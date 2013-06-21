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
    public String iconPackage;
    public int iconId;
    public int iconLevel;
    public boolean visible = true;
    public int number;
    public CharSequence contentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.510 -0400", hash_original_method = "4C7F8CA5669CDF6CA44AF1CD4C42CB3D", hash_generated_method = "1C59DDDBF6065700F2DA5847B65C31AD")
    @DSModeled(DSC.SAFE)
    public StatusBarIcon(String iconPackage, int iconId, int iconLevel, int number,
            CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(iconPackage);
        dsTaint.addTaint(iconLevel);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(number);
        // ---------- Original Method ----------
        //this.iconPackage = iconPackage;
        //this.iconId = iconId;
        //this.iconLevel = iconLevel;
        //this.number = number;
        //this.contentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.510 -0400", hash_original_method = "D5CBB2AA2C175CD3828E11BBF7822BC5", hash_generated_method = "7759A6136E7A62013BFB3232E56F957E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusBarIcon(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.511 -0400", hash_original_method = "1EE859B2BAC1B0E091951C7E79A1C85B", hash_generated_method = "C84073B0436117855F09B4ECBB5BD81D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD11920BFF8E6101EEB1946347E328D08_322876725 = ("StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                + " level=" + this.iconLevel + " visible=" + visible
                + " num=" + this.number + " )");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StatusBarIcon(pkg=" + this.iconPackage + " id=0x" + Integer.toHexString(this.iconId)
                //+ " level=" + this.iconLevel + " visible=" + visible
                //+ " num=" + this.number + " )";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.511 -0400", hash_original_method = "D6D80221D74BF64CC6743E6FD4844F75", hash_generated_method = "8EEA322A0B18246573D64F6E6AC1040E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StatusBarIcon clone() {
        StatusBarIcon that;
        that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                this.number, this.contentDescription);
        that.visible = this.visible;
        return (StatusBarIcon)dsTaint.getTaint();
        // ---------- Original Method ----------
        //StatusBarIcon that = new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel,
                //this.number, this.contentDescription);
        //that.visible = this.visible;
        //return that;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.513 -0400", hash_original_method = "80D94D7ADFF35638471EE5AD3E4769D4", hash_generated_method = "ECA1052A8505E60A2BE829F68F3B7BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.514 -0400", hash_original_method = "95CFF8C99AE4CB8951821DDD1BE9F05B", hash_generated_method = "6F1FB6DD7716F11E981820B3E66008ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.514 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<StatusBarIcon> CREATOR = new Parcelable.Creator<StatusBarIcon>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.514 -0400", hash_original_method = "0CBF415FD85440100C0520ADBF6731D5", hash_generated_method = "543ADAAD49C1FFD4B60D7F41BB0E8FB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarIcon createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            StatusBarIcon var79D80FD182FF3DB014A3033B41925E35_1233114072 = (new StatusBarIcon(parcel));
            return (StatusBarIcon)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarIcon(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.514 -0400", hash_original_method = "63388FF3AD007FD82913ED9B945B2578", hash_generated_method = "1820D132BA690C2526C82D4CCBB16D53")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StatusBarIcon[] newArray(int size) {
            dsTaint.addTaint(size);
            StatusBarIcon[] var9ACA7622585650F5E95A19DFBA982558_948189979 = (new StatusBarIcon[size]);
            return (StatusBarIcon[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StatusBarIcon[size];
        }

        
}; //Transformed anonymous class
}

