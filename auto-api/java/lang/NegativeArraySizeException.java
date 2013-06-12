package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class NegativeArraySizeException extends RuntimeException {
    private static final long serialVersionUID = -8960118058596991861L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.298 -0400", hash_original_method = "D33CED1C2CC51E1A27A91F713183A870", hash_generated_method = "3D3F093798F39CB872EB2BCCC85AF8B2")
    @DSModeled(DSC.SAFE)
    public NegativeArraySizeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.305 -0400", hash_original_method = "8AAF2E9F34B5796377EDFC62134DFEB6", hash_generated_method = "A55AD3A92FF378E5EB37258CE912E956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NegativeArraySizeException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


