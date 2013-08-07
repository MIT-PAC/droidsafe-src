package android.view.textservice;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public final class TextInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.020 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.020 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.020 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.020 -0400", hash_original_method = "A935C713B1C118E04C925F76EDA27293", hash_generated_method = "005C37CB404463903C96F2FDFC878DB9")
    public  TextInfo(String text) {
        this(text, 0, 0);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.022 -0400", hash_original_method = "B3A9BFDD6561354A8432CF39635FFD52", hash_generated_method = "78BADAC5C7FFD45BDF9D02E499EF66FD")
    public  TextInfo(String text, int cookie, int sequence) {
        if(TextUtils.isEmpty(text))        
        {
            IllegalArgumentException var0271D06DC6AE8621CCAE6E69366FDBA4_899769085 = new IllegalArgumentException(text);
            var0271D06DC6AE8621CCAE6E69366FDBA4_899769085.addTaint(taint);
            throw var0271D06DC6AE8621CCAE6E69366FDBA4_899769085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.024 -0400", hash_original_method = "54ACC9BA5B2FD7C303374DCEBBF4E743", hash_generated_method = "6FA7C85C95CBB4295DFB5C6B4F7293F1")
    public  TextInfo(Parcel source) {
        mText = source.readString();
        mCookie = source.readInt();
        mSequence = source.readInt();
        // ---------- Original Method ----------
        //mText = source.readString();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.024 -0400", hash_original_method = "573D2D5BE8E27F6CA8F77B871E9B67A7", hash_generated_method = "CD4FFFA8241B59E73A1BFAF3A3EA654A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.024 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "69E24BBF70270B1EA1ACE7B348CA0B31")
    public String getText() {
String var7F7ECB4B14362FFBA020956966B29A66_924572809 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_924572809.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_924572809;
        // ---------- Original Method ----------
        //return mText;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.025 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "3967A9F307A2C912502834CF859735EA")
    public int getCookie() {
        int var6E854C680205E153D6A9DE7BA337DEAC_2103493511 = (mCookie);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738194546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738194546;
        // ---------- Original Method ----------
        //return mCookie;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.025 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "E38F472276C8CA5049FF654CF25951C1")
    public int getSequence() {
        int varDFA2A9B34C4EF6A435AC62654D16526E_285714109 = (mSequence);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29197824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29197824;
        // ---------- Original Method ----------
        //return mSequence;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.025 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "75FDE5FE4C9B22D57FA14CFBB68C4EFD")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_441036357 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91894900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91894900;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.025 -0400", hash_original_field = "6EEA547074FA6FFA43F36F5BBA63B9C1", hash_generated_field = "E3059B89E044EFFFEE81FFCBFDB37D6F")

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

