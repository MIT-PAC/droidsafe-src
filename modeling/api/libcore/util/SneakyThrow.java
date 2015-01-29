package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class SneakyThrow {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.037 -0500", hash_original_method = "3C10A19581B59CA3FAE35651327DA950", hash_generated_method = "76F0A9ECD0E10BAA0B382425285D04A9")
    
public static void sneakyThrow(Throwable t) {
        SneakyThrow.<Error>sneakyThrow2(t);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.034 -0500", hash_original_method = "F6943C77D63FE9259DE7FD0A0682E999", hash_generated_method = "ED113E537CB3611A4CFCD38AD08B02C1")
    
private SneakyThrow() {}
    
}

