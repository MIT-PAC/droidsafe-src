package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import javax.microedition.khronos.opengles.GL;

public class Canvas {
    final int mNativeCanvas;
    private Bitmap  mBitmap;
    private DrawFilter mDrawFilter;
    protected int mDensity = Bitmap.DENSITY_NONE;
    protected int mScreenDensity = Bitmap.DENSITY_NONE;
    @SuppressWarnings({"UnusedDeclaration"})
    private int         mSurfaceFormat;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    @SuppressWarnings({"UnusedDeclaration"})
    private final CanvasFinalizer mFinalizer;
    public static final int MATRIX_SAVE_FLAG = 0x01;
    public static final int CLIP_SAVE_FLAG = 0x02;
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    public static final int ALL_SAVE_FLAG = 0x1F;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.987 -0400", hash_original_method = "1267A44EC7BCBF8838C9761711C37259", hash_generated_method = "F23A02FAAF13C3839BED9D19B43BF325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas() {
        mNativeCanvas = initRaster(0);
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        // ---------- Original Method ----------
        //mNativeCanvas = initRaster(0);
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "A9F0CF71D2326F372461300A3D767A86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        {
            boolean var6BA398A25C0007F3F9E60F39C57A8340_1922029799 = (!bitmap.isMutable());
            {
                throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "0125894D7DA043B80947DBCCCF7992D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Canvas(int nativeCanvas) {
        dsTaint.addTaint(nativeCanvas);
        {
            throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "F7C7D25A19AA72375ED496EEE413BEBB")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected GL getGL() {
        return (GL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "C9004BC47678C06851981C6431709EC5")
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "F6F982BDFE8AA5C0E01EE9F2D9165328", hash_generated_method = "05AE1F1EA19E54BED742089926BB4815")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBitmap(Bitmap bitmap) {
        dsTaint.addTaint(bitmap.dsTaint);
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_1583410965 = (isHardwareAccelerated());
            {
                throw new RuntimeException("Can't set a bitmap device on a GL canvas");
            } //End block
        } //End collapsed parenthetic
        int pointer;
        pointer = 0;
        {
            {
                boolean varF12BF886E543DD07B8FC1D7A55B10614_711587668 = (!bitmap.isMutable());
                {
                    throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "0783D70DEAE4131502A0BC9339586EF0")
    @DSModeled(DSC.SAFE)
    public void setViewport(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.988 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "B5E14EAC8468AB1C1A41FC932088673B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpaque() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "8202ACDF7C5D29ED74BE3232863D1E31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "CFD12F7A9648C1DBAD827DBA35D4B80A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "51432277FCC7B4EB235DC0C983B8AFA3")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "67C9034FA61967648F2458A8FB5F781D", hash_generated_method = "F8DA9D1A6B599387896B7A724FA31F5B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "6483AC7099626D407F19AEDE62EB5287")
    @DSModeled(DSC.SAFE)
    public void setScreenDensity(int density) {
        dsTaint.addTaint(density);
        // ---------- Original Method ----------
        //mScreenDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "58BDC0573195999CE86E3EB48D0616AE")
    @DSModeled(DSC.SAFE)
    public int getMaximumBitmapWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "B6D9D07B07195FFE0B32F464B6ADA56F")
    @DSModeled(DSC.SAFE)
    public int getMaximumBitmapHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "13A27F48261C03D96F0EAE5AAC855FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int save() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.989 -0400", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "EC745A2AE90786C6060CB33DE57BD954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int save(int saveFlags) {
        dsTaint.addTaint(saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "BBD8ED7A7B4E197CA65B17E33869140D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(paint.dsTaint);
        int varA5CBFDE30BD9450F18C791C44EFCC5C7_1268665104 = (native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, bounds,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "04A87401F2B33BD21C3E14AE486A3083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        int var2F61FD39EB631471B29C425EFBBF4F51_539750382 = (native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "DADC5FC06424D8A249805DC991A04312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(alpha);
        alpha = Math.min(255, Math.max(0, alpha));
        int varB81B6263C9EA4136F5F2163CAACF155C_1621232153 = (native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //alpha = Math.min(255, Math.max(0, alpha));
        //return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "04D2338DE4DB2D550C1E72EC57DF19BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        int varAB13D3D6A85F702363B4C10CC58EB5DE_519961664 = (native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     //alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "EB44B5F60968B7E1DB698EC75965A0FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "5B1F4BC4D592CE89717BC8FE42AB0129")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSaveCount() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.990 -0400", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "3F4BBD395B8A0BBDF944EBDA55BBF46D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreToCount(int saveCount) {
        dsTaint.addTaint(saveCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "D7EAFB33E67C35A487FB9FDA7236DB5C", hash_generated_method = "A7C03F60E710BA0F25F35149515ED144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void translate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "914C0B0C62A552CD356908505BF7E530", hash_generated_method = "4160FBC111E13971511C62FB0AE7B53D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "3CF5D75837855368C1491DA72AAC5877")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "3293BC510D2403D70370080BC137D04A", hash_generated_method = "DC0A68820015C27F4780A19333FBBF42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rotate(float degrees) {
        dsTaint.addTaint(degrees);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "C09D6605E3F7E27C0E309D8810450F82")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "9A32963251C8E24534E6C462A7245167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skew(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "92F93C7D2AC41CA3F3A5613FB52C686A", hash_generated_method = "210ED566FE722845DA03E8209086A99C")
    @DSModeled(DSC.SAFE)
    public void concat(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_concat(mNativeCanvas, matrix.native_instance);
        // ---------- Original Method ----------
        //native_concat(mNativeCanvas, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "6F7ED13C43CFDDDC52175F2A2E62086C")
    @DSModeled(DSC.SAFE)
    public void setMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
        // ---------- Original Method ----------
        //native_setMatrix(mNativeCanvas,
                         //matrix == null ? 0 : matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.991 -0400", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "1B882380F1C2632DA6854399A755D8B3")
    @DSModeled(DSC.SAFE)
    public void getMatrix(Matrix ctm) {
        dsTaint.addTaint(ctm.dsTaint);
        native_getCTM(mNativeCanvas, ctm.native_instance);
        // ---------- Original Method ----------
        //native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "4371AE0B60C62FD25B0D0DCB7534D89D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "7FFCC89F7BB6AE0841C46BCE88A5A9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(RectF rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_808387467 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "6E9D4B3F91ABE860174AF8A0BD8B501B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(Rect rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_1515352701 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "317A96047C9426C71C8530A0253BADF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "DBFBEFC538B8C3C32CFFB0A6ECC63979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "C0250FC724DC4E11BADB095C3B4CE535")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varEE9DF9D2FD21703C87AA172F004D9785_1606763624 = (native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "4745EBC0FB1D396A12F088D8B0B5D796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(float left, float top,
                                   float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.992 -0400", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "62C1822D246B14FF7FC6B5EEA2F8CA63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRect(int left, int top,
                                   int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "0CBDD1A61EDB86A29061E692684825F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipPath(Path path, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(path.dsTaint);
        boolean var3967E0369498EDA77CDA505C721131EC_1171685235 = (native_clipPath(mNativeCanvas, path.ni(), op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "DBED59A3417D264FAB12FBF4D470F4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipPath(Path path) {
        dsTaint.addTaint(path.dsTaint);
        boolean var5668FEC2CC06DA8D3911368F8A48CE68_949243951 = (clipPath(path, Region.Op.INTERSECT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return clipPath(path, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "4F287A4D39C64171093E17A43FE4A916")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRegion(Region region, Region.Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        boolean var670725A52E9FB351AE9F8E165F40703A_383244027 = (native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "AEE65F080ED4664A8DDE2A7F9F5CB719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clipRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean varEC420F7490712C49934D9178B28B2A4A_954395352 = (clipRegion(region, Region.Op.INTERSECT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return clipRegion(region, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "51CDD779C610F3ACA0E8427EE42233CB")
    @DSModeled(DSC.SAFE)
    public DrawFilter getDrawFilter() {
        return (DrawFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDrawFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "8972E35323DBA0F558928417E56EA5BA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "B5C98FC0359EF33784E44034EEE48800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(RectF rect, EdgeType type) {
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        boolean var429A74CF4AF210076B3239D74D69786D_1066233893 = (native_quickReject(mNativeCanvas, rect, type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.993 -0400", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "508C3E554F0DC50C042ED574FB9303EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(Path path, EdgeType type) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        boolean varB3A55B701382D522818E598BFA909059_127823959 = (native_quickReject(mNativeCanvas, path.ni(), type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "6A1158F0D94442142497112F77790556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varDB574CFEBFF126B7D24F9B2C2E4668CF_1582629759 = (native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  //type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "9D636BBEA1B524BF90FBF9E70939F19D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getClipBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        boolean var817922B6BDA738AD08E140FF68D83598_1401174468 = (native_getClipBounds(mNativeCanvas, bounds));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_getClipBounds(mNativeCanvas, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "D72742AFBA40434BE999D39DA582FE9B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "BCA76817FD551629645C284D9256D997")
    @DSModeled(DSC.SAFE)
    public void drawRGB(int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        native_drawRGB(mNativeCanvas, r, g, b);
        // ---------- Original Method ----------
        //native_drawRGB(mNativeCanvas, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "18D3D4C4D41701C42C98892F0CFC46FB")
    @DSModeled(DSC.SAFE)
    public void drawARGB(int a, int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(a);
        native_drawARGB(mNativeCanvas, a, r, g, b);
        // ---------- Original Method ----------
        //native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "48245C666CF25C5D2A3A59476AB1828C")
    @DSModeled(DSC.SAFE)
    public void drawColor(int color) {
        dsTaint.addTaint(color);
        native_drawColor(mNativeCanvas, color);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "FE906DF42567AF697EA7EBD4925E97B2")
    @DSModeled(DSC.SAFE)
    public void drawColor(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.994 -0400", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "05CA29BC9E3A8A5D1E2585C8B0513C3E")
    @DSModeled(DSC.SAFE)
    public void drawPaint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "485BE4B4F9BF5DF52C1EB42679DDF581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPoints(float[] pts, int offset, int count,
                                  Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "C5343F981B41607D95064EBFB0A9529A")
    @DSModeled(DSC.SAFE)
    public void drawPoints(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts);
        drawPoints(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "C6FB27512BD3184FEDDF896C22FB9CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPoint(float x, float y, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "B6DC8903FDEE452D685FA44296B398E4", hash_generated_method = "6EEC6F6E613590C3329ABEA7F60C6460")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "F60DB16C336EBA079FAA057093356583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawLines(float[] pts, int offset, int count,
                                 Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "AEFF1359160935D499E5A96E9228B391")
    @DSModeled(DSC.SAFE)
    public void drawLines(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts);
        drawLines(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "92CAF62733D332BBD1E0FC952FA30007")
    @DSModeled(DSC.SAFE)
    public void drawRect(RectF rect, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.995 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "E764D9564ECEFAA46ABFE846FE6200DF")
    @DSModeled(DSC.SAFE)
    public void drawRect(Rect r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "40C648623D5FC2ACE509070F7FA79A6D")
    @DSModeled(DSC.SAFE)
    public void drawRect(float left, float top, float right, float bottom,
                         Paint paint) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        native_drawRect(mNativeCanvas, left, top, right, bottom,
                        paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, left, top, right, bottom,
                        //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "68242662823845D3936295A7CE4E7BEF", hash_generated_method = "A97CF56E577E10195A68AD2817709324")
    @DSModeled(DSC.SAFE)
    public void drawOval(RectF oval, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "E100F288BF7BC5AEBD49598437B1CC8E")
    @DSModeled(DSC.SAFE)
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(paint.dsTaint);
        native_drawCircle(mNativeCanvas, cx, cy, radius,
                          paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawCircle(mNativeCanvas, cx, cy, radius,
                          //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "F4AF075FD0A2D1422CA480462FC81409")
    @DSModeled(DSC.SAFE)
    public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(useCenter);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        {
            throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "F5F9E87493392C1E922E266FA6FCF691")
    @DSModeled(DSC.SAFE)
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        {
            throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "0771B06A5DB79DCDA48BD1ADBD491833", hash_generated_method = "EE79028C504FA78250114D01B2D12AB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPath(Path path, Paint paint) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.996 -0400", hash_original_method = "4E72B045BA38CFE64C69AC73618E6E81", hash_generated_method = "334FC681567308ECFC605C40827E1CC3")
    private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.997 -0400", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "766271A5397794B0BBC500D8EA9D3015")
    @DSModeled(DSC.SAFE)
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        dsTaint.addTaint(chunks);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.997 -0400", hash_original_method = "31B292C5F0F5731C1C9071C226236EDA", hash_generated_method = "AA47EE2B90547CEB8572CD84534D5530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(paint.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.997 -0400", hash_original_method = "C948472D99C8DCD49BAB1292EF9A789B", hash_generated_method = "A33111DAAD4E000BFC05C0E20B26B4AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        {
            throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.997 -0400", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "8A03E1BCC732F3BF7C7D67DF6116E0F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        {
            throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.997 -0400", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "2C616F13CCAFF09628BC7A686DAB2922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmap(int[] colors, int offset, int stride, float x,
                           float y, int width, int height, boolean hasAlpha,
                           Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            throw new IllegalArgumentException("width must be >= 0");
        } //End block
        {
            throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_699196699 = (Math.abs(stride) < width);
            {
                throw new IllegalArgumentException("abs(stride) must be >= width");
            } //End block
        } //End collapsed parenthetic
        int lastScanline;
        lastScanline = offset + (height - 1) * stride;
        int length;
        length = colors.length;
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_drawBitmap(mNativeCanvas, colors, offset, stride, x, y, width, height, hasAlpha,
                paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.998 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "8C2F6AD067265574DB37037C63C0DF02")
    @DSModeled(DSC.SAFE)
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
                           int width, int height, boolean hasAlpha,
                           Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   hasAlpha, paint);
        // ---------- Original Method ----------
        //drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   //hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.998 -0400", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "AEEC9085D3EFF568FDBABBCBBCAA968D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.998 -0400", hash_original_method = "8881482C31CD6EB42F6A156D24B79CEC", hash_generated_method = "BFA33F863C09EC7778ECB3B0762595FC")
    protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.998 -0400", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "9F3656F5E0E135C0B1A23F23659CDEBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight,
                               float[] verts, int vertOffset,
                               int[] colors, int colorOffset, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(meshWidth);
        dsTaint.addTaint(meshHeight);
        dsTaint.addTaint(verts);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vertOffset);
        {
            throw new ArrayIndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.998 -0400", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "8F5DC9AFDB378165475B2E74462E5F1D")
    @DSModeled(DSC.SAFE)
    public void drawVertices(VertexMode mode, int vertexCount,
                             float[] verts, int vertOffset,
                             float[] texs, int texOffset,
                             int[] colors, int colorOffset,
                             short[] indices, int indexOffset,
                             int indexCount, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(vertexCount);
        dsTaint.addTaint(indexOffset);
        dsTaint.addTaint(texs);
        dsTaint.addTaint(indexCount);
        dsTaint.addTaint(texOffset);
        dsTaint.addTaint(verts);
        dsTaint.addTaint(colors);
        dsTaint.addTaint(indices);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(mode.dsTaint);
        dsTaint.addTaint(vertOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.999 -0400", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "F2C0A4EC6E5BDAA2C4E663C7D9D3CDA2")
    @DSModeled(DSC.SAFE)
    public void drawText(char[] text, int index, int count, float x, float y,
                         Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.999 -0400", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "56B4621D660911EB43C295556910F731")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.999 -0400", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "269C5778F41065BBB98A014216444854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(String text, int start, int end, float x, float y,
                         Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var9527A5CDD965760192A60A252272F336_545910875 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.999 -0400", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "A0CA5B94D45C5E6F4776D9CDD4DE3D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawText(CharSequence text, int start, int end, float x,
                         float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.999 -0400", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "861E8B586337B3D71A682171401BA4B1")
    @DSModeled(DSC.SAFE)
    public void drawTextRun(char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir,
            Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(count);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            throw new NullPointerException("text is null");
        } //End block
        {
            throw new NullPointerException("paint is null");
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        {
            throw new IllegalArgumentException("unknown dir: " + dir);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.000 -0400", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "2A2B354B0C832F832DF042C575179FC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextRun(CharSequence text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int dir,
            Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(end);
        dsTaint.addTaint(y);
        dsTaint.addTaint(contextEnd);
        dsTaint.addTaint(x);
        {
            throw new NullPointerException("text is null");
        } //End block
        {
            throw new NullPointerException("paint is null");
        } //End block
        {
            boolean var5121ADA1DFFE288F77E0A77339FFD85F_411562892 = ((start | end | end - start | text.length() - end) < 0);
            {
                throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.000 -0400", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "C243E5FC0831856DD193A0EB773BAAD0")
    @DSModeled(DSC.SAFE)
    public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos);
        {
            throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.000 -0400", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "2F98B83D30B2868F6E200563BFF31144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPosText(String text, float[] pos, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos);
        {
            boolean var8252BA30A9512CA9A5F07EEE6666D9DD_1886525473 = (text.length()*2 > pos.length);
            {
                throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text.length()*2 > pos.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.000 -0400", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "9820B408F93D8EFE68EEF595B9BE9F3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextOnPath(char[] text, int index, int count, Path path,
                               float hOffset, float vOffset, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        {
            throw new ArrayIndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.001 -0400", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "EFA4E8A9458AF2297FDC0B6E96B42A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawTextOnPath(String text, Path path, float hOffset,
                               float vOffset, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        {
            boolean varC763452D8A14BA9A46AF46F7BF99B944_1577819083 = (text.length() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.001 -0400", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "AF3AB00E352286F4DF762764AB3A3B86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture) {
        dsTaint.addTaint(picture.dsTaint);
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
        // ---------- Original Method ----------
        //picture.endRecording();
        //native_drawPicture(mNativeCanvas, picture.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.001 -0400", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "7A259933C482E4227A972229070CF96D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture, RectF dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_75413588 = (picture.getWidth() > 0 && picture.getHeight() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.001 -0400", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "B855AEDB324D52224ECAA933D40BB294")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPicture(Picture picture, Rect dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_1624856757 = (picture.getWidth() > 0 && picture.getHeight() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "93434D631F907ECC82DC2E048DB0F3A9", hash_generated_method = "820B69D7A367E4DB0F1F2D5357DD5708")
    public static void freeCaches() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "3EBBBBC26F5E16FFB2B6D786FA479F7E", hash_generated_method = "41B6D9FFFD03A4B90E4E3EEAE273550D")
    private static int initRaster(int nativeBitmapOrZero) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "8A7EBB7C23E6416DF65D6370CED77FAF", hash_generated_method = "DB243E0B630BE60E91A773C2607DF038")
    private static void native_setBitmap(int nativeCanvas, int bitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "5E3C17309541973BE3514660DDBAF04D", hash_generated_method = "E2A7CE7E3E4EA117DBB7A6A276E3ADE2")
    private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "D2B1B73656A8B182F4A01F38BF3CFBF6", hash_generated_method = "6AC585BA27D293624528E70B168F163D")
    private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "9594DE1ABC3315C82CB8DB0D7C4E4C98", hash_generated_method = "35FDF9CE47D6FAF8B194026FA4ADEE2E")
    private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "BA99D49CA5823566EE917CE39D511947", hash_generated_method = "D5FC2E5D6F865CCFBA25C54EDCB7D715")
    private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "423AE455CB6BD353F1D991C4C3A1C716", hash_generated_method = "C6C9CC66604CB0E0C4BF7286E3036B3C")
    private static void native_concat(int nCanvas, int nMatrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "F209B4B31BD738CCD97D2988C37011C9", hash_generated_method = "1A82D7347135688ED8EAB5D3C19A9375")
    private static void native_setMatrix(int nCanvas, int nMatrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "404E41FDB1BA7BAF993613A3C893F8D7", hash_generated_method = "410605AC96C45F1C90D1BD62CDAB77FC")
    private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.002 -0400", hash_original_method = "650D1014388FBCF2647BD895B09B762C", hash_generated_method = "048549314D0D5096F434FDAD36C35BA2")
    private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "59CFFBD9BC9916B57B57860C120B5C08", hash_generated_method = "DDD87BA96EF43DF037E4F83D019691F1")
    private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "7816F1A0CAB31287786A3567A2FBE745", hash_generated_method = "3B05093D99365B90AA06C0BB970678EE")
    private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "810BA0AC84127E98C729669F2EA0CAD3", hash_generated_method = "4D180A4263CF21FA6C870EB9B7DDE2C5")
    private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "1900DEFB1A0F049DE4AB767C6F9325E7", hash_generated_method = "0EBC3C817C701E378BF568BAA1990A8D")
    private static void native_getCTM(int canvas, int matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "485A181FCE90D90A348999E1A2E04252", hash_generated_method = "A57F2D390648AA415EDB32886FEDA0C7")
    private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "4739263377A53D1C5E51AB843BE07623", hash_generated_method = "DF28AC6281F9C939C9A2FB220D95CBAD")
    private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "A00E65D43961E6B6097AAB802937C1D0", hash_generated_method = "05A82887249C45E0BF4E885D0D86D601")
    private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "A64717A927D68E758144171688AC2103", hash_generated_method = "0A4545A3CB6D11B21AF492023F90803F")
    private static void native_drawRGB(int nativeCanvas, int r, int g,
                                              int b) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "3A6C44CC3A923F64AEFD5E0F71551708", hash_generated_method = "B77F97E3E322E9CA845BA2829316B1E8")
    private static void native_drawARGB(int nativeCanvas, int a, int r,
                                               int g, int b) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "BDA0CCBCF142D911E056EC2EA930C3D5", hash_generated_method = "A3CBAC26FFD4CA922C0DCEBA3CC3A6E0")
    private static void native_drawColor(int nativeCanvas, int color) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.003 -0400", hash_original_method = "39D6187793B442ADAF411958D7E6C231", hash_generated_method = "A148EBBCFFEAECAADADBC4BCC3D5C6BB")
    private static void native_drawColor(int nativeCanvas, int color,
                                                int mode) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "E1CF98EB13D626D45DA70CE5D8A6A895", hash_generated_method = "51E86B85C65556FAE0422C2B34AEFA94")
    private static void native_drawPaint(int nativeCanvas, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "F08456503EEF78F8CD8B324C21FF8162", hash_generated_method = "59907E7B383E2E1CC32870D313D5FE58")
    private static void native_drawLine(int nativeCanvas, float startX,
                                               float startY, float stopX,
                                               float stopY, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "35BCAA56BE6F51E8569B94D1B96A81F9", hash_generated_method = "4596EF472D13673565A6420E7784FDE0")
    private static void native_drawRect(int nativeCanvas, RectF rect,
                                               int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "EECFFF2E02BC47FBA1A1E5B1AA182042", hash_generated_method = "FD81D70661C601A1B178821A65D309A8")
    private static void native_drawRect(int nativeCanvas, float left,
                                               float top, float right,
                                               float bottom, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "27ECAB4C3F0F43B2541D5BB912337E24", hash_generated_method = "55E98AA6DB9C37A301764605E5482C46")
    private static void native_drawOval(int nativeCanvas, RectF oval,
                                               int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "9310583CCFCF127647C58297D3EDFD10", hash_generated_method = "11ECB5E8A010956901F0499D16A17FB7")
    private static void native_drawCircle(int nativeCanvas, float cx,
                                                 float cy, float radius,
                                                 int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "31E0BF9A98CD3328B6D9E63E701F3333", hash_generated_method = "632A501708458874337623D24ACC73D1")
    private static void native_drawArc(int nativeCanvas, RectF oval,
                                              float startAngle, float sweep,
                                              boolean useCenter, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "0964C9A5210500969275F4E89E56806B", hash_generated_method = "EF30CA520500EAAE4B8E7D67F2F9BE89")
    private static void native_drawRoundRect(int nativeCanvas,
                                                    RectF rect, float rx,
                                                    float ry, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "9143D0FFE1465B6E13906644CB1DC55E", hash_generated_method = "827EFAD31058AC008BAB50C3E0D4B6D5")
    private static void native_drawPath(int nativeCanvas, int path,
                                               int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "C80764E4805E21186793B1F564F2650A")
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
        dsTaint.addTaint(left);
        dsTaint.addTaint(canvasDensity);
        dsTaint.addTaint(nativeCanvas);
        dsTaint.addTaint(screenDensity);
        dsTaint.addTaint(top);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.004 -0400", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "BE11599239C04FBFD9331FAAD92BF065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, RectF dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
        dsTaint.addTaint(nativePaintOrZero);
        dsTaint.addTaint(bitmap);
        dsTaint.addTaint(bitmapDensity);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(nativeCanvas);
        dsTaint.addTaint(screenDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "7AE604C58B413E6D3ABB34FFA85984D5", hash_generated_method = "C56A572FF1B7401EC37A74D54311FD0B")
    private static void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, Rect dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "9AF65864F94E67ED14EE257F44CCE9B1", hash_generated_method = "CC0B58B7156663A9847D33B604E66BD0")
    private static void native_drawBitmap(int nativeCanvas, int[] colors,
                                                int offset, int stride, float x,
                                                 float y, int width, int height,
                                                 boolean hasAlpha,
                                                 int nativePaintOrZero) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "2922EB8A59E06AEF48CCE48EF0F46348", hash_generated_method = "DFC09E38B364F593A462ED26B8A2A5E2")
    private static void nativeDrawBitmapMatrix(int nCanvas, int nBitmap,
                                                      int nMatrix, int nPaint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "3B3E08F246CF595731F2874FB1780A26", hash_generated_method = "0E22E8AE525849F4138795F910F37194")
    private static void nativeDrawBitmapMesh(int nCanvas, int nBitmap,
                                                    int meshWidth, int meshHeight,
                                                    float[] verts, int vertOffset,
                                                    int[] colors, int colorOffset, int nPaint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "1D1FF950C9E6327A69123AF9A772CECF", hash_generated_method = "96156E2CD885C86E31C98F62FDFCC973")
    private static void nativeDrawVertices(int nCanvas, int mode, int n,
                   float[] verts, int vertOffset, float[] texs, int texOffset,
                   int[] colors, int colorOffset, short[] indices,
                   int indexOffset, int indexCount, int nPaint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "7A9D9EC8B324F5F52F4B7E2B9F8D236D", hash_generated_method = "031E13EAE5A049F4961DDA089EBE8A5C")
    private static void native_drawText(int nativeCanvas, char[] text,
                                               int index, int count, float x,
                                               float y, int flags, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "280C9A28059B7019CCF1C3EA2FE5B024", hash_generated_method = "0382151136BC2479151854C03C6A16D3")
    private static void native_drawText(int nativeCanvas, String text,
                                               int start, int end, float x,
                                               float y, int flags, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "6A6A1FFF8FCAEB7E70B3B9171BF13255", hash_generated_method = "B89F03267F3A494D4C3712E1B6990FD8")
    private static void native_drawTextRun(int nativeCanvas, String text,
            int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "F32455EEDB6633C51B236D96501E091A", hash_generated_method = "DA1F66E0E611DC8FDEF30A02F26DCD83")
    private static void native_drawTextRun(int nativeCanvas, char[] text,
            int start, int count, int contextStart, int contextCount,
            float x, float y, int flags, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.005 -0400", hash_original_method = "65C6735C53A3B9B2888D4C5FDE244DBD", hash_generated_method = "E70A285B5E5934B953FDC24C57BFE7AB")
    private static void native_drawPosText(int nativeCanvas,
                                                  char[] text, int index,
                                                  int count, float[] pos,
                                                  int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "4F65317CC1027DD9F88DC92D44102B4C", hash_generated_method = "B4A0A2FEC5F03EA29F74402A146C745C")
    private static void native_drawPosText(int nativeCanvas,
                                                  String text, float[] pos,
                                                  int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "CDF09434D9D8D429F50AA057E29E49C9", hash_generated_method = "71D26C2A4E075810B18023A424EF0467")
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     char[] text, int index,
                                                     int count, int path,
                                                     float hOffset,
                                                     float vOffset, int bidiFlags,
                                                     int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "7D70E34E0E877C08032ADB9BD01BE954", hash_generated_method = "A01901FB9835137C28F751EC247A4948")
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     String text, int path,
                                                     float hOffset, 
                                                     float vOffset, 
                                                     int flags, int paint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "C61D4ED64E5A54B55783BD16AE9EE812", hash_generated_method = "64881DFDBA69FD586D23255637BCBE06")
    private static void native_drawPicture(int nativeCanvas,
                                                  int nativePicture) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "0D0A34F72B74838CDA73FD43DC04BEB1", hash_generated_method = "B18CA5EC23A7CA1D2E77CFF09FF1F72C")
    private static void finalizer(int nativeCanvas) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    private static class CanvasFinalizer {
        private final int mNativeCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "52F4B82574AD344FC7F2CAD2D9F5C1DC")
        @DSModeled(DSC.SAFE)
        public CanvasFinalizer(int nativeCanvas) {
            dsTaint.addTaint(nativeCanvas);
            // ---------- Original Method ----------
            //mNativeCanvas = nativeCanvas;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.006 -0400", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "1E5D9FB07B5FF67D5A418E89F1D00761")
        @DSModeled(DSC.SAFE)
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

    
}


