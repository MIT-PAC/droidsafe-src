package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PixelXorXfermode extends Xfermode {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.757 -0400", hash_original_method = "D83BD6D1A9BB9762D9B3F34AF8222FEA", hash_generated_method = "116186C686DB4DF13AE7D12EB56DDCCC")
    public  PixelXorXfermode(int opColor) {
        addTaint(opColor);
        native_instance = nativeCreate(opColor);
        // ---------- Original Method ----------
        //native_instance = nativeCreate(opColor);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(int opColor) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725099153 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725099153;
    }

    
}

