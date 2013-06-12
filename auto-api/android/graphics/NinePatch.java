package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NinePatch {
    private final Bitmap mBitmap;
    private final byte[] mChunk;
    private Paint mPaint;
    private String mSrcName;
    private final RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.228 -0400", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "9DFC7067A30B208CF8CAEC63F4A0978A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NinePatch(Bitmap bitmap, byte[] chunk, String srcName) {
        dsTaint.addTaint(chunk);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(srcName);
        validateNinePatchChunk(mBitmap.ni(), chunk);
        // ---------- Original Method ----------
        //mBitmap = bitmap;
        //mChunk = chunk;
        //mSrcName = srcName;
        //validateNinePatchChunk(mBitmap.ni(), chunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "03AA9EAB95576522644883529B08BB7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "AB4318F582C3B160C9716D62AB8F0F10")
    @DSModeled(DSC.SAFE)
    public void setPaint(Paint p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
        //mPaint = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "4DBC5AC0BECBC174DB3D45F1D1BD7C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, RectF location) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1947913296 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "C2035D4964CFB9EB7A96C8661FF11E0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, Rect location) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_2111081208 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "43D64CB2E5A24C29F3ACCA96C1937163")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas, Rect location, Paint paint) {
        dsTaint.addTaint(location.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_708181482 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.229 -0400", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "69DE4E03BA1CF93B69EDF27795AFB984")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "5AE05C058A08863665F9CDB00D3A0423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWidth() {
        int var57D36AC407EFDDA4FB3640AD5BF79509_2059843185 = (mBitmap.getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "191B5E55BC5BDB8D8181D9EC483DD4E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeight() {
        int varD4CB35A60B9E5617CB00E88FD9661C8C_1237568781 = (mBitmap.getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmap.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "57D16B3C5FB6329D67785895ECBCA8AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasAlpha() {
        boolean varCC9B942DAF8C11B799B81316FCD04AE8_1121932563 = (mBitmap.hasAlpha());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBitmap.hasAlpha();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "AF1B9CCBCEAADB9A12B8BB924EB1E047")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Region getTransparentRegion(Rect location) {
        dsTaint.addTaint(location.dsTaint);
        int r;
        r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        return (Region)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        //return r != 0 ? new Region(r) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "570ABE90E265E5D485D9A13A5FB144E0", hash_generated_method = "C822529437CFAAEE51CA19123DCBB2A6")
    public static boolean isNinePatchChunk(byte[] chunk) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "72DE7872A496F82CF6AF13D558B6BEB5", hash_generated_method = "5DEF9EB8A9A78A8F6B74F971C10C8308")
    private static void validateNinePatchChunk(int bitmap, byte[] chunk) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "5AF77EC14E43956C22B204336C3EAB2B", hash_generated_method = "553C32D727F6AD3A45CCE80E00756CE2")
    private static void nativeDraw(int canvas_instance, RectF loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "B67F6DCE2468E532A1C990B9D5E018DE", hash_generated_method = "55017D541F9719EC4C01DE912CD866AE")
    private static void nativeDraw(int canvas_instance, Rect loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.230 -0400", hash_original_method = "0F502DB0383B6654CBDFA70E91CC9D76", hash_generated_method = "C9BF777773EE86A9B3101F89AF050568")
    private static int nativeGetTransparentRegion(
            int bitmap, byte[] chunk, Rect location) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


