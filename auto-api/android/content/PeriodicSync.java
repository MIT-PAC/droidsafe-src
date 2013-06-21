package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Bundle;
import android.os.Parcel;
import android.accounts.Account;

public class PeriodicSync implements Parcelable {
    public Account account;
    public String authority;
    public Bundle extras;
    public long period;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.071 -0400", hash_original_method = "34D447B50A8BF0311FD91158BAB8271D", hash_generated_method = "548D5ED2144E8A778AEF87A6FC2D1D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PeriodicSync(Account account, String authority, Bundle extras, long period) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(account.dsTaint);
        dsTaint.addTaint(period);
        dsTaint.addTaint(extras.dsTaint);
        this.extras = new Bundle(extras);
        // ---------- Original Method ----------
        //this.account = account;
        //this.authority = authority;
        //this.extras = new Bundle(extras);
        //this.period = period;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.072 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.072 -0400", hash_original_method = "D77F1A5B85A714E7D78D3A9001CC9547", hash_generated_method = "6B2FC293CF1C52302F498AB664A09FD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.073 -0400", hash_original_method = "05CC89CFE228C27B7E04895576ABC3FB", hash_generated_method = "9132F68F9B03542698C60E474DDB7611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1681321546 = (o == this);
        } //End collapsed parenthetic
        PeriodicSync other;
        other = (PeriodicSync) o;
        boolean var0F46930ADB8E4361FDA12695D042DC05_1697540315 = (account.equals(other.account)
                && authority.equals(other.authority)
                && period == other.period
                && SyncStorageEngine.equals(extras, other.extras));
        return dsTaint.getTaintBoolean();
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

    
    public static final Creator<PeriodicSync> CREATOR = new Creator<PeriodicSync>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.073 -0400", hash_original_method = "1DDDAEB0A3936D38ABA192522EF53B01", hash_generated_method = "C0DB5A0637B2A1A464D863C4BE08260C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PeriodicSync createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PeriodicSync varCFBBE8132D94EC7BFF486F111D7011F8_38583074 = (new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong()));
            return (PeriodicSync)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    //source.readString(), source.readBundle(), source.readLong());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.073 -0400", hash_original_method = "B8DE296655EF89F17A5BDA7DD5043F30", hash_generated_method = "E44C403FDCEE6C534443325AF73303A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PeriodicSync[] newArray(int size) {
            dsTaint.addTaint(size);
            PeriodicSync[] var5A4ECCE034B29B03D4F7544311FDBA8D_1711704141 = (new PeriodicSync[size]);
            return (PeriodicSync[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PeriodicSync[size];
        }

        
}; //Transformed anonymous class
}

