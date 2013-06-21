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
    private GLES20RecordingCanvas mNextPoolable;
    private boolean mIsPooled;
    private GLES20DisplayList mDisplayList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.670 -0400", hash_original_method = "812619B49F53F101F754768C67C6D06B", hash_generated_method = "DB948983801BF86D0D9F511447C56561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GLES20RecordingCanvas() {
        super(true , true );
        // ---------- Original Method ----------
    }

    
        static GLES20RecordingCanvas obtain(GLES20DisplayList displayList) {
        GLES20RecordingCanvas canvas = sPool.acquire();
        canvas.mDisplayList = displayList;
        return canvas;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.671 -0400", hash_original_method = "4BF651B582CB590909780C1869866D8B", hash_generated_method = "3D0617C1B82933B36561C4CD058E7E05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void recycle() {
        mDisplayList = null;
        resetDisplayListRenderer();
        sPool.release(this);
        // ---------- Original Method ----------
        //mDisplayList = null;
        //resetDisplayListRenderer();
        //sPool.release(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.671 -0400", hash_original_method = "A71C73121DC15CD39FF9E0C285832C08", hash_generated_method = "7CD0CD2A12EBBD10623EBB86CFA6DF96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void start() {
        mDisplayList.mBitmaps.clear();
        // ---------- Original Method ----------
        //mDisplayList.mBitmaps.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.671 -0400", hash_original_method = "71CBB11C79B7A62506CED8B00E21C814", hash_generated_method = "50BFE114291E39482CF53661B1CC2CE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int end(int nativeDisplayList) {
        dsTaint.addTaint(nativeDisplayList);
        int varE5F47972D5B6D2C5F4548479736404F6_1178738403 = (getDisplayList(nativeDisplayList));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getDisplayList(nativeDisplayList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.671 -0400", hash_original_method = "FB81CD87D0D9397EB08E4403B91E1B9C", hash_generated_method = "1C7BA40CC778DDFA43E63E03E82A2DC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordShaderBitmap(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        {
            Shader shader;
            shader = paint.getShader();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.671 -0400", hash_original_method = "CA25EBA5455666A6E9CEF7F1EE6D9382", hash_generated_method = "B5DEC34CD6D0101EBBE645612230D38B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        dsTaint.addTaint(chunks[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        super.drawPatch(bitmap, chunks, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawPatch(bitmap, chunks, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "DC4589341334316769F25D31A4526E34", hash_generated_method = "B496B23C69452816C5352C4EEEB52CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(top);
        super.drawBitmap(bitmap, left, top, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, left, top, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "CFD3BD2C1BBA98F5626893D13AB7C95A", hash_generated_method = "CA69498E39ACCD50C2E756C4F32A0D6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(matrix.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        super.drawBitmap(bitmap, matrix, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, matrix, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "9D2E295A26539D23EF0FD856A55589EB", hash_generated_method = "ACE11734EBD19D3FAD3F8BC872C22835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "4963172342BE3F3A14C54D98056B0F90", hash_generated_method = "1FE1A354EB0A58A40ADFCA8E97473FAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmap(bitmap, src, dst, paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "DB3E0CCCF2FCFB4CB333E762F8389779", hash_generated_method = "A2962FE9111B5762E5519B3EF54288E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width,
            int height, boolean hasAlpha, Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.672 -0400", hash_original_method = "CC1BFF66CF59C17AECED1F918B377AD4", hash_generated_method = "9C31FB57E8235E39B423A027A2E95771")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width,
            int height, boolean hasAlpha, Paint paint) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(width);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(hasAlpha);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // ---------- Original Method ----------
        //super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.673 -0400", hash_original_method = "B7C59AEFBBFF71A556BD33964BA07740", hash_generated_method = "21CAA265466626DE7C83A9EE94034466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(meshWidth);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(verts[0]);
        dsTaint.addTaint(meshHeight);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vertOffset);
        super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                paint);
        mDisplayList.mBitmaps.add(bitmap);
        // ---------- Original Method ----------
        //super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                //paint);
        //mDisplayList.mBitmaps.add(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.673 -0400", hash_original_method = "4DF4209CA819AE22A2A14AA60ACB3697", hash_generated_method = "692C9DB2C3BB075BA1FB9123493239BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(radius);
        dsTaint.addTaint(cx);
        super.drawCircle(cx, cy, radius, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawCircle(cx, cy, radius, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.673 -0400", hash_original_method = "30C4D3613633A9FCB7ECF231471F3979", hash_generated_method = "70B465F9FAE2994279DA978F0C7B0D90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(stopX);
        dsTaint.addTaint(stopY);
        dsTaint.addTaint(paint.dsTaint);
        super.drawLine(startX, startY, stopX, stopY, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLine(startX, startY, stopX, stopY, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.673 -0400", hash_original_method = "C038B0F4E07BC63D9CC15294AD02864F", hash_generated_method = "79D5EB6DAD6620033C17B42D36EE8945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
        super.drawLines(pts, offset, count, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLines(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.673 -0400", hash_original_method = "AA7BADDFA2C89121B41A7D51CA556ABA", hash_generated_method = "EF1F92974B872F394823A5813C9BE58D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawLines(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        super.drawLines(pts, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawLines(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "A2B91942D85687989A62C3285DF43905", hash_generated_method = "BF45449F937FF9DB5A7744259166A9BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawOval(RectF oval, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(oval.dsTaint);
        super.drawOval(oval, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawOval(oval, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "7748C9BE2561EA173914AC3CFE087B19", hash_generated_method = "37B70314CE2877DDEAF8C18314A50032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPaint(Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        super.drawPaint(paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPaint(paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "3120F956E0FE224EB056D8CDF132CF1F", hash_generated_method = "27BA6317C10FCFEE115218EC593EB16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPath(Path path, Paint paint) {
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        super.drawPath(path, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPath(path, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "412A4CCC07E20298CEA55E5ECEB83C32", hash_generated_method = "513CAD627560227BE51AD3E807C7F1EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawPoint(x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoint(x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "51E132A0609F9B860C87F98C31B83F8B", hash_generated_method = "B10DC24B9DA3A758BF3BA2F1C8C106F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pts[0]);
        super.drawPoints(pts, offset, count, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoints(pts, offset, count, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.674 -0400", hash_original_method = "3DB950A55A272851AB93E72BAA2C6BF0", hash_generated_method = "92D5027FA41A717698D79BA006F4CA28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pts[0]);
        super.drawPoints(pts, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPoints(pts, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "5812B7883E39E96F67ED930BCE1DE4A7", hash_generated_method = "CF7B2A93545DD9C02CB5D521109A86A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        super.drawPosText(text, index, count, pos, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPosText(text, index, count, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "CA8025B27EF9941F6DFBC1DE361D5F43", hash_generated_method = "B4702775F2C60377A3714C83F698C1BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(pos[0]);
        super.drawPosText(text, pos, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawPosText(text, pos, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "D641E5ABFD7437F3EDFED3D71E56C934", hash_generated_method = "FBBBBA52FA4E445DC9979C88CCACE09B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        super.drawRect(left, top, right, bottom, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(left, top, right, bottom, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "F96FFCB74ADCDDC7497B805FFF815A67", hash_generated_method = "A58D0ED8ABB3147B228ABE044691AA42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(Rect r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "F0BA570E177EFC714FE45C2E3865CC67", hash_generated_method = "C4DD9D43251542D09B72DB8558743175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRect(RectF r, Paint paint) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRect(r, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.675 -0400", hash_original_method = "E275D35476CEA326D993C73B901ED23A", hash_generated_method = "2FCB48A97590AF35E9DB7067992821AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(rx);
        dsTaint.addTaint(ry);
        super.drawRoundRect(rect, rx, ry, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawRoundRect(rect, rx, ry, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "60E63B8EF17911ACF468A6FDA91C5D63", hash_generated_method = "5D1B5A4F9CDB4A7B2A7B5329E51CF082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawText(text, index, count, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, index, count, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "585212AEA550FACE039047645BC98BED", hash_generated_method = "02CE71DCAA4C40A399A9CDD28487B8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "63DF32BDCE465690FDE2F1D69ECEEFE0", hash_generated_method = "82BFB7E656CC8BE63DC1EFA7CDA1FBB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, start, end, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "0944F1DD1D16CFB38C8E528DA520FB54", hash_generated_method = "57902DF4EDE12C639186A9B26480C7B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawText(text, x, y, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawText(text, x, y, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "17C6301AC506947D36623830CCD53DA2", hash_generated_method = "DAAB7111419A4226014A04781338685C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(count);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.676 -0400", hash_original_method = "2FD74C6C408C83B9960286A926052773", hash_generated_method = "5F69C3D3E26A4730E261EB9B6D083AB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(hOffset);
        dsTaint.addTaint(path.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vOffset);
        super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.677 -0400", hash_original_method = "05CE94B81669916A196F6078E75D04C9", hash_generated_method = "95B219163BA58243650817E04E059008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        dsTaint.addTaint(contextCount);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(contextIndex);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.677 -0400", hash_original_method = "E7125E7BBA30897AB93AB262D69717F5", hash_generated_method = "B24A888083AA958C36CA8C62D0F9481A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart,
            int contextEnd, float x, float y, int dir, Paint paint) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(dir);
        dsTaint.addTaint(contextStart);
        dsTaint.addTaint(start);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(end);
        dsTaint.addTaint(x);
        dsTaint.addTaint(contextEnd);
        super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.677 -0400", hash_original_method = "83D483EF2452A3F57A0616F8CAF895D5", hash_generated_method = "992914513B0674CD8C76F65FED4C3ADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        dsTaint.addTaint(colorOffset);
        dsTaint.addTaint(vertexCount);
        dsTaint.addTaint(indexOffset);
        dsTaint.addTaint(texs[0]);
        dsTaint.addTaint(indexCount);
        dsTaint.addTaint(texOffset);
        dsTaint.addTaint(colors[0]);
        dsTaint.addTaint(verts[0]);
        dsTaint.addTaint(indices[0]);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(vertOffset);
        dsTaint.addTaint(mode.dsTaint);
        super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                colorOffset, indices, indexOffset, indexCount, paint);
        recordShaderBitmap(paint);
        // ---------- Original Method ----------
        //super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                //colorOffset, indices, indexOffset, indexCount, paint);
        //recordShaderBitmap(paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.677 -0400", hash_original_method = "9CAF97A102D33FFCF9C056A4D55F3569", hash_generated_method = "996D2DED2BD6F4D7E29890E99763B0E3")
    @DSModeled(DSC.SAFE)
    @Override
    public GLES20RecordingCanvas getNextPoolable() {
        return (GLES20RecordingCanvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNextPoolable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.677 -0400", hash_original_method = "7B44EE8A9B50CDC1F4718A77AC31B644", hash_generated_method = "17AC688386841426D9102D9F02D44DE7")
    @DSModeled(DSC.SAFE)
    @Override
    public void setNextPoolable(GLES20RecordingCanvas element) {
        dsTaint.addTaint(element.dsTaint);
        // ---------- Original Method ----------
        //mNextPoolable = element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.678 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "D37AF8DC239CFE9A7D68BF3D6672D22B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isPooled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPooled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.678 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "9DB634BE52ABE622D9902851D3C72B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public void setPooled(boolean isPooled) {
        dsTaint.addTaint(isPooled);
        // ---------- Original Method ----------
        //mIsPooled = isPooled;
    }

    
    private static final int POOL_LIMIT = 25;
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

