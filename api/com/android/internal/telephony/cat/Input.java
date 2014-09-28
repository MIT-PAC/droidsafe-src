package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Input implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.376 -0400", hash_original_field = "C55BBAE9BA652C2BEDEB4F6E28BCA10E", hash_generated_field = "449B79E7C316C34FDDF2E2D2B21F2438")

    public static final Parcelable.Creator<Input> CREATOR = new Parcelable.Creator<Input>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.395 -0500", hash_original_method = "A3060A4F3D5664F92DE2DC8B971AB968", hash_generated_method = "5E43F3E1FFE6B7ACCFD3135E6F83943B")
        
public Input createFromParcel(Parcel in) {
            return new Input(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.397 -0500", hash_original_method = "B3E4B71B9877E87E02262381214C0C55", hash_generated_method = "AE01488B1AABB7935E7F3229671E868D")
        
public Input[] newArray(int size) {
            return new Input[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.355 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "67BF1EF40348032263B5C952F69B65D0")

    public String text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.357 -0500", hash_original_field = "AD7E58A82EEDD02E2FB67C4EA69C0D37", hash_generated_field = "A8DF562F814A84BD8B13A7B79A300691")

    public String defaultText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.360 -0500", hash_original_field = "0C64FDDDE16C63294C62EE068DB291C9", hash_generated_field = "18C3710E837ABC3ED3609E8E9E147C46")

    public Bitmap icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.362 -0500", hash_original_field = "54B61E7BA82EDAA45F98208022D8682C", hash_generated_field = "559AEAAC15E5C4835D9479E681F79909")

    public int minLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.364 -0500", hash_original_field = "F86765D8132FDA293DFA51AE9486778D", hash_generated_field = "9F8EB648BC0BC25A3F4696D10FA41BEE")

    public int maxLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.367 -0500", hash_original_field = "6208CB3AFDC0D988EB4E973D956FC7FE", hash_generated_field = "60136D1376A0D0806BAE1A241EDF215D")

    public boolean ucs2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.369 -0500", hash_original_field = "9A33E1285A9FC44C7B610BBE7F0B3939", hash_generated_field = "95529D02420F333E71AD2716B27758C5")

    public boolean packed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.371 -0500", hash_original_field = "BE7F39004779D8E41D0A0E3316948386", hash_generated_field = "9D804976FE6B1146D40D36456C1A46E9")

    public boolean digitOnly;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.374 -0500", hash_original_field = "A587E40F34E75E876A2C1E1FAFD435CB", hash_generated_field = "2E48F9DD9C53D0B8088EE166780CCB5D")

    public boolean echo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.376 -0500", hash_original_field = "3A80EEEAC83D8DC8D53544B7E152DFAF", hash_generated_field = "5C4B993DEA53816FAF6C9A570B469DEC")

    public boolean yesNo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.379 -0500", hash_original_field = "E131DAF35CC59A8CEE38290A7F7F7AD8", hash_generated_field = "B089F8BA7DD3EF733FF9A54CE2F03291")

    public boolean helpAvailable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.381 -0500", hash_original_field = "A6070A7BA087BD42A534C9AD7E3C0404", hash_generated_field = "F627176E1C35421D662BC9D4AD138316")

    public Duration duration;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.384 -0500", hash_original_method = "3E111AA938495B7C4FDD9DF56E63C31E", hash_generated_method = "3E111AA938495B7C4FDD9DF56E63C31E")
    
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.387 -0500", hash_original_method = "C5B4E51AE4A5E722D5F00F3982A6F022", hash_generated_method = "1F0E029113220D7EAC6362860E2C3DE0")
    
private Input(Parcel in) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.389 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.392 -0500", hash_original_method = "B53B93ABACC072A2D5F958A02DC16FEB", hash_generated_method = "DAF036CF71375F716CB667CACF625CBA")
    
public void writeToParcel(Parcel dest, int flags) {
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
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.403 -0500", hash_original_method = "B234C4FFCAD94565C16D3A43A2454835", hash_generated_method = "B234C4FFCAD94565C16D3A43A2454835")
    
boolean setIcon(Bitmap Icon) { return true; }
    // orphaned legacy method
    public Input createFromParcel(Parcel in) {
            return new Input(in);
        }
    
    // orphaned legacy method
    public Input[] newArray(int size) {
            return new Input[size];
        }
    
}

