package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;

class GLES20RecordingCanvas extends GLES20Canvas implements Poolable<GLES20RecordingCanvas> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.014 -0400", hash_original_field = "7B38C26CC56878D73DF5CEDF555F45AE", hash_generated_field = "35E28CCA15868A28E16FD08ECC45E14C")

    private GLES20RecordingCanvas mNextPoolable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.014 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.014 -0400", hash_original_field = "28797884D8917814D2A66A0146DC8FD5", hash_generated_field = "7DDFDE83419DEB0EF4C1B68E8EB5EE96")

    private GLES20DisplayList mDisplayList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.014 -0400", hash_original_method = "812619B49F53F101F754768C67C6D06B", hash_generated_method = "DB948983801BF86D0D9F511447C56561")
    private  GLES20RecordingCanvas() {
        super(true , true );
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    static GLES20RecordingCanvas obtain(GLES20DisplayList displayList) {
        GLES20RecordingCanvas canvas = sPool.acquire();
        canvas.mDisplayList = displayList;
        return canvas;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.015 -0400", hash_original_method = "4BF651B582CB590909780C1869866D8B", hash_generated_method = "3D0617C1B82933B36561C4CD058E7E05")
     void recycle() {
        mDisplayList = null;
        resetDisplayListRenderer();
        sPool.release(this);
        // ---------- Original Method ----------
        //mDisplayList = null;
        //resetDisplayListRenderer();
        //sPool.release(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.015 -0400", hash_original_method = "A71C73121DC15CD39FF9E0C285832C08", hash_generated_method = "7CD0CD2A12EBBD10623EBB86CFA6DF96")
     void start() {
        mDisplayList.mBitmaps.clear();
        // ---------- Original Method ----------
        //mDisplayList.mBitmaps.clear();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.016 -0400", hash_original_method = "71CBB11C79B7A62506CED8B00E21C814", hash_generated_method = "F4A0BF2DE7193AB2B5ADF240985F5CC5")
     int end(int nativeDisplayList) {
        addTaint(nativeDisplayList);
        int var350DF305047301C566992C4E00BEDCB4_191167139 = (getDisplayList(nativeDisplayList));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421128306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421128306;
        // ---------- Original Method ----------
        //return getDisplayList(nativeDisplayList);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.016 -0400", hash_original_method = "FB81CD87D0D9397EB08E4403B91E1B9C", hash_generated_method = "84A19FE355FA90A053D69892410B2F03")
    private void recordShaderBitmap(Paint paint) {
        addTaint(paint.getTaint());
    if(paint != null)        
        {
            final Shader shader = paint.getShader();
    if(shader instanceof BitmapShader)            
            {
                mDisplayList.mBitmaps.add(((BitmapShader) shader).mBitmap);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (paint != null) {
            //final Shader shader = paint.getShader();
            //if (shader instanceof BitmapShader) {
                //mDisplayList.mBitmaps.add(((BitmapShader) shader).mBitmap);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.017 -0400", hash_original_method = "CA25EBA5455666A6E9CEF7F1EE6D9382", hash_generated_method = "391F3A60380EF7E41A5ECD0D07319057")
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(chunks[0]);
        addTaint(bitmap.getTaint());
        super.drawPatch(bitmap, chunks, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawPatch(bitmap, chunks, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.017 -0400", hash_original_method = "DC4589341334316769F25D31A4526E34", hash_generated_method = "449B33B463CBCAA5FF28BE380430AA5A")
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(top);
        addTaint(left);
        addTaint(bitmap.getTaint());
        super.drawBitmap(bitmap, left, top, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, left, top, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.017 -0400", hash_original_method = "CFD3BD2C1BBA98F5626893D13AB7C95A", hash_generated_method = "59D9F85B65AA4625DAA42C812DCDDD44")
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(matrix.getTaint());
        addTaint(bitmap.getTaint());
        super.drawBitmap(bitmap, matrix, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, matrix, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.018 -0400", hash_original_method = "9D2E295A26539D23EF0FD856A55589EB", hash_generated_method = "1FC92FCEAEBB7508A2435B6B45119A81")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.018 -0400", hash_original_method = "4963172342BE3F3A14C54D98056B0F90", hash_generated_method = "D8DB9F357E1F07E7301DAA32562295BD")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.019 -0400", hash_original_method = "DB3E0CCCF2FCFB4CB333E762F8389779", hash_generated_method = "2D19080CE4E20144F8223B553F785458")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width,
            int height, boolean hasAlpha, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.020 -0400", hash_original_method = "CC1BFF66CF59C17AECED1F918B377AD4", hash_generated_method = "44BD992D13673ECB8DF78B7564882360")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width,
            int height, boolean hasAlpha, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.020 -0400", hash_original_method = "B7C59AEFBBFF71A556BD33964BA07740", hash_generated_method = "6255FBCE62202C7B7721B368F1104A14")
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(colorOffset);
        addTaint(colors[0]);
        addTaint(vertOffset);
        addTaint(verts[0]);
        addTaint(meshHeight);
        addTaint(meshWidth);
        addTaint(bitmap.getTaint());
        super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                //paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.020 -0400", hash_original_method = "4DF4209CA819AE22A2A14AA60ACB3697", hash_generated_method = "7FA98BE31BBFD397EDA6ED68FF58B4CD")
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(radius);
        addTaint(cy);
        addTaint(cx);
        super.drawCircle(cx, cy, radius, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawCircle(cx, cy, radius, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.021 -0400", hash_original_method = "30C4D3613633A9FCB7ECF231471F3979", hash_generated_method = "E078C640E182C457607A37862602BF3C")
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(stopY);
        addTaint(stopX);
        addTaint(startY);
        addTaint(startX);
        super.drawLine(startX, startY, stopX, stopY, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLine(startX, startY, stopX, stopY, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.021 -0400", hash_original_method = "C038B0F4E07BC63D9CC15294AD02864F", hash_generated_method = "FDE943AF1CA4E9DBD6DFE2980290C713")
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(count);
        addTaint(offset);
        addTaint(pts[0]);
        super.drawLines(pts, offset, count, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLines(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.021 -0400", hash_original_method = "AA7BADDFA2C89121B41A7D51CA556ABA", hash_generated_method = "C630CD9D40A1AD6BF6FA849384E37755")
    @Override
    public void drawLines(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        super.drawLines(pts, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLines(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.022 -0400", hash_original_method = "A2B91942D85687989A62C3285DF43905", hash_generated_method = "CC8C05D43D385F288AABCBBD43E06A32")
    @Override
    public void drawOval(RectF oval, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(oval.getTaint());
        super.drawOval(oval, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawOval(oval, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.022 -0400", hash_original_method = "7748C9BE2561EA173914AC3CFE087B19", hash_generated_method = "6567D55157454EF215213156E298CD48")
    @Override
    public void drawPaint(Paint paint) {
        addTaint(paint.getTaint());
        super.drawPaint(paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPaint(paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.022 -0400", hash_original_method = "3120F956E0FE224EB056D8CDF132CF1F", hash_generated_method = "D233308565F5D12EDA0144A02425044E")
    @Override
    public void drawPath(Path path, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(path.getTaint());
        super.drawPath(path, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPath(path, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.023 -0400", hash_original_method = "412A4CCC07E20298CEA55E5ECEB83C32", hash_generated_method = "5475AB463B1D63D3A9E799ABFF4F6897")
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        super.drawPoint(x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoint(x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.023 -0400", hash_original_method = "51E132A0609F9B860C87F98C31B83F8B", hash_generated_method = "0FEB7362827B8B9AB55B69B3809C11C7")
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(count);
        addTaint(offset);
        addTaint(pts[0]);
        super.drawPoints(pts, offset, count, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoints(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.023 -0400", hash_original_method = "3DB950A55A272851AB93E72BAA2C6BF0", hash_generated_method = "A9CA094AA2756DBF0F494F344EAAE78B")
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        super.drawPoints(pts, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoints(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.024 -0400", hash_original_method = "5812B7883E39E96F67ED930BCE1DE4A7", hash_generated_method = "7A2DE19F4BFEB33B1CC907A5AB9A8DCD")
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        super.drawPosText(text, index, count, pos, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPosText(text, index, count, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.024 -0400", hash_original_method = "CA8025B27EF9941F6DFBC1DE361D5F43", hash_generated_method = "E8D57A0273F93C0DCA46A13CED98F93F")
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(text.getTaint());
        super.drawPosText(text, pos, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPosText(text, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.024 -0400", hash_original_method = "D641E5ABFD7437F3EDFED3D71E56C934", hash_generated_method = "D2BFAC4BC7A6C6A00008FE31B70C005F")
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        super.drawRect(left, top, right, bottom, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(left, top, right, bottom, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.025 -0400", hash_original_method = "F96FFCB74ADCDDC7497B805FFF815A67", hash_generated_method = "F8E27C370A6EED654C0C70DA551AA8F1")
    @Override
    public void drawRect(Rect r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.025 -0400", hash_original_method = "F0BA570E177EFC714FE45C2E3865CC67", hash_generated_method = "86BA5B783EF078F61582D13AE63D443F")
    @Override
    public void drawRect(RectF r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.025 -0400", hash_original_method = "E275D35476CEA326D993C73B901ED23A", hash_generated_method = "42D44236AAC21880E7653CB2A3EDE4F4")
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(ry);
        addTaint(rx);
        addTaint(rect.getTaint());
        super.drawRoundRect(rect, rx, ry, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRoundRect(rect, rx, ry, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.026 -0400", hash_original_method = "60E63B8EF17911ACF468A6FDA91C5D63", hash_generated_method = "58D1C58438D8D62A0CE18DB2645A41EA")
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        super.drawText(text, index, count, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, index, count, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.026 -0400", hash_original_method = "585212AEA550FACE039047645BC98BED", hash_generated_method = "77F0C43229D3AA5D9274C1E4AB3E8444")
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.026 -0400", hash_original_method = "63DF32BDCE465690FDE2F1D69ECEEFE0", hash_generated_method = "3AEEF3A858BAA5C3334E8D47E0D70FB8")
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.027 -0400", hash_original_method = "0944F1DD1D16CFB38C8E528DA520FB54", hash_generated_method = "EA827CCB07CF15CD1DE9D47E7FEEC760")
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(text.getTaint());
        super.drawText(text, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.027 -0400", hash_original_method = "17C6301AC506947D36623830CCD53DA2", hash_generated_method = "EE75CC41F305E7597C59EF5B0DB87F87")
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(vOffset);
        addTaint(hOffset);
        addTaint(path.getTaint());
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.028 -0400", hash_original_method = "2FD74C6C408C83B9960286A926052773", hash_generated_method = "92B0B8CBADD886B5BB726708055CF927")
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(vOffset);
        addTaint(hOffset);
        addTaint(path.getTaint());
        addTaint(text.getTaint());
        super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.028 -0400", hash_original_method = "05CE94B81669916A196F6078E75D04C9", hash_generated_method = "14E75404EB3C1C6E8B0352E16F8D8B81")
    @Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dir);
        addTaint(y);
        addTaint(x);
        addTaint(contextCount);
        addTaint(contextIndex);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.029 -0400", hash_original_method = "E7125E7BBA30897AB93AB262D69717F5", hash_generated_method = "84D6BEFD691E0FAF922B4E46D1C8BF9B")
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart,
            int contextEnd, float x, float y, int dir, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dir);
        addTaint(y);
        addTaint(x);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.029 -0400", hash_original_method = "83D483EF2452A3F57A0616F8CAF895D5", hash_generated_method = "93B66F2676B62541F40B3E7B62592CE5")
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(indexCount);
        addTaint(indexOffset);
        addTaint(indices[0]);
        addTaint(colorOffset);
        addTaint(colors[0]);
        addTaint(texOffset);
        addTaint(texs[0]);
        addTaint(vertOffset);
        addTaint(verts[0]);
        addTaint(vertexCount);
        addTaint(mode.getTaint());
        super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                colorOffset, indices, indexOffset, indexCount, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                //colorOffset, indices, indexOffset, indexCount, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.030 -0400", hash_original_method = "9CAF97A102D33FFCF9C056A4D55F3569", hash_generated_method = "DF82B101FEBF96C771DE65BF68D21792")
    @Override
    public GLES20RecordingCanvas getNextPoolable() {
GLES20RecordingCanvas var5612CC1D0E3746BA465EFD9B27DD0183_1293848331 =         mNextPoolable;
        var5612CC1D0E3746BA465EFD9B27DD0183_1293848331.addTaint(taint);
        return var5612CC1D0E3746BA465EFD9B27DD0183_1293848331;
        // ---------- Original Method ----------
        //return mNextPoolable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.030 -0400", hash_original_method = "7B44EE8A9B50CDC1F4718A77AC31B644", hash_generated_method = "2EC27BE1EC2F279F97DC352220AC5CA9")
    @Override
    public void setNextPoolable(GLES20RecordingCanvas element) {
        mNextPoolable = element;
        // ---------- Original Method ----------
        //mNextPoolable = element;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.030 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "BD159D7634D766C510F5B333B216B00F")
    @Override
    public boolean isPooled() {
        boolean var224D05F4261498DA1D9DF38424832532_2101457011 = (mIsPooled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965376105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965376105;
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.031 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "340F14801E8F39C4D5683CC10C769565")
    @Override
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.031 -0400", hash_original_field = "E11E204BE01DF39B29FA162896B0C2DA", hash_generated_field = "0DE242031008609AEF5496C2CEEC2E7E")

    private static final int POOL_LIMIT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.031 -0400", hash_original_field = "A1C3683480416D197E1BFE168BB15056", hash_generated_field = "343893E106CDB914F2ED44928D11424F")

    private static final Pool<GLES20RecordingCanvas> sPool = Pools.synchronizedPool(
            Pools.finitePool(new PoolableManager<GLES20RecordingCanvas>() {
                public GLES20RecordingCanvas newInstance() {
                    return new GLES20RecordingCanvas();
                }
                @Override
                public void onAcquired(GLES20RecordingCanvas element) {
                }
                @Override
                public void onReleased(GLES20RecordingCanvas element) {
                }
            }, POOL_LIMIT));
}

