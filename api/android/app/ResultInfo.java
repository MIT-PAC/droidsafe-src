package android.app;

// Droidsafe Imports
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ResultInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.528 -0400", hash_original_field = "344245CF6F3FB0EF7E71D82B314565C8", hash_generated_field = "9751D4E955A56AA5356026C082D57D65")

    public String mResultWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.528 -0400", hash_original_field = "86891437037662D667B835C6AB354174", hash_generated_field = "85DF646F4249AC1D2BDB38637924C61D")

    public int mRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.528 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "C5F755BFBAC5FACAF96067E93F13F919")

    public int mResultCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.528 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "44EE18239FF473343B1B4A3246CBC87D")

    public Intent mData;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.529 -0400", hash_original_method = "5613E3DAA5C00F0B9643F3F13EB312FC", hash_generated_method = "7996DAB0AC864885B2CBAC135A1A1795")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.535 -0400", hash_original_method = "96F78670445F12E6C74BEEDC3D49BD9C", hash_generated_method = "74ABBA3DC38C7AE74C1C79476572E0DA")
    public  ResultInfo(Parcel in) {
        mResultWho = in.readString();
        mRequestCode = in.readInt();
        mResultCode = in.readInt();
        if(in.readInt() != 0)        
        {
            mData = Intent.CREATOR.createFromParcel(in);
        } //End block
        else
        {
            mData = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.536 -0400", hash_original_method = "45459039AB19A0482EB7D8EB8705A318", hash_generated_method = "D303D66D35E819D921E93D20CC426FC1")
    public String toString() {
String var503AE12A5260321A6845A1C1B1307BB1_96201398 =         "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            + ", result=" + mResultCode + ", data=" + mData + "}";
        var503AE12A5260321A6845A1C1B1307BB1_96201398.addTaint(taint);
        return var503AE12A5260321A6845A1C1B1307BB1_96201398;
        // ---------- Original Method ----------
        //return "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            //+ ", result=" + mResultCode + ", data=" + mData + "}";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.537 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "60215E93B550401EA3DA3BD6E17567BB")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1609171456 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915659615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915659615;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.537 -0400", hash_original_method = "C00CE2610591477E96DECA81C0021A12", hash_generated_method = "1A24F76E58C25CC707F7FB0D840D498A")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(mResultWho);
        out.writeInt(mRequestCode);
        out.writeInt(mResultCode);
        if(mData != null)        
        {
            out.writeInt(1);
            mData.writeToParcel(out, 0);
        } //End block
        else
        {
            out.writeInt(0);
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.541 -0400", hash_original_field = "0AD537D7B4AC3F7C300248CFF3FC2AEF", hash_generated_field = "D13876AA40E0BEAA5F9CE88B0DEDE86A")

    public static final Parcelable.Creator<ResultInfo> CREATOR
            = new Parcelable.Creator<ResultInfo>() {
        public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }

        public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    };
    // orphaned legacy method
    public ResultInfo createFromParcel(Parcel in) {
            return new ResultInfo(in);
        }
    
    // orphaned legacy method
    public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    
}

