package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;





public class DecelerateInterpolator implements Interpolator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.677 -0500", hash_original_field = "F629CADA235E0CF4B3D2DAAEC94A8720", hash_generated_field = "A4F5427DC6C0D3BD86B003B9F84706BC")

    
    private float mFactor = 1.0f;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.674 -0500", hash_original_method = "E95CC471518E4ACA9BF79FBE17893E65", hash_generated_method = "BC3D2231269944E5A92DBFD0F7E93424")
    public DecelerateInterpolator() {
    }

    /**
     * Constructor
     * 
     * @param factor Degree to which the animation should be eased. Setting factor to 1.0f produces
     *        an upside-down y=x^2 parabola. Increasing factor above 1.0f makes exaggerates the
     *        ease-out effect (i.e., it starts even faster and ends evens slower)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.675 -0500", hash_original_method = "FDF29E6FEED3439F4AD5C9E93301F45A", hash_generated_method = "F327E1735E922A9DAFCE720978B8687D")
    public DecelerateInterpolator(float factor) {
        mFactor = factor;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.675 -0500", hash_original_method = "B4A81760BCCD97E1721CC54FAD915070", hash_generated_method = "318F2C7B3A19029E0C3131143E7D1499")
    public DecelerateInterpolator(Context context, AttributeSet attrs) {
        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.DecelerateInterpolator);
        
        mFactor = a.getFloat(com.android.internal.R.styleable.DecelerateInterpolator_factor, 1.0f);
        
        a.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.676 -0500", hash_original_method = "53C85C7631357B3680FF88D2085C3BF7", hash_generated_method = "291FA6CC116E313A867FFB864B5E8E2D")
    public float getInterpolation(float input) {
        float result;
        if (mFactor == 1.0f) {
            result = (float)(1.0f - (1.0f - input) * (1.0f - input));
        } else {
            result = (float)(1.0f - Math.pow((1.0f - input), 2 * mFactor));
        }
        return result;
    }

    
}

