package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class NoSuchFieldException extends Exception {
    private static final long serialVersionUID = -6143714805279938260L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.311 -0400", hash_original_method = "C9B6E52CB5F5184DC84559DF357B6964", hash_generated_method = "E52797C8DAB34C12DAAF6AE202F2DA5F")
    @DSModeled(DSC.SAFE)
    public NoSuchFieldException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.314 -0400", hash_original_method = "3003F78B5EA782042D23C70E768D6CA2", hash_generated_method = "B1AB95363673F7BFBD15BDE2F2FED4BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchFieldException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


