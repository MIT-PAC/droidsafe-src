package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;




public class SSLException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.787 -0500", hash_original_field = "EF8FC78292841774D3D1555DB7B301C1", hash_generated_field = "E1A5658E80377BA2C7164C30C5149FA7")

    private static final long serialVersionUID = 4511006460650708967L;

    /**
     * Creates a new {@code SSLException} with the specified reason.
     *
     * @param reason
     *            the reason for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.791 -0500", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "1E377BFA8712A67ED08005B350F50442")
    
public SSLException(String reason) {
        super(reason);
    }

    /**
     * Creates a new {@code SSLException} with the specified message and cause.
     *
     * @param message
     *            the detail message for the exception.
     * @param cause
     *            the cause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.793 -0500", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "62E00E815D798736CF38F05BC33176D1")
    
public SSLException(String message, Throwable cause) {
        super(message);
        super.initCause(cause);
    }

    /**
     * Creates a new {@code SSLException} with the specified cause.
     *
     * @param cause
     *            the cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.796 -0500", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "CD65939416DAD8F4A12A52BBF0391ED0")
    
public SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        super.initCause(cause);
    }
}

