package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.Locale;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SuggestionSpan extends CharacterStyle implements ParcelableSpan {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.898 -0500", hash_original_method = "19A242C347BA804206F8CA950CA33C4A", hash_generated_method = "0C8639614D1C222AC84A8F5F0321AC10")
    
private static int hashCodeInternal(String[] suggestions, String locale,
            String notificationTargetClassName) {
        return Arrays.hashCode(new Object[] {Long.valueOf(SystemClock.uptimeMillis()), suggestions,
                locale, notificationTargetClassName});
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.809 -0500", hash_original_field = "25E11C67B21CB308C73603F2F7226601", hash_generated_field = "1D7B974E27680F135303E920BF84BF8D")

    public static final int FLAG_EASY_CORRECT = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.812 -0500", hash_original_field = "02FA5FA5AB1E34416EB375C320C852B4", hash_generated_field = "DBA29D2759519352B179244965765408")

    public static final int FLAG_MISSPELLED = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.814 -0500", hash_original_field = "FE705C1788FCEB1E34FC289BD715D7AD", hash_generated_field = "711B1FB5ACCA563596236E3C086B8CA7")

    public static final int FLAG_AUTO_CORRECTION = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.817 -0500", hash_original_field = "C2C4C65430A0254E14DAB7AC833F36C9", hash_generated_field = "6BE9D6FF7EA9AFB0E6D33742E0643DAC")

    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.820 -0500", hash_original_field = "E5256340D9295C3A0D6AA883A5237971", hash_generated_field = "1F2C143752BB6DB9A8D30C9B306CEF3A")

    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.823 -0500", hash_original_field = "72964C1E25BADA1DB0B666ED0F8F6A2D", hash_generated_field = "9184FE4582FFB6A9866F321FBE911D2B")

    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.825 -0500", hash_original_field = "B99DE3CE3189FA8363B747E3FB1CBDDA", hash_generated_field = "3AD3422034F9C2094284D22AF1FFB1F3")

    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.828 -0500", hash_original_field = "E41E5467D8AC444668FE62E51E55FF12", hash_generated_field = "AF65BC39A44E7D93F9365DF1A5F722E1")

    public static final int SUGGESTIONS_MAX_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.224 -0400", hash_original_field = "D7626C6BE860F29C41E36E880CF9437E", hash_generated_field = "368BEC2D23997E875633673B3BD26F7D")

    public static final Parcelable.Creator<SuggestionSpan> CREATOR =
            new Parcelable.Creator<SuggestionSpan>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.901 -0500", hash_original_method = "83D0E443CEF3A23105CCAF941D2CD31C", hash_generated_method = "A157438956A6B2EE4126C37B1504B75D")
        
@Override
        public SuggestionSpan createFromParcel(Parcel source) {
            return new SuggestionSpan(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.904 -0500", hash_original_method = "2859891039EEB1F9F4824C56AEBEC162", hash_generated_method = "746D547A50B5A82B599C75734B55FE1C")
        
@Override
        public SuggestionSpan[] newArray(int size) {
            return new SuggestionSpan[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.830 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.832 -0500", hash_original_field = "D25184D4A2C602FEC3892EB70177EB91", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private  String[] mSuggestions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.835 -0500", hash_original_field = "82080BB7A25D427BAE7797A695BDB8B8", hash_generated_field = "6976E71D408345D64F0294914E1AF7FF")

    private  String mLocaleString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.837 -0500", hash_original_field = "0E9EA22958F5580BD17B813BBD46F6B0", hash_generated_field = "989974DFDEA3AFDC371476BF9398A642")

    private  String mNotificationTargetClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.840 -0500", hash_original_field = "A13152B9FE22A291FA8BF7E71C005049", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private  int mHashCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.843 -0500", hash_original_field = "06BC6A858E238A790B3DB49A52AE943B", hash_generated_field = "D8E4A74236F36CDFABEB6618E7713838")

    private float mEasyCorrectUnderlineThickness;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.846 -0500", hash_original_field = "DD1A84731880B8DEA80E239CCCA8EE38", hash_generated_field = "905A94AA135811911825782A2E1D2D0E")

    private int mEasyCorrectUnderlineColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.848 -0500", hash_original_field = "7BDD2761EAB8EB4D336D07B75D25A9BF", hash_generated_field = "7C6B77EA496ACC5A6845012167698141")

    private float mMisspelledUnderlineThickness;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.850 -0500", hash_original_field = "000078B6D48A012D7A9CBB72782DD459", hash_generated_field = "BDDD9AB7CE31E6C68EA76F54C1C6C56E")

    private int mMisspelledUnderlineColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.852 -0500", hash_original_field = "FB092D1F7EE550B296F688594379B53A", hash_generated_field = "C319F61C6ED6657EDFE1CE012D16B907")

    private float mAutoCorrectionUnderlineThickness;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.855 -0500", hash_original_field = "7499AB346189BD34077419B0E098498D", hash_generated_field = "EA8BF259BCC9D5320AD9DAB8BD56682E")

    private int mAutoCorrectionUnderlineColor;

    /**
     * @param context Context for the application
     * @param suggestions Suggestions for the string under the span
     * @param flags Additional flags indicating how this span is handled in TextView
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.857 -0500", hash_original_method = "1AA1B5C63F654C549AF10ADB766A64DF", hash_generated_method = "74A33A9CF13FF82D333456B68C61E897")
    
public SuggestionSpan(Context context, String[] suggestions, int flags) {
        this(context, null, suggestions, flags, null);
    }

    /**
     * @param locale Locale of the suggestions
     * @param suggestions Suggestions for the string under the span
     * @param flags Additional flags indicating how this span is handled in TextView
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.860 -0500", hash_original_method = "88CDF93F546795CBA0066C8B71DB0B2A", hash_generated_method = "D2658D0A2C8B8C4C4DCAADA498C094AF")
    
public SuggestionSpan(Locale locale, String[] suggestions, int flags) {
        this(null, locale, suggestions, flags, null);
    }

    /**
     * @param context Context for the application
     * @param locale locale Locale of the suggestions
     * @param suggestions Suggestions for the string under the span. Only the first up to
     * {@link SuggestionSpan#SUGGESTIONS_MAX_SIZE} will be considered.
     * @param flags Additional flags indicating how this span is handled in TextView
     * @param notificationTargetClass if not null, this class will get notified when the user
     * selects one of the suggestions.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.864 -0500", hash_original_method = "A25B331A60DB2E24929C6ECDB825D631", hash_generated_method = "C96E639A52CBBDFB6EC5C4C69B4049AC")
    
public SuggestionSpan(Context context, Locale locale, String[] suggestions, int flags,
            Class<?> notificationTargetClass) {
        final int N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        mSuggestions = Arrays.copyOf(suggestions, N);
        mFlags = flags;
        if (context != null && locale == null) {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } else {
            mLocaleString = locale.toString();
        }

        if (notificationTargetClass != null) {
            mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
        } else {
            mNotificationTargetClassName = "";
        }
        mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);

        initStyle(context);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.870 -0500", hash_original_method = "AC28AFCA6CE2EAE56AAAC33C5F3867AA", hash_generated_method = "817E7E3AC2DF398EC373F171C80E3E05")
    
public SuggestionSpan(Parcel src) {
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.867 -0500", hash_original_method = "BA5838B3AC67A7A883D23FDD23135D12", hash_generated_method = "94CCEC7D8AF36D768886794C882E01D2")
    
private void initStyle(Context context) {
        if (context == null) {
            mMisspelledUnderlineThickness = 0;
            mEasyCorrectUnderlineThickness = 0;
            mAutoCorrectionUnderlineThickness = 0;
            mMisspelledUnderlineColor = Color.BLACK;
            mEasyCorrectUnderlineColor = Color.BLACK;
            mAutoCorrectionUnderlineColor = Color.BLACK;
            return;
        }

        int defStyle = com.android.internal.R.attr.textAppearanceMisspelledSuggestion;
        TypedArray typedArray = context.obtainStyledAttributes(
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
    }

    /**
     * @return an array of suggestion texts for this span
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.872 -0500", hash_original_method = "04652F77FFC7CAE5D602B0C4E1FED158", hash_generated_method = "013629CE7E363B170006B500CA4D5D7A")
    
public String[] getSuggestions() {
        return mSuggestions;
    }

    /**
     * @return the locale of the suggestions
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.875 -0500", hash_original_method = "A5C216C37271149997104A3E25E89F54", hash_generated_method = "8A75BE64309CC11E6E9FB3F5754CC8E4")
    
public String getLocale() {
        return mLocaleString;
    }

    /**
     * @return The name of the class to notify. The class of the original IME package will receive
     * a notification when the user selects one of the suggestions. The notification will include
     * the original string, the suggested replacement string as well as the hashCode of this span.
     * The class will get notified by an intent that has those information.
     * This is an internal API because only the framework should know the class name.
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.877 -0500", hash_original_method = "248A1CDF1DF25C4245B012EBF128264F", hash_generated_method = "B9AB09A78E3DAC7EFDC7AA4B2768F922")
    
public String getNotificationTargetClassName() {
        return mNotificationTargetClassName;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.879 -0500", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "A2E92201CC64F45D5B306C5445EC4739")
    
public int getFlags() {
        return mFlags;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.882 -0500", hash_original_method = "CA4BF4BE3BC1B3094957FBC465D7A081", hash_generated_method = "97A4B5D77B14653C46CC07DE01BD3A06")
    
public void setFlags(int flags) {
        mFlags = flags;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.884 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.887 -0500", hash_original_method = "B88B3E1963FF277C84F7B31C7327EB57", hash_generated_method = "32BAEB93F19464E02D67D2B8744873BF")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
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
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.890 -0500", hash_original_method = "DBAA6553895459183AA1E1C35310F256", hash_generated_method = "F8E6266376A4F6A7AF437EF4875BA636")
    
@Override
    public int getSpanTypeId() {
        return TextUtils.SUGGESTION_SPAN;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.893 -0500", hash_original_method = "DEEF8A91A4946D9B043EDA2DAC8F9CA5", hash_generated_method = "48E06225B31E8FF62F1F24D1789138A2")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof SuggestionSpan) {
            return ((SuggestionSpan)o).hashCode() == mHashCode;
        }
        return false;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.895 -0500", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "B0837B818531E3C208A8A4F995ED9F70")
    
@Override
    public int hashCode() {
        return mHashCode;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.910 -0500", hash_original_method = "FC1F2F33C12EF11918B48BC18977D662", hash_generated_method = "E790414A86A20EEB60D3E6F6C0131EBB")
    
@Override
    public void updateDrawState(TextPaint tp) {
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        if (easy) {
            if (!misspelled) {
                tp.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
            } else if (tp.underlineColor == 0) {
                // Spans are rendered in an arbitrary order. Since misspelled is less prioritary
                // than just easy, do not apply misspelled if an easy (or a mispelled) has been set
                tp.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
            }
        } else if (autoCorrection) {
            tp.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        }
    }

    /**
     * @return The color of the underline for that span, or 0 if there is no underline
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.913 -0500", hash_original_method = "6F69CCF79C26CDB5AAE1758554866B40", hash_generated_method = "05D7DDAE757CC59D61ACFA08D764FD8C")
    
public int getUnderlineColor() {
        // The order here should match what is used in updateDrawState
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        if (easy) {
            if (!misspelled) {
                return mEasyCorrectUnderlineColor;
            } else {
                return mMisspelledUnderlineColor;
            }
        } else if (autoCorrection) {
            return mAutoCorrectionUnderlineColor;
        }
        return 0;
    }
}

