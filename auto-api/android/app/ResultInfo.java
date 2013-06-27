package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.Map;

public class ResultInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.372 -0400", hash_original_field = "344245CF6F3FB0EF7E71D82B314565C8", hash_generated_field = "9751D4E955A56AA5356026C082D57D65")

    public String mResultWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.387 -0400", hash_original_field = "86891437037662D667B835C6AB354174", hash_generated_field = "85DF646F4249AC1D2BDB38637924C61D")

    public int mRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.388 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "C5F755BFBAC5FACAF96067E93F13F919")

    public int mResultCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.389 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "44EE18239FF473343B1B4A3246CBC87D")

    public Intent mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.413 -0400", hash_original_method = "5613E3DAA5C00F0B9643F3F13EB312FC", hash_generated_method = "7996DAB0AC864885B2CBAC135A1A1795")
    public  ResultInfo(String resultWho, int requestCode, int resultCode,
            Intent data) {
        mResultWho = resultWho;
        mRequestCode = requestCode;
        mResultCode = resultCode;
        mData = data;
        // ---------- Original Method ----------
        //mResultWho = resultWho;
        //mRequestCode = requestCode;
        //mResultCode = resultCode;
        //mData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.417 -0400", hash_original_method = "96F78670445F12E6C74BEEDC3D49BD9C", hash_generated_method = "C5CDE9B77258294D9A14A3B3644F2631")
    public  ResultInfo(Parcel in) {
        mResultWho = in.readString();
        mRequestCode = in.readInt();
        mResultCode = in.readInt();
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_2079850523 = (in.readInt() != 0);
            {
                mData = Intent.CREATOR.createFromParcel(in);
            } //End block
            {
                mData = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mResultWho = in.readString();
        //mRequestCode = in.readInt();
        //mResultCode = in.readInt();
        //if (in.readInt() != 0) {
            //mData = Intent.CREATOR.createFromParcel(in);
        //} else {
            //mData = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.440 -0400", hash_original_method = "45459039AB19A0482EB7D8EB8705A318", hash_generated_method = "5D8326996A9A31F0B53C24A586A6DCAC")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1925786524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1925786524 = "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            + ", result=" + mResultCode + ", data=" + mData + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1925786524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1925786524;
        // ---------- Original Method ----------
        //return "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            //+ ", result=" + mResultCode + ", data=" + mData + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.459 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "830ACB7198173EE79429F9F34582C831")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191981494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191981494;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.469 -0400", hash_original_method = "C00CE2610591477E96DECA81C0021A12", hash_generated_method = "B1BFE7759F145E81AF523935B785959B")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mResultWho);
        out.writeInt(mRequestCode);
        out.writeInt(mResultCode);
        {
            out.writeInt(1);
            mData.writeToParcel(out, 0);
        } //End block
        {
            out.writeInt(0);
        } //End block
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeString(mResultWho);
        //out.writeInt(mRequestCode);
        //out.writeInt(mResultCode);
        //if (mData != null) {
            //out.writeInt(1);
            //mData.writeToParcel(out, 0);
        //} else {
            //out.writeInt(0);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.471 -0400", hash_original_field = "0AD537D7B4AC3F7C300248CFF3FC2AEF", hash_generated_field = "D13876AA40E0BEAA5F9CE88B0DEDE86A")

    public static final Parcelable.Creator<ResultInfo> CREATOR
            = new Parcelable.Creator<ResultInfo>() {
        public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }

        public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    };
}

