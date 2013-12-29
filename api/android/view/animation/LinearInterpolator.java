package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;




public class LinearInterpolator implements Interpolator {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.690 -0500", hash_original_method = "13E92F18FAEF7A23B3FECE76D3743C4D", hash_generated_method = "D97DB0409FE17B256914BC53C86F250C")
    public LinearInterpolator() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.691 -0500", hash_original_method = "29CB619ACC2051B5132F64AAC7117909", hash_generated_method = "929FAF15E64844BD56AC9F3328D02C09")
    public LinearInterpolator(Context context, AttributeSet attrs) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.692 -0500", hash_original_method = "6F32AC5E234DC575638821E35BB1A952", hash_generated_method = "03715D1D8B6E767BEEADF23FA216761B")
    public float getInterpolation(float input) {
        return input;
    }

    
}

