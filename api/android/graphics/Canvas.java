package android.graphics;

// Droidsafe Imports
import javax.microedition.khronos.opengles.GL;

import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class Canvas {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.066 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "9AEAAB458F04AA015A1FEC7988D58EFD")

    int mNativeCanvas;
    private Bitmap  mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.066 -0400", hash_original_field = "33EC7BAD3C77F28DF4CAC7D27FF9F413", hash_generated_field = "31D717B55AEC45D08AFE5E2055099FE3")

    private DrawFilter mDrawFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.067 -0400", hash_original_field = "374AD1D5FABD7F0924F98F93B66480BB", hash_generated_field = "26A3C4D459B626187E0E8706060CBC58")

    protected int mDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.067 -0400", hash_original_field = "3C7272D39DFDF8BA7BC8BAE70278C78B", hash_generated_field = "B3B96B83CBF6A474ACFDE54DAF7E8D5B")

    protected int mScreenDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.067 -0400", hash_original_field = "D2E79E153A2C7AD6C353ED3C0C4AF8B9", hash_generated_field = "5A79E0455BB83A8F5930E665EB36A02A")

    @SuppressWarnings({"UnusedDeclaration"}) private int mSurfaceFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.067 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D26BA3C2A6930E011E689CD349B6702B")

    @SuppressWarnings({"UnusedDeclaration"}) private CanvasFinalizer mFinalizer;
    
    @DSModeled(value = DSC.SAFE)
	public Canvas() {
		//Do Nothing
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.068 -0400", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "DB4E82951E063CEEECA13CEF410C1C45")
    public  Canvas(Bitmap bitmap) {
        if(!bitmap.isMutable())        
        {
            IllegalStateException varB9C3A3A59BC5C857E3F255B36EEF0DC8_228178167 = new IllegalStateException(
                            "Immutable bitmap passed to Canvas constructor");
            varB9C3A3A59BC5C857E3F255B36EEF0DC8_228178167.addTaint(taint);
            throw varB9C3A3A59BC5C857E3F255B36EEF0DC8_228178167;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.068 -0400", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "8AD3B420F89C77904C96EB19695F13AC")
      Canvas(int nativeCanvas) {
        if(nativeCanvas == 0)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1752058371 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1752058371.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1752058371;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.069 -0400", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "34311A5FF1FA45B349D973EEDF587B46")
    @Deprecated
    protected GL getGL() {
GL var540C13E9E156B687226421B24F2DF178_1684756069 =         null;
        var540C13E9E156B687226421B24F2DF178_1684756069.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1684756069;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.069 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "C670E0BF3904BF5E2AF308681ADAC914")
    public boolean isHardwareAccelerated() {
        boolean var68934A3E9455FA72420237EB05902327_1007197896 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433561194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433561194;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(value = DSC.SAFE)
	public void setBitmap(Bitmap bitmap) {
		addTaint(bitmap.getTaint());
		addTaint(bitmap.getDensity()); //getDensity will return a tainted value
		/*
        if (isHardwareAccelerated()) {
            throw new RuntimeException("Can't set a bitmap device on a GL canvas");
        }
        int pointer = 0;
        if (bitmap != null) {
            if (!bitmap.isMutable()) {
                throw new IllegalStateException();
            }
            throwIfRecycled(bitmap);
            mDensity = bitmap.mDensity;
            pointer = bitmap.ni();
        }
        native_setBitmap(mNativeCanvas, pointer);
        mBitmap = bitmap;
        */
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.070 -0400", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "5E7607C7F35EFC6197184F074C0525A9")
    public void setViewport(int width, int height) {
        addTaint(height);
        addTaint(width);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.070 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "11250A7179EFE8050904D6ABF0E956FB")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823395985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823395985;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.070 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "E71B1DE573A6109483C63EBEB40F9290")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960359390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960359390;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.071 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "F262DACE74B24E8D30C50E6BEB69964D")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761326365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761326365;
    }

    
    @DSModeled(value = DSC.SAFE)
	public int getDensity() {
		return getTaintInt();
		//return mDensity;
    }

    
    @DSModeled(value = DSC.SAFE)
	public void setDensity(int density) {
		addTaint(density);  //Density is saved both here and in the bitmap
		mBitmap.setDensity(density);  //setDensity will track the taint in the Bitmap object
		/*
        if (mBitmap != null) {
            mBitmap.setDensity(density);
        }
        mDensity = density;
        */
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.072 -0400", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "A6B4CCAC527ADCBCA2970ADC88659071")
    public void setScreenDensity(int density) {
        mScreenDensity = density;
        // ---------- Original Method ----------
        //mScreenDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.072 -0400", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "A7B41D77C3AB46D10E184EFC1FCA8BC3")
    public int getMaximumBitmapWidth() {
        int varEFF742E655CE706FE07F716F7242F89C_1613106076 = (MAXMIMUM_BITMAP_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599759488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599759488;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.072 -0400", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "734FE2835AB3BBC5AD761998783FE50E")
    public int getMaximumBitmapHeight() {
        int varEFF742E655CE706FE07F716F7242F89C_468150863 = (MAXMIMUM_BITMAP_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199461408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199461408;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.073 -0400", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "503214C4F575748D5A46C01D41E9CBFD")
    public int save() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442891613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442891613;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.073 -0400", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "2D5DDCD9D11C68046BF5AE7CEF5B3FD2")
    @DSModeled(DSC.SAFE)
    public int save(int saveFlags) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973425025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973425025;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.073 -0400", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "6ABFE859E9A3FE0274D64AB7F73A60F3")
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bounds.getTaint());
        int var2F72CAB9E82AE6D65726D922CDB4ACED_270193317 = (native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461167556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461167556;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, bounds,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.074 -0400", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "7BECA52F7C5541ADF84D88BD428BB766")
    public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        addTaint(saveFlags);
        addTaint(paint.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        int var78BE8BC6EEE8543E5FE41A72939C05E4_893329239 = (native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548106417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548106417;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.074 -0400", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "36461D0B505973538E3779D2072980DE")
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bounds.getTaint());
        alpha = Math.min(255, Math.max(0, alpha));
        int varDAFA73D4CF9EAA021A7201BFA4BDDE24_1880264967 = (native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121451535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121451535;
        // ---------- Original Method ----------
        //alpha = Math.min(255, Math.max(0, alpha));
        //return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.075 -0400", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "16F246718EE8471A135D0DC595BA7C7D")
    public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        addTaint(saveFlags);
        addTaint(alpha);
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        int varFFB2E6758484BEC5ABC723AFF5EEBA3B_327835553 = (native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319446334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319446334;
        // ---------- Original Method ----------
        //return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     //alpha, saveFlags);
    }

    
    @DSModeled(DSC.SAFE)
    public void restore() {
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.075 -0400", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "D27494997966DF7456C87742D89CCC6C")
    public int getSaveCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699527867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699527867;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.076 -0400", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "974A4A0419CFC80E5DCE3A10E5A44569")
    public void restoreToCount(int saveCount) {
    }

    
    @DSModeled(DSC.SAFE)
	public void translate(float dx, float dy) {
		addTaint(dx);
		addTaint(dy);
	}

    
    @DSModeled(DSC.SAFE)
	public void scale(float sx, float sy) {
		addTaint(sx);
		addTaint(sy);
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.077 -0400", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "CDEABD23C9A2F7AD3AFA53FBF751A464")
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
	public void rotate(float degrees) {
		addTaint(degrees);
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.077 -0400", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "8ECECC7987074C9CD61575A5DAC2B527")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.078 -0400", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "8C9F38F6D7E6C080ECF146BE9233FC5D")
    public void skew(float sx, float sy) {
    }

    
    @DSModeled(DSC.SAFE)
	public void concat(Matrix matrix) {
		addTaint(matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.078 -0400", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "96B2676400786CD1F61DCB6834818734")
    public void setMatrix(Matrix matrix) {
        addTaint(matrix.getTaint());
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
        // ---------- Original Method ----------
        //native_setMatrix(mNativeCanvas,
                         //matrix == null ? 0 : matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.079 -0400", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "3A3372FD72956C9E9D7FD09558117C60")
    public void getMatrix(Matrix ctm) {
        addTaint(ctm.getTaint());
        native_getCTM(mNativeCanvas, ctm.native_instance);
        // ---------- Original Method ----------
        //native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.083 -0400", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "459A71B8333BB0FFE4A7E07AFF944DBF")
    public final Matrix getMatrix() {
        Matrix m = new Matrix();
        getMatrix(m);
Matrix varBD22C5ECD1F8BC3EE2416AF7A8014FD2_303706451 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_303706451.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_303706451;
        // ---------- Original Method ----------
        //Matrix m = new Matrix();
        //getMatrix(m);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.084 -0400", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "D73DF58C892AD94E6052B61CD9B9D030")
    public boolean clipRect(RectF rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var24674B6C369AA84B24BD6C57ABBD02EF_501314456 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882657171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882657171;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.084 -0400", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "2E4CD136E9EEAD527F5AC2681B192C15")
    public boolean clipRect(Rect rect, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(rect.getTaint());
        boolean var24674B6C369AA84B24BD6C57ABBD02EF_582531576 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396480418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396480418;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.085 -0400", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "1D34339D6FF862417CBDFED266D4BED2")
    public boolean clipRect(RectF rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75111500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75111500;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.086 -0400", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "E0BBC7C48914FF1E53F4DEE4CEA5AC1A")
    public boolean clipRect(Rect rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109373803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109373803;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.086 -0400", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "AB3CCB735438798941D098A122C7BB10")
    public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        addTaint(op.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean varD7AC0BD0D62861CC137EA1FAC782D37D_424975876 = (native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120621646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120621646;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.087 -0400", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "3103DB16D116EDACBE978EAD6193945A")
    public boolean clipRect(float left, float top,
                                   float right, float bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205310301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205310301;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.087 -0400", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "87ACCB84420D79A59F58C707E152E251")
    public boolean clipRect(int left, int top,
                                   int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401571668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401571668;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.088 -0400", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "1DC55DC07C2EA026D27802E38AF2C40B")
    public boolean clipPath(Path path, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(path.getTaint());
        boolean var368077C868F5558511AED0E4E369F219_686315447 = (native_clipPath(mNativeCanvas, path.ni(), op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305785837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305785837;
        // ---------- Original Method ----------
        //return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.088 -0400", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "9B0B3E643B65318591A37450246A1CC3")
    public boolean clipPath(Path path) {
        addTaint(path.getTaint());
        boolean var02AC20FF4C25BECDDDCCAB8CD257C45D_1640018855 = (clipPath(path, Region.Op.INTERSECT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416650410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416650410;
        // ---------- Original Method ----------
        //return clipPath(path, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.088 -0400", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "C8194241794BBCAC4524CA535D5C21B7")
    public boolean clipRegion(Region region, Region.Op op) {
        addTaint(op.getTaint());
        addTaint(region.getTaint());
        boolean varF44AD2F9DE9FA406AA85FC800A9B2413_788527042 = (native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703190792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703190792;
        // ---------- Original Method ----------
        //return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.089 -0400", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "9BBA94B4F6178A3DA6715767637CEF00")
    public boolean clipRegion(Region region) {
        addTaint(region.getTaint());
        boolean varBCA634D2998124C6DB2C94FFEEC5D33E_2043824464 = (clipRegion(region, Region.Op.INTERSECT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347177653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347177653;
        // ---------- Original Method ----------
        //return clipRegion(region, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.090 -0400", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "BC7B7705DDB4FDE5B4A67D956200EA50")
    public DrawFilter getDrawFilter() {
DrawFilter var5EDA12300AEAAFC248858F9EEC89F965_368287631 =         mDrawFilter;
        var5EDA12300AEAAFC248858F9EEC89F965_368287631.addTaint(taint);
        return var5EDA12300AEAAFC248858F9EEC89F965_368287631;
        // ---------- Original Method ----------
        //return mDrawFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.091 -0400", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "15C5B84B5ADFCF92FA52DCD023CFDCD7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.091 -0400", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "9A35733127EEE06035D7B46D3176A320")
    public boolean quickReject(RectF rect, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(rect.getTaint());
        boolean varB1B99A16647CDB21F5DEC0E24EE58FD4_1842556855 = (native_quickReject(mNativeCanvas, rect, type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333910616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333910616;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.091 -0400", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "7357A79A8EF9BC52C76458721757F85E")
    public boolean quickReject(Path path, EdgeType type) {
        addTaint(type.getTaint());
        addTaint(path.getTaint());
        boolean varB5DEF5671B1C98A9B71B3911DC40BF72_1357556095 = (native_quickReject(mNativeCanvas, path.ni(), type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354534132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354534132;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.092 -0400", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "288C21394D210690C3CD6A4C944572C0")
    public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        addTaint(type.getTaint());
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean var8F2F42CD37C1D52BA9CCFA1F8E6AE8D8_1684431700 = (native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1321652334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1321652334;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  //type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.092 -0400", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "C732AB37010F3CD71747C04A97B956F3")
    public boolean getClipBounds(Rect bounds) {
        addTaint(bounds.getTaint());
        boolean varA98C3E9BB60A5C0F1E477AD90B08B580_1592576393 = (native_getClipBounds(mNativeCanvas, bounds));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781059740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781059740;
        // ---------- Original Method ----------
        //return native_getClipBounds(mNativeCanvas, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.093 -0400", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "4869A7729157453CDF69EFD225866172")
    public final Rect getClipBounds() {
        Rect r = new Rect();
        getClipBounds(r);
Rect var4C1F3C86A0E56B6E375080F5F710547E_1682459688 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_1682459688.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_1682459688;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //getClipBounds(r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.096 -0400", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "B3F7EACD5A719DF9BE71A4BD25E978FE")
    public void drawRGB(int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        native_drawRGB(mNativeCanvas, r, g, b);
        // ---------- Original Method ----------
        //native_drawRGB(mNativeCanvas, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.096 -0400", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "E9E61FA3F9EE61836A7F346E1C787C8E")
    public void drawARGB(int a, int r, int g, int b) {
        addTaint(b);
        addTaint(g);
        addTaint(r);
        addTaint(a);
        native_drawARGB(mNativeCanvas, a, r, g, b);
        // ---------- Original Method ----------
        //native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.097 -0400", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "A8B513A56FF5C578DB10A6FDD49B92E0")
    @DSModeled(DSC.SAFE)
    public void drawColor(int color) {
        addTaint(color);
        native_drawColor(mNativeCanvas, color);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.097 -0400", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "CE02F13E6307D6ABEA745CE735B00A7C")
    public void drawColor(int color, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(color);
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.097 -0400", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "BF6573436AB274374078C50D9F5434CD")
    public void drawPaint(Paint paint) {
        addTaint(paint.getTaint());
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.098 -0400", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "6FF2BCA7A4B0B8AB911130468726B5DA")
    public void drawPoints(float[] pts, int offset, int count,
                                  Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.099 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "B69588386471F89E34165E1BF55AC31E")
    public void drawPoints(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawPoints(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.099 -0400", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "CC1E903F166689821C3A24C5F449BF0F")
    public void drawPoint(float x, float y, Paint paint) {
    }

    
    @DSModeled(DSC.SAFE)
	public void drawLine(float startX, float startY, float stopX, float stopY,
            Paint paint) {
		/*
		 * This method calls a native method that draws to a native canvas which
		 * is represented by the mNativeCanvas (a pointer/handle) value in the SDK 
		 * implementation the call will modify the bitmap managed by the native code.
		 * 
		 * DSFIXME:  Technically the underlying bitmap will be changed 
		 * (represented by the int mNativeCanvas).  It appears that this
		 * operation happens in real time, so tracking taint is difficult
		 * on the upflow.
		 */
		addTaint(startX);
		addTaint(startY);
		addTaint(stopX);
		addTaint(stopY);
		addTaint(paint.getTaint());
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.100 -0400", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "BC11F5ED395D07C9E16C7DC1EBD0C9F8")
    public void drawLines(float[] pts, int offset, int count,
                                 Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.100 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "240D0D497D3344413E6F301FD6886910")
    public void drawLines(float[] pts, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pts[0]);
        drawLines(pts, 0, pts.length, paint);
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.100 -0400", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "5C7970080710503FEA9475DCFFE9EE2E")
    public void drawRect(RectF rect, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(rect.getTaint());
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.101 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "70EEEE2E580CA4DAB0C2EFA671CD1698")
    public void drawRect(Rect r, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(r.getTaint());
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.101 -0400", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "70D750C631A2CACFBEC9B5AF328C9167")
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
    public void drawOval(RectF oval, Paint paint) {
		addTaint(oval.getTaint());
		addTaint(paint.getTaint());
    	/* GITI DSModeled
        if (oval == null) {
            throw new NullPointerException();
        }
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        */
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.102 -0400", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "60AC95F7F5E6ED28C5FD44D65BCB54B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.102 -0400", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "9635E880B3C2B2E3543F727C75A46D1D")
    public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(useCenter);
        addTaint(sweepAngle);
        addTaint(startAngle);
        addTaint(oval.getTaint());
        if(oval == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1192667847 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1192667847.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1192667847;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.103 -0400", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "3282C4E0443B8647A955A63F299AAE48")
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(ry);
        addTaint(rx);
        addTaint(rect.getTaint());
        if(rect == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_202046361 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_202046361.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_202046361;
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
    public void drawPath(Path path, Paint paint) {
		addTaint(path.getTaint());
		addTaint(paint.getTaint());
        /*
         native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        */
    }

    
    private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.106 -0400", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "4CEE03DE2E27870C2160F08F6922FE0E")
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(chunks[0]);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
		addTaint(bitmap.getTaint());
		addTaint(left);
		addTaint(top);
		addTaint(paint.getTaint());
		/*
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                bitmap.mDensity);
        */
    }

    
    @DSModeled(DSC.SAFE)
	public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
		addTaint(bitmap.getTaint());
		addTaint(src.getTaint());
		addTaint(dst.getTaint());
		addTaint(paint.getTaint());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.108 -0400", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "910B7FF1B58701BE6C405730613CE833")
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
        addTaint(bitmap.getTaint());
        if(dst == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_747018885 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_747018885.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_747018885;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.109 -0400", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "3E63877D8808DF9719A8F4C0A23AD54C")
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
            IllegalArgumentException var3466F3A966382BEF5BF802F7CB74379A_675315338 = new IllegalArgumentException("width must be >= 0");
            var3466F3A966382BEF5BF802F7CB74379A_675315338.addTaint(taint);
            throw var3466F3A966382BEF5BF802F7CB74379A_675315338;
        } //End block
        if(height < 0)        
        {
            IllegalArgumentException var32D5EA37D2C9CC8D7924EB1890514E85_181114368 = new IllegalArgumentException("height must be >= 0");
            var32D5EA37D2C9CC8D7924EB1890514E85_181114368.addTaint(taint);
            throw var32D5EA37D2C9CC8D7924EB1890514E85_181114368;
        } //End block
        if(Math.abs(stride) < width)        
        {
            IllegalArgumentException varD1549FCE299AC8F2198C0DF0EF8A3981_322751611 = new IllegalArgumentException("abs(stride) must be >= width");
            varD1549FCE299AC8F2198C0DF0EF8A3981_322751611.addTaint(taint);
            throw varD1549FCE299AC8F2198C0DF0EF8A3981_322751611;
        } //End block
        int lastScanline = offset + (height - 1) * stride;
        int length = colors.length;
        if(offset < 0 || (offset + width > length) || lastScanline < 0
                || (lastScanline + width > length))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1280953442 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1280953442.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1280953442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.110 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "78F74E18FD210530369BA07793BF08B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.110 -0400", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "1CB0ABB74C82F6E12D6E115A65203896")
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

    
    protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.111 -0400", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "2FD82B91C315E8EB77CCE3735CAE1CFD")
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
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_1861510340 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_1861510340.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_1861510340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.112 -0400", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "48A5675C21AFED885875C1BF25FC83F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.112 -0400", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "D5BB32EAB4D03308821E93F9C7BAA7CA")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1365171152 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1365171152.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1365171152;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.113 -0400", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "8BDCDD88CDBF21753FB511A72105DB2E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.113 -0400", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "7DCAA30368332959F543B2BA06A65AE3")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1819247974 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1819247974.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1819247974;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.114 -0400", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "E67EB30951DB319324F54BDEC6A5391E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.114 -0400", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "E8D342E8F62A78D2BEEFEF30CE3285B5")
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
            NullPointerException varE721FFF637A8AEB2CF5C45DF4D44B430_1649379091 = new NullPointerException("text is null");
            varE721FFF637A8AEB2CF5C45DF4D44B430_1649379091.addTaint(taint);
            throw varE721FFF637A8AEB2CF5C45DF4D44B430_1649379091;
        } //End block
        if(paint == null)        
        {
            NullPointerException varD3AB27C4A33629CBB43A9C34E8527C11_933104680 = new NullPointerException("paint is null");
            varD3AB27C4A33629CBB43A9C34E8527C11_933104680.addTaint(taint);
            throw varD3AB27C4A33629CBB43A9C34E8527C11_933104680;
        } //End block
        if((index | count | text.length - index - count) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_723190129 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_723190129.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_723190129;
        } //End block
        if(dir != DIRECTION_LTR && dir != DIRECTION_RTL)        
        {
            IllegalArgumentException var841FBAF4D2776F03E46F4ABCA09CF32C_790042923 = new IllegalArgumentException("unknown dir: " + dir);
            var841FBAF4D2776F03E46F4ABCA09CF32C_790042923.addTaint(taint);
            throw var841FBAF4D2776F03E46F4ABCA09CF32C_790042923;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.115 -0400", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "8A69C7F09264EE2778F86C09A8230722")
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
            NullPointerException varE721FFF637A8AEB2CF5C45DF4D44B430_146323187 = new NullPointerException("text is null");
            varE721FFF637A8AEB2CF5C45DF4D44B430_146323187.addTaint(taint);
            throw varE721FFF637A8AEB2CF5C45DF4D44B430_146323187;
        } //End block
        if(paint == null)        
        {
            NullPointerException varD3AB27C4A33629CBB43A9C34E8527C11_513104140 = new NullPointerException("paint is null");
            varD3AB27C4A33629CBB43A9C34E8527C11_513104140.addTaint(taint);
            throw varD3AB27C4A33629CBB43A9C34E8527C11_513104140;
        } //End block
        if((start | end | end - start | text.length() - end) < 0)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1820341698 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1820341698.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1820341698;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.116 -0400", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "721A9A2266EF164827437C4BF78A2D68")
    public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(count);
        addTaint(index);
        addTaint(text[0]);
        if(index < 0 || index + count > text.length || count*2 > pos.length)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1896005073 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1896005073.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1896005073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.116 -0400", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "99075A5CD9C1646CF2688222D793BFD9")
    public void drawPosText(String text, float[] pos, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(pos[0]);
        addTaint(text.getTaint());
        if(text.length()*2 > pos.length)        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_477913036 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_477913036.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_477913036;
        } //End block
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
        // ---------- Original Method ----------
        //if (text.length()*2 > pos.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.117 -0400", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "59EE3E1D5AA2B9376155A0DDE3C7F519")
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
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_878616029 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_878616029.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_878616029;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.117 -0400", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "47372CB79179E82107419AB1D8FAEA1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.118 -0400", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "47757917294BA25293EFD3726F6C75B1")
    public void drawPicture(Picture picture) {
        addTaint(picture.getTaint());
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
        // ---------- Original Method ----------
        //picture.endRecording();
        //native_drawPicture(mNativeCanvas, picture.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.118 -0400", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "9FC4E31C28FE8403BAFF127D81E861CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.118 -0400", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "A2A785D511E81C7C2AA656A7A16638E2")
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

    
    public static void freeCaches() {
    }

    
    private static int initRaster(int nativeBitmapOrZero) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378610903 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378610903;
    }

    
    private static void native_setBitmap(int nativeCanvas, int bitmap) {
    }

    
    private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467194653 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467194653;
    }

    
    private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430058921 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430058921;
    }

    
    private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730328887 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730328887;
    }

    
    private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192671444 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192671444;
    }

    
    private static void native_concat(int nCanvas, int nMatrix) {
    }

    
    private static void native_setMatrix(int nCanvas, int nMatrix) {
    }

    
    private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065743384 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065743384;
    }

    
    private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071424835 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071424835;
    }

    
    private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786500323 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786500323;
    }

    
    private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
    }

    
    private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373360843 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373360843;
    }

    
    private static void native_getCTM(int canvas, int matrix) {
    }

    
    private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522063304 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522063304;
    }

    
    private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643825593 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643825593;
    }

    
    private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380645477 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380645477;
    }

    
    private static void native_drawRGB(int nativeCanvas, int r, int g,
                                              int b) {
    }

    
    private static void native_drawARGB(int nativeCanvas, int a, int r,
                                               int g, int b) {
    }

    
    private static void native_drawColor(int nativeCanvas, int color) {
    }

    
    private static void native_drawColor(int nativeCanvas, int color,
                                                int mode) {
    }

    
    private static void native_drawPaint(int nativeCanvas, int paint) {
    }

    
    private static void native_drawLine(int nativeCanvas, float startX,
                                               float startY, float stopX,
                                               float stopY, int paint) {
    }

    
    private static void native_drawRect(int nativeCanvas, RectF rect,
                                               int paint) {
    }

    
    private static void native_drawRect(int nativeCanvas, float left,
                                               float top, float right,
                                               float bottom, int paint) {
    }

    
    private static void native_drawOval(int nativeCanvas, RectF oval,
                                               int paint) {
    }

    
    private static void native_drawCircle(int nativeCanvas, float cx,
                                                 float cy, float radius,
                                                 int paint) {
    }

    
    private static void native_drawArc(int nativeCanvas, RectF oval,
                                              float startAngle, float sweep,
                                              boolean useCenter, int paint) {
    }

    
    private static void native_drawRoundRect(int nativeCanvas,
                                                    RectF rect, float rx,
                                                    float ry, int paint) {
    }

    
    private static void native_drawPath(int nativeCanvas, int path,
                                               int paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.127 -0400", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "1978C6A28FFF2DB3A4C5A5D1D9333DBD")
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 float left, float top,
                                                 int nativePaintOrZero,
                                                 int canvasDensity,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.127 -0400", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "763AB84984E018ED98A2E3B0F74BDC61")
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, RectF dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    private static void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 Rect src, Rect dst,
                                                 int nativePaintOrZero,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    private static void native_drawBitmap(int nativeCanvas, int[] colors,
                                                int offset, int stride, float x,
                                                 float y, int width, int height,
                                                 boolean hasAlpha,
                                                 int nativePaintOrZero) {
    }

    
    private static void nativeDrawBitmapMatrix(int nCanvas, int nBitmap,
                                                      int nMatrix, int nPaint) {
    }

    
    private static void nativeDrawBitmapMesh(int nCanvas, int nBitmap,
                                                    int meshWidth, int meshHeight,
                                                    float[] verts, int vertOffset,
                                                    int[] colors, int colorOffset, int nPaint) {
    }

    
    private static void nativeDrawVertices(int nCanvas, int mode, int n,
                   float[] verts, int vertOffset, float[] texs, int texOffset,
                   int[] colors, int colorOffset, short[] indices,
                   int indexOffset, int indexCount, int nPaint) {
    }

    
    private static void native_drawText(int nativeCanvas, char[] text,
                                               int index, int count, float x,
                                               float y, int flags, int paint) {
    }

    
    private static void native_drawText(int nativeCanvas, String text,
                                               int start, int end, float x,
                                               float y, int flags, int paint) {
    }

    
    private static void native_drawTextRun(int nativeCanvas, String text,
            int start, int end, int contextStart, int contextEnd,
            float x, float y, int flags, int paint) {
    }

    
    private static void native_drawTextRun(int nativeCanvas, char[] text,
            int start, int count, int contextStart, int contextCount,
            float x, float y, int flags, int paint) {
    }

    
    private static void native_drawPosText(int nativeCanvas,
                                                  char[] text, int index,
                                                  int count, float[] pos,
                                                  int paint) {
    }

    
    private static void native_drawPosText(int nativeCanvas,
                                                  String text, float[] pos,
                                                  int paint) {
    }

    
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     char[] text, int index,
                                                     int count, int path,
                                                     float hOffset,
                                                     float vOffset, int bidiFlags,
                                                     int paint) {
    }

    
    private static void native_drawTextOnPath(int nativeCanvas,
                                                     String text, int path,
                                                     float hOffset, 
                                                     float vOffset, 
                                                     int flags, int paint) {
    }

    
    private static void native_drawPicture(int nativeCanvas,
                                                  int nativePicture) {
    }

    
    private static void finalizer(int nativeCanvas) {
    }

    
    private static class CanvasFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.131 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "2D4BC4BEF691AE213514DA2EF6E7568C")

        private int mNativeCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.132 -0400", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "B264373C320A36AAFBD12A28825D248D")
        public  CanvasFinalizer(int nativeCanvas) {
            mNativeCanvas = nativeCanvas;
            // ---------- Original Method ----------
            //mNativeCanvas = nativeCanvas;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.132 -0400", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "E0DD32B7B7DB5442C1A4ACFF42D259E6")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.132 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.132 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.132 -0400", hash_original_field = "C556908955BCA8DE829C1472DC13D030", hash_generated_field = "C086895BCC59A770BE756AADD45CAAC6")

    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "F4BF6B1C8A93145BA1CB4CB556F8ADF8", hash_generated_field = "6A8DA922229349FE565C69BCB53E7C76")

    public static final int MATRIX_SAVE_FLAG = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "37D5AB303E356F1AB33043E7CBEFBD08", hash_generated_field = "58F530C9C6B270B19539C29F0F59AF3F")

    public static final int CLIP_SAVE_FLAG = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "AB31C1A54E066A5DBA1B2797D23C5043", hash_generated_field = "46E7D1290A1803E6928B2E065D955191")

    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "28C403FDD6A4FCC72A3C41B2D78DEE83", hash_generated_field = "532BC0688FBCF248880462AA6827890F")

    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "97F975D3F457D0AEE16D292A34785CDA", hash_generated_field = "9BC3AB123F6CF841BC3428B9EA233C60")

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.133 -0400", hash_original_field = "E4DF070159C4F6422D39F4135C00F6BC", hash_generated_field = "A21A7EFBC48A7EE5E4832E43F9767035")

    public static final int ALL_SAVE_FLAG = 0x1F;
    
}

