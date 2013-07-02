package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AnticipateInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.430 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.430 -0400", hash_original_method = "7C2506D70A86643AB33B7796EA331F9D", hash_generated_method = "761E0AC6C5BE23250969F07445914E84")
    public  AnticipateInterpolator() {
        mTension = 2.0f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.430 -0400", hash_original_method = "9BAE6E66C77EF37188591BAA368F1B92", hash_generated_method = "41BB8ADF848B4D75A305C8076C5221D1")
    public  AnticipateInterpolator(float tension) {
        mTension = tension;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.430 -0400", hash_original_method = "82BFA8AC47DF9DDA6D8E3F7FE8B02F6B", hash_generated_method = "A9A97D0551CB04E264C72C145203ED4D")
    public  AnticipateInterpolator(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AnticipateInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.AnticipateInterpolator_tension, 2.0f);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
                
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:02.431 -0400", hash_original_method = "708C87963D95E01AE56D23D7408FFDE5", hash_generated_method = "6A8307AC1FD18055818FFBB10C601264")
    public float getInterpolation(float t) {
        addTaint(t);
        float var546ADE640B6EDFBC8A086EF31347E768_1605436697 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1605436697;
        
        
    }

    
}

