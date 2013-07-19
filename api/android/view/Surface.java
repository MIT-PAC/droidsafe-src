package android.view;

// Droidsafe Imports
import android.content.res.CompatibilityInfo.Translator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.SurfaceTexture;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Surface implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "BD9155F16322AD91398B71690C8B7AEA", hash_generated_field = "3070A52A13AD896F784FBCE51B4EC514")

    private int mSurfaceControl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "CA195FDEC5D859B1105216AEBB374C45", hash_generated_field = "A0D4D8EA840808F4949CA72E7B280524")

    private int mSaveCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "8D4942A1FCE89D15FDC57EFABEDBC717")

    private Canvas mCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "6B7A1524BE726B23C7CE5739BBDA3408", hash_generated_field = "135E03AE60E04B6C9A1CE3A6EC7E0070")

    private int mNativeSurface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "53362B083976939F1558AE45894FA6BA", hash_generated_field = "81B134DE4CE27806029BB8F16BA06618")

    private int mSurfaceGenerationId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "0B3437FCE64116004DAA46396A3DFAE5", hash_generated_field = "84B770FB871F6914572C383213400F31")

    private Translator mCompatibilityTranslator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "7EA6797302956B6C6E1F30D1DB430A8F", hash_generated_field = "29B3084AC9F7B25FE01001CD958BE3DB")

    private Matrix mCompatibleMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.059 -0400", hash_original_field = "7E7F7481BAE64F4953D7B0B6B9BFBCD2", hash_generated_field = "3D60FB93273F748E494C53BEB8064D29")

    private Exception mCreationStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.060 -0400", hash_original_method = "3C6D5ED7C9D2AD52254061DCBE40C6B7", hash_generated_method = "A4D25DD305BD739C15CB87873ABD07A0")
    public  Surface(SurfaceTexture surfaceTexture) {
        addTaint(surfaceTexture.getTaint());
        if(DEBUG_RELEASE)        
        {
            mCreationStack = new Exception();
        } //End block
        mCanvas = new CompatibleCanvas();
        initFromSurfaceTexture(surfaceTexture);
        // ---------- Original Method ----------
        //if (DEBUG_RELEASE) {
            //mCreationStack = new Exception();
        //}
        //mCanvas = new CompatibleCanvas();
        //initFromSurfaceTexture(surfaceTexture);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.061 -0400", hash_original_method = "63DD348776A9AD7A69FD5A5406A9D749", hash_generated_method = "C584B60D4070D219729F8C3282DD6DF4")
    public  Surface(SurfaceSession s,
            int pid, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        addTaint(flags);
        addTaint(format);
        addTaint(h);
        addTaint(w);
        addTaint(display);
        addTaint(pid);
        addTaint(s.getTaint());
        if(DEBUG_RELEASE)        
        {
            mCreationStack = new Exception();
        } //End block
        mCanvas = new CompatibleCanvas();
        init(s,pid,null,display,w,h,format,flags);
        // ---------- Original Method ----------
        //if (DEBUG_RELEASE) {
            //mCreationStack = new Exception();
        //}
        //mCanvas = new CompatibleCanvas();
        //init(s,pid,null,display,w,h,format,flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.063 -0400", hash_original_method = "77F92398B62C28FF78E552B775B6A70A", hash_generated_method = "FDB64651208DEE56DB6D1C2510724720")
    public  Surface(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        addTaint(flags);
        addTaint(format);
        addTaint(h);
        addTaint(w);
        addTaint(display);
        addTaint(pid);
        addTaint(s.getTaint());
        if(DEBUG_RELEASE)        
        {
            mCreationStack = new Exception();
        } //End block
        mCanvas = new CompatibleCanvas();
        init(s,pid,name,display,w,h,format,flags);
        mName = name;
        // ---------- Original Method ----------
        //if (DEBUG_RELEASE) {
            //mCreationStack = new Exception();
        //}
        //mCanvas = new CompatibleCanvas();
        //init(s,pid,name,display,w,h,format,flags);
        //mName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.063 -0400", hash_original_method = "CA741F0DB07B20B1C302E68F5EF5136C", hash_generated_method = "CFF9079F6F8989E212EED52D804FE5C8")
    public  Surface() {
        if(DEBUG_RELEASE)        
        {
            mCreationStack = new Exception();
        } //End block
        mCanvas = new CompatibleCanvas();
        // ---------- Original Method ----------
        //if (DEBUG_RELEASE) {
            //mCreationStack = new Exception();
        //}
        //mCanvas = new CompatibleCanvas();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.064 -0400", hash_original_method = "6ECF42DC85BE770B3A0C34165723456A", hash_generated_method = "6B38CFE5047E5BAE29E67E9C13DA5F73")
    private  Surface(Parcel source) throws OutOfResourcesException {
        addTaint(source.getTaint());
        init(source);
        // ---------- Original Method ----------
        //init(source);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.064 -0400", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "1CA4141606543D9EC9AD9133E41BD88E")
    public boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792046539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792046539;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.064 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "41B8B73906B263B02861ABB4EEE712F2")
    public void release() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.064 -0400", hash_original_method = "F02785EB89A3C576418753FA8D7724E3", hash_generated_method = "7AB0F5DAC102336F94C4800E7E6EC8CE")
    public Canvas lockCanvas(Rect dirty) throws OutOfResourcesException, IllegalArgumentException {
        addTaint(dirty.getTaint());
Canvas var22D4613C7A7305DB019C02B164A77F20_39175989 =         lockCanvasNative(dirty);
        var22D4613C7A7305DB019C02B164A77F20_39175989.addTaint(taint);
        return var22D4613C7A7305DB019C02B164A77F20_39175989;
        // ---------- Original Method ----------
        //return lockCanvasNative(dirty);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.065 -0400", hash_original_method = "1664CDF216B0331D581B002047F21426", hash_generated_method = "BEEB767D1AF96D89BEAA4AD680C9B81D")
    public void unlockCanvasAndPost(Canvas canvas) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.065 -0400", hash_original_method = "9F24053A4EC94DBA8AA05836E657F81D", hash_generated_method = "B038027C53527359282F71DFE3BF979F")
    public void unlockCanvas(Canvas canvas) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.065 -0400", hash_original_method = "FD610F755B3A8168C37DFBCC26EDD5A5", hash_generated_method = "FA850EE97B5605899CCCDA72284FA7BB")
    @Override
    public String toString() {
String var25EF7C530E07F3C308EB714ECC7303B9_974727218 =         "Surface(name=" + mName + ", identity=" + getIdentity() + ")";
        var25EF7C530E07F3C308EB714ECC7303B9_974727218.addTaint(taint);
        return var25EF7C530E07F3C308EB714ECC7303B9_974727218;
        // ---------- Original Method ----------
        //return "Surface(name=" + mName + ", identity=" + getIdentity() + ")";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.066 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8EF3AA8DB13A2609A1BD9664EE7E36BB")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1844811211 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393548686 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393548686;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.066 -0400", hash_original_method = "A2AACDDA330848E1D1B1D4F055379C04", hash_generated_method = "6B3262E758E40230A0EC3EBB44B77D83")
    public void readFromParcel(Parcel source) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.066 -0400", hash_original_method = "C84F8D8C205C1B394ACE8E5A5C73E3F6", hash_generated_method = "ED3C20853EE283140D61863E7CC05F99")
    public void writeToParcel(Parcel dest, int flags) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.066 -0400", hash_original_method = "1CEDD42C8B2FBCD0475C0CDDE7D9C910", hash_generated_method = "F18D52817B86CDD9D9B7AFE1583B9211")
    public void copyFrom(Surface o) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.067 -0400", hash_original_method = "16EE9E8EF08EFD3BA0284B735E7BCC13", hash_generated_method = "F539196FFF94F06C660BECF76F48FD3B")
    public void transferFrom(Surface o) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.067 -0400", hash_original_method = "4CE5C8D563EAB7D0D818407349F1750B", hash_generated_method = "BFA0F1087A11B66BEC825F177ED4CCE4")
    public int getGenerationId() {
        int var53362B083976939F1558AE45894FA6BA_1973914788 = (mSurfaceGenerationId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438041168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438041168;
        // ---------- Original Method ----------
        //return mSurfaceGenerationId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.067 -0400", hash_original_method = "CB1C97A8279A76B0FD2F8557CCA1DF81", hash_generated_method = "630AFFACC4A23B139D7CE5E8B049F1EC")
     void setCompatibilityTranslator(Translator translator) {
        addTaint(translator.getTaint());
        if(translator != null)        
        {
            float appScale = translator.applicationScale;
            mCompatibleMatrix = new Matrix();
            mCompatibleMatrix.setScale(appScale, appScale);
        } //End block
        // ---------- Original Method ----------
        //if (translator != null) {
            //float appScale = translator.applicationScale;
            //mCompatibleMatrix = new Matrix();
            //mCompatibleMatrix.setScale(appScale, appScale);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.067 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "1FA264C4250124C0FC0A99BBC4E0C9DF")
    public void destroy() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.826 -0400", hash_original_method = "187F763AA53C0F8EE9F854FE8C7B0DA2", hash_generated_method = "0FF923E44844D20FE339E44DC3CFAC90")
    private Canvas lockCanvasNative(Rect dirty) {
    	return new Canvas();
    }

    
    @DSModeled(DSC.SAFE)
    public static void freezeDisplay(int display) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void unfreezeDisplay(int display) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void setOrientation(int display, int orientation, int flags) {
    }

    
    public static void setOrientation(int display, int orientation) {
        setOrientation(display, orientation, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap screenshot(int width, int height) {
    	return BitmapFactory.decodeByteArray(new byte[0], 0, width * height);
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap screenshot(int width, int height, int minLayer, int maxLayer) {
    	return BitmapFactory.decodeByteArray(new byte[0], 0, width * height);
    }

    
    @DSModeled(DSC.SAFE)
    public static void openTransaction() {
    }

    
    @DSModeled(DSC.SAFE)
    public static void closeTransaction() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "428DEA65454197BAB1AB2F833BF39B55", hash_generated_method = "E0D75CEE93E7BC9B4DD23C1CF3F705CA")
    public void setLayer(int zorder) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "7F99A19F828A289B6FD343EC8CB65512", hash_generated_method = "72AA9B77CC2AA972E9C4071D2F5243EE")
    public void setPosition(int x, int y) {
        addTaint(y);
        addTaint(x);
        setPosition((float)x, (float)y);
        // ---------- Original Method ----------
        //setPosition((float)x, (float)y);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "D556E449F3DAE9E225E5655A6439B288", hash_generated_method = "01FE99E049CADF15099A4358AD7A0805")
    public void setPosition(float x, float y) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "7F2FB86FF01FCE5B1880FA85C66C3806", hash_generated_method = "0C10C6ECA537BF9EC48FDC78E37F8231")
    public void setSize(int w, int h) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "58365D1B8E35BD4BC81D336D692C97A2", hash_generated_method = "2CAEE5E9ABBD44ABA77ACDEBF6780153")
    public void hide() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "9067AC917FFB66A9E8FF84EA37A89CBE", hash_generated_method = "5B805FC97056DA9ABD80353A6133FF8B")
    public void show() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.068 -0400", hash_original_method = "8BC3F7928D017996CA20E3AD22A58A3C", hash_generated_method = "8C6B9697066F095BC8F8EF08CAE0653C")
    public void setTransparentRegionHint(Region region) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "021CC1A8FCE5777EEDC941EBD3709765", hash_generated_method = "67D2E54DFF8E42EBA7F80A015B7CFC5C")
    public void setAlpha(float alpha) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "C221BDABC27AE9327206947389DE8DAC", hash_generated_method = "53D9B02179F6297CD55494A6D45AF1D9")
    public void setMatrix(float dsdx, float dtdx, float dsdy, float dtdy) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "1F5223037E46C5C80D7D4FC991D282C9", hash_generated_method = "35DAF2726170E3F4ED3AD17631545F9B")
    public void freeze() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "510610C10E363AFDA52A6703982BC316", hash_generated_method = "3D863391F4DF022CA3C29E823A9BD026")
    public void unfreeze() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "B3E5D6D54C5D692662BF006C8E303D59", hash_generated_method = "38006CD8D091D568FF5D25EE4FF6244D")
    public void setFreezeTint(int tint) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "C7085AACC0EA197CCDBEBDC91CFFCA9E", hash_generated_method = "70F2C2CA80B62E417117E816D656E3E8")
    public void setFlags(int flags, int mask) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "1BAE2B05EDDA8E2427743FE96FA46E82", hash_generated_method = "9F9E0DF88841C7EFDB07AD759F8BFF1C")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            super.finalize();
        } //End block
        finally 
        {
            if(mNativeSurface != 0 || mSurfaceControl != 0)            
            {
                if(DEBUG_RELEASE)                
                {
                } //End block
                else
                {
                } //End block
            } //End block
            release();
        } //End block
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} finally {
            //if (mNativeSurface != 0 || mSurfaceControl != 0) {
                //if (DEBUG_RELEASE) {
                    //Log.w(LOG_TAG, "Surface.finalize() has work. You should have called release() (" 
                            //+ mNativeSurface + ", " + mSurfaceControl + ")", mCreationStack);
                //} else {
                    //Log.w(LOG_TAG, "Surface.finalize() has work. You should have called release() (" 
                            //+ mNativeSurface + ", " + mSurfaceControl + ")");
                //}
            //}
            //release();            
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "6CC4E2A6788D537FAA561FF2F1482110", hash_generated_method = "AD08DA90139772E5809887C477D9C600")
    private void init(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "F10A64920BEF86A35D10AFBE49D37C12", hash_generated_method = "56C7840171875D3B671212B1B91DD491")
    private void init(Parcel source) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.069 -0400", hash_original_method = "EBFCAC1A806E7105045857BE7B671E13", hash_generated_method = "79DA3604975EAAE9A3B23926E4F66416")
    private void initFromSurfaceTexture(SurfaceTexture surfaceTexture) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "A65BCA62207C2D99277C23D442CBFDBD", hash_generated_method = "6D2624FC907DB9EA868EAB955C4742BD")
    private int getIdentity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669212160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669212160;
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "A594474F57F2910DF90E8F2B34F97C87")
        public  OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "5C61F340B8BA1A59560151D83B1A6E5F")
        public  OutOfResourcesException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private class CompatibleCanvas extends Canvas {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_field = "1385AF6333A941634ABB92BEDB3ACBE3", hash_generated_field = "379D1DE57EE71D7AC75E059FE9ADC328")

        private Matrix mOrigMatrix = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "9F84EE428B625E49141923C25C0021D6", hash_generated_method = "9F84EE428B625E49141923C25C0021D6")
        public CompatibleCanvas ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "4436A903F00C274285C5C4A8B9E9A836", hash_generated_method = "F281FA4AA499E01B179939091793804B")
        @Override
        public int getWidth() {
            int w = super.getWidth();
            if(mCompatibilityTranslator != null)            
            {
                w = (int)(w * mCompatibilityTranslator.applicationInvertedScale + .5f);
            } //End block
            int varF1290186A5D0B1CEAB27F4E77C0C5D68_474070433 = (w);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810822249 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810822249;
            // ---------- Original Method ----------
            //int w = super.getWidth();
            //if (mCompatibilityTranslator != null) {
                //w = (int)(w * mCompatibilityTranslator.applicationInvertedScale + .5f);
            //}
            //return w;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "F355CB2C14EBD84D4AE7E0F5ECAE6C3D", hash_generated_method = "1811F8EB7DE99ED0B15FFAF12DCE1E9D")
        @Override
        public int getHeight() {
            int h = super.getHeight();
            if(mCompatibilityTranslator != null)            
            {
                h = (int)(h * mCompatibilityTranslator.applicationInvertedScale + .5f);
            } //End block
            int var2510C39011C5BE704182423E3A695E91_1469195984 = (h);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739963324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739963324;
            // ---------- Original Method ----------
            //int h = super.getHeight();
            //if (mCompatibilityTranslator != null) {
                //h = (int)(h * mCompatibilityTranslator.applicationInvertedScale + .5f);
            //}
            //return h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.070 -0400", hash_original_method = "50EBC9F34A364763AC7C9602053D9FF8", hash_generated_method = "F85CDAB392FDB06BD24D2FBE6E2A9240")
        @Override
        public void setMatrix(Matrix matrix) {
            addTaint(matrix.getTaint());
            if(mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix))            
            {
                super.setMatrix(matrix);
            } //End block
            else
            {
                Matrix m = new Matrix(mCompatibleMatrix);
                m.preConcat(matrix);
                super.setMatrix(m);
            } //End block
            // ---------- Original Method ----------
            //if (mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix)) {
                //super.setMatrix(matrix);
            //} else {
                //Matrix m = new Matrix(mCompatibleMatrix);
                //m.preConcat(matrix);
                //super.setMatrix(m);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_method = "8FC81697AA41EC8DD4975B897D7BBDC3", hash_generated_method = "C6C1B216CDB48E845ACD67CF77B7C67C")
        @Override
        public void getMatrix(Matrix m) {
            addTaint(m.getTaint());
            super.getMatrix(m);
            if(mOrigMatrix == null)            
            {
                mOrigMatrix = new Matrix();
            } //End block
            mOrigMatrix.set(m);
            // ---------- Original Method ----------
            //super.getMatrix(m);
            //if (mOrigMatrix == null) {
                //mOrigMatrix = new Matrix(); 
            //}
            //mOrigMatrix.set(m);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "6DDF7D23DFB2FB1CF2DB3648A8B85071", hash_generated_field = "E865BFAE544CB63FF109B25F41991E5B")

    private static final String LOG_TAG = "Surface";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "B115923E6C18F47C6311DFE70CFF34FB", hash_generated_field = "85F04C43536B1AE4A9BF96CF26488180")

    private static final boolean DEBUG_RELEASE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "21335678A732A081CE6933E8E8DAE075", hash_generated_field = "D3D30099A50791E5BBCDD89F15ECA592")

    public static final int ROTATION_0       = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "0CF44681CE486D2977FD54AF7AE3682F", hash_generated_field = "F2A2C6EEDF86C1E16C9FCE94434DC53A")

    public static final int ROTATION_90      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "6BAB164EC4B724052F5B85BF9979BFF6", hash_generated_field = "E18D27FB35F9722D54432B8305BC4C14")

    public static final int ROTATION_180     = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "8F5A482B6F26FF67329F8CCFE971642D", hash_generated_field = "F81154964A7735929776F4BD9D5367B7")

    public static final int ROTATION_270     = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "A0BDC3D0947F49327858A7C3EA043B63", hash_generated_field = "2569277C8E27FDFD7DA43282F812897F")

    public static final int HIDDEN              = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "041755E0FB1FE65D79E0385846833AF4", hash_generated_field = "0DBFC41D21E0536C69753FAF5773D22D")

    public static final int SECURE              = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "209E01D187557EE76FB90CF108963F5D", hash_generated_field = "B4E5B4B144F4C46C4721120F7AEB539C")

    public static final int NON_PREMULTIPLIED   = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "2DDB37C4FE8E030ADDA21E9EFC2C9A53", hash_generated_field = "787D10C57614CA43DFEEABE50199B538")

    public static final int OPAQUE              = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "D4E7561879EC3972DDE1AB327CBF3EAE", hash_generated_field = "4144F4EBFF817C8C47FA9745FCD5529D")

    public static final int PROTECTED_APP       = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "DF169A3E9DE529BE228AF3021B6332BE", hash_generated_field = "2FE2BFC9986E44BEF9C952166E40148E")

    public static final int FX_SURFACE_NORMAL   = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "61DD00CE0D4B94896FBC7DF41785C80C", hash_generated_field = "B41A8A674D59D1BA27FDF13A7BE1EE34")

    @Deprecated
    public static final int FX_SURFACE_BLUR     = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "50E30092BB3F853C637EB7C5F6A57AEF", hash_generated_field = "CC10EA1184AB37BE19F2FD9D27FD26D7")

    public static final int FX_SURFACE_DIM     = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "5B96371DD0C90E3EE75D05B0946C70ED", hash_generated_field = "1EAE9F8197E9996FAEB8F7CC6BCA9F6A")

    public static final int FX_SURFACE_SCREENSHOT   = 0x00030000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "C5C825A72DFE30CF97B57EDAFA52757A", hash_generated_field = "9FFCE6C9349CD57B4435EDF8BDD8A3F7")

    public static final int FX_SURFACE_MASK     = 0x000F0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "41322578DA891D6298C638FF37D2E46E", hash_generated_field = "FFF1AB1FE91D68AE5A8FEEB979D6675B")

    public static final int SURFACE_HIDDEN    = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "B7D4285D19076ACBFEF95FC45E28A66B", hash_generated_field = "329C5A7EAF9BA2418EB85688C52E41C0")

    public static final int SURFACE_FROZEN     = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "ABE07E03E14E99F86ABEC697B5FBDBEA", hash_generated_field = "3B67C17B3862342915009A6C0F5CA9F5")

    public static final int SURFACE_DITHER    = 0x04;
    static { nativeClassInit(); }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.071 -0400", hash_original_field = "8D1981611D47C7C4E4F15592707A3675", hash_generated_field = "B681B4338E63E9BDE475C3E1E59180D7")

    public static final Parcelable.Creator<Surface> CREATOR
            = new Parcelable.Creator<Surface>()
    {
        public Surface createFromParcel(Parcel source) {
            try {
                return new Surface(source);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            }
            return null;
        }

        public Surface[] newArray(int size) {
            return new Surface[size];
        }
    };
    // orphaned legacy method
    public Surface createFromParcel(Parcel source) {
            try {
                return new Surface(source);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            }
            return null;
        }
    
    // orphaned legacy method
    public Surface[] newArray(int size) {
            return new Surface[size];
        }
    
}

