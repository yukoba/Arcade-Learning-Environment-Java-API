// Generated by jextract

package jp.yukoba.ale;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$4 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$4() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_BOOLEAN
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "ale_setBool",
        constants$4.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_FLOAT
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "ale_setFloat",
        constants$4.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "ale_loadROM",
        constants$2.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_FLOAT,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "ale_act",
        constants$4.const$5
    );
}


