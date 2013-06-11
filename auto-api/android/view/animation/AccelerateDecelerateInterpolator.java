package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.AttributeSet;

public class AccelerateDecelerateInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.817 -0400", hash_original_method = "9170BAC272EC23921BC06B3298E3C672", hash_generated_method = "8493376525265B8C03720DBE996985D3")
    @DSModeled(DSC.SAFE)
    public AccelerateDecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.817 -0400", hash_original_method = "D602F33A097B951591F85B612C29B413", hash_generated_method = "3D2390822785F0B1A8A4AEA745BFD946")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    public AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.817 -0400", hash_original_method = "4CDEA74C9486F5AA77C068C7B6F2D062", hash_generated_method = "C7A1BE0D25664558E81EEC15250DC6FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        float var5D6D4F1E6FA42978E975449212234539_836563192 = ((float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
    }

    
}


