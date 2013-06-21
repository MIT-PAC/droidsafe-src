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
    public String mResultWho;
    public int mRequestCode;
    public int mResultCode;
    public Intent mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.555 -0400", hash_original_method = "5613E3DAA5C00F0B9643F3F13EB312FC", hash_generated_method = "CCE11D099BACC241D6E2F7F6AA740C8A")
    @DSModeled(DSC.SPEC)
    public ResultInfo(String resultWho, int requestCode, int resultCode,
            Intent data) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(resultWho);
        // ---------- Original Method ----------
        //mResultWho = resultWho;
        //mRequestCode = requestCode;
        //mResultCode = resultCode;
        //mData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.556 -0400", hash_original_method = "96F78670445F12E6C74BEEDC3D49BD9C", hash_generated_method = "943614B90E7405A1AD45FE50D13661D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResultInfo(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mResultWho = in.readString();
        mRequestCode = in.readInt();
        mResultCode = in.readInt();
        {
            boolean var25D67F28E4887DDC152DCB9726EAB4D3_1664352597 = (in.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.556 -0400", hash_original_method = "45459039AB19A0482EB7D8EB8705A318", hash_generated_method = "9C3C7294C3CE9B449DF8F43C3511FEE3")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ResultInfo{who=" + mResultWho + ", request=" + mRequestCode
            //+ ", result=" + mResultCode + ", data=" + mData + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.557 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.557 -0400", hash_original_method = "C00CE2610591477E96DECA81C0021A12", hash_generated_method = "EF081730BD926DE7BE988F9D5324747F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    public static final Parcelable.Creator<ResultInfo> CREATOR = new Parcelable.Creator<ResultInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.558 -0400", hash_original_method = "826AEDDD26AEE1AF600D5589DF2DC45E", hash_generated_method = "61F045B547AA564102B7CC42AC2758B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResultInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ResultInfo varD1824C8CF0C9440BA4EAC1B336D3A61A_882880463 = (new ResultInfo(in));
            return (ResultInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.559 -0400", hash_original_method = "D708841F6AE6B702AE483AC563E2586E", hash_generated_method = "2EAAAE1EA9F18D2C5B8657DA4995D6A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResultInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ResultInfo[] var49BF841D1226760DBD0C00ECB8AE3BD4_1682572101 = (new ResultInfo[size]);
            return (ResultInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultInfo[size];
        }

        
}; //Transformed anonymous class
}

