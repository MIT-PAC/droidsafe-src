package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.376 -0500", hash_original_field = "AC30E7151FF76A060B7B62C8AF7CA48C", hash_generated_field = "01AA02176D8B0D4469EBD90B8AA3C5A2")

    public static final int FLAG_PRIMARY = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.379 -0500", hash_original_field = "407BE1CF9F855EC56DA03439417E648D", hash_generated_field = "7DDE313CC6217C188DA5EDD964551F50")

    public static final int FLAG_ADMIN   = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.381 -0500", hash_original_field = "45CFE9A640E09519B1B7692F4AE2E183", hash_generated_field = "B5BAA9769DABC391F6635E59A724E0BC")

    public static final int FLAG_GUEST   = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.820 -0400", hash_original_field = "09A478919C59F371C3F438652185797C", hash_generated_field = "658D9FDDF53EA34B02D472AE07E66DBE")

    public static final Parcelable.Creator<UserInfo> CREATOR
            = new Parcelable.Creator<UserInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.411 -0500", hash_original_method = "33AD9B8ED865CFD9BB809454A11B02C8", hash_generated_method = "8D1C7C6B5FCFE546D9AA7412DBBE5914")
        
public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.413 -0500", hash_original_method = "670B57990F72488A07B6DB78DC8AE996", hash_generated_method = "E582A3A74809C8FA8C90944557DD4A49")
        
public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.383 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.385 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.387 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.389 -0500", hash_original_method = "D096C0D44FA6D8727E6F6C9E96EEA8B2", hash_generated_method = "BAA591FF16D1080CBFB4FAB53C24BA71")
    
public UserInfo(int id, String name, int flags) {
        this.id = id;
        this.name = name;
        this.flags = flags;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.398 -0500", hash_original_method = "FFEDB19A4FE2EC199D413AD96B705A93", hash_generated_method = "C5E9627FDFB0959113BC24F322946A9E")
    
public UserInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.401 -0500", hash_original_method = "51A70C7FC3794F4822F30406E486F30B", hash_generated_method = "1356779BC21D1C6BB3EC76C0210776AB")
    
public UserInfo(UserInfo orig) {
        name = orig.name;
        id = orig.id;
        flags = orig.flags;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.418 -0500", hash_original_method = "D2DCB71066BFE658C1047A9ADF1A8FE4", hash_generated_method = "599E2AFDC689BAC6EF8ECA43771A2613")
    
private UserInfo(Parcel source) {
        id = source.readInt();
        name = source.readString();
        flags = source.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.392 -0500", hash_original_method = "C03AE380E4F338F1E70E5C1BDC1E37B9", hash_generated_method = "D8E752725A82D370D55E64D675AA5AA2")
    
public boolean isPrimary() {
        return toTaintBoolean(flags + getTaintInt()); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.394 -0500", hash_original_method = "AB675EF64043DB6994A1BFFAAF9F7F55", hash_generated_method = "8968E374D36D976197B721875E7BF326")
    
public boolean isAdmin() {
        return toTaintBoolean(flags + getTaintInt()); 
        //return (flags & FLAG_ADMIN) == FLAG_ADMIN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.396 -0500", hash_original_method = "C17F5F8C940B592632E4868007F4D830", hash_generated_method = "52AE29ED93B6329CE7750137C8AA1A6D")
    
public boolean isGuest() {
        return toTaintBoolean(flags + getTaintInt()); 
        //return (flags & FLAG_GUEST) == FLAG_GUEST;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.404 -0500", hash_original_method = "0DF6D7695BB85FE21EB781D1BB3F7789", hash_generated_method = "E1F972FC30105A319609DD9C577EECC2")
    
@Override
    public String toString() {
        return "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.406 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:50.408 -0500", hash_original_method = "82A3C338305AFFE9E85DC8705D16ECA4", hash_generated_method = "B6AEB52E3B8936F92E3429B233558B1F")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(flags);
    }
    // orphaned legacy method
    public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
    
    // orphaned legacy method
    public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    
}

