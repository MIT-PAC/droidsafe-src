package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class CancellationException extends IllegalStateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:45.191 -0500", hash_original_field = "B243E15B6AC13355B92A4A804E81BCC4", hash_generated_field = "F3AD4CDF91774FFBDAF7D0443800FBBD")

    private static final long serialVersionUID = -9202173006928992231L;

    /**
     * Constructs a <tt>CancellationException</tt> with no detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:45.192 -0500", hash_original_method = "C0676E9FE520D18F322700EE730819D6", hash_generated_method = "29D24BE5410E4955A051AB5D177667AC")
    public CancellationException() {}

    /**
     * Constructs a <tt>CancellationException</tt> with the specified detail
     * message.
     *
     * @param message the detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:45.193 -0500", hash_original_method = "6CF19E73C026523F689130FF9C39751C", hash_generated_method = "1598F5EB9AD023A3CBF17A833242949C")
    public CancellationException(String message) {
        super(message);
    }
}

