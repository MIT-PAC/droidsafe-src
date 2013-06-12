package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SubscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "416865739F2C1ABBE61451113480FAB4", hash_generated_method = "89FF16A9B1AF9CAF7D07071FF9361918")
    @DSModeled(DSC.SAFE)
    public SubscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "71E3921D1341E00E4D27F607004C29AC", hash_generated_method = "67E4ACD98C90580079A5382A27EA294B")
    @DSModeled(DSC.SAFE)
    public SubscriptSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "CB8400634E0A005DFA226D39FFA147D9", hash_generated_method = "2FF33F3075A7F7B89011A11FA638C90B")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUBSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "3D9BE3A3714B4F82FD0627A2AF4A91CB")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "9DCCA482100D1E9EC8F2615F051D6490", hash_generated_method = "C7D1990E765DFFA83845F9FECABDA4CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.318 -0400", hash_original_method = "7DFDD8213FBD02BEC2253684A70AD5F4", hash_generated_method = "F99671864CC246D407363A8845D53F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift -= (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
}


