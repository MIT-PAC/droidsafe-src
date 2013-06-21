package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class TextInfo implements Parcelable {
    private String mText;
    private int mCookie;
    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.503 -0400", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "FD27B35B2E7F1CEB0BEFAE6EE4622CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextInfo(String text) {
        this(text, 0, 0);
        dsTaint.addTaint(text);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.503 -0400", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "2CBCDE5A55376B981D909ED2ED64BA6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextInfo(String text, int cookie, int sequence) {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(text);
        dsTaint.addTaint(sequence);
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_56138235 = (TextUtils.isEmpty(text));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(text);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(text)) {
            //throw new IllegalArgumentException(text);
        //}
        //mText = text;
        //mCookie = cookie;
        //mSequence = sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.503 -0400", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "B709FF4895C0B494D7C885D9C9C930A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
        // ---------- Original Method ----------
        //mText = source.readString();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.503 -0400", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "D6A173810434B9B2A07AA9F4B7F1A3A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mText);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        // ---------- Original Method ----------
        //dest.writeString(mText);
        //dest.writeInt(mCookie);
        //dest.writeInt(mSequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "E3EAAAD01B180F3E836EEC9E5B123291")
    @DSModeled(DSC.SAFE)
    public String getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "01496ACE56D3B7CCEA709998CA4572B6")
    @DSModeled(DSC.SAFE)
    public int getCookie() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "8BB9E17C8E439ED53C772A4A13D13795")
    @DSModeled(DSC.SAFE)
    public int getSequence() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static final Parcelable.Creator<TextInfo> CREATOR = new Parcelable.Creator<TextInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "C95CDA85767E41F4E63E830DD2608E4F", hash_generated_method = "077B5058E5C9427A355CC52505031852")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TextInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            TextInfo var25D9AFE74177CB087E794A2CC118E409_33833176 = (new TextInfo(source));
            return (TextInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TextInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.504 -0400", hash_original_method = "6BCA98C20410A9F228A60FB161EDF202", hash_generated_method = "7481C392B4649346CEE79737E249B512")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TextInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            TextInfo[] varA75F586C5E2C00E58A8D1C0CCA909B8D_287333801 = (new TextInfo[size]);
            return (TextInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TextInfo[size];
        }

        
}; //Transformed anonymous class
}

