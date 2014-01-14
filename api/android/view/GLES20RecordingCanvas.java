package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.385 -0500", hash_original_method = "53E5FDBF859A33AAC863847F6B788FBD", hash_generated_method = "F5137FE27A1F74CD3EEAAE1E925C67FF")
    
static GLES20RecordingCanvas obtain(GLES20DisplayList displayList) {
        GLES20RecordingCanvas canvas = sPool.acquire();
        canvas.mDisplayList = displayList;
        return canvas;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.361 -0500", hash_original_field = "79F08CB26B07B865C0EC990011CCA336", hash_generated_field = "2BD52470E159A29B9F65DAAD0FA604F3")

    // view hierarchy because display lists are generated recursively.
    private static final int POOL_LIMIT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.230 -0400", hash_original_field = "A1C3683480416D197E1BFE168BB15056", hash_generated_field = "343893E106CDB914F2ED44928D11424F")

    private static final Pool<GLES20RecordingCanvas> sPool = Pools.synchronizedPool(
            Pools.finitePool(new PoolableManager<GLES20RecordingCanvas>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.364 -0500", hash_original_method = "53A8B9DE22CFBDFED10E2973CAFAEC8E", hash_generated_method = "CF40F342479B4F4A79E47EFA67AAF815")
        
public GLES20RecordingCanvas newInstance() {
                    return new GLES20RecordingCanvas();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.368 -0500", hash_original_method = "EC7B9FDFA0C3F40F823F6660CFD0596E", hash_generated_method = "D263A620F6B4569029859B1A88AF6ABF")
        
@Override
                public void onAcquired(GLES20RecordingCanvas element) {
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.371 -0500", hash_original_method = "830A30A4FF3F1B2BF2D0058C72D7284B", hash_generated_method = "8846930B89B98ADD0F02FF21A566E45D")
        
@Override
                public void onReleased(GLES20RecordingCanvas element) {
                }
            }, POOL_LIMIT));
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.375 -0500", hash_original_field = "A7AAA227AE246DD3E532BAF09A0425DB", hash_generated_field = "35E28CCA15868A28E16FD08ECC45E14C")

    private GLES20RecordingCanvas mNextPoolable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.377 -0500", hash_original_field = "016073DCFA93DD0305C42C8759ED2078", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

    private boolean mIsPooled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.380 -0500", hash_original_field = "538DA6A02CD4CBF9836B7D9AEFA242B3", hash_generated_field = "7DDFDE83419DEB0EF4C1B68E8EB5EE96")

    private GLES20DisplayList mDisplayList;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.382 -0500", hash_original_method = "812619B49F53F101F754768C67C6D06B", hash_generated_method = "5DEE3E6724C777E7BB89CDEA4B56592A")
    
private GLES20RecordingCanvas() {
        super(true /*record*/, true /*translucent*/);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.387 -0500", hash_original_method = "4BF651B582CB590909780C1869866D8B", hash_generated_method = "4BF651B582CB590909780C1869866D8B")
    
void recycle() {
        mDisplayList = null;
        resetDisplayListRenderer();
        sPool.release(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.389 -0500", hash_original_method = "A71C73121DC15CD39FF9E0C285832C08", hash_generated_method = "A71C73121DC15CD39FF9E0C285832C08")
    
void start() {
        mDisplayList.mBitmaps.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.391 -0500", hash_original_method = "71CBB11C79B7A62506CED8B00E21C814", hash_generated_method = "71CBB11C79B7A62506CED8B00E21C814")
    
int end(int nativeDisplayList) {
        return getDisplayList(nativeDisplayList);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.394 -0500", hash_original_method = "FB81CD87D0D9397EB08E4403B91E1B9C", hash_generated_method = "86AAF893AF1B83A1BA10AA5157941A07")
    
private void recordShaderBitmap(Paint paint) {
        if (paint != null) {
            final Shader shader = paint.getShader();
            if (shader instanceof BitmapShader) {
                mDisplayList.mBitmaps.add(((BitmapShader) shader).mBitmap);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.396 -0500", hash_original_method = "CA25EBA5455666A6E9CEF7F1EE6D9382", hash_generated_method = "3D96D7702F8CF642B8D35B173882D9D6")
    
@Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        super.drawPatch(bitmap, chunks, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.398 -0500", hash_original_method = "DC4589341334316769F25D31A4526E34", hash_generated_method = "7A9724BFB5F544E9FE30874E54F5FB79")
    
@Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        super.drawBitmap(bitmap, left, top, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.402 -0500", hash_original_method = "CFD3BD2C1BBA98F5626893D13AB7C95A", hash_generated_method = "7B4D41A321D5E4FA9A2680A529552AA6")
    
@Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        super.drawBitmap(bitmap, matrix, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.404 -0500", hash_original_method = "9D2E295A26539D23EF0FD856A55589EB", hash_generated_method = "A385CED3EDA8303B068597927E428F99")
    
@Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.408 -0500", hash_original_method = "4963172342BE3F3A14C54D98056B0F90", hash_generated_method = "6B0C4E3168FB2D41960521013F58D0F5")
    
@Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        super.drawBitmap(bitmap, src, dst, paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.410 -0500", hash_original_method = "DB3E0CCCF2FCFB4CB333E762F8389779", hash_generated_method = "C23A33689E88ABA5D9793E50E11DAB89")
    
@Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width,
            int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.413 -0500", hash_original_method = "CC1BFF66CF59C17AECED1F918B377AD4", hash_generated_method = "548EB36D2FC9EBC7545EBF630188E89E")
    
@Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width,
            int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.415 -0500", hash_original_method = "B7C59AEFBBFF71A556BD33964BA07740", hash_generated_method = "4DB930E62708FF6D267280F0B7BAF9EC")
    
@Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts,
            int vertOffset, int[] colors, int colorOffset, Paint paint) {
        super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset,
                paint);
        mDisplayList.mBitmaps.add(bitmap);
        // Shaders in the Paint are ignored when drawing a Bitmap
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.418 -0500", hash_original_method = "4DF4209CA819AE22A2A14AA60ACB3697", hash_generated_method = "FC57016B4E7CD98488260D4510533ADB")
    
@Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        super.drawCircle(cx, cy, radius, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.420 -0500", hash_original_method = "30C4D3613633A9FCB7ECF231471F3979", hash_generated_method = "EACC873E0818C0B86DE083339AF57214")
    
@Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        super.drawLine(startX, startY, stopX, stopY, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.423 -0500", hash_original_method = "C038B0F4E07BC63D9CC15294AD02864F", hash_generated_method = "3015021319C8FD60732DF49B82BF7DC6")
    
@Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        super.drawLines(pts, offset, count, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.425 -0500", hash_original_method = "AA7BADDFA2C89121B41A7D51CA556ABA", hash_generated_method = "0C9A005F72AD58AC9A57D61E4B4D0734")
    
@Override
    public void drawLines(float[] pts, Paint paint) {
        super.drawLines(pts, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.428 -0500", hash_original_method = "A2B91942D85687989A62C3285DF43905", hash_generated_method = "2B909D7016AEAE1897855DD7B9972BB5")
    
@Override
    public void drawOval(RectF oval, Paint paint) {
        super.drawOval(oval, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.431 -0500", hash_original_method = "7748C9BE2561EA173914AC3CFE087B19", hash_generated_method = "A4059BA42B960D39649E9E873F643E42")
    
@Override
    public void drawPaint(Paint paint) {
        super.drawPaint(paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.433 -0500", hash_original_method = "3120F956E0FE224EB056D8CDF132CF1F", hash_generated_method = "725A0F995755A40854FCF536E5BD392C")
    
@Override
    public void drawPath(Path path, Paint paint) {
        super.drawPath(path, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.436 -0500", hash_original_method = "412A4CCC07E20298CEA55E5ECEB83C32", hash_generated_method = "497D8FD605E05B11EA1124E783C845D3")
    
@Override
    public void drawPoint(float x, float y, Paint paint) {
        super.drawPoint(x, y, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.438 -0500", hash_original_method = "51E132A0609F9B860C87F98C31B83F8B", hash_generated_method = "FC26C29A89D033DC1180105FF39ECF9E")
    
@Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        super.drawPoints(pts, offset, count, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.440 -0500", hash_original_method = "3DB950A55A272851AB93E72BAA2C6BF0", hash_generated_method = "12B9B521D0F00AB78FA4A85CAB522EF3")
    
@Override
    public void drawPoints(float[] pts, Paint paint) {
        super.drawPoints(pts, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.443 -0500", hash_original_method = "5812B7883E39E96F67ED930BCE1DE4A7", hash_generated_method = "D928F9279ECF675F8580157607A25E8B")
    
@Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        super.drawPosText(text, index, count, pos, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.446 -0500", hash_original_method = "CA8025B27EF9941F6DFBC1DE361D5F43", hash_generated_method = "64EF44972494D9A43D9ED903F5051B42")
    
@Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        super.drawPosText(text, pos, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.448 -0500", hash_original_method = "D641E5ABFD7437F3EDFED3D71E56C934", hash_generated_method = "5F0F9B8A668DB61E48E41EA9A49D531B")
    
@Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        super.drawRect(left, top, right, bottom, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.451 -0500", hash_original_method = "F96FFCB74ADCDDC7497B805FFF815A67", hash_generated_method = "C86AB36CD389B0E03502A136BE0234EE")
    
@Override
    public void drawRect(Rect r, Paint paint) {
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.453 -0500", hash_original_method = "F0BA570E177EFC714FE45C2E3865CC67", hash_generated_method = "8FD20A56B9FEFA610ADD1B8F841C00A4")
    
@Override
    public void drawRect(RectF r, Paint paint) {
        super.drawRect(r, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.456 -0500", hash_original_method = "E275D35476CEA326D993C73B901ED23A", hash_generated_method = "8806C955819798F712B9D1B4D93E4C81")
    
@Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        super.drawRoundRect(rect, rx, ry, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.458 -0500", hash_original_method = "60E63B8EF17911ACF468A6FDA91C5D63", hash_generated_method = "C89DFFE6AE1C095FE5A178FB029DBA64")
    
@Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        super.drawText(text, index, count, x, y, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.461 -0500", hash_original_method = "585212AEA550FACE039047645BC98BED", hash_generated_method = "88A741BA8AB855C71C7635266D722782")
    
@Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.463 -0500", hash_original_method = "63DF32BDCE465690FDE2F1D69ECEEFE0", hash_generated_method = "F855096D413CAFBBEC90959A9A18E8A3")
    
@Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        super.drawText(text, start, end, x, y, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.466 -0500", hash_original_method = "0944F1DD1D16CFB38C8E528DA520FB54", hash_generated_method = "45298B03A8C67A42B75261438B49A7E5")
    
@Override
    public void drawText(String text, float x, float y, Paint paint) {
        super.drawText(text, x, y, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.468 -0500", hash_original_method = "17C6301AC506947D36623830CCD53DA2", hash_generated_method = "A127ECE9266713AD529FD522CA168659")
    
@Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset,
            float vOffset, Paint paint) {
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.471 -0500", hash_original_method = "2FD74C6C408C83B9960286A926052773", hash_generated_method = "7664B3B5872889A6776E06B31FC1CC4E")
    
@Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.474 -0500", hash_original_method = "05CE94B81669916A196F6078E75D04C9", hash_generated_method = "7110D390ABF83C6290BEB6C4D004A6BC")
    
@Override
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount,
            float x, float y, int dir, Paint paint) {
        super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, dir, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.476 -0500", hash_original_method = "E7125E7BBA30897AB93AB262D69717F5", hash_generated_method = "973D8F999AEF0C3957B174C03376FA8B")
    
@Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart,
            int contextEnd, float x, float y, int dir, Paint paint) {
        super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, dir, paint);
        recordShaderBitmap(paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.479 -0500", hash_original_method = "83D483EF2452A3F57A0616F8CAF895D5", hash_generated_method = "88A8C919FF94AE68F86DF8A9580977D4")
    
@Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset,
            float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices,
            int indexOffset, int indexCount, Paint paint) {
        super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors,
                colorOffset, indices, indexOffset, indexCount, paint);
        recordShaderBitmap(paint);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.481 -0500", hash_original_method = "9CAF97A102D33FFCF9C056A4D55F3569", hash_generated_method = "F2D59CF926F40D5152D2709AA01F0C2A")
    
@Override
    public GLES20RecordingCanvas getNextPoolable() {
        return mNextPoolable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.488 -0500", hash_original_method = "7B44EE8A9B50CDC1F4718A77AC31B644", hash_generated_method = "60EF11486833E735992FB26A040B3E24")
    
@Override
    public void setNextPoolable(GLES20RecordingCanvas element) {
        mNextPoolable = element;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.492 -0500", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "A772970D9332AB6848A8C1BDDD918043")
    
@Override
    public boolean isPooled() {
        return mIsPooled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:43.494 -0500", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "46B5BF13D3BDFACD57486AB650DF846E")
    
@Override
    public void setPooled(boolean isPooled) {
        mIsPooled = isPooled;
    }
}

