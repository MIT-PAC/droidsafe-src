package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public class AccountManagerResponse implements Parcelable {
    private IAccountManagerResponse mResponse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.410 -0400", hash_original_method = "3522B88B7A321F46293EAD30C75E1618", hash_generated_method = "2CBF9EA6B1907175DAEB7124FD350975")
    @DSModeled(DSC.SAFE)
    public AccountManagerResponse(IAccountManagerResponse response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //mResponse = response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.411 -0400", hash_original_method = "25719BDE37ECFBE2984FFF140C89B60A", hash_generated_method = "E44DD0754A1E3A11D0AB1141070ADCA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccountManagerResponse(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        mResponse =
                IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
        // ---------- Original Method ----------
        //mResponse =
                //IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.412 -0400", hash_original_method = "9B774AF037DE184114612158D52CE3AE", hash_generated_method = "C990571F19DF69B1BBB651309CCE282F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onResult(Bundle result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(result.dsTaint);
        try 
        {
            mResponse.onResult(result);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mResponse.onResult(result);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.413 -0400", hash_original_method = "E6057BE96727FC9D5F2F0AC6DA4D66E7", hash_generated_method = "596C16F8E15A787C84F43124A228EA6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onError(int errorCode, String errorMessage) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(errorMessage);
        dsTaint.addTaint(errorCode);
        try 
        {
            mResponse.onError(errorCode, errorMessage);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mResponse.onError(errorCode, errorMessage);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.414 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.491 -0400", hash_original_method = "CE73222339489F4EC9333AF29A0583AB", hash_generated_method = "223644F3BF2447AC71B8AEE00281BD6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeStrongBinder(mResponse.asBinder());
        // ---------- Original Method ----------
        //dest.writeStrongBinder(mResponse.asBinder());
    }

    
    public static final Creator<AccountManagerResponse> CREATOR = new Creator<AccountManagerResponse>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.492 -0400", hash_original_method = "BC1F78C1DE1163CF39ECBF698C4F20F7", hash_generated_method = "F454C130C7004BD8E9892AC2493D3732")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccountManagerResponse createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            AccountManagerResponse varBA9FE7B31391DC259A32D0B142061B0F_1933474884 = (new AccountManagerResponse(source));
            return (AccountManagerResponse)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccountManagerResponse(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.493 -0400", hash_original_method = "457368C77CFF58E97F63B7FC822851B6", hash_generated_method = "528D59C605D0AFE06BA567FBD8A5F42E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AccountManagerResponse[] newArray(int size) {
            dsTaint.addTaint(size);
            AccountManagerResponse[] var6EE10DE9966A2CD12DEA0BF6E685758B_200520541 = (new AccountManagerResponse[size]);
            return (AccountManagerResponse[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccountManagerResponse[size];
        }

        
}; //Transformed anonymous class
}

