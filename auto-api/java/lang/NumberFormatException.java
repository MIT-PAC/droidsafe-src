package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class NumberFormatException extends IllegalArgumentException {
    private static final long serialVersionUID = -2848938806368998894L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.389 -0400", hash_original_method = "5EB9584C9C40374DC4817FFEDC3C2AF2", hash_generated_method = "0CB536869F4EFA02E32EA6F09BFA9ECF")
    @DSModeled(DSC.SAFE)
    public NumberFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.390 -0400", hash_original_method = "E8CAE1FBBA27FF2762363375A55E9E2D", hash_generated_method = "F482BA614CBFBB5F662EDA805E7F6A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NumberFormatException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


