package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class StrikethroughSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.541 -0500", hash_original_method = "70702F8DA78154CC84DD659B0C371894", hash_generated_method = "C977F971DFA9B70EA5AE0BAB05208620")
    
public StrikethroughSpan() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.544 -0500", hash_original_method = "D18CB35A7B1E8FEC4B878F7114956CE8", hash_generated_method = "4FF3ABA785993BB43021A3C3C0C3C367")
    
public StrikethroughSpan(Parcel src) {
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.547 -0500", hash_original_method = "4F4EC815E74FCC73E9106D709A5A342D", hash_generated_method = "42C80CB323A7987661535D10FF2135FA")
    
public int getSpanTypeId() {
        return TextUtils.STRIKETHROUGH_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.549 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.552 -0500", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "ED3C20853EE283140D61863E7CC05F99")
    
public void writeToParcel(Parcel dest, int flags) {
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.554 -0500", hash_original_method = "405DAF545E7B8CA376105971B6D6FF49", hash_generated_method = "77F7E6ED05F8E6341B9B2085553A748D")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.setStrikeThruText(true);
	}
    
}

