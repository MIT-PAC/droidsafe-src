package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Input implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.263 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "67BF1EF40348032263B5C952F69B65D0")

    public String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.264 -0400", hash_original_field = "0DB17AA1D80E20064FE42736B1C76DE8", hash_generated_field = "A8DF562F814A84BD8B13A7B79A300691")

    public String defaultText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.264 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "18C3710E837ABC3ED3609E8E9E147C46")

    public Bitmap icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.265 -0400", hash_original_field = "EF74CC6AE7569E44DE58A472EBA0B735", hash_generated_field = "559AEAAC15E5C4835D9479E681F79909")

    public int minLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.265 -0400", hash_original_field = "0957793E23A382F3649C3CEC380DB3A0", hash_generated_field = "9F8EB648BC0BC25A3F4696D10FA41BEE")

    public int maxLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.266 -0400", hash_original_field = "A4BA4F0B30716F95C1284D0AC6911172", hash_generated_field = "60136D1376A0D0806BAE1A241EDF215D")

    public boolean ucs2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.266 -0400", hash_original_field = "F59DCD306EC32930F1E78A1D82280B48", hash_generated_field = "95529D02420F333E71AD2716B27758C5")

    public boolean packed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.267 -0400", hash_original_field = "48E53685F06F1F31FDA1CBA710CD28E3", hash_generated_field = "9D804976FE6B1146D40D36456C1A46E9")

    public boolean digitOnly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.267 -0400", hash_original_field = "CBB11ED87DC8A95D81400C7F33C7C171", hash_generated_field = "2E48F9DD9C53D0B8088EE166780CCB5D")

    public boolean echo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.267 -0400", hash_original_field = "6BF80F7828EEF303F66AC6014B4B4930", hash_generated_field = "5C4B993DEA53816FAF6C9A570B469DEC")

    public boolean yesNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.268 -0400", hash_original_field = "95C3E9257A5998B6C3758B36FBDB8DD8", hash_generated_field = "B089F8BA7DD3EF733FF9A54CE2F03291")

    public boolean helpAvailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.268 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "F627176E1C35421D662BC9D4AD138316")

    public Duration duration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.283 -0400", hash_original_method = "3E111AA938495B7C4FDD9DF56E63C31E", hash_generated_method = "E9D74EB192B2133709AE56F6372F5254")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.300 -0400", hash_original_method = "C5B4E51AE4A5E722D5F00F3982A6F022", hash_generated_method = "D5B42A943E8383C6B6B370B4111F91AC")
    private  Input(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.301 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6D4344D8B7F3E5BF30F14BDF54AACB82")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_578195277 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780337044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_780337044;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.302 -0400", hash_original_method = "B53B93ABACC072A2D5F958A02DC16FEB", hash_generated_method = "62FE11E4E09A13FA877C65CE5133C729")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.303 -0400", hash_original_method = "B234C4FFCAD94565C16D3A43A2454835", hash_generated_method = "7EC097EFE7AF104EBEA282B3AB0EDC91")
     boolean setIcon(Bitmap Icon) {
        addTaint(Icon.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_580562060 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219682180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219682180;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.305 -0400", hash_original_field = "C55BBAE9BA652C2BEDEB4F6E28BCA10E", hash_generated_field = "449B79E7C316C34FDDF2E2D2B21F2438")

    public static final Parcelable.Creator<Input> CREATOR = new Parcelable.Creator<Input>() {
        public Input createFromParcel(Parcel in) {
            return new Input(in);
        }

        public Input[] newArray(int size) {
            return new Input[size];
        }
    };
    // orphaned legacy method
    public Input createFromParcel(Parcel in) {
            return new Input(in);
        }
    
    // orphaned legacy method
    public Input[] newArray(int size) {
            return new Input[size];
        }
    
}

