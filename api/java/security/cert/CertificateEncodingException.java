package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class CertificateEncodingException extends CertificateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.398 -0500", hash_original_field = "B9B4CD01134336AA96560290A6E0D00B", hash_generated_field = "283D9FEE55079801531E0A45A4848707")


    private static final long serialVersionUID = 6219492851589449162L;

    /**
     * Creates a new {@code CertificateEncodingException} with the specified
     * message.
     *
     * @param msg
     *            The detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.401 -0500", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "596B3FCDB77705DCD01C5AEC0CB7CE12")
    
public CertificateEncodingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateEncodingException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.403 -0500", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "1FEEFACAAD9DCE3EF3F4C9F5BD996270")
    
public CertificateEncodingException() {
    }

    /**
     * Creates a new {@code CertificateEncodingException} with the specified
     * message and cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the cause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.406 -0500", hash_original_method = "E243161DE39D22E4790DBE91A7D0CBA3", hash_generated_method = "F1FEAF5A8E5F82B35E5765927094CA87")
    
public CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code CertificateEncodingException} with the specified
     * cause.
     *
     * @param cause
     *            the cause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.409 -0500", hash_original_method = "A32D2B579DCEB6262CC5C2D0257C91FD", hash_generated_method = "2117EE1C144FF7029E651AFF0AE8F365")
    
public CertificateEncodingException(Throwable cause) {
        super(cause);
    }
}

