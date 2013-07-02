package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class StrikethroughSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.881 -0400", hash_original_method = "70702F8DA78154CC84DD659B0C371894", hash_generated_method = "DE2AFB86A0D61FBD8C253D51FF49314A")
    public  StrikethroughSpan() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.882 -0400", hash_original_method = "D18CB35A7B1E8FEC4B878F7114956CE8", hash_generated_method = "A661FA7F8A41B3C8F80242BB82FF70AB")
    public  StrikethroughSpan(Parcel src) {
        addTaint(src.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.883 -0400", hash_original_method = "4F4EC815E74FCC73E9106D709A5A342D", hash_generated_method = "29037ED1AAD619B07EBDB0EDCA35E0F8")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754766256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754766256;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.883 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D1AD544374BD11321B853EB72AD14A7A")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445039190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445039190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.884 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "E7DBC20584A55C26974D54383A48E9F7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.884 -0400", hash_original_method = "405DAF545E7B8CA376105971B6D6FF49", hash_generated_method = "E53E249A8041C9B8AA6A1D86389C6700")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setStrikeThruText(true);
        addTaint(ds.getTaint());
        
        
    }

    
}

