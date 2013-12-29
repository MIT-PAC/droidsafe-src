package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.650 -0500", hash_original_field = "21095941128B6129DEC37CD978EFF0FA", hash_generated_field = "3B223E7F26C32E3992CEACF94EAB3E33")

    private static final long serialVersionUID = 790824L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.651 -0500", hash_original_field = "806B57DB0428E85D2726FB0E46248D66", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")


    private  String flags;

    /**
     * Constructs a new {@code IllegalFormatFlagsException} with the specified
     * flags.
     *
     * @param flags
     *           the specified flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.652 -0500", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "D0C22EC43D8E60BFD62B1C1311A559D1")
    public IllegalFormatFlagsException(String flags) {
        if (flags == null) {
            throw new NullPointerException();
        }
        this.flags = flags;
    }

    /**
     * Returns the flags that are illegal.
     *
     * @return the flags that are illegal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.652 -0500", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "755C27A527F4F0B24180AE62DAAD9815")
    public String getFlags() {
        return flags;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.653 -0500", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D3CC7E01EA9B8CB8A8BD4B18FB45E983")
    @Override
public String getMessage() {
        return flags;
    }
}

