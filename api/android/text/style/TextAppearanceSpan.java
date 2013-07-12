package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class TextAppearanceSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.458 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "5282170AD2743DECEA0FF0876CABC714")

    private String mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.458 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.458 -0400", hash_original_field = "327DC1284D23313571A41B232E2678D5", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private int mTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.458 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.458 -0400", hash_original_field = "9F5A5097868D3BAB83E72FBCFAB6A21C", hash_generated_field = "D4E8778377795C8E2ACC264610934B4B")

    private ColorStateList mTextColorLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.459 -0400", hash_original_method = "9B1172C0C8B31BFAE0D2C93687346AFE", hash_generated_method = "BCD1C1AD08E368165FE4EC652DB19889")
    public  TextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
        addTaint(appearance);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.462 -0400", hash_original_method = "9317B5C63D080DC3774D9B3DFE979A1B", hash_generated_method = "9F02B1C64430E2A7FE434EC80EDD3242")
    public  TextAppearanceSpan(Context context, int appearance, int colorList) {
        addTaint(colorList);
        addTaint(appearance);
        addTaint(context.getTaint());
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
switch(tf){
        case 1:
        mTypeface = "sans";
        break;
        case 2:
        mTypeface = "serif";
        break;
        case 3:
        mTypeface = "monospace";
        break;
        default:
        mTypeface = null;
        break;
}        a.recycle();
    if(colorList >= 0)        
        {
            a = context.obtainStyledAttributes(com.android.internal.R.style.Theme,
                                            com.android.internal.R.styleable.Theme);
            textColor = a.getColorStateList(colorList);
            a.recycle();
        } 
        mTextColor = textColor;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.463 -0400", hash_original_method = "BC7BB9D16048D8ABD4B4822412C22F80", hash_generated_method = "1562EAF0D06CC3B413C7B78388E7EB34")
    public  TextAppearanceSpan(String family, int style, int size,
                              ColorStateList color, ColorStateList linkColor) {
        mTypeface = family;
        mStyle = style;
        mTextSize = size;
        mTextColor = color;
        mTextColorLink = linkColor;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.465 -0400", hash_original_method = "0C8ADD28198996D9662262CC57DEB737", hash_generated_method = "274C9A5D1FDF6FD94E4AFC7D7B010B27")
    public  TextAppearanceSpan(Parcel src) {
        mTypeface = src.readString();
        mStyle = src.readInt();
        mTextSize = src.readInt();
    if(src.readInt() != 0)        
        {
            mTextColor = ColorStateList.CREATOR.createFromParcel(src);
        } 
        else
        {
            mTextColor = null;
        } 
    if(src.readInt() != 0)        
        {
            mTextColorLink = ColorStateList.CREATOR.createFromParcel(src);
        } 
        else
        {
            mTextColorLink = null;
        } 
        
        
        
        
        
            
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.466 -0400", hash_original_method = "06416282EB1641FCC18F44A861BC9EFB", hash_generated_method = "A258B445884A26A50E15C719CB61CFBF")
    public int getSpanTypeId() {
        int varCD492B187E15F56C7810FD02C1C1708D_1119830376 = (TextUtils.TEXT_APPEARANCE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161921743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161921743;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.466 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6C79C77D3DBC65EE38323C99DBD80414")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1190499834 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620580325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620580325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.467 -0400", hash_original_method = "5C4A27F4DE181F367842F0367978AD5D", hash_generated_method = "7DA90968403CA01593CD3D4060F07B81")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mTypeface);
        dest.writeInt(mStyle);
        dest.writeInt(mTextSize);
    if(mTextColor != null)        
        {
            dest.writeInt(1);
            mTextColor.writeToParcel(dest, flags);
        } 
        else
        {
            dest.writeInt(0);
        } 
    if(mTextColorLink != null)        
        {
            dest.writeInt(1);
            mTextColorLink.writeToParcel(dest, flags);
        } 
        else
        {
            dest.writeInt(0);
        } 
        
        
        
        
        
            
            
        
            
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.468 -0400", hash_original_method = "15042A588BD36B3AABC957E25B6ABB68", hash_generated_method = "A61E03F579694A9DFFA4E2218A488863")
    public String getFamily() {
String varCA555E983FC958B176FA6EA9B4C69E1B_579250326 =         mTypeface;
        varCA555E983FC958B176FA6EA9B4C69E1B_579250326.addTaint(taint);
        return varCA555E983FC958B176FA6EA9B4C69E1B_579250326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.469 -0400", hash_original_method = "BEF77474BA0C11C6EB44F1454E52790F", hash_generated_method = "A01544514362077A5FFABB621C2B7E28")
    public ColorStateList getTextColor() {
ColorStateList varF2B26C798C9C7016812AC3DA166887CA_1108125951 =         mTextColor;
        varF2B26C798C9C7016812AC3DA166887CA_1108125951.addTaint(taint);
        return varF2B26C798C9C7016812AC3DA166887CA_1108125951;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.470 -0400", hash_original_method = "9E3E27CD0F13B768F4263E5569C857AD", hash_generated_method = "063D1208F5472BB2F0099905E5BC6F10")
    public ColorStateList getLinkTextColor() {
ColorStateList varAF7DFF38BBEA0BE796D66E10E6013A75_1970140066 =         mTextColorLink;
        varAF7DFF38BBEA0BE796D66E10E6013A75_1970140066.addTaint(taint);
        return varAF7DFF38BBEA0BE796D66E10E6013A75_1970140066;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.470 -0400", hash_original_method = "AB3DB1BB0D199EBBBA8548C5EC0C310E", hash_generated_method = "537751D4802D966455E0F07717A3FAF0")
    public int getTextSize() {
        int var327DC1284D23313571A41B232E2678D5_1199531578 = (mTextSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073370430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073370430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.471 -0400", hash_original_method = "3C882FE9CECBB039C8EAD0BA2E56F794", hash_generated_method = "F1D28F91DD652E1702A81AA31FBFD3CC")
    public int getTextStyle() {
        int var16896C9E7463BF6DF9DB6B58257F1327_686031400 = (mStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134052294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134052294;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.472 -0400", hash_original_method = "91F606F0F4AED8EEECD78BF397028020", hash_generated_method = "4F19D8391DA71ED6B19F64C983040062")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        updateMeasureState(ds);
    if(mTextColor != null)        
        {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        } 
    if(mTextColorLink != null)        
        {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.474 -0400", hash_original_method = "F4F67354DC20CE392F9DCE12B9A9C5F1", hash_generated_method = "F4AA129A814E6EBF4E894C70E491C4E6")
    @Override
    public void updateMeasureState(TextPaint ds) {
        addTaint(ds.getTaint());
    if(mTypeface != null || mStyle != 0)        
        {
            Typeface tf = ds.getTypeface();
            int style = 0;
    if(tf != null)            
            {
                style = tf.getStyle();
            } 
            style |= mStyle;
    if(mTypeface != null)            
            {
                tf = Typeface.create(mTypeface, style);
            } 
            else
    if(tf == null)            
            {
                tf = Typeface.defaultFromStyle(style);
            } 
            else
            {
                tf = Typeface.create(tf, style);
            } 
            int fake = style & ~tf.getStyle();
    if((fake & Typeface.BOLD) != 0)            
            {
                ds.setFakeBoldText(true);
            } 
    if((fake & Typeface.ITALIC) != 0)            
            {
                ds.setTextSkewX(-0.25f);
            } 
            ds.setTypeface(tf);
        } 
    if(mTextSize > 0)        
        {
            ds.setTextSize(mTextSize);
        } 
        
        
    }

    
}

