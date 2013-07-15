package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class AccountManagerResponse implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.017 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "D637A55DBCA794D5ED83787471490AEF")

    private IAccountManagerResponse mResponse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.018 -0400", hash_original_method = "3522B88B7A321F46293EAD30C75E1618", hash_generated_method = "59FA086C4129E04241D85AD832C5FDC8")
    public  AccountManagerResponse(IAccountManagerResponse response) {
        mResponse = response;
        // ---------- Original Method ----------
        //mResponse = response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.022 -0400", hash_original_method = "25719BDE37ECFBE2984FFF140C89B60A", hash_generated_method = "68FA4D479BEB125118EB07ECE8D64669")
    public  AccountManagerResponse(Parcel parcel) {
        mResponse =
                IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
        // ---------- Original Method ----------
        //mResponse =
                //IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.025 -0400", hash_original_method = "9B774AF037DE184114612158D52CE3AE", hash_generated_method = "5195F6FFDB93A555A2A1D320D8B1B164")
    public void onResult(Bundle result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        try 
        {
            mResponse.onResult(result);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mResponse.onResult(result);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.030 -0400", hash_original_method = "E6057BE96727FC9D5F2F0AC6DA4D66E7", hash_generated_method = "5EC3DDE7129EAF0CD565510519F81B7B")
    public void onError(int errorCode, String errorMessage) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(errorMessage.getTaint());
        addTaint(errorCode);
        try 
        {
            mResponse.onError(errorCode, errorMessage);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mResponse.onError(errorCode, errorMessage);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.038 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "220ED63FE12E6297ADAE64D47F3EFD2E")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_642235235 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416361487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_416361487;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.041 -0400", hash_original_method = "CE73222339489F4EC9333AF29A0583AB", hash_generated_method = "90F0408D0E0696F094210E9AED553B6E")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeStrongBinder(mResponse.asBinder());
        // ---------- Original Method ----------
        //dest.writeStrongBinder(mResponse.asBinder());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.043 -0400", hash_original_field = "C063FF2DAC7085FABC5A4118EBCC8FB6", hash_generated_field = "24EAF1DECF76FE87EC73D7C9E1E10A5E")

    public static final Creator<AccountManagerResponse> CREATOR =
            new Creator<AccountManagerResponse>() {
        public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }

        public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    };
    // orphaned legacy method
    public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }
    
    // orphaned legacy method
    public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    
}

