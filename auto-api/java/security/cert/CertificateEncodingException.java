package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateEncodingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.632 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "8DCDD19FE87A4AA07DE99F8116B6CE48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.633 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C2D35BC07014BC3018532FA9B69AF7DE")
    @DSModeled(DSC.SAFE)
    public CertificateEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.633 -0400", hash_original_method = "E243161DE39D22E4790DBE91A7D0CBA3", hash_generated_method = "8A4828EBA029E464F15ECB66CC316F37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.633 -0400", hash_original_method = "A32D2B579DCEB6262CC5C2D0257C91FD", hash_generated_method = "BAA9D791794075CB4C4C7E9644C29559")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6219492851589449162L;
}

