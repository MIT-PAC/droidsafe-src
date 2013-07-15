package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CornerPathEffect extends PathEffect {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.238 -0400", hash_original_method = "1A6DA6E79B72785E2BC38681BFBED33C", hash_generated_method = "E74CD84CF8ABF68C16A8F7ADD231E9BF")
    public  CornerPathEffect(float radius) {
        addTaint(radius);
        native_instance = nativeCreate(radius);
        // ---------- Original Method ----------
        //native_instance = nativeCreate(radius);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(float radius) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317499148 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317499148;
    }

    
}

