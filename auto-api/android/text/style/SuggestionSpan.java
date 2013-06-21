package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Locale;

public class SuggestionSpan extends CharacterStyle implements ParcelableSpan {
    private int mFlags;
    private String[] mSuggestions;
    private String mLocaleString;
    private String mNotificationTargetClassName;
    private int mHashCode;
    private float mEasyCorrectUnderlineThickness;
    private int mEasyCorrectUnderlineColor;
    private float mMisspelledUnderlineThickness;
    private int mMisspelledUnderlineColor;
    private float mAutoCorrectionUnderlineThickness;
    private int mAutoCorrectionUnderlineColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.979 -0400", hash_original_method = "1AA1B5C63F654C549AF10ADB766A64DF", hash_generated_method = "8DE647CE50E23D57D44B858A99F121B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Context context, String[] suggestions, int flags) {
        this(context, null, suggestions, flags, null);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(suggestions[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.979 -0400", hash_original_method = "88CDF93F546795CBA0066C8B71DB0B2A", hash_generated_method = "440BD2279C6D5B8D6368CFB7EBA47F67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Locale locale, String[] suggestions, int flags) {
        this(null, locale, suggestions, flags, null);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(suggestions[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.980 -0400", hash_original_method = "A25B331A60DB2E24929C6ECDB825D631", hash_generated_method = "717106B9BEFC916132B299CD48E24DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Context context, Locale locale, String[] suggestions, int flags,
            Class<?> notificationTargetClass) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(suggestions[0]);
        dsTaint.addTaint(notificationTargetClass.dsTaint);
        int N;
        N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        mSuggestions = Arrays.copyOf(suggestions, N);
        {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } //End block
        {
            mLocaleString = locale.toString();
        } //End block
        {
            mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
        } //End block
        {
            mNotificationTargetClassName = "";
        } //End block
        mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);
        initStyle(context);
        // ---------- Original Method ----------
        //final int N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        //mSuggestions = Arrays.copyOf(suggestions, N);
        //mFlags = flags;
        //if (context != null && locale == null) {
            //mLocaleString = context.getResources().getConfiguration().locale.toString();
        //} else {
            //mLocaleString = locale.toString();
        //}
        //if (notificationTargetClass != null) {
            //mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
        //} else {
            //mNotificationTargetClassName = "";
        //}
        //mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);
        //initStyle(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.980 -0400", hash_original_method = "AC28AFCA6CE2EAE56AAAC33C5F3867AA", hash_generated_method = "DB7BF183FCAA838FD27F2A75FD45465A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mSuggestions = src.readStringArray();
        mFlags = src.readInt();
        mLocaleString = src.readString();
        mNotificationTargetClassName = src.readString();
        mHashCode = src.readInt();
        mEasyCorrectUnderlineColor = src.readInt();
        mEasyCorrectUnderlineThickness = src.readFloat();
        mMisspelledUnderlineColor = src.readInt();
        mMisspelledUnderlineThickness = src.readFloat();
        mAutoCorrectionUnderlineColor = src.readInt();
        mAutoCorrectionUnderlineThickness = src.readFloat();
        // ---------- Original Method ----------
        //mSuggestions = src.readStringArray();
        //mFlags = src.readInt();
        //mLocaleString = src.readString();
        //mNotificationTargetClassName = src.readString();
        //mHashCode = src.readInt();
        //mEasyCorrectUnderlineColor = src.readInt();
        //mEasyCorrectUnderlineThickness = src.readFloat();
        //mMisspelledUnderlineColor = src.readInt();
        //mMisspelledUnderlineThickness = src.readFloat();
        //mAutoCorrectionUnderlineColor = src.readInt();
        //mAutoCorrectionUnderlineThickness = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.981 -0400", hash_original_method = "BA5838B3AC67A7A883D23FDD23135D12", hash_generated_method = "FA9E89DF5B1A84C06A36C5C726FED51D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initStyle(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            mMisspelledUnderlineThickness = 0;
            mEasyCorrectUnderlineThickness = 0;
            mAutoCorrectionUnderlineThickness = 0;
            mMisspelledUnderlineColor = Color.BLACK;
            mEasyCorrectUnderlineColor = Color.BLACK;
            mAutoCorrectionUnderlineColor = Color.BLACK;
        } //End block
        int defStyle;
        defStyle = com.android.internal.R.attr.textAppearanceMisspelledSuggestion;
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(
                null, com.android.internal.R.styleable.SuggestionSpan, defStyle, 0);
        mMisspelledUnderlineThickness = typedArray.getDimension(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineThickness, 0);
        mMisspelledUnderlineColor = typedArray.getColor(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineColor, Color.BLACK);
        defStyle = com.android.internal.R.attr.textAppearanceEasyCorrectSuggestion;
        typedArray = context.obtainStyledAttributes(
                null, com.android.internal.R.styleable.SuggestionSpan, defStyle, 0);
        mEasyCorrectUnderlineThickness = typedArray.getDimension(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineThickness, 0);
        mEasyCorrectUnderlineColor = typedArray.getColor(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineColor, Color.BLACK);
        defStyle = com.android.internal.R.attr.textAppearanceAutoCorrectionSuggestion;
        typedArray = context.obtainStyledAttributes(
                null, com.android.internal.R.styleable.SuggestionSpan, defStyle, 0);
        mAutoCorrectionUnderlineThickness = typedArray.getDimension(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineThickness, 0);
        mAutoCorrectionUnderlineColor = typedArray.getColor(
                com.android.internal.R.styleable.SuggestionSpan_textUnderlineColor, Color.BLACK);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.981 -0400", hash_original_method = "04652F77FFC7CAE5D602B0C4E1FED158", hash_generated_method = "92B20387FADD491F87416E7D92DF462A")
    @DSModeled(DSC.SAFE)
    public String[] getSuggestions() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mSuggestions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.982 -0400", hash_original_method = "A5C216C37271149997104A3E25E89F54", hash_generated_method = "F6A340AEAE2D278C4B7797FB28EB28EF")
    @DSModeled(DSC.SAFE)
    public String getLocale() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLocaleString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.982 -0400", hash_original_method = "248A1CDF1DF25C4245B012EBF128264F", hash_generated_method = "C4EA6F53ED2FEB8F65C3C0DB3D855485")
    @DSModeled(DSC.SAFE)
    public String getNotificationTargetClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNotificationTargetClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.982 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "DCA5119FF28B26AD9D6F7E29978E11F1")
    @DSModeled(DSC.SAFE)
    public int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.982 -0400", hash_original_method = "CA4BF4BE3BC1B3094957FBC465D7A081", hash_generated_method = "C7327F2C34AB403927A5E6C67FB16FDC")
    @DSModeled(DSC.SAFE)
    public void setFlags(int flags) {
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
        //mFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.982 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.983 -0400", hash_original_method = "B88B3E1963FF277C84F7B31C7327EB57", hash_generated_method = "28DA8971AE43C55646A2B1C1145A3B20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeStringArray(mSuggestions);
        dest.writeInt(mFlags);
        dest.writeString(mLocaleString);
        dest.writeString(mNotificationTargetClassName);
        dest.writeInt(mHashCode);
        dest.writeInt(mEasyCorrectUnderlineColor);
        dest.writeFloat(mEasyCorrectUnderlineThickness);
        dest.writeInt(mMisspelledUnderlineColor);
        dest.writeFloat(mMisspelledUnderlineThickness);
        dest.writeInt(mAutoCorrectionUnderlineColor);
        dest.writeFloat(mAutoCorrectionUnderlineThickness);
        // ---------- Original Method ----------
        //dest.writeStringArray(mSuggestions);
        //dest.writeInt(mFlags);
        //dest.writeString(mLocaleString);
        //dest.writeString(mNotificationTargetClassName);
        //dest.writeInt(mHashCode);
        //dest.writeInt(mEasyCorrectUnderlineColor);
        //dest.writeFloat(mEasyCorrectUnderlineThickness);
        //dest.writeInt(mMisspelledUnderlineColor);
        //dest.writeFloat(mMisspelledUnderlineThickness);
        //dest.writeInt(mAutoCorrectionUnderlineColor);
        //dest.writeFloat(mAutoCorrectionUnderlineThickness);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.983 -0400", hash_original_method = "DBAA6553895459183AA1E1C35310F256", hash_generated_method = "5E35FEB48D778A4241179A1A668F515E")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.983 -0400", hash_original_method = "DEEF8A91A4946D9B043EDA2DAC8F9CA5", hash_generated_method = "7C94CE56498F7267966F048119F5B86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var500A963F8ACD27ABA28675D4855B6937_2021888541 = (((SuggestionSpan)o).hashCode() == mHashCode);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof SuggestionSpan) {
            //return ((SuggestionSpan)o).hashCode() == mHashCode;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.984 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "299AB68DDC3147F06079A7D1A7DCDD71")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHashCode;
    }

    
        private static int hashCodeInternal(String[] suggestions, String locale,
            String notificationTargetClassName) {
        return Arrays.hashCode(new Object[] {Long.valueOf(SystemClock.uptimeMillis()), suggestions,
                locale, notificationTargetClassName});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.984 -0400", hash_original_method = "FC1F2F33C12EF11918B48BC18977D662", hash_generated_method = "DA663744EF19C70B3BC6F34C7A6D220A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        boolean misspelled;
        misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        boolean easy;
        easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        boolean autoCorrection;
        autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        {
            {
                tp.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
            } //End block
            {
                tp.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
            } //End block
        } //End block
        {
            tp.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        } //End block
        // ---------- Original Method ----------
        //final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        //final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        //final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        //if (easy) {
            //if (!misspelled) {
                //tp.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
            //} else if (tp.underlineColor == 0) {
                //tp.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
            //}
        //} else if (autoCorrection) {
            //tp.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.985 -0400", hash_original_method = "6F69CCF79C26CDB5AAE1758554866B40", hash_generated_method = "7E84A0D701C4EC32D83FBDEB5B03A619")
    @DSModeled(DSC.SAFE)
    public int getUnderlineColor() {
        boolean misspelled;
        misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        boolean easy;
        easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        boolean autoCorrection;
        autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        //final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        //final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        //if (easy) {
            //if (!misspelled) {
                //return mEasyCorrectUnderlineColor;
            //} else {
                //return mMisspelledUnderlineColor;
            //}
        //} else if (autoCorrection) {
            //return mAutoCorrectionUnderlineColor;
        //}
        //return 0;
    }

    
    public static final int FLAG_EASY_CORRECT = 0x0001;
    public static final int FLAG_MISSPELLED = 0x0002;
    public static final int FLAG_AUTO_CORRECTION = 0x0004;
    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    public static final int SUGGESTIONS_MAX_SIZE = 5;
    public static final Parcelable.Creator<SuggestionSpan> CREATOR = new Parcelable.Creator<SuggestionSpan>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.986 -0400", hash_original_method = "83D0E443CEF3A23105CCAF941D2CD31C", hash_generated_method = "D423F56271D0423CF6C6C0C32ECDD074")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SuggestionSpan createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            SuggestionSpan var8371CBEF07DB73706E1C6A13DAAD8F1A_45879831 = (new SuggestionSpan(source));
            return (SuggestionSpan)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionSpan(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.986 -0400", hash_original_method = "2859891039EEB1F9F4824C56AEBEC162", hash_generated_method = "7E786F03E4A37049F92A4616940A342E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SuggestionSpan[] newArray(int size) {
            dsTaint.addTaint(size);
            SuggestionSpan[] varE7AD1E623C6DFBBC1039CBEFC9C56C91_780391018 = (new SuggestionSpan[size]);
            return (SuggestionSpan[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionSpan[size];
        }

        
}; //Transformed anonymous class
}

