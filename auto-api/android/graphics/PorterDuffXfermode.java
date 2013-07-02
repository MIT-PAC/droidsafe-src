package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PorterDuffXfermode extends Xfermode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.103 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "698BE6610509E128DA164E335568BD09")

    public PorterDuff.Mode mode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.104 -0400", hash_original_method = "051BEADE6290B35325837FC3FD526210", hash_generated_method = "CE9F8B860BFE864C3D9B1AFEE69D364E")
    public  PorterDuffXfermode(PorterDuff.Mode mode) {
        this.mode = mode;
        native_instance = nativeCreateXfermode(mode.nativeInt);
        
        
        
    }

    
    private static int nativeCreateXfermode(int mode) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

