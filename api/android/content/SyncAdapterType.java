package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextUtils;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncAdapterType implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.382 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.382 -0400", hash_original_field = "642DD1F2CDF049378FF093FB182D60AF", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public String accountType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.382 -0400", hash_original_field = "0E4C65D409CD4831B90E8525882FF6B7", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public boolean isKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.382 -0400", hash_original_field = "DCC9B65BEB3A994B069BE8FDD23F9E0B", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private boolean userVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.383 -0400", hash_original_field = "617A9A4A6D58471D2E103EEF489AA5B6", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private boolean supportsUploading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.383 -0400", hash_original_field = "391766E6A8AA19C7BFCC7418EF28F75F", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private boolean isAlwaysSyncable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.383 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.383 -0400", hash_original_field = "80041F9B9EDF6183DE1C21317DF17D2A", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private String settingsActivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.385 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "3B2BA7AD8F0CB2F368AD77D4ADAC641C")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
    if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_928619962 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_928619962.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_928619962;
        } //End block
    if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_1460611349 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_1460611349.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_1460611349;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.391 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "4DDD6FF371EAA23B078B7565F8676CBA")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
    if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_238666707 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_238666707.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_238666707;
        } //End block
    if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_708697072 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_708697072.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_708697072;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.394 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "279BE3B92B0117B33BF6F5BE419C59C8")
    private  SyncAdapterType(String authority, String accountType) {
    if(TextUtils.isEmpty(authority))        
        {
            IllegalArgumentException varA93699DE5E3452160763FFD32794DC21_515249203 = new IllegalArgumentException("the authority must not be empty: " + authority);
            varA93699DE5E3452160763FFD32794DC21_515249203.addTaint(taint);
            throw varA93699DE5E3452160763FFD32794DC21_515249203;
        } //End block
    if(TextUtils.isEmpty(accountType))        
        {
            IllegalArgumentException var9EF813351D0B3CE30E14DE9AE8813AA0_122989684 = new IllegalArgumentException("the accountType must not be empty: " + accountType);
            var9EF813351D0B3CE30E14DE9AE8813AA0_122989684.addTaint(taint);
            throw var9EF813351D0B3CE30E14DE9AE8813AA0_122989684;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.395 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BA5B95BC49F29754E6A41C165811392F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.396 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "79251D951C8D11360E647B0153C8898E")
    public boolean supportsUploading() {
    if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1510546225 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1510546225.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1510546225;
        } //End block
        boolean var617A9A4A6D58471D2E103EEF489AA5B6_1254138680 = (supportsUploading);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835355222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835355222;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return supportsUploading;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.397 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "B40BCAC3E2CE5C9D042D3ECB5AEC60D9")
    public boolean isUserVisible() {
    if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_133991078 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_133991078.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_133991078;
        } //End block
        boolean varDCC9B65BEB3A994B069BE8FDD23F9E0B_1256994253 = (userVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868203997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868203997;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return userVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.398 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "D8FAF93D3A0A2E6B33AE43C4D575817A")
    public boolean allowParallelSyncs() {
    if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1834000692 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1834000692.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1834000692;
        } //End block
        boolean var577E05B3572C976DAF60C9783F6204CF_1911574861 = (allowParallelSyncs);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18951465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18951465;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.399 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "B4189FEBA333EE6B1D0863F9BADB3FA9")
    public boolean isAlwaysSyncable() {
    if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_1676026109 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_1676026109.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_1676026109;
        } //End block
        boolean var391766E6A8AA19C7BFCC7418EF28F75F_1491092994 = (isAlwaysSyncable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824689836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824689836;
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return isAlwaysSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.400 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "4CE7688BA00EDE1813C13DC676AA0A7E")
    public String getSettingsActivity() {
    if(isKey)        
        {
            IllegalStateException var9AC4E6CF5DB1A8600BB25EB267540083_372916513 = new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
            var9AC4E6CF5DB1A8600BB25EB267540083_372916513.addTaint(taint);
            throw var9AC4E6CF5DB1A8600BB25EB267540083_372916513;
        } //End block
String var99638EA45B20928CF2245440E0728CEF_35102691 =         settingsActivity;
        var99638EA45B20928CF2245440E0728CEF_35102691.addTaint(taint);
        return var99638EA45B20928CF2245440E0728CEF_35102691;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.402 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "85AF8D90037BDBF88ADDCB224C6BD95D")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1577198781 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287912760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287912760;
        }
    if(!(o instanceof SyncAdapterType))        
        {
        boolean var68934A3E9455FA72420237EB05902327_977251288 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666888902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666888902;
        }
        final SyncAdapterType other = (SyncAdapterType)o;
        boolean var57D246962AD954851DEF5671274CAB5A_332383307 = (authority.equals(other.authority) && accountType.equals(other.accountType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075215384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075215384;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SyncAdapterType)) return false;
        //final SyncAdapterType other = (SyncAdapterType)o;
        //return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.403 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "8010329E24E70DCC7436BF60809DB19F")
    public int hashCode() {
        int result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_1900971267 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415813182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415813182;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + authority.hashCode();
        //result = 31 * result + accountType.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.404 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "C28AFB4FCDC61C0F2E6D10C82A31ADFE")
    public String toString() {
    if(isKey)        
        {
String var7E9C2CCED9F9AFA21A27D93287F98B75_1507776365 =             "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
            var7E9C2CCED9F9AFA21A27D93287F98B75_1507776365.addTaint(taint);
            return var7E9C2CCED9F9AFA21A27D93287F98B75_1507776365;
        } //End block
        else
        {
String var2060563EFD93E4F59770E183A15C5E49_309341817 =             "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
            var2060563EFD93E4F59770E183A15C5E49_309341817.addTaint(taint);
            return var2060563EFD93E4F59770E183A15C5E49_309341817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.405 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BB2802F7D8EFD80FDB4A277F621056D4")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2063300135 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375517932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375517932;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.406 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "148EC0FE04320D761B91A9C8B906EA83")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
    if(isKey)        
        {
            IllegalStateException var00D58C44047647550D0AAF5EF75BF7AD_822773569 = new IllegalStateException("keys aren't parcelable");
            var00D58C44047647550D0AAF5EF75BF7AD_822773569.addTaint(taint);
            throw var00D58C44047647550D0AAF5EF75BF7AD_822773569;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.406 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

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

