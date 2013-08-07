package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class BlurMaskFilter extends MaskFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:38.641 -0400", hash_original_method = "E906BEDBA8C667F2A993849051C66540", hash_generated_method = "FEBBE57AECD55A3C0890A2723A465052")
    public  BlurMaskFilter(float radius, Blur style) {
        addTaint(style.getTaint());
        addTaint(radius);
native_instance=nativeConstructor(radius, style.native_int)
        // ---------- Original Method ----------
        //native_instance = nativeConstructor(radius, style.native_int);
    }

    
    private static int nativeConstructor(float radius, int style) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937545656 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937545656;
    }

    
    public enum Blur {
        NORMAL(0),  
        SOLID(1),   
        OUTER(2),   
        INNER(3);   
        Blur(int value) {
            native_int = value;
        }
        final int native_int;
    }

    
}

