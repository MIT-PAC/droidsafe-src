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
    public int         mBidiFlags = BIDI_DEFAULT_LTR;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.396 -0400", hash_original_method = "07976DE00CD3F977E8ACA514AAEDE967", hash_generated_method = "2E92EC59FFA72681E3F4ECFD5F5383AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint() {
        this(0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.396 -0400", hash_original_method = "DD18D0561860908DF0D4B7BC76B2B3D2", hash_generated_method = "F4BE4407DE9800E485C38BE3650E79D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.397 -0400", hash_original_method = "5333FFC8A800A9BDD5C93C0D81F44606", hash_generated_method = "6B38F140C0D1B15F41C520BF490F704C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
        // ---------- Original Method ----------
        //mNativePaint = native_initWithPaint(paint.mNativePaint);
        //setClassVariablesFrom(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.397 -0400", hash_original_method = "500B44D79F50634A486701EEF1530400", hash_generated_method = "4EC68B4DCAA133DD09A2D2EB6717EEB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.398 -0400", hash_original_method = "98AAB6FDA11AA2B9ABF20CA846521C6A", hash_generated_method = "70CE316ED33E8D010998A4614AE5213D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.398 -0400", hash_original_method = "98AB66F312E073116B808F98CBEF958E", hash_generated_method = "71360DE2C22B6D0ACDE7CAC4A28FAAD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.398 -0400", hash_original_method = "163478F4D44D5ADDAB10921FE1B9406D", hash_generated_method = "D2E564E6BE7E88F95D003629D8788121")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.399 -0400", hash_original_method = "35E33B2836010FD893C5DC650465B2C6", hash_generated_method = "63E05DBEBB87025367B0AE01B37A0B5F")
    @DSModeled(DSC.SAFE)
    public int getBidiFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBidiFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.399 -0400", hash_original_method = "47898531701F33FAC5767BA6A377013D", hash_generated_method = "FD813F13C04C50171770CCF0243E759E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBidiFlags(int flags) {
        dsTaint.addTaint(flags);
        flags &= BIDI_FLAG_MASK;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown bidi flag: " + flags);
        } //End block
        // ---------- Original Method ----------
        //flags &= BIDI_FLAG_MASK;
        //if (flags > BIDI_MAX_FLAG_VALUE) {
            //throw new IllegalArgumentException("unknown bidi flag: " + flags);
        //}
        //mBidiFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.399 -0400", hash_original_method = "1AEF3AE96B7B0567703FA6E8804026B1", hash_generated_method = "D02EE480D0B6CB899205AD1AAC475296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFlags() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.400 -0400", hash_original_method = "7E0C8B4D00EF46DF7C96B7FEFE972867", hash_generated_method = "DADE0787EFE6F973F1EA5532B2B4082E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFlags(int flags) {
        dsTaint.addTaint(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.400 -0400", hash_original_method = "7451F33B471F8FECF642BA91F121AF70", hash_generated_method = "D82A35101E323538D7690CE63CF978A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHinting() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.400 -0400", hash_original_method = "07C5EEBB2536BECA8E267FAA9B72B9E6", hash_generated_method = "CFEB0DF4B5FBA40B6C1F244389FC79EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHinting(int mode) {
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.400 -0400", hash_original_method = "5965A0E7316AAA95881AE3D055547B57", hash_generated_method = "09925B9C6EB77993F4A4356481C9300D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isAntiAlias() {
        boolean var0A7E8DB3C2F27E0E70AEB7D3C4714849_2045348272 = ((getFlags() & ANTI_ALIAS_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & ANTI_ALIAS_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.401 -0400", hash_original_method = "8B9E1DF7E3F10B045A1C3ED5825D806F", hash_generated_method = "6B07D9F13CEC1E0683E09394D10FEE5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAntiAlias(boolean aa) {
        dsTaint.addTaint(aa);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.401 -0400", hash_original_method = "365AF52E63589F5A5C820D079E688641", hash_generated_method = "DE100363F192556430F5210AE6DCFE07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isDither() {
        boolean var5399F5810C06B5F2B5007E7BFE0F0E00_1868215782 = ((getFlags() & DITHER_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & DITHER_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.401 -0400", hash_original_method = "A1D5308EB6CBA9AF3933567292CFE65A", hash_generated_method = "3CA0D8D4FAFCA623FA9705611751024C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.401 -0400", hash_original_method = "9B687614DCB13072E0D397A968085B41", hash_generated_method = "E50ED0BE25F20435A6F4D682938BE011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isLinearText() {
        boolean var79DAF9C030CBADD6B91BC7DC15DBE862_708563300 = ((getFlags() & LINEAR_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & LINEAR_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.402 -0400", hash_original_method = "1D0DE5FFC588536775BF0537B97C257E", hash_generated_method = "80CC2E71158101E961169B5A919C567B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLinearText(boolean linearText) {
        dsTaint.addTaint(linearText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.402 -0400", hash_original_method = "8BAC5D567D23AEF728D22298071CB50B", hash_generated_method = "E2663D549DB339824F6A978CB0F4A25F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isSubpixelText() {
        boolean varA843E4D86CA73BCC98350551BD14C6C0_1996020347 = ((getFlags() & SUBPIXEL_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & SUBPIXEL_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.402 -0400", hash_original_method = "1B1E55650C7A249BE6F48A7FCCDE2B0E", hash_generated_method = "170EF15E7E2A4653F9241716A911D0C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubpixelText(boolean subpixelText) {
        dsTaint.addTaint(subpixelText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.403 -0400", hash_original_method = "540058EB824CF1779470649F70CA731D", hash_generated_method = "7B14BFC203A7B7E696CE2666E51ECEC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isUnderlineText() {
        boolean varE927F016983A6B322D1DB9E7B9D956EF_1026471100 = ((getFlags() & UNDERLINE_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & UNDERLINE_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.403 -0400", hash_original_method = "08639A75D204C407A568CB7739C3FAB4", hash_generated_method = "F1018466915260903738701C7B1E768E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUnderlineText(boolean underlineText) {
        dsTaint.addTaint(underlineText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.403 -0400", hash_original_method = "4D8DFD32FB0492CC10F2A4C48D6AABE0", hash_generated_method = "55595BDF57E4FC9F35403059CBFB1C3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isStrikeThruText() {
        boolean var7E7F54E434CA51F1CAA8093A60301247_1994134329 = ((getFlags() & STRIKE_THRU_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & STRIKE_THRU_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.404 -0400", hash_original_method = "EE8879CC84B0101E64CC036D7E2B8F8D", hash_generated_method = "673827EC440A8D98E235DEF2904676EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrikeThruText(boolean strikeThruText) {
        dsTaint.addTaint(strikeThruText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.404 -0400", hash_original_method = "64C8195C0C6E03DDD3FCE77D9F18F499", hash_generated_method = "6B9477DA5C08DD54A9A13E2451DBCC4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFakeBoldText() {
        boolean varBA3E1460985702B77EDFEB4E358B3B6A_1930721537 = ((getFlags() & FAKE_BOLD_TEXT_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & FAKE_BOLD_TEXT_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.405 -0400", hash_original_method = "6E7D99B95546D6ABB7274A6609FD0359", hash_generated_method = "5464CC10E0FCA2A5182A15B3946CD345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFakeBoldText(boolean fakeBoldText) {
        dsTaint.addTaint(fakeBoldText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.406 -0400", hash_original_method = "69EBEFD820D698F0EA00B7F4C8854ABB", hash_generated_method = "79625F84C8FCF61295F66D3ADF3CFB4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isFilterBitmap() {
        boolean var8F4FACEC12D1030ECB4A927B5426F3CC_970200651 = ((getFlags() & FILTER_BITMAP_FLAG) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFlags() & FILTER_BITMAP_FLAG) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.406 -0400", hash_original_method = "B8C11CD7111D9BC247774CFB44C7A8B0", hash_generated_method = "E4A77D77B1AE32093C518814F6A3B5AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.407 -0400", hash_original_method = "7A3F88F43B6717422F7911C6C93794E0", hash_generated_method = "61B49342FFBB661F196951E9F19A7C2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Style getStyle() {
        Style varDF1F6B230123C5DD940B6F0B3006D996_1927653057 = (sStyleArray[native_getStyle(mNativePaint)]);
        return (Style)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sStyleArray[native_getStyle(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.407 -0400", hash_original_method = "0C31442FDD5A78FAD136F991DDCEA542", hash_generated_method = "ECADFD745B9A05DD027FC9A759167580")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStyle(Style style) {
        dsTaint.addTaint(style.dsTaint);
        native_setStyle(mNativePaint, style.nativeInt);
        // ---------- Original Method ----------
        //native_setStyle(mNativePaint, style.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.407 -0400", hash_original_method = "A6843949A5740747763B245A4340955B", hash_generated_method = "CB006443E0408A8DAE46868BAE309715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColor() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.407 -0400", hash_original_method = "6B0B967C1DC4D48EE66A1A874887BE3F", hash_generated_method = "A1063ECEDE837E6FDBFCB626494E16C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColor(int color) {
        dsTaint.addTaint(color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.408 -0400", hash_original_method = "D39ECC24DCC5EA2AD7BF99F063294ED7", hash_generated_method = "E463C98B121864AFCFFD0DDC02FE4627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAlpha() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.408 -0400", hash_original_method = "2717A1058DFCA3888C2EAD1CA5D16AFD", hash_generated_method = "5409C9D6918DDAFC4619A62AA44A4C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(int a) {
        dsTaint.addTaint(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.408 -0400", hash_original_method = "61ED3E8FA79427F4AF66F905BEAE9870", hash_generated_method = "444ECB263861348C649109AAC1B7A499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setARGB(int a, int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(a);
        setColor((a << 24) | (r << 16) | (g << 8) | b);
        // ---------- Original Method ----------
        //setColor((a << 24) | (r << 16) | (g << 8) | b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.408 -0400", hash_original_method = "6176D634A3133A706881E45A3F2EC84E", hash_generated_method = "3889A3C03640B94D5CF95BD4DBFFD82E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getStrokeWidth() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.409 -0400", hash_original_method = "75F355CF371141B3EA541D9CF06B77D7", hash_generated_method = "543123A7613AEBEA342D76C44BF0D946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeWidth(float width) {
        dsTaint.addTaint(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.409 -0400", hash_original_method = "4CDA12126AC6E812A74D0B2AB0DB6A34", hash_generated_method = "ECD136219C383E00DEE6A2FDE6EFBC48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getStrokeMiter() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.409 -0400", hash_original_method = "252E24C8C0C1E389692C4003A305EEC7", hash_generated_method = "B1EF95C916552290378087C60BA07059")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeMiter(float miter) {
        dsTaint.addTaint(miter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.409 -0400", hash_original_method = "5DCDC8444F177D5C991625E0155BCA4A", hash_generated_method = "5EC8C3BC515F6D552C4CCB57D5A8F29E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cap getStrokeCap() {
        Cap var27B18866C82BBDEE7D0090F673D1B1E0_443795823 = (sCapArray[native_getStrokeCap(mNativePaint)]);
        return (Cap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.409 -0400", hash_original_method = "D26EF05E574A5A1AE605A2030639B3B0", hash_generated_method = "46A184B449FAEE9C7BF14E790B9A99D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeCap(Cap cap) {
        dsTaint.addTaint(cap.dsTaint);
        native_setStrokeCap(mNativePaint, cap.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.410 -0400", hash_original_method = "EC697BED5392A0A7D9DB024F5A9BA066", hash_generated_method = "E4F32C1B89536F6604605F297736BF16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Join getStrokeJoin() {
        Join var37B4E906946CBD22BC4578AFE8693B00_177898176 = (sJoinArray[native_getStrokeJoin(mNativePaint)]);
        return (Join)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.410 -0400", hash_original_method = "08533C600DCDC9F9AEA810B7ADA01DF0", hash_generated_method = "569FF1F3CAF41A69456F4649B10D1D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrokeJoin(Join join) {
        dsTaint.addTaint(join.dsTaint);
        native_setStrokeJoin(mNativePaint, join.nativeInt);
        // ---------- Original Method ----------
        //native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.410 -0400", hash_original_method = "47F5CE3F8A2C9B64184DA3E7564A16E0", hash_generated_method = "CD014E1C80C993933F344619FFD2ABE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFillPath(Path src, Path dst) {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        boolean varD76A52FF867281710D540951850A2520_2014022294 = (native_getFillPath(mNativePaint, src.ni(), dst.ni()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_getFillPath(mNativePaint, src.ni(), dst.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.411 -0400", hash_original_method = "F14F830C87873216E173BB3B6F2D71DE", hash_generated_method = "BEAB54DDD8D08E56C4118CE569EF317F")
    @DSModeled(DSC.SAFE)
    public Shader getShader() {
        return (Shader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.411 -0400", hash_original_method = "CB91A884CE132802683E082171CC1D6C", hash_generated_method = "E62C87F05423EDF7521BC92786702E25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.411 -0400", hash_original_method = "0F313F2FF8A981B6076CED0DBA25A8DB", hash_generated_method = "B3D4CB5CE78D886EDF373E2BCA2F9F8F")
    @DSModeled(DSC.SAFE)
    public ColorFilter getColorFilter() {
        return (ColorFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mColorFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.412 -0400", hash_original_method = "C7126951024C02787596F4A62EFB1A3F", hash_generated_method = "1847FD2C03664563C4CECCCEE32B4EC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.412 -0400", hash_original_method = "DC5D89A34795E2A5122BF3B6DBF85AE6", hash_generated_method = "679A16D6871E742271DD10CDAD489B40")
    @DSModeled(DSC.SAFE)
    public Xfermode getXfermode() {
        return (Xfermode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mXfermode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.412 -0400", hash_original_method = "42770A58843BCA14944D0826F7595F4B", hash_generated_method = "4FFDD4B2402F8E04209CBA7D80A4DB38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.413 -0400", hash_original_method = "D81D17C09FBA25719A586CCEA3F0BEFE", hash_generated_method = "B9477708F87C1E70CA2B49FCD61815E8")
    @DSModeled(DSC.SAFE)
    public PathEffect getPathEffect() {
        return (PathEffect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPathEffect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.413 -0400", hash_original_method = "1FFAC2BED25128ED5407987A8834154C", hash_generated_method = "6AF036E9E4F319D8CD77C94F09D4968F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.413 -0400", hash_original_method = "E1DE139FF20646B82CF42CE75E145566", hash_generated_method = "D7570E323AF3C4E37F4B7B5EC043F5C8")
    @DSModeled(DSC.SAFE)
    public MaskFilter getMaskFilter() {
        return (MaskFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMaskFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.413 -0400", hash_original_method = "12313867224D56BCBF8C1F85C229A2F0", hash_generated_method = "3E409C46EAA3F8DDF81DF9D080966682")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.414 -0400", hash_original_method = "E402FEB0FEC812E5128501C647697EA3", hash_generated_method = "158393E6653CC13C532D03120FA13720")
    @DSModeled(DSC.SAFE)
    public Typeface getTypeface() {
        return (Typeface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTypeface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.414 -0400", hash_original_method = "73CCDBF9DAC8A72983E784437C89D8D5", hash_generated_method = "4F11699BA20D7EB7DE06AD52D672E84E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.414 -0400", hash_original_method = "7F563E2B82AAC612FD94925F2ADE0503", hash_generated_method = "DD21AF272316AA5126FB0933308CB98A")
    @DSModeled(DSC.SAFE)
    public Rasterizer getRasterizer() {
        return (Rasterizer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRasterizer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.415 -0400", hash_original_method = "C8A0400F51437E6D358556D513DD7EE5", hash_generated_method = "A2B83863F92F81A38B64007D32A29598")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.415 -0400", hash_original_method = "30B7CF0D1828E00D1755D0EC1ABBE2FD", hash_generated_method = "C8ADB2D1665A9E9007BA0AD29D959CC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(color);
        dsTaint.addTaint(dy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.415 -0400", hash_original_method = "9A021015EB9699060DA93C776C6886F7", hash_generated_method = "B905EAB9F233D0751E044596BEC3562A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nSetShadowLayer(float radius, float dx, float dy, int color) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(color);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(radius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.416 -0400", hash_original_method = "DB007ED9A7C8404ED556121239348407", hash_generated_method = "69C41E78339835181B7060E466C37E39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0, 0, 0, 0);
        // ---------- Original Method ----------
        //hasShadow = false;
        //nSetShadowLayer(0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.416 -0400", hash_original_method = "5BB4256D6E91E955B4D3F4F49AADCB0E", hash_generated_method = "4E764BDBB3F4C08B01132764780FB9E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Align getTextAlign() {
        Align var025BD55D74E667490D93BDF0B89FEFC6_1492961055 = (sAlignArray[native_getTextAlign(mNativePaint)]);
        return (Align)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.416 -0400", hash_original_method = "9031C48C5C8C88E95D6A94DEBF9597C6", hash_generated_method = "48100BE93CDA10321BD5E9CAF9B48A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextAlign(Align align) {
        dsTaint.addTaint(align.dsTaint);
        native_setTextAlign(mNativePaint, align.nativeInt);
        // ---------- Original Method ----------
        //native_setTextAlign(mNativePaint, align.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.416 -0400", hash_original_method = "2A8BEEB1775704D2B3E07881AE922147", hash_generated_method = "831298C513610A67EA23811B3DB899A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextSize() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.417 -0400", hash_original_method = "D08AF5901B1A9C873DECCE4D2981E18B", hash_generated_method = "B628A6A36711269DD6BBE2042C7FDEE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextSize(float textSize) {
        dsTaint.addTaint(textSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.417 -0400", hash_original_method = "EEC42792D0F71421A678CE903B4FA263", hash_generated_method = "35FB769A7907F6CE17CA1D1060F9F650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextScaleX() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.417 -0400", hash_original_method = "87304E629EFE8B729DA5569E791B6279", hash_generated_method = "F578B5EBF2FC0B5F6F7AA6C0284FEE30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextScaleX(float scaleX) {
        dsTaint.addTaint(scaleX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.417 -0400", hash_original_method = "07133F92A91BAB9C1735E9B633DC996D", hash_generated_method = "13F7B7C9CF726121F961AEBA265B387A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextSkewX() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.417 -0400", hash_original_method = "3930648222881DDA6B516B90E78C962C", hash_generated_method = "CE66D30BAEC6FC80B86BE4054E8A2BDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTextSkewX(float skewX) {
        dsTaint.addTaint(skewX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.418 -0400", hash_original_method = "BAAE43E1F09165366508512053D99CC4", hash_generated_method = "52E3BD79C10E91CED9FBAD201B6576FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float ascent() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.418 -0400", hash_original_method = "C74862F858F8C9C5BB339033A2D07A66", hash_generated_method = "32683BED3ECFBAF7A9287FD310D3B2A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float descent() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.418 -0400", hash_original_method = "E3F97BD47FCDD806F1495C59D5DC88F3", hash_generated_method = "634DADC5AC61A007C49B34D66318B698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFontMetrics(FontMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.419 -0400", hash_original_method = "413DCA25916B10D66C5EBCBD1F3E5F3E", hash_generated_method = "9A7F2D5B4A998A1730B9C1B6EAC83FE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.419 -0400", hash_original_method = "22AF3BB1B7346662E340EB744DF0CCEE", hash_generated_method = "CB8988333DCBCED9E05EA02B5317AAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFontMetricsInt(FontMetricsInt fmi) {
        dsTaint.addTaint(fmi.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.422 -0400", hash_original_method = "B88208EBDD064B8ABC7A4B1B4C890CB3", hash_generated_method = "B988238ACD58F1ECDA2AF242C967087B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.422 -0400", hash_original_method = "EF0ED40E419F51E9B426A955B42CA854", hash_generated_method = "F1721B3D94191432942C20D8E18416AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFontSpacing() {
        float varE2260D5039D2A3988D3A0EAEA55ED628_2142717214 = (getFontMetrics(null));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getFontMetrics(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.423 -0400", hash_original_method = "4B30EE6B8828803214F6472A454BF7F0", hash_generated_method = "CDFF104DA5BF6FFB298E787B8CD9B1EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(char[] text, int index, int count) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            float var204A124D7256F67576DEC177530E8CA9_1255129324 = (native_measureText(text, index, count));
        } //End block
        float oldSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.423 -0400", hash_original_method = "1D29C18CB0DD7430F92F434F064552F2", hash_generated_method = "B50F9B1B60E3A482B03EDE64F0AFB2ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(char[] text, int index, int count) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.424 -0400", hash_original_method = "A455FCC07C61C67A7FE9747C69B01A43", hash_generated_method = "D0A0839BE9E935756D7A5730418125D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(String text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1847885269 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_1499095134 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6C5BF54DC4892C8073B52E95C3AE2BA1_1098653475 = (native_measureText(text, start, end));
        } //End block
        float oldSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.424 -0400", hash_original_method = "DFCEFEA707A99B30CBEB967F0B6D9176", hash_generated_method = "BD8357F8787D509E591366BB8A179DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(String text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.424 -0400", hash_original_method = "C4C224EF0059A9B14092F4800A14BAD4", hash_generated_method = "650768AE7996661B02A34A791120B525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(String text) {
        dsTaint.addTaint(text);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_681729080 = (text.length() == 0);
        } //End collapsed parenthetic
        float varDE0E49D527135C371027DDD371BB7F5C_1896848552 = (native_measureText(text));
        float oldSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.424 -0400", hash_original_method = "91386AC41942864A83F6131CB196DED9", hash_generated_method = "83DD9EB05B02F4CC02F58CEF38927A26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float native_measureText(String text) {
        dsTaint.addTaint(text);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.425 -0400", hash_original_method = "6EB2D4EE24026300FF5D315D09C81847", hash_generated_method = "A853B54611B6CC4D1503F62178C2FF9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float measureText(CharSequence text, int start, int end) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_48755194 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_2000405491 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float var6236CF621C1135D29EAF7BA8ECD372DF_2067846525 = (measureText((String)text, start, end));
        } //End block
        {
            float var315F7BA142189E74DF7F2C7E5074479F_1922973603 = (measureText(text.toString(), start, end));
        } //End block
        {
            float varC657CDB825AED28F6EC29BE81E302484_1447210254 = (((GraphicsOperations)text).measureText(start, end, this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.425 -0400", hash_original_method = "D72C3AADC526484DACB4DD861B9B7C6F", hash_generated_method = "4A90DC2FBC726CF60102C9B09BB6D2B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(char[] text, int index, int count,
                                float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(maxWidth);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var0D5AAC51BA58AAF43D4E2413FC1B1BFC_1543700887 = (index < 0 || text.length - index < Math.abs(count));
            {
                if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            int var588A3E34EF8CC7F08FC2E9135A7530BE_137030528 = (native_breakText(text, index, count, maxWidth, measuredWidth));
        } //End block
        float oldSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.426 -0400", hash_original_method = "3F5AF75ABD8DDB127E29E64DFBDBC4A3", hash_generated_method = "887979196BDE30C18B99A54AF5EF51EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_breakText(char[] text, int index, int count,
                                        float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(maxWidth);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.426 -0400", hash_original_method = "35BD856EF91F37D3D6F6474A08F13759", hash_generated_method = "2D66063FB8BC08FE179FC24E27C1104E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(CharSequence text, int start, int end,
                         boolean measureForwards,
                         float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth[0]);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_119000657 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_266334479 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            boolean varB0BEAB0ED949D4AEA45AA76B829F1BBC_1485963051 = (start == 0 && text instanceof String && end == text.length());
            {
                int varE185824846EF4861F502E218B9EC6147_837571778 = (breakText((String) text, measureForwards, maxWidth,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.427 -0400", hash_original_method = "C05DD240630B83BC61ED5B6F9EF8E181", hash_generated_method = "7337DC803906571F6A6725F70B478E6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int breakText(String text, boolean measureForwards,
                                float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth[0]);
        dsTaint.addTaint(text);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_345230970 = (text.length() == 0);
        } //End collapsed parenthetic
        {
            int var69E64876CE9B422F0E0C81D70A86C49D_947701516 = (native_breakText(text, measureForwards, maxWidth, measuredWidth));
        } //End block
        float oldSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.427 -0400", hash_original_method = "26339CA739A6FAF1A2C001CF8203F02F", hash_generated_method = "50C36862ECE4556F63F341087F3D32F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_breakText(String text, boolean measureForwards,
                                        float maxWidth, float[] measuredWidth) {
        dsTaint.addTaint(measuredWidth[0]);
        dsTaint.addTaint(text);
        dsTaint.addTaint(maxWidth);
        dsTaint.addTaint(measureForwards);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.428 -0400", hash_original_method = "83C574DC73479463FE44C1F2988A5F29", hash_generated_method = "610E3B976ADD60FECC66192D550CB47F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(char[] text, int index, int count,
                             float[] widths) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(widths[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            int var0DDD48BB4F1D26244DA9DA23FABF3401_1196948738 = (native_getTextWidths(mNativePaint, text, index, count, widths));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.429 -0400", hash_original_method = "F14F0812F33DADA5D35A1216285E517E", hash_generated_method = "1651BAA54B79579686203FD3D3C1BFC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(CharSequence text, int start, int end,
                             float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(widths[0]);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_747667811 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_525280169 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int var5D20898AFE082D7DD346F7FD8F9F995D_368833258 = (getTextWidths((String) text, start, end, widths));
        } //End block
        {
            int var75159B67CD95E075E263ED8014FEA7F7_241624298 = (getTextWidths(text.toString(), start, end, widths));
        } //End block
        {
            int var3A56B5BB09115C0B32F02D407185C205_1029055367 = (((GraphicsOperations) text).getTextWidths(start, end,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.430 -0400", hash_original_method = "FC7E920984BEE100F69A523319264731", hash_generated_method = "9E46CC7F9AAC536060DC9AE097FD0CB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(String text, int start, int end, float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(widths[0]);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean var9527A5CDD965760192A60A252272F336_1150763752 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_476651625 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            int varBEC4070C2642CF1E33A5E49FB207AF35_270687478 = (native_getTextWidths(mNativePaint, text, start, end, widths));
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.430 -0400", hash_original_method = "2A3DC3984F2D039C4252250086EEE48E", hash_generated_method = "D91A9D3809D7763A2A15232CDCB324E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextWidths(String text, float[] widths) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(widths[0]);
        int var69BF8B4981D05965CD3D190575A4DA2F_1694089662 = (getTextWidths(text, 0, text.length(), widths));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getTextWidths(text, 0, text.length(), widths);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.431 -0400", hash_original_method = "FA2DB9E943D72A496CC6A996B7086F15", hash_generated_method = "4F0FC076D4E3A01C6C6F3361972525D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextGlyphs(String text, int start, int end, int contextStart, int contextEnd,
            int flags, char[] glyphs) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(glyphs[0]);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(contextEnd);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean var48E9A0E727B5C13031610714A0F3121E_776888013 = ((start | end | contextStart | contextEnd | (end - start)
                | (start - contextStart) | (contextEnd - end) | (text.length() - end)
                | (text.length() - contextEnd)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        int var5604385AD0B712150B1A0044CF957B36_1563534950 = (native_getTextGlyphs(mNativePaint, text, start, end, contextStart, contextEnd,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.431 -0400", hash_original_method = "CEF06EAF1F3995907C189C9C72603DEF", hash_generated_method = "D063854E17F3D3FD289DCC6618C4CCF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex) {
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(index);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(count);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(chars[0]);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(advancesIndex);
        float var13BD798480C8819B88B041244F6BBD82_1701172201 = (getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(chars, index, count, contextIndex, contextCount, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.432 -0400", hash_original_method = "5F3C708402843653E3430F9E58C46380", hash_generated_method = "2B02822A1D0E31DB632C03927B05B558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(char[] chars, int index, int count,
            int contextIndex, int contextCount, int flags, float[] advances,
            int advancesIndex, int reserved) {
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(index);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(count);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(chars[0]);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(advancesIndex);
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
            float var9858EF271DB73A9C5CCA76565BD23E23_1290362486 = (native_getTextRunAdvances(mNativePaint, chars, index, count,
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.432 -0400", hash_original_method = "2F009E21E693FAD74101A2B25EBDF10B", hash_generated_method = "499D45D28EBF5E96FDBE5323CD4F7A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesIndex);
        dsTaint.addTaint(contextEnd);
        float varE8CBEF545459E19AB4A39859AE3D961A_1212690502 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.433 -0400", hash_original_method = "4EFF4F6D396021295344678FBB8A998E", hash_generated_method = "4583A48F3E86DDFC121BFA659E4B6245")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(CharSequence text, int start, int end,
            int contextStart, int contextEnd, int flags, float[] advances,
            int advancesIndex, int reserved) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesIndex);
        dsTaint.addTaint(contextEnd);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_727789473 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            float var53C63DC714A80E28C550C886BD1BF771_1983902597 = (getTextRunAdvances((String) text, start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var8A3BE239E9FF57407B2B40D6353ADC2C_778933891 = (getTextRunAdvances(text.toString(), start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, reserved));
        } //End block
        {
            float var5ED11FC83FC39AEF2A8CAFC241CA9694_1097612383 = (((GraphicsOperations) text).getTextRunAdvances(start, end,
                    contextStart, contextEnd, flags, advances, advancesIndex, this));
        } //End block
        {
            boolean var8A801BB93DFE1C696CAF475D2408E876_198211624 = (text.length() == 0 || end == start);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.434 -0400", hash_original_method = "1581EA555CC5336BCB2DDF38747B9672", hash_generated_method = "F599E29DF0BE842D19F68EF2BFD50AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesIndex);
        dsTaint.addTaint(contextEnd);
        float varE8CBEF545459E19AB4A39859AE3D961A_441330525 = (getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                advances, advancesIndex, 0 ));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getTextRunAdvances(text, start, end, contextStart, contextEnd, flags,
                //advances, advancesIndex, 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.435 -0400", hash_original_method = "1C46AF2D403F5DA84F25080DCEA69AA0", hash_generated_method = "175D92571BC093D3DEF4EE69EE28A4ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTextRunAdvances(String text, int start, int end, int contextStart,
            int contextEnd, int flags, float[] advances, int advancesIndex, int reserved) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(advances[0]);
        dsTaint.addTaint(reserved);
        dsTaint.addTaint(end);
        dsTaint.addTaint(advancesIndex);
        dsTaint.addTaint(contextEnd);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("text cannot be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown flags value: " + flags);
        } //End block
        {
            boolean varCD925A198552EF304E37BFC3C54909BB_645355128 = ((start | end | contextStart | contextEnd | advancesIndex | (end - start)
                | (start - contextStart) | (contextEnd - end)
                | (text.length() - contextEnd)
                | (advances == null ? 0 :
                    (advances.length - advancesIndex - (end - start)))) < 0); //DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB847AF29AA4DC1416413087DD4BD672_843662979 = (text.length() == 0 || start == end);
        } //End collapsed parenthetic
        {
            float varA17437B07A992747272D690A911F4BE8_1597481358 = (native_getTextRunAdvances(mNativePaint, text, start, end,
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
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.437 -0400", hash_original_method = "EB6D9B15E4067DFED9B2A74E5C744A1F", hash_generated_method = "13E2BBF6BB4679790B379AA3C5E9594C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTextRunCursor(char[] text, int contextStart, int contextLength,
            int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(contextLength);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        int contextEnd;
        contextEnd = contextStart + contextLength;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int varE8EBF73E11AF76C72E64792B60A20D56_1972518872 = (native_getTextRunCursor(mNativePaint, text,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.438 -0400", hash_original_method = "34AAA4A164F43F1E201745A1F65B4411", hash_generated_method = "BB9E8F904EF937A07F885D12D7CD20EE")
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
            int var619EE7AC5F2B236B269D3FB8DEBD1DE5_1392709944 = (getTextRunCursor(text.toString(), contextStart, contextEnd,
                    flags, offset, cursorOpt));
        } //End block
        {
            int var5359D01CAC7EB633AB92A9435A4EFA33_1177075716 = (((GraphicsOperations) text).getTextRunCursor(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.438 -0400", hash_original_method = "D546CDC2181E95744AE417A48EFCB65E", hash_generated_method = "1D1E2DCE7BB633440B8BCDD166E05E52")
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
            boolean varA368D1291D010AA3542B6D856DA1F09E_787021792 = (((contextStart | contextEnd | offset | (contextEnd - contextStart)
                | (offset - contextStart) | (contextEnd - offset)
                | (text.length() - contextEnd) | cursorOpt) < 0)
                || cursorOpt > CURSOR_OPT_MAX_VALUE);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int var5B91A9628724F23D69FCD31F54247A76_1418661695 = (native_getTextRunCursor(mNativePaint, text,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.439 -0400", hash_original_method = "0E7040D8937128B20B9E7E7425C5D78D", hash_generated_method = "7FC7787FC54817C1ACEFE146F4D0D97E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextPath(char[] text, int index, int count,
                            float x, float y, Path path) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.439 -0400", hash_original_method = "F99FE41661C2E1CF4ABA5DAE3EEF7955", hash_generated_method = "3F99C53BBA48E0472343CD2C755BB7D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextPath(String text, int start, int end,
                            float x, float y, Path path) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        {
            boolean var9527A5CDD965760192A60A252272F336_983544884 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.439 -0400", hash_original_method = "FD83EA4D46005AE0FEF3AC534F19299F", hash_generated_method = "11B0CE5D82453602063585404A1A38BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextBounds(String text, int start, int end, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var9527A5CDD965760192A60A252272F336_1117279204 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need bounds Rect");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.440 -0400", hash_original_method = "989A6FF8CB429D5D016E1FAEDFB33A1F", hash_generated_method = "2B41F611BD7F4348040AB178965FFC7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextBounds(char[] text, int index, int count, Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("need bounds Rect");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.440 -0400", hash_original_method = "925DF10B1DD177E135B07F96DE8E7F32", hash_generated_method = "DF419449CAA1B777D791C6F5EE64D2ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.445 -0400", hash_original_method = "2766BE855FF2D72BD9BAD5CAFB40ABE8", hash_generated_method = "CEE81960761AD751378494203C019985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_getTextRunCursor(int native_object, char[] text,
            int contextStart, int contextLength, int flags, int offset, int cursorOpt) {
        dsTaint.addTaint(contextLength);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(cursorOpt);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(native_object);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.445 -0400", hash_original_method = "EDBEC3DC0C784965FEB390C91BCB35F5", hash_generated_method = "0B4D3EC4EE517909CC3623AF324E3310")
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
        return dsTaint.getTaintInt();
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
        public float   top;
        public float   ascent;
        public float   descent;
        public float   bottom;
        public float   leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.446 -0400", hash_original_method = "F24D6A8B1491C4AE9269542AFD432378", hash_generated_method = "F24D6A8B1491C4AE9269542AFD432378")
                public FontMetrics ()
        {
        }


    }


    
    public static class FontMetricsInt {
        public int   top;
        public int   ascent;
        public int   descent;
        public int   bottom;
        public int   leading;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.446 -0400", hash_original_method = "B6268FD4C33775E70B297806A015C3E9", hash_generated_method = "B6268FD4C33775E70B297806A015C3E9")
                public FontMetricsInt ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.447 -0400", hash_original_method = "97A4B08E6C02C426AA89747CCB47B314", hash_generated_method = "CFA3EB54E335524C3685CD2118E2547F")
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
}

