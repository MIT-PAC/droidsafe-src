package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_extraTension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_tension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator;

public class AnticipateOvershootInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.445 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.445 -0400", hash_original_method = "ADFB7B1CA7D165BA838134D2684973F5", hash_generated_method = "9F5D05CDCB4B5CB1ADE17DC42E2BEF6C")
    public  AnticipateOvershootInterpolator() {
        mTension = 2.0f * 1.5f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.445 -0400", hash_original_method = "D15CF2E61548D6019F2AF4E90A4CFAB6", hash_generated_method = "D99C2C79B93882790F7B932B057E00D6")
    public  AnticipateOvershootInterpolator(float tension) {
        mTension = tension * 1.5f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.445 -0400", hash_original_method = "3EEBC4A7EE7237033C6CB68A91DD57AF", hash_generated_method = "E9CCD84715D8B7DFD848411354DE56BA")
    public  AnticipateOvershootInterpolator(float tension, float extraTension) {
        mTension = tension * extraTension;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.446 -0400", hash_original_method = "390B8CC1565A1D66C861EB72B2EF6A9A", hash_generated_method = "CC08B9EED88EB1E91148EAF11EA48BD6")
    public  AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static float a(float t, float s) {
        return t * t * ((s + 1) * t - s);
    }

    
    @DSModeled(DSC.SAFE)
    private static float o(float t, float s) {
        return t * t * ((s + 1) * t + s);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.446 -0400", hash_original_method = "2255DD32EB6AB62491E070729AD8FA55", hash_generated_method = "2AF9421D3383D09E5D9907FA826D6446")
    public float getInterpolation(float t) {
        float var4D22A2546DC500EBE319D50671525B44_386467666 = (0.5f * a(t * 2.0f, mTension));
        float var02159358DD7855912AE0F9BDD748D3B4_1949951369 = (0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f));
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_543562966 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_543562966;
        
        
        
    }

    
}

