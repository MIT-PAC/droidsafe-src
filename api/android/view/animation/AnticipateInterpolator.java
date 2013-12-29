package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;





public class AnticipateInterpolator implements Interpolator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.997 -0500", hash_original_field = "8768F20F89FEA365257D9CA7103B2BB5", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private  float mTension;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.998 -0500", hash_original_method = "7C2506D70A86643AB33B7796EA331F9D", hash_generated_method = "56386AE77777F64CC46CB677C4AD5216")
    public AnticipateInterpolator() {
        mTension = 2.0f;
    }

    /**
     * @param tension Amount of anticipation. When tension equals 0.0f, there is
     *                no anticipation and the interpolator becomes a simple
     *                acceleration interpolator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:26.999 -0500", hash_original_method = "9BAE6E66C77EF37188591BAA368F1B92", hash_generated_method = "C018AC8FC72D77E4614785DD14807538")
    public AnticipateInterpolator(float tension) {
        mTension = tension;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.000 -0500", hash_original_method = "82BFA8AC47DF9DDA6D8E3F7FE8B02F6B", hash_generated_method = "9845E06A81ABD3C9150462EB3DC34A84")
    public AnticipateInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AnticipateInterpolator);

        mTension =
                a.getFloat(com.android.internal.R.styleable.AnticipateInterpolator_tension, 2.0f);

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:27.000 -0500", hash_original_method = "708C87963D95E01AE56D23D7408FFDE5", hash_generated_method = "AFF8D259EE2AC025B68E37A702DB5284")
    public float getInterpolation(float t) {
        // a(t) = t * t * ((tension + 1) * t - tension)
        return t * t * ((mTension + 1) * t - mTension);
    }

    
}

