package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SubscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.900 -0400", hash_original_method = "416865739F2C1ABBE61451113480FAB4", hash_generated_method = "431381B5FAFD384F6FEF99A75F935F86")
    public  SubscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.900 -0400", hash_original_method = "71E3921D1341E00E4D27F607004C29AC", hash_generated_method = "E3F85E1D6FA0CC2C53BEF83804B496BD")
    public  SubscriptSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.900 -0400", hash_original_method = "CB8400634E0A005DFA226D39FFA147D9", hash_generated_method = "C3F1630AF610C88836A5051A25CC0636")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819775634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819775634;
        // ---------- Original Method ----------
        //return TextUtils.SUBSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.901 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EBD38C9B44D6E7E248838C456AAC85F9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50092522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50092522;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.901 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "E7DBC20584A55C26974D54383A48E9F7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.901 -0400", hash_original_method = "9DCCA482100D1E9EC8F2615F051D6490", hash_generated_method = "D1E1706279C9F8A9EF8CDDF2CF68D55C")
    @Override
    public void updateDrawState(TextPaint tp) {
        tp.baselineShift -= (int) (tp.ascent() / 2);
        addTaint(tp.getTaint());
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.902 -0400", hash_original_method = "7DFDD8213FBD02BEC2253684A70AD5F4", hash_generated_method = "1A8037C31851F13711CF3284149B246F")
    @Override
    public void updateMeasureState(TextPaint tp) {
        tp.baselineShift -= (int) (tp.ascent() / 2);
        addTaint(tp.getTaint());
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
}

