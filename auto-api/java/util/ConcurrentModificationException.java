package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ConcurrentModificationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.753 -0400", hash_original_method = "5F5AEF59023EF0CE03A16FBB12617DB7", hash_generated_method = "79688BEA5D6B303CB294241AA0949D8E")
    @DSModeled(DSC.SAFE)
    public ConcurrentModificationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.753 -0400", hash_original_method = "106C24DD3D2A07AA8584E42740C7683A", hash_generated_method = "ABC4C65B28495AF1AB4F22000DE51D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.753 -0400", hash_original_method = "2C18D4011661B4B4C3C2AF76F80D71D0", hash_generated_method = "7A47CE1595676510E5E5203298D3892C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.753 -0400", hash_original_method = "1483D8E8224DDF6AD31766681C65E484", hash_generated_method = "594B23E9830661DDB4F9E4F134EAE638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3666751008965953603L;
}

