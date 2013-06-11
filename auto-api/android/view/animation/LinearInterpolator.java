package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.AttributeSet;

public class LinearInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.873 -0400", hash_original_method = "13E92F18FAEF7A23B3FECE76D3743C4D", hash_generated_method = "2F44D160AD277A1D927A103684CD74E1")
    @DSModeled(DSC.SAFE)
    public LinearInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.873 -0400", hash_original_method = "29CB619ACC2051B5132F64AAC7117909", hash_generated_method = "056F315BCFA40357C330A17EF3AEC6D7")
    @DSModeled(DSC.SAFE)
    public LinearInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.873 -0400", hash_original_method = "6F32AC5E234DC575638821E35BB1A952", hash_generated_method = "7436D17C37FA1561F8D35B4904FA7879")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return input;
    }

    
}


