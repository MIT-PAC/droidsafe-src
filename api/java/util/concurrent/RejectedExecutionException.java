package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class RejectedExecutionException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.260 -0500", hash_original_field = "FB756077ACECEC5BCBB25B731C7A3EFF", hash_generated_field = "186DDE3724BE825E7BBFB6C14ECF5E8F")

    private static final long serialVersionUID = -375805702767069545L;

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with no detail message.
     * The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.261 -0500", hash_original_method = "14BCCCC5B9E76D0C33B19F741DA19A4D", hash_generated_method = "FE41605EF4F0C24FE9849F18FBEA6EE7")
    public RejectedExecutionException() { }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link
     * #initCause(Throwable) initCause}.
     *
     * @param message the detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.262 -0500", hash_original_method = "685040D05C4255BE5A578536BCB19A2C", hash_generated_method = "9075C47707276C23620D48186BCB02D8")
    public RejectedExecutionException(String message) {
        super(message);
    }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified detail message and cause.
     *
     * @param  message the detail message
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.263 -0500", hash_original_method = "E48A8DF27205DB3C2384C43BB1BC845B", hash_generated_method = "430AC3B395AFA9CCD14DE04745571D20")
    public RejectedExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified cause.  The detail message is set to: <pre> (cause ==
     * null ? null : cause.toString())</pre> (which typically contains
     * the class and detail message of <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.264 -0500", hash_original_method = "A7DCBE3F8485ADE0DEAC0A36B08B4222", hash_generated_method = "B651C4E56A90C136C279CD930C42EDE1")
    public RejectedExecutionException(Throwable cause) {
        super(cause);
    }
}

