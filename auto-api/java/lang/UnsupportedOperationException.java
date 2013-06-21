package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedOperationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.665 -0400", hash_original_method = "7F6DB5D5ED9D38F1F537736368EB0450", hash_generated_method = "A99A19AC28CD29E8B1E65D945AA0DFDA")
    @DSModeled(DSC.SAFE)
    public UnsupportedOperationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.666 -0400", hash_original_method = "D8E5E0CB144C04E81C4A0C2F4745C381", hash_generated_method = "94FD975A77BD9756677AC76C90380485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.666 -0400", hash_original_method = "66AB41D7AD796BF9B33430AF2C434F38", hash_generated_method = "3F6FB781912E18EEB2AD2796BF391B01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.666 -0400", hash_original_method = "47724B2BD03E5789FE4A564680099229", hash_generated_method = "7003201B4C78F53F47695411DDCD646B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1242599979055084673L;
}

