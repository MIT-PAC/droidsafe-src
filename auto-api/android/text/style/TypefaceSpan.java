package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class TypefaceSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final String mFamily;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.360 -0400", hash_original_method = "30225DE18E1EF58337803047C2C7576B", hash_generated_method = "73DB2DA51BCD54747532CA65E0D52377")
    @DSModeled(DSC.SAFE)
    public TypefaceSpan(String family) {
        dsTaint.addTaint(family);
        // ---------- Original Method ----------
        //mFamily = family;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.360 -0400", hash_original_method = "EBFC14963D531976FE4CEA16F8670D1D", hash_generated_method = "781C4FBEFC1A86D0CD8AC3ECAA2D2A6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypefaceSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mFamily = src.readString();
        // ---------- Original Method ----------
        //mFamily = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.360 -0400", hash_original_method = "07DD5A556D8AFD5FB18137B3F1261BE3", hash_generated_method = "C7E6E5A40C374AD427CE4652EC60126C")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.TYPEFACE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.360 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.360 -0400", hash_original_method = "3222DFE1438A7B94741074BF5C471F95", hash_generated_method = "B76D60717CF6FDE8E554B6D4E3CFA444")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(mFamily);
        // ---------- Original Method ----------
        //dest.writeString(mFamily);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "A22822B6578A7051FA8E71732705B93C", hash_generated_method = "D307EC7FE8D89ADB703E91159CE8150B")
    @DSModeled(DSC.SAFE)
    public String getFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "1FF2F211A2A46041B93FC8FF91A72EF9", hash_generated_method = "78125169DDB5FF9D06FCDEF66F43610E")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        apply(ds, mFamily);
        // ---------- Original Method ----------
        //apply(ds, mFamily);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "EDA342B19CEA5F662FF3BE7187A11677", hash_generated_method = "42F1D206C9EDFE4247C3D96BE31E07D7")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateMeasureState(TextPaint paint) {
        dsTaint.addTaint(paint.dsTaint);
        apply(paint, mFamily);
        // ---------- Original Method ----------
        //apply(paint, mFamily);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "ED714DD63FC851B11BFBFDFA48AE4364", hash_generated_method = "E7F430CA5C43CD544BC69EB7E39A9817")
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

    
}


