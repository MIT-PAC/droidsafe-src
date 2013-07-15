package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class TextInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.725 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.725 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.726 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.726 -0400", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "005C37CB404463903C96F2FDFC878DB9")
    public  TextInfo(String text) {
        this(text, 0, 0);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.726 -0400", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "337B792928CE019FBDF584283A605134")
    public  TextInfo(String text, int cookie, int sequence) {
    if(TextUtils.isEmpty(text))        
        {
            IllegalArgumentException var0271D06DC6AE8621CCAE6E69366FDBA4_1923583341 = new IllegalArgumentException(text);
            var0271D06DC6AE8621CCAE6E69366FDBA4_1923583341.addTaint(taint);
            throw var0271D06DC6AE8621CCAE6E69366FDBA4_1923583341;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.727 -0400", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "6FA7C85C95CBB4295DFB5C6B4F7293F1")
    public  TextInfo(Parcel source) {
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
        // ---------- Original Method ----------
        //mText = source.readString();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.727 -0400", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "CD4FFFA8241B59E73A1BFAF3A3EA654A")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mText);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        // ---------- Original Method ----------
        //dest.writeString(mText);
        //dest.writeInt(mCookie);
        //dest.writeInt(mSequence);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.728 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "B1B6208D7EB8042B5F9EFB950269430E")
    public String getText() {
String var7F7ECB4B14362FFBA020956966B29A66_1126417318 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_1126417318.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_1126417318;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.728 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "370C04EB7BD1A7313D624F6D2B492469")
    public int getCookie() {
        int var6E854C680205E153D6A9DE7BA337DEAC_1915980746 = (mCookie);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803069212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803069212;
        // ---------- Original Method ----------
        //return mCookie;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.728 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "175FA13C764A94B7658801CF7EB9E4C7")
    public int getSequence() {
        int varDFA2A9B34C4EF6A435AC62654D16526E_48620116 = (mSequence);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218026318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218026318;
        // ---------- Original Method ----------
        //return mSequence;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.728 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "39FC27C2156DBE10E21169150C9A74C5")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1587696245 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799553428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799553428;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.728 -0400", hash_original_field = "6EEA547074FA6FFA43F36F5BBA63B9C1", hash_generated_field = "E3059B89E044EFFFEE81FFCBFDB37D6F")

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

