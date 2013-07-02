package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.util.ArrayUtils;
import android.os.Parcel;
import android.os.Parcelable;

public final class SuggestionsInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_field = "659339316F0FA48E105689F448D3DD36", hash_generated_field = "390932DA60837BE0A47579CAD7C0B1B8")

    private int mSuggestionsAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_field = "CA02AEF8EAC753FA2D196EF97B87005C", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private String[] mSuggestions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_field = "E208D34C580E8C2FF2D2E07606F1E52A", hash_generated_field = "4EA9B3C35E806BD03C8EAA998321A5D4")

    private boolean mSuggestionsAvailable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.459 -0400", hash_original_method = "F72366BA0EDF1634C1AA3C488E109E33", hash_generated_method = "7EEE0965FCB80E8E46E017CDCC9AAAAF")
    public  SuggestionsInfo(int suggestionsAttributes, String[] suggestions) {
        mSuggestionsAttributes = suggestionsAttributes;
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } 
        {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        } 
        mCookie = 0;
        mSequence = 0;
        
        
        
            
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.460 -0400", hash_original_method = "F344476C9AC73EBE1631CA25EF553262", hash_generated_method = "54765017D56A2FE9CCDC02AAAB4ED4F4")
    public  SuggestionsInfo(
            int suggestionsAttributes, String[] suggestions, int cookie, int sequence) {
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } 
        {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        } 
        mSuggestionsAttributes = suggestionsAttributes;
        mCookie = cookie;
        mSequence = sequence;
        
        
            
            
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.460 -0400", hash_original_method = "A8076752A4CBE1F29691F498A5186710", hash_generated_method = "AFF965CE09DEBAB8C81C1A1B3381EE0B")
    public  SuggestionsInfo(Parcel source) {
        mSuggestionsAttributes = source.readInt();
        mSuggestions = source.readStringArray();
        mCookie = source.readInt();
        mSequence = source.readInt();
        mSuggestionsAvailable = source.readInt() == 1;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.461 -0400", hash_original_method = "D6F7E488E85F5F73C07F51AB39369D4C", hash_generated_method = "29C6117D6C49F2EC6258DA355F2E96AB")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSuggestionsAttributes);
        dest.writeStringArray(mSuggestions);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        dest.writeInt(mSuggestionsAvailable ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.461 -0400", hash_original_method = "BC94DA38979C8D1C8B1C739567CEFAB2", hash_generated_method = "9E4966E6F8955843BFFC0570250F1A39")
    public void setCookieAndSequence(int cookie, int sequence) {
        mCookie = cookie;
        mSequence = sequence;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.462 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "6D6D1F1F04EFE5EC37FFF20A3BFC09B3")
    public int getCookie() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139298726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139298726;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.462 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "90160281A80C29339439E1B58F59FDC9")
    public int getSequence() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342141499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342141499;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.463 -0400", hash_original_method = "CAB4876CFD4A091BA905BB4AD514BA41", hash_generated_method = "0421BD887D02C4BDA9FB17E7E3B213BE")
    public int getSuggestionsAttributes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428320502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428320502;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.463 -0400", hash_original_method = "F830DF6AFB67D9BA96245AE6E3B04D1C", hash_generated_method = "12AC4DF763634E2ED716EC53F8F2CF81")
    public int getSuggestionsCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428467668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428467668;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_method = "303722B2FF6B72DC10F6A88905A65E92", hash_generated_method = "55E50B06D3F041E35AB66B1832BA079F")
    public String getSuggestionAt(int i) {
        String varB4EAC82CA7396A68D541C85D26508E83_966015205 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_966015205 = mSuggestions[i];
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_966015205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_966015205;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5AE2F922FD0B2BAEADDEF3437BFBD35C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761795220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761795220;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_field = "A8DC2299AB9C9D2C0C54EC3AC018538C", hash_generated_field = "2D3D0D0351BF8AB635A0C02B8A36EDBE")

    private static final String[] EMPTY = ArrayUtils.emptyArray(String.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_field = "97BF5AD1962A9448326287CE4A92D246", hash_generated_field = "1B01F5B80758F8517026C18547BAF7C6")

    public static final int RESULT_ATTR_IN_THE_DICTIONARY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_field = "D90742D0DFC90BF652231491C2A1D529", hash_generated_field = "62708B506BBFFF949F1CE8EDF196B42B")

    public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.464 -0400", hash_original_field = "89A5A88EB521B1F87DC270AE47909638", hash_generated_field = "319837AF46D02D94C46D8330FB323380")

    public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.465 -0400", hash_original_field = "C2528F28EE8C2B797601B9AAA3764A2B", hash_generated_field = "A1262BBCBC0A40327218E2B9D15365C4")

    public static final Parcelable.Creator<SuggestionsInfo> CREATOR
            = new Parcelable.Creator<SuggestionsInfo>() {
        @Override
        public SuggestionsInfo createFromParcel(Parcel source) {
            return new SuggestionsInfo(source);
        }

        @Override
        public SuggestionsInfo[] newArray(int size) {
            return new SuggestionsInfo[size];
        }
    };
    
}

