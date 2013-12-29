package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class GeneralSecurityException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.220 -0500", hash_original_field = "405DD9FBA96A0927742ABBB449405C20", hash_generated_field = "F3DAE821DA81007CC901C8C9F2AFD853")


    private static final long serialVersionUID = 894798122053539237L;

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.221 -0500", hash_original_method = "DF58B5CAF337DE33E44F54F447F733AD", hash_generated_method = "E776BAAF24977B6ADD7C2CEE90496CE9")
    public GeneralSecurityException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.222 -0500", hash_original_method = "F9327F749082DE23B0685F6DD902B858", hash_generated_method = "DEFCDA2D930C1A41C786D9F4C49800BB")
    public GeneralSecurityException() {
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.223 -0500", hash_original_method = "577694F56592C068A46C118A7E1B2604", hash_generated_method = "63A4DF5B3964856330EFF449BF86AAA0")
    public GeneralSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code GeneralSecurityException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.224 -0500", hash_original_method = "44918F9A2CF16E0F2387B03C3A16E529", hash_generated_method = "AA74B500A81C814BDD18224634889196")
    public GeneralSecurityException(Throwable cause) {
        super(cause);
    }
}

