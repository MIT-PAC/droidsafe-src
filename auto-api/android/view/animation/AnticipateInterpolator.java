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

public class AnticipateInterpolator implements Interpolator {
    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.060 -0400", hash_original_method = "7C2506D70A86643AB33B7796EA331F9D", hash_generated_method = "761E0AC6C5BE23250969F07445914E84")
    @DSModeled(DSC.SAFE)
    public AnticipateInterpolator() {
        mTension = 2.0f;
        // ---------- Original Method ----------
        //mTension = 2.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.060 -0400", hash_original_method = "9BAE6E66C77EF37188591BAA368F1B92", hash_generated_method = "5A29409BC655F60AEC84431D75F140FB")
    @DSModeled(DSC.SAFE)
    public AnticipateInterpolator(float tension) {
        dsTaint.addTaint(tension);
        // ---------- Original Method ----------
        //mTension = tension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.060 -0400", hash_original_method = "82BFA8AC47DF9DDA6D8E3F7FE8B02F6B", hash_generated_method = "6BCE974CD99ED71B78311751F5FD33C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AnticipateInterpolator(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AnticipateInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.AnticipateInterpolator_tension, 2.0f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.AnticipateInterpolator);
        //mTension =
                //a.getFloat(com.android.internal.R.styleable.AnticipateInterpolator_tension, 2.0f);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.060 -0400", hash_original_method = "708C87963D95E01AE56D23D7408FFDE5", hash_generated_method = "669B9D84E2A1596C9DFBA955A5E45ECF")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float t) {
        dsTaint.addTaint(t);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return t * t * ((mTension + 1) * t - mTension);
    }

    
}

