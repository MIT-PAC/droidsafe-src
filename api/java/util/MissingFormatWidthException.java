package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class MissingFormatWidthException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.174 -0500", hash_original_field = "76333191D6A81F62E9E3BD72642DE4B9", hash_generated_field = "9262A014094776552C1DB27AFE71EDD8")

    private static final long serialVersionUID = 15560123L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.177 -0500", hash_original_field = "6F3CB884E38CB76988A52AA9FBE92CE9", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private  String s;

    /**
     * Constructs a new {@code MissingFormatWidthException} with the specified
     * format specifier.
     *
     * @param s
     *           the specified format specifier.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.179 -0500", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "1CDF571302F76E6A3FE2C188C3EF1CD5")
    
public MissingFormatWidthException(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * Returns the format specifier associated with the exception.
     *
     * @return the format specifier associated with the exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.181 -0500", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "B5EF8C4577C109EF71D4C5DF20FB818D")
    
public String getFormatSpecifier() {
        return s;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:43.184 -0500", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "97EE27B1421D4F688EB352C6B1788982")
    
@Override
    public String getMessage() {
        return s;
    }
}

