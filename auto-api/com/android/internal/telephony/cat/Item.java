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

public class Item implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.179 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.179 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "67BF1EF40348032263B5C952F69B65D0")

    public String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.179 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "18C3710E837ABC3ED3609E8E9E147C46")

    public Bitmap icon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.179 -0400", hash_original_method = "05C10E3AB09D0E755B8F84F42D5EB677", hash_generated_method = "D7AD461FF1064148AEFFE7841F4F4F48")
    public  Item(int id, String text) {
        this.id = id;
        this.text = text;
        this.icon = null;
        // ---------- Original Method ----------
        //this.id = id;
        //this.text = text;
        //this.icon = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.180 -0400", hash_original_method = "FE8E70F741D1760772151F9A3106E203", hash_generated_method = "EE7405A7AE020A10FA0217F6054326A3")
    public  Item(Parcel in) {
        id = in.readInt();
        text = in.readString();
        icon = in.readParcelable(null);
        // ---------- Original Method ----------
        //id = in.readInt();
        //text = in.readString();
        //icon = in.readParcelable(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.180 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8DEEFF9655EA75313929F2CDDF7A93F9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503723617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503723617;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.180 -0400", hash_original_method = "9F06F16F0F60B4944A559AD32B259BAF", hash_generated_method = "6629086FB4583B8DE492C6A6CBBE9B7E")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(text);
        dest.writeParcelable(icon, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(text);
        //dest.writeParcelable(icon, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.195 -0400", hash_original_method = "D77DEAB1CC7B5FDE4A537F56E3011951", hash_generated_method = "B8CB1071B6A4DF36699F77B775A15421")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1165573954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1165573954 = text;
        varB4EAC82CA7396A68D541C85D26508E83_1165573954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165573954;
        // ---------- Original Method ----------
        //return text;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.195 -0400", hash_original_field = "222EFCE28F204A0D4C7EF9490F5602EB", hash_generated_field = "D69DEFD9515459FCA84CC8CDF18F4564")

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}

