package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class SneakyThrow {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "F6943C77D63FE9259DE7FD0A0682E999", hash_generated_method = "6CA8A52950698FF80B69DF243DFD51D0")
    @DSModeled(DSC.SAFE)
    private SneakyThrow() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "3C10A19581B59CA3FAE35651327DA950", hash_generated_method = "76F0A9ECD0E10BAA0B382425285D04A9")
    public static void sneakyThrow(Throwable t) {
        SneakyThrow.<Error>sneakyThrow2(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.540 -0400", hash_original_method = "25E754478B48CAAA160D695E4B833220", hash_generated_method = "B58C71E1827DB3F2E4B93982C87723AA")
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }

    
}


