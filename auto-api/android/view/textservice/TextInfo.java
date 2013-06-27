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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.658 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.659 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.659 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.659 -0400", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "005C37CB404463903C96F2FDFC878DB9")
    public  TextInfo(String text) {
        this(text, 0, 0);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.666 -0400", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "9FC37A5DBB1A073E9372768B3301A497")
    public  TextInfo(String text, int cookie, int sequence) {
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_1606105489 = (TextUtils.isEmpty(text));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.668 -0400", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "6FA7C85C95CBB4295DFB5C6B4F7293F1")
    public  TextInfo(Parcel source) {
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
        // ---------- Original Method ----------
        //mText = source.readString();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.668 -0400", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "722B6A344F6ECA46D1D2200378DB1B0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.675 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "6EC787A4B5E8E5242DF836DEF967EFE7")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_1247026026 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1247026026 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_1247026026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247026026;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.676 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "544A49D175CC15D5A18A897F0583260D")
    public int getCookie() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604723515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604723515;
        // ---------- Original Method ----------
        //return mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.677 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "B292A9D44A9DF959B5084146EB46935C")
    public int getSequence() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965175510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965175510;
        // ---------- Original Method ----------
        //return mSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.677 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6329883475B353087A9B847104E0BC0D")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486402899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486402899;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.677 -0400", hash_original_field = "6EEA547074FA6FFA43F36F5BBA63B9C1", hash_generated_field = "E3059B89E044EFFFEE81FFCBFDB37D6F")

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

