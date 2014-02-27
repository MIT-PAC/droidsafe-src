package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class PorterDuffColorFilter extends ColorFilter {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_CreatePorterDuffFilter(int srcColor, int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nCreatePorterDuffFilter(int nativeFilter, int srcColor,
            int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }
    /**
     * Create a colorfilter that uses the specified color and porter-duff mode.
     *
     * @param srcColor       The source color used with the specified
     *                       porter-duff mode
     * @param mode           The porter-duff mode that is applied
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:10.970 -0500", hash_original_method = "7596573BC98218F8353DB810A415EA55", hash_generated_method = "FC221DD174470D4245763A796A96A214")
    
public PorterDuffColorFilter(int srcColor, PorterDuff.Mode mode) {
        native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
    }
    
}

