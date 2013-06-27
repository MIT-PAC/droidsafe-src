package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NinePatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.180 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.180 -0400", hash_original_field = "9AAC32C2595A9C136C2B2B291F82DBDA", hash_generated_field = "AA663839700E75596095EA5B2F89ACB9")

    private byte[] mChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.180 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.180 -0400", hash_original_field = "80E799DF66AAB9A1337B2CCDF36F9929", hash_generated_field = "DB0C3CE567257EC5E2EF3955BE3033A2")

    private String mSrcName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.181 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.194 -0400", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "FDBCEF26C845555A069651CFEE5744A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.196 -0400", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "67281AB675DD487FADE69EC686585CDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.197 -0400", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "6C5BAF6F2F11B93DFDBE2A7B4FA1E0F5")
    public void setPaint(Paint p) {
        mPaint = p;
        // ---------- Original Method ----------
        //mPaint = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.210 -0400", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "26BE2BC90258F72EB1C2CA6ACB61734C")
    public void draw(Canvas canvas, RectF location) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1645142329 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.212 -0400", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "C9F238E9D523A9BE572451410AA8EE65")
    public void draw(Canvas canvas, Rect location) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_929875895 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.226 -0400", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "3A2FD3916B36AA7CA879E058AE573B02")
    public void draw(Canvas canvas, Rect location, Paint paint) {
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1261968276 = (!canvas.isHardwareAccelerated());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.226 -0400", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "A1D26E967BE173A0E0C68B97C2A5511D")
    public int getDensity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302557999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302557999;
        // ---------- Original Method ----------
        //return mBitmap.mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.227 -0400", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "C2CDCACF2E84CBF932AE5889F1B19E73")
    public int getWidth() {
        int var57D36AC407EFDDA4FB3640AD5BF79509_1669523962 = (mBitmap.getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319667781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319667781;
        // ---------- Original Method ----------
        //return mBitmap.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.227 -0400", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "BD17360A83A795BB98CF5AF3F0885DA7")
    public int getHeight() {
        int varD4CB35A60B9E5617CB00E88FD9661C8C_1738696746 = (mBitmap.getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337128768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337128768;
        // ---------- Original Method ----------
        //return mBitmap.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.228 -0400", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "FC12ADC4F450521E5AC2588973C113BE")
    public final boolean hasAlpha() {
        boolean varCC9B942DAF8C11B799B81316FCD04AE8_1441621307 = (mBitmap.hasAlpha());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439692199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439692199;
        // ---------- Original Method ----------
        //return mBitmap.hasAlpha();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:13.229 -0400", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "938714BCC35157EDF055D5356BFC8EF4")
    public final Region getTransparentRegion(Rect location) {
        Region varB4EAC82CA7396A68D541C85D26508E83_14347976 = null; //Variable for return #1
        int r;
        r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        varB4EAC82CA7396A68D541C85D26508E83_14347976 = r != 0 ? new Region(r) : null;
        addTaint(location.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_14347976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14347976;
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

