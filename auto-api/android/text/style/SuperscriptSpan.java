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

public class SuperscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.989 -0400", hash_original_method = "A61AB96C11E77F6A36ED29C74BA40E45", hash_generated_method = "DE65DBC0A53FF2E3ADE17A2A294E4A04")
    @DSModeled(DSC.SAFE)
    public SuperscriptSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.990 -0400", hash_original_method = "B19848584389A2607BE1DAAEB2FA7668", hash_generated_method = "A3CC050AFC49557A76C4E58D5FF869D4")
    @DSModeled(DSC.SAFE)
    public SuperscriptSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.992 -0400", hash_original_method = "0CB176122CE000C44267FEA34CA341C1", hash_generated_method = "0ECC8C189C99976BE465A00371936E06")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUPERSCRIPT_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.992 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.993 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "5AF02C39344A4D99F1196D802145D467")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.994 -0400", hash_original_method = "E27C5F044B669DD3305C3952779CC951", hash_generated_method = "DF62A316FD6454536B9BBD7011D10D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.994 -0400", hash_original_method = "A4B2093D2F6B24A1446298F151C8C815", hash_generated_method = "98A3B5D5C3A9D3F125B5165688590927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.baselineShift += (int) (tp.ascent() / 2);
        // ---------- Original Method ----------
        //tp.baselineShift += (int) (tp.ascent() / 2);
    }

    
}

