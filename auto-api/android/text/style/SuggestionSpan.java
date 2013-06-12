package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int FLAG_EASY_CORRECT = 0x0001;
    public static final int FLAG_MISSPELLED = 0x0002;
    public static final int FLAG_AUTO_CORRECTION = 0x0004;
    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    public static final int SUGGESTIONS_MAX_SIZE = 5;
    private int mFlags;
    private final String[] mSuggestions;
    private final String mLocaleString;
    private final String mNotificationTargetClassName;
    private final int mHashCode;
    private float mEasyCorrectUnderlineThickness;
    private int mEasyCorrectUnderlineColor;
    private float mMisspelledUnderlineThickness;
    private int mMisspelledUnderlineColor;
    private float mAutoCorrectionUnderlineThickness;
    private int mAutoCorrectionUnderlineColor;
    public static final Parcelable.Creator<SuggestionSpan> CREATOR = new Parcelable.Creator<SuggestionSpan>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.339 -0400", hash_original_method = "83D0E443CEF3A23105CCAF941D2CD31C", hash_generated_method = "D9CF42FB421E6F767A889108AD7264B6")
        @DSModeled(DSC.SAFE)
        @Override
        public SuggestionSpan createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (SuggestionSpan)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionSpan(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.339 -0400", hash_original_method = "2859891039EEB1F9F4824C56AEBEC162", hash_generated_method = "155E02E48CC2EBAFBBBA633B35FF7720")
        @DSModeled(DSC.SAFE)
        @Override
        public SuggestionSpan[] newArray(int size) {
            dsTaint.addTaint(size);
            return (SuggestionSpan[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SuggestionSpan[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.339 -0400", hash_original_method = "1AA1B5C63F654C549AF10ADB766A64DF", hash_generated_method = "FC64DF2C0C198D0DB67CC3DB1A18945C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Context context, String[] suggestions, int flags) {
        this(context, null, suggestions, flags, null);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(suggestions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.339 -0400", hash_original_method = "88CDF93F546795CBA0066C8B71DB0B2A", hash_generated_method = "B140D8818DD0DDBB565830E7ABC9DB9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Locale locale, String[] suggestions, int flags) {
        this(null, locale, suggestions, flags, null);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(suggestions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.339 -0400", hash_original_method = "A25B331A60DB2E24929C6ECDB825D631", hash_generated_method = "2B38EB26CAB3BE6FA5E53BBE2B0272FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionSpan(Context context, Locale locale, String[] suggestions, int flags,
            Class<?> notificationTargetClass) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(suggestions);
        dsTaint.addTaint(notificationTargetClass.dsTaint);
        final int N;
        N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        mSuggestions = Arrays.copyOf(suggestions, N);
        {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } //End block
                {
            mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "AC28AFCA6CE2EAE56AAAC33C5F3867AA", hash_generated_method = "AA7DB88692E74A39037E156A9B4C31B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "BA5838B3AC67A7A883D23FDD23135D12", hash_generated_method = "56641FAC99E2DD1965F046A303E0FE02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "04652F77FFC7CAE5D602B0C4E1FED158", hash_generated_method = "A000EC71C46E0EB0CFD13F4958BFE194")
    @DSModeled(DSC.SAFE)
    public String[] getSuggestions() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mSuggestions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "A5C216C37271149997104A3E25E89F54", hash_generated_method = "D0572983FA62BFF352EE5DF0903BD6B9")
    @DSModeled(DSC.SAFE)
    public String getLocale() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLocaleString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "248A1CDF1DF25C4245B012EBF128264F", hash_generated_method = "D47F4AEB46DFBCB89007536A25055383")
    @DSModeled(DSC.SAFE)
    public String getNotificationTargetClassName() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNotificationTargetClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.340 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "B26C2F9BF1D3CF35709A1E868416FD9D")
    @DSModeled(DSC.SAFE)
    public int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "CA4BF4BE3BC1B3094957FBC465D7A081", hash_generated_method = "E3894DEB0259DECB316E16770A0B2AF6")
    @DSModeled(DSC.SAFE)
    public void setFlags(int flags) {
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
        //mFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "B88B3E1963FF277C84F7B31C7327EB57", hash_generated_method = "709DA437F5FA9947D75E52A375FF5B27")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "DBAA6553895459183AA1E1C35310F256", hash_generated_method = "3C90D1D14AE324A06860082F27862B6B")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "DEEF8A91A4946D9B043EDA2DAC8F9CA5", hash_generated_method = "AC0B986FD8996B9F0E0BFB183DAD0700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var500A963F8ACD27ABA28675D4855B6937_1222544424 = (((SuggestionSpan)o).hashCode() == mHashCode);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o instanceof SuggestionSpan) {
            //return ((SuggestionSpan)o).hashCode() == mHashCode;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "CC95935C60ED1B6371583A785322D85D")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "19A242C347BA804206F8CA950CA33C4A", hash_generated_method = "0C8639614D1C222AC84A8F5F0321AC10")
    private static int hashCodeInternal(String[] suggestions, String locale,
            String notificationTargetClassName) {
        return Arrays.hashCode(new Object[] {Long.valueOf(SystemClock.uptimeMillis()), suggestions,
                locale, notificationTargetClassName});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "FC1F2F33C12EF11918B48BC18977D662", hash_generated_method = "1F52CB758C8673A3569D4BCFC9DC5DB0")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        final boolean misspelled;
        misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy;
        easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.341 -0400", hash_original_method = "6F69CCF79C26CDB5AAE1758554866B40", hash_generated_method = "495E41D27349782ABB42F07EB2AE7D77")
    @DSModeled(DSC.SAFE)
    public int getUnderlineColor() {
        final boolean misspelled;
        misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy;
        easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection;
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

    
}


