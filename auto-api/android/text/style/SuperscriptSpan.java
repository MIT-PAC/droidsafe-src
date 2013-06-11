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

public class SuperscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "A61AB96C11E77F6A36ED29C74BA40E45", hash_generated_method = "AA13076500228BC8C19E934116BEF120")
    @DSModeled(DSC.SAFE)
    public SuperscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "B19848584389A2607BE1DAAEB2FA7668", hash_generated_method = "541E8A6B6A0D973261DC23226E564357")
    @DSModeled(DSC.SAFE)
    public SuperscriptSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "0CB176122CE000C44267FEA34CA341C1", hash_generated_method = "30021FF883EE37EE89EDC560FD31152B")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUPERSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "3D9BE3A3714B4F82FD0627A2AF4A91CB")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "E27C5F044B669DD3305C3952779CC951", hash_generated_method = "A497A4E062570969E80D2B53A5826657")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.343 -0400", hash_original_method = "A4B2093D2F6B24A1446298F151C8C815", hash_generated_method = "8CB4F114B7AAF4192D5D8AFA2AAFFCB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
}


