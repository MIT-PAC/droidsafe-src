package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SignatureException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.599 -0400", hash_original_method = "1A64E23BD4BC60E25E0621B283BA1364", hash_generated_method = "B0C9586B5AB8432239D2FC777B1DB1EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.599 -0400", hash_original_method = "FC81C3C47A9C38543897BA92BDE9ED63", hash_generated_method = "9B6C915C21DA34F6FA6FCE12975D4CE6")
    @DSModeled(DSC.SAFE)
    public SignatureException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.599 -0400", hash_original_method = "016680A93C61AAA9E83AF67D8C91F93A", hash_generated_method = "3BBA99FF1272B1D0A8D81326C2B76414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.599 -0400", hash_original_method = "3352DA5C6676595EED2C0C966A19B61C", hash_generated_method = "C1662653B45B9388A437AAF7DACBEA57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignatureException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 7509989324975124438L;
}

