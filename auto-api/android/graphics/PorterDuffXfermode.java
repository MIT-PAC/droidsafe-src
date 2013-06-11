package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PorterDuffXfermode extends Xfermode {
    public final PorterDuff.Mode mode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.314 -0400", hash_original_method = "051BEADE6290B35325837FC3FD526210", hash_generated_method = "610CCB6844622A2F41E6512F1613F10C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PorterDuffXfermode(PorterDuff.Mode mode) {
        dsTaint.addTaint(mode.dsTaint);
        native_instance = nativeCreateXfermode(mode.nativeInt);
        // ---------- Original Method ----------
        //this.mode = mode;
        //native_instance = nativeCreateXfermode(mode.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.314 -0400", hash_original_method = "79E34DA236B4349F60F92D35F4065463", hash_generated_method = "E793762B4DED4998E7F6E790FDBCB170")
    private static int nativeCreateXfermode(int mode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


