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

public class CycleInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.457 -0400", hash_original_field = "A0EE3305FA1A9221F46E8C78E7042111", hash_generated_field = "B899AFE094BA9FE27B31C93546E211F2")

    private float mCycles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.457 -0400", hash_original_method = "B3C740F3395BC63F138ED104BB72F5FF", hash_generated_method = "BA11D4BA12DF3EAB1AB28B2B714A5C98")
    public  CycleInterpolator(float cycles) {
        mCycles = cycles;
        // ---------- Original Method ----------
        //mCycles = cycles;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.457 -0400", hash_original_method = "3D8943FFFF7A02945830CB20C0A660B3", hash_generated_method = "82B6125E55BFDD4E379B9287D05C2932")
    public  CycleInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        //mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.458 -0400", hash_original_method = "C854E7122C234C45B08A1B645C47BE34", hash_generated_method = "88AA456AFD070437E55E9FFC5A502904")
    public float getInterpolation(float input) {
        float var562DE128661521933BE69E8098B2C6D5_272469857 = ((float)(Math.sin(2 * mCycles * Math.PI * input)));
        addTaint(input);
        float var546ADE640B6EDFBC8A086EF31347E768_1459858972 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1459858972;
        // ---------- Original Method ----------
        //return (float)(Math.sin(2 * mCycles * Math.PI * input));
    }

    
}

