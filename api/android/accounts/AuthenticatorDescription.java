package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;

public class AuthenticatorDescription implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.464 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

    public String type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.465 -0400", hash_original_field = "462C96446499C39107F2C03833CC7769", hash_generated_field = "46DEAC82CA7C9A88AA196BE0871997FC")

    public int labelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.467 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.469 -0400", hash_original_field = "08D9A420D546C56B22C0605125965438", hash_generated_field = "36AE93911796C13B7EF9B68F77960E18")

    public int smallIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.471 -0400", hash_original_field = "EA639B62B2C562F387ECD9A9E05BBE27", hash_generated_field = "E5632098A2A7787935B71623831E7C75")

    public int accountPreferencesId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.473 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.475 -0400", hash_original_field = "18C2ADF61E095BE169BDDA448B4745A9", hash_generated_field = "A2B611DD6D4F5E46933CA32414A47564")

    public boolean customTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.482 -0400", hash_original_method = "10CE98088B9AD2510D39AB010FD4DE80", hash_generated_method = "3F8DC0EC4E78B4CB8DA1A2D2E512F4E3")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId, boolean customTokens) {
        if(type == null)        
        {
        IllegalArgumentException var8A5FB2A5739BF743D2E01BAE8C297DC0_15213436 = new IllegalArgumentException("type cannot be null");
        var8A5FB2A5739BF743D2E01BAE8C297DC0_15213436.addTaint(taint);
        throw var8A5FB2A5739BF743D2E01BAE8C297DC0_15213436;
        }
        if(packageName == null)        
        {
        IllegalArgumentException var57E2291AABFD28F187851D722802F626_1748989387 = new IllegalArgumentException("packageName cannot be null");
        var57E2291AABFD28F187851D722802F626_1748989387.addTaint(taint);
        throw var57E2291AABFD28F187851D722802F626_1748989387;
        }
        this.type = type;
        this.packageName = packageName;
        this.labelId = labelId;
        this.iconId = iconId;
        this.smallIconId = smallIconId;
        this.accountPreferencesId = prefId;
        this.customTokens = customTokens;
        // ---------- Original Method ----------
        //if (type == null) throw new IllegalArgumentException("type cannot be null");
        //if (packageName == null) throw new IllegalArgumentException("packageName cannot be null");
        //this.type = type;
        //this.packageName = packageName;
        //this.labelId = labelId;
        //this.iconId = iconId;
        //this.smallIconId = smallIconId;
        //this.accountPreferencesId = prefId;
        //this.customTokens = customTokens;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.486 -0400", hash_original_method = "11382004E2A497F30E307E2BE452746D", hash_generated_method = "A0E54BCAFADC69D039650CCC8275E8A3")
    public  AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId) {
        this(type, packageName, labelId, iconId, smallIconId, prefId, false);
        addTaint(prefId);
        addTaint(smallIconId);
        addTaint(iconId);
        addTaint(labelId);
        addTaint(packageName.getTaint());
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.494 -0400", hash_original_method = "4037EB3A36670641FC6DEBBB390D3E87", hash_generated_method = "5086636F6C4E6395A933FB3675CB53B6")
    private  AuthenticatorDescription(String type) {
        this.type = type;
        this.packageName = null;
        this.labelId = 0;
        this.iconId = 0;
        this.smallIconId = 0;
        this.accountPreferencesId = 0;
        this.customTokens = false;
        // ---------- Original Method ----------
        //this.type = type;
        //this.packageName = null;
        //this.labelId = 0;
        //this.iconId = 0;
        //this.smallIconId = 0;
        //this.accountPreferencesId = 0;
        //this.customTokens = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.505 -0400", hash_original_method = "C10BAC93BE842F654B6DBE8A81B18B55", hash_generated_method = "7D5F83D489164E5D801A0271260284B5")
    private  AuthenticatorDescription(Parcel source) {
        this.type = source.readString();
        this.packageName = source.readString();
        this.labelId = source.readInt();
        this.iconId = source.readInt();
        this.smallIconId = source.readInt();
        this.accountPreferencesId = source.readInt();
        this.customTokens = source.readByte() == 1;
        // ---------- Original Method ----------
        //this.type = source.readString();
        //this.packageName = source.readString();
        //this.labelId = source.readInt();
        //this.iconId = source.readInt();
        //this.smallIconId = source.readInt();
        //this.accountPreferencesId = source.readInt();
        //this.customTokens = source.readByte() == 1;
    }

    
    public static AuthenticatorDescription newKey(String type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        return new AuthenticatorDescription(type);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.511 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FA88F2CC13E364AFA457DBEBA33DE0B6")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1899977133 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088592873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088592873;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.514 -0400", hash_original_method = "6BF731200C51E86131E751F42FA1CCF7", hash_generated_method = "27967978E3BDD3C5DD48822817474262")
    public int hashCode() {
        int var1234BA14D219990AD59276F9D4AC0644_2052708021 = (type.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600335355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600335355;
        // ---------- Original Method ----------
        //return type.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.520 -0400", hash_original_method = "56302D274B0C35098461E26F41A371FE", hash_generated_method = "E021F23787790CECFF4CF5D975082734")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1651262088 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106455946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106455946;
        }
        if(!(o instanceof AuthenticatorDescription))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1420147991 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526751450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526751450;
        }
        final AuthenticatorDescription other = (AuthenticatorDescription) o;
        boolean var1BB01DECE8CDE2A5B4D38B04F82A9F11_1112694283 = (type.equals(other.type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852929921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852929921;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof AuthenticatorDescription)) return false;
        //final AuthenticatorDescription other = (AuthenticatorDescription) o;
        //return type.equals(other.type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.525 -0400", hash_original_method = "E530FC0646EA4443AB0B477A8261002A", hash_generated_method = "4558777D211D8BEDC56312E3D7CAEB97")
    public String toString() {
String var645F2244FF2137377AF0777536CDDC2B_1363612991 =         "AuthenticatorDescription {type=" + type + "}";
        var645F2244FF2137377AF0777536CDDC2B_1363612991.addTaint(taint);
        return var645F2244FF2137377AF0777536CDDC2B_1363612991;
        // ---------- Original Method ----------
        //return "AuthenticatorDescription {type=" + type + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.529 -0400", hash_original_method = "72F90E851087733BFC5D935FAA58D7A0", hash_generated_method = "4C536443DCD43D5EAD7329EA8AFA3A76")
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
        // ---------- Original Method ----------
        //dest.writeString(type);
        //dest.writeString(packageName);
        //dest.writeInt(labelId);
        //dest.writeInt(iconId);
        //dest.writeInt(smallIconId);
        //dest.writeInt(accountPreferencesId);
        //dest.writeByte((byte) (customTokens ? 1 : 0));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.532 -0400", hash_original_field = "12B3D1AC0AFD24255EEB56CB064F61F9", hash_generated_field = "EF0A236923C6371C92756878CC1C0C5A")

    public static final Creator<AuthenticatorDescription> CREATOR =
            new Creator<AuthenticatorDescription>() {
        
        public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }

        
        public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    };
    // orphaned legacy method
    public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }
    
    // orphaned legacy method
    public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    
}

