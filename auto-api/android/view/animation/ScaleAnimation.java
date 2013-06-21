package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

public class ScaleAnimation extends Animation {
    private Resources mResources;
    private float mFromX;
    private float mToX;
    private float mFromY;
    private float mToY;
    private int mFromXType = TypedValue.TYPE_NULL;
    private int mToXType = TypedValue.TYPE_NULL;
    private int mFromYType = TypedValue.TYPE_NULL;
    private int mToYType = TypedValue.TYPE_NULL;
    private int mFromXData = 0;
    private int mToXData = 0;
    private int mFromYData = 0;
    private int mToYData = 0;
    private int mPivotXType = ABSOLUTE;
    private int mPivotYType = ABSOLUTE;
    private float mPivotXValue = 0.0f;
    private float mPivotYValue = 0.0f;
    private float mPivotX;
    private float mPivotY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.184 -0400", hash_original_method = "E7EC7911EB152736ED90DFA69DF1393A", hash_generated_method = "2DBA0CDC8D0894D3D4DD4F0EEA90E41C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mResources = context.getResources();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ScaleAnimation);
        TypedValue tv;
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromXScale);
        mFromX = 0.0f;
        {
            {
                mFromX = tv.getFloat();
            } //End block
            {
                mFromXType = tv.type;
                mFromXData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toXScale);
        mToX = 0.0f;
        {
            {
                mToX = tv.getFloat();
            } //End block
            {
                mToXType = tv.type;
                mToXData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromYScale);
        mFromY = 0.0f;
        {
            {
                mFromY = tv.getFloat();
            } //End block
            {
                mFromYType = tv.type;
                mFromYData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toYScale);
        mToY = 0.0f;
        {
            {
                mToY = tv.getFloat();
            } //End block
            {
                mToYType = tv.type;
                mToYData = tv.data;
            } //End block
        } //End block
        Description d;
        d = Description.parseValue(a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_pivotX));
        mPivotXType = d.type;
        mPivotXValue = d.value;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.ScaleAnimation_pivotY));
        mPivotYType = d.type;
        mPivotYValue = d.value;
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.185 -0400", hash_original_method = "512F0A59662E426B1B9BCA8ED3066806", hash_generated_method = "5F26CD492783174BCCF3F237B5CF490A")
    @DSModeled(DSC.SAFE)
    public ScaleAnimation(float fromX, float toX, float fromY, float toY) {
        dsTaint.addTaint(toX);
        dsTaint.addTaint(toY);
        dsTaint.addTaint(fromX);
        dsTaint.addTaint(fromY);
        mResources = null;
        mPivotX = 0;
        mPivotY = 0;
        // ---------- Original Method ----------
        //mResources = null;
        //mFromX = fromX;
        //mToX = toX;
        //mFromY = fromY;
        //mToY = toY;
        //mPivotX = 0;
        //mPivotY = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.185 -0400", hash_original_method = "E87B1195FC877E2731C7B2475118F4DC", hash_generated_method = "5D8F2AF34AD2E4464D9E2D0A524E4468")
    @DSModeled(DSC.SAFE)
    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
            float pivotX, float pivotY) {
        dsTaint.addTaint(toX);
        dsTaint.addTaint(pivotX);
        dsTaint.addTaint(toY);
        dsTaint.addTaint(pivotY);
        dsTaint.addTaint(fromX);
        dsTaint.addTaint(fromY);
        mResources = null;
        mPivotXType = ABSOLUTE;
        mPivotYType = ABSOLUTE;
        // ---------- Original Method ----------
        //mResources = null;
        //mFromX = fromX;
        //mToX = toX;
        //mFromY = fromY;
        //mToY = toY;
        //mPivotXType = ABSOLUTE;
        //mPivotYType = ABSOLUTE;
        //mPivotXValue = pivotX;
        //mPivotYValue = pivotY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.186 -0400", hash_original_method = "D69E90D5037F2660E180F2C8AD5003B6", hash_generated_method = "4D58FEB0E1215E32895879FA263498DB")
    @DSModeled(DSC.SAFE)
    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        dsTaint.addTaint(toX);
        dsTaint.addTaint(pivotYType);
        dsTaint.addTaint(toY);
        dsTaint.addTaint(pivotYValue);
        dsTaint.addTaint(pivotXValue);
        dsTaint.addTaint(fromX);
        dsTaint.addTaint(fromY);
        dsTaint.addTaint(pivotXType);
        mResources = null;
        // ---------- Original Method ----------
        //mResources = null;
        //mFromX = fromX;
        //mToX = toX;
        //mFromY = fromY;
        //mToY = toY;
        //mPivotXValue = pivotXValue;
        //mPivotXType = pivotXType;
        //mPivotYValue = pivotYValue;
        //mPivotYType = pivotYType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.187 -0400", hash_original_method = "ACAB92B82483DFC255430C098BD55E9F", hash_generated_method = "9152C87F784C35B8E9BAEF6E0043CD84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        float sx;
        sx = 1.0f;
        float sy;
        sy = 1.0f;
        float scale;
        scale = getScaleFactor();
        {
            sx = mFromX + ((mToX - mFromX) * interpolatedTime);
        } //End block
        {
            sy = mFromY + ((mToY - mFromY) * interpolatedTime);
        } //End block
        {
            t.getMatrix().setScale(sx, sy);
        } //End block
        {
            t.getMatrix().setScale(sx, sy, scale * mPivotX, scale * mPivotY);
        } //End block
        // ---------- Original Method ----------
        //float sx = 1.0f;
        //float sy = 1.0f;
        //float scale = getScaleFactor();
        //if (mFromX != 1.0f || mToX != 1.0f) {
            //sx = mFromX + ((mToX - mFromX) * interpolatedTime);
        //}
        //if (mFromY != 1.0f || mToY != 1.0f) {
            //sy = mFromY + ((mToY - mFromY) * interpolatedTime);
        //}
        //if (mPivotX == 0 && mPivotY == 0) {
            //t.getMatrix().setScale(sx, sy);
        //} else {
            //t.getMatrix().setScale(sx, sy, scale * mPivotX, scale * mPivotY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.187 -0400", hash_original_method = "676CA3558C31BAAF0E94504390B45F7E", hash_generated_method = "6075C82DC0D46FD4ABEFDCE42A27741B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float resolveScale(float scale, int type, int data, int size, int psize) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(psize);
        dsTaint.addTaint(data);
        dsTaint.addTaint(type);
        dsTaint.addTaint(size);
        float targetSize;
        {
            targetSize = TypedValue.complexToFraction(data, size, psize);
        } //End block
        {
            targetSize = TypedValue.complexToDimension(data, mResources.getDisplayMetrics());
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float targetSize;
        //if (type == TypedValue.TYPE_FRACTION) {
            //targetSize = TypedValue.complexToFraction(data, size, psize);
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //targetSize = TypedValue.complexToDimension(data, mResources.getDisplayMetrics());
        //} else {
            //return scale;
        //}
        //if (size == 0) {
            //return 1;
        //}
        //return targetSize/(float)size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.188 -0400", hash_original_method = "E8174A29F113646F3F03DE9F1A1AE2A8", hash_generated_method = "50F9F758CC7992170A6C3618288A0972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(parentWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(parentHeight);
        super.initialize(width, height, parentWidth, parentHeight);
        mFromX = resolveScale(mFromX, mFromXType, mFromXData, width, parentWidth);
        mToX = resolveScale(mToX, mToXType, mToXData, width, parentWidth);
        mFromY = resolveScale(mFromY, mFromYType, mFromYData, height, parentHeight);
        mToY = resolveScale(mToY, mToYType, mToYData, height, parentHeight);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
        // ---------- Original Method ----------
        //super.initialize(width, height, parentWidth, parentHeight);
        //mFromX = resolveScale(mFromX, mFromXType, mFromXData, width, parentWidth);
        //mToX = resolveScale(mToX, mToXType, mToXData, width, parentWidth);
        //mFromY = resolveScale(mFromY, mFromYType, mFromYData, height, parentHeight);
        //mToY = resolveScale(mToY, mToYType, mToYData, height, parentHeight);
        //mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        //mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }

    
}

