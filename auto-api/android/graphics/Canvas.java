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
import javax.microedition.khronos.opengles.GL;

public class Canvas {
    int mNativeCanvas;
    private Bitmap  mBitmap;
    private DrawFilter mDrawFilter;
    protected int mDensity = Bitmap.DENSITY_NONE;
    protected int mScreenDensity = Bitmap.DENSITY_NONE;
    @SuppressWarnings({"UnusedDeclaration"}) private int         mSurfaceFormat;
    @SuppressWarnings({"UnusedDeclaration"}) private CanvasFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.164 -0400", hash_original_method = "1267A44EC7BCBF8838C9761711C37259", hash_generated_method = "63552CAA2E9C15316003F51321B1A087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas() {
        mNativeCanvas = initRaster(0);
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        // ---------- Original Method ----------
        //mNativeCanvas = initRaster(0);
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.164 -0400", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "2CD945089B13E2BBE6B5FF38F6F3EC3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        {
            boolean var6BA398A25C0007F3F9E60F39C57A8340_208697088 = (!bitmap.isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Immutable bitmap passed to Canvas constructor");
            } //End block
        } //End collapsed parenthetic
        throwIfRecycled(bitmap);
        mNativeCanvas = initRaster(bitmap.ni());
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        mDensity = bitmap.mDensity;
        // ---------- Original Method ----------
        //if (!bitmap.isMutable()) {
            //throw new IllegalStateException(
                            //"Immutable bitmap passed to Canvas constructor");
        //}
        //throwIfRecycled(bitmap);
        //mNativeCanvas = initRaster(bitmap.ni());
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
        //mBitmap = bitmap;
        //mDensity = bitmap.mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.165 -0400", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "725DEC18751DD44E8D1C2FE7594B97B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Canvas(int nativeCanvas) {
        dsTaint.addTaint(nativeCanvas);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        mFinalizer = new CanvasFinalizer(nativeCanvas);
        mDensity = Bitmap.getDefaultDensity();
        // ---------- Original Method ----------
        //if (nativeCanvas == 0) {
            //throw new IllegalStateException();
        //}
        //mNativeCanvas = nativeCanvas;
        //mFinalizer = new CanvasFinalizer(nativeCanvas);
        //mDensity = Bitmap.getDefaultDensity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.166 -0400", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "72CFC63A543E0B83624A41F8C99807EE")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected GL getGL() {
        return (GL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.166 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "EF454A3D30295DF562C30F8D8DB85848")
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.167 -0400", hash_original_method = "F6F982BDFE8AA5C0E01EE9F2D9165328", hash_generated_method = "9B25339BE9C5F54E5B7EE852027E4D69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBitmap(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_1685570410 = (isHardwareAccelerated());
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Can't set a bitmap device on a GL canvas");
            } //End block
        } //End collapsed parenthetic
        int pointer;
        pointer = 0;
        {
            {
                boolean varF12BF886E543DD07B8FC1D7A55B10614_358581979 = (!bitmap.isMutable());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End collapsed parenthetic
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            pointer = bitmap.ni();
        } //End block
        native_setBitmap(mNativeCanvas, pointer);
        // ---------- Original Method ----------
        //if (isHardwareAccelerated()) {
            //throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        //}
        //int pointer = 0;
        //if (bitmap != null) {
            //if (!bitmap.isMutable()) {
                //throw new IllegalStateException();
            //}
            //throwIfRecycled(bitmap);
            //mDensity = bitmap.mDensity;
            //pointer = bitmap.ni();
        //}
        //native_setBitmap(mNativeCanvas, pointer);
        //mBitmap = bitmap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.168 -0400", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "31A7B9CBE23356D379D679B2D878F261")
    @DSModeled(DSC.SAFE)
    public void setViewport(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.168 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "85D01AAC2BE5DE26630731B8B3847BEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.169 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "DF8B748F0B24EE0E7526D789A40020BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.169 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "74072A037789FBB3D4EA8BB8DEA4D056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.169 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "F9A8778C3CF83A7A00D23BEF3B0CD3EE")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.169 -0400", hash_original_method = "67C9034FA61967648F2458A8FB5F781D", hash_generated_method = "2E9B95A687CB815701436D2E1A5C0991")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDensity(int density) {
        dsTaint.addTaint(density);
        {
            mBitmap.setDensity(density);
        } //End block
        // ---------- Original Method ----------
        //if (mBitmap != null) {
            //mBitmap.setDensity(density);
        //}
        //mDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.169 -0400", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "BB8BC9FC9D1AB7F51A42614550145858")
    @DSModeled(DSC.SAFE)
    public void setScreenDensity(int density) {
        dsTaint.addTaint(density);
        // ---------- Original Method ----------
        //mScreenDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.170 -0400", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "BEF030E4068140D23356566330198A58")
    @DSModeled(DSC.SAFE)
    public int getMaximumBitmapWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.170 -0400", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "7ABC6B723CC9EA89118B4541A3BBD959")
    @DSModeled(DSC.SAFE)
    public int getMaximumBitmapHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.170 -0400", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "1B38ED623182189DE604DA79B7071909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int save() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.170 -0400", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "359119A6BF666647D58A8FA5688F63D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int save(int saveFlags) {
        dsTaint.addTaint(saveFlags);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.171 -0400", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "547FCF266CD234D61FC6A0DC9A6DD9EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        int varA5CBFDE30BD9450F18C791C44EFCC5C7_40308971 = (native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, bounds,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.171 -0400", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "78EEDDC13C62AA44D1CCB9147570B325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        int var2F61FD39EB631471B29C425EFBBF4F51_1697060158 = (native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.171 -0400", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "0F632EC59ABBEE66C1E01B1D7657533D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(alpha);
        alpha = Math.min(255, Math.max(0, alpha));
        int varB81B6263C9EA4136F5F2163CAACF155C_2008399679 = (native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //alpha = Math.min(255, Math.max(0, alpha));
        //return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.171 -0400", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "04537C6FBB30EDE2A8558749822BD15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        int varAB13D3D6A85F702363B4C10CC58EB5DE_1289216806 = (native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     //alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.172 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "17FCF523146E8D711A132189A0FA7A41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.172 -0400", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "93BD960386FEBB94D2770E3208C4BD40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSaveCount() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.172 -0400", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "E4B03A2F1FA24A2CFAE8EAFDF5ED6D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreToCount(int saveCount) {
        dsTaint.addTaint(saveCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.172 -0400", hash_original_method = "D7EAFB33E67C35A487FB9FDA7236DB5C", hash_generated_method = "08730296081D71C557685AFD38A7A023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.172 -0400", hash_original_method = "914C0B0C62A552CD356908505BF7E530", hash_generated_method = "77CE8F7921739D7F18CA011E7D8A6CF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.173 -0400", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "EE7E20A140C44B1EB2BC98C74610389E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scale(float sx, float sy, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        translate(px, py);
        scale(sx, sy);
        translate(-px, -py);
        // ---------- Original Method ----------
        //translate(px, py);
        //scale(sx, sy);
        //translate(-px, -py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.173 -0400", hash_original_method = "3293BC510D2403D70370080BC137D04A", hash_generated_method = "02861443FDCB8D44FB3418D3A8E4787B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotate(float degrees) {
        dsTaint.addTaint(degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.173 -0400", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "FDEC53E0D53C8DB4D76B1A4196E4F761")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void rotate(float degrees, float px, float py) {
        dsTaint.addTaint(px);
        dsTaint.addTaint(py);
        dsTaint.addTaint(degrees);
        translate(px, py);
        rotate(degrees);
        translate(-px, -py);
        // ---------- Original Method ----------
        //translate(px, py);
        //rotate(degrees);
        //translate(-px, -py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.173 -0400", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "B76BDEA6D9309085A0C03838BA7CDC21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skew(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.174 -0400", hash_original_method = "92F93C7D2AC41CA3F3A5613FB52C686A", hash_generated_method = "CE61BAC4A90C72974D43A7BD1EF4D1D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void concat(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_concat(mNativeCanvas, matrix.native_instance);
        // ---------- Original Method ----------
        //native_concat(mNativeCanvas, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.174 -0400", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "52EC3442666A75437999A75BFFC8EC58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
        // ---------- Original Method ----------
        //native_setMatrix(mNativeCanvas,
                         //matrix == null ? 0 : matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.174 -0400", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "EDCBF00328EC6E40E3660045051B23EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getMatrix(Matrix ctm) {
        dsTaint.addTaint(ctm.dsTaint);
        native_getCTM(mNativeCanvas, ctm.native_instance);
        // ---------- Original Method ----------
        //native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.174 -0400", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "57207C663BA64FC239709E5472B0EB94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Matrix getMatrix() {
        Matrix m;
        m = new Matrix();
        getMatrix(m);
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Matrix m = new Matrix();
        //getMatrix(m);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.175 -0400", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "3A83BE3C1894F089829492FB83128235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(RectF rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_371232077 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.175 -0400", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "1B482E78B384EC2617F45C8810C6A66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(Rect rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_1523927852 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.175 -0400", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "4D40B977CBB0ECD44BD81338993AA0A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.175 -0400", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "FE1117990888C0C331B32003309BEBDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.176 -0400", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "34208BA2E937F50C87CCF297B1B74DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varEE9DF9D2FD21703C87AA172F004D9785_241730698 = (native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.176 -0400", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "4DF2D0F3E7D99D5FD5F9F1059F8C57C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(float left, float top,
                                   float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.176 -0400", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "7088D8DB50DAE348CF09AF2C36A7B6CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(int left, int top,
                                   int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.176 -0400", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "853205E271E38BCA9D3AE3089E7068BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipPath(Path path, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(path.dsTaint);
        boolean var3967E0369498EDA77CDA505C721131EC_1896328177 = (native_clipPath(mNativeCanvas, path.ni(), op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.177 -0400", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "B722F28C3DE3A592C3D8D23B867E2E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipPath(Path path) {
        dsTaint.addTaint(path.dsTaint);
        boolean var5668FEC2CC06DA8D3911368F8A48CE68_108204398 = (clipPath(path, Region.Op.INTERSECT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return clipPath(path, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.177 -0400", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "918032048F9548B96B7ACE4A8F1242A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRegion(Region region, Region.Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        boolean var670725A52E9FB351AE9F8E165F40703A_1400301625 = (native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.177 -0400", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "8B024E6A037F7720ABE811B3B5BE2814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean varEC420F7490712C49934D9178B28B2A4A_1280373585 = (clipRegion(region, Region.Op.INTERSECT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return clipRegion(region, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.177 -0400", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "249DE54F7528E83A075E07CD21A77F69")
    @DSModeled(DSC.SAFE)
    public DrawFilter getDrawFilter() {
        return (DrawFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDrawFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.177 -0400", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "DBD681F06827A650CC0D85FD72FB2B91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDrawFilter(DrawFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        int nativeFilter;
        nativeFilter = 0;
        {
            nativeFilter = filter.mNativeInt;
        } //End block
        nativeSetDrawFilter(mNativeCanvas, nativeFilter);
        // ---------- Original Method ----------
        //int nativeFilter = 0;
        //if (filter != null) {
            //nativeFilter = filter.mNativeInt;
        //}
        //mDrawFilter = filter;
        //nativeSetDrawFilter(mNativeCanvas, nativeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.178 -0400", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "49D0C8CCE448D137D67594330C26DDEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(RectF rect, EdgeType type) {
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean var429A74CF4AF210076B3239D74D69786D_490748722 = (native_quickReject(mNativeCanvas, rect, type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.178 -0400", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "89B7807A675195ADA1AB01152723049A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Path path, EdgeType type) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        boolean varB3A55B701382D522818E598BFA909059_1299157112 = (native_quickReject(mNativeCanvas, path.ni(), type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.178 -0400", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "EBB560E898B40BF7F6DB505970C108C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varDB574CFEBFF126B7D24F9B2C2E4668CF_1338058346 = (native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  //type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.179 -0400", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "FCF4A6C3AB2D977D90F23E32D5C6644A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getClipBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        boolean var817922B6BDA738AD08E140FF68D83598_1195612306 = (native_getClipBounds(mNativeCanvas, bounds));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_getClipBounds(mNativeCanvas, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.179 -0400", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "0590B396043FB534AA3808FB491D1E9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Rect getClipBounds() {
        Rect r;
        r = new Rect();
        getClipBounds(r);
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //getClipBounds(r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.179 -0400", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "C10CA4C4CD95C7A32886520B91EE128E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawRGB(int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        native_drawRGB(mNativeCanvas, r, g, b);
        // ---------- Original Method ----------
        //native_drawRGB(mNativeCanvas, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.179 -0400", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "EEB760EC1332C5762D622A9EC0075398")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawARGB(int a, int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(a);
        native_drawARGB(mNativeCanvas, a, r, g, b);
        // ---------- Original Method ----------
        //native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.180 -0400", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "5B321916FE15A200BF379C06C546E6E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawColor(int color) {
        dsTaint.addTaint(color);
        native_drawColor(mNativeCanvas, color);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.180 -0400", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "757CFE8FFEC0C1D24EA3849F11B1ED83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawColor(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.180 -0400", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "ABE53FC7763C99388179103CE5B7DCC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPaint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.180 -0400", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "B47384ABF3A749C50F2644D55D0A9F49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPoints(float[] pts, int offset, int count,
                                  Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.182 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "43C8D56B435F3C1A2077CB71796A3F56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPoints(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        drawPoints(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.182 -0400", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "C83C6DCFC4C491271B94F14CB2606EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPoint(float x, float y, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.182 -0400", hash_original_method = "B6DC8903FDEE452D685FA44296B398E4", hash_generated_method = "7DBC43CB707429C5B3EFFD838F8D1A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLine(float startX, float startY, float stopX, float stopY,
                         Paint paint) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(stopX);
        dsTaint.addTaint(stopY);
        dsTaint.addTaint(paint.dsTaint);
        native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.183 -0400", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "D5D8B76756AB3E5446CC461272F27D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLines(float[] pts, int offset, int count,
                                 Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.183 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "A4C3AFDB806DF6E586610899EA690B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLines(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        drawLines(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.183 -0400", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "1934F566FEF4B6759AF1CF807085576C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawRect(RectF rect, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.183 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "6D5AB8445D54F1A5471ECD6AADB5E2BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawRect(Rect r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.184 -0400", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "1D36755E6F1411365277173D0D5EB17C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawRect(float left, float top, float right, float bottom,
                         Paint paint) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        native_drawRect(mNativeCanvas, left, top, right, bottom,
                        paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, left, top, right, bottom,
                        //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.185 -0400", hash_original_method = "68242662823845D3936295A7CE4E7BEF", hash_generated_method = "73B02A2322AFA6694EEF1171F022A0BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawOval(RectF oval, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.186 -0400", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "24093C8BA24D739736139A93AFD3AF5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(cx);
        native_drawCircle(mNativeCanvas, cx, cy, radius,
                          paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawCircle(mNativeCanvas, cx, cy, radius,
                          //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.187 -0400", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "F9698D2678273E2D82F302A018D265C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(useCenter);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       useCenter, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       //useCenter, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.187 -0400", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "B7B022E1C9B1520C63425541AC70BB1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             paint.mNativePaint);
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException();
        //}
        //native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.188 -0400", hash_original_method = "0771B06A5DB79DCDA48BD1ADBD491833", hash_generated_method = "00622E85EB7BCC200C0B7AD824E66F2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPath(Path path, Paint paint) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
    }

    
        private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.189 -0400", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "F6730D45CCDED749AC79F01C97E9BE7F")
    @DSModeled(DSC.SAFE)
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        dsTaint.addTaint(chunks[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.189 -0400", hash_original_method = "31B292C5F0F5731C1C9071C226236EDA", hash_generated_method = "D36D64D639B51159C277BCB917AC6928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(top);
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                bitmap.mDensity);
        // ---------- Original Method ----------
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                //paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                //bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.190 -0400", hash_original_method = "C948472D99C8DCD49BAB1292EF9A789B", hash_generated_method = "FA71F24C48F29947CB5F02619B0EC79A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.190 -0400", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "E5FF950F1155E98AF098146F0B1DA055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.191 -0400", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "CEA01B31496A795C125AB7E0394BB3B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(int[] colors, int offset, int stride, float x,
                           float y, int width, int height, boolean hasAlpha,
                           Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("width must be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_356250529 = (Math.abs(stride) < width);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("abs(stride) must be >= width");
            } //End block
        } //End collapsed parenthetic
        int lastScanline;
        lastScanline = offset + (height - 1) * stride;
        int length;
        length = colors.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_drawBitmap(mNativeCanvas, colors, offset, stride, x, y, width, height, hasAlpha,
                paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.191 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "D36774DC5CC4D5531CEE987ED36BC41A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
                           int width, int height, boolean hasAlpha,
                           Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   hasAlpha, paint);
        // ---------- Original Method ----------
        //drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   //hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.191 -0400", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "EF05545CE3E59B7552616C7507DBC796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        //nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                //paint != null ? paint.mNativePaint : 0);
    }

    
        protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.192 -0400", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "224EB4B63D27499921176F3077495D1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight,
                               float[] verts, int vertOffset,
                               int[] colors, int colorOffset, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(meshWidth);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(verts[0]);
        dsTaint.addTaint(meshHeight);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vertOffset);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        int count;
        count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);
        {
            checkRange(colors.length, colorOffset, count);
        } //End block
        nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             verts, vertOffset, colors, colorOffset,
                             paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        //if ((meshWidth | meshHeight | vertOffset | colorOffset) < 0) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (meshWidth == 0 || meshHeight == 0) {
            //return;
        //}
        //int count = (meshWidth + 1) * (meshHeight + 1);
        //checkRange(verts.length, vertOffset, count * 2);
        //if (colors != null) {
            //checkRange(colors.length, colorOffset, count);
        //}
        //nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             //verts, vertOffset, colors, colorOffset,
                             //paint != null ? paint.mNativePaint : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.193 -0400", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "565D185E369ED0C01C30444FCA05D31F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawVertices(VertexMode mode, int vertexCount,
                             float[] verts, int vertOffset,
                             float[] texs, int texOffset,
                             int[] colors, int colorOffset,
                             short[] indices, int indexOffset,
                             int indexCount, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(vertexCount);
        dsTaint.addTaint(indexOffset);
        dsTaint.addTaint(texs[0]);
        dsTaint.addTaint(indexCount);
        dsTaint.addTaint(texOffset);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(verts[0]);
        dsTaint.addTaint(indices[0]);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vertOffset);
        dsTaint.addTaint(mode.dsTaint);
        checkRange(verts.length, vertOffset, vertexCount);
        {
            checkRange(texs.length, texOffset, vertexCount);
        } //End block
        {
            checkRange(colors.length, colorOffset, vertexCount / 2);
        } //End block
        {
            checkRange(indices.length, indexOffset, indexCount);
        } //End block
        nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           vertOffset, texs, texOffset, colors, colorOffset,
                          indices, indexOffset, indexCount, paint.mNativePaint);
        // ---------- Original Method ----------
        //checkRange(verts.length, vertOffset, vertexCount);
        //if (texs != null) {
            //checkRange(texs.length, texOffset, vertexCount);
        //}
        //if (colors != null) {
            //checkRange(colors.length, colorOffset, vertexCount / 2);
        //}
        //if (indices != null) {
            //checkRange(indices.length, indexOffset, indexCount);
        //}
        //nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           //vertOffset, texs, texOffset, colors, colorOffset,
                          //indices, indexOffset, indexCount, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.195 -0400", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "2DFA31402AEA82267DB3FD63B1A36ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(char[] text, int index, int count, float x, float y,
                         Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //if ((index | count | (index + count) |
            //(text.length - index - count)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.195 -0400", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "E9440BBFD76EFF892DBE8FFD6155EFBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(String text, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.196 -0400", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "9584FD613C9BA85C13F1823E35F9A77A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(String text, int start, int end, float x, float y,
                         Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        {
            boolean var9527A5CDD965760192A60A252272F336_878731573 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.196 -0400", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "7FA6340076EF9779EB42FE7024CC014A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(CharSequence text, int start, int end, float x,
                         float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        {
            native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            paint.mBidiFlags, paint.mNativePaint);
        } //End block
        {
            ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     paint);
        } //End block
        {
            char[] buf;
            buf = TemporaryBuffer.obtain(end - start);
            TextUtils.getChars(text, start, end, buf, 0);
            native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    paint.mBidiFlags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        //if (text instanceof String || text instanceof SpannedString ||
            //text instanceof SpannableString) {
            //native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            //paint.mBidiFlags, paint.mNativePaint);
        //} else if (text instanceof GraphicsOperations) {
            //((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     //paint);
        //} else {
            //char[] buf = TemporaryBuffer.obtain(end - start);
            //TextUtils.getChars(text, start, end, buf, 0);
            //native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    //paint.mBidiFlags, paint.mNativePaint);
            //TemporaryBuffer.recycle(buf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.197 -0400", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "215941B9307A76AA9B6D844D29C842CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextRun(char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir,
            Paint paint) {
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("paint is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown dir: " + dir);
        } //End block
        native_drawTextRun(mNativeCanvas, text, index, count,
                contextIndex, contextCount, x, y, dir, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new NullPointerException("text is null");
        //}
        //if (paint == null) {
            //throw new NullPointerException("paint is null");
        //}
        //if ((index | count | text.length - index - count) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (dir != DIRECTION_LTR && dir != DIRECTION_RTL) {
            //throw new IllegalArgumentException("unknown dir: " + dir);
        //}
        //native_drawTextRun(mNativeCanvas, text, index, count,
                //contextIndex, contextCount, x, y, dir, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.197 -0400", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "F8CE4EDF3C75DE356288B76E31DF4582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextRun(CharSequence text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int dir,
            Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        dsTaint.addTaint(contextEnd);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("paint is null");
        } //End block
        {
            boolean var5121ADA1DFFE288F77E0A77339FFD85F_676358142 = ((start | end | end - start | text.length() - end) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int flags;
        flags = 0;
        flags = 1;
        {
            native_drawTextRun(mNativeCanvas, text.toString(), start, end,
                    contextStart, contextEnd, x, y, flags, paint.mNativePaint);
        } //End block
        {
            ((GraphicsOperations) text).drawTextRun(this, start, end,
                    contextStart, contextEnd, x, y, flags, paint);
        } //End block
        {
            int contextLen;
            contextLen = contextEnd - contextStart;
            int len;
            len = end - start;
            char[] buf;
            buf = TemporaryBuffer.obtain(contextLen);
            TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
            native_drawTextRun(mNativeCanvas, buf, start - contextStart, len,
                    0, contextLen, x, y, flags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.198 -0400", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "A07C8E66EC1355859A8FCD045B26BBB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        native_drawPosText(mNativeCanvas, text, index, count, pos,
                           paint.mNativePaint);
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length || count*2 > pos.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, index, count, pos,
                           //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.198 -0400", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "C2DC42F990D512B0E81C513692398261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPosText(String text, float[] pos, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        {
            boolean var8252BA30A9512CA9A5F07EEE6666D9DD_1403339396 = (text.length()*2 > pos.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text.length()*2 > pos.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.198 -0400", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "9C869EB3E6C924A84D59FD8F85B91968")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextOnPath(char[] text, int index, int count, Path path,
                               float hOffset, float vOffset, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_drawTextOnPath(mNativeCanvas, text, index, count,
                              path.ni(), hOffset, vOffset,
                              paint.mBidiFlags, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawTextOnPath(mNativeCanvas, text, index, count,
                              //path.ni(), hOffset, vOffset,
                              //paint.mBidiFlags, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.199 -0400", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "EA9C860CB0A4304B1D4CB39F742D3DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextOnPath(String text, Path path, float hOffset,
                               float vOffset, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        {
            boolean varC763452D8A14BA9A46AF46F7BF99B944_309263318 = (text.length() > 0);
            {
                native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  hOffset, vOffset, paint.mBidiFlags,
                                  paint.mNativePaint);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (text.length() > 0) {
            //native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  //hOffset, vOffset, paint.mBidiFlags,
                                  //paint.mNativePaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.199 -0400", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "F90E83DFC36C619DD7B6EE5C155E95AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture) {
        dsTaint.addTaint(picture.dsTaint);
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
        // ---------- Original Method ----------
        //picture.endRecording();
        //native_drawPicture(mNativeCanvas, picture.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.199 -0400", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "55736905AEF6FE9F4FA93D99DF4F1ED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture, RectF dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_1019003659 = (picture.getWidth() > 0 && picture.getHeight() > 0);
            {
                scale(dst.width() / picture.getWidth(),
                  dst.height() / picture.getHeight());
            } //End block
        } //End collapsed parenthetic
        drawPicture(picture);
        restore();
        // ---------- Original Method ----------
        //save();
        //translate(dst.left, dst.top);
        //if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            //scale(dst.width() / picture.getWidth(),
                  //dst.height() / picture.getHeight());
        //}
        //drawPicture(picture);
        //restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.200 -0400", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "FDE789DC6986266CD2C2A2F9FE4AFB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture, Rect dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_401456085 = (picture.getWidth() > 0 && picture.getHeight() > 0);
            {
                scale((float)dst.width() / picture.getWidth(),
                  (float)dst.height() / picture.getHeight());
            } //End block
        } //End collapsed parenthetic
        drawPicture(picture);
        restore();
        // ---------- Original Method ----------
        //save();
        //translate(dst.left, dst.top);
        //if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            //scale((float)dst.width() / picture.getWidth(),
                  //(float)dst.height() / picture.getHeight());
        //}
        //drawPicture(picture);
        //restore();
    }

    
        public static void freeCaches() {
    }

    
        private static int initRaster(int nativeBitmapOrZero) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setBitmap(int nativeCanvas, int bitmap) {
    }

    
        private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_concat(int nCanvas, int nMatrix) {
    }

    
        private static void native_setMatrix(int nCanvas, int nMatrix) {
    }

    
        private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
    }

    
        private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_getCTM(int canvas, int matrix) {
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_drawRGB(int nativeCanvas, int r, int g,
                                              int b) {
    }

    
        private static void native_drawARGB(int nativeCanvas, int a, int r,
                                               int g, int b) {
    }

    
        private static void native_drawColor(int nativeCanvas, int color) {
    }

    
        private static void native_drawColor(int nativeCanvas, int color,
                                                int mode) {
    }

    
        private static void native_drawPaint(int nativeCanvas, int paint) {
    }

    
        private static void native_drawLine(int nativeCanvas, float startX,
                                               float startY, float stopX,
                                               float stopY, int paint) {
    }

    
        private static void native_drawRect(int nativeCanvas, RectF rect,
                                               int paint) {
    }

    
        private static void native_drawRect(int nativeCanvas, float left,
                                               float top, float right,
                                               float bottom, int paint) {
    }

    
        private static void native_drawOval(int nativeCanvas, RectF oval,
                                               int paint) {
    }

    
        private static void native_drawCircle(int nativeCanvas, float cx,
                                                 float cy, float radius,
                                                 int paint) {
    }

    
        private static void native_drawArc(int nativeCanvas, RectF oval,
                                              float startAngle, float sweep,
                                              boolean useCenter, int paint) {
    }

    
        private static void native_drawRoundRect(int nativeCanvas,
                                                    RectF rect, float rx,
                                                    float ry, int paint) {
    }

    
        private static void native_drawPath(int nativeCanvas, int path,
                                               int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.204 -0400", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "35438D25392D2FD9BB64815CA1EA66EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 float left, float top,
                                                 int nativePaintOrZero,
                                                 int canvasDensity,
                                                 int screenDensity,
                                                 int bitmapDensity) {
        dsTaint.addTaint(nativePaintOrZero);
        dsTaint.addTaint(bitmap);
        dsTaint.addTaint(bitmapDensity);
        dsTaint.addTaint(canvasDensity);
        dsTaint.addTaint(left);
        dsTaint.addTaint(nativeCanvas);
        dsTaint.addTaint(screenDensity);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.204 -0400", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "ECD33F28CAE100BC2DDE463A56816051")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, RectF dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
        dsTaint.addTaint(nativePaintOrZero);
        dsTaint.addTaint(bitmap);
        dsTaint.addTaint(bitmapDensity);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(nativeCanvas);
        dsTaint.addTaint(screenDensity);
    }

    
        private static void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, Rect dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
        private static void native_drawBitmap(int nativeCanvas, int[] colors,
                                                int offset, int stride, float x,
                                                 float y, int width, int height,
                                                 boolean hasAlpha,
                                                 int nativePaintOrZero) {
    }

    
        private static void nativeDrawBitmapMatrix(int nCanvas, int nBitmap,
                                                      int nMatrix, int nPaint) {
    }

    
        private static void nativeDrawBitmapMesh(int nCanvas, int nBitmap,
                                                    int meshWidth, int meshHeight,
                                                    float[] verts, int vertOffset,
                                                    int[] colors, int colorOffset, int nPaint) {
    }

    
        private static void nativeDrawVertices(int nCanvas, int mode, int n,
                   float[] verts, int vertOffset, float[] texs, int texOffset,
                   int[] colors, int colorOffset, short[] indices,
                   int indexOffset, int indexCount, int nPaint) {
    }

    
        private static void native_drawText(int nativeCanvas, char[] text,
                                               int index, int count, float x,
                                               float y, int flags, int paint) {
    }

    
        private static void native_drawText(int nativeCanvas, String text,
                                               int start, int end, float x,
                                               float y, int flags, int paint) {
    }

    
        private static void native_drawTextRun(int nativeCanvas, String text,
            int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, int paint) {
    }

    
        private static void native_drawTextRun(int nativeCanvas, char[] text,
            int start, int count, int contextStart, int contextCount,
            float x, float y, int flags, int paint) {
    }

    
        private static void native_drawPosText(int nativeCanvas,
                                                  char[] text, int index,
                                                  int count, float[] pos,
                                                  int paint) {
    }

    
        private static void native_drawPosText(int nativeCanvas,
                                                  String text, float[] pos,
                                                  int paint) {
    }

    
        private static void native_drawTextOnPath(int nativeCanvas,
                                                     char[] text, int index,
                                                     int count, int path,
                                                     float hOffset,
                                                     float vOffset, int bidiFlags,
                                                     int paint) {
    }

    
        private static void native_drawTextOnPath(int nativeCanvas,
                                                     String text, int path,
                                                     float hOffset, 
                                                     float vOffset, 
                                                     int flags, int paint) {
    }

    
        private static void native_drawPicture(int nativeCanvas,
                                                  int nativePicture) {
    }

    
        private static void finalizer(int nativeCanvas) {
    }

    
    private static class CanvasFinalizer {
        private int mNativeCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.207 -0400", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "2EFBA89F957EA7646031B645AA100AFE")
        @DSModeled(DSC.SAFE)
        public CanvasFinalizer(int nativeCanvas) {
            dsTaint.addTaint(nativeCanvas);
            // ---------- Original Method ----------
            //mNativeCanvas = nativeCanvas;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.207 -0400", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "284671E9CCA761E0F6E36393D7646CA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    finalizer(mNativeCanvas);
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (mNativeCanvas != 0) {
                    //finalizer(mNativeCanvas);
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
    public enum EdgeType {
        BW(0),  
        AA(1);  
        EdgeType(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
    public enum VertexMode {
        TRIANGLES(0),
        TRIANGLE_STRIP(1),
        TRIANGLE_FAN(2);
        VertexMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    public static final int MATRIX_SAVE_FLAG = 0x01;
    public static final int CLIP_SAVE_FLAG = 0x02;
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    public static final int ALL_SAVE_FLAG = 0x1F;
}

