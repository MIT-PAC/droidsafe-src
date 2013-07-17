package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import javax.microedition.khronos.opengles.GL;

public class Canvas {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "9AEAAB458F04AA015A1FEC7988D58EFD")

    int mNativeCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "33EC7BAD3C77F28DF4CAC7D27FF9F413", hash_generated_field = "31D717B55AEC45D08AFE5E2055099FE3")

    private DrawFilter mDrawFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "374AD1D5FABD7F0924F98F93B66480BB", hash_generated_field = "26A3C4D459B626187E0E8706060CBC58")

    protected int mDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "3C7272D39DFDF8BA7BC8BAE70278C78B", hash_generated_field = "B3B96B83CBF6A474ACFDE54DAF7E8D5B")

    protected int mScreenDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "D2E79E153A2C7AD6C353ED3C0C4AF8B9", hash_generated_field = "5A79E0455BB83A8F5930E665EB36A02A")

    @SuppressWarnings({"UnusedDeclaration"}) private int mSurfaceFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.892 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D26BA3C2A6930E011E689CD349B6702B")

    @SuppressWarnings({"UnusedDeclaration"}) private CanvasFinalizer mFinalizer;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.893 -0400", hash_original_method = "1267A44EC7BCBF8838C9761711C37259", hash_generated_method = "63552CAA2E9C15316003F51321B1A087")
    public  Canvas() {
        mNativeCanvas = initRaster(0);
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        // ---------- Original Method ----------
        //mNativeCanvas = initRaster(0);
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.894 -0400", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "3499EE203F1F2448FFF7EBFBA2FB6F67")
    public  Canvas(Bitmap bitmap) {
        if(!bitmap.isMutable())        
        {
            IllegalStateException varB9C3A3A59BC5C857E3F255B36EEF0DC8_1730677705 = new IllegalStateException(
                            "Immutable bitmap passed to Canvas constructor");
            varB9C3A3A59BC5C857E3F255B36EEF0DC8_1730677705.addTaint(taint);
            throw varB9C3A3A59BC5C857E3F255B36EEF0DC8_1730677705;
        } //End block
        throwIfRecycled(bitmap);
        mNativeCanvas = initRaster(bitmap.ni());
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        mBitmap = bitmap;
        mDensity = bitmap.mDensity;
        // ---------- Original Method ----------
        //if (!bitmap.isMutable()) {
            //throw new IllegalStateException(
                            //"Immutable bitmap passed to Canvas constructor");
        //}
        //throwIfRecycled(bitmap);
        //mNativeCanvas = initRaster(bitmap.ni());
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
        //mBitmap = bitmap;
        //mDensity = bitmap.mDensity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.894 -0400", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "C961949B3BF68E777E28D4D8436CBE46")
      Canvas(int nativeCanvas) {
        if(nativeCanvas == 0)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1619366411 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1619366411.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1619366411;
        } //End block
        mNativeCanvas = nativeCanvas;
        mFinalizer = new CanvasFinalizer(nativeCanvas);
        mDensity = Bitmap.getDefaultDensity();
        // ---------- Original Method ----------
        //if (nativeCanvas == 0) {
            //throw new IllegalStateException();
        //}
        //mNativeCanvas = nativeCanvas;
        //mFinalizer = new CanvasFinalizer(nativeCanvas);
        //mDensity = Bitmap.getDefaultDensity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.895 -0400", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "68BD5BD359DA4CBA7F88434CD92747F9")
    @Deprecated
    protected GL getGL() {
GL var540C13E9E156B687226421B24F2DF178_1550155481 =         null;
        var540C13E9E156B687226421B24F2DF178_1550155481.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1550155481;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.895 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "41B4205CED3B4F7942327C773D7C973B")
    public boolean isHardwareAccelerated() {
        boolean var68934A3E9455FA72420237EB05902327_1699065890 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102283139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102283139;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.896 -0400", hash_original_method = "F6F982BDFE8AA5C0E01EE9F2D9165328", hash_generated_method = "121396A29BCF218527771A62380DCC43")
    public void setBitmap(Bitmap bitmap) {
        if(isHardwareAccelerated())        
        {
            RuntimeException var6091F9DAED2E950E70BC7FB9C5874FB8_314051826 = new RuntimeException("Can't set a bitmap device on a GL canvas");
            var6091F9DAED2E950E70BC7FB9C5874FB8_314051826.addTaint(taint);
            throw var6091F9DAED2E950E70BC7FB9C5874FB8_314051826;
        } //End block
        int pointer = 0;
        if(bitmap != null)        
        {
            if(!bitmap.isMutable())            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1253326616 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_1253326616.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_1253326616;
            } //End block
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            pointer = bitmap.ni();
        } //End block
        native_setBitmap(mNativeCanvas, pointer);
        mBitmap = bitmap;
        // ---------- Original Method ----------
        //if (isHardwareAccelerated()) {
            //throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        //}
        //int pointer = 0;
        //if (bitmap != null) {
            //if (!bitmap.isMutable()) {
                //throw new IllegalStateException();
            //}
            //throwIfRecycled(bitmap);
            //mDensity = bitmap.mDensity;
            //pointer = bitmap.ni();
        //}
        //native_setBitmap(mNativeCanvas, pointer);
        //mBitmap = bitmap;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.896 -0400", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "5E7607C7F35EFC6197184F074C0525A9")
    public void setViewport(int width, int height) {
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.897 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "E1EB93F29F866FB1C5168A9C92ABDF65")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466892718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466892718;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.897 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "E03EA0F8881F50B68B4BE78FF6E9EC07")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493739307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1493739307;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.897 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "57CB9C44B6B26436E9A9DDFBBB597236")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892815756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892815756;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.898 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "A99578BDB52EF8C98159DD8013586326")
    public int getDensity() {
        int var174BB9FF4691CBE6254BA90AE9FA0B63_1307459706 = (mDensity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162223465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162223465;
        // ---------- Original Method ----------
        //return mDensity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.898 -0400", hash_original_method = "67C9034FA61967648F2458A8FB5F781D", hash_generated_method = "AD92D1FCA7675766DA10A783C242DAA0")
    public void setDensity(int density) {
        if(mBitmap != null)        
        {
            mBitmap.setDensity(density);
        } //End block
        mDensity = density;
        // ---------- Original Method ----------
        //if (mBitmap != null) {
            //mBitmap.setDensity(density);
        //}
        //mDensity = density;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.899 -0400", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "A6B4CCAC527ADCBCA2970ADC88659071")
    public void setScreenDensity(int density) {
        mScreenDensity = density;
        // ---------- Original Method ----------
        //mScreenDensity = density;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.899 -0400", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "7D07EE59CF587A3AF9F6017C37E7AA0F")
    public int getMaximumBitmapWidth() {
        int varEFF742E655CE706FE07F716F7242F89C_1296438284 = (MAXMIMUM_BITMAP_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173989993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173989993;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.900 -0400", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "C32093AC6493B0603E5AB4191CF020EB")
    public int getMaximumBitmapHeight() {
        int varEFF742E655CE706FE07F716F7242F89C_58487509 = (MAXMIMUM_BITMAP_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147292515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147292515;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.900 -0400", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "D0997A1AE625B6AE9873884B4BBBF84C")
    public int save() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253886032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253886032;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.900 -0400", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "772C8B537D25A4619C19F3FCC272CCB4")
    public int save(int saveFlags) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123504820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123504820;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.900 -0400", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "1CC8BBFE998870CE98A060A7AF64DC9D")
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bounds.getTaint());
        int var2F72CAB9E82AE6D65726D922CDB4ACED_702519413 = (native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409619177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409619177;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, bounds,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.901 -0400", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "B2E1BD33DF6B3F03C365DD21FAD39FE1")
    public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        int var78BE8BC6EEE8543E5FE41A72939C05E4_1109683621 = (native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839209954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839209954;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.902 -0400", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "F97BA0D0441CA0735F52BAE8692317AC")
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bounds.getTaint());
        alpha = Math.min(255, Math.max(0, alpha));
        int varDAFA73D4CF9EAA021A7201BFA4BDDE24_2001733931 = (native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642248267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642248267;
        // ---------- Original Method ----------
        //alpha = Math.min(255, Math.max(0, alpha));
        //return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.902 -0400", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "6EAE964D31323D3150B34E9427BC73C6")
    public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        int varFFB2E6758484BEC5ABC723AFF5EEBA3B_1655606848 = (native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934249335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934249335;
        // ---------- Original Method ----------
        //return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     //alpha, saveFlags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.903 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "17FCF523146E8D711A132189A0FA7A41")
    public void restore() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.903 -0400", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "BCD05CA79B917EE8B18DEB9814F49D62")
    public int getSaveCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958157032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958157032;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.903 -0400", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "974A4A0419CFC80E5DCE3A10E5A44569")
    public void restoreToCount(int saveCount) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.903 -0400", hash_original_method = "D7EAFB33E67C35A487FB9FDA7236DB5C", hash_generated_method = "D0B6F0A9E05AD23474AA3F4EC0F3A5D4")
    public void translate(float dx, float dy) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.904 -0400", hash_original_method = "914C0B0C62A552CD356908505BF7E530", hash_generated_method = "C80939F3E48B9985ED6CECC4D208910C")
    public void scale(float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.904 -0400", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "CDEABD23C9A2F7AD3AFA53FBF751A464")
    public final void scale(float sx, float sy, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(sy);
        addTaint(sx);
        translate(px, py);
        scale(sx, sy);
        translate(-px, -py);
        // ---------- Original Method ----------
        //translate(px, py);
        //scale(sx, sy);
        //translate(-px, -py);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.904 -0400", hash_original_method = "3293BC510D2403D70370080BC137D04A", hash_generated_method = "538AEF3060A20505833F455ADFC3A525")
    public void rotate(float degrees) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.905 -0400", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "8ECECC7987074C9CD61575A5DAC2B527")
    public final void rotate(float degrees, float px, float py) {
        addTaint(py);
        addTaint(px);
        addTaint(degrees);
        translate(px, py);
        rotate(degrees);
        translate(-px, -py);
        // ---------- Original Method ----------
        //translate(px, py);
        //rotate(degrees);
        //translate(-px, -py);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.905 -0400", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "8C9F38F6D7E6C080ECF146BE9233FC5D")
    public void skew(float sx, float sy) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.905 -0400", hash_original_method = "92F93C7D2AC41CA3F3A5613FB52C686A", hash_generated_method = "4A9E69C70A34ABDEE27617D810D6D837")
    public void concat(Matrix matrix) {
        addTaint(matrix.getTaint());
        native_concat(mNativeCanvas, matrix.native_instance);
        // ---------- Original Method ----------
        //native_concat(mNativeCanvas, matrix.native_instance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.906 -0400", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "96B2676400786CD1F61DCB6834818734")
    public void setMatrix(Matrix matrix) {
        addTaint(matrix.getTaint());
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
        // ---------- Original Method ----------
        //native_setMatrix(mNativeCanvas,
                         //matrix == null ? 0 : matrix.native_instance);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.906 -0400", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "3A3372FD72956C9E9D7FD09558117C60")
    public void getMatrix(Matrix ctm) {
        addTaint(ctm.getTaint());
        native_getCTM(mNativeCanvas, ctm.native_instance);
        // ---------- Original Method ----------
        //native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.906 -0400", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "6E7E74878D727C2B59346C9A216E05B9")
    public final Matrix getMatrix() {
        Matrix m = new Matrix();
        getMatrix(m);
Matrix varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1267511085 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1267511085.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1267511085;
        // ---------- Original Method ----------
        //Matrix m = new Matrix();
        //getMatrix(m);
        //return m;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.907 -0400", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "D70850AF0D43EC1C96A491EA7FF1E87F")
    public boolean clipRect(RectF rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var24674B6C369AA84B24BD6C57ABBD02EF_1566272239 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668856505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668856505;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.907 -0400", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "E2B59E75C4C7E90723778EB33BAC8786")
    public boolean clipRect(Rect rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var24674B6C369AA84B24BD6C57ABBD02EF_591525235 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113395551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113395551;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.908 -0400", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "1BE46AF482E4008B78270283EDC9C3C7")
    public boolean clipRect(RectF rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463030774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463030774;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.908 -0400", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "4E984CF0DF911F63AA8D71A8AA3AEB85")
    public boolean clipRect(Rect rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914956484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914956484;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.908 -0400", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "2511884D6999D02D5A74F23087DE8E93")
    public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        addTaint(op.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varD7AC0BD0D62861CC137EA1FAC782D37D_1002575632 = (native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348475459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348475459;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               //op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.909 -0400", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "76F9FBBEEC6345662323CE047432C627")
    public boolean clipRect(float left, float top,
                                   float right, float bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561411777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561411777;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.909 -0400", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "1DE5031D93469BF60ADEBF66DFB2C473")
    public boolean clipRect(int left, int top,
                                   int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573474818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573474818;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.910 -0400", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "8446A06AC30B0ABE22786F16D96E1625")
    public boolean clipPath(Path path, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(path.getTaint());
        boolean var368077C868F5558511AED0E4E369F219_661643593 = (native_clipPath(mNativeCanvas, path.ni(), op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621045351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621045351;
        // ---------- Original Method ----------
        //return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.910 -0400", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "EA68FE5B43FA81116E65EA72401A1764")
    public boolean clipPath(Path path) {
        addTaint(path.getTaint());
        boolean var02AC20FF4C25BECDDDCCAB8CD257C45D_1742589297 = (clipPath(path, Region.Op.INTERSECT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144916412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144916412;
        // ---------- Original Method ----------
        //return clipPath(path, Region.Op.INTERSECT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.911 -0400", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "AD91BEB1DE46B73523BB1AAF6A1CF2A2")
    public boolean clipRegion(Region region, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        boolean varF44AD2F9DE9FA406AA85FC800A9B2413_1448194134 = (native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577518174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577518174;
        // ---------- Original Method ----------
        //return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.911 -0400", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "EA015FFF3FF5C63ED94BF4DBE17DF7E3")
    public boolean clipRegion(Region region) {
        addTaint(region.getTaint());
        boolean varBCA634D2998124C6DB2C94FFEEC5D33E_947645240 = (clipRegion(region, Region.Op.INTERSECT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820738098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_820738098;
        // ---------- Original Method ----------
        //return clipRegion(region, Region.Op.INTERSECT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.911 -0400", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "6F860B6642CAB54823563461475DB56D")
    public DrawFilter getDrawFilter() {
DrawFilter var5EDA12300AEAAFC248858F9EEC89F965_74786209 =         mDrawFilter;
        var5EDA12300AEAAFC248858F9EEC89F965_74786209.addTaint(taint);
        return var5EDA12300AEAAFC248858F9EEC89F965_74786209;
        // ---------- Original Method ----------
        //return mDrawFilter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.912 -0400", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "15C5B84B5ADFCF92FA52DCD023CFDCD7")
    public void setDrawFilter(DrawFilter filter) {
        int nativeFilter = 0;
        if(filter != null)        
        {
            nativeFilter = filter.mNativeInt;
        } //End block
        mDrawFilter = filter;
        nativeSetDrawFilter(mNativeCanvas, nativeFilter);
        // ---------- Original Method ----------
        //int nativeFilter = 0;
        //if (filter != null) {
            //nativeFilter = filter.mNativeInt;
        //}
        //mDrawFilter = filter;
        //nativeSetDrawFilter(mNativeCanvas, nativeFilter);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.912 -0400", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "5263A5ED3EB7C615FCA782B2377A0A4A")
    public boolean quickReject(RectF rect, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(rect.getTaint());
        boolean varB1B99A16647CDB21F5DEC0E24EE58FD4_690283412 = (native_quickReject(mNativeCanvas, rect, type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257465483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257465483;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.913 -0400", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "9E05E3783AA42300F9A5412D55923D07")
    public boolean quickReject(Path path, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(path.getTaint());
        boolean varB5DEF5671B1C98A9B71B3911DC40BF72_1997785389 = (native_quickReject(mNativeCanvas, path.ni(), type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517133986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517133986;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.914 -0400", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "40582F3C16AE3D95A93BFBC3A4F141C0")
    public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        addTaint(type.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var8F2F42CD37C1D52BA9CCFA1F8E6AE8D8_1892190575 = (native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482678204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482678204;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  //type.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.914 -0400", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "AA3FE5CD0269B70376B28AB309A39AFE")
    public boolean getClipBounds(Rect bounds) {
        addTaint(bounds.getTaint());
        boolean varA98C3E9BB60A5C0F1E477AD90B08B580_849604111 = (native_getClipBounds(mNativeCanvas, bounds));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917549484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_917549484;
        // ---------- Original Method ----------
        //return native_getClipBounds(mNativeCanvas, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.915 -0400", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "C0963F81A301CCE096381A0A170321D4")
    public final Rect getClipBounds() {
        Rect r = new Rect();
        getClipBounds(r);
Rect var4C1F3C86A0E56B6E375080F5F710547E_1117048832 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_1117048832.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_1117048832;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //getClipBounds(r);
        //return r;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.915 -0400", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "B3F7EACD5A719DF9BE71A4BD25E978FE")
    public void drawRGB(int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        native_drawRGB(mNativeCanvas, r, g, b);
        // ---------- Original Method ----------
        //native_drawRGB(mNativeCanvas, r, g, b);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.915 -0400", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "E9E61FA3F9EE61836A7F346E1C787C8E")
    public void drawARGB(int a, int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        addTaint(a);
        native_drawARGB(mNativeCanvas, a, r, g, b);
        // ---------- Original Method ----------
        //native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.916 -0400", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "A8B513A56FF5C578DB10A6FDD49B92E0")
    public void drawColor(int color) {
        addTaint(color);
        native_drawColor(mNativeCanvas, color);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.916 -0400", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "CE02F13E6307D6ABEA745CE735B00A7C")
    public void drawColor(int color, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(color);
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.916 -0400", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "BF6573436AB274374078C50D9F5434CD")
    public void drawPaint(Paint paint) {
        addTaint(paint.getTaint());
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.917 -0400", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "6FF2BCA7A4B0B8AB911130468726B5DA")
    public void drawPoints(float[] pts, int offset, int count,
                                  Paint paint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.917 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "B69588386471F89E34165E1BF55AC31E")
    public void drawPoints(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawPoints(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.917 -0400", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "CC1E903F166689821C3A24C5F449BF0F")
    public void drawPoint(float x, float y, Paint paint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.918 -0400", hash_original_method = "B6DC8903FDEE452D685FA44296B398E4", hash_generated_method = "EC3E7FF9C266EF3EDD34B2E172301CAB")
    public void drawLine(float startX, float startY, float stopX, float stopY,
                         Paint paint) {
        addTaint(paint.getTaint());
        addTaint(stopY);
        addTaint(stopX);
        addTaint(startY);
        addTaint(startX);
        native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.918 -0400", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "BC11F5ED395D07C9E16C7DC1EBD0C9F8")
    public void drawLines(float[] pts, int offset, int count,
                                 Paint paint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.919 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "240D0D497D3344413E6F301FD6886910")
    public void drawLines(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawLines(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.919 -0400", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "5C7970080710503FEA9475DCFFE9EE2E")
    public void drawRect(RectF rect, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(rect.getTaint());
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.919 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "70EEEE2E580CA4DAB0C2EFA671CD1698")
    public void drawRect(Rect r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.920 -0400", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "70D750C631A2CACFBEC9B5AF328C9167")
    public void drawRect(float left, float top, float right, float bottom,
                         Paint paint) {
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        native_drawRect(mNativeCanvas, left, top, right, bottom,
                        paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, left, top, right, bottom,
                        //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.920 -0400", hash_original_method = "68242662823845D3936295A7CE4E7BEF", hash_generated_method = "286E591E0281499E63E2BBF1FF9C55FA")
    public void drawOval(RectF oval, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(oval.getTaint());
        if(oval == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1379454045 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1379454045.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1379454045;
        } //End block
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.921 -0400", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "60AC95F7F5E6ED28C5FD44D65BCB54B6")
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(radius);
        addTaint(cy);
        addTaint(cx);
        native_drawCircle(mNativeCanvas, cx, cy, radius,
                          paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawCircle(mNativeCanvas, cx, cy, radius,
                          //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.921 -0400", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "2F37C3CF272F64A81FC98AFF246EC382")
    public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(useCenter);
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
        if(oval == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1842900593 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1842900593.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1842900593;
        } //End block
        native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       useCenter, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       //useCenter, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.922 -0400", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "FCE51C38EFC9449B4CBB4CAE6ABDE150")
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(ry);
        addTaint(rx);
        addTaint(rect.getTaint());
        if(rect == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_709374289 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_709374289.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_709374289;
        } //End block
        native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             paint.mNativePaint);
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException();
        //}
        //native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.922 -0400", hash_original_method = "0771B06A5DB79DCDA48BD1ADBD491833", hash_generated_method = "5D7BFF714EB04071A3E6A58073A83246")
    public void drawPath(Path path, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(path.getTaint());
        native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
    }

    
    @DSModeled(DSC.SAFE)
    private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.923 -0400", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "4CEE03DE2E27870C2160F08F6922FE0E")
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(chunks[0]);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.923 -0400", hash_original_method = "31B292C5F0F5731C1C9071C226236EDA", hash_generated_method = "CD57C5FC2672A35C7D40F6EE0716B558")
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(top);
        addTaint(left);
        addTaint(bitmap.getTaint());
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                bitmap.mDensity);
        // ---------- Original Method ----------
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                //paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                //bitmap.mDensity);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.924 -0400", hash_original_method = "C948472D99C8DCD49BAB1292EF9A789B", hash_generated_method = "EA75ED6BC12A0BDC3D337C7F79100591")
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        if(dst == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_215581459 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_215581459.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_215581459;
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.924 -0400", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "BBF7C192967195EDEED91E1033C07D2A")
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        if(dst == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1777840866 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1777840866.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1777840866;
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.925 -0400", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "F14B798D75CDE97DA659384A92886E6B")
    public void drawBitmap(int[] colors, int offset, int stride, float x,
                           float y, int width, int height, boolean hasAlpha,
                           Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        if(width < 0)        
        {
            IllegalArgumentException var3466F3A966382BEF5BF802F7CB74379A_1346349426 = new IllegalArgumentException("width must be >= 0");
            var3466F3A966382BEF5BF802F7CB74379A_1346349426.addTaint(taint);
            throw var3466F3A966382BEF5BF802F7CB74379A_1346349426;
        } //End block
        if(height < 0)        
        {
            IllegalArgumentException var32D5EA37D2C9CC8D7924EB1890514E85_799054898 = new IllegalArgumentException("height must be >= 0");
            var32D5EA37D2C9CC8D7924EB1890514E85_799054898.addTaint(taint);
            throw var32D5EA37D2C9CC8D7924EB1890514E85_799054898;
        } //End block
        if(Math.abs(stride) < width)        
        {
            IllegalArgumentException varD1549FCE299AC8F2198C0DF0EF8A3981_47302792 = new IllegalArgumentException("abs(stride) must be >= width");
            varD1549FCE299AC8F2198C0DF0EF8A3981_47302792.addTaint(taint);
            throw varD1549FCE299AC8F2198C0DF0EF8A3981_47302792;
        } //End block
        int lastScanline = offset + (height - 1) * stride;
        int length = colors.length;
        if(offset < 0 || (offset + width > length) || lastScanline < 0
                || (lastScanline + width > length))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1187852216 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1187852216.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1187852216;
        } //End block
        if(width == 0 || height == 0)        
        {
            return;
        } //End block
        native_drawBitmap(mNativeCanvas, colors, offset, stride, x, y, width, height, hasAlpha,
                paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.926 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "78F74E18FD210530369BA07793BF08B0")
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
                           int width, int height, boolean hasAlpha,
                           Paint paint) {
        addTaint(paint.getTaint());
        addTaint(hasAlpha);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(colors[0]);
        drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   hasAlpha, paint);
        // ---------- Original Method ----------
        //drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   //hasAlpha, paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.927 -0400", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "1CB0ABB74C82F6E12D6E115A65203896")
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(matrix.getTaint());
        addTaint(bitmap.getTaint());
        nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        //nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                //paint != null ? paint.mNativePaint : 0);
    }

    
    @DSModeled(DSC.SAFE)
    protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.929 -0400", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "32F9E0EEF964859573B341B44CA3E60E")
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight,
                               float[] verts, int vertOffset,
                               int[] colors, int colorOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(colorOffset);
        addTaint(colors[0]);
        addTaint(vertOffset);
        addTaint(verts[0]);
        addTaint(meshHeight);
        addTaint(meshWidth);
        addTaint(bitmap.getTaint());
        if((meshWidth | meshHeight | vertOffset | colorOffset) < 0)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_792920037 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_792920037.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_792920037;
        } //End block
        if(meshWidth == 0 || meshHeight == 0)        
        {
            return;
        } //End block
        int count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);
        if(colors != null)        
        {
            checkRange(colors.length, colorOffset, count);
        } //End block
        nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             verts, vertOffset, colors, colorOffset,
                             paint != null ? paint.mNativePaint : 0);
        // ---------- Original Method ----------
        //if ((meshWidth | meshHeight | vertOffset | colorOffset) < 0) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //if (meshWidth == 0 || meshHeight == 0) {
            //return;
        //}
        //int count = (meshWidth + 1) * (meshHeight + 1);
        //checkRange(verts.length, vertOffset, count * 2);
        //if (colors != null) {
            //checkRange(colors.length, colorOffset, count);
        //}
        //nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             //verts, vertOffset, colors, colorOffset,
                             //paint != null ? paint.mNativePaint : 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.930 -0400", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "48A5675C21AFED885875C1BF25FC83F0")
    public void drawVertices(VertexMode mode, int vertexCount,
                             float[] verts, int vertOffset,
                             float[] texs, int texOffset,
                             int[] colors, int colorOffset,
                             short[] indices, int indexOffset,
                             int indexCount, Paint paint) {
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
        checkRange(verts.length, vertOffset, vertexCount);
        if(texs != null)        
        {
            checkRange(texs.length, texOffset, vertexCount);
        } //End block
        if(colors != null)        
        {
            checkRange(colors.length, colorOffset, vertexCount / 2);
        } //End block
        if(indices != null)        
        {
            checkRange(indices.length, indexOffset, indexCount);
        } //End block
        nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           vertOffset, texs, texOffset, colors, colorOffset,
                          indices, indexOffset, indexCount, paint.mNativePaint);
        // ---------- Original Method ----------
        //checkRange(verts.length, vertOffset, vertexCount);
        //if (texs != null) {
            //checkRange(texs.length, texOffset, vertexCount);
        //}
        //if (colors != null) {
            //checkRange(colors.length, colorOffset, vertexCount / 2);
        //}
        //if (indices != null) {
            //checkRange(indices.length, indexOffset, indexCount);
        //}
        //nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           //vertOffset, texs, texOffset, colors, colorOffset,
                          //indices, indexOffset, indexCount, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.930 -0400", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "EE5F73AEBFD2C5362E540DBA0031C3D4")
    public void drawText(char[] text, int index, int count, float x, float y,
                         Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if((index | count | (index + count) |
            (text.length - index - count)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1161424686 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1161424686.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1161424686;
        } //End block
        native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //if ((index | count | (index + count) |
            //(text.length - index - count)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.931 -0400", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "8BDCDD88CDBF21753FB511A72105DB2E")
    public void drawText(String text, float x, float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(text.getTaint());
        native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.931 -0400", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "C4B3BCC44526FC1A76914FED81F2F7C0")
    public void drawText(String text, int start, int end, float x, float y,
                         Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if((start | end | (end - start) | (text.length() - end)) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_503711907 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_503711907.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_503711907;
        } //End block
        native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.932 -0400", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "E67EB30951DB319324F54BDEC6A5391E")
    public void drawText(CharSequence text, int start, int end, float x,
                         float y, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text instanceof String || text instanceof SpannedString ||
            text instanceof SpannableString)        
        {
            native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            paint.mBidiFlags, paint.mNativePaint);
        } //End block
        else
        if(text instanceof GraphicsOperations)        
        {
            ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     paint);
        } //End block
        else
        {
            char[] buf = TemporaryBuffer.obtain(end - start);
            TextUtils.getChars(text, start, end, buf, 0);
            native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    paint.mBidiFlags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        //if (text instanceof String || text instanceof SpannedString ||
            //text instanceof SpannableString) {
            //native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            //paint.mBidiFlags, paint.mNativePaint);
        //} else if (text instanceof GraphicsOperations) {
            //((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     //paint);
        //} else {
            //char[] buf = TemporaryBuffer.obtain(end - start);
            //TextUtils.getChars(text, start, end, buf, 0);
            //native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    //paint.mBidiFlags, paint.mNativePaint);
            //TemporaryBuffer.recycle(buf);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.933 -0400", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "5DED010927D098640D9939EB1DD230EB")
    public void drawTextRun(char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir,
            Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dir);
        addTaint(y);
        addTaint(x);
        addTaint(contextCount);
        addTaint(contextIndex);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(text == null)        
        {
            NullPointerException varE721FFF637A8AEB2CF5C45DF4D44B430_515415463 = new NullPointerException("text is null");
            varE721FFF637A8AEB2CF5C45DF4D44B430_515415463.addTaint(taint);
            throw varE721FFF637A8AEB2CF5C45DF4D44B430_515415463;
        } //End block
        if(paint == null)        
        {
            NullPointerException varD3AB27C4A33629CBB43A9C34E8527C11_860799479 = new NullPointerException("paint is null");
            varD3AB27C4A33629CBB43A9C34E8527C11_860799479.addTaint(taint);
            throw varD3AB27C4A33629CBB43A9C34E8527C11_860799479;
        } //End block
        if((index | count | text.length - index - count) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_267736559 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_267736559.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_267736559;
        } //End block
        if(dir != DIRECTION_LTR && dir != DIRECTION_RTL)        
        {
            IllegalArgumentException var841FBAF4D2776F03E46F4ABCA09CF32C_1772573358 = new IllegalArgumentException("unknown dir: " + dir);
            var841FBAF4D2776F03E46F4ABCA09CF32C_1772573358.addTaint(taint);
            throw var841FBAF4D2776F03E46F4ABCA09CF32C_1772573358;
        } //End block
        native_drawTextRun(mNativeCanvas, text, index, count,
                contextIndex, contextCount, x, y, dir, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new NullPointerException("text is null");
        //}
        //if (paint == null) {
            //throw new NullPointerException("paint is null");
        //}
        //if ((index | count | text.length - index - count) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (dir != DIRECTION_LTR && dir != DIRECTION_RTL) {
            //throw new IllegalArgumentException("unknown dir: " + dir);
        //}
        //native_drawTextRun(mNativeCanvas, text, index, count,
                //contextIndex, contextCount, x, y, dir, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.935 -0400", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "7E17BACD15C7D318AA1C3FC2912335F8")
    public void drawTextRun(CharSequence text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int dir,
            Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dir);
        addTaint(y);
        addTaint(x);
        addTaint(contextEnd);
        addTaint(contextStart);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        if(text == null)        
        {
            NullPointerException varE721FFF637A8AEB2CF5C45DF4D44B430_953085188 = new NullPointerException("text is null");
            varE721FFF637A8AEB2CF5C45DF4D44B430_953085188.addTaint(taint);
            throw varE721FFF637A8AEB2CF5C45DF4D44B430_953085188;
        } //End block
        if(paint == null)        
        {
            NullPointerException varD3AB27C4A33629CBB43A9C34E8527C11_2073488835 = new NullPointerException("paint is null");
            varD3AB27C4A33629CBB43A9C34E8527C11_2073488835.addTaint(taint);
            throw varD3AB27C4A33629CBB43A9C34E8527C11_2073488835;
        } //End block
        if((start | end | end - start | text.length() - end) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1219061470 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1219061470.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1219061470;
        } //End block
        int flags = dir == 0 ? 0 : 1;
        if(text instanceof String || text instanceof SpannedString ||
                text instanceof SpannableString)        
        {
            native_drawTextRun(mNativeCanvas, text.toString(), start, end,
                    contextStart, contextEnd, x, y, flags, paint.mNativePaint);
        } //End block
        else
        if(text instanceof GraphicsOperations)        
        {
            ((GraphicsOperations) text).drawTextRun(this, start, end,
                    contextStart, contextEnd, x, y, flags, paint);
        } //End block
        else
        {
            int contextLen = contextEnd - contextStart;
            int len = end - start;
            char[] buf = TemporaryBuffer.obtain(contextLen);
            TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
            native_drawTextRun(mNativeCanvas, buf, start - contextStart, len,
                    0, contextLen, x, y, flags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.936 -0400", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "C2219322C0D828534CD53453A4F05C97")
    public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(index < 0 || index + count > text.length || count*2 > pos.length)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_880132898 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_880132898.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_880132898;
        } //End block
        native_drawPosText(mNativeCanvas, text, index, count, pos,
                           paint.mNativePaint);
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length || count*2 > pos.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, index, count, pos,
                           //paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.937 -0400", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "5AB9FB71BAAC5CA2DFDD16C7E5070216")
    public void drawPosText(String text, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(text.getTaint());
        if(text.length()*2 > pos.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_520339477 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_520339477.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_520339477;
        } //End block
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text.length()*2 > pos.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.938 -0400", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "CDF67B030C1FB47F8A0C61A2A208B9B8")
    public void drawTextOnPath(char[] text, int index, int count, Path path,
                               float hOffset, float vOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(vOffset);
        addTaint(hOffset);
        addTaint(path.getTaint());
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(index < 0 || index + count > text.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_2097164710 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_2097164710.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_2097164710;
        } //End block
        native_drawTextOnPath(mNativeCanvas, text, index, count,
                              path.ni(), hOffset, vOffset,
                              paint.mBidiFlags, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawTextOnPath(mNativeCanvas, text, index, count,
                              //path.ni(), hOffset, vOffset,
                              //paint.mBidiFlags, paint.mNativePaint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.939 -0400", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "47372CB79179E82107419AB1D8FAEA1D")
    public void drawTextOnPath(String text, Path path, float hOffset,
                               float vOffset, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(vOffset);
        addTaint(hOffset);
        addTaint(path.getTaint());
        addTaint(text.getTaint());
        if(text.length() > 0)        
        {
            native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  hOffset, vOffset, paint.mBidiFlags,
                                  paint.mNativePaint);
        } //End block
        // ---------- Original Method ----------
        //if (text.length() > 0) {
            //native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  //hOffset, vOffset, paint.mBidiFlags,
                                  //paint.mNativePaint);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.939 -0400", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "47757917294BA25293EFD3726F6C75B1")
    public void drawPicture(Picture picture) {
        addTaint(picture.getTaint());
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
        // ---------- Original Method ----------
        //picture.endRecording();
        //native_drawPicture(mNativeCanvas, picture.ni());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.940 -0400", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "9FC4E31C28FE8403BAFF127D81E861CF")
    public void drawPicture(Picture picture, RectF dst) {
        addTaint(dst.getTaint());
        addTaint(picture.getTaint());
        save();
        translate(dst.left, dst.top);
        if(picture.getWidth() > 0 && picture.getHeight() > 0)        
        {
            scale(dst.width() / picture.getWidth(),
                  dst.height() / picture.getHeight());
        } //End block
        drawPicture(picture);
        restore();
        // ---------- Original Method ----------
        //save();
        //translate(dst.left, dst.top);
        //if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            //scale(dst.width() / picture.getWidth(),
                  //dst.height() / picture.getHeight());
        //}
        //drawPicture(picture);
        //restore();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.941 -0400", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "A2A785D511E81C7C2AA656A7A16638E2")
    public void drawPicture(Picture picture, Rect dst) {
        addTaint(dst.getTaint());
        addTaint(picture.getTaint());
        save();
        translate(dst.left, dst.top);
        if(picture.getWidth() > 0 && picture.getHeight() > 0)        
        {
            scale((float)dst.width() / picture.getWidth(),
                  (float)dst.height() / picture.getHeight());
        } //End block
        drawPicture(picture);
        restore();
        // ---------- Original Method ----------
        //save();
        //translate(dst.left, dst.top);
        //if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            //scale((float)dst.width() / picture.getWidth(),
                  //(float)dst.height() / picture.getHeight());
        //}
        //drawPicture(picture);
        //restore();
    }

    
    @DSModeled(DSC.SAFE)
    public static void freeCaches() {
    }

    
    @DSModeled(DSC.SAFE)
    private static int initRaster(int nativeBitmapOrZero) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setBitmap(int nativeCanvas, int bitmap) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_concat(int nCanvas, int nMatrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_setMatrix(int nCanvas, int nMatrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_getCTM(int canvas, int matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawRGB(int nativeCanvas, int r, int g,
                                              int b) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawARGB(int nativeCanvas, int a, int r,
                                               int g, int b) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawColor(int nativeCanvas, int color) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawColor(int nativeCanvas, int color,
                                                int mode) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawPaint(int nativeCanvas, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawLine(int nativeCanvas, float startX,
                                               float startY, float stopX,
                                               float stopY, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawRect(int nativeCanvas, RectF rect,
                                               int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawRect(int nativeCanvas, float left,
                                               float top, float right,
                                               float bottom, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawOval(int nativeCanvas, RectF oval,
                                               int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawCircle(int nativeCanvas, float cx,
                                                 float cy, float radius,
                                                 int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawArc(int nativeCanvas, RectF oval,
                                              float startAngle, float sweep,
                                              boolean useCenter, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawRoundRect(int nativeCanvas,
                                                    RectF rect, float rx,
                                                    float ry, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawPath(int nativeCanvas, int path,
                                               int paint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.953 -0400", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "1978C6A28FFF2DB3A4C5A5D1D9333DBD")
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 float left, float top,
                                                 int nativePaintOrZero,
                                                 int canvasDensity,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.954 -0400", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "763AB84984E018ED98A2E3B0F74BDC61")
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, RectF dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, Rect dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawBitmap(int nativeCanvas, int[] colors,
                                                int offset, int stride, float x,
                                                 float y, int width, int height,
                                                 boolean hasAlpha,
                                                 int nativePaintOrZero) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDrawBitmapMatrix(int nCanvas, int nBitmap,
                                                      int nMatrix, int nPaint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDrawBitmapMesh(int nCanvas, int nBitmap,
                                                    int meshWidth, int meshHeight,
                                                    float[] verts, int vertOffset,
                                                    int[] colors, int colorOffset, int nPaint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDrawVertices(int nCanvas, int mode, int n,
                   float[] verts, int vertOffset, float[] texs, int texOffset,
                   int[] colors, int colorOffset, short[] indices,
                   int indexOffset, int indexCount, int nPaint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawText(int nativeCanvas, char[] text,
                                               int index, int count, float x,
                                               float y, int flags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawText(int nativeCanvas, String text,
                                               int start, int end, float x,
                                               float y, int flags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawTextRun(int nativeCanvas, String text,
            int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawTextRun(int nativeCanvas, char[] text,
            int start, int count, int contextStart, int contextCount,
            float x, float y, int flags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawPosText(int nativeCanvas,
                                                  char[] text, int index,
                                                  int count, float[] pos,
                                                  int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawPosText(int nativeCanvas,
                                                  String text, float[] pos,
                                                  int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     char[] text, int index,
                                                     int count, int path,
                                                     float hOffset,
                                                     float vOffset, int bidiFlags,
                                                     int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     String text, int path,
                                                     float hOffset, 
                                                     float vOffset, 
                                                     int flags, int paint) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void native_drawPicture(int nativeCanvas,
                                                  int nativePicture) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void finalizer(int nativeCanvas) {
    }

    
    private static class CanvasFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.956 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "2D4BC4BEF691AE213514DA2EF6E7568C")

        private int mNativeCanvas;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.956 -0400", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "B264373C320A36AAFBD12A28825D248D")
        public  CanvasFinalizer(int nativeCanvas) {
            mNativeCanvas = nativeCanvas;
            // ---------- Original Method ----------
            //mNativeCanvas = nativeCanvas;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.956 -0400", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "E0DD32B7B7DB5442C1A4ACFF42D259E6")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                if(mNativeCanvas != 0)                
                {
                    finalizer(mNativeCanvas);
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (mNativeCanvas != 0) {
                    //finalizer(mNativeCanvas);
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
    public enum EdgeType {
        BW(0),  
        AA(1);  
        EdgeType(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
    public enum VertexMode {
        TRIANGLES(0),
        TRIANGLE_STRIP(1),
        TRIANGLE_FAN(2);
        VertexMode(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        public final int nativeInt;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "C556908955BCA8DE829C1472DC13D030", hash_generated_field = "C086895BCC59A770BE756AADD45CAAC6")

    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "F4BF6B1C8A93145BA1CB4CB556F8ADF8", hash_generated_field = "6A8DA922229349FE565C69BCB53E7C76")

    public static final int MATRIX_SAVE_FLAG = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "37D5AB303E356F1AB33043E7CBEFBD08", hash_generated_field = "58F530C9C6B270B19539C29F0F59AF3F")

    public static final int CLIP_SAVE_FLAG = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "AB31C1A54E066A5DBA1B2797D23C5043", hash_generated_field = "46E7D1290A1803E6928B2E065D955191")

    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "28C403FDD6A4FCC72A3C41B2D78DEE83", hash_generated_field = "532BC0688FBCF248880462AA6827890F")

    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "97F975D3F457D0AEE16D292A34785CDA", hash_generated_field = "9BC3AB123F6CF841BC3428B9EA233C60")

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.957 -0400", hash_original_field = "E4DF070159C4F6422D39F4135C00F6BC", hash_generated_field = "A21A7EFBC48A7EE5E4832E43F9767035")

    public static final int ALL_SAVE_FLAG = 0x1F;
}

