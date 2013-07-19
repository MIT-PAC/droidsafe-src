package android.text.style;

// Droidsafe Imports
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SuperscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.233 -0400", hash_original_method = "A61AB96C11E77F6A36ED29C74BA40E45", hash_generated_method = "DE65DBC0A53FF2E3ADE17A2A294E4A04")
    public  SuperscriptSpan() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.233 -0400", hash_original_method = "B19848584389A2607BE1DAAEB2FA7668", hash_generated_method = "5D2C230AE1780D325FE9D87CD354E471")
    public  SuperscriptSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.233 -0400", hash_original_method = "0CB176122CE000C44267FEA34CA341C1", hash_generated_method = "8532C236C1DCC66898D9843965E65779")
    public int getSpanTypeId() {
        int var0E518E173722522EFA552FF3B1AAE76F_288446471 = (TextUtils.SUPERSCRIPT_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597127325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597127325;
        // ---------- Original Method ----------
        //return TextUtils.SUPERSCRIPT_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.234 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FBF4E99C7AB0AD72CD5199E4399BF881")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1315407323 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955732209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955732209;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.234 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "D6F5FAEE7A649F263C37D62D8A41EDFC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.234 -0400", hash_original_method = "E27C5F044B669DD3305C3952779CC951", hash_generated_method = "42A3B9D0EB3FD803930315C10C283C0C")
    @Override
    public void updateDrawState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.235 -0400", hash_original_method = "A4B2093D2F6B24A1446298F151C8C815", hash_generated_method = "B14899546C2E64A9D16245795AB7C4E7")
    @Override
    public void updateMeasureState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
}

