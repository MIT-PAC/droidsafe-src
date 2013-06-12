package android.graphics;

// Droidsafe Imports
import android.text.GraphicsOperations;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class Paint {
    public int mNativePaint;
    private ColorFilter mColorFilter;
    private MaskFilter  mMaskFilter;
    private PathEffect  mPathEffect;
    private Rasterizer  mRasterizer;
    private Shader      mShader;
    private Typeface    mTypeface;
    private Xfermode    mXfermode;
    private boolean     mHasCompatScaling;
    private float       mCompatScaling;
    private float       mInvCompatScaling;
    public boolean hasShadow;
    public float shadowDx;
    public float shadowDy;
    public float shadowRadius;
    public int shadowColor;
    public  int         mBidiFlags = BIDI_DEFAULT_LTR;
    static final Style[] sStyleArray = {
        Style.FILL, Style.STROKE, Style.FILL_AND_STROKE
    };
    static final Cap[] sCapArray = {
        Cap.BUTT, Cap.ROUND, Cap.SQUARE
    };
    static final Join[] sJoinArray = {
        Join.MITER, Join.ROUND, Join.BEVEL
    };
    static final Align[] sAlignArray = {
        Align.LEFT, Align.CENTER, Align.RIGHT
    };
    public static final int ANTI_ALIAS_FLAG     = 0x01;
    public static final int FILTER_BITMAP_FLAG  = 0x02;
    public static final int DITHER_FLAG         = 0x04;
    public static final int UNDERLINE_TEXT_FLAG = 0x08;
    public static final int STRIKE_THRU_TEXT_FLAG = 0x10;
    public static final int FAKE_BOLD_TEXT_FLAG = 0x20;
    public static final int LINEAR_TEXT_FLAG    = 0x40;
    public static final int SUBPIXEL_TEXT_FLAG  = 0x80;
    public static final int DEV_KERN_TEXT_FLAG  = 0x100;
    static final int DEFAULT_PAINT_FLAGS = DEV_KERN_TEXT_FLAG;
    public static final int HINTING_OFF = 0x0;
    public static final int HINTING_ON = 0x1;
    public static final int BIDI_LTR = 0x0;
    public static final int BIDI_RTL = 0x1;
    public static final int BIDI_DEFAULT_LTR = 0x2;
    public static final int BIDI_DEFAULT_RTL = 0x3;
    public static final int BIDI_FORCE_LTR = 0x4;
    public static final int BIDI_FORCE_RTL = 0x5;
    private static final int BIDI_MAX_FLAG_VALUE = BIDI_FORCE_RTL;
    private static final int BIDI_FLAG_MASK = 0x7;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    public static final int CURSOR_AFTER = 0;
    public static final int CURSOR_AT_OR_AFTER = 1;
    public static final int CURSOR_BEFORE = 2;
    public static final int CURSOR_AT_OR_BEFORE = 3;
    public static final int CURSOR_AT = 4;
    private static final int CURSOR_OPT_MAX_VALUE = CURSOR_AT;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.256 -0400", hash_original_method = "07976DE00CD3F977E8ACA514AAEDE967", hash_generated_method = "8146D7F2BA06D2F5C81FDCDE23511D20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint() {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.256 -0400", hash_original_method = "DD18D0561860908DF0D4B7BC76B2B3D2", hash_generated_method = "A7A3286A607B34C0F413CA76FF132799")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint(int flags) {
        dsTaint.addTaint(flags);
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        // ---------- Original Method ----------
        //mNativePaint = native_init();
        //setFlags(flags | DEFAULT_PAINT_FLAGS);
        //mCompatScaling = mInvCompatScaling = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.256 -0400", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "945FC92F6A8D47E71461F5B5E8F33D5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
        // ---------- Original Method ----------
        //mNativePaint = native_initWithPaint(paint.mNativePaint);
        //setClassVariablesFrom(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.256 -0400", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "E0589D680C5965A5425AAF840FB5C1E7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "A243FCF41B9DA1201CA05627755E6AAF")
    @DSModeled(DSC.SAFE)
    public void set(Paint src) {
        dsTaint.addTaint(src.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "8E5882F5EC163184BDCD3503CE601F80")
    @DSModeled(DSC.SAFE)
    private void setClassVariablesFrom(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "CC9569F1253AC524A4852EA98E764860")
    @DSModeled(DSC.SAFE)
    public void setCompatibilityScaling(float factor) {
        dsTaint.addTaint(factor);
        {
            mHasCompatScaling = false;
            mCompatScaling = mInvCompatScaling = 1.0f;
        } //End block
        {
            mHasCompatScaling = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "FC7EFC6DBBBD9D86539B9B62C36F6797")
    @DSModeled(DSC.SAFE)
    public int getBidiFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBidiFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "34C5399E3B16AE36067297AC82F1D186")
    @DSModeled(DSC.SAFE)
    public void setBidiFlags(int flags) {
        dsTaint.addTaint(flags);
        flags &= BIDI_FLAG_MASK;
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("unknown bidi flag: " + flags);
        } //End block
        // ---------- Original Method ----------
        //flags &= BIDI_FLAG_MASK;
        //if (flags > BIDI_MAX_FLAG_VALUE) {
            //throw new IllegalArgumentException("unknown bidi flag: " + flags);
        //}
        //mBidiFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "1AEF3AE96B7B0567703FA6E8804026B1", hash_generated_method = "A7DF5EF096080F23085F1D9D12A330F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFlags() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "7E0C8B4D00EF46DF7C96B7FEFE972867", hash_generated_method = "3791203F99520BB5F5D54ACEA102BACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFlags(int flags) {
        dsTaint.addTaint(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "270130DB88A2999BD955FFC0120B88F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHinting() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.257 -0400", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "04B25D6D564447BA1EE427E4737DB24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHinting(int mode) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "BBECF8A54E4669B675A1FB48AFC97E37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAntiAlias() {
        boolean var0A7E8DB3C2F27E0E70AEB7D3C4714849_1800267935 = ((getFlags() & ANTI_ALIAS_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "8B9E1DF7E3F10B045A1C3ED5825D806F", hash_generated_method = "C17EB68BBE742AD60FEA3B69AC041459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAntiAlias(boolean aa) {
        dsTaint.addTaint(aa);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "17163DDBDFD58437E3BEA295AB1B4784")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isDither() {
        boolean var5399F5810C06B5F2B5007E7BFE0F0E00_1641949436 = ((getFlags() & DITHER_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & DITHER_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "68C8091210261312A62151B3884DB20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "50210B6E1841D6990E82FA3730A6C4B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isLinearText() {
        boolean var79DAF9C030CBADD6B91BC7DC15DBE862_1809493782 = ((getFlags() & LINEAR_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "27DC7913193DF7119623A693038798F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLinearText(boolean linearText) {
        dsTaint.addTaint(linearText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "2BAFF7CB7A7B553660DAA6935F115239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isSubpixelText() {
        boolean varA843E4D86CA73BCC98350551BD14C6C0_1922451867 = ((getFlags() & SUBPIXEL_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "3FC9F87083F64E1EE048D7518D68B9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubpixelText(boolean subpixelText) {
        dsTaint.addTaint(subpixelText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "907CD675D1E5DB3591FDB7B167A5E1C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isUnderlineText() {
        boolean varE927F016983A6B322D1DB9E7B9D956EF_1545859298 = ((getFlags() & UNDERLINE_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.258 -0400", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "70E22748A75A0E5F867F0893C0A8619E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUnderlineText(boolean underlineText) {
        dsTaint.addTaint(underlineText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "45EAA6327F0E6C8F0B2747AA50D9D447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isStrikeThruText() {
        boolean var7E7F54E434CA51F1CAA8093A60301247_602982563 = ((getFlags() & STRIKE_THRU_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "F08E03843DFF4CD82D27C980BF8F2A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrikeThruText(boolean strikeThruText) {
        dsTaint.addTaint(strikeThruText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "A15F8F92BFD88A3DC4B108128D593C9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFakeBoldText() {
        boolean varBA3E1460985702B77EDFEB4E358B3B6A_516496194 = ((getFlags() & FAKE_BOLD_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "BF3679E28B281383A761206AC8983918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFakeBoldText(boolean fakeBoldText) {
        dsTaint.addTaint(fakeBoldText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "C07294AEEC99F01F29B1CF3511AADE20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFilterBitmap() {
        boolean var8F4FACEC12D1030ECB4A927B5426F3CC_2122575018 = ((getFlags() & FILTER_BITMAP_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "B8C11CD7111D9BC247774CFB44C7A8B0", hash_generated_method = "39E720E9634FD7FDD02F694D52523B0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "F8AF24871EBDC6FC3E2CB6E56D53C601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Style getStyle() {
        Style varDF1F6B230123C5DD940B6F0B3006D996_1402699340 = (sStyleArray[native_getStyle(mNativePaint)]);
        return (Style)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sStyleArray[native_getStyle(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "6CD775ADDA53C622C42E033B6284018E")
    @DSModeled(DSC.SAFE)
    public void setStyle(Style style) {
        dsTaint.addTaint(style.dsTaint);
        native_setStyle(mNativePaint, style.nativeInt);
        // ---------- Original Method ----------
        //native_setStyle(mNativePaint, style.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "A6843949A5740747763B245A4340955B", hash_generated_method = "3BCF8459A7D552F67BF7E8E9A5A1A0FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColor() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "6B0B967C1DC4D48EE66A1A874887BE3F", hash_generated_method = "CE8FC46D0A51D6A616B21CE0F180043B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColor(int color) {
        dsTaint.addTaint(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.259 -0400", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "B1FC3D62E17C20BEB2218622F72E8AC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAlpha() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "941D9F50217F4AD2EFEA2144B2444FA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(int a) {
        dsTaint.addTaint(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "F5ED7F5CC1F4DF94C321F8CF9CF633F3")
    @DSModeled(DSC.SAFE)
    public void setARGB(int a, int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(a);
        setColor((a << 24) | (r << 16) | (g << 8) | b);
        // ---------- Original Method ----------
        //setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "588580C0E5AADBC724F3D72712534C75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getStrokeWidth() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "513781E2C48E042A61B491F2C39E82D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeWidth(float width) {
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "CD7867D2A711986095F96429AFBAF435")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getStrokeMiter() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "5F49824461DDEE5D0E8E8F01E3B825FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeMiter(float miter) {
        dsTaint.addTaint(miter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "FD76C7280FD28F3F8DBC9C51D86C24AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cap getStrokeCap() {
        Cap var27B18866C82BBDEE7D0090F673D1B1E0_1626362432 = (sCapArray[native_getStrokeCap(mNativePaint)]);
        return (Cap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "B9A4F5FD7C79C84CBFBCD430CA3B9CA3")
    @DSModeled(DSC.SAFE)
    public void setStrokeCap(Cap cap) {
        dsTaint.addTaint(cap.dsTaint);
        native_setStrokeCap(mNativePaint, cap.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "ACB9E64899362B061F1703B8ACB10AF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Join getStrokeJoin() {
        Join var37B4E906946CBD22BC4578AFE8693B00_947326872 = (sJoinArray[native_getStrokeJoin(mNativePaint)]);
        return (Join)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.260 -0400", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "BB836171A8EAB76DC122F10355F44C9C")
    @DSModeled(DSC.SAFE)
    public void setStrokeJoin(Join join) {
        dsTaint.addTaint(join.dsTaint);
        native_setStrokeJoin(mNativePaint, join.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "26D3A1FE8C7AD294E9121607B6D09FCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFillPath(Path src, Path dst) {
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        boolean varD76A52FF867281710D540951850A2520_320351816 = (native_getFillPath(mNativePaint, src.ni(), dst.ni()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "1A6F115BF24EA415C4DDC731A4708CFE")
    @DSModeled(DSC.SAFE)
    public Shader getShader() {
        return (Shader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "299157E94C6F94BBBBE3E530CAE37FA4")
    @DSModeled(DSC.SAFE)
    public Shader setShader(Shader shader) {
        dsTaint.addTaint(shader.dsTaint);
        int shaderNative;
        shaderNative = 0;
        shaderNative = shader.native_instance;
        native_setShader(mNativePaint, shaderNative);
        return (Shader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int shaderNative = 0;
        //if (shader != null)
            //shaderNative = shader.native_instance;
        //native_setShader(mNativePaint, shaderNative);
        //mShader = shader;
        //return shader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "FB07855719A79AA282D7D58505D99AB6")
    @DSModeled(DSC.SAFE)
    public ColorFilter getColorFilter() {
        return (ColorFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mColorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "4ED0EF8FD4593D18E5DDCB2BB86CE0A2")
    @DSModeled(DSC.SAFE)
    public ColorFilter setColorFilter(ColorFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        int filterNative;
        filterNative = 0;
        filterNative = filter.native_instance;
        native_setColorFilter(mNativePaint, filterNative);
        return (ColorFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int filterNative = 0;
        //if (filter != null)
            //filterNative = filter.native_instance;
        //native_setColorFilter(mNativePaint, filterNative);
        //mColorFilter = filter;
        //return filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "B91629001FDF37634235DE5731B3E289")
    @DSModeled(DSC.SAFE)
    public Xfermode getXfermode() {
        return (Xfermode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mXfermode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "84EAA142B6DA873236182D66CBD7EF39")
    @DSModeled(DSC.SAFE)
    public Xfermode setXfermode(Xfermode xfermode) {
        dsTaint.addTaint(xfermode.dsTaint);
        int xfermodeNative;
        xfermodeNative = 0;
        xfermodeNative = xfermode.native_instance;
        native_setXfermode(mNativePaint, xfermodeNative);
        return (Xfermode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int xfermodeNative = 0;
        //if (xfermode != null)
            //xfermodeNative = xfermode.native_instance;
        //native_setXfermode(mNativePaint, xfermodeNative);
        //mXfermode = xfermode;
        //return xfermode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.261 -0400", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "FE4AA430C6E89253671B9A00CBC601FA")
    @DSModeled(DSC.SAFE)
    public PathEffect getPathEffect() {
        return (PathEffect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPathEffect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "62FA662C585D71D62E967242BF6D2AA4")
    @DSModeled(DSC.SAFE)
    public PathEffect setPathEffect(PathEffect effect) {
        dsTaint.addTaint(effect.dsTaint);
        int effectNative;
        effectNative = 0;
        {
            effectNative = effect.native_instance;
        } //End block
        native_setPathEffect(mNativePaint, effectNative);
        return (PathEffect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int effectNative = 0;
        //if (effect != null) {
            //effectNative = effect.native_instance;
        //}
        //native_setPathEffect(mNativePaint, effectNative);
        //mPathEffect = effect;
        //return effect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "FB0174D58CFBB6B2DC7E2DE57418B03D")
    @DSModeled(DSC.SAFE)
    public MaskFilter getMaskFilter() {
        return (MaskFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMaskFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "65E544B1D10B00ECCEAD99E5F1E19E80")
    @DSModeled(DSC.SAFE)
    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        dsTaint.addTaint(maskfilter.dsTaint);
        int maskfilterNative;
        maskfilterNative = 0;
        {
            maskfilterNative = maskfilter.native_instance;
        } //End block
        native_setMaskFilter(mNativePaint, maskfilterNative);
        return (MaskFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int maskfilterNative = 0;
        //if (maskfilter != null) {
            //maskfilterNative = maskfilter.native_instance;
        //}
        //native_setMaskFilter(mNativePaint, maskfilterNative);
        //mMaskFilter = maskfilter;
        //return maskfilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "69AC4DA5A135C50E34F105B0ACAE2F6D")
    @DSModeled(DSC.SAFE)
    public Typeface getTypeface() {
        return (Typeface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "657B3CD922106C49A6D63F996143C73A")
    @DSModeled(DSC.SAFE)
    public Typeface setTypeface(Typeface typeface) {
        dsTaint.addTaint(typeface.dsTaint);
        int typefaceNative;
        typefaceNative = 0;
        {
            typefaceNative = typeface.native_instance;
        } //End block
        native_setTypeface(mNativePaint, typefaceNative);
        return (Typeface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int typefaceNative = 0;
        //if (typeface != null) {
            //typefaceNative = typeface.native_instance;
        //}
        //native_setTypeface(mNativePaint, typefaceNative);
        //mTypeface = typeface;
        //return typeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "09F5403226519DA06A59B7529A946CB9")
    @DSModeled(DSC.SAFE)
    public Rasterizer getRasterizer() {
        return (Rasterizer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRasterizer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "2E208FA532426BC6EEBC842EE9E82E57")
    @DSModeled(DSC.SAFE)
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        dsTaint.addTaint(rasterizer.dsTaint);
        int rasterizerNative;
        rasterizerNative = 0;
        {
            rasterizerNative = rasterizer.native_instance;
        } //End block
        native_setRasterizer(mNativePaint, rasterizerNative);
        return (Rasterizer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int rasterizerNative = 0;
        //if (rasterizer != null) {
            //rasterizerNative = rasterizer.native_instance;
        //}
        //native_setRasterizer(mNativePaint, rasterizerNative);
        //mRasterizer = rasterizer;
        //return rasterizer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.262 -0400", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "6219E1B87B84C435D2E4A9D3BBBB0C55")
    @DSModeled(DSC.SAFE)
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(color);
        dsTaint.addTaint(radius);
        hasShadow = radius > 0.0f;
        nSetShadowLayer(radius, dx, dy, color);
        // ---------- Original Method ----------
        //hasShadow = radius > 0.0f;
        //shadowRadius = radius;
        //shadowDx = dx;
        //shadowDy = dy;
        //shadowColor = color;
        //nSetShadowLayer(radius, dx, dy, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "389BD84458262FD251EF23595B482645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nSetShadowLayer(float radius, float dx, float dy, int color) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(color);
        dsTaint.addTaint(radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "0CB0E5E49FF897C942CAE3854F3A81D6")
    @DSModeled(DSC.SAFE)
    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
        // ---------- Original Method ----------
        //hasShadow = false;
        //nSetShadowLayer(0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "48EC61584B2CF399F4EEDD7629BB8E71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Align getTextAlign() {
        Align var025BD55D74E667490D93BDF0B89FEFC6_404561291 = (sAlignArray[native_getTextAlign(mNativePaint)]);
        return (Align)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "F14829A75076D3AA8E83F96D3DE93B09")
    @DSModeled(DSC.SAFE)
    public void setTextAlign(Align align) {
        dsTaint.addTaint(align.dsTaint);
        native_setTextAlign(mNativePaint, align.nativeInt);
        // ---------- Original Method ----------
        //native_setTextAlign(mNativePaint, align.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "37F533ECE116789054750D56E6167363")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextSize() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "542E0194E3822812D3340AAA00042385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextSize(float textSize) {
        dsTaint.addTaint(textSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "5C0A37072C52C7A82880C9DB23224D17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextScaleX() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "177E005FE61E64D63354B5D03DAE20F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextScaleX(float scaleX) {
        dsTaint.addTaint(scaleX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "B7FC6A9B5C3F915E6B4CA4BB33D86CD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextSkewX() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "4D4E4246A9D5BF3E63BC3E4F4F42B7C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextSkewX(float skewX) {
        dsTaint.addTaint(skewX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "DDAB26337442693D6826198D708C2FF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float ascent() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.263 -0400", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "70B847676D209635304476F632FC5804")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float descent() {
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "6D709634EFB66B5C706D652902AFE972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFontMetrics(FontMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "8DE3D71E2E5EC28937553707976B9CFF")
    @DSModeled(DSC.SAFE)
    public FontMetrics getFontMetrics() {
        FontMetrics fm;
        fm = new FontMetrics();
        getFontMetrics(fm);
        return (FontMetrics)dsTaint.getTaint();
        // ---------- Original Method ----------
        //FontMetrics fm = new FontMetrics();
        //getFontMetrics(fm);
        //return fm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "04C0E90E827B8A091599709B89D8338B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFontMetricsInt(FontMetricsInt fmi) {
        dsTaint.addTaint(fmi.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "FC1A64F43154B5456D0D044BD1B682DB")
    @DSModeled(DSC.SAFE)
    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fm;
        fm = new FontMetricsInt();
        getFontMetricsInt(fm);
        return (FontMetricsInt)dsTaint.getTaint();
        // ---------- Original Method ----------
        //FontMetricsInt fm = new FontMetricsInt();
        //getFontMetricsInt(fm);
        //return fm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "FB46C65021E48B71CA4EEDD31FF2EA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFontSpacing() {
        float varE2260D5039D2A3988D3A0EAEA55ED628_1568687835 = (getFontMetrics(null));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getFontMetrics(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "4B30EE6B8828803214F6472A454BF7F0", hash_generated_method = "585D47C31F9CC172FCF4DC20DD465AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(char[] text, int index, int count) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            float var204A124D7256F67576DEC177530E8CA9_424629689 = (native_measureText(text, index, count));
        } //End block
        final float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text, index, count);
        setTextSize(oldSize);
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.264 -0400", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "0AE44C2DDE6D02CB7D14F19F6987C58D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(char[] text, int index, int count) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.265 -0400", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "31F3C2F7CC57414CA78A251852B62667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(String text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1631132212 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_663306449 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6C5BF54DC4892C8073B52E95C3AE2BA1_1329175083 = (native_measureText(text, start, end));
        } //End block
        final float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text, start, end);
        setTextSize(oldSize);
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.265 -0400", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "77903BFE7CDC6FC0F641B8E8D181DB94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(String text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.265 -0400", hash_original_method = "C4C224EF0059A9B14092F4800A14BAD4", hash_generated_method = "BB271EDE3A2B61129E940EDA0F065585")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(String text) {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_1227317008 = (text.length() == 0);
        } //End collapsed parenthetic
        float varDE0E49D527135C371027DDD371BB7F5C_1101371511 = (native_measureText(text));
        final float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w;
        w = native_measureText(text);
        setTextSize(oldSize);
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.265 -0400", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "5D6E3215A25CEC628D42BE207D4CBD70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(String text) {
        dsTaint.addTaint(text);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.265 -0400", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "B701031453E2483D6B6FA6C5CA0AF1FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(CharSequence text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_482614801 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_442743460 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6236CF621C1135D29EAF7BA8ECD372DF_808457273 = (measureText((String)text, start, end));
        } //End block
        {
            float var315F7BA142189E74DF7F2C7E5074479F_1245830572 = (measureText(text.toString(), start, end));
        } //End block
        {
            float varC657CDB825AED28F6EC29BE81E302484_958441755 = (((GraphicsOperations)text).measureText(start, end, this));
        } //End block
        char[] buf;
        buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        float result;
        result = measureText(buf, 0, end - start);
        TemporaryBuffer.recycle(buf);
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.266 -0400", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "CBC7D8BF5C9C2828F67C2160EF7799C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(maxWidth);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var0D5AAC51BA58AAF43D4E2413FC1B1BFC_1564525074 = (index < 0 || text.length - index < Math.abs(count));
            if (DroidSafeAndroidRuntime.control)
            {
                throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            int var588A3E34EF8CC7F08FC2E9135A7530BE_1592390484 = (native_breakText(text, index, count, maxWidth, measuredWidth));
        } //End block
        final float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_breakText(text, index, count, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        measuredWidth[0] *= mInvCompatScaling;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.266 -0400", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "2D991C258FFA159045AC0216DE499495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_breakText(char[] text, int index, int count,
                                        float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(maxWidth);
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.266 -0400", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "0D45F0D88937712AD48DAC5675A1013C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(CharSequence text, int start, int end,
                         boolean measureForwards,
                         float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_2030037247 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1631626308 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            boolean varB0BEAB0ED949D4AEA45AA76B829F1BBC_595046829 = (start == 0 && text instanceof String && end == text.length());
            {
                int varE185824846EF4861F502E218B9EC6147_1162680651 = (breakText((String) text, measureForwards, maxWidth,
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.266 -0400", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "3952DFC655FFFD67EA0DF1EBB63B5B3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(text);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_496387914 = (text.length() == 0);
        } //End collapsed parenthetic
        {
            int var69E64876CE9B422F0E0C81D70A86C49D_811754898 = (native_breakText(text, measureForwards, maxWidth, measuredWidth));
        } //End block
        final float oldSize;
        oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        int res;
        res = native_breakText(text, measureForwards, maxWidth*mCompatScaling,
                measuredWidth);
        setTextSize(oldSize);
        measuredWidth[0] *= mInvCompatScaling;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.267 -0400", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "18929DCB6BA1FD279FCD366F571677A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_breakText(String text, boolean measureForwards,
                                        float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(text);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.267 -0400", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "8D31A58824943E3C8C394163DDCB233A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(widths);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            int var0DDD48BB4F1D26244DA9DA23FABF3401_1319515342 = (native_getTextWidths(mNativePaint, text, index, count, widths));
        } //End block
        final float oldSize;
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.267 -0400", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "AC6072450090E29BF1996C39CC1EF4D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(widths);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1534543056 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_2084753809 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int var5D20898AFE082D7DD346F7FD8F9F995D_436432139 = (getTextWidths((String) text, start, end, widths));
        } //End block
        {
            int var75159B67CD95E075E263ED8014FEA7F7_1200731930 = (getTextWidths(text.toString(), start, end, widths));
        } //End block
        {
            int var3A56B5BB09115C0B32F02D407185C205_1879356478 = (((GraphicsOperations) text).getTextWidths(start, end,
                                                                 widths, this));
        } //End block
        char[] buf;
        buf = TemporaryBuffer.obtain(end - start);
        TextUtils.getChars(text, start, end, buf, 0);
        int result;
        result = getTextWidths(buf, 0, end - start, widths);
        TemporaryBuffer.recycle(buf);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.268 -0400", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "136F22F84EE52DC49827C2C742C76F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(String text, int start, int end, float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(widths);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_775844247 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_850447732 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int varBEC4070C2642CF1E33A5E49FB207AF35_1236677437 = (native_getTextWidths(mNativePaint, text, start, end, widths));
        } //End block
        final float oldSize;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.268 -0400", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "DB2565C9AE1FB7FEA5CA9986DA44AD02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(String text, float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(widths);
        int var69BF8B4981D05965CD3D190575A4DA2F_464252351 = (getTextWidths(text, 0, text.length(), widths));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getTextWidths(text, 0, text.length(), widths);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.268 -0400", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "C3F8F29279E864C209D92E9017ED8763")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextGlyphs(String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(glyphs);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean var48E9A0E727B5C13031610714A0F3121E_835513284 = ((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        int var5604385AD0B712150B1A0044CF957B36_137760653 = (native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
                flags, glyphs));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.268 -0400", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "6113C6BCED392D7A1A9479B9D74B76F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(count);
        dsTaint.addTaint(chars);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(advancesIndex);
        float var13BD798480C8819B88B041244F6BBD82_2028876594 = (getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.269 -0400", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "0DCF00E2D7FE821607E713E7EEF37A72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex, int reserved) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(count);
        dsTaint.addTaint(chars);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(advancesIndex);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            float var9858EF271DB73A9C5CCA76565BD23E23_53133587 = (native_getTextRunAdvances(mNativePaint, chars, index, count,
                    contextIndex, contextCount, flags, advances, advancesIndex, reserved));
        } //End block
        final float oldSize;
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.269 -0400", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "893E9909A87AA5C1D2BCD0816BA04614")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(advancesIndex);
        float varE8CBEF545459E19AB4A39859AE3D961A_1664031331 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.269 -0400", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "3107C931154F852C7FD6766E34AA0ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex, int reserved) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(advancesIndex);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_1419835073 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            float var53C63DC714A80E28C550C886BD1BF771_1365512384 = (getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var8A3BE239E9FF57407B2B40D6353ADC2C_780552166 = (getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var5ED11FC83FC39AEF2A8CAFC241CA9694_685093610 = (((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this));
        } //End block
        {
            boolean var8A801BB93DFE1C696CAF475D2408E876_745735265 = (text.length() == 0 || end == start);
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.270 -0400", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "1CCD0A444F0BD0B05FEE554CE578386D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(advancesIndex);
        float varE8CBEF545459E19AB4A39859AE3D961A_272120391 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.270 -0400", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "08D5615AD1CB3B1316DD6ECF6BDC231A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex, int reserved) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(advances);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(advancesIndex);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("text cannot be null");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_1537270618 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1252724229 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float varA17437B07A992747272D690A911F4BE8_1892768823 = (native_getTextRunAdvances(mNativePaint, text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        final float oldSize;
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.270 -0400", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "6C4216004596E6FFA3674C14BE31DCFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextRunCursor(char[] text, int contextStart, int contextLength,
            int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(contextLength);
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        int contextEnd;
        contextEnd = contextStart + contextLength;
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IndexOutOfBoundsException();
        } //End block
        int varE8EBF73E11AF76C72E64792B60A20D56_1203797948 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextLength, flags, offset, cursorOpt));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.271 -0400", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "95941E78352B9BC20616F33989839D57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextRunCursor(CharSequence text, int contextStart,
           int contextEnd, int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(contextEnd);
        {
            int var619EE7AC5F2B236B269D3FB8DEBD1DE5_725911083 = (getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt));
        } //End block
        {
            int var5359D01CAC7EB633AB92A9435A4EFA33_736988896 = (((GraphicsOperations) text).getTextRunCursor(
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.271 -0400", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "3B83DF05A4D307191C21D5946B77CB6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextRunCursor(String text, int contextStart, int contextEnd,
            int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(contextEnd);
        {
            boolean varA368D1291D010AA3542B6D856DA1F09E_1024549697 = (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length() - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int var5B91A9628724F23D69FCD31F54247A76_1308666865 = (native_getTextRunCursor(mNativePaint, text,
                contextStart, contextEnd, flags, offset, cursorOpt));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.271 -0400", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "A3A18147BFD97698FF1F8759839565A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextPath(char[] text, int index, int count,
                            float x, float y, Path path) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "6EE5CD73833005F7FBD1943D55B5416C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextPath(String text, int start, int end,
                            float x, float y, Path path) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var9527A5CDD965760192A60A252272F336_318139093 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                path.ni());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_getTextPath(mNativePaint, mBidiFlags, text, start, end, x, y, 
                //path.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "5ABBCD3FC39C0F40486BC1DA0BED1170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var9527A5CDD965760192A60A252272F336_126267757 = ((start | end | (end - start) | (text.length() - end)) < 0);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException("need bounds Rect");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "57D6107B9DDB682FC7AF31E9CCBAC726")
    @DSModeled(DSC.SAFE)
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException("need bounds Rect");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "925DF10B1DD177E135B07F96DE8E7F32", hash_generated_method = "AE84DC2AAACE7A048A129530F931C03A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "3C46655FB8D2300CD2F57789F5C15FA7", hash_generated_method = "4EF9FFF90F62383C346E53F3F4D0F223")
    private static int native_init() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "5C99CEA59365BB26B06AD1E8D37F4231", hash_generated_method = "E3B5F31D516787CB321051F484530646")
    private static int native_initWithPaint(int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "548CCA10F3D2A7665E05666D064EBB52", hash_generated_method = "7EDB534CCC42C323E3EFF1F89E411801")
    private static void native_reset(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "03FE39B4725C25687863AC255E842897", hash_generated_method = "BF523FC9DD9199FCC7A3E8789C7273B1")
    private static void native_set(int native_dst, int native_src) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.272 -0400", hash_original_method = "4B642C8B4EA1686128CAB2195F7EEE41", hash_generated_method = "AEAE8FD0EE30CF8AA4BEAB8974CB2AC9")
    private static int native_getStyle(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "E81C5C6733C9D0BBD78C86A091FBCC3C", hash_generated_method = "E705A1FB9F62666F09ACC3C13D7FFE2A")
    private static void native_setStyle(int native_object, int style) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "87FA9CF22263BBF5C1229E599E9F18DF", hash_generated_method = "91C8D779545F8F26E94E385B69A55063")
    private static int native_getStrokeCap(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "91A75051C20DCC14B98232CB35EC8902", hash_generated_method = "4C1C08A04DE59274A9D90FD650CFB846")
    private static void native_setStrokeCap(int native_object, int cap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "0A26FE357DE8D02F952F86733B6A1408", hash_generated_method = "B69B914AD9DBED632B9004B53C662CE7")
    private static int native_getStrokeJoin(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "7A99A56A761B7D352A3389246089E8F8", hash_generated_method = "32B71B6482D455651490E0569893EA22")
    private static void native_setStrokeJoin(int native_object,
                                                    int join) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "EDFBB5A424FC9D8BF5026FAB94D4CB02", hash_generated_method = "28E4F2DACED90A62A7C1CBFFB89BE0F4")
    private static boolean native_getFillPath(int native_object,
                                                     int src, int dst) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "5AB206EF4D12989EE2D0899B3577C719", hash_generated_method = "AD951EE9EB92B070B836DCFFDA7BA71E")
    private static int native_setShader(int native_object, int shader) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "A0D44D8A08DCE3B90BE7398C89799713", hash_generated_method = "4F4F599EEAD669833E28BA85C0479871")
    private static int native_setColorFilter(int native_object,
                                                    int filter) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "AED5E952854136F11BC9C80F9B54108C", hash_generated_method = "7BD111CAEA38440A2463F014E14BE76A")
    private static int native_setXfermode(int native_object,
                                                 int xfermode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "D8A4107D1C1424ACAA2A3575AF119FBC", hash_generated_method = "06FA4DBE22B4DB83A5838C6EFE402D69")
    private static int native_setPathEffect(int native_object,
                                                   int effect) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "D6E83ED0EB3D390FD11E73FA48EA780E", hash_generated_method = "BA6FEC81490D86F0D1EE345B9548FEBC")
    private static int native_setMaskFilter(int native_object,
                                                   int maskfilter) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "00E708671C7EE9990745424711A50988", hash_generated_method = "FEEB8A4CD0376F63A011E773271C0B70")
    private static int native_setTypeface(int native_object,
                                                 int typeface) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "BF7EAA91244464700B65D6B0693651E9", hash_generated_method = "4AE383463D17C836906C2F555E2F0D05")
    private static int native_setRasterizer(int native_object,
                                                   int rasterizer) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.273 -0400", hash_original_method = "CF7004ABBE1352B36509BA99127B9C4B", hash_generated_method = "D0AFCB65116FBABC54149CC02D6B2561")
    private static int native_getTextAlign(int native_object) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "F3A6C4275FF6B8111357A5009A975959", hash_generated_method = "E00E48EF0EAFE3E086D261451AC7EFBF")
    private static void native_setTextAlign(int native_object,
                                                   int align) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "D8CDB6087FA1ADD8B077630A7AA071B9", hash_generated_method = "B3CA1E0FA595AD08A18B57F1C943D826")
    private static float native_getFontMetrics(int native_paint,
                                                      FontMetrics metrics) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "5798B9B1D7013229FF354939FCE53EE7", hash_generated_method = "8663C14281C0DF83B256B709EC6C9999")
    private static int native_getTextWidths(int native_object,
                            char[] text, int index, int count, float[] widths) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "A9D4407EC40F98FA32BCDA82649531A2", hash_generated_method = "141AAC9396E741C5C6F9113974D73A6E")
    private static int native_getTextWidths(int native_object,
                            String text, int start, int end, float[] widths) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "7E0C412CDDA00DDBB22062458ABAE9D0", hash_generated_method = "C45307AC5EE59768BDF285B1F505DAB3")
    private static int native_getTextGlyphs(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "AB90135DF69AE297BABD40C76B18CB32", hash_generated_method = "568564D2CE011A24AB7691234B53F7F6")
    private static float native_getTextRunAdvances(int native_object,
            char[] text, int index, int count, int contextIndex, int contextCount,
            int flags, float[] advances, int advancesIndex, int reserved) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "AC7E7D171C2E41F2764EBAC79F96217A", hash_generated_method = "C5158CFBED503BA5F3D1570A2FA7AD41")
    private static float native_getTextRunAdvances(int native_object,
            String text, int start, int end, int contextStart, int contextEnd,
            int flags, float[] advances, int advancesIndex, int reserved) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "67BF6CE458141FF07734CF2FE7693661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_getTextRunCursor(int native_object, char[] text,
            int contextStart, int contextLength, int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(contextLength);
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(native_object);
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "2143BEFD9FDA5DA982844885A8B9BA1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_getTextRunCursor(int native_object, String text,
            int contextStart, int contextEnd, int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(native_object);
        dsTaint.addTaint(contextEnd);
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "5CD4E1AB5BC8C4A380999C810B83D369", hash_generated_method = "C0646E9F54C7DF3F980AFB36274D9B61")
    private static void native_getTextPath(int native_object, int bidiFlags,
                char[] text, int index, int count, float x, float y, int path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.274 -0400", hash_original_method = "010DC42BFFBEA9418D9D9737369294CB", hash_generated_method = "C8A33E3EC720A1DC890D9B8A896AA1EE")
    private static void native_getTextPath(int native_object, int bidiFlags,
                String text, int start, int end, float x, float y, int path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.275 -0400", hash_original_method = "31C9D65530002B3B6909EAB7B6BF4B9C", hash_generated_method = "F8DCFEB25A0F254A72D7C87F0FD46A09")
    private static void nativeGetStringBounds(int nativePaint,
                                String text, int start, int end, Rect bounds) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.275 -0400", hash_original_method = "3FB16766928962DA301585D12401FD92", hash_generated_method = "1FC59B0E514B5BD511C59D383FD983B5")
    private static void nativeGetCharArrayBounds(int nativePaint,
                                char[] text, int index, int count, Rect bounds) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.275 -0400", hash_original_method = "7EEE9C2C5C1A55E88B64BA7667E3DE23", hash_generated_method = "33ED3B98E882744C7C8F168F42795134")
    private static void finalizer(int nativePaint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
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
        public float   top;
        public float   ascent;
        public float   descent;
        public float   bottom;
        public float   leading;
        
    }


    
    public static class FontMetricsInt {
        public int   top;
        public int   ascent;
        public int   descent;
        public int   bottom;
        public int   leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.276 -0400", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "5180232A3CD5FB85B1DEA17E0C061E83")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    //" descent=" + descent + " bottom=" + bottom +
                    //" leading=" + leading;
        }

        
    }


    
}


