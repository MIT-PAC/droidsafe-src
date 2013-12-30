package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class StatusBarIcon implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.172 -0400", hash_original_field = "0817369B751A1EC947304389BAC8856A", hash_generated_field = "17A23CF6531EE973BFD4DDDD17F8E814")

    public static final Parcelable.Creator<StatusBarIcon> CREATOR
            = new Parcelable.Creator<StatusBarIcon>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.745 -0500", hash_original_method = "0CBF415FD85440100C0520ADBF6731D5", hash_generated_method = "10D2BAB95A8F878736012C4B66C57E50")
        
public StatusBarIcon createFromParcel(Parcel parcel)
        {
            return new StatusBarIcon(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.747 -0500", hash_original_method = "63388FF3AD007FD82913ED9B945B2578", hash_generated_method = "755621C66A3134DBF8DAC64C08CD78B6")
        
public StatusBarIcon[] newArray(int size)
        {
            return new StatusBarIcon[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.704 -0500", hash_original_field = "5CE2473DDC459A9A84DAD5732E145195", hash_generated_field = "120E6CD15DC0115F43F5BF8A73434313")

    public String iconPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.708 -0500", hash_original_field = "5FB1FE173593F2C1352A3849ECD329FE", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.712 -0500", hash_original_field = "F9B43650694732C77D734E3DEABF76D6", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.714 -0500", hash_original_field = "52048B89F4F77F63C7B183482880203B", hash_generated_field = "747298D1A596D9E1616684B32AA6E8A2")

    public boolean visible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.716 -0500", hash_original_field = "75B782B0DE9A9BBA8740638F419D560B", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.718 -0500", hash_original_field = "F62A9C417146ADA11DD2901F7E2ACC9B", hash_generated_field = "9E10BE95BF1FC96775E534BFE1760451")

    public CharSequence contentDescription;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.721 -0500", hash_original_method = "4C7F8CA5669CDF6CA44AF1CD4C42CB3D", hash_generated_method = "AF90E94253866DD7B865C9F4D08F7D73")
    
public StatusBarIcon(String iconPackage, int iconId, int iconLevel, int number,
            CharSequence contentDescription) {
        this.iconPackage = iconPackage;
        this.iconId = iconId;
        this.iconLevel = iconLevel;
        this.number = number;
        this.contentDescription = contentDescription;
    }

    /**
     * Unflatten the StatusBarIcon from a parcel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.729 -0500", hash_original_method = "D5CBB2AA2C175CD3828E11BBF7822BC5", hash_generated_method = "50BBC8CC3F5D54E0B12EABAC32803668")
    
public StatusBarIcon(Parcel in) {
        readFromParcel(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.723 -0500", hash_original_method = "1EE859B2BAC1B0E091951C7E79A1C85B", hash_generated_method = "DF2FC622328504DBBA9D931966BCB57A")
    
@Override
    public String toString() {
        return "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                + " level=" + this.iconLevel + " visible=" + visible
                + " num=" + this.number + " )";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.726 -0500", hash_original_method = "D6D80221D74BF64CC6743E6FD4844F75", hash_generated_method = "2D1C1AB63A238B229AEEFB3303C485A1")
    
@Override
    public StatusBarIcon clone() {
        StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                this.number, this.contentDescription);
        that.visible = this.visible;
        return that;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.731 -0500", hash_original_method = "80D94D7ADFF35638471EE5AD3E4769D4", hash_generated_method = "7970EB5512A7AF74DC1A36FD006D2769")
    
public void readFromParcel(Parcel in) {
        this.iconPackage = in.readString();
        this.iconId = in.readInt();
        this.iconLevel = in.readInt();
        this.visible = in.readInt() != 0;
        this.number = in.readInt();
        this.contentDescription = in.readCharSequence();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.739 -0500", hash_original_method = "95CFF8C99AE4CB8951821DDD1BE9F05B", hash_generated_method = "C39752AC7F20C830EACE70C412CCC5E7")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.iconPackage);
        out.writeInt(this.iconId);
        out.writeInt(this.iconLevel);
        out.writeInt(this.visible ? 1 : 0);
        out.writeInt(this.number);
        out.writeCharSequence(this.contentDescription);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:54.741 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public StatusBarIcon createFromParcel(Parcel parcel)
        {
            return new StatusBarIcon(parcel);
        }
    
    // orphaned legacy method
    public StatusBarIcon[] newArray(int size)
        {
            return new StatusBarIcon[size];
        }
    
}

