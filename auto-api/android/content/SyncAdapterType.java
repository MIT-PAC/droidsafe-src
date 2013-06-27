package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextUtils;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncAdapterType implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.648 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.648 -0400", hash_original_field = "642DD1F2CDF049378FF093FB182D60AF", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public String accountType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.648 -0400", hash_original_field = "0E4C65D409CD4831B90E8525882FF6B7", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public boolean isKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.648 -0400", hash_original_field = "DCC9B65BEB3A994B069BE8FDD23F9E0B", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private boolean userVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.649 -0400", hash_original_field = "617A9A4A6D58471D2E103EEF489AA5B6", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private boolean supportsUploading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.649 -0400", hash_original_field = "391766E6A8AA19C7BFCC7418EF28F75F", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private boolean isAlwaysSyncable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.649 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.649 -0400", hash_original_field = "80041F9B9EDF6183DE1C21317DF17D2A", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private String settingsActivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.669 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "C91CB2575905EC866D73A88A9442EC43")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_672063278 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1847951232 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = userVisible;
        this.supportsUploading = supportsUploading;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = false;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = userVisible;
        //this.supportsUploading = supportsUploading;
        //this.isAlwaysSyncable = false;
        //this.allowParallelSyncs = false;
        //this.settingsActivity = null;
        //this.isKey = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.684 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "8A4D8C2315F9DE60A4FEA1CECA7D1FB5")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_389543606 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1647522717 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = userVisible;
        this.supportsUploading = supportsUploading;
        this.isAlwaysSyncable = isAlwaysSyncable;
        this.allowParallelSyncs = allowParallelSyncs;
        this.settingsActivity = settingsActivity;
        this.isKey = false;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = userVisible;
        //this.supportsUploading = supportsUploading;
        //this.isAlwaysSyncable = isAlwaysSyncable;
        //this.allowParallelSyncs = allowParallelSyncs;
        //this.settingsActivity = settingsActivity;
        //this.isKey = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.691 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "33F5451A6777DB1B17E84BC378050E7A")
    private  SyncAdapterType(String authority, String accountType) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1437475297 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1492711789 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.authority = authority;
        this.accountType = accountType;
        this.userVisible = true;
        this.supportsUploading = true;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = true;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = true;
        //this.supportsUploading = true;
        //this.isAlwaysSyncable = false;
        //this.allowParallelSyncs = false;
        //this.settingsActivity = null;
        //this.isKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.699 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BA5B95BC49F29754E6A41C165811392F")
    public  SyncAdapterType(Parcel source) {
        this(
                source.readString(),
                source.readString(),
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readString());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.700 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "BFA68A55DCB01D792BA9673A403B2EEA")
    public boolean supportsUploading() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490277758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490277758;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return supportsUploading;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.701 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "0578B542BB6EC75AE2D3229CC5F7D285")
    public boolean isUserVisible() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669525897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_669525897;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return userVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.715 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "DA1795703E8507734B4D774600C3F663")
    public boolean allowParallelSyncs() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322619107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322619107;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.716 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "749958186365875C246C098ED310BAFD")
    public boolean isAlwaysSyncable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576529486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576529486;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return isAlwaysSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.720 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "6229ABE34B463EF543E4C1B0E24A63FF")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_2136574398 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2136574398 = settingsActivity;
        varB4EAC82CA7396A68D541C85D26508E83_2136574398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2136574398;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return settingsActivity;
    }

    
        public static SyncAdapterType newKey(String authority, String accountType) {
        return new SyncAdapterType(authority, accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.737 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "9797B615ED1D96ED3BBD5F5D55E67AE9")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1686131721 = (o == this);
        } //End collapsed parenthetic
        SyncAdapterType other;
        other = (SyncAdapterType)o;
        boolean var5E7B2BE5B83770AB325FD6B40928AD13_1389671341 = (authority.equals(other.authority) && accountType.equals(other.accountType));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798765729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798765729;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SyncAdapterType)) return false;
        //final SyncAdapterType other = (SyncAdapterType)o;
        //return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.808 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "F564BCFFA57BAFEC4A20E079B8F2EB21")
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454345665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454345665;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + authority.hashCode();
        //result = 31 * result + accountType.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.818 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "87BF08E9F5941ED83F0D8D1D26AD4EC0")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1122211509 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_304204590 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1122211509 = "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_304204590 = "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1479794083; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1479794083 = varB4EAC82CA7396A68D541C85D26508E83_1122211509;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1479794083 = varB4EAC82CA7396A68D541C85D26508E83_304204590;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1479794083.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1479794083;
        // ---------- Original Method ----------
        //if (isKey) {
            //return "SyncAdapterType Key {name=" + authority
                    //+ ", type=" + accountType
                    //+ "}";
        //} else {
            //return "SyncAdapterType {name=" + authority
                    //+ ", type=" + accountType
                    //+ ", userVisible=" + userVisible
                    //+ ", supportsUploading=" + supportsUploading
                    //+ ", isAlwaysSyncable=" + isAlwaysSyncable
                    //+ ", allowParallelSyncs=" + allowParallelSyncs
                    //+ ", settingsActivity=" + settingsActivity
                    //+ "}";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.819 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C4002A152323425187E2B3E415E057E2")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395868619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395868619;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.828 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "8696CB918FF4B34C9AE538373A6A13DB")
    public void writeToParcel(Parcel dest, int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("keys aren't parcelable");
        } //End block
        dest.writeString(authority);
        dest.writeString(accountType);
        dest.writeInt(userVisible ? 1 : 0);
        dest.writeInt(supportsUploading ? 1 : 0);
        dest.writeInt(isAlwaysSyncable ? 1 : 0);
        dest.writeInt(allowParallelSyncs ? 1 : 0);
        dest.writeString(settingsActivity);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException("keys aren't parcelable");
        //}
        //dest.writeString(authority);
        //dest.writeString(accountType);
        //dest.writeInt(userVisible ? 1 : 0);
        //dest.writeInt(supportsUploading ? 1 : 0);
        //dest.writeInt(isAlwaysSyncable ? 1 : 0);
        //dest.writeInt(allowParallelSyncs ? 1 : 0);
        //dest.writeString(settingsActivity);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.828 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {
        public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }

        public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    };
}

