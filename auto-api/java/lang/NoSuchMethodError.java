package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchMethodError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.895 -0400", hash_original_method = "80EBD198F916FEE348D274437586B5BC", hash_generated_method = "47FDE86C35A2EDC474B42FD4951F4771")
    @DSModeled(DSC.SAFE)
    public NoSuchMethodError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.895 -0400", hash_original_method = "4CC31AAD9CD08413E75D886E5A5CF2D3", hash_generated_method = "F86EC1DD3E899214CFA621D7EBC5A91F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchMethodError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3765521442372831335L;
}

