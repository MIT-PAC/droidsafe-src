package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IndexOutOfBoundsException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.746 -0400", hash_original_method = "D4CD8ADEE84F45A3C2932250B7EFAD5E", hash_generated_method = "21F705B9E81BD76361B6BB1EE50EEEC3")
    @DSModeled(DSC.SAFE)
    public IndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.747 -0400", hash_original_method = "43F047B4ECB1C9194E62BC668739E967", hash_generated_method = "2986522395E4F53CAF0A5B0AE88574FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 234122996006267687L;
}

