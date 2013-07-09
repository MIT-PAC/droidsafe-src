package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.258 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.258 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.258 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.259 -0400", hash_original_method = "D096C0D44FA6D8727E6F6C9E96EEA8B2", hash_generated_method = "58203309A1CB008008CCA5C9D79494EC")
    public  UserInfo(int id, String name, int flags) {
        this.id = id;
        this.name = name;
        this.flags = flags;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.260 -0400", hash_original_method = "FFEDB19A4FE2EC199D413AD96B705A93", hash_generated_method = "EF7390497822A172718BFC5C0489B1A3")
    public  UserInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.261 -0400", hash_original_method = "51A70C7FC3794F4822F30406E486F30B", hash_generated_method = "C124218563C96B1CFCEC4164C772F706")
    public  UserInfo(UserInfo orig) {
        name = orig.name;
        id = orig.id;
        flags = orig.flags;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.262 -0400", hash_original_method = "D2DCB71066BFE658C1047A9ADF1A8FE4", hash_generated_method = "F6BA4C3FD87168476A3988CC8FF4FE69")
    private  UserInfo(Parcel source) {
        id = source.readInt();
        name = source.readString();
        flags = source.readInt();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.262 -0400", hash_original_method = "C03AE380E4F338F1E70E5C1BDC1E37B9", hash_generated_method = "4B5F799E3BC0526639C5B085DE17C0F9")
    public boolean isPrimary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401219087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401219087;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.263 -0400", hash_original_method = "AB675EF64043DB6994A1BFFAAF9F7F55", hash_generated_method = "E1BE0AA2795922966AD13645FAB7A56E")
    public boolean isAdmin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_680738408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_680738408;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.263 -0400", hash_original_method = "C17F5F8C940B592632E4868007F4D830", hash_generated_method = "30D0B803C3755D47893EEAE1B2657910")
    public boolean isGuest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174187527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174187527;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.264 -0400", hash_original_method = "0DF6D7695BB85FE21EB781D1BB3F7789", hash_generated_method = "4C51837EEE5F747C7CFAD9A47077C47A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1448758 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1448758 = "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1448758.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1448758;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6EEC1B6E9AEEF9AF6D73D65546F22C15")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179632629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179632629;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_method = "82A3C338305AFFE9E85DC8705D16ECA4", hash_generated_method = "68209779AE83DCEB4B756C2D7CF72084")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(flags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_field = "D88A0459F2264FBEB883685D701D54B8", hash_generated_field = "01AA02176D8B0D4469EBD90B8AA3C5A2")

    public static final int FLAG_PRIMARY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_field = "29283B35DB6D96DA2B778FC7B147ABEA", hash_generated_field = "7DDE313CC6217C188DA5EDD964551F50")

    public static final int FLAG_ADMIN   = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_field = "DAFFC847C52B8C8C8DD311E9E5AE9532", hash_generated_field = "B5BAA9769DABC391F6635E59A724E0BC")

    public static final int FLAG_GUEST   = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.265 -0400", hash_original_field = "09A478919C59F371C3F438652185797C", hash_generated_field = "658D9FDDF53EA34B02D472AE07E66DBE")

    public static final Parcelable.Creator<UserInfo> CREATOR
            = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
    
    public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
    
    
    public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    
}

