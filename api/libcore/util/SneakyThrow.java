package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public final class SneakyThrow {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.651 -0500", hash_original_method = "3C10A19581B59CA3FAE35651327DA950", hash_generated_method = "76F0A9ECD0E10BAA0B382425285D04A9")
    public static void sneakyThrow(Throwable t) {
        SneakyThrow.<Error>sneakyThrow2(t);
    }

    
    @DSModeled(DSC.BAN)
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.650 -0500", hash_original_method = "F6943C77D63FE9259DE7FD0A0682E999", hash_generated_method = "ED113E537CB3611A4CFCD38AD08B02C1")
    private SneakyThrow() {}

    
}

