package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

public class Paint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "D43E64E8DB23D8105EFCFFDFE2703E5E", hash_generated_field = "F9F1B9FB44729EA466DD33DE16A3AB10")

    public int mNativePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "B084716E2B957889ADD456E706B0D908", hash_generated_field = "30CA93EA0A1FDD848EE36D39E7D9E77B")

    private MaskFilter mMaskFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "0C964CB18CE5DB6CE248155A69D05850", hash_generated_field = "0970365855BAEB3B93B55E917D7BB807")

    private PathEffect mPathEffect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "B8E4807966280C43A678FFEA169DB2BF", hash_generated_field = "E15971EFBFBD92787A66981AB256F5C2")

    private Rasterizer mRasterizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "B1952C618C8BBD071ACDDBA82DB64026")

    private Shader mShader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.482 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "234D9F5A4F790A70ADC301ADC43BEEC1")

    private Typeface mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "28B87225BC1D2D4DDEE55BD61F984139", hash_generated_field = "E20BD0A091050F1F29128E6A824DE542")

    private Xfermode mXfermode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "AC29C10FA86008DC70760D09ABDD8975", hash_generated_field = "41C5D1021B750266A4ADC951970465D5")

    private boolean mHasCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "54878B6CF92B4C69D84F841DD1E3B67B", hash_generated_field = "B75D80F84935274D46B49A2A5EE4E0AB")

    private float mCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "080CF1326240F02CC5113284F8866075", hash_generated_field = "3B482C031B54D0585FB747229A42223A")

    private float mInvCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "5ECD95A3EBAA8F5228C8769A496F581F", hash_generated_field = "79432E7E02F51603141CA873F5DC70EF")

    public boolean hasShadow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "0576421823B0FE164EF79686754E859C", hash_generated_field = "5B09CAB9CB4DEB539F28464A0A9AF847")

    public float shadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "B56AC33C6797CC57B93060FF92EE1F0E", hash_generated_field = "E8741946672ABFDF9B3AFE7FAFACA993")

    public float shadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "AEE37AD6DA942F6F9C5FBE1BCF65AC67", hash_generated_field = "584D14064094F2C1B9BDB348A4C8065C")

    public float shadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "D14A83C55DBA07A19E2627BF8C98AFB6", hash_generated_field = "F7019584388E8E0B6A5FA29A5D1D5111")

    public int shadowColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_field = "ABA7903F07E8350F4F66A9F81A266F4F", hash_generated_field = "EC215250783F837A7E2BDA6A9E3ACA2D")

    public int mBidiFlags = BIDI_DEFAULT_LTR;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.483 -0400", hash_original_method = "07976DE00CD3F977E8ACA514AAEDE967", hash_generated_method = "2E92EC59FFA72681E3F4ECFD5F5383AA")
    public  Paint() {
        this(0);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.484 -0400", hash_original_method = "DD18D0561860908DF0D4B7BC76B2B3D2", hash_generated_method = "ABDF03E9F8EA7583E030156FE4ED96D1")
    public  Paint(int flags) {
        addTaint(flags);
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        // ---------- Original Method ----------
        //mNativePaint = native_init();
        //setFlags(flags | DEFAULT_PAINT_FLAGS);
        //mCompatScaling = mInvCompatScaling = 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.484 -0400", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "1E0CEE6CD795EABAB79C1575708D48D5")
    public  Paint(Paint paint) {
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
        // ---------- Original Method ----------
        //mNativePaint = native_initWithPaint(paint.mNativePaint);
        //setClassVariablesFrom(paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.485 -0400", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "4EC68B4DCAA133DD09A2D2EB6717EEB2")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.486 -0400", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "BE014283A449A012B9ACEC8E96B2A509")
    public void set(Paint src) {
        addTaint(src.getTaint());
        if(this != src)        
        {
            native_set(mNativePaint, src.mNativePaint);
            setClassVariablesFrom(src);
        } //End block
        // ---------- Original Method ----------
        //if (this != src) {
            //native_set(mNativePaint, src.mNativePaint);
            //setClassVariablesFrom(src);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.489 -0400", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "BD7871E3A37A563592B6AC84BB6E6C1C")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.490 -0400", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "407FC46B741F88D4037C340D8E4C7070")
    public void setCompatibilityScaling(float factor) {
        if(factor == 1.0)        
        {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.491 -0400", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "7231B0F9E6DE1D926F2CF0379648F0B9")
    public int getBidiFlags() {
        int var1748BBD3D4961DC7F03913160F67CAB2_1914302131 = (mBidiFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043577161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043577161;
        // ---------- Original Method ----------
        //return mBidiFlags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.492 -0400", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "368A03471E7A48698BFF8C26E93FDB91")
    public void setBidiFlags(int flags) {
        flags &= BIDI_FLAG_MASK;
        if(flags > BIDI_MAX_FLAG_VALUE)        
        {
            IllegalArgumentException var5C65497B81547CBCA3C7DC4360BDCA5B_1549951200 = new IllegalArgumentException("unknown bidi flag: " + flags);
            var5C65497B81547CBCA3C7DC4360BDCA5B_1549951200.addTaint(taint);
            throw var5C65497B81547CBCA3C7DC4360BDCA5B_1549951200;
        } //End block
        mBidiFlags = flags;
        // ---------- Original Method ----------
        //flags &= BIDI_FLAG_MASK;
        //if (flags > BIDI_MAX_FLAG_VALUE) {
            //throw new IllegalArgumentException("unknown bidi flag: " + flags);
        //}
        //mBidiFlags = flags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.492 -0400", hash_original_method = "1AEF3AE96B7B0567703FA6E8804026B1", hash_generated_method = "7E1F8ECBB02A43B639AE4C84384EDB61")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084830919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084830919;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.493 -0400", hash_original_method = "7E0C8B4D00EF46DF7C96B7FEFE972867", hash_generated_method = "E81D91BA95CE017C8A6AE2CF5F166A3B")
    public void setFlags(int flags) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.493 -0400", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "D2915910C8C742D6C2B564E35F08AE9D")
    public int getHinting() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095069549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095069549;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.494 -0400", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "BEF76864791FDB477DCC8963BCE4B764")
    public void setHinting(int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.494 -0400", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "0F495CF34858BA566CB7ACB1300CA30C")
    public final boolean isAntiAlias() {
        boolean var642B1B77578F5B92DFE12743626FDDB3_1062122543 = ((getFlags() & ANTI_ALIAS_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660444856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660444856;
        // ---------- Original Method ----------
        //return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.494 -0400", hash_original_method = "8B9E1DF7E3F10B045A1C3ED5825D806F", hash_generated_method = "969C9AD79C602B0B74504E6ADC0CDA95")
    public void setAntiAlias(boolean aa) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.495 -0400", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "DA1818438401F750A837FAF7F0DCB2D6")
    public final boolean isDither() {
        boolean var3935C3521043228D582B5346E9A3ED0C_1477685742 = ((getFlags() & DITHER_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341525330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341525330;
        // ---------- Original Method ----------
        //return (getFlags() & DITHER_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.495 -0400", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "885C8677A0ED029E797386D2040088D8")
    public void setDither(boolean dither) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.496 -0400", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "7CDDC79E71357D5724D7FE3E0495CBFA")
    public final boolean isLinearText() {
        boolean var7CF7C722E4323F681C755D27FF58C13F_1330800417 = ((getFlags() & LINEAR_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664094548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664094548;
        // ---------- Original Method ----------
        //return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.496 -0400", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "018998AB05D2191EBA074C9F705B430C")
    public void setLinearText(boolean linearText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.497 -0400", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "EE9F51CAD6C9F480B6A36C5D2B86ABA3")
    public final boolean isSubpixelText() {
        boolean var750E17719AD0F45546FE3847F5A43055_1901433131 = ((getFlags() & SUBPIXEL_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119581607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119581607;
        // ---------- Original Method ----------
        //return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.497 -0400", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "B34B82250E86FDB7DB09A047E0B9AB1E")
    public void setSubpixelText(boolean subpixelText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.498 -0400", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "5613A0C37E33A1B256898449644989AF")
    public final boolean isUnderlineText() {
        boolean var8F4035594F35F50D509088F3DD2A2DB2_980572811 = ((getFlags() & UNDERLINE_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131473544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131473544;
        // ---------- Original Method ----------
        //return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.498 -0400", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "417886D7D175F8B8D55EE0D90CFAE4FA")
    public void setUnderlineText(boolean underlineText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.498 -0400", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "74286C7FCCCA0BC97E5C492ED65A0142")
    public final boolean isStrikeThruText() {
        boolean varFEA105DBA375C0A2F032B236A0A2E7F0_1261163342 = ((getFlags() & STRIKE_THRU_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691305376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691305376;
        // ---------- Original Method ----------
        //return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.499 -0400", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "FB6506C20923BFB227903FF1094AB4FB")
    public void setStrikeThruText(boolean strikeThruText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.499 -0400", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "B299B2EB6F5DD370FBED019E0AC996B5")
    public final boolean isFakeBoldText() {
        boolean var15B427FFF4C33E421851BAED92E8DAFF_1598002899 = ((getFlags() & FAKE_BOLD_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630121436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630121436;
        // ---------- Original Method ----------
        //return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.514 -0400", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "69207AE83514DFB7DD01C9111E4B061D")
    public void setFakeBoldText(boolean fakeBoldText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.514 -0400", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "F3CAC0281385BC28052E580B0E85D534")
    public final boolean isFilterBitmap() {
        boolean var819608BAF0AAB38A96B8B58084D72F3C_1476010279 = ((getFlags() & FILTER_BITMAP_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216101902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216101902;
        // ---------- Original Method ----------
        //return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.514 -0400", hash_original_method = "B8C11CD7111D9BC247774CFB44C7A8B0", hash_generated_method = "72A4AA63A3BDB8FE50798AE60EFC3156")
    public void setFilterBitmap(boolean filter) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.514 -0400", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "16A86B05775663ECF1DD568C50B2E6AF")
    public Style getStyle() {
Style var27879EDEA81956155BE56815AB26799D_429840112 =         sStyleArray[native_getStyle(mNativePaint)];
        var27879EDEA81956155BE56815AB26799D_429840112.addTaint(taint);
        return var27879EDEA81956155BE56815AB26799D_429840112;
        // ---------- Original Method ----------
        //return sStyleArray[native_getStyle(mNativePaint)];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "D22412F550961279E948FD64FC691029")
    public void setStyle(Style style) {
        addTaint(style.getTaint());
        native_setStyle(mNativePaint, style.nativeInt);
        // ---------- Original Method ----------
        //native_setStyle(mNativePaint, style.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "A6843949A5740747763B245A4340955B", hash_generated_method = "2C670B401FCE835CA8796350ABCAF758")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755720426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755720426;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "6B0B967C1DC4D48EE66A1A874887BE3F", hash_generated_method = "359EC0CDBCF6D3FF497E0AB9CE671581")
    public void setColor(int color) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "E925D159634D04E536108C634A92E651")
    public int getAlpha() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403730107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403730107;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "319BF4CF7F9EF61753405A8B0B105272")
    public void setAlpha(int a) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "0204EBF369F6F4973C4FCEBD5A585646")
    public void setARGB(int a, int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        addTaint(a);
        setColor((a << 24) | (r << 16) | (g << 8) | b);
        // ---------- Original Method ----------
        //setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.515 -0400", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "0C492485A74DBEB1BDBF4FE13CC494FA")
    public float getStrokeWidth() {
        float var546ADE640B6EDFBC8A086EF31347E768_1013562719 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1013562719;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "564DC2A484C3EEE36BA29C2660B22AD8")
    public void setStrokeWidth(float width) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "C09360DDD98D18531F7175D7DABB8A5F")
    public float getStrokeMiter() {
        float var546ADE640B6EDFBC8A086EF31347E768_1613486316 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1613486316;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "1944134F0761932CBCD4B9547BA850AF")
    public void setStrokeMiter(float miter) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "532803AAAC04BAEE1EF459D21F42A43D")
    public Cap getStrokeCap() {
Cap var5D5320C20783685DBA0D6064E7E86A1D_1587771240 =         sCapArray[native_getStrokeCap(mNativePaint)];
        var5D5320C20783685DBA0D6064E7E86A1D_1587771240.addTaint(taint);
        return var5D5320C20783685DBA0D6064E7E86A1D_1587771240;
        // ---------- Original Method ----------
        //return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "277F69D872CDB2B8723F06892A48CE4C")
    public void setStrokeCap(Cap cap) {
        addTaint(cap.getTaint());
        native_setStrokeCap(mNativePaint, cap.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "4AEA1323B77F6511C0F85F4499023E71")
    public Join getStrokeJoin() {
Join var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1518330575 =         sJoinArray[native_getStrokeJoin(mNativePaint)];
        var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1518330575.addTaint(taint);
        return var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1518330575;
        // ---------- Original Method ----------
        //return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "605EE2EB145C049007351816BDAFD469")
    public void setStrokeJoin(Join join) {
        addTaint(join.getTaint());
        native_setStrokeJoin(mNativePaint, join.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.516 -0400", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "DEF885BB7431F81C69DD7B873D0E2C31")
    public boolean getFillPath(Path src, Path dst) {
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        boolean var0B1620E3C3242ECB54942755E09EC219_207559451 = (native_getFillPath(mNativePaint, src.ni(), dst.ni()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486090774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_486090774;
        // ---------- Original Method ----------
        //return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.517 -0400", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "3A16CA53AD922E1745C24E43FD09F921")
    public Shader getShader() {
Shader var1E3A4ADBA26A90CC52B6789FE92E9043_179439498 =         mShader;
        var1E3A4ADBA26A90CC52B6789FE92E9043_179439498.addTaint(taint);
        return var1E3A4ADBA26A90CC52B6789FE92E9043_179439498;
        // ---------- Original Method ----------
        //return mShader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.517 -0400", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "59FCBB5945C357C6D196FE3BD8A60C9A")
    public Shader setShader(Shader shader) {
        int shaderNative = 0;
        if(shader != null)        
        shaderNative = shader.native_instance;
        native_setShader(mNativePaint, shaderNative);
        mShader = shader;
Shader varFFC587FB7657AE6653704469EEF0EF8A_1039889308 =         shader;
        varFFC587FB7657AE6653704469EEF0EF8A_1039889308.addTaint(taint);
        return varFFC587FB7657AE6653704469EEF0EF8A_1039889308;
        // ---------- Original Method ----------
        //int shaderNative = 0;
        //if (shader != null)
            //shaderNative = shader.native_instance;
        //native_setShader(mNativePaint, shaderNative);
        //mShader = shader;
        //return shader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.517 -0400", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "CA8A0FA4F9C6D48969424824F2D2CBB3")
    public ColorFilter getColorFilter() {
ColorFilter varEDD194C8C1AE8ED0D309C82968CA83AE_1918197081 =         mColorFilter;
        varEDD194C8C1AE8ED0D309C82968CA83AE_1918197081.addTaint(taint);
        return varEDD194C8C1AE8ED0D309C82968CA83AE_1918197081;
        // ---------- Original Method ----------
        //return mColorFilter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.517 -0400", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "9902B1EB21AEEA43577593E3AAA79493")
    public ColorFilter setColorFilter(ColorFilter filter) {
        int filterNative = 0;
        if(filter != null)        
        filterNative = filter.native_instance;
        native_setColorFilter(mNativePaint, filterNative);
        mColorFilter = filter;
ColorFilter varEDAB7C57B2A558E364C3233CE622D985_621092322 =         filter;
        varEDAB7C57B2A558E364C3233CE622D985_621092322.addTaint(taint);
        return varEDAB7C57B2A558E364C3233CE622D985_621092322;
        // ---------- Original Method ----------
        //int filterNative = 0;
        //if (filter != null)
            //filterNative = filter.native_instance;
        //native_setColorFilter(mNativePaint, filterNative);
        //mColorFilter = filter;
        //return filter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.517 -0400", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "15487EE36239ECD3AA677CE50D166A42")
    public Xfermode getXfermode() {
Xfermode varC511827B29B204E5EAA5182BCB874846_1729948279 =         mXfermode;
        varC511827B29B204E5EAA5182BCB874846_1729948279.addTaint(taint);
        return varC511827B29B204E5EAA5182BCB874846_1729948279;
        // ---------- Original Method ----------
        //return mXfermode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "0921950A15D9608D02782231DB40313D")
    public Xfermode setXfermode(Xfermode xfermode) {
        int xfermodeNative = 0;
        if(xfermode != null)        
        xfermodeNative = xfermode.native_instance;
        native_setXfermode(mNativePaint, xfermodeNative);
        mXfermode = xfermode;
Xfermode varC1CEA90A1ECF2887378C37444B43B32D_1556633755 =         xfermode;
        varC1CEA90A1ECF2887378C37444B43B32D_1556633755.addTaint(taint);
        return varC1CEA90A1ECF2887378C37444B43B32D_1556633755;
        // ---------- Original Method ----------
        //int xfermodeNative = 0;
        //if (xfermode != null)
            //xfermodeNative = xfermode.native_instance;
        //native_setXfermode(mNativePaint, xfermodeNative);
        //mXfermode = xfermode;
        //return xfermode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "28CCE6EBF12F176D962C31915FE29188")
    public PathEffect getPathEffect() {
PathEffect var62231A322915CC0816BA035D0DB999E9_1583540124 =         mPathEffect;
        var62231A322915CC0816BA035D0DB999E9_1583540124.addTaint(taint);
        return var62231A322915CC0816BA035D0DB999E9_1583540124;
        // ---------- Original Method ----------
        //return mPathEffect;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "7852B39A066102778DD4F72FC019C1BE")
    public PathEffect setPathEffect(PathEffect effect) {
        int effectNative = 0;
        if(effect != null)        
        {
            effectNative = effect.native_instance;
        } //End block
        native_setPathEffect(mNativePaint, effectNative);
        mPathEffect = effect;
PathEffect varC228D34163331935C47D1C8D0FF6067F_805405151 =         effect;
        varC228D34163331935C47D1C8D0FF6067F_805405151.addTaint(taint);
        return varC228D34163331935C47D1C8D0FF6067F_805405151;
        // ---------- Original Method ----------
        //int effectNative = 0;
        //if (effect != null) {
            //effectNative = effect.native_instance;
        //}
        //native_setPathEffect(mNativePaint, effectNative);
        //mPathEffect = effect;
        //return effect;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "2C8F556AF77134C553F3786F1D4209BC")
    public MaskFilter getMaskFilter() {
MaskFilter var212930E76E499C498BBA58BFE514DEFB_1087985279 =         mMaskFilter;
        var212930E76E499C498BBA58BFE514DEFB_1087985279.addTaint(taint);
        return var212930E76E499C498BBA58BFE514DEFB_1087985279;
        // ---------- Original Method ----------
        //return mMaskFilter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "052C1CE4F36E66C18A75156EBF1D8128")
    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        int maskfilterNative = 0;
        if(maskfilter != null)        
        {
            maskfilterNative = maskfilter.native_instance;
        } //End block
        native_setMaskFilter(mNativePaint, maskfilterNative);
        mMaskFilter = maskfilter;
MaskFilter var809F23AFE180E2B871F7AB6111A113AC_1468251717 =         maskfilter;
        var809F23AFE180E2B871F7AB6111A113AC_1468251717.addTaint(taint);
        return var809F23AFE180E2B871F7AB6111A113AC_1468251717;
        // ---------- Original Method ----------
        //int maskfilterNative = 0;
        //if (maskfilter != null) {
            //maskfilterNative = maskfilter.native_instance;
        //}
        //native_setMaskFilter(mNativePaint, maskfilterNative);
        //mMaskFilter = maskfilter;
        //return maskfilter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.518 -0400", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "72F63714CDAB71F5092FA387AF3D684E")
    public Typeface getTypeface() {
Typeface varCA555E983FC958B176FA6EA9B4C69E1B_1909862918 =         mTypeface;
        varCA555E983FC958B176FA6EA9B4C69E1B_1909862918.addTaint(taint);
        return varCA555E983FC958B176FA6EA9B4C69E1B_1909862918;
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.519 -0400", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "DE9F5CD0E27A0A9439106F84CA53043D")
    public Typeface setTypeface(Typeface typeface) {
        int typefaceNative = 0;
        if(typeface != null)        
        {
            typefaceNative = typeface.native_instance;
        } //End block
        native_setTypeface(mNativePaint, typefaceNative);
        mTypeface = typeface;
Typeface varFE051F16B59B46C310898CF1A96D8867_1598884819 =         typeface;
        varFE051F16B59B46C310898CF1A96D8867_1598884819.addTaint(taint);
        return varFE051F16B59B46C310898CF1A96D8867_1598884819;
        // ---------- Original Method ----------
        //int typefaceNative = 0;
        //if (typeface != null) {
            //typefaceNative = typeface.native_instance;
        //}
        //native_setTypeface(mNativePaint, typefaceNative);
        //mTypeface = typeface;
        //return typeface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.519 -0400", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "B14CEFB36E9EB09F4B590735B4DE8D6A")
    public Rasterizer getRasterizer() {
Rasterizer varE90C2BC199F6AB692B71C8201A9480EC_1226009936 =         mRasterizer;
        varE90C2BC199F6AB692B71C8201A9480EC_1226009936.addTaint(taint);
        return varE90C2BC199F6AB692B71C8201A9480EC_1226009936;
        // ---------- Original Method ----------
        //return mRasterizer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.519 -0400", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "067AB852A2D84E5228BD65EC61B8A723")
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        int rasterizerNative = 0;
        if(rasterizer != null)        
        {
            rasterizerNative = rasterizer.native_instance;
        } //End block
        native_setRasterizer(mNativePaint, rasterizerNative);
        mRasterizer = rasterizer;
Rasterizer var284B36D27D5CF0F737A31AF832A95273_452769006 =         rasterizer;
        var284B36D27D5CF0F737A31AF832A95273_452769006.addTaint(taint);
        return var284B36D27D5CF0F737A31AF832A95273_452769006;
        // ---------- Original Method ----------
        //int rasterizerNative = 0;
        //if (rasterizer != null) {
            //rasterizerNative = rasterizer.native_instance;
        //}
        //native_setRasterizer(mNativePaint, rasterizerNative);
        //mRasterizer = rasterizer;
        //return rasterizer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.519 -0400", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "890115DE943F753280243985FB0CA4B9")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.519 -0400", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "DE3CFB24C60627249AA98DBC6D18C4A8")
    private void nSetShadowLayer(float radius, float dx, float dy, int color) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "69C41E78339835181B7060E466C37E39")
    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
        // ---------- Original Method ----------
        //hasShadow = false;
        //nSetShadowLayer(0, 0, 0, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "B1F74D8C4072C7715B08392F1875D5B7")
    public Align getTextAlign() {
Align var2FAEB5066D95FB11BAB5CBC4358EE326_276990368 =         sAlignArray[native_getTextAlign(mNativePaint)];
        var2FAEB5066D95FB11BAB5CBC4358EE326_276990368.addTaint(taint);
        return var2FAEB5066D95FB11BAB5CBC4358EE326_276990368;
        // ---------- Original Method ----------
        //return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "85F1280E5F607A230D3C2951AC7A491F")
    public void setTextAlign(Align align) {
        addTaint(align.getTaint());
        native_setTextAlign(mNativePaint, align.nativeInt);
        // ---------- Original Method ----------
        //native_setTextAlign(mNativePaint, align.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "B43AC05A6BD1AD7D66B93C43ECC52DC8")
    public float getTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_2042369913 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2042369913;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "D150D3B101DE8920A691C9CE66A42B08")
    public void setTextSize(float textSize) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "B91EAB78224E28A9BD4C1E509D7BB7AB")
    public float getTextScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1733870196 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1733870196;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "75A2C46EA134EC88EFC16602B5352C8F")
    public void setTextScaleX(float scaleX) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.520 -0400", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "77F28C28EB62785D2F6B55F54157B64E")
    public float getTextSkewX() {
        float var546ADE640B6EDFBC8A086EF31347E768_271346158 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_271346158;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "94DEC1BD4F69C9C57DAD152D853AE23B")
    public void setTextSkewX(float skewX) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "43609ECDE3583946D117CCAECE9FCC85")
    public float ascent() {
        float var546ADE640B6EDFBC8A086EF31347E768_1093334074 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1093334074;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "F3AA0912AFC7453B93310836AF1FDA20")
    public float descent() {
        float var546ADE640B6EDFBC8A086EF31347E768_1494263811 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1494263811;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "26B0CA9569EB9179314B3AF5E404C3B7")
    public float getFontMetrics(FontMetrics metrics) {
        float var546ADE640B6EDFBC8A086EF31347E768_20228682 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_20228682;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "4AECF4B9451E81F0B087340492D91A87")
    public FontMetrics getFontMetrics() {
        FontMetrics fm = new FontMetrics();
        getFontMetrics(fm);
FontMetrics var23595DD9B2392DF50EC435F4E8F21162_267993056 =         fm;
        var23595DD9B2392DF50EC435F4E8F21162_267993056.addTaint(taint);
        return var23595DD9B2392DF50EC435F4E8F21162_267993056;
        // ---------- Original Method ----------
        //FontMetrics fm = new FontMetrics();
        //getFontMetrics(fm);
        //return fm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "FCD47398884293F927C4D24CCB784D56")
    public int getFontMetricsInt(FontMetricsInt fmi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120625700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120625700;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "B455196A7754F8291C5025224FB8B40A")
    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fm = new FontMetricsInt();
        getFontMetricsInt(fm);
FontMetricsInt var23595DD9B2392DF50EC435F4E8F21162_1979660493 =         fm;
        var23595DD9B2392DF50EC435F4E8F21162_1979660493.addTaint(taint);
        return var23595DD9B2392DF50EC435F4E8F21162_1979660493;
        // ---------- Original Method ----------
        //FontMetricsInt fm = new FontMetricsInt();
        //getFontMetricsInt(fm);
        //return fm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.521 -0400", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "4766B27579EA76D4E398A6BCB2260646")
    public float getFontSpacing() {
        float var8BA153667E9D783491847D1270F862D1_1836223407 = (getFontMetrics(null));
                float var546ADE640B6EDFBC8A086EF31347E768_1082303710 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1082303710;
        // ---------- Original Method ----------
        //return getFontMetrics(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.522 -0400", hash_original_method = "4B30EE6B8828803214F6472A454BF7F0", hash_generated_method = "B76C0BA1204A0ECADEF7D98BC0F5CB9C")
    public float measureText(char[] text, int index, int count) {
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1981799451 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1981799451.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1981799451;
        } //End block
        if((index | count) < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_907463835 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_907463835.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_907463835;
        } //End block
        if(text.length == 0 || count == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1482994070 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1088026284 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1088026284;
        } //End block
        if(!mHasCompatScaling)        
        {
            float var70E7EAC1B676F157C2A482F4E1928574_432070134 = (native_measureText(text, index, count));
                        float var546ADE640B6EDFBC8A086EF31347E768_554608619 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_554608619;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_1578738718 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_688166280 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_688166280;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.522 -0400", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "C3FD5CF964EA732E4DCB58385C05069E")
    private float native_measureText(char[] text, int index, int count) {
        float var546ADE640B6EDFBC8A086EF31347E768_1296587550 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1296587550;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.522 -0400", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "24A6D997758DE4995F25C372B0FBBC36")
    public float measureText(String text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_343643036 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_343643036.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_343643036;
        } //End block
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1945214386 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1945214386.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1945214386;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1490432118 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_273105698 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_273105698;
        } //End block
        if(!mHasCompatScaling)        
        {
            float var0E5E906619CE1361070518A4A6F8ABDF_51423900 = (native_measureText(text, start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_1214513004 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1214513004;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, start, end);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_1772254531 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_1699306332 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1699306332;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.523 -0400", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "5E9B6DA07CF6FD03512A578EBAF45199")
    private float native_measureText(String text, int start, int end) {
        float var546ADE640B6EDFBC8A086EF31347E768_1482130955 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1482130955;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.523 -0400", hash_original_method = "C4C224EF0059A9B14092F4800A14BAD4", hash_generated_method = "B65FA69EE09EE63ED331B8E6F923F663")
    public float measureText(String text) {
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1242244614 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1242244614.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1242244614;
        } //End block
        if(text.length() == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1064939934 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_648166761 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_648166761;
        } //End block
        if(!mHasCompatScaling)        
        {
        float var11ADFBC487B3F6CC93D222703EB3CB89_1914821153 = (native_measureText(text));
                float var546ADE640B6EDFBC8A086EF31347E768_23351005 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_23351005;
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_294986184 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_1746500716 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1746500716;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.523 -0400", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "475C6F47691134A72900DE190EB50F0C")
    private float native_measureText(String text) {
        float var546ADE640B6EDFBC8A086EF31347E768_477411263 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_477411263;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.524 -0400", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "0699BA9DA5CB9B3052EB376B17710870")
    public float measureText(CharSequence text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_782057928 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_782057928.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_782057928;
        } //End block
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1093980131 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1093980131.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1093980131;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_2111656485 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1301892232 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1301892232;
        } //End block
        if(text instanceof String)        
        {
            float var8329CA8B64ECC977BE7A1503C212DD63_424627100 = (measureText((String)text, start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_1051623250 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1051623250;
        } //End block
        if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            float var72D129C3BAA89420B492736807AD7986_1769446521 = (measureText(text.toString(), start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_864427350 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_864427350;
        } //End block
        if(text instanceof GraphicsOperations)        
        {
            float var34E05A0D64873628034B29F38D31156B_1660147066 = (((GraphicsOperations)text).measureText(start, end, this));
                        float var546ADE640B6EDFBC8A086EF31347E768_1947487415 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1947487415;
        } //End block
        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        float result = measureText(buf, 0, end - start);
        TemporaryBuffer.recycle(buf);
        float varB4A88417B3D0170D754C647C30B7216A_1360610681 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_1172244884 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1172244884;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.524 -0400", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "75BEF17BE6036610BCF795545CAEDEC7")
    public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        addTaint(measuredWidth[0]);
        addTaint(maxWidth);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1713920802 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1713920802.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1713920802;
        } //End block
        if(index < 0 || text.length - index < Math.abs(count))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_880180782 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_880180782.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_880180782;
        } //End block
        if(text.length == 0 || count == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1462765878 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_873656716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_873656716;
        } //End block
        if(!mHasCompatScaling)        
        {
            int var8A583F46EBF403D863EC3EF27D8283AC_703164311 = (native_breakText(text, index, count, maxWidth, measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382409901 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382409901;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        if(measuredWidth != null)        
        measuredWidth[0] *= mInvCompatScaling;
        int var9B207167E5381C47682C6B4F58A623FB_1044023825 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914292855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914292855;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.524 -0400", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "A83375C0C9E2220214EB277D5CD8B82F")
    private int native_breakText(char[] text, int index, int count,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970943337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970943337;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.525 -0400", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "31254EBCDD1654A879B4CE0069332C55")
    public int breakText(CharSequence text, int start, int end,
                         boolean measureForwards,
                         float maxWidth, float[] measuredWidth) {
        addTaint(measuredWidth[0]);
        addTaint(maxWidth);
        addTaint(measureForwards);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1476283340 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1476283340.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1476283340;
        } //End block
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_343207528 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_343207528.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_343207528;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_300663616 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102199762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102199762;
        } //End block
        if(start == 0 && text instanceof String && end == text.length())        
        {
            int varA0C7DD3C65929EA4C17B796AE9736DE9_1560398025 = (breakText((String) text, measureForwards, maxWidth,
                             measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497277668 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497277668;
        } //End block
        char[] buf = TemporaryBuffer.obtain(end - start);
        int result;
        TextUtils.getChars(text, start, end, buf, 0);
        if(measureForwards)        
        {
            result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
        } //End block
        else
        {
            result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
        } //End block
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_1076281819 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896573196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896573196;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.525 -0400", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "DA0ECA20807D18EC364867E2763146FB")
    public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        addTaint(measuredWidth[0]);
        addTaint(maxWidth);
        addTaint(measureForwards);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1761648567 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1761648567.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1761648567;
        } //End block
        if(text.length() == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_251603677 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336159404 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336159404;
        } //End block
        if(!mHasCompatScaling)        
        {
            int varEDAC3B0C717B953A5CA86AF2F480D6B2_1546301486 = (native_breakText(text, measureForwards, maxWidth, measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503315479 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503315479;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        if(measuredWidth != null)        
        measuredWidth[0] *= mInvCompatScaling;
        int var9B207167E5381C47682C6B4F58A623FB_1432877228 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337366328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337366328;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.526 -0400", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "5B7D0869BBD00A42C78236B12039C713")
    private int native_breakText(String text, boolean measureForwards,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014747681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014747681;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.526 -0400", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "19CA253888C59B9EA580EFCE7E113FE3")
    public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        addTaint(widths[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_2112250649 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_2112250649.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_2112250649;
        } //End block
        if((index | count) < 0 || index + count > text.length
                || count > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_275037132 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_275037132.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_275037132;
        } //End block
        if(text.length == 0 || count == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1288434093 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421253916 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421253916;
        } //End block
        if(!mHasCompatScaling)        
        {
            int varFD1D13D12ADD3222776A56363A0033F8_744012544 = (native_getTextWidths(mNativePaint, text, index, count, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000168394 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000168394;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, index, count, widths);
        setTextSize(oldSize);
for(int i=0;i<res;i++)
        {
            widths[i] *= mInvCompatScaling;
        } //End block
        int var9B207167E5381C47682C6B4F58A623FB_1903307594 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662049008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662049008;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.527 -0400", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "B9657A03E3038413A87EEFCC65BC51D1")
    public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        addTaint(widths[0]);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_434686005 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_434686005.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_434686005;
        } //End block
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_442884670 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_442884670.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_442884670;
        } //End block
        if(end - start > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1172036020 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1172036020.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1172036020;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1585030260 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060481575 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060481575;
        } //End block
        if(text instanceof String)        
        {
            int var60ADEAEFC3B23ED16BB6E6A8B6401C37_1642931303 = (getTextWidths((String) text, start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3838161 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3838161;
        } //End block
        if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            int varF9B7FB4729F4B16F5FE2157BCA2A35AE_668409805 = (getTextWidths(text.toString(), start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428790250 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428790250;
        } //End block
        if(text instanceof GraphicsOperations)        
        {
            int var0665F197BF357516D9A14C07113FE128_800144992 = (((GraphicsOperations) text).getTextWidths(start, end,
                                                                 widths, this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687854806 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687854806;
        } //End block
        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        int result = getTextWidths(buf, 0, end - start, widths);
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_620014592 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330507915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330507915;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.527 -0400", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "4E3201DB228D204B705F964CAD5DB38D")
    public int getTextWidths(String text, int start, int end, float[] widths) {
        addTaint(widths[0]);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_270232542 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_270232542.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_270232542;
        } //End block
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_104116164 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_104116164.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_104116164;
        } //End block
        if(end - start > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1567241385 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1567241385.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1567241385;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_998525748 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104600715 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104600715;
        } //End block
        if(!mHasCompatScaling)        
        {
            int varC43F01325A60BBB82679A7C269AE62EA_2035275516 = (native_getTextWidths(mNativePaint, text, start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941163179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941163179;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, start, end, widths);
        setTextSize(oldSize);
for(int i=0;i<res;i++)
        {
            widths[i] *= mInvCompatScaling;
        } //End block
        int var9B207167E5381C47682C6B4F58A623FB_102140676 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678175282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678175282;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.527 -0400", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "EB3074DCAEAD0F962198E584F42C426D")
    public int getTextWidths(String text, float[] widths) {
        addTaint(widths[0]);
        addTaint(text.getTaint());
        int var4617C28D9589F5653FEC03B7A4E6137E_60426153 = (getTextWidths(text, 0, text.length(), widths));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798916806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798916806;
        // ---------- Original Method ----------
        //return getTextWidths(text, 0, text.length(), widths);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.528 -0400", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "DBC2CA675D179B3BFE1547654B9DDF37")
    public int getTextGlyphs(String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        addTaint(glyphs[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1920454996 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1920454996.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1920454996;
        } //End block
        if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_1547525074 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_1547525074.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_1547525074;
        } //End block
        if((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_796278476 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_796278476.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_796278476;
        } //End block
        if(end - start > glyphs.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_12659372 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_12659372.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_12659372;
        } //End block
        int var0F649BDADDAF679F4381081F2BA1C5F3_2004285898 = (native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                flags, glyphs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804322196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804322196;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.528 -0400", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "FE6377F462C3EDA77832B3545059C102")
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex) {
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextCount);
        addTaint(contextIndex);
        addTaint(count);
        addTaint(index);
        addTaint(chars[0]);
        float var284A9FEDCF47916BBC72FA22D715FCD4_1213229041 = (getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_398164748 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_398164748;
        // ---------- Original Method ----------
        //return getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                //advances, advancesIndex, 0 );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.529 -0400", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "68D328A62AB20CDB6A0FEA06652E0C00")
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex, int reserved) {
        addTaint(reserved);
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextCount);
        addTaint(contextIndex);
        addTaint(count);
        addTaint(index);
        addTaint(chars[0]);
        if(chars == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_17793531 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_17793531.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_17793531;
        } //End block
        if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_1890411551 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_1890411551.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_1890411551;
        } //End block
        if((index | count | contextIndex | contextCount | advancesIndex
                | (index - contextIndex) | (contextCount - count)
                | ((contextIndex + contextCount) - (index + count))
                | (chars.length - (contextIndex + contextCount))
                | (advances == null ? 0 :
                    (advances.length - (advancesIndex + count)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1629770274 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1629770274.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1629770274;
        } //End block
        if(chars.length == 0 || count == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1872136108 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_86926867 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_86926867;
        } //End block
        if(!mHasCompatScaling)        
        {
            float varE544EB49886AE438A5634DCA68684C35_448038368 = (native_getTextRunAdvances(mNativePaint, chars, index, count,
                    contextIndex, contextCount, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_283291608 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_283291608;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float res = native_getTextRunAdvances(mNativePaint, chars, index, count,
                contextIndex, contextCount, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);
        if(advances != null)        
        {
for(int i = advancesIndex, e = i + count;i < e;i++)
            {
                advances[i] *= mInvCompatScaling;
            } //End block
        } //End block
        float var8466095FFDD3B243DF53150386ADE184_408187377 = (res * mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_872314481 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_872314481;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.529 -0400", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "A7EF4F7DC2C3C4BC1B19A2046596DD02")
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex) {
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        float var50746E0DA3A1F00D008EA88B96400E8A_1605866402 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_1191829375 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1191829375;
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.530 -0400", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "52D9A5695EDC37F83FAC9F1D2E5691E9")
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex, int reserved) {
        addTaint(reserved);
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_506905684 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_506905684.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_506905684;
        } //End block
        if((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2035803355 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_2035803355.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_2035803355;
        } //End block
        if(text instanceof String)        
        {
            float var5519FADAE51E3E4F6C01623397DCE421_1936044514 = (getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1455282464 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1455282464;
        } //End block
        if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            float var686FAEF320E165943BBF86BA646E6891_875510808 = (getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1595320247 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1595320247;
        } //End block
        if(text instanceof GraphicsOperations)        
        {
            float varE85C7458E8B75AD2B0841C3AB014DDD9_1629252067 = (((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this));
                        float var546ADE640B6EDFBC8A086EF31347E768_1447669017 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1447669017;
        } //End block
        if(text.length() == 0 || end == start)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_812973332 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_2015944737 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2015944737;
        } //End block
        int contextLen = contextEnd - contextStart;
        int len = end - start;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        float result = getTextRunAdvances(buf, start - contextStart, len,
                0, contextLen, flags, advances, advancesIndex, reserved);
        TemporaryBuffer.recycle(buf);
        float varB4A88417B3D0170D754C647C30B7216A_650215933 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_2035044580 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2035044580;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.530 -0400", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "DB4C0991BA551EC979FBC01C8C0E1464")
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex) {
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        float var50746E0DA3A1F00D008EA88B96400E8A_146615870 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_1504027518 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1504027518;
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.533 -0400", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "FCDBDB246B10E07B836B61BB971EF9F5")
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex, int reserved) {
        addTaint(reserved);
        addTaint(advancesIndex);
        addTaint(advances[0]);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_82333314 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_82333314.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_82333314;
        } //End block
        if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_1737400497 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_1737400497.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_1737400497;
        } //End block
        if((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1876602117 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1876602117.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1876602117;
        } //End block
        if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1197769826 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_806268048 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_806268048;
        } //End block
        if(!mHasCompatScaling)        
        {
            float var9C803B9AF8B8ADF4A9DF7E682889B037_832775743 = (native_getTextRunAdvances(mNativePaint, text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1208586968 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1208586968;
        } //End block
        final float oldSize = getTextSize();
        setTextSize(oldSize * mCompatScaling);
        float totalAdvance = native_getTextRunAdvances(mNativePaint, text, start, end,
                contextStart, contextEnd, flags, advances, advancesIndex, reserved);
        setTextSize(oldSize);
        if(advances != null)        
        {
for(int i = advancesIndex, e = i + (end - start);i < e;i++)
            {
                advances[i] *= mInvCompatScaling;
            } //End block
        } //End block
        float var52DE27C379CD7E6D9FBCC5964642D0C7_1232342761 = (totalAdvance * mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_937145863 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_937145863;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.533 -0400", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "4167FAF005FD7236568AD56A6ACD9BB6")
    public int getTextRunCursor(char[] text, int contextStart, int contextLength,
            int flags, int offset, int cursorOpt) {
        addTaint(cursorOpt);
        addTaint(offset);
        addTaint(flags);
        addTaint(contextLength);
        addTaint(contextStart);
        addTaint(text[0]);
        int contextEnd = contextStart + contextLength;
        if(((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_661367856 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_661367856.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_661367856;
        } //End block
        int var7E8D60AB1C0E0030E9B360A74B8FE480_1270041625 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextLength, flags, offset, cursorOpt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204265882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204265882;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.534 -0400", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "89F5DC40E8B7DF0BDE94D2EEACEBBBD5")
    public int getTextRunCursor(CharSequence text, int contextStart,
           int contextEnd, int flags, int offset, int cursorOpt) {
        addTaint(cursorOpt);
        addTaint(offset);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(text.getTaint());
        if(text instanceof String || text instanceof SpannedString ||
                text instanceof SpannableString)        
        {
            int varD986F6991E2BCD064C355D1FFAC5D96C_1300694000 = (getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652330037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652330037;
        } //End block
        if(text instanceof GraphicsOperations)        
        {
            int varEB33E8704606CCAAF7704FBDEC219F44_417305813 = (((GraphicsOperations) text).getTextRunCursor(
                    contextStart, contextEnd, flags, offset, cursorOpt, this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451904716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451904716;
        } //End block
        int contextLen = contextEnd - contextStart;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        int result = getTextRunCursor(buf, 0, contextLen, flags, offset - contextStart, cursorOpt);
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_956737210 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634247677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634247677;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.534 -0400", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "53E12CD1BDFBE377DA7028405D64C6B4")
    public int getTextRunCursor(String text, int contextStart, int contextEnd,
            int flags, int offset, int cursorOpt) {
        addTaint(cursorOpt);
        addTaint(offset);
        addTaint(flags);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(text.getTaint());
        if(((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length() - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_471259133 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_471259133.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_471259133;
        } //End block
        int var253BD0BF1E08F15BC3132544C1BCD5E8_230769231 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextEnd, flags, offset, cursorOpt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088335812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088335812;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.534 -0400", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "59252D0443A078198FBE6B98787125B5")
    public void getTextPath(char[] text, int index, int count,
                            float x, float y, Path path) {
        addTaint(path.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if((index | count) < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_429826681 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_429826681.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_429826681;
        } //End block
        native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                path.ni());
        // ---------- Original Method ----------
        //if ((index | count) < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                //path.ni());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.534 -0400", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "B534802614AC58994340AE743B86AAC1")
    public void getTextPath(String text, int start, int end,
                            float x, float y, Path path) {
        addTaint(path.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1423805862 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1423805862.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1423805862;
        } //End block
        native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                path.ni());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                //path.ni());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.535 -0400", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "8916608672347E6DC18B499268CCAFE8")
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1296913590 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1296913590.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1296913590;
        } //End block
        if(bounds == null)        
        {
            NullPointerException var1736C57BDD30DB87CD6E2B590A713613_1821627068 = new NullPointerException("need bounds Rect");
            var1736C57BDD30DB87CD6E2B590A713613_1821627068.addTaint(taint);
            throw var1736C57BDD30DB87CD6E2B590A713613_1821627068;
        } //End block
        nativeGetStringBounds(mNativePaint, text, start, end, bounds);
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (bounds == null) {
            //throw new NullPointerException("need bounds Rect");
        //}
        //nativeGetStringBounds(mNativePaint, text, start, end, bounds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.535 -0400", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "28FE9D91E01268A376AC8B46F1692F07")
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if((index | count) < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_999245659 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_999245659.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_999245659;
        } //End block
        if(bounds == null)        
        {
            NullPointerException var1736C57BDD30DB87CD6E2B590A713613_312062142 = new NullPointerException("need bounds Rect");
            var1736C57BDD30DB87CD6E2B590A713613_312062142.addTaint(taint);
            throw var1736C57BDD30DB87CD6E2B590A713613_312062142;
        } //End block
        nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
        // ---------- Original Method ----------
        //if ((index | count) < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (bounds == null) {
            //throw new NullPointerException("need bounds Rect");
        //}
        //nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.535 -0400", hash_original_method = "925DF10B1DD177E135B07F96DE8E7F32", hash_generated_method = "DF419449CAA1B777D791C6F5EE64D2ED")
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

    
    @DSModeled(DSC.SAFE)
    private static int native_init() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_initWithPaint(int paint) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_reset(int native_object) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_set(int native_dst, int native_src) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getStyle(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setStyle(int native_object, int style) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getStrokeCap(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setStrokeCap(int native_object, int cap) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getStrokeJoin(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setStrokeJoin(int native_object,
                                                    int join) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_getFillPath(int native_object,
                                                     int src, int dst) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setShader(int native_object, int shader) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setColorFilter(int native_object,
                                                    int filter) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setXfermode(int native_object,
                                                 int xfermode) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setPathEffect(int native_object,
                                                   int effect) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setMaskFilter(int native_object,
                                                   int maskfilter) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setTypeface(int native_object,
                                                 int typeface) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setRasterizer(int native_object,
                                                   int rasterizer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getTextAlign(int native_object) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setTextAlign(int native_object,
                                                   int align) {
    }

    
    @DSModeled(DSC.SAFE)
    private static float native_getFontMetrics(int native_paint,
                                                      FontMetrics metrics) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getTextWidths(int native_object,
                            char[] text, int index, int count, float[] widths) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getTextWidths(int native_object,
                            String text, int start, int end, float[] widths) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_getTextGlyphs(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float native_getTextRunAdvances(int native_object,
            char[] text, int index, int count, int contextIndex, int contextCount,
            int flags, float[] advances, int advancesIndex, int reserved) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float native_getTextRunAdvances(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, int reserved) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.541 -0400", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "9CE68059979C116BFC5573553158E883")
    private int native_getTextRunCursor(int native_object, char[] text,
            int contextStart, int contextLength, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952415407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952415407;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.542 -0400", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "74D622F753F1692D9D5D7CC7E69ECB8B")
    private int native_getTextRunCursor(int native_object, String text,
            int contextStart, int contextEnd, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305254298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305254298;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_getTextPath(int native_object, int bidiFlags,
                char[] text, int index, int count, float x, float y, int path) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_getTextPath(int native_object, int bidiFlags,
                String text, int start, int end, float x, float y, int path) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetStringBounds(int nativePaint,
                                String text, int start, int end, Rect bounds) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetCharArrayBounds(int nativePaint,
                                char[] text, int index, int count, Rect bounds) {
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.546 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "F9D622C84E97B0C2CBDBCB618909D322")

        public float top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.546 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "A796C466A86DB299E2750CA9F2E8F71A")

        public float ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.546 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "A16D9583A878BCA686CD4BEDA3A7949E")

        public float descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "3601A2C074D2F75BE50976E0F9B684C6")

        public float bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "888796604577C49ABEC23552DFF6B4E6")

        public float leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_method = "9D0F6E676FD14A88D6B94EA1234A3DC2", hash_generated_method = "9D0F6E676FD14A88D6B94EA1234A3DC2")
        public FontMetrics ()
        {
            //Synthesized constructor
        }


    }


    
    public static class FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

        public int top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "FA14915E4ED5D34F11F90DF8ECCA8FF2")

        public int ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.547 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "28172A09342BA30A11EF1965F08565DD")

        public int descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.548 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

        public int bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.548 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "EE2E8A507D7730016199EA97319493B2")

        public int leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.548 -0400", hash_original_method = "8179D96EF0A0532FF84A77E27487BF14", hash_generated_method = "8179D96EF0A0532FF84A77E27487BF14")
        public FontMetricsInt ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "3B963AF2C8B8DE7BFA394AC5C9B9CD2E")
        @Override
        public String toString() {
String varF92B29C833F745C8BC7C58B9EE6A4D06_75763926 =             "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    " descent=" + descent + " bottom=" + bottom +
                    " leading=" + leading;
            varF92B29C833F745C8BC7C58B9EE6A4D06_75763926.addTaint(taint);
            return varF92B29C833F745C8BC7C58B9EE6A4D06_75763926;
            // ---------- Original Method ----------
            //return "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    //" descent=" + descent + " bottom=" + bottom +
                    //" leading=" + leading;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_field = "DA21A7D685DD2F0287DF4209A5883DA6", hash_generated_field = "5C49143BE7FFA5D3F7B1962C98542BDE")

    static final Style[] sStyleArray = {
        Style.FILL, Style.STROKE, Style.FILL_AND_STROKE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_field = "6FB167C672F318B57B505D87A2054546", hash_generated_field = "DC64E880474C9D8403AA868EB4AA3944")

    static final Cap[] sCapArray = {
        Cap.BUTT, Cap.ROUND, Cap.SQUARE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_field = "817A29AB9F2FBE52718953372FA63797", hash_generated_field = "428598CDD6B0136C38E4F901486168AA")

    static final Join[] sJoinArray = {
        Join.MITER, Join.ROUND, Join.BEVEL
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_field = "D7D8049DA3EF124C474A03CB581B7573", hash_generated_field = "B768A63E818BB42B636833669C3022B6")

    static final Align[] sAlignArray = {
        Align.LEFT, Align.CENTER, Align.RIGHT
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.549 -0400", hash_original_field = "DAED95C98C2D4267466506AA3DAA06AF", hash_generated_field = "45D0C54CC6E381296E91FEFD4D7E9F05")

    public static final int ANTI_ALIAS_FLAG     = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.550 -0400", hash_original_field = "32C79F3C172895E1068B20BB6EF1B730", hash_generated_field = "3B37B87298EB8671D01D36A02B147DBD")

    public static final int FILTER_BITMAP_FLAG  = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.550 -0400", hash_original_field = "4F23A3DB5C72BE721B62DFDF2A927536", hash_generated_field = "16DC79CD5B30E8BBD4718C630596673F")

    public static final int DITHER_FLAG         = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.551 -0400", hash_original_field = "3177915AF2023957BA3DC371F728F3DE", hash_generated_field = "B76EE25AA2E9AE34D9CEE0AE93E3B0AF")

    public static final int UNDERLINE_TEXT_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.551 -0400", hash_original_field = "8922A9753F894FF1F3817F1BDDADBCE6", hash_generated_field = "2E3EA944809E9CBC9A119AA5696756EB")

    public static final int STRIKE_THRU_TEXT_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.551 -0400", hash_original_field = "FE8C2E5F3338DB63879146CE21AB8196", hash_generated_field = "DE9EF5A591F6D71DE416EE9B51EE6EB5")

    public static final int FAKE_BOLD_TEXT_FLAG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "200456E8ACA82EF7148143B7EBB92E26", hash_generated_field = "7F1BE56009FABC11D8C2A24734D2E78C")

    public static final int LINEAR_TEXT_FLAG    = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "2EE5264F466D0CCCCA6FD42ECAA3A082", hash_generated_field = "104067A48B49BC1C75654D92F259E44A")

    public static final int SUBPIXEL_TEXT_FLAG  = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "590BE3871E0A9C676B8DA9EB91D73A5D", hash_generated_field = "B7D127AFEC7155C6CDA53B6A46D2FB5C")

    public static final int DEV_KERN_TEXT_FLAG  = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "11F7E634916EB2B3531D36F0AA006F69", hash_generated_field = "9CF58765CF27F6C03CE44F70BFCDB856")

    static final int DEFAULT_PAINT_FLAGS = DEV_KERN_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "94822D72BA2ED08272F86B1D8CBBB228", hash_generated_field = "7E20082E997CCF5AE3ADDE6EB55F4D14")

    public static final int HINTING_OFF = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "00F8D279832856AAB2482457B470C69C", hash_generated_field = "75F6A241333C1BDE4871EB2D5849C4B4")

    public static final int HINTING_ON = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "36E6A04BF5F69066937E780304BE2372", hash_generated_field = "6F9C6C8D6013846EA024C014B7506D51")

    public static final int BIDI_LTR = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "E99238E9A37B5494B1F6D3374D8A8388", hash_generated_field = "5E8A80ABBBB4622F32D5ECA5E3A02CF1")

    public static final int BIDI_RTL = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "EE0C47E8438ECB20552CEF2D89DC24C8", hash_generated_field = "2F04CC5409C37696637070FBC2BCA711")

    public static final int BIDI_DEFAULT_LTR = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "82417C79DDF40F02CFD62DC0B0BFF557", hash_generated_field = "91CE6515A1DC6EC518B6EF6F7044CC99")

    public static final int BIDI_DEFAULT_RTL = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "E2F3639E9F2BEC4CCE554F5DA6A66B39", hash_generated_field = "96707B9ED197F2C49CEF721789B1CC89")

    public static final int BIDI_FORCE_LTR = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "4477D287153948E3BCC8146F87474210", hash_generated_field = "C8D922D49FF076A4FA47E7AC1C90E71C")

    public static final int BIDI_FORCE_RTL = 0x5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "AD043D77A3F007CF0D78F67B7A122465", hash_generated_field = "80689923EFFED0DEFB8EBF590BABE137")

    private static final int BIDI_MAX_FLAG_VALUE = BIDI_FORCE_RTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "EDE5E0F0C0A7138B12B7543291047D37", hash_generated_field = "F2C5ACAE49EA02FB996F32FA24F9DDEA")

    private static final int BIDI_FLAG_MASK = 0x7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "3156617304B6D40B79220E1E6BFC0BE0", hash_generated_field = "519D5E5540609C6F930879E787B9A0E3")

    public static final int CURSOR_AFTER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "46E4972643B74A1460244D84ED486FD5", hash_generated_field = "87F0976C0F58B633C620CB23E58C9D06")

    public static final int CURSOR_AT_OR_AFTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "4CEF794F11B5E574A3ECFEC23B55ABAD", hash_generated_field = "E937AFFEBC810173CB0EDEB05B57742B")

    public static final int CURSOR_BEFORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.552 -0400", hash_original_field = "0FEA77E88DFD7349A142E7C079F0CD42", hash_generated_field = "59875B95A53D3853447FD50EB38FE659")

    public static final int CURSOR_AT_OR_BEFORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.553 -0400", hash_original_field = "0D7566A26ECAD2F14A1D61E8205D9E27", hash_generated_field = "944FD8D9E2B6685D6BB0D020EFBD576C")

    public static final int CURSOR_AT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.553 -0400", hash_original_field = "6CC78B0C1FCA48FD494AD1FDCE89286A", hash_generated_field = "D6F9958F9851E03048ADF3A5AFE0078A")

    private static final int CURSOR_OPT_MAX_VALUE = CURSOR_AT;
}

