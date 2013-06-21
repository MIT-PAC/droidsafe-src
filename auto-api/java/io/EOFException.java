package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class EOFException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.485 -0400", hash_original_method = "1CCCAA76135EE86F6894FC590C0C686A", hash_generated_method = "7B880AD42DEB094CD5B685C1C5FFAC26")
    @DSModeled(DSC.SAFE)
    public EOFException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.485 -0400", hash_original_method = "1DF3A1A90A52071351DFC31CC87C4540", hash_generated_method = "11D92919CFACFE5DEFB1346F313D77F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EOFException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6433858223774886977L;
}

