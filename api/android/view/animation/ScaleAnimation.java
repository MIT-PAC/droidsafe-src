package android.view.animation;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;


public class ScaleAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "B7091BC0690A369B631C4AF140D8B159", hash_generated_field = "BB287F46785769B83860D56D8BE9EFD8")

    private float mFromX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "D864FCC57CCC50BB6242B14CE133C3B7", hash_generated_field = "04285F5086DF3EAF7703BA446BC7BACF")

    private float mToX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "1939E8650C0971B4FE5AE882E21D3729", hash_generated_field = "23FE8E016CC493D9EFEDB8A1C9A430E7")

    private float mFromY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "FAD1FB9CEA94C154D23406F00650BF27", hash_generated_field = "B32ECB78B8E715C7460739B27CA842E7")

    private float mToY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "B7B73D12CE3B9412F1A00109937D53DA", hash_generated_field = "EF5CCFA809ED96BE62A4E7398FA3E7EF")

    private int mFromXType = TypedValue.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "60CC0D53535479E0C7A9D501F5E4A0FC", hash_generated_field = "0DAB7BC0DD34C12139A64FA80B053006")

    private int mToXType = TypedValue.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "2F80A3ADA12E7A54C5C204588EF593F0", hash_generated_field = "D8BF40E0AE12F53A1AE0BE3E1CFAD3A4")

    private int mFromYType = TypedValue.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "1E7561A3A9EC0001918DDC90167EF387", hash_generated_field = "96D1562EC34C4AC02419D0A55158EC4D")

    private int mToYType = TypedValue.TYPE_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "4139ECFEEFACC0D8A88195A455CF45AB", hash_generated_field = "78C236BBF3AA3B138CA8A37DA32CAA60")

    private int mFromXData = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "242C328B6333C998429DE06D353EBE5C", hash_generated_field = "BFDE8B8EEB4894371DCD5E8AA633C493")

    private int mToXData = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "BBD337555245B463E61F4438DA8A92A9", hash_generated_field = "339253AB01E09DEEC240855896A6E360")

    private int mFromYData = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "E7864FD3E8DB8F12A4C5837E49C9B4AC", hash_generated_field = "D5DE9D4159C58D4EFB94DA518A494266")

    private int mToYData = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.112 -0400", hash_original_field = "4B9436C45F4B7D7C4C9D04B918C8A0DD", hash_generated_field = "EC74AC06B5691B47A1AD5BBF6B15ECE3")

    private int mPivotXType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.113 -0400", hash_original_field = "3F1C9FB4BA67D4E05339F28A943BFC6E", hash_generated_field = "C9A99ED0A354C0C74E5E29006BD9ED31")

    private int mPivotYType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.113 -0400", hash_original_field = "8D8BFEB1DA7B8A0B2979A96EE34F4D2C", hash_generated_field = "AF755B8408C979E36D20FBC0A81E876D")

    private float mPivotXValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.113 -0400", hash_original_field = "A1F855333DF1E4EF5B69460F3BFFF0D1", hash_generated_field = "E9B533B02C8C2E2321EBFE6D7C3F6C50")

    private float mPivotYValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.113 -0400", hash_original_field = "D66A9F2EFD98D68E75A6EA9E5E5D83DE", hash_generated_field = "D5598B4EF8A215EC3A51B2F400B272F3")

    private float mPivotX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.113 -0400", hash_original_field = "0AD24014D3E582A643E83C27A45B1B51", hash_generated_field = "0971400EDE5A41D2136C532E521A2E57")

    private float mPivotY;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.116 -0400", hash_original_method = "E7EC7911EB152736ED90DFA69DF1393A", hash_generated_method = "0B4BF7A655ECBD672E7DCE61265BBF39")
    public  ScaleAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        mResources = context.getResources();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ScaleAnimation);
        TypedValue tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromXScale);
        mFromX = 0.0f;
        if(tv != null)        
        {
            if(tv.type == TypedValue.TYPE_FLOAT)            
            {
                mFromX = tv.getFloat();
            } //End block
            else
            {
                mFromXType = tv.type;
                mFromXData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toXScale);
        mToX = 0.0f;
        if(tv != null)        
        {
            if(tv.type == TypedValue.TYPE_FLOAT)            
            {
                mToX = tv.getFloat();
            } //End block
            else
            {
                mToXType = tv.type;
                mToXData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromYScale);
        mFromY = 0.0f;
        if(tv != null)        
        {
            if(tv.type == TypedValue.TYPE_FLOAT)            
            {
                mFromY = tv.getFloat();
            } //End block
            else
            {
                mFromYType = tv.type;
                mFromYData = tv.data;
            } //End block
        } //End block
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toYScale);
        mToY = 0.0f;
        if(tv != null)        
        {
            if(tv.type == TypedValue.TYPE_FLOAT)            
            {
                mToY = tv.getFloat();
            } //End block
            else
            {
                mToYType = tv.type;
                mToYData = tv.data;
            } //End block
        } //End block
        Description d = Description.parseValue(a.peekValue(
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.118 -0400", hash_original_method = "512F0A59662E426B1B9BCA8ED3066806", hash_generated_method = "F4B1B691291C2CB057305BB1755A27CE")
    public  ScaleAnimation(float fromX, float toX, float fromY, float toY) {
        mResources = null;
        mFromX = fromX;
        mToX = toX;
        mFromY = fromY;
        mToY = toY;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.119 -0400", hash_original_method = "E87B1195FC877E2731C7B2475118F4DC", hash_generated_method = "7CADD6E5F23E503EA9E92E265142D072")
    public  ScaleAnimation(float fromX, float toX, float fromY, float toY,
            float pivotX, float pivotY) {
        mResources = null;
        mFromX = fromX;
        mToX = toX;
        mFromY = fromY;
        mToY = toY;
        mPivotXType = ABSOLUTE;
        mPivotYType = ABSOLUTE;
        mPivotXValue = pivotX;
        mPivotYValue = pivotY;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.121 -0400", hash_original_method = "D69E90D5037F2660E180F2C8AD5003B6", hash_generated_method = "402FCFE0BA9E51B59997343ECF9C9D17")
    public  ScaleAnimation(float fromX, float toX, float fromY, float toY,
            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        mResources = null;
        mFromX = fromX;
        mToX = toX;
        mFromY = fromY;
        mToY = toY;
        mPivotXValue = pivotXValue;
        mPivotXType = pivotXType;
        mPivotYValue = pivotYValue;
        mPivotYType = pivotYType;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.122 -0400", hash_original_method = "ACAB92B82483DFC255430C098BD55E9F", hash_generated_method = "DE47C38BD240223238CAB8B04037AC1B")
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(interpolatedTime);
        float sx = 1.0f;
        float sy = 1.0f;
        float scale = getScaleFactor();
        if(mFromX != 1.0f || mToX != 1.0f)        
        {
            sx = mFromX + ((mToX - mFromX) * interpolatedTime);
        } //End block
        if(mFromY != 1.0f || mToY != 1.0f)        
        {
            sy = mFromY + ((mToY - mFromY) * interpolatedTime);
        } //End block
        if(mPivotX == 0 && mPivotY == 0)        
        {
            t.getMatrix().setScale(sx, sy);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.123 -0400", hash_original_method = "676CA3558C31BAAF0E94504390B45F7E", hash_generated_method = "09AA5752EFE3B77B90F1F546B6463878")
     float resolveScale(float scale, int type, int data, int size, int psize) {
        addTaint(psize);
        addTaint(size);
        addTaint(data);
        addTaint(type);
        addTaint(scale);
        float targetSize;
        if(type == TypedValue.TYPE_FRACTION)        
        {
            targetSize = TypedValue.complexToFraction(data, size, psize);
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            targetSize = TypedValue.complexToDimension(data, mResources.getDisplayMetrics());
        } //End block
        else
        {
            float var0CB47AEB6E5F9323F0969E628C4E59F5_9794349 = (scale);
                        float var546ADE640B6EDFBC8A086EF31347E768_361107812 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_361107812;
        } //End block
        if(size == 0)        
        {
            float varC4CA4238A0B923820DCC509A6F75849B_756365172 = (1);
                        float var546ADE640B6EDFBC8A086EF31347E768_19538913 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_19538913;
        } //End block
        float varB7A55A890AEA197BD829FD4660EE4EF4_460574838 = (targetSize/(float)size);
                float var546ADE640B6EDFBC8A086EF31347E768_1067692018 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1067692018;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.123 -0400", hash_original_method = "E8174A29F113646F3F03DE9F1A1AE2A8", hash_generated_method = "C41E37D0FCE9CC7DF1C6CA527D948C88")
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
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

