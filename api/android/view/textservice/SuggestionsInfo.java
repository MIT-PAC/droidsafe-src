package android.view.textservice;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.ArrayUtils;






public final class SuggestionsInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.992 -0400", hash_original_field = "659339316F0FA48E105689F448D3DD36", hash_generated_field = "390932DA60837BE0A47579CAD7C0B1B8")

    private int mSuggestionsAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.992 -0400", hash_original_field = "CA02AEF8EAC753FA2D196EF97B87005C", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private String[] mSuggestions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.992 -0400", hash_original_field = "E208D34C580E8C2FF2D2E07606F1E52A", hash_generated_field = "4EA9B3C35E806BD03C8EAA998321A5D4")

    private boolean mSuggestionsAvailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.992 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.993 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.995 -0400", hash_original_method = "F72366BA0EDF1634C1AA3C488E109E33", hash_generated_method = "E36BDC53EEF4A77EE77D132C2E06D7B0")
    public  SuggestionsInfo(int suggestionsAttributes, String[] suggestions) {
        mSuggestionsAttributes = suggestionsAttributes;
        if(suggestions == null)        
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } //End block
        else
        {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        } //End block
        mCookie = 0;
        mSequence = 0;
        // ---------- Original Method ----------
        //mSuggestionsAttributes = suggestionsAttributes;
        //if (suggestions == null) {
            //mSuggestions = EMPTY;
            //mSuggestionsAvailable = false;
        //} else {
            //mSuggestions = suggestions;
            //mSuggestionsAvailable = true;
        //}
        //mCookie = 0;
        //mSequence = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.997 -0400", hash_original_method = "F344476C9AC73EBE1631CA25EF553262", hash_generated_method = "71F0BA8CCD9118EAD9F1C288663DEF89")
    public  SuggestionsInfo(
            int suggestionsAttributes, String[] suggestions, int cookie, int sequence) {
        if(suggestions == null)        
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } //End block
        else
        {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        } //End block
        mSuggestionsAttributes = suggestionsAttributes;
        mCookie = cookie;
        mSequence = sequence;
        // ---------- Original Method ----------
        //if (suggestions == null) {
            //mSuggestions = EMPTY;
            //mSuggestionsAvailable = false;
        //} else {
            //mSuggestions = suggestions;
            //mSuggestionsAvailable = true;
        //}
        //mSuggestionsAttributes = suggestionsAttributes;
        //mCookie = cookie;
        //mSequence = sequence;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.998 -0400", hash_original_method = "A8076752A4CBE1F29691F498A5186710", hash_generated_method = "AFF965CE09DEBAB8C81C1A1B3381EE0B")
    public  SuggestionsInfo(Parcel source) {
        mSuggestionsAttributes = source.readInt();
        mSuggestions = source.readStringArray();
        mCookie = source.readInt();
        mSequence = source.readInt();
        mSuggestionsAvailable = source.readInt() == 1;
        // ---------- Original Method ----------
        //mSuggestionsAttributes = source.readInt();
        //mSuggestions = source.readStringArray();
        //mCookie = source.readInt();
        //mSequence = source.readInt();
        //mSuggestionsAvailable = source.readInt() == 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.998 -0400", hash_original_method = "D6F7E488E85F5F73C07F51AB39369D4C", hash_generated_method = "C50B0F63077B2CBB179C94674822DE16")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mSuggestionsAttributes);
        dest.writeStringArray(mSuggestions);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        dest.writeInt(mSuggestionsAvailable ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSuggestionsAttributes);
        //dest.writeStringArray(mSuggestions);
        //dest.writeInt(mCookie);
        //dest.writeInt(mSequence);
        //dest.writeInt(mSuggestionsAvailable ? 1 : 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.998 -0400", hash_original_method = "BC94DA38979C8D1C8B1C739567CEFAB2", hash_generated_method = "9E4966E6F8955843BFFC0570250F1A39")
    public void setCookieAndSequence(int cookie, int sequence) {
        mCookie = cookie;
        mSequence = sequence;
        // ---------- Original Method ----------
        //mCookie = cookie;
        //mSequence = sequence;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.999 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "5AD94882F9A145F230FEC529682ABC4B")
    public int getCookie() {
        int var6E854C680205E153D6A9DE7BA337DEAC_1937516370 = (mCookie);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1063861829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1063861829;
        // ---------- Original Method ----------
        //return mCookie;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.999 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "AC307C20E93C9BC4749C111493320DC1")
    public int getSequence() {
        int varDFA2A9B34C4EF6A435AC62654D16526E_904179695 = (mSequence);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726341068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726341068;
        // ---------- Original Method ----------
        //return mSequence;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.999 -0400", hash_original_method = "CAB4876CFD4A091BA905BB4AD514BA41", hash_generated_method = "56D32A663EA03DD3094F49CA6EDD0B63")
    public int getSuggestionsAttributes() {
        int var659339316F0FA48E105689F448D3DD36_258139268 = (mSuggestionsAttributes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932914232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932914232;
        // ---------- Original Method ----------
        //return mSuggestionsAttributes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_method = "F830DF6AFB67D9BA96245AE6E3B04D1C", hash_generated_method = "9CEAC6F2BEBA996DAE9C7B40F4A2177B")
    public int getSuggestionsCount() {
        if(!mSuggestionsAvailable)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_957501079 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109491340 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109491340;
        } //End block
        int var59A6CE6A9698BA3774343B460D0056B4_1050132994 = (mSuggestions.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348611504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348611504;
        // ---------- Original Method ----------
        //if (!mSuggestionsAvailable) {
            //return -1;
        //}
        //return mSuggestions.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_method = "303722B2FF6B72DC10F6A88905A65E92", hash_generated_method = "CF1AB05AADAFE2C29B992C562D870469")
    public String getSuggestionAt(int i) {
        addTaint(i);
String var09A13D800FB7522D7DD400180F60E984_233857354 =         mSuggestions[i];
        var09A13D800FB7522D7DD400180F60E984_233857354.addTaint(taint);
        return var09A13D800FB7522D7DD400180F60E984_233857354;
        // ---------- Original Method ----------
        //return mSuggestions[i];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "59813693FA06304D48942BDE1026997F")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_780339484 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192501068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192501068;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_field = "A8DC2299AB9C9D2C0C54EC3AC018538C", hash_generated_field = "2D3D0D0351BF8AB635A0C02B8A36EDBE")

    private static final String[] EMPTY = ArrayUtils.emptyArray(String.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_field = "97BF5AD1962A9448326287CE4A92D246", hash_generated_field = "1B01F5B80758F8517026C18547BAF7C6")

    public static final int RESULT_ATTR_IN_THE_DICTIONARY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.000 -0400", hash_original_field = "D90742D0DFC90BF652231491C2A1D529", hash_generated_field = "62708B506BBFFF949F1CE8EDF196B42B")

    public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.001 -0400", hash_original_field = "89A5A88EB521B1F87DC270AE47909638", hash_generated_field = "319837AF46D02D94C46D8330FB323380")

    public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.001 -0400", hash_original_field = "C2528F28EE8C2B797601B9AAA3764A2B", hash_generated_field = "A1262BBCBC0A40327218E2B9D15365C4")

    public static final Parcelable.Creator<SuggestionsInfo> CREATOR
            = new Parcelable.Creator<SuggestionsInfo>() {
        @DSModeled(DSC.SAFE)
        @Override
        public SuggestionsInfo createFromParcel(Parcel source) {
            return new SuggestionsInfo(source);
        }

        @DSModeled(DSC.SAFE)
        @Override
        public SuggestionsInfo[] newArray(int size) {
            return new SuggestionsInfo[size];
        }
    };
}

