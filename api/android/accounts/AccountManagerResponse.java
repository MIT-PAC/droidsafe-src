package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class AccountManagerResponse implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.380 -0400", hash_original_field = "C063FF2DAC7085FABC5A4118EBCC8FB6", hash_generated_field = "24EAF1DECF76FE87EC73D7C9E1E10A5E")

    public static final Creator<AccountManagerResponse> CREATOR =
            new Creator<AccountManagerResponse>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.077 -0500", hash_original_method = "BC1F78C1DE1163CF39ECBF698C4F20F7", hash_generated_method = "92989100502057C5AC3E470095E1578D")
        
public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.080 -0500", hash_original_method = "457368C77CFF58E97F63B7FC822851B6", hash_generated_method = "B5ECECF4284C402FFA7F3275FE94C6E2")
        
public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.059 -0500", hash_original_field = "BCCFC11938EEC7DE34A0DE82C0A04729", hash_generated_field = "D637A55DBCA794D5ED83787471490AEF")

    private IAccountManagerResponse mResponse;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.062 -0500", hash_original_method = "3522B88B7A321F46293EAD30C75E1618", hash_generated_method = "DBA4E86319BB28506FC2F5E79C098999")
    
public AccountManagerResponse(IAccountManagerResponse response) {
        mResponse = response;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.065 -0500", hash_original_method = "25719BDE37ECFBE2984FFF140C89B60A", hash_generated_method = "07C4E9E7B8BBC5DD400EFAFD4D39E915")
    
public AccountManagerResponse(Parcel parcel) {
        mResponse =
                IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.067 -0500", hash_original_method = "9B774AF037DE184114612158D52CE3AE", hash_generated_method = "402A4D226A5EA9F268DB7EA12DB2FCB1")
    
public void onResult(Bundle result) {
        try {
            mResponse.onResult(result);
        } catch (RemoteException e) {
            // this should never happen
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.069 -0500", hash_original_method = "E6057BE96727FC9D5F2F0AC6DA4D66E7", hash_generated_method = "D6D0D3A7D85C048D57E5D6C485113040")
    
public void onError(int errorCode, String errorMessage) {
        try {
            mResponse.onError(errorCode, errorMessage);
        } catch (RemoteException e) {
            // this should never happen
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.071 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:46.074 -0500", hash_original_method = "CE73222339489F4EC9333AF29A0583AB", hash_generated_method = "30A7CE51E6A6812A5160F790F686A8FB")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mResponse.asBinder());
    }
    // orphaned legacy method
    public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }
    
    // orphaned legacy method
    public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    
}

