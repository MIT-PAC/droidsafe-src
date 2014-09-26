package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class ResultInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.541 -0400", hash_original_field = "0AD537D7B4AC3F7C300248CFF3FC2AEF", hash_generated_field = "D13876AA40E0BEAA5F9CE88B0DEDE86A")

    public static final Parcelable.Creator<ResultInfo> CREATOR
            = new Parcelable.Creator<ResultInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.236 -0500", hash_original_method = "826AEDDD26AEE1AF600D5589DF2DC45E", hash_generated_method = "3F26F88D8C10E39B8C7B5A6C03489489")
        
public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.238 -0500", hash_original_method = "D708841F6AE6B702AE483AC563E2586E", hash_generated_method = "EEF357D520331FCB0237567BC867B500")
        
public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.216 -0500", hash_original_field = "1732934EFC1D1342A42349680EA6209D", hash_generated_field = "9751D4E955A56AA5356026C082D57D65")

    public  String mResultWho;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.219 -0500", hash_original_field = "7DFBC3B390A93C26F8D09A6E08442EF1", hash_generated_field = "85DF646F4249AC1D2BDB38637924C61D")

    public  int mRequestCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.221 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "C5F755BFBAC5FACAF96067E93F13F919")

    public  int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.223 -0500", hash_original_field = "E7414990EEF8A5735FF106E5EF8844E8", hash_generated_field = "44EE18239FF473343B1B4A3246CBC87D")

    public  Intent mData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.225 -0500", hash_original_method = "5613E3DAA5C00F0B9643F3F13EB312FC", hash_generated_method = "5BCAEE19652BA7054F796C4388B16F42")
    
public ResultInfo(String resultWho, int requestCode, int resultCode,
            Intent data) {
        mResultWho = resultWho;
        mRequestCode = requestCode;
        mResultCode = resultCode;
        mData = data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.243 -0500", hash_original_method = "96F78670445F12E6C74BEEDC3D49BD9C", hash_generated_method = "A759712A132777509FF16C236CCB98B5")
    
public ResultInfo(Parcel in) {
        mResultWho = in.readString();
        mRequestCode = in.readInt();
        mResultCode = in.readInt();
        if (in.readInt() != 0) {
            mData = Intent.CREATOR.createFromParcel(in);
        } else {
            mData = null;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.228 -0500", hash_original_method = "45459039AB19A0482EB7D8EB8705A318", hash_generated_method = "E68454FE4A22507D72E6A3A42E3E9044")
    
public String toString() {
        return "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            + ", result=" + mResultCode + ", data=" + mData + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.229 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.232 -0500", hash_original_method = "C00CE2610591477E96DECA81C0021A12", hash_generated_method = "A7764B6D179A6394B46EFC96BFEB599E")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(mResultWho);
        out.writeInt(mRequestCode);
        out.writeInt(mResultCode);
        if (mData != null) {
            out.writeInt(1);
            mData.writeToParcel(out, 0);
        } else {
            out.writeInt(0);
        }
    }
    // orphaned legacy method
    public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }
    
    // orphaned legacy method
    public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    
}

