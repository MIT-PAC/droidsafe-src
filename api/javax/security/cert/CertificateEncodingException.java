package javax.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CertificateEncodingException extends CertificateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.669 -0500", hash_original_field = "5766AFD65368213F15A5D0E7A6E04DFD", hash_generated_field = "E640B75D9A9B871CE2BE02F61BBEA9DB")

    private static final long serialVersionUID = -8187642723048403470L;

    /**
     * Creates a new {@code CertificateEncodingException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.671 -0500", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "596B3FCDB77705DCD01C5AEC0CB7CE12")
    
public CertificateEncodingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateEncodingException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.674 -0500", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "1FEEFACAAD9DCE3EF3F4C9F5BD996270")
    
public CertificateEncodingException() {
    }
}

