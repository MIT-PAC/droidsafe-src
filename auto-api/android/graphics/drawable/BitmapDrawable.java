package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class BitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS =
            Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG;
    private BitmapState mBitmapState;
    private Bitmap mBitmap;
    private int mTargetDensity;
    private final Rect mDstRect = new Rect();
    private boolean mApplyGravity;
    private boolean mMutated;
    private int mBitmapWidth;
    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.442 -0400", hash_original_method = "B0AF2A53C18BC0AEA00F89D5110E52E7", hash_generated_method = "ED12567B27CCF31218BF1EFCBE06A6A1")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public BitmapDrawable() {
        mBitmapState = new BitmapState((Bitmap) null);
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.464 -0400", hash_original_method = "ECC74DE3478988E64B883DFDAEC329B4", hash_generated_method = "1000B55DC0676332701458483EA268D7")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res) {
        dsTaint.addTaint(res.dsTaint);
        mBitmapState = new BitmapState((Bitmap) null);
        mBitmapState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.470 -0400", hash_original_method = "EDF3772DB206CC7034C0B4AE87D72F1A", hash_generated_method = "396485E4A54E4FAFFB93B626DDD0C60B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), null);
        dsTaint.addTaint(bitmap.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.499 -0400", hash_original_method = "0FA3F000A20BF5722D4983CAD4B48A6A", hash_generated_method = "DC662AA8A80B3C259F2D075E3D3B4E44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitmapDrawable(Resources res, Bitmap bitmap) {
        this(new BitmapState(bitmap), res);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(bitmap.dsTaint);
        mBitmapState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.524 -0400", hash_original_method = "88A1392443C2003D9FA4C6DECF6A14A3", hash_generated_method = "5C5DC7CDEE4F4A9A0FF6BE975EF27B3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public BitmapDrawable(String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        dsTaint.addTaint(filepath);
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } //End block
        // ---------- Original Method ----------
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.572 -0400", hash_original_method = "2E50FC990DF5F99ED2B436DB68D65D30", hash_generated_method = "288D6FE14D7C85B0FCFFF1C56D208D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res, String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(filepath);
        mBitmapState.mTargetDensity = mTargetDensity;
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } //End block
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.611 -0400", hash_original_method = "5474E95C495E2BDEA7848B2F1051B5AB", hash_generated_method = "1199D8F0A085E46EEEF31DB0EC179B80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public BitmapDrawable(java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        dsTaint.addTaint(is.dsTaint);
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } //End block
        // ---------- Original Method ----------
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.646 -0400", hash_original_method = "A95CEE47ED6D08FEFE672AAA66725922", hash_generated_method = "2E890901CF5544CA57A8713FDBB09B58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res, java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(is.dsTaint);
        mBitmapState.mTargetDensity = mTargetDensity;
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } //End block
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.700 -0400", hash_original_method = "FB19047A342C9589C667FFAF2B0ECEA1", hash_generated_method = "849ECEBC5C20E8B9C62370C9BE015F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BitmapDrawable(BitmapState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        {
            mTargetDensity = res.getDisplayMetrics().densityDpi;
        } //End block
        {
            mTargetDensity = state.mTargetDensity;
        } //End block
        setBitmap(state != null ? state.mBitmap : null);
        // ---------- Original Method ----------
        //mBitmapState = state;
        //if (res != null) {
            //mTargetDensity = res.getDisplayMetrics().densityDpi;
        //} else {
            //mTargetDensity = state.mTargetDensity;
        //}
        //setBitmap(state != null ? state.mBitmap : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.721 -0400", hash_original_method = "29B9C66D2E3FF8CE986D27E62D842E86", hash_generated_method = "2322F74DF62D1A7F46E51FB3786806CD")
    @DSModeled(DSC.SAFE)
    public final Paint getPaint() {
        return (Paint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.744 -0400", hash_original_method = "CDEEA354B6732B0C95C918F7ECA77F64", hash_generated_method = "DC19E1EEEB6087396B28970B40D76AB0")
    @DSModeled(DSC.SAFE)
    public final Bitmap getBitmap() {
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.769 -0400", hash_original_method = "BD13D47BACD5F22B3F18803E2B331415", hash_generated_method = "6F9A5BDDA9EA5B3B2BEE500F00FD5AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
        // ---------- Original Method ----------
        //mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        //mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.816 -0400", hash_original_method = "5A8B316E5E7A06983942607FAB994128", hash_generated_method = "899941A9848071465598F7F796B1FA16")
    @DSModeled(DSC.SAFE)
    private void setBitmap(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        {
            {
                computeBitmapSize();
            } //End block
            {
                mBitmapWidth = mBitmapHeight = -1;
            } //End block
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (bitmap != mBitmap) {
            //mBitmap = bitmap;
            //if (bitmap != null) {
                //computeBitmapSize();
            //} else {
                //mBitmapWidth = mBitmapHeight = -1;
            //}
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.868 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "4B9D85C7BF42F503C18FBA7BE0CACEC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        setTargetDensity(canvas.getDensity());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.932 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "4C238AFF9B32B2D971707C3E08B9742A")
    @DSModeled(DSC.SAFE)
    public void setTargetDensity(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        setTargetDensity(metrics.densityDpi);
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:14.975 -0400", hash_original_method = "A17595DAE1AE36756FF8FF6EEBB23DC0", hash_generated_method = "4D2A0C524AA21A1964FF1EB8AC514EA5")
    @DSModeled(DSC.SAFE)
    public void setTargetDensity(int density) {
        dsTaint.addTaint(density);
        {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            {
                computeBitmapSize();
            } //End block
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (mTargetDensity != density) {
            //mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            //if (mBitmap != null) {
                //computeBitmapSize();
            //}
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.002 -0400", hash_original_method = "35E95FC787F9F24A49C5DE1ED0297F4C", hash_generated_method = "FC97ED1612065AC71A46CDBAF93DDB0D")
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapState.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.088 -0400", hash_original_method = "4FFB5FF85BF6BE29F34E4951AEB6D83F", hash_generated_method = "216E3D2944274CC49297449D314856EC")
    @DSModeled(DSC.SAFE)
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        {
            mBitmapState.mGravity = gravity;
            mApplyGravity = true;
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (mBitmapState.mGravity != gravity) {
            //mBitmapState.mGravity = gravity;
            //mApplyGravity = true;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.092 -0400", hash_original_method = "A6A7F02FCC6854A1D6F789226FBA84D5", hash_generated_method = "5FCBE323D9FCE7FC9F0FA47AF9355587")
    @DSModeled(DSC.SAFE)
    public void setAntiAlias(boolean aa) {
        dsTaint.addTaint(aa);
        mBitmapState.mPaint.setAntiAlias(aa);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setAntiAlias(aa);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.132 -0400", hash_original_method = "79F41E9E1F5486CC4586236A9EB22FE0", hash_generated_method = "2A25AFD02996FEAFFA9336E10B3F2ADA")
    @DSModeled(DSC.SAFE)
    @Override
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
        mBitmapState.mPaint.setFilterBitmap(filter);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.212 -0400", hash_original_method = "FC203784F21362ACF19CD453633052FE", hash_generated_method = "A006F5C56416D4D76DF50915BDE476EB")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        mBitmapState.mPaint.setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.257 -0400", hash_original_method = "8C03C626370DF89EB681D1D91A4CB25A", hash_generated_method = "A482C39E1124E251098638A767FB7841")
    @DSModeled(DSC.SAFE)
    public Shader.TileMode getTileModeX() {
        return (Shader.TileMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.301 -0400", hash_original_method = "C4F6E36EB6EDDD2C280548D4CD537229", hash_generated_method = "06F4FE76483692F4AFF56EE777AFF94A")
    @DSModeled(DSC.SAFE)
    public Shader.TileMode getTileModeY() {
        return (Shader.TileMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.329 -0400", hash_original_method = "856CFED7038AD7D83A692D422DD3B90C", hash_generated_method = "11F771CE9ACA7FB3E29F9AF7376CB5E7")
    @DSModeled(DSC.SAFE)
    public void setTileModeX(Shader.TileMode mode) {
        dsTaint.addTaint(mode.dsTaint);
        setTileModeXY(mode, mBitmapState.mTileModeY);
        // ---------- Original Method ----------
        //setTileModeXY(mode, mBitmapState.mTileModeY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.356 -0400", hash_original_method = "445DE87A20C6F0A91872714D31B4C1C9", hash_generated_method = "A40609420426DC9BB1AA0A19249EA61B")
    @DSModeled(DSC.SAFE)
    public final void setTileModeY(Shader.TileMode mode) {
        dsTaint.addTaint(mode.dsTaint);
        setTileModeXY(mBitmapState.mTileModeX, mode);
        // ---------- Original Method ----------
        //setTileModeXY(mBitmapState.mTileModeX, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.370 -0400", hash_original_method = "ADEC19A1E439C619635E588D2B7F4415", hash_generated_method = "7C420504F2F35D3803DE55CEF5BB8F3C")
    @DSModeled(DSC.SAFE)
    public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        dsTaint.addTaint(ymode.dsTaint);
        dsTaint.addTaint(xmode.dsTaint);
        final BitmapState state;
        state = mBitmapState;
        {
            state.mTileModeX = xmode;
            state.mTileModeY = ymode;
            state.mRebuildShader = true;
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //final BitmapState state = mBitmapState;
        //if (state.mTileModeX != xmode || state.mTileModeY != ymode) {
            //state.mTileModeX = xmode;
            //state.mTileModeY = ymode;
            //state.mRebuildShader = true;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.402 -0400", hash_original_method = "10D38B42FB036E8B57E4A209AB7F4ADC", hash_generated_method = "7488E6876EAF9B0D95E953795EB98678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int varA770F81D96E9B1930F8D483FADA8C11B_1406857174 = (super.getChangingConfigurations() | mBitmapState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.493 -0400", hash_original_method = "43A5F38374D847F9AEDDDDB09459070C", hash_generated_method = "C3A18BAB7E70E8A410415758B85BF956")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        super.onBoundsChange(bounds);
        mApplyGravity = true;
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //mApplyGravity = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.681 -0400", hash_original_method = "6FA1B7BCBB056D9C6C12415C137DE76D", hash_generated_method = "5BDC121477379A7BBCED29C76CB3ED0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        Bitmap bitmap;
        bitmap = mBitmap;
        {
            final BitmapState state;
            state = mBitmapState;
            {
                Shader.TileMode tmx;
                tmx = state.mTileModeX;
                Shader.TileMode tmy;
                tmy = state.mTileModeY;
                {
                    state.mPaint.setShader(null);
                } //End block
                {
                    state.mPaint.setShader(new BitmapShader(bitmap,
                            tmx == null ? Shader.TileMode.CLAMP : tmx,
                            tmy == null ? Shader.TileMode.CLAMP : tmy));
                } //End block
                state.mRebuildShader = false;
                copyBounds(mDstRect);
            } //End block
            Shader shader;
            shader = state.mPaint.getShader();
            {
                {
                    final int layoutDirection;
                    layoutDirection = getResolvedLayoutDirectionSelf();
                    Gravity.apply(state.mGravity, mBitmapWidth, mBitmapHeight,
                            getBounds(), mDstRect, layoutDirection);
                    mApplyGravity = false;
                } //End block
                canvas.drawBitmap(bitmap, null, mDstRect, state.mPaint);
            } //End block
            {
                {
                    copyBounds(mDstRect);
                    mApplyGravity = false;
                } //End block
                canvas.drawRect(mDstRect, state.mPaint);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.772 -0400", hash_original_method = "49CE66D09454E056E2AD494EF2DD30A3", hash_generated_method = "97A7CA184DE4F65B01571B55780AD3A3")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        int oldAlpha;
        oldAlpha = mBitmapState.mPaint.getAlpha();
        {
            mBitmapState.mPaint.setAlpha(alpha);
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //int oldAlpha = mBitmapState.mPaint.getAlpha();
        //if (alpha != oldAlpha) {
            //mBitmapState.mPaint.setAlpha(alpha);
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.825 -0400", hash_original_method = "F79C881D02962F781494A97AA0D9D98A", hash_generated_method = "35E4856366CD675BC94C7E94AAF7C3A1")
    @DSModeled(DSC.SAFE)
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mBitmapState.mPaint.setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:15.944 -0400", hash_original_method = "12F43AAD192527EE14BD9EA92E6F05B8", hash_generated_method = "BC719F00E0A416DDC8656FC2C6BE7E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_1873834274 = (!mMutated && super.mutate() == this);
            {
                mBitmapState = new BitmapState(mBitmapState);
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mBitmapState = new BitmapState(mBitmapState);
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:16.892 -0400", hash_original_method = "C7B53A4BB10177C8F005B36E9252EFF2", hash_generated_method = "5AD9923D3DF9DB9B899FE66FAC17E85B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.BitmapDrawable);
        final int id;
        id = a.getResourceId(com.android.internal.R.styleable.BitmapDrawable_src, 0);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
        final Bitmap bitmap;
        bitmap = BitmapFactory.decodeResource(r, id);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
        mBitmapState.mBitmap = bitmap;
        setBitmap(bitmap);
        setTargetDensity(r.getDisplayMetrics());
        final Paint paint;
        paint = mBitmapState.mPaint;
        paint.setAntiAlias(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_antialias,
                paint.isAntiAlias()));
        paint.setFilterBitmap(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_filter,
                paint.isFilterBitmap()));
        paint.setDither(a.getBoolean(com.android.internal.R.styleable.BitmapDrawable_dither,
                paint.isDither()));
        setGravity(a.getInt(com.android.internal.R.styleable.BitmapDrawable_gravity, Gravity.FILL));
        int tileMode;
        tileMode = a.getInt(com.android.internal.R.styleable.BitmapDrawable_tileMode, -1);
        {
            //Begin case 0 
            setTileModeXY(Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            //End case 0 
            //Begin case 1 
            setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            //End case 1 
            //Begin case 2 
            setTileModeXY(Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
            //End case 2 
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:16.968 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "B1FA7F25CD2997B4ADD3A143E1465255")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:16.986 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "9E68AE3ADEAAC27CE3F655F015361F0B")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.113 -0400", hash_original_method = "9571905A182C10BB0B86009E34DE8EF4", hash_generated_method = "1FC9A6A2237E251AB7392148E5CA67FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        Bitmap bm;
        bm = mBitmap;
        {
            boolean var65AA1139D89603A7B5D75450BE5BC76F_2142804110 = ((bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mBitmapState.mGravity != Gravity.FILL) {
            //return PixelFormat.TRANSLUCENT;
        //}
        //Bitmap bm = mBitmap;
        //return (bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255) ?
                //PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.142 -0400", hash_original_method = "B22D07CBAAEE149FB3D11CBEDB83599B", hash_generated_method = "D2C07EABFC02BC4B14F5586AB2D49BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ConstantState getConstantState() {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBitmapState.mChangingConfigurations = getChangingConfigurations();
        //return mBitmapState;
    }

    
    final static class BitmapState extends ConstantState {
        Bitmap mBitmap;
        int mChangingConfigurations;
        int mGravity = Gravity.FILL;
        Paint mPaint = new Paint(DEFAULT_PAINT_FLAGS);
        Shader.TileMode mTileModeX = null;
        Shader.TileMode mTileModeY = null;
        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        boolean mRebuildShader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.161 -0400", hash_original_method = "80003A9E2431B1DF8C6F7DBC005B3BC9", hash_generated_method = "B52FA501E60306E378E49F0858CBF4B6")
        @DSModeled(DSC.SAFE)
         BitmapState(Bitmap bitmap) {
            dsTaint.addTaint(bitmap.dsTaint);
            // ---------- Original Method ----------
            //mBitmap = bitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.260 -0400", hash_original_method = "C0031760E3673EAB51AB6808BBA62477", hash_generated_method = "0B2BE29B1CF75757E9A0A4520E0665E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         BitmapState(BitmapState bitmapState) {
            this(bitmapState.mBitmap);
            dsTaint.addTaint(bitmapState.dsTaint);
            mChangingConfigurations = bitmapState.mChangingConfigurations;
            mGravity = bitmapState.mGravity;
            mTileModeX = bitmapState.mTileModeX;
            mTileModeY = bitmapState.mTileModeY;
            mTargetDensity = bitmapState.mTargetDensity;
            mPaint = new Paint(bitmapState.mPaint);
            mRebuildShader = bitmapState.mRebuildShader;
            // ---------- Original Method ----------
            //mChangingConfigurations = bitmapState.mChangingConfigurations;
            //mGravity = bitmapState.mGravity;
            //mTileModeX = bitmapState.mTileModeX;
            //mTileModeY = bitmapState.mTileModeY;
            //mTargetDensity = bitmapState.mTargetDensity;
            //mPaint = new Paint(bitmapState.mPaint);
            //mRebuildShader = bitmapState.mRebuildShader;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.271 -0400", hash_original_method = "7A0D3C52124D4E31E0F3E052BCC0F262", hash_generated_method = "064B923DE658F6326ECCF832002FE1EA")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.307 -0400", hash_original_method = "E262501023FDB9346524FFA189B84EDB", hash_generated_method = "C0520629A40B4DF9A98B125211307CA0")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:17.316 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2D59F41488F7278F18877F131EF0D371")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
}


