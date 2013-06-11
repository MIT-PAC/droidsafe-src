package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IllegalThreadStateException extends IllegalArgumentException {
    private static final long serialVersionUID = -7626246362397460174L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.186 -0400", hash_original_method = "5791A934E1D6D40F1C86D615B455C03B", hash_generated_method = "C77B44F0C61DDD87E3C5EF337FDFD28C")
    @DSModeled(DSC.SAFE)
    public IllegalThreadStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.197 -0400", hash_original_method = "3CBEBFECA4223415F4314CC0B87A4ECE", hash_generated_method = "9472F308F6817FB0BF7CF963AC6B60EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalThreadStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


