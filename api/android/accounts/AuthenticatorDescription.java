package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;

public class AuthenticatorDescription implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.134 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.135 -0400", hash_original_field = "462C96446499C39107F2C03833CC7769", hash_generated_field = "46DEAC82CA7C9A88AA196BE0871997FC")

    public int labelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.137 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.137 -0400", hash_original_field = "08D9A420D546C56B22C0605125965438", hash_generated_field = "36AE93911796C13B7EF9B68F77960E18")

    public int smallIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.139 -0400", hash_original_field = "EA639B62B2C562F387ECD9A9E05BBE27", hash_generated_field = "E5632098A2A7787935B71623831E7C75")

    public int accountPreferencesId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.140 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.141 -0400", hash_original_field = "18C2ADF61E095BE169BDDA448B4745A9", hash_generated_field = "A2B611DD6D4F5E46933CA32414A47564")

    public boolean customTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.149 -0400", hash_original_method = "10CE98088B9AD2510D39AB010FD4DE80", hash_generated_method = "B7AB5632AA225EE58DA91310ED774D57")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId, boolean customTokens) {
    if(type == null)        
        {
        IllegalArgumentException var8A5FB2A5739BF743D2E01BAE8C297DC0_903629052 = new IllegalArgumentException("type cannot be null");
        var8A5FB2A5739BF743D2E01BAE8C297DC0_903629052.addTaint(taint);
        throw var8A5FB2A5739BF743D2E01BAE8C297DC0_903629052;
        }
    if(packageName == null)        
        {
        IllegalArgumentException var57E2291AABFD28F187851D722802F626_114187652 = new IllegalArgumentException("packageName cannot be null");
        var57E2291AABFD28F187851D722802F626_114187652.addTaint(taint);
        throw var57E2291AABFD28F187851D722802F626_114187652;
        }
        this.type = type;
        this.packageName = packageName;
        this.labelId = labelId;
        this.iconId = iconId;
        this.smallIconId = smallIconId;
        this.accountPreferencesId = prefId;
        this.customTokens = customTokens;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.152 -0400", hash_original_method = "11382004E2A497F30E307E2BE452746D", hash_generated_method = "A0E54BCAFADC69D039650CCC8275E8A3")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId) {
        this(type, packageName, labelId, iconId, smallIconId, prefId, false);
        addTaint(prefId);
        addTaint(smallIconId);
        addTaint(iconId);
        addTaint(labelId);
        addTaint(packageName.getTaint());
        addTaint(type.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.163 -0400", hash_original_method = "4037EB3A36670641FC6DEBBB390D3E87", hash_generated_method = "5086636F6C4E6395A933FB3675CB53B6")
    private  AuthenticatorDescription(String type) {
        this.type = type;
        this.packageName = null;
        this.labelId = 0;
        this.iconId = 0;
        this.smallIconId = 0;
        this.accountPreferencesId = 0;
        this.customTokens = false;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.171 -0400", hash_original_method = "C10BAC93BE842F654B6DBE8A81B18B55", hash_generated_method = "7D5F83D489164E5D801A0271260284B5")
    private  AuthenticatorDescription(Parcel source) {
        this.type = source.readString();
        this.packageName = source.readString();
        this.labelId = source.readInt();
        this.iconId = source.readInt();
        this.smallIconId = source.readInt();
        this.accountPreferencesId = source.readInt();
        this.customTokens = source.readByte() == 1;
        
        
        
        
        
        
        
        
    }

    
        public static AuthenticatorDescription newKey(String type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        return new AuthenticatorDescription(type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.176 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BB9373B5D6E9FFEA2D09B7D325C705F7")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2039973022 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937111111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937111111;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.180 -0400", hash_original_method = "6BF731200C51E86131E751F42FA1CCF7", hash_generated_method = "615B39B6099D82C8416FAB85401E29DE")
    public int hashCode() {
        int var1234BA14D219990AD59276F9D4AC0644_332145182 = (type.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346973562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346973562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.188 -0400", hash_original_method = "56302D274B0C35098461E26F41A371FE", hash_generated_method = "2B7D1B4D4D5065FFA93AA3C992C6451C")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1817964162 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558855431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558855431;
        }
    if(!(o instanceof AuthenticatorDescription))        
        {
        boolean var68934A3E9455FA72420237EB05902327_210930578 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840819097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840819097;
        }
        final AuthenticatorDescription other = (AuthenticatorDescription) o;
        boolean var1BB01DECE8CDE2A5B4D38B04F82A9F11_1093255957 = (type.equals(other.type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964892150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_964892150;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.192 -0400", hash_original_method = "E530FC0646EA4443AB0B477A8261002A", hash_generated_method = "384E88354544AD13E48F5916603F7E6B")
    public String toString() {
String var645F2244FF2137377AF0777536CDDC2B_854911660 =         "AuthenticatorDescription {type=" + type + "}";
        var645F2244FF2137377AF0777536CDDC2B_854911660.addTaint(taint);
        return var645F2244FF2137377AF0777536CDDC2B_854911660;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.195 -0400", hash_original_method = "72F90E851087733BFC5D935FAA58D7A0", hash_generated_method = "4C536443DCD43D5EAD7329EA8AFA3A76")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(type);
        dest.writeString(packageName);
        dest.writeInt(labelId);
        dest.writeInt(iconId);
        dest.writeInt(smallIconId);
        dest.writeInt(accountPreferencesId);
        dest.writeByte((byte) (customTokens ? 1 : 0));
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:32.197 -0400", hash_original_field = "12B3D1AC0AFD24255EEB56CB064F61F9", hash_generated_field = "EF0A236923C6371C92756878CC1C0C5A")

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

