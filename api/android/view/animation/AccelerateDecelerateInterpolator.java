package android.view.animation;

// Droidsafe Imports
import android.content.Context;
import android.util.AttributeSet;
import droidsafe.annotations.DSGenerator;

public class AccelerateDecelerateInterpolator implements Interpolator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.645 -0400", hash_original_method = "9170BAC272EC23921BC06B3298E3C672", hash_generated_method = "D44D0AF2D4BCF55AA1CC9E50DDF2DCD1")
    public  AccelerateDecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.645 -0400", hash_original_method = "D602F33A097B951591F85B612C29B413", hash_generated_method = "013773700F22AFE905A38A299FEA2379")
    @SuppressWarnings({"UnusedDeclaration"})
    public  AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.646 -0400", hash_original_method = "4CDEA74C9486F5AA77C068C7B6F2D062", hash_generated_method = "B8744BAF30AC4710FBAC8C7494EB321A")
    public float getInterpolation(float input) {
        addTaint(input);
        float varA61ABA6772F4D9189BA44ED9DC5667B4_1822712763 = ((float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f);
                float var546ADE640B6EDFBC8A086EF31347E768_1178792911 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1178792911;
        // ---------- Original Method ----------
        //return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
    }

    
}

