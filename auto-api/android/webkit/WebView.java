package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private boolean mAutoRedraw;
    private AlertDialog mListBoxDialog = null;
    private ZoomManager mZoomManager;
    private Rect mGLRectViewport = new Rect();
    private Rect mViewRectViewport = new Rect();
    private RectF mVisibleContentRect = new RectF();
    private boolean mGLViewportEmpty = false;
    private CallbackProxy mCallbackProxy;
    private WebViewDatabase mDatabase;
    private SslCertificate mCertificate;
    private int mNativeClass;
    private WebViewCore mWebViewCore;
    Handler mPrivateHandler = new PrivateHandler();
    private WebTextView mWebTextView;
    private int mTextGeneration;
    ViewManager mViewManager;
    PluginFullScreenHolder mFullScreenHolder;
    private int mLastTouchX;
    private int mLastTouchY;
    private int mStartTouchX;
    private int mStartTouchY;
    private float mAverageAngle;
    private long mLastTouchTime;
    private long mLastSentTouchTime;
    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
    VelocityTracker mVelocityTracker;
    private int mMaximumFling;
    private float mLastVelocity;
    private float mLastVelX;
    private float mLastVelY;
    private int mCurrentScrollingLayerId;
    private Rect mScrollingLayerRect = new Rect();
    private int mTouchMode = TOUCH_DONE_MODE;
    private boolean mForwardTouchEvents = false;
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
    boolean mWidthCanMeasure;
    boolean mHeightCanMeasure;
    int mLastWidthSent;
    int mLastHeightSent;
    int mLastActualHeightSent;
    private int mContentWidth;
    private int mContentHeight;
    private boolean mOverlayHorizontalScrollbar = true;
    private boolean mOverlayVerticalScrollbar = false;
    OverScroller mScroller;
    private boolean mInOverScrollMode = false;
    private boolean mWrapContent;
    private int mHeldMotionless;
    private AccessibilityInjector mAccessibilityInjector;
    private boolean mAccessibilityScriptInjected;
    private Region mTextSelectionRegion = new Region();
    private Paint mTextSelectionPaint;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    private Region mTouchHighlightRegion = new Region();
    private Paint mTouchHightlightPaint;
    private Paint mTouchCrossHairColor;
    private int mTouchHighlightX;
    private int mTouchHighlightY;
    private long mTouchHighlightRequested;
    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    private boolean mBlockWebkitViewMessages = false;
    private boolean mHardwareAccelSkia = false;
    private int mInitialScaleInPercent = 0;
    private boolean mSendScrollEvent = true;
    private int mSnapScrollMode = SNAP_NONE;
    private boolean mSnapPositive;
    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
    private TextToSpeech mTextToSpeech;
    private Pattern mMatchAxsUrlParameterPattern;
    private int mOverscrollDistance;
    private int mOverflingDistance;
    private OverScrollGlow mOverScrollGlow;
    private Vector<Integer> mKeysPressed;
    private long mLastTouchUpTime = 0;
    private WebViewCore.AutoFillData mAutoFillData;
    private int mBackgroundColor = Color.WHITE;
    private int mAutoScrollX = 0;
    private int mAutoScrollY = 0;
    private int mMinAutoScrollX = 0;
    private int mMaxAutoScrollX = 0;
    private int mMinAutoScrollY = 0;
    private int mMaxAutoScrollY = 0;
    private Rect mScrollingLayerBounds = new Rect();
    private boolean mSentAutoScrollMessage = false;
    private TouchEventQueue mTouchEventQueue = new TouchEventQueue();
    private boolean mPictureUpdatePausedForFocusChange = false;
    private PictureListener mPictureListener;
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
    private DrawFilter mZoomFilter =
            new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
    private DrawFilter mScrollFilter =
            new PaintFlagsDrawFilter(SCROLL_BITS, 0);
    private boolean mDrawHistory = false;
    private Picture mHistoryPicture = null;
    private int mHistoryWidth = 0;
    private int mHistoryHeight = 0;
    private boolean mGotCenterDown = false;
    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.787 -0400", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "06A215AA6634AE56C91297FE1C3B3D3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.787 -0400", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "6E39A47D41652DFD74FD574B15194D71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.787 -0400", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "D70AFFAC08E65307FDE51EBE9A8DC777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.787 -0400", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "923D2484D40D4D771CB6F67D7F80D4FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.788 -0400", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "B13815395247705806C5BBDA99D038AB")
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
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid context argument");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.788 -0400", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "04CCCA39115104D6AC5BA74803FE09D2")
    @DSModeled(DSC.SAFE)
     void incrementTextGeneration() {
        // ---------- Original Method ----------
        //mTextGeneration++;
    }

    
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

    
        private static synchronized void disableProxyListener(Context context) {
        if (sProxyReceiver == null)
            return;
        context.getApplicationContext().unregisterReceiver(sProxyReceiver);
        sProxyReceiver = null;
    }

    
        private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyProperties = (ProxyProperties)intent.getExtra(Proxy.EXTRA_PROXY_INFO);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, null);
            return;
        }
        WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, proxyProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.789 -0400", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "6264EC030B36454062E0A3B73C12C170")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.789 -0400", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "19F517DDFE6662AEEF4BB02832E0E135")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateMultiTouchSupport(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mZoomManager.updateMultiTouchSupport(context);
        // ---------- Original Method ----------
        //mZoomManager.updateMultiTouchSupport(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.789 -0400", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "39EDB1E80A24887C5DE1449C7D64FFC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init() {
        OnTrimMemoryListener.init(getContext());
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        ViewConfiguration configuration;
        configuration = ViewConfiguration.get(getContext());
        int slop;
        slop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = slop * slop;
        slop = configuration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = slop * slop;
        float density;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.790 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "EC67567EC5C07259C01BC902C6E9E285")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.790 -0400", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "005933F7B8F71827218F4E1BC1034383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addAccessibilityApisToJavaScript() {
        {
            boolean varBB290631FF6BE4C8F44D202E8FB380A0_1087024378 = (AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled());
            {
                Context ctx;
                ctx = getContext();
                {
                    String packageName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.790 -0400", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "A2288C92C983D5D3246AA0C172C80D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.790 -0400", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "21E724E2AFD4D4FB304563853CEE9DCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.791 -0400", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "BC177E3708EDA474F180C058FB75E975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        int convertedContentWidth;
        convertedContentWidth = contentToViewX(getContentWidth());
        int adjustedViewWidth;
        adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        int convertedContentHeight;
        convertedContentHeight = contentToViewY(getContentHeight());
        int adjustedViewHeight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.791 -0400", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "F15AB4537D12BB0932B256034B1F4C13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isScrollableForAccessibility() {
        boolean var2E51EF2A2B51F29427B40369CE73A1BE_1366123926 = ((contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                //|| contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.791 -0400", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "A1A6CA6E77B6EBBC398AC33387AA7386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.791 -0400", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "708CF99AA9FBD07803B68DC221BEEA76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void adjustDefaultZoomDensity(int zoomDensity) {
        dsTaint.addTaint(zoomDensity);
        float density;
        density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //final float density = mContext.getResources().getDisplayMetrics().density
                //* 100 / zoomDensity;
        //updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.791 -0400", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "FA85999C431A912B3D7833A90D4BBDC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDefaultZoomDensity(float density) {
        dsTaint.addTaint(density);
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //mNavSlop = (int) (16 * density);
        //mZoomManager.updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.793 -0400", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "D1E841478DA92608DDDE3D52CC08A10C")
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
            Message remember;
            remember = mPrivateHandler.obtainMessage(
                    REMEMBER_PASSWORD);
            remember.getData().putString("host", schemePlusHost);
            remember.getData().putString("username", username);
            remember.getData().putString("password", password);
            remember.obj = resumeMsg;
            Message neverRemember;
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.793 -0400", hash_original_method = "99DE72360AB23E9BF4985BE8ED3FB8CE", hash_generated_method = "57B5A40E87E91444264092BB100C5F5C")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(which);
                    dsTaint.addTaint(dialog.dsTaint);
                    resumeMsg.sendToTarget();
                    // ---------- Original Method ----------
                    //resumeMsg.sendToTarget();
                }
})
                    .setNeutralButton(com.android.internal.R.string.save_password_remember,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.793 -0400", hash_original_method = "BC12A66C673827B889B0C1DFB7251A66", hash_generated_method = "0F6431241076FE2C698AD2B3651A514B")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(which);
                    dsTaint.addTaint(dialog.dsTaint);
                    remember.sendToTarget();
                    // ---------- Original Method ----------
                    //remember.sendToTarget();
                }
})
                    .setNegativeButton(com.android.internal.R.string.save_password_never,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.793 -0400", hash_original_method = "873315778F761CDAFA793A9437C366FC", hash_generated_method = "A5AECD29FD34A92C8A15C3D68AABF30F")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(which);
                    dsTaint.addTaint(dialog.dsTaint);
                    neverRemember.sendToTarget();
                    // ---------- Original Method ----------
                    //neverRemember.sendToTarget();
                }
})
                    .setOnCancelListener(new OnCancelListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.793 -0400", hash_original_method = "93C3AC18FD9E5633ABD9F836EA5CC3F9", hash_generated_method = "F67A67800A141D71790D55CE8BF61928")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onCancel(DialogInterface dialog) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(dialog.dsTaint);
                    resumeMsg.sendToTarget();
                    // ---------- Original Method ----------
                    //resumeMsg.sendToTarget();
                }
}).show();
            rVal = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.794 -0400", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "87F550C44EE61D2319E6030139901D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.794 -0400", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "8AFCC72C945FCE8DDB9E9FA7CE4D5A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        dsTaint.addTaint(overlay);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayHorizontalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.794 -0400", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "339F2F5BDC0C95402D9B9B5389AB00A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalScrollbarOverlay(boolean overlay) {
        dsTaint.addTaint(overlay);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayVerticalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.794 -0400", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "9147B2F13479F202222F6DCDCC59B2C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean overlayHorizontalScrollbar() {
        checkThread();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayHorizontalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.794 -0400", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "D53D1CD1BAED9D6E7D3D584F8D099AD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean overlayVerticalScrollbar() {
        checkThread();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayVerticalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.795 -0400", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "2897284B2A7392CEF4EF342E11931367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewWidth() {
        {
            boolean var292598F3B8B58F58543813175CA4B8DD_1494537564 = (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar);
            {
                int var6198C346AE8689F1D3DC081BB775DCCC_781657421 = (getWidth());
            } //End block
            {
                int var140744BAF485A6F88159B58920081848_1224840249 = (Math.max(0, getWidth() - getVerticalScrollbarWidth()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.795 -0400", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "128E4D5BA8EA607122504B9877BF658B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getTitleHeight() {
        {
            Object var89620761E813C776D9C3C42E19001F67_1723684417 = (mTitleBar.getHeight());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTitleBar != null ? mTitleBar.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.795 -0400", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "07F38F1C8081B5B38008162C8DE2FF17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVisibleTitleHeight() {
        checkThread();
        int var723012357A221391980D0C0C10B6FF34_492770567 = (getVisibleTitleHeightImpl());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.795 -0400", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "E9026D9EA7C64FE5DDA6490940BDB962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getVisibleTitleHeightImpl() {
        int var92FBB9603EF7E293DE9CA0F22B9E46D3_34525690 = (Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(getTitleHeight() - Math.max(0, mScrollY),
                //getOverlappingActionModeHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.796 -0400", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "4DEA2D845D4E88AF5D843DBB98AA9101")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.796 -0400", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "1E5F5753DA52193AD4FB992C45DF0442")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewHeight() {
        int varD548A0758944BD119F0830EAB903948B_850457827 = (getViewHeightWithTitle() - getVisibleTitleHeightImpl());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.796 -0400", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "31C70832C25EC03512B10C686B36CC4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getViewHeightWithTitle() {
        int height;
        height = getHeight();
        {
            boolean varEFFBBF75692B423920E06898DB33B47D_1391673964 = (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.796 -0400", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "D395A9496BF260EDB1AEEDAD17C0160A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SslCertificate getCertificate() {
        checkThread();
        return (SslCertificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.796 -0400", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "2D52982B285E15431AE2F41D29AD3D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "570A0509C31CCE7C8B389BD252DB6225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "519CB9601743337091AF8026F52164FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "1AA89D1CEC773E848D1F85D580D6D447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        checkThread();
        String[] var77CB03096BD32FC162AEEEDE53FE6C3E_1796782650 = (mDatabase.getHttpAuthUsernamePassword(host, realm));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //checkThread();
        //return mDatabase.getHttpAuthUsernamePassword(host, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "96EAAC7786E159D4BA71959CCD2826C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "448F915BE7E908A0F655BF91243B2A40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.797 -0400", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "6484E292F95762A26C284C86BD93A17F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.798 -0400", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "38021AB430F2F37CB9A4606BEC6303C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void destroy() {
        checkThread();
        destroyImpl();
        // ---------- Original Method ----------
        //checkThread();
        //destroyImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.798 -0400", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "780F377B513A7B5883C80A512598480F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.798 -0400", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "5ECF1703C78B421B596D7D523817C926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setJsFlags(String flags) {
        dsTaint.addTaint(flags);
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.798 -0400", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "2EB139CA563AD09B4A1C7BEA9057E25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.799 -0400", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "4531DAE29E69DBD62B6C593791F64CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.799 -0400", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "10957912782B40AC63615225D4B59F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList saveState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        checkThread();
        WebBackForwardList list;
        list = copyBackForwardList();
        int currentIndex;
        currentIndex = list.getCurrentIndex();
        int size;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.800 -0400", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "0B3B92BF70ECE3619721047EB1F69801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(b.dsTaint);
        checkThread();
        Picture p;
        p = capturePicture();
        File temp;
        temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.800 -0400", hash_original_method = "71F2765D1125FA36D6758E11ABE47081", hash_generated_method = "4F46149694C62E2224995F4104868B9C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                FileOutputStream out;
                out = null;
                try 
                {
                    out = new FileOutputStream(temp);
                    p.writeToStream(out);
                    temp.renameTo(dest);
                } //End block
                catch (Exception e)
                { }
                finally 
                {
                    {
                        try 
                        {
                            out.close();
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                    temp.delete();
                } //End block
                // ---------- Original Method ----------
                //FileOutputStream out = null;
                //try {
                    //out = new FileOutputStream(temp);
                    //p.writeToStream(out);
                    //temp.renameTo(dest);
                //} catch (Exception e) {
                //} finally {
                    //if (out != null) {
                        //try {
                            //out.close();
                        //} catch (Exception e) {
                        //}
                    //}
                    //temp.delete();
                //}
            }
}).start();
        b.putInt("scrollX", mScrollX);
        b.putInt("scrollY", mScrollY);
        mZoomManager.saveZoomState(b);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.800 -0400", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "4B55FF1F4291A75E454F33216957EC1B")
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
        float scale;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.801 -0400", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "9AAB2BE28CA13B21183573FA06556DC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean restorePicture(Bundle b, File src) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        checkThread();
        {
            boolean varE83409CFB365F3AF171C437BEF6A7D4D_1612874947 = (!src.exists());
        } //End collapsed parenthetic
        try 
        {
            FileInputStream in;
            in = new FileInputStream(src);
            Bundle copy;
            copy = new Bundle(b);
            new Thread(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.801 -0400", hash_original_method = "724A0503E9DDAB096FD7727D625B3A77", hash_generated_method = "89D61C8DB8F4342157418CD9E5A815B3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    try 
                    {
                        Picture p;
                        p = Picture.createFromStream(in);
                        {
                            mPrivateHandler.post(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.801 -0400", hash_original_method = "C56555B2959C7B009BAA3230DF6B18BD", hash_generated_method = "99D4A60111AD5243B646F29DC3E7007E")
                                //DSFIXME:  CODE0002: Requires DSC value to be set
                                public void run() {
                                    restoreHistoryPictureFields(p, copy);
                                    // ---------- Original Method ----------
                                    //restoreHistoryPictureFields(p, copy);
                                }
});
                        } //End block
                    } //End block
                    finally 
                    {
                        try 
                        {
                            in.close();
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                    // ---------- Original Method ----------
                    //try {
                        //final Picture p = Picture.createFromStream(in);
                        //if (p != null) {
                            //mPrivateHandler.post(new Runnable() {
                                //public void run() {
                                    //restoreHistoryPictureFields(p, copy);
                                //}
                            //});
                        //}
                    //} finally {
                        //try {
                            //in.close();
                        //} catch (Exception e) {
                        //}
                    //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.802 -0400", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "CB383ADA87FEC2B1E0B81FCA0B93CCD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean saveViewState(OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        try 
        {
            boolean varD8E0513B299C4708A843791F787A4612_1342996378 = (ViewStateSerializer.serializeViewState(stream, this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.802 -0400", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "B5F7CAFD1254D2E69BFBCC625071DD03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.802 -0400", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "732621B4DF183E8125FE78ECB6DCCC1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
        // ---------- Original Method ----------
        //mBlockWebkitViewMessages = false;
        //mLoadedPicture = null;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.803 -0400", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "DAAA01F8A57321170A5FD57F77052897")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList restoreState(Bundle inState) {
        dsTaint.addTaint(inState.dsTaint);
        checkThread();
        WebBackForwardList returnList;
        returnList = null;
        {
            boolean var2DC9EFB7F916A118778C320ECAEAF366_123719578 = (inState.containsKey("index") && inState.containsKey("history"));
            {
                mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));
                WebBackForwardList list;
                list = mCallbackProxy.getBackForwardList();
                int index;
                index = inState.getInt("index");
                {
                    List<byte[]> history;
                    history = (List<byte[]>) inState.getSerializable("history");
                    int size;
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
                    boolean varA762F755263E0165E9C21EFA8E349BE2_1638028013 = (inState.getBoolean("privateBrowsingEnabled"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.803 -0400", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "CA5AA35B56AEBC8494D4368357D175FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        dsTaint.addTaint(additionalHttpHeaders.dsTaint);
        dsTaint.addTaint(url);
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url, additionalHttpHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.803 -0400", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "C6215A1DAE4E24B85E94323B8E0A7422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.803 -0400", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "1E9655D604855FC588119E586E5BB9B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadUrl(String url) {
        dsTaint.addTaint(url);
        checkThread();
        loadUrlImpl(url);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.804 -0400", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "FD9DDE6E02F0D4455D7298240F114086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadUrlImpl(String url) {
        dsTaint.addTaint(url);
        loadUrlImpl(url, null);
        // ---------- Original Method ----------
        //if (url == null) {
            //return;
        //}
        //loadUrlImpl(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.804 -0400", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "E90E54ED0785BDC7FA4FF6C5CF0E3F4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postUrl(String url, byte[] postData) {
        dsTaint.addTaint(postData[0]);
        dsTaint.addTaint(url);
        checkThread();
        {
            boolean var4F95E4BDE23CE2774CDB1234D95999CA_2015473998 = (URLUtil.isNetworkUrl(url));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.805 -0400", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "FDF31F27FC0A7953AE3AA8ADD649F732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadData(String data, String mimeType, String encoding) {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(data);
        dsTaint.addTaint(mimeType);
        checkThread();
        loadDataImpl(data, mimeType, encoding);
        // ---------- Original Method ----------
        //checkThread();
        //loadDataImpl(data, mimeType, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.805 -0400", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "BDE8D0BDCB1EC615E8248472A8C174B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadDataImpl(String data, String mimeType, String encoding) {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(data);
        dsTaint.addTaint(mimeType);
        StringBuilder dataUrl;
        dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        {
            boolean var42C80751A5B21E94C93713173917F7B9_204825139 = ("base64".equals(encoding));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.805 -0400", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "5396F7F2F2F3E54CD4C6DDEC5A88059E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        dsTaint.addTaint(baseUrl);
        dsTaint.addTaint(historyUrl);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(data);
        dsTaint.addTaint(mimeType);
        checkThread();
        {
            boolean var66719BDAFAA36B530D74BC3839E26AEE_1622724785 = (baseUrl != null && baseUrl.toLowerCase().startsWith("data:"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.806 -0400", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "6DB1574475CEED11ABF61CA379802941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveWebArchive(String filename) {
        dsTaint.addTaint(filename);
        checkThread();
        saveWebArchiveImpl(filename, false, null);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(filename, false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.806 -0400", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "49263A62F911AC702702E9904612E78F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(autoname);
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(basename, autoname, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.806 -0400", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "F1A6A449B9F81CEE9C80F61811884A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        dsTaint.addTaint(basename);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(autoname);
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            //new SaveWebArchiveMessage(basename, autoname, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.806 -0400", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "2C395E4AC53467FAD68E24848E941787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopLoading() {
        checkThread();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
        // ---------- Original Method ----------
        //checkThread();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.STOP_LOADING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.806 -0400", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "8F4D6179589A516B470113791CFEE8A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.807 -0400", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "5F3F726511096BE568CEFB7FAF16864C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoBack() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_1029941294 = (l.getClearPending());
                {
                    boolean var206A5F4DC30C9911DE984FA8A632E8D0_729447106 = (l.getCurrentIndex() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.807 -0400", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "63D2353E5F881AC0C773B9FBCC91A18D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.807 -0400", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "EDB0B8388803E8021D48CB8486B52A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoForward() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_239364846 = (l.getClearPending());
                {
                    boolean varCC6932F1C4388293E5C6020CC2BE99D1_1932283533 = (l.getCurrentIndex() < l.getSize() - 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.807 -0400", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "7DBF91244690F3215087518F21FF9C8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.807 -0400", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "4B90DF119C3D929E331997F17FEA94B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canGoBackOrForward(int steps) {
        dsTaint.addTaint(steps);
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_105014005 = (l.getClearPending());
                {
                    int newIndex;
                    newIndex = l.getCurrentIndex() + steps;
                    boolean varC96153442818D1ECADD5777B6D61A76F_1800963241 = (newIndex >= 0 && newIndex < l.getSize());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.808 -0400", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "56E9C2895DC9EA9E3EBE195DB5817ECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void goBackOrForward(int steps) {
        dsTaint.addTaint(steps);
        checkThread();
        goBackOrForwardImpl(steps);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(steps);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.808 -0400", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "1EDD8E16539C71116F376FA31DDB8E24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void goBackOrForwardImpl(int steps) {
        dsTaint.addTaint(steps);
        goBackOrForward(steps, false);
        // ---------- Original Method ----------
        //goBackOrForward(steps, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.808 -0400", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "985C92AEB2ECED021E022874191465FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.808 -0400", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "D87A2ED7914153D0719564DDAE74C8C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        boolean varB1BAC2416E34E6087A203AED7444A817_1323609188 = (getSettings().isPrivateBrowsingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return getSettings().isPrivateBrowsingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.808 -0400", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "07E57C68BA1FFA2F79AE67648A8B3103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
        // ---------- Original Method ----------
        //getSettings().setPrivateBrowsingEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.809 -0400", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "E6426BF6B0E7D2CE6876C9D3F810D0D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.809 -0400", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "4B13359D2F21B80FA24EB93F7657BAE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageUp(boolean top) {
        dsTaint.addTaint(top);
        checkThread();
        nativeClearCursor();
        {
            boolean varEC29A5852D76967DDCD92AF6EF13DA1B_1913543543 = (pinScrollTo(mScrollX, 0, true, 0));
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
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_1879144820 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1225570407 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_889392084 = (extendScroll(y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.809 -0400", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "9901F1DB2F54973208597EA58098CBE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean pageDown(boolean bottom) {
        dsTaint.addTaint(bottom);
        checkThread();
        nativeClearCursor();
        {
            boolean var20824CBC7D9295AF4224D9CEA1714AF5_1859181977 = (pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0));
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
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_1696362510 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_450047149 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_1651867568 = (extendScroll(y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.810 -0400", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "96502640F44EE6B02C635F6CE1A50F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.810 -0400", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "790A902E3642E9A1631F69424FC3D3E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.810 -0400", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "06D863A2C5D1421BB58E8FF022A975EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean inEditingMode() {
        boolean var5AD34046046BD5597D48FAE1E55DF94F_1837706746 = (mWebTextView != null && mWebTextView.getParent() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWebTextView != null && mWebTextView.getParent() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.810 -0400", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "C8AA95A0AE8B7AB62046E411A9BCACD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearTextEntry() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1963553681 = (inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.810 -0400", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "D7B65974B4E5A889235F7954CDBB6EA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getScale() {
        checkThread();
        float var7BDB5950E779A8350C7AFF5485D9A1D9_61580271 = (mZoomManager.getScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.811 -0400", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "53DE6CF53409FF20F91CDFF6D5BE45B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getTextHandleScale() {
        float density;
        density = mContext.getResources().getDisplayMetrics().density;
        float varE59D2240C31D06227A739295405DD61F_1124736883 = (density / getScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float density = mContext.getResources().getDisplayMetrics().density;
        //return density / getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.811 -0400", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "C4702E3EE682C83458424C1B3EE55974")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getReadingLevelScale() {
        float var44DB53B9B3C50B031CB12B3205E80427_75211569 = (mZoomManager.getReadingLevelScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getReadingLevelScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.811 -0400", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "1946656ED8846C07CC586C9ACBB72226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInitialScale(int scaleInPercent) {
        dsTaint.addTaint(scaleInPercent);
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
        // ---------- Original Method ----------
        //checkThread();
        //mZoomManager.setInitialScaleInPercent(scaleInPercent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.811 -0400", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "A7954A2AB54E17DD462191893DB44ED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invokeZoomPicker() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_1997312195 = (!getSettings().supportZoom());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.811 -0400", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "9B52F9CF6030125D2673C044B3C7352D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HitTestResult getHitTestResult() {
        checkThread();
        HitTestResult varE98E5DEF74229AC9890C6F5B28E1D7E9_892202577 = (hitTestResult(mInitialHitTestResult));
        return (HitTestResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return hitTestResult(mInitialHitTestResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.812 -0400", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "DA645DCAEB443A627E985E64265E54DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HitTestResult hitTestResult(HitTestResult fallback) {
        dsTaint.addTaint(fallback.dsTaint);
        HitTestResult result;
        result = new HitTestResult();
        {
            boolean var5225ACD2E56334E54962D68427F36819_301180863 = (nativeHasCursorNode());
            {
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_918809583 = (nativeCursorIsTextInput());
                    {
                        result.setType(HitTestResult.EDIT_TEXT_TYPE);
                    } //End block
                    {
                        String text;
                        text = nativeCursorText();
                        {
                            {
                                boolean varC002F8AFED7F549F33D23662D5EE005B_834661662 = (text.startsWith(SCHEME_TEL));
                                {
                                    result.setType(HitTestResult.PHONE_TYPE);
                                    result.setExtra(text.substring(SCHEME_TEL.length()));
                                } //End block
                                {
                                    boolean var8892C872AF1A0DE7CA908AB563D8630A_1539854206 = (text.startsWith(SCHEME_MAILTO));
                                    {
                                        result.setType(HitTestResult.EMAIL_TYPE);
                                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                                    } //End block
                                    {
                                        boolean varC83048191C80A2E63B6D052EA1A2AF29_815689872 = (text.startsWith(SCHEME_GEO));
                                        {
                                            result.setType(HitTestResult.GEO_TYPE);
                                            result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                                        } //End block
                                        {
                                            boolean var559FEC73A68A4A49F5AE8D79C0655989_312872240 = (nativeCursorIsAnchor());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.812 -0400", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "B7F54B3F416778BAB98103F9B4D7A5BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void domChangedFocus() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_372675817 = (inEditingMode());
            {
                mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.812 -0400", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "5D4E7F9590922DD3D79FABDA6B051AC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestFocusNodeHref(Message hrefMsg) {
        dsTaint.addTaint(hrefMsg.dsTaint);
        checkThread();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        {
            boolean var5225ACD2E56334E54962D68427F36819_2009311422 = (nativeHasCursorNode());
            {
                Rect cursorBounds;
                cursorBounds = nativeGetCursorRingBounds();
                {
                    boolean var445EE3E02909E3AEE38EC98CDB8981EE_1876673822 = (!cursorBounds.contains(contentX, contentY));
                    {
                        int slop;
                        slop = viewToContentDimension(mNavSlop);
                        cursorBounds.inset(-slop, -slop);
                        {
                            boolean varADAA650ED0CC8F602CC684B55A8BD54B_1860871434 = (cursorBounds.contains(contentX, contentY));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.813 -0400", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "F73AAA537B4DE37E31BC63950E46A5D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.813 -0400", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "C1BCEFD80AE6F1AB714FE533FF6C2311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int pinLocX(int x) {
        dsTaint.addTaint(x);
        int var07118715F745D512C238AD2FEDFE6515_1726083381 = (pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return x;
        //return pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.813 -0400", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "C73A16D621AB6778AC1A0C5D43F994B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int pinLocY(int y) {
        dsTaint.addTaint(y);
        int var2B535EA2474A113BEF6C4806B3E88FC9_1124457768 = (pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return y;
        //return pinLoc(y, getViewHeightWithTitle(),
                      //computeRealVerticalScrollRange() + getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.813 -0400", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "3F88DD2BADCEB289086C689EA3E487C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "42E542E0C7C8D4C54E2C6F7BE7A3DFAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitleBarGravity(int gravity) {
        dsTaint.addTaint(gravity);
        invalidate();
        // ---------- Original Method ----------
        //mTitleGravity = gravity;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "B5E73AC4CFC5E5F09FB01399359F71E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int viewToContentDimension(int d) {
        dsTaint.addTaint(d);
        int var6C6E42DD517C7D3B9A717F110B422373_264063878 = (Math.round(d * mZoomManager.getInvScale()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "81D4E398849625F0308CA1596308C272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int viewToContentX(int x) {
        dsTaint.addTaint(x);
        int var8DEE0558B14D500E1B85CE5222A73912_1112362085 = (viewToContentDimension(x));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return viewToContentDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "70D71821F21E491EEF586602AF9DBF9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int viewToContentY(int y) {
        dsTaint.addTaint(y);
        int var7B97DA5C6E7937A4956BCED3C768F5E3_1415588155 = (viewToContentDimension(y - getTitleHeight()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return viewToContentDimension(y - getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "D01143F246F0E36DDC6B6DBDDAF52744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float viewToContentXf(int x) {
        dsTaint.addTaint(x);
        float var8A8AB39BD9FBE3D7753B44FE92DB7211_1983671708 = (x * mZoomManager.getInvScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return x * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.814 -0400", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "B75DFCE6E5D0B8AF40773C5FED433584")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float viewToContentYf(int y) {
        dsTaint.addTaint(y);
        float var831D90CB537843A85A184EBC2C0DA386_795704873 = ((y - getTitleHeight()) * mZoomManager.getInvScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (y - getTitleHeight()) * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.815 -0400", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "BF0CD9BB72369E6F3E764C245B04CACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewDimension(int d) {
        dsTaint.addTaint(d);
        int var330434C37CE0501EDFCFE74FEF711C69_1738155910 = (Math.round(d * mZoomManager.getScale()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.815 -0400", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "897CA78B42E85EEA91323FEF35102CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewX(int x) {
        dsTaint.addTaint(x);
        int var5F9CD9178F56CA92BE57B17CD7626740_51702687 = (contentToViewDimension(x));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentToViewDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.815 -0400", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "55503C3936ADFA35AA2D3A1A2E02F5A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int contentToViewY(int y) {
        dsTaint.addTaint(y);
        int varFF4BC4A064C1180EFE780BDD5AD7DDE0_2139337229 = (contentToViewDimension(y) + getTitleHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentToViewDimension(y) + getTitleHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.815 -0400", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "49773A605EA79EF75444F73F51AD3FEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect contentToViewRect(Rect x) {
        dsTaint.addTaint(x.dsTaint);
        Rect var4B81D5DF5680451FFACD064B79463794_1248688855 = (new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom)));
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        //contentToViewX(x.right), contentToViewY(x.bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.815 -0400", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "227DD843B4B6809C11304BE422FD73B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewInvalidate(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        float scale;
        scale = mZoomManager.getScale();
        int dy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.816 -0400", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "683C4AE9298EAE818970AE10DF519700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(delay);
        float scale;
        scale = mZoomManager.getScale();
        int dy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.816 -0400", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "E511464D1105EB94F8260071D463BACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void invalidateContentRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        viewInvalidate(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //viewInvalidate(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.816 -0400", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "5847048DB193138D46100A4DCE1A2FEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.816 -0400", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "A13E2606FC69A643014A8CBAEA05C459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordNewContentSize(int w, int h, boolean updateLayout) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(updateLayout);
        dsTaint.addTaint(h);
        {
            {
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_1237497869 = (!mScroller.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.817 -0400", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "1EBB29412DB3E32CCA85BE7E96D96A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Rect sendOurVisibleRect() {
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_337182677 = (mZoomManager.isPreventingWebkitUpdates());
        } //End collapsed parenthetic
        calcOurContentVisibleRect(mVisibleRect);
        {
            boolean var00DE442F9F80E5CC469870BAE951674E_1062570240 = (!mVisibleRect.equals(mLastVisibleRectSent));
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
            boolean var3D2FB3EC4A2EF0714518F74D7378575D_1531741738 = (getGlobalVisibleRect(mGlobalVisibleRect)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.817 -0400", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "E331FFCC99052CC328D159AF5F379404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void calcOurVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
        // ---------- Original Method ----------
        //getGlobalVisibleRect(r, mGlobalVisibleOffset);
        //r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.817 -0400", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "A6D1DEA13755224E4904304046C76481")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.818 -0400", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "8E79C1C0D61B542479F23B2E686B3653")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.818 -0400", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "24C65F9CAF01ADFAF2AC829EB22D5B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean sendViewSizeZoom(boolean force) {
        dsTaint.addTaint(force);
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_393058198 = (mZoomManager.isPreventingWebkitUpdates());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.819 -0400", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "8CAC5C242FDCE05CCD39CFFAB16A720C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDoubleTapZoom(int doubleTapZoom) {
        dsTaint.addTaint(doubleTapZoom);
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
        // ---------- Original Method ----------
        //mZoomManager.updateDoubleTapZoom(doubleTapZoom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.819 -0400", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "CF96E6DFDBCC5E13E8434C6DB9E77A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeRealHorizontalScrollRange() {
        {
            int varFC9DBABA45B6BB7366F73B80D989E991_597797984 = ((int) Math.floor(mContentWidth * mZoomManager.getScale()));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryWidth;
        //} else {
            //return (int) Math.floor(mContentWidth * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "7B85C2C3C89DD7AD0D68490880CA862C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollRange() {
        int range;
        range = computeRealHorizontalScrollRange();
        int scrollX;
        scrollX = mScrollX;
        int overscrollRight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "CCC8BF2D3A423BF5C109AF8C7F66FC9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeHorizontalScrollOffset() {
        int var39399E7590852488423D31BF8E113523_1700187767 = (Math.max(mScrollX, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollX, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "81B482BE864EEB34CA582BFDE3BF7F79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int computeRealVerticalScrollRange() {
        {
            int var6B23C2077842EB549029F0B0D2DC4BA6_1811923081 = ((int) Math.floor(mContentHeight * mZoomManager.getScale()));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryHeight;
        //} else {
            //return (int) Math.floor(mContentHeight * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "2D50E2A845B3526C8618E444E9C3B536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollRange() {
        int range;
        range = computeRealVerticalScrollRange();
        int scrollY;
        scrollY = mScrollY;
        int overscrollBottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "24AD22EA400832AF8D0DC9E9FDBF555C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollOffset() {
        int var34E847664C51512EE9641EF813607EB4_1717715423 = (Math.max(mScrollY - getTitleHeight(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollY - getTitleHeight(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.820 -0400", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "31FDFDFC84A84FAAF00DEC5DC6633227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollExtent() {
        int varE85BFDDBDAAF56CEC1CA21E104DA822F_1175856357 = (getViewHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getViewHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.821 -0400", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "A0B377A8AAF66F506A9ADCA1DAB7283D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.821 -0400", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "C17E86A9DFCA7282CE91B8AD98041893")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.821 -0400", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "DE6FFCE4B313324657F919088C35F827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUrl() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object varBD02ED23F0746D6990A513108379DB42_642436798 = (h.getUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.822 -0400", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "93361BC55FFE2416FC6B93245D99A6D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginalUrl() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var5A176BD94397B5E17F627335178507C0_995208112 = (h.getOriginalUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getOriginalUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.822 -0400", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "F5981D9EEA97C5D258FB7CC29085696C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTitle() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var79F60E007ABDDF3B8DDD796002584E77_1110736257 = (h.getTitle());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTitle() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.822 -0400", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "B94D04650087AA77861D3EF7A4E3AF10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFavicon() {
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var3761298654F94BE05D2E704C028E9FB9_1289741702 = (h.getFavicon());
        } //End flattened ternary
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getFavicon() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.823 -0400", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "4116B363E66F724502D92DA764A015A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTouchIconUrl() {
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        {
            Object var901B799FE33F4D9E3DB3E78A5B6E00DB_1366120121 = (h.getTouchIconUrl());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTouchIconUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.823 -0400", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "35CC1F147448CA577551BB9BA42ECB84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProgress() {
        checkThread();
        int var7E8F23F5531EF375BC02F70B93667140_447759318 = (mCallbackProxy.getProgress());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getProgress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.823 -0400", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "3373279723523E45C4A65FD427DC3B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getContentHeight() {
        checkThread();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkThread();
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.823 -0400", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "23678F181E89C77B0192749A1BE3977A")
    @DSModeled(DSC.SAFE)
    public int getContentWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mContentWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.823 -0400", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "96075663C4E1C1E6F8F093BE55FAEA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPageBackgroundColor() {
        int varDEEC2470ADDE0DE678B2B89837C36FF8_986283733 = (nativeGetBackgroundColor());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetBackgroundColor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.824 -0400", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "651F867BAFC105E7B600DA6E0DB6200B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.824 -0400", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "FCEBD265F9D78FA6297E394388314989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.824 -0400", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "9A2C91217964AFD85BD7C1DC25019147")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.824 -0400", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "E33325AE827CB28E3B785E85B89DA243")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.825 -0400", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "07BCA5B1EE1984BB2F0870F601394764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateDrawingState() {
        {
            boolean var7C64E366ECC1C3C33738983696089D46_1004368593 = (getWindowVisibility() != VISIBLE);
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_1143113030 = (getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.825 -0400", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "FED5B336FC4FDC2946193D66C38CB80D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.825 -0400", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "C07344F445DF0A0BE7187BD0D1E33356")
    @DSModeled(DSC.SAFE)
    public boolean isPaused() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPaused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.825 -0400", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "7D54396D1E9C804F1A90D8C86B6B65FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.825 -0400", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "FD64DF362567CE01F712E9FDD02CAA9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.826 -0400", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "927A6FD6E3A2677521E007BF60CE9AF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearFormData() {
        checkThread();
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1425085141 = (inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.826 -0400", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "2F018CB7C6DC1FE54A157AEDF3AD6E80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.826 -0400", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "36E442E384C566FE65DE22F84677463B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.826 -0400", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "D7A08DDE23794A4DEF8C529A13D8C259")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardList copyBackForwardList() {
        checkThread();
        WebBackForwardList var5EAE26242306E3C727AA5461B299ADAF_991124064 = (mCallbackProxy.getBackForwardList().clone());
        return (WebBackForwardList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getBackForwardList().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.826 -0400", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "9D4D7366B35071BA778F73D50722E986")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void findNext(boolean forward) {
        dsTaint.addTaint(forward);
        checkThread();
        nativeFindNext(forward);
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //nativeFindNext(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.827 -0400", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "829694D591E133AD14EC310214ECA461")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.827 -0400", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "68F5AABE59AD1EF33BD7B2890ED89F46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showFindDialog(String text, boolean showIme) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(showIme);
        checkThread();
        FindActionModeCallback callback;
        callback = new FindActionModeCallback(mContext);
        {
            boolean varD263546D355C6FB3DF70E9DF8F0F7FDE_750114282 = (getParent() == null || startActionMode(callback) == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.827 -0400", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "A5DFCB348EDAC2979502A82FDDF64C36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFindIsUp(boolean isUp) {
        dsTaint.addTaint(isUp);
        nativeSetFindIsUp(isUp);
        // ---------- Original Method ----------
        //mFindIsUp = isUp;
        //if (0 == mNativeClass) return;
        //nativeSetFindIsUp(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.828 -0400", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "4369CED7ABFC842E8756BBBCF211172C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int findIndex() {
        int var790C769C9D30EC8562E6C6B0E7276107_354415628 = (nativeFindIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (0 == mNativeClass) return -1;
        //return nativeFindIndex();
    }

    
        public static String findAddress(String addr) {
        checkThread();
        return findAddress(addr, false);
    }

    
        public static String findAddress(String addr, boolean caseInsensitive) {
        return WebViewCore.nativeFindAddress(addr, caseInsensitive);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.828 -0400", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "1AF0A7969A405E9ACF74B77D7B7D1CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.829 -0400", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "948A2F13512D200DBE7FFC5B15A696B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.830 -0400", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "A05B31B4DC4357DB2028581330623D04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.830 -0400", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "A83853DA38B09ACCE7BA0F75693DED2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.forceFinished(true);
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.830 -0400", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "4BD9529DEDA4237347481AF508ED1A34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_757143708 = (mScroller.computeScrollOffset());
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
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_614836198 = (!mScroller.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.831 -0400", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "D8AE0CEFF91F5673D79C93C9F6B09116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static int computeDuration(int dx, int dy) {
        int distance = Math.max(Math.abs(dx), Math.abs(dy));
        int duration = distance * 1000 / STD_SPEED;
        return Math.min(duration, MAX_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.831 -0400", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "1732C5FFC97968C8F5ED06BFA1B9663F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        dsTaint.addTaint(animate);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dsTaint.addTaint(animationDuration);
        boolean varDDCD3B201102A2B6BF7DF6BB672D50B5_514543673 = (pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.831 -0400", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "64E34859C59E7EE1A117C3645BD6E46C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.832 -0400", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "842706063E2972ACC2A179E4F30B711B")
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
            boolean var3FCDFFB9E4E3AC0EFF489E7F0EAB193B_1656134948 = (cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0));
        } //End block
        {
            boolean var29BB42B254A3ABD17ABD36618645F129_998893451 = (pinScrollBy(cx, cy, animate, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.832 -0400", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "0110ADB512487FCC266CAA2BDB63BD3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onPageStarted(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        setCertificate(null);
        mAccessibilityScriptInjected = false;
        // ---------- Original Method ----------
        //setCertificate(null);
        //mAccessibilityScriptInjected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.832 -0400", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "D5C33985ADFC4EC13AD62A4EC0A05AA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(url);
        {
            {
                boolean varE94AF5A5E140E4B674F99180E2533924_1360257240 = (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.832 -0400", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "944691623E374060ED39DB9156C77C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void injectAccessibilityForUrl(String url) {
        dsTaint.addTaint(url);
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(mContext);
        {
            boolean var2F55789C2BAEC4B54A3769DF00E1201A_1191637198 = (!accessibilityManager.isEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var257A8D7DF44254A8F3AFFC587333D831_572125136 = (!getSettings().getJavaScriptEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.833 -0400", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "D6EADDD95D38E68E446227B2DFFA79B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.833 -0400", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "F7035EFBA4B4D54F327E684DFF985031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getAxsUrlParameterValue(String url) {
        dsTaint.addTaint(url);
        {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        } //End block
        Matcher matcher;
        matcher = mMatchAxsUrlParameterPattern.matcher(url);
        {
            boolean var0CA07C7E05B5FB943A39E313382D5DA2_20371230 = (matcher.find());
            {
                String keyValuePair;
                keyValuePair = url.substring(matcher.start(), matcher.end());
                int varB4575FE2088203A669F7AEBE1DD89AA0_1053204194 = (Integer.parseInt(keyValuePair.split("=")[1]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.833 -0400", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "11A0D334A10801273DF382282362E2E0")
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
                boolean varBB2C6738F4D3DE5D7DC74ECC3D92899E_2130755241 = (getProgress() < 100);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "4E7E0216FD0F2EDD874772A40194ADDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "86AEC02F17163B5EA4CB3C0BB0B53252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void contentSizeChanged(boolean updateLayout) {
        dsTaint.addTaint(updateLayout);
        {
            {
                boolean var687FC976609C320EB23E747E9ECBC12A_2015537024 = (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout);
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7183AB9F5F71646AEDE7ABA21E1DCB83_1657520554 = (getMeasuredWidth() != contentToViewDimension(mContentWidth)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "CA52505AC3E9A6CFA5E96A1763723CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWebViewClient(WebViewClient client) {
        dsTaint.addTaint(client.dsTaint);
        checkThread();
        mCallbackProxy.setWebViewClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebViewClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "0E20ADD240A02FBE2E488265DC7D4635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebViewClient getWebViewClient() {
        WebViewClient var4EB37B5B1E9A652F49A924F7972773FB_967408884 = (mCallbackProxy.getWebViewClient());
        return (WebViewClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebViewClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "F57F0CC08C080FC9F67EADF468FDB5D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDownloadListener(DownloadListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setDownloadListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.834 -0400", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "AF63816D70D1F532E3749C57569AFC1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWebChromeClient(WebChromeClient client) {
        dsTaint.addTaint(client.dsTaint);
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebChromeClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "37F853E74E50159C18B39AF674A4544E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebChromeClient getWebChromeClient() {
        WebChromeClient var76EC2DAF7AECAA60F4515D73D7EEBA5F_582721295 = (mCallbackProxy.getWebChromeClient());
        return (WebChromeClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebChromeClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "1823D43DB8F5936A7E92C62202C6D12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWebBackForwardListClient(WebBackForwardListClient client) {
        dsTaint.addTaint(client.dsTaint);
        mCallbackProxy.setWebBackForwardListClient(client);
        // ---------- Original Method ----------
        //mCallbackProxy.setWebBackForwardListClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "464150DBFFF655E79DA3B93D74C72A99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient var7C2425DFE3987FE4C6879F9F99300C0B_1990635127 = (mCallbackProxy.getWebBackForwardListClient());
        return (WebBackForwardListClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebBackForwardListClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "F322C7A06FFF2C43B6A26E327723F380")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setPictureListener(PictureListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mPictureListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "3AE498A7918B2504019DFD2A9BFF9CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void externalRepresentation(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.835 -0400", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "5770EB973F07938598A3F14D662CAB9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void documentAsText(Message callback) {
        dsTaint.addTaint(callback.dsTaint);
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.836 -0400", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "32C196689FD3A48AEC21F4A57F43C66C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.836 -0400", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "2682C5B41C228386DC1E4F9C28120C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.836 -0400", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "3C58249FA902A6A41972840BE8B3AECA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WebSettings getSettings() {
        checkThread();
        {
            Object varA73F6C7E3AB8DC13A9EF0D8D99FBDC40_1172703965 = (mWebViewCore.getSettings());
        } //End flattened ternary
        return (WebSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //return (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
    }

    
        @Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.836 -0400", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "ACD79AC8E60721916B3D63394B1A8713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        dsTaint.addTaint(reloadOpenPages);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.837 -0400", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "E0107750E40A97628F2D70DD310FFAAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mPrivateHandler.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.837 -0400", hash_original_method = "C35D8FF76F468647EBD4843DB70BD70E", hash_generated_method = "1D1962C885A4B76385563869BB6544A0")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void run() {
                        destroy();
                        // ---------- Original Method ----------
                        //destroy();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.837 -0400", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "D941C00B9FF2F8A740BDE0401E2E8D82")
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
        boolean var2713BACF81F43D1C388D129F1A927E0D_311175736 = (super.drawChild(canvas, child, drawingTime));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.837 -0400", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "73CA17C19C678183036B2388669D6838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawContent(Canvas canvas, boolean drawRings) {
        dsTaint.addTaint(drawRings);
        dsTaint.addTaint(canvas.dsTaint);
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
        // ---------- Original Method ----------
        //drawCoreAndCursorRing(canvas, mBackgroundColor,
                //mDrawCursorRing && drawRings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.838 -0400", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "97042420D2EBD5DE7FA292A295DD044D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.838 -0400", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "0353B6877C3A9B7D333C6DB459D47C5D")
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
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_29269270 = (canvas.isHardwareAccelerated());
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
            boolean var4322EE85B805CBD21A094B57F62ADC23_617651554 = (mInOverScrollMode && !getSettings()
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
            boolean varEFDBDAC0A2DEB3E5103984743E3C9A57_1166467757 = (mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        {
            long delay;
            delay = System.currentTimeMillis() - mTouchHighlightRequested;
            {
                boolean varBCA1B79D766932AE90DE8B5336B437FC_42883417 = (delay < ViewConfiguration.getTapTimeout());
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
                        boolean var777D1BAEECB4D7088A7F6E66A69B6796_420828158 = (iter.next(r));
                        {
                            canvas.drawRect(r, mTouchHightlightPaint);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7909E0FF363982F909528C78CCCF0F02_992092539 = (getSettings().getNavDump());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.839 -0400", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "34A310392E72BEC0A58EE1BE45DD1549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
        // ---------- Original Method ----------
        //mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        //mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        //setTouchHighlightRects(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.839 -0400", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "9F33750A52071818562AB3578D1FEA17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.839 -0400", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "DD7E3466A78706F37D76343F75CE7F5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performLongClick() {
        {
            boolean var88AD79EA276C28AD3B3469360BCE1788_1351043844 = (getParent() == null);
        } //End collapsed parenthetic
        ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        {
            boolean var13D92B99C938B0F2FF8CCF00F803E8A6_113013311 = (detector != null && detector.isInProgress());
        } //End collapsed parenthetic
        {
            boolean var780C0185A33DB3757005E772477A414D_1266888334 = (mNativeClass != 0 && nativeCursorIsTextInput());
            {
                centerKeyPressOnTextField();
                rebuildWebTextView();
            } //End block
            {
                clearTextEntry();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_849958749 = (inEditingMode());
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
                boolean var8E1B4A2E9B8893A37E1A84490A65FC9A_720849960 = (mWebTextView.performLongClick());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC298D59926924FB0808A70DC864C4372_1983815189 = (super.performLongClick());
        } //End collapsed parenthetic
        boolean isSelecting;
        isSelecting = selectText();
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.839 -0400", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "07AF8D613978D19401F423D031639B84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean selectText() {
        int x;
        x = viewToContentX(mLastTouchX + mScrollX);
        int y;
        y = viewToContentY(mLastTouchY + mScrollY);
        boolean varB29E32086CAB7981D2C629145B25F904_1374254391 = (selectText(x, y));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int x = viewToContentX(mLastTouchX + mScrollX);
        //int y = viewToContentY(mLastTouchY + mScrollY);
        //return selectText(x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.840 -0400", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "EBDA9D88B920B37199A1C39F03F569FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean selectText(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varC5ECEC29B03BE800BB553180A5BFDF02_935628375 = (!setUpSelect(true, x, y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.840 -0400", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "52B40D3944B19BC89B919B771B3A9D67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.840 -0400", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "297B82CF0D29896828BF2A0CEF7E5F17")
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
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "invalid parameter passed to didUpdateWebTextViewDimensions");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.840 -0400", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "6E5434EEE7E913163B1D37C01EF02F87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void offsetByLayerScrollPosition(Rect box) {
        dsTaint.addTaint(box.dsTaint);
        {
            boolean var9CB7C6698CC8E4B39807B6B5CCF588EA_1871412244 = ((mCurrentScrollingLayerId != 0)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "85F2592BE3917969D461289AD57E3C9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        dsTaint.addTaint(isPictureAfterFirstLayout);
        dsTaint.addTaint(showVisualIndicator);
        dsTaint.addTaint(layer);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "93D690DD6DF93AED78CA1B92842CC83C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getBaseLayer() {
        int var56C10FDD99E0FDF412C413A619660025_1519600029 = (nativeGetBaseLayer());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return 0;
        //}
        //return nativeGetBaseLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "305B4B76FA92FEEBC2C9895487E3CF30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onZoomAnimationStart() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1754074896 = (inEditingMode());
            {
                mWebTextView.setVisibility(INVISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.setVisibility(INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "D43FCDA9F49AD9487B92328E85BBCEE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onZoomAnimationEnd() {
        {
            boolean var7CF3A0FDB7A5E846FB3F76D951F33983_1675183430 = (inEditingMode()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "1DA8D4977752B15EE1DC244719C6FA7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onFixedLengthZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //WebViewCore.pauseUpdatePicture(getWebViewCore());
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.841 -0400", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "101EE64BBEBED819506DCE68CFA9A134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.842 -0400", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "31BDBA0C8D6E2F47757B3FD4275C9F01")
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
            boolean var5969E37520F40BCD8DA013ED3783BF82_1432683624 = (!canvas.isHardwareAccelerated());
            {
                canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            } //End block
        } //End collapsed parenthetic
        boolean UIAnimationsRunning;
        UIAnimationsRunning = false;
        {
            boolean var438456B32769D6A7B316667DCB4406FE_1452830791 = (mNativeClass != 0 && !canvas.isHardwareAccelerated()
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
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_617141242 = (canvas.isHardwareAccelerated());
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
                    boolean varB9C4161DF2F7ECD45BDF12D53A873278_1789691450 = (mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled());
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
                    boolean varDFCE6862E0CA36047A4C3134A0AB6043_1182134425 = (mZoomManager.isZoomAnimating() || UIAnimationsRunning);
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
                boolean varF6566AA8A24398D5119084D846E17436_1460947280 = (!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode());
                {
                    didUpdateWebTextViewDimensions(ANYWHERE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.843 -0400", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "6241E7B34A6BD595A7B0F31C423E8DAB")
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
            boolean varE3C5F3369D1CDF36597C49DAB102029E_1085678061 = (iter.next(r));
            {
                r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
                {
                    boolean var6DFFCCE966800787D5E5EFDDEDE35151_1150001076 = (r.intersect(clip));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.843 -0400", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "D8985D3BBB3470BDC6CE984D5FEA15F7")
    @DSModeled(DSC.SAFE)
     boolean drawHistory() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDrawHistory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.844 -0400", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "CE9A21557F377660F5B43A0D9D36CE2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getHistoryPictureWidth() {
        {
            Object var5C92612DE9888EAC00CA7C21ECDC0B5E_1392182296 = (mHistoryPicture.getWidth());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.844 -0400", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "2066AAF366F5D6AC6403261B7CC57550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void switchOutDrawHistory() {
        {
            boolean var4213A82FBAD6D3C76E09EE9714EFE36E_1287939378 = (mDrawHistory && (getProgress() == 100 || nativeHasContent()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.844 -0400", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "3BBA0797E621B31CE54D5A3E8A103DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.844 -0400", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "B4F51BEAC48A28C0269DE9F4BB75AC41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.845 -0400", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "3B8242575FC66C39C433A995E01AE434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void deleteSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.845 -0400", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "07C4E2E162792A8131025DDE534EE54D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.845 -0400", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "6DF3BD2006CFC98277BF87D1911007B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.845 -0400", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "8E3A9CD849CBD67EFAE5BF14929BACE9")
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
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_1499997804 = (inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.846 -0400", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "33B7440096C9F207E9837DC1D02072E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void hideSoftKeyboard() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean var1C65995F61E387B4C34088A3BF18BF15_1474595338 = (imm != null && (imm.isActive(this)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.846 -0400", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "FF7BBD5575A7CF8B88CC3F575A6A00CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void rebuildWebTextView() {
        {
            boolean varD65E3F1F95872BCE9675FDBCB6E52A34_1749337148 = (!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus()));
        } //End collapsed parenthetic
        boolean alreadyThere;
        alreadyThere = inEditingMode();
        {
            boolean var7605F9B50D3E6B1FCD1B43262B1DB86A_593745120 = (0 == mNativeClass || !nativeFocusCandidateIsTextInput());
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
            boolean varBCF51FD17B0A78CB3F43132D03F914EA_354400510 = (imm != null && imm.isActive(mWebTextView));
            {
                imm.restartInput(mWebTextView);
                mWebTextView.clearComposingText();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_830979384 = (isFocused());
            {
                mWebTextView.requestFocus();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.846 -0400", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "2E86ADCC0BD894A7BCC8F07A1389B90A")
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
            boolean var5F1F7DC9987FB452C0CD065A1A522578_1502533905 = (!Rect.intersects(bounds, visibleRect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "297491AEC1F1D93CAB767A3EDBD5D37D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "C79360889439696E82BC1DD990D797CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void revealSelection() {
        {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "4A2D9365C02DDA69D7C4B923CB935D8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(autoComplete);
        dsTaint.addTaint(autoFillable);
        dsTaint.addTaint(name);
        {
            boolean varF44B622654F1EDE6833649178C55B74F_2091885135 = (mWebViewCore.getSettings().getSaveFormData());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "7A019CB1F4F2A73C081EBDCBDD813B91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestLabel(int framePointer, int nodePointer) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(framePointer);
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                //nodePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "095BD32945AB1C2E270DEA25ED8552A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
        // ---------- Original Method ----------
        //nativeDumpDisplayTree(getUrl());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.847 -0400", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "E484E51FADDFAF343958B4A526215E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpDomTree(boolean toFile) {
        dsTaint.addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "0C9FCCE7BE72F63FA7013B6B277BDF63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpRenderTree(boolean toFile) {
        dsTaint.addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "5A01FAE035DC9B2B19C3CFCD95128CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "46FC00E6808DC26531FC733CD56A9659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "AD73DDA9DEE4DBACADAAC65BAB256F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "124D693A23802FC37898FC0B07A23510")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        {
            boolean var858C72F44AB8CD41BC0BE3BD37D47DCB_2133543971 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.848 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "AFF3891DE7800AE77A23AA8639AB239E")
    @DSModeled(DSC.SAFE)
    private boolean isEnterActionKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.850 -0400", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "5DB9E9FD85495D72D2B83905108B5443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var057857A71DAAF22FA381D228F5183695_1204856115 = (event.isCtrlPressed());
        } //End collapsed parenthetic
        {
            mAutoRedraw = !mAutoRedraw;
            {
                invalidate();
            } //End block
        } //End block
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_455705521 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_2013105881 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_2080668243 = (AccessibilityManager.getInstance(mContext).isEnabled());
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
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1699951748 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_1618908911 = (mAccessibilityInjector.onKeyEvent(event));
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
                boolean var01265F35364458CD2A88FFB15C2C1B92_2006177565 = (event.hasNoModifiers());
                {
                    pageUp(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_761405269 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageUp(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_903352912 = (event.hasNoModifiers());
                {
                    pageDown(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1266421505 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageDown(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean var4D7637BE3E5BB8DFB8BE9F5DEBBD0190_996505609 = (keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers());
            {
                pageUp(true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCDA174DB103BE1133CABA578513ECF4C_965866253 = (keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers());
            {
                pageDown(true);
            } //End block
        } //End collapsed parenthetic
        {
            switchOutDrawHistory();
            {
                boolean var5EC168B85D610989E99D878E0C758737_1894615509 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varAC7A24F7600680817ED76B813249DD81_1355364331 = (event.hasModifiers(KeyEvent.META_ALT_ON));
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
                    boolean var563F44E657D7D016C02306EF7D73B63C_573245029 = (pinScrollTo(0, mScrollY, true, 0));
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    nativeClearCursor();
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    boolean var05C6B866B6258D11272BBA227622E49C_613504497 = (pinScrollTo(mContentWidth, mScrollY, true, 0));
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
                boolean varECFDC30B9B17E54572F391464D24DDCA_593654218 = (navHandledKey(keyCode, 1, false, event.getEventTime()));
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
                boolean var1C3F6BC8881ADE70AD0B6D90845DAEAD_1718920481 = (event.getRepeatCount() == 0);
                {
                    mGotCenterDown = true;
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var887BE5E0D671A1E9580BF5C98186B06D_332605348 = (getSettings().getNavDump());
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
            boolean varFBB0B09776F969247DB212E1762B7005_1868686610 = (nativeCursorIsTextInput());
            {
                mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
                rebuildWebTextView();
                {
                    boolean var91CFAA6DBB8ACD778F334172661A353F_699180324 = (inEditingMode());
                    {
                        mWebTextView.setDefaultSelection();
                        boolean var0E01D6F0C9B3C4661498B390117F08D9_1941476866 = (mWebTextView.dispatchKeyEvent(event));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var4BF8F7F944B1F59AAF473CC034212BAF_1289088306 = (nativeHasFocusNode());
                {
                    rebuildWebTextView();
                    {
                        boolean varCC7B651C81D6575D905B32AE4D2DE9FF_193116680 = (inEditingMode());
                        {
                            mWebTextView.setDefaultSelection();
                            boolean var94D478091AA1B30B7403F71D4EA231CE_1431876825 = (mWebTextView.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_523426349 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.851 -0400", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "797CB94E1CD1F0F919FF91AF5FD07583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varFB3D894E81BEF45C7836AA612BE5CF4E_2072550881 = (keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode());
            {
                String text;
                text = nativeCursorText();
                {
                    boolean var0730AC3C43F6F231E2E36B9DE5B4A786_2041850948 = (!nativeCursorIsTextInput() && text != null
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
            boolean var418B2724488F40E407E2D4BA258E6AE2_983433395 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_1242882350 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1654449343 = (AccessibilityManager.getInstance(mContext).isEnabled());
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
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1819314124 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_1610076598 = (mAccessibilityInjector.onKeyEvent(event));
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
                boolean var5EC168B85D610989E99D878E0C758737_1948489590 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF2C062DAF4D50BEAFF0E218848138E20_2013380282 = (isEnterActionKey(keyCode));
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
                    boolean var1C0F8D4E9F76762BB9ABC943F1506101_456790838 = (!nativeCursorIntersects(visibleRect));
                } //End collapsed parenthetic
                WebViewCore.CursorData data;
                data = cursorData();
                mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
                playSoundEffect(SoundEffectConstants.CLICK);
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_1986603546 = (nativeCursorIsTextInput());
                    {
                        rebuildWebTextView();
                        centerKeyPressOnTextField();
                        {
                            boolean varDB1B9C12ED48DAB084977319495C514C_552896360 = (inEditingMode());
                            {
                                mWebTextView.setDefaultSelection();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                clearTextEntry();
                nativeShowCursorTimed();
                {
                    boolean var34E3725E8E3257788672BB9D0420AAC0_1046341504 = (mCallbackProxy.uiOverrideUrlLoading(nativeCursorText()));
                } //End collapsed parenthetic
                {
                    boolean var2B73408B18669E3ED44DEC84F3F8FE87_454489190 = (nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents());
                    {
                        mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_97479183 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.853 -0400", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "11DCA5C48E0C889CD225E0C7BED7DE3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setUpSelect(boolean selectWord, int x, int y) {
        dsTaint.addTaint(selectWord);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var1C653723DC415BF11BF974AF60071D68_777585037 = (inFullScreenMode());
        } //End collapsed parenthetic
        nativeResetSelection();
        {
            boolean var5D0F3C45A3AF9494DFD7437F551FA15B_1661237648 = (selectWord && !nativeWordSelection(x, y));
            {
                selectionDone();
            } //End block
        } //End collapsed parenthetic
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
        {
            boolean varB8A3B697E17C784F74A8FDA17CF85863_302172280 = (startActionMode(mSelectCallback) == null);
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
            boolean var5225ACD2E56334E54962D68427F36819_1792349714 = (nativeHasCursorNode());
            {
                Rect rect;
                rect = nativeCursorNodeBounds();
                mSelectX = contentToViewX(rect.left);
                mSelectY = contentToViewY(rect.top);
            } //End block
            {
                boolean varBE337274F3E43C04FF66B457B0EF7AE1_1336589540 = (mLastTouchY > getVisibleTitleHeightImpl());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.853 -0400", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "397EF000EB5841A9556B40D05B9E7E33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //setUpSelect(false, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.866 -0400", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "732A472F6455BA1D2A21F68D1939A238")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectAll() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_1711528804 = (inFullScreenMode());
        } //End collapsed parenthetic
        {
            Point select;
            select = nativeSelectableText();
            {
                boolean varAEB90306D9A88D63001E6EB8A442969D_1453822771 = (!selectText(select.x, select.y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.866 -0400", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "52C98EE1C4524A42D0A6137208BBFA56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void selectionDone() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.867 -0400", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "8246F4A7263EB574F4311820471EC542")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.867 -0400", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "2E9C330995F1503DA2F4A074B32F4B11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchBox getSearchBox() {
        {
            boolean var575F4597422E60100014A3F178C01D0F_2101455054 = ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null));
        } //End collapsed parenthetic
        SearchBox var96D2C2C612208F805ACC6282C981F076_1231115657 = (mWebViewCore.getBrowserFrame().getSearchBox());
        return (SearchBox)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null)) {
            //return null;
        //}
        //return mWebViewCore.getBrowserFrame().getSearchBox();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.867 -0400", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "1878FD6BC7B25D86AF7B7A4A3060EF63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getSelection() {
        String var50D5BADA1C94EAD5BF704BB1EED0B40C_8211974 = (nativeGetSelection());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mNativeClass == 0) return "";
        //return nativeGetSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.867 -0400", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "9F04E9C9194517CD23BECF787303E907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_1371065934 = (hasWindowFocus());
            setActive(true);
        } //End collapsed parenthetic
        ViewTreeObserver treeObserver;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.868 -0400", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "4AA4CFD798071B742D6B7B97B65F1D98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_1330012506 = (hasWindowFocus());
            setActive(false);
        } //End collapsed parenthetic
        ViewTreeObserver treeObserver;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.868 -0400", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "D2E9E20CF2DA8E5447A1EDC46F7B63F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.869 -0400", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "A3F882BB42821C38E691FA325F375DE6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onChildViewAdded(View parent, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.869 -0400", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "52135DE9888D3B9801CC6C1DD8045200")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onChildViewRemoved(View p, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.869 -0400", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "55D3B53282DAB681103C4D0E5ABC0B0B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldFocus.dsTaint);
        dsTaint.addTaint(newFocus.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.869 -0400", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "620D42C76BA80781293C75E1544E8275")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setActive(boolean active) {
        dsTaint.addTaint(active);
        {
            {
                boolean varC68F8DA53A6E7AE533DF2B6E0273984A_1042633470 = (hasFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
                {
                    mDrawCursorRing = false;
                    {
                        boolean var82DF510B98047A24212E03E202533075_19686570 = (!inEditingMode());
                        {
                            setFocusControllerActive(false);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB5F2F3BA6162A40E6EBD61229A1DF48F_1389870271 = (!mZoomManager.isZoomPickerVisible());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.870 -0400", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "EB976824462943E43FB03D4801334522")
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
            WebSettings settings;
            settings = getSettings();
            {
                boolean var1D74215CA3033399C095EF1282AE5BE7_254134329 = (settings != null && settings.enableSmoothTransition() &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.871 -0400", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "750D64F4D36FAE8DB2C99860B230B156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.872 -0400", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "F0A6E5C43AB745CB8CBAC1473D3757FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        {
            {
                boolean var7FF7C69BF2546C1B46A75E34BBC40609_1386617017 = (hasWindowFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDrawCursorRing = false;
            {
                boolean varD52AFE2B2A5DD9C2C2CA64ADDFB71D04_669638719 = (!inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.872 -0400", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "54B66956DF54307731708D012EE1FC6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.873 -0400", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "56DEAFD7421024EC6DE0E17A8404DF73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.873 -0400", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "5FC3E186135518BC1DECFB2FD4B78ACA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.873 -0400", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "4F3B2B1AE70D659D3D65938368F62E1F")
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
                boolean varB4D4A6A79DEACE1E888BD156FFAF1F5C_1591844498 = (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.873 -0400", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "665D72098F3D7C601728F1C0630E7A03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_1574390231 = (event.getAction());
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
            boolean var5B06505CBCDCB8DEE1F6FB0FBB28CE94_936133247 = (inEditingMode() && mWebTextView.isFocused());
            {
                boolean var055C27F4AD9E2119212195DD41858BDC_1264073540 = (mWebTextView.dispatchKeyEvent(event));
            } //End block
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_420318417 = (super.dispatchKeyEvent(event));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.874 -0400", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "A2E6BDC2B09356CED7E3752535D1E1B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hitFocusedPlugin(int contentX, int contentY) {
        dsTaint.addTaint(contentX);
        dsTaint.addTaint(contentY);
        {
            Rect r;
            r = nativeFocusNodeBounds();
        } //End block
        boolean varAADFA5397280FFF07498DCDB610497F5_769292607 = (nativeFocusIsPlugin()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.874 -0400", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "30FD823536FECE5AA1C6E4D28A0FC531")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.874 -0400", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "B18A252B531FB4449326947BDDC9F905")
    @DSModeled(DSC.SAFE)
    private boolean inFullScreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFullScreenHolder != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.874 -0400", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "CFDACCBE86E4961929BC9FA13EA1ECDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissFullScreenMode() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_172940267 = (inFullScreenMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.874 -0400", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "ADA24DB953E0EB7EB11E71E67325FC31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onPinchToZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelTouch();
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //cancelTouch();
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.875 -0400", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "0E3568546CD9D9DFA8BC0BFD865D5974")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.875 -0400", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "78030028617C0F896B61717276A6510A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.875 -0400", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "EEF5F80B17204021218ACFC78EB60775")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.875 -0400", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "8210BB73EB35757FD732333DB21ECB6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varAD562CF087912EB5FF0170636C3B2B0D_1950344274 = (mNativeClass == 0 || (!isClickable() && !isLongClickable()));
        } //End collapsed parenthetic
        {
            boolean varDD40B025666699E2A78E1AD03139D936_473773105 = (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.876 -0400", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "F4DA64FFA7F81C43FA73EC6DFD451006")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float calculateDragAngle(int dx, int dy) {
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        float var0DC0C40463DA1E6DC4A725D44FA13B49_1526749104 = ((float) Math.atan2(dy, dx));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //dx = Math.abs(dx);
        //dy = Math.abs(dy);
        //return (float) Math.atan2(dy, dx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.880 -0400", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "D03FD3B486EB981A7426667D05DB5ADE")
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
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1206913085 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    mTouchMode = TOUCH_DRAG_START_MODE;
                    mConfirmMove = true;
                    nativeSetIsScrolling(false);
                } //End block
                {
                    boolean varBDC63CBFC1D5292A90395B799377E3CA_1070164486 = (mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP));
                    {
                        mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_1880370900 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
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
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_1919137645 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
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
                                        boolean varD778979F37708EA925216FB277FD8D27_1880802012 = (getSettings().getNavDump());
                                        {
                                            mTouchHighlightX = (int) x + mScrollX;
                                            mTouchHighlightY = (int) y + mScrollY;
                                            mPrivateHandler.postDelayed(new Runnable() {                                                
                                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.877 -0400", hash_original_method = "7498706CCC2860B05B7071008D2A72AF", hash_generated_method = "BDEB34128B671E054A924D53CAF12B4F")
                                                //DSFIXME:  CODE0002: Requires DSC value to be set
                                                public void run() {
                                                    mTouchHighlightX = mTouchHighlightY = 0;
                                                    invalidate();
                                                    // ---------- Original Method ----------
                                                    //mTouchHighlightX = mTouchHighlightY = 0;
                                                    //invalidate();
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
                    boolean var72609C462D4DCD4473D0A433CA78D370_1729883164 = (inFullScreenMode() || mDeferTouchProcess);
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
                    boolean var8932DD5DB07C85349F24CECE7642DABD_1418104713 = (shouldForwardTouchEvent());
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
                            boolean var6904F2C5D7BEAFC799CAAF4B382483D5_595863940 = (!inFullScreenMode());
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
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_1269084478 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varD5BC4EB905AD1A9E62B09D5876DE7CFA_254272238 = (shouldForwardTouchEvent() && mConfirmMove && (firstMove
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
                        boolean varEF4783D596E01CB01D0208E403EB969C_1564337039 = (firstMove && !inFullScreenMode());
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
                ScaleGestureDetector detector;
                detector = mZoomManager.getMultiTouchGestureDetector();
                mAverageAngle = calculateDragAngle(deltaX, deltaY);
                {
                    boolean varA7D01DAA9313836025F53EEF13EC7FDA_46490870 = (detector == null || !detector.isInProgress());
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
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_917621807 = (!isFocused());
                requestFocus();
            } //End collapsed parenthetic
            {
                boolean var4F0E2B9C4455366734F8A4D46CDF3837_1242150371 = (shouldForwardTouchEvent());
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
                boolean var99D9C999635D25840B0CAFFCC353615B_1109850001 = (inFullScreenMode() || mDeferTouchProcess);
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
                    boolean var9A35F484FD2A3035C5778E7274850AEE_227860955 = (mPreventDefault != PREVENT_DEFAULT_YES
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
                        boolean var52238646ADDC3EDB53CF60FF8D752DAA_1587859981 = (!nativeHitSelection(contentX, contentY));
                        {
                            selectionDone();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var7ECA0E1176F50826819D1E05F7BE240D_1928607629 = (mTouchMode == TOUCH_INIT_MODE
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
                    boolean varBCFC69392A8766EDCCDAD1B162C3D405_1063699481 = (mScroller.springBack(mScrollX, mScrollY, 0,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.881 -0400", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "904549C3511CC214880D9923756D4268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        dsTaint.addTaint(ev.dsTaint);
        dsTaint.addTaint(sequence);
        TouchEventData ted;
        ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.882 -0400", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "672CD87AB7C3BA433941D8C75FEFED85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleMultiTouchInWebView(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        float x;
        x = ev.getX();
        float y;
        y = ev.getY();
        {
            detector.onTouchEvent(ev);
            {
                boolean var57DA30FC8CBBE7A73D9281B93734CBB1_2048586209 = (detector.isInProgress());
                {
                    mLastTouchTime = ev.getEventTime();
                    x = detector.getFocusX();
                    y = detector.getFocusY();
                    cancelLongPress();
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    {
                        boolean var1701A38F89582DE3B703C873F3E6A99C_117657052 = (!mZoomManager.supportsPanDuringZoom());
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
            boolean var3FCFE6069F8C28D647A3D03480A488F3_88707594 = (action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2);
            {
                mLastTouchX = Math.round(x);
                mLastTouchY = Math.round(y);
            } //End block
        } //End collapsed parenthetic
        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.883 -0400", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "EABCE1FA2A25CAE5D33E2314C85AD6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        dsTaint.addTaint(removeEvents);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean var3C4264CDBD1B465E519441FFC519D662_1585621902 = (shouldForwardTouchEvent());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.883 -0400", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "EDBCE2711D8C82335A27D491745DBC55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.883 -0400", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "319FC1C72835795F52968677012BD08A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.884 -0400", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "E4672106EFFCE82A04E21A40997F528D")
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
                int contentX;
                contentX = viewToContentDimension(deltaX);
                int contentY;
                contentY = viewToContentDimension(deltaY);
                int maxX;
                maxX = mScrollingLayerRect.right;
                int maxY;
                maxY = mScrollingLayerRect.bottom;
                int resultX;
                resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                int resultY;
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
                boolean var5792E174AFE968D06415B5B7AAC36535_525789101 = (mOverScrollGlow != null && mOverScrollGlow.isAnimating());
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mZoomManager.keepZoomPickerVisible();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.884 -0400", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "F4F1B6CD0083C974948AF19093AD2700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stopTouch() {
        {
            boolean varCAF00077668D04F986EAAEC815FA20E7_49327102 = (mScroller.isFinished() && !mSelectingText
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.885 -0400", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "6ACD90A8273AC0816AA95B7965C587ED")
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
            boolean varAC20DC667EA914A16B375E9527C79DFD_908349409 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.885 -0400", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "85D55284AEA919C72C2EBE93A5F09F71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1423617290 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_2045482896 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_563565223 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
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
                            int vdelta;
                            vdelta = (int) (vscroll * getVerticalScrollFactor());
                            int hdelta;
                            hdelta = (int) (hscroll * getHorizontalScrollFactor());
                            {
                                boolean var2D3D9D2324BD436DC860CC59381AD41D_1982687228 = (pinScrollBy(hdelta, vdelta, false, 0));
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1354307617 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.886 -0400", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "C72ECD10650E9982ED8284B25E01E30B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMapTrackballToArrowKeys(boolean setMap) {
        dsTaint.addTaint(setMap);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
        //mMapTrackballToArrowKeys = setMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.886 -0400", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "6AC8F93A7F315BEE56D465931AC8D27F")
    @DSModeled(DSC.SAFE)
     void resetTrackballTime() {
        mTrackballLastTime = 0;
        // ---------- Original Method ----------
        //mTrackballLastTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.887 -0400", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "36FD37DE8AFBEABDD35A9374B3DFC82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        long time;
        time = ev.getEventTime();
        {
            boolean varF89B2554B17216A1EC58B9D61476F71F_1199035573 = ((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0);
            {
                {
                    boolean varF71C9C4037B7A9B705CFAAB9834929D8_1601189644 = (ev.getY() > 0);
                    pageDown(true);
                } //End collapsed parenthetic
                {
                    boolean var07FD34B1A3496FC381CDBE7EFC3BB0AA_512753015 = (ev.getY() < 0);
                    pageUp(true);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_209369908 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                mTrackballDown = true;
                {
                    boolean varD7E949BAB427F90FF96CAA2888F6F2C4_426842687 = (time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds()));
                    {
                        nativeSelectBestAt(mLastCursorBounds);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varAFC77293C02F773029137FDE42129C14_540604626 = (isInTouchMode());
                    requestFocusFromTouch();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9BE2C50B8CBB194C9242022F6D5B67CC_1939444652 = (ev.getAction() == MotionEvent.ACTION_UP);
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
            boolean var963F7CE81FE031C5E5B8879F84F3644B_1287359850 = ((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.888 -0400", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "262781C83857A1AC882D89357C644E99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.888 -0400", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "B81AEEBDAF673DDFD52EADA0580CA043")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.888 -0400", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "BD125196BF5FFD346D24291FC78FA4D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.889 -0400", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "EA6318D6179E0D925FC6BB428C0F4B44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int keyCodeToSoundsEffect(int keyCode) {
        dsTaint.addTaint(keyCode);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.890 -0400", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "068D4A2961849BC4B10AE770F6736206")
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
                boolean var13243A190284240A17DA938A95FFCA4B_1430755592 = (mNativeClass != 0 && nativePageShouldHandleShiftAndArrows());
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
                    boolean var9216DDA0E70E02F03C94252CA6894A26_369146146 = (navHandledKey(selectKeyCode, count, false, time));
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
                boolean var1510D01512E341B4186F1DC473D82D5C_1356632773 = (Math.abs(mScrollX - oldScrollX) > Math.abs(xMove));
                {
                    xMove = 0;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varEA9F4D4529504DF5B7FB3F15ED262404_1656824651 = (Math.abs(mScrollY - oldScrollY) > Math.abs(yMove));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.890 -0400", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "165BD05AC1205C09C94D498DA2B36D20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int computeMaxScrollX() {
        int varA25CFD9DF68C570DBFC28D80EAD42611_1176941071 = (Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.890 -0400", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "624B387ECDE21FD71AA921B9BB0A9C76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int computeMaxScrollY() {
        int varBA3EE78DB7716D218FE9D8E3CD2F2343_827086440 = (Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                //- getViewHeightWithTitle(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.890 -0400", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "EF0C28E0102C2B932B814D4D649A5600")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.890 -0400", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "089CF654CAFB6D42A234123ACB9ECCE5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.891 -0400", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "BD2B6B97FDF0951E14F3764141C1191A")
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
                boolean var294FD332965037BDDAF5E40360BE82C6_1501036493 = (mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY));
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
            float circle;
            circle = (float) (Math.PI) * 2.0f;
            {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
            } //End block
        } //End block
        {
            boolean var7D437B480773CFFE36BF196E1126697F_1565428196 = ((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy));
            {
                vx = 0;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var062E5EDAB50CDBF113CFC310D559CF03_1657903154 = ((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx));
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
        int time;
        time = mScroller.getDuration();
        {
            awakenScrollBars(time);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.892 -0400", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "57F36251E365A154A0E832907B2C5AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public View getZoomControls() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_288337354 = (!getSettings().supportZoom());
        } //End collapsed parenthetic
        View varA42D8B8924B07B5130F0496CCA7A32D7_1082102722 = (mZoomManager.getExternalZoomPicker());
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return null;
        //}
        //return mZoomManager.getExternalZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.892 -0400", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "E0110D1A2A491ABF92EE451CB29B8360")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
        // ---------- Original Method ----------
        //mZoomManager.dismissZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.892 -0400", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "EA80FEA2FE2FACF29F0A13E70CA95402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getDefaultZoomScale() {
        float var952A9E36B82C4A93C3ADCF5509083504_828692327 = (mZoomManager.getDefaultScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getDefaultScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.892 -0400", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "508F79EB883A355A6252E897D425D6E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float getZoomOverviewScale() {
        float varEF858DD667F2D952B7E5019CEC33E4DD_1477932909 = (mZoomManager.getZoomOverviewScale());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mZoomManager.getZoomOverviewScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.893 -0400", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "905687D363B4F4798B40BEC8AFA2E15E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canZoomIn() {
        checkThread();
        boolean varB7D0C9863F46AF864AE5BCCDA2FEA388_201141594 = (mZoomManager.canZoomIn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.893 -0400", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "A510B1FF93F1DCCAB6654A783FFA7EFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canZoomOut() {
        checkThread();
        boolean var55B9AB817324FC769B25B74F0D5FB277_1507465730 = (mZoomManager.canZoomOut());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.893 -0400", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "7665B4FF9904B163B56E533D3FEED3D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomIn() {
        checkThread();
        boolean varAC42C946D5F06586AAF06194E5591056_1099898143 = (mZoomManager.zoomIn());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.893 -0400", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "56F5F17FE95E0BA9043454731AEE4043")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean zoomOut() {
        checkThread();
        boolean varA9C5CE6824B53568BAC50FAF0F581652_730447788 = (mZoomManager.zoomOut());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.893 -0400", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "48AFB1D4C92D3637F7483F34272B10ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.894 -0400", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "20F077B4F8603AD424A79C6FAB4CECB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scrollFocusedTextInputX(float xPercent) {
        dsTaint.addTaint(xPercent);
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1009833786 = (!inEditingMode() || mWebViewCore == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.894 -0400", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "1D68D5DA5FA359645FCC9AB3C38D4CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scrollFocusedTextInputY(int y) {
        dsTaint.addTaint(y);
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1303598180 = (!inEditingMode() || mWebViewCore == null);
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.894 -0400", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "FAEFE2105E23F8AE15E384398AA70B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void initiateTextFieldDrag(float x, float y, long eventTime) {
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_147454385 = (!inEditingMode());
        } //End collapsed parenthetic
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_1403181648 = (!mScroller.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.895 -0400", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "2946AB3CCC014AD1625B3DE14AEDD04D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean textFieldDrag(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_842946237 = (!inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.895 -0400", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "568AB1D15A9C7030A1CC51C5225A30FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void touchUpOnTextField(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_1081420268 = (!inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.895 -0400", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "07B7429CE92B5FFBFFF85A5139F60BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    //nativeCursorNodePointer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.896 -0400", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "00239B8EE981897E587C8AD45D98709B")
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
            boolean var4BAF6D43948FA1BCD9CF85CF914BDF89_1633037100 = (USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty());
            {
                mTouchHighlightRequested = 0;
                invalidate(mTouchHighlightRegion.getBounds());
                mPrivateHandler.postDelayed(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.895 -0400", hash_original_method = "862A653E9B61CDCF6EC82472350CCAAA", hash_generated_method = "E8C29D6A71E7E23B309BC73E875C4F22")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void run() {
                        removeTouchHighlight();
                        // ---------- Original Method ----------
                        //removeTouchHighlight();
                    }
}, ViewConfiguration.getPressedStateDuration());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5F51EF0491BBB7096F9C5C6CD4BCA197_893993567 = (getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
                WebViewCore.TouchUpData touchUpData;
                touchUpData = new WebViewCore.TouchUpData();
                touchUpData.mMoveGeneration = 0;
                mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
            } //End block
            {
                boolean varDA83C45CB8F2A6B5FD9F88AE0C10D3FD_1283085866 = (nativePointInNavCache(contentX, contentY, slop));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.896 -0400", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "1877A558B974DC6F9E045E0A16D36982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doMotionUp(int contentX, int contentY) {
        dsTaint.addTaint(contentX);
        dsTaint.addTaint(contentY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varC55016010C379CE34BF3B6896DDAD394_701121691 = (nativeMotionUp(contentX, contentY, slop) && mLogEvent);
            {
                EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7C1BED8D4E1F2400404C847BC14812AF_1431123750 = (nativeHasCursorNode() && !nativeCursorIsTextInput());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.896 -0400", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "C93F605E15A477EBB506444304D44C5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.896 -0400", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "608961F8DDA79B3838F902DF0C221323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Rect getPluginBounds(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varE761D0BE351A5DB0C46D78ECBD6C783A_1339711748 = (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin());
            {
                Rect var00CB1A97DE918DF5494318893B9A376C_354773230 = (nativeCacheHitNodeBounds());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.897 -0400", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "01FA7A05CE214E690F5635AC81018464")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isRectFitOnScreen(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        int rectWidth;
        rectWidth = rect.width();
        int rectHeight;
        rectHeight = rect.height();
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        boolean var21C05C69D4E6BB9F2891D7DC21CA89A0_1682312799 = (!mZoomManager.willScaleTriggerZoom(scale)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.897 -0400", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "BDCDF33573B9CA9E44569AD4C14227AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void centerFitRect(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
        int rectWidth;
        rectWidth = rect.width();
        int rectHeight;
        rectHeight = rect.height();
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        {
            boolean varDD6431018C58684D7A37FFB96BEA1A10_1497389063 = (!mZoomManager.willScaleTriggerZoom(scale));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.898 -0400", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "40B7787F35AA5F41C86CEDFB2E8D710B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void overrideLoading(String url) {
        dsTaint.addTaint(url);
        mCallbackProxy.uiOverrideUrlLoading(url);
        // ---------- Original Method ----------
        //mCallbackProxy.uiOverrideUrlLoading(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.898 -0400", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "823FC3032BEE91FE476079994DB30FBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        boolean result;
        result = false;
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1682845991 = (inEditingMode());
            {
                result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
            } //End block
            {
                result = super.requestFocus(direction, previouslyFocusedRect);
                {
                    boolean varA494CE1F4ADF8E7072392AACBFD5D724_1539949486 = (mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode());
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
                            boolean var191048386196A56D55A1FA6B9EBCC1D7_130500227 = (mNativeClass != 0 && !nativeHasCursorNode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.899 -0400", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "BA415821C164C7FDAEC9DF962A05583B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.901 -0400", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "255FE31F623727930599FD1E40B56FB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rect.dsTaint);
        {
            boolean var264B566DF21DF74851E1F42772AB9C13_1982860942 = (mZoomManager.isFixedLengthAnimationInProgress());
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
                boolean varD63CDEF6BD028FCFFAC8F4D0CD965025_394251916 = (rect.height() > 2 * oneThirdOfScreenHeight);
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
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1885091789 = (rect.width() > width);
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
            boolean var5E8E4CF43F6392F54248EF881F3D0871_1441536143 = (pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.902 -0400", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "8362CECCBE58C9C797CAFA871D4D3787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        dsTaint.addTaint(replace);
        dsTaint.addTaint(oldEnd);
        dsTaint.addTaint(newStart);
        dsTaint.addTaint(oldStart);
        dsTaint.addTaint(newEnd);
        WebViewCore.ReplaceTextData arg;
        arg = new WebViewCore.ReplaceTextData();
        arg.mReplace = replace;
        arg.mNewStart = newStart;
        arg.mNewEnd = newEnd;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.902 -0400", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "3E2617EDEECF767B72C808EC7EC2E7F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void passToJavaScript(String currentText, KeyEvent event) {
        dsTaint.addTaint(currentText);
        dsTaint.addTaint(event.dsTaint);
        WebViewCore.JSKeyData arg;
        arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.902 -0400", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "E79DA86FB51C12E059E4780282239D0E")
    @DSModeled(DSC.SAFE)
    public synchronized WebViewCore getWebViewCore() {
        return (WebViewCore)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.924 -0400", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "3E568CD14CB4A957D013A2BBC5E09CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTouchHighlightRects(ArrayList<Rect> rects) {
        dsTaint.addTaint(rects.dsTaint);
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
        {
            {
                Iterator<Rect> var667F73C18A060295B52BA65D5642C74D_1977576959 = (rects).iterator();
                var667F73C18A060295B52BA65D5642C74D_1977576959.hasNext();
                Rect rect = var667F73C18A060295B52BA65D5642C74D_1977576959.next();
                {
                    Rect viewRect;
                    viewRect = contentToViewRect(rect);
                    {
                        boolean varA5A6B8C49AB9156241CF88CA93A69E58_1370839525 = (viewRect.width() < getWidth() >> 1
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.925 -0400", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "0423CB641471FC07C16C29348A683353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void pageSwapCallback(boolean notifyAnimationStarted) {
        dsTaint.addTaint(notifyAnimationStarted);
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1886524054 = (inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.926 -0400", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "A1B82218630E707F02314B45758CFC0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        dsTaint.addTaint(draw.dsTaint);
        dsTaint.addTaint(updateBaseLayer);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
            } //End block
        } //End block
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
        Point viewSize;
        viewSize = draw.mViewSize;
        boolean updateLayout;
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
            boolean var926A8D0B5C0D740061680329138C210C_268966009 = (draw.mFocusSizeChanged && inEditingMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.926 -0400", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "7D42ACA34E5F58B95E06159371B16F5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        dsTaint.addTaint(nodePointer);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(textGeneration);
        {
            boolean var179B09369C5FEC85CD8155FF224AECDC_1403479044 = (inEditingMode()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.926 -0400", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "CD108CD97CA3CB47A5E3DD99832C70CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        dsTaint.addTaint(selectedArray[0]);
        dsTaint.addTaint(enabledArray[0]);
        dsTaint.addTaint(array[0]);
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selectedArray));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.927 -0400", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "17A24BB1D59B6B978B63000CB2DD6EB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestListBox(String[] array, int[] enabledArray, int selection) {
        dsTaint.addTaint(enabledArray[0]);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(array[0]);
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selection));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.927 -0400", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "FADD7B8CDC71275ED44D85DF46CB22B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMoveFocus(int frame, int node) {
        dsTaint.addTaint(node);
        dsTaint.addTaint(frame);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                //new WebViewCore.CursorData(frame, node, 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.927 -0400", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "6FED2D44B61F4AABE6998A6F5E7D0F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.927 -0400", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "BEFD59BFA6C61528ED3906F35EC3A945")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.928 -0400", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "B66053B7D425DE0EDCC682296765EB54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.928 -0400", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "74434B7C5C5F5A12C8F38357876526C9")
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
        int var4CD57EC65F046B376944293A38E9A187_638836124 = (viewToContentX(width));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.929 -0400", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "1598F193CA97C5CB02838C21CB838EC2")
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
        int var3B6C50355F4C83B6515E3BB844F5C669_249722753 = (Math.round(height * mZoomManager.getInvScale()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.930 -0400", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "43791F1CBB48DBD139A4E7B1FDB49008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void viewInvalidate() {
        invalidate();
        // ---------- Original Method ----------
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.930 -0400", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "A6D19BCDC994B612006BBB6125B73CF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.931 -0400", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "124F056BEF60408B64FDA82E7BD99F45")
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
            boolean var78E9DE151C1DFEF7820F7C4599A2F8D0_715333875 = (contentCursorRingBounds.isEmpty());
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
            boolean varB6D877D107F828AA26477AA9FEE04EDD_1057933363 = (Rect.intersects(outset, viewCursorRingBounds) == false);
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
            boolean var6A8A4E436D7412BEF448043644BD31DB_122999629 = (mLastCursorBounds.isEmpty());
        } //End collapsed parenthetic
        {
            boolean var46EFF7D5420AE1A7A30F7E288D313B74_605639704 = (mLastCursorBounds.equals(contentCursorRingBounds));
        } //End collapsed parenthetic
        requestRectangleOnScreen(viewCursorRingBounds);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.931 -0400", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "CF4D613FAE1E38F6878EE54154746488")
    @DSModeled(DSC.SAFE)
    private boolean accessibilityScriptInjected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityScriptInjected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "3F2E7889F0CC045A99B53D6DED36581B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setBackgroundColor(int color) {
        dsTaint.addTaint(color);
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
        // ---------- Original Method ----------
        //mBackgroundColor = color;
        //mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "85CCCEA00CCFC3C2990DD68DC174D234")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "49C11A46779F1E96E386D8C36C8F69E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void drawPage(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
        // ---------- Original Method ----------
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "3921830CCBC51BFF28024E120E2B700F")
    @DSModeled(DSC.SAFE)
    public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
        //mHTML5VideoViewProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "83B46FDD7BE3C477C4BCEC75E236A8FA")
    @DSModeled(DSC.SAFE)
    public void setTouchInterval(int interval) {
        dsTaint.addTaint(interval);
        // ---------- Original Method ----------
        //mCurrentTouchInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.932 -0400", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "9FECB6B34299144F93F1171043954E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void updateCachedTextfield(String updatedText) {
        dsTaint.addTaint(updatedText);
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
        // ---------- Original Method ----------
        //nativeUpdateCachedTextfield(updatedText, mTextGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.933 -0400", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "F2C90329121831CDF7727DB2FF2161D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void autoFillForm(int autoFillQueryId) {
        dsTaint.addTaint(autoFillQueryId);
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.933 -0400", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "AD7C1A44CAF2C3731E10582957863380")
    @DSModeled(DSC.SAFE)
     ViewManager getViewManager() {
        return (ViewManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mViewManager;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.933 -0400", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "2C8A3F643487BF9C4C932C87B894FD6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void contentInvalidateAll() {
        {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.933 -0400", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "14F0772081BF82E7E18655BBAC5A6F22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
        // ---------- Original Method ----------
        //nativeRegisterPageSwapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.933 -0400", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "EAF06CEEDE2D5E5967608F86C355FE16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void tileProfilingStart() {
        nativeTileProfilingStart();
        // ---------- Original Method ----------
        //nativeTileProfilingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "0D95E39ABBDF3ECAF653472950D3D682")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float tileProfilingStop() {
        float varB18687EE139E5166CC9AF408D9889054_1548819582 = (nativeTileProfilingStop());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeTileProfilingStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "8FDB7E2C7A9F51E9629172BAF0B24960")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void tileProfilingClear() {
        nativeTileProfilingClear();
        // ---------- Original Method ----------
        //nativeTileProfilingClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "07EB1621C74F6F816F8816840C667DC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingNumFrames() {
        int var169947B5FA60947E0B7BC7984522118F_237403527 = (nativeTileProfilingNumFrames());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingNumFrames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "BBB5A9A41B38BA329E66A24AB228150D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingNumTilesInFrame(int frame) {
        dsTaint.addTaint(frame);
        int varFDE1A8CA934CC4FCCFE59320104D4907_1088082456 = (nativeTileProfilingNumTilesInFrame(frame));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingNumTilesInFrame(frame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "5F750F999B2818DF056E5BEECFA02384")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tileProfilingGetInt(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        int varE7654B1D69F1E5F05A936A8E62104F88_137443671 = (nativeTileProfilingGetInt(frame, tile, key));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeTileProfilingGetInt(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "A11496AB8AA63724AC59C1B582437CBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float tileProfilingGetFloat(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        float varFC830259BB0CC6250B57A21E07835342_279686086 = (nativeTileProfilingGetFloat(frame, tile, key));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeTileProfilingGetFloat(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.934 -0400", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "B884865075DFB6D1DDFFBF254897D9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCacheHitFramePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "3C9D5062D2F06BAEC4DB485C352DAA11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCacheHitIsPlugin() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "6CED70429EF2054BF16F9ACE173627D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeCacheHitNodeBounds() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "B89D054BAB66A1D9B3C02069CC1A03D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCacheHitNodePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "2C929D3168FE3E72D461E6649B6EC306")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void nativeClearCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "2095AD5F2A19E643E4F6920A420DBC19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx) {
        dsTaint.addTaint(isHighEndGfx);
        dsTaint.addTaint(drawableDir);
        dsTaint.addTaint(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "F7DFCFB1A47915264C7372DF918CEB08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCursorFramePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.935 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "76F744DB91B086D203B5C87B43043C15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeCursorNodeBounds() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "6AFF46CC810795AD8DC51F4F04AD031B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeCursorNodePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "FAD8E66ED6831D7E74D400EA5B4706D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIntersects(Rect visibleRect) {
        dsTaint.addTaint(visibleRect.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "4F0A068F232C1C7EB87718C338B51CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIsAnchor() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "7CFC72DCF46D55D3353EA9D76FFBBA10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorIsTextInput() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "292B716B3837AB55CFAC33176571CBCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Point nativeCursorPosition() {
        return (Point)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "EDBA6CC4EF71677F31CF54983F7E869B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeCursorText() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "02FE9CE18CFB352601186637E6FDACB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeCursorWantsKeyEvents() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.936 -0400", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "F601101523F054AD48972FF053FC6215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDebugDump() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "4E16A96D1B9DDA8E601B6F36452E82D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "EF60B30AB4F1948FA2A673A8820AE890")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeDumpDisplayTree(String urlOrNull) {
        dsTaint.addTaint(urlOrNull);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "527CEB4C29F14FB5F748A8F542D07902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeEvaluateLayersAnimations(int nativeInstance) {
        dsTaint.addTaint(nativeInstance);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "3733EA33FB32FD47C6E65C34DBCF3B0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetDrawGLFunction(int nativeInstance, Rect rect,
            Rect viewRect, RectF visibleRect, float scale, int extras) {
        dsTaint.addTaint(viewRect.dsTaint);
        dsTaint.addTaint(scale);
        dsTaint.addTaint(nativeInstance);
        dsTaint.addTaint(visibleRect.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        dsTaint.addTaint(extras);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "255D53BE48C186531B152FAB6EC4E9E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
            RectF visibleRect) {
        dsTaint.addTaint(viewRect.dsTaint);
        dsTaint.addTaint(visibleRect.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.937 -0400", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "8192B37F51E41F90215C1F26E3D850A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeExtendSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "0F01E7BF5C86D3D3B0DE2801F0A5675D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFindAll(String findLower, String findUpper,
            boolean sameAsLastSearch) {
        dsTaint.addTaint(sameAsLastSearch);
        dsTaint.addTaint(findLower);
        dsTaint.addTaint(findUpper);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "82630B9792602A6AEE785559B95FBA32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeFindNext(boolean forward) {
        dsTaint.addTaint(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "B1E5619F61649C1C1A82EF43416722CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateFramePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "77A3A6566A6D8188D74AA586946E56FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateHasNextTextfield() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "54EDCB50513249FF4448EE82A19B0B68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsPassword() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "38CA82324897713EEC00D9B2B1581A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusCandidateIsRtlText() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "F0FACD985C6B26CCA2786C7B2918B3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusCandidateIsTextInput() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "9F976FB5F19BD7978BEC07EBE2EFF44D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateMaxLength() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.938 -0400", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "9482BC00AC74405EE61F1E51AA9933C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsAutoComplete() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "F0E7190D6FF4F819E2E9B729DF198C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeFocusCandidateIsSpellcheck() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "01F3FDBECE4AC0C63C6C249A0002A829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String nativeFocusCandidateName() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "37BAAA335FC2F7D9F1E4913393F63B1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusCandidateNodeBounds() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "DEC449E0C016C91D6A71469A96D87235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusCandidatePaddingRect() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "4329FA80B9B684D18C150ACF097A0EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidatePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "CEBC103030365754AC8DA66513A6EE02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeFocusCandidateText() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "0F47DC6245D14132DB3E570F33D931FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     float nativeFocusCandidateTextSize() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.939 -0400", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "ABF2046249782B7B03B7CE6D782F7D6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusCandidateLineHeight() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "62E8EC532F87818B791F9486B2746A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFocusCandidateType() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "D55181695307EE76C390456FB224F4DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFocusCandidateLayerId() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "2F8AC5A54FAF4CD5B5C34F9778B2F48F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeFocusIsPlugin() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "74BE953F3B4968768BD528E458AEA7E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeFocusNodeBounds() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "54AA55555E4301379CF4C01A94968F37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeFocusNodePointer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "55D55484850CDA53F15D2B0FAD79AB68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeGetCursorRingBounds() {
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "4C66FB821DC7D3C27E9D9259C3BB68C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeGetSelection() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "46B87CF12E4D5C47C9D82E335A922A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasCursorNode() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.940 -0400", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "8FA3EBABF3DCC6E84A40947581C7A9D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasFocusNode() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "C5D686BF12DF1683258EF31789BFD66A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeHideCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "CEFE641239321954A065232213B0E035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHitSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "1D04A419BB13B820D1569DFCF369607A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String nativeImageURI(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "4931CD211AE029703EBE8600C611C50A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeInstrumentReport() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "3177E37009238EC1805878624DB1D071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeLayerBounds(int layer) {
        dsTaint.addTaint(layer);
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "F0AFCACCCF95963C77472FBBA3024057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeMoveCursorToNextTextInput() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "43D604CC6B6498BD16F0E531E4CD2075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeMotionUp(int x, int y, int slop) {
        dsTaint.addTaint(slop);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.941 -0400", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "C2ED1ACB01108DC11CF94852D78BB16F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeMoveCursor(int keyCode, int count,
            boolean noScroll) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(noScroll);
        dsTaint.addTaint(count);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "D6C1EDE5B39153D5D8FFBD6920495B62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeMoveGeneration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "E9A4857EA2BB03ED0ACF8BF7CD821145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeMoveSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "DDC16143E1EBF21A6C892FF3B7B4FC14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativePageShouldHandleShiftAndArrows() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "BA4D685A7ACD8997DADED809AC7042C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativePointInNavCache(int x, int y, int slop) {
        dsTaint.addTaint(slop);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "7E164F51BFD26BAEB37C17707BD8874E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeResetSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "081DBBF89226CB26374ACB3DEBD7901D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Point nativeSelectableText() {
        return (Point)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "5DACEC38ECF99BF3DA52929D8D3AE5DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.942 -0400", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "C579885BDCBEC2803AF2EAFFFC47C344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectBestAt(Rect rect) {
        dsTaint.addTaint(rect.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "36D983EA9B1964B6D7F49A980E51DC51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSelectAt(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "6AE27B8185A98D54E6744920E8158949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeSelectionX() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "D50C9D192E45A2AC533AB9E6E85ECAB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeSelectionY() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "E894C43EEE964711609AC62C8E497552")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeFindIndex() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "5AB5068259CCABEFACDEA5560EBD42C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetExtendSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "BF3E2C6C0F834088FF260D2D57AB8864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetFindIsEmpty() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "311EFBF57CABE9B07D3B73A8FB88DB4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetFindIsUp(boolean isUp) {
        dsTaint.addTaint(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.943 -0400", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "178E2068921E7E72FD8C42F21408F558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetHeightCanMeasure(boolean measure) {
        dsTaint.addTaint(measure);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "A9BB9B8FAF964DF0CCCCB793B4771B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetBaseLayer(int layer, Region invalRegion,
            boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
            boolean registerPageSwapCallback) {
        dsTaint.addTaint(isPictureAfterFirstLayout);
        dsTaint.addTaint(showVisualIndicator);
        dsTaint.addTaint(layer);
        dsTaint.addTaint(invalRegion.dsTaint);
        dsTaint.addTaint(registerPageSwapCallback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "A2579B6E0D2F69A5343DE7618D624A51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetBaseLayer() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "7AA70DF267F5A3B8D5F1139BE8B04F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeShowCursorTimed() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "ADF97184F79D3BC524B13D2FE721B9BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeReplaceBaseContent(int content) {
        dsTaint.addTaint(content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "09B5842A6DCA9996825E63D4BF37FDC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeCopyBaseContentToPicture(Picture pict) {
        dsTaint.addTaint(pict.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "43FA246FE408092B8645BB389FD8880D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeHasContent() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "8BA5E1F949AB6376472A6F5B4E32B86B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetSelectionPointer(int nativeInstance,
            boolean set, float scale, int x, int y) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(nativeInstance);
        dsTaint.addTaint(set);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.944 -0400", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "DAF8DE086913BB59EB8D3E9C00727DC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeStartSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "A11715011B8424E4C1DF23E23BC77CCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeStopGL() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "E788D1A1EBDA38E7EDA0D07A3049D7B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Rect nativeSubtractLayers(Rect content) {
        dsTaint.addTaint(content.dsTaint);
        return (Rect)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "862E32BACF5DDF71986BE9B9B3C9B0E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTextGeneration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "357B1EA2F63D3ED8C271D67AFCCC12A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeRegisterPageSwapCallback() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "2E113EDF1B459505AA2AF4625DE30F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTileProfilingStart() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "6E85B5FC973A92E4D64DEACFBFBAF564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float nativeTileProfilingStop() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "7EF0A6540C2A701F27B19DB98FD72058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeTileProfilingClear() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.945 -0400", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "4DAB22C084CBAAA547FA959D735EB1DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingNumFrames() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "E70B4D89D6320E83E97DB697A2943FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingNumTilesInFrame(int frame) {
        dsTaint.addTaint(frame);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "D71A66E5878B8CB126FE36C595D1780A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeTileProfilingGetInt(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "06E1AB50842C2380DA516593725B3949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float nativeTileProfilingGetFloat(int frame, int tile, String key) {
        dsTaint.addTaint(frame);
        dsTaint.addTaint(tile);
        dsTaint.addTaint(key);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "3A6A2C5162A8ACDD7843B4487E1B8419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUpdateCachedTextfield(String updatedText,
            int generation) {
        dsTaint.addTaint(updatedText);
        dsTaint.addTaint(generation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "6D017489B1D6CF5BB3F0F2AF32D2B220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeWordSelection(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "D8B9242E221D3581D6D1A17CE401F130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int nativeGetBlockLeftEdge(int x, int y, float scale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "8FFB2EE5EB82F226710BA6416E46199B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeUseHardwareAccelSkia(boolean enabled) {
        dsTaint.addTaint(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.946 -0400", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "01653848FCD74C4FA5BE35656D4A3E75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeScrollableLayer(int x, int y, Rect scrollRect,
            Rect scrollBounds) {
        dsTaint.addTaint(scrollRect.dsTaint);
        dsTaint.addTaint(scrollBounds.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "82A1486216815C1722B3B89272673717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeScrollLayer(int layer, int newX, int newY) {
        dsTaint.addTaint(newX);
        dsTaint.addTaint(layer);
        dsTaint.addTaint(newY);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "4C8A6EC233609085F01246A9699AADB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeSetIsScrolling(boolean isScrolling) {
        dsTaint.addTaint(isScrolling);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "D5246F3ADCCE856A318224B665ECE7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetBackgroundColor() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "9A8E785013254E9A89E5387F5B19564D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean nativeSetProperty(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "CBBBDFBC6F9C5FE2DF7A908565833FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String nativeGetProperty(String key) {
        dsTaint.addTaint(key);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "4FB5C01FC83E9635DD28935A8DD83622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetTextSelectionRegion(int instance, Region region) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(instance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.947 -0400", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "9478A6BAC664395F800C605AD91A11C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeGetSelectionHandles(int instance, int[] handles) {
        dsTaint.addTaint(instance);
        dsTaint.addTaint(handles[0]);
    }

    
        private static void nativeOnTrimMemory(int level) {
    }

    
        private static void nativeSetPauseDrawing(int instance, boolean pause) {
    }

    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "836323464380532D0B8242E0690D9C50", hash_generated_method = "836323464380532D0B8242E0690D9C50")
                public InnerGlobalLayoutListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "786D0CF33E3E2CEB75F206A8A4B53316")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_693457552 = (isShown());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "E86AA6D011978401520065D0AF6DA6AE", hash_generated_method = "E86AA6D011978401520065D0AF6DA6AE")
                public InnerScrollChangedListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "CF0A3D408528A21E6487A7721B8E33F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_8637165 = (isShown());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "3903CE6527E504477DC355A8F8633B25", hash_generated_method = "3903CE6527E504477DC355A8F8633B25")
                public WebViewTransport ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "26E2382D0FB72A9C588B7007B505DAD5")
        @DSModeled(DSC.SAFE)
        public synchronized void setWebView(WebView webview) {
            dsTaint.addTaint(webview.dsTaint);
            // ---------- Original Method ----------
            //mWebview = webview;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.948 -0400", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "FD4FC754B1EBE29A6980A280CC6D8982")
        @DSModeled(DSC.SAFE)
        public synchronized WebView getWebView() {
            return (WebView)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mWebview;
        }

        
    }


    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.949 -0400", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "A9B8EC9165DEC7131D17AFD473F1680A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private OnTrimMemoryListener(Context c) {
            dsTaint.addTaint(c.dsTaint);
            c.registerComponentCallbacks(this);
            // ---------- Original Method ----------
            //c.registerComponentCallbacks(this);
        }

        
                static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.949 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "1834BBE46D3F21B80EA57CAFD933D3B0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(newConfig.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.949 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "703A059557F06AE044520D2E93D3D2F0")
        @DSModeled(DSC.SAFE)
        @Override
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.949 -0400", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "85380984D295890E45888F4C5C4F2801")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static OnTrimMemoryListener sInstance = null;
    }


    
    public class HitTestResult {
        private int mType;
        private String mExtra;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.949 -0400", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "3E8436A0FC0A9040E95F25D444A899AD")
        @DSModeled(DSC.SAFE)
         HitTestResult() {
            mType = UNKNOWN_TYPE;
            // ---------- Original Method ----------
            //mType = UNKNOWN_TYPE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "40E6AB35D728BB560D51A4F02C2FF1CF")
        @DSModeled(DSC.SAFE)
        private void setType(int type) {
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //mType = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "D2155B73BC0F49E2AB0E989513CBCDC7")
        @DSModeled(DSC.SAFE)
        private void setExtra(String extra) {
            dsTaint.addTaint(extra);
            // ---------- Original Method ----------
            //mExtra = extra;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
        @DSModeled(DSC.SAFE)
        public int getType() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "77B50CA4CC347036CB15D326BC3675E4")
        @DSModeled(DSC.SAFE)
        public String getExtra() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mExtra;
        }

        
        public static final int UNKNOWN_TYPE = 0;
        @Deprecated public static final int ANCHOR_TYPE = 1;
        public static final int PHONE_TYPE = 2;
        public static final int GEO_TYPE = 3;
        public static final int EMAIL_TYPE = 4;
        public static final int IMAGE_TYPE = 5;
        @Deprecated public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int EDIT_TEXT_TYPE = 9;
    }


    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "AB4DA2725E0AF09481951F3F5083482D", hash_generated_method = "AB4DA2725E0AF09481951F3F5083482D")
                public ProxyReceiver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "D1DE35624FF859098C24DB16B6428497")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean var5A158AEAA9529F1AFE9F1BFAB51F2DA9_53869062 = (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.950 -0400", hash_original_method = "91AC2311E01D6F764C2B6AF7EADAD53A", hash_generated_method = "91AC2311E01D6F764C2B6AF7EADAD53A")
                public PackageListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.951 -0400", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "1CF24BE683257F47072414E02224B935")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            String packageName;
            packageName = intent.getData().getSchemeSpecificPart();
            boolean replacing;
            replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
            {
                boolean varFF4619C38D73ED134292A51CFC6DAD56_1396578757 = (Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing);
            } //End collapsed parenthetic
            {
                boolean varF3A5A3941CCE4017F61B8223025B4DC2_718820026 = (sGoogleApps.contains(packageName));
                {
                    {
                        boolean var37328E8572988711DFAEB7B421756EDC_1047727827 = (Intent.ACTION_PACKAGE_ADDED.equals(action));
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
                boolean varB1BC6389427C1315076A84D35B8A1EAF_2075392057 = (pm.containsPluginPermissionAndSignatures(packageName));
                {
                    pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class SaveWebArchiveMessage {
        String mBasename;
        boolean mAutoname;
        ValueCallback<String> mCallback;
        String mResultFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.951 -0400", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "4C7FC277E8E53FA1CC9390193E08CC24")
        @DSModeled(DSC.SAFE)
         SaveWebArchiveMessage(String basename, boolean autoname, ValueCallback<String> callback) {
            dsTaint.addTaint(basename);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(autoname);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.951 -0400", hash_original_method = "EFE8E8F121E60FD1FB305DEC92F9AA94", hash_generated_method = "EFE8E8F121E60FD1FB305DEC92F9AA94")
                public ViewSizeData ()
        {
        }


    }


    
    private class RequestFormData implements Runnable {
        private String mName;
        private String mUrl;
        private Message mUpdateMessage;
        private boolean mAutoFillable;
        private boolean mAutoComplete;
        private WebSettings mWebSettings;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.952 -0400", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "DA1A7D812C53B9027980AE031D19F06C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RequestFormData(String name, String url, Message msg,
                boolean autoFillable, boolean autoComplete) {
            dsTaint.addTaint(autoComplete);
            dsTaint.addTaint(autoFillable);
            dsTaint.addTaint(name);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.952 -0400", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "01B90467CA13620F59B0F56DEBDF2B94")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ArrayList<String> pastEntries;
            pastEntries = new ArrayList<String>();
            {
                {
                    boolean var5288C74084AF99D20729B6F53A54E232_438100601 = (mWebSettings != null && mWebSettings.getAutoFillProfile() != null);
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
                boolean var3F0C3C91772BA4E0AAA044D02E105F29_389189112 = (pastEntries.size() > 0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.952 -0400", hash_original_method = "93AF792B85A93ADDD523F7EA033C118A", hash_generated_method = "93AF792B85A93ADDD523F7EA033C118A")
                public QueuedTouch ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.952 -0400", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "E3C451142098072FEAE7B5E1B5E0707F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.953 -0400", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "39CD94F7892D22766ABD8F4880A6BD0E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.953 -0400", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "8E07B975C971F6E6BCF6E821B2F5165B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.953 -0400", hash_original_method = "46DEA12507E506C7329A183C40F77080", hash_generated_method = "46DEA12507E506C7329A183C40F77080")
                public TouchEventQueue ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.953 -0400", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "4B76E9EEB2A8F3F68F8E7C76CE06F608")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private QueuedTouch obtainQueuedTouch() {
            {
                QueuedTouch result;
                result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
            } //End block
            QueuedTouch var253DA5AD31CE605522EF879FB90EE6A2_504341097 = (new QueuedTouch());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.953 -0400", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "FF19A2C62E6D784032ABEC06DA4B653A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
            // ---------- Original Method ----------
            //mIgnoreUntilSequence = mNextTouchSequence;
            //runQueuedAndPreQueuedEvents();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.954 -0400", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "FB156250A9C3BD0F183BF7E5E47EAFEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.954 -0400", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "DAA3DEEFE5204CF946602F8551E24E80")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.954 -0400", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "6E9D0A5B9EDF5E9007F999D52CE318A9")
        @DSModeled(DSC.SAFE)
        private void recycleQueuedTouch(QueuedTouch qd) {
            dsTaint.addTaint(qd.dsTaint);
            {
                qd.mNext = mQueuedTouchRecycleBin;
            } //End block
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH) {
                //qd.mNext = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = qd;
                //mQueuedTouchRecycleCount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.955 -0400", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "10E51E5BBAB2D5CE78007C28414A1712")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.955 -0400", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "A933109F74344EBA00AB56FB925DD8D7")
        @DSModeled(DSC.SAFE)
        public long nextTouchSequence() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mNextTouchSequence++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.955 -0400", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "C05F914C862E40AEFF89537D5B07AE25")
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
                boolean varBE43CED5DAEAE4AB789CEEFCCB879ABB_1391755669 = (dropStaleGestures(ted.mMotionEvent, ted.mSequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                } //End block
                handleQueuedTouchEventData(ted);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.956 -0400", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "0638509B55D29AC271A09DBEEE27AEBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void enqueueTouchEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            long sequence;
            sequence = nextTouchSequence();
            {
                boolean varC743B531629C8022D99C282BCE55BA59_1393997565 = (dropStaleGestures(ev, sequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                handleQueuedMotionEvent(ev);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.956 -0400", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "B5D89403867D41355387842DF49AFAEE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void runNextQueuedEvents() {
            QueuedTouch qd;
            qd = mTouchEventQueue;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe;
                recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.956 -0400", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "5E5362E636396FE03375955B2C7B90EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            dsTaint.addTaint(ev.dsTaint);
            dsTaint.addTaint(sequence);
            {
                boolean var6660B004F1AFFBD2AD367F81FA8A8ECB_844982910 = (ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove);
                {
                    int dx;
                    dx = Math.round(ev.getX()) - mLastTouchX;
                    int dy;
                    dy = Math.round(ev.getY()) - mLastTouchY;
                    {
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDD96473448E99D0068A310672554EE17_1258074653 = (ev != null && ev.getAction() == MotionEvent.ACTION_DOWN);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.957 -0400", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "D5E1EEB63DFA39A3490E86A663B5BAFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.957 -0400", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "F98087F093C48E6513DC9E31D4A30B3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void handleQueuedMotionEvent(MotionEvent ev) {
            dsTaint.addTaint(ev.dsTaint);
            mLastEventTime = ev.getEventTime();
            int action;
            action = ev.getActionMasked();
            {
                boolean var5547CC292C3C07AC5E49CBFC5588305F_1515298827 = (ev.getPointerCount() > 1);
                {
                    handleMultiTouchInWebView(ev);
                } //End block
                {
                    ScaleGestureDetector detector;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.958 -0400", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "C6CE20F6FD041A283FE771B50192FEEB")
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

        
        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
    }


    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.958 -0400", hash_original_method = "EEAC7690DC95B36B9B3C11B7E313BF00", hash_generated_method = "EEAC7690DC95B36B9B3C11B7E313BF00")
                public PrivateHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.962 -0400", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "AAA7CAA8300A38808A34BD731F5DA749")
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
                        boolean var8FF10029C08AB4FC7C05FF2A261CB23D_1081999225 = (!getSettings().supportTouchOnly()
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
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_1879524674 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_1459986308 = (inFullScreenMode() || mDeferTouchProcess);
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
                        boolean varC08B8A0171CF85CA13986B7A742C9FAC_1792056251 = (imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView))));
                    } //End collapsed parenthetic
                } //End block
                Point p;
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
                float density;
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
                WebViewCore.DrawData draw;
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
                boolean var24ED917A45E165B2D0DB73D1C228849D_1207669295 = (inEditingMode() &&
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
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1093115078 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    hideSoftKeyboard();
                } //End block
            } //End collapsed parenthetic
            //End case FORM_DID_BLUR 
            //Begin case RETURN_LABEL 
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_243378366 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setHint((String) msg.obj);
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        boolean varE86969381D8E084EE7486B0BCDFB9761_1054792498 = (imm != null && imm.isActive(mWebTextView));
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
                boolean var0513EDBB647F1B1B0CEC2398CB7258CB_1508486108 = (inEditingMode() && nativeCursorIsTextInput());
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
                boolean var543595A323B4887B7F3AF5971C508703_154021077 = (mWebTextView.isSameTextField(msg.arg1));
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
                boolean varA9995E2AE703E9AF13E24802C20B989A_1705820153 = (inFullScreenMode());
            } //End collapsed parenthetic
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            TouchEventData ted;
            ted = (TouchEventData) msg.obj;
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            {
                boolean var25F0555089CC470A412F802E26A1BE83_2038118782 = (mTouchEventQueue.enqueueTouchEvent(ted));
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
                    boolean var193BD8982A9C597816FCA9FE1F0F7BC4_591171993 = (inFullScreenMode());
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
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_2035230882 = (inEditingMode());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.964 -0400", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "199A8CC14E6600A01F0054E621CB342C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private InvokeListBox(String[] array, int[] enabled, int[] selected) {
            dsTaint.addTaint(enabled[0]);
            dsTaint.addTaint(selected[0]);
            dsTaint.addTaint(array[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.964 -0400", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "3F1AE5AE0B6D8A64E79EDFCCAA5475D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private InvokeListBox(String[] array, int[] enabled, int selection) {
            dsTaint.addTaint(enabled[0]);
            dsTaint.addTaint(selection);
            dsTaint.addTaint(array[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.966 -0400", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "A900CAE539A76B504402AC4DA3B2B655")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ListView listView;
            listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            MyArrayListAdapter adapter;
            adapter = new MyArrayListAdapter();
            AlertDialog.Builder b;
            b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);
            {
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.965 -0400", hash_original_method = "3150D57594E9A243EB2796EE1880D262", hash_generated_method = "9653D1CA36932FF11826B1B9CFB79AED")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void onClick(DialogInterface dialog, int which) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        dsTaint.addTaint(which);
                        dsTaint.addTaint(dialog.dsTaint);
                        mWebViewCore.sendMessage(
                                EventHub.LISTBOX_CHOICES,
                                adapter.getCount(), 0,
                                listView.getCheckedItemPositions());
                        // ---------- Original Method ----------
                        //mWebViewCore.sendMessage(
                                //EventHub.LISTBOX_CHOICES,
                                //adapter.getCount(), 0,
                                //listView.getCheckedItemPositions());
                    }
});
                b.setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.965 -0400", hash_original_method = "167C789BB5CCECE2A545076849F2D943", hash_generated_method = "39D5C79841DD84242555F139EFA9BAAC")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void onClick(DialogInterface dialog, int which) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        dsTaint.addTaint(which);
                        dsTaint.addTaint(dialog.dsTaint);
                        mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                        // ---------- Original Method ----------
                        //mWebViewCore.sendMessage(
                                //EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    }
});
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.965 -0400", hash_original_method = "4FB59E3EE3C723FAB3D9C696C9283630", hash_generated_method = "7C9C253410497BBD7DB8883D9DF7A910")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        dsTaint.addTaint(id);
                        dsTaint.addTaint(position);
                        dsTaint.addTaint(v.dsTaint);
                        dsTaint.addTaint(parent.dsTaint);
                        mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        mListBoxDialog.dismiss();
                        mListBoxDialog = null;
                        // ---------- Original Method ----------
                        //mListBoxMessage = Message.obtain(null,
                                //EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        //mListBoxDialog.dismiss();
                        //mListBoxDialog = null;
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.966 -0400", hash_original_method = "718CBFBF20241D8F0DF84EA7F924765B", hash_generated_method = "28B8E6EE73084FAC3068DDFEEF53A1CB")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onCancel(DialogInterface dialog) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(dialog.dsTaint);
                    mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    mListBoxDialog = null;
                    // ---------- Original Method ----------
                    //mWebViewCore.sendMessage(
                                //EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    //mListBoxDialog = null;
                }
});
            mListBoxDialog.show();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class Container extends Object {
            String  mString;
            int     mEnabled;
            int     mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.966 -0400", hash_original_method = "698B89512ABA7FC05CFE132C28749CEE", hash_generated_method = "698B89512ABA7FC05CFE132C28749CEE")
                        public Container ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.966 -0400", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "024F51443A3DCBD1C98EF23B1DD86374")
            @DSModeled(DSC.SAFE)
            @Override
            public String toString() {
                return dsTaint.getTaintString();
                // ---------- Original Method ----------
                //return mString;
            }

            
            final static int OPTGROUP = -1;
            final static int OPTION_DISABLED = 0;
            final static int OPTION_ENABLED = 1;
        }


        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.966 -0400", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "49BA01A9414CEFE48019AF33DD04C46A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.967 -0400", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "E90DF21A75DF5AAEB365ED14AF390FD1")
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
                        boolean var29E3F9545B0C5E6979D96B1ACDAB027D_21043649 = (position < getCount() - 1);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.967 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "EFF95DEF7F8614606ED71B7F0D898399")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean hasStableIds() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.967 -0400", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "2B1E237B0284FB9E7ADA50B4CB74EF49")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private Container item(int position) {
                dsTaint.addTaint(position);
                {
                    boolean var46FB1B51094929768D004AD98A0CD79D_548276347 = (position < 0 || position >= getCount());
                } //End collapsed parenthetic
                Container varE069C5AE020B74C9C365DE3307AEA467_1098906578 = ((Container) getItem(position));
                return (Container)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (position < 0 || position >= getCount()) {
                    //return null;
                //}
                //return (Container) getItem(position);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.967 -0400", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "D60E610513547A24C8D3F07142307E59")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.967 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "8F9650A119DFC09D25E8DA1FABB131DF")
            @DSModeled(DSC.SAFE)
            @Override
            public boolean areAllItemsEnabled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.968 -0400", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "962BEC433B8F39433617FA18DE76C81F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.968 -0400", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "CDD7442D0ECB3E83C830D306470A1279")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.968 -0400", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "D2AA3FB22D7E7F7A70A21D82546FEC2E")
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
                                boolean varA60FED54EC8179E35E73102579F12B18_1853445629 = (mAdapter.getItemId(i) == mCheckedId);
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
    
    static private final boolean AUTO_REDRAW_HACK = false;
    static final String LOGTAG = "webview";
    private static final int TOUCH_SENT_INTERVAL = 0;
    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    private static final int TOUCH_INIT_MODE = 1;
    private static final int TOUCH_DRAG_START_MODE = 2;
    private static final int TOUCH_DRAG_MODE = 3;
    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    private static final int TOUCH_SHORTPRESS_MODE = 5;
    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    private static final int TOUCH_DONE_MODE = 7;
    private static final int TOUCH_PINCH_DRAG = 8;
    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    private static final int PREVENT_DEFAULT_NO = 0;
    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    private static final int PREVENT_DEFAULT_YES = 3;
    private static final int PREVENT_DEFAULT_IGNORE = 4;
    private static final int TAP_TIMEOUT = 300;
    private static final int LONG_PRESS_TIMEOUT = 1000;
    private static final int MIN_FLING_TIME = 250;
    private static final int MOTIONLESS_TIME = 100;
    private static final int PAGE_SCROLL_OVERLAP = 24;
    private static final int STD_SPEED = 480;
    private static final int MAX_DURATION = 750;
    private static final int SLIDE_TITLE_DURATION = 500;
    private static Paint mOverScrollBackground;
    private static Paint mOverScrollBorder;
    private static final int MOTIONLESS_FALSE           = 0;
    private static final int MOTIONLESS_PENDING         = 1;
    private static final int MOTIONLESS_TRUE            = 2;
    private static final int MOTIONLESS_IGNORE          = 3;
    static final boolean USE_JAVA_TEXT_SELECTION = true;
    static final boolean DEBUG_TEXT_HANDLES = false;
    static final boolean USE_WEBKIT_RINGS = false;
    private static final int HIGHLIGHT_COLOR = 0x6633b5e5;
    private static final float TOUCH_HIGHLIGHT_ARC = 5.0f;
    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
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
    private static final int SNAP_NONE = 0;
    private static final int SNAP_LOCK = 1;
    private static final int SNAP_X = 2;
    private static final int SNAP_Y = 4;
    private static final int DRAW_EXTRAS_NONE = 0;
    private static final int DRAW_EXTRAS_FIND = 1;
    private static final int DRAW_EXTRAS_SELECTION = 2;
    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
    private static final int SCROLLBAR_AUTO = 0;
    private static final int SCROLLBAR_ALWAYSOFF = 1;
    private static final int SCROLLBAR_ALWAYSON = 2;
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
    static boolean mLogEvent = true;
    private static boolean sNotificationsEnabled = true;
    public static final String SCHEME_TEL = "tel:";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    private static final long SELECT_SCROLL_INTERVAL = 1000 / 60;
    private static boolean mIncrementEGLContextHack = false;
    private static ProxyReceiver sProxyReceiver;
    private static boolean sPackageInstallationReceiverAdded = false;
    private static Set<String> sGoogleApps;
    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    
    private static final int FULLY_ON_SCREEN = 0;
    private static final int INTERSECTS_SCREEN = 1;
    private static final int ANYWHERE = 2;
    private static final int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
    private static final int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
    private static final float HSLOPE_TO_START_SNAP = .25f;
    private static final float HSLOPE_TO_BREAK_SNAP = .4f;
    private static final float VSLOPE_TO_START_SNAP = 1.25f;
    private static final float VSLOPE_TO_BREAK_SNAP = .95f;
    private static final float ANGLE_VERT = 2f;
    private static final float ANGLE_HORIZ = 0f;
    private static final float MMA_WEIGHT_N = 5;
    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    private static final int TRACKBALL_TIMEOUT = 200;
    private static final int TRACKBALL_WAIT = 100;
    private static final int TRACKBALL_SCALE = 400;
    private static final int TRACKBALL_SCROLL_COUNT = 5;
    private static final int TRACKBALL_MOVE_COUNT = 10;
    private static final int TRACKBALL_MULTIPLIER = 3;
    private static final int SELECT_CURSOR_OFFSET = 16;
    private static final int SELECT_SCROLL = 5;
    static final int NO_LEFTEDGE = -1;
}

