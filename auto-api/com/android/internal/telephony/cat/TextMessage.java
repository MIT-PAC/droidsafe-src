package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class TextMessage implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "E2DC2962A3400D07C1E73970CD6088E9", hash_generated_field = "89D5663AAD817AD059982BDCE7E515F8")

    public String title = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "2CC7BFE3CD16BA4B3DACD763882084C8", hash_generated_field = "7C6EB2211248E8ECCC9536A2703A266C")

    public String text = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "0978EC6ACE6187BDAA54B44671E52FAB", hash_generated_field = "9BB4432E8A17D94FAC37F939FB84BC7B")

    public Bitmap icon = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "C40D01357EC1C81E9000661C41F80901", hash_generated_field = "E4277ECAEF6B2AF19DCEE8FDCADEAB53")

    public boolean iconSelfExplanatory = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "68D5B6F568BA91F33BE55991F6AC6206", hash_generated_field = "1DE57C793E1EE8AAC93D0C943D569901")

    public boolean isHighPriority = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "DA1C5D50EF6FCEE5F3779916610C8024", hash_generated_field = "B5C2806FE50578767D404E0200F66E94")

    public boolean responseNeeded = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "71ED17B77860D3BADAF5E39B9DD6CB78", hash_generated_field = "51C7DB463990EF775339231B2F6261ED")

    public boolean userClear = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_field = "3D5D894443C0D0494E94B408130DD98B", hash_generated_field = "E4FF40771E805BB676F6D4F40FE541E7")

    public Duration duration = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.826 -0400", hash_original_method = "9D0AB1B2CC05C1155E2594BD69FE3EC1", hash_generated_method = "83409D8B2575D0083E782346223705C9")
      TextMessage() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.827 -0400", hash_original_method = "3799DABAA0CF60B82958F76005DE5116", hash_generated_method = "58BF70938726D0FF39CF9E007FA074C7")
    private  TextMessage(Parcel in) {
        title = in.readString();
        text = in.readString();
        icon = in.readParcelable(null);
        iconSelfExplanatory = in.readInt() == 1 ? true : false;
        isHighPriority = in.readInt() == 1 ? true : false;
        responseNeeded = in.readInt() == 1 ? true : false;
        userClear = in.readInt() == 1 ? true : false;
        duration = in.readParcelable(null);
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.827 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B1C3580E7E5ACF909DE5C99B7BFC04C9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886803648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886803648;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.827 -0400", hash_original_method = "5C9745DEA7F97922AFA0A354D69593A3", hash_generated_method = "CD562A9E72009CE75758F5998D04023A")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
        dest.writeParcelable(icon, 0);
        dest.writeInt(iconSelfExplanatory ? 1 : 0);
        dest.writeInt(isHighPriority ? 1 : 0);
        dest.writeInt(responseNeeded ? 1 : 0);
        dest.writeInt(userClear ? 1 : 0);
        dest.writeParcelable(duration, 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.827 -0400", hash_original_field = "EF3F1EB675921B9F7D12DA9545573B3F", hash_generated_field = "7AB7AD3116D6E3A5A4512A3A97E00765")

    public static final Parcelable.Creator<TextMessage> CREATOR = new Parcelable.Creator<TextMessage>() {
        public TextMessage createFromParcel(Parcel in) {
            return new TextMessage(in);
        }

        public TextMessage[] newArray(int size) {
            return new TextMessage[size];
        }
    };
    
    public TextMessage createFromParcel(Parcel in) {
            return new TextMessage(in);
        }
    
    
    public TextMessage[] newArray(int size) {
            return new TextMessage[size];
        }
    
}

