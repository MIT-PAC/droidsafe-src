package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Bundle;
import android.os.Parcel;
import android.accounts.Account;

public class PeriodicSync implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.240 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public Account account;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.240 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.240 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.241 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "49C5D8DF45BFC99E2E96D80F4EA633C6")

    public long period;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.243 -0400", hash_original_method = "34D447B50A8BF0311FD91158BAB8271D", hash_generated_method = "8811081678FE37BAFD2ECD5814D13257")
    public  PeriodicSync(Account account, String authority, Bundle extras, long period) {
        this.account = account;
        this.authority = authority;
        this.extras = new Bundle(extras);
        this.period = period;
        // ---------- Original Method ----------
        //this.account = account;
        //this.authority = authority;
        //this.extras = new Bundle(extras);
        //this.period = period;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.243 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C7A77A7AB7D01842AF87B4447D5CFD0B")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_992826110 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881757591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881757591;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.244 -0400", hash_original_method = "D77F1A5B85A714E7D78D3A9001CC9547", hash_generated_method = "6FEC3E8CA67B12F2B83AD9792E783FFE")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        account.writeToParcel(dest, flags);
        dest.writeString(authority);
        dest.writeBundle(extras);
        dest.writeLong(period);
        // ---------- Original Method ----------
        //account.writeToParcel(dest, flags);
        //dest.writeString(authority);
        //dest.writeBundle(extras);
        //dest.writeLong(period);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.246 -0400", hash_original_method = "05CC89CFE228C27B7E04895576ABC3FB", hash_generated_method = "437AD0BA3211943B86A4B025120155FF")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_343547816 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218645347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218645347;
        } //End block
    if(!(o instanceof PeriodicSync))        
        {
            boolean var68934A3E9455FA72420237EB05902327_795060769 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625396828 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_625396828;
        } //End block
        final PeriodicSync other = (PeriodicSync) o;
        boolean varF21DE64CB31FC03DD0E27292A2503664_1406483524 = (account.equals(other.account)
                && authority.equals(other.authority)
                && period == other.period
                && SyncStorageEngine.equals(extras, other.extras));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044263657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044263657;
        // ---------- Original Method ----------
        //if (o == this) {
            //return true;
        //}
        //if (!(o instanceof PeriodicSync)) {
            //return false;
        //}
        //final PeriodicSync other = (PeriodicSync) o;
        //return account.equals(other.account)
                //&& authority.equals(other.authority)
                //&& period == other.period
                //&& SyncStorageEngine.equals(extras, other.extras);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.247 -0400", hash_original_field = "D1D66675233804683D3FB5AA9833457F", hash_generated_field = "476BDAB47FF19722C7E6C835502904C2")

    public static final Creator<PeriodicSync> CREATOR = new Creator<PeriodicSync>() {
        public PeriodicSync createFromParcel(Parcel source) {
            return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong());
        }

        public PeriodicSync[] newArray(int size) {
            return new PeriodicSync[size];
        }
    };
    // orphaned legacy method
    public PeriodicSync createFromParcel(Parcel source) {
            return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong());
        }
    
    // orphaned legacy method
    public PeriodicSync[] newArray(int size) {
            return new PeriodicSync[size];
        }
    
}

