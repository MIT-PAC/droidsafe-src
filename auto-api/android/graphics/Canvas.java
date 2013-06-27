package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import javax.microedition.khronos.opengles.GL;

public class Canvas {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.502 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "9AEAAB458F04AA015A1FEC7988D58EFD")

    int mNativeCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.502 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

    private Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.502 -0400", hash_original_field = "33EC7BAD3C77F28DF4CAC7D27FF9F413", hash_generated_field = "31D717B55AEC45D08AFE5E2055099FE3")

    private DrawFilter mDrawFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.503 -0400", hash_original_field = "374AD1D5FABD7F0924F98F93B66480BB", hash_generated_field = "26A3C4D459B626187E0E8706060CBC58")

    protected int mDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.503 -0400", hash_original_field = "3C7272D39DFDF8BA7BC8BAE70278C78B", hash_generated_field = "B3B96B83CBF6A474ACFDE54DAF7E8D5B")

    protected int mScreenDensity = Bitmap.DENSITY_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.503 -0400", hash_original_field = "D2E79E153A2C7AD6C353ED3C0C4AF8B9", hash_generated_field = "5A79E0455BB83A8F5930E665EB36A02A")

    @SuppressWarnings({"UnusedDeclaration"}) private int mSurfaceFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.503 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D26BA3C2A6930E011E689CD349B6702B")

    @SuppressWarnings({"UnusedDeclaration"}) private CanvasFinalizer mFinalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.521 -0400", hash_original_method = "1267A44EC7BCBF8838C9761711C37259", hash_generated_method = "63552CAA2E9C15316003F51321B1A087")
    public  Canvas() {
        mNativeCanvas = initRaster(0);
        mFinalizer = new CanvasFinalizer(mNativeCanvas);
        // ---------- Original Method ----------
        //mNativeCanvas = initRaster(0);
        //mFinalizer = new CanvasFinalizer(mNativeCanvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.523 -0400", hash_original_method = "57E1F1C357DC29B7A94C226F5C3B5C9B", hash_generated_method = "6F7D2C3581D7E3273B6A76ACBF78F8D1")
    public  Canvas(Bitmap bitmap) {
        {
            boolean var6BA398A25C0007F3F9E60F39C57A8340_272084283 = (!bitmap.isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Immutable bitmap passed to Canvas constructor");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.549 -0400", hash_original_method = "347D84319548CC8FC9B392FE55B81BD9", hash_generated_method = "FC9F47ED0B823D4E3B524ADFDE4768CF")
      Canvas(int nativeCanvas) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.551 -0400", hash_original_method = "B940DF21824B9124E6B753106E553281", hash_generated_method = "10F7E1C1DDFC6FC56134EB48E93461A9")
    @Deprecated
    protected GL getGL() {
        GL varB4EAC82CA7396A68D541C85D26508E83_1922912308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1922912308 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1922912308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1922912308;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.551 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "30B010DE4C0E9CE313D26A0470EE21C3")
    public boolean isHardwareAccelerated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617230216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_617230216;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.589 -0400", hash_original_method = "F6F982BDFE8AA5C0E01EE9F2D9165328", hash_generated_method = "B177DA9ED72B2B4E9DDEA8D84AA8EA9C")
    public void setBitmap(Bitmap bitmap) {
        {
            boolean varBDA84146B1D9E3F7F12351B38C986FB8_1068367896 = (isHardwareAccelerated());
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Can't set a bitmap device on a GL canvas");
            } //End block
        } //End collapsed parenthetic
        int pointer;
        pointer = 0;
        {
            {
                boolean varF12BF886E543DD07B8FC1D7A55B10614_107142110 = (!bitmap.isMutable());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.590 -0400", hash_original_method = "85F5D8C713E0C3D78EE01CE144D393CD", hash_generated_method = "7E1F363915FA95C976FBC3F8007059F4")
    public void setViewport(int width, int height) {
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.590 -0400", hash_original_method = "9A759A0D04375324D8F6D99375FF174F", hash_generated_method = "300B286AAC93FC499639EE8BC2CE2BCA")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259745478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259745478;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.591 -0400", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "5E66B3DFB724DD690F942C68A06C7496")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498858134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498858134;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.591 -0400", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "B7D14B59D73E41019B5B3A02C7605877")
    public int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703893472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703893472;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.619 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "52CF35133A8AAC07EFBBB5C7F3D9AB30")
    public int getDensity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414398252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414398252;
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.620 -0400", hash_original_method = "67C9034FA61967648F2458A8FB5F781D", hash_generated_method = "688E20CFFBAB10F58473DF356BBCFE25")
    public void setDensity(int density) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.620 -0400", hash_original_method = "097B83D968163B69D9FD944A715444E1", hash_generated_method = "A6B4CCAC527ADCBCA2970ADC88659071")
    public void setScreenDensity(int density) {
        mScreenDensity = density;
        // ---------- Original Method ----------
        //mScreenDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.621 -0400", hash_original_method = "E7FD28619D99C67895E6B54C83B12011", hash_generated_method = "61743ACEFD96B28F3ABE5E50211023BC")
    public int getMaximumBitmapWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5809929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5809929;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.647 -0400", hash_original_method = "F4D5E7FCD71CC06030F3DF600D5A4E91", hash_generated_method = "AE09E3B33023F233275AA4B0ED3FE008")
    public int getMaximumBitmapHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627671553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627671553;
        // ---------- Original Method ----------
        //return MAXMIMUM_BITMAP_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.648 -0400", hash_original_method = "F3B8683979D1D489E213BCC22FA3BBF8", hash_generated_method = "86575B58A7DE1713DF4F2ED4F2EA78A3")
    public int save() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994420815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994420815;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.648 -0400", hash_original_method = "B3EA192DB08CDE7F222599E8EB46FFD6", hash_generated_method = "90523267DDC499925DF9A63E790AC099")
    public int save(int saveFlags) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617616600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617616600;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.649 -0400", hash_original_method = "D3E38B54874BE956E1980D322B5BE510", hash_generated_method = "5C93DBAC78EC2970916ABCC7D3B6C4A6")
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        int varA5CBFDE30BD9450F18C791C44EFCC5C7_2136301874 = (native_saveLayer(mNativeCanvas, bounds,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(bounds.getTaint());
        addTaint(paint.getTaint());
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297480996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1297480996;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, bounds,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.680 -0400", hash_original_method = "E5CA8AFF181BF9AD7711CB91FDA3487A", hash_generated_method = "9C060F40B010B6B8FF037076CB16D4CE")
    public int saveLayer(float left, float top, float right, float bottom,
                         Paint paint, int saveFlags) {
        int var2F61FD39EB631471B29C425EFBBF4F51_664570880 = (native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                paint != null ? paint.mNativePaint : 0,
                                saveFlags)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(paint.getTaint());
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859890689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859890689;
        // ---------- Original Method ----------
        //return native_saveLayer(mNativeCanvas, left, top, right, bottom,
                                //paint != null ? paint.mNativePaint : 0,
                                //saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.681 -0400", hash_original_method = "11712C48B70E4A29EC050275E8757D6B", hash_generated_method = "2AB12DCCBF56730B6E510935A80BCAB6")
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        alpha = Math.min(255, Math.max(0, alpha));
        int varB81B6263C9EA4136F5F2163CAACF155C_139917966 = (native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags));
        addTaint(bounds.getTaint());
        addTaint(alpha);
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231759973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231759973;
        // ---------- Original Method ----------
        //alpha = Math.min(255, Math.max(0, alpha));
        //return native_saveLayerAlpha(mNativeCanvas, bounds, alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.682 -0400", hash_original_method = "1E17DC2ECF868A450BC9B6F62927FD6A", hash_generated_method = "BAFCD9C6D9E291EADE2638187E16E807")
    public int saveLayerAlpha(float left, float top, float right, float bottom,
                              int alpha, int saveFlags) {
        int varAB13D3D6A85F702363B4C10CC58EB5DE_1527862983 = (native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     alpha, saveFlags));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(alpha);
        addTaint(saveFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204724035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204724035;
        // ---------- Original Method ----------
        //return native_saveLayerAlpha(mNativeCanvas, left, top, right, bottom,
                                     //alpha, saveFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.683 -0400", hash_original_method = "54E49D501AAC4DB03DE41A5BADEC9468", hash_generated_method = "17FCF523146E8D711A132189A0FA7A41")
    public void restore() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.683 -0400", hash_original_method = "C157B89F0FBAFE11C45EBC10DA0B6D3E", hash_generated_method = "81293DA0809BF602D2E9126F3585DE94")
    public int getSaveCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464943279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464943279;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.727 -0400", hash_original_method = "5559D0B771CBEE6A1A38BCD3A9AC5162", hash_generated_method = "974A4A0419CFC80E5DCE3A10E5A44569")
    public void restoreToCount(int saveCount) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.727 -0400", hash_original_method = "D7EAFB33E67C35A487FB9FDA7236DB5C", hash_generated_method = "D0B6F0A9E05AD23474AA3F4EC0F3A5D4")
    public void translate(float dx, float dy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.728 -0400", hash_original_method = "914C0B0C62A552CD356908505BF7E530", hash_generated_method = "C80939F3E48B9985ED6CECC4D208910C")
    public void scale(float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.728 -0400", hash_original_method = "FBE272FA12218448E57FDD0F51163D2E", hash_generated_method = "37D65165CCFE0D8572091320C5FEC8CA")
    public final void scale(float sx, float sy, float px, float py) {
        translate(px, py);
        scale(sx, sy);
        translate(-px, -py);
        addTaint(sx);
        addTaint(sy);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //translate(px, py);
        //scale(sx, sy);
        //translate(-px, -py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.729 -0400", hash_original_method = "3293BC510D2403D70370080BC137D04A", hash_generated_method = "538AEF3060A20505833F455ADFC3A525")
    public void rotate(float degrees) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.729 -0400", hash_original_method = "96E9024A0524487F4C2E52375F89DAF2", hash_generated_method = "683CDB0A97BFAEC9B7E888189B964E97")
    public final void rotate(float degrees, float px, float py) {
        translate(px, py);
        rotate(degrees);
        translate(-px, -py);
        addTaint(degrees);
        addTaint(px);
        addTaint(py);
        // ---------- Original Method ----------
        //translate(px, py);
        //rotate(degrees);
        //translate(-px, -py);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.730 -0400", hash_original_method = "89B271C0116BA22E329740125333F5A7", hash_generated_method = "8C9F38F6D7E6C080ECF146BE9233FC5D")
    public void skew(float sx, float sy) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.730 -0400", hash_original_method = "92F93C7D2AC41CA3F3A5613FB52C686A", hash_generated_method = "EB597E9BD6D5D83E7BAECB18C7BD8078")
    public void concat(Matrix matrix) {
        native_concat(mNativeCanvas, matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //native_concat(mNativeCanvas, matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.731 -0400", hash_original_method = "ABA89A91C9E394A5196A87FF36F2A069", hash_generated_method = "CF91DEE0319445327BD8855B7FCA1DE8")
    public void setMatrix(Matrix matrix) {
        native_setMatrix(mNativeCanvas,
                         matrix == null ? 0 : matrix.native_instance);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //native_setMatrix(mNativeCanvas,
                         //matrix == null ? 0 : matrix.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.731 -0400", hash_original_method = "43D0B837CD75E40B4AB1C87B7D03A6CC", hash_generated_method = "F52DA59BCA1B56749EF0BBA5C09C6EC4")
    public void getMatrix(Matrix ctm) {
        native_getCTM(mNativeCanvas, ctm.native_instance);
        addTaint(ctm.getTaint());
        // ---------- Original Method ----------
        //native_getCTM(mNativeCanvas, ctm.native_instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.749 -0400", hash_original_method = "677F0589CC9DCD49ED4AD9753284FD1D", hash_generated_method = "22C1DDEAE0F4DA5834772AE29CAB45FE")
    public final Matrix getMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_442946861 = null; //Variable for return #1
        Matrix m;
        m = new Matrix();
        getMatrix(m);
        varB4EAC82CA7396A68D541C85D26508E83_442946861 = m;
        varB4EAC82CA7396A68D541C85D26508E83_442946861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_442946861;
        // ---------- Original Method ----------
        //Matrix m = new Matrix();
        //getMatrix(m);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.753 -0400", hash_original_method = "ADF2B4EDD750040189755D8AA2B089F0", hash_generated_method = "0725D79D066050682FE83A934D7702FF")
    public boolean clipRect(RectF rect, Region.Op op) {
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_26540069 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736700020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736700020;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.764 -0400", hash_original_method = "C0255CEC0BCD1AD46E1B4E180BE74E1B", hash_generated_method = "4C5CB386581FC74B0D0CD64502C3277B")
    public boolean clipRect(Rect rect, Region.Op op) {
        boolean varAC47F037A127A32BF1967A9F17C8D6EE_273938798 = (native_clipRect(mNativeCanvas,
                               rect.left, rect.top, rect.right, rect.bottom,
                               op.nativeInt));
        addTaint(rect.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080644277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080644277;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas,
                               //rect.left, rect.top, rect.right, rect.bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.765 -0400", hash_original_method = "830DBE6B0CD66B7FB13D1DDCBCB1919D", hash_generated_method = "96AD42011741627D772DB9D3D08AF3AE")
    public boolean clipRect(RectF rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792377547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_792377547;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.766 -0400", hash_original_method = "85C29845972840A2A78B8F138670556A", hash_generated_method = "A65E349564E1BDFCD8E5C4EC6CB31FC6")
    public boolean clipRect(Rect rect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258064453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258064453;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.769 -0400", hash_original_method = "1DF6FF81DFB932BE2B5849557766481E", hash_generated_method = "131C8339A1584ED4BFF7E83DE5DE7164")
    public boolean clipRect(float left, float top, float right, float bottom,
                            Region.Op op) {
        boolean varEE9DF9D2FD21703C87AA172F004D9785_1955512022 = (native_clipRect(mNativeCanvas, left, top, right, bottom,
                               op.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803599948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803599948;
        // ---------- Original Method ----------
        //return native_clipRect(mNativeCanvas, left, top, right, bottom,
                               //op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.769 -0400", hash_original_method = "1121260B2872F4C8288BF6DC851005F3", hash_generated_method = "A01705612AC50B8C6A503322CBF1494B")
    public boolean clipRect(float left, float top,
                                   float right, float bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781777915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781777915;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.774 -0400", hash_original_method = "C42EF88CC3B7717E7A29DDD6EED6CD2B", hash_generated_method = "2833B269A53D2741449F3540E95FE42E")
    public boolean clipRect(int left, int top,
                                   int right, int bottom) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272910012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272910012;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.785 -0400", hash_original_method = "7A7DE76338CD4FF5C3A48558D2B4614E", hash_generated_method = "45D855F8BBED907B9EFED4F00A91ADB2")
    public boolean clipPath(Path path, Region.Op op) {
        boolean var3967E0369498EDA77CDA505C721131EC_1274052773 = (native_clipPath(mNativeCanvas, path.ni(), op.nativeInt));
        addTaint(path.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153480742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153480742;
        // ---------- Original Method ----------
        //return native_clipPath(mNativeCanvas, path.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.786 -0400", hash_original_method = "1145BB7612B8DCB4209865A3916D22D3", hash_generated_method = "D83B7863BB10F28CDBFE9DB548CD6A0A")
    public boolean clipPath(Path path) {
        boolean var5668FEC2CC06DA8D3911368F8A48CE68_79685415 = (clipPath(path, Region.Op.INTERSECT));
        addTaint(path.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890836259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890836259;
        // ---------- Original Method ----------
        //return clipPath(path, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.790 -0400", hash_original_method = "28C7C5FF233FA752A95A4980EB733491", hash_generated_method = "ACA906952DDABBC3FB7DBF6386660E87")
    public boolean clipRegion(Region region, Region.Op op) {
        boolean var670725A52E9FB351AE9F8E165F40703A_1808710898 = (native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt));
        addTaint(region.getTaint());
        addTaint(op.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490984708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490984708;
        // ---------- Original Method ----------
        //return native_clipRegion(mNativeCanvas, region.ni(), op.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.791 -0400", hash_original_method = "DB214CB3316FBBF79B84FF393892AF1F", hash_generated_method = "F51129986734A2F9B2DFA179B2F92498")
    public boolean clipRegion(Region region) {
        boolean varEC420F7490712C49934D9178B28B2A4A_972287153 = (clipRegion(region, Region.Op.INTERSECT));
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750575330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750575330;
        // ---------- Original Method ----------
        //return clipRegion(region, Region.Op.INTERSECT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.806 -0400", hash_original_method = "7CFD876AAFB864AD7FF69DF25AA89EAD", hash_generated_method = "60D5197FE19D5C4E72A491F90A6877C6")
    public DrawFilter getDrawFilter() {
        DrawFilter varB4EAC82CA7396A68D541C85D26508E83_1230404108 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230404108 = mDrawFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1230404108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230404108;
        // ---------- Original Method ----------
        //return mDrawFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.808 -0400", hash_original_method = "68F6BB80C574F9A67A1BF360B92238CB", hash_generated_method = "D04D4A95F383CD63F0DC1FC03A086B6D")
    public void setDrawFilter(DrawFilter filter) {
        int nativeFilter;
        nativeFilter = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.809 -0400", hash_original_method = "6593DA2291538241F61FD613E7FE6D5B", hash_generated_method = "8F9198AC3DF88EBC751B22CA07953DA5")
    public boolean quickReject(RectF rect, EdgeType type) {
        boolean var429A74CF4AF210076B3239D74D69786D_1702135191 = (native_quickReject(mNativeCanvas, rect, type.nativeInt));
        addTaint(rect.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516057820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516057820;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, rect, type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.822 -0400", hash_original_method = "1B5471D21BEA46C8ED1B36EA429F046B", hash_generated_method = "AD9E8DD0FA01A00C1E1BEF5B9A6F94EB")
    public boolean quickReject(Path path, EdgeType type) {
        boolean varB3A55B701382D522818E598BFA909059_1968041451 = (native_quickReject(mNativeCanvas, path.ni(), type.nativeInt));
        addTaint(path.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688652764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688652764;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, path.ni(), type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.824 -0400", hash_original_method = "A8D2AD12ACC5E410C736D30130C20B13", hash_generated_method = "2C6EE6BF4805FE0C7E41D777B1B55DE9")
    public boolean quickReject(float left, float top, float right, float bottom,
                               EdgeType type) {
        boolean varDB574CFEBFF126B7D24F9B2C2E4668CF_1361799177 = (native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  type.nativeInt));
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039455255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039455255;
        // ---------- Original Method ----------
        //return native_quickReject(mNativeCanvas, left, top, right, bottom,
                                  //type.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.824 -0400", hash_original_method = "C4C8EDF474744387A03BAF2FCA9EC7E1", hash_generated_method = "73D812B1A2707680758BE1507588AE9C")
    public boolean getClipBounds(Rect bounds) {
        boolean var817922B6BDA738AD08E140FF68D83598_2113879465 = (native_getClipBounds(mNativeCanvas, bounds));
        addTaint(bounds.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235434180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235434180;
        // ---------- Original Method ----------
        //return native_getClipBounds(mNativeCanvas, bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.830 -0400", hash_original_method = "081EA481AF3998560C2A7BDAF7DC2D73", hash_generated_method = "6E986C167325FDFDC0771246D72D9A70")
    public final Rect getClipBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1870448934 = null; //Variable for return #1
        Rect r;
        r = new Rect();
        getClipBounds(r);
        varB4EAC82CA7396A68D541C85D26508E83_1870448934 = r;
        varB4EAC82CA7396A68D541C85D26508E83_1870448934.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870448934;
        // ---------- Original Method ----------
        //Rect r = new Rect();
        //getClipBounds(r);
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.835 -0400", hash_original_method = "512FC5029F1C2BD4A7A7DEBEE6E3C841", hash_generated_method = "E801416B62B290E45235BE390EC13C43")
    public void drawRGB(int r, int g, int b) {
        native_drawRGB(mNativeCanvas, r, g, b);
        addTaint(r);
        addTaint(g);
        addTaint(b);
        // ---------- Original Method ----------
        //native_drawRGB(mNativeCanvas, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.839 -0400", hash_original_method = "9BFD91E842A11577904B0CB6F2A3F2B4", hash_generated_method = "464285DDC9CEF38D91810DA38F154B33")
    public void drawARGB(int a, int r, int g, int b) {
        native_drawARGB(mNativeCanvas, a, r, g, b);
        addTaint(a);
        addTaint(r);
        addTaint(g);
        addTaint(b);
        // ---------- Original Method ----------
        //native_drawARGB(mNativeCanvas, a, r, g, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.839 -0400", hash_original_method = "BF5E846D1EF3BCCEA205827104DDB3E8", hash_generated_method = "993DC51DCBD7D29AF03774D4A8401A39")
    public void drawColor(int color) {
        native_drawColor(mNativeCanvas, color);
        addTaint(color);
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.846 -0400", hash_original_method = "4AB8965ACD48B286E6BCF28D614F6B00", hash_generated_method = "52C3B6FDF011A048C52AFFCD6D3279AD")
    public void drawColor(int color, PorterDuff.Mode mode) {
        native_drawColor(mNativeCanvas, color, mode.nativeInt);
        addTaint(color);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //native_drawColor(mNativeCanvas, color, mode.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.847 -0400", hash_original_method = "774CA3D90C36917005A085F0E322036A", hash_generated_method = "960D19FE8C311E69F5CF277E4E308A97")
    public void drawPaint(Paint paint) {
        native_drawPaint(mNativeCanvas, paint.mNativePaint);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawPaint(mNativeCanvas, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.847 -0400", hash_original_method = "A7026FD3DE10525F382BCFDA63577851", hash_generated_method = "6FF2BCA7A4B0B8AB911130468726B5DA")
    public void drawPoints(float[] pts, int offset, int count,
                                  Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.860 -0400", hash_original_method = "929DA853C72DCA36C1C2D5AEB0F0EEC1", hash_generated_method = "FDDFB451709B85185722E880B08A03DE")
    public void drawPoints(float[] pts, Paint paint) {
        drawPoints(pts, 0, pts.length, paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawPoints(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.861 -0400", hash_original_method = "09F3146190FEA35181D8E9A65B708145", hash_generated_method = "CC1E903F166689821C3A24C5F449BF0F")
    public void drawPoint(float x, float y, Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.862 -0400", hash_original_method = "B6DC8903FDEE452D685FA44296B398E4", hash_generated_method = "5167A8AEE4FCFB8B38C2049C02EDBE03")
    public void drawLine(float startX, float startY, float stopX, float stopY,
                         Paint paint) {
        native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        paint.mNativePaint);
        addTaint(startX);
        addTaint(startY);
        addTaint(stopX);
        addTaint(stopY);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.862 -0400", hash_original_method = "5A8D10A468DAF40C9664F83218CAE45B", hash_generated_method = "BC11F5ED395D07C9E16C7DC1EBD0C9F8")
    public void drawLines(float[] pts, int offset, int count,
                                 Paint paint) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.862 -0400", hash_original_method = "C2DF9F5B70F03E16002905BD3365AB2E", hash_generated_method = "948CC0AF99C144CA637D86455027526E")
    public void drawLines(float[] pts, Paint paint) {
        drawLines(pts, 0, pts.length, paint);
        addTaint(pts[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawLines(pts, 0, pts.length, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.863 -0400", hash_original_method = "890D392C9C1E85BE5BBE5EB943FF6481", hash_generated_method = "75B40F341DBAABF3C79C79D828A9036B")
    public void drawRect(RectF rect, Paint paint) {
        native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
        addTaint(rect.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, rect, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.867 -0400", hash_original_method = "9CB801DBEAF645326E64FD8725588653", hash_generated_method = "FA5E813207BF7E034D006B42B99B9EDA")
    public void drawRect(Rect r, Paint paint) {
        drawRect(r.left, r.top, r.right, r.bottom, paint);
        addTaint(r.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //drawRect(r.left, r.top, r.right, r.bottom, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.868 -0400", hash_original_method = "CDE86729C0DE5B687E9F3D6C62C89CBA", hash_generated_method = "F657A8C85B064D648BFAC6732A24C0B2")
    public void drawRect(float left, float top, float right, float bottom,
                         Paint paint) {
        native_drawRect(mNativeCanvas, left, top, right, bottom,
                        paint.mNativePaint);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawRect(mNativeCanvas, left, top, right, bottom,
                        //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.868 -0400", hash_original_method = "68242662823845D3936295A7CE4E7BEF", hash_generated_method = "DBDA9536099B9A60ABBD934ABA689F9F")
    public void drawOval(RectF oval, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
        addTaint(oval.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawOval(mNativeCanvas, oval, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.883 -0400", hash_original_method = "6EC335AEB28EA1E608617532103E031D", hash_generated_method = "81D42163DBEDCA820B9261D1C5C4D7CD")
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        native_drawCircle(mNativeCanvas, cx, cy, radius,
                          paint.mNativePaint);
        addTaint(cx);
        addTaint(cy);
        addTaint(radius);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawCircle(mNativeCanvas, cx, cy, radius,
                          //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.884 -0400", hash_original_method = "5411F007DFA413B9921CB5C131E7CB3B", hash_generated_method = "9387B0579C31E01BF8D0DBA04CB8C48B")
    public void drawArc(RectF oval, float startAngle, float sweepAngle,
                        boolean useCenter, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       useCenter, paint.mNativePaint);
        addTaint(oval.getTaint());
        addTaint(startAngle);
        addTaint(sweepAngle);
        addTaint(useCenter);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (oval == null) {
            //throw new NullPointerException();
        //}
        //native_drawArc(mNativeCanvas, oval, startAngle, sweepAngle,
                       //useCenter, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.885 -0400", hash_original_method = "41C1A121517CD12760C521BBD9AF1967", hash_generated_method = "9A06BD928854EDFCC40464703ADA1B81")
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             paint.mNativePaint);
        addTaint(rect.getTaint());
        addTaint(rx);
        addTaint(ry);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (rect == null) {
            //throw new NullPointerException();
        //}
        //native_drawRoundRect(mNativeCanvas, rect, rx, ry,
                             //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.885 -0400", hash_original_method = "0771B06A5DB79DCDA48BD1ADBD491833", hash_generated_method = "C3D8CE8FA013DB27B5FC5BFA5BD1AD44")
    public void drawPath(Path path, Paint paint) {
        native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
        addTaint(path.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawPath(mNativeCanvas, path.ni(), paint.mNativePaint);
    }

    
        private static void throwIfRecycled(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException(
                        "Canvas: trying to use a recycled bitmap " + bitmap);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.900 -0400", hash_original_method = "ED4DAC4BAED1A32A3D194D286EE0C9BC", hash_generated_method = "308F398101DCC2B26BEFED36B48C2FF5")
    public void drawPatch(Bitmap bitmap, byte[] chunks, RectF dst, Paint paint) {
        addTaint(bitmap.getTaint());
        addTaint(chunks[0]);
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.902 -0400", hash_original_method = "31B292C5F0F5731C1C9071C226236EDA", hash_generated_method = "38CFCE49838BBA233C940D18EECE5BFF")
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                bitmap.mDensity);
        addTaint(bitmap.getTaint());
        addTaint(left);
        addTaint(top);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), left, top,
                //paint != null ? paint.mNativePaint : 0, mDensity, mScreenDensity,
                //bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.903 -0400", hash_original_method = "C948472D99C8DCD49BAB1292EF9A789B", hash_generated_method = "A11FF561B30617AA57B9B653E9E03986")
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.905 -0400", hash_original_method = "841672D97CF75C5F24DD91219B8271EA", hash_generated_method = "7D693BD6299EB63587FDFECFD9B896CF")
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        throwIfRecycled(bitmap);
        native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          paint != null ? paint.mNativePaint : 0,
                          mScreenDensity, bitmap.mDensity);
        addTaint(bitmap.getTaint());
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (dst == null) {
            //throw new NullPointerException();
        //}
        //throwIfRecycled(bitmap);
        //native_drawBitmap(mNativeCanvas, bitmap.ni(), src, dst,
                          //paint != null ? paint.mNativePaint : 0,
                          //mScreenDensity, bitmap.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.931 -0400", hash_original_method = "16007B10D324732000F0755E804F2C6B", hash_generated_method = "ACC352C678F20C3E23193AEC511CA803")
    public void drawBitmap(int[] colors, int offset, int stride, float x,
                           float y, int width, int height, boolean hasAlpha,
                           Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("width must be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_1501620418 = (Math.abs(stride) < width);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("abs(stride) must be >= width");
            } //End block
        } //End collapsed parenthetic
        int lastScanline;
        lastScanline = offset + (height - 1) * stride;
        int length;
        length = colors.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_drawBitmap(mNativeCanvas, colors, offset, stride, x, y, width, height, hasAlpha,
                paint != null ? paint.mNativePaint : 0);
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
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.937 -0400", hash_original_method = "1DECC82647C03783DFB70A54A4715DCA", hash_generated_method = "44B44EB9CAEE9A0A7DD177556159BEB6")
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y,
                           int width, int height, boolean hasAlpha,
                           Paint paint) {
        drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   hasAlpha, paint);
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
        //drawBitmap(colors, offset, stride, (float)x, (float)y, width, height,
                   //hasAlpha, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.937 -0400", hash_original_method = "EB6FF8B38000E2AA8E5468782EF53260", hash_generated_method = "8D366D90312963AD200241CE0567F9D9")
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                paint != null ? paint.mNativePaint : 0);
        addTaint(bitmap.getTaint());
        addTaint(matrix.getTaint());
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //nativeDrawBitmapMatrix(mNativeCanvas, bitmap.ni(), matrix.ni(),
                //paint != null ? paint.mNativePaint : 0);
    }

    
        protected static void checkRange(int length, int offset, int count) {
        if ((offset | count) < 0 || offset + count > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.940 -0400", hash_original_method = "014BBC0AF3F984A031B4F01243EED110", hash_generated_method = "A1B1D889D47B995EE51E2F4EE7671C05")
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight,
                               float[] verts, int vertOffset,
                               int[] colors, int colorOffset, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        int count;
        count = (meshWidth + 1) * (meshHeight + 1);
        checkRange(verts.length, vertOffset, count * 2);
        {
            checkRange(colors.length, colorOffset, count);
        } //End block
        nativeDrawBitmapMesh(mNativeCanvas, bitmap.ni(), meshWidth, meshHeight,
                             verts, vertOffset, colors, colorOffset,
                             paint != null ? paint.mNativePaint : 0);
        addTaint(bitmap.getTaint());
        addTaint(meshWidth);
        addTaint(meshHeight);
        addTaint(verts[0]);
        addTaint(vertOffset);
        addTaint(colors[0]);
        addTaint(colorOffset);
        addTaint(paint.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.950 -0400", hash_original_method = "DF78170F74F7916B8CA044C6FA0E7706", hash_generated_method = "848F7029EE3ED7238974B3B52E79E378")
    public void drawVertices(VertexMode mode, int vertexCount,
                             float[] verts, int vertOffset,
                             float[] texs, int texOffset,
                             int[] colors, int colorOffset,
                             short[] indices, int indexOffset,
                             int indexCount, Paint paint) {
        checkRange(verts.length, vertOffset, vertexCount);
        {
            checkRange(texs.length, texOffset, vertexCount);
        } //End block
        {
            checkRange(colors.length, colorOffset, vertexCount / 2);
        } //End block
        {
            checkRange(indices.length, indexOffset, indexCount);
        } //End block
        nativeDrawVertices(mNativeCanvas, mode.nativeInt, vertexCount, verts,
                           vertOffset, texs, texOffset, colors, colorOffset,
                          indices, indexOffset, indexCount, paint.mNativePaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.962 -0400", hash_original_method = "B53D951EA30645908EAA0D773F3CD0B1", hash_generated_method = "4756EE29ECB2745262CFB9BC8B4F7003")
    public void drawText(char[] text, int index, int count, float x, float y,
                         Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((index | count | (index + count) |
            //(text.length - index - count)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, index, count, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.962 -0400", hash_original_method = "5AF5477506B1C1EE3856DD0F624B5874", hash_generated_method = "FD5A708E3C2E7608EC5B63B0D061BAD2")
    public void drawText(String text, float x, float y, Paint paint) {
        native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                paint.mNativePaint);
        addTaint(text.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //native_drawText(mNativeCanvas, text, 0, text.length(), x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.964 -0400", hash_original_method = "6829DC946932105C9401F9B35E7B6F88", hash_generated_method = "5EACB688696E2373A3C06A1F9F3D9AB7")
    public void drawText(String text, int start, int end, float x, float y,
                         Paint paint) {
        {
            boolean var9527A5CDD965760192A60A252272F336_1375236280 = ((start | end | (end - start) | (text.length() - end)) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                paint.mNativePaint);
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if ((start | end | (end - start) | (text.length() - end)) < 0) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawText(mNativeCanvas, text, start, end, x, y, paint.mBidiFlags,
                //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.980 -0400", hash_original_method = "6FEFF94D9E21F991F21729F6F5F461A6", hash_generated_method = "2353272B345D49B33A3550DAF78F48B9")
    public void drawText(CharSequence text, int start, int end, float x,
                         float y, Paint paint) {
        {
            native_drawText(mNativeCanvas, text.toString(), start, end, x, y,
                            paint.mBidiFlags, paint.mNativePaint);
        } //End block
        {
            ((GraphicsOperations) text).drawText(this, start, end, x, y,
                                                     paint);
        } //End block
        {
            char[] buf;
            buf = TemporaryBuffer.obtain(end - start);
            TextUtils.getChars(text, start, end, buf, 0);
            native_drawText(mNativeCanvas, buf, 0, end - start, x, y,
                    paint.mBidiFlags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
        addTaint(text.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(x);
        addTaint(y);
        addTaint(paint.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.993 -0400", hash_original_method = "6EBE295547BE775A36E1A6AF2206E2F5", hash_generated_method = "A8C19B1F3A1B082F176887B89299977E")
    public void drawTextRun(char[] text, int index, int count,
            int contextIndex, int contextCount, float x, float y, int dir,
            Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("paint is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown dir: " + dir);
        } //End block
        native_drawTextRun(mNativeCanvas, text, index, count,
                contextIndex, contextCount, x, y, dir, paint.mNativePaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.997 -0400", hash_original_method = "92F46C968D6DA82FFBC09248C72F0C8C", hash_generated_method = "87C37851EF588D3907EBDD2172A77505")
    public void drawTextRun(CharSequence text, int start, int end,
            int contextStart, int contextEnd, float x, float y, int dir,
            Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("text is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("paint is null");
        } //End block
        {
            boolean var5121ADA1DFFE288F77E0A77339FFD85F_1218085244 = ((start | end | end - start | text.length() - end) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int flags;
        flags = 0;
        flags = 1;
        {
            native_drawTextRun(mNativeCanvas, text.toString(), start, end,
                    contextStart, contextEnd, x, y, flags, paint.mNativePaint);
        } //End block
        {
            ((GraphicsOperations) text).drawTextRun(this, start, end,
                    contextStart, contextEnd, x, y, flags, paint);
        } //End block
        {
            int contextLen;
            contextLen = contextEnd - contextStart;
            int len;
            len = end - start;
            char[] buf;
            buf = TemporaryBuffer.obtain(contextLen);
            TextUtils.getChars(text, contextStart, contextEnd, buf, 0);
            native_drawTextRun(mNativeCanvas, buf, start - contextStart, len,
                    0, contextLen, x, y, flags, paint.mNativePaint);
            TemporaryBuffer.recycle(buf);
        } //End block
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
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.016 -0400", hash_original_method = "85C4F370BE8714F2CD7DF24F138664E0", hash_generated_method = "58ABD5F72E95D27EE9061176216892CD")
    public void drawPosText(char[] text, int index, int count, float[] pos,
                            Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        native_drawPosText(mNativeCanvas, text, index, count, pos,
                           paint.mNativePaint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length || count*2 > pos.length) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, index, count, pos,
                           //paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.017 -0400", hash_original_method = "887F094692FA72239FA373420B7D2404", hash_generated_method = "2C523592CE2C2C7F1CD2430DD485655F")
    public void drawPosText(String text, float[] pos, Paint paint) {
        {
            boolean var8252BA30A9512CA9A5F07EEE6666D9DD_130907321 = (text.length()*2 > pos.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
        addTaint(text.getTaint());
        addTaint(pos[0]);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (text.length()*2 > pos.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawPosText(mNativeCanvas, text, pos, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.018 -0400", hash_original_method = "34245E42F942570AFBDEF6E2A30FB787", hash_generated_method = "19E20A3DE8CDC72A400D04573A16ED5C")
    public void drawTextOnPath(char[] text, int index, int count, Path path,
                               float hOffset, float vOffset, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        native_drawTextOnPath(mNativeCanvas, text, index, count,
                              path.ni(), hOffset, vOffset,
                              paint.mBidiFlags, paint.mNativePaint);
        addTaint(text[0]);
        addTaint(index);
        addTaint(count);
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (index < 0 || index + count > text.length) {
            //throw new ArrayIndexOutOfBoundsException();
        //}
        //native_drawTextOnPath(mNativeCanvas, text, index, count,
                              //path.ni(), hOffset, vOffset,
                              //paint.mBidiFlags, paint.mNativePaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.019 -0400", hash_original_method = "BBB121FCAE128F1EC35D041163A72498", hash_generated_method = "63B8D7ED7BD03D7F8F855B027F604983")
    public void drawTextOnPath(String text, Path path, float hOffset,
                               float vOffset, Paint paint) {
        {
            boolean varC763452D8A14BA9A46AF46F7BF99B944_1594413803 = (text.length() > 0);
            {
                native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  hOffset, vOffset, paint.mBidiFlags,
                                  paint.mNativePaint);
            } //End block
        } //End collapsed parenthetic
        addTaint(text.getTaint());
        addTaint(path.getTaint());
        addTaint(hOffset);
        addTaint(vOffset);
        addTaint(paint.getTaint());
        // ---------- Original Method ----------
        //if (text.length() > 0) {
            //native_drawTextOnPath(mNativeCanvas, text, path.ni(),
                                  //hOffset, vOffset, paint.mBidiFlags,
                                  //paint.mNativePaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.031 -0400", hash_original_method = "DAACDF6D023CC31453619FC0BE061518", hash_generated_method = "6AF143BD685A1D0FABD7AA160263197A")
    public void drawPicture(Picture picture) {
        picture.endRecording();
        native_drawPicture(mNativeCanvas, picture.ni());
        addTaint(picture.getTaint());
        // ---------- Original Method ----------
        //picture.endRecording();
        //native_drawPicture(mNativeCanvas, picture.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.032 -0400", hash_original_method = "9A4AF54B94158E3C4DCFADF51FCAADD5", hash_generated_method = "63CDCD2AA05C157CD46EA372AA28A6CE")
    public void drawPicture(Picture picture, RectF dst) {
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_1238659311 = (picture.getWidth() > 0 && picture.getHeight() > 0);
            {
                scale(dst.width() / picture.getWidth(),
                  dst.height() / picture.getHeight());
            } //End block
        } //End collapsed parenthetic
        drawPicture(picture);
        restore();
        addTaint(picture.getTaint());
        addTaint(dst.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.043 -0400", hash_original_method = "A0088B5FD0255BCF9789E7655D1F3782", hash_generated_method = "0DFD004F3D4B0D96C2AD5B8FE2945E7F")
    public void drawPicture(Picture picture, Rect dst) {
        save();
        translate(dst.left, dst.top);
        {
            boolean var2F17974692B446CCF5B17AF0A40BCC63_288045959 = (picture.getWidth() > 0 && picture.getHeight() > 0);
            {
                scale((float)dst.width() / picture.getWidth(),
                  (float)dst.height() / picture.getHeight());
            } //End block
        } //End collapsed parenthetic
        drawPicture(picture);
        restore();
        addTaint(picture.getTaint());
        addTaint(dst.getTaint());
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
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_setBitmap(int nativeCanvas, int bitmap) {
    }

    
        private static int native_saveLayer(int nativeCanvas, RectF bounds,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayer(int nativeCanvas, float l,
                                               float t, float r, float b,
                                               int paint, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayerAlpha(int nativeCanvas,
                                                    RectF bounds, int alpha,
                                                    int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_saveLayerAlpha(int nativeCanvas, float l,
                                                    float t, float r, float b,
                                                    int alpha, int layerFlags) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_concat(int nCanvas, int nMatrix) {
    }

    
        private static void native_setMatrix(int nCanvas, int nMatrix) {
    }

    
        private static boolean native_clipRect(int nCanvas,
                                                  float left, float top,
                                                  float right, float bottom,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_clipPath(int nativeCanvas,
                                                  int nativePath,
                                                  int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_clipRegion(int nativeCanvas,
                                                    int nativeRegion,
                                                    int regionOp) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeSetDrawFilter(int nativeCanvas,
                                                   int nativeFilter) {
    }

    
        private static boolean native_getClipBounds(int nativeCanvas,
                                                       Rect bounds) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_getCTM(int canvas, int matrix) {
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     RectF rect,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     int path,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean native_quickReject(int nativeCanvas,
                                                     float left, float top,
                                                     float right, float bottom,
                                                     int native_edgeType) {
        return DSUtils.UNKNOWN_BOOLEAN;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.116 -0400", hash_original_method = "43BC096C5F63253CAAFF0D49F467C93B", hash_generated_method = "1978C6A28FFF2DB3A4C5A5D1D9333DBD")
    private void native_drawBitmap(int nativeCanvas, int bitmap,
                                                 float left, float top,
                                                 int nativePaintOrZero,
                                                 int canvasDensity,
                                                 int screenDensity,
                                                 int bitmapDensity) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.117 -0400", hash_original_method = "9002F07A0506565EF0C19FE427C30B26", hash_generated_method = "763AB84984E018ED98A2E3B0F74BDC61")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.155 -0400", hash_original_field = "43544F9C14B4112CFCDD0F57C8A5D0BC", hash_generated_field = "2D4BC4BEF691AE213514DA2EF6E7568C")

        private int mNativeCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.156 -0400", hash_original_method = "C87133F6F9E7B261DCFE48B3CCDE3AF4", hash_generated_method = "B264373C320A36AAFBD12A28825D248D")
        public  CanvasFinalizer(int nativeCanvas) {
            mNativeCanvas = nativeCanvas;
            // ---------- Original Method ----------
            //mNativeCanvas = nativeCanvas;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.158 -0400", hash_original_method = "DC60B53B0AE455E1CAF5A4B9B6F554F2", hash_generated_method = "284671E9CCA761E0F6E36393D7646CA2")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.158 -0400", hash_original_field = "3D2A059C760EF7D86A0626C4F577CC01", hash_generated_field = "560BA2CA377351903A6838650E1B66A9")

    public static final int DIRECTION_LTR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.159 -0400", hash_original_field = "5951EED42C22D433156FD08951CA7169", hash_generated_field = "FE6A83E9AB181642152249B0E98D001F")

    public static final int DIRECTION_RTL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "C556908955BCA8DE829C1472DC13D030", hash_generated_field = "B8DF867675CF3A883ED358B729BE57FC")

    private static int MAXMIMUM_BITMAP_SIZE = 32766;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "F4BF6B1C8A93145BA1CB4CB556F8ADF8", hash_generated_field = "6A8DA922229349FE565C69BCB53E7C76")

    public static final int MATRIX_SAVE_FLAG = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "37D5AB303E356F1AB33043E7CBEFBD08", hash_generated_field = "58F530C9C6B270B19539C29F0F59AF3F")

    public static final int CLIP_SAVE_FLAG = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "AB31C1A54E066A5DBA1B2797D23C5043", hash_generated_field = "46E7D1290A1803E6928B2E065D955191")

    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "28C403FDD6A4FCC72A3C41B2D78DEE83", hash_generated_field = "532BC0688FBCF248880462AA6827890F")

    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "97F975D3F457D0AEE16D292A34785CDA", hash_generated_field = "9BC3AB123F6CF841BC3428B9EA233C60")

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.167 -0400", hash_original_field = "E4DF070159C4F6422D39F4135C00F6BC", hash_generated_field = "A21A7EFBC48A7EE5E4832E43F9767035")

    public static final int ALL_SAVE_FLAG = 0x1F;
}

