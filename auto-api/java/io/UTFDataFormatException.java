package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UTFDataFormatException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.351 -0400", hash_original_method = "3EA36195962A4C2ABB96F147659089B7", hash_generated_method = "4F6021DB90D836B7A73C5500EB8CC7F8")
    @DSModeled(DSC.SAFE)
    public UTFDataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.351 -0400", hash_original_method = "40942835B5B465ACA9ABF07953FCB6E7", hash_generated_method = "68A5179446A5A9AC116391175633BBE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UTFDataFormatException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 420743449228280612L;
}

