package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Input implements Parcelable {
    public String text;
    public String defaultText;
    public Bitmap icon;
    public int minLen;
    public int maxLen;
    public boolean ucs2;
    public boolean packed;
    public boolean digitOnly;
    public boolean echo;
    public boolean yesNo;
    public boolean helpAvailable;
    public Duration duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.931 -0400", hash_original_method = "3E111AA938495B7C4FDD9DF56E63C31E", hash_generated_method = "E9D74EB192B2133709AE56F6372F5254")
    @DSModeled(DSC.SAFE)
     Input() {
        text = "";
        defaultText = null;
        icon = null;
        minLen = 0;
        maxLen = 1;
        ucs2 = false;
        packed = false;
        digitOnly = false;
        echo = false;
        yesNo = false;
        helpAvailable = false;
        duration = null;
        // ---------- Original Method ----------
        //text = "";
        //defaultText = null;
        //icon = null;
        //minLen = 0;
        //maxLen = 1;
        //ucs2 = false;
        //packed = false;
        //digitOnly = false;
        //echo = false;
        //yesNo = false;
        //helpAvailable = false;
        //duration = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.932 -0400", hash_original_method = "C5B4E51AE4A5E722D5F00F3982A6F022", hash_generated_method = "7F8FB5DACB0969E28E1A6EA73886A534")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Input(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        text = in.readString();
        defaultText = in.readString();
        icon = in.readParcelable(null);
        minLen = in.readInt();
        maxLen = in.readInt();
        ucs2 = in.readInt() == 1 ? true : false;
        packed = in.readInt() == 1 ? true : false;
        digitOnly = in.readInt() == 1 ? true : false;
        echo = in.readInt() == 1 ? true : false;
        yesNo = in.readInt() == 1 ? true : false;
        helpAvailable = in.readInt() == 1 ? true : false;
        duration = in.readParcelable(null);
        // ---------- Original Method ----------
        //text = in.readString();
        //defaultText = in.readString();
        //icon = in.readParcelable(null);
        //minLen = in.readInt();
        //maxLen = in.readInt();
        //ucs2 = in.readInt() == 1 ? true : false;
        //packed = in.readInt() == 1 ? true : false;
        //digitOnly = in.readInt() == 1 ? true : false;
        //echo = in.readInt() == 1 ? true : false;
        //yesNo = in.readInt() == 1 ? true : false;
        //helpAvailable = in.readInt() == 1 ? true : false;
        //duration = in.readParcelable(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.932 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.932 -0400", hash_original_method = "B53B93ABACC072A2D5F958A02DC16FEB", hash_generated_method = "C55DB8AE4042C984C8DEE787BB48D33F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(text);
        dest.writeString(defaultText);
        dest.writeParcelable(icon, 0);
        dest.writeInt(minLen);
        dest.writeInt(maxLen);
        dest.writeInt(ucs2 ? 1 : 0);
        dest.writeInt(packed ? 1 : 0);
        dest.writeInt(digitOnly ? 1 : 0);
        dest.writeInt(echo ? 1 : 0);
        dest.writeInt(yesNo ? 1 : 0);
        dest.writeInt(helpAvailable ? 1 : 0);
        dest.writeParcelable(duration, 0);
        // ---------- Original Method ----------
        //dest.writeString(text);
        //dest.writeString(defaultText);
        //dest.writeParcelable(icon, 0);
        //dest.writeInt(minLen);
        //dest.writeInt(maxLen);
        //dest.writeInt(ucs2 ? 1 : 0);
        //dest.writeInt(packed ? 1 : 0);
        //dest.writeInt(digitOnly ? 1 : 0);
        //dest.writeInt(echo ? 1 : 0);
        //dest.writeInt(yesNo ? 1 : 0);
        //dest.writeInt(helpAvailable ? 1 : 0);
        //dest.writeParcelable(duration, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.932 -0400", hash_original_method = "B234C4FFCAD94565C16D3A43A2454835", hash_generated_method = "493F46633BC32CC869D184D811600905")
    @DSModeled(DSC.SAFE)
     boolean setIcon(Bitmap Icon) {
        dsTaint.addTaint(Icon.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    public static final Parcelable.Creator<Input> CREATOR = new Parcelable.Creator<Input>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.933 -0400", hash_original_method = "A3060A4F3D5664F92DE2DC8B971AB968", hash_generated_method = "7A0E224824960FE4B6C8B4A195C06DD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Input createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Input var8E9D94C2FCB027E089352DAFD35261D8_728940673 = (new Input(in));
            return (Input)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Input(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.933 -0400", hash_original_method = "B3E4B71B9877E87E02262381214C0C55", hash_generated_method = "BA0837B4B43DBD13AED1167F5D3849EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Input[] newArray(int size) {
            dsTaint.addTaint(size);
            Input[] var40AFD33A2A5C19C7573A296A4CD74971_566991618 = (new Input[size]);
            return (Input[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Input[size];
        }

        
}; //Transformed anonymous class
}

