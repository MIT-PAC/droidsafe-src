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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.093 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.093 -0400", hash_original_field = "642DD1F2CDF049378FF093FB182D60AF", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public String accountType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.093 -0400", hash_original_field = "0E4C65D409CD4831B90E8525882FF6B7", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public boolean isKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.093 -0400", hash_original_field = "DCC9B65BEB3A994B069BE8FDD23F9E0B", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private boolean userVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.095 -0400", hash_original_field = "617A9A4A6D58471D2E103EEF489AA5B6", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private boolean supportsUploading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.096 -0400", hash_original_field = "391766E6A8AA19C7BFCC7418EF28F75F", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private boolean isAlwaysSyncable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.096 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.096 -0400", hash_original_field = "80041F9B9EDF6183DE1C21317DF17D2A", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private String settingsActivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.102 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "97D3DB785512574DCA275BCBC4B03AD2")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_748440932 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1754845413 = (TextUtils.isEmpty(accountType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.127 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "2C0DB6D3A88E4CE1D37247F063CCBB2D")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1723477898 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1678702975 = (TextUtils.isEmpty(accountType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.129 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "74B7BD5B15E9425B271662256543FC21")
    private  SyncAdapterType(String authority, String accountType) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1418499951 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1889564686 = (TextUtils.isEmpty(accountType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.130 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BA5B95BC49F29754E6A41C165811392F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.131 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "0EE14BB1395BE1D450377E6F7D417D8D")
    public boolean supportsUploading() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453116730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453116730;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return supportsUploading;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.131 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "09FAB64AE647B464284FE681595299AC")
    public boolean isUserVisible() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130114135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130114135;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return userVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.133 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "4230179395DDE1D029473FEDCEE54F48")
    public boolean allowParallelSyncs() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093881770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093881770;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.143 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "C11D38EEC541AB3ACE5AAAB2B4B9C0EE")
    public boolean isAlwaysSyncable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829890648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829890648;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return isAlwaysSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.156 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "BFD0F2BB2F2DCE04F7AAF9C3E34899B7")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_2058279672 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2058279672 = settingsActivity;
        varB4EAC82CA7396A68D541C85D26508E83_2058279672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058279672;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.158 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "BAA72691674E7C52C9BCB0369C24B2F0")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_249418495 = (o == this);
        } //End collapsed parenthetic
        SyncAdapterType other;
        other = (SyncAdapterType)o;
        boolean var5E7B2BE5B83770AB325FD6B40928AD13_541582889 = (authority.equals(other.authority) && accountType.equals(other.accountType));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113111033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113111033;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SyncAdapterType)) return false;
        //final SyncAdapterType other = (SyncAdapterType)o;
        //return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.159 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "A0F9A72D59F80F9A07434BCAED532AD4")
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137321331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137321331;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + authority.hashCode();
        //result = 31 * result + accountType.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.170 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "DAFE80783CE898248F59536539CA5086")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1397986692 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1993393831 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1397986692 = "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1993393831 = "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
        } //End block
        String varA7E53CE21691AB073D9660D615818899_188712830; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_188712830 = varB4EAC82CA7396A68D541C85D26508E83_1397986692;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_188712830 = varB4EAC82CA7396A68D541C85D26508E83_1993393831;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_188712830.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_188712830;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.171 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1A4DDECB27ECD0E062E48162942625F5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445788342 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445788342;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.180 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "8696CB918FF4B34C9AE538373A6A13DB")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:59.180 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {
        public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }

        public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    };
}

