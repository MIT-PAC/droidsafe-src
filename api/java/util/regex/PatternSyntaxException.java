package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class PatternSyntaxException extends IllegalArgumentException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.724 -0500", hash_original_field = "E07B55B3020F8FAD3B89EE71263765D3", hash_generated_field = "95718108CDA06A2DD9B75CB57E0279C5")

    private static final long serialVersionUID = -3864639126226059218L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.727 -0500", hash_original_field = "6B6E3FF272BF9F88A097A817DC27AF69", hash_generated_field = "869DADF19D0CEFB2D948CD463462BCA0")

    private String desc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.729 -0500", hash_original_field = "57C08BF52FBB9452CE610A98F88E4F24", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.732 -0500", hash_original_field = "0C3F3A62108AB7C9F2A0FD1A7BB34E58", hash_generated_field = "18384124910AA57648BA024F99B1F65B")

    private int index = -1;

    /**
     * Creates a new PatternSyntaxException for a given message, pattern, and
     * error index.
     *
     * @param description
     *            the description of the syntax error, or {@code null} if the
     *            description is not known.
     * @param pattern
     *            the syntactically incorrect regular expression, or
     *            {@code null} if the regular expression is not known.
     * @param index
     *            the character index around which the error occurred, or -1 if
     *            the index is not known.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.734 -0500", hash_original_method = "89B9A833AE2CE5B13E9F312F3F36ED4B", hash_generated_method = "00E8F812EAB398F385D00C450BD1C0AB")
    
public PatternSyntaxException(String description, String pattern, int index) {
        this.desc = description;
        this.pattern = pattern;
        this.index = index;
    }

    /**
     * Returns the syntactically incorrect regular expression.
     *
     * @return the regular expression.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.737 -0500", hash_original_method = "7A292BCA91A2C0FA8C2558D08D8D09A0", hash_generated_method = "1A9FDB8743C473586BF04DCAFF28A282")
    
public String getPattern() {
        return pattern;
    }

    /**
     * Returns a detailed error message for the exception. The message is
     * potentially multi-line, and it might include a detailed description, the
     * original regular expression, and the index at which the error occurred.
     *
     * @return the error message.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.740 -0500", hash_original_method = "103F1174601A04B5B5C014BF3A77F551", hash_generated_method = "3C2F0A3444D1C62640570528625D59B6")
    
@Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (desc != null) {
            sb.append(desc);
        }

        if (index >= 0) {
            if (desc != null) {
                sb.append(' ');
            }
            sb.append("near index ");
            sb.append(index);
            sb.append(':');
        }

        if (pattern != null) {
            sb.append('\n');
            sb.append(pattern);

            if (index >= 0) {
                char[] spaces = new char[index];
                Arrays.fill(spaces, ' ');
                sb.append('\n');
                sb.append(spaces);
                sb.append('^');
            }
        }

        return sb.toString();
    }

    /**
     * Returns the description of the syntax error, or {@code null} if the
     * description is not known.
     *
     * @return the description.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.742 -0500", hash_original_method = "B876CD4C2F9B0449C0BFBE53447962F9", hash_generated_method = "E4511326242349EB0FABB36392B66DEB")
    
public String getDescription() {
        return desc;
    }

    /**
     * Returns the character index around which the error occurred, or -1 if the
     * index is not known.
     *
     * @return the index.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.745 -0500", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "96CCC69099797392A28F97F5383D17E0")
    
public int getIndex() {
        return index;
    }
}

