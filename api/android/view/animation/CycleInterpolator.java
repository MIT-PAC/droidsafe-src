package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;





public class CycleInterpolator implements Interpolator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.221 -0500", hash_original_field = "17F18B8547C8163B564A93FA0327FF9E", hash_generated_field = "B899AFE094BA9FE27B31C93546E211F2")

    
    private float mCycles;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.217 -0500", hash_original_method = "B3C740F3395BC63F138ED104BB72F5FF", hash_generated_method = "973DCFF905BD2075568557E5E8B5113D")
    public CycleInterpolator(float cycles) {
        mCycles = cycles;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.219 -0500", hash_original_method = "3D8943FFFF7A02945830CB20C0A660B3", hash_generated_method = "068F617DDBDBE081EB64F239BC83EA5C")
    public CycleInterpolator(Context context, AttributeSet attrs) {
        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        
        mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        
        a.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.220 -0500", hash_original_method = "C854E7122C234C45B08A1B645C47BE34", hash_generated_method = "0A1DAC5C284DAAFDA01827EDA9C33BCE")
    public float getInterpolation(float input) {
        return (float)(Math.sin(2 * mCycles * Math.PI * input));
    }

    
}

