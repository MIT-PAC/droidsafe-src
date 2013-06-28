package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PorterDuffColorFilter extends ColorFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.099 -0400", hash_original_method = "7596573BC98218F8353DB810A415EA55", hash_generated_method = "F82B2FA53DF8E60A35BD0910128BE877")
    public  PorterDuffColorFilter(int srcColor, PorterDuff.Mode mode) {
        native_instance = native_CreatePorterDuffFilter(srcColor, mode.nativeInt);
        nativeColorFilter = nCreatePorterDuffFilter(native_instance, srcColor, mode.nativeInt);
        addTaint(srcColor);
        addTaint(mode.getTaint());
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

