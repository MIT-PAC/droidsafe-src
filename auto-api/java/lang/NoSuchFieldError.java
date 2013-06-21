package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchFieldError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.892 -0400", hash_original_method = "F8D799539E9A974C8BB35DC17F7C342D", hash_generated_method = "F310D0DF0C26994229A44A3EEEF18445")
    @DSModeled(DSC.SAFE)
    public NoSuchFieldError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.893 -0400", hash_original_method = "18AA8F00FBF3130F84A1236717EEB4A7", hash_generated_method = "809142BC6195117F11816EB3DAF088BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchFieldError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -3456430195886129035L;
}

