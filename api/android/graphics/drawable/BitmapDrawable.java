package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.613 -0400", hash_original_field = "8CF9D6A2BA83DEFBA443E79D87D8B1A2", hash_generated_field = "3A76FEC83F92CDCF2EE402CB0D000CA7")

    private BitmapState mBitmapState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "E3FD93BDA80C01F50A45E71FBA2F2318", hash_generated_field = "13CD7AE350A8EF6D449472E24FC8398F")

    private int mTargetDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "1320DB4AC9152B6EEDA856562A1C352D", hash_generated_field = "1E3D8C2BEBFECFBF47423C145BB19A3C")

    private final Rect mDstRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "79CEB2570500CABABA0DD2F3ED958E15", hash_generated_field = "5A87E51B39C79BA29E312E77B8B43A92")

    private boolean mApplyGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "DE6A0ABB3CA1313B4F7BDFF407B4A18B", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.614 -0400", hash_original_field = "EE573FC7FF36074270F8BF43556DFB4C", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.615 -0400", hash_original_method = "B0AF2A53C18BC0AEA00F89D5110E52E7", hash_generated_method = "29FF9CA7DE78EFC57224158AE5341D65")
    @Deprecated
    public  BitmapDrawable() {
        mBitmapState = new BitmapState((Bitmap) null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.616 -0400", hash_original_method = "ECC74DE3478988E64B883DFDAEC329B4", hash_generated_method = "B8F53F068664D88F4A14ADE77C0B6BB1")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res) {
        addTaint(res.getTaint());
        mBitmapState = new BitmapState((Bitmap) null);
        mBitmapState.mTargetDensity = mTargetDensity;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.616 -0400", hash_original_method = "EDF3772DB206CC7034C0B4AE87D72F1A", hash_generated_method = "C08812B7C36B875EA3AC6289F8C1030A")
    @Deprecated
    public  BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), null);
        addTaint(bitmap.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.617 -0400", hash_original_method = "0FA3F000A20BF5722D4983CAD4B48A6A", hash_generated_method = "2910F98D7FC104D8099BFC6FCA77279D")
    public  BitmapDrawable(Resources res, Bitmap bitmap) {
        this(new BitmapState(bitmap), res);
        addTaint(bitmap.getTaint());
        addTaint(res.getTaint());
        mBitmapState.mTargetDensity = mTargetDensity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.617 -0400", hash_original_method = "88A1392443C2003D9FA4C6DECF6A14A3", hash_generated_method = "11E1EB6556FB31A283EA23E9AB149719")
    @Deprecated
    public  BitmapDrawable(String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        addTaint(filepath.getTaint());
    if(mBitmap == null)        
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.618 -0400", hash_original_method = "2E50FC990DF5F99ED2B436DB68D65D30", hash_generated_method = "52559ACAAB9903121470AE818205C61E")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res, String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        addTaint(filepath.getTaint());
        addTaint(res.getTaint());
        mBitmapState.mTargetDensity = mTargetDensity;
    if(mBitmap == null)        
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.618 -0400", hash_original_method = "5474E95C495E2BDEA7848B2F1051B5AB", hash_generated_method = "3CC7842E019BDB532FFCC8F01C34C375")
    @Deprecated
    public  BitmapDrawable(java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        addTaint(is.getTaint());
    if(mBitmap == null)        
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.619 -0400", hash_original_method = "A95CEE47ED6D08FEFE672AAA66725922", hash_generated_method = "BAA8606004AB589254F25A1225F006AD")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res, java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        addTaint(is.getTaint());
        addTaint(res.getTaint());
        mBitmapState.mTargetDensity = mTargetDensity;
    if(mBitmap == null)        
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.620 -0400", hash_original_method = "FB19047A342C9589C667FFAF2B0ECEA1", hash_generated_method = "64DA8E1E2360AAEBBD8776CA3ECF0205")
    private  BitmapDrawable(BitmapState state, Resources res) {
        mBitmapState = state;
    if(res != null)        
        {
            mTargetDensity = res.getDisplayMetrics().densityDpi;
        } 
        else
        {
            mTargetDensity = state.mTargetDensity;
        } 
        setBitmap(state != null ? state.mBitmap : null);
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.620 -0400", hash_original_method = "29B9C66D2E3FF8CE986D27E62D842E86", hash_generated_method = "C69AA6868EA20694703931863C2A1095")
    public final Paint getPaint() {
Paint varE3E65144F7E831421DA6CC787BBC597C_1798716530 =         mBitmapState.mPaint;
        varE3E65144F7E831421DA6CC787BBC597C_1798716530.addTaint(taint);
        return varE3E65144F7E831421DA6CC787BBC597C_1798716530;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.620 -0400", hash_original_method = "CDEEA354B6732B0C95C918F7ECA77F64", hash_generated_method = "6BED37C5C5F22F18798209E8B7F503E8")
    public final Bitmap getBitmap() {
Bitmap var3AE2FA0FD35BCE2BB296A9C2B523C9FC_1222742160 =         mBitmap;
        var3AE2FA0FD35BCE2BB296A9C2B523C9FC_1222742160.addTaint(taint);
        return var3AE2FA0FD35BCE2BB296A9C2B523C9FC_1222742160;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.621 -0400", hash_original_method = "BD13D47BACD5F22B3F18803E2B331415", hash_generated_method = "5BD547052F6BE282E7B4F0BFF461A99A")
    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.621 -0400", hash_original_method = "5A8B316E5E7A06983942607FAB994128", hash_generated_method = "FAC645F6B1147F59BBC47A9751C86933")
    private void setBitmap(Bitmap bitmap) {
    if(bitmap != mBitmap)        
        {
            mBitmap = bitmap;
    if(bitmap != null)            
            {
                computeBitmapSize();
            } 
            else
            {
                mBitmapWidth = mBitmapHeight = -1;
            } 
            invalidateSelf();
        } 
        
        
            
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.622 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "08ADEC9348B823ADA440A2B50003FC7E")
    public void setTargetDensity(Canvas canvas) {
        addTaint(canvas.getTaint());
        setTargetDensity(canvas.getDensity());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.622 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "A780DDFCC4CBE80D7EFC83D56CFDF67F")
    public void setTargetDensity(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        setTargetDensity(metrics.densityDpi);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.623 -0400", hash_original_method = "A17595DAE1AE36756FF8FF6EEBB23DC0", hash_generated_method = "BAA55B2CE1AB01E63F69C3EACC446F44")
    public void setTargetDensity(int density) {
    if(mTargetDensity != density)        
        {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
    if(mBitmap != null)            
            {
                computeBitmapSize();
            } 
            invalidateSelf();
        } 
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.623 -0400", hash_original_method = "35E95FC787F9F24A49C5DE1ED0297F4C", hash_generated_method = "5464C78F867D49DCF0DA1280FCA28B17")
    public int getGravity() {
        int varAC1B497EA644683625E1592BCC420E70_1088563413 = (mBitmapState.mGravity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006996592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006996592;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.624 -0400", hash_original_method = "4FFB5FF85BF6BE29F34E4951AEB6D83F", hash_generated_method = "4990407CF9ED1404EE61CF8CAFF9F273")
    public void setGravity(int gravity) {
    if(mBitmapState.mGravity != gravity)        
        {
            mBitmapState.mGravity = gravity;
            mApplyGravity = true;
            invalidateSelf();
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.624 -0400", hash_original_method = "A6A7F02FCC6854A1D6F789226FBA84D5", hash_generated_method = "FDB48E3CB0AEF7BEC72E3587CE056080")
    public void setAntiAlias(boolean aa) {
        addTaint(aa);
        mBitmapState.mPaint.setAntiAlias(aa);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.625 -0400", hash_original_method = "79F41E9E1F5486CC4586236A9EB22FE0", hash_generated_method = "EA50CFAF9A3655479F733C2E485F5B20")
    @Override
    public void setFilterBitmap(boolean filter) {
        addTaint(filter);
        mBitmapState.mPaint.setFilterBitmap(filter);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.625 -0400", hash_original_method = "FC203784F21362ACF19CD453633052FE", hash_generated_method = "1FEF8C5682A4E65A1BA40DA090FD2DD6")
    @Override
    public void setDither(boolean dither) {
        addTaint(dither);
        mBitmapState.mPaint.setDither(dither);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.625 -0400", hash_original_method = "8C03C626370DF89EB681D1D91A4CB25A", hash_generated_method = "AC1AA89EA54FF900E2894FED925FF019")
    public Shader.TileMode getTileModeX() {
Shader.TileMode var8A0DDC40CE3A669DB6E8ED93A5D53143_1009486631 =         mBitmapState.mTileModeX;
        var8A0DDC40CE3A669DB6E8ED93A5D53143_1009486631.addTaint(taint);
        return var8A0DDC40CE3A669DB6E8ED93A5D53143_1009486631;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.626 -0400", hash_original_method = "C4F6E36EB6EDDD2C280548D4CD537229", hash_generated_method = "7E0979A198C24E4E0639033239D56D7A")
    public Shader.TileMode getTileModeY() {
Shader.TileMode var20C17428E24ACD541E1A3941B269BCFC_1801635636 =         mBitmapState.mTileModeY;
        var20C17428E24ACD541E1A3941B269BCFC_1801635636.addTaint(taint);
        return var20C17428E24ACD541E1A3941B269BCFC_1801635636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.627 -0400", hash_original_method = "856CFED7038AD7D83A692D422DD3B90C", hash_generated_method = "D7EB833378A78EEB251B687D6A418614")
    public void setTileModeX(Shader.TileMode mode) {
        addTaint(mode.getTaint());
        setTileModeXY(mode, mBitmapState.mTileModeY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.628 -0400", hash_original_method = "445DE87A20C6F0A91872714D31B4C1C9", hash_generated_method = "00F602B4F9F100DDF3497B32C03E846E")
    public final void setTileModeY(Shader.TileMode mode) {
        addTaint(mode.getTaint());
        setTileModeXY(mBitmapState.mTileModeX, mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.629 -0400", hash_original_method = "ADEC19A1E439C619635E588D2B7F4415", hash_generated_method = "FEC60FA57D9721BBB1E91CD6B2A83F5F")
    public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        addTaint(ymode.getTaint());
        addTaint(xmode.getTaint());
        final BitmapState state = mBitmapState;
    if(state.mTileModeX != xmode || state.mTileModeY != ymode)        
        {
            state.mTileModeX = xmode;
            state.mTileModeY = ymode;
            state.mRebuildShader = true;
            invalidateSelf();
        } 
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.629 -0400", hash_original_method = "10D38B42FB036E8B57E4A209AB7F4ADC", hash_generated_method = "13FE008A27BCE9225C79E24649AAF7D0")
    @Override
    public int getChangingConfigurations() {
        int var3FEDC0452C3DBDEBD33B7D15B3692B25_320191890 = (super.getChangingConfigurations() | mBitmapState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923572587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923572587;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.630 -0400", hash_original_method = "43A5F38374D847F9AEDDDDB09459070C", hash_generated_method = "4C719EE6B6EF151AB2ABE8E40AB0AC81")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        addTaint(bounds.getTaint());
        super.onBoundsChange(bounds);
        mApplyGravity = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.631 -0400", hash_original_method = "6FA1B7BCBB056D9C6C12415C137DE76D", hash_generated_method = "8ABD2040214BD4F752B8F3FAF33F477D")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        Bitmap bitmap = mBitmap;
    if(bitmap != null)        
        {
            final BitmapState state = mBitmapState;
    if(state.mRebuildShader)            
            {
                Shader.TileMode tmx = state.mTileModeX;
                Shader.TileMode tmy = state.mTileModeY;
    if(tmx == null && tmy == null)                
                {
                    state.mPaint.setShader(null);
                } 
                else
                {
                    state.mPaint.setShader(new BitmapShader(bitmap,
                            tmx == null ? Shader.TileMode.CLAMP : tmx,
                            tmy == null ? Shader.TileMode.CLAMP : tmy));
                } 
                state.mRebuildShader = false;
                copyBounds(mDstRect);
            } 
            Shader shader = state.mPaint.getShader();
    if(shader == null)            
            {
    if(mApplyGravity)                
                {
                    final int layoutDirection = getResolvedLayoutDirectionSelf();
                    Gravity.apply(state.mGravity, mBitmapWidth, mBitmapHeight,
                            getBounds(), mDstRect, layoutDirection);
                    mApplyGravity = false;
                } 
                canvas.drawBitmap(bitmap, null, mDstRect, state.mPaint);
            } 
            else
            {
    if(mApplyGravity)                
                {
                    copyBounds(mDstRect);
                    mApplyGravity = false;
                } 
                canvas.drawRect(mDstRect, state.mPaint);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.632 -0400", hash_original_method = "49CE66D09454E056E2AD494EF2DD30A3", hash_generated_method = "91CAF86F01D69BF321FD7132A16F8D2A")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        int oldAlpha = mBitmapState.mPaint.getAlpha();
    if(alpha != oldAlpha)        
        {
            mBitmapState.mPaint.setAlpha(alpha);
            invalidateSelf();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.633 -0400", hash_original_method = "F79C881D02962F781494A97AA0D9D98A", hash_generated_method = "1B97F5953B8EC21C266369A4AD2517A7")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mBitmapState.mPaint.setColorFilter(cf);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.634 -0400", hash_original_method = "12F43AAD192527EE14BD9EA92E6F05B8", hash_generated_method = "91A6CF0AB6E028FCAC5005035CDB013C")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mBitmapState = new BitmapState(mBitmapState);
            mMutated = true;
        } 
Drawable var72A74007B2BE62B849F475C7BDA4658B_1312445158 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1312445158.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1312445158;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.636 -0400", hash_original_method = "C7B53A4BB10177C8F005B36E9252EFF2", hash_generated_method = "866F0008BE1353BEF452A9E74C99CA18")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.BitmapDrawable);
        final int id = a.getResourceId(com.android.internal.R.styleable.BitmapDrawable_src, 0);
    if(id == 0)        
        {
            XmlPullParserException var1601E3160C46A96655701F0CD188D346_1138955470 = new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
            var1601E3160C46A96655701F0CD188D346_1138955470.addTaint(taint);
            throw var1601E3160C46A96655701F0CD188D346_1138955470;
        } 
        final Bitmap bitmap = BitmapFactory.decodeResource(r, id);
    if(bitmap == null)        
        {
            XmlPullParserException var1601E3160C46A96655701F0CD188D346_95921230 = new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
            var1601E3160C46A96655701F0CD188D346_95921230.addTaint(taint);
            throw var1601E3160C46A96655701F0CD188D346_95921230;
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
    if(tileMode != -1)        
        {
switch(tileMode){
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.637 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "E940B0EAACB158EFC7BB2A5418BB75D9")
    @Override
    public int getIntrinsicWidth() {
        int varDE6A0ABB3CA1313B4F7BDFF407B4A18B_812767657 = (mBitmapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_297319419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_297319419;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.638 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "28BF95AAFAE58C32D16E9C2AE5D33A21")
    @Override
    public int getIntrinsicHeight() {
        int varEE573FC7FF36074270F8BF43556DFB4C_73103787 = (mBitmapHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622391932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1622391932;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.639 -0400", hash_original_method = "9571905A182C10BB0B86009E34DE8EF4", hash_generated_method = "48F43F4B9BF8FC5E9755C113B1B4979E")
    @Override
    public int getOpacity() {
    if(mBitmapState.mGravity != Gravity.FILL)        
        {
            int var26C79996E92FCFBDC98A49C80BC91AD0_1434194118 = (PixelFormat.TRANSLUCENT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573664650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573664650;
        } 
        Bitmap bm = mBitmap;
        int varE8E91935D3E850230416366BB42F953B_2099352410 = ((bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255) ?
                PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076216569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076216569;
        
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_method = "B22D07CBAAEE149FB3D11CBEDB83599B", hash_generated_method = "8534606B8CCFFC895011F9200C893292")
    @Override
    public final ConstantState getConstantState() {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
ConstantState var3E67C407BBCC4D42D5C5CECC6362B9A7_1380033668 =         mBitmapState;
        var3E67C407BBCC4D42D5C5CECC6362B9A7_1380033668.addTaint(taint);
        return var3E67C407BBCC4D42D5C5CECC6362B9A7_1380033668;
        
        
        
    }

    
    final static class BitmapState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "46C0A7FFF0FFB93D952536F8E8BA5C29")

        Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "DDCDC839DADEAD04333ED644B12D7DB9", hash_generated_field = "02974118B7DB2EBC67C99A80C329EC2D")

        int mGravity = Gravity.FILL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "BD957D3BC7CA3492655F65B4E470959F", hash_generated_field = "F847D1003F51642BF2CF19539CE8548D")

        Paint mPaint = new Paint(DEFAULT_PAINT_FLAGS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "AE4E5625D3BC87E574124C0D35AA33F0", hash_generated_field = "6E9BEEFA8B8AEF79DD5E5F09806F1C57")

        Shader.TileMode mTileModeX = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "175572BE9589677CFF38C357404E53D9", hash_generated_field = "4B2749A46C2F0D56B391EF4A168B3C38")

        Shader.TileMode mTileModeY = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.640 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.641 -0400", hash_original_field = "C95B286C20384507638FDBDA61303A46", hash_generated_field = "6C534FAF0245C3B32617A5CE28BF5D41")

        boolean mRebuildShader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.641 -0400", hash_original_method = "80003A9E2431B1DF8C6F7DBC005B3BC9", hash_generated_method = "A9BB708F42AA8B8426AFD5B8BA3AC518")
          BitmapState(Bitmap bitmap) {
            mBitmap = bitmap;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.642 -0400", hash_original_method = "C0031760E3673EAB51AB6808BBA62477", hash_generated_method = "2C0F2E0534D8B72198A0A519439014E3")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.642 -0400", hash_original_method = "7A0D3C52124D4E31E0F3E052BCC0F262", hash_generated_method = "97165EA7B597097714802EA0386B1A57")
        @Override
        public Drawable newDrawable() {
Drawable var5E1084F28333265ABFA76FF86F056B51_479098243 =             new BitmapDrawable(this, null);
            var5E1084F28333265ABFA76FF86F056B51_479098243.addTaint(taint);
            return var5E1084F28333265ABFA76FF86F056B51_479098243;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.643 -0400", hash_original_method = "E262501023FDB9346524FFA189B84EDB", hash_generated_method = "30BC067CDD8D9867F0074A3B8CC3393C")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var63524157975F655BCEF229267EA3374D_2117085723 =             new BitmapDrawable(this, res);
            var63524157975F655BCEF229267EA3374D_2117085723.addTaint(taint);
            return var63524157975F655BCEF229267EA3374D_2117085723;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.643 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "D59AFF166059FA61ADD1F00A77E309CA")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1815398053 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764231197 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764231197;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.643 -0400", hash_original_field = "363F36F250F2419DDB43875B36ED4309", hash_generated_field = "88A3BEB3155DA79AE994754DCF9B8910")

    private static final int DEFAULT_PAINT_FLAGS = Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG;
}

