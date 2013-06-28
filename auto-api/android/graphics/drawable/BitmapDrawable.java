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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "8CF9D6A2BA83DEFBA443E79D87D8B1A2", hash_generated_field = "3A76FEC83F92CDCF2EE402CB0D000CA7")

    private BitmapState mBitmapState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "E3FD93BDA80C01F50A45E71FBA2F2318", hash_generated_field = "13CD7AE350A8EF6D449472E24FC8398F")

    private int mTargetDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "1320DB4AC9152B6EEDA856562A1C352D", hash_generated_field = "1E3D8C2BEBFECFBF47423C145BB19A3C")

    private final Rect mDstRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "79CEB2570500CABABA0DD2F3ED958E15", hash_generated_field = "5A87E51B39C79BA29E312E77B8B43A92")

    private boolean mApplyGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.629 -0400", hash_original_field = "DE6A0ABB3CA1313B4F7BDFF407B4A18B", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.630 -0400", hash_original_field = "EE573FC7FF36074270F8BF43556DFB4C", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.630 -0400", hash_original_method = "B0AF2A53C18BC0AEA00F89D5110E52E7", hash_generated_method = "29FF9CA7DE78EFC57224158AE5341D65")
    @Deprecated
    public  BitmapDrawable() {
        mBitmapState = new BitmapState((Bitmap) null);
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.630 -0400", hash_original_method = "ECC74DE3478988E64B883DFDAEC329B4", hash_generated_method = "B18D459252C5056083A6888A2A5429CA")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res) {
        mBitmapState = new BitmapState((Bitmap) null);
        mBitmapState.mTargetDensity = mTargetDensity;
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //mBitmapState = new BitmapState((Bitmap) null);
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.630 -0400", hash_original_method = "EDF3772DB206CC7034C0B4AE87D72F1A", hash_generated_method = "C08812B7C36B875EA3AC6289F8C1030A")
    @Deprecated
    public  BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), null);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.631 -0400", hash_original_method = "0FA3F000A20BF5722D4983CAD4B48A6A", hash_generated_method = "352A35DD05B12E74B01CFE068368B9CF")
    public  BitmapDrawable(Resources res, Bitmap bitmap) {
        this(new BitmapState(bitmap), res);
        mBitmapState.mTargetDensity = mTargetDensity;
        addTaint(res.getTaint());
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.631 -0400", hash_original_method = "88A1392443C2003D9FA4C6DECF6A14A3", hash_generated_method = "30E54C125471BFA1B7D1FD0D8E2DCDB5")
    @Deprecated
    public  BitmapDrawable(String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } //End block
        addTaint(filepath.getTaint());
        // ---------- Original Method ----------
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.631 -0400", hash_original_method = "2E50FC990DF5F99ED2B436DB68D65D30", hash_generated_method = "8A804E38E36F91849CE26D5B58FCB3D3")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res, String filepath) {
        this(new BitmapState(BitmapFactory.decodeFile(filepath)), null);
        mBitmapState.mTargetDensity = mTargetDensity;
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        } //End block
        addTaint(res.getTaint());
        addTaint(filepath.getTaint());
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + filepath);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.632 -0400", hash_original_method = "5474E95C495E2BDEA7848B2F1051B5AB", hash_generated_method = "D9B3C82B474BF728AF9814631A5804FA")
    @Deprecated
    public  BitmapDrawable(java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } //End block
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.633 -0400", hash_original_method = "A95CEE47ED6D08FEFE672AAA66725922", hash_generated_method = "03E43325C4D24EEC89BE9F70F8547966")
    @SuppressWarnings({"UnusedParameters"})
    public  BitmapDrawable(Resources res, java.io.InputStream is) {
        this(new BitmapState(BitmapFactory.decodeStream(is)), null);
        mBitmapState.mTargetDensity = mTargetDensity;
        {
            android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        } //End block
        addTaint(res.getTaint());
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        //mBitmapState.mTargetDensity = mTargetDensity;
        //if (mBitmap == null) {
            //android.util.Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + is);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.633 -0400", hash_original_method = "FB19047A342C9589C667FFAF2B0ECEA1", hash_generated_method = "5A71E2C55A647198EC58100C490645BB")
    private  BitmapDrawable(BitmapState state, Resources res) {
        mBitmapState = state;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.634 -0400", hash_original_method = "29B9C66D2E3FF8CE986D27E62D842E86", hash_generated_method = "38A6CB060BB1EA5FBB073FAD1BDD38A2")
    public final Paint getPaint() {
        Paint varB4EAC82CA7396A68D541C85D26508E83_1081057072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1081057072 = mBitmapState.mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_1081057072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1081057072;
        // ---------- Original Method ----------
        //return mBitmapState.mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.635 -0400", hash_original_method = "CDEEA354B6732B0C95C918F7ECA77F64", hash_generated_method = "4215E46115395918B9027A7CDD2BF736")
    public final Bitmap getBitmap() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1557935651 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1557935651 = mBitmap;
        varB4EAC82CA7396A68D541C85D26508E83_1557935651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557935651;
        // ---------- Original Method ----------
        //return mBitmap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.635 -0400", hash_original_method = "BD13D47BACD5F22B3F18803E2B331415", hash_generated_method = "5BD547052F6BE282E7B4F0BFF461A99A")
    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
        // ---------- Original Method ----------
        //mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        //mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.636 -0400", hash_original_method = "5A8B316E5E7A06983942607FAB994128", hash_generated_method = "3D15F63945BF8C529D5658A88C1876D3")
    private void setBitmap(Bitmap bitmap) {
        {
            mBitmap = bitmap;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.636 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "215297D0233ECB14FB787AB40CF9D26A")
    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.636 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "960E9F99A08076327B89289C4AB924D5")
    public void setTargetDensity(DisplayMetrics metrics) {
        setTargetDensity(metrics.densityDpi);
        addTaint(metrics.getTaint());
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.637 -0400", hash_original_method = "A17595DAE1AE36756FF8FF6EEBB23DC0", hash_generated_method = "8C366F309112F1BCDA5DD664A2779B9E")
    public void setTargetDensity(int density) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.637 -0400", hash_original_method = "35E95FC787F9F24A49C5DE1ED0297F4C", hash_generated_method = "9C0D41A128E10BD5222F76FE8AD70726")
    public int getGravity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970974660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970974660;
        // ---------- Original Method ----------
        //return mBitmapState.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.637 -0400", hash_original_method = "4FFB5FF85BF6BE29F34E4951AEB6D83F", hash_generated_method = "3CAEEEC77D7426A98428C5206B4E1401")
    public void setGravity(int gravity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.638 -0400", hash_original_method = "A6A7F02FCC6854A1D6F789226FBA84D5", hash_generated_method = "81A4AF1F70FE3D4B394141CE13B0BCA2")
    public void setAntiAlias(boolean aa) {
        mBitmapState.mPaint.setAntiAlias(aa);
        invalidateSelf();
        addTaint(aa);
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setAntiAlias(aa);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.638 -0400", hash_original_method = "79F41E9E1F5486CC4586236A9EB22FE0", hash_generated_method = "D6BED982ED733C2E8810C51F7335D890")
    @Override
    public void setFilterBitmap(boolean filter) {
        mBitmapState.mPaint.setFilterBitmap(filter);
        invalidateSelf();
        addTaint(filter);
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.638 -0400", hash_original_method = "FC203784F21362ACF19CD453633052FE", hash_generated_method = "68B5455275844A5A62B96E778723FA20")
    @Override
    public void setDither(boolean dither) {
        mBitmapState.mPaint.setDither(dither);
        invalidateSelf();
        addTaint(dither);
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.639 -0400", hash_original_method = "8C03C626370DF89EB681D1D91A4CB25A", hash_generated_method = "01ED8EB43CB092BB4CE5DBC7C60C61AF")
    public Shader.TileMode getTileModeX() {
        Shader.TileMode varB4EAC82CA7396A68D541C85D26508E83_497050970 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_497050970 = mBitmapState.mTileModeX;
        varB4EAC82CA7396A68D541C85D26508E83_497050970.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_497050970;
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.640 -0400", hash_original_method = "C4F6E36EB6EDDD2C280548D4CD537229", hash_generated_method = "316314DF16B2A3C1E69C64A04B9876CF")
    public Shader.TileMode getTileModeY() {
        Shader.TileMode varB4EAC82CA7396A68D541C85D26508E83_1215831096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1215831096 = mBitmapState.mTileModeY;
        varB4EAC82CA7396A68D541C85D26508E83_1215831096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1215831096;
        // ---------- Original Method ----------
        //return mBitmapState.mTileModeY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.640 -0400", hash_original_method = "856CFED7038AD7D83A692D422DD3B90C", hash_generated_method = "ACF585952D9FB3F7A0DED05140FDAF03")
    public void setTileModeX(Shader.TileMode mode) {
        setTileModeXY(mode, mBitmapState.mTileModeY);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //setTileModeXY(mode, mBitmapState.mTileModeY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.640 -0400", hash_original_method = "445DE87A20C6F0A91872714D31B4C1C9", hash_generated_method = "38EC405E55776A7DB9B271E4E96FA040")
    public final void setTileModeY(Shader.TileMode mode) {
        setTileModeXY(mBitmapState.mTileModeX, mode);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //setTileModeXY(mBitmapState.mTileModeX, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.641 -0400", hash_original_method = "ADEC19A1E439C619635E588D2B7F4415", hash_generated_method = "9FA377191A1FBD9A70EAB4200F3A9E9A")
    public void setTileModeXY(Shader.TileMode xmode, Shader.TileMode ymode) {
        final BitmapState state = mBitmapState;
        {
            state.mTileModeX = xmode;
            state.mTileModeY = ymode;
            state.mRebuildShader = true;
            invalidateSelf();
        } //End block
        addTaint(xmode.getTaint());
        addTaint(ymode.getTaint());
        // ---------- Original Method ----------
        //final BitmapState state = mBitmapState;
        //if (state.mTileModeX != xmode || state.mTileModeY != ymode) {
            //state.mTileModeX = xmode;
            //state.mTileModeY = ymode;
            //state.mRebuildShader = true;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.641 -0400", hash_original_method = "10D38B42FB036E8B57E4A209AB7F4ADC", hash_generated_method = "E5199E9A1AFB213F8A164ACBCE0D7B37")
    @Override
    public int getChangingConfigurations() {
        int varA770F81D96E9B1930F8D483FADA8C11B_1517318357 = (super.getChangingConfigurations() | mBitmapState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883008475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883008475;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.642 -0400", hash_original_method = "43A5F38374D847F9AEDDDDB09459070C", hash_generated_method = "12B17D68BAA243EB8ED4328C71FF3668")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onBoundsChange(bounds);
        mApplyGravity = true;
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //mApplyGravity = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.643 -0400", hash_original_method = "6FA1B7BCBB056D9C6C12415C137DE76D", hash_generated_method = "6C5B4646853D1BE13587D5D5A398F3BE")
    @Override
    public void draw(Canvas canvas) {
        Bitmap bitmap = mBitmap;
        {
            final BitmapState state = mBitmapState;
            {
                Shader.TileMode tmx = state.mTileModeX;
                Shader.TileMode tmy = state.mTileModeY;
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
            Shader shader = state.mPaint.getShader();
            {
                {
                    final int layoutDirection = getResolvedLayoutDirectionSelf();
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.643 -0400", hash_original_method = "49CE66D09454E056E2AD494EF2DD30A3", hash_generated_method = "3359F78221035F18E875E5B8192FAC30")
    @Override
    public void setAlpha(int alpha) {
        int oldAlpha = mBitmapState.mPaint.getAlpha();
        {
            mBitmapState.mPaint.setAlpha(alpha);
            invalidateSelf();
        } //End block
        addTaint(alpha);
        // ---------- Original Method ----------
        //int oldAlpha = mBitmapState.mPaint.getAlpha();
        //if (alpha != oldAlpha) {
            //mBitmapState.mPaint.setAlpha(alpha);
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.644 -0400", hash_original_method = "F79C881D02962F781494A97AA0D9D98A", hash_generated_method = "23DB2309CF739B20EBAA9053A7ECAD06")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mBitmapState.mPaint.setColorFilter(cf);
        invalidateSelf();
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //mBitmapState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.646 -0400", hash_original_method = "12F43AAD192527EE14BD9EA92E6F05B8", hash_generated_method = "042B2095CDA5D5294F73D0CCA49A51EF")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_492082158 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_392862855 = (!mMutated && super.mutate() == this);
            {
                mBitmapState = new BitmapState(mBitmapState);
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_492082158 = this;
        varB4EAC82CA7396A68D541C85D26508E83_492082158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492082158;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mBitmapState = new BitmapState(mBitmapState);
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.647 -0400", hash_original_method = "C7B53A4BB10177C8F005B36E9252EFF2", hash_generated_method = "C1646E2468DD424947A7800A42DCAE4A")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.BitmapDrawable);
        final int id = a.getResourceId(com.android.internal.R.styleable.BitmapDrawable_src, 0);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
        final Bitmap bitmap = BitmapFactory.decodeResource(r, id);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <bitmap> requires a valid src attribute");
        } //End block
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.647 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "7AD8A31E1AD399EA8D18F0022637E7DE")
    @Override
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288447591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288447591;
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.648 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "C01A53378840DAC6AAD643847732282D")
    @Override
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767914015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767914015;
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.648 -0400", hash_original_method = "9571905A182C10BB0B86009E34DE8EF4", hash_generated_method = "E37E225F19FD4FD77BACEB1093FCB4D8")
    @Override
    public int getOpacity() {
        Bitmap bm = mBitmap;
        {
            boolean var65AA1139D89603A7B5D75450BE5BC76F_187995058 = ((bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667456994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667456994;
        // ---------- Original Method ----------
        //if (mBitmapState.mGravity != Gravity.FILL) {
            //return PixelFormat.TRANSLUCENT;
        //}
        //Bitmap bm = mBitmap;
        //return (bm == null || bm.hasAlpha() || mBitmapState.mPaint.getAlpha() < 255) ?
                //PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_method = "B22D07CBAAEE149FB3D11CBEDB83599B", hash_generated_method = "40B5CAD7D54696A113792DCF39D4246F")
    @Override
    public final ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_2029986899 = null; //Variable for return #1
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_2029986899 = mBitmapState;
        varB4EAC82CA7396A68D541C85D26508E83_2029986899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029986899;
        // ---------- Original Method ----------
        //mBitmapState.mChangingConfigurations = getChangingConfigurations();
        //return mBitmapState;
    }

    
    final static class BitmapState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "46C0A7FFF0FFB93D952536F8E8BA5C29")

        Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "DDCDC839DADEAD04333ED644B12D7DB9", hash_generated_field = "02974118B7DB2EBC67C99A80C329EC2D")

        int mGravity = Gravity.FILL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "BD957D3BC7CA3492655F65B4E470959F", hash_generated_field = "F847D1003F51642BF2CF19539CE8548D")

        Paint mPaint = new Paint(DEFAULT_PAINT_FLAGS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "AE4E5625D3BC87E574124C0D35AA33F0", hash_generated_field = "6E9BEEFA8B8AEF79DD5E5F09806F1C57")

        Shader.TileMode mTileModeX = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.649 -0400", hash_original_field = "175572BE9589677CFF38C357404E53D9", hash_generated_field = "4B2749A46C2F0D56B391EF4A168B3C38")

        Shader.TileMode mTileModeY = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.650 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.650 -0400", hash_original_field = "C95B286C20384507638FDBDA61303A46", hash_generated_field = "6C534FAF0245C3B32617A5CE28BF5D41")

        boolean mRebuildShader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.650 -0400", hash_original_method = "80003A9E2431B1DF8C6F7DBC005B3BC9", hash_generated_method = "A9BB708F42AA8B8426AFD5B8BA3AC518")
          BitmapState(Bitmap bitmap) {
            mBitmap = bitmap;
            // ---------- Original Method ----------
            //mBitmap = bitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.650 -0400", hash_original_method = "C0031760E3673EAB51AB6808BBA62477", hash_generated_method = "2C0F2E0534D8B72198A0A519439014E3")
          BitmapState(BitmapState bitmapState) {
            this(bitmapState.mBitmap);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.651 -0400", hash_original_method = "7A0D3C52124D4E31E0F3E052BCC0F262", hash_generated_method = "2F6AD802E38E5DEB9E53FAF5103FAB37")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_701296489 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_701296489 = new BitmapDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_701296489.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_701296489;
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.652 -0400", hash_original_method = "E262501023FDB9346524FFA189B84EDB", hash_generated_method = "C03D6FF6C99340902D791F9ED55F3996")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_2100014171 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2100014171 = new BitmapDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2100014171.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2100014171;
            // ---------- Original Method ----------
            //return new BitmapDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.652 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "6696C5AF04F5D58C42DA9EC2D09F5102")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181092553 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181092553;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.652 -0400", hash_original_field = "363F36F250F2419DDB43875B36ED4309", hash_generated_field = "88A3BEB3155DA79AE994754DCF9B8910")

    private static final int DEFAULT_PAINT_FLAGS = Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG;
}

