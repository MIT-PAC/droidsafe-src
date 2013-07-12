package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.TemporaryBuffer;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

class GLES20Canvas extends HardwareCanvas {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "D57F412B2FBE34E5266AB85A3EC09555", hash_generated_field = "EB29C468CD6CC66BADB54A0F112750F9")

    private boolean mOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

    private int mRenderer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "8A3D5C4CB4C335D9AECD1C2651D2AAAF")

    @SuppressWarnings({"unused", "FieldCanBeLocal"}) private CanvasFinalizer mFinalizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "A71103FAF0A55FA79982ACB43DFBC49A", hash_generated_field = "6791C5CD1248B8A3047AAAB23F781F88")

    private final float[] mPoint = new float[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.910 -0400", hash_original_field = "8AF780D9E9617941A63F16F3D6400B2F", hash_generated_field = "BB2122C190B62908BBEDD5B8E43D320D")

    private final float[] mLine = new float[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.911 -0400", hash_original_field = "A51A4E6456596E09991D8FF2155CE00E", hash_generated_field = "49E49C9D9740E032CABA98DD5151CA56")

    private final Rect mClipBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.911 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "7E8B7E1A9144C0D301C8FE334261595B")

    private DrawFilter mFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.911 -0400", hash_original_method = "E61B8AD2F95A2B414E32399D6E0EB15F", hash_generated_method = "2AFB8DAA72D20488621230DD00C5A8A5")
      GLES20Canvas(boolean translucent) {
        this(false, translucent);
        addTaint(translucent);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.911 -0400", hash_original_method = "7F059AE8F3F932B35FF16ED888919AA8", hash_generated_method = "74FC0FA718B9D10E4233916A4857DF72")
      GLES20Canvas(int layer, boolean translucent) {
        mOpaque = !translucent;
        mRenderer = nCreateLayerRenderer(layer);
        setupFinalizer();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.912 -0400", hash_original_method = "E76C4C3F056A713824BBE7237B891059", hash_generated_method = "71C01C0F92BAF29181A5B3B9E2729313")
    protected  GLES20Canvas(boolean record, boolean translucent) {
        addTaint(record);
        mOpaque = !translucent;
    if(record)        
        {
            mRenderer = nCreateDisplayListRenderer();
        } 
        else
        {
            mRenderer = nCreateRenderer();
        } 
        setupFinalizer();
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nIsAvailable() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        @DSModeled(DSC.SAFE)
    static boolean isAvailable() {
        return sIsAvailable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.913 -0400", hash_original_method = "C5F1546049F1B2879B50EF00176E7660", hash_generated_method = "30D1F75DFEA72A742D251B10BA7A9CEA")
    private void setupFinalizer() {
    if(mRenderer == 0)        
        {
            IllegalStateException varC4B7F850A06E1E30E038C65FAC0396C6_713724507 = new IllegalStateException("Could not create GLES20Canvas renderer");
            varC4B7F850A06E1E30E038C65FAC0396C6_713724507.addTaint(taint);
            throw varC4B7F850A06E1E30E038C65FAC0396C6_713724507;
        } 
        else
        {
            mFinalizer = new CanvasFinalizer(mRenderer);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.913 -0400", hash_original_method = "DC942AC5C00E84A83A7A0337B1608CAB", hash_generated_method = "E424FF35B49ED518F1C9932756CF66A2")
    protected void resetDisplayListRenderer() {
        nResetDisplayListRenderer(mRenderer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nCreateRenderer() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nCreateLayerRenderer(int layer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nCreateDisplayListRenderer() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nResetDisplayListRenderer(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDestroyRenderer(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    static int nCreateTextureLayer(boolean opaque, int[] layerInfo) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static int nCreateLayer(int width, int height, boolean isOpaque, int[] layerInfo) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static void nResizeLayer(int layerId, int width, int height, int[] layerInfo) {
    }

    
    @DSModeled(DSC.SAFE)
    static void nUpdateTextureLayer(int layerId, int width, int height, boolean opaque,
            SurfaceTexture surface) {
    }

    
    @DSModeled(DSC.SAFE)
    static void nSetTextureLayerTransform(int layerId, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    static void nDestroyLayer(int layerId) {
    }

    
    @DSModeled(DSC.SAFE)
    static void nDestroyLayerDeferred(int layerId) {
    }

    
    @DSModeled(DSC.SAFE)
    static boolean nCopyLayer(int layerId, int bitmap) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.916 -0400", hash_original_method = "AB6C012A4EC234C0DA96929A7EE984CD", hash_generated_method = "AC508C153357F6BF455B508D58C4CF1B")
    @Override
    public boolean isOpaque() {
        boolean varD57F412B2FBE34E5266AB85A3EC09555_160799839 = (mOpaque);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780090105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780090105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.916 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "E9BDF7E9B49382B999F7BC132DF5B7D1")
    @Override
    public int getWidth() {
        int varA3DB1626A190732E588FD0D14FC8FB31_1385267821 = (mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186442747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186442747;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.916 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "BED1021607230E7C912A1033EFBE215A")
    @Override
    public int getHeight() {
        int var483542B05A951AA16D89C7F809C20811_500943838 = (mHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959113900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959113900;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.917 -0400", hash_original_method = "10F69D1300E55A44C724BA9496871588", hash_generated_method = "680B418669E52985332B05E762B534C8")
    @Override
    public int getMaximumBitmapWidth() {
        int varF7C147EB016379DF55ED470E94ECF0DE_177085495 = (nGetMaximumTextureWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697630542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697630542;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.917 -0400", hash_original_method = "A5ADDC40BA4D92830B9288340B890F82", hash_generated_method = "35BA905F29D138FCA921F1B451BF7CC9")
    @Override
    public int getMaximumBitmapHeight() {
        int varCC613ED1478CA0A4367B4D62BAD817EF_1545678667 = (nGetMaximumTextureHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722556858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722556858;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nGetMaximumTextureWidth() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nGetMaximumTextureHeight() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.917 -0400", hash_original_method = "3FE83BE893B91EF457CAAB97151B4DC3", hash_generated_method = "CC3C39D0D5C07B70A32E1D6BF9872BD0")
    @Override
    public void setViewport(int width, int height) {
        mWidth = width;
        mHeight = height;
        nSetViewport(mRenderer, width, height);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetViewport(int renderer, int width, int height) {
    }

    
        public static boolean preserveBackBuffer() {
        return nPreserveBackBuffer();
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nPreserveBackBuffer() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isBackBufferPreserved() {
        return nIsBackBufferPreserved();
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nIsBackBufferPreserved() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        @DSModeled(DSC.SAFE)
    public static void disableVsync() {
        nDisableVsync();
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDisableVsync() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.918 -0400", hash_original_method = "9B095EEB0FC45774066EB055E8D05D05", hash_generated_method = "100AB8E0C00A37D158A2FA76AB777030")
    @Override
     void onPreDraw(Rect dirty) {
        
        addTaint(dirty.getTaint());
    if(dirty != null)        
        {
            nPrepareDirty(mRenderer, dirty.left, dirty.top, dirty.right, dirty.bottom, mOpaque);
        } 
        else
        {
            nPrepare(mRenderer, mOpaque);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nPrepare(int renderer, boolean opaque) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nPrepareDirty(int renderer, int left, int top, int right, int bottom,
            boolean opaque) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.918 -0400", hash_original_method = "7365F42EBD4B3D862109C8AFB45818F1", hash_generated_method = "D28DBD24898E379BFD423F6D4D12570A")
    @Override
     void onPostDraw() {
        
        nFinish(mRenderer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nFinish(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.918 -0400", hash_original_method = "D585DC5373E63EDA28C11B713D8E1A5B", hash_generated_method = "5A1BBF43FA068BD11FC29C388175F812")
    @Override
    public boolean callDrawGLFunction(int drawGLFunction) {
        addTaint(drawGLFunction);
        boolean var8BFFDBEAFF2EFDF3164312F2AB2AA207_1081947488 = (nCallDrawGLFunction(mRenderer, drawGLFunction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426725634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426725634;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nCallDrawGLFunction(int renderer, int drawGLFunction) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static void flushCaches(int level) {
        nFlushCaches(level);
    }

    
    @DSModeled(DSC.SAFE)
    private static void nFlushCaches(int level) {
    }

    
        public static void terminateCaches() {
        nTerminateCaches();
    }

    
    @DSModeled(DSC.SAFE)
    private static void nTerminateCaches() {
    }

    
        @DSModeled(DSC.SAFE)
    public static void initCaches() {
        nInitCaches();
    }

    
    @DSModeled(DSC.SAFE)
    private static void nInitCaches() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.919 -0400", hash_original_method = "B6A785707CFBE1E38AD4FE8A1D6625FF", hash_generated_method = "CD61D784FC52230E0055C32832FC0E93")
     int getDisplayList(int displayList) {
        addTaint(displayList);
        int varB0723F104765C12084C8EBEB7B27433A_601291597 = (nGetDisplayList(mRenderer, displayList));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714780617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714780617;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nGetDisplayList(int renderer, int displayList) {
        return DSUtils.UNKNOWN_INT;
    }

    
        @DSModeled(DSC.SAFE)
    static void destroyDisplayList(int displayList) {
        nDestroyDisplayList(displayList);
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDestroyDisplayList(int displayList) {
    }

    
        @DSModeled(DSC.SAFE)
    static int getDisplayListSize(int displayList) {
        return nGetDisplayListSize(displayList);
    }

    
    @DSModeled(DSC.SAFE)
    private static int nGetDisplayListSize(int displayList) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.919 -0400", hash_original_method = "444FDEED71E94CFCE2A65CC1E400505B", hash_generated_method = "431EF806A9F313A3AE3F6F712ECBBCFA")
    @Override
    public boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty) {
        addTaint(dirty.getTaint());
        addTaint(height);
        addTaint(width);
        addTaint(displayList.getTaint());
        boolean var0F7B0A94047C775A9CCA1688036BC62B_694528270 = (nDrawDisplayList(mRenderer,
                ((GLES20DisplayList) displayList).getNativeDisplayList(), width, height, dirty));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600416679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_600416679;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nDrawDisplayList(int renderer, int displayList,
            int width, int height, Rect dirty) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.919 -0400", hash_original_method = "5B863FAF56BDA796D9647970A297D545", hash_generated_method = "9C6B91518F1334CB3C0EE8419B7A8557")
    @Override
     void outputDisplayList(DisplayList displayList) {
        addTaint(displayList.getTaint());
        nOutputDisplayList(mRenderer, ((GLES20DisplayList) displayList).getNativeDisplayList());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nOutputDisplayList(int renderer, int displayList) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "34690C8D247D9A973C4DB94AE9D7C53D", hash_generated_method = "997C1B2E0341F9D6C632E364FEF49B4A")
     void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(layer.getTaint());
        final GLES20Layer glLayer = (GLES20Layer) layer;
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawLayer(mRenderer, glLayer.getLayer(), x, y, nativePaint);
    if(modifier != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifier);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawLayer(int renderer, int layer, float x, float y, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "2CAEF0DDE58BE10FAAA9AA0E667CCD64", hash_generated_method = "BA861453510B5BC8D04AD58E7A1553A0")
     void interrupt() {
        nInterrupt(mRenderer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "C365B4BBFEB4F0EDD5006A765220696B", hash_generated_method = "1C80A41B36E63E43CCFBDD0716C47088")
     void resume() {
        nResume(mRenderer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nInterrupt(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nResume(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "CD9590925AA701F1E39AE88CF6AE97E7", hash_generated_method = "6BD801DCA2F9BEE81F3125D6CC83A696")
    @Override
    public boolean clipPath(Path path) {
        addTaint(path.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_156938152 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_156938152.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_156938152;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "A0322959331EF06FDECE706338820D13", hash_generated_method = "4825D00B1BD1F28498A552B6049E7E00")
    @Override
    public boolean clipPath(Path path, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(path.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1918576549 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1918576549.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1918576549;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.920 -0400", hash_original_method = "3AC948804DA1E718A76D8B221FEACE24", hash_generated_method = "4B05F0891684B1830D6D49ECDFF6C306")
    @Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var89B23FF280FFA824B378FE20F78CB7A5_1955463936 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248080549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248080549;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nClipRect(int renderer, float left, float top,
            float right, float bottom, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "CF0F08AE677C71FBDBDD5FF973518EEC", hash_generated_method = "924907C64CC5C0163F11807DC976CA6E")
    @Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varE92DCB0A2C1A37C14D92C05CF2FCC325_1519545007 = (nClipRect(mRenderer, left, top, right, bottom, op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120342044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120342044;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "3911A8B4E2CBFCB889327A4F77A9CAF7", hash_generated_method = "5132E2E8A54941055650A44DA3E95FB9")
    @Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var89B23FF280FFA824B378FE20F78CB7A5_2131284955 = (nClipRect(mRenderer, left, top, right, bottom, Region.Op.INTERSECT.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_690875928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_690875928;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nClipRect(int renderer, int left, int top, int right, int bottom,
            int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "C5507A7F3855C8C6C63565CD78400CEB", hash_generated_method = "F34E2D3D74BF986B1940EA43A5F0FEA1")
    @Override
    public boolean clipRect(Rect rect) {
        addTaint(rect.getTaint());
        boolean var9E9D54F02CB180C00C7EDBC15A4FA604_1508078369 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114301232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114301232;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "CE1C58CF7145731A4EAE6ABB1C090975", hash_generated_method = "47DDAD4E7A9763CE4F98A355196B72CA")
    @Override
    public boolean clipRect(Rect rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var883EAF71FB92F9F1F1A2153E07A28588_475278494 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519054144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519054144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "82CE8198F83847EB9950BBA97A14CB45", hash_generated_method = "5EE05B36D09A5BC9C68FCAEBDAAAA0F4")
    @Override
    public boolean clipRect(RectF rect) {
        addTaint(rect.getTaint());
        boolean var9E9D54F02CB180C00C7EDBC15A4FA604_249537471 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                Region.Op.INTERSECT.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689742373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689742373;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.921 -0400", hash_original_method = "84F2B877854C623DFB4ED57554605946", hash_generated_method = "C683738CBBC9AA81DE8CF1C9E23C3065")
    @Override
    public boolean clipRect(RectF rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var883EAF71FB92F9F1F1A2153E07A28588_801739401 = (nClipRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421365551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421365551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "668D615301DC55EDCE9C8FA044FF5F71", hash_generated_method = "195B5EE8204606047FEE2B234B63BB0B")
    @Override
    public boolean clipRegion(Region region) {
        addTaint(region.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1072203130 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1072203130.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1072203130;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "9554359F0ECC8D3364C9D02F1B6C0A6E", hash_generated_method = "6573BFE731C43EBBF7CAEC87E9F28D13")
    @Override
    public boolean clipRegion(Region region, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1644350683 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1644350683.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1644350683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "5A157FCBBF6BAEFB3D0D6DDEEF98EB76", hash_generated_method = "442DAF1851A949824EC2C9A86674A50A")
    @Override
    public boolean getClipBounds(Rect bounds) {
        addTaint(bounds.getTaint());
        boolean var39DFF8903C8DDE2FAE867DBC4A09CEF7_565398290 = (nGetClipBounds(mRenderer, bounds));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352653282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352653282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nGetClipBounds(int renderer, Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "0662E9735A64886F23067D669F3F560C", hash_generated_method = "253A86A21029D2B9AE88BEEC5EC096C0")
    @Override
    public boolean quickReject(float left, float top, float right, float bottom, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varD2C36748788BD5AD12C5DEAB4866E474_1555032827 = (nQuickReject(mRenderer, left, top, right, bottom, type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67362731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67362731;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nQuickReject(int renderer, float left, float top,
            float right, float bottom, int edge) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "866F13730ACFD67020DA883631339738", hash_generated_method = "BDA202C36F75871FCA0F05B2D06C1B16")
    @Override
    public boolean quickReject(Path path, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(path.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2048402963 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2048402963.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2048402963;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "0E7313D794F0C2C284156675C98816BB", hash_generated_method = "136C8B0E69AC0959175D50E95D4443FD")
    @Override
    public boolean quickReject(RectF rect, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(rect.getTaint());
        boolean varBEEBA0E86EA880C0912462C1F2B0EDE7_1685734465 = (quickReject(rect.left, rect.top, rect.right, rect.bottom, type));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439174653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439174653;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.922 -0400", hash_original_method = "D702D49D0CBA8DAFFC483E145A7D155B", hash_generated_method = "9F1C4B541DA6BCF82C75E3E3336AD9EB")
    @Override
    public void translate(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
    if(dx != 0.0f || dy != 0.0f)        
        nTranslate(mRenderer, dx, dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nTranslate(int renderer, float dx, float dy) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "B4BEAF66CD344F6FBAA1A7BCA9EAC51C", hash_generated_method = "0212FAEA49320B139B41D8B1A3049035")
    @Override
    public void skew(float sx, float sy) {
        addTaint(sy);
        addTaint(sx);
        nSkew(mRenderer, sx, sy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSkew(int renderer, float sx, float sy) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "088A2140F7946F7E1F87C60185C75E3A", hash_generated_method = "06F47DA2C4BC0BFD54CD0F55B50E8AA7")
    @Override
    public void rotate(float degrees) {
        addTaint(degrees);
        nRotate(mRenderer, degrees);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nRotate(int renderer, float degrees) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "407ACB57F0B4398889DAE0D23801B26B", hash_generated_method = "9C32413688507E5B3B4B5C43AA370798")
    @Override
    public void scale(float sx, float sy) {
        addTaint(sy);
        addTaint(sx);
        nScale(mRenderer, sx, sy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nScale(int renderer, float sx, float sy) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "F6D59AD1FAE97EC22EF86A1DF6443B3F", hash_generated_method = "D26407292801951992231AE3DB5D5B76")
    @Override
    public void setMatrix(Matrix matrix) {
        addTaint(matrix.getTaint());
        nSetMatrix(mRenderer, matrix.native_instance);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetMatrix(int renderer, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "5C2AB9AC8E62FE145634A1140AF6AF7A", hash_generated_method = "39F006588A5C3BDA9624B952E563867A")
    @Override
    public void getMatrix(Matrix matrix) {
        addTaint(matrix.getTaint());
        nGetMatrix(mRenderer, matrix.native_instance);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nGetMatrix(int renderer, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.923 -0400", hash_original_method = "D981C9A8CE9E8AB948A57E105C909748", hash_generated_method = "DD56A9DE49EC546344D9FB1A6FA7C388")
    @Override
    public void concat(Matrix matrix) {
        addTaint(matrix.getTaint());
        nConcatMatrix(mRenderer, matrix.native_instance);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nConcatMatrix(int renderer, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.924 -0400", hash_original_method = "7EFF2592C3C6BD5E4F13755A0D5399A0", hash_generated_method = "52159B83B72AB8A806ADCF35B702429A")
    @Override
    public int save() {
        int varBB74372FF18FEE33CB51B124B07FCD59_1796952435 = (nSave(mRenderer, Canvas.CLIP_SAVE_FLAG | Canvas.MATRIX_SAVE_FLAG));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363919574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363919574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.924 -0400", hash_original_method = "F50C3BBFE7BD2C9D29BCAB4C8FE567F6", hash_generated_method = "1BBD8861C9AFCF9AD1CAD1001ACAFC0A")
    @Override
    public int save(int saveFlags) {
        addTaint(saveFlags);
        int var83B098C10803F9C5FC6B081963F88E64_1848810078 = (nSave(mRenderer, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938695031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938695031;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nSave(int renderer, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.924 -0400", hash_original_method = "9DF5A937336C76576E5F634C144FC48D", hash_generated_method = "320E28E4AC3EAE2ADE06102A8DE86814")
    @Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bounds.getTaint());
    if(bounds != null)        
        {
            int var6C14327D501CB2DF47256E66D8117CF0_379808560 = (saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, paint, saveFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552479000 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552479000;
        } 
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        int count = nSaveLayer(mRenderer, nativePaint, saveFlags);
    if(modifier != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifier);
        int varE2942A04780E223B215EB8B663CF5353_831342705 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117143488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117143488;
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nSaveLayer(int renderer, int paint, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.924 -0400", hash_original_method = "E794596E5060868E9256D6234D184C09", hash_generated_method = "3CB8B3569BF5D8E5F898F322BACC3C05")
    @Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint,
            int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
    if(left < right && top < bottom)        
        {
            int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
            final int nativePaint = paint == null ? 0 : paint.mNativePaint;
            int count = nSaveLayer(mRenderer, left, top, right, bottom, nativePaint, saveFlags);
    if(modifier != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifier);
            int varE2942A04780E223B215EB8B663CF5353_494609862 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062659081 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062659081;
        } 
        int var93E11C19FAFCCBCB4B81A37D476FB864_1053292311 = (save(saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707563732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707563732;
        
        
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nSaveLayer(int renderer, float left, float top,
            float right, float bottom, int paint, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.925 -0400", hash_original_method = "E4AB6B80C5EF0D5B797D753415FED0BE", hash_generated_method = "4780780FF82EDD7CA8A6D4E946D837B0")
    @Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bounds.getTaint());
    if(bounds != null)        
        {
            int var680C56DCD82C6DE036ED8C78E543A1E1_1902389951 = (saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom,
                    alpha, saveFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820403542 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820403542;
        } 
        int var5CA833EA5C757196FCF1809B451D6ED4_56015170 = (nSaveLayerAlpha(mRenderer, alpha, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449102088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449102088;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nSaveLayerAlpha(int renderer, int alpha, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.925 -0400", hash_original_method = "B4AB4565F10B041D742F1796C47ECB95", hash_generated_method = "5812193168EC70CC619890056543BA94")
    @Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha,
            int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
    if(left < right && top < bottom)        
        {
            int var86A0D67CF338C0CF143EF13E4B3BEE1C_280012572 = (nSaveLayerAlpha(mRenderer, left, top, right, bottom, alpha, saveFlags));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257730106 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257730106;
        } 
        int var93E11C19FAFCCBCB4B81A37D476FB864_1887020802 = (save(saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776111035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776111035;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nSaveLayerAlpha(int renderer, float left, float top, float right,
            float bottom, int alpha, int saveFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.925 -0400", hash_original_method = "C18753FB8460844761E485A3B07AB085", hash_generated_method = "70D1825D14CEDE923274F8D7C79BA367")
    @Override
    public void restore() {
        nRestore(mRenderer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nRestore(int renderer) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.925 -0400", hash_original_method = "03029795119CF4F7F4374FF9CDD913F1", hash_generated_method = "9866F503B48E3048E862E853D8DE1004")
    @Override
    public void restoreToCount(int saveCount) {
        addTaint(saveCount);
        nRestoreToCount(mRenderer, saveCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nRestoreToCount(int renderer, int saveCount) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.926 -0400", hash_original_method = "5171A9EFFCF2464453072A29F0BC817F", hash_generated_method = "1FAF32FF0CF371A994880C62DD900841")
    @Override
    public int getSaveCount() {
        int var07BC16A087EC2F97F6B7AAC46DF1D0FB_1731814357 = (nGetSaveCount(mRenderer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849055070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849055070;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int nGetSaveCount(int renderer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.926 -0400", hash_original_method = "846B7706B193B695840103C92096214E", hash_generated_method = "2A2151BC53135B33E05ECD91C4DDE028")
    @Override
    public void setDrawFilter(DrawFilter filter) {
        mFilter = filter;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.926 -0400", hash_original_method = "00C808EC6F25CC6E1FA57C10F69CA13D", hash_generated_method = "9C0B66B7731553B2286FACCF43E38662")
    @Override
    public DrawFilter getDrawFilter() {
DrawFilter var6104E4BD549FCD2640641D136DD683A6_716747252 =         mFilter;
        var6104E4BD549FCD2640641D136DD683A6_716747252.addTaint(taint);
        return var6104E4BD549FCD2640641D136DD683A6_716747252;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.926 -0400", hash_original_method = "1B5F3778D027ED2D7C875DF279109721", hash_generated_method = "32F41CE9D8CF07BE82A7027D5C730880")
    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter,
            Paint paint) {
        addTaint(paint.getTaint());
        addTaint(useCenter);
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
        int modifiers = setupModifiers(paint);
        nDrawArc(mRenderer, oval.left, oval.top, oval.right, oval.bottom, startAngle, sweepAngle,
                useCenter, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawArc(int renderer, float left, float top,
            float right, float bottom, float startAngle, float sweepAngle,
            boolean useCenter, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.926 -0400", hash_original_method = "AAC237D01F9254CC358C9D52B0A20AD9", hash_generated_method = "056F36CA49CC96D882A23D6253B9EA23")
    @Override
    public void drawARGB(int a, int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        addTaint(a);
        drawColor((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.928 -0400", hash_original_method = "3E288E14B7CE68A819334B0A90162954", hash_generated_method = "7AC6D5A04025FF0F15BCC4B7A9825784")
    @Override
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(chunks[0]);
        addTaint(bitmap.getTaint());
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawPatch(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, chunks,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
    if(modifier != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifier);
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawPatch(int renderer, int bitmap, byte[] buffer, byte[] chunks,
            float left, float top, float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.928 -0400", hash_original_method = "BF78CEE5A5D5A0B7000D42B8D7CD12A6", hash_generated_method = "63652DBC220F442FA35F1DF187A840BA")
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(top);
        addTaint(left);
        addTaint(bitmap.getTaint());
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, nativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawBitmap(
            int renderer, int bitmap, byte[] buffer, float left, float top, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.928 -0400", hash_original_method = "7A23E114FF3FC414FFADAB9162210E17", hash_generated_method = "77800C56F7A3BF21B32AC59C4E20982A")
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(matrix.getTaint());
        addTaint(bitmap.getTaint());
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer,
                matrix.native_instance, nativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buff,
            int matrix, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.930 -0400", hash_original_method = "025B89D3F15CD9670FC3D74B91AB5D58", hash_generated_method = "5EF40C1FA30701B82DDAC90FA0F06068")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        int left;
        int top;
        int right;
        int bottom;
    if(src == null)        
        {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } 
        else
        {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        } 
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
        
            
            
            
        
            
            
            
            
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.933 -0400", hash_original_method = "18A7A5D5D5C8B881DFD85E47F7DA3439", hash_generated_method = "DF85C1A6DC7E947ACE5692AB3884D7DD")
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        float left;
        float top;
        float right;
        float bottom;
    if(src == null)        
        {
            left = top = 0;
            right = bitmap.getWidth();
            bottom = bitmap.getHeight();
        } 
        else
        {
            left = src.left;
            right = src.right;
            top = src.top;
            bottom = src.bottom;
        } 
        nDrawBitmap(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, left, top, right, bottom,
                dst.left, dst.top, dst.right, dst.bottom, nativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
        
            
            
            
        
            
            
            
            
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawBitmap(int renderer, int bitmap, byte[] buffer,
            float srcLeft, float srcTop, float srcRight, float srcBottom,
            float left, float top, float right, float bottom, int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.933 -0400", hash_original_method = "9B6F84B3164E22399F0F518F30D6F56B", hash_generated_method = "5446C43054469AD262F4DED8FBBDF7E2")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y,
            int width, int height, boolean hasAlpha, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        int modifier = paint != null ? setupColorFilter(paint) : MODIFIER_NONE;
        final Bitmap.Config config = hasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        final Bitmap b = Bitmap.createBitmap(colors, offset, stride, width, height, config);
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmap(mRenderer, b.mNativeBitmap, b.mBuffer, x, y, nativePaint);
        b.recycle();
    if(modifier != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifier);
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.933 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "1B6822115F8797CEFF093DB7882E6C34")
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
            int width, int height, boolean hasAlpha, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        drawBitmap(colors, offset, stride, (float) x, (float) y, width, height, hasAlpha, paint);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.935 -0400", hash_original_method = "B49032D10E62987D37B2D43027E8B7B3", hash_generated_method = "8B0200765003E312C53292084B058D2E")
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
    if(meshWidth < 0 || meshHeight < 0 || vertOffset < 0 || colorOffset < 0)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1185720996 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1185720996.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1185720996;
        } 
    if(meshWidth == 0 || meshHeight == 0)        
        {
            return;
        } 
        final int count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);
        colors = null;
        colorOffset = 0;
        int modifiers = paint != null ? setupModifiers(bitmap, paint) : MODIFIER_NONE;
        final int nativePaint = paint == null ? 0 : paint.mNativePaint;
        nDrawBitmapMesh(mRenderer, bitmap.mNativeBitmap, bitmap.mBuffer, meshWidth, meshHeight,
                verts, vertOffset, colors, colorOffset, nativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
            
        
        
            
        
        
        
        
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawBitmapMesh(int renderer, int bitmap, byte[] buffer,
            int meshWidth, int meshHeight, float[] verts, int vertOffset,
            int[] colors, int colorOffset, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.935 -0400", hash_original_method = "3CC575BC6DB3F469750010B2B8CAC81C", hash_generated_method = "CFCE24718E3E7CF1D5E9A2A4D98BACB8")
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(radius);
        addTaint(cy);
        addTaint(cx);
        int modifiers = setupModifiers(paint);
        nDrawCircle(mRenderer, cx, cy, radius, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawCircle(int renderer, float cx, float cy,
            float radius, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.935 -0400", hash_original_method = "4F7ABDA5E981B914379787693CC10165", hash_generated_method = "C3C2A08E4F406434E020AFF0EA8C3C4A")
    @Override
    public void drawColor(int color) {
        addTaint(color);
        drawColor(color, PorterDuff.Mode.SRC_OVER);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.937 -0400", hash_original_method = "CF35C7302232BF0C4B60CFA92B96D407", hash_generated_method = "7AA2693CA714743AC774AEC1B0C16439")
    @Override
    public void drawColor(int color, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(color);
        nDrawColor(mRenderer, color, mode.nativeInt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawColor(int renderer, int color, int mode) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.937 -0400", hash_original_method = "5EABC5A9A71D080A656B11841F718311", hash_generated_method = "6330210DF13C15F2273C445DAFF62A14")
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        addTaint(paint.getTaint());
        mLine[0] = startX;
        mLine[1] = startY;
        mLine[2] = stopX;
        mLine[3] = stopY;
        drawLines(mLine, 0, 4, paint);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.938 -0400", hash_original_method = "CC8F0B4448632DE8A259253A60E2B3F7", hash_generated_method = "3A4874EC033FA4030D1264E9D2592C81")
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(count);
        addTaint(offset);
        addTaint(pts[0]);
    if((offset | count) < 0 || offset + count > pts.length)        
        {
            IllegalArgumentException var549D16F3405BF0B3A7D18DF89C5725E5_1499412081 = new IllegalArgumentException("The lines array must contain 4 elements per line.");
            var549D16F3405BF0B3A7D18DF89C5725E5_1499412081.addTaint(taint);
            throw var549D16F3405BF0B3A7D18DF89C5725E5_1499412081;
        } 
        int modifiers = setupModifiers(paint);
        nDrawLines(mRenderer, pts, offset, count, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawLines(int renderer, float[] points,
            int offset, int count, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.939 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "DD7D0820367BD7CCFC6E6C3BFF1DD24E")
    @Override
    public void drawLines(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawLines(pts, 0, pts.length, paint);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.939 -0400", hash_original_method = "3C8333232F307DB00830ADFD9367082C", hash_generated_method = "BE7290F5D782DE45BBDFEB33AA60151D")
    @Override
    public void drawOval(RectF oval, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(oval.getTaint());
        int modifiers = setupModifiers(paint);
        nDrawOval(mRenderer, oval.left, oval.top, oval.right, oval.bottom, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawOval(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.939 -0400", hash_original_method = "F3CEC7F1ABD68352F2A5895BCD8335A7", hash_generated_method = "A57933C0DD66BB033573162B66104A07")
    @Override
    public void drawPaint(Paint paint) {
        addTaint(paint.getTaint());
        final Rect r = mClipBounds;
        nGetClipBounds(mRenderer, r);
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.939 -0400", hash_original_method = "E734C6F1749AB430929BC8490D600517", hash_generated_method = "7FDA9F40B87F90E80BDF6F3BB434DEA4")
    @Override
    public void drawPath(Path path, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(path.getTaint());
        int modifiers = setupModifiers(paint);
    if(path.isSimplePath)        
        {
    if(path.rects != null)            
            {
                nDrawRects(mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
            } 
        } 
        else
        {
            nDrawPath(mRenderer, path.mNativePath, paint.mNativePaint);
        } 
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawPath(int renderer, int path, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawRects(int renderer, int region, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.942 -0400", hash_original_method = "2AA9BBA2F44244E312AB57A12DAF658B", hash_generated_method = "0B3999624C32B26B5FCD7A5CAF6F0022")
    @Override
    public void drawPicture(Picture picture) {
        addTaint(picture.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1511369206 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1511369206.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1511369206;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.942 -0400", hash_original_method = "1202DF046E7699A744E442D410CE2128", hash_generated_method = "02BC5DB703E17BE89BBC72ED9A3E3672")
    @Override
    public void drawPicture(Picture picture, Rect dst) {
        addTaint(dst.getTaint());
        addTaint(picture.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_59529537 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_59529537.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_59529537;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.942 -0400", hash_original_method = "CE526B9F8925E416169A22B853086EA4", hash_generated_method = "D75D6D0741365858023C53D992C8B8B9")
    @Override
    public void drawPicture(Picture picture, RectF dst) {
        addTaint(dst.getTaint());
        addTaint(picture.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1282151521 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1282151521.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1282151521;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.942 -0400", hash_original_method = "711B0E1C295D7644DD171BC7547CDDDA", hash_generated_method = "104842C33FA4333CD182A9724A0EA65D")
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        mPoint[0] = x;
        mPoint[1] = y;
        drawPoints(mPoint, 0, 2, paint);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.942 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "D8720D3F5332A17627233DE6797392EE")
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawPoints(pts, 0, pts.length, paint);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.944 -0400", hash_original_method = "A6EA0B46F26697457B201A425B5A3171", hash_generated_method = "49A13EAB6B8AA2817AAA24DBC57B4125")
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(count);
        addTaint(offset);
        addTaint(pts[0]);
        int modifiers = setupModifiers(paint);
        nDrawPoints(mRenderer, pts, offset, count, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawPoints(int renderer, float[] points,
            int offset, int count, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.945 -0400", hash_original_method = "A1D0375AE9DFF68E398CA7F0C8CFDC48", hash_generated_method = "74F0D723D9BB3291B080D9D7733878F0")
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.945 -0400", hash_original_method = "2727BD7310EB8AF1CE9C5E69FE8F5F77", hash_generated_method = "3B5DADF6F0A55064CE40FA5ED654E984")
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(text.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.945 -0400", hash_original_method = "1D1C68AD886616B8DD56E02894BED97B", hash_generated_method = "EBFA760F7E574D3C1D1EA5D3EA936C92")
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        int modifiers = setupModifiers(paint);
        nDrawRect(mRenderer, left, top, right, bottom, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawRect(int renderer, float left, float top,
            float right, float bottom, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.954 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "BBB6D5F4F6A6E2187C3A22EA5AD2D898")
    @Override
    public void drawRect(Rect r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.954 -0400", hash_original_method = "73D11F584AEBB7C191086A2FFF4052A9", hash_generated_method = "2D56321029DEE0E9DA970C32DEDE0DB8")
    @Override
    public void drawRect(RectF r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.954 -0400", hash_original_method = "EB9FA3A1182306D8C56FD7B1B2A405F0", hash_generated_method = "E6088EADF0D68049F3FB32C7CFAAB75D")
    @Override
    public void drawRGB(int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        drawColor(0xFF000000 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.955 -0400", hash_original_method = "F66719DAB9BD4C7CE0890FFA1C26F9F2", hash_generated_method = "EBE2A06C5985DEEBDF554AF33DBE0BD1")
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(ry);
        addTaint(rx);
        addTaint(rect.getTaint());
        int modifiers = setupModifiers(paint);
        nDrawRoundRect(mRenderer, rect.left, rect.top, rect.right, rect.bottom,
                rx, ry, paint.mNativePaint);
    if(modifiers != MODIFIER_NONE)        
        nResetModifiers(mRenderer, modifiers);
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawRoundRect(int renderer, float left, float top,
            float right, float bottom, float rx, float y, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.955 -0400", hash_original_method = "5B66E40A85BEEB6F8228E5994A513667", hash_generated_method = "23136926576D34ED9AFC7D3B6D3C3EB7")
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
    if((index | count | (index + count) | (text.length - index - count)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_885747272 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_885747272.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_885747272;
        } 
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, index, count, x, y, paint.mBidiFlags, paint.mNativePaint);
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawText(int renderer, char[] text, int index, int count,
            float x, float y, int bidiFlags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.956 -0400", hash_original_method = "BF4D02798081BBBF8269CD636760F070", hash_generated_method = "4190B9A7FFD780925A16CCBC8620D778")
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        int modifiers = setupModifiers(paint);
        try 
        {
    if(text instanceof String || text instanceof SpannedString ||
                    text instanceof SpannableString)            
            {
                nDrawText(mRenderer, text.toString(), start, end, x, y, paint.mBidiFlags,
                        paint.mNativePaint);
            } 
            else
    if(text instanceof GraphicsOperations)            
            {
                ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                         paint);
            } 
            else
            {
                char[] buf = TemporaryBuffer.obtain(end - start);
                TextUtils.getChars(text, start, end, buf, 0);
                nDrawText(mRenderer, buf, 0, end - start, x, y,
                        paint.mBidiFlags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            } 
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.957 -0400", hash_original_method = "53AB28ACA34BAB18CDB1722B92273EEB", hash_generated_method = "1D6FB07916367136B84513C72E8DEA65")
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_883151814 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_883151814.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_883151814;
        } 
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, start, end, x, y, paint.mBidiFlags, paint.mNativePaint);
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawText(int renderer, String text, int start, int end,
            float x, float y, int bidiFlags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.957 -0400", hash_original_method = "F496E99287218708FCCC7DBE6218BF00", hash_generated_method = "6560B7EB5B7762580F8F9561797E38B3")
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(text.getTaint());
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawText(mRenderer, text, 0, text.length(), x, y, paint.mBidiFlags,
                    paint.mNativePaint);
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.957 -0400", hash_original_method = "C2D0F05CD306BD6EB45BAEA1052EFD68", hash_generated_method = "7D8A930ECBDC214A71CEB1EEC14B63CC")
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
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.957 -0400", hash_original_method = "E399416700F7228806FC79CB70E6A478", hash_generated_method = "E3492886BB57304B70F3B7BCD2D166B4")
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(vOffset);
        addTaint(hOffset);
        addTaint(path.getTaint());
        addTaint(text.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.958 -0400", hash_original_method = "8FBF947B147B7DB5ED34E606F7095E1C", hash_generated_method = "09144BCD9686D372C09BD26582079B16")
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
    if((index | count | text.length - index - count) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1529980132 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1529980132.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1529980132;
        } 
    if(dir != DIRECTION_LTR && dir != DIRECTION_RTL)        
        {
            IllegalArgumentException varA7697A0B8843DFFB67E3CBA4DDE8EAF9_1767349649 = new IllegalArgumentException("Unknown direction: " + dir);
            varA7697A0B8843DFFB67E3CBA4DDE8EAF9_1767349649.addTaint(taint);
            throw varA7697A0B8843DFFB67E3CBA4DDE8EAF9_1767349649;
        } 
        int modifiers = setupModifiers(paint);
        try 
        {
            nDrawTextRun(mRenderer, text, index, count, contextIndex, contextCount, x, y, dir,
                    paint.mNativePaint);
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
            
        
        
            
        
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawTextRun(int renderer, char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir, int nativePaint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.958 -0400", hash_original_method = "7904538C4B6BCEBBAA348BC3E2FD272F", hash_generated_method = "88A80190B9815EAE3B62EAA1905E3C61")
    @Override
    public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd,
            float x, float y, int dir, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dir);
        addTaint(y);
        addTaint(x);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
    if((start | end | end - start | text.length() - end) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1839413604 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1839413604.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1839413604;
        } 
        int modifiers = setupModifiers(paint);
        try 
        {
            int flags = dir == 0 ? 0 : 1;
    if(text instanceof String || text instanceof SpannedString ||
                    text instanceof SpannableString)            
            {
                nDrawTextRun(mRenderer, text.toString(), start, end, contextStart,
                        contextEnd, x, y, flags, paint.mNativePaint);
            } 
            else
    if(text instanceof GraphicsOperations)            
            {
                ((GraphicsOperations) text).drawTextRun(this, start, end,
                        contextStart, contextEnd, x, y, flags, paint);
            } 
            else
            {
                int contextLen = contextEnd - contextStart;
                int len = end - start;
                char[] buf = TemporaryBuffer.obtain(contextLen);
                TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
                nDrawTextRun(mRenderer, buf, start - contextStart, len, 0, contextLen,
                        x, y, flags, paint.mNativePaint);
                TemporaryBuffer.recycle(buf);
            } 
        } 
        finally 
        {
    if(modifiers != MODIFIER_NONE)            
            nResetModifiers(mRenderer, modifiers);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nDrawTextRun(int renderer, String text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int flags, int nativePaint) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.959 -0400", hash_original_method = "7C5BB6E42A47B8FFC1224CB48EC5DC66", hash_generated_method = "40DFC169A693775C01A0188AE9FF9AE3")
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
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.959 -0400", hash_original_method = "5D6688C2A74D4FFF4670B4EAAE2F407B", hash_generated_method = "81E7DCC60085EF9C79B39E74F75B1DBA")
    private int setupModifiers(Bitmap b, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(b.getTaint());
    if(b.getConfig() == Bitmap.Config.ALPHA_8)        
        {
            int var413027AD41BF7545DCB2F18DFA7EE08B_683056064 = (setupModifiers(paint));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894396309 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894396309;
        } 
        final ColorFilter filter = paint.getColorFilter();
    if(filter != null)        
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            int varD644E26BA3F8E16EA7B54364F3EC7563_622728456 = (MODIFIER_COLOR_FILTER);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209210017 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209210017;
        } 
        int var14EC4C6E987AFE92EEB1024593A6AD22_1532982282 = (MODIFIER_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859357381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859357381;
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.959 -0400", hash_original_method = "7663D59B2E312EB2A24D959BD08A0BC2", hash_generated_method = "6B1CBD134459F0B2501726DCE6F5B17F")
    private int setupModifiers(Paint paint) {
        addTaint(paint.getTaint());
        int modifiers = MODIFIER_NONE;
    if(paint.hasShadow)        
        {
            nSetupShadow(mRenderer, paint.shadowRadius, paint.shadowDx, paint.shadowDy,
                    paint.shadowColor);
            modifiers |= MODIFIER_SHADOW;
        } 
        final Shader shader = paint.getShader();
    if(shader != null)        
        {
            nSetupShader(mRenderer, shader.native_shader);
            modifiers |= MODIFIER_SHADER;
        } 
        final ColorFilter filter = paint.getColorFilter();
    if(filter != null)        
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            modifiers |= MODIFIER_COLOR_FILTER;
        } 
        int varBF24B44A8CC99E648657B164C8ABA758_1512260963 = (modifiers);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179217242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179217242;
        
        
        
            
                    
            
        
        
        
            
            
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.960 -0400", hash_original_method = "8D8D130B420F7BDB77245347422EB674", hash_generated_method = "7D4566A917C3F3C45AFBE201BEE72CA4")
    private int setupColorFilter(Paint paint) {
        addTaint(paint.getTaint());
        final ColorFilter filter = paint.getColorFilter();
    if(filter != null)        
        {
            nSetupColorFilter(mRenderer, filter.nativeColorFilter);
            int varD644E26BA3F8E16EA7B54364F3EC7563_1079229007 = (MODIFIER_COLOR_FILTER);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868498220 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868498220;
        } 
        int var14EC4C6E987AFE92EEB1024593A6AD22_194461670 = (MODIFIER_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568853379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_568853379;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetupShader(int renderer, int shader) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetupColorFilter(int renderer, int colorFilter) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetupShadow(int renderer, float radius,
            float dx, float dy, int color) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nResetModifiers(int renderer, int modifiers) {
    }

    
    private static final class CanvasFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.960 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "29611ED2287CE69051FC2BCDB2E2FF9D")

        private int mRenderer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.960 -0400", hash_original_method = "FD0EABF3A28C8F1A6C7AE1792F2A951E", hash_generated_method = "F4CE774395766560B3604C2271BA47E5")
        public  CanvasFinalizer(int renderer) {
            mRenderer = renderer;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.960 -0400", hash_original_method = "98F8E6E4208DCA7352053ED1AE5E9232", hash_generated_method = "172B7210461BDF8CBEDEDD56AE7B7486")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                nDestroyRenderer(mRenderer);
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "724AEEA405FC9CF2CE47243A92797113", hash_generated_field = "E2BA09F8DF55E2B4054F568E93987B59")

    private static final int MODIFIER_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "94B729010A95D20E8C197B93E2E6F8D5", hash_generated_field = "F3A096D0EBF980761DC223D5B61BA142")

    private static final int MODIFIER_SHADOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "0CA6B43DD1E03498AF4D707A3E3A166E", hash_generated_field = "A17A6835293DC1FAD5B4BD9C6992B819")

    private static final int MODIFIER_SHADER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "8F247A4C1EFB8B21D56F5A549AF04510", hash_generated_field = "2EFB036221198641F88AC422E6AE703C")

    private static final int MODIFIER_COLOR_FILTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "311BEA3B2ABE4D5421B92A22977E6ED9", hash_generated_field = "00CB76E41029EE5E99449BE03B14A2C4")

    private static boolean sIsAvailable = nIsAvailable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "2D3E4E15F2A351552D65553739390E48", hash_generated_field = "ABDEA563561F2E851E5FA87E2946EA62")

    public static final int FLUSH_CACHES_LAYERS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "CC12B1F5538FD6E6A924A110A43464C3", hash_generated_field = "862324F027832C57FCA1F817DF8CFB81")

    public static final int FLUSH_CACHES_MODERATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.961 -0400", hash_original_field = "3137DA4124C142EF7060FF3E7E058DC0", hash_generated_field = "868D2688FA6966D15281F70A2C218ADD")

    public static final int FLUSH_CACHES_FULL = 2;
}

