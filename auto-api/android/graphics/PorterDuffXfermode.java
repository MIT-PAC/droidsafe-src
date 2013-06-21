package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PorterDuffXfermode extends Xfermode {
    public PorterDuff.Mode mode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.549 -0400", hash_original_method = "051BEADE6290B35325837FC3FD526210", hash_generated_method = "8373334C75405766926052DE91D18C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PorterDuffXfermode(PorterDuff.Mode mode) {
        dsTaint.addTaint(mode.dsTaint);
        native_instance = nativeCreateXfermode(mode.nativeInt);
        // ---------- Original Method ----------
        //this.mode = mode;
        //native_instance = nativeCreateXfermode(mode.nativeInt);
    }

    
        private static int nativeCreateXfermode(int mode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

