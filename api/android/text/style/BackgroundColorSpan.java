package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.796 -0500", hash_original_field = "CF1046E2EF6F9B2B63BE18A3B2BC71FD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")


    private  int mColor;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.799 -0500", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "2BE46F90653194AA0EA6BE54B715823F")
    
public BackgroundColorSpan(int color) {
		mColor = color;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.802 -0500", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "1AA25EFAED937732392AEB3688A55E59")
    
public BackgroundColorSpan(Parcel src) {
        mColor = src.readInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.804 -0500", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "A571725B2EED3A9BAADBD3F7FF75B3BA")
    
public int getSpanTypeId() {
        return TextUtils.BACKGROUND_COLOR_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.806 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.809 -0500", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "5D25898D16D89B2F14A8038422877D91")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.812 -0500", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "EF4C76447B892CD3AFF0D6AAAB37436B")
    
public int getBackgroundColor() {
		return mColor;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.815 -0500", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "D3D860E9C1D9F021148DD577729D7D5C")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.bgColor = mColor;
	}

    
}

