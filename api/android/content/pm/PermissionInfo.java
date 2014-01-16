package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PermissionInfo extends PackageItemInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.527 -0500", hash_original_field = "1B99EF1A6A81EDDB5DE5DA703DEA1FB0", hash_generated_field = "C9A532AE354590800FA04A66BAD3E386")

    public static final int PROTECTION_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.529 -0500", hash_original_field = "CC1F0B22F25F6D7BD142BD2BD1A87989", hash_generated_field = "44C6D2F12CE31512311008318586CE82")

    public static final int PROTECTION_DANGEROUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.531 -0500", hash_original_field = "73220C35B7F637C53089BD26953D2F23", hash_generated_field = "CA0B94CB5AF4ED813B3488D87617AA61")

    public static final int PROTECTION_SIGNATURE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.534 -0500", hash_original_field = "BDA4568588A5DAC189CCF223C36F2B92", hash_generated_field = "A803B7417F8FF56A5DE269218A5BC21C")

    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.398 -0400", hash_original_field = "B05E804BB27C0BF12F18E1AFCCF1178A", hash_generated_field = "7D6B5C0E99186EC2167C4DBDCB5AD2EE")

    public static final Creator<PermissionInfo> CREATOR =
        new Creator<PermissionInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.560 -0500", hash_original_method = "CE272AA0F393607C7BD51E233995C9B9", hash_generated_method = "2C119AF1DA4D21CAC1AE2F73BF2D7D26")
        
public PermissionInfo createFromParcel(Parcel source) {
            return new PermissionInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.562 -0500", hash_original_method = "F50F017196AA55C30F890E5CC032DF70", hash_generated_method = "C0AA225A23D9E9ED9F87AA2F3D0BB60D")
        
public PermissionInfo[] newArray(int size) {
            return new PermissionInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.536 -0500", hash_original_field = "58DFF24D9C4CFDAEE359799F513155D9", hash_generated_field = "ED45639033EEDA1CA9D8CA3A2607E8AD")

    public String group;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.538 -0500", hash_original_field = "1C23F3ABB5154D4340D3FAF2DBF4B754", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.540 -0500", hash_original_field = "3F29E24378A26499E7DD21245533F93B", hash_generated_field = "DC8641D3F3115BD1A7EE01A008EB7DE8")

    public CharSequence nonLocalizedDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.542 -0500", hash_original_field = "6E9A85F917F979F1F46EBDAC13A74EF5", hash_generated_field = "D4FB0787FB8F46D8D7588BD5727D8594")

    public int protectionLevel;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.545 -0500", hash_original_method = "4363F86D103EC845B9204173BA7C251E", hash_generated_method = "3E257F6676A741715A11CAD661144D62")
    
public PermissionInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.547 -0500", hash_original_method = "64C8DADAA6D1A83E089E968A1FA0F105", hash_generated_method = "9F8737751BA70C7DC4F9DD624A15740A")
    
public PermissionInfo(PermissionInfo orig) {
        super(orig);
        group = orig.group;
        descriptionRes = orig.descriptionRes;
        protectionLevel = orig.protectionLevel;
        nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.567 -0500", hash_original_method = "B4E7B82E4C24C37709BA1B06DE1A7578", hash_generated_method = "C956AA4DF31C793C5377C958B4F91AF6")
    
private PermissionInfo(Parcel source) {
        super(source);
        group = source.readString();
        descriptionRes = source.readInt();
        protectionLevel = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    /**
     * Retrieve the textual description of this permission.  This
     * will call back on the given PackageManager to load the description from
     * the application.
     *
     * @param pm A PackageManager from which the label can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     *
     * @return Returns a CharSequence containing the permission's description.
     * If there is no description, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.550 -0500", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "AE1FD32E979E85F92B8FF10149DD076E")
    
public CharSequence loadDescription(PackageManager pm) {
        if (nonLocalizedDescription != null) {
            return nonLocalizedDescription;
        }
        if (descriptionRes != 0) {
            CharSequence label = pm.getText(packageName, descriptionRes, null);
            if (label != null) {
                return label;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.553 -0500", hash_original_method = "07D30C0CB33D6CDA9C3B1D51B29A13B5", hash_generated_method = "07AAAE41736F4EFAC30084818EA3CE93")
    
public String toString() {
        return "PermissionInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.555 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.557 -0500", hash_original_method = "1534C59E913BA20826F4978690F40C01", hash_generated_method = "F0E56868BCF239570C207E9FD2444D7D")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(group);
        dest.writeInt(descriptionRes);
        dest.writeInt(protectionLevel);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }
    // orphaned legacy method
    public PermissionInfo createFromParcel(Parcel source) {
            return new PermissionInfo(source);
        }
    
    // orphaned legacy method
    public PermissionInfo[] newArray(int size) {
            return new PermissionInfo[size];
        }
    
}

