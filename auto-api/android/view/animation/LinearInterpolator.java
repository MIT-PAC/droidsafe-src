package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;

public class LinearInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.154 -0400", hash_original_method = "13E92F18FAEF7A23B3FECE76D3743C4D", hash_generated_method = "DC13658407D17E107075AA3D5F40CD6F")
    @DSModeled(DSC.SAFE)
    public LinearInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.154 -0400", hash_original_method = "29CB619ACC2051B5132F64AAC7117909", hash_generated_method = "65F9DBDA229A120E2CBC4047427F873F")
    @DSModeled(DSC.SAFE)
    public LinearInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.154 -0400", hash_original_method = "6F32AC5E234DC575638821E35BB1A952", hash_generated_method = "F485323F8C308AF40AD38264C7CA86A1")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return input;
    }

    
}

