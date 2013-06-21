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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.940 -0400", hash_original_method = "416865739F2C1ABBE61451113480FAB4", hash_generated_method = "431381B5FAFD384F6FEF99A75F935F86")
    @DSModeled(DSC.SAFE)
    public SubscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.941 -0400", hash_original_method = "71E3921D1341E00E4D27F607004C29AC", hash_generated_method = "20D6B1D3E3020D1CC174B660AC5F5F2D")
    @DSModeled(DSC.SAFE)
    public SubscriptSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.941 -0400", hash_original_method = "CB8400634E0A005DFA226D39FFA147D9", hash_generated_method = "BAB6E9CC52219FBAE72B51D544B60AB0")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUBSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.941 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.941 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "5AF02C39344A4D99F1196D802145D467")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.941 -0400", hash_original_method = "9DCCA482100D1E9EC8F2615F051D6490", hash_generated_method = "853ADD9BEB83A7A3DF440814D19BC89E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.942 -0400", hash_original_method = "7DFDD8213FBD02BEC2253684A70AD5F4", hash_generated_method = "02729D01CDAB52E17A8402E6647E7938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
}

