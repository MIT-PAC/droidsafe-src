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

public class StrikethroughSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.924 -0400", hash_original_method = "70702F8DA78154CC84DD659B0C371894", hash_generated_method = "DE2AFB86A0D61FBD8C253D51FF49314A")
    @DSModeled(DSC.SAFE)
    public StrikethroughSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.924 -0400", hash_original_method = "D18CB35A7B1E8FEC4B878F7114956CE8", hash_generated_method = "B6C043EE43FC7DA3EC9E66240CB7119C")
    @DSModeled(DSC.SAFE)
    public StrikethroughSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.924 -0400", hash_original_method = "4F4EC815E74FCC73E9106D709A5A342D", hash_generated_method = "72F9C20D0AED5A60EC56C3B13E7BA1BD")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.STRIKETHROUGH_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.924 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.924 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "5AF02C39344A4D99F1196D802145D467")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.934 -0400", hash_original_method = "405DAF545E7B8CA376105971B6D6FF49", hash_generated_method = "5014251CE1341B3FA36A5EB1C07749FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setStrikeThruText(true);
        // ---------- Original Method ----------
        //ds.setStrikeThruText(true);
    }

    
}

