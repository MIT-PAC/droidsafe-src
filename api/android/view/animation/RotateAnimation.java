package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class RotateAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "A15722F5083687A94AEBECFD3C44711E", hash_generated_field = "F09C4FDC9F6C8A1D9CB749F5F6E5EB01")

    private float mFromDegrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "F12DDB33947BE4AD8AACC9EB5D42D418", hash_generated_field = "A38FA34A09FF84CE5329199DB304846C")

    private float mToDegrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "4B9436C45F4B7D7C4C9D04B918C8A0DD", hash_generated_field = "EC74AC06B5691B47A1AD5BBF6B15ECE3")

    private int mPivotXType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "3F1C9FB4BA67D4E05339F28A943BFC6E", hash_generated_field = "C9A99ED0A354C0C74E5E29006BD9ED31")

    private int mPivotYType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "8D8BFEB1DA7B8A0B2979A96EE34F4D2C", hash_generated_field = "AF755B8408C979E36D20FBC0A81E876D")

    private float mPivotXValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "A1F855333DF1E4EF5B69460F3BFFF0D1", hash_generated_field = "E9B533B02C8C2E2321EBFE6D7C3F6C50")

    private float mPivotYValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "D5598B4EF8A215EC3A51B2F400B272F3")

    private float mPivotX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.922 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "0971400EDE5A41D2136C532E521A2E57")

    private float mPivotY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.923 -0400", hash_original_method = "B7950BF16E5DA5C93A26B94851E70CDD", hash_generated_method = "6710F3E1A38977FDA17C23E2AC15D2DC")
    public  RotateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.RotateAnimation);
        mFromDegrees = a.getFloat(
                com.android.internal.R.styleable.RotateAnimation_fromDegrees, 0.0f);
        mToDegrees = a.getFloat(com.android.internal.R.styleable.RotateAnimation_toDegrees, 0.0f);
        Description d = Description.parseValue(a.peekValue(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.924 -0400", hash_original_method = "F93E828358C80C590EEB448A5EA60EF3", hash_generated_method = "C676D9303416F964F963833EFA0F7DEE")
    public  RotateAnimation(float fromDegrees, float toDegrees) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mPivotX = 0.0f;
        mPivotY = 0.0f;
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotX = 0.0f;
        //mPivotY = 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.925 -0400", hash_original_method = "19A86326052CAD17DE162EF74120BA6A", hash_generated_method = "EFE11A3109A54F1122A453C75C28FC74")
    public  RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mPivotXType = ABSOLUTE;
        mPivotYType = ABSOLUTE;
        mPivotXValue = pivotX;
        mPivotYValue = pivotY;
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotXType = ABSOLUTE;
        //mPivotYType = ABSOLUTE;
        //mPivotXValue = pivotX;
        //mPivotYValue = pivotY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.926 -0400", hash_original_method = "72ECE06422A744A3901DF4DB74918F78", hash_generated_method = "895C542E1008EB5525AB8D4C914CF5A2")
    public  RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
            int pivotYType, float pivotYValue) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mPivotXValue = pivotXValue;
        mPivotXType = pivotXType;
        mPivotYValue = pivotYValue;
        mPivotYType = pivotYType;
        // ---------- Original Method ----------
        //mFromDegrees = fromDegrees;
        //mToDegrees = toDegrees;
        //mPivotXValue = pivotXValue;
        //mPivotXType = pivotXType;
        //mPivotYValue = pivotYValue;
        //mPivotYType = pivotYType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.927 -0400", hash_original_method = "194AFADB87C10F3B1916BACFE93A5B2C", hash_generated_method = "DC9217BB35C7E656A933D57EF603F811")
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(interpolatedTime);
        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        float scale = getScaleFactor();
    if(mPivotX == 0.0f && mPivotY == 0.0f)        
        {
            t.getMatrix().setRotate(degrees);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.928 -0400", hash_original_method = "45493CF0F005891678EBD20A791168F1", hash_generated_method = "53783E9B1C23799F49072FEC34253244")
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
        // ---------- Original Method ----------
        //super.initialize(width, height, parentWidth, parentHeight);
        //mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        //mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }

    
}

