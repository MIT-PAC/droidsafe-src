package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PermissionGroupInfo extends PackageItemInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.367 -0400", hash_original_field = "C5F42F5EC446394F1B5E3897D28E68B6", hash_generated_field = "157E7C3FA4773BF05F9A4ED13A8D2703")

    public static final Creator<PermissionGroupInfo> CREATOR =
            new Creator<PermissionGroupInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.026 -0500", hash_original_method = "187B40B88C67C0925A9FFCFB53E91019", hash_generated_method = "36A00DFDF064E40FE9D3483B7EC370D0")
        
public PermissionGroupInfo createFromParcel(Parcel source) {
            return new PermissionGroupInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.028 -0500", hash_original_method = "E8CF26CD838EA459740518D5D22D5674", hash_generated_method = "C3B79F9773533C9073B34EB2096F2B9F")
        
public PermissionGroupInfo[] newArray(int size) {
            return new PermissionGroupInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.007 -0500", hash_original_field = "1C23F3ABB5154D4340D3FAF2DBF4B754", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.009 -0500", hash_original_field = "3F29E24378A26499E7DD21245533F93B", hash_generated_field = "DC8641D3F3115BD1A7EE01A008EB7DE8")

    public CharSequence nonLocalizedDescription;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.011 -0500", hash_original_method = "82344B3D2D2745586AE3E2C39F67E56D", hash_generated_method = "AF08E9B69596662C63F486D2E119E1D6")
    
public PermissionGroupInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.013 -0500", hash_original_method = "86BDB0F775205D222755746395606069", hash_generated_method = "96A368CFB9B9AD1FDD5022E295113430")
    
public PermissionGroupInfo(PermissionGroupInfo orig) {
        super(orig);
        descriptionRes = orig.descriptionRes;
        nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.033 -0500", hash_original_method = "251C6C67446670431867B6BD14427B23", hash_generated_method = "7F3C1C643A42B722800AF39689BCB9F3")
    
private PermissionGroupInfo(Parcel source) {
        super(source);
        descriptionRes = source.readInt();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.016 -0500", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "AE1FD32E979E85F92B8FF10149DD076E")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.019 -0500", hash_original_method = "712313A7FB39E8068296CCC509012BB3", hash_generated_method = "F11ADAEA8F676C6A52E6B69310AC7745")
    
public String toString() {
        return "PermissionGroupInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.021 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.023 -0500", hash_original_method = "48DC2E300D4B0399A780C6669617C26B", hash_generated_method = "685C8DED2406CC9ABC1827EEAA63E83B")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(descriptionRes);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }
    // orphaned legacy method
    public PermissionGroupInfo createFromParcel(Parcel source) {
            return new PermissionGroupInfo(source);
        }
    
    // orphaned legacy method
    public PermissionGroupInfo[] newArray(int size) {
            return new PermissionGroupInfo[size];
        }
    
}

