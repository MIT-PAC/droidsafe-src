package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class StyleSpan extends MetricAffectingSpan implements ParcelableSpan {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.199 -0500", hash_original_method = "632179F62463F6D980B0D3B45549D120", hash_generated_method = "E5425591F0412B59950C6878EA16F6B0")
    
private static void apply(Paint paint, int style) {
        int oldStyle;

        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int want = oldStyle | style;

        Typeface tf;
        if (old == null) {
            tf = Typeface.defaultFromStyle(want);
        } else {
            tf = Typeface.create(old, want);
        }

        int fake = want & ~tf.getStyle();

        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.175 -0500", hash_original_field = "33CDAE5A87225928D8656C9A774A9266", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

	private  int mStyle;

	/**
	 * 
	 * @param style An integer constant describing the style for this span. Examples
	 * include bold, italic, and normal. Values are constants defined 
	 * in {@link android.graphics.Typeface}.
	 */
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.178 -0500", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "1A3F07DA3D717E13281805DCEB7FE7E0")
    
public StyleSpan(int style) {
		mStyle = style;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.181 -0500", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "6944F4FE74A111095F8D75B56C19FA70")
    
public StyleSpan(Parcel src) {
        mStyle = src.readInt();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.183 -0500", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "E9A47A9C453074578F9B5591657DFA2C")
    
public int getSpanTypeId() {
        return TextUtils.STYLE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.186 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.188 -0500", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "41C7F61B1A1892F049E1FE28D96ED7AB")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStyle);
    }

	/**
	 * Returns the style constant defined in {@link android.graphics.Typeface}. 
	 */
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.190 -0500", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "0483C07B81F11407B89CC2952582DCF6")
    
public int getStyle() {
		return mStyle;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.193 -0500", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "8F230C0A581B27C22D726BD3C10AFB08")
    
@Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mStyle);
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.195 -0500", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "C6F7FBFBCCF41841C0BD7BCBB4689879")
    
@Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mStyle);
    }
    
}

