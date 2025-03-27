package jp.yukoba.ale;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Random;

import static jp.yukoba.ale.ale_c_interface_h.*;

@SuppressWarnings("preview")
public class Test {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: mvn exec:java -Dexec.mainClass=jp.yukoba.ale.Test -Dexec.args=<rom_file> -Dexec.classpathScope=test");
            return;
        }

        System.loadLibrary("ale");

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment rom_path = arena.allocateUtf8String(args[0]);

            // Check if ROM is supported
            MemorySegment md5_buffer = arena.allocate(33);
            int supported = ale_isSupportedROM(rom_path, md5_buffer, md5_buffer.byteSize());
            if (supported == 1) {
                System.out.printf("ROM is supported. MD5: %s\n", md5_buffer);
            } else if (supported == 0) {
                System.out.println("ROM is not officially supported by ALE.");
                // Proceed anyway? Or exit?
            } else {
                System.err.println("Error checking ROM support.");
                // return; // Decide if this is fatal
            }

            // Create ALE instance
            MemorySegment ale = ale_create();
            if (ale.address() == 0) {
                System.err.println("Failed to create ALE instance.");
                return;
            }

            // Set some options (optional)
            ale_setBool(ale, arena.allocateUtf8String("display_screen"), true);
            ale_setFloat(ale, arena.allocateUtf8String("repeat_action_probability"), 0.0f); // Deterministic

            // Load the ROM
            if (ale_loadROM(ale, rom_path) != 0) {
                System.err.printf("Failed to load ROM: %s\n", args[0]);
                ale_destroy(ale);
                return;
            }

            // Get legal actions
            int num_actions = ale_getLegalActionSet(ale, MemorySegment.NULL, 0); // Get count first
            if (num_actions < 0) {
                System.err.println("Failed to get action set size.");
                ale_destroy(ale);
                return;
            }
            MemorySegment legal_actions = arena.allocate(num_actions * Action.byteSize());
            if (legal_actions.address() == 0) {
                System.err.println("Failed to allocate memory for actions.");
                ale_destroy(ale);
                return;
            }
            if (ale_getLegalActionSet(ale, legal_actions, num_actions) != num_actions) {
                System.err.println("Failed to get action set.");
                ale_destroy(ale);
                return;
            }

            System.out.printf("Legal actions (%d): ", num_actions);
            for (int i = 0; i < num_actions; ++i) {
                System.out.printf("%d ", legal_actions.getAtIndex(Action, i));
            }
            System.out.println();

            // Simple game loop: perform 100 random actions
            Random rand = new Random();
            float total_reward = 0f;
            for (int i = 0; i < 100; ++i) {
                if (ale_game_over(ale, true)) {
                    System.out.printf("Game over at step %d\n", i);
                    ale_reset_game(ale);
                }

                // Choose a random legal action
                int action = legal_actions.getAtIndex(Action, rand.nextInt(num_actions));
                float reward = ale_act(ale, action);
                total_reward += reward;

                // Optional: Get screen data (example - requires large buffer)
            /*
            int width = ale_getScreenWidth(ale);
            int height = ale_getScreenHeight(ale);
            if (width > 0 && height > 0) {
                size_t rgb_size = (size_t)width * height * 3;
                unsigned char* screen_buffer = (unsigned char*)malloc(rgb_size);
                if (screen_buffer) {
                    if (ale_getScreenRGB(ale, screen_buffer, rgb_size) > 0) {
                        // Process screen_buffer...
                    }
                    free(screen_buffer);
                }
            }
            */
            }

            System.out.printf("Total reward over 100 steps: %f\n", total_reward);

            // Clean up
            ale_destroy(ale);
        }
    }
}
