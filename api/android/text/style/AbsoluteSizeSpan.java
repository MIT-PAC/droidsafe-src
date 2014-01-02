package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.883 -0500", hash_original_field = "205262C28D2B190751535A4911B3B259", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")


    private  int mSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.885 -0500", hash_original_field = "9E4EA6749E436A4CDB41A8DF2E48BA64", hash_generated_field = "2907C85C29B7CCA19FB98273C79A6D33")

    private boolean mDip;

    /**
     * Set the text size to <code>size</code> physical pixels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.888 -0500", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "A25B9B6C1CBF06EAF34257BEF6967579")
    
public AbsoluteSizeSpan(int size) {
        mSize = size;
    }

    /**
     * Set the text size to <code>size</code> physical pixels,
     * or to <code>size</code> device-independent pixels if
     * <code>dip</code> is true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.891 -0500", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "52231DDFA78692940605245633DE0D64")
    
public AbsoluteSizeSpan(int size, boolean dip) {
        mSize = size;
        mDip = dip;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.893 -0500", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "9710953588BBCD8CCD514AD13A6B26A2")
    
public AbsoluteSizeSpan(Parcel src) {
        mSize = src.readInt();
        mDip = src.readInt() != 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.896 -0500", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "8B8FD8107EAC0D44DB88652626E9054C")
    
public int getSpanTypeId() {
        return TextUtils.ABSOLUTE_SIZE_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.898 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.901 -0500", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "BE1229E47D431A511687138451D4A2D4")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.904 -0500", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "5C0A5CB4DD3116647C99AA4ADB19626C")
    
public int getSize() {
        return mSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.907 -0500", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "EF7075792C061613644F3FB25C32CBD8")
    
public boolean getDip() {
        return mDip;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.909 -0500", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "AACE070B9A57AEDB9F1C09CD6A65EAD2")
    
@Override
    public void updateDrawState(TextPaint ds) {
        if (mDip) {
            ds.setTextSize(mSize * ds.density);
        } else {
            ds.setTextSize(mSize);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.912 -0500", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "3485EC12B4D711B3337A89E1A1ABFDA4")
    
@Override
    public void updateMeasureState(TextPaint ds) {
        if (mDip) {
            ds.setTextSize(mSize * ds.density);
        } else {
            ds.setTextSize(mSize);
        }
    }

    
}

