package junit.runner;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Version {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.460 -0400", hash_original_method = "783F8C18B2BD3982CB7AF1593B9B73BB", hash_generated_method = "BE0416AE7F45B6358A4177A47D1F39CB")
    private  Version() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    public static String id() {
        return "3.8.1";
    }

    
}

