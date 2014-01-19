package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class OvershootInterpolator implements Interpolator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.407 -0500", hash_original_field = "8768F20F89FEA365257D9CA7103B2BB5", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private  float mTension;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.409 -0500", hash_original_method = "3B6B46657965F6A20EBA4BBC6ADB2DCC", hash_generated_method = "73002248E41892E5A1F876CA5B1EB772")
    
public OvershootInterpolator() {
        mTension = 2.0f;
    }

    /**
     * @param tension Amount of overshoot. When tension equals 0.0f, there is
     *                no overshoot and the interpolator becomes a simple
     *                deceleration interpolator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.412 -0500", hash_original_method = "AC62500F6876F098739AD852AB3DA2C8", hash_generated_method = "4EC0B868297773A4F63E4C0892D19151")
    
public OvershootInterpolator(float tension) {
        mTension = tension;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.414 -0500", hash_original_method = "26239DC2C12BB0FDD838BBF27F5324A3", hash_generated_method = "7B9C1A517207FE7F294FC5F9A5FA8E83")
    
public OvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.OvershootInterpolator);

        mTension =
                a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);

        a.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.417 -0500", hash_original_method = "F21DD3F51BCD131DFD1A0AC343B5C733", hash_generated_method = "3DC77BA128FDB24C8E93C4EE335FD934")
    
public float getInterpolation(float t) {
        // _o(t) = t * t * ((tension + 1) * t + tension)
        // o(t) = _o(t - 1) + 1
        t -= 1.0f;
        return t * t * ((mTension + 1) * t + mTension) + 1.0f;
    }
    
}

