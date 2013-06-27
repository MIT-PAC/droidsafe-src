package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.480 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "5282170AD2743DECEA0FF0876CABC714")

    private String mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.481 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.481 -0400", hash_original_field = "327DC1284D23313571A41B232E2678D5", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private int mTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.481 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.481 -0400", hash_original_field = "9F5A5097868D3BAB83E72FBCFAB6A21C", hash_generated_field = "D4E8778377795C8E2ACC264610934B4B")

    private ColorStateList mTextColorLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.481 -0400", hash_original_method = "9B1172C0C8B31BFAE0D2C93687346AFE", hash_generated_method = "886B1FFA46BEE8FFE2C7A1329C35BFEE")
    public  TextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
        addTaint(context.getTaint());
        addTaint(appearance);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.486 -0400", hash_original_method = "9317B5C63D080DC3774D9B3DFE979A1B", hash_generated_method = "9F53CB1248919BE169F32AA87FE92B84")
    public  TextAppearanceSpan(Context context, int appearance, int colorList) {
        ColorStateList textColor;
        TypedArray a;
        a = context.obtainStyledAttributes(appearance,
                                           com.android.internal.R.styleable.TextAppearance);
        textColor = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColor);
        mTextColorLink = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColorLink);
        mTextSize = a.getDimensionPixelSize(com.android.internal.R.styleable.
                                        TextAppearance_textSize, -1);
        mStyle = a.getInt(com.android.internal.R.styleable.TextAppearance_textStyle, 0);
        int tf;
        tf = a.getInt(com.android.internal.R.styleable.TextAppearance_typeface, 0);
        //Begin case 1 
        mTypeface = "sans";
        //End case 1 
        //Begin case 2 
        mTypeface = "serif";
        //End case 2 
        //Begin case 3 
        mTypeface = "monospace";
        //End case 3 
        //Begin case default 
        mTypeface = null;
        //End case default 
        a.recycle();
        {
            a = context.obtainStyledAttributes(com.android.internal.R.style.Theme,
                                            com.android.internal.R.styleable.Theme);
            textColor = a.getColorStateList(colorList);
            a.recycle();
        } //End block
        mTextColor = textColor;
        addTaint(context.getTaint());
        addTaint(appearance);
        addTaint(colorList);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.487 -0400", hash_original_method = "BC7BB9D16048D8ABD4B4822412C22F80", hash_generated_method = "1562EAF0D06CC3B413C7B78388E7EB34")
    public  TextAppearanceSpan(String family, int style, int size,
                              ColorStateList color, ColorStateList linkColor) {
        mTypeface = family;
        mStyle = style;
        mTextSize = size;
        mTextColor = color;
        mTextColorLink = linkColor;
        // ---------- Original Method ----------
        //mTypeface = family;
        //mStyle = style;
        //mTextSize = size;
        //mTextColor = color;
        //mTextColorLink = linkColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.494 -0400", hash_original_method = "0C8ADD28198996D9662262CC57DEB737", hash_generated_method = "31D9DB2073E41A59C06EF2027FA1B7DF")
    public  TextAppearanceSpan(Parcel src) {
        mTypeface = src.readString();
        mStyle = src.readInt();
        mTextSize = src.readInt();
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_2140120596 = (src.readInt() != 0);
            {
                mTextColor = ColorStateList.CREATOR.createFromParcel(src);
            } //End block
            {
                mTextColor = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_385807610 = (src.readInt() != 0);
            {
                mTextColorLink = ColorStateList.CREATOR.createFromParcel(src);
            } //End block
            {
                mTextColorLink = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mTypeface = src.readString();
        //mStyle = src.readInt();
        //mTextSize = src.readInt();
        //if (src.readInt() != 0) {
            //mTextColor = ColorStateList.CREATOR.createFromParcel(src);
        //} else {
            //mTextColor = null;
        //}
        //if (src.readInt() != 0) {
            //mTextColorLink = ColorStateList.CREATOR.createFromParcel(src);
        //} else {
            //mTextColorLink = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.503 -0400", hash_original_method = "06416282EB1641FCC18F44A861BC9EFB", hash_generated_method = "1E25115BB6F05E80C515791DDA4AAACF")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956589612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956589612;
        // ---------- Original Method ----------
        //return TextUtils.TEXT_APPEARANCE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.504 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ACF594D0D525C336C7B4F25D9DB75028")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948321432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948321432;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.504 -0400", hash_original_method = "5C4A27F4DE181F367842F0367978AD5D", hash_generated_method = "9850408920266E56E6F9FAC2825715C6")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTypeface);
        dest.writeInt(mStyle);
        dest.writeInt(mTextSize);
        {
            dest.writeInt(1);
            mTextColor.writeToParcel(dest, flags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            mTextColorLink.writeToParcel(dest, flags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mTypeface);
        //dest.writeInt(mStyle);
        //dest.writeInt(mTextSize);
        //if (mTextColor != null) {
            //dest.writeInt(1);
            //mTextColor.writeToParcel(dest, flags);
        //} else {
            //dest.writeInt(0);
        //}
        //if (mTextColorLink != null) {
            //dest.writeInt(1);
            //mTextColorLink.writeToParcel(dest, flags);
        //} else {
            //dest.writeInt(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.510 -0400", hash_original_method = "15042A588BD36B3AABC957E25B6ABB68", hash_generated_method = "07BCE99AC2BE5CD45BA9F3F97A2A9889")
    public String getFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_1797902426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797902426 = mTypeface;
        varB4EAC82CA7396A68D541C85D26508E83_1797902426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797902426;
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.518 -0400", hash_original_method = "BEF77474BA0C11C6EB44F1454E52790F", hash_generated_method = "8DE37EA1B13CB193090973F3ECC6D501")
    public ColorStateList getTextColor() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_915798738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915798738 = mTextColor;
        varB4EAC82CA7396A68D541C85D26508E83_915798738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915798738;
        // ---------- Original Method ----------
        //return mTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.519 -0400", hash_original_method = "9E3E27CD0F13B768F4263E5569C857AD", hash_generated_method = "851BEFBBD66D2AB5DDB5C8BE1F757B4B")
    public ColorStateList getLinkTextColor() {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1524563238 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1524563238 = mTextColorLink;
        varB4EAC82CA7396A68D541C85D26508E83_1524563238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1524563238;
        // ---------- Original Method ----------
        //return mTextColorLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.519 -0400", hash_original_method = "AB3DB1BB0D199EBBBA8548C5EC0C310E", hash_generated_method = "CC6D1BEC97AE8637D3224527053CE372")
    public int getTextSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128836190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128836190;
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.525 -0400", hash_original_method = "3C882FE9CECBB039C8EAD0BA2E56F794", hash_generated_method = "C26CE67019D033911A6BA268015FA9B6")
    public int getTextStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628216938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628216938;
        // ---------- Original Method ----------
        //return mStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.535 -0400", hash_original_method = "91F606F0F4AED8EEECD78BF397028020", hash_generated_method = "FA2E6C7851B07621F022E81F53DF4C96")
    @Override
    public void updateDrawState(TextPaint ds) {
        updateMeasureState(ds);
        {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        } //End block
        {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        } //End block
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //updateMeasureState(ds);
        //if (mTextColor != null) {
            //ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        //}
        //if (mTextColorLink != null) {
            //ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.550 -0400", hash_original_method = "F4F67354DC20CE392F9DCE12B9A9C5F1", hash_generated_method = "3518235B4918A8C11C8F5F72A69DFAEE")
    @Override
    public void updateMeasureState(TextPaint ds) {
        {
            Typeface tf;
            tf = ds.getTypeface();
            int style;
            style = 0;
            {
                style = tf.getStyle();
            } //End block
            style |= mStyle;
            {
                tf = Typeface.create(mTypeface, style);
            } //End block
            {
                tf = Typeface.defaultFromStyle(style);
            } //End block
            {
                tf = Typeface.create(tf, style);
            } //End block
            int fake;
            fake = style & ~tf.getStyle();
            {
                ds.setFakeBoldText(true);
            } //End block
            {
                ds.setTextSkewX(-0.25f);
            } //End block
            ds.setTypeface(tf);
        } //End block
        {
            ds.setTextSize(mTextSize);
        } //End block
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

