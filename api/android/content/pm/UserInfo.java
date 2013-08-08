package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class UserInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.810 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.810 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.810 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.812 -0400", hash_original_method = "D096C0D44FA6D8727E6F6C9E96EEA8B2", hash_generated_method = "58203309A1CB008008CCA5C9D79494EC")
    public  UserInfo(int id, String name, int flags) {
        this.id = id;
        this.name = name;
        this.flags = flags;
        // ---------- Original Method ----------
        //this.id = id;
        //this.name = name;
        //this.flags = flags;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.813 -0400", hash_original_method = "FFEDB19A4FE2EC199D413AD96B705A93", hash_generated_method = "EF7390497822A172718BFC5C0489B1A3")
    public  UserInfo() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.814 -0400", hash_original_method = "51A70C7FC3794F4822F30406E486F30B", hash_generated_method = "C124218563C96B1CFCEC4164C772F706")
    public  UserInfo(UserInfo orig) {
        name = orig.name;
        id = orig.id;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //id = orig.id;
        //flags = orig.flags;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.815 -0400", hash_original_method = "D2DCB71066BFE658C1047A9ADF1A8FE4", hash_generated_method = "F6BA4C3FD87168476A3988CC8FF4FE69")
    private  UserInfo(Parcel source) {
        id = source.readInt();
        name = source.readString();
        flags = source.readInt();
        // ---------- Original Method ----------
        //id = source.readInt();
        //name = source.readString();
        //flags = source.readInt();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.815 -0400", hash_original_method = "C03AE380E4F338F1E70E5C1BDC1E37B9", hash_generated_method = "9E394F6645154A7104BBDBC23BFD1B1F")
    public boolean isPrimary() {
        boolean var5AB371C2655E4B58255C7DFA22ECEB89_1070138307 = ((flags & FLAG_PRIMARY) == FLAG_PRIMARY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805836559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805836559;
        // ---------- Original Method ----------
        //return (flags & FLAG_PRIMARY) == FLAG_PRIMARY;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.816 -0400", hash_original_method = "AB675EF64043DB6994A1BFFAAF9F7F55", hash_generated_method = "9DD601D05F1D374045E91A9602672F56")
    public boolean isAdmin() {
        boolean var50678694C8DE9B168422FE7304BEDBA0_1545531747 = ((flags & FLAG_ADMIN) == FLAG_ADMIN);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165934525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_165934525;
        // ---------- Original Method ----------
        //return (flags & FLAG_ADMIN) == FLAG_ADMIN;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.816 -0400", hash_original_method = "C17F5F8C940B592632E4868007F4D830", hash_generated_method = "3AA2A5B5FA11D0C9C3B6194C8EFD03E6")
    public boolean isGuest() {
        boolean varD2FA5948C2551B1CA03A0F9629252059_746477725 = ((flags & FLAG_GUEST) == FLAG_GUEST);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103611639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103611639;
        // ---------- Original Method ----------
        //return (flags & FLAG_GUEST) == FLAG_GUEST;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.817 -0400", hash_original_method = "0DF6D7695BB85FE21EB781D1BB3F7789", hash_generated_method = "38ABBF1F61A02ED27A16D78D71D42035")
    @Override
    public String toString() {
String varAE9EAD1C92DCAF55B077936E6231CB03_967962673 =         "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
        varAE9EAD1C92DCAF55B077936E6231CB03_967962673.addTaint(taint);
        return varAE9EAD1C92DCAF55B077936E6231CB03_967962673;
        // ---------- Original Method ----------
        //return "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.818 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "69B97B4089038C919D2B4D551A6D5D50")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1585995467 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82190239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82190239;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.819 -0400", hash_original_method = "82A3C338305AFFE9E85DC8705D16ECA4", hash_generated_method = "94EF2913E7071C1492E6C95C5AFE38D7")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(name);
        //dest.writeInt(flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.819 -0400", hash_original_field = "D88A0459F2264FBEB883685D701D54B8", hash_generated_field = "01AA02176D8B0D4469EBD90B8AA3C5A2")

    public static final int FLAG_PRIMARY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.819 -0400", hash_original_field = "29283B35DB6D96DA2B778FC7B147ABEA", hash_generated_field = "7DDE313CC6217C188DA5EDD964551F50")

    public static final int FLAG_ADMIN   = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.819 -0400", hash_original_field = "DAFFC847C52B8C8C8DD311E9E5AE9532", hash_generated_field = "B5BAA9769DABC391F6635E59A724E0BC")

    public static final int FLAG_GUEST   = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.820 -0400", hash_original_field = "09A478919C59F371C3F438652185797C", hash_generated_field = "658D9FDDF53EA34B02D472AE07E66DBE")

    public static final Parcelable.Creator<UserInfo> CREATOR
            = new Parcelable.Creator<UserInfo>() {
        @DSModeled(DSC.BAN)
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
        @DSModeled(DSC.BAN)
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
    // orphaned legacy method
    public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
    
    // orphaned legacy method
    public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    
}

