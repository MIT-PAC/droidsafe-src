package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.microedition.khronos.opengles.GL;

import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

import droidsafe.helpers.DSUtils;

public class Canvas {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.272 -0500", hash_original_method = "4E72B045BA38CFE64C69AC73618E6E81", hash_generated_method = "334FC681567308ECFC605C40827E1CC3")
    
private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    /**
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.291 -0500", hash_original_method = "8881482C31CD6EB42F6A156D24B79CEC", hash_generated_method = "BFA33F863C09EC7778ECB3B0762595FC")
    
protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static void freeCaches() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int initRaster(int nativeBitmapOrZero) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378610903 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378610903;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setBitmap(int nativeCanvas, int bitmap) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467194653 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467194653;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430058921 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430058921;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730328887 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730328887;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192671444 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192671444;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_concat(int nCanvas, int nMatrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_setMatrix(int nCanvas, int nMatrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065743384 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065743384;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071424835 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071424835;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786500323 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786500323;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373360843 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373360843;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_getCTM(int canvas, int matrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522063304 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522063304;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643825593 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643825593;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380645477 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380645477;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawRGB(int nativeCanvas, int r, int g,
                                              int b) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawARGB(int nativeCanvas, int a, int r,
                                               int g, int b) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawColor(int nativeCanvas, int color) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawColor(int nativeCanvas, int color,
                                                int mode) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawPaint(int nativeCanvas, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawLine(int nativeCanvas, float startX,
                                               float startY, float stopX,
                                               float stopY, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawRect(int nativeCanvas, RectF rect,
                                               int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawRect(int nativeCanvas, float left,
                                               float top, float right,
                                               float bottom, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawOval(int nativeCanvas, RectF oval,
                                               int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawCircle(int nativeCanvas, float cx,
                                                 float cy, float radius,
                                                 int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawArc(int nativeCanvas, RectF oval,
                                              float startAngle, float sweep,
                                              boolean useCenter, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawRoundRect(int nativeCanvas,
                                                    RectF rect, float rx,
                                                    float ry, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawPath(int nativeCanvas, int path,
                                               int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, Rect dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawBitmap(int nativeCanvas, int[] colors,
                                                int offset, int stride, float x,
                                                 float y, int width, int height,
                                                 boolean hasAlpha,
                                                 int nativePaintOrZero) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDrawBitmapMatrix(int nCanvas, int nBitmap,
                                                      int nMatrix, int nPaint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDrawBitmapMesh(int nCanvas, int nBitmap,
                                                    int meshWidth, int meshHeight,
                                                    float[] verts, int vertOffset,
                                                    int[] colors, int colorOffset, int nPaint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDrawVertices(int nCanvas, int mode, int n,
                   float[] verts, int vertOffset, float[] texs, int texOffset,
                   int[] colors, int colorOffset, short[] indices,
                   int indexOffset, int indexCount, int nPaint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawText(int nativeCanvas, char[] text,
                                               int index, int count, float x,
                                               float y, int flags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawText(int nativeCanvas, String text,
                                               int start, int end, float x,
                                               float y, int flags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawTextRun(int nativeCanvas, String text,
            int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawTextRun(int nativeCanvas, char[] text,
            int start, int count, int contextStart, int contextCount,
            float x, float y, int flags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawPosText(int nativeCanvas,
                                                  char[] text, int index,
                                                  int count, float[] pos,
                                                  int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawPosText(int nativeCanvas,
                                                  String text, float[] pos,
                                                  int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     char[] text, int index,
                                                     int count, int path,
                                                     float hOffset,
                                                     float vOffset, int bidiFlags,
                                                     int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     String text, int path,
                                                     float hOffset, 
                                                     float vOffset, 
                                                     int flags, int paint) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_drawPicture(int nativeCanvas,
                                                  int nativePicture) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void finalizer(int nativeCanvas) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.046 -0500", hash_original_field = "DE0993C64A5DCE6B04BA860BC13954B0", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.048 -0500", hash_original_field = "46B700B3B2E9E814F4C1E3FC3262AEB1", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.050 -0500", hash_original_field = "B5945FF46563199466C484AC170AD006", hash_generated_field = "BC69128E9B848FDD39E2F6D1048A3E30")

    // (see SkCanvas.cpp, SkDraw.cpp)
    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.103 -0500", hash_original_field = "E60E36172E05957F55F145C2156155BA", hash_generated_field = "6C8DE3849C8C2C8F11FED5E72A54856F")

    /** restore the current matrix when restore() is called */
    public static final int MATRIX_SAVE_FLAG = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.105 -0500", hash_original_field = "5331FE1A3406446C5981931DCB724987", hash_generated_field = "58F530C9C6B270B19539C29F0F59AF3F")

    public static final int CLIP_SAVE_FLAG = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.108 -0500", hash_original_field = "A29A388892161BAC13B6CD1CDC67B45B", hash_generated_field = "46E7D1290A1803E6928B2E065D955191")

    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.110 -0500", hash_original_field = "D40895AB2C4E729507313F9A6624B745", hash_generated_field = "532BC0688FBCF248880462AA6827890F")

    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.113 -0500", hash_original_field = "B97A7C3CD626185DDD36D5A7FC04926B", hash_generated_field = "9BC3AB123F6CF841BC3428B9EA233C60")

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.116 -0500", hash_original_field = "4FDDBD41583FED24D0A15A369D1B03AD", hash_generated_field = "A21A7EFBC48A7EE5E4832E43F9767035")

    public static final int ALL_SAVE_FLAG = 0x1F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.032 -0500", hash_original_field = "9AEAAB458F04AA015A1FEC7988D58EFD", hash_generated_field = "9AEAAB458F04AA015A1FEC7988D58EFD")

     int mNativeCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.034 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap  mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.036 -0500", hash_original_field = "1809E3F3B0952C4944386BCDAFF81AC8", hash_generated_field = "04F9CD5B166F725F4476D4C3990647B3")
    
    // optional field set by the caller
    private DrawFilter mDrawFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.039 -0500", hash_original_field = "41920084ADA48F59F241C35F3D02476D", hash_generated_field = "26A3C4D459B626187E0E8706060CBC58")

    protected int mDensity = Bitmap.DENSITY_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.041 -0500", hash_original_field = "FA7F1C26BE2DD8F0261D589B965FA2A4", hash_generated_field = "B3B96B83CBF6A474ACFDE54DAF7E8D5B")

    protected int mScreenDensity = Bitmap.DENSITY_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.043 -0500", hash_original_field = "BDE9F80FF611CA04BAC6BF350B53679E", hash_generated_field = "5A79E0455BB83A8F5930E665EB36A02A")

    @SuppressWarnings({"UnusedDeclaration"})
    private int         mSurfaceFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.052 -0500", hash_original_field = "92E0A3468E5C8A32534FFA55F4EA69E2", hash_generated_field = "D26BA3C2A6930E011E689CD349B6702B")

    @SuppressWarnings({"UnusedDeclaration"})
    private  CanvasFinalizer mFinalizer;
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Canvas() {
		//Do Nothing
	}

    /**
     * Construct a canvas with the specified bitmap to draw into. The bitmap
     * must be mutable.
     * 
     * <p>The initial target density of the canvas is the same as the given
     * bitmap's density.
     *
     * @param bitmap Specifies a mutable bitmap for the canvas to draw into.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.068 -0500", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "9BFED6DEC7FF5091C599E38FA68AFF9D")
    
public Canvas(Bitmap bitmap) {
        if (!bitmap.isMutable()) {
            throw new IllegalStateException(
                            "Immutable bitmap passed to Canvas constructor");
        }
        throwIfRecycled(bitmap);
        mNativeCanvas = initRaster(bitmap.ni());
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        mBitmap = bitmap;
        mDensity = bitmap.mDensity;
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.070 -0500", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "347D84319548CC8FC9B392FE55B81BD9")
    
Canvas(int nativeCanvas) {
        if (nativeCanvas == 0) {
            throw new IllegalStateException();
        }
        mNativeCanvas = nativeCanvas;
        mFinalizer = new CanvasFinalizer(nativeCanvas);
        mDensity = Bitmap.getDefaultDensity();
    }

    /**
     * Returns null.
     * 
     * @deprecated This method is not supported and should not be invoked.
     * 
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.073 -0500", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "5BB6D3440A25548E93896CEA426595C1")
    
@Deprecated
    protected GL getGL() {
        return null;
    }

    /**
     * Indicates whether this Canvas uses hardware acceleration.
     * 
     * Note that this method does not define what type of hardware acceleration
     * may or may not be used.
     * 
     * @return True if drawing operations are hardware accelerated,
     *         false otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.075 -0500", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "3C7366855ACB2D093DD423127CC059B2")
    
public boolean isHardwareAccelerated() {
        return false;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void setBitmap(Bitmap bitmap) {
		addTaint(bitmap.getTaint());
		addTaint(bitmap.getDensity()); //getDensity will return a tainted value
		/*
        if (isHardwareAccelerated()) {
            throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        }
        int pointer = 0;
        if (bitmap != null) {
            if (!bitmap.isMutable()) {
                throw new IllegalStateException();
            }
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            pointer = bitmap.ni();
        }
        native_setBitmap(mNativeCanvas, pointer);
        mBitmap = bitmap;
        */
    }
    
    /**
     * Set the viewport dimensions if this canvas is GL based. If it is not,
     * this method is ignored and no exception is thrown.
     *
     * @param width The width of the viewport
     * @param height The height of the viewport
     * 
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.079 -0500", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "F813A2ECD65AA49F40CA21327D7699A1")
    
public void setViewport(int width, int height) {
    }

    /**
     * Return true if the device that the current layer draws into is opaque
     * (i.e. does not support per-pixel alpha).
     *
     * @return true if the device that the current layer draws into is opaque
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.083 -0500", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "0FF4C408441CDF51A299C96865D3C743")
    
    public boolean isOpaque(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Returns the width of the current drawing layer
     *
     * @return the width of the current drawing layer
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.086 -0500", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "119E6F88A6022FFF8C0BCF10E5D283FB")
    
    public int getWidth(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Returns the height of the current drawing layer
     *
     * @return the height of the current drawing layer
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.090 -0500", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "A50AB7B99158205015AA04248040D6D3")
    
    public int getHeight(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDensity() {
		return getTaintInt();
		//return mDensity;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void setDensity(int density) {
		addTaint(density);  //Density is saved both here and in the bitmap
		mBitmap.setDensity(density);  //setDensity will track the taint in the Bitmap object
		/*
        if (mBitmap != null) {
            mBitmap.setDensity(density);
        }
        mDensity = density;
        */
	}

    /** @hide */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.097 -0500", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "0608A6D15F183500AD37A116391AB878")
    
public void setScreenDensity(int density) {
        mScreenDensity = density;
    }

    /**
     * Returns the maximum allowed width for bitmaps drawn with this canvas.
     * Attempting to draw with a bitmap wider than this value will result
     * in an error.
     * 
     * @see #getMaximumBitmapHeight() 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.099 -0500", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "5D274B8825E67B365D5115D71633CAE7")
    
public int getMaximumBitmapWidth() {
        return MAXMIMUM_BITMAP_SIZE;
    }
    
    /**
     * Returns the maximum allowed height for bitmaps drawn with this canvas.
     * Attempting to draw with a bitmap taller than this value will result
     * in an error.
     * 
     * @see #getMaximumBitmapWidth() 
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.100 -0500", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "9340C6DCC529E409677A2F3455B2243D")
    
public int getMaximumBitmapHeight() {
        return MAXMIMUM_BITMAP_SIZE;
    }
    
    /**
     * Saves the current matrix and clip onto a private stack. Subsequent
     * calls to translate,scale,rotate,skew,concat or clipRect,clipPath
     * will all operate as usual, but when the balancing call to restore()
     * is made, those calls will be forgotten, and the settings that existed
     * before the save() will be reinstated.
     *
     * @return The value to pass to restoreToCount() to balance this save()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.119 -0500", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "2B849F705D66B3344BB858C062FCF030")
    
    public int save(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    /**
     * Based on saveFlags, can save the current matrix and clip onto a private
     * stack. Subsequent calls to translate,scale,rotate,skew,concat or
     * clipRect,clipPath will all operate as usual, but when the balancing
     * call to restore() is made, those calls will be forgotten, and the
     * settings that existed before the save() will be reinstated.
     *
     * @param saveFlags flag bits that specify which parts of the Canvas state
     *                  to save/restore
     * @return The value to pass to restoreToCount() to balance this save()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.123 -0500", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "78CD894CA5CA8D178BBE65B05D1E4F9A")
    
    public int save(int saveFlags){
    	//Formerly a native method
    	addTaint(saveFlags);
    	return getTaintInt();
    }

    /**
     * This behaves the same as save(), but in addition it allocates an
     * offscreen bitmap. All drawing calls are directed there, and only when
     * the balancing call to restore() is made is that offscreen transfered to
     * the canvas (or the previous layer). Subsequent calls to translate,
     * scale, rotate, skew, concat or clipRect, clipPath all operate on this
     * copy. When the balancing call to restore() is made, this copy is
     * deleted and the previous matrix/clip state is restored.
     *
     * @param bounds May be null. The maximum size the offscreen bitmap
     *               needs to be (in local coordinates)
     * @param paint  This is copied, and is applied to the offscreen when
     *               restore() is called.
     * @param saveFlags  see _SAVE_FLAG constants
     * @return       value to pass to restoreToCount() to balance this save()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.125 -0500", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "8E8A50822F89D18894E9EDB936F0539B")
    
public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        return native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags);
    }
    
    /**
     * Helper version of saveLayer() that takes 4 values rather than a RectF.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.127 -0500", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "77968793B4456561D3534C8518576750")
    
public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags);
    }

    /**
     * This behaves the same as save(), but in addition it allocates an
     * offscreen bitmap. All drawing calls are directed there, and only when
     * the balancing call to restore() is made is that offscreen transfered to
     * the canvas (or the previous layer). Subsequent calls to translate,
     * scale, rotate, skew, concat or clipRect, clipPath all operate on this
     * copy. When the balancing call to restore() is made, this copy is
     * deleted and the previous matrix/clip state is restored.
     *
     * @param bounds    The maximum size the offscreen bitmap needs to be
     *                  (in local coordinates)
     * @param alpha     The alpha to apply to the offscreen when when it is
                        drawn during restore()
     * @param saveFlags see _SAVE_FLAG constants
     * @return          value to pass to restoreToCount() to balance this call
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.129 -0500", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "01AF074B73D4C1F84F3199AA9ECEB8B1")
    
public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        alpha = Math.min(255, Math.max(0, alpha));
        return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }
    
    /**
     * Helper for saveLayerAlpha() that takes 4 values instead of a RectF.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.131 -0500", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "2EE874E2E6C2748C0F4D4D80A9216851")
    
public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void restore() {
	}

    /**
     * Returns the number of matrix/clip states on the Canvas' private stack.
     * This will equal # save() calls - # restore() calls.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.139 -0500", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "469086422F4A0C211EE8A99341DDC2E6")
    
    public int getSaveCount(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Efficient way to pop any calls to save() that happened after the save
     * count reached saveCount. It is an error for saveCount to be less than 1.
     *
     * Example:
     *    int count = canvas.save();
     *    ... // more calls potentially to save()
     *    canvas.restoreToCount(count);
     *    // now the canvas is back in the same state it was before the initial
     *    // call to save().
     *
     * @param saveCount The save level to restore to.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.143 -0500", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "FFDE58BDE0F4E8A7BB6CEACB56352E98")
    
    public void restoreToCount(int saveCount){
    	//Formerly a native method
    	addTaint(saveCount);
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void translate(float dx, float dy) {
		addTaint(dx);
		addTaint(dy);
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void scale(float sx, float sy) {
		addTaint(sx);
		addTaint(sy);
	}

    /**
     * Preconcat the current matrix with the specified scale.
     *
     * @param sx The amount to scale in X
     * @param sy The amount to scale in Y
     * @param px The x-coord for the pivot point (unchanged by the scale)
     * @param py The y-coord for the pivot point (unchanged by the scale)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.152 -0500", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "A90714BC8F2D627F45F2D7B13B278A01")
    
public final void scale(float sx, float sy, float px, float py) {
        translate(px, py);
        scale(sx, sy);
        translate(-px, -py);
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void rotate(float degrees) {
		addTaint(degrees);
	}

    /**
     * Preconcat the current matrix with the specified rotation.
     *
     * @param degrees The amount to rotate, in degrees
     * @param px The x-coord for the pivot point (unchanged by the rotation)
     * @param py The y-coord for the pivot point (unchanged by the rotation)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.158 -0500", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "61DCE9732DA02773D3D2939E3FB0D6DE")
    
public final void rotate(float degrees, float px, float py) {
        translate(px, py);
        rotate(degrees);
        translate(-px, -py);
    }

    /**
     * Preconcat the current matrix with the specified skew.
     *
     * @param sx The amount to skew in X
     * @param sy The amount to skew in Y
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.162 -0500", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "634C1E54E855948A577968C18CF78209")
    
    public void skew(float sx, float sy){
    	//Formerly a native method
    	addTaint(sx);
    	addTaint(sy);
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void concat(Matrix matrix) {
		addTaint(matrix.native_instance);
    }
    
    /**
     * Completely replace the current matrix with the specified matrix. If the
     * matrix parameter is null, then the current matrix is reset to identity.
     *
     * @param matrix The matrix to replace the current matrix with. If it is
     *               null, set the current matrix to identity.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.166 -0500", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "2D41CB2D2ED1123789F114F9CE5C1F8F")
    
public void setMatrix(Matrix matrix) {
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
    }
    
    /**
     * Return, in ctm, the current transformation matrix. This does not alter
     * the matrix in the canvas, but just returns a copy of it.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.168 -0500", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "A9BE5FD6B90F19A6DB1C75520C046BEA")
    
public void getMatrix(Matrix ctm) {
        native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    /**
     * Return a new matrix with a copy of the canvas' current transformation
     * matrix.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.171 -0500", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "0EFEA3854D4D1A1427D490C733F4434D")
    
public final Matrix getMatrix() {
        Matrix m = new Matrix();
        getMatrix(m);
        return m;
    }
    
    /**
     * Modify the current clip with the specified rectangle.
     *
     * @param rect The rect to intersect with the current clip
     * @param op How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.173 -0500", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "11763958C4DDE97C38EB6CF50AA0DC5D")
    
public boolean clipRect(RectF rect, Region.Op op) {
        return native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt);
    }

    /**
     * Modify the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @param op How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.175 -0500", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "B52B4C54AFF7D730B7710759599B2299")
    
public boolean clipRect(Rect rect, Region.Op op) {
        return native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt);
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @return true if the resulting clip is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.178 -0500", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "F2C884192B64A3A56DC7DFFCF33158E7")
    
    public boolean clipRect(RectF rect){
    	//Formerly a native method
    	addTaint(rect.getTaint());
    	return getTaintBoolean();
    }
    
    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @return true if the resulting clip is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.182 -0500", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "CD4E9DC764BA294C9CF415C093942BB3")
    
    public boolean clipRect(Rect rect){
    	//Formerly a native method
    	addTaint(rect.getTaint());
    	return getTaintBoolean();
    }
    
    /**
     * Modify the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current
     *               clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @param op     How the clip is modified
     * @return       true if the resulting clip is non-empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.184 -0500", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "949B522CC2BD95F3746A3FBAF564F432")
    
public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt);
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @return       true if the resulting clip is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.188 -0500", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "6D64E5549536322AD01BC3C2F5F7B309")
    
    public boolean clipRect(float left, float top,
                                       float right, float bottom){
    	//Formerly a native method
    	addTaint(left);
    	addTaint(top);
    	addTaint(right);
    	addTaint(bottom);
    	return getTaintBoolean();
    }
    
    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @return       true if the resulting clip is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.192 -0500", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "D3A89CF00F564A9CFE02EBD6D8219414")
    
    public boolean clipRect(int left, int top,
                                       int right, int bottom){
    	//Formerly a native method
    	addTaint(left);
    	addTaint(top);
    	addTaint(right);
    	addTaint(bottom);
    	return getTaintBoolean();
    }
    
    /**
        * Modify the current clip with the specified path.
     *
     * @param path The path to operate on the current clip
     * @param op   How the clip is modified
     * @return     true if the resulting is non-empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.194 -0500", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "1BC6A3758785F5F0776626FF643FAA62")
    
public boolean clipPath(Path path, Region.Op op) {
        return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }
    
    /**
     * Intersect the current clip with the specified path.
     *
     * @param path The path to intersect with the current clip
     * @return     true if the resulting is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.196 -0500", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "AD6D4EAA7D8C0F1641FF3CCD8A40507B")
    
public boolean clipPath(Path path) {
        return clipPath(path, Region.Op.INTERSECT);
    }
    
    /**
     * Modify the current clip with the specified region. Note that unlike
     * clipRect() and clipPath() which transform their arguments by the
     * current matrix, clipRegion() assumes its argument is already in the
     * coordinate system of the current layer's bitmap, and so not
     * transformation is performed.
     *
     * @param region The region to operate on the current clip, based on op
     * @param op How the clip is modified
     * @return true if the resulting is non-empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.198 -0500", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "2F846477F27E4E0526BED076D2581381")
    
public boolean clipRegion(Region region, Region.Op op) {
        return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    /**
     * Intersect the current clip with the specified region. Note that unlike
     * clipRect() and clipPath() which transform their arguments by the
     * current matrix, clipRegion() assumes its argument is already in the
     * coordinate system of the current layer's bitmap, and so not
     * transformation is performed.
     *
     * @param region The region to operate on the current clip, based on op
     * @return true if the resulting is non-empty
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.200 -0500", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "F5CFE1D0ECCD78ABD40742E04CEB317E")
    
public boolean clipRegion(Region region) {
        return clipRegion(region, Region.Op.INTERSECT);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.203 -0500", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "DB47B7D7BDB246B91136D3617D06EA7A")
    
public DrawFilter getDrawFilter() {
        return mDrawFilter;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.205 -0500", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "CFC18FCAFAB562E5E19EA145E4E09CFB")
    
public void setDrawFilter(DrawFilter filter) {
        int nativeFilter = 0;
        if (filter != null) {
            nativeFilter = filter.mNativeInt;
        }
        mDrawFilter = filter;
        nativeSetDrawFilter(mNativeCanvas, nativeFilter);
    }

    /**
     * Return true if the specified rectangle, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls).
     *
     * @param rect  the rect to compare with the current clip
     * @param type  specifies how to treat the edges (BW or antialiased)
     * @return      true if the rect (transformed by the canvas' matrix)
     *              does not intersect with the canvas' clip
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.214 -0500", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "681D0242EDBE5796B0251F8FE01E5F4A")
    
public boolean quickReject(RectF rect, EdgeType type) {
        return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    /**
     * Return true if the specified path, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls). Note: for speed it may
     * return false even if the path itself might not intersect the clip
     * (i.e. the bounds of the path intersects, but the path does not).
     *
     * @param path        The path to compare with the current clip
     * @param type        true if the path should be considered antialiased,
     *                    since that means it may
     *                    affect a larger area (more pixels) than
     *                    non-antialiased.
     * @return            true if the path (transformed by the canvas' matrix)
     *                    does not intersect with the canvas' clip
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.216 -0500", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "277779C1CB18A60DD012AA41528BB1DB")
    
public boolean quickReject(Path path, EdgeType type) {
        return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    /**
     * Return true if the specified rectangle, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls).
     *
     * @param left        The left side of the rectangle to compare with the
     *                    current clip
     * @param top         The top of the rectangle to compare with the current
     *                    clip
     * @param right       The right side of the rectangle to compare with the
     *                    current clip
     * @param bottom      The bottom of the rectangle to compare with the
     *                    current clip
     * @param type        true if the rect should be considered antialiased,
     *                    since that means it may affect a larger area (more
     *                    pixels) than non-antialiased.
     * @return            true if the rect (transformed by the canvas' matrix)
     *                    does not intersect with the canvas' clip
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.218 -0500", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "0923654BB8AF65F9484CAA5A96D66B6A")
    
public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt);
    }

    /**
     * Retrieve the clip bounds, returning true if they are non-empty.
     *
     * @param bounds Return the clip bounds here. If it is null, ignore it but
     *               still return true if the current clip is non-empty.
     * @return true if the current clip is non-empty.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.220 -0500", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "CD2B68B9BCE0D43AB62694FB49268EB6")
    
public boolean getClipBounds(Rect bounds) {
        return native_getClipBounds(mNativeCanvas, bounds);
    }
    
    /**
     * Retrieve the clip bounds.
     *
     * @return the clip bounds, or [0, 0, 0, 0] if the clip is empty.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.222 -0500", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "C7F3C9DD4F71BE5FE3E931C0C7EA11E6")
    
public final Rect getClipBounds() {
        Rect r = new Rect();
        getClipBounds(r);
        return r;
    }
    
    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified RGB color, using srcover porterduff mode.
     *
     * @param r red component (0..255) of the color to draw onto the canvas
     * @param g green component (0..255) of the color to draw onto the canvas
     * @param b blue component (0..255) of the color to draw onto the canvas
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.224 -0500", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "2DA1E6EA2939186445D232E9DDEB54FE")
    
public void drawRGB(int r, int g, int b) {
        native_drawRGB(mNativeCanvas, r, g, b);
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified ARGB color, using srcover porterduff mode.
     *
     * @param a alpha component (0..255) of the color to draw onto the canvas
     * @param r red component (0..255) of the color to draw onto the canvas
     * @param g green component (0..255) of the color to draw onto the canvas
     * @param b blue component (0..255) of the color to draw onto the canvas
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.227 -0500", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "25A3A58DABAB0A14F7BA58894D4CE78B")
    
public void drawARGB(int a, int r, int g, int b) {
        native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified color, using srcover porterduff mode.
     *
     * @param color the color to draw onto the canvas
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.229 -0500", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "EE06CAAE9D24DA5976CF89E841300FAB")
    
public void drawColor(int color) {
        native_drawColor(mNativeCanvas, color);
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified color and porter-duff xfermode.
     *
     * @param color the color to draw with
     * @param mode  the porter-duff mode to apply to the color
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.231 -0500", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "BC575776DFB584ABEB1578CB4B01E8B5")
    
public void drawColor(int color, PorterDuff.Mode mode) {
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with
     * the specified paint. This is equivalent (but faster) to drawing an
     * infinitely large rectangle with the specified paint.
     *
     * @param paint The paint used to draw onto the canvas
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.233 -0500", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "842D690B248E8ADCC5125F903224E558")
    
public void drawPaint(Paint paint) {
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }
    
    /**
     * Draw a series of points. Each point is centered at the coordinate
     * specified by pts[], and its diameter is specified by the paint's stroke
     * width (as transformed by the canvas' CTM), with special treatment for
     * a stroke width of 0, which always draws exactly 1 pixel (or at most 4
     * if antialiasing is enabled). The shape of the point is controlled by
     * the paint's Cap type. The shape is a square, unless the cap type is
     * Round, in which case the shape is a circle.
     *
     * @param pts      Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset   Number of values to skip before starting to draw.
     * @param count    The number of values to process, after skipping offset
     *                 of them. Since one point uses two values, the number of
     *                 "points" that are drawn is really (count >> 1).
     * @param paint    The paint used to draw the points
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.237 -0500", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "D83D82C75D0C85838D7CC6E60BE8AA26")
    
    public void drawPoints(float[] pts, int offset, int count,
                                      Paint paint){
    	//Formerly a native method
    	addTaint(pts[0]);
    	addTaint(offset);
    	addTaint(count);
    	addTaint(paint.getTaint());
    }

    /**
     * Helper for drawPoints() that assumes you want to draw the entire array
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.240 -0500", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "4963A10BE9A7760ABAFB8261B92A7C9A")
    
public void drawPoints(float[] pts, Paint paint) {
        drawPoints(pts, 0, pts.length, paint);
    }

    /**
     * Helper for drawPoints() for drawing a single point.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.244 -0500", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "44507CA9D773D18530A1BEC585BFD420")
    
    public void drawPoint(float x, float y, Paint paint){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(paint.getTaint());
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void drawLine(float startX, float startY, float stopX, float stopY,
            Paint paint) {
		/*
		 * This method calls a native method that draws to a native canvas which
		 * is represented by the mNativeCanvas (a pointer/handle) value in the SDK 
		 * implementation the call will modify the bitmap managed by the native code.
		 * 
		 * DSFIXME:  Technically the underlying bitmap will be changed 
		 * (represented by the int mNativeCanvas).  It appears that this
		 * operation happens in real time, so tracking taint is difficult
		 * on the upflow.
		 */
		addTaint(startX);
		addTaint(startY);
		addTaint(stopX);
		addTaint(stopY);
		addTaint(paint.getTaint());
	}

    /**
     * Draw a series of lines. Each line is taken from 4 consecutive values
     * in the pts array. Thus to draw 1 line, the array must contain at least 4
     * values. This is logically the same as drawing the array as follows:
     * drawLine(pts[0], pts[1], pts[2], pts[3]) followed by
     * drawLine(pts[4], pts[5], pts[6], pts[7]) and so on.
     *
     * @param pts      Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset   Number of values in the array to skip before drawing.
     * @param count    The number of values in the array to process, after
     *                 skipping "offset" of them. Since each line uses 4 values,
     *                 the number of "lines" that are drawn is really
     *                 (count >> 2).
     * @param paint    The paint used to draw the points
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.249 -0500", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "895A193964894AB87288405D02F31326")
    
    public void drawLines(float[] pts, int offset, int count,
                                     Paint paint){
    	//Formerly a native method
    	addTaint(pts[0]);
    	addTaint(offset);
    	addTaint(count);
    	addTaint(paint.getTaint());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.251 -0500", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "6BB9AF47E7A96C3EDD32940E0EDDF45D")
    
public void drawLines(float[] pts, Paint paint) {
        drawLines(pts, 0, pts.length, paint);
    }

    /**
     * Draw the specified Rect using the specified paint. The rectangle will
     * be filled or framed based on the Style in the paint.
     *
     * @param rect  The rect to be drawn
     * @param paint The paint used to draw the rect
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.254 -0500", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "687F901A7B0DB72090772A4E5099C96D")
    
public void drawRect(RectF rect, Paint paint) {
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    /**
     * Draw the specified Rect using the specified Paint. The rectangle
     * will be filled or framed based on the Style in the paint.
     *
     * @param r        The rectangle to be drawn.
     * @param paint    The paint used to draw the rectangle
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.257 -0500", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "ADA6219B535C173D2ADD2608EB80D68B")
    
public void drawRect(Rect r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    /**
     * Draw the specified Rect using the specified paint. The rectangle will
     * be filled or framed based on the Style in the paint.
     *
     * @param left   The left side of the rectangle to be drawn
     * @param top    The top side of the rectangle to be drawn
     * @param right  The right side of the rectangle to be drawn
     * @param bottom The bottom side of the rectangle to be drawn
     * @param paint  The paint used to draw the rect
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.259 -0500", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "F9406D975293ED3CE5ED28AC7966047F")
    
public void drawRect(float left, float top, float right, float bottom,
                         Paint paint) {
        native_drawRect(mNativeCanvas, left, top, right, bottom,
                        paint.mNativePaint);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void drawOval(RectF oval, Paint paint) {
		addTaint(oval.getTaint());
		addTaint(paint.getTaint());
    	/* GITI DSModeled
        if (oval == null) {
            throw new NullPointerException();
        }
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        */
    }

    /**
     * Draw the specified circle using the specified paint. If radius is <= 0,
     * then nothing will be drawn. The circle will be filled or framed based
     * on the Style in the paint.
     *
     * @param cx     The x-coordinate of the center of the cirle to be drawn
     * @param cy     The y-coordinate of the center of the cirle to be drawn
     * @param radius The radius of the cirle to be drawn
     * @param paint  The paint used to draw the circle
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.263 -0500", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "692344834A58C7F02E5722238C227FDE")
    
public void drawCircle(float cx, float cy, float radius, Paint paint) {
        native_drawCircle(mNativeCanvas, cx, cy, radius,
                          paint.mNativePaint);
    }

    /**
     * <p>Draw the specified arc, which will be scaled to fit inside the
     * specified oval.</p>
     * 
     * <p>If the start angle is negative or >= 360, the start angle is treated
     * as start angle modulo 360.</p>
     * 
     * <p>If the sweep angle is >= 360, then the oval is drawn
     * completely. Note that this differs slightly from SkPath::arcTo, which
     * treats the sweep angle modulo 360. If the sweep angle is negative,
     * the sweep angle is treated as sweep angle modulo 360</p>
     * 
     * <p>The arc is drawn clockwise. An angle of 0 degrees correspond to the
     * geometric angle of 0 degrees (3 o'clock on a watch.)</p>
     *
     * @param oval       The bounds of oval used to define the shape and size
     *                   of the arc
     * @param startAngle Starting angle (in degrees) where the arc begins
     * @param sweepAngle Sweep angle (in degrees) measured clockwise
     * @param useCenter If true, include the center of the oval in the arc, and
                        close it if it is being stroked. This will draw a wedge
     * @param paint      The paint used to draw the arc
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.265 -0500", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "CE118D9220FDE4CED8F2CCAF3528CA51")
    
public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        if (oval == null) {
            throw new NullPointerException();
        }
        native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       useCenter, paint.mNativePaint);
    }

    /**
     * Draw the specified round-rect using the specified paint. The roundrect
     * will be filled or framed based on the Style in the paint.
     *
     * @param rect  The rectangular bounds of the roundRect to be drawn
     * @param rx    The x-radius of the oval used to round the corners
     * @param ry    The y-radius of the oval used to round the corners
     * @param paint The paint used to draw the roundRect
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.267 -0500", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "AF18146D80DB438DD0A2F77C34F0CB67")
    
public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        if (rect == null) {
            throw new NullPointerException();
        }
        native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             paint.mNativePaint);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void drawPath(Path path, Paint paint) {
		addTaint(path.getTaint());
		addTaint(paint.getTaint());
        /*
         native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        */
    }

    /**
     * Draws the specified bitmap as an N-patch (most often, a 9-patches.)
     *
     * Note: Only supported by hardware accelerated canvas at the moment.
     *
     * @param bitmap The bitmap to draw as an N-patch
     * @param chunks The patches information (matches the native struct Res_png_9patch)
     * @param dst The destination rectangle.
     * @param paint The paint to draw the bitmap with. may be null
     * 
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.274 -0500", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "EB27392E1BDD30EDFD84F4921F2A74B4")
    
public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
		addTaint(bitmap.getTaint());
		addTaint(left);
		addTaint(top);
		addTaint(paint.getTaint());
		/*
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                bitmap.mDensity);
        */
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
		addTaint(bitmap.getTaint());
		addTaint(src.getTaint());
		addTaint(dst.getTaint());
		addTaint(paint.getTaint());
    }

    /**
     * Draw the specified bitmap, scaling/translating automatically to fill
     * the destination rectangle. If the source rectangle is not null, it
     * specifies the subset of the bitmap to draw.
     * 
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     *
     * <p>This function <em>ignores the density associated with the bitmap</em>.
     * This is because the source and destination rectangle coordinate
     * spaces are in their respective densities, so must already have the
     * appropriate scaling factor applied.
     * 
     * @param bitmap The bitmap to be drawn
     * @param src    May be null. The subset of the bitmap to be drawn
     * @param dst    The rectangle that the bitmap will be scaled/translated
     *               to fit into
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.282 -0500", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "8F2F6B8B6FB5820FB660E656203CC417")
    
public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        if (dst == null) {
            throw new NullPointerException();
        }
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
    }
    
    /**
     * Treat the specified array of colors as a bitmap, and draw it. This gives
     * the same result as first creating a bitmap from the array, and then
     * drawing it, but this method avoids explicitly creating a bitmap object
     * which can be more efficient if the colors are changing often.
     *
     * @param colors Array of colors representing the pixels of the bitmap
     * @param offset Offset into the array of colors for the first pixel
     * @param stride The number of colors in the array between rows (must be
     *               >= width or <= -width).
     * @param x The X coordinate for where to draw the bitmap
     * @param y The Y coordinate for where to draw the bitmap
     * @param width The width of the bitmap
     * @param height The height of the bitmap
     * @param hasAlpha True if the alpha channel of the colors contains valid
     *                 values. If false, the alpha byte is ignored (assumed to
     *                 be 0xFF for every pixel).
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.285 -0500", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "862D3F90B941C9EBECA4941BD16C4649")
    
public void drawBitmap(int[] colors, int offset, int stride, float x,
                           float y, int width, int height, boolean hasAlpha,
                           Paint paint) {
        // check for valid input
        if (width < 0) {
            throw new IllegalArgumentException("width must be >= 0");
        }
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (Math.abs(stride) < width) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int lastScanline = offset + (height - 1) * stride;
        int length = colors.length;
        if (offset < 0 || (offset + width > length) || lastScanline < 0
                || (lastScanline + width > length)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // quick escape if there's nothing to draw
        if (width == 0 || height == 0) {
            return;
        }
        // punch down to native for the actual draw
        native_drawBitmap(mNativeCanvas, colors, offset, stride, x, y, width, height, hasAlpha,
                paint != null ? paint.mNativePaint : 0);
    }
    
    /** Legacy version of drawBitmap(int[] colors, ...) that took ints for x,y
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.287 -0500", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "D01D43B09DAFD2BBAD87A5CC970B7DC0")
    
public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
                           int width, int height, boolean hasAlpha,
                           Paint paint) {
        // call through to the common float version
        drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   hasAlpha, paint);
    }
        
    /**
     * Draw the bitmap using the specified matrix.
     *
     * @param bitmap The bitmap to draw
     * @param matrix The matrix used to transform the bitmap when it is drawn
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.289 -0500", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "E0067301BC4D95F1F82B6EFF8CAC0C89")
    
public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                paint != null ? paint.mNativePaint : 0);
    }
    
    /**
     * Draw the bitmap through the mesh, where mesh vertices are evenly
     * distributed across the bitmap. There are meshWidth+1 vertices across, and
     * meshHeight+1 vertices down. The verts array is accessed in row-major
     * order, so that the first meshWidth+1 vertices are distributed across the
     * top of the bitmap from left to right. A more general version of this
     * methid is drawVertices().
     *
     * @param bitmap The bitmap to draw using the mesh
     * @param meshWidth The number of columns in the mesh. Nothing is drawn if
     *                  this is 0
     * @param meshHeight The number of rows in the mesh. Nothing is drawn if
     *                   this is 0
     * @param verts Array of x,y pairs, specifying where the mesh should be
     *              drawn. There must be at least
     *              (meshWidth+1) * (meshHeight+1) * 2 + meshOffset values
     *              in the array
     * @param vertOffset Number of verts elements to skip before drawing
     * @param colors May be null. Specifies a color at each vertex, which is
     *               interpolated across the cell, and whose values are
     *               multiplied by the corresponding bitmap colors. If not null,
     *               there must be at least (meshWidth+1) * (meshHeight+1) +
     *               colorOffset values in the array.
     * @param colorOffset Number of color elements to skip before drawing
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.294 -0500", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "5E417D0279DE411E7B89E6E44D91B70C")
    
public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight,
                               float[] verts, int vertOffset,
                               int[] colors, int colorOffset, Paint paint) {
        if ((meshWidth | meshHeight | vertOffset | colorOffset) < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (meshWidth == 0 || meshHeight == 0) {
            return;
        }
        int count = (meshWidth + 1) * (meshHeight + 1);
        // we mul by 2 since we need two floats per vertex
        checkRange(verts.length, vertOffset, count * 2);
        if (colors != null) {
            // no mul by 2, since we need only 1 color per vertex
            checkRange(colors.length, colorOffset, count);
        }
        nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             verts, vertOffset, colors, colorOffset,
                             paint != null ? paint.mNativePaint : 0);
    }
    
    /**
     * Draw the array of vertices, interpreted as triangles (based on mode). The
     * verts array is required, and specifies the x,y pairs for each vertex. If
     * texs is non-null, then it is used to specify the coordinate in shader
     * coordinates to use at each vertex (the paint must have a shader in this
     * case). If there is no texs array, but there is a color array, then each
     * color is interpolated across its corresponding triangle in a gradient. If
     * both texs and colors arrays are present, then they behave as before, but
     * the resulting color at each pixels is the result of multiplying the
     * colors from the shader and the color-gradient together. The indices array
     * is optional, but if it is present, then it is used to specify the index
     * of each triangle, rather than just walking through the arrays in order.
     *
     * @param mode How to interpret the array of vertices
     * @param vertexCount The number of values in the vertices array (and
     *      corresponding texs and colors arrays if non-null). Each logical
     *      vertex is two values (x, y), vertexCount must be a multiple of 2.
     * @param verts Array of vertices for the mesh
     * @param vertOffset Number of values in the verts to skip before drawing.
     * @param texs May be null. If not null, specifies the coordinates to sample
     *      into the current shader (e.g. bitmap tile or gradient)
     * @param texOffset Number of values in texs to skip before drawing.
     * @param colors May be null. If not null, specifies a color for each
     *      vertex, to be interpolated across the triangle.
     * @param colorOffset Number of values in colors to skip before drawing.
     * @param indices If not null, array of indices to reference into the
     *      vertex (texs, colors) array.
     * @param indexCount number of entries in the indices array (if not null).
     * @param paint Specifies the shader to use if the texs array is non-null. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.303 -0500", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "BBBCFF4693D5F2C3DA4308D56E7A969E")
    
public void drawVertices(VertexMode mode, int vertexCount,
                             float[] verts, int vertOffset,
                             float[] texs, int texOffset,
                             int[] colors, int colorOffset,
                             short[] indices, int indexOffset,
                             int indexCount, Paint paint) {
        checkRange(verts.length, vertOffset, vertexCount);
        if (texs != null) {
            checkRange(texs.length, texOffset, vertexCount);
        }
        if (colors != null) {
            checkRange(colors.length, colorOffset, vertexCount / 2);
        }
        if (indices != null) {
            checkRange(indices.length, indexOffset, indexCount);
        }
        nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           vertOffset, texs, texOffset, colors, colorOffset,
                          indices, indexOffset, indexCount, paint.mNativePaint);
    }
    
    /**
     * Draw the text, with origin at (x,y), using the specified paint. The
     * origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.306 -0500", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "CE07C6E1BD5141BE415BFA895FDEDA11")
    
public void drawText(char[] text, int index, int count, float x, float y,
                         Paint paint) {
        if ((index | count | (index + count) |
            (text.length - index - count)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                paint.mNativePaint);
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint. The
     * origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.308 -0500", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "A9F3EEEB2A8415737D8887B2A209059C")
    
public void drawText(String text, float x, float y, Paint paint) {
        native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                paint.mNativePaint);
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint.
     * The origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param start The index of the first character in text to draw
     * @param end   (end - 1) is the index of the last character in text to draw
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.311 -0500", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "8428B61909C5F2EBDE360D0D5F0EDE95")
    
public void drawText(String text, int start, int end, float x, float y,
                         Paint paint) {
        if ((start | end | (end - start) | (text.length() - end)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                paint.mNativePaint);
    }

    /**
     * Draw the specified range of text, specified by start/end, with its
     * origin at (x,y), in the specified Paint. The origin is interpreted
     * based on the Align setting in the Paint.
     *
     * @param text     The text to be drawn
     * @param start    The index of the first character in text to draw
     * @param end      (end - 1) is the index of the last character in text
     *                 to draw
     * @param x        The x-coordinate of origin for where to draw the text
     * @param y        The y-coordinate of origin for where to draw the text
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.313 -0500", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "31282EAB2BB247C7F5C281A556545124")
    
public void drawText(CharSequence text, int start, int end, float x,
                         float y, Paint paint) {
        if (text instanceof String || text instanceof SpannedString ||
            text instanceof SpannableString) {
            native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            paint.mBidiFlags, paint.mNativePaint);
        } else if (text instanceof GraphicsOperations) {
            ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     paint);
        } else {
            char[] buf = TemporaryBuffer.obtain(end - start);
            TextUtils.getChars(text, start, end, buf, 0);
            native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    paint.mBidiFlags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        }
    }

    /**
     * Render a run of all LTR or all RTL text, with shaping. This does not run
     * bidi on the provided text, but renders it as a uniform right-to-left or
     * left-to-right run, as indicated by dir. Alignment of the text is as
     * determined by the Paint's TextAlign value.
     * 
     * @param text the text to render
     * @param index the start of the text to render
     * @param count the count of chars to render
     * @param contextIndex the start of the context for shaping.  Must be
     *         no greater than index.
     * @param contextCount the number of characters in the context for shaping.
     *         ContexIndex + contextCount must be no less than index
     *         + count.
     * @param x the x position at which to draw the text
     * @param y the y position at which to draw the text
     * @param dir the run direction, either {@link #DIRECTION_LTR} or
     *         {@link #DIRECTION_RTL}.
     * @param paint the paint
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.316 -0500", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "1B9C28878E8B0179B8E0E1BDD4CDED62")
    
public void drawTextRun(char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir,
            Paint paint) {

        if (text == null) {
            throw new NullPointerException("text is null");
        }
        if (paint == null) {
            throw new NullPointerException("paint is null");
        }
        if ((index | count | text.length - index - count) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (dir != DIRECTION_LTR && dir != DIRECTION_RTL) {
            throw new IllegalArgumentException("unknown dir: " + dir);
        }

        native_drawTextRun(mNativeCanvas, text, index, count,
                contextIndex, contextCount, x, y, dir, paint.mNativePaint);
    }

    /**
     * Render a run of all LTR or all RTL text, with shaping. This does not run
     * bidi on the provided text, but renders it as a uniform right-to-left or
     * left-to-right run, as indicated by dir. Alignment of the text is as
     * determined by the Paint's TextAlign value.
     *
     * @param text the text to render
     * @param start the start of the text to render. Data before this position
     *            can be used for shaping context.
     * @param end the end of the text to render. Data at or after this
     *            position can be used for shaping context.
     * @param x the x position at which to draw the text
     * @param y the y position at which to draw the text
     * @param dir the run direction, either 0 for LTR or 1 for RTL.
     * @param paint the paint
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.320 -0500", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "39739D2446632EC7009AA1DE60DF6229")
    
public void drawTextRun(CharSequence text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int dir,
            Paint paint) {

        if (text == null) {
            throw new NullPointerException("text is null");
        }
        if (paint == null) {
            throw new NullPointerException("paint is null");
        }
        if ((start | end | end - start | text.length() - end) < 0) {
            throw new IndexOutOfBoundsException();
        }

        int flags = dir == 0 ? 0 : 1;

        if (text instanceof String || text instanceof SpannedString ||
                text instanceof SpannableString) {
            native_drawTextRun(mNativeCanvas, text.toString(), start, end,
                    contextStart, contextEnd, x, y, flags, paint.mNativePaint);
        } else if (text instanceof GraphicsOperations) {
            ((GraphicsOperations) text).drawTextRun(this, start, end,
                    contextStart, contextEnd, x, y, flags, paint);
        } else {
            int contextLen = contextEnd - contextStart;
            int len = end - start;
            char[] buf = TemporaryBuffer.obtain(contextLen);
            TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
            native_drawTextRun(mNativeCanvas, buf, start - contextStart, len,
                    0, contextLen, x, y, flags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        }
    }
    
    private static class CanvasFinalizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.055 -0500", hash_original_field = "9AEAAB458F04AA015A1FEC7988D58EFD", hash_generated_field = "2D4BC4BEF691AE213514DA2EF6E7568C")

        private  int mNativeCanvas;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.058 -0500", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "9CF681F26468FE9E51A54AAE3DFC6D05")
        
public CanvasFinalizer(int nativeCanvas) {
            mNativeCanvas = nativeCanvas;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.061 -0500", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "9EAA59FE8A1AC389853679A4014358DB")
        
@Override
        protected void finalize() throws Throwable {
            try {
                if (mNativeCanvas != 0) {
                    finalizer(mNativeCanvas);
                }
            } finally {
                super.finalize();
            }
        }
        
    }
    
    public enum EdgeType {
        BW(0),  
        AA(1);  //!< treat edges by rounding-out, since they may be antialiased
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.208 -0500", hash_original_method = "DE06F253EDCACE209FBC3A0C0A89C58A", hash_generated_method = "DE06F253EDCACE209FBC3A0C0A89C58A")
            
EdgeType(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.211 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "98EAA4A55387890AE1074B767C7F1464")

        public  int nativeInt;
    }
    
    public enum VertexMode {
        TRIANGLES(0),
        TRIANGLE_STRIP(1),
        TRIANGLE_FAN(2);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.297 -0500", hash_original_method = "76F89A0458E260840A64ADE5D74457F8", hash_generated_method = "76F89A0458E260840A64ADE5D74457F8")
            
VertexMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.299 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "98EAA4A55387890AE1074B767C7F1464")

        public  int nativeInt;
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     *
     * @param text     The text to be drawn
     * @param index    The index of the first character to draw
     * @param count    The number of characters to draw, starting from index.
     * @param pos      Array of [x,y] positions, used to position each
     *                 character
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.322 -0500", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "A4B1D5F82C1C758F36C3D4E56F30C1A9")
    
public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        if (index < 0 || index + count > text.length || count*2 > pos.length) {
            throw new IndexOutOfBoundsException();
        }
        native_drawPosText(mNativeCanvas, text, index, count, pos,
                           paint.mNativePaint);
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     *
     * @param text  The text to be drawn
     * @param pos   Array of [x,y] positions, used to position each character
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.324 -0500", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "DF7223F1354FFC21F5CBD418A7364F9B")
    
public void drawPosText(String text, float[] pos, Paint paint) {
        if (text.length()*2 > pos.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text     The text to be drawn
     * @param path     The path the text should follow for its baseline
     * @param hOffset  The distance along the path to add to the text's
     *                 starting position
     * @param vOffset  The distance above(-) or below(+) the path to position
     *                 the text
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.327 -0500", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "35BA1DF442634C9B4F2A851D1604FA9B")
    
public void drawTextOnPath(char[] text, int index, int count, Path path,
                               float hOffset, float vOffset, Paint paint) {
        if (index < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_drawTextOnPath(mNativeCanvas, text, index, count,
                              path.ni(), hOffset, vOffset,
                              paint.mBidiFlags, paint.mNativePaint);
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text     The text to be drawn
     * @param path     The path the text should follow for its baseline
     * @param hOffset  The distance along the path to add to the text's
     *                 starting position
     * @param vOffset  The distance above(-) or below(+) the path to position
     *                 the text
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.329 -0500", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "FE6DD563D7BEBC354DFA48CAF6847CF0")
    
public void drawTextOnPath(String text, Path path, float hOffset,
                               float vOffset, Paint paint) {
        if (text.length() > 0) {
            native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  hOffset, vOffset, paint.mBidiFlags,
                                  paint.mNativePaint);
        }
    }

    /**
     * Save the canvas state, draw the picture, and restore the canvas state.
     * This differs from picture.draw(canvas), which does not perform any
     * save/restore.
     * 
     * @param picture  The picture to be drawn
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.331 -0500", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "A7CDC96DCBEB12154D728CCBA831327D")
    
public void drawPicture(Picture picture) {
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
    }
    
    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.334 -0500", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "96E3C3926F5F41E8C998D191BB378939")
    
public void drawPicture(Picture picture, RectF dst) {
        save();
        translate(dst.left, dst.top);
        if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            scale(dst.width() / picture.getWidth(),
                  dst.height() / picture.getHeight());
        }
        drawPicture(picture);
        restore();
    }
    
    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.336 -0500", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "BB63D045235D0F2D29909303E4AA51F6")
    
public void drawPicture(Picture picture, Rect dst) {
        save();
        translate(dst.left, dst.top);
        if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            scale((float)dst.width() / picture.getWidth(),
                  (float)dst.height() / picture.getHeight());
        }
        drawPicture(picture);
        restore();
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.458 -0500", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "0546F5A0C949A71B1798184843F818A0")
    
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                     float left, float top,
                                                     int nativePaintOrZero,
                                                     int canvasDensity,
                                                     int screenDensity,
                                                     int bitmapDensity){
    	//Formerly a native method
    	addTaint(nativeCanvas);
    	addTaint(bitmap);
    	addTaint(left);
    	addTaint(top);
    	addTaint(nativePaintOrZero);
    	addTaint(canvasDensity);
    	addTaint(screenDensity);
    	addTaint(bitmapDensity);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:20.462 -0500", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "DF800D68BE0723DC79FE8A9A4F3F8878")
    
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                     Rect src, RectF dst,
                                                     int nativePaintOrZero,
                                                     int screenDensity,
                                                     int bitmapDensity){
    	//Formerly a native method
    	addTaint(nativeCanvas);
    	addTaint(bitmap);
    	addTaint(src.getTaint());
    	addTaint(dst.getTaint());
    	addTaint(nativePaintOrZero);
    	addTaint(screenDensity);
    	addTaint(bitmapDensity);
    }
    
}

