package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InvalidObjectException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.347 -0500", hash_original_field = "677990D5BABC0145DFBB1D460A32C675", hash_generated_field = "6F09C82044616D14EF4E046B0DC4AF10")

    private static final long serialVersionUID = 3233174318281839583L;

    /**
     * Constructs an {@code InvalidObjectException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.350 -0500", hash_original_method = "4AF46063AE9909D1F5A16DD867276801", hash_generated_method = "A516B2CF5AF002985976B6415D9CE694")
    
public InvalidObjectException(String detailMessage) {
        super(detailMessage);
    }
}

