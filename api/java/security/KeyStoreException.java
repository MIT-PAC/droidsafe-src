package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class KeyStoreException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.553 -0500", hash_original_field = "C748574F6277BF6338B3D26F2F153367", hash_generated_field = "9E8817162139C00CFA46CC9F751DAE7C")


    private static final long serialVersionUID = -1119353179322377262L;

    /**
     * Constructs a new instance of {@code KeyStoreException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.556 -0500", hash_original_method = "7369A8C363020ACD6ED9F21AE7042369", hash_generated_method = "2828495065BA12064DBB2F728B54840D")
    
public KeyStoreException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code KeyStoreException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.559 -0500", hash_original_method = "A81CEEB8E106BDB258202C5859E57972", hash_generated_method = "123253F9C9A8FF83BD2726BD026E7D06")
    
public KeyStoreException() {
    }

    /**
     * Constructs a new instance of {@code KeyStoreException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.562 -0500", hash_original_method = "B8FD54DFEAD6E5AF89E6549D49EE9467", hash_generated_method = "7A872E5FBC17D55A3E0F7EC923BBE712")
    
public KeyStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code KeyStoreException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.565 -0500", hash_original_method = "4819C5194870119A368744981D172EEA", hash_generated_method = "23F369BCAF3DF43A9F220A6E89B21519")
    
public KeyStoreException(Throwable cause) {
        super(cause);
    }
}

