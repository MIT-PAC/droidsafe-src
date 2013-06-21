package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AccelerateInterpolator implements Interpolator {
    private float mFactor;
    private double mDoubleFactor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.970 -0400", hash_original_method = "6B066D2B0A6275C71F94C50A6808FEFE", hash_generated_method = "F4C76F6A7360596A87957076806A582C")
    @DSModeled(DSC.SAFE)
    public AccelerateInterpolator() {
        mFactor = 1.0f;
        mDoubleFactor = 2.0;
        // ---------- Original Method ----------
        //mFactor = 1.0f;
        //mDoubleFactor = 2.0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.970 -0400", hash_original_method = "94059E5CBD2536EA402F0EA752CA0B91", hash_generated_method = "887CF2664C4B52594BDC6E991AC7BE1A")
    @DSModeled(DSC.SAFE)
    public AccelerateInterpolator(float factor) {
        dsTaint.addTaint(factor);
        mDoubleFactor = 2 * mFactor;
        // ---------- Original Method ----------
        //mFactor = factor;
        //mDoubleFactor = 2 * mFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.970 -0400", hash_original_method = "E776590D91ABBE218804FDD3622828FA", hash_generated_method = "361A7277517E9C334A4BFF357BB3FB1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccelerateInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AccelerateInterpolator);
        mFactor = a.getFloat(com.android.internal.R.styleable.AccelerateInterpolator_factor, 1.0f);
        mDoubleFactor = 2 * mFactor;
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AccelerateInterpolator);
        //mFactor = a.getFloat(com.android.internal.R.styleable.AccelerateInterpolator_factor, 1.0f);
        //mDoubleFactor = 2 * mFactor;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.970 -0400", hash_original_method = "8D8C7C748A85E1C7007F595C7B08B241", hash_generated_method = "28833A2229FA1D278EC537D584CC7A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        {
            float var73859B2992F46FC4B2E8AC506AD29932_1053873702 = ((float)Math.pow(input, mDoubleFactor));
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mFactor == 1.0f) {
            //return input * input;
        //} else {
            //return (float)Math.pow(input, mDoubleFactor);
        //}
    }

    
}

