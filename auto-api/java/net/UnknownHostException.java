package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class UnknownHostException extends IOException {
    private static final long serialVersionUID = -4639126076052875403L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "63F4AB968FFD132B70B6AA5D00C05B79", hash_generated_method = "C5141D1765F29D7A47D8D9B816AC71CD")
    @DSModeled(DSC.SAFE)
    public UnknownHostException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.301 -0400", hash_original_method = "F0919D76ED897260C338F2959B098923", hash_generated_method = "750CB534E3BAA3AD299541631F9D7C2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnknownHostException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


