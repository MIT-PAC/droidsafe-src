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

public class RotateAnimation extends Animation {
    private float mFromDegrees;
    private float mToDegrees;
    private int mPivotXType = ABSOLUTE;
    private int mPivotYType = ABSOLUTE;
    private float mPivotXValue = 0.0f;
    private float mPivotYValue = 0.0f;
    private float mPivotX;
    private float mPivotY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.166 -0400", hash_original_method = "B7950BF16E5DA5C93A26B94851E70CDD", hash_generated_method = "EF20AAB3B44B5761DF70B14D19CE1940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RotateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.RotateAnimation);
        mFromDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateAnimation_fromDegrees, 0.0f);
        mToDegrees = a.getFloat(com.android.internal.R.styleable.RotateAnimation_toDegrees, 0.0f);
        Description d;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.RotateAnimation_pivotX));
        mPivotXType = d.type;
        mPivotXValue = d.value;
        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.RotateAnimation_pivotY));
        mPivotYType = d.type;
        mPivotYValue = d.value;
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.RotateAnimation);
        //mFromDegrees = a.getFloat(
                //com.android.internal.R.styleable.RotateAnimation_fromDegrees, 0.0f);
        //mToDegrees = a.getFloat(com.android.internal.R.styleable.RotateAnimation_toDegrees, 0.0f);
        //Description d = Description.parseValue(a.peekValue(
            //com.android.internal.R.styleable.RotateAnimation_pivotX));
        //mPivotXType = d.type;
        //mPivotXValue = d.value;
        //d = Description.parseValue(a.peekValue(
            //com.android.internal.R.styleable.RotateAnimation_pivotY));
        //mPivotYType = d.type;
        //mPivotYValue = d.value;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.166 -0400", hash_original_method = "F93E828358C80C590EEB448A5EA60EF3", hash_generated_method = "EDF8B375281118D8073CFFF42C352242")
    @DSModeled(DSC.SAFE)
    public RotateAnimation(float fromDegrees, float toDegrees) {
        dsTaint.addTaint(fromDegrees);
        dsTaint.addTaint(toDegrees);
        mPivotX = 0.0f;
        mPivotY = 0.0f;
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotX = 0.0f;
        //mPivotY = 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.167 -0400", hash_original_method = "19A86326052CAD17DE162EF74120BA6A", hash_generated_method = "91C67F6695B740565057A7106CE870F2")
    @DSModeled(DSC.SAFE)
    public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) {
        dsTaint.addTaint(fromDegrees);
        dsTaint.addTaint(pivotX);
        dsTaint.addTaint(pivotY);
        dsTaint.addTaint(toDegrees);
        mPivotXType = ABSOLUTE;
        mPivotYType = ABSOLUTE;
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotXType = ABSOLUTE;
        //mPivotYType = ABSOLUTE;
        //mPivotXValue = pivotX;
        //mPivotYValue = pivotY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.167 -0400", hash_original_method = "72ECE06422A744A3901DF4DB74918F78", hash_generated_method = "9AD0950384E5F2F78DB96ED9E87754E6")
    @DSModeled(DSC.SAFE)
    public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
            int pivotYType, float pivotYValue) {
        dsTaint.addTaint(fromDegrees);
        dsTaint.addTaint(pivotYType);
        dsTaint.addTaint(pivotYValue);
        dsTaint.addTaint(pivotXValue);
        dsTaint.addTaint(pivotXType);
        dsTaint.addTaint(toDegrees);
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotXValue = pivotXValue;
        //mPivotXType = pivotXType;
        //mPivotYValue = pivotYValue;
        //mPivotYType = pivotYType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.167 -0400", hash_original_method = "194AFADB87C10F3B1916BACFE93A5B2C", hash_generated_method = "4802F3E068D377608DEA9E9956B50A9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(interpolatedTime);
        float degrees;
        degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        float scale;
        scale = getScaleFactor();
        {
            t.getMatrix().setRotate(degrees);
        } //End block
        {
            t.getMatrix().setRotate(degrees, mPivotX * scale, mPivotY * scale);
        } //End block
        // ---------- Original Method ----------
        //float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        //float scale = getScaleFactor();
        //if (mPivotX == 0.0f && mPivotY == 0.0f) {
            //t.getMatrix().setRotate(degrees);
        //} else {
            //t.getMatrix().setRotate(degrees, mPivotX * scale, mPivotY * scale);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.167 -0400", hash_original_method = "45493CF0F005891678EBD20A791168F1", hash_generated_method = "DA5AA1D3C8C649966B2EA728235ACA8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(parentWidth);
        dsTaint.addTaint(width);
        dsTaint.addTaint(parentHeight);
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
        // ---------- Original Method ----------
        //super.initialize(width, height, parentWidth, parentHeight);
        //mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        //mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }

    
}

