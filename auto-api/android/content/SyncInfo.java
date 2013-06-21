package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SyncInfo implements Parcelable {
    public int authorityId;
    public Account account;
    public String authority;
    public long startTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.118 -0400", hash_original_method = "08CB15341E378B91930C38215FF9CE0F", hash_generated_method = "316E4B3FE9991587F59762261BD904AE")
    @DSModeled(DSC.SAFE)
     SyncInfo(int authorityId, Account account, String authority,
            long startTime) {
        dsTaint.addTaint(startTime);
        dsTaint.addTaint(authority);
        dsTaint.addTaint(authorityId);
        dsTaint.addTaint(account.dsTaint);
        // ---------- Original Method ----------
        //this.authorityId = authorityId;
        //this.account = account;
        //this.authority = authority;
        //this.startTime = startTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.118 -0400", hash_original_method = "C517E1FF2489673370FA690A620D127C", hash_generated_method = "0FBBF0D446D334EBD926C26BB55275B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SyncInfo(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        authorityId = parcel.readInt();
        account = new Account(parcel);
        authority = parcel.readString();
        startTime = parcel.readLong();
        // ---------- Original Method ----------
        //authorityId = parcel.readInt();
        //account = new Account(parcel);
        //authority = parcel.readString();
        //startTime = parcel.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.119 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.119 -0400", hash_original_method = "1C5B91DE7E7E8D04DC252E4EE5F1DBAA", hash_generated_method = "C9DF01EA6A75E0A856617DFB4FF082FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(authorityId);
        account.writeToParcel(parcel, 0);
        parcel.writeString(authority);
        parcel.writeLong(startTime);
        // ---------- Original Method ----------
        //parcel.writeInt(authorityId);
        //account.writeToParcel(parcel, 0);
        //parcel.writeString(authority);
        //parcel.writeLong(startTime);
    }

    
    public static final Creator<SyncInfo> CREATOR = new Creator<SyncInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.119 -0400", hash_original_method = "8CC1AEB78BBF2ED2FA2D9F459276B44F", hash_generated_method = "5DCF308D8BAD73B5EEA84C65F4622C14")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SyncInfo varB9F80EAD54D2A91EC3A1EF2208451CFA_887603539 = (new SyncInfo(in));
            return (SyncInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.120 -0400", hash_original_method = "5C1CA30D4924E9B917C7F0C224EF3A13", hash_generated_method = "FFEDCF7353B67A8F6E813CF4626B8407")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            SyncInfo[] var372FE4925137A938F3C18E55CDC5CCDB_1758281383 = (new SyncInfo[size]);
            return (SyncInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncInfo[size];
        }

        
}; //Transformed anonymous class
}

