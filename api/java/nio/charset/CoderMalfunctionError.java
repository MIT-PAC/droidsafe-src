package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CoderMalfunctionError extends Error {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.851 -0400", hash_original_method = "883FFC59265DE3B21E7C8AE56E57641B", hash_generated_method = "2133BCAD975CC26F38D1A082BEC9E5A3")
    public  CoderMalfunctionError(Exception ex) {
        super(ex);
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.851 -0400", hash_original_field = "1A335B9C4DBEB9C7F7E507913845A35B", hash_generated_field = "113DCE2BB9203B33E699C7CF2E28F6A0")

    private static final long serialVersionUID = -1151412348057794301L;
}

