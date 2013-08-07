package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;




public class SocketUtils {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.537 -0400", hash_original_method = "2758868180F6D2D4DEA6AC671B8BE637", hash_generated_method = "1ACFD737D96D84F27254E1B7C6AF47DE")
    private  SocketUtils() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static void setCreated(Socket s) {
        s.isCreated = true;
    }

    
}

