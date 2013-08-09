package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class BlurMaskFilter extends MaskFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-08 22:38:39.066 -0400", hash_original_method = "E906BEDBA8C667F2A993849051C66540", hash_generated_method = "DB37756D1E7646F47B7AB1203C89751F")
    public  BlurMaskFilter(float radius, Blur style) {
        addTaint(style.getTaint());
        addTaint(radius);
        native_instance = nativeConstructor(radius, style.native_int);
        // ---------- Original Method ----------
        //native_instance = nativeConstructor(radius, style.native_int);
    }

    
        private static int nativeConstructor(float radius, int style) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990673403 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990673403;
    }

    
    public enum Blur {
        NORMAL(0),  
        SOLID(1),   
        OUTER(2),   
        INNER(3);
        @DSModeled(DSC.SAFE)
        Blur(int value) {
            native_int = value;
        }
        final int native_int;
    }

    
}

