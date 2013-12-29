package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;




public class AccelerateDecelerateInterpolator implements Interpolator {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.659 -0500", hash_original_method = "9170BAC272EC23921BC06B3298E3C672", hash_generated_method = "65309E801988EB5B5C1DA6EA7DC295CB")
    public AccelerateDecelerateInterpolator() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.660 -0500", hash_original_method = "D602F33A097B951591F85B612C29B413", hash_generated_method = "432382AE939AA654FC7B8365A3416EFB")
    @SuppressWarnings({"UnusedDeclaration"})
public AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.661 -0500", hash_original_method = "4CDEA74C9486F5AA77C068C7B6F2D062", hash_generated_method = "B03B14BDE8ABC1D6FE5605D5C32C941D")
    public float getInterpolation(float input) {
        return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
    }

    
}

