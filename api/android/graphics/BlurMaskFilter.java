package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class BlurMaskFilter extends MaskFilter {

    
        private static int nativeConstructor(float radius, int style) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990673403 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990673403;
    }
    
    /**
     * Create a blur maskfilter.
     *
     * @param radius The radius to extend the blur from the original mask. Must be > 0.
     * @param style  The Blur to use
     * @return       The new blur maskfilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.062 -0500", hash_original_method = "E906BEDBA8C667F2A993849051C66540", hash_generated_method = "92A9E7A1C9812AD7226E5F9C6F28DDAE")
    
public BlurMaskFilter(float radius, Blur style) {
        native_instance = nativeConstructor(radius, style.native_int);
    }

    
    public enum Blur {
        NORMAL(0),  
        SOLID(1),   
        OUTER(2),   
        INNER(3);   //!< just blur inside the original border
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.056 -0500", hash_original_method = "48C9082C1B59E336FB6C242DE3A9C7D0", hash_generated_method = "48C9082C1B59E336FB6C242DE3A9C7D0")
            
Blur(int value) {
            native_int = value;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.058 -0500", hash_original_field = "BADCEEE95FC21A56DEC673ECC42E1251", hash_generated_field = "BADCEEE95FC21A56DEC673ECC42E1251")

         int native_int;
    }

    
}

