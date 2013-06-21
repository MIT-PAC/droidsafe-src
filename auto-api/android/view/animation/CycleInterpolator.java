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
    private float mCycles;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.105 -0400", hash_original_method = "B3C740F3395BC63F138ED104BB72F5FF", hash_generated_method = "AFD519C98C34C3EE84920FF26633C357")
    @DSModeled(DSC.SAFE)
    public CycleInterpolator(float cycles) {
        dsTaint.addTaint(cycles);
        // ---------- Original Method ----------
        //mCycles = cycles;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.105 -0400", hash_original_method = "3D8943FFFF7A02945830CB20C0A660B3", hash_generated_method = "5C1788DF38F20D6CDA65E55B68A9B193")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CycleInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a =
            //context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.CycleInterpolator);
        //mCycles = a.getFloat(com.android.internal.R.styleable.CycleInterpolator_cycles, 1.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.105 -0400", hash_original_method = "C854E7122C234C45B08A1B645C47BE34", hash_generated_method = "AAD57EFCB7A0E71A67780940B701C2E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float input) {
        dsTaint.addTaint(input);
        float var562DE128661521933BE69E8098B2C6D5_712687738 = ((float)(Math.sin(2 * mCycles * Math.PI * input)));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float)(Math.sin(2 * mCycles * Math.PI * input));
    }

    
}

