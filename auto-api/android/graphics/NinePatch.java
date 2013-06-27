package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NinePatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_field = "9AAC32C2595A9C136C2B2B291F82DBDA", hash_generated_field = "AA663839700E75596095EA5B2F89ACB9")

    private byte[] mChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_field = "80E799DF66AAB9A1337B2CCDF36F9929", hash_generated_field = "DB0C3CE567257EC5E2EF3955BE3033A2")

    private String mSrcName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.811 -0400", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "FDBCEF26C845555A069651CFEE5744A4")
    public  NinePatch(Bitmap bitmap, byte[] chunk, String srcName) {
        mBitmap = bitmap;
        mChunk = chunk;
        mSrcName = srcName;
        validateNinePatchChunk(mBitmap.ni(), chunk);
        // ---------- Original Method ----------
        //mBitmap = bitmap;
        //mChunk = chunk;
        //mSrcName = srcName;
        //validateNinePatchChunk(mBitmap.ni(), chunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.832 -0400", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "67281AB675DD487FADE69EC686585CDB")
    public  NinePatch(NinePatch patch) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.833 -0400", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "6C5BAF6F2F11B93DFDBE2A7B4FA1E0F5")
    public void setPaint(Paint p) {
        mPaint = p;
        // ---------- Original Method ----------
        //mPaint = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.834 -0400", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "00B657A9748F319055A1948462700995")
    public void draw(Canvas canvas, RectF location) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1489335612 = (!canvas.isHardwareAccelerated());
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
        addTaint(canvas.getTaint());
        addTaint(location.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.844 -0400", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "0CA7B37BEFF9C766C6839C3FE8555F8D")
    public void draw(Canvas canvas, Rect location) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1384241765 = (!canvas.isHardwareAccelerated());
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
        addTaint(canvas.getTaint());
        addTaint(location.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.864 -0400", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "4DF5496AB5C3B309E5AFF39DED832BDA")
    public void draw(Canvas canvas, Rect location, Paint paint) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1096934397 = (!canvas.isHardwareAccelerated());
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
        addTaint(canvas.getTaint());
        addTaint(location.getTaint());
        addTaint(paint.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.865 -0400", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "19F658F11B14A4F016B7C8846A2078DF")
    public int getDensity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962646947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962646947;
        // ---------- Original Method ----------
        //return mBitmap.mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.866 -0400", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "71DAFE613E07E65C4A954C7545F04299")
    public int getWidth() {
        int var57D36AC407EFDDA4FB3640AD5BF79509_2118696818 = (mBitmap.getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146536073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146536073;
        // ---------- Original Method ----------
        //return mBitmap.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.867 -0400", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "636E0975030D40691558C277143AB220")
    public int getHeight() {
        int varD4CB35A60B9E5617CB00E88FD9661C8C_1154865230 = (mBitmap.getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325669157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325669157;
        // ---------- Original Method ----------
        //return mBitmap.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.879 -0400", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "10C179CCE8E74CA18DCDE4BA07702794")
    public final boolean hasAlpha() {
        boolean varCC9B942DAF8C11B799B81316FCD04AE8_977605998 = (mBitmap.hasAlpha());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698582653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698582653;
        // ---------- Original Method ----------
        //return mBitmap.hasAlpha();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.881 -0400", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "69C9DA80F930ED924084EA16EAF8F310")
    public final Region getTransparentRegion(Rect location) {
        Region varB4EAC82CA7396A68D541C85D26508E83_353068800 = null; //Variable for return #1
        int r;
        r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        varB4EAC82CA7396A68D541C85D26508E83_353068800 = r != 0 ? new Region(r) : null;
        addTaint(location.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_353068800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_353068800;
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

