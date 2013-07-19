package android.view.animation;

// Droidsafe Imports
import android.content.Context;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class LinearInterpolator implements Interpolator {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.035 -0400", hash_original_method = "13E92F18FAEF7A23B3FECE76D3743C4D", hash_generated_method = "DC13658407D17E107075AA3D5F40CD6F")
    public  LinearInterpolator() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.035 -0400", hash_original_method = "29CB619ACC2051B5132F64AAC7117909", hash_generated_method = "E17E5DE09DBE968101A281DD2E33328D")
    public  LinearInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.035 -0400", hash_original_method = "6F32AC5E234DC575638821E35BB1A952", hash_generated_method = "0C7E1E6638BBE19A28A15CD26F827587")
    public float getInterpolation(float input) {
        addTaint(input);
        float varA43C1B0AA53A0C908810C06AB1FF3967_194493364 = (input);
                float var546ADE640B6EDFBC8A086EF31347E768_194093073 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_194093073;
        // ---------- Original Method ----------
        //return input;
    }

    
}

