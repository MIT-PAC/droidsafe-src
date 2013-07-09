package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class TextAppearanceSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.002 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "5282170AD2743DECEA0FF0876CABC714")

    private String mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.002 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.002 -0400", hash_original_field = "327DC1284D23313571A41B232E2678D5", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private int mTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.003 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.003 -0400", hash_original_field = "9F5A5097868D3BAB83E72FBCFAB6A21C", hash_generated_field = "D4E8778377795C8E2ACC264610934B4B")

    private ColorStateList mTextColorLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.003 -0400", hash_original_method = "9B1172C0C8B31BFAE0D2C93687346AFE", hash_generated_method = "886B1FFA46BEE8FFE2C7A1329C35BFEE")
    public  TextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
        addTaint(context.getTaint());
        addTaint(appearance);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.004 -0400", hash_original_method = "9317B5C63D080DC3774D9B3DFE979A1B", hash_generated_method = "D5F838B175BB5A62E58D7B297E6117A4")
    public  TextAppearanceSpan(Context context, int appearance, int colorList) {
        ColorStateList textColor;
        TypedArray a = context.obtainStyledAttributes(appearance,
                                           com.android.internal.R.styleable.TextAppearance);
        textColor = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColor);
        mTextColorLink = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColorLink);
        mTextSize = a.getDimensionPixelSize(com.android.internal.R.styleable.
                                        TextAppearance_textSize, -1);
        mStyle = a.getInt(com.android.internal.R.styleable.TextAppearance_textStyle, 0);
        int tf = a.getInt(com.android.internal.R.styleable.TextAppearance_typeface, 0);
        
        mTypeface = "sans";
        
        
        mTypeface = "serif";
        
        
        mTypeface = "monospace";
        
        
        mTypeface = null;
        
        a.recycle();
        {
            a = context.obtainStyledAttributes(com.android.internal.R.style.Theme,
                                            com.android.internal.R.styleable.Theme);
            textColor = a.getColorStateList(colorList);
            a.recycle();
        } 
        mTextColor = textColor;
        addTaint(context.getTaint());
        addTaint(appearance);
        addTaint(colorList);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.004 -0400", hash_original_method = "BC7BB9D16048D8ABD4B4822412C22F80", hash_generated_method = "1562EAF0D06CC3B413C7B78388E7EB34")
    public  TextAppearanceSpan(String family, int style, int size,
                              ColorStateList color, ColorStateList linkColor) {
        mTypeface = family;
        mStyle = style;
        mTextSize = size;
        mTextColor = color;
        mTextColorLink = linkColor;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.005 -0400", hash_original_method = "0C8ADD28198996D9662262CC57DEB737", hash_generated_method = "B23F11190DD4884630FB2F1E8BDFAE82")
    public  TextAppearanceSpan(Parcel src) {
        mTypeface = src.readString();
        mStyle = src.readInt();
        mTextSize = src.readInt();
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_1186644409 = (src.readInt() != 0);
            {
                mTextColor = ColorStateList.CREATOR.createFromParcel(src);
            } 
            {
                mTextColor = null;
            } 
        } 
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_1259831027 = (src.readInt() != 0);
            {
                mTextColorLink = ColorStateList.CREATOR.createFromParcel(src);
            } 
            {
                mTextColorLink = null;
            } 
        } 
        
        
        
        
        
            
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.006 -0400", hash_original_method = "06416282EB1641FCC18F44A861BC9EFB", hash_generated_method = "1D7541A061FA0EAE2464AA1F14799173")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899362422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1899362422;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.006 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3C3BE694BD0F076E32CF8009F5B53301")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676189865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676189865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.007 -0400", hash_original_method = "5C4A27F4DE181F367842F0367978AD5D", hash_generated_method = "9850408920266E56E6F9FAC2825715C6")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTypeface);
        dest.writeInt(mStyle);
        dest.writeInt(mTextSize);
        {
            dest.writeInt(1);
            mTextColor.writeToParcel(dest, flags);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            mTextColorLink.writeToParcel(dest, flags);
        } 
        {
            dest.writeInt(0);
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
            
            
        
            
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.007 -0400", hash_original_method = "15042A588BD36B3AABC957E25B6ABB68", hash_generated_method = "77306610B3FABBC47F4083E858ECD295")
    public String getFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_1672642297 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1672642297 = mTypeface;
        varB4EAC82CA7396A68D541C85D26508E83_1672642297.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1672642297;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.008 -0400", hash_original_method = "BEF77474BA0C11C6EB44F1454E52790F", hash_generated_method = "55847672DD5D6DE79CE5A481517ED7AA")
    public ColorStateList getTextColor() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1614513163 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1614513163 = mTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_1614513163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1614513163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.008 -0400", hash_original_method = "9E3E27CD0F13B768F4263E5569C857AD", hash_generated_method = "023D41609D9B502BCD87B214519F4353")
    public ColorStateList getLinkTextColor() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_932639708 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_932639708 = mTextColorLink;
        varB4EAC82CA7396A68D541C85D26508E83_932639708.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_932639708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.009 -0400", hash_original_method = "AB3DB1BB0D199EBBBA8548C5EC0C310E", hash_generated_method = "0AF52B3B28D54ED666FBB5FBF6801CB6")
    public int getTextSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022199432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022199432;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.009 -0400", hash_original_method = "3C882FE9CECBB039C8EAD0BA2E56F794", hash_generated_method = "41E6E4A40006C1D3CE6D2CFB84A1A859")
    public int getTextStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829543102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829543102;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.009 -0400", hash_original_method = "91F606F0F4AED8EEECD78BF397028020", hash_generated_method = "FA2E6C7851B07621F022E81F53DF4C96")
    @Override
    public void updateDrawState(TextPaint ds) {
        updateMeasureState(ds);
        {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        } 
        {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        } 
        addTaint(ds.getTaint());
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.010 -0400", hash_original_method = "F4F67354DC20CE392F9DCE12B9A9C5F1", hash_generated_method = "0350E2457DB2333EC00A4DBA3C54F134")
    @Override
    public void updateMeasureState(TextPaint ds) {
        {
            Typeface tf = ds.getTypeface();
            int style = 0;
            {
                style = tf.getStyle();
            } 
            style |= mStyle;
            {
                tf = Typeface.create(mTypeface, style);
            } 
            {
                tf = Typeface.defaultFromStyle(style);
            } 
            {
                tf = Typeface.create(tf, style);
            } 
            int fake = style & ~tf.getStyle();
            {
                ds.setFakeBoldText(true);
            } 
            {
                ds.setTextSkewX(-0.25f);
            } 
            ds.setTypeface(tf);
        } 
        {
            ds.setTextSize(mTextSize);
        } 
        addTaint(ds.getTaint());
        
        
    }

    
}

