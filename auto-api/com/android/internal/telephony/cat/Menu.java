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
import java.util.ArrayList;
import java.util.List;

public class Menu implements Parcelable {
    public List<Item> items;
    public List<TextAttribute> titleAttrs;
    public PresentationType presentationType;
    public String title;
    public Bitmap titleIcon;
    public int defaultItem;
    public boolean softKeyPreferred;
    public boolean helpAvailable;
    public boolean titleIconSelfExplanatory;
    public boolean itemsIconSelfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.947 -0400", hash_original_method = "2E99B961E06FFBDF1C6EFBD0F84C03B4", hash_generated_method = "A863469DD6195991058FA32E29A64698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Menu() {
        items = new ArrayList<Item>();
        title = null;
        titleAttrs = null;
        defaultItem = 0;
        softKeyPreferred = false;
        helpAvailable = false;
        titleIconSelfExplanatory = false;
        itemsIconSelfExplanatory = false;
        titleIcon = null;
        presentationType = PresentationType.NAVIGATION_OPTIONS;
        // ---------- Original Method ----------
        //items = new ArrayList<Item>();
        //title = null;
        //titleAttrs = null;
        //defaultItem = 0;
        //softKeyPreferred = false;
        //helpAvailable = false;
        //titleIconSelfExplanatory = false;
        //itemsIconSelfExplanatory = false;
        //titleIcon = null;
        //presentationType = PresentationType.NAVIGATION_OPTIONS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.948 -0400", hash_original_method = "170B02CF9C000CCCFFA0390811062CB3", hash_generated_method = "676093082E6378D21CF35B944CE8E0EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Menu(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        title = in.readString();
        titleIcon = in.readParcelable(null);
        items = new ArrayList<Item>();
        int size;
        size = in.readInt();
        {
            int i;
            i = 0;
            {
                Item item;
                item = in.readParcelable(null);
                items.add(item);
            } //End block
        } //End collapsed parenthetic
        defaultItem = in.readInt();
        softKeyPreferred = in.readInt() == 1 ? true : false;
        helpAvailable = in.readInt() == 1 ? true : false;
        titleIconSelfExplanatory = in.readInt() == 1 ? true : false;
        itemsIconSelfExplanatory = in.readInt() == 1 ? true : false;
        presentationType = PresentationType.values()[in.readInt()];
        // ---------- Original Method ----------
        //title = in.readString();
        //titleIcon = in.readParcelable(null);
        //items = new ArrayList<Item>();
        //int size = in.readInt();
        //for (int i=0; i<size; i++) {
            //Item item = in.readParcelable(null);
            //items.add(item);
        //}
        //defaultItem = in.readInt();
        //softKeyPreferred = in.readInt() == 1 ? true : false;
        //helpAvailable = in.readInt() == 1 ? true : false;
        //titleIconSelfExplanatory = in.readInt() == 1 ? true : false;
        //itemsIconSelfExplanatory = in.readInt() == 1 ? true : false;
        //presentationType = PresentationType.values()[in.readInt()];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.948 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.949 -0400", hash_original_method = "B96ACF1C9395307298AAD1BDB077B52A", hash_generated_method = "BD79AFC181155D428CC6987B0D97E237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(title);
        dest.writeParcelable(titleIcon, flags);
        int size;
        size = items.size();
        dest.writeInt(size);
        {
            int i;
            i = 0;
            {
                dest.writeParcelable(items.get(i), flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeInt(defaultItem);
        dest.writeInt(softKeyPreferred ? 1 : 0);
        dest.writeInt(helpAvailable ? 1 : 0);
        dest.writeInt(titleIconSelfExplanatory ? 1 : 0);
        dest.writeInt(itemsIconSelfExplanatory ? 1 : 0);
        dest.writeInt(presentationType.ordinal());
        // ---------- Original Method ----------
        //dest.writeString(title);
        //dest.writeParcelable(titleIcon, flags);
        //int size = items.size();
        //dest.writeInt(size);
        //for (int i=0; i<size; i++) {
            //dest.writeParcelable(items.get(i), flags);
        //}
        //dest.writeInt(defaultItem);
        //dest.writeInt(softKeyPreferred ? 1 : 0);
        //dest.writeInt(helpAvailable ? 1 : 0);
        //dest.writeInt(titleIconSelfExplanatory ? 1 : 0);
        //dest.writeInt(itemsIconSelfExplanatory ? 1 : 0);
        //dest.writeInt(presentationType.ordinal());
    }

    
    public static final Parcelable.Creator<Menu> CREATOR = new Parcelable.Creator<Menu>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.949 -0400", hash_original_method = "B445093B170171BD842D7C958982DF35", hash_generated_method = "618226FE8309EF9631ED7E041E0D538A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Menu createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Menu var75D803CF59F99C0D8F9BBFFF020D4D84_1877515692 = (new Menu(in));
            return (Menu)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Menu(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.949 -0400", hash_original_method = "F22AD3E8083B6C85A43FA20A727DB120", hash_generated_method = "B80B4A9F74F392BAAA8121E84F76D1D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Menu[] newArray(int size) {
            dsTaint.addTaint(size);
            Menu[] varC1CAD0198B3B9C6AB5F5AEDCADCB0908_759671543 = (new Menu[size]);
            return (Menu[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Menu[size];
        }

        
}; //Transformed anonymous class
}

