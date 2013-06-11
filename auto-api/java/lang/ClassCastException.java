package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ClassCastException extends RuntimeException {
    private static final long serialVersionUID = -9223365651070458532L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.067 -0400", hash_original_method = "54A88184B9052FBFDEDAE165A6A4F85C", hash_generated_method = "D7AE170023561F01D8CC5F349FEADC10")
    @DSModeled(DSC.SAFE)
    public ClassCastException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.070 -0400", hash_original_method = "9AC0043646A15326C62DB46FBF4E3D5F", hash_generated_method = "C4872EE6089D5DEA0695B2544C11F287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassCastException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


