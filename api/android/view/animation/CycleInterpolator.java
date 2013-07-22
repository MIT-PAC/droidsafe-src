package android.view.animation;

// Droidsafe Imports
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CycleInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.897 -0400", hash_original_field = "A0EE3305FA1A9221F46E8C78E7042111", hash_generated_field = "B899AFE094BA9FE27B31C93546E211F2")

    private float mCycles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.897 -0400", hash_original_method = "B3C740F3395BC63F138ED104BB72F5FF", hash_generated_method = "BA11D4BA12DF3EAB1AB28B2B714A5C98")
    @DSModeled(DSC.SAFE)
    public  CycleInterpolator(float cycles) {
        mCycles = cycles;
        // ---------- Original Method ----------
        //mCycles = cycles;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.898 -0400", hash_original_method = "3D8943FFFF7A02945830CB20C0A660B3", hash_generated_method = "B4B049EFB94B58F835FF15B0BF309A19")
    @DSModeled(DSC.SAFE)
    public  CycleInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        //mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.898 -0400", hash_original_method = "C854E7122C234C45B08A1B645C47BE34", hash_generated_method = "7DCB4377B42BA3482F8BA344BC3BC11A")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float input) {
        addTaint(input);
        float varCAA5374381A561639DB19EE12C68720E_1773687533 = ((float)(Math.sin(2 * mCycles * Math.PI * input)));
                float var546ADE640B6EDFBC8A086EF31347E768_268368656 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_268368656;
        // ---------- Original Method ----------
        //return (float)(Math.sin(2 * mCycles * Math.PI * input));
    }

    
}

