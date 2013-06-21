package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AssertionFailedError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.409 -0400", hash_original_method = "71F257E86E7BC4683CC6DEDD211B2B80", hash_generated_method = "CA362C55EDDF9D2AF60C14AF4873ACCA")
    @DSModeled(DSC.SAFE)
    public AssertionFailedError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.409 -0400", hash_original_method = "B8BE23DBCDF9422A0C250D37CF195D42", hash_generated_method = "C4790E13CD80164399416F619CE8E25F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionFailedError(String message) {
        super (message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

