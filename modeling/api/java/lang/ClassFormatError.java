package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ClassFormatError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.429 -0500", hash_original_field = "16E549032B7EC4EBE37CBBDA56B69A2E", hash_generated_field = "5EA27B59C36E073C15C01C9D2F77DFE8")

    private static final long serialVersionUID = -8420114879011949195L;

    /**
     * Constructs a new {@code ClassFormatError} that includes the current stack
     * trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.431 -0500", hash_original_method = "425CA80A6692859A51AA327ECCF27B34", hash_generated_method = "56A869F7F22EF0248DEDF8F6B1BF0E6E")
    
public ClassFormatError() {
    }

    /**
     * Constructs a new {@code ClassFormatError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.434 -0500", hash_original_method = "BAE3B13B354B16D7CAA986D0ECE3EF81", hash_generated_method = "E206EB0E0AD07F3E5CDEB8C58994FB8A")
    
public ClassFormatError(String detailMessage) {
        super(detailMessage);
    }
}

