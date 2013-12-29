package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;





public class TextMessage implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.631 -0400", hash_original_field = "EF3F1EB675921B9F7D12DA9545573B3F", hash_generated_field = "7AB7AD3116D6E3A5A4512A3A97E00765")

    public static final Parcelable.Creator<TextMessage> CREATOR = new Parcelable.Creator<TextMessage>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.277 -0500", hash_original_method = "193204926DE8A544A72BFB5B6B7CDED8", hash_generated_method = "5153762E696A40E5C895C9B601886119")
        public TextMessage createFromParcel(Parcel in) {
            return new TextMessage(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.278 -0500", hash_original_method = "F5D191BD196FFE2386251BBE8C8F1CD2", hash_generated_method = "E5561EF4D0387938F289B4A53E5F392B")
        public TextMessage[] newArray(int size) {
            return new TextMessage[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.267 -0500", hash_original_field = "367C7DE0517AFB335926659BE075E62E", hash_generated_field = "89D5663AAD817AD059982BDCE7E515F8")

    public String title = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.268 -0500", hash_original_field = "7B7C2A609FEDB31FDC299D68B4960131", hash_generated_field = "7C6EB2211248E8ECCC9536A2703A266C")

    public String text = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.269 -0500", hash_original_field = "C6E106C25903444A1A0B9FDB23193E0A", hash_generated_field = "9BB4432E8A17D94FAC37F939FB84BC7B")

    public Bitmap icon = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.269 -0500", hash_original_field = "FAA0A4E5EE9C832E4E03FB95034C3006", hash_generated_field = "E4277ECAEF6B2AF19DCEE8FDCADEAB53")

    public boolean iconSelfExplanatory = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.270 -0500", hash_original_field = "6A1F2660DF8B3CD66266091BD0E920A3", hash_generated_field = "1DE57C793E1EE8AAC93D0C943D569901")

    public boolean isHighPriority = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.271 -0500", hash_original_field = "2F7B5EC67BCECECC50CE2E43C191DA4D", hash_generated_field = "B5C2806FE50578767D404E0200F66E94")

    public boolean responseNeeded = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.272 -0500", hash_original_field = "F5611DAB90410A1CCEB907C77031B9E9", hash_generated_field = "51C7DB463990EF775339231B2F6261ED")

    public boolean userClear = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.272 -0500", hash_original_field = "90DE8F5FB1484229C98B6411A0471CB2", hash_generated_field = "E4FF40771E805BB676F6D4F40FE541E7")

    public Duration duration = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.273 -0500", hash_original_method = "9D0AB1B2CC05C1155E2594BD69FE3EC1", hash_generated_method = "9D0AB1B2CC05C1155E2594BD69FE3EC1")
    TextMessage() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.274 -0500", hash_original_method = "3799DABAA0CF60B82958F76005DE5116", hash_generated_method = "5280A0EB969981172683E0C9A5180813")
    private TextMessage(Parcel in) {
        title = in.readString();
        text = in.readString();
        icon = in.readParcelable(null);
        iconSelfExplanatory = in.readInt() == 1 ? true : false;
        isHighPriority = in.readInt() == 1 ? true : false;
        responseNeeded = in.readInt() == 1 ? true : false;
        userClear = in.readInt() == 1 ? true : false;
        duration = in.readParcelable(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.275 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.276 -0500", hash_original_method = "5C9745DEA7F97922AFA0A354D69593A3", hash_generated_method = "6A7D1D94390BDFCCA8C30F1A15F03A90")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
        dest.writeParcelable(icon, 0);
        dest.writeInt(iconSelfExplanatory ? 1 : 0);
        dest.writeInt(isHighPriority ? 1 : 0);
        dest.writeInt(responseNeeded ? 1 : 0);
        dest.writeInt(userClear ? 1 : 0);
        dest.writeParcelable(duration, 0);
    }
    // orphaned legacy method
    public TextMessage createFromParcel(Parcel in) {
            return new TextMessage(in);
        }
    
    // orphaned legacy method
    public TextMessage[] newArray(int size) {
            return new TextMessage[size];
        }
    
}

