package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PermissionInfo extends PackageItemInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.851 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "ED45639033EEDA1CA9D8CA3A2607E8AD")

    public String group;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.851 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.851 -0400", hash_original_field = "F132344C9D3F23D988965BDF2FE9E96E", hash_generated_field = "DC8641D3F3115BD1A7EE01A008EB7DE8")

    public CharSequence nonLocalizedDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.851 -0400", hash_original_field = "372B755E9445B05D3AE456958C953027", hash_generated_field = "D4FB0787FB8F46D8D7588BD5727D8594")

    public int protectionLevel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.852 -0400", hash_original_method = "4363F86D103EC845B9204173BA7C251E", hash_generated_method = "919AEC380A87E0C9D5318078288ABD70")
    public  PermissionInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.853 -0400", hash_original_method = "64C8DADAA6D1A83E089E968A1FA0F105", hash_generated_method = "7726730A12071B0A37544522AC99470D")
    public  PermissionInfo(PermissionInfo orig) {
        super(orig);
        group = orig.group;
        descriptionRes = orig.descriptionRes;
        protectionLevel = orig.protectionLevel;
        nonLocalizedDescription = orig.nonLocalizedDescription;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.854 -0400", hash_original_method = "B4E7B82E4C24C37709BA1B06DE1A7578", hash_generated_method = "A55762989ADF30EDD993404FD5F01AFB")
    private  PermissionInfo(Parcel source) {
        super(source);
        group = source.readString();
        descriptionRes = source.readInt();
        protectionLevel = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.855 -0400", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "210857189FB6AA004B67C75BA810284D")
    public CharSequence loadDescription(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1864487450 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1857109975 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_168171907 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1864487450 = nonLocalizedDescription;
        } 
        {
            CharSequence label = pm.getText(packageName, descriptionRes, null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1857109975 = label;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_168171907 = null;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1000744586; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1000744586 = varB4EAC82CA7396A68D541C85D26508E83_1864487450;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1000744586 = varB4EAC82CA7396A68D541C85D26508E83_1857109975;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1000744586 = varB4EAC82CA7396A68D541C85D26508E83_168171907;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1000744586.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1000744586;
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.856 -0400", hash_original_method = "07D30C0CB33D6CDA9C3B1D51B29A13B5", hash_generated_method = "591ED1FAADEF3CB8734CFEA4AA19BF22")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1432577218 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1432577218 = "PermissionInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1432577218.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1432577218;
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.856 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F723429292A37FCD660AE9CC8867B3E8")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297775601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297775601;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_method = "1534C59E913BA20826F4978690F40C01", hash_generated_method = "3265E727E501AC8C43821CCF7C6FE9B0")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(group);
        dest.writeInt(descriptionRes);
        dest.writeInt(protectionLevel);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_field = "CB1E21534E7BB59BC8F88181DE500B19", hash_generated_field = "C9A532AE354590800FA04A66BAD3E386")

    public static final int PROTECTION_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_field = "15E03608780CF5EA2E180F414D2B94E7", hash_generated_field = "44C6D2F12CE31512311008318586CE82")

    public static final int PROTECTION_DANGEROUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_field = "B8C3E0D18B6377F2458A185F4F6FBF88", hash_generated_field = "CA0B94CB5AF4ED813B3488D87617AA61")

    public static final int PROTECTION_SIGNATURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_field = "7F55A9338571B2C08C45413FB4535D63", hash_generated_field = "A803B7417F8FF56A5DE269218A5BC21C")

    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.857 -0400", hash_original_field = "B05E804BB27C0BF12F18E1AFCCF1178A", hash_generated_field = "7D6B5C0E99186EC2167C4DBDCB5AD2EE")

    public static final Creator<PermissionInfo> CREATOR =
        new Creator<PermissionInfo>() {
        public PermissionInfo createFromParcel(Parcel source) {
            return new PermissionInfo(source);
        }
        public PermissionInfo[] newArray(int size) {
            return new PermissionInfo[size];
        }
    };
    
    public PermissionInfo createFromParcel(Parcel source) {
            return new PermissionInfo(source);
        }
    
    
    public PermissionInfo[] newArray(int size) {
            return new PermissionInfo[size];
        }
    
}

