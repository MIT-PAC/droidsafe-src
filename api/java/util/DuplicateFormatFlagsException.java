package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DuplicateFormatFlagsException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.992 -0500", hash_original_field = "69212B48BC641C20E2E5ACE6CED63595", hash_generated_field = "4C0E6AE2289782AA658DEA3E3AFA2999")

    private static final long serialVersionUID = 18890531L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.994 -0500", hash_original_field = "806B57DB0428E85D2726FB0E46248D66", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private  String flags;

    /**
     * Constructs a new {@code DuplicateFormatFlagsException} with the flags
     * containing duplicates.
     *
     * @param f
     *           the format flags that contain a duplicate flag.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.997 -0500", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "83F4CCFB7ED7CF4F9ACCFE23B4350C57")
    
public DuplicateFormatFlagsException(String f) {
        if (f == null) {
            throw new NullPointerException();
        }
        flags = f;
    }

    /**
     * Returns the format flags that contain a duplicate flag.
     *
     * @return the format flags that contain a duplicate flag.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:48.000 -0500", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "755C27A527F4F0B24180AE62DAAD9815")
    
public String getFlags() {
        return flags;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:48.002 -0500", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D3CC7E01EA9B8CB8A8BD4B18FB45E983")
    
@Override
    public String getMessage() {
        return flags;
    }
}

