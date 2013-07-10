package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "CA02AEF8EAC753FA2D196EF97B87005C", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private String[] mSuggestions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "F8C014B9DC9B6F650C6A5D6711E7B81B", hash_generated_field = "6976E71D408345D64F0294914E1AF7FF")

    private String mLocaleString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "C4CAD77D098232600F5558362002C7AB", hash_generated_field = "989974DFDEA3AFDC371476BF9398A642")

    private String mNotificationTargetClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "E956BB9564CEFC570FEA9AB3C95F10E8", hash_generated_field = "D8E4A74236F36CDFABEB6618E7713838")

    private float mEasyCorrectUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "BDCD49C66A8BA2B78EE398B7616EB873", hash_generated_field = "905A94AA135811911825782A2E1D2D0E")

    private int mEasyCorrectUnderlineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "A80A2BB072BE7B32F7EFEFB15B008AF3", hash_generated_field = "7C6B77EA496ACC5A6845012167698141")

    private float mMisspelledUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "791E2C995AC7D9DEC6A8E948883CF1B2", hash_generated_field = "BDDD9AB7CE31E6C68EA76F54C1C6C56E")

    private int mMisspelledUnderlineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "93DB5E340D77634F6DF7B6530227999C", hash_generated_field = "C319F61C6ED6657EDFE1CE012D16B907")

    private float mAutoCorrectionUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.953 -0400", hash_original_field = "5D1932BD724A70EE08630ECDFD073593", hash_generated_field = "EA8BF259BCC9D5320AD9DAB8BD56682E")

    private int mAutoCorrectionUnderlineColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.954 -0400", hash_original_method = "1AA1B5C63F654C549AF10ADB766A64DF", hash_generated_method = "E4AA98F06146B222EF4E7EB69234BBA8")
    public  SuggestionSpan(Context context, String[] suggestions, int flags) {
        this(context, null, suggestions, flags, null);
        addTaint(context.getTaint());
        addTaint(suggestions[0].getTaint());
        addTaint(flags);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.954 -0400", hash_original_method = "88CDF93F546795CBA0066C8B71DB0B2A", hash_generated_method = "57A048FD1C6D98A0698F066D51785D7A")
    public  SuggestionSpan(Locale locale, String[] suggestions, int flags) {
        this(null, locale, suggestions, flags, null);
        addTaint(locale.getTaint());
        addTaint(suggestions[0].getTaint());
        addTaint(flags);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.955 -0400", hash_original_method = "A25B331A60DB2E24929C6ECDB825D631", hash_generated_method = "3BC88620B5F5EB85F78A8720FD6D3C9A")
    public  SuggestionSpan(Context context, Locale locale, String[] suggestions, int flags,
            Class<?> notificationTargetClass) {
        final int N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        mSuggestions = Arrays.copyOf(suggestions, N);
        mFlags = flags;
        {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } 
        {
            mLocaleString = locale.toString();
        } 
        {
            mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
        } 
        {
            mNotificationTargetClassName = "";
        } 
        mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);
        initStyle(context);
        
        
        
        
        
            
        
            
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.955 -0400", hash_original_method = "AC28AFCA6CE2EAE56AAAC33C5F3867AA", hash_generated_method = "712A353AF7234E2FDCC2A17962307AE6")
    public  SuggestionSpan(Parcel src) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.957 -0400", hash_original_method = "BA5838B3AC67A7A883D23FDD23135D12", hash_generated_method = "FA9FEFC91C989E04A427C5E20D1F6696")
    private void initStyle(Context context) {
        {
            mMisspelledUnderlineThickness = 0;
            mEasyCorrectUnderlineThickness = 0;
            mAutoCorrectionUnderlineThickness = 0;
            mMisspelledUnderlineColor = Color.BLACK;
            mEasyCorrectUnderlineColor = Color.BLACK;
            mAutoCorrectionUnderlineColor = Color.BLACK;
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
        addTaint(context.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.958 -0400", hash_original_method = "04652F77FFC7CAE5D602B0C4E1FED158", hash_generated_method = "8482D4D09362042C4A71EDCD1B649D75")
    public String[] getSuggestions() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1029791560 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1029791560 = mSuggestions;
        varB4EAC82CA7396A68D541C85D26508E83_1029791560.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1029791560;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.958 -0400", hash_original_method = "A5C216C37271149997104A3E25E89F54", hash_generated_method = "EB7533ADE047D37F7BE214FE475E07D7")
    public String getLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1460474504 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1460474504 = mLocaleString;
        varB4EAC82CA7396A68D541C85D26508E83_1460474504.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1460474504;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.959 -0400", hash_original_method = "248A1CDF1DF25C4245B012EBF128264F", hash_generated_method = "80F1880D3A1850B754BC51479DD13662")
    public String getNotificationTargetClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_893881512 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_893881512 = mNotificationTargetClassName;
        varB4EAC82CA7396A68D541C85D26508E83_893881512.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_893881512;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.959 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "CB0074D1A74785A44A893E1F35355F13")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796133944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796133944;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.959 -0400", hash_original_method = "CA4BF4BE3BC1B3094957FBC465D7A081", hash_generated_method = "85F0B9F34D43E8A3B2C0982106D45E4D")
    public void setFlags(int flags) {
        mFlags = flags;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.959 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2EC7D8802A08D62AA1A965B509699894")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145303452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145303452;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.960 -0400", hash_original_method = "B88B3E1963FF277C84F7B31C7327EB57", hash_generated_method = "143E88ACDB6CC9F5ACAD9C2C55FF5575")
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
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.960 -0400", hash_original_method = "DBAA6553895459183AA1E1C35310F256", hash_generated_method = "898CEAA6E78C2B2BCAE4CBEE421F6A4B")
    @Override
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983064362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983064362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.960 -0400", hash_original_method = "DEEF8A91A4946D9B043EDA2DAC8F9CA5", hash_generated_method = "FDA035DF9EB54A1650431271EF6EC0C1")
    @Override
    public boolean equals(Object o) {
        {
            boolean var500A963F8ACD27ABA28675D4855B6937_607686583 = (((SuggestionSpan)o).hashCode() == mHashCode);
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634495015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634495015;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.961 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "7F12213FCB3B1F1D2BED9A6C10AADE8A")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600652464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600652464;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int hashCodeInternal(String[] suggestions, String locale,
            String notificationTargetClassName) {
        return Arrays.hashCode(new Object[] {Long.valueOf(SystemClock.uptimeMillis()), suggestions,
                locale, notificationTargetClassName});
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.961 -0400", hash_original_method = "FC1F2F33C12EF11918B48BC18977D662", hash_generated_method = "EB0E539C0DC2F7E9DFE4AAFB81BF71E4")
    @Override
    public void updateDrawState(TextPaint tp) {
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        {
            {
                tp.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
            } 
            {
                tp.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
            } 
        } 
        {
            tp.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        } 
        addTaint(tp.getTaint());
        
        
        
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_method = "6F69CCF79C26CDB5AAE1758554866B40", hash_generated_method = "E824A4BF99CB9B1D63AB3C92327FEF2E")
    public int getUnderlineColor() {
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006591225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006591225;
        
        
        
        
        
            
                
            
                
            
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "7555E0084C8700A4BB6F3718BE46674D", hash_generated_field = "1D7B974E27680F135303E920BF84BF8D")

    public static final int FLAG_EASY_CORRECT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "A708EACC955FF35E5E6FB7F37EF6CC52", hash_generated_field = "DBA29D2759519352B179244965765408")

    public static final int FLAG_MISSPELLED = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "9715ECF168FACCF4AF16F8046A2CEB59", hash_generated_field = "711B1FB5ACCA563596236E3C086B8CA7")

    public static final int FLAG_AUTO_CORRECTION = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "C0D336A66C280BCE4B9B488359B6B588", hash_generated_field = "6BE9D6FF7EA9AFB0E6D33742E0643DAC")

    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "B695D07CF613C9C38E2442FC9305663B", hash_generated_field = "1F2C143752BB6DB9A8D30C9B306CEF3A")

    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "C1B859A532523D319E0D2C0C2CFD7B36", hash_generated_field = "9184FE4582FFB6A9866F321FBE911D2B")

    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "22B1E822A3E96026E3585C9DCAA2CBEA", hash_generated_field = "3AD3422034F9C2094284D22AF1FFB1F3")

    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "AF6244CA0A343D2679CCD6D79405434C", hash_generated_field = "AF65BC39A44E7D93F9365DF1A5F722E1")

    public static final int SUGGESTIONS_MAX_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.962 -0400", hash_original_field = "D7626C6BE860F29C41E36E880CF9437E", hash_generated_field = "368BEC2D23997E875633673B3BD26F7D")

    public static final Parcelable.Creator<SuggestionSpan> CREATOR =
            new Parcelable.Creator<SuggestionSpan>() {
        @Override
        public SuggestionSpan createFromParcel(Parcel source) {
            return new SuggestionSpan(source);
        }

        @Override
        public SuggestionSpan[] newArray(int size) {
            return new SuggestionSpan[size];
        }
    };
}

