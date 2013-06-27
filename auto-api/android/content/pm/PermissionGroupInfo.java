package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PermissionGroupInfo extends PackageItemInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:04.993 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:04.993 -0400", hash_original_field = "F132344C9D3F23D988965BDF2FE9E96E", hash_generated_field = "DC8641D3F3115BD1A7EE01A008EB7DE8")

    public CharSequence nonLocalizedDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:04.993 -0400", hash_original_method = "82344B3D2D2745586AE3E2C39F67E56D", hash_generated_method = "C344FD7EBA0ACA0405579BE9BC8FB4E5")
    public  PermissionGroupInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.004 -0400", hash_original_method = "86BDB0F775205D222755746395606069", hash_generated_method = "9E42539179CB72B7DF3C7D104B792B22")
    public  PermissionGroupInfo(PermissionGroupInfo orig) {
        super(orig);
        descriptionRes = orig.descriptionRes;
        nonLocalizedDescription = orig.nonLocalizedDescription;
        // ---------- Original Method ----------
        //descriptionRes = orig.descriptionRes;
        //nonLocalizedDescription = orig.nonLocalizedDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.006 -0400", hash_original_method = "251C6C67446670431867B6BD14427B23", hash_generated_method = "C80CEF62BF9EA33C58DF216289241944")
    private  PermissionGroupInfo(Parcel source) {
        super(source);
        descriptionRes = source.readInt();
        nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //descriptionRes = source.readInt();
        //nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.032 -0400", hash_original_method = "EA6AC5CC522A2884BAFD1D1CC4525D81", hash_generated_method = "B86209A5A69B2C573444D5F6E6178081")
    public CharSequence loadDescription(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_945319006 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1032911444 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1820198164 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_945319006 = nonLocalizedDescription;
        } //End block
        {
            CharSequence label;
            label = pm.getText(packageName, descriptionRes, null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1032911444 = label;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1820198164 = null;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1236756842; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1236756842 = varB4EAC82CA7396A68D541C85D26508E83_945319006;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1236756842 = varB4EAC82CA7396A68D541C85D26508E83_1032911444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1236756842 = varB4EAC82CA7396A68D541C85D26508E83_1820198164;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1236756842.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1236756842;
        // ---------- Original Method ----------
        //if (nonLocalizedDescription != null) {
            //return nonLocalizedDescription;
        //}
        //if (descriptionRes != 0) {
            //CharSequence label = pm.getText(packageName, descriptionRes, null);
            //if (label != null) {
                //return label;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.033 -0400", hash_original_method = "712313A7FB39E8068296CCC509012BB3", hash_generated_method = "A8306B29A40217482692437DEA805F02")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_967926864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_967926864 = "PermissionGroupInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_967926864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967926864;
        // ---------- Original Method ----------
        //return "PermissionGroupInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.047 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9181051C24CC895CBBF693C8356F262D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070379228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070379228;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.049 -0400", hash_original_method = "48DC2E300D4B0399A780C6669617C26B", hash_generated_method = "78475FB280E9FDF2A4BBFEC200A2A74F")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(descriptionRes);
        TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeInt(descriptionRes);
        //TextUtils.writeToParcel(nonLocalizedDescription, dest, parcelableFlags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:05.049 -0400", hash_original_field = "C5F42F5EC446394F1B5E3897D28E68B6", hash_generated_field = "157E7C3FA4773BF05F9A4ED13A8D2703")

    public static final Creator<PermissionGroupInfo> CREATOR =
            new Creator<PermissionGroupInfo>() {
        public PermissionGroupInfo createFromParcel(Parcel source) {
            return new PermissionGroupInfo(source);
        }
        public PermissionGroupInfo[] newArray(int size) {
            return new PermissionGroupInfo[size];
        }
    };
}

