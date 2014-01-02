package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;


public class ScaleAnimation extends Animation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.167 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private  Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.169 -0500", hash_original_field = "A7698EADE21741D2C5739B53D16EE931", hash_generated_field = "BB287F46785769B83860D56D8BE9EFD8")


    private float mFromX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.171 -0500", hash_original_field = "C647943068C62A1ABE17C8AE2FCB54FE", hash_generated_field = "04285F5086DF3EAF7703BA446BC7BACF")

    private float mToX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.173 -0500", hash_original_field = "DAE6D0B305E0767167FE19F1EF90345F", hash_generated_field = "23FE8E016CC493D9EFEDB8A1C9A430E7")

    private float mFromY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.175 -0500", hash_original_field = "4AC9857F7AB5B1656EF0F16021315947", hash_generated_field = "B32ECB78B8E715C7460739B27CA842E7")

    private float mToY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.177 -0500", hash_original_field = "1B7F7F8CB078C3324C8AB2A9E2A3F8E5", hash_generated_field = "EF5CCFA809ED96BE62A4E7398FA3E7EF")


    private int mFromXType = TypedValue.TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.180 -0500", hash_original_field = "E62278171439704A31FB53DC7635F2F7", hash_generated_field = "0DAB7BC0DD34C12139A64FA80B053006")

    private int mToXType = TypedValue.TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.182 -0500", hash_original_field = "CAA649A6174AF8A5C424F26652C829EE", hash_generated_field = "D8BF40E0AE12F53A1AE0BE3E1CFAD3A4")

    private int mFromYType = TypedValue.TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.184 -0500", hash_original_field = "56FBD7ABFB0E1E2F4D5A14EED0D6A9CA", hash_generated_field = "96D1562EC34C4AC02419D0A55158EC4D")

    private int mToYType = TypedValue.TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.186 -0500", hash_original_field = "A66E29BF954CE0404CE4F05DD7319748", hash_generated_field = "78C236BBF3AA3B138CA8A37DA32CAA60")


    private int mFromXData = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.188 -0500", hash_original_field = "2BC1C22C8E59BD42B08A00E070F23CC0", hash_generated_field = "BFDE8B8EEB4894371DCD5E8AA633C493")

    private int mToXData = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.192 -0500", hash_original_field = "FF8E5E27B495A1D01298216E34901B3C", hash_generated_field = "339253AB01E09DEEC240855896A6E360")

    private int mFromYData = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.194 -0500", hash_original_field = "03A334717BBA9EC84D3EEBE2A6569D84", hash_generated_field = "D5DE9D4159C58D4EFB94DA518A494266")

    private int mToYData = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.196 -0500", hash_original_field = "35319F0004C491BB80D5F1742219F20C", hash_generated_field = "EC74AC06B5691B47A1AD5BBF6B15ECE3")


    private int mPivotXType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.198 -0500", hash_original_field = "15AA19B564953B2E92DF57FC0E988FB4", hash_generated_field = "C9A99ED0A354C0C74E5E29006BD9ED31")

    private int mPivotYType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.200 -0500", hash_original_field = "DAF37BA52463794A2FC8056AA3E095AA", hash_generated_field = "AF755B8408C979E36D20FBC0A81E876D")

    private float mPivotXValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.202 -0500", hash_original_field = "53742362BBA0945C7FD67A0E0C9C324E", hash_generated_field = "E9B533B02C8C2E2321EBFE6D7C3F6C50")

    private float mPivotYValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.204 -0500", hash_original_field = "5936761CCB9106C6D82A6436A57EC343", hash_generated_field = "D5598B4EF8A215EC3A51B2F400B272F3")


    private float mPivotX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.207 -0500", hash_original_field = "6CE864DEEFD86BFE91AA6D818A7F55C0", hash_generated_field = "0971400EDE5A41D2136C532E521A2E57")

    private float mPivotY;

    /**
     * Constructor used when a ScaleAnimation is loaded from a resource.
     * 
     * @param context Application context to use
     * @param attrs Attribute set from which to read values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.210 -0500", hash_original_method = "E7EC7911EB152736ED90DFA69DF1393A", hash_generated_method = "9087758B3B9E3944BF7964604E052FFB")
    
public ScaleAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);

        mResources = context.getResources();

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ScaleAnimation);

        TypedValue tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromXScale);
        mFromX = 0.0f;
        if (tv != null) {
            if (tv.type == TypedValue.TYPE_FLOAT) {
                // This is a scaling factor.
                mFromX = tv.getFloat();
            } else {
                mFromXType = tv.type;
                mFromXData = tv.data;
            }
        }
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toXScale);
        mToX = 0.0f;
        if (tv != null) {
            if (tv.type == TypedValue.TYPE_FLOAT) {
                // This is a scaling factor.
                mToX = tv.getFloat();
            } else {
                mToXType = tv.type;
                mToXData = tv.data;
            }
        }

        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_fromYScale);
        mFromY = 0.0f;
        if (tv != null) {
            if (tv.type == TypedValue.TYPE_FLOAT) {
                // This is a scaling factor.
                mFromY = tv.getFloat();
            } else {
                mFromYType = tv.type;
                mFromYData = tv.data;
            }
        }
        tv = a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_toYScale);
        mToY = 0.0f;
        if (tv != null) {
            if (tv.type == TypedValue.TYPE_FLOAT) {
                // This is a scaling factor.
                mToY = tv.getFloat();
            } else {
                mToYType = tv.type;
                mToYData = tv.data;
            }
        }

        Description d = Description.parseValue(a.peekValue(
                com.android.internal.R.styleable.ScaleAnimation_pivotX));
        mPivotXType = d.type;
        mPivotXValue = d.value;

        d = Description.parseValue(a.peekValue(
            com.android.internal.R.styleable.ScaleAnimation_pivotY));
        mPivotYType = d.type;
        mPivotYValue = d.value;

        a.recycle();
    }

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.213 -0500", hash_original_method = "512F0A59662E426B1B9BCA8ED3066806", hash_generated_method = "0EBB2D749C70BCA98B947AB188DB1D61")
    
public ScaleAnimation(float fromX, float toX, float fromY, float toY) {
        mResources = null;
        mFromX = fromX;
        mToX = toX;
        mFromY = fromY;
        mToY = toY;
        mPivotX = 0;
        mPivotY = 0;
    }

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     * @param pivotX The X coordinate of the point about which the object is
     *        being scaled, specified as an absolute number where 0 is the left
     *        edge. (This point remains fixed while the object changes size.)
     * @param pivotY The Y coordinate of the point about which the object is
     *        being scaled, specified as an absolute number where 0 is the top
     *        edge. (This point remains fixed while the object changes size.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.216 -0500", hash_original_method = "E87B1195FC877E2731C7B2475118F4DC", hash_generated_method = "8F93806C1A6D737E24B2E62611A732BA")
    
public ScaleAnimation(float fromX, float toX, float fromY, float toY,
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
    }

    /**
     * Constructor to use when building a ScaleAnimation from code
     * 
     * @param fromX Horizontal scaling factor to apply at the start of the
     *        animation
     * @param toX Horizontal scaling factor to apply at the end of the animation
     * @param fromY Vertical scaling factor to apply at the start of the
     *        animation
     * @param toY Vertical scaling factor to apply at the end of the animation
     * @param pivotXType Specifies how pivotXValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotXValue The X coordinate of the point about which the object
     *        is being scaled, specified as an absolute number where 0 is the
     *        left edge. (This point remains fixed while the object changes
     *        size.) This value can either be an absolute number if pivotXType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     * @param pivotYType Specifies how pivotYValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param pivotYValue The Y coordinate of the point about which the object
     *        is being scaled, specified as an absolute number where 0 is the
     *        top edge. (This point remains fixed while the object changes
     *        size.) This value can either be an absolute number if pivotYType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.219 -0500", hash_original_method = "D69E90D5037F2660E180F2C8AD5003B6", hash_generated_method = "6001773CF59440E96A2CBF5B1BDF84A3")
    
public ScaleAnimation(float fromX, float toX, float fromY, float toY,
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.221 -0500", hash_original_method = "ACAB92B82483DFC255430C098BD55E9F", hash_generated_method = "5AD76E61E389D728E605DFB23229C651")
    
@Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float sx = 1.0f;
        float sy = 1.0f;
        float scale = getScaleFactor();

        if (mFromX != 1.0f || mToX != 1.0f) {
            sx = mFromX + ((mToX - mFromX) * interpolatedTime);
        }
        if (mFromY != 1.0f || mToY != 1.0f) {
            sy = mFromY + ((mToY - mFromY) * interpolatedTime);
        }

        if (mPivotX == 0 && mPivotY == 0) {
            t.getMatrix().setScale(sx, sy);
        } else {
            t.getMatrix().setScale(sx, sy, scale * mPivotX, scale * mPivotY);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.224 -0500", hash_original_method = "676CA3558C31BAAF0E94504390B45F7E", hash_generated_method = "676CA3558C31BAAF0E94504390B45F7E")
    
float resolveScale(float scale, int type, int data, int size, int psize) {
        float targetSize;
        if (type == TypedValue.TYPE_FRACTION) {
            targetSize = TypedValue.complexToFraction(data, size, psize);
        } else if (type == TypedValue.TYPE_DIMENSION) {
            targetSize = TypedValue.complexToDimension(data, mResources.getDisplayMetrics());
        } else {
            return scale;
        }

        if (size == 0) {
            return 1;
        }

        return targetSize/(float)size;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:58.226 -0500", hash_original_method = "E8174A29F113646F3F03DE9F1A1AE2A8", hash_generated_method = "B963901B26B7E8625D14F2EB7FA8D121")
    
@Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        mFromX = resolveScale(mFromX, mFromXType, mFromXData, width, parentWidth);
        mToX = resolveScale(mToX, mToXType, mToXData, width, parentWidth);
        mFromY = resolveScale(mFromY, mFromYType, mFromYData, height, parentHeight);
        mToY = resolveScale(mToY, mToYType, mToYData, height, parentHeight);

        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
    }

    
}

