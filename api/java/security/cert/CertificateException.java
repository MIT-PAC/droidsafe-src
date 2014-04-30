package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;

public class CertificateException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.069 -0500", hash_original_field = "63788574FD9B1189E170F3022130F14D", hash_generated_field = "EF8006469A2B3A811310EC8372238772")

    private static final long serialVersionUID = 3192535253797119798L;

    /**
     * Creates a new {@code CertificateException} with the specified message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.071 -0500", hash_original_method = "B94F5C9247EB09D2A3B5F93CD6C3CCDF", hash_generated_method = "ACB6CE514AE47C5043CA9C45091D2E06")
    
public CertificateException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.074 -0500", hash_original_method = "FF458EF7F95F357456B3AFD0871B002E", hash_generated_method = "9153284B5E07FB649C1E073E2207C7A4")
    
public CertificateException() {
    }

    /**
     * Creates a new {@code CertificateException} with the specified message and
     * cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the cause.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.077 -0500", hash_original_method = "3E71F41626D2D81134C9C58E70BA9CC7", hash_generated_method = "7C9AD378A56B3487106038E3E42DF9E1")
    
public CertificateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code CertificateException} with the specified cause.
     *
     * @param cause
     *            the cause
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.080 -0500", hash_original_method = "E2FE45CCAA1ECBB72042149ECF15B312", hash_generated_method = "054A251C5867A95C77FA7375BA5BBCCC")
    
public CertificateException(Throwable cause) {
        super(cause);
    }
}

