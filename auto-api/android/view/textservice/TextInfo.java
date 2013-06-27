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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.745 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.745 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.746 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.746 -0400", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "005C37CB404463903C96F2FDFC878DB9")
    public  TextInfo(String text) {
        this(text, 0, 0);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.747 -0400", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "AA0F904E0113D2C469FD714717A2F6DE")
    public  TextInfo(String text, int cookie, int sequence) {
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_709184261 = (TextUtils.isEmpty(text));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(text);
            } //End block
        } //End collapsed parenthetic
        mText = text;
        mCookie = cookie;
        mSequence = sequence;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(text)) {
            //throw new IllegalArgumentException(text);
        //}
        //mText = text;
        //mCookie = cookie;
        //mSequence = sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.747 -0400", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "6FA7C85C95CBB4295DFB5C6B4F7293F1")
    public  TextInfo(Parcel source) {
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
        // ---------- Original Method ----------
        //mText = source.readString();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.748 -0400", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "722B6A344F6ECA46D1D2200378DB1B0F")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mText);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mText);
        //dest.writeInt(mCookie);
        //dest.writeInt(mSequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.758 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "837461750F6709D65EB6341FFADAEF50")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_2090780028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2090780028 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_2090780028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2090780028;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.759 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "C0CFF864E63E272C689055D412BD4153")
    public int getCookie() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551589699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551589699;
        // ---------- Original Method ----------
        //return mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.759 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "44479EFF543FD81F742FBF80596320CC")
    public int getSequence() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411315049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411315049;
        // ---------- Original Method ----------
        //return mSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.759 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3910DF69A985BB37EC4FFF8DFC225E0A")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746649521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746649521;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.760 -0400", hash_original_field = "6EEA547074FA6FFA43F36F5BBA63B9C1", hash_generated_field = "E3059B89E044EFFFEE81FFCBFDB37D6F")

    public static final Parcelable.Creator<TextInfo> CREATOR
            = new Parcelable.Creator<TextInfo>() {
        @Override
        public TextInfo createFromParcel(Parcel source) {
            return new TextInfo(source);
        }

        @Override
        public TextInfo[] newArray(int size) {
            return new TextInfo[size];
        }
    };
}

