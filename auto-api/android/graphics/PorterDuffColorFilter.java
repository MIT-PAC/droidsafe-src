package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PorterDuffColorFilter extends ColorFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.313 -0400", hash_original_method = "7596573BC98218F8353DB810A415EA55", hash_generated_method = "429C91492E15464CAD257882CB7138E4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.313 -0400", hash_original_method = "69ED4D7D831B610E20A4B25C237B2902", hash_generated_method = "5E4E23D6A5351D9355EB92C3EF01FA08")
    private static int native_CreatePorterDuffFilter(int srcColor, int porterDuffMode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.313 -0400", hash_original_method = "36AEC6A5CC6D849413FB02DD7CD2F25F", hash_generated_method = "3D15F4FA96ADB73248D781772ADB3A80")
    private static int nCreatePorterDuffFilter(int nativeFilter, int srcColor,
            int porterDuffMode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


