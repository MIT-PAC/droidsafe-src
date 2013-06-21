package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class TypefaceSpan extends MetricAffectingSpan implements ParcelableSpan {
    private String mFamily;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.021 -0400", hash_original_method = "30225DE18E1EF58337803047C2C7576B", hash_generated_method = "6A0272009ED170059069ADF53C988380")
    @DSModeled(DSC.SAFE)
    public TypefaceSpan(String family) {
        dsTaint.addTaint(family);
        // ---------- Original Method ----------
        //mFamily = family;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.021 -0400", hash_original_method = "EBFC14963D531976FE4CEA16F8670D1D", hash_generated_method = "E77C613F6E81608D84AEE286CD1E5A4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypefaceSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mFamily = src.readString();
        // ---------- Original Method ----------
        //mFamily = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.021 -0400", hash_original_method = "07DD5A556D8AFD5FB18137B3F1261BE3", hash_generated_method = "C8E250ABA1BBF24EB297FF702B241835")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.TYPEFACE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.021 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.022 -0400", hash_original_method = "3222DFE1438A7B94741074BF5C471F95", hash_generated_method = "B802A7A7673E802E3A1969A8537EE96F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mFamily);
        // ---------- Original Method ----------
        //dest.writeString(mFamily);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.022 -0400", hash_original_method = "A22822B6578A7051FA8E71732705B93C", hash_generated_method = "CFC81ED507AA631CEFD9DC5D34DA2C7E")
    @DSModeled(DSC.SAFE)
    public String getFamily() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFamily;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.022 -0400", hash_original_method = "1FF2F211A2A46041B93FC8FF91A72EF9", hash_generated_method = "8A65434923DC3547937B22A7E34667E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        apply(ds, mFamily);
        // ---------- Original Method ----------
        //apply(ds, mFamily);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.022 -0400", hash_original_method = "EDA342B19CEA5F662FF3BE7187A11677", hash_generated_method = "CB0500F92075AC6B3FF2C3EA8B146251")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint paint) {
        dsTaint.addTaint(paint.dsTaint);
        apply(paint, mFamily);
        // ---------- Original Method ----------
        //apply(paint, mFamily);
    }

    
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

