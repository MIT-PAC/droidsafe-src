package libcore.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SneakyThrow {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.461 -0400", hash_original_method = "F6943C77D63FE9259DE7FD0A0682E999", hash_generated_method = "19FDB13A46BEE2B1007D50142F524148")
    private  SneakyThrow() {
        // ---------- Original Method ----------
    }

    
    public static void sneakyThrow(Throwable t) {
        SneakyThrow.<Error>sneakyThrow2(t);
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }

    
}

