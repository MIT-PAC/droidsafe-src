package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final String mTypeface;
    private final int mStyle;
    private final int mTextSize;
    private final ColorStateList mTextColor;
    private final ColorStateList mTextColorLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.356 -0400", hash_original_method = "9B1172C0C8B31BFAE0D2C93687346AFE", hash_generated_method = "0E1EA8BB6E976134B930BEEEE56E165E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
        dsTaint.addTaint(appearance);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.356 -0400", hash_original_method = "9317B5C63D080DC3774D9B3DFE979A1B", hash_generated_method = "A6DC9868103603415BC7411F57447723")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextAppearanceSpan(Context context, int appearance, int colorList) {
        dsTaint.addTaint(appearance);
        dsTaint.addTaint(colorList);
        dsTaint.addTaint(context.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "BC7BB9D16048D8ABD4B4822412C22F80", hash_generated_method = "A89CFCF072A389F1D47E14C0A5397566")
    @DSModeled(DSC.SAFE)
    public TextAppearanceSpan(String family, int style, int size,
                              ColorStateList color, ColorStateList linkColor) {
        dsTaint.addTaint(linkColor.dsTaint);
        dsTaint.addTaint(style);
        dsTaint.addTaint(color.dsTaint);
        dsTaint.addTaint(family);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mTypeface = family;
        //mStyle = style;
        //mTextSize = size;
        //mTextColor = color;
        //mTextColorLink = linkColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "0C8ADD28198996D9662262CC57DEB737", hash_generated_method = "AE0E81E0BE45D7ECE0533918BCE35AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextAppearanceSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mTypeface = src.readString();
        mStyle = src.readInt();
        mTextSize = src.readInt();
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_1946412324 = (src.readInt() != 0);
            {
                mTextColor = ColorStateList.CREATOR.createFromParcel(src);
            } //End block
            {
                mTextColor = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD1B2B02E9DB19B4AD5578330E4A9BB4_162586162 = (src.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "06416282EB1641FCC18F44A861BC9EFB", hash_generated_method = "6F7B5E5D4A707214926C733368D77671")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.TEXT_APPEARANCE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "5C4A27F4DE181F367842F0367978AD5D", hash_generated_method = "B3BD0C8E9149E8FAD117DF0E036869B8")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "15042A588BD36B3AABC957E25B6ABB68", hash_generated_method = "33ADE3870E190535C57EE30F1D9083AD")
    @DSModeled(DSC.SAFE)
    public String getFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "BEF77474BA0C11C6EB44F1454E52790F", hash_generated_method = "72D6830913E57E95E73C39D806EE0F5D")
    @DSModeled(DSC.SAFE)
    public ColorStateList getTextColor() {
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "9E3E27CD0F13B768F4263E5569C857AD", hash_generated_method = "0A2108E969259BD24F929C058DED0F29")
    @DSModeled(DSC.SAFE)
    public ColorStateList getLinkTextColor() {
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextColorLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "AB3DB1BB0D199EBBBA8548C5EC0C310E", hash_generated_method = "ADC8C6F941AA9FB92F910DD548DEA70F")
    @DSModeled(DSC.SAFE)
    public int getTextSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTextSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.357 -0400", hash_original_method = "3C882FE9CECBB039C8EAD0BA2E56F794", hash_generated_method = "6B07D70076D80BAB896ADDC5B0E9D26D")
    @DSModeled(DSC.SAFE)
    public int getTextStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.358 -0400", hash_original_method = "91F606F0F4AED8EEECD78BF397028020", hash_generated_method = "85F247843C02D475F455BAB487B99811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        updateMeasureState(ds);
        {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        } //End block
        {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        } //End block
        // ---------- Original Method ----------
        //updateMeasureState(ds);
        //if (mTextColor != null) {
            //ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        //}
        //if (mTextColorLink != null) {
            //ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.358 -0400", hash_original_method = "F4F67354DC20CE392F9DCE12B9A9C5F1", hash_generated_method = "66B6E8FBDAA3E4D5B5EB28DFA13162E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


