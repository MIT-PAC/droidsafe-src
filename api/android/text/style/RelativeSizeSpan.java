package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class RelativeSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.083 -0500", hash_original_field = "859F89A95EA81D453D987D576B8DE2B6", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")


	private  float mProportion;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.086 -0500", hash_original_method = "A7FADA85249F1B8943B2C3745C9AD73C", hash_generated_method = "DDB2669CFC4AE8ADAE8FB516D9CF6198")
    
public RelativeSizeSpan(float proportion) {
		mProportion = proportion;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.089 -0500", hash_original_method = "3E1E83FB4F6546C2007DF6E3D1177212", hash_generated_method = "D6E81724594499068C6BAC398C52CBE5")
    
public RelativeSizeSpan(Parcel src) {
        mProportion = src.readFloat();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.091 -0500", hash_original_method = "D2254CF1E8362BBCA36C2E8295131004", hash_generated_method = "1972884810E209123C5BD1C346BEDA83")
    
public int getSpanTypeId() {
        return TextUtils.RELATIVE_SIZE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.095 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.097 -0500", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "6269EB970CDD3F9298E6DD0FFC02ACA2")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mProportion);
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.100 -0500", hash_original_method = "E89C4B67E9A9CE5F6854A6F0C8388FE6", hash_generated_method = "6BB9212972B7C36B9AE0E94B2ACC0633")
    
public float getSizeChange() {
		return mProportion;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.102 -0500", hash_original_method = "D87A5BB37ACAA736C762D797F93AD23D", hash_generated_method = "83A3EDD74190D30640C440629739D245")
    
@Override
	public void updateDrawState(TextPaint ds) {
		ds.setTextSize(ds.getTextSize() * mProportion);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.104 -0500", hash_original_method = "B20FAC1EC83BD8EFC8CAF1EE401E0C1F", hash_generated_method = "55632735833C92C2B6AEB4DF5A137329")
    
@Override
	public void updateMeasureState(TextPaint ds) {
		ds.setTextSize(ds.getTextSize() * mProportion);
	}

    
}

