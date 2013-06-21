package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PorterDuffColorFilter extends ColorFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.548 -0400", hash_original_method = "7596573BC98218F8353DB810A415EA55", hash_generated_method = "D56195A98A45B4A9C25754513EBABC4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PorterDuffColorFilter(int srcColor, PorterDuff.Mode mode) {
        dsTaint.addTaint(srcColor);
        dsTaint.addTaint(mode.dsTaint);
        native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
        // ---------- Original Method ----------
        //native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        //nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
    }

    
        private static int native_CreatePorterDuffFilter(int srcColor, int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nCreatePorterDuffFilter(int nativeFilter, int srcColor,
            int porterDuffMode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

