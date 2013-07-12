package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class TranslateAnimation extends Animation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "30596AFED90526D901C7B838CDCC0CDB", hash_generated_field = "53B23801C0E3E8220D6B059716F97974")

    private int mFromXType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "8BFB7E4EE0A5D695091516D2F827E736", hash_generated_field = "6E294F70A6A04D6998AFF7886D38BA76")

    private int mToXType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "E3DE394DA204CEB9377F5B3F1D29BC09", hash_generated_field = "E79DA4E8427835359C8D27F63442A8AA")

    private int mFromYType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "704F0605044464AA8E494CD73A8553EA", hash_generated_field = "5E2D74DF967231C63B133AA9152EAD10")

    private int mToYType = ABSOLUTE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "C4B5E6D99A3B4ECD1624ADA9ACB4E1B1", hash_generated_field = "ACE77DFDBE16E24C8F2A3945CECB4697")

    private float mFromXValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "2E954164AE172BEF1AFA887B581F0CDD", hash_generated_field = "148E45B88E557C508BF44D6622B72449")

    private float mToXValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "8562DD03E72E0C305982B30895B55322", hash_generated_field = "7B219C2A412C5F590E0D24B299716773")

    private float mFromYValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "BA781974830944D7C6648FBA868E9595", hash_generated_field = "DCFD542B9F7979C11BDF27AE328F13B3")

    private float mToYValue = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "588BFE2F78E28BF44BB27F8726BA36F9", hash_generated_field = "ADB5E26D5EA2BC19E407584F177CA75A")

    private float mFromXDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "EB6682B70579D9289DF0FD0A3D487C21", hash_generated_field = "231A6C16A0509A65E8E6082CA57FEE73")

    private float mToXDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "9C5E41F70B529799DCDB53D6F5B36D4D", hash_generated_field = "B85F90CAAC019257F15A8E98B3AF695B")

    private float mFromYDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.019 -0400", hash_original_field = "4994ACA0E3412018CAAEC6FB6A02E458", hash_generated_field = "A1C417F3FC746748CC7FD81A1E5625C3")

    private float mToYDelta;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.021 -0400", hash_original_method = "A16A4EA57E6F92D9F93733BFB1359F59", hash_generated_method = "6D60054BA9D40678D83C6B37E381FF9A")
    public  TranslateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.022 -0400", hash_original_method = "3F07A84DAAC1EE50E22F719B3019603F", hash_generated_method = "F6D5C9D025C5DE0DBBF80D89A5392DFC")
    public  TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        mFromXValue = fromXDelta;
        mToXValue = toXDelta;
        mFromYValue = fromYDelta;
        mToYValue = toYDelta;
        mFromXType = ABSOLUTE;
        mToXType = ABSOLUTE;
        mFromYType = ABSOLUTE;
        mToYType = ABSOLUTE;
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.024 -0400", hash_original_method = "D0D15BEA3C16DDFD23FD148FD42664E4", hash_generated_method = "825858649B41C5A9D8D90FE313426A6D")
    public  TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.024 -0400", hash_original_method = "A766E69C82E8D177EAD959BF3BB9235A", hash_generated_method = "577CE3A6EA9D2996267E94F0704F6D88")
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        addTaint(t.getTaint());
        addTaint(interpolatedTime);
        float dx = mFromXDelta;
        float dy = mFromYDelta;
    if(mFromXDelta != mToXDelta)        
        {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        } 
    if(mFromYDelta != mToYDelta)        
        {
            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        } 
        t.getMatrix().setTranslate(dx, dy);
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.025 -0400", hash_original_method = "8DB34CFBDCDCD857D21DC05DC5D03D8B", hash_generated_method = "DF56667F248A77764539EC597F374BEC")
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mFromXDelta = resolveSize(mFromXType, mFromXValue, width, parentWidth);
        mToXDelta = resolveSize(mToXType, mToXValue, width, parentWidth);
        mFromYDelta = resolveSize(mFromYType, mFromYValue, height, parentHeight);
        mToYDelta = resolveSize(mToYType, mToYValue, height, parentHeight);
        
        
        
        
        
        
    }

    
}

