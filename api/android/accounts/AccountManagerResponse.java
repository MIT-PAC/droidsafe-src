package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class AccountManagerResponse implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.439 -0400", hash_original_field = "E72652B09AB331E8E60D8A37942A6989", hash_generated_field = "D637A55DBCA794D5ED83787471490AEF")

    private IAccountManagerResponse mResponse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.440 -0400", hash_original_method = "3522B88B7A321F46293EAD30C75E1618", hash_generated_method = "59FA086C4129E04241D85AD832C5FDC8")
    public  AccountManagerResponse(IAccountManagerResponse response) {
        mResponse = response;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.442 -0400", hash_original_method = "25719BDE37ECFBE2984FFF140C89B60A", hash_generated_method = "68FA4D479BEB125118EB07ECE8D64669")
    public  AccountManagerResponse(Parcel parcel) {
        mResponse =
                IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.443 -0400", hash_original_method = "9B774AF037DE184114612158D52CE3AE", hash_generated_method = "5CF67B28612A650313E691B455966022")
    public void onResult(Bundle result) {
        
        try 
        {
            mResponse.onResult(result);
        } 
        catch (RemoteException e)
        { }
        addTaint(result.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.445 -0400", hash_original_method = "E6057BE96727FC9D5F2F0AC6DA4D66E7", hash_generated_method = "824F75DD797A4B6FBA720E766457FDEC")
    public void onError(int errorCode, String errorMessage) {
        
        try 
        {
            mResponse.onError(errorCode, errorMessage);
        } 
        catch (RemoteException e)
        { }
        addTaint(errorCode);
        addTaint(errorMessage.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.447 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "36721EA21EA99CAED769AC692C98B3F1")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206111872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206111872;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.448 -0400", hash_original_method = "CE73222339489F4EC9333AF29A0583AB", hash_generated_method = "C74FE840E57EC6F40B1692C5969A93F2")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mResponse.asBinder());
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.449 -0400", hash_original_field = "C063FF2DAC7085FABC5A4118EBCC8FB6", hash_generated_field = "24EAF1DECF76FE87EC73D7C9E1E10A5E")

    public static final Creator<AccountManagerResponse> CREATOR =
            new Creator<AccountManagerResponse>() {
        public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }

        public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    };
    
    public AccountManagerResponse createFromParcel(Parcel source) {
            return new AccountManagerResponse(source);
        }
    
    
    public AccountManagerResponse[] newArray(int size) {
            return new AccountManagerResponse[size];
        }
    
}

