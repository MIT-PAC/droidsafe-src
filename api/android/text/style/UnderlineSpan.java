package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;




public class UnderlineSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.698 -0500", hash_original_method = "0961EBA9EB7C20D52B677528162BDFE2", hash_generated_method = "65F63C6B3B84B4696FABA57EF724E21D")
    
public UnderlineSpan() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.702 -0500", hash_original_method = "2F10E98AFC8F657229593A567035B72B", hash_generated_method = "DABF1A9716B11D69C1674E3BC9AADA93")
    
public UnderlineSpan(Parcel src) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.704 -0500", hash_original_method = "98FDD0C5C920ADC9B5642E26AAA3CBE6", hash_generated_method = "5D2570FC5CBA9827E8A5B1F6ECC72ED9")
    
public int getSpanTypeId() {
        return TextUtils.UNDERLINE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.706 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.709 -0500", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "ED3C20853EE283140D61863E7CC05F99")
    
public void writeToParcel(Parcel dest, int flags) {
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.711 -0500", hash_original_method = "0AB5A88A5517CF0706AB68CD6097189A", hash_generated_method = "8A61894DF82201317A7D4E62F5640FF1")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.setUnderlineText(true);
	}

    
}

