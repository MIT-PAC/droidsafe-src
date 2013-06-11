package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class UTFDataFormatException extends IOException {
    private static final long serialVersionUID = 420743449228280612L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.712 -0400", hash_original_method = "3EA36195962A4C2ABB96F147659089B7", hash_generated_method = "5E2EA4058ECBB133F44C3E7D0D3218C5")
    @DSModeled(DSC.SAFE)
    public UTFDataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.712 -0400", hash_original_method = "40942835B5B465ACA9ABF07953FCB6E7", hash_generated_method = "8F0A4068234C9FF1DD66AEF254D14BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UTFDataFormatException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


