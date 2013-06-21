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
    public int id;
    public String text;
    public Bitmap icon;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.935 -0400", hash_original_method = "05C10E3AB09D0E755B8F84F42D5EB677", hash_generated_method = "904AB9CDB206DE9A32552DF2C163BA32")
    @DSModeled(DSC.SAFE)
    public Item(int id, String text) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(text);
        this.icon = null;
        // ---------- Original Method ----------
        //this.id = id;
        //this.text = text;
        //this.icon = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.935 -0400", hash_original_method = "FE8E70F741D1760772151F9A3106E203", hash_generated_method = "A8113A45CBD96022B787C29FA1983ADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Item(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        id = in.readInt();
        text = in.readString();
        icon = in.readParcelable(null);
        // ---------- Original Method ----------
        //id = in.readInt();
        //text = in.readString();
        //icon = in.readParcelable(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.935 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.936 -0400", hash_original_method = "9F06F16F0F60B4944A559AD32B259BAF", hash_generated_method = "345D9CD8FCC19293DF45EF3F757BAB6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(id);
        dest.writeString(text);
        dest.writeParcelable(icon, flags);
        // ---------- Original Method ----------
        //dest.writeInt(id);
        //dest.writeString(text);
        //dest.writeParcelable(icon, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.936 -0400", hash_original_method = "D77DEAB1CC7B5FDE4A537F56E3011951", hash_generated_method = "1D31096301EB7FC3113A3DBB07A2FC59")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return text;
    }

    
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.936 -0400", hash_original_method = "337005C89E3476E5BF20BF6FC939368A", hash_generated_method = "FD76F2770EA93B3BE5AA0C1A17B2660B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Item createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Item var9C66A1231F532989C228B54F7FB499CC_2128678733 = (new Item(in));
            return (Item)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Item(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.936 -0400", hash_original_method = "EE6E2DCA075007A66C19A292386EC3A9", hash_generated_method = "DED4ADB05EB423639B1F12973FA94AEB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Item[] newArray(int size) {
            dsTaint.addTaint(size);
            Item[] var21A1FC72FEBCE59A1C4D4ECF7A65A796_1455925177 = (new Item[size]);
            return (Item[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Item[size];
        }

        
}; //Transformed anonymous class
}

