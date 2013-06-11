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

public class StyleSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final int mStyle;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "5516F0C4044654F8C445CB02D215E35B")
    @DSModeled(DSC.SAFE)
    public StyleSpan(int style) {
        dsTaint.addTaint(style);
        // ---------- Original Method ----------
        //mStyle = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "CE9071D3EB6E90EC75E7A1AD637F79CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StyleSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mStyle = src.readInt();
        // ---------- Original Method ----------
        //mStyle = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "3D579FB68A637C0C708E63B70E596E06")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.STYLE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "BFE579682EB06FFB1112AB5A97214A85")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mStyle);
        // ---------- Original Method ----------
        //dest.writeInt(mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "2DDD2020A4C52280B4F6E160C7C191FB")
    @DSModeled(DSC.SAFE)
    public int getStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "3246173180D24F8587AB94D6D184CC03")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        apply(ds, mStyle);
        // ---------- Original Method ----------
        //apply(ds, mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "91B2E349C16EA55239E9A4B7D433DC4A")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateMeasureState(TextPaint paint) {
        dsTaint.addTaint(paint.dsTaint);
        apply(paint, mStyle);
        // ---------- Original Method ----------
        //apply(paint, mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.317 -0400", hash_original_method = "632179F62463F6D980B0D3B45549D120", hash_generated_method = "E5425591F0412B59950C6878EA16F6B0")
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


