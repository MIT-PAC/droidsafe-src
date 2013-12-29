package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;


public class TranslateAnimation extends Animation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.034 -0500", hash_original_field = "0FED669AE2959DF6D307B52F040483FD", hash_generated_field = "53B23801C0E3E8220D6B059716F97974")

    private int mFromXType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.035 -0500", hash_original_field = "BFB9A8D5EA4028CAC258A7531E4A78C6", hash_generated_field = "6E294F70A6A04D6998AFF7886D38BA76")

    private int mToXType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.036 -0500", hash_original_field = "422A8AE8BF4D181A42ECF680F9C3AEF1", hash_generated_field = "E79DA4E8427835359C8D27F63442A8AA")


    private int mFromYType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.037 -0500", hash_original_field = "6F875E958AE2B4F8668CF0429AA7780B", hash_generated_field = "5E2D74DF967231C63B133AA9152EAD10")

    private int mToYType = ABSOLUTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.038 -0500", hash_original_field = "2202B012AC6AE7547C654DEF1F949494", hash_generated_field = "ACE77DFDBE16E24C8F2A3945CECB4697")


    private float mFromXValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.040 -0500", hash_original_field = "FB51C32CBBA3F0658256C38133956AB7", hash_generated_field = "148E45B88E557C508BF44D6622B72449")

    private float mToXValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.041 -0500", hash_original_field = "FE701A0358A95D17F1F0E13FF83D2D56", hash_generated_field = "7B219C2A412C5F590E0D24B299716773")


    private float mFromYValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.042 -0500", hash_original_field = "EFDDFA35C1C6AEDFA119C757B3A2F8A2", hash_generated_field = "DCFD542B9F7979C11BDF27AE328F13B3")

    private float mToYValue = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.043 -0500", hash_original_field = "F855393FF1F22AEB4038F777CEF98A3B", hash_generated_field = "ADB5E26D5EA2BC19E407584F177CA75A")


    private float mFromXDelta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.045 -0500", hash_original_field = "B71B78B886482F20432A35B00A1BDDFB", hash_generated_field = "231A6C16A0509A65E8E6082CA57FEE73")

    private float mToXDelta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.046 -0500", hash_original_field = "3DB9CD2690952AF05C1F2C46B914E9B9", hash_generated_field = "B85F90CAAC019257F15A8E98B3AF695B")

    private float mFromYDelta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.047 -0500", hash_original_field = "E170DB4F1353A4F3E750B4501FD6660A", hash_generated_field = "A1C417F3FC746748CC7FD81A1E5625C3")

    private float mToYDelta;

    /**
     * Constructor used when a TranslateAnimation is loaded from a resource.
     * 
     * @param context Application context to use
     * @param attrs Attribute set from which to read values
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.049 -0500", hash_original_method = "A16A4EA57E6F92D9F93733BFB1359F59", hash_generated_method = "5C6ECF02B391C5770C291169B7BC859A")
    public TranslateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TranslateAnimation);

        Description d = Description.parseValue(a.peekValue(
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
    }

    /**
     * Constructor to use when building a TranslateAnimation from code
     * 
     * @param fromXDelta Change in X coordinate to apply at the start of the
     *        animation
     * @param toXDelta Change in X coordinate to apply at the end of the
     *        animation
     * @param fromYDelta Change in Y coordinate to apply at the start of the
     *        animation
     * @param toYDelta Change in Y coordinate to apply at the end of the
     *        animation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.050 -0500", hash_original_method = "3F07A84DAAC1EE50E22F719B3019603F", hash_generated_method = "8D23F162B2F66B12DA40DAC4879AD5F6")
    public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        mFromXValue = fromXDelta;
        mToXValue = toXDelta;
        mFromYValue = fromYDelta;
        mToYValue = toYDelta;

        mFromXType = ABSOLUTE;
        mToXType = ABSOLUTE;
        mFromYType = ABSOLUTE;
        mToYType = ABSOLUTE;
    }

    /**
     * Constructor to use when building a TranslateAnimation from code
     * 
     * @param fromXType Specifies how fromXValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param fromXValue Change in X coordinate to apply at the start of the
     *        animation. This value can either be an absolute number if fromXType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     * @param toXType Specifies how toXValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param toXValue Change in X coordinate to apply at the end of the
     *        animation. This value can either be an absolute number if toXType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     * @param fromYType Specifies how fromYValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param fromYValue Change in Y coordinate to apply at the start of the
     *        animation. This value can either be an absolute number if fromYType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     * @param toYType Specifies how toYValue should be interpreted. One of
     *        Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
     *        Animation.RELATIVE_TO_PARENT.
     * @param toYValue Change in Y coordinate to apply at the end of the
     *        animation. This value can either be an absolute number if toYType
     *        is ABSOLUTE, or a percentage (where 1.0 is 100%) otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.052 -0500", hash_original_method = "D0D15BEA3C16DDFD23FD148FD42664E4", hash_generated_method = "5981909C22083A077C9C131B3569A103")
    public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
            int fromYType, float fromYValue, int toYType, float toYValue) {

        mFromXValue = fromXValue;
        mToXValue = toXValue;
        mFromYValue = fromYValue;
        mToYValue = toYValue;

        mFromXType = fromXType;
        mToXType = toXType;
        mFromYType = fromYType;
        mToYType = toYType;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.053 -0500", hash_original_method = "A766E69C82E8D177EAD959BF3BB9235A", hash_generated_method = "3F9341B33CF49392F9646FD88CEFF0AE")
    @Override
protected void applyTransformation(float interpolatedTime, Transformation t) {
        float dx = mFromXDelta;
        float dy = mFromYDelta;
        if (mFromXDelta != mToXDelta) {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        }
        if (mFromYDelta != mToYDelta) {
            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        }
        t.getMatrix().setTranslate(dx, dy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:28.054 -0500", hash_original_method = "8DB34CFBDCDCD857D21DC05DC5D03D8B", hash_generated_method = "9D126252B52F7C0ACD7DF1F59A4442C0")
    @Override
public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mFromXDelta = resolveSize(mFromXType, mFromXValue, width, parentWidth);
        mToXDelta = resolveSize(mToXType, mToXValue, width, parentWidth);
        mFromYDelta = resolveSize(mFromYType, mFromYValue, height, parentHeight);
        mToYDelta = resolveSize(mToYType, mToYValue, height, parentHeight);
    }

    
}

