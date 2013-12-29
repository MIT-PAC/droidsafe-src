package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class InvalidAlgorithmParameterException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:14.079 -0500", hash_original_field = "4A1F897BE08446645911F0327B941CEA", hash_generated_field = "860F70BF4B332299464A61D7F7CDE3BE")

    private static final long serialVersionUID = 2864672297499471472L;

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}
     * with the given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:14.080 -0500", hash_original_method = "8764EFDBF443E087329639C5F03FBF33", hash_generated_method = "39F090F307D04B07F933D3B779FE2DFD")
    public InvalidAlgorithmParameterException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:14.081 -0500", hash_original_method = "6854FBA50B4775039731A07DEA1BCECF", hash_generated_method = "39BD5A94C30671B897C727ADBCEDD9C9")
    public InvalidAlgorithmParameterException() {
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:14.082 -0500", hash_original_method = "8C1684940E5C6F60C794DE0A4727DA86", hash_generated_method = "DCCEDA396C02F815988B8383EFADDCB6")
    public InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code InvalidAlgorithmParameterException}
     * with the cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:14.083 -0500", hash_original_method = "EFB1E846A63455E1688ABC4BA0B50914", hash_generated_method = "709419BDD9594B7652B467D9F2F0C2A5")
    public InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
    }
}

