package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.AttributeSet;

public class LinearInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.894 -0400", hash_original_method = "13E92F18FAEF7A23B3FECE76D3743C4D", hash_generated_method = "DC13658407D17E107075AA3D5F40CD6F")
    public  LinearInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.894 -0400", hash_original_method = "29CB619ACC2051B5132F64AAC7117909", hash_generated_method = "E17E5DE09DBE968101A281DD2E33328D")
    public  LinearInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.895 -0400", hash_original_method = "6F32AC5E234DC575638821E35BB1A952", hash_generated_method = "D290879CCCEAD9A01A55E4FC780AD495")
    public float getInterpolation(float input) {
        addTaint(input);
        float varA43C1B0AA53A0C908810C06AB1FF3967_178386334 = (input);
                float var546ADE640B6EDFBC8A086EF31347E768_1782165735 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1782165735;
        // ---------- Original Method ----------
        //return input;
    }

    
}

