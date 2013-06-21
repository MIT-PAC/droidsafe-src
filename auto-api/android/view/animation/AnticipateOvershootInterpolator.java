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
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_extraTension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_tension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator;

public class AnticipateOvershootInterpolator implements Interpolator {
    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.098 -0400", hash_original_method = "ADFB7B1CA7D165BA838134D2684973F5", hash_generated_method = "9F5D05CDCB4B5CB1ADE17DC42E2BEF6C")
    @DSModeled(DSC.SAFE)
    public AnticipateOvershootInterpolator() {
        mTension = 2.0f * 1.5f;
        // ---------- Original Method ----------
        //mTension = 2.0f * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.098 -0400", hash_original_method = "D15CF2E61548D6019F2AF4E90A4CFAB6", hash_generated_method = "D8EC1D94BDAAEDC94A6E1061D4732A4C")
    @DSModeled(DSC.SAFE)
    public AnticipateOvershootInterpolator(float tension) {
        dsTaint.addTaint(tension);
        mTension = tension * 1.5f;
        // ---------- Original Method ----------
        //mTension = tension * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.099 -0400", hash_original_method = "3EEBC4A7EE7237033C6CB68A91DD57AF", hash_generated_method = "23C7E2BFC73EC9A8AD4C3C8B4DC4C9F5")
    @DSModeled(DSC.SAFE)
    public AnticipateOvershootInterpolator(float tension, float extraTension) {
        dsTaint.addTaint(extraTension);
        dsTaint.addTaint(tension);
        mTension = tension * extraTension;
        // ---------- Original Method ----------
        //mTension = tension * extraTension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.099 -0400", hash_original_method = "390B8CC1565A1D66C861EB72B2EF6A9A", hash_generated_method = "2811B6F28EECC6EE16FCAF94664ED1F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        //mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                //a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        //a.recycle();
    }

    
        private static float a(float t, float s) {
        return t * t * ((s + 1) * t - s);
    }

    
        private static float o(float t, float s) {
        return t * t * ((s + 1) * t + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.101 -0400", hash_original_method = "2255DD32EB6AB62491E070729AD8FA55", hash_generated_method = "3027FEA68210DEAE11221CC39327DA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getInterpolation(float t) {
        dsTaint.addTaint(t);
        float var4D22A2546DC500EBE319D50671525B44_353989792 = (0.5f * a(t * 2.0f, mTension));
        float var02159358DD7855912AE0F9BDD748D3B4_1951134285 = (0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (t < 0.5f) return 0.5f * a(t * 2.0f, mTension);
        //else return 0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f);
    }

    
}

