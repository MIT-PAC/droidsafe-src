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
    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.157 -0400", hash_original_method = "3B6B46657965F6A20EBA4BBC6ADB2DCC", hash_generated_method = "A80BEDF24C62F5BB949AF4EB0447BF7C")
    @DSModeled(DSC.SAFE)
    public OvershootInterpolator() {
        mTension = 2.0f;
        // ---------- Original Method ----------
        //mTension = 2.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.157 -0400", hash_original_method = "AC62500F6876F098739AD852AB3DA2C8", hash_generated_method = "BA6550B9A799BAA9F6D6A713F85BC213")
    @DSModeled(DSC.SAFE)
    public OvershootInterpolator(float tension) {
        dsTaint.addTaint(tension);
        // ---------- Original Method ----------
        //mTension = tension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.158 -0400", hash_original_method = "26239DC2C12BB0FDD838BBF27F5324A3", hash_generated_method = "EB7DE21D975C7B21867605029F8C212B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OvershootInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.158 -0400", hash_original_method = "F21DD3F51BCD131DFD1A0AC343B5C733", hash_generated_method = "4346C7218FA7FFF5DB2CBA11CA9BBCD3")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float t) {
        dsTaint.addTaint(t);
        t -= 1.0f;
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //t -= 1.0f;
        //return t * t * ((mTension + 1) * t + mTension) + 1.0f;
    }

    
}

