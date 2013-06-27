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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.781 -0400", hash_original_method = "70702F8DA78154CC84DD659B0C371894", hash_generated_method = "DE2AFB86A0D61FBD8C253D51FF49314A")
    public  StrikethroughSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.781 -0400", hash_original_method = "D18CB35A7B1E8FEC4B878F7114956CE8", hash_generated_method = "A661FA7F8A41B3C8F80242BB82FF70AB")
    public  StrikethroughSpan(Parcel src) {
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.782 -0400", hash_original_method = "4F4EC815E74FCC73E9106D709A5A342D", hash_generated_method = "6C6B20728E88755836CD7BE80B6D3504")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93826998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93826998;
        // ---------- Original Method ----------
        //return TextUtils.STRIKETHROUGH_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.783 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F52E7705452E5A8789EE21215BA9D835")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408493641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408493641;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.783 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "E7DBC20584A55C26974D54383A48E9F7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.784 -0400", hash_original_method = "405DAF545E7B8CA376105971B6D6FF49", hash_generated_method = "E53E249A8041C9B8AA6A1D86389C6700")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setStrikeThruText(true);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setStrikeThruText(true);
    }

    
}

