package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.385 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.385 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "67BF1EF40348032263B5C952F69B65D0")

    public String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.385 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "18C3710E837ABC3ED3609E8E9E147C46")

    public Bitmap icon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.386 -0400", hash_original_method = "05C10E3AB09D0E755B8F84F42D5EB677", hash_generated_method = "D7AD461FF1064148AEFFE7841F4F4F48")
    public  Item(int id, String text) {
        this.id = id;
        this.text = text;
        this.icon = null;
        // ---------- Original Method ----------
        //this.id = id;
        //this.text = text;
        //this.icon = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.387 -0400", hash_original_method = "FE8E70F741D1760772151F9A3106E203", hash_generated_method = "EE7405A7AE020A10FA0217F6054326A3")
    public  Item(Parcel in) {
        id = in.readInt();
        text = in.readString();
        icon = in.readParcelable(null);
        // ---------- Original Method ----------
        //id = in.readInt();
        //text = in.readString();
        //icon = in.readParcelable(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.387 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1C540A9DE926CDB92DF95BEFC4C40D3C")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_412425373 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219377350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219377350;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.388 -0400", hash_original_method = "9F06F16F0F60B4944A559AD32B259BAF", hash_generated_method = "F897AC96269CFD1BB89B1E94BF55FECC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(id);
        dest.writeString(text);
        dest.writeParcelable(icon, flags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(text);
        //dest.writeParcelable(icon, flags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.388 -0400", hash_original_method = "D77DEAB1CC7B5FDE4A537F56E3011951", hash_generated_method = "F977564EA83E8D44C8D7185AA38175F5")
    public String toString() {
String var79CC641C1148018540A26F7ADC424893_1948426721 =         text;
        var79CC641C1148018540A26F7ADC424893_1948426721.addTaint(taint);
        return var79CC641C1148018540A26F7ADC424893_1948426721;
        // ---------- Original Method ----------
        //return text;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.389 -0400", hash_original_field = "222EFCE28F204A0D4C7EF9490F5602EB", hash_generated_field = "D69DEFD9515459FCA84CC8CDF18F4564")

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    // orphaned legacy method
    public Item createFromParcel(Parcel in) {
            return new Item(in);
        }
    
    // orphaned legacy method
    public Item[] newArray(int size) {
            return new Item[size];
        }
    
}

