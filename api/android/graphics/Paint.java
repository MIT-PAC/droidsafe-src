package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

public class Paint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.527 -0400", hash_original_field = "D43E64E8DB23D8105EFCFFDFE2703E5E", hash_generated_field = "F9F1B9FB44729EA466DD33DE16A3AB10")

    public int mNativePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.527 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.527 -0400", hash_original_field = "B084716E2B957889ADD456E706B0D908", hash_generated_field = "30CA93EA0A1FDD848EE36D39E7D9E77B")

    private MaskFilter mMaskFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.528 -0400", hash_original_field = "0C964CB18CE5DB6CE248155A69D05850", hash_generated_field = "0970365855BAEB3B93B55E917D7BB807")

    private PathEffect mPathEffect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.528 -0400", hash_original_field = "B8E4807966280C43A678FFEA169DB2BF", hash_generated_field = "E15971EFBFBD92787A66981AB256F5C2")

    private Rasterizer mRasterizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.528 -0400", hash_original_field = "A3C15874DE554606CB943AF3D68F568F", hash_generated_field = "B1952C618C8BBD071ACDDBA82DB64026")

    private Shader mShader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.528 -0400", hash_original_field = "7AFF8BDC578BFE389B910CFF01CF4231", hash_generated_field = "234D9F5A4F790A70ADC301ADC43BEEC1")

    private Typeface mTypeface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.528 -0400", hash_original_field = "28B87225BC1D2D4DDEE55BD61F984139", hash_generated_field = "E20BD0A091050F1F29128E6A824DE542")

    private Xfermode mXfermode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "AC29C10FA86008DC70760D09ABDD8975", hash_generated_field = "41C5D1021B750266A4ADC951970465D5")

    private boolean mHasCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "54878B6CF92B4C69D84F841DD1E3B67B", hash_generated_field = "B75D80F84935274D46B49A2A5EE4E0AB")

    private float mCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "080CF1326240F02CC5113284F8866075", hash_generated_field = "3B482C031B54D0585FB747229A42223A")

    private float mInvCompatScaling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "5ECD95A3EBAA8F5228C8769A496F581F", hash_generated_field = "79432E7E02F51603141CA873F5DC70EF")

    public boolean hasShadow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "0576421823B0FE164EF79686754E859C", hash_generated_field = "5B09CAB9CB4DEB539F28464A0A9AF847")

    public float shadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "B56AC33C6797CC57B93060FF92EE1F0E", hash_generated_field = "E8741946672ABFDF9B3AFE7FAFACA993")

    public float shadowDy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "AEE37AD6DA942F6F9C5FBE1BCF65AC67", hash_generated_field = "584D14064094F2C1B9BDB348A4C8065C")

    public float shadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.529 -0400", hash_original_field = "D14A83C55DBA07A19E2627BF8C98AFB6", hash_generated_field = "F7019584388E8E0B6A5FA29A5D1D5111")

    public int shadowColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.530 -0400", hash_original_field = "ABA7903F07E8350F4F66A9F81A266F4F", hash_generated_field = "EC215250783F837A7E2BDA6A9E3ACA2D")

    public int mBidiFlags = BIDI_DEFAULT_LTR;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.530 -0400", hash_original_method = "07976DE00CD3F977E8ACA514AAEDE967", hash_generated_method = "2E92EC59FFA72681E3F4ECFD5F5383AA")
    public  Paint() {
        this(0);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.531 -0400", hash_original_method = "DD18D0561860908DF0D4B7BC76B2B3D2", hash_generated_method = "ABDF03E9F8EA7583E030156FE4ED96D1")
    public  Paint(int flags) {
        addTaint(flags);
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.531 -0400", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "1E0CEE6CD795EABAB79C1575708D48D5")
    public  Paint(Paint paint) {
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.532 -0400", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "4EC68B4DCAA133DD09A2D2EB6717EEB2")
    public void reset() {
        native_reset(mNativePaint);
        setFlags(DEFAULT_PAINT_FLAGS);
        mHasCompatScaling = false;
        mCompatScaling = mInvCompatScaling = 1;
        mBidiFlags = BIDI_DEFAULT_LTR;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.533 -0400", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "BE014283A449A012B9ACEC8E96B2A509")
    public void set(Paint src) {
        addTaint(src.getTaint());
    if(this != src)        
        {
            native_set(mNativePaint, src.mNativePaint);
            setClassVariablesFrom(src);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.535 -0400", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "BD7871E3A37A563592B6AC84BB6E6C1C")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.535 -0400", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "407FC46B741F88D4037C340D8E4C7070")
    public void setCompatibilityScaling(float factor) {
    if(factor == 1.0)        
        {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } 
        else
        {
            mHasCompatScaling = true;
            mCompatScaling = factor;
            mInvCompatScaling = 1.0f/factor;
        } 
        
        
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.536 -0400", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "C722D59368CA8399AB9F7D3B5D1894AF")
    public int getBidiFlags() {
        int var1748BBD3D4961DC7F03913160F67CAB2_1744971053 = (mBidiFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108585156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108585156;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.536 -0400", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "373B7A896FA995B42835935638CFA736")
    public void setBidiFlags(int flags) {
        flags &= BIDI_FLAG_MASK;
    if(flags > BIDI_MAX_FLAG_VALUE)        
        {
            IllegalArgumentException var5C65497B81547CBCA3C7DC4360BDCA5B_471089973 = new IllegalArgumentException("unknown bidi flag: " + flags);
            var5C65497B81547CBCA3C7DC4360BDCA5B_471089973.addTaint(taint);
            throw var5C65497B81547CBCA3C7DC4360BDCA5B_471089973;
        } 
        mBidiFlags = flags;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.537 -0400", hash_original_method = "1AEF3AE96B7B0567703FA6E8804026B1", hash_generated_method = "8F51C4D5BFE0510C638CA52F3C3FCB03")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988650551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988650551;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.537 -0400", hash_original_method = "7E0C8B4D00EF46DF7C96B7FEFE972867", hash_generated_method = "E81D91BA95CE017C8A6AE2CF5F166A3B")
    public void setFlags(int flags) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.537 -0400", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "6A7ABF64D3970255CCF92092ED9CF343")
    public int getHinting() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619049886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619049886;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.538 -0400", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "BEF76864791FDB477DCC8963BCE4B764")
    public void setHinting(int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.538 -0400", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "3A24918F3FE93E0733AAC901C3294DDD")
    public final boolean isAntiAlias() {
        boolean var642B1B77578F5B92DFE12743626FDDB3_1106064147 = ((getFlags() & ANTI_ALIAS_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825338785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825338785;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.538 -0400", hash_original_method = "8B9E1DF7E3F10B045A1C3ED5825D806F", hash_generated_method = "969C9AD79C602B0B74504E6ADC0CDA95")
    public void setAntiAlias(boolean aa) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.538 -0400", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "16EB6F9A74529B12A6F481B3C593C25F")
    public final boolean isDither() {
        boolean var3935C3521043228D582B5346E9A3ED0C_703092141 = ((getFlags() & DITHER_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689346235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689346235;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.539 -0400", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "885C8677A0ED029E797386D2040088D8")
    public void setDither(boolean dither) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.539 -0400", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "B62EA9FA6F7E4821B9292099279713CE")
    public final boolean isLinearText() {
        boolean var7CF7C722E4323F681C755D27FF58C13F_648581485 = ((getFlags() & LINEAR_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119695931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_119695931;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.539 -0400", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "018998AB05D2191EBA074C9F705B430C")
    public void setLinearText(boolean linearText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.540 -0400", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "FE523AC015F47527D2E7BDBE408E7998")
    public final boolean isSubpixelText() {
        boolean var750E17719AD0F45546FE3847F5A43055_1865695148 = ((getFlags() & SUBPIXEL_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121463867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121463867;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.540 -0400", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "B34B82250E86FDB7DB09A047E0B9AB1E")
    public void setSubpixelText(boolean subpixelText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.550 -0400", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "55267E22566A5B8307D4B3CDE3624376")
    public final boolean isUnderlineText() {
        boolean var8F4035594F35F50D509088F3DD2A2DB2_1973862543 = ((getFlags() & UNDERLINE_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780520614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780520614;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.577 -0400", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "417886D7D175F8B8D55EE0D90CFAE4FA")
    public void setUnderlineText(boolean underlineText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.577 -0400", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "A2E3BC88F5A33C70A103433E5E40192F")
    public final boolean isStrikeThruText() {
        boolean varFEA105DBA375C0A2F032B236A0A2E7F0_284743802 = ((getFlags() & STRIKE_THRU_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444043852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444043852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.578 -0400", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "FB6506C20923BFB227903FF1094AB4FB")
    public void setStrikeThruText(boolean strikeThruText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.578 -0400", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "7D93A572081173674D767587BAAD0635")
    public final boolean isFakeBoldText() {
        boolean var15B427FFF4C33E421851BAED92E8DAFF_999648152 = ((getFlags() & FAKE_BOLD_TEXT_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222750408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222750408;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.578 -0400", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "69207AE83514DFB7DD01C9111E4B061D")
    public void setFakeBoldText(boolean fakeBoldText) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.579 -0400", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "3258BBFCF21B159426C020517024293B")
    public final boolean isFilterBitmap() {
        boolean var819608BAF0AAB38A96B8B58084D72F3C_1257449991 = ((getFlags() & FILTER_BITMAP_FLAG) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319950205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319950205;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.580 -0400", hash_original_method = "B8C11CD7111D9BC247774CFB44C7A8B0", hash_generated_method = "72A4AA63A3BDB8FE50798AE60EFC3156")
    public void setFilterBitmap(boolean filter) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.580 -0400", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "1A39B435711E1D45C9FFC9A80025C4FA")
    public Style getStyle() {
Style var27879EDEA81956155BE56815AB26799D_366769662 =         sStyleArray[native_getStyle(mNativePaint)];
        var27879EDEA81956155BE56815AB26799D_366769662.addTaint(taint);
        return var27879EDEA81956155BE56815AB26799D_366769662;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.581 -0400", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "D22412F550961279E948FD64FC691029")
    public void setStyle(Style style) {
        addTaint(style.getTaint());
        native_setStyle(mNativePaint, style.nativeInt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.584 -0400", hash_original_method = "A6843949A5740747763B245A4340955B", hash_generated_method = "0869AB63E1E8409D0262E95D71C5065E")
    public int getColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592137225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592137225;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.584 -0400", hash_original_method = "6B0B967C1DC4D48EE66A1A874887BE3F", hash_generated_method = "359EC0CDBCF6D3FF497E0AB9CE671581")
    public void setColor(int color) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.584 -0400", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "472608D2F1A772B30C04CDBE8A5B9E4E")
    public int getAlpha() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507523736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507523736;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "319BF4CF7F9EF61753405A8B0B105272")
    public void setAlpha(int a) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "0204EBF369F6F4973C4FCEBD5A585646")
    public void setARGB(int a, int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        addTaint(a);
        setColor((a << 24) | (r << 16) | (g << 8) | b);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "C31D356AAF19AF1BB0047E7D2A9D4FA7")
    public float getStrokeWidth() {
        float var546ADE640B6EDFBC8A086EF31347E768_1021141842 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1021141842;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "564DC2A484C3EEE36BA29C2660B22AD8")
    public void setStrokeWidth(float width) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "6171BB079B611FC57734A26D0F03D698")
    public float getStrokeMiter() {
        float var546ADE640B6EDFBC8A086EF31347E768_1233314702 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1233314702;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "1944134F0761932CBCD4B9547BA850AF")
    public void setStrokeMiter(float miter) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.585 -0400", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "9A84E7EE3287A0FA4665AB5EBC0C60D6")
    public Cap getStrokeCap() {
Cap var5D5320C20783685DBA0D6064E7E86A1D_1230648415 =         sCapArray[native_getStrokeCap(mNativePaint)];
        var5D5320C20783685DBA0D6064E7E86A1D_1230648415.addTaint(taint);
        return var5D5320C20783685DBA0D6064E7E86A1D_1230648415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "277F69D872CDB2B8723F06892A48CE4C")
    public void setStrokeCap(Cap cap) {
        addTaint(cap.getTaint());
        native_setStrokeCap(mNativePaint, cap.nativeInt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "87C6634D2FC5288CCAF676F2843FD7CC")
    public Join getStrokeJoin() {
Join var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1615147696 =         sJoinArray[native_getStrokeJoin(mNativePaint)];
        var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1615147696.addTaint(taint);
        return var6F72EEBDDA6BE12DD8B3C23E8E7F6F0C_1615147696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "605EE2EB145C049007351816BDAFD469")
    public void setStrokeJoin(Join join) {
        addTaint(join.getTaint());
        native_setStrokeJoin(mNativePaint, join.nativeInt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "9B4F3A9A9BC6D17126A3380672C688FA")
    public boolean getFillPath(Path src, Path dst) {
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        boolean var0B1620E3C3242ECB54942755E09EC219_793044151 = (native_getFillPath(mNativePaint, src.ni(), dst.ni()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361995808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361995808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "707A10C36B8AD69F64FAB0F5FBB0AEA3")
    public Shader getShader() {
Shader var1E3A4ADBA26A90CC52B6789FE92E9043_1632685298 =         mShader;
        var1E3A4ADBA26A90CC52B6789FE92E9043_1632685298.addTaint(taint);
        return var1E3A4ADBA26A90CC52B6789FE92E9043_1632685298;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.586 -0400", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "666FAD53FEE7CD343E1FFC2E3E36AA7C")
    public Shader setShader(Shader shader) {
        int shaderNative = 0;
    if(shader != null)        
        shaderNative = shader.native_instance;
        native_setShader(mNativePaint, shaderNative);
        mShader = shader;
Shader varFFC587FB7657AE6653704469EEF0EF8A_403450862 =         shader;
        varFFC587FB7657AE6653704469EEF0EF8A_403450862.addTaint(taint);
        return varFFC587FB7657AE6653704469EEF0EF8A_403450862;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.587 -0400", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "C5C8BE65ECECE3902B9A06B13D1457E1")
    public ColorFilter getColorFilter() {
ColorFilter varEDD194C8C1AE8ED0D309C82968CA83AE_1128358919 =         mColorFilter;
        varEDD194C8C1AE8ED0D309C82968CA83AE_1128358919.addTaint(taint);
        return varEDD194C8C1AE8ED0D309C82968CA83AE_1128358919;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.587 -0400", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "4F59B16ACE65374F7DD8E8225F6050EE")
    public ColorFilter setColorFilter(ColorFilter filter) {
        int filterNative = 0;
    if(filter != null)        
        filterNative = filter.native_instance;
        native_setColorFilter(mNativePaint, filterNative);
        mColorFilter = filter;
ColorFilter varEDAB7C57B2A558E364C3233CE622D985_726199755 =         filter;
        varEDAB7C57B2A558E364C3233CE622D985_726199755.addTaint(taint);
        return varEDAB7C57B2A558E364C3233CE622D985_726199755;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.587 -0400", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "311511616625EF53412FD7551D0871C6")
    public Xfermode getXfermode() {
Xfermode varC511827B29B204E5EAA5182BCB874846_2003017864 =         mXfermode;
        varC511827B29B204E5EAA5182BCB874846_2003017864.addTaint(taint);
        return varC511827B29B204E5EAA5182BCB874846_2003017864;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.587 -0400", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "9241EDDB6F83E65256EAA76E9C234D99")
    public Xfermode setXfermode(Xfermode xfermode) {
        int xfermodeNative = 0;
    if(xfermode != null)        
        xfermodeNative = xfermode.native_instance;
        native_setXfermode(mNativePaint, xfermodeNative);
        mXfermode = xfermode;
Xfermode varC1CEA90A1ECF2887378C37444B43B32D_1517598936 =         xfermode;
        varC1CEA90A1ECF2887378C37444B43B32D_1517598936.addTaint(taint);
        return varC1CEA90A1ECF2887378C37444B43B32D_1517598936;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.587 -0400", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "4B72A85901128CA86E11508531FA7343")
    public PathEffect getPathEffect() {
PathEffect var62231A322915CC0816BA035D0DB999E9_364180788 =         mPathEffect;
        var62231A322915CC0816BA035D0DB999E9_364180788.addTaint(taint);
        return var62231A322915CC0816BA035D0DB999E9_364180788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.588 -0400", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "11AE0ABE39B8EC79BEF52ED86C503A75")
    public PathEffect setPathEffect(PathEffect effect) {
        int effectNative = 0;
    if(effect != null)        
        {
            effectNative = effect.native_instance;
        } 
        native_setPathEffect(mNativePaint, effectNative);
        mPathEffect = effect;
PathEffect varC228D34163331935C47D1C8D0FF6067F_1945920607 =         effect;
        varC228D34163331935C47D1C8D0FF6067F_1945920607.addTaint(taint);
        return varC228D34163331935C47D1C8D0FF6067F_1945920607;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.588 -0400", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "0C9434B61C2B8A64B2A9610A24C51C42")
    public MaskFilter getMaskFilter() {
MaskFilter var212930E76E499C498BBA58BFE514DEFB_682218242 =         mMaskFilter;
        var212930E76E499C498BBA58BFE514DEFB_682218242.addTaint(taint);
        return var212930E76E499C498BBA58BFE514DEFB_682218242;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.588 -0400", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "F381CD78DBFC1F28445A28AE045A0FCE")
    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        int maskfilterNative = 0;
    if(maskfilter != null)        
        {
            maskfilterNative = maskfilter.native_instance;
        } 
        native_setMaskFilter(mNativePaint, maskfilterNative);
        mMaskFilter = maskfilter;
MaskFilter var809F23AFE180E2B871F7AB6111A113AC_1255188903 =         maskfilter;
        var809F23AFE180E2B871F7AB6111A113AC_1255188903.addTaint(taint);
        return var809F23AFE180E2B871F7AB6111A113AC_1255188903;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.588 -0400", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "273DDFB117BAD0EFDF57F345FFF9B631")
    public Typeface getTypeface() {
Typeface varCA555E983FC958B176FA6EA9B4C69E1B_1517093201 =         mTypeface;
        varCA555E983FC958B176FA6EA9B4C69E1B_1517093201.addTaint(taint);
        return varCA555E983FC958B176FA6EA9B4C69E1B_1517093201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.589 -0400", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "F27231D683ACEB6E57FB66A6485E2C01")
    public Typeface setTypeface(Typeface typeface) {
        int typefaceNative = 0;
    if(typeface != null)        
        {
            typefaceNative = typeface.native_instance;
        } 
        native_setTypeface(mNativePaint, typefaceNative);
        mTypeface = typeface;
Typeface varFE051F16B59B46C310898CF1A96D8867_891264285 =         typeface;
        varFE051F16B59B46C310898CF1A96D8867_891264285.addTaint(taint);
        return varFE051F16B59B46C310898CF1A96D8867_891264285;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.589 -0400", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "5E6562D46885A68E1799FB53B8A9952F")
    public Rasterizer getRasterizer() {
Rasterizer varE90C2BC199F6AB692B71C8201A9480EC_659972787 =         mRasterizer;
        varE90C2BC199F6AB692B71C8201A9480EC_659972787.addTaint(taint);
        return varE90C2BC199F6AB692B71C8201A9480EC_659972787;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.589 -0400", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "101ABC958BAFEC2944B964DEFC9B5FF4")
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        int rasterizerNative = 0;
    if(rasterizer != null)        
        {
            rasterizerNative = rasterizer.native_instance;
        } 
        native_setRasterizer(mNativePaint, rasterizerNative);
        mRasterizer = rasterizer;
Rasterizer var284B36D27D5CF0F737A31AF832A95273_1506434994 =         rasterizer;
        var284B36D27D5CF0F737A31AF832A95273_1506434994.addTaint(taint);
        return var284B36D27D5CF0F737A31AF832A95273_1506434994;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.589 -0400", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "890115DE943F753280243985FB0CA4B9")
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        hasShadow = radius > 0.0f;
        shadowRadius = radius;
        shadowDx = dx;
        shadowDy = dy;
        shadowColor = color;
        nSetShadowLayer(radius, dx, dy, color);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.589 -0400", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "DE3CFB24C60627249AA98DBC6D18C4A8")
    private void nSetShadowLayer(float radius, float dx, float dy, int color) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "69C41E78339835181B7060E466C37E39")
    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "738B2285CBD3436BDCC438DD53063C27")
    public Align getTextAlign() {
Align var2FAEB5066D95FB11BAB5CBC4358EE326_1040838282 =         sAlignArray[native_getTextAlign(mNativePaint)];
        var2FAEB5066D95FB11BAB5CBC4358EE326_1040838282.addTaint(taint);
        return var2FAEB5066D95FB11BAB5CBC4358EE326_1040838282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "85F1280E5F607A230D3C2951AC7A491F")
    public void setTextAlign(Align align) {
        addTaint(align.getTaint());
        native_setTextAlign(mNativePaint, align.nativeInt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "82F0B10C63FCD42BD30C207704B6DFBE")
    public float getTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_1457155217 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1457155217;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "D150D3B101DE8920A691C9CE66A42B08")
    public void setTextSize(float textSize) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.590 -0400", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "947F3A05B2AB696ADEC4F501F0368BC5")
    public float getTextScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_244796606 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_244796606;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "75A2C46EA134EC88EFC16602B5352C8F")
    public void setTextScaleX(float scaleX) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "00E093D7CF587C3F9335209906A4380F")
    public float getTextSkewX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1511865150 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1511865150;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "94DEC1BD4F69C9C57DAD152D853AE23B")
    public void setTextSkewX(float skewX) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "BB4E92609BF7B8659FD57C37DEE91B22")
    public float ascent() {
        float var546ADE640B6EDFBC8A086EF31347E768_888134973 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_888134973;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "BB119A75C273E1FCB1E09F430131C560")
    public float descent() {
        float var546ADE640B6EDFBC8A086EF31347E768_1213682708 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1213682708;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.591 -0400", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "EA98DF70DC9CDDA2F07109E91EFBFC9D")
    public float getFontMetrics(FontMetrics metrics) {
        float var546ADE640B6EDFBC8A086EF31347E768_1328825058 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1328825058;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.592 -0400", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "3CE233E305CC32F7CFCEAC420A2227C6")
    public FontMetrics getFontMetrics() {
        FontMetrics fm = new FontMetrics();
        getFontMetrics(fm);
FontMetrics var23595DD9B2392DF50EC435F4E8F21162_494728388 =         fm;
        var23595DD9B2392DF50EC435F4E8F21162_494728388.addTaint(taint);
        return var23595DD9B2392DF50EC435F4E8F21162_494728388;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.592 -0400", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "291812D7B947117624E57A56CC82CF47")
    public int getFontMetricsInt(FontMetricsInt fmi) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793437118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793437118;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.592 -0400", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "59B2A43D3065A99D2AE6D722B3E406D3")
    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fm = new FontMetricsInt();
        getFontMetricsInt(fm);
FontMetricsInt var23595DD9B2392DF50EC435F4E8F21162_2119193918 =         fm;
        var23595DD9B2392DF50EC435F4E8F21162_2119193918.addTaint(taint);
        return var23595DD9B2392DF50EC435F4E8F21162_2119193918;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.592 -0400", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "18705D6ADA5129A14F8706685B889040")
    public float getFontSpacing() {
        float var8BA153667E9D783491847D1270F862D1_740493366 = (getFontMetrics(null));
                float var546ADE640B6EDFBC8A086EF31347E768_770607869 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_770607869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.592 -0400", hash_original_method = "4B30EE6B8828803214F6472A454BF7F0", hash_generated_method = "7B01B45CCBA4EEDFC4543307E896412D")
    public float measureText(char[] text, int index, int count) {
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_521614464 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_521614464.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_521614464;
        } 
    if((index | count) < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_225077145 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_225077145.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_225077145;
        } 
    if(text.length == 0 || count == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_460225673 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_2016447354 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2016447354;
        } 
    if(!mHasCompatScaling)        
        {
            float var70E7EAC1B676F157C2A482F4E1928574_183903877 = (native_measureText(text, index, count));
                        float var546ADE640B6EDFBC8A086EF31347E768_1947106822 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1947106822;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_577389730 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_602107834 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_602107834;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.593 -0400", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "808C7CD144FCA910BF23134C7786DFD0")
    private float native_measureText(char[] text, int index, int count) {
        float var546ADE640B6EDFBC8A086EF31347E768_185096764 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_185096764;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.593 -0400", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "8F55AE34B78072E2FA10B4023F0EA814")
    public float measureText(String text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_2118908969 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_2118908969.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_2118908969;
        } 
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1857645407 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1857645407.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1857645407;
        } 
    if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1064642064 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_911351551 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_911351551;
        } 
    if(!mHasCompatScaling)        
        {
            float var0E5E906619CE1361070518A4A6F8ABDF_1213425280 = (native_measureText(text, start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_1468386468 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1468386468;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, start, end);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_565483290 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_2019707045 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2019707045;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.593 -0400", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "A198DA4CE10E8B48CB4217CA6E39DF04")
    private float native_measureText(String text, int start, int end) {
        float var546ADE640B6EDFBC8A086EF31347E768_333200503 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_333200503;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.594 -0400", hash_original_method = "C4C224EF0059A9B14092F4800A14BAD4", hash_generated_method = "C7D5280B11187A33F999E3A27D2CDFBC")
    public float measureText(String text) {
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_34239182 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_34239182.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_34239182;
        } 
    if(text.length() == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1427784809 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_539825869 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_539825869;
        } 
    if(!mHasCompatScaling)        
        {
        float var11ADFBC487B3F6CC93D222703EB3CB89_1484433492 = (native_measureText(text));
                float var546ADE640B6EDFBC8A086EF31347E768_268896105 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_268896105;
        }
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        float varF27CD9A53B1576228E8FA5C91E3FCA65_2017675372 = (w*mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_1070963240 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1070963240;
        
        
            
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.594 -0400", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "CEA0C53E66C091A317322E14D9684BCB")
    private float native_measureText(String text) {
        float var546ADE640B6EDFBC8A086EF31347E768_494918990 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_494918990;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.594 -0400", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "7A24A30B368E59FD9B7A707212608D11")
    public float measureText(CharSequence text, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_425937396 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_425937396.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_425937396;
        } 
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1562676085 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1562676085.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1562676085;
        } 
    if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_346882436 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1407831885 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1407831885;
        } 
    if(text instanceof String)        
        {
            float var8329CA8B64ECC977BE7A1503C212DD63_212941185 = (measureText((String)text, start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_1293860205 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1293860205;
        } 
    if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            float var72D129C3BAA89420B492736807AD7986_1521885792 = (measureText(text.toString(), start, end));
                        float var546ADE640B6EDFBC8A086EF31347E768_2004521980 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2004521980;
        } 
    if(text instanceof GraphicsOperations)        
        {
            float var34E05A0D64873628034B29F38D31156B_1296352665 = (((GraphicsOperations)text).measureText(start, end, this));
                        float var546ADE640B6EDFBC8A086EF31347E768_467563297 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_467563297;
        } 
        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        float result = measureText(buf, 0, end - start);
        TemporaryBuffer.recycle(buf);
        float varB4A88417B3D0170D754C647C30B7216A_604369909 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_542780309 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_542780309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.595 -0400", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "5F363656392CF49EDEAE42A864ECDF35")
    public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        addTaint(measuredWidth[0]);
        addTaint(maxWidth);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_943526223 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_943526223.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_943526223;
        } 
    if(index < 0 || text.length - index < Math.abs(count))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1765310328 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1765310328.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1765310328;
        } 
    if(text.length == 0 || count == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_294572468 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363051499 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363051499;
        } 
    if(!mHasCompatScaling)        
        {
            int var8A583F46EBF403D863EC3EF27D8283AC_998474558 = (native_breakText(text, index, count, maxWidth, measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990515704 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990515704;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
    if(measuredWidth != null)        
        measuredWidth[0] *= mInvCompatScaling;
        int var9B207167E5381C47682C6B4F58A623FB_625469086 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849402416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849402416;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.595 -0400", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "345B7502BCE865ADE019F364058EA9FF")
    private int native_breakText(char[] text, int index, int count,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368949564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368949564;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.595 -0400", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "E0C70D617D00A5D84F6CC6E37A3CF5A2")
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
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1404066011 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1404066011.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1404066011;
        } 
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1074095179 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1074095179.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1074095179;
        } 
    if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1378275192 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436014882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436014882;
        } 
    if(start == 0 && text instanceof String && end == text.length())        
        {
            int varA0C7DD3C65929EA4C17B796AE9736DE9_1146317442 = (breakText((String) text, measureForwards, maxWidth,
                             measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428801754 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428801754;
        } 
        char[] buf = TemporaryBuffer.obtain(end - start);
        int result;
        TextUtils.getChars(text, start, end, buf, 0);
    if(measureForwards)        
        {
            result = breakText(buf, 0, end - start, maxWidth, measuredWidth);
        } 
        else
        {
            result = breakText(buf, 0, -(end - start), maxWidth, measuredWidth);
        } 
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_353059700 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814763598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814763598;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.596 -0400", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "7727BD9F8929381BA587E7384D59ADE3")
    public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        addTaint(measuredWidth[0]);
        addTaint(maxWidth);
        addTaint(measureForwards);
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_753330176 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_753330176.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_753330176;
        } 
    if(text.length() == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1709040077 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973443461 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973443461;
        } 
    if(!mHasCompatScaling)        
        {
            int varEDAC3B0C717B953A5CA86AF2F480D6B2_1854061026 = (native_breakText(text, measureForwards, maxWidth, measuredWidth));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74500694 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74500694;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
    if(measuredWidth != null)        
        measuredWidth[0] *= mInvCompatScaling;
        int var9B207167E5381C47682C6B4F58A623FB_517723106 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660105842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660105842;
        
        
            
        
        
            
        
        
            
        
        
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.596 -0400", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "24C491C1EC63577B2EFEC09EAF080DD6")
    private int native_breakText(String text, boolean measureForwards,
                                        float maxWidth, float[] measuredWidth) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426889330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426889330;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.596 -0400", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "9B5BC0D11447F7926DA64914FEAF68C8")
    public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        addTaint(widths[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_760043728 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_760043728.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_760043728;
        } 
    if((index | count) < 0 || index + count > text.length
                || count > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1883718041 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1883718041.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1883718041;
        } 
    if(text.length == 0 || count == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1371137033 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129260135 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129260135;
        } 
    if(!mHasCompatScaling)        
        {
            int varFD1D13D12ADD3222776A56363A0033F8_696387667 = (native_getTextWidths(mNativePaint, text, index, count, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190103214 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190103214;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, index, count, widths);
        setTextSize(oldSize);
for(int i=0;i<res;i++)
        {
            widths[i] *= mInvCompatScaling;
        } 
        int var9B207167E5381C47682C6B4F58A623FB_1674411160 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53179027 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_53179027;
        
        
            
        
        
                
            
        
        
            
        
        
            
        
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.599 -0400", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "33E7EB2053E0A395AE9C27B5B9D4CACA")
    public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        addTaint(widths[0]);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_374664453 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_374664453.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_374664453;
        } 
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_707941768 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_707941768.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_707941768;
        } 
    if(end - start > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_243953719 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_243953719.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_243953719;
        } 
    if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2026998406 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963601895 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963601895;
        } 
    if(text instanceof String)        
        {
            int var60ADEAEFC3B23ED16BB6E6A8B6401C37_1966741411 = (getTextWidths((String) text, start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014328795 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014328795;
        } 
    if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            int varF9B7FB4729F4B16F5FE2157BCA2A35AE_67646613 = (getTextWidths(text.toString(), start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964274751 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964274751;
        } 
    if(text instanceof GraphicsOperations)        
        {
            int var0665F197BF357516D9A14C07113FE128_841714425 = (((GraphicsOperations) text).getTextWidths(start, end,
                                                                 widths, this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360681394 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360681394;
        } 
        char[] buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        int result = getTextWidths(buf, 0, end - start, widths);
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_681330912 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941912580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941912580;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.600 -0400", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "2BFAE27711EA1BE2D405DD5EB077F57E")
    public int getTextWidths(String text, int start, int end, float[] widths) {
        addTaint(widths[0]);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if(text == null)        
        {
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_458512940 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_458512940.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_458512940;
        } 
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1068255912 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1068255912.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1068255912;
        } 
    if(end - start > widths.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_377513750 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_377513750.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_377513750;
        } 
    if(text.length() == 0 || start == end)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_658519032 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231873127 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231873127;
        } 
    if(!mHasCompatScaling)        
        {
            int varC43F01325A60BBB82679A7C269AE62EA_1049691737 = (native_getTextWidths(mNativePaint, text, start, end, widths));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030372112 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030372112;
        } 
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res = native_getTextWidths(mNativePaint, text, start, end, widths);
        setTextSize(oldSize);
for(int i=0;i<res;i++)
        {
            widths[i] *= mInvCompatScaling;
        } 
        int var9B207167E5381C47682C6B4F58A623FB_145977556 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792708365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_792708365;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.600 -0400", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "2709342CAE07F3F81F81F7CAD0F11F0F")
    public int getTextWidths(String text, float[] widths) {
        addTaint(widths[0]);
        addTaint(text.getTaint());
        int var4617C28D9589F5653FEC03B7A4E6137E_1915971340 = (getTextWidths(text, 0, text.length(), widths));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580741623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580741623;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.601 -0400", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "8340B6DD518DBED36F5B2C098832F801")
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
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_378067265 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_378067265.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_378067265;
        } 
    if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_273995603 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_273995603.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_273995603;
        } 
    if((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_994066722 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_994066722.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_994066722;
        } 
    if(end - start > glyphs.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_372974027 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_372974027.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_372974027;
        } 
        int var0F649BDADDAF679F4381081F2BA1C5F3_985281752 = (native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                flags, glyphs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017330648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017330648;
        
        
            
        
        
            
        
        
                
                
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.601 -0400", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "2FC5C53F0D0EE0ECCD140F768D4E4500")
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
        float var284A9FEDCF47916BBC72FA22D715FCD4_2115449898 = (getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_199670100 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_199670100;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.602 -0400", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "D056010293E48D3E135CE6CF35207291")
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
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_815693753 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_815693753.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_815693753;
        } 
    if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_1382971553 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_1382971553.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_1382971553;
        } 
    if((index | count | contextIndex | contextCount | advancesIndex
                | (index - contextIndex) | (contextCount - count)
                | ((contextIndex + contextCount) - (index + count))
                | (chars.length - (contextIndex + contextCount))
                | (advances == null ? 0 :
                    (advances.length - (advancesIndex + count)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1312172677 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1312172677.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1312172677;
        } 
    if(chars.length == 0 || count == 0)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_1893334179 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_1435693850 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1435693850;
        } 
    if(!mHasCompatScaling)        
        {
            float varE544EB49886AE438A5634DCA68684C35_388222553 = (native_getTextRunAdvances(mNativePaint, chars, index, count,
                    contextIndex, contextCount, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1282125081 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1282125081;
        } 
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
            } 
        } 
        float var8466095FFDD3B243DF53150386ADE184_940527580 = (res * mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_257166561 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_257166561;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.602 -0400", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "EF2DF4F4A7E56109A87E4528493E8F1B")
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
        float var50746E0DA3A1F00D008EA88B96400E8A_1052502649 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_389797631 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_389797631;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.603 -0400", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "8CB2E201BBC0789A08E171A342BC7E1C")
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
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_1000078241 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_1000078241.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_1000078241;
        } 
    if((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1267425544 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1267425544.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1267425544;
        } 
    if(text instanceof String)        
        {
            float var5519FADAE51E3E4F6C01623397DCE421_652212856 = (getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_1831172441 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1831172441;
        } 
    if(text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            float var686FAEF320E165943BBF86BA646E6891_1530885270 = (getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_2026774263 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2026774263;
        } 
    if(text instanceof GraphicsOperations)        
        {
            float varE85C7458E8B75AD2B0841C3AB014DDD9_517897589 = (((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this));
                        float var546ADE640B6EDFBC8A086EF31347E768_1075035758 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1075035758;
        } 
    if(text.length() == 0 || end == start)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_676571227 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_324567019 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_324567019;
        } 
        int contextLen = contextEnd - contextStart;
        int len = end - start;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        float result = getTextRunAdvances(buf, start - contextStart, len,
                0, contextLen, flags, advances, advancesIndex, reserved);
        TemporaryBuffer.recycle(buf);
        float varB4A88417B3D0170D754C647C30B7216A_939750831 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_14822115 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_14822115;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.603 -0400", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "386B1CA6C5C6A5BE9F97278773C239FA")
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
        float var50746E0DA3A1F00D008EA88B96400E8A_1611415399 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
                float var546ADE640B6EDFBC8A086EF31347E768_920537454 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_920537454;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.604 -0400", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "9D4EE3AC47034E8D071025A0DA6A1014")
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
            IllegalArgumentException var1FDFBD3F02B83E5057FC176C56EA0812_897209929 = new IllegalArgumentException("text cannot be null");
            var1FDFBD3F02B83E5057FC176C56EA0812_897209929.addTaint(taint);
            throw var1FDFBD3F02B83E5057FC176C56EA0812_897209929;
        } 
    if(flags != DIRECTION_LTR && flags != DIRECTION_RTL)        
        {
            IllegalArgumentException var8F19F9786638A028A605EEB6EE96D8C3_516876221 = new IllegalArgumentException("unknown flags value: " + flags);
            var8F19F9786638A028A605EEB6EE96D8C3_516876221.addTaint(taint);
            throw var8F19F9786638A028A605EEB6EE96D8C3_516876221;
        } 
    if((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_923019619 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_923019619.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_923019619;
        } 
    if(text.length() == 0 || start == end)        
        {
            float var7DFF51CA8EB990122513F24FFDAA4D9A_135676823 = (0f);
                        float var546ADE640B6EDFBC8A086EF31347E768_820685584 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_820685584;
        } 
    if(!mHasCompatScaling)        
        {
            float var9C803B9AF8B8ADF4A9DF7E682889B037_212378773 = (native_getTextRunAdvances(mNativePaint, text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
                        float var546ADE640B6EDFBC8A086EF31347E768_710368932 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_710368932;
        } 
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
            } 
        } 
        float var52DE27C379CD7E6D9FBCC5964642D0C7_992549077 = (totalAdvance * mInvCompatScaling);
                float var546ADE640B6EDFBC8A086EF31347E768_548322375 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_548322375;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.604 -0400", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "CDBC0FB6F2981674B4CC8979944BC3D4")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1445160805 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1445160805.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1445160805;
        } 
        int var7E8D60AB1C0E0030E9B360A74B8FE480_110993477 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextLength, flags, offset, cursorOpt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280002052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280002052;
        
        
        
                
                
                
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.605 -0400", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "5FA5B5E11C1BD339A2F1CC5961F34B08")
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
            int varD986F6991E2BCD064C355D1FFAC5D96C_1410556349 = (getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470779198 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470779198;
        } 
    if(text instanceof GraphicsOperations)        
        {
            int varEB33E8704606CCAAF7704FBDEC219F44_267712714 = (((GraphicsOperations) text).getTextRunCursor(
                    contextStart, contextEnd, flags, offset, cursorOpt, this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011341186 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011341186;
        } 
        int contextLen = contextEnd - contextStart;
        char[] buf = TemporaryBuffer.obtain(contextLen);
        TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
        int result = getTextRunCursor(buf, 0, contextLen, flags, offset - contextStart, cursorOpt);
        TemporaryBuffer.recycle(buf);
        int varB4A88417B3D0170D754C647C30B7216A_868702601 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957187033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957187033;
        
        
                
            
                    
        
        
            
                    
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.605 -0400", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "44D7013FA232E9D64B8E234113AFE980")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_837502597 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_837502597.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_837502597;
        } 
        int var253BD0BF1E08F15BC3132544C1BCD5E8_1920607898 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextEnd, flags, offset, cursorOpt));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691556190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691556190;
        
        
                
                
                
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.605 -0400", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "BBC179AE525DF5F4F59CC40BF3FE2734")
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
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_914523093 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_914523093.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_914523093;
        } 
        native_getTextPath(mNativePaint, mBidiFlags, text, index, count, x, y, 
                path.ni());
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.606 -0400", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "26E38DF18C4FF7EBE797371B05093B78")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1541400816 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1541400816.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1541400816;
        } 
        native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                path.ni());
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.606 -0400", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "0558BC8847221C9C2EE825FEF8A81240")
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_88782734 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_88782734.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_88782734;
        } 
    if(bounds == null)        
        {
            NullPointerException var1736C57BDD30DB87CD6E2B590A713613_809652552 = new NullPointerException("need bounds Rect");
            var1736C57BDD30DB87CD6E2B590A713613_809652552.addTaint(taint);
            throw var1736C57BDD30DB87CD6E2B590A713613_809652552;
        } 
        nativeGetStringBounds(mNativePaint, text, start, end, bounds);
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.606 -0400", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "013D791FEE1F4356B5E294A3746A2078")
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        addTaint(bounds.getTaint());
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
    if((index | count) < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1316091128 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1316091128.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1316091128;
        } 
    if(bounds == null)        
        {
            NullPointerException var1736C57BDD30DB87CD6E2B590A713613_650908106 = new NullPointerException("need bounds Rect");
            var1736C57BDD30DB87CD6E2B590A713613_650908106.addTaint(taint);
            throw var1736C57BDD30DB87CD6E2B590A713613_650908106;
        } 
        nativeGetCharArrayBounds(mNativePaint, text, index, count, bounds);
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.606 -0400", hash_original_method = "925DF10B1DD177E135B07F96DE8E7F32", hash_generated_method = "DF419449CAA1B777D791C6F5EE64D2ED")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            finalizer(mNativePaint);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.609 -0400", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "8F051FF70C7FDA7C3F19E76F17024CFE")
    private int native_getTextRunCursor(int native_object, char[] text,
            int contextStart, int contextLength, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090277734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090277734;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.609 -0400", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "617F8A39C03C73BF3D8E92F13F1BF109")
    private int native_getTextRunCursor(int native_object, String text,
            int contextStart, int contextEnd, int flags, int offset, int cursorOpt) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1506350307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1506350307;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "F9D622C84E97B0C2CBDBCB618909D322")

        public float top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "A796C466A86DB299E2750CA9F2E8F71A")

        public float ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "A16D9583A878BCA686CD4BEDA3A7949E")

        public float descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "3601A2C074D2F75BE50976E0F9B684C6")

        public float bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "888796604577C49ABEC23552DFF6B4E6")

        public float leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.613 -0400", hash_original_method = "9D0F6E676FD14A88D6B94EA1234A3DC2", hash_generated_method = "9D0F6E676FD14A88D6B94EA1234A3DC2")
        public FontMetrics ()
        {
            
        }


    }


    
    public static class FontMetricsInt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "4FB04C904AA02F82B407995BA570583C")

        public int top;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "A1A9983BFBFB713CE08AB3961E93F741", hash_generated_field = "FA14915E4ED5D34F11F90DF8ECCA8FF2")

        public int ascent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "02E251094E7D27130BE25530E2AE708F", hash_generated_field = "28172A09342BA30A11EF1965F08565DD")

        public int descent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "F7035266BD2A20B12FE551C6FAE7D704")

        public int bottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "4C8C5196B43F3F53984E975BD506A788", hash_generated_field = "EE2E8A507D7730016199EA97319493B2")

        public int leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_method = "8179D96EF0A0532FF84A77E27487BF14", hash_generated_method = "8179D96EF0A0532FF84A77E27487BF14")
        public FontMetricsInt ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "C53F893D75BF03680F3D9F25D48180D0")
        @Override
        public String toString() {
String varF92B29C833F745C8BC7C58B9EE6A4D06_812295694 =             "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    " descent=" + descent + " bottom=" + bottom +
                    " leading=" + leading;
            varF92B29C833F745C8BC7C58B9EE6A4D06_812295694.addTaint(taint);
            return varF92B29C833F745C8BC7C58B9EE6A4D06_812295694;
            
            
                    
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "DA21A7D685DD2F0287DF4209A5883DA6", hash_generated_field = "5C49143BE7FFA5D3F7B1962C98542BDE")

    static final Style[] sStyleArray = {
        Style.FILL, Style.STROKE, Style.FILL_AND_STROKE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "6FB167C672F318B57B505D87A2054546", hash_generated_field = "DC64E880474C9D8403AA868EB4AA3944")

    static final Cap[] sCapArray = {
        Cap.BUTT, Cap.ROUND, Cap.SQUARE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "817A29AB9F2FBE52718953372FA63797", hash_generated_field = "428598CDD6B0136C38E4F901486168AA")

    static final Join[] sJoinArray = {
        Join.MITER, Join.ROUND, Join.BEVEL
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "D7D8049DA3EF124C474A03CB581B7573", hash_generated_field = "B768A63E818BB42B636833669C3022B6")

    static final Align[] sAlignArray = {
        Align.LEFT, Align.CENTER, Align.RIGHT
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.614 -0400", hash_original_field = "DAED95C98C2D4267466506AA3DAA06AF", hash_generated_field = "45D0C54CC6E381296E91FEFD4D7E9F05")

    public static final int ANTI_ALIAS_FLAG     = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "32C79F3C172895E1068B20BB6EF1B730", hash_generated_field = "3B37B87298EB8671D01D36A02B147DBD")

    public static final int FILTER_BITMAP_FLAG  = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "4F23A3DB5C72BE721B62DFDF2A927536", hash_generated_field = "16DC79CD5B30E8BBD4718C630596673F")

    public static final int DITHER_FLAG         = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "3177915AF2023957BA3DC371F728F3DE", hash_generated_field = "B76EE25AA2E9AE34D9CEE0AE93E3B0AF")

    public static final int UNDERLINE_TEXT_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "8922A9753F894FF1F3817F1BDDADBCE6", hash_generated_field = "2E3EA944809E9CBC9A119AA5696756EB")

    public static final int STRIKE_THRU_TEXT_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "FE8C2E5F3338DB63879146CE21AB8196", hash_generated_field = "DE9EF5A591F6D71DE416EE9B51EE6EB5")

    public static final int FAKE_BOLD_TEXT_FLAG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "200456E8ACA82EF7148143B7EBB92E26", hash_generated_field = "7F1BE56009FABC11D8C2A24734D2E78C")

    public static final int LINEAR_TEXT_FLAG    = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "2EE5264F466D0CCCCA6FD42ECAA3A082", hash_generated_field = "104067A48B49BC1C75654D92F259E44A")

    public static final int SUBPIXEL_TEXT_FLAG  = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "590BE3871E0A9C676B8DA9EB91D73A5D", hash_generated_field = "B7D127AFEC7155C6CDA53B6A46D2FB5C")

    public static final int DEV_KERN_TEXT_FLAG  = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "11F7E634916EB2B3531D36F0AA006F69", hash_generated_field = "9CF58765CF27F6C03CE44F70BFCDB856")

    static final int DEFAULT_PAINT_FLAGS = DEV_KERN_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "94822D72BA2ED08272F86B1D8CBBB228", hash_generated_field = "7E20082E997CCF5AE3ADDE6EB55F4D14")

    public static final int HINTING_OFF = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "00F8D279832856AAB2482457B470C69C", hash_generated_field = "75F6A241333C1BDE4871EB2D5849C4B4")

    public static final int HINTING_ON = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "36E6A04BF5F69066937E780304BE2372", hash_generated_field = "6F9C6C8D6013846EA024C014B7506D51")

    public static final int BIDI_LTR = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "E99238E9A37B5494B1F6D3374D8A8388", hash_generated_field = "5E8A80ABBBB4622F32D5ECA5E3A02CF1")

    public static final int BIDI_RTL = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.615 -0400", hash_original_field = "EE0C47E8438ECB20552CEF2D89DC24C8", hash_generated_field = "2F04CC5409C37696637070FBC2BCA711")

    public static final int BIDI_DEFAULT_LTR = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "82417C79DDF40F02CFD62DC0B0BFF557", hash_generated_field = "91CE6515A1DC6EC518B6EF6F7044CC99")

    public static final int BIDI_DEFAULT_RTL = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "E2F3639E9F2BEC4CCE554F5DA6A66B39", hash_generated_field = "96707B9ED197F2C49CEF721789B1CC89")

    public static final int BIDI_FORCE_LTR = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "4477D287153948E3BCC8146F87474210", hash_generated_field = "C8D922D49FF076A4FA47E7AC1C90E71C")

    public static final int BIDI_FORCE_RTL = 0x5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "AD043D77A3F007CF0D78F67B7A122465", hash_generated_field = "80689923EFFED0DEFB8EBF590BABE137")

    private static final int BIDI_MAX_FLAG_VALUE = BIDI_FORCE_RTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "EDE5E0F0C0A7138B12B7543291047D37", hash_generated_field = "F2C5ACAE49EA02FB996F32FA24F9DDEA")

    private static final int BIDI_FLAG_MASK = 0x7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "3156617304B6D40B79220E1E6BFC0BE0", hash_generated_field = "519D5E5540609C6F930879E787B9A0E3")

    public static final int CURSOR_AFTER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "46E4972643B74A1460244D84ED486FD5", hash_generated_field = "87F0976C0F58B633C620CB23E58C9D06")

    public static final int CURSOR_AT_OR_AFTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "4CEF794F11B5E574A3ECFEC23B55ABAD", hash_generated_field = "E937AFFEBC810173CB0EDEB05B57742B")

    public static final int CURSOR_BEFORE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "0FEA77E88DFD7349A142E7C079F0CD42", hash_generated_field = "59875B95A53D3853447FD50EB38FE659")

    public static final int CURSOR_AT_OR_BEFORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "0D7566A26ECAD2F14A1D61E8205D9E27", hash_generated_field = "944FD8D9E2B6685D6BB0D020EFBD576C")

    public static final int CURSOR_AT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.616 -0400", hash_original_field = "6CC78B0C1FCA48FD494AD1FDCE89286A", hash_generated_field = "D6F9958F9851E03048ADF3A5AFE0078A")

    private static final int CURSOR_OPT_MAX_VALUE = CURSOR_AT;
}

