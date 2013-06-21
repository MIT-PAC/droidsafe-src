package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ClassCastException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.635 -0400", hash_original_method = "54A88184B9052FBFDEDAE165A6A4F85C", hash_generated_method = "BCB3275847821F22276E01938C0B7F6E")
    @DSModeled(DSC.SAFE)
    public ClassCastException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.635 -0400", hash_original_method = "9AC0043646A15326C62DB46FBF4E3D5F", hash_generated_method = "1A3C018D2A1C9462ACC07CECE62A09D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClassCastException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -9223365651070458532L;
}

