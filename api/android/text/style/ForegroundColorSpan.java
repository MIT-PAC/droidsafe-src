package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.722 -0500", hash_original_field = "CF1046E2EF6F9B2B63BE18A3B2BC71FD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")


    private  int mColor;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.725 -0500", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "45EC880AE53DCB2510F24924B0275E08")
    
public ForegroundColorSpan(int color) {
		mColor = color;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.728 -0500", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "E356BF977DE3BC5A3638E068D80A9555")
    
public ForegroundColorSpan(Parcel src) {
        mColor = src.readInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.731 -0500", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "1E333E0A391913A39029DA1ECAA4C4C3")
    
public int getSpanTypeId() {
        return TextUtils.FOREGROUND_COLOR_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.734 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.737 -0500", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "5D25898D16D89B2F14A8038422877D91")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.739 -0500", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "B912D85C9C793468EB70215DAAB63BD1")
    
public int getForegroundColor() {
		return mColor;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.742 -0500", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "3C6F8B2684F3190CD751A0B8669370D1")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.setColor(mColor);
	}

    
}

