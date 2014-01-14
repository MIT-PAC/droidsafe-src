package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_extraTension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_tension;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AnticipateOvershootInterpolator implements Interpolator {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.625 -0500", hash_original_method = "A804F4B2D6C0DDE24A4B9DBFE10616E4", hash_generated_method = "357F270F6A0E934E160F9377E73A1B66")
    
private static float a(float t, float s) {
        return t * t * ((s + 1) * t - s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.628 -0500", hash_original_method = "CCFF6DF9EE8C4A0C6417FACC9D2DDD5B", hash_generated_method = "F182AC0DEBE3773636CFD180E4E4FC00")
    
private static float o(float t, float s) {
        return t * t * ((s + 1) * t + s);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.612 -0500", hash_original_field = "8768F20F89FEA365257D9CA7103B2BB5", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private  float mTension;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.615 -0500", hash_original_method = "ADFB7B1CA7D165BA838134D2684973F5", hash_generated_method = "922D6BCD7E48564F6BB97F43A8785749")
    
public AnticipateOvershootInterpolator() {
        mTension = 2.0f * 1.5f;
    }

    /**
     * @param tension Amount of anticipation/overshoot. When tension equals 0.0f,
     *                there is no anticipation/overshoot and the interpolator becomes
     *                a simple acceleration/deceleration interpolator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.617 -0500", hash_original_method = "D15CF2E61548D6019F2AF4E90A4CFAB6", hash_generated_method = "380001BE6766A89D9EAA979FEADDD42C")
    
public AnticipateOvershootInterpolator(float tension) {
        mTension = tension * 1.5f;
    }

    /**
     * @param tension Amount of anticipation/overshoot. When tension equals 0.0f,
     *                there is no anticipation/overshoot and the interpolator becomes
     *                a simple acceleration/deceleration interpolator.
     * @param extraTension Amount by which to multiply the tension. For instance,
     *                     to get the same overshoot as an OvershootInterpolator with
     *                     a tension of 2.0f, you would use an extraTension of 1.5f.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.620 -0500", hash_original_method = "3EEBC4A7EE7237033C6CB68A91DD57AF", hash_generated_method = "88440E4C527104688EDD960127521C84")
    
public AnticipateOvershootInterpolator(float tension, float extraTension) {
        mTension = tension * extraTension;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.623 -0500", hash_original_method = "390B8CC1565A1D66C861EB72B2EF6A9A", hash_generated_method = "9719C9ACD527928BA5A6767464C23AAE")
    
public AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);

        mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);

        a.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:59.631 -0500", hash_original_method = "2255DD32EB6AB62491E070729AD8FA55", hash_generated_method = "6AC09E7923C11621C591AE16BBAB1E35")
    
public float getInterpolation(float t) {
        // a(t, s) = t * t * ((s + 1) * t - s)
        // o(t, s) = t * t * ((s + 1) * t + s)
        // f(t) = 0.5 * a(t * 2, tension * extraTension), when t < 0.5
        // f(t) = 0.5 * (o(t * 2 - 2, tension * extraTension) + 2), when t <= 1.0
        if (t < 0.5f) return 0.5f * a(t * 2.0f, mTension);
        else return 0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f);
    }
    
}

