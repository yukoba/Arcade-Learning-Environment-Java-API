// Generated by jextract

package jp.yukoba.ale;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$2 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$2() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "ale_destroy",
        constants$0.const$0
    );
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_LONG
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "ale_getString",
        constants$2.const$1
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "ale_getInt",
        constants$2.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_BOOLEAN,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "ale_getBool",
        constants$2.const$5
    );
}


