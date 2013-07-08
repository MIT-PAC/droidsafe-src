package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class AuthenticatorDescription implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.492 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.492 -0400", hash_original_field = "462C96446499C39107F2C03833CC7769", hash_generated_field = "46DEAC82CA7C9A88AA196BE0871997FC")

    public int labelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.492 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.493 -0400", hash_original_field = "08D9A420D546C56B22C0605125965438", hash_generated_field = "36AE93911796C13B7EF9B68F77960E18")

    public int smallIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.493 -0400", hash_original_field = "EA639B62B2C562F387ECD9A9E05BBE27", hash_generated_field = "E5632098A2A7787935B71623831E7C75")

    public int accountPreferencesId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.493 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.494 -0400", hash_original_field = "18C2ADF61E095BE169BDDA448B4745A9", hash_generated_field = "A2B611DD6D4F5E46933CA32414A47564")

    public boolean customTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.496 -0400", hash_original_method = "10CE98088B9AD2510D39AB010FD4DE80", hash_generated_method = "234E674672DAFBFEBFBB3D8024D6805F")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId, boolean customTokens) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("type cannot be null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("packageName cannot be null");
        this.type = type;
        this.packageName = packageName;
        this.labelId = labelId;
        this.iconId = iconId;
        this.smallIconId = smallIconId;
        this.accountPreferencesId = prefId;
        this.customTokens = customTokens;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.497 -0400", hash_original_method = "11382004E2A497F30E307E2BE452746D", hash_generated_method = "B4357C7410CA8ED8F35B684664B8D3FF")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId) {
        this(type, packageName, labelId, iconId, smallIconId, prefId, false);
        addTaint(type.getTaint());
        addTaint(packageName.getTaint());
        addTaint(labelId);
        addTaint(iconId);
        addTaint(smallIconId);
        addTaint(prefId);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.499 -0400", hash_original_method = "4037EB3A36670641FC6DEBBB390D3E87", hash_generated_method = "5086636F6C4E6395A933FB3675CB53B6")
    private  AuthenticatorDescription(String type) {
        this.type = type;
        this.packageName = null;
        this.labelId = 0;
        this.iconId = 0;
        this.smallIconId = 0;
        this.accountPreferencesId = 0;
        this.customTokens = false;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.501 -0400", hash_original_method = "C10BAC93BE842F654B6DBE8A81B18B55", hash_generated_method = "7D5F83D489164E5D801A0271260284B5")
    private  AuthenticatorDescription(Parcel source) {
        this.type = source.readString();
        this.packageName = source.readString();
        this.labelId = source.readInt();
        this.iconId = source.readInt();
        this.smallIconId = source.readInt();
        this.accountPreferencesId = source.readInt();
        this.customTokens = source.readByte() == 1;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static AuthenticatorDescription newKey(String type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        return new AuthenticatorDescription(type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.502 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DB3CFD9A272162FFCAACB79532332D94")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149206173 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149206173;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.503 -0400", hash_original_method = "6BF731200C51E86131E751F42FA1CCF7", hash_generated_method = "DA40101C0FA9A883E5F4EE45E55F8D86")
    public int hashCode() {
        int var5445C9C24EEBE23FF02D6BECCF921AED_329932945 = (type.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690747653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690747653;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.504 -0400", hash_original_method = "56302D274B0C35098461E26F41A371FE", hash_generated_method = "76A47C7529D65FF4DFA493D7CAD3106B")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_143963407 = (o == this);
        } 
        final AuthenticatorDescription other = (AuthenticatorDescription) o;
        boolean varE9C3F01EF71A53EF70D5F9E4EF6F3FE9_1386226709 = (type.equals(other.type));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854211709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854211709;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.506 -0400", hash_original_method = "E530FC0646EA4443AB0B477A8261002A", hash_generated_method = "C6B5E4BC9E9C40DAAAFC57CCCA7BD9C0")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1734167954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1734167954 = "AuthenticatorDescription {type=" + type + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1734167954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1734167954;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.508 -0400", hash_original_method = "72F90E851087733BFC5D935FAA58D7A0", hash_generated_method = "4051D34850B60282DB772F1FB1293821")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(packageName);
        dest.writeInt(labelId);
        dest.writeInt(iconId);
        dest.writeInt(smallIconId);
        dest.writeInt(accountPreferencesId);
        dest.writeByte((byte) (customTokens ? 1 : 0));
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.510 -0400", hash_original_field = "12B3D1AC0AFD24255EEB56CB064F61F9", hash_generated_field = "EF0A236923C6371C92756878CC1C0C5A")

    public static final Creator<AuthenticatorDescription> CREATOR =
            new Creator<AuthenticatorDescription>() {
        
        public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }

        
        public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    };
    
    public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }
    
    
    public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    
}

