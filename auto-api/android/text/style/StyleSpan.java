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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.085 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.092 -0400", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "20E261DB45592C7A8E2B0565C32D51B3")
    public  StyleSpan(int style) {
        mStyle = style;
        // ---------- Original Method ----------
        //mStyle = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.093 -0400", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "DA3F115CA81C47BA19C70316FB6DD3C3")
    public  StyleSpan(Parcel src) {
        mStyle = src.readInt();
        // ---------- Original Method ----------
        //mStyle = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.098 -0400", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "665E051D69DF8F11E751C714810223DE")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881282985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881282985;
        // ---------- Original Method ----------
        //return TextUtils.STYLE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.104 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DEA1BCC349C9B6C7BD9A63F87051479D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779956524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779956524;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.109 -0400", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "AEFE324C6D2DD56DF1A0D9A77D7D3A9F")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStyle);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.109 -0400", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "0BE073D9FB9C5652E1FA9E423CC8C9D4")
    public int getStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664099542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664099542;
        // ---------- Original Method ----------
        //return mStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.109 -0400", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "E364188F21EA713099CD2402C631CAF2")
    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mStyle);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //apply(ds, mStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.110 -0400", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "CE2E525CD4AB250DB76C4A2C66201128")
    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mStyle);
        addTaint(paint.getTaint());
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

