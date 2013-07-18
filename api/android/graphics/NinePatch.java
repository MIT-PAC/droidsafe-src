package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class NinePatch {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_field = "9AAC32C2595A9C136C2B2B291F82DBDA", hash_generated_field = "AA663839700E75596095EA5B2F89ACB9")

    private byte[] mChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_field = "80E799DF66AAB9A1337B2CCDF36F9929", hash_generated_field = "DB0C3CE567257EC5E2EF3955BE3033A2")

    private String mSrcName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E70F5B350707014CDC8DCA8B7C0C28DD")

    private final RectF mRect = new RectF();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_method = "D88879F567A4CA145787F3AF3B8F5F18", hash_generated_method = "FDBCEF26C845555A069651CFEE5744A4")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.363 -0400", hash_original_method = "578697A0E71C0E213522F36880BE7410", hash_generated_method = "6981D35AE9F988AB316977678E776170")
    public  NinePatch(NinePatch patch) {
        mBitmap = patch.mBitmap;
        mChunk = patch.mChunk;
        mSrcName = patch.mSrcName;
        if(patch.mPaint != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.364 -0400", hash_original_method = "D0981A681D74F230E15D58DC6CAB4B12", hash_generated_method = "6C5BAF6F2F11B93DFDBE2A7B4FA1E0F5")
    public void setPaint(Paint p) {
        mPaint = p;
        // ---------- Original Method ----------
        //mPaint = p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.364 -0400", hash_original_method = "EAF50CB5C0E6A8C8743BB0867CC2AAFE", hash_generated_method = "A32484557F9DB6B2067C2D353CD740E4")
    public void draw(Canvas canvas, RectF location) {
        addTaint(location.getTaint());
        addTaint(canvas.getTaint());
        if(!canvas.isHardwareAccelerated())        
        {
            nativeDraw(canvas.mNativeCanvas, location,
                       mBitmap.ni(), mChunk,
                       mPaint != null ? mPaint.mNativePaint : 0,
                       canvas.mDensity, mBitmap.mDensity);
        } //End block
        else
        {
            canvas.drawPatch(mBitmap, mChunk, location, mPaint);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.364 -0400", hash_original_method = "0ABE1DB59D00B8D3A7DF4CB4F149C27D", hash_generated_method = "AC439821CB8F5764A85B383BD3632006")
    public void draw(Canvas canvas, Rect location) {
        addTaint(location.getTaint());
        addTaint(canvas.getTaint());
        if(!canvas.isHardwareAccelerated())        
        {
            nativeDraw(canvas.mNativeCanvas, location,
                        mBitmap.ni(), mChunk,
                        mPaint != null ? mPaint.mNativePaint : 0,
                        canvas.mDensity, mBitmap.mDensity);
        } //End block
        else
        {
            mRect.set(location);
            canvas.drawPatch(mBitmap, mChunk, mRect, mPaint);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.364 -0400", hash_original_method = "CF14EE2D4C6547AB65BEAA94D29C006C", hash_generated_method = "6EAB0819AE11A04776E4F87DD4267693")
    public void draw(Canvas canvas, Rect location, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(location.getTaint());
        addTaint(canvas.getTaint());
        if(!canvas.isHardwareAccelerated())        
        {
            nativeDraw(canvas.mNativeCanvas, location,
                    mBitmap.ni(), mChunk, paint != null ? paint.mNativePaint : 0,
                    canvas.mDensity, mBitmap.mDensity);
        } //End block
        else
        {
            mRect.set(location);
            canvas.drawPatch(mBitmap, mChunk, mRect, paint);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.365 -0400", hash_original_method = "27EBBFC0A49FBB6B32AE88535DB257BA", hash_generated_method = "639DA7ECDF2AFDAA0215FC6B3C050FB9")
    public int getDensity() {
        int var9E30D0A74E195321DF2F63FF8FEFFFBD_657981030 = (mBitmap.mDensity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747185650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747185650;
        // ---------- Original Method ----------
        //return mBitmap.mDensity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.365 -0400", hash_original_method = "248DEDBBF8E87ACAD7F5460B83DB8F69", hash_generated_method = "3BDB00734BB8FD2EBE27A9687142A62F")
    public int getWidth() {
        int varF582257C9BC06C3475683DA9F9AE7919_286351856 = (mBitmap.getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806336464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806336464;
        // ---------- Original Method ----------
        //return mBitmap.getWidth();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.365 -0400", hash_original_method = "2785E3A64A823A27985D4386D66934E2", hash_generated_method = "1C69A82DA0711F7E35E3AC563EAA6D7A")
    public int getHeight() {
        int varC25E084EBC4D9358C01EBD9A3B801212_2105667482 = (mBitmap.getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962686551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962686551;
        // ---------- Original Method ----------
        //return mBitmap.getHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.365 -0400", hash_original_method = "E05D2C3DAD463E01AE2524510542E014", hash_generated_method = "CD6AB962DD4E1A68A2D3858156285A0B")
    public final boolean hasAlpha() {
        boolean varFF9794086A6F899230C172EE02D57A54_923177185 = (mBitmap.hasAlpha());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038687374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038687374;
        // ---------- Original Method ----------
        //return mBitmap.hasAlpha();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.365 -0400", hash_original_method = "057B771D19C75A7C087A15EB64E8E6F2", hash_generated_method = "2D8317FB9E0BCC501ED885EDD65A57A4")
    public final Region getTransparentRegion(Rect location) {
        addTaint(location.getTaint());
        int r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
Region var649A544237119CDAA836B920E8287C24_1286489823 =         r != 0 ? new Region(r) : null;
        var649A544237119CDAA836B920E8287C24_1286489823.addTaint(taint);
        return var649A544237119CDAA836B920E8287C24_1286489823;
        // ---------- Original Method ----------
        //int r = nativeGetTransparentRegion(mBitmap.ni(), mChunk, location);
        //return r != 0 ? new Region(r) : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNinePatchChunk(byte[] chunk) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void validateNinePatchChunk(int bitmap, byte[] chunk) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDraw(int canvas_instance, RectF loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDraw(int canvas_instance, Rect loc, int bitmap_instance,
                                          byte[] c, int paint_instance_or_null,
                                          int destDensity, int srcDensity) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetTransparentRegion(
            int bitmap, byte[] chunk, Rect location) {
        return DSUtils.UNKNOWN_INT;
    }

    
}

