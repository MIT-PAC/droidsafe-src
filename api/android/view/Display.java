package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;
import android.content.res.CompatibilityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.DisplayMetrics;

import droidsafe.helpers.DSUtils;

public class Display {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int getDisplayCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086194105;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.307 -0500", hash_original_method = "EAA8F8A14B9F77AE841E750047985ABA", hash_generated_method = "E85C3B1E8EB8D4474C2CFD73095C7800")
    
static IWindowManager getWindowManager() {
        synchronized (sStaticInit) {
            if (sWindowManager == null) {
                sWindowManager = IWindowManager.Stub.asInterface(
                        ServiceManager.getService("window"));
            }
            return sWindowManager;
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClassInit() {
    }

    /**
     * Returns a display object which uses the metric's width/height instead.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.346 -0500", hash_original_method = "0B13ECC3F100D49D8BCFE6A30F50129A", hash_generated_method = "EF80024A00D7E526068FD0AA7374CDCF")
    
public static Display createCompatibleDisplay(int displayId, CompatibilityInfoHolder compat) {
        return new Display(displayId, compat);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.236 -0500", hash_original_field = "4D90A9FA3052D3EDC22DC1D54D37C400", hash_generated_field = "223CCD915B07E407EFEFA564FDB2DC20")

    static final String TAG = "Display";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.238 -0500", hash_original_field = "0BEA5D8ECCFFBC6DCB7190B03E168DA0", hash_generated_field = "329D6DE5FD992832882D33C274C4BB6D")

    static final boolean DEBUG_DISPLAY_SIZE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.241 -0500", hash_original_field = "998D754C5B2258E250D60237967BBA0B", hash_generated_field = "DE0938F6522CA6DA05C305B8778F7B69")

    public static final int DEFAULT_DISPLAY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.339 -0500", hash_original_field = "5DD5AFB956F82E56442C6720CD888418", hash_generated_field = "3688F7B3534C6CD8F91C89CB5E40FE68")

    private static final Object sStaticInit = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.342 -0500", hash_original_field = "FF0D215A6350FF708FCE993AD427F9D1", hash_generated_field = "815F7815DE01033DD7A51FFFBC42763D")

    private static boolean sInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.344 -0500", hash_original_field = "F8394A0A868CD62A3B859D8862E95ED4", hash_generated_field = "9FFB1E54F186971CA192F7BE25683B37")

    private static IWindowManager sWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.317 -0500", hash_original_field = "5EAC126C193FC41ACB184C1D10F2C250", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

    private  CompatibilityInfoHolder mCompatibilityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.319 -0500", hash_original_field = "32484B09E23EA969F843AD1B3AF0B883", hash_generated_field = "C3D33931672C9997D02DE67B6B8FC170")

    private  int   mDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.321 -0500", hash_original_field = "2C810B4E3BA1B3CF1D70CD3A6C6C42DA", hash_generated_field = "A3BE31732297BF4F97F73715693F8671")

    private int         mPixelFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.323 -0500", hash_original_field = "1B397F74F922019F2121302F8A04D632", hash_generated_field = "3B186DE7AE43652AB2C26B4DC04F9761")

    private float       mRefreshRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.325 -0500", hash_original_field = "B5DC68677E93FA7FF1DA60AF3938C510", hash_generated_field = "B5DC68677E93FA7FF1DA60AF3938C510")
 float   mDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.327 -0500", hash_original_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A", hash_generated_field = "B2E7A1F0CAE99DBD9D3D65E29165C84A")
 float   mDpiX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.329 -0500", hash_original_field = "BC1908C6E1D0054138584C2D01126D3C", hash_generated_field = "BC1908C6E1D0054138584C2D01126D3C")
 float   mDpiY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.332 -0500", hash_original_field = "C2BAC675E69529ADCFDBC8F23A87249F", hash_generated_field = "538425559D2BF0F635F9288868FC8D78")
    
    private final Point mTmpPoint = new Point();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.334 -0500", hash_original_field = "1D8990DD0AE47C2EF8F82812E1AB1108", hash_generated_field = "3C9E4AC56655D3050A4B4F36D2BBE1DC")

    private final DisplayMetrics mTmpMetrics = new DisplayMetrics();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.337 -0500", hash_original_field = "5CE7CF2F6BE1854E13EB1C178B39AB19", hash_generated_field = "362C6D41A17812DA983C811277AF00AE")

    private float mLastGetTime;

/**
 * Display flag: Indicates that the display supports compositing content
 * that is stored in protected graphics buffers.
 * <p>
 * If this flag is set then the display device supports compositing protected buffers.
 * </p><p>
 * If this flag is not set then the display device may not support compositing
 * protected buffers; the user may see a blank region on the screen instead of
 * the protected content.
 * </p><p>
 * Secure (DRM) video decoders may allocate protected graphics buffers to request that
 * a hardware-protected path be provided between the video decoder and the external
 * display sink.  If a hardware-protected path is not available, then content stored
 * in protected graphics buffers may not be composited.
 * </p><p>
 * An application can use the absence of this flag as a hint that it should not use protected
 * buffers for this display because the content may not be visible.  For example,
 * if the flag is not set then the application may choose not to show content on this
 * display, show an informative error message, select an alternate content stream
 * or adopt a different strategy for decoding content that does not rely on
 * protected buffers.
 * </p>
 *
 * @see #getFlags
 */
public static final int FLAG_SUPPORTS_PROTECTED_BUFFERS = 1 << 0;

/**
 * Display flag: Indicates that the display has a secure video output and
 * supports compositing secure surfaces.
 * <p>
 * If this flag is set then the display device has a secure video output
 * and is capable of showing secure surfaces.  It may also be capable of
 * showing {@link #FLAG_SUPPORTS_PROTECTED_BUFFERS protected buffers}.
 * </p><p>
 * If this flag is not set then the display device may not have a secure video
 * output; the user may see a blank region on the screen instead of
 * the contents of secure surfaces or protected buffers.
 * </p><p>
 * Secure surfaces are used to prevent content rendered into those surfaces
 * by applications from appearing in screenshots or from being viewed
 * on non-secure displays.  Protected buffers are used by secure video decoders
 * for a similar purpose.
 * </p><p>
 * An application creates a window with a secure surface by specifying the
 * {@link WindowManager.LayoutParams#FLAG_SECURE} window flag.
 * Likewise, an application creates a {@link SurfaceView} with a secure surface
 * by calling {@link SurfaceView#setSecure} before attaching the secure view to
 * its containing window.
 * </p><p>
 * An application can use the absence of this flag as a hint that it should not create
 * secure surfaces or protected buffers on this display because the content may
 * not be visible.  For example, if the flag is not set then the application may
 * choose not to show content on this display, show an informative error message,
 * select an alternate content stream or adopt a different strategy for decoding
 * content that does not rely on secure surfaces or protected buffers.
 * </p>
 *
 * @see #getFlags
 */
public static final int FLAG_SECURE = 1 << 1;

/**
 * Display flag: Indicates that the display is private.  Only the application that
 * owns the display can create windows on it.
 *
 * @see #getFlags
 */
public static final int FLAG_PRIVATE = 1 << 2;

/**
 * Display flag: Indicates that the display is a presentation display.
 * <p>
 * This flag identifies secondary displays that are suitable for
 * use as presentation displays such as HDMI or Wireless displays.  Applications
 * may automatically project their content to presentation displays to provide
 * richer second screen experiences.
 * </p>
 *
 * @see #getFlags
 */
public static final int FLAG_PRESENTATION = 1 << 3;

/**
 * Display type: Unknown display type.
 * @hide
 */
public static final int TYPE_UNKNOWN = 0;

/**
 * Display type: Built-in display.
 * @hide
 */
public static final int TYPE_BUILT_IN = 1;

/**
 * Display type: HDMI display.
 * @hide
 */
public static final int TYPE_HDMI = 2;

/**
 * Display type: WiFi display.
 * @hide
 */
public static final int TYPE_WIFI = 3;

/**
 * Display type: Overlay display.
 * @hide
 */
public static final int TYPE_OVERLAY = 4;

/**
 * Display type: Virtual display.
 * @hide
 */
public static final int TYPE_VIRTUAL = 5;

    /**
     * Use {@link android.view.WindowManager#getDefaultDisplay()
     * WindowManager.getDefaultDisplay()} to create a Display object.
     * Display gives you access to some information about a particular display
     * connected to the device.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.243 -0500", hash_original_method = "C9519A69B693719AC1491BF9F92C5C8E", hash_generated_method = "482C09FFFDB57BC8D0C88DE0A02382B2")
    
Display(int display, CompatibilityInfoHolder compatInfo) {
        // initalize the statics when this class is first instansiated. This is
        // done here instead of in the static block because Zygote
        synchronized (sStaticInit) {
            if (!sInitialized) {
                nativeClassInit();
                sInitialized = true;
            }
        }
        mCompatibilityInfo = compatInfo != null ? compatInfo : new CompatibilityInfoHolder();
        mDisplay = display;
        init(display);
    }
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public Display(DSOnlyType dontcare) {
        this(DSUtils.FAKE_INT, null);
    }

    /**
     * Returns the index of this display.  This is currently undefined; do
     * not use.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.246 -0500", hash_original_method = "107F25776C4AB2DB96852EDD25D31975", hash_generated_method = "1C8EF4CE2343D615351A4D0090FBFC7B")
    
public int getDisplayId() {
        return mDisplay;
    }
    
    /**
     * Gets the size of the display, in pixels.
     * <p>
     * Note that this value should <em>not</em> be used for computing layouts,
     * since a device will typically have screen decoration (such as a status bar)
     * along the edges of the display that reduce the amount of application
     * space available from the size returned here.  Layouts should instead use
     * the window size.
     * </p><p>
     * The size is adjusted based on the current rotation of the display.
     * </p><p>
     * The size returned by this method does not necessarily represent the
     * actual raw size (native resolution) of the display.  The returned size may
     * be adjusted to exclude certain system decor elements that are always visible.
     * It may also be scaled to provide compatibility with older applications that
     * were originally designed for smaller displays.
     * </p>
     *
     * @param outSize A {@link Point} object to receive the size information.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.252 -0500", hash_original_method = "17F24EABE37BDCE44DDE55CD705BD7B9", hash_generated_method = "BC8EF3BA048941B41AD13CC2332CDB1B")
    
public void getSize(Point outSize) {
        getSizeInternal(outSize, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.255 -0500", hash_original_method = "79B8C4439194701109AF7AA6129A555C", hash_generated_method = "50C67704465B26566DAA72B1350433D7")
    
private void getSizeInternal(Point outSize, boolean doCompat) {
        try {
            IWindowManager wm = getWindowManager();
            if (wm != null) {
                wm.getDisplaySize(outSize);
                CompatibilityInfo ci;
                if (doCompat && (ci=mCompatibilityInfo.getIfNeeded()) != null) {
                    synchronized (mTmpMetrics) {
                        mTmpMetrics.noncompatWidthPixels = outSize.x;
                        mTmpMetrics.noncompatHeightPixels = outSize.y;
                        mTmpMetrics.density = mDensity;
                        ci.applyToDisplayMetrics(mTmpMetrics);
                        outSize.x = mTmpMetrics.widthPixels;
                        outSize.y = mTmpMetrics.heightPixels;
                    }
                }
            } else {
                // This is just for boot-strapping, initializing the
                // system process before the window manager is up.
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            }
            if (false) {
                RuntimeException here = new RuntimeException("here");
                here.fillInStackTrace();
                Slog.v(TAG, "Returning display size: " + outSize, here);
            }
            if (DEBUG_DISPLAY_SIZE && doCompat) Slog.v(
                    TAG, "Returning display size: " + outSize);
        } catch (RemoteException e) {
            Slog.w("Display", "Unable to get display size", e);
        }
    }
    
    /**
     * Gets the size of the display as a rectangle, in pixels.
     *
     * @param outSize A {@link Rect} object to receive the size information.
     * @see #getSize(Point)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.258 -0500", hash_original_method = "92D5B5EBFB706321BDD6B906C6DF5945", hash_generated_method = "555AAF8F81735CF11D4BE1BFF3CEFA78")
    
public void getRectSize(Rect outSize) {
        synchronized (mTmpPoint) {
            getSizeInternal(mTmpPoint, true);
            outSize.set(0, 0, mTmpPoint.x, mTmpPoint.y);
        }
    }

    /**
     * Return the maximum screen size dimension that will happen.  This is
     * mostly for wallpapers.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.260 -0500", hash_original_method = "404C4EF6FA3AD3B9975B754C597D6C0E", hash_generated_method = "A34A4080F73EE8B2B7760D3F3BCC074C")
    
public int getMaximumSizeDimension() {
        try {
            IWindowManager wm = getWindowManager();
            return wm.getMaximumSizeDimension();
        } catch (RemoteException e) {
            Slog.w("Display", "Unable to get display maximum size dimension", e);
            return 0;
        }
    }

    /**
     * @deprecated Use {@link #getSize(Point)} instead.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.263 -0500", hash_original_method = "2F7FD849240377F4AD58DDE704C1CFAA", hash_generated_method = "BA73A9C9C8FCBA8528451F8212BABE9D")
    
@Deprecated
    public int getWidth() {
        synchronized (mTmpPoint) {
            long now = SystemClock.uptimeMillis();
            if (now > (mLastGetTime+20)) {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            }
            return mTmpPoint.x;
        }
    }

    /**
     * @deprecated Use {@link #getSize(Point)} instead.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.265 -0500", hash_original_method = "60FBCC92DE8F9EC729264DB15D46C4E8", hash_generated_method = "5643E07DE3A1DF429C96D173AA292F28")
    
@Deprecated
    public int getHeight() {
        synchronized (mTmpPoint) {
            long now = SystemClock.uptimeMillis();
            if (now > (mLastGetTime+20)) {
                getSizeInternal(mTmpPoint, true);
                mLastGetTime = now;
            }
            return mTmpPoint.y;
        }
    }

    /**
     * Gets the real size of the display without subtracting any window decor or
     * applying any compatibility scale factors.
     * <p>
     * The real size may be smaller than the raw size when the window manager
     * is emulating a smaller display (using adb shell am display-size).
     * </p><p>
     * The size is adjusted based on the current rotation of the display.
     * </p>
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.268 -0500", hash_original_method = "B1AC967D724C688D478E66D81CB079DE", hash_generated_method = "29CF76A3DE88DB7B77389FBE638C4BF6")
    
public void getRealSize(Point outSize) {
        try {
            IWindowManager wm = getWindowManager();
            if (wm != null) {
                wm.getRealDisplaySize(outSize);
            } else {
                // This is just for boot-strapping, initializing the
                // system process before the window manager is up.
                outSize.x = getRawWidth();
                outSize.y = getRawHeight();
            }
            if (DEBUG_DISPLAY_SIZE) Slog.v(
                    TAG, "Returning real display size: " + outSize);
        } catch (RemoteException e) {
            Slog.w("Display", "Unable to get real display size", e);
        }
    }

    /**
     * Gets the raw width of the display, in pixels.
     * <p>
     * The size is adjusted based on the current rotation of the display.
     * </p>
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.270 -0500", hash_original_method = "1DDDF7191F0FF0F7297CF97C1DA4B799", hash_generated_method = "D5F3350F9FBA6FBCEEDB8360A5823864")
    
public int getRawWidth() {
        int w = getRawWidthNative();
        if (DEBUG_DISPLAY_SIZE) Slog.v(
                TAG, "Returning raw display width: " + w);
        return w;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.275 -0500", hash_original_method = "F4A84F8F2FFCAD78922F38438709A2E6", hash_generated_method = "AD61DDB1335568D17DCD03533EBA08E6")
    
    private int getRawWidthNative(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Gets the raw height of the display, in pixels.
     * <p>
     * The size is adjusted based on the current rotation of the display.
     * </p>
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.277 -0500", hash_original_method = "3ACB8E9BEACC517B317C29EAF3634629", hash_generated_method = "AD1DD2BAFB4CC93C4CAEC065F4E6113F")
    
public int getRawHeight() {
        int h = getRawHeightNative();
        if (DEBUG_DISPLAY_SIZE) Slog.v(
                TAG, "Returning raw display height: " + h);
        return h;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.281 -0500", hash_original_method = "0BBCECD524BDD54CA608342D94B23905", hash_generated_method = "48A3CC71B454471523A765603E8F2113")
    
    private int getRawHeightNative(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    /**
     * Returns the rotation of the screen from its "natural" orientation.
     * The returned value may be {@link Surface#ROTATION_0 Surface.ROTATION_0}
     * (no rotation), {@link Surface#ROTATION_90 Surface.ROTATION_90},
     * {@link Surface#ROTATION_180 Surface.ROTATION_180}, or
     * {@link Surface#ROTATION_270 Surface.ROTATION_270}.  For
     * example, if a device has a naturally tall screen, and the user has
     * turned it on its side to go into a landscape orientation, the value
     * returned here may be either {@link Surface#ROTATION_90 Surface.ROTATION_90}
     * or {@link Surface#ROTATION_270 Surface.ROTATION_270} depending on
     * the direction it was turned.  The angle is the rotation of the drawn
     * graphics on the screen, which is the opposite direction of the physical
     * rotation of the device.  For example, if the device is rotated 90
     * degrees counter-clockwise, to compensate rendering will be rotated by
     * 90 degrees clockwise and thus the returned value here will be
     * {@link Surface#ROTATION_90 Surface.ROTATION_90}.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.283 -0500", hash_original_method = "0627945D4A6FEA5F8EF1880CC4DB952B", hash_generated_method = "9F82DC778CFEFA13C888B6C1F98A1C59")
    
public int getRotation() {
        return getOrientation();
    }
    
    /**
     * @deprecated use {@link #getRotation}
     * @return orientation of this display.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.287 -0500", hash_original_method = "6E125A4EC20477CEC647612C37C0ECFE", hash_generated_method = "579A0203D6236D81664B553F26B2711E")
    
    @Deprecated
    public int getOrientation(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Return the native pixel format of the display.  The returned value
     * may be one of the constants int {@link android.graphics.PixelFormat}.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.289 -0500", hash_original_method = "441029F9FCB9AB0438A81D4AE48234F0", hash_generated_method = "113D6BD2144B8B471B058272F811664F")
    
public int getPixelFormat() {
        return mPixelFormat;
    }
    
    /**
     * Return the refresh rate of this display in frames per second.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.292 -0500", hash_original_method = "79009E426290AE6AA1C61D7B07738692", hash_generated_method = "915A0C2921F8E445C8BBB81C6178EFF8")
    
public float getRefreshRate() {
        return mRefreshRate;
    }
    
    /**
     * Gets display metrics that describe the size and density of this display.
     * <p>
     * The size is adjusted based on the current rotation of the display.
     * </p><p>
     * The size returned by this method does not necessarily represent the
     * actual raw size (native resolution) of the display.  The returned size may
     * be adjusted to exclude certain system decor elements that are always visible.
     * It may also be scaled to provide compatibility with older applications that
     * were originally designed for smaller displays.
     * </p>
     *
     * @param outMetrics A {@link DisplayMetrics} object to receive the metrics.
     */
    @DSComment("only for display view")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.294 -0500", hash_original_method = "81980A722EF93A85BC60465488AFFEA3", hash_generated_method = "127EAF7824B13820ADCF3A73223C6D4F")
    
public void getMetrics(DisplayMetrics outMetrics) {
        synchronized (mTmpPoint) {
            getSizeInternal(mTmpPoint, false);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        }

        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        if (ci != null) {
            ci.applyToDisplayMetrics(outMetrics);
        }

        if (DEBUG_DISPLAY_SIZE) Slog.v(TAG, "Returning DisplayMetrics: "
                + outMetrics.widthPixels + "x" + outMetrics.heightPixels
                + " " + outMetrics.density);
    }

    /**
     * Gets display metrics based on the real size of this display.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.296 -0500", hash_original_method = "EF32DD6952DB89EBAA6A7EFF5769279F", hash_generated_method = "E737A504C65C9004D2AE668D6E1E2856")
    
public void getRealMetrics(DisplayMetrics outMetrics) {
        synchronized (mTmpPoint) {
            getRealSize(mTmpPoint);
            getMetricsWithSize(outMetrics, mTmpPoint.x, mTmpPoint.y);
        }
    }

    /**
     * If the display is mirrored to an external HDMI display, returns the
     * width of that display.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.299 -0500", hash_original_method = "FDECD188634E4AD18CD2905FF365772D", hash_generated_method = "F7A6FB561BE3D49C5DEF359505C6D727")
    
public int getRawExternalWidth() {
        return 1280;
    }

    /**
     * If the display is mirrored to an external HDMI display, returns the
     * height of that display.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.301 -0500", hash_original_method = "376AC17F1270BAB2AB31395345202FD2", hash_generated_method = "AC8AE7757D41023D900EFB2D71052C04")
    
public int getRawExternalHeight() {
        return 720;
    }

    /**
     * Gets display metrics based on an explicit assumed display size.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.304 -0500", hash_original_method = "9D75A337ADB9CB99DE08523595E3FF43", hash_generated_method = "193166C12048EB9FDF36A519520DCDCC")
    
public void getMetricsWithSize(DisplayMetrics outMetrics,
            int width, int height) {
        outMetrics.densityDpi   = (int)((mDensity*DisplayMetrics.DENSITY_DEFAULT)+.5f);

        outMetrics.noncompatWidthPixels  = outMetrics.widthPixels = width;
        outMetrics.noncompatHeightPixels = outMetrics.heightPixels = height;

        outMetrics.density = outMetrics.noncompatDensity = mDensity;
        outMetrics.scaledDensity = outMetrics.noncompatScaledDensity = outMetrics.density;
        outMetrics.xdpi = outMetrics.noncompatXdpi = mDpiX;
        outMetrics.ydpi = outMetrics.noncompatYdpi = mDpiY;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.314 -0500", hash_original_method = "CE3A43F20C9E9D8C85E043AD25A6B3E9", hash_generated_method = "665C622029752F1221564D280B11E5B0")
    
    private void init(int display){
    	//Formerly a native method
    	addTaint(display);
    }

    public static boolean hasAccess(int uid, int flags, int ownerUid) {
        // TODO Auto-generated method stub
        return false;
    }

}

