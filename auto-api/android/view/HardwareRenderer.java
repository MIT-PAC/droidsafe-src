package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.509 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.509 -0400", hash_original_field = "49AC8048BC7573882A7251630928EF32", hash_generated_field = "1A824CB4728D8EA1700C48FC56A6A4D0")

    private boolean mRequested = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.509 -0400", hash_original_method = "E06114671092584077A71408305BD1AB", hash_generated_method = "E06114671092584077A71408305BD1AB")
    public HardwareRenderer ()
    {
        
    }


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

    
    @DSModeled(DSC.SAFE)
    public static void setupDiskCache(File cacheDir) {
        nSetupShadersDiskCache(new File(cacheDir, CACHE_PATH_SHADERS).getAbsolutePath());
    }

    
    private static void nSetupShadersDiskCache(String cacheFile) {
    }

    
    abstract boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
            Rect dirty);

    
    abstract DisplayList createDisplayList();

    
    abstract HardwareLayer createHardwareLayer(boolean isOpaque);

    
    abstract HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque);

    
    abstract SurfaceTexture createSurfaceTexture(HardwareLayer layer);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.514 -0400", hash_original_method = "9B70801888A6ED6A8A5716CEEB0139B3", hash_generated_method = "696B6F09DB81190178278396165C1D92")
     void initializeIfNeeded(int width, int height, View.AttachInfo attachInfo,
            SurfaceHolder holder) throws Surface.OutOfResourcesException {
        {
            boolean varC2E2705FCD6C547FA29A43E4EE096B77_1363564723 = (isRequested());
            {
                {
                    boolean varAE5712E4D523B0C93A265DF749E6E081_1610285797 = (!isEnabled());
                    {
                        {
                            boolean varF368F5F27839403AFE572C1398FD8488_171714375 = (initialize(holder));
                            {
                                setup(width, height);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(width);
        addTaint(height);
        addTaint(attachInfo.getTaint());
        addTaint(holder.getTaint());
        
        
            
                
                    
                
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.515 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "78EEF655A16119B5F3221AB3F976C53D")
     boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135924010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135924010;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.515 -0400", hash_original_method = "E431274334564F99DE06BE0647F24670", hash_generated_method = "C2CE1DB1D0D5E01CA74F489F1351598B")
     void setEnabled(boolean enabled) {
        mEnabled = enabled;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_method = "2657035D37B57C6EB1FDEBFDEB2FC631", hash_generated_method = "864A0B5FE8CD78D08FB92C871911F3EC")
     boolean isRequested() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945318717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945318717;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_method = "5489F62162525BB08E1A950602557C7B", hash_generated_method = "6C5945B8EA5D67FB5159E094E21FF9C0")
     void setRequested(boolean requested) {
        mRequested = requested;
        
        
    }

    
    static abstract class GlRenderer extends HardwareRenderer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "2BA03B5BE1E097B9BC57B210061D879D")

        int mWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3D81262840DA37820D58425FC486E30D")

        int mHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "4B5703969A5D1B3F20E76A16B21EF3AA", hash_generated_field = "75D18A698C8C0156FC372CC4CDC659FD")

        EGLContext mEglContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "6CB4022825BF3891C4CBC4215A165C31", hash_generated_field = "C8809406F874F748D7C2D2A82FC8CAFB")

        Thread mEglThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "BB92F1E402C2CF8873F9526C78C325F9", hash_generated_field = "3BCE51A04A846FE71AD218CCB7DF9B47")

        EGLSurface mEglSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "D13376DE2BC4474B01F1A83287CA2BC4", hash_generated_field = "776F52E98B7458F3181D343B01ABD47C")

        GL mGl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "37BD83BC682BDA2AAC757751086B36DE")

        HardwareCanvas mCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "EDB3186346B1612B7704D58A9CAAE15F", hash_generated_field = "2B862720623879764FB3C1B9EA11B335")

        int mFrameCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "67733C7F7D8E4C7C7A459C93C066173F", hash_generated_field = "FFE47057B50B334DD786C5E73414DC81")

        Paint mDebugPaint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "0A34812C66F525B1CA7E24023471D9BA", hash_generated_field = "ECB95A231B3EDB5A9081400631FFCAB1")

        boolean mDirtyRegionsEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "868C0C427245760814552A5B70CB53AF", hash_generated_field = "763734C03E6324334FBF6C22D68E5385")

        boolean mVsyncDisabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "5164B62B837448A39F3CCE947AE6F417", hash_generated_field = "F9D183B249EAF9218F504B0391DBAF55")

        int mGlVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.516 -0400", hash_original_field = "73CAD811A48D76CFFB6B1DC80D318679", hash_generated_field = "BA918D2716C9DCF541C02A323E8108FD")

        boolean mTranslucent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.517 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

        private boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.517 -0400", hash_original_field = "054D3AA75C56BAF25A15C014D3BEB501", hash_generated_field = "182B0379D371946AD3DA2504271E34F0")

        private final Rect mRedrawClip = new Rect();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.517 -0400", hash_original_method = "10324A50C61190B04368151ACA88DC91", hash_generated_method = "54CDE5FD66865137F71D5ED07635B7A6")
          GlRenderer(int glVersion, boolean translucent) {
            mGlVersion = glVersion;
            mTranslucent = translucent;
            final String vsyncProperty = SystemProperties.get(DISABLE_VSYNC_PROPERTY, "false");
            mVsyncDisabled = "true".equalsIgnoreCase(vsyncProperty);
            {
                Log.d(LOG_TAG, "Disabling v-sync");
            } 
            
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.517 -0400", hash_original_method = "8E011D652AD55D9A8BD48AFBDECCE639", hash_generated_method = "7C6720DE85AFCFA491669AAA962BC298")
         boolean hasDirtyRegions() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726782828 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_726782828;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.518 -0400", hash_original_method = "5D86F2EDCD8D2650FE0B69784B6D885F", hash_generated_method = "029522EBBD9B1B8DE64EE09171E3FB9C")
         void checkEglErrors() {
            {
                boolean var144802B2B6A01A50D0C4CE42DADB3B73_814039138 = (isEnabled());
                {
                    int error = sEgl.eglGetError();
                    {
                        fallback(error != EGL11.EGL_CONTEXT_LOST);
                    } 
                } 
            } 
            
            
                
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.518 -0400", hash_original_method = "87E6FBE52BF3E41B35644D0BA431AF43", hash_generated_method = "E473E7E963133FDD0FE2A6AD74B5AD72")
        private void fallback(boolean fallback) {
            destroy(true);
            {
                setRequested(false);
            } 
            addTaint(fallback);
            
            
            
                
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.518 -0400", hash_original_method = "921EA5B73D96C86CDA9474B12ADD4C25", hash_generated_method = "D5348133EA8DC8612696A89D5F6E84E4")
        @Override
         boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            {
                boolean var3BCB7015259C3CB8CF45488CDBC1CF77_1219476619 = (isRequested() && !isEnabled());
                {
                    initializeEgl();
                    mGl = createEglSurface(holder);
                    mDestroyed = false;
                    {
                        int err = sEgl.eglGetError();
                        {
                            destroy(true);
                            setRequested(false);
                        } 
                        {
                            {
                                mCanvas = createCanvas();
                            } 
                            {
                                setEnabled(true);
                            } 
                        } 
                    } 
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789408576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789408576;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.519 -0400", hash_original_method = "2D2C42A66AD2DEB924E2F6769D89C4AD", hash_generated_method = "56ACA7861C10A27D2CAF817C8911D0D3")
        @Override
         void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            {
                boolean var50F3BA8A55559ACD41E86FE1D11F765A_1512206159 = (isRequested() && isEnabled());
                {
                    createEglSurface(holder);
                } 
            } 
            addTaint(holder.getTaint());
            
            
                
            
        }

        
        abstract GLES20Canvas createCanvas();

        
        abstract int[] getConfig(boolean dirtyRegions);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.520 -0400", hash_original_method = "B279C4718AE98DC5BFCF9CC39FB51005", hash_generated_method = "97CEE127C4A058D0421FB6B1B5AE70A5")
         void initializeEgl() {
            {
                {
                    sEgl = (EGL10) EGLContext.getEGL();
                    sEglDisplay = sEgl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglGetDisplay failed "
                                + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                    } 
                    int[] version = new int[2];
                    {
                        boolean varD6156887E7BE0E650F0700155892DF35_646905287 = (!sEgl.eglInitialize(sEglDisplay, version));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglInitialize failed " +
                                GLUtils.getEGLErrorString(sEgl.eglGetError()));
                        } 
                    } 
                    sEglConfig = chooseEglConfig();
                    {
                        {
                            sDirtyRegions = false;
                            sEglConfig = chooseEglConfig();
                            {
                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
                            } 
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
                        } 
                    } 
                } 
            } 
            Gl20Renderer.Gl20RendererEglContext managedContext = sEglContextStorage.get();
            mEglContext = managedContext != null ? managedContext.getContext() : null;
            mEglThread = Thread.currentThread();
            {
                mEglContext = createContext(sEgl, sEglDisplay, sEglConfig);
                sEglContextStorage.set(new Gl20Renderer.Gl20RendererEglContext(mEglContext));
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.534 -0400", hash_original_method = "7EBBB0609098A0727E2316EE23892E6C", hash_generated_method = "F4D8E79B291E859D45B2A7B1DF7CCF2E")
        private EGLConfig chooseEglConfig() {
            EGLConfig varB4EAC82CA7396A68D541C85D26508E83_1120089756 = null; 
            EGLConfig varB4EAC82CA7396A68D541C85D26508E83_1127852702 = null; 
            EGLConfig[] configs = new EGLConfig[1];
            int[] configsCount = new int[1];
            int[] configSpec = getConfig(sDirtyRegions);
            final String debug = SystemProperties.get(PRINT_CONFIG_PROPERTY, "");
            {
                boolean var2BF498AF35B2DE8E8EC02AA6562A3CB6_2147095922 = ("all".equalsIgnoreCase(debug));
                {
                    sEgl.eglChooseConfig(sEglDisplay, configSpec, null, 0, configsCount);
                    EGLConfig[] debugConfigs = new EGLConfig[configsCount[0]];
                    sEgl.eglChooseConfig(sEglDisplay, configSpec, debugConfigs,
                        configsCount[0], configsCount);
                    {
                        EGLConfig config = debugConfigs[0];
                        {
                            printConfig(config);
                        } 
                    } 
                } 
            } 
            {
                boolean var291CF98780E894F321CE39735F052BBA_1994457276 = (!sEgl.eglChooseConfig(sEglDisplay, configSpec, configs, 1, configsCount));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("eglChooseConfig failed " +
                        GLUtils.getEGLErrorString(sEgl.eglGetError()));
                } 
                {
                    {
                        boolean var1F4F220B1BF202484B8610575B52EA82_925676833 = ("choice".equalsIgnoreCase(debug));
                        {
                            printConfig(configs[0]);
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1120089756 = configs[0];
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1127852702 = null;
            EGLConfig varA7E53CE21691AB073D9660D615818899_1453383803; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1453383803 = varB4EAC82CA7396A68D541C85D26508E83_1120089756;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1453383803 = varB4EAC82CA7396A68D541C85D26508E83_1127852702;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1453383803.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1453383803;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.535 -0400", hash_original_method = "0890A6845DB8299C7ED9F063C47BF666", hash_generated_method = "EE90F5190AF13B65EF515CF07BECA397")
        private void printConfig(EGLConfig config) {
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
            addTaint(config.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.536 -0400", hash_original_method = "CE78C152F3B6BB29B0F51267B059EC85", hash_generated_method = "EFD48E0330FD6EE9EDE0B22EAD03353F")
         GL createEglSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            GL varB4EAC82CA7396A68D541C85D26508E83_1414060863 = null; 
            GL varB4EAC82CA7396A68D541C85D26508E83_1687144342 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("egl not initialized");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglDisplay not initialized");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("eglConfig not initialized");
            } 
            {
                boolean varE1A0062923CC8D105E1D641BD84ED7EC_1402181151 = (Thread.currentThread() != mEglThread);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("HardwareRenderer cannot be used " 
                        + "from multiple threads");
                } 
            } 
            destroySurface();
            {
                boolean var3C9C186337E0EEDBC330EDFE5EA34947_649997097 = (!createSurface(holder));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1414060863 = null;
                } 
            } 
            {
                boolean var3C1887F134AFD0772B92DDFACA365517_1584714763 = (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext));
                {
                    if (DroidSafeAndroidRuntime.control) throw new Surface.OutOfResourcesException("eglMakeCurrent failed "
                        + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                } 
            } 
            initCaches();
            {
                {
                    boolean varFC05E1FC19D1A0180D13CF66EEE4B0BE_1616259433 = (!(mDirtyRegionsEnabled = GLES20Canvas.preserveBackBuffer()));
                } 
            } 
            {
                mDirtyRegionsEnabled = GLES20Canvas.isBackBufferPreserved();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1687144342 = mEglContext.getGL();
            addTaint(holder.getTaint());
            GL varA7E53CE21691AB073D9660D615818899_6462972; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_6462972 = varB4EAC82CA7396A68D541C85D26508E83_1414060863;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_6462972 = varB4EAC82CA7396A68D541C85D26508E83_1687144342;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_6462972.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_6462972;
            
            
        }

        
        abstract void initCaches();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.537 -0400", hash_original_method = "25878E68191E1BEA8EFD58CC92DB697F", hash_generated_method = "527C45D20E1BEACC8B25FAEB8168B8CC")
         EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
            EGLContext varB4EAC82CA7396A68D541C85D26508E83_323933389 = null; 
            int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };
            varB4EAC82CA7396A68D541C85D26508E83_323933389 = egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    mGlVersion != 0 ? attribs : null);
            addTaint(egl.getTaint());
            addTaint(eglDisplay.getTaint());
            addTaint(eglConfig.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_323933389.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_323933389;
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.538 -0400", hash_original_method = "476B6B31B3E717E00869D611EE7348F9", hash_generated_method = "0CE6B54DE25F892056E8E6CA45F820C0")
        @Override
         void destroy(boolean full) {
            {
                mCanvas = null;
            } 
            {
                boolean var7FD2B2AC2F812E9E15F51250DF65D54F_1243129317 = (!isEnabled() || mDestroyed);
                {
                    setEnabled(false);
                } 
            } 
            destroySurface();
            setEnabled(false);
            mDestroyed = true;
            mGl = null;
            addTaint(full);
            
            
                
            
            
                
                
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.538 -0400", hash_original_method = "8729F371C5ECEEE6F9AFEEF006F001BC", hash_generated_method = "6DFE4C4673985EF01C6C017B284828E4")
         void destroySurface() {
            {
                sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.539 -0400", hash_original_method = "31AB32F492C93DC28936068651BB9A5D", hash_generated_method = "FD5E686B32DC663E1514397554884B41")
        @Override
         void invalidate(SurfaceHolder holder) {
            sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
            {
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
                setEnabled(false);
            } 
            {
                boolean varCBFBE03196001F4D16583BA378EC3188_1754425727 = (holder.getSurface().isValid());
                {
                    {
                        boolean varD9304243F22C6F34FB847EA974654D54_1193377157 = (!createSurface(holder));
                    } 
                    {
                        setEnabled(true);
                    } 
                } 
            } 
            addTaint(holder.getTaint());
            
            
            
                
                
                
            
            
                
                    
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.540 -0400", hash_original_method = "DE5D7845AE9FF0DF12BC88C1DA1B9378", hash_generated_method = "BEC605BE1C251317B875ED362B845CB9")
        private boolean createSurface(SurfaceHolder holder) {
            mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, holder, null);
            {
                int error = sEgl.eglGetError();
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("createWindowSurface failed "
                        + GLUtils.getEGLErrorString(error));
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_526624392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_526624392;
            
            
            
                
                
                    
                    
                
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.541 -0400", hash_original_method = "5192B6F9979CE04F5E58A6D4E6C990F7", hash_generated_method = "400F98617A3CBD2258968C9E98FF5053")
        @Override
         boolean validate() {
            boolean varD9475434482CCC29748C80263F853577_1575532238 = (checkCurrent() != SURFACE_STATE_ERROR);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252411294 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252411294;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.542 -0400", hash_original_method = "432BCA9410981741609CBA70FE61BE99", hash_generated_method = "E52451FF6A63AB676973BD10FEA41673")
        @Override
         void setup(int width, int height) {
            {
                boolean var17D7A803A05FFA096A6B1D8A438BE6FB_120265743 = (validate());
                {
                    mCanvas.setViewport(width, height);
                    mWidth = width;
                    mHeight = height;
                } 
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.542 -0400", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "CE881E387BB372F53B4706C4285526C0")
        @Override
         int getWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929995629 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929995629;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.542 -0400", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "E304BA92DB167459706EA50382266939")
        @Override
         int getHeight() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917433453 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917433453;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.543 -0400", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "63A266BD443E0D8EB43E5E728CC4A180")
        @Override
         HardwareCanvas getCanvas() {
            HardwareCanvas varB4EAC82CA7396A68D541C85D26508E83_188955710 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_188955710 = mCanvas;
            varB4EAC82CA7396A68D541C85D26508E83_188955710.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_188955710;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.543 -0400", hash_original_method = "BAED9FCEBD48E8CDA814A9102CB815B2", hash_generated_method = "D8B714B039F7B91989159CABF4CA5AF8")
         boolean canDraw() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964526446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_964526446;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.544 -0400", hash_original_method = "5270AAD77A1E26F7563AFAAC446C8262", hash_generated_method = "D1D1BF3A49F969C9AFF6B64380268E6B")
         void onPreDraw(Rect dirty) {
            
            addTaint(dirty.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.544 -0400", hash_original_method = "600776A2676C628EF453DCB2EAD62BCF", hash_generated_method = "CE44E4A0F53F45960A85861D50074AD3")
         void onPostDraw() {
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.545 -0400", hash_original_method = "B420691F06CB3429CDB4650F51ED53E5", hash_generated_method = "1050BFFEA5F0AD902657323898FEC659")
        @Override
         boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
                Rect dirty) {
            {
                boolean var7B873551A23ADB6964E1E62C26C12628_706434266 = (canDraw());
                {
                    {
                        boolean varC3BDE9FC350118928E1C88FC962287F4_1929000437 = (!hasDirtyRegions());
                        {
                            dirty = null;
                        } 
                    } 
                    attachInfo.mIgnoreDirtyState = true;
                    attachInfo.mDrawingTime = SystemClock.uptimeMillis();
                    view.mPrivateFlags |= View.DRAWN;
                    final int surfaceState = checkCurrent();
                    {
                        {
                            dirty = null;
                        } 
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
                            {
                                {
                                    boolean varBF7A0A5847B93025D7528D98A8C75811_1872306351 = (canvas.drawDisplayList(displayList, view.getWidth(),
                                    view.getHeight(), mRedrawClip));
                                    {
                                        {
                                            boolean varD7B1D0D428000B522C58B6351FDB129E_616116226 = (mRedrawClip.isEmpty() || view.getParent() == null);
                                            {
                                                view.invalidate();
                                            } 
                                            {
                                                view.getParent().invalidateChild(view, mRedrawClip);
                                            } 
                                        } 
                                        mRedrawClip.setEmpty();
                                    } 
                                } 
                            } 
                            {
                                view.draw(canvas);
                            } 
                            {
                                {
                                    mDebugPaint = new Paint();
                                    mDebugPaint.setColor(0x7fff0000);
                                } 
                                {
                                    canvas.drawRect(dirty, mDebugPaint);
                                } 
                            } 
                        } 
                        finally 
                        {
                            callbacks.onHardwarePostDraw(canvas);
                            canvas.restoreToCount(saveCount);
                            view.mRecreateDisplayList = false;
                        } 
                        onPostDraw();
                        attachInfo.mIgnoreDirtyState = false;
                        sEgl.eglSwapBuffers(sEglDisplay, mEglSurface);
                        checkEglErrors();
                    } 
                } 
            } 
            addTaint(view.getTaint());
            addTaint(attachInfo.getTaint());
            addTaint(callbacks.getTaint());
            addTaint(dirty.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164770254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_164770254;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_method = "F54ECE08CE2E8C98D4ED45C8BC0241CA", hash_generated_method = "ED5FC2A7226217EB15BD50CB2A0D5B34")
         int checkCurrent() {
            {
                boolean var2BE000E074BA4ADE1630B6A389B9A4D8_856220280 = (mEglThread != Thread.currentThread());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Hardware acceleration can only be used with a " +
                        "single UI thread.\nOriginal thread: " + mEglThread + "\n" +
                        "Current thread: " + Thread.currentThread());
                } 
            } 
            {
                boolean var383C1CBFF0E87A815F96650DC2FDC9F7_1357385344 = (!mEglContext.equals(sEgl.eglGetCurrentContext()) ||
                    !mEglSurface.equals(sEgl.eglGetCurrentSurface(EGL_DRAW)));
                {
                    {
                        boolean varAE201570A32AF474310E703D42CF4FE4_1733980421 = (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext));
                        {
                            fallback(true);
                        } 
                    } 
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838488530 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838488530;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "A19F59BE927F4F5E11AA32DB62E90314", hash_generated_field = "3E10338E50BF743AF77D21918619DEC3")

        static final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "97A00FC4142306DA1042323304264C1B", hash_generated_field = "2C445899F8A8AEDECF32FB9135B066D1")

        static final int EGL_OPENGL_ES2_BIT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "96D54B55AD0E4E40B6DCB87E61752FF9", hash_generated_field = "2A272558ACA6FC8A6614D6BA7458C75D")

        static final int EGL_SURFACE_TYPE = 0x3033;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "507D2DB29A3E835918E1443820044DA4", hash_generated_field = "C31026AE6C97B54F64BA8D74F4DB4624")

        static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 0x0400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "B3D3DE2F97138E3F4C8C1104D2283F22", hash_generated_field = "0938239E7634E9F8C37B8678E90396F9")

        static final int SURFACE_STATE_ERROR = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.546 -0400", hash_original_field = "AD7BA14E9F8D93599CF7E6857DE82E51", hash_generated_field = "A56E49F9D74B2FDD846AFDD966D2CA36")

        static final int SURFACE_STATE_SUCCESS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "5A39E5B262E2B76674680C1E93FBA130", hash_generated_field = "DCB1F5A31169FA47085409CF6AA15381")

        static final int SURFACE_STATE_UPDATED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "517CB8E1BF8BAAB4DD9DC6139F9CBA55", hash_generated_field = "89D62FD7DEAB0F4EA47FB451DD608D43")

        static EGL10 sEgl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "0DC55FC6F390572EB62834B8C0E81B1C", hash_generated_field = "4D6AA44B0537982BD4C758CAAEDCA2BB")

        static EGLDisplay sEglDisplay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "4B84BABA9DC89D85E1FD3FA8F9F1DA63", hash_generated_field = "AB7BB82C5C2E6AFE71B7DB7D36C3876B")

        static EGLConfig sEglConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "8A7FD20B727D1EBC888543F70503348B", hash_generated_field = "8E033D3FEBA28DC4C5024A9005A21267")

        static final Object[] sEglLock = new Object[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "C85C8C7C19C4A40E7B8BAD011C332FE3", hash_generated_field = "B964CE88695D4A806E497A467321E250")

        static final ThreadLocal<Gl20Renderer.Gl20RendererEglContext> sEglContextStorage = new ThreadLocal<Gl20Renderer.Gl20RendererEglContext>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "03A020BDC3E1EF59FB3D9C945D229599", hash_generated_field = "2552FD4B6C23E3B90D7EC1BBA8F3293E")

        static boolean sDirtyRegions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "693EC6F7BC7ED63CB47319C2DC57F448", hash_generated_field = "1C3D78F3A3106B7D131377ACD7D2905E")

        static boolean sDirtyRegionsRequested;
        static {
            String dirtyProperty = SystemProperties.get(RENDER_DIRTY_REGIONS_PROPERTY, "true");
            sDirtyRegions = RENDER_DIRTY_REGIONS && "true".equalsIgnoreCase(dirtyProperty);
            sDirtyRegionsRequested = sDirtyRegions;
        }
        
    }


    
    static class Gl20Renderer extends GlRenderer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.547 -0400", hash_original_field = "8BB014C044F807A0D79AB317C305F7F8", hash_generated_field = "A04C267767B10D74D267BE1DECB4FBB4")

        private GLES20Canvas mGlCanvas;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.548 -0400", hash_original_method = "B1E95719A4C359FC5D5C603A14B80EB3", hash_generated_method = "DDBF91067C6DB4EB1DC3ED91881B3482")
          Gl20Renderer(boolean translucent) {
            super(2, translucent);
            addTaint(translucent);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.550 -0400", hash_original_method = "F74985FDFA2E9230D4C8D7E9B7CADFBD", hash_generated_method = "1CEC7A81941114380E1AFFF4B0DB5687")
        @Override
         GLES20Canvas createCanvas() {
            GLES20Canvas varB4EAC82CA7396A68D541C85D26508E83_942699811 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_942699811 = mGlCanvas = new GLES20Canvas(mTranslucent);
            varB4EAC82CA7396A68D541C85D26508E83_942699811.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_942699811;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.550 -0400", hash_original_method = "F0C99ACF7C56841B3F486F5BFE1F4C1E", hash_generated_method = "6B81BAE9C31342F906C3A463E4E5AD56")
        @Override
         int[] getConfig(boolean dirtyRegions) {
            int[] var941023AB58F9EE17A68F90360D8ED29B_1877837437 = (new int[] {
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
            addTaint(dirtyRegions);
            int[] varB4CCCA26F9DB9189C32F33E82D425CFB_548035336 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_548035336;
            
            
                    
                    
                    
                    
                    
                    
                    
                    
                            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.551 -0400", hash_original_method = "7C06275E87085241F3D16D3C83742A74", hash_generated_method = "FE9E19F8157E46F4D596C9F48C05192B")
        @Override
         void initCaches() {
            GLES20Canvas.initCaches();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.551 -0400", hash_original_method = "C7C1539F42BBDC0F7B3C1C5760B83BD0", hash_generated_method = "062CE41BE259C25CCC968418E33F8093")
        @Override
         boolean canDraw() {
            boolean var035A8626DACD2769091177CDE818C3DB_807128673 = (super.canDraw() && mGlCanvas != null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12345059 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_12345059;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.551 -0400", hash_original_method = "0022B5A5096431CE2C7606DC3316BE73", hash_generated_method = "3FE2A9FF54B12B84B27310EBEDC340B7")
        @Override
         void onPreDraw(Rect dirty) {
            
            mGlCanvas.onPreDraw(dirty);
            addTaint(dirty.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.552 -0400", hash_original_method = "7433D62E540EA68CB724AA636E5E1121", hash_generated_method = "927CC0A07657DA1C5F4A57B52A17F932")
        @Override
         void onPostDraw() {
            
            mGlCanvas.onPostDraw();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.552 -0400", hash_original_method = "6E3A6DE775BA1410C4AD975BAADAD54E", hash_generated_method = "70185618C499004D5A5C2B8D98017584")
        @Override
         void destroy(boolean full) {
            try 
            {
                super.destroy(full);
            } 
            finally 
            {
                {
                    mGlCanvas = null;
                } 
            } 
            addTaint(full);
            
            
                
            
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.553 -0400", hash_original_method = "E63C13501979998737C0E9B67210D488", hash_generated_method = "4286DCEBC7B34BCB0F9768F3AC6F61C4")
        @Override
         void setup(int width, int height) {
            super.setup(width, height);
            {
                GLES20Canvas.disableVsync();
            } 
            addTaint(width);
            addTaint(height);
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.553 -0400", hash_original_method = "91DF561E8BF11B235EB0CF61AE2449D1", hash_generated_method = "F22DD3545EF0B3911FEBBE5B3526A83A")
        @Override
         DisplayList createDisplayList() {
            DisplayList varB4EAC82CA7396A68D541C85D26508E83_1672496051 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1672496051 = new GLES20DisplayList();
            varB4EAC82CA7396A68D541C85D26508E83_1672496051.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1672496051;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.554 -0400", hash_original_method = "9926A5C358BE0969CD82CBEFEE88B0C5", hash_generated_method = "5894576C4FB2E9DCFCC9236EFE5F72EB")
        @Override
         HardwareLayer createHardwareLayer(boolean isOpaque) {
            HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_873045943 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_873045943 = new GLES20TextureLayer(isOpaque);
            addTaint(isOpaque);
            varB4EAC82CA7396A68D541C85D26508E83_873045943.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_873045943;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.555 -0400", hash_original_method = "4877A9BF76918321656F296A4083E728", hash_generated_method = "12D7B7ECD61F279CB228BF4280C40245")
        @Override
         HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque) {
            HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_804765335 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_804765335 = new GLES20RenderLayer(width, height, isOpaque);
            addTaint(width);
            addTaint(height);
            addTaint(isOpaque);
            varB4EAC82CA7396A68D541C85D26508E83_804765335.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_804765335;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.555 -0400", hash_original_method = "2626CBE8666291C6CAEC91C70C04EEE5", hash_generated_method = "C0B1267488DAB065FDBDC85AF3701144")
        @Override
         SurfaceTexture createSurfaceTexture(HardwareLayer layer) {
            SurfaceTexture varB4EAC82CA7396A68D541C85D26508E83_1232220298 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1232220298 = ((GLES20TextureLayer) layer).getSurfaceTexture();
            addTaint(layer.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1232220298.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1232220298;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.556 -0400", hash_original_method = "47CAC65634322D23BF323CE20E51DB06", hash_generated_method = "CBC446EB4AFBB36E0C621160551A949D")
        @Override
         void destroyLayers(View view) {
            {
                boolean varC249819A4D06EA9938518237597D517E_1565594845 = (view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR);
                {
                    destroyHardwareLayer(view);
                    GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
                } 
            } 
            addTaint(view.getTaint());
            
            
                
                
            
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.557 -0400", hash_original_method = "05E9CAD7CA3059A2D779D6F5B2F697AA", hash_generated_method = "FEC55B67D7BA8D589ABEB04CBA9B2BFA")
        @Override
         void destroyHardwareResources(View view) {
            {
                boolean needsContext = true;
                {
                    boolean var50ED5639F05964E73DC32579A230672A_192980 = (isEnabled() && checkCurrent() != SURFACE_STATE_ERROR);
                    needsContext = false;
                } 
                {
                    Gl20RendererEglContext managedContext = sEglContextStorage.get();
                    usePbufferSurface(managedContext.getContext());
                } 
                destroyResources(view);
                GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            } 
            addTaint(view.getTaint());
            
            
                
                
                
                    
                    
                    
                
                
                
            
        }

        
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.558 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

            final Handler mHandler = new Handler();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.559 -0400", hash_original_method = "DAB7F8E2E2F55BAE2E6064B879DDA260", hash_generated_method = "30BCF69C0F54B16C64CD64F49D5AC7AC")
            public  Gl20RendererEglContext(EGLContext context) {
                super(context);
                addTaint(context.getTaint());
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_method = "022CE21F17BE8021C39A7EA65E477736", hash_generated_method = "22785257085BD67DD37B17017B5508A4")
            @Override
            public void onTerminate(final EGLContext eglContext) {
                
                {
                    boolean var72DF4570FAAFD5BF41841B28E36357E7_471709145 = (mHandler.getLooper() != Looper.myLooper());
                    {
                        mHandler.post(new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.560 -0400", hash_original_method = "21D2857ABF6002C575615AA7F88BFAF8", hash_generated_method = "FEB39EBDBF35BC9FF5BD7B79A3DED670")
                            @Override
                            public void run() {
                                onTerminate(eglContext);
                                
                                
                            }
});
                    } 
                } 
                {
                    {
                        boolean var582F742B3D76F186D18ABD8532921AC2_326466904 = (EGLImpl.getInitCount(sEglDisplay) == 1);
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
                        } 
                    } 
                } 
                addTaint(eglContext.getTaint());
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "EDA244A8C4565A775D56E24ADEB2FC59", hash_generated_field = "6C6559CCDF7784B417023844F64F56D4")

        private static EGLSurface sPbuffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "D522D77DC5D21C2E0332D0703628B0B9", hash_generated_field = "397F4B1C85C553C6A50924367AE7739B")

        private static final Object[] sPbufferLock = new Object[0];
    }


    
    interface HardwareDrawCallbacks {
        
        void onHardwarePreDraw(HardwareCanvas canvas);

        
        void onHardwarePostDraw(HardwareCanvas canvas);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "2CE86765ED6DE7B67B485EBC8407FCBF", hash_generated_field = "717E213E05D2F7DB8EEBB9B9EB1D0800")

    static final String LOG_TAG = "HardwareRenderer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "FC1A9F98AA9C84CCBBC0AEBA66BAE490", hash_generated_field = "B7B9392A7811B48512BF0381603745C8")

    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "601E0E9CFF9912C4775ACF10567152C3", hash_generated_field = "8EEB971F06F320DA447B8EF1EAEE0542")

    public static final boolean RENDER_DIRTY_REGIONS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "171CE27716A16B22686FE2BA986FD2C2", hash_generated_field = "92ABF1D349C9DCF39365EE9296F875F7")

    static final String RENDER_DIRTY_REGIONS_PROPERTY = "hwui.render_dirty_regions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "B776832CE6AB1117A3B1FEA2C94E267D", hash_generated_field = "216B53A2C64AD3B3E792D12B0494E523")

    static final String DISABLE_VSYNC_PROPERTY = "hwui.disable_vsync";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "7ABB5A5B8E6E258B121B6B9EDFFA0EEA", hash_generated_field = "AF7D24DB7B3520929345144B8569DE46")

    static final String PRINT_CONFIG_PROPERTY = "hwui.print_config";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "8D093686D9AC39D7C2BB739AFC3BB2FB", hash_generated_field = "51986C698AA97FF96AC59DB3C2F7A7C5")

    private static final boolean DEBUG_DIRTY_REGION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "7D6DBD06A0D268F3C0C1E8EABBEEB68D", hash_generated_field = "B133F2DB85933820B16416D91ED8E00F")

    public static boolean sRendererDisabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.561 -0400", hash_original_field = "4861EA08BD543FA120F4D88F28D142EB", hash_generated_field = "1FF74BCF78FCE0998B21A6610C492707")

    public static boolean sSystemRendererDisabled = false;
}

