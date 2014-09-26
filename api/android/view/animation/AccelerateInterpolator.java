package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AccelerateInterpolator implements Interpolator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.305 -0500", hash_original_field = "5F55AF62FBC4E40CA601A9EF6C2F535D", hash_generated_field = "C4B60CAF58795A5FD80295DCE69373D7")

    private  float mFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.308 -0500", hash_original_field = "575142D26864A930A9D73126BAA4B195", hash_generated_field = "E32BD9A569BB931AE42B2AB10166121F")

    private  double mDoubleFactor;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.310 -0500", hash_original_method = "6B066D2B0A6275C71F94C50A6808FEFE", hash_generated_method = "561C0C48B89A9EDAC0AB93CBCF1494FA")
    
public AccelerateInterpolator() {
        mFactor = 1.0f;
        mDoubleFactor = 2.0;
    }
    
    /**
     * Constructor
     * 
     * @param factor Degree to which the animation should be eased. Seting
     *        factor to 1.0f produces a y=x^2 parabola. Increasing factor above
     *        1.0f  exaggerates the ease-in effect (i.e., it starts even
     *        slower and ends evens faster)
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.313 -0500", hash_original_method = "94059E5CBD2536EA402F0EA752CA0B91", hash_generated_method = "9645CF4B2EBFA6BF1B15BD023F89559D")
    
public AccelerateInterpolator(float factor) {
        mFactor = factor;
        mDoubleFactor = 2 * mFactor;
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.316 -0500", hash_original_method = "E776590D91ABBE218804FDD3622828FA", hash_generated_method = "85AE2CE3522EAC83DB14E56935E3506E")
    
public AccelerateInterpolator(Context context, AttributeSet attrs) {
        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AccelerateInterpolator);
        
        mFactor = a.getFloat(com.android.internal.R.styleable.AccelerateInterpolator_factor, 1.0f);
        mDoubleFactor = 2 * mFactor;

        a.recycle();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.319 -0500", hash_original_method = "8D8C7C748A85E1C7007F595C7B08B241", hash_generated_method = "1BDFF9C8001694F05039E1E7865FAAFB")
    
public float getInterpolation(float input) {
        if (mFactor == 1.0f) {
            return input * input;
        } else {
            return (float)Math.pow(input, mDoubleFactor);
        }
    }
    
}

