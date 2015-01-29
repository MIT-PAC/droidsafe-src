package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class MalformedInputException extends CharacterCodingException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.083 -0500", hash_original_field = "2B7F2530086621A042092B57ACAB6983", hash_generated_field = "AD2DD481E60844E3D7253976946DDA58")

    private static final long serialVersionUID = -3438823399834806194L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.086 -0500", hash_original_field = "755C7B08BD7CC897183CC4B0B5436326", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;

    /**
     * Constructs a new {@code MalformedInputException}.
     *
     * @param length
     *            the length of the malformed input.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.088 -0500", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "9353A0EB2ECDCF84D7E945D0B98F71D8")
    
public MalformedInputException(int length) {
        this.inputLength = length;
    }

    /**
     * Gets the length of the malformed input.
     *
     * @return the length of the malformed input.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.091 -0500", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "FA812069F55585CBB369DCEB6C68F21E")
    
public int getInputLength() {
        return this.inputLength;
    }


    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.093 -0500", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "1857012EE798A7AA3F53EF74BDA89DF6")
    
@Override
    public String getMessage() {
        return "Length: " + inputLength;
    }
}

