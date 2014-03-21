package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;

public class BitmapDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.002 -0500", hash_original_field = "7CF99753786D75C47609AC471C80045B", hash_generated_field = "88A3BEB3155DA79AE994754DCF9B8910")

    private static final int DEFAULT_PAINT_FLAGS =
            Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.004 -0500", hash_original_field = "8530586CAAF1F7CDB68987827F5D218A", hash_generated_field = "3A76FEC83F92CDCF2EE402CB0D000CA7")

    private BitmapState mBitmapState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.007 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.009 -0500", hash_original_field = "ECD4D89DF1454FA7D8CADA9E2E6FCCE4", hash_generated_field = "13CD7AE350A8EF6D449472E24FC8398F")

    private int mTargetDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.011 -0500", hash_original_field = "0A025D603E5F1E14FDA0CBD26CE0F38F", hash_generated_field = "1E3D8C2BEBFECFBF47423C145BB19A3C")

    private final Rect mDstRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.013 -0500", hash_original_field = "8FC0E2BDB952C12BF9DFB1F1A8CC0274", hash_generated_field = "5A87E51B39C79BA29E312E77B8B43A92")

    private boolean mApplyGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.015 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.017 -0500", hash_original_field = "4C687A097BDE0B0C2EC2AE8D7A5DB502", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.019 -0500", hash_original_field = "02D7E7DAA0BBE312A2B33B0AA711DE83", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    /**
     * Create an empty drawable, not dealing with density.
     * @deprecated Use {@link #BitmapDrawable(Resources)} to ensure
     * that the drawable has correctly set its target density.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.022 -0500", hash_original_method = "B0AF2A53C18BC0AEA00F89D5110E52E7", hash_generated_method = "10025C3CB8BCA7B5E32EB632DAC36488")
    
@Deprecated
    public BitmapDrawable() {
        mBitmapState = new BitmapState((Bitmap) null);
    }

    /**
     * Create an empty drawable, setting initial target density based on
     * the display metrics of the resources.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.024 -0500", hash_original_method = "ECC74DE3478988E64B883DFDAEC329B4", hash_generated_method = "6CCAA0CEB8A5375232BFAD5CE0634B39")
    
@SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res) {
        mBitmapState = new BitmapState((Bitmap) null);
        mBitmapState.mTargetDensity = mTargetDensity;
    }

    /**
     * Create drawable from a bitmap, not dealing with density.
     * @deprecated Use {@link #BitmapDrawable(Resources, Bitmap)} to ensure
     * that the drawable has correctly set its target density.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.027 -0500", hash_original_method = "EDF3772DB206CC7034C0B4AE87D72F1A", hash_generated_method = "2A24C773588AAE50B0BEBB88EBB18FAE")
    
@Deprecated
    public BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), null);
    }

    /**
     * Create drawable from a bitmap, setting initial target density based on
     * the display metrics of the resources.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.030 -0500", hash_original_method = "0FA3F000A20BF5722D4983CAD4B48A6A", hash_generated_method = "0098083302FD036F72DFABFE27F96262")
    
public BitmapDrawable(Resources res, Bitmap bitmap) {
        this(new BitmapState(bitmap), res);
        mBitmapState.mTargetDensity = mTargetDensity;
    }

    /**
     * Create a drawable by opening a given file path and decoding the bitmap.
     * @deprecated Use {@link #BitmapDrawable(Resources, String)} to ensure
     * that the drawable has correctly set its target density.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.032 -0500", hash_original_method = "88A1392443C2003D9FA4C6DECF6A14A3", hash_generated_method = "AEAAE41ED94955B07B93D5B2B222D042")
    
@Deprecated
    public BitmapDrawable(String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        if (mBitmap == null) {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        }
    }

    /**
     * Create a drawable by opening a given file path and decoding the bitmap.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.035 -0500", hash_original_method = "2E50FC990DF5F99ED2B436DB68D65D30", hash_generated_method = "00378E813D9AAE96C89E687C495CF7FE")
    
@SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res, String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        mBitmapState.mTargetDensity = mTargetDensity;
        if (mBitmap == null) {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        }
    }

    /**
     * Create a drawable by decoding a bitmap from the given input stream.
     * @deprecated Use {@link #BitmapDrawable(Resources, java.io.InputStream)} to ensure
     * that the drawable has correctly set its target density.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.039 -0500", hash_original_method = "5474E95C495E2BDEA7848B2F1051B5AB", hash_generated_method = "1FFFECB7616C84868E8040908FCDEBA5")
    
@Deprecated
    public BitmapDrawable(java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        if (mBitmap == null) {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        }
    }

    /**
     * Create a drawable by decoding a bitmap from the given input stream.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.041 -0500", hash_original_method = "A95CEE47ED6D08FEFE672AAA66725922", hash_generated_method = "0AB6F4FFFBE41D5DDFA26AA1238B2C05")
    
@SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res, java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        mBitmapState.mTargetDensity = mTargetDensity;
        if (mBitmap == null) {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.142 -0500", hash_original_method = "FB19047A342C9589C667FFAF2B0ECEA1", hash_generated_method = "E33C44F0BAD1866256B0752EAE971E19")
    
private BitmapDrawable(BitmapState state, Resources res) {
        mBitmapState = state;
        if (res != null) {
            mTargetDensity = res.getDisplayMetrics().densityDpi;
        } else {
            mTargetDensity = state.mTargetDensity;
        }
        setBitmap(state != null ? state.mBitmap : null);
    }

    /**
     * Returns the paint used to render this drawable.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.043 -0500", hash_original_method = "29B9C66D2E3FF8CE986D27E62D842E86", hash_generated_method = "C3B46D1777DCA21FDF6977CF73B91FC6")
    
public final Paint getPaint() {
        return mBitmapState.mPaint;
    }

    /**
     * Returns the bitmap used by this drawable to render. May be null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.045 -0500", hash_original_method = "CDEEA354B6732B0C95C918F7ECA77F64", hash_generated_method = "6FC2F538D34A5C21D9536C0D23FAE615")
    
public final Bitmap getBitmap() {
        return mBitmap;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.048 -0500", hash_original_method = "BD13D47BACD5F22B3F18803E2B331415", hash_generated_method = "3EE1AD4C713355ED2A10F7F32D2B84A3")
    
private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.050 -0500", hash_original_method = "5A8B316E5E7A06983942607FAB994128", hash_generated_method = "93C3D4C899F4E5B8DE6E6FEE36513FAA")
    
private void setBitmap(Bitmap bitmap) {
        if (bitmap != mBitmap) {
            mBitmap = bitmap;
            if (bitmap != null) {
                computeBitmapSize();
            } else {
                mBitmapWidth = mBitmapHeight = -1;
            }
            invalidateSelf();
        }
    }

    /**
     * Set the density scale at which this drawable will be rendered. This
     * method assumes the drawable will be rendered at the same density as the
     * specified canvas.
     *
     * @param canvas The Canvas from which the density scale must be obtained.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.052 -0500", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "61CFDB38788DB3DF61DD296AC5E20393")
    
public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    /**
     * Set the density scale at which this drawable will be rendered.
     *
     * @param metrics The DisplayMetrics indicating the density scale for this drawable.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.054 -0500", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "5DB2A771EE175C3701864DA1F5B543BF")
    
public void setTargetDensity(DisplayMetrics metrics) {
        setTargetDensity(metrics.densityDpi);
    }

    /**
     * Set the density at which this drawable will be rendered.
     *
     * @param density The density scale for this drawable.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.057 -0500", hash_original_method = "A17595DAE1AE36756FF8FF6EEBB23DC0", hash_generated_method = "39C6DDF052D0D618F5CB6A280CEFADC9")
    
public void setTargetDensity(int density) {
        if (mTargetDensity != density) {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            if (mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    /** Get the gravity used to position/stretch the bitmap within its bounds.
     * See android.view.Gravity
     * @return the gravity applied to the bitmap
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.059 -0500", hash_original_method = "35E95FC787F9F24A49C5DE1ED0297F4C", hash_generated_method = "32A95249308553D39F2B55B97EB69838")
    
public int getGravity() {
        return mBitmapState.mGravity;
    }
    
    /** Set the gravity used to position/stretch the bitmap within its bounds.
        See android.view.Gravity
     * @param gravity the gravity
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.061 -0500", hash_original_method = "4FFB5FF85BF6BE29F34E4951AEB6D83F", hash_generated_method = "A272C91539BBD9EF9B0425AF81AE32F0")
    
public void setGravity(int gravity) {
        if (mBitmapState.mGravity != gravity) {
            mBitmapState.mGravity = gravity;
            mApplyGravity = true;
            invalidateSelf();
        }
    }

    /**
     * Enables or disables anti-aliasing for this drawable. Anti-aliasing affects
     * the edges of the bitmap only so it applies only when the drawable is rotated.
     * 
     * @param aa True if the bitmap should be anti-aliased, false otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.063 -0500", hash_original_method = "A6A7F02FCC6854A1D6F789226FBA84D5", hash_generated_method = "1CC278EEB209DDD7554CBF036FFF47D3")
    
public void setAntiAlias(boolean aa) {
        mBitmapState.mPaint.setAntiAlias(aa);
        invalidateSelf();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.066 -0500", hash_original_method = "79F41E9E1F5486CC4586236A9EB22FE0", hash_generated_method = "323E6A41A493DA85844E9CE29CA92993")
    
@Override
    public void setFilterBitmap(boolean filter) {
        mBitmapState.mPaint.setFilterBitmap(filter);
        invalidateSelf();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.068 -0500", hash_original_method = "FC203784F21362ACF19CD453633052FE", hash_generated_method = "806D4B5BA618F1FCAB8C981B9E7424E0")
    
@Override
    public void setDither(boolean dither) {
        mBitmapState.mPaint.setDither(dither);
        invalidateSelf();
    }

    /**
     * Indicates the repeat behavior of this drawable on the X axis.
     * 
     * @return {@link Shader.TileMode#CLAMP} if the bitmap does not repeat,
     *         {@link Shader.TileMode#REPEAT} or {@link Shader.TileMode#MIRROR} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.070 -0500", hash_original_method = "8C03C626370DF89EB681D1D91A4CB25A", hash_generated_method = "74A29D0EC9A98DFB9B0FA0CB03D34F12")
    
public Shader.TileMode getTileModeX() {
        return mBitmapState.mTileModeX;
    }

    /**
     * Indicates the repeat behavior of this drawable on the Y axis.
     * 
     * @return {@link Shader.TileMode#CLAMP} if the bitmap does not repeat,
     *         {@link Shader.TileMode#REPEAT} or {@link Shader.TileMode#MIRROR} otherwise.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.072 -0500", hash_original_method = "C4F6E36EB6EDDD2C280548D4CD537229", hash_generated_method = "2E942088EDC19DCAECDB8410D6D3DEAE")
    
public Shader.TileMode getTileModeY() {
        return mBitmapState.mTileModeY;
    }

    /**
     * Sets the repeat behavior of this drawable on the X axis. By default, the drawable
     * does not repeat its bitmap. Using {@link Shader.TileMode#REPEAT} or
     * {@link Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled) if the bitmap
     * is smaller than this drawable.
     * 
     * @param mode The repeat mode for this drawable.
     * 
     * @see #setTileModeY(android.graphics.Shader.TileMode) 
     * @see #setTileModeXY(android.graphics.Shader.TileMode, android.graphics.Shader.TileMode) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.074 -0500", hash_original_method = "856CFED7038AD7D83A692D422DD3B90C", hash_generated_method = "4463E50B87B9EF10A176C4D91CFDC903")
    
public void setTileModeX(Shader.TileMode mode) {
        setTileModeXY(mode, mBitmapState.mTileModeY);
    }

    /**
     * Sets the repeat behavior of this drawable on the Y axis. By default, the drawable
     * does not repeat its bitmap. Using {@link Shader.TileMode#REPEAT} or
     * {@link Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled) if the bitmap
     * is smaller than this drawable.
     * 
     * @param mode The repeat mode for this drawable.
     * 
     * @see #setTileModeX(android.graphics.Shader.TileMode) 
     * @see #setTileModeXY(android.graphics.Shader.TileMode, android.graphics.Shader.TileMode) 
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.076 -0500", hash_original_method = "445DE87A20C6F0A91872714D31B4C1C9", hash_generated_method = "1D33D6C86AA8FEB3E5DD294076CA83B3")
    
public final void setTileModeY(Shader.TileMode mode) {
        setTileModeXY(mBitmapState.mTileModeX, mode);
    }

    /**
     * Sets the repeat behavior of this drawable on both axis. By default, the drawable
     * does not repeat its bitmap. Using {@link Shader.TileMode#REPEAT} or
     * {@link Shader.TileMode#MIRROR} the bitmap can be repeated (or tiled) if the bitmap
     * is smaller than this drawable.
     * 
     * @param xmode The X repeat mode for this drawable.
     * @param ymode The Y repeat mode for this drawable.
     * 
     * @see #setTileModeX(android.graphics.Shader.TileMode)
     * @see #setTileModeY(android.graphics.Shader.TileMode) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.079 -0500", hash_original_method = "ADEC19A1E439C619635E588D2B7F4415", hash_generated_method = "9524D68B0F6765A70E0BB59CC27EEB31")
    
public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        final BitmapState state = mBitmapState;
        if (state.mTileModeX != xmode || state.mTileModeY != ymode) {
            state.mTileModeX = xmode;
            state.mTileModeY = ymode;
            state.mRebuildShader = true;
            invalidateSelf();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.082 -0500", hash_original_method = "10D38B42FB036E8B57E4A209AB7F4ADC", hash_generated_method = "B88743EDE3AAAF7E3863625464132403")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.085 -0500", hash_original_method = "43A5F38374D847F9AEDDDDB09459070C", hash_generated_method = "8D9D2E5D441049C4B88ED4BD494A1914")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mApplyGravity = true;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.088 -0500", hash_original_method = "6FA1B7BCBB056D9C6C12415C137DE76D", hash_generated_method = "A90B5DA1A11446CA3441C2EC01CB8A87")
    
@Override
    public void draw(Canvas canvas) {
        Bitmap bitmap = mBitmap;
        if (bitmap != null) {
            final BitmapState state = mBitmapState;
            if (state.mRebuildShader) {
                Shader.TileMode tmx = state.mTileModeX;
                Shader.TileMode tmy = state.mTileModeY;

                if (tmx == null && tmy == null) {
                    state.mPaint.setShader(null);
                } else {
                    state.mPaint.setShader(new BitmapShader(bitmap,
                            tmx == null ? Shader.TileMode.CLAMP : tmx,
                            tmy == null ? Shader.TileMode.CLAMP : tmy));
                }
                state.mRebuildShader = false;
                copyBounds(mDstRect);
            }

            Shader shader = state.mPaint.getShader();
            if (shader == null) {
                if (mApplyGravity) {
                    final int layoutDirection = getResolvedLayoutDirectionSelf();
                    Gravity.apply(state.mGravity, mBitmapWidth, mBitmapHeight,
                            getBounds(), mDstRect, layoutDirection);
                    mApplyGravity = false;
                }
                canvas.drawBitmap(bitmap, null, mDstRect, state.mPaint);
            } else {
                if (mApplyGravity) {
                    copyBounds(mDstRect);
                    mApplyGravity = false;
                }
                canvas.drawRect(mDstRect, state.mPaint);
            }
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.090 -0500", hash_original_method = "49CE66D09454E056E2AD494EF2DD30A3", hash_generated_method = "83D57727976F7DCF22DCE37B73CF654A")
    
@Override
    public void setAlpha(int alpha) {
        int oldAlpha = mBitmapState.mPaint.getAlpha();
        if (alpha != oldAlpha) {
            mBitmapState.mPaint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.092 -0500", hash_original_method = "F79C881D02962F781494A97AA0D9D98A", hash_generated_method = "F25AF7EAB97D9AB76CF1F5AD34B99A1A")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        mBitmapState.mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    /**
     * A mutable BitmapDrawable still shares its Bitmap with any other Drawable
     * that comes from the same resource.
     *
     * @return This drawable.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.095 -0500", hash_original_method = "12F43AAD192527EE14BD9EA92E6F05B8", hash_generated_method = "929C3DCA2A88B94727C182DEFD173D7E")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mBitmapState = new BitmapState(mBitmapState);
            mMutated = true;
        }
        return this;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.098 -0500", hash_original_method = "C7B53A4BB10177C8F005B36E9252EFF2", hash_generated_method = "D68C7B8DB767C41E9B6BCF5141502A36")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.BitmapDrawable);

        final int id = a.getResourceId(com.android.internal.R.styleable.BitmapDrawable_src, 0);
        if (id == 0) {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        }
        final Bitmap bitmap = BitmapFactory.decodeResource(r, id);
        if (bitmap == null) {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        }
        mBitmapState.mBitmap = bitmap;
        setBitmap(bitmap);
        setTargetDensity(r.getDisplayMetrics());

        final Paint paint = mBitmapState.mPaint;
        paint.setAntiAlias(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_antialias,
                paint.isAntiAlias()));
        paint.setFilterBitmap(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_filter,
                paint.isFilterBitmap()));
        paint.setDither(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_dither,
                paint.isDither()));
        setGravity(a.getInt(com.android.internal.R.styleable.BitmapDrawable_gravity, Gravity.FILL));
        int tileMode = a.getInt(com.android.internal.R.styleable.BitmapDrawable_tileMode, -1);
        if (tileMode != -1) {
            switch (tileMode) {
                case 0:
                    setTileModeXY(Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                    break;
                case 1:
                    setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    break;
                case 2:
                    setTileModeXY(Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
                    break;
            }
        }

        a.recycle();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.100 -0500", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "21AB0A052F6EA6AC14C0E8AE68C8FF19")
    
@Override
    public int getIntrinsicWidth() {
        return mBitmapWidth;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.102 -0500", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "4C6E95AD1C54FB0FB2042DE89349F724")
    
@Override
    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.105 -0500", hash_original_method = "9571905A182C10BB0B86009E34DE8EF4", hash_generated_method = "B97E52E400811FB0B91121E4F2CCB5CC")
    
@Override
    public int getOpacity() {
        if (mBitmapState.mGravity != Gravity.FILL) {
            return PixelFormat.TRANSLUCENT;
        }
        Bitmap bm = mBitmap;
        /*
        return (bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255) ?
                PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
        */

        return (bm.getTaintInt() + mBitmapState.mPaint.getAlpha());
    }
    
    final static class BitmapState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.110 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "46C0A7FFF0FFB93D952536F8E8BA5C29")

        Bitmap mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.112 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.114 -0500", hash_original_field = "02974118B7DB2EBC67C99A80C329EC2D", hash_generated_field = "02974118B7DB2EBC67C99A80C329EC2D")

        int mGravity = Gravity.FILL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.116 -0500", hash_original_field = "F847D1003F51642BF2CF19539CE8548D", hash_generated_field = "F847D1003F51642BF2CF19539CE8548D")

        Paint mPaint = new Paint(DEFAULT_PAINT_FLAGS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.119 -0500", hash_original_field = "6E9BEEFA8B8AEF79DD5E5F09806F1C57", hash_generated_field = "6E9BEEFA8B8AEF79DD5E5F09806F1C57")

        Shader.TileMode mTileModeX = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.121 -0500", hash_original_field = "4B2749A46C2F0D56B391EF4A168B3C38", hash_generated_field = "4B2749A46C2F0D56B391EF4A168B3C38")

        Shader.TileMode mTileModeY = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.123 -0500", hash_original_field = "80AC771C22191FC983474A6CF039F227", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.125 -0500", hash_original_field = "6C534FAF0245C3B32617A5CE28BF5D41", hash_generated_field = "6C534FAF0245C3B32617A5CE28BF5D41")

        boolean mRebuildShader;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.128 -0500", hash_original_method = "80003A9E2431B1DF8C6F7DBC005B3BC9", hash_generated_method = "80003A9E2431B1DF8C6F7DBC005B3BC9")
        
BitmapState(Bitmap bitmap) {
            mBitmap = bitmap;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.131 -0500", hash_original_method = "C0031760E3673EAB51AB6808BBA62477", hash_generated_method = "C0031760E3673EAB51AB6808BBA62477")
        
BitmapState(BitmapState bitmapState) {
            this(bitmapState.mBitmap);
            mChangingConfigurations = bitmapState.mChangingConfigurations;
            mGravity = bitmapState.mGravity;
            mTileModeX = bitmapState.mTileModeX;
            mTileModeY = bitmapState.mTileModeY;
            mTargetDensity = bitmapState.mTargetDensity;
            mPaint = new Paint(bitmapState.mPaint);
            mRebuildShader = bitmapState.mRebuildShader;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.133 -0500", hash_original_method = "7A0D3C52124D4E31E0F3E052BCC0F262", hash_generated_method = "6ACC4AD0AFA34A69D8C6E65EB8A2215B")
        
@Override
        public Drawable newDrawable() {
            return new BitmapDrawable(this, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.135 -0500", hash_original_method = "E262501023FDB9346524FFA189B84EDB", hash_generated_method = "67D91EFCA3497E562D10A6F7F27A39E7")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new BitmapDrawable(this, res);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.138 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:15.107 -0500", hash_original_method = "B22D07CBAAEE149FB3D11CBEDB83599B", hash_generated_method = "A2AEE23A8D12D22E83417B98A2AC6B3C")
    
@Override
    public final ConstantState getConstantState() {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return mBitmapState;
    }
}

