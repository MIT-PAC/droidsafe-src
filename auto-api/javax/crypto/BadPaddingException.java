package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class BadPaddingException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.904 -0400", hash_original_method = "09CEF21DE4AE127050E57B3AC6E4EB54", hash_generated_method = "BBBAC30F00E33DD64CDC9846BCA9045D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BadPaddingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.905 -0400", hash_original_method = "93AC86C418E78DB07C3A1E0229C09FBC", hash_generated_method = "BEC10E384823F5A0EB6660587E005727")
    @DSModeled(DSC.SAFE)
    public BadPaddingException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5315033893984728443L;
}

