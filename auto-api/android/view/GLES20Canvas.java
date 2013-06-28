package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.TemporaryBuffer;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

class GLES20Canvas extends HardwareCanvas {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "D57F412B2FBE34E5266AB85A3EC09555", hash_generated_field = "EB29C468CD6CC66BADB54A0F112750F9")

    private boolean mOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

    private int mRenderer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "8A3D5C4CB4C335D9AECD1C2651D2AAAF")

    @SuppressWarnings({"unused", "FieldCanBeLocal"}) private CanvasFinalizer mFinalizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "A71103FAF0A55FA79982ACB43DFBC49A", hash_generated_field = "6791C5CD1248B8A3047AAAB23F781F88")

    private final float[] mPoint = new float[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "8AF780D9E9617941A63F16F3D6400B2F", hash_generated_field = "BB2122C190B62908BBEDD5B8E43D320D")

    private final float[] mLine = new float[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "A51A4E6456596E09991D8FF2155CE00E", hash_generated_field = "49E49C9D9740E032CABA98DD5151CA56")

    private final Rect mClipBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "7E8B7E1A9144C0D301C8FE334261595B")

    private DrawFilter mFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.156 -0400", hash_original_method = "E61B8AD2F95A2B414E32399D6E0EB15F", hash_generated_method = "2AFB8DAA72D20488621230DD00C5A8A5")
      GLES20Canvas(boolean translucent) {
        this(false, translucent);
        addTaint(translucent);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.157 -0400", hash_original_method = "7F059AE8F3F932B35FF16ED888919AA8", hash_generated_method = "74FC0FA718B9D10E4233916A4857DF72")
      GLES20Canvas(int layer, boolean translucent) {
        mOpaque = !translucent;
        mRenderer = nCreateLayerRenderer(layer);
        setupFinalizer();
        // ---------- Original Method ----------
        //mOpaque = !translucent;
        //mRenderer = nCreateLayerRenderer(layer);
        //setupFinalizer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.157 -0400", hash_original_method = "E76C4C3F056A713824BBE7237B891059", hash_generated_method = "121B835638D0788E10561D4E38D29C58")
    protected  GLES20Canvas(boolean record, boolean translucent) {
        mOpaque = !translucent;
        {
            mRenderer = nCreateDisplayListRenderer();
        } //End block
        {
            mRenderer = nCreateRenderer();
        } //End block
        setupFinalizer();
        addTaint(record);
        // ---------- Original Method ----------
        //mOpaque = !translucent;
        //if (record) {
            //mRenderer = nCreateDisplayListRenderer();
        //} else {
            //mRenderer = nCreateRenderer();
        //}
        //setupFinalizer();
    }

    
    private static boolean nIsAvailable() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    static boolean isAvailable() {
        return sIsAvailable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.157 -0400", hash_original_method = "C5F1546049F1B2879B50EF00176E7660", hash_generated_method = "0C9C5F2865E1946BB687D321E4EF73B7")
    private void setupFinalizer() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not create GLES20Canvas renderer");
        } //End block
        {
            mFinalizer = new CanvasFinalizer(mRenderer);
        } //End block
        // ---------- Original Method ----------
        //if (mRenderer == 0) {
            //throw new IllegalStateException("Could not create GLES20Canvas renderer");
        //} else {
            //mFinalizer = new CanvasFinalizer(mRenderer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.158 -0400", hash_original_method = "DC942AC5C00E84A83A7A0337B1608CAB", hash_generated_method = "E424FF35B49ED518F1C9932756CF66A2")
    protected void resetDisplayListRenderer() {
        nResetDisplayListRenderer(mRenderer);
        // ---------- Original Method ----------
        //nResetDisplayListRenderer(mRenderer);
    }

    
    private static int nCreateRenderer() {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static int nCreateLayerRenderer(int layer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static int nCreateDisplayListRenderer() {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static void nResetDisplayListRenderer(int renderer) {
    }

    
    private static void nDestroyRenderer(int renderer) {
    }

    
    static int nCreateTextureLayer(boolean opaque, int[] layerInfo) {
        return DSUtils.UNKNOWN_INT;
    }

    
    static int nCreateLayer(int width, int height, boolean isOpaque, int[] layerInfo) {
        return DSUtils.UNKNOWN_INT;
    }

    
    static void nResizeLayer(int layerId, int width, int height, int[] layerInfo) {
    }

    
    static void nUpdateTextureLayer(int layerId, int width, int height, boolean opaque,
            SurfaceTexture surface) {
    }

    
    static void nSetTextureLayerTransform(int layerId, int matrix) {
    }

    
    static void nDestroyLayer(int layerId) {
    }

    
    static void nDestroyLayerDeferred(int layerId) {
    }

    
    static boolean nCopyLayer(int layerId, int bitmap) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.160 -0400", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "3FCB0DD128C90CEA35255F0B5080335B")
    @Override
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413084162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413084162;
        // ---------- Original Method ----------
        //return mOpaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.160 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "A9B4B55E794271E12A332D37E44961C9")
    @Override
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685693592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685693592;
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.160 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "D20D691DF12B98D8AC596CAC4B187900")
    @Override
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056217065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056217065;
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.161 -0400", hash_original_method = "10F69D1300E55A44C724BA9496871588", hash_generated_method = "F2163ECF7DB82A059F6C7A64F6F17D44")
    @Override
    public int getMaximumBitmapWidth() {
        int var2F82E860F1E12659F23C0B40B403A9CB_285218816 = (nGetMaximumTextureWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262034345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1262034345;
        // ---------- Original Method ----------
        //return nGetMaximumTextureWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.161 -0400", hash_original_method = "A5ADDC40BA4D92830B9288340B890F82", hash_generated_method = "5A3ED69E0DF22D1ABD8FF15E0EC98328")
    @Override
    public int getMaximumBitmapHeight() {
        int var1BBF2D527FD9D576845B61C43DC1364E_340132767 = (nGetMaximumTextureHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365609133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365609133;
        // ---------- Original Method ----------
        //return nGetMaximumTextureHeight();
    }

    
    private static int nGetMaximumTextureWidth() {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static int nGetMaximumTextureHeight() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.162 -0400", hash_original_method = "3FE83BE893B91EF457CAAB97151B4DC3", hash_generated_method = "CC3C39D0D5C07B70A32E1D6BF9872BD0")
    @Override
    public void setViewport(int width, int height) {
        mWidth = width;
        mHeight = height;
        nSetViewport(mRenderer, width, height);
        // ---------- Original Method ----------
        //mWidth = width;
        //mHeight = height;
        //nSetViewport(mRenderer, width, height);
    }

    
    private static void nSetViewport(int renderer, int width, int height) {
    }

    
    public static boolean preserveBackBuffer() {
        return nPreserveBackBuffer();
    }

    
    private static boolean nPreserveBackBuffer() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static boolean isBackBufferPreserved() {
        return nIsBackBufferPreserved();
    }

    
    private static boolean nIsBackBufferPreserved() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static void disableVsync() {
        nDisableVsync();
    }

    
    private static void nDisableVsync() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.163 -0400", hash_original_method = "9B095EEB0FC45774066EB055E8D05D05", hash_generated_method = "194D03C0C0802C77E17386DC78E96B57")
    @Override
     void onPreDraw(Rect dirty) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            nPrepareDirty(mRenderer, dirty.left, dirty.top, dirty.right, dirty.bottom, mOpaque);
        } //End block
        {
            nPrepare(mRenderer, mOpaque);
        } //End block
        addTaint(dirty.getTaint());
        // ---------- Original Method ----------
        //if (dirty != null) {
            //nPrepareDirty(mRenderer, dirty.left, dirty.top, dirty.right, dirty.bottom, mOpaque);
        //} else {
            //nPrepare(mRenderer, mOpaque);
        //}
    }

    
    private static void nPrepare(int renderer, boolean opaque) {
    }

    
    private static void nPrepareDirty(int renderer, int left, int top, int right, int bottom,
            boolean opaque) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.163 -0400", hash_original_method = "7365F42EBD4B3D862109C8AFB45818F1", hash_generated_method = "D28DBD24898E379BFD423F6D4D12570A")
    @Override
     void onPostDraw() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        nFinish(mRenderer);
        // ---------- Original Method ----------
        //nFinish(mRenderer);
    }

    
    private static void nFinish(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.164 -0400", hash_original_method = "D585DC5373E63EDA28C11B713D8E1A5B", hash_generated_method = "4D0D1BBC35FB0AD996AB6BB04CB27C07")
    @Override
    public boolean callDrawGLFunction(int drawGLFunction) {
        boolean varC4A19E2A6C6B767935A813F45844EA3B_2016554624 = (nCallDrawGLFunction(mRenderer, drawGLFunction));
        addTaint(drawGLFunction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471338397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471338397;
        // ---------- Original Method ----------
        //return nCallDrawGLFunction(mRenderer, drawGLFunction);
    }

    
    private static boolean nCallDrawGLFunction(int renderer, int drawGLFunction) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static void flushCaches(int level) {
        nFlushCaches(level);
    }

    
    private static void nFlushCaches(int level) {
    }

    
    public static void terminateCaches() {
        nTerminateCaches();
    }

    
    private static void nTerminateCaches() {
    }

    
    public static void initCaches() {
        nInitCaches();
    }

    
    private static void nInitCaches() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.165 -0400", hash_original_method = "B6A785707CFBE1E38AD4FE8A1D6625FF", hash_generated_method = "AE9ACAC6704CE8E68DC6B9274FA358A9")
     int getDisplayList(int displayList) {
        int varCBB832023A69ED9BB808A7FE776E9BD9_636855390 = (nGetDisplayList(mRenderer, displayList));
        addTaint(displayList);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257747366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257747366;
        // ---------- Original Method ----------
        //return nGetDisplayList(mRenderer, displayList);
    }

    
    private static int nGetDisplayList(int renderer, int displayList) {
        return DSUtils.UNKNOWN_INT;
    }

    
    static void destroyDisplayList(int displayList) {
        nDestroyDisplayList(displayList);
    }

    
    private static void nDestroyDisplayList(int displayList) {
    }

    
    static int getDisplayListSize(int displayList) {
        return nGetDisplayListSize(displayList);
    }

    
    private static int nGetDisplayListSize(int displayList) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.166 -0400", hash_original_method = "444FDEED71E94CFCE2A65CC1E400505B", hash_generated_method = "3C6AA9F0736DBAF259835CE702F55B1B")
    @Override
    public boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty) {
        boolean var21370983C4F053CE0631C1001824FECB_1801497422 = (nDrawDisplayList(mRenderer,
                ((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty));
        addTaint(displayList.getTaint());
        addTaint(width);
        addTaint(height);
        addTaint(dirty.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793106707 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_793106707;
        // ---------- Original Method ----------
        //return nDrawDisplayList(mRenderer,
                //((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty);
    }

    
    private static boolean nDrawDisplayList(int renderer, int displayList,
            int width, int height, Rect dirty) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.166 -0400", hash_original_method = "5B863FAF56BDA796D9647970A297D545", hash_generated_method = "392FF023F6FF54515E49CD1513012D05")
    @Override
     void outputDisplayList(DisplayList displayList) {
        nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
        addTaint(displayList.getTaint());
        // ---------- Original Method ----------
        //nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
    }

    
    private static void nOutputDisplayList(int renderer, int displayList) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.169 -0400", hash_original_method = "34690C8D247D9A973C4DB94AE9D7C53D", hash_generated_method = "88557E4A99998A17E55C40247C390558")
     void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint) {
        final GLES20Layer glLayer = (GLES20Layer) layer;
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
        nResetModifiers(mRenderer, modifier);
        addTaint(layer.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //final GLES20Layer glLayer = (GLES20Layer) layer;
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    
    private static void nDrawLayer(int renderer, int layer, float x, float y, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.170 -0400", hash_original_method = "2CAEF0DDE58BE10FAAA9AA0E667CCD64", hash_generated_method = "BA861453510B5BC8D04AD58E7A1553A0")
     void interrupt() {
        nInterrupt(mRenderer);
        // ---------- Original Method ----------
        //nInterrupt(mRenderer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.171 -0400", hash_original_method = "C365B4BBFEB4F0EDD5006A765220696B", hash_generated_method = "1C80A41B36E63E43CCFBDD0716C47088")
     void resume() {
        nResume(mRenderer);
        // ---------- Original Method ----------
        //nResume(mRenderer);
    }

    
    private static void nInterrupt(int renderer) {
    }

    
    private static void nResume(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.172 -0400", hash_original_method = "CD9590925AA701F1E39AE88CF6AE97E7", hash_generated_method = "1D2D7F617ECB1C921E6A81819E30E250")
    @Override
    public boolean clipPath(Path path) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(path.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475746647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475746647;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.172 -0400", hash_original_method = "A0322959331EF06FDECE706338820D13", hash_generated_method = "012E27128FB0410358418EDE9338AD65")
    @Override
    public boolean clipPath(Path path, Region.Op op) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(path.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1249688425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1249688425;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.172 -0400", hash_original_method = "3AC948804DA1E718A76D8B221FEACE24", hash_generated_method = "CC4B71458FCB3147B4E27C4F134C22DB")
    @Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        boolean var5AEDEF262D6E77628C31CFE063BA37CC_1599249841 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636737380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636737380;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    
    private static boolean nClipRect(int renderer, float left, float top,
            float right, float bottom, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.173 -0400", hash_original_method = "CF0F08AE677C71FBDBDD5FF973518EEC", hash_generated_method = "0F0FF738955DCA7F6F912FC078F3181F")
    @Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        boolean varEAE2AD84DDACC0D8F9E8CB54A9C56C43_560525834 = (nClipRect(mRenderer, left, top, right, bottom, op.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293114265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_293114265;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.173 -0400", hash_original_method = "3911A8B4E2CBFCB889327A4F77A9CAF7", hash_generated_method = "5F31A7237319A9DACDF13C2F602568FB")
    @Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        boolean var5AEDEF262D6E77628C31CFE063BA37CC_2129130905 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429931325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429931325;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    
    private static boolean nClipRect(int renderer, int left, int top, int right, int bottom,
            int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.174 -0400", hash_original_method = "C5507A7F3855C8C6C63565CD78400CEB", hash_generated_method = "AB17187B0FBF8642AEE187A2A0710C14")
    @Override
    public boolean clipRect(Rect rect) {
        boolean var20B4B81DA2D8103CA7CA51BA49BE0DD0_1390661544 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336024745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336024745;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //Region.Op.INTERSECT.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.174 -0400", hash_original_method = "CE1C58CF7145731A4EAE6ABB1C090975", hash_generated_method = "ADFBDA193CF2F8BCC8782CF64FA5FF44")
    @Override
    public boolean clipRect(Rect rect, Region.Op op) {
        boolean varF4CB4A50501C143AE1ED2F868AC9C184_998681062 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65061409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65061409;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.175 -0400", hash_original_method = "82CE8198F83847EB9950BBA97A14CB45", hash_generated_method = "2F68EEF01B029447F0A6D8E7D1AADC8B")
    @Override
    public boolean clipRect(RectF rect) {
        boolean var20B4B81DA2D8103CA7CA51BA49BE0DD0_1884066240 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941651711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941651711;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //Region.Op.INTERSECT.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.175 -0400", hash_original_method = "84F2B877854C623DFB4ED57554605946", hash_generated_method = "C82B400CD5FDAA6FDEA2996606403C98")
    @Override
    public boolean clipRect(RectF rect, Region.Op op) {
        boolean varF4CB4A50501C143AE1ED2F868AC9C184_1199319486 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743489815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743489815;
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.175 -0400", hash_original_method = "668D615301DC55EDCE9C8FA044FF5F71", hash_generated_method = "F22259DEBB38649D5D284D0778F93460")
    @Override
    public boolean clipRegion(Region region) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926656492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926656492;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.176 -0400", hash_original_method = "9554359F0ECC8D3364C9D02F1B6C0A6E", hash_generated_method = "3E8B192DD72648B20C5C245F4F182AAB")
    @Override
    public boolean clipRegion(Region region, Region.Op op) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725385203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725385203;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.176 -0400", hash_original_method = "5A157FCBBF6BAEFB3D0D6DDEEF98EB76", hash_generated_method = "18C1EDBC49E92275B8CCF6AB2CCA20EE")
    @Override
    public boolean getClipBounds(Rect bounds) {
        boolean varCA244AE61DE6F3A03B7536F19E7E331E_41204487 = (nGetClipBounds(mRenderer, bounds));
        addTaint(bounds.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958428715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958428715;
        // ---------- Original Method ----------
        //return nGetClipBounds(mRenderer, bounds);
    }

    
    private static boolean nGetClipBounds(int renderer, Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.176 -0400", hash_original_method = "0662E9735A64886F23067D669F3F560C", hash_generated_method = "09786DF15880665FCB676DC6E95B3455")
    @Override
    public boolean quickReject(float left, float top, float right, float bottom, EdgeType type) {
        boolean var0F31BC06DBEC4B76A6CCB17691BE7DA8_1995503939 = (nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503063997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503063997;
        // ---------- Original Method ----------
        //return nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt);
    }

    
    private static boolean nQuickReject(int renderer, float left, float top,
            float right, float bottom, int edge) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.177 -0400", hash_original_method = "866F13730ACFD67020DA883631339738", hash_generated_method = "C6E06B7E503BD58D1870A1302D1E99CB")
    @Override
    public boolean quickReject(Path path, EdgeType type) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(path.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608953334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608953334;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.177 -0400", hash_original_method = "0E7313D794F0C2C284156675C98816BB", hash_generated_method = "5717607A43A52B4C43739B61D267BF1D")
    @Override
    public boolean quickReject(RectF rect, EdgeType type) {
        boolean var446DE569437F7D1782E011E7DFACF532_1498934525 = (quickReject(rect.left, rect.top, rect.right, rect.bottom, type));
        addTaint(rect.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312354663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312354663;
        // ---------- Original Method ----------
        //return quickReject(rect.left, rect.top, rect.right, rect.bottom, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.177 -0400", hash_original_method = "D702D49D0CBA8DAFFC483E145A7D155B", hash_generated_method = "062A0866B19ECB7D9AA9D0F734739CA3")
    @Override
    public void translate(float dx, float dy) {
        nTranslate(mRenderer, dx, dy);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //if (dx != 0.0f || dy != 0.0f) nTranslate(mRenderer, dx, dy);
    }

    
    private static void nTranslate(int renderer, float dx, float dy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.178 -0400", hash_original_method = "B4BEAF66CD344F6FBAA1A7BCA9EAC51C", hash_generated_method = "C41495E494DF8278073AE0B77A7BB97D")
    @Override
    public void skew(float sx, float sy) {
        nSkew(mRenderer, sx, sy);
        addTaint(sx);
        addTaint(sy);
        // ---------- Original Method ----------
        //nSkew(mRenderer, sx, sy);
    }

    
    private static void nSkew(int renderer, float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.179 -0400", hash_original_method = "088A2140F7946F7E1F87C60185C75E3A", hash_generated_method = "4AF01F5DBF73CFBC54957EE1B3783B33")
    @Override
    public void rotate(float degrees) {
        nRotate(mRenderer, degrees);
        addTaint(degrees);
        // ---------- Original Method ----------
        //nRotate(mRenderer, degrees);
    }

    
    private static void nRotate(int renderer, float degrees) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.179 -0400", hash_original_method = "407ACB57F0B4398889DAE0D23801B26B", hash_generated_method = "56D6F059A6DD46AE78E62B1AF24187AE")
    @Override
    public void scale(float sx, float sy) {
        nScale(mRenderer, sx, sy);
        addTaint(sx);
        addTaint(sy);
        // ---------- Original Method ----------
        //nScale(mRenderer, sx, sy);
    }

    
    private static void nScale(int renderer, float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.179 -0400", hash_original_method = "F6D59AD1FAE97EC22EF86A1DF6443B3F", hash_generated_method = "BB1A65239C3CCB84191C6CA107490B43")
    @Override
    public void setMatrix(Matrix matrix) {
        nSetMatrix(mRenderer, matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //nSetMatrix(mRenderer, matrix.native_instance);
    }

    
    private static void nSetMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.180 -0400", hash_original_method = "5C2AB9AC8E62FE145634A1140AF6AF7A", hash_generated_method = "163FA369562BC5B7C5810CBE2D11B663")
    @Override
    public void getMatrix(Matrix matrix) {
        nGetMatrix(mRenderer, matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //nGetMatrix(mRenderer, matrix.native_instance);
    }

    
    private static void nGetMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.181 -0400", hash_original_method = "D981C9A8CE9E8AB948A57E105C909748", hash_generated_method = "13B1CE8AB60D3EA26325CCF543DB0001")
    @Override
    public void concat(Matrix matrix) {
        nConcatMatrix(mRenderer, matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //nConcatMatrix(mRenderer, matrix.native_instance);
    }

    
    private static void nConcatMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.181 -0400", hash_original_method = "7EFF2592C3C6BD5E4F13755A0D5399A0", hash_generated_method = "A2DF92807B3D8D73D90F0FF94073D220")
    @Override
    public int save() {
        int varF2C17D2E97D5ED631A8D7EEE74944094_8655081 = (nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226753764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226753764;
        // ---------- Original Method ----------
        //return nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.182 -0400", hash_original_method = "F50C3BBFE7BD2C9D29BCAB4C8FE567F6", hash_generated_method = "7C340D2CE104ECA999469C561341D301")
    @Override
    public int save(int saveFlags) {
        int var2A3CE8B1D9F9FA715D89281510DCFCB9_931719847 = (nSave(mRenderer, saveFlags));
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044349267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044349267;
        // ---------- Original Method ----------
        //return nSave(mRenderer, saveFlags);
    }

    
    private static int nSave(int renderer, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.182 -0400", hash_original_method = "9DF5A937336C76576E5F634C144FC48D", hash_generated_method = "37A4B2A8A2284C5B56847830CD42C40E")
    @Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        {
            int var20A869D74EDE832F843CC7BD4DB8A988_3786731 = (saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, paint, saveFlags));
        } //End block
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        int count = nSaveLayer(mRenderer, nativePaint, saveFlags);
        nResetModifiers(mRenderer, modifier);
        addTaint(bounds.getTaint());
        addTaint(paint.getTaint());
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332815774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332815774;
        // ---------- Original Method ----------
        //if (bounds != null) {
            //return saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, paint, saveFlags);
        //}
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //int count = nSaveLayer(mRenderer, nativePaint, saveFlags);
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
        //return count;
    }

    
    private static int nSaveLayer(int renderer, int paint, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.183 -0400", hash_original_method = "E794596E5060868E9256D6234D184C09", hash_generated_method = "ECB930BC2BBFA266828CDC76FF6A3550")
    @Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint,
            int saveFlags) {
        {
            int modifier;
            modifier = setupColorFilter(paint);
            modifier = MODIFIER_NONE;
            int nativePaint;
            nativePaint = 0;
            nativePaint = paint.mNativePaint;
            int count = nSaveLayer(mRenderer, left, top, right, bottom, nativePaint, saveFlags);
            nResetModifiers(mRenderer, modifier);
        } //End block
        int varEA6155209B327E6D6A26296B56FB2AC5_475864829 = (save(saveFlags));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(paint.getTaint());
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074692725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074692725;
        // ---------- Original Method ----------
        //if (left < right && top < bottom) {
            //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
            //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
            //int count = nSaveLayer(mRenderer, left, top, right, bottom, nativePaint, saveFlags);
            //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
            //return count;
        //}
        //return save(saveFlags);
    }

    
    private static int nSaveLayer(int renderer, float left, float top,
            float right, float bottom, int paint, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.184 -0400", hash_original_method = "E4AB6B80C5EF0D5B797D753415FED0BE", hash_generated_method = "FE9A8206DF3432C6777A1CB8C04DC308")
    @Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        {
            int varFB0B372D7BDA6865AFF768ED959BAEF6_1107351438 = (saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom,
                    alpha, saveFlags));
        } //End block
        int varCFD03E3328DC4C00BBEC0CCC6AD112E5_2073883817 = (nSaveLayerAlpha(mRenderer, alpha, saveFlags));
        addTaint(bounds.getTaint());
        addTaint(alpha);
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915939169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915939169;
        // ---------- Original Method ----------
        //if (bounds != null) {
            //return saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom,
                    //alpha, saveFlags);
        //}
        //return nSaveLayerAlpha(mRenderer, alpha, saveFlags);
    }

    
    private static int nSaveLayerAlpha(int renderer, int alpha, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.184 -0400", hash_original_method = "B4AB4565F10B041D742F1796C47ECB95", hash_generated_method = "C8F648B0113FD1C7A0C146806D9F8C40")
    @Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha,
            int saveFlags) {
        {
            int var109591026B19EDE75417DB7AF33A11FA_1298386907 = (nSaveLayerAlpha(mRenderer, left, top, right, bottom, alpha, saveFlags));
        } //End block
        int varEA6155209B327E6D6A26296B56FB2AC5_1448141486 = (save(saveFlags));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(alpha);
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254545904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254545904;
        // ---------- Original Method ----------
        //if (left < right && top < bottom) {
            //return nSaveLayerAlpha(mRenderer, left, top, right, bottom, alpha, saveFlags);
        //}
        //return save(saveFlags);
    }

    
    private static int nSaveLayerAlpha(int renderer, float left, float top, float right,
            float bottom, int alpha, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.185 -0400", hash_original_method = "C18753FB8460844761E485A3B07AB085", hash_generated_method = "70D1825D14CEDE923274F8D7C79BA367")
    @Override
    public void restore() {
        nRestore(mRenderer);
        // ---------- Original Method ----------
        //nRestore(mRenderer);
    }

    
    private static void nRestore(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.186 -0400", hash_original_method = "03029795119CF4F7F4374FF9CDD913F1", hash_generated_method = "2B2F57009AF9A88635FCC8D8D93756FD")
    @Override
    public void restoreToCount(int saveCount) {
        nRestoreToCount(mRenderer, saveCount);
        addTaint(saveCount);
        // ---------- Original Method ----------
        //nRestoreToCount(mRenderer, saveCount);
    }

    
    private static void nRestoreToCount(int renderer, int saveCount) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.186 -0400", hash_original_method = "5171A9EFFCF2464453072A29F0BC817F", hash_generated_method = "1146B05ACF341F05B399B64DA78C0F59")
    @Override
    public int getSaveCount() {
        int varBD59B9383972492C3C1BFF0B7946F4DD_1706264490 = (nGetSaveCount(mRenderer));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644109966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644109966;
        // ---------- Original Method ----------
        //return nGetSaveCount(mRenderer);
    }

    
    private static int nGetSaveCount(int renderer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.186 -0400", hash_original_method = "846B7706B193B695840103C92096214E", hash_generated_method = "2A2151BC53135B33E05ECD91C4DDE028")
    @Override
    public void setDrawFilter(DrawFilter filter) {
        mFilter = filter;
        // ---------- Original Method ----------
        //mFilter = filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.187 -0400", hash_original_method = "00C808EC6F25CC6E1FA57C10F69CA13D", hash_generated_method = "25FFD7DCFE0E56E60FFE50EFAEFC7186")
    @Override
    public DrawFilter getDrawFilter() {
        DrawFilter varB4EAC82CA7396A68D541C85D26508E83_1354750150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1354750150 = mFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1354750150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1354750150;
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.187 -0400", hash_original_method = "1B5F3778D027ED2D7C875DF279109721", hash_generated_method = "EBC026967703DAECD601BDFCD5B96A97")
    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter,
            Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawArc(mRenderer, oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle,
                useCenter, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
        addTaint(useCenter);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawArc(mRenderer, oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle,
                //useCenter, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawArc(int renderer, float left, float top,
            float right, float bottom, float startAngle, float sweepAngle,
            boolean useCenter, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.188 -0400", hash_original_method = "AAC237D01F9254CC358C9D52B0A20AD9", hash_generated_method = "7100F337D20659FD2619EDAFF17FC452")
    @Override
    public void drawARGB(int a, int r, int g, int b) {
        drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        addTaint(a);
        addTaint(r);
        addTaint(g);
        addTaint(b);
        // ---------- Original Method ----------
        //drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.188 -0400", hash_original_method = "3E288E14B7CE68A819334B0A90162954", hash_generated_method = "BBB59D8D223BD6B6894D7319E33E2D0F")
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, chunks,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        nResetModifiers(mRenderer, modifier);
        addTaint(bitmap.getTaint());
        addTaint(chunks[0]);
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, chunks,
                //dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    
    private static void nDrawPatch(int renderer, int bitmap, byte[] buffer, byte[] chunks,
            float left, float top, float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.189 -0400", hash_original_method = "BF78CEE5A5D5A0B7000D42B8D7CD12A6", hash_generated_method = "B01E11762C9F1628459EF2CADDC12AE8")
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(bitmap.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawBitmap(
            int renderer, int bitmap, byte[] buffer, float left, float top, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.190 -0400", hash_original_method = "7A23E114FF3FC414FFADAB9162210E17", hash_generated_method = "C1F9FC6EDC4FBC2FDD2210F90ADCAB67")
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer,
                matrix.native_instance, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(bitmap.getTaint());
        addTaint(matrix.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer,
                //matrix.native_instance, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buff,
            int matrix, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.191 -0400", hash_original_method = "025B89D3F15CD9670FC3D74B91AB5D58", hash_generated_method = "611A34F8B8D32D25C9F7E8FA04546A70")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        int left;
        int top;
        int right;
        int bottom;
        {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } //End block
        {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        } //End block
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //int left, top, right, bottom;
        //if (src == null) {
            //left = top = 0;
            //right = bitmap.getWidth();
            //bottom = bitmap.getHeight();
        //} else {
            //left = src.left;
            //right = src.right;
            //top = src.top;
            //bottom = src.bottom;
        //}
        //nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                //dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.192 -0400", hash_original_method = "18A7A5D5D5C8B881DFD85E47F7DA3439", hash_generated_method = "8D97BB904EF3E2462A79C4D25132A98E")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        float left;
        float top;
        float right;
        float bottom;
        {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } //End block
        {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        } //End block
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //float left, top, right, bottom;
        //if (src == null) {
            //left = top = 0;
            //right = bitmap.getWidth();
            //bottom = bitmap.getHeight();
        //} else {
            //left = src.left;
            //right = src.right;
            //top = src.top;
            //bottom = src.bottom;
        //}
        //nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                //dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buffer,
            float srcLeft, float srcTop, float srcRight, float srcBottom,
            float left, float top, float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.193 -0400", hash_original_method = "9B6F84B3164E22399F0F518F30D6F56B", hash_generated_method = "2C0139AB8799BD160F56256C71EABAF8")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y,
            int width, int height, boolean hasAlpha, Paint paint) {
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        Bitmap.Config config;
        config = Bitmap.Config.ARGB_8888;
        config = Bitmap.Config.RGB_565;
        final Bitmap b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        b.recycle();
        nResetModifiers(mRenderer, modifier);
        addTaint(colors[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        addTaint(hasAlpha);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final Bitmap.Config config = hasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        //final Bitmap b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        //b.recycle();
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.194 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "E86361AE744E9B7F72E66F9429D95648")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
            int width, int height, boolean hasAlpha, Paint paint) {
        drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
        addTaint(colors[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        addTaint(hasAlpha);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.194 -0400", hash_original_method = "B49032D10E62987D37B2D43027E8B7B3", hash_generated_method = "4B77C2058A49FC8474A261AE3C9221A2")
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        final int count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);
        colors = null;
        colorOffset = 0;
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmapMesh(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, meshWidth, meshHeight,
                verts, vertOffset, colors, colorOffset, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(bitmap.getTaint());
        addTaint(meshWidth);
        addTaint(meshHeight);
        addTaint(verts[0]);
        addTaint(vertOffset);
        addTaint(colors[0]);
        addTaint(colorOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (meshWidth < 0 || meshHeight < 0 || vertOffset < 0 || colorOffset < 0) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (meshWidth == 0 || meshHeight == 0) {
            //return;
        //}
        //final int count = (meshWidth + 1) * (meshHeight + 1);
        //checkRange(verts.length, vertOffset, count * 2);
        //colors = null;
        //colorOffset = 0;
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmapMesh(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, meshWidth, meshHeight,
                //verts, vertOffset, colors, colorOffset, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawBitmapMesh(int renderer, int bitmap, byte[] buffer,
            int meshWidth, int meshHeight, float[] verts, int vertOffset,
            int[] colors, int colorOffset, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.195 -0400", hash_original_method = "3CC575BC6DB3F469750010B2B8CAC81C", hash_generated_method = "EBBAD1BFB9856D8BEC02715E8F024851")
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(cx);
        addTaint(cy);
        addTaint(radius);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawCircle(int renderer, float cx, float cy,
            float radius, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.195 -0400", hash_original_method = "4F7ABDA5E981B914379787693CC10165", hash_generated_method = "BDBB1C6CE2C518602EAF02B4D9C5F026")
    @Override
    public void drawColor(int color) {
        drawColor(color, PorterDuff.Mode.SRC_OVER);
        addTaint(color);
        // ---------- Original Method ----------
        //drawColor(color, PorterDuff.Mode.SRC_OVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.196 -0400", hash_original_method = "CF35C7302232BF0C4B60CFA92B96D407", hash_generated_method = "66C5EADDBCC0448A906591FEDFC52DB1")
    @Override
    public void drawColor(int color, PorterDuff.Mode mode) {
        nDrawColor(mRenderer, color, mode.nativeInt);
        addTaint(color);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //nDrawColor(mRenderer, color, mode.nativeInt);
    }

    
    private static void nDrawColor(int renderer, int color, int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.196 -0400", hash_original_method = "5EABC5A9A71D080A656B11841F718311", hash_generated_method = "83FBC18BECAA1D26869A9AFD31E56AD5")
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        mLine[0] = startX;
        mLine[1] = startY;
        mLine[2] = stopX;
        mLine[3] = stopY;
        drawLines(mLine, 0, 4, paint);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //mLine[0] = startX;
        //mLine[1] = startY;
        //mLine[2] = stopX;
        //mLine[3] = stopY;
        //drawLines(mLine, 0, 4, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.197 -0400", hash_original_method = "CC8F0B4448632DE8A259253A60E2B3F7", hash_generated_method = "CAF94CA85E686CF7324721A21202A420")
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        } //End block
        int modifiers = setupModifiers(paint);
        nDrawLines(mRenderer, pts, offset, count, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(pts[0]);
        addTaint(offset);
        addTaint(count);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((offset | count) < 0 || offset + count > pts.length) {
            //throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        //}
        //int modifiers = setupModifiers(paint);
        //nDrawLines(mRenderer, pts, offset, count, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawLines(int renderer, float[] points,
            int offset, int count, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.197 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "20F7F5F3BFD3766A6C8EDC4B8F987BDC")
    @Override
    public void drawLines(float[] pts, Paint paint) {
        drawLines(pts, 0, pts.length, paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.197 -0400", hash_original_method = "3C8333232F307DB00830ADFD9367082C", hash_generated_method = "0733ECA4F6C20A2033C203075FC58398")
    @Override
    public void drawOval(RectF oval, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(oval.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawOval(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.198 -0400", hash_original_method = "F3CEC7F1ABD68352F2A5895BCD8335A7", hash_generated_method = "4437342066D10E68893C3D84DE346C8D")
    @Override
    public void drawPaint(Paint paint) {
        final Rect r = mClipBounds;
        nGetClipBounds(mRenderer, r);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //final Rect r = mClipBounds;
        //nGetClipBounds(mRenderer, r);
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.198 -0400", hash_original_method = "E734C6F1749AB430929BC8490D600517", hash_generated_method = "61937937C79AC9496EFFD599AAE79CDB")
    @Override
    public void drawPath(Path path, Paint paint) {
        int modifiers = setupModifiers(paint);
        {
            {
                nDrawRects(mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
            } //End block
        } //End block
        {
            nDrawPath(mRenderer, path.mNativePath, paint.mNativePaint);
        } //End block
        nResetModifiers(mRenderer, modifiers);
        addTaint(path.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //if (path.isSimplePath) {
            //if (path.rects != null) {
                //nDrawRects(mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
            //}
        //} else {
            //nDrawPath(mRenderer, path.mNativePath, paint.mNativePaint);
        //}
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawPath(int renderer, int path, int paint) {
    }

    
    private static void nDrawRects(int renderer, int region, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.199 -0400", hash_original_method = "2AA9BBA2F44244E312AB57A12DAF658B", hash_generated_method = "F2B8595DD75A2F7A3630EEB354DA0C3F")
    @Override
    public void drawPicture(Picture picture) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(picture.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.200 -0400", hash_original_method = "1202DF046E7699A744E442D410CE2128", hash_generated_method = "C18903179754272BB4DAA014D59EEA46")
    @Override
    public void drawPicture(Picture picture, Rect dst) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(picture.getTaint());
        addTaint(dst.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.200 -0400", hash_original_method = "CE526B9F8925E416169A22B853086EA4", hash_generated_method = "C983ABE9421E9461991AEF24F970DCFE")
    @Override
    public void drawPicture(Picture picture, RectF dst) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(picture.getTaint());
        addTaint(dst.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.201 -0400", hash_original_method = "711B0E1C295D7644DD171BC7547CDDDA", hash_generated_method = "00C2BAB4377C062205605ACBC5494E12")
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        mPoint[0] = x;
        mPoint[1] = y;
        drawPoints(mPoint, 0, 2, paint);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //mPoint[0] = x;
        //mPoint[1] = y;
        //drawPoints(mPoint, 0, 2, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.201 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "761E08A19F69F8527973C9F526190591")
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        drawPoints(pts, 0, pts.length, paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.202 -0400", hash_original_method = "A6EA0B46F26697457B201A425B5A3171", hash_generated_method = "A2985637F2788B210D2200E69AE16C19")
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(pts[0]);
        addTaint(offset);
        addTaint(count);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawPoints(int renderer, float[] points,
            int offset, int count, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.203 -0400", hash_original_method = "A1D0375AE9DFF68E398CA7F0C8CFDC48", hash_generated_method = "C58AAF0ED1F6D9D63C48503C4E523D01")
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.203 -0400", hash_original_method = "2727BD7310EB8AF1CE9C5E69FE8F5F77", hash_generated_method = "528C69E94D75929A5C52268974BE27CA")
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        addTaint(text.getTaint());
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.203 -0400", hash_original_method = "1D1C68AD886616B8DD56E02894BED97B", hash_generated_method = "92771B0E2444F4143EADFD18CA61C8AD")
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawRect(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.204 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "7B347C48A24269E0F3F362452CD9958D")
    @Override
    public void drawRect(Rect r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        addTaint(r.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.205 -0400", hash_original_method = "73D11F584AEBB7C191086A2FFF4052A9", hash_generated_method = "6BA46391F60F374ED4AC0AC14305E04E")
    @Override
    public void drawRect(RectF r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        addTaint(r.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.205 -0400", hash_original_method = "EB9FA3A1182306D8C56FD7B1B2A405F0", hash_generated_method = "4AE00367D49D1FA55A3E06642921B7B3")
    @Override
    public void drawRGB(int r, int g, int b) {
        drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        addTaint(r);
        addTaint(g);
        addTaint(b);
        // ---------- Original Method ----------
        //drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.205 -0400", hash_original_method = "F66719DAB9BD4C7CE0890FFA1C26F9F2", hash_generated_method = "E0FB26D9D2700573B79A50A1EE0FD469")
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                rx, ry, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        addTaint(rect.getTaint());
        addTaint(rx);
        addTaint(ry);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //rx, ry, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
    private static void nDrawRoundRect(int renderer, float left, float top,
            float right, float bottom, float rx, float y, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.206 -0400", hash_original_method = "5B66E40A85BEEB6F8228E5994A513667", hash_generated_method = "66D40364D8F80C4B215A7B30E881FE16")
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, index, count, x, y, paint.mBidiFlags, paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((index | count | (index + count) | (text.length - index - count)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //int modifiers = setupModifiers(paint);
        //try {
            //nDrawText(mRenderer, text, index, count, x, y, paint.mBidiFlags, paint.mNativePaint);
        //} finally {
            //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        //}
    }

    
    private static void nDrawText(int renderer, char[] text, int index, int count,
            float x, float y, int bidiFlags, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.207 -0400", hash_original_method = "BF4D02798081BBBF8269CD636760F070", hash_generated_method = "EE41C78DD9D65A8F04707490C780FF02")
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        int modifiers = setupModifiers(paint);
        try 
        {
            {
                nDrawText(mRenderer, text.toString(), start, end, x, y, paint.mBidiFlags,
                        paint.mNativePaint);
            } //End block
            {
                ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                         paint);
            } //End block
            {
                char[] buf = TemporaryBuffer.obtain(end - start);
                TextUtils.getChars(text, start, end, buf, 0);
                nDrawText(mRenderer, buf, 0, end - start, x, y,
                        paint.mBidiFlags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            } //End block
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.207 -0400", hash_original_method = "53AB28ACA34BAB18CDB1722B92273EEB", hash_generated_method = "3187A12EF084C18A8B965766A09E9FF3")
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        {
            boolean var9527A5CDD965760192A60A252272F336_1839049712 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, start, end, x, y, paint.mBidiFlags, paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //int modifiers = setupModifiers(paint);
        //try {
            //nDrawText(mRenderer, text, start, end, x, y, paint.mBidiFlags, paint.mNativePaint);
        //} finally {
            //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        //}
    }

    
    private static void nDrawText(int renderer, String text, int start, int end,
            float x, float y, int bidiFlags, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.208 -0400", hash_original_method = "F496E99287218708FCCC7DBE6218BF00", hash_generated_method = "0B7D0F51B665736DD5C8D78AA7496884")
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //try {
            //nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    //paint.mNativePaint);
        //} finally {
            //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.208 -0400", hash_original_method = "C2D0F05CD306BD6EB45BAEA1052EFD68", hash_generated_method = "E8072F6412FBF0708CCDC684DDEFC2CC")
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.208 -0400", hash_original_method = "E399416700F7228806FC79CB70E6A478", hash_generated_method = "68D8C9D341F43CDFE24109F7E8C46C4D")
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        addTaint(text.getTaint());
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.209 -0400", hash_original_method = "8FBF947B147B7DB5ED34E606F7095E1C", hash_generated_method = "65FB7BDC9C27F0219901EDFDE97ABF84")
    @Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown direction: " + dir);
        } //End block
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawTextRun(mRenderer, text, index, count, contextIndex, contextCount, x, y, dir,
                    paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(contextIndex);
        addTaint(contextCount);
        addTaint(x);
        addTaint(y);
        addTaint(dir);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((index | count | text.length - index - count) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (dir != DIRECTION_LTR && dir != DIRECTION_RTL) {
            //throw new IllegalArgumentException("Unknown direction: " + dir);
        //}
        //int modifiers = setupModifiers(paint);
        //try {
            //nDrawTextRun(mRenderer, text, index, count, contextIndex, contextCount, x, y, dir,
                    //paint.mNativePaint);
        //} finally {
            //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        //}
    }

    
    private static void nDrawTextRun(int renderer, char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir, int nativePaint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.210 -0400", hash_original_method = "7904538C4B6BCEBBAA348BC3E2FD272F", hash_generated_method = "3D9E051969A9492B338777FF2EDF4A07")
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd,
            float x, float y, int dir, Paint paint) {
        {
            boolean var5121ADA1DFFE288F77E0A77339FFD85F_1849004487 = ((start | end | end - start | text.length() - end) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int modifiers = setupModifiers(paint);
        try 
        {
            int flags;
            flags = 0;
            flags = 1;
            {
                nDrawTextRun(mRenderer, text.toString(), start, end, contextStart,
                        contextEnd, x, y, flags, paint.mNativePaint);
            } //End block
            {
                ((GraphicsOperations) text).drawTextRun(this, start, end,
                        contextStart, contextEnd, x, y, flags, paint);
            } //End block
            {
                int contextLen = contextEnd - contextStart;
                int len = end - start;
                char[] buf = TemporaryBuffer.obtain(contextLen);
                TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
                nDrawTextRun(mRenderer, buf, start - contextStart, len, 0, contextLen,
                        x, y, flags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            } //End block
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(x);
        addTaint(y);
        addTaint(dir);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static void nDrawTextRun(int renderer, String text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int flags, int nativePaint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.211 -0400", hash_original_method = "7C5BB6E42A47B8FFC1224CB48EC5DC66", hash_generated_method = "B8AD1C1FAE2C4B6BF26DC49B7C01AC46")
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        addTaint(mode.getTaint());
        addTaint(vertexCount);
        addTaint(verts[0]);
        addTaint(vertOffset);
        addTaint(texs[0]);
        addTaint(texOffset);
        addTaint(colors[0]);
        addTaint(colorOffset);
        addTaint(indices[0]);
        addTaint(indexOffset);
        addTaint(indexCount);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.212 -0400", hash_original_method = "5D6688C2A74D4FFF4670B4EAAE2F407B", hash_generated_method = "EFDECCF4FDBB5C44532552F83F67A4C3")
    private int setupModifiers(Bitmap b, Paint paint) {
        {
            boolean varE8F20F871D48D5163C8F27A746DD70EB_1110344281 = (b.getConfig() == Bitmap.Config.ALPHA_8);
            {
                int var0B5730C30DDBF6EECCE639F4E564849D_981121458 = (setupModifiers(paint));
            } //End block
        } //End collapsed parenthetic
        final ColorFilter filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
        } //End block
        addTaint(b.getTaint());
        addTaint(paint.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365219367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365219367;
        // ---------- Original Method ----------
        //if (b.getConfig() == Bitmap.Config.ALPHA_8) {
            //return setupModifiers(paint);
        //}
        //final ColorFilter filter = paint.getColorFilter();
        //if (filter != null) {
            //nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            //return MODIFIER_COLOR_FILTER;
        //}
        //return MODIFIER_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.213 -0400", hash_original_method = "7663D59B2E312EB2A24D959BD08A0BC2", hash_generated_method = "79209B596A5238AB171A833AE7118653")
    private int setupModifiers(Paint paint) {
        int modifiers = MODIFIER_NONE;
        {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy,
                    paint.shadowColor);
            modifiers |= MODIFIER_SHADOW;
        } //End block
        final Shader shader = paint.getShader();
        {
            nSetupShader(mRenderer, shader.native_shader);
            modifiers |= MODIFIER_SHADER;
        } //End block
        final ColorFilter filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            modifiers |= MODIFIER_COLOR_FILTER;
        } //End block
        addTaint(paint.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312846659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312846659;
        // ---------- Original Method ----------
        //int modifiers = MODIFIER_NONE;
        //if (paint.hasShadow) {
            //nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy,
                    //paint.shadowColor);
            //modifiers |= MODIFIER_SHADOW;
        //}
        //final Shader shader = paint.getShader();
        //if (shader != null) {
            //nSetupShader(mRenderer, shader.native_shader);
            //modifiers |= MODIFIER_SHADER;
        //}
        //final ColorFilter filter = paint.getColorFilter();
        //if (filter != null) {
            //nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            //modifiers |= MODIFIER_COLOR_FILTER;
        //}
        //return modifiers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.213 -0400", hash_original_method = "8D8D130B420F7BDB77245347422EB674", hash_generated_method = "06E602FBECE85CBE0F3F24219CEA9654")
    private int setupColorFilter(Paint paint) {
        final ColorFilter filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
        } //End block
        addTaint(paint.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406958747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406958747;
        // ---------- Original Method ----------
        //final ColorFilter filter = paint.getColorFilter();
        //if (filter != null) {
            //nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            //return MODIFIER_COLOR_FILTER;
        //}
        //return MODIFIER_NONE;
    }

    
    private static void nSetupShader(int renderer, int shader) {
    }

    
    private static void nSetupColorFilter(int renderer, int colorFilter) {
    }

    
    private static void nSetupShadow(int renderer, float radius,
            float dx, float dy, int color) {
    }

    
    private static void nResetModifiers(int renderer, int modifiers) {
    }

    
    private static final class CanvasFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.214 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

        private int mRenderer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.214 -0400", hash_original_method = "FD0EABF3A28C8F1A6C7AE1792F2A951E", hash_generated_method = "F4CE774395766560B3604C2271BA47E5")
        public  CanvasFinalizer(int renderer) {
            mRenderer = renderer;
            // ---------- Original Method ----------
            //mRenderer = renderer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_method = "98F8E6E4208DCA7352053ED1AE5E9232", hash_generated_method = "172B7210461BDF8CBEDEDD56AE7B7486")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                nDestroyRenderer(mRenderer);
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //nDestroyRenderer(mRenderer);
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "724AEEA405FC9CF2CE47243A92797113", hash_generated_field = "E2BA09F8DF55E2B4054F568E93987B59")

    private static final int MODIFIER_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "94B729010A95D20E8C197B93E2E6F8D5", hash_generated_field = "F3A096D0EBF980761DC223D5B61BA142")

    private static final int MODIFIER_SHADOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "0CA6B43DD1E03498AF4D707A3E3A166E", hash_generated_field = "A17A6835293DC1FAD5B4BD9C6992B819")

    private static final int MODIFIER_SHADER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "8F247A4C1EFB8B21D56F5A549AF04510", hash_generated_field = "2EFB036221198641F88AC422E6AE703C")

    private static final int MODIFIER_COLOR_FILTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "311BEA3B2ABE4D5421B92A22977E6ED9", hash_generated_field = "00CB76E41029EE5E99449BE03B14A2C4")

    private static boolean sIsAvailable = nIsAvailable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "2D3E4E15F2A351552D65553739390E48", hash_generated_field = "ABDEA563561F2E851E5FA87E2946EA62")

    public static final int FLUSH_CACHES_LAYERS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "CC12B1F5538FD6E6A924A110A43464C3", hash_generated_field = "862324F027832C57FCA1F817DF8CFB81")

    public static final int FLUSH_CACHES_MODERATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.215 -0400", hash_original_field = "3137DA4124C142EF7060FF3E7E058DC0", hash_generated_field = "868D2688FA6966D15281F70A2C218ADD")

    public static final int FLUSH_CACHES_FULL = 2;
}

