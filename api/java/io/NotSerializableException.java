package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NotSerializableException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.590 -0500", hash_original_field = "60837B5C1B966117A8FB2ADDBC15466F", hash_generated_field = "48F39D42996338B3D3EADC139002C622")

    private static final long serialVersionUID = 2906642554793891381L;

    /**
     * Constructs a new {@code NotSerializableException} with its stack trace
     * filled in.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.592 -0500", hash_original_method = "F05776C79D2C056D2A5E9037EDB03920", hash_generated_method = "8CFF896851B0FED7312E9CAEDF084484")
    
public NotSerializableException() {
    }

    /**
     * Constructs a new {@link NotSerializableException} with its stack trace
     * and detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.595 -0500", hash_original_method = "AC41FE5CB653485B7C55102BD4EBFA1E", hash_generated_method = "F054EB24726814C2CD166590686070CF")
    
public NotSerializableException(String detailMessage) {
        super(detailMessage);
    }
}

