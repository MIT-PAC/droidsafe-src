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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.918 -0400", hash_original_method = "9170BAC272EC23921BC06B3298E3C672", hash_generated_method = "D44D0AF2D4BCF55AA1CC9E50DDF2DCD1")
    public  AccelerateDecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.918 -0400", hash_original_method = "D602F33A097B951591F85B612C29B413", hash_generated_method = "08053CF83BADCE55740CEDABD0361B0D")
    @SuppressWarnings({"UnusedDeclaration"})
    public  AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.918 -0400", hash_original_method = "4CDEA74C9486F5AA77C068C7B6F2D062", hash_generated_method = "DDF045EEEE8B6E3FA5A9D813F358DAE2")
    public float getInterpolation(float input) {
        float var5D6D4F1E6FA42978E975449212234539_173481723 = ((float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f);
        addTaint(input);
        float var546ADE640B6EDFBC8A086EF31347E768_1838649634 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1838649634;
        // ---------- Original Method ----------
        //return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
    }

    
}

