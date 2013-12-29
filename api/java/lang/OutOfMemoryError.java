package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class OutOfMemoryError extends VirtualMachineError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.738 -0500", hash_original_field = "DDF9EDA94CA38D92072F6D61C9206F50", hash_generated_field = "6777CAF84C62D33BC871EAE1C16AF151")


    private static final long serialVersionUID = 8228564086184010517L;

    /**
     * Constructs a new {@code OutOfMemoryError} that includes the current stack
     * trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.739 -0500", hash_original_method = "ADBA576B8D149CC9A483364A3C8F9DE7", hash_generated_method = "083877639DE9124323322433ECA63E75")
    public OutOfMemoryError() {
    }

    /**
     * Constructs a new {@code OutOfMemoryError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.740 -0500", hash_original_method = "C0FA448A5BDB254B40480B36A6B3D86E", hash_generated_method = "F4E05986235926D845F1DD2415EDF845")
    public OutOfMemoryError(String detailMessage) {
        super(detailMessage);
    }
}

