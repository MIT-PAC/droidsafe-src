package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class StyleSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.892 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.892 -0400", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "20E261DB45592C7A8E2B0565C32D51B3")
    public  StyleSpan(int style) {
        mStyle = style;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.893 -0400", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "DA3F115CA81C47BA19C70316FB6DD3C3")
    public  StyleSpan(Parcel src) {
        mStyle = src.readInt();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.893 -0400", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "A5E582A70E5272643BC03FA954DFF815")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491945936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491945936;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.893 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7A3A45F169786F180686BE9DAA70DDBE")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925921224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925921224;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.894 -0400", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "AEFE324C6D2DD56DF1A0D9A77D7D3A9F")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStyle);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.894 -0400", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "7DD1EC4FE2A95BE30F02150A4A4B42E1")
    public int getStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093443683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093443683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.894 -0400", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "E364188F21EA713099CD2402C631CAF2")
    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mStyle);
        addTaint(ds.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.895 -0400", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "CE2E525CD4AB250DB76C4A2C66201128")
    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mStyle);
        addTaint(paint.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

