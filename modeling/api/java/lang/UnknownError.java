package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnknownError extends VirtualMachineError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.660 -0500", hash_original_field = "2F272C34205B7B1B25D9AC7D49350D81", hash_generated_field = "3A804F8B2369E6030B7BA56EE93212B0")

    private static final long serialVersionUID = 2524784860676771849L;

    /**
     * Constructs a new {@code UnknownError} that includes the current stack
     * trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.662 -0500", hash_original_method = "DEBB86C8E485BA79C07551D87066B1FF", hash_generated_method = "6C3E5315C342509DE4814B5A0C5AAF56")
    
public UnknownError() {
    }

    /**
     * Constructs a new {@code UnknownError} with the current stack trace and
     * the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.665 -0500", hash_original_method = "9EE2469E06677E3029FF643B11D994DB", hash_generated_method = "82347FB2E6016701B7D01B73FA65ACFA")
    
public UnknownError(String detailMessage) {
        super(detailMessage);
    }
}

