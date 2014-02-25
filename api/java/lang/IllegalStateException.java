package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IllegalStateException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.081 -0500", hash_original_field = "2285409AA88F4380A02FA101AFCA4AB4", hash_generated_field = "DCC0988018DD2FB77D529B43591FE9E8")

    private static final long serialVersionUID = -1848914673093119416L;

    /**
     * Constructs a new {@code IllegalStateException} that includes the current
     * stack trace.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.083 -0500", hash_original_method = "A3FE636ADA4040CA4955BB4251C76DAB", hash_generated_method = "ADF160625FB5CE675133C54A7E3B099C")
    
public IllegalStateException() {
    }

    /**
     * Constructs a new {@code IllegalStateException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.086 -0500", hash_original_method = "F14466412D9BB118D44B7BD1FD4B4021", hash_generated_method = "9615D7436FD893BFC025728991315F39")
    
public IllegalStateException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code IllegalStateException} with the current stack
     * trace, the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the cause of this exception.
     * @since 1.5
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.089 -0500", hash_original_method = "6F3B5205BA771B0DF92BD44831C586ED", hash_generated_method = "F1C1BF56B815A0662C2CAAB74F9EB899")
    
public IllegalStateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code IllegalStateException} with the current stack
     * trace and the specified cause.
     *
     * @param cause
     *            the cause of this exception, may be {@code null}.
     * @since 1.5
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.091 -0500", hash_original_method = "6DC0580FE34F314D6F80EBAA4A416AA3", hash_generated_method = "D17356B6AEAEA409630F638EDBB3B0D3")
    
public IllegalStateException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}

