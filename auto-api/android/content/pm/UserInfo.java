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
    public int id;
    public String name;
    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.982 -0400", hash_original_method = "D096C0D44FA6D8727E6F6C9E96EEA8B2", hash_generated_method = "0EDAF3C6E9D599CE6B057E550839744C")
    @DSModeled(DSC.SAFE)
    public UserInfo(int id, String name, int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //this.id = id;
        //this.name = name;
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.982 -0400", hash_original_method = "FFEDB19A4FE2EC199D413AD96B705A93", hash_generated_method = "EF7390497822A172718BFC5C0489B1A3")
    @DSModeled(DSC.SAFE)
    public UserInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.982 -0400", hash_original_method = "51A70C7FC3794F4822F30406E486F30B", hash_generated_method = "40FB5D61AA5CE0F1556C397326C61240")
    @DSModeled(DSC.SAFE)
    public UserInfo(UserInfo orig) {
        dsTaint.addTaint(orig.dsTaint);
        name = orig.name;
        id = orig.id;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //id = orig.id;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.983 -0400", hash_original_method = "D2DCB71066BFE658C1047A9ADF1A8FE4", hash_generated_method = "79BCBCBCCAA10ABBF06F329A120AEEDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private UserInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        id = source.readInt();
        name = source.readString();
        flags = source.readInt();
        // ---------- Original Method ----------
        //id = source.readInt();
        //name = source.readString();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.983 -0400", hash_original_method = "C03AE380E4F338F1E70E5C1BDC1E37B9", hash_generated_method = "58F3FF9D781405663A64533F5381BFFC")
    @DSModeled(DSC.SAFE)
    public boolean isPrimary() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (flags & FLAG_PRIMARY) == FLAG_PRIMARY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.983 -0400", hash_original_method = "AB675EF64043DB6994A1BFFAAF9F7F55", hash_generated_method = "4A6F38CE67E6D28F5CCA7DD175DBA882")
    @DSModeled(DSC.SAFE)
    public boolean isAdmin() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (flags & FLAG_ADMIN) == FLAG_ADMIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.984 -0400", hash_original_method = "C17F5F8C940B592632E4868007F4D830", hash_generated_method = "4C94558D30408C496863A1AAFA052CE8")
    @DSModeled(DSC.SAFE)
    public boolean isGuest() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (flags & FLAG_GUEST) == FLAG_GUEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.984 -0400", hash_original_method = "0DF6D7695BB85FE21EB781D1BB3F7789", hash_generated_method = "F2C1330236B86E14147B695F4B4D7D83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varA38A549FF21CF6A7619405AFCBE77D4D_1967160633 = ("UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "UserInfo{" + id + ":" + name + ":" + Integer.toHexString(flags) + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.991 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.991 -0400", hash_original_method = "82A3C338305AFFE9E85DC8705D16ECA4", hash_generated_method = "54FD5D2A424CF938CF3662CC5249006F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(name);
        //dest.writeInt(flags);
    }

    
    public static final int FLAG_PRIMARY = 0x00000001;
    public static final int FLAG_ADMIN   = 0x00000002;
    public static final int FLAG_GUEST   = 0x00000004;
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.991 -0400", hash_original_method = "33AD9B8ED865CFD9BB809454A11B02C8", hash_generated_method = "89D055042C38FBCBD01D3C342239DB79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UserInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            UserInfo varB1C9D1758FF654761716D0F95CAFD6BF_1879284997 = (new UserInfo(source));
            return (UserInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UserInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.992 -0400", hash_original_method = "670B57990F72488A07B6DB78DC8AE996", hash_generated_method = "6CF84C10E29BEDB5EAD21AE414E07E02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UserInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            UserInfo[] varAFB14D4A0C692149E1E5B6A79CA52E3A_411172718 = (new UserInfo[size]);
            return (UserInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new UserInfo[size];
        }

        
}; //Transformed anonymous class
}

