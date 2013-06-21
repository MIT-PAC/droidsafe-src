package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class AuthenticatorDescription implements Parcelable {
    public String type;
    public int labelId;
    public int iconId;
    public int smallIconId;
    public int accountPreferencesId;
    public String packageName;
    public boolean customTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.539 -0400", hash_original_method = "10CE98088B9AD2510D39AB010FD4DE80", hash_generated_method = "65F37C0E6BB0A808EC6F49FA9DD33790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId, boolean customTokens) {
        dsTaint.addTaint(prefId);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(smallIconId);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(type);
        dsTaint.addTaint(labelId);
        dsTaint.addTaint(customTokens);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("type cannot be null");
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("packageName cannot be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.540 -0400", hash_original_method = "11382004E2A497F30E307E2BE452746D", hash_generated_method = "3A36FEF6C5AA7F67CE69C6A5F90BC420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorDescription(String type, String packageName, int labelId, int iconId,
            int smallIconId, int prefId) {
        this(type, packageName, labelId, iconId, smallIconId, prefId, false);
        dsTaint.addTaint(prefId);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(smallIconId);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(type);
        dsTaint.addTaint(labelId);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.541 -0400", hash_original_method = "4037EB3A36670641FC6DEBBB390D3E87", hash_generated_method = "A10D8A15144AF5E4AD400BC88FD06AF8")
    @DSModeled(DSC.SAFE)
    private AuthenticatorDescription(String type) {
        dsTaint.addTaint(type);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.543 -0400", hash_original_method = "C10BAC93BE842F654B6DBE8A81B18B55", hash_generated_method = "40FD9D5A1EFF9CA1CF72BC106D948B13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AuthenticatorDescription(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.544 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.545 -0400", hash_original_method = "6BF731200C51E86131E751F42FA1CCF7", hash_generated_method = "DC6391B01FBEA4A423268031C692D891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var5445C9C24EEBE23FF02D6BECCF921AED_515724071 = (type.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return type.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.547 -0400", hash_original_method = "56302D274B0C35098461E26F41A371FE", hash_generated_method = "BE869934F8C73D34396766032845639F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_193166954 = (o == this);
        } //End collapsed parenthetic
        AuthenticatorDescription other;
        other = (AuthenticatorDescription) o;
        boolean varE9C3F01EF71A53EF70D5F9E4EF6F3FE9_642579247 = (type.equals(other.type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof AuthenticatorDescription)) return false;
        //final AuthenticatorDescription other = (AuthenticatorDescription) o;
        //return type.equals(other.type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.548 -0400", hash_original_method = "E530FC0646EA4443AB0B477A8261002A", hash_generated_method = "38AF65C1C19C9F9D58A2FCFB1B28F21D")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "AuthenticatorDescription {type=" + type + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.558 -0400", hash_original_method = "72F90E851087733BFC5D935FAA58D7A0", hash_generated_method = "1BCF1620D80FE032B0473BA925D04601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    public static final Creator<AuthenticatorDescription> CREATOR = new Creator<AuthenticatorDescription>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.560 -0400", hash_original_method = "C8C9153CF7DF6BC9F2BC5B781B8F131A", hash_generated_method = "F42E98845434C1D2696B6E81419A9EBC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AuthenticatorDescription createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            AuthenticatorDescription varFFEBA8B693D3B5BB1F2D8A01A87D2A50_1965921369 = (new AuthenticatorDescription(source));
            return (AuthenticatorDescription)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AuthenticatorDescription(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.561 -0400", hash_original_method = "24C5D5BB4B7F00B9B4CD3B0710269609", hash_generated_method = "70AD5896EA50C2FCFFCC2A2642FF6DD1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AuthenticatorDescription[] newArray(int size) {
            dsTaint.addTaint(size);
            AuthenticatorDescription[] var5D81B838FCA8B68CA004A18F6C9B335D_908944904 = (new AuthenticatorDescription[size]);
            return (AuthenticatorDescription[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AuthenticatorDescription[size];
        }

        
}; //Transformed anonymous class
}

