package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextUtils;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncAdapterType implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.888 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "642DD1F2CDF049378FF093FB182D60AF", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public String accountType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "0E4C65D409CD4831B90E8525882FF6B7", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public boolean isKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "DCC9B65BEB3A994B069BE8FDD23F9E0B", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private boolean userVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "617A9A4A6D58471D2E103EEF489AA5B6", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private boolean supportsUploading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "391766E6A8AA19C7BFCC7418EF28F75F", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private boolean isAlwaysSyncable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.889 -0400", hash_original_field = "80041F9B9EDF6183DE1C21317DF17D2A", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private String settingsActivity;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.891 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "10D6044283661BAEB499B7919AD4342E")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_1216757805 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_1216757805.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_1216757805;
        } //End block
        if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_1176863098 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_1176863098.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_1176863098;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.896 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "0A84F3A2928555CF755678A4B56D93BC")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_2005655735 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_2005655735.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_2005655735;
        } //End block
        if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_1364224055 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_1364224055.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_1364224055;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.899 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "12ED39C6B17297309E1F49D52D72184B")
    private  SyncAdapterType(String authority, String accountType) {
        if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_1950068132 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_1950068132.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_1950068132;
        } //End block
        if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_2002213147 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_2002213147.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_2002213147;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.900 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BA5B95BC49F29754E6A41C165811392F")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.901 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "CCC4FFE1204DB81F8EA59452FB37C7DC")
    public boolean supportsUploading() {
        if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_538903885 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_538903885.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_538903885;
        } //End block
        boolean var617A9A4A6D58471D2E103EEF489AA5B6_1968680050 = (supportsUploading);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029005138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029005138;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return supportsUploading;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.902 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "CCD2D68DA4FFC7ABF306916F3C9447FD")
    public boolean isUserVisible() {
        if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1035656282 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1035656282.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1035656282;
        } //End block
        boolean varDCC9B65BEB3A994B069BE8FDD23F9E0B_1451773072 = (userVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15470865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_15470865;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return userVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.902 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "4CC00D3C8B5544FAD76445138E7AF03E")
    public boolean allowParallelSyncs() {
        if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1525450428 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1525450428.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1525450428;
        } //End block
        boolean var577E05B3572C976DAF60C9783F6204CF_1403651892 = (allowParallelSyncs);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223256323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223256323;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.903 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "A82DA67525190EC8C88AAA47FA784577")
    public boolean isAlwaysSyncable() {
        if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1630814424 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1630814424.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1630814424;
        } //End block
        boolean var391766E6A8AA19C7BFCC7418EF28F75F_1816363341 = (isAlwaysSyncable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860204715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_860204715;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return isAlwaysSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.905 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "78A63EC9772138BC33C083EAC4FE2C34")
    public String getSettingsActivity() {
        if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_580976407 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_580976407.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_580976407;
        } //End block
String var99638EA45B20928CF2245440E0728CEF_977333460 =         settingsActivity;
        var99638EA45B20928CF2245440E0728CEF_977333460.addTaint(taint);
        return var99638EA45B20928CF2245440E0728CEF_977333460;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return settingsActivity;
    }

    
    @DSModeled(DSC.SAFE)
    public static SyncAdapterType newKey(String authority, String accountType) {
        return new SyncAdapterType(authority, accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.907 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "B712E5BE38DA2B551C353244C7235978")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1317754122 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1321349195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1321349195;
        }
        if(!(o instanceof SyncAdapterType))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1986922970 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518093926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_518093926;
        }
        final SyncAdapterType other = (SyncAdapterType)o;
        boolean var57D246962AD954851DEF5671274CAB5A_393588783 = (authority.equals(other.authority) && accountType.equals(other.accountType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140347970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140347970;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SyncAdapterType)) return false;
        //final SyncAdapterType other = (SyncAdapterType)o;
        //return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.908 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "E786A372E46B495A7F3F880D22ED2809")
    public int hashCode() {
        int result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_1578105010 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030273804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030273804;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + authority.hashCode();
        //result = 31 * result + accountType.hashCode();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.911 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "D6661DDD0776EEB0AD63A1FE230144AC")
    public String toString() {
        if(isKey)        
        {
String var7E9C2CCED9F9AFA21A27D93287F98B75_1019121235 =             "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
            var7E9C2CCED9F9AFA21A27D93287F98B75_1019121235.addTaint(taint);
            return var7E9C2CCED9F9AFA21A27D93287F98B75_1019121235;
        } //End block
        else
        {
String var2060563EFD93E4F59770E183A15C5E49_324604312 =             "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
            var2060563EFD93E4F59770E183A15C5E49_324604312.addTaint(taint);
            return var2060563EFD93E4F59770E183A15C5E49_324604312;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.913 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "65209CA1942BB55BFA318C4993F08FB0")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1802536770 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999861193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999861193;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.914 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "9566AAFB0CB03917006A031C1415570A")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        if(isKey)        
        {
            IllegalStateException var00D58C44047647550D0AAF5EF75BF7AD_1724419018 = new IllegalStateException("keys aren't parcelable");
            var00D58C44047647550D0AAF5EF75BF7AD_1724419018.addTaint(taint);
            throw var00D58C44047647550D0AAF5EF75BF7AD_1724419018;
        } //End block
        dest.writeString(authority);
        dest.writeString(accountType);
        dest.writeInt(userVisible ? 1 : 0);
        dest.writeInt(supportsUploading ? 1 : 0);
        dest.writeInt(isAlwaysSyncable ? 1 : 0);
        dest.writeInt(allowParallelSyncs ? 1 : 0);
        dest.writeString(settingsActivity);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.915 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {
        public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }

        public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    };
    // orphaned legacy method
    public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }
    
    // orphaned legacy method
    public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    
}

