package android.text.style;

// Droidsafe Imports
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SubscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.135 -0400", hash_original_method = "416865739F2C1ABBE61451113480FAB4", hash_generated_method = "431381B5FAFD384F6FEF99A75F935F86")
    public  SubscriptSpan() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.135 -0400", hash_original_method = "71E3921D1341E00E4D27F607004C29AC", hash_generated_method = "E3F85E1D6FA0CC2C53BEF83804B496BD")
    public  SubscriptSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.136 -0400", hash_original_method = "CB8400634E0A005DFA226D39FFA147D9", hash_generated_method = "8D10B18893717CDEB298A97989AA7B95")
    public int getSpanTypeId() {
        int var1651419F4E7D40404DADB1DF2FD15B0B_619995402 = (TextUtils.SUBSCRIPT_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109253515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109253515;
        // ---------- Original Method ----------
        //return TextUtils.SUBSCRIPT_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.136 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7055E3092C0B8CD8EED37BE70E18B38F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_292063148 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307593481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307593481;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.137 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "D6F5FAEE7A649F263C37D62D8A41EDFC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.138 -0400", hash_original_method = "9DCCA482100D1E9EC8F2615F051D6490", hash_generated_method = "17B54659B5DD5B84BBA88EC58D83E857")
    @Override
    public void updateDrawState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.139 -0400", hash_original_method = "7DFDD8213FBD02BEC2253684A70AD5F4", hash_generated_method = "4AA39604495A204D5F0B12FC74DD8DD0")
    @Override
    public void updateMeasureState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
}

