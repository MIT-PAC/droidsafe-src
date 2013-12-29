package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class InternalError extends VirtualMachineError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.262 -0500", hash_original_field = "B512AB1E07A78E16312CA58490B4C4F4", hash_generated_field = "DAD8FB96BBB0A062B3DA55A68D183E86")


    private static final long serialVersionUID = -9062593416125562365L;

    /**
     * Constructs a new {@code InternalError} that includes the current stack
     * trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.263 -0500", hash_original_method = "18A11DFE954AAC7F3401D9A18E98EAA5", hash_generated_method = "CAE3B5ACBC0F48D1AC89C2F70A7D594C")
    public InternalError() {
    }

    /**
     * Constructs a new {@code InternalError} with the current stack trace and
     * the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.263 -0500", hash_original_method = "11A7F61F65B1BF556316C3B357308A87", hash_generated_method = "943A050F6994FC2E57B0120B909CF76D")
    public InternalError(String detailMessage) {
        super(detailMessage);
    }
}

