package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class DecelerateInterpolator implements Interpolator {
    private float mFactor = 1.0f;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.862 -0400", hash_original_method = "E95CC471518E4ACA9BF79FBE17893E65", hash_generated_method = "40A257C11E5CF68D02C469E8D23B0E2E")
    @DSModeled(DSC.SAFE)
    public DecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.862 -0400", hash_original_method = "FDF29E6FEED3439F4AD5C9E93301F45A", hash_generated_method = "89C55127F3A90438673736573BEA8CCF")
    @DSModeled(DSC.SAFE)
    public DecelerateInterpolator(float factor) {
        dsTaint.addTaint(factor);
        // ---------- Original Method ----------
        //mFactor = factor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.862 -0400", hash_original_method = "B4A81760BCCD97E1721CC54FAD915070", hash_generated_method = "DAF25C28A213559AB822FA529D60E6E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecelerateInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.DecelerateInterpolator);
        mFactor = a.getFloat(com.android.internal.R.styleable.DecelerateInterpolator_factor, 1.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.DecelerateInterpolator);
        //mFactor = a.getFloat(com.android.internal.R.styleable.DecelerateInterpolator_factor, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.862 -0400", hash_original_method = "53C85C7631357B3680FF88D2085C3BF7", hash_generated_method = "08185B0CE0A7840CF36DDAE8BE4CE597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        float result;
        {
            result = (float)(1.0f - (1.0f - input) * (1.0f - input));
        } //End block
        {
            result = (float)(1.0f - Math.pow((1.0f - input), 2 * mFactor));
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float result;
        //if (mFactor == 1.0f) {
            //result = (float)(1.0f - (1.0f - input) * (1.0f - input));
        //} else {
            //result = (float)(1.0f - Math.pow((1.0f - input), 2 * mFactor));
        //}
        //return result;
    }

    
}


