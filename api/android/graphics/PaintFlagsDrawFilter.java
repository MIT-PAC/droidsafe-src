package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class PaintFlagsDrawFilter extends DrawFilter {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeConstructor(int clearBits, int setBits) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Subclass of DrawFilter that affects every paint by first clearing
     * the specified clearBits in the paint's flags, and then setting the
     * specified setBits in the paint's flags.
     *
     * @param clearBits These bits will be cleared in the paint's flags
     * @param setBits These bits will be set in the paint's flags
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.948 -0500", hash_original_method = "D31498501931F002B6E02A5E6FE68BA6", hash_generated_method = "DB8B9A412CEC8BA8F2B1DB42594F3045")
    
public PaintFlagsDrawFilter(int clearBits, int setBits) {
        // our native constructor can return 0, if the specified bits
        // are effectively a no-op
        mNativeInt = nativeConstructor(clearBits, setBits);
    }
    
}

