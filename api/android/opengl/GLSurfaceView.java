package android.opengl;

// Droidsafe Imports
import java.io.Writer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class GLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "5C8CC32ADEFFBB82D5398A3F0A956341", hash_generated_field = "E80A115172E1CADCEDB95343305F31F8")

    private boolean mSizeChanged = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "2C5BF5594B888D1E6442FD66C87651DB", hash_generated_field = "2E75A75105E7522B16840413392C2719")

    private GLThread mGLThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "655D7742BDF0154D755D8012DFB26E60")

    private Renderer mRenderer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "40F295D8807CAB798532DFEA849C6F06")

    private boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "FE1CC11EA5E2D13077D6BD12E68D13DB", hash_generated_field = "0D06A0983D993F273B4D8ECA63328176")

    private EGLConfigChooser mEGLConfigChooser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.252 -0400", hash_original_field = "9C4932F67698E48B2C2276B24FB1F0CA", hash_generated_field = "22ED109E5D19AE599E44288A7242C1E5")

    private EGLContextFactory mEGLContextFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_field = "9A0AF7DCE8EC994533742E1235BC5FF1", hash_generated_field = "E3117B1108AE650B6C49E72DB2814A93")

    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_field = "F25301CD798F670D3A40407086D4663E", hash_generated_field = "AB1795361F8C868AADE39F41E168626E")

    private GLWrapper mGLWrapper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_field = "8073F2C08292CAAB03561C345E401438", hash_generated_field = "9496F66E2598A164065A99C1FFE9527C")

    private int mDebugFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_field = "2A48051BD2509E83B11EAB53FF224F6A", hash_generated_field = "AB21D5DA668CEB71C5BE53180E39D9DB")

    private int mEGLContextClientVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_field = "F50201D924FB5476F49BE8AD0664A8AC", hash_generated_field = "B7274B6FEDA290C84C4C186237763B86")

    private boolean mPreserveEGLContextOnPause;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_method = "2049D028AED77772C0EF08D2BBAE876F", hash_generated_method = "ABCBE1DBCC48566A86DFC4993FBA2798")
    public  GLSurfaceView(Context context) {
        super(context);
        addTaint(context.getTaint());
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.253 -0400", hash_original_method = "93DD44BF6C3B90D77E42FC0AB73B1708", hash_generated_method = "1CCB2F3297BD266E5F22841D480A51AE")
    public  GLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.254 -0400", hash_original_method = "E27264F3583A6717A4BE0996AD22B7A6", hash_generated_method = "C6A51B3F92CEBD35D5741E2A42EC3331")
    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        // ---------- Original Method ----------
        //SurfaceHolder holder = getHolder();
        //holder.addCallback(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.254 -0400", hash_original_method = "62AADEA51F1A9BF5575F2E5A0791202E", hash_generated_method = "DE8535F451C1DB5D5B53F3A6215E7688")
    public void setGLWrapper(GLWrapper glWrapper) {
        mGLWrapper = glWrapper;
        // ---------- Original Method ----------
        //mGLWrapper = glWrapper;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.255 -0400", hash_original_method = "95CD067D63C131003FD4FBBE7098897E", hash_generated_method = "31E24E5D35845A66E5F3AEE9995517A2")
    public void setDebugFlags(int debugFlags) {
        mDebugFlags = debugFlags;
        // ---------- Original Method ----------
        //mDebugFlags = debugFlags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.255 -0400", hash_original_method = "6993850204A95232CAB55D0CCC1BAFCE", hash_generated_method = "2DDB31419E417F7F1F4AA39D902AC6D9")
    public int getDebugFlags() {
        int var8073F2C08292CAAB03561C345E401438_792210504 = (mDebugFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092043036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092043036;
        // ---------- Original Method ----------
        //return mDebugFlags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.255 -0400", hash_original_method = "717A951DD1F3691DEF19A2756D2824F8", hash_generated_method = "E9353C948C1F52F5DBA984F15989C2F4")
    public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        mPreserveEGLContextOnPause = preserveOnPause;
        // ---------- Original Method ----------
        //mPreserveEGLContextOnPause = preserveOnPause;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.256 -0400", hash_original_method = "60238A7236A689DEF9712C11E43803DE", hash_generated_method = "F2ACAC95ACA221D1402C9E09B06DAFAE")
    public boolean getPreserveEGLContextOnPause() {
        boolean varF50201D924FB5476F49BE8AD0664A8AC_618550156 = (mPreserveEGLContextOnPause);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320217130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320217130;
        // ---------- Original Method ----------
        //return mPreserveEGLContextOnPause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.257 -0400", hash_original_method = "64481B8066824EA776B6FC67FACE8B51", hash_generated_method = "5B50993B32FF40B0ECCDAABDD9BB5036")
    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if(mEGLConfigChooser == null)        
        {
            mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        } //End block
        if(mEGLContextFactory == null)        
        {
            mEGLContextFactory = new DefaultContextFactory();
        } //End block
        if(mEGLWindowSurfaceFactory == null)        
        {
            mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        } //End block
        mRenderer = renderer;
        mGLThread = new GLThread(renderer);
        mGLThread.start();
        // ---------- Original Method ----------
        //checkRenderThreadState();
        //if (mEGLConfigChooser == null) {
            //mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        //}
        //if (mEGLContextFactory == null) {
            //mEGLContextFactory = new DefaultContextFactory();
        //}
        //if (mEGLWindowSurfaceFactory == null) {
            //mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        //}
        //mRenderer = renderer;
        //mGLThread = new GLThread(renderer);
        //mGLThread.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.258 -0400", hash_original_method = "6F22CFBD5A9926728BF6F0008FB33425", hash_generated_method = "CD9884CBA3536496A087BFFD0559CE66")
    public void setEGLContextFactory(EGLContextFactory factory) {
        checkRenderThreadState();
        mEGLContextFactory = factory;
        // ---------- Original Method ----------
        //checkRenderThreadState();
        //mEGLContextFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.258 -0400", hash_original_method = "1FB2F696FFEAFBF78B8CE4F0AE52B72E", hash_generated_method = "6BD5E5299B980A2A6E05ADF7ABC9CD3E")
    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        checkRenderThreadState();
        mEGLWindowSurfaceFactory = factory;
        // ---------- Original Method ----------
        //checkRenderThreadState();
        //mEGLWindowSurfaceFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.259 -0400", hash_original_method = "95299B7816E92BC747285D3C263BF3C6", hash_generated_method = "57B6C252C5E049C7F30F5A70B4956DEE")
    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        checkRenderThreadState();
        mEGLConfigChooser = configChooser;
        // ---------- Original Method ----------
        //checkRenderThreadState();
        //mEGLConfigChooser = configChooser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.259 -0400", hash_original_method = "226B740D6DC98E22518E0EAB23B55B9E", hash_generated_method = "FB3999790C7191F067A027B0EDBCA419")
    public void setEGLConfigChooser(boolean needDepth) {
        addTaint(needDepth);
        setEGLConfigChooser(new SimpleEGLConfigChooser(needDepth));
        // ---------- Original Method ----------
        //setEGLConfigChooser(new SimpleEGLConfigChooser(needDepth));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.260 -0400", hash_original_method = "091BCCF8C091A3C39DC981548CC7F874", hash_generated_method = "83621D78DF70B8B5E683F86DD862F423")
    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize,
            int alphaSize, int depthSize, int stencilSize) {
        addTaint(stencilSize);
        addTaint(depthSize);
        addTaint(alphaSize);
        addTaint(blueSize);
        addTaint(greenSize);
        addTaint(redSize);
        setEGLConfigChooser(new ComponentSizeChooser(redSize, greenSize,
                blueSize, alphaSize, depthSize, stencilSize));
        // ---------- Original Method ----------
        //setEGLConfigChooser(new ComponentSizeChooser(redSize, greenSize,
                //blueSize, alphaSize, depthSize, stencilSize));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.260 -0400", hash_original_method = "50689A18B452A2797F4096E269807A99", hash_generated_method = "9C0EB114981D0392CB7089EEB75DABAD")
    public void setEGLContextClientVersion(int version) {
        checkRenderThreadState();
        mEGLContextClientVersion = version;
        // ---------- Original Method ----------
        //checkRenderThreadState();
        //mEGLContextClientVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.261 -0400", hash_original_method = "F401D8CE2ED637FA8D91B0F6CF1DA9F1", hash_generated_method = "2B6E51CBC645D702F00DE6F8DAB112F4")
    public void setRenderMode(int renderMode) {
        addTaint(renderMode);
        mGLThread.setRenderMode(renderMode);
        // ---------- Original Method ----------
        //mGLThread.setRenderMode(renderMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.261 -0400", hash_original_method = "A90B80ACC894289C502B7717EBA7E101", hash_generated_method = "7D0AEDE866A842D64A2F863FE1F020CF")
    public int getRenderMode() {
        int var3A4B05FA71E35DAAA8CA366057A7D2CF_1492005771 = (mGLThread.getRenderMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392247041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392247041;
        // ---------- Original Method ----------
        //return mGLThread.getRenderMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.261 -0400", hash_original_method = "CFFBC35659E0BA943A055CA80830B728", hash_generated_method = "596A5792FF4EE3F180CFE15B447D9C84")
    public void requestRender() {
        mGLThread.requestRender();
        // ---------- Original Method ----------
        //mGLThread.requestRender();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.262 -0400", hash_original_method = "CA97146B18E855EC440A54EE624F6B33", hash_generated_method = "1701EE367EFAFFD7A8871AFD5FE8119B")
    public void surfaceCreated(SurfaceHolder holder) {
        addTaint(holder.getTaint());
        mGLThread.surfaceCreated();
        // ---------- Original Method ----------
        //mGLThread.surfaceCreated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.262 -0400", hash_original_method = "EA7799B476DE689FE2FFBF9C597A98F4", hash_generated_method = "847AF2A8F84DE1F98B2859A58D2FED9A")
    public void surfaceDestroyed(SurfaceHolder holder) {
        addTaint(holder.getTaint());
        mGLThread.surfaceDestroyed();
        // ---------- Original Method ----------
        //mGLThread.surfaceDestroyed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.262 -0400", hash_original_method = "30B95CA79378BAE34CA752354751401C", hash_generated_method = "5EA8E71188F042DA3547B5B7528A7B03")
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        addTaint(h);
        addTaint(w);
        addTaint(format);
        addTaint(holder.getTaint());
        mGLThread.onWindowResize(w, h);
        // ---------- Original Method ----------
        //mGLThread.onWindowResize(w, h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.263 -0400", hash_original_method = "0214E3A2798E907A5B7DAC32A4EC375B", hash_generated_method = "6681AE724F27029C5B375ADA17026377")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mGLThread.onPause();
        // ---------- Original Method ----------
        //mGLThread.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.263 -0400", hash_original_method = "FF9EAD78F8E3B3945B5E32D8491EF212", hash_generated_method = "7C9D3D7765FF5DFBFD663EC6CFD3DF12")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mGLThread.onResume();
        // ---------- Original Method ----------
        //mGLThread.onResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.263 -0400", hash_original_method = "BC25E256895D25AFE996AA7797074D1E", hash_generated_method = "6172F668F47571DE604108EB705EC639")
    public void queueEvent(Runnable r) {
        addTaint(r.getTaint());
        mGLThread.queueEvent(r);
        // ---------- Original Method ----------
        //mGLThread.queueEvent(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.264 -0400", hash_original_method = "B3264BCF0DBD2F88E8CFEB8E1785CF85", hash_generated_method = "AC147B12F79F6D118CD724BBE7320BA6")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        if(LOG_ATTACH_DETACH)        
        {
            Log.d(TAG, "onAttachedToWindow reattach =" + mDetached);
        } //End block
        if(mDetached && (mRenderer != null))        
        {
            int renderMode = RENDERMODE_CONTINUOUSLY;
            if(mGLThread != null)            
            {
                renderMode = mGLThread.getRenderMode();
            } //End block
            mGLThread = new GLThread(mRenderer);
            if(renderMode != RENDERMODE_CONTINUOUSLY)            
            {
                mGLThread.setRenderMode(renderMode);
            } //End block
            mGLThread.start();
        } //End block
        mDetached = false;
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (LOG_ATTACH_DETACH) {
            //Log.d(TAG, "onAttachedToWindow reattach =" + mDetached);
        //}
        //if (mDetached && (mRenderer != null)) {
            //int renderMode = RENDERMODE_CONTINUOUSLY;
            //if (mGLThread != null) {
                //renderMode = mGLThread.getRenderMode();
            //}
            //mGLThread = new GLThread(mRenderer);
            //if (renderMode != RENDERMODE_CONTINUOUSLY) {
                //mGLThread.setRenderMode(renderMode);
            //}
            //mGLThread.start();
        //}
        //mDetached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.264 -0400", hash_original_method = "783D43AC66E879A98C2CBDD1B113996E", hash_generated_method = "4C8D1093930C1588D1CD927129A22660")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(LOG_ATTACH_DETACH)        
        {
            Log.d(TAG, "onDetachedFromWindow");
        } //End block
        if(mGLThread != null)        
        {
            mGLThread.requestExitAndWait();
        } //End block
        mDetached = true;
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //if (LOG_ATTACH_DETACH) {
            //Log.d(TAG, "onDetachedFromWindow");
        //}
        //if (mGLThread != null) {
            //mGLThread.requestExitAndWait();
        //}
        //mDetached = true;
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.265 -0400", hash_original_method = "D0DDFF21B511089DC22A6A0EC54D9B69", hash_generated_method = "A84D7E2139BB88F789B9F8F23DA3EFC0")
    private void checkRenderThreadState() {
        if(mGLThread != null)        
        {
            IllegalStateException varC218A1D46912D20C666AAA2EC6490C75_431486201 = new IllegalStateException(
                    "setRenderer has already been called for this instance.");
            varC218A1D46912D20C666AAA2EC6490C75_431486201.addTaint(taint);
            throw varC218A1D46912D20C666AAA2EC6490C75_431486201;
        } //End block
        // ---------- Original Method ----------
        //if (mGLThread != null) {
            //throw new IllegalStateException(
                    //"setRenderer has already been called for this instance.");
        //}
    }

    
    private class DefaultContextFactory implements EGLContextFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.265 -0400", hash_original_field = "A19F59BE927F4F5E11AA32DB62E90314", hash_generated_field = "A15829C68F3F8F197FCD7108E0FB196F")

        private int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.265 -0400", hash_original_method = "367DA38C080CFBEAC5EB8A1CB6A885E8", hash_generated_method = "367DA38C080CFBEAC5EB8A1CB6A885E8")
        public DefaultContextFactory ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.265 -0400", hash_original_method = "97605796E723B11DCDEB6F529D20F6F4", hash_generated_method = "DEC8FBDC02CD7EF5E494517F655CA15F")
        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            addTaint(config.getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, mEGLContextClientVersion,
                    EGL10.EGL_NONE };
EGLContext var4C18EADC35FDAA640D05B1661AC9F8A7_1756112244 =             egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT,
                    mEGLContextClientVersion != 0 ? attrib_list : null);
            var4C18EADC35FDAA640D05B1661AC9F8A7_1756112244.addTaint(taint);
            return var4C18EADC35FDAA640D05B1661AC9F8A7_1756112244;
            // ---------- Original Method ----------
            //int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, mEGLContextClientVersion,
                    //EGL10.EGL_NONE };
            //return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT,
                    //mEGLContextClientVersion != 0 ? attrib_list : null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.266 -0400", hash_original_method = "737CCA85FA60476B1E480C5B63FFDFD8", hash_generated_method = "FB25EC3B0764E71C6518454177D59073")
        public void destroyContext(EGL10 egl, EGLDisplay display,
                EGLContext context) {
            addTaint(context.getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            if(!egl.eglDestroyContext(display, context))            
            {
                if(LOG_THREADS)                
                {
                } //End block
                RuntimeException varE70A668B21E542DE99EB5DB8ECDB19A4_1004046681 = new RuntimeException("eglDestroyContext failed: "
                        + EGLLogWrapper.getErrorString(egl.eglGetError()));
                varE70A668B21E542DE99EB5DB8ECDB19A4_1004046681.addTaint(taint);
                throw varE70A668B21E542DE99EB5DB8ECDB19A4_1004046681;
            } //End block
            // ---------- Original Method ----------
            //if (!egl.eglDestroyContext(display, context)) {
                //Log.e("DefaultContextFactory", "display:" + display + " context: " + context);
                //if (LOG_THREADS) {
                    //Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                //}
                //throw new RuntimeException("eglDestroyContext failed: "
                        //+ EGLLogWrapper.getErrorString(egl.eglGetError()));
            //}
        }

        
    }


    
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.267 -0400", hash_original_method = "6C49886831D2941418C9D5571DBB218F", hash_generated_method = "6C49886831D2941418C9D5571DBB218F")
        public DefaultWindowSurfaceFactory ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.267 -0400", hash_original_method = "B3EF23184592B8D563E81FEA0BB94777", hash_generated_method = "3B47694EC6D53D4DACF538557B8B1B28")
        public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display,
                EGLConfig config, Object nativeWindow) {
            addTaint(nativeWindow.getTaint());
            addTaint(config.getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            EGLSurface result = null;
            try 
            {
                result = egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            } //End block
            catch (IllegalArgumentException e)
            {
            } //End block
EGLSurface varDC838461EE2FA0CA4C9BBB70A15456B0_1848407234 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1848407234.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1848407234;
            // ---------- Original Method ----------
            //EGLSurface result = null;
            //try {
                //result = egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            //} catch (IllegalArgumentException e) {
                //Log.e(TAG, "eglCreateWindowSurface", e);
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.268 -0400", hash_original_method = "E501A8DBEBAA16077B860412B23D22C3", hash_generated_method = "62167E021FEC61595A665B69C4B5B7F1")
        public void destroySurface(EGL10 egl, EGLDisplay display,
                EGLSurface surface) {
            addTaint(surface.getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            egl.eglDestroySurface(display, surface);
            // ---------- Original Method ----------
            //egl.eglDestroySurface(display, surface);
        }

        
    }


    
    private abstract class BaseConfigChooser implements EGLConfigChooser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.268 -0400", hash_original_field = "56C48A662231532FA0ED121513C84BCC", hash_generated_field = "0A6C46FF0E4A8D427534A13E3913B826")

        protected int[] mConfigSpec;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.268 -0400", hash_original_method = "A0DBF051E13A9D28CAE6FB3EFED45483", hash_generated_method = "0CE9E04EE63DB888AA091436398A0249")
        public  BaseConfigChooser(int[] configSpec) {
            mConfigSpec = filterConfigSpec(configSpec);
            // ---------- Original Method ----------
            //mConfigSpec = filterConfigSpec(configSpec);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.269 -0400", hash_original_method = "8324D0F818B008780D6764BA3D123E5B", hash_generated_method = "7285425DF9162AF555C6F13A620D0ECA")
        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            int[] num_config = new int[1];
            if(!egl.eglChooseConfig(display, mConfigSpec, null, 0,
                    num_config))            
            {
                IllegalArgumentException var63420DA9E3C1A2E5F4449BB499FC9C6A_1214354495 = new IllegalArgumentException("eglChooseConfig failed");
                var63420DA9E3C1A2E5F4449BB499FC9C6A_1214354495.addTaint(taint);
                throw var63420DA9E3C1A2E5F4449BB499FC9C6A_1214354495;
            } //End block
            int numConfigs = num_config[0];
            if(numConfigs <= 0)            
            {
                IllegalArgumentException var966BF0FADDC050963942B5714E09F6AA_415774121 = new IllegalArgumentException(
                        "No configs match configSpec");
                var966BF0FADDC050963942B5714E09F6AA_415774121.addTaint(taint);
                throw var966BF0FADDC050963942B5714E09F6AA_415774121;
            } //End block
            EGLConfig[] configs = new EGLConfig[numConfigs];
            if(!egl.eglChooseConfig(display, mConfigSpec, configs, numConfigs,
                    num_config))            
            {
                IllegalArgumentException varC8C34BC32F3AEF512C5D0FC891478096_1177141298 = new IllegalArgumentException("eglChooseConfig#2 failed");
                varC8C34BC32F3AEF512C5D0FC891478096_1177141298.addTaint(taint);
                throw varC8C34BC32F3AEF512C5D0FC891478096_1177141298;
            } //End block
            EGLConfig config = chooseConfig(egl, display, configs);
            if(config == null)            
            {
                IllegalArgumentException varC9694EE3A7EED9942529BF4C9D0DE787_118707846 = new IllegalArgumentException("No config chosen");
                varC9694EE3A7EED9942529BF4C9D0DE787_118707846.addTaint(taint);
                throw varC9694EE3A7EED9942529BF4C9D0DE787_118707846;
            } //End block
EGLConfig var81567CF7749AF2EA37063F56A4D104CE_1965624746 =             config;
            var81567CF7749AF2EA37063F56A4D104CE_1965624746.addTaint(taint);
            return var81567CF7749AF2EA37063F56A4D104CE_1965624746;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        abstract EGLConfig chooseConfig(EGL10 egl, EGLDisplay display,
                EGLConfig[] configs);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.270 -0400", hash_original_method = "A5ED2D6BA80622A09257A565CA0B4B3A", hash_generated_method = "8292428C952977D5126A5A533AEDED68")
        private int[] filterConfigSpec(int[] configSpec) {
            addTaint(configSpec[0]);
            if(mEGLContextClientVersion != 2)            
            {
                int[] varE8D3997D6620122E5C778B5C85BBED61_1619194769 = (configSpec);
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1131466742 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_1131466742;
            } //End block
            int len = configSpec.length;
            int[] newConfigSpec = new int[len + 2];
            System.arraycopy(configSpec, 0, newConfigSpec, 0, len-1);
            newConfigSpec[len-1] = EGL10.EGL_RENDERABLE_TYPE;
            newConfigSpec[len] = 4;
            newConfigSpec[len+1] = EGL10.EGL_NONE;
            int[] var51199C2D9687B5D3D11CF8A6BDE6A030_857428641 = (newConfigSpec);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2102639828 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_2102639828;
            // ---------- Original Method ----------
            //if (mEGLContextClientVersion != 2) {
                //return configSpec;
            //}
            //int len = configSpec.length;
            //int[] newConfigSpec = new int[len + 2];
            //System.arraycopy(configSpec, 0, newConfigSpec, 0, len-1);
            //newConfigSpec[len-1] = EGL10.EGL_RENDERABLE_TYPE;
            //newConfigSpec[len] = 4;
            //newConfigSpec[len+1] = EGL10.EGL_NONE;
            //return newConfigSpec;
        }

        
    }


    
    private class ComponentSizeChooser extends BaseConfigChooser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "3B2CE6613BAAB11EC6605CC6BD87C453")

        private int[] mValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "EA7834070CA09D743B703BD153BE105D", hash_generated_field = "DFB29A4DE6CC3A6F59EEA72256CA1B07")

        protected int mRedSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "CB443D85A6809577071B4911F637BA72", hash_generated_field = "F004205D5ECD51A712961F597706D420")

        protected int mGreenSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "3D8E5E49A033D1F269BEFBF7FD4138C9", hash_generated_field = "10FEF4227DE2E0FF5A7B93D82D802C38")

        protected int mBlueSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "A48F41D048FF60B9B7CB340DDE7DF7DA", hash_generated_field = "4D595AB931725F0489E385B7FCCFFE15")

        protected int mAlphaSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "B8DB5B8F0D138562F1090879E60E3778", hash_generated_field = "069D7DB749F1CA74392E9E3B7C7F6E2C")

        protected int mDepthSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.271 -0400", hash_original_field = "8C32FB68D37ACEC3AD971DDC5C67BF87", hash_generated_field = "2F511AB8225415A379DBE2BACDAB208A")

        protected int mStencilSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.273 -0400", hash_original_method = "E977E3948EFA9E2BABD91C89238414B6", hash_generated_method = "88A6B05F3856EB5895AC37D711C971E2")
        public  ComponentSizeChooser(int redSize, int greenSize, int blueSize,
                int alphaSize, int depthSize, int stencilSize) {
            super(new int[] {
                    EGL10.EGL_RED_SIZE, redSize,
                    EGL10.EGL_GREEN_SIZE, greenSize,
                    EGL10.EGL_BLUE_SIZE, blueSize,
                    EGL10.EGL_ALPHA_SIZE, alphaSize,
                    EGL10.EGL_DEPTH_SIZE, depthSize,
                    EGL10.EGL_STENCIL_SIZE, stencilSize,
                    EGL10.EGL_NONE});
            mValue = new int[1];
            mRedSize = redSize;
            mGreenSize = greenSize;
            mBlueSize = blueSize;
            mAlphaSize = alphaSize;
            mDepthSize = depthSize;
            mStencilSize = stencilSize;
            // ---------- Original Method ----------
            //mValue = new int[1];
            //mRedSize = redSize;
            //mGreenSize = greenSize;
            //mBlueSize = blueSize;
            //mAlphaSize = alphaSize;
            //mDepthSize = depthSize;
            //mStencilSize = stencilSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.273 -0400", hash_original_method = "90A4D31D410952CF994E4BDBA2A25F67", hash_generated_method = "5C5089836D83CB2B5DA887972AB6298E")
        @Override
        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display,
                EGLConfig[] configs) {
            addTaint(configs[0].getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
for(EGLConfig config : configs)
            {
                int d = findConfigAttrib(egl, display, config,
                        EGL10.EGL_DEPTH_SIZE, 0);
                int s = findConfigAttrib(egl, display, config,
                        EGL10.EGL_STENCIL_SIZE, 0);
                if((d >= mDepthSize) && (s >= mStencilSize))                
                {
                    int r = findConfigAttrib(egl, display, config,
                            EGL10.EGL_RED_SIZE, 0);
                    int g = findConfigAttrib(egl, display, config,
                             EGL10.EGL_GREEN_SIZE, 0);
                    int b = findConfigAttrib(egl, display, config,
                              EGL10.EGL_BLUE_SIZE, 0);
                    int a = findConfigAttrib(egl, display, config,
                            EGL10.EGL_ALPHA_SIZE, 0);
                    if((r == mRedSize) && (g == mGreenSize)
                            && (b == mBlueSize) && (a == mAlphaSize))                    
                    {
EGLConfig var81567CF7749AF2EA37063F56A4D104CE_480073345 =                         config;
                        var81567CF7749AF2EA37063F56A4D104CE_480073345.addTaint(taint);
                        return var81567CF7749AF2EA37063F56A4D104CE_480073345;
                    } //End block
                } //End block
            } //End block
EGLConfig var540C13E9E156B687226421B24F2DF178_867898396 =             null;
            var540C13E9E156B687226421B24F2DF178_867898396.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_867898396;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.273 -0400", hash_original_method = "97DBBE0DC2E33C941B4CF19B7BAFBD1F", hash_generated_method = "40EFB7DF5B9AB0D553B4286F2B6A8084")
        private int findConfigAttrib(EGL10 egl, EGLDisplay display,
                EGLConfig config, int attribute, int defaultValue) {
            addTaint(defaultValue);
            addTaint(attribute);
            addTaint(config.getTaint());
            addTaint(display.getTaint());
            addTaint(egl.getTaint());
            if(egl.eglGetConfigAttrib(display, config, attribute, mValue))            
            {
                int var7B4DFC040077F056DADD8131153DD2BA_1121921614 = (mValue[0]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77195213 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77195213;
            } //End block
            int var16830A58E1E33A4163524366BA7B701B_1108979814 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452042318 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452042318;
            // ---------- Original Method ----------
            //if (egl.eglGetConfigAttrib(display, config, attribute, mValue)) {
                //return mValue[0];
            //}
            //return defaultValue;
        }

        
    }


    
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.274 -0400", hash_original_method = "5A2D4186FEBB3CAA35FAB0BA469AA3FD", hash_generated_method = "A50673207916E7AF056A1E3FBFF6CFD7")
        public  SimpleEGLConfigChooser(boolean withDepthBuffer) {
            super(5, 6, 5, 0, withDepthBuffer ? 16 : 0, 0);
            addTaint(withDepthBuffer);
            // ---------- Original Method ----------
        }

        
    }


    
    private class EglHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_field = "3023137470A4ADFB4E3C9833935DD103", hash_generated_field = "3F30F83F3D104993379AD92B39AFB83D")

        EGL10 mEgl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_field = "1FC08BDEAF1E15E8CF7A87BCC9D8C81F", hash_generated_field = "7AE477A3032DB5EA7015A0F83A2F2E86")

        EGLDisplay mEglDisplay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_field = "BB92F1E402C2CF8873F9526C78C325F9", hash_generated_field = "3BCE51A04A846FE71AD218CCB7DF9B47")

        EGLSurface mEglSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_field = "EC18D8492C89047079D96796B1A86CCE", hash_generated_field = "0645CA46F08494E04FEDB68893B6F495")

        EGLConfig mEglConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_field = "4B5703969A5D1B3F20E76A16B21EF3AA", hash_generated_field = "75D18A698C8C0156FC372CC4CDC659FD")

        EGLContext mEglContext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.275 -0400", hash_original_method = "83AF3D46DA70FB835D7CAB893AE219D0", hash_generated_method = "61E9FC9F7B53C9519C38BEB8C32FDDB4")
        public  EglHelper() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.276 -0400", hash_original_method = "E1120F549D6F6E96023A6A07CACEFA1B", hash_generated_method = "A47F62F6DCD00CF4E5E8066D4D9B5CE1")
        public void start() {
            if(LOG_EGL)            
            {
            } //End block
            mEgl = (EGL10) EGLContext.getEGL();
            mEglDisplay = mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if(mEglDisplay == EGL10.EGL_NO_DISPLAY)            
            {
                RuntimeException var0312427AA6A13F1770EDEB58A1465A88_27083476 = new RuntimeException("eglGetDisplay failed");
                var0312427AA6A13F1770EDEB58A1465A88_27083476.addTaint(taint);
                throw var0312427AA6A13F1770EDEB58A1465A88_27083476;
            } //End block
            int[] version = new int[2];
            if(!mEgl.eglInitialize(mEglDisplay, version))            
            {
                RuntimeException var5200287A2A065ADB27820FAEFDEDBF9A_136200235 = new RuntimeException("eglInitialize failed");
                var5200287A2A065ADB27820FAEFDEDBF9A_136200235.addTaint(taint);
                throw var5200287A2A065ADB27820FAEFDEDBF9A_136200235;
            } //End block
            mEglConfig = mEGLConfigChooser.chooseConfig(mEgl, mEglDisplay);
            mEglContext = mEGLContextFactory.createContext(mEgl, mEglDisplay, mEglConfig);
            if(mEglContext == null || mEglContext == EGL10.EGL_NO_CONTEXT)            
            {
                mEglContext = null;
                throwEglException("createContext");
            } //End block
            if(LOG_EGL)            
            {
            } //End block
            mEglSurface = null;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.277 -0400", hash_original_method = "E9F7F165780F6F468D822EAA5675F636", hash_generated_method = "0470F2E4C6714F5AE2C4FE5CE9F545BF")
        public GL createSurface(SurfaceHolder holder) {
            if(LOG_EGL)            
            {
            } //End block
            if(mEgl == null)            
            {
                RuntimeException var5A8744D5A97A139075D8D01C30ADD4A5_430379898 = new RuntimeException("egl not initialized");
                var5A8744D5A97A139075D8D01C30ADD4A5_430379898.addTaint(taint);
                throw var5A8744D5A97A139075D8D01C30ADD4A5_430379898;
            } //End block
            if(mEglDisplay == null)            
            {
                RuntimeException varA6A6317A00D2FA87E40F6545911F3492_2100102790 = new RuntimeException("eglDisplay not initialized");
                varA6A6317A00D2FA87E40F6545911F3492_2100102790.addTaint(taint);
                throw varA6A6317A00D2FA87E40F6545911F3492_2100102790;
            } //End block
            if(mEglConfig == null)            
            {
                RuntimeException var5648A4DE52718464733525554FABDB07_1401742398 = new RuntimeException("mEglConfig not initialized");
                var5648A4DE52718464733525554FABDB07_1401742398.addTaint(taint);
                throw var5648A4DE52718464733525554FABDB07_1401742398;
            } //End block
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE)            
            {
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
            } //End block
            mEglSurface = mEGLWindowSurfaceFactory.createWindowSurface(mEgl,
                    mEglDisplay, mEglConfig, holder);
            if(mEglSurface == null || mEglSurface == EGL10.EGL_NO_SURFACE)            
            {
                int error = mEgl.eglGetError();
                if(error == EGL10.EGL_BAD_NATIVE_WINDOW)                
                {
                } //End block
GL var540C13E9E156B687226421B24F2DF178_2135092748 =                 null;
                var540C13E9E156B687226421B24F2DF178_2135092748.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2135092748;
            } //End block
            if(!mEgl.eglMakeCurrent(mEglDisplay, mEglSurface, mEglSurface, mEglContext))            
            {
                throwEglException("eglMakeCurrent");
            } //End block
            GL gl = mEglContext.getGL();
            if(mGLWrapper != null)            
            {
                gl = mGLWrapper.wrap(gl);
            } //End block
            if((mDebugFlags & (DEBUG_CHECK_GL_ERROR | DEBUG_LOG_GL_CALLS)) != 0)            
            {
                int configFlags = 0;
                Writer log = null;
                if((mDebugFlags & DEBUG_CHECK_GL_ERROR) != 0)                
                {
                    configFlags |= GLDebugHelper.CONFIG_CHECK_GL_ERROR;
                } //End block
                if((mDebugFlags & DEBUG_LOG_GL_CALLS) != 0)                
                {
                    log = new LogWriter();
                } //End block
                gl = GLDebugHelper.wrap(gl, configFlags, log);
            } //End block
GL varFAA02136F9EBF1C6070126B7C9E9CB37_1835747862 =             gl;
            varFAA02136F9EBF1C6070126B7C9E9CB37_1835747862.addTaint(taint);
            return varFAA02136F9EBF1C6070126B7C9E9CB37_1835747862;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.279 -0400", hash_original_method = "009805D54505405E7F35DCDF643A7FC6", hash_generated_method = "7A469EDC4D4D4A110B38ED9ADFB06D4D")
        public void purgeBuffers() {
            mEgl.eglMakeCurrent(mEglDisplay,
                    EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                    EGL10.EGL_NO_CONTEXT);
            mEgl.eglMakeCurrent(mEglDisplay,
                    mEglSurface, mEglSurface,
                    mEglContext);
            // ---------- Original Method ----------
            //mEgl.eglMakeCurrent(mEglDisplay,
                    //EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                    //EGL10.EGL_NO_CONTEXT);
            //mEgl.eglMakeCurrent(mEglDisplay,
                    //mEglSurface, mEglSurface,
                    //mEglContext);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.280 -0400", hash_original_method = "9C95ED348041927E683F703A784FA97A", hash_generated_method = "90FE5F937599601CA7A40CE1AB4191B2")
        public boolean swap() {
            if(! mEgl.eglSwapBuffers(mEglDisplay, mEglSurface))            
            {
                int error = mEgl.eglGetError();
switch(error){
                case EGL11.EGL_CONTEXT_LOST:
                boolean var68934A3E9455FA72420237EB05902327_1977189886 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256008622 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_256008622;
                case EGL10.EGL_BAD_NATIVE_WINDOW:
                break;
                default:
                throwEglException("eglSwapBuffers", error);
}
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_864103611 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1387539423 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1387539423;
            // ---------- Original Method ----------
            //if (! mEgl.eglSwapBuffers(mEglDisplay, mEglSurface)) {
                //int error = mEgl.eglGetError();
                //switch(error) {
                //case EGL11.EGL_CONTEXT_LOST:
                    //return false;
                //case EGL10.EGL_BAD_NATIVE_WINDOW:
                    //Log.e("EglHelper", "eglSwapBuffers returned EGL_BAD_NATIVE_WINDOW. tid=" + Thread.currentThread().getId());
                    //break;
                //default:
                    //throwEglException("eglSwapBuffers", error);
                //}
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.281 -0400", hash_original_method = "F4390E64E142A92962AFFCA2A868DB1D", hash_generated_method = "3AA48DFDF0E8A5A71C0F9271AB99BF16")
        public void destroySurface() {
            if(LOG_EGL)            
            {
            } //End block
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE)            
            {
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_CONTEXT);
                mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
                mEglSurface = null;
            } //End block
            // ---------- Original Method ----------
            //if (LOG_EGL) {
                //Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            //}
            //if (mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {
                //mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE,
                        //EGL10.EGL_NO_SURFACE,
                        //EGL10.EGL_NO_CONTEXT);
                //mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
                //mEglSurface = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.282 -0400", hash_original_method = "75E7D06EEC93D6B21DBAB7382B0AE2AF", hash_generated_method = "FAEB092283C1C5AEF04BC4EA95AB9696")
        public void finish() {
            if(LOG_EGL)            
            {
            } //End block
            if(mEglContext != null)            
            {
                mEGLContextFactory.destroyContext(mEgl, mEglDisplay, mEglContext);
                mEglContext = null;
            } //End block
            if(mEglDisplay != null)            
            {
                mEgl.eglTerminate(mEglDisplay);
                mEglDisplay = null;
            } //End block
            // ---------- Original Method ----------
            //if (LOG_EGL) {
                //Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            //}
            //if (mEglContext != null) {
                //mEGLContextFactory.destroyContext(mEgl, mEglDisplay, mEglContext);
                //mEglContext = null;
            //}
            //if (mEglDisplay != null) {
                //mEgl.eglTerminate(mEglDisplay);
                //mEglDisplay = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.283 -0400", hash_original_method = "BBFD946D1E92713A8E3F246C64816A5E", hash_generated_method = "2653A3AF88837D543E107E60A9B32AFB")
        private void throwEglException(String function) {
            addTaint(function.getTaint());
            throwEglException(function, mEgl.eglGetError());
            // ---------- Original Method ----------
            //throwEglException(function, mEgl.eglGetError());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.284 -0400", hash_original_method = "F35384FC419606847EA5AA038D9E6031", hash_generated_method = "FB3CBAFBF39C21F2E8F3F0C0173DC3ED")
        private void throwEglException(String function, int error) {
            addTaint(error);
            addTaint(function.getTaint());
            String message = function + " failed: " + EGLLogWrapper.getErrorString(error);
            if(LOG_THREADS)            
            {
            } //End block
            RuntimeException var84ECB4EA3AEDFA95D03DB645F86E7A03_1970956008 = new RuntimeException(message);
            var84ECB4EA3AEDFA95D03DB645F86E7A03_1970956008.addTaint(taint);
            throw var84ECB4EA3AEDFA95D03DB645F86E7A03_1970956008;
            // ---------- Original Method ----------
            //String message = function + " failed: " + EGLLogWrapper.getErrorString(error);
            //if (LOG_THREADS) {
                //Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + message);
            //}
            //throw new RuntimeException(message);
        }

        
    }


    
    class GLThread extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.285 -0400", hash_original_field = "03C8DCC0F9493C50A84BCF1F4E8E229C", hash_generated_field = "3667C8CDBEE9DD6DA201BBB06F975F88")

        private boolean mShouldExit;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.285 -0400", hash_original_field = "AD23CAFDFAE9C0DA6D8CEC3B08707FDF", hash_generated_field = "44F266F0432C0EFD235C8183DD0B51A1")

        private boolean mExited;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "30D1847E0290105F3B9B8676E3AFCAA6", hash_generated_field = "99FD2263A5DF98BA94E8C373CDA953C3")

        private boolean mRequestPaused;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "C63FAC2D0F128E9B6E2F15328412486E", hash_generated_field = "9B834AB9E5C00250542F8DEB91ED0E2F")

        private boolean mPaused;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "92E8233E4109DEA7BF94A50FB880EAAF", hash_generated_field = "514F0E2FF657C1E2926C625EE0C2A55C")

        private boolean mHasSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "91FB19363A4CA06D9630765788822666", hash_generated_field = "F1D840BEC01E65E93A488E3A6D14D736")

        private boolean mWaitingForSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "85A58953641EE773213E0169C04298C0", hash_generated_field = "4A2A91067D7B18BAA9311207F028FEDC")

        private boolean mHaveEglContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "732FA2CB377F4076702DB198BBAFB796", hash_generated_field = "A6F3B75A3C62BDC269D81AE3192A2B1E")

        private boolean mHaveEglSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "1E6FD1CBE9E1B8E0EB54A9A9930992A1", hash_generated_field = "AEDBAD4E651BFDC4A3C0A200EA9340E8")

        private boolean mShouldReleaseEglContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "41FC831CD43FBC2D6B8A4F11E317F0CB", hash_generated_field = "E7653EB9F9A1926DBAF869454A58408B")

        private int mRenderMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.286 -0400", hash_original_field = "78E2E9963CEF8F0171CFCDB844AB4109", hash_generated_field = "04D0EE4906FBC2F004DE3C4AF5DBCC4F")

        private boolean mRequestRender;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.287 -0400", hash_original_field = "67FE5CFF9C9E360E840CD08B34D5C93B", hash_generated_field = "1E19E103716E35A6AED458C0663993A3")

        private boolean mRenderComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.287 -0400", hash_original_field = "FDA19F13168E30C2514B58400D500234", hash_generated_field = "B5F71D74E6909FCC5E419B53FBFAF01C")

        private ArrayList<Runnable> mEventQueue = new ArrayList<Runnable>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.287 -0400", hash_original_field = "D9CFA901A96C28EEA9DD412429CB9486", hash_generated_field = "655D7742BDF0154D755D8012DFB26E60")

        private Renderer mRenderer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.287 -0400", hash_original_field = "0DA78C5CD7DC54879FBBDF81391F2D07", hash_generated_field = "643AE0FAB78B60A315CA9AB4E93467B6")

        private EglHelper mEglHelper;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.288 -0400", hash_original_method = "6338646405C7F70E0BB13ECBAEE65220", hash_generated_method = "80DB93F37804331BA8F7D20F46ACC102")
          GLThread(Renderer renderer) {
            super();
            mWidth = 0;
            mHeight = 0;
            mRequestRender = true;
            mRenderMode = RENDERMODE_CONTINUOUSLY;
            mRenderer = renderer;
            // ---------- Original Method ----------
            //mWidth = 0;
            //mHeight = 0;
            //mRequestRender = true;
            //mRenderMode = RENDERMODE_CONTINUOUSLY;
            //mRenderer = renderer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.288 -0400", hash_original_method = "4EBF7F6B9BB16BE66D221453F245DA46", hash_generated_method = "550DD3240C41D167A1DDF31588BE6F1A")
        @Override
        public void run() {
            setName("GLThread " + getId());
            if(LOG_THREADS)            
            {
            } //End block
            try 
            {
                guardedRun();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            finally 
            {
                sGLThreadManager.threadExiting(this);
            } //End block
            // ---------- Original Method ----------
            //setName("GLThread " + getId());
            //if (LOG_THREADS) {
                //Log.i("GLThread", "starting tid=" + getId());
            //}
            //try {
                //guardedRun();
            //} catch (InterruptedException e) {
            //} finally {
                //sGLThreadManager.threadExiting(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.289 -0400", hash_original_method = "1FA739F1ECF9B8C719EEC300CFB94B99", hash_generated_method = "7C2EBA300F9F2362B5C6814AEBE0C1BB")
        private void stopEglSurfaceLocked() {
            if(mHaveEglSurface)            
            {
                mHaveEglSurface = false;
                mEglHelper.destroySurface();
            } //End block
            // ---------- Original Method ----------
            //if (mHaveEglSurface) {
                //mHaveEglSurface = false;
                //mEglHelper.destroySurface();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.289 -0400", hash_original_method = "08753DB570F3FF0DFFEC96C08E49FCF2", hash_generated_method = "272A4019F75A39A8226A3A23B7805B77")
        private void stopEglContextLocked() {
            if(mHaveEglContext)            
            {
                mEglHelper.finish();
                mHaveEglContext = false;
                sGLThreadManager.releaseEglContextLocked(this);
            } //End block
            // ---------- Original Method ----------
            //if (mHaveEglContext) {
                //mEglHelper.finish();
                //mHaveEglContext = false;
                //sGLThreadManager.releaseEglContextLocked(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.297 -0400", hash_original_method = "711FE3C53AF4E351881864AF0E3340A2", hash_generated_method = "F6D2EDD702F236F7FE5B1AB3BD520CCA")
        private void guardedRun() throws InterruptedException {
            mEglHelper = new EglHelper();
            mHaveEglContext = false;
            mHaveEglSurface = false;
            try 
            {
                GL10 gl = null;
                boolean createEglContext = false;
                boolean createEglSurface = false;
                boolean lostEglContext = false;
                boolean sizeChanged = false;
                boolean wantRenderNotification = false;
                boolean doRenderNotification = false;
                boolean askedToReleaseEglContext = false;
                int w = 0;
                int h = 0;
                Runnable event = null;
                while
(true)                
                {
                    synchronized
(sGLThreadManager)                    {
                        while
(true)                        
                        {
                            if(mShouldExit)                            
                            {
                                return;
                            } //End block
                            if(! mEventQueue.isEmpty())                            
                            {
                                event = mEventQueue.remove(0);
                                break;
                            } //End block
                            if(mPaused != mRequestPaused)                            
                            {
                                mPaused = mRequestPaused;
                                sGLThreadManager.notifyAll();
                                if(LOG_PAUSE_RESUME)                                
                                {
                                } //End block
                            } //End block
                            if(mShouldReleaseEglContext)                            
                            {
                                if(LOG_SURFACE)                                
                                {
                                } //End block
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                mShouldReleaseEglContext = false;
                                askedToReleaseEglContext = true;
                            } //End block
                            if(lostEglContext)                            
                            {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                lostEglContext = false;
                            } //End block
                            if(mHaveEglSurface && mPaused)                            
                            {
                                if(LOG_SURFACE)                                
                                {
                                } //End block
                                stopEglSurfaceLocked();
                                if(!mPreserveEGLContextOnPause || sGLThreadManager.shouldReleaseEGLContextWhenPausing())                                
                                {
                                    stopEglContextLocked();
                                    if(LOG_SURFACE)                                    
                                    {
                                    } //End block
                                } //End block
                                if(sGLThreadManager.shouldTerminateEGLWhenPausing())                                
                                {
                                    mEglHelper.finish();
                                    if(LOG_SURFACE)                                    
                                    {
                                    } //End block
                                } //End block
                            } //End block
                            if((! mHasSurface) && (! mWaitingForSurface))                            
                            {
                                if(LOG_SURFACE)                                
                                {
                                } //End block
                                if(mHaveEglSurface)                                
                                {
                                    stopEglSurfaceLocked();
                                } //End block
                                mWaitingForSurface = true;
                                sGLThreadManager.notifyAll();
                            } //End block
                            if(mHasSurface && mWaitingForSurface)                            
                            {
                                if(LOG_SURFACE)                                
                                {
                                } //End block
                                mWaitingForSurface = false;
                                sGLThreadManager.notifyAll();
                            } //End block
                            if(doRenderNotification)                            
                            {
                                if(LOG_SURFACE)                                
                                {
                                } //End block
                                wantRenderNotification = false;
                                doRenderNotification = false;
                                mRenderComplete = true;
                                sGLThreadManager.notifyAll();
                            } //End block
                            if(readyToDraw())                            
                            {
                                if(! mHaveEglContext)                                
                                {
                                    if(askedToReleaseEglContext)                                    
                                    {
                                        askedToReleaseEglContext = false;
                                    } //End block
                                    else
                                    if(sGLThreadManager.tryAcquireEglContextLocked(this))                                    
                                    {
                                        try 
                                        {
                                            mEglHelper.start();
                                        } //End block
                                        catch (RuntimeException t)
                                        {
                                            sGLThreadManager.releaseEglContextLocked(this);
                                            t.addTaint(taint);
                                            throw t;
                                        } //End block
                                        mHaveEglContext = true;
                                        createEglContext = true;
                                        sGLThreadManager.notifyAll();
                                    } //End block
                                } //End block
                                if(mHaveEglContext && !mHaveEglSurface)                                
                                {
                                    mHaveEglSurface = true;
                                    createEglSurface = true;
                                    sizeChanged = true;
                                } //End block
                                if(mHaveEglSurface)                                
                                {
                                    if(mSizeChanged)                                    
                                    {
                                        sizeChanged = true;
                                        w = mWidth;
                                        h = mHeight;
                                        wantRenderNotification = true;
                                        if(LOG_SURFACE)                                        
                                        {
                                        } //End block
                                        if(DRAW_TWICE_AFTER_SIZE_CHANGED)                                        
                                        {
                                        } //End block
                                        else
                                        {
                                            mRequestRender = false;
                                        } //End block
                                        mSizeChanged = false;
                                    } //End block
                                    else
                                    {
                                        mRequestRender = false;
                                    } //End block
                                    sGLThreadManager.notifyAll();
                                    break;
                                } //End block
                            } //End block
                            if(LOG_THREADS)                            
                            {
                            } //End block
                            sGLThreadManager.wait();
                        } //End block
                    } //End block
                    if(event != null)                    
                    {
                        event.run();
                        event = null;
                        continue;
                    } //End block
                    if(createEglSurface)                    
                    {
                        if(LOG_SURFACE)                        
                        {
                        } //End block
                        gl = (GL10) mEglHelper.createSurface(getHolder());
                        if(gl == null)                        
                        {
                            break;
                        } //End block
                        sGLThreadManager.checkGLDriver(gl);
                        createEglSurface = false;
                    } //End block
                    if(createEglContext)                    
                    {
                        if(LOG_RENDERER)                        
                        {
                        } //End block
                        mRenderer.onSurfaceCreated(gl, mEglHelper.mEglConfig);
                        createEglContext = false;
                    } //End block
                    if(sizeChanged)                    
                    {
                        if(LOG_RENDERER)                        
                        {
                        } //End block
                        mEglHelper.purgeBuffers();
                        mRenderer.onSurfaceChanged(gl, w, h);
                        sizeChanged = false;
                    } //End block
                    if(LOG_RENDERER_DRAW_FRAME)                    
                    {
                    } //End block
                    mRenderer.onDrawFrame(gl);
                    if(!mEglHelper.swap())                    
                    {
                        if(LOG_SURFACE)                        
                        {
                        } //End block
                        lostEglContext = true;
                    } //End block
                    if(wantRenderNotification)                    
                    {
                        doRenderNotification = true;
                    } //End block
                } //End block
            } //End block
            finally 
            {
                synchronized
(sGLThreadManager)                {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.300 -0400", hash_original_method = "9F067F2F4ACE6678B9A9189C7770DD17", hash_generated_method = "1EA34AEB46E3F1251D6513B18B68A8FD")
        public boolean ableToDraw() {
            boolean var5F1ABFBC88B23B99E2A7E27390E942A3_1358774056 = (mHaveEglContext && mHaveEglSurface && readyToDraw());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154041558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_154041558;
            // ---------- Original Method ----------
            //return mHaveEglContext && mHaveEglSurface && readyToDraw();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.300 -0400", hash_original_method = "0EE68488D52C3628D006C7323CA4E5A0", hash_generated_method = "9FCE4B3BBBBE91BC37260A7396F45573")
        private boolean readyToDraw() {
            boolean varD45A9E3CBAE4F7104CD510795BE80E11_1175313808 = ((!mPaused) && mHasSurface
                && (mWidth > 0) && (mHeight > 0)
                && (mRequestRender || (mRenderMode == RENDERMODE_CONTINUOUSLY)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043290882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043290882;
            // ---------- Original Method ----------
            //return (!mPaused) && mHasSurface
                //&& (mWidth > 0) && (mHeight > 0)
                //&& (mRequestRender || (mRenderMode == RENDERMODE_CONTINUOUSLY));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.301 -0400", hash_original_method = "DBFC9FD50E90875659CDDCEC9AA517CD", hash_generated_method = "A0598CEAB182508A3E2F4480E07E07DF")
        public void setRenderMode(int renderMode) {
            if(!((RENDERMODE_WHEN_DIRTY <= renderMode) && (renderMode <= RENDERMODE_CONTINUOUSLY)))            
            {
                IllegalArgumentException varD1745A7B694DCD88F753C18B115204C5_86376250 = new IllegalArgumentException("renderMode");
                varD1745A7B694DCD88F753C18B115204C5_86376250.addTaint(taint);
                throw varD1745A7B694DCD88F753C18B115204C5_86376250;
            } //End block
            synchronized
(sGLThreadManager)            {
                mRenderMode = renderMode;
                sGLThreadManager.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //if ( !((RENDERMODE_WHEN_DIRTY <= renderMode) && (renderMode <= RENDERMODE_CONTINUOUSLY)) ) {
                //throw new IllegalArgumentException("renderMode");
            //}
            //synchronized(sGLThreadManager) {
                //mRenderMode = renderMode;
                //sGLThreadManager.notifyAll();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.302 -0400", hash_original_method = "FE0099A91432BFCACE7C52B0FC1032B6", hash_generated_method = "4FD81BB85ED3F71CEA9B04705FAF85F2")
        public int getRenderMode() {
            synchronized
(sGLThreadManager)            {
                int var41FC831CD43FBC2D6B8A4F11E317F0CB_1307959706 = (mRenderMode);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826746069 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826746069;
            } //End block
            // ---------- Original Method ----------
            //synchronized(sGLThreadManager) {
                //return mRenderMode;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.302 -0400", hash_original_method = "7D299D0786810F42249F0484E8A25CD9", hash_generated_method = "B061E14E0CD495481C41ADB81AB3BDD1")
        public void requestRender() {
            synchronized
(sGLThreadManager)            {
                mRequestRender = true;
                sGLThreadManager.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //synchronized(sGLThreadManager) {
                //mRequestRender = true;
                //sGLThreadManager.notifyAll();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.303 -0400", hash_original_method = "E700922CB1559E30A5B5551273407803", hash_generated_method = "79A94C3337392F6E847F450AB08DCCDC")
        public void surfaceCreated() {
            synchronized
(sGLThreadManager)            {
                if(LOG_THREADS)                
                {
                } //End block
                mHasSurface = true;
                sGLThreadManager.notifyAll();
                while
((mWaitingForSurface) && (!mExited))                
                {
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(sGLThreadManager) {
                //if (LOG_THREADS) {
                    //Log.i("GLThread", "surfaceCreated tid=" + getId());
                //}
                //mHasSurface = true;
                //sGLThreadManager.notifyAll();
                //while((mWaitingForSurface) && (!mExited)) {
                    //try {
                        //sGLThreadManager.wait();
                    //} catch (InterruptedException e) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.305 -0400", hash_original_method = "CF6F3A984F95B50FF50C1BADBEA0D748", hash_generated_method = "8B8691B0B5A79F9BCF82B11B9D531A03")
        public void surfaceDestroyed() {
            synchronized
(sGLThreadManager)            {
                if(LOG_THREADS)                
                {
                } //End block
                mHasSurface = false;
                sGLThreadManager.notifyAll();
                while
((!mWaitingForSurface) && (!mExited))                
                {
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(sGLThreadManager) {
                //if (LOG_THREADS) {
                    //Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                //}
                //mHasSurface = false;
                //sGLThreadManager.notifyAll();
                //while((!mWaitingForSurface) && (!mExited)) {
                    //try {
                        //sGLThreadManager.wait();
                    //} catch (InterruptedException e) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.306 -0400", hash_original_method = "C67CE20F9EC18CF1CF416A1853C3B589", hash_generated_method = "186DAF0D2A1313F1C6758DAF78FC2EDA")
        public void onPause() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            synchronized
(sGLThreadManager)            {
                if(LOG_PAUSE_RESUME)                
                {
                } //End block
                mRequestPaused = true;
                sGLThreadManager.notifyAll();
                while
((! mExited) && (! mPaused))                
                {
                    if(LOG_PAUSE_RESUME)                    
                    {
                    } //End block
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (sGLThreadManager) {
                //if (LOG_PAUSE_RESUME) {
                    //Log.i("GLThread", "onPause tid=" + getId());
                //}
                //mRequestPaused = true;
                //sGLThreadManager.notifyAll();
                //while ((! mExited) && (! mPaused)) {
                    //if (LOG_PAUSE_RESUME) {
                        //Log.i("Main thread", "onPause waiting for mPaused.");
                    //}
                    //try {
                        //sGLThreadManager.wait();
                    //} catch (InterruptedException ex) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.306 -0400", hash_original_method = "8E5DEB2C9B7EC152BCE3E0DC74768ADB", hash_generated_method = "A4140363D9851395C6C0B8362748A2CC")
        public void onResume() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            synchronized
(sGLThreadManager)            {
                if(LOG_PAUSE_RESUME)                
                {
                } //End block
                mRequestPaused = false;
                mRequestRender = true;
                mRenderComplete = false;
                sGLThreadManager.notifyAll();
                while
((! mExited) && mPaused && (!mRenderComplete))                
                {
                    if(LOG_PAUSE_RESUME)                    
                    {
                    } //End block
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (sGLThreadManager) {
                //if (LOG_PAUSE_RESUME) {
                    //Log.i("GLThread", "onResume tid=" + getId());
                //}
                //mRequestPaused = false;
                //mRequestRender = true;
                //mRenderComplete = false;
                //sGLThreadManager.notifyAll();
                //while ((! mExited) && mPaused && (!mRenderComplete)) {
                    //if (LOG_PAUSE_RESUME) {
                        //Log.i("Main thread", "onResume waiting for !mPaused.");
                    //}
                    //try {
                        //sGLThreadManager.wait();
                    //} catch (InterruptedException ex) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.308 -0400", hash_original_method = "E1DF3790FCF903F4369120E3C31DD321", hash_generated_method = "48770806661BD7137AE9CE568E7FC935")
        public void onWindowResize(int w, int h) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            synchronized
(sGLThreadManager)            {
                mWidth = w;
                mHeight = h;
                mSizeChanged = true;
                mRequestRender = true;
                mRenderComplete = false;
                sGLThreadManager.notifyAll();
                while
(! mExited && !mPaused && !mRenderComplete
                        && (mGLThread != null && mGLThread.ableToDraw()))                
                {
                    if(LOG_SURFACE)                    
                    {
                    } //End block
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.308 -0400", hash_original_method = "B658ED85C2522980AFFC21FA75A8FE5F", hash_generated_method = "734C939D3D6EF58FCE8C32AA19AE19E9")
        public void requestExitAndWait() {
            synchronized
(sGLThreadManager)            {
                mShouldExit = true;
                sGLThreadManager.notifyAll();
                while
(! mExited)                
                {
                    try 
                    {
                        sGLThreadManager.wait();
                    } //End block
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(sGLThreadManager) {
                //mShouldExit = true;
                //sGLThreadManager.notifyAll();
                //while (! mExited) {
                    //try {
                        //sGLThreadManager.wait();
                    //} catch (InterruptedException ex) {
                        //Thread.currentThread().interrupt();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.309 -0400", hash_original_method = "9327C398D00F21C8F0D3A5F602389F52", hash_generated_method = "859D4162BE0DBF24AB151CDCBA2CD53F")
        public void requestReleaseEglContextLocked() {
            mShouldReleaseEglContext = true;
            sGLThreadManager.notifyAll();
            // ---------- Original Method ----------
            //mShouldReleaseEglContext = true;
            //sGLThreadManager.notifyAll();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.309 -0400", hash_original_method = "8F41524AB3CEE2918675BC83BF3CC490", hash_generated_method = "0BF27D5A5D5DC723EC705E2012C51E0B")
        public void queueEvent(Runnable r) {
            addTaint(r.getTaint());
            if(r == null)            
            {
                IllegalArgumentException var7FDAB28161AE6C8597C19A745D4066A2_292219424 = new IllegalArgumentException("r must not be null");
                var7FDAB28161AE6C8597C19A745D4066A2_292219424.addTaint(taint);
                throw var7FDAB28161AE6C8597C19A745D4066A2_292219424;
            } //End block
            synchronized
(sGLThreadManager)            {
                mEventQueue.add(r);
                sGLThreadManager.notifyAll();
            } //End block
            // ---------- Original Method ----------
            //if (r == null) {
                //throw new IllegalArgumentException("r must not be null");
            //}
            //synchronized(sGLThreadManager) {
                //mEventQueue.add(r);
                //sGLThreadManager.notifyAll();
            //}
        }

        
    }


    
    static class LogWriter extends Writer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.310 -0400", hash_original_field = "4F0F394E09EF59EAD1F09E9AE4D05150", hash_generated_field = "93EF782A08ECBADA45732AEB26C05023")

        private StringBuilder mBuilder = new StringBuilder();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.310 -0400", hash_original_method = "17A1C7BC31C04C9AEB1C6A159FE1E12E", hash_generated_method = "17A1C7BC31C04C9AEB1C6A159FE1E12E")
        public LogWriter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.310 -0400", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "D08D7FDC7D86BF10CFE149353B975CA7")
        @Override
        public void close() {
            flushBuilder();
            // ---------- Original Method ----------
            //flushBuilder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.310 -0400", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "97F56083B0C8ACED57AE8237C5E7EFB5")
        @Override
        public void flush() {
            flushBuilder();
            // ---------- Original Method ----------
            //flushBuilder();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "9BDF1371A8F52A0B4DB9441B7A707252")
        @Override
        public void write(char[] buf, int offset, int count) {
            addTaint(count);
            addTaint(offset);
            addTaint(buf[0]);
for(int i = 0;i < count;i++)
            {
                char c = buf[offset + i];
                if(c == '\n')                
                {
                    flushBuilder();
                } //End block
                else
                {
                    mBuilder.append(c);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //for(int i = 0; i < count; i++) {
                //char c = buf[offset + i];
                //if ( c == '\n') {
                    //flushBuilder();
                //}
                //else {
                    //mBuilder.append(c);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_method = "E3A61F648C50A4FD42F02D92C137403F", hash_generated_method = "604770BBA3EC8093548B9883BDD7DCF6")
        private void flushBuilder() {
            if(mBuilder.length() > 0)            
            {
                mBuilder.delete(0, mBuilder.length());
            } //End block
            // ---------- Original Method ----------
            //if (mBuilder.length() > 0) {
                //Log.v("GLSurfaceView", mBuilder.toString());
                //mBuilder.delete(0, mBuilder.length());
            //}
        }

        
    }


    
    private static class GLThreadManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_field = "B2F8656BEA454D1646D6A21F0BA59A6F", hash_generated_field = "F73A6B8127F542A081B6A62FA30A43F7")

        private boolean mGLESVersionCheckComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_field = "041C9CA91D021E56FD641C682F911049", hash_generated_field = "B4C54A4CB01F0BC9B76DECECD129FF44")

        private int mGLESVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_field = "1B1F84B94581F10ADD44E8287312BED9", hash_generated_field = "446C076A6568D35915B8ED59A92E0AA9")

        private boolean mGLESDriverCheckComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_field = "C6B5F8CACA605F27C17B6D55449A1939", hash_generated_field = "682D31F8601D77498A0A2F017F5AF89E")

        private boolean mMultipleGLESContextsAllowed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.311 -0400", hash_original_field = "A9EFE93895F3A53C29BDAB72648B5FDA", hash_generated_field = "34CA86E2F3B4D626596C357B4FA1E7A5")

        private boolean mLimitedGLESContexts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.312 -0400", hash_original_field = "C06432921F949FA93568F2C366C90611", hash_generated_field = "648BA99AC2147F67E5271F329D877F61")

        private GLThread mEglOwner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.312 -0400", hash_original_method = "5D6BCD582D13070585FC5F161A43B68D", hash_generated_method = "5D6BCD582D13070585FC5F161A43B68D")
        public GLThreadManager ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.312 -0400", hash_original_method = "FE8705658DEAD61621738F4D8A2A7147", hash_generated_method = "29D8A8F475D3E7C44E72CDC33E671C23")
        public synchronized void threadExiting(GLThread thread) {
            addTaint(thread.getTaint());
            if(LOG_THREADS)            
            {
            } //End block
            thread.mExited = true;
            if(mEglOwner == thread)            
            {
                mEglOwner = null;
            } //End block
            notifyAll();
            // ---------- Original Method ----------
            //if (LOG_THREADS) {
                //Log.i("GLThread", "exiting tid=" +  thread.getId());
            //}
            //thread.mExited = true;
            //if (mEglOwner == thread) {
                //mEglOwner = null;
            //}
            //notifyAll();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.313 -0400", hash_original_method = "BB464B3FFF506A1CF7A316246B2050CF", hash_generated_method = "85270BE6A21C1C664C07754013ACFA1C")
        public boolean tryAcquireEglContextLocked(GLThread thread) {
            if(mEglOwner == thread || mEglOwner == null)            
            {
                mEglOwner = thread;
                notifyAll();
                boolean varB326B5062B2F0E69046810717534CB09_1563867351 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415393011 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_415393011;
            } //End block
            checkGLESVersion();
            if(mMultipleGLESContextsAllowed)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1093923281 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665700714 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_665700714;
            } //End block
            if(mEglOwner != null)            
            {
                mEglOwner.requestReleaseEglContextLocked();
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_118334460 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284502855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284502855;
            // ---------- Original Method ----------
            //if (mEglOwner == thread || mEglOwner == null) {
                //mEglOwner = thread;
                //notifyAll();
                //return true;
            //}
            //checkGLESVersion();
            //if (mMultipleGLESContextsAllowed) {
                //return true;
            //}
            //if (mEglOwner != null) {
                //mEglOwner.requestReleaseEglContextLocked();
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.313 -0400", hash_original_method = "3F74D4F9D098B5B4B240AE885DDBE7E6", hash_generated_method = "DDDEEFB1E851589A136B3AB748BF49DD")
        public void releaseEglContextLocked(GLThread thread) {
            addTaint(thread.getTaint());
            if(mEglOwner == thread)            
            {
                mEglOwner = null;
            } //End block
            notifyAll();
            // ---------- Original Method ----------
            //if (mEglOwner == thread) {
                //mEglOwner = null;
            //}
            //notifyAll();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.313 -0400", hash_original_method = "12EA186A7F5CD9C6E3046A2A0BD2DF68", hash_generated_method = "0CFDE167BB7C89A1E70C2BE11E89FA0C")
        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            boolean varA9EFE93895F3A53C29BDAB72648B5FDA_1715345916 = (mLimitedGLESContexts);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980122687 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980122687;
            // ---------- Original Method ----------
            //return mLimitedGLESContexts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.314 -0400", hash_original_method = "BB392C65C3FB4BE472C770A6388E6483", hash_generated_method = "7DF816D2C9AA4194DB92CADA46E5AC87")
        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            boolean varEAD339743B9D665A815133F1B9D8AD4E_110268789 = (!mMultipleGLESContextsAllowed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901230447 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901230447;
            // ---------- Original Method ----------
            //checkGLESVersion();
            //return !mMultipleGLESContextsAllowed;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.314 -0400", hash_original_method = "3071AD09B063784236EDA64AF3B8A081", hash_generated_method = "ACB68AC38CE55DB9C98558ECF8E21312")
        public synchronized void checkGLDriver(GL10 gl) {
            addTaint(gl.getTaint());
            if(! mGLESDriverCheckComplete)            
            {
                checkGLESVersion();
                String renderer = gl.glGetString(GL10.GL_RENDERER);
                if(mGLESVersion < kGLES_20)                
                {
                    mMultipleGLESContextsAllowed =
                        ! renderer.startsWith(kMSM7K_RENDERER_PREFIX);
                    notifyAll();
                } //End block
                mLimitedGLESContexts = !mMultipleGLESContextsAllowed || renderer.startsWith(kADRENO);
                if(LOG_SURFACE)                
                {
                } //End block
                mGLESDriverCheckComplete = true;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_method = "6DFB699ADC87072E31136271B3768D35", hash_generated_method = "25C35E5FCEB1923EE90EF372FCA4FDC1")
        private void checkGLESVersion() {
            if(! mGLESVersionCheckComplete)            
            {
                mGLESVersion = SystemProperties.getInt(
                        "ro.opengles.version",
                        ConfigurationInfo.GL_ES_VERSION_UNDEFINED);
                if(mGLESVersion >= kGLES_20)                
                {
                    mMultipleGLESContextsAllowed = true;
                } //End block
                if(LOG_SURFACE)                
                {
                } //End block
                mGLESVersionCheckComplete = true;
            } //End block
            // ---------- Original Method ----------
            //if (! mGLESVersionCheckComplete) {
                //mGLESVersion = SystemProperties.getInt(
                        //"ro.opengles.version",
                        //ConfigurationInfo.GL_ES_VERSION_UNDEFINED);
                //if (mGLESVersion >= kGLES_20) {
                    //mMultipleGLESContextsAllowed = true;
                //}
                //if (LOG_SURFACE) {
                    //Log.w(TAG, "checkGLESVersion mGLESVersion =" +
                            //" " + mGLESVersion + " mMultipleGLESContextsAllowed = " + mMultipleGLESContextsAllowed);
                //}
                //mGLESVersionCheckComplete = true;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "3788EFB80D2324813CE3E57505A3CC89", hash_generated_field = "9D735A32CC6365416B5A8B54E94812D1")

        private static String TAG = "GLThreadManager";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "A08019EDBD7CCFC9A45261584235B8E2", hash_generated_field = "44145C195E85BF38DA0FFB2AC8BB4311")

        private static final int kGLES_20 = 0x20000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "DCDAA896FD82C36594EBA69BB60C8791", hash_generated_field = "3621160A8F7B1BD84A2A6958E68DD5EA")

        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "2C053DE959A73C3FC58A287C9044FBC0", hash_generated_field = "F329DF17B4230EF2C98D0E995B680386")

        private static final String kADRENO = "Adreno";
    }


    
    public interface GLWrapper {
        
        GL wrap(GL gl);
    }
    
    public interface Renderer {
        
        void onSurfaceCreated(GL10 gl, EGLConfig config);

        
        void onSurfaceChanged(GL10 gl, int width, int height);

        
        void onDrawFrame(GL10 gl);
    }
    
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig);
        void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context);
    }
    
    public interface EGLWindowSurfaceFactory {
        
        EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config,
                Object nativeWindow);
        void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface);
    }
    
    public interface EGLConfigChooser {
        
        EGLConfig chooseConfig(EGL10 egl, EGLDisplay display);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "A85F078E9128963B5B1EE6472E6EE647", hash_generated_field = "4034EC823D59F85BB049B0361EB812F4")

    private final static String TAG = "GLSurfaceView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "93D0021D19C4F5432347E9751CB3CA6E", hash_generated_field = "1EE3A05D4667F28D82E3A91570ACECC2")

    private final static boolean LOG_ATTACH_DETACH = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "E9296F230F213EF46F3E97C858160AE6", hash_generated_field = "7A59CB5BFE26193256ADA36CA0D612E2")

    private final static boolean LOG_THREADS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "91C4A3A4FE21E1D816A68B6547220D84", hash_generated_field = "FBAB33E8D4FA0CCAEA6311BEFEA4806A")

    private final static boolean LOG_PAUSE_RESUME = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "CC2A60A081DCC3FA2FEB3DB8094658C7", hash_generated_field = "0509E45F538814A0914CCDF76BF039B0")

    private final static boolean LOG_SURFACE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.315 -0400", hash_original_field = "C489CB25497FF7DECC795C8FE599D59A", hash_generated_field = "7733B6AF262A325B4E3B0B3F5F6ABFD4")

    private final static boolean LOG_RENDERER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "99CC802813ADF46B15AB799A700005E3", hash_generated_field = "9767E7A30553B720521176A0B1C7A7DF")

    private final static boolean LOG_RENDERER_DRAW_FRAME = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "3F51157E6F7F900729E5CB8E7DA66F0C", hash_generated_field = "6374488C33DF12121CA7B9425BE95249")

    private final static boolean LOG_EGL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "D639469F97317BAA7E42513E2437DECC", hash_generated_field = "0E2BD5A2E10A5705ABDA8B3F88084518")

    private final static boolean DRAW_TWICE_AFTER_SIZE_CHANGED = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "3295D6273F4F06A0AE7E1B09D5271B7F", hash_generated_field = "14B58EB967907A856FA213C29C42BA45")

    public final static int RENDERMODE_WHEN_DIRTY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "5E9CD6BECEA1F2F43905E5B61C743C70", hash_generated_field = "560E958618800A224F6FD592043FEB61")

    public final static int RENDERMODE_CONTINUOUSLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "D963F9F4A8F1C94946858FB46774A9D8", hash_generated_field = "5D4C6365859FA1400C6019E0BBDAC737")

    public final static int DEBUG_CHECK_GL_ERROR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "97CD2CD9FAA40055EFBAB76686C7B24A", hash_generated_field = "D663A579D7909EF5537DE06901903309")

    public final static int DEBUG_LOG_GL_CALLS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.316 -0400", hash_original_field = "2879BE5A8901E264BE3DB12CA95C0872", hash_generated_field = "2A611276FE9639F8735EA60D1E43AEA3")

    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
}

