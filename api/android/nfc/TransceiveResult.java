package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

public final class TransceiveResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.798 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "898029569E5207542E445F1B5791BBF2")

    int mResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.798 -0400", hash_original_field = "BFFE7E0589B22CE865458FA1B0436BE6", hash_generated_field = "9B327001CAAE073009DBABE5CADFA298")

    byte[] mResponseData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.798 -0400", hash_original_method = "BA3E23EA94CFCB76E8DA5A162A199F9F", hash_generated_method = "52B26C94A414FFC514E277A7C1EC7257")
    public  TransceiveResult(final int result, final byte[] data) {
        mResult = result;
        mResponseData = data;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.799 -0400", hash_original_method = "B3157A12430DB97B40C44B33A50DEAC2", hash_generated_method = "95E92869FD17F71B9D1DB16725ACD2F6")
    public byte[] getResponseOrThrow() throws IOException {
switch(mResult){
        case RESULT_SUCCESS:
        byte[] varBFFE7E0589B22CE865458FA1B0436BE6_39776295 = (mResponseData);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1334696401 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1334696401;
        case RESULT_TAGLOST:
        TagLostException varCCBC287F21F58CFDA103A96DA6324BF2_850393388 = new TagLostException("Tag was lost.");
        varCCBC287F21F58CFDA103A96DA6324BF2_850393388.addTaint(taint);
        throw varCCBC287F21F58CFDA103A96DA6324BF2_850393388;
        case RESULT_EXCEEDED_LENGTH:
        IOException var7E7BD042D49877BAF80F86FA101D8487_790067051 = new IOException("Transceive length exceeds supported maximum");
        var7E7BD042D49877BAF80F86FA101D8487_790067051.addTaint(taint);
        throw var7E7BD042D49877BAF80F86FA101D8487_790067051;
        default:
        IOException varC0A3EE5F469C616C75377A96A94F4CF4_600056581 = new IOException("Transceive failed");
        varC0A3EE5F469C616C75377A96A94F4CF4_600056581.addTaint(taint);
        throw varC0A3EE5F469C616C75377A96A94F4CF4_600056581;
}
        
        
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.799 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9853AF00360D41A1ACA8B88830DF9980")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_110876274 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918823880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918823880;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_method = "561D73418397BF7826CB5BA2EBF58A4C", hash_generated_method = "F395845E4EEF769009C9B78FC7A0C13B")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mResult);
    if(mResult == RESULT_SUCCESS)        
        {
            dest.writeInt(mResponseData.length);
            dest.writeByteArray(mResponseData);
        } 
        
        
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_field = "7220CC5FE09F8E0AD236B0794719C2B8", hash_generated_field = "93D71095BCD71B4D4475A608C17F7F57")

    public static final int RESULT_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_field = "DC58DEC1ADFE5C84D68D0AA62D585476", hash_generated_field = "4FD1539AD317A1A31DD1A35AD83E5BE8")

    public static final int RESULT_FAILURE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_field = "BB3496D11307C2AA450314C4DB6739E2", hash_generated_field = "96BC6B774CB901ED0AE4953C2ADCF528")

    public static final int RESULT_TAGLOST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_field = "37B6DEDCD47B84C75BAA8DE8677173D4", hash_generated_field = "FAFE791CB93F99512ACDB648AE7425C7")

    public static final int RESULT_EXCEEDED_LENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.800 -0400", hash_original_field = "FFC0712FDE7CBA72C474F4F97F95AC1D", hash_generated_field = "9C8EC90C6F5B038F4E844B19E185F53B")

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

