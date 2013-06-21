package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalThreadStateException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.745 -0400", hash_original_method = "5791A934E1D6D40F1C86D615B455C03B", hash_generated_method = "298A639F0F6CE69715D3CB67F1B0216A")
    @DSModeled(DSC.SAFE)
    public IllegalThreadStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.745 -0400", hash_original_method = "3CBEBFECA4223415F4314CC0B87A4ECE", hash_generated_method = "D77E86B4A60AB615609E8D25A3CA94D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalThreadStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7626246362397460174L;
}

