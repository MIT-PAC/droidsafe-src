package android.nfc;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import android.os.Parcel;
import android.os.Parcelable;





public final class TransceiveResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.443 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "898029569E5207542E445F1B5791BBF2")

    int mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.443 -0400", hash_original_field = "BFFE7E0589B22CE865458FA1B0436BE6", hash_generated_field = "9B327001CAAE073009DBABE5CADFA298")

    byte[] mResponseData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.444 -0400", hash_original_method = "BA3E23EA94CFCB76E8DA5A162A199F9F", hash_generated_method = "52B26C94A414FFC514E277A7C1EC7257")
    public  TransceiveResult(final int result, final byte[] data) {
        mResult = result;
        mResponseData = data;
        // ---------- Original Method ----------
        //mResult = result;
        //mResponseData = data;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.445 -0400", hash_original_method = "B3157A12430DB97B40C44B33A50DEAC2", hash_generated_method = "EE76566F72F9F0420B6A9ED80F9EF1D4")
    public byte[] getResponseOrThrow() throws IOException {
switch(mResult){
        case RESULT_SUCCESS:
        byte[] varBFFE7E0589B22CE865458FA1B0436BE6_1304454538 = (mResponseData);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_552091886 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_552091886;
        case RESULT_TAGLOST:
        TagLostException varCCBC287F21F58CFDA103A96DA6324BF2_9046056 = new TagLostException("Tag was lost.");
        varCCBC287F21F58CFDA103A96DA6324BF2_9046056.addTaint(taint);
        throw varCCBC287F21F58CFDA103A96DA6324BF2_9046056;
        case RESULT_EXCEEDED_LENGTH:
        IOException var7E7BD042D49877BAF80F86FA101D8487_1549985634 = new IOException("Transceive length exceeds supported maximum");
        var7E7BD042D49877BAF80F86FA101D8487_1549985634.addTaint(taint);
        throw var7E7BD042D49877BAF80F86FA101D8487_1549985634;
        default:
        IOException varC0A3EE5F469C616C75377A96A94F4CF4_4262195 = new IOException("Transceive failed");
        varC0A3EE5F469C616C75377A96A94F4CF4_4262195.addTaint(taint);
        throw varC0A3EE5F469C616C75377A96A94F4CF4_4262195;
}
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.446 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "102967875BB0B1FDE07E55926254A156")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2127785212 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968505003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968505003;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.446 -0400", hash_original_method = "561D73418397BF7826CB5BA2EBF58A4C", hash_generated_method = "F395845E4EEF769009C9B78FC7A0C13B")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mResult);
        if(mResult == RESULT_SUCCESS)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.447 -0400", hash_original_field = "7220CC5FE09F8E0AD236B0794719C2B8", hash_generated_field = "93D71095BCD71B4D4475A608C17F7F57")

    public static final int RESULT_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.447 -0400", hash_original_field = "DC58DEC1ADFE5C84D68D0AA62D585476", hash_generated_field = "4FD1539AD317A1A31DD1A35AD83E5BE8")

    public static final int RESULT_FAILURE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.447 -0400", hash_original_field = "BB3496D11307C2AA450314C4DB6739E2", hash_generated_field = "96BC6B774CB901ED0AE4953C2ADCF528")

    public static final int RESULT_TAGLOST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.447 -0400", hash_original_field = "37B6DEDCD47B84C75BAA8DE8677173D4", hash_generated_field = "FAFE791CB93F99512ACDB648AE7425C7")

    public static final int RESULT_EXCEEDED_LENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.448 -0400", hash_original_field = "FFC0712FDE7CBA72C474F4F97F95AC1D", hash_generated_field = "9C8EC90C6F5B038F4E844B19E185F53B")

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

