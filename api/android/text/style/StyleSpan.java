package android.text.style;

// Droidsafe Imports
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StyleSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.122 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2C93712457B79293762FFB4C4660914F")

    private int mStyle;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.123 -0400", hash_original_method = "CB9EF90D73212D1B02A5528CB9665E4D", hash_generated_method = "20E261DB45592C7A8E2B0565C32D51B3")
    public  StyleSpan(int style) {
        mStyle = style;
        // ---------- Original Method ----------
        //mStyle = style;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.123 -0400", hash_original_method = "02AE991FD30EFB3911FE5E70F7128BC4", hash_generated_method = "DA3F115CA81C47BA19C70316FB6DD3C3")
    public  StyleSpan(Parcel src) {
        mStyle = src.readInt();
        // ---------- Original Method ----------
        //mStyle = src.readInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.123 -0400", hash_original_method = "C2E273380763004C4C8E32A154731A96", hash_generated_method = "968B6E13AA1FA032DCBC73B1AD045691")
    public int getSpanTypeId() {
        int varF3183A428FC8564EC11BCC1E3FF8D45E_1392512714 = (TextUtils.STYLE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356165919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356165919;
        // ---------- Original Method ----------
        //return TextUtils.STYLE_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.123 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DD2262F95270B43EB0539F08079FAD20")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_836114726 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482125360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482125360;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.124 -0400", hash_original_method = "9FF3B3C6BD83D888752F465547E6E91F", hash_generated_method = "1F0A2BF71A3CCA0A43B05AC2E6EBA757")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mStyle);
        // ---------- Original Method ----------
        //dest.writeInt(mStyle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.124 -0400", hash_original_method = "6995AD72D9F4DF103A9CB7EC694D7036", hash_generated_method = "408A099516E98BBE5F1EF824CBD2981B")
    public int getStyle() {
        int var16896C9E7463BF6DF9DB6B58257F1327_349463719 = (mStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790424501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790424501;
        // ---------- Original Method ----------
        //return mStyle;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.124 -0400", hash_original_method = "71A0215A3FEBF509106C7457A8525E21", hash_generated_method = "95D3F0B6584DF4F6EAD90DAEF95D6B83")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        apply(ds, mStyle);
        // ---------- Original Method ----------
        //apply(ds, mStyle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.125 -0400", hash_original_method = "78F275D913B08D5544D3EE3C8B4C4B82", hash_generated_method = "45465076BF238EB8F479180D3B7FE967")
    @Override
    public void updateMeasureState(TextPaint paint) {
        addTaint(paint.getTaint());
        apply(paint, mStyle);
        // ---------- Original Method ----------
        //apply(paint, mStyle);
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

