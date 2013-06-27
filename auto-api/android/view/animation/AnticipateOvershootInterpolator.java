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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.498 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.510 -0400", hash_original_method = "ADFB7B1CA7D165BA838134D2684973F5", hash_generated_method = "9F5D05CDCB4B5CB1ADE17DC42E2BEF6C")
    public  AnticipateOvershootInterpolator() {
        mTension = 2.0f * 1.5f;
        // ---------- Original Method ----------
        //mTension = 2.0f * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.515 -0400", hash_original_method = "D15CF2E61548D6019F2AF4E90A4CFAB6", hash_generated_method = "D99C2C79B93882790F7B932B057E00D6")
    public  AnticipateOvershootInterpolator(float tension) {
        mTension = tension * 1.5f;
        // ---------- Original Method ----------
        //mTension = tension * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.516 -0400", hash_original_method = "3EEBC4A7EE7237033C6CB68A91DD57AF", hash_generated_method = "E9CCD84715D8B7DFD848411354DE56BA")
    public  AnticipateOvershootInterpolator(float tension, float extraTension) {
        mTension = tension * extraTension;
        // ---------- Original Method ----------
        //mTension = tension * extraTension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.517 -0400", hash_original_method = "390B8CC1565A1D66C861EB72B2EF6A9A", hash_generated_method = "A6F11FC37E41EC6C9D8C090DD4D22658")
    public  AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.518 -0400", hash_original_method = "2255DD32EB6AB62491E070729AD8FA55", hash_generated_method = "57B54120B468EB521E12BC49AB84C62D")
    public float getInterpolation(float t) {
        float var4D22A2546DC500EBE319D50671525B44_388000133 = (0.5f * a(t * 2.0f, mTension));
        float var02159358DD7855912AE0F9BDD748D3B4_393220403 = (0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f));
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_191014525 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_191014525;
        // ---------- Original Method ----------
        //if (t < 0.5f) return 0.5f * a(t * 2.0f, mTension);
        //else return 0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f);
    }

    
}

