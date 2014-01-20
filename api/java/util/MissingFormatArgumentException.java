package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class MissingFormatArgumentException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.571 -0500", hash_original_field = "82EEE3CCDE8BFF76F042F5FFD23F381B", hash_generated_field = "723F192E88250AAFAAB75AB9339AECE3")

    private static final long serialVersionUID = 19190115L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.573 -0500", hash_original_field = "6F3CB884E38CB76988A52AA9FBE92CE9", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private  String s;

    /**
     * Constructs a new {@code MissingFormatArgumentException} with the
     * specified conversion that lacks the argument.
     *
     * @param s
     *           the specified conversion that lacks the argument.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.576 -0500", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "681F1F55DB6FB4C149E4113361637857")
    
public MissingFormatArgumentException(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    /**
     * Returns the conversion associated with the exception.
     *
     * @return the conversion associated with the exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.578 -0500", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "B5EF8C4577C109EF71D4C5DF20FB818D")
    
public String getFormatSpecifier() {
        return s;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:24.580 -0500", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "E831B99CF205FF7F407FD6E605C4B920")
    
@Override
    public String getMessage() {
        return "Format specifier: " + s;
    }
}

