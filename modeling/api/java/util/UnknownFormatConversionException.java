package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnknownFormatConversionException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.592 -0500", hash_original_field = "B070DAF3B31EE569742856B867E8AAD1", hash_generated_field = "3D86292F0E1219DE043B5F4188CBC598")

    private static final long serialVersionUID = 19060418L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.595 -0500", hash_original_field = "6F3CB884E38CB76988A52AA9FBE92CE9", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private  String s;

    /**
     * Constructs an {@code UnknownFormatConversionException} with the unknown
     * format conversion.
     *
     * @param s
     *           the unknown format conversion.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.598 -0500", hash_original_method = "0FB4C71CADE23BA4642C2B1DAECF427B", hash_generated_method = "9F8C527BA3A3717904184BAE31D0F555")
    
public UnknownFormatConversionException(String s) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.600 -0500", hash_original_method = "F42E87FF5499AB643BB7E67C5DADAA6D", hash_generated_method = "7B92C0D01D97BD03D9BBBD6EC1C575FD")
    
public String getConversion() {
        return s;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:03.602 -0500", hash_original_method = "E0B7E8AB02E28C66CE17D4B71D9F5BCF", hash_generated_method = "83D675AFF486DD80DDF90F3450A72621")
    
@Override
    public String getMessage() {
        return "Conversion: " + s;
    }
}

