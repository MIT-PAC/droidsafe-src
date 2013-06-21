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

public class StyleSpan extends MetricAffectingSpan implements ParcelableSpan {
    private int mStyle;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.938 -0400", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "82C18918F70D9D1B44399AA4986C6786")
    @DSModeled(DSC.SAFE)
    public StyleSpan(int style) {
        dsTaint.addTaint(style);
        // ---------- Original Method ----------
        //mStyle = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.938 -0400", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "308712177C161310AA0833EF47160E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StyleSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mStyle = src.readInt();
        // ---------- Original Method ----------
        //mStyle = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.938 -0400", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "8F1E7EF17C57F6A84BE4CFBFBEC12FBA")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.STYLE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.938 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.939 -0400", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "F8372E2C6FAE1BAEDFCEBBFC4FB81A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mStyle);
        // ---------- Original Method ----------
        //dest.writeInt(mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.939 -0400", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "2AB6BE57834CD959EE2F40B95E6B8721")
    @DSModeled(DSC.SAFE)
    public int getStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.939 -0400", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "21A3D114B78225DE9F9785FF01C9C752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        apply(ds, mStyle);
        // ---------- Original Method ----------
        //apply(ds, mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.939 -0400", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "E9435BAFD70E4C5BD6C788E546A2E6C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint paint) {
        dsTaint.addTaint(paint.dsTaint);
        apply(paint, mStyle);
        // ---------- Original Method ----------
        //apply(paint, mStyle);
    }

    
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

    
}

