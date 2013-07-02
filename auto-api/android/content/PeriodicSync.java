package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Bundle;
import android.os.Parcel;
import android.accounts.Account;

public class PeriodicSync implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.461 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public Account account;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.461 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.461 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.461 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "49C5D8DF45BFC99E2E96D80F4EA633C6")

    public long period;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.462 -0400", hash_original_method = "34D447B50A8BF0311FD91158BAB8271D", hash_generated_method = "8811081678FE37BAFD2ECD5814D13257")
    public  PeriodicSync(Account account, String authority, Bundle extras, long period) {
        this.account = account;
        this.authority = authority;
        this.extras = new Bundle(extras);
        this.period = period;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.462 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "45EA491DA8B8D913EF7841EFF8EF1AF2")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143667624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143667624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.463 -0400", hash_original_method = "D77F1A5B85A714E7D78D3A9001CC9547", hash_generated_method = "7D3B0FFA9A2A517F6A70B22711F7385E")
    public void writeToParcel(Parcel dest, int flags) {
        account.writeToParcel(dest, flags);
        dest.writeString(authority);
        dest.writeBundle(extras);
        dest.writeLong(period);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.464 -0400", hash_original_method = "05CC89CFE228C27B7E04895576ABC3FB", hash_generated_method = "235CB6FA236A20FB58BDFD6E5092583E")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_242516740 = (o == this);
        } 
        final PeriodicSync other = (PeriodicSync) o;
        boolean var0F46930ADB8E4361FDA12695D042DC05_512143919 = (account.equals(other.account)
                && authority.equals(other.authority)
                && period == other.period
                && SyncStorageEngine.equals(extras, other.extras));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715054448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715054448;
        
        
            
        
        
            
        
        
        
                
                
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.464 -0400", hash_original_field = "D1D66675233804683D3FB5AA9833457F", hash_generated_field = "476BDAB47FF19722C7E6C835502904C2")

    public static final Creator<PeriodicSync> CREATOR = new Creator<PeriodicSync>() {
        public PeriodicSync createFromParcel(Parcel source) {
            return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong());
        }

        public PeriodicSync[] newArray(int size) {
            return new PeriodicSync[size];
        }
    };
    
    public PeriodicSync createFromParcel(Parcel source) {
            return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong());
        }
    
    
    public PeriodicSync[] newArray(int size) {
            return new PeriodicSync[size];
        }
    
}

