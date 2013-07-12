package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "691D502CFD0E0626CD3B058E5682AD1C", hash_generated_field = "476ABB1F52C3A12124EEACDB58E8E189")

    public List<Item> items;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "195FA8DF6FC9B5CFB062F802C5E71427", hash_generated_field = "5A5E763DDA809E466D258B0BEF7B3CF1")

    public List<TextAttribute> titleAttrs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "A44325CD80CA8B3708910F324AD665E0", hash_generated_field = "CB58C9A657B05B968317B537DCD37634")

    public PresentationType presentationType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "8A90568C6E332919F11E323BA0057155")

    public String title;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "D794263776054546DBA5B1ED2CC754D6", hash_generated_field = "098A35A0443838BE0B42D9CC5F647B03")

    public Bitmap titleIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.371 -0400", hash_original_field = "8FE94B374176FBB177C44C8192C32021", hash_generated_field = "3A0377EDF9C782CB4D4BFE39FE615D31")

    public int defaultItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.372 -0400", hash_original_field = "96A3428F0F548A8F00D3CEC1EBAE0C1E", hash_generated_field = "C7573512761AE15B4F2E1EC9799C356F")

    public boolean softKeyPreferred;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.372 -0400", hash_original_field = "95C3E9257A5998B6C3758B36FBDB8DD8", hash_generated_field = "B089F8BA7DD3EF733FF9A54CE2F03291")

    public boolean helpAvailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.372 -0400", hash_original_field = "2C96220247CE6637DCD0E5D1096649B1", hash_generated_field = "0FAF24D8129D04267CF76644994A3196")

    public boolean titleIconSelfExplanatory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.372 -0400", hash_original_field = "2F1407D5232300DC3271B60FBC5FDA47", hash_generated_field = "6B371AD473F156CDACB463C287BE9F73")

    public boolean itemsIconSelfExplanatory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.374 -0400", hash_original_method = "2E99B961E06FFBDF1C6EFBD0F84C03B4", hash_generated_method = "A863469DD6195991058FA32E29A64698")
    public  Menu() {
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
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.376 -0400", hash_original_method = "170B02CF9C000CCCFFA0390811062CB3", hash_generated_method = "6D049DF9F137E0DDAF395EA0222D7001")
    private  Menu(Parcel in) {
        title = in.readString();
        titleIcon = in.readParcelable(null);
        items = new ArrayList<Item>();
        int size = in.readInt();
for(int i=0;i<size;i++)
        {
            Item item = in.readParcelable(null);
            items.add(item);
        } 
        defaultItem = in.readInt();
        softKeyPreferred = in.readInt() == 1 ? true : false;
        helpAvailable = in.readInt() == 1 ? true : false;
        titleIconSelfExplanatory = in.readInt() == 1 ? true : false;
        itemsIconSelfExplanatory = in.readInt() == 1 ? true : false;
        presentationType = PresentationType.values()[in.readInt()];
        
        
        
        
        
        
            
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.377 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DA42183997582C83BEBF40D28AEFC922")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1660030436 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124826410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124826410;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.377 -0400", hash_original_method = "B96ACF1C9395307298AAD1BDB077B52A", hash_generated_method = "5541DD5628A3AA4FBACFBF0FC93B0330")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(title);
        dest.writeParcelable(titleIcon, flags);
        int size = items.size();
        dest.writeInt(size);
for(int i=0;i<size;i++)
        {
            dest.writeParcelable(items.get(i), flags);
        } 
        dest.writeInt(defaultItem);
        dest.writeInt(softKeyPreferred ? 1 : 0);
        dest.writeInt(helpAvailable ? 1 : 0);
        dest.writeInt(titleIconSelfExplanatory ? 1 : 0);
        dest.writeInt(itemsIconSelfExplanatory ? 1 : 0);
        dest.writeInt(presentationType.ordinal());
        
        
        
        
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.377 -0400", hash_original_field = "F280FAF502E3EC830C212739EA877C0E", hash_generated_field = "55BC0B4641874E81A5D070AF9C451A82")

    public static final Parcelable.Creator<Menu> CREATOR = new Parcelable.Creator<Menu>() {
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
    
    public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }
    
    
    public Menu[] newArray(int size) {
            return new Menu[size];
        }
    
}

