package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class UnknownHostException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.442 -0400", hash_original_method = "63F4AB968FFD132B70B6AA5D00C05B79", hash_generated_method = "F64B44015C6B2F668B99417C6CF8EE19")
    @DSModeled(DSC.SAFE)
    public UnknownHostException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.443 -0400", hash_original_method = "F0919D76ED897260C338F2959B098923", hash_generated_method = "66022E8E6631E76AD16046F4461658F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownHostException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4639126076052875403L;
}

