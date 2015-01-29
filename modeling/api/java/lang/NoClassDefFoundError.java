package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NoClassDefFoundError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.411 -0500", hash_original_field = "A34D2E22B8AEB391A372450313DE4CF0", hash_generated_field = "7F723B6959D8FAA4C42C90B77178AC81")

    private static final long serialVersionUID = 9095859863287012458L;

    /**
     * Constructs a new {@code NoClassDefFoundError} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.414 -0500", hash_original_method = "8CFE32FE45EF5975C0AEC893301BEE4B", hash_generated_method = "5FFE3B56A333844F16468049F0DB0449")
    
public NoClassDefFoundError() {
    }

    /**
     * Constructs a new {@code NoClassDefFoundError} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.417 -0500", hash_original_method = "88A7AB7FEE2EA03213AF9C41CB5D2B15", hash_generated_method = "88911A1410DDAEDA1F2EC4E89C7F3917")
    
public NoClassDefFoundError(String detailMessage) {
        super(detailMessage);
    }
}

