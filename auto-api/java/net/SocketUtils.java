package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SocketUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.140 -0400", hash_original_method = "2758868180F6D2D4DEA6AC671B8BE637", hash_generated_method = "1ACFD737D96D84F27254E1B7C6AF47DE")
    @DSModeled(DSC.SAFE)
    private SocketUtils() {
        // ---------- Original Method ----------
    }

    
        public static void setCreated(Socket s) {
        s.isCreated = true;
    }

    
}

