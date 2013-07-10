package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class OvershootInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.705 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.705 -0400", hash_original_method = "3B6B46657965F6A20EBA4BBC6ADB2DCC", hash_generated_method = "A80BEDF24C62F5BB949AF4EB0447BF7C")
    public  OvershootInterpolator() {
        mTension = 2.0f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.705 -0400", hash_original_method = "AC62500F6876F098739AD852AB3DA2C8", hash_generated_method = "3342901F331D73E8DB6BB4CD2D2DD8A1")
    public  OvershootInterpolator(float tension) {
        mTension = tension;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.706 -0400", hash_original_method = "26239DC2C12BB0FDD838BBF27F5324A3", hash_generated_method = "DDE1446848FE9BB4299CF78AFDB8CBD6")
    public  OvershootInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.OvershootInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.OvershootInterpolator_tension, 2.0f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.706 -0400", hash_original_method = "F21DD3F51BCD131DFD1A0AC343B5C733", hash_generated_method = "758C516160CB847B7ACA79EF0B918D3E")
    public float getInterpolation(float t) {
        t -= 1.0f;
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_882164432 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_882164432;
        
        
        
    }

    
}

