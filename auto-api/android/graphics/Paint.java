package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

public class Paint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.162 -0400", hash_original_field = "D43E64E8DB23D8105EFCFFDFE2703E5E", hash_generated_field = "F9F1B9FB44729EA466DD33DE16A3AB10")

    public int mNativePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.163 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.163 -0400", hash_original_field = "B084716E2B957889ADD456E706B0D908", hash_generated_field = "30CA93EA0A1FDD848EE36D39E7D9E77B")

    private MaskFilter mMaskFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.163 -0400", hash_original_field = "0C964CB18CE5DB6CE248155A69D05850", hash_generated_field = "0970365855BAEB3B93B55E917D7BB807")

    private PathEffect mPathEffect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.163 -0400", hash_original_field = "B8E4807966280C43A678FFEA169DB2BF", hash_generated_field = "E15971EFBFBD92787A66981AB256F5C2")

    private Rasterizer mRasterizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.163 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "B1952C618C8BBD071ACDDBA82DB64026")

    private Shader mShader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "234D9F5A4F790A70ADC301ADC43BEEC1")

    private Typeface mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "28B87225BC1D2D4DDEE55BD61F984139", hash_generated_field = "E20BD0A091050F1F29128E6A824DE542")

    private Xfermode mXfermode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "AC29C10FA86008DC70760D09ABDD8975", hash_generated_field = "41C5D1021B750266A4ADC951970465D5")

    private boolean mHasCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "54878B6CF92B4C69D84F841DD1E3B67B", hash_generated_field = "B75D80F84935274D46B49A2A5EE4E0AB")

    private float mCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "080CF1326240F02CC5113284F8866075", hash_generated_field = "3B482C031B54D0585FB747229A42223A")

    private float mInvCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "5ECD95A3EBAA8F5228C8769A496F581F", hash_generated_field = "79432E7E02F51603141CA873F5DC70EF")

    public boolean hasShadow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "0576421823B0FE164EF79686754E859C", hash_generated_field = "5B09CAB9CB4DEB539F28464A0A9AF847")

    public float shadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.164 -0400", hash_original_field = "B56AC33C6797CC57B93060FF92EE1F0E", hash_generated_field = "E8741946672ABFDF9B3AFE7FAFACA993")

    public float shadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.168 -0400", hash_original_field = "AEE37AD6DA942F6F9C5FBE1BCF65AC67", hash_generated_field = "584D14064094F2C1B9BDB348A4C8065C")

    public float shadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.168 -0400", hash_original_field = "D14A83C55DBA07A19E2627BF8C98AFB6", hash_generated_field = "F7019584388E8E0B6A5FA29A5D1D5111")

    public int shadowColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.168 -0400", hash_original_field = "ABA7903F07E8350F4F66A9F81A266F4F", hash_generated_field = "EC215250783F837A7E2BDA6A9E3ACA2D")

    public int mBidiFlags = BIDI_DEFAULT_LTR;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.169 -0400", hash_original_method = "07976DE00CD3F977E8ACA514AAEDE967", hash_generated_method = "2E92EC59FFA72681E3F4ECFD5F5383AA")
    public  Paint() {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.169 -0400", hash_original_method = "DD18D0561860908DF0D4B7BC76B2B3D2", hash_generated_method = "7A0C07D3AEB4DA59EEE3702F868EFE69")
    public  Paint(int flags) {
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        addTaint(flags);
        // ---------- Original Method ----------
        //mNativePaint = native_init();
        //setFlags(flags | DEFAULT_PAINT_FLAGS);
        //mCompatScaling = mInvCompatScaling = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.184 -0400", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "1E0CEE6CD795EABAB79C1575708D48D5")
    public  Paint(Paint paint) {
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
        // ---------- Original Method ----------
        //mNativePaint = native_initWithPaint(paint.mNativePaint);
        //setClassVariablesFrom(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.185 -0400", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "4EC68B4DCAA133DD09A2D2EB6717EEB2")
    public void reset() {
        native_reset(mNativePaint);
        setFlags(DEFAULT_PAINT_FLAGS);
        mHasCompatScaling = false;
        mCompatScaling = mInvCompatScaling = 1;
        mBidiFlags = BIDI_DEFAULT_LTR;
        // ---------- Original Method ----------
        //native_reset(mNativePaint);
        //setFlags(DEFAULT_PAINT_FLAGS);
        //mHasCompatScaling = false;
        //mCompatScaling = mInvCompatScaling = 1;
        //mBidiFlags = BIDI_DEFAULT_LTR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.186 -0400", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "F99284F4099EF5836A6E51FA357ED689")
    public void set(Paint src) {
        {
            native_set(mNativePaint, src.mNativePaint);
            setClassVariablesFrom(src);
        } //End block
        addTaint(src.getTaint());
        // ---------- Original Method ----------
        //if (this != src) {
            //native_set(mNativePaint, src.mNativePaint);
            //setClassVariablesFrom(src);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.214 -0400", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "BD7871E3A37A563592B6AC84BB6E6C1C")
    private void setClassVariablesFrom(Paint paint) {
        mColorFilter = paint.mColorFilter;
        mMaskFilter = paint.mMaskFilter;
        mPathEffect = paint.mPathEffect;
        mRasterizer = paint.mRasterizer;
        mShader = paint.mShader;
        mTypeface = paint.mTypeface;
        mXfermode = paint.mXfermode;
        mHasCompatScaling = paint.mHasCompatScaling;
        mCompatScaling = paint.mCompatScaling;
        mInvCompatScaling = paint.mInvCompatScaling;
        hasShadow = paint.hasShadow;
        shadowDx = paint.shadowDx;
        shadowDy = paint.shadowDy;
        shadowRadius = paint.shadowRadius;
        shadowColor = paint.shadowColor;
        mBidiFlags = paint.mBidiFlags;
        // ---------- Original Method ----------
        //mColorFilter = paint.mColorFilter;
        //mMaskFilter = paint.mMaskFilter;
        //mPathEffect = paint.mPathEffect;
        //mRasterizer = paint.mRasterizer;
        //mShader = paint.mShader;
        //mTypeface = paint.mTypeface;
        //mXfermode = paint.mXfermode;
        //mHasCompatScaling = paint.mHasCompatScaling;
        //mCompatScaling = paint.mCompatScaling;
        //mInvCompatScaling = paint.mInvCompatScaling;
        //hasShadow = paint.hasShadow;
        //shadowDx = paint.shadowDx;
        //shadowDy = paint.shadowDy;
        //shadowRadius = paint.shadowRadius;
        //shadowColor = paint.shadowColor;
        //mBidiFlags = paint.mBidiFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.215 -0400", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "80AF4F2346B332217D15D4ADF4D7B10B")
    public void setCompatibilityScaling(float factor) {
        {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } //End block
        {
            mHasCompatScaling = true;
            mCompatScaling = factor;
            mInvCompatScaling = 1.0f/factor;
        } //End block
        // ---------- Original Method ----------
        //if (factor == 1.0) {
            //mHasCompatScaling = false;
            //mCompatScaling = mInvCompatScaling = 1.0f;
        //} else {
            //mHasCompatScaling = true;
            //mCompatScaling = factor;
            //mInvCompatScaling = 1.0f/factor;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.216 -0400", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "5264E1601A22E0BAAF10506EC284EAF3")
    public int getBidiFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767222867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767222867;
        // ---------- Original Method ----------
        //return mBidiFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.231 -0400", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "A20F8252F7C80C1DD2CD8D7678A19D6B")
    public void setBidiFlags(int flags) {
        flags &= BIDI_FLAG_MASK;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown bidi flag: " + flags);
        } //End block
        mBidiFlags = flags;
        // ---------- Original Method ----------
        //flags &= BIDI_FLAG_MASK;
        //if (flags > BIDI_MAX_FLAG_VALUE) {
            //throw new IllegalArgumentException("unknown bidi flag: " + flags);
        //}
        //mBidiFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.232 -0400", hash_original_method = "1AEF3AE96B7B0567703FA6E8804026B1", hash_generated_method = "D2C100F6282D0BD1799845D569781323")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378721315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378721315;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.233 -0400", hash_original_method = "7E0C8B4D00EF46DF7C96B7FEFE972867", hash_generated_method = "E81D91BA95CE017C8A6AE2CF5F166A3B")
    public void setFlags(int flags) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.233 -0400", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "4FF7B015DF6C1E6AE617B9D85417D3C5")
    public int getHinting() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204220164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204220164;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.233 -0400", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "BEF76864791FDB477DCC8963BCE4B764")
    public void setHinting(int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.240 -0400", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "4CB7E304300AE3D053E75CD69DAD679F")
    public final boolean isAntiAlias() {
        boolean var0A7E8DB3C2F27E0E70AEB7D3C4714849_1719461708 = ((getFlags() & ANTI_ALIAS_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220701505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220701505;
        // ---------- Original Method ----------
        //return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.240 -0400", hash_original_method = "8B9E1DF7E3F10B045A1C3ED5825D806F", hash_generated_method = "969C9AD79C602B0B74504E6ADC0CDA95")
    public void setAntiAlias(boolean aa) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.244 -0400", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "7A65C9FB2492B3F3C48BD7DB8908FF71")
    public final boolean isDither() {
        boolean var5399F5810C06B5F2B5007E7BFE0F0E00_1672063959 = ((getFlags() & DITHER_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_525648414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_525648414;
        // ---------- Original Method ----------
        //return (getFlags() & DITHER_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.260 -0400", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "885C8677A0ED029E797386D2040088D8")
    public void setDither(boolean dither) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.261 -0400", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "FF2C883ACF51036CEF41B673ADB00227")
    public final boolean isLinearText() {
        boolean var79DAF9C030CBADD6B91BC7DC15DBE862_1245761567 = ((getFlags() & LINEAR_TEXT_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974331110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974331110;
        // ---------- Original Method ----------
        //return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.261 -0400", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "018998AB05D2191EBA074C9F705B430C")
    public void setLinearText(boolean linearText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.262 -0400", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "2082BA7CB2EE409B915DCF48619BC767")
    public final boolean isSubpixelText() {
        boolean varA843E4D86CA73BCC98350551BD14C6C0_158382047 = ((getFlags() & SUBPIXEL_TEXT_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423628975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423628975;
        // ---------- Original Method ----------
        //return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.262 -0400", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "B34B82250E86FDB7DB09A047E0B9AB1E")
    public void setSubpixelText(boolean subpixelText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.262 -0400", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "88799CCEE77102CE5A93C4AF92E593CF")
    public final boolean isUnderlineText() {
        boolean varE927F016983A6B322D1DB9E7B9D956EF_1067759342 = ((getFlags() & UNDERLINE_TEXT_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208201142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208201142;
        // ---------- Original Method ----------
        //return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.263 -0400", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "417886D7D175F8B8D55EE0D90CFAE4FA")
    public void setUnderlineText(boolean underlineText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.265 -0400", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "F26D9D5D43A61E99ED3B2B228A18BAAA")
    public final boolean isStrikeThruText() {
        boolean var7E7F54E434CA51F1CAA8093A60301247_1605189610 = ((getFlags() & STRIKE_THRU_TEXT_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619412360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619412360;
        // ---------- Original Method ----------
        //return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.275 -0400", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "FB6506C20923BFB227903FF1094AB4FB")
    public void setStrikeThruText(boolean strikeThruText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.275 -0400", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "CA53E9C144A49C46A4AA2174C1289F60")
    public final boolean isFakeBoldText() {
        boolean varBA3E1460985702B77EDFEB4E358B3B6A_1465937787 = ((getFlags() & FAKE_BOLD_TEXT_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382976391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382976391;
        // ---------- Original Method ----------
        //return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.278 -0400", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "69207AE83514DFB7DD01C9111E4B061D")
    public void setFakeBoldText(boolean fakeBoldText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.287 -0400", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "E42AC3974F7035145D43CBF0FD791B7B")
    public final boolean isFilterBitmap() {
        boolean var8F4FACEC12D1030ECB4A927B5426F3CC_107406728 = ((getFlags() & FILTER_BITMAP_FLAG) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971160607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971160607;
        // ---------- Original Method ----------
        //return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.287 -0400", hash_original_method = "B8C11CD7111D9BC247774CFB44C7A8B0", hash_generated_method = "72A4AA63A3BDB8FE50798AE60EFC3156")
    public void setFilterBitmap(boolean filter) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.288 -0400", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "0CBC9DBE58FF6547130C599F50162918")
    public Style getStyle() {
        Style varB4EAC82CA7396A68D541C85D26508E83_1181546704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1181546704 = sStyleArray[native_getStyle(mNativePaint)];
        varB4EAC82CA7396A68D541C85D26508E83_1181546704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1181546704;
        // ---------- Original Method ----------
        //return sStyleArray[native_getStyle(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.289 -0400", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "A3CD231564AE9D96957E5C796740F44F")
    public void setStyle(Style style) {
        native_setStyle(mNativePaint, style.nativeInt);
        addTaint(style.getTaint());
        // ---------- Original Method ----------
        //native_setStyle(mNativePaint, style.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.308 -0400", hash_original_method = "A6843949A5740747763B245A4340955B", hash_generated_method = "60BB0E9E72DB12FD97A929ECF098F6C2")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803024104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803024104;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.308 -0400", hash_original_method = "6B0B967C1DC4D48EE66A1A874887BE3F", hash_generated_method = "359EC0CDBCF6D3FF497E0AB9CE671581")
    public void setColor(int color) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.308 -0400", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "DD1D19A016D8D37A09E219D9CE91829F")
    public int getAlpha() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929385875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929385875;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.309 -0400", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "319BF4CF7F9EF61753405A8B0B105272")
    public void setAlpha(int a) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.309 -0400", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "229C04BDCD75A76996F0587C993C0385")
    public void setARGB(int a, int r, int g, int b) {
        setColor((a << 24) | (r << 16) | (g << 8) | b);
        addTaint(a);
        addTaint(r);
        addTaint(g);
        addTaint(b);
        // ---------- Original Method ----------
        //setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.310 -0400", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "748A3A65B83CD8AF67C9F34E664AD257")
    public float getStrokeWidth() {
        float var546ADE640B6EDFBC8A086EF31347E768_200328302 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_200328302;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.310 -0400", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "564DC2A484C3EEE36BA29C2660B22AD8")
    public void setStrokeWidth(float width) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.311 -0400", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "7F9D48A273D28639CF11F739FA2460D6")
    public float getStrokeMiter() {
        float var546ADE640B6EDFBC8A086EF31347E768_735459995 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_735459995;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.311 -0400", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "1944134F0761932CBCD4B9547BA850AF")
    public void setStrokeMiter(float miter) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.327 -0400", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "E874812CC0AF60967EEC5B4CD6F722F6")
    public Cap getStrokeCap() {
        Cap varB4EAC82CA7396A68D541C85D26508E83_1692356252 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1692356252 = sCapArray[native_getStrokeCap(mNativePaint)];
        varB4EAC82CA7396A68D541C85D26508E83_1692356252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1692356252;
        // ---------- Original Method ----------
        //return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.332 -0400", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "186FBCA98E34E24406C269CCB5881F97")
    public void setStrokeCap(Cap cap) {
        native_setStrokeCap(mNativePaint, cap.nativeInt);
        addTaint(cap.getTaint());
        // ---------- Original Method ----------
        //native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.333 -0400", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "BC89E609C59AEFE40359D150574CE55B")
    public Join getStrokeJoin() {
        Join varB4EAC82CA7396A68D541C85D26508E83_680229504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680229504 = sJoinArray[native_getStrokeJoin(mNativePaint)];
        varB4EAC82CA7396A68D541C85D26508E83_680229504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680229504;
        // ---------- Original Method ----------
        //return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.350 -0400", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "24A88653DE5A6EF41BE4C2AC012987A7")
    public void setStrokeJoin(Join join) {
        native_setStrokeJoin(mNativePaint, join.nativeInt);
        addTaint(join.getTaint());
        // ---------- Original Method ----------
        //native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.351 -0400", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "4395AAD7D60B7100BF493F9C3181BE04")
    public boolean getFillPath(Path src, Path dst) {
        boolean varD76A52FF867281710D540951850A2520_1923117925 = (native_getFillPath(mNativePaint, src.ni(), dst.ni()));
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952737839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_952737839;
        // ---------- Original Method ----------
        //return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.352 -0400", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "463382C157936988EC9CCEFD0901F034")
    public Shader getShader() {
        Shader varB4EAC82CA7396A68D541C85D26508E83_801848943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_801848943 = mShader;
        varB4EAC82CA7396A68D541C85D26508E83_801848943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_801848943;
        // ---------- Original Method ----------
        //return mShader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.363 -0400", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "50CCF5F0DF0F5640DD6971458FB6AF55")
    public Shader setShader(Shader shader) {
        Shader varB4EAC82CA7396A68D541C85D26508E83_1733400713 = null; //Variable for return #1
        int shaderNative;
        shaderNative = 0;
        shaderNative = shader.native_instance;
        native_setShader(mNativePaint, shaderNative);
        mShader = shader;
        varB4EAC82CA7396A68D541C85D26508E83_1733400713 = shader;
        varB4EAC82CA7396A68D541C85D26508E83_1733400713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1733400713;
        // ---------- Original Method ----------
        //int shaderNative = 0;
        //if (shader != null)
            //shaderNative = shader.native_instance;
        //native_setShader(mNativePaint, shaderNative);
        //mShader = shader;
        //return shader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.364 -0400", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "658185E098C5FA62D992DFB760350A88")
    public ColorFilter getColorFilter() {
        ColorFilter varB4EAC82CA7396A68D541C85D26508E83_199753081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_199753081 = mColorFilter;
        varB4EAC82CA7396A68D541C85D26508E83_199753081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_199753081;
        // ---------- Original Method ----------
        //return mColorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.366 -0400", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "D094BD7C5A782A2DC3CC78B47D0AF2D6")
    public ColorFilter setColorFilter(ColorFilter filter) {
        ColorFilter varB4EAC82CA7396A68D541C85D26508E83_480849897 = null; //Variable for return #1
        int filterNative;
        filterNative = 0;
        filterNative = filter.native_instance;
        native_setColorFilter(mNativePaint, filterNative);
        mColorFilter = filter;
        varB4EAC82CA7396A68D541C85D26508E83_480849897 = filter;
        varB4EAC82CA7396A68D541C85D26508E83_480849897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480849897;
        // ---------- Original Method ----------
        //int filterNative = 0;
        //if (filter != null)
            //filterNative = filter.native_instance;
        //native_setColorFilter(mNativePaint, filterNative);
        //mColorFilter = filter;
        //return filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.366 -0400", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "2D580ECEDF309639E3F8598B9B272C53")
    public Xfermode getXfermode() {
        Xfermode varB4EAC82CA7396A68D541C85D26508E83_384553581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_384553581 = mXfermode;
        varB4EAC82CA7396A68D541C85D26508E83_384553581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_384553581;
        // ---------- Original Method ----------
        //return mXfermode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.399 -0400", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "61A31406CB6408A58A21A70B93E523B8")
    public Xfermode setXfermode(Xfermode xfermode) {
        Xfermode varB4EAC82CA7396A68D541C85D26508E83_1551148620 = null; //Variable for return #1
        int xfermodeNative;
        xfermodeNative = 0;
        xfermodeNative = xfermode.native_instance;
        native_setXfermode(mNativePaint, xfermodeNative);
        mXfermode = xfermode;
        varB4EAC82CA7396A68D541C85D26508E83_1551148620 = xfermode;
        varB4EAC82CA7396A68D541C85D26508E83_1551148620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1551148620;
        // ---------- Original Method ----------
        //int xfermodeNative = 0;
        //if (xfermode != null)
            //xfermodeNative = xfermode.native_instance;
        //native_setXfermode(mNativePaint, xfermodeNative);
        //mXfermode = xfermode;
        //return xfermode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.400 -0400", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "296B823B4CFCD0A924A635F2950C0407")
    public PathEffect getPathEffect() {
        PathEffect varB4EAC82CA7396A68D541C85D26508E83_1373214432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1373214432 = mPathEffect;
        varB4EAC82CA7396A68D541C85D26508E83_1373214432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1373214432;
        // ---------- Original Method ----------
        //return mPathEffect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.405 -0400", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "B27723AB2AACF499005ACD9B458553C6")
    public PathEffect setPathEffect(PathEffect effect) {
        PathEffect varB4EAC82CA7396A68D541C85D26508E83_434772663 = null; //Variable for return #1
        int effectNative;
        effectNative = 0;
        {
            effectNative = effect.native_instance;
        } //End block
        native_setPathEffect(mNativePaint, effectNative);
        mPathEffect = effect;
        varB4EAC82CA7396A68D541C85D26508E83_434772663 = effect;
        varB4EAC82CA7396A68D541C85D26508E83_434772663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434772663;
        // ---------- Original Method ----------
        //int effectNative = 0;
        //if (effect != null) {
            //effectNative = effect.native_instance;
        //}
        //native_setPathEffect(mNativePaint, effectNative);
        //mPathEffect = effect;
        //return effect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.423 -0400", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "C9BEA654B4D2D18B09F60AEA07AAAE1E")
    public MaskFilter getMaskFilter() {
        MaskFilter varB4EAC82CA7396A68D541C85D26508E83_141741025 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_141741025 = mMaskFilter;
        varB4EAC82CA7396A68D541C85D26508E83_141741025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141741025;
        // ---------- Original Method ----------
        //return mMaskFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.424 -0400", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "8B134FC6DD850D2AD4E761A1A1D0BEF2")
    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        MaskFilter varB4EAC82CA7396A68D541C85D26508E83_179455250 = null; //Variable for return #1
        int maskfilterNative;
        maskfilterNative = 0;
        {
            maskfilterNative = maskfilter.native_instance;
        } //End block
        native_setMaskFilter(mNativePaint, maskfilterNative);
        mMaskFilter = maskfilter;
        varB4EAC82CA7396A68D541C85D26508E83_179455250 = maskfilter;
        varB4EAC82CA7396A68D541C85D26508E83_179455250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179455250;
        // ---------- Original Method ----------
        //int maskfilterNative = 0;
        //if (maskfilter != null) {
            //maskfilterNative = maskfilter.native_instance;
        //}
        //native_setMaskFilter(mNativePaint, maskfilterNative);
        //mMaskFilter = maskfilter;
        //return maskfilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.427 -0400", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "BE46AD202895A8929A2F297919158D9A")
    public Typeface getTypeface() {
        Typeface varB4EAC82CA7396A68D541C85D26508E83_649750259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_649750259 = mTypeface;
        varB4EAC82CA7396A68D541C85D26508E83_649750259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_649750259;
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.442 -0400", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "9D5AE843A547FA82B971C8D4889D1FA1")
    public Typeface setTypeface(Typeface typeface) {
        Typeface varB4EAC82CA7396A68D541C85D26508E83_1630369245 = null; //Variable for return #1
        int typefaceNative;
        typefaceNative = 0;
        {
            typefaceNative = typeface.native_instance;
        } //End block
        native_setTypeface(mNativePaint, typefaceNative);
        mTypeface = typeface;
        varB4EAC82CA7396A68D541C85D26508E83_1630369245 = typeface;
        varB4EAC82CA7396A68D541C85D26508E83_1630369245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1630369245;
        // ---------- Original Method ----------
        //int typefaceNative = 0;
        //if (typeface != null) {
            //typefaceNative = typeface.native_instance;
        //}
        //native_setTypeface(mNativePaint, typefaceNative);
        //mTypeface = typeface;
        //return typeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.449 -0400", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "174DB04099AD2DB478046B91F723216E")
    public Rasterizer getRasterizer() {
        Rasterizer varB4EAC82CA7396A68D541C85D26508E83_1963801232 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1963801232 = mRasterizer;
        varB4EAC82CA7396A68D541C85D26508E83_1963801232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1963801232;
        // ---------- Original Method ----------
        //return mRasterizer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.472 -0400", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "CE403F71887CF51946062709B5541165")
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        Rasterizer varB4EAC82CA7396A68D541C85D26508E83_1521802612 = null; //Variable for return #1
        int rasterizerNative;
        rasterizerNative = 0;
        {
            rasterizerNative = rasterizer.native_instance;
        } //End block
        native_setRasterizer(mNativePaint, rasterizerNative);
        mRasterizer = rasterizer;
        varB4EAC82CA7396A68D541C85D26508E83_1521802612 = rasterizer;
        varB4EAC82CA7396A68D541C85D26508E83_1521802612.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521802612;
        // ---------- Original Method ----------
        //int rasterizerNative = 0;
        //if (rasterizer != null) {
            //rasterizerNative = rasterizer.native_instance;
        //}
        //native_setRasterizer(mNativePaint, rasterizerNative);
        //mRasterizer = rasterizer;
        //return rasterizer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.473 -0400", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "890115DE943F753280243985FB0CA4B9")
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        hasShadow = radius > 0.0f;
        shadowRadius = radius;
        shadowDx = dx;
        shadowDy = dy;
        shadowColor = color;
        nSetShadowLayer(radius, dx, dy, color);
        // ---------- Original Method ----------
        //hasShadow = radius > 0.0f;
        //shadowRadius = radius;
        //shadowDx = dx;
        //shadowDy = dy;
        //shadowColor = color;
        //nSetShadowLayer(radius, dx, dy, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.474 -0400", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "DE3CFB24C60627249AA98DBC6D18C4A8")
    private void nSetShadowLayer(float radius, float dx, float dy, int color) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.478 -0400", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "69C41E78339835181B7060E466C37E39")
    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
        // ---------- Original Method ----------
        //hasShadow = false;
        //nSetShadowLayer(0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.479 -0400", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "F787273EF87AB74D27303F5F28285A4E")
    public Align getTextAlign() {
        Align varB4EAC82CA7396A68D541C85D26508E83_1903003436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1903003436 = sAlignArray[native_getTextAlign(mNativePaint)];
        varB4EAC82CA7396A68D541C85D26508E83_1903003436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903003436;
        // ---------- Original Method ----------
        //return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.486 -0400", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "EC12567627067EC06BB38C70707493C5")
    public void setTextAlign(Align align) {
        native_setTextAlign(mNativePaint, align.nativeInt);
        addTaint(align.getTaint());
        // ---------- Original Method ----------
        //native_setTextAlign(mNativePaint, align.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.487 -0400", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "AD95306C462AB0A419570C9FF72882F0")
    public float getTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_2011936784 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2011936784;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.498 -0400", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "D150D3B101DE8920A691C9CE66A42B08")
    public void setTextSize(float textSize) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.500 -0400", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "42EDBAA474378E85A32656C0F416A905")
    public float getTextScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_2146654796 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2146654796;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.504 -0400", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "75A2C46EA134EC88EFC16602B5352C8F")
    public void setTextScaleX(float scaleX) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.505 -0400", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "08469B0758CC8DE5E307C4DCAB434E95")
    public float getTextSkewX() {
        float var546ADE640B6EDFBC8A086EF31347E768_759194720 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_759194720;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.505 -0400", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "94DEC1BD4F69C9C57DAD152D853AE23B")
    public void setTextSkewX(float skewX) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.505 -0400", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "D77A74A3E74E3D04CF4D5140B7C6351A")
    public float ascent() {
        float var546ADE640B6EDFBC8A086EF31347E768_1885301726 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1885301726;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.506 -0400", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "2642A467C67BEEDDB0F1F211931B39FB")
    public float descent() {
        float var546ADE640B6EDFBC8A086EF31347E768_1171580976 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1171580976;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.506 -0400", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "1D0E6C7F3A1787C0631F834EE6CD9BB3")
    public float getFontMetrics(FontMetrics metrics) {
        float var546ADE640B6EDFBC8A086EF31347E768_1486834547 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1486834547;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.521 -0400", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "34E001408F9D31AA88F8799C044B941A")
    public FontMetrics getFontMetrics() {
        FontMetrics varB4EAC82CA7396A68D541C85D26508E83_1008290367 = null; //Variable for return #1
        FontMetrics fm;
        fm = new FontMetrics();
        getFontMetrics(fm);
        varB4EAC82CA7396A68D541C85D26508E83_1008290367 = fm;
        varB4EAC82CA7396A68D541C85D26508E83_1008290367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008290367;
        // ---------- Original Method ----------
        //FontMetrics fm = new FontMetrics();
        //getFontMetrics(fm);
        //return fm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.521 -0400", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "2D7AA884D33A1CEF64DEEB4650CD4980")
    public int getFontMetricsInt(FontMetricsInt fmi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995365073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995365073;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.523 -0400", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "221F4FA085ABAC09C81843AC28AADD4B")
    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt varB4EAC82CA7396A68D541C85D26508E83_91437945 = null; //Variable for return #1
        FontMetricsInt fm;
        fm = new FontMetricsInt();
        getFontMetricsInt(fm);
        varB4EAC82CA7396A68D541C85D26508E83_91437945 = fm;
        varB4EAC82CA7396A68D541C85D26508E83_91437945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_91437945;
        // ---------- Original Method ----------
        //FontMetricsInt fm = new FontMetricsInt();
        //getFontMetricsInt(fm);
        //return fm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.524 -0400", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "9B97BD51F582EDE055914C979998CE1A")
    public float getFontSpacing() {
        float varE2260D5039D2A3988D3A0EAEA55ED628_262272344 = (getFontMetrics(null));
        float var546ADE640B6EDFBC8A086EF31347E768_651046403 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_651046403;
        // ---------- Original Method ----------
        //return getFontMetrics(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.539 -0400", hash_original_method = "4B30EE6B8828803214F6472A454BF7F0", hash_generated_method = "7A5964C5BAAC69967B4B73156D02CB96")
    public float measureText(char[] text, int index, int count) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            float var204A124D7256F67576DEC177530E8CA9_803834693 = (native_measureText(text, index, count));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text, index, count);
        setTextSize(oldSize);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        float var546ADE640B6EDFBC8A086EF31347E768_1652924115 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1652924115;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if ((index | count) < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (text.length == 0 || count == 0) {
            //return 0f;
        //}
        //if (!mHasCompatScaling) {
            //return native_measureText(text, index, count);
        //}
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //float w = native_measureText(text, index, count);
        //setTextSize(oldSize);
        //return w*mInvCompatScaling;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.560 -0400", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "00704CBE7086057E6580603D53B1EA3C")
    private float native_measureText(char[] text, int index, int count) {
        float var546ADE640B6EDFBC8A086EF31347E768_1808698601 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1808698601;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.561 -0400", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "E37A2D385615A6F056A38A03367BD0A6")
    public float measureText(String text, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_227996500 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1689030191 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6C5BF54DC4892C8073B52E95C3AE2BA1_437366055 = (native_measureText(text, start, end));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text, start, end);
        setTextSize(oldSize);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        float var546ADE640B6EDFBC8A086EF31347E768_1676267841 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1676267841;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (text.length() == 0 || start == end) {
            //return 0f;
        //}
        //if (!mHasCompatScaling) {
            //return native_measureText(text, start, end);
        //}
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //float w = native_measureText(text, start, end);
        //setTextSize(oldSize);
        //return w*mInvCompatScaling;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.562 -0400", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "4B651907834C4675BA995C8128A9D500")
    private float native_measureText(String text, int start, int end) {
        float var546ADE640B6EDFBC8A086EF31347E768_818939105 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_818939105;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.571 -0400", hash_original_method = "C4C224EF0059A9B14092F4800A14BAD4", hash_generated_method = "1033C0280604F4D7CB22D8D1348EF2C1")
    public float measureText(String text) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_2101208622 = (text.length() == 0);
        } //End collapsed parenthetic
        float varDE0E49D527135C371027DDD371BB7F5C_1411144112 = (native_measureText(text));
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text);
        setTextSize(oldSize);
        addTaint(text.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1660158588 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1660158588;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if (text.length() == 0) {
            //return 0f;
        //}
        //if (!mHasCompatScaling) return native_measureText(text);
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //float w = native_measureText(text);
        //setTextSize(oldSize);
        //return w*mInvCompatScaling;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.572 -0400", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "B24DD460854F0A7DBEBC2327B6E3BA4E")
    private float native_measureText(String text) {
        float var546ADE640B6EDFBC8A086EF31347E768_2056538311 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2056538311;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.595 -0400", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "30E645D8D058FFCFE0CF17FE1D401579")
    public float measureText(CharSequence text, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_768277429 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_2086158283 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6236CF621C1135D29EAF7BA8ECD372DF_181785107 = (measureText((String)text, start, end));
        } //End block
        {
            float var315F7BA142189E74DF7F2C7E5074479F_1713523161 = (measureText(text.toString(), start, end));
        } //End block
        {
            float varC657CDB825AED28F6EC29BE81E302484_164334396 = (((GraphicsOperations)text).measureText(start, end, this));
        } //End block
        char[] buf;
        buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        float result;
        result = measureText(buf, 0, end - start);
        TemporaryBuffer.recycle(buf);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        float var546ADE640B6EDFBC8A086EF31347E768_1573701237 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1573701237;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.608 -0400", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "1B62641A9DA2664A5DAEE9C2D0885C7D")
    public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var0D5AAC51BA58AAF43D4E2413FC1B1BFC_2051104889 = (index < 0 || text.length - index < Math.abs(count));
            {
                if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            int var588A3E34EF8CC7F08FC2E9135A7530BE_190333940 = (native_breakText(text, index, count, maxWidth, measuredWidth));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        measuredWidth[0] *= mInvCompatScaling;
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(maxWidth);
        addTaint(measuredWidth[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869049168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869049168;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if (index < 0 || text.length - index < Math.abs(count)) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (text.length == 0 || count == 0) {
            //return 0;
        //}
        //if (!mHasCompatScaling) {
            //return native_breakText(text, index, count, maxWidth, measuredWidth);
        //}
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //int res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                //measuredWidth);
        //setTextSize(oldSize);
        //if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.615 -0400", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "AA1D75F93AC138000FCD0C74F9766A52")
    private int native_breakText(char[] text, int index, int count,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056035169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056035169;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.618 -0400", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "DBAE578BA81275D7E14D8AF69493581A")
    public int breakText(CharSequence text, int start, int end,
                         boolean measureForwards,
                         float maxWidth, float[] measuredWidth) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1667007870 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1761572765 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            boolean varB0BEAB0ED949D4AEA45AA76B829F1BBC_1314584230 = (start == 0 && text instanceof String && end == text.length());
            {
                int varE185824846EF4861F502E218B9EC6147_1821270078 = (breakText((String) text, measureForwards, maxWidth,
                             measuredWidth));
            } //End block
        } //End collapsed parenthetic
        char[] buf;
        buf = TemporaryBuffer.obtain(end - start);
        int result;
        TextUtils.getChars(text, start, end, buf, 0);
        {
            result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
        } //End block
        {
            result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
        } //End block
        TemporaryBuffer.recycle(buf);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(measureForwards);
        addTaint(maxWidth);
        addTaint(measuredWidth[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120905773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120905773;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.649 -0400", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "C908F3BDCDF2358B562EB67B68509FD2")
    public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_552305918 = (text.length() == 0);
        } //End collapsed parenthetic
        {
            int var69E64876CE9B422F0E0C81D70A86C49D_677334255 = (native_breakText(text, measureForwards, maxWidth, measuredWidth));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        measuredWidth[0] *= mInvCompatScaling;
        addTaint(text.getTaint());
        addTaint(measureForwards);
        addTaint(maxWidth);
        addTaint(measuredWidth[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446667670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446667670;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if (text.length() == 0) {
            //return 0;
        //}
        //if (!mHasCompatScaling) {
            //return native_breakText(text, measureForwards, maxWidth, measuredWidth);
        //}
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //int res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                //measuredWidth);
        //setTextSize(oldSize);
        //if (measuredWidth != null) measuredWidth[0] *= mInvCompatScaling;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.649 -0400", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "51D49D723D968CBD2506F2577E30DF19")
    private int native_breakText(String text, boolean measureForwards,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424896570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424896570;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.651 -0400", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "4076A197A169EB465C01D6750833DF98")
    public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            int var0DDD48BB4F1D26244DA9DA23FABF3401_532389778 = (native_getTextWidths(mNativePaint, text, index, count, widths));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_getTextWidths(mNativePaint, text, index, count, widths);
        setTextSize(oldSize);
        {
            int i;
            i = 0;
            {
                widths[i] *= mInvCompatScaling;
            } //End block
        } //End collapsed parenthetic
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(widths[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668975512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668975512;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if ((index | count) < 0 || index + count > text.length
                //|| count > widths.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (text.length == 0 || count == 0) {
            //return 0;
        //}
        //if (!mHasCompatScaling) {
            //return native_getTextWidths(mNativePaint, text, index, count, widths);
        //}
        //final float oldSize = getTextSize();
        //setTextSize(oldSize*mCompatScaling);
        //int res = native_getTextWidths(mNativePaint, text, index, count, widths);
        //setTextSize(oldSize);
        //for (int i=0; i<res; i++) {
            //widths[i] *= mInvCompatScaling;
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.692 -0400", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "AE5445A09218DDAB552C634FAF7AEF32")
    public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_2063331153 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_429309929 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int var5D20898AFE082D7DD346F7FD8F9F995D_709750763 = (getTextWidths((String) text, start, end, widths));
        } //End block
        {
            int var75159B67CD95E075E263ED8014FEA7F7_1365073676 = (getTextWidths(text.toString(), start, end, widths));
        } //End block
        {
            int var3A56B5BB09115C0B32F02D407185C205_873781736 = (((GraphicsOperations) text).getTextWidths(start, end,
                                                                 widths, this));
        } //End block
        char[] buf;
        buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        int result;
        result = getTextWidths(buf, 0, end - start, widths);
        TemporaryBuffer.recycle(buf);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(widths[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142103391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142103391;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.700 -0400", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "AF06488B6C01833B3921E710AE3E0584")
    public int getTextWidths(String text, int start, int end, float[] widths) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1869226807 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1258379217 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int varBEC4070C2642CF1E33A5E49FB207AF35_1582130136 = (native_getTextWidths(mNativePaint, text, start, end, widths));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_getTextWidths(mNativePaint, text, start, end, widths);
        setTextSize(oldSize);
        {
            int i;
            i = 0;
            {
                widths[i] *= mInvCompatScaling;
            } //End block
        } //End collapsed parenthetic
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(widths[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100988516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100988516;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.712 -0400", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "96A265DED74326836BFC534DE6E37AAD")
    public int getTextWidths(String text, float[] widths) {
        int var69BF8B4981D05965CD3D190575A4DA2F_1812503073 = (getTextWidths(text, 0, text.length(), widths));
        addTaint(text.getTaint());
        addTaint(widths[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113434601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113434601;
        // ---------- Original Method ----------
        //return getTextWidths(text, 0, text.length(), widths);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.714 -0400", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "B81B3CE47E6F85DC86AE8033C9A0AAAF")
    public int getTextGlyphs(String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean var48E9A0E727B5C13031610714A0F3121E_603549230 = ((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        int var5604385AD0B712150B1A0044CF957B36_1979239911 = (native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                flags, glyphs));
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(glyphs[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163693423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163693423;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new IllegalArgumentException("text cannot be null");
        //}
        //if (flags != DIRECTION_LTR && flags != DIRECTION_RTL) {
            //throw new IllegalArgumentException("unknown flags value: " + flags);
        //}
        //if ((start | end | contextStart | contextEnd | (end - start)
                //| (start - contextStart) | (contextEnd - end) | (text.length() - end)
                //| (text.length() - contextEnd)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (end - start > glyphs.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //return native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                //flags, glyphs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.731 -0400", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "065F9FB98E0E1AC5BFE5C78CC09CFE65")
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex) {
        float var13BD798480C8819B88B041244F6BBD82_782321652 = (getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 ));
        addTaint(chars[0]);
        addTaint(index);
        addTaint(count);
        addTaint(contextIndex);
        addTaint(contextCount);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_521467892 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_521467892;
        // ---------- Original Method ----------
        //return getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.753 -0400", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "2D8AAF753AA304AF50FD72098EC19616")
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex, int reserved) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            float var9858EF271DB73A9C5CCA76565BD23E23_542805231 = (native_getTextRunAdvances(mNativePaint, chars, index, count,
                    contextIndex, contextCount, flags, advances, advancesIndex, reserved));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float res;
        res = native_getTextRunAdvances(mNativePaint, chars, index, count,
                contextIndex, contextCount, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);
        {
            {
                int i, e;
                i = advancesIndex;
                e = i + count;
                {
                    advances[i] *= mInvCompatScaling;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(chars[0]);
        addTaint(index);
        addTaint(count);
        addTaint(contextIndex);
        addTaint(contextCount);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        addTaint(reserved);
        float var546ADE640B6EDFBC8A086EF31347E768_878176482 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_878176482;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.754 -0400", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "54BB48B348C390A9CF8E47EFF197CE3D")
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex) {
        float varE8CBEF545459E19AB4A39859AE3D961A_1542720021 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_191590910 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_191590910;
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.866 -0400", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "B888AF8D837F30FA647C90AA1F6963E9")
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex, int reserved) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_1428802436 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            float var53C63DC714A80E28C550C886BD1BF771_1749499137 = (getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var8A3BE239E9FF57407B2B40D6353ADC2C_964459485 = (getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var5ED11FC83FC39AEF2A8CAFC241CA9694_1943920418 = (((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this));
        } //End block
        {
            boolean var8A801BB93DFE1C696CAF475D2408E876_2020297281 = (text.length() == 0 || end == start);
        } //End collapsed parenthetic
        int contextLen;
        contextLen = contextEnd - contextStart;
        int len;
        len = end - start;
        char[] buf;
        buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        float result;
        result = getTextRunAdvances(buf, start - contextStart, len,
                0, contextLen, flags, advances, advancesIndex, reserved);
        TemporaryBuffer.recycle(buf);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        addTaint(reserved);
        float var546ADE640B6EDFBC8A086EF31347E768_1561610166 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1561610166;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.867 -0400", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "BAEA51B526BCCA26F62F0F04AB56A678")
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex) {
        float varE8CBEF545459E19AB4A39859AE3D961A_288033903 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1123787431 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1123787431;
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.889 -0400", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "10C95A026F1A722B09E6519F0471BC49")
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex, int reserved) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_2144940587 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_975839691 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float varA17437B07A992747272D690A911F4BE8_1482996774 = (native_getTextRunAdvances(mNativePaint, text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float totalAdvance;
        totalAdvance = native_getTextRunAdvances(mNativePaint, text, start, end,
                contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);
        {
            {
                int i, e;
                i = advancesIndex;
                e = i + (end - start);
                {
                    advances[i] *= mInvCompatScaling;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(advances[0]);
        addTaint(advancesIndex);
        addTaint(reserved);
        float var546ADE640B6EDFBC8A086EF31347E768_702751057 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_702751057;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.907 -0400", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "663EA294CC8F9144891FB9AA3596ED97")
    public int getTextRunCursor(char[] text, int contextStart, int contextLength,
            int flags, int offset, int cursorOpt) {
        int contextEnd;
        contextEnd = contextStart + contextLength;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int varE8EBF73E11AF76C72E64792B60A20D56_400548308 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextLength, flags, offset, cursorOpt));
        addTaint(text[0]);
        addTaint(contextStart);
        addTaint(contextLength);
        addTaint(flags);
        addTaint(offset);
        addTaint(cursorOpt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316954157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316954157;
        // ---------- Original Method ----------
        //int contextEnd = contextStart + contextLength;
        //if (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                //| (offset - contextStart) | (contextEnd - offset)
                //| (text.length - contextEnd) | cursorOpt) < 0)
                //|| cursorOpt > CURSOR_OPT_MAX_VALUE) {
            //throw new IndexOutOfBoundsException();
        //}
        //return native_getTextRunCursor(mNativePaint, text,
                //contextStart, contextLength, flags, offset, cursorOpt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.909 -0400", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "5F8411DB873A38C3EFF9233DDE154E0D")
    public int getTextRunCursor(CharSequence text, int contextStart,
           int contextEnd, int flags, int offset, int cursorOpt) {
        {
            int var619EE7AC5F2B236B269D3FB8DEBD1DE5_436069271 = (getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt));
        } //End block
        {
            int var5359D01CAC7EB633AB92A9435A4EFA33_366311692 = (((GraphicsOperations) text).getTextRunCursor(
                    contextStart, contextEnd, flags, offset, cursorOpt, this));
        } //End block
        int contextLen;
        contextLen = contextEnd - contextStart;
        char[] buf;
        buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        int result;
        result = getTextRunCursor(buf, 0, contextLen, flags, offset - contextStart, cursorOpt);
        TemporaryBuffer.recycle(buf);
        addTaint(text.getTaint());
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(offset);
        addTaint(cursorOpt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886115123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886115123;
        // ---------- Original Method ----------
        //if (text instanceof String || text instanceof SpannedString ||
                //text instanceof SpannableString) {
            //return getTextRunCursor(text.toString(), contextStart, contextEnd,
                    //flags, offset, cursorOpt);
        //}
        //if (text instanceof GraphicsOperations) {
            //return ((GraphicsOperations) text).getTextRunCursor(
                    //contextStart, contextEnd, flags, offset, cursorOpt, this);
        //}
        //int contextLen = contextEnd - contextStart;
        //char[] buf = TemporaryBuffer.obtain(contextLen);
        //TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        //int result = getTextRunCursor(buf, 0, contextLen, flags, offset - contextStart, cursorOpt);
        //TemporaryBuffer.recycle(buf);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.920 -0400", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "006FABEAE9B7DF4B341B76B998055792")
    public int getTextRunCursor(String text, int contextStart, int contextEnd,
            int flags, int offset, int cursorOpt) {
        {
            boolean varA368D1291D010AA3542B6D856DA1F09E_1341441646 = (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length() - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int var5B91A9628724F23D69FCD31F54247A76_1619087016 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextEnd, flags, offset, cursorOpt));
        addTaint(text.getTaint());
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(flags);
        addTaint(offset);
        addTaint(cursorOpt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081360482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081360482;
        // ---------- Original Method ----------
        //if (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                //| (offset - contextStart) | (contextEnd - offset)
                //| (text.length() - contextEnd) | cursorOpt) < 0)
                //|| cursorOpt > CURSOR_OPT_MAX_VALUE) {
            //throw new IndexOutOfBoundsException();
        //}
        //return native_getTextRunCursor(mNativePaint, text,
                //contextStart, contextEnd, flags, offset, cursorOpt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.926 -0400", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "905D9E78817AB9F6F7234344D8AE96A5")
    public void getTextPath(char[] text, int index, int count,
                            float x, float y, Path path) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                path.ni());
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(x);
        addTaint(y);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //if ((index | count) < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                //path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.946 -0400", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "7A1119AD51AB11A27DFF5BD0B8BE424F")
    public void getTextPath(String text, int start, int end,
                            float x, float y, Path path) {
        {
            boolean var9527A5CDD965760192A60A252272F336_670450647 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                path.ni());
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                //path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.948 -0400", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "D9C9D39667B6F7BEA00EBF79E195B1C0")
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        {
            boolean var9527A5CDD965760192A60A252272F336_946456388 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need bounds Rect");
        } //End block
        nativeGetStringBounds(mNativePaint, text, start, end, bounds);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (bounds == null) {
            //throw new NullPointerException("need bounds Rect");
        //}
        //nativeGetStringBounds(mNativePaint, text, start, end, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.949 -0400", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "9008BD67264402A03E682EB91A92F9A9")
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need bounds Rect");
        } //End block
        nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //if ((index | count) < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (bounds == null) {
            //throw new NullPointerException("need bounds Rect");
        //}
        //nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.975 -0400", hash_original_method = "925DF10B1DD177E135B07F96DE8E7F32", hash_generated_method = "DF419449CAA1B777D791C6F5EE64D2ED")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            finalizer(mNativePaint);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //finalizer(mNativePaint);
        //} finally {
            //super.finalize();
        //}
    }

    
        private static int native_init() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_initWithPaint(int paint) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_reset(int native_object) {
    }

    
        private static void native_set(int native_dst, int native_src) {
    }

    
        private static int native_getStyle(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setStyle(int native_object, int style) {
    }

    
        private static int native_getStrokeCap(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setStrokeCap(int native_object, int cap) {
    }

    
        private static int native_getStrokeJoin(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setStrokeJoin(int native_object,
                                                    int join) {
    }

    
        private static boolean native_getFillPath(int native_object,
                                                     int src, int dst) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int native_setShader(int native_object, int shader) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setColorFilter(int native_object,
                                                    int filter) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setXfermode(int native_object,
                                                 int xfermode) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setPathEffect(int native_object,
                                                   int effect) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setMaskFilter(int native_object,
                                                   int maskfilter) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setTypeface(int native_object,
                                                 int typeface) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setRasterizer(int native_object,
                                                   int rasterizer) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_getTextAlign(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setTextAlign(int native_object,
                                                   int align) {
    }

    
        private static float native_getFontMetrics(int native_paint,
                                                      FontMetrics metrics) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static int native_getTextWidths(int native_object,
                            char[] text, int index, int count, float[] widths) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_getTextWidths(int native_object,
                            String text, int start, int end, float[] widths) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_getTextGlyphs(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static float native_getTextRunAdvances(int native_object,
            char[] text, int index, int count, int contextIndex, int contextCount,
            int flags, float[] advances, int advancesIndex, int reserved) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float native_getTextRunAdvances(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, int reserved) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.026 -0400", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "E9B2107978D21A448400BB498A319AC2")
    private int native_getTextRunCursor(int native_object, char[] text,
            int contextStart, int contextLength, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565306755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565306755;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.026 -0400", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "FF3640FE7FF829AB0BD05B01A565CABB")
    private int native_getTextRunCursor(int native_object, String text,
            int contextStart, int contextEnd, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31639352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31639352;
    }

    
        private static void native_getTextPath(int native_object, int bidiFlags,
                char[] text, int index, int count, float x, float y, int path) {
    }

    
        private static void native_getTextPath(int native_object, int bidiFlags,
                String text, int start, int end, float x, float y, int path) {
    }

    
        private static void nativeGetStringBounds(int nativePaint,
                                String text, int start, int end, Rect bounds) {
    }

    
        private static void nativeGetCharArrayBounds(int nativePaint,
                                char[] text, int index, int count, Rect bounds) {
    }

    
        private static void finalizer(int nativePaint) {
    }

    
    public enum Style {
        FILL            (0),
        STROKE          (1),
        FILL_AND_STROKE (2);
        Style(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    public enum Cap {
        BUTT    (0),
        ROUND   (1),
        SQUARE  (2);
        private Cap(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    public enum Join {
        MITER   (0),
        ROUND   (1),
        BEVEL   (2);
        private Join(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    public enum Align {
        LEFT    (0),
        CENTER  (1),
        RIGHT   (2);
        private Align(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    public static class FontMetrics {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "F9D622C84E97B0C2CBDBCB618909D322")

        public float top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "A796C466A86DB299E2750CA9F2E8F71A")

        public float ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "A16D9583A878BCA686CD4BEDA3A7949E")

        public float descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "3601A2C074D2F75BE50976E0F9B684C6")

        public float bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "888796604577C49ABEC23552DFF6B4E6")

        public float leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_method = "9D0F6E676FD14A88D6B94EA1234A3DC2", hash_generated_method = "9D0F6E676FD14A88D6B94EA1234A3DC2")
        public FontMetrics ()
        {
            //Synthesized constructor
        }


    }


    
    public static class FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.029 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

        public int top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.030 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "FA14915E4ED5D34F11F90DF8ECCA8FF2")

        public int ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.030 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "28172A09342BA30A11EF1965F08565DD")

        public int descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.030 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

        public int bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.030 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "EE2E8A507D7730016199EA97319493B2")

        public int leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.030 -0400", hash_original_method = "8179D96EF0A0532FF84A77E27487BF14", hash_generated_method = "8179D96EF0A0532FF84A77E27487BF14")
        public FontMetricsInt ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "63B8AE4D8AFA6A782673025F534BCD21")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_877139409 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_877139409 = "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    " descent=" + descent + " bottom=" + bottom +
                    " leading=" + leading;
            varB4EAC82CA7396A68D541C85D26508E83_877139409.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_877139409;
            // ---------- Original Method ----------
            //return "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    //" descent=" + descent + " bottom=" + bottom +
                    //" leading=" + leading;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_field = "DA21A7D685DD2F0287DF4209A5883DA6", hash_generated_field = "B137E5FE52A726C65F83425DDED7F6D8")

    static Style[] sStyleArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_field = "6FB167C672F318B57B505D87A2054546", hash_generated_field = "6BC69D632CA1778AF9E5F55ADA15DD0A")

    static Cap[] sCapArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_field = "817A29AB9F2FBE52718953372FA63797", hash_generated_field = "E044E46611ADA323C54027A1AE620355")

    static Join[] sJoinArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_field = "D7D8049DA3EF124C474A03CB581B7573", hash_generated_field = "502B3EB81E3B943D14ED50966DA36943")

    static Align[] sAlignArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.048 -0400", hash_original_field = "DAED95C98C2D4267466506AA3DAA06AF", hash_generated_field = "45D0C54CC6E381296E91FEFD4D7E9F05")

    public static final int ANTI_ALIAS_FLAG     = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "32C79F3C172895E1068B20BB6EF1B730", hash_generated_field = "3B37B87298EB8671D01D36A02B147DBD")

    public static final int FILTER_BITMAP_FLAG  = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "4F23A3DB5C72BE721B62DFDF2A927536", hash_generated_field = "16DC79CD5B30E8BBD4718C630596673F")

    public static final int DITHER_FLAG         = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "3177915AF2023957BA3DC371F728F3DE", hash_generated_field = "B76EE25AA2E9AE34D9CEE0AE93E3B0AF")

    public static final int UNDERLINE_TEXT_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "8922A9753F894FF1F3817F1BDDADBCE6", hash_generated_field = "2E3EA944809E9CBC9A119AA5696756EB")

    public static final int STRIKE_THRU_TEXT_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "FE8C2E5F3338DB63879146CE21AB8196", hash_generated_field = "DE9EF5A591F6D71DE416EE9B51EE6EB5")

    public static final int FAKE_BOLD_TEXT_FLAG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "200456E8ACA82EF7148143B7EBB92E26", hash_generated_field = "7F1BE56009FABC11D8C2A24734D2E78C")

    public static final int LINEAR_TEXT_FLAG    = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "2EE5264F466D0CCCCA6FD42ECAA3A082", hash_generated_field = "104067A48B49BC1C75654D92F259E44A")

    public static final int SUBPIXEL_TEXT_FLAG  = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "590BE3871E0A9C676B8DA9EB91D73A5D", hash_generated_field = "B7D127AFEC7155C6CDA53B6A46D2FB5C")

    public static final int DEV_KERN_TEXT_FLAG  = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.049 -0400", hash_original_field = "11F7E634916EB2B3531D36F0AA006F69", hash_generated_field = "C46EE02197766B5C6FEA370CD0D6546A")

    static int DEFAULT_PAINT_FLAGS = DEV_KERN_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "94822D72BA2ED08272F86B1D8CBBB228", hash_generated_field = "7E20082E997CCF5AE3ADDE6EB55F4D14")

    public static final int HINTING_OFF = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "00F8D279832856AAB2482457B470C69C", hash_generated_field = "75F6A241333C1BDE4871EB2D5849C4B4")

    public static final int HINTING_ON = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "36E6A04BF5F69066937E780304BE2372", hash_generated_field = "6F9C6C8D6013846EA024C014B7506D51")

    public static final int BIDI_LTR = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "E99238E9A37B5494B1F6D3374D8A8388", hash_generated_field = "5E8A80ABBBB4622F32D5ECA5E3A02CF1")

    public static final int BIDI_RTL = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "EE0C47E8438ECB20552CEF2D89DC24C8", hash_generated_field = "2F04CC5409C37696637070FBC2BCA711")

    public static final int BIDI_DEFAULT_LTR = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "82417C79DDF40F02CFD62DC0B0BFF557", hash_generated_field = "91CE6515A1DC6EC518B6EF6F7044CC99")

    public static final int BIDI_DEFAULT_RTL = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "E2F3639E9F2BEC4CCE554F5DA6A66B39", hash_generated_field = "96707B9ED197F2C49CEF721789B1CC89")

    public static final int BIDI_FORCE_LTR = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "4477D287153948E3BCC8146F87474210", hash_generated_field = "C8D922D49FF076A4FA47E7AC1C90E71C")

    public static final int BIDI_FORCE_RTL = 0x5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.050 -0400", hash_original_field = "AD043D77A3F007CF0D78F67B7A122465", hash_generated_field = "9418DE89529357C532D05188A6823D6C")

    private static int BIDI_MAX_FLAG_VALUE = BIDI_FORCE_RTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.068 -0400", hash_original_field = "EDE5E0F0C0A7138B12B7543291047D37", hash_generated_field = "FBC382B10CB42383F8016E88B781A5AE")

    private static int BIDI_FLAG_MASK = 0x7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "3156617304B6D40B79220E1E6BFC0BE0", hash_generated_field = "519D5E5540609C6F930879E787B9A0E3")

    public static final int CURSOR_AFTER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "46E4972643B74A1460244D84ED486FD5", hash_generated_field = "87F0976C0F58B633C620CB23E58C9D06")

    public static final int CURSOR_AT_OR_AFTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "4CEF794F11B5E574A3ECFEC23B55ABAD", hash_generated_field = "E937AFFEBC810173CB0EDEB05B57742B")

    public static final int CURSOR_BEFORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "0FEA77E88DFD7349A142E7C079F0CD42", hash_generated_field = "59875B95A53D3853447FD50EB38FE659")

    public static final int CURSOR_AT_OR_BEFORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "0D7566A26ECAD2F14A1D61E8205D9E27", hash_generated_field = "944FD8D9E2B6685D6BB0D020EFBD576C")

    public static final int CURSOR_AT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.069 -0400", hash_original_field = "6CC78B0C1FCA48FD494AD1FDCE89286A", hash_generated_field = "D202BF98034DD8D9E3187DDA3D64B352")

    private static int CURSOR_OPT_MAX_VALUE = CURSOR_AT;
}

