package com.android.internal.statusbar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class StatusBarIcon implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "89BDC6D785F9592259F3FD88C8FC1DA7", hash_generated_field = "120E6CD15DC0115F43F5BF8A73434313")

    public String iconPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "9432811F07E2B832B9FB4017EFF8CCB5")

    public int iconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "51E274E8C6B26CCAA23AE1525DA7C129", hash_generated_field = "0B0F3FF5AB4CD552070A82872F28FB69")

    public int iconLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "B254AA152A9B02EFA446C15BC606802B", hash_generated_field = "747298D1A596D9E1616684B32AA6E8A2")

    public boolean visible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.497 -0400", hash_original_field = "1FABA34B02CC9E2377494D7D48243292", hash_generated_field = "9E10BE95BF1FC96775E534BFE1760451")

    public CharSequence contentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.499 -0400", hash_original_method = "4C7F8CA5669CDF6CA44AF1CD4C42CB3D", hash_generated_method = "DE4FEAB206FEF7894ACFEC79333CFF8C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.499 -0400", hash_original_method = "D5CBB2AA2C175CD3828E11BBF7822BC5", hash_generated_method = "281B2AC0CADBFFE503E005E287B2E9D3")
    public  StatusBarIcon(Parcel in) {
        addTaint(in.getTaint());
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.500 -0400", hash_original_method = "1EE859B2BAC1B0E091951C7E79A1C85B", hash_generated_method = "5C77FE9E4BD13DBC6EC72E862C10AD4C")
    @Override
    public String toString() {
String varB386A426A810794AFD31502A9A981A90_459044460 =         "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                + " level=" + this.iconLevel + " visible=" + visible
                + " num=" + this.number + " )";
        varB386A426A810794AFD31502A9A981A90_459044460.addTaint(taint);
        return varB386A426A810794AFD31502A9A981A90_459044460;
        // ---------- Original Method ----------
        //return "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                //+ " level=" + this.iconLevel + " visible=" + visible
                //+ " num=" + this.number + " )";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.500 -0400", hash_original_method = "D6D80221D74BF64CC6743E6FD4844F75", hash_generated_method = "4C2413FC67E13149A4993CDCACC6400B")
    @Override
    public StatusBarIcon clone() {
        StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                this.number, this.contentDescription);
        that.visible = this.visible;
StatusBarIcon varF9965B73D80F3C31BC4764828F08696D_1581672980 =         that;
        varF9965B73D80F3C31BC4764828F08696D_1581672980.addTaint(taint);
        return varF9965B73D80F3C31BC4764828F08696D_1581672980;
        // ---------- Original Method ----------
        //StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                //this.number, this.contentDescription);
        //that.visible = this.visible;
        //return that;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.502 -0400", hash_original_method = "80D94D7ADFF35638471EE5AD3E4769D4", hash_generated_method = "F4D3DAC8B468C888AF30D9AE4B6A9A7E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.502 -0400", hash_original_method = "95CFF8C99AE4CB8951821DDD1BE9F05B", hash_generated_method = "C030BA13D2B0189030C4949999941B2B")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(this.iconPackage);
        out.writeInt(this.iconId);
        out.writeInt(this.iconLevel);
        out.writeInt(this.visible ? 1 : 0);
        out.writeInt(this.number);
        out.writeCharSequence(this.contentDescription);
        // ---------- Original Method ----------
        //out.writeString(this.iconPackage);
        //out.writeInt(this.iconId);
        //out.writeInt(this.iconLevel);
        //out.writeInt(this.visible ? 1 : 0);
        //out.writeInt(this.number);
        //out.writeCharSequence(this.contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.503 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "742E0376BFCDC66D1C396B7F23BA4ADD")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_67552012 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135183022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135183022;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.503 -0400", hash_original_field = "0817369B751A1EC947304389BAC8856A", hash_generated_field = "17A23CF6531EE973BFD4DDDD17F8E814")

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

