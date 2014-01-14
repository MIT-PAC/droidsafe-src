package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class PeriodicSync implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.713 -0400", hash_original_field = "D1D66675233804683D3FB5AA9833457F", hash_generated_field = "476BDAB47FF19722C7E6C835502904C2")

    public static final Creator<PeriodicSync> CREATOR = new Creator<PeriodicSync>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.588 -0500", hash_original_method = "1DDDAEB0A3936D38ABA192522EF53B01", hash_generated_method = "1942E7F4F3EEE1F864E20D1D637617B6")
        
public PeriodicSync createFromParcel(Parcel source) {
            return new PeriodicSync(Account.CREATOR.createFromParcel(source),
                    source.readString(), source.readBundle(), source.readLong());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.591 -0500", hash_original_method = "B8DE296655EF89F17A5BDA7DD5043F30", hash_generated_method = "1C425310D40E8BF71E3763E5FC81EA49")
        
public PeriodicSync[] newArray(int size) {
            return new PeriodicSync[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.572 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public  Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.574 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public  String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.576 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public  Bundle extras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.579 -0500", hash_original_field = "21C6B258F031958D40A6DAC5279E0EE8", hash_generated_field = "49C5D8DF45BFC99E2E96D80F4EA633C6")

    public  long period;

    /** Creates a new PeriodicSync, copying the Bundle */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.581 -0500", hash_original_method = "34D447B50A8BF0311FD91158BAB8271D", hash_generated_method = "629A4461D3844C6A125DAA9A9D517CBA")
    
public PeriodicSync(Account account, String authority, Bundle extras, long period) {
        this.account = account;
        this.authority = authority;
        this.extras = new Bundle(extras);
        this.period = period;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.583 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.585 -0500", hash_original_method = "D77F1A5B85A714E7D78D3A9001CC9547", hash_generated_method = "F16843460B395BC9C7C565520BFD6119")
    
public void writeToParcel(Parcel dest, int flags) {
        account.writeToParcel(dest, flags);
        dest.writeString(authority);
        dest.writeBundle(extras);
        dest.writeLong(period);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.595 -0500", hash_original_method = "05CC89CFE228C27B7E04895576ABC3FB", hash_generated_method = "7A226861F582A0ADBC3B2587703A02A7")
    
public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof PeriodicSync)) {
            return false;
        }

        final PeriodicSync other = (PeriodicSync) o;

        return account.equals(other.account)
                && authority.equals(other.authority)
                && period == other.period
                && SyncStorageEngine.equals(extras, other.extras);
    }
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

