package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class AuthenticatorDescription implements Parcelable {

    /**
     * A factory method for creating an AuthenticatorDescription that can be used as a key
     * to identify the authenticator by its type.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.104 -0500", hash_original_method = "9A2D216346AB85B0A920CEE255CF28A0", hash_generated_method = "27D4F7B871BA01C7D691AD14677A22C6")
    
public static AuthenticatorDescription newKey(String type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        return new AuthenticatorDescription(type);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.532 -0400", hash_original_field = "12B3D1AC0AFD24255EEB56CB064F61F9", hash_generated_field = "EF0A236923C6371C92756878CC1C0C5A")

    public static final Creator<AuthenticatorDescription> CREATOR =
            new Creator<AuthenticatorDescription>() {
        /** @inheritDoc */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.124 -0500", hash_original_method = "C8C9153CF7DF6BC9F2BC5B781B8F131A", hash_generated_method = "131C5B279DB3464463A5ACA54AA40A18")
        
public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }

        /** @inheritDoc */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.127 -0500", hash_original_method = "24C5D5BB4B7F00B9B4CD3B0710269609", hash_generated_method = "8FE6DAD26BE3C2EC31FB3996ED65BB66")
        
public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.080 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "7BA709B14E744AD5C81755E81EB9D05D")

     public String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.082 -0500", hash_original_field = "C68300CE648DE1635FA80C8B5C0A0CDB", hash_generated_field = "46DEAC82CA7C9A88AA196BE0871997FC")

     public int labelId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.085 -0500", hash_original_field = "5FB1FE173593F2C1352A3849ECD329FE", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

     public int iconId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.087 -0500", hash_original_field = "3C1B65DFC4A9B5BF23416CA39FA25773", hash_generated_field = "36AE93911796C13B7EF9B68F77960E18")

     public int smallIconId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.089 -0500", hash_original_field = "48D855A7D84E3F44A3953C1EF48E2609", hash_generated_field = "E5632098A2A7787935B71623831E7C75")

     public int accountPreferencesId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.092 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

     public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.095 -0500", hash_original_field = "D950F4094629E620DCA209790F317773", hash_generated_field = "A2B611DD6D4F5E46933CA32414A47564")

     public boolean customTokens;

    /** A constructor for a full AuthenticatorDescription */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.098 -0500", hash_original_method = "10CE98088B9AD2510D39AB010FD4DE80", hash_generated_method = "5677A14CE64E3DD057BF2FB4C46C202D")
    
public AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId, boolean customTokens) {
        if (type == null) throw new IllegalArgumentException("type cannot be null");
        if (packageName == null) throw new IllegalArgumentException("packageName cannot be null");
        this.type = type;
        this.packageName = packageName;
        this.labelId = labelId;
        this.iconId = iconId;
        this.smallIconId = smallIconId;
        this.accountPreferencesId = prefId;
        this.customTokens = customTokens;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.101 -0500", hash_original_method = "11382004E2A497F30E307E2BE452746D", hash_generated_method = "056DBEC1061432F448CEB6E2016EC1E1")
    
public AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId) {
        this(type, packageName, labelId, iconId, smallIconId, prefId, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.106 -0500", hash_original_method = "4037EB3A36670641FC6DEBBB390D3E87", hash_generated_method = "3081C37713196AB5405E7A26E393BD99")
    
private AuthenticatorDescription(String type) {
        this.type = type;
        this.packageName = null;
        this.labelId = 0;
        this.iconId = 0;
        this.smallIconId = 0;
        this.accountPreferencesId = 0;
        this.customTokens = false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.109 -0500", hash_original_method = "C10BAC93BE842F654B6DBE8A81B18B55", hash_generated_method = "744BDC08A914DAF88929C7C04F8AB64A")
    
private AuthenticatorDescription(Parcel source) {
        this.type = source.readString();
        this.packageName = source.readString();
        this.labelId = source.readInt();
        this.iconId = source.readInt();
        this.smallIconId = source.readInt();
        this.accountPreferencesId = source.readInt();
        this.customTokens = source.readByte() == 1;
    }

    /** @inheritDoc */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.111 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Returns the hashcode of the type only. */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.113 -0500", hash_original_method = "6BF731200C51E86131E751F42FA1CCF7", hash_generated_method = "8DD507783991967039D39B7AC5CFF07E")
    
public int hashCode() {
        return type.hashCode();
    }

    /** Compares the type only, suitable for key comparisons. */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.116 -0500", hash_original_method = "56302D274B0C35098461E26F41A371FE", hash_generated_method = "8636066B283EEC770CB81C9AD3F3AA54")
    
public boolean equals(Object o) {
        return toTaintBoolean(getTaintInt() + o.getTaintInt()); 
        /*
        if (o == this) return true;
        if (!(o instanceof AuthenticatorDescription)) return false;
        final AuthenticatorDescription other = (AuthenticatorDescription) o;
        return type.equals(other.type);
        */
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.118 -0500", hash_original_method = "E530FC0646EA4443AB0B477A8261002A", hash_generated_method = "8AF5CC66264B7D020ED61FFB05C5E3BB")
    
public String toString() {
        return "AuthenticatorDescription {type=" + type + "}";
    }

    /** @inheritDoc */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:49.121 -0500", hash_original_method = "72F90E851087733BFC5D935FAA58D7A0", hash_generated_method = "6194097B8BCEEA90E52AC78F22B09D6F")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(packageName);
        dest.writeInt(labelId);
        dest.writeInt(iconId);
        dest.writeInt(smallIconId);
        dest.writeInt(accountPreferencesId);
        dest.writeByte((byte) (customTokens ? 1 : 0));
    }
    // orphaned legacy method
    public AuthenticatorDescription createFromParcel(Parcel source) {
            return new AuthenticatorDescription(source);
        }
    
    // orphaned legacy method
    public AuthenticatorDescription[] newArray(int size) {
            return new AuthenticatorDescription[size];
        }
    
}

