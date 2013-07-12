package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SocketUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.318 -0400", hash_original_method = "2758868180F6D2D4DEA6AC671B8BE637", hash_generated_method = "1ACFD737D96D84F27254E1B7C6AF47DE")
    private  SocketUtils() {
        
    }

    
        @DSModeled(DSC.SPEC)
    public static void setCreated(Socket s) {
        s.isCreated = true;
    }

    
}

