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
    private boolean mOpaque;
    private int mRenderer;
    @SuppressWarnings({"unused", "FieldCanBeLocal"}) private CanvasFinalizer mFinalizer;
    private int mWidth;
    private int mHeight;
    private float[] mPoint = new float[2];
    private float[] mLine = new float[4];
    private Rect mClipBounds = new Rect();
    private DrawFilter mFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.607 -0400", hash_original_method = "E61B8AD2F95A2B414E32399D6E0EB15F", hash_generated_method = "788A3269FA8887CFF6D34B2711928C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GLES20Canvas(boolean translucent) {
        this(false, translucent);
        dsTaint.addTaint(translucent);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.608 -0400", hash_original_method = "7F059AE8F3F932B35FF16ED888919AA8", hash_generated_method = "36A993BCF5D92E89D4468F7EC1E233F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GLES20Canvas(int layer, boolean translucent) {
        dsTaint.addTaint(layer);
        dsTaint.addTaint(translucent);
        mOpaque = !translucent;
        mRenderer = nCreateLayerRenderer(layer);
        setupFinalizer();
        // ---------- Original Method ----------
        //mOpaque = !translucent;
        //mRenderer = nCreateLayerRenderer(layer);
        //setupFinalizer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.608 -0400", hash_original_method = "E76C4C3F056A713824BBE7237B891059", hash_generated_method = "8F7B1B6F9D2D1116CDDB69E6DF2596FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GLES20Canvas(boolean record, boolean translucent) {
        dsTaint.addTaint(record);
        dsTaint.addTaint(translucent);
        mOpaque = !translucent;
        {
            mRenderer = nCreateDisplayListRenderer();
        } //End block
        {
            mRenderer = nCreateRenderer();
        } //End block
        setupFinalizer();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.608 -0400", hash_original_method = "C5F1546049F1B2879B50EF00176E7660", hash_generated_method = "0C9C5F2865E1946BB687D321E4EF73B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.609 -0400", hash_original_method = "DC942AC5C00E84A83A7A0337B1608CAB", hash_generated_method = "E424FF35B49ED518F1C9932756CF66A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.611 -0400", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "7C72ECFFEE2EF0C99162C696A7785AE5")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOpaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.611 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "FF8625F14463300FC0D7C5D94ED9D5D9")
    @DSModeled(DSC.SAFE)
    @Override
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.611 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "024D25F9688CED51F2A70948EBB1D19F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.611 -0400", hash_original_method = "10F69D1300E55A44C724BA9496871588", hash_generated_method = "8818958449DC8CECDDAB276D58F8F501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getMaximumBitmapWidth() {
        int var2F82E860F1E12659F23C0B40B403A9CB_1801981216 = (nGetMaximumTextureWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nGetMaximumTextureWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.612 -0400", hash_original_method = "A5ADDC40BA4D92830B9288340B890F82", hash_generated_method = "42B4875B69FF624B73FD680A015BE712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getMaximumBitmapHeight() {
        int var1BBF2D527FD9D576845B61C43DC1364E_1727261588 = (nGetMaximumTextureHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nGetMaximumTextureHeight();
    }

    
        private static int nGetMaximumTextureWidth() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nGetMaximumTextureHeight() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.612 -0400", hash_original_method = "3FE83BE893B91EF457CAAB97151B4DC3", hash_generated_method = "A6D74B416F438F732C94A3BEE0D02727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setViewport(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.619 -0400", hash_original_method = "9B095EEB0FC45774066EB055E8D05D05", hash_generated_method = "DA882B9839CCDDBC5415DEE808A8D8FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void onPreDraw(Rect dirty) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dirty.dsTaint);
        {
            nPrepareDirty(mRenderer, dirty.left, dirty.top, dirty.right, dirty.bottom, mOpaque);
        } //End block
        {
            nPrepare(mRenderer, mOpaque);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.620 -0400", hash_original_method = "7365F42EBD4B3D862109C8AFB45818F1", hash_generated_method = "D28DBD24898E379BFD423F6D4D12570A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void onPostDraw() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        nFinish(mRenderer);
        // ---------- Original Method ----------
        //nFinish(mRenderer);
    }

    
        private static void nFinish(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.621 -0400", hash_original_method = "D585DC5373E63EDA28C11B713D8E1A5B", hash_generated_method = "FF5BC08A7644C2E885C2E6DCE81BC7CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean callDrawGLFunction(int drawGLFunction) {
        dsTaint.addTaint(drawGLFunction);
        boolean varC4A19E2A6C6B767935A813F45844EA3B_903720537 = (nCallDrawGLFunction(mRenderer, drawGLFunction));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.622 -0400", hash_original_method = "B6A785707CFBE1E38AD4FE8A1D6625FF", hash_generated_method = "26DC396EF788B3669F59DE95FDD3A3CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getDisplayList(int displayList) {
        dsTaint.addTaint(displayList);
        int varCBB832023A69ED9BB808A7FE776E9BD9_683190907 = (nGetDisplayList(mRenderer, displayList));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.623 -0400", hash_original_method = "444FDEED71E94CFCE2A65CC1E400505B", hash_generated_method = "A609495E0A25DDCF721419E2C6D0781F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(displayList.dsTaint);
        dsTaint.addTaint(dirty.dsTaint);
        boolean var21370983C4F053CE0631C1001824FECB_1822420218 = (nDrawDisplayList(mRenderer,
                ((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nDrawDisplayList(mRenderer,
                //((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty);
    }

    
        private static boolean nDrawDisplayList(int renderer, int displayList,
            int width, int height, Rect dirty) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.623 -0400", hash_original_method = "5B863FAF56BDA796D9647970A297D545", hash_generated_method = "73CCC5CFB8D5A516F2D5938EE6D95961")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void outputDisplayList(DisplayList displayList) {
        dsTaint.addTaint(displayList.dsTaint);
        nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
        // ---------- Original Method ----------
        //nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
    }

    
        private static void nOutputDisplayList(int renderer, int displayList) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.624 -0400", hash_original_method = "34690C8D247D9A973C4DB94AE9D7C53D", hash_generated_method = "E662C9A57ED2AB115295FDC23825E43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint) {
        dsTaint.addTaint(layer.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        GLES20Layer glLayer;
        glLayer = (GLES20Layer) layer;
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
        nResetModifiers(mRenderer, modifier);
        // ---------- Original Method ----------
        //final GLES20Layer glLayer = (GLES20Layer) layer;
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    
        private static void nDrawLayer(int renderer, int layer, float x, float y, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.624 -0400", hash_original_method = "2CAEF0DDE58BE10FAAA9AA0E667CCD64", hash_generated_method = "BA861453510B5BC8D04AD58E7A1553A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void interrupt() {
        nInterrupt(mRenderer);
        // ---------- Original Method ----------
        //nInterrupt(mRenderer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.624 -0400", hash_original_method = "C365B4BBFEB4F0EDD5006A765220696B", hash_generated_method = "1C80A41B36E63E43CCFBDD0716C47088")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void resume() {
        nResume(mRenderer);
        // ---------- Original Method ----------
        //nResume(mRenderer);
    }

    
        private static void nInterrupt(int renderer) {
    }

    
        private static void nResume(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.624 -0400", hash_original_method = "CD9590925AA701F1E39AE88CF6AE97E7", hash_generated_method = "2ED2513213A47419F0CCC9D65912F322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipPath(Path path) {
        dsTaint.addTaint(path.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.625 -0400", hash_original_method = "A0322959331EF06FDECE706338820D13", hash_generated_method = "D9ED5879471523EDA60F0C7EAD5F927E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipPath(Path path, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(path.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.625 -0400", hash_original_method = "3AC948804DA1E718A76D8B221FEACE24", hash_generated_method = "D6283E1334244CD740D3BD7F7BF2FDD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean var5AEDEF262D6E77628C31CFE063BA37CC_1187641934 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    
        private static boolean nClipRect(int renderer, float left, float top,
            float right, float bottom, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.625 -0400", hash_original_method = "CF0F08AE677C71FBDBDD5FF973518EEC", hash_generated_method = "2673C722039E5E4A737F5AA5B8FF751D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean varEAE2AD84DDACC0D8F9E8CB54A9C56C43_1080722183 = (nClipRect(mRenderer, left, top, right, bottom, op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.625 -0400", hash_original_method = "3911A8B4E2CBFCB889327A4F77A9CAF7", hash_generated_method = "E1DF7E664358D5A1C8C47CB6A79559A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean var5AEDEF262D6E77628C31CFE063BA37CC_517814239 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    
        private static boolean nClipRect(int renderer, int left, int top, int right, int bottom,
            int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.626 -0400", hash_original_method = "C5507A7F3855C8C6C63565CD78400CEB", hash_generated_method = "12311F6D6ADBDE937A7B74753B05BD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean var20B4B81DA2D8103CA7CA51BA49BE0DD0_1139924458 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //Region.Op.INTERSECT.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.626 -0400", hash_original_method = "CE1C58CF7145731A4EAE6ABB1C090975", hash_generated_method = "9C32CC571E40BA387971EB1C7FDB1C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(Rect rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varF4CB4A50501C143AE1ED2F868AC9C184_1318299416 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.626 -0400", hash_original_method = "82CE8198F83847EB9950BBA97A14CB45", hash_generated_method = "ED8599F9CBE333AF9B35A860D137668A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(RectF rect) {
        dsTaint.addTaint(rect.dsTaint);
        boolean var20B4B81DA2D8103CA7CA51BA49BE0DD0_2005099786 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //Region.Op.INTERSECT.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.626 -0400", hash_original_method = "84F2B877854C623DFB4ED57554605946", hash_generated_method = "BD650A58E4158C5F3D44D41E7FD2CA30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRect(RectF rect, Region.Op op) {
        dsTaint.addTaint(op.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean varF4CB4A50501C143AE1ED2F868AC9C184_1694854433 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.627 -0400", hash_original_method = "668D615301DC55EDCE9C8FA044FF5F71", hash_generated_method = "C9DBE3739EFB596E3DA7319C7DC097E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.627 -0400", hash_original_method = "9554359F0ECC8D3364C9D02F1B6C0A6E", hash_generated_method = "475FA83BB6169611FEA399588144D7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clipRegion(Region region, Region.Op op) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(op.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.627 -0400", hash_original_method = "5A157FCBBF6BAEFB3D0D6DDEEF98EB76", hash_generated_method = "1BF3650307338666208CFEB07BCA379E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getClipBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        boolean varCA244AE61DE6F3A03B7536F19E7E331E_493320456 = (nGetClipBounds(mRenderer, bounds));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nGetClipBounds(mRenderer, bounds);
    }

    
        private static boolean nGetClipBounds(int renderer, Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.627 -0400", hash_original_method = "0662E9735A64886F23067D669F3F560C", hash_generated_method = "5D2832223F5801C1BC72801574D60229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean quickReject(float left, float top, float right, float bottom, EdgeType type) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean var0F31BC06DBEC4B76A6CCB17691BE7DA8_1113741093 = (nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt);
    }

    
        private static boolean nQuickReject(int renderer, float left, float top,
            float right, float bottom, int edge) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.628 -0400", hash_original_method = "866F13730ACFD67020DA883631339738", hash_generated_method = "2C6989C1F466C19A3BFFCA63C213E779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean quickReject(Path path, EdgeType type) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(type.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.628 -0400", hash_original_method = "0E7313D794F0C2C284156675C98816BB", hash_generated_method = "5C60F088A6724B828B9C99376C7A1327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean quickReject(RectF rect, EdgeType type) {
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        boolean var446DE569437F7D1782E011E7DFACF532_165103682 = (quickReject(rect.left, rect.top, rect.right, rect.bottom, type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return quickReject(rect.left, rect.top, rect.right, rect.bottom, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.628 -0400", hash_original_method = "D702D49D0CBA8DAFFC483E145A7D155B", hash_generated_method = "EDE68E79656CD400795B010FE94582C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void translate(float dx, float dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        nTranslate(mRenderer, dx, dy);
        // ---------- Original Method ----------
        //if (dx != 0.0f || dy != 0.0f) nTranslate(mRenderer, dx, dy);
    }

    
        private static void nTranslate(int renderer, float dx, float dy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.629 -0400", hash_original_method = "B4BEAF66CD344F6FBAA1A7BCA9EAC51C", hash_generated_method = "7FA178779B120E6F17960B328E88BD18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void skew(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        nSkew(mRenderer, sx, sy);
        // ---------- Original Method ----------
        //nSkew(mRenderer, sx, sy);
    }

    
        private static void nSkew(int renderer, float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.629 -0400", hash_original_method = "088A2140F7946F7E1F87C60185C75E3A", hash_generated_method = "C6F47F53CE59A83D2AA3A1560FA9676B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void rotate(float degrees) {
        dsTaint.addTaint(degrees);
        nRotate(mRenderer, degrees);
        // ---------- Original Method ----------
        //nRotate(mRenderer, degrees);
    }

    
        private static void nRotate(int renderer, float degrees) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.629 -0400", hash_original_method = "407ACB57F0B4398889DAE0D23801B26B", hash_generated_method = "751BDB4B7CCAFA2FD5C9FB6FF13BD84F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void scale(float sx, float sy) {
        dsTaint.addTaint(sy);
        dsTaint.addTaint(sx);
        nScale(mRenderer, sx, sy);
        // ---------- Original Method ----------
        //nScale(mRenderer, sx, sy);
    }

    
        private static void nScale(int renderer, float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.629 -0400", hash_original_method = "F6D59AD1FAE97EC22EF86A1DF6443B3F", hash_generated_method = "6BBAF5A4F7DB8AA9C8C3482B95058261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        nSetMatrix(mRenderer, matrix.native_instance);
        // ---------- Original Method ----------
        //nSetMatrix(mRenderer, matrix.native_instance);
    }

    
        private static void nSetMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.630 -0400", hash_original_method = "5C2AB9AC8E62FE145634A1140AF6AF7A", hash_generated_method = "814500C3F9D48725AAEE46CB7C28F482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        nGetMatrix(mRenderer, matrix.native_instance);
        // ---------- Original Method ----------
        //nGetMatrix(mRenderer, matrix.native_instance);
    }

    
        private static void nGetMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.631 -0400", hash_original_method = "D981C9A8CE9E8AB948A57E105C909748", hash_generated_method = "2487D48312DD1551D37BB9DFC5A5FB8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void concat(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        nConcatMatrix(mRenderer, matrix.native_instance);
        // ---------- Original Method ----------
        //nConcatMatrix(mRenderer, matrix.native_instance);
    }

    
        private static void nConcatMatrix(int renderer, int matrix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.632 -0400", hash_original_method = "7EFF2592C3C6BD5E4F13755A0D5399A0", hash_generated_method = "C8AD186B2576C69FB1D485AE9D17FC2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int save() {
        int varF2C17D2E97D5ED631A8D7EEE74944094_516344082 = (nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.632 -0400", hash_original_method = "F50C3BBFE7BD2C9D29BCAB4C8FE567F6", hash_generated_method = "5539947B6E1E18AE00A31C52B4B22EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int save(int saveFlags) {
        dsTaint.addTaint(saveFlags);
        int var2A3CE8B1D9F9FA715D89281510DCFCB9_789035473 = (nSave(mRenderer, saveFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nSave(mRenderer, saveFlags);
    }

    
        private static int nSave(int renderer, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.632 -0400", hash_original_method = "9DF5A937336C76576E5F634C144FC48D", hash_generated_method = "F0F6D460DAF94855E320C1FB23739604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        {
            int var20A869D74EDE832F843CC7BD4DB8A988_1461855373 = (saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, paint, saveFlags));
        } //End block
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        int count;
        count = nSaveLayer(mRenderer, nativePaint, saveFlags);
        nResetModifiers(mRenderer, modifier);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.632 -0400", hash_original_method = "E794596E5060868E9256D6234D184C09", hash_generated_method = "7D7605E2DD333EDE983CF8C10B1C8D0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint,
            int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        {
            int modifier;
            modifier = setupColorFilter(paint);
            modifier = MODIFIER_NONE;
            int nativePaint;
            nativePaint = 0;
            nativePaint = paint.mNativePaint;
            int count;
            count = nSaveLayer(mRenderer, left, top, right, bottom, nativePaint, saveFlags);
            nResetModifiers(mRenderer, modifier);
        } //End block
        int varEA6155209B327E6D6A26296B56FB2AC5_1511517420 = (save(saveFlags));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.633 -0400", hash_original_method = "E4AB6B80C5EF0D5B797D753415FED0BE", hash_generated_method = "53146338F0FFB4A3AE0B0D1FBD219DED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(bounds.dsTaint);
        dsTaint.addTaint(alpha);
        {
            int varFB0B372D7BDA6865AFF768ED959BAEF6_411390798 = (saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom,
                    alpha, saveFlags));
        } //End block
        int varCFD03E3328DC4C00BBEC0CCC6AD112E5_1895168741 = (nSaveLayerAlpha(mRenderer, alpha, saveFlags));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.633 -0400", hash_original_method = "B4AB4565F10B041D742F1796C47ECB95", hash_generated_method = "2F4C75C6BA0ABE173F5AD088F55CBA87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha,
            int saveFlags) {
        dsTaint.addTaint(saveFlags);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        {
            int var109591026B19EDE75417DB7AF33A11FA_1075446395 = (nSaveLayerAlpha(mRenderer, left, top, right, bottom, alpha, saveFlags));
        } //End block
        int varEA6155209B327E6D6A26296B56FB2AC5_1167804295 = (save(saveFlags));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.633 -0400", hash_original_method = "C18753FB8460844761E485A3B07AB085", hash_generated_method = "70D1825D14CEDE923274F8D7C79BA367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void restore() {
        nRestore(mRenderer);
        // ---------- Original Method ----------
        //nRestore(mRenderer);
    }

    
        private static void nRestore(int renderer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.634 -0400", hash_original_method = "03029795119CF4F7F4374FF9CDD913F1", hash_generated_method = "979C659643C9EACA2186E248B19F2D8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void restoreToCount(int saveCount) {
        dsTaint.addTaint(saveCount);
        nRestoreToCount(mRenderer, saveCount);
        // ---------- Original Method ----------
        //nRestoreToCount(mRenderer, saveCount);
    }

    
        private static void nRestoreToCount(int renderer, int saveCount) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.634 -0400", hash_original_method = "5171A9EFFCF2464453072A29F0BC817F", hash_generated_method = "8349C4145AF0884C3A739C1376C73C51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getSaveCount() {
        int varBD59B9383972492C3C1BFF0B7946F4DD_1126105010 = (nGetSaveCount(mRenderer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nGetSaveCount(mRenderer);
    }

    
        private static int nGetSaveCount(int renderer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.634 -0400", hash_original_method = "846B7706B193B695840103C92096214E", hash_generated_method = "5297E6D1AF3E56391A276986632DD7B9")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDrawFilter(DrawFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        // ---------- Original Method ----------
        //mFilter = filter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.634 -0400", hash_original_method = "00C808EC6F25CC6E1FA57C10F69CA13D", hash_generated_method = "B90BA229E1E82AE0B9817C18F08F0975")
    @DSModeled(DSC.SAFE)
    @Override
    public DrawFilter getDrawFilter() {
        return (DrawFilter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.635 -0400", hash_original_method = "1B5F3778D027ED2D7C875DF279109721", hash_generated_method = "29A682E9F64CB414D429CDD322B67E49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter,
            Paint paint) {
        dsTaint.addTaint(startAngle);
        dsTaint.addTaint(useCenter);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(sweepAngle);
        dsTaint.addTaint(oval.dsTaint);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawArc(mRenderer, oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle,
                useCenter, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.635 -0400", hash_original_method = "AAC237D01F9254CC358C9D52B0A20AD9", hash_generated_method = "CB2200AABB27C0A1301B717655373A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawARGB(int a, int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(a);
        drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        // ---------- Original Method ----------
        //drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.635 -0400", hash_original_method = "3E288E14B7CE68A819334B0A90162954", hash_generated_method = "A510936E84454AB2996225D403C8B68E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        dsTaint.addTaint(chunks[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, chunks,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        nResetModifiers(mRenderer, modifier);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.636 -0400", hash_original_method = "BF78CEE5A5D5A0B7000D42B8D7CD12A6", hash_generated_method = "2974BDBBFDAAFE37D7879C578E86C861")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(top);
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawBitmap(
            int renderer, int bitmap, byte[] buffer, float left, float top, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.636 -0400", hash_original_method = "7A23E114FF3FC414FFADAB9162210E17", hash_generated_method = "E24670B769A5C88EEDEAD4547B5B639F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer,
                matrix.native_instance, nativePaint);
        nResetModifiers(mRenderer, modifiers);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.636 -0400", hash_original_method = "025B89D3F15CD9670FC3D74B91AB5D58", hash_generated_method = "2D4DB365E02E72D33DF239B8D2B81DEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        int left, top, right, bottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.637 -0400", hash_original_method = "18A7A5D5D5C8B881DFD85E47F7DA3439", hash_generated_method = "DCE10EAF528386D26A41109E80D13439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        int modifiers;
        modifiers = setupModifiers(bitmap, paint);
        modifiers = MODIFIER_NONE;
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        float left, top, right, bottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.637 -0400", hash_original_method = "9B6F84B3164E22399F0F518F30D6F56B", hash_generated_method = "BA01A22F23A2BFE0F5E1995E2725C66B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y,
            int width, int height, boolean hasAlpha, Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int modifier;
        modifier = setupColorFilter(paint);
        modifier = MODIFIER_NONE;
        Bitmap.Config config;
        config = Bitmap.Config.ARGB_8888;
        config = Bitmap.Config.RGB_565;
        Bitmap b;
        b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        int nativePaint;
        nativePaint = 0;
        nativePaint = paint.mNativePaint;
        nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        b.recycle();
        nResetModifiers(mRenderer, modifier);
        // ---------- Original Method ----------
        //int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        //final Bitmap.Config config = hasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        //final Bitmap b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        //final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        //nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        //b.recycle();
        //if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.637 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "250EB4125139D5E2735832E1BDE7ED8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
            int width, int height, boolean hasAlpha, Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
        // ---------- Original Method ----------
        //drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.638 -0400", hash_original_method = "B49032D10E62987D37B2D43027E8B7B3", hash_generated_method = "020E3C57FAC0A7B3AED274E236AF5AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.638 -0400", hash_original_method = "3CC575BC6DB3F469750010B2B8CAC81C", hash_generated_method = "B47E460E7E62DF58D701200D13C4BB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(cx);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawCircle(int renderer, float cx, float cy,
            float radius, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.639 -0400", hash_original_method = "4F7ABDA5E981B914379787693CC10165", hash_generated_method = "37C3F6890CF46B349C36A422981F001A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawColor(int color) {
        dsTaint.addTaint(color);
        drawColor(color, PorterDuff.Mode.SRC_OVER);
        // ---------- Original Method ----------
        //drawColor(color, PorterDuff.Mode.SRC_OVER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.639 -0400", hash_original_method = "CF35C7302232BF0C4B60CFA92B96D407", hash_generated_method = "C5DD7A577BC12C14E551320E2B70E9B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawColor(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        nDrawColor(mRenderer, color, mode.nativeInt);
        // ---------- Original Method ----------
        //nDrawColor(mRenderer, color, mode.nativeInt);
    }

    
        private static void nDrawColor(int renderer, int color, int mode) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.639 -0400", hash_original_method = "5EABC5A9A71D080A656B11841F718311", hash_generated_method = "C6EFA683E0D0BCAFEBFA6B8B2E511362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(stopX);
        dsTaint.addTaint(stopY);
        dsTaint.addTaint(paint.dsTaint);
        mLine[0] = startX;
        mLine[1] = startY;
        mLine[2] = stopX;
        mLine[3] = stopY;
        drawLines(mLine, 0, 4, paint);
        // ---------- Original Method ----------
        //mLine[0] = startX;
        //mLine[1] = startY;
        //mLine[2] = stopX;
        //mLine[3] = stopY;
        //drawLines(mLine, 0, 4, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.639 -0400", hash_original_method = "CC8F0B4448632DE8A259253A60E2B3F7", hash_generated_method = "BD89FA6F5AAB77C0B17F20B4238EFC4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        } //End block
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawLines(mRenderer, pts, offset, count, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.640 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "4A8DCD3012B6AE0A6E2DFCEB091A6D40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLines(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        drawLines(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.640 -0400", hash_original_method = "3C8333232F307DB00830ADFD9367082C", hash_generated_method = "57FBFE21C2FEAEB9A843A0849EB725A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawOval(RectF oval, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawOval(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.640 -0400", hash_original_method = "F3CEC7F1ABD68352F2A5895BCD8335A7", hash_generated_method = "4078CF6371A83794536E78219576CE42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPaint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        Rect r;
        r = mClipBounds;
        nGetClipBounds(mRenderer, r);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //final Rect r = mClipBounds;
        //nGetClipBounds(mRenderer, r);
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.641 -0400", hash_original_method = "E734C6F1749AB430929BC8490D600517", hash_generated_method = "95AEB1D8F801B51AE4C5E1BEE80D5956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPath(Path path, Paint paint) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        int modifiers;
        modifiers = setupModifiers(paint);
        {
            {
                nDrawRects(mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
            } //End block
        } //End block
        {
            nDrawPath(mRenderer, path.mNativePath, paint.mNativePaint);
        } //End block
        nResetModifiers(mRenderer, modifiers);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.641 -0400", hash_original_method = "2AA9BBA2F44244E312AB57A12DAF658B", hash_generated_method = "F1C5A888E26A0DD337AE9D835F1EE9AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPicture(Picture picture) {
        dsTaint.addTaint(picture.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.641 -0400", hash_original_method = "1202DF046E7699A744E442D410CE2128", hash_generated_method = "52823B410898E003A48C300B83B9040A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPicture(Picture picture, Rect dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.641 -0400", hash_original_method = "CE526B9F8925E416169A22B853086EA4", hash_generated_method = "36A9186319043ECD072EB1B278C0F8D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPicture(Picture picture, RectF dst) {
        dsTaint.addTaint(picture.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.642 -0400", hash_original_method = "711B0E1C295D7644DD171BC7547CDDDA", hash_generated_method = "9344333394187BD9C0C10DE7F6CB3DAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        mPoint[0] = x;
        mPoint[1] = y;
        drawPoints(mPoint, 0, 2, paint);
        // ---------- Original Method ----------
        //mPoint[0] = x;
        //mPoint[1] = y;
        //drawPoints(mPoint, 0, 2, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.642 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "CF48F8A81383E46F77172274496E9BCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        drawPoints(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.642 -0400", hash_original_method = "A6EA0B46F26697457B201A425B5A3171", hash_generated_method = "1421F65F0D56DB92EE19B171A41B90E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawPoints(int renderer, float[] points,
            int offset, int count, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.642 -0400", hash_original_method = "A1D0375AE9DFF68E398CA7F0C8CFDC48", hash_generated_method = "F5024D731A9BC94922F6B142AB49B351")
    @DSModeled(DSC.SAFE)
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.642 -0400", hash_original_method = "2727BD7310EB8AF1CE9C5E69FE8F5F77", hash_generated_method = "CF4B0BD44A257C9E71CA2E2CC362ADB8")
    @DSModeled(DSC.SAFE)
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.643 -0400", hash_original_method = "1D1C68AD886616B8DD56E02894BED97B", hash_generated_method = "B07CBFC91AF8523604BDE44FE6ACB8A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawRect(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.643 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "550D6A3D366D7FE78D0740225ABB6099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(Rect r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.643 -0400", hash_original_method = "73D11F584AEBB7C191086A2FFF4052A9", hash_generated_method = "BF2A092C0C0E6BB10522ECA917C72F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(RectF r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.643 -0400", hash_original_method = "EB9FA3A1182306D8C56FD7B1B2A405F0", hash_generated_method = "8DD88FA9BF6E12CFF81656C8185D25E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRGB(int r, int g, int b) {
        dsTaint.addTaint(g);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        // ---------- Original Method ----------
        //drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.643 -0400", hash_original_method = "F66719DAB9BD4C7CE0890FFA1C26F9F2", hash_generated_method = "DE9B0AEF6A798FD76AFDBAED5473CF73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        int modifiers;
        modifiers = setupModifiers(paint);
        nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                rx, ry, paint.mNativePaint);
        nResetModifiers(mRenderer, modifiers);
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                //rx, ry, paint.mNativePaint);
        //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    
        private static void nDrawRoundRect(int renderer, float left, float top,
            float right, float bottom, float rx, float y, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.644 -0400", hash_original_method = "5B66E40A85BEEB6F8228E5994A513667", hash_generated_method = "6C1C0A6DC89E8A2A2E741ACD311A44E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int modifiers;
        modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, index, count, x, y, paint.mBidiFlags, paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.644 -0400", hash_original_method = "BF4D02798081BBBF8269CD636760F070", hash_generated_method = "A0C1CD376270E7A2420BF0E2BC338381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        int modifiers;
        modifiers = setupModifiers(paint);
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
                char[] buf;
                buf = TemporaryBuffer.obtain(end - start);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.645 -0400", hash_original_method = "53AB28ACA34BAB18CDB1722B92273EEB", hash_generated_method = "815662F21FA1914DF1D5373E1FB91484")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        {
            boolean var9527A5CDD965760192A60A252272F336_912434941 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int modifiers;
        modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, start, end, x, y, paint.mBidiFlags, paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.645 -0400", hash_original_method = "F496E99287218708FCCC7DBE6218BF00", hash_generated_method = "2325B02E957B540F3D9A9B44B9220ABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int modifiers;
        modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
        // ---------- Original Method ----------
        //int modifiers = setupModifiers(paint);
        //try {
            //nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    //paint.mNativePaint);
        //} finally {
            //if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.646 -0400", hash_original_method = "C2D0F05CD306BD6EB45BAEA1052EFD68", hash_generated_method = "99D9AA9D9610F4DF0D6CB60C05812E16")
    @DSModeled(DSC.SAFE)
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.646 -0400", hash_original_method = "E399416700F7228806FC79CB70E6A478", hash_generated_method = "A96A21541F0545C170C75E6EB92CC69E")
    @DSModeled(DSC.SAFE)
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.646 -0400", hash_original_method = "8FBF947B147B7DB5ED34E606F7095E1C", hash_generated_method = "819E74C213BFE59D2B06AFB40FB02703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
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
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown direction: " + dir);
        } //End block
        int modifiers;
        modifiers = setupModifiers(paint);
        try 
        {
            nDrawTextRun(mRenderer, text, index, count, contextIndex, contextCount, x, y, dir,
                    paint.mNativePaint);
        } //End block
        finally 
        {
            nResetModifiers(mRenderer, modifiers);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.647 -0400", hash_original_method = "7904538C4B6BCEBBAA348BC3E2FD272F", hash_generated_method = "811695E6D185C4F19FE85AFA952CB043")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd,
            float x, float y, int dir, Paint paint) {
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
            boolean var5121ADA1DFFE288F77E0A77339FFD85F_663092529 = ((start | end | end - start | text.length() - end) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int modifiers;
        modifiers = setupModifiers(paint);
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
                int contextLen;
                contextLen = contextEnd - contextStart;
                int len;
                len = end - start;
                char[] buf;
                buf = TemporaryBuffer.obtain(contextLen);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void nDrawTextRun(int renderer, String text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int flags, int nativePaint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.647 -0400", hash_original_method = "7C5BB6E42A47B8FFC1224CB48EC5DC66", hash_generated_method = "3B5CD7E1D8AF3FD4E81B8DE87E87CC26")
    @DSModeled(DSC.SAFE)
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
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
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.648 -0400", hash_original_method = "5D6688C2A74D4FFF4670B4EAAE2F407B", hash_generated_method = "BEE89138A6D9EF077A788FE3E52ACD66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int setupModifiers(Bitmap b, Paint paint) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        {
            boolean varE8F20F871D48D5163C8F27A746DD70EB_718488829 = (b.getConfig() == Bitmap.Config.ALPHA_8);
            {
                int var0B5730C30DDBF6EECCE639F4E564849D_937610955 = (setupModifiers(paint));
            } //End block
        } //End collapsed parenthetic
        ColorFilter filter;
        filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.648 -0400", hash_original_method = "7663D59B2E312EB2A24D959BD08A0BC2", hash_generated_method = "C7C32233C0A4C2AB7957B5F9C6399BF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int setupModifiers(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        int modifiers;
        modifiers = MODIFIER_NONE;
        {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy,
                    paint.shadowColor);
            modifiers |= MODIFIER_SHADOW;
        } //End block
        Shader shader;
        shader = paint.getShader();
        {
            nSetupShader(mRenderer, shader.native_shader);
            modifiers |= MODIFIER_SHADER;
        } //End block
        ColorFilter filter;
        filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            modifiers |= MODIFIER_COLOR_FILTER;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.648 -0400", hash_original_method = "8D8D130B420F7BDB77245347422EB674", hash_generated_method = "8AE76C00088345FC6CE7044BE737B2A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int setupColorFilter(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        ColorFilter filter;
        filter = paint.getColorFilter();
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
        } //End block
        return dsTaint.getTaintInt();
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
        private int mRenderer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.649 -0400", hash_original_method = "FD0EABF3A28C8F1A6C7AE1792F2A951E", hash_generated_method = "A92E8E87D11F36DE1A14549F745242CE")
        @DSModeled(DSC.SAFE)
        public CanvasFinalizer(int renderer) {
            dsTaint.addTaint(renderer);
            // ---------- Original Method ----------
            //mRenderer = renderer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.649 -0400", hash_original_method = "98F8E6E4208DCA7352053ED1AE5E9232", hash_generated_method = "172B7210461BDF8CBEDEDD56AE7B7486")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final int MODIFIER_NONE = 0;
    private static final int MODIFIER_SHADOW = 1;
    private static final int MODIFIER_SHADER = 2;
    private static final int MODIFIER_COLOR_FILTER = 4;
    private static boolean sIsAvailable = nIsAvailable();
    public static final int FLUSH_CACHES_LAYERS = 0;
    public static final int FLUSH_CACHES_MODERATE = 1;
    public static final int FLUSH_CACHES_FULL = 2;
}

