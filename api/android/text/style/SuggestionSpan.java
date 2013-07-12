package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "CA02AEF8EAC753FA2D196EF97B87005C", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private String[] mSuggestions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "F8C014B9DC9B6F650C6A5D6711E7B81B", hash_generated_field = "6976E71D408345D64F0294914E1AF7FF")

    private String mLocaleString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "C4CAD77D098232600F5558362002C7AB", hash_generated_field = "989974DFDEA3AFDC371476BF9398A642")

    private String mNotificationTargetClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.397 -0400", hash_original_field = "E956BB9564CEFC570FEA9AB3C95F10E8", hash_generated_field = "D8E4A74236F36CDFABEB6618E7713838")

    private float mEasyCorrectUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_field = "BDCD49C66A8BA2B78EE398B7616EB873", hash_generated_field = "905A94AA135811911825782A2E1D2D0E")

    private int mEasyCorrectUnderlineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_field = "A80A2BB072BE7B32F7EFEFB15B008AF3", hash_generated_field = "7C6B77EA496ACC5A6845012167698141")

    private float mMisspelledUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_field = "791E2C995AC7D9DEC6A8E948883CF1B2", hash_generated_field = "BDDD9AB7CE31E6C68EA76F54C1C6C56E")

    private int mMisspelledUnderlineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_field = "93DB5E340D77634F6DF7B6530227999C", hash_generated_field = "C319F61C6ED6657EDFE1CE012D16B907")

    private float mAutoCorrectionUnderlineThickness;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_field = "5D1932BD724A70EE08630ECDFD073593", hash_generated_field = "EA8BF259BCC9D5320AD9DAB8BD56682E")

    private int mAutoCorrectionUnderlineColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_method = "1AA1B5C63F654C549AF10ADB766A64DF", hash_generated_method = "DBD60BCEEE69E8AE6149D744FD438FD6")
    public  SuggestionSpan(Context context, String[] suggestions, int flags) {
        this(context, null, suggestions, flags, null);
        addTaint(flags);
        addTaint(suggestions[0].getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.398 -0400", hash_original_method = "88CDF93F546795CBA0066C8B71DB0B2A", hash_generated_method = "A2CA26509DC18D698A004F0E040FEA4A")
    public  SuggestionSpan(Locale locale, String[] suggestions, int flags) {
        this(null, locale, suggestions, flags, null);
        addTaint(flags);
        addTaint(suggestions[0].getTaint());
        addTaint(locale.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.400 -0400", hash_original_method = "A25B331A60DB2E24929C6ECDB825D631", hash_generated_method = "A004D61977C92E7599910C9E9363EDFF")
    public  SuggestionSpan(Context context, Locale locale, String[] suggestions, int flags,
            Class<?> notificationTargetClass) {
        final int N = Math.min(SUGGESTIONS_MAX_SIZE, suggestions.length);
        mSuggestions = Arrays.copyOf(suggestions, N);
        mFlags = flags;
    if(context != null && locale == null)        
        {
            mLocaleString = context.getResources().getConfiguration().locale.toString();
        } 
        else
        {
            mLocaleString = locale.toString();
        } 
    if(notificationTargetClass != null)        
        {
            mNotificationTargetClassName = notificationTargetClass.getCanonicalName();
        } 
        else
        {
            mNotificationTargetClassName = "";
        } 
        mHashCode = hashCodeInternal(mSuggestions, mLocaleString, mNotificationTargetClassName);
        initStyle(context);
        
        
        
        
        
            
        
            
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.402 -0400", hash_original_method = "AC28AFCA6CE2EAE56AAAC33C5F3867AA", hash_generated_method = "712A353AF7234E2FDCC2A17962307AE6")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.404 -0400", hash_original_method = "BA5838B3AC67A7A883D23FDD23135D12", hash_generated_method = "70621487F43C248E57A43D38FEA487D4")
    private void initStyle(Context context) {
        addTaint(context.getTaint());
    if(context == null)        
        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.405 -0400", hash_original_method = "04652F77FFC7CAE5D602B0C4E1FED158", hash_generated_method = "8E1885F969FD98BE7C1E67CD5C6DFFC1")
    public String[] getSuggestions() {
String[] var92323203D5120492B0A269EF8CC62459_1324687416 =         mSuggestions;
        var92323203D5120492B0A269EF8CC62459_1324687416.addTaint(taint);
        return var92323203D5120492B0A269EF8CC62459_1324687416;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.405 -0400", hash_original_method = "A5C216C37271149997104A3E25E89F54", hash_generated_method = "5E6AA66C468C606496A4C2AD2722AC19")
    public String getLocale() {
String varB2660BACB674CEB63470DD0D45A8D0D5_2138029193 =         mLocaleString;
        varB2660BACB674CEB63470DD0D45A8D0D5_2138029193.addTaint(taint);
        return varB2660BACB674CEB63470DD0D45A8D0D5_2138029193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.405 -0400", hash_original_method = "248A1CDF1DF25C4245B012EBF128264F", hash_generated_method = "D738852D9108803C11082D3AE33315CD")
    public String getNotificationTargetClassName() {
String varFA0CC82C3EC85485A38A003386BB68C9_659415215 =         mNotificationTargetClassName;
        varFA0CC82C3EC85485A38A003386BB68C9_659415215.addTaint(taint);
        return varFA0CC82C3EC85485A38A003386BB68C9_659415215;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.405 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "C73ABDE9E6C656971F1ECD0F03977EEA")
    public int getFlags() {
        int var9C3CD7D37D3E1E66BE9B3B005FC98B3A_824993563 = (mFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502892234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502892234;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.406 -0400", hash_original_method = "CA4BF4BE3BC1B3094957FBC465D7A081", hash_generated_method = "85F0B9F34D43E8A3B2C0982106D45E4D")
    public void setFlags(int flags) {
        mFlags = flags;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.406 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2D87009292C54915DE6671F04B4328D9")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_666203234 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298444108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298444108;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.406 -0400", hash_original_method = "B88B3E1963FF277C84F7B31C7327EB57", hash_generated_method = "29DD4AD91B5F1E25C57ED2636AE4BC0F")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.406 -0400", hash_original_method = "DBAA6553895459183AA1E1C35310F256", hash_generated_method = "D992D1B0BFEDCD5926EBB4032DF2DA3C")
    @Override
    public int getSpanTypeId() {
        int var98F88D0991B454468A3F264C2766096B_449739656 = (TextUtils.SUGGESTION_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484365822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484365822;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.407 -0400", hash_original_method = "DEEF8A91A4946D9B043EDA2DAC8F9CA5", hash_generated_method = "4F866B5BD991EC928687F152CBA20F2D")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof SuggestionSpan)        
        {
            boolean var3CB4120123C0F125CFE867A3275F21CA_1391405609 = (((SuggestionSpan)o).hashCode() == mHashCode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615220721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_615220721;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1405143211 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749471194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749471194;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.407 -0400", hash_original_method = "D7D5E8B622FC6A9CB6E203DCD79B8799", hash_generated_method = "46EC4864B9E9F6BF0B5C29358A35E416")
    @Override
    public int hashCode() {
        int varD1324C907E3C733CA9E17C8F90836F79_1198432243 = (mHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509010666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509010666;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static int hashCodeInternal(String[] suggestions, String locale,
            String notificationTargetClassName) {
        return Arrays.hashCode(new Object[] {Long.valueOf(SystemClock.uptimeMillis()), suggestions,
                locale, notificationTargetClassName});
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.408 -0400", hash_original_method = "FC1F2F33C12EF11918B48BC18977D662", hash_generated_method = "8EBC39D59069EE04A1B95B4E754574FE")
    @Override
    public void updateDrawState(TextPaint tp) {
        addTaint(tp.getTaint());
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
    if(easy)        
        {
    if(!misspelled)            
            {
                tp.setUnderlineText(mEasyCorrectUnderlineColor, mEasyCorrectUnderlineThickness);
            } 
            else
    if(tp.underlineColor == 0)            
            {
                tp.setUnderlineText(mMisspelledUnderlineColor, mMisspelledUnderlineThickness);
            } 
        } 
        else
    if(autoCorrection)        
        {
            tp.setUnderlineText(mAutoCorrectionUnderlineColor, mAutoCorrectionUnderlineThickness);
        } 
        
        
        
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.408 -0400", hash_original_method = "6F69CCF79C26CDB5AAE1758554866B40", hash_generated_method = "21D4C0BA821D19EE2AE688F23DA5C3AA")
    public int getUnderlineColor() {
        final boolean misspelled = (mFlags & FLAG_MISSPELLED) != 0;
        final boolean easy = (mFlags & FLAG_EASY_CORRECT) != 0;
        final boolean autoCorrection = (mFlags & FLAG_AUTO_CORRECTION) != 0;
    if(easy)        
        {
    if(!misspelled)            
            {
                int varBDCD49C66A8BA2B78EE398B7616EB873_1114067380 = (mEasyCorrectUnderlineColor);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949536895 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949536895;
            } 
            else
            {
                int var791E2C995AC7D9DEC6A8E948883CF1B2_75331746 = (mMisspelledUnderlineColor);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27368961 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27368961;
            } 
        } 
        else
    if(autoCorrection)        
        {
            int var5D1932BD724A70EE08630ECDFD073593_1142463373 = (mAutoCorrectionUnderlineColor);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480525372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480525372;
        } 
        int varCFCD208495D565EF66E7DFF9F98764DA_1726952594 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921167283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921167283;
        
        
        
        
        
            
                
            
                
            
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.409 -0400", hash_original_field = "7555E0084C8700A4BB6F3718BE46674D", hash_generated_field = "1D7B974E27680F135303E920BF84BF8D")

    public static final int FLAG_EASY_CORRECT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.409 -0400", hash_original_field = "A708EACC955FF35E5E6FB7F37EF6CC52", hash_generated_field = "DBA29D2759519352B179244965765408")

    public static final int FLAG_MISSPELLED = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "9715ECF168FACCF4AF16F8046A2CEB59", hash_generated_field = "711B1FB5ACCA563596236E3C086B8CA7")

    public static final int FLAG_AUTO_CORRECTION = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "C0D336A66C280BCE4B9B488359B6B588", hash_generated_field = "6BE9D6FF7EA9AFB0E6D33742E0643DAC")

    public static final String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "B695D07CF613C9C38E2442FC9305663B", hash_generated_field = "1F2C143752BB6DB9A8D30C9B306CEF3A")

    public static final String SUGGESTION_SPAN_PICKED_AFTER = "after";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "C1B859A532523D319E0D2C0C2CFD7B36", hash_generated_field = "9184FE4582FFB6A9866F321FBE911D2B")

    public static final String SUGGESTION_SPAN_PICKED_BEFORE = "before";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "22B1E822A3E96026E3585C9DCAA2CBEA", hash_generated_field = "3AD3422034F9C2094284D22AF1FFB1F3")

    public static final String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "AF6244CA0A343D2679CCD6D79405434C", hash_generated_field = "AF65BC39A44E7D93F9365DF1A5F722E1")

    public static final int SUGGESTIONS_MAX_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.410 -0400", hash_original_field = "D7626C6BE860F29C41E36E880CF9437E", hash_generated_field = "368BEC2D23997E875633673B3BD26F7D")

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

