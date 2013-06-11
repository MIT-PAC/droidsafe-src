package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.Widget;
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
import junit.framework.Assert;
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
import static javax.microedition.khronos.egl.EGL10.*;

public class WebView extends AbsoluteLayout implements ViewTreeObserver.OnGlobalFocusChangeListener, ViewGroup.OnHierarchyChangeListener {
    private InnerGlobalLayoutListener mGlobalLayoutListener = null;
    private InnerScrollChangedListener mScrollChangedListener = null;
    static private final boolean AUTO_REDRAW_HACK = false;
    private boolean mAutoRedraw;
    private AlertDialog mListBoxDialog = null;
    static final String LOGTAG = "webview";
    private ZoomManager mZoomManager;
    private final Rect mGLRectViewport = new Rect();
    private final Rect mViewRectViewport = new Rect();
    private final RectF mVisibleContentRect = new RectF();
    private boolean mGLViewportEmpty = false;
    private final CallbackProxy mCallbackProxy;
    private final WebViewDatabase mDatabase;
    private SslCertificate mCertificate;
    private int mNativeClass;
    private WebViewCore mWebViewCore;
    final Handler mPrivateHandler = new PrivateHandler();
    private WebTextView mWebTextView;
    private int mTextGeneration;
    final ViewManager mViewManager;
    PluginFullScreenHolder mFullScreenHolder;
    private int mLastTouchX;
    private int mLastTouchY;
    private int mStartTouchX;
    private int mStartTouchY;
    private float mAverageAngle;
    private long mLastTouchTime;
    private long mLastSentTouchTime;
    private static final int TOUCH_SENT_INTERVAL = 0;
    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
    VelocityTracker mVelocityTracker;
    private int mMaximumFling;
    private float mLastVelocity;
    private float mLastVelX;
    private float mLastVelY;
    private int mCurrentScrollingLayerId;
    private Rect mScrollingLayerRect = new Rect();
    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    private int mTouchMode = TOUCH_DONE_MODE;
    private static final int TOUCH_INIT_MODE = 1;
    private static final int TOUCH_DRAG_START_MODE = 2;
    private static final int TOUCH_DRAG_MODE = 3;
    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    private static final int TOUCH_SHORTPRESS_MODE = 5;
    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    private static final int TOUCH_DONE_MODE = 7;
    private static final int TOUCH_PINCH_DRAG = 8;
    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    private boolean mForwardTouchEvents = false;
    private static final int PREVENT_DEFAULT_NO = 0;
    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    private static final int PREVENT_DEFAULT_YES = 3;
    private static final int PREVENT_DEFAULT_IGNORE = 4;
    private int mPreventDefault = PREVENT_DEFAULT_IGNORE;
    private boolean mConfirmMove;
    private boolean mDeferTouchProcess;
    private int mDeferTouchMode = TOUCH_DONE_MODE;
    private float mLastDeferTouchX;
    private float mLastDeferTouchY;
    boolean mDragFromTextInput;
    private boolean mDrawCursorRing = true;
    private boolean mIsPaused;
    private HitTestResult mInitialHitTestResult;
    private int mTouchSlopSquare;
    private int mDoubleTapSlopSquare;
    private int mNavSlop;
    private static final int TAP_TIMEOUT = 300;
    private static final int LONG_PRESS_TIMEOUT = 1000;
    private static final int MIN_FLING_TIME = 250;
    private static final int MOTIONLESS_TIME = 100;
    private static final int PAGE_SCROLL_OVERLAP = 24;
    boolean mWidthCanMeasure;
    boolean mHeightCanMeasure;
    int mLastWidthSent;
    int mLastHeightSent;
    int mLastActualHeightSent;
    private int mContentWidth;
    private int mContentHeight;
    private boolean mOverlayHorizontalScrollbar = true;
    private boolean mOverlayVerticalScrollbar = false;
    private static final int STD_SPEED = 480;
    private static final int MAX_DURATION = 750;
    private static final int SLIDE_TITLE_DURATION = 500;
    OverScroller mScroller;
    private boolean mInOverScrollMode = false;
    private static Paint mOverScrollBackground;
    private static Paint mOverScrollBorder;
    private boolean mWrapContent;
    private static final int MOTIONLESS_FALSE           = 0;
    private static final int MOTIONLESS_PENDING         = 1;
    private static final int MOTIONLESS_TRUE            = 2;
    private static final int MOTIONLESS_IGNORE          = 3;
    private int mHeldMotionless;
    private AccessibilityInjector mAccessibilityInjector;
    private boolean mAccessibilityScriptInjected;
    static final boolean USE_JAVA_TEXT_SELECTION = true;
    static final boolean DEBUG_TEXT_HANDLES = false;
    private Region mTextSelectionRegion = new Region();
    private Paint mTextSelectionPaint;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    static final boolean USE_WEBKIT_RINGS = false;
    private static final int HIGHLIGHT_COLOR = 0x6633b5e5;
    private static final float TOUCH_HIGHLIGHT_ARC = 5.0f;
    private Region mTouchHighlightRegion = new Region();
    private Paint mTouchHightlightPaint;
    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
    private Paint mTouchCrossHairColor;
    private int mTouchHighlightX;
    private int mTouchHighlightY;
    private long mTouchHighlightRequested;
    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    private boolean mBlockWebkitViewMessages = false;
    private boolean mHardwareAccelSkia = false;
    private static final int REMEMBER_PASSWORD          = 1;
    private static final int NEVER_REMEMBER_PASSWORD    = 2;
    private static final int SWITCH_TO_SHORTPRESS       = 3;
    private static final int SWITCH_TO_LONGPRESS        = 4;
    private static final int RELEASE_SINGLE_TAP         = 5;
    private static final int REQUEST_FORM_DATA          = 6;
    private static final int DRAG_HELD_MOTIONLESS       = 8;
    private static final int AWAKEN_SCROLL_BARS         = 9;
    private static final int PREVENT_DEFAULT_TIMEOUT    = 10;
    private static final int SCROLL_SELECT_TEXT         = 11;
    private static final int FIRST_PRIVATE_MSG_ID = REMEMBER_PASSWORD;
    private static final int LAST_PRIVATE_MSG_ID = SCROLL_SELECT_TEXT;
    static final int SCROLL_TO_MSG_ID                   = 101;
    static final int NEW_PICTURE_MSG_ID                 = 105;
    static final int UPDATE_TEXT_ENTRY_MSG_ID           = 106;
    static final int WEBCORE_INITIALIZED_MSG_ID         = 107;
    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID       = 108;
    static final int UPDATE_ZOOM_RANGE                  = 109;
    static final int UNHANDLED_NAV_KEY                  = 110;
    static final int CLEAR_TEXT_ENTRY                   = 111;
    static final int UPDATE_TEXT_SELECTION_MSG_ID       = 112;
    static final int SHOW_RECT_MSG_ID                   = 113;
    static final int LONG_PRESS_CENTER                  = 114;
    static final int PREVENT_TOUCH_ID                   = 115;
    static final int WEBCORE_NEED_TOUCH_EVENTS          = 116;
    static final int INVAL_RECT_MSG_ID                  = 117;
    static final int REQUEST_KEYBOARD                   = 118;
    static final int DO_MOTION_UP                       = 119;
    static final int SHOW_FULLSCREEN                    = 120;
    static final int HIDE_FULLSCREEN                    = 121;
    static final int DOM_FOCUS_CHANGED                  = 122;
    static final int REPLACE_BASE_CONTENT               = 123;
    static final int FORM_DID_BLUR                      = 124;
    static final int RETURN_LABEL                       = 125;
    static final int FIND_AGAIN                         = 126;
    static final int CENTER_FIT_RECT                    = 127;
    static final int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
    static final int SET_SCROLLBAR_MODES                = 129;
    static final int SELECTION_STRING_CHANGED           = 130;
    static final int SET_TOUCH_HIGHLIGHT_RECTS          = 131;
    static final int SAVE_WEBARCHIVE_FINISHED           = 132;
    static final int SET_AUTOFILLABLE                   = 133;
    static final int AUTOFILL_COMPLETE                  = 134;
    static final int SELECT_AT                          = 135;
    static final int SCREEN_ON                          = 136;
    static final int ENTER_FULLSCREEN_VIDEO             = 137;
    static final int UPDATE_SELECTION                   = 138;
    static final int UPDATE_ZOOM_DENSITY                = 139;
    private static final int FIRST_PACKAGE_MSG_ID = SCROLL_TO_MSG_ID;
    private static final int LAST_PACKAGE_MSG_ID = SET_TOUCH_HIGHLIGHT_RECTS;
    static final String[] HandlerPrivateDebugString = {
        "REMEMBER_PASSWORD", 
        "NEVER_REMEMBER_PASSWORD", 
        "SWITCH_TO_SHORTPRESS", 
        "SWITCH_TO_LONGPRESS", 
        "RELEASE_SINGLE_TAP", 
        "REQUEST_FORM_DATA", 
        "RESUME_WEBCORE_PRIORITY", 
        "DRAG_HELD_MOTIONLESS", 
        "AWAKEN_SCROLL_BARS", 
        "PREVENT_DEFAULT_TIMEOUT", 
        "SCROLL_SELECT_TEXT" 
    };
    static final String[] HandlerPackageDebugString = {
        "SCROLL_TO_MSG_ID", 
        "102", 
        "103", 
        "104", 
        "NEW_PICTURE_MSG_ID", 
        "UPDATE_TEXT_ENTRY_MSG_ID", 
        "WEBCORE_INITIALIZED_MSG_ID", 
        "UPDATE_TEXTFIELD_TEXT_MSG_ID", 
        "UPDATE_ZOOM_RANGE", 
        "UNHANDLED_NAV_KEY", 
        "CLEAR_TEXT_ENTRY", 
        "UPDATE_TEXT_SELECTION_MSG_ID", 
        "SHOW_RECT_MSG_ID", 
        "LONG_PRESS_CENTER", 
        "PREVENT_TOUCH_ID", 
        "WEBCORE_NEED_TOUCH_EVENTS", 
        "INVAL_RECT_MSG_ID", 
        "REQUEST_KEYBOARD", 
        "DO_MOTION_UP", 
        "SHOW_FULLSCREEN", 
        "HIDE_FULLSCREEN", 
        "DOM_FOCUS_CHANGED", 
        "REPLACE_BASE_CONTENT", 
        "FORM_DID_BLUR", 
        "RETURN_LABEL", 
        "FIND_AGAIN", 
        "CENTER_FIT_RECT", 
        "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID", 
        "SET_SCROLLBAR_MODES", 
        "SELECTION_STRING_CHANGED", 
        "SET_TOUCH_HIGHLIGHT_RECTS", 
        "SAVE_WEBARCHIVE_FINISHED", 
        "SET_AUTOFILLABLE", 
        "AUTOFILL_COMPLETE", 
        "SELECT_AT", 
        "SCREEN_ON", 
        "ENTER_FULLSCREEN_VIDEO", 
        "UPDATE_SELECTION", 
        "UPDATE_ZOOM_DENSITY" 
    };
    static final int DEFAULT_VIEWPORT_WIDTH = 980;
    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
    private int mInitialScaleInPercent = 0;
    private boolean mSendScrollEvent = true;
    private int mSnapScrollMode = SNAP_NONE;
    private static final int SNAP_NONE = 0;
    private static final int SNAP_LOCK = 1;
    private static final int SNAP_X = 2;
    private static final int SNAP_Y = 4;
    private boolean mSnapPositive;
    private static final int DRAW_EXTRAS_NONE = 0;
    private static final int DRAW_EXTRAS_FIND = 1;
    private static final int DRAW_EXTRAS_SELECTION = 2;
    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
    private static final int SCROLLBAR_AUTO = 0;
    private static final int SCROLLBAR_ALWAYSOFF = 1;
    private static final int SCROLLBAR_ALWAYSON = 2;
    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
    private static final int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
    private static final String ALIAS_ACCESSIBILITY_JS_INTERFACE = "accessibility";
    private static final String ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT =
        "javascript:(function() {" +
        "    var chooser = document.createElement('script');" +
        "    chooser.type = 'text/javascript';" +
        "    chooser.src = 'https://ssl.gstatic.com/accessibility/javascript/android/AndroidScriptChooser.user.js';" +
        "    document.getElementsByTagName('head')[0].appendChild(chooser);" +
        "  })();";
    private static final String PATTERN_MATCH_AXS_URL_PARAMETER = "(\\?axs=(0|1))|(&axs=(0|1))";
    private TextToSpeech mTextToSpeech;
    private Pattern mMatchAxsUrlParameterPattern;
    private int mOverscrollDistance;
    private int mOverflingDistance;
    private OverScrollGlow mOverScrollGlow;
    private Vector<Integer> mKeysPressed;
    static boolean mLogEvent = true;
    private long mLastTouchUpTime = 0;
    private WebViewCore.AutoFillData mAutoFillData;
    private static boolean sNotificationsEnabled = true;
    public static final String SCHEME_TEL = "tel:";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    private int mBackgroundColor = Color.WHITE;
    private static final long SELECT_SCROLL_INTERVAL = 1000 / 60;
    private int mAutoScrollX = 0;
    private int mAutoScrollY = 0;
    private int mMinAutoScrollX = 0;
    private int mMaxAutoScrollX = 0;
    private int mMinAutoScrollY = 0;
    private int mMaxAutoScrollY = 0;
    private Rect mScrollingLayerBounds = new Rect();
    private boolean mSentAutoScrollMessage = false;
    private static boolean mIncrementEGLContextHack = false;
    private final TouchEventQueue mTouchEventQueue = new TouchEventQueue();
    private boolean mPictureUpdatePausedForFocusChange = false;
    private PictureListener mPictureListener;
    private static ProxyReceiver sProxyReceiver;
    private static boolean sPackageInstallationReceiverAdded = false;
    private static Set<String> sGoogleApps;
    private int mCachedOverlappingActionModeHeight = -1;
    private View mTitleBar;
    private int mTitleGravity;
    private Rect mLastVisibleRectSent = new Rect();
    private Rect mLastGlobalRect = new Rect();
    private Rect mVisibleRect = new Rect();
    private Rect mGlobalVisibleRect = new Rect();
    private Point mScrollOffset = new Point();
    private Point mGlobalVisibleOffset = new Point();
    private Rect mContentVisibleRect = new Rect();
    private FindActionModeCallback mFindCallback;
    private boolean mFindIsUp;
    private String mLastFind;
    private String mPageThatNeedsToSlideTitleBarOffScreen;
    private int mYDistanceToSlideTitleOffScreen;
    private int mOrientation = Configuration.ORIENTATION_UNDEFINED;
    private SelectActionModeCallback mSelectCallback;
    private static final int FULLY_ON_SCREEN = 0;
    private static final int INTERSECTS_SCREEN = 1;
    private static final int ANYWHERE = 2;
    private static final int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
    private static final int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
    private final DrawFilter mZoomFilter =
            new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
    private final DrawFilter mScrollFilter =
            new PaintFlagsDrawFilter(SCROLL_BITS, 0);
    private boolean mDrawHistory = false;
    private Picture mHistoryPicture = null;
    private int mHistoryWidth = 0;
    private int mHistoryHeight = 0;
    private boolean mGotCenterDown = false;
    private static final float HSLOPE_TO_START_SNAP = .25f;
    private static final float HSLOPE_TO_BREAK_SNAP = .4f;
    private static final float VSLOPE_TO_START_SNAP = 1.25f;
    private static final float VSLOPE_TO_BREAK_SNAP = .95f;
    private static final float ANGLE_VERT = 2f;
    private static final float ANGLE_HORIZ = 0f;
    private static final float MMA_WEIGHT_N = 5;
    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
    private long mTrackballFirstTime = 0;
    private long mTrackballLastTime = 0;
    private float mTrackballRemainsX = 0.0f;
    private float mTrackballRemainsY = 0.0f;
    private int mTrackballXMove = 0;
    private int mTrackballYMove = 0;
    private boolean mSelectingText = false;
    private boolean mSelectionStarted = false;
    private boolean mExtendSelection = false;
    private boolean mDrawSelectionPointer = false;
    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    private static final int TRACKBALL_TIMEOUT = 200;
    private static final int TRACKBALL_WAIT = 100;
    private static final int TRACKBALL_SCALE = 400;
    private static final int TRACKBALL_SCROLL_COUNT = 5;
    private static final int TRACKBALL_MOVE_COUNT = 10;
    private static final int TRACKBALL_MULTIPLIER = 3;
    private static final int SELECT_CURSOR_OFFSET = 16;
    private static final int SELECT_SCROLL = 5;
    private int mSelectX = 0;
    private int mSelectY = 0;
    private boolean mFocusSizeChanged = false;
    private boolean mTrackballDown = false;
    private long mTrackballUpTime = 0;
    private long mLastCursorTime = 0;
    private Rect mLastCursorBounds;
    private boolean mMapTrackballToArrowKeys = true;
    private DrawData mDelaySetPicture;
    private DrawData mLoadedPicture;
    private Message mListBoxMessage;
    static final int NO_LEFTEDGE = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.318 -0400", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "916FFFCDEF90262FA137B9C1EBADF9C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.318 -0400", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "CE1809898695E7588186C1B94484F817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.318 -0400", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "D415737A572ADF5620424074E024683D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.318 -0400", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "9DF63A2E8467839A7E0AB617CBDFFADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context, AttributeSet attrs, int defStyle,
            boolean privateBrowsing) {
        this(context, attrs, defStyle, null, privateBrowsing);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(privateBrowsing);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "732F05AC7620417E9D273155F1DFFAE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected WebView(Context context, AttributeSet attrs, int defStyle,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(javaScriptInterfaces.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(privateBrowsing);
        checkThread();
        /*
        {
            throw new IllegalArgumentException("Invalid context argument");
        } //End block
        */
        JniUtil.setContext(context);
        mCallbackProxy = new CallbackProxy(context, this);
        mViewManager = new ViewManager(this);
        L10nUtils.setApplicationContext(context.getApplicationContext());
        mWebViewCore = new WebViewCore(context, this, mCallbackProxy, javaScriptInterfaces);
        mDatabase = WebViewDatabase.getInstance(context);
        mScroller = new OverScroller(context, null, 0, 0, false);
        mZoomManager = new ZoomManager(this, mCallbackProxy);
        init();
        setupPackageListener(context);
        setupProxyListener(context);
        updateMultiTouchSupport(context);
        {
            startPrivateBrowsing();
        } //End block
        mAutoFillData = new WebViewCore.AutoFillData();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "716712ADAB695835D13726CD4D67E95C")
    @DSModeled(DSC.SAFE)
     void incrementTextGeneration() {
        mTextGeneration++;
        // ---------- Original Method ----------
        //mTextGeneration++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "9DD1CC09113D51859A2A4670DD02C2DF", hash_generated_method = "FCDA953C8433D77A64389A2C0E5FD53F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "4253223359E0A55D0B7478B1E46B70E0", hash_generated_method = "BE62E962D780E3FF30B32BD79E8A1FC0")
    private static synchronized void disableProxyListener(Context context) {
        if (sProxyReceiver == null)
            return;
        context.getApplicationContext().unregisterReceiver(sProxyReceiver);
        sProxyReceiver = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "95792EAC29A9A8AB6982385F0DB82F6E", hash_generated_method = "858615C39CA8948C325BEF6AC3361B7B")
    private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyProperties = (ProxyProperties)intent.getExtra(Proxy.EXTRA_PROXY_INFO);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, null);
            return;
        }
        WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, proxyProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "D1CA135B70EB7830EE7E1E547C43D311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupPackageListener(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            IntentFilter filter;
            filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addDataScheme("package");
            BroadcastReceiver packageListener;
            packageListener = new PackageListener();
            context.getApplicationContext().registerReceiver(packageListener, filter);
            sPackageInstallationReceiverAdded = true;
        } //End block
        AsyncTask<Void, Void, Set<String>> task;
        task = new AsyncTask<Void, Void, Set<String>>() {
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
                    }
                }
                return installedPackages;
            }
            @Override
            protected void onPostExecute(Set<String> installedPackages) {
                if (mWebViewCore != null) {
                    mWebViewCore.sendMessage(EventHub.ADD_PACKAGE_NAMES, installedPackages);
                }
            }
        };
        task.execute();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "D0481667C0DC686AB16AE5B8A3F9F0EF")
    @DSModeled(DSC.SAFE)
     void updateMultiTouchSupport(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mZoomManager.updateMultiTouchSupport(context);
        // ---------- Original Method ----------
        //mZoomManager.updateMultiTouchSupport(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "F46843AC9CC3C12A5C02493211AD86F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init() {
        OnTrimMemoryListener.init(getContext());
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        final ViewConfiguration configuration;
        configuration = ViewConfiguration.get(getContext());
        int slop;
        slop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = slop * slop;
        slop = configuration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = slop * slop;
        final float density;
        density = getContext().getResources().getDisplayMetrics().density;
        mNavSlop = (int) (16 * density);
        mZoomManager.init(density);
        mMaximumFling = configuration.getScaledMaximumFlingVelocity();
        DRAG_LAYER_INVERSE_DENSITY_SQUARED = 1 / (density * density);
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        setScrollBarStyle(super.getScrollBarStyle());
        mKeysPressed = new Vector<Integer>(2);
        mHTML5VideoViewProxy = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.319 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "5080F2EF14C9DC10393EB8319AEC0906")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "A0A77B8998B167FFCF92E2993B8A7B9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addAccessibilityApisToJavaScript() {
        {
            boolean varBB290631FF6BE4C8F44D202E8FB380A0_334829615 = (AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled());
            {
                final Context ctx;
                ctx = getContext();
                {
                    final String packageName;
                    packageName = ctx.getPackageName();
                    {
                        mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            packageName + ".**webview**");
                        addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()
                //&& getSettings().getJavaScriptEnabled()) {
            //final Context ctx = getContext();
            //if (ctx != null) {
                //final String packageName = ctx.getPackageName();
                //if (packageName != null) {
                    //mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            //packageName + ".**webview**");
                    //addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "C371A290DF20D97B37459B0595C7D100")
    @DSModeled(DSC.SAFE)
    private void removeAccessibilityApisFromJavaScript() {
        {
            removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        } //End block
        // ---------- Original Method ----------
        //if (mTextToSpeech != null) {
            //removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            //mTextToSpeech.shutdown();
            //mTextToSpeech = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "AB529852462D6AA80F30161C911E45BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "36B2C58891C3548E783830C71D624D8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        final int convertedContentWidth;
        convertedContentWidth = contentToViewX(getContentWidth());
        final int adjustedViewWidth;
        adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        final int convertedContentHeight;
        convertedContentHeight = contentToViewY(getContentHeight());
        final int adjustedViewHeight;
        adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(isScrollableForAccessibility());
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //final int convertedContentWidth = contentToViewX(getContentWidth());
        //final int adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        //event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        //final int convertedContentHeight = contentToViewY(getContentHeight());
        //final int adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        //event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "D292CBD7022DC4EBDB0DAC3AAAD2AB7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isScrollableForAccessibility() {
        boolean var2E51EF2A2B51F29427B40369CE73A1BE_1167395301 = ((contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                //|| contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "AE960D46E4E8F97AC8313B4EBCA4EC88")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOverScrollMode(int mode) {
        dsTaint.addTaint(mode);
        super.setOverScrollMode(mode);
        {
            {
                mOverScrollGlow = new OverScrollGlow(this);
            } //End block
        } //End block
        {
            mOverScrollGlow = null;
        } //End block
        // ---------- Original Method ----------
        //super.setOverScrollMode(mode);
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mOverScrollGlow == null) {
                //mOverScrollGlow = new OverScrollGlow(this);
            //}
        //} else {
            //mOverScrollGlow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "81D0D4CD95AA6CCC74E46171A031C3CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void adjustDefaultZoomDensity(int zoomDensity) {
        dsTaint.addTaint(zoomDensity);
        final float density;
        density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //final float density = mContext.getResources().getDisplayMetrics().density
                //* 100 / zoomDensity;
        //updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.320 -0400", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "7ADD18D814EDD3F0AF55F6E7E2157756")
    @DSModeled(DSC.SAFE)
     void updateDefaultZoomDensity(float density) {
        dsTaint.addTaint(density);
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //mNavSlop = (int) (16 * density);
        //mZoomManager.updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.321 -0400", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "B92DB916AD9B3DE784A733821EAEFAAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean onSavePassword(String schemePlusHost, String username,
            String password, final Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(username);
        dsTaint.addTaint(schemePlusHost);
        dsTaint.addTaint(resumeMsg.dsTaint);
        dsTaint.addTaint(password);
        boolean rVal;
        rVal = false;
        {
            mDatabase.setUsernamePassword(schemePlusHost, username, password);
        } //End block
        {
            final Message remember;
            remember = mPrivateHandler.obtainMessage(
                    REMEMBER_PASSWORD);
            remember.getData().putString("host", schemePlusHost);
            remember.getData().putString("username", username);
            remember.getData().putString("password", password);
            remember.obj = resumeMsg;
            final Message neverRemember;
            neverRemember = mPrivateHandler.obtainMessage(
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
            rVal = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.321 -0400", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "01FFFFED67C71647852EA57D580F8050")
    @DSModeled(DSC.SAFE)
    @Override
    public void setScrollBarStyle(int style) {
        dsTaint.addTaint(style);
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        } //End block
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        } //End block
        super.setScrollBarStyle(style);
        // ---------- Original Method ----------
        //if (style == View.SCROLLBARS_INSIDE_INSET
                //|| style == View.SCROLLBARS_OUTSIDE_INSET) {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        //} else {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        //}
        //super.setScrollBarStyle(style);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.321 -0400", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "6E890A970F339CA1D6FDF244B4866A4C")
    @DSModeled(DSC.SAFE)
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        dsTaint.addTaint(overlay);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayHorizontalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.321 -0400", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "BE94F88BFC94B1DDDB6FCC05EDDA17B7")
    @DSModeled(DSC.SAFE)
    public void setVerticalScrollbarOverlay(boolean overlay) {
        dsTaint.addTaint(overlay);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayVerticalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.321 -0400", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "4E18B97EFF94542E5F27EE367E47E36E")
    @DSModeled(DSC.SAFE)
    public boolean overlayHorizontalScrollbar() {
        checkThread();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayHorizontalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "55E906423BFA47B7CF2B04C28E764C4A")
    @DSModeled(DSC.SAFE)
    public boolean overlayVerticalScrollbar() {
        checkThread();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayVerticalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "249CE7D314C8087CC11ABDF240E9421E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewWidth() {
        {
            boolean var292598F3B8B58F58543813175CA4B8DD_1716403174 = (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar);
            {
                int var6198C346AE8689F1D3DC081BB775DCCC_1194317148 = (getWidth());
            } //End block
            {
                int var140744BAF485A6F88159B58920081848_497654983 = (Math.max(0, getWidth() - getVerticalScrollbarWidth()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar) {
            //return getWidth();
        //} else {
            //return Math.max(0, getWidth() - getVerticalScrollbarWidth());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "1A29CE5170E743ACDB50958EC521BEC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getTitleHeight() {
        {
            Object var89620761E813C776D9C3C42E19001F67_937879135 = (mTitleBar.getHeight());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTitleBar != null ? mTitleBar.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "DC993769F981678A37569873C520BF61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVisibleTitleHeight() {
        checkThread();
        int var723012357A221391980D0C0C10B6FF34_241866935 = (getVisibleTitleHeightImpl());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "F542DF45320E26B45895584CA4BDB200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getVisibleTitleHeightImpl() {
        int var92FBB9603EF7E293DE9CA0F22B9E46D3_1514538119 = (Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(getTitleHeight() - Math.max(0, mScrollY),
                //getOverlappingActionModeHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "6799823F65D90D823E7EDED935F9F104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOverlappingActionModeHeight() {
        {
            getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            mCachedOverlappingActionModeHeight = Math.max(0,
                    mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mFindCallback == null) {
            //return 0;
        //}
        //if (mCachedOverlappingActionModeHeight < 0) {
            //getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            //mCachedOverlappingActionModeHeight = Math.max(0,
                    //mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        //}
        //return mCachedOverlappingActionModeHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "43A8DEC3095B8FB9BFB83AE8D39E3868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewHeight() {
        int varD548A0758944BD119F0830EAB903948B_1725413488 = (getViewHeightWithTitle() - getVisibleTitleHeightImpl());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "44FE9628D71E42491C88C893A03ED396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewHeightWithTitle() {
        int height;
        height = getHeight();
        {
            boolean varEFFBBF75692B423920E06898DB33B47D_1598814374 = (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar);
            {
                height -= getHorizontalScrollbarHeight();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int height = getHeight();
        //if (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar) {
            //height -= getHorizontalScrollbarHeight();
        //}
        //return height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "013018462EBC984EF2216387192B0FB8")
    @DSModeled(DSC.SAFE)
    public SslCertificate getCertificate() {
        checkThread();
        return (SslCertificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "E8F480C8E7D7C9A4546576265B725BF7")
    @DSModeled(DSC.SAFE)
    public void setCertificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "setCertificate=" + certificate);
        //}
        //mCertificate = certificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "202719C90BD15643289A3FAA27F0EB9B")
    @DSModeled(DSC.SAFE)
    public void savePassword(String host, String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(host);
        dsTaint.addTaint(password);
        checkThread();
        mDatabase.setUsernamePassword(host, username, password);
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setUsernamePassword(host, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "0CEC023439156E44CA32F1DEE3DF4AB7")
    @DSModeled(DSC.SAFE)
    public void setHttpAuthUsernamePassword(String host, String realm,
            String username, String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(password);
        checkThread();
        mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.322 -0400", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "7E94BA6175615FD5888CA37F1E49CD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        checkThread();
        String[] var77CB03096BD32FC162AEEEDE53FE6C3E_603466038 = (mDatabase.getHttpAuthUsernamePassword(host, realm));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //checkThread();
        //return mDatabase.getHttpAuthUsernamePassword(host, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "9F064088841EBA7A9C2457D09AC7AA69")
    @DSModeled(DSC.SAFE)
    private void clearActionModes() {
        {
            mSelectCallback.finish();
        } //End block
        {
            mFindCallback.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectCallback != null) {
            //mSelectCallback.finish();
        //}
        //if (mFindCallback != null) {
            //mFindCallback.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "05FE27767F314C4F9DBC55FD721D6573")
    @DSModeled(DSC.SAFE)
    private void clearHelpers() {
        clearTextEntry();
        clearActionModes();
        dismissFullScreenMode();
        cancelSelectDialog();
        // ---------- Original Method ----------
        //clearTextEntry();
        //clearActionModes();
        //dismissFullScreenMode();
        //cancelSelectDialog();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "C0A1C23B6AD955FE5B579170EFDEED8E")
    @DSModeled(DSC.SAFE)
    private void cancelSelectDialog() {
        {
            mListBoxDialog.cancel();
            mListBoxDialog = null;
        } //End block
        // ---------- Original Method ----------
        //if (mListBoxDialog != null) {
            //mListBoxDialog.cancel();
            //mListBoxDialog = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "8590B89573355FFEF49D7EE746CACF7D")
    @DSModeled(DSC.SAFE)
    public void destroy() {
        checkThread();
        destroyImpl();
        // ---------- Original Method ----------
        //checkThread();
        //destroyImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "4A5BE0192312BB51E6FD13F48962875D")
    @DSModeled(DSC.SAFE)
    private void destroyImpl() {
        clearHelpers();
        {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        } //End block
        {
            mWebTextView.remove();
            mWebTextView = null;
        } //End block
        nativeStopGL();
        {
            mCallbackProxy.setWebViewClient(null);
            mCallbackProxy.setWebChromeClient(null);
            {
                WebViewCore webViewCore;
                webViewCore = mWebViewCore;
                mWebViewCore = null;
                webViewCore.destroy();
            } //End block
            mPrivateHandler.removeCallbacksAndMessages(null);
            mCallbackProxy.removeCallbacksAndMessages(null);
            {
                mCallbackProxy.notify();
            } //End block
        } //End block
        {
            nativeDestroy();
            mNativeClass = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "D90791382B998754300C46B222220008", hash_generated_method = "2493124BC7814D1E0DD5A823972892AE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "EDAF97142100A2828612566C3AE09FEC", hash_generated_method = "9182EE3245CCF64B9549F702F9A17C31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "095E88806A17400D15E741216ED81A88")
    @DSModeled(DSC.SAFE)
    public void setJsFlags(String flags) {
        dsTaint.addTaint(flags);
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "38D8CBE5ADCFBCFA7CE3D28C2CD7E046")
    @DSModeled(DSC.SAFE)
    public void setNetworkAvailable(boolean networkUp) {
        dsTaint.addTaint(networkUp);
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                networkUp ? 1 : 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                //networkUp ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "FEC3DE7B73FC2D8245B1C02B76AEFA72")
    @DSModeled(DSC.SAFE)
    public void setNetworkType(String type, String subtype) {
        dsTaint.addTaint(subtype);
        dsTaint.addTaint(type);
        checkThread();
        Map<String, String> map;
        map = new HashMap<String, String>();
        map.put("type", type);
        map.put("subtype", subtype);
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
        // ---------- Original Method ----------
        //checkThread();
        //Map<String, String> map = new HashMap<String, String>();
        //map.put("type", type);
        //map.put("subtype", subtype);
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.323 -0400", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "A2EEC0604DF54303CAF685391A2C626D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList saveState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        checkThread();
        WebBackForwardList list;
        list = copyBackForwardList();
        final int currentIndex;
        currentIndex = list.getCurrentIndex();
        final int size;
        size = list.getSize();
        outState.putInt("index", currentIndex);
        ArrayList<byte[]> history;
        history = new ArrayList<byte[]>(size);
        {
            int i;
            i = 0;
            {
                WebHistoryItem item;
                item = list.getItemAtIndex(i);
                byte[] data;
                data = item.getFlattenedData();
                history.add(data);
            } //End block
        } //End collapsed parenthetic
        outState.putSerializable("history", history);
        {
            outState.putBundle("certificate",
                               SslCertificate.saveState(mCertificate));
        } //End block
        outState.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(outState);
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.324 -0400", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "6C90910E2EAF83716C401A8ADF7BCEAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(b.dsTaint);
        checkThread();
        final Picture p;
        p = capturePicture();
        final File temp;
        temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {
            public void run() {
                FileOutputStream out = null;
                try {
                    out = new FileOutputStream(temp);
                    p.writeToStream(out);
                    temp.renameTo(dest);
                } catch (Exception e) {
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception e) {
                        }
                    }
                    temp.delete();
                }
            }
        }).start();
        b.putInt("scrollX", mScrollX);
        b.putInt("scrollY", mScrollY);
        mZoomManager.saveZoomState(b);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.324 -0400", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "1225CFC6CAEF25CC7BB9CACBC8F5752C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void restoreHistoryPictureFields(Picture p, Bundle b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        int sx;
        sx = b.getInt("scrollX", 0);
        int sy;
        sy = b.getInt("scrollY", 0);
        mDrawHistory = true;
        mScrollX = sx;
        mScrollY = sy;
        mZoomManager.restoreZoomState(b);
        final float scale;
        scale = mZoomManager.getScale();
        mHistoryWidth = Math.round(p.getWidth() * scale);
        mHistoryHeight = Math.round(p.getHeight() * scale);
        invalidate();
        // ---------- Original Method ----------
        //int sx = b.getInt("scrollX", 0);
        //int sy = b.getInt("scrollY", 0);
        //mDrawHistory = true;
        //mHistoryPicture = p;
        //mScrollX = sx;
        //mScrollY = sy;
        //mZoomManager.restoreZoomState(b);
        //final float scale = mZoomManager.getScale();
        //mHistoryWidth = Math.round(p.getWidth() * scale);
        //mHistoryHeight = Math.round(p.getHeight() * scale);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.324 -0400", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "88D6A14652EC549CB4212004C007DA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean restorePicture(Bundle b, File src) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        checkThread();
        {
            boolean varE83409CFB365F3AF171C437BEF6A7D4D_535270680 = (!src.exists());
        } //End collapsed parenthetic
        try 
        {
            final FileInputStream in;
            in = new FileInputStream(src);
            final Bundle copy;
            copy = new Bundle(b);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final Picture p = Picture.createFromStream(in);
                        if (p != null) {
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
                        }
                    }
                }
            }).start();
        } //End block
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "E19D7595FDA323E55500D6ABDFCD4569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean saveViewState(OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        try 
        {
            boolean varD8E0513B299C4708A843791F787A4612_172900602 = (ViewStateSerializer.serializeViewState(stream, this));
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ViewStateSerializer.serializeViewState(stream, this);
        //} catch (IOException e) {
            //Log.w(LOGTAG, "Failed to saveViewState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "7FA6243AB7375E0B80E4CCB02F36CF67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean loadViewState(InputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        try 
        {
            mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            mBlockWebkitViewMessages = true;
            setNewPicture(mLoadedPicture, true);
            mLoadedPicture.mViewState = null;
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            //mBlockWebkitViewMessages = true;
            //setNewPicture(mLoadedPicture, true);
            //mLoadedPicture.mViewState = null;
            //return true;
        //} catch (IOException e) {
            //Log.w(LOGTAG, "Failed to loadViewState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "76D8FACFDAEE5AB889C2F649C76D72CD")
    @DSModeled(DSC.SAFE)
    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
        // ---------- Original Method ----------
        //mBlockWebkitViewMessages = false;
        //mLoadedPicture = null;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "7592CD03E27724643B43D4FCB6CB9382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList restoreState(Bundle inState) {
        dsTaint.addTaint(inState.dsTaint);
        checkThread();
        WebBackForwardList returnList;
        returnList = null;
        {
            boolean var2DC9EFB7F916A118778C320ECAEAF366_256090421 = (inState.containsKey("index") && inState.containsKey("history"));
            {
                mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));
                final WebBackForwardList list;
                list = mCallbackProxy.getBackForwardList();
                final int index;
                index = inState.getInt("index");
                {
                    final List<byte[]> history;
                    history = (List<byte[]>) inState.getSerializable("history");
                    final int size;
                    size = history.size();
                    {
                        int i;
                        i = 0;
                        {
                            byte[] data;
                            data = history.remove(0);
                            WebHistoryItem item;
                            item = new WebHistoryItem(data);
                            list.addHistoryItem(item);
                        } //End block
                    } //End collapsed parenthetic
                    returnList = copyBackForwardList();
                    returnList.setCurrentIndex(index);
                } //End block
                {
                    boolean varA762F755263E0165E9C21EFA8E349BE2_1877476999 = (inState.getBoolean("privateBrowsingEnabled"));
                    {
                        getSettings().setPrivateBrowsingEnabled(true);
                    } //End block
                } //End collapsed parenthetic
                mZoomManager.restoreZoomState(inState);
                mWebViewCore.removeMessages();
                mWebViewCore.sendMessage(EventHub.RESTORE_STATE, index);
            } //End block
        } //End collapsed parenthetic
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "3EE92E6026541C12425E8DF1307CFFDB")
    @DSModeled(DSC.SAFE)
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        dsTaint.addTaint(additionalHttpHeaders.dsTaint);
        dsTaint.addTaint(url);
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url, additionalHttpHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "A6CE52543868AD5C8AF707AB61B61131")
    @DSModeled(DSC.SAFE)
    private void loadUrlImpl(String url, Map<String, String> extraHeaders) {
        dsTaint.addTaint(extraHeaders.dsTaint);
        dsTaint.addTaint(url);
        switchOutDrawHistory();
        WebViewCore.GetUrlData arg;
        arg = new WebViewCore.GetUrlData();
        arg.mUrl = url;
        arg.mExtraHeaders = extraHeaders;
        mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        clearHelpers();
        // ---------- Original Method ----------
        //switchOutDrawHistory();
        //WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        //arg.mUrl = url;
        //arg.mExtraHeaders = extraHeaders;
        //mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        //clearHelpers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "F7975741139CA29F200971E61858FAEB")
    @DSModeled(DSC.SAFE)
    public void loadUrl(String url) {
        dsTaint.addTaint(url);
        checkThread();
        loadUrlImpl(url);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.325 -0400", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "CD39A052C905B226F0101C5422DDEDA8")
    @DSModeled(DSC.SAFE)
    private void loadUrlImpl(String url) {
        dsTaint.addTaint(url);
        loadUrlImpl(url, null);
        // ---------- Original Method ----------
        //if (url == null) {
            //return;
        //}
        //loadUrlImpl(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "5724D232E6DCB3C298EF28337CB15E9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postUrl(String url, byte[] postData) {
        dsTaint.addTaint(postData);
        dsTaint.addTaint(url);
        checkThread();
        {
            boolean var4F95E4BDE23CE2774CDB1234D95999CA_2119236203 = (URLUtil.isNetworkUrl(url));
            {
                switchOutDrawHistory();
                WebViewCore.PostUrlData arg;
                arg = new WebViewCore.PostUrlData();
                arg.mUrl = url;
                arg.mPostData = postData;
                mWebViewCore.sendMessage(EventHub.POST_URL, arg);
                clearHelpers();
            } //End block
            {
                loadUrlImpl(url);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkThread();
        //if (URLUtil.isNetworkUrl(url)) {
            //switchOutDrawHistory();
            //WebViewCore.PostUrlData arg = new WebViewCore.PostUrlData();
            //arg.mUrl = url;
            //arg.mPostData = postData;
            //mWebViewCore.sendMessage(EventHub.POST_URL, arg);
            //clearHelpers();
        //} else {
            //loadUrlImpl(url);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "B0EB4FAAC5138B8D39B40048EEDD514E")
    @DSModeled(DSC.SAFE)
    public void loadData(String data, String mimeType, String encoding) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(mimeType);
        checkThread();
        loadDataImpl(data, mimeType, encoding);
        // ---------- Original Method ----------
        //checkThread();
        //loadDataImpl(data, mimeType, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "923D3630216BEF375D1BA083DAE5FC59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadDataImpl(String data, String mimeType, String encoding) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(mimeType);
        StringBuilder dataUrl;
        dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        {
            boolean var42C80751A5B21E94C93713173917F7B9_1959304717 = ("base64".equals(encoding));
            {
                dataUrl.append(";base64");
            } //End block
        } //End collapsed parenthetic
        dataUrl.append(",");
        dataUrl.append(data);
        loadUrlImpl(dataUrl.toString());
        // ---------- Original Method ----------
        //StringBuilder dataUrl = new StringBuilder("data:");
        //dataUrl.append(mimeType);
        //if ("base64".equals(encoding)) {
            //dataUrl.append(";base64");
        //}
        //dataUrl.append(",");
        //dataUrl.append(data);
        //loadUrlImpl(dataUrl.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "AC8A21DEF15B3A1851358072E5E984FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        dsTaint.addTaint(baseUrl);
        dsTaint.addTaint(historyUrl);
        dsTaint.addTaint(data);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(mimeType);
        checkThread();
        {
            boolean var66719BDAFAA36B530D74BC3839E26AEE_536069283 = (baseUrl != null && baseUrl.toLowerCase().startsWith("data:"));
            {
                loadDataImpl(data, mimeType, encoding);
            } //End block
        } //End collapsed parenthetic
        switchOutDrawHistory();
        WebViewCore.BaseUrlData arg;
        arg = new WebViewCore.BaseUrlData();
        arg.mBaseUrl = baseUrl;
        arg.mData = data;
        arg.mMimeType = mimeType;
        arg.mEncoding = encoding;
        arg.mHistoryUrl = historyUrl;
        mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        clearHelpers();
        // ---------- Original Method ----------
        //checkThread();
        //if (baseUrl != null && baseUrl.toLowerCase().startsWith("data:")) {
            //loadDataImpl(data, mimeType, encoding);
            //return;
        //}
        //switchOutDrawHistory();
        //WebViewCore.BaseUrlData arg = new WebViewCore.BaseUrlData();
        //arg.mBaseUrl = baseUrl;
        //arg.mData = data;
        //arg.mMimeType = mimeType;
        //arg.mEncoding = encoding;
        //arg.mHistoryUrl = historyUrl;
        //mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        //clearHelpers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "BF0ABF799F25E72ACC934A97BCAC377B")
    @DSModeled(DSC.SAFE)
    public void saveWebArchive(String filename) {
        dsTaint.addTaint(filename);
        checkThread();
        saveWebArchiveImpl(filename, false, null);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(filename, false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.326 -0400", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "185454647504414973E6959111E90F8B")
    @DSModeled(DSC.SAFE)
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(autoname);
        dsTaint.addTaint(callback.dsTaint);
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(basename, autoname, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "E05B7911E617CB6839BDA3C2A4DB8DF8")
    @DSModeled(DSC.SAFE)
    private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(autoname);
        dsTaint.addTaint(callback.dsTaint);
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            //new SaveWebArchiveMessage(basename, autoname, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "5EE136E2B8E0FCBE006D997F6DA8191B")
    @DSModeled(DSC.SAFE)
    public void stopLoading() {
        checkThread();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
        // ---------- Original Method ----------
        //checkThread();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.STOP_LOADING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "65B171884B51F0D9EDDD3DDA13FF25EA")
    @DSModeled(DSC.SAFE)
    public void reload() {
        checkThread();
        clearHelpers();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.RELOAD);
        // ---------- Original Method ----------
        //checkThread();
        //clearHelpers();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.RELOAD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "5FBDCAFDD3C83C4B1CA78C9E6F3C39A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoBack() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_793877165 = (l.getClearPending());
                {
                    boolean var206A5F4DC30C9911DE984FA8A632E8D0_1327244577 = (l.getCurrentIndex() > 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //return l.getCurrentIndex() > 0;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "2C3C2AA77EEDA81950AF754894DD203D")
    @DSModeled(DSC.SAFE)
    public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "854F0A60E8D14413C8CE5BBD69FCC718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoForward() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_470862127 = (l.getClearPending());
                {
                    boolean varCC6932F1C4388293E5C6020CC2BE99D1_1903855042 = (l.getCurrentIndex() < l.getSize() - 1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //return l.getCurrentIndex() < l.getSize() - 1;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "DD59604DD975CFAD3F411496BF7FC856")
    @DSModeled(DSC.SAFE)
    public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "8841BC87ED2558291E57FEC50677868C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoBackOrForward(int steps) {
        dsTaint.addTaint(steps);
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_112561059 = (l.getClearPending());
                {
                    int newIndex;
                    newIndex = l.getCurrentIndex() + steps;
                    boolean varC96153442818D1ECADD5777B6D61A76F_1125184177 = (newIndex >= 0 && newIndex < l.getSize());
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //int newIndex = l.getCurrentIndex() + steps;
                //return newIndex >= 0 && newIndex < l.getSize();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "C43C817820649912F82C3FEE666A275E")
    @DSModeled(DSC.SAFE)
    public void goBackOrForward(int steps) {
        dsTaint.addTaint(steps);
        checkThread();
        goBackOrForwardImpl(steps);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(steps);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "DC4601E4C62718DD63A3E424B8C04DC3")
    @DSModeled(DSC.SAFE)
    private void goBackOrForwardImpl(int steps) {
        dsTaint.addTaint(steps);
        goBackOrForward(steps, false);
        // ---------- Original Method ----------
        //goBackOrForward(steps, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "EAC8876ACC89D40240DC296D9D86F9C3")
    @DSModeled(DSC.SAFE)
    private void goBackOrForward(int steps, boolean ignoreSnapshot) {
        dsTaint.addTaint(ignoreSnapshot);
        dsTaint.addTaint(steps);
        {
            clearHelpers();
            mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    ignoreSnapshot ? 1 : 0);
        } //End block
        // ---------- Original Method ----------
        //if (steps != 0) {
            //clearHelpers();
            //mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    //ignoreSnapshot ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "678B19232BFAE34B78BCFE7668F8C5CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        boolean varB1BAC2416E34E6087A203AED7444A817_330405469 = (getSettings().isPrivateBrowsingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return getSettings().isPrivateBrowsingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.327 -0400", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "04CD1322005CA8D19E7E611DA641DE71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
        // ---------- Original Method ----------
        //getSettings().setPrivateBrowsingEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "7272F99E35CA24E9E37C53D091420AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean extendScroll(int y) {
        dsTaint.addTaint(y);
        int finalY;
        finalY = mScroller.getFinalY();
        int newY;
        newY = pinLocY(finalY + y);
        mScroller.setFinalY(newY);
        mScroller.extendDuration(computeDuration(0, y));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int finalY = mScroller.getFinalY();
        //int newY = pinLocY(finalY + y);
        //if (newY == finalY) return false;
        //mScroller.setFinalY(newY);
        //mScroller.extendDuration(computeDuration(0, y));
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "F921ABA44FEED77A41E5D862FE8F9C11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageUp(boolean top) {
        dsTaint.addTaint(top);
        checkThread();
        nativeClearCursor();
        {
            boolean varEC29A5852D76967DDCD92AF6EF13DA1B_1781826855 = (pinScrollTo(mScrollX, 0, true, 0));
        } //End block
        int h;
        h = getHeight();
        int y;
        {
            y = -h + PAGE_SCROLL_OVERLAP;
        } //End block
        {
            y = -h / 2;
        } //End block
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_1053451763 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1040904505 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_1420000677 = (extendScroll(y));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) {
            //return false;
        //}
        //nativeClearCursor();
        //if (top) {
            //return pinScrollTo(mScrollX, 0, true, 0);
        //}
        //int h = getHeight();
        //int y;
        //if (h > 2 * PAGE_SCROLL_OVERLAP) {
            //y = -h + PAGE_SCROLL_OVERLAP;
        //} else {
            //y = -h / 2;
        //}
        //return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                //: extendScroll(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "A1BF0BBB8668C04D526AAA68D4BEC141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageDown(boolean bottom) {
        dsTaint.addTaint(bottom);
        checkThread();
        nativeClearCursor();
        {
            boolean var20824CBC7D9295AF4224D9CEA1714AF5_398553553 = (pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0));
        } //End block
        int h;
        h = getHeight();
        int y;
        {
            y = h - PAGE_SCROLL_OVERLAP;
        } //End block
        {
            y = h / 2;
        } //End block
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_1632994177 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1882938343 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_1979977807 = (extendScroll(y));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) {
            //return false;
        //}
        //nativeClearCursor();
        //if (bottom) {
            //return pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0);
        //}
        //int h = getHeight();
        //int y;
        //if (h > 2 * PAGE_SCROLL_OVERLAP) {
            //y = h - PAGE_SCROLL_OVERLAP;
        //} else {
            //y = h / 2;
        //}
        //return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                //: extendScroll(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "C5D24586F1E05E427674A864FC133492")
    @DSModeled(DSC.SAFE)
    public void clearView() {
        checkThread();
        mContentWidth = 0;
        mContentHeight = 0;
        setBaseLayer(0, null, false, false, false);
        mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        // ---------- Original Method ----------
        //checkThread();
        //mContentWidth = 0;
        //mContentHeight = 0;
        //setBaseLayer(0, null, false, false, false);
        //mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "826FF2D5D6A0414AF58C50427D984BED")
    @DSModeled(DSC.SAFE)
    public Picture capturePicture() {
        checkThread();
        Picture result;
        result = new Picture();
        nativeCopyBaseContentToPicture(result);
        return (Picture)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) return null;
        //Picture result = new Picture();
        //nativeCopyBaseContentToPicture(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "D16A7D8146A16AAFC79F021CFDE2F366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inEditingMode() {
        boolean var5AD34046046BD5597D48FAE1E55DF94F_1529122985 = (mWebTextView != null && mWebTextView.getParent() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWebTextView != null && mWebTextView.getParent() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "DF46B2E20DF844CE6C7C125292C0DDE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearTextEntry() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_953335991 = (inEditingMode());
            {
                mWebTextView.remove();
            } //End block
            {
                hideSoftKeyboard();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.remove();
        //} else {
            //hideSoftKeyboard();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "E3BB9BB55C90F6CBF5AA40FFC318DBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getScale() {
        checkThread();
        float var7BDB5950E779A8350C7AFF5485D9A1D9_403562199 = (mZoomManager.getScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "4EB4CD6E9D7CF6FB6893E6163E02864C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getTextHandleScale() {
        float density;
        density = mContext.getResources().getDisplayMetrics().density;
        float varE59D2240C31D06227A739295405DD61F_572582620 = (density / getScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float density = mContext.getResources().getDisplayMetrics().density;
        //return density / getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.328 -0400", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "515B20233DCF3E05B01B608371DEF057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getReadingLevelScale() {
        float var44DB53B9B3C50B031CB12B3205E80427_1791576022 = (mZoomManager.getReadingLevelScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getReadingLevelScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "D34FEBC327C428D49679E585E05C633C")
    @DSModeled(DSC.SAFE)
    public void setInitialScale(int scaleInPercent) {
        dsTaint.addTaint(scaleInPercent);
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
        // ---------- Original Method ----------
        //checkThread();
        //mZoomManager.setInitialScaleInPercent(scaleInPercent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "8A3B64C616D40199BB0CC1AE0590FFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeZoomPicker() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_2059902658 = (!getSettings().supportZoom());
        } //End collapsed parenthetic
        clearHelpers();
        mZoomManager.invokeZoomPicker();
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return;
        //}
        //clearHelpers();
        //mZoomManager.invokeZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "7BA7802E95EE377B9876A10B4BD2FBAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HitTestResult getHitTestResult() {
        checkThread();
        HitTestResult varE98E5DEF74229AC9890C6F5B28E1D7E9_430758927 = (hitTestResult(mInitialHitTestResult));
        return (HitTestResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return hitTestResult(mInitialHitTestResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "6439AACD6507710F2F0D5091834DD6CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HitTestResult hitTestResult(HitTestResult fallback) {
        dsTaint.addTaint(fallback.dsTaint);
        HitTestResult result;
        result = new HitTestResult();
        {
            boolean var5225ACD2E56334E54962D68427F36819_70743419 = (nativeHasCursorNode());
            {
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_1974257450 = (nativeCursorIsTextInput());
                    {
                        result.setType(HitTestResult.EDIT_TEXT_TYPE);
                    } //End block
                    {
                        String text;
                        text = nativeCursorText();
                        {
                            {
                                boolean varC002F8AFED7F549F33D23662D5EE005B_870466264 = (text.startsWith(SCHEME_TEL));
                                {
                                    result.setType(HitTestResult.PHONE_TYPE);
                                    result.setExtra(text.substring(SCHEME_TEL.length()));
                                } //End block
                                {
                                    boolean var8892C872AF1A0DE7CA908AB563D8630A_549801895 = (text.startsWith(SCHEME_MAILTO));
                                    {
                                        result.setType(HitTestResult.EMAIL_TYPE);
                                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                                    } //End block
                                    {
                                        boolean varC83048191C80A2E63B6D052EA1A2AF29_1263587768 = (text.startsWith(SCHEME_GEO));
                                        {
                                            result.setType(HitTestResult.GEO_TYPE);
                                            result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                                        } //End block
                                        {
                                            boolean var559FEC73A68A4A49F5AE8D79C0655989_548517254 = (nativeCursorIsAnchor());
                                            {
                                                result.setType(HitTestResult.SRC_ANCHOR_TYPE);
                                                result.setExtra(text);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                result = fallback;
            } //End block
        } //End collapsed parenthetic
        int type;
        type = result.getType();
        {
            int contentX;
            contentX = viewToContentX(mLastTouchX + mScrollX);
            int contentY;
            contentY = viewToContentY(mLastTouchY + mScrollY);
            String text;
            text = nativeImageURI(contentX, contentY);
            {
                result.setType(type == HitTestResult.UNKNOWN_TYPE ?
                        HitTestResult.IMAGE_TYPE :
                        HitTestResult.SRC_IMAGE_ANCHOR_TYPE);
                result.setExtra(text);
            } //End block
        } //End block
        return (HitTestResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "DE3B705CEFE9A95700E35DCFB3A4C97F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void domChangedFocus() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_283775678 = (inEditingMode());
            {
                mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.329 -0400", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "2F2E708BE1DA71FF3C3BC8F114298656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestFocusNodeHref(Message hrefMsg) {
        dsTaint.addTaint(hrefMsg.dsTaint);
        checkThread();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        {
            boolean var5225ACD2E56334E54962D68427F36819_597563322 = (nativeHasCursorNode());
            {
                Rect cursorBounds;
                cursorBounds = nativeGetCursorRingBounds();
                {
                    boolean var445EE3E02909E3AEE38EC98CDB8981EE_1242703701 = (!cursorBounds.contains(contentX, contentY));
                    {
                        int slop;
                        slop = viewToContentDimension(mNavSlop);
                        cursorBounds.inset(-slop, -slop);
                        {
                            boolean varADAA650ED0CC8F602CC684B55A8BD54B_1813274805 = (cursorBounds.contains(contentX, contentY));
                            {
                                contentX = (int) cursorBounds.centerX();
                                contentY = (int) cursorBounds.centerY();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                contentX, contentY, hrefMsg);
        // ---------- Original Method ----------
        //checkThread();
        //if (hrefMsg == null) {
            //return;
        //}
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //if (nativeHasCursorNode()) {
            //Rect cursorBounds = nativeGetCursorRingBounds();
            //if (!cursorBounds.contains(contentX, contentY)) {
                //int slop = viewToContentDimension(mNavSlop);
                //cursorBounds.inset(-slop, -slop);
                //if (cursorBounds.contains(contentX, contentY)) {
                    //contentX = (int) cursorBounds.centerX();
                    //contentY = (int) cursorBounds.centerY();
                //}
            //}
        //}
        //mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                //contentX, contentY, hrefMsg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "6DC7AB8C6A9634DD296D216ACBE24A6D")
    @DSModeled(DSC.SAFE)
    public void requestImageRef(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        checkThread();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        String ref;
        ref = nativeImageURI(contentX, contentY);
        Bundle data;
        data = msg.getData();
        data.putString("url", ref);
        msg.setData(data);
        msg.sendToTarget();
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //String ref = nativeImageURI(contentX, contentY);
        //Bundle data = msg.getData();
        //data.putString("url", ref);
        //msg.setData(data);
        //msg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "9B5A3D11C56688EF80D0415919DF486F", hash_generated_method = "E361E2DF5815A522DBD3C9232120604E")
    static int pinLoc(int x, int viewMax, int docMax) {
        if (docMax < viewMax) {   
            x = 0;
        } else if (x < 0) {
            x = 0;
        } else if (x + viewMax > docMax) {
            x = docMax - viewMax;
        }
        return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "16171DAC867BE4F7963B1999D54F82F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int pinLocX(int x) {
        dsTaint.addTaint(x);
        int var07118715F745D512C238AD2FEDFE6515_637086083 = (pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return x;
        //return pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "58FFDE4565572A2E5019CA44A77617FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int pinLocY(int y) {
        dsTaint.addTaint(y);
        int var2B535EA2474A113BEF6C4806B3E88FC9_1013976058 = (pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return y;
        //return pinLoc(y, getViewHeightWithTitle(),
                      //computeRealVerticalScrollRange() + getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "FA662AC241ADDCCDE9A7A70F4D77607B")
    @DSModeled(DSC.SAFE)
    public void setEmbeddedTitleBar(View v) {
        dsTaint.addTaint(v.dsTaint);
        {
            removeView(mTitleBar);
        } //End block
        {
            addView(v, new AbsoluteLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        } //End block
        // ---------- Original Method ----------
        //if (mTitleBar == v) return;
        //if (mTitleBar != null) {
            //removeView(mTitleBar);
        //}
        //if (null != v) {
            //addView(v, new AbsoluteLayout.LayoutParams(
                    //ViewGroup.LayoutParams.MATCH_PARENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        //}
        //mTitleBar = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "E646A2ED7045453A8DFD9741BC81986F")
    @DSModeled(DSC.SAFE)
    public void setTitleBarGravity(int gravity) {
        dsTaint.addTaint(gravity);
        invalidate();
        // ---------- Original Method ----------
        //mTitleGravity = gravity;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "ABE12560B23A75575B6CA41C9AAE6644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int viewToContentDimension(int d) {
        dsTaint.addTaint(d);
        int var6C6E42DD517C7D3B9A717F110B422373_1230122245 = (Math.round(d * mZoomManager.getInvScale()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "DF4436DC35E2F9C0975ABF476D4817F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int viewToContentX(int x) {
        dsTaint.addTaint(x);
        int var8DEE0558B14D500E1B85CE5222A73912_1573862413 = (viewToContentDimension(x));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return viewToContentDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "2A47E7495658C4BA27C4862174E3BCEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int viewToContentY(int y) {
        dsTaint.addTaint(y);
        int var7B97DA5C6E7937A4956BCED3C768F5E3_1787623012 = (viewToContentDimension(y - getTitleHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return viewToContentDimension(y - getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "C7BC78A5FB8A6AFDD4E4A7185979B277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float viewToContentXf(int x) {
        dsTaint.addTaint(x);
        float var8A8AB39BD9FBE3D7753B44FE92DB7211_1229200487 = (x * mZoomManager.getInvScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return x * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "66B846C7878C25648867C2B29815B822")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float viewToContentYf(int y) {
        dsTaint.addTaint(y);
        float var831D90CB537843A85A184EBC2C0DA386_360728629 = ((y - getTitleHeight()) * mZoomManager.getInvScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (y - getTitleHeight()) * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.330 -0400", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "D5D088E9CA482CAC14B1BBAF2B1F8EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewDimension(int d) {
        dsTaint.addTaint(d);
        int var330434C37CE0501EDFCFE74FEF711C69_871034543 = (Math.round(d * mZoomManager.getScale()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "B5AC99EEC215019B2A16F78C18905BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewX(int x) {
        dsTaint.addTaint(x);
        int var5F9CD9178F56CA92BE57B17CD7626740_241995119 = (contentToViewDimension(x));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentToViewDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "652D0C4120F775918CDBBAAA22B7633D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewY(int y) {
        dsTaint.addTaint(y);
        int varFF4BC4A064C1180EFE780BDD5AD7DDE0_365269625 = (contentToViewDimension(y) + getTitleHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentToViewDimension(y) + getTitleHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "58C7DF5D16FEF6F27BEEC4D983C4D5F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect contentToViewRect(Rect x) {
        dsTaint.addTaint(x.dsTaint);
        Rect var4B81D5DF5680451FFACD064B79463794_57538002 = (new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom)));
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        //contentToViewX(x.right), contentToViewY(x.bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "AF79EF8590C9D03ABEE0813CCFE53912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewInvalidate(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        final float scale;
        scale = mZoomManager.getScale();
        final int dy;
        dy = getTitleHeight();
        invalidate((int)Math.floor(l * scale),
                   (int)Math.floor(t * scale) + dy,
                   (int)Math.ceil(r * scale),
                   (int)Math.ceil(b * scale) + dy);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //invalidate((int)Math.floor(l * scale),
                   //(int)Math.floor(t * scale) + dy,
                   //(int)Math.ceil(r * scale),
                   //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "A4B7DBE5939CFC0C94D22AAB562EEBF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(delay);
        final float scale;
        scale = mZoomManager.getScale();
        final int dy;
        dy = getTitleHeight();
        postInvalidateDelayed(delay,
                              (int)Math.floor(l * scale),
                              (int)Math.floor(t * scale) + dy,
                              (int)Math.ceil(r * scale),
                              (int)Math.ceil(b * scale) + dy);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //postInvalidateDelayed(delay,
                              //(int)Math.floor(l * scale),
                              //(int)Math.floor(t * scale) + dy,
                              //(int)Math.ceil(r * scale),
                              //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "791F84DE764FC27720911C6770091DE8")
    @DSModeled(DSC.SAFE)
    private void invalidateContentRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        viewInvalidate(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //viewInvalidate(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "997E7E92C7FD63030C2C380C472B3AF3")
    @DSModeled(DSC.SAFE)
    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "44601A80339F01C24194EF10E51E3BAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordNewContentSize(int w, int h, boolean updateLayout) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(updateLayout);
        dsTaint.addTaint(h);
        {
            {
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_2113899904 = (!mScroller.isFinished());
                    {
                        mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                        mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        contentSizeChanged(updateLayout);
        // ---------- Original Method ----------
        //if ((w | h) == 0) {
            //return;
        //}
        //if (mContentWidth != w || mContentHeight != h) {
            //mContentWidth = w;
            //mContentHeight = h;
            //if (!mDrawHistory) {
                //updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                //if (!mScroller.isFinished()) {
                    //mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                    //mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                //}
            //}
        //}
        //contentSizeChanged(updateLayout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.331 -0400", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "8319B0021C857762373EA0595BB0340E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Rect sendOurVisibleRect() {
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_459131742 = (mZoomManager.isPreventingWebkitUpdates());
        } //End collapsed parenthetic
        calcOurContentVisibleRect(mVisibleRect);
        {
            boolean var00DE442F9F80E5CC469870BAE951674E_1535959921 = (!mVisibleRect.equals(mLastVisibleRectSent));
            {
                {
                    mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                    mWebViewCore.removeMessages(EventHub.SET_SCROLL_OFFSET);
                    mWebViewCore.sendMessage(EventHub.SET_SCROLL_OFFSET,
                        nativeMoveGeneration(), mSendScrollEvent ? 1 : 0, mScrollOffset);
                } //End block
                mLastVisibleRectSent.set(mVisibleRect);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3D2FB3EC4A2EF0714518F74D7378575D_1308306123 = (getGlobalVisibleRect(mGlobalVisibleRect)
                && !mGlobalVisibleRect.equals(mLastGlobalRect));
            {
                {
                    mWebViewCore.sendMessage(EventHub.SET_GLOBAL_BOUNDS, mGlobalVisibleRect);
                } //End block
                mLastGlobalRect.set(mGlobalVisibleRect);
            } //End block
        } //End collapsed parenthetic
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "10EC2A1DC96999DD138B5A79F0DB9147")
    @DSModeled(DSC.SAFE)
    private void calcOurVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
        // ---------- Original Method ----------
        //getGlobalVisibleRect(r, mGlobalVisibleOffset);
        //r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "8729D3736DE708ED791964F6CA05FAE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void calcOurContentVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        calcOurVisibleRect(r);
        r.left = viewToContentX(r.left);
        r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        r.right = viewToContentX(r.right);
        r.bottom = viewToContentY(r.bottom);
        // ---------- Original Method ----------
        //calcOurVisibleRect(r);
        //r.left = viewToContentX(r.left);
        //r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentX(r.right);
        //r.bottom = viewToContentY(r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "9B8EB420FE29EFE573AF50FC54C6C5D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void calcOurContentVisibleRectF(RectF r) {
        dsTaint.addTaint(r.dsTaint);
        calcOurVisibleRect(mContentVisibleRect);
        r.left = viewToContentXf(mContentVisibleRect.left);
        r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        r.right = viewToContentXf(mContentVisibleRect.right);
        r.bottom = viewToContentYf(mContentVisibleRect.bottom);
        // ---------- Original Method ----------
        //calcOurVisibleRect(mContentVisibleRect);
        //r.left = viewToContentXf(mContentVisibleRect.left);
        //r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentXf(mContentVisibleRect.right);
        //r.bottom = viewToContentYf(mContentVisibleRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "07480A155B24415A3104DFE20EF3B9B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean sendViewSizeZoom(boolean force) {
        dsTaint.addTaint(force);
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_1166651198 = (mZoomManager.isPreventingWebkitUpdates());
        } //End collapsed parenthetic
        int viewWidth;
        viewWidth = getViewWidth();
        int newWidth;
        newWidth = Math.round(viewWidth * mZoomManager.getInvScale());
        int viewHeight;
        viewHeight = getViewHeightWithTitle() - getTitleHeight();
        int newHeight;
        newHeight = Math.round(viewHeight * mZoomManager.getInvScale());
        float heightWidthRatio;
        heightWidthRatio = (float) viewHeight / viewWidth;
        {
            newHeight = 0;
            heightWidthRatio = 0;
        } //End block
        int actualViewHeight;
        actualViewHeight = Math.round(getViewHeight() * mZoomManager.getInvScale());
        {
            ViewSizeData data;
            data = new ViewSizeData();
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
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "09CFAECDD8AADB02591FECF8639BF64F")
    @DSModeled(DSC.SAFE)
     void updateDoubleTapZoom(int doubleTapZoom) {
        dsTaint.addTaint(doubleTapZoom);
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
        // ---------- Original Method ----------
        //mZoomManager.updateDoubleTapZoom(doubleTapZoom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "E22ADD8A3880248D5881E0E4CA81EF1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeRealHorizontalScrollRange() {
        {
            int varFC9DBABA45B6BB7366F73B80D989E991_1485968570 = ((int) Math.floor(mContentWidth * mZoomManager.getScale()));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryWidth;
        //} else {
            //return (int) Math.floor(mContentWidth * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "C80E6CE105807703EEEC056362DAB1FE")
    @DSModeled(DSC.SAFE)
    @Override
    protected int computeHorizontalScrollRange() {
        int range;
        range = computeRealHorizontalScrollRange();
        final int scrollX;
        scrollX = mScrollX;
        final int overscrollRight;
        overscrollRight = computeMaxScrollX();
        {
            range -= scrollX;
        } //End block
        {
            range += scrollX - overscrollRight;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int range = computeRealHorizontalScrollRange();
        //final int scrollX = mScrollX;
        //final int overscrollRight = computeMaxScrollX();
        //if (scrollX < 0) {
            //range -= scrollX;
        //} else if (scrollX > overscrollRight) {
            //range += scrollX - overscrollRight;
        //}
        //return range;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "7CCD079B3BAC204A41B47A5D15BA9E96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollOffset() {
        int var39399E7590852488423D31BF8E113523_1007731056 = (Math.max(mScrollX, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollX, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.332 -0400", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "C9CD459851C1B9D5E2F8D78F94A77FFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeRealVerticalScrollRange() {
        {
            int var6B23C2077842EB549029F0B0D2DC4BA6_175608560 = ((int) Math.floor(mContentHeight * mZoomManager.getScale()));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryHeight;
        //} else {
            //return (int) Math.floor(mContentHeight * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "8BDDD8AF5FA37DA649E18946C9D0FF7D")
    @DSModeled(DSC.SAFE)
    @Override
    protected int computeVerticalScrollRange() {
        int range;
        range = computeRealVerticalScrollRange();
        final int scrollY;
        scrollY = mScrollY;
        final int overscrollBottom;
        overscrollBottom = computeMaxScrollY();
        {
            range -= scrollY;
        } //End block
        {
            range += scrollY - overscrollBottom;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int range = computeRealVerticalScrollRange();
        //final int scrollY = mScrollY;
        //final int overscrollBottom = computeMaxScrollY();
        //if (scrollY < 0) {
            //range -= scrollY;
        //} else if (scrollY > overscrollBottom) {
            //range += scrollY - overscrollBottom;
        //}
        //return range;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "613152EDF3EA6C671569113C9F9DBE6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollOffset() {
        int var34E847664C51512EE9641EF813607EB4_109073051 = (Math.max(mScrollY - getTitleHeight(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollY - getTitleHeight(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "20040BFE2D7CFA45A489856F3C6C773F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollExtent() {
        int varE85BFDDBDAAF56CEC1CA21E104DA822F_116875495 = (getViewHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getViewHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "37E8337CB2A6B305B52D973A4354E5DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDrawVerticalScrollBar(Canvas canvas,
                                           Drawable scrollBar,
                                           int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(l);
        dsTaint.addTaint(scrollBar.dsTaint);
        {
            t -= mScrollY;
        } //End block
        scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //if (mScrollY < 0) {
            //t -= mScrollY;
        //}
        //scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "19EDDFDE6A5CD744A7B10505E9EB3808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(scrollX);
        dsTaint.addTaint(clampedY);
        dsTaint.addTaint(clampedX);
        {
            scrollLayerTo(scrollX, scrollY);
        } //End block
        mInOverScrollMode = false;
        int maxX;
        maxX = computeMaxScrollX();
        int maxY;
        maxY = computeMaxScrollY();
        {
            scrollX = pinLocX(scrollX);
        } //End block
        {
            mInOverScrollMode = true;
        } //End block
        {
            mInOverScrollMode = true;
        } //End block
        int oldX;
        oldX = mScrollX;
        int oldY;
        oldY = mScrollY;
        super.scrollTo(scrollX, scrollY);
        {
            mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        } //End block
        // ---------- Original Method ----------
        //if (mTouchMode == TOUCH_DRAG_LAYER_MODE) {
            //scrollLayerTo(scrollX, scrollY);
            //return;
        //}
        //mInOverScrollMode = false;
        //int maxX = computeMaxScrollX();
        //int maxY = computeMaxScrollY();
        //if (maxX == 0) {
            //scrollX = pinLocX(scrollX);
        //} else if (scrollX < 0 || scrollX > maxX) {
            //mInOverScrollMode = true;
        //}
        //if (scrollY < 0 || scrollY > maxY) {
            //mInOverScrollMode = true;
        //}
        //int oldX = mScrollX;
        //int oldY = mScrollY;
        //super.scrollTo(scrollX, scrollY);
        //if (mOverScrollGlow != null) {
            //mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "1A679311A9A468963C8383919C72F3DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUrl() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object varBD02ED23F0746D6990A513108379DB42_596379697 = (h.getUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "EDC232F200D3BCC408172EED8A651293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginalUrl() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var5A176BD94397B5E17F627335178507C0_1755581313 = (h.getOriginalUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getOriginalUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "1BA1E58B35CB686C844EFAB5F86E8BC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTitle() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var79F60E007ABDDF3B8DDD796002584E77_1570528001 = (h.getTitle());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTitle() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.333 -0400", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "AAF6E1680A554034FE39596F8EBE7DA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFavicon() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var3761298654F94BE05D2E704C028E9FB9_416943520 = (h.getFavicon());
        } //End flattened ternary
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getFavicon() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "F386735ADCBA1431DA280A88416FB5C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTouchIconUrl() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var901B799FE33F4D9E3DB3E78A5B6E00DB_565943101 = (h.getTouchIconUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTouchIconUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "F985DC5E5BE84188C3B98662FEF1C1EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProgress() {
        checkThread();
        int var7E8F23F5531EF375BC02F70B93667140_849995690 = (mCallbackProxy.getProgress());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getProgress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "146FF842745E76426EC5721277B5AE03")
    @DSModeled(DSC.SAFE)
    public int getContentHeight() {
        checkThread();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "F53F6F17C99AED5D1CED4914128500F0")
    @DSModeled(DSC.SAFE)
    public int getContentWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "210CB3F41A65CEFDA7178F954EE3EAA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPageBackgroundColor() {
        int varDEEC2470ADDE0DE678B2B89837C36FF8_319525932 = (nativeGetBackgroundColor());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetBackgroundColor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "2F71CD421001B4E5FD9266FEDECD8277")
    @DSModeled(DSC.SAFE)
    public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "AC6E01CF95D81632B7E8DF18A51E2B48")
    @DSModeled(DSC.SAFE)
    public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "EB24DBC1B5D5428CA1D60354990412BA")
    @DSModeled(DSC.SAFE)
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
        {
            mIsPaused = true;
            mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            {
                mHTML5VideoViewProxy.pauseAndDispatch();
            } //End block
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            cancelSelectDialog();
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (!mIsPaused) {
            //mIsPaused = true;
            //mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            //if (mHTML5VideoViewProxy != null) {
                //mHTML5VideoViewProxy.pauseAndDispatch();
            //}
            //if (mNativeClass != 0) {
                //nativeSetPauseDrawing(mNativeClass, true);
            //}
            //cancelSelectDialog();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "B5D088DBAEC5D76191609C88165452A5")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        super.onWindowVisibilityChanged(visibility);
        updateDrawingState();
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //updateDrawingState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "3F9F99A0213882F4DBCB9C3D6A4676F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDrawingState() {
        {
            boolean var7C64E366ECC1C3C33738983696089D46_1627574729 = (getWindowVisibility() != VISIBLE);
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_711978325 = (getVisibility() != VISIBLE);
                {
                    nativeSetPauseDrawing(mNativeClass, true);
                } //End block
                {
                    nativeSetPauseDrawing(mNativeClass, false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mNativeClass == 0 || mIsPaused) return;
        //if (getWindowVisibility() != VISIBLE) {
            //nativeSetPauseDrawing(mNativeClass, true);
        //} else if (getVisibility() != VISIBLE) {
            //nativeSetPauseDrawing(mNativeClass, true);
        //} else {
            //nativeSetPauseDrawing(mNativeClass, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "4B77B200DB0FA4A401BB32C0142017E2")
    @DSModeled(DSC.SAFE)
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
        {
            mIsPaused = false;
            mWebViewCore.sendMessage(EventHub.ON_RESUME);
            {
                nativeSetPauseDrawing(mNativeClass, false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mIsPaused) {
            //mIsPaused = false;
            //mWebViewCore.sendMessage(EventHub.ON_RESUME);
            //if (mNativeClass != 0) {
                //nativeSetPauseDrawing(mNativeClass, false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "68B1A0FDA750DC2173B0F6BE4F28DD87")
    @DSModeled(DSC.SAFE)
    public boolean isPaused() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPaused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "B13DACD8707C857D1CB36D421B58610B")
    @DSModeled(DSC.SAFE)
    public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "7D3E9AF532D23BF3BE04C8963846C0DD")
    @DSModeled(DSC.SAFE)
    public void clearCache(boolean includeDiskFiles) {
        dsTaint.addTaint(includeDiskFiles);
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                includeDiskFiles ? 1 : 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                //includeDiskFiles ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.334 -0400", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "2C148B3E984235563D296B49173F5BCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearFormData() {
        checkThread();
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_722259492 = (inEditingMode());
            {
                mWebTextView.setAdapterCustom(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkThread();
        //if (inEditingMode()) {
            //mWebTextView.setAdapterCustom(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "B9E0996F745288A38F99BCA71255A3B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearHistory() {
        checkThread();
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.getBackForwardList().setClearPending();
        //mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "C2025E7B9BBADDB775BA421298378C43")
    @DSModeled(DSC.SAFE)
    public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "1E32431964C88EDD47364CC75A3B6B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList copyBackForwardList() {
        checkThread();
        WebBackForwardList var5EAE26242306E3C727AA5461B299ADAF_1885309425 = (mCallbackProxy.getBackForwardList().clone());
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getBackForwardList().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "D78E6B615C55C8DAC33CF3C7AE905786")
    @DSModeled(DSC.SAFE)
    public void findNext(boolean forward) {
        dsTaint.addTaint(forward);
        checkThread();
        nativeFindNext(forward);
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //nativeFindNext(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "38F75BD0011DC94A9F8AE1526DCD45F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findAll(String find) {
        dsTaint.addTaint(find);
        checkThread();
        int result;
        result = nativeFindAll(find.toLowerCase(),
                find.toUpperCase(), find.equalsIgnoreCase(mLastFind));
        result = 0;
        invalidate();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return 0;
        //int result = find != null ? nativeFindAll(find.toLowerCase(),
                //find.toUpperCase(), find.equalsIgnoreCase(mLastFind)) : 0;
        //invalidate();
        //mLastFind = find;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "94C529E0CD066D99ADB6103D38A02EFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showFindDialog(String text, boolean showIme) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(showIme);
        checkThread();
        FindActionModeCallback callback;
        callback = new FindActionModeCallback(mContext);
        {
            boolean varD263546D355C6FB3DF70E9DF8F0F7FDE_1083419547 = (getParent() == null || startActionMode(callback) == null);
        } //End collapsed parenthetic
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = callback;
        setFindIsUp(true);
        mFindCallback.setWebView(this);
        {
            mFindCallback.showSoftInput();
        } //End block
        {
            mFindCallback.setText(text);
            mFindCallback.findAll();
        } //End block
        {
            text = mLastFind;
        } //End block
        {
            mFindCallback.setText(text);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //FindActionModeCallback callback = new FindActionModeCallback(mContext);
        //if (getParent() == null || startActionMode(callback) == null) {
            //return false;
        //}
        //mCachedOverlappingActionModeHeight = -1;
        //mFindCallback = callback;
        //setFindIsUp(true);
        //mFindCallback.setWebView(this);
        //if (showIme) {
            //mFindCallback.showSoftInput();
        //} else if (text != null) {
            //mFindCallback.setText(text);
            //mFindCallback.findAll();
            //return true;
        //}
        //if (text == null) {
            //text = mLastFind;
        //}
        //if (text != null) {
            //mFindCallback.setText(text);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "FCFF44AF811729E1FE33F029DF49B6FC")
    @DSModeled(DSC.SAFE)
    private void setFindIsUp(boolean isUp) {
        dsTaint.addTaint(isUp);
        nativeSetFindIsUp(isUp);
        // ---------- Original Method ----------
        //mFindIsUp = isUp;
        //if (0 == mNativeClass) return;
        //nativeSetFindIsUp(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "2F77CF93349DC661F2FEF700C852E5B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int findIndex() {
        int var790C769C9D30EC8562E6C6B0E7276107_845979876 = (nativeFindIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (0 == mNativeClass) return -1;
        //return nativeFindIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "4708F5F42FC70D135A9D2E41E9763CDD", hash_generated_method = "50EEB8028068C97BB9C81E4800D50473")
    public static String findAddress(String addr) {
        checkThread();
        return findAddress(addr, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.335 -0400", hash_original_method = "2B68EFBFE26D95B828D150F41B7C4652", hash_generated_method = "D1AAE93FFF1895592B5055D3FCA0C726")
    public static String findAddress(String addr, boolean caseInsensitive) {
        return WebViewCore.nativeFindAddress(addr, caseInsensitive);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "EB90C4FC8A42139D94D04C8F79058CE2")
    @DSModeled(DSC.SAFE)
    public void clearMatches() {
        checkThread();
        nativeSetFindIsEmpty();
        invalidate();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0)
            //return;
        //nativeSetFindIsEmpty();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "EBA9B11CE9FECFDDC4CEC0EFAFB92B63")
    @DSModeled(DSC.SAFE)
     void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
        clearMatches();
        setFindIsUp(false);
        pinScrollTo(mScrollX, mScrollY, false, 0);
        invalidate();
        // ---------- Original Method ----------
        //mFindCallback = null;
        //mCachedOverlappingActionModeHeight = -1;
        //if (mWebViewCore == null) {
            //return;
        //}
        //clearMatches();
        //setFindIsUp(false);
        //pinScrollTo(mScrollX, mScrollY, false, 0);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "535D1819D90C23A1E9D9C876429CBC83")
    @DSModeled(DSC.SAFE)
    public void documentHasImages(Message response) {
        dsTaint.addTaint(response.dsTaint);
        checkThread();
        mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
        // ---------- Original Method ----------
        //checkThread();
        //if (response == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "066A957AA02F43498EE4559492203F3A")
    @DSModeled(DSC.SAFE)
    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.forceFinished(true);
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "49C04EE7D01CDFEAE39657B0BE16A0EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_2117235003 = (mScroller.computeScrollOffset());
            {
                int oldX;
                oldX = mScrollX;
                int oldY;
                oldY = mScrollY;
                int x;
                x = mScroller.getCurrX();
                int y;
                y = mScroller.getCurrY();
                invalidate();
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_1120604215 = (!mScroller.isFinished());
                    {
                        int rangeX;
                        rangeX = computeMaxScrollX();
                        int rangeY;
                        rangeY = computeMaxScrollY();
                        int overflingDistance;
                        overflingDistance = mOverflingDistance;
                        {
                            oldX = mScrollingLayerRect.left;
                            oldY = mScrollingLayerRect.top;
                            rangeX = mScrollingLayerRect.right;
                            rangeY = mScrollingLayerRect.bottom;
                            overflingDistance = 0;
                        } //End block
                        overScrollBy(x - oldX, y - oldY, oldX, oldY,
                        rangeX, rangeY,
                        overflingDistance, overflingDistance, false);
                        {
                            mOverScrollGlow.absorbGlow(x, y, oldX, oldY, rangeX, rangeY);
                        } //End block
                    } //End block
                    {
                        {
                            mScrollX = x;
                            mScrollY = y;
                        } //End block
                        {
                            scrollLayerTo(x, y);
                        } //End block
                        abortAnimation();
                        nativeSetIsScrolling(false);
                        {
                            WebViewCore.resumePriority();
                            {
                                WebViewCore.resumeUpdatePicture(mWebViewCore);
                            } //End block
                        } //End block
                        {
                            sendOurVisibleRect();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                super.computeScroll();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "678A07288751263D8B343DC87AA0D6BC")
    @DSModeled(DSC.SAFE)
    private void scrollLayerTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        mScrollingLayerRect.left = x;
        mScrollingLayerRect.top = y;
        onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        invalidate();
        // ---------- Original Method ----------
        //if (x == mScrollingLayerRect.left && y == mScrollingLayerRect.top) {
            //return;
        //}
        //nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        //mScrollingLayerRect.left = x;
        //mScrollingLayerRect.top = y;
        //onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "6411BF62B571DFB81CA7A8EE4DFAA604", hash_generated_method = "EA6F917BB7DA2CCB33B3F202E2BDAD62")
    private static int computeDuration(int dx, int dy) {
        int distance = Math.max(Math.abs(dx), Math.abs(dy));
        int duration = distance * 1000 / STD_SPEED;
        return Math.min(duration, MAX_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.336 -0400", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "3E61D80EFD75ECFC956BA078F5CEECC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(animationDuration);
        boolean varDDCD3B201102A2B6BF7DF6BB672D50B5_294573340 = (pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "F3946855AEE64D19121C36DAA10C60C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean pinScrollTo(int x, int y, boolean animate, int animationDuration) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(animationDuration);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        x = pinLocX(x);
        y = pinLocY(y);
        int dx;
        dx = x - mScrollX;
        int dy;
        dy = y - mScrollY;
        abortAnimation();
        {
            mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            awakenScrollBars(mScroller.getDuration());
            invalidate();
        } //End block
        {
            scrollTo(x, y);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //x = pinLocX(x);
        //y = pinLocY(y);
        //int dx = x - mScrollX;
        //int dy = y - mScrollY;
        //if ((dx | dy) == 0) {
            //return false;
        //}
        //abortAnimation();
        //if (animate) {
            //mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    //animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            //awakenScrollBars(mScroller.getDuration());
            //invalidate();
        //} else {
            //scrollTo(x, y);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "5297D8E27F3DD95AF3FFB9446D198E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setContentScrollBy(int cx, int cy, boolean animate) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        cx = contentToViewDimension(cx);
        cy = contentToViewDimension(cy);
        {
            {
                Rect tempRect;
                tempRect = new Rect();
                calcOurVisibleRect(tempRect);
                tempRect.offset(cx, cy);
                requestRectangleOnScreen(tempRect);
            } //End block
            boolean var3FCDFFB9E4E3AC0EFF489E7F0EAB193B_2033639836 = (cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0));
        } //End block
        {
            boolean var29BB42B254A3ABD17ABD36618645F129_910289361 = (pinScrollBy(cx, cy, animate, 0));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return false;
        //}
        //cx = contentToViewDimension(cx);
        //cy = contentToViewDimension(cy);
        //if (mHeightCanMeasure) {
            //if (cy != 0) {
                //Rect tempRect = new Rect();
                //calcOurVisibleRect(tempRect);
                //tempRect.offset(cx, cy);
                //requestRectangleOnScreen(tempRect);
            //}
            //return cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0);
        //} else {
            //return pinScrollBy(cx, cy, animate, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "F3530E7937CC61C483D80094902CAA2B")
    @DSModeled(DSC.SAFE)
     void onPageStarted(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        setCertificate(null);
        mAccessibilityScriptInjected = false;
        // ---------- Original Method ----------
        //setCertificate(null);
        //mAccessibilityScriptInjected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "ABF98FB645740AE409F5206A9A7F1FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        {
            {
                boolean varE94AF5A5E140E4B674F99180E2533924_410903128 = (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    && mScrollX == 0 && mScrollY == 0);
                {
                    pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        SLIDE_TITLE_DURATION);
                } //End block
            } //End collapsed parenthetic
            mPageThatNeedsToSlideTitleBarOffScreen = null;
        } //End block
        mZoomManager.onPageFinished(url);
        injectAccessibilityForUrl(url);
        // ---------- Original Method ----------
        //if (mPageThatNeedsToSlideTitleBarOffScreen != null) {
            //if (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    //&& mScrollX == 0 && mScrollY == 0) {
                //pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        //SLIDE_TITLE_DURATION);
            //}
            //mPageThatNeedsToSlideTitleBarOffScreen = null;
        //}
        //mZoomManager.onPageFinished(url);
        //injectAccessibilityForUrl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "BCCBF6CE58253467DF3EA143FEFF6150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void injectAccessibilityForUrl(String url) {
        dsTaint.addTaint(url);
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(mContext);
        {
            boolean var2F55789C2BAEC4B54A3769DF00E1201A_1209588948 = (!accessibilityManager.isEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var257A8D7DF44254A8F3AFFC587333D831_324209776 = (!getSettings().getJavaScriptEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } //End block
        } //End collapsed parenthetic
        int axsParameterValue;
        axsParameterValue = getAxsUrlParameterValue(url);
        {
            boolean onDeviceScriptInjectionEnabled;
            onDeviceScriptInjectionEnabled = (Settings.Secure.getInt(mContext
                    .getContentResolver(), Settings.Secure.ACCESSIBILITY_SCRIPT_INJECTION, 0) == 1);
            {
                ensureAccessibilityScriptInjectorInstance(false);
                loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
                mAccessibilityScriptInjected = true;
            } //End block
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } //End block
        } //End block
        {
            ensureAccessibilityScriptInjectorInstance(true);
        } //End block
        {
            ensureAccessibilityScriptInjectorInstance(false);
            loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "11CFB9B54AE3740C41A42EAF5663AE1D")
    @DSModeled(DSC.SAFE)
    private void ensureAccessibilityScriptInjectorInstance(boolean present) {
        dsTaint.addTaint(present);
        {
            {
                mAccessibilityInjector = new AccessibilityInjector(this);
            } //End block
        } //End block
        {
            mAccessibilityInjector = null;
        } //End block
        // ---------- Original Method ----------
        //if (present) {
            //if (mAccessibilityInjector == null) {
                //mAccessibilityInjector = new AccessibilityInjector(this);
            //}
        //} else {
            //mAccessibilityInjector = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.337 -0400", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "A45790259707D5E8DFB2BC081E02953E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getAxsUrlParameterValue(String url) {
        dsTaint.addTaint(url);
        {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        } //End block
        Matcher matcher;
        matcher = mMatchAxsUrlParameterPattern.matcher(url);
        {
            boolean var0CA07C7E05B5FB943A39E313382D5DA2_366928513 = (matcher.find());
            {
                String keyValuePair;
                keyValuePair = url.substring(matcher.start(), matcher.end());
                int varB4575FE2088203A669F7AEBE1DD89AA0_874071240 = (Integer.parseInt(keyValuePair.split("=")[1]));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mMatchAxsUrlParameterPattern == null) {
            //mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        //}
        //Matcher matcher = mMatchAxsUrlParameterPattern.matcher(url);
        //if (matcher.find()) {
            //String keyValuePair = url.substring(matcher.start(), matcher.end());
            //return Integer.parseInt(keyValuePair.split("=")[1]);
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "DF2F83D232BE007898D2AF88B9E70FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setContentScrollTo(int cx, int cy) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        int vx;
        int vy;
        {
            vx = 0;
            vy = 0;
        } //End block
        {
            vx = contentToViewX(cx);
            vy = contentToViewY(cy);
        } //End block
        {
            {
                boolean varBB2C6738F4D3DE5D7DC74ECC3D92899E_1242299815 = (getProgress() < 100);
                {
                    mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                    mYDistanceToSlideTitleOffScreen = vy;
                } //End block
                {
                    pinScrollTo(vx, vy, true, SLIDE_TITLE_DURATION);
                } //End block
            } //End collapsed parenthetic
        } //End block
        pinScrollTo(vx, vy, false, 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "25C28827D103F3CD877957EA62F0D7DF")
    @DSModeled(DSC.SAFE)
    private void spawnContentScrollTo(int cx, int cy) {
        dsTaint.addTaint(cy);
        dsTaint.addTaint(cx);
        int vx;
        vx = contentToViewX(cx);
        int vy;
        vy = contentToViewY(cy);
        pinScrollTo(vx, vy, true, 0);
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return;
        //}
        //int vx = contentToViewX(cx);
        //int vy = contentToViewY(cy);
        //pinScrollTo(vx, vy, true, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "A26D5C5488AEEE6527FD0FC01C769DD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void contentSizeChanged(boolean updateLayout) {
        dsTaint.addTaint(updateLayout);
        {
            {
                boolean var687FC976609C320EB23E747E9ECBC12A_655592562 = (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout);
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7183AB9F5F71646AEDE7ABA21E1DCB83_1177956089 = (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    || updateLayout);
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sendViewSizeZoom(false);
        } //End block
        // ---------- Original Method ----------
        //if ((mContentWidth | mContentHeight) == 0) {
            //return;
        //}
        //if (mHeightCanMeasure) {
            //if (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    //|| updateLayout) {
                //requestLayout();
            //}
        //} else if (mWidthCanMeasure) {
            //if (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    //|| updateLayout) {
                //requestLayout();
            //}
        //} else {
            //sendViewSizeZoom(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "439C1E9495545050082549D9A516A31E")
    @DSModeled(DSC.SAFE)
    public void setWebViewClient(WebViewClient client) {
        dsTaint.addTaint(client.dsTaint);
        checkThread();
        mCallbackProxy.setWebViewClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebViewClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "75893F2CFD21525FFB8857449C28805D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebViewClient getWebViewClient() {
        WebViewClient var4EB37B5B1E9A652F49A924F7972773FB_1237536999 = (mCallbackProxy.getWebViewClient());
        return (WebViewClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebViewClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "7D71A8B87B846D35E5D8F23343418159")
    @DSModeled(DSC.SAFE)
    public void setDownloadListener(DownloadListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setDownloadListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "78274E2F3BF8D79D8229AEAA4824073F")
    @DSModeled(DSC.SAFE)
    public void setWebChromeClient(WebChromeClient client) {
        dsTaint.addTaint(client.dsTaint);
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebChromeClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "E6E54F9DC478F83DD14D846521253770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebChromeClient getWebChromeClient() {
        WebChromeClient var76EC2DAF7AECAA60F4515D73D7EEBA5F_2013896376 = (mCallbackProxy.getWebChromeClient());
        return (WebChromeClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebChromeClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "7369D261E0F22570043187C5182B5EBD")
    @DSModeled(DSC.SAFE)
    public void setWebBackForwardListClient(WebBackForwardListClient client) {
        dsTaint.addTaint(client.dsTaint);
        mCallbackProxy.setWebBackForwardListClient(client);
        // ---------- Original Method ----------
        //mCallbackProxy.setWebBackForwardListClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "67CE240B73523D100786AAF5E92D6410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient var7C2425DFE3987FE4C6879F9F99300C0B_1923813297 = (mCallbackProxy.getWebBackForwardListClient());
        return (WebBackForwardListClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebBackForwardListClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.338 -0400", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "D4066C5FBAD5EFA9BC22077F56C66F17")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setPictureListener(PictureListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mPictureListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "CDA3880DBAA9C3AD4FB252B11CE08CA3")
    @DSModeled(DSC.SAFE)
    public void externalRepresentation(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "DE38DDACFFCBAE80DA54AF16EE42F2EB")
    @DSModeled(DSC.SAFE)
    public void documentAsText(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "A28C9CEF24CB45AA1A392387E283B04B")
    @DSModeled(DSC.SAFE)
    public void addJavascriptInterface(Object obj, String interfaceName) {
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(obj.dsTaint);
        checkThread();
        WebViewCore.JSInterfaceData arg;
        arg = new WebViewCore.JSInterfaceData();
        arg.mObject = obj;
        arg.mInterfaceName = interfaceName;
        mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
        // ---------- Original Method ----------
        //checkThread();
        //if (obj == null) {
            //return;
        //}
        //WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
        //arg.mObject = obj;
        //arg.mInterfaceName = interfaceName;
        //mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "CAE50EF8C32AF12A4FC3F8C468F8AA82")
    @DSModeled(DSC.SAFE)
    public void removeJavascriptInterface(String interfaceName) {
        dsTaint.addTaint(interfaceName);
        checkThread();
        {
            WebViewCore.JSInterfaceData arg;
            arg = new WebViewCore.JSInterfaceData();
            arg.mInterfaceName = interfaceName;
            mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mWebViewCore != null) {
            //WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            //arg.mInterfaceName = interfaceName;
            //mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "2CA0989B6C30DD9BB627E644FFBD7FD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebSettings getSettings() {
        checkThread();
        {
            Object varA73F6C7E3AB8DC13A9EF0D8D99FBDC40_1560288802 = (mWebViewCore.getSettings());
        } //End flattened ternary
        return (WebSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "DCC8025B0D65015CFA8097991E635157", hash_generated_method = "1ADD4122EC3C36802F56A241F84FF6AC")
    @Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "C0F100A4BB4F3DC8D7D89BFD9C3ECF43")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        dsTaint.addTaint(reloadOpenPages);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "41EDF8C37F8CEE6EE34C77B51AEB7B00")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mPrivateHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        destroy();
                    }
                });
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mNativeClass != 0) {
                //mPrivateHandler.post(new Runnable() {
                    //@Override
                    //public void run() {
                        //destroy();
                    //}
                //});
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.339 -0400", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "AB2C798070503E0B660F7BA1FF067A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(drawingTime);
        {
            mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            int newTop;
            newTop = 0;
            {
                newTop = Math.min(0, mScrollY);
            } //End block
            {
                newTop = mScrollY;
            } //End block
            mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            mTitleBar.setTop(newTop);
        } //End block
        boolean var2713BACF81F43D1C388D129F1A927E0D_1432819126 = (super.drawChild(canvas, child, drawingTime));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (child == mTitleBar) {
            //mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            //int newTop = 0;
            //if (mTitleGravity == Gravity.NO_GRAVITY) {
                //newTop = Math.min(0, mScrollY);
            //} else if (mTitleGravity == Gravity.TOP) {
                //newTop = mScrollY;
            //}
            //mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            //mTitleBar.setTop(newTop);
        //}
        //return super.drawChild(canvas, child, drawingTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.340 -0400", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "E31FA2CCB6F41D9CA2507582DCD1007B")
    @DSModeled(DSC.SAFE)
    private void drawContent(Canvas canvas, boolean drawRings) {
        dsTaint.addTaint(drawRings);
        dsTaint.addTaint(canvas.dsTaint);
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
        // ---------- Original Method ----------
        //drawCoreAndCursorRing(canvas, mBackgroundColor,
                //mDrawCursorRing && drawRings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.340 -0400", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "0B9FD6DBE021C2240DF04C40297C2C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawOverScrollBackground(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            mOverScrollBackground = new Paint();
            Bitmap bm;
            bm = BitmapFactory.decodeResource(
                    mContext.getResources(),
                    com.android.internal.R.drawable.status_bar_background);
            mOverScrollBackground.setShader(new BitmapShader(bm,
                    Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            mOverScrollBorder = new Paint();
            mOverScrollBorder.setStyle(Paint.Style.STROKE);
            mOverScrollBorder.setStrokeWidth(0);
            mOverScrollBorder.setColor(0xffbbbbbb);
        } //End block
        int top;
        top = 0;
        int right;
        right = computeRealHorizontalScrollRange();
        int bottom;
        bottom = top + computeRealVerticalScrollRange();
        canvas.save();
        canvas.translate(mScrollX, mScrollY);
        canvas.clipRect(-mScrollX, top - mScrollY, right - mScrollX, bottom
                - mScrollY, Region.Op.DIFFERENCE);
        canvas.drawPaint(mOverScrollBackground);
        canvas.restore();
        canvas.drawRect(-1, top - 1, right, bottom, mOverScrollBorder);
        canvas.clipRect(0, top, right, bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.340 -0400", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "FC852613D5BD68DEEFF2E6719FDAB120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        {
            canvas.drawColor(mBackgroundColor);
        } //End block
        {
            canvas.drawColor(mBackgroundColor);
        } //End block
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_1874025872 = (canvas.isHardwareAccelerated());
            {
                {
                    mIncrementEGLContextHack = true;
                    EGL10 egl;
                    egl = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglDisplay;
                    eglDisplay = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    int[] version;
                    version = new int[2];
                    egl.eglInitialize(eglDisplay, version);
                } //End block
                mZoomManager.setHardwareAccelerated();
            } //End block
        } //End collapsed parenthetic
        int saveCount;
        saveCount = canvas.save();
        {
            boolean var4322EE85B805CBD21A094B57F62ADC23_1536085090 = (mInOverScrollMode && !getSettings()
                .getUseWebViewBackgroundForOverscrollBackground());
            {
                drawOverScrollBackground(canvas);
            } //End block
        } //End collapsed parenthetic
        {
            canvas.translate(0, getTitleHeight());
        } //End block
        boolean drawJavaRings;
        drawJavaRings = !mTouchHighlightRegion.isEmpty()
                && (mTouchMode == TOUCH_INIT_MODE
                || mTouchMode == TOUCH_SHORTPRESS_START_MODE
                || mTouchMode == TOUCH_SHORTPRESS_MODE
                || mTouchMode == TOUCH_DONE_MODE);
        boolean drawNativeRings;
        drawNativeRings = !drawJavaRings;
        {
            drawNativeRings = !drawJavaRings && !isInTouchMode();
        } //End block
        drawContent(canvas, drawNativeRings);
        canvas.restoreToCount(saveCount);
        {
            invalidate();
        } //End block
        mWebViewCore.signalRepaintDone();
        {
            boolean varEFDBDAC0A2DEB3E5103984743E3C9A57_2004580906 = (mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        {
            long delay;
            delay = System.currentTimeMillis() - mTouchHighlightRequested;
            {
                boolean varBCA1B79D766932AE90DE8B5336B437FC_1036158915 = (delay < ViewConfiguration.getTapTimeout());
                {
                    Rect r;
                    r = mTouchHighlightRegion.getBounds();
                    postInvalidateDelayed(delay, r.left, r.top, r.right, r.bottom);
                } //End block
                {
                    {
                        mTouchHightlightPaint = new Paint();
                        mTouchHightlightPaint.setColor(HIGHLIGHT_COLOR);
                    } //End block
                    RegionIterator iter;
                    iter = new RegionIterator(mTouchHighlightRegion);
                    Rect r;
                    r = new Rect();
                    {
                        boolean var777D1BAEECB4D7088A7F6E66A69B6796_34968164 = (iter.next(r));
                        {
                            canvas.drawRect(r, mTouchHightlightPaint);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7909E0FF363982F909528C78CCCF0F02_1757620228 = (getSettings().getNavDump());
                {
                    {
                        {
                            mTouchCrossHairColor = new Paint();
                            mTouchCrossHairColor.setColor(Color.RED);
                        } //End block
                        canvas.drawLine(mTouchHighlightX - mNavSlop,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    + mNavSlop + 1, mTouchHighlightY + mNavSlop
                                    + 1, mTouchCrossHairColor);
                        canvas.drawLine(mTouchHighlightX + mNavSlop + 1,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    - mNavSlop,
                            mTouchHighlightY + mNavSlop + 1,
                            mTouchCrossHairColor);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.340 -0400", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "114BBDE001784E9B3DF1C672CA284953")
    @DSModeled(DSC.SAFE)
    private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
        // ---------- Original Method ----------
        //mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        //mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        //setTouchHighlightRects(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "426AAF57AE6A109FBBB2A8683655E9F5")
    @DSModeled(DSC.SAFE)
    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        dsTaint.addTaint(params.dsTaint);
        {
            mWrapContent = true;
        } //End block
        super.setLayoutParams(params);
        // ---------- Original Method ----------
        //if (params.height == LayoutParams.WRAP_CONTENT) {
            //mWrapContent = true;
        //}
        //super.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "2522BDC5A0247F7D97906E5A25ED7A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performLongClick() {
        {
            boolean var88AD79EA276C28AD3B3469360BCE1788_241202136 = (getParent() == null);
        } //End collapsed parenthetic
        final ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        {
            boolean var13D92B99C938B0F2FF8CCF00F803E8A6_2134052239 = (detector != null && detector.isInProgress());
        } //End collapsed parenthetic
        {
            boolean var780C0185A33DB3757005E772477A414D_911908126 = (mNativeClass != 0 && nativeCursorIsTextInput());
            {
                centerKeyPressOnTextField();
                rebuildWebTextView();
            } //End block
            {
                clearTextEntry();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_989597549 = (inEditingMode());
            {
                mWebTextView.ensureLayout();
                AbsoluteLayout.LayoutParams params;
                params = (AbsoluteLayout.LayoutParams) mWebTextView.getLayoutParams();
                MotionEvent fake;
                fake = MotionEvent.obtain(mLastTouchTime,
                    mLastTouchTime, MotionEvent.ACTION_DOWN,
                    mLastTouchX - params.x + mScrollX,
                    mLastTouchY - params.y + mScrollY, 0);
                mWebTextView.dispatchTouchEvent(fake);
                boolean var8E1B4A2E9B8893A37E1A84490A65FC9A_1150453757 = (mWebTextView.performLongClick());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC298D59926924FB0808A70DC864C4372_1479707748 = (super.performLongClick());
        } //End collapsed parenthetic
        final boolean isSelecting;
        isSelecting = selectText();
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "6F8B790726EAED37AB3159021B6806D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean selectText() {
        int x;
        x = viewToContentX(mLastTouchX + mScrollX);
        int y;
        y = viewToContentY(mLastTouchY + mScrollY);
        boolean varB29E32086CAB7981D2C629145B25F904_1094271700 = (selectText(x, y));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int x = viewToContentX(mLastTouchX + mScrollX);
        //int y = viewToContentY(mLastTouchY + mScrollY);
        //return selectText(x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "EBD8B850788208672D7463F651295106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean selectText(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varC5ECEC29B03BE800BB553180A5BFDF02_895873933 = (!setUpSelect(true, x, y));
        } //End collapsed parenthetic
        nativeSetExtendSelection();
        mDrawSelectionPointer = false;
        mTouchMode = TOUCH_DRAG_MODE;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!setUpSelect(true, x, y)) {
            //return false;
        //}
        //nativeSetExtendSelection();
        //mDrawSelectionPointer = false;
        //mTouchMode = TOUCH_DRAG_MODE;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "3D12A59B513048D7FC39E6C46B5E76D7")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        mCachedOverlappingActionModeHeight = -1;
        {
            selectionDone();
        } //End block
        mOrientation = newConfig.orientation;
        {
            mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        } //End block
        // ---------- Original Method ----------
        //mCachedOverlappingActionModeHeight = -1;
        //if (mSelectingText && mOrientation != newConfig.orientation) {
            //selectionDone();
        //}
        //mOrientation = newConfig.orientation;
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "90AFA3A098F65DCA10E1E6C8FBC28431")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean didUpdateWebTextViewDimensions(int intersection) {
        dsTaint.addTaint(intersection);
        Rect contentBounds;
        contentBounds = nativeFocusCandidateNodeBounds();
        Rect vBox;
        vBox = contentToViewRect(contentBounds);
        Rect visibleRect;
        visibleRect = new Rect();
        calcOurVisibleRect(visibleRect);
        offsetByLayerScrollPosition(vBox);
        boolean onScreen;
        //Begin case FULLY_ON_SCREEN 
        onScreen = visibleRect.contains(vBox);
        //End case FULLY_ON_SCREEN 
        //Begin case INTERSECTS_SCREEN 
        onScreen = Rect.intersects(visibleRect, vBox);
        //End case INTERSECTS_SCREEN 
        //Begin case ANYWHERE 
        onScreen = true;
        //End case ANYWHERE 
        //Begin case default 
        //throw new AssertionError(
                        //"invalid parameter passed to didUpdateWebTextViewDimensions");
        //End case default 
        {
            mWebTextView.setRect(vBox.left, vBox.top, vBox.width(),
                    vBox.height());
            mWebTextView.updateTextSize();
            updateWebTextViewPadding();
        } //End block
        {
            mWebTextView.remove();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.341 -0400", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "49F91F8C2514E07C19A9DB18AC3D258F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void offsetByLayerScrollPosition(Rect box) {
        dsTaint.addTaint(box.dsTaint);
        {
            boolean var9CB7C6698CC8E4B39807B6B5CCF588EA_1732123545 = ((mCurrentScrollingLayerId != 0)
                && (mCurrentScrollingLayerId == nativeFocusCandidateLayerId()));
            {
                box.offsetTo(box.left - mScrollingLayerRect.left,
                    box.top - mScrollingLayerRect.top);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mCurrentScrollingLayerId != 0)
                //&& (mCurrentScrollingLayerId == nativeFocusCandidateLayerId())) {
            //box.offsetTo(box.left - mScrollingLayerRect.left,
                    //box.top - mScrollingLayerRect.top);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "FB54AC79B6C6D36FB12D91FFAE371AEE")
    @DSModeled(DSC.SAFE)
     void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        dsTaint.addTaint(layer);
        dsTaint.addTaint(showVisualIndicator);
        dsTaint.addTaint(isPictureAfterFirstLayout);
        dsTaint.addTaint(invalRegion.dsTaint);
        dsTaint.addTaint(registerPageSwapCallback);
        nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                isPictureAfterFirstLayout, registerPageSwapCallback);
        {
            mHTML5VideoViewProxy.setBaseLayer(layer);
        } //End block
        // ---------- Original Method ----------
        //if (mNativeClass == 0)
            //return;
        //nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                //isPictureAfterFirstLayout, registerPageSwapCallback);
        //if (mHTML5VideoViewProxy != null) {
            //mHTML5VideoViewProxy.setBaseLayer(layer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "932BABE35C6B978BDFB18508FE1143CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getBaseLayer() {
        int var56C10FDD99E0FDF412C413A619660025_485020784 = (nativeGetBaseLayer());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return 0;
        //}
        //return nativeGetBaseLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "583F27A1AD2C39A015BF0B839CC27C1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onZoomAnimationStart() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_846692572 = (inEditingMode());
            {
                mWebTextView.setVisibility(INVISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.setVisibility(INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "790872AE98F5AC973042CC6BDD699087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onZoomAnimationEnd() {
        {
            boolean var7CF3A0FDB7A5E846FB3F76D951F33983_1889306120 = (inEditingMode()
                && didUpdateWebTextViewDimensions(FULLY_ON_SCREEN));
            {
                mWebTextView.setVisibility(VISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& didUpdateWebTextViewDimensions(FULLY_ON_SCREEN)) {
            //mWebTextView.setVisibility(VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "4B9926E17BA58D8DF82118921C082D17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onFixedLengthZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //WebViewCore.pauseUpdatePicture(getWebViewCore());
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.342 -0400", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "382306844DCD09C6A50F0B599C118165")
    @DSModeled(DSC.SAFE)
     void onFixedLengthZoomAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            WebViewCore.resumeUpdatePicture(mWebViewCore);
        } //End block
        onZoomAnimationEnd();
        // ---------- Original Method ----------
        //if (!mBlockWebkitViewMessages && !mSelectingText) {
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
        //}
        //onZoomAnimationEnd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.343 -0400", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "EA30FAB0527223BDFEB16D71331CD59F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawCoreAndCursorRing(Canvas canvas, int color,
        boolean drawCursorRing) {
        dsTaint.addTaint(drawCursorRing);
        dsTaint.addTaint(color);
        dsTaint.addTaint(canvas.dsTaint);
        {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            canvas.drawPicture(mHistoryPicture);
        } //End block
        boolean animateZoom;
        animateZoom = mZoomManager.isFixedLengthAnimationInProgress();
        boolean animateScroll;
        animateScroll = ((!mScroller.isFinished()
                || mVelocityTracker != null)
                && (mTouchMode != TOUCH_DRAG_MODE ||
                mHeldMotionless != MOTIONLESS_TRUE))
                || mDeferTouchMode == TOUCH_DRAG_MODE;
        {
            {
                mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                mHeldMotionless = MOTIONLESS_FALSE;
            } //End block
            {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(DRAG_HELD_MOTIONLESS), MOTIONLESS_TIME);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                mHeldMotionless = MOTIONLESS_PENDING;
            } //End block
        } //End block
        int saveCount;
        saveCount = canvas.save();
        {
            mZoomManager.animateZoom(canvas);
        } //End block
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_595615170 = (!canvas.isHardwareAccelerated());
            {
                canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            } //End block
        } //End collapsed parenthetic
        boolean UIAnimationsRunning;
        UIAnimationsRunning = false;
        {
            boolean var438456B32769D6A7B316667DCB4406FE_1008833619 = (mNativeClass != 0 && !canvas.isHardwareAccelerated()
                && nativeEvaluateLayersAnimations(mNativeClass));
            {
                UIAnimationsRunning = true;
                mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
                invalidate();
            } //End block
        } //End collapsed parenthetic
        int extras;
        extras = DRAW_EXTRAS_NONE;
        {
            extras = DRAW_EXTRAS_FIND;
        } //End block
        {
            extras = DRAW_EXTRAS_SELECTION;
            nativeSetSelectionPointer(mNativeClass,
                    mDrawSelectionPointer,
                    mZoomManager.getInvScale(), mSelectX, mSelectY - getTitleHeight());
        } //End block
        {
            extras = DRAW_EXTRAS_CURSOR_RING;
        } //End block
        calcOurContentVisibleRectF(mVisibleContentRect);
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_177910294 = (canvas.isHardwareAccelerated());
            {
                Rect glRectViewport;
                glRectViewport = null;
                glRectViewport = mGLRectViewport;
                Rect viewRectViewport;
                viewRectViewport = null;
                viewRectViewport = mViewRectViewport;
                int functor;
                functor = nativeGetDrawGLFunction(mNativeClass, glRectViewport,
                    viewRectViewport, mVisibleContentRect, getScale(), extras);
                ((HardwareCanvas) canvas).callDrawGLFunction(functor);
                {
                    boolean varB9C4161DF2F7ECD45BDF12D53A873278_1090115613 = (mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled());
                    {
                        mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                        nativeUseHardwareAccelSkia(mHardwareAccelSkia);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                DrawFilter df;
                df = null;
                {
                    boolean varDFCE6862E0CA36047A4C3134A0AB6043_134968465 = (mZoomManager.isZoomAnimating() || UIAnimationsRunning);
                    {
                        df = mZoomFilter;
                    } //End block
                    {
                        df = mScrollFilter;
                    } //End block
                } //End collapsed parenthetic
                canvas.setDrawFilter(df);
                int content;
                content = nativeDraw(canvas, mVisibleContentRect, color,
                    extras, false);
                canvas.setDrawFilter(null);
                {
                    mWebViewCore.sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        canvas.restoreToCount(saveCount);
        {
            drawTextSelectionHandles(canvas);
        } //End block
        {
            {
                mTouchMode = TOUCH_SHORTPRESS_MODE;
            } //End block
        } //End block
        {
            mFocusSizeChanged = false;
            {
                boolean varF6566AA8A24398D5119084D846E17436_108329377 = (!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode());
                {
                    didUpdateWebTextViewDimensions(ANYWHERE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.343 -0400", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "1A7C2B393C99F0F4FE34082C4298006F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawTextSelectionHandles(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            mTextSelectionPaint = new Paint();
            mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        } //End block
        mTextSelectionRegion.setEmpty();
        nativeGetTextSelectionRegion(mNativeClass, mTextSelectionRegion);
        Rect r;
        r = new Rect();
        RegionIterator iter;
        iter = new RegionIterator(mTextSelectionRegion);
        Rect clip;
        clip = canvas.getClipBounds();
        {
            boolean varE3C5F3369D1CDF36597C49DAB102029E_1539039650 = (iter.next(r));
            {
                r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
                {
                    boolean var6DFFCCE966800787D5E5EFDDEDE35151_993317442 = (r.intersect(clip));
                    {
                        canvas.drawRect(r, mTextSelectionPaint);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mSelectHandleLeft = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_left);
        } //End block
        int[] handles;
        handles = new int[4];
        nativeGetSelectionHandles(mNativeClass, handles);
        int start_x;
        start_x = contentToViewDimension(handles[0]);
        int start_y;
        start_y = contentToViewDimension(handles[1]);
        int end_x;
        end_x = contentToViewDimension(handles[2]);
        int end_y;
        end_y = contentToViewDimension(handles[3]);
        start_x -= (mSelectHandleLeft.getIntrinsicWidth() * 3) / 4;
        mSelectHandleLeft.setBounds(start_x, start_y,
                start_x + mSelectHandleLeft.getIntrinsicWidth(),
                start_y + mSelectHandleLeft.getIntrinsicHeight());
        {
            mSelectHandleRight = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_right);
        } //End block
        end_x -= mSelectHandleRight.getIntrinsicWidth() / 4;
        mSelectHandleRight.setBounds(end_x, end_y,
                end_x + mSelectHandleRight.getIntrinsicWidth(),
                end_y + mSelectHandleRight.getIntrinsicHeight());
        {
            mSelectHandleLeft.setAlpha(125);
            mSelectHandleRight.setAlpha(125);
        } //End block
        mSelectHandleLeft.draw(canvas);
        mSelectHandleRight.draw(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.343 -0400", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "44C705990287716C7FDFF8929A593E13")
    @DSModeled(DSC.SAFE)
     boolean drawHistory() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDrawHistory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.343 -0400", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "0F84011347C9CB234F4B0986942926AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getHistoryPictureWidth() {
        {
            Object var5C92612DE9888EAC00CA7C21ECDC0B5E_675368426 = (mHistoryPicture.getWidth());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "74D18FD5133D411E6A8EAD823EED3DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void switchOutDrawHistory() {
        {
            boolean var4213A82FBAD6D3C76E09EE9714EFE36E_1694934165 = (mDrawHistory && (getProgress() == 100 || nativeHasContent()));
            {
                mDrawHistory = false;
                mHistoryPicture = null;
                invalidate();
                int oldScrollX;
                oldScrollX = mScrollX;
                int oldScrollY;
                oldScrollY = mScrollY;
                mScrollX = pinLocX(mScrollX);
                mScrollY = pinLocY(mScrollY);
                {
                    onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
                } //End block
                {
                    sendOurVisibleRect();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (null == mWebViewCore) return;
        //if (mDrawHistory && (getProgress() == 100 || nativeHasContent())) {
            //mDrawHistory = false;
            //mHistoryPicture = null;
            //invalidate();
            //int oldScrollX = mScrollX;
            //int oldScrollY = mScrollY;
            //mScrollX = pinLocX(mScrollX);
            //mScrollY = pinLocY(mScrollY);
            //if (oldScrollX != mScrollX || oldScrollY != mScrollY) {
                //onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
            //} else {
                //sendOurVisibleRect();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "3AA01DB0F437B5FC45A1FE5D538145F9")
    @DSModeled(DSC.SAFE)
     WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData result;
        result = cursorDataNoPosition();
        Point position;
        position = nativeCursorPosition();
        result.mX = position.x;
        result.mY = position.y;
        return (WebViewCore.CursorData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = cursorDataNoPosition();
        //Point position = nativeCursorPosition();
        //result.mX = position.x;
        //result.mY = position.y;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "80F0BEC48744A400F9013E1E4DC622A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WebViewCore.CursorData cursorDataNoPosition() {
        WebViewCore.CursorData result;
        result = new WebViewCore.CursorData();
        result.mMoveGeneration = nativeMoveGeneration();
        result.mFrame = nativeCursorFramePointer();
        return (WebViewCore.CursorData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = new WebViewCore.CursorData();
        //result.mMoveGeneration = nativeMoveGeneration();
        //result.mFrame = nativeCursorFramePointer();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "5EA721F658D66014E2D48E0F64ECBAF8")
    @DSModeled(DSC.SAFE)
     void deleteSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mTextGeneration++;
        WebViewCore.TextSelectionData data;
        data = new WebViewCore.TextSelectionData(start, end);
        mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                data);
        // ---------- Original Method ----------
        //mTextGeneration++;
        //WebViewCore.TextSelectionData data
                //= new WebViewCore.TextSelectionData(start, end);
        //mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                //data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "7E8F21068EB96953DE82FFE28E8A6A58")
    @DSModeled(DSC.SAFE)
     void setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "0001D3A7ED0973917E1FCF01B2921F72")
    @DSModeled(DSC.SAFE)
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        InputConnection connection;
        connection = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "C08490B3694BE1EDBBE2CCF38AE62044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void displaySoftKeyboard(boolean isTextView) {
        dsTaint.addTaint(isTextView);
        InputMethodManager imm;
        imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean zoom;
        zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        } //End block
        {
            rebuildWebTextView();
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_1268369786 = (inEditingMode());
                {
                    imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                    {
                        didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        imm.showSoftInput(this, 0);
        // ---------- Original Method ----------
        //InputMethodManager imm = (InputMethodManager)
                //getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //boolean zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        //if (zoom) {
            //mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            //mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        //}
        //if (isTextView) {
            //rebuildWebTextView();
            //if (inEditingMode()) {
                //imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                //if (zoom) {
                    //didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                //}
                //return;
            //}
        //}
        //imm.showSoftInput(this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.344 -0400", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "2E9F66F7379313985C182F41FABEC2E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void hideSoftKeyboard() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean var1C65995F61E387B4C34088A3BF18BF15_1496814236 = (imm != null && (imm.isActive(this)
                || (inEditingMode() && imm.isActive(mWebTextView))));
            {
                imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null && (imm.isActive(this)
                //|| (inEditingMode() && imm.isActive(mWebTextView)))) {
            //imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "F494D73B153F12C34129B40619B171D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rebuildWebTextView() {
        {
            boolean varD65E3F1F95872BCE9675FDBCB6E52A34_1791040179 = (!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus()));
        } //End collapsed parenthetic
        boolean alreadyThere;
        alreadyThere = inEditingMode();
        {
            boolean var7605F9B50D3E6B1FCD1B43262B1DB86A_1405345742 = (0 == mNativeClass || !nativeFocusCandidateIsTextInput());
            {
                {
                    mWebTextView.remove();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mWebTextView = new WebTextView(mContext, WebView.this, mAutoFillData.getQueryId());
            mTextGeneration = 0;
        } //End block
        mWebTextView.updateTextSize();
        updateWebTextViewPosition();
        String text;
        text = nativeFocusCandidateText();
        int nodePointer;
        nodePointer = nativeFocusCandidatePointer();
        mWebTextView.setNodePointer(nodePointer);
        mWebTextView.setType(nativeFocusCandidateType());
        mWebTextView.setGravityForRtl(nativeFocusCandidateIsRtlText());
        {
            text = "";
        } //End block
        mWebTextView.setTextAndKeepSelection(text);
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean varBCF51FD17B0A78CB3F43132D03F914EA_39851030 = (imm != null && imm.isActive(mWebTextView));
            {
                imm.restartInput(mWebTextView);
                mWebTextView.clearComposingText();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1634415759 = (isFocused());
            {
                mWebTextView.requestFocus();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "09C0BCF525BFF5A96C32346E594779A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateWebTextViewPosition() {
        Rect visibleRect;
        visibleRect = new Rect();
        calcOurContentVisibleRect(visibleRect);
        Rect bounds;
        bounds = nativeFocusCandidateNodeBounds();
        Rect vBox;
        vBox = contentToViewRect(bounds);
        offsetByLayerScrollPosition(vBox);
        mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        {
            boolean var5F1F7DC9987FB452C0CD065A1A522578_214559235 = (!Rect.intersects(bounds, visibleRect));
            {
                revealSelection();
            } //End block
        } //End collapsed parenthetic
        updateWebTextViewPadding();
        // ---------- Original Method ----------
        //Rect visibleRect = new Rect();
        //calcOurContentVisibleRect(visibleRect);
        //Rect bounds = nativeFocusCandidateNodeBounds();
        //Rect vBox = contentToViewRect(bounds);
        //offsetByLayerScrollPosition(vBox);
        //mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        //if (!Rect.intersects(bounds, visibleRect)) {
            //revealSelection();
        //}
        //updateWebTextViewPadding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "335B5BD26CD0233B34396F6C0352EA18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateWebTextViewPadding() {
        Rect paddingRect;
        paddingRect = nativeFocusCandidatePaddingRect();
        {
            mWebTextView.setPadding(
                    contentToViewDimension(paddingRect.left),
                    contentToViewDimension(paddingRect.top),
                    contentToViewDimension(paddingRect.right),
                    contentToViewDimension(paddingRect.bottom));
        } //End block
        // ---------- Original Method ----------
        //Rect paddingRect = nativeFocusCandidatePaddingRect();
        //if (paddingRect != null) {
            //mWebTextView.setPadding(
                    //contentToViewDimension(paddingRect.left),
                    //contentToViewDimension(paddingRect.top),
                    //contentToViewDimension(paddingRect.right),
                    //contentToViewDimension(paddingRect.bottom));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "2C8929B9B938612834BAB95CA0E72258")
    @DSModeled(DSC.SAFE)
     void revealSelection() {
        {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "BEDC7AAB78100C8F1C657A3C103F7B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(autoComplete);
        dsTaint.addTaint(name);
        dsTaint.addTaint(autoFillable);
        {
            boolean varF44B622654F1EDE6833649178C55B74F_246158076 = (mWebViewCore.getSettings().getSaveFormData());
            {
                Message update;
                update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
                update.arg1 = nodePointer;
                RequestFormData updater;
                updater = new RequestFormData(name, getUrl(),
                    update, autoFillable, autoComplete);
                Thread t;
                t = new Thread(updater);
                t.start();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mWebViewCore.getSettings().getSaveFormData()) {
            //Message update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
            //update.arg1 = nodePointer;
            //RequestFormData updater = new RequestFormData(name, getUrl(),
                    //update, autoFillable, autoComplete);
            //Thread t = new Thread(updater);
            //t.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "D00BE3A0286B5033DD9AE24C9F30936A")
    @DSModeled(DSC.SAFE)
     void requestLabel(int framePointer, int nodePointer) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(framePointer);
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                //nodePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "D00001B13210C067200D908E005DC3D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
        // ---------- Original Method ----------
        //nativeDumpDisplayTree(getUrl());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "87ED52449149438E868CF2A705B095AB")
    @DSModeled(DSC.SAFE)
    public void dumpDomTree(boolean toFile) {
        dsTaint.addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "910883830749E5FBF06871495FB8ABEE")
    @DSModeled(DSC.SAFE)
    public void dumpRenderTree(boolean toFile) {
        dsTaint.addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "7B45BF05EF30F84277C306003001CE25")
    @DSModeled(DSC.SAFE)
    public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.345 -0400", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "F8B1CF4543E3DB63918D95C37C0F0C49")
    @DSModeled(DSC.SAFE)
    public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        dsTaint.addTaint(gamma);
        dsTaint.addTaint(canProvideGamma);
        dsTaint.addTaint(canProvideBeta);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(beta);
        dsTaint.addTaint(canProvideAlpha);
        mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
        // ---------- Original Method ----------
        //mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                //canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.346 -0400", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "9D764E69E40605AE27973C3761AC1292")
    @DSModeled(DSC.SAFE)
    public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.346 -0400", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "070FEEB46542108BE39EA60B0ACA2CA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        {
            boolean var858C72F44AB8CD41BC0BE3BD37D47DCB_1366837054 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mBlockWebkitViewMessages) {
            //return false;
        //}
        //if (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null) {
            //mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            //mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.346 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "5AAEDD626750BD0D477C278CCFE01303")
    @DSModeled(DSC.SAFE)
    private boolean isEnterActionKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.347 -0400", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "2937720D322CAD52B5410850B298A77A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var057857A71DAAF22FA381D228F5183695_1257757218 = (event.isCtrlPressed());
        } //End collapsed parenthetic
        {
            mAutoRedraw = !mAutoRedraw;
            {
                invalidate();
            } //End block
        } //End block
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_791710537 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_327304725 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1137227345 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                    } //End block
                    {
                        mAccessibilityScriptInjected = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_603267788 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_457493554 = (mAccessibilityInjector.onKeyEvent(event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mAccessibilityInjector = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1442470977 = (event.hasNoModifiers());
                {
                    pageUp(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_939082342 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageUp(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_404550271 = (event.hasNoModifiers());
                {
                    pageDown(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1387823076 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageDown(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean var4D7637BE3E5BB8DFB8BE9F5DEBBD0190_2117248504 = (keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers());
            {
                pageUp(true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCDA174DB103BE1133CABA578513ECF4C_246635412 = (keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers());
            {
                pageDown(true);
            } //End block
        } //End collapsed parenthetic
        {
            switchOutDrawHistory();
            {
                boolean var5EC168B85D610989E99D878E0C758737_675352866 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varAC7A24F7600680817ED76B813249DD81_2081384345 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                {
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    pageUp(true);
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    pageDown(true);
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    nativeClearCursor();
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    boolean var563F44E657D7D016C02306EF7D73B63C_479547557 = (pinScrollTo(0, mScrollY, true, 0));
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    nativeClearCursor();
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    boolean var05C6B866B6258D11272BBA227622E49C_1332715911 = (pinScrollTo(mContentWidth, mScrollY, true, 0));
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                } //End block
            } //End collapsed parenthetic
            {
                int xRate;
                xRate = 1;
                xRate = 0;
                int yRate;
                yRate = 1;
                yRate = 0;
                int multiplier;
                multiplier = event.getRepeatCount() + 1;
                moveSelection(xRate * multiplier, yRate * multiplier);
            } //End block
            {
                boolean varECFDC30B9B17E54572F391464D24DDCA_1456730441 = (navHandledKey(keyCode, 1, false, event.getEventTime()));
                {
                    playSoundEffect(keyCodeToSoundsEffect(keyCode));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            switchOutDrawHistory();
            boolean wantsKeyEvents;
            wantsKeyEvents = nativeCursorNodePointer() == 0
                || nativeCursorWantsKeyEvents();
            {
                boolean var1C3F6BC8881ADE70AD0B6D90845DAEAD_691689381 = (event.getRepeatCount() == 0);
                {
                    mGotCenterDown = true;
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var887BE5E0D671A1E9580BF5C98186B06D_2093391265 = (getSettings().getNavDump());
            {
                //Begin case KeyEvent.KEYCODE_4 
                dumpDisplayTree();
                //End case KeyEvent.KEYCODE_4 
                //Begin case KeyEvent.KEYCODE_5 KeyEvent.KEYCODE_6 
                dumpDomTree(keyCode == KeyEvent.KEYCODE_5);
                //End case KeyEvent.KEYCODE_5 KeyEvent.KEYCODE_6 
                //Begin case KeyEvent.KEYCODE_7 KeyEvent.KEYCODE_8 
                dumpRenderTree(keyCode == KeyEvent.KEYCODE_7);
                //End case KeyEvent.KEYCODE_7 KeyEvent.KEYCODE_8 
                //Begin case KeyEvent.KEYCODE_9 
                nativeInstrumentReport();
                //End case KeyEvent.KEYCODE_9 
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFBB0B09776F969247DB212E1762B7005_1436617111 = (nativeCursorIsTextInput());
            {
                mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
                rebuildWebTextView();
                {
                    boolean var91CFAA6DBB8ACD778F334172661A353F_1053901766 = (inEditingMode());
                    {
                        mWebTextView.setDefaultSelection();
                        boolean var0E01D6F0C9B3C4661498B390117F08D9_977236223 = (mWebTextView.dispatchKeyEvent(event));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var4BF8F7F944B1F59AAF473CC034212BAF_820396514 = (nativeHasFocusNode());
                {
                    rebuildWebTextView();
                    {
                        boolean varCC7B651C81D6575D905B32AE4D2DE9FF_346553402 = (inEditingMode());
                        {
                            mWebTextView.setDefaultSelection();
                            boolean var94D478091AA1B30B7403F71D4EA231CE_1296006274 = (mWebTextView.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_1369196698 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.348 -0400", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "842727EC5A4B9644A3EE881FDF3576DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varFB3D894E81BEF45C7836AA612BE5CF4E_1774665792 = (keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode());
            {
                String text;
                text = nativeCursorText();
                {
                    boolean var0730AC3C43F6F231E2E36B9DE5B4A786_850845041 = (!nativeCursorIsTextInput() && text != null
                    && text.startsWith(SCHEME_TEL));
                    {
                        Intent intent;
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse(text));
                        getContext().startActivity(intent);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_373250721 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_755427453 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_827575469 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_UP, event);
                    } //End block
                    {
                        mAccessibilityScriptInjected = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1401181196 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_1572681280 = (mAccessibilityInjector.onKeyEvent(event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mAccessibilityInjector = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var5EC168B85D610989E99D878E0C758737_1108515067 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF2C062DAF4D50BEAFF0E218848138E20_2055583272 = (isEnterActionKey(keyCode));
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mGotCenterDown = false;
                {
                    {
                        copySelection();
                        selectionDone();
                    } //End block
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } //End block
                } //End block
                Rect visibleRect;
                visibleRect = sendOurVisibleRect();
                {
                    boolean var1C0F8D4E9F76762BB9ABC943F1506101_783712162 = (!nativeCursorIntersects(visibleRect));
                } //End collapsed parenthetic
                WebViewCore.CursorData data;
                data = cursorData();
                mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
                playSoundEffect(SoundEffectConstants.CLICK);
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_1879961256 = (nativeCursorIsTextInput());
                    {
                        rebuildWebTextView();
                        centerKeyPressOnTextField();
                        {
                            boolean varDB1B9C12ED48DAB084977319495C514C_1149682445 = (inEditingMode());
                            {
                                mWebTextView.setDefaultSelection();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                clearTextEntry();
                nativeShowCursorTimed();
                {
                    boolean var34E3725E8E3257788672BB9D0420AAC0_403293928 = (mCallbackProxy.uiOverrideUrlLoading(nativeCursorText()));
                } //End collapsed parenthetic
                {
                    boolean var2B73408B18669E3ED44DEC84F3F8FE87_1444611703 = (nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents());
                    {
                        mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_1467133668 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.348 -0400", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "A403C78797346F218231802AC5E6A525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setUpSelect(boolean selectWord, int x, int y) {
        dsTaint.addTaint(selectWord);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var1C653723DC415BF11BF974AF60071D68_98766643 = (inFullScreenMode());
        } //End collapsed parenthetic
        nativeResetSelection();
        {
            boolean var5D0F3C45A3AF9494DFD7437F551FA15B_1419461017 = (selectWord && !nativeWordSelection(x, y));
            {
                selectionDone();
            } //End block
        } //End collapsed parenthetic
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
        {
            boolean varB8A3B697E17C784F74A8FDA17CF85863_1905364996 = (startActionMode(mSelectCallback) == null);
            {
                selectionDone();
            } //End block
        } //End collapsed parenthetic
        mExtendSelection = false;
        mSelectingText = mDrawSelectionPointer = true;
        {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        } //End block
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        {
            boolean var5225ACD2E56334E54962D68427F36819_1707984579 = (nativeHasCursorNode());
            {
                Rect rect;
                rect = nativeCursorNodeBounds();
                mSelectX = contentToViewX(rect.left);
                mSelectY = contentToViewY(rect.top);
            } //End block
            {
                boolean varBE337274F3E43C04FF66B457B0EF7AE1_1116363669 = (mLastTouchY > getVisibleTitleHeightImpl());
                {
                    mSelectX = mScrollX + mLastTouchX;
                    mSelectY = mScrollY + mLastTouchY;
                } //End block
                {
                    mSelectX = mScrollX + getViewWidth() / 2;
                    mSelectY = mScrollY + getViewHeightWithTitle() / 2;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        nativeHideCursor();
        mMinAutoScrollX = 0;
        mMaxAutoScrollX = getViewWidth();
        mMinAutoScrollY = 0;
        mMaxAutoScrollY = getViewHeightWithTitle();
        mCurrentScrollingLayerId = nativeScrollableLayer(viewToContentX(mSelectX),
                viewToContentY(mSelectY), mScrollingLayerRect,
                mScrollingLayerBounds);
        {
            {
                mMinAutoScrollX = Math.max(mMinAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.left));
                mMaxAutoScrollX = Math.min(mMaxAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.right));
            } //End block
            {
                mMinAutoScrollY = Math.max(mMinAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.top));
                mMaxAutoScrollY = Math.min(mMaxAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.bottom));
            } //End block
        } //End block
        mMinAutoScrollX += SELECT_SCROLL;
        mMaxAutoScrollX -= SELECT_SCROLL;
        mMinAutoScrollY += SELECT_SCROLL;
        mMaxAutoScrollY -= SELECT_SCROLL;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.348 -0400", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "703D12A91BB33E3AAEBAF2C6D8E1CBDC")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //setUpSelect(false, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.348 -0400", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "D48509B38BC1A90A7B590285FC697AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectAll() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_820094855 = (inFullScreenMode());
        } //End collapsed parenthetic
        {
            Point select;
            select = nativeSelectableText();
            {
                boolean varAEB90306D9A88D63001E6EB8A442969D_1460867145 = (!selectText(select.x, select.y));
            } //End collapsed parenthetic
        } //End block
        nativeSelectAll();
        mDrawSelectionPointer = false;
        mExtendSelection = true;
        invalidate();
        // ---------- Original Method ----------
        //if (0 == mNativeClass) return;
        //if (inFullScreenMode()) return;
        //if (!mSelectingText) {
            //Point select = nativeSelectableText();
            //if (!selectText(select.x, select.y)) return;
        //}
        //nativeSelectAll();
        //mDrawSelectionPointer = false;
        //mExtendSelection = true;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.348 -0400", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "56BA60FC68AA4970BCF6D8852AF3C3B1")
    @DSModeled(DSC.SAFE)
     void selectionDone() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mSelectingText = false;
            {
                setLayerType(LAYER_TYPE_NONE, null);
            } //End block
            mSelectCallback.finish();
            mSelectCallback = null;
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            invalidate();
            mAutoScrollX = 0;
            mAutoScrollY = 0;
            mSentAutoScrollMessage = false;
        } //End block
        // ---------- Original Method ----------
        //if (mSelectingText) {
            //mSelectingText = false;
            //if (DEBUG_TEXT_HANDLES) {
                //setLayerType(LAYER_TYPE_NONE, null);
            //}
            //mSelectCallback.finish();
            //mSelectCallback = null;
            //WebViewCore.resumePriority();
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
            //invalidate(); 
            //mAutoScrollX = 0;
            //mAutoScrollY = 0;
            //mSentAutoScrollMessage = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "AE9C76B1570C45146003E459FBE84076")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean copySelection() {
        boolean copiedSomething;
        copiedSomething = false;
        String selection;
        selection = getSelection();
        {
            Toast.makeText(mContext
                    , com.android.internal.R.string.text_copied
                    , Toast.LENGTH_SHORT).show();
            copiedSomething = true;
            ClipboardManager cm;
            cm = (ClipboardManager)getContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(selection);
        } //End block
        invalidate();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean copiedSomething = false;
        //String selection = getSelection();
        //if (selection != null && selection != "") {
            //if (DebugFlags.WEB_VIEW) {
                //Log.v(LOGTAG, "copySelection \"" + selection + "\"");
            //}
            //Toast.makeText(mContext
                    //, com.android.internal.R.string.text_copied
                    //, Toast.LENGTH_SHORT).show();
            //copiedSomething = true;
            //ClipboardManager cm = (ClipboardManager)getContext()
                    //.getSystemService(Context.CLIPBOARD_SERVICE);
            //cm.setText(selection);
        //}
        //invalidate();
        //return copiedSomething;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "5B849C64CADAC75117206BF6F897586C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchBox getSearchBox() {
        {
            boolean var575F4597422E60100014A3F178C01D0F_1684611683 = ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null));
        } //End collapsed parenthetic
        SearchBox var96D2C2C612208F805ACC6282C981F076_2057055702 = (mWebViewCore.getBrowserFrame().getSearchBox());
        return (SearchBox)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null)) {
            //return null;
        //}
        //return mWebViewCore.getBrowserFrame().getSearchBox();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "F08CF2AAD64A2D54BECB06B9EF6499AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getSelection() {
        String var50D5BADA1C94EAD5BF704BB1EED0B40C_1588408735 = (nativeGetSelection());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mNativeClass == 0) return "";
        //return nativeGetSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "6452F51FECCB4D483146A9E6DDDB5618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_449694670 = (hasWindowFocus());
            setActive(true);
        } //End collapsed parenthetic
        final ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        {
            mGlobalLayoutListener = new InnerGlobalLayoutListener();
            treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        } //End block
        {
            mScrollChangedListener = new InnerScrollChangedListener();
            treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        } //End block
        addAccessibilityApisToJavaScript();
        mTouchEventQueue.reset();
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (hasWindowFocus()) setActive(true);
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //if (mGlobalLayoutListener == null) {
            //mGlobalLayoutListener = new InnerGlobalLayoutListener();
            //treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        //}
        //if (mScrollChangedListener == null) {
            //mScrollChangedListener = new InnerScrollChangedListener();
            //treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        //}
        //addAccessibilityApisToJavaScript();
        //mTouchEventQueue.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "E6C5CD916DF5D115ADF14BD419CD661B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_1773281871 = (hasWindowFocus());
            setActive(false);
        } //End collapsed parenthetic
        final ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        {
            treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            mGlobalLayoutListener = null;
        } //End block
        {
            treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            mScrollChangedListener = null;
        } //End block
        removeAccessibilityApisFromJavaScript();
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //clearHelpers();
        //mZoomManager.dismissZoomPicker();
        //if (hasWindowFocus()) setActive(false);
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //if (mGlobalLayoutListener != null) {
            //treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            //mGlobalLayoutListener = null;
        //}
        //if (mScrollChangedListener != null) {
            //treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            //mScrollChangedListener = null;
        //}
        //removeAccessibilityApisFromJavaScript();
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "19DA744259E21D986D89BC55BB6DF3FD")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        super.onVisibilityChanged(changedView, visibility);
        {
            mZoomManager.dismissZoomPicker();
        } //End block
        updateDrawingState();
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != View.VISIBLE && mZoomManager != null) {
            //mZoomManager.dismissZoomPicker();
        //}
        //updateDrawingState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "2B61604AE0CEF3A80C3E82876D6CB615")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onChildViewAdded(View parent, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "945774D2B6DEB5C36A475C3C7BC9CD0F")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onChildViewRemoved(View p, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.349 -0400", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "C87B316452390400E2A3809AB454EB20")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldFocus.dsTaint);
        dsTaint.addTaint(newFocus.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "0C3557A5417E9246D9F6802935C49278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setActive(boolean active) {
        dsTaint.addTaint(active);
        {
            {
                boolean varC68F8DA53A6E7AE533DF2B6E0273984A_995594805 = (hasFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
                {
                    mDrawCursorRing = false;
                    {
                        boolean var82DF510B98047A24212E03E202533075_290200732 = (!inEditingMode());
                        {
                            setFocusControllerActive(false);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB5F2F3BA6162A40E6EBD61229A1DF48F_2048868250 = (!mZoomManager.isZoomPickerVisible());
                {
                    mDrawCursorRing = false;
                } //End block
            } //End collapsed parenthetic
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            mTouchMode = TOUCH_DONE_MODE;
            setFocusControllerActive(false);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "4DFDFCDA0E75B6D7A55E06A6EB8C3C7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        setActive(hasWindowFocus);
        {
            JWebCoreJavaBridge.setActiveWebView(this);
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = false;
            } //End block
        } //End block
        {
            JWebCoreJavaBridge.removeActiveWebView(this);
            final WebSettings settings;
            settings = getSettings();
            {
                boolean var1D74215CA3033399C095EF1282AE5BE7_1108103710 = (settings != null && settings.enableSmoothTransition() &&
                    mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore));
                {
                    WebViewCore.pauseUpdatePicture(mWebViewCore);
                    mPictureUpdatePausedForFocusChange = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        super.onWindowFocusChanged(hasWindowFocus);
        // ---------- Original Method ----------
        //setActive(hasWindowFocus);
        //if (hasWindowFocus) {
            //JWebCoreJavaBridge.setActiveWebView(this);
            //if (mPictureUpdatePausedForFocusChange) {
                //WebViewCore.resumeUpdatePicture(mWebViewCore);
                //mPictureUpdatePausedForFocusChange = false;
            //}
        //} else {
            //JWebCoreJavaBridge.removeActiveWebView(this);
            //final WebSettings settings = getSettings();
            //if (settings != null && settings.enableSmoothTransition() &&
                    //mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore)) {
                //WebViewCore.pauseUpdatePicture(mWebViewCore);
                //mPictureUpdatePausedForFocusChange = true;
            //}
        //}
        //super.onWindowFocusChanged(hasWindowFocus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "DBAB568D68880210C8E4546EAE245E4E")
    @DSModeled(DSC.SAFE)
     void setFocusControllerActive(boolean active) {
        dsTaint.addTaint(active);
        mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore == null) return;
        //mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        //if (active && mListBoxMessage != null) {
            //mWebViewCore.sendMessage(mListBoxMessage);
            //mListBoxMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "0644E6797282B861044D4C0C88B98B0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            {
                boolean var7FF7C69BF2546C1B46A75E34BBC40609_736805839 = (hasWindowFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDrawCursorRing = false;
            {
                boolean varD52AFE2B2A5DD9C2C2CA64ADDFB71D04_1851178313 = (!inEditingMode());
                {
                    setFocusControllerActive(false);
                } //End block
            } //End collapsed parenthetic
            mKeysPressed.clear();
        } //End block
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "MT focusChanged " + focused + ", " + direction);
        //}
        //if (focused) {
            //if (hasWindowFocus()) {
                //mDrawCursorRing = !inEditingMode();
                //setFocusControllerActive(true);
            //}
        //} else {
            //mDrawCursorRing = false;
            //if (!inEditingMode()) {
                //setFocusControllerActive(false);
            //}
            //mKeysPressed.clear();
        //}
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "81B3A3D45E582F7E1CC430C8F5488542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setGLRectViewport() {
        boolean visible;
        visible = getGlobalVisibleRect(mGLRectViewport);
        {
            View rootView;
            rootView = getRootView();
            int rootViewHeight;
            rootViewHeight = rootView.getHeight();
            mViewRectViewport.set(mGLRectViewport);
            int savedWebViewBottom;
            savedWebViewBottom = mGLRectViewport.bottom;
            mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            mGLViewportEmpty = false;
        } //End block
        {
            mGLViewportEmpty = true;
        } //End block
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
        // ---------- Original Method ----------
        //boolean visible = getGlobalVisibleRect(mGLRectViewport);
        //if (visible) {
            //View rootView = getRootView();
            //int rootViewHeight = rootView.getHeight();
            //mViewRectViewport.set(mGLRectViewport);
            //int savedWebViewBottom = mGLRectViewport.bottom;
            //mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            //mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            //mGLViewportEmpty = false;
        //} else {
            //mGLViewportEmpty = true;
        //}
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                //mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.350 -0400", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "B0A367C30DA95753EC2B13CAD4BCEEC3")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean changed;
        changed = super.setFrame(left, top, right, bottom);
        {
            sendViewSizeZoom(false);
        } //End block
        setGLRectViewport();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(left, top, right, bottom);
        //if (!changed && mHeightCanMeasure) {
            //sendViewSizeZoom(false);
        //}
        //setGLRectViewport();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "F899022ED643204885BD7AF1A06D047C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(ow);
        dsTaint.addTaint(h);
        dsTaint.addTaint(oh);
        super.onSizeChanged(w, h, ow, oh);
        int newMaxViewportWidth;
        newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        {
            sMaxViewportWidth = newMaxViewportWidth;
        } //End block
        mZoomManager.onSizeChanged(w, h, ow, oh);
        {
            setNewPicture(mLoadedPicture, false);
        } //End block
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, ow, oh);
        //int newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        //if (newMaxViewportWidth > sMaxViewportWidth) {
            //sMaxViewportWidth = newMaxViewportWidth;
        //}
        //mZoomManager.onSizeChanged(w, h, ow, oh);
        //if (mLoadedPicture != null && mDelaySetPicture == null) {
            //setNewPicture(mLoadedPicture, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "3F62C5E08E03973FD82F49BA0EC33E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldt);
        dsTaint.addTaint(t);
        dsTaint.addTaint(oldl);
        dsTaint.addTaint(l);
        super.onScrollChanged(l, t, oldl, oldt);
        {
            sendOurVisibleRect();
            int titleHeight;
            titleHeight = getTitleHeight();
            {
                boolean varB4D4A6A79DEACE1E888BD156FFAF1F5C_397145748 = (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0));
                {
                    sendViewSizeZoom(false);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //super.onScrollChanged(l, t, oldl, oldt);
        //if (!mInOverScrollMode) {
            //sendOurVisibleRect();
            //int titleHeight = getTitleHeight();
            //if (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0)) {
                //sendViewSizeZoom(false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "4E3E35BA303128F49E738BF793E80EE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_1200368739 = (event.getAction());
            //Begin case KeyEvent.ACTION_DOWN 
            mKeysPressed.add(Integer.valueOf(event.getKeyCode()));
            //End case KeyEvent.ACTION_DOWN 
            //Begin case KeyEvent.ACTION_UP 
            int location;
            location = mKeysPressed.indexOf(Integer.valueOf(event.getKeyCode()));
            //End case KeyEvent.ACTION_UP 
            //Begin case KeyEvent.ACTION_UP 
            {
                mKeysPressed.remove(location);
            } //End block
            //End case KeyEvent.ACTION_UP 
        } //End collapsed parenthetic
        {
            boolean var5B06505CBCDCB8DEE1F6FB0FBB28CE94_785947459 = (inEditingMode() && mWebTextView.isFocused());
            {
                boolean var055C27F4AD9E2119212195DD41858BDC_1923842907 = (mWebTextView.dispatchKeyEvent(event));
            } //End block
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_259834960 = (super.dispatchKeyEvent(event));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "6BD9A6BDFBC5C76D63F2AE5D1AA3CAFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hitFocusedPlugin(int contentX, int contentY) {
        dsTaint.addTaint(contentX);
        dsTaint.addTaint(contentY);
        {
            Rect r;
            r = nativeFocusNodeBounds();
        } //End block
        boolean varAADFA5397280FFF07498DCDB610497F5_1610892038 = (nativeFocusIsPlugin()
                && nativeFocusNodeBounds().contains(contentX, contentY));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "nativeFocusIsPlugin()=" + nativeFocusIsPlugin());
            //Rect r = nativeFocusNodeBounds();
            //Log.v(LOGTAG, "nativeFocusNodeBounds()=(" + r.left + ", " + r.top
                    //+ ", " + r.right + ", " + r.bottom + ")");
        //}
        //return nativeFocusIsPlugin()
                //&& nativeFocusNodeBounds().contains(contentX, contentY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "7B0C33F9EAF177A5B5F7234DB75B107E")
    @DSModeled(DSC.SAFE)
    private boolean shouldForwardTouchEvent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mFullScreenHolder != null) return true;
        //if (mBlockWebkitViewMessages) return false;
        //return mForwardTouchEvents
                //&& !mSelectingText
                //&& mPreventDefault != PREVENT_DEFAULT_IGNORE
                //&& mPreventDefault != PREVENT_DEFAULT_NO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "B1552509D7D1BA1A4365835C0A8168E4")
    @DSModeled(DSC.SAFE)
    private boolean inFullScreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFullScreenHolder != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "3CF7D51BEC34499A6C2664CD5A051B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissFullScreenMode() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_370973675 = (inFullScreenMode());
            {
                mFullScreenHolder.hide();
                mFullScreenHolder = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inFullScreenMode()) {
            //mFullScreenHolder.hide();
            //mFullScreenHolder = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "BB8FE319542F84F64C4A70296F39F766")
    @DSModeled(DSC.SAFE)
     void onPinchToZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelTouch();
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //cancelTouch();
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.351 -0400", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "88A742007ABECF289F5D18834BDC0863")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onPinchToZoomAnimationEnd(ScaleGestureDetector detector) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(detector.dsTaint);
        onZoomAnimationEnd();
        mTouchMode = TOUCH_PINCH_DRAG;
        mConfirmMove = true;
        startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
        // ---------- Original Method ----------
        //onZoomAnimationEnd();
        //mTouchMode = TOUCH_PINCH_DRAG;
        //mConfirmMove = true;
        //startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.352 -0400", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "A4BAAD2120CA1E8F078DF4C717D39B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startScrollingLayer(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int contentX;
        contentX = viewToContentX((int) x + mScrollX);
        int contentY;
        contentY = viewToContentY((int) y + mScrollY);
        mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                mScrollingLayerRect, mScrollingLayerBounds);
        {
            mTouchMode = TOUCH_DRAG_LAYER_MODE;
        } //End block
        // ---------- Original Method ----------
        //int contentX = viewToContentX((int) x + mScrollX);
        //int contentY = viewToContentY((int) y + mScrollY);
        //mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                //mScrollingLayerRect, mScrollingLayerBounds);
        //if (mCurrentScrollingLayerId != 0) {
            //mTouchMode = TOUCH_DRAG_LAYER_MODE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.352 -0400", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "F0AD9370398CADE6E3C26A3125651AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        WebViewCore.CursorData data;
        data = cursorDataNoPosition();
        data.mX = viewToContentX((int) event.getX() + mScrollX);
        data.mY = viewToContentY((int) event.getY() + mScrollY);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return false;
        //}
        //WebViewCore.CursorData data = cursorDataNoPosition();
        //data.mX = viewToContentX((int) event.getX() + mScrollX);
        //data.mY = viewToContentY((int) event.getY() + mScrollY);
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.352 -0400", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "7495E66CEFF6E070FC088C41E3A3B2C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varAD562CF087912EB5FF0170636C3B2B0D_649472560 = (mNativeClass == 0 || (!isClickable() && !isLongClickable()));
        } //End collapsed parenthetic
        {
            boolean varDD40B025666699E2A78E1AD03139D936_1461467473 = (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO);
            {
                passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
            } //End block
            {
                mTouchEventQueue.enqueueTouchEvent(ev);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mNativeClass == 0 || (!isClickable() && !isLongClickable())) {
            //return false;
        //}
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, ev + " at " + ev.getEventTime()
                //+ " mTouchMode=" + mTouchMode
                //+ " numPointers=" + ev.getPointerCount());
        //}
        //if (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO) {
            //passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
        //} else {
            //mTouchEventQueue.enqueueTouchEvent(ev);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.352 -0400", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "4530A5A7CFCD21A6709DEC29E0563529")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float calculateDragAngle(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        float var0DC0C40463DA1E6DC4A725D44FA13B49_1770859121 = ((float) Math.atan2(dy, dx));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //dx = Math.abs(dx);
        //dy = Math.abs(dy);
        //return (float) Math.atan2(dy, dx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.355 -0400", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "798CBED97ED31D2FA92A83D5969D5CB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleTouchEventCommon(MotionEvent ev, int action, int x, int y) {
        dsTaint.addTaint(ev.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        long eventTime;
        eventTime = ev.getEventTime();
        x = Math.min(x, getViewWidth() - 1);
        y = Math.min(y, getViewHeightWithTitle() - 1);
        int deltaX;
        deltaX = mLastTouchX - x;
        int deltaY;
        deltaY = mLastTouchY - y;
        int contentX;
        contentX = viewToContentX(x + mScrollX);
        int contentY;
        contentY = viewToContentY(y + mScrollY);
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mPreventDefault = PREVENT_DEFAULT_NO;
            mConfirmMove = false;
            mInitialHitTestResult = null;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_180898634 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    mTouchMode = TOUCH_DRAG_START_MODE;
                    mConfirmMove = true;
                    nativeSetIsScrolling(false);
                } //End block
                {
                    boolean varBDC63CBFC1D5292A90395B799377E3CA_709108104 = (mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP));
                    {
                        mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_2051165323 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                removeTouchHighlight();
                            } //End block
                        } //End collapsed parenthetic
                        {
                            mTouchMode = TOUCH_DOUBLE_TAP_MODE;
                        } //End block
                        {
                            doShortPress();
                            mTouchMode = TOUCH_INIT_MODE;
                            mDeferTouchProcess = !mBlockWebkitViewMessages
                                && (!inFullScreenMode() && mForwardTouchEvents)
                                ? hitFocusedPlugin(contentX, contentY)
                                : false;
                        } //End block
                    } //End block
                    {
                        mTouchMode = TOUCH_INIT_MODE;
                        mDeferTouchProcess = !mBlockWebkitViewMessages
                            && (!inFullScreenMode() && mForwardTouchEvents)
                            ? hitFocusedPlugin(contentX, contentY)
                            : false;
                        {
                            mWebViewCore.sendMessage(
                                EventHub.UPDATE_FRAME_CACHE_IF_LOADING);
                        } //End block
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_1388988278 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                TouchHighlightData data;
                                data = new TouchHighlightData();
                                data.mX = contentX;
                                data.mY = contentY;
                                data.mNativeLayerRect = new Rect();
                                data.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, data.mNativeLayerRect, null);
                                data.mSlop = viewToContentDimension(mNavSlop);
                                mTouchHighlightRegion.setEmpty();
                                {
                                    mTouchHighlightRequested = System.currentTimeMillis();
                                    mWebViewCore.sendMessageAtFrontOfQueue(
                                    EventHub.GET_TOUCH_HIGHLIGHT_RECTS, data);
                                } //End block
                                {
                                    {
                                        boolean varD778979F37708EA925216FB277FD8D27_1048994739 = (getSettings().getNavDump());
                                        {
                                            mTouchHighlightX = (int) x + mScrollX;
                                            mTouchHighlightY = (int) y + mScrollY;
                                            mPrivateHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        mTouchHighlightX = mTouchHighlightY = 0;
                                        invalidate();
                                    }
                                }, TOUCH_HIGHLIGHT_ELAPSE_TIME);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            EventLog.writeEvent(EventLogTags.BROWSER_DOUBLE_TAP_DURATION,
                                (eventTime - mLastTouchUpTime), eventTime);
                        } //End block
                        {
                            mDrawSelectionPointer = false;
                            mSelectionStarted = nativeStartSelection(contentX, contentY);
                            invalidate();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_SHORTPRESS, TAP_TIMEOUT);
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_LONGPRESS, LONG_PRESS_TIMEOUT);
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_2059537677 = (inFullScreenMode() || mDeferTouchProcess);
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_MAYBE_YES;
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8932DD5DB07C85349F24CECE7642DABD_1023968460 = (shouldForwardTouchEvent());
                    {
                        TouchEventData ted;
                        ted = new TouchEventData();
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
                        {
                            boolean var6904F2C5D7BEAFC799CAAF4B382483D5_572042883 = (!inFullScreenMode());
                            {
                                mPrivateHandler.removeMessages(PREVENT_DEFAULT_TIMEOUT);
                                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                    .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                            action, 0), TAP_TIMEOUT);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            startTouch(x, y, eventTime);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            boolean firstMove;
            firstMove = false;
            {
                mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                mConfirmMove = true;
                firstMove = true;
                {
                    mTouchMode = TOUCH_INIT_MODE;
                } //End block
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_744052932 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varD5BC4EB905AD1A9E62B09D5876DE7CFA_1634542351 = (shouldForwardTouchEvent() && mConfirmMove && (firstMove
                        || eventTime - mLastSentTouchTime > mCurrentTouchInterval));
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
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
                    {
                        boolean varEF4783D596E01CB01D0208E403EB969C_1832053026 = (firstMove && !inFullScreenMode());
                        {
                            mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                        action, 0), TAP_TIMEOUT);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                mVelocityTracker.addMovement(ev);
            } //End block
            {
                ViewParent parent;
                parent = getParent();
                {
                    parent.requestDisallowInterceptTouchEvent(true);
                } //End block
                mAutoScrollX = x <= mMinAutoScrollX ? -SELECT_SCROLL
                            : x >= mMaxAutoScrollX ? SELECT_SCROLL : 0;
                mAutoScrollY = y <= mMinAutoScrollY ? -SELECT_SCROLL
                            : y >= mMaxAutoScrollY ? SELECT_SCROLL : 0;
                {
                    mSentAutoScrollMessage = true;
                    mPrivateHandler.sendEmptyMessageDelayed(
                                SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                } //End block
                {
                    nativeExtendSelection(contentX, contentY);
                    invalidate();
                } //End block
            } //End block
            {
                {
                    mLastTouchTime = eventTime;
                } //End block
                final ScaleGestureDetector detector;
                detector = mZoomManager.getMultiTouchGestureDetector();
                mAverageAngle = calculateDragAngle(deltaX, deltaY);
                {
                    boolean varA7D01DAA9313836025F53EEF13EC7FDA_19089076 = (detector == null || !detector.isInProgress());
                    {
                        {
                            mSnapScrollMode = SNAP_X;
                            mSnapPositive = deltaX > 0;
                            mAverageAngle = ANGLE_HORIZ;
                        } //End block
                        {
                            mSnapScrollMode = SNAP_Y;
                            mSnapPositive = deltaY > 0;
                            mAverageAngle = ANGLE_VERT;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mTouchMode = TOUCH_DRAG_MODE;
                deltaX = 0;
                deltaY = 0;
                startScrollingLayer(x, y);
                startDrag();
            } //End block
            boolean done;
            done = false;
            boolean keepScrollBarsVisible;
            keepScrollBarsVisible = false;
            {
                keepScrollBarsVisible = done = true;
            } //End block
            {
                mAverageAngle +=
                        (calculateDragAngle(deltaX, deltaY) - mAverageAngle)
                        / MMA_WEIGHT_N;
                {
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        mSnapScrollMode = SNAP_X;
                        mSnapPositive = deltaX > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_HORIZ) / 2;
                    } //End block
                    {
                        mSnapScrollMode = SNAP_Y;
                        mSnapPositive = deltaY > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_VERT) / 2;
                    } //End block
                } //End block
                {
                    {
                        deltaY = 0;
                    } //End block
                    {
                        deltaX = 0;
                    } //End block
                } //End block
                {
                    mHeldMotionless = MOTIONLESS_FALSE;
                    nativeSetIsScrolling(true);
                } //End block
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    nativeSetIsScrolling(false);
                    keepScrollBarsVisible = true;
                } //End block
                mLastTouchTime = eventTime;
            } //End block
            doDrag(deltaX, deltaY);
            {
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    invalidate();
                } //End block
                awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(),
                            false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                            .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
            } //End block
            {
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_819025401 = (!isFocused());
                requestFocus();
            } //End collapsed parenthetic
            {
                boolean var4F0E2B9C4455366734F8A4D46CDF3837_759900807 = (shouldForwardTouchEvent());
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
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
                } //End block
            } //End collapsed parenthetic
            mLastTouchUpTime = eventTime;
            {
                mAutoScrollX = mAutoScrollY = 0;
            } //End block
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            {
                boolean var99D9C999635D25840B0CAFFCC353615B_920994448 = (inFullScreenMode() || mDeferTouchProcess);
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
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
                } //End block
                {
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    mTouchMode = TOUCH_DONE_MODE;
                } //End block
            } //End collapsed parenthetic
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            {
                {
                    boolean var9A35F484FD2A3035C5778E7274850AEE_304305663 = (mPreventDefault != PREVENT_DEFAULT_YES
                                    && (computeMaxScrollX() > 0
                                            || computeMaxScrollY() > 0));
                    {
                        WebViewCore.reducePriority();
                        WebViewCore.pauseUpdatePicture(mWebViewCore);
                    } //End block
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    {
                        boolean var52238646ADDC3EDB53CF60FF8D752DAA_412558375 = (!nativeHitSelection(contentX, contentY));
                        {
                            selectionDone();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var7ECA0E1176F50826819D1E05F7BE240D_186747656 = (mTouchMode == TOUCH_INIT_MODE
                                    && (canZoomIn() || canZoomOut()));
                    {
                        mPrivateHandler.sendEmptyMessageDelayed(
                                        RELEASE_SINGLE_TAP, ViewConfiguration
                                                .getDoubleTapTimeout());
                    } //End block
                    {
                        doShortPress();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            {
                {
                    mVelocityTracker.addMovement(ev);
                } //End block
                mHeldMotionless = MOTIONLESS_IGNORE;
                doFling();
            } //End block
            {
                {
                    boolean varBCFC69392A8766EDCCDAD1B162C3D405_467044832 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    computeMaxScrollX(), 0,
                                    computeMaxScrollY()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mHeldMotionless = MOTIONLESS_TRUE;
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            invalidate();
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            mLastVelocity = 0;
            //End case TOUCH_DRAG_START_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            WebViewCore.resumePriority();
            //End case TOUCH_DRAG_START_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
            //End case TOUCH_DRAG_START_MODE 
            stopTouch();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            {
                mScroller.springBack(mScrollX, mScrollY, 0,
                            computeMaxScrollX(), 0, computeMaxScrollY());
                invalidate();
            } //End block
            cancelWebCoreTouchEvent(contentX, contentY, false);
            cancelTouch();
        } //End block
        //End case MotionEvent.ACTION_CANCEL 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.356 -0400", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "985BE8E2D107C76E818A8127F3EA456D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        dsTaint.addTaint(ev.dsTaint);
        dsTaint.addTaint(sequence);
        TouchEventData ted;
        ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        final int count;
        count = ev.getPointerCount();
        ted.mIds = new int[count];
        ted.mPoints = new Point[count];
        ted.mPointsInView = new Point[count];
        {
            int c;
            c = 0;
            {
                ted.mIds[c] = ev.getPointerId(c);
                int x;
                x = viewToContentX((int) ev.getX(c) + mScrollX);
                int y;
                y = viewToContentY((int) ev.getY(c) + mScrollY);
                ted.mPoints[c] = new Point(x, y);
                ted.mPointsInView[c] = new Point((int) ev.getX(c), (int) ev.getY(c));
            } //End block
        } //End collapsed parenthetic
        {
            ted.mActionIndex = ev.getActionIndex();
        } //End block
        ted.mMetaState = ev.getMetaState();
        ted.mReprocess = true;
        ted.mMotionEvent = MotionEvent.obtain(ev);
        ted.mSequence = sequence;
        mTouchEventQueue.preQueueTouchEventData(ted);
        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
        cancelLongPress();
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.356 -0400", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "9498C126B622449D9359D3EBD1CC27CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleMultiTouchInWebView(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        final ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        float x;
        x = ev.getX();
        float y;
        y = ev.getY();
        {
            detector.onTouchEvent(ev);
            {
                boolean var57DA30FC8CBBE7A73D9281B93734CBB1_280379812 = (detector.isInProgress());
                {
                    mLastTouchTime = ev.getEventTime();
                    x = detector.getFocusX();
                    y = detector.getFocusY();
                    cancelLongPress();
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    {
                        boolean var1701A38F89582DE3B703C873F3E6A99C_883227573 = (!mZoomManager.supportsPanDuringZoom());
                    } //End collapsed parenthetic
                    mTouchMode = TOUCH_DRAG_MODE;
                    {
                        mVelocityTracker = VelocityTracker.obtain();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int action;
        action = ev.getActionMasked();
        {
            cancelTouch();
            action = MotionEvent.ACTION_DOWN;
        } //End block
        {
            boolean var3FCFE6069F8C28D647A3D03480A488F3_171487923 = (action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2);
            {
                mLastTouchX = Math.round(x);
                mLastTouchY = Math.round(y);
            } //End block
        } //End collapsed parenthetic
        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.357 -0400", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "1A6B33BE8C2B454D67C380877AEE4344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(removeEvents);
        dsTaint.addTaint(x);
        {
            boolean var3C4264CDBD1B465E519441FFC519D662_264729821 = (shouldForwardTouchEvent());
            {
                {
                    mWebViewCore.removeMessages(EventHub.TOUCH_EVENT);
                } //End block
                TouchEventData ted;
                ted = new TouchEventData();
                ted.mIds = new int[1];
                ted.mIds[0] = 0;
                ted.mPoints = new Point[1];
                ted.mPoints[0] = new Point(x, y);
                ted.mPointsInView = new Point[1];
                int viewX;
                viewX = contentToViewX(x) - mScrollX;
                int viewY;
                viewY = contentToViewY(y) - mScrollY;
                ted.mPointsInView[0] = new Point(viewX, viewY);
                ted.mAction = MotionEvent.ACTION_CANCEL;
                ted.mNativeLayer = nativeScrollableLayer(
                    x, y, ted.mNativeLayerRect, null);
                ted.mSequence = mTouchEventQueue.nextTouchSequence();
                mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                mPreventDefault = PREVENT_DEFAULT_IGNORE;
                {
                    mTouchEventQueue.ignoreCurrentlyMissingEvents();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.357 -0400", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "C6AB28F4398F93FB099050CA5195B23D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startTouch(float x, float y, long eventTime) {
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        mStartTouchX = mLastTouchX = Math.round(x);
        mStartTouchY = mLastTouchY = Math.round(y);
        mVelocityTracker = VelocityTracker.obtain();
        mSnapScrollMode = SNAP_NONE;
        mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                ViewConfiguration.getTapTimeout());
        // ---------- Original Method ----------
        //mStartTouchX = mLastTouchX = Math.round(x);
        //mStartTouchY = mLastTouchY = Math.round(y);
        //mLastTouchTime = eventTime;
        //mVelocityTracker = VelocityTracker.obtain();
        //mSnapScrollMode = SNAP_NONE;
        //mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                //ViewConfiguration.getTapTimeout());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.357 -0400", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "80024814AE21474E3C43078CEEE3C1A2")
    @DSModeled(DSC.SAFE)
    private void startDrag() {
        WebViewCore.reducePriority();
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);
        {
            nativeHideCursor();
        } //End block
        {
            mZoomManager.invokeZoomPicker();
        } //End block
        // ---------- Original Method ----------
        //WebViewCore.reducePriority();
        //WebViewCore.pauseUpdatePicture(mWebViewCore);
        //nativeSetIsScrolling(true);
        //if (!mDragFromTextInput) {
            //nativeHideCursor();
        //}
        //if (mHorizontalScrollBarMode != SCROLLBAR_ALWAYSOFF
                //|| mVerticalScrollBarMode != SCROLLBAR_ALWAYSOFF) {
            //mZoomManager.invokeZoomPicker();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.357 -0400", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "62F1C3DFEBEDEF249A24225A41C68D22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doDrag(int deltaX, int deltaY) {
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(deltaY);
        {
            int oldX;
            oldX = mScrollX;
            int oldY;
            oldY = mScrollY;
            int rangeX;
            rangeX = computeMaxScrollX();
            int rangeY;
            rangeY = computeMaxScrollY();
            int overscrollDistance;
            overscrollDistance = mOverscrollDistance;
            {
                final int contentX;
                contentX = viewToContentDimension(deltaX);
                final int contentY;
                contentY = viewToContentDimension(deltaY);
                final int maxX;
                maxX = mScrollingLayerRect.right;
                final int maxY;
                maxY = mScrollingLayerRect.bottom;
                final int resultX;
                resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                final int resultY;
                resultY = Math.max(0,
                        Math.min(mScrollingLayerRect.top + contentY, maxY));
                {
                    mTouchMode = TOUCH_DRAG_LAYER_MODE;
                    deltaX = contentX;
                    deltaY = contentY;
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = maxX;
                    rangeY = maxY;
                } //End block
                {
                    mTouchMode = TOUCH_DRAG_MODE;
                } //End block
            } //End block
            {
                mOverScrollGlow.setOverScrollDeltas(deltaX, deltaY);
            } //End block
            overScrollBy(deltaX, deltaY, oldX, oldY,
                    rangeX, rangeY,
                    mOverscrollDistance, mOverscrollDistance, true);
            {
                boolean var5792E174AFE968D06415B5B7AAC36535_380795892 = (mOverScrollGlow != null && mOverScrollGlow.isAnimating());
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mZoomManager.keepZoomPickerVisible();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.357 -0400", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "2BA6D83383F7431797985F9F61070B40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopTouch() {
        {
            boolean varCAF00077668D04F986EAAEC815FA20E7_1964614086 = (mScroller.isFinished() && !mSelectingText
                && (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE));
            {
                WebViewCore.resumePriority();
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                nativeSetIsScrolling(false);
            } //End block
        } //End collapsed parenthetic
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        {
            mOverScrollGlow.releaseAll();
        } //End block
        // ---------- Original Method ----------
        //if (mScroller.isFinished() && !mSelectingText
                //&& (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE)) {
            //WebViewCore.resumePriority();
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
            //nativeSetIsScrolling(false);
        //}
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
        //if (mOverScrollGlow != null) {
            //mOverScrollGlow.releaseAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.358 -0400", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "8B84C28A903D1E9AABFE2E4B7199A2BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelTouch() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        } //End block
        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
        {
            boolean varAC20DC667EA914A16B375E9527C79DFD_1687250644 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
            } //End block
        } //End collapsed parenthetic
        mHeldMotionless = MOTIONLESS_TRUE;
        mTouchMode = TOUCH_DONE_MODE;
        nativeHideCursor();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.358 -0400", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "478A4F94E64704631C082E9CB26CCB31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_969807896 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1128413668 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        /*final*/ float vscroll;
                        /*final*/ float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_264633471 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                            {
                                vscroll = 0;
                                hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            } //End block
                            {
                                vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            final int vdelta;
                            vdelta = (int) (vscroll * getVerticalScrollFactor());
                            final int hdelta;
                            hdelta = (int) (hscroll * getHorizontalScrollFactor());
                            {
                                boolean var2D3D9D2324BD436DC860CC59381AD41D_2093825389 = (pinScrollBy(hdelta, vdelta, false, 0));
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_2021596530 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.358 -0400", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "11F705233EC980D32C7CF97BBF2BCCA3")
    @DSModeled(DSC.SAFE)
    public void setMapTrackballToArrowKeys(boolean setMap) {
        dsTaint.addTaint(setMap);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mMapTrackballToArrowKeys = setMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.358 -0400", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "66119BAFACA01CA93AA53D15A83308AB")
    @DSModeled(DSC.SAFE)
     void resetTrackballTime() {
        mTrackballLastTime = 0;
        // ---------- Original Method ----------
        //mTrackballLastTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.359 -0400", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "B74618B00BFB7A7CEC56614E37E52519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        long time;
        time = ev.getEventTime();
        {
            boolean varF89B2554B17216A1EC58B9D61476F71F_915467062 = ((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0);
            {
                {
                    boolean varF71C9C4037B7A9B705CFAAB9834929D8_715041270 = (ev.getY() > 0);
                    pageDown(true);
                } //End collapsed parenthetic
                {
                    boolean var07FD34B1A3496FC381CDBE7EFC3BB0AA_587751898 = (ev.getY() < 0);
                    pageUp(true);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_128104290 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                mTrackballDown = true;
                {
                    boolean varD7E949BAB427F90FF96CAA2888F6F2C4_992511474 = (time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds()));
                    {
                        nativeSelectBestAt(mLastCursorBounds);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varAFC77293C02F773029137FDE42129C14_2081983785 = (isInTouchMode());
                    requestFocusFromTouch();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9BE2C50B8CBB194C9242022F6D5B67CC_2055519510 = (ev.getAction() == MotionEvent.ACTION_UP);
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mTrackballDown = false;
                mTrackballUpTime = time;
                {
                    {
                        copySelection();
                        selectionDone();
                    } //End block
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var963F7CE81FE031C5E5B8879F84F3644B_106750788 = ((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
                AccessibilityManager.getInstance(mContext).isEnabled());
        } //End collapsed parenthetic
        switchOutDrawHistory();
        {
            mTrackballFirstTime = time;
            mTrackballXMove = mTrackballYMove = 0;
        } //End block
        mTrackballLastTime = time;
        mTrackballRemainsX += ev.getX();
        mTrackballRemainsY += ev.getY();
        doTrackball(time, ev.getMetaState());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.359 -0400", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "41C60BA79CB9016382E621E722DE8513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void moveSelection(float xRate, float yRate) {
        dsTaint.addTaint(xRate);
        dsTaint.addTaint(yRate);
        int width;
        width = getViewWidth();
        int height;
        height = getViewHeight();
        int maxX;
        maxX = width + mScrollX;
        int maxY;
        maxY = height + mScrollY;
        mSelectX = Math.min(maxX, Math.max(mScrollX - SELECT_CURSOR_OFFSET
                , mSelectX));
        mSelectY = Math.min(maxY, Math.max(mScrollY - SELECT_CURSOR_OFFSET
                , mSelectY));
        nativeMoveSelection(viewToContentX(mSelectX), viewToContentY(mSelectY));
        int scrollX;
        scrollX = SELECT_CURSOR_OFFSET;
        scrollX = 0;
        int scrollY;
        scrollY = SELECT_CURSOR_OFFSET;
        scrollY = 0;
        pinScrollBy(scrollX, scrollY, true, 0);
        Rect select;
        select = new Rect(mSelectX, mSelectY, mSelectX + 1, mSelectY + 1);
        requestRectangleOnScreen(select);
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.359 -0400", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "A35A937DE51ED89AF6BABBB6103E2844")
    @DSModeled(DSC.SAFE)
    private int scaleTrackballX(float xRate, int width) {
        dsTaint.addTaint(width);
        dsTaint.addTaint(xRate);
        int xMove;
        xMove = (int) (xRate / TRACKBALL_SCALE * width);
        int nextXMove;
        nextXMove = xMove;
        {
            {
                xMove -= mTrackballXMove;
            } //End block
        } //End block
        {
            xMove -= mTrackballXMove;
        } //End block
        mTrackballXMove = nextXMove;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int xMove = (int) (xRate / TRACKBALL_SCALE * width);
        //int nextXMove = xMove;
        //if (xMove > 0) {
            //if (xMove > mTrackballXMove) {
                //xMove -= mTrackballXMove;
            //}
        //} else if (xMove < mTrackballXMove) {
            //xMove -= mTrackballXMove;
        //}
        //mTrackballXMove = nextXMove;
        //return xMove;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.359 -0400", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "6CA60E1FB7C92A37AB4B6024451AAB05")
    @DSModeled(DSC.SAFE)
    private int scaleTrackballY(float yRate, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(yRate);
        int yMove;
        yMove = (int) (yRate / TRACKBALL_SCALE * height);
        int nextYMove;
        nextYMove = yMove;
        {
            {
                yMove -= mTrackballYMove;
            } //End block
        } //End block
        {
            yMove -= mTrackballYMove;
        } //End block
        mTrackballYMove = nextYMove;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int yMove = (int) (yRate / TRACKBALL_SCALE * height);
        //int nextYMove = yMove;
        //if (yMove > 0) {
            //if (yMove > mTrackballYMove) {
                //yMove -= mTrackballYMove;
            //}
        //} else if (yMove < mTrackballYMove) {
            //yMove -= mTrackballYMove;
        //}
        //mTrackballYMove = nextYMove;
        //return yMove;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.360 -0400", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "ECB834C228F30B2571D807877D41D50C")
    @DSModeled(DSC.SAFE)
    private int keyCodeToSoundsEffect(int keyCode) {
        dsTaint.addTaint(keyCode);
        /*
        throw new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
        */
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch(keyCode) {
            //case KeyEvent.KEYCODE_DPAD_UP:
                //return SoundEffectConstants.NAVIGATION_UP;
            //case KeyEvent.KEYCODE_DPAD_RIGHT:
                //return SoundEffectConstants.NAVIGATION_RIGHT;
            //case KeyEvent.KEYCODE_DPAD_DOWN:
                //return SoundEffectConstants.NAVIGATION_DOWN;
            //case KeyEvent.KEYCODE_DPAD_LEFT:
                //return SoundEffectConstants.NAVIGATION_LEFT;
        //}
        //throw new IllegalArgumentException("keyCode must be one of " +
                //"{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                //"KEYCODE_DPAD_LEFT}.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.360 -0400", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "78CE635FC953E8139468FC6AE2D95947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doTrackball(long time, int metaState) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(metaState);
        int elapsed;
        elapsed = (int) (mTrackballLastTime - mTrackballFirstTime);
        {
            elapsed = TRACKBALL_TIMEOUT;
        } //End block
        float xRate;
        xRate = mTrackballRemainsX * 1000 / elapsed;
        float yRate;
        yRate = mTrackballRemainsY * 1000 / elapsed;
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeight();
        {
            {
                mSelectX = contentToViewX(nativeSelectionX());
                mSelectY = contentToViewY(nativeSelectionY());
                mDrawSelectionPointer = mExtendSelection = true;
                nativeSetExtendSelection();
            } //End block
            moveSelection(scaleTrackballX(xRate, viewWidth),
                    scaleTrackballY(yRate, viewHeight));
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } //End block
        float ax;
        ax = Math.abs(xRate);
        float ay;
        ay = Math.abs(yRate);
        float maxA;
        maxA = Math.max(ax, ay);
        int width;
        width = mContentWidth - viewWidth;
        int height;
        height = mContentHeight - viewHeight;
        width = 0;
        height = 0;
        ax = Math.abs(mTrackballRemainsX * TRACKBALL_MULTIPLIER);
        ay = Math.abs(mTrackballRemainsY * TRACKBALL_MULTIPLIER);
        maxA = Math.max(ax, ay);
        int count;
        count = Math.max(0, (int) maxA);
        int oldScrollX;
        oldScrollX = mScrollX;
        int oldScrollY;
        oldScrollY = mScrollY;
        {
            int selectKeyCode;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_LEFT;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
            count = Math.min(count, TRACKBALL_MOVE_COUNT);
            {
                boolean var13243A190284240A17DA938A95FFCA4B_785109002 = (mNativeClass != 0 && nativePageShouldHandleShiftAndArrows());
                {
                    {
                        int i;
                        i = 0;
                        {
                            letPageHandleNavKey(selectKeyCode, time, true, metaState);
                        } //End block
                    } //End collapsed parenthetic
                    letPageHandleNavKey(selectKeyCode, time, false, metaState);
                } //End block
                {
                    boolean var9216DDA0E70E02F03C94252CA6894A26_2050448749 = (navHandledKey(selectKeyCode, count, false, time));
                    {
                        playSoundEffect(keyCodeToSoundsEffect(selectKeyCode));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } //End block
        {
            int xMove;
            xMove = scaleTrackballX(xRate, width);
            int yMove;
            yMove = scaleTrackballY(yRate, height);
            {
                boolean var1510D01512E341B4186F1DC473D82D5C_1972069457 = (Math.abs(mScrollX - oldScrollX) > Math.abs(xMove));
                {
                    xMove = 0;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varEA9F4D4529504DF5B7FB3F15ED262404_1298926900 = (Math.abs(mScrollY - oldScrollY) > Math.abs(yMove));
                {
                    yMove = 0;
                } //End block
            } //End collapsed parenthetic
            {
                pinScrollBy(xMove, yMove, true, 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.360 -0400", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "24604F70D8210027DDD819C82040E351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int computeMaxScrollX() {
        int varA25CFD9DF68C570DBFC28D80EAD42611_427250279 = (Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.360 -0400", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "4B2328EFFD7C221FFEED383362DEB923")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int computeMaxScrollY() {
        int varBA3EE78DB7716D218FE9D8E3CD2F2343_1413788228 = (Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                //- getViewHeightWithTitle(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.361 -0400", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "8A3837DAB7F6D763A0F8FDC90406E7E3")
    @DSModeled(DSC.SAFE)
     boolean updateScrollCoordinates(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int oldX;
        oldX = mScrollX;
        int oldY;
        oldY = mScrollY;
        mScrollX = x;
        mScrollY = y;
        {
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int oldX = mScrollX;
        //int oldY = mScrollY;
        //mScrollX = x;
        //mScrollY = y;
        //if (oldX != mScrollX || oldY != mScrollY) {
            //onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.361 -0400", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "1B9107DD3D96DC6F4161263E1E29A7B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flingScroll(int vx, int vy) {
        dsTaint.addTaint(vy);
        dsTaint.addTaint(vx);
        checkThread();
        mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
        // ---------- Original Method ----------
        //checkThread();
        //mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                //computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.361 -0400", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "1F175FB072715F848D45A495F521825C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doFling() {
        int maxX;
        maxX = computeMaxScrollX();
        int maxY;
        maxY = computeMaxScrollY();
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int vx;
        vx = (int) mVelocityTracker.getXVelocity();
        int vy;
        vy = (int) mVelocityTracker.getYVelocity();
        int scrollX;
        scrollX = mScrollX;
        int scrollY;
        scrollY = mScrollY;
        int overscrollDistance;
        overscrollDistance = mOverscrollDistance;
        int overflingDistance;
        overflingDistance = mOverflingDistance;
        {
            scrollX = mScrollingLayerRect.left;
            scrollY = mScrollingLayerRect.top;
            maxX = mScrollingLayerRect.right;
            maxY = mScrollingLayerRect.bottom;
            overscrollDistance = overflingDistance = 0;
        } //End block
        {
            {
                vy = 0;
            } //End block
            {
                vx = 0;
            } //End block
        } //End block
        {
            WebViewCore.resumePriority();
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
            {
                boolean var294FD332965037BDDAF5E40360BE82C6_257644416 = (mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY));
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        float currentVelocity;
        currentVelocity = mScroller.getCurrVelocity();
        float velocity;
        velocity = (float) Math.hypot(vx, vy);
        {
            float deltaR;
            deltaR = (float) (Math.abs(Math.atan2(mLastVelY, mLastVelX)
                    - Math.atan2(vy, vx)));
            final float circle;
            circle = (float) (Math.PI) * 2.0f;
            {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
            } //End block
        } //End block
        {
            boolean var7D437B480773CFFE36BF196E1126697F_372421597 = ((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy));
            {
                vx = 0;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var062E5EDAB50CDBF113CFC310D559CF03_532336764 = ((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx));
            {
                vy = 0;
            } //End block
        } //End collapsed parenthetic
        {
            {
                vx = 0;
            } //End block
            {
                vy = 0;
            } //End block
        } //End block
        mLastVelX = vx;
        mLastVelY = vy;
        mLastVelocity = velocity;
        mScroller.fling(scrollX, scrollY, -vx, -vy, 0, maxX, 0, maxY,
                maxX == 0 ? 0 : overflingDistance, overflingDistance);
        final int time;
        time = mScroller.getDuration();
        {
            awakenScrollBars(time);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "6CEBE77BA0738653307B0B12847764A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public View getZoomControls() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_847792465 = (!getSettings().supportZoom());
        } //End collapsed parenthetic
        View varA42D8B8924B07B5130F0496CCA7A32D7_2086015001 = (mZoomManager.getExternalZoomPicker());
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return null;
        //}
        //return mZoomManager.getExternalZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "2C0CA68FEA8281AFF081DFED7B07A71C")
    @DSModeled(DSC.SAFE)
     void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
        // ---------- Original Method ----------
        //mZoomManager.dismissZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "E25D0B6B22F98693FE61811E2E1A6992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getDefaultZoomScale() {
        float var952A9E36B82C4A93C3ADCF5509083504_1045602238 = (mZoomManager.getDefaultScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getDefaultScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "E9F31757BE46544FAB18BE5C788271C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getZoomOverviewScale() {
        float varEF858DD667F2D952B7E5019CEC33E4DD_750630600 = (mZoomManager.getZoomOverviewScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getZoomOverviewScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "47FF39342E742308B17A9CC96732DDC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canZoomIn() {
        checkThread();
        boolean varB7D0C9863F46AF864AE5BCCDA2FEA388_986635782 = (mZoomManager.canZoomIn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "3D1B6298487EB074E9D2C7F13FF13A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canZoomOut() {
        checkThread();
        boolean var55B9AB817324FC769B25B74F0D5FB277_1043664873 = (mZoomManager.canZoomOut());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "F6C640F4C339DB5DE90DA87CDA8E2625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomIn() {
        checkThread();
        boolean varAC42C946D5F06586AAF06194E5591056_612155870 = (mZoomManager.zoomIn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "B89D7141B54278E7C1FF5B37BA192F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomOut() {
        checkThread();
        boolean varA9C5CE6824B53568BAC50FAF0F581652_1322799723 = (mZoomManager.zoomOut());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "A9948166A074EF016DE75990EFF43D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSelection() {
        mPrivateHandler.removeMessages(UPDATE_SELECTION);
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        Rect rect;
        rect = new Rect(contentX - slop, contentY - slop,
                contentX + slop, contentY + slop);
        nativeSelectBestAt(rect);
        mInitialHitTestResult = hitTestResult(null);
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return;
        //}
        //mPrivateHandler.removeMessages(UPDATE_SELECTION);
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //int slop = viewToContentDimension(mNavSlop);
        //Rect rect = new Rect(contentX - slop, contentY - slop,
                //contentX + slop, contentY + slop);
        //nativeSelectBestAt(rect);
        //mInitialHitTestResult = hitTestResult(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "EBAB0FA96EBB341230C8FB9C25E0FD46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scrollFocusedTextInputX(float xPercent) {
        dsTaint.addTaint(xPercent);
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1752436627 = (!inEditingMode() || mWebViewCore == null);
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                new Float(xPercent));
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                //new Float(xPercent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.362 -0400", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "C7CB2A852A3CA04AF31873BD5F509B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scrollFocusedTextInputY(int y) {
        dsTaint.addTaint(y);
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1946749219 = (!inEditingMode() || mWebViewCore == null);
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "E6DD962ED60A0182D1C374E66DD91E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initiateTextFieldDrag(float x, float y, long eventTime) {
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_1966492906 = (!inEditingMode());
        } //End collapsed parenthetic
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_2068052183 = (!mScroller.isFinished());
            {
                abortAnimation();
            } //End block
        } //End collapsed parenthetic
        mSnapScrollMode = SNAP_NONE;
        mVelocityTracker = VelocityTracker.obtain();
        mTouchMode = TOUCH_DRAG_START_MODE;
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return;
        //}
        //mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        //mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        //mLastTouchTime = eventTime;
        //if (!mScroller.isFinished()) {
            //abortAnimation();
        //}
        //mSnapScrollMode = SNAP_NONE;
        //mVelocityTracker = VelocityTracker.obtain();
        //mTouchMode = TOUCH_DRAG_START_MODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "DCB3FF5F6C8B252A73B602F96F085E0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean textFieldDrag(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_2086005328 = (!inEditingMode());
        } //End collapsed parenthetic
        mDragFromTextInput = true;
        event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                (float) (mWebTextView.getTop() - mScrollY));
        boolean result;
        result = onTouchEvent(event);
        mDragFromTextInput = false;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return false;
        //}
        //mDragFromTextInput = true;
        //event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                //(float) (mWebTextView.getTop() - mScrollY));
        //boolean result = onTouchEvent(event);
        //mDragFromTextInput = false;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "BAAAC9CB5DC1102E1CD925C9884705DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void touchUpOnTextField(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_159052731 = (!inEditingMode());
        } //End collapsed parenthetic
        int x;
        x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        int y;
        y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        int slop;
        slop = viewToContentDimension(mNavSlop);
        nativeMotionUp(x, y, slop);
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return;
        //}
        //int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        //int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        //int slop = viewToContentDimension(mNavSlop);
        //nativeMotionUp(x, y, slop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "6C3D725838891874A77055A03D27504A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    //nativeCursorNodePointer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "DA6CE904A653423F4FC41502CA7B7EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doShortPress() {
        mTouchMode = TOUCH_DONE_MODE;
        updateSelection();
        switchOutDrawHistory();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean var4BAF6D43948FA1BCD9CF85CF914BDF89_215208694 = (USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty());
            {
                mTouchHighlightRequested = 0;
                invalidate(mTouchHighlightRegion.getBounds());
                mPrivateHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    removeTouchHighlight();
                }
            }, ViewConfiguration.getPressedStateDuration());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5F51EF0491BBB7096F9C5C6CD4BCA197_1844182945 = (getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
                WebViewCore.TouchUpData touchUpData;
                touchUpData = new WebViewCore.TouchUpData();
                touchUpData.mMoveGeneration = 0;
                mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
            } //End block
            {
                boolean varDA83C45CB8F2A6B5FD9F88AE0C10D3FD_1956565208 = (nativePointInNavCache(contentX, contentY, slop));
                {
                    WebViewCore.MotionUpData motionUpData;
                    motionUpData = new WebViewCore
                    .MotionUpData();
                    motionUpData.mFrame = nativeCacheHitFramePointer();
                    motionUpData.mNode = nativeCacheHitNodePointer();
                    motionUpData.mBounds = nativeCacheHitNodeBounds();
                    motionUpData.mX = contentX;
                    motionUpData.mY = contentY;
                    mWebViewCore.sendMessageAtFrontOfQueue(EventHub.VALID_NODE_BOUNDS,
                    motionUpData);
                } //End block
                {
                    doMotionUp(contentX, contentY);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.363 -0400", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "807A2CE1FD778E61C8D2980F9319E1FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doMotionUp(int contentX, int contentY) {
        dsTaint.addTaint(contentX);
        dsTaint.addTaint(contentY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varC55016010C379CE34BF3B6896DDAD394_1216830476 = (nativeMotionUp(contentX, contentY, slop) && mLogEvent);
            {
                EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7C1BED8D4E1F2400404C847BC14812AF_197085320 = (nativeHasCursorNode() && !nativeCursorIsTextInput());
            {
                playSoundEffect(SoundEffectConstants.CLICK);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativeMotionUp(contentX, contentY, slop) && mLogEvent) {
            //EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
        //}
        //if (nativeHasCursorNode() && !nativeCursorIsTextInput()) {
            //playSoundEffect(SoundEffectConstants.CLICK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.364 -0400", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "259B2A83756DAE64085BC8481A933408")
    @DSModeled(DSC.SAFE)
     void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.364 -0400", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "C2F3E9076897E7DFB63C44530AEFA9CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Rect getPluginBounds(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varE761D0BE351A5DB0C46D78ECBD6C783A_771082875 = (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin());
            {
                Rect var00CB1A97DE918DF5494318893B9A376C_920738880 = (nativeCacheHitNodeBounds());
            } //End block
        } //End collapsed parenthetic
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin()) {
            //return nativeCacheHitNodeBounds();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.364 -0400", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "EA31BF2DA297FE159A245F4499001CC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isRectFitOnScreen(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        final int rectWidth;
        rectWidth = rect.width();
        final int rectHeight;
        rectHeight = rect.height();
        final int viewWidth;
        viewWidth = getViewWidth();
        final int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        boolean var21C05C69D4E6BB9F2891D7DC21CA89A0_923027913 = (!mZoomManager.willScaleTriggerZoom(scale)
                && contentToViewX(rect.left) >= mScrollX
                && contentToViewX(rect.right) <= mScrollX + viewWidth
                && contentToViewY(rect.top) >= mScrollY
                && contentToViewY(rect.bottom) <= mScrollY + viewHeight);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int rectWidth = rect.width();
        //final int rectHeight = rect.height();
        //final int viewWidth = getViewWidth();
        //final int viewHeight = getViewHeightWithTitle();
        //float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        //scale = mZoomManager.computeScaleWithLimits(scale);
        //return !mZoomManager.willScaleTriggerZoom(scale)
                //&& contentToViewX(rect.left) >= mScrollX
                //&& contentToViewX(rect.right) <= mScrollX + viewWidth
                //&& contentToViewY(rect.top) >= mScrollY
                //&& contentToViewY(rect.bottom) <= mScrollY + viewHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.364 -0400", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "64F8A1EBE14AD6DD63A60185C3541D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void centerFitRect(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        final int rectWidth;
        rectWidth = rect.width();
        final int rectHeight;
        rectHeight = rect.height();
        final int viewWidth;
        viewWidth = getViewWidth();
        final int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        {
            boolean varDD6431018C58684D7A37FFB96BEA1A10_112162436 = (!mZoomManager.willScaleTriggerZoom(scale));
            {
                pinScrollTo(contentToViewX(rect.left + rectWidth / 2) - viewWidth / 2,
                    contentToViewY(rect.top + rectHeight / 2) - viewHeight / 2,
                    true, 0);
            } //End block
            {
                float actualScale;
                actualScale = mZoomManager.getScale();
                float oldScreenX;
                oldScreenX = rect.left * actualScale - mScrollX;
                float rectViewX;
                rectViewX = rect.left * scale;
                float rectViewWidth;
                rectViewWidth = rectWidth * scale;
                float newMaxWidth;
                newMaxWidth = mContentWidth * scale;
                float newScreenX;
                newScreenX = (viewWidth - rectViewWidth) / 2;
                {
                    newScreenX = rectViewX;
                } //End block
                {
                    newScreenX = viewWidth - (newMaxWidth - rectViewX);
                } //End block
                float zoomCenterX;
                zoomCenterX = (oldScreenX * scale - newScreenX * actualScale)
                    / (scale - actualScale);
                float oldScreenY;
                oldScreenY = rect.top * actualScale + getTitleHeight()
                    - mScrollY;
                float rectViewY;
                rectViewY = rect.top * scale + getTitleHeight();
                float rectViewHeight;
                rectViewHeight = rectHeight * scale;
                float newMaxHeight;
                newMaxHeight = mContentHeight * scale + getTitleHeight();
                float newScreenY;
                newScreenY = (viewHeight - rectViewHeight) / 2;
                {
                    newScreenY = rectViewY;
                } //End block
                {
                    newScreenY = viewHeight - (newMaxHeight - rectViewY);
                } //End block
                float zoomCenterY;
                zoomCenterY = (oldScreenY * scale - newScreenY * actualScale)
                    / (scale - actualScale);
                mZoomManager.setZoomCenter(zoomCenterX, zoomCenterY);
                mZoomManager.startZoomAnimation(scale, false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.365 -0400", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "DB757A2A8C1ED51792E572FCA3155083")
    @DSModeled(DSC.SAFE)
    private void overrideLoading(String url) {
        dsTaint.addTaint(url);
        mCallbackProxy.uiOverrideUrlLoading(url);
        // ---------- Original Method ----------
        //mCallbackProxy.uiOverrideUrlLoading(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.372 -0400", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "52081059A3AC8244D956FE30E5B6381F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        boolean result;
        result = false;
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_565585664 = (inEditingMode());
            {
                result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
            } //End block
            {
                result = super.requestFocus(direction, previouslyFocusedRect);
                {
                    boolean varA494CE1F4ADF8E7072392AACBFD5D724_1106619640 = (mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode());
                    {
                        int fakeKeyDirection;
                        fakeKeyDirection = 0;
                        //Begin case View.FOCUS_UP 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_UP;
                        //End case View.FOCUS_UP 
                        //Begin case View.FOCUS_DOWN 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_DOWN;
                        //End case View.FOCUS_DOWN 
                        //Begin case View.FOCUS_LEFT 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_LEFT;
                        //End case View.FOCUS_LEFT 
                        //Begin case View.FOCUS_RIGHT 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_RIGHT;
                        //End case View.FOCUS_RIGHT 
                        {
                            boolean var191048386196A56D55A1FA6B9EBCC1D7_305325095 = (mNativeClass != 0 && !nativeHasCursorNode());
                            {
                                navHandledKey(fakeKeyDirection, 1, true, 0);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.372 -0400", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "C3BE70A5A53206FB580DF03192FB146B")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight;
        measuredHeight = heightSize;
        int measuredWidth;
        measuredWidth = widthSize;
        int contentHeight;
        contentHeight = contentToViewDimension(mContentHeight);
        int contentWidth;
        contentWidth = contentToViewDimension(mContentWidth);
        {
            mHeightCanMeasure = true;
            measuredHeight = contentHeight;
            {
                {
                    measuredHeight = heightSize;
                    mHeightCanMeasure = false;
                    measuredHeight |= MEASURED_STATE_TOO_SMALL;
                } //End block
            } //End block
        } //End block
        {
            mHeightCanMeasure = false;
        } //End block
        {
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        } //End block
        {
            mWidthCanMeasure = true;
            measuredWidth = contentWidth;
        } //End block
        {
            {
                measuredWidth |= MEASURED_STATE_TOO_SMALL;
            } //End block
            mWidthCanMeasure = false;
        } //End block
        {
            setMeasuredDimension(measuredWidth, measuredHeight);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.373 -0400", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "FD573C7F6261B5A7782C7689632684B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rect.dsTaint);
        {
            boolean var264B566DF21DF74851E1F42772AB9C13_1741339407 = (mZoomManager.isFixedLengthAnimationInProgress());
        } //End collapsed parenthetic
        rect.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        Rect content;
        content = new Rect(viewToContentX(mScrollX),
                viewToContentY(mScrollY),
                viewToContentX(mScrollX + getWidth()
                - getVerticalScrollbarWidth()),
                viewToContentY(mScrollY + getViewHeightWithTitle()));
        content = nativeSubtractLayers(content);
        int screenTop;
        screenTop = contentToViewY(content.top);
        int screenBottom;
        screenBottom = contentToViewY(content.bottom);
        int height;
        height = screenBottom - screenTop;
        int scrollYDelta;
        scrollYDelta = 0;
        {
            int oneThirdOfScreenHeight;
            oneThirdOfScreenHeight = height / 3;
            {
                boolean varD63CDEF6BD028FCFFAC8F4D0CD965025_913247601 = (rect.height() > 2 * oneThirdOfScreenHeight);
                {
                    scrollYDelta = rect.top - screenTop;
                } //End block
                {
                    scrollYDelta = rect.top - (screenTop + oneThirdOfScreenHeight);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            scrollYDelta = rect.top - screenTop;
        } //End block
        int screenLeft;
        screenLeft = contentToViewX(content.left);
        int screenRight;
        screenRight = contentToViewX(content.right);
        int width;
        width = screenRight - screenLeft;
        int scrollXDelta;
        scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_706601448 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } //End block
                {
                    scrollXDelta += (rect.right - screenRight);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            scrollXDelta -= (screenLeft - rect.left);
        } //End block
        {
            boolean var5E8E4CF43F6392F54248EF881F3D0871_1673324815 = (pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.373 -0400", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "FEF7A50E77DA7F992D3324707E4397E0")
    @DSModeled(DSC.SAFE)
     void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        dsTaint.addTaint(oldEnd);
        dsTaint.addTaint(replace);
        dsTaint.addTaint(newStart);
        dsTaint.addTaint(oldStart);
        dsTaint.addTaint(newEnd);
        WebViewCore.ReplaceTextData arg;
        arg = new WebViewCore.ReplaceTextData();
        arg.mReplace = replace;
        arg.mNewStart = newStart;
        arg.mNewEnd = newEnd;
        mTextGeneration++;
        arg.mTextGeneration = mTextGeneration;
        mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
        // ---------- Original Method ----------
        //WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
        //arg.mReplace = replace;
        //arg.mNewStart = newStart;
        //arg.mNewEnd = newEnd;
        //mTextGeneration++;
        //arg.mTextGeneration = mTextGeneration;
        //mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.373 -0400", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "8A19896BF1DEB96E3149ED7DDAFF3131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void passToJavaScript(String currentText, KeyEvent event) {
        dsTaint.addTaint(currentText);
        dsTaint.addTaint(event.dsTaint);
        WebViewCore.JSKeyData arg;
        arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
        mTextGeneration++;
        mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                cursorData(), 1000);
        // ---------- Original Method ----------
        //if (mWebViewCore == null) {
            //return;
        //}
        //WebViewCore.JSKeyData arg = new WebViewCore.JSKeyData();
        //arg.mEvent = event;
        //arg.mCurrentText = currentText;
        //mTextGeneration++;
        //mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        //mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        //mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                //cursorData(), 1000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.373 -0400", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "DFAD41F4FBE822BFC335829B901112F3")
    @DSModeled(DSC.SAFE)
    public synchronized WebViewCore getWebViewCore() {
        return (WebViewCore)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.373 -0400", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "D95F76C9DCD8E39C7AE7C6FC527CC776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTouchHighlightRects(ArrayList<Rect> rects) {
        dsTaint.addTaint(rects.dsTaint);
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
        {
            {
                Iterator<Rect> seatecAstronomy42 = rects.iterator();
                seatecAstronomy42.hasNext();
                Rect rect = seatecAstronomy42.next();
                {
                    Rect viewRect;
                    viewRect = contentToViewRect(rect);
                    {
                        boolean varA5A6B8C49AB9156241CF88CA93A69E58_194999600 = (viewRect.width() < getWidth() >> 1
                        || viewRect.height() < getHeight() >> 1);
                        {
                            mTouchHighlightRegion.union(viewRect);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            invalidate(mTouchHighlightRegion.getBounds());
        } //End block
        // ---------- Original Method ----------
        //invalidate(mTouchHighlightRegion.getBounds());
        //mTouchHighlightRegion.setEmpty();
        //if (rects != null) {
            //for (Rect rect : rects) {
                //Rect viewRect = contentToViewRect(rect);
                //if (viewRect.width() < getWidth() >> 1
                        //|| viewRect.height() < getHeight() >> 1) {
                    //mTouchHighlightRegion.union(viewRect);
                //} else {
                    //Log.w(LOGTAG, "Skip the huge selection rect:"
                            //+ viewRect);
                //}
            //}
            //invalidate(mTouchHighlightRegion.getBounds());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "EEB14110E497201A204DA86B1F3656B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void pageSwapCallback(boolean notifyAnimationStarted) {
        dsTaint.addTaint(notifyAnimationStarted);
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_701531264 = (inEditingMode());
            {
                didUpdateWebTextViewDimensions(ANYWHERE);
            } //End block
        } //End collapsed parenthetic
        {
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //didUpdateWebTextViewDimensions(ANYWHERE);
        //}
        //if (notifyAnimationStarted) {
            //mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "FA63EF866C3DFE0B8CC7900EF3D7B455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        dsTaint.addTaint(draw.dsTaint);
        dsTaint.addTaint(updateBaseLayer);
        /*
        {
            {
                throw new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
            } //End block
        } //End block
        */
        WebViewCore.ViewState viewState;
        viewState = draw.mViewState;
        boolean isPictureAfterFirstLayout;
        isPictureAfterFirstLayout = viewState != null;
        {
            boolean registerPageSwapCallback;
            registerPageSwapCallback = !mZoomManager.isFixedLengthAnimationInProgress() && inEditingMode();
            setBaseLayer(draw.mBaseLayer, draw.mInvalRegion,
                    getSettings().getShowVisualIndicator(),
                    isPictureAfterFirstLayout, registerPageSwapCallback);
        } //End block
        final Point viewSize;
        viewSize = draw.mViewSize;
        final boolean updateLayout;
        updateLayout = viewSize.x == mLastWidthSent
                && viewSize.y == mLastHeightSent;
        mSendScrollEvent = false;
        recordNewContentSize(draw.mContentSize.x,
                draw.mContentSize.y, updateLayout);
        {
            mLastWidthSent = 0;
            mZoomManager.onFirstLayout(draw);
            int scrollX;
            scrollX = getContentWidth();
            scrollX = viewState.mScrollX;
            int scrollY;
            scrollY = viewState.mScrollY;
            setContentScrollTo(scrollX, scrollY);
            {
                clearTextEntry();
            } //End block
        } //End block
        mSendScrollEvent = true;
        {
            Rect b;
            b = draw.mInvalRegion.getBounds();
        } //End block
        invalidateContentRect(draw.mInvalRegion.getBounds());
        {
            mPictureListener.onNewPicture(WebView.this, capturePicture());
        } //End block
        mZoomManager.onNewPicture(draw);
        {
            boolean var926A8D0B5C0D740061680329138C210C_1780982315 = (draw.mFocusSizeChanged && inEditingMode());
            {
                mFocusSizeChanged = true;
            } //End block
        } //End collapsed parenthetic
        {
            mViewManager.postReadyToDrawAll();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "29DAAFDAAE5A6804E5D2850D45521BB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(textGeneration);
        {
            boolean var179B09369C5FEC85CD8155FF224AECDC_447296792 = (inEditingMode()
                && mWebTextView.isSameTextField(nodePointer)
                && textGeneration == mTextGeneration);
            {
                mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& mWebTextView.isSameTextField(nodePointer)
                //&& textGeneration == mTextGeneration) {
            //mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "5336C17134515BA625F497FE9F1C6501")
    @DSModeled(DSC.SAFE)
     void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        dsTaint.addTaint(selectedArray);
        dsTaint.addTaint(enabledArray);
        dsTaint.addTaint(array);
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selectedArray));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "CBB76EF68503D612D3008F5B3AB5D469")
    @DSModeled(DSC.SAFE)
     void requestListBox(String[] array, int[] enabledArray, int selection) {
        dsTaint.addTaint(enabledArray);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(array);
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selection));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "432CCAF21DECDBFF0DE47AD3E2346C7F")
    @DSModeled(DSC.SAFE)
    private void sendMoveFocus(int frame, int node) {
        dsTaint.addTaint(node);
        dsTaint.addTaint(frame);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                //new WebViewCore.CursorData(frame, node, 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "08EABB14F7874942BA29FDCB2DC5086D")
    @DSModeled(DSC.SAFE)
    private void sendMoveMouse(int frame, int node, int x, int y) {
        dsTaint.addTaint(node);
        dsTaint.addTaint(frame);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                new WebViewCore.CursorData(frame, node, x, y));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                //new WebViewCore.CursorData(frame, node, x, y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.374 -0400", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "BF186B3E9F5801CCB3319D682DF01265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private void sendMoveMouseIfLatest(boolean removeFocus, boolean stopPaintingCaret) {
        dsTaint.addTaint(stopPaintingCaret);
        dsTaint.addTaint(removeFocus);
        {
            clearTextEntry();
        } //End block
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                stopPaintingCaret ? 1 : 0, 0,
                cursorData());
        // ---------- Original Method ----------
        //if (removeFocus) {
            //clearTextEntry();
        //}
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                //stopPaintingCaret ? 1 : 0, 0,
                //cursorData());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.375 -0400", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "C72AB9A96EA9D049C117B60663CE8B4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMotionUp(int touchGeneration,
            int frame, int node, int x, int y) {
        dsTaint.addTaint(node);
        dsTaint.addTaint(frame);
        dsTaint.addTaint(touchGeneration);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        WebViewCore.TouchUpData touchUpData;
        touchUpData = new WebViewCore.TouchUpData();
        touchUpData.mMoveGeneration = touchGeneration;
        touchUpData.mFrame = frame;
        touchUpData.mNode = node;
        touchUpData.mX = x;
        touchUpData.mY = y;
        touchUpData.mNativeLayer = nativeScrollableLayer(
                x, y, touchUpData.mNativeLayerRect, null);
        mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
        // ---------- Original Method ----------
        //WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
        //touchUpData.mMoveGeneration = touchGeneration;
        //touchUpData.mFrame = frame;
        //touchUpData.mNode = node;
        //touchUpData.mX = x;
        //touchUpData.mY = y;
        //touchUpData.mNativeLayer = nativeScrollableLayer(
                //x, y, touchUpData.mNativeLayerRect, null);
        //mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.375 -0400", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "68ACBD010A4A6FFAA3C9FF47DB798BEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScaledMaxXScroll() {
        int width;
        {
            width = getViewWidth() / 4;
        } //End block
        {
            Rect visRect;
            visRect = new Rect();
            calcOurVisibleRect(visRect);
            width = visRect.width() / 2;
        } //End block
        int var4CD57EC65F046B376944293A38E9A187_512115705 = (viewToContentX(width));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int width;
        //if (mHeightCanMeasure == false) {
            //width = getViewWidth() / 4;
        //} else {
            //Rect visRect = new Rect();
            //calcOurVisibleRect(visRect);
            //width = visRect.width() / 2;
        //}
        //return viewToContentX(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.375 -0400", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "9855D63E695A3C2EBC3C95EFDA24A383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getScaledMaxYScroll() {
        int height;
        {
            height = getViewHeight() / 4;
        } //End block
        {
            Rect visRect;
            visRect = new Rect();
            calcOurVisibleRect(visRect);
            height = visRect.height() / 2;
        } //End block
        int var3B6C50355F4C83B6515E3BB844F5C669_797381633 = (Math.round(height * mZoomManager.getInvScale()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int height;
        //if (mHeightCanMeasure == false) {
            //height = getViewHeight() / 4;
        //} else {
            //Rect visRect = new Rect();
            //calcOurVisibleRect(visRect);
            //height = visRect.height() / 2;
        //}
        //return Math.round(height * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.375 -0400", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "7211F07AC26B3BFBEDC86CE80760D287")
    @DSModeled(DSC.SAFE)
    private void viewInvalidate() {
        invalidate();
        // ---------- Original Method ----------
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.375 -0400", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "E97DE20633BAA8027270870CFF6987F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void letPageHandleNavKey(int keyCode, long time, boolean down, int metaState) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(time);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(down);
        int keyEventAction;
        int eventHubAction;
        {
            keyEventAction = KeyEvent.ACTION_DOWN;
            eventHubAction = EventHub.KEY_DOWN;
            playSoundEffect(keyCodeToSoundsEffect(keyCode));
        } //End block
        {
            keyEventAction = KeyEvent.ACTION_UP;
            eventHubAction = EventHub.KEY_UP;
        } //End block
        KeyEvent event;
        event = new KeyEvent(time, time, keyEventAction, keyCode,
                1, (metaState & KeyEvent.META_SHIFT_ON)
                | (metaState & KeyEvent.META_ALT_ON)
                | (metaState & KeyEvent.META_SYM_ON)
                , KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        mWebViewCore.sendMessage(eventHubAction, event);
        // ---------- Original Method ----------
        //int keyEventAction;
        //int eventHubAction;
        //if (down) {
            //keyEventAction = KeyEvent.ACTION_DOWN;
            //eventHubAction = EventHub.KEY_DOWN;
            //playSoundEffect(keyCodeToSoundsEffect(keyCode));
        //} else {
            //keyEventAction = KeyEvent.ACTION_UP;
            //eventHubAction = EventHub.KEY_UP;
        //}
        //KeyEvent event = new KeyEvent(time, time, keyEventAction, keyCode,
                //1, (metaState & KeyEvent.META_SHIFT_ON)
                //| (metaState & KeyEvent.META_ALT_ON)
                //| (metaState & KeyEvent.META_SYM_ON)
                //, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        //mWebViewCore.sendMessage(eventHubAction, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "A3F276B43AC5C66ABDA7228BAB946BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean navHandledKey(int keyCode, int count, boolean noScroll,
            long time) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(time);
        dsTaint.addTaint(noScroll);
        dsTaint.addTaint(count);
        mInitialHitTestResult = null;
        mLastCursorBounds = nativeGetCursorRingBounds();
        boolean keyHandled;
        keyHandled = nativeMoveCursor(keyCode, count, noScroll) == false;
        Rect contentCursorRingBounds;
        contentCursorRingBounds = nativeGetCursorRingBounds();
        {
            boolean var78E9DE151C1DFEF7820F7C4599A2F8D0_2026274570 = (contentCursorRingBounds.isEmpty());
        } //End collapsed parenthetic
        Rect viewCursorRingBounds;
        viewCursorRingBounds = contentToViewRect(contentCursorRingBounds);
        mLastTouchX = (viewCursorRingBounds.left + viewCursorRingBounds.right) / 2;
        mLastTouchY = (viewCursorRingBounds.top + viewCursorRingBounds.bottom) / 2;
        Rect visRect;
        visRect = new Rect();
        calcOurVisibleRect(visRect);
        Rect outset;
        outset = new Rect(visRect);
        int maxXScroll;
        maxXScroll = visRect.width() / 2;
        int maxYScroll;
        maxYScroll = visRect.height() / 2;
        outset.inset(-maxXScroll, -maxYScroll);
        {
            boolean varB6D877D107F828AA26477AA9FEE04EDD_1056466864 = (Rect.intersects(outset, viewCursorRingBounds) == false);
        } //End collapsed parenthetic
        int maxH;
        maxH = Math.min(viewCursorRingBounds.right - visRect.right,
                maxXScroll);
        {
            pinScrollBy(maxH, 0, true, 0);
        } //End block
        {
            maxH = Math.max(viewCursorRingBounds.left - visRect.left,
                    -maxXScroll);
            {
                pinScrollBy(maxH, 0, true, 0);
            } //End block
        } //End block
        {
            boolean var6A8A4E436D7412BEF448043644BD31DB_1484935398 = (mLastCursorBounds.isEmpty());
        } //End collapsed parenthetic
        {
            boolean var46EFF7D5420AE1A7A30F7E288D313B74_1079540255 = (mLastCursorBounds.equals(contentCursorRingBounds));
        } //End collapsed parenthetic
        requestRectangleOnScreen(viewCursorRingBounds);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "663AD138B5A550540E43802385553C7F")
    @DSModeled(DSC.SAFE)
    private boolean accessibilityScriptInjected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityScriptInjected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "A51C9034E0A7F54740300C66334B3552")
    @DSModeled(DSC.SAFE)
    @Override
    public void setBackgroundColor(int color) {
        dsTaint.addTaint(color);
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
        // ---------- Original Method ----------
        //mBackgroundColor = color;
        //mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "12C1DB3E7A62ACB3F68DBCF84E3307B7")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void debugDump() {
        checkThread();
        nativeDebugDump();
        mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
        // ---------- Original Method ----------
        //checkThread();
        //nativeDebugDump();
        //mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "42F56AD76464BEAE18FB225A18D48F87")
    @DSModeled(DSC.SAFE)
    public void drawPage(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
        // ---------- Original Method ----------
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "F08EF346A076F977D82C3CB1E868AE74")
    @DSModeled(DSC.SAFE)
    public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //mHTML5VideoViewProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "8913240CF2507E8AFE34808F8C478AA9")
    @DSModeled(DSC.SAFE)
    public void setTouchInterval(int interval) {
        dsTaint.addTaint(interval);
        // ---------- Original Method ----------
        //mCurrentTouchInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.376 -0400", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "521ABCE574451115B9960AB16A80FE7A")
    @DSModeled(DSC.SAFE)
    protected void updateCachedTextfield(String updatedText) {
        dsTaint.addTaint(updatedText);
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
        // ---------- Original Method ----------
        //nativeUpdateCachedTextfield(updatedText, mTextGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "65FC27A9B18173ECA81E2785375EEDC9")
    @DSModeled(DSC.SAFE)
     void autoFillForm(int autoFillQueryId) {
        dsTaint.addTaint(autoFillQueryId);
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "3662CDD079981960AA50A81B965E1C86")
    @DSModeled(DSC.SAFE)
     ViewManager getViewManager() {
        return (ViewManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mViewManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "943B62368DE741C255F640DAAE3693A1", hash_generated_method = "948C04E76A6FC62A78AB33C2005A1A44")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "2B24D6B15E3C9330F49004C9CA187BC8")
    @DSModeled(DSC.SAFE)
    protected void contentInvalidateAll() {
        {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "B8F5A74F85D6F9F84526BF0DA479D253")
    @DSModeled(DSC.SAFE)
    protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
        // ---------- Original Method ----------
        //nativeRegisterPageSwapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "33C94B3FA736814E290F5E5A2456804B")
    @DSModeled(DSC.SAFE)
    public void tileProfilingStart() {
        nativeTileProfilingStart();
        // ---------- Original Method ----------
        //nativeTileProfilingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "CEE2E9410DE06A3558B4C415B02BCAB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float tileProfilingStop() {
        float varB18687EE139E5166CC9AF408D9889054_1733602611 = (nativeTileProfilingStop());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeTileProfilingStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "438EAD688C15D1355C8C4C4A7F92A6E1")
    @DSModeled(DSC.SAFE)
    public void tileProfilingClear() {
        nativeTileProfilingClear();
        // ---------- Original Method ----------
        //nativeTileProfilingClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "49C37E4B9A3F79C1C3D8B72020CB020F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingNumFrames() {
        int var169947B5FA60947E0B7BC7984522118F_2039936377 = (nativeTileProfilingNumFrames());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingNumFrames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "B3C30467A80A6AFC719E7FB0C4BACC02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingNumTilesInFrame(int frame) {
        dsTaint.addTaint(frame);
        int varFDE1A8CA934CC4FCCFE59320104D4907_807197423 = (nativeTileProfilingNumTilesInFrame(frame));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingNumTilesInFrame(frame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "0CA9A1E200F2B0D063E83366CC9BB92F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingGetInt(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        int varE7654B1D69F1E5F05A936A8E62104F88_29421142 = (nativeTileProfilingGetInt(frame, tile, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingGetInt(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "6C3495822C2142A876113C58853DDA19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float tileProfilingGetFloat(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        float varFC830259BB0CC6250B57A21E07835342_516234869 = (nativeTileProfilingGetFloat(frame, tile, key));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeTileProfilingGetFloat(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "6457E9D3FAA72AA01C0F08D3E1124377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCacheHitFramePointer() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "A53CB2BEB3773D6764CBB2BD84025CF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCacheHitIsPlugin() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "838C95571F45B1878EE484641EBA955E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeCacheHitNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "FC0903DBF8027FE6C0C58977967E6F72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCacheHitNodePointer() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "1C8085F1338FB815E2E3920E73D5DB70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void nativeClearCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.377 -0400", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "99C0CD4FF47DA8966C0B8FA1C28A4C99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx) {
        dsTaint.addTaint(isHighEndGfx);
        dsTaint.addTaint(drawableDir);
        dsTaint.addTaint(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "9C6ADB755EDFF84D942D6EC0E92F4E81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCursorFramePointer() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "130B5EEAE6687F8C79AF99A1C7813E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeCursorNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "2E449C113BCBBF33A5E21DC28DDFCE32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCursorNodePointer() {
    	return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "FC4D2FCFD103A5D5A9E094DBF906C06E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIntersects(Rect visibleRect) {
        dsTaint.addTaint(visibleRect.dsTaint);
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "7B93E0BDF70896C409E9E22BE8783445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIsAnchor() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "066268104D9322ACA5A3A15CB9B1FDBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIsTextInput() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "662DC61DEB6426FAA8B33399CB08C992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Point nativeCursorPosition() {
    	return new Point();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "2C78EAE30422A0D08AAA4233AF983886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeCursorText() {
    	return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "10FF5800FB71AC44246CD15DD541C7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorWantsKeyEvents() {
    	return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "52ABB7810971EBE123DE8E4C86AFF94A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDebugDump() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1E6A29FEC4719172DAB72764161B9E2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "920BD05EC5673E681E420C922B66311E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeDraw(Canvas canvas, RectF visibleRect,
            int color, int extra, boolean splitIfNeeded) {
        dsTaint.addTaint(splitIfNeeded);
        dsTaint.addTaint(color);
        dsTaint.addTaint(extra);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(visibleRect.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "C5953939795C9E03F9F9342536DB42E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpDisplayTree(String urlOrNull) {
        dsTaint.addTaint(urlOrNull);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "59C31231D245CD3771E1CD43ADF500D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeEvaluateLayersAnimations(int nativeInstance) {
        dsTaint.addTaint(nativeInstance);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "AF4245151B8BB4788F6CDF344C2C4850")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetDrawGLFunction(int nativeInstance, Rect rect,
            Rect viewRect, RectF visibleRect, float scale, int extras) {
        dsTaint.addTaint(viewRect.dsTaint);
        dsTaint.addTaint(nativeInstance);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(visibleRect.dsTaint);
        dsTaint.addTaint(extras);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "AE2C858751F7B1E8EB6E05C70DE8EDA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
            RectF visibleRect) {
        dsTaint.addTaint(viewRect.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(visibleRect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "BE93FD796EE2ABD7B9F6FF1CCC195FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeExtendSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "6640570C0CAAA84F645A35B28E2477F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFindAll(String findLower, String findUpper,
            boolean sameAsLastSearch) {
        dsTaint.addTaint(sameAsLastSearch);
        dsTaint.addTaint(findLower);
        dsTaint.addTaint(findUpper);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "976877B92CE6D7716121311A4B44E286")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFindNext(boolean forward) {
        dsTaint.addTaint(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "4A1C845C88E369C549BA87181285437C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateFramePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "3C0AC60963498B1B56D44E88918C1B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateHasNextTextfield() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "6934086B1486E748E10D22DF06700CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsPassword() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "0A8F68F23512FA148747F337436255F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusCandidateIsRtlText() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "8902AFAB7FBF33F4876B120E7E3A03AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusCandidateIsTextInput() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "47D4E963ABA84A52F53C4612477907F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateMaxLength() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "F69D559FEB2CCEFED0986E2543F14C4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsAutoComplete() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "609373E619DFC1561AF944DA81AC90D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsSpellcheck() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "4FFE3F68CCE0C1A90EADECEFD93738B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String nativeFocusCandidateName() {
    	return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "BAEE29210DDBAEE8E99D149762D0548F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusCandidateNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "183FAE6CFFE3BB6D35430147FAB76F88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusCandidatePaddingRect() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "D3FDC1B3B7DBED5E7887540FC8379E2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidatePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "419CE5896BC227A8E9B7F2FB830E96F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeFocusCandidateText() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.378 -0400", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "275EC37860CE340EE1D80F6BE76EE05B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float nativeFocusCandidateTextSize() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "5BE6CAF508D1ED006376CB1095515570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateLineHeight() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "AFDFDCC1731E169F6052530736DF86E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFocusCandidateType() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "236D1B01D0EFB8FEE5FE608C534EEE1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFocusCandidateLayerId() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "D145CCB02C5F94E18C2BC50FA4BC7942")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusIsPlugin() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "9268633570ABB230C2DA4C5A2AD8049E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "5418EA47421E25FFADE0D5674094ED04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusNodePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "D04E227BFE752D2AD81DBBA1BC8C0C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeGetCursorRingBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "DAB2EBE7A464F426B24DD4DECCB33D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeGetSelection() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "BE457DA334E8CB86EB690C8EB4786B83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasCursorNode() {
        return dsTaint.getTaintBoolean();
    	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "45917A51A73690C644467A42A83A39E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasFocusNode() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "4B38A1BA78ED5484D335A2A49C6577EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeHideCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "80C94B6D222914953FFE924AEC4572C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHitSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "F30513CC3EEC378EAE8550814B71066F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeImageURI(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "78FB26BAEE786AB57F623138CF0CAB57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeInstrumentReport() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "485286E77F8C883A0765647BEEAECD0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeLayerBounds(int layer) {
        dsTaint.addTaint(layer);
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "6585E217139DB928B972AE953CF88C27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeMoveCursorToNextTextInput() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "9A532282620D457E1BE59FAF736BED06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeMotionUp(int x, int y, int slop) {
        dsTaint.addTaint(slop);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "DCE1B7EFDE6B6439DFDFEAB2B589AB97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeMoveCursor(int keyCode, int count,
            boolean noScroll) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(noScroll);
        dsTaint.addTaint(count);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "5FBB30E6736055C97BF9B8F66768DB5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeMoveGeneration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "06F3A79286D749EEEDB57507F72727C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeMoveSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "006E6AE9116A40F285FC3C8D0FC209A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativePageShouldHandleShiftAndArrows() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "3E2D94C4B65D499B7F64E283EFCE2180")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativePointInNavCache(int x, int y, int slop) {
        dsTaint.addTaint(slop);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "E499406226A6497B445A4F711DBE2366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeResetSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "336415877E033E79094AFA16F0936DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Point nativeSelectableText() {
    	return new Point();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "EB11EC3EFE693B0DB223E956F8B5673D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "A8E1C3B860648195CCD1EE1096D0CC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectBestAt(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "C83EDA1465DA715BAC56143D2832AFF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectAt(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "938A95D25873B7A9A566FE622A86D6DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeSelectionX() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "53517374AF117E596CE44B7675FE3B02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeSelectionY() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "0BCA085AEB0D28A00A7E0429DE300072")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFindIndex() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "2090464FC7EC84B5AC40C5E63EEF9B94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetExtendSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "ACF76AB508EA0B9B7AF646460B676204")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetFindIsEmpty() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "5D613AB4B27443ECA04B2880748CC777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetFindIsUp(boolean isUp) {
        dsTaint.addTaint(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.379 -0400", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "FA5E5F97B3463D0CC416284292E07235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetHeightCanMeasure(boolean measure) {
        dsTaint.addTaint(measure);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "3E58945266FE972D1344F63C000862B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetBaseLayer(int layer, Region invalRegion,
            boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
            boolean registerPageSwapCallback) {
        dsTaint.addTaint(layer);
        dsTaint.addTaint(showVisualIndicator);
        dsTaint.addTaint(isPictureAfterFirstLayout);
        dsTaint.addTaint(invalRegion.dsTaint);
        dsTaint.addTaint(registerPageSwapCallback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "76BA6B93FD2D52A61A3933FAFCFFCAF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetBaseLayer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "EFD615BAA2395910FB9A3410424E2D1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeShowCursorTimed() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "9BBAE42C15D885DCE10A6312E5AE8A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeReplaceBaseContent(int content) {
        dsTaint.addTaint(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "EA73924720CE9B861639D16883ACAC27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCopyBaseContentToPicture(Picture pict) {
        dsTaint.addTaint(pict.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "EBDADF454F6EF1688E6D476894DB3F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasContent() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "6B1FA76D0AAEE81B16F3E6D02B3CF916")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetSelectionPointer(int nativeInstance,
            boolean set, float scale, int x, int y) {
        dsTaint.addTaint(nativeInstance);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(set);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "6A6B9A0F3E38BA8B692B17314F6CE436")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeStartSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "84F8C85789D14D5CA68412A43B173601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeStopGL() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "EA79FD5B8238E5DF83C8F39E78D9CD86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeSubtractLayers(Rect content) {
        dsTaint.addTaint(content.dsTaint);
    	Rect ret = new Rect();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "1D26C81D307C8A8EC2B0F3435959B469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTextGeneration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "68A271C29A05126109ECA7FBE2EB8A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRegisterPageSwapCallback() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "2219A26EC7A9F04542BB2B43A8DAE509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTileProfilingStart() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "C983B7B5F0B7731C3D66DF4FF67E3ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float nativeTileProfilingStop() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "A6ADDD0F57581D7A1E4A3B5847F245AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTileProfilingClear() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "3DD1D6B08BB10FDE9BA785E44CC957AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingNumFrames() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "1FDBDB1CF00D2A5A70E5E98BC7A797C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingNumTilesInFrame(int frame) {
        dsTaint.addTaint(frame);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "2E69182D4FC9F692206984D982E63568")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingGetInt(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "EA11A6593212F7848A6DBE5093E7212D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float nativeTileProfilingGetFloat(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "CF78D846D3F2A5BEBF0218E462ACEAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateCachedTextfield(String updatedText,
            int generation) {
        dsTaint.addTaint(updatedText);
        dsTaint.addTaint(generation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "B53CC0CB197592CD675BC03092D36FC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeWordSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "7CA4AC5B17936805E1E23B3D12641963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeGetBlockLeftEdge(int x, int y, float scale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "D648E743AE3291A9AFAFF77D52E116FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUseHardwareAccelSkia(boolean enabled) {
        dsTaint.addTaint(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "FAD900CFA7B6F0F14467B9E0A2FB6BD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeScrollableLayer(int x, int y, Rect scrollRect,
            Rect scrollBounds) {
        dsTaint.addTaint(scrollRect.dsTaint);
        dsTaint.addTaint(scrollBounds.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "0EEE63B11F01F1FD220FFB91A3B8F191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeScrollLayer(int layer, int newX, int newY) {
        dsTaint.addTaint(layer);
        dsTaint.addTaint(newX);
        dsTaint.addTaint(newY);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "38B572426D5D82E0CB1371D8E4F7EEF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetIsScrolling(boolean isScrolling) {
        dsTaint.addTaint(isScrolling);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "65891674C01C763976D29ADC26FD3F96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetBackgroundColor() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "16561A235A976A32B8A1343AD2693F3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeSetProperty(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "673CF412317E63980A202E58D1BC22F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String nativeGetProperty(String key) {
        dsTaint.addTaint(key);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "729E1FFD2AE38127850B1476620A9E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetTextSelectionRegion(int instance, Region region) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "4AEA6CED5535075BA6B612032EA61B87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetSelectionHandles(int instance, int[] handles) {
        dsTaint.addTaint(instance);
        dsTaint.addTaint(handles);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.380 -0400", hash_original_method = "3914688BC2C608012BB2A11771B543D9", hash_generated_method = "CB5EB2C337461A5AC8919AC12E2D43B7")
    private static void nativeOnTrimMemory(int level) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "40CAAA20A745B5C9918EDBEB33AE6FA6", hash_generated_method = "EC57F2253188ECA0A3B2B7003085B4F4")
    private static void nativeSetPauseDrawing(int instance, boolean pause) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "03B1FB241091128CC3C429E8FE2AB249")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_1138194929 = (isShown());
                {
                    setGLRectViewport();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    private class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "24F519E59EB4D1D4AB1D6154ACC32079")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_57988001 = (isShown());
                {
                    setGLRectViewport();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    public class WebViewTransport {
        private WebView mWebview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "E509447752057714AB051F9ABCD81ACA")
        @DSModeled(DSC.SAFE)
        public synchronized void setWebView(WebView webview) {
            dsTaint.addTaint(webview.dsTaint);
            // ---------- Original Method ----------
            //mWebview = webview;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "B7758A42BD6DA62CC3402455C8046A7B")
        @DSModeled(DSC.SAFE)
        public synchronized WebView getWebView() {
            return (WebView)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mWebview;
        }

        
    }


    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {
        private static OnTrimMemoryListener sInstance = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "A03B586D7924C2D7E70A3C5F98A8EA03")
        @DSModeled(DSC.SAFE)
        private OnTrimMemoryListener(Context c) {
            dsTaint.addTaint(c.dsTaint);
            c.registerComponentCallbacks(this);
            // ---------- Original Method ----------
            //c.registerComponentCallbacks(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "A91E534521EB4B302FD27148495CE212", hash_generated_method = "B52429BAC91BFECA544DA731B89A962C")
        static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "C319606098DB97B0AFF743F5205959C0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(newConfig.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "48D253603C0D3E8EF6505071C930F079")
        @DSModeled(DSC.SAFE)
        @Override
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "23363D626CA2F6533B3FA8E9BB87A08E")
        @DSModeled(DSC.SAFE)
        @Override
        public void onTrimMemory(int level) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(level);
            {
                Log.d("WebView", "onTrimMemory: " + level);
            } //End block
            WebView.nativeOnTrimMemory(level);
            // ---------- Original Method ----------
            //if (DebugFlags.WEB_VIEW) {
                //Log.d("WebView", "onTrimMemory: " + level);
            //}
            //WebView.nativeOnTrimMemory(level);
        }

        
    }


    
    public class HitTestResult {
        public static final int UNKNOWN_TYPE = 0;
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int PHONE_TYPE = 2;
        public static final int GEO_TYPE = 3;
        public static final int EMAIL_TYPE = 4;
        public static final int IMAGE_TYPE = 5;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int EDIT_TEXT_TYPE = 9;
        private int mType;
        private String mExtra;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "C019530CA09DDAD8B3B21170AF19DCF0")
        @DSModeled(DSC.SAFE)
         HitTestResult() {
            mType = UNKNOWN_TYPE;
            // ---------- Original Method ----------
            //mType = UNKNOWN_TYPE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "B7EC6ED91844C46A1045D9E61BEBC66C")
        @DSModeled(DSC.SAFE)
        private void setType(int type) {
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //mType = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "4206DE27ABB73B03AEBA168A7F620A71")
        @DSModeled(DSC.SAFE)
        private void setExtra(String extra) {
            dsTaint.addTaint(extra);
            // ---------- Original Method ----------
            //mExtra = extra;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "E6C0F4DA24DEB386955E797B464A5714")
        @DSModeled(DSC.SAFE)
        public int getType() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "E282C28ECBCF44F8ABE2BA3BD58C4135")
        @DSModeled(DSC.SAFE)
        public String getExtra() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mExtra;
        }

        
    }


    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.381 -0400", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "46DE011A7B87F12ED96593634E4C52EB")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean var5A158AEAA9529F1AFE9F1BFAB51F2DA9_1770367576 = (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION));
                {
                    handleProxyBroadcast(intent);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION)) {
                //handleProxyBroadcast(intent);
            //}
        }

        
    }


    
    private static class PackageListener extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "033C820ED87779584E35FD548C9A5ACE")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            final String action;
            action = intent.getAction();
            final String packageName;
            packageName = intent.getData().getSchemeSpecificPart();
            final boolean replacing;
            replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
            {
                boolean varFF4619C38D73ED134292A51CFC6DAD56_414911801 = (Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing);
            } //End collapsed parenthetic
            {
                boolean varF3A5A3941CCE4017F61B8223025B4DC2_1702786128 = (sGoogleApps.contains(packageName));
                {
                    {
                        boolean var37328E8572988711DFAEB7B421756EDC_1341695518 = (Intent.ACTION_PACKAGE_ADDED.equals(action));
                        {
                            WebViewCore.sendStaticMessage(EventHub.ADD_PACKAGE_NAME, packageName);
                        } //End block
                        {
                            WebViewCore.sendStaticMessage(EventHub.REMOVE_PACKAGE_NAME, packageName);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            PluginManager pm;
            pm = PluginManager.getInstance(context);
            {
                boolean varB1BC6389427C1315076A84D35B8A1EAF_594195633 = (pm.containsPluginPermissionAndSignatures(packageName));
                {
                    pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class SaveWebArchiveMessage {
        /*final*/ String mBasename;
        /*final*/ boolean mAutoname;
        /*final*/ ValueCallback<String> mCallback;
        String mResultFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "09CEB4687F0432150E16BEE10A2ED104")
        @DSModeled(DSC.SAFE)
         SaveWebArchiveMessage(String basename, boolean autoname, ValueCallback<String> callback) {
            dsTaint.addTaint(basename);
            dsTaint.addTaint(autoname);
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
            //mBasename = basename;
            //mAutoname = autoname;
            //mCallback = callback;
        }

        
    }


    
    static class ViewSizeData {
        int mWidth;
        int mHeight;
        float mHeightWidthRatio;
        int mActualViewHeight;
        int mTextWrapWidth;
        int mAnchorX;
        int mAnchorY;
        float mScale;
        boolean mIgnoreHeight;
        
    }


    
    private class RequestFormData implements Runnable {
        private String mName;
        private String mUrl;
        private Message mUpdateMessage;
        private boolean mAutoFillable;
        private boolean mAutoComplete;
        private WebSettings mWebSettings;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "DC012BC6F0F2A24C28894D6F986AFBE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RequestFormData(String name, String url, Message msg,
                boolean autoFillable, boolean autoComplete) {
            dsTaint.addTaint(autoComplete);
            dsTaint.addTaint(name);
            dsTaint.addTaint(autoFillable);
            dsTaint.addTaint(msg.dsTaint);
            dsTaint.addTaint(url);
            mUrl = WebTextView.urlForAutoCompleteData(url);
            mWebSettings = getSettings();
            // ---------- Original Method ----------
            //mName = name;
            //mUrl = WebTextView.urlForAutoCompleteData(url);
            //mUpdateMessage = msg;
            //mAutoFillable = autoFillable;
            //mAutoComplete = autoComplete;
            //mWebSettings = getSettings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "9A774FBCDADE21328E8B213841539B18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ArrayList<String> pastEntries;
            pastEntries = new ArrayList<String>();
            {
                {
                    boolean var5288C74084AF99D20729B6F53A54E232_1794441719 = (mWebSettings != null && mWebSettings.getAutoFillProfile() != null);
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.autofill_this_form).toString() +
                            " " +
                            mAutoFillData.getPreviewString());
                        mWebTextView.setAutoFillProfileIsSet(true);
                    } //End block
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.setup_autofill).toString());
                        mWebTextView.setAutoFillProfileIsSet(false);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                pastEntries.addAll(mDatabase.getFormData(mUrl, mName));
            } //End block
            {
                boolean var3F0C3C91772BA4E0AAA044D02E105F29_654947393 = (pastEntries.size() > 0);
                {
                    AutoCompleteAdapter adapter;
                    adapter = new
                        AutoCompleteAdapter(mContext, pastEntries);
                    mUpdateMessage.obj = adapter;
                    mUpdateMessage.sendToTarget();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class QueuedTouch {
        long mSequence;
        MotionEvent mEvent;
        TouchEventData mTed;
        QueuedTouch mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "C3D42C14B0E3D4C7212ABA04296D6FA6")
        @DSModeled(DSC.SAFE)
        public QueuedTouch set(TouchEventData ted) {
            dsTaint.addTaint(ted.dsTaint);
            mSequence = ted.mSequence;
            mEvent = null;
            mNext = null;
            return (QueuedTouch)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mSequence = ted.mSequence;
            //mTed = ted;
            //mEvent = null;
            //mNext = null;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "C65BA06469F32AB60B846669D1DE4CDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public QueuedTouch set(MotionEvent ev, long sequence) {
            dsTaint.addTaint(ev.dsTaint);
            dsTaint.addTaint(sequence);
            mEvent = MotionEvent.obtain(ev);
            mTed = null;
            mNext = null;
            return (QueuedTouch)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mEvent = MotionEvent.obtain(ev);
            //mSequence = sequence;
            //mTed = null;
            //mNext = null;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.382 -0400", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "65D5F190B893F686E153FD53932C7D9C")
        @DSModeled(DSC.SAFE)
        public QueuedTouch add(QueuedTouch other) {
            dsTaint.addTaint(other.dsTaint);
            {
                other.mNext = this;
            } //End block
            QueuedTouch insertAt;
            insertAt = this;
            {
                insertAt = insertAt.mNext;
            } //End block
            other.mNext = insertAt.mNext;
            insertAt.mNext = other;
            return (QueuedTouch)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (other.mSequence < mSequence) {
                //other.mNext = this;
                //return other;
            //}
            //QueuedTouch insertAt = this;
            //while (insertAt.mNext != null && insertAt.mNext.mSequence < other.mSequence) {
                //insertAt = insertAt.mNext;
            //}
            //other.mNext = insertAt.mNext;
            //insertAt.mNext = other;
            //return this;
        }

        
    }


    
    private class TouchEventQueue {
        private long mNextTouchSequence = Long.MIN_VALUE + 1;
        private long mLastHandledTouchSequence = Long.MIN_VALUE;
        private long mIgnoreUntilSequence = Long.MIN_VALUE + 1;
        private QueuedTouch mTouchEventQueue;
        private QueuedTouch mPreQueue;
        private QueuedTouch mQueuedTouchRecycleBin;
        private int mQueuedTouchRecycleCount;
        private long mLastEventTime = Long.MAX_VALUE;
        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "8851A17C023BD5127C9B1478AE4B58A9")
        @DSModeled(DSC.SAFE)
        private QueuedTouch obtainQueuedTouch() {
            {
                QueuedTouch result;
                result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
                mQueuedTouchRecycleCount--;
            } //End block
            return (QueuedTouch)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleBin != null) {
                //QueuedTouch result = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = result.mNext;
                //mQueuedTouchRecycleCount--;
                //return result;
            //}
            //return new QueuedTouch();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "0A2AC870A43557EFEA532DF82AE032CC")
        @DSModeled(DSC.SAFE)
        public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
            // ---------- Original Method ----------
            //mIgnoreUntilSequence = mNextTouchSequence;
            //runQueuedAndPreQueuedEvents();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "733E4ECDFDD4A61D329BB5949671546E")
        @DSModeled(DSC.SAFE)
        private void runQueuedAndPreQueuedEvents() {
            QueuedTouch qd;
            qd = mPreQueue;
            boolean fromPreQueue;
            fromPreQueue = true;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe;
                recycleMe = qd;
                {
                    mPreQueue = qd.mNext;
                } //End block
                {
                    mTouchEventQueue = qd.mNext;
                } //End block
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;
                long nextPre;
                nextPre = mPreQueue.mSequence;
                nextPre = Long.MAX_VALUE;
                long nextQueued;
                nextQueued = mTouchEventQueue.mSequence;
                nextQueued = Long.MAX_VALUE;
                fromPreQueue = nextPre < nextQueued;
                qd = fromPreQueue ? mPreQueue : mTouchEventQueue;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "3B88A37C57CDF37FD47D1754128C08E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void preQueueTouchEventData(TouchEventData ted) {
            dsTaint.addTaint(ted.dsTaint);
            QueuedTouch newTouch;
            newTouch = obtainQueuedTouch().set(ted);
            {
                mPreQueue = newTouch;
            } //End block
            {
                QueuedTouch insertionPoint;
                insertionPoint = mPreQueue;
                {
                    insertionPoint = insertionPoint.mNext;
                } //End block
                newTouch.mNext = insertionPoint.mNext;
                insertionPoint.mNext = newTouch;
            } //End block
            // ---------- Original Method ----------
            //QueuedTouch newTouch = obtainQueuedTouch().set(ted);
            //if (mPreQueue == null) {
                //mPreQueue = newTouch;
            //} else {
                //QueuedTouch insertionPoint = mPreQueue;
                //while (insertionPoint.mNext != null &&
                        //insertionPoint.mNext.mSequence < newTouch.mSequence) {
                    //insertionPoint = insertionPoint.mNext;
                //}
                //newTouch.mNext = insertionPoint.mNext;
                //insertionPoint.mNext = newTouch;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "EE05EA30CF2F1BC45688B011F19576A2")
        @DSModeled(DSC.SAFE)
        private void recycleQueuedTouch(QueuedTouch qd) {
            dsTaint.addTaint(qd.dsTaint);
            {
                qd.mNext = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleCount++;
            } //End block
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH) {
                //qd.mNext = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = qd;
                //mQueuedTouchRecycleCount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "F091EF7C4632F89747D7816503A33DF7")
        @DSModeled(DSC.SAFE)
        public void reset() {
            mNextTouchSequence = Long.MIN_VALUE + 1;
            mLastHandledTouchSequence = Long.MIN_VALUE;
            mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            {
                QueuedTouch recycleMe;
                recycleMe = mTouchEventQueue;
                mTouchEventQueue = mTouchEventQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            {
                QueuedTouch recycleMe;
                recycleMe = mPreQueue;
                mPreQueue = mPreQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            // ---------- Original Method ----------
            //mNextTouchSequence = Long.MIN_VALUE + 1;
            //mLastHandledTouchSequence = Long.MIN_VALUE;
            //mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            //while (mTouchEventQueue != null) {
                //QueuedTouch recycleMe = mTouchEventQueue;
                //mTouchEventQueue = mTouchEventQueue.mNext;
                //recycleQueuedTouch(recycleMe);
            //}
            //while (mPreQueue != null) {
                //QueuedTouch recycleMe = mPreQueue;
                //mPreQueue = mPreQueue.mNext;
                //recycleQueuedTouch(recycleMe);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.383 -0400", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "40B796FDEAC9534A2017B79629347753")
        @DSModeled(DSC.SAFE)
        public long nextTouchSequence() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mNextTouchSequence++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.384 -0400", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "A9C98254A2F92D44232AEB307F56550A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean enqueueTouchEvent(TouchEventData ted) {
            dsTaint.addTaint(ted.dsTaint);
            QueuedTouch preQueue;
            preQueue = mPreQueue;
            {
                {
                    mPreQueue = preQueue.mNext;
                } //End block
                {
                    QueuedTouch prev;
                    prev = preQueue;
                    preQueue = null;
                    {
                        {
                            preQueue = prev.mNext;
                            prev.mNext = preQueue.mNext;
                        } //End block
                        {
                            prev = prev.mNext;
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                boolean varBE43CED5DAEAE4AB789CEEFCCB879ABB_126055204 = (dropStaleGestures(ted.mMotionEvent, ted.mSequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                } //End block
                handleQueuedTouchEventData(ted);
                mLastHandledTouchSequence++;
                runNextQueuedEvents();
            } //End block
            {
                QueuedTouch qd;
                qd = preQueue;
                qd = obtainQueuedTouch().set(ted);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.384 -0400", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "C1A3B208407D25704F124185BBB23CC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void enqueueTouchEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            final long sequence;
            sequence = nextTouchSequence();
            {
                boolean varC743B531629C8022D99C282BCE55BA59_777364237 = (dropStaleGestures(ev, sequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                handleQueuedMotionEvent(ev);
                mLastHandledTouchSequence++;
                runNextQueuedEvents();
            } //End block
            {
                QueuedTouch qd;
                qd = obtainQueuedTouch().set(ev, sequence);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
            // ---------- Original Method ----------
            //final long sequence = nextTouchSequence();
            //if (dropStaleGestures(ev, sequence)) {
                //return;
            //}
            //runNextQueuedEvents();
            //if (mLastHandledTouchSequence + 1 == sequence) {
                //handleQueuedMotionEvent(ev);
                //mLastHandledTouchSequence++;
                //runNextQueuedEvents();
            //} else {
                //QueuedTouch qd = obtainQueuedTouch().set(ev, sequence);
                //mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.384 -0400", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "303E1B7DFABFC0B063B7B8F3B00E9051")
        @DSModeled(DSC.SAFE)
        private void runNextQueuedEvents() {
            QueuedTouch qd;
            qd = mTouchEventQueue;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe;
                recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;
            } //End block
            mTouchEventQueue = qd;
            // ---------- Original Method ----------
            //QueuedTouch qd = mTouchEventQueue;
            //while (qd != null && qd.mSequence == mLastHandledTouchSequence + 1) {
                //handleQueuedTouch(qd);
                //QueuedTouch recycleMe = qd;
                //qd = qd.mNext;
                //recycleQueuedTouch(recycleMe);
                //mLastHandledTouchSequence++;
            //}
            //mTouchEventQueue = qd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.384 -0400", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "ACE438C8987C01C448AEA533BDD1EA81")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            dsTaint.addTaint(ev.dsTaint);
            dsTaint.addTaint(sequence);
            {
                boolean var6660B004F1AFFBD2AD367F81FA8A8ECB_1191329547 = (ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove);
                {
                    final int dx;
                    dx = Math.round(ev.getX()) - mLastTouchX;
                    final int dy;
                    dy = Math.round(ev.getY()) - mLastTouchY;
                    {
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDD96473448E99D0068A310672554EE17_1080524407 = (ev != null && ev.getAction() == MotionEvent.ACTION_DOWN);
                {
                    long eventTime;
                    eventTime = ev.getEventTime();
                    long lastHandledEventTime;
                    lastHandledEventTime = mLastEventTime;
                    {
                        runQueuedAndPreQueuedEvents();
                        QueuedTouch qd;
                        qd = mTouchEventQueue;
                        {
                            QueuedTouch recycleMe;
                            recycleMe = qd;
                            qd = qd.mNext;
                            recycleQueuedTouch(recycleMe);
                        } //End block
                        mTouchEventQueue = qd;
                        mLastHandledTouchSequence = sequence - 1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                QueuedTouch qd;
                qd = mTouchEventQueue;
                {
                    QueuedTouch recycleMe;
                    recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mTouchEventQueue = qd;
                mLastHandledTouchSequence = mIgnoreUntilSequence - 1;
            } //End block
            {
                QueuedTouch qd;
                qd = mPreQueue;
                {
                    QueuedTouch recycleMe;
                    recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mPreQueue = qd;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.384 -0400", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "0AE1B97217DC1D3041159A54A857A28F")
        @DSModeled(DSC.SAFE)
        private void handleQueuedTouch(QueuedTouch qt) {
            dsTaint.addTaint(qt.dsTaint);
            {
                handleQueuedTouchEventData(qt.mTed);
            } //End block
            {
                handleQueuedMotionEvent(qt.mEvent);
                qt.mEvent.recycle();
            } //End block
            // ---------- Original Method ----------
            //if (qt.mTed != null) {
                //handleQueuedTouchEventData(qt.mTed);
            //} else {
                //handleQueuedMotionEvent(qt.mEvent);
                //qt.mEvent.recycle();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.385 -0400", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "826BB77F6B9F30B199D7BC6E8E894DF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void handleQueuedMotionEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            mLastEventTime = ev.getEventTime();
            int action;
            action = ev.getActionMasked();
            {
                boolean var5547CC292C3C07AC5E49CBFC5588305F_991013965 = (ev.getPointerCount() > 1);
                {
                    handleMultiTouchInWebView(ev);
                } //End block
                {
                    final ScaleGestureDetector detector;
                    detector = mZoomManager.getMultiTouchGestureDetector();
                    {
                        detector.onTouchEvent(ev);
                    } //End block
                    handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mLastEventTime = ev.getEventTime();
            //int action = ev.getActionMasked();
            //if (ev.getPointerCount() > 1) {  
                //handleMultiTouchInWebView(ev);
            //} else {
                //final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                //if (detector != null && mPreventDefault != PREVENT_DEFAULT_YES) {
                    //detector.onTouchEvent(ev);
                //}
                //handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.385 -0400", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "D7125C8A163B8C5E3679D756B85FA066")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void handleQueuedTouchEventData(TouchEventData ted) {
            dsTaint.addTaint(ted.dsTaint);
            {
                mLastEventTime = ted.mMotionEvent.getEventTime();
            } //End block
            {
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN;
                } //End block
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO;
                } //End block
                {
                    mTouchHighlightRegion.setEmpty();
                } //End block
            } //End block
            {
                {
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                        handleMultiTouchInWebView(ted.mMotionEvent);
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } //End block
                } //End block
                {
                    //Begin case MotionEvent.ACTION_DOWN 
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_DOWN 
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_DOWN 
                    mDeferTouchMode = TOUCH_INIT_MODE;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_MOVE 
                    {
                        int x;
                        x = ted.mPointsInView[0].x;
                        int y;
                        y = ted.mPointsInView[0].y;
                        {
                            mDeferTouchMode = TOUCH_DRAG_MODE;
                            mLastDeferTouchX = x;
                            mLastDeferTouchY = y;
                            startScrollingLayer(x, y);
                            startDrag();
                        } //End block
                        int deltaX;
                        deltaX = pinLocX((int) (mScrollX
                                    + mLastDeferTouchX - x))
                                    - mScrollX;
                        int deltaY;
                        deltaY = pinLocY((int) (mScrollY
                                    + mLastDeferTouchY - y))
                                    - mScrollY;
                        doDrag(deltaX, deltaY);
                        mLastDeferTouchX = x;
                        mLastDeferTouchY = y;
                    } //End block
                    //End case MotionEvent.ACTION_MOVE 
                    //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    {
                        mScroller.springBack(mScrollX, mScrollY, 0,
                                        computeMaxScrollX(), 0,
                                        computeMaxScrollY());
                        invalidate();
                        WebViewCore.resumePriority();
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    } //End block
                    //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    HitTestResult hitTest;
                    hitTest = getHitTestResult();
                    //End case WebViewCore.ACTION_LONGPRESS 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    {
                        performLongClick();
                    } //End block
                    //End case WebViewCore.ACTION_LONGPRESS 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case WebViewCore.ACTION_LONGPRESS 
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.388 -0400", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "940961646066783E0F69A2F34EE5CA86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case REMEMBER_PASSWORD 
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"),
                            msg.getData().getString("username"),
                            msg.getData().getString("password"));
                ((Message) msg.obj).sendToTarget();
            } //End block
            //End case REMEMBER_PASSWORD 
            //Begin case NEVER_REMEMBER_PASSWORD 
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"), null, null);
                ((Message) msg.obj).sendToTarget();
            } //End block
            //End case NEVER_REMEMBER_PASSWORD 
            //Begin case PREVENT_DEFAULT_TIMEOUT 
            {
                {
                    cancelWebCoreTouchEvent(
                                viewToContentX(mLastTouchX + mScrollX),
                                viewToContentY(mLastTouchY + mScrollY),
                                true);
                } //End block
            } //End block
            //End case PREVENT_DEFAULT_TIMEOUT 
            //Begin case SCROLL_SELECT_TEXT 
            {
                {
                    mSentAutoScrollMessage = false;
                } //End block
                {
                    pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                } //End block
                {
                    scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX,
                                mScrollingLayerRect.top + mAutoScrollY);
                } //End block
                sendEmptyMessageDelayed(
                            SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
            } //End block
            //End case SCROLL_SELECT_TEXT 
            //Begin case UPDATE_SELECTION 
            {
                {
                    updateSelection();
                } //End block
            } //End block
            //End case UPDATE_SELECTION 
            //Begin case SWITCH_TO_SHORTPRESS 
            {
                mInitialHitTestResult = null;
                {
                    {
                        boolean var8FF10029C08AB4FC7C05FF2A261CB23D_1589385981 = (!getSettings().supportTouchOnly()
                                && mPreventDefault != PREVENT_DEFAULT_YES);
                        {
                            mTouchMode = TOUCH_SHORTPRESS_START_MODE;
                            updateSelection();
                        } //End block
                        {
                            mTouchMode = TOUCH_SHORTPRESS_MODE;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mTouchMode = TOUCH_DONE_MODE;
                } //End block
            } //End block
            //End case SWITCH_TO_SHORTPRESS 
            //Begin case SWITCH_TO_LONGPRESS 
            {
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_2082319364 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_2143230787 = (inFullScreenMode() || mDeferTouchProcess);
                    {
                        TouchEventData ted;
                        ted = new TouchEventData();
                        ted.mAction = WebViewCore.ACTION_LONGPRESS;
                        ted.mIds = new int[1];
                        ted.mIds[0] = 0;
                        ted.mPoints = new Point[1];
                        ted.mPoints[0] = new Point(viewToContentX(mLastTouchX + mScrollX),
                                                   viewToContentY(mLastTouchY + mScrollY));
                        ted.mPointsInView = new Point[1];
                        ted.mPointsInView[0] = new Point(mLastTouchX, mLastTouchY);
                        ted.mMetaState = 0;
                        ted.mReprocess = mDeferTouchProcess;
                        ted.mNativeLayer = nativeScrollableLayer(
                                ted.mPoints[0].x, ted.mPoints[0].y,
                                ted.mNativeLayerRect, null);
                        ted.mSequence = mTouchEventQueue.nextTouchSequence();
                        mTouchEventQueue.preQueueTouchEventData(ted);
                        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                    } //End block
                    {
                        mTouchMode = TOUCH_DONE_MODE;
                        performLongClick();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case SWITCH_TO_LONGPRESS 
            //Begin case RELEASE_SINGLE_TAP 
            {
                doShortPress();
            } //End block
            //End case RELEASE_SINGLE_TAP 
            //Begin case SCROLL_TO_MSG_ID 
            {
                {
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        boolean varC08B8A0171CF85CA13986B7A742C9FAC_1507826464 = (imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView))));
                    } //End collapsed parenthetic
                } //End block
                final Point p;
                p = (Point) msg.obj;
                {
                    spawnContentScrollTo(p.x, p.y);
                } //End block
                {
                    setContentScrollTo(p.x, p.y);
                } //End block
            } //End block
            //End case SCROLL_TO_MSG_ID 
            //Begin case UPDATE_ZOOM_RANGE 
            {
                WebViewCore.ViewState viewState;
                viewState = (WebViewCore.ViewState) msg.obj;
                mZoomManager.updateZoomRange(viewState, getViewWidth(), viewState.mScrollX);
            } //End block
            //End case UPDATE_ZOOM_RANGE 
            //Begin case UPDATE_ZOOM_DENSITY 
            {
                final float density;
                density = (Float) msg.obj;
                mZoomManager.updateDefaultZoomDensity(density);
            } //End block
            //End case UPDATE_ZOOM_DENSITY 
            //Begin case REPLACE_BASE_CONTENT 
            {
                nativeReplaceBaseContent(msg.arg1);
            } //End block
            //End case REPLACE_BASE_CONTENT 
            //Begin case NEW_PICTURE_MSG_ID 
            {
                final WebViewCore.DrawData draw;
                draw = (WebViewCore.DrawData) msg.obj;
                setNewPicture(draw, true);
            } //End block
            //End case NEW_PICTURE_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            String drawableDir;
            drawableDir = BrowserFrame.getRawResFilename(
                            BrowserFrame.DRAWABLEDIR, mContext);
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            WindowManager windowManager;
            windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            Display display;
            display = windowManager.getDefaultDisplay();
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            nativeCreate(msg.arg1, drawableDir,
                            ActivityManager.isHighEndGfx(display));
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            {
                setNewPicture(mDelaySetPicture, true);
                mDelaySetPicture = null;
            } //End block
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case UPDATE_TEXTFIELD_TEXT_MSG_ID 
            {
                boolean var24ED917A45E165B2D0DB73D1C228849D_1510421860 = (inEditingMode() &&
                            mWebTextView.isSameTextField(msg.arg1));
                {
                    {
                        String text;
                        text = (String) msg.obj;
                        {
                            text = "";
                        } //End block
                        mWebTextView.setTextAndKeepSelection(text);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //End case UPDATE_TEXTFIELD_TEXT_MSG_ID 
            //Begin case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID 
            displaySoftKeyboard(true);
            //End case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID 
            //Begin case UPDATE_TEXT_SELECTION_MSG_ID 
            updateTextSelectionFromMessage(msg.arg1, msg.arg2,
                            (WebViewCore.TextSelectionData) msg.obj);
            //End case UPDATE_TEXT_SELECTION_MSG_ID 
            //Begin case FORM_DID_BLUR 
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_442723115 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    hideSoftKeyboard();
                } //End block
            } //End collapsed parenthetic
            //End case FORM_DID_BLUR 
            //Begin case RETURN_LABEL 
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1619192245 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setHint((String) msg.obj);
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        boolean varE86969381D8E084EE7486B0BCDFB9761_646663619 = (imm != null && imm.isActive(mWebTextView));
                        {
                            imm.restartInput(mWebTextView);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case RETURN_LABEL 
            //Begin case UNHANDLED_NAV_KEY 
            navHandledKey(msg.arg1, 1, false, 0);
            //End case UNHANDLED_NAV_KEY 
            //Begin case UPDATE_TEXT_ENTRY_MSG_ID 
            {
                boolean var0513EDBB647F1B1B0CEC2398CB7258CB_2145910487 = (inEditingMode() && nativeCursorIsTextInput());
                {
                    updateWebTextViewPosition();
                } //End block
            } //End collapsed parenthetic
            //End case UPDATE_TEXT_ENTRY_MSG_ID 
            //Begin case CLEAR_TEXT_ENTRY 
            clearTextEntry();
            //End case CLEAR_TEXT_ENTRY 
            //Begin case INVAL_RECT_MSG_ID 
            {
                Rect r;
                r = (Rect)msg.obj;
                {
                    invalidate();
                } //End block
                {
                    viewInvalidate(r.left, r.top, r.right, r.bottom);
                } //End block
            } //End block
            //End case INVAL_RECT_MSG_ID 
            //Begin case REQUEST_FORM_DATA 
            AutoCompleteAdapter adapter;
            adapter = (AutoCompleteAdapter) msg.obj;
            //End case REQUEST_FORM_DATA 
            //Begin case REQUEST_FORM_DATA 
            {
                boolean var543595A323B4887B7F3AF5971C508703_1333623062 = (mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setAdapterCustom(adapter);
                } //End block
            } //End collapsed parenthetic
            //End case REQUEST_FORM_DATA 
            //Begin case LONG_PRESS_CENTER 
            mGotCenterDown = false;
            //End case LONG_PRESS_CENTER 
            //Begin case LONG_PRESS_CENTER 
            mTrackballDown = false;
            //End case LONG_PRESS_CENTER 
            //Begin case LONG_PRESS_CENTER 
            performLongClick();
            //End case LONG_PRESS_CENTER 
            //Begin case WEBCORE_NEED_TOUCH_EVENTS 
            mForwardTouchEvents = (msg.arg1 != 0);
            //End case WEBCORE_NEED_TOUCH_EVENTS 
            //Begin case PREVENT_TOUCH_ID 
            {
                boolean varA9995E2AE703E9AF13E24802C20B989A_1239016274 = (inFullScreenMode());
            } //End collapsed parenthetic
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            TouchEventData ted;
            ted = (TouchEventData) msg.obj;
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            {
                boolean var25F0555089CC470A412F802E26A1BE83_1427759231 = (mTouchEventQueue.enqueueTouchEvent(ted));
                {
                    removeMessages(PREVENT_DEFAULT_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
            //End case PREVENT_TOUCH_ID 
            //Begin case REQUEST_KEYBOARD 
            {
                hideSoftKeyboard();
            } //End block
            {
                displaySoftKeyboard(false);
            } //End block
            //End case REQUEST_KEYBOARD 
            //Begin case FIND_AGAIN 
            {
                mFindCallback.findAll();
            } //End block
            //End case FIND_AGAIN 
            //Begin case DRAG_HELD_MOTIONLESS 
            mHeldMotionless = MOTIONLESS_TRUE;
            //End case DRAG_HELD_MOTIONLESS 
            //Begin case DRAG_HELD_MOTIONLESS 
            invalidate();
            //End case DRAG_HELD_MOTIONLESS 
            //Begin case AWAKEN_SCROLL_BARS 
            {
                awakenScrollBars(ViewConfiguration
                                .getScrollDefaultDelay(), false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(AWAKEN_SCROLL_BARS),
                                ViewConfiguration.getScrollDefaultDelay());
            } //End block
            //End case AWAKEN_SCROLL_BARS 
            //Begin case DO_MOTION_UP 
            doMotionUp(msg.arg1, msg.arg2);
            //End case DO_MOTION_UP 
            //Begin case SCREEN_ON 
            setKeepScreenOn(msg.arg1 == 1);
            //End case SCREEN_ON 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            int layerId;
            layerId = msg.arg1;
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            String url;
            url = (String) msg.obj;
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            {
                mHTML5VideoViewProxy.enterFullScreenVideo(layerId, url);
            } //End block
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case SHOW_FULLSCREEN 
            {
                View view;
                view = (View) msg.obj;
                int orientation;
                orientation = msg.arg1;
                int npp;
                npp = msg.arg2;
                {
                    boolean var193BD8982A9C597816FCA9FE1F0F7BC4_1144637800 = (inFullScreenMode());
                    {
                        dismissFullScreenMode();
                    } //End block
                } //End collapsed parenthetic
                mFullScreenHolder = new PluginFullScreenHolder(WebView.this, orientation, npp);
                mFullScreenHolder.setContentView(view);
                mFullScreenHolder.show();
            } //End block
            //End case SHOW_FULLSCREEN 
            //Begin case HIDE_FULLSCREEN 
            dismissFullScreenMode();
            //End case HIDE_FULLSCREEN 
            //Begin case DOM_FOCUS_CHANGED 
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_2082416430 = (inEditingMode());
                {
                    nativeClearCursor();
                    rebuildWebTextView();
                } //End block
            } //End collapsed parenthetic
            //End case DOM_FOCUS_CHANGED 
            //Begin case SHOW_RECT_MSG_ID 
            {
                WebViewCore.ShowRectData data;
                data = (WebViewCore.ShowRectData) msg.obj;
                int x;
                x = mScrollX;
                int left;
                left = contentToViewX(data.mLeft);
                int width;
                width = contentToViewDimension(data.mWidth);
                int maxWidth;
                maxWidth = contentToViewDimension(data.mContentWidth);
                int viewWidth;
                viewWidth = getViewWidth();
                {
                    x += left + width / 2 - mScrollX - viewWidth / 2;
                } //End block
                {
                    x += (int) (left + data.mXPercentInDoc * width
                                - mScrollX - data.mXPercentInView * viewWidth);
                } //End block
                x = Math.max(0,
                            (Math.min(maxWidth, x + viewWidth)) - viewWidth);
                int top;
                top = contentToViewY(data.mTop);
                int height;
                height = contentToViewDimension(data.mHeight);
                int maxHeight;
                maxHeight = contentToViewDimension(data.mContentHeight);
                int viewHeight;
                viewHeight = getViewHeight();
                int y;
                y = (int) (top + data.mYPercentInDoc * height -
                                   data.mYPercentInView * viewHeight);
                y = Math.max(0,
                            (Math.min(maxHeight, y + viewHeight) - viewHeight));
                y = Math.max(0, y - getVisibleTitleHeightImpl());
                scrollTo(x, y);
            } //End block
            //End case SHOW_RECT_MSG_ID 
            //Begin case CENTER_FIT_RECT 
            centerFitRect((Rect)msg.obj);
            //End case CENTER_FIT_RECT 
            //Begin case SET_SCROLLBAR_MODES 
            mHorizontalScrollBarMode = msg.arg1;
            //End case SET_SCROLLBAR_MODES 
            //Begin case SET_SCROLLBAR_MODES 
            mVerticalScrollBarMode = msg.arg2;
            //End case SET_SCROLLBAR_MODES 
            //Begin case SELECTION_STRING_CHANGED 
            {
                String selectionString;
                selectionString = (String) msg.obj;
                mAccessibilityInjector.onSelectionStringChange(selectionString);
            } //End block
            //End case SELECTION_STRING_CHANGED 
            //Begin case SET_TOUCH_HIGHLIGHT_RECTS 
            @SuppressWarnings("unchecked") ArrayList<Rect> rects;
            rects = (ArrayList<Rect>) msg.obj;
            //End case SET_TOUCH_HIGHLIGHT_RECTS 
            //Begin case SET_TOUCH_HIGHLIGHT_RECTS 
            setTouchHighlightRects(rects);
            //End case SET_TOUCH_HIGHLIGHT_RECTS 
            //Begin case SAVE_WEBARCHIVE_FINISHED 
            SaveWebArchiveMessage saveMessage;
            saveMessage = (SaveWebArchiveMessage)msg.obj;
            //End case SAVE_WEBARCHIVE_FINISHED 
            //Begin case SAVE_WEBARCHIVE_FINISHED 
            {
                saveMessage.mCallback.onReceiveValue(saveMessage.mResultFile);
            } //End block
            //End case SAVE_WEBARCHIVE_FINISHED 
            //Begin case SET_AUTOFILLABLE 
            mAutoFillData = (WebViewCore.AutoFillData) msg.obj;
            //End case SET_AUTOFILLABLE 
            //Begin case SET_AUTOFILLABLE 
            {
                mWebTextView.setAutoFillable(mAutoFillData.getQueryId());
                rebuildWebTextView();
            } //End block
            //End case SET_AUTOFILLABLE 
            //Begin case AUTOFILL_COMPLETE 
            {
                mWebTextView.setAdapterCustom(null);
            } //End block
            //End case AUTOFILL_COMPLETE 
            //Begin case SELECT_AT 
            nativeSelectAt(msg.arg1, msg.arg2);
            //End case SELECT_AT 
            //Begin case default 
            super.handleMessage(msg);
            //End case default 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class InvokeListBox implements Runnable {
        private boolean     mMultiple;
        private int[]       mSelectedArray;
        private int         mSelection;
        private Container[] mContainers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.388 -0400", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "E8FD6096500AD473974CF4E58771758C")
        @DSModeled(DSC.SAFE)
        private InvokeListBox(String[] array, int[] enabled, int[] selected) {
            dsTaint.addTaint(enabled);
            dsTaint.addTaint(selected);
            dsTaint.addTaint(array);
            mMultiple = true;
            int length;
            length = array.length;
            mContainers = new Container[length];
            {
                int i;
                i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mMultiple = true;
            //mSelectedArray = selected;
            //int length = array.length;
            //mContainers = new Container[length];
            //for (int i = 0; i < length; i++) {
                //mContainers[i] = new Container();
                //mContainers[i].mString = array[i];
                //mContainers[i].mEnabled = enabled[i];
                //mContainers[i].mId = i;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.388 -0400", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "0CB2D0380289C296ED9D6E1CEF5660D9")
        @DSModeled(DSC.SAFE)
        private InvokeListBox(String[] array, int[] enabled, int selection) {
            dsTaint.addTaint(enabled);
            dsTaint.addTaint(selection);
            dsTaint.addTaint(array);
            mMultiple = false;
            int length;
            length = array.length;
            mContainers = new Container[length];
            {
                int i;
                i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mSelection = selection;
            //mMultiple = false;
            //int length = array.length;
            //mContainers = new Container[length];
            //for (int i = 0; i < length; i++) {
                //mContainers[i] = new Container();
                //mContainers[i].mString = array[i];
                //mContainers[i].mEnabled = enabled[i];
                //mContainers[i].mId = i;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "318B74D770A1EB3B18A8A2DAD302FC77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            final ListView listView;
            listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            final MyArrayListAdapter adapter;
            adapter = new MyArrayListAdapter();
            AlertDialog.Builder b;
            b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);
            {
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
            } //End block
            mListBoxDialog = b.create();
            listView.setAdapter(adapter);
            listView.setFocusableInTouchMode(true);
            listView.setTextFilterEnabled(!mMultiple);
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                int length;
                length = mSelectedArray.length;
                {
                    int i;
                    i = 0;
                    {
                        listView.setItemChecked(mSelectedArray[i], true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                        mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        mListBoxDialog.dismiss();
                        mListBoxDialog = null;
                    }
                });
                {
                    listView.setSelection(mSelection);
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listView.setItemChecked(mSelection, true);
                    DataSetObserver observer;
                    observer = new SingleDataSetObserver(
                            adapter.getItemId(mSelection), listView, adapter);
                    adapter.registerDataSetObserver(observer);
                } //End block
            } //End block
            mListBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    mListBoxDialog = null;
                }
            });
            mListBoxDialog.show();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class Container extends Object {
            final static int OPTGROUP = -1;
            final static int OPTION_DISABLED = 0;
            final static int OPTION_ENABLED = 1;
            String  mString;
            int     mEnabled;
            int     mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "75BC6F43F448BC4A3490CA3C989FE9D3")
            @DSModeled(DSC.SAFE)
            @Override
            public String toString() {
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //return mString;
            }

            
        }


        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "167D244AB9FBB504354F71C841B9E3E4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "FB6C167DFF1F1640894CD86BEC167A04")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                dsTaint.addTaint(position);
                dsTaint.addTaint(parent.dsTaint);
                dsTaint.addTaint(convertView.dsTaint);
                convertView = super.getView(position, null, parent);
                Container c;
                c = item(position);
                {
                    LinearLayout layout;
                    layout = new LinearLayout(mContext);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    {
                        View dividerTop;
                        dividerTop = new View(mContext);
                        dividerTop.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerTop);
                    } //End block
                    {
                        {
                            Assert.assertTrue(convertView instanceof CheckedTextView);
                            ((CheckedTextView) convertView).setCheckMarkDrawable(null);
                        } //End block
                    } //End block
                    {
                        convertView.setEnabled(false);
                    } //End block
                    layout.addView(convertView);
                    {
                        boolean var29E3F9545B0C5E6979D96B1ACDAB027D_1812844990 = (position < getCount() - 1);
                        {
                            View dividerBottom;
                            dividerBottom = new View(mContext);
                            dividerBottom.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                            layout.addView(dividerBottom);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                return (View)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "4183E36168D122DBCF5A50188624DA65")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean hasStableIds() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.389 -0400", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "CE6FCCE0E0E5510D05F9B457AFC1D400")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private Container item(int position) {
                dsTaint.addTaint(position);
                {
                    boolean var46FB1B51094929768D004AD98A0CD79D_2084994608 = (position < 0 || position >= getCount());
                } //End collapsed parenthetic
                Container varE069C5AE020B74C9C365DE3307AEA467_28153803 = ((Container) getItem(position));
                return (Container)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (position < 0 || position >= getCount()) {
                    //return null;
                //}
                //return (Container) getItem(position);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.390 -0400", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "A7F85B6DFDEDFD567F5FC804C4DE3553")
            @DSModeled(DSC.SAFE)
            @Override
            public long getItemId(int position) {
                dsTaint.addTaint(position);
                Container item;
                item = item(position);
                return dsTaint.getTaintLong();
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return -1;
                //}
                //return item.mId;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.390 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "A7722848142FAFCD091F099CA8E33463")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean areAllItemsEnabled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.390 -0400", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "3CE266DB2926E77995BFB09064F1AE93")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean isEnabled(int position) {
                dsTaint.addTaint(position);
                Container item;
                item = item(position);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return false;
                //}
                //return Container.OPTION_ENABLED == item.mEnabled;
            }

            
        }


        
        private class SingleDataSetObserver extends DataSetObserver {
            private long        mCheckedId;
            private ListView    mListView;
            private Adapter     mAdapter;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.390 -0400", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "298D30B2389DB9EFC94ACE97BE56E18F")
            @DSModeled(DSC.SAFE)
            public SingleDataSetObserver(long id, ListView l, Adapter a) {
                dsTaint.addTaint(id);
                dsTaint.addTaint(a.dsTaint);
                dsTaint.addTaint(l.dsTaint);
                // ---------- Original Method ----------
                //mCheckedId = id;
                //mListView = l;
                //mAdapter = a;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.390 -0400", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "892343C48F8179B48E088D0A39C393F9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onChanged() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                int position;
                position = mListView.getCheckedItemPosition();
                long id;
                id = mAdapter.getItemId(position);
                {
                    mListView.clearChoices();
                    int count;
                    count = mAdapter.getCount();
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean varA60FED54EC8179E35E73102579F12B18_1410476486 = (mAdapter.getItemId(i) == mCheckedId);
                                {
                                    mListView.setItemChecked(i, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                //int position = mListView.getCheckedItemPosition();
                //long id = mAdapter.getItemId(position);
                //if (mCheckedId != id) {
                    //mListView.clearChoices();
                    //int count = mAdapter.getCount();
                    //for (int i = 0; i < count; i++) {
                        //if (mAdapter.getItemId(i) == mCheckedId) {
                            //mListView.setItemChecked(i, true);
                            //break;
                        //}
                    //}
                //}
            }

            
        }


        
    }


    
    @Deprecated public interface PictureListener {
        
        @Deprecated
        public void onNewPicture(WebView view, Picture picture);
    }
    
    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    
}


