package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import static javax.microedition.khronos.egl.EGL10.EGL_ALPHA_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_BAD_NATIVE_WINDOW;
import static javax.microedition.khronos.egl.EGL10.EGL_BLUE_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
import static javax.microedition.khronos.egl.EGL10.EGL_DEPTH_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_DRAW;
import static javax.microedition.khronos.egl.EGL10.EGL_GREEN_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_HEIGHT;
import static javax.microedition.khronos.egl.EGL10.EGL_NONE;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
import static javax.microedition.khronos.egl.EGL10.EGL_RED_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_RENDERABLE_TYPE;
import static javax.microedition.khronos.egl.EGL10.EGL_STENCIL_SIZE;
import static javax.microedition.khronos.egl.EGL10.EGL_SUCCESS;
import static javax.microedition.khronos.egl.EGL10.EGL_WIDTH;
import static javax.microedition.khronos.egl.EGL10.EGL_WINDOW_BIT;

import java.io.File;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

import android.content.ComponentCallbacks2;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import android.opengl.ManagedEGLContext;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;

import com.google.android.gles_jni.EGLImpl;






public abstract class HardwareRenderer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.525 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.525 -0400", hash_original_field = "49AC8048BC7573882A7251630928EF32", hash_generated_field = "1A824CB4728D8EA1700C48FC56A6A4D0")

    private boolean mRequested = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.525 -0400", hash_original_method = "E06114671092584077A71408305BD1AB", hash_generated_method = "E06114671092584077A71408305BD1AB")
    public HardwareRenderer ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public static void disable(boolean system) {
        sRendererDisabled = true;
        if (system) {
            sSystemRendererDisabled = true;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isAvailable() {
        return GLES20Canvas.isAvailable();
    }

    
    @DSModeled(DSC.SAFE)
    abstract void destroy(boolean full);

    
    @DSModeled(DSC.SAFE)
    abstract boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException;

    
    @DSModeled(DSC.SAFE)
    abstract void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException;

    
    @DSModeled(DSC.SAFE)
    abstract void destroyLayers(View view);

    
    @DSModeled(DSC.SAFE)
    abstract void destroyHardwareResources(View view);

    
    @DSModeled(DSC.SAFE)
    abstract void invalidate(SurfaceHolder holder);

    
    @DSModeled(DSC.SAFE)
    abstract boolean validate();

    
    @DSModeled(DSC.SAFE)
    abstract void setup(int width, int height);

    
    @DSModeled(DSC.SAFE)
    abstract int getWidth();

    
    @DSModeled(DSC.SAFE)
    abstract int getHeight();

    
    @DSModeled(DSC.SAFE)
    abstract HardwareCanvas getCanvas();

    
    @DSModeled(DSC.SAFE)
    public static void setupDiskCache(File cacheDir) {
        nSetupShadersDiskCache(new File(cacheDir, CACHE_PATH_SHADERS).getAbsolutePath());
    }

    
    @DSModeled(DSC.SAFE)
    private static void nSetupShadersDiskCache(String cacheFile) {
    }

    
    @DSModeled(DSC.SAFE)
    abstract boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
            Rect dirty);

    
    @DSModeled(DSC.SAFE)
    abstract DisplayList createDisplayList();

    
    @DSModeled(DSC.SAFE)
    abstract HardwareLayer createHardwareLayer(boolean isOpaque);

    
    @DSModeled(DSC.SAFE)
    abstract HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque);

    
    @DSModeled(DSC.SAFE)
    abstract SurfaceTexture createSurfaceTexture(HardwareLayer layer);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.528 -0400", hash_original_method = "9B70801888A6ED6A8A5716CEEB0139B3", hash_generated_method = "62F0EA9D5243A969E29E78495E138746")
     void initializeIfNeeded(int width, int height, View.AttachInfo attachInfo,
            SurfaceHolder holder) throws Surface.OutOfResourcesException {
        addTaint(holder.getTaint());
        addTaint(attachInfo.getTaint());
        addTaint(height);
        addTaint(width);
        if(isRequested())        
        {
            if(!isEnabled())            
            {
                if(initialize(holder))                
                {
                    setup(width, height);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (isRequested()) {
            //if (!isEnabled()) {
                //if (initialize(holder)) {
                    //setup(width, height);
                //}
            //}
        //}
    }

    
    static HardwareRenderer createGlRenderer(int glVersion, boolean translucent) {
        switch (glVersion) {
            case 2:
                return Gl20Renderer.create(translucent);
        }
        throw new IllegalArgumentException("Unknown GL version: " + glVersion);
    }

    
    static void trimMemory(int level) {
        Gl20Renderer.trimMemory(level);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.528 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "28BA4F48C19A4DD28D558050F9D65010")
     boolean isEnabled() {
        boolean var6F84A7F10C955D3C78F44E5278F6195B_1542051353 = (mEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966434404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966434404;
        // ---------- Original Method ----------
        //return mEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.529 -0400", hash_original_method = "E431274334564F99DE06BE0647F24670", hash_generated_method = "C2CE1DB1D0D5E01CA74F489F1351598B")
     void setEnabled(boolean enabled) {
        mEnabled = enabled;
        // ---------- Original Method ----------
        //mEnabled = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.529 -0400", hash_original_method = "2657035D37B57C6EB1FDEBFDEB2FC631", hash_generated_method = "776812C818566F1EDFDAB0EE5E61BF92")
     boolean isRequested() {
        boolean varCAD2F4EAFD7FAE1B5AB35772EE26114C_1361791824 = (mRequested);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129322952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129322952;
        // ---------- Original Method ----------
        //return mRequested;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.529 -0400", hash_original_method = "5489F62162525BB08E1A950602557C7B", hash_generated_method = "6C5945B8EA5D67FB5159E094E21FF9C0")
     void setRequested(boolean requested) {
        mRequested = requested;
        // ---------- Original Method ----------
        //mRequested = requested;
    }

    
    static abstract class GlRenderer extends HardwareRenderer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "2BA03B5BE1E097B9BC57B210061D879D")

        int mWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3D81262840DA37820D58425FC486E30D")

        int mHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "4B5703969A5D1B3F20E76A16B21EF3AA", hash_generated_field = "75D18A698C8C0156FC372CC4CDC659FD")

        EGLContext mEglContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "6CB4022825BF3891C4CBC4215A165C31", hash_generated_field = "C8809406F874F748D7C2D2A82FC8CAFB")

        Thread mEglThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "BB92F1E402C2CF8873F9526C78C325F9", hash_generated_field = "3BCE51A04A846FE71AD218CCB7DF9B47")

        EGLSurface mEglSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "D13376DE2BC4474B01F1A83287CA2BC4", hash_generated_field = "776F52E98B7458F3181D343B01ABD47C")

        GL mGl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "37BD83BC682BDA2AAC757751086B36DE")

        HardwareCanvas mCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "EDB3186346B1612B7704D58A9CAAE15F", hash_generated_field = "2B862720623879764FB3C1B9EA11B335")

        int mFrameCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "67733C7F7D8E4C7C7A459C93C066173F", hash_generated_field = "FFE47057B50B334DD786C5E73414DC81")

        Paint mDebugPaint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "0A34812C66F525B1CA7E24023471D9BA", hash_generated_field = "ECB95A231B3EDB5A9081400631FFCAB1")

        boolean mDirtyRegionsEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "868C0C427245760814552A5B70CB53AF", hash_generated_field = "763734C03E6324334FBF6C22D68E5385")

        boolean mVsyncDisabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "5164B62B837448A39F3CCE947AE6F417", hash_generated_field = "F9D183B249EAF9218F504B0391DBAF55")

        int mGlVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "73CAD811A48D76CFFB6B1DC80D318679", hash_generated_field = "BA918D2716C9DCF541C02A323E8108FD")

        boolean mTranslucent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

        private boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.532 -0400", hash_original_field = "054D3AA75C56BAF25A15C014D3BEB501", hash_generated_field = "182B0379D371946AD3DA2504271E34F0")

        private final Rect mRedrawClip = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.533 -0400", hash_original_method = "10324A50C61190B04368151ACA88DC91", hash_generated_method = "B2F503B8EEBE39B647EC467EC45A6985")
          GlRenderer(int glVersion, boolean translucent) {
            mGlVersion = glVersion;
            mTranslucent = translucent;
            final String vsyncProperty = SystemProperties.get(DISABLE_VSYNC_PROPERTY, "false");
            mVsyncDisabled = "true".equalsIgnoreCase(vsyncProperty);
            if(mVsyncDisabled)            
            {
                Log.d(LOG_TAG, "Disabling v-sync");
            } //End block
            // ---------- Original Method ----------
            //mGlVersion = glVersion;
            //mTranslucent = translucent;
            //final String vsyncProperty = SystemProperties.get(DISABLE_VSYNC_PROPERTY, "false");
            //mVsyncDisabled = "true".equalsIgnoreCase(vsyncProperty);
            //if (mVsyncDisabled) {
                //Log.d(LOG_TAG, "Disabling v-sync");
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.533 -0400", hash_original_method = "8E011D652AD55D9A8BD48AFBDECCE639", hash_generated_method = "B679A263E9F532199F0F48D27DD8D6E1")
         boolean hasDirtyRegions() {
            boolean var0A34812C66F525B1CA7E24023471D9BA_1467651228 = (mDirtyRegionsEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539205383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_539205383;
            // ---------- Original Method ----------
            //return mDirtyRegionsEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.533 -0400", hash_original_method = "5D86F2EDCD8D2650FE0B69784B6D885F", hash_generated_method = "116183A3759EAAF954771D32ABBAAFAE")
         void checkEglErrors() {
            if(isEnabled())            
            {
                int error = sEgl.eglGetError();
                if(error != EGL_SUCCESS)                
                {
                    fallback(error != EGL11.EGL_CONTEXT_LOST);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (isEnabled()) {
                //int error = sEgl.eglGetError();
                //if (error != EGL_SUCCESS) {
                    //Log.w(LOG_TAG, "EGL error: " + GLUtils.getEGLErrorString(error));
                    //fallback(error != EGL11.EGL_CONTEXT_LOST);
                //}
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.534 -0400", hash_original_method = "87E6FBE52BF3E41B35644D0BA431AF43", hash_generated_method = "724BB10E1821067E94AC57137E341A8E")
        private void fallback(boolean fallback) {
            addTaint(fallback);
            destroy(true);
            if(fallback)            
            {
                setRequested(false);
            } //End block
            // ---------- Original Method ----------
            //destroy(true);
            //if (fallback) {
                //setRequested(false);
                //Log.w(LOG_TAG, "Mountain View, we've had a problem here. " 
                        //+ "Switching back to software rendering.");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.534 -0400", hash_original_method = "921EA5B73D96C86CDA9474B12ADD4C25", hash_generated_method = "67132930A3FB15F325999230119FF06F")
        @Override
         boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            if(isRequested() && !isEnabled())            
            {
                initializeEgl();
                mGl = createEglSurface(holder);
                mDestroyed = false;
                if(mGl != null)                
                {
                    int err = sEgl.eglGetError();
                    if(err != EGL_SUCCESS)                    
                    {
                        destroy(true);
                        setRequested(false);
                    } //End block
                    else
                    {
                        if(mCanvas == null)                        
                        {
                            mCanvas = createCanvas();
                        } //End block
                        if(mCanvas != null)                        
                        {
                            setEnabled(true);
                        } //End block
                        else
                        {
                        } //End block
                    } //End block
                    boolean var2AEE1C379439EE1764B56589D9BFE76A_2025022113 = (mCanvas != null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709063888 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709063888;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_23934892 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370866452 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_370866452;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.535 -0400", hash_original_method = "2D2C42A66AD2DEB924E2F6769D89C4AD", hash_generated_method = "9CC5A194330D702D7662E0288D145EB6")
        @Override
         void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            addTaint(holder.getTaint());
            if(isRequested() && isEnabled())            
            {
                createEglSurface(holder);
            } //End block
            // ---------- Original Method ----------
            //if (isRequested() && isEnabled()) {
                //createEglSurface(holder);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        abstract GLES20Canvas createCanvas();

        
        @DSModeled(DSC.SAFE)
        abstract int[] getConfig(boolean dirtyRegions);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.537 -0400", hash_original_method = "B279C4718AE98DC5BFCF9CC39FB51005", hash_generated_method = "080F9ECF15E2F3C6139B501BBC59C494")
         void initializeEgl() {
            synchronized
(sEglLock)            {
                if(sEgl == null && sEglConfig == null)                
                {
                    sEgl = (EGL10) EGLContext.getEGL();
                    sEglDisplay = sEgl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    if(sEglDisplay == EGL_NO_DISPLAY)                    
                    {
                        RuntimeException var1B927C3232E5557F308CA5707C567639_653036246 = new RuntimeException("eglGetDisplay failed "
                                + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                        var1B927C3232E5557F308CA5707C567639_653036246.addTaint(taint);
                        throw var1B927C3232E5557F308CA5707C567639_653036246;
                    } //End block
                    int[] version = new int[2];
                    if(!sEgl.eglInitialize(sEglDisplay, version))                    
                    {
                        RuntimeException varCC0EF50699CF5CC417C55603CA6B303C_1335287434 = new RuntimeException("eglInitialize failed " +
                                GLUtils.getEGLErrorString(sEgl.eglGetError()));
                        varCC0EF50699CF5CC417C55603CA6B303C_1335287434.addTaint(taint);
                        throw varCC0EF50699CF5CC417C55603CA6B303C_1335287434;
                    } //End block
                    sEglConfig = chooseEglConfig();
                    if(sEglConfig == null)                    
                    {
                        if(sDirtyRegions)                        
                        {
                            sDirtyRegions = false;
                            sEglConfig = chooseEglConfig();
                            if(sEglConfig == null)                            
                            {
                                RuntimeException varD0BA15276D2F35634275A9CEAF68C4D1_659870873 = new RuntimeException("eglConfig not initialized");
                                varD0BA15276D2F35634275A9CEAF68C4D1_659870873.addTaint(taint);
                                throw varD0BA15276D2F35634275A9CEAF68C4D1_659870873;
                            } //End block
                        } //End block
                        else
                        {
                            RuntimeException varD0BA15276D2F35634275A9CEAF68C4D1_975293642 = new RuntimeException("eglConfig not initialized");
                            varD0BA15276D2F35634275A9CEAF68C4D1_975293642.addTaint(taint);
                            throw varD0BA15276D2F35634275A9CEAF68C4D1_975293642;
                        } //End block
                    } //End block
                } //End block
            } //End block
            Gl20Renderer.Gl20RendererEglContext managedContext = sEglContextStorage.get();
            mEglContext = managedContext != null ? managedContext.getContext() : null;
            mEglThread = Thread.currentThread();
            if(mEglContext == null)            
            {
                mEglContext = createContext(sEgl, sEglDisplay, sEglConfig);
                sEglContextStorage.set(new Gl20Renderer.Gl20RendererEglContext(mEglContext));
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.537 -0400", hash_original_method = "7EBBB0609098A0727E2316EE23892E6C", hash_generated_method = "5950AB41F58F95C94A08A5B70FE82546")
        private EGLConfig chooseEglConfig() {
            EGLConfig[] configs = new EGLConfig[1];
            int[] configsCount = new int[1];
            int[] configSpec = getConfig(sDirtyRegions);
            final String debug = SystemProperties.get(PRINT_CONFIG_PROPERTY, "");
            if("all".equalsIgnoreCase(debug))            
            {
                sEgl.eglChooseConfig(sEglDisplay, configSpec, null, 0, configsCount);
                EGLConfig[] debugConfigs = new EGLConfig[configsCount[0]];
                sEgl.eglChooseConfig(sEglDisplay, configSpec, debugConfigs,
                        configsCount[0], configsCount);
for(EGLConfig config : debugConfigs)
                {
                    printConfig(config);
                } //End block
            } //End block
            if(!sEgl.eglChooseConfig(sEglDisplay, configSpec, configs, 1, configsCount))            
            {
                IllegalArgumentException var74B99D29D34C8E50E6A0A7B42D575DC1_523931965 = new IllegalArgumentException("eglChooseConfig failed " +
                        GLUtils.getEGLErrorString(sEgl.eglGetError()));
                var74B99D29D34C8E50E6A0A7B42D575DC1_523931965.addTaint(taint);
                throw var74B99D29D34C8E50E6A0A7B42D575DC1_523931965;
            } //End block
            else
            if(configsCount[0] > 0)            
            {
                if("choice".equalsIgnoreCase(debug))                
                {
                    printConfig(configs[0]);
                } //End block
EGLConfig var410F8DC63E401479E8FD3D5D855F4B7B_868323567 =                 configs[0];
                var410F8DC63E401479E8FD3D5D855F4B7B_868323567.addTaint(taint);
                return var410F8DC63E401479E8FD3D5D855F4B7B_868323567;
            } //End block
EGLConfig var540C13E9E156B687226421B24F2DF178_1290590049 =             null;
            var540C13E9E156B687226421B24F2DF178_1290590049.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1290590049;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.538 -0400", hash_original_method = "0890A6845DB8299C7ED9F063C47BF666", hash_generated_method = "6FC5D75673E2291D1EE0C855331C45B2")
        private void printConfig(EGLConfig config) {
            addTaint(config.getTaint());
            int[] value = new int[1];
            Log.d(LOG_TAG, "EGL configuration " + config + ":");
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_RED_SIZE, value);
            Log.d(LOG_TAG, "  RED_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_GREEN_SIZE, value);
            Log.d(LOG_TAG, "  GREEN_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_BLUE_SIZE, value);
            Log.d(LOG_TAG, "  BLUE_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_ALPHA_SIZE, value);
            Log.d(LOG_TAG, "  ALPHA_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_DEPTH_SIZE, value);
            Log.d(LOG_TAG, "  DEPTH_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_STENCIL_SIZE, value);
            Log.d(LOG_TAG, "  STENCIL_SIZE = " + value[0]);
            sEgl.eglGetConfigAttrib(sEglDisplay, config, EGL_SURFACE_TYPE, value);
            Log.d(LOG_TAG, "  SURFACE_TYPE = 0x" + Integer.toHexString(value[0]));
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.538 -0400", hash_original_method = "CE78C152F3B6BB29B0F51267B059EC85", hash_generated_method = "576C1F7B753E2E495B2DE8B51EEDD252")
         GL createEglSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            addTaint(holder.getTaint());
            if(sEgl == null)            
            {
                RuntimeException var5A8744D5A97A139075D8D01C30ADD4A5_2012509364 = new RuntimeException("egl not initialized");
                var5A8744D5A97A139075D8D01C30ADD4A5_2012509364.addTaint(taint);
                throw var5A8744D5A97A139075D8D01C30ADD4A5_2012509364;
            } //End block
            if(sEglDisplay == null)            
            {
                RuntimeException varA6A6317A00D2FA87E40F6545911F3492_1037283451 = new RuntimeException("eglDisplay not initialized");
                varA6A6317A00D2FA87E40F6545911F3492_1037283451.addTaint(taint);
                throw varA6A6317A00D2FA87E40F6545911F3492_1037283451;
            } //End block
            if(sEglConfig == null)            
            {
                RuntimeException varD0BA15276D2F35634275A9CEAF68C4D1_1511467634 = new RuntimeException("eglConfig not initialized");
                varD0BA15276D2F35634275A9CEAF68C4D1_1511467634.addTaint(taint);
                throw varD0BA15276D2F35634275A9CEAF68C4D1_1511467634;
            } //End block
            if(Thread.currentThread() != mEglThread)            
            {
                IllegalStateException var8D246CA55DBF1E5B90C3DBB6E85989E7_896606010 = new IllegalStateException("HardwareRenderer cannot be used " 
                        + "from multiple threads");
                var8D246CA55DBF1E5B90C3DBB6E85989E7_896606010.addTaint(taint);
                throw var8D246CA55DBF1E5B90C3DBB6E85989E7_896606010;
            } //End block
            destroySurface();
            if(!createSurface(holder))            
            {
GL var540C13E9E156B687226421B24F2DF178_653273595 =                 null;
                var540C13E9E156B687226421B24F2DF178_653273595.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_653273595;
            } //End block
            if(!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext))            
            {
                Surface.OutOfResourcesException var32C96ADE7E95002329B6F2AF1A5812AE_164697682 = new Surface.OutOfResourcesException("eglMakeCurrent failed "
                        + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                var32C96ADE7E95002329B6F2AF1A5812AE_164697682.addTaint(taint);
                throw var32C96ADE7E95002329B6F2AF1A5812AE_164697682;
            } //End block
            initCaches();
            if(sDirtyRegions)            
            {
                if(!(mDirtyRegionsEnabled = GLES20Canvas.preserveBackBuffer()))                
                {
                } //End block
            } //End block
            else
            if(sDirtyRegionsRequested)            
            {
                mDirtyRegionsEnabled = GLES20Canvas.isBackBufferPreserved();
            } //End block
GL var6B3D9F1DEC3427303F21E6CDA2CD8137_262782479 =             mEglContext.getGL();
            var6B3D9F1DEC3427303F21E6CDA2CD8137_262782479.addTaint(taint);
            return var6B3D9F1DEC3427303F21E6CDA2CD8137_262782479;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        abstract void initCaches();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.538 -0400", hash_original_method = "25878E68191E1BEA8EFD58CC92DB697F", hash_generated_method = "D9B35049CAA0751BB95110B0AC4510D1")
         EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
            addTaint(eglConfig.getTaint());
            addTaint(eglDisplay.getTaint());
            addTaint(egl.getTaint());
            int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };
EGLContext var927F4799C479B4C43A974ADDE6053FE6_1394440957 =             egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    mGlVersion != 0 ? attribs : null);
            var927F4799C479B4C43A974ADDE6053FE6_1394440957.addTaint(taint);
            return var927F4799C479B4C43A974ADDE6053FE6_1394440957;
            // ---------- Original Method ----------
            //int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };
            //return egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    //mGlVersion != 0 ? attribs : null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.538 -0400", hash_original_method = "476B6B31B3E717E00869D611EE7348F9", hash_generated_method = "9DE91ABC178188A5D799E43797E98925")
        @Override
         void destroy(boolean full) {
            addTaint(full);
            if(full && mCanvas != null)            
            {
                mCanvas = null;
            } //End block
            if(!isEnabled() || mDestroyed)            
            {
                setEnabled(false);
                return;
            } //End block
            destroySurface();
            setEnabled(false);
            mDestroyed = true;
            mGl = null;
            // ---------- Original Method ----------
            //if (full && mCanvas != null) {
                //mCanvas = null;
            //}
            //if (!isEnabled() || mDestroyed) {
                //setEnabled(false);
                //return;
            //}
            //destroySurface();
            //setEnabled(false);
            //mDestroyed = true;
            //mGl = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "8729F371C5ECEEE6F9AFEEF006F001BC", hash_generated_method = "C097A218D875F057B9CCADED356636EC")
         void destroySurface() {
            if(mEglSurface != null && mEglSurface != EGL_NO_SURFACE)            
            {
                sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
            } //End block
            // ---------- Original Method ----------
            //if (mEglSurface != null && mEglSurface != EGL_NO_SURFACE) {
                //sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
                //sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                //mEglSurface = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "31AB32F492C93DC28936068651BB9A5D", hash_generated_method = "91F1E780087AC859890BF3AD704CD4D2")
        @Override
         void invalidate(SurfaceHolder holder) {
            addTaint(holder.getTaint());
            sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
            if(mEglSurface != null && mEglSurface != EGL_NO_SURFACE)            
            {
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
                setEnabled(false);
            } //End block
            if(holder.getSurface().isValid())            
            {
                if(!createSurface(holder))                
                {
                    return;
                } //End block
                if(mCanvas != null)                
                {
                    setEnabled(true);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
            //if (mEglSurface != null && mEglSurface != EGL_NO_SURFACE) {
                //sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                //mEglSurface = null;
                //setEnabled(false);
            //}
            //if (holder.getSurface().isValid()) {
                //if (!createSurface(holder)) {
                    //return;
                //}
                //if (mCanvas != null) {
                    //setEnabled(true);
                //}
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "DE5D7845AE9FF0DF12BC88C1DA1B9378", hash_generated_method = "59279ECA4FB0C58B52855668C1D9705B")
        private boolean createSurface(SurfaceHolder holder) {
            mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, holder, null);
            if(mEglSurface == null || mEglSurface == EGL_NO_SURFACE)            
            {
                int error = sEgl.eglGetError();
                if(error == EGL_BAD_NATIVE_WINDOW)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_264445021 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217043261 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217043261;
                } //End block
                RuntimeException var2ABFB2AD133F2DE0D24F51181CBC4AE9_113077010 = new RuntimeException("createWindowSurface failed "
                        + GLUtils.getEGLErrorString(error));
                var2ABFB2AD133F2DE0D24F51181CBC4AE9_113077010.addTaint(taint);
                throw var2ABFB2AD133F2DE0D24F51181CBC4AE9_113077010;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_506518163 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046329403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046329403;
            // ---------- Original Method ----------
            //mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, holder, null);
            //if (mEglSurface == null || mEglSurface == EGL_NO_SURFACE) {
                //int error = sEgl.eglGetError();
                //if (error == EGL_BAD_NATIVE_WINDOW) {
                    //Log.e(LOG_TAG, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    //return false;
                //}
                //throw new RuntimeException("createWindowSurface failed "
                        //+ GLUtils.getEGLErrorString(error));
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "5192B6F9979CE04F5E58A6D4E6C990F7", hash_generated_method = "C0DE962A0AB2A31CA3DF2A1625742119")
        @Override
         boolean validate() {
            boolean varE79A9CA5084B37704EDF595716446B75_1207530132 = (checkCurrent() != SURFACE_STATE_ERROR);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087711172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087711172;
            // ---------- Original Method ----------
            //return checkCurrent() != SURFACE_STATE_ERROR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "432BCA9410981741609CBA70FE61BE99", hash_generated_method = "5B071D597535F5F1490600D40011E971")
        @Override
         void setup(int width, int height) {
            if(validate())            
            {
                mCanvas.setViewport(width, height);
                mWidth = width;
                mHeight = height;
            } //End block
            // ---------- Original Method ----------
            //if (validate()) {
                //mCanvas.setViewport(width, height);
                //mWidth = width;
                //mHeight = height;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.539 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "419DEE5DD3BFFCA0AD019DD6377143CE")
        @Override
         int getWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_1950725685 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617721038 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617721038;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.540 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "C8E2F39D580E299506AFCCF617A8B0C5")
        @Override
         int getHeight() {
            int var483542B05A951AA16D89C7F809C20811_2123048136 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368415774 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368415774;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.540 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "747F13AFB185488D5073828C18F2C6EC")
        @Override
         HardwareCanvas getCanvas() {
HardwareCanvas var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1257206558 =             mCanvas;
            var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1257206558.addTaint(taint);
            return var3AB98B3CCAF89A85C04BAFF3A3FCA5C1_1257206558;
            // ---------- Original Method ----------
            //return mCanvas;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.540 -0400", hash_original_method = "BAED9FCEBD48E8CDA814A9102CB815B2", hash_generated_method = "90ED88BB25394D698941CF895E0DBE21")
         boolean canDraw() {
            boolean var4100F70211E1483E664E1C43EF885793_1856113095 = (mGl != null && mCanvas != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970926451 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970926451;
            // ---------- Original Method ----------
            //return mGl != null && mCanvas != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.540 -0400", hash_original_method = "5270AAD77A1E26F7563AFAAC446C8262", hash_generated_method = "D1D1BF3A49F969C9AFF6B64380268E6B")
         void onPreDraw(Rect dirty) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dirty.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.540 -0400", hash_original_method = "600776A2676C628EF453DCB2EAD62BCF", hash_generated_method = "CE44E4A0F53F45960A85861D50074AD3")
         void onPostDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_method = "B420691F06CB3429CDB4650F51ED53E5", hash_generated_method = "FB486BB512D0FE323EF61B2090B5C955")
        @Override
         boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
                Rect dirty) {
            addTaint(dirty.getTaint());
            addTaint(callbacks.getTaint());
            addTaint(attachInfo.getTaint());
            addTaint(view.getTaint());
            if(canDraw())            
            {
                if(!hasDirtyRegions())                
                {
                    dirty = null;
                } //End block
                attachInfo.mIgnoreDirtyState = true;
                attachInfo.mDrawingTime = SystemClock.uptimeMillis();
                view.mPrivateFlags |= View.DRAWN;
                final int surfaceState = checkCurrent();
                if(surfaceState != SURFACE_STATE_ERROR)                
                {
                    if(surfaceState == SURFACE_STATE_UPDATED)                    
                    {
                        dirty = null;
                    } //End block
                    onPreDraw(dirty);
                    HardwareCanvas canvas = mCanvas;
                    attachInfo.mHardwareCanvas = canvas;
                    int saveCount = canvas.save();
                    callbacks.onHardwarePreDraw(canvas);
                    try 
                    {
                        view.mRecreateDisplayList =
                                (view.mPrivateFlags & View.INVALIDATED) == View.INVALIDATED;
                        view.mPrivateFlags &= ~View.INVALIDATED;
                        DisplayList displayList = view.getDisplayList();
                        if(displayList != null)                        
                        {
                            if(canvas.drawDisplayList(displayList, view.getWidth(),
                                    view.getHeight(), mRedrawClip))                            
                            {
                                if(mRedrawClip.isEmpty() || view.getParent() == null)                                
                                {
                                    view.invalidate();
                                } //End block
                                else
                                {
                                    view.getParent().invalidateChild(view, mRedrawClip);
                                } //End block
                                mRedrawClip.setEmpty();
                            } //End block
                        } //End block
                        else
                        {
                            view.draw(canvas);
                        } //End block
                        if(DEBUG_DIRTY_REGION)                        
                        {
                            if(mDebugPaint == null)                            
                            {
                                mDebugPaint = new Paint();
                                mDebugPaint.setColor(0x7fff0000);
                            } //End block
                            if(dirty != null && (mFrameCount++ & 1) == 0)                            
                            {
                                canvas.drawRect(dirty, mDebugPaint);
                            } //End block
                        } //End block
                    } //End block
                    finally 
                    {
                        callbacks.onHardwarePostDraw(canvas);
                        canvas.restoreToCount(saveCount);
                        view.mRecreateDisplayList = false;
                    } //End block
                    onPostDraw();
                    attachInfo.mIgnoreDirtyState = false;
                    sEgl.eglSwapBuffers(sEglDisplay, mEglSurface);
                    checkEglErrors();
                    boolean var2D7177011D6B119A3B3C77C997EEA401_939624864 = (dirty == null);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940203697 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_940203697;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1039626964 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721113532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721113532;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_method = "F54ECE08CE2E8C98D4ED45C8BC0241CA", hash_generated_method = "9F2E0A7D73A43BF2514AE32A0EFA22A4")
         int checkCurrent() {
            if(mEglThread != Thread.currentThread())            
            {
                IllegalStateException varD332D66A3EAFD9DE6B6716DEA3FE03B2_551708257 = new IllegalStateException("Hardware acceleration can only be used with a " +
                        "single UI thread.\nOriginal thread: " + mEglThread + "\n" +
                        "Current thread: " + Thread.currentThread());
                varD332D66A3EAFD9DE6B6716DEA3FE03B2_551708257.addTaint(taint);
                throw varD332D66A3EAFD9DE6B6716DEA3FE03B2_551708257;
            } //End block
            if(!mEglContext.equals(sEgl.eglGetCurrentContext()) ||
                    !mEglSurface.equals(sEgl.eglGetCurrentSurface(EGL_DRAW)))            
            {
                if(!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext))                
                {
                    fallback(true);
                    int varC7C48E6323DB6F23C634A5AAD9F7AD39_1348293300 = (SURFACE_STATE_ERROR);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607565567 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607565567;
                } //End block
                else
                {
                    int varEB3697E19DAB96EF5BA24A5175A1EE25_892669950 = (SURFACE_STATE_UPDATED);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266194585 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266194585;
                } //End block
            } //End block
            int var9D08B7ED674A0459C61995FCBA9E7255_1126491029 = (SURFACE_STATE_SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939794240 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939794240;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "A19F59BE927F4F5E11AA32DB62E90314", hash_generated_field = "3E10338E50BF743AF77D21918619DEC3")

        static final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "97A00FC4142306DA1042323304264C1B", hash_generated_field = "2C445899F8A8AEDECF32FB9135B066D1")

        static final int EGL_OPENGL_ES2_BIT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "96D54B55AD0E4E40B6DCB87E61752FF9", hash_generated_field = "2A272558ACA6FC8A6614D6BA7458C75D")

        static final int EGL_SURFACE_TYPE = 0x3033;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "507D2DB29A3E835918E1443820044DA4", hash_generated_field = "C31026AE6C97B54F64BA8D74F4DB4624")

        static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 0x0400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "B3D3DE2F97138E3F4C8C1104D2283F22", hash_generated_field = "0938239E7634E9F8C37B8678E90396F9")

        static final int SURFACE_STATE_ERROR = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "AD7BA14E9F8D93599CF7E6857DE82E51", hash_generated_field = "A56E49F9D74B2FDD846AFDD966D2CA36")

        static final int SURFACE_STATE_SUCCESS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "5A39E5B262E2B76674680C1E93FBA130", hash_generated_field = "DCB1F5A31169FA47085409CF6AA15381")

        static final int SURFACE_STATE_UPDATED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.541 -0400", hash_original_field = "517CB8E1BF8BAAB4DD9DC6139F9CBA55", hash_generated_field = "89D62FD7DEAB0F4EA47FB451DD608D43")

        static EGL10 sEgl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "0DC55FC6F390572EB62834B8C0E81B1C", hash_generated_field = "4D6AA44B0537982BD4C758CAAEDCA2BB")

        static EGLDisplay sEglDisplay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "4B84BABA9DC89D85E1FD3FA8F9F1DA63", hash_generated_field = "AB7BB82C5C2E6AFE71B7DB7D36C3876B")

        static EGLConfig sEglConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "8A7FD20B727D1EBC888543F70503348B", hash_generated_field = "8E033D3FEBA28DC4C5024A9005A21267")

        static final Object[] sEglLock = new Object[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "C85C8C7C19C4A40E7B8BAD011C332FE3", hash_generated_field = "B964CE88695D4A806E497A467321E250")

        static final ThreadLocal<Gl20Renderer.Gl20RendererEglContext> sEglContextStorage = new ThreadLocal<Gl20Renderer.Gl20RendererEglContext>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "03A020BDC3E1EF59FB3D9C945D229599", hash_generated_field = "2552FD4B6C23E3B90D7EC1BBA8F3293E")

        static boolean sDirtyRegions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "693EC6F7BC7ED63CB47319C2DC57F448", hash_generated_field = "1C3D78F3A3106B7D131377ACD7D2905E")

        static boolean sDirtyRegionsRequested;
        static {
            String dirtyProperty = SystemProperties.get(RENDER_DIRTY_REGIONS_PROPERTY, "true");
            sDirtyRegions = RENDER_DIRTY_REGIONS && "true".equalsIgnoreCase(dirtyProperty);
            sDirtyRegionsRequested = sDirtyRegions;
        }
        
    }


    
    static class Gl20Renderer extends GlRenderer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_field = "8BB014C044F807A0D79AB317C305F7F8", hash_generated_field = "A04C267767B10D74D267BE1DECB4FBB4")

        private GLES20Canvas mGlCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_method = "B1E95719A4C359FC5D5C603A14B80EB3", hash_generated_method = "DDBF91067C6DB4EB1DC3ED91881B3482")
          Gl20Renderer(boolean translucent) {
            super(2, translucent);
            addTaint(translucent);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_method = "F74985FDFA2E9230D4C8D7E9B7CADFBD", hash_generated_method = "10EA7448369E511428F6859C3A30B4D0")
        @Override
         GLES20Canvas createCanvas() {
GLES20Canvas var5172C7EB1AEC89F673E47E03A04AE959_1104815543 =             mGlCanvas = new GLES20Canvas(mTranslucent);
            var5172C7EB1AEC89F673E47E03A04AE959_1104815543.addTaint(taint);
            return var5172C7EB1AEC89F673E47E03A04AE959_1104815543;
            // ---------- Original Method ----------
            //return mGlCanvas = new GLES20Canvas(mTranslucent);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.542 -0400", hash_original_method = "F0C99ACF7C56841B3F486F5BFE1F4C1E", hash_generated_method = "C42CCCDF9EE30DD16E17BBDD490BBD6D")
        @Override
         int[] getConfig(boolean dirtyRegions) {
            addTaint(dirtyRegions);
            int[] varEA61E13FCE2B426DD79C3D75FA4939CA_768501192 = (new int[] {
                    EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
                    EGL_RED_SIZE, 8,
                    EGL_GREEN_SIZE, 8,
                    EGL_BLUE_SIZE, 8,
                    EGL_ALPHA_SIZE, 8,
                    EGL_DEPTH_SIZE, 0,
                    EGL_STENCIL_SIZE, 0,
                    EGL_SURFACE_TYPE, EGL_WINDOW_BIT |
                            (dirtyRegions ? EGL_SWAP_BEHAVIOR_PRESERVED_BIT : 0),
                    EGL_NONE
            });
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_331243375 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_331243375;
            // ---------- Original Method ----------
            //return new int[] {
                    //EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
                    //EGL_RED_SIZE, 8,
                    //EGL_GREEN_SIZE, 8,
                    //EGL_BLUE_SIZE, 8,
                    //EGL_ALPHA_SIZE, 8,
                    //EGL_DEPTH_SIZE, 0,
                    //EGL_STENCIL_SIZE, 0,
                    //EGL_SURFACE_TYPE, EGL_WINDOW_BIT |
                            //(dirtyRegions ? EGL_SWAP_BEHAVIOR_PRESERVED_BIT : 0),
                    //EGL_NONE
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "7C06275E87085241F3D16D3C83742A74", hash_generated_method = "FE9E19F8157E46F4D596C9F48C05192B")
        @Override
         void initCaches() {
            GLES20Canvas.initCaches();
            // ---------- Original Method ----------
            //GLES20Canvas.initCaches();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "C7C1539F42BBDC0F7B3C1C5760B83BD0", hash_generated_method = "D055DE279C06DBC13A7322C724678F37")
        @Override
         boolean canDraw() {
            boolean var983DB783612D1CD099A2AE3632410E69_308511250 = (super.canDraw() && mGlCanvas != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691570406 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_691570406;
            // ---------- Original Method ----------
            //return super.canDraw() && mGlCanvas != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "0022B5A5096431CE2C7606DC3316BE73", hash_generated_method = "DC76595AA7DB46F6F83FDB2E45B183EB")
        @Override
         void onPreDraw(Rect dirty) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dirty.getTaint());
            mGlCanvas.onPreDraw(dirty);
            // ---------- Original Method ----------
            //mGlCanvas.onPreDraw(dirty);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "7433D62E540EA68CB724AA636E5E1121", hash_generated_method = "927CC0A07657DA1C5F4A57B52A17F932")
        @Override
         void onPostDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mGlCanvas.onPostDraw();
            // ---------- Original Method ----------
            //mGlCanvas.onPostDraw();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "6E3A6DE775BA1410C4AD975BAADAD54E", hash_generated_method = "754E2713F42008D964679C9DA3511FB7")
        @Override
         void destroy(boolean full) {
            addTaint(full);
            try 
            {
                super.destroy(full);
            } //End block
            finally 
            {
                if(full && mGlCanvas != null)                
                {
                    mGlCanvas = null;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //try {
                //super.destroy(full);
            //} finally {
                //if (full && mGlCanvas != null) {
                    //mGlCanvas = null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "E63C13501979998737C0E9B67210D488", hash_generated_method = "EDEF54D660F650DC4888114AB415A387")
        @Override
         void setup(int width, int height) {
            addTaint(height);
            addTaint(width);
            super.setup(width, height);
            if(mVsyncDisabled)            
            {
                GLES20Canvas.disableVsync();
            } //End block
            // ---------- Original Method ----------
            //super.setup(width, height);
            //if (mVsyncDisabled) {
                //GLES20Canvas.disableVsync();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "91DF561E8BF11B235EB0CF61AE2449D1", hash_generated_method = "AF3524A79D7F70B9ABD1553CB41C0E77")
        @Override
         DisplayList createDisplayList() {
DisplayList var08B970B2951F462EDA0A27A3AC7A5D09_790971824 =             new GLES20DisplayList();
            var08B970B2951F462EDA0A27A3AC7A5D09_790971824.addTaint(taint);
            return var08B970B2951F462EDA0A27A3AC7A5D09_790971824;
            // ---------- Original Method ----------
            //return new GLES20DisplayList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "9926A5C358BE0969CD82CBEFEE88B0C5", hash_generated_method = "C8450FC62663C7EBB669A816056AC619")
        @Override
         HardwareLayer createHardwareLayer(boolean isOpaque) {
            addTaint(isOpaque);
HardwareLayer var441516924736EDCB964EC8ECE95CB586_1079362325 =             new GLES20TextureLayer(isOpaque);
            var441516924736EDCB964EC8ECE95CB586_1079362325.addTaint(taint);
            return var441516924736EDCB964EC8ECE95CB586_1079362325;
            // ---------- Original Method ----------
            //return new GLES20TextureLayer(isOpaque);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.543 -0400", hash_original_method = "4877A9BF76918321656F296A4083E728", hash_generated_method = "3EF5D67F68C283A64C6DB0A155F7ECD7")
        @Override
         HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque) {
            addTaint(isOpaque);
            addTaint(height);
            addTaint(width);
HardwareLayer var2B297EF24CB6A7334E2F53FA2F4EC775_1726092954 =             new GLES20RenderLayer(width, height, isOpaque);
            var2B297EF24CB6A7334E2F53FA2F4EC775_1726092954.addTaint(taint);
            return var2B297EF24CB6A7334E2F53FA2F4EC775_1726092954;
            // ---------- Original Method ----------
            //return new GLES20RenderLayer(width, height, isOpaque);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.544 -0400", hash_original_method = "2626CBE8666291C6CAEC91C70C04EEE5", hash_generated_method = "EDC1C65B69F93FF6EC76B9563FABE17B")
        @Override
         SurfaceTexture createSurfaceTexture(HardwareLayer layer) {
            addTaint(layer.getTaint());
SurfaceTexture varAA924545A7AC84D1B0FCFE9418DCB8F7_1257300807 =             ((GLES20TextureLayer) layer).getSurfaceTexture();
            varAA924545A7AC84D1B0FCFE9418DCB8F7_1257300807.addTaint(taint);
            return varAA924545A7AC84D1B0FCFE9418DCB8F7_1257300807;
            // ---------- Original Method ----------
            //return ((GLES20TextureLayer) layer).getSurfaceTexture();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.544 -0400", hash_original_method = "47CAC65634322D23BF323CE20E51DB06", hash_generated_method = "FD1EA9CA3328BC165A45D6703C6DD8B3")
        @Override
         void destroyLayers(View view) {
            addTaint(view.getTaint());
            if(view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR)            
            {
                destroyHardwareLayer(view);
                GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            } //End block
            // ---------- Original Method ----------
            //if (view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR) {
                //destroyHardwareLayer(view);
                //GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            //}
        }

        
        @DSModeled(DSC.BAN)
        private static void destroyHardwareLayer(View view) {
            view.destroyLayer();
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                int count = group.getChildCount();
                for (int i = 0; i < count; i++) {
                    destroyHardwareLayer(group.getChildAt(i));
                }
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.544 -0400", hash_original_method = "05E9CAD7CA3059A2D779D6F5B2F697AA", hash_generated_method = "C2861882CB176B2EA1562EF368AABB21")
        @Override
         void destroyHardwareResources(View view) {
            addTaint(view.getTaint());
            if(view != null)            
            {
                boolean needsContext = true;
                if(isEnabled() && checkCurrent() != SURFACE_STATE_ERROR)                
                needsContext = false;
                if(needsContext)                
                {
                    Gl20RendererEglContext managedContext = sEglContextStorage.get();
                    if(managedContext == null)                    
                    return;
                    usePbufferSurface(managedContext.getContext());
                } //End block
                destroyResources(view);
                GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            } //End block
            // ---------- Original Method ----------
            //if (view != null) {
                //boolean needsContext = true;
                //if (isEnabled() && checkCurrent() != SURFACE_STATE_ERROR) needsContext = false;
                //if (needsContext) {
                    //Gl20RendererEglContext managedContext = sEglContextStorage.get();
                    //if (managedContext == null) return;
                    //usePbufferSurface(managedContext.getContext());
                //}
                //destroyResources(view);
                //GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            //}
        }

        
        @DSModeled(DSC.BAN)
        private static void destroyResources(View view) {
            view.destroyHardwareResources();
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                int count = group.getChildCount();
                for (int i = 0; i < count; i++) {
                    destroyResources(group.getChildAt(i));
                }
            }
        }

        
        static HardwareRenderer create(boolean translucent) {
            if (GLES20Canvas.isAvailable()) {
                return new Gl20Renderer(translucent);
            }
            return null;
        }

        
        static void trimMemory(int level) {
            if (sEgl == null || sEglConfig == null) return;
            Gl20RendererEglContext managedContext = sEglContextStorage.get();
            if (managedContext == null) {
                return;
            } else {
                usePbufferSurface(managedContext.getContext());
            }
            switch (level) {
                case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
                case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
                    GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_MODERATE);
                    break;
                case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                    GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_FULL);
                    break;
            }
        }

        
        @DSModeled(DSC.BAN)
        private static void usePbufferSurface(EGLContext eglContext) {
            synchronized (sPbufferLock) {
                if (sPbuffer == null) {
                    sPbuffer = sEgl.eglCreatePbufferSurface(sEglDisplay, sEglConfig, new int[] {
                            EGL_WIDTH, 1, EGL_HEIGHT, 1, EGL_NONE
                    });
                }
            }
            sEgl.eglMakeCurrent(sEglDisplay, sPbuffer, sPbuffer, eglContext);
        }

        
        static class Gl20RendererEglContext extends ManagedEGLContext {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.544 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

            final Handler mHandler = new Handler();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.544 -0400", hash_original_method = "DAB7F8E2E2F55BAE2E6064B879DDA260", hash_generated_method = "30BCF69C0F54B16C64CD64F49D5AC7AC")
            public  Gl20RendererEglContext(EGLContext context) {
                super(context);
                addTaint(context.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_method = "022CE21F17BE8021C39A7EA65E477736", hash_generated_method = "73D3BEB6018FDB1F15BFFEEED5BD5A11")
            @Override
            public void onTerminate(final EGLContext eglContext) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(eglContext.getTaint());
                if(mHandler.getLooper() != Looper.myLooper())                
                {
                    mHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_method = "21D2857ABF6002C575615AA7F88BFAF8", hash_generated_method = "FEB39EBDBF35BC9FF5BD7B79A3DED670")
                @Override
                public void run() {
                    onTerminate(eglContext);
                    // ---------- Original Method ----------
                    //onTerminate(eglContext);
                }
});
                    return;
                } //End block
                synchronized
(sEglLock)                {
                    if(sEgl == null)                    
                    return;
                    if(EGLImpl.getInitCount(sEglDisplay) == 1)                    
                    {
                        usePbufferSurface(eglContext);
                        GLES20Canvas.terminateCaches();
                        sEgl.eglDestroyContext(sEglDisplay, eglContext);
                        sEglContextStorage.remove();
                        sEgl.eglDestroySurface(sEglDisplay, sPbuffer);
                        sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE,
                                EGL_NO_SURFACE, EGL_NO_CONTEXT);
                        sEgl.eglReleaseThread();
                        sEgl.eglTerminate(sEglDisplay);
                        sEgl = null;
                        sEglDisplay = null;
                        sEglConfig = null;
                        sPbuffer = null;
                        sEglContextStorage.set(null);
                    } //End block
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "EDA244A8C4565A775D56E24ADEB2FC59", hash_generated_field = "6C6559CCDF7784B417023844F64F56D4")

        private static EGLSurface sPbuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "D522D77DC5D21C2E0332D0703628B0B9", hash_generated_field = "397F4B1C85C553C6A50924367AE7739B")

        private static final Object[] sPbufferLock = new Object[0];
    }


    
    interface HardwareDrawCallbacks {
        
        void onHardwarePreDraw(HardwareCanvas canvas);

        
        void onHardwarePostDraw(HardwareCanvas canvas);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "2CE86765ED6DE7B67B485EBC8407FCBF", hash_generated_field = "717E213E05D2F7DB8EEBB9B9EB1D0800")

    static final String LOG_TAG = "HardwareRenderer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "FC1A9F98AA9C84CCBBC0AEBA66BAE490", hash_generated_field = "B7B9392A7811B48512BF0381603745C8")

    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "601E0E9CFF9912C4775ACF10567152C3", hash_generated_field = "8EEB971F06F320DA447B8EF1EAEE0542")

    public static final boolean RENDER_DIRTY_REGIONS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.545 -0400", hash_original_field = "171CE27716A16B22686FE2BA986FD2C2", hash_generated_field = "92ABF1D349C9DCF39365EE9296F875F7")

    static final String RENDER_DIRTY_REGIONS_PROPERTY = "hwui.render_dirty_regions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.546 -0400", hash_original_field = "B776832CE6AB1117A3B1FEA2C94E267D", hash_generated_field = "216B53A2C64AD3B3E792D12B0494E523")

    static final String DISABLE_VSYNC_PROPERTY = "hwui.disable_vsync";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.546 -0400", hash_original_field = "7ABB5A5B8E6E258B121B6B9EDFFA0EEA", hash_generated_field = "AF7D24DB7B3520929345144B8569DE46")

    static final String PRINT_CONFIG_PROPERTY = "hwui.print_config";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.546 -0400", hash_original_field = "8D093686D9AC39D7C2BB739AFC3BB2FB", hash_generated_field = "51986C698AA97FF96AC59DB3C2F7A7C5")

    private static final boolean DEBUG_DIRTY_REGION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.546 -0400", hash_original_field = "7D6DBD06A0D268F3C0C1E8EABBEEB68D", hash_generated_field = "B133F2DB85933820B16416D91ED8E00F")

    public static boolean sRendererDisabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.546 -0400", hash_original_field = "4861EA08BD543FA120F4D88F28D142EB", hash_generated_field = "1FF74BCF78FCE0998B21A6610C492707")

    public static boolean sSystemRendererDisabled = false;
}

