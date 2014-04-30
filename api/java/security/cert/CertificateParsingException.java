package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CertificateParsingException extends CertificateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.113 -0500", hash_original_field = "E4DA89334FFCB7B948A51D02C208306F", hash_generated_field = "9FB65A3F56B8D84968FA0A283A775A80")

    private static final long serialVersionUID = -7989222416793322029L;

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.115 -0500", hash_original_method = "52C1CA38DD038BC33FD4ADF2F8CE17BE", hash_generated_method = "A245E685ED65819D19415A8A5D1C01EC")
    
public CertificateParsingException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateParsingException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.118 -0500", hash_original_method = "8DA8B534EA167A5C50442E9F25486020", hash_generated_method = "7AFB4234C7D14EE73B98DB173DF0ADEA")
    
public CertificateParsingException() {
    }

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * message and cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the exception's source.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.120 -0500", hash_original_method = "7DFD64EF17D16B3CA905ED3004EA7773", hash_generated_method = "53E21438479EB7D5BF3DA52BEEA6C314")
    
public CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code CertificateParsingException} with the specified
     * cause.
     *
     * @param cause
     *            the exception's source.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.123 -0500", hash_original_method = "655AB0A50E551680E7DF5C232C5D908E", hash_generated_method = "06D11561C966AC7F165D89B92CFF2346")
    
public CertificateParsingException(Throwable cause) {
        super(cause);
    }
}

