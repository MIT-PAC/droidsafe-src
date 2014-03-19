package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class NinePatch {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static boolean isNinePatchChunk(byte[] chunk) {
        return toTaintBoolean(chunk[0]);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void validateNinePatchChunk(int bitmap, byte[] chunk) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDraw(int canvas_instance, RectF loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDraw(int canvas_instance, Rect loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetTransparentRegion(
            int bitmap, byte[] chunk, Rect location) {
        return (bitmap + chunk[0] + chunk.getTaintInt() + location.getTaintInt());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.436 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private  Bitmap mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.439 -0500", hash_original_field = "3F787CBF4F632BCC55D205BCB17241D5", hash_generated_field = "AA663839700E75596095EA5B2F89ACB9")

    private  byte[] mChunk;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.440 -0500", hash_original_field = "0344A2D91EF1BCE652EE63EFC12EEAC9", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.442 -0500", hash_original_field = "28B922A15D9B88908EB88A91E30B694D", hash_generated_field = "DB0C3CE567257EC5E2EF3955BE3033A2")

    private String mSrcName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.444 -0500", hash_original_field = "499D59727FC656C05DFD3E86493F2A86", hash_generated_field = "E70F5B350707014CDC8DCA8B7C0C28DD")

    private final RectF mRect = new RectF();
    
    /** 
     * Create a drawable projection from a bitmap to nine patches.
     *
     * @param bitmap    The bitmap describing the patches.
     * @param chunk     The 9-patch data chunk describing how the underlying
     *                  bitmap is split apart and drawn.
     * @param srcName   The name of the source for the bitmap. Might be null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.447 -0500", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "245D7C7EBEDC071B4A50B10CD6BDE868")
    
public NinePatch(Bitmap bitmap, byte[] chunk, String srcName) {
        mBitmap = bitmap;
        mChunk = chunk;
        mSrcName = srcName;
        validateNinePatchChunk(mBitmap.ni(), chunk);
    }

    /**
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.449 -0500", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "15F0791994FA296DA6C4587330AF9376")
    
public NinePatch(NinePatch patch) {
        mBitmap = patch.mBitmap;
        mChunk = patch.mChunk;
        mSrcName = patch.mSrcName;
        if (patch.mPaint != null) {
            mPaint = new Paint(patch.mPaint);
        }
        validateNinePatchChunk(mBitmap.ni(), mChunk);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.452 -0500", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "A572CB545AC3E4B4E5FBAE3763C975B5")
    
public void setPaint(Paint p) {
        mPaint = p;
    }
    
    /** 
     * Draw a bitmap of nine patches.
     *
     * @param canvas    A container for the current matrix and clip used to draw the bitmap.
     * @param location  Where to draw the bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.454 -0500", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "4C604BF9D7599B29FC764F1927B989FB")
    
public void draw(Canvas canvas, RectF location) {
        addTaint(location.getTaint());
        canvas.addTaint(getTaint());
    }
    
    /** 
     * Draw a bitmap of nine patches.
     *
     * @param canvas    A container for the current matrix and clip used to draw the bitmap.
     * @param location  Where to draw the bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.457 -0500", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "4800FA80F07F749D78A2A7FC786195E4")
    
public void draw(Canvas canvas, Rect location) {
        /*
        if (!canvas.isHardwareAccelerated()) {
            nativeDraw(canvas.mNativeCanvas, location,
                        mBitmap.ni(), mChunk,
                        mPaint != null ? mPaint.mNativePaint : 0,
                        canvas.mDensity, mBitmap.mDensity);
        } else {
            mRect.set(location);
            canvas.drawPatch(mBitmap, mChunk, mRect, mPaint);
        }
        */
        mRect.set(location);
        canvas.addTaint(getTaint());
        canvas.addTaint(location.getTaint());
    }

    /** 
     * Draw a bitmap of nine patches.
     *
     * @param canvas    A container for the current matrix and clip used to draw the bitmap.
     * @param location  Where to draw the bitmap.
     * @param paint     The Paint to draw through.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.459 -0500", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "AAE7B6C3C8CCFBA5AE2B6F0B28BC0BD7")
    
public void draw(Canvas canvas, Rect location, Paint paint) {
       /* 
        if (!canvas.isHardwareAccelerated()) {
            nativeDraw(canvas.mNativeCanvas, location,
                    mBitmap.ni(), mChunk, paint != null ? paint.mNativePaint : 0,
                    canvas.mDensity, mBitmap.mDensity);
        } else {
            mRect.set(location);
            canvas.drawPatch(mBitmap, mChunk, mRect, paint);
        }
        */

        mRect.set(location);
        canvas.addTaint(getTaint());
        canvas.addTaint(location.getTaint());
        canvas.addTaint(paint.getTaint());
    }

    /**
     * Return the underlying bitmap's density, as per
     * {@link Bitmap#getDensity() Bitmap.getDensity()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.461 -0500", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "27DE3D32201225D1AA4CA39CCE7D66F4")
    
public int getDensity() {
        return mBitmap.mDensity;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.463 -0500", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "3FB4A85E6F6A135BC5724E72DB79F048")
    
public int getWidth() {
        return mBitmap.getWidth();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.465 -0500", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "FB6AC04B8078DB77AC5BC660237D10BC")
    
public int getHeight() {
        return mBitmap.getHeight();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.467 -0500", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "578DD35101B938BD3E8BA023BA405463")
    
public final boolean hasAlpha() {
        return mBitmap.hasAlpha();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.470 -0500", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "9DBBD34840F49148A1CA4BBFC7879982")
    
public final Region getTransparentRegion(Rect location) {
        /*
        int r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        return r != 0 ? new Region(r) : null;
        */
        Region r = new Region();
        r.addTaint(location.getTaint());
        r.addTaint(getTaint());
        return r;
    }
}

