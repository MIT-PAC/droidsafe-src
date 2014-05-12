package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

public class GLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.444 -0500", hash_original_field = "B2B0A61E120CF69A740A0EBBEFCB0DCC", hash_generated_field = "4034EC823D59F85BB049B0361EB812F4")

    private final static String TAG = "GLSurfaceView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.447 -0500", hash_original_field = "74D8DC872CDC0A5418D3946243C9EF50", hash_generated_field = "1EE3A05D4667F28D82E3A91570ACECC2")

    private final static boolean LOG_ATTACH_DETACH = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.450 -0500", hash_original_field = "BEDC3182AA02377BAFE05B8E3F2ECA81", hash_generated_field = "7A59CB5BFE26193256ADA36CA0D612E2")

    private final static boolean LOG_THREADS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.453 -0500", hash_original_field = "012C3D1DB78EF88A1D9A6DBE2EB7F0EE", hash_generated_field = "FBAB33E8D4FA0CCAEA6311BEFEA4806A")

    private final static boolean LOG_PAUSE_RESUME = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.456 -0500", hash_original_field = "8E477B533CDEB596B04BC8AF900C5AD3", hash_generated_field = "0509E45F538814A0914CCDF76BF039B0")

    private final static boolean LOG_SURFACE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.458 -0500", hash_original_field = "9A775B4DE0004C2C3744E696050D95F7", hash_generated_field = "7733B6AF262A325B4E3B0B3F5F6ABFD4")

    private final static boolean LOG_RENDERER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.461 -0500", hash_original_field = "174AA4313CFF31E253F621931DE828F1", hash_generated_field = "9767E7A30553B720521176A0B1C7A7DF")

    private final static boolean LOG_RENDERER_DRAW_FRAME = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.463 -0500", hash_original_field = "FF78D40B79676A0EA92769F105FB2F53", hash_generated_field = "6374488C33DF12121CA7B9425BE95249")

    private final static boolean LOG_EGL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.467 -0500", hash_original_field = "FAA8A58D3C445652D1BA1207ADEA87BC", hash_generated_field = "0E2BD5A2E10A5705ABDA8B3F88084518")

    private final static boolean DRAW_TWICE_AFTER_SIZE_CHANGED = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.469 -0500", hash_original_field = "36BAAA78AB5A9CADAC22299820165F35", hash_generated_field = "14B58EB967907A856FA213C29C42BA45")

    public final static int RENDERMODE_WHEN_DIRTY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.472 -0500", hash_original_field = "467DA93F8632EB029733DA0EC5C267E4", hash_generated_field = "560E958618800A224F6FD592043FEB61")

    public final static int RENDERMODE_CONTINUOUSLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.474 -0500", hash_original_field = "49459274F7DBAEA0C9B45D9BFEA099C4", hash_generated_field = "5D4C6365859FA1400C6019E0BBDAC737")

    public final static int DEBUG_CHECK_GL_ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.477 -0500", hash_original_field = "6D17F4B316F5AE5DED33C87AEE1BF3BE", hash_generated_field = "D663A579D7909EF5537DE06901903309")

    public final static int DEBUG_LOG_GL_CALLS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.833 -0500", hash_original_field = "87E37158AC15E4B0BB0B2135E699EE13", hash_generated_field = "2A611276FE9639F8735EA60D1E43AEA3")

    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.836 -0500", hash_original_field = "B8B7EF20A31F9D80C8061C2901F9F992", hash_generated_field = "E80A115172E1CADCEDB95343305F31F8")

    private boolean mSizeChanged = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.838 -0500", hash_original_field = "19D0003F4E4380ADE49769B81A6E13CA", hash_generated_field = "2E75A75105E7522B16840413392C2719")

    private GLThread mGLThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.841 -0500", hash_original_field = "720EF707169F06701CBF89E969BC03B3", hash_generated_field = "655D7742BDF0154D755D8012DFB26E60")

    private Renderer mRenderer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.843 -0500", hash_original_field = "F0A7088DB55E87649B19609F5563F724", hash_generated_field = "40F295D8807CAB798532DFEA849C6F06")

    private boolean mDetached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.845 -0500", hash_original_field = "0918EAC64CBD4B4254784C02F0E8C22B", hash_generated_field = "0D06A0983D993F273B4D8ECA63328176")

    private EGLConfigChooser mEGLConfigChooser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.848 -0500", hash_original_field = "5C8EB01BDEE335ECCE23DD3AB6592AC9", hash_generated_field = "22ED109E5D19AE599E44288A7242C1E5")

    private EGLContextFactory mEGLContextFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.850 -0500", hash_original_field = "D678752BAA5DEB5572FC6E782E63D8A0", hash_generated_field = "E3117B1108AE650B6C49E72DB2814A93")

    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.852 -0500", hash_original_field = "EA2FF7843754FD0B03744F9DA24AEBE0", hash_generated_field = "AB1795361F8C868AADE39F41E168626E")

    private GLWrapper mGLWrapper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.855 -0500", hash_original_field = "D7CF670418C964679B827E373E26BC89", hash_generated_field = "9496F66E2598A164065A99C1FFE9527C")

    private int mDebugFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.857 -0500", hash_original_field = "C09C18F578C27CE95961BD2B765DC819", hash_generated_field = "AB21D5DA668CEB71C5BE53180E39D9DB")

    private int mEGLContextClientVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.859 -0500", hash_original_field = "318533DB197A141C90A19653639140A1", hash_generated_field = "B7274B6FEDA290C84C4C186237763B86")

    private boolean mPreserveEGLContextOnPause;

    /**
     * Standard View constructor. In order to render something, you
     * must call {@link #setRenderer} to register a renderer.
     */
    @DSComment("OpenGL Viewer")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.479 -0500", hash_original_method = "2049D028AED77772C0EF08D2BBAE876F", hash_generated_method = "0B9876CB69076368282CCF3E5F778061")
    
public GLSurfaceView(Context context) {
        super(context);
        init();
    }

    /**
     * Standard View constructor. In order to render something, you
     * must call {@link #setRenderer} to register a renderer.
     */
    @DSComment("OpenGL Viewer")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.482 -0500", hash_original_method = "93DD44BF6C3B90D77E42FC0AB73B1708", hash_generated_method = "88C0E6A2ABE0F69B7804229BCC880863")
    
public GLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.485 -0500", hash_original_method = "E27264F3583A6717A4BE0996AD22B7A6", hash_generated_method = "BBFB4A66C22BD7ED9F5426D3679A0B9F")
    
private void init() {
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        // setFormat is done by SurfaceView in SDK 2.3 and newer. Uncomment
        // this statement if back-porting to 2.2 or older:
        // holder.setFormat(PixelFormat.RGB_565);
        //
        // setType is not needed for SDK 2.0 or newer. Uncomment this
        // statement if back-porting this code to older SDKs.
        // holder.setType(SurfaceHolder.SURFACE_TYPE_GPU);
    }

    /**
     * Set the glWrapper. If the glWrapper is not null, its
     * {@link GLWrapper#wrap(GL)} method is called
     * whenever a surface is created. A GLWrapper can be used to wrap
     * the GL object that's passed to the renderer. Wrapping a GL
     * object enables examining and modifying the behavior of the
     * GL calls made by the renderer.
     * <p>
     * Wrapping is typically used for debugging purposes.
     * <p>
     * The default value is null.
     * @param glWrapper the new GLWrapper
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.487 -0500", hash_original_method = "62AADEA51F1A9BF5575F2E5A0791202E", hash_generated_method = "77657B2994DE7DC1177BF6FFE564238B")
    
public void setGLWrapper(GLWrapper glWrapper) {
        mGLWrapper = glWrapper;
    }

    /**
     * Set the debug flags to a new value. The value is
     * constructed by OR-together zero or more
     * of the DEBUG_CHECK_* constants. The debug flags take effect
     * whenever a surface is created. The default value is zero.
     * @param debugFlags the new debug flags
     * @see #DEBUG_CHECK_GL_ERROR
     * @see #DEBUG_LOG_GL_CALLS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.489 -0500", hash_original_method = "95CD067D63C131003FD4FBBE7098897E", hash_generated_method = "9261BD1612C1499767F68F30239E960D")
    
public void setDebugFlags(int debugFlags) {
        mDebugFlags = debugFlags;
    }

    /**
     * Get the current value of the debug flags.
     * @return the current value of the debug flags.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.492 -0500", hash_original_method = "6993850204A95232CAB55D0CCC1BAFCE", hash_generated_method = "5B8569C0D13F507F30A669044C905414")
    
public int getDebugFlags() {
        return mDebugFlags;
    }

    /**
     * Control whether the EGL context is preserved when the GLSurfaceView is paused and
     * resumed.
     * <p>
     * If set to true, then the EGL context may be preserved when the GLSurfaceView is paused.
     * Whether the EGL context is actually preserved or not depends upon whether the
     * Android device that the program is running on can support an arbitrary number of EGL
     * contexts or not. Devices that can only support a limited number of EGL contexts must
     * release the  EGL context in order to allow multiple applications to share the GPU.
     * <p>
     * If set to false, the EGL context will be released when the GLSurfaceView is paused,
     * and recreated when the GLSurfaceView is resumed.
     * <p>
     *
     * The default is false.
     *
     * @param preserveOnPause preserve the EGL context when paused
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.494 -0500", hash_original_method = "717A951DD1F3691DEF19A2756D2824F8", hash_generated_method = "1E69CC3A9974E31AB26DB2643D08D99D")
    
public void setPreserveEGLContextOnPause(boolean preserveOnPause) {
        mPreserveEGLContextOnPause = preserveOnPause;
    }

    /**
     * @return true if the EGL context will be preserved when paused
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.496 -0500", hash_original_method = "60238A7236A689DEF9712C11E43803DE", hash_generated_method = "10C6F477746D24D894FB8556AED5D14D")
    
public boolean getPreserveEGLContextOnPause() {
        return mPreserveEGLContextOnPause;
    }

    /**
     * Set the renderer associated with this view. Also starts the thread that
     * will call the renderer, which in turn causes the rendering to start.
     * <p>This method should be called once and only once in the life-cycle of
     * a GLSurfaceView.
     * <p>The following GLSurfaceView methods can only be called <em>before</em>
     * setRenderer is called:
     * <ul>
     * <li>{@link #setEGLConfigChooser(boolean)}
     * <li>{@link #setEGLConfigChooser(EGLConfigChooser)}
     * <li>{@link #setEGLConfigChooser(int, int, int, int, int, int)}
     * </ul>
     * <p>
     * The following GLSurfaceView methods can only be called <em>after</em>
     * setRenderer is called:
     * <ul>
     * <li>{@link #getRenderMode()}
     * <li>{@link #onPause()}
     * <li>{@link #onResume()}
     * <li>{@link #queueEvent(Runnable)}
     * <li>{@link #requestRender()}
     * <li>{@link #setRenderMode(int)}
     * </ul>
     *
     * @param renderer the renderer to use to perform OpenGL drawing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.499 -0500", hash_original_method = "64481B8066824EA776B6FC67FACE8B51", hash_generated_method = "6D4F0DDF00C28B1487EA8661D8C652E0")
    
public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (mEGLConfigChooser == null) {
            mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (mEGLContextFactory == null) {
            mEGLContextFactory = new DefaultContextFactory();
        }
        if (mEGLWindowSurfaceFactory == null) {
            mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        mRenderer = renderer;
        mGLThread = new GLThread(renderer);
        mGLThread.start();
    }

    /**
     * Install a custom EGLContextFactory.
     * <p>If this method is
     * called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>
     * If this method is not called, then by default
     * a context will be created with no shared context and
     * with a null attribute list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.501 -0500", hash_original_method = "6F22CFBD5A9926728BF6F0008FB33425", hash_generated_method = "DC9E8D32C039787D64519715E40CE49F")
    
public void setEGLContextFactory(EGLContextFactory factory) {
        checkRenderThreadState();
        mEGLContextFactory = factory;
    }

    /**
     * Install a custom EGLWindowSurfaceFactory.
     * <p>If this method is
     * called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>
     * If this method is not called, then by default
     * a window surface will be created with a null attribute list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.504 -0500", hash_original_method = "1FB2F696FFEAFBF78B8CE4F0AE52B72E", hash_generated_method = "F074732CBE39BE2ECCCEAEC1A3CF39C3")
    
public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory factory) {
        checkRenderThreadState();
        mEGLWindowSurfaceFactory = factory;
    }

    /**
     * Install a custom EGLConfigChooser.
     * <p>If this method is
     * called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>
     * If no setEGLConfigChooser method is called, then by default the
     * view will choose an EGLConfig that is compatible with the current
     * android.view.Surface, with a depth buffer depth of
     * at least 16 bits.
     * @param configChooser
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.507 -0500", hash_original_method = "95299B7816E92BC747285D3C263BF3C6", hash_generated_method = "2C35C576067D769596C73CCDB4367EE8")
    
public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        checkRenderThreadState();
        mEGLConfigChooser = configChooser;
    }

    /**
     * Install a config chooser which will choose a config
     * as close to 16-bit RGB as possible, with or without an optional depth
     * buffer as close to 16-bits as possible.
     * <p>If this method is
     * called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>
     * If no setEGLConfigChooser method is called, then by default the
     * view will choose an RGB_565 surface with a depth buffer depth of
     * at least 16 bits.
     *
     * @param needDepth
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.509 -0500", hash_original_method = "226B740D6DC98E22518E0EAB23B55B9E", hash_generated_method = "A3548541304921EF9B9451C8624E09B4")
    
public void setEGLConfigChooser(boolean needDepth) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(needDepth));
    }
    
    private class DefaultContextFactory implements EGLContextFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.551 -0500", hash_original_field = "05ED6095C69105CABAB5DA8E1FBF3493", hash_generated_field = "A15829C68F3F8F197FCD7108E0FB196F")

        private int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.265 -0400", hash_original_method = "367DA38C080CFBEAC5EB8A1CB6A885E8", hash_generated_method = "367DA38C080CFBEAC5EB8A1CB6A885E8")
        public DefaultContextFactory ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.553 -0500", hash_original_method = "97605796E723B11DCDEB6F529D20F6F4", hash_generated_method = "5A7BAE0B43A11C48A761B3B3B9563853")
        
public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig config) {
            int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, mEGLContextClientVersion,
                    EGL10.EGL_NONE };

            return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT,
                    mEGLContextClientVersion != 0 ? attrib_list : null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.556 -0500", hash_original_method = "737CCA85FA60476B1E480C5B63FFDFD8", hash_generated_method = "7F4AE3067E58018C42D724910F1EAC0F")
        
public void destroyContext(EGL10 egl, EGLDisplay display,
                EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
                Log.e("DefaultContextFactory", "display:" + display + " context: " + context);
                if (LOG_THREADS) {
                    Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                }
                throw new RuntimeException("eglDestroyContext failed: "
                        + EGLLogWrapper.getErrorString(egl.eglGetError()));
            }
        }
        
    }
    
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.267 -0400", hash_original_method = "6C49886831D2941418C9D5571DBB218F", hash_generated_method = "6C49886831D2941418C9D5571DBB218F")
        public DefaultWindowSurfaceFactory ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.564 -0500", hash_original_method = "B3EF23184592B8D563E81FEA0BB94777", hash_generated_method = "CB969D3F2147F995491B63D875F72A04")
        
public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display,
                EGLConfig config, Object nativeWindow) {
            EGLSurface result = null;
            try {
                result = egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            } catch (IllegalArgumentException e) {
                // This exception indicates that the surface flinger surface
                // is not valid. This can happen if the surface flinger surface has
                // been torn down, but the application has not yet been
                // notified via SurfaceHolder.Callback.surfaceDestroyed.
                // In theory the application should be notified first,
                // but in practice sometimes it is not. See b/4588890
                Log.e(TAG, "eglCreateWindowSurface", e);
            }
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.566 -0500", hash_original_method = "E501A8DBEBAA16077B860412B23D22C3", hash_generated_method = "1FEC7822EBA1B2276B6683869996FF4E")
        
public void destroySurface(EGL10 egl, EGLDisplay display,
                EGLSurface surface) {
            egl.eglDestroySurface(display, surface);
        }
        
    }
    
    private abstract class BaseConfigChooser implements EGLConfigChooser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.583 -0500", hash_original_field = "EB34F51E7132820858554B010CC454CD", hash_generated_field = "0A6C46FF0E4A8D427534A13E3913B826")

        protected int[] mConfigSpec;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.575 -0500", hash_original_method = "A0DBF051E13A9D28CAE6FB3EFED45483", hash_generated_method = "A5E974EEC38C0E7B12397A24785B6534")
        
public BaseConfigChooser(int[] configSpec) {
            mConfigSpec = filterConfigSpec(configSpec);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.578 -0500", hash_original_method = "8324D0F818B008780D6764BA3D123E5B", hash_generated_method = "63CBED63AE12116AE7A5F601F1A89B78")
        
public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (!egl.eglChooseConfig(display, mConfigSpec, null, 0,
                    num_config)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }

            int numConfigs = num_config[0];

            if (numConfigs <= 0) {
                throw new IllegalArgumentException(
                        "No configs match configSpec");
            }

            EGLConfig[] configs = new EGLConfig[numConfigs];
            if (!egl.eglChooseConfig(display, mConfigSpec, configs, numConfigs,
                    num_config)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig config = chooseConfig(egl, display, configs);
            if (config == null) {
                throw new IllegalArgumentException("No config chosen");
            }
            return config;
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.580 -0500", hash_original_method = "D5AA0DE9B25FCCF7DFB660A22AA5E818", hash_generated_method = "2C8C09C7C8206FCEC2227CEC3F964AB2")
        
abstract EGLConfig chooseConfig(EGL10 egl, EGLDisplay display,
                EGLConfig[] configs);

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.585 -0500", hash_original_method = "A5ED2D6BA80622A09257A565CA0B4B3A", hash_generated_method = "0FC5EAFD7C70887E6B3AD3B7AA4E313F")
        
private int[] filterConfigSpec(int[] configSpec) {
            if (mEGLContextClientVersion != 2) {
                return configSpec;
            }
            /* We know none of the subclasses define EGL_RENDERABLE_TYPE.
             * And we know the configSpec is well formed.
             */
            int len = configSpec.length;
            int[] newConfigSpec = new int[len + 2];
            System.arraycopy(configSpec, 0, newConfigSpec, 0, len-1);
            newConfigSpec[len-1] = EGL10.EGL_RENDERABLE_TYPE;
            newConfigSpec[len] = 4; /* EGL_OPENGL_ES2_BIT */
            newConfigSpec[len+1] = EGL10.EGL_NONE;
            return newConfigSpec;
        }
        
    }
    
    private class ComponentSizeChooser extends BaseConfigChooser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.600 -0500", hash_original_field = "3CB28337EDF97BC7A43DE559FAEFBE0E", hash_generated_field = "3B2CE6613BAAB11EC6605CC6BD87C453")

        private int[] mValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.602 -0500", hash_original_field = "2E964ADEC9C377671C9C69464FED0F0B", hash_generated_field = "DFB29A4DE6CC3A6F59EEA72256CA1B07")

        protected int mRedSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.604 -0500", hash_original_field = "B99BED964E3D6E1F5940B8B9C6501E93", hash_generated_field = "F004205D5ECD51A712961F597706D420")

        protected int mGreenSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.607 -0500", hash_original_field = "853877738747565CA1E7BAF1CEB7DE5D", hash_generated_field = "10FEF4227DE2E0FF5A7B93D82D802C38")

        protected int mBlueSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.609 -0500", hash_original_field = "67CC59656EF994BD3A684B6FCB15A59F", hash_generated_field = "4D595AB931725F0489E385B7FCCFFE15")

        protected int mAlphaSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.611 -0500", hash_original_field = "C55E8B9E6FC4A0DD23042A52ED0D0342", hash_generated_field = "069D7DB749F1CA74392E9E3B7C7F6E2C")

        protected int mDepthSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.613 -0500", hash_original_field = "8E37C0699655984CBBA9D7CD249DDE16", hash_generated_field = "2F511AB8225415A379DBE2BACDAB208A")

        protected int mStencilSize;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.591 -0500", hash_original_method = "E977E3948EFA9E2BABD91C89238414B6", hash_generated_method = "21E8C4EC8FE1C345989AAE24213D41E2")
        
public ComponentSizeChooser(int redSize, int greenSize, int blueSize,
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
       }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.595 -0500", hash_original_method = "90A4D31D410952CF994E4BDBA2A25F67", hash_generated_method = "84D5B4E82932F44C4E83D513B83E26CF")
        
@Override
        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display,
                EGLConfig[] configs) {
            for (EGLConfig config : configs) {
                int d = findConfigAttrib(egl, display, config,
                        EGL10.EGL_DEPTH_SIZE, 0);
                int s = findConfigAttrib(egl, display, config,
                        EGL10.EGL_STENCIL_SIZE, 0);
                if ((d >= mDepthSize) && (s >= mStencilSize)) {
                    int r = findConfigAttrib(egl, display, config,
                            EGL10.EGL_RED_SIZE, 0);
                    int g = findConfigAttrib(egl, display, config,
                             EGL10.EGL_GREEN_SIZE, 0);
                    int b = findConfigAttrib(egl, display, config,
                              EGL10.EGL_BLUE_SIZE, 0);
                    int a = findConfigAttrib(egl, display, config,
                            EGL10.EGL_ALPHA_SIZE, 0);
                    if ((r == mRedSize) && (g == mGreenSize)
                            && (b == mBlueSize) && (a == mAlphaSize)) {
                        return config;
                    }
                }
            }
            return null;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.597 -0500", hash_original_method = "97DBBE0DC2E33C941B4CF19B7BAFBD1F", hash_generated_method = "205CF82AC1FF7710F62C76CA25FE446E")
        
private int findConfigAttrib(EGL10 egl, EGLDisplay display,
                EGLConfig config, int attribute, int defaultValue) {

            if (egl.eglGetConfigAttrib(display, config, attribute, mValue)) {
                return mValue[0];
            }
            return defaultValue;
        }
        
    }
    
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.620 -0500", hash_original_method = "5A2D4186FEBB3CAA35FAB0BA469AA3FD", hash_generated_method = "AE238B0832C01983744DC20A0CAD79BF")
        
public SimpleEGLConfigChooser(boolean withDepthBuffer) {
            super(5, 6, 5, 0, withDepthBuffer ? 16 : 0, 0);
        }
        
    }
    
    private class EglHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.650 -0500", hash_original_field = "3F30F83F3D104993379AD92B39AFB83D", hash_generated_field = "3F30F83F3D104993379AD92B39AFB83D")

        EGL10 mEgl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.652 -0500", hash_original_field = "7AE477A3032DB5EA7015A0F83A2F2E86", hash_generated_field = "7AE477A3032DB5EA7015A0F83A2F2E86")

        EGLDisplay mEglDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.654 -0500", hash_original_field = "3BCE51A04A846FE71AD218CCB7DF9B47", hash_generated_field = "3BCE51A04A846FE71AD218CCB7DF9B47")

        EGLSurface mEglSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.656 -0500", hash_original_field = "0645CA46F08494E04FEDB68893B6F495", hash_generated_field = "0645CA46F08494E04FEDB68893B6F495")

        EGLConfig mEglConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.658 -0500", hash_original_field = "75D18A698C8C0156FC372CC4CDC659FD", hash_generated_field = "75D18A698C8C0156FC372CC4CDC659FD")

        EGLContext mEglContext;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.625 -0500", hash_original_method = "83AF3D46DA70FB835D7CAB893AE219D0", hash_generated_method = "B7FD75A300B866ED8F1391BE46EE8008")
        
public EglHelper() {

        }

        /**
         * Initialize EGL for a given configuration spec.
         * @param configSpec
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.628 -0500", hash_original_method = "E1120F549D6F6E96023A6A07CACEFA1B", hash_generated_method = "C5E6E6E23C1F8C5EAA10C4F8EDA199B8")
        
public void start() {
            if (LOG_EGL) {
                Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            }
            /*
             * Get an EGL instance
             */
            mEgl = (EGL10) EGLContext.getEGL();

            /*
             * Get to the default display.
             */
            mEglDisplay = mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);

            if (mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }

            /*
             * We can now initialize EGL for that display
             */
            int[] version = new int[2];
            if(!mEgl.eglInitialize(mEglDisplay, version)) {
                throw new RuntimeException("eglInitialize failed");
            }
            mEglConfig = mEGLConfigChooser.chooseConfig(mEgl, mEglDisplay);

            /*
            * Create an EGL context. We want to do this as rarely as we can, because an
            * EGL context is a somewhat heavy object.
            */
            mEglContext = mEGLContextFactory.createContext(mEgl, mEglDisplay, mEglConfig);
            if (mEglContext == null || mEglContext == EGL10.EGL_NO_CONTEXT) {
                mEglContext = null;
                throwEglException("createContext");
            }
            if (LOG_EGL) {
                Log.w("EglHelper", "createContext " + mEglContext + " tid=" + Thread.currentThread().getId());
            }

            mEglSurface = null;
        }

        /*
         * React to the creation of a new surface by creating and returning an
         * OpenGL interface that renders to that surface.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.631 -0500", hash_original_method = "E9F7F165780F6F468D822EAA5675F636", hash_generated_method = "350FA8ADBA2DBCE3A9F65BF5139A3C62")
        
public GL createSurface(SurfaceHolder holder) {
            if (LOG_EGL) {
                Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            }
            /*
             * Check preconditions.
             */
            if (mEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            /*
             *  The window size has changed, so we need to create a new
             *  surface.
             */
            if (mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {

                /*
                 * Unbind and destroy the old EGL surface, if
                 * there is one.
                 */
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
            }

            /*
             * Create an EGL surface we can render into.
             */
            mEglSurface = mEGLWindowSurfaceFactory.createWindowSurface(mEgl,
                    mEglDisplay, mEglConfig, holder);

            if (mEglSurface == null || mEglSurface == EGL10.EGL_NO_SURFACE) {
                int error = mEgl.eglGetError();
                if (error == EGL10.EGL_BAD_NATIVE_WINDOW) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return null;
            }

            /*
             * Before we can issue GL commands, we need to make sure
             * the context is current and bound to a surface.
             */
            if (!mEgl.eglMakeCurrent(mEglDisplay, mEglSurface, mEglSurface, mEglContext)) {
                throwEglException("eglMakeCurrent");
            }

            GL gl = mEglContext.getGL();
            if (mGLWrapper != null) {
                gl = mGLWrapper.wrap(gl);
            }

            if ((mDebugFlags & (DEBUG_CHECK_GL_ERROR | DEBUG_LOG_GL_CALLS)) != 0) {
                int configFlags = 0;
                Writer log = null;
                if ((mDebugFlags & DEBUG_CHECK_GL_ERROR) != 0) {
                    configFlags |= GLDebugHelper.CONFIG_CHECK_GL_ERROR;
                }
                if ((mDebugFlags & DEBUG_LOG_GL_CALLS) != 0) {
                    log = new LogWriter();
                }
                gl = GLDebugHelper.wrap(gl, configFlags, log);
            }
            return gl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.634 -0500", hash_original_method = "009805D54505405E7F35DCDF643A7FC6", hash_generated_method = "F5EA51A6054E87567498BD10AA803184")
        
public void purgeBuffers() {
            mEgl.eglMakeCurrent(mEglDisplay,
                    EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE,
                    EGL10.EGL_NO_CONTEXT);
            mEgl.eglMakeCurrent(mEglDisplay,
                    mEglSurface, mEglSurface,
                    mEglContext);
        }

        /**
         * Display the current render surface.
         * @return false if the context has been lost.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.637 -0500", hash_original_method = "9C95ED348041927E683F703A784FA97A", hash_generated_method = "401190BEF3C7CF9EC9C55DEB6D70B31A")
        
public boolean swap() {
            if (! mEgl.eglSwapBuffers(mEglDisplay, mEglSurface)) {

                /*
                 * Check for EGL_CONTEXT_LOST, which means the context
                 * and all associated data were lost (For instance because
                 * the device went to sleep). We need to sleep until we
                 * get a new surface.
                 */
                int error = mEgl.eglGetError();
                switch(error) {
                case EGL11.EGL_CONTEXT_LOST:
                    return false;
                case EGL10.EGL_BAD_NATIVE_WINDOW:
                    // The native window is bad, probably because the
                    // window manager has closed it. Ignore this error,
                    // on the expectation that the application will be closed soon.
                    Log.e("EglHelper", "eglSwapBuffers returned EGL_BAD_NATIVE_WINDOW. tid=" + Thread.currentThread().getId());
                    break;
                default:
                    throwEglException("eglSwapBuffers", error);
                }
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.640 -0500", hash_original_method = "F4390E64E142A92962AFFCA2A868DB1D", hash_generated_method = "4467A4AE58B12C1C089A88B4A1332EB8")
        
public void destroySurface() {
            if (LOG_EGL) {
                Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            }
            if (mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE) {
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_SURFACE,
                        EGL10.EGL_NO_CONTEXT);
                mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
                mEglSurface = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.643 -0500", hash_original_method = "75E7D06EEC93D6B21DBAB7382B0AE2AF", hash_generated_method = "6BA63A62B72351656F543C21719C04D0")
        
public void finish() {
            if (LOG_EGL) {
                Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            }
            if (mEglContext != null) {
                mEGLContextFactory.destroyContext(mEgl, mEglDisplay, mEglContext);
                mEglContext = null;
            }
            if (mEglDisplay != null) {
                mEgl.eglTerminate(mEglDisplay);
                mEglDisplay = null;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.645 -0500", hash_original_method = "BBFD946D1E92713A8E3F246C64816A5E", hash_generated_method = "576651A4AA863B1D7BF5137C0EBAA7D6")
        
private void throwEglException(String function) {
            throwEglException(function, mEgl.eglGetError());
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.648 -0500", hash_original_method = "F35384FC419606847EA5AA038D9E6031", hash_generated_method = "2DE54EEC147895E03717DD9D459446BD")
        
private void throwEglException(String function, int error) {
            String message = function + " failed: " + EGLLogWrapper.getErrorString(error);
            if (LOG_THREADS) {
                Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + message);
            }
            throw new RuntimeException(message);
        }
        
    }
    
    class GLThread extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.719 -0500", hash_original_field = "B999E08569F60578F2C6EEC297448896", hash_generated_field = "FBAEA3980C3C0B3ACDB6B73A2BC269A5")

        // variables are protected by the sGLThreadManager monitor
        private boolean mShouldExit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.721 -0500", hash_original_field = "9D5BBD948F81BA103405D452D2629FA5", hash_generated_field = "44F266F0432C0EFD235C8183DD0B51A1")

        private boolean mExited;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.723 -0500", hash_original_field = "06C30C40FD4237095E84581C2D7A3E86", hash_generated_field = "99FD2263A5DF98BA94E8C373CDA953C3")

        private boolean mRequestPaused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.726 -0500", hash_original_field = "D0FCBA7E15DDDC88C32E39FCFFF456DB", hash_generated_field = "9B834AB9E5C00250542F8DEB91ED0E2F")

        private boolean mPaused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.729 -0500", hash_original_field = "1BE3066D2E55A4CBD16D3D1DDBF1E4CD", hash_generated_field = "514F0E2FF657C1E2926C625EE0C2A55C")

        private boolean mHasSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.731 -0500", hash_original_field = "E1AE13BEEB8CE2FA4DC95EBBF27E6119", hash_generated_field = "F1D840BEC01E65E93A488E3A6D14D736")

        private boolean mWaitingForSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.734 -0500", hash_original_field = "A04C3B5D15EB8FF1626C8B7AE96E4912", hash_generated_field = "4A2A91067D7B18BAA9311207F028FEDC")

        private boolean mHaveEglContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.736 -0500", hash_original_field = "984E31C6C60CB31A223EBE22C6D087AF", hash_generated_field = "A6F3B75A3C62BDC269D81AE3192A2B1E")

        private boolean mHaveEglSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.739 -0500", hash_original_field = "8A9EDC3DDD9BF33F5ED4BAB25B51FA21", hash_generated_field = "AEDBAD4E651BFDC4A3C0A200EA9340E8")

        private boolean mShouldReleaseEglContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.741 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.743 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.745 -0500", hash_original_field = "E53CE01192FE55D66BB84697D6A15AEC", hash_generated_field = "E7653EB9F9A1926DBAF869454A58408B")

        private int mRenderMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.748 -0500", hash_original_field = "EE0FCE1EAD5CB5E619945A31530AAFAD", hash_generated_field = "04D0EE4906FBC2F004DE3C4AF5DBCC4F")

        private boolean mRequestRender;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.751 -0500", hash_original_field = "B01C205B4ACBCB6103F5C7F6EC748F58", hash_generated_field = "1E19E103716E35A6AED458C0663993A3")

        private boolean mRenderComplete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.753 -0500", hash_original_field = "8C1D82BE6E35D39F764DF9852E1AB5CF", hash_generated_field = "B5F71D74E6909FCC5E419B53FBFAF01C")

        private ArrayList<Runnable> mEventQueue = new ArrayList<Runnable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.756 -0500", hash_original_field = "720EF707169F06701CBF89E969BC03B3", hash_generated_field = "655D7742BDF0154D755D8012DFB26E60")

        private Renderer mRenderer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.758 -0500", hash_original_field = "F4A98CA9FF1C1FFD4423D035B7A414C6", hash_generated_field = "643AE0FAB78B60A315CA9AB4E93467B6")

        private EglHelper mEglHelper;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.667 -0500", hash_original_method = "6338646405C7F70E0BB13ECBAEE65220", hash_generated_method = "6338646405C7F70E0BB13ECBAEE65220")
        
GLThread(Renderer renderer) {
            super();
            mWidth = 0;
            mHeight = 0;
            mRequestRender = true;
            mRenderMode = RENDERMODE_CONTINUOUSLY;
            mRenderer = renderer;
        }

        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.669 -0500", hash_original_method = "4EBF7F6B9BB16BE66D221453F245DA46", hash_generated_method = "1653E32386D466C1F718F4265D118D53")
        
@Override
        public void run() {
            setName("GLThread " + getId());
            if (LOG_THREADS) {
                Log.i("GLThread", "starting tid=" + getId());
            }

            try {
                guardedRun();
            } catch (InterruptedException e) {
                // fall thru and exit normally
            } finally {
                sGLThreadManager.threadExiting(this);
            }
        }

        /*
         * This private method should only be called inside a
         * synchronized(sGLThreadManager) block.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.672 -0500", hash_original_method = "1FA739F1ECF9B8C719EEC300CFB94B99", hash_generated_method = "52444CA2211C1A24BDC91B06E5337381")
        
private void stopEglSurfaceLocked() {
            if (mHaveEglSurface) {
                mHaveEglSurface = false;
                mEglHelper.destroySurface();
            }
        }

        /*
         * This private method should only be called inside a
         * synchronized(sGLThreadManager) block.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.675 -0500", hash_original_method = "08753DB570F3FF0DFFEC96C08E49FCF2", hash_generated_method = "6356F0F56CBBD764359507E658715010")
        
private void stopEglContextLocked() {
            if (mHaveEglContext) {
                mEglHelper.finish();
                mHaveEglContext = false;
                sGLThreadManager.releaseEglContextLocked(this);
            }
        }
        @DSVerified
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.682 -0500", hash_original_method = "711FE3C53AF4E351881864AF0E3340A2", hash_generated_method = "B13447098E0AD2EE755FA704D1A400DA")
        
private void guardedRun() throws InterruptedException {
            mEglHelper = new EglHelper();
            mHaveEglContext = false;
            mHaveEglSurface = false;
            try {
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

                while (true) {
                    synchronized (sGLThreadManager) {
                        while (true) {
                            if (mShouldExit) {
                                return;
                            }

                            if (! mEventQueue.isEmpty()) {
                                event = mEventQueue.remove(0);
                                break;
                            }

                            // Update the pause state.
                            if (mPaused != mRequestPaused) {
                                mPaused = mRequestPaused;
                                sGLThreadManager.notifyAll();
                                if (LOG_PAUSE_RESUME) {
                                    Log.i("GLThread", "mPaused is now " + mPaused + " tid=" + getId());
                                }
                            }

                            // Do we need to give up the EGL context?
                            if (mShouldReleaseEglContext) {
                                if (LOG_SURFACE) {
                                    Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());
                                }
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                mShouldReleaseEglContext = false;
                                askedToReleaseEglContext = true;
                            }

                            // Have we lost the EGL context?
                            if (lostEglContext) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                                lostEglContext = false;
                            }

                            // Do we need to release the EGL surface?
                            if (mHaveEglSurface && mPaused) {
                                if (LOG_SURFACE) {
                                    Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());
                                }
                                stopEglSurfaceLocked();
                                if (!mPreserveEGLContextOnPause || sGLThreadManager.shouldReleaseEGLContextWhenPausing()) {
                                    stopEglContextLocked();
                                    if (LOG_SURFACE) {
                                        Log.i("GLThread", "releasing EGL context because paused tid=" + getId());
                                    }
                                }
                                if (sGLThreadManager.shouldTerminateEGLWhenPausing()) {
                                    mEglHelper.finish();
                                    if (LOG_SURFACE) {
                                        Log.i("GLThread", "terminating EGL because paused tid=" + getId());
                                    }
                                }
                            }

                            // Have we lost the surface view surface?
                            if ((! mHasSurface) && (! mWaitingForSurface)) {
                                if (LOG_SURFACE) {
                                    Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());
                                }
                                if (mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                mWaitingForSurface = true;
                                sGLThreadManager.notifyAll();
                            }

                            // Have we acquired the surface view surface?
                            if (mHasSurface && mWaitingForSurface) {
                                if (LOG_SURFACE) {
                                    Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());
                                }
                                mWaitingForSurface = false;
                                sGLThreadManager.notifyAll();
                            }

                            if (doRenderNotification) {
                                if (LOG_SURFACE) {
                                    Log.i("GLThread", "sending render notification tid=" + getId());
                                }
                                wantRenderNotification = false;
                                doRenderNotification = false;
                                mRenderComplete = true;
                                sGLThreadManager.notifyAll();
                            }

                            // Ready to draw?
                            if (readyToDraw()) {

                                // If we don't have an EGL context, try to acquire one.
                                if (! mHaveEglContext) {
                                    if (askedToReleaseEglContext) {
                                        askedToReleaseEglContext = false;
                                    } else if (sGLThreadManager.tryAcquireEglContextLocked(this)) {
                                        try {
                                            mEglHelper.start();
                                        } catch (RuntimeException t) {
                                            sGLThreadManager.releaseEglContextLocked(this);
                                            throw t;
                                        }
                                        mHaveEglContext = true;
                                        createEglContext = true;

                                        sGLThreadManager.notifyAll();
                                    }
                                }

                                if (mHaveEglContext && !mHaveEglSurface) {
                                    mHaveEglSurface = true;
                                    createEglSurface = true;
                                    sizeChanged = true;
                                }

                                if (mHaveEglSurface) {
                                    if (mSizeChanged) {
                                        sizeChanged = true;
                                        w = mWidth;
                                        h = mHeight;
                                        wantRenderNotification = true;
                                        if (LOG_SURFACE) {
                                            Log.i("GLThread", "noticing that we want render notification tid=" + getId());
                                        }

                                        if (DRAW_TWICE_AFTER_SIZE_CHANGED) {
                                            // We keep mRequestRender true so that we draw twice after the size changes.
                                            // (Once because of mSizeChanged, the second time because of mRequestRender.)
                                            // This forces the updated graphics onto the screen.
                                        } else {
                                            mRequestRender = false;
                                        }
                                        mSizeChanged = false;
                                    } else {
                                        mRequestRender = false;
                                    }
                                    sGLThreadManager.notifyAll();
                                    break;
                                }
                            }

                            // By design, this is the only place in a GLThread thread where we wait().
                            if (LOG_THREADS) {
                                Log.i("GLThread", "waiting tid=" + getId()
                                    + " mHaveEglContext: " + mHaveEglContext
                                    + " mHaveEglSurface: " + mHaveEglSurface
                                    + " mPaused: " + mPaused
                                    + " mHasSurface: " + mHasSurface
                                    + " mWaitingForSurface: " + mWaitingForSurface
                                    + " mWidth: " + mWidth
                                    + " mHeight: " + mHeight
                                    + " mRequestRender: " + mRequestRender
                                    + " mRenderMode: " + mRenderMode);
                            }
                            sGLThreadManager.wait();
                        }
                    } // end of synchronized(sGLThreadManager)

                    if (event != null) {
                        event.run();
                        event = null;
                        continue;
                    }

                    if (createEglSurface) {
                        if (LOG_SURFACE) {
                            Log.w("GLThread", "egl createSurface");
                        }
                        gl = (GL10) mEglHelper.createSurface(getHolder());
                        if (gl == null) {
                            // Couldn't create a surface. Quit quietly.
                            break;
                        }
                        sGLThreadManager.checkGLDriver(gl);
                        createEglSurface = false;
                    }

                    if (createEglContext) {
                        if (LOG_RENDERER) {
                            Log.w("GLThread", "onSurfaceCreated");
                        }
                        mRenderer.onSurfaceCreated(gl, mEglHelper.mEglConfig);
                        createEglContext = false;
                    }

                    if (sizeChanged) {
                        if (LOG_RENDERER) {
                            Log.w("GLThread", "onSurfaceChanged(" + w + ", " + h + ")");
                        }
                        mEglHelper.purgeBuffers();
                        mRenderer.onSurfaceChanged(gl, w, h);
                        sizeChanged = false;
                    }

                    if (LOG_RENDERER_DRAW_FRAME) {
                        Log.w("GLThread", "onDrawFrame tid=" + getId());
                    }
                    mRenderer.onDrawFrame(gl);
                    if (!mEglHelper.swap()) {
                        if (LOG_SURFACE) {
                            Log.i("GLThread", "egl context lost tid=" + getId());
                        }
                        lostEglContext = true;
                    }

                    if (wantRenderNotification) {
                        doRenderNotification = true;
                    }
                }

            } finally {
                /*
                 * clean-up everything...
                 */
                synchronized (sGLThreadManager) {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.684 -0500", hash_original_method = "9F067F2F4ACE6678B9A9189C7770DD17", hash_generated_method = "4FF3ECBFF9C668577D888A352C512B82")
        
public boolean ableToDraw() {
            return mHaveEglContext && mHaveEglSurface && readyToDraw();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.687 -0500", hash_original_method = "0EE68488D52C3628D006C7323CA4E5A0", hash_generated_method = "577848DF83F2720EAE848E5E2B72B3F6")
        
private boolean readyToDraw() {
            return (!mPaused) && mHasSurface
                && (mWidth > 0) && (mHeight > 0)
                && (mRequestRender || (mRenderMode == RENDERMODE_CONTINUOUSLY));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.689 -0500", hash_original_method = "DBFC9FD50E90875659CDDCEC9AA517CD", hash_generated_method = "097B35F7570163BDDDC11135B25B7DEF")
        
public void setRenderMode(int renderMode) {
            if ( !((RENDERMODE_WHEN_DIRTY <= renderMode) && (renderMode <= RENDERMODE_CONTINUOUSLY)) ) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized(sGLThreadManager) {
                mRenderMode = renderMode;
                sGLThreadManager.notifyAll();
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.692 -0500", hash_original_method = "FE0099A91432BFCACE7C52B0FC1032B6", hash_generated_method = "7EE3F7FE94B63E26C6FCF8CCB2CE038E")
        
public int getRenderMode() {
            synchronized(sGLThreadManager) {
                return mRenderMode;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.695 -0500", hash_original_method = "7D299D0786810F42249F0484E8A25CD9", hash_generated_method = "E8E3A1891256BE65BCA478970C7D6608")
        
public void requestRender() {
            synchronized(sGLThreadManager) {
                mRequestRender = true;
                sGLThreadManager.notifyAll();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.697 -0500", hash_original_method = "E700922CB1559E30A5B5551273407803", hash_generated_method = "639B37422F2B0FF3CB80ECB7479685E0")
        
public void surfaceCreated() {
            synchronized(sGLThreadManager) {
                if (LOG_THREADS) {
                    Log.i("GLThread", "surfaceCreated tid=" + getId());
                }
                mHasSurface = true;
                sGLThreadManager.notifyAll();
                while((mWaitingForSurface) && (!mExited)) {
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.700 -0500", hash_original_method = "CF6F3A984F95B50FF50C1BADBEA0D748", hash_generated_method = "C988229BFE395757F26A1234F60D5C37")
        
public void surfaceDestroyed() {
            synchronized(sGLThreadManager) {
                if (LOG_THREADS) {
                    Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                }
                mHasSurface = false;
                sGLThreadManager.notifyAll();
                while((!mWaitingForSurface) && (!mExited)) {
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.702 -0500", hash_original_method = "C67CE20F9EC18CF1CF416A1853C3B589", hash_generated_method = "4BFB9756215BC99E8A25D8F7587F7E79")
        
public void onPause() {
            synchronized (sGLThreadManager) {
                if (LOG_PAUSE_RESUME) {
                    Log.i("GLThread", "onPause tid=" + getId());
                }
                mRequestPaused = true;
                sGLThreadManager.notifyAll();
                while ((! mExited) && (! mPaused)) {
                    if (LOG_PAUSE_RESUME) {
                        Log.i("Main thread", "onPause waiting for mPaused.");
                    }
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.705 -0500", hash_original_method = "8E5DEB2C9B7EC152BCE3E0DC74768ADB", hash_generated_method = "CC3AFE76D78A8C3F1F7F5ABE444960BD")
        
public void onResume() {
            synchronized (sGLThreadManager) {
                if (LOG_PAUSE_RESUME) {
                    Log.i("GLThread", "onResume tid=" + getId());
                }
                mRequestPaused = false;
                mRequestRender = true;
                mRenderComplete = false;
                sGLThreadManager.notifyAll();
                while ((! mExited) && mPaused && (!mRenderComplete)) {
                    if (LOG_PAUSE_RESUME) {
                        Log.i("Main thread", "onResume waiting for !mPaused.");
                    }
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.708 -0500", hash_original_method = "E1DF3790FCF903F4369120E3C31DD321", hash_generated_method = "24A41C72CDB2E979DB7DCEE409EBA6B5")
        
public void onWindowResize(int w, int h) {
            synchronized (sGLThreadManager) {
                mWidth = w;
                mHeight = h;
                mSizeChanged = true;
                mRequestRender = true;
                mRenderComplete = false;
                sGLThreadManager.notifyAll();

                // Wait for thread to react to resize and render a frame
                while (! mExited && !mPaused && !mRenderComplete
                        && (mGLThread != null && mGLThread.ableToDraw())) {
                    if (LOG_SURFACE) {
                        Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + mGLThread.getId());
                    }
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.711 -0500", hash_original_method = "B658ED85C2522980AFFC21FA75A8FE5F", hash_generated_method = "77151B01F6603C1965F5D818087260A1")
        
public void requestExitAndWait() {
            // don't call this from GLThread thread or it is a guaranteed
            // deadlock!
            synchronized(sGLThreadManager) {
                mShouldExit = true;
                sGLThreadManager.notifyAll();
                while (! mExited) {
                    try {
                        sGLThreadManager.wait();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.714 -0500", hash_original_method = "9327C398D00F21C8F0D3A5F602389F52", hash_generated_method = "3456EDA931BC4662AE4E4193DDCB3CBC")
        
public void requestReleaseEglContextLocked() {
            mShouldReleaseEglContext = true;
            sGLThreadManager.notifyAll();
        }

        /**
         * Queue an "event" to be run on the GL rendering thread.
         * @param r the runnable to be run on the GL rendering thread.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.716 -0500", hash_original_method = "8F41524AB3CEE2918675BC83BF3CC490", hash_generated_method = "4B9EF4ACF8F97C90CD4452F99244B87E")
        
public void queueEvent(Runnable r) {
            if (r == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized(sGLThreadManager) {
                mEventQueue.add(r);
                sGLThreadManager.notifyAll();
            }
        }
        
    }
    
    static class LogWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.778 -0500", hash_original_field = "128476B88E78A1761DD1201459C9F3EF", hash_generated_field = "93EF782A08ECBADA45732AEB26C05023")

        private StringBuilder mBuilder = new StringBuilder();
        
        @DSComment("Package priviledge")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.310 -0400", hash_original_method = "17A1C7BC31C04C9AEB1C6A159FE1E12E", hash_generated_method = "17A1C7BC31C04C9AEB1C6A159FE1E12E")
        public LogWriter ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.768 -0500", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "1CD08D4D2256B0899718D98755C4D248")
        
@Override public void close() {
            flushBuilder();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.771 -0500", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "64C92D353792C9C77A9951308C9A0855")
        
@Override public void flush() {
            flushBuilder();
        }

        @DSSink({DSSinkKind.IO})
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.773 -0500", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "72F623F59FC9F90F70CCD532565A22B3")
        
@Override public void write(char[] buf, int offset, int count) {
            for(int i = 0; i < count; i++) {
                char c = buf[offset + i];
                if ( c == '\n') {
                    flushBuilder();
                }
                else {
                    mBuilder.append(c);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.776 -0500", hash_original_method = "E3A61F648C50A4FD42F02D92C137403F", hash_generated_method = "B0C190A9FB0367232B9AD8C1B6CE3B2B")
        
private void flushBuilder() {
            if (mBuilder.length() > 0) {
                Log.v("GLSurfaceView", mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
            }
        }
        
    }
    
    private static class GLThreadManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.786 -0500", hash_original_field = "4814D7F8160EC08AEDB25F1C634E1282", hash_generated_field = "9D735A32CC6365416B5A8B54E94812D1")

        private static String TAG = "GLThreadManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.820 -0500", hash_original_field = "F20944801182C113CCC28806BA95AB62", hash_generated_field = "44145C195E85BF38DA0FFB2AC8BB4311")

        private static final int kGLES_20 = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.823 -0500", hash_original_field = "E474A5AC8CFE0FC4C1392759014366B3", hash_generated_field = "3621160A8F7B1BD84A2A6958E68DD5EA")

        private static final String kMSM7K_RENDERER_PREFIX =
            "Q3Dimension MSM7500 ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.826 -0500", hash_original_field = "575D4A5E7228D562E7428BA629F3C09D", hash_generated_field = "F329DF17B4230EF2C98D0E995B680386")

        private static final String kADRENO = "Adreno";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.808 -0500", hash_original_field = "F1062F8A09DE0C18156FD20E3B44CAEE", hash_generated_field = "F73A6B8127F542A081B6A62FA30A43F7")

        private boolean mGLESVersionCheckComplete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.810 -0500", hash_original_field = "FECFCAB227B687BE4CCD868AA303C14E", hash_generated_field = "B4C54A4CB01F0BC9B76DECECD129FF44")

        private int mGLESVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.812 -0500", hash_original_field = "5057EE1F3B73F3882984E3EAD62788CB", hash_generated_field = "446C076A6568D35915B8ED59A92E0AA9")

        private boolean mGLESDriverCheckComplete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.815 -0500", hash_original_field = "008570E2208BBB807AE651CB73ACE059", hash_generated_field = "682D31F8601D77498A0A2F017F5AF89E")

        private boolean mMultipleGLESContextsAllowed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.817 -0500", hash_original_field = "176ADADD3197C6FD58F69EB0EB55F510", hash_generated_field = "34CA86E2F3B4D626596C357B4FA1E7A5")

        private boolean mLimitedGLESContexts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.828 -0500", hash_original_field = "18DB0C067795818817897BF2B4F3125F", hash_generated_field = "648BA99AC2147F67E5271F329D877F61")

        private GLThread mEglOwner;
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.312 -0400", hash_original_method = "5D6BCD582D13070585FC5F161A43B68D", hash_generated_method = "5D6BCD582D13070585FC5F161A43B68D")
        public GLThreadManager ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.788 -0500", hash_original_method = "FE8705658DEAD61621738F4D8A2A7147", hash_generated_method = "70038F4DF24A8D37458F27C5DD63FECD")
        
public synchronized void threadExiting(GLThread thread) {
            if (LOG_THREADS) {
                Log.i("GLThread", "exiting tid=" +  thread.getId());
            }
            thread.mExited = true;
            if (mEglOwner == thread) {
                mEglOwner = null;
            }
            notifyAll();
        }

        /*
         * Tries once to acquire the right to use an EGL
         * context. Does not block. Requires that we are already
         * in the sGLThreadManager monitor when this is called.
         *
         * @return true if the right to use an EGL context was acquired.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.791 -0500", hash_original_method = "BB464B3FFF506A1CF7A316246B2050CF", hash_generated_method = "90BD7E9D98A0CCEA1443C3AA9881E8CE")
        
public boolean tryAcquireEglContextLocked(GLThread thread) {
            if (mEglOwner == thread || mEglOwner == null) {
                mEglOwner = thread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (mMultipleGLESContextsAllowed) {
                return true;
            }
            // Notify the owning thread that it should release the context.
            // TODO: implement a fairness policy. Currently
            // if the owning thread is drawing continuously it will just
            // reacquire the EGL context.
            if (mEglOwner != null) {
                mEglOwner.requestReleaseEglContextLocked();
            }
            return false;
        }

        /*
         * Releases the EGL context. Requires that we are already in the
         * sGLThreadManager monitor when this is called.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.794 -0500", hash_original_method = "3F74D4F9D098B5B4B240AE885DDBE7E6", hash_generated_method = "EC7FA1688629C127FC51A4B672C53C76")
        
public void releaseEglContextLocked(GLThread thread) {
            if (mEglOwner == thread) {
                mEglOwner = null;
            }
            notifyAll();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.797 -0500", hash_original_method = "12EA186A7F5CD9C6E3046A2A0BD2DF68", hash_generated_method = "E779D3A9F464D2CE0A848D4D0F20E77A")
        
public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            // Release the EGL context when pausing even if
            // the hardware supports multiple EGL contexts.
            // Otherwise the device could run out of EGL contexts.
            return mLimitedGLESContexts;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.800 -0500", hash_original_method = "BB392C65C3FB4BE472C770A6388E6483", hash_generated_method = "CE1C667E55371022BD6FC45EDAE0F1ED")
        
public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !mMultipleGLESContextsAllowed;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.803 -0500", hash_original_method = "3071AD09B063784236EDA64AF3B8A081", hash_generated_method = "B6D682DC5095AE670F7016D27838F27C")
        
public synchronized void checkGLDriver(GL10 gl) {
            if (! mGLESDriverCheckComplete) {
                checkGLESVersion();
                String renderer = gl.glGetString(GL10.GL_RENDERER);
                if (mGLESVersion < kGLES_20) {
                    mMultipleGLESContextsAllowed =
                        ! renderer.startsWith(kMSM7K_RENDERER_PREFIX);
                    notifyAll();
                }
                mLimitedGLESContexts = !mMultipleGLESContextsAllowed || renderer.startsWith(kADRENO);
                if (LOG_SURFACE) {
                    Log.w(TAG, "checkGLDriver renderer = \"" + renderer + "\" multipleContextsAllowed = "
                        + mMultipleGLESContextsAllowed
                        + " mLimitedGLESContexts = " + mLimitedGLESContexts);
                }
                mGLESDriverCheckComplete = true;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.805 -0500", hash_original_method = "6DFB699ADC87072E31136271B3768D35", hash_generated_method = "73AD1AB53516B33CCEA37E2F43A568D7")
        
private void checkGLESVersion() {
            if (! mGLESVersionCheckComplete) {
                mGLESVersion = SystemProperties.getInt(
                        "ro.opengles.version",
                        ConfigurationInfo.GL_ES_VERSION_UNDEFINED);
                if (mGLESVersion >= kGLES_20) {
                    mMultipleGLESContextsAllowed = true;
                }
                if (LOG_SURFACE) {
                    Log.w(TAG, "checkGLESVersion mGLESVersion =" +
                            " " + mGLESVersion + " mMultipleGLESContextsAllowed = " + mMultipleGLESContextsAllowed);
                }
                mGLESVersionCheckComplete = true;
            }
        }
    }
    
    public interface GLWrapper {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        GL wrap(GL gl);
    }
    
    public interface Renderer {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onSurfaceCreated(GL10 gl, EGLConfig config);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onSurfaceChanged(GL10 gl, int width, int height);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onDrawFrame(GL10 gl);
    }
    
    public interface EGLContextFactory {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context);
    }
    
    public interface EGLWindowSurfaceFactory {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config,
                Object nativeWindow);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface);
    }
    
    public interface EGLConfigChooser {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        EGLConfig chooseConfig(EGL10 egl, EGLDisplay display);
    }

    /**
     * Install a config chooser which will choose a config
     * with at least the specified depthSize and stencilSize,
     * and exactly the specified redSize, greenSize, blueSize and alphaSize.
     * <p>If this method is
     * called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>
     * If no setEGLConfigChooser method is called, then by default the
     * view will choose an RGB_565 surface with a depth buffer depth of
     * at least 16 bits.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.512 -0500", hash_original_method = "091BCCF8C091A3C39DC981548CC7F874", hash_generated_method = "DE1CE08963BE100CB3B0C5C0C11035D5")
    
public void setEGLConfigChooser(int redSize, int greenSize, int blueSize,
            int alphaSize, int depthSize, int stencilSize) {
        setEGLConfigChooser(new ComponentSizeChooser(redSize, greenSize,
                blueSize, alphaSize, depthSize, stencilSize));
    }

    /**
     * Inform the default EGLContextFactory and default EGLConfigChooser
     * which EGLContext client version to pick.
     * <p>Use this method to create an OpenGL ES 2.0-compatible context.
     * Example:
     * <pre class="prettyprint">
     *     public MyView(Context context) {
     *         super(context);
     *         setEGLContextClientVersion(2); // Pick an OpenGL ES 2.0 context.
     *         setRenderer(new MyRenderer());
     *     }
     * </pre>
     * <p>Note: Activities which require OpenGL ES 2.0 should indicate this by
     * setting @lt;uses-feature android:glEsVersion="0x00020000" /> in the activity's
     * AndroidManifest.xml file.
     * <p>If this method is called, it must be called before {@link #setRenderer(Renderer)}
     * is called.
     * <p>This method only affects the behavior of the default EGLContexFactory and the
     * default EGLConfigChooser. If
     * {@link #setEGLContextFactory(EGLContextFactory)} has been called, then the supplied
     * EGLContextFactory is responsible for creating an OpenGL ES 2.0-compatible context.
     * If
     * {@link #setEGLConfigChooser(EGLConfigChooser)} has been called, then the supplied
     * EGLConfigChooser is responsible for choosing an OpenGL ES 2.0-compatible config.
     * @param version The EGLContext client version to choose. Use 2 for OpenGL ES 2.0
     */
    @DSComment("OpenGL Viewer")
    @DSSafe(DSCat.GRAPHICS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.515 -0500", hash_original_method = "50689A18B452A2797F4096E269807A99", hash_generated_method = "5092F2744009E50C24A10025D45C3888")
    
public void setEGLContextClientVersion(int version) {
        checkRenderThreadState();
        mEGLContextClientVersion = version;
    }

    /**
     * Set the rendering mode. When renderMode is
     * RENDERMODE_CONTINUOUSLY, the renderer is called
     * repeatedly to re-render the scene. When renderMode
     * is RENDERMODE_WHEN_DIRTY, the renderer only rendered when the surface
     * is created, or when {@link #requestRender} is called. Defaults to RENDERMODE_CONTINUOUSLY.
     * <p>
     * Using RENDERMODE_WHEN_DIRTY can improve battery life and overall system performance
     * by allowing the GPU and CPU to idle when the view does not need to be updated.
     * <p>
     * This method can only be called after {@link #setRenderer(Renderer)}
     *
     * @param renderMode one of the RENDERMODE_X constants
     * @see #RENDERMODE_CONTINUOUSLY
     * @see #RENDERMODE_WHEN_DIRTY
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.517 -0500", hash_original_method = "F401D8CE2ED637FA8D91B0F6CF1DA9F1", hash_generated_method = "2D988EB6111E0CA99DC5A816C3D4AB0C")
    
public void setRenderMode(int renderMode) {
        mGLThread.setRenderMode(renderMode);
    }

    /**
     * Get the current rendering mode. May be called
     * from any thread. Must not be called before a renderer has been set.
     * @return the current rendering mode.
     * @see #RENDERMODE_CONTINUOUSLY
     * @see #RENDERMODE_WHEN_DIRTY
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.519 -0500", hash_original_method = "A90B80ACC894289C502B7717EBA7E101", hash_generated_method = "513590CAC4C4ABCB2A8A546DFCEA97AA")
    
public int getRenderMode() {
        return mGLThread.getRenderMode();
    }

    /**
     * Request that the renderer render a frame.
     * This method is typically used when the render mode has been set to
     * {@link #RENDERMODE_WHEN_DIRTY}, so that frames are only rendered on demand.
     * May be called
     * from any thread. Must not be called before a renderer has been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.521 -0500", hash_original_method = "CFFBC35659E0BA943A055CA80830B728", hash_generated_method = "1CE087568ADBD7245540BA0F63AF1A84")
    
public void requestRender() {
        mGLThread.requestRender();
    }

    /**
     * This method is part of the SurfaceHolder.Callback interface, and is
     * not normally called or subclassed by clients of GLSurfaceView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.523 -0500", hash_original_method = "CA97146B18E855EC440A54EE624F6B33", hash_generated_method = "17EC2D9CF7721941F6C98E81D23D0F5D")
    
public void surfaceCreated(SurfaceHolder holder) {
        mGLThread.surfaceCreated();
    }

    /**
     * This method is part of the SurfaceHolder.Callback interface, and is
     * not normally called or subclassed by clients of GLSurfaceView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.526 -0500", hash_original_method = "EA7799B476DE689FE2FFBF9C597A98F4", hash_generated_method = "FA25EF53341F1B47140917DA971CCBC7")
    
public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface will be destroyed when we return
        mGLThread.surfaceDestroyed();
    }

    /**
     * This method is part of the SurfaceHolder.Callback interface, and is
     * not normally called or subclassed by clients of GLSurfaceView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.528 -0500", hash_original_method = "30B95CA79378BAE34CA752354751401C", hash_generated_method = "4497200DEF0BA5323B87E4E7E101B714")
    
public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        mGLThread.onWindowResize(w, h);
    }

    /**
     * Inform the view that the activity is paused. The owner of this view must
     * call this method when the activity is paused. Calling this method will
     * pause the rendering thread.
     * Must not be called before a renderer has been set.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.531 -0500", hash_original_method = "0214E3A2798E907A5B7DAC32A4EC375B", hash_generated_method = "AC35EA4EB7E4739DCF7C0D3E3C4344FE")
    
public void onPause() {
        mGLThread.onPause();
    }

    /**
     * Inform the view that the activity is resumed. The owner of this view must
     * call this method when the activity is resumed. Calling this method will
     * recreate the OpenGL display and resume the rendering
     * thread.
     * Must not be called before a renderer has been set.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.533 -0500", hash_original_method = "FF9EAD78F8E3B3945B5E32D8491EF212", hash_generated_method = "2041042B986B68EBD4503ECF6F9F5FE9")
    
public void onResume() {
        mGLThread.onResume();
    }

    /**
     * Queue a runnable to be run on the GL rendering thread. This can be used
     * to communicate with the Renderer on the rendering thread.
     * Must not be called before a renderer has been set.
     * @param r the runnable to be run on the GL rendering thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.535 -0500", hash_original_method = "BC25E256895D25AFE996AA7797074D1E", hash_generated_method = "76CBE1CA618D7F9DE04FD1115F110264")
    
public void queueEvent(Runnable r) {
        mGLThread.queueEvent(r);
    }

    /**
     * This method is used as part of the View class and is not normally
     * called or subclassed by clients of GLSurfaceView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.538 -0500", hash_original_method = "B3264BCF0DBD2F88E8CFEB8E1785CF85", hash_generated_method = "24B5B91E7E9F71B7C9FF6AC694BFEB5F")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (LOG_ATTACH_DETACH) {
            Log.d(TAG, "onAttachedToWindow reattach =" + mDetached);
        }
        if (mDetached && (mRenderer != null)) {
            int renderMode = RENDERMODE_CONTINUOUSLY;
            if (mGLThread != null) {
                renderMode = mGLThread.getRenderMode();
            }
            mGLThread = new GLThread(mRenderer);
            if (renderMode != RENDERMODE_CONTINUOUSLY) {
                mGLThread.setRenderMode(renderMode);
            }
            mGLThread.start();
        }
        mDetached = false;
    }

    /**
     * This method is used as part of the View class and is not normally
     * called or subclassed by clients of GLSurfaceView.
     * Must not be called before a renderer has been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.541 -0500", hash_original_method = "783D43AC66E879A98C2CBDD1B113996E", hash_generated_method = "E952790FDFDFFFD1534A80BB986A0716")
    
@Override
    protected void onDetachedFromWindow() {
        if (LOG_ATTACH_DETACH) {
            Log.d(TAG, "onDetachedFromWindow");
        }
        if (mGLThread != null) {
            mGLThread.requestExitAndWait();
        }
        mDetached = true;
        super.onDetachedFromWindow();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.783 -0500", hash_original_method = "D0DDFF21B511089DC22A6A0EC54D9B69", hash_generated_method = "B1E3905F5083642D143059CB46FC0A14")
    
private void checkRenderThreadState() {
        if (mGLThread != null) {
            throw new IllegalStateException(
                    "setRenderer has already been called for this instance.");
        }
    }
}

