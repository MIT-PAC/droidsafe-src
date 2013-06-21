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
    private BitmapState mBitmapState;
    private Bitmap mBitmap;
    private int mTargetDensity;
    private Rect mDstRect = new Rect();
    private boolean mApplyGravity;
    private boolean mMutated;
    private int mBitmapWidth;
    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.929 -0400", hash_original_method = "B0AF2A53C18BC0AEA00F89D5110E52E7", hash_generated_method = "29FF9CA7DE78EFC57224158AE5341D65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public BitmapDrawable() {
        mBitmapState = new BitmapState((Bitmap) null);
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.930 -0400", hash_original_method = "ECC74DE3478988E64B883DFDAEC329B4", hash_generated_method = "408B3F36133C53413917CD8262E51C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res) {
        dsTaint.addTaint(res.dsTaint);
        mBitmapState = new BitmapState((Bitmap) null);
        mBitmapState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.930 -0400", hash_original_method = "EDF3772DB206CC7034C0B4AE87D72F1A", hash_generated_method = "B5D3F01F12FD151CF81F2DA5F4BEC7D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), null);
        dsTaint.addTaint(bitmap.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.930 -0400", hash_original_method = "0FA3F000A20BF5722D4983CAD4B48A6A", hash_generated_method = "4592916D91A93FEC3CB03DC4AE3AE232")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitmapDrawable(Resources res, Bitmap bitmap) {
        this(new BitmapState(bitmap), res);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(bitmap.dsTaint);
        mBitmapState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.931 -0400", hash_original_method = "88A1392443C2003D9FA4C6DECF6A14A3", hash_generated_method = "D3755B3B0356B7D3C68FF2DAFBDAC9D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.931 -0400", hash_original_method = "2E50FC990DF5F99ED2B436DB68D65D30", hash_generated_method = "C674F1BA1013C53BA69E234E9074C9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    public BitmapDrawable(Resources res, String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        dsTaint.addTaint(filepath);
        dsTaint.addTaint(res.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.931 -0400", hash_original_method = "5474E95C495E2BDEA7848B2F1051B5AB", hash_generated_method = "EEB08C8F4A50A8CA0C5F87F07FE36014")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.931 -0400", hash_original_method = "A95CEE47ED6D08FEFE672AAA66725922", hash_generated_method = "90EE97AB3CD10C48D0742BDB58EE3DA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.932 -0400", hash_original_method = "FB19047A342C9589C667FFAF2B0ECEA1", hash_generated_method = "D887F070A8548787A2BB0AD1719745D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.932 -0400", hash_original_method = "29B9C66D2E3FF8CE986D27E62D842E86", hash_generated_method = "1B9FBC4EEDC9A417BE012518A9B9195F")
    @DSModeled(DSC.SAFE)
    public final Paint getPaint() {
        return (Paint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.932 -0400", hash_original_method = "CDEEA354B6732B0C95C918F7ECA77F64", hash_generated_method = "F53AD048E40B03402139E2D9F4BD9F54")
    @DSModeled(DSC.SAFE)
    public final Bitmap getBitmap() {
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.933 -0400", hash_original_method = "BD13D47BACD5F22B3F18803E2B331415", hash_generated_method = "5BD547052F6BE282E7B4F0BFF461A99A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
        // ---------- Original Method ----------
        //mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        //mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.933 -0400", hash_original_method = "5A8B316E5E7A06983942607FAB994128", hash_generated_method = "BB1F0F1A385BB81CA148F9BD54DE2F0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.933 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "5AE2074DBD3336F28282B383F84002BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        setTargetDensity(canvas.getDensity());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.933 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "CA201B9257141BB6206992605DA679FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        setTargetDensity(metrics.densityDpi);
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.934 -0400", hash_original_method = "A17595DAE1AE36756FF8FF6EEBB23DC0", hash_generated_method = "11316574AA36B735A9FFA02054BDE683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.934 -0400", hash_original_method = "35E95FC787F9F24A49C5DE1ED0297F4C", hash_generated_method = "0BB004F4AC46233C6FBC6E0A41789452")
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapState.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.934 -0400", hash_original_method = "4FFB5FF85BF6BE29F34E4951AEB6D83F", hash_generated_method = "1C734484326D7BB67F2CFEA2E5853FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.934 -0400", hash_original_method = "A6A7F02FCC6854A1D6F789226FBA84D5", hash_generated_method = "153239DB3CB42C61F020CD743EFFA1C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAntiAlias(boolean aa) {
        dsTaint.addTaint(aa);
        mBitmapState.mPaint.setAntiAlias(aa);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setAntiAlias(aa);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.935 -0400", hash_original_method = "79F41E9E1F5486CC4586236A9EB22FE0", hash_generated_method = "A7A7D8987EC4609F29D6355592DB7EAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
        mBitmapState.mPaint.setFilterBitmap(filter);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.935 -0400", hash_original_method = "FC203784F21362ACF19CD453633052FE", hash_generated_method = "33F25055C6997093A7522266A6187839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        mBitmapState.mPaint.setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.935 -0400", hash_original_method = "8C03C626370DF89EB681D1D91A4CB25A", hash_generated_method = "C02D0C441AAE5DE8E18372591E0D5C79")
    @DSModeled(DSC.SAFE)
    public Shader.TileMode getTileModeX() {
        return (Shader.TileMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.935 -0400", hash_original_method = "C4F6E36EB6EDDD2C280548D4CD537229", hash_generated_method = "B203FA1D3090A23CE1C3E53DEA503E48")
    @DSModeled(DSC.SAFE)
    public Shader.TileMode getTileModeY() {
        return (Shader.TileMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.936 -0400", hash_original_method = "856CFED7038AD7D83A692D422DD3B90C", hash_generated_method = "214180852F455E9C2B5C2F89821398FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTileModeX(Shader.TileMode mode) {
        dsTaint.addTaint(mode.dsTaint);
        setTileModeXY(mode, mBitmapState.mTileModeY);
        // ---------- Original Method ----------
        //setTileModeXY(mode, mBitmapState.mTileModeY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.936 -0400", hash_original_method = "445DE87A20C6F0A91872714D31B4C1C9", hash_generated_method = "D03DA061E0BEAB232FF12C0E18FAD483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setTileModeY(Shader.TileMode mode) {
        dsTaint.addTaint(mode.dsTaint);
        setTileModeXY(mBitmapState.mTileModeX, mode);
        // ---------- Original Method ----------
        //setTileModeXY(mBitmapState.mTileModeX, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.936 -0400", hash_original_method = "ADEC19A1E439C619635E588D2B7F4415", hash_generated_method = "B9FF911AAF80329F56A07F647B26F27C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        dsTaint.addTaint(ymode.dsTaint);
        dsTaint.addTaint(xmode.dsTaint);
        BitmapState state;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.936 -0400", hash_original_method = "10D38B42FB036E8B57E4A209AB7F4ADC", hash_generated_method = "9604CA9FADC94B390DF6BDD71759D5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int varA770F81D96E9B1930F8D483FADA8C11B_215450568 = (super.getChangingConfigurations() | mBitmapState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.937 -0400", hash_original_method = "43A5F38374D847F9AEDDDDB09459070C", hash_generated_method = "C12697D8672891DABAC41FBE42696442")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.937 -0400", hash_original_method = "6FA1B7BCBB056D9C6C12415C137DE76D", hash_generated_method = "74FAA9C68C2C3E08B40A506948FE357E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        Bitmap bitmap;
        bitmap = mBitmap;
        {
            BitmapState state;
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
                    int layoutDirection;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.938 -0400", hash_original_method = "49CE66D09454E056E2AD494EF2DD30A3", hash_generated_method = "3716F5AD7DAA83DF1FA1496C9A8A2F17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.943 -0400", hash_original_method = "F79C881D02962F781494A97AA0D9D98A", hash_generated_method = "58E835AE3F4273A990C6205D874D5917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mBitmapState.mPaint.setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.944 -0400", hash_original_method = "12F43AAD192527EE14BD9EA92E6F05B8", hash_generated_method = "F920004FEFB790E564D3DC481025DEDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_746980495 = (!mMutated && super.mutate() == this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.945 -0400", hash_original_method = "C7B53A4BB10177C8F005B36E9252EFF2", hash_generated_method = "D4A24BBE4D2F31C05664AC924C733C1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.BitmapDrawable);
        int id;
        id = a.getResourceId(com.android.internal.R.styleable.BitmapDrawable_src, 0);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeResource(r, id);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
        mBitmapState.mBitmap = bitmap;
        setBitmap(bitmap);
        setTargetDensity(r.getDisplayMetrics());
        Paint paint;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.945 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "5FF4CA940937A0DF3B8654CDD8C46AE8")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.945 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "290BB80DDDA870A8A4E130689F858B6F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.946 -0400", hash_original_method = "9571905A182C10BB0B86009E34DE8EF4", hash_generated_method = "91536710A0A8B0C834D207C090CCF3BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        Bitmap bm;
        bm = mBitmap;
        {
            boolean var65AA1139D89603A7B5D75450BE5BC76F_671550012 = ((bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.946 -0400", hash_original_method = "B22D07CBAAEE149FB3D11CBEDB83599B", hash_generated_method = "F7D9B5218E309444130B08E036E9EDE9")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.946 -0400", hash_original_method = "80003A9E2431B1DF8C6F7DBC005B3BC9", hash_generated_method = "C41AB57CBB2F7C70016B0D3B36EF430B")
        @DSModeled(DSC.SAFE)
         BitmapState(Bitmap bitmap) {
            dsTaint.addTaint(bitmap.dsTaint);
            // ---------- Original Method ----------
            //mBitmap = bitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.947 -0400", hash_original_method = "C0031760E3673EAB51AB6808BBA62477", hash_generated_method = "71889F33249FC8321C64FF6D6103BBE8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.947 -0400", hash_original_method = "7A0D3C52124D4E31E0F3E052BCC0F262", hash_generated_method = "C9954A6722B70B0BA8B36D93D854598A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var5E3DC18038C013C7B2A8F43BB30BAA61_1991405194 = (new BitmapDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.947 -0400", hash_original_method = "E262501023FDB9346524FFA189B84EDB", hash_generated_method = "7C2ABC893F1C9CA0FA10165C8E57AF38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable varD791D72606C6742123CED150E799A09C_307148665 = (new BitmapDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.947 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    private static final int DEFAULT_PAINT_FLAGS =
            Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG;
}

