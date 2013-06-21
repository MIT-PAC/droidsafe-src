package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends RuntimeException {
    public String response;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.355 -0400", hash_original_method = "E43EF8DD9693C1DC19D1ACB3B5C49985", hash_generated_method = "8E73AAF6C0DD88B97DBEE8479A8E26A4")
    @DSModeled(DSC.SAFE)
     ParseException(String response) {
        dsTaint.addTaint(response);
        // ---------- Original Method ----------
        //this.response = response;
    }

    
}

