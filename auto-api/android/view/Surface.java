package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.CompatibilityInfo.Translator;
import android.graphics.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;

public class Surface implements Parcelable {
    private int mSurfaceControl;
    private int mSaveCount;
    private Canvas mCanvas;
    private int mNativeSurface;
    private int mSurfaceGenerationId;
    private String mName;
    private Translator mCompatibilityTranslator;
    private Matrix mCompatibleMatrix;
    private Exception mCreationStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.298 -0400", hash_original_method = "3C6D5ED7C9D2AD52254061DCBE40C6B7", hash_generated_method = "4D37784A014D92ACC11781F1EEA802C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.298 -0400", hash_original_method = "63DD348776A9AD7A69FD5A5406A9D749", hash_generated_method = "49DA2959BC2F2D96C477B548496DB618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Surface(SurfaceSession s,
            int pid, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(display);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.298 -0400", hash_original_method = "77F92398B62C28FF78E552B775B6A70A", hash_generated_method = "7C2290FB36CDEF420EBE84468B4F5CF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Surface(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(display);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.298 -0400", hash_original_method = "CA741F0DB07B20B1C302E68F5EF5136C", hash_generated_method = "632413C73B8BFD6A837FF217F9EC67B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "6ECF42DC85BE770B3A0C34165723456A", hash_generated_method = "463F8946171A5DEA5DA2CD88B16D4182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Surface(Parcel source) throws OutOfResourcesException {
        dsTaint.addTaint(source.dsTaint);
        init(source);
        // ---------- Original Method ----------
        //init(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "F1240C06AF1BA9E648B2E780B8155F1C", hash_generated_method = "F4AF210A3FAC410753DB168A3B10A798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValid() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "41B8B73906B263B02861ABB4EEE712F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "F02785EB89A3C576418753FA8D7724E3", hash_generated_method = "150E980F9B3B135064FCAE2FC03C72A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Canvas lockCanvas(Rect dirty) throws OutOfResourcesException, IllegalArgumentException {
        dsTaint.addTaint(dirty.dsTaint);
        Canvas var06391638DF2BB3BAE0D4C56F992675E4_460311278 = (lockCanvasNative(dirty));
        return (Canvas)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lockCanvasNative(dirty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "1664CDF216B0331D581B002047F21426", hash_generated_method = "BED22ECC1E129FBFA1C290E3E0E577B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlockCanvasAndPost(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "9F24053A4EC94DBA8AA05836E657F81D", hash_generated_method = "9EA362434A64E923BAD3D6F466682BC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlockCanvas(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.299 -0400", hash_original_method = "FD610F755B3A8168C37DFBCC26EDD5A5", hash_generated_method = "6B988EB72E30F4A991CCBEC6A2A49CC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE88DD8035859E6656014442E27A29678_2024510026 = ("Surface(name=" + mName + ", identity=" + getIdentity() + ")");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Surface(name=" + mName + ", identity=" + getIdentity() + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.300 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.300 -0400", hash_original_method = "A2AACDDA330848E1D1B1D4F055379C04", hash_generated_method = "4D78E5F0B41D052FC0B0DE683E5127A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.300 -0400", hash_original_method = "C84F8D8C205C1B394ACE8E5A5C73E3F6", hash_generated_method = "5D255B20FFEB71AB75EB7E138934A32F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
    }

    
        private static void nativeClassInit() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.300 -0400", hash_original_method = "1CEDD42C8B2FBCD0475C0CDDE7D9C910", hash_generated_method = "869C647CA5A40D50A945A4EC72A0A034")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyFrom(Surface o) {
        dsTaint.addTaint(o.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.300 -0400", hash_original_method = "16EE9E8EF08EFD3BA0284B735E7BCC13", hash_generated_method = "79C33644E053CBAC95E906A8A577DFF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transferFrom(Surface o) {
        dsTaint.addTaint(o.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.301 -0400", hash_original_method = "4CE5C8D563EAB7D0D818407349F1750B", hash_generated_method = "4BD3AA2CB59DF5E4474CE26B5E060576")
    @DSModeled(DSC.SAFE)
    public int getGenerationId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSurfaceGenerationId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.301 -0400", hash_original_method = "CB1C97A8279A76B0FD2F8557CCA1DF81", hash_generated_method = "B180D096DF3B46478D2CF3AD2EA95C77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.301 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "1FA264C4250124C0FC0A99BBC4E0C9DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.301 -0400", hash_original_method = "187F763AA53C0F8EE9F854FE8C7B0DA2", hash_generated_method = "B3FDA16DCB854337B91C7DD3319F7572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Canvas lockCanvasNative(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        return (Canvas)dsTaint.getTaint();
    }

    
        public static void freezeDisplay(int display) {
    }

    
        public static void unfreezeDisplay(int display) {
    }

    
        public static void setOrientation(int display, int orientation, int flags) {
    }

    
        public static void setOrientation(int display, int orientation) {
        setOrientation(display, orientation, 0);
    }

    
        public static Bitmap screenshot(int width, int height) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static Bitmap screenshot(int width, int height, int minLayer, int maxLayer) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static void openTransaction() {
    }

    
        public static void closeTransaction() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.302 -0400", hash_original_method = "428DEA65454197BAB1AB2F833BF39B55", hash_generated_method = "8E6354FBC794E3AE298D99E97962F954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLayer(int zorder) {
        dsTaint.addTaint(zorder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.302 -0400", hash_original_method = "7F99A19F828A289B6FD343EC8CB65512", hash_generated_method = "DBC00E1254EC679A25ABDE18AC1FB1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPosition(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        setPosition((float)x, (float)y);
        // ---------- Original Method ----------
        //setPosition((float)x, (float)y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "D556E449F3DAE9E225E5655A6439B288", hash_generated_method = "18F8B05B80FBAA72897DF2E4D8BE0FD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPosition(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "7F2FB86FF01FCE5B1880FA85C66C3806", hash_generated_method = "282890DD97649F603219ABE8F6206664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSize(int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "58365D1B8E35BD4BC81D336D692C97A2", hash_generated_method = "2CAEE5E9ABBD44ABA77ACDEBF6780153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "9067AC917FFB66A9E8FF84EA37A89CBE", hash_generated_method = "5B805FC97056DA9ABD80353A6133FF8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "8BC3F7928D017996CA20E3AD22A58A3C", hash_generated_method = "19E1C0D9B425BE14BDA4660EED36ED0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransparentRegionHint(Region region) {
        dsTaint.addTaint(region.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "021CC1A8FCE5777EEDC941EBD3709765", hash_generated_method = "139768D2879E2B580D783D8BC66CA43E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "C221BDABC27AE9327206947389DE8DAC", hash_generated_method = "A497D5D6C8C7E06ACE721495CA388F04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMatrix(float dsdx, float dtdx, float dsdy, float dtdy) {
        dsTaint.addTaint(dtdy);
        dsTaint.addTaint(dtdx);
        dsTaint.addTaint(dsdy);
        dsTaint.addTaint(dsdx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.303 -0400", hash_original_method = "1F5223037E46C5C80D7D4FC991D282C9", hash_generated_method = "35DAF2726170E3F4ED3AD17631545F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void freeze() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "510610C10E363AFDA52A6703982BC316", hash_generated_method = "3D863391F4DF022CA3C29E823A9BD026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unfreeze() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "B3E5D6D54C5D692662BF006C8E303D59", hash_generated_method = "629441113546F751011735BB9B4871F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFreezeTint(int tint) {
        dsTaint.addTaint(tint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "C7085AACC0EA197CCDBEBDC91CFFCA9E", hash_generated_method = "DB4BA7BD99E55F00C9B07D406D866641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFlags(int flags, int mask) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "1BAE2B05EDDA8E2427743FE96FA46E82", hash_generated_method = "7C6EF9F1826766D199070573FA4D17F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "6CC4E2A6788D537FAA561FF2F1482110", hash_generated_method = "CDCB2013225E5EE142E5B708F6BEFD4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(SurfaceSession s,
            int pid, String name, int display, int w, int h, int format, int flags) throws OutOfResourcesException {
        dsTaint.addTaint(w);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(display);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(format);
        dsTaint.addTaint(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.304 -0400", hash_original_method = "F10A64920BEF86A35D10AFBE49D37C12", hash_generated_method = "E63C8CD396F5438D99BFF7E036FE8160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.305 -0400", hash_original_method = "EBFCAC1A806E7105045857BE7B671E13", hash_generated_method = "90C349AF062E2AAB0779544F3ADABDD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromSurfaceTexture(SurfaceTexture surfaceTexture) {
        dsTaint.addTaint(surfaceTexture.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.305 -0400", hash_original_method = "A65BCA62207C2D99277C23D442CBFDBD", hash_generated_method = "1E569029FC2875CD47F79DE12B451F0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getIdentity() {
        return dsTaint.getTaintInt();
    }

    
    public static class OutOfResourcesException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.305 -0400", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "A594474F57F2910DF90E8F2B34F97C87")
        @DSModeled(DSC.SAFE)
        public OutOfResourcesException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.305 -0400", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "D2827E50CE1819C8467D6B826BD6F810")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OutOfResourcesException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    private class CompatibleCanvas extends Canvas {
        private Matrix mOrigMatrix = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.305 -0400", hash_original_method = "7C0C39022D98B8B786DDAA1C7F558FD5", hash_generated_method = "7C0C39022D98B8B786DDAA1C7F558FD5")
                public CompatibleCanvas ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.306 -0400", hash_original_method = "4436A903F00C274285C5C4A8B9E9A836", hash_generated_method = "83295D6C27C606CF8806B51586CF168D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.306 -0400", hash_original_method = "F355CB2C14EBD84D4AE7E0F5ECAE6C3D", hash_generated_method = "991AF742A0AC2D9CE6D6EE6F91D50B79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.306 -0400", hash_original_method = "50EBC9F34A364763AC7C9602053D9FF8", hash_generated_method = "55C5AF7EDA3E9A925FDB8B338BCC07D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setMatrix(Matrix matrix) {
            dsTaint.addTaint(matrix.dsTaint);
            {
                boolean varC243940C8E980702D435CDAA12C8D323_1595007388 = (mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.306 -0400", hash_original_method = "8FC81697AA41EC8DD4975B897D7BBDC3", hash_generated_method = "29C68E485155C294C0C4D92B544A354C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    @Deprecated public static final int FX_SURFACE_BLUR     = 0x00010000;
    public static final int FX_SURFACE_DIM     = 0x00020000;
    public static final int FX_SURFACE_SCREENSHOT   = 0x00030000;
    public static final int FX_SURFACE_MASK     = 0x000F0000;
    public static final int SURFACE_HIDDEN    = 0x01;
    public static final int SURFACE_FROZEN     = 0x02;
    public static final int SURFACE_DITHER    = 0x04;
    static { nativeClassInit(); }
    
    public static final Parcelable.Creator<Surface> CREATOR = new Parcelable.Creator<Surface>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.307 -0400", hash_original_method = "B8797068538D7B2F1963613F92E62B32", hash_generated_method = "9C42A322D9313EF40BD0662ED20CE300")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Surface createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            try 
            {
                Surface varC876D7109D86F553F86244AD6FD53202_1462214343 = (new Surface(source));
            } //End block
            catch (Exception e)
            { }
            return (Surface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //return new Surface(source);
            //} catch (Exception e) {
                //Log.e(LOG_TAG, "Exception creating surface from parcel", e);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.307 -0400", hash_original_method = "38FBCD3B929BD371241F41AD88A154ED", hash_generated_method = "C455176C0F7EF0E80FC371D0A679AD47")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Surface[] newArray(int size) {
            dsTaint.addTaint(size);
            Surface[] var3736F3394504CAA74B80E0A8DFE9649F_1780420911 = (new Surface[size]);
            return (Surface[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Surface[size];
        }

        
}; //Transformed anonymous class
}

