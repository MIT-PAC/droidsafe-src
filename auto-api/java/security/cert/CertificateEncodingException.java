package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CertificateEncodingException extends CertificateException {
    private static final long serialVersionUID = 6219492851589449162L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.594 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "9642185B0E4817F2A9B90EAEB2F44066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.594 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C75A94409FABB5E4BF0EA2A54284C41A")
    @DSModeled(DSC.SAFE)
    public CertificateEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.594 -0400", hash_original_method = "E243161DE39D22E4790DBE91A7D0CBA3", hash_generated_method = "C565BB8C3A5E2EB1D91E748D26AB3CB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.594 -0400", hash_original_method = "A32D2B579DCEB6262CC5C2D0257C91FD", hash_generated_method = "7E332F207505E3513346C968D80AD2BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateEncodingException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


