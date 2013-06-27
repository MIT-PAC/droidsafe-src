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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.485 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "898029569E5207542E445F1B5791BBF2")

    int mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.485 -0400", hash_original_field = "BFFE7E0589B22CE865458FA1B0436BE6", hash_generated_field = "9B327001CAAE073009DBABE5CADFA298")

    byte[] mResponseData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.486 -0400", hash_original_method = "BA3E23EA94CFCB76E8DA5A162A199F9F", hash_generated_method = "52B26C94A414FFC514E277A7C1EC7257")
    public  TransceiveResult(final int result, final byte[] data) {
        mResult = result;
        mResponseData = data;
        // ---------- Original Method ----------
        //mResult = result;
        //mResponseData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.487 -0400", hash_original_method = "B3157A12430DB97B40C44B33A50DEAC2", hash_generated_method = "04885D950AD01B651E85E1934657A788")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1584261352 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1584261352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.490 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BE6619D8A4BCAAE44134870C9DDD367C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747068930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747068930;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.501 -0400", hash_original_method = "561D73418397BF7826CB5BA2EBF58A4C", hash_generated_method = "AE5C41012813B141CADE3CEF7CE376C0")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mResult);
        {
            dest.writeInt(mResponseData.length);
            dest.writeByteArray(mResponseData);
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mResult);
        //if (mResult == RESULT_SUCCESS) {
            //dest.writeInt(mResponseData.length);
            //dest.writeByteArray(mResponseData);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.502 -0400", hash_original_field = "7220CC5FE09F8E0AD236B0794719C2B8", hash_generated_field = "93D71095BCD71B4D4475A608C17F7F57")

    public static final int RESULT_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.502 -0400", hash_original_field = "DC58DEC1ADFE5C84D68D0AA62D585476", hash_generated_field = "4FD1539AD317A1A31DD1A35AD83E5BE8")

    public static final int RESULT_FAILURE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.502 -0400", hash_original_field = "BB3496D11307C2AA450314C4DB6739E2", hash_generated_field = "96BC6B774CB901ED0AE4953C2ADCF528")

    public static final int RESULT_TAGLOST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.502 -0400", hash_original_field = "37B6DEDCD47B84C75BAA8DE8677173D4", hash_generated_field = "FAFE791CB93F99512ACDB648AE7425C7")

    public static final int RESULT_EXCEEDED_LENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.502 -0400", hash_original_field = "FFC0712FDE7CBA72C474F4F97F95AC1D", hash_generated_field = "9C8EC90C6F5B038F4E844B19E185F53B")

    public static final Parcelable.Creator<TransceiveResult> CREATOR =
            new Parcelable.Creator<TransceiveResult>() {
        @Override
        public TransceiveResult createFromParcel(Parcel in) {
            int result = in.readInt();
            byte[] responseData;

            if (result == RESULT_SUCCESS) {
                int responseLength = in.readInt();
                responseData = new byte[responseLength];
                in.readByteArray(responseData);
            } else {
                responseData = null;
            }
            return new TransceiveResult(result, responseData);
        }

        @Override
        public TransceiveResult[] newArray(int size) {
            return new TransceiveResult[size];
        }
    };
}

