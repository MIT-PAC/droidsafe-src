package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.TextUtils;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncAdapterType implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "642DD1F2CDF049378FF093FB182D60AF", hash_generated_field = "605DE0A253B85773EFA64EA7D260C004")

    public String accountType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "0E4C65D409CD4831B90E8525882FF6B7", hash_generated_field = "46331B9D058E77D8FEAF6DAFE4893538")

    public boolean isKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "DCC9B65BEB3A994B069BE8FDD23F9E0B", hash_generated_field = "FDD9716B7EE01E6C7F7C61A406C475B3")

    private boolean userVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "617A9A4A6D58471D2E103EEF489AA5B6", hash_generated_field = "2F0669A8CD6713EC731AA9423751D433")

    private boolean supportsUploading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "391766E6A8AA19C7BFCC7418EF28F75F", hash_generated_field = "EC5A70CA56D9ACB11F8E30281DEFCA45")

    private boolean isAlwaysSyncable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "08F3F9E210EACF3E681E9F79AF28B21B")

    private boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.529 -0400", hash_original_field = "80041F9B9EDF6183DE1C21317DF17D2A", hash_generated_field = "3FB7BC54288EFE7E0876E59723A6F2A5")

    private String settingsActivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.530 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "9EA1D663853E248F8265F639A614657A")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1763917891 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } 
        } 
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1798470936 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.530 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "8A7C21420CD0038DF658A15D8E81B79D")
    public  SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_349258784 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } 
        } 
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1424959834 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.531 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "07EF3D7EA82BBD8A53B46C8AC3741E6E")
    private  SyncAdapterType(String authority, String accountType) {
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_888724354 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } 
        } 
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1932092127 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.532 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BA5B95BC49F29754E6A41C165811392F")
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
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.533 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "61FD79CD4524552AE59609A022EE7723")
    public boolean supportsUploading() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783724763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783724763;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.534 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "60281A0E824B3F53FF1A1833B452A304")
    public boolean isUserVisible() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832209464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832209464;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.534 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "108D601F4EB4AC30E1CCF6A87793710C")
    public boolean allowParallelSyncs() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067615530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067615530;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.535 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "24958C0A9C98DF3E0B2674ADABB71B50")
    public boolean isAlwaysSyncable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427007358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427007358;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.536 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "B494F2B7718A0EC5DCCB5F7D202AA260")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_2006877821 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2006877821 = settingsActivity;
        varB4EAC82CA7396A68D541C85D26508E83_2006877821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2006877821;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SyncAdapterType newKey(String authority, String accountType) {
        return new SyncAdapterType(authority, accountType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.537 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "963AA50C67DFF05160EF7773DBBD380D")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_530673385 = (o == this);
        } 
        final SyncAdapterType other = (SyncAdapterType)o;
        boolean var5E7B2BE5B83770AB325FD6B40928AD13_1548383266 = (authority.equals(other.authority) && accountType.equals(other.accountType));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403518566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403518566;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.538 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "A5AFB894D1400F2DD187BDA646E60E23")
    public int hashCode() {
        int result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889456598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889456598;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.539 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "D6EA6CBD88C77A1CE85EDEB4B02BA32D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_281258751 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1632123153 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_281258751 = "SyncAdapterType Key {name=" + authority
                    + ", type=" + accountType
                    + "}";
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1632123153 = "SyncAdapterType {name=" + authority
                    + ", type=" + accountType
                    + ", userVisible=" + userVisible
                    + ", supportsUploading=" + supportsUploading
                    + ", isAlwaysSyncable=" + isAlwaysSyncable
                    + ", allowParallelSyncs=" + allowParallelSyncs
                    + ", settingsActivity=" + settingsActivity
                    + "}";
        } 
        String varA7E53CE21691AB073D9660D615818899_1545493671; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1545493671 = varB4EAC82CA7396A68D541C85D26508E83_281258751;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1545493671 = varB4EAC82CA7396A68D541C85D26508E83_1632123153;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1545493671.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1545493671;
        
        
            
                    
                    
        
            
                    
                    
                    
                    
                    
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.540 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E7ABEFEF169C9F292BEC7C30D47E908D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707091819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707091819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.541 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "8696CB918FF4B34C9AE538373A6A13DB")
    public void writeToParcel(Parcel dest, int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("keys aren't parcelable");
        } 
        dest.writeString(authority);
        dest.writeString(accountType);
        dest.writeInt(userVisible ? 1 : 0);
        dest.writeInt(supportsUploading ? 1 : 0);
        dest.writeInt(isAlwaysSyncable ? 1 : 0);
        dest.writeInt(allowParallelSyncs ? 1 : 0);
        dest.writeString(settingsActivity);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.541 -0400", hash_original_field = "C0271090D095B41DEE511966A620F157", hash_generated_field = "D799AD48CC34F9F1CF0974DC61C7D14C")

    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {
        public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }

        public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    };
    
    public SyncAdapterType createFromParcel(Parcel source) {
            return new SyncAdapterType(source);
        }
    
    
    public SyncAdapterType[] newArray(int size) {
            return new SyncAdapterType[size];
        }
    
}

