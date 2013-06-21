package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.ArrayUtils;
import android.os.Parcel;
import android.os.Parcelable;

public final class SuggestionsInfo implements Parcelable {
    private int mSuggestionsAttributes;
    private String[] mSuggestions;
    private boolean mSuggestionsAvailable;
    private int mCookie;
    private int mSequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.496 -0400", hash_original_method = "F72366BA0EDF1634C1AA3C488E109E33", hash_generated_method = "93773D1E64E15CFA73D5DF890FD6D853")
    @DSModeled(DSC.SAFE)
    public SuggestionsInfo(int suggestionsAttributes, String[] suggestions) {
        dsTaint.addTaint(suggestionsAttributes);
        dsTaint.addTaint(suggestions[0]);
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.496 -0400", hash_original_method = "F344476C9AC73EBE1631CA25EF553262", hash_generated_method = "B801F44704E74BCDF976C84AAD040AED")
    @DSModeled(DSC.SAFE)
    public SuggestionsInfo(
            int suggestionsAttributes, String[] suggestions, int cookie, int sequence) {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(sequence);
        dsTaint.addTaint(suggestionsAttributes);
        dsTaint.addTaint(suggestions[0]);
        {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } //End block
        {
            mSuggestionsAvailable = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "A8076752A4CBE1F29691F498A5186710", hash_generated_method = "8986C2FAC55A0AD1F2BEF6F63F33F49A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionsInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "D6F7E488E85F5F73C07F51AB39369D4C", hash_generated_method = "3190ECE2AE8DDA17981255EA6F976EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "BC94DA38979C8D1C8B1C739567CEFAB2", hash_generated_method = "09D202761E826F84198FDC48D08DFCA4")
    @DSModeled(DSC.SAFE)
    public void setCookieAndSequence(int cookie, int sequence) {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(sequence);
        // ---------- Original Method ----------
        //mCookie = cookie;
        //mSequence = sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "01496ACE56D3B7CCEA709998CA4572B6")
    @DSModeled(DSC.SAFE)
    public int getCookie() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "8BB9E17C8E439ED53C772A4A13D13795")
    @DSModeled(DSC.SAFE)
    public int getSequence() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.497 -0400", hash_original_method = "CAB4876CFD4A091BA905BB4AD514BA41", hash_generated_method = "7093F0C8871552CE1D23E394331328BC")
    @DSModeled(DSC.SAFE)
    public int getSuggestionsAttributes() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSuggestionsAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.498 -0400", hash_original_method = "F830DF6AFB67D9BA96245AE6E3B04D1C", hash_generated_method = "2D77F7417EF4C821F2516D68CBD1AE72")
    @DSModeled(DSC.SAFE)
    public int getSuggestionsCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!mSuggestionsAvailable) {
            //return -1;
        //}
        //return mSuggestions.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.498 -0400", hash_original_method = "303722B2FF6B72DC10F6A88905A65E92", hash_generated_method = "2B5B71035780A3833036D318677CD747")
    @DSModeled(DSC.SAFE)
    public String getSuggestionAt(int i) {
        dsTaint.addTaint(i);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestions[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.498 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    private static final String[] EMPTY = ArrayUtils.emptyArray(String.class);
    public static final int RESULT_ATTR_IN_THE_DICTIONARY = 0x0001;
    public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 0x0002;
    public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 0x0004;
    public static final Parcelable.Creator<SuggestionsInfo> CREATOR = new Parcelable.Creator<SuggestionsInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.498 -0400", hash_original_method = "F97F550CBFC4BB9C72B2E6BDB6B999E6", hash_generated_method = "86D4325980B92E01BAFD2A598576BA28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SuggestionsInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            SuggestionsInfo var4F22E4F5A208799B588D02920D997537_23191944 = (new SuggestionsInfo(source));
            return (SuggestionsInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionsInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.498 -0400", hash_original_method = "F02A74E3784170B5B2B3A7C1C66F7DCB", hash_generated_method = "0A31D16AB3D1E76F16D23CF8024E83CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SuggestionsInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            SuggestionsInfo[] varE1A22E07CE42AD26DF05CA692738D93F_1471543025 = (new SuggestionsInfo[size]);
            return (SuggestionsInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionsInfo[size];
        }

        
}; //Transformed anonymous class
}

