package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.389 -0400", hash_original_field = "222EFCE28F204A0D4C7EF9490F5602EB", hash_generated_field = "D69DEFD9515459FCA84CC8CDF18F4564")

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.290 -0500", hash_original_method = "337005C89E3476E5BF20BF6FC939368A", hash_generated_method = "9C6FED5FE9E897D6717B821DCC47FF55")
        
public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.293 -0500", hash_original_method = "EE6E2DCA075007A66C19A292386EC3A9", hash_generated_method = "7D3E15F2EBC13C35C85A071036D5502B")
        
public Item[] newArray(int size) {
            return new Item[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.272 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.274 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "67BF1EF40348032263B5C952F69B65D0")

    public String text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.277 -0500", hash_original_field = "0C64FDDDE16C63294C62EE068DB291C9", hash_generated_field = "18C3710E837ABC3ED3609E8E9E147C46")

    public Bitmap icon;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.280 -0500", hash_original_method = "05C10E3AB09D0E755B8F84F42D5EB677", hash_generated_method = "F14D5EF5DEB18B40A4D210589C3B5F54")
    
public Item(int id, String text) {
        this.id = id;
        this.text = text;
        this.icon = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.283 -0500", hash_original_method = "FE8E70F741D1760772151F9A3106E203", hash_generated_method = "3CDBFA2CCAFD9CA3A75235CD3D67FD46")
    
public Item(Parcel in) {
        id = in.readInt();
        text = in.readString();
        icon = in.readParcelable(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.285 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.287 -0500", hash_original_method = "9F06F16F0F60B4944A559AD32B259BAF", hash_generated_method = "EC9E64B4C9825D0A89B1890A1618171D")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(text);
        dest.writeParcelable(icon, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.298 -0500", hash_original_method = "D77DEAB1CC7B5FDE4A537F56E3011951", hash_generated_method = "0C4E5E4CA8D40010711A1BEC5DC08A53")
    
public String toString() {
        return text;
    }
    // orphaned legacy method
    public Item createFromParcel(Parcel in) {
            return new Item(in);
        }
    
    // orphaned legacy method
    public Item[] newArray(int size) {
            return new Item[size];
        }
    
}

