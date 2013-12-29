package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class SyncAdapterType implements Parcelable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.082 -0500", hash_original_method = "BE9D5A7300F00B3E167DEF043BAF0785", hash_generated_method = "66A2B5AAD58478E08B2058881DDCEBDB")
    public static SyncAdapterType newKey(String authority, String accountType) {
        return new SyncAdapterType(authority, accountType);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.915 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.088 -0500", hash_original_method = "63BD8FE183983D6CDCBA016F3E24D9D5", hash_generated_method = "7EC49768DC45426B5D5D27A17821CBA7")
        public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.089 -0500", hash_original_method = "9B9CC41BB0EF0A8D0D6C6DC12ADA0165", hash_generated_method = "9D23C2EC532E5D8CF591C7F369DDE99E")
        public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.068 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public  String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.069 -0500", hash_original_field = "ED8E0AA6D77344B926CB45811BAD4A69", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public  String accountType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.070 -0500", hash_original_field = "664A69B396846033C28FF67B0408AFFE", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public  boolean isKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.071 -0500", hash_original_field = "69550B70A521DDCCDE611C61AEC55F32", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private  boolean userVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.071 -0500", hash_original_field = "2E8330CD8CBF5978305E571EE85DF34C", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private  boolean supportsUploading;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.072 -0500", hash_original_field = "D93A104DAB2A0DA5826B0B6C97B18B76", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private  boolean isAlwaysSyncable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.073 -0500", hash_original_field = "45DFE1195B1606D7F5BD6BE7998F9A8A", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private  boolean allowParallelSyncs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.074 -0500", hash_original_field = "C799623DFD1647785EE6ABF905E19139", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private  String settingsActivity;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.075 -0500", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "5CCA08FD4E06876D5968F90975B05BF6")
    public SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("the authority must not be empty: " + authority);
        }
        if (TextUtils.isEmpty(accountType)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        }
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = userVisible;
        this.supportsUploading = supportsUploading;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = false;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.076 -0500", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "64FAEB8F306F71153F5D9866E53D378B")
    public SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("the authority must not be empty: " + authority);
        }
        if (TextUtils.isEmpty(accountType)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        }
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = userVisible;
        this.supportsUploading = supportsUploading;
        this.isAlwaysSyncable = isAlwaysSyncable;
        this.allowParallelSyncs = allowParallelSyncs;
        this.settingsActivity = settingsActivity;
        this.isKey = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.077 -0500", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "BFD4D32CC834C337A352471F08214430")
    private SyncAdapterType(String authority, String accountType) {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("the authority must not be empty: " + authority);
        }
        if (TextUtils.isEmpty(accountType)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        }
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = true;
        this.supportsUploading = true;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.087 -0500", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "57196294B9E5CE0ABE9762FD5F23FA4A")
    public SyncAdapterType(Parcel source) {
        this(
                source.readString(),
                source.readString(),
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.077 -0500", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "C07F87BF6F609B2EF68D586D3E67B48F")
    public boolean supportsUploading() {
        if (isKey) {
            throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        }
        return supportsUploading;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.078 -0500", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "EFDDC56B6F999562C439EC64FCAC6C68")
    public boolean isUserVisible() {
        if (isKey) {
            throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        }
        return userVisible;
    }

    /**
     * @return True if this SyncAdapter supports syncing multiple accounts simultaneously.
     * If false then the SyncManager will take care to only start one sync at a time
     * using this SyncAdapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.079 -0500", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "93738CA6338EA3FA22E2E874061D17FD")
    public boolean allowParallelSyncs() {
        if (isKey) {
            throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        }
        return allowParallelSyncs;
    }

    /**
     * If true then the SyncManager will never issue an initialization sync to the SyncAdapter
     * and will instead automatically call
     * {@link ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with a
     * value of 1 for each account and provider that this sync adapter supports.
     * @return true if the SyncAdapter does not require initialization and if it is ok for the
     * SyncAdapter to treat it as syncable automatically.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.080 -0500", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "6E9ED9CA2328B2186B8B3383E2171F69")
    public boolean isAlwaysSyncable() {
        if (isKey) {
            throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        }
        return isAlwaysSyncable;
    }

    /**
     * @return The activity to use to invoke this SyncAdapter's settings activity.
     * May be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.081 -0500", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "2B2C7E20B6DD46CE353FB91528567605")
    public String getSettingsActivity() {
        if (isKey) {
            throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        }
        return settingsActivity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.083 -0500", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "087530CFCC4DA554EC8258BACC47DA1E")
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SyncAdapterType)) return false;
        final SyncAdapterType other = (SyncAdapterType)o;
        // don't include userVisible or supportsUploading in the equality check
        return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.084 -0500", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "FD796F4389853C23CBCF318ECE7050C7")
    public int hashCode() {
        int result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        // don't include userVisible or supportsUploading  the hash
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.084 -0500", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "2BCD0886A28F77327C771B41B441D23E")
    public String toString() {
        if (isKey) {
            return "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
        } else {
            return "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.085 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:02.086 -0500", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "7C3D3D7AD55181DBEDD396F243CB19B5")
    public void writeToParcel(Parcel dest, int flags) {
        if (isKey) {
            throw new IllegalStateException("keys aren't parcelable");
        }

        dest.writeString(authority);
        dest.writeString(accountType);
        dest.writeInt(userVisible ? 1 : 0);
        dest.writeInt(supportsUploading ? 1 : 0);
        dest.writeInt(isAlwaysSyncable ? 1 : 0);
        dest.writeInt(allowParallelSyncs ? 1 : 0);
        dest.writeString(settingsActivity);
    }
    // orphaned legacy method
    public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }
    
    // orphaned legacy method
    public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    
}

