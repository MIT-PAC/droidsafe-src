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

public class TranslateAnimation extends Animation {
    private int mFromXType = ABSOLUTE;
    private int mToXType = ABSOLUTE;
    private int mFromYType = ABSOLUTE;
    private int mToYType = ABSOLUTE;
    private float mFromXValue = 0.0f;
    private float mToXValue = 0.0f;
    private float mFromYValue = 0.0f;
    private float mToYValue = 0.0f;
    private float mFromXDelta;
    private float mToXDelta;
    private float mFromYDelta;
    private float mToYDelta;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.207 -0400", hash_original_method = "A16A4EA57E6F92D9F93733BFB1359F59", hash_generated_method = "25601DD3B32B270B8F398E82453F47E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TranslateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TranslateAnimation);
        Description d;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.TranslateAnimation_fromXDelta));
        mFromXType = d.type;
        mFromXValue = d.value;
        d = Description.parseValue(a.peekValue(
                com.android.internal.R.styleable.TranslateAnimation_toXDelta));
        mToXType = d.type;
        mToXValue = d.value;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.TranslateAnimation_fromYDelta));
        mFromYType = d.type;
        mFromYValue = d.value;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.TranslateAnimation_toYDelta));
        mToYType = d.type;
        mToYValue = d.value;
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.207 -0400", hash_original_method = "3F07A84DAAC1EE50E22F719B3019603F", hash_generated_method = "A352B2B0F6E44B5EEEB800B1B90F6B17")
    @DSModeled(DSC.SAFE)
    public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        dsTaint.addTaint(toYDelta);
        dsTaint.addTaint(fromYDelta);
        dsTaint.addTaint(toXDelta);
        dsTaint.addTaint(fromXDelta);
        mFromXType = ABSOLUTE;
        mToXType = ABSOLUTE;
        mFromYType = ABSOLUTE;
        mToYType = ABSOLUTE;
        // ---------- Original Method ----------
        //mFromXValue = fromXDelta;
        //mToXValue = toXDelta;
        //mFromYValue = fromYDelta;
        //mToYValue = toYDelta;
        //mFromXType = ABSOLUTE;
        //mToXType = ABSOLUTE;
        //mFromYType = ABSOLUTE;
        //mToYType = ABSOLUTE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.207 -0400", hash_original_method = "D0D15BEA3C16DDFD23FD148FD42664E4", hash_generated_method = "4D4A10A0EDAB9C0359B11EDD67DB5CA3")
    @DSModeled(DSC.SAFE)
    public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
            int fromYType, float fromYValue, int toYType, float toYValue) {
        dsTaint.addTaint(fromYType);
        dsTaint.addTaint(fromXValue);
        dsTaint.addTaint(toXValue);
        dsTaint.addTaint(toYType);
        dsTaint.addTaint(toXType);
        dsTaint.addTaint(toYValue);
        dsTaint.addTaint(fromYValue);
        dsTaint.addTaint(fromXType);
        // ---------- Original Method ----------
        //mFromXValue = fromXValue;
        //mToXValue = toXValue;
        //mFromYValue = fromYValue;
        //mToYValue = toYValue;
        //mFromXType = fromXType;
        //mToXType = toXType;
        //mFromYType = fromYType;
        //mToYType = toYType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.207 -0400", hash_original_method = "A766E69C82E8D177EAD959BF3BB9235A", hash_generated_method = "917DFEB81D710CB1EA5D8A0B6A517BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        float dx;
        dx = mFromXDelta;
        float dy;
        dy = mFromYDelta;
        {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        } //End block
        {
            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        } //End block
        t.getMatrix().setTranslate(dx, dy);
        // ---------- Original Method ----------
        //float dx = mFromXDelta;
        //float dy = mFromYDelta;
        //if (mFromXDelta != mToXDelta) {
            //dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        //}
        //if (mFromYDelta != mToYDelta) {
            //dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        //}
        //t.getMatrix().setTranslate(dx, dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.208 -0400", hash_original_method = "8DB34CFBDCDCD857D21DC05DC5D03D8B", hash_generated_method = "6D90285807939228B35AE74788E14857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(parentWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(parentHeight);
        super.initialize(width, height, parentWidth, parentHeight);
        mFromXDelta = resolveSize(mFromXType, mFromXValue, width, parentWidth);
        mToXDelta = resolveSize(mToXType, mToXValue, width, parentWidth);
        mFromYDelta = resolveSize(mFromYType, mFromYValue, height, parentHeight);
        mToYDelta = resolveSize(mToYType, mToYValue, height, parentHeight);
        // ---------- Original Method ----------
        //super.initialize(width, height, parentWidth, parentHeight);
        //mFromXDelta = resolveSize(mFromXType, mFromXValue, width, parentWidth);
        //mToXDelta = resolveSize(mToXType, mToXValue, width, parentWidth);
        //mFromYDelta = resolveSize(mFromYType, mFromYValue, height, parentHeight);
        //mToYDelta = resolveSize(mToYType, mToYValue, height, parentHeight);
    }

    
}

