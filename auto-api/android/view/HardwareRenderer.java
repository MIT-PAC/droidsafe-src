package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import java.io.File;
import static javax.microedition.khronos.egl.EGL10.*;

public abstract class HardwareRenderer {
    static final String LOG_TAG = "HardwareRenderer";
    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
    public static final boolean RENDER_DIRTY_REGIONS = true;
    static final String RENDER_DIRTY_REGIONS_PROPERTY = "hwui.render_dirty_regions";
    static final String DISABLE_VSYNC_PROPERTY = "hwui.disable_vsync";
    static final String PRINT_CONFIG_PROPERTY = "hwui.print_config";
    private static final boolean DEBUG_DIRTY_REGION = false;
    public static boolean sRendererDisabled = false;
    public static boolean sSystemRendererDisabled = false;
    private boolean mEnabled;
    private boolean mRequested = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.006 -0400", hash_original_method = "9C9980AFD7DCCC801BD37DEFF892DD3E", hash_generated_method = "685A2C4B8C1F25453A3976C90D8F5844")
    public static void disable(boolean system) {
        sRendererDisabled = true;
        if (system) {
            sSystemRendererDisabled = true;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "290EA92060FDC76DF9899DFDEC8C2AD8", hash_generated_method = "52EB6BC0E8887F652592EF95BA41BE76")
    public static boolean isAvailable() {
        return GLES20Canvas.isAvailable();
    }

    
    abstract void destroy(boolean full);

    
    abstract boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException;

    
    abstract void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException;

    
    abstract void destroyLayers(View view);

    
    abstract void destroyHardwareResources(View view);

    
    abstract void invalidate(SurfaceHolder holder);

    
    abstract boolean validate();

    
    abstract void setup(int width, int height);

    
    abstract int getWidth();

    
    abstract int getHeight();

    
    abstract HardwareCanvas getCanvas();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "4D6DA7709E03DD958DC246E9D34F1611", hash_generated_method = "659680C38E48DF38D5BD90BD48E8C1D2")
    public static void setupDiskCache(File cacheDir) {
        nSetupShadersDiskCache(new File(cacheDir, CACHE_PATH_SHADERS).getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "16A6A61D4FDE679AC43F89D450C818BD", hash_generated_method = "2C0C43E53AA4488F04E9525A99E50E72")
    private static void nSetupShadersDiskCache(String cacheFile) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    abstract boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
            Rect dirty);

    
    abstract DisplayList createDisplayList();

    
    abstract HardwareLayer createHardwareLayer(boolean isOpaque);

    
    abstract HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque);

    
    abstract SurfaceTexture createSurfaceTexture(HardwareLayer layer);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "9B70801888A6ED6A8A5716CEEB0139B3", hash_generated_method = "405395FE13CDCD11866921C1C88002C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initializeIfNeeded(int width, int height, View.AttachInfo attachInfo,
            SurfaceHolder holder) throws Surface.OutOfResourcesException {
        dsTaint.addTaint(holder.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(attachInfo.dsTaint);
        {
            boolean varC2E2705FCD6C547FA29A43E4EE096B77_1639685598 = (isRequested());
            {
                {
                    boolean varAE5712E4D523B0C93A265DF749E6E081_84422561 = (!isEnabled());
                    {
                        {
                            boolean varF368F5F27839403AFE572C1398FD8488_2120622384 = (initialize(holder));
                            {
                                setup(width, height);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isRequested()) {
            //if (!isEnabled()) {
                //if (initialize(holder)) {
                    //setup(width, height);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "6EE96EBC477B77879F9A873960F8548A", hash_generated_method = "0502D06F1B00937FAD8B3C20BDF1D18F")
    static HardwareRenderer createGlRenderer(int glVersion, boolean translucent) {
        switch (glVersion) {
            case 2:
                return Gl20Renderer.create(translucent);
        }
        throw new IllegalArgumentException("Unknown GL version: " + glVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "6B7DE4E21B02A7055F930254E2A5AEE4", hash_generated_method = "3CB24B0546585868D5A010CEBFFBB49D")
    static void trimMemory(int level) {
        Gl20Renderer.trimMemory(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "D88BDAAECB5E3C9E13C6C75580C56722")
    @DSModeled(DSC.SAFE)
     boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "E431274334564F99DE06BE0647F24670", hash_generated_method = "7AF111C330CEE878DD826846B770A700")
    @DSModeled(DSC.SAFE)
     void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "2657035D37B57C6EB1FDEBFDEB2FC631", hash_generated_method = "5ABF8BC4C82CC9C42E59C73E5652D89F")
    @DSModeled(DSC.SAFE)
     boolean isRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.007 -0400", hash_original_method = "5489F62162525BB08E1A950602557C7B", hash_generated_method = "D3A0C7244FE8D2CF497672585A51583C")
    @DSModeled(DSC.SAFE)
     void setRequested(boolean requested) {
        dsTaint.addTaint(requested);
        // ---------- Original Method ----------
        //mRequested = requested;
    }

    
    static abstract class GlRenderer extends HardwareRenderer {
        static final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
        static final int EGL_OPENGL_ES2_BIT = 4;
        static final int EGL_SURFACE_TYPE = 0x3033;
        static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 0x0400;
        static final int SURFACE_STATE_ERROR = 0;
        static final int SURFACE_STATE_SUCCESS = 1;
        static final int SURFACE_STATE_UPDATED = 2;
        static EGL10 sEgl;
        static EGLDisplay sEglDisplay;
        static EGLConfig sEglConfig;
        static final Object[] sEglLock = new Object[0];
        int mWidth = -1, mHeight = -1;
        static final ThreadLocal<Gl20Renderer.Gl20RendererEglContext> sEglContextStorage
                = new ThreadLocal<Gl20Renderer.Gl20RendererEglContext>();
        EGLContext mEglContext;
        Thread mEglThread;
        EGLSurface mEglSurface;
        GL mGl;
        HardwareCanvas mCanvas;
        int mFrameCount;
        Paint mDebugPaint;
        static boolean sDirtyRegions;
        static final boolean sDirtyRegionsRequested;
        boolean mDirtyRegionsEnabled;
        final boolean mVsyncDisabled;
        final int mGlVersion;
        final boolean mTranslucent;
        private boolean mDestroyed;
        private final Rect mRedrawClip = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "10324A50C61190B04368151ACA88DC91", hash_generated_method = "3CE87FE1398F751F52511982AF730134")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         GlRenderer(int glVersion, boolean translucent) {
            dsTaint.addTaint(glVersion);
            dsTaint.addTaint(translucent);
            mTranslucent = translucent;
            mGlVersion = glVersion;
            final String vsyncProperty;
            vsyncProperty = SystemProperties.get(DISABLE_VSYNC_PROPERTY, "false");
            mVsyncDisabled = "true".equalsIgnoreCase(vsyncProperty);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "8E011D652AD55D9A8BD48AFBDECCE639", hash_generated_method = "A12B009E8E85718EADD1FEF0D88A0CA7")
        @DSModeled(DSC.SAFE)
         boolean hasDirtyRegions() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDirtyRegionsEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "5D86F2EDCD8D2650FE0B69784B6D885F", hash_generated_method = "E07484F080FF9D4686E8BA5E1B0292D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void checkEglErrors() {
            {
                boolean var144802B2B6A01A50D0C4CE42DADB3B73_1875588652 = (isEnabled());
                {
                    int error;
                    error = sEgl.eglGetError();
                    {
                        fallback(error != EGL11.EGL_CONTEXT_LOST);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isEnabled()) {
                //int error = sEgl.eglGetError();
                //if (error != EGL_SUCCESS) {
                    //Log.w(LOG_TAG, "EGL error: " + GLUtils.getEGLErrorString(error));
                    //fallback(error != EGL11.EGL_CONTEXT_LOST);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "87E6FBE52BF3E41B35644D0BA431AF43", hash_generated_method = "3F212E171C244CD1552BA0DDF0B24910")
        @DSModeled(DSC.SAFE)
        private void fallback(boolean fallback) {
            dsTaint.addTaint(fallback);
            destroy(true);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "921EA5B73D96C86CDA9474B12ADD4C25", hash_generated_method = "8AEF69C75A0601CB258FA7E9FF16C542")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            dsTaint.addTaint(holder.dsTaint);
            {
                boolean var3BCB7015259C3CB8CF45488CDBC1CF77_1355855388 = (isRequested() && !isEnabled());
                {
                    initializeEgl();
                    mGl = createEglSurface(holder);
                    mDestroyed = false;
                    {
                        int err;
                        err = sEgl.eglGetError();
                        {
                            destroy(true);
                            setRequested(false);
                        } //End block
                        {
                            {
                                mCanvas = createCanvas();
                            } //End block
                            {
                                setEnabled(true);
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.008 -0400", hash_original_method = "2D2C42A66AD2DEB924E2F6769D89C4AD", hash_generated_method = "A96E7742C3E24D80C48033ACD1FCDA3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            dsTaint.addTaint(holder.dsTaint);
            {
                boolean var50F3BA8A55559ACD41E86FE1D11F765A_664171256 = (isRequested() && isEnabled());
                {
                    createEglSurface(holder);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isRequested() && isEnabled()) {
                //createEglSurface(holder);
            //}
        }

        
        abstract GLES20Canvas createCanvas();

        
        abstract int[] getConfig(boolean dirtyRegions);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.009 -0400", hash_original_method = "B279C4718AE98DC5BFCF9CC39FB51005", hash_generated_method = "7D18A53EE08C871E5344C194DD5996CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void initializeEgl() {
            {
                {
                    sEgl = (EGL10) EGLContext.getEGL();
                    sEglDisplay = sEgl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglGetDisplay failed "
                                + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                    } //End block
                    int[] version;
                    version = new int[2];
                    {
                        boolean varD6156887E7BE0E650F0700155892DF35_1976287408 = (!sEgl.eglInitialize(sEglDisplay, version));
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglInitialize failed " +
                                GLUtils.getEGLErrorString(sEgl.eglGetError()));
                        } //End block
                    } //End collapsed parenthetic
                    sEglConfig = chooseEglConfig();
                    {
                        {
                            sDirtyRegions = false;
                            sEglConfig = chooseEglConfig();
                            {
                            	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
                            } //End block
                        } //End block
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
                        } //End block
                    } //End block
                } //End block
            } //End block
            Gl20Renderer.Gl20RendererEglContext managedContext;
            managedContext = sEglContextStorage.get();
            mEglContext = managedContext != null ? managedContext.getContext() : null;
            mEglThread = Thread.currentThread();
            {
                mEglContext = createContext(sEgl, sEglDisplay, sEglConfig);
                sEglContextStorage.set(new Gl20Renderer.Gl20RendererEglContext(mEglContext));
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.009 -0400", hash_original_method = "7EBBB0609098A0727E2316EE23892E6C", hash_generated_method = "2AA25B4B16F7C65B0F7AD2AF0777017A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private EGLConfig chooseEglConfig() {
            EGLConfig[] configs;
            configs = new EGLConfig[1];
            int[] configsCount;
            configsCount = new int[1];
            int[] configSpec;
            configSpec = getConfig(sDirtyRegions);
            final String debug;
            debug = SystemProperties.get(PRINT_CONFIG_PROPERTY, "");
            {
                boolean var2BF498AF35B2DE8E8EC02AA6562A3CB6_165523352 = ("all".equalsIgnoreCase(debug));
                {
                    sEgl.eglChooseConfig(sEglDisplay, configSpec, null, 0, configsCount);
                    EGLConfig[] debugConfigs;
                    debugConfigs = new EGLConfig[configsCount[0]];
                    sEgl.eglChooseConfig(sEglDisplay, configSpec, debugConfigs,
                        configsCount[0], configsCount);
                    {
                        EGLConfig config = debugConfigs[0];
                        {
                            printConfig(config);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var291CF98780E894F321CE39735F052BBA_111213981 = (!sEgl.eglChooseConfig(sEglDisplay, configSpec, configs, 1, configsCount));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("eglChooseConfig failed " +
                        GLUtils.getEGLErrorString(sEgl.eglGetError()));
                } //End block
                {
                    {
                        boolean var1F4F220B1BF202484B8610575B52EA82_1135300880 = ("choice".equalsIgnoreCase(debug));
                        {
                            printConfig(configs[0]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (EGLConfig)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.009 -0400", hash_original_method = "0890A6845DB8299C7ED9F063C47BF666", hash_generated_method = "5B8201948C540CAD47936DFBFBC6C414")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void printConfig(EGLConfig config) {
            dsTaint.addTaint(config.dsTaint);
            int[] value;
            value = new int[1];
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.009 -0400", hash_original_method = "CE78C152F3B6BB29B0F51267B059EC85", hash_generated_method = "03141E1E0C1991854B459C35334D78BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         GL createEglSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            dsTaint.addTaint(holder.dsTaint);
            {
            	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("egl not initialized");
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglDisplay not initialized");
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
            } //End block
            {
                boolean varE1A0062923CC8D105E1D641BD84ED7EC_575770295 = (Thread.currentThread() != mEglThread);
                {
                	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HardwareRenderer cannot be used " 
                        + "from multiple threads");
                } //End block
            } //End collapsed parenthetic
            destroySurface();
            {
                boolean var3C9C186337E0EEDBC330EDFE5EA34947_529909206 = (!createSurface(holder));
            } //End collapsed parenthetic
            {
                boolean var3C1887F134AFD0772B92DDFACA365517_1464405433 = (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext));
                {
                	if (DroidSafeAndroidRuntime.control) throw new Surface.OutOfResourcesException("eglMakeCurrent failed "
                        + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                } //End block
            } //End collapsed parenthetic
            initCaches();
            {
                {
                    boolean varFC05E1FC19D1A0180D13CF66EEE4B0BE_858673431 = (!(mDirtyRegionsEnabled = GLES20Canvas.preserveBackBuffer()));
                } //End collapsed parenthetic
            } //End block
            {
                mDirtyRegionsEnabled = GLES20Canvas.isBackBufferPreserved();
            } //End block
            GL varF9D0933A023DBDCACF739D8C1B82A3B2_2009433886 = (mEglContext.getGL());
            return (GL)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        abstract void initCaches();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "25878E68191E1BEA8EFD58CC92DB697F", hash_generated_method = "4AA8140A83CC5139D63842716E085289")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
            dsTaint.addTaint(egl.dsTaint);
            dsTaint.addTaint(eglDisplay.dsTaint);
            dsTaint.addTaint(eglConfig.dsTaint);
            int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };
            EGLContext var4DEF2E5618C652038EDD892C62DCB0A3_1451664991 = (egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    mGlVersion != 0 ? attribs : null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (EGLContext)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };
            //return egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    //mGlVersion != 0 ? attribs : null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "476B6B31B3E717E00869D611EE7348F9", hash_generated_method = "A2341D9180E71755C08E86545DDC9F84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void destroy(boolean full) {
            dsTaint.addTaint(full);
            {
                mCanvas = null;
            } //End block
            {
                boolean var7FD2B2AC2F812E9E15F51250DF65D54F_533611017 = (!isEnabled() || mDestroyed);
                {
                    setEnabled(false);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "8729F371C5ECEEE6F9AFEEF006F001BC", hash_generated_method = "81A6948403558CBB747CEDD38C9A5173")
        @DSModeled(DSC.SAFE)
         void destroySurface() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "31AB32F492C93DC28936068651BB9A5D", hash_generated_method = "B9236EDCBF4EADEE2D413B9402A91AA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void invalidate(SurfaceHolder holder) {
            dsTaint.addTaint(holder.dsTaint);
            sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
            {
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
                setEnabled(false);
            } //End block
            {
                boolean varCBFBE03196001F4D16583BA378EC3188_940411843 = (holder.getSurface().isValid());
                {
                    {
                        boolean varD9304243F22C6F34FB847EA974654D54_1049429679 = (!createSurface(holder));
                    } //End collapsed parenthetic
                    {
                        setEnabled(true);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "DE5D7845AE9FF0DF12BC88C1DA1B9378", hash_generated_method = "D5AFD37CC1D175033C516B6A2CE8788E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean createSurface(SurfaceHolder holder) {
            dsTaint.addTaint(holder.dsTaint);
            mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, holder, null);
            {
                int error;
                error = sEgl.eglGetError();
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("createWindowSurface failed "
                        + GLUtils.getEGLErrorString(error));
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.010 -0400", hash_original_method = "5192B6F9979CE04F5E58A6D4E6C990F7", hash_generated_method = "BC18E62AA72904E949B3300F75E7D4C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         boolean validate() {
            boolean varD9475434482CCC29748C80263F853577_863676965 = (checkCurrent() != SURFACE_STATE_ERROR);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return checkCurrent() != SURFACE_STATE_ERROR;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "432BCA9410981741609CBA70FE61BE99", hash_generated_method = "2D813D55151C44F62BADF0D31D135993")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void setup(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            {
                boolean var17D7A803A05FFA096A6B1D8A438BE6FB_568079438 = (validate());
                {
                    mCanvas.setViewport(width, height);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (validate()) {
                //mCanvas.setViewport(width, height);
                //mWidth = width;
                //mHeight = height;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "E0F82C039FAF82B3856FE8DC15F2C65F")
        @DSModeled(DSC.SAFE)
        @Override
         int getWidth() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "B3CF5C992C09ED603D0B68DCA3160615")
        @DSModeled(DSC.SAFE)
        @Override
         int getHeight() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "443A478AAAFFF6029C47008822277BFC")
        @DSModeled(DSC.SAFE)
        @Override
         HardwareCanvas getCanvas() {
            return (HardwareCanvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCanvas;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "BAED9FCEBD48E8CDA814A9102CB815B2", hash_generated_method = "FDB5DA46EFB559488428EAB7D7F883B9")
        @DSModeled(DSC.SAFE)
         boolean canDraw() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mGl != null && mCanvas != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "5270AAD77A1E26F7563AFAAC446C8262", hash_generated_method = "514232BA1C5F4CBFCFAEBE37BBD91973")
        @DSModeled(DSC.SAFE)
         void onPreDraw(Rect dirty) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(dirty.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "600776A2676C628EF453DCB2EAD62BCF", hash_generated_method = "33B0BF943B06EE8F6237C74E73C3861A")
        @DSModeled(DSC.SAFE)
         void onPostDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.011 -0400", hash_original_method = "48B4102DE0A767B3D4749D592D5492A5", hash_generated_method = "EDDC2CB05758DDD3E59A9615F66061ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
                Rect dirty) {
            dsTaint.addTaint(callbacks.dsTaint);
            dsTaint.addTaint(dirty.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(attachInfo.dsTaint);
            {
                boolean var7B873551A23ADB6964E1E62C26C12628_1837868998 = (canDraw());
                {
                    {
                        boolean varC3BDE9FC350118928E1C88FC962287F4_998142245 = (!hasDirtyRegions());
                        {
                            dirty = null;
                        } //End block
                        {
                            dirty.intersect(0, 0, mWidth, mHeight);
                        } //End block
                    } //End collapsed parenthetic
                    attachInfo.mIgnoreDirtyState = true;
                    attachInfo.mDrawingTime = SystemClock.uptimeMillis();
                    view.mPrivateFlags |= View.DRAWN;
                    final int surfaceState;
                    surfaceState = checkCurrent();
                    {
                        {
                            dirty = null;
                        } //End block
                        onPreDraw(dirty);
                        HardwareCanvas canvas;
                        canvas = mCanvas;
                        attachInfo.mHardwareCanvas = canvas;
                        int saveCount;
                        saveCount = canvas.save();
                        callbacks.onHardwarePreDraw(canvas);
                        try 
                        {
                            view.mRecreateDisplayList =
                                (view.mPrivateFlags & View.INVALIDATED) == View.INVALIDATED;
                            view.mPrivateFlags &= ~View.INVALIDATED;
                            DisplayList displayList;
                            displayList = view.getDisplayList();
                            {
                                {
                                    boolean varBF7A0A5847B93025D7528D98A8C75811_1223037265 = (canvas.drawDisplayList(displayList, view.getWidth(),
                                    view.getHeight(), mRedrawClip));
                                    {
                                        {
                                            boolean varD7B1D0D428000B522C58B6351FDB129E_1780663474 = (mRedrawClip.isEmpty() || view.getParent() == null);
                                            {
                                                view.invalidate();
                                            } //End block
                                            {
                                                view.getParent().invalidateChild(view, mRedrawClip);
                                            } //End block
                                        } //End collapsed parenthetic
                                        mRedrawClip.setEmpty();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                view.draw(canvas);
                            } //End block
                            {
                                {
                                    mDebugPaint = new Paint();
                                    mDebugPaint.setColor(0x7fff0000);
                                } //End block
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
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "F54ECE08CE2E8C98D4ED45C8BC0241CA", hash_generated_method = "D4547B0EA51A5AE0739672DFD20E3BE8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int checkCurrent() {
            {
                boolean var2BE000E074BA4ADE1630B6A389B9A4D8_1215275536 = (mEglThread != Thread.currentThread());
                {
                	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Hardware acceleration can only be used with a " +
                        "single UI thread.\nOriginal thread: " + mEglThread + "\n" +
                        "Current thread: " + Thread.currentThread());
                } //End block
            } //End collapsed parenthetic
            {
                boolean var383C1CBFF0E87A815F96650DC2FDC9F7_880009312 = (!mEglContext.equals(sEgl.eglGetCurrentContext()) ||
                    !mEglSurface.equals(sEgl.eglGetCurrentSurface(EGL_DRAW)));
                {
                    {
                        boolean varAE201570A32AF474310E703D42CF4FE4_1510023800 = (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext));
                        {
                            fallback(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static {
            String dirtyProperty = SystemProperties.get(RENDER_DIRTY_REGIONS_PROPERTY, "true");
            sDirtyRegions = RENDER_DIRTY_REGIONS && "true".equalsIgnoreCase(dirtyProperty);
            sDirtyRegionsRequested = sDirtyRegions;
        }
        
    }


    
    static class Gl20Renderer extends GlRenderer {
        private GLES20Canvas mGlCanvas;
        private static EGLSurface sPbuffer;
        private static final Object[] sPbufferLock = new Object[0];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "B1E95719A4C359FC5D5C603A14B80EB3", hash_generated_method = "BE90E2C2756F913273E86F11D2A6DA4E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Gl20Renderer(boolean translucent) {
            super(2, translucent);
            dsTaint.addTaint(translucent);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "F74985FDFA2E9230D4C8D7E9B7CADFBD", hash_generated_method = "583A711A069B56BD736F6B894CD2F5AB")
        @DSModeled(DSC.SAFE)
        @Override
         GLES20Canvas createCanvas() {
            GLES20Canvas varF1FA269B32523AE772B76DE0A817AD90_307913697 = (mGlCanvas = new GLES20Canvas(mTranslucent));
            return (GLES20Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mGlCanvas = new GLES20Canvas(mTranslucent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "F0C99ACF7C56841B3F486F5BFE1F4C1E", hash_generated_method = "9C8669F5E0681E60FF370377DC7B055A")
        @DSModeled(DSC.SAFE)
        @Override
         int[] getConfig(boolean dirtyRegions) {
            dsTaint.addTaint(dirtyRegions);
            int[] retVal = new int[1];
            retVal[0] = dsTaint.getTaintInt();
            return retVal;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "7C06275E87085241F3D16D3C83742A74", hash_generated_method = "E0DD2B0B7D1D734767E89EA7857A33E2")
        @DSModeled(DSC.SAFE)
        @Override
         void initCaches() {
            GLES20Canvas.initCaches();
            // ---------- Original Method ----------
            //GLES20Canvas.initCaches();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "C7C1539F42BBDC0F7B3C1C5760B83BD0", hash_generated_method = "06482E7E9ADED4108396E85E3DD6E45C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         boolean canDraw() {
            boolean var035A8626DACD2769091177CDE818C3DB_600792520 = (super.canDraw() && mGlCanvas != null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return super.canDraw() && mGlCanvas != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "0022B5A5096431CE2C7606DC3316BE73", hash_generated_method = "33BC4368D8954579C98D80AD39D98A8F")
        @DSModeled(DSC.SAFE)
        @Override
         void onPreDraw(Rect dirty) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(dirty.dsTaint);
            mGlCanvas.onPreDraw(dirty);
            // ---------- Original Method ----------
            //mGlCanvas.onPreDraw(dirty);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.012 -0400", hash_original_method = "7433D62E540EA68CB724AA636E5E1121", hash_generated_method = "83165D3A202552EEB86378FC8C276D2E")
        @DSModeled(DSC.SAFE)
        @Override
         void onPostDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mGlCanvas.onPostDraw();
            // ---------- Original Method ----------
            //mGlCanvas.onPostDraw();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "6E3A6DE775BA1410C4AD975BAADAD54E", hash_generated_method = "F2F201443D1A2F03BF586C929DC7F88E")
        @DSModeled(DSC.SAFE)
        @Override
         void destroy(boolean full) {
            dsTaint.addTaint(full);
            try 
            {
                super.destroy(full);
            } //End block
            finally 
            {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "E63C13501979998737C0E9B67210D488", hash_generated_method = "40D5903EF27389955754A4DFAA7FEF03")
        @DSModeled(DSC.SAFE)
        @Override
         void setup(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            super.setup(width, height);
            {
                GLES20Canvas.disableVsync();
            } //End block
            // ---------- Original Method ----------
            //super.setup(width, height);
            //if (mVsyncDisabled) {
                //GLES20Canvas.disableVsync();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "91DF561E8BF11B235EB0CF61AE2449D1", hash_generated_method = "74728DC1EA3AF2E5199604822BB44B48")
        @DSModeled(DSC.SAFE)
        @Override
         DisplayList createDisplayList() {
            return (DisplayList)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GLES20DisplayList();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "9926A5C358BE0969CD82CBEFEE88B0C5", hash_generated_method = "5C26250DEA1482E0B09330AF4D2E3AA6")
        @DSModeled(DSC.SAFE)
        @Override
         HardwareLayer createHardwareLayer(boolean isOpaque) {
            dsTaint.addTaint(isOpaque);
            return (HardwareLayer)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GLES20TextureLayer(isOpaque);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "4877A9BF76918321656F296A4083E728", hash_generated_method = "74EB2CBD8F8B2F33446C393F901AF80F")
        @DSModeled(DSC.SAFE)
        @Override
         HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(isOpaque);
            return (HardwareLayer)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GLES20RenderLayer(width, height, isOpaque);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "2626CBE8666291C6CAEC91C70C04EEE5", hash_generated_method = "1EACC0D99E4590F9221527CF368BA168")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         SurfaceTexture createSurfaceTexture(HardwareLayer layer) {
            dsTaint.addTaint(layer.dsTaint);
            SurfaceTexture var5EECCFAEEB08809EA268C821817D5DDC_1093817601 = (((GLES20TextureLayer) layer).getSurfaceTexture());
            return (SurfaceTexture)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((GLES20TextureLayer) layer).getSurfaceTexture();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "47CAC65634322D23BF323CE20E51DB06", hash_generated_method = "D9008E4D2B535D47C13DF5C90BDB6539")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void destroyLayers(View view) {
            dsTaint.addTaint(view.dsTaint);
            {
                boolean varC249819A4D06EA9938518237597D517E_1316928038 = (view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR);
                {
                    destroyHardwareLayer(view);
                    GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR) {
                //destroyHardwareLayer(view);
                //GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "3A587C3870D559FE72764A828C177D6D", hash_generated_method = "EDE28C6E6EC3F1BD0A1A015E207F1D6C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "05E9CAD7CA3059A2D779D6F5B2F697AA", hash_generated_method = "F10FFD9D7512CC1ED5102026BE621405")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void destroyHardwareResources(View view) {
            dsTaint.addTaint(view.dsTaint);
            {
                boolean needsContext;
                needsContext = true;
                {
                    boolean var50ED5639F05964E73DC32579A230672A_1013935894 = (isEnabled() && checkCurrent() != SURFACE_STATE_ERROR);
                    needsContext = false;
                } //End collapsed parenthetic
                {
                    Gl20RendererEglContext managedContext;
                    managedContext = sEglContextStorage.get();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.013 -0400", hash_original_method = "8521FC3B281A56CFA34090E93CBC7058", hash_generated_method = "2C7B68118FF5420F1FD37CECE14B634D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.014 -0400", hash_original_method = "7C42AE7FEC85968DC821581EB40A786E", hash_generated_method = "685D7EED2668661A3A81CF9CA425E372")
        static HardwareRenderer create(boolean translucent) {
            if (GLES20Canvas.isAvailable()) {
                return new Gl20Renderer(translucent);
            }
            return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.014 -0400", hash_original_method = "07359DC32B0E99110D7D4927D57C3077", hash_generated_method = "6B9291971D245AF79EE5FF9781989F85")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.014 -0400", hash_original_method = "34BFF10BDA33F8F3E764109893739A93", hash_generated_method = "34F92E4D0231E7880AC962B6A1A82C08")
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
            final Handler mHandler = new Handler();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.014 -0400", hash_original_method = "DAB7F8E2E2F55BAE2E6064B879DDA260", hash_generated_method = "6D48D4AE8188438084B6245ACE5F3500")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Gl20RendererEglContext(EGLContext context) {
                super(context);
                dsTaint.addTaint(context.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.014 -0400", hash_original_method = "022CE21F17BE8021C39A7EA65E477736", hash_generated_method = "2E3AECE804B593EC0803E5071FEE07AF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onTerminate(final EGLContext eglContext) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(eglContext.dsTaint);
                {
                    boolean var72DF4570FAAFD5BF41841B28E36357E7_1455310841 = (mHandler.getLooper() != Looper.myLooper());
                    {
                        mHandler.post(new Runnable() {
                        @Override public void run() {
                            onTerminate(eglContext);
                        }
                    });
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean var582F742B3D76F186D18ABD8532921AC2_783726509 = (EGLImpl.getInitCount(sEglDisplay) == 1);
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
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    interface HardwareDrawCallbacks {
        
        void onHardwarePreDraw(HardwareCanvas canvas);

        
        void onHardwarePostDraw(HardwareCanvas canvas);
    }
    
}


