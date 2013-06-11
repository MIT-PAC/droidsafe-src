package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ArithmeticException extends RuntimeException {
    private static final long serialVersionUID = 2256477558314496007L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.500 -0400", hash_original_method = "24115F2AC5B4BFA51305F479377E801A", hash_generated_method = "16F518FF568C534220FFFB8AFE100E66")
    @DSModeled(DSC.SAFE)
    public ArithmeticException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:44.503 -0400", hash_original_method = "FAC340A34D2F62BBB9E823C2AE5CBB24", hash_generated_method = "BC577836BF89F86CCDDE696F75E68DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArithmeticException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


