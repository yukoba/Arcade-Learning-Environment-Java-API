// Generated by jextract

package jp.yukoba.ale;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$1 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$1() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "__report_gsfailure",
        constants$0.const$4
    );
    static final VarHandle const$1 = JAVA_LONG.varHandle();
    static final MemorySegment const$2 = RuntimeHelper.lookupGlobalVariable("__security_cookie", JAVA_LONG);
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(RuntimeHelper.POINTER);
    static final MethodHandle const$4 = RuntimeHelper.downcallHandleVariadic(
        "ale_create",
        constants$1.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        JAVA_BOOLEAN
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "ale_create_with_display",
        constants$1.const$5
    );
}


