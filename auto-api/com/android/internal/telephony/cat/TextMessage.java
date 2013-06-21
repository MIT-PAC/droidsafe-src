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

public class TextMessage implements Parcelable {
    public String title = "";
    public String text = null;
    public Bitmap icon = null;
    public boolean iconSelfExplanatory = false;
    public boolean isHighPriority = false;
    public boolean responseNeeded = true;
    public boolean userClear = false;
    public Duration duration = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.023 -0400", hash_original_method = "9D0AB1B2CC05C1155E2594BD69FE3EC1", hash_generated_method = "83409D8B2575D0083E782346223705C9")
    @DSModeled(DSC.SAFE)
     TextMessage() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.024 -0400", hash_original_method = "3799DABAA0CF60B82958F76005DE5116", hash_generated_method = "3D2082503F99FD7877631CA1C5B7B40F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TextMessage(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        title = in.readString();
        text = in.readString();
        icon = in.readParcelable(null);
        iconSelfExplanatory = in.readInt() == 1 ? true : false;
        isHighPriority = in.readInt() == 1 ? true : false;
        responseNeeded = in.readInt() == 1 ? true : false;
        userClear = in.readInt() == 1 ? true : false;
        duration = in.readParcelable(null);
        // ---------- Original Method ----------
        //title = in.readString();
        //text = in.readString();
        //icon = in.readParcelable(null);
        //iconSelfExplanatory = in.readInt() == 1 ? true : false;
        //isHighPriority = in.readInt() == 1 ? true : false;
        //responseNeeded = in.readInt() == 1 ? true : false;
        //userClear = in.readInt() == 1 ? true : false;
        //duration = in.readParcelable(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.024 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.024 -0400", hash_original_method = "5C9745DEA7F97922AFA0A354D69593A3", hash_generated_method = "47ECF625BE83DDFFF42D3AA79FE75CC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(title);
        dest.writeString(text);
        dest.writeParcelable(icon, 0);
        dest.writeInt(iconSelfExplanatory ? 1 : 0);
        dest.writeInt(isHighPriority ? 1 : 0);
        dest.writeInt(responseNeeded ? 1 : 0);
        dest.writeInt(userClear ? 1 : 0);
        dest.writeParcelable(duration, 0);
        // ---------- Original Method ----------
        //dest.writeString(title);
        //dest.writeString(text);
        //dest.writeParcelable(icon, 0);
        //dest.writeInt(iconSelfExplanatory ? 1 : 0);
        //dest.writeInt(isHighPriority ? 1 : 0);
        //dest.writeInt(responseNeeded ? 1 : 0);
        //dest.writeInt(userClear ? 1 : 0);
        //dest.writeParcelable(duration, 0);
    }

    
    public static final Parcelable.Creator<TextMessage> CREATOR = new Parcelable.Creator<TextMessage>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.025 -0400", hash_original_method = "193204926DE8A544A72BFB5B6B7CDED8", hash_generated_method = "056B6F8E39C51A6A9A4277E2B0D22961")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TextMessage createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            TextMessage var801ED9D053C1CC8D0B5566A9D3991EE3_1926800965 = (new TextMessage(in));
            return (TextMessage)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TextMessage(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.025 -0400", hash_original_method = "F5D191BD196FFE2386251BBE8C8F1CD2", hash_generated_method = "CB2A38D9EF6FECFC605FA8A1056CA243")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TextMessage[] newArray(int size) {
            dsTaint.addTaint(size);
            TextMessage[] var284AC1832E5AB1AE9BAB1F689F5FF368_1946669796 = (new TextMessage[size]);
            return (TextMessage[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TextMessage[size];
        }

        
}; //Transformed anonymous class
}

