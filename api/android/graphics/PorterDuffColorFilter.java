package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PorterDuffColorFilter extends ColorFilter {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.825 -0400", hash_original_method = "7596573BC98218F8353DB810A415EA55", hash_generated_method = "D80BA774757B8E6D7A03404BAD569B9A")
    public  PorterDuffColorFilter(int srcColor, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(srcColor);
        native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
        // ---------- Original Method ----------
        //native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        //nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_CreatePorterDuffFilter(int srcColor, int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nCreatePorterDuffFilter(int nativeFilter, int srcColor,
            int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

