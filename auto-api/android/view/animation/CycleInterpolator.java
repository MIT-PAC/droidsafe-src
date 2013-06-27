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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.330 -0400", hash_original_field = "A0EE3305FA1A9221F46E8C78E7042111", hash_generated_field = "B899AFE094BA9FE27B31C93546E211F2")

    private float mCycles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.330 -0400", hash_original_method = "B3C740F3395BC63F138ED104BB72F5FF", hash_generated_method = "BA11D4BA12DF3EAB1AB28B2B714A5C98")
    public  CycleInterpolator(float cycles) {
        mCycles = cycles;
        // ---------- Original Method ----------
        //mCycles = cycles;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.337 -0400", hash_original_method = "3D8943FFFF7A02945830CB20C0A660B3", hash_generated_method = "CC57A5DD52EBE1F45C035FAAA42B4DC3")
    public  CycleInterpolator(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.342 -0400", hash_original_method = "C854E7122C234C45B08A1B645C47BE34", hash_generated_method = "068FD85312A1F1437D78621669E28D1C")
    public float getInterpolation(float input) {
        float var562DE128661521933BE69E8098B2C6D5_1381474128 = ((float)(Math.sin(2 * mCycles * Math.PI * input)));
        addTaint(input);
        float var546ADE640B6EDFBC8A086EF31347E768_1778320919 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1778320919;
        // ---------- Original Method ----------
        //return (float)(Math.sin(2 * mCycles * Math.PI * input));
    }

    
}

