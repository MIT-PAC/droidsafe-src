package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.360 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.360 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.360 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.374 -0400", hash_original_method = "D096C0D44FA6D8727E6F6C9E96EEA8B2", hash_generated_method = "58203309A1CB008008CCA5C9D79494EC")
    public  UserInfo(int id, String name, int flags) {
        this.id = id;
        this.name = name;
        this.flags = flags;
        // ---------- Original Method ----------
        //this.id = id;
        //this.name = name;
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.387 -0400", hash_original_method = "FFEDB19A4FE2EC199D413AD96B705A93", hash_generated_method = "EF7390497822A172718BFC5C0489B1A3")
    public  UserInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.388 -0400", hash_original_method = "51A70C7FC3794F4822F30406E486F30B", hash_generated_method = "C124218563C96B1CFCEC4164C772F706")
    public  UserInfo(UserInfo orig) {
        name = orig.name;
        id = orig.id;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //id = orig.id;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.390 -0400", hash_original_method = "D2DCB71066BFE658C1047A9ADF1A8FE4", hash_generated_method = "F6BA4C3FD87168476A3988CC8FF4FE69")
    private  UserInfo(Parcel source) {
        id = source.readInt();
        name = source.readString();
        flags = source.readInt();
        // ---------- Original Method ----------
        //id = source.readInt();
        //name = source.readString();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.390 -0400", hash_original_method = "C03AE380E4F338F1E70E5C1BDC1E37B9", hash_generated_method = "B85F57B5414B418CC34D8CA43475445E")
    public boolean isPrimary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211711172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211711172;
        // ---------- Original Method ----------
        //return (flags & FLAG_PRIMARY) == FLAG_PRIMARY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.412 -0400", hash_original_method = "AB675EF64043DB6994A1BFFAAF9F7F55", hash_generated_method = "027E1885BB280CC2B4423284B5AED8BA")
    public boolean isAdmin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757981016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757981016;
        // ---------- Original Method ----------
        //return (flags & FLAG_ADMIN) == FLAG_ADMIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.413 -0400", hash_original_method = "C17F5F8C940B592632E4868007F4D830", hash_generated_method = "ED36AECB55BA9D3F83010C2D4492CC30")
    public boolean isGuest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185238448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185238448;
        // ---------- Original Method ----------
        //return (flags & FLAG_GUEST) == FLAG_GUEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.415 -0400", hash_original_method = "0DF6D7695BB85FE21EB781D1BB3F7789", hash_generated_method = "FF35DDA134520E205410505D4EC4602E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1511468593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1511468593 = "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1511468593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1511468593;
        // ---------- Original Method ----------
        //return "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.443 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "39FDAE89F514DDC4215AE05BCB17C5A5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908344793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908344793;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.444 -0400", hash_original_method = "82A3C338305AFFE9E85DC8705D16ECA4", hash_generated_method = "68209779AE83DCEB4B756C2D7CF72084")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(flags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(name);
        //dest.writeInt(flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.444 -0400", hash_original_field = "D88A0459F2264FBEB883685D701D54B8", hash_generated_field = "01AA02176D8B0D4469EBD90B8AA3C5A2")

    public static final int FLAG_PRIMARY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.444 -0400", hash_original_field = "29283B35DB6D96DA2B778FC7B147ABEA", hash_generated_field = "7DDE313CC6217C188DA5EDD964551F50")

    public static final int FLAG_ADMIN   = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.445 -0400", hash_original_field = "DAFFC847C52B8C8C8DD311E9E5AE9532", hash_generated_field = "B5BAA9769DABC391F6635E59A724E0BC")

    public static final int FLAG_GUEST   = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.445 -0400", hash_original_field = "09A478919C59F371C3F438652185797C", hash_generated_field = "658D9FDDF53EA34B02D472AE07E66DBE")

    public static final Parcelable.Creator<UserInfo> CREATOR
            = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}

