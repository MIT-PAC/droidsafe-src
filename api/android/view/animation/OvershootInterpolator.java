package android.view.animation;

// Droidsafe Imports
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class OvershootInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.042 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.043 -0400", hash_original_method = "3B6B46657965F6A20EBA4BBC6ADB2DCC", hash_generated_method = "A80BEDF24C62F5BB949AF4EB0447BF7C")
    @DSModeled(DSC.SAFE)
    public  OvershootInterpolator() {
        mTension = 2.0f;
        // ---------- Original Method ----------
        //mTension = 2.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.043 -0400", hash_original_method = "AC62500F6876F098739AD852AB3DA2C8", hash_generated_method = "3342901F331D73E8DB6BB4CD2D2DD8A1")
    @DSModeled(DSC.SAFE)
    public  OvershootInterpolator(float tension) {
        mTension = tension;
        // ---------- Original Method ----------
        //mTension = tension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.043 -0400", hash_original_method = "26239DC2C12BB0FDD838BBF27F5324A3", hash_generated_method = "9E20B1D2935C1C8AB84931C63977F2C6")
    @DSModeled(DSC.SAFE)
    public  OvershootInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.OvershootInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.OvershootInterpolator);
        //mTension =
                //a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);
        //a.recycle();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.044 -0400", hash_original_method = "F21DD3F51BCD131DFD1A0AC343B5C733", hash_generated_method = "79ECC5DCA6621FB71D0B09739E1E579A")
    public float getInterpolation(float t) {
        addTaint(t);
        t -= 1.0f;
        float varB2F2167E677D9EF4EFAE76678AB7AF9C_137861302 = (t * t * ((mTension + 1) * t + mTension) + 1.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_545506456 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_545506456;
        // ---------- Original Method ----------
        //t -= 1.0f;
        //return t * t * ((mTension + 1) * t + mTension) + 1.0f;
    }

    
}

