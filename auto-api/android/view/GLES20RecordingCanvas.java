package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.225 -0400", hash_original_field = "7B38C26CC56878D73DF5CEDF555F45AE", hash_generated_field = "35E28CCA15868A28E16FD08ECC45E14C")

    private GLES20RecordingCanvas mNextPoolable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.225 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.225 -0400", hash_original_field = "28797884D8917814D2A66A0146DC8FD5", hash_generated_field = "7DDFDE83419DEB0EF4C1B68E8EB5EE96")

    private GLES20DisplayList mDisplayList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.226 -0400", hash_original_method = "812619B49F53F101F754768C67C6D06B", hash_generated_method = "DB948983801BF86D0D9F511447C56561")
    private  GLES20RecordingCanvas() {
        super(true , true );
        // ---------- Original Method ----------
    }

    
        static GLES20RecordingCanvas obtain(GLES20DisplayList displayList) {
        GLES20RecordingCanvas canvas = sPool.acquire();
        canvas.mDisplayList = displayList;
        return canvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.227 -0400", hash_original_method = "4BF651B582CB590909780C1869866D8B", hash_generated_method = "3D0617C1B82933B36561C4CD058E7E05")
     void recycle() {
        mDisplayList = null;
        resetDisplayListRenderer();
        sPool.release(this);
        // ---------- Original Method ----------
        //mDisplayList = null;
        //resetDisplayListRenderer();
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.227 -0400", hash_original_method = "A71C73121DC15CD39FF9E0C285832C08", hash_generated_method = "7CD0CD2A12EBBD10623EBB86CFA6DF96")
     void start() {
        mDisplayList.mBitmaps.clear();
        // ---------- Original Method ----------
        //mDisplayList.mBitmaps.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.242 -0400", hash_original_method = "71CBB11C79B7A62506CED8B00E21C814", hash_generated_method = "6D8FD7FDDED0253CCC6BB15C20FC5999")
     int end(int nativeDisplayList) {
        int varE5F47972D5B6D2C5F4548479736404F6_1984111933 = (getDisplayList(nativeDisplayList));
        addTaint(nativeDisplayList);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430706501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430706501;
        // ---------- Original Method ----------
        //return getDisplayList(nativeDisplayList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.243 -0400", hash_original_method = "FB81CD87D0D9397EB08E4403B91E1B9C", hash_generated_method = "5D7652C3A424281EFE8D5A88FDD383DF")
    private void recordShaderBitmap(Paint paint) {
        {
            Shader shader;
            shader = paint.getShader();
            {
                mDisplayList.mBitmaps.add(((BitmapShader) shader).mBitmap);
            } //End block
        } //End block
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (paint != null) {
            //final Shader shader = paint.getShader();
            //if (shader instanceof BitmapShader) {
                //mDisplayList.mBitmaps.add(((BitmapShader) shader).mBitmap);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.243 -0400", hash_original_method = "CA25EBA5455666A6E9CEF7F1EE6D9382", hash_generated_method = "10FD249218B91F273FFD217A0DFC82EF")
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        super.drawPatch(bitmap, chunks, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(chunks[0]);
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPatch(bitmap, chunks, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.243 -0400", hash_original_method = "DC4589341334316769F25D31A4526E34", hash_generated_method = "A151CBD3E65A9F7CD759DF69E92071CA")
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        super.drawBitmap(bitmap, left, top, paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, left, top, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.244 -0400", hash_original_method = "CFD3BD2C1BBA98F5626893D13AB7C95A", hash_generated_method = "03B18EA310ACEA15176DDFD419BB181C")
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        super.drawBitmap(bitmap, matrix, paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(matrix.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, matrix, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.244 -0400", hash_original_method = "9D2E295A26539D23EF0FD856A55589EB", hash_generated_method = "884FD63C5CDB9AB3FC08478E35908B0A")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.259 -0400", hash_original_method = "4963172342BE3F3A14C54D98056B0F90", hash_generated_method = "8E9E68F30EECFACACAF520D308CD36A4")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.262 -0400", hash_original_method = "DB3E0CCCF2FCFB4CB333E762F8389779", hash_generated_method = "35E1B22847D4BA3E6F12B9341743D8FC")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width,
            int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        addTaint(colors[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        addTaint(hasAlpha);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.263 -0400", hash_original_method = "CC1BFF66CF59C17AECED1F918B377AD4", hash_generated_method = "082AA85EBD572D41886168FD12B35471")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width,
            int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        addTaint(colors[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        addTaint(hasAlpha);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.285 -0400", hash_original_method = "B7C59AEFBBFF71A556BD33964BA07740", hash_generated_method = "92C95009A5CA9D51B1C7786EDF8248DC")
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                paint);
        mDisplayList.mBitmaps.add(bitmap);
        addTaint(bitmap.getTaint());
        addTaint(meshWidth);
        addTaint(meshHeight);
        addTaint(verts[0]);
        addTaint(vertOffset);
        addTaint(colors[0]);
        addTaint(colorOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                //paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.286 -0400", hash_original_method = "4DF4209CA819AE22A2A14AA60ACB3697", hash_generated_method = "ADDDC9C2EDCBAAF63E714F53AABEA14D")
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        super.drawCircle(cx, cy, radius, paint);
        recordShaderBitmap(paint);
        addTaint(cx);
        addTaint(cy);
        addTaint(radius);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawCircle(cx, cy, radius, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.296 -0400", hash_original_method = "30C4D3613633A9FCB7ECF231471F3979", hash_generated_method = "ADB68F06B6110FC08D01F1DFAEB61251")
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        super.drawLine(startX, startY, stopX, stopY, paint);
        recordShaderBitmap(paint);
        addTaint(startX);
        addTaint(startY);
        addTaint(stopX);
        addTaint(stopY);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawLine(startX, startY, stopX, stopY, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.297 -0400", hash_original_method = "C038B0F4E07BC63D9CC15294AD02864F", hash_generated_method = "074DAF43978BDAF57AD209F7D03FB6CF")
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        super.drawLines(pts, offset, count, paint);
        recordShaderBitmap(paint);
        addTaint(pts[0]);
        addTaint(offset);
        addTaint(count);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawLines(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.298 -0400", hash_original_method = "AA7BADDFA2C89121B41A7D51CA556ABA", hash_generated_method = "B1AB764FE331C182BF0C3788AD7A06F9")
    @Override
    public void drawLines(float[] pts, Paint paint) {
        super.drawLines(pts, paint);
        recordShaderBitmap(paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawLines(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.298 -0400", hash_original_method = "A2B91942D85687989A62C3285DF43905", hash_generated_method = "93F197E8179554398B4AB85E227E6172")
    @Override
    public void drawOval(RectF oval, Paint paint) {
        super.drawOval(oval, paint);
        recordShaderBitmap(paint);
        addTaint(oval.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawOval(oval, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.298 -0400", hash_original_method = "7748C9BE2561EA173914AC3CFE087B19", hash_generated_method = "6F5D57D0E201E035693B34889547DF88")
    @Override
    public void drawPaint(Paint paint) {
        super.drawPaint(paint);
        recordShaderBitmap(paint);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPaint(paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.301 -0400", hash_original_method = "3120F956E0FE224EB056D8CDF132CF1F", hash_generated_method = "4ADB47377B5A7B7E615212DE0F0C8BDC")
    @Override
    public void drawPath(Path path, Paint paint) {
        super.drawPath(path, paint);
        recordShaderBitmap(paint);
        addTaint(path.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPath(path, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.317 -0400", hash_original_method = "412A4CCC07E20298CEA55E5ECEB83C32", hash_generated_method = "3600D84A20FF58E896144369373284DE")
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        super.drawPoint(x, y, paint);
        recordShaderBitmap(paint);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPoint(x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.318 -0400", hash_original_method = "51E132A0609F9B860C87F98C31B83F8B", hash_generated_method = "AE78AF9E67FEE9071BE7C54E242AA41B")
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        super.drawPoints(pts, offset, count, paint);
        recordShaderBitmap(paint);
        addTaint(pts[0]);
        addTaint(offset);
        addTaint(count);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPoints(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.318 -0400", hash_original_method = "3DB950A55A272851AB93E72BAA2C6BF0", hash_generated_method = "9EA7908665BE95DA504718950A07FAA3")
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        super.drawPoints(pts, paint);
        recordShaderBitmap(paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPoints(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.319 -0400", hash_original_method = "5812B7883E39E96F67ED930BCE1DE4A7", hash_generated_method = "C4FC409F8E0CB25B21E8657FDA2DFB94")
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        super.drawPosText(text, index, count, pos, paint);
        recordShaderBitmap(paint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPosText(text, index, count, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.320 -0400", hash_original_method = "CA8025B27EF9941F6DFBC1DE361D5F43", hash_generated_method = "A890349CC3D35C7CA91D18E82790C52B")
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        super.drawPosText(text, pos, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawPosText(text, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.321 -0400", hash_original_method = "D641E5ABFD7437F3EDFED3D71E56C934", hash_generated_method = "5DA0C941F3952ADB432039F6C6CD9731")
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        super.drawRect(left, top, right, bottom, paint);
        recordShaderBitmap(paint);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawRect(left, top, right, bottom, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.321 -0400", hash_original_method = "F96FFCB74ADCDDC7497B805FFF815A67", hash_generated_method = "7DCB54132645FB68B4CD3CE265C623B2")
    @Override
    public void drawRect(Rect r, Paint paint) {
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        addTaint(r.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.335 -0400", hash_original_method = "F0BA570E177EFC714FE45C2E3865CC67", hash_generated_method = "DA0FFEACCB22B69EB99CBA7608282347")
    @Override
    public void drawRect(RectF r, Paint paint) {
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        addTaint(r.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.335 -0400", hash_original_method = "E275D35476CEA326D993C73B901ED23A", hash_generated_method = "BC28AFC30C6B1ED6A3752C66A4DA600F")
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        super.drawRoundRect(rect, rx, ry, paint);
        recordShaderBitmap(paint);
        addTaint(rect.getTaint());
        addTaint(rx);
        addTaint(ry);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawRoundRect(rect, rx, ry, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.336 -0400", hash_original_method = "60E63B8EF17911ACF468A6FDA91C5D63", hash_generated_method = "172CF3D847A65F9BBE26A33F0B8D73AE")
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        super.drawText(text, index, count, x, y, paint);
        recordShaderBitmap(paint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawText(text, index, count, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.337 -0400", hash_original_method = "585212AEA550FACE039047645BC98BED", hash_generated_method = "EAD31888E4FCDDAF900DB336FA75CA76")
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.337 -0400", hash_original_method = "63DF32BDCE465690FDE2F1D69ECEEFE0", hash_generated_method = "2FDA9FA9433342E7B233A178EA014BCF")
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.338 -0400", hash_original_method = "0944F1DD1D16CFB38C8E528DA520FB54", hash_generated_method = "928738DBE098DD84C0E12B6A6F44AC36")
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        super.drawText(text, x, y, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawText(text, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.338 -0400", hash_original_method = "17C6301AC506947D36623830CCD53DA2", hash_generated_method = "7DCBAF308E5968696EE87A1365F7B43F")
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.352 -0400", hash_original_method = "2FD74C6C408C83B9960286A926052773", hash_generated_method = "A08F412AFE1A7A67D14F5187AB9B92CC")
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.352 -0400", hash_original_method = "05CE94B81669916A196F6078E75D04C9", hash_generated_method = "5C416CE3714EE76074223DD73ACDFD87")
    @Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        recordShaderBitmap(paint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(contextIndex);
        addTaint(contextCount);
        addTaint(x);
        addTaint(y);
        addTaint(dir);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.353 -0400", hash_original_method = "E7125E7BBA30897AB93AB262D69717F5", hash_generated_method = "8B28EDBD5515224292A8348E005B63AE")
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart,
            int contextEnd, float x, float y, int dir, Paint paint) {
        super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        recordShaderBitmap(paint);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(contextStart);
        addTaint(contextEnd);
        addTaint(x);
        addTaint(y);
        addTaint(dir);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.354 -0400", hash_original_method = "83D483EF2452A3F57A0616F8CAF895D5", hash_generated_method = "90958A17FF5A93087CAA7E19DF0123C6")
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                colorOffset, indices, indexOffset, indexCount, paint);
        recordShaderBitmap(paint);
        addTaint(mode.getTaint());
        addTaint(vertexCount);
        addTaint(verts[0]);
        addTaint(vertOffset);
        addTaint(texs[0]);
        addTaint(texOffset);
        addTaint(colors[0]);
        addTaint(colorOffset);
        addTaint(indices[0]);
        addTaint(indexOffset);
        addTaint(indexCount);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                //colorOffset, indices, indexOffset, indexCount, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.363 -0400", hash_original_method = "9CAF97A102D33FFCF9C056A4D55F3569", hash_generated_method = "213579D34A14FE7D48ED95E765CF53C9")
    @Override
    public GLES20RecordingCanvas getNextPoolable() {
        GLES20RecordingCanvas varB4EAC82CA7396A68D541C85D26508E83_1882152044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1882152044 = mNextPoolable;
        varB4EAC82CA7396A68D541C85D26508E83_1882152044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1882152044;
        // ---------- Original Method ----------
        //return mNextPoolable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.364 -0400", hash_original_method = "7B44EE8A9B50CDC1F4718A77AC31B644", hash_generated_method = "2EC27BE1EC2F279F97DC352220AC5CA9")
    @Override
    public void setNextPoolable(GLES20RecordingCanvas element) {
        mNextPoolable = element;
        // ---------- Original Method ----------
        //mNextPoolable = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.364 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "737F883CD43D8F983357BFD11F07B696")
    @Override
    public boolean isPooled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160891798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160891798;
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.364 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "340F14801E8F39C4D5683CC10C769565")
    @Override
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.364 -0400", hash_original_field = "E11E204BE01DF39B29FA162896B0C2DA", hash_generated_field = "695ACAC5048B1B3A28E05268F29F0EA4")

    private static int POOL_LIMIT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.365 -0400", hash_original_field = "A1C3683480416D197E1BFE168BB15056", hash_generated_field = "B00827D6085F3967509C9E860BFDF69C")

    private static Pool<GLES20RecordingCanvas> sPool = Pools.synchronizedPool(
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

