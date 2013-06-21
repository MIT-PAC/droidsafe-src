package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

public final class TransceiveResult implements Parcelable {
    int mResult;
    byte[] mResponseData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.138 -0400", hash_original_method = "BA3E23EA94CFCB76E8DA5A162A199F9F", hash_generated_method = "76EE348DBFF83AE1130D22221FCF2AC2")
    @DSModeled(DSC.SAFE)
    public TransceiveResult(final int result, final byte[] data) {
        dsTaint.addTaint(result);
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
        //mResult = result;
        //mResponseData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.139 -0400", hash_original_method = "B3157A12430DB97B40C44B33A50DEAC2", hash_generated_method = "BE03441B770050F306AF527BAC970C0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getResponseOrThrow() throws IOException {
        //Begin case RESULT_TAGLOST 
        if (DroidSafeAndroidRuntime.control) throw new TagLostException("Tag was lost.");
        //End case RESULT_TAGLOST 
        //Begin case RESULT_EXCEEDED_LENGTH 
        if (DroidSafeAndroidRuntime.control) throw new IOException("Transceive length exceeds supported maximum");
        //End case RESULT_EXCEEDED_LENGTH 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IOException("Transceive failed");
        //End case default 
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //switch (mResult) {
            //case RESULT_SUCCESS:
                //return mResponseData;
            //case RESULT_TAGLOST:
                //throw new TagLostException("Tag was lost.");
            //case RESULT_EXCEEDED_LENGTH:
                //throw new IOException("Transceive length exceeds supported maximum");
            //default:
                //throw new IOException("Transceive failed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.140 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.140 -0400", hash_original_method = "561D73418397BF7826CB5BA2EBF58A4C", hash_generated_method = "41443339FE119DB2756AF007C8AF900F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mResult);
        {
            dest.writeInt(mResponseData.length);
            dest.writeByteArray(mResponseData);
        } //End block
        // ---------- Original Method ----------
        //dest.writeInt(mResult);
        //if (mResult == RESULT_SUCCESS) {
            //dest.writeInt(mResponseData.length);
            //dest.writeByteArray(mResponseData);
        //}
    }

    
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_TAGLOST = 2;
    public static final int RESULT_EXCEEDED_LENGTH = 3;
    public static final Parcelable.Creator<TransceiveResult> CREATOR = new Parcelable.Creator<TransceiveResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.141 -0400", hash_original_method = "BFC8A39F82125AA8B2493EE990788449", hash_generated_method = "B9A27DEF3D20302A686BEA3F267D0055")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TransceiveResult createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int result;
            result = in.readInt();
            byte[] responseData;
            {
                int responseLength;
                responseLength = in.readInt();
                responseData = new byte[responseLength];
                in.readByteArray(responseData);
            } //End block
            {
                responseData = null;
            } //End block
            TransceiveResult var6B1B7DC4C6EDEFE9BAAE99A8C4F3BC38_157955551 = (new TransceiveResult(result, responseData));
            return (TransceiveResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int result = in.readInt();
            //byte[] responseData;
            //if (result == RESULT_SUCCESS) {
                //int responseLength = in.readInt();
                //responseData = new byte[responseLength];
                //in.readByteArray(responseData);
            //} else {
                //responseData = null;
            //}
            //return new TransceiveResult(result, responseData);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.141 -0400", hash_original_method = "B5998B203B4504A6E25715B8DD72366B", hash_generated_method = "B115C21E503FCC5739BF3E472CAC3112")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TransceiveResult[] newArray(int size) {
            dsTaint.addTaint(size);
            TransceiveResult[] var7F3A8B1762226F3687620F2ED43596DB_1254105496 = (new TransceiveResult[size]);
            return (TransceiveResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TransceiveResult[size];
        }

        
}; //Transformed anonymous class
}

