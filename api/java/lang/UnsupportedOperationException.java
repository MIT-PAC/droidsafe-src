package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class UnsupportedOperationException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.773 -0500", hash_original_field = "8DD97B7175717F620E947385BBAB6F28", hash_generated_field = "98371D8BFFC25B03165EF5ECBBCB29E2")


    private static final long serialVersionUID = -1242599979055084673L;

    /**
     * Constructs a new {@code UnsupportedOperationException} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.776 -0500", hash_original_method = "7F6DB5D5ED9D38F1F537736368EB0450", hash_generated_method = "0E0DB9023EDADF61F49201327AC8AD26")
    
public UnsupportedOperationException() {
    }

    /**
     * Constructs a new {@code UnsupportedOperationException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.779 -0500", hash_original_method = "D8E5E0CB144C04E81C4A0C2F4745C381", hash_generated_method = "524F01D45A2ED48F724445E4C12C424F")
    
public UnsupportedOperationException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code UnsupportedOperationException} with the current
     * stack trace, the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.781 -0500", hash_original_method = "66AB41D7AD796BF9B33430AF2C434F38", hash_generated_method = "92E2257F8052820444C34D6455F4C1F7")
    
public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code UnsupportedOperationException} with the current
     * stack trace and the specified cause.
     *
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.784 -0500", hash_original_method = "47724B2BD03E5789FE4A564680099229", hash_generated_method = "EDC641BC2446FD23BB14BBE931583F71")
    
public UnsupportedOperationException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}

