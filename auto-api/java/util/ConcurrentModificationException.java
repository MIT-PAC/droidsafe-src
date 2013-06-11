package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ConcurrentModificationException extends RuntimeException {
    private static final long serialVersionUID = -3666751008965953603L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.050 -0400", hash_original_method = "5F5AEF59023EF0CE03A16FBB12617DB7", hash_generated_method = "79C16D5A4AE161895521EE72BFB7B1D7")
    @DSModeled(DSC.SAFE)
    public ConcurrentModificationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.050 -0400", hash_original_method = "106C24DD3D2A07AA8584E42740C7683A", hash_generated_method = "92BEFC1A995D85E0C5FD170CF15CA03C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.050 -0400", hash_original_method = "2C18D4011661B4B4C3C2AF76F80D71D0", hash_generated_method = "E177DF55D09923AAFBCB3E03BAE33D47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.050 -0400", hash_original_method = "1483D8E8224DDF6AD31766681C65E484", hash_generated_method = "9B0B69D21C1FE5F12194E807259E4108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentModificationException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


