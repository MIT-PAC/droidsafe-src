package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NinePatch {
    private Bitmap mBitmap;
    private byte[] mChunk;
    private Paint mPaint;
    private String mSrcName;
    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.356 -0400", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "23BD9127788075A68D51D15C6E9D3583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NinePatch(Bitmap bitmap, byte[] chunk, String srcName) {
        dsTaint.addTaint(chunk[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(srcName);
        validateNinePatchChunk(mBitmap.ni(), chunk);
        // ---------- Original Method ----------
        //mBitmap = bitmap;
        //mChunk = chunk;
        //mSrcName = srcName;
        //validateNinePatchChunk(mBitmap.ni(), chunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.356 -0400", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "C24D78C4D168F62CD6E895921FA7B714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NinePatch(NinePatch patch) {
        dsTaint.addTaint(patch.dsTaint);
        mBitmap = patch.mBitmap;
        mChunk = patch.mChunk;
        mSrcName = patch.mSrcName;
        {
            mPaint = new Paint(patch.mPaint);
        } //End block
        validateNinePatchChunk(mBitmap.ni(), mChunk);
        // ---------- Original Method ----------
        //mBitmap = patch.mBitmap;
        //mChunk = patch.mChunk;
        //mSrcName = patch.mSrcName;
        //if (patch.mPaint != null) {
            //mPaint = new Paint(patch.mPaint);
        //}
        //validateNinePatchChunk(mBitmap.ni(), mChunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.357 -0400", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "C1568EA2936F358DA516208D7BDD5D9C")
    @DSModeled(DSC.SAFE)
    public void setPaint(Paint p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
        //mPaint = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.357 -0400", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "05A5822FB62CC53E416B0616EB1AF6F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, RectF location) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_277104328 = (!canvas.isHardwareAccelerated());
            {
                nativeDraw(canvas.mNativeCanvas, location,
                       mBitmap.ni(), mChunk,
                       mPaint != null ? mPaint.mNativePaint : 0,
                       canvas.mDensity, mBitmap.mDensity);
            } //End block
            {
                canvas.drawPatch(mBitmap, mChunk, location, mPaint);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!canvas.isHardwareAccelerated()) {
            //nativeDraw(canvas.mNativeCanvas, location,
                       //mBitmap.ni(), mChunk,
                       //mPaint != null ? mPaint.mNativePaint : 0,
                       //canvas.mDensity, mBitmap.mDensity);
        //} else {
            //canvas.drawPatch(mBitmap, mChunk, location, mPaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.357 -0400", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "D92038D3B35A0488C2A513D93D1E731D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, Rect location) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1879430910 = (!canvas.isHardwareAccelerated());
            {
                nativeDraw(canvas.mNativeCanvas, location,
                        mBitmap.ni(), mChunk,
                        mPaint != null ? mPaint.mNativePaint : 0,
                        canvas.mDensity, mBitmap.mDensity);
            } //End block
            {
                mRect.set(location);
                canvas.drawPatch(mBitmap, mChunk, mRect, mPaint);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!canvas.isHardwareAccelerated()) {
            //nativeDraw(canvas.mNativeCanvas, location,
                        //mBitmap.ni(), mChunk,
                        //mPaint != null ? mPaint.mNativePaint : 0,
                        //canvas.mDensity, mBitmap.mDensity);
        //} else {
            //mRect.set(location);
            //canvas.drawPatch(mBitmap, mChunk, mRect, mPaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.358 -0400", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "8429F2427587AFFBC099E85F72B63054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, Rect location, Paint paint) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_672428005 = (!canvas.isHardwareAccelerated());
            {
                nativeDraw(canvas.mNativeCanvas, location,
                    mBitmap.ni(), mChunk, paint != null ? paint.mNativePaint : 0,
                    canvas.mDensity, mBitmap.mDensity);
            } //End block
            {
                mRect.set(location);
                canvas.drawPatch(mBitmap, mChunk, mRect, paint);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!canvas.isHardwareAccelerated()) {
            //nativeDraw(canvas.mNativeCanvas, location,
                    //mBitmap.ni(), mChunk, paint != null ? paint.mNativePaint : 0,
                    //canvas.mDensity, mBitmap.mDensity);
        //} else {
            //mRect.set(location);
            //canvas.drawPatch(mBitmap, mChunk, mRect, paint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.360 -0400", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "4E7311FB2B2CA6C8E3E20FE774AA0348")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.360 -0400", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "9C17F4646C44A10EFA5CC8DFD997098B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
        int var57D36AC407EFDDA4FB3640AD5BF79509_2127784868 = (mBitmap.getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.360 -0400", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "4654DC6B1C243D838B98304F376EE20D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
        int varD4CB35A60B9E5617CB00E88FD9661C8C_428155184 = (mBitmap.getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.360 -0400", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "9F2FDAB2EF3BDB772FA5DB3A9FA1E9C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasAlpha() {
        boolean varCC9B942DAF8C11B799B81316FCD04AE8_591842258 = (mBitmap.hasAlpha());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBitmap.hasAlpha();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.361 -0400", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "2F212423E2609DCC4F4C91ED268ECC87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Region getTransparentRegion(Rect location) {
        dsTaint.addTaint(location.dsTaint);
        int r;
        r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        {
            Object var5E74A772E25D1B0B3147E128D6864A87_554379391 = (new Region(r));
        } //End flattened ternary
        return (Region)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        //return r != 0 ? new Region(r) : null;
    }

    
        public static boolean isNinePatchChunk(byte[] chunk) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void validateNinePatchChunk(int bitmap, byte[] chunk) {
    }

    
        private static void nativeDraw(int canvas_instance, RectF loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }

    
        private static void nativeDraw(int canvas_instance, Rect loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }

    
        private static int nativeGetTransparentRegion(
            int bitmap, byte[] chunk, Rect location) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

