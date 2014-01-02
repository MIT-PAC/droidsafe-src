package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class SecurityException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.393 -0500", hash_original_field = "66900AFC64D7C18F38BA74DB4550B3FA", hash_generated_field = "713BC78E703E562CFBF2DBB2AB4EDF1A")


    private static final long serialVersionUID = 6878364983674394167L;

    /**
     * Constructs a new {@code SecurityException} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.396 -0500", hash_original_method = "0D8A79337436926212C4E8DACFE6A955", hash_generated_method = "C7F889834C9E7C4C4B72A99F9A91AC6B")
    
public SecurityException() {
    }

    /**
     * Constructs a new {@code SecurityException} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.399 -0500", hash_original_method = "35201AC9E2F0540A3FCA08DB4F71F2A3", hash_generated_method = "F9010C592D66BE68816BE6B0C626B107")
    
public SecurityException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code SecurityException} with the current stack trace,
     * the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.402 -0500", hash_original_method = "6D3B8DD6DA516F6B2B4EBB83E8379AAA", hash_generated_method = "6D5E26C532D69214D3DD0DA43C477B77")
    
public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code SecurityException} with the current stack trace
     * and the specified cause.
     *
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.405 -0500", hash_original_method = "B0CE861A38AC7D57FFFB507001C97872", hash_generated_method = "EE785A04AC176438B220EB6E7057547B")
    
public SecurityException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}

