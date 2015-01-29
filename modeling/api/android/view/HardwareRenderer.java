package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Invoke this method to disable hardware rendering in the current process.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.166 -0500", hash_original_method = "9C9980AFD7DCCC801BD37DEFF892DD3E", hash_generated_method = "685A2C4B8C1F25453A3976C90D8F5844")
    
public static void disable(boolean system) {
        sRendererDisabled = true;
        if (system) {
            sSystemRendererDisabled = true;
        }
    }

    /**
     * Indicates whether hardware acceleration is available under any form for
     * the view hierarchy.
     * 
     * @return True if the view hierarchy can potentially be hardware accelerated,
     *         false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.168 -0500", hash_original_method = "290EA92060FDC76DF9899DFDEC8C2AD8", hash_generated_method = "52EB6BC0E8887F652592EF95BA41BE76")
    
public static boolean isAvailable() {
        return GLES20Canvas.isAvailable();
    }

    /**
     * Sets the directory to use as a persistent storage for hardware rendering
     * resources.
     * 
     * @param cacheDir A directory the current process can write to
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.195 -0500", hash_original_method = "4D6DA7709E03DD958DC246E9D34F1611", hash_generated_method = "659680C38E48DF38D5BD90BD48E8C1D2")
    
public static void setupDiskCache(File cacheDir) {
        nSetupShadersDiskCache(new File(cacheDir, CACHE_PATH_SHADERS).getAbsolutePath());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nSetupShadersDiskCache(String cacheFile) {
    }

    /**
     * Creates a hardware renderer using OpenGL.
     * 
     * @param glVersion The version of OpenGL to use (1 for OpenGL 1, 11 for OpenGL 1.1, etc.)
     * @param translucent True if the surface is translucent, false otherwise
     * 
     * @return A hardware renderer backed by OpenGL.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.218 -0500", hash_original_method = "6EE96EBC477B77879F9A873960F8548A", hash_generated_method = "0502D06F1B00937FAD8B3C20BDF1D18F")
    
static HardwareRenderer createGlRenderer(int glVersion, boolean translucent) {
        switch (glVersion) {
            case 2:
                return Gl20Renderer.create(translucent);
        }
        throw new IllegalArgumentException("Unknown GL version: " + glVersion);
    }

    /**
     * Invoke this method when the system is running out of memory. This
     * method will attempt to recover as much memory as possible, based on
     * the specified hint.
     * 
     * @param level Hint about the amount of memory that should be trimmed,
     *              see {@link android.content.ComponentCallbacks}
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.221 -0500", hash_original_method = "6B7DE4E21B02A7055F930254E2A5AEE4", hash_generated_method = "3CB24B0546585868D5A010CEBFFBB49D")
    
static void trimMemory(int level) {
        Gl20Renderer.trimMemory(level);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.139 -0500", hash_original_field = "23AB7C9A6B8427249D427638F5C15FF0", hash_generated_field = "717E213E05D2F7DB8EEBB9B9EB1D0800")

    static final String LOG_TAG = "HardwareRenderer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.142 -0500", hash_original_field = "F20B14B2188068518098F699C5627D0D", hash_generated_field = "B7B9392A7811B48512BF0381603745C8")

    private static final String CACHE_PATH_SHADERS = "com.android.opengl.shaders_cache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.145 -0500", hash_original_field = "04AB30CF5DC322AFF771C097812BC007", hash_generated_field = "8EEB971F06F320DA447B8EF1EAEE0542")

    public static final boolean RENDER_DIRTY_REGIONS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.147 -0500", hash_original_field = "7E438A110D93A4591380704E6ACF41AE", hash_generated_field = "92ABF1D349C9DCF39365EE9296F875F7")

    static final String RENDER_DIRTY_REGIONS_PROPERTY = "hwui.render_dirty_regions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.150 -0500", hash_original_field = "64CFBD2D690DC5096AD5E6DE8A195D2F", hash_generated_field = "216B53A2C64AD3B3E792D12B0494E523")

    static final String DISABLE_VSYNC_PROPERTY = "hwui.disable_vsync";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.152 -0500", hash_original_field = "27AA96499236A6269BAA40BA846B01F0", hash_generated_field = "AF7D24DB7B3520929345144B8569DE46")

    static final String PRINT_CONFIG_PROPERTY = "hwui.print_config";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.154 -0500", hash_original_field = "A635CC2507A5893DC1F2910D99C06D75", hash_generated_field = "51986C698AA97FF96AC59DB3C2F7A7C5")

    private static final boolean DEBUG_DIRTY_REGION = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.157 -0500", hash_original_field = "990C5951FB2C0D7E79AA5842E5B34AF4", hash_generated_field = "B133F2DB85933820B16416D91ED8E00F")

    public static boolean sRendererDisabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.159 -0500", hash_original_field = "D5F291CE470D86CB768AA73A38C6DF8A", hash_generated_field = "1FF74BCF78FCE0998B21A6610C492707")

    public static boolean sSystemRendererDisabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.161 -0500", hash_original_field = "B372655E189CA31F1D74E7441882FA0E", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.164 -0500", hash_original_field = "0CE24D677BB0060A09BDAA76A732BC53", hash_generated_field = "1A824CB4728D8EA1700C48FC56A6A4D0")

    private boolean mRequested = true;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.525 -0400", hash_original_method = "E06114671092584077A71408305BD1AB", hash_generated_method = "E06114671092584077A71408305BD1AB")
    public HardwareRenderer ()
    {
        //Synthesized constructor
    }

    /**
     * Destroys the hardware rendering context.
     * 
     * @param full If true, destroys all associated resources.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.171 -0500", hash_original_method = "EB7A0DD175A25AECD4D2F9F82222FF48", hash_generated_method = "05828D357AD43E29595F907E12376CBA")
    
abstract void destroy(boolean full);

    /**
     * Initializes the hardware renderer for the specified surface.
     * 
     * @param holder The holder for the surface to hardware accelerate.
     * 
     * @return True if the initialization was successful, false otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.173 -0500", hash_original_method = "63A8D60474C2966D995D457C9B9955A2", hash_generated_method = "BB23AF9787C7F4B0052DAD454D80E6A3")
    
abstract boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException;
    
    /**
     * Updates the hardware renderer for the specified surface.
     * 
     * @param holder The holder for the surface to hardware accelerate
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.175 -0500", hash_original_method = "8FE0C4928F213DDB1AC5E22C50F47F64", hash_generated_method = "57E011FCF2E6041383AA2AC8D0251322")
    
abstract void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException;

    /**
     * Destroys the layers used by the specified view hierarchy.
     * 
     * @param view The root of the view hierarchy
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.177 -0500", hash_original_method = "C93C704EE574651A1BA9456BEAF67A6E", hash_generated_method = "517238A3DFAC8F150EBF533DA592EBC6")
    
abstract void destroyLayers(View view);

    /**
     * Destroys all hardware rendering resources associated with the specified
     * view hierarchy.
     * 
     * @param view The root of the view hierarchy
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.180 -0500", hash_original_method = "C54C39F0AE01B1B593235445BAB775DC", hash_generated_method = "6050F23754C71B2BC9438211727BE456")
    
abstract void destroyHardwareResources(View view);
    
    /**
     * This method should be invoked whenever the current hardware renderer
     * context should be reset.
     * 
     * @param holder The holder for the surface to hardware accelerate
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.183 -0500", hash_original_method = "9D23EFC6987C44FAD0E7F8718271CC77", hash_generated_method = "4B49A7FD584FBCB829948BA35988585A")
    
abstract void invalidate(SurfaceHolder holder);

    /**
     * This method should be invoked to ensure the hardware renderer is in
     * valid state (for instance, to ensure the correct EGL context is bound
     * to the current thread.)
     * 
     * @return true if the renderer is now valid, false otherwise
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.185 -0500", hash_original_method = "416BA317E33EF7C387F81782526C9623", hash_generated_method = "3A35EB1080D61C47905A7BAE70289D2F")
    
abstract boolean validate();

    /**
     * Setup the hardware renderer for drawing. This is called whenever the
     * size of the target surface changes or when the surface is first created.
     * 
     * @param width Width of the drawing surface.
     * @param height Height of the drawing surface.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.187 -0500", hash_original_method = "A1F263AE9D74A1E0B7EB2C5CA9090FE8", hash_generated_method = "F38343CFC29A981DE9F65848AD6890F7")
    
abstract void setup(int width, int height);

    /**
     * Gets the current width of the surface. This is the width that the surface
     * was last set to in a call to {@link #setup(int, int)}.
     *
     * @return the current width of the surface
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.189 -0500", hash_original_method = "D4E7715F32876041521BE16EC8E1C0AC", hash_generated_method = "FEB5ED1C1A44BA8AD6B90EEC5A641AC2")
    
abstract int getWidth();

    /**
     * Gets the current height of the surface. This is the height that the surface
     * was last set to in a call to {@link #setup(int, int)}.
     *
     * @return the current width of the surface
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.191 -0500", hash_original_method = "E09BF3A531DEFF54888EDA3B98EB9CFF", hash_generated_method = "56B4A9EEB051769A5AE27C14B0517CFE")
    
abstract int getHeight();

    /**
     * Gets the current canvas associated with this HardwareRenderer.
     *
     * @return the current HardwareCanvas
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.193 -0500", hash_original_method = "0D7F234467EBE3155552A1EF9B644626", hash_generated_method = "C04C8CCAD8E35259D9227E6936774422")
    
abstract HardwareCanvas getCanvas();

    /**
     * Draws the specified view.
     *
     * @param view The view to draw.
     * @param attachInfo AttachInfo tied to the specified view.
     * @param callbacks Callbacks invoked when drawing happens.
     * @param dirty The dirty rectangle to update, can be null.
     * 
     * @return true if the dirty rect was ignored, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.204 -0500", hash_original_method = "0E2B0617AD8C443F0EBC3896368BAD9C", hash_generated_method = "421803850C1F3F2BCFD66A67CBA21FD7")
    
abstract boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
            Rect dirty);
    
    static abstract class GlRenderer extends HardwareRenderer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.233 -0500", hash_original_field = "05ED6095C69105CABAB5DA8E1FBF3493", hash_generated_field = "3E10338E50BF743AF77D21918619DEC3")

        static final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.235 -0500", hash_original_field = "F31ABFF27378341DBE2BD21D7CFA6F37", hash_generated_field = "2C445899F8A8AEDECF32FB9135B066D1")

        static final int EGL_OPENGL_ES2_BIT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.237 -0500", hash_original_field = "ADA515BC7E7DDD989A80695EAB0B75C8", hash_generated_field = "2A272558ACA6FC8A6614D6BA7458C75D")

        static final int EGL_SURFACE_TYPE = 0x3033;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.239 -0500", hash_original_field = "5943B4661C9A92AC2CD547E478BF8252", hash_generated_field = "C31026AE6C97B54F64BA8D74F4DB4624")

        static final int EGL_SWAP_BEHAVIOR_PRESERVED_BIT = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.242 -0500", hash_original_field = "ABF5E1A4FDD60A8C604D76B15781AF59", hash_generated_field = "0938239E7634E9F8C37B8678E90396F9")

        static final int SURFACE_STATE_ERROR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.244 -0500", hash_original_field = "A544A3F14BA10C6F86E45CE1724DF50D", hash_generated_field = "A56E49F9D74B2FDD846AFDD966D2CA36")

        static final int SURFACE_STATE_SUCCESS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.248 -0500", hash_original_field = "BCD0FD5CC68D417E845C08F52C505ABD", hash_generated_field = "DCB1F5A31169FA47085409CF6AA15381")

        static final int SURFACE_STATE_UPDATED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.251 -0500", hash_original_field = "F3F99A4AAF4495C7E5BD414E92D87A69", hash_generated_field = "89D62FD7DEAB0F4EA47FB451DD608D43")
        
        static EGL10 sEgl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.253 -0500", hash_original_field = "2850C2E5CF41CD47FAA9244CD3808DF8", hash_generated_field = "4D6AA44B0537982BD4C758CAAEDCA2BB")

        static EGLDisplay sEglDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.255 -0500", hash_original_field = "81DAC1AF07A98E202F467091D2D3496D", hash_generated_field = "AB7BB82C5C2E6AFE71B7DB7D36C3876B")

        static EGLConfig sEglConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.258 -0500", hash_original_field = "85D1F8D304F47161622D8ED6A049A5E4", hash_generated_field = "8E033D3FEBA28DC4C5024A9005A21267")

        static final Object[] sEglLock = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.262 -0500", hash_original_field = "1F888D1BF0C62050E8F97E5021FED0B8", hash_generated_field = "B964CE88695D4A806E497A467321E250")

        static final ThreadLocal<Gl20Renderer.Gl20RendererEglContext> sEglContextStorage
                = new ThreadLocal<Gl20Renderer.Gl20RendererEglContext>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.280 -0500", hash_original_field = "FBD54073AB282DD33B22F58D5C3837F5", hash_generated_field = "2552FD4B6C23E3B90D7EC1BBA8F3293E")

        static boolean sDirtyRegions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.283 -0500", hash_original_field = "C783221E7492838CD3A28618CEA72311", hash_generated_field = "1C3D78F3A3106B7D131377ACD7D2905E")

        static  boolean sDirtyRegionsRequested;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "2BA03B5BE1E097B9BC57B210061D879D")

        int mWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.531 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3D81262840DA37820D58425FC486E30D")

        int mHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.265 -0500", hash_original_field = "75D18A698C8C0156FC372CC4CDC659FD", hash_generated_field = "75D18A698C8C0156FC372CC4CDC659FD")

        EGLContext mEglContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.267 -0500", hash_original_field = "C8809406F874F748D7C2D2A82FC8CAFB", hash_generated_field = "C8809406F874F748D7C2D2A82FC8CAFB")

        Thread mEglThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.269 -0500", hash_original_field = "3BCE51A04A846FE71AD218CCB7DF9B47", hash_generated_field = "3BCE51A04A846FE71AD218CCB7DF9B47")

        EGLSurface mEglSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.271 -0500", hash_original_field = "776F52E98B7458F3181D343B01ABD47C", hash_generated_field = "776F52E98B7458F3181D343B01ABD47C")
        
        GL mGl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.273 -0500", hash_original_field = "37BD83BC682BDA2AAC757751086B36DE", hash_generated_field = "37BD83BC682BDA2AAC757751086B36DE")

        HardwareCanvas mCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.276 -0500", hash_original_field = "2B862720623879764FB3C1B9EA11B335", hash_generated_field = "2B862720623879764FB3C1B9EA11B335")

        int mFrameCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.278 -0500", hash_original_field = "FFE47057B50B334DD786C5E73414DC81", hash_generated_field = "FFE47057B50B334DD786C5E73414DC81")

        Paint mDebugPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.286 -0500", hash_original_field = "ECB95A231B3EDB5A9081400631FFCAB1", hash_generated_field = "ECB95A231B3EDB5A9081400631FFCAB1")

        boolean mDirtyRegionsEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.288 -0500", hash_original_field = "763734C03E6324334FBF6C22D68E5385", hash_generated_field = "763734C03E6324334FBF6C22D68E5385")

         boolean mVsyncDisabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.290 -0500", hash_original_field = "F9D183B249EAF9218F504B0391DBAF55", hash_generated_field = "F9D183B249EAF9218F504B0391DBAF55")

         int mGlVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.292 -0500", hash_original_field = "BA918D2716C9DCF541C02A323E8108FD", hash_generated_field = "BA918D2716C9DCF541C02A323E8108FD")

         boolean mTranslucent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.295 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

        private boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.297 -0500", hash_original_field = "F6A60C6925878F0452B252169082DB15", hash_generated_field = "182B0379D371946AD3DA2504271E34F0")

        private final Rect mRedrawClip = new Rect();

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.300 -0500", hash_original_method = "10324A50C61190B04368151ACA88DC91", hash_generated_method = "10324A50C61190B04368151ACA88DC91")
        
GlRenderer(int glVersion, boolean translucent) {
            mGlVersion = glVersion;
            mTranslucent = translucent;

            final String vsyncProperty = SystemProperties.get(DISABLE_VSYNC_PROPERTY, "false");
            mVsyncDisabled = "true".equalsIgnoreCase(vsyncProperty);
            if (mVsyncDisabled) {
                Log.d(LOG_TAG, "Disabling v-sync");
            }
        }

        /**
         * Indicates whether this renderer instance can track and update dirty regions.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.302 -0500", hash_original_method = "8E011D652AD55D9A8BD48AFBDECCE639", hash_generated_method = "8E011D652AD55D9A8BD48AFBDECCE639")
        
boolean hasDirtyRegions() {
            return mDirtyRegionsEnabled;
        }

        /**
         * Checks for OpenGL errors. If an error has occured, {@link #destroy(boolean)}
         * is invoked and the requested flag is turned off. The error code is
         * also logged as a warning.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.305 -0500", hash_original_method = "5D86F2EDCD8D2650FE0B69784B6D885F", hash_generated_method = "849DC00E57DCD1E295810EC8A52E0EA7")
        
void checkEglErrors() {
            if (isEnabled()) {
                int error = sEgl.eglGetError();
                if (error != EGL_SUCCESS) {
                    // something bad has happened revert to
                    // normal rendering.
                    Log.w(LOG_TAG, "EGL error: " + GLUtils.getEGLErrorString(error));
                    fallback(error != EGL11.EGL_CONTEXT_LOST);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.308 -0500", hash_original_method = "87E6FBE52BF3E41B35644D0BA431AF43", hash_generated_method = "2DCEE108E07058D47A7054049261F1B3")
        
private void fallback(boolean fallback) {
            destroy(true);
            if (fallback) {
                // we'll try again if it was context lost
                setRequested(false);
                Log.w(LOG_TAG, "Mountain View, we've had a problem here. " 
                        + "Switching back to software rendering.");
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.311 -0500", hash_original_method = "921EA5B73D96C86CDA9474B12ADD4C25", hash_generated_method = "AC9BE6FB9C00DA492F79E828C1659269")
        
@Override
        boolean initialize(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            if (isRequested() && !isEnabled()) {
                initializeEgl();
                mGl = createEglSurface(holder);
                mDestroyed = false;

                if (mGl != null) {
                    int err = sEgl.eglGetError();
                    if (err != EGL_SUCCESS) {
                        destroy(true);
                        setRequested(false);
                    } else {
                        if (mCanvas == null) {
                            mCanvas = createCanvas();
                        }
                        if (mCanvas != null) {
                            setEnabled(true);
                        } else {
                            Log.w(LOG_TAG, "Hardware accelerated Canvas could not be created");
                        }
                    }

                    return mCanvas != null;
                }
            }
            return false;
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.313 -0500", hash_original_method = "2D2C42A66AD2DEB924E2F6769D89C4AD", hash_generated_method = "5DACB61F29CD1537FEDD6249592BE7FA")
        
@Override
        void updateSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            if (isRequested() && isEnabled()) {
                createEglSurface(holder);
            }
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.315 -0500", hash_original_method = "7DB12B4D4904E03574ADA1ECFE31C77F", hash_generated_method = "8F81F9113EFE188B4823F1D193F645B3")
        
abstract GLES20Canvas createCanvas();

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.318 -0500", hash_original_method = "EB23F55B33F6A830491AE8E8F7F78596", hash_generated_method = "CE1C4A796CE77884B9B83331CEBE9A9C")
        
abstract int[] getConfig(boolean dirtyRegions);

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.321 -0500", hash_original_method = "B279C4718AE98DC5BFCF9CC39FB51005", hash_generated_method = "3662C850DC64376531B42BAF14C28EC2")
        
void initializeEgl() {
            synchronized (sEglLock) {
                if (sEgl == null && sEglConfig == null) {
                    sEgl = (EGL10) EGLContext.getEGL();
                    
                    // Get to the default display.
                    sEglDisplay = sEgl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    
                    if (sEglDisplay == EGL_NO_DISPLAY) {
                        throw new RuntimeException("eglGetDisplay failed "
                                + GLUtils.getEGLErrorString(sEgl.eglGetError()));
                    }
                    
                    // We can now initialize EGL for that display
                    int[] version = new int[2];
                    if (!sEgl.eglInitialize(sEglDisplay, version)) {
                        throw new RuntimeException("eglInitialize failed " +
                                GLUtils.getEGLErrorString(sEgl.eglGetError()));
                    }
        
                    sEglConfig = chooseEglConfig();
                    if (sEglConfig == null) {
                        // We tried to use EGL_SWAP_BEHAVIOR_PRESERVED_BIT, try again without
                        if (sDirtyRegions) {
                            sDirtyRegions = false;
                            sEglConfig = chooseEglConfig();
                            if (sEglConfig == null) {
                                throw new RuntimeException("eglConfig not initialized");
                            }
                        } else {
                            throw new RuntimeException("eglConfig not initialized");
                        }
                    }
                }
            }

            Gl20Renderer.Gl20RendererEglContext managedContext = sEglContextStorage.get();
            mEglContext = managedContext != null ? managedContext.getContext() : null;
            mEglThread = Thread.currentThread();

            if (mEglContext == null) {
                mEglContext = createContext(sEgl, sEglDisplay, sEglConfig);
                sEglContextStorage.set(new Gl20Renderer.Gl20RendererEglContext(mEglContext));
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.324 -0500", hash_original_method = "7EBBB0609098A0727E2316EE23892E6C", hash_generated_method = "89A2A7F31CDF109113A23802DB68516D")
        
private EGLConfig chooseEglConfig() {
            EGLConfig[] configs = new EGLConfig[1];
            int[] configsCount = new int[1];
            int[] configSpec = getConfig(sDirtyRegions);

            // Debug
            final String debug = SystemProperties.get(PRINT_CONFIG_PROPERTY, "");
            if ("all".equalsIgnoreCase(debug)) {
                sEgl.eglChooseConfig(sEglDisplay, configSpec, null, 0, configsCount);

                EGLConfig[] debugConfigs = new EGLConfig[configsCount[0]];
                sEgl.eglChooseConfig(sEglDisplay, configSpec, debugConfigs,
                        configsCount[0], configsCount);

                for (EGLConfig config : debugConfigs) {
                    printConfig(config);
                }
            }

            if (!sEgl.eglChooseConfig(sEglDisplay, configSpec, configs, 1, configsCount)) {
                throw new IllegalArgumentException("eglChooseConfig failed " +
                        GLUtils.getEGLErrorString(sEgl.eglGetError()));
            } else if (configsCount[0] > 0) {
                if ("choice".equalsIgnoreCase(debug)) {
                    printConfig(configs[0]);
                }
                return configs[0];
            }

            return null;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.327 -0500", hash_original_method = "0890A6845DB8299C7ED9F063C47BF666", hash_generated_method = "3F8C8711E02856F769753D378CD4AAF8")
        
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
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.330 -0500", hash_original_method = "CE78C152F3B6BB29B0F51267B059EC85", hash_generated_method = "582FE607616092E2EDE3A41FE8B5C81F")
        
GL createEglSurface(SurfaceHolder holder) throws Surface.OutOfResourcesException {
            // Check preconditions.
            if (sEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (sEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (sEglConfig == null) {
                throw new RuntimeException("eglConfig not initialized");
            }
            if (Thread.currentThread() != mEglThread) {
                throw new IllegalStateException("HardwareRenderer cannot be used " 
                        + "from multiple threads");
            }

            // In case we need to destroy an existing surface
            destroySurface();

            // Create an EGL surface we can render into.
            if (!createSurface(holder)) {
                return null;
            }

            /*
             * Before we can issue GL commands, we need to make sure
             * the context is current and bound to a surface.
             */
            if (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext)) {
                throw new Surface.OutOfResourcesException("eglMakeCurrent failed "
                        + GLUtils.getEGLErrorString(sEgl.eglGetError()));
            }
            
            initCaches();

            // If mDirtyRegions is set, this means we have an EGL configuration
            // with EGL_SWAP_BEHAVIOR_PRESERVED_BIT set
            if (sDirtyRegions) {
                if (!(mDirtyRegionsEnabled = GLES20Canvas.preserveBackBuffer())) {
                    Log.w(LOG_TAG, "Backbuffer cannot be preserved");
                }
            } else if (sDirtyRegionsRequested) {
                // If mDirtyRegions is not set, our EGL configuration does not
                // have EGL_SWAP_BEHAVIOR_PRESERVED_BIT; however, the default
                // swap behavior might be EGL_BUFFER_PRESERVED, which means we
                // want to set mDirtyRegions. We try to do this only if dirty
                // regions were initially requested as part of the device
                // configuration (see RENDER_DIRTY_REGIONS)
                mDirtyRegionsEnabled = GLES20Canvas.isBackBufferPreserved();
            }

            return mEglContext.getGL();
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.333 -0500", hash_original_method = "3A7BFEE9E506BEABC7703C4487FB8734", hash_generated_method = "EA3413B6E2E9C7912CB6DFB54AA29C4D")
        
abstract void initCaches();

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.335 -0500", hash_original_method = "25878E68191E1BEA8EFD58CC92DB697F", hash_generated_method = "25878E68191E1BEA8EFD58CC92DB697F")
        
EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
            int[] attribs = { EGL_CONTEXT_CLIENT_VERSION, mGlVersion, EGL_NONE };

            return egl.eglCreateContext(eglDisplay, eglConfig, EGL_NO_CONTEXT,
                    mGlVersion != 0 ? attribs : null);            
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.338 -0500", hash_original_method = "476B6B31B3E717E00869D611EE7348F9", hash_generated_method = "D097A0CBE91A223A0BA663A7A2047163")
        
@Override
        void destroy(boolean full) {
            if (full && mCanvas != null) {
                mCanvas = null;
            }

            if (!isEnabled() || mDestroyed) {
                setEnabled(false);
                return;
            }

            destroySurface();
            setEnabled(false);

            mDestroyed = true;
            mGl = null;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.340 -0500", hash_original_method = "8729F371C5ECEEE6F9AFEEF006F001BC", hash_generated_method = "8729F371C5ECEEE6F9AFEEF006F001BC")
        
void destroySurface() {
            if (mEglSurface != null && mEglSurface != EGL_NO_SURFACE) {
                sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.343 -0500", hash_original_method = "31AB32F492C93DC28936068651BB9A5D", hash_generated_method = "DB32E0DA063D68D8E1D591E84D3C28E2")
        
@Override
        void invalidate(SurfaceHolder holder) {
            // Cancels any existing buffer to ensure we'll get a buffer
            // of the right size before we call eglSwapBuffers
            sEgl.eglMakeCurrent(sEglDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);

            if (mEglSurface != null && mEglSurface != EGL_NO_SURFACE) {
                sEgl.eglDestroySurface(sEglDisplay, mEglSurface);
                mEglSurface = null;
                setEnabled(false);
            }

            if (holder.getSurface().isValid()) {
                if (!createSurface(holder)) {
                    return;
                }
                if (mCanvas != null) {
                    setEnabled(true);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.346 -0500", hash_original_method = "DE5D7845AE9FF0DF12BC88C1DA1B9378", hash_generated_method = "4C480E3CEC1800596C51E2769B91FD17")
        
private boolean createSurface(SurfaceHolder holder) {
            mEglSurface = sEgl.eglCreateWindowSurface(sEglDisplay, sEglConfig, holder, null);

            if (mEglSurface == null || mEglSurface == EGL_NO_SURFACE) {
                int error = sEgl.eglGetError();
                if (error == EGL_BAD_NATIVE_WINDOW) {
                    Log.e(LOG_TAG, "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    return false;
                }
                throw new RuntimeException("createWindowSurface failed "
                        + GLUtils.getEGLErrorString(error));
            }
            return true;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.348 -0500", hash_original_method = "5192B6F9979CE04F5E58A6D4E6C990F7", hash_generated_method = "DB5855D3087DE5F703B68977C42C1C27")
        
@Override
        boolean validate() {
            return checkCurrent() != SURFACE_STATE_ERROR;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.351 -0500", hash_original_method = "432BCA9410981741609CBA70FE61BE99", hash_generated_method = "1B0FAA25240DD94C2B895D60766BBD55")
        
@Override
        void setup(int width, int height) {
            if (validate()) {
                mCanvas.setViewport(width, height);
                mWidth = width;
                mHeight = height;
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.353 -0500", hash_original_method = "AA9BA105372BFC95AFBABED408315F5C", hash_generated_method = "651DCBA9FACC62304A60971F8F89CCBC")
        
@Override
        int getWidth() {
            return mWidth;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.356 -0500", hash_original_method = "0304EDCF78FF45B68A7EB91BFEAAA2CD", hash_generated_method = "ED21678AEB517A389B8FE90A798E5728")
        
@Override
        int getHeight() {
            return mHeight;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.358 -0500", hash_original_method = "03525402B3DC937D128A720724E320B3", hash_generated_method = "8DFF870ACAE374B016A5345B9168DC2B")
        
@Override
        HardwareCanvas getCanvas() {
            return mCanvas;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.361 -0500", hash_original_method = "BAED9FCEBD48E8CDA814A9102CB815B2", hash_generated_method = "BAED9FCEBD48E8CDA814A9102CB815B2")
        
boolean canDraw() {
            return mGl != null && mCanvas != null;
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.363 -0500", hash_original_method = "5270AAD77A1E26F7563AFAAC446C8262", hash_generated_method = "5270AAD77A1E26F7563AFAAC446C8262")
        
void onPreDraw(Rect dirty) {
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.365 -0500", hash_original_method = "600776A2676C628EF453DCB2EAD62BCF", hash_generated_method = "600776A2676C628EF453DCB2EAD62BCF")
        
void onPostDraw() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.369 -0500", hash_original_method = "B420691F06CB3429CDB4650F51ED53E5", hash_generated_method = "A921A9B8FDDD6F013F04287CBD68A00D")
        
@Override
        boolean draw(View view, View.AttachInfo attachInfo, HardwareDrawCallbacks callbacks,
                Rect dirty) {
            if (canDraw()) {
                if (!hasDirtyRegions()) {
                    dirty = null;
                }
                attachInfo.mIgnoreDirtyState = true;
                attachInfo.mDrawingTime = SystemClock.uptimeMillis();

                view.mPrivateFlags |= View.DRAWN;

                final int surfaceState = checkCurrent();
                if (surfaceState != SURFACE_STATE_ERROR) {
                    // We had to change the current surface and/or context, redraw everything
                    if (surfaceState == SURFACE_STATE_UPDATED) {
                        dirty = null;
                    }

                    onPreDraw(dirty);

                    HardwareCanvas canvas = mCanvas;
                    attachInfo.mHardwareCanvas = canvas;

                    int saveCount = canvas.save();
                    callbacks.onHardwarePreDraw(canvas);

                    try {
                        view.mRecreateDisplayList =
                                (view.mPrivateFlags & View.INVALIDATED) == View.INVALIDATED;
                        view.mPrivateFlags &= ~View.INVALIDATED;

                        DisplayList displayList = view.getDisplayList();
                        if (displayList != null) {
                            if (canvas.drawDisplayList(displayList, view.getWidth(),
                                    view.getHeight(), mRedrawClip)) {
                                if (mRedrawClip.isEmpty() || view.getParent() == null) {
                                    view.invalidate();
                                } else {
                                    view.getParent().invalidateChild(view, mRedrawClip);
                                }
                                mRedrawClip.setEmpty();
                            }
                        } else {
                            // Shouldn't reach here
                            view.draw(canvas);
                        }

                        if (DEBUG_DIRTY_REGION) {
                            if (mDebugPaint == null) {
                                mDebugPaint = new Paint();
                                mDebugPaint.setColor(0x7fff0000);
                            }
                            if (dirty != null && (mFrameCount++ & 1) == 0) {
                                canvas.drawRect(dirty, mDebugPaint);
                            }
                        }
                    } finally {
                        callbacks.onHardwarePostDraw(canvas);
                        canvas.restoreToCount(saveCount);
                        view.mRecreateDisplayList = false;
                    }

                    onPostDraw();

                    attachInfo.mIgnoreDirtyState = false;

                    sEgl.eglSwapBuffers(sEglDisplay, mEglSurface);
                    checkEglErrors();

                    return dirty == null;
                }
            }

            return false;
        }

        /**
         * Ensures the current EGL context is the one we expect.
         * 
         * @return {@link #SURFACE_STATE_ERROR} if the correct EGL context cannot be made current,
         *         {@link #SURFACE_STATE_UPDATED} if the EGL context was changed or
         *         {@link #SURFACE_STATE_SUCCESS} if the EGL context was the correct one
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.371 -0500", hash_original_method = "F54ECE08CE2E8C98D4ED45C8BC0241CA", hash_generated_method = "F54ECE08CE2E8C98D4ED45C8BC0241CA")
        
int checkCurrent() {
            if (mEglThread != Thread.currentThread()) {
                throw new IllegalStateException("Hardware acceleration can only be used with a " +
                        "single UI thread.\nOriginal thread: " + mEglThread + "\n" +
                        "Current thread: " + Thread.currentThread());
            }

            if (!mEglContext.equals(sEgl.eglGetCurrentContext()) ||
                    !mEglSurface.equals(sEgl.eglGetCurrentSurface(EGL_DRAW))) {
                if (!sEgl.eglMakeCurrent(sEglDisplay, mEglSurface, mEglSurface, mEglContext)) {
                    Log.e(LOG_TAG, "eglMakeCurrent failed " +
                            GLUtils.getEGLErrorString(sEgl.eglGetError()));
                    fallback(true);
                    return SURFACE_STATE_ERROR;
                } else {
                    return SURFACE_STATE_UPDATED;
                }
            }
            return SURFACE_STATE_SUCCESS;
        }
        static {
            String dirtyProperty = SystemProperties.get(RENDER_DIRTY_REGIONS_PROPERTY, "true");
            sDirtyRegions = RENDER_DIRTY_REGIONS && "true".equalsIgnoreCase(dirtyProperty);
            sDirtyRegionsRequested = sDirtyRegions;
        }
        
    }
    
    static class Gl20Renderer extends GlRenderer {

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.440 -0500", hash_original_method = "3A587C3870D559FE72764A828C177D6D", hash_generated_method = "EDE28C6E6EC3F1BD0A1A015E207F1D6C")
        
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
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.446 -0500", hash_original_method = "8521FC3B281A56CFA34090E93CBC7058", hash_generated_method = "2C7B68118FF5420F1FD37CECE14B634D")
        
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

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.448 -0500", hash_original_method = "7C42AE7FEC85968DC821581EB40A786E", hash_generated_method = "685D7EED2668661A3A81CF9CA425E372")
        
static HardwareRenderer create(boolean translucent) {
            if (GLES20Canvas.isAvailable()) {
                return new Gl20Renderer(translucent);
            }
            return null;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.451 -0500", hash_original_method = "07359DC32B0E99110D7D4927D57C3077", hash_generated_method = "52D59EB479C6E9D3ACA33D44D009C10C")
        
static void trimMemory(int level) {
            if (sEgl == null || sEglConfig == null) return;

            Gl20RendererEglContext managedContext = sEglContextStorage.get();
            // We do not have OpenGL objects
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

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.453 -0500", hash_original_method = "34BFF10BDA33F8F3E764109893739A93", hash_generated_method = "10E553D21A30BCF6D3E6247F5228E3FE")
        
private static void usePbufferSurface(EGLContext eglContext) {
            synchronized (sPbufferLock) {
                // Create a temporary 1x1 pbuffer so we have a context
                // to clear our OpenGL objects
                if (sPbuffer == null) {
                    sPbuffer = sEgl.eglCreatePbufferSurface(sEglDisplay, sEglConfig, new int[] {
                            EGL_WIDTH, 1, EGL_HEIGHT, 1, EGL_NONE
                    });
                }
            }
            sEgl.eglMakeCurrent(sEglDisplay, sPbuffer, sPbuffer, eglContext);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.385 -0500", hash_original_field = "E466A43BAA9C7F59150794EAFA275E2B", hash_generated_field = "6C6559CCDF7784B417023844F64F56D4")

        private static EGLSurface sPbuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.388 -0500", hash_original_field = "DAE42D9E3FFD5CB8F4F331EC6F477F94", hash_generated_field = "397F4B1C85C553C6A50924367AE7739B")

        private static final Object[] sPbufferLock = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.382 -0500", hash_original_field = "5126E5DC300154DE2568A2DB4C659947", hash_generated_field = "A04C267767B10D74D267BE1DECB4FBB4")

        private GLES20Canvas mGlCanvas;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.405 -0500", hash_original_method = "B1E95719A4C359FC5D5C603A14B80EB3", hash_generated_method = "B1E95719A4C359FC5D5C603A14B80EB3")
        
Gl20Renderer(boolean translucent) {
            super(2, translucent);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.408 -0500", hash_original_method = "F74985FDFA2E9230D4C8D7E9B7CADFBD", hash_generated_method = "AF2B83FE012044B9B6834BD22F4A7275")
        
@Override
        GLES20Canvas createCanvas() {
            return mGlCanvas = new GLES20Canvas(mTranslucent);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.411 -0500", hash_original_method = "F0C99ACF7C56841B3F486F5BFE1F4C1E", hash_generated_method = "FE63F231BD975606BA4D3DDD3D04FB36")
        
@Override
        int[] getConfig(boolean dirtyRegions) {
            return new int[] {
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
            };
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.413 -0500", hash_original_method = "7C06275E87085241F3D16D3C83742A74", hash_generated_method = "E63C095940EAAC542BC3FC016267E23B")
        
@Override
        void initCaches() {
            GLES20Canvas.initCaches();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.415 -0500", hash_original_method = "C7C1539F42BBDC0F7B3C1C5760B83BD0", hash_generated_method = "C0DC862EF25ED318D23A0F442BDC63FD")
        
@Override
        boolean canDraw() {
            return super.canDraw() && mGlCanvas != null;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.417 -0500", hash_original_method = "0022B5A5096431CE2C7606DC3316BE73", hash_generated_method = "0F203CBDA7639E105C65101F9F1F8B96")
        
@Override
        void onPreDraw(Rect dirty) {
            mGlCanvas.onPreDraw(dirty);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.420 -0500", hash_original_method = "7433D62E540EA68CB724AA636E5E1121", hash_generated_method = "CBCDB29F70267B928CA56AEDDFA9E02F")
        
@Override
        void onPostDraw() {
            mGlCanvas.onPostDraw();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.422 -0500", hash_original_method = "6E3A6DE775BA1410C4AD975BAADAD54E", hash_generated_method = "A5FC2DEBE2EC190C53A410DF0C87B637")
        
@Override
        void destroy(boolean full) {
            try {
                super.destroy(full);
            } finally {
                if (full && mGlCanvas != null) {
                    mGlCanvas = null;
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.425 -0500", hash_original_method = "E63C13501979998737C0E9B67210D488", hash_generated_method = "CD9DC1D3314A700E2BB6D5376E6F3967")
        
@Override
        void setup(int width, int height) {
            super.setup(width, height);
            if (mVsyncDisabled) {
                GLES20Canvas.disableVsync();
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.427 -0500", hash_original_method = "91DF561E8BF11B235EB0CF61AE2449D1", hash_generated_method = "BA46D2C6262632E7183640D3E31F768C")
        
@Override
        DisplayList createDisplayList() {
            return new GLES20DisplayList();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.430 -0500", hash_original_method = "9926A5C358BE0969CD82CBEFEE88B0C5", hash_generated_method = "4D4D9A04FD762D6B5DB835DBFA1D3DA4")
        
@Override
        HardwareLayer createHardwareLayer(boolean isOpaque) {
            return new GLES20TextureLayer(isOpaque);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.432 -0500", hash_original_method = "4877A9BF76918321656F296A4083E728", hash_generated_method = "3FBDCEFBF946203E7B727D84DF38AF0B")
        
@Override
        HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque) {
            return new GLES20RenderLayer(width, height, isOpaque);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.435 -0500", hash_original_method = "2626CBE8666291C6CAEC91C70C04EEE5", hash_generated_method = "47F952BC705D78261B017A9B6A07F35C")
        
@Override
        SurfaceTexture createSurfaceTexture(HardwareLayer layer) {
            return ((GLES20TextureLayer) layer).getSurfaceTexture();
        }
        
        static class Gl20RendererEglContext extends ManagedEGLContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.391 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

            final Handler mHandler = new Handler();

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.393 -0500", hash_original_method = "DAB7F8E2E2F55BAE2E6064B879DDA260", hash_generated_method = "A3DC8B712B44E6E42FEAF2F446FC84D7")
            
public Gl20RendererEglContext(EGLContext context) {
                super(context);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.401 -0500", hash_original_method = "022CE21F17BE8021C39A7EA65E477736", hash_generated_method = "C98CE1613E6F1FDA42041868313FCD02")
            
@Override
            public void onTerminate(final EGLContext eglContext) {
                // Make sure we do this on the correct thread.
                if (mHandler.getLooper() != Looper.myLooper()) {
                    mHandler.post(new Runnable() {
                        @DSSafe(DSCat.SAFE_LIST)
                @Override public void run() {
                            onTerminate(eglContext);
                        }
                    });
                    return;
                }

                synchronized (sEglLock) {
                    if (sEgl == null) return;

                    if (EGLImpl.getInitCount(sEglDisplay) == 1) {
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
            
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.437 -0500", hash_original_method = "47CAC65634322D23BF323CE20E51DB06", hash_generated_method = "6715D2C7C2A5DFC434A7709B787B0A88")
        
@Override
        void destroyLayers(View view) {
            if (view != null && isEnabled() && checkCurrent() != SURFACE_STATE_ERROR) {
                destroyHardwareLayer(view);
                GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.443 -0500", hash_original_method = "05E9CAD7CA3059A2D779D6F5B2F697AA", hash_generated_method = "D43A8089BBAB2A3A08923DEC53AA6A11")
        
@Override
        void destroyHardwareResources(View view) {
            if (view != null) {
                boolean needsContext = true;
                if (isEnabled() && checkCurrent() != SURFACE_STATE_ERROR) needsContext = false;

                if (needsContext) {
                    Gl20RendererEglContext managedContext = sEglContextStorage.get();
                    if (managedContext == null) return;
                    usePbufferSurface(managedContext.getContext());
                }

                destroyResources(view);
                GLES20Canvas.flushCaches(GLES20Canvas.FLUSH_CACHES_LAYERS);
            }
        }
    }
    
    interface HardwareDrawCallbacks {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onHardwarePreDraw(HardwareCanvas canvas);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onHardwarePostDraw(HardwareCanvas canvas);
    }

    /**
     * Creates a new display list that can be used to record batches of
     * drawing operations.
     * 
     * @return A new display list.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.206 -0500", hash_original_method = "356CB302D9BC66C459DDD745CCDFE1DD", hash_generated_method = "4748B2A7984D0C8C43F137D8B317772B")
    
abstract DisplayList createDisplayList();

    /**
     * Creates a new hardware layer. A hardware layer built by calling this
     * method will be treated as a texture layer, instead of as a render target.
     * 
     * @param isOpaque Whether the layer should be opaque or not
     * 
     * @return A hardware layer
     */    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.209 -0500", hash_original_method = "400A04EF0E476FEB9A1F94E173694FDB", hash_generated_method = "1491B90B042C9035297169067B411717")
    
abstract HardwareLayer createHardwareLayer(boolean isOpaque);
    
    /**
     * Creates a new hardware layer.
     * 
     * @param width The minimum width of the layer
     * @param height The minimum height of the layer
     * @param isOpaque Whether the layer should be opaque or not
     * 
     * @return A hardware layer
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.211 -0500", hash_original_method = "1DBBF671AE3C021F2109E0400F25ADE2", hash_generated_method = "7222A3FD69629B46F3C52F0C33030932")
    
abstract HardwareLayer createHardwareLayer(int width, int height, boolean isOpaque);

    /**
     * Creates a new {@link SurfaceTexture} that can be used to render into the
     * specified hardware layer.
     * 
     *
     * @param layer The layer to render into using a {@link android.graphics.SurfaceTexture}
     * 
     * @return A {@link SurfaceTexture}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.213 -0500", hash_original_method = "60936D2F9DA291835597D06AC147FC27", hash_generated_method = "B765F9698743085195745CEB692927D2")
    
abstract SurfaceTexture createSurfaceTexture(HardwareLayer layer);

    /**
     * Initializes the hardware renderer for the specified surface and setup the
     * renderer for drawing, if needed. This is invoked when the ViewAncestor has
     * potentially lost the hardware renderer. The hardware renderer should be
     * reinitialized and setup when the render {@link #isRequested()} and
     * {@link #isEnabled()}.
     * 
     * @param width The width of the drawing surface.
     * @param height The height of the drawing surface.
     * @param attachInfo The 
     * @param holder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.215 -0500", hash_original_method = "9B70801888A6ED6A8A5716CEEB0139B3", hash_generated_method = "7055BC03E88DD0689FCC6EBDCFA75E76")
    
void initializeIfNeeded(int width, int height, View.AttachInfo attachInfo,
            SurfaceHolder holder) throws Surface.OutOfResourcesException {
        if (isRequested()) {
            // We lost the gl context, so recreate it.
            if (!isEnabled()) {
                if (initialize(holder)) {
                    setup(width, height);
                }
            }
        }        
    }

    /**
     * Indicates whether hardware acceleration is currently enabled.
     * 
     * @return True if hardware acceleration is in use, false otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.223 -0500", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "B599CE9BD5CE6C0947F95A74F4693444")
    
boolean isEnabled() {
        return mEnabled;
    }

    /**
     * Indicates whether hardware acceleration is currently enabled.
     * 
     * @param enabled True if the hardware renderer is in use, false otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.225 -0500", hash_original_method = "E431274334564F99DE06BE0647F24670", hash_generated_method = "E431274334564F99DE06BE0647F24670")
    
void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    /**
     * Indicates whether hardware acceleration is currently request but not
     * necessarily enabled yet.
     * 
     * @return True if requested, false otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.227 -0500", hash_original_method = "2657035D37B57C6EB1FDEBFDEB2FC631", hash_generated_method = "2657035D37B57C6EB1FDEBFDEB2FC631")
    
boolean isRequested() {
        return mRequested;
    }

    /**
     * Indicates whether hardware acceleration is currently requested but not
     * necessarily enabled yet.
     * 
     * @return True to request hardware acceleration, false otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:54.229 -0500", hash_original_method = "5489F62162525BB08E1A950602557C7B", hash_generated_method = "5489F62162525BB08E1A950602557C7B")
    
void setRequested(boolean requested) {
        mRequested = requested;
    }
}

