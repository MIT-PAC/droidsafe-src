package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class TextAppearanceSpan extends MetricAffectingSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.544 -0500", hash_original_field = "09F52ED154F9A85ECF27E5DE83FC66E9", hash_generated_field = "5282170AD2743DECEA0FF0876CABC714")

    private  String mTypeface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.547 -0500", hash_original_field = "33CDAE5A87225928D8656C9A774A9266", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private  int mStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.549 -0500", hash_original_field = "5CFDEC1CAF5A4AED7672FC72DA5F5CD1", hash_generated_field = "9990B8B20909CFDC9898F67C6FDD18EC")

    private  int mTextSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.552 -0500", hash_original_field = "B31ADBE0719B7B69EDAEB4A1C7EA7A09", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private  ColorStateList mTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.555 -0500", hash_original_field = "A4682FEE4B3C0B03BEDF6244035A4A03", hash_generated_field = "D4E8778377795C8E2ACC264610934B4B")

    private  ColorStateList mTextColorLink;

    /**
     * Uses the specified TextAppearance resource to determine the
     * text appearance.  The <code>appearance</code> should be, for example,
     * <code>android.R.style.TextAppearance_Small</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.558 -0500", hash_original_method = "9B1172C0C8B31BFAE0D2C93687346AFE", hash_generated_method = "E13808B9D761C7FC4EC662B6B98D865E")
    
public TextAppearanceSpan(Context context, int appearance) {
        this(context, appearance, -1);
    }

    /**
     * Uses the specified TextAppearance resource to determine the
     * text appearance, and the specified text color resource
     * to determine the color.  The <code>appearance</code> should be,
     * for example, <code>android.R.style.TextAppearance_Small</code>,
     * and the <code>colorList</code> should be, for example,
     * <code>android.R.styleable.Theme_textColorPrimary</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.562 -0500", hash_original_method = "9317B5C63D080DC3774D9B3DFE979A1B", hash_generated_method = "817796371ED855BF67F0184F350184F0")
    
public TextAppearanceSpan(Context context, int appearance, int colorList) {
        ColorStateList textColor;
        
        TypedArray a =
            context.obtainStyledAttributes(appearance,
                                           com.android.internal.R.styleable.TextAppearance);

        textColor = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColor);
        mTextColorLink = a.getColorStateList(com.android.internal.R.styleable.
                                        TextAppearance_textColorLink);
        mTextSize = a.getDimensionPixelSize(com.android.internal.R.styleable.
                                        TextAppearance_textSize, -1);

        mStyle = a.getInt(com.android.internal.R.styleable.TextAppearance_textStyle, 0);
        int tf = a.getInt(com.android.internal.R.styleable.TextAppearance_typeface, 0);

        switch (tf) {
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
        }

        a.recycle();

        if (colorList >= 0) {
            a = context.obtainStyledAttributes(com.android.internal.R.style.Theme,
                                            com.android.internal.R.styleable.Theme);

            textColor = a.getColorStateList(colorList);
            a.recycle();
        }
        
        mTextColor = textColor;
    }

    /**
     * Makes text be drawn with the specified typeface, size, style,
     * and colors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.565 -0500", hash_original_method = "BC7BB9D16048D8ABD4B4822412C22F80", hash_generated_method = "BB768A6DB07301C01C1E1BDACA468A39")
    
public TextAppearanceSpan(String family, int style, int size,
                              ColorStateList color, ColorStateList linkColor) {
        mTypeface = family;
        mStyle = style;
        mTextSize = size;
        mTextColor = color;
        mTextColorLink = linkColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.568 -0500", hash_original_method = "0C8ADD28198996D9662262CC57DEB737", hash_generated_method = "54A78923DBD31DFD49506777A8B8664E")
    
public TextAppearanceSpan(Parcel src) {
        mTypeface = src.readString();
        mStyle = src.readInt();
        mTextSize = src.readInt();
        if (src.readInt() != 0) {
            mTextColor = ColorStateList.CREATOR.createFromParcel(src);
        } else {
            mTextColor = null;
        }
        if (src.readInt() != 0) {
            mTextColorLink = ColorStateList.CREATOR.createFromParcel(src);
        } else {
            mTextColorLink = null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.571 -0500", hash_original_method = "06416282EB1641FCC18F44A861BC9EFB", hash_generated_method = "5820CFA4EE5DA8B5A7814A237A6DD6C3")
    
public int getSpanTypeId() {
        return TextUtils.TEXT_APPEARANCE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.574 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.576 -0500", hash_original_method = "5C4A27F4DE181F367842F0367978AD5D", hash_generated_method = "C6D466EB680329C8888856F55D33E7A0")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTypeface);
        dest.writeInt(mStyle);
        dest.writeInt(mTextSize);
        if (mTextColor != null) {
            dest.writeInt(1);
            mTextColor.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
        if (mTextColorLink != null) {
            dest.writeInt(1);
            mTextColorLink.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
    }

    /**
     * Returns the typeface family specified by this span, or <code>null</code>
     * if it does not specify one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.579 -0500", hash_original_method = "15042A588BD36B3AABC957E25B6ABB68", hash_generated_method = "4AB3A6DA8541DBE92DCA2D2683522159")
    
public String getFamily() {
        return mTypeface;
    }

    /**
     * Returns the text color specified by this span, or <code>null</code>
     * if it does not specify one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.581 -0500", hash_original_method = "BEF77474BA0C11C6EB44F1454E52790F", hash_generated_method = "9575CAE1AB7C631C9C79687563375B9B")
    
public ColorStateList getTextColor() {
        return mTextColor;
    }

    /**
     * Returns the link color specified by this span, or <code>null</code>
     * if it does not specify one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.584 -0500", hash_original_method = "9E3E27CD0F13B768F4263E5569C857AD", hash_generated_method = "242170C0CE7903861CC2ABF1C2ABA3F4")
    
public ColorStateList getLinkTextColor() {
        return mTextColorLink;
    }

    /**
     * Returns the text size specified by this span, or <code>-1</code>
     * if it does not specify one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.587 -0500", hash_original_method = "AB3DB1BB0D199EBBBA8548C5EC0C310E", hash_generated_method = "5F28BA7CEBEC3E497D8525F54BB31DC9")
    
public int getTextSize() {
        return mTextSize;
    }

    /**
     * Returns the text style specified by this span, or <code>0</code>
     * if it does not specify one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.589 -0500", hash_original_method = "3C882FE9CECBB039C8EAD0BA2E56F794", hash_generated_method = "23EFD0FF59218581C82FF50B58AECE14")
    
public int getTextStyle() {
        return mStyle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.592 -0500", hash_original_method = "91F606F0F4AED8EEECD78BF397028020", hash_generated_method = "8D3D05CD6A573AE4E201562175EA137B")
    
@Override
    public void updateDrawState(TextPaint ds) {
        updateMeasureState(ds);

        if (mTextColor != null) {
            ds.setColor(mTextColor.getColorForState(ds.drawableState, 0));
        }

        if (mTextColorLink != null) {
            ds.linkColor = mTextColorLink.getColorForState(ds.drawableState, 0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.596 -0500", hash_original_method = "F4F67354DC20CE392F9DCE12B9A9C5F1", hash_generated_method = "99EAFD0473F9092FB35C400190F2142B")
    
@Override
    public void updateMeasureState(TextPaint ds) {
        if (mTypeface != null || mStyle != 0) {
            Typeface tf = ds.getTypeface();
            int style = 0;

            if (tf != null) {
                style = tf.getStyle();
            }

            style |= mStyle;

            if (mTypeface != null) {
                tf = Typeface.create(mTypeface, style);
            } else if (tf == null) {
                tf = Typeface.defaultFromStyle(style);
            } else {
                tf = Typeface.create(tf, style);
            }

            int fake = style & ~tf.getStyle();

            if ((fake & Typeface.BOLD) != 0) {
                ds.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                ds.setTextSkewX(-0.25f);
            }

            ds.setTypeface(tf);
        }

        if (mTextSize > 0) {
            ds.setTextSize(mTextSize);
        }
    }

    
}

