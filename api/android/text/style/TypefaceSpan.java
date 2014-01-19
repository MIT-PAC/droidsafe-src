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

public class TypefaceSpan extends MetricAffectingSpan implements ParcelableSpan {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.019 -0500", hash_original_method = "ED714DD63FC851B11BFBFDFA48AE4364", hash_generated_method = "E7F430CA5C43CD544BC69EB7E39A9817")
    
private static void apply(Paint paint, String family) {
        int oldStyle;

        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        Typeface tf = Typeface.create(family, oldStyle);
        int fake = oldStyle & ~tf.getStyle();

        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.995 -0500", hash_original_field = "BD3B3D220B95779753C72932A6E9366B", hash_generated_field = "9590C932BAED724FD12B55F1BADC30FA")

    private  String mFamily;

    /**
     * @param family The font family for this typeface.  Examples include
     * "monospace", "serif", and "sans-serif".
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.998 -0500", hash_original_method = "30225DE18E1EF58337803047C2C7576B", hash_generated_method = "E512622B6AD4EA72458E817A953BD263")
    
public TypefaceSpan(String family) {
        mFamily = family;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.001 -0500", hash_original_method = "EBFC14963D531976FE4CEA16F8670D1D", hash_generated_method = "99797FAA81087C5834D39ABA8570E5D1")
    
public TypefaceSpan(Parcel src) {
        mFamily = src.readString();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.004 -0500", hash_original_method = "07DD5A556D8AFD5FB18137B3F1261BE3", hash_generated_method = "6C7395228F840CFAF5B7706030813A2A")
    
public int getSpanTypeId() {
        return TextUtils.TYPEFACE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.007 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.009 -0500", hash_original_method = "3222DFE1438A7B94741074BF5C471F95", hash_generated_method = "51277D345CE76D3D1C320B5B6FCE1219")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFamily);
    }

    /**
     * Returns the font family name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.011 -0500", hash_original_method = "A22822B6578A7051FA8E71732705B93C", hash_generated_method = "FBA6554ECC41D538C8462DBE55F6F7DF")
    
public String getFamily() {
        return mFamily;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.014 -0500", hash_original_method = "1FF2F211A2A46041B93FC8FF91A72EF9", hash_generated_method = "8BD81F1934CE6DCB00F20FA831CE6357")
    
@Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mFamily);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.016 -0500", hash_original_method = "EDA342B19CEA5F662FF3BE7187A11677", hash_generated_method = "7DC5ABCFB5B2388783AA7317BA8B4C1B")
    
@Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mFamily);
    }
    
}

