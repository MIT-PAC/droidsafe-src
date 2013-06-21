package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class KeyChainException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.146 -0400", hash_original_method = "07A073FF0F51A72901A8B28E6AC903AE", hash_generated_method = "23E3F1B8D4BA1176F337353CEEB0458D")
    @DSModeled(DSC.SAFE)
    public KeyChainException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.147 -0400", hash_original_method = "0A58DB61FCFCEABE9058FC3092E58BF3", hash_generated_method = "75A1E75AD93617DEDAA128BA34DFC972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyChainException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.147 -0400", hash_original_method = "3E8EDDC6FC8719784A3F6D961EFA0DBF", hash_generated_method = "0D34E96143039EC555ED4E20F8F5F10A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyChainException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.147 -0400", hash_original_method = "8CC23A5EEF616E11C5C7CDC0612B705F", hash_generated_method = "56D9264EFD5A407C261875291A41EA9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyChainException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

