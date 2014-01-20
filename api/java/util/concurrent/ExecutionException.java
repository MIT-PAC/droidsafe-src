package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ExecutionException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:09.392 -0500", hash_original_field = "FF7C593BA4DF310EC8C99EFC4E7317F9", hash_generated_field = "4C3DC9FE7EA604C8C77421AD65570D42")

    private static final long serialVersionUID = 7830266012832686185L;

    /**
     * Constructs an <tt>ExecutionException</tt> with no detail message.
     * The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:09.394 -0500", hash_original_method = "CDEFB422B20894AAD6D4B957BC56ADC9", hash_generated_method = "847C83D48280FC61FF967516E2A7095B")
    
protected ExecutionException() { }

    /**
     * Constructs an <tt>ExecutionException</tt> with the specified detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     *
     * @param message the detail message
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:09.397 -0500", hash_original_method = "7E880AEC547973941FE5E9587A1A933C", hash_generated_method = "625F6B1F1BB1AD7B2ED20876E9331F1C")
    
protected ExecutionException(String message) {
        super(message);
    }

    /**
     * Constructs an <tt>ExecutionException</tt> with the specified detail
     * message and cause.
     *
     * @param  message the detail message
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:09.400 -0500", hash_original_method = "8309DDE2E41584C8A0A69308778461DD", hash_generated_method = "921DB627584208513156ED32C45F27D3")
    
public ExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an <tt>ExecutionException</tt> with the specified cause.
     * The detail message is set to:
     * <pre>
     *  (cause == null ? null : cause.toString())</pre>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:09.402 -0500", hash_original_method = "BC8973A519EF21FB8A5BD589A5BEDC19", hash_generated_method = "4DDA9E5A9A5DCCF1674BF019906FB62D")
    
public ExecutionException(Throwable cause) {
        super(cause);
    }
}

