package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class KeyManagementException extends KeyException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.289 -0500", hash_original_field = "5DA0FDFCFAEF68F94D1E0975944FA356", hash_generated_field = "89D5F685E2DD3F83FC2D5B9AF7510AA0")


    private static final long serialVersionUID = 947674216157062695L;

    /**
     * Constructs a new instance of {@code KeyManagementException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.290 -0500", hash_original_method = "C1C9437036F95280A4529C1CBB03A96B", hash_generated_method = "5C411873DF962B2B8665B98F5C37F85D")
    public KeyManagementException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code KeyManagementException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.291 -0500", hash_original_method = "DE152C48BD78964F95EBFDDBEC69C54C", hash_generated_method = "D419DAACF538AAFDCEEA52FBEAAE46D0")
    public KeyManagementException() {
    }

    /**
     * Constructs a new instance of {@code KeyManagementException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.292 -0500", hash_original_method = "81AAB74590EA3C5396EE9D20F7BBE3DD", hash_generated_method = "8E6E8085F5DFB6B67B4BCD2515126F68")
    public KeyManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code KeyManagementException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.293 -0500", hash_original_method = "E6EDC076BA6A403E961006D69F90ADCE", hash_generated_method = "65AE01DE9E61249AAA650A61466C6D12")
    public KeyManagementException(Throwable cause) {
        super(cause);
    }
}

