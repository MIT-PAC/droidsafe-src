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

public class DecelerateInterpolator implements Interpolator {
    private float mFactor = 1.0f;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.109 -0400", hash_original_method = "E95CC471518E4ACA9BF79FBE17893E65", hash_generated_method = "5083D8CB9C8622A55E9438CFA2C111F7")
    @DSModeled(DSC.SAFE)
    public DecelerateInterpolator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.109 -0400", hash_original_method = "FDF29E6FEED3439F4AD5C9E93301F45A", hash_generated_method = "85EB8A93A2A61584768BB5D78E9A76FA")
    @DSModeled(DSC.SAFE)
    public DecelerateInterpolator(float factor) {
        dsTaint.addTaint(factor);
        // ---------- Original Method ----------
        //mFactor = factor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.109 -0400", hash_original_method = "B4A81760BCCD97E1721CC54FAD915070", hash_generated_method = "369F1B389617AC03AB92ECF0D3DE4BBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.109 -0400", hash_original_method = "53C85C7631357B3680FF88D2085C3BF7", hash_generated_method = "2CFCC4C26374D5AD7C05B7F06192C1D4")
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

