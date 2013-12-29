package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class UnmappableCharacterException extends CharacterCodingException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.577 -0500", hash_original_field = "D6D1666FF6B36CEE9E191C47E93E3C6C", hash_generated_field = "F98718CE7644E1BAF8F83D1AD426E139")

    private static final long serialVersionUID = -7026962371537706123L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.578 -0500", hash_original_field = "755C7B08BD7CC897183CC4B0B5436326", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;

    /**
     * Constructs a new {@code UnmappableCharacterException}.
     *
     * @param length
     *            the length of the unmappable character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.579 -0500", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "435F29678A7BB92BD64605F93A209FEE")
    public UnmappableCharacterException(int length) {
        this.inputLength = length;
    }

    /**
     * Returns the length of the unmappable character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.580 -0500", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "FA812069F55585CBB369DCEB6C68F21E")
    public int getInputLength() {
        return this.inputLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.581 -0500", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "1857012EE798A7AA3F53EF74BDA89DF6")
    @Override
public String getMessage() {
        return "Length: " + inputLength;
    }
}

