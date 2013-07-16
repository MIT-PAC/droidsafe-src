package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SuperscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.415 -0400", hash_original_method = "A61AB96C11E77F6A36ED29C74BA40E45", hash_generated_method = "DE65DBC0A53FF2E3ADE17A2A294E4A04")
    public  SuperscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.416 -0400", hash_original_method = "B19848584389A2607BE1DAAEB2FA7668", hash_generated_method = "5D2C230AE1780D325FE9D87CD354E471")
    public  SuperscriptSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.416 -0400", hash_original_method = "0CB176122CE000C44267FEA34CA341C1", hash_generated_method = "347571006C0BA6C70C142B9C4AF2C464")
    public int getSpanTypeId() {
        int var0E518E173722522EFA552FF3B1AAE76F_1899182019 = (TextUtils.SUPERSCRIPT_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598478661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598478661;
        // ---------- Original Method ----------
        //return TextUtils.SUPERSCRIPT_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.417 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DDF183238C6DDC0D2435AB54B51A80D0")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2065589636 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915839716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915839716;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.418 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "D6F5FAEE7A649F263C37D62D8A41EDFC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.418 -0400", hash_original_method = "E27C5F044B669DD3305C3952779CC951", hash_generated_method = "42A3B9D0EB3FD803930315C10C283C0C")
    @Override
    public void updateDrawState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.419 -0400", hash_original_method = "A4B2093D2F6B24A1446298F151C8C815", hash_generated_method = "B14899546C2E64A9D16245795AB7C4E7")
    @Override
    public void updateMeasureState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
}

