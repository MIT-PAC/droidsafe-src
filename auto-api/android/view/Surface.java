package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.CompatibilityInfo.Translator;
import android.graphics.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;

public class Surface implements Parcelable {
    private static final String LOG_TAG = "Surface";
    private static final boolean DEBUG_RELEASE = false;
    public static final int ROTATION_0       = 0;
    public static final int ROTATION_90      = 1;
    public static final int ROTATION_180     = 2;
    public static final int ROTATION_270     = 3;
    public static final int HIDDEN              = 0x00000004;
    public static final int SECURE              = 0x00000080;
    public static final int NON_PREMULTIPLIED   = 0x00000100;
    public static final int OPAQUE              = 0x00000400;
    public static final int PROTECTED_APP       = 0x00000800;
    public static final int FX_SURFACE_NORMAL   = 0x00000000;
    @Deprecated
    public static final int FX_SURFACE_BLUR     = 0x00010000;
    public static final int FX_SURFACE_DIM     = 0x00020000;
    public static final int FX_SURFACE_SCREENSHOT   = 0x00030000;
    public static final int FX_SURFACE_MASK     = 0x000F0000;
    public static final int SURFACE_HIDDEN    = 0x01;
    public static final int SURFACE_FROZEN     = 0x02;
    public static final int SURFACE_DITHER    = 0x04;
    private int mSurfaceControl;
    private int mSaveCount;
    private Canvas mCanvas;
    private int mNativeSurface;
    private int mSurfaceGenerationId;
    private String mName;
    private Translator mCompatibilityTranslator;
    private Matrix mCompatibleMatrix;
    private Exception mCreationStack;
    public static final Parcelable.Creator<Surface> CREATOR = new Parcelable.Creator<Surface>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "B8797068538D7B2F1963613F92E62B32", hash_generated_method = "20625C03896C00CC78C3B9B82F3233E8")
        @DSModeled(DSC.SAFE)
        public Surface createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (Surface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //return new Surface(source);
            //} catch (Exception e) {
                //Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "38FBCD3B929BD371241F41AD88A154ED", hash_generated_method = "975852FC694C983553D2F186F10E8E74")
        @DSModeled(DSC.SAFE)
        public Surface[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Surface[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Surface[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "3C6D5ED7C9D2AD52254061DCBE40C6B7", hash_generated_method = "E185DA24104161E8E6581AC29FD3749B")
    @DSModeled(DSC.SAFE)
    public Surface(SurfaceTexture surfaceTexture) {
        dsTaint.addTaint(surfaceTexture.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "63DD348776A9AD7A69FD5A5406A9D749", hash_generated_method = "3BFE1328C8B9FF2F780A7D3F0D41D5B3")
    @DSModeled(DSC.SAFE)
    public Surface(SurfaceSession s,
            int pid, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(display);
        dsTaint.addTaint(format);
        dsTaint.addTaint(h);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "77F92398B62C28FF78E552B775B6A70A", hash_generated_method = "F1D96DA2614DC19FA962C10A563C3792")
    @DSModeled(DSC.SAFE)
    public Surface(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(display);
        dsTaint.addTaint(format);
        dsTaint.addTaint(h);
        {
            mCreationStack = new Exception();
        } //End block
        mCanvas = new CompatibleCanvas();
        init(s,pid,name,display,w,h,format,flags);
        // ---------- Original Method ----------
        //if (DEBUG_RELEASE) {
            //mCreationStack = new Exception();
        //}
        //mCanvas = new CompatibleCanvas();
        //init(s,pid,name,display,w,h,format,flags);
        //mName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "CA741F0DB07B20B1C302E68F5EF5136C", hash_generated_method = "2CE40DFFC8124D60490AF12367BCB776")
    @DSModeled(DSC.SAFE)
    public Surface() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "6ECF42DC85BE770B3A0C34165723456A", hash_generated_method = "D95059EA21B4D38CF0392E52E4594ABD")
    @DSModeled(DSC.SAFE)
    private Surface(Parcel source) throws OutOfResourcesException {
        dsTaint.addTaint(source.dsTaint);
        init(source);
        // ---------- Original Method ----------
        //init(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "4650533557ECD9C18114FDC684C3823B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValid() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "D2584A9F2F8C3801A0BB432618FEF48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "F02785EB89A3C576418753FA8D7724E3", hash_generated_method = "B922C8A4ED24BB3F96EC44F9DF025BDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas lockCanvas(Rect dirty) throws OutOfResourcesException, IllegalArgumentException {
        dsTaint.addTaint(dirty.dsTaint);
        Canvas var06391638DF2BB3BAE0D4C56F992675E4_55120589 = (lockCanvasNative(dirty));
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lockCanvasNative(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "1664CDF216B0331D581B002047F21426", hash_generated_method = "56CF2DA877471A26F9E3BBB7C435F166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlockCanvasAndPost(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.534 -0400", hash_original_method = "9F24053A4EC94DBA8AA05836E657F81D", hash_generated_method = "11D6AC39426C26D688968C203D2EF885")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlockCanvas(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "FD610F755B3A8168C37DFBCC26EDD5A5", hash_generated_method = "6E75BEF1F460B5958179B94DBB66D0E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE88DD8035859E6656014442E27A29678_751173771 = ("Surface(name=" + mName + ", identity=" + getIdentity() + ")");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Surface(name=" + mName + ", identity=" + getIdentity() + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "A2AACDDA330848E1D1B1D4F055379C04", hash_generated_method = "669A2E664CC096C01F08AE9D799B5DC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "C84F8D8C205C1B394ACE8E5A5C73E3F6", hash_generated_method = "49A176EED18CE7DF24660AC7EEE0465B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "368BCBBAD3F68FEF8C07AE5DC4D2077C", hash_generated_method = "66CFEED3BA0F1B2AF18C8805660BFF70")
    private static void nativeClassInit() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "1CEDD42C8B2FBCD0475C0CDDE7D9C910", hash_generated_method = "C3B534B77310683533F00EDE9FC12EE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyFrom(Surface o) {
        dsTaint.addTaint(o.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "16EE9E8EF08EFD3BA0284B735E7BCC13", hash_generated_method = "ADE6CF2F612B25555C8B4BFC302DD5E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transferFrom(Surface o) {
        dsTaint.addTaint(o.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "4CE5C8D563EAB7D0D818407349F1750B", hash_generated_method = "859EA43A699474BA25FE3CBC146A3CA2")
    @DSModeled(DSC.SAFE)
    public int getGenerationId() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSurfaceGenerationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "CB1C97A8279A76B0FD2F8557CCA1DF81", hash_generated_method = "F23EFC46D5B1018D4884DB0C27D57932")
    @DSModeled(DSC.SAFE)
     void setCompatibilityTranslator(Translator translator) {
        dsTaint.addTaint(translator.dsTaint);
        {
            float appScale;
            appScale = translator.applicationScale;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "C0979FD74768C1B4DEEA4937354A07CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "187F763AA53C0F8EE9F854FE8C7B0DA2", hash_generated_method = "62F0FB0769D2BE39605BE5FDB7305D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Canvas lockCanvasNative(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        return (Canvas)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "9DB0E66C1A9AB7C90671A451BA800BC6", hash_generated_method = "7B4845FA192061F35A1DA5FC8C08EB52")
    public static void freezeDisplay(int display) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "02259213151E54B372977976EF2967D5", hash_generated_method = "2F241C200CAD6E0B7992EEC349E03F9B")
    public static void unfreezeDisplay(int display) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "42A522001273144863E04A0D6A3C57A9", hash_generated_method = "352C15DEE3A0C535E15823D0343CD1AA")
    public static void setOrientation(int display, int orientation, int flags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "CA3B1E412921E586689C048FD004B792", hash_generated_method = "D40867BC55FB737722C212D1BD5D85B0")
    public static void setOrientation(int display, int orientation) {
        setOrientation(display, orientation, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "DB9546994189396D4F5B70BB6C426E41", hash_generated_method = "2D381E7D870ADB5D09FDA4313287C9E5")
    public static Bitmap screenshot(int width, int height) {
        DSTaintObject taint = new DSTaintObject();
        taint.addTaint(width);
        taint.addTaint(height);
        return (Bitmap)taint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.535 -0400", hash_original_method = "23F62978A6FF5B001F5553334F9692CB", hash_generated_method = "B71282F6B17A0909E4160752A8E25801")
    public static Bitmap screenshot(int width, int height, int minLayer, int maxLayer) {
    	DSTaintObject taint = new DSTaintObject();
        taint.addTaint(width);
        taint.addTaint(height);
        taint.addTaint(minLayer);
        taint.addTaint(maxLayer);
        return (Bitmap)taint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "B345370D69D0ADB30EF332A201BA2580", hash_generated_method = "2C87405528355100A52329D537A4FF9B")
    public static void openTransaction() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "FAB045451AEFB5D891295D915941957C", hash_generated_method = "E14F69EB45B63E940A0A13AEE6C3527C")
    public static void closeTransaction() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "428DEA65454197BAB1AB2F833BF39B55", hash_generated_method = "28BCD48F7AAF4FE00D57B8A54C37BAD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLayer(int zorder) {
        dsTaint.addTaint(zorder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "7F99A19F828A289B6FD343EC8CB65512", hash_generated_method = "3A188A41F1C38601E0689E4EB8F60E0D")
    @DSModeled(DSC.SAFE)
    public void setPosition(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        setPosition((float)x, (float)y);
        // ---------- Original Method ----------
        //setPosition((float)x, (float)y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "D556E449F3DAE9E225E5655A6439B288", hash_generated_method = "81E5B5C31B83F78CA733BC1FB5CA44A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPosition(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "7F2FB86FF01FCE5B1880FA85C66C3806", hash_generated_method = "F928FBBA39218A1473AD07B1DFC7054A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSize(int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "58365D1B8E35BD4BC81D336D692C97A2", hash_generated_method = "DEC94A4AA548F10DB517AE7FECDB70D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "9067AC917FFB66A9E8FF84EA37A89CBE", hash_generated_method = "904407DD96E95F437986FD7172561C66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "8BC3F7928D017996CA20E3AD22A58A3C", hash_generated_method = "982079832CA7FB92B34721433AE4C584")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransparentRegionHint(Region region) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(region.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "021CC1A8FCE5777EEDC941EBD3709765", hash_generated_method = "8B54E39A38DC370CB28BCC7AB67ED89E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "C221BDABC27AE9327206947389DE8DAC", hash_generated_method = "AEBE698C7319F541D707C697D2BDDEB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMatrix(float dsdx, float dtdx, float dsdy, float dtdy) {
        dsTaint.addTaint(dtdy);
        dsTaint.addTaint(dtdx);
        dsTaint.addTaint(dsdy);
        dsTaint.addTaint(dsdx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "1F5223037E46C5C80D7D4FC991D282C9", hash_generated_method = "36FCEA0665551815F092B89C86EF3930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void freeze() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "510610C10E363AFDA52A6703982BC316", hash_generated_method = "C8F2715F1135FBA003E5A37A4D6B0E7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unfreeze() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "B3E5D6D54C5D692662BF006C8E303D59", hash_generated_method = "6CC80486D1A32BBEDD4032D809758561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFreezeTint(int tint) {
        dsTaint.addTaint(tint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "C7085AACC0EA197CCDBEBDC91CFFCA9E", hash_generated_method = "4683730609575713652CC0294AE550E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFlags(int flags, int mask) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "1BAE2B05EDDA8E2427743FE96FA46E82", hash_generated_method = "F615E876F5E62D95B5FF27B2ABF3D116")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            super.finalize();
        } //End block
        finally 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.536 -0400", hash_original_method = "6CC4E2A6788D537FAA561FF2F1482110", hash_generated_method = "C67C03C6F059A06E6525F4C519EB25DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(display);
        dsTaint.addTaint(format);
        dsTaint.addTaint(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "F10A64920BEF86A35D10AFBE49D37C12", hash_generated_method = "8036B3E609AD7B628454D58B90C35E3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "EBFCAC1A806E7105045857BE7B671E13", hash_generated_method = "C8C457EB99615098B896FE1C08D2FD2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromSurfaceTexture(SurfaceTexture surfaceTexture) {
        dsTaint.addTaint(surfaceTexture.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "A65BCA62207C2D99277C23D442CBFDBD", hash_generated_method = "BC5E7D4FB2B0E1B96B290DC88C9637AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getIdentity() {
    	return dsTaint.getTaintInt();
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "CFBFC0DB041C16AD2D90FA8588C85EDB")
        @DSModeled(DSC.SAFE)
        public OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "63FF1155466AA653A323C76D2D58DC79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OutOfResourcesException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    private class CompatibleCanvas extends Canvas {
        private Matrix mOrigMatrix = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "4436A903F00C274285C5C4A8B9E9A836", hash_generated_method = "EEDF9F70996E2493AB3EE2D95147C937")
        @DSModeled(DSC.SAFE)
        @Override
        public int getWidth() {
            int w;
            w = super.getWidth();
            {
                w = (int)(w * mCompatibilityTranslator.applicationInvertedScale + .5f);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int w = super.getWidth();
            //if (mCompatibilityTranslator != null) {
                //w = (int)(w * mCompatibilityTranslator.applicationInvertedScale + .5f);
            //}
            //return w;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "F355CB2C14EBD84D4AE7E0F5ECAE6C3D", hash_generated_method = "8E7F0FF50F74597B665A3197CDA7F952")
        @DSModeled(DSC.SAFE)
        @Override
        public int getHeight() {
            int h;
            h = super.getHeight();
            {
                h = (int)(h * mCompatibilityTranslator.applicationInvertedScale + .5f);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int h = super.getHeight();
            //if (mCompatibilityTranslator != null) {
                //h = (int)(h * mCompatibilityTranslator.applicationInvertedScale + .5f);
            //}
            //return h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "50EBC9F34A364763AC7C9602053D9FF8", hash_generated_method = "8208C1C0D929B9D46B1567E926F35445")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setMatrix(Matrix matrix) {
            dsTaint.addTaint(matrix.dsTaint);
            {
                boolean varC243940C8E980702D435CDAA12C8D323_502606174 = (mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix));
                {
                    super.setMatrix(matrix);
                } //End block
                {
                    Matrix m;
                    m = new Matrix(mCompatibleMatrix);
                    m.preConcat(matrix);
                    super.setMatrix(m);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix)) {
                //super.setMatrix(matrix);
            //} else {
                //Matrix m = new Matrix(mCompatibleMatrix);
                //m.preConcat(matrix);
                //super.setMatrix(m);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.537 -0400", hash_original_method = "8FC81697AA41EC8DD4975B897D7BBDC3", hash_generated_method = "DC8AF99A08793C0CF321A5C0E4C74F88")
        @DSModeled(DSC.SAFE)
        @Override
        public void getMatrix(Matrix m) {
            dsTaint.addTaint(m.dsTaint);
            super.getMatrix(m);
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


    
    static { nativeClassInit(); }
    
}


