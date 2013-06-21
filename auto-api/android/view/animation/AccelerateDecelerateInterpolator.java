package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;

public class AccelerateDecelerateInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.966 -0400", hash_original_method = "9170BAC272EC23921BC06B3298E3C672", hash_generated_method = "D44D0AF2D4BCF55AA1CC9E50DDF2DCD1")
    @DSModeled(DSC.SAFE)
    public AccelerateDecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.966 -0400", hash_original_method = "D602F33A097B951591F85B612C29B413", hash_generated_method = "58616B5816BDEE33880368B9BF2162BB")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    public AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.967 -0400", hash_original_method = "4CDEA74C9486F5AA77C068C7B6F2D062", hash_generated_method = "B7C1875222CACFF20E747449546D716F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        float var5D6D4F1E6FA42978E975449212234539_2115217321 = ((float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
    }

    
}

