package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class StrikethroughSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.286 -0400", hash_original_method = "70702F8DA78154CC84DD659B0C371894", hash_generated_method = "DE2AFB86A0D61FBD8C253D51FF49314A")
    public  StrikethroughSpan() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.287 -0400", hash_original_method = "D18CB35A7B1E8FEC4B878F7114956CE8", hash_generated_method = "A661FA7F8A41B3C8F80242BB82FF70AB")
    public  StrikethroughSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.287 -0400", hash_original_method = "4F4EC815E74FCC73E9106D709A5A342D", hash_generated_method = "5290EB12694B37C81820ECE933174E40")
    public int getSpanTypeId() {
        int var25086A53E0202AD1490D4409D58EA8CF_1226872977 = (TextUtils.STRIKETHROUGH_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843966974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843966974;
        // ---------- Original Method ----------
        //return TextUtils.STRIKETHROUGH_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.288 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9490A3B3091C3B7B8A105325243A0CA9")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_129530312 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557939025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557939025;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.288 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "D6F5FAEE7A649F263C37D62D8A41EDFC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.288 -0400", hash_original_method = "405DAF545E7B8CA376105971B6D6FF49", hash_generated_method = "89A7F8E9C41ADDAF22957A85A1E63438")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setStrikeThruText(true);
        // ---------- Original Method ----------
        //ds.setStrikeThruText(true);
    }

    
}

