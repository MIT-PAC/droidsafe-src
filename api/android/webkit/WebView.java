package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

import junit.framework.Assert;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Proxy;
import android.net.ProxyProperties;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.HardwareCanvas;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebTextView.AutoCompleteAdapter;
import android.webkit.WebViewCore.DrawData;
import android.webkit.WebViewCore.EventHub;
import android.webkit.WebViewCore.TouchEventData;
import android.webkit.WebViewCore.TouchHighlightData;
import android.widget.AbsoluteLayout;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.OverScroller;
import android.widget.Toast;

public class WebView extends AbsoluteLayout implements ViewTreeObserver.OnGlobalFocusChangeListener, ViewGroup.OnHierarchyChangeListener {

    /*
     * @param context This method expects this to be a valid context
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.399 -0500", hash_original_method = "9DD1CC09113D51859A2A4670DD02C2DF", hash_generated_method = "FCDA953C8433D77A64389A2C0E5FD53F")
    
private static synchronized void setupProxyListener(Context context) {
        if (sProxyReceiver != null || sNotificationsEnabled == false) {
            return;
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Proxy.PROXY_CHANGE_ACTION);
        sProxyReceiver = new ProxyReceiver();
        Intent currentProxy = context.getApplicationContext().registerReceiver(
                sProxyReceiver, filter);
        if (currentProxy != null) {
            handleProxyBroadcast(currentProxy);
        }
    }

    /*
     * @param context This method expects this to be a valid context
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.402 -0500", hash_original_method = "4253223359E0A55D0B7478B1E46B70E0", hash_generated_method = "BE62E962D780E3FF30B32BD79E8A1FC0")
    
private static synchronized void disableProxyListener(Context context) {
        if (sProxyReceiver == null)
            return;

        context.getApplicationContext().unregisterReceiver(sProxyReceiver);
        sProxyReceiver = null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.404 -0500", hash_original_method = "95792EAC29A9A8AB6982385F0DB82F6E", hash_generated_method = "858615C39CA8948C325BEF6AC3361B7B")
    
private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyProperties = (ProxyProperties)intent.getExtra(Proxy.EXTRA_PROXY_INFO);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, null);
            return;
        }
        WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, proxyProperties);
    }

    /**
     * Enables platform notifications of data state and proxy changes.
     * Notifications are enabled by default.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.521 -0500", hash_original_method = "D90791382B998754300C46B222220008", hash_generated_method = "2493124BC7814D1E0DD5A823972892AE")
    
@Deprecated
    public static void enablePlatformNotifications() {
        checkThread();
        synchronized (WebView.class) {
            Network.enablePlatformNotifications();
            sNotificationsEnabled = true;
            Context context = JniUtil.getContext();
            if (context != null)
                setupProxyListener(context);
        }
    }

    /**
     * Disables platform notifications of data state and proxy changes.
     * Notifications are enabled by default.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.523 -0500", hash_original_method = "EDAF97142100A2828612566C3AE09FEC", hash_generated_method = "9182EE3245CCF64B9549F702F9A17C31")
    
@Deprecated
    public static void disablePlatformNotifications() {
        checkThread();
        synchronized (WebView.class) {
            Network.disablePlatformNotifications();
            sNotificationsEnabled = false;
            Context context = JniUtil.getContext();
            if (context != null)
                disableProxyListener(context);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.671 -0500", hash_original_method = "9B5A3D11C56688EF80D0415919DF486F", hash_generated_method = "A52C1258BA0B977EADB943AD12D7B4E4")
    
static int pinLoc(int x, int viewMax, int docMax) {
//        Log.d(LOGTAG, "-- pinLoc " + x + " " + viewMax + " " + docMax);
        if (docMax < viewMax) {   // the doc has room on the sides for "blank"
            // pin the short document to the top/left of the screen
            x = 0;
//            Log.d(LOGTAG, "--- center " + x);
        } else if (x < 0) {
            x = 0;
//            Log.d(LOGTAG, "--- zero");
        } else if (x + viewMax > docMax) {
            x = docMax - viewMax;
//            Log.d(LOGTAG, "--- pin " + x);
        }
        return x;
    }

    /**
     * Return the first substring consisting of the address of a physical
     * location. Currently, only addresses in the United States are detected,
     * and consist of:
     * - a house number
     * - a street name
     * - a street type (Road, Circle, etc), either spelled out or abbreviated
     * - a city name
     * - a state or territory, either spelled out or two-letter abbr.
     * - an optional 5 digit or 9 digit zip code.
     *
     * All names must be correctly capitalized, and the zip code, if present,
     * must be valid for the state. The street type must be a standard USPS
     * spelling or abbreviation. The state or territory must also be spelled
     * or abbreviated using USPS standards. The house number may not exceed
     * five digits.
     * @param addr The string to search for addresses.
     *
     * @return the address, or if no address is found, return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.855 -0500", hash_original_method = "4708F5F42FC70D135A9D2E41E9763CDD", hash_generated_method = "50EEB8028068C97BB9C81E4800D50473")
    
public static String findAddress(String addr) {
        checkThread();
        return findAddress(addr, false);
    }

    /**
     * @hide
     * Return the first substring consisting of the address of a physical
     * location. Currently, only addresses in the United States are detected,
     * and consist of:
     * - a house number
     * - a street name
     * - a street type (Road, Circle, etc), either spelled out or abbreviated
     * - a city name
     * - a state or territory, either spelled out or two-letter abbr.
     * - an optional 5 digit or 9 digit zip code.
     *
     * Names are optionally capitalized, and the zip code, if present,
     * must be valid for the state. The street type must be a standard USPS
     * spelling or abbreviation. The state or territory must also be spelled
     * or abbreviated using USPS standards. The house number may not exceed
     * five digits.
     * @param addr The string to search for addresses.
     * @param caseInsensitive addr Set to true to make search ignore case.
     *
     * @return the address, or if no address is found, return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.857 -0500", hash_original_method = "2B68EFBFE26D95B828D150F41B7C4652", hash_generated_method = "D1AAE93FFF1895592B5055D3FCA0C726")
    
public static String findAddress(String addr, boolean caseInsensitive) {
        return WebViewCore.nativeFindAddress(addr, caseInsensitive);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.874 -0500", hash_original_method = "6411BF62B571DFB81CA7A8EE4DFAA604", hash_generated_method = "EA6F917BB7DA2CCB33B3F202E2BDAD62")
    
private static int computeDuration(int dx, int dy) {
        int distance = Math.max(Math.abs(dx), Math.abs(dy));
        int duration = distance * 1000 / STD_SPEED;
        return Math.min(duration, MAX_DURATION);
    }

   /**
    * Return the list of currently loaded plugins.
    * @return The list of currently loaded plugins.
    *
    * @hide
    * @deprecated This was used for Gears, which has been deprecated.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.936 -0500", hash_original_method = "DCC8025B0D65015CFA8097991E635157", hash_generated_method = "1ADD4122EC3C36802F56A241F84FF6AC")
    
@Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.681 -0500", hash_original_method = "943B62368DE741C255F640DAAE3693A1", hash_generated_method = "948C04E76A6FC62A78AB33C2005A1A44")
    
private static void checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Throwable throwable = new Throwable(
                    "Warning: A WebView method was called on thread '" +
                    Thread.currentThread().getName() + "'. " +
                    "All WebView methods must be called on the UI thread. " +
                    "Future versions of WebView may not support use on other threads.");
            Log.w(LOGTAG, Log.getStackTraceString(throwable));
            StrictMode.onWebViewMethodCalledOnWrongThread(throwable);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeOnTrimMemory(int level) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetPauseDrawing(int instance, boolean pause) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.807 -0500", hash_original_field = "E2BFD1A81A3612483C464EF0BFEA4A9A", hash_generated_field = "E443A86E3B234F65E60B42BE78CD50FA")

    // the screen all-the-time. Good for profiling our drawing code
    static private final boolean AUTO_REDRAW_HACK = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.813 -0500", hash_original_field = "93D99CDED393B48383B191F5FB29A7B0", hash_generated_field = "3DDB64784E4CB9C9D138ACE428331F35")

    static final String LOGTAG = "webview";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.893 -0500", hash_original_field = "AA7848649BDB090157B9326CB2249C17", hash_generated_field = "18A327C2449F72346CC969AA861F8DED")

    private static final int TOUCH_SENT_INTERVAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.913 -0500", hash_original_field = "53DD0AA05606A9C60D411C28AF257341", hash_generated_field = "FBD3D68B9D3F34F99ACBD597C3ED75C7")

    // MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION times of the previous velocity
    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.917 -0500", hash_original_field = "7919DC477B91408F03EE5FCE0C8825E9", hash_generated_field = "0E03AEB798357E5423FA6ECC32D0ACBF")

    private static final int TOUCH_INIT_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.919 -0500", hash_original_field = "CD25A86F5BE660C3F0E7036501F2BF74", hash_generated_field = "1E0980F04B2FCD375BEABB7363B8FF68")

    private static final int TOUCH_DRAG_START_MODE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.922 -0500", hash_original_field = "B7A582785E15C748735CB81EEEF92F0A", hash_generated_field = "83AE715CF0D0671A947C87A1241F0CA1")

    private static final int TOUCH_DRAG_MODE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.924 -0500", hash_original_field = "5A9ECB6727AA3F6E9B89E44262BEDD2D", hash_generated_field = "0CF4A98B15B6BE2EA0162F1E9D30FC12")

    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.926 -0500", hash_original_field = "C6B4BF551352B049ADD4C4D5A9643834", hash_generated_field = "FECEEB0AF4271E899239BD7E9D392EBF")

    private static final int TOUCH_SHORTPRESS_MODE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.928 -0500", hash_original_field = "62AF53C6C123E69B057C3498B2658387", hash_generated_field = "64F3E1DC401E3A13C6A5A084547AFA2E")

    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.931 -0500", hash_original_field = "C84CEADF1EBDC2CDF6CD347D6DD65026", hash_generated_field = "A9451B2FBF47965DCA0749E0900C1CA7")

    private static final int TOUCH_DONE_MODE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.934 -0500", hash_original_field = "CA13B6EEE18632137B0C96B955959B18", hash_generated_field = "D21FFBF08857043ABC578F1B36B815A5")

    private static final int TOUCH_PINCH_DRAG = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.936 -0500", hash_original_field = "54D758D8B2F857557A8CAD6417221AF8", hash_generated_field = "06D188067A2E01E8C0722603047A2705")

    private static final int TOUCH_DRAG_LAYER_MODE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.940 -0500", hash_original_field = "8C33ACF997FB2E4AA5D6F46978B99F52", hash_generated_field = "812A15AD3C1211902A2550EEFF3EB664")

    // mForwardTouchEvents. If WebCore wants all the touch events, it says yes
    // for touch down. Otherwise UI will wait for the answer of the first
    // confirmed move before taking over the control.
    private static final int PREVENT_DEFAULT_NO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.943 -0500", hash_original_field = "805B1B2321F3910EADE545E7A7059EFA", hash_generated_field = "DE6AB7A95401C72A4B1DD8181041E794")

    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.945 -0500", hash_original_field = "F8908ED116643A0494AF586FCABA9B53", hash_generated_field = "ED8840ED75A291E8054A7C1BB5671FBA")

    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.948 -0500", hash_original_field = "39EB208A03518778213083128B56FCD9", hash_generated_field = "F777B90C70D246657A3C6B01F65E2838")

    private static final int PREVENT_DEFAULT_YES = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.951 -0500", hash_original_field = "B691FA654415461E2CF04D78773661F0", hash_generated_field = "4874F2F37BC83962E22DDD1E2023B942")

    private static final int PREVENT_DEFAULT_IGNORE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.981 -0500", hash_original_field = "1B2B7E7F41E10752D90E85A03507DCA8", hash_generated_field = "1961D425D05D27800F54CE2D623137FC")

    // But system time out is 100ms, which is too short for the browser.
    // In the browser, if it switches out of tap too soon, jump tap won't work.
    // In addition, a double tap on a trackpad will always have a duration of
    // 300ms, so this value must be at least that (otherwise we will timeout the
    // first tap and convert it to a long press).
    private static final int TAP_TIMEOUT = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.984 -0500", hash_original_field = "56F6D4FFE801561A738EBB85BB69D1F2", hash_generated_field = "B7DACB3BEFE083B10AD7062DF7B03AAA")

    // But system time out is 500ms, which is too short for the browser.
    // With a short timeout, it's difficult to treat trigger a short press.
    private static final int LONG_PRESS_TIMEOUT = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.986 -0500", hash_original_field = "9305D6C83E5A59741F0D700240461FFA", hash_generated_field = "37FBC39ACE1B888AF1A1226526A7D957")

    private static final int MIN_FLING_TIME = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.988 -0500", hash_original_field = "C97A662B579BAB3134685053FCF2894E", hash_generated_field = "A558F8CE44ACC3F82805560DA4A932C7")

    private static final int MOTIONLESS_TIME = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.991 -0500", hash_original_field = "8447A20A22B82F47D05CAA0D2D1FF6BF", hash_generated_field = "DF838DD1671374869D8B9F96CC852954")

    // pages with the space bar, in pixels.
    private static final int PAGE_SCROLL_OVERLAP = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.012 -0500", hash_original_field = "E0B28E2F63709C2A68FA809816B09B36", hash_generated_field = "3BEED6FF1988D10692876EC511DA2714")

    // time than large distances, but we cap the duration, so that very large
    // distances won't take too long to get there.
    private static final int STD_SPEED = 480;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.014 -0500", hash_original_field = "616BCD0C3CC8341AE5CD09227359C198", hash_generated_field = "0C7227F382D1803B357DEDCD01F5746F")

    // time for the longest scroll animation
    private static final int MAX_DURATION = 750;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.017 -0500", hash_original_field = "9E9FCE57CCF57FCEE6C94999472C2F59", hash_generated_field = "02D03CB624675F55BDCD5E41671FD647")

    private static final int SLIDE_TITLE_DURATION = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.024 -0500", hash_original_field = "F5D2F005957C81C275C8CD655E0C87A9", hash_generated_field = "E8C9A528EEF567C1C6F71F0F8BDD0AD6")

    private static Paint mOverScrollBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.026 -0500", hash_original_field = "57303995D78F84714FD4C3027646F821", hash_generated_field = "9CFFB41CE7C3DFBAB932F7E5B2B5A059")

    private static Paint mOverScrollBorder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.030 -0500", hash_original_field = "DCE8752DC456CA49938E2FFD37CB9184", hash_generated_field = "BF51A867D871DC62C484459645C786EE")

    private static final int MOTIONLESS_FALSE           = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.033 -0500", hash_original_field = "4E4F62C872B2BEB06A96E05791986D3B", hash_generated_field = "221783611900669BBF31AB8C03851102")

    private static final int MOTIONLESS_PENDING         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.035 -0500", hash_original_field = "0768A2B940149F005AA3B12A7E6AE95C", hash_generated_field = "1D92A2861F83A93813AB357DE4223391")

    private static final int MOTIONLESS_TRUE            = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.037 -0500", hash_original_field = "0754D701DF2728B2CAEC5A8F25D3CA54", hash_generated_field = "C6E1D10F9F9872B9A144832957CA340B")

    private static final int MOTIONLESS_IGNORE          = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.046 -0500", hash_original_field = "FDEA5BC550463273ECA809BD733F1CD4", hash_generated_field = "56E82801D034FBA81618FDC04F23AD89")

    static final boolean USE_JAVA_TEXT_SELECTION = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.049 -0500", hash_original_field = "96B5906EBFB1C2E386C1914807CC29D2", hash_generated_field = "76611AB1485AA5FC8BD8987CF3E25BA9")

    static final boolean DEBUG_TEXT_HANDLES = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.059 -0500", hash_original_field = "606D62CC0AD7EC1ECAD7109D60414614", hash_generated_field = "F714A1E692291741531539A5847EE5E7")

    static final boolean USE_WEBKIT_RINGS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.062 -0500", hash_original_field = "C395C34F6D670443278357A279170786", hash_generated_field = "D99D6450883933EC3EDB9D544EA20E89")

    private static final int HIGHLIGHT_COLOR = 0x6633b5e5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.064 -0500", hash_original_field = "D0A5A30936DA163EFE5E6389343021E5", hash_generated_field = "B9E672C8C92E4F02476A87E5E8F00EFF")

    private static final float TOUCH_HIGHLIGHT_ARC = 5.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.071 -0500", hash_original_field = "67DF00B19AE0C56189907C360509647C", hash_generated_field = "D9CFD52B18DD7ACE5C7B4C9B8DCE0FB8")

    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.073 -0500", hash_original_field = "C635159C751A5BC74350726025487A68", hash_generated_field = "9694C60ABD71F7A40135B185FF8C39AE")

    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.090 -0500", hash_original_field = "DA31B9704DE164D08D20AD1451BF9A41", hash_generated_field = "845FF623ACA8C5E4C6AACC50D38E08AD")

    private static final int REMEMBER_PASSWORD          = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.093 -0500", hash_original_field = "841C3D7DB22AB109C050E8DF4376E62A", hash_generated_field = "4FF8F5E62D23B1965B10DFC91A32FDAE")

    private static final int NEVER_REMEMBER_PASSWORD    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.096 -0500", hash_original_field = "3F082071C26FB4DF09752D8C30BA3419", hash_generated_field = "B588C19F42988465D315DA2A4FBBA3FD")

    private static final int SWITCH_TO_SHORTPRESS       = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.098 -0500", hash_original_field = "428646F4527BBDFF1723701E841C666C", hash_generated_field = "657A48B0D0DC22729992E21828434A12")

    private static final int SWITCH_TO_LONGPRESS        = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.101 -0500", hash_original_field = "EA1C32D7C9A41E6AADE8D34B798B1803", hash_generated_field = "186CFC188140DCBE345F602F7F0C2905")

    private static final int RELEASE_SINGLE_TAP         = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.103 -0500", hash_original_field = "E09EA36104E856FD5B1920EFAD2557A0", hash_generated_field = "79842F5FC0B8AB67D642FA8B9A679175")

    private static final int REQUEST_FORM_DATA          = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.105 -0500", hash_original_field = "BB466A0F316DA3DE3F7D3F2D53025C31", hash_generated_field = "A32950EE1B5E9CE33CFBA9FC2515D222")

    private static final int DRAG_HELD_MOTIONLESS       = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.108 -0500", hash_original_field = "65E8DCABAEB7FED74B2A9571CD29A417", hash_generated_field = "EE164C411576EF13FF1F4368945ABBDA")

    private static final int AWAKEN_SCROLL_BARS         = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.110 -0500", hash_original_field = "25AEDCFA4F7E33337255E2428076D6E8", hash_generated_field = "9AA9F86C18770C4CCDF9B4E83C0A3AE1")

    private static final int PREVENT_DEFAULT_TIMEOUT    = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.112 -0500", hash_original_field = "5506FCAD9BC03E9AC603A1B1D1E12197", hash_generated_field = "1A30728C562EE960FCAE38492FDF5A10")

    private static final int SCROLL_SELECT_TEXT         = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.115 -0500", hash_original_field = "835356710355F48DA47BDBAA5CBE92ED", hash_generated_field = "C4C2FB6BF24B5B91EE6F668B637E3F5E")

    private static final int FIRST_PRIVATE_MSG_ID = REMEMBER_PASSWORD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.117 -0500", hash_original_field = "3283265B7383E0B2B6F21237C4897008", hash_generated_field = "CC36E89D4F3E8BDB7A3B14B8623FFDC6")

    private static final int LAST_PRIVATE_MSG_ID = SCROLL_SELECT_TEXT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.119 -0500", hash_original_field = "2C9B3557D7F4BBFDBE5E8B405C7531A2", hash_generated_field = "7254467C2E49F4861061982FEF332006")

    static final int SCROLL_TO_MSG_ID                   = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.121 -0500", hash_original_field = "3F51A7D08D23DC29C09B1345734856D4", hash_generated_field = "7065AF08B8A2C65D18732F27B9BF7699")

    static final int NEW_PICTURE_MSG_ID                 = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.124 -0500", hash_original_field = "462F52E64035A569D6FD79722BE98516", hash_generated_field = "277D21369AF0DCC3922F2C0900E0BF83")

    static final int UPDATE_TEXT_ENTRY_MSG_ID           = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.126 -0500", hash_original_field = "3BA84C8D8B88CF5165DFFD7B24617934", hash_generated_field = "2190393FA6B05377859E2EC02FC609B1")

    static final int WEBCORE_INITIALIZED_MSG_ID         = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.128 -0500", hash_original_field = "3F1A54F9C4ABB5B30800D8B4EDBC6C62", hash_generated_field = "363113902179F1670C84BE84F2AB8C31")

    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID       = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.130 -0500", hash_original_field = "C60E7CC59730070EE2FD360D2D5C5471", hash_generated_field = "4013CBF1F8ABDA417E1F0266A418CE84")

    static final int UPDATE_ZOOM_RANGE                  = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.132 -0500", hash_original_field = "42D92504A16D3C18CFC7DE67708913C0", hash_generated_field = "ACAC39F47E162B00CF5452C8D285224A")

    static final int UNHANDLED_NAV_KEY                  = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.135 -0500", hash_original_field = "3C0B01357CBFFA70694E6E5ACA2138C8", hash_generated_field = "D4C9BC4EE92065A4B38085E347EBFF2D")

    static final int CLEAR_TEXT_ENTRY                   = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.137 -0500", hash_original_field = "67283E7ECC807356FCA8CE191A5D83CF", hash_generated_field = "FE149D6B2BEA3EF65A0F281FAAB4BD1B")

    static final int UPDATE_TEXT_SELECTION_MSG_ID       = 112;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.140 -0500", hash_original_field = "72A72DC7B2409D47A16DF7650F186CAB", hash_generated_field = "AAAC74426AC96A03AD3699140276236E")

    static final int SHOW_RECT_MSG_ID                   = 113;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.142 -0500", hash_original_field = "A30200ED821E865D61A9E1C72F9179DA", hash_generated_field = "5AAABADC1AB3CEBAA78D6532F857C623")

    static final int LONG_PRESS_CENTER                  = 114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.145 -0500", hash_original_field = "BA5D3DA2B88ADD6570B4E9846DC33958", hash_generated_field = "201D6503E6272B55C420339E2E7BDE7C")

    static final int PREVENT_TOUCH_ID                   = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.147 -0500", hash_original_field = "2AAD8B0A1B872824B1DE78A38AD688E9", hash_generated_field = "A86F64A6A36838BB94E4B146AB31DF86")

    static final int WEBCORE_NEED_TOUCH_EVENTS          = 116;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.149 -0500", hash_original_field = "C3FB219EC677747210E391E7E55328E7", hash_generated_field = "79B69F5D8A24CF7E46EB19A46659BFA2")

    static final int INVAL_RECT_MSG_ID                  = 117;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.152 -0500", hash_original_field = "0CEC3ABC849B80FB405124B27B0BD274", hash_generated_field = "924815315D700D740440DFA55EE36D91")

    static final int REQUEST_KEYBOARD                   = 118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.154 -0500", hash_original_field = "455AA65E2119CDD4EF270F4EA70AC4E6", hash_generated_field = "4768152ADFCA823C71171A5E37B97106")

    static final int DO_MOTION_UP                       = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.156 -0500", hash_original_field = "76AF937D30DF43DA62E3190FCBD800F8", hash_generated_field = "E7977AC2556CED43CF07CEE5AF8FDE33")

    static final int SHOW_FULLSCREEN                    = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.158 -0500", hash_original_field = "97523EB44850FAE3CD482B0BF4C95E54", hash_generated_field = "B95AC15CEB23F6D073C96BA18C56AFC4")

    static final int HIDE_FULLSCREEN                    = 121;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.160 -0500", hash_original_field = "3E5E7526B36CF31832D0CF70B686AF43", hash_generated_field = "11B42A13FA8326EB24C2CB47B363607D")

    static final int DOM_FOCUS_CHANGED                  = 122;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.163 -0500", hash_original_field = "4CB313806EF3E84A18AED09E80B0FF27", hash_generated_field = "993E493207463D5A7619CFA9914C444F")

    static final int REPLACE_BASE_CONTENT               = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.165 -0500", hash_original_field = "680E3209023ACFF25630846E6F857444", hash_generated_field = "656F7FC823E801D32B0F7134A367764C")

    static final int FORM_DID_BLUR                      = 124;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.167 -0500", hash_original_field = "180DA49C34B5654C77A1894231042D4C", hash_generated_field = "96DB2122D5F33DFDA3965819F33C1149")

    static final int RETURN_LABEL                       = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.169 -0500", hash_original_field = "83E63E3931288A293CE53DDAC202E4BA", hash_generated_field = "E77F6B5D2A8DAA7E01A4E6E904DA5730")

    static final int FIND_AGAIN                         = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.172 -0500", hash_original_field = "2D572EE5A661A2CCABA51C627FFACD27", hash_generated_field = "72BDFF2047DC48D536EFABE2C6EBF63A")

    static final int CENTER_FIT_RECT                    = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.174 -0500", hash_original_field = "A7BF8F8ECA161BF0EE3D134A4918BACE", hash_generated_field = "8BE537A1AEFB91D6733828F1CA586112")

    static final int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.176 -0500", hash_original_field = "30B55B58E0D3A11962BA8B95105B15BC", hash_generated_field = "A9F84DE94816567373BF26E254C087FE")

    static final int SET_SCROLLBAR_MODES                = 129;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.178 -0500", hash_original_field = "B3F8622D0101D08CC2E18191FA037ACD", hash_generated_field = "AD64A4F8822122E1A34DBBC79E31614C")

    static final int SELECTION_STRING_CHANGED           = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.180 -0500", hash_original_field = "BF30116252DFEAC8159B9636DF6A900A", hash_generated_field = "8CDB94B0E367FF9B79372CF48343B648")

    static final int SET_TOUCH_HIGHLIGHT_RECTS          = 131;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.182 -0500", hash_original_field = "751E219932980028B247C3EF2BC83159", hash_generated_field = "03CC030275D6F647B2B790C448B6FE84")

    static final int SAVE_WEBARCHIVE_FINISHED           = 132;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.185 -0500", hash_original_field = "07C3DFA1ED1D627F79FAFAAEFE798183", hash_generated_field = "FFD1C9BADD0FACA49935CBF0B35A5383")

    static final int SET_AUTOFILLABLE                   = 133;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.188 -0500", hash_original_field = "09D0D3E8265FC919D9975F292DF33BDF", hash_generated_field = "BC4DF909BBCB4938EDEA9A6C5ED1E05E")

    static final int AUTOFILL_COMPLETE                  = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.190 -0500", hash_original_field = "E21ECB6258D90D0BD176B2E3E7677FCA", hash_generated_field = "1A34A6FEE310D5268F65BDDC9AB9E463")

    static final int SELECT_AT                          = 135;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.193 -0500", hash_original_field = "01C67DA284F3D37D58FD0B1F97EC8D1E", hash_generated_field = "170B2EC041BE3DE273500B68E73B6761")

    static final int SCREEN_ON                          = 136;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.195 -0500", hash_original_field = "7207EC1F96C1BE058026553466A54102", hash_generated_field = "73783E2BCB2A1F25F9EF7718CCC75157")

    static final int ENTER_FULLSCREEN_VIDEO             = 137;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.197 -0500", hash_original_field = "9E5B73BF2968FBCA9FAD8904C7F2FFDE", hash_generated_field = "8C35AD6313526A4AA2605C4FC66BF0A4")

    static final int UPDATE_SELECTION                   = 138;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.199 -0500", hash_original_field = "188E6ED0B3B3B77FF8311C13AC8BD5EF", hash_generated_field = "9390DCDC12CE0060B9E23ED7E29C5AC0")

    static final int UPDATE_ZOOM_DENSITY                = 139;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.201 -0500", hash_original_field = "F8EEE6146FD6B0A00FD6923A73FCCAC7", hash_generated_field = "8C572792B03EEB5427DEDA49100454ED")

    private static final int FIRST_PACKAGE_MSG_ID = SCROLL_TO_MSG_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.204 -0500", hash_original_field = "63E6AB032F5F6E6F91430BCFC446A983", hash_generated_field = "4E7D46918644EB2075A696C11D88350A")

    private static final int LAST_PACKAGE_MSG_ID = SET_TOUCH_HIGHLIGHT_RECTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.206 -0500", hash_original_field = "4146704713F20BC59F311BDE394CB7B9", hash_generated_field = "602447B2C284F14CC78DF7DCCA7E9F60")

    static final String[] HandlerPrivateDebugString = {
        "REMEMBER_PASSWORD", //              = 1;
        "NEVER_REMEMBER_PASSWORD", //        = 2;
        "SWITCH_TO_SHORTPRESS", //           = 3;
        "SWITCH_TO_LONGPRESS", //            = 4;
        "RELEASE_SINGLE_TAP", //             = 5;
        "REQUEST_FORM_DATA", //              = 6;
        "RESUME_WEBCORE_PRIORITY", //        = 7;
        "DRAG_HELD_MOTIONLESS", //           = 8;
        "AWAKEN_SCROLL_BARS", //             = 9;
        "PREVENT_DEFAULT_TIMEOUT", //        = 10;
        "SCROLL_SELECT_TEXT" //              = 11;
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.210 -0500", hash_original_field = "291DA55D15990632E6364B01E2AAFC31", hash_generated_field = "47084986896DE9C949E7B48A7C384372")

    static final String[] HandlerPackageDebugString = {
        "SCROLL_TO_MSG_ID", //               = 101;
        "102", //                            = 102;
        "103", //                            = 103;
        "104", //                            = 104;
        "NEW_PICTURE_MSG_ID", //             = 105;
        "UPDATE_TEXT_ENTRY_MSG_ID", //       = 106;
        "WEBCORE_INITIALIZED_MSG_ID", //     = 107;
        "UPDATE_TEXTFIELD_TEXT_MSG_ID", //   = 108;
        "UPDATE_ZOOM_RANGE", //              = 109;
        "UNHANDLED_NAV_KEY", //              = 110;
        "CLEAR_TEXT_ENTRY", //               = 111;
        "UPDATE_TEXT_SELECTION_MSG_ID", //   = 112;
        "SHOW_RECT_MSG_ID", //               = 113;
        "LONG_PRESS_CENTER", //              = 114;
        "PREVENT_TOUCH_ID", //               = 115;
        "WEBCORE_NEED_TOUCH_EVENTS", //      = 116;
        "INVAL_RECT_MSG_ID", //              = 117;
        "REQUEST_KEYBOARD", //               = 118;
        "DO_MOTION_UP", //                   = 119;
        "SHOW_FULLSCREEN", //                = 120;
        "HIDE_FULLSCREEN", //                = 121;
        "DOM_FOCUS_CHANGED", //              = 122;
        "REPLACE_BASE_CONTENT", //           = 123;
        "FORM_DID_BLUR", //                  = 124;
        "RETURN_LABEL", //                   = 125;
        "FIND_AGAIN", //                     = 126;
        "CENTER_FIT_RECT", //                = 127;
        "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID", // = 128;
        "SET_SCROLLBAR_MODES", //            = 129;
        "SELECTION_STRING_CHANGED", //       = 130;
        "SET_TOUCH_HIGHLIGHT_RECTS", //      = 131;
        "SAVE_WEBARCHIVE_FINISHED", //       = 132;
        "SET_AUTOFILLABLE", //               = 133;
        "AUTOFILL_COMPLETE", //              = 134;
        "SELECT_AT", //                      = 135;
        "SCREEN_ON", //                      = 136;
        "ENTER_FULLSCREEN_VIDEO", //         = 137;
        "UPDATE_SELECTION", //               = 138;
        "UPDATE_ZOOM_DENSITY" //             = 139;
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.212 -0500", hash_original_field = "8D46680F43B80E400FF2D3324A08B617", hash_generated_field = "8A766883C1DD2C309BC3AADB6B97BF87")

    // use DEFAULT_VIEWPORT_WIDTH as the default viewport width
    static final int DEFAULT_VIEWPORT_WIDTH = 980;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.214 -0500", hash_original_field = "ECA7030C4CC7D41656999C6DB41344FA", hash_generated_field = "ED90D9D29AD74249AEEA12A53104EB59")

    // calculated by the Webkit. To avoid the bad behavior when some site's
    // minimum preferred width keeps growing when changing the viewport width or
    // the minimum preferred width is huge, an upper limit is needed.
    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.223 -0500", hash_original_field = "F92109C6993BC0BD3DFA437D681B6C9B", hash_generated_field = "12DD7BA1ECB0CEEABEAEA8C19EA4EEC0")

    private static final int SNAP_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.225 -0500", hash_original_field = "11D7269CB1CF2151F94BB50F4E2E90D2", hash_generated_field = "44F29DF20F3360AEBB95E56773127AF4")

    private static final int SNAP_LOCK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.227 -0500", hash_original_field = "894B87079C37E6FBC9EC34F625817D1B", hash_generated_field = "6DBF6AE108E04D4351B186A179DF3FCA")

    private static final int SNAP_X = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.230 -0500", hash_original_field = "2B40DE093732603A25859ADE057E470F", hash_generated_field = "5AFF215A3A6D74F76184DEFB1B36A42A")

    private static final int SNAP_Y = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.234 -0500", hash_original_field = "7186062EECB072F4DA236EA21486BD13", hash_generated_field = "93A7BEEBD6A337BD2002A7AF261BA794")

    private static final int DRAW_EXTRAS_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.237 -0500", hash_original_field = "EDB30609CCD2FA01B5D2C3E30A069D7A", hash_generated_field = "5DEF86C95A734C2BFB2CF176BC8AC764")

    private static final int DRAW_EXTRAS_FIND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.239 -0500", hash_original_field = "ABD8CB3C707DFCF3BBE01C68C70BB501", hash_generated_field = "F45EEC0EFD9D990731D68240BE77F3B6")

    private static final int DRAW_EXTRAS_SELECTION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.242 -0500", hash_original_field = "91915D51C9DC8DC9889427C50ACCCFC3", hash_generated_field = "DB426EFE262457E5F8DE02B93DD898EE")

    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.245 -0500", hash_original_field = "287BA2E945203D407FDF226F0B9A3DC9", hash_generated_field = "9CB3776FCE6B53D91225CA998E19D152")

    private static final int SCROLLBAR_AUTO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.247 -0500", hash_original_field = "160FCA651197FF9ED31C59ED5C9EF571", hash_generated_field = "A8314BA3A711CC792258269C0F75D504")

    private static final int SCROLLBAR_ALWAYSOFF = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.249 -0500", hash_original_field = "6C9E912CF5B69662642607CD3A64FF82", hash_generated_field = "91745CC4B7D62D037FA8FA9A02FEAC20")

    private static final int SCROLLBAR_ALWAYSON = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.256 -0500", hash_original_field = "F3A3D60A606F4A3751923793C4CCAE47", hash_generated_field = "5F56089957CE2AA577D90FD2366DCB5C")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.258 -0500", hash_original_field = "D14D825132C15BD72486AE28F1ED9A9A", hash_generated_field = "C154CE6C5A7DD848C5458E579A34E977")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.261 -0500", hash_original_field = "8CB314272D83A7E86AFB4314C7B25FC0", hash_generated_field = "3EE141793CAB7DBE4F282C0A0792360A")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.263 -0500", hash_original_field = "B32704AD79314AEB059608913CE5D08C", hash_generated_field = "7FEACEF0FBD261C47258EABED39A961E")

    private static final String ALIAS_ACCESSIBILITY_JS_INTERFACE = "accessibility";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.265 -0500", hash_original_field = "30C1B05BA4DCD859C0C1A81B64241DD8", hash_generated_field = "A2C35DC346B46BA13B63BC3C3362C4DC")

    // pick the right script for the current URL
    private static final String ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT =
        "javascript:(function() {" +
        "    var chooser = document.createElement('script');" +
        "    chooser.type = 'text/javascript';" +
        "    chooser.src = 'https://ssl.gstatic.com/accessibility/javascript/android/AndroidScriptChooser.user.js';" +
        "    document.getElementsByTagName('head')[0].appendChild(chooser);" +
        "  })();";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.268 -0500", hash_original_field = "0F59EA065EFBDB2E6411D187C0D060D4", hash_generated_field = "856EE61BCFD043BB38F397792C0CADF6")

    // The value of 0 means the accessibility script is opted out
    // The value of 1 means the accessibility script is already injected
    private static final String PATTERN_MATCH_AXS_URL_PARAMETER = "(\\?axs=(0|1))|(&axs=(0|1))";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.285 -0500", hash_original_field = "29F07EADEC4D94432989EFBDEEFBF05F", hash_generated_field = "0B476E3CCACC629DB9A3D288788EC4D4")
 static boolean mLogEvent = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.291 -0500", hash_original_field = "4999C69190E2FB28A4B1A09C5D9F533C", hash_generated_field = "EED2A629500C8CA0653CD2F48FDAD9D7")

    private static boolean sNotificationsEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.293 -0500", hash_original_field = "7A6051C7A409BC8C34B1DA3FEBAB46BF", hash_generated_field = "1105526185EEB7FC5A898096FC617896")

    public static final String SCHEME_TEL = "tel:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.296 -0500", hash_original_field = "076E0EDED75F58E2EA1AAABD567C348C", hash_generated_field = "36F5F4D1322A91FC8551EC5BF47D4080")

    public static final String SCHEME_MAILTO = "mailto:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.298 -0500", hash_original_field = "6226F783966B54812F3773E5C8A1F149", hash_generated_field = "7B183832849E08B748A127FC4F00AF3D")

    public static final String SCHEME_GEO = "geo:0,0?q=";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.303 -0500", hash_original_field = "B52CE17756400F6A79418D3CCD978702", hash_generated_field = "12AA7BB1627971F332190446E320A104")

    private static final long SELECT_SCROLL_INTERVAL = 1000 / 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.323 -0500", hash_original_field = "00A2255F0712BE3F5D01E8F8251DB432", hash_generated_field = "E9A626874BEA31BC13B6B41907D72FD5")

    private static boolean mIncrementEGLContextHack = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.397 -0500", hash_original_field = "984D94F4CFA03032C626AA0B74339024", hash_generated_field = "4EA311A46057E2E819D49F1C54EBACAA")

    private static ProxyReceiver sProxyReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.406 -0500", hash_original_field = "56BC507B2E4D29D5BFE9EC97DD7AA0DD", hash_generated_field = "BE2C046AC7C6AC534B7DCBF692384BF9")

    private static boolean sPackageInstallationReceiverAdded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.408 -0500", hash_original_field = "870EA26951894907EDDA2A634305A289", hash_generated_field = "D793892490DD0E214DB1F20B155AEC44")

    private static Set<String> sGoogleApps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.976 -0500", hash_original_field = "2A45BF2C479BDFB8F7BCDFCDC1D2571A", hash_generated_field = "739202D5461617487329E2B164F8902F")

    private static final int FULLY_ON_SCREEN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.978 -0500", hash_original_field = "60E79869D382A8D71109BE0B148FE504", hash_generated_field = "CE05C08766D95F4E3F036CF82E22E80D")

    private static final int INTERSECTS_SCREEN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.982 -0500", hash_original_field = "7F8CA9BC303456B09ED1A65E258212C9", hash_generated_field = "0FFC4C37CCC54707516F4AEADC8D4AB0")

    private static final int ANYWHERE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.002 -0500", hash_original_field = "D2DF6B355BA28BE77388D81EB1103769", hash_generated_field = "2489EBB9D342B040697800D9D9593C68")

    private static final int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.004 -0500", hash_original_field = "6BA91BF7DC1E45B3D5C9DB321F86681A", hash_generated_field = "AF1F828F986930EB290A0C1ACE51C53E")

    private static final int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.170 -0500", hash_original_field = "35717E867E8CA3981DB8FC1DBB6041F8", hash_generated_field = "0002A73C608BB024BD4E79AB8BAC6B7C")

    private static final float HSLOPE_TO_START_SNAP = .25f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.172 -0500", hash_original_field = "FC794F04B82078D327B066A47C1FDC11", hash_generated_field = "A4A8D0695FF84A162831C09369F3446A")

    private static final float HSLOPE_TO_BREAK_SNAP = .4f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.175 -0500", hash_original_field = "34AB05A92CDBC0EF57524405B67B28EB", hash_generated_field = "6129E624D18CD718742AEA8DBDBB14BE")

    private static final float VSLOPE_TO_START_SNAP = 1.25f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.177 -0500", hash_original_field = "1399E2F2E1818D68C377C9E8428CB2A9", hash_generated_field = "B98021F16BB475A9FDBFB533AE2C5734")

    private static final float VSLOPE_TO_BREAK_SNAP = .95f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.179 -0500", hash_original_field = "A5E7AC411DF20E2B25E4B15545F816B7", hash_generated_field = "F2D9920A33A34535ECA37BEBE3D0D75B")

    private static final float ANGLE_VERT = 2f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.181 -0500", hash_original_field = "D7E6E6E690025B82B9BFEDA922DE7DDD", hash_generated_field = "D881007596C110DADFB66D030A1AE042")

    private static final float ANGLE_HORIZ = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.184 -0500", hash_original_field = "4A94D673B39085A16C70A31C059DE8E0", hash_generated_field = "02A991FD63390E5D8237C6CD740E3288")

    private static final float MMA_WEIGHT_N = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.204 -0500", hash_original_field = "FCBA5BB4F752F233A974DB314CD4E75F", hash_generated_field = "0F241555BB1B7F1AFDD83530F7CB2D92")

    // density of the screen.
    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.276 -0500", hash_original_field = "0C1C2DD618BE6882BFBB2382920A2B3D", hash_generated_field = "6A677A0E966C283B8B607D7ECEA95F9F")

    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.278 -0500", hash_original_field = "8C053F5A868724F4C0847E0383870D4E", hash_generated_field = "B007269D873CD11DCF66489AD37A9EAD")

    private static final int TRACKBALL_TIMEOUT = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.281 -0500", hash_original_field = "8BFAE39A3E92AF3F127B8EDEF81C4D24", hash_generated_field = "38263236B59C07C6CAD6AC61CCFF665A")

    private static final int TRACKBALL_WAIT = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.283 -0500", hash_original_field = "A9BB69D60A6D2D1814D72DA86552CE7E", hash_generated_field = "9569AC1D1AEE74878270EB42C805F75F")

    private static final int TRACKBALL_SCALE = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.285 -0500", hash_original_field = "0A16EC316F4820F7D8AEFDAE1C3122FF", hash_generated_field = "8C66096D385ED6DA92A759E273B8AD09")

    private static final int TRACKBALL_SCROLL_COUNT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.288 -0500", hash_original_field = "D1DF9ED17818E8ADFFF10EE1D72F1E4D", hash_generated_field = "6749FB93CFC3225830453166B1116D09")

    private static final int TRACKBALL_MOVE_COUNT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.291 -0500", hash_original_field = "AB1306B909BCE0A374DB0BB6379E23E6", hash_generated_field = "E7BC40FBD90C7DEFDA42D41012CE3CB4")

    private static final int TRACKBALL_MULTIPLIER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.293 -0500", hash_original_field = "F85D23F09D7326D20A201739963AFCFE", hash_generated_field = "0A2B827BEE20945621FE1CF47839A0CD")

    private static final int SELECT_CURSOR_OFFSET = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.295 -0500", hash_original_field = "76A65E0DD87E132DFDC0EEFE64DA8E19", hash_generated_field = "60B8D37D0EC66557053483F48A69616B")

    private static final int SELECT_SCROLL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.040 -0500", hash_original_field = "077450666BD3B6F75A41CA1B96EC016E", hash_generated_field = "A9F4333AC17378DA2BC1CE8FE8AF3863")

    static final int NO_LEFTEDGE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.802 -0500", hash_original_field = "771711E3CAB1C8FC22902A344E1FA617", hash_generated_field = "6CC6F5C62728D3C43873C2A6A3501E11")

    private InnerGlobalLayoutListener mGlobalLayoutListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.804 -0500", hash_original_field = "A19F2E97ACAE2F911EE070318FAB6F36", hash_generated_field = "FD3918832A54C40DD17CB93DF3C9E96F")

    private InnerScrollChangedListener mScrollChangedListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.809 -0500", hash_original_field = "7CC318BEFF039034891F26277D4D1760", hash_generated_field = "AD74579540B42D36D4D6B2635A693432")

    private boolean mAutoRedraw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.811 -0500", hash_original_field = "21AD46B58525A411E4B1B9771C50CEBB", hash_generated_field = "89EE4E29DFEC33524F58D526AE1ACA92")

    // It's used to dismiss the dialog in destroy if not done before.
    private AlertDialog mListBoxDialog = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.816 -0500", hash_original_field = "89F04BCF2CEF2FF9614BE546923CA10D", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.819 -0500", hash_original_field = "4CAD59BBE5135E0C04805AC625DC489E", hash_generated_field = "36ADFB8E74B62C4DEE5D800A76CE9C6D")

    private final Rect mGLRectViewport = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.821 -0500", hash_original_field = "E1D4E69789F4E138950C37C99A5CACF5", hash_generated_field = "FB5FB956134A1E202B8B65301622285A")

    private final Rect mViewRectViewport = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.823 -0500", hash_original_field = "7ACBA4A13180E4993EA3E3D285A30782", hash_generated_field = "51BDAF2CD4D275E8CED0563368F453CE")

    private final RectF mVisibleContentRect = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.825 -0500", hash_original_field = "F3DADDC5A4E71865835C3DBB21CCD833", hash_generated_field = "6BED6DB5622AA2BCDA57E6A48F00385A")

    private boolean mGLViewportEmpty = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.854 -0500", hash_original_field = "C50B804397335F4C59F495D6A5AAA565", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private  CallbackProxy mCallbackProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.857 -0500", hash_original_field = "2DFBDBD4347FE4E3543384465B3B797C", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private  WebViewDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.859 -0500", hash_original_field = "8722B9770017213537D317FB65A9919D", hash_generated_field = "B46B2FBDC77E7FD9B4E8141E1595B5DC")

    private SslCertificate mCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.861 -0500", hash_original_field = "07FEFC5B2084F76E6CC54B7208111C50", hash_generated_field = "219510A9FAE6E554308EB5F60C4E8CB8")

    // created.
    private int mNativeClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.863 -0500", hash_original_field = "799AB033E7CD1CC92AF93A69917908BF", hash_generated_field = "A28EE3F94DFC2909C02050EBA5B65F21")

    // destroyed.
    private WebViewCore mWebViewCore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.865 -0500", hash_original_field = "F1FD27CC75E819B7519464DBAA075663", hash_generated_field = "EBCAFB070E0C48E133EA460DF1A8E31F")

    /* package */ final Handler mPrivateHandler = new PrivateHandler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.867 -0500", hash_original_field = "BD72EBF63280DCD43897377651E43171", hash_generated_field = "AFC642D7CC3CCD87E0FAB3BD2F752688")

    private WebTextView mWebTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.869 -0500", hash_original_field = "199FE44F91F4F1B8CB571680578352F3", hash_generated_field = "562E8BA58B8760B3FBDE7B8820B8B738")

    // more key events.
    private int mTextGeneration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.874 -0500", hash_original_field = "998C24A93F5A243548630A07FBEEBABF", hash_generated_field = "03BCC0F20BFE07773FE20B85B73974E8")

    /* package */  ViewManager mViewManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.876 -0500", hash_original_field = "E9614F2B38AB4DEABFFB87F7486CC59B", hash_generated_field = "E9614F2B38AB4DEABFFB87F7486CC59B")

    PluginFullScreenHolder mFullScreenHolder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.878 -0500", hash_original_field = "35062D972410BBB1FE725ED89BA41011", hash_generated_field = "BD4968058047E8092403B263696B6E7C")

    private int mLastTouchX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.880 -0500", hash_original_field = "83DD8996AB5E7F5A3A78A1F5BC03546B", hash_generated_field = "69A36CEAFC0963888AC8B4ED2F6D4978")

    private int mLastTouchY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.882 -0500", hash_original_field = "14847273E02020AEBA7C0FF65AE1992E", hash_generated_field = "4D8D56CD18597A03E84AFA3541D74E0F")

    private int mStartTouchX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.884 -0500", hash_original_field = "40937D13C85EF8EDCA9E0BF1F550CA12", hash_generated_field = "CEF59ED5F74695F1C489B12BA9877E2B")

    private int mStartTouchY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.886 -0500", hash_original_field = "3DF6E064E068DE667657B1466F4E2E28", hash_generated_field = "5C401664BB9D608028617F5EDF66E2AF")

    private float mAverageAngle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.888 -0500", hash_original_field = "FB58D09EAA08B496B654F37BDCBB752E", hash_generated_field = "47C433080713997997212745A4983F8F")

    private long mLastTouchTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.890 -0500", hash_original_field = "C3CC5E680D2F1F94C40C92D765F9AB71", hash_generated_field = "0990A940DEEA6D528A067E6EA87B7F9C")

    private long mLastSentTouchTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.896 -0500", hash_original_field = "FC736F486A4FD978D60C08B4C0672180", hash_generated_field = "561D6233D1FB6E93F053BC05FD8FA507")

    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.898 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "507D8F8387EDC230B54D84A5AD8E5830")

    VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.900 -0500", hash_original_field = "AAC40B9C50B43C3542F08C995BB858EE", hash_generated_field = "F4AD22AFC08761D5F541EC696D9C09FE")

    private int mMaximumFling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.902 -0500", hash_original_field = "6E335DD9E5DC0F72B2FD65D92FBCA030", hash_generated_field = "36A6D141DB1FFF457C16610ED5D633AD")

    private float mLastVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.904 -0500", hash_original_field = "8889182BFC3B3FFF2D03DD7FF1C0A82E", hash_generated_field = "C0F88FE2C7B9E7C7BB7B21BE6A587FCF")

    private float mLastVelX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.906 -0500", hash_original_field = "C1DE7D55A1380F8A1C8248087776124F", hash_generated_field = "28065D974B22FD4A98645752CE5547CF")

    private float mLastVelY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.908 -0500", hash_original_field = "83F84EDCE9F28E1BDA6F27C848FEDBAA", hash_generated_field = "607EC8CFE97408F4374FF8F7ACABB92F")

    private int mCurrentScrollingLayerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.910 -0500", hash_original_field = "3EC51515E245659C7CBCFC6EC290D588", hash_generated_field = "2C565358915D9304934306126B23D037")

    private Rect mScrollingLayerRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.915 -0500", hash_original_field = "5B94107B6F397B118A3FC8BB06F504A3", hash_generated_field = "066849BFFA66413DA55C64140E71033C")

    private int mTouchMode = TOUCH_DONE_MODE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.938 -0500", hash_original_field = "9EB2FED2618ABDD67C7897B5E025FB23", hash_generated_field = "3A29CEF1DA2C2B3FE6FFDD5EF2D24261")

    // Can only be set by WebKit via JNI.
    private boolean mForwardTouchEvents = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.953 -0500", hash_original_field = "34098659EC054A2BFF39486507734B7C", hash_generated_field = "E1D1C001302DE5375C735E7EF10D1D17")

    private int mPreventDefault = PREVENT_DEFAULT_IGNORE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.955 -0500", hash_original_field = "D038447DAE8F7E995B57CE09DE0C0CDF", hash_generated_field = "7A19B98B2EFB8BB31AEC747F1CA41B97")

    private boolean mConfirmMove;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.957 -0500", hash_original_field = "3786444AFF545B6AFFE2F85C47DBBAAA", hash_generated_field = "F6598AA86FF381048F798F3CE13E2D6A")

    // default is not set, the UI will continue handle them.
    private boolean mDeferTouchProcess;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.959 -0500", hash_original_field = "606F67D62F27BEFE6F828C2EB59C0352", hash_generated_field = "8423324F9E580D6ABFEBE04C2CF75992")

    // separately. Currently no snapping or fling in the deferred process mode
    private int mDeferTouchMode = TOUCH_DONE_MODE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.962 -0500", hash_original_field = "AC2CDB68F7174E3A8704A11BF1BCBC37", hash_generated_field = "0B464B8324C284C9331034B27020C3DF")

    private float mLastDeferTouchX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.964 -0500", hash_original_field = "3AF7D66DFE02263FF4D7469B0C29E839", hash_generated_field = "BB913DF57D5D59E382435C22DB0D167C")

    private float mLastDeferTouchY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.965 -0500", hash_original_field = "1AAAA5D187A798CA7E8F507E98CEFDFE", hash_generated_field = "E0C3485DD19C202F3D11EAB2496B409C")

    // so that we know not to hide the cursor
    boolean mDragFromTextInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.967 -0500", hash_original_field = "DF8033393D4E456CD9FA96A199E1F05B", hash_generated_field = "73F680AEDB48E6ACAF7DB5B88D2B7A20")

    private boolean mDrawCursorRing = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.969 -0500", hash_original_field = "EDA16AE07539011386A0914499547B11", hash_generated_field = "4940A67E026325EBC1382989DD930EDC")

    private boolean mIsPaused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.971 -0500", hash_original_field = "17F3994BC8262A545F662CC87E616634", hash_generated_field = "9F291EA33B1111436C86DAFA7D749E10")

    private HitTestResult mInitialHitTestResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.973 -0500", hash_original_field = "22908E064AB773A0D025345BB08C461C", hash_generated_field = "72C2872022E176C2DE96D122AA6A9BD4")

    // pre-computed square of ViewConfiguration.getScaledTouchSlop()
    private int mTouchSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.976 -0500", hash_original_field = "D8CB968A9E00512DAFB6AA042D9A5D66", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.979 -0500", hash_original_field = "FCA906E4645008E909410AA6F3DCD2CD", hash_generated_field = "3648C260E562DC86BDAAC7F94E7352D4")

    private int mNavSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.993 -0500", hash_original_field = "B290C2276932B172EE2AB0CAFBE30BAE", hash_generated_field = "B290C2276932B172EE2AB0CAFBE30BAE")

    boolean mWidthCanMeasure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.995 -0500", hash_original_field = "61DC23F447FF0AD3EC3A81B971B9006E", hash_generated_field = "61DC23F447FF0AD3EC3A81B971B9006E")

    boolean mHeightCanMeasure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.997 -0500", hash_original_field = "0A23B55D1A7DFF5E5D35E13264ADE9DE", hash_generated_field = "B22EF3E12E398C5623A47CCE4021B556")

    // sending the same dimensions more than once.
    int mLastWidthSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.999 -0500", hash_original_field = "DC0C48A78A79993E34C7065A16800A42", hash_generated_field = "DC0C48A78A79993E34C7065A16800A42")

    int mLastHeightSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.001 -0500", hash_original_field = "03CB436788BF47F35B484535A1648867", hash_generated_field = "0EF752E12802279D5B5FF48AC2E685BF")

    // value records the last sent actual view height.
    int mLastActualHeightSent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.003 -0500", hash_original_field = "E53904AD377D72960D8A5847D00D2A72", hash_generated_field = "5F8C94CB44AF6FE0EF7A765D1E3AFD13")

    private int mContentWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.005 -0500", hash_original_field = "6909FC61CEAFC4290968B35F30281B2B", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.008 -0500", hash_original_field = "0D47A503CDF7DFC01B4E415C7E81D77A", hash_generated_field = "4C8021BC04DD55EDACC8DEA77A9DDCF8")

    // Need to have the separate control for horizontal and vertical scrollbar
    // style than the View's single scrollbar style
    private boolean mOverlayHorizontalScrollbar = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.010 -0500", hash_original_field = "A15789EB41BB3EBD83DBDD91627E2D13", hash_generated_field = "C373EF1100F74B3BFFFB5DEE30CCBD07")

    private boolean mOverlayVerticalScrollbar = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.019 -0500", hash_original_field = "63F6CA74EEC786DAEE7A49BF47815C33", hash_generated_field = "BA331B1B58497FA7AEC038701D51D669")

    // Used by OverScrollGlow
    OverScroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.022 -0500", hash_original_field = "B5FE60493D824E3762B730930C148F9F", hash_generated_field = "3C483E4AA361608032CA95612E8DD525")

    private boolean mInOverScrollMode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.028 -0500", hash_original_field = "29AE1E96A888E254154D1CC9F943ACC8", hash_generated_field = "DC1AD28F6DE5AE5C8271D33DC8A73FB4")

    private boolean mWrapContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.040 -0500", hash_original_field = "A75EC86DBEE2CD8C39770CE3CEA2CD20", hash_generated_field = "9FDC3D0BB72A7D1D7962780902257BB3")

    private int mHeldMotionless;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.042 -0500", hash_original_field = "20C982741BF08CD31E1DB1E04EAE8D4A", hash_generated_field = "2D88F9AA5376B187A7A8C303446D8249")

    // JavaScript or ones for which no accessibility script exists
    private AccessibilityInjector mAccessibilityInjector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.044 -0500", hash_original_field = "A6F4005ED4DE99145F559123EE86F36D", hash_generated_field = "54564DA92BBBC03042BB179DF1E3DBF6")

    // know to handle Shift and arrows natively first
    private boolean mAccessibilityScriptInjected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.051 -0500", hash_original_field = "BE4F58FC393A48E09C1F141F8D7CFAFD", hash_generated_field = "61AC3E065C8F6175E76224FE4B7A0FF2")

    private Region mTextSelectionRegion = new Region();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.053 -0500", hash_original_field = "E2BF903C7A0F90F87D11CBF14391089E", hash_generated_field = "BD311CF93A193EF9001A97A5DA8FE989")

    private Paint mTextSelectionPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.055 -0500", hash_original_field = "73A3461427515CA0D6EC13FAF3DABAD3", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.057 -0500", hash_original_field = "63C35F1953545E7F3F0712EB353CE909", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.067 -0500", hash_original_field = "4FE7AD54E90B99947D2673AF31D5365E", hash_generated_field = "19F67E28C78216AF79F5581C6BC23DEC")

    private Region mTouchHighlightRegion = new Region();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.069 -0500", hash_original_field = "F536CAAB6E3D2DABFB70E70AB3B6E8A2", hash_generated_field = "FA05D517E862A9B2474EE135EA332D18")

    private Paint mTouchHightlightPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.076 -0500", hash_original_field = "C0D289F64F1DB84A53E1862265867D25", hash_generated_field = "CCDC3EB9EBCFF4D16ABA2CE80EB3455A")

    private Paint mTouchCrossHairColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.078 -0500", hash_original_field = "DD6394A585005902C3BADC5C25649CE4", hash_generated_field = "1735D38F75F52C24227B746378768B7B")

    private int mTouchHighlightX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.080 -0500", hash_original_field = "132580120F29E037E94399ABA091CAFE", hash_generated_field = "44E768B9D358A889E8F0FC8017DD211E")

    private int mTouchHighlightY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.082 -0500", hash_original_field = "BC91D163716576B7BC7FEA1DCBAC2BB9", hash_generated_field = "BCDAE3999FBCFDE5BC7A1BE619AB74DD")

    private long mTouchHighlightRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.084 -0500", hash_original_field = "4DECF9A9F2B5B0D978861F79250BFA6A", hash_generated_field = "D11AB1F9BF002D240945BF312132F894")

    // SetBaseLayer time and to pause when WebView paused.
    private HTML5VideoViewProxy mHTML5VideoViewProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.086 -0500", hash_original_field = "408F88C0409C567156AC33237011D3DD", hash_generated_field = "D395AA199126908FEE3B0F46BA4F9C62")

    private boolean mBlockWebkitViewMessages = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.088 -0500", hash_original_field = "EDE589EA426C8D634992AFFE6D511EEC", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.216 -0500", hash_original_field = "30BB871261A1AB18D3D5CF80DD338DCB", hash_generated_field = "0E203AC987BF40A8DEA081542906FFB5")

    private int mInitialScaleInPercent = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.218 -0500", hash_original_field = "C31DEA7AE1E98F05379BFF05BD440B15", hash_generated_field = "FA946648632C85BC04665EE7D148FCC7")

    // to false when restoring the scroll position.
    private boolean mSendScrollEvent = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.220 -0500", hash_original_field = "76A1E7095A9987EF2220F359971FA43A", hash_generated_field = "006CA1330A69406C602E466B10C43D72")

    private int mSnapScrollMode = SNAP_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.232 -0500", hash_original_field = "37B867A4DDC39CA1ADBC92ED64E2D59D", hash_generated_field = "761337948FA4302FD3F9FCADBD7D6775")

    private boolean mSnapPositive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.251 -0500", hash_original_field = "3E7EFCE290562B2CE1B6933EB322C247", hash_generated_field = "E5F7424044C4D04F0D77F776582A67ED")

    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.253 -0500", hash_original_field = "856B9CEF3BA03BC5786FE244426F19E8", hash_generated_field = "4A97F423DAA345C75890FCC344743D6F")

    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.271 -0500", hash_original_field = "80045207B9E9BA23B94ABFFBC5ADAD99", hash_generated_field = "4036B77E67867608087C8B2F001B55D5")

    private TextToSpeech mTextToSpeech;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.273 -0500", hash_original_field = "9828365F5E97657DBB5966FF3DF422BA", hash_generated_field = "1642D7423FB15C64A4AAEE8A9C5243AD")

    private Pattern mMatchAxsUrlParameterPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.275 -0500", hash_original_field = "3140A319F32CA873045621864B655537", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.277 -0500", hash_original_field = "F239C82AEB45C28104273F86A78E6F04", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.280 -0500", hash_original_field = "A17F2B2FA2811A21667D5D4B17E262B3", hash_generated_field = "8B88748678D320254190188B25A37155")

    private OverScrollGlow mOverScrollGlow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.282 -0500", hash_original_field = "F2252D08978A4F88484B28F6BC24D74B", hash_generated_field = "6DAF40C63FBB9494FA268E54C51A621E")

    private Vector<Integer> mKeysPressed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.287 -0500", hash_original_field = "EA0CE8941EE0428791CABCF71AC5F9E9", hash_generated_field = "5D52BE334296C573389C0CB6810E8EF8")

    private long mLastTouchUpTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.289 -0500", hash_original_field = "EDFEBBF17BD799FAA6D0096BF64BC979", hash_generated_field = "EF5F7F128924D81624F7C082EE5C57AB")

    private WebViewCore.AutoFillData mAutoFillData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.300 -0500", hash_original_field = "FE9D0827027BBBA62864073D294FED0E", hash_generated_field = "72384577DFC3FC75A8B033CE6FF0A482")

    private int mBackgroundColor = Color.WHITE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.305 -0500", hash_original_field = "9F6013B513913A5B063CE0950D5BC501", hash_generated_field = "ABB6666AC59D2544A6D12F224E33C262")

    private int mAutoScrollX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.307 -0500", hash_original_field = "FEE379F60A69486C80B2463CC2506A9C", hash_generated_field = "A4B68D036567B21BC4865DE6F61A2F9B")

    private int mAutoScrollY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.309 -0500", hash_original_field = "94120F36A60847DC9163D5C61A7BB441", hash_generated_field = "D6CD5D682502282E9E072F16ACF14D05")

    private int mMinAutoScrollX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.311 -0500", hash_original_field = "DDDEA288B1C41CEF63ED6A666044482F", hash_generated_field = "DC36203DB61C91E1CACF31ED43B3363B")

    private int mMaxAutoScrollX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.313 -0500", hash_original_field = "D5A930A01AE7169E5B96615FD3E23632", hash_generated_field = "57F79EF124C5DBD88EF9E9E66F10A308")

    private int mMinAutoScrollY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.315 -0500", hash_original_field = "CC53494DC3F64185F97CA297D3FF55C5", hash_generated_field = "CE9836AC2A30ED3AE38A49B2B5FD58DC")

    private int mMaxAutoScrollY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.317 -0500", hash_original_field = "8553823267D81150213696AC792D8CAF", hash_generated_field = "C04A6808A8A8B578AE175BC815BEE12B")

    private Rect mScrollingLayerBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.319 -0500", hash_original_field = "92416C5F5869CB2994A9DDFBC85B9E1E", hash_generated_field = "D0A94ECA1348E1AFEFD396947BC74CA0")

    private boolean mSentAutoScrollMessage = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.325 -0500", hash_original_field = "485DFF63D204104171E7175621BBD6FD", hash_generated_field = "A3939324652696BBD6D583F09CF597D7")

    private final TouchEventQueue mTouchEventQueue = new TouchEventQueue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.327 -0500", hash_original_field = "222A18F7ED96F97CA4DD0B63FAE82867", hash_generated_field = "333D865FCED73682C738B5A705E887AA")

    private boolean mPictureUpdatePausedForFocusChange = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.329 -0500", hash_original_field = "AB017C83A4E2B1EC80BAC1269B682472", hash_generated_field = "4A0FE46DD2984BED2A76807E9415B4B3")

    private PictureListener mPictureListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.488 -0500", hash_original_field = "714E88D1E99B4DF5F0767E40B341D50F", hash_generated_field = "4EFDB68AF38CE1FE479B1628CB5C7FFE")

    private int mCachedOverlappingActionModeHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.677 -0500", hash_original_field = "D19A1A00A0D109530E04604537DE7857", hash_generated_field = "3E16AF791F0C585BB692C30369E75608")

    private View mTitleBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.679 -0500", hash_original_field = "FB1ADE50622A5C3F2AD435CA6E7523F0", hash_generated_field = "82DF3ED5B282B44B1689BB6A67100AAF")

    private int mTitleGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.716 -0500", hash_original_field = "77F138C0FB078FD04602625FDED7657F", hash_generated_field = "CC333D0F8AD8FFDB25F1E8D239DE82EF")

    private Rect mLastVisibleRectSent = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.719 -0500", hash_original_field = "3A05ABDA846F1D34F8FD97DD317E515E", hash_generated_field = "9D8EB240679F63D7259D12AA2646AE20")

    private Rect mLastGlobalRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.721 -0500", hash_original_field = "6C02949576BB491A5AE8F04B7BE021A2", hash_generated_field = "DBEA6A01B6683DAB3422424D4E5AF629")

    private Rect mVisibleRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.724 -0500", hash_original_field = "90077AFE710D9C661C47363315C10CE3", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.726 -0500", hash_original_field = "17A00880305D200212918AD32181BA34", hash_generated_field = "F65CE097DE2BD38B5640202605D44DCF")

    private Point mScrollOffset = new Point();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.731 -0500", hash_original_field = "9AA4B9AE03BF45798C8FEA9679CC2EE3", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.737 -0500", hash_original_field = "134E75239DFB27E8D645B4C21AA0CC85", hash_generated_field = "E9C8FCC78A563BE608DAE1158D0138F1")

    private Rect mContentVisibleRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.844 -0500", hash_original_field = "A163A27568A49C47CADE3DF4B989D87A", hash_generated_field = "18201BE28AF4897CDDE04B91A8BAC40D")

    private FindActionModeCallback mFindCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.851 -0500", hash_original_field = "BAE013BD725887318BF27DDE23377B2C", hash_generated_field = "E762AA7ABBB062AFD98ECE99815F47B3")

    // or not we draw the highlights for matches.
    private boolean mFindIsUp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.853 -0500", hash_original_field = "99F9151C698914B101D01A606BAD643E", hash_generated_field = "72A21B49D438EABE6DDFAEDCD9B53B2E")

    // reopened.
    private String mLastFind;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.896 -0500", hash_original_field = "5392948562E1F27911E79EE01A5BF199", hash_generated_field = "11CC91033432A6D33F6833384C84316E")

    private String mPageThatNeedsToSlideTitleBarOffScreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.898 -0500", hash_original_field = "BF71EFC99F308BB3940B2FB70A238BA5", hash_generated_field = "39C14D863975598F1C60036A4E9EC22E")

    private int mYDistanceToSlideTitleOffScreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.970 -0500", hash_original_field = "592F2B75BE96A8C89DA4630BFA1EF590", hash_generated_field = "A47FD3369D923B9B9858ECC0900495AB")

    private int mOrientation = Configuration.ORIENTATION_UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.974 -0500", hash_original_field = "A3587DA3E8EA3B1EB7A45C48E73CDA9B", hash_generated_field = "CFB51504048F92C552B87D79FF631083")

    private SelectActionModeCallback mSelectCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.006 -0500", hash_original_field = "BDDA94154EA60E6632321BDF2C6655B0", hash_generated_field = "588110A2CFA9E9678107331C0D2C96FA")

    private final DrawFilter mZoomFilter =
            new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.008 -0500", hash_original_field = "E8B9E364787CE04C441044959E83628E", hash_generated_field = "6C99E5AC4C9CFFB5676D7E9B3F3366A7")

    private final DrawFilter mScrollFilter =
            new PaintFlagsDrawFilter(SCROLL_BITS, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.019 -0500", hash_original_field = "E17B6495AAC2783E60584BCD3E54D8FE", hash_generated_field = "51BC097A03E0230FE4DFAD304AA0C022")

    private boolean mDrawHistory = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.021 -0500", hash_original_field = "907D4E0A4B607701505ABE7FB1E237CD", hash_generated_field = "E6AB03F308839A8ED10716B0A06579B2")

    private Picture mHistoryPicture = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.023 -0500", hash_original_field = "0640217286BAA2BE653179B6CA6F5F0C", hash_generated_field = "0C64A62751DA7E49704757557E14D916")

    private int mHistoryWidth = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.025 -0500", hash_original_field = "4E8990E93592D7040A41C0DD8183AB70", hash_generated_field = "75F48CB3330D09CEFA904F7B84BDA417")

    private int mHistoryHeight = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.097 -0500", hash_original_field = "C358249DF7C2CB2C2E8AF576B6A141E9", hash_generated_field = "B14881C708C4261D340490A2D8CCFC57")

    // affect long press with the trackball/touch.
    private boolean mGotCenterDown = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.201 -0500", hash_original_field = "54B50F5F74B4B283EF10C61CC02B6EFC", hash_generated_field = "6BA9F593E96951F9D93C5371F1ED7501")

    // Computed in init().
    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.255 -0500", hash_original_field = "B4F1FDDA37D4A45101E61FBB4D71B902", hash_generated_field = "C1BDD4A6558DC5330CEE7B5578017A71")

    private long mTrackballFirstTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.257 -0500", hash_original_field = "450DF8152367BE31AF83C3E5EB78FD27", hash_generated_field = "7A8E9CA6466F4282ADE2CFEAB9543F99")

    private long mTrackballLastTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.259 -0500", hash_original_field = "22DA21C87A638B8414CF6C725AAB037B", hash_generated_field = "D0AAD41F7AF21E3C814A3CE6751CC65E")

    private float mTrackballRemainsX = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.261 -0500", hash_original_field = "FF215BF1043FEAAC230A356D19C5A5E9", hash_generated_field = "43DEE62CF8478127489DCB48CC70FD45")

    private float mTrackballRemainsY = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.263 -0500", hash_original_field = "9C6425433F0D65D9A9513DD6976B6F65", hash_generated_field = "7912151F282E7C954771498A3F49BAA2")

    private int mTrackballXMove = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.266 -0500", hash_original_field = "B5EB2D38B73F6A44728EA5C2F94AC904", hash_generated_field = "E884F524A10E52504DC2311DBDFD6B80")

    private int mTrackballYMove = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.268 -0500", hash_original_field = "EBF8D724C72DE8B0EE469F4D3C74B19C", hash_generated_field = "17DE07DD7201E373F3679F7C8E42D936")

    private boolean mSelectingText = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.269 -0500", hash_original_field = "F57AF4ED06B039BEABCF339B26E973BC", hash_generated_field = "E66D148FB016EBE0AB6A510827B8EDE8")

    private boolean mSelectionStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.271 -0500", hash_original_field = "B0F86F10D0FFA1F60B721F9F1A3FE04E", hash_generated_field = "A0828D99C4C5AD1E7FE83A66318FB99D")

    private boolean mExtendSelection = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.273 -0500", hash_original_field = "0B9320E649EA1388B50C2A64F283290E", hash_generated_field = "2908E3A71D3F7575EE5D63922F38ADEA")

    private boolean mDrawSelectionPointer = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.297 -0500", hash_original_field = "5055B7DA5483AEF18A46F66132438FDF", hash_generated_field = "DF8E0D848DB8117787785920A7B48359")

    private int mSelectX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.299 -0500", hash_original_field = "B90EE851DF94F4DB81F097A16B41481A", hash_generated_field = "FE7922D4E6B26989A17C6608E2D41B9A")

    private int mSelectY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.301 -0500", hash_original_field = "C568DDEAE3246242AEEE289F00E7E673", hash_generated_field = "F7FF545538C9AFAAB77E510B3626B30E")

    private boolean mFocusSizeChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.304 -0500", hash_original_field = "E36DE2774C3AFE6B0E362EB9561F3AA7", hash_generated_field = "9FA6435FA400DA07C2707641944C195D")

    private boolean mTrackballDown = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.306 -0500", hash_original_field = "00AC28D951EEBA486E1411B80A78D987", hash_generated_field = "7F383DE2FB2467193D38739089AE9AA7")

    private long mTrackballUpTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.308 -0500", hash_original_field = "3CC7F8602028F7A309124BE040E9DDE7", hash_generated_field = "36CFD91777BA610BB27907D3ED4B1532")

    private long mLastCursorTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.310 -0500", hash_original_field = "F13B3C8A4F7FAF12747B9355BC6E251B", hash_generated_field = "628DA4E196378CFBF1F4C373208CA500")

    private Rect mLastCursorBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.313 -0500", hash_original_field = "D4F11A71ACF630AB3F612BC0C5FE48C7", hash_generated_field = "2109F61131A04A9568E346864ABDD13F")

    // directly for movement. Currently, the framework only passes
    // arrow key events, not trackball events, from one child to the next
    private boolean mMapTrackballToArrowKeys = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.315 -0500", hash_original_field = "CD984ABC64946E4B835D5113248CD18C", hash_generated_field = "AD498406B1DE6FEBF53F73747731D143")

    private DrawData mDelaySetPicture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.317 -0500", hash_original_field = "3F25451B046159B2132C4100362049AE", hash_generated_field = "200C54AE573D3744441934A403CEA512")

    private DrawData mLoadedPicture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.633 -0500", hash_original_field = "2566C588E6FF76067851190285C7A7E7", hash_generated_field = "0BBC35906DDA57724DA9629F2934A2C3")

    private Message mListBoxMessage;

    /**
     * Construct a new WebView with a Context object.
     * @param context A Context object used to access application assets.
     */
    @DSComment("Webview display, no IO access to outside world")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.378 -0500", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "94935CB70AC87EEF477D2A7E00A939D8")
    
public WebView(Context context) {
        this(context, null);
    }

    /**
     * Construct a new WebView with layout parameters.
     * @param context A Context object used to access application assets.
     * @param attrs An AttributeSet passed to our parent.
     */
    @DSComment("Webview display, no IO access to outside world")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.381 -0500", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "43DB8C8BA5135CBEB119F61A45FD4BC7")
    
public WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
    }

    /**
     * Construct a new WebView with layout parameters and a default style.
     * @param context A Context object used to access application assets.
     * @param attrs An AttributeSet passed to our parent.
     * @param defStyle The default style resource ID.
     */
    @DSComment("Webview display, no IO access to outside world")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.383 -0500", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "EA32C4710F079B331868A4E93EB1D69F")
    
public WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
    }

    /**
     * Construct a new WebView with layout parameters and a default style.
     * @param context A Context object used to access application assets.
     * @param attrs An AttributeSet passed to our parent.
     * @param defStyle The default style resource ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.386 -0500", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "472B30A2BCF3E9725DD6B03E7F6660A4")
    
public WebView(Context context, AttributeSet attrs, int defStyle,
            boolean privateBrowsing) {
        this(context, attrs, defStyle, null, privateBrowsing);
    }

    /**
     * Construct a new WebView with layout parameters, a default style and a set
     * of custom Javscript interfaces to be added to the WebView at initialization
     * time. This guarantees that these interfaces will be available when the JS
     * context is initialized.
     * @param context A Context object used to access application assets.
     * @param attrs An AttributeSet passed to our parent.
     * @param defStyle The default style resource ID.
     * @param javaScriptInterfaces is a Map of interface names, as keys, and
     * object implementing those interfaces, as values.
     * @hide pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.389 -0500", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "5451A5B54663C331B2485EB67A485CC5")
    
protected WebView(Context context, AttributeSet attrs, int defStyle,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyle);
        checkThread();

        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }

        // Used by the chrome stack to find application paths
        JniUtil.setContext(context);

        mCallbackProxy = new CallbackProxy(context, this);
        mViewManager = new ViewManager(this);
        L10nUtils.setApplicationContext(context.getApplicationContext());
        mWebViewCore = new WebViewCore(context, this, mCallbackProxy, javaScriptInterfaces);
        mDatabase = WebViewDatabase.getInstance(context);
        mScroller = new OverScroller(context, null, 0, 0, false); //TODO Use OverScroller's flywheel
        mZoomManager = new ZoomManager(this, mCallbackProxy);

        /* The init method must follow the creation of certain member variables,
         * such as the mZoomManager.
         */
        init();
        setupPackageListener(context);
        setupProxyListener(context);
        updateMultiTouchSupport(context);

        if (privateBrowsing) {
            startPrivateBrowsing();
        }

        mAutoFillData = new WebViewCore.AutoFillData();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.872 -0500", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "1AA2C9794D97C2364A0DADD5E85D90A7")
    
void incrementTextGeneration() { mTextGeneration++; }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.424 -0500", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "C69F8D11183EFD0128E246BE2FA68162")
    
private void setupPackageListener(Context context) {

        /*
         * we must synchronize the instance check and the creation of the
         * receiver to ensure that only ONE receiver exists for all WebView
         * instances.
         */
        synchronized (WebView.class) {

            // if the receiver already exists then we do not need to register it
            // again
            if (sPackageInstallationReceiverAdded) {
                return;
            }

            IntentFilter filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addDataScheme("package");
            BroadcastReceiver packageListener = new PackageListener();
            context.getApplicationContext().registerReceiver(packageListener, filter);
            sPackageInstallationReceiverAdded = true;
        }

        // check if any of the monitored apps are already installed
        AsyncTask<Void, Void, Set<String>> task = new AsyncTask<Void, Void, Set<String>>() {

            @Override
            protected Set<String> doInBackground(Void... unused) {
                Set<String> installedPackages = new HashSet<String>();
                PackageManager pm = mContext.getPackageManager();
                for (String name : sGoogleApps) {
                    try {
                        PackageInfo pInfo = pm.getPackageInfo(name,
                                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
                        installedPackages.add(name);
                    } catch (PackageManager.NameNotFoundException e) {
                        // package not found
                    }
                }
                return installedPackages;
            }

            // Executes on the UI thread
            @Override
            protected void onPostExecute(Set<String> installedPackages) {
                if (mWebViewCore != null) {
                    mWebViewCore.sendMessage(EventHub.ADD_PACKAGE_NAMES, installedPackages);
                }
            }
        };
        task.execute();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.426 -0500", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "D171E06F145F8F81C3868B74C7C19479")
    
void updateMultiTouchSupport(Context context) {
        mZoomManager.updateMultiTouchSupport(context);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.429 -0500", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "237670CA3BED798B9954C4B3A7008078")
    
private void init() {
        OnTrimMemoryListener.init(getContext());

        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);

        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        int slop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = slop * slop;
        slop = configuration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = slop * slop;
        final float density = getContext().getResources().getDisplayMetrics().density;
        // use one line height, 16 based on our current default font, for how
        // far we allow a touch be away from the edge of a link
        mNavSlop = (int) (16 * density);
        mZoomManager.init(density);
        mMaximumFling = configuration.getScaledMaximumFlingVelocity();

        // Compute the inverse of the density squared.
        DRAG_LAYER_INVERSE_DENSITY_SQUARED = 1 / (density * density);

        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();

        setScrollBarStyle(super.getScrollBarStyle());
        // Initially use a size of two, since the user is likely to only hold
        // down two keys at a time (shift + another key)
        mKeysPressed = new Vector<Integer>(2);
        mHTML5VideoViewProxy = null ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.431 -0500", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "A772FDD7D6140F1318D1965F00562411")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /**
     * Adds accessibility APIs to JavaScript.
     *
     * Note: This method is responsible to performing the necessary
     *       check if the accessibility APIs should be exposed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.433 -0500", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "9C3495481067D050AC9D1F0627D3E9C9")
    
private void addAccessibilityApisToJavaScript() {
        if (AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled()) {
            // exposing the TTS for now ...
            final Context ctx = getContext();
            if (ctx != null) {
                final String packageName = ctx.getPackageName();
                if (packageName != null) {
                    mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            packageName + ".**webview**");
                    addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                }
            }
        }
    }

    /**
     * Removes accessibility APIs from JavaScript.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.435 -0500", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "0908686BF573E7D3F2B71D7A848E85BC")
    
private void removeAccessibilityApisFromJavaScript() {
        // exposing the TTS for now ...
        if (mTextToSpeech != null) {
            removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.438 -0500", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "9C9869D5AF6C8E3B7105A50B3FA9F062")
    
@Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.441 -0500", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "BBE01BA2FD3032ACC5E9AE713CDD9523")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        final int convertedContentWidth = contentToViewX(getContentWidth());
        final int adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        final int convertedContentHeight = contentToViewY(getContentHeight());
        final int adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.443 -0500", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "F2048AB6067CFB9A1D5C72929C448A73")
    
private boolean isScrollableForAccessibility() {
        return (contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.446 -0500", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "A9A3F5834D6532D7E3329353C7A555B3")
    
@Override
    public void setOverScrollMode(int mode) {
        super.setOverScrollMode(mode);
        if (mode != OVER_SCROLL_NEVER) {
            if (mOverScrollGlow == null) {
                mOverScrollGlow = new OverScrollGlow(this);
            }
        } else {
            mOverScrollGlow = null;
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.448 -0500", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "BA4B31C47DE4BA2971C30454C84EA63B")
    
void adjustDefaultZoomDensity(int zoomDensity) {
        final float density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.449 -0500", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "7567DCE8E5EACCE5FE0A82F6C23C0491")
    
void updateDefaultZoomDensity(float density) {
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
    }

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.466 -0500", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "35BD1D8EAB003F2908D426971C4634CF")
    
boolean onSavePassword(String schemePlusHost, String username,
            String password, final Message resumeMsg) {
       boolean rVal = false;
       if (resumeMsg == null) {
           // null resumeMsg implies saving password silently
           mDatabase.setUsernamePassword(schemePlusHost, username, password);
       } else {
            final Message remember = mPrivateHandler.obtainMessage(
                    REMEMBER_PASSWORD);
            remember.getData().putString("host", schemePlusHost);
            remember.getData().putString("username", username);
            remember.getData().putString("password", password);
            remember.obj = resumeMsg;

            final Message neverRemember = mPrivateHandler.obtainMessage(
                    NEVER_REMEMBER_PASSWORD);
            neverRemember.getData().putString("host", schemePlusHost);
            neverRemember.getData().putString("username", username);
            neverRemember.getData().putString("password", password);
            neverRemember.obj = resumeMsg;

            new AlertDialog.Builder(getContext())
                    .setTitle(com.android.internal.R.string.save_password_label)
                    .setMessage(com.android.internal.R.string.save_password_message)
                    .setPositiveButton(com.android.internal.R.string.save_password_notnow,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            resumeMsg.sendToTarget();
                        }
                    })
                    .setNeutralButton(com.android.internal.R.string.save_password_remember,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            remember.sendToTarget();
                        }
                    })
                    .setNegativeButton(com.android.internal.R.string.save_password_never,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            neverRemember.sendToTarget();
                        }
                    })
                    .setOnCancelListener(new OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            resumeMsg.sendToTarget();
                        }
                    }).show();
            // Return true so that WebViewCore will pause while the dialog is
            // up.
            rVal = true;
        }
       return rVal;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.468 -0500", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "0A0ED11EBC73AD94DD08C440385BAC74")
    
@Override
    public void setScrollBarStyle(int style) {
        if (style == View.SCROLLBARS_INSIDE_INSET
                || style == View.SCROLLBARS_OUTSIDE_INSET) {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        } else {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        }
        super.setScrollBarStyle(style);
    }

    /**
     * Specify whether the horizontal scrollbar has overlay style.
     * @param overlay TRUE if horizontal scrollbar should have overlay style.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.470 -0500", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "21703057F2A35A4D675BF414B5EA11EC")
    
public void setHorizontalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayHorizontalScrollbar = overlay;
    }

    /**
     * Specify whether the vertical scrollbar has overlay style.
     * @param overlay TRUE if vertical scrollbar should have overlay style.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.473 -0500", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "33BE12E87D717C855E56F47214AAD605")
    
public void setVerticalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayVerticalScrollbar = overlay;
    }

    /**
     * Return whether horizontal scrollbar has overlay style
     * @return TRUE if horizontal scrollbar has overlay style.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.475 -0500", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "C5A0C4F505BB4BFAF3874B566BC1AA4B")
    
public boolean overlayHorizontalScrollbar() {
        checkThread();
        return mOverlayHorizontalScrollbar;
    }

    /**
     * Return whether vertical scrollbar has overlay style
     * @return TRUE if vertical scrollbar has overlay style.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.478 -0500", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "5D9EA300C172FA57EC7D6F9B137A68B4")
    
public boolean overlayVerticalScrollbar() {
        checkThread();
        return mOverlayVerticalScrollbar;
    }

    /*
     * Return the width of the view where the content of WebView should render
     * to.
     * Note: this can be called from WebCoreThread.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.480 -0500", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "3E12E9F04DFD10E2EA667E9B6D755EF7")
    
int getViewWidth() {
        if (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar) {
            return getWidth();
        } else {
            return Math.max(0, getWidth() - getVerticalScrollbarWidth());
        }
    }

    /**
     * returns the height of the titlebarview (if any). Does not care about
     * scrolling
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.482 -0500", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "1E4FFB1D8A95745B5150056D938A9A00")
    
protected int getTitleHeight() {
        return mTitleBar != null ? mTitleBar.getHeight() : 0;
    }

    /**
     * Return the amount of the titlebarview (if any) that is visible
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.484 -0500", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "8FEF6CB4E4BB3A5D8F7D7506ECFF7D30")
    
public int getVisibleTitleHeight() {
        checkThread();
        return getVisibleTitleHeightImpl();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.486 -0500", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "49A382AB95670BA962C97075DB4AFE79")
    
private int getVisibleTitleHeightImpl() {
        // need to restrict mScrollY due to over scroll
        return Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.490 -0500", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "5F9ECA2C0F8BDD6D09C96D4D1F660B85")
    
private int getOverlappingActionModeHeight() {
        if (mFindCallback == null) {
            return 0;
        }
        if (mCachedOverlappingActionModeHeight < 0) {
            getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            mCachedOverlappingActionModeHeight = Math.max(0,
                    mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        }
        return mCachedOverlappingActionModeHeight;
    }

    /*
     * Return the height of the view where the content of WebView should render
     * to.  Note that this excludes mTitleBar, if there is one.
     * Note: this can be called from WebCoreThread.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.492 -0500", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "16F04C5EBC3B8E93A1D61DBBB33F796C")
    
int getViewHeight() {
        return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.494 -0500", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "F3F8EC43F8C9AD092589A17909A5F537")
    
int getViewHeightWithTitle() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar) {
            height -= getHorizontalScrollbarHeight();
        }
        return height;
    }

    /**
     * @return The SSL certificate for the main top-level page or null if
     * there is no certificate (the site is not secure).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.496 -0500", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "D941CDE9C26B68DCB706441D31F03D27")
    
public SslCertificate getCertificate() {
        checkThread();
        return mCertificate;
    }

    /**
     * Sets the SSL certificate for the main top-level page.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.498 -0500", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "022380724AE1DF7EC69704110ED4A6D0")
    
public void setCertificate(SslCertificate certificate) {
        checkThread();
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "setCertificate=" + certificate);
        }
        // here, the certificate can be null (if the site is not secure)
        mCertificate = certificate;
    }

    //-------------------------------------------------------------------------
    // Methods called by activity
    //-------------------------------------------------------------------------

    /**
     * Save the username and password for a particular host in the WebView's
     * internal database.
     * @param host The host that required the credentials.
     * @param username The username for the given host.
     * @param password The password for the given host.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.501 -0500", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "DCE70F7D8B048425164C9BFABA4B339A")
    
public void savePassword(String host, String username, String password) {
        checkThread();
        mDatabase.setUsernamePassword(host, username, password);
    }

    /**
     * Set the HTTP authentication credentials for a given host and realm.
     *
     * @param host The host for the credentials.
     * @param realm The realm for the credentials.
     * @param username The username for the password. If it is null, it means
     *                 password can't be saved.
     * @param password The password
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.503 -0500", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "5B3154C7A2F4E54356EE4258F81BBF6F")
    
public void setHttpAuthUsernamePassword(String host, String realm,
            String username, String password) {
        checkThread();
        mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
    }

    /**
     * Retrieve the HTTP authentication username and password for a given
     * host & realm pair
     *
     * @param host The host for which the credentials apply.
     * @param realm The realm for which the credentials apply.
     * @return String[] if found, String[0] is username, which can be null and
     *         String[1] is password. Return null if it can't find anything.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.506 -0500", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "9D31C73646B1A70D9F25CA4D7C8FC1AC")
    
public String[] getHttpAuthUsernamePassword(String host, String realm) {
        checkThread();
        return mDatabase.getHttpAuthUsernamePassword(host, realm);
    }

    /**
     * Remove Find or Select ActionModes, if active.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.508 -0500", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "55EF3F7A96F2B960628A9ADBE036EAB9")
    
private void clearActionModes() {
        if (mSelectCallback != null) {
            mSelectCallback.finish();
        }
        if (mFindCallback != null) {
            mFindCallback.finish();
        }
    }

    /**
     * Called to clear state when moving from one page to another, or changing
     * in some other way that makes elements associated with the current page
     * (such as WebTextView or ActionModes) no longer relevant.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.510 -0500", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "2F4CE7F6E21CB586C2093CA7D81F9A58")
    
private void clearHelpers() {
        clearTextEntry();
        clearActionModes();
        dismissFullScreenMode();
        cancelSelectDialog();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.513 -0500", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "1958BDA0AAADE97223B4E57910872AF9")
    
private void cancelSelectDialog() {
        if (mListBoxDialog != null) {
            mListBoxDialog.cancel();
            mListBoxDialog = null;
        }
    }

    /**
     * Destroy the internal state of the WebView. This method should be called
     * after the WebView has been removed from the view system. No other
     * methods may be called on a WebView after destroy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.515 -0500", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "2796AC4C6D6DEB5492E837EF4AA2FCC0")
    
public void destroy() {
        checkThread();
        destroyImpl();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.518 -0500", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "A4EA8150DDD464FEC035FB6211F6BE57")
    
private void destroyImpl() {
        clearHelpers();
        if (mListBoxDialog != null) {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        }
        // remove so that it doesn't cause events
        if (mWebTextView != null) {
            mWebTextView.remove();
            mWebTextView = null;
        }
        if (mNativeClass != 0) nativeStopGL();
        if (mWebViewCore != null) {
            // Set the handlers to null before destroying WebViewCore so no
            // more messages will be posted.
            mCallbackProxy.setWebViewClient(null);
            mCallbackProxy.setWebChromeClient(null);
            // Tell WebViewCore to destroy itself
            synchronized (this) {
                WebViewCore webViewCore = mWebViewCore;
                mWebViewCore = null; // prevent using partial webViewCore
                webViewCore.destroy();
            }
            // Remove any pending messages that might not be serviced yet.
            mPrivateHandler.removeCallbacksAndMessages(null);
            mCallbackProxy.removeCallbacksAndMessages(null);
            // Wake up the WebCore thread just in case it is waiting for a
            // JavaScript dialog.
            synchronized (mCallbackProxy) {
                mCallbackProxy.notify();
            }
        }
        if (mNativeClass != 0) {
            nativeDestroy();
            mNativeClass = 0;
        }
    }

    /**
     * Sets JavaScript engine flags.
     *
     * @param flags JS engine flags in a String
     *
     * @hide pending API solidification
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.525 -0500", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "313F8FD922ADDC4FC386024DA05F2E06")
    
public void setJsFlags(String flags) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
    }

    /**
     * Inform WebView of the network state. This is used to set
     * the JavaScript property window.navigator.isOnline and
     * generates the online/offline event as specified in HTML5, sec. 5.7.7
     * @param networkUp boolean indicating if network is available
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.527 -0500", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "C4FB567BD9DB029C43008B7C7E3A025F")
    
public void setNetworkAvailable(boolean networkUp) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                networkUp ? 1 : 0, 0);
    }

    /**
     * Inform WebView about the current network type.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.529 -0500", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "AFB7882F78099C3405A98A50951EF7A2")
    
public void setNetworkType(String type, String subtype) {
        checkThread();
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("subtype", subtype);
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
    }
    /**
     * Save the state of this WebView used in
     * {@link android.app.Activity#onSaveInstanceState}. Please note that this
     * method no longer stores the display data for this WebView. The previous
     * behavior could potentially leak files if {@link #restoreState} was never
     * called. See {@link #savePicture} and {@link #restorePicture} for saving
     * and restoring the display data.
     * @param outState The Bundle to store the WebView state.
     * @return The same copy of the back/forward list used to save the state. If
     *         saveState fails, the returned list will be null.
     * @see #savePicture
     * @see #restorePicture
     */
    @DSComment("Storage access indirectly")
    @DSSpec(DSCat.STORAGE_ACCESS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.533 -0500", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "BE9ECAD12A01D1D3F1757D031FD2DCD0")
    
public WebBackForwardList saveState(Bundle outState) {
        checkThread();
        if (outState == null) {
            return null;
        }
        // We grab a copy of the back/forward list because a client of WebView
        // may have invalidated the history list by calling clearHistory.
        WebBackForwardList list = copyBackForwardList();
        final int currentIndex = list.getCurrentIndex();
        final int size = list.getSize();
        // We should fail saving the state if the list is empty or the index is
        // not in a valid range.
        if (currentIndex < 0 || currentIndex >= size || size == 0) {
            return null;
        }
        outState.putInt("index", currentIndex);
        // FIXME: This should just be a byte[][] instead of ArrayList but
        // Parcel.java does not have the code to handle multi-dimensional
        // arrays.
        ArrayList<byte[]> history = new ArrayList<byte[]>(size);
        for (int i = 0; i < size; i++) {
            WebHistoryItem item = list.getItemAtIndex(i);
            if (null == item) {
                // FIXME: this shouldn't happen
                // need to determine how item got set to null
                Log.w(LOGTAG, "saveState: Unexpected null history item.");
                return null;
            }
            byte[] data = item.getFlattenedData();
            if (data == null) {
                // It would be very odd to not have any data for a given history
                // item. And we will fail to rebuild the history list without
                // flattened data.
                return null;
            }
            history.add(data);
        }
        outState.putSerializable("history", history);
        if (mCertificate != null) {
            outState.putBundle("certificate",
                               SslCertificate.saveState(mCertificate));
        }
        outState.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(outState);
        return list;
    }

    /**
     * Save the current display data to the Bundle given. Used in conjunction
     * with {@link #saveState}.
     * @param b A Bundle to store the display data.
     * @param dest The file to store the serialized picture data. Will be
     *             overwritten with this WebView's picture data.
     * @return True if the picture was successfully saved.
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.540 -0500", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "694F210E7FB41288B808C736FA66E7C6")
    
@Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        checkThread();
        if (dest == null || b == null) {
            return false;
        }
        final Picture p = capturePicture();
        // Use a temporary file while writing to ensure the destination file
        // contains valid data.
        final File temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {
            public void run() {
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(temp);
                    p.writeToStream(out);
                    // Writing the picture succeeded, rename the temporary file
                    // to the destination.
                    temp.renameTo(dest);
                } catch (Exception e) {
                    // too late to do anything about it.
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception e) {
                            // Can't do anything about that
                        }
                    }
                    temp.delete();
                }
            }
        }).start();
        // now update the bundle
        b.putInt("scrollX", mScrollX);
        b.putInt("scrollY", mScrollY);
        mZoomManager.saveZoomState(b);
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.542 -0500", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "CB76D97F1A521C92FC5ED0687FDE0D4E")
    
private void restoreHistoryPictureFields(Picture p, Bundle b) {
        int sx = b.getInt("scrollX", 0);
        int sy = b.getInt("scrollY", 0);

        mDrawHistory = true;
        mHistoryPicture = p;

        mScrollX = sx;
        mScrollY = sy;
        mZoomManager.restoreZoomState(b);
        final float scale = mZoomManager.getScale();
        mHistoryWidth = Math.round(p.getWidth() * scale);
        mHistoryHeight = Math.round(p.getHeight() * scale);

        invalidate();
    }

    /**
     * Restore the display data that was save in {@link #savePicture}. Used in
     * conjunction with {@link #restoreState}.
     *
     * Note that this will not work if the WebView is hardware accelerated.
     * @param b A Bundle containing the saved display data.
     * @param src The file where the picture data was stored.
     * @return True if the picture was successfully restored.
     * @deprecated This method is now obsolete.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.552 -0500", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "0EF4CA64CA7B36D278D473D83D2E8541")
    
@Deprecated
    public boolean restorePicture(Bundle b, File src) {
        checkThread();
        if (src == null || b == null) {
            return false;
        }
        if (!src.exists()) {
            return false;
        }
        try {
            final FileInputStream in = new FileInputStream(src);
            final Bundle copy = new Bundle(b);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final Picture p = Picture.createFromStream(in);
                        if (p != null) {
                            // Post a runnable on the main thread to update the
                            // history picture fields.
                            mPrivateHandler.post(new Runnable() {
                                public void run() {
                                    restoreHistoryPictureFields(p, copy);
                                }
                            });
                        }
                    } finally {
                        try {
                            in.close();
                        } catch (Exception e) {
                            // Nothing we can do now.
                        }
                    }
                }
            }).start();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Saves the view data to the output stream. The output is highly
     * version specific, and may not be able to be loaded by newer versions
     * of WebView.
     * @param stream The {@link OutputStream} to save to
     * @return True if saved successfully
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.555 -0500", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "132EAB4582DEB52238266A662B7A3CEE")
    
public boolean saveViewState(OutputStream stream) {
        try {
            return ViewStateSerializer.serializeViewState(stream, this);
        } catch (IOException e) {
            Log.w(LOGTAG, "Failed to saveViewState", e);
        }
        return false;
    }

    /**
     * Loads the view data from the input stream. See
     * {@link #saveViewState(OutputStream)} for more information.
     * @param stream The {@link InputStream} to load from
     * @return True if loaded successfully
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.557 -0500", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "041005B3E900303968113A8B03693D1B")
    
public boolean loadViewState(InputStream stream) {
        try {
            mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            mBlockWebkitViewMessages = true;
            setNewPicture(mLoadedPicture, true);
            mLoadedPicture.mViewState = null;
            return true;
        } catch (IOException e) {
            Log.w(LOGTAG, "Failed to loadViewState", e);
        }
        return false;
    }

    /**
     * Clears the view state set with {@link #loadViewState(InputStream)}.
     * This WebView will then switch to showing the content from webkit
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.559 -0500", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "0BFAB6C2D17D2CF196C0FAF2AF024790")
    
public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
    }

    /**
     * Restore the state of this WebView from the given map used in
     * {@link android.app.Activity#onRestoreInstanceState}. This method should
     * be called to restore the state of the WebView before using the object. If
     * it is called after the WebView has had a chance to build state (load
     * pages, create a back/forward list, etc.) there may be undesirable
     * side-effects. Please note that this method no longer restores the
     * display data for this WebView. See {@link #savePicture} and {@link
     * #restorePicture} for saving and restoring the display data.
     * @param inState The incoming Bundle of state.
     * @return The restored back/forward list or null if restoreState failed.
     * @see #savePicture
     * @see #restorePicture
     */
    @DSComment("Storage access indirectly")
    @DSSpec(DSCat.STORAGE_ACCESS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.563 -0500", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "54F47ABA8CB052ABA402D246AF43C583")
    
public WebBackForwardList restoreState(Bundle inState) {
        checkThread();
        WebBackForwardList returnList = null;
        if (inState == null) {
            return returnList;
        }
        if (inState.containsKey("index") && inState.containsKey("history")) {
            mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));

            final WebBackForwardList list = mCallbackProxy.getBackForwardList();
            final int index = inState.getInt("index");
            // We can't use a clone of the list because we need to modify the
            // shared copy, so synchronize instead to prevent concurrent
            // modifications.
            synchronized (list) {
                final List<byte[]> history =
                        (List<byte[]>) inState.getSerializable("history");
                final int size = history.size();
                // Check the index bounds so we don't crash in native code while
                // restoring the history index.
                if (index < 0 || index >= size) {
                    return null;
                }
                for (int i = 0; i < size; i++) {
                    byte[] data = history.remove(0);
                    if (data == null) {
                        // If we somehow have null data, we cannot reconstruct
                        // the item and thus our history list cannot be rebuilt.
                        return null;
                    }
                    WebHistoryItem item = new WebHistoryItem(data);
                    list.addHistoryItem(item);
                }
                // Grab the most recent copy to return to the caller.
                returnList = copyBackForwardList();
                // Update the copy to have the correct index.
                returnList.setCurrentIndex(index);
            }
            // Restore private browsing setting.
            if (inState.getBoolean("privateBrowsingEnabled")) {
                getSettings().setPrivateBrowsingEnabled(true);
            }
            mZoomManager.restoreZoomState(inState);
            // Remove all pending messages because we are restoring previous
            // state.
            mWebViewCore.removeMessages();
            // Send a restore state message.
            mWebViewCore.sendMessage(EventHub.RESTORE_STATE, index);
        }
        return returnList;
    }

    /**
     * Load the given URL with the specified additional HTTP headers.
     * @param url The URL of the resource to load.
     * @param additionalHttpHeaders The additional headers to be used in the
     *            HTTP request for this URL, specified as a map from name to
     *            value. Note that if this map contains any of the headers
     *            that are set by default by the WebView, such as those
     *            controlling caching, accept types or the User-Agent, their
     *            values may be overriden by the WebView's defaults.
     */
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.565 -0500", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "5B9D1B63FC1E7B285328458907CCA0A9")
    
public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
    }

    @DSVerified
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.567 -0500", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "9DC311FFA850B862423B38D4B91018ED")
    
private void loadUrlImpl(String url, Map<String, String> extraHeaders) {
        switchOutDrawHistory();
        WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        arg.mUrl = url;
        arg.mExtraHeaders = extraHeaders;
        mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        WebViewClient client = getWebViewClient();
        client.onLoadResource(this, url);
        client.onPageFinished(this, url);
        client.onReceivedError(this, DSUtils.FAKE_INT, new String(), url);
        //clearHelpers();
    }

    /**
     * Load the given URL.
     * @param url The URL of the resource to load.
     */
    @DSComment("I/O load/store/Internet")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.569 -0500", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "AACBEEE0E28FE1B64F1E9BC46034B940")
    @DSVerified
public void loadUrl(String url) {
        checkThread();
        loadUrlImpl(url);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.571 -0500", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "01ADABB1756CCB934FAEC213819353E2")
    @DSVerified
    
private void loadUrlImpl(String url) {
        if (url == null) {
            return;
        }
        loadUrlImpl(url, null);
    }

    /**
     * Load the url with postData using "POST" method into the WebView. If url
     * is not a network url, it will be loaded with {link
     * {@link #loadUrl(String)} instead.
     *
     * @param url The url of the resource to load.
     * @param postData The data will be passed to "POST" request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.573 -0500", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "BDA72B4C0B750A07FE4F609C9A662AA6")
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public void postUrl(String url, byte[] postData) {
        checkThread();
        if (URLUtil.isNetworkUrl(url)) {
            switchOutDrawHistory();
            WebViewCore.PostUrlData arg = new WebViewCore.PostUrlData();
            arg.mUrl = url;
            arg.mPostData = postData;
            mWebViewCore.sendMessage(EventHub.POST_URL, arg);
            clearHelpers();
        } else {
            loadUrlImpl(url);
        }
    }

    /**
     * Load the given data into the WebView using a 'data' scheme URL.
     * <p>
     * Note that JavaScript's same origin policy means that script running in a
     * page loaded using this method will be unable to access content loaded
     * using any scheme other than 'data', including 'http(s)'. To avoid this
     * restriction, use {@link
     * #loadDataWithBaseURL(String,String,String,String,String)
     * loadDataWithBaseURL()} with an appropriate base URL.
     * <p>
     * If the value of the encoding parameter is 'base64', then the data must
     * be encoded as base64. Otherwise, the data must use ASCII encoding for
     * octets inside the range of safe URL characters and use the standard %xx
     * hex encoding of URLs for octets outside that range. For example,
     * '#', '%', '\', '?' should be replaced by %23, %25, %27, %3f respectively.
     * <p>
     * The 'data' scheme URL formed by this method uses the default US-ASCII
     * charset. If you need need to set a different charset, you should form a
     * 'data' scheme URL which explicitly specifies a charset parameter in the
     * mediatype portion of the URL and call {@link #loadUrl(String)} instead.
     * Note that the charset obtained from the mediatype portion of a data URL
     * always overrides that specified in the HTML or XML document itself.
     * @param data A String of data in the given encoding.
     * @param mimeType The MIME type of the data, e.g. 'text/html'.
     * @param encoding The encoding of the data.
     */
    @DSComment("I/O load/store")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.576 -0500", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "7129D2CE5481188BA506D152E5DF4298")
    
public void loadData(String data, String mimeType, String encoding) {
        loadDataImpl(data, mimeType, encoding);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.578 -0500", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "27ADCFF7BAE7DE9FD5985643C04553C2")
    
private void loadDataImpl(String data, String mimeType, String encoding) {
        StringBuilder dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        if ("base64".equals(encoding)) {
            dataUrl.append(";base64");
        }
        dataUrl.append(",");
        dataUrl.append(data);
        loadUrlImpl(dataUrl.toString());
    }

    /**
     * Load the given data into the WebView, using baseUrl as the base URL for
     * the content. The base URL is used both to resolve relative URLs and when
     * applying JavaScript's same origin policy. The historyUrl is used for the
     * history entry.
     * <p>
     * Note that content specified in this way can access local device files
     * (via 'file' scheme URLs) only if baseUrl specifies a scheme other than
     * 'http', 'https', 'ftp', 'ftps', 'about' or 'javascript'.
     * <p>
     * If the base URL uses the data scheme, this method is equivalent to
     * calling {@link #loadData(String,String,String) loadData()} and the
     * historyUrl is ignored.
     * @param baseUrl URL to use as the page's base URL. If null defaults to
     *            'about:blank'
     * @param data A String of data in the given encoding.
     * @param mimeType The MIMEType of the data, e.g. 'text/html'. If null,
     *            defaults to 'text/html'.
     * @param encoding The encoding of the data.
     * @param historyUrl URL to use as the history entry, if null defaults to
     *            'about:blank'.
     */
    @DSComment("I/O load/store/Internet")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.581 -0500", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "89BE15BE04FA3CB1EBB257D74C48283E")
    
public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        checkThread();

        if (baseUrl != null && baseUrl.toLowerCase().startsWith("data:")) {
            loadDataImpl(data, mimeType, encoding);
            return;
        }
        switchOutDrawHistory();
        WebViewCore.BaseUrlData arg = new WebViewCore.BaseUrlData();
        arg.mBaseUrl = baseUrl;
        arg.mData = data;
        arg.mMimeType = mimeType;
        arg.mEncoding = encoding;
        arg.mHistoryUrl = historyUrl;
        mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        clearHelpers();
    }

    /**
     * Saves the current view as a web archive.
     *
     * @param filename The filename where the archive should be placed.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.583 -0500", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "224FBE9D1D33F8B534D7E01F2035F554")
    
public void saveWebArchive(String filename) {
        checkThread();
        saveWebArchiveImpl(filename, false, null);
    }

    /**
     * Saves the current view as a web archive.
     *
     * @param basename The filename where the archive should be placed.
     * @param autoname If false, takes basename to be a file. If true, basename
     *                 is assumed to be a directory in which a filename will be
     *                 chosen according to the url of the current page.
     * @param callback Called after the web archive has been saved. The
     *                 parameter for onReceiveValue will either be the filename
     *                 under which the file was saved, or null if saving the
     *                 file failed.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.599 -0500", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "FBFD33E9478DDA726A4B14BBDD4B02E5")
    
public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.601 -0500", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "90ADF750116F14CCF3A683ECAB4CA0C9")
    
private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
    }

    /**
     * Stop the current load.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.604 -0500", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "9717326FEEF34853A925E1939B66447F")
    
public void stopLoading() {
        checkThread();
        // TODO: should we clear all the messages in the queue before sending
        // STOP_LOADING?
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
    }

    /**
     * Reload the current url.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.606 -0500", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "5F5638F28E9C0FFF9AA6B8A4D8FA6E4D")
    
public void reload() {
        checkThread();
        clearHelpers();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.RELOAD);
    }

    /**
     * Return true if this WebView has a back history item.
     * @return True iff this WebView has a back history item.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.609 -0500", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "BEDE549A4BAFA5CCD660B7D3056AD972")
    
public boolean canGoBack() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized (l) {
            if (l.getClearPending()) {
                return false;
            } else {
                return l.getCurrentIndex() > 0;
            }
        }
    }

    /**
     * Go back in the history of this WebView.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.611 -0500", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "18A10E214FD6EAE3B511451CDCE1E568")
    
public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
    }

    /**
     * Return true if this WebView has a forward history item.
     * @return True iff this Webview has a forward history item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.613 -0500", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "79CE959C900EDF44FAAE723F49DA1C13")
    
public boolean canGoForward() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized (l) {
            if (l.getClearPending()) {
                return false;
            } else {
                return l.getCurrentIndex() < l.getSize() - 1;
            }
        }
    }

    /**
     * Go forward in the history of this WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.615 -0500", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "AF71861260DCCDB38E607EE435555DE6")
    
public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
    }

    /**
     * Return true if the page can go back or forward the given
     * number of steps.
     * @param steps The negative or positive number of steps to move the
     *              history.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.617 -0500", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "708AF65EECCE0E62C9BE96DADF736B49")
    
public boolean canGoBackOrForward(int steps) {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized (l) {
            if (l.getClearPending()) {
                return false;
            } else {
                int newIndex = l.getCurrentIndex() + steps;
                return newIndex >= 0 && newIndex < l.getSize();
            }
        }
    }

    /**
     * Go to the history item that is the number of steps away from
     * the current item. Steps is negative if backward and positive
     * if forward.
     * @param steps The number of steps to take back or forward in the back
     *              forward list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.619 -0500", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "F455D95C10B4C2B0EE0847E9B209B48F")
    
public void goBackOrForward(int steps) {
        checkThread();
        goBackOrForwardImpl(steps);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.622 -0500", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "78A693FF66CC4E4C5CB260A270500B86")
    
private void goBackOrForwardImpl(int steps) {
        goBackOrForward(steps, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.624 -0500", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "3B0B2BFCA3AB8DB31D714E3E34D44B42")
    
private void goBackOrForward(int steps, boolean ignoreSnapshot) {
        if (steps != 0) {
            clearHelpers();
            mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    ignoreSnapshot ? 1 : 0);
        }
    }

    /**
     * Returns true if private browsing is enabled in this WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.626 -0500", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "0028B50FB1506D387F26A0B76932D66B")
    
public boolean isPrivateBrowsingEnabled() {
        checkThread();
        return getSettings().isPrivateBrowsingEnabled();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.628 -0500", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "515D050E8CAD6880C02F2655B5EC876E")
    
private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.631 -0500", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "9D4952453E9CEDB938C1750FB6E60502")
    
private boolean extendScroll(int y) {
        int finalY = mScroller.getFinalY();
        int newY = pinLocY(finalY + y);
        if (newY == finalY) return false;
        mScroller.setFinalY(newY);
        mScroller.extendDuration(computeDuration(0, y));
        return true;
    }

    /**
     * Scroll the contents of the view up by half the view size
     * @param top true to jump to the top of the page
     * @return true if the page was scrolled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.633 -0500", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "74C83EC35749C4A63C726DB5F8635E6B")
    
public boolean pageUp(boolean top) {
        checkThread();
        if (mNativeClass == 0) {
            return false;
        }
        nativeClearCursor(); // start next trackball movement from page edge
        if (top) {
            // go to the top of the document
            return pinScrollTo(mScrollX, 0, true, 0);
        }
        // Page up
        int h = getHeight();
        int y;
        if (h > 2 * PAGE_SCROLL_OVERLAP) {
            y = -h + PAGE_SCROLL_OVERLAP;
        } else {
            y = -h / 2;
        }
        return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                : extendScroll(y);
    }

    /**
     * Scroll the contents of the view down by half the page size
     * @param bottom true to jump to bottom of page
     * @return true if the page was scrolled
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.635 -0500", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "F6F74AE01233898F0996E6AE36F9881A")
    
public boolean pageDown(boolean bottom) {
        checkThread();
        if (mNativeClass == 0) {
            return false;
        }
        nativeClearCursor(); // start next trackball movement from page edge
        if (bottom) {
            return pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0);
        }
        // Page down.
        int h = getHeight();
        int y;
        if (h > 2 * PAGE_SCROLL_OVERLAP) {
            y = h - PAGE_SCROLL_OVERLAP;
        } else {
            y = h / 2;
        }
        return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                : extendScroll(y);
    }

    /**
     * Clear the view so that onDraw() will draw nothing but white background,
     * and onMeasure() will return 0 if MeasureSpec is not MeasureSpec.EXACTLY
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.638 -0500", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "C941652AC8217508613028CF9ECFAAAA")
    
public void clearView() {
        checkThread();
        mContentWidth = 0;
        mContentHeight = 0;
        setBaseLayer(0, null, false, false, false);
        mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
    }

    /**
     * Return a new picture that captures the current display of the webview.
     * This is a copy of the display, and will be unaffected if the webview
     * later loads a different URL.
     *
     * @return a picture containing the current contents of the view. Note this
     *         picture is of the entire document, and is not restricted to the
     *         bounds of the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.640 -0500", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "149ADDDA6D5264A0DCBCA182FDFFAF82")
    
public Picture capturePicture() {
        checkThread();
        if (mNativeClass == 0) return null;
        Picture result = new Picture();
        nativeCopyBaseContentToPicture(result);
        return result;
    }

    /**
     *  Return true if the browser is displaying a TextView for text input.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.642 -0500", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "410AB274DA47E4677D3226812443B143")
    
private boolean inEditingMode() {
        return mWebTextView != null && mWebTextView.getParent() != null;
    }

    /**
     * Remove the WebTextView.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.644 -0500", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "86BF06F48B0B6AE9E1B5319BC781F360")
    
private void clearTextEntry() {
        if (inEditingMode()) {
            mWebTextView.remove();
        } else {
            // The keyboard may be open with the WebView as the served view
            hideSoftKeyboard();
        }
    }

    /**
     * Return the current scale of the WebView
     * @return The current scale.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.646 -0500", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "4DC5F3DA68044F56F453CE22567A3B36")
    
public float getScale() {
        checkThread();
        return mZoomManager.getScale();
    }

    // Called by JNI. Returns the scale to apply to the text selection handles
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.648 -0500", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "8FE7DEBB03549EA34C695CA1BEB039D3")
    
float getTextHandleScale() {
        float density = mContext.getResources().getDisplayMetrics().density;
        return density / getScale();
    }

    /**
     * Return the reading level scale of the WebView
     * @return The reading level scale.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.651 -0500", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "53ABC037DDC33F33CA1EED7753E7BC53")
    
float getReadingLevelScale() {
        return mZoomManager.getReadingLevelScale();
    }

    /**
     * Set the initial scale for the WebView. 0 means default. If
     * {@link WebSettings#getUseWideViewPort()} is true, it zooms out all the
     * way. Otherwise it starts with 100%. If initial scale is greater than 0,
     * WebView starts with this value as initial scale.
     * Please note that unlike the scale properties in the viewport meta tag,
     * this method doesn't take the screen density into account.
     *
     * @param scaleInPercent The initial scale in percent.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.653 -0500", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "C8FF0437D49A072D9ADA314256540104")
    
public void setInitialScale(int scaleInPercent) {
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
    }

    /**
     * Invoke the graphical zoom picker widget for this WebView. This will
     * result in the zoom widget appearing on the screen to control the zoom
     * level of this WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.656 -0500", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "80D71798DF735A58F85344D890FE0D3F")
    
public void invokeZoomPicker() {
        checkThread();
        if (!getSettings().supportZoom()) {
            Log.w(LOGTAG, "This WebView doesn't support zoom.");
            return;
        }
        clearHelpers();
        mZoomManager.invokeZoomPicker();
    }

    /**
     * Return a HitTestResult based on the current cursor node. If a HTML::a tag
     * is found and the anchor has a non-JavaScript url, the HitTestResult type
     * is set to SRC_ANCHOR_TYPE and the url is set in the "extra" field. If the
     * anchor does not have a url or if it is a JavaScript url, the type will
     * be UNKNOWN_TYPE and the url has to be retrieved through
     * {@link #requestFocusNodeHref} asynchronously. If a HTML::img tag is
     * found, the HitTestResult type is set to IMAGE_TYPE and the url is set in
     * the "extra" field. A type of
     * SRC_IMAGE_ANCHOR_TYPE indicates an anchor with a url that has an image as
     * a child node. If a phone number is found, the HitTestResult type is set
     * to PHONE_TYPE and the phone number is set in the "extra" field of
     * HitTestResult. If a map address is found, the HitTestResult type is set
     * to GEO_TYPE and the address is set in the "extra" field of HitTestResult.
     * If an email address is found, the HitTestResult type is set to EMAIL_TYPE
     * and the email is set in the "extra" field of HitTestResult. Otherwise,
     * HitTestResult type is set to UNKNOWN_TYPE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.658 -0500", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "AB640BF3BF774D9077A21A1A84BD617F")
    
public HitTestResult getHitTestResult() {
        checkThread();
        return hitTestResult(mInitialHitTestResult);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.661 -0500", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "292FDCE1666485668703C5E9BABC5B4C")
    
private HitTestResult hitTestResult(HitTestResult fallback) {
        if (mNativeClass == 0) {
            return null;
        }

        HitTestResult result = new HitTestResult();
        if (nativeHasCursorNode()) {
            if (nativeCursorIsTextInput()) {
                result.setType(HitTestResult.EDIT_TEXT_TYPE);
            } else {
                String text = nativeCursorText();
                if (text != null) {
                    if (text.startsWith(SCHEME_TEL)) {
                        result.setType(HitTestResult.PHONE_TYPE);
                        result.setExtra(text.substring(SCHEME_TEL.length()));
                    } else if (text.startsWith(SCHEME_MAILTO)) {
                        result.setType(HitTestResult.EMAIL_TYPE);
                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                    } else if (text.startsWith(SCHEME_GEO)) {
                        result.setType(HitTestResult.GEO_TYPE);
                        result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                    } else if (nativeCursorIsAnchor()) {
                        result.setType(HitTestResult.SRC_ANCHOR_TYPE);
                        result.setExtra(text);
                    }
                }
            }
        } else if (fallback != null) {
            /* If webkit causes a rebuild while the long press is in progress,
             * the cursor node may be reset, even if it is still around. This
             * uses the cursor node saved when the touch began. Since the
             * nativeImageURI below only changes the result if it is successful,
             * this uses the data beneath the touch if available or the original
             * tap data otherwise.
             */
            Log.v(LOGTAG, "hitTestResult use fallback");
            result = fallback;
        }
        int type = result.getType();
        if (type == HitTestResult.UNKNOWN_TYPE
                || type == HitTestResult.SRC_ANCHOR_TYPE) {
            // Now check to see if it is an image.
            int contentX = viewToContentX(mLastTouchX + mScrollX);
            int contentY = viewToContentY(mLastTouchY + mScrollY);
            String text = nativeImageURI(contentX, contentY);
            if (text != null) {
                result.setType(type == HitTestResult.UNKNOWN_TYPE ?
                        HitTestResult.IMAGE_TYPE :
                        HitTestResult.SRC_IMAGE_ANCHOR_TYPE);
                result.setExtra(text);
            }
        }
        return result;
    }

    // Called by JNI when the DOM has changed the focus.  Clear the focus so
    // that new keys will go to the newly focused field
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.663 -0500", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "E16AB738538E695A48D3F856DE905DB2")
    
private void domChangedFocus() {
        if (inEditingMode()) {
            mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        }
    }
    /**
     * Request the anchor or image element URL at the last tapped point.
     * If hrefMsg is null, this method returns immediately and does not
     * dispatch hrefMsg to its target. If the tapped point hits an image,
     * an anchor, or an image in an anchor, the message associates
     * strings in named keys in its data. The value paired with the key
     * may be an empty string.
     *
     * @param hrefMsg This message will be dispatched with the result of the
     *                request. The message data contains three keys:
     *                - "url" returns the anchor's href attribute.
     *                - "title" returns the anchor's text.
     *                - "src" returns the image's src attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.666 -0500", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "B1EDED2EC3DC7211E9329E027FBAE902")
    
public void requestFocusNodeHref(Message hrefMsg) {
        checkThread();
        if (hrefMsg == null) {
            return;
        }
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        if (nativeHasCursorNode()) {
            Rect cursorBounds = nativeGetCursorRingBounds();
            if (!cursorBounds.contains(contentX, contentY)) {
                int slop = viewToContentDimension(mNavSlop);
                cursorBounds.inset(-slop, -slop);
                if (cursorBounds.contains(contentX, contentY)) {
                    contentX = (int) cursorBounds.centerX();
                    contentY = (int) cursorBounds.centerY();
                }
            }
        }
        mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                contentX, contentY, hrefMsg);
    }

    /**
     * Request the url of the image last touched by the user. msg will be sent
     * to its target with a String representing the url as its object.
     *
     * @param msg This message will be dispatched with the result of the request
     *            as the data member with "url" as key. The result can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.668 -0500", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "7BD81DF2330D7ABA5E13709A0D8D3C8B")
    
public void requestImageRef(Message msg) {
        checkThread();
        if (0 == mNativeClass) return; // client isn't initialized
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        String ref = nativeImageURI(contentX, contentY);
        Bundle data = msg.getData();
        data.putString("url", ref);
        msg.setData(data);
        msg.sendToTarget();
    }

    // Expects x in view coordinates
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.673 -0500", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "2E6BB99E9F0ADE9CFE2EB3651509758F")
    
int pinLocX(int x) {
        if (mInOverScrollMode) return x;
        return pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange());
    }

    // Expects y in view coordinates
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.675 -0500", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "A92B9630A61300140C3AE67C3AC12BE5")
    
int pinLocY(int y) {
        if (mInOverScrollMode) return y;
        return pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight());
    }

    /**
     * Add or remove a title bar to be embedded into the WebView, and scroll
     * along with it vertically, while remaining in view horizontally. Pass
     * null to remove the title bar from the WebView, and return to drawing
     * the WebView normally without translating to account for the title bar.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.681 -0500", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "C8ED96D759E48447757585FDAAB0061A")
    
public void setEmbeddedTitleBar(View v) {
        if (mTitleBar == v) return;
        if (mTitleBar != null) {
            removeView(mTitleBar);
        }
        if (null != v) {
            addView(v, new AbsoluteLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        }
        mTitleBar = v;
    }

    /**
     * Set where to render the embedded title bar
     * NO_GRAVITY at the top of the page
     * TOP        at the top of the screen
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.683 -0500", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "70B7C09BD4F41B796C260FD127AE6906")
    
public void setTitleBarGravity(int gravity) {
        mTitleGravity = gravity;
        // force refresh
        invalidate();
    }

    /**
     * Given a distance in view space, convert it to content space. Note: this
     * does not reflect translation, just scaling, so this should not be called
     * with coordinates, but should be called for dimensions like width or
     * height.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.685 -0500", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "C6B0522CCDD57EB69B14A75D599C7EA6")
    
private int viewToContentDimension(int d) {
        return Math.round(d * mZoomManager.getInvScale());
    }

    /**
     * Given an x coordinate in view space, convert it to content space.  Also
     * may be used for absolute heights (such as for the WebTextView's
     * textSize, which is unaffected by the height of the title bar).
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.688 -0500", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "35AD2AB5BD1F513BBF06CEB9122EB14F")
    
int viewToContentX(int x) {
        return viewToContentDimension(x);
    }

    /**
     * Given a y coordinate in view space, convert it to content space.
     * Takes into account the height of the title bar if there is one
     * embedded into the WebView.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.690 -0500", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "B6A85EDC570728FDA84445069164B6A2")
    
int viewToContentY(int y) {
        return viewToContentDimension(y - getTitleHeight());
    }

    /**
     * Given a x coordinate in view space, convert it to content space.
     * Returns the result as a float.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.692 -0500", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "7BDE7C0FA6FC4F1FBAF49B55F6CC592E")
    
private float viewToContentXf(int x) {
        return x * mZoomManager.getInvScale();
    }

    /**
     * Given a y coordinate in view space, convert it to content space.
     * Takes into account the height of the title bar if there is one
     * embedded into the WebView. Returns the result as a float.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.694 -0500", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "555184CC223B97DDACBB2BC5B73AAE46")
    
private float viewToContentYf(int y) {
        return (y - getTitleHeight()) * mZoomManager.getInvScale();
    }

    /**
     * Given a distance in content space, convert it to view space. Note: this
     * does not reflect translation, just scaling, so this should not be called
     * with coordinates, but should be called for dimensions like width or
     * height.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.697 -0500", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "74D1F48A89696DCA5EDA08E03AD6C35A")
    
int contentToViewDimension(int d) {
        return Math.round(d * mZoomManager.getScale());
    }

    /**
     * Given an x coordinate in content space, convert it to view
     * space.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.698 -0500", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "3F90909ED8FDB4D6012C971C04745DE8")
    
int contentToViewX(int x) {
        return contentToViewDimension(x);
    }

    /**
     * Given a y coordinate in content space, convert it to view
     * space.  Takes into account the height of the title bar.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.700 -0500", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "2F9E81A812F0B78A638AA2019B02FF67")
    
int contentToViewY(int y) {
        return contentToViewDimension(y) + getTitleHeight();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.702 -0500", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "ADCDFAE47097037C6CB4872BF1E356DE")
    
private Rect contentToViewRect(Rect x) {
        return new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom));
    }

    /*  To invalidate a rectangle in content coordinates, we need to transform
        the rect into view coordinates, so we can then call invalidate(...).

        Normally, we would just call contentToView[XY](...), which eventually
        calls Math.round(coordinate * mActualScale). However, for invalidates,
        we need to account for the slop that occurs with antialiasing. To
        address that, we are a little more liberal in the size of the rect that
        we invalidate.

        This liberal calculation calls floor() for the top/left, and ceil() for
        the bottom/right coordinates. This catches the possible extra pixels of
        antialiasing that we might have missed with just round().
     */

    // Called by JNI to invalidate the View, given rectangle coordinates in
    // content space
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.704 -0500", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "753FF991F2F8AD4D4493BFD0240A1F2B")
    
private void viewInvalidate(int l, int t, int r, int b) {
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
        invalidate((int)Math.floor(l * scale),
                   (int)Math.floor(t * scale) + dy,
                   (int)Math.ceil(r * scale),
                   (int)Math.ceil(b * scale) + dy);
    }

    // Called by JNI to invalidate the View after a delay, given rectangle
    // coordinates in content space
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.707 -0500", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "D383E5A8743BD71A721BDCF19FFCB956")
    
private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
        postInvalidateDelayed(delay,
                              (int)Math.floor(l * scale),
                              (int)Math.floor(t * scale) + dy,
                              (int)Math.ceil(r * scale),
                              (int)Math.ceil(b * scale) + dy);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.709 -0500", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "CC598B2E2CAB278FC7CA0F76C119CD53")
    
private void invalidateContentRect(Rect r) {
        viewInvalidate(r.left, r.top, r.right, r.bottom);
    }

    // stop the scroll animation, and don't let a subsequent fling add
    // to the existing velocity
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.712 -0500", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "0E7143F6E97592BD292ABC814BBBA330")
    
private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
    }

    /* call from webcoreview.draw(), so we're still executing in the UI thread
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.714 -0500", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "0C51950FA35468BEFF7FCB31C187ADBB")
    
private void recordNewContentSize(int w, int h, boolean updateLayout) {

        // premature data from webkit, ignore
        if ((w | h) == 0) {
            return;
        }

        // don't abort a scroll animation if we didn't change anything
        if (mContentWidth != w || mContentHeight != h) {
            // record new dimensions
            mContentWidth = w;
            mContentHeight = h;
            // If history Picture is drawn, don't update scroll. They will be
            // updated when we get out of that mode.
            if (!mDrawHistory) {
                // repin our scroll, taking into account the new content size
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                if (!mScroller.isFinished()) {
                    // We are in the middle of a scroll.  Repin the final scroll
                    // position.
                    mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                    mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                }
            }
        }
        contentSizeChanged(updateLayout);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.728 -0500", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "A5015873967CE38366BEE887BCE5ADAF")
    
Rect sendOurVisibleRect() {
        if (mZoomManager.isPreventingWebkitUpdates()) return mLastVisibleRectSent;
        calcOurContentVisibleRect(mVisibleRect);
        // Rect.equals() checks for null input.
        if (!mVisibleRect.equals(mLastVisibleRectSent)) {
            if (!mBlockWebkitViewMessages) {
                mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                mWebViewCore.removeMessages(EventHub.SET_SCROLL_OFFSET);
                mWebViewCore.sendMessage(EventHub.SET_SCROLL_OFFSET,
                        nativeMoveGeneration(), mSendScrollEvent ? 1 : 0, mScrollOffset);
            }
            mLastVisibleRectSent.set(mVisibleRect);
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        }
        if (getGlobalVisibleRect(mGlobalVisibleRect)
                && !mGlobalVisibleRect.equals(mLastGlobalRect)) {
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "sendOurVisibleRect=(" + mGlobalVisibleRect.left + ","
                        + mGlobalVisibleRect.top + ",r=" + mGlobalVisibleRect.right + ",b="
                        + mGlobalVisibleRect.bottom);
            }
            // TODO: the global offset is only used by windowRect()
            // in ChromeClientAndroid ; other clients such as touch
            // and mouse events could return view + screen relative points.
            if (!mBlockWebkitViewMessages) {
                mWebViewCore.sendMessage(EventHub.SET_GLOBAL_BOUNDS, mGlobalVisibleRect);
            }
            mLastGlobalRect.set(mGlobalVisibleRect);
        }
        return mVisibleRect;
    }
    // Sets r to be the visible rectangle of our webview in view coordinates
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.733 -0500", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "83D5F65CEBECB8929FAED76182A59F39")
    
private void calcOurVisibleRect(Rect r) {
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    // Sets r to be our visible rectangle in content coordinates
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.735 -0500", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "D710ABF450367BF84C032CDC15A2047B")
    
private void calcOurContentVisibleRect(Rect r) {
        calcOurVisibleRect(r);
        r.addTaint(viewToContentX(r.getTaintInt()) + viewToContentY(r.getTaintInt())) ;
        r.addTaint(getVisibleTitleHeight());
        
        // viewToContentY will remove the total height of the title bar.  Add
        // the visible height back in to account for the fact that if the title
        // bar is partially visible, the part of the visible rect which is
        // displaying our content is displaced by that amount.
        // r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        // r.right = viewToContentX(r.right);
        // r.bottom = viewToContentY(r.bottom);
    }
    // Sets r to be our visible rectangle in content coordinates. We use this
    // method on the native side to compute the position of the fixed layers.
    // Uses floating coordinates (necessary to correctly place elements when
    // the scale factor is not 1)
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.740 -0500", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "5D967BE5B0074E8BDB2931626231F0B1")
    
private void calcOurContentVisibleRectF(RectF r) {
        calcOurVisibleRect(mContentVisibleRect);
        r.left = viewToContentXf(mContentVisibleRect.left);
        // viewToContentY will remove the total height of the title bar.  Add
        // the visible height back in to account for the fact that if the title
        // bar is partially visible, the part of the visible rect which is
        // displaying our content is displaced by that amount.
        r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        r.right = viewToContentXf(mContentVisibleRect.right);
        r.bottom = viewToContentYf(mContentVisibleRect.bottom);
    }

    /**
     * Compute unzoomed width and height, and if they differ from the last
     * values we sent, send them to webkit (to be used as new viewport)
     *
     * @param force ensures that the message is sent to webkit even if the width
     * or height has not changed since the last message
     *
     * @return true if new values were sent
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.764 -0500", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "A247D7BD84A84124087BCD8D819686D5")
    
boolean sendViewSizeZoom(boolean force) {
        if (mBlockWebkitViewMessages) return false;
        if (mZoomManager.isPreventingWebkitUpdates()) return false;

        int viewWidth = getViewWidth();
        int newWidth = Math.round(viewWidth * mZoomManager.getInvScale());
        // This height could be fixed and be different from actual visible height.
        int viewHeight = getViewHeightWithTitle() - getTitleHeight();
        int newHeight = Math.round(viewHeight * mZoomManager.getInvScale());
        // Make the ratio more accurate than (newHeight / newWidth), since the
        // latter both are calculated and rounded.
        float heightWidthRatio = (float) viewHeight / viewWidth;
        /*
         * Because the native side may have already done a layout before the
         * View system was able to measure us, we have to send a height of 0 to
         * remove excess whitespace when we grow our width. This will trigger a
         * layout and a change in content size. This content size change will
         * mean that contentSizeChanged will either call this method directly or
         * indirectly from onSizeChanged.
         */
        if (newWidth > mLastWidthSent && mWrapContent) {
            newHeight = 0;
            heightWidthRatio = 0;
        }
        // Actual visible content height.
        int actualViewHeight = Math.round(getViewHeight() * mZoomManager.getInvScale());
        // Avoid sending another message if the dimensions have not changed.
        if (newWidth != mLastWidthSent || newHeight != mLastHeightSent || force ||
                actualViewHeight != mLastActualHeightSent) {
            ViewSizeData data = new ViewSizeData();
            data.mWidth = newWidth;
            data.mHeight = newHeight;
            data.mHeightWidthRatio = heightWidthRatio;
            data.mActualViewHeight = actualViewHeight;
            data.mTextWrapWidth = Math.round(viewWidth / mZoomManager.getTextWrapScale());
            data.mScale = mZoomManager.getScale();
            data.mIgnoreHeight = mZoomManager.isFixedLengthAnimationInProgress()
                    && !mHeightCanMeasure;
            data.mAnchorX = mZoomManager.getDocumentAnchorX();
            data.mAnchorY = mZoomManager.getDocumentAnchorY();
            mWebViewCore.sendMessage(EventHub.VIEW_SIZE_CHANGED, data);
            mLastWidthSent = newWidth;
            mLastHeightSent = newHeight;
            mLastActualHeightSent = actualViewHeight;
            mZoomManager.clearDocumentAnchor();
            return true;
        }
        return false;
    }

    /**
     * Update the double-tap zoom.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.766 -0500", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "68D4F7C7314D54768CC2FFDD5D69C2D7")
    
void updateDoubleTapZoom(int doubleTapZoom) {
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.768 -0500", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "E9C6D8CDDF7F836B163567BEFB17A181")
    
private int computeRealHorizontalScrollRange() {
        if (mDrawHistory) {
            return mHistoryWidth;
        } else {
            // to avoid rounding error caused unnecessary scrollbar, use floor
            return (int) Math.floor(mContentWidth * mZoomManager.getScale());
        }
    }

    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.770 -0500", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "B129A0A2DA3C35A75BA8F112EFBB4714")
    
@Override
    protected int computeHorizontalScrollRange() {
        int range = computeRealHorizontalScrollRange();

        // Adjust reported range if overscrolled to compress the scroll bars
        final int scrollX = mScrollX;
        final int overscrollRight = computeMaxScrollX();
        if (scrollX < 0) {
            range -= scrollX;
        } else if (scrollX > overscrollRight) {
            range += scrollX - overscrollRight;
        }

        return range;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.773 -0500", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "CC0BDE9E0E7A771AF757BD0DC436D8FD")
    
@Override
    protected int computeHorizontalScrollOffset() {
        return Math.max(mScrollX, 0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.775 -0500", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "322DC1FD603E5A47405FDE59FA6F00A4")
    
private int computeRealVerticalScrollRange() {
        if (mDrawHistory) {
            return mHistoryHeight;
        } else {
            // to avoid rounding error caused unnecessary scrollbar, use floor
            return (int) Math.floor(mContentHeight * mZoomManager.getScale());
        }
    }

    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.777 -0500", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "DF848DEEC15F38C424325849F24E9234")
    
@Override
    protected int computeVerticalScrollRange() {
        int range = computeRealVerticalScrollRange();

        // Adjust reported range if overscrolled to compress the scroll bars
        final int scrollY = mScrollY;
        final int overscrollBottom = computeMaxScrollY();
        if (scrollY < 0) {
            range -= scrollY;
        } else if (scrollY > overscrollBottom) {
            range += scrollY - overscrollBottom;
        }

        return range;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.779 -0500", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "5EAE237D38ED7B8B747B428F4396C8D7")
    
@Override
    protected int computeVerticalScrollOffset() {
        return Math.max(mScrollY - getTitleHeight(), 0);
    }

    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.782 -0500", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "CEA40E73D7F29F4763F5FA915429E8B3")
    
@Override
    protected int computeVerticalScrollExtent() {
        return getViewHeight();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.785 -0500", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "B4265CED641FB11707BFDDB87BC9168E")
    
@Override
    protected void onDrawVerticalScrollBar(Canvas canvas,
                                           Drawable scrollBar,
                                           int l, int t, int r, int b) {
        if (mScrollY < 0) {
            t -= mScrollY;
        }
        scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        scrollBar.draw(canvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.788 -0500", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "B9C99A810CC687E12A5D56CBE028CBD5")
    
@Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {
        // Special-case layer scrolling so that we do not trigger normal scroll
        // updating.
        if (mTouchMode == TOUCH_DRAG_LAYER_MODE) {
            scrollLayerTo(scrollX, scrollY);
            return;
        }
        mInOverScrollMode = false;
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();
        if (maxX == 0) {
            // do not over scroll x if the page just fits the screen
            scrollX = pinLocX(scrollX);
        } else if (scrollX < 0 || scrollX > maxX) {
            mInOverScrollMode = true;
        }
        if (scrollY < 0 || scrollY > maxY) {
            mInOverScrollMode = true;
        }

        int oldX = mScrollX;
        int oldY = mScrollY;

        super.scrollTo(scrollX, scrollY);

        if (mOverScrollGlow != null) {
            mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        }
    }

    /**
     * Get the url for the current page. This is not always the same as the url
     * passed to WebViewClient.onPageStarted because although the load for
     * that url has begun, the current page may not have changed.
     * @return The url for the current page.
     */
    @DSSpec(DSCat.URI_EXCHANGE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.790 -0500", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "F38C676B99E9ECCC987DAE6C3277ADF4")
    
public String getUrl() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        return h != null ? h.getUrl() : null;
    }

    /**
     * Get the original url for the current page. This is not always the same
     * as the url passed to WebViewClient.onPageStarted because although the
     * load for that url has begun, the current page may not have changed.
     * Also, there may have been redirects resulting in a different url to that
     * originally requested.
     * @return The url that was originally requested for the current page.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.792 -0500", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "424B9AB1E79C41732C4BF4BCE610F2EF")
    
public String getOriginalUrl() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        return h != null ? h.getOriginalUrl() : null;
    }

    /**
     * Get the title for the current page. This is the title of the current page
     * until WebViewClient.onReceivedTitle is called.
     * @return The title for the current page.
     */
    @DSComment("information may be on internet")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.794 -0500", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "E7ECFF7699D3EBB5771FCAA8FB697708")
    
public String getTitle() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        return h != null ? h.getTitle() : null;
    }

    /**
     * Get the favicon for the current page. This is the favicon of the current
     * page until WebViewClient.onReceivedIcon is called.
     * @return The favicon for the current page.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.796 -0500", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "9904D0BE4E94A746B828E528232FD56B")
    
public Bitmap getFavicon() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        return h != null ? h.getFavicon() : null;
    }

    /**
     * Get the touch icon url for the apple-touch-icon <link> element, or
     * a URL on this site's server pointing to the standard location of a
     * touch icon.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.798 -0500", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "5EAE3AD6DA2B5ABB5FAAC467647CAF57")
    
public String getTouchIconUrl() {
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        return h != null ? h.getTouchIconUrl() : null;
    }

    /**
     * Get the progress for the current page.
     * @return The progress for the current page between 0 and 100.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.801 -0500", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "74E145D876EA6155A260B96B198D0831")
    
public int getProgress() {
        checkThread();
        return mCallbackProxy.getProgress();
    }

    /**
     * @return the height of the HTML content.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.803 -0500", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "D1270718E2C8F4E88C999AB896253809")
    
public int getContentHeight() {
        checkThread();
        return mContentHeight;
    }

    /**
     * @return the width of the HTML content.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.805 -0500", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "D6A17C41237228432A494BE3184F037A")
    
public int getContentWidth() {
        return mContentWidth;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.807 -0500", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "5963ED82BA8C236C2BD81F54552D56F2")
    
public int getPageBackgroundColor() {
        return nativeGetBackgroundColor();
    }

    /**
     * Pause all layout, parsing, and JavaScript timers for all webviews. This
     * is a global requests, not restricted to just this webview. This can be
     * useful if the application has been paused.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.809 -0500", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "C6FB0F272C63C170DE7873FB105535DB")
    
public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
    }

    /**
     * Resume all layout, parsing, and JavaScript timers for all webviews.
     * This will resume dispatching all timers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.811 -0500", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "A3B11EA05C94695BCDE2A376917756FD")
    
public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
    }

    /**
     * Call this to pause any extra processing associated with this WebView and
     * its associated DOM, plugins, JavaScript etc. For example, if the WebView
     * is taken offscreen, this could be called to reduce unnecessary CPU or
     * network traffic. When the WebView is again "active", call onResume().
     *
     * Note that this differs from pauseTimers(), which affects all WebViews.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.813 -0500", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "D54ECA2EDAEA2CF8627AD4D6F473C9C8")
    
public void onPause() {
        checkThread();
        if (!mIsPaused) {
            mIsPaused = true;
            mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            // We want to pause the current playing video when switching out
            // from the current WebView/tab.
            if (mHTML5VideoViewProxy != null) {
                mHTML5VideoViewProxy.pauseAndDispatch();
            }
            if (mNativeClass != 0) {
                nativeSetPauseDrawing(mNativeClass, true);
            }

            cancelSelectDialog();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.815 -0500", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "EDB07093EAF3C020CE26B9EF08DA4178")
    
@Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        updateDrawingState();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.818 -0500", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "79814C5B2A5EB8E3D8936785FBEE125A")
    
void updateDrawingState() {
        if (mNativeClass == 0 || mIsPaused) return;
        if (getWindowVisibility() != VISIBLE) {
            nativeSetPauseDrawing(mNativeClass, true);
        } else if (getVisibility() != VISIBLE) {
            nativeSetPauseDrawing(mNativeClass, true);
        } else {
            nativeSetPauseDrawing(mNativeClass, false);
        }
    }

    /**
     * Call this to resume a WebView after a previous call to onPause().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.821 -0500", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "7B9E38238EDD49DE3D81FC093042B6EA")
    
public void onResume() {
        checkThread();
        if (mIsPaused) {
            mIsPaused = false;
            mWebViewCore.sendMessage(EventHub.ON_RESUME);
            if (mNativeClass != 0) {
                nativeSetPauseDrawing(mNativeClass, false);
            }
        }
    }

    /**
     * Returns true if the view is paused, meaning onPause() was called. Calling
     * onResume() sets the paused state back to false.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.823 -0500", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "75F463955FADAB9308A00FA4B9748524")
    
public boolean isPaused() {
        return mIsPaused;
    }

    /**
     * Call this to inform the view that memory is low so that it can
     * free any available memory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.825 -0500", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "CDDC4E240A9CB55A3098D6C36A957AD4")
    
public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
    }

    /**
     * Clear the resource cache. Note that the cache is per-application, so
     * this will clear the cache for all WebViews used.
     *
     * @param includeDiskFiles If false, only the RAM cache is cleared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.827 -0500", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "3F825B340D6418D8ADB7E8ACDF0C747F")
    
public void clearCache(boolean includeDiskFiles) {
        checkThread();
        // Note: this really needs to be a static method as it clears cache for all
        // WebView. But we need mWebViewCore to send message to WebCore thread, so
        // we can't make this static.
        mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                includeDiskFiles ? 1 : 0, 0);
    }

    /**
     * Make sure that clearing the form data removes the adapter from the
     * currently focused textfield if there is one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.829 -0500", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "574CC803D92A8FFCB7CFA370FE1EBF2D")
    
public void clearFormData() {
        checkThread();
        if (inEditingMode()) {
            mWebTextView.setAdapterCustom(null);
        }
    }

    /**
     * Tell the WebView to clear its internal back/forward list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.831 -0500", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "160A1248547810EBD3686902707D3F19")
    
public void clearHistory() {
        checkThread();
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
    }

    /**
     * Clear the SSL preferences table stored in response to proceeding with SSL
     * certificate errors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.833 -0500", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "74879555076FDDFCDF27006AF7AA6585")
    
public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
    }

    /**
     * Return the WebBackForwardList for this WebView. This contains the
     * back/forward list for use in querying each item in the history stack.
     * This is a copy of the private WebBackForwardList so it contains only a
     * snapshot of the current state. Multiple calls to this method may return
     * different objects. The object returned from this method will not be
     * updated to reflect any new state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.835 -0500", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "2D3211D0DE44395F46C9593C5D4BEBD7")
    
public WebBackForwardList copyBackForwardList() {
        checkThread();
        return mCallbackProxy.getBackForwardList().clone();
    }

    /*
     * Highlight and scroll to the next occurance of String in findAll.
     * Wraps the page infinitely, and scrolls.  Must be called after
     * calling findAll.
     *
     * @param forward Direction to search.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.837 -0500", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "2376A8082C9FDEF61E49AFBF2F70E4EF")
    
public void findNext(boolean forward) {
        checkThread();
        if (0 == mNativeClass) return; // client isn't initialized
        nativeFindNext(forward);
    }

    /*
     * Find all instances of find on the page and highlight them.
     * @param find  String to find.
     * @return int  The number of occurances of the String "find"
     *              that were found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.840 -0500", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "2F7225F85F1D39CB698F335F846CAF3D")
    
public int findAll(String find) {
        checkThread();
        if (0 == mNativeClass) return 0; // client isn't initialized
        int result = find != null ? nativeFindAll(find.toLowerCase(),
                find.toUpperCase(), find.equalsIgnoreCase(mLastFind)) : 0;
        invalidate();
        mLastFind = find;
        return result;
    }

    /**
     * Start an ActionMode for finding text in this WebView.  Only works if this
     *              WebView is attached to the view system.
     * @param text If non-null, will be the initial text to search for.
     *             Otherwise, the last String searched for in this WebView will
     *             be used to start.
     * @param showIme If true, show the IME, assuming the user will begin typing.
     *             If false and text is non-null, perform a find all.
     * @return boolean True if the find dialog is shown, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.842 -0500", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "A135CD2B0F862DA584D57D0A1105C60B")
    
public boolean showFindDialog(String text, boolean showIme) {
        checkThread();
        FindActionModeCallback callback = new FindActionModeCallback(mContext);
        if (getParent() == null || startActionMode(callback) == null) {
            // Could not start the action mode, so end Find on page
            return false;
        }
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = callback;
        setFindIsUp(true);
        mFindCallback.setWebView(this);
        if (showIme) {
            mFindCallback.showSoftInput();
        } else if (text != null) {
            mFindCallback.setText(text);
            mFindCallback.findAll();
            return true;
        }
        if (text == null) {
            text = mLastFind;
        }
        if (text != null) {
            mFindCallback.setText(text);
        }
        return true;
    }

    /**
     * Toggle whether the find dialog is showing, for both native and Java.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.847 -0500", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "90255B9B02F1B70DB1B02FC577B9CB35")
    
private void setFindIsUp(boolean isUp) {
        mFindIsUp = isUp;
        if (0 == mNativeClass) return; // client isn't initialized
        nativeSetFindIsUp(isUp);
    }

    /**
     * Return the index of the currently highlighted match.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.849 -0500", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "FBDEE77A8BCDC35814DF27DAD18B5857")
    
int findIndex() {
        if (0 == mNativeClass) return -1;
        return nativeFindIndex();
    }

    /*
     * Clear the highlighting surrounding text matches created by findAll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.860 -0500", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "A075086D49C6B2C48326451A26E9E76D")
    
public void clearMatches() {
        checkThread();
        if (mNativeClass == 0)
            return;
        nativeSetFindIsEmpty();
        invalidate();
    }

    /**
     * Called when the find ActionMode ends.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.862 -0500", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "A67E3244D2DDB3B643A8BF563B2AB754")
    
void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
        if (mWebViewCore == null) {
            return;
        }
        clearMatches();
        setFindIsUp(false);
        // Now that the dialog has been removed, ensure that we scroll to a
        // location that is not beyond the end of the page.
        pinScrollTo(mScrollX, mScrollY, false, 0);
        invalidate();
    }

    /**
     * Query the document to see if it contains any image references. The
     * message object will be dispatched with arg1 being set to 1 if images
     * were found and 0 if the document does not reference any images.
     * @param response The message that will be dispatched with the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.865 -0500", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "1D609564B0F0B062FECC8F8F547D61CD")
    
public void documentHasImages(Message response) {
        checkThread();
        if (response == null) {
            return;
        }
        mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
    }

    /**
     * Request the scroller to abort any ongoing animation
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.867 -0500", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "982E3129EF3F73BD53CF02E889136A3B")
    
public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
    }

    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.870 -0500", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "8C9886F2D775D857649089B89A57EE10")
    
@Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            invalidate();  // So we draw again

            if (!mScroller.isFinished()) {
                int rangeX = computeMaxScrollX();
                int rangeY = computeMaxScrollY();
                int overflingDistance = mOverflingDistance;

                // Use the layer's scroll data if needed.
                if (mTouchMode == TOUCH_DRAG_LAYER_MODE) {
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = mScrollingLayerRect.right;
                    rangeY = mScrollingLayerRect.bottom;
                    // No overscrolling for layers.
                    overflingDistance = 0;
                }

                overScrollBy(x - oldX, y - oldY, oldX, oldY,
                        rangeX, rangeY,
                        overflingDistance, overflingDistance, false);

                if (mOverScrollGlow != null) {
                    mOverScrollGlow.absorbGlow(x, y, oldX, oldY, rangeX, rangeY);
                }
            } else {
                if (mTouchMode != TOUCH_DRAG_LAYER_MODE) {
                    mScrollX = x;
                    mScrollY = y;
                } else {
                    // Update the layer position instead of WebView.
                    scrollLayerTo(x, y);
                }
                abortAnimation();
                nativeSetIsScrolling(false);
                if (!mBlockWebkitViewMessages) {
                    WebViewCore.resumePriority();
                    if (!mSelectingText) {
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    }
                }
                if (oldX != mScrollX || oldY != mScrollY) {
                    sendOurVisibleRect();
                }
            }
        } else {
            super.computeScroll();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.872 -0500", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "6ED0E25A030B2A4316CE4B9AD7AB9AB3")
    
private void scrollLayerTo(int x, int y) {
        if (x == mScrollingLayerRect.left && y == mScrollingLayerRect.top) {
            return;
        }
        nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        mScrollingLayerRect.left = x;
        mScrollingLayerRect.top = y;
        onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        invalidate();
    }

    // helper to pin the scrollBy parameters (already in view coordinates)
    // returns true if the scroll was changed
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.877 -0500", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "8BD847BEF7E0C709EA772E89086B07C6")
    
private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        return pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration);
    }
    // helper to pin the scrollTo parameters (already in view coordinates)
    // returns true if the scroll was changed
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.879 -0500", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "69D9C041236B8CDCE9202E6FF5EA0531")
    
private boolean pinScrollTo(int x, int y, boolean animate, int animationDuration) {
        x = pinLocX(x);
        y = pinLocY(y);
        int dx = x - mScrollX;
        int dy = y - mScrollY;

        if ((dx | dy) == 0) {
            return false;
        }
        abortAnimation();
        if (animate) {
            //        Log.d(LOGTAG, "startScroll: " + dx + " " + dy);
            mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            awakenScrollBars(mScroller.getDuration());
            invalidate();
        } else {
            scrollTo(x, y);
        }
        return true;
    }

    // Scale from content to view coordinates, and pin.
    // Also called by jni webview.cpp
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.881 -0500", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "A2BEBB362CB8B5B8C96DAA8B2C37D52E")
    
private boolean setContentScrollBy(int cx, int cy, boolean animate) {
        if (mDrawHistory) {
            // disallow WebView to change the scroll position as History Picture
            // is used in the view system.
            // TODO: as we switchOutDrawHistory when trackball or navigation
            // keys are hit, this should be safe. Right?
            return false;
        }
        cx = contentToViewDimension(cx);
        cy = contentToViewDimension(cy);
        if (mHeightCanMeasure) {
            // move our visible rect according to scroll request
            if (cy != 0) {
                Rect tempRect = new Rect();
                calcOurVisibleRect(tempRect);
                tempRect.offset(cx, cy);
                requestRectangleOnScreen(tempRect);
            }
            // FIXME: We scroll horizontally no matter what because currently
            // ScrollView and ListView will not scroll horizontally.
            // FIXME: Why do we only scroll horizontally if there is no
            // vertical scroll?
//                Log.d(LOGTAG, "setContentScrollBy cy=" + cy);
            return cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0);
        } else {
            return pinScrollBy(cx, cy, animate, 0);
        }
    }

    /**
     * Called by CallbackProxy when the page starts loading.
     * @param url The URL of the page which has started loading.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.883 -0500", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "A817B6CD2D46DEB4984D50DC01A0845F")
    
void onPageStarted(String url) {
        // every time we start a new page, we want to reset the
        // WebView certificate:  if the new site is secure, we
        // will reload it and get a new certificate set;
        // if the new site is not secure, the certificate must be
        // null, and that will be the case
        setCertificate(null);

        // reset the flag since we set to true in if need after
        // loading is see onPageFinished(Url)
        mAccessibilityScriptInjected = false;
    }

    /**
     * Called by CallbackProxy when the page finishes loading.
     * @param url The URL of the page which has finished loading.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.885 -0500", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "53524BF31E749B2C154A956AB52DAE76")
    
void onPageFinished(String url) {
        if (mPageThatNeedsToSlideTitleBarOffScreen != null) {
            // If the user is now on a different page, or has scrolled the page
            // past the point where the title bar is offscreen, ignore the
            // scroll request.
            if (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    && mScrollX == 0 && mScrollY == 0) {
                pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        SLIDE_TITLE_DURATION);
            }
            mPageThatNeedsToSlideTitleBarOffScreen = null;
        }
        mZoomManager.onPageFinished(url);
        injectAccessibilityForUrl(url);
    }

    /**
     * This method injects accessibility in the loaded document if accessibility
     * is enabled. If JavaScript is enabled we try to inject a URL specific script.
     * If no URL specific script is found or JavaScript is disabled we fallback to
     * the default {@link AccessibilityInjector} implementation.
     * </p>
     * If the URL has the "axs" paramter set to 1 it has already done the
     * script injection so we do nothing. If the parameter is set to 0
     * the URL opts out accessibility script injection so we fall back to
     * the default {@link AccessibilityInjector}.
     * </p>
     * Note: If the user has not opted-in the accessibility script injection no scripts
     * are injected rather the default {@link AccessibilityInjector} implementation
     * is used.
     *
     * @param url The URL loaded by this {@link WebView}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.888 -0500", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "AEC82A19FA728AA82BF0149CCD2E2698")
    
private void injectAccessibilityForUrl(String url) {
        if (mWebViewCore == null) {
            return;
        }
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mContext);

        if (!accessibilityManager.isEnabled()) {
            // it is possible that accessibility was turned off between reloads
            ensureAccessibilityScriptInjectorInstance(false);
            return;
        }

        if (!getSettings().getJavaScriptEnabled()) {
            // no JS so we fallback to the basic buil-in support
            ensureAccessibilityScriptInjectorInstance(true);
            return;
        }

        // check the URL "axs" parameter to choose appropriate action
        int axsParameterValue = getAxsUrlParameterValue(url);
        if (axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED) {
            boolean onDeviceScriptInjectionEnabled = (Settings.Secure.getInt(mContext
                    .getContentResolver(), Settings.Secure.ACCESSIBILITY_SCRIPT_INJECTION, 0) == 1);
            if (onDeviceScriptInjectionEnabled) {
                ensureAccessibilityScriptInjectorInstance(false);
                // neither script injected nor script injection opted out => we inject
                loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
                // TODO: Set this flag after successfull script injection. Maybe upon injection
                // the chooser should update the meta tag and we check it to declare success
                mAccessibilityScriptInjected = true;
            } else {
                // injection disabled so we fallback to the basic built-in support
                ensureAccessibilityScriptInjectorInstance(true);
            }
        } else if (axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT) {
            // injection opted out so we fallback to the basic buil-in support
            ensureAccessibilityScriptInjectorInstance(true);
        } else if (axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED) {
            ensureAccessibilityScriptInjectorInstance(false);
            // the URL provides accessibility but we still need to add our generic script
            loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
        } else {
            Log.e(LOGTAG, "Unknown URL value for the \"axs\" URL parameter: " + axsParameterValue);
        }
    }

    /**
     * Ensures the instance of the {@link AccessibilityInjector} to be present ot not.
     *
     * @param present True to ensure an insance, false to ensure no instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.891 -0500", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "F1BD626DB6A1715B5093C8C9909D9D3D")
    
private void ensureAccessibilityScriptInjectorInstance(boolean present) {
        if (present) {
            if (mAccessibilityInjector == null) {
                mAccessibilityInjector = new AccessibilityInjector(this);
            }
        } else {
            mAccessibilityInjector = null;
        }
    }

    /**
     * Gets the "axs" URL parameter value.
     *
     * @param url A url to fetch the paramter from.
     * @return The parameter value if such, -1 otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.893 -0500", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "9C5DD837728CE86C8F4EB9F5E7D07740")
    
private int getAxsUrlParameterValue(String url) {
        if (mMatchAxsUrlParameterPattern == null) {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        }
        Matcher matcher = mMatchAxsUrlParameterPattern.matcher(url);
        if (matcher.find()) {
            String keyValuePair = url.substring(matcher.start(), matcher.end());
            return Integer.parseInt(keyValuePair.split("=")[1]);
        }
        return -1;
    }

    // scale from content to view coordinates, and pin
    // return true if pin caused the final x/y different than the request cx/cy,
    // and a future scroll may reach the request cx/cy after our size has
    // changed
    // return false if the view scroll to the exact position as it is requested,
    // where negative numbers are taken to mean 0
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.900 -0500", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "B393D99C548EAA84B095619B0B4153A3")
    
private boolean setContentScrollTo(int cx, int cy) {
        if (mDrawHistory) {
            // disallow WebView to change the scroll position as History Picture
            // is used in the view system.
            // One known case where this is called is that WebCore tries to
            // restore the scroll position. As history Picture already uses the
            // saved scroll position, it is ok to skip this.
            return false;
        }
        int vx;
        int vy;
        if ((cx | cy) == 0) {
            // If the page is being scrolled to (0,0), do not add in the title
            // bar's height, and simply scroll to (0,0). (The only other work
            // in contentToView_ is to multiply, so this would not change 0.)
            vx = 0;
            vy = 0;
        } else {
            vx = contentToViewX(cx);
            vy = contentToViewY(cy);
        }
//        Log.d(LOGTAG, "content scrollTo [" + cx + " " + cy + "] view=[" +
//                      vx + " " + vy + "]");
        // Some mobile sites attempt to scroll the title bar off the page by
        // scrolling to (0,1).  If we are at the top left corner of the
        // page, assume this is an attempt to scroll off the title bar, and
        // animate the title bar off screen slowly enough that the user can see
        // it.
        if (cx == 0 && cy == 1 && mScrollX == 0 && mScrollY == 0
                && mTitleBar != null) {
            // FIXME: 100 should be defined somewhere as our max progress.
            if (getProgress() < 100) {
                // Wait to scroll the title bar off screen until the page has
                // finished loading.  Keep track of the URL and the destination
                // Y position
                mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                mYDistanceToSlideTitleOffScreen = vy;
            } else {
                pinScrollTo(vx, vy, true, SLIDE_TITLE_DURATION);
            }
            // Since we are animating, we have not yet reached the desired
            // scroll position.  Do not return true to request another attempt
            return false;
        }
        pinScrollTo(vx, vy, false, 0);
        // If the request was to scroll to a negative coordinate, treat it as if
        // it was a request to scroll to 0
        if ((mScrollX != vx && cx >= 0) || (mScrollY != vy && cy >= 0)) {
            return true;
        } else {
            return false;
        }
    }

    // scale from content to view coordinates, and pin
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.903 -0500", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "77F2320F20EC51FB45340CBCCBA32470")
    
private void spawnContentScrollTo(int cx, int cy) {
        if (mDrawHistory) {
            // disallow WebView to change the scroll position as History Picture
            // is used in the view system.
            return;
        }
        int vx = contentToViewX(cx);
        int vy = contentToViewY(cy);
        pinScrollTo(vx, vy, true, 0);
    }

    /**
     * These are from webkit, and are in content coordinate system (unzoomed)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.906 -0500", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "F9B6D062395EB292AD0FF4F3DB850EF2")
    
private void contentSizeChanged(boolean updateLayout) {
        // suppress 0,0 since we usually see real dimensions soon after
        // this avoids drawing the prev content in a funny place. If we find a
        // way to consolidate these notifications, this check may become
        // obsolete
        if ((mContentWidth | mContentHeight) == 0) {
            return;
        }

        if (mHeightCanMeasure) {
            if (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout) {
                requestLayout();
            }
        } else if (mWidthCanMeasure) {
            if (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    || updateLayout) {
                requestLayout();
            }
        } else {
            // If we don't request a layout, try to send our view size to the
            // native side to ensure that WebCore has the correct dimensions.
            sendViewSizeZoom(false);
        }
    }

    /**
     * Set the WebViewClient that will receive various notifications and
     * requests. This will replace the current handler.
     * @param client An implementation of WebViewClient.
     */
    @DSComment("Webview display, no IO access to outside world")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.908 -0500", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "62BFFE4108BE3AC6FAE4A3DFA32B6093")
    
    @DSVerified
public void setWebViewClient(WebViewClient client) {
        //checkThread();
        mCallbackProxy.setWebViewClient(client);
    }

    /**
     * Gets the WebViewClient
     * @return the current WebViewClient instance.
     *
     *@hide pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.910 -0500", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "D23A39C912F39A603EB9FAA5D3B3F9F2")
    
public WebViewClient getWebViewClient() {
        return mCallbackProxy.getWebViewClient();
    }

    /**
     * Register the interface to be used when content can not be handled by
     * the rendering engine, and should be downloaded instead. This will replace
     * the current handler.
     * @param listener An implementation of DownloadListener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.912 -0500", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "A941DE35BB5EF7C2B20ED04D015CF539")
    
public void setDownloadListener(DownloadListener listener) {
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
    }

    /**
     * Set the chrome handler. This is an implementation of WebChromeClient for
     * use in handling JavaScript dialogs, favicons, titles, and the progress.
     * This will replace the current handler.
     * @param client An implementation of WebChromeClient.
     */
    @DSComment("Webview display, no IO access to outside world")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.914 -0500", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "4EEA2E22B4A1041289EAF3F896446D14")
    
public void setWebChromeClient(WebChromeClient client) {
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
    }

    /**
     * Gets the chrome handler.
     * @return the current WebChromeClient instance.
     *
     * @hide API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.916 -0500", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "4C16CE4B3D3AFE5213FA5FE8C158F22B")
    
public WebChromeClient getWebChromeClient() {
        return mCallbackProxy.getWebChromeClient();
    }

    /**
     * Set the back/forward list client. This is an implementation of
     * WebBackForwardListClient for handling new items and changes in the
     * history index.
     * @param client An implementation of WebBackForwardListClient.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.918 -0500", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "0E08471A12F1F4D863F73ED54D80CB6D")
    
public void setWebBackForwardListClient(WebBackForwardListClient client) {
        mCallbackProxy.setWebBackForwardListClient(client);
    }

    /**
     * Gets the WebBackForwardListClient.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.921 -0500", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "295E6F4656A8D31EF7091646ECC9AF4F")
    
public WebBackForwardListClient getWebBackForwardListClient() {
        return mCallbackProxy.getWebBackForwardListClient();
    }

    /**
     * Set the Picture listener. This is an interface used to receive
     * notifications of a new Picture.
     * @param listener An implementation of WebView.PictureListener.
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.923 -0500", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "965038717D24F7E9DE840A33C8EC8565")

    @DSVerified("Picture comes from Internet")
    @DSSpec(DSCat.INTERNET)
@Deprecated
    public void setPictureListener(PictureListener listener) {
        mPictureListener = listener;
        if (listener != null)
            listener.onNewPicture(this, new Picture());
    }

    /**
     * {@hide}
     */
    /* FIXME: Debug only! Remove for SDK! */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.925 -0500", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "5EB69581C3B175CCFDB715D0767540FD")
    
public void externalRepresentation(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
    }

    /**
     * {@hide}
     */
    /* FIXME: Debug only! Remove for SDK! */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.927 -0500", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "EA4F0B252BF625CE915101F84A3F383B")
    
public void documentAsText(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
    }

    /**
     * Use this function to bind an object to JavaScript so that the
     * methods can be accessed from JavaScript.
     * <p><strong>IMPORTANT:</strong>
     * <ul>
     * <li> Using addJavascriptInterface() allows JavaScript to control your
     * application. This can be a very useful feature or a dangerous security
     * issue. When the HTML in the WebView is untrustworthy (for example, part
     * or all of the HTML is provided by some person or process), then an
     * attacker could inject HTML that will execute your code and possibly any
     * code of the attacker's choosing.<br>
     * Do not use addJavascriptInterface() unless all of the HTML in this
     * WebView was written by you.</li>
     * <li> The Java object that is bound runs in another thread and not in
     * the thread that it was constructed in.</li>
     * </ul></p>
     * @param obj The class instance to bind to JavaScript, null instances are
     *            ignored.
     * @param interfaceName The name to used to expose the instance in
     *                      JavaScript.
     */
    @DSComment("System settings/policy")
    @DSSpec(DSCat.SYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.929 -0500", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "3C2BF336734549FA2F6035BA7DE9224F")
    
public void addJavascriptInterface(Object obj, String interfaceName) {
        checkThread();
        if (obj == null) {
            return;
        }
        WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
        arg.mObject = obj;
        arg.mInterfaceName = interfaceName;
        mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
    }

    /**
     * Removes a previously added JavaScript interface with the given name.
     * @param interfaceName The name of the interface to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.931 -0500", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "79477773C5EF9883370339F8C64AA40E")
    
public void removeJavascriptInterface(String interfaceName) {
        checkThread();
        if (mWebViewCore != null) {
            WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            arg.mInterfaceName = interfaceName;
            mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        }
    }

    /**
     * Return the WebSettings object used to control the settings for this
     * WebView.
     * @return A WebSettings object that can be used to control this WebView's
     *         settings.
     */
    @DSComment("Spec classification done at the Setting manipulation level")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.933 -0500", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "A532D40D6A49AAE15F166EE8766438A8")
    
public WebSettings getSettings() {
        checkThread();
        return (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
    }

   /**
    * @hide
    * @deprecated This was used for Gears, which has been deprecated.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.938 -0500", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "A70493F564C3D03EA9422798A55BF6BF")
    
@Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        checkThread();
    }

    //-------------------------------------------------------------------------
    // Override View methods
    //-------------------------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.944 -0500", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "23D126352E024A64A52BF76C1AAB305D")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mNativeClass != 0) {
                mPrivateHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        destroy();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.947 -0500", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "4643C6F19C9B35F74E17E7CB604B7AE6")
    
@Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (child == mTitleBar) {
            // When drawing the title bar, move it horizontally to always show
            // at the top of the WebView.
            mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            int newTop = 0;
            if (mTitleGravity == Gravity.NO_GRAVITY) {
                newTop = Math.min(0, mScrollY);
            } else if (mTitleGravity == Gravity.TOP) {
                newTop = mScrollY;
            }
            mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            mTitleBar.setTop(newTop);
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.949 -0500", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "3380A83D2EB94908B4B2657CF04D418C")
    
private void drawContent(Canvas canvas, boolean drawRings) {
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
    }

    /**
     * Draw the background when beyond bounds
     * @param canvas Canvas to draw into
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.951 -0500", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "04413027C5F1FEC600A069C2DC8FBCA4")
    
private void drawOverScrollBackground(Canvas canvas) {
        if (mOverScrollBackground == null) {
            mOverScrollBackground = new Paint();
            Bitmap bm = BitmapFactory.decodeResource(
                    mContext.getResources(),
                    com.android.internal.R.drawable.status_bar_background);
            mOverScrollBackground.setShader(new BitmapShader(bm,
                    Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            mOverScrollBorder = new Paint();
            mOverScrollBorder.setStyle(Paint.Style.STROKE);
            mOverScrollBorder.setStrokeWidth(0);
            mOverScrollBorder.setColor(0xffbbbbbb);
        }

        int top = 0;
        int right = computeRealHorizontalScrollRange();
        int bottom = top + computeRealVerticalScrollRange();
        // first draw the background and anchor to the top of the view
        canvas.save();
        canvas.translate(mScrollX, mScrollY);
        canvas.clipRect(-mScrollX, top - mScrollY, right - mScrollX, bottom
                - mScrollY, Region.Op.DIFFERENCE);
        canvas.drawPaint(mOverScrollBackground);
        canvas.restore();
        // then draw the border
        canvas.drawRect(-1, top - 1, right, bottom, mOverScrollBorder);
        // next clip the region for the content
        canvas.clipRect(0, top, right, bottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.956 -0500", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "F8B8E04E5963F305767F2FAC231B3231")
    
@Override
    protected void onDraw(Canvas canvas) {
        // if mNativeClass is 0, the WebView is either destroyed or not
        // initialized. In either case, just draw the background color and return
        if (mNativeClass == 0) {
            canvas.drawColor(mBackgroundColor);
            return;
        }

        // if both mContentWidth and mContentHeight are 0, it means there is no
        // valid Picture passed to WebView yet. This can happen when WebView
        // just starts. Draw the background and return.
        if ((mContentWidth | mContentHeight) == 0 && mHistoryPicture == null) {
            canvas.drawColor(mBackgroundColor);
            return;
        }

        if (canvas.isHardwareAccelerated()) {
            if (mIncrementEGLContextHack == false) {
                mIncrementEGLContextHack = true;
                EGL10 egl = (EGL10) EGLContext.getEGL();
                EGLDisplay eglDisplay = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                int[] version = new int[2];
                egl.eglInitialize(eglDisplay, version);
            }
            mZoomManager.setHardwareAccelerated();
        }

        int saveCount = canvas.save();
        if (mInOverScrollMode && !getSettings()
                .getUseWebViewBackgroundForOverscrollBackground()) {
            drawOverScrollBackground(canvas);
        }
        if (mTitleBar != null) {
            canvas.translate(0, getTitleHeight());
        }
        boolean drawJavaRings = !mTouchHighlightRegion.isEmpty()
                && (mTouchMode == TOUCH_INIT_MODE
                || mTouchMode == TOUCH_SHORTPRESS_START_MODE
                || mTouchMode == TOUCH_SHORTPRESS_MODE
                || mTouchMode == TOUCH_DONE_MODE);
        boolean drawNativeRings = !drawJavaRings;
        if (USE_WEBKIT_RINGS) {
            drawNativeRings = !drawJavaRings && !isInTouchMode();
        }
        drawContent(canvas, drawNativeRings);
        canvas.restoreToCount(saveCount);

        if (AUTO_REDRAW_HACK && mAutoRedraw) {
            invalidate();
        }
        mWebViewCore.signalRepaintDone();

        if (mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas)) {
            invalidate();
        }

        // paint the highlight in the end
        if (drawJavaRings) {
            long delay = System.currentTimeMillis() - mTouchHighlightRequested;
            if (delay < ViewConfiguration.getTapTimeout()) {
                Rect r = mTouchHighlightRegion.getBounds();
                postInvalidateDelayed(delay, r.left, r.top, r.right, r.bottom);
            } else {
                if (mTouchHightlightPaint == null) {
                    mTouchHightlightPaint = new Paint();
                    mTouchHightlightPaint.setColor(HIGHLIGHT_COLOR);
                }
                RegionIterator iter = new RegionIterator(mTouchHighlightRegion);
                Rect r = new Rect();
                while (iter.next(r)) {
                    canvas.drawRect(r, mTouchHightlightPaint);
                }
            }
        }
        if (DEBUG_TOUCH_HIGHLIGHT) {
            if (getSettings().getNavDump()) {
                if ((mTouchHighlightX | mTouchHighlightY) != 0) {
                    if (mTouchCrossHairColor == null) {
                        mTouchCrossHairColor = new Paint();
                        mTouchCrossHairColor.setColor(Color.RED);
                    }
                    canvas.drawLine(mTouchHighlightX - mNavSlop,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    + mNavSlop + 1, mTouchHighlightY + mNavSlop
                                    + 1, mTouchCrossHairColor);
                    canvas.drawLine(mTouchHighlightX + mNavSlop + 1,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    - mNavSlop,
                            mTouchHighlightY + mNavSlop + 1,
                            mTouchCrossHairColor);
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.958 -0500", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "A0D2FAC9027C9B651219A2B985B81A9D")
    
private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.961 -0500", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "6691979A802DA24E926F97BC7AEFCBFD")
    
@Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if (params.height == LayoutParams.WRAP_CONTENT) {
            mWrapContent = true;
        }
        super.setLayoutParams(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.963 -0500", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "F17574C1A67136CEE26ECF21674DFE5B")
    
@Override
    public boolean performLongClick() {
        // performLongClick() is the result of a delayed message. If we switch
        // to windows overview, the WebView will be temporarily removed from the
        // view system. In that case, do nothing.
        if (getParent() == null) return false;

        // A multi-finger gesture can look like a long press; make sure we don't take
        // long press actions if we're scaling.
        final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
        if (detector != null && detector.isInProgress()) {
            return false;
        }

        if (mNativeClass != 0 && nativeCursorIsTextInput()) {
            // Send the click so that the textfield is in focus
            centerKeyPressOnTextField();
            rebuildWebTextView();
        } else {
            clearTextEntry();
        }
        if (inEditingMode()) {
            // Since we just called rebuildWebTextView, the layout is not set
            // properly.  Update it so it can correctly find the word to select.
            mWebTextView.ensureLayout();
            // Provide a touch down event to WebTextView, which will allow it
            // to store the location to use in performLongClick.
            AbsoluteLayout.LayoutParams params
                    = (AbsoluteLayout.LayoutParams) mWebTextView.getLayoutParams();
            MotionEvent fake = MotionEvent.obtain(mLastTouchTime,
                    mLastTouchTime, MotionEvent.ACTION_DOWN,
                    mLastTouchX - params.x + mScrollX,
                    mLastTouchY - params.y + mScrollY, 0);
            mWebTextView.dispatchTouchEvent(fake);
            return mWebTextView.performLongClick();
        }
        if (mSelectingText) return false; // long click does nothing on selection
        /* if long click brings up a context menu, the super function
         * returns true and we're done. Otherwise, nothing happened when
         * the user clicked. */
        if (super.performLongClick()) {
            return true;
        }
        /* In the case where the application hasn't already handled the long
         * click action, look for a word under the  click. If one is found,
         * animate the text selection into view.
         * FIXME: no animation code yet */
        final boolean isSelecting = selectText();
        if (isSelecting) {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }
        return isSelecting;
    }

    /**
     * Select the word at the last click point.
     *
     * @hide pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.966 -0500", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "5575D4C90B08DF2F911F065FF58FC197")
    
public boolean selectText() {
        int x = viewToContentX(mLastTouchX + mScrollX);
        int y = viewToContentY(mLastTouchY + mScrollY);
        return selectText(x, y);
    }

    /**
     * Select the word at the indicated content coordinates.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.968 -0500", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "B52E6A452332503A396253DC5399F744")
    
boolean selectText(int x, int y) {
        if (!setUpSelect(true, x, y)) {
            return false;
        }
        nativeSetExtendSelection();
        mDrawSelectionPointer = false;
        mTouchMode = TOUCH_DRAG_MODE;
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.972 -0500", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "F15DF8D8A1DAE432E57D2C2558C85553")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        mCachedOverlappingActionModeHeight = -1;
        if (mSelectingText && mOrientation != newConfig.orientation) {
            selectionDone();
        }
        mOrientation = newConfig.orientation;
        if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        }
    }

    /**
     * Check to see if the focused textfield/textarea is still on screen.  If it
     * is, update the the dimensions and location of WebTextView.  Otherwise,
     * remove the WebTextView.  Should be called when the zoom level changes.
     * @param intersection How to determine whether the textfield/textarea is
     *        still on screen.
     * @return boolean True if the textfield/textarea is still on screen and the
     *         dimensions/location of WebTextView have been updated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.985 -0500", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "79C53C915A6E23FC6D1B406EE6814E88")
    
private boolean didUpdateWebTextViewDimensions(int intersection) {
        Rect contentBounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(contentBounds);
        Rect visibleRect = new Rect();
        calcOurVisibleRect(visibleRect);
        offsetByLayerScrollPosition(vBox);
        // If the textfield is on screen, place the WebTextView in
        // its new place, accounting for our new scroll/zoom values,
        // and adjust its textsize.
        boolean onScreen;
        switch (intersection) {
            case FULLY_ON_SCREEN:
                onScreen = visibleRect.contains(vBox);
                break;
            case INTERSECTS_SCREEN:
                onScreen = Rect.intersects(visibleRect, vBox);
                break;
            case ANYWHERE:
                onScreen = true;
                break;
            default:
                throw new AssertionError(
                        "invalid parameter passed to didUpdateWebTextViewDimensions");
        }
        if (onScreen) {
            mWebTextView.setRect(vBox.left, vBox.top, vBox.width(),
                    vBox.height());
            mWebTextView.updateTextSize();
            updateWebTextViewPadding();
            return true;
        } else {
            // The textfield is now off screen.  The user probably
            // was not zooming to see the textfield better.  Remove
            // the WebTextView.  If the user types a key, and the
            // textfield is still in focus, we will reconstruct
            // the WebTextView and scroll it back on screen.
            mWebTextView.remove();
            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.987 -0500", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "9B31B74C60F30199CE857326BDEBCB37")
    
private void offsetByLayerScrollPosition(Rect box) {
        if ((mCurrentScrollingLayerId != 0)
                && (mCurrentScrollingLayerId == nativeFocusCandidateLayerId())) {
            box.offsetTo(box.left - mScrollingLayerRect.left,
                    box.top - mScrollingLayerRect.top);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.989 -0500", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07")
    
void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        if (mNativeClass == 0)
            return;
        nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                isPictureAfterFirstLayout, registerPageSwapCallback);
        if (mHTML5VideoViewProxy != null) {
            mHTML5VideoViewProxy.setBaseLayer(layer);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.991 -0500", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "D4D775641116CD07F30FDC12383A0B44")
    
int getBaseLayer() {
        if (mNativeClass == 0) {
            return 0;
        }
        return nativeGetBaseLayer();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.993 -0500", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "0D34572BF80A1E628DE82CF2E303B51A")
    
private void onZoomAnimationStart() {
        // If it is in password mode, turn it off so it does not draw misplaced.
        if (inEditingMode()) {
            mWebTextView.setVisibility(INVISIBLE);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.995 -0500", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "E9AE899400E1180973AF83EA50A29D44")
    
private void onZoomAnimationEnd() {
        // adjust the edit text view if needed
        if (inEditingMode()
                && didUpdateWebTextViewDimensions(FULLY_ON_SCREEN)) {
            // If it is a password field, start drawing the WebTextView once
            // again.
            mWebTextView.setVisibility(VISIBLE);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.997 -0500", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "D76312EAEA392F17B2BD7F48A7BA5E85")
    
void onFixedLengthZoomAnimationStart() {
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.000 -0500", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "7728365CE5185BB89BE1B9394D71C9F8")
    
void onFixedLengthZoomAnimationEnd() {
        if (!mBlockWebkitViewMessages && !mSelectingText) {
            WebViewCore.resumeUpdatePicture(mWebViewCore);
        }
        onZoomAnimationEnd();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.014 -0500", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "C6178A3AFDAAD88E8F6E2CEE62E9982B")
    
private void drawCoreAndCursorRing(Canvas canvas, int color,
        boolean drawCursorRing) {
        if (mDrawHistory) {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            canvas.drawPicture(mHistoryPicture);
            return;
        }
        if (mNativeClass == 0) return;

        boolean animateZoom = mZoomManager.isFixedLengthAnimationInProgress();
        boolean animateScroll = ((!mScroller.isFinished()
                || mVelocityTracker != null)
                && (mTouchMode != TOUCH_DRAG_MODE ||
                mHeldMotionless != MOTIONLESS_TRUE))
                || mDeferTouchMode == TOUCH_DRAG_MODE;
        if (mTouchMode == TOUCH_DRAG_MODE) {
            if (mHeldMotionless == MOTIONLESS_PENDING) {
                mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                mHeldMotionless = MOTIONLESS_FALSE;
            }
            if (mHeldMotionless == MOTIONLESS_FALSE) {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(DRAG_HELD_MOTIONLESS), MOTIONLESS_TIME);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                mHeldMotionless = MOTIONLESS_PENDING;
            }
        }
        int saveCount = canvas.save();
        if (animateZoom) {
            mZoomManager.animateZoom(canvas);
        } else if (!canvas.isHardwareAccelerated()) {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
        }

        boolean UIAnimationsRunning = false;
        // Currently for each draw we compute the animation values;
        // We may in the future decide to do that independently.
        if (mNativeClass != 0 && !canvas.isHardwareAccelerated()
                && nativeEvaluateLayersAnimations(mNativeClass)) {
            UIAnimationsRunning = true;
            // If we have unfinished (or unstarted) animations,
            // we ask for a repaint. We only need to do this in software
            // rendering (with hardware rendering we already have a different
            // method of requesting a repaint)
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
            invalidate();
        }

        // decide which adornments to draw
        int extras = DRAW_EXTRAS_NONE;
        if (mFindIsUp) {
            extras = DRAW_EXTRAS_FIND;
        } else if (mSelectingText && (!USE_JAVA_TEXT_SELECTION || DEBUG_TEXT_HANDLES)) {
            extras = DRAW_EXTRAS_SELECTION;
            nativeSetSelectionPointer(mNativeClass,
                    mDrawSelectionPointer,
                    mZoomManager.getInvScale(), mSelectX, mSelectY - getTitleHeight());
        } else if (drawCursorRing) {
            extras = DRAW_EXTRAS_CURSOR_RING;
        }
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "mFindIsUp=" + mFindIsUp
                    + " mSelectingText=" + mSelectingText
                    + " nativePageShouldHandleShiftAndArrows()="
                    + nativePageShouldHandleShiftAndArrows()
                    + " animateZoom=" + animateZoom
                    + " extras=" + extras);
        }

        calcOurContentVisibleRectF(mVisibleContentRect);
        if (canvas.isHardwareAccelerated()) {
            Rect glRectViewport = mGLViewportEmpty ? null : mGLRectViewport;
            Rect viewRectViewport = mGLViewportEmpty ? null : mViewRectViewport;

            int functor = nativeGetDrawGLFunction(mNativeClass, glRectViewport,
                    viewRectViewport, mVisibleContentRect, getScale(), extras);
            ((HardwareCanvas) canvas).callDrawGLFunction(functor);
            if (mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled()) {
                mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                nativeUseHardwareAccelSkia(mHardwareAccelSkia);
            }

        } else {
            DrawFilter df = null;
            if (mZoomManager.isZoomAnimating() || UIAnimationsRunning) {
                df = mZoomFilter;
            } else if (animateScroll) {
                df = mScrollFilter;
            }
            canvas.setDrawFilter(df);
            // XXX: Revisit splitting content.  Right now it causes a
            // synchronization problem with layers.
            int content = nativeDraw(canvas, mVisibleContentRect, color,
                    extras, false);
            canvas.setDrawFilter(null);
            if (!mBlockWebkitViewMessages && content != 0) {
                mWebViewCore.sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
            }
        }

        canvas.restoreToCount(saveCount);
        if (mSelectingText && USE_JAVA_TEXT_SELECTION) {
            drawTextSelectionHandles(canvas);
        }

        if (extras == DRAW_EXTRAS_CURSOR_RING) {
            if (mTouchMode == TOUCH_SHORTPRESS_START_MODE) {
                mTouchMode = TOUCH_SHORTPRESS_MODE;
            }
        }
        if (mFocusSizeChanged) {
            mFocusSizeChanged = false;
            // If we are zooming, this will get handled above, when the zoom
            // finishes.  We also do not need to do this unless the WebTextView
            // is showing. With hardware acceleration, the pageSwapCallback()
            // updates the WebTextView position in sync with page swapping
            if (!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode()) {
                didUpdateWebTextViewDimensions(ANYWHERE);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.017 -0500", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "6F3C01E8372575B6D6AB10AC39A7858A")
    
private void drawTextSelectionHandles(Canvas canvas) {
        if (mTextSelectionPaint == null) {
            mTextSelectionPaint = new Paint();
            mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        }
        mTextSelectionRegion.setEmpty();
        nativeGetTextSelectionRegion(mNativeClass, mTextSelectionRegion);
        Rect r = new Rect();
        RegionIterator iter = new RegionIterator(mTextSelectionRegion);
        Rect clip = canvas.getClipBounds();
        while (iter.next(r)) {
            r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
            if (r.intersect(clip)) {
                canvas.drawRect(r, mTextSelectionPaint);
            }
        }
        if (mSelectHandleLeft == null) {
            mSelectHandleLeft = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_left);
        }
        int[] handles = new int[4];
        nativeGetSelectionHandles(mNativeClass, handles);
        int start_x = contentToViewDimension(handles[0]);
        int start_y = contentToViewDimension(handles[1]);
        int end_x = contentToViewDimension(handles[2]);
        int end_y = contentToViewDimension(handles[3]);
        // Magic formula copied from TextView
        start_x -= (mSelectHandleLeft.getIntrinsicWidth() * 3) / 4;
        mSelectHandleLeft.setBounds(start_x, start_y,
                start_x + mSelectHandleLeft.getIntrinsicWidth(),
                start_y + mSelectHandleLeft.getIntrinsicHeight());
        if (mSelectHandleRight == null) {
            mSelectHandleRight = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_right);
        }
        end_x -= mSelectHandleRight.getIntrinsicWidth() / 4;
        mSelectHandleRight.setBounds(end_x, end_y,
                end_x + mSelectHandleRight.getIntrinsicWidth(),
                end_y + mSelectHandleRight.getIntrinsicHeight());
        if (DEBUG_TEXT_HANDLES) {
            mSelectHandleLeft.setAlpha(125);
            mSelectHandleRight.setAlpha(125);
        }
        mSelectHandleLeft.draw(canvas);
        mSelectHandleRight.draw(canvas);
    }

    // Only check the flag, can be called from WebCore thread
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.027 -0500", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "079D561B903F747D50B5A79B1ECD14A7")
    
boolean drawHistory() {
        return mDrawHistory;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.029 -0500", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "03914C35D57FCC88F6BB8A1539696293")
    
int getHistoryPictureWidth() {
        return (mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0;
    }

    // Should only be called in UI thread
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.032 -0500", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "169EC9B57049181BC7DA856A8BDE1A3D")
    
void switchOutDrawHistory() {
        if (null == mWebViewCore) return; // CallbackProxy may trigger this
        if (mDrawHistory && (getProgress() == 100 || nativeHasContent())) {
            mDrawHistory = false;
            mHistoryPicture = null;
            invalidate();
            int oldScrollX = mScrollX;
            int oldScrollY = mScrollY;
            mScrollX = pinLocX(mScrollX);
            mScrollY = pinLocY(mScrollY);
            if (oldScrollX != mScrollX || oldScrollY != mScrollY) {
                onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
            } else {
                sendOurVisibleRect();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.034 -0500", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "C39AA31A6BA8457E4DE9A390830947C7")
    
WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData result = cursorDataNoPosition();
        Point position = nativeCursorPosition();
        result.mX = position.x;
        result.mY = position.y;
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.036 -0500", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "A984EE77267D92EBC297A83944E36AE0")
    
WebViewCore.CursorData cursorDataNoPosition() {
        WebViewCore.CursorData result = new WebViewCore.CursorData();
        result.mMoveGeneration = nativeMoveGeneration();
        result.mFrame = nativeCursorFramePointer();
        return result;
    }

    /**
     *  Delete text from start to end in the focused textfield. If there is no
     *  focus, or if start == end, silently fail.  If start and end are out of
     *  order, swap them.
     *  @param  start   Beginning of selection to delete.
     *  @param  end     End of selection to delete.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.038 -0500", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "7E748FE119FB7A0AE13E567E94DF9EED")
    
void deleteSelection(int start, int end) {
        mTextGeneration++;
        WebViewCore.TextSelectionData data
                = new WebViewCore.TextSelectionData(start, end);
        mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                data);
    }

    /**
     *  Set the selection to (start, end) in the focused textfield. If start and
     *  end are out of order, swap them.
     *  @param  start   Beginning of selection.
     *  @param  end     End of selection.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.040 -0500", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "894990055202EB09B0889C114864FFFB")
    
void setSelection(int start, int end) {
        if (mWebViewCore != null) {
            mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.042 -0500", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "033181D4BD6A104349AD268A9062B9E9")
    
@Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
      InputConnection connection = super.onCreateInputConnection(outAttrs);
      outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
      return connection;
    }

    /**
     * Called in response to a message from webkit telling us that the soft
     * keyboard should be launched.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.045 -0500", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "53396EFB1163BD100A6CE2A8D7C56228")
    
private void displaySoftKeyboard(boolean isTextView) {
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        // bring it back to the default level scale so that user can enter text
        boolean zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        if (zoom) {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        }
        if (isTextView) {
            rebuildWebTextView();
            if (inEditingMode()) {
                imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                if (zoom) {
                    didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                }
                return;
            }
        }
        // Used by plugins and contentEditable.
        // Also used if the navigation cache is out of date, and
        // does not recognize that a textfield is in focus.  In that
        // case, use WebView as the targeted view.
        // see http://b/issue?id=2457459
        imm.showSoftInput(this, 0);
    }

    // Called by WebKit to instruct the UI to hide the keyboard
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.047 -0500", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "C4721AF2C5C0C9614FC4F06D2A058208")
    
private void hideSoftKeyboard() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null && (imm.isActive(this)
                || (inEditingMode() && imm.isActive(mWebTextView)))) {
            imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
        }
    }

    /*
     * This method checks the current focus and cursor and potentially rebuilds
     * mWebTextView to have the appropriate properties, such as password,
     * multiline, and what text it contains.  It also removes it if necessary.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.049 -0500", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "429FB32643665F506A03B43314523307")
    
void rebuildWebTextView() {
        // If the WebView does not have focus, do nothing until it gains focus.
        if (!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus())) {
            return;
        }
        boolean alreadyThere = inEditingMode();
        // inEditingMode can only return true if mWebTextView is non-null,
        // so we can safely call remove() if (alreadyThere)
        if (0 == mNativeClass || !nativeFocusCandidateIsTextInput()) {
            if (alreadyThere) {
                mWebTextView.remove();
            }
            return;
        }
        // At this point, we know we have found an input field, so go ahead
        // and create the WebTextView if necessary.
        if (mWebTextView == null) {
            mWebTextView = new WebTextView(mContext, WebView.this, mAutoFillData.getQueryId());
            // Initialize our generation number.
            mTextGeneration = 0;
        }
        mWebTextView.updateTextSize();
        updateWebTextViewPosition();
        String text = nativeFocusCandidateText();
        int nodePointer = nativeFocusCandidatePointer();
        // This needs to be called before setType, which may call
        // requestFormData, and it needs to have the correct nodePointer.
        mWebTextView.setNodePointer(nodePointer);
        mWebTextView.setType(nativeFocusCandidateType());
        // Gravity needs to be set after setType
        mWebTextView.setGravityForRtl(nativeFocusCandidateIsRtlText());
        if (null == text) {
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "rebuildWebTextView null == text");
            }
            text = "";
        }
        mWebTextView.setTextAndKeepSelection(text);
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null && imm.isActive(mWebTextView)) {
            imm.restartInput(mWebTextView);
            mWebTextView.clearComposingText();
        }
        if (isFocused()) {
            mWebTextView.requestFocus();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.052 -0500", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "4908313FEB040629A814A8CDB317705F")
    
private void updateWebTextViewPosition() {
        Rect visibleRect = new Rect();
        calcOurContentVisibleRect(visibleRect);
        // Note that sendOurVisibleRect calls viewToContent, so the coordinates
        // should be in content coordinates.
        Rect bounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(bounds);
        offsetByLayerScrollPosition(vBox);
        mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        if (!Rect.intersects(bounds, visibleRect)) {
            revealSelection();
        }
        updateWebTextViewPadding();
    }

    /**
     * Update the padding of mWebTextView based on the native textfield/textarea
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.054 -0500", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "ABE088F792BFFAA5C9E93F6237E16D22")
    
void updateWebTextViewPadding() {
        Rect paddingRect = nativeFocusCandidatePaddingRect();
        if (paddingRect != null) {
            // Use contentToViewDimension since these are the dimensions of
            // the padding.
            mWebTextView.setPadding(
                    contentToViewDimension(paddingRect.left),
                    contentToViewDimension(paddingRect.top),
                    contentToViewDimension(paddingRect.right),
                    contentToViewDimension(paddingRect.bottom));
        }
    }

    /**
     * Tell webkit to put the cursor on screen.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.057 -0500", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "75BA4FD21197C06422E03F26B8B18909")
    
void revealSelection() {
        if (mWebViewCore != null) {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        }
    }

    /**
     * Called by WebTextView to find saved form data associated with the
     * textfield
     * @param name Name of the textfield.
     * @param nodePointer Pointer to the node of the textfield, so it can be
     *          compared to the currently focused textfield when the data is
     *          retrieved.
     * @param autoFillable true if WebKit has determined this field is part of
     *          a form that can be auto filled.
     * @param autoComplete true if the attribute "autocomplete" is set to true
     *          on the textfield.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.059 -0500", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "276F36A490F8AABA2644120A754BA7BF")
    
void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        if (mWebViewCore.getSettings().getSaveFormData()) {
            Message update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
            update.arg1 = nodePointer;
            RequestFormData updater = new RequestFormData(name, getUrl(),
                    update, autoFillable, autoComplete);
            Thread t = new Thread(updater);
            t.start();
        }
    }

    /**
     * Pass a message to find out the <label> associated with the <input>
     * identified by nodePointer
     * @param framePointer Pointer to the frame containing the <input> node
     * @param nodePointer Pointer to the node for which a <label> is desired.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.061 -0500", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "91B9F6932FB01733CE18E8B916887FAE")
    
void requestLabel(int framePointer, int nodePointer) {
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
    }

    /**
     * Dump the display tree to "/sdcard/displayTree.txt"
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.085 -0500", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "E79E369D34325D9B2A39E9D3D391D60C")
    
public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
    }

    /**
     * Dump the dom tree to adb shell if "toFile" is False, otherwise dump it to
     * "/sdcard/domTree.txt"
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.087 -0500", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "1D6F0F77C05AC697559096E32BB304C8")
    
public void dumpDomTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
    }

    /**
     * Dump the render tree to adb shell if "toFile" is False, otherwise dump it
     * to "/sdcard/renderTree.txt"
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.089 -0500", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "E7A12322F9EA6579335811D4D36C60DF")
    
public void dumpRenderTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
    }

    /**
     * Called by DRT on UI thread, need to proxy to WebCore thread.
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.091 -0500", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "B30DDDBF1E45B335AD8393DFE989DD16")
    
public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
    }

    /**
     * Called by DRT on WebCore thread.
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.093 -0500", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "E366CA2D07689A76CB98F76EE2B9BFAF")
    
public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
    }

    /**
     * Dump the V8 counters to standard output.
     * Note that you need a build with V8 and WEBCORE_INSTRUMENTATION set to
     * true. Otherwise, this will do nothing.
     *
     * @hide debug only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.095 -0500", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "43603260A0EB7FA7D616B0CD22031C70")
    
public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.100 -0500", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "82958EEB1CDA0768BEAC6D53C84959E7")
    
@Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        if (mBlockWebkitViewMessages) {
            return false;
        }
        // send complex characters to webkit for use by JS and plugins
        if (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null) {
            // pass the key to DOM
            mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            // return true as DOM handles the key
            return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.102 -0500", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "A11ABE9645CFB85AB3245D436E4A8107")
    
private boolean isEnterActionKey(int keyCode) {
        return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                || keyCode == KeyEvent.KEYCODE_ENTER
                || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.108 -0500", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "C2DDDDFFB4F8C77D4EB072F25282AE65")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "keyDown at " + System.currentTimeMillis()
                    + "keyCode=" + keyCode
                    + ", " + event + ", unicode=" + event.getUnicodeChar());
        }
        if (mBlockWebkitViewMessages) {
            return false;
        }

        // don't implement accelerator keys here; defer to host application
        if (event.isCtrlPressed()) {
            return false;
        }

        if (mNativeClass == 0) {
            return false;
        }

        // do this hack up front, so it always works, regardless of touch-mode
        if (AUTO_REDRAW_HACK && (keyCode == KeyEvent.KEYCODE_CALL)) {
            mAutoRedraw = !mAutoRedraw;
            if (mAutoRedraw) {
                invalidate();
            }
            return true;
        }

        // Bubble up the key event if
        // 1. it is a system key; or
        // 2. the host application wants to handle it;
        if (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event)) {
            return false;
        }

        // accessibility support
        if (accessibilityScriptInjected()) {
            if (AccessibilityManager.getInstance(mContext).isEnabled()) {
                // if an accessibility script is injected we delegate to it the key handling.
                // this script is a screen reader which is a fully fledged solution for blind
                // users to navigate in and interact with web pages.
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                return true;
            } else {
                // Clean up if accessibility was disabled after loading the current URL.
                mAccessibilityScriptInjected = false;
            }
        } else if (mAccessibilityInjector != null) {
            if (AccessibilityManager.getInstance(mContext).isEnabled()) {
                if (mAccessibilityInjector.onKeyEvent(event)) {
                    // if an accessibility injector is present (no JavaScript enabled or the site
                    // opts out injecting our JavaScript screen reader) we let it decide whether
                    // to act on and consume the event.
                    return true;
                }
            } else {
                // Clean up if accessibility was disabled after loading the current URL.
                mAccessibilityInjector = null;
            }
        }

        if (keyCode == KeyEvent.KEYCODE_PAGE_UP) {
            if (event.hasNoModifiers()) {
                pageUp(false);
                return true;
            } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                pageUp(true);
                return true;
            }
        }

        if (keyCode == KeyEvent.KEYCODE_PAGE_DOWN) {
            if (event.hasNoModifiers()) {
                pageDown(false);
                return true;
            } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                pageDown(true);
                return true;
            }
        }

        if (keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers()) {
            pageUp(true);
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers()) {
            pageDown(true);
            return true;
        }

        if (keyCode >= KeyEvent.KEYCODE_DPAD_UP
                && keyCode <= KeyEvent.KEYCODE_DPAD_RIGHT) {
            switchOutDrawHistory();
            if (nativePageShouldHandleShiftAndArrows()) {
                letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                return true;
            }
            if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_UP:
                        pageUp(true);
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        pageDown(true);
                        return true;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        nativeClearCursor(); // start next trackball movement from page edge
                        return pinScrollTo(0, mScrollY, true, 0);
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        nativeClearCursor(); // start next trackball movement from page edge
                        return pinScrollTo(mContentWidth, mScrollY, true, 0);
                }
            }
            if (mSelectingText) {
                int xRate = keyCode == KeyEvent.KEYCODE_DPAD_LEFT
                    ? -1 : keyCode == KeyEvent.KEYCODE_DPAD_RIGHT ? 1 : 0;
                int yRate = keyCode == KeyEvent.KEYCODE_DPAD_UP ?
                    -1 : keyCode == KeyEvent.KEYCODE_DPAD_DOWN ? 1 : 0;
                int multiplier = event.getRepeatCount() + 1;
                moveSelection(xRate * multiplier, yRate * multiplier);
                return true;
            }
            if (navHandledKey(keyCode, 1, false, event.getEventTime())) {
                playSoundEffect(keyCodeToSoundsEffect(keyCode));
                return true;
            }
            // Bubble up the key event as WebView doesn't handle it
            return false;
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            switchOutDrawHistory();
            boolean wantsKeyEvents = nativeCursorNodePointer() == 0
                || nativeCursorWantsKeyEvents();
            if (event.getRepeatCount() == 0) {
                if (mSelectingText) {
                    return true; // discard press if copy in progress
                }
                mGotCenterDown = true;
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
                if (!wantsKeyEvents) return true;
            }
            // Bubble up the key event as WebView doesn't handle it
            if (!wantsKeyEvents) return false;
        }

        if (getSettings().getNavDump()) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_4:
                    dumpDisplayTree();
                    break;
                case KeyEvent.KEYCODE_5:
                case KeyEvent.KEYCODE_6:
                    dumpDomTree(keyCode == KeyEvent.KEYCODE_5);
                    break;
                case KeyEvent.KEYCODE_7:
                case KeyEvent.KEYCODE_8:
                    dumpRenderTree(keyCode == KeyEvent.KEYCODE_7);
                    break;
                case KeyEvent.KEYCODE_9:
                    nativeInstrumentReport();
                    return true;
            }
        }

        if (nativeCursorIsTextInput()) {
            // This message will put the node in focus, for the DOM's notion
            // of focus.
            mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
            // This will bring up the WebTextView and put it in focus, for
            // our view system's notion of focus
            rebuildWebTextView();
            // Now we need to pass the event to it
            if (inEditingMode()) {
                mWebTextView.setDefaultSelection();
                return mWebTextView.dispatchKeyEvent(event);
            }
        } else if (nativeHasFocusNode()) {
            // In this case, the cursor is not on a text input, but the focus
            // might be.  Check it, and if so, hand over to the WebTextView.
            rebuildWebTextView();
            if (inEditingMode()) {
                mWebTextView.setDefaultSelection();
                return mWebTextView.dispatchKeyEvent(event);
            }
        }

        // TODO: should we pass all the keys to DOM or check the meta tag
        if (nativeCursorWantsKeyEvents() || true) {
            // pass the key to DOM
            mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            // return true as DOM handles the key
            return true;
        }

        // Bubble up the key event as WebView doesn't handle it
        return false;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.113 -0500", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "B117E42AB9A0C0868602CFBF46853AF0")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "keyUp at " + System.currentTimeMillis()
                    + ", " + event + ", unicode=" + event.getUnicodeChar());
        }
        if (mBlockWebkitViewMessages) {
            return false;
        }

        if (mNativeClass == 0) {
            return false;
        }

        // special CALL handling when cursor node's href is "tel:XXX"
        if (keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode()) {
            String text = nativeCursorText();
            if (!nativeCursorIsTextInput() && text != null
                    && text.startsWith(SCHEME_TEL)) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(text));
                getContext().startActivity(intent);
                return true;
            }
        }

        // Bubble up the key event if
        // 1. it is a system key; or
        // 2. the host application wants to handle it;
        if (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event)) {
            return false;
        }

        // accessibility support
        if (accessibilityScriptInjected()) {
            if (AccessibilityManager.getInstance(mContext).isEnabled()) {
                // if an accessibility script is injected we delegate to it the key handling.
                // this script is a screen reader which is a fully fledged solution for blind
                // users to navigate in and interact with web pages.
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
                return true;
            } else {
                // Clean up if accessibility was disabled after loading the current URL.
                mAccessibilityScriptInjected = false;
            }
        } else if (mAccessibilityInjector != null) {
            if (AccessibilityManager.getInstance(mContext).isEnabled()) {
                if (mAccessibilityInjector.onKeyEvent(event)) {
                    // if an accessibility injector is present (no JavaScript enabled or the site
                    // opts out injecting our JavaScript screen reader) we let it decide whether to
                    // act on and consume the event.
                    return true;
                }
            } else {
                // Clean up if accessibility was disabled after loading the current URL.
                mAccessibilityInjector = null;
            }
        }

        if (keyCode >= KeyEvent.KEYCODE_DPAD_UP
                && keyCode <= KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (nativePageShouldHandleShiftAndArrows()) {
                letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                return true;
            }
            // always handle the navigation keys in the UI thread
            // Bubble up the key event as WebView doesn't handle it
            return false;
        }

        if (isEnterActionKey(keyCode)) {
            // remove the long press message first
            mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            mGotCenterDown = false;

            if (mSelectingText) {
                if (mExtendSelection) {
                    copySelection();
                    selectionDone();
                } else {
                    mExtendSelection = true;
                    nativeSetExtendSelection();
                    invalidate(); // draw the i-beam instead of the arrow
                }
                return true; // discard press if copy in progress
            }

            // perform the single click
            Rect visibleRect = sendOurVisibleRect();
            // Note that sendOurVisibleRect calls viewToContent, so the
            // coordinates should be in content coordinates.
            if (!nativeCursorIntersects(visibleRect)) {
                return false;
            }
            WebViewCore.CursorData data = cursorData();
            mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
            playSoundEffect(SoundEffectConstants.CLICK);
            if (nativeCursorIsTextInput()) {
                rebuildWebTextView();
                centerKeyPressOnTextField();
                if (inEditingMode()) {
                    mWebTextView.setDefaultSelection();
                }
                return true;
            }
            clearTextEntry();
            nativeShowCursorTimed();
            if (mCallbackProxy.uiOverrideUrlLoading(nativeCursorText())) {
                return true;
            }
            if (nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents()) {
                mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                return true;
            }
        }

        // TODO: should we pass all the keys to DOM or check the meta tag
        if (nativeCursorWantsKeyEvents() || true) {
            // pass the key to DOM
            mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            // return true as DOM handles the key
            return true;
        }

        // Bubble up the key event as WebView doesn't handle it
        return false;
    }

    /*
     * Enter selecting text mode, and see if CAB should be shown.
     * Returns true if the WebView is now in
     * selecting text mode (including if it was already in that mode, and this
     * method did nothing).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.116 -0500", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "47892130207B91B623DB5E66266B24B8")
    
private boolean setUpSelect(boolean selectWord, int x, int y) {
        if (0 == mNativeClass) return false; // client isn't initialized
        if (inFullScreenMode()) return false;
        if (mSelectingText) return true;
        nativeResetSelection();
        if (selectWord && !nativeWordSelection(x, y)) {
            selectionDone();
            return false;
        }
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
        if (startActionMode(mSelectCallback) == null) {
            // There is no ActionMode, so do not allow the user to modify a
            // selection.
            selectionDone();
            return false;
        }
        mExtendSelection = false;
        mSelectingText = mDrawSelectionPointer = true;
        if (DEBUG_TEXT_HANDLES) {
            // Debugging text handles requires running in software mode
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
        // don't let the picture change during text selection
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        if (nativeHasCursorNode()) {
            Rect rect = nativeCursorNodeBounds();
            mSelectX = contentToViewX(rect.left);
            mSelectY = contentToViewY(rect.top);
        } else if (mLastTouchY > getVisibleTitleHeightImpl()) {
            mSelectX = mScrollX + mLastTouchX;
            mSelectY = mScrollY + mLastTouchY;
        } else {
            mSelectX = mScrollX + getViewWidth() / 2;
            mSelectY = mScrollY + getViewHeightWithTitle() / 2;
        }
        nativeHideCursor();
        mMinAutoScrollX = 0;
        mMaxAutoScrollX = getViewWidth();
        mMinAutoScrollY = 0;
        mMaxAutoScrollY = getViewHeightWithTitle();
        mCurrentScrollingLayerId = nativeScrollableLayer(viewToContentX(mSelectX),
                viewToContentY(mSelectY), mScrollingLayerRect,
                mScrollingLayerBounds);
        if (mCurrentScrollingLayerId != 0) {
            if (mScrollingLayerRect.left != mScrollingLayerRect.right) {
                mMinAutoScrollX = Math.max(mMinAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.left));
                mMaxAutoScrollX = Math.min(mMaxAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.right));
            }
            if (mScrollingLayerRect.top != mScrollingLayerRect.bottom) {
                mMinAutoScrollY = Math.max(mMinAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.top));
                mMaxAutoScrollY = Math.min(mMaxAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.bottom));
            }
        }
        mMinAutoScrollX += SELECT_SCROLL;
        mMaxAutoScrollX -= SELECT_SCROLL;
        mMinAutoScrollY += SELECT_SCROLL;
        mMaxAutoScrollY -= SELECT_SCROLL;
        return true;
    }

    /**
     * Use this method to put the WebView into text selection mode.
     * Do not rely on this functionality; it will be deprecated in the future.
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.118 -0500", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "EDFF97818EEB45D698C46880BA32FBC9")
    
@Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
    }

    /**
     * Select all of the text in this WebView.
     *
     * @hide pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.121 -0500", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "49AB9E2CD4E335C8745BA8CD5969873E")
    
public void selectAll() {
        if (0 == mNativeClass) return; // client isn't initialized
        if (inFullScreenMode()) return;
        if (!mSelectingText) {
            // retrieve a point somewhere within the text
            Point select = nativeSelectableText();
            if (!selectText(select.x, select.y)) return;
        }
        nativeSelectAll();
        mDrawSelectionPointer = false;
        mExtendSelection = true;
        invalidate();
    }

    /**
     * Called when the selection has been removed.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.123 -0500", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "51A3DB2B77F266FAFED94283A9485521")
    
void selectionDone() {
        if (mSelectingText) {
            mSelectingText = false;
            if (DEBUG_TEXT_HANDLES) {
                // Debugging text handles required running in software mode, set
                // back to default now
                setLayerType(LAYER_TYPE_NONE, null);
            }
            // finish is idempotent, so this is fine even if selectionDone was
            // called by mSelectCallback.onDestroyActionMode
            mSelectCallback.finish();
            mSelectCallback = null;
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            invalidate(); // redraw without selection
            mAutoScrollX = 0;
            mAutoScrollY = 0;
            mSentAutoScrollMessage = false;
        }
    }

    /**
     * Copy the selection to the clipboard
     *
     * @hide pending API council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.125 -0500", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "5479DFB9DF31C4AB4167EC826B2A7BDC")
    
public boolean copySelection() {
        boolean copiedSomething = false;
        String selection = getSelection();
        if (selection != null && selection != "") {
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "copySelection \"" + selection + "\"");
            }
            Toast.makeText(mContext
                    , com.android.internal.R.string.text_copied
                    , Toast.LENGTH_SHORT).show();
            copiedSomething = true;
            ClipboardManager cm = (ClipboardManager)getContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(selection);
        }
        invalidate(); // remove selection region and pointer
        return copiedSomething;
    }

    /**
     * @hide pending API Council approval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.128 -0500", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "80FD6A75F26A59E3FA117B363CB7E35F")
    
public SearchBox getSearchBox() {
        if ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null)) {
            return null;
        }
        return mWebViewCore.getBrowserFrame().getSearchBox();
    }

    /**
     * Returns the currently highlighted text as a string.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.130 -0500", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "A676AD565525EE3D82CB063563895008")
    
String getSelection() {
        if (mNativeClass == 0) return "";
        return nativeGetSelection();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.133 -0500", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "5F8FF49238949244D6972B9F61BEF82D")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (hasWindowFocus()) setActive(true);
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        if (mGlobalLayoutListener == null) {
            mGlobalLayoutListener = new InnerGlobalLayoutListener();
            treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        }
        if (mScrollChangedListener == null) {
            mScrollChangedListener = new InnerScrollChangedListener();
            treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        }

        addAccessibilityApisToJavaScript();

        mTouchEventQueue.reset();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.135 -0500", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "8CB4B504026DA5C0D66E79B844E6B39F")
    
@Override
    protected void onDetachedFromWindow() {
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        if (hasWindowFocus()) setActive(false);

        final ViewTreeObserver treeObserver = getViewTreeObserver();
        if (mGlobalLayoutListener != null) {
            treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            mGlobalLayoutListener = null;
        }
        if (mScrollChangedListener != null) {
            treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            mScrollChangedListener = null;
        }

        removeAccessibilityApisFromJavaScript();

        super.onDetachedFromWindow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.138 -0500", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "643A3BCC50BD9448DC4DD2DC2C928374")
    
@Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        // The zoomManager may be null if the webview is created from XML that
        // specifies the view's visibility param as not visible (see http://b/2794841)
        if (visibility != View.VISIBLE && mZoomManager != null) {
            mZoomManager.dismissZoomPicker();
        }
        updateDrawingState();
    }

    /**
     * @deprecated WebView no longer needs to implement
     * ViewGroup.OnHierarchyChangeListener.  This method does nothing now.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.140 -0500", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "06EC805D332001D6B8070E27E89BC6FA")
    
@Deprecated
    public void onChildViewAdded(View parent, View child) {}

    /**
     * @deprecated WebView no longer needs to implement
     * ViewGroup.OnHierarchyChangeListener.  This method does nothing now.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.142 -0500", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "34135DF19B3E8C9E82644162DAB7E071")
    
@Deprecated
    public void onChildViewRemoved(View p, View child) {}

    /**
     * @deprecated WebView should not have implemented
     * ViewTreeObserver.OnGlobalFocusChangeListener. This method does nothing now.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.144 -0500", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "DEDCFA6878FEABC0FA813EB9A0D449FF")
    
@Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.147 -0500", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "412829C4C3078A2260809ABAEDA017B6")
    
void setActive(boolean active) {
        if (active) {
            if (hasFocus()) {
                // If our window regained focus, and we have focus, then begin
                // drawing the cursor ring
                mDrawCursorRing = !inEditingMode();
                setFocusControllerActive(true);
            } else {
                mDrawCursorRing = false;
                if (!inEditingMode()) {
                    // If our window gained focus, but we do not have it, do not
                    // draw the cursor ring.
                    setFocusControllerActive(false);
                }
                // We do not call recordButtons here because we assume
                // that when we lost focus, or window focus, it got called with
                // false for the first parameter
            }
        } else {
            if (!mZoomManager.isZoomPickerVisible()) {
                /*
                 * The external zoom controls come in their own window, so our
                 * window loses focus. Our policy is to not draw the cursor ring
                 * if our window is not focused, but this is an exception since
                 * the user can still navigate the web page with the zoom
                 * controls showing.
                 */
                mDrawCursorRing = false;
            }
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            mTouchMode = TOUCH_DONE_MODE;
            setFocusControllerActive(false);
        }
        invalidate();
    }

    // To avoid drawing the cursor ring, and remove the TextView when our window
    // loses focus.
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.149 -0500", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "E8F00BA2B6F2130275F5EE2C371431EF")
    
@Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        setActive(hasWindowFocus);
        if (hasWindowFocus) {
            JWebCoreJavaBridge.setActiveWebView(this);
            if (mPictureUpdatePausedForFocusChange) {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = false;
            }
        } else {
            JWebCoreJavaBridge.removeActiveWebView(this);
            final WebSettings settings = getSettings();
            if (settings != null && settings.enableSmoothTransition() &&
                    mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore)) {
                WebViewCore.pauseUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = true;
            }
        }
        super.onWindowFocusChanged(hasWindowFocus);
    }

    /*
     * Pass a message to WebCore Thread, telling the WebCore::Page's
     * FocusController to be  "inactive" so that it will
     * not draw the blinking cursor.  It gets set to "active" to draw the cursor
     * in WebViewCore.cpp, when the WebCore thread receives key events/clicks.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.152 -0500", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "66C277B994D82AEF93E8C73E3DBBC938")
    
void setFocusControllerActive(boolean active) {
        if (mWebViewCore == null) return;
        mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        // Need to send this message after the document regains focus.
        if (active && mListBoxMessage != null) {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.155 -0500", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "4D2B220AB3AFECE4E1445E87C7A279A5")
    
@Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "MT focusChanged " + focused + ", " + direction);
        }
        if (focused) {
            // When we regain focus, if we have window focus, resume drawing
            // the cursor ring
            if (hasWindowFocus()) {
                mDrawCursorRing = !inEditingMode();
                setFocusControllerActive(true);
            //} else {
                // The WebView has gained focus while we do not have
                // windowfocus.  When our window lost focus, we should have
                // called recordButtons(false...)
            }
        } else {
            // When we lost focus, unless focus went to the TextView (which is
            // true if we are in editing mode), stop drawing the cursor ring.
            mDrawCursorRing = false;
            if (!inEditingMode()) {
                setFocusControllerActive(false);
            }
            mKeysPressed.clear();
        }

        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.157 -0500", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "8C10A3B755F09E2AFA9D197F002F8A9C")
    
void setGLRectViewport() {
        // Use the getGlobalVisibleRect() to get the intersection among the parents
        // visible == false means we're clipped - send a null rect down to indicate that
        // we should not draw
        boolean visible = getGlobalVisibleRect(mGLRectViewport);
        if (visible) {
            // Then need to invert the Y axis, just for GL
            View rootView = getRootView();
            int rootViewHeight = rootView.getHeight();
            mViewRectViewport.set(mGLRectViewport);
            int savedWebViewBottom = mGLRectViewport.bottom;
            mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            mGLViewportEmpty = false;
        } else {
            mGLViewportEmpty = true;
        }
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.160 -0500", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "69A59C5C4A0568EC5BAE8C1504F6B848")
    
@Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed = super.setFrame(left, top, right, bottom);
        if (!changed && mHeightCanMeasure) {
            // When mHeightCanMeasure is true, we will set mLastHeightSent to 0
            // in WebViewCore after we get the first layout. We do call
            // requestLayout() when we get contentSizeChanged(). But the View
            // system won't call onSizeChanged if the dimension is not changed.
            // In this case, we need to call sendViewSizeZoom() explicitly to
            // notify the WebKit about the new dimensions.
            sendViewSizeZoom(false);
        }
        setGLRectViewport();
        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.162 -0500", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "0D8D40D76437DD89C41CE59164FFF87B")
    
@Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        super.onSizeChanged(w, h, ow, oh);

        // adjust the max viewport width depending on the view dimensions. This
        // is to ensure the scaling is not going insane. So do not shrink it if
        // the view size is temporarily smaller, e.g. when soft keyboard is up.
        int newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        if (newMaxViewportWidth > sMaxViewportWidth) {
            sMaxViewportWidth = newMaxViewportWidth;
        }

        mZoomManager.onSizeChanged(w, h, ow, oh);

        if (mLoadedPicture != null && mDelaySetPicture == null) {
            // Size changes normally result in a new picture
            // Re-set the loaded picture to simulate that
            // However, do not update the base layer as that hasn't changed
            setNewPicture(mLoadedPicture, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.165 -0500", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "BFB3929C352ECA6EC9B985D4FEF8F093")
    
@Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (!mInOverScrollMode) {
            sendOurVisibleRect();
            // update WebKit if visible title bar height changed. The logic is same
            // as getVisibleTitleHeightImpl.
            int titleHeight = getTitleHeight();
            if (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0)) {
                sendViewSizeZoom(false);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.167 -0500", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "DC2D5182AC949B07569F56672D303479")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.ACTION_DOWN:
                mKeysPressed.add(Integer.valueOf(event.getKeyCode()));
                break;
            case KeyEvent.ACTION_MULTIPLE:
                // Always accept the action.
                break;
            case KeyEvent.ACTION_UP:
                int location = mKeysPressed.indexOf(Integer.valueOf(event.getKeyCode()));
                if (location == -1) {
                    // We did not receive the key down for this key, so do not
                    // handle the key up.
                    return false;
                } else {
                    // We did receive the key down.  Handle the key up, and
                    // remove it from our pressed keys.
                    mKeysPressed.remove(location);
                }
                break;
            default:
                // Accept the action.  This should not happen, unless a new
                // action is added to KeyEvent.
                break;
        }
        if (inEditingMode() && mWebTextView.isFocused()) {
            // Ensure that the WebTextView gets the event, even if it does
            // not currently have a bounds.
            return mWebTextView.dispatchKeyEvent(event);
        } else {
            return super.dispatchKeyEvent(event);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.186 -0500", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "1B82DE51A2E32A0B10F9F2A2C6E8D733")
    
private boolean hitFocusedPlugin(int contentX, int contentY) {
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "nativeFocusIsPlugin()=" + nativeFocusIsPlugin());
            Rect r = nativeFocusNodeBounds();
            Log.v(LOGTAG, "nativeFocusNodeBounds()=(" + r.left + ", " + r.top
                    + ", " + r.right + ", " + r.bottom + ")");
        }
        return nativeFocusIsPlugin()
                && nativeFocusNodeBounds().contains(contentX, contentY);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.188 -0500", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "2D2BA664519E4D5096A370BF2CE030C2")
    
private boolean shouldForwardTouchEvent() {
        if (mFullScreenHolder != null) return true;
        if (mBlockWebkitViewMessages) return false;
        return mForwardTouchEvents
                && !mSelectingText
                && mPreventDefault != PREVENT_DEFAULT_IGNORE
                && mPreventDefault != PREVENT_DEFAULT_NO;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.191 -0500", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "9A1FA92748EFCF215BA79CCF8E5DC16E")
    
private boolean inFullScreenMode() {
        return mFullScreenHolder != null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.193 -0500", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "91EBEC88B98CF657FD269C7847768632")
    
private void dismissFullScreenMode() {
        if (inFullScreenMode()) {
            mFullScreenHolder.hide();
            mFullScreenHolder = null;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.195 -0500", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "E398EFAA2C9E24B229C24A6148F651DD")
    
void onPinchToZoomAnimationStart() {
        // cancel the single touch handling
        cancelTouch();
        onZoomAnimationStart();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.197 -0500", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "A3C68FAF5A30AAB15D7F4CF8404737D2")
    
void onPinchToZoomAnimationEnd(ScaleGestureDetector detector) {
        onZoomAnimationEnd();
        // start a drag, TOUCH_PINCH_DRAG, can't use TOUCH_INIT_MODE as
        // it may trigger the unwanted click, can't use TOUCH_DRAG_MODE
        // as it may trigger the unwanted fling.
        mTouchMode = TOUCH_PINCH_DRAG;
        mConfirmMove = true;
        startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
    }

    // See if there is a layer at x, y and switch to TOUCH_DRAG_LAYER_MODE if a
    // layer is found.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.199 -0500", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "979BA420C9EB4E79240479D12AB5BD89")
    
private void startScrollingLayer(float x, float y) {
        int contentX = viewToContentX((int) x + mScrollX);
        int contentY = viewToContentY((int) y + mScrollY);
        mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                mScrollingLayerRect, mScrollingLayerBounds);
        if (mCurrentScrollingLayerId != 0) {
            mTouchMode = TOUCH_DRAG_LAYER_MODE;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.207 -0500", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "E093DFA49F8E2982920FA2F78A464F5D")
    
@Override
    public boolean onHoverEvent(MotionEvent event) {
        if (mNativeClass == 0) {
            return false;
        }
        WebViewCore.CursorData data = cursorDataNoPosition();
        data.mX = viewToContentX((int) event.getX() + mScrollX);
        data.mY = viewToContentY((int) event.getY() + mScrollY);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        return true;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.209 -0500", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "2679FA7075D2EC221912DDD2609E8353")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mNativeClass == 0 || (!isClickable() && !isLongClickable())) {
            return false;
        }

        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, ev + " at " + ev.getEventTime()
                + " mTouchMode=" + mTouchMode
                + " numPointers=" + ev.getPointerCount());
        }

        // If WebKit wasn't interested in this multitouch gesture, enqueue
        // the event for handling directly rather than making the round trip
        // to WebKit and back.
        if (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO) {
            passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
        } else {
            mTouchEventQueue.enqueueTouchEvent(ev);
        }

        // Since all events are handled asynchronously, we always want the gesture stream.
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.211 -0500", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "B836AFFE79A549B48D7669E1C18BD84C")
    
private float calculateDragAngle(int dx, int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        return (float) Math.atan2(dy, dx);
    }

    /*
     * Common code for single touch and multi-touch.
     * (x, y) denotes current focus point, which is the touch point for single touch
     * and the middle point for multi-touch.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.227 -0500", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "38D7A4FD8C9348965B3D03FC332DA9E0")
    
private boolean handleTouchEventCommon(MotionEvent ev, int action, int x, int y) {
        long eventTime = ev.getEventTime();

        // Due to the touch screen edge effect, a touch closer to the edge
        // always snapped to the edge. As getViewWidth() can be different from
        // getWidth() due to the scrollbar, adjusting the point to match
        // getViewWidth(). Same applied to the height.
        x = Math.min(x, getViewWidth() - 1);
        y = Math.min(y, getViewHeightWithTitle() - 1);

        int deltaX = mLastTouchX - x;
        int deltaY = mLastTouchY - y;
        int contentX = viewToContentX(x + mScrollX);
        int contentY = viewToContentY(y + mScrollY);

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mPreventDefault = PREVENT_DEFAULT_NO;
                mConfirmMove = false;
                mInitialHitTestResult = null;
                if (!mScroller.isFinished()) {
                    // stop the current scroll animation, but if this is
                    // the start of a fling, allow it to add to the current
                    // fling's velocity
                    mScroller.abortAnimation();
                    mTouchMode = TOUCH_DRAG_START_MODE;
                    mConfirmMove = true;
                    nativeSetIsScrolling(false);
                } else if (mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP)) {
                    mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
                    if (USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
                        removeTouchHighlight();
                    }
                    if (deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare) {
                        mTouchMode = TOUCH_DOUBLE_TAP_MODE;
                    } else {
                        // commit the short press action for the previous tap
                        doShortPress();
                        mTouchMode = TOUCH_INIT_MODE;
                        mDeferTouchProcess = !mBlockWebkitViewMessages
                                && (!inFullScreenMode() && mForwardTouchEvents)
                                ? hitFocusedPlugin(contentX, contentY)
                                : false;
                    }
                } else { // the normal case
                    mTouchMode = TOUCH_INIT_MODE;
                    mDeferTouchProcess = !mBlockWebkitViewMessages
                            && (!inFullScreenMode() && mForwardTouchEvents)
                            ? hitFocusedPlugin(contentX, contentY)
                            : false;
                    if (!mBlockWebkitViewMessages) {
                        mWebViewCore.sendMessage(
                                EventHub.UPDATE_FRAME_CACHE_IF_LOADING);
                    }
                    if (USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
                        TouchHighlightData data = new TouchHighlightData();
                        data.mX = contentX;
                        data.mY = contentY;
                        data.mNativeLayerRect = new Rect();
                        data.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, data.mNativeLayerRect, null);
                        data.mSlop = viewToContentDimension(mNavSlop);
                        mTouchHighlightRegion.setEmpty();
                        if (!mBlockWebkitViewMessages) {
                            mTouchHighlightRequested = System.currentTimeMillis();
                            mWebViewCore.sendMessageAtFrontOfQueue(
                                    EventHub.GET_TOUCH_HIGHLIGHT_RECTS, data);
                        }
                        if (DEBUG_TOUCH_HIGHLIGHT) {
                            if (getSettings().getNavDump()) {
                                mTouchHighlightX = (int) x + mScrollX;
                                mTouchHighlightY = (int) y + mScrollY;
                                mPrivateHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        mTouchHighlightX = mTouchHighlightY = 0;
                                        invalidate();
                                    }
                                }, TOUCH_HIGHLIGHT_ELAPSE_TIME);
                            }
                        }
                    }
                    if (mLogEvent && eventTime - mLastTouchUpTime < 1000) {
                        EventLog.writeEvent(EventLogTags.BROWSER_DOUBLE_TAP_DURATION,
                                (eventTime - mLastTouchUpTime), eventTime);
                    }
                    if (mSelectingText) {
                        mDrawSelectionPointer = false;
                        mSelectionStarted = nativeStartSelection(contentX, contentY);
                        if (DebugFlags.WEB_VIEW) {
                            Log.v(LOGTAG, "select=" + contentX + "," + contentY);
                        }
                        invalidate();
                    }
                }
                // Trigger the link
                if (!mSelectingText && (mTouchMode == TOUCH_INIT_MODE
                        || mTouchMode == TOUCH_DOUBLE_TAP_MODE)) {
                    mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_SHORTPRESS, TAP_TIMEOUT);
                    mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_LONGPRESS, LONG_PRESS_TIMEOUT);
                    if (inFullScreenMode() || mDeferTouchProcess) {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } else if (!mBlockWebkitViewMessages && mForwardTouchEvents) {
                        mPreventDefault = PREVENT_DEFAULT_MAYBE_YES;
                    } else {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                    }
                    // pass the touch events from UI thread to WebCore thread
                    if (shouldForwardTouchEvent()) {
                        TouchEventData ted = new TouchEventData();
                        ted.mAction = action;
                        ted.mIds = new int[1];
                        ted.mIds[0] = ev.getPointerId(0);
                        ted.mPoints = new Point[1];
                        ted.mPoints[0] = new Point(contentX, contentY);
                        ted.mPointsInView = new Point[1];
                        ted.mPointsInView[0] = new Point(x, y);
                        ted.mMetaState = ev.getMetaState();
                        ted.mReprocess = mDeferTouchProcess;
                        ted.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, ted.mNativeLayerRect, null);
                        ted.mSequence = mTouchEventQueue.nextTouchSequence();
                        mTouchEventQueue.preQueueTouchEventData(ted);
                        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                        if (mDeferTouchProcess) {
                            // still needs to set them for compute deltaX/Y
                            mLastTouchX = x;
                            mLastTouchY = y;
                            break;
                        }
                        if (!inFullScreenMode()) {
                            mPrivateHandler.removeMessages(PREVENT_DEFAULT_TIMEOUT);
                            mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                    .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                            action, 0), TAP_TIMEOUT);
                        }
                    }
                }
                startTouch(x, y, eventTime);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                boolean firstMove = false;
                if (!mConfirmMove && (deltaX * deltaX + deltaY * deltaY)
                        >= mTouchSlopSquare) {
                    mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    mConfirmMove = true;
                    firstMove = true;
                    if (mTouchMode == TOUCH_DOUBLE_TAP_MODE) {
                        mTouchMode = TOUCH_INIT_MODE;
                    }
                    if (USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
                        removeTouchHighlight();
                    }
                }
                // pass the touch events from UI thread to WebCore thread
                if (shouldForwardTouchEvent() && mConfirmMove && (firstMove
                        || eventTime - mLastSentTouchTime > mCurrentTouchInterval)) {
                    TouchEventData ted = new TouchEventData();
                    ted.mAction = action;
                    ted.mIds = new int[1];
                    ted.mIds[0] = ev.getPointerId(0);
                    ted.mPoints = new Point[1];
                    ted.mPoints[0] = new Point(contentX, contentY);
                    ted.mPointsInView = new Point[1];
                    ted.mPointsInView[0] = new Point(x, y);
                    ted.mMetaState = ev.getMetaState();
                    ted.mReprocess = mDeferTouchProcess;
                    ted.mNativeLayer = mCurrentScrollingLayerId;
                    ted.mNativeLayerRect.set(mScrollingLayerRect);
                    ted.mSequence = mTouchEventQueue.nextTouchSequence();
                    mTouchEventQueue.preQueueTouchEventData(ted);
                    mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                    mLastSentTouchTime = eventTime;
                    if (mDeferTouchProcess) {
                        break;
                    }
                    if (firstMove && !inFullScreenMode()) {
                        mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                        action, 0), TAP_TIMEOUT);
                    }
                }
                if (mTouchMode == TOUCH_DONE_MODE
                        || mPreventDefault == PREVENT_DEFAULT_YES) {
                    // no dragging during scroll zoom animation, or when prevent
                    // default is yes
                    break;
                }
                if (mVelocityTracker == null) {
                    Log.e(LOGTAG, "Got null mVelocityTracker when "
                            + "mPreventDefault = " + mPreventDefault
                            + " mDeferTouchProcess = " + mDeferTouchProcess
                            + " mTouchMode = " + mTouchMode);
                } else {
                    mVelocityTracker.addMovement(ev);
                }
                if (mSelectingText && mSelectionStarted) {
                    if (DebugFlags.WEB_VIEW) {
                        Log.v(LOGTAG, "extend=" + contentX + "," + contentY);
                    }
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    mAutoScrollX = x <= mMinAutoScrollX ? -SELECT_SCROLL
                            : x >= mMaxAutoScrollX ? SELECT_SCROLL : 0;
                    mAutoScrollY = y <= mMinAutoScrollY ? -SELECT_SCROLL
                            : y >= mMaxAutoScrollY ? SELECT_SCROLL : 0;
                    if ((mAutoScrollX != 0 || mAutoScrollY != 0)
                            && !mSentAutoScrollMessage) {
                        mSentAutoScrollMessage = true;
                        mPrivateHandler.sendEmptyMessageDelayed(
                                SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                    }
                    if (deltaX != 0 || deltaY != 0) {
                        nativeExtendSelection(contentX, contentY);
                        invalidate();
                    }
                    break;
                }

                if (mTouchMode != TOUCH_DRAG_MODE &&
                        mTouchMode != TOUCH_DRAG_LAYER_MODE) {

                    if (!mConfirmMove) {
                        break;
                    }

                    if (mPreventDefault == PREVENT_DEFAULT_MAYBE_YES
                            || mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN) {
                        // track mLastTouchTime as we may need to do fling at
                        // ACTION_UP
                        mLastTouchTime = eventTime;
                        break;
                    }

                    // Only lock dragging to one axis if we don't have a scale in progress.
                    // Scaling implies free-roaming movement. Note this is only ever a question
                    // if mZoomManager.supportsPanDuringZoom() is true.
                    final ScaleGestureDetector detector =
                      mZoomManager.getMultiTouchGestureDetector();
                    mAverageAngle = calculateDragAngle(deltaX, deltaY);
                    if (detector == null || !detector.isInProgress()) {
                        // if it starts nearly horizontal or vertical, enforce it
                        if (mAverageAngle < HSLOPE_TO_START_SNAP) {
                            mSnapScrollMode = SNAP_X;
                            mSnapPositive = deltaX > 0;
                            mAverageAngle = ANGLE_HORIZ;
                        } else if (mAverageAngle > VSLOPE_TO_START_SNAP) {
                            mSnapScrollMode = SNAP_Y;
                            mSnapPositive = deltaY > 0;
                            mAverageAngle = ANGLE_VERT;
                        }
                    }

                    mTouchMode = TOUCH_DRAG_MODE;
                    mLastTouchX = x;
                    mLastTouchY = y;
                    deltaX = 0;
                    deltaY = 0;

                    startScrollingLayer(x, y);
                    startDrag();
                }

                // do pan
                boolean done = false;
                boolean keepScrollBarsVisible = false;
                if (deltaX == 0 && deltaY == 0) {
                    keepScrollBarsVisible = done = true;
                } else {
                    mAverageAngle +=
                        (calculateDragAngle(deltaX, deltaY) - mAverageAngle)
                        / MMA_WEIGHT_N;
                    if (mSnapScrollMode != SNAP_NONE) {
                        if (mSnapScrollMode == SNAP_Y) {
                            // radical change means getting out of snap mode
                            if (mAverageAngle < VSLOPE_TO_BREAK_SNAP) {
                                mSnapScrollMode = SNAP_NONE;
                            }
                        }
                        if (mSnapScrollMode == SNAP_X) {
                            // radical change means getting out of snap mode
                            if (mAverageAngle > HSLOPE_TO_BREAK_SNAP) {
                                mSnapScrollMode = SNAP_NONE;
                            }
                        }
                    } else {
                        if (mAverageAngle < HSLOPE_TO_START_SNAP) {
                            mSnapScrollMode = SNAP_X;
                            mSnapPositive = deltaX > 0;
                            mAverageAngle = (mAverageAngle + ANGLE_HORIZ) / 2;
                        } else if (mAverageAngle > VSLOPE_TO_START_SNAP) {
                            mSnapScrollMode = SNAP_Y;
                            mSnapPositive = deltaY > 0;
                            mAverageAngle = (mAverageAngle + ANGLE_VERT) / 2;
                        }
                    }
                    if (mSnapScrollMode != SNAP_NONE) {
                        if ((mSnapScrollMode & SNAP_X) == SNAP_X) {
                            deltaY = 0;
                        } else {
                            deltaX = 0;
                        }
                    }
                    mLastTouchX = x;
                    mLastTouchY = y;

                    if (deltaX * deltaX + deltaY * deltaY > mTouchSlopSquare) {
                        mHeldMotionless = MOTIONLESS_FALSE;
                        nativeSetIsScrolling(true);
                    } else {
                        mHeldMotionless = MOTIONLESS_TRUE;
                        nativeSetIsScrolling(false);
                        keepScrollBarsVisible = true;
                    }

                    mLastTouchTime = eventTime;
                }

                doDrag(deltaX, deltaY);

                // Turn off scrollbars when dragging a layer.
                if (keepScrollBarsVisible &&
                        mTouchMode != TOUCH_DRAG_LAYER_MODE) {
                    if (mHeldMotionless != MOTIONLESS_TRUE) {
                        mHeldMotionless = MOTIONLESS_TRUE;
                        invalidate();
                    }
                    // keep the scrollbar on the screen even there is no scroll
                    awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(),
                            false);
                    // Post a message so that we'll keep them alive while we're not scrolling.
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                            .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                    // return false to indicate that we can't pan out of the
                    // view space
                    return !done;
                } else {
                    mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                if (!isFocused()) requestFocus();
                // pass the touch events from UI thread to WebCore thread
                if (shouldForwardTouchEvent()) {
                    TouchEventData ted = new TouchEventData();
                    ted.mIds = new int[1];
                    ted.mIds[0] = ev.getPointerId(0);
                    ted.mAction = action;
                    ted.mPoints = new Point[1];
                    ted.mPoints[0] = new Point(contentX, contentY);
                    ted.mPointsInView = new Point[1];
                    ted.mPointsInView[0] = new Point(x, y);
                    ted.mMetaState = ev.getMetaState();
                    ted.mReprocess = mDeferTouchProcess;
                    ted.mNativeLayer = mCurrentScrollingLayerId;
                    ted.mNativeLayerRect.set(mScrollingLayerRect);
                    ted.mSequence = mTouchEventQueue.nextTouchSequence();
                    mTouchEventQueue.preQueueTouchEventData(ted);
                    mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                }
                mLastTouchUpTime = eventTime;
                if (mSentAutoScrollMessage) {
                    mAutoScrollX = mAutoScrollY = 0;
                }
                switch (mTouchMode) {
                    case TOUCH_DOUBLE_TAP_MODE: // double tap
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                        if (inFullScreenMode() || mDeferTouchProcess) {
                            TouchEventData ted = new TouchEventData();
                            ted.mIds = new int[1];
                            ted.mIds[0] = ev.getPointerId(0);
                            ted.mAction = WebViewCore.ACTION_DOUBLETAP;
                            ted.mPoints = new Point[1];
                            ted.mPoints[0] = new Point(contentX, contentY);
                            ted.mPointsInView = new Point[1];
                            ted.mPointsInView[0] = new Point(x, y);
                            ted.mMetaState = ev.getMetaState();
                            ted.mReprocess = mDeferTouchProcess;
                            ted.mNativeLayer = nativeScrollableLayer(
                                    contentX, contentY,
                                    ted.mNativeLayerRect, null);
                            ted.mSequence = mTouchEventQueue.nextTouchSequence();
                            mTouchEventQueue.preQueueTouchEventData(ted);
                            mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                        } else if (mPreventDefault != PREVENT_DEFAULT_YES){
                            mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                            mTouchMode = TOUCH_DONE_MODE;
                        }
                        break;
                    case TOUCH_INIT_MODE: // tap
                    case TOUCH_SHORTPRESS_START_MODE:
                    case TOUCH_SHORTPRESS_MODE:
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                        if (mConfirmMove) {
                            Log.w(LOGTAG, "Miss a drag as we are waiting for" +
                                    " WebCore's response for touch down.");
                            if (mPreventDefault != PREVENT_DEFAULT_YES
                                    && (computeMaxScrollX() > 0
                                            || computeMaxScrollY() > 0)) {
                                // If the user has performed a very quick touch
                                // sequence it is possible that we may get here
                                // before WebCore has had a chance to process the events.
                                // In this case, any call to preventDefault in the
                                // JS touch handler will not have been executed yet.
                                // Hence we will see both the UI (now) and WebCore
                                // (when context switches) handling the event,
                                // regardless of whether the web developer actually
                                // doeses preventDefault in their touch handler. This
                                // is the nature of our asynchronous touch model.

                                // we will not rewrite drag code here, but we
                                // will try fling if it applies.
                                WebViewCore.reducePriority();
                                // to get better performance, pause updating the
                                // picture
                                WebViewCore.pauseUpdatePicture(mWebViewCore);
                                // fall through to TOUCH_DRAG_MODE
                            } else {
                                // WebKit may consume the touch event and modify
                                // DOM. drawContentPicture() will be called with
                                // animateSroll as true for better performance.
                                // Force redraw in high-quality.
                                invalidate();
                                break;
                            }
                        } else {
                            if (mSelectingText) {
                                // tapping on selection or controls does nothing
                                if (!nativeHitSelection(contentX, contentY)) {
                                    selectionDone();
                                }
                                break;
                            }
                            // only trigger double tap if the WebView is
                            // scalable
                            if (mTouchMode == TOUCH_INIT_MODE
                                    && (canZoomIn() || canZoomOut())) {
                                mPrivateHandler.sendEmptyMessageDelayed(
                                        RELEASE_SINGLE_TAP, ViewConfiguration
                                                .getDoubleTapTimeout());
                            } else {
                                doShortPress();
                            }
                            break;
                        }
                    case TOUCH_DRAG_MODE:
                    case TOUCH_DRAG_LAYER_MODE:
                        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                        // if the user waits a while w/o moving before the
                        // up, we don't want to do a fling
                        if (eventTime - mLastTouchTime <= MIN_FLING_TIME) {
                            if (mVelocityTracker == null) {
                                Log.e(LOGTAG, "Got null mVelocityTracker when "
                                        + "mPreventDefault = "
                                        + mPreventDefault
                                        + " mDeferTouchProcess = "
                                        + mDeferTouchProcess);
                            } else {
                                mVelocityTracker.addMovement(ev);
                            }
                            // set to MOTIONLESS_IGNORE so that it won't keep
                            // removing and sending message in
                            // drawCoreAndCursorRing()
                            mHeldMotionless = MOTIONLESS_IGNORE;
                            doFling();
                            break;
                        } else {
                            if (mScroller.springBack(mScrollX, mScrollY, 0,
                                    computeMaxScrollX(), 0,
                                    computeMaxScrollY())) {
                                invalidate();
                            }
                        }
                        // redraw in high-quality, as we're done dragging
                        mHeldMotionless = MOTIONLESS_TRUE;
                        invalidate();
                        // fall through
                    case TOUCH_DRAG_START_MODE:
                        // TOUCH_DRAG_START_MODE should not happen for the real
                        // device as we almost certain will get a MOVE. But this
                        // is possible on emulator.
                        mLastVelocity = 0;
                        WebViewCore.resumePriority();
                        if (!mSelectingText) {
                            WebViewCore.resumeUpdatePicture(mWebViewCore);
                        }
                        break;
                }
                stopTouch();
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                if (mTouchMode == TOUCH_DRAG_MODE) {
                    mScroller.springBack(mScrollX, mScrollY, 0,
                            computeMaxScrollX(), 0, computeMaxScrollY());
                    invalidate();
                }
                cancelWebCoreTouchEvent(contentX, contentY, false);
                cancelTouch();
                break;
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.230 -0500", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "B867532DC17AB3A7D4A891B20071BDBA")
    
private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        TouchEventData ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        final int count = ev.getPointerCount();
        ted.mIds = new int[count];
        ted.mPoints = new Point[count];
        ted.mPointsInView = new Point[count];
        for (int c = 0; c < count; c++) {
            ted.mIds[c] = ev.getPointerId(c);
            int x = viewToContentX((int) ev.getX(c) + mScrollX);
            int y = viewToContentY((int) ev.getY(c) + mScrollY);
            ted.mPoints[c] = new Point(x, y);
            ted.mPointsInView[c] = new Point((int) ev.getX(c), (int) ev.getY(c));
        }
        if (ted.mAction == MotionEvent.ACTION_POINTER_DOWN
            || ted.mAction == MotionEvent.ACTION_POINTER_UP) {
            ted.mActionIndex = ev.getActionIndex();
        }
        ted.mMetaState = ev.getMetaState();
        ted.mReprocess = true;
        ted.mMotionEvent = MotionEvent.obtain(ev);
        ted.mSequence = sequence;
        mTouchEventQueue.preQueueTouchEventData(ted);
        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
        cancelLongPress();
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.233 -0500", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "5D07338F77E56BF9837D6B99048B7247")
    
void handleMultiTouchInWebView(MotionEvent ev) {
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "multi-touch: " + ev + " at " + ev.getEventTime()
                + " mTouchMode=" + mTouchMode
                + " numPointers=" + ev.getPointerCount()
                + " scrolloffset=(" + mScrollX + "," + mScrollY + ")");
        }

        final ScaleGestureDetector detector =
            mZoomManager.getMultiTouchGestureDetector();

        // A few apps use WebView but don't instantiate gesture detector.
        // We don't need to support multi touch for them.
        if (detector == null) return;

        float x = ev.getX();
        float y = ev.getY();

        if (mPreventDefault != PREVENT_DEFAULT_YES) {
            detector.onTouchEvent(ev);

            if (detector.isInProgress()) {
                if (DebugFlags.WEB_VIEW) {
                    Log.v(LOGTAG, "detector is in progress");
                }
                mLastTouchTime = ev.getEventTime();
                x = detector.getFocusX();
                y = detector.getFocusY();

                cancelLongPress();
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                if (!mZoomManager.supportsPanDuringZoom()) {
                    return;
                }
                mTouchMode = TOUCH_DRAG_MODE;
                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain();
                }
            }
        }

        int action = ev.getActionMasked();
        if (action == MotionEvent.ACTION_POINTER_DOWN) {
            cancelTouch();
            action = MotionEvent.ACTION_DOWN;
        } else if (action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2) {
            // set mLastTouchX/Y to the remaining points for multi-touch.
            mLastTouchX = Math.round(x);
            mLastTouchY = Math.round(y);
        } else if (action == MotionEvent.ACTION_MOVE) {
            // negative x or y indicate it is on the edge, skip it.
            if (x < 0 || y < 0) {
                return;
            }
        }

        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.237 -0500", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "A4BADCFAAEB7A29B57BAE96F8BD7C294")
    
private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        if (shouldForwardTouchEvent()) {
            if (removeEvents) {
                mWebViewCore.removeMessages(EventHub.TOUCH_EVENT);
            }
            TouchEventData ted = new TouchEventData();
            ted.mIds = new int[1];
            ted.mIds[0] = 0;
            ted.mPoints = new Point[1];
            ted.mPoints[0] = new Point(x, y);
            ted.mPointsInView = new Point[1];
            int viewX = contentToViewX(x) - mScrollX;
            int viewY = contentToViewY(y) - mScrollY;
            ted.mPointsInView[0] = new Point(viewX, viewY);
            ted.mAction = MotionEvent.ACTION_CANCEL;
            ted.mNativeLayer = nativeScrollableLayer(
                    x, y, ted.mNativeLayerRect, null);
            ted.mSequence = mTouchEventQueue.nextTouchSequence();
            mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
            mPreventDefault = PREVENT_DEFAULT_IGNORE;

            if (removeEvents) {
                // Mark this after sending the message above; we should
                // be willing to ignore the cancel event that we just sent.
                mTouchEventQueue.ignoreCurrentlyMissingEvents();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.239 -0500", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "F253793CE7B59335C4832396CBF0ADC6")
    
private void startTouch(float x, float y, long eventTime) {
        // Remember where the motion event started
        mStartTouchX = mLastTouchX = Math.round(x);
        mStartTouchY = mLastTouchY = Math.round(y);
        mLastTouchTime = eventTime;
        mVelocityTracker = VelocityTracker.obtain();
        mSnapScrollMode = SNAP_NONE;
        mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                ViewConfiguration.getTapTimeout());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.241 -0500", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "67A271A99FF445D8BBC06F59F2F14B61")
    
private void startDrag() {
        WebViewCore.reducePriority();
        // to get better performance, pause updating the picture
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);

        if (!mDragFromTextInput) {
            nativeHideCursor();
        }

        if (mHorizontalScrollBarMode != SCROLLBAR_ALWAYSOFF
                || mVerticalScrollBarMode != SCROLLBAR_ALWAYSOFF) {
            mZoomManager.invokeZoomPicker();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.244 -0500", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "00F037C87E79F02E3C0CFE129E1D33B8")
    
private void doDrag(int deltaX, int deltaY) {
        if ((deltaX | deltaY) != 0) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int rangeX = computeMaxScrollX();
            int rangeY = computeMaxScrollY();
            int overscrollDistance = mOverscrollDistance;

            // Check for the original scrolling layer in case we change
            // directions.  mTouchMode might be TOUCH_DRAG_MODE if we have
            // reached the edge of a layer but mScrollingLayer will be non-zero
            // if we initiated the drag on a layer.
            if (mCurrentScrollingLayerId != 0) {
                final int contentX = viewToContentDimension(deltaX);
                final int contentY = viewToContentDimension(deltaY);

                // Check the scrolling bounds to see if we will actually do any
                // scrolling.  The rectangle is in document coordinates.
                final int maxX = mScrollingLayerRect.right;
                final int maxY = mScrollingLayerRect.bottom;
                final int resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                final int resultY = Math.max(0,
                        Math.min(mScrollingLayerRect.top + contentY, maxY));

                if (resultX != mScrollingLayerRect.left ||
                        resultY != mScrollingLayerRect.top) {
                    // In case we switched to dragging the page.
                    mTouchMode = TOUCH_DRAG_LAYER_MODE;
                    deltaX = contentX;
                    deltaY = contentY;
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = maxX;
                    rangeY = maxY;
                } else {
                    // Scroll the main page if we are not going to scroll the
                    // layer.  This does not reset mScrollingLayer in case the
                    // user changes directions and the layer can scroll the
                    // other way.
                    mTouchMode = TOUCH_DRAG_MODE;
                }
            }

            if (mOverScrollGlow != null) {
                mOverScrollGlow.setOverScrollDeltas(deltaX, deltaY);
            }

            overScrollBy(deltaX, deltaY, oldX, oldY,
                    rangeX, rangeY,
                    mOverscrollDistance, mOverscrollDistance, true);
            if (mOverScrollGlow != null && mOverScrollGlow.isAnimating()) {
                invalidate();
            }
        }
        mZoomManager.keepZoomPickerVisible();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.248 -0500", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "08C9373D138F0E9F0D413FF961E6E03E")
    
private void stopTouch() {
        if (mScroller.isFinished() && !mSelectingText
                && (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE)) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        }

        // we also use mVelocityTracker == null to tell us that we are
        // not "moving around", so we can take the slower/prettier
        // mode in the drawing code
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }

        // Release any pulled glows
        if (mOverScrollGlow != null) {
            mOverScrollGlow.releaseAll();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.250 -0500", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "E3672290B170656017A5855E41AFBE54")
    
private void cancelTouch() {
        // we also use mVelocityTracker == null to tell us that we are
        // not "moving around", so we can take the slower/prettier
        // mode in the drawing code
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }

        if ((mTouchMode == TOUCH_DRAG_MODE
                || mTouchMode == TOUCH_DRAG_LAYER_MODE) && !mSelectingText) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        }
        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
        if (USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
            removeTouchHighlight();
        }
        mHeldMotionless = MOTIONLESS_TRUE;
        mTouchMode = TOUCH_DONE_MODE;
        nativeHideCursor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.253 -0500", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "7666B81C22F5AF84225B0E004063B978")
    
@Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_SCROLL: {
                    final float vscroll;
                    final float hscroll;
                    if ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0) {
                        vscroll = 0;
                        hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                    } else {
                        vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                        hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                    }
                    if (hscroll != 0 || vscroll != 0) {
                        final int vdelta = (int) (vscroll * getVerticalScrollFactor());
                        final int hdelta = (int) (hscroll * getHorizontalScrollFactor());
                        if (pinScrollBy(hdelta, vdelta, false, 0)) {
                            return true;
                        }
                    }
                }
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.319 -0500", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "12B92825F9AB7F7D77767E0280BB77E2")
    
public void setMapTrackballToArrowKeys(boolean setMap) {
        checkThread();
        mMapTrackballToArrowKeys = setMap;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.320 -0500", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "B9600CE64DC445389C4969B83D045257")
    
void resetTrackballTime() {
        mTrackballLastTime = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.324 -0500", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "409B199A4C56A037843D6EB7A9DC4555")
    
@Override
    public boolean onTrackballEvent(MotionEvent ev) {
        long time = ev.getEventTime();
        if ((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0) {
            if (ev.getY() > 0) pageDown(true);
            if (ev.getY() < 0) pageUp(true);
            return true;
        }
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (mSelectingText) {
                return true; // discard press if copy in progress
            }
            mTrackballDown = true;
            if (mNativeClass == 0) {
                return false;
            }
            if (time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds())) {
                nativeSelectBestAt(mLastCursorBounds);
            }
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "onTrackballEvent down ev=" + ev
                        + " time=" + time
                        + " mLastCursorTime=" + mLastCursorTime);
            }
            if (isInTouchMode()) requestFocusFromTouch();
            return false; // let common code in onKeyDown at it
        }
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            // LONG_PRESS_CENTER is set in common onKeyDown
            mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            mTrackballDown = false;
            mTrackballUpTime = time;
            if (mSelectingText) {
                if (mExtendSelection) {
                    copySelection();
                    selectionDone();
                } else {
                    mExtendSelection = true;
                    nativeSetExtendSelection();
                    invalidate(); // draw the i-beam instead of the arrow
                }
                return true; // discard press if copy in progress
            }
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "onTrackballEvent up ev=" + ev
                        + " time=" + time
                );
            }
            return false; // let common code in onKeyUp at it
        }
        if ((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
                AccessibilityManager.getInstance(mContext).isEnabled()) {
            if (DebugFlags.WEB_VIEW) Log.v(LOGTAG, "onTrackballEvent gmail quit");
            return false;
        }
        if (mTrackballDown) {
            if (DebugFlags.WEB_VIEW) Log.v(LOGTAG, "onTrackballEvent down quit");
            return true; // discard move if trackball is down
        }
        if (time - mTrackballUpTime < TRACKBALL_TIMEOUT) {
            if (DebugFlags.WEB_VIEW) Log.v(LOGTAG, "onTrackballEvent up timeout quit");
            return true;
        }
        // TODO: alternatively we can do panning as touch does
        switchOutDrawHistory();
        if (time - mTrackballLastTime > TRACKBALL_TIMEOUT) {
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "onTrackballEvent time="
                        + time + " last=" + mTrackballLastTime);
            }
            mTrackballFirstTime = time;
            mTrackballXMove = mTrackballYMove = 0;
        }
        mTrackballLastTime = time;
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "onTrackballEvent ev=" + ev + " time=" + time);
        }
        mTrackballRemainsX += ev.getX();
        mTrackballRemainsY += ev.getY();
        doTrackball(time, ev.getMetaState());
        return true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.327 -0500", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "D182A136D0B4338F5A241BF2E86510C3")
    
void moveSelection(float xRate, float yRate) {
        if (mNativeClass == 0)
            return;
        int width = getViewWidth();
        int height = getViewHeight();
        mSelectX += xRate;
        mSelectY += yRate;
        int maxX = width + mScrollX;
        int maxY = height + mScrollY;
        mSelectX = Math.min(maxX, Math.max(mScrollX - SELECT_CURSOR_OFFSET
                , mSelectX));
        mSelectY = Math.min(maxY, Math.max(mScrollY - SELECT_CURSOR_OFFSET
                , mSelectY));
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "moveSelection"
                    + " mSelectX=" + mSelectX
                    + " mSelectY=" + mSelectY
                    + " mScrollX=" + mScrollX
                    + " mScrollY=" + mScrollY
                    + " xRate=" + xRate
                    + " yRate=" + yRate
                    );
        }
        nativeMoveSelection(viewToContentX(mSelectX), viewToContentY(mSelectY));
        int scrollX = mSelectX < mScrollX ? -SELECT_CURSOR_OFFSET
                : mSelectX > maxX - SELECT_CURSOR_OFFSET ? SELECT_CURSOR_OFFSET
                : 0;
        int scrollY = mSelectY < mScrollY ? -SELECT_CURSOR_OFFSET
                : mSelectY > maxY - SELECT_CURSOR_OFFSET ? SELECT_CURSOR_OFFSET
                : 0;
        pinScrollBy(scrollX, scrollY, true, 0);
        Rect select = new Rect(mSelectX, mSelectY, mSelectX + 1, mSelectY + 1);
        requestRectangleOnScreen(select);
        invalidate();
   }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.330 -0500", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "1EDEE8A2C7E4336C8A02F363558DBF5E")
    
private int scaleTrackballX(float xRate, int width) {
        int xMove = (int) (xRate / TRACKBALL_SCALE * width);
        int nextXMove = xMove;
        if (xMove > 0) {
            if (xMove > mTrackballXMove) {
                xMove -= mTrackballXMove;
            }
        } else if (xMove < mTrackballXMove) {
            xMove -= mTrackballXMove;
        }
        mTrackballXMove = nextXMove;
        return xMove;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.332 -0500", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "5D47331C92C07BD87A0DFC30A573AD6B")
    
private int scaleTrackballY(float yRate, int height) {
        int yMove = (int) (yRate / TRACKBALL_SCALE * height);
        int nextYMove = yMove;
        if (yMove > 0) {
            if (yMove > mTrackballYMove) {
                yMove -= mTrackballYMove;
            }
        } else if (yMove < mTrackballYMove) {
            yMove -= mTrackballYMove;
        }
        mTrackballYMove = nextYMove;
        return yMove;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.335 -0500", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "837A404A9E6C9A97F68B4AAAE96C0F7C")
    
private int keyCodeToSoundsEffect(int keyCode) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                return SoundEffectConstants.NAVIGATION_UP;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                return SoundEffectConstants.NAVIGATION_RIGHT;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                return SoundEffectConstants.NAVIGATION_DOWN;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                return SoundEffectConstants.NAVIGATION_LEFT;
        }
        throw new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.339 -0500", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "CB5ECC30B6029B70FC6EA74CB61A76AB")
    
private void doTrackball(long time, int metaState) {
        int elapsed = (int) (mTrackballLastTime - mTrackballFirstTime);
        if (elapsed == 0) {
            elapsed = TRACKBALL_TIMEOUT;
        }
        float xRate = mTrackballRemainsX * 1000 / elapsed;
        float yRate = mTrackballRemainsY * 1000 / elapsed;
        int viewWidth = getViewWidth();
        int viewHeight = getViewHeight();
        if (mSelectingText) {
            if (!mDrawSelectionPointer) {
                // The last selection was made by touch, disabling drawing the
                // selection pointer. Allow the trackball to adjust the
                // position of the touch control.
                mSelectX = contentToViewX(nativeSelectionX());
                mSelectY = contentToViewY(nativeSelectionY());
                mDrawSelectionPointer = mExtendSelection = true;
                nativeSetExtendSelection();
            }
            moveSelection(scaleTrackballX(xRate, viewWidth),
                    scaleTrackballY(yRate, viewHeight));
            mTrackballRemainsX = mTrackballRemainsY = 0;
            return;
        }
        float ax = Math.abs(xRate);
        float ay = Math.abs(yRate);
        float maxA = Math.max(ax, ay);
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "doTrackball elapsed=" + elapsed
                    + " xRate=" + xRate
                    + " yRate=" + yRate
                    + " mTrackballRemainsX=" + mTrackballRemainsX
                    + " mTrackballRemainsY=" + mTrackballRemainsY);
        }
        int width = mContentWidth - viewWidth;
        int height = mContentHeight - viewHeight;
        if (width < 0) width = 0;
        if (height < 0) height = 0;
        ax = Math.abs(mTrackballRemainsX * TRACKBALL_MULTIPLIER);
        ay = Math.abs(mTrackballRemainsY * TRACKBALL_MULTIPLIER);
        maxA = Math.max(ax, ay);
        int count = Math.max(0, (int) maxA);
        int oldScrollX = mScrollX;
        int oldScrollY = mScrollY;
        if (count > 0) {
            int selectKeyCode = ax < ay ? mTrackballRemainsY < 0 ?
                    KeyEvent.KEYCODE_DPAD_UP : KeyEvent.KEYCODE_DPAD_DOWN :
                    mTrackballRemainsX < 0 ? KeyEvent.KEYCODE_DPAD_LEFT :
                    KeyEvent.KEYCODE_DPAD_RIGHT;
            count = Math.min(count, TRACKBALL_MOVE_COUNT);
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "doTrackball keyCode=" + selectKeyCode
                        + " count=" + count
                        + " mTrackballRemainsX=" + mTrackballRemainsX
                        + " mTrackballRemainsY=" + mTrackballRemainsY);
            }
            if (mNativeClass != 0 && nativePageShouldHandleShiftAndArrows()) {
                for (int i = 0; i < count; i++) {
                    letPageHandleNavKey(selectKeyCode, time, true, metaState);
                }
                letPageHandleNavKey(selectKeyCode, time, false, metaState);
            } else if (navHandledKey(selectKeyCode, count, false, time)) {
                playSoundEffect(keyCodeToSoundsEffect(selectKeyCode));
            }
            mTrackballRemainsX = mTrackballRemainsY = 0;
        }
        if (count >= TRACKBALL_SCROLL_COUNT) {
            int xMove = scaleTrackballX(xRate, width);
            int yMove = scaleTrackballY(yRate, height);
            if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "doTrackball pinScrollBy"
                        + " count=" + count
                        + " xMove=" + xMove + " yMove=" + yMove
                        + " mScrollX-oldScrollX=" + (mScrollX-oldScrollX)
                        + " mScrollY-oldScrollY=" + (mScrollY-oldScrollY)
                        );
            }
            if (Math.abs(mScrollX - oldScrollX) > Math.abs(xMove)) {
                xMove = 0;
            }
            if (Math.abs(mScrollY - oldScrollY) > Math.abs(yMove)) {
                yMove = 0;
            }
            if (xMove != 0 || yMove != 0) {
                pinScrollBy(xMove, yMove, true, 0);
            }
        }
    }

    /**
     * Compute the maximum horizontal scroll position. Used by {@link OverScrollGlow}.
     * @return Maximum horizontal scroll position within real content
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.341 -0500", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "3D3DDB29824BD983AC62807A5552B60B")
    
int computeMaxScrollX() {
        return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    /**
     * Compute the maximum vertical scroll position. Used by {@link OverScrollGlow}.
     * @return Maximum vertical scroll position within real content
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.343 -0500", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "9E8EF9B58CA6D488566369B6B3CF8AF1")
    
int computeMaxScrollY() {
        return Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.345 -0500", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "57089A20002C2A6AB0E32C20C9225985")
    
boolean updateScrollCoordinates(int x, int y) {
        int oldX = mScrollX;
        int oldY = mScrollY;
        mScrollX = x;
        mScrollY = y;
        if (oldX != mScrollX || oldY != mScrollY) {
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.347 -0500", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "63813480FE580B7090C8132F511D6F98")
    
public void flingScroll(int vx, int vy) {
        checkThread();
        mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.352 -0500", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "F9AB6EB47CA23B3BB620C664A81DC955")
    
private void doFling() {
        if (mVelocityTracker == null) {
            return;
        }
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();

        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int vx = (int) mVelocityTracker.getXVelocity();
        int vy = (int) mVelocityTracker.getYVelocity();

        int scrollX = mScrollX;
        int scrollY = mScrollY;
        int overscrollDistance = mOverscrollDistance;
        int overflingDistance = mOverflingDistance;

        // Use the layer's scroll data if applicable.
        if (mTouchMode == TOUCH_DRAG_LAYER_MODE) {
            scrollX = mScrollingLayerRect.left;
            scrollY = mScrollingLayerRect.top;
            maxX = mScrollingLayerRect.right;
            maxY = mScrollingLayerRect.bottom;
            // No overscrolling for layers.
            overscrollDistance = overflingDistance = 0;
        }

        if (mSnapScrollMode != SNAP_NONE) {
            if ((mSnapScrollMode & SNAP_X) == SNAP_X) {
                vy = 0;
            } else {
                vx = 0;
            }
        }
        if ((maxX == 0 && vy == 0) || (maxY == 0 && vx == 0)) {
            WebViewCore.resumePriority();
            if (!mSelectingText) {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            }
            if (mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY)) {
                invalidate();
            }
            return;
        }
        float currentVelocity = mScroller.getCurrVelocity();
        float velocity = (float) Math.hypot(vx, vy);
        if (mLastVelocity > 0 && currentVelocity > 0 && velocity
                > mLastVelocity * MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION) {
            float deltaR = (float) (Math.abs(Math.atan2(mLastVelY, mLastVelX)
                    - Math.atan2(vy, vx)));
            final float circle = (float) (Math.PI) * 2.0f;
            if (deltaR > circle * 0.9f || deltaR < circle * 0.1f) {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
                if (DebugFlags.WEB_VIEW) {
                    Log.v(LOGTAG, "doFling vx= " + vx + " vy=" + vy);
                }
            } else if (DebugFlags.WEB_VIEW) {
                Log.v(LOGTAG, "doFling missed " + deltaR / circle);
            }
        } else if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "doFling start last=" + mLastVelocity
                    + " current=" + currentVelocity
                    + " vx=" + vx + " vy=" + vy
                    + " maxX=" + maxX + " maxY=" + maxY
                    + " scrollX=" + scrollX + " scrollY=" + scrollY
                    + " layer=" + mCurrentScrollingLayerId);
        }

        // Allow sloppy flings without overscrolling at the edges.
        if ((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy)) {
            vx = 0;
        }
        if ((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx)) {
            vy = 0;
        }

        if (overscrollDistance < overflingDistance) {
            if ((vx > 0 && scrollX == -overscrollDistance) ||
                    (vx < 0 && scrollX == maxX + overscrollDistance)) {
                vx = 0;
            }
            if ((vy > 0 && scrollY == -overscrollDistance) ||
                    (vy < 0 && scrollY == maxY + overscrollDistance)) {
                vy = 0;
            }
        }

        mLastVelX = vx;
        mLastVelY = vy;
        mLastVelocity = velocity;

        // no horizontal overscroll if the content just fits
        mScroller.fling(scrollX, scrollY, -vx, -vy, 0, maxX, 0, maxY,
                maxX == 0 ? 0 : overflingDistance, overflingDistance);
        // Duration is calculated based on velocity. With range boundaries and overscroll
        // we may not know how long the final animation will take. (Hence the deprecation
        // warning on the call below.) It's not a big deal for scroll bars but if webcore
        // resumes during this effect we will take a performance hit. See computeScroll;
        // we resume webcore there when the animation is finished.
        final int time = mScroller.getDuration();

        // Suppress scrollbars for layer scrolling.
        if (mTouchMode != TOUCH_DRAG_LAYER_MODE) {
            awakenScrollBars(time);
        }

        invalidate();
    }

    /**
     * Returns a view containing zoom controls i.e. +/- buttons. The caller is
     * in charge of installing this view to the view hierarchy. This view will
     * become visible when the user starts scrolling via touch and fade away if
     * the user does not interact with it.
     * <p/>
     * API version 3 introduces a built-in zoom mechanism that is shown
     * automatically by the MapView. This is the preferred approach for
     * showing the zoom UI.
     *
     * @deprecated The built-in zoom mechanism is preferred, see
     *             {@link WebSettings#setBuiltInZoomControls(boolean)}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.355 -0500", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "964523E253442494AEA3E70586655998")
    
@Deprecated
    public View getZoomControls() {
        checkThread();
        if (!getSettings().supportZoom()) {
            Log.w(LOGTAG, "This WebView doesn't support zoom.");
            return null;
        }
        return mZoomManager.getExternalZoomPicker();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.357 -0500", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "EC89FF2696E56191A01C387CAC6B0B5A")
    
void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.359 -0500", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "6F08586F43D113F982C701D06B48528D")
    
float getDefaultZoomScale() {
        return mZoomManager.getDefaultScale();
    }

    /**
     * Return the overview scale of the WebView
     * @return The overview scale.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.360 -0500", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "E79BB21DF563AB4A37FFCD3F87B40C92")
    
float getZoomOverviewScale() {
        return mZoomManager.getZoomOverviewScale();
    }

    /**
     * @return TRUE if the WebView can be zoomed in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.362 -0500", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "7F60EE6550A5563C03EE504D829CEFC6")
    
public boolean canZoomIn() {
        checkThread();
        return mZoomManager.canZoomIn();
    }

    /**
     * @return TRUE if the WebView can be zoomed out.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.364 -0500", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "A82AAA17674BE2DA74E16223B86B190C")
    
public boolean canZoomOut() {
        checkThread();
        return mZoomManager.canZoomOut();
    }

    /**
     * Perform zoom in in the webview
     * @return TRUE if zoom in succeeds. FALSE if no zoom changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.366 -0500", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "A7B3DFD300494641E8D30876A67CCF1C")
    
public boolean zoomIn() {
        checkThread();
        return mZoomManager.zoomIn();
    }

    /**
     * Perform zoom out in the webview
     * @return TRUE if zoom out succeeds. FALSE if no zoom changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.368 -0500", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "581C479B81E6B50F9D6380C04D3EC49B")
    
public boolean zoomOut() {
        checkThread();
        return mZoomManager.zoomOut();
    }

    /**
     * This selects the best clickable target at mLastTouchX and mLastTouchY
     * and calls showCursorTimed on the native side
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.371 -0500", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "17F8DD702AAA2458384FED980DC874BD")
    
private void updateSelection() {
        if (mNativeClass == 0) {
            return;
        }
        mPrivateHandler.removeMessages(UPDATE_SELECTION);
        // mLastTouchX and mLastTouchY are the point in the current viewport
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
        Rect rect = new Rect(contentX - slop, contentY - slop,
                contentX + slop, contentY + slop);
        nativeSelectBestAt(rect);
        mInitialHitTestResult = hitTestResult(null);
    }

    /**
     * Scroll the focused text field to match the WebTextView
     * @param xPercent New x position of the WebTextView from 0 to 1.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.373 -0500", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "B1C37D04459D7444D73F65FC3A93C13A")
    
void scrollFocusedTextInputX(float xPercent) {
        if (!inEditingMode() || mWebViewCore == null) {
            return;
        }
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                new Float(xPercent));
    }

    /**
     * Scroll the focused textarea vertically to match the WebTextView
     * @param y New y position of the WebTextView in view coordinates
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.375 -0500", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "0440BEEC9E3517FB16518560397B0D7B")
    
void scrollFocusedTextInputY(int y) {
        if (!inEditingMode() || mWebViewCore == null) {
            return;
        }
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
    }

    /**
     * Set our starting point and time for a drag from the WebTextView.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.377 -0500", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "8B2CD9AB316A7F800AB44456E462AE1F")
    
void initiateTextFieldDrag(float x, float y, long eventTime) {
        if (!inEditingMode()) {
            return;
        }
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        mLastTouchTime = eventTime;
        if (!mScroller.isFinished()) {
            abortAnimation();
        }
        mSnapScrollMode = SNAP_NONE;
        mVelocityTracker = VelocityTracker.obtain();
        mTouchMode = TOUCH_DRAG_START_MODE;
    }

    /**
     * Given a motion event from the WebTextView, set its location to our
     * coordinates, and handle the event.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.380 -0500", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "6C960439C25AF77774221479666CDCA6")
    
boolean textFieldDrag(MotionEvent event) {
        if (!inEditingMode()) {
            return false;
        }
        mDragFromTextInput = true;
        event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                (float) (mWebTextView.getTop() - mScrollY));
        boolean result = onTouchEvent(event);
        mDragFromTextInput = false;
        return result;
    }

    /**
     * Due a touch up from a WebTextView.  This will be handled by webkit to
     * change the selection.
     * @param event MotionEvent in the WebTextView's coordinates.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.382 -0500", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "CCB59B7D57EBC2BB253C2DA42141CFB6")
    
void touchUpOnTextField(MotionEvent event) {
        if (!inEditingMode()) {
            return;
        }
        int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        int slop = viewToContentDimension(mNavSlop);
        nativeMotionUp(x, y, slop);
    }

    /**
     * Called when pressing the center key or trackball on a textfield.
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.384 -0500", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "035659BEB020AB9C28AA205B5DB17F79")
    
void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.390 -0500", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "5C6388BAE975E47C1D9D5A8547BD9B1D")
    
private void doShortPress() {
        if (mNativeClass == 0) {
            return;
        }
        if (mPreventDefault == PREVENT_DEFAULT_YES) {
            return;
        }
        mTouchMode = TOUCH_DONE_MODE;
        updateSelection();
        switchOutDrawHistory();
        // mLastTouchX and mLastTouchY are the point in the current viewport
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
        if (USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty()) {
            // set mTouchHighlightRequested to 0 to cause an immediate
            // drawing of the touch rings
            mTouchHighlightRequested = 0;
            invalidate(mTouchHighlightRegion.getBounds());
            mPrivateHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    removeTouchHighlight();
                }
            }, ViewConfiguration.getPressedStateDuration());
        }
        if (getSettings().supportTouchOnly()) {
            removeTouchHighlight();
            WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
            // use "0" as generation id to inform WebKit to use the same x/y as
            // it used when processing GET_TOUCH_HIGHLIGHT_RECTS
            touchUpData.mMoveGeneration = 0;
            mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
        } else if (nativePointInNavCache(contentX, contentY, slop)) {
            WebViewCore.MotionUpData motionUpData = new WebViewCore
                    .MotionUpData();
            motionUpData.mFrame = nativeCacheHitFramePointer();
            motionUpData.mNode = nativeCacheHitNodePointer();
            motionUpData.mBounds = nativeCacheHitNodeBounds();
            motionUpData.mX = contentX;
            motionUpData.mY = contentY;
            mWebViewCore.sendMessageAtFrontOfQueue(EventHub.VALID_NODE_BOUNDS,
                    motionUpData);
        } else {
            doMotionUp(contentX, contentY);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.392 -0500", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "3E1CEA7918B9412F922C81D9656F4837")
    
private void doMotionUp(int contentX, int contentY) {
        int slop = viewToContentDimension(mNavSlop);
        if (nativeMotionUp(contentX, contentY, slop) && mLogEvent) {
            EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
        }
        if (nativeHasCursorNode() && !nativeCursorIsTextInput()) {
            playSoundEffect(SoundEffectConstants.CLICK);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.395 -0500", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "BED1306FE0550DFB625B165B53E3B66F")
    
void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
    }

    /**
     * Returns plugin bounds if x/y in content coordinates corresponds to a
     * plugin. Otherwise a NULL rectangle is returned.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.397 -0500", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "D3A185A17D693CB3B7C02952CB7AEB22")
    
Rect getPluginBounds(int x, int y) {
        int slop = viewToContentDimension(mNavSlop);
        if (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin()) {
            return nativeCacheHitNodeBounds();
        } else {
            return null;
        }
    }

    /*
     * Return true if the rect (e.g. plugin) is fully visible and maximized
     * inside the WebView.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.399 -0500", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "DC9D6EF2856B92F6E87ED36BA942B258")
    
boolean isRectFitOnScreen(Rect rect) {
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        
        return toTaintBoolean(rect.getTaintInt() + scale + viewWidth + viewHeight);
       /* 
        return !mZoomManager.willScaleTriggerZoom(scale)
                && contentToViewX(rect.left) >= mScrollX
                && contentToViewX(rect.right) <= mScrollX + viewWidth
                && contentToViewY(rect.top) >= mScrollY
                && contentToViewY(rect.bottom) <= mScrollY + viewHeight;
        */
    }

    /*
     * Maximize and center the rectangle, specified in the document coordinate
     * space, inside the WebView. If the zoom doesn't need to be changed, do an
     * animated scroll to center it. If the zoom needs to be changed, find the
     * zoom center and do a smooth zoom transition. The rect is in document
     * coordinates
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.402 -0500", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "A024482712019BA142D3C29834E617CD")
    
void centerFitRect(Rect rect) {
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        if (!mZoomManager.willScaleTriggerZoom(scale)) {
            pinScrollTo(contentToViewX(rect.left + rectWidth / 2) - viewWidth / 2,
                    contentToViewY(rect.top + rectHeight / 2) - viewHeight / 2,
                    true, 0);
        } else {
            float actualScale = mZoomManager.getScale();
            float oldScreenX = rect.left * actualScale - mScrollX;
            float rectViewX = rect.left * scale;
            float rectViewWidth = rectWidth * scale;
            float newMaxWidth = mContentWidth * scale;
            float newScreenX = (viewWidth - rectViewWidth) / 2;
            // pin the newX to the WebView
            if (newScreenX > rectViewX) {
                newScreenX = rectViewX;
            } else if (newScreenX > (newMaxWidth - rectViewX - rectViewWidth)) {
                newScreenX = viewWidth - (newMaxWidth - rectViewX);
            }
            float zoomCenterX = (oldScreenX * scale - newScreenX * actualScale)
                    / (scale - actualScale);
            float oldScreenY = rect.top * actualScale + getTitleHeight()
                    - mScrollY;
            float rectViewY = rect.top * scale + getTitleHeight();
            float rectViewHeight = rectHeight * scale;
            float newMaxHeight = mContentHeight * scale + getTitleHeight();
            float newScreenY = (viewHeight - rectViewHeight) / 2;
            // pin the newY to the WebView
            if (newScreenY > rectViewY) {
                newScreenY = rectViewY;
            } else if (newScreenY > (newMaxHeight - rectViewY - rectViewHeight)) {
                newScreenY = viewHeight - (newMaxHeight - rectViewY);
            }
            float zoomCenterY = (oldScreenY * scale - newScreenY * actualScale)
                    / (scale - actualScale);
            mZoomManager.setZoomCenter(zoomCenterX, zoomCenterY);
            mZoomManager.startZoomAnimation(scale, false);
        }
    }

    // Called by JNI to handle a touch on a node representing an email address,
    // address, or phone number
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.404 -0500", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "AD833BDB06067F52D599D470202FD72D")
    
private void overrideLoading(String url) {
        mCallbackProxy.uiOverrideUrlLoading(url);
    }
    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.515 -0400", hash_original_method = "8AECAF07C584017DF10A77A8577569BA", hash_generated_method = "8AECAF07C584017DF10A77A8577569BA")
        public InnerGlobalLayoutListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.793 -0500", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "AF3F96E23ADC4F2A0F10117AF42181F9")
        
public void onGlobalLayout() {
            if (isShown()) {
                setGLRectViewport();
            }
        }
        
    }
    
    private class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.516 -0400", hash_original_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D", hash_generated_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D")
        public InnerScrollChangedListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.798 -0500", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "0CE2E5313C4DA5E7236DD856FDE34D1E")
        
public void onScrollChanged() {
            if (isShown()) {
                setGLRectViewport();
            }
        }
        
    }
    
    public class WebViewTransport {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.828 -0500", hash_original_field = "69F56ECFFE5C02CC8F0B3FC5EA1BB2E9", hash_generated_field = "CE9B7FCDD03C866BC3B0AB067564E1E9")

        private WebView mWebview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.516 -0400", hash_original_method = "019254006A207FE7BCA503E59C7BDCD4", hash_generated_method = "019254006A207FE7BCA503E59C7BDCD4")
        public WebViewTransport ()
        {
            //Synthesized constructor
        }

        /**
         * Set the WebView to the transportation object.
         * @param webview The WebView to transport.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.830 -0500", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "F4E8F0241307FB4A61F9A089F8DE2367")
        
public synchronized void setWebView(WebView webview) {
            mWebview = webview;
        }

        /**
         * Return the WebView object.
         * @return WebView The transported WebView object.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.833 -0500", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "A0DB45617F9F631D03655490812037B3")
        
public synchronized WebView getWebView() {
            return mWebview;
        }
        
    }
    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.839 -0500", hash_original_method = "A91E534521EB4B302FD27148495CE212", hash_generated_method = "B52429BAC91BFECA544DA731B89A962C")
        
static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.837 -0500", hash_original_field = "DA405B221E4EB73966413301BBAEE558", hash_generated_field = "C88183308993326DA3B8CE3C16E7E9BA")

        private static OnTrimMemoryListener sInstance = null;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.842 -0500", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "353A1B903135B3C9F21F960CF617C8E5")
        
private OnTrimMemoryListener(Context c) {
            c.registerComponentCallbacks(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.845 -0500", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "4F9B9E302E26D467779FCAC83A2A10E3")
        
@Override
        public void onConfigurationChanged(Configuration newConfig) {
            // Ignore
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.848 -0500", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "5C18DD82328FE532B9053189D40C7FE4")
        
@Override
        public void onLowMemory() {
            // Ignore
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:50.851 -0500", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "99915FC13B22778BA0D27A56D3FB7169")
        
@Override
        public void onTrimMemory(int level) {
            if (DebugFlags.WEB_VIEW) {
                Log.d("WebView", "onTrimMemory: " + level);
            }
            WebView.nativeOnTrimMemory(level);
        }
    }
    
    public class HitTestResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.334 -0500", hash_original_field = "BF0D048310629F0B0A94E17878AE69F2", hash_generated_field = "66339D0C16D16517633DFB08461D5C3F")

        public static final int UNKNOWN_TYPE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.337 -0500", hash_original_field = "2C9FE869C78999BD31369134AB13694A", hash_generated_field = "C6E0A23956E4344E5A24770E8DEB80AF")

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.340 -0500", hash_original_field = "8C5A36A4E9B26D4ACCCDE4293877A515", hash_generated_field = "1F892F69F99B538EA9542E4188E9D049")

        public static final int PHONE_TYPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.342 -0500", hash_original_field = "30D0DF37A0C7622852CA1C89A561A760", hash_generated_field = "609BC3DD941EE1B3F8DBCDEA6DC14E92")

        public static final int GEO_TYPE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.344 -0500", hash_original_field = "506C578BCD87EDE8934798683CB36E7C", hash_generated_field = "AF4F62540D93A175F846244DE39FF3EA")

        public static final int EMAIL_TYPE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.347 -0500", hash_original_field = "D39A48035EDC47D7B835BB983A1B9BA9", hash_generated_field = "D1341758694A17E34931E15E5F9AE163")

        public static final int IMAGE_TYPE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.350 -0500", hash_original_field = "A91730CA4D9D6E4B532BB9EE34EE0CEC", hash_generated_field = "A790FEB45D10D6E4493673EC8A439C5E")

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.353 -0500", hash_original_field = "4F04F62B8C6CD96ECE454CA47EC9982F", hash_generated_field = "F746B9271AE854E19C3EA4F13285C847")

        public static final int SRC_ANCHOR_TYPE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.355 -0500", hash_original_field = "FD726CAB114AE09DED3BC7D0C84AF4D9", hash_generated_field = "C47A4D8A2B58A38AB94516810D897655")

        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.358 -0500", hash_original_field = "AA915EB2890FCA67CD86BEA113CC0E5F", hash_generated_field = "AD4F3515FDAD6418D5559EF03B760AC2")

        public static final int EDIT_TEXT_TYPE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.360 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.362 -0500", hash_original_field = "BFADF59C1E8D2C274055FF05797F3DBF", hash_generated_field = "7473B88E9A243CF8ACFD2DDF98031A9D")

        private String mExtra;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.364 -0500", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "22122A9CDE290DEBAA97D7928999F948")
        
HitTestResult() {
            mType = UNKNOWN_TYPE;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.367 -0500", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "ACFBF44FE6C04DA5FF469E0EE6A0F250")
        
private void setType(int type) {
            mType = type;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.369 -0500", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "8E9AB32B10422BCFF2B08E970FACC40F")
        
private void setExtra(String extra) {
            mExtra = extra;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.371 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
        
public int getType() {
            return mType;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.374 -0500", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "8AD83B51BD7C90F61A9349C76A343A68")
        
public String getExtra() {
            return mExtra;
        }
    }
    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.518 -0400", hash_original_method = "81C64DA14CD8ADA6B639EE9F61F2A898", hash_generated_method = "81C64DA14CD8ADA6B639EE9F61F2A898")
        public ProxyReceiver ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.393 -0500", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "FB3AB251B74508B0A5900B8472EB3767")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION)) {
                handleProxyBroadcast(intent);
            }
        }
        
    }
    
    private static class PackageListener extends BroadcastReceiver {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.518 -0400", hash_original_method = "F623A53A552E0B02B7648231F682A935", hash_generated_method = "F623A53A552E0B02B7648231F682A935")
        public PackageListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.412 -0500", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "CBB578CAF73EF526C62ECF35CA6BAE6A")
        
@Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            final String packageName = intent.getData().getSchemeSpecificPart();
            final boolean replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
            if (Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing) {
                // if it is replacing, refreshPlugins() when adding
                return;
            }

            if (sGoogleApps.contains(packageName)) {
                if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
                    WebViewCore.sendStaticMessage(EventHub.ADD_PACKAGE_NAME, packageName);
                } else {
                    WebViewCore.sendStaticMessage(EventHub.REMOVE_PACKAGE_NAME, packageName);
                }
            }

            PluginManager pm = PluginManager.getInstance(context);
            if (pm.containsPluginPermissionAndSignatures(packageName)) {
                pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
            }
        }
        
    }
    
    static class SaveWebArchiveMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.588 -0500", hash_original_field = "05C64ACC3BAB92D2CCE8178ABA3FDAE1", hash_generated_field = "05C64ACC3BAB92D2CCE8178ABA3FDAE1")
  String mBasename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.591 -0500", hash_original_field = "6BCA401625C852D06DCC273A17617FED", hash_generated_field = "6BCA401625C852D06DCC273A17617FED")
  boolean mAutoname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.593 -0500", hash_original_field = "C752F5297A11E20E661B6130B21F3B9A", hash_generated_field = "C752F5297A11E20E661B6130B21F3B9A")
  ValueCallback<String> mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.595 -0500", hash_original_field = "047227D3BBCE6402C69D67FD47561A95", hash_generated_field = "047227D3BBCE6402C69D67FD47561A95")
 String mResultFile;
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.586 -0500", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "D64671432E0583E419B88EDB6B668A93")
        
SaveWebArchiveMessage (String basename, boolean autoname, ValueCallback<String> callback) {
            mBasename = basename;
            mAutoname = autoname;
            mCallback = callback;
        }
        
    }
    
    static class ViewSizeData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.743 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.745 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.747 -0500", hash_original_field = "78B7CCE03B515024F44B1EEDC44555A1", hash_generated_field = "78B7CCE03B515024F44B1EEDC44555A1")

        float mHeightWidthRatio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.748 -0500", hash_original_field = "3A48A4BC51B3BD422EE46136E8931243", hash_generated_field = "3A48A4BC51B3BD422EE46136E8931243")

        int mActualViewHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.751 -0500", hash_original_field = "B26A0AD7DDE8F0FD05B17352E367406B", hash_generated_field = "B26A0AD7DDE8F0FD05B17352E367406B")

        int mTextWrapWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.752 -0500", hash_original_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F", hash_generated_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F")

        int mAnchorX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.754 -0500", hash_original_field = "A5A5BAD4084BA0905925E24FE8CC16A6", hash_generated_field = "A5A5BAD4084BA0905925E24FE8CC16A6")

        int mAnchorY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.757 -0500", hash_original_field = "ABDB0A4470BBD1454ED388F3CD972EEE", hash_generated_field = "ABDB0A4470BBD1454ED388F3CD972EEE")

        float mScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:51.759 -0500", hash_original_field = "63B858676F9D9765C256ADBE1D3B6A59", hash_generated_field = "63B858676F9D9765C256ADBE1D3B6A59")

        boolean mIgnoreHeight;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.519 -0400", hash_original_method = "0E4893AFBBF2A9B13986CA2BDFC332DE", hash_generated_method = "0E4893AFBBF2A9B13986CA2BDFC332DE")
        public ViewSizeData ()
        {
            //Synthesized constructor
        }

    }
    
    private class RequestFormData implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.064 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.066 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

        private String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.068 -0500", hash_original_field = "99DDEB1140F4CCCA0D9EC8ECACEB7D08", hash_generated_field = "0487D88BABEAE0E64EE47FD1AEEB417C")

        private Message mUpdateMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.071 -0500", hash_original_field = "66041FF16B2AD3B395E344D195D0F70D", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

        private boolean mAutoFillable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.073 -0500", hash_original_field = "77E0B02B23DF4249D8B2645E97A57F48", hash_generated_field = "F9D9BCAC942E8D5C0FAF4BD1D37CB5CF")

        private boolean mAutoComplete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.075 -0500", hash_original_field = "0B42F3C7F24D94A7C50B0770671247AA", hash_generated_field = "93B1D4E2229B54F25A168656E4937615")

        private WebSettings mWebSettings;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.078 -0500", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "BEE093B5F61B26CB2E7A7D55968510C9")
        
public RequestFormData(String name, String url, Message msg,
                boolean autoFillable, boolean autoComplete) {
            mName = name;
            mUrl = WebTextView.urlForAutoCompleteData(url);
            mUpdateMessage = msg;
            mAutoFillable = autoFillable;
            mAutoComplete = autoComplete;
            mWebSettings = getSettings();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.081 -0500", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "283587215503832F5607F81DAF7B5DA0")
        
public void run() {
            ArrayList<String> pastEntries = new ArrayList<String>();

            if (mAutoFillable) {
                // Note that code inside the adapter click handler in WebTextView depends
                // on the AutoFill item being at the top of the drop down list. If you change
                // the order, make sure to do it there too!
                if (mWebSettings != null && mWebSettings.getAutoFillProfile() != null) {
                    pastEntries.add(getResources().getText(
                            com.android.internal.R.string.autofill_this_form).toString() +
                            " " +
                            mAutoFillData.getPreviewString());
                    mWebTextView.setAutoFillProfileIsSet(true);
                } else {
                    // There is no autofill profile set up yet, so add an option that
                    // will invite the user to set their profile up.
                    pastEntries.add(getResources().getText(
                            com.android.internal.R.string.setup_autofill).toString());
                    mWebTextView.setAutoFillProfileIsSet(false);
                }
            }

            if (mAutoComplete) {
                pastEntries.addAll(mDatabase.getFormData(mUrl, mName));
            }

            if (pastEntries.size() > 0) {
                AutoCompleteAdapter adapter = new
                        AutoCompleteAdapter(mContext, pastEntries);
                mUpdateMessage.obj = adapter;
                mUpdateMessage.sendToTarget();
            }
        }
        
    }
    
    private static class QueuedTouch {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.423 -0500", hash_original_field = "B8B6644602DD2683A7B0A4778A62DE29", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.425 -0500", hash_original_field = "20EA73C9A7F9F149019985C98DE3A38D", hash_generated_field = "20EA73C9A7F9F149019985C98DE3A38D")

        MotionEvent mEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.427 -0500", hash_original_field = "C7A09A520003D6660CD5B4796D1273F4", hash_generated_field = "C7A09A520003D6660CD5B4796D1273F4")

        TouchEventData mTed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.429 -0500", hash_original_field = "BEE6F088ABCC206EAF882A35EEC82861", hash_generated_field = "BEE6F088ABCC206EAF882A35EEC82861")

        QueuedTouch mNext;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.521 -0400", hash_original_method = "FA8EC88E2AD519ABBE81A37B882E4019", hash_generated_method = "FA8EC88E2AD519ABBE81A37B882E4019")
        public QueuedTouch ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.432 -0500", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "750EE7CEFC6B0380AB44E709EE0E29A6")
        
public QueuedTouch set(TouchEventData ted) {
            mSequence = ted.mSequence;
            mTed = ted;
            mEvent = null;
            mNext = null;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.435 -0500", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "4A9B58AB3F5824073908EDA9E803F36C")
        
public QueuedTouch set(MotionEvent ev, long sequence) {
            mEvent = MotionEvent.obtain(ev);
            mSequence = sequence;
            mTed = null;
            mNext = null;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.437 -0500", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "5E8AD1D496C84EC542FDA259A0E8524E")
        
public QueuedTouch add(QueuedTouch other) {
            if (other.mSequence < mSequence) {
                other.mNext = this;
                return other;
            }

            QueuedTouch insertAt = this;
            while (insertAt.mNext != null && insertAt.mNext.mSequence < other.mSequence) {
                insertAt = insertAt.mNext;
            }
            other.mNext = insertAt.mNext;
            insertAt.mNext = other;
            return this;
        }
        
    }
    
    private class TouchEventQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.460 -0500", hash_original_field = "F4A9DF668B7A94CFA2D2E931761130BA", hash_generated_field = "BB5877DC49413A9228D8F9DC3EDA4B0C")

        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.462 -0500", hash_original_field = "4832E41BD93D505FC405A38B02E51C2B", hash_generated_field = "E348FC28D39D22D6D781B3B929F27054")

        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.441 -0500", hash_original_field = "BB5C96BCBE2AD6006103FCEB9D577242", hash_generated_field = "127F03A306165D2D03A139A6F1583390")

        private long mNextTouchSequence = Long.MIN_VALUE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.443 -0500", hash_original_field = "040C68E88FD42316A4D9DF97E0972657", hash_generated_field = "266156A22BD39F4F0BEF086C9C7B63E5")

        private long mLastHandledTouchSequence = Long.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.446 -0500", hash_original_field = "CE0CF35861731EDB1E97F0B845365CCC", hash_generated_field = "AF7570BA97F43827805CB02058F37277")

        private long mIgnoreUntilSequence = Long.MIN_VALUE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.448 -0500", hash_original_field = "788CD7D6437138B02ED9F736C19878A3", hash_generated_field = "21DBEB15ECA49C1E87E853FA0180CD65")

        private QueuedTouch mTouchEventQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.450 -0500", hash_original_field = "824C1C99F0A644DD8A06BDF9505D7AAA", hash_generated_field = "08077047985BEF38D8C3F6BC11BCAC86")

        private QueuedTouch mPreQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.452 -0500", hash_original_field = "8AD315D464596DBCDD4BB3B9965B48E6", hash_generated_field = "F259F7EDDF59F6CEF0FD59699D3FC834")

        private QueuedTouch mQueuedTouchRecycleBin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.455 -0500", hash_original_field = "5A59F0B0F689869BD07D64C0BF37158E", hash_generated_field = "778CCCFD60C85F5AB4F8F90308D45BB5")

        private int mQueuedTouchRecycleCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.457 -0500", hash_original_field = "03EE4966C06B2E42E229C964520CAC5A", hash_generated_field = "1E79D4489BE43CB9AEB55D3B13DF96A3")

        private long mLastEventTime = Long.MAX_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.527 -0400", hash_original_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25", hash_generated_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25")
        public TouchEventQueue ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.465 -0500", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "770CD3A99F071C36E4BF918FB22AAF00")
        
private QueuedTouch obtainQueuedTouch() {
            if (mQueuedTouchRecycleBin != null) {
                QueuedTouch result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
                mQueuedTouchRecycleCount--;
                return result;
            }
            return new QueuedTouch();
        }

        /**
         * Allow events with any currently missing sequence numbers to be skipped in processing.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.467 -0500", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "F7144914BFC47F4BAD96C50190163E38")
        
public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;

            // Run any events we have available and complete, pre-queued or otherwise.
            runQueuedAndPreQueuedEvents();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.470 -0500", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "D9F2528AD25CD9943E8E3E46EB11EE51")
        
private void runQueuedAndPreQueuedEvents() {
            QueuedTouch qd = mPreQueue;
            boolean fromPreQueue = true;
            while (qd != null && qd.mSequence == mLastHandledTouchSequence + 1) {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
                if (fromPreQueue) {
                    mPreQueue = qd.mNext;
                } else {
                    mTouchEventQueue = qd.mNext;
                }
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;

                long nextPre = mPreQueue != null ? mPreQueue.mSequence : Long.MAX_VALUE;
                long nextQueued = mTouchEventQueue != null ?
                        mTouchEventQueue.mSequence : Long.MAX_VALUE;
                fromPreQueue = nextPre < nextQueued;
                qd = fromPreQueue ? mPreQueue : mTouchEventQueue;
            }
        }

        /**
         * Add a TouchEventData to the pre-queue.
         *
         * An event in the pre-queue is an event that we know about that
         * has been sent to webkit, but that we haven't received back and
         * enqueued into the normal touch queue yet. If webkit ever times
         * out and we need to ignore currently missing events, we'll run
         * events from the pre-queue to patch the holes.
         *
         * @param ted TouchEventData to pre-queue
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.472 -0500", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "384F403C0727FBC3B9816520BA5DC480")
        
public void preQueueTouchEventData(TouchEventData ted) {
            QueuedTouch newTouch = obtainQueuedTouch().set(ted);
            if (mPreQueue == null) {
                mPreQueue = newTouch;
            } else {
                QueuedTouch insertionPoint = mPreQueue;
                while (insertionPoint.mNext != null &&
                        insertionPoint.mNext.mSequence < newTouch.mSequence) {
                    insertionPoint = insertionPoint.mNext;
                }
                newTouch.mNext = insertionPoint.mNext;
                insertionPoint.mNext = newTouch;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.475 -0500", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "A64BCE2555319DEBC74896D7CACC0DB2")
        
private void recycleQueuedTouch(QueuedTouch qd) {
            if (mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH) {
                qd.mNext = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = qd;
                mQueuedTouchRecycleCount++;
            }
        }

        /**
         * Reset the touch event queue. This will dump any pending events
         * and reset the sequence numbering.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.477 -0500", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "765568C29DC9A0E9E1CD83E61DDD3ED1")
        
public void reset() {
            mNextTouchSequence = Long.MIN_VALUE + 1;
            mLastHandledTouchSequence = Long.MIN_VALUE;
            mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            while (mTouchEventQueue != null) {
                QueuedTouch recycleMe = mTouchEventQueue;
                mTouchEventQueue = mTouchEventQueue.mNext;
                recycleQueuedTouch(recycleMe);
            }
            while (mPreQueue != null) {
                QueuedTouch recycleMe = mPreQueue;
                mPreQueue = mPreQueue.mNext;
                recycleQueuedTouch(recycleMe);
            }
        }

        /**
         * Return the next valid sequence number for tagging incoming touch events.
         * @return The next touch event sequence number
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.479 -0500", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "C1DEFF3D34782E676FD00E5FCF5C7EED")
        
public long nextTouchSequence() {
            return mNextTouchSequence++;
        }

        /**
         * Enqueue a touch event in the form of TouchEventData.
         * The sequence number will be read from the mSequence field of the argument.
         *
         * If the touch event's sequence number is the next in line to be processed, it will
         * be handled before this method returns. Any subsequent events that have already
         * been queued will also be processed in their proper order.
         *
         * @param ted Touch data to be processed in order.
         * @return true if the event was processed before returning, false if it was just enqueued.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.482 -0500", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "CA95E967C93F3636701B85C974A66791")
        
public boolean enqueueTouchEvent(TouchEventData ted) {
            // Remove from the pre-queue if present
            QueuedTouch preQueue = mPreQueue;
            if (preQueue != null) {
                // On exiting this block, preQueue is set to the pre-queued QueuedTouch object
                // if it was present in the pre-queue, and removed from the pre-queue itself.
                if (preQueue.mSequence == ted.mSequence) {
                    mPreQueue = preQueue.mNext;
                } else {
                    QueuedTouch prev = preQueue;
                    preQueue = null;
                    while (prev.mNext != null) {
                        if (prev.mNext.mSequence == ted.mSequence) {
                            preQueue = prev.mNext;
                            prev.mNext = preQueue.mNext;
                            break;
                        } else {
                            prev = prev.mNext;
                        }
                    }
                }
            }

            if (ted.mSequence < mLastHandledTouchSequence) {
                // Stale event and we already moved on; drop it. (Should not be common.)
                Log.w(LOGTAG, "Stale touch event " + MotionEvent.actionToString(ted.mAction) +
                        " received from webcore; ignoring");
                return false;
            }

            if (dropStaleGestures(ted.mMotionEvent, ted.mSequence)) {
                return false;
            }

            // dropStaleGestures above might have fast-forwarded us to
            // an event we have already.
            runNextQueuedEvents();

            if (mLastHandledTouchSequence + 1 == ted.mSequence) {
                if (preQueue != null) {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                }
                handleQueuedTouchEventData(ted);

                mLastHandledTouchSequence++;

                // Do we have any more? Run them if so.
                runNextQueuedEvents();
            } else {
                // Reuse the pre-queued object if we had it.
                QueuedTouch qd = preQueue != null ? preQueue : obtainQueuedTouch().set(ted);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            }
            return true;
        }

        /**
         * Enqueue a touch event in the form of a MotionEvent from the framework.
         *
         * If the touch event's sequence number is the next in line to be processed, it will
         * be handled before this method returns. Any subsequent events that have already
         * been queued will also be processed in their proper order.
         *
         * @param ev MotionEvent to be processed in order
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.485 -0500", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "D47EA7E66611E1DBFB227E03D5F287A5")
        
public void enqueueTouchEvent(MotionEvent ev) {
            final long sequence = nextTouchSequence();

            if (dropStaleGestures(ev, sequence)) {
                return;
            }

            // dropStaleGestures above might have fast-forwarded us to
            // an event we have already.
            runNextQueuedEvents();

            if (mLastHandledTouchSequence + 1 == sequence) {
                handleQueuedMotionEvent(ev);

                mLastHandledTouchSequence++;

                // Do we have any more? Run them if so.
                runNextQueuedEvents();
            } else {
                QueuedTouch qd = obtainQueuedTouch().set(ev, sequence);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.487 -0500", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "A1C669D11074BA1BD3BEBF8663A8CFC6")
        
private void runNextQueuedEvents() {
            QueuedTouch qd = mTouchEventQueue;
            while (qd != null && qd.mSequence == mLastHandledTouchSequence + 1) {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;
            }
            mTouchEventQueue = qd;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.492 -0500", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "03296235FEE356E8213431728BB34180")
        
private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            if (ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove) {
                // This is to make sure that we don't attempt to process a tap
                // or long press when webkit takes too long to get back to us.
                // The movement will be properly confirmed when we process the
                // enqueued event later.
                final int dx = Math.round(ev.getX()) - mLastTouchX;
                final int dy = Math.round(ev.getY()) - mLastTouchY;
                if (dx * dx + dy * dy > mTouchSlopSquare) {
                    mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                }
            }

            if (mTouchEventQueue == null) {
                return sequence <= mLastHandledTouchSequence;
            }

            // If we have a new down event and it's been a while since the last event
            // we saw, catch up as best we can and keep going.
            if (ev != null && ev.getAction() == MotionEvent.ACTION_DOWN) {
                long eventTime = ev.getEventTime();
                long lastHandledEventTime = mLastEventTime;
                if (eventTime > lastHandledEventTime + QUEUED_GESTURE_TIMEOUT) {
                    Log.w(LOGTAG, "Got ACTION_DOWN but still waiting on stale event. " +
                            "Catching up.");
                    runQueuedAndPreQueuedEvents();

                    // Drop leftovers that we truly don't have.
                    QueuedTouch qd = mTouchEventQueue;
                    while (qd != null && qd.mSequence < sequence) {
                        QueuedTouch recycleMe = qd;
                        qd = qd.mNext;
                        recycleQueuedTouch(recycleMe);
                    }
                    mTouchEventQueue = qd;
                    mLastHandledTouchSequence = sequence - 1;
                }
            }

            if (mIgnoreUntilSequence - 1 > mLastHandledTouchSequence) {
                QueuedTouch qd = mTouchEventQueue;
                while (qd != null && qd.mSequence < mIgnoreUntilSequence) {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                }
                mTouchEventQueue = qd;
                mLastHandledTouchSequence = mIgnoreUntilSequence - 1;
            }

            if (mPreQueue != null) {
                // Drop stale prequeued events
                QueuedTouch qd = mPreQueue;
                while (qd != null && qd.mSequence < mIgnoreUntilSequence) {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                }
                mPreQueue = qd;
            }

            return sequence <= mLastHandledTouchSequence;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.494 -0500", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "CF93205B63744AB2C6645A8103D42900")
        
private void handleQueuedTouch(QueuedTouch qt) {
            if (qt.mTed != null) {
                handleQueuedTouchEventData(qt.mTed);
            } else {
                handleQueuedMotionEvent(qt.mEvent);
                qt.mEvent.recycle();
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.497 -0500", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "03A0303A38BDBC4F19A678CADC435B78")
        
private void handleQueuedMotionEvent(MotionEvent ev) {
            mLastEventTime = ev.getEventTime();
            int action = ev.getActionMasked();
            if (ev.getPointerCount() > 1) {  // Multi-touch
                handleMultiTouchInWebView(ev);
            } else {
                final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                if (detector != null && mPreventDefault != PREVENT_DEFAULT_YES) {
                    // ScaleGestureDetector needs a consistent event stream to operate properly.
                    // It won't take any action with fewer than two pointers, but it needs to
                    // update internal bookkeeping state.
                    detector.onTouchEvent(ev);
                }

                handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.501 -0500", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "DB4300A6342AF33A9238146749D12827")
        
private void handleQueuedTouchEventData(TouchEventData ted) {
            if (ted.mMotionEvent != null) {
                mLastEventTime = ted.mMotionEvent.getEventTime();
            }
            if (!ted.mReprocess) {
                if (ted.mAction == MotionEvent.ACTION_DOWN
                        && mPreventDefault == PREVENT_DEFAULT_MAYBE_YES) {
                    // if prevent default is called from WebCore, UI
                    // will not handle the rest of the touch events any
                    // more.
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN;
                } else if (ted.mAction == MotionEvent.ACTION_MOVE
                        && mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN) {
                    // the return for the first ACTION_MOVE will decide
                    // whether UI will handle touch or not. Currently no
                    // support for alternating prevent default
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO;
                }
                if (mPreventDefault == PREVENT_DEFAULT_YES) {
                    mTouchHighlightRegion.setEmpty();
                }
            } else {
                if (ted.mPoints.length > 1) {  // multi-touch
                    if (!ted.mNativeResult && mPreventDefault != PREVENT_DEFAULT_YES) {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                        handleMultiTouchInWebView(ted.mMotionEvent);
                    } else {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    }
                    return;
                }

                // prevent default is not called in WebCore, so the
                // message needs to be reprocessed in UI
                if (!ted.mNativeResult) {
                    // Following is for single touch.
                    switch (ted.mAction) {
                        case MotionEvent.ACTION_DOWN:
                            mLastDeferTouchX = ted.mPointsInView[0].x;
                            mLastDeferTouchY = ted.mPointsInView[0].y;
                            mDeferTouchMode = TOUCH_INIT_MODE;
                            break;
                        case MotionEvent.ACTION_MOVE: {
                            // no snapping in defer process
                            int x = ted.mPointsInView[0].x;
                            int y = ted.mPointsInView[0].y;

                            if (mDeferTouchMode != TOUCH_DRAG_MODE) {
                                mDeferTouchMode = TOUCH_DRAG_MODE;
                                mLastDeferTouchX = x;
                                mLastDeferTouchY = y;
                                startScrollingLayer(x, y);
                                startDrag();
                            }
                            int deltaX = pinLocX((int) (mScrollX
                                    + mLastDeferTouchX - x))
                                    - mScrollX;
                            int deltaY = pinLocY((int) (mScrollY
                                    + mLastDeferTouchY - y))
                                    - mScrollY;
                            doDrag(deltaX, deltaY);
                            if (deltaX != 0) mLastDeferTouchX = x;
                            if (deltaY != 0) mLastDeferTouchY = y;
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            if (mDeferTouchMode == TOUCH_DRAG_MODE) {
                                // no fling in defer process
                                mScroller.springBack(mScrollX, mScrollY, 0,
                                        computeMaxScrollX(), 0,
                                        computeMaxScrollY());
                                invalidate();
                                WebViewCore.resumePriority();
                                WebViewCore.resumeUpdatePicture(mWebViewCore);
                            }
                            mDeferTouchMode = TOUCH_DONE_MODE;
                            break;
                        case WebViewCore.ACTION_DOUBLETAP:
                            // doDoubleTap() needs mLastTouchX/Y as anchor
                            mLastDeferTouchX = ted.mPointsInView[0].x;
                            mLastDeferTouchY = ted.mPointsInView[0].y;
                            mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                            mDeferTouchMode = TOUCH_DONE_MODE;
                            break;
                        case WebViewCore.ACTION_LONGPRESS:
                            HitTestResult hitTest = getHitTestResult();
                            if (hitTest != null && hitTest.mType
                                    != HitTestResult.UNKNOWN_TYPE) {
                                performLongClick();
                            }
                            mDeferTouchMode = TOUCH_DONE_MODE;
                            break;
                    }
                }
            }
        }
    }
    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.545 -0400", hash_original_method = "827423792FD52B61F0723B9DB59191FF", hash_generated_method = "827423792FD52B61F0723B9DB59191FF")
        public PrivateHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.519 -0500", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "659A1C2DE11BADEDF525CFC062257691")
        
@Override
        public void handleMessage(Message msg) {
            // exclude INVAL_RECT_MSG_ID since it is frequently output
            if (DebugFlags.WEB_VIEW && msg.what != INVAL_RECT_MSG_ID) {
                if (msg.what >= FIRST_PRIVATE_MSG_ID
                        && msg.what <= LAST_PRIVATE_MSG_ID) {
                    Log.v(LOGTAG, HandlerPrivateDebugString[msg.what
                            - FIRST_PRIVATE_MSG_ID]);
                } else if (msg.what >= FIRST_PACKAGE_MSG_ID
                        && msg.what <= LAST_PACKAGE_MSG_ID) {
                    Log.v(LOGTAG, HandlerPackageDebugString[msg.what
                            - FIRST_PACKAGE_MSG_ID]);
                } else {
                    Log.v(LOGTAG, Integer.toString(msg.what));
                }
            }
            if (mWebViewCore == null) {
                // after WebView's destroy() is called, skip handling messages.
                return;
            }
            if (mBlockWebkitViewMessages
                    && msg.what != WEBCORE_INITIALIZED_MSG_ID) {
                // Blocking messages from webkit
                return;
            }
            switch (msg.what) {
                case REMEMBER_PASSWORD: {
                    mDatabase.setUsernamePassword(
                            msg.getData().getString("host"),
                            msg.getData().getString("username"),
                            msg.getData().getString("password"));
                    ((Message) msg.obj).sendToTarget();
                    break;
                }
                case NEVER_REMEMBER_PASSWORD: {
                    mDatabase.setUsernamePassword(
                            msg.getData().getString("host"), null, null);
                    ((Message) msg.obj).sendToTarget();
                    break;
                }
                case PREVENT_DEFAULT_TIMEOUT: {
                    // if timeout happens, cancel it so that it won't block UI
                    // to continue handling touch events
                    if ((msg.arg1 == MotionEvent.ACTION_DOWN
                            && mPreventDefault == PREVENT_DEFAULT_MAYBE_YES)
                            || (msg.arg1 == MotionEvent.ACTION_MOVE
                            && mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN)) {
                        cancelWebCoreTouchEvent(
                                viewToContentX(mLastTouchX + mScrollX),
                                viewToContentY(mLastTouchY + mScrollY),
                                true);
                    }
                    break;
                }
                case SCROLL_SELECT_TEXT: {
                    if (mAutoScrollX == 0 && mAutoScrollY == 0) {
                        mSentAutoScrollMessage = false;
                        break;
                    }
                    if (mCurrentScrollingLayerId == 0) {
                        pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                    } else {
                        scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX,
                                mScrollingLayerRect.top + mAutoScrollY);
                    }
                    sendEmptyMessageDelayed(
                            SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                    break;
                }
                case UPDATE_SELECTION: {
                    if (mTouchMode == TOUCH_INIT_MODE
                            || mTouchMode == TOUCH_SHORTPRESS_MODE
                            || mTouchMode == TOUCH_SHORTPRESS_START_MODE) {
                        updateSelection();
                    }
                    break;
                }
                case SWITCH_TO_SHORTPRESS: {
                    mInitialHitTestResult = null; // set by updateSelection()
                    if (mTouchMode == TOUCH_INIT_MODE) {
                        if (!getSettings().supportTouchOnly()
                                && mPreventDefault != PREVENT_DEFAULT_YES) {
                            mTouchMode = TOUCH_SHORTPRESS_START_MODE;
                            updateSelection();
                        } else {
                            // set to TOUCH_SHORTPRESS_MODE so that it won't
                            // trigger double tap any more
                            mTouchMode = TOUCH_SHORTPRESS_MODE;
                        }
                    } else if (mTouchMode == TOUCH_DOUBLE_TAP_MODE) {
                        mTouchMode = TOUCH_DONE_MODE;
                    }
                    break;
                }
                case SWITCH_TO_LONGPRESS: {
                    if (USE_WEBKIT_RINGS || getSettings().supportTouchOnly()) {
                        removeTouchHighlight();
                    }
                    if (inFullScreenMode() || mDeferTouchProcess) {
                        TouchEventData ted = new TouchEventData();
                        ted.mAction = WebViewCore.ACTION_LONGPRESS;
                        ted.mIds = new int[1];
                        ted.mIds[0] = 0;
                        ted.mPoints = new Point[1];
                        ted.mPoints[0] = new Point(viewToContentX(mLastTouchX + mScrollX),
                                                   viewToContentY(mLastTouchY + mScrollY));
                        ted.mPointsInView = new Point[1];
                        ted.mPointsInView[0] = new Point(mLastTouchX, mLastTouchY);
                        // metaState for long press is tricky. Should it be the
                        // state when the press started or when the press was
                        // released? Or some intermediary key state? For
                        // simplicity for now, we don't set it.
                        ted.mMetaState = 0;
                        ted.mReprocess = mDeferTouchProcess;
                        ted.mNativeLayer = nativeScrollableLayer(
                                ted.mPoints[0].x, ted.mPoints[0].y,
                                ted.mNativeLayerRect, null);
                        ted.mSequence = mTouchEventQueue.nextTouchSequence();
                        mTouchEventQueue.preQueueTouchEventData(ted);
                        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                    } else if (mPreventDefault != PREVENT_DEFAULT_YES) {
                        mTouchMode = TOUCH_DONE_MODE;
                        performLongClick();
                    }
                    break;
                }
                case RELEASE_SINGLE_TAP: {
                    doShortPress();
                    break;
                }
                case SCROLL_TO_MSG_ID: {
                    // arg1 = animate, arg2 = onlyIfImeIsShowing
                    // obj = Point(x, y)
                    if (msg.arg2 == 1) {
                        // This scroll is intended to bring the textfield into
                        // view, but is only necessary if the IME is showing
                        InputMethodManager imm = InputMethodManager.peekInstance();
                        if (imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView)))) {
                            break;
                        }
                    }
                    final Point p = (Point) msg.obj;
                    if (msg.arg1 == 1) {
                        spawnContentScrollTo(p.x, p.y);
                    } else {
                        setContentScrollTo(p.x, p.y);
                    }
                    break;
                }
                case UPDATE_ZOOM_RANGE: {
                    WebViewCore.ViewState viewState = (WebViewCore.ViewState) msg.obj;
                    // mScrollX contains the new minPrefWidth
                    mZoomManager.updateZoomRange(viewState, getViewWidth(), viewState.mScrollX);
                    break;
                }
                case UPDATE_ZOOM_DENSITY: {
                    final float density = (Float) msg.obj;
                    mZoomManager.updateDefaultZoomDensity(density);
                    break;
                }
                case REPLACE_BASE_CONTENT: {
                    nativeReplaceBaseContent(msg.arg1);
                    break;
                }
                case NEW_PICTURE_MSG_ID: {
                    // called for new content
                    final WebViewCore.DrawData draw = (WebViewCore.DrawData) msg.obj;
                    setNewPicture(draw, true);
                    break;
                }
                case WEBCORE_INITIALIZED_MSG_ID:
                    // nativeCreate sets mNativeClass to a non-zero value
                    String drawableDir = BrowserFrame.getRawResFilename(
                            BrowserFrame.DRAWABLEDIR, mContext);
                    WindowManager windowManager =
                            (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
                    Display display = windowManager.getDefaultDisplay();
                    nativeCreate(msg.arg1, drawableDir,
                            ActivityManager.isHighEndGfx(display));
                    if (mDelaySetPicture != null) {
                        setNewPicture(mDelaySetPicture, true);
                        mDelaySetPicture = null;
                    }
                    if (mIsPaused) {
                        nativeSetPauseDrawing(mNativeClass, true);
                    }
                    break;
                case UPDATE_TEXTFIELD_TEXT_MSG_ID:
                    // Make sure that the textfield is currently focused
                    // and representing the same node as the pointer.
                    if (inEditingMode() &&
                            mWebTextView.isSameTextField(msg.arg1)) {
                        if (msg.arg2 == mTextGeneration) {
                            String text = (String) msg.obj;
                            if (null == text) {
                                text = "";
                            }
                            mWebTextView.setTextAndKeepSelection(text);
                        }
                    }
                    break;
                case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID:
                    displaySoftKeyboard(true);
                    // fall through to UPDATE_TEXT_SELECTION_MSG_ID
                case UPDATE_TEXT_SELECTION_MSG_ID:
                    updateTextSelectionFromMessage(msg.arg1, msg.arg2,
                            (WebViewCore.TextSelectionData) msg.obj);
                    break;
                case FORM_DID_BLUR:
                    if (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1)) {
                        hideSoftKeyboard();
                    }
                    break;
                case RETURN_LABEL:
                    if (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1)) {
                        mWebTextView.setHint((String) msg.obj);
                        InputMethodManager imm
                                = InputMethodManager.peekInstance();
                        // The hint is propagated to the IME in
                        // onCreateInputConnection.  If the IME is already
                        // active, restart it so that its hint text is updated.
                        if (imm != null && imm.isActive(mWebTextView)) {
                            imm.restartInput(mWebTextView);
                        }
                    }
                    break;
                case UNHANDLED_NAV_KEY:
                    navHandledKey(msg.arg1, 1, false, 0);
                    break;
                case UPDATE_TEXT_ENTRY_MSG_ID:
                    // this is sent after finishing resize in WebViewCore. Make
                    // sure the text edit box is still on the  screen.
                    if (inEditingMode() && nativeCursorIsTextInput()) {
                        updateWebTextViewPosition();
                    }
                    break;
                case CLEAR_TEXT_ENTRY:
                    clearTextEntry();
                    break;
                case INVAL_RECT_MSG_ID: {
                    Rect r = (Rect)msg.obj;
                    if (r == null) {
                        invalidate();
                    } else {
                        // we need to scale r from content into view coords,
                        // which viewInvalidate() does for us
                        viewInvalidate(r.left, r.top, r.right, r.bottom);
                    }
                    break;
                }
                case REQUEST_FORM_DATA:
                    AutoCompleteAdapter adapter = (AutoCompleteAdapter) msg.obj;
                    if (mWebTextView.isSameTextField(msg.arg1)) {
                        mWebTextView.setAdapterCustom(adapter);
                    }
                    break;

                case LONG_PRESS_CENTER:
                    // as this is shared by keydown and trackballdown, reset all
                    // the states
                    mGotCenterDown = false;
                    mTrackballDown = false;
                    performLongClick();
                    break;

                case WEBCORE_NEED_TOUCH_EVENTS:
                    mForwardTouchEvents = (msg.arg1 != 0);
                    break;

                case PREVENT_TOUCH_ID:
                    if (inFullScreenMode()) {
                        break;
                    }
                    TouchEventData ted = (TouchEventData) msg.obj;

                    if (mTouchEventQueue.enqueueTouchEvent(ted)) {
                        // WebCore is responding to us; remove pending timeout.
                        // It will be re-posted when needed.
                        removeMessages(PREVENT_DEFAULT_TIMEOUT);
                    }
                    break;

                case REQUEST_KEYBOARD:
                    if (msg.arg1 == 0) {
                        hideSoftKeyboard();
                    } else {
                        displaySoftKeyboard(false);
                    }
                    break;

                case FIND_AGAIN:
                    // Ignore if find has been dismissed.
                    if (mFindIsUp && mFindCallback != null) {
                        mFindCallback.findAll();
                    }
                    break;

                case DRAG_HELD_MOTIONLESS:
                    mHeldMotionless = MOTIONLESS_TRUE;
                    invalidate();
                    // fall through to keep scrollbars awake

                case AWAKEN_SCROLL_BARS:
                    if (mTouchMode == TOUCH_DRAG_MODE
                            && mHeldMotionless == MOTIONLESS_TRUE) {
                        awakenScrollBars(ViewConfiguration
                                .getScrollDefaultDelay(), false);
                        mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(AWAKEN_SCROLL_BARS),
                                ViewConfiguration.getScrollDefaultDelay());
                    }
                    break;

                case DO_MOTION_UP:
                    doMotionUp(msg.arg1, msg.arg2);
                    break;

                case SCREEN_ON:
                    setKeepScreenOn(msg.arg1 == 1);
                    break;

                case ENTER_FULLSCREEN_VIDEO:
                    int layerId = msg.arg1;

                    String url = (String) msg.obj;
                    if (mHTML5VideoViewProxy != null) {
                        mHTML5VideoViewProxy.enterFullScreenVideo(layerId, url);
                    }
                    break;

                case SHOW_FULLSCREEN: {
                    View view = (View) msg.obj;
                    int orientation = msg.arg1;
                    int npp = msg.arg2;

                    if (inFullScreenMode()) {
                        Log.w(LOGTAG, "Should not have another full screen.");
                        dismissFullScreenMode();
                    }
                    mFullScreenHolder = new PluginFullScreenHolder(WebView.this, orientation, npp);
                    mFullScreenHolder.setContentView(view);
                    mFullScreenHolder.show();

                    break;
                }
                case HIDE_FULLSCREEN:
                    dismissFullScreenMode();
                    break;

                case DOM_FOCUS_CHANGED:
                    if (inEditingMode()) {
                        nativeClearCursor();
                        rebuildWebTextView();
                    }
                    break;

                case SHOW_RECT_MSG_ID: {
                    WebViewCore.ShowRectData data = (WebViewCore.ShowRectData) msg.obj;
                    int x = mScrollX;
                    int left = contentToViewX(data.mLeft);
                    int width = contentToViewDimension(data.mWidth);
                    int maxWidth = contentToViewDimension(data.mContentWidth);
                    int viewWidth = getViewWidth();
                    if (width < viewWidth) {
                        // center align
                        x += left + width / 2 - mScrollX - viewWidth / 2;
                    } else {
                        x += (int) (left + data.mXPercentInDoc * width
                                - mScrollX - data.mXPercentInView * viewWidth);
                    }
                    if (DebugFlags.WEB_VIEW) {
                        Log.v(LOGTAG, "showRectMsg=(left=" + left + ",width=" +
                              width + ",maxWidth=" + maxWidth +
                              ",viewWidth=" + viewWidth + ",x="
                              + x + ",xPercentInDoc=" + data.mXPercentInDoc +
                              ",xPercentInView=" + data.mXPercentInView+ ")");
                    }
                    // use the passing content width to cap x as the current
                    // mContentWidth may not be updated yet
                    x = Math.max(0,
                            (Math.min(maxWidth, x + viewWidth)) - viewWidth);
                    int top = contentToViewY(data.mTop);
                    int height = contentToViewDimension(data.mHeight);
                    int maxHeight = contentToViewDimension(data.mContentHeight);
                    int viewHeight = getViewHeight();
                    int y = (int) (top + data.mYPercentInDoc * height -
                                   data.mYPercentInView * viewHeight);
                    if (DebugFlags.WEB_VIEW) {
                        Log.v(LOGTAG, "showRectMsg=(top=" + top + ",height=" +
                              height + ",maxHeight=" + maxHeight +
                              ",viewHeight=" + viewHeight + ",y="
                              + y + ",yPercentInDoc=" + data.mYPercentInDoc +
                              ",yPercentInView=" + data.mYPercentInView+ ")");
                    }
                    // use the passing content height to cap y as the current
                    // mContentHeight may not be updated yet
                    y = Math.max(0,
                            (Math.min(maxHeight, y + viewHeight) - viewHeight));
                    // We need to take into account the visible title height
                    // when scrolling since y is an absolute view position.
                    y = Math.max(0, y - getVisibleTitleHeightImpl());
                    scrollTo(x, y);
                    }
                    break;

                case CENTER_FIT_RECT:
                    centerFitRect((Rect)msg.obj);
                    break;

                case SET_SCROLLBAR_MODES:
                    mHorizontalScrollBarMode = msg.arg1;
                    mVerticalScrollBarMode = msg.arg2;
                    break;

                case SELECTION_STRING_CHANGED:
                    if (mAccessibilityInjector != null) {
                        String selectionString = (String) msg.obj;
                        mAccessibilityInjector.onSelectionStringChange(selectionString);
                    }
                    break;

                case SET_TOUCH_HIGHLIGHT_RECTS:
                    @SuppressWarnings("unchecked")
                    ArrayList<Rect> rects = (ArrayList<Rect>) msg.obj;
                    setTouchHighlightRects(rects);
                    break;

                case SAVE_WEBARCHIVE_FINISHED:
                    SaveWebArchiveMessage saveMessage = (SaveWebArchiveMessage)msg.obj;
                    if (saveMessage.mCallback != null) {
                        saveMessage.mCallback.onReceiveValue(saveMessage.mResultFile);
                    }
                    break;

                case SET_AUTOFILLABLE:
                    mAutoFillData = (WebViewCore.AutoFillData) msg.obj;
                    if (mWebTextView != null) {
                        mWebTextView.setAutoFillable(mAutoFillData.getQueryId());
                        rebuildWebTextView();
                    }
                    break;

                case AUTOFILL_COMPLETE:
                    if (mWebTextView != null) {
                        // Clear the WebTextView adapter when AutoFill finishes
                        // so that the drop down gets cleared.
                        mWebTextView.setAdapterCustom(null);
                    }
                    break;

                case SELECT_AT:
                    nativeSelectAt(msg.arg1, msg.arg2);
                    break;

                default:
                    super.handleMessage(msg);
                    break;
            }
        }
        
    }
    
    private class InvokeListBox implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.541 -0500", hash_original_field = "908F5FE8BBD699691C1178E68199AA34", hash_generated_field = "44EE6B10D8B13CA54299546EDE76F988")

        private boolean     mMultiple;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.543 -0500", hash_original_field = "869C67787E17E84C4EAD7FDBB6326D5A", hash_generated_field = "9043ECED353715E0AF55A9014BE2BBF2")

        // which items are selected.
        private int[]       mSelectedArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.546 -0500", hash_original_field = "0C4C8B0A1715B385CAAC273E9808CB09", hash_generated_field = "E48EE1A54F02871C8D5096CDB19BF1BE")

        // where the initial selection is.
        private int         mSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.548 -0500", hash_original_field = "408895D39EB3CCF81038A7F275604DBD", hash_generated_field = "9EF3ABDF3C19BF934708240D666FC0CB")

        private Container[] mContainers;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.592 -0500", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "54A74FD8BC478377E8ABCD51A515BC12")
        
private InvokeListBox(String[] array, int[] enabled, int[] selected) {
            mMultiple = true;
            mSelectedArray = selected;

            int length = array.length;
            mContainers = new Container[length];
            for (int i = 0; i < length; i++) {
                mContainers[i] = new Container();
                mContainers[i].mString = array[i];
                mContainers[i].mEnabled = enabled[i];
                mContainers[i].mId = i;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.595 -0500", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "DD5622151A88BFF95E6722072BC2D454")
        
private InvokeListBox(String[] array, int[] enabled, int selection) {
            mSelection = selection;
            mMultiple = false;

            int length = array.length;
            mContainers = new Container[length];
            for (int i = 0; i < length; i++) {
                mContainers[i] = new Container();
                mContainers[i].mString = array[i];
                mContainers[i].mEnabled = enabled[i];
                mContainers[i].mId = i;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.626 -0500", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "81640B52256D38FF136FE224AACC2881")
        
public void run() {
            final ListView listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            final MyArrayListAdapter adapter = new MyArrayListAdapter();
            AlertDialog.Builder b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);

            if (mMultiple) {
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mWebViewCore.sendMessage(
                                EventHub.LISTBOX_CHOICES,
                                adapter.getCount(), 0,
                                listView.getCheckedItemPositions());
                    }});
                b.setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                }});
            }
            mListBoxDialog = b.create();
            listView.setAdapter(adapter);
            listView.setFocusableInTouchMode(true);
            // There is a bug (1250103) where the checks in a ListView with
            // multiple items selected are associated with the positions, not
            // the ids, so the items do not properly retain their checks when
            // filtered.  Do not allow filtering on multiple lists until
            // that bug is fixed.

            listView.setTextFilterEnabled(!mMultiple);
            if (mMultiple) {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                int length = mSelectedArray.length;
                for (int i = 0; i < length; i++) {
                    listView.setItemChecked(mSelectedArray[i], true);
                }
            } else {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                        // Rather than sending the message right away, send it
                        // after the page regains focus.
                        mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        mListBoxDialog.dismiss();
                        mListBoxDialog = null;
                    }
                });
                if (mSelection != -1) {
                    listView.setSelection(mSelection);
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listView.setItemChecked(mSelection, true);
                    DataSetObserver observer = new SingleDataSetObserver(
                            adapter.getItemId(mSelection), listView, adapter);
                    adapter.registerDataSetObserver(observer);
                }
            }
            mListBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    mListBoxDialog = null;
                }
            });
            mListBoxDialog.show();
        }
        
        private class Container extends Object {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.551 -0500", hash_original_field = "32A64B52EEC419131339C020DEEDECB6", hash_generated_field = "286E6252D1F55A019AFE2E7F01596CD3")

            final static int OPTGROUP = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.553 -0500", hash_original_field = "E762DD8463331646545A82FDA729C716", hash_generated_field = "B55392C731ABAA66EEF81A3CED619863")

            final static int OPTION_DISABLED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.556 -0500", hash_original_field = "878F53F908302084056A2895F3F797EA", hash_generated_field = "4F0BC4F0AB9BA9C14CA01391DF9AFF29")

            final static int OPTION_ENABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.558 -0500", hash_original_field = "0DD8A30A5B66E3389BB7F1641026A732", hash_generated_field = "0DD8A30A5B66E3389BB7F1641026A732")

            String  mString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.560 -0500", hash_original_field = "3811FA45E31C1288EF4A5CD0AF26B346", hash_generated_field = "3811FA45E31C1288EF4A5CD0AF26B346")

            int     mEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.562 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

            int     mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:55.559 -0400", hash_original_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4", hash_generated_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4")
            public Container ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.565 -0500", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "E7A0B18763B46172481F8F37425DB151")
            
@Override
            public String toString() {
                return mString;
            }
        }
        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.571 -0500", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "1BEDBA549DAB70D94F1AA91F52B3A3E0")
            
public MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.574 -0500", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "078E31C6FF9D729395668829E7CDBF90")
            
@Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                // Always pass in null so that we will get a new CheckedTextView
                // Otherwise, an item which was previously used as an <optgroup>
                // element (i.e. has no check), could get used as an <option>
                // element, which needs a checkbox/radio, but it would not have
                // one.
                convertView = super.getView(position, null, parent);
                Container c = item(position);
                if (c != null && Container.OPTION_ENABLED != c.mEnabled) {
                    // ListView does not draw dividers between disabled and
                    // enabled elements.  Use a LinearLayout to provide dividers
                    LinearLayout layout = new LinearLayout(mContext);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    if (position > 0) {
                        View dividerTop = new View(mContext);
                        dividerTop.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerTop);
                    }

                    if (Container.OPTGROUP == c.mEnabled) {
                        // Currently select_dialog_multichoice uses CheckedTextViews.
                        // If that changes, the class cast will no longer be valid.
                        if (mMultiple) {
                            Assert.assertTrue(convertView instanceof CheckedTextView);
                            ((CheckedTextView) convertView).setCheckMarkDrawable(null);
                        }
                    } else {
                        // c.mEnabled == Container.OPTION_DISABLED
                        // Draw the disabled element in a disabled state.
                        convertView.setEnabled(false);
                    }

                    layout.addView(convertView);
                    if (position < getCount() - 1) {
                        View dividerBottom = new View(mContext);
                        dividerBottom.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerBottom);
                    }
                    return layout;
                }
                return convertView;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.576 -0500", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "EC7B3A567763A10159361DA50951B936")
            
@Override
            public boolean hasStableIds() {
                // AdapterView's onChanged method uses this to determine whether
                // to restore the old state.  Return false so that the old (out
                // of date) state does not replace the new, valid state.
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.579 -0500", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "B34FA3ECD00ECDD5B1C5DFE6E7CD7BC5")
            
private Container item(int position) {
                if (position < 0 || position >= getCount()) {
                    return null;
                }
                return (Container) getItem(position);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.582 -0500", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "0B8B70CAFDD17C90A567DAF0D4FB0AA8")
            
@Override
            public long getItemId(int position) {
                Container item = item(position);
                if (item == null) {
                    return -1;
                }
                return item.mId;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.584 -0500", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "D6664212657AC9A2B62F6CC6A650C851")
            
@Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.587 -0500", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "1E08B79BA7AF08C0F4A444FBF5EA8F5D")
            
@Override
            public boolean isEnabled(int position) {
                Container item = item(position);
                if (item == null) {
                    return false;
                }
                return Container.OPTION_ENABLED == item.mEnabled;
            }
            
        }
        
        private class SingleDataSetObserver extends DataSetObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.598 -0500", hash_original_field = "490DC12F7ABEDDE28793D57E20084CB1", hash_generated_field = "2D84C7F454FDE105876BFC5F1B67C86D")

            private long        mCheckedId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.600 -0500", hash_original_field = "564994122F8B404810DDCD714146F030", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

            private ListView    mListView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.602 -0500", hash_original_field = "2CCFA3B9041B42EEC769AA09DF8CA535", hash_generated_field = "6E193E3C34AABA5E66E6DED38A82989F")

            private Adapter     mAdapter;

            /*
             * Create a new observer.
             * @param id The ID of the item to keep checked.
             * @param l ListView for getting and clearing the checked states
             * @param a Adapter for getting the IDs
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.605 -0500", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "221F751833751ABD9ADBFEC183792FCC")
            
public SingleDataSetObserver(long id, ListView l, Adapter a) {
                mCheckedId = id;
                mListView = l;
                mAdapter = a;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.609 -0500", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "4470FD77F0F3698840B28D2345D482C4")
            
@Override
            public void onChanged() {
                // The filter may have changed which item is checked.  Find the
                // item that the ListView thinks is checked.
                int position = mListView.getCheckedItemPosition();
                long id = mAdapter.getItemId(position);
                if (mCheckedId != id) {
                    // Clear the ListView's idea of the checked item, since
                    // it is incorrect
                    mListView.clearChoices();
                    // Search for mCheckedId.  If it is in the filtered list,
                    // mark it as checked
                    int count = mAdapter.getCount();
                    for (int i = 0; i < count; i++) {
                        if (mAdapter.getItemId(i) == mCheckedId) {
                            mListView.setItemChecked(i, true);
                            break;
                        }
                    }
                }
            }
            
        }
        
    }
    
    @Deprecated public interface PictureListener {
        
        @DSVerified
        @Deprecated
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onNewPicture(WebView view, Picture picture);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.407 -0500", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "CD9EE6A2D087C138458D3F328272A45F")
    
@Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        // FIXME: If a subwindow is showing find, and the user touches the
        // background window, it can steal focus.
        if (mFindIsUp) return false;
        boolean result = false;
        if (inEditingMode()) {
            result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
        } else {
            result = super.requestFocus(direction, previouslyFocusedRect);
            if (mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode()) {
                // For cases such as GMail, where we gain focus from a direction,
                // we want to move to the first available link.
                // FIXME: If there are no visible links, we may not want to
                int fakeKeyDirection = 0;
                switch(direction) {
                    case View.FOCUS_UP:
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_UP;
                        break;
                    case View.FOCUS_DOWN:
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_DOWN;
                        break;
                    case View.FOCUS_LEFT:
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_LEFT;
                        break;
                    case View.FOCUS_RIGHT:
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_RIGHT;
                        break;
                    default:
                        return result;
                }
                if (mNativeClass != 0 && !nativeHasCursorNode()) {
                    navHandledKey(fakeKeyDirection, 1, true, 0);
                }
            }
        }
        return result;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.410 -0500", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "C81A99A0F578F9B2FECF377A3153192E")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int measuredHeight = heightSize;
        int measuredWidth = widthSize;

        // Grab the content size from WebViewCore.
        int contentHeight = contentToViewDimension(mContentHeight);
        int contentWidth = contentToViewDimension(mContentWidth);

//        Log.d(LOGTAG, "------- measure " + heightMode);

        if (heightMode != MeasureSpec.EXACTLY) {
            mHeightCanMeasure = true;
            measuredHeight = contentHeight;
            if (heightMode == MeasureSpec.AT_MOST) {
                // If we are larger than the AT_MOST height, then our height can
                // no longer be measured and we should scroll internally.
                if (measuredHeight > heightSize) {
                    measuredHeight = heightSize;
                    mHeightCanMeasure = false;
                    measuredHeight |= MEASURED_STATE_TOO_SMALL;
                }
            }
        } else {
            mHeightCanMeasure = false;
        }
        if (mNativeClass != 0) {
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        }
        // For the width, always use the given size unless unspecified.
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            mWidthCanMeasure = true;
            measuredWidth = contentWidth;
        } else {
            if (measuredWidth < contentWidth) {
                measuredWidth |= MEASURED_STATE_TOO_SMALL;
            }
            mWidthCanMeasure = false;
        }

        synchronized (this) {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.413 -0500", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "8A87A419545B01676C37E779DC96105A")
    
@Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        if (mNativeClass == 0) {
            return false;
        }
        // don't scroll while in zoom animation. When it is done, we will adjust
        // the necessary components (e.g., WebTextView if it is in editing mode)
        if (mZoomManager.isFixedLengthAnimationInProgress()) {
            return false;
        }

        rect.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());

        Rect content = new Rect(viewToContentX(mScrollX),
                viewToContentY(mScrollY),
                viewToContentX(mScrollX + getWidth()
                - getVerticalScrollbarWidth()),
                viewToContentY(mScrollY + getViewHeightWithTitle()));
        content = nativeSubtractLayers(content);
        int screenTop = contentToViewY(content.top);
        int screenBottom = contentToViewY(content.bottom);
        int height = screenBottom - screenTop;
        int scrollYDelta = 0;

        if (rect.bottom > screenBottom) {
            int oneThirdOfScreenHeight = height / 3;
            if (rect.height() > 2 * oneThirdOfScreenHeight) {
                // If the rectangle is too tall to fit in the bottom two thirds
                // of the screen, place it at the top.
                scrollYDelta = rect.top - screenTop;
            } else {
                // If the rectangle will still fit on screen, we want its
                // top to be in the top third of the screen.
                scrollYDelta = rect.top - (screenTop + oneThirdOfScreenHeight);
            }
        } else if (rect.top < screenTop) {
            scrollYDelta = rect.top - screenTop;
        }

        int screenLeft = contentToViewX(content.left);
        int screenRight = contentToViewX(content.right);
        int width = screenRight - screenLeft;
        int scrollXDelta = 0;

        if (rect.right > screenRight && rect.left > screenLeft) {
            if (rect.width() > width) {
                scrollXDelta += (rect.left - screenLeft);
            } else {
                scrollXDelta += (rect.right - screenRight);
            }
        } else if (rect.left < screenLeft) {
            scrollXDelta -= (screenLeft - rect.left);
        }

        if ((scrollYDelta | scrollXDelta) != 0) {
            return pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0);
        }

        return false;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.416 -0500", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "9DCDBD91FCFEDA12D8B253252355D461")
    
void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
        arg.mReplace = replace;
        arg.mNewStart = newStart;
        arg.mNewEnd = newEnd;
        mTextGeneration++;
        arg.mTextGeneration = mTextGeneration;
        mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.418 -0500", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "4953DB6B19B3FED0631BBF5C71F5DEA1")
    
void passToJavaScript(String currentText, KeyEvent event) {
        // check if mWebViewCore has been destroyed
        if (mWebViewCore == null) {
            return;
        }
        WebViewCore.JSKeyData arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
        // Increase our text generation number, and pass it to webcore thread
        mTextGeneration++;
        mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        // WebKit's document state is not saved until about to leave the page.
        // To make sure the host application, like Browser, has the up to date
        // document state when it goes to background, we force to save the
        // document state.
        mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                cursorData(), 1000);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.421 -0500", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "880BE1CD50B152CB6BA5D249482CB679")
    
public synchronized WebViewCore getWebViewCore() {
        return mWebViewCore;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.529 -0500", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "56C80A1D918CCAA9D20BE42375CF473E")
    
private void setTouchHighlightRects(ArrayList<Rect> rects) {
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
        if (rects != null) {
            for (Rect rect : rects) {
                Rect viewRect = contentToViewRect(rect);
                // some sites, like stories in nytimes.com, set
                // mouse event handler in the top div. It is not
                // user friendly to highlight the div if it covers
                // more than half of the screen.
                if (viewRect.width() < getWidth() >> 1
                        || viewRect.height() < getHeight() >> 1) {
                    mTouchHighlightRegion.union(viewRect);
                } else {
                    Log.w(LOGTAG, "Skip the huge selection rect:"
                            + viewRect);
                }
            }
            invalidate(mTouchHighlightRegion.getBounds());
        }
    }

    /** @hide Called by JNI when pages are swapped (only occurs with hardware
     * acceleration) */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.532 -0500", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "558EFEC93116451DA939CF32CF33B9CE")
    
protected void pageSwapCallback(boolean notifyAnimationStarted) {
        if (inEditingMode()) {
            didUpdateWebTextViewDimensions(ANYWHERE);
        }
        if (notifyAnimationStarted) {
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.536 -0500", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "78CE45156389EC1F0B2CEACD1677EF40")
    
void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        if (mNativeClass == 0) {
            if (mDelaySetPicture != null) {
                throw new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
            }
            // Not initialized yet, delay set
            mDelaySetPicture = draw;
            return;
        }
        WebViewCore.ViewState viewState = draw.mViewState;
        boolean isPictureAfterFirstLayout = viewState != null;

        if (updateBaseLayer) {
            // Request a callback on pageSwap (to reposition the webtextview)
            boolean registerPageSwapCallback =
                !mZoomManager.isFixedLengthAnimationInProgress() && inEditingMode();

            setBaseLayer(draw.mBaseLayer, draw.mInvalRegion,
                    getSettings().getShowVisualIndicator(),
                    isPictureAfterFirstLayout, registerPageSwapCallback);
        }
        final Point viewSize = draw.mViewSize;
        // We update the layout (i.e. request a layout from the
        // view system) if the last view size that we sent to
        // WebCore matches the view size of the picture we just
        // received in the fixed dimension.
        final boolean updateLayout = viewSize.x == mLastWidthSent
                && viewSize.y == mLastHeightSent;
        // Don't send scroll event for picture coming from webkit,
        // since the new picture may cause a scroll event to override
        // the saved history scroll position.
        mSendScrollEvent = false;
        recordNewContentSize(draw.mContentSize.x,
                draw.mContentSize.y, updateLayout);
        if (isPictureAfterFirstLayout) {
            // Reset the last sent data here since dealing with new page.
            mLastWidthSent = 0;
            mZoomManager.onFirstLayout(draw);
            int scrollX = viewState.mShouldStartScrolledRight
                    ? getContentWidth() : viewState.mScrollX;
            int scrollY = viewState.mScrollY;
            setContentScrollTo(scrollX, scrollY);
            if (!mDrawHistory) {
                // As we are on a new page, remove the WebTextView. This
                // is necessary for page loads driven by webkit, and in
                // particular when the user was on a password field, so
                // the WebTextView was visible.
                clearTextEntry();
            }
        }
        mSendScrollEvent = true;

        if (DebugFlags.WEB_VIEW) {
            Rect b = draw.mInvalRegion.getBounds();
            Log.v(LOGTAG, "NEW_PICTURE_MSG_ID {" +
                    b.left+","+b.top+","+b.right+","+b.bottom+"}");
        }
        invalidateContentRect(draw.mInvalRegion.getBounds());

        if (mPictureListener != null) {
            mPictureListener.onNewPicture(WebView.this, capturePicture());
        }

        // update the zoom information based on the new picture
        mZoomManager.onNewPicture(draw);

        if (draw.mFocusSizeChanged && inEditingMode()) {
            mFocusSizeChanged = true;
        }
        if (isPictureAfterFirstLayout) {
            mViewManager.postReadyToDrawAll();
        }
    }

    /**
     * Used when receiving messages for REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID
     * and UPDATE_TEXT_SELECTION_MSG_ID.  Update the selection of WebTextView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.538 -0500", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "2DE80566DF0C707BC823086210A50C94")
    
private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        if (inEditingMode()
                && mWebTextView.isSameTextField(nodePointer)
                && textGeneration == mTextGeneration) {
            mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
        }
    }

    /*
     * Request a dropdown menu for a listbox with multiple selection.
     *
     * @param array Labels for the listbox.
     * @param enabledArray  State for each element in the list.  See static
     *      integers in Container class.
     * @param selectedArray Which positions are initally selected.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.635 -0500", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "16D6BAB9A7D75CB7761DB162A42C30B0")
    
void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
    }

    /*
     * Request a dropdown menu for a listbox with single selection or a single
     * <select> element.
     *
     * @param array Labels for the listbox.
     * @param enabledArray  State for each element in the list.  See static
     *      integers in Container class.
     * @param selection Which position is initally selected.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.637 -0500", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "DFD9151F49FF1E4FE4A084739CADF16D")
    
void requestListBox(String[] array, int[] enabledArray, int selection) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.640 -0500", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "64A72550D70ED3DC499EBCDF2EA33C70")
    
private void sendMoveFocus(int frame, int node) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
    }

    // called by JNI
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.642 -0500", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "45E509967DBF500806E0685CA412A114")
    
private void sendMoveMouse(int frame, int node, int x, int y) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                new WebViewCore.CursorData(frame, node, x, y));
    }

    /*
     * Send a mouse move event to the webcore thread.
     *
     * @param removeFocus Pass true to remove the WebTextView, if present.
     * @param stopPaintingCaret Stop drawing the blinking caret if true.
     * called by JNI
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.645 -0500", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "EAC6E4DB977F977272DCD7F6FA3A2207")
    
@SuppressWarnings("unused")
    private void sendMoveMouseIfLatest(boolean removeFocus, boolean stopPaintingCaret) {
        if (removeFocus) {
            clearTextEntry();
        }
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                stopPaintingCaret ? 1 : 0, 0,
                cursorData());
    }

    /**
     * Called by JNI to send a message to the webcore thread that the user
     * touched the webpage.
     * @param touchGeneration Generation number of the touch, to ignore touches
     *      after a new one has been generated.
     * @param frame Pointer to the frame holding the node that was touched.
     * @param node Pointer to the node touched.
     * @param x x-position of the touch.
     * @param y y-position of the touch.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.647 -0500", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "246818ADDA69189644A8F7A221CA8E7F")
    
private void sendMotionUp(int touchGeneration,
            int frame, int node, int x, int y) {
        WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
        touchUpData.mMoveGeneration = touchGeneration;
        touchUpData.mFrame = frame;
        touchUpData.mNode = node;
        touchUpData.mX = x;
        touchUpData.mY = y;
        touchUpData.mNativeLayer = nativeScrollableLayer(
                x, y, touchUpData.mNativeLayerRect, null);
        mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.649 -0500", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "EAFD820DBFC12066704F2241B81E358D")
    
private int getScaledMaxXScroll() {
        int width;
        if (mHeightCanMeasure == false) {
            width = getViewWidth() / 4;
        } else {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            width = visRect.width() / 2;
        }
        // FIXME the divisor should be retrieved from somewhere
        return viewToContentX(width);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.652 -0500", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "942D6C9E132340592B52CC360520FD7D")
    
private int getScaledMaxYScroll() {
        int height;
        if (mHeightCanMeasure == false) {
            height = getViewHeight() / 4;
        } else {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            height = visRect.height() / 2;
        }
        // FIXME the divisor should be retrieved from somewhere
        // the closest thing today is hard-coded into ScrollView.java
        // (from ScrollView.java, line 363)   int maxJump = height/2;
        return Math.round(height * mZoomManager.getInvScale());
    }

    /**
     * Called by JNI to invalidate view
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.654 -0500", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "0208CF55BD3406A85C955F2C0D5F4F69")
    
private void viewInvalidate() {
        invalidate();
    }

    /**
     * Pass the key directly to the page.  This assumes that
     * nativePageShouldHandleShiftAndArrows() returned true.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.656 -0500", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "F936527272DCADD848AC85D96092D969")
    
private void letPageHandleNavKey(int keyCode, long time, boolean down, int metaState) {
        int keyEventAction;
        int eventHubAction;
        if (down) {
            keyEventAction = KeyEvent.ACTION_DOWN;
            eventHubAction = EventHub.KEY_DOWN;
            playSoundEffect(keyCodeToSoundsEffect(keyCode));
        } else {
            keyEventAction = KeyEvent.ACTION_UP;
            eventHubAction = EventHub.KEY_UP;
        }

        KeyEvent event = new KeyEvent(time, time, keyEventAction, keyCode,
                1, (metaState & KeyEvent.META_SHIFT_ON)
                | (metaState & KeyEvent.META_ALT_ON)
                | (metaState & KeyEvent.META_SYM_ON)
                , KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        mWebViewCore.sendMessage(eventHubAction, event);
    }

    // return true if the key was handled
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.660 -0500", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "F26CEC548DA71693ACFCEEAE24107017")
    
private boolean navHandledKey(int keyCode, int count, boolean noScroll,
            long time) {
        if (mNativeClass == 0) {
            return false;
        }
        mInitialHitTestResult = null;
        mLastCursorTime = time;
        mLastCursorBounds = nativeGetCursorRingBounds();
        boolean keyHandled
                = nativeMoveCursor(keyCode, count, noScroll) == false;
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "navHandledKey mLastCursorBounds=" + mLastCursorBounds
                    + " mLastCursorTime=" + mLastCursorTime
                    + " handled=" + keyHandled);
        }
        if (keyHandled == false) {
            return keyHandled;
        }
        Rect contentCursorRingBounds = nativeGetCursorRingBounds();
        if (contentCursorRingBounds.isEmpty()) return keyHandled;
        Rect viewCursorRingBounds = contentToViewRect(contentCursorRingBounds);
        // set last touch so that context menu related functions will work
        mLastTouchX = (viewCursorRingBounds.left + viewCursorRingBounds.right) / 2;
        mLastTouchY = (viewCursorRingBounds.top + viewCursorRingBounds.bottom) / 2;
        if (mHeightCanMeasure == false) {
            return keyHandled;
        }
        Rect visRect = new Rect();
        calcOurVisibleRect(visRect);
        Rect outset = new Rect(visRect);
        int maxXScroll = visRect.width() / 2;
        int maxYScroll = visRect.height() / 2;
        outset.inset(-maxXScroll, -maxYScroll);
        if (Rect.intersects(outset, viewCursorRingBounds) == false) {
            return keyHandled;
        }
        // FIXME: Necessary because ScrollView/ListView do not scroll left/right
        int maxH = Math.min(viewCursorRingBounds.right - visRect.right,
                maxXScroll);
        if (maxH > 0) {
            pinScrollBy(maxH, 0, true, 0);
        } else {
            maxH = Math.max(viewCursorRingBounds.left - visRect.left,
                    -maxXScroll);
            if (maxH < 0) {
                pinScrollBy(maxH, 0, true, 0);
            }
        }
        if (mLastCursorBounds.isEmpty()) return keyHandled;
        if (mLastCursorBounds.equals(contentCursorRingBounds)) {
            return keyHandled;
        }
        if (DebugFlags.WEB_VIEW) {
            Log.v(LOGTAG, "navHandledKey contentCursorRingBounds="
                    + contentCursorRingBounds);
        }
        requestRectangleOnScreen(viewCursorRingBounds);
        return keyHandled;
    }

    /**
     * @return Whether accessibility script has been injected.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.662 -0500", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "0A64F31EEB911BD73AAC7B24C14D7589")
    
private boolean accessibilityScriptInjected() {
        // TODO: Maybe the injected script should announce its presence in
        // the page meta-tag so the nativePageShouldHandleShiftAndArrows
        // will check that as one of the conditions it looks for
        return mAccessibilityScriptInjected;
    }

    /**
     * Set the background color. It's white by default. Pass
     * zero to make the view transparent.
     * @param color   the ARGB color described by Color.java
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.664 -0500", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "C525087A89B637AE8141ADDBFDBC0EDC")
    
@Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
    }

    /**
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.666 -0500", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "76B05094347BA6B13C62A9B4D2052F81")
    
@Deprecated
    public void debugDump() {
        checkThread();
        nativeDebugDump();
        mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
    }

    /**
     * Draw the HTML page into the specified canvas. This call ignores any
     * view-specific zoom, scroll offset, or other changes. It does not draw
     * any view-specific chrome, such as progress or URL bars.
     *
     * @hide only needs to be accessible to Browser and testing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.668 -0500", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "AC2FDD1155D17570AF063FB3DDBDC7D2")
    
public void drawPage(Canvas canvas) {
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
    }

    /**
     * Enable the communication b/t the webView and VideoViewProxy
     *
     * @hide only used by the Browser
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.671 -0500", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "FBE95963E967DCF44C70F39386BCB7BB")
    
public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        mHTML5VideoViewProxy = proxy;
    }

    /**
     * Set the time to wait between passing touches to WebCore. See also the
     * TOUCH_SENT_INTERVAL member for further discussion.
     *
     * @hide This is only used by the DRT test application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.673 -0500", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "69E124925F7AA1AA0C3F79AFB71EF12D")
    
public void setTouchInterval(int interval) {
        mCurrentTouchInterval = interval;
    }

    /**
     *  Update our cache with updatedText.
     *  @param updatedText  The new text to put in our cache.
     *  @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.675 -0500", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "F8B9D243E36D54D66BB33CCEC7A06AA9")
    
protected void updateCachedTextfield(String updatedText) {
        // Also place our generation number so that when we look at the cache
        // we recognize that it is up to date.
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.677 -0500", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "74F769C6AF79DFB2F6C73397A396647A")
    
void autoFillForm(int autoFillQueryId) {
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, /* unused */0);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.679 -0500", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "D7B2726C13999E8A86361BD414F1463C")
    
ViewManager getViewManager() {
        return mViewManager;
    }

    /** @hide send content invalidate */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.683 -0500", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "8C2AED0DB0191C5B097885C8574E25B2")
    
protected void contentInvalidateAll() {
        if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        }
    }

    /** @hide call pageSwapCallback upon next page swap */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.685 -0500", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "D39788C02B6FCC586CD5F3E67EFCBE0E")
    
protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
    }

    /**
     * Begin collecting per-tile profiling data
     *
     * @hide only used by profiling tests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.687 -0500", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "C3AFF2CFF3E60465E6BC6B7CC8F74267")
    
public void tileProfilingStart() {
        nativeTileProfilingStart();
    }
    /**
     * Return per-tile profiling data
     *
     * @hide only used by profiling tests
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.690 -0500", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "66B1E5773C7A26A0526E0A3A9BE6F332")
    
public float tileProfilingStop() {
        return nativeTileProfilingStop();
    }

    /** @hide only used by profiling tests */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.692 -0500", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "561C09E9E35368D0C3C0F038D9E7648C")
    
public void tileProfilingClear() {
        nativeTileProfilingClear();
    }
    /** @hide only used by profiling tests */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.695 -0500", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "E0BFA20D057AD1EC46555FF2099B0894")
    
public int tileProfilingNumFrames() {
        return nativeTileProfilingNumFrames();
    }
    /** @hide only used by profiling tests */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.697 -0500", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "8577A1DE12798A70515299D3BA259CEF")
    
public int tileProfilingNumTilesInFrame(int frame) {
        return nativeTileProfilingNumTilesInFrame(frame);
    }
    /** @hide only used by profiling tests */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.699 -0500", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "2CB066A880CE41F80A360FD0B5F6233B")
    
public int tileProfilingGetInt(int frame, int tile, String key) {
        return nativeTileProfilingGetInt(frame, tile, key);
    }
    /** @hide only used by profiling tests */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.701 -0500", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "E8816C1D083E0C115E1BD5969D6BC9A4")
    
public float tileProfilingGetFloat(int frame, int tile, String key) {
        return nativeTileProfilingGetFloat(frame, tile, key);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.705 -0500", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "A725DE72884C02D38A9FC4BA9E3F66B8")
    
    private int nativeCacheHitFramePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.708 -0500", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "250C7F40A2E1FA9D55D5EE0E87360AF8")
    
    private boolean  nativeCacheHitIsPlugin(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "C211C5C405AAE9953CCBBEEF22D45B31")
    private Rect nativeCacheHitNodeBounds() {
    	return new Rect();
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.715 -0500", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "0078AA23333ED0E9D9F4E29369CCC190")
    
    private int nativeCacheHitNodePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.719 -0500", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "2B165C84A0FE1C2B1FA9B2C0B6CC7ACA")
    
    void nativeClearCursor(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.722 -0500", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "66FFF73024A1E31D998A3CCDD3CAC0F3")
    
    private void     nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx){
    	//Formerly a native method
    	addTaint(ptr);
    	addTaint(drawableDir.getTaint());
    	addTaint(isHighEndGfx);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.726 -0500", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "2CF054E2D3EFBAA1143281DAE1B370DE")
    
    private int      nativeCursorFramePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "E271E918D4C574FDDE4719E4B98A8B2B")
    private Rect nativeCursorNodeBounds() {
        Rect rect = new Rect();
        rect.addTaint(getTaint());
    	return rect;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.733 -0500", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "8C4A3E8B097083F8F2C00691591D0F94")
    
    private int nativeCursorNodePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.736 -0500", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "1BF370D8EB320C0666F08D31C910F2A5")
    
    private boolean  nativeCursorIntersects(Rect visibleRect){
    	//Formerly a native method
    	addTaint(visibleRect.getTaint());
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.740 -0500", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "77D3ADD5FE3D0F5732E3760879E6EC99")
    
    private boolean  nativeCursorIsAnchor(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.744 -0500", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "A580CB2DA0F5D0BE1F2E65BF2A1B3861")
    
    private boolean  nativeCursorIsTextInput(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "2045A184BB97A2996B1887CC917B0804")
    private Point nativeCursorPosition() {
        Point p = new Point();
        p.addTaint(getTaint());
    	return p;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "3E24BE9E7EBDB8C5312CC587887CD85C")
    private String nativeCursorText() {
        String str = new String();
        str.addTaint(getTaint());
    	return str;
    }
    /**
     * Returns true if the native cursor node says it wants to handle key events
     * (ala plugins). This can only be called if mNativeClass is non-zero!
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.754 -0500", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "06D066047CE74A86835E2E045E81BC62")
    
    private boolean  nativeCursorWantsKeyEvents(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.757 -0500", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "6630042E6E3CE9825425656AE801DAB0")
    
    private void     nativeDebugDump(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.761 -0500", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "FDCAC65A286C27544E9BABE5E3EB84F6")
    
    private void     nativeDestroy(){
    	//Formerly a native method
    }

    /**
     * Draw the picture set with a background color and extra. If
     * "splitIfNeeded" is true and the return value is not 0, the return value
     * MUST be passed to WebViewCore with SPLIT_PICTURE_SET message so that the
     * native allocation can be freed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.765 -0500", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "68CA2871427ACFBC50DBEE88AC00F0FE")
    
    private int nativeDraw(Canvas canvas, RectF visibleRect,
                int color, int extra, boolean splitIfNeeded){
    	//Formerly a native method
    	canvas.addTaint(visibleRect.getTaint());
    	canvas.addTaint(color);
    	canvas.addTaint(extra);
    	canvas.addTaint(splitIfNeeded);
    	addTaint(canvas.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.768 -0500", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "53E7449DB375CC22D7115AD43A95C76D")
    
    private void     nativeDumpDisplayTree(String urlOrNull){
    	//Formerly a native method
    	addTaint(urlOrNull.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.772 -0500", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "F0ECFE37947AD38040F68EA495E1469C")
    
    private boolean  nativeEvaluateLayersAnimations(int nativeInstance){
    	//Formerly a native method
    	addTaint(nativeInstance);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.776 -0500", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "C7FF7B092A78BF8950A7737CC5CB1154")
    
    private int      nativeGetDrawGLFunction(int nativeInstance, Rect rect,
                Rect viewRect, RectF visibleRect, float scale, int extras){
    	//Formerly a native method
    	addTaint(nativeInstance);
    	addTaint(rect.getTaint());
    	addTaint(viewRect.getTaint());
    	addTaint(visibleRect.getTaint());
    	addTaint(scale);
    	addTaint(extras);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.780 -0500", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "CD3A2B7BAA7578765697616E334D2161")
    
    private void     nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
                RectF visibleRect){
    	//Formerly a native method
    	addTaint(rect.getTaint());
    	addTaint(viewRect.getTaint());
    	addTaint(visibleRect.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.783 -0500", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "A87A6B303B6EAB21827F10DD568BEE52")
    
    private void     nativeExtendSelection(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.787 -0500", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "D47BAF4CF4FABE978E2B3BB20BF72457")
    
    private int      nativeFindAll(String findLower, String findUpper,
                boolean sameAsLastSearch){
    	//Formerly a native method
    	addTaint(findLower.getTaint());
    	addTaint(findUpper.getTaint());
    	addTaint(sameAsLastSearch);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.791 -0500", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "331B206015E58642B8163EC10612022F")
    
    private void     nativeFindNext(boolean forward){
    	//Formerly a native method
    	addTaint(forward);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.794 -0500", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "1AC5E410627D65E0995733694906A89B")
    
    int      nativeFocusCandidateFramePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.797 -0500", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "64FF0605F6D8E4F68CC24574286C04C9")
    
    boolean  nativeFocusCandidateHasNextTextfield(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.800 -0500", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "782618A9B159384D9FD18DD103A1ADAC")
    
    boolean  nativeFocusCandidateIsPassword(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.803 -0500", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "410FDAC4E088DC26E5D4C33C32FBEF63")
    
    private boolean  nativeFocusCandidateIsRtlText(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.807 -0500", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "37D9D915D1D0E256D902B54F7BC15CFC")
    
    private boolean  nativeFocusCandidateIsTextInput(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.811 -0500", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "57AD3EE512EEE700B38A3D00E923C4C6")
    
    int      nativeFocusCandidateMaxLength(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.814 -0500", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "64661C02334B4CAA6A0AB134EC1FEDDF")
    
    boolean  nativeFocusCandidateIsAutoComplete(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.818 -0500", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "350ED0C2ABC212BBE1C6DFC0F96AD5FC")
    
    boolean  nativeFocusCandidateIsSpellcheck(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "482EB255509BA82D443BAA9D71623788")
     String nativeFocusCandidateName() {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "E9FE505188BFAFC647C681A775DCAAFD")
    private Rect nativeFocusCandidateNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "8CA80E2A60FEEA9061A61B09DA68625A")
    private Rect nativeFocusCandidatePaddingRect() {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.832 -0500", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "F96D5F75089BEE6BD6045096E4817869")
    
    int      nativeFocusCandidatePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "B8D2D3434495629B87849A0DDE9761CA")
    private String nativeFocusCandidateText() {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.840 -0500", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "D39414142619CA2C5A5AC12FF0A78348")
    
    float    nativeFocusCandidateTextSize(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.843 -0500", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "5F15AECA738E1078F11CE6A9C9808FF6")
    
    int nativeFocusCandidateLineHeight(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Returns an integer corresponding to WebView.cpp::type.
     * See WebTextView.setType()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.846 -0500", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "7D3B69FEE47F02C045548A1FDEFBBAEF")
    
    private int      nativeFocusCandidateType(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.849 -0500", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "0D21C0543AED5DE880C12259511B8515")
    
    private int      nativeFocusCandidateLayerId(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.853 -0500", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "D493DAED54C6530D6856706D7C85A79B")
    
    private boolean  nativeFocusIsPlugin(){
    	//Formerly a native method
    	return getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "65244A088D15DCA1F0C3C7F2D973DFD4")
    private Rect nativeFocusNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.860 -0500", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "5F625D5E51C0A3CD879EB83976F799F5")
    
    int nativeFocusNodePointer(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "68114054688AC2ACF3B41A1E50F28F3A")
    private Rect nativeGetCursorRingBounds() {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "CAEC1387621E6EAAC0BBE851878D90E6")
    private String nativeGetSelection() {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.872 -0500", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "45DF3BE9B61C2C505D06C3D0146704B9")
    
    private boolean  nativeHasCursorNode(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.875 -0500", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "6541D875F51D35F33911824D158B7BF0")
    
    private boolean  nativeHasFocusNode(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.879 -0500", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "C89C05A6B7EB783543227B788A45A258")
    
    private void     nativeHideCursor(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.882 -0500", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "A9D8A1A321DA1FF70D9F680AED29AEAA")
    
    private boolean  nativeHitSelection(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	return getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "68E20D0E121FE807EF3A683540460D64")
    private String nativeImageURI(int x, int y) {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.889 -0500", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "CA0D21A2912F22BC450807E65C3480FD")
    
    private void     nativeInstrumentReport(){
    	//Formerly a native method
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "0EF9BAF6479325B7AFB630E9F288D638")
    private Rect nativeLayerBounds(int layer) {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.896 -0500", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "20CECC8D9E09EA4A7365EB985126939B")
    
    boolean nativeMoveCursorToNextTextInput(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    // return true if the page has been scrolled
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.900 -0500", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "221B1530F83EAC09726D5A51C2A75364")
    
    private boolean  nativeMotionUp(int x, int y, int slop){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(slop);
    	return getTaintBoolean();
    }

    // returns false if it handled the key
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.904 -0500", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "37475DD2AB12294B101591D4D050D542")
    
    private boolean  nativeMoveCursor(int keyCode, int count,
                boolean noScroll){
    	//Formerly a native method
    	addTaint(keyCode);
    	addTaint(count);
    	addTaint(noScroll);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.907 -0500", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "77DDCC6B20FAE053FE3481DE62E0B0B4")
    
    private int      nativeMoveGeneration(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.912 -0500", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "4898BDB30C49B9D5542F13D242CB0F53")
    
    private void     nativeMoveSelection(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    }

    /**
     * @return true if the page should get the shift and arrow keys, rather
     * than select text/navigation.
     *
     * If the focus is a plugin, or if the focus and cursor match and are
     * a contentEditable element, then the page should handle these keys.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.915 -0500", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "373B20749F8049D07D4D4E9A48E84B59")
    
    private boolean  nativePageShouldHandleShiftAndArrows(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.918 -0500", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "746BBE8DF0191980C4DCDDE9251AD195")
    
    private boolean  nativePointInNavCache(int x, int y, int slop){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(slop);
    	return getTaintBoolean();
    }

    // Like many other of our native methods, you must make sure that
    // mNativeClass is not null before calling this method.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.922 -0500", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "110286EB50D9247D355905A201DDCA3E")
    
    private void     nativeResetSelection(){
    	//Formerly a native method
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "4FCCB0475B387C1F5318EC92944C45EC")
    private Point nativeSelectableText() {
    	Point p = new Point();
    	p.addTaint(getTaint());
    	return p;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.930 -0500", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "3139B34B7932D90BBD974861A784E91F")
    
    private void     nativeSelectAll(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.933 -0500", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "B997F9D32E797806125E25E4F0EC22DB")
    
    private void     nativeSelectBestAt(Rect rect){
    	//Formerly a native method
    	addTaint(rect.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.937 -0500", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "BC4BE5FAD18BEE52DB68D9363C3A3C2B")
    
    private void     nativeSelectAt(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.940 -0500", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "835E8E0007CB048A352D8F41A17C4BD2")
    
    private int      nativeSelectionX(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.944 -0500", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "DA2361A52D118C851D6DBCEBAD7C9443")
    
    private int      nativeSelectionY(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.948 -0500", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "E690A45EAB11FD4E5C4D2AA54D4F336F")
    
    private int      nativeFindIndex(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.951 -0500", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "4AA569088B7EBAF3D59FA33B812EE0F2")
    
    private void     nativeSetExtendSelection(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.954 -0500", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "C98ABCAE96A9D906EFC016AD2CE07734")
    
    private void     nativeSetFindIsEmpty(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.959 -0500", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "77D96611FA3FA1421CB122D73B135432")
    
    private void     nativeSetFindIsUp(boolean isUp){
    	//Formerly a native method
    	addTaint(isUp);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.962 -0500", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "D3339C825BD61F277D0714C3D17C210E")
    
    private void     nativeSetHeightCanMeasure(boolean measure){
    	//Formerly a native method
    	addTaint(measure);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.965 -0500", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "1C4A354AB0673554798FB5A100101959")
    
    private void     nativeSetBaseLayer(int layer, Region invalRegion,
                boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
                boolean registerPageSwapCallback){
    	//Formerly a native method
    	addTaint(layer);
    	addTaint(invalRegion.getTaint());
    	addTaint(showVisualIndicator);
    	addTaint(isPictureAfterFirstLayout);
    	addTaint(registerPageSwapCallback);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.969 -0500", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "AC1A439B6AB31BD5CA6DD47AF93CFF14")
    
    private int      nativeGetBaseLayer(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.973 -0500", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "227F35ED33FA1A2E05ECA826034B497E")
    
    private void     nativeShowCursorTimed(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.977 -0500", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "31521DE97A0FA3B32BCBB80AF005ABC3")
    
    private void     nativeReplaceBaseContent(int content){
    	//Formerly a native method
    	addTaint(content);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.980 -0500", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "C536C75654272169E0C3DA476C319B1A")
    
    private void     nativeCopyBaseContentToPicture(Picture pict){
    	//Formerly a native method
    	addTaint(pict.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.984 -0500", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "C47B602BF3B6FD8117B49BCBEA2808FF")
    
    private boolean  nativeHasContent(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.987 -0500", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "7C055334B53CFB8D8E2834A9CE661822")
    
    private void     nativeSetSelectionPointer(int nativeInstance,
                boolean set, float scale, int x, int y){
    	//Formerly a native method
    	addTaint(nativeInstance);
    	addTaint(set);
    	addTaint(scale);
    	addTaint(x);
    	addTaint(y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.991 -0500", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "2B571047D345F3826F89679DAEE97B57")
    
    private boolean  nativeStartSelection(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	return getTaintBoolean();
    }

    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:52.995 -0500", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "75A7C05D4AA5464F454B10A42FCB9D28")
    
    private void     nativeStopGL(){
    	//Formerly a native method
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "59C253F3D708B1AEFB61B74588B1BC4B")
    private Rect nativeSubtractLayers(Rect content) {
    	Rect r = new Rect();
    	r.addTaint(getTaint());
    	return r;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.002 -0500", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "1A1D4D1C6EED71495F53A17883F0674B")
    
    private int      nativeTextGeneration(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.005 -0500", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "513A00773C9A1C0EF090553B372609E8")
    
    private void     nativeRegisterPageSwapCallback(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.008 -0500", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "A6911D4623DBA5902DD797889426BF48")
    
    private void     nativeTileProfilingStart(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.012 -0500", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "34171B9E2FC17F0A7B839AC65C4F35B6")
    
    private float    nativeTileProfilingStop(){
    	//Formerly a native method
    	return getTaintFloat();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.016 -0500", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "944F4DF17F0DBBC34C510EC20D481166")
    
    private void     nativeTileProfilingClear(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.020 -0500", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "BD7609B5D3B066F4EFD379B5BB418E24")
    
    private int      nativeTileProfilingNumFrames(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.023 -0500", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "E4E05FB89E4F3E374BD36BBAEB165D61")
    
    private int      nativeTileProfilingNumTilesInFrame(int frame){
    	//Formerly a native method
    	addTaint(frame);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.027 -0500", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "4F46979CA4BF5A98A4C78DB4DD641130")
    
    private int      nativeTileProfilingGetInt(int frame, int tile, String key){
    	//Formerly a native method
    	addTaint(frame);
    	addTaint(tile);
    	addTaint(key.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.031 -0500", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "DEF6850FF385EE40B5DDF53B9E27425D")
    
    private float    nativeTileProfilingGetFloat(int frame, int tile, String key){
    	//Formerly a native method
    	addTaint(frame);
    	addTaint(tile);
    	addTaint(key.getTaint());
    	return getTaintFloat();
    }

    // Never call this version except by updateCachedTextfield(String) -
    // we always want to pass in our generation number.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.034 -0500", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "070A0C631983DC550FDAB6E639F497C7")
    
    private void     nativeUpdateCachedTextfield(String updatedText,
                int generation){
    	//Formerly a native method
    	addTaint(updatedText.getTaint());
    	addTaint(generation);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.038 -0500", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "65C1F5CD7CB48CC81A7F23FF36903815")
    
    private boolean  nativeWordSelection(int x, int y){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	return getTaintBoolean();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.044 -0500", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "A9FA0948B92F80C5E8F880138040C094")
    
    int nativeGetBlockLeftEdge(int x, int y, float scale){
    	//Formerly a native method
    	return (int)(getTaintInt() + x + y + scale);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.048 -0500", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "9D0FE0F2692FD31CE8FCE2C8E073ABB3")
    
    private void     nativeUseHardwareAccelSkia(boolean enabled){
    	//Formerly a native method
    	addTaint(enabled);
    }

    // Returns a pointer to the scrollable LayerAndroid at the given point.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.052 -0500", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "D3ECD2A482E17F929789F45B9E5A2D44")
    
    private int      nativeScrollableLayer(int x, int y, Rect scrollRect,
                Rect scrollBounds){
    	//Formerly a native method
    	addTaint(x);
    	addTaint(y);
    	addTaint(scrollRect.getTaint());
    	addTaint(scrollBounds.getTaint());
    	return getTaintInt();
    }

    /**
     * Scroll the specified layer.
     * @param layer Id of the layer to scroll, as determined by nativeScrollableLayer.
     * @param newX Destination x position to which to scroll.
     * @param newY Destination y position to which to scroll.
     * @return True if the layer is successfully scrolled.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.055 -0500", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "015487A2DECA804E37E7382E2BDB07AE")
    
    private boolean  nativeScrollLayer(int layer, int newX, int newY){
    	//Formerly a native method
    	addTaint(layer);
    	addTaint(newX);
    	addTaint(newY);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.058 -0500", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "345AEA5411DADE6AD28448ADE2EEB8F3")
    
    private void     nativeSetIsScrolling(boolean isScrolling){
    	//Formerly a native method
    	addTaint(isScrolling);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.062 -0500", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "BCB79DA97285BA9144ED18B6A36D0474")
    
    private int      nativeGetBackgroundColor(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.066 -0500", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "8807297C32E8F23B6318088727687D37")
    
    boolean  nativeSetProperty(String key, String value){
    	//Formerly a native method
    	addTaint(key.getTaint());
    	addTaint(value.getTaint());
    	return getTaintBoolean();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "2CDC971A436EF25C108C6D2B163E982B")
     String nativeGetProperty(String key) {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.073 -0500", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "299CE957150C03620EC4FCE530500687")
    
    private void     nativeGetTextSelectionRegion(int instance, Region region){
    	//Formerly a native method
    	//addTaint(instance);
    	//addTaint(region.getTaint());
    	region.addTaint(instance + region.getTaintInt());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:53.076 -0500", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "4DB5BF496616839CE6BEF8CF80EDD7D3")
    
    private void     nativeGetSelectionHandles(int instance, int[] handles){
    	//Formerly a native method
        handles[0] = instance;
        /*
    	addTaint(instance);
    	addTaint(handles[0]);
    	*/
    }

}

