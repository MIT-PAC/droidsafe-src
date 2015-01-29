package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DataFormatException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.169 -0500", hash_original_field = "E39F36BBD171B9C84AD19366AC48ED4F", hash_generated_field = "C9CD720E9C64714A16820A451BFCDC51")

    private static final long serialVersionUID = 2219632870893641452L;

    /**
     * Constructs a new {@code DataFormatException} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.172 -0500", hash_original_method = "64C52722D8298AB468E7E3E8999CA51F", hash_generated_method = "6FB07265273DD4D58EBD808F5D8FF537")
    
public DataFormatException() {
    }

    /**
     * Constructs a new {@code DataFormatException} instance with the specified
     * message.
     *
     * @param detailMessage
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:33.175 -0500", hash_original_method = "54A194B6E0CA21D574EDE0E22D325A81", hash_generated_method = "D0E99055D2BCE11D20C03985ED368F40")
    
public DataFormatException(String detailMessage) {
        super(detailMessage);
    }
}

