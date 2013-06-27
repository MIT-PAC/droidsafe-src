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

public class OvershootInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.429 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.430 -0400", hash_original_method = "3B6B46657965F6A20EBA4BBC6ADB2DCC", hash_generated_method = "A80BEDF24C62F5BB949AF4EB0447BF7C")
    public  OvershootInterpolator() {
        mTension = 2.0f;
        // ---------- Original Method ----------
        //mTension = 2.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.430 -0400", hash_original_method = "AC62500F6876F098739AD852AB3DA2C8", hash_generated_method = "3342901F331D73E8DB6BB4CD2D2DD8A1")
    public  OvershootInterpolator(float tension) {
        mTension = tension;
        // ---------- Original Method ----------
        //mTension = tension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.431 -0400", hash_original_method = "26239DC2C12BB0FDD838BBF27F5324A3", hash_generated_method = "0B8834CD3CD3163286A9347BD0412454")
    public  OvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.OvershootInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.OvershootInterpolator);
        //mTension =
                //a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:55.448 -0400", hash_original_method = "F21DD3F51BCD131DFD1A0AC343B5C733", hash_generated_method = "75BA251C4C1E005EEA0FDA775CEA2B14")
    public float getInterpolation(float t) {
        t -= 1.0f;
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_308079366 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_308079366;
        // ---------- Original Method ----------
        //t -= 1.0f;
        //return t * t * ((mTension + 1) * t + mTension) + 1.0f;
    }

    
}

