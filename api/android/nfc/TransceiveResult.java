package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import android.os.Parcel;
import android.os.Parcelable;

public final class TransceiveResult implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.785 -0500", hash_original_field = "3D2A0A46A17A176E4787361ED7109E90", hash_generated_field = "93D71095BCD71B4D4475A608C17F7F57")

    public static final int RESULT_SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.787 -0500", hash_original_field = "E0DB9251857C1081B3EBBF40B6CE0BB6", hash_generated_field = "4FD1539AD317A1A31DD1A35AD83E5BE8")

    public static final int RESULT_FAILURE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.789 -0500", hash_original_field = "822C4A82C20B0D63A2439D58885DD755", hash_generated_field = "96BC6B774CB901ED0AE4953C2ADCF528")

    public static final int RESULT_TAGLOST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.792 -0500", hash_original_field = "0F2B4F0CA1D2260E45B2E0D4AAC7100C", hash_generated_field = "FAFE791CB93F99512ACDB648AE7425C7")

    public static final int RESULT_EXCEEDED_LENGTH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.448 -0400", hash_original_field = "FFC0712FDE7CBA72C474F4F97F95AC1D", hash_generated_field = "9C8EC90C6F5B038F4E844B19E185F53B")

    public static final Parcelable.Creator<TransceiveResult> CREATOR =
            new Parcelable.Creator<TransceiveResult>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.809 -0500", hash_original_method = "BFC8A39F82125AA8B2493EE990788449", hash_generated_method = "F89AB33BD05BD3B26A9FD1785AC1E901")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.812 -0500", hash_original_method = "B5998B203B4504A6E25715B8DD72366B", hash_generated_method = "A0E8AEA6E1B7BA861F3C9BD909DBB7ED")
        
@Override
        public TransceiveResult[] newArray(int size) {
            return new TransceiveResult[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.794 -0500", hash_original_field = "898029569E5207542E445F1B5791BBF2", hash_generated_field = "898029569E5207542E445F1B5791BBF2")

     int mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.796 -0500", hash_original_field = "9B327001CAAE073009DBABE5CADFA298", hash_generated_field = "9B327001CAAE073009DBABE5CADFA298")

     byte[] mResponseData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.798 -0500", hash_original_method = "BA3E23EA94CFCB76E8DA5A162A199F9F", hash_generated_method = "153971E6819D940ABACAC97942C83691")
    
public TransceiveResult(final int result, final byte[] data) {
        mResult = result;
        mResponseData = data;
    }

    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.800 -0500", hash_original_method = "B3157A12430DB97B40C44B33A50DEAC2", hash_generated_method = "EA8B9E9A0510ED2206C50A315DFD6B75")
    
public byte[] getResponseOrThrow() throws IOException {
        switch (mResult) {
            case RESULT_SUCCESS:
                return mResponseData;
            case RESULT_TAGLOST:
                throw new TagLostException("Tag was lost.");
            case RESULT_EXCEEDED_LENGTH:
                throw new IOException("Transceive length exceeds supported maximum");
            default:
                throw new IOException("Transceive failed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.803 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.805 -0500", hash_original_method = "561D73418397BF7826CB5BA2EBF58A4C", hash_generated_method = "1AE74467F9AADA5D9DCA52C5278606DB")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mResult);
        if (mResult == RESULT_SUCCESS) {
            dest.writeInt(mResponseData.length);
            dest.writeByteArray(mResponseData);
        }
    }
}

