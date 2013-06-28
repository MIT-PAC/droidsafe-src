package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class StatusBarIcon implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.066 -0400", hash_original_field = "89BDC6D785F9592259F3FD88C8FC1DA7", hash_generated_field = "120E6CD15DC0115F43F5BF8A73434313")

    public String iconPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.066 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.066 -0400", hash_original_field = "51E274E8C6B26CCAA23AE1525DA7C129", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.067 -0400", hash_original_field = "B254AA152A9B02EFA446C15BC606802B", hash_generated_field = "747298D1A596D9E1616684B32AA6E8A2")

    public boolean visible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.067 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.067 -0400", hash_original_field = "1FABA34B02CC9E2377494D7D48243292", hash_generated_field = "9E10BE95BF1FC96775E534BFE1760451")

    public CharSequence contentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.067 -0400", hash_original_method = "4C7F8CA5669CDF6CA44AF1CD4C42CB3D", hash_generated_method = "DE4FEAB206FEF7894ACFEC79333CFF8C")
    public  StatusBarIcon(String iconPackage, int iconId, int iconLevel, int number,
            CharSequence contentDescription) {
        this.iconPackage = iconPackage;
        this.iconId = iconId;
        this.iconLevel = iconLevel;
        this.number = number;
        this.contentDescription = contentDescription;
        // ---------- Original Method ----------
        //this.iconPackage = iconPackage;
        //this.iconId = iconId;
        //this.iconLevel = iconLevel;
        //this.number = number;
        //this.contentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.068 -0400", hash_original_method = "D5CBB2AA2C175CD3828E11BBF7822BC5", hash_generated_method = "C52279C923E9D991201B6AA1E52D8C7B")
    public  StatusBarIcon(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.068 -0400", hash_original_method = "1EE859B2BAC1B0E091951C7E79A1C85B", hash_generated_method = "745BD01CF531C547CEA729FB3A88A7A5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1757174572 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1757174572 = "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                + " level=" + this.iconLevel + " visible=" + visible
                + " num=" + this.number + " )";
        varB4EAC82CA7396A68D541C85D26508E83_1757174572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757174572;
        // ---------- Original Method ----------
        //return "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                //+ " level=" + this.iconLevel + " visible=" + visible
                //+ " num=" + this.number + " )";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.068 -0400", hash_original_method = "D6D80221D74BF64CC6743E6FD4844F75", hash_generated_method = "AC0F654F2BAACF5793EDC90944234923")
    @Override
    public StatusBarIcon clone() {
        StatusBarIcon varB4EAC82CA7396A68D541C85D26508E83_120392287 = null; //Variable for return #1
        StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                this.number, this.contentDescription);
        that.visible = this.visible;
        varB4EAC82CA7396A68D541C85D26508E83_120392287 = that;
        varB4EAC82CA7396A68D541C85D26508E83_120392287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_120392287;
        // ---------- Original Method ----------
        //StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                //this.number, this.contentDescription);
        //that.visible = this.visible;
        //return that;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.069 -0400", hash_original_method = "80D94D7ADFF35638471EE5AD3E4769D4", hash_generated_method = "F4D3DAC8B468C888AF30D9AE4B6A9A7E")
    public void readFromParcel(Parcel in) {
        this.iconPackage = in.readString();
        this.iconId = in.readInt();
        this.iconLevel = in.readInt();
        this.visible = in.readInt() != 0;
        this.number = in.readInt();
        this.contentDescription = in.readCharSequence();
        // ---------- Original Method ----------
        //this.iconPackage = in.readString();
        //this.iconId = in.readInt();
        //this.iconLevel = in.readInt();
        //this.visible = in.readInt() != 0;
        //this.number = in.readInt();
        //this.contentDescription = in.readCharSequence();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.069 -0400", hash_original_method = "95CFF8C99AE4CB8951821DDD1BE9F05B", hash_generated_method = "A649C3E1FB4F4F6D0B412F55D840C2E3")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.iconPackage);
        out.writeInt(this.iconId);
        out.writeInt(this.iconLevel);
        out.writeInt(this.visible ? 1 : 0);
        out.writeInt(this.number);
        out.writeCharSequence(this.contentDescription);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeString(this.iconPackage);
        //out.writeInt(this.iconId);
        //out.writeInt(this.iconLevel);
        //out.writeInt(this.visible ? 1 : 0);
        //out.writeInt(this.number);
        //out.writeCharSequence(this.contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.070 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4931FC95B2E15659FF0E7D93B33679ED")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479453510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479453510;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.070 -0400", hash_original_field = "0817369B751A1EC947304389BAC8856A", hash_generated_field = "17A23CF6531EE973BFD4DDDD17F8E814")

    public static final Parcelable.Creator<StatusBarIcon> CREATOR
            = new Parcelable.Creator<StatusBarIcon>()
    {
        public StatusBarIcon createFromParcel(Parcel parcel)
        {
            return new StatusBarIcon(parcel);
        }

        public StatusBarIcon[] newArray(int size)
        {
            return new StatusBarIcon[size];
        }
    };
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

