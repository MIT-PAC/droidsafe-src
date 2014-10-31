package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import droidsafe.helpers.DSUtils;

class GLES20Canvas extends HardwareCanvas {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nIsAvailable() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.065 -0500", hash_original_method = "E7A6C668061FB4CD360ECD595098BC2E", hash_generated_method = "C227356B089353A74253AFA60F79204A")
    
static boolean isAvailable() {
        return sIsAvailable;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nCreateRenderer() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nCreateLayerRenderer(int layer) {
        //return DSUtils.UNKNOWN_INT;
        return layer;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nCreateDisplayListRenderer() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nResetDisplayListRenderer(int renderer) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDestroyRenderer(int renderer) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int nCreateTextureLayer(boolean opaque, int[] layerInfo) {
        return ((opaque) ? 1 : 0) + layerInfo[0];
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int nCreateLayer(int width, int height, boolean isOpaque, int[] layerInfo) {
        return (width + height + ((isOpaque) ? 1 : 0) + layerInfo[0]);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void nResizeLayer(int layerId, int width, int height, int[] layerInfo) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void nUpdateTextureLayer(int layerId, int width, int height, boolean opaque,
            SurfaceTexture surface) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void nSetTextureLayerTransform(int layerId, int matrix) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void nDestroyLayer(int layerId) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void nDestroyLayerDeferred(int layerId) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static boolean nCopyLayer(int layerId, int bitmap) {
        return ((layerId + bitmap) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nGetMaximumTextureWidth() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nGetMaximumTextureHeight() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetViewport(int renderer, int width, int height) {
    }

    /**
     * Preserves the back buffer of the current surface after a buffer swap.
     * Calling this method sets the EGL_SWAP_BEHAVIOR attribute of the current
     * surface to EGL_BUFFER_PRESERVED. Calling this method requires an EGL
     * config that supports EGL_SWAP_BEHAVIOR_PRESERVED_BIT.
     * 
     * @return True if the swap behavior was successfully changed,
     *         false otherwise.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.166 -0500", hash_original_method = "AE589E28DA0FF19F04E5968FD5B7BCF7", hash_generated_method = "A14F05ED755959656EBBF6F461EF602E")
    
public static boolean preserveBackBuffer() {
        return nPreserveBackBuffer();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nPreserveBackBuffer() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Indicates whether the current surface preserves its back buffer
     * after a buffer swap.
     * 
     * @return True, if the surface's EGL_SWAP_BEHAVIOR is EGL_BUFFER_PRESERVED,
     *         false otherwise
     *         
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.171 -0500", hash_original_method = "C612ABEE1C0679BFBBDBFDD36B58357B", hash_generated_method = "7BC317122D8F42B263139F55F07CA8D6")
    
public static boolean isBackBufferPreserved() {
        return nIsBackBufferPreserved();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nIsBackBufferPreserved() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Disables v-sync. For performance testing only.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.177 -0500", hash_original_method = "E35FF664DA486BBF1CFE86498473FB9B", hash_generated_method = "81AF2D5B35CA402304449ACA5C911EFF")
    
public static void disableVsync() {
        nDisableVsync();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDisableVsync() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nPrepare(int renderer, boolean opaque) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nPrepareDirty(int renderer, int left, int top, int right, int bottom,
            boolean opaque) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nFinish(int renderer) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nCallDrawGLFunction(int renderer, int drawGLFunction) {
        return ((renderer + drawGLFunction) == 1);
        //return DSUtils.UNKNOWN_BOOLEAN;
    }

    /**
     * Flush caches to reclaim as much memory as possible. The amount of memory
     * to reclaim is indicate by the level parameter.
     * 
     * The level can be one of {@link #FLUSH_CACHES_MODERATE} or
     * {@link #FLUSH_CACHES_FULL}.
     * 
     * @param level Hint about the amount of memory to reclaim
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.214 -0500", hash_original_method = "64DF5163CDE8D05C8B8668EA0F566783", hash_generated_method = "1C6280021B1F560C301FE81E9CC168BF")
    
public static void flushCaches(int level) {
        nFlushCaches(level);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nFlushCaches(int level) {
    }

    /**
     * Release all resources associated with the underlying caches. This should
     * only be called after a full flushCaches().
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.220 -0500", hash_original_method = "EB5F19B4C0AA4D04AF76FF39EB0F0F4B", hash_generated_method = "AFAE6958332FA6F822807680023D5132")
    
public static void terminateCaches() {
        nTerminateCaches();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nTerminateCaches() {
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.227 -0500", hash_original_method = "01879F1C2D7CAA7698BDDF85ECCBAF1C", hash_generated_method = "4F0CB17B770997072018FC4D6858B9B1")
    
public static void initCaches() {
        nInitCaches();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nInitCaches() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nGetDisplayList(int renderer, int displayList) {
        return renderer + displayList;
        //return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.240 -0500", hash_original_method = "7797822949EB42761B06A2E6106989AA", hash_generated_method = "D62F0A00880A66791B8FF892C2CD7913")
    
static void destroyDisplayList(int displayList) {
        nDestroyDisplayList(displayList);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDestroyDisplayList(int displayList) {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.246 -0500", hash_original_method = "D2F577F42B579CD03E6A04C3A1E1D45D", hash_generated_method = "F0DB4F4FA09C82D82C0648F5FA1656E5")
    
static int getDisplayListSize(int displayList) {
        return nGetDisplayListSize(displayList);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nGetDisplayListSize(int displayList) {
        //return DSUtils.UNKNOWN_INT;
        return displayList;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nDrawDisplayList(int renderer, int displayList,
            int width, int height, Rect dirty) {
        return  (((renderer + displayList + width + height + dirty.getTaintInt())) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nOutputDisplayList(int renderer, int displayList) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawLayer(int renderer, int layer, float x, float y, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nInterrupt(int renderer) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nResume(int renderer) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nClipRect(int renderer, float left, float top,
            float right, float bottom, int op) {
        //return DSUtils.UNKNOWN_BOOLEAN;

        return ((renderer + left + top + right + bottom + op) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nClipRect(int renderer, int left, int top, int right, int bottom,
            int op) {
        return ((renderer + left + top + right + bottom + op) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nGetClipBounds(int renderer, Rect bounds) {
        return (((renderer + bounds.getTaintInt())) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nQuickReject(int renderer, float left, float top,
            float right, float bottom, int edge) {
        return ((renderer + left + top + right + bottom + edge) == 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nTranslate(int renderer, float dx, float dy) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSkew(int renderer, float sx, float sy) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nRotate(int renderer, float degrees) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nScale(int renderer, float sx, float sy) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetMatrix(int renderer, int matrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nGetMatrix(int renderer, int matrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nConcatMatrix(int renderer, int matrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nSave(int renderer, int flags) {
        return (renderer + flags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nSaveLayer(int renderer, int paint, int saveFlags) {
        //return DSUtils.UNKNOWN_INT;
        return (renderer + paint + saveFlags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nSaveLayer(int renderer, float left, float top,
            float right, float bottom, int paint, int saveFlags) {

        return (int)(renderer + left + top + right + bottom + paint + saveFlags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nSaveLayerAlpha(int renderer, int alpha, int saveFlags) {
        return (int)(renderer + alpha + saveFlags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nSaveLayerAlpha(int renderer, float left, float top, float right,
            float bottom, int alpha, int saveFlags) {
        return (int)(renderer + left + top + right + bottom + alpha + saveFlags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nRestore(int renderer) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nRestoreToCount(int renderer, int saveCount) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nGetSaveCount(int renderer) {
        return renderer;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawArc(int renderer, float left, float top,
            float right, float bottom, float startAngle, float sweepAngle,
            boolean useCenter, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawPatch(int renderer, int bitmap, byte[] buffer, byte[] chunks,
            float left, float top, float right, float bottom, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawBitmap(
            int renderer, int bitmap, byte[] buffer, float left, float top, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buff,
            int matrix, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buffer,
            float srcLeft, float srcTop, float srcRight, float srcBottom,
            float left, float top, float right, float bottom, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawBitmapMesh(int renderer, int bitmap, byte[] buffer,
            int meshWidth, int meshHeight, float[] verts, int vertOffset,
            int[] colors, int colorOffset, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawCircle(int renderer, float cx, float cy,
            float radius, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawColor(int renderer, int color, int mode) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawLines(int renderer, float[] points,
            int offset, int count, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawOval(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawPath(int renderer, int path, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawRects(int renderer, int region, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawPoints(int renderer, float[] points,
            int offset, int count, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawRect(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawRoundRect(int renderer, float left, float top,
            float right, float bottom, float rx, float y, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawText(int renderer, char[] text, int index, int count,
            float x, float y, int bidiFlags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawText(int renderer, String text, int start, int end,
            float x, float y, int bidiFlags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawTextRun(int renderer, char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir, int nativePaint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nDrawTextRun(int renderer, String text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int flags, int nativePaint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetupShader(int renderer, int shader) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetupColorFilter(int renderer, int colorFilter) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetupShadow(int renderer, float radius,
            float dx, float dy, int color) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nResetModifiers(int renderer, int modifiers) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.028 -0500", hash_original_field = "E0A3150F3F38261C8E4D4BE8D4154830", hash_generated_field = "E2BA09F8DF55E2B4054F568E93987B59")

    private static final int MODIFIER_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.030 -0500", hash_original_field = "C02C079833F5743CE69787A66D6BBFFA", hash_generated_field = "F3A096D0EBF980761DC223D5B61BA142")

    private static final int MODIFIER_SHADOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.032 -0500", hash_original_field = "FAFB0184CC1DB23424B5EF449300A51F", hash_generated_field = "A17A6835293DC1FAD5B4BD9C6992B819")

    private static final int MODIFIER_SHADER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.035 -0500", hash_original_field = "985DFD16F77998EB98CFD45F128D7A93", hash_generated_field = "2EFB036221198641F88AC422E6AE703C")

    private static final int MODIFIER_COLOR_FILTER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.063 -0500", hash_original_field = "36F8B3DE9C178F74BA7750FD57882362", hash_generated_field = "00CB76E41029EE5E99449BE03B14A2C4")

    private static boolean sIsAvailable = nIsAvailable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.207 -0500", hash_original_field = "32C97249F3A0E2ADF1033BF680842ABB", hash_generated_field = "DB96BE2CEA794999371A162F27C6B5E6")

    // Memory
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Must match Caches::FlushMode values
     * 
     * @see #flushCaches(int) 
     */
    public static final int FLUSH_CACHES_LAYERS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.209 -0500", hash_original_field = "078747913E38B3982B61AE60D16EC42D", hash_generated_field = "862324F027832C57FCA1F817DF8CFB81")

    public static final int FLUSH_CACHES_MODERATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.212 -0500", hash_original_field = "E935EE0C4FB7441306ED0C867D010686", hash_generated_field = "868D2688FA6966D15281F70A2C218ADD")

    public static final int FLUSH_CACHES_FULL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.037 -0500", hash_original_field = "1A5E1BEFDB0DF6CE4A573A377262DC5D", hash_generated_field = "EB29C468CD6CC66BADB54A0F112750F9")

    private  boolean mOpaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.039 -0500", hash_original_field = "2B452A59440EC392E79D53931F031EDF", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

    private int mRenderer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.043 -0500", hash_original_field = "92E0A3468E5C8A32534FFA55F4EA69E2", hash_generated_field = "BCADEFD6F92410BFE03DA2D57A6A077A")

    // DO NOT overwrite this reference once it is set.
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private CanvasFinalizer mFinalizer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.046 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.048 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.050 -0500", hash_original_field = "CF6BEF09B050EF04D7DAF2E71645B9A2", hash_generated_field = "6791C5CD1248B8A3047AAAB23F781F88")
    
    private final float[] mPoint = new float[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.052 -0500", hash_original_field = "B13B58B4084D8A17811E5403A71954E5", hash_generated_field = "BB2122C190B62908BBEDD5B8E43D320D")

    private final float[] mLine = new float[4];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.054 -0500", hash_original_field = "8AB232A6CE3131F6D9ADAEE4BAB77D3A", hash_generated_field = "49E49C9D9740E032CABA98DD5151CA56")
    
    private final Rect mClipBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.056 -0500", hash_original_field = "E64BC6A401ACB45F89B54F9EA0DDC4A1", hash_generated_field = "7E8B7E1A9144C0D301C8FE334261595B")

    private DrawFilter mFilter;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Creates a canvas to render directly on screen.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.068 -0500", hash_original_method = "E61B8AD2F95A2B414E32399D6E0EB15F", hash_generated_method = "E61B8AD2F95A2B414E32399D6E0EB15F")
    
GLES20Canvas(boolean translucent) {
        this(false, translucent);
    }

    /**
     * Creates a canvas to render into an FBO.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.070 -0500", hash_original_method = "7F059AE8F3F932B35FF16ED888919AA8", hash_generated_method = "7F059AE8F3F932B35FF16ED888919AA8")
    
GLES20Canvas(int layer, boolean translucent) {
        mOpaque = !translucent;
        mRenderer = nCreateLayerRenderer(layer);
        setupFinalizer();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.073 -0500", hash_original_method = "E76C4C3F056A713824BBE7237B891059", hash_generated_method = "723D777EFAD2C8D09A304E2CDBCE6DA6")
    
protected GLES20Canvas(boolean record, boolean translucent) {
        mOpaque = !translucent;

        if (record) {
            mRenderer = nCreateDisplayListRenderer();
        } else {
            mRenderer = nCreateRenderer();
        }

        setupFinalizer();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.075 -0500", hash_original_method = "C5F1546049F1B2879B50EF00176E7660", hash_generated_method = "CDA0E79E0E683E7FDA5851E20C6C51DF")
    
private void setupFinalizer() {
        if (mRenderer == 0) {
            throw new IllegalStateException("Could not create GLES20Canvas renderer");
        } else {
            mFinalizer = new CanvasFinalizer(mRenderer);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.077 -0500", hash_original_method = "DC942AC5C00E84A83A7A0337B1608CAB", hash_generated_method = "CDC984C7919C509BEE73A72EC8463C2B")
    
protected void resetDisplayListRenderer() {
        nResetDisplayListRenderer(mRenderer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Canvas management
    ///////////////////////////////////////////////////////////////////////////

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.140 -0500", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "518AEB549B811D6CF4CF93C40BB21414")
    
@Override
    public boolean isOpaque() {
        return mOpaque;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.142 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "544DCA524D5A67C6D05071F3100B5B3C")
    
@Override
    public int getWidth() {
        return mWidth;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.145 -0500", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "E76548EEA445A2E9D8F83F5D972E0669")
    
@Override
    public int getHeight() {
        return mHeight;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.147 -0500", hash_original_method = "10F69D1300E55A44C724BA9496871588", hash_generated_method = "65D18FF7E8486F50C37E7AD31D6D07F6")
    
@Override
    public int getMaximumBitmapWidth() {
        return nGetMaximumTextureWidth();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.149 -0500", hash_original_method = "A5ADDC40BA4D92830B9288340B890F82", hash_generated_method = "53BB15B9BD2CFEFAEBBACF64DDD1AB32")
    
@Override
    public int getMaximumBitmapHeight() {
        return nGetMaximumTextureHeight();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Setup
    ///////////////////////////////////////////////////////////////////////////

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.159 -0500", hash_original_method = "3FE83BE893B91EF457CAAB97151B4DC3", hash_generated_method = "15D9B8A31D0161E432F50759F79644BC")
    
@Override
    public void setViewport(int width, int height) {
        mWidth = width;
        mHeight = height;

        nSetViewport(mRenderer, width, height);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.185 -0500", hash_original_method = "9B095EEB0FC45774066EB055E8D05D05", hash_generated_method = "15DF7A375DF542F70B100F995D281262")
    
@Override
    void onPreDraw(Rect dirty) {
        if (dirty != null) {
            nPrepareDirty(mRenderer, dirty.left, dirty.top, dirty.right, dirty.bottom, mOpaque);
        } else {
            nPrepare(mRenderer, mOpaque);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.195 -0500", hash_original_method = "7365F42EBD4B3D862109C8AFB45818F1", hash_generated_method = "83997BA3E0C31EEE60788DC5B85F15A5")
    
@Override
    void onPostDraw() {
        nFinish(mRenderer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.201 -0500", hash_original_method = "D585DC5373E63EDA28C11B713D8E1A5B", hash_generated_method = "4BEF5202D9F7F06A1BD74E674F730A0C")
    
@Override
    public boolean callDrawGLFunction(int drawGLFunction) {
        return nCallDrawGLFunction(mRenderer, drawGLFunction);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // Display list
    ///////////////////////////////////////////////////////////////////////////

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.232 -0500", hash_original_method = "B6A785707CFBE1E38AD4FE8A1D6625FF", hash_generated_method = "B6A785707CFBE1E38AD4FE8A1D6625FF")
    
int getDisplayList(int displayList) {
        return nGetDisplayList(mRenderer, displayList);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.252 -0500", hash_original_method = "444FDEED71E94CFCE2A65CC1E400505B", hash_generated_method = "1EF8801C9577BF7348E06FF6CB0D5982")
    
@Override
    public boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty) {
        return nDrawDisplayList(mRenderer,
                ((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.258 -0500", hash_original_method = "5B863FAF56BDA796D9647970A297D545", hash_generated_method = "902955F17374AD1721E505C1CBDC03A3")
    
@Override
    void outputDisplayList(DisplayList displayList) {
        nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
    }

    ///////////////////////////////////////////////////////////////////////////
    // Hardware layer
    ///////////////////////////////////////////////////////////////////////////
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.264 -0500", hash_original_method = "34690C8D247D9A973C4DB94AE9D7C53D", hash_generated_method = "34690C8D247D9A973C4DB94AE9D7C53D")
    
void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint) {
        final GLES20Layer glLayer = (GLES20Layer) layer;
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
        if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.271 -0500", hash_original_method = "2CAEF0DDE58BE10FAAA9AA0E667CCD64", hash_generated_method = "2CAEF0DDE58BE10FAAA9AA0E667CCD64")
    
void interrupt() {
        nInterrupt(mRenderer);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.273 -0500", hash_original_method = "C365B4BBFEB4F0EDD5006A765220696B", hash_generated_method = "C365B4BBFEB4F0EDD5006A765220696B")
    
void resume() {
        nResume(mRenderer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Clipping
    ///////////////////////////////////////////////////////////////////////////

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.284 -0500", hash_original_method = "CD9590925AA701F1E39AE88CF6AE97E7", hash_generated_method = "9D8E9B6B4BC7EAE2E4B44F2544E65072")
    
@Override
    public boolean clipPath(Path path) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.286 -0500", hash_original_method = "A0322959331EF06FDECE706338820D13", hash_generated_method = "D778E0BBC9D7830D84D64FA62D826E60")
    
@Override
    public boolean clipPath(Path path, Region.Op op) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.288 -0500", hash_original_method = "3AC948804DA1E718A76D8B221FEACE24", hash_generated_method = "64D217940D88C79C47B9B0BFE154FE27")
    
@Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.295 -0500", hash_original_method = "CF0F08AE677C71FBDBDD5FF973518EEC", hash_generated_method = "8B096CC245E5FCF097D508095C8217B8")
    
@Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        return nClipRect(mRenderer, left, top, right, bottom, op.nativeInt);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.297 -0500", hash_original_method = "3911A8B4E2CBFCB889327A4F77A9CAF7", hash_generated_method = "5F846B6C641980E83BF972667C1FD727")
    
@Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        return nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.304 -0500", hash_original_method = "C5507A7F3855C8C6C63565CD78400CEB", hash_generated_method = "BA1383C0673B7ED1CEA516A804F47E8B")
    
@Override
    public boolean clipRect(Rect rect) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt);        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.306 -0500", hash_original_method = "CE1C58CF7145731A4EAE6ABB1C090975", hash_generated_method = "EE0D0332C8BBF46AB558C04220506BFD")
    
@Override
    public boolean clipRect(Rect rect, Region.Op op) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.308 -0500", hash_original_method = "82CE8198F83847EB9950BBA97A14CB45", hash_generated_method = "B14EC8B011C7905DFC477E96AE7E5BE0")
    
@Override
    public boolean clipRect(RectF rect) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.310 -0500", hash_original_method = "84F2B877854C623DFB4ED57554605946", hash_generated_method = "18368D3D2ABD1ACE3998AD2F8BA7B69E")
    
@Override
    public boolean clipRect(RectF rect, Region.Op op) {
        return nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.313 -0500", hash_original_method = "668D615301DC55EDCE9C8FA044FF5F71", hash_generated_method = "48C5936B8FEC8D19A289CB1366E34544")
    
@Override
    public boolean clipRegion(Region region) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.316 -0500", hash_original_method = "9554359F0ECC8D3364C9D02F1B6C0A6E", hash_generated_method = "995B04F7897CB76691FA3A93D72A6B3B")
    
@Override
    public boolean clipRegion(Region region, Region.Op op) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.318 -0500", hash_original_method = "5A157FCBBF6BAEFB3D0D6DDEEF98EB76", hash_generated_method = "CC4083DB27C8C5F656C299E5426FD7BC")
    
@Override
    public boolean getClipBounds(Rect bounds) {
        return nGetClipBounds(mRenderer, bounds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.325 -0500", hash_original_method = "0662E9735A64886F23067D669F3F560C", hash_generated_method = "C7405A55B80768FA86E5EDAA1FA72AE4")
    
@Override
    public boolean quickReject(float left, float top, float right, float bottom, EdgeType type) {
        return nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.332 -0500", hash_original_method = "866F13730ACFD67020DA883631339738", hash_generated_method = "189812B3586733255351B17A098B6FBB")
    
@Override
    public boolean quickReject(Path path, EdgeType type) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.334 -0500", hash_original_method = "0E7313D794F0C2C284156675C98816BB", hash_generated_method = "7ABDA740FC33160D5F768EE17A1552D9")
    
@Override
    public boolean quickReject(RectF rect, EdgeType type) {
        return quickReject(rect.left, rect.top, rect.right, rect.bottom, type);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Transformations
    ///////////////////////////////////////////////////////////////////////////

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.336 -0500", hash_original_method = "D702D49D0CBA8DAFFC483E145A7D155B", hash_generated_method = "E7F3CC7677A2A92C01900C4A6FEB9A41")
    
@Override
    public void translate(float dx, float dy) {
        if (dx != 0.0f || dy != 0.0f) nTranslate(mRenderer, dx, dy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.343 -0500", hash_original_method = "B4BEAF66CD344F6FBAA1A7BCA9EAC51C", hash_generated_method = "8BB6D70954F64C14A36F952F974DB9B9")
    
@Override
    public void skew(float sx, float sy) {
        nSkew(mRenderer, sx, sy);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.349 -0500", hash_original_method = "088A2140F7946F7E1F87C60185C75E3A", hash_generated_method = "87C2F1BBE5F03277CBFA83500A5588A9")
    
@Override
    public void rotate(float degrees) {
        nRotate(mRenderer, degrees);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.355 -0500", hash_original_method = "407ACB57F0B4398889DAE0D23801B26B", hash_generated_method = "FFEB6F0A7FD79FECAF47ABB594720184")
    
@Override
    public void scale(float sx, float sy) {
        nScale(mRenderer, sx, sy);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.361 -0500", hash_original_method = "F6D59AD1FAE97EC22EF86A1DF6443B3F", hash_generated_method = "842B4D0D1DA321F39C333F1F49A9D447")
    
@Override
    public void setMatrix(Matrix matrix) {
        nSetMatrix(mRenderer, matrix.getTaintInt());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.368 -0500", hash_original_method = "5C2AB9AC8E62FE145634A1140AF6AF7A", hash_generated_method = "E336193D9894F888AEC4D90B138B72D7")
    
@Override
    public void getMatrix(Matrix matrix) {
        nGetMatrix(mRenderer, matrix.getTaintInt());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.374 -0500", hash_original_method = "D981C9A8CE9E8AB948A57E105C909748", hash_generated_method = "E6CCDE5196546BDDF5DB3BB3AEE5FB0F")
    
@Override
    public void concat(Matrix matrix) {
        nConcatMatrix(mRenderer, matrix.getTaintInt());
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // State management
    ///////////////////////////////////////////////////////////////////////////

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.380 -0500", hash_original_method = "7EFF2592C3C6BD5E4F13755A0D5399A0", hash_generated_method = "3BAD83C542AA4F0BD480AD855118B0B9")
    
@Override
    public int save() {
        return nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.383 -0500", hash_original_method = "F50C3BBFE7BD2C9D29BCAB4C8FE567F6", hash_generated_method = "16A9A78E3CB2A7A088BBF27870F8505C")
    
@Override
    public int save(int saveFlags) {
        return nSave(mRenderer, saveFlags);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.389 -0500", hash_original_method = "9DF5A937336C76576E5F634C144FC48D", hash_generated_method = "5874F23B7ACE8895C1D7BAA60010B41A")
    
@Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        if (bounds != null) {
            return saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, paint, saveFlags);
        }

        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        int count = nSaveLayer(mRenderer, nativePaint, saveFlags);
        if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
        return count;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.396 -0500", hash_original_method = "E794596E5060868E9256D6234D184C09", hash_generated_method = "C049EBA06670DC13A938785626378E55")
    
@Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint,
            int saveFlags) {
        if (left < right && top < bottom) {
            int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
            final int nativePaint = paint == null ? 0 : paint.mNativePaint;
            int count = nSaveLayer(mRenderer, left, top, right, bottom, nativePaint, saveFlags);
            if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
            return count;
        }
        return save(saveFlags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.403 -0500", hash_original_method = "E4AB6B80C5EF0D5B797D753415FED0BE", hash_generated_method = "CFDBAE483E8CD313DC1DB9DB500F6346")
    
@Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        if (bounds != null) {
            return saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom,
                    alpha, saveFlags);
        }
        return nSaveLayerAlpha(mRenderer, alpha, saveFlags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.409 -0500", hash_original_method = "B4AB4565F10B041D742F1796C47ECB95", hash_generated_method = "3D76D7C8F728830E6940716B15976C7E")
    
@Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha,
            int saveFlags) {
        if (left < right && top < bottom) {
            return nSaveLayerAlpha(mRenderer, left, top, right, bottom, alpha, saveFlags);
        }
        return save(saveFlags);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.416 -0500", hash_original_method = "C18753FB8460844761E485A3B07AB085", hash_generated_method = "4DA346B994536DC0784475C403BEE476")
    
@Override
    public void restore() {
        nRestore(mRenderer);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.422 -0500", hash_original_method = "03029795119CF4F7F4374FF9CDD913F1", hash_generated_method = "47865D29D08961405F5E34856C49A3E1")
    
@Override
    public void restoreToCount(int saveCount) {
        nRestoreToCount(mRenderer, saveCount);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.428 -0500", hash_original_method = "5171A9EFFCF2464453072A29F0BC817F", hash_generated_method = "BDD837002E564B51F46CB8A72B2FE5D6")
    
@Override
    public int getSaveCount() {
        return nGetSaveCount(mRenderer);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Filtering
    ///////////////////////////////////////////////////////////////////////////

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.435 -0500", hash_original_method = "846B7706B193B695840103C92096214E", hash_generated_method = "455E4EA1968F0D0BE9297CD36D7FFECE")
    
@Override
    public void setDrawFilter(DrawFilter filter) {
        mFilter = filter;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.437 -0500", hash_original_method = "00C808EC6F25CC6E1FA57C10F69CA13D", hash_generated_method = "A09D80A22C969C496AD901F52849B6ED")
    
@Override
    public DrawFilter getDrawFilter() {
        return mFilter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Drawing
    ///////////////////////////////////////////////////////////////////////////

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.440 -0500", hash_original_method = "1B5F3778D027ED2D7C875DF279109721", hash_generated_method = "4B0BC539952A9AD5B3FE04E3A42562F7")
    
@Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter,
            Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawArc(mRenderer, oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle,
                useCenter, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.446 -0500", hash_original_method = "AAC237D01F9254CC358C9D52B0A20AD9", hash_generated_method = "30A183A71A0C356E3BA02A6473D1F2F1")
    
@Override
    public void drawARGB(int a, int r, int g, int b) {
        drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.448 -0500", hash_original_method = "3E288E14B7CE68A819334B0A90162954", hash_generated_method = "39BE361C43196DABD559C40CE9C9D767")
    
@Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        // Shaders are ignored when drawing patches
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, chunks,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.455 -0500", hash_original_method = "BF78CEE5A5D5A0B7000D42B8D7CD12A6", hash_generated_method = "2A8BE290CF8B0088D86D4809038F1E20")
    
@Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.462 -0500", hash_original_method = "7A23E114FF3FC414FFADAB9162210E17", hash_generated_method = "5B464A7F5C24E8EFA5273DB1A80F2E71")
    
@Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer,
                matrix.getTaintInt(), nativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.469 -0500", hash_original_method = "025B89D3F15CD9670FC3D74B91AB5D58", hash_generated_method = "17FF0BABBF28A442CD83331624B2AD4C")
    
@Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;

        int left, top, right, bottom;
        if (src == null) {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } else {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        }

        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.472 -0500", hash_original_method = "18A7A5D5D5C8B881DFD85E47F7DA3439", hash_generated_method = "828BD9A55D3008C6C6AC3A38D673860C")
    
@Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;

        float left, top, right, bottom;
        if (src == null) {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } else {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        }

        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.479 -0500", hash_original_method = "9B6F84B3164E22399F0F518F30D6F56B", hash_generated_method = "0F2EDCC0FF6573CA4620E7470A79D3B5")
    
@Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y,
            int width, int height, boolean hasAlpha, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final Bitmap.Config config = hasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        final Bitmap b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        b.recycle();
        if (modifier != MODIFIER_NONE) nResetModifiers(mRenderer, modifier);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.482 -0500", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "49400B124CEE65CE4E8BCB51466FFB74")
    
@Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
            int width, int height, boolean hasAlpha, Paint paint) {
        // Shaders are ignored when drawing bitmaps
        drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.485 -0500", hash_original_method = "B49032D10E62987D37B2D43027E8B7B3", hash_generated_method = "B10A631D2DEE592FB155F40BEC86BF75")
    
@Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        if (meshWidth < 0 || meshHeight < 0 || vertOffset < 0 || colorOffset < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (meshWidth == 0 || meshHeight == 0) {
            return;
        }

        final int count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);

        // TODO: Colors are ignored for now
        colors = null;
        colorOffset = 0;

        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;        
        nDrawBitmapMesh(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, meshWidth, meshHeight,
                verts, vertOffset, colors, colorOffset, nativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.491 -0500", hash_original_method = "3CC575BC6DB3F469750010B2B8CAC81C", hash_generated_method = "5EAC065B9D4B099E14C829ED381F68ED")
    
@Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.498 -0500", hash_original_method = "4F7ABDA5E981B914379787693CC10165", hash_generated_method = "C40B8082E4B77B3E53E615C68D33C8C1")
    
@Override
    public void drawColor(int color) {
        drawColor(color, PorterDuff.Mode.SRC_OVER);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.500 -0500", hash_original_method = "CF35C7302232BF0C4B60CFA92B96D407", hash_generated_method = "62F2345423347C9F61CE55913CC83B9F")
    
@Override
    public void drawColor(int color, PorterDuff.Mode mode) {
        nDrawColor(mRenderer, color, mode.nativeInt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.506 -0500", hash_original_method = "5EABC5A9A71D080A656B11841F718311", hash_generated_method = "A6C4EDE2B88EEB79293B3B4ACAA16C4B")
    
@Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        mLine[0] = startX;
        mLine[1] = startY;
        mLine[2] = stopX;
        mLine[3] = stopY;
        drawLines(mLine, 0, 4, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.509 -0500", hash_original_method = "CC8F0B4448632DE8A259253A60E2B3F7", hash_generated_method = "7C7D3675C57A09775C207AC8FBDEDC22")
    
@Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        if ((offset | count) < 0 || offset + count > pts.length) {
            throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        }
        int modifiers = setupModifiers(paint);
        nDrawLines(mRenderer, pts, offset, count, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.515 -0500", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "A7873CEB2E61EB70732E128257743107")
    
@Override
    public void drawLines(float[] pts, Paint paint) {
        drawLines(pts, 0, pts.length, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.518 -0500", hash_original_method = "3C8333232F307DB00830ADFD9367082C", hash_generated_method = "869229807977BE9FA2EE2B0F8E23DB55")
    
@Override
    public void drawOval(RectF oval, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.525 -0500", hash_original_method = "F3CEC7F1ABD68352F2A5895BCD8335A7", hash_generated_method = "59DF5FAC474DC53E9555288783178389")
    
@Override
    public void drawPaint(Paint paint) {
        final Rect r = mClipBounds;
        nGetClipBounds(mRenderer, r);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.528 -0500", hash_original_method = "E734C6F1749AB430929BC8490D600517", hash_generated_method = "F8C650F1F2510764322C544689686F88")
    
@Override
    public void drawPath(Path path, Paint paint) {
        int modifiers = setupModifiers(paint);
        if (path.isSimplePath) {
            if (path.rects != null) {
                nDrawRects(mRenderer, path.rects.getTaintInt(), paint.mNativePaint);
            }
        } else {
            nDrawPath(mRenderer, path.getTaintInt(), paint.mNativePaint);
        }
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.537 -0500", hash_original_method = "2AA9BBA2F44244E312AB57A12DAF658B", hash_generated_method = "9CDC570E008EF693D5E979C12AD83414")
    
@Override
    public void drawPicture(Picture picture) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.541 -0500", hash_original_method = "1202DF046E7699A744E442D410CE2128", hash_generated_method = "D4116EA05217E96BAF6D09C6134BB76C")
    
@Override
    public void drawPicture(Picture picture, Rect dst) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.543 -0500", hash_original_method = "CE526B9F8925E416169A22B853086EA4", hash_generated_method = "1397371DEC83D47BEB2AA0BE6551100E")
    
@Override
    public void drawPicture(Picture picture, RectF dst) {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.545 -0500", hash_original_method = "711B0E1C295D7644DD171BC7547CDDDA", hash_generated_method = "13AEB071F940531F88718F7CEF745608")
    
@Override
    public void drawPoint(float x, float y, Paint paint) {
        mPoint[0] = x;
        mPoint[1] = y;
        drawPoints(mPoint, 0, 2, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.548 -0500", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "4BF51664F30C98FF10C18C768587116F")
    
@Override
    public void drawPoints(float[] pts, Paint paint) {
        drawPoints(pts, 0, pts.length, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.550 -0500", hash_original_method = "A6EA0B46F26697457B201A425B5A3171", hash_generated_method = "2E32D22F12DF2105CE15D229C9F55952")
    
@Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.556 -0500", hash_original_method = "A1D0375AE9DFF68E398CA7F0C8CFDC48", hash_generated_method = "0B596169F7508A490FA706993A5EC5B7")
    
@Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        // TODO: Implement
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.559 -0500", hash_original_method = "2727BD7310EB8AF1CE9C5E69FE8F5F77", hash_generated_method = "22E22711E047CE1722D97809BB354046")
    
@Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        // TODO: Implement
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.562 -0500", hash_original_method = "1D1C68AD886616B8DD56E02894BED97B", hash_generated_method = "6A20B37666646833034B4B5A9AC0D430")
    
@Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.568 -0500", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "B33438BD25418FAC97FE046951D8D841")
    
@Override
    public void drawRect(Rect r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.571 -0500", hash_original_method = "73D11F584AEBB7C191086A2FFF4052A9", hash_generated_method = "8DF05428E94DC5B4E7B0A1D7ED017A52")
    
@Override
    public void drawRect(RectF r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.573 -0500", hash_original_method = "EB9FA3A1182306D8C56FD7B1B2A405F0", hash_generated_method = "F4CA98973E64DF85E59226D12C20DBB5")
    
@Override
    public void drawRGB(int r, int g, int b) {
        drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.576 -0500", hash_original_method = "F66719DAB9BD4C7CE0890FFA1C26F9F2", hash_generated_method = "15D9411B8615327890C17B00864BF391")
    
@Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        int modifiers = setupModifiers(paint);
        nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                rx, ry, paint.mNativePaint);
        if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);        
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.583 -0500", hash_original_method = "5B66E40A85BEEB6F8228E5994A513667", hash_generated_method = "F04A9779F387F4BE7D28AB0EB665F25A")
    
@Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        if ((index | count | (index + count) | (text.length - index - count)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        int modifiers = setupModifiers(paint);
        try {
            nDrawText(mRenderer, text, index, count, x, y, paint.mBidiFlags, paint.mNativePaint);
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.589 -0500", hash_original_method = "BF4D02798081BBBF8269CD636760F070", hash_generated_method = "C30C5CAFBA8FD8A692D0BF4049A66986")
    
@Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        int modifiers = setupModifiers(paint);
        try {
            if (text instanceof String || text instanceof SpannedString ||
                    text instanceof SpannableString) {
                nDrawText(mRenderer, text.toString(), start, end, x, y, paint.mBidiFlags,
                        paint.mNativePaint);
            } else if (text instanceof GraphicsOperations) {
                ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                         paint);
            } else {
                char[] buf = TemporaryBuffer.obtain(end - start);
                TextUtils.getChars(text, start, end, buf, 0);
                nDrawText(mRenderer, buf, 0, end - start, x, y,
                        paint.mBidiFlags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            }
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.592 -0500", hash_original_method = "53AB28ACA34BAB18CDB1722B92273EEB", hash_generated_method = "D1E73F9DFA1A900A19D29D85F130F3BA")
    
@Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }

        int modifiers = setupModifiers(paint);
        try {
            nDrawText(mRenderer, text, start, end, x, y, paint.mBidiFlags, paint.mNativePaint);
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.599 -0500", hash_original_method = "F496E99287218708FCCC7DBE6218BF00", hash_generated_method = "350663D47E7038EF5ECFE549F1FFB270")
    
@Override
    public void drawText(String text, float x, float y, Paint paint) {
        int modifiers = setupModifiers(paint);
        try {
            nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    paint.mNativePaint);
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }
    
    private static final class CanvasFinalizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.100 -0500", hash_original_field = "2B452A59440EC392E79D53931F031EDF", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

        private  int mRenderer;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.102 -0500", hash_original_method = "FD0EABF3A28C8F1A6C7AE1792F2A951E", hash_generated_method = "633B7850B194EB0F9364A125E63CAE9A")
        
public CanvasFinalizer(int renderer) {
            mRenderer = renderer;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.105 -0500", hash_original_method = "98F8E6E4208DCA7352053ED1AE5E9232", hash_generated_method = "14AF259034054A724E804D82E5964DF7")
        
@Override
        protected void finalize() throws Throwable {
            try {
                nDestroyRenderer(mRenderer);
            } finally {
                super.finalize();
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.601 -0500", hash_original_method = "C2D0F05CD306BD6EB45BAEA1052EFD68", hash_generated_method = "73E8DFEB8220740DF2635249C8F69460")
    
@Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        // TODO: Implement
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.604 -0500", hash_original_method = "E399416700F7228806FC79CB70E6A478", hash_generated_method = "3D37AF8C0C2CC36494C0ADAFF5CB79A5")
    
@Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        // TODO: Implement
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.606 -0500", hash_original_method = "8FBF947B147B7DB5ED34E606F7095E1C", hash_generated_method = "BAE7874006D4E21F64A0836371560353")
    
@Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        if ((index | count | text.length - index - count) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (dir != DIRECTION_LTR && dir != DIRECTION_RTL) {
            throw new IllegalArgumentException("Unknown direction: " + dir);
        }

        int modifiers = setupModifiers(paint);
        try {
            nDrawTextRun(mRenderer, text, index, count, contextIndex, contextCount, x, y, dir,
                    paint.mNativePaint);
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.613 -0500", hash_original_method = "7904538C4B6BCEBBAA348BC3E2FD272F", hash_generated_method = "380CD4F072A04D5FEE22B7CC0A09466A")
    
@Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd,
            float x, float y, int dir, Paint paint) {
        if ((start | end | end - start | text.length() - end) < 0) {
            throw new IndexOutOfBoundsException();
        }

        int modifiers = setupModifiers(paint);
        try {
            int flags = dir == 0 ? 0 : 1;
            if (text instanceof String || text instanceof SpannedString ||
                    text instanceof SpannableString) {
                nDrawTextRun(mRenderer, text.toString(), start, end, contextStart,
                        contextEnd, x, y, flags, paint.mNativePaint);
            } else if (text instanceof GraphicsOperations) {
                ((GraphicsOperations) text).drawTextRun(this, start, end,
                        contextStart, contextEnd, x, y, flags, paint);
            } else {
                int contextLen = contextEnd - contextStart;
                int len = end - start;
                char[] buf = TemporaryBuffer.obtain(contextLen);
                TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
                nDrawTextRun(mRenderer, buf, start - contextStart, len, 0, contextLen,
                        x, y, flags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            }
        } finally {
            if (modifiers != MODIFIER_NONE) nResetModifiers(mRenderer, modifiers);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.620 -0500", hash_original_method = "7C5BB6E42A47B8FFC1224CB48EC5DC66", hash_generated_method = "052DDC923FB4925751C69AB409C55ECE")
    
@Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        // TODO: Implement
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.623 -0500", hash_original_method = "5D6688C2A74D4FFF4670B4EAAE2F407B", hash_generated_method = "47977578C6B2700A0D70F0D514425818")
    
private int setupModifiers(Bitmap b, Paint paint) {
        if (b.getConfig() == Bitmap.Config.ALPHA_8) {
            return setupModifiers(paint);
        }

        final ColorFilter filter = paint.getColorFilter();
        if (filter != null) {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            return MODIFIER_COLOR_FILTER;
        }

        return MODIFIER_NONE;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.626 -0500", hash_original_method = "7663D59B2E312EB2A24D959BD08A0BC2", hash_generated_method = "8BD5B8D7D3741BF3C9ADC2618EEC871E")
    
private int setupModifiers(Paint paint) {
        int modifiers = MODIFIER_NONE;

        if (paint.hasShadow) {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy,
                    paint.shadowColor);
            modifiers |= MODIFIER_SHADOW;
        }

        final Shader shader = paint.getShader();
        if (shader != null) {
            nSetupShader(mRenderer, shader.native_shader);
            modifiers |= MODIFIER_SHADER;
        }

        final ColorFilter filter = paint.getColorFilter();
        if (filter != null) {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            modifiers |= MODIFIER_COLOR_FILTER;
        }

        return modifiers;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:44.628 -0500", hash_original_method = "8D8D130B420F7BDB77245347422EB674", hash_generated_method = "78D0EB59D17B40D30E4AB40800D3DB4D")
    
private int setupColorFilter(Paint paint) {
        final ColorFilter filter = paint.getColorFilter();
        if (filter != null) {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            return MODIFIER_COLOR_FILTER;
        }
        return MODIFIER_NONE;
    }
}

