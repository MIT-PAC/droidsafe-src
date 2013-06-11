package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.Manifest;
import android.animation.LayoutTransition;
import android.app.ActivityManagerNative;
import android.content.ClipDescription;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.LatencyTimer;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.android.internal.policy.PolicyManager;
import com.android.internal.view.BaseSurfaceHolder;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.RootViewSurfaceTaker;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class ViewRootImpl extends Handler implements ViewParent, View.AttachInfo.Callbacks, HardwareRenderer.HardwareDrawCallbacks {
    private static final String TAG = "ViewRootImpl";
    private static final boolean DBG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final boolean DEBUG_DRAW = false || LOCAL_LOGV;
    private static final boolean DEBUG_LAYOUT = false || LOCAL_LOGV;
    private static final boolean DEBUG_DIALOG = false || LOCAL_LOGV;
    private static final boolean DEBUG_INPUT_RESIZE = false || LOCAL_LOGV;
    private static final boolean DEBUG_ORIENTATION = false || LOCAL_LOGV;
    private static final boolean DEBUG_TRACKBALL = false || LOCAL_LOGV;
    private static final boolean DEBUG_IMF = false || LOCAL_LOGV;
    private static final boolean DEBUG_CONFIGURATION = false || LOCAL_LOGV;
    private static final boolean DEBUG_FPS = false;
    private static final boolean WATCH_POINTER = false;
    private static final String PROPERTY_PROFILE_RENDERING = "viewancestor.profile_rendering";
    private static final boolean MEASURE_LATENCY = false;
    private static LatencyTimer lt;
    static final int MAX_TRACKBALL_DELAY = 250;
    static IWindowSession sWindowSession;
    static final Object mStaticInit = new Object();
    static boolean mInitialized = false;
    static final ThreadLocal<RunQueue> sRunQueues = new ThreadLocal<RunQueue>();
    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<Runnable>();
    static boolean sFirstDrawComplete = false;
    static final ArrayList<ComponentCallbacks> sConfigCallbacks
            = new ArrayList<ComponentCallbacks>();
    long mLastTrackballTime = 0;
    final TrackballAxis mTrackballAxisX = new TrackballAxis();
    final TrackballAxis mTrackballAxisY = new TrackballAxis();
    int mLastJoystickXDirection;
    int mLastJoystickYDirection;
    int mLastJoystickXKeyCode;
    int mLastJoystickYKeyCode;
    final int[] mTmpLocation = new int[2];
    final TypedValue mTmpValue = new TypedValue();
    final InputMethodCallback mInputMethodCallback;
    final SparseArray<Object> mPendingEvents = new SparseArray<Object>();
    int mPendingEventSeq = 0;
    final Thread mThread;
    final WindowLeaked mLocation;
    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    final W mWindow;
    final int mTargetSdkVersion;
    int mSeq;
    View mView;
    View mFocusedView;
    View mRealFocusedView;
    int mViewVisibility;
    boolean mAppVisible = true;
    int mOrigWindowType = -1;
    boolean mStopped = false;
    boolean mLastInCompatMode = false;
    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    BaseSurfaceHolder mSurfaceHolder;
    boolean mIsCreating;
    boolean mDrawingAllowed;
    final Region mTransparentRegion;
    final Region mPreviousTransparentRegion;
    int mWidth;
    int mHeight;
    Rect mDirty;
    final Rect mCurrentDirty = new Rect();
    final Rect mPreviousDirty = new Rect();
    boolean mIsAnimating;
    CompatibilityInfo.Translator mTranslator;
    final View.AttachInfo mAttachInfo;
    InputChannel mInputChannel;
    InputQueue.Callback mInputQueueCallback;
    InputQueue mInputQueue;
    FallbackEventHandler mFallbackEventHandler;
    final Rect mTempRect;
    final Rect mVisRect;
    boolean mTraversalScheduled;
    long mLastTraversalFinishedTimeNanos;
    long mLastDrawDurationNanos;
    boolean mWillDrawSoon;
    boolean mLayoutRequested;
    boolean mFirst;
    boolean mReportNextDraw;
    boolean mFullRedrawNeeded;
    boolean mNewSurfaceNeeded;
    boolean mHasHadWindowFocus;
    boolean mLastWasImTarget;
    InputEventMessage mPendingInputEvents = null;
    boolean mWindowAttributesChanged = false;
    int mWindowAttributesChangesFlag = 0;
    private final Surface mSurface = new Surface();
    boolean mAdded;
    boolean mAddedTouchMode;
    CompatibilityInfoHolder mCompatibilityInfo;
    int mAddNesting;
    final Rect mWinFrame;
    final Rect mPendingVisibleInsets = new Rect();
    final Rect mPendingContentInsets = new Rect();
    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets
            = new ViewTreeObserver.InternalInsetsInfo();
    final Configuration mLastConfiguration = new Configuration();
    final Configuration mPendingConfiguration = new Configuration();
    boolean mScrollMayChange;
    int mSoftInputMode;
    View mLastScrolledFocus;
    int mScrollY;
    int mCurScrollY;
    Scroller mScroller;
    HardwareLayer mResizeBuffer;
    long mResizeBufferStartTime;
    int mResizeBufferDuration;
    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    private ArrayList<LayoutTransition> mPendingTransitions;
    final ViewConfiguration mViewConfiguration;
    ClipDescription mDragDescription;
    View mCurrentDragView;
    volatile Object mLocalDragState;
    final PointF mDragPoint = new PointF();
    final PointF mLastTouchPoint = new PointF();
    private boolean mProfileRendering;
    private Thread mRenderProfiler;
    private volatile boolean mRenderProfilingEnabled;
    private long mFpsStartTime = -1;
    private long mFpsPrevTime = -1;
    private int mFpsNumFrames;
    AudioManager mAudioManager;
    final AccessibilityManager mAccessibilityManager;
    AccessibilityInteractionController mAccessibilityInteractionController;
    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    private final int mDensity;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    private boolean mProfile = false;
    int mHardwareYOffset;
    int mResizeAlpha;
    final Paint mResizePaint = new Paint();
    public final static int DO_TRAVERSAL = 1000;
    public final static int DIE = 1001;
    public final static int RESIZED = 1002;
    public final static int RESIZED_REPORT = 1003;
    public final static int WINDOW_FOCUS_CHANGED = 1004;
    public final static int DISPATCH_KEY = 1005;
    public final static int DISPATCH_POINTER = 1006;
    public final static int DISPATCH_TRACKBALL = 1007;
    public final static int DISPATCH_APP_VISIBILITY = 1008;
    public final static int DISPATCH_GET_NEW_SURFACE = 1009;
    public final static int FINISHED_EVENT = 1010;
    public final static int DISPATCH_KEY_FROM_IME = 1011;
    public final static int FINISH_INPUT_CONNECTION = 1012;
    public final static int CHECK_FOCUS = 1013;
    public final static int CLOSE_SYSTEM_DIALOGS = 1014;
    public final static int DISPATCH_DRAG_EVENT = 1015;
    public final static int DISPATCH_DRAG_LOCATION_EVENT = 1016;
    public final static int DISPATCH_SYSTEM_UI_VISIBILITY = 1017;
    public final static int DISPATCH_GENERIC_MOTION = 1018;
    public final static int UPDATE_CONFIGURATION = 1019;
    public final static int DO_PERFORM_ACCESSIBILITY_ACTION = 1020;
    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID = 1021;
    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID = 1022;
    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT = 1023;
    public final static int PROCESS_INPUT_EVENTS = 1024;
    private long mInputEventReceiveTimeNanos;
    private long mInputEventDeliverTimeNanos;
    private long mInputEventDeliverPostImeTimeNanos;
    private InputQueue.FinishedCallback mFinishedCallback;
    private final InputHandler mInputHandler = new InputHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "DA8B85C0B97B283164189BFC107A0C51", hash_generated_method = "F440D15F47FE242C485B66B5BC20E671")
        @DSModeled(DSC.SAFE)
        public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
            dsTaint.addTaint(finishedCallback.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            startInputEvent(finishedCallback);
            dispatchKey(event, true);
            // ---------- Original Method ----------
            //startInputEvent(finishedCallback);
            //dispatchKey(event, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "BA251C4BE7EEF8348B6DA839AE6C5F99", hash_generated_method = "93914AA1020CD9B9E8F5425E915FA934")
        @DSModeled(DSC.SAFE)
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            dsTaint.addTaint(finishedCallback.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            startInputEvent(finishedCallback);
            dispatchMotion(event, true);
            // ---------- Original Method ----------
            //startInputEvent(finishedCallback);
            //dispatchMotion(event, true);
        }

        
}; //Transformed anonymous class
    private SurfaceHolder mHolder = new SurfaceHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "C6283542455A71726493ABA0EB18310B")
        @DSModeled(DSC.SAFE)
        public Surface getSurface() {
            return (Surface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSurface;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "111414E0BC27432A58777D8D7A8A5313", hash_generated_method = "DD2624CC11AB0D3BC1E618BB799FFF8A")
        @DSModeled(DSC.SAFE)
        public boolean isCreating() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "1534EBA7EE38BC120F6309F5A1B3FF9E", hash_generated_method = "7A90FFA1EB6E830D2E24BFD99DAAE843")
        @DSModeled(DSC.SAFE)
        public void addCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "1D7F6566A3906AFA0AB54EE06949ABBB", hash_generated_method = "12713D51E0298F62C647EFAB45D4B595")
        @DSModeled(DSC.SAFE)
        public void removeCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "0FF9F7AB4B875AE8A0C5A8C3535F85C8", hash_generated_method = "80333F2A6738627AB6A06EA1EF0C2FF4")
        @DSModeled(DSC.SAFE)
        public void setFixedSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "0794758F1C90C59C5D7A2C0BDE8FAA38", hash_generated_method = "97F197B3D667806FF8A2A5E1FFC042A4")
        @DSModeled(DSC.SAFE)
        public void setSizeFromLayout() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "CF1EA2FC05AD6DEBDFA26DEE8FD9DB43", hash_generated_method = "7C9503A5E310B441E9274720A8C3EBF5")
        @DSModeled(DSC.SAFE)
        public void setFormat(int format) {
            dsTaint.addTaint(format);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "2C12B38247A8844049CB884E0B89464D")
        @DSModeled(DSC.SAFE)
        public void setType(int type) {
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.706 -0400", hash_original_method = "46E48CC06FE228B4151C3D83F1499F0C", hash_generated_method = "73145A2121D626F4D1819D6C6E89A7A7")
        @DSModeled(DSC.SAFE)
        public void setKeepScreenOn(boolean screenOn) {
            dsTaint.addTaint(screenOn);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "3082759B8090FD86F4392C9CC2C4FBD0", hash_generated_method = "1A135AABBA0451985426E422CFC9D072")
        @DSModeled(DSC.SAFE)
        public Canvas lockCanvas() {
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "3E84C9B445B974E90BE60751B0E8F5B3", hash_generated_method = "E5231FC96A8B12FBB5BC98F9D4EBA4C0")
        @DSModeled(DSC.SAFE)
        public Canvas lockCanvas(Rect dirty) {
            dsTaint.addTaint(dirty.dsTaint);
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "398534786B4B68CC68F8CE8B2E298404", hash_generated_method = "2EC38AACB68EF21232B647379FC7DD5E")
        @DSModeled(DSC.SAFE)
        public void unlockCanvasAndPost(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "0458ACEC2C801E19AE11DF373ED70BEE", hash_generated_method = "ECAFD3DD7927CC95E8BA5235CC93898E")
        @DSModeled(DSC.SAFE)
        public Rect getSurfaceFrame() {
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "30AB3DC3CF45F6460C1B2C84DB6BEEC3", hash_generated_method = "A1E6542AF1483E916A05E739C47B903A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewRootImpl(Context context) {
        super();
        dsTaint.addTaint(context.dsTaint);
        {
            {
                lt = new LatencyTimer(100, 1000);
            } //End block
        } //End block
        getWindowSession(context.getMainLooper());
        mThread = Thread.currentThread();
        mLocation = new WindowLeaked(null);
        mLocation.fillInStackTrace();
        mWidth = -1;
        mHeight = -1;
        mDirty = new Rect();
        mTempRect = new Rect();
        mVisRect = new Rect();
        mWinFrame = new Rect();
        mWindow = new W(this);
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        mInputMethodCallback = new InputMethodCallback(this);
        mViewVisibility = View.GONE;
        mTransparentRegion = new Region();
        mPreviousTransparentRegion = new Region();
        mFirst = true;
        mAdded = false;
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAccessibilityInteractionConnectionManager =
            new AccessibilityInteractionConnectionManager();
        mAccessibilityManager.addAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        mAttachInfo = new View.AttachInfo(sWindowSession, mWindow, this, this);
        mViewConfiguration = ViewConfiguration.get(context);
        mDensity = context.getResources().getDisplayMetrics().densityDpi;
        mFallbackEventHandler = PolicyManager.makeNewFallbackEventHandler(context);
        mProfileRendering = Boolean.parseBoolean(
                SystemProperties.get(PROPERTY_PROFILE_RENDERING, "false"));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "6204018B0410883FB8966B71E80E7FF6", hash_generated_method = "559F65FDCB3510E740B6FB09ECC8C64F")
    public static IWindowSession getWindowSession(Looper mainLooper) {
        synchronized (mStaticInit) {
            if (!mInitialized) {
                try {
                    InputMethodManager imm = InputMethodManager.getInstance(mainLooper);
                    sWindowSession = Display.getWindowManager().openSession(
                            imm.getClient(), imm.getInputContext());
                    mInitialized = true;
                } catch (RemoteException e) {
                }
            }
            return sWindowSession;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "FAC0EC3E77B4781B224707645FD3A4FF", hash_generated_method = "116B0A8AEFC670E5FAF3025171FE97B7")
    public static void addFirstDrawHandler(Runnable callback) {
        synchronized (sFirstDrawHandlers) {
            if (!sFirstDrawComplete) {
                sFirstDrawHandlers.add(callback);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "834621F626C96E3AD42E0A4200072657", hash_generated_method = "C3464632656664054F7604F4AA724841")
    public static void addConfigCallback(ComponentCallbacks callback) {
        synchronized (sConfigCallbacks) {
            sConfigCallbacks.add(callback);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "CC8B7F3C56C4BD3E79E20E40E6BC7183", hash_generated_method = "CC6FD02F422E1777066CBB75AE4AF55B")
    @DSModeled(DSC.SAFE)
    public void profile() {
        mProfile = true;
        // ---------- Original Method ----------
        //mProfile = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.707 -0400", hash_original_method = "056827AB9E74AF6C4B57ABEC8FCA9A3C", hash_generated_method = "67071346A9218C2191AEF8CE4E4334B3")
    static boolean isInTouchMode() {
        if (mInitialized) {
            try {
                return sWindowSession.getInTouchMode();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.708 -0400", hash_original_method = "41A7A71F10D2AEAE23E30A793138BBB4", hash_generated_method = "7EB15F7DDB375672F951AC012EBB7811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(panelParentView.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            {
                mFallbackEventHandler.setView(view);
                mWindowAttributes.copyFrom(attrs);
                attrs = mWindowAttributes;
                {
                    mSurfaceHolderCallback =
                            ((RootViewSurfaceTaker)view).willYouTakeTheSurface();
                    {
                        mSurfaceHolder = new TakenSurfaceHolder();
                        mSurfaceHolder.setFormat(PixelFormat.UNKNOWN);
                    } //End block
                } //End block
                CompatibilityInfo compatibilityInfo;
                compatibilityInfo = mCompatibilityInfo.get();
                mTranslator = compatibilityInfo.getTranslator();
                {
                    enableHardwareAcceleration(attrs);
                } //End block
                boolean restore;
                restore = false;
                {
                    mSurface.setCompatibilityTranslator(mTranslator);
                    restore = true;
                    attrs.backup();
                    mTranslator.translateWindowLayout(attrs);
                } //End block
                Log.d(TAG, "WindowLayout in setView:" + attrs);
                {
                    boolean var2EEA59713A247080EA419945AB126FA8_1623359861 = (!compatibilityInfo.supportsScreen());
                    {
                        attrs.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                        mLastInCompatMode = true;
                    } //End block
                } //End collapsed parenthetic
                mSoftInputMode = attrs.softInputMode;
                mWindowAttributesChanged = true;
                mWindowAttributesChangesFlag = WindowManager.LayoutParams.EVERYTHING_CHANGED;
                mAttachInfo.mRootView = view;
                mAttachInfo.mScalingRequired = mTranslator != null;
                mAttachInfo.mApplicationScale =
                        mTranslator == null ? 1.0f : mTranslator.applicationScale;
                {
                    mAttachInfo.mPanelParentWindowToken
                            = panelParentView.getApplicationWindowToken();
                } //End block
                mAdded = true;
                int res;
                requestLayout();
                {
                    mInputChannel = new InputChannel();
                } //End block
                try 
                {
                    mOrigWindowType = mWindowAttributes.type;
                    res = sWindowSession.add(mWindow, mSeq, mWindowAttributes,
                            getHostVisibility(), mAttachInfo.mContentInsets,
                            mInputChannel);
                } //End block
                catch (RemoteException e)
                {
                    mAdded = false;
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mInputChannel = null;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    throw new RuntimeException("Adding window failed", e);
                } //End block
                finally 
                {
                    {
                        attrs.restore();
                    } //End block
                } //End block
                {
                    mTranslator.translateRectInScreenToAppWindow(mAttachInfo.mContentInsets);
                } //End block
                mPendingContentInsets.set(mAttachInfo.mContentInsets);
                mPendingVisibleInsets.set(0, 0, 0, 0);
                {
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mAdded = false;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    //Begin case WindowManagerImpl.ADD_BAD_APP_TOKEN WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not valid; is your activity running?");
                    //End case WindowManagerImpl.ADD_BAD_APP_TOKEN WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN 
                    //Begin case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not for an application");
                    //End case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    //Begin case WindowManagerImpl.ADD_APP_EXITING 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- app for token " + attrs.token
                                + " is exiting");
                    //End case WindowManagerImpl.ADD_APP_EXITING 
                    //Begin case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- window " + mWindow
                                + " has already been added");
                    //End case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    //Begin case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- another window of this type already exists");
                    //End case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    //Begin case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- permission denied for this window type");
                    //End case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    throw new RuntimeException(
                        "Unable to add window -- unknown error code " + res);
                } //End block
                {
                    mInputQueueCallback =
                        ((RootViewSurfaceTaker)view).willYouTakeTheInputQueue();
                } //End block
                {
                    {
                        mInputQueue = new InputQueue(mInputChannel);
                        mInputQueueCallback.onInputQueueCreated(mInputQueue);
                    } //End block
                    {
                        InputQueue.registerInputChannel(mInputChannel, mInputHandler,
                                Looper.myQueue());
                    } //End block
                } //End block
                view.assignParent(this);
                mAddedTouchMode = (res&WindowManagerImpl.ADD_FLAG_IN_TOUCH_MODE) != 0;
                mAppVisible = (res&WindowManagerImpl.ADD_FLAG_APP_VISIBLE) != 0;
                {
                    boolean var9FA688D7A8792CFDE0FE1059C3B8F748_8897370 = (mAccessibilityManager.isEnabled());
                    {
                        mAccessibilityInteractionConnectionManager.ensureConnection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "CB86722DA8E467DDCEDA5A630CA3194B", hash_generated_method = "326297414EBA2E1788604BFCA2979A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void destroyHardwareResources() {
        {
            {
                boolean var4CC7CC042FB1A0B872228C316C872BB4_841570951 = (mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    mAttachInfo.mHardwareRenderer.destroyLayers(mView);
                } //End block
            } //End collapsed parenthetic
            mAttachInfo.mHardwareRenderer.destroy(false);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //if (mAttachInfo.mHardwareRenderer.isEnabled()) {
                //mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            //}
            //mAttachInfo.mHardwareRenderer.destroy(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "E3F9E04A5716D71423EBE08431EEB223", hash_generated_method = "518D9D9F4CDA82660222536106FA05FA")
    @DSModeled(DSC.SAFE)
     void terminateHardwareResources() {
        {
            mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            mAttachInfo.mHardwareRenderer.destroy(false);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            //mAttachInfo.mHardwareRenderer.destroy(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1", hash_generated_method = "596B35F3788E6FA52019A6273E3DCADD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void destroyHardwareLayers() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_1063635787 = (mThread != Thread.currentThread());
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_1496294525 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                    {
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_1569412116 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                    {
                        mAttachInfo.mHardwareRenderer.destroyLayers(mView);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //if (mAttachInfo.mHardwareRenderer != null &&
                    //mAttachInfo.mHardwareRenderer.isEnabled()) {
                //HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
            //}
        //} else {
            //if (mAttachInfo.mHardwareRenderer != null &&
                    //mAttachInfo.mHardwareRenderer.isEnabled()) {
                //mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "645D4C027059B67B04B5E1D1CDD7444E", hash_generated_method = "0B6D5E2871695D5D06CFBDD64DFFDD0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;
        final boolean hardwareAccelerated;
        hardwareAccelerated = (attrs.flags & WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) != 0;
        {
            {
                boolean varEAF487A08F9D7C7E236198761FEC371F_65219815 = (!HardwareRenderer.isAvailable());
            } //End collapsed parenthetic
            final boolean fakeHwAccelerated;
            fakeHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED) != 0;
            final boolean forceHwAccelerated;
            forceHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED) != 0;
            {
                {
                    boolean var902B8BD79FA592FACE1DE1F2E5EEDD20_1251328041 = (!HardwareRenderer.sSystemRendererDisabled
                        && Looper.getMainLooper() != Looper.myLooper());
                } //End collapsed parenthetic
                final boolean translucent;
                translucent = attrs.format != PixelFormat.OPAQUE;
                {
                    mAttachInfo.mHardwareRenderer.destroy(true);
                } //End block
                mAttachInfo.mHardwareRenderer = HardwareRenderer.createGlRenderer(2, translucent);
                mAttachInfo.mHardwareAccelerated = mAttachInfo.mHardwareAccelerationRequested
                        = mAttachInfo.mHardwareRenderer != null;
            } //End block
            {
                mAttachInfo.mHardwareAccelerationRequested = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "FCF5C5BA62DE5F51C791E836B9B93019")
    @DSModeled(DSC.SAFE)
    public View getView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.709 -0400", hash_original_method = "6C3085A5B27688C16B5F48D71E61D048", hash_generated_method = "00E5175B2F18FA0F371091B977C6A378")
    @DSModeled(DSC.SAFE)
    final WindowLeaked getLocation() {
        return (WindowLeaked)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "344B8CEF50FED73B6C66A984FDFE543C", hash_generated_method = "CEFF36B963AD7F8C9097E768BD59555A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setLayoutParams(WindowManager.LayoutParams attrs, boolean newView) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(newView);
        {
            int oldSoftInputMode;
            oldSoftInputMode = mWindowAttributes.softInputMode;
            int compatibleWindowFlag;
            compatibleWindowFlag = mWindowAttributes.flags & WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
            mWindowAttributesChangesFlag = mWindowAttributes.copyFrom(attrs);
            mWindowAttributes.flags |= compatibleWindowFlag;
            {
                mSoftInputMode = attrs.softInputMode;
                requestLayout();
            } //End block
            {
                mWindowAttributes.softInputMode = (mWindowAttributes.softInputMode
                        & ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                        | (oldSoftInputMode
                                & WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
            } //End block
            mWindowAttributesChanged = true;
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "F0FE5EE4E253DD8DC552809A1CA2533F", hash_generated_method = "41FD45AE8920EFF2150C9C1A54521881")
    @DSModeled(DSC.SAFE)
     void handleAppVisibility(boolean visible) {
        dsTaint.addTaint(visible);
        {
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        //if (mAppVisible != visible) {
            //mAppVisible = visible;
            //scheduleTraversals();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "18299B4078E7C7C61849ACAFD8526C89", hash_generated_method = "4B27894EC7F53DE4DE17F53CAFB0326E")
    @DSModeled(DSC.SAFE)
     void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //mNewSurfaceNeeded = true;
        //mFullRedrawNeeded = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "A2905530B195FBB19B3C3F0AC663BF20", hash_generated_method = "6BB516F5A5E3E1E7118ABA317EE9F7F4")
    @DSModeled(DSC.SAFE)
    public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //checkThread();
        //mLayoutRequested = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "13F945759D2C310C5D0BB68B6FB1E2B8", hash_generated_method = "A516416D747EAAE4BDB79061B478FE37")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "1BB28848D4C8EEFEA34E8E46FE6AC5D5", hash_generated_method = "0D29575FED5D0679B1DCB286C64E6754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateChild(View child, Rect dirty) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(dirty.dsTaint);
        checkThread();
        {
            invalidate();
        } //End block
        {
            mTempRect.set(dirty);
            dirty = mTempRect;
            {
                dirty.offset(0, -mCurScrollY);
            } //End block
            {
                mTranslator.translateRectInAppWindowToScreen(dirty);
            } //End block
            {
                dirty.inset(-1, -1);
            } //End block
        } //End block
        {
            boolean varEF86BD19BDAC3E37812F85F40921C01A_295149293 = (!mDirty.isEmpty() && !mDirty.contains(dirty));
            {
                mAttachInfo.mSetIgnoreDirtyState = true;
                mAttachInfo.mIgnoreDirtyState = true;
            } //End block
        } //End collapsed parenthetic
        mDirty.union(dirty);
        {
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "813AAD1E42CFCCC731AB301BBB74FC18", hash_generated_method = "5C04F2C09C2F356F5E5693DFDD234477")
    @DSModeled(DSC.SAFE)
     void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
        // ---------- Original Method ----------
        //mDirty.set(0, 0, mWidth, mHeight);
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "081DD37813B858E5AB3FA0820EF5D835", hash_generated_method = "DD6B5D70A6C5486D23C82558DD7A85B8")
    @DSModeled(DSC.SAFE)
     void setStopped(boolean stopped) {
        dsTaint.addTaint(stopped);
        {
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mStopped != stopped) {
            //mStopped = stopped;
            //if (!stopped) {
                //scheduleTraversals();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.710 -0400", hash_original_method = "DCC308262D5800610A000228CF8970A4", hash_generated_method = "9E80A92699DDCFA09EDE833B95037254")
    @DSModeled(DSC.SAFE)
    public ViewParent getParent() {
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "67B0199062309B0E78F2F88E3E2AD59A", hash_generated_method = "05B9CC1A830A4769268A362BCB3EBD03")
    @DSModeled(DSC.SAFE)
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(dirty.dsTaint);
        invalidateChild(null, dirty);
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //invalidateChild(null, dirty);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "FB92C76BB083D5DC37740C978F02B71C", hash_generated_method = "50198F3FBCAE72CDF16C1F407B9CF5D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(offset.dsTaint);
        {
            throw new RuntimeException("child is not mine, honest!");
        } //End block
        boolean var3C447C15080EDED58EBDD084A72DF38D_2101910600 = (r.intersect(0, 0, mWidth, mHeight));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (child != mView) {
            //throw new RuntimeException("child is not mine, honest!");
        //}
        //return r.intersect(0, 0, mWidth, mHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "57451ED91AC07EA69FA21499971D2B45", hash_generated_method = "01998103EA3C9AC18C6BEA04E0EB62A4")
    @DSModeled(DSC.SAFE)
    public void bringChildToFront(View child) {
        dsTaint.addTaint(child.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "0E9A2AD60F5B60B1A096C27CF046877D", hash_generated_method = "1F62085AF30397334F31145E30D7B3A1")
    @DSModeled(DSC.SAFE)
    public void scheduleTraversals() {
        {
            mTraversalScheduled = true;
            {
                final long now;
                now = System.nanoTime();
                Log.d(TAG, "Latency: Scheduled traversal, it has been "
                        + ((now - mLastTraversalFinishedTimeNanos) * 0.000001f)
                        + "ms since the last traversal finished.");
            } //End block
            sendEmptyMessage(DO_TRAVERSAL);
        } //End block
        // ---------- Original Method ----------
        //if (!mTraversalScheduled) {
            //mTraversalScheduled = true;
            //if (ViewDebug.DEBUG_LATENCY && mLastTraversalFinishedTimeNanos != 0) {
                //final long now = System.nanoTime();
                //Log.d(TAG, "Latency: Scheduled traversal, it has been "
                        //+ ((now - mLastTraversalFinishedTimeNanos) * 0.000001f)
                        //+ "ms since the last traversal finished.");
            //}
            //sendEmptyMessage(DO_TRAVERSAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "0B26D78664F51D8793A6008ECDA459E7", hash_generated_method = "AED5AB297E930A2FA4B907E3604897DB")
    @DSModeled(DSC.SAFE)
    public void unscheduleTraversals() {
        {
            mTraversalScheduled = false;
            removeMessages(DO_TRAVERSAL);
        } //End block
        // ---------- Original Method ----------
        //if (mTraversalScheduled) {
            //mTraversalScheduled = false;
            //removeMessages(DO_TRAVERSAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "27A276950AD49DC3B2BCAC57214867E1", hash_generated_method = "F5161F81D1989A4F98AD29CC74663C99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getHostVisibility() {
        {
            Object var8D6CE5BDBC311FE3B049ABF0D70214FD_276931860 = (mView.getVisibility());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAppVisible ? mView.getVisibility() : View.GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "4A37F94A433BB0C51ABAD4CD2013B711", hash_generated_method = "8E2E79CBEF7B800E6FA11366CCA3AB3B")
    @DSModeled(DSC.SAFE)
     void disposeResizeBuffer() {
        {
            mResizeBuffer.destroy();
            mResizeBuffer = null;
        } //End block
        // ---------- Original Method ----------
        //if (mResizeBuffer != null) {
            //mResizeBuffer.destroy();
            //mResizeBuffer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "9CCD20C4D5BE58E51524A629AA69C9DE", hash_generated_method = "8501511A26325E04EAC861B486D9AD5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestTransitionStart(LayoutTransition transition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(transition.dsTaint);
        {
            boolean var194FCB9DF54F69E97F56CE68C10354D0_1378357194 = (mPendingTransitions == null || !mPendingTransitions.contains(transition));
            {
                {
                    mPendingTransitions = new ArrayList<LayoutTransition>();
                } //End block
                mPendingTransitions.add(transition);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPendingTransitions == null || !mPendingTransitions.contains(transition)) {
            //if (mPendingTransitions == null) {
                 //mPendingTransitions = new ArrayList<LayoutTransition>();
            //}
            //mPendingTransitions.add(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.711 -0400", hash_original_method = "E06FBD8158D133D090EB34C23F0C9FD1", hash_generated_method = "E8832C92F0DB070A94B9D50A4A82D907")
    @DSModeled(DSC.SAFE)
    private void processInputEvents(boolean outOfOrder) {
        dsTaint.addTaint(outOfOrder);
        {
            handleMessage(mPendingInputEvents.mMessage);
            InputEventMessage tmpMessage;
            tmpMessage = mPendingInputEvents;
            mPendingInputEvents = mPendingInputEvents.mNext;
            tmpMessage.recycle();
            {
                removeMessages(PROCESS_INPUT_EVENTS);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //while (mPendingInputEvents != null) {
            //handleMessage(mPendingInputEvents.mMessage);
            //InputEventMessage tmpMessage = mPendingInputEvents;
            //mPendingInputEvents = mPendingInputEvents.mNext;
            //tmpMessage.recycle();
            //if (outOfOrder) {
                //removeMessages(PROCESS_INPUT_EVENTS);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.716 -0400", hash_original_method = "DF10FEADFB061504FA9A2B620C341C55", hash_generated_method = "D98C5CB1BCFF96924021DC2CBD8086A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performTraversals() {
        final View host;
        host = mView;
        processInputEvents(true);
        {
            System.out.println("======================================");
            System.out.println("performTraversals");
            host.debug();
        } //End block
        mTraversalScheduled = false;
        mWillDrawSoon = true;
        boolean windowSizeMayChange;
        windowSizeMayChange = false;
        boolean fullRedrawNeeded;
        fullRedrawNeeded = mFullRedrawNeeded;
        boolean newSurface;
        newSurface = false;
        boolean surfaceChanged;
        surfaceChanged = false;
        WindowManager.LayoutParams lp;
        lp = mWindowAttributes;
        int desiredWindowWidth;
        int desiredWindowHeight;
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        final View.AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        final int viewVisibility;
        viewVisibility = getHostVisibility();
        boolean viewVisibilityChanged;
        viewVisibilityChanged = mViewVisibility != viewVisibility
                || mNewSurfaceNeeded;
        WindowManager.LayoutParams params;
        params = null;
        {
            mWindowAttributesChanged = false;
            surfaceChanged = true;
            params = lp;
        } //End block
        CompatibilityInfo compatibilityInfo;
        compatibilityInfo = mCompatibilityInfo.get();
        {
            boolean var0A004AC3811C18545614B32625CEEC49_13966073 = (compatibilityInfo.supportsScreen() == mLastInCompatMode);
            {
                params = lp;
                fullRedrawNeeded = true;
                mLayoutRequested = true;
                {
                    params.flags &= ~WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = false;
                } //End block
                {
                    params.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        mWindowAttributesChangesFlag = 0;
        Rect frame;
        frame = mWinFrame;
        {
            fullRedrawNeeded = true;
            mLayoutRequested = true;
            {
                Display disp;
                disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                Point size;
                size = new Point();
                disp.getRealSize(size);
                desiredWindowWidth = size.x;
                desiredWindowHeight = size.y;
            } //End block
            {
                DisplayMetrics packageMetrics;
                packageMetrics = mView.getContext().getResources().getDisplayMetrics();
                desiredWindowWidth = packageMetrics.widthPixels;
                desiredWindowHeight = packageMetrics.heightPixels;
            } //End block
            attachInfo.mSurface = mSurface;
            attachInfo.mUse32BitDrawingCache = true;
            attachInfo.mHasWindowFocus = false;
            attachInfo.mWindowVisibility = viewVisibility;
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            viewVisibilityChanged = false;
            mLastConfiguration.setTo(host.getResources().getConfiguration());
            host.dispatchAttachedToWindow(attachInfo, 0);
            host.fitSystemWindows(mAttachInfo.mContentInsets);
        } //End block
        {
            desiredWindowWidth = frame.width();
            desiredWindowHeight = frame.height();
            {
                fullRedrawNeeded = true;
                mLayoutRequested = true;
                windowSizeMayChange = true;
            } //End block
        } //End block
        {
            attachInfo.mWindowVisibility = viewVisibility;
            host.dispatchWindowVisibilityChanged(viewVisibility);
            {
                destroyHardwareResources();
            } //End block
            {
                mHasHadWindowFocus = false;
            } //End block
        } //End block
        boolean insetsChanged;
        insetsChanged = false;
        {
            getRunQueue().executeActions(attachInfo.mHandler);
            final Resources res;
            res = mView.getContext().getResources();
            {
                mAttachInfo.mInTouchMode = !mAddedTouchMode;
                ensureTouchModeLocally(mAddedTouchMode);
            } //End block
            {
                {
                    boolean var62033EA88707C143C01D8EAFE9900154_734194837 = (!mPendingContentInsets.equals(mAttachInfo.mContentInsets));
                    {
                        insetsChanged = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var0CAA9A1F030432324CBF6F78F99C9DD7_335887727 = (!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets));
                    {
                        mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    } //End block
                } //End collapsed parenthetic
                {
                    windowSizeMayChange = true;
                    {
                        Display disp;
                        disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                        Point size;
                        size = new Point();
                        disp.getRealSize(size);
                        desiredWindowWidth = size.x;
                        desiredWindowHeight = size.y;
                    } //End block
                    {
                        DisplayMetrics packageMetrics;
                        packageMetrics = res.getDisplayMetrics();
                        desiredWindowWidth = packageMetrics.widthPixels;
                        desiredWindowHeight = packageMetrics.heightPixels;
                    } //End block
                } //End block
            } //End block
            boolean goodMeasure;
            goodMeasure = false;
            {
                final DisplayMetrics packageMetrics;
                packageMetrics = res.getDisplayMetrics();
                res.getValue(com.android.internal.R.dimen.config_prefDialogWidth, mTmpValue, true);
                int baseSize;
                baseSize = 0;
                {
                    baseSize = (int)mTmpValue.getDimension(packageMetrics);
                } //End block
                {
                    childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    {
                        boolean var21D962C086164386A94062CBCB36B58F_1884304032 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
                        {
                            goodMeasure = true;
                        } //End block
                        {
                            baseSize = (baseSize+desiredWindowWidth)/2;
                            childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                            host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            {
                                boolean var9F98C604F7D547E03F47254F3D22799F_248584281 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
                                {
                                    goodMeasure = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);
                childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                {
                    boolean varDF7BF5380028FDCE8B63C5F6F1205021_1017208008 = (mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight());
                    {
                        windowSizeMayChange = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after measure");
                host.debug();
            } //End block
        } //End block
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            boolean oldScreenOn;
            oldScreenOn = attachInfo.mKeepScreenOn;
            int oldVis;
            oldVis = attachInfo.mSystemUiVisibility;
            boolean oldHasSystemUiListeners;
            oldHasSystemUiListeners = attachInfo.mHasSystemUiListeners;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            attachInfo.mHasSystemUiListeners = false;
            host.dispatchCollectViewAttributes(0);
            {
                params = lp;
            } //End block
        } //End block
        {
            attachInfo.mForceReportNewAttributes = false;
            params = lp;
        } //End block
        {
            attachInfo.mViewVisibilityChanged = false;
            int resizeMode;
            resizeMode = mSoftInputMode &
                    WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;
            {
                final int N;
                N = attachInfo.mScrollContainers.size();
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varA64E9739EA7F01D5D1160845BAD0386A_974661071 = (attachInfo.mScrollContainers.get(i).isShown());
                            {
                                resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
                } //End block
                {
                    lp.softInputMode = (lp.softInputMode &
                            ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) |
                            resizeMode;
                    params = lp;
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var124397EC8E035E35B1B90F57C49E8065_10881277 = (!PixelFormat.formatHasAlpha(params.format));
                {
                    params.format = PixelFormat.TRANSLUCENT;
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean windowShouldResize;
        windowShouldResize = mLayoutRequested && windowSizeMayChange
            && ((mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight())
                || (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.width() < desiredWindowWidth && frame.width() != mWidth)
                || (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.height() < desiredWindowHeight && frame.height() != mHeight));
        final boolean computesInternalInsets;
        computesInternalInsets = attachInfo.mTreeObserver.hasComputeInternalInsetsListeners();
        boolean insetsPending;
        insetsPending = false;
        int relayoutResult;
        relayoutResult = 0;
        {
            {
                insetsPending = computesInternalInsets && (mFirst || viewVisibilityChanged);
            } //End block
            {
                mSurfaceHolder.mSurfaceLock.lock();
                mDrawingAllowed = true;
            } //End block
            boolean hwInitialized;
            hwInitialized = false;
            boolean contentInsetsChanged;
            contentInsetsChanged = false;
            boolean visibleInsetsChanged;
            boolean hadSurface;
            hadSurface = mSurface.isValid();
            try 
            {
                int fl;
                fl = 0;
                {
                    fl = params.flags;
                    {
                        params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    } //End block
                    params.subtreeSystemUiVisibility = attachInfo.mSystemUiVisibility;
                    params.hasSystemUiListeners = attachInfo.mHasSystemUiListeners;
                } //End block
                final int surfaceGenerationId;
                surfaceGenerationId = mSurface.getGenerationId();
                relayoutResult = relayoutWindow(params, viewVisibility, insetsPending);
                {
                    params.flags = fl;
                } //End block
                {
                    updateConfiguration(mPendingConfiguration, !mFirst);
                    mPendingConfiguration.seq = 0;
                } //End block
                contentInsetsChanged = !mPendingContentInsets.equals(
                        mAttachInfo.mContentInsets);
                visibleInsetsChanged = !mPendingVisibleInsets.equals(
                        mAttachInfo.mVisibleInsets);
                {
                    {
                        boolean var1E0539E09B573A600F6F1CFEAFBE4679_724996007 = (mWidth > 0 && mHeight > 0 &&
                            mSurface != null && mSurface.isValid() &&
                            !mAttachInfo.mTurnOffWindowResizeAnim &&
                            mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled() &&
                            mAttachInfo.mHardwareRenderer.validate() &&
                            lp != null && !PixelFormat.formatHasAlpha(lp.format));
                        {
                            disposeResizeBuffer();
                            boolean completed;
                            completed = false;
                            HardwareCanvas hwRendererCanvas;
                            hwRendererCanvas = mAttachInfo.mHardwareRenderer.getCanvas();
                            HardwareCanvas layerCanvas;
                            layerCanvas = null;
                            try 
                            {
                                {
                                    mResizeBuffer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                                        mWidth, mHeight, false);
                                } //End block
                                {
                                    boolean var3E6D8158ACA9AC4B059634A10A6CF6F6_968610427 = (mResizeBuffer.getWidth() != mWidth ||
                                    mResizeBuffer.getHeight() != mHeight);
                                    {
                                        mResizeBuffer.resize(mWidth, mHeight);
                                    } //End block
                                } //End collapsed parenthetic
                                layerCanvas = mResizeBuffer.start(hwRendererCanvas);
                                layerCanvas.setViewport(mWidth, mHeight);
                                layerCanvas.onPreDraw(null);
                                final int restoreCount;
                                restoreCount = layerCanvas.save();
                                layerCanvas.drawColor(0xff000000, PorterDuff.Mode.SRC);
                                int yoff;
                                final boolean scrolling;
                                scrolling = mScroller != null
                                    && mScroller.computeScrollOffset();
                                {
                                    yoff = mScroller.getCurrY();
                                    mScroller.abortAnimation();
                                } //End block
                                {
                                    yoff = mScrollY;
                                } //End block
                                layerCanvas.translate(0, -yoff);
                                {
                                    mTranslator.translateCanvas(layerCanvas);
                                } //End block
                                mView.draw(layerCanvas);
                                mResizeBufferStartTime = SystemClock.uptimeMillis();
                                mResizeBufferDuration = mView.getResources().getInteger(
                                    com.android.internal.R.integer.config_mediumAnimTime);
                                completed = true;
                                layerCanvas.restoreToCount(restoreCount);
                            } //End block
                            catch (OutOfMemoryError e)
                            { }
                            finally 
                            {
                                {
                                    layerCanvas.onPostDraw();
                                } //End block
                                {
                                    mResizeBuffer.end(hwRendererCanvas);
                                    {
                                        mResizeBuffer.destroy();
                                        mResizeBuffer = null;
                                    } //End block
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    mAttachInfo.mContentInsets.set(mPendingContentInsets);
                    host.fitSystemWindows(mAttachInfo.mContentInsets);
                } //End block
                {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                } //End block
                {
                    {
                        boolean var85F0101842CACF01F09324AA7EC986C7_1113335748 = (mSurface.isValid());
                        {
                            newSurface = true;
                            fullRedrawNeeded = true;
                            mPreviousTransparentRegion.setEmpty();
                            {
                                try 
                                {
                                    hwInitialized = mAttachInfo.mHardwareRenderer.initialize(mHolder);
                                } //End block
                                catch (Surface.OutOfResourcesException e)
                                {
                                    try 
                                    {
                                        {
                                            boolean varDF4C39F3C79070D8F8930AEFD74A46C5_1776638587 = (!sWindowSession.outOfMemory(mWindow));
                                            {
                                                Process.killProcess(Process.myPid());
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    catch (RemoteException ex)
                                    { }
                                    mLayoutRequested = true;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var223FE8BD2DC3BE69B6019B00E048EE0C_1442814379 = (!mSurface.isValid());
                    {
                        mLastScrolledFocus = null;
                        mScrollY = mCurScrollY = 0;
                        {
                            mScroller.abortAnimation();
                        } //End block
                        disposeResizeBuffer();
                        {
                            boolean var750EE654262A2705CF0E4AE4A63530E4_1324246229 = (mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled());
                            {
                                mAttachInfo.mHardwareRenderer.destroy(true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varA621B9B0F4C63EC9228FD0CAB33867BD_1839045143 = (surfaceGenerationId != mSurface.getGenerationId() &&
                        mSurfaceHolder == null && mAttachInfo.mHardwareRenderer != null);
                        {
                            fullRedrawNeeded = true;
                            try 
                            {
                                mAttachInfo.mHardwareRenderer.updateSurface(mHolder);
                            } //End block
                            catch (Surface.OutOfResourcesException e)
                            {
                                try 
                                {
                                    {
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_876441837 = (!sWindowSession.outOfMemory(mWindow));
                                        {
                                            Process.killProcess(Process.myPid());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                catch (RemoteException ex)
                                { }
                                mLayoutRequested = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (RemoteException e)
            { }
            attachInfo.mWindowLeft = frame.left;
            attachInfo.mWindowTop = frame.top;
            mWidth = frame.width();
            mHeight = frame.height();
            {
                {
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_408152193 = (mSurface.isValid());
                    {
                        mSurfaceHolder.mSurface = mSurface;
                    } //End block
                } //End collapsed parenthetic
                mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
                mSurfaceHolder.mSurfaceLock.unlock();
                {
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_1295316753 = (mSurface.isValid());
                    {
                        {
                            mSurfaceHolder.ungetCallbacks();
                            mIsCreating = true;
                            mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
                            SurfaceHolder.Callback callbacks[];
                            callbacks = mSurfaceHolder.getCallbacks();
                            {
                                {
                                    Iterator<SurfaceHolder.Callback> seatecAstronomy42 = callbacks.iterator();
                                    seatecAstronomy42.hasNext();
                                    SurfaceHolder.Callback c = seatecAstronomy42.next();
                                    {
                                        c.surfaceCreated(mSurfaceHolder);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            surfaceChanged = true;
                        } //End block
                        {
                            mSurfaceHolderCallback.surfaceChanged(mSurfaceHolder,
                                lp.format, mWidth, mHeight);
                            SurfaceHolder.Callback callbacks[];
                            callbacks = mSurfaceHolder.getCallbacks();
                            {
                                {
                                    Iterator<SurfaceHolder.Callback> seatecAstronomy42 = callbacks.iterator();
                                    seatecAstronomy42.hasNext();
                                    SurfaceHolder.Callback c = seatecAstronomy42.next();
                                    {
                                        c.surfaceChanged(mSurfaceHolder, lp.format,
                                        mWidth, mHeight);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                        mIsCreating = false;
                    } //End block
                    {
                        mSurfaceHolder.ungetCallbacks();
                        SurfaceHolder.Callback callbacks[];
                        callbacks = mSurfaceHolder.getCallbacks();
                        mSurfaceHolderCallback.surfaceDestroyed(mSurfaceHolder);
                        {
                            {
                                Iterator<SurfaceHolder.Callback> seatecAstronomy42 = callbacks.iterator();
                                seatecAstronomy42.hasNext();
                                SurfaceHolder.Callback c = seatecAstronomy42.next();
                                {
                                    c.surfaceDestroyed(mSurfaceHolder);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        mSurfaceHolder.mSurfaceLock.lock();
                        try 
                        {
                            mSurfaceHolder.mSurface = new Surface();
                        } //End block
                        finally 
                        {
                            mSurfaceHolder.mSurfaceLock.unlock();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_1879600565 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    {
                        boolean var68BE6CA5337B3E1A6C30D35C34420F08_1834213584 = (hwInitialized || windowShouldResize ||
                        mWidth != mAttachInfo.mHardwareRenderer.getWidth() ||
                        mHeight != mAttachInfo.mHardwareRenderer.getHeight());
                        {
                            mAttachInfo.mHardwareRenderer.setup(mWidth, mHeight);
                            {
                                mAttachInfo.mHardwareRenderer.invalidate(mHolder);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean focusChangedDueToTouchMode;
                focusChangedDueToTouchMode = ensureTouchModeLocally(
                        (relayoutResult&WindowManagerImpl.RELAYOUT_RES_IN_TOUCH_MODE) != 0);
                {
                    boolean varA6DAF762C1B830FF995EE7E2238847D5_678006869 = (focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth()
                        || mHeight != host.getMeasuredHeight() || contentInsetsChanged);
                    {
                        childWidthMeasureSpec = getRootMeasureSpec(mWidth, lp.width);
                        childHeightMeasureSpec = getRootMeasureSpec(mHeight, lp.height);
                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        int width;
                        width = host.getMeasuredWidth();
                        int height;
                        height = host.getMeasuredHeight();
                        boolean measureAgain;
                        measureAgain = false;
                        {
                            width += (int) ((mWidth - width) * lp.horizontalWeight);
                            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
                                MeasureSpec.EXACTLY);
                            measureAgain = true;
                        } //End block
                        {
                            height += (int) ((mHeight - height) * lp.verticalWeight);
                            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY);
                            measureAgain = true;
                        } //End block
                        {
                            host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        } //End block
                        mLayoutRequested = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        final boolean didLayout;
        didLayout = mLayoutRequested && !mStopped;
        boolean triggerGlobalLayoutListener;
        triggerGlobalLayoutListener = didLayout
                || attachInfo.mRecomputeGlobalAttributes;
        {
            mLayoutRequested = false;
            mScrollMayChange = true;
            long startTime;
            startTime = 0L;
            {
                startTime = SystemClock.elapsedRealtime();
            } //End block
            host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());
            {
                {
                    boolean var31831045BDEFED9943FC4835790CC5A9_595442659 = (!host.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_LAYOUT));
                    {
                        throw new IllegalStateException("The view hierarchy is an inconsistent state,"
                            + "please refer to the logs with the tag "
                            + ViewDebug.CONSISTENCY_LOG_TAG + " for more infomation.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                EventLog.writeEvent(60001, SystemClock.elapsedRealtime() - startTime);
            } //End block
            {
                host.getLocationInWindow(mTmpLocation);
                mTransparentRegion.set(mTmpLocation[0], mTmpLocation[1],
                        mTmpLocation[0] + host.mRight - host.mLeft,
                        mTmpLocation[1] + host.mBottom - host.mTop);
                host.gatherTransparentRegion(mTransparentRegion);
                {
                    mTranslator.translateRegionInWindowToScreen(mTransparentRegion);
                } //End block
                {
                    boolean var9116609D398330DBB934B3776C260A89_1741721283 = (!mTransparentRegion.equals(mPreviousTransparentRegion));
                    {
                        mPreviousTransparentRegion.set(mTransparentRegion);
                        try 
                        {
                            sWindowSession.setTransparentRegion(mWindow, mTransparentRegion);
                        } //End block
                        catch (RemoteException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after setFrame");
                host.debug();
            } //End block
        } //End block
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mTreeObserver.dispatchOnGlobalLayout();
            {
                boolean var673B0FAE9DD6499A44EB4983D0077ABD_789227087 = (AccessibilityManager.getInstance(host.mContext).isEnabled());
                {
                    postSendWindowContentChangedCallback();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            final ViewTreeObserver.InternalInsetsInfo insets;
            insets = attachInfo.mGivenInternalInsets;
            insets.reset();
            attachInfo.mTreeObserver.dispatchOnComputeInternalInsets(insets);
            {
                boolean var0FBD0E114506B508CD538E9D69F15B52_1700864479 = (insetsPending || !mLastGivenInsets.equals(insets));
                {
                    mLastGivenInsets.set(insets);
                    final Rect contentInsets;
                    final Rect visibleInsets;
                    final Region touchableRegion;
                    {
                        contentInsets = mTranslator.getTranslatedContentInsets(insets.contentInsets);
                        visibleInsets = mTranslator.getTranslatedVisibleInsets(insets.visibleInsets);
                        touchableRegion = mTranslator.getTranslatedTouchableArea(insets.touchableRegion);
                    } //End block
                    {
                        contentInsets = insets.contentInsets;
                        visibleInsets = insets.visibleInsets;
                        touchableRegion = insets.touchableRegion;
                    } //End block
                    try 
                    {
                        sWindowSession.setInsets(mWindow, insets.mTouchableInsets,
                            contentInsets, visibleInsets, touchableRegion);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                {
                    boolean var4424A784A6C03CB3A8B3EDDFC8E02AD9_275075995 = (!mView.hasFocus());
                    {
                        mView.requestFocus(View.FOCUS_FORWARD);
                        mFocusedView = mRealFocusedView = mView.findFocus();
                    } //End block
                    {
                        mRealFocusedView = mView.findFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mFirst = false;
        mWillDrawSoon = false;
        mNewSurfaceNeeded = false;
        mViewVisibility = viewVisibility;
        {
            final boolean imTarget;
            imTarget = WindowManager.LayoutParams
                    .mayUseInputMethod(mWindowAttributes.flags);
            {
                mLastWasImTarget = imTarget;
                InputMethodManager imm;
                imm = InputMethodManager.peekInstance();
                {
                    imm.startGettingWindowFocus(mView);
                    imm.onWindowFocus(mView, mView.findFocus(),
                            mWindowAttributes.softInputMode,
                            !mHasHadWindowFocus, mWindowAttributes.flags);
                } //End block
            } //End block
        } //End block
        boolean cancelDraw;
        cancelDraw = attachInfo.mTreeObserver.dispatchOnPreDraw() ||
                viewVisibility != View.VISIBLE;
        {
            {
                boolean var01179B785E9234D284AD849ED1C97F52_1261032165 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i;
                        i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_895140392 = (i < mPendingTransitions.size());
                        {
                            mPendingTransitions.get(i).startChangingAnimations();
                        } //End block
                    } //End collapsed parenthetic
                    mPendingTransitions.clear();
                } //End block
            } //End collapsed parenthetic
            mFullRedrawNeeded = false;
            final long drawStartTime;
            {
                drawStartTime = System.nanoTime();
            } //End block
            draw(fullRedrawNeeded);
            {
                mLastDrawDurationNanos = System.nanoTime() - drawStartTime;
            } //End block
            {
                mReportNextDraw = false;
                {
                    boolean varFBA90BC0FA837508D9D80EA4B8A252E5_2103174444 = (mSurfaceHolder != null && mSurface.isValid());
                    {
                        mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
                        SurfaceHolder.Callback callbacks[];
                        callbacks = mSurfaceHolder.getCallbacks();
                        {
                            {
                                Iterator<SurfaceHolder.Callback> seatecAstronomy42 = callbacks.iterator();
                                seatecAstronomy42.hasNext();
                                SurfaceHolder.Callback c = seatecAstronomy42.next();
                                {
                                    {
                                        ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                        mSurfaceHolder);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                try 
                {
                    sWindowSession.finishDrawing(mWindow);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        {
            {
                boolean var01179B785E9234D284AD849ED1C97F52_1643906663 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i;
                        i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_1087658649 = (i < mPendingTransitions.size());
                        {
                            mPendingTransitions.get(i).endChangingAnimations();
                        } //End block
                    } //End collapsed parenthetic
                    mPendingTransitions.clear();
                } //End block
            } //End collapsed parenthetic
            {
                mReportNextDraw = true;
            } //End block
            {
                mFullRedrawNeeded = true;
            } //End block
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.717 -0400", hash_original_method = "365202E212CCFCA6F73CFA951F572330", hash_generated_method = "AC700CDB90D147CDD8B0DD6A5CB226FC")
    @DSModeled(DSC.SAFE)
    public void requestTransparentRegion(View child) {
        dsTaint.addTaint(child.dsTaint);
        checkThread();
        {
            mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            mWindowAttributesChanged = true;
            mWindowAttributesChangesFlag = 0;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //mWindowAttributesChanged = true;
            //mWindowAttributesChangesFlag = 0;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.717 -0400", hash_original_method = "66EB141D637AEB4DAD3BF6AA91407C70", hash_generated_method = "DE880CF25549AC71DD256A8760ACA195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRootMeasureSpec(int windowSize, int rootDimension) {
        dsTaint.addTaint(windowSize);
        dsTaint.addTaint(rootDimension);
        int measureSpec;
        //Begin case ViewGroup.LayoutParams.MATCH_PARENT 
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
        //End case ViewGroup.LayoutParams.MATCH_PARENT 
        //Begin case ViewGroup.LayoutParams.WRAP_CONTENT 
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
        //End case ViewGroup.LayoutParams.WRAP_CONTENT 
        //Begin case default 
        measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int measureSpec;
        //switch (rootDimension) {
        //case ViewGroup.LayoutParams.MATCH_PARENT:
            //measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
            //break;
        //case ViewGroup.LayoutParams.WRAP_CONTENT:
            //measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
            //break;
        //default:
            //measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
            //break;
        //}
        //return measureSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.717 -0400", hash_original_method = "40FADC477E8B2549BFFAC38F5B19946C", hash_generated_method = "F30749523F20F4DCC817E70912D8F957")
    @DSModeled(DSC.SAFE)
    public void onHardwarePreDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        canvas.translate(0, -mHardwareYOffset);
        // ---------- Original Method ----------
        //canvas.translate(0, -mHardwareYOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.717 -0400", hash_original_method = "0640B89EE45E5EFA4DD1A520BD523415", hash_generated_method = "B57B5CF9FFFCD3422F40AFEB50F1A2C4")
    @DSModeled(DSC.SAFE)
    public void onHardwarePostDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        {
            mResizePaint.setAlpha(mResizeAlpha);
            canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        } //End block
        // ---------- Original Method ----------
        //if (mResizeBuffer != null) {
            //mResizePaint.setAlpha(mResizeAlpha);
            //canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.717 -0400", hash_original_method = "6ED7CE075B975161CAA5CFD7B073E953", hash_generated_method = "53EE35951C59D41989BD1A217EAE298B")
    @DSModeled(DSC.SAFE)
     void outputDisplayList(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            DisplayList displayList;
            displayList = view.getDisplayList();
            {
                mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null && mAttachInfo.mHardwareCanvas != null) {
            //DisplayList displayList = view.getDisplayList();
            //if (displayList != null) {
                //mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.718 -0400", hash_original_method = "910E3893A962467411DC222791137B30", hash_generated_method = "2FE2909524BF5FB6D3DA6EB1882B4E7A")
    @DSModeled(DSC.SAFE)
    private void profileRendering(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            {
                mRenderProfiler = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Starting profiling thread");
                        while (mRenderProfilingEnabled) {
                            mAttachInfo.mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mDirty.set(0, 0, mWidth, mHeight);
                                    scheduleTraversals();
                                }
                            });
                            try {
                                Thread.sleep(15);
                            } catch (InterruptedException e) {
                                Log.d(TAG, "Exiting profiling thread");
                            }                            
                        }
                    }
                }, "Rendering Profiler");
                mRenderProfiler.start();
            } //End block
            {
                mRenderProfiler.interrupt();
                mRenderProfiler = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.718 -0400", hash_original_method = "1AA1A4B748D7601F4F3826735499E6F6", hash_generated_method = "A7B4BED50F3D8518580BC1ED0BD2AF4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trackFPS() {
        long nowTime;
        nowTime = System.currentTimeMillis();
        {
            mFpsStartTime = mFpsPrevTime = nowTime;
            mFpsNumFrames = 0;
        } //End block
        {
            ++mFpsNumFrames;
            String thisHash;
            thisHash = Integer.toHexString(System.identityHashCode(this));
            long frameTime;
            frameTime = nowTime - mFpsPrevTime;
            long totalTime;
            totalTime = nowTime - mFpsStartTime;
            mFpsPrevTime = nowTime;
            {
                float fps;
                fps = (float) mFpsNumFrames * 1000 / totalTime;
                mFpsStartTime = nowTime;
                mFpsNumFrames = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //long nowTime = System.currentTimeMillis();
        //if (mFpsStartTime < 0) {
            //mFpsStartTime = mFpsPrevTime = nowTime;
            //mFpsNumFrames = 0;
        //} else {
            //++mFpsNumFrames;
            //String thisHash = Integer.toHexString(System.identityHashCode(this));
            //long frameTime = nowTime - mFpsPrevTime;
            //long totalTime = nowTime - mFpsStartTime;
            //Log.v(TAG, "0x" + thisHash + "\tFrame time:\t" + frameTime);
            //mFpsPrevTime = nowTime;
            //if (totalTime > 1000) {
                //float fps = (float) mFpsNumFrames * 1000 / totalTime;
                //Log.v(TAG, "0x" + thisHash + "\tFPS:\t" + fps);
                //mFpsStartTime = nowTime;
                //mFpsNumFrames = 0;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.719 -0400", hash_original_method = "E37EF3DCFB26F629DB3873EE57113F2D", hash_generated_method = "6971DBF8FB70C3D3B4CD3758D3EDCDB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void draw(boolean fullRedrawNeeded) {
        dsTaint.addTaint(fullRedrawNeeded);
        Surface surface;
        surface = mSurface;
        {
            boolean var2E815E81AF85D59B92EF3DD48D335D0C_331701327 = (surface == null || !surface.isValid());
        } //End collapsed parenthetic
        {
            trackFPS();
        } //End block
        {
            {
                sFirstDrawComplete = true;
                final int count;
                count = sFirstDrawHandlers.size();
                {
                    int i;
                    i = 0;
                    {
                        post(sFirstDrawHandlers.get(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        scrollToRectOrFocus(null, false);
        {
            mAttachInfo.mViewScrollChanged = false;
            mAttachInfo.mTreeObserver.dispatchOnScrollChanged();
        } //End block
        int yoff;
        boolean animating;
        animating = mScroller != null && mScroller.computeScrollOffset();
        {
            yoff = mScroller.getCurrY();
        } //End block
        {
            yoff = mScrollY;
        } //End block
        {
            mCurScrollY = yoff;
            fullRedrawNeeded = true;
        } //End block
        float appScale;
        appScale = mAttachInfo.mApplicationScale;
        boolean scalingRequired;
        scalingRequired = mAttachInfo.mScalingRequired;
        int resizeAlpha;
        resizeAlpha = 0;
        {
            long deltaTime;
            deltaTime = SystemClock.uptimeMillis() - mResizeBufferStartTime;
            {
                float amt;
                amt = deltaTime/(float) mResizeBufferDuration;
                amt = mResizeInterpolator.getInterpolation(amt);
                animating = true;
                resizeAlpha = 255 - (int)(amt*255);
            } //End block
            {
                disposeResizeBuffer();
            } //End block
        } //End block
        Rect dirty;
        dirty = mDirty;
        {
            dirty.setEmpty();
            {
                {
                    mScroller.abortAnimation();
                } //End block
                disposeResizeBuffer();
            } //End block
        } //End block
        {
            mAttachInfo.mIgnoreDirtyState = true;
            dirty.set(0, 0, (int) (mWidth * appScale + 0.5f), (int) (mHeight * appScale + 0.5f));
        } //End block
        {
            boolean var5D30B77E3F89F2623E0DAAFBA8BE8C49_830930436 = (mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled());
            {
                {
                    boolean varD5F827B9D34B0B1DC1F85ACE756947A8_202446632 = (!dirty.isEmpty() || mIsAnimating);
                    {
                        mIsAnimating = false;
                        mHardwareYOffset = yoff;
                        mResizeAlpha = resizeAlpha;
                        mCurrentDirty.set(dirty);
                        mCurrentDirty.union(mPreviousDirty);
                        mPreviousDirty.set(dirty);
                        dirty.setEmpty();
                        Rect currentDirty;
                        currentDirty = mCurrentDirty;
                        {
                            currentDirty = null;
                        } //End block
                        {
                            boolean varDE04A2AF95D6F679E2E2203A2A073551_257400994 = (mAttachInfo.mHardwareRenderer.draw(mView, mAttachInfo, this, currentDirty));
                            {
                                mPreviousDirty.set(0, 0, mWidth, mHeight);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    mFullRedrawNeeded = true;
                    scheduleTraversals();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC62E7C7590DB61B5214E434C55175F8_2048330033 = (!dirty.isEmpty() || mIsAnimating);
            {
                Canvas canvas;
                try 
                {
                    int left;
                    left = dirty.left;
                    int top;
                    top = dirty.top;
                    int right;
                    right = dirty.right;
                    int bottom;
                    bottom = dirty.bottom;
                    final long lockCanvasStartTime;
                    {
                        lockCanvasStartTime = System.nanoTime();
                    } //End block
                    canvas = surface.lockCanvas(dirty);
                    {
                        long now;
                        now = System.nanoTime();
                        Log.d(TAG, "Latency: Spent "
                            + ((now - lockCanvasStartTime) * 0.000001f)
                            + "ms waiting for surface.lockCanvas()");
                    } //End block
                    {
                        mAttachInfo.mIgnoreDirtyState = true;
                    } //End block
                    canvas.setDensity(mDensity);
                } //End block
                catch (Surface.OutOfResourcesException e)
                {
                    try 
                    {
                        {
                            boolean var752BE542D442F142A9DEDCDCD20ADA9F_641802924 = (!sWindowSession.outOfMemory(mWindow));
                            {
                                Process.killProcess(Process.myPid());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException ex)
                    { }
                    mLayoutRequested = true;
                } //End block
                catch (IllegalArgumentException e)
                {
                    mLayoutRequested = true;
                } //End block
                try 
                {
                    {
                        boolean var94DD6BEDF06EB37762BEEC60B9337CF6_2039523715 = (!dirty.isEmpty() || mIsAnimating);
                        {
                            long startTime;
                            startTime = 0L;
                            {
                                startTime = SystemClock.elapsedRealtime();
                            } //End block
                            {
                                boolean varD1E08946F6E52A077FF56A289B9208C1_779938008 = (!canvas.isOpaque() || yoff != 0);
                                {
                                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                } //End block
                            } //End collapsed parenthetic
                            dirty.setEmpty();
                            mIsAnimating = false;
                            mAttachInfo.mDrawingTime = SystemClock.uptimeMillis();
                            mView.mPrivateFlags |= View.DRAWN;
                            {
                                Context cxt;
                                cxt = mView.getContext();
                            } //End block
                            try 
                            {
                                canvas.translate(0, -yoff);
                                {
                                    mTranslator.translateCanvas(canvas);
                                } //End block
                                canvas.setScreenDensity(scalingRequired
                                ? DisplayMetrics.DENSITY_DEVICE : 0);
                                mAttachInfo.mSetIgnoreDirtyState = false;
                                mView.draw(canvas);
                            } //End block
                            finally 
                            {
                                {
                                    mAttachInfo.mIgnoreDirtyState = false;
                                } //End block
                            } //End block
                            {
                                mView.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_DRAWING);
                            } //End block
                            {
                                EventLog.writeEvent(60000, SystemClock.elapsedRealtime() - startTime);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    surface.unlockCanvasAndPost(canvas);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mFullRedrawNeeded = true;
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.720 -0400", hash_original_method = "FAD7953F436A3C038802D5DE07F19E9E", hash_generated_method = "E8133B601B048A6DA1057E9F68EC2108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        dsTaint.addTaint(rectangle.dsTaint);
        dsTaint.addTaint(immediate);
        final View.AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        final Rect ci;
        ci = attachInfo.mContentInsets;
        final Rect vi;
        vi = attachInfo.mVisibleInsets;
        int scrollY;
        scrollY = 0;
        boolean handled;
        handled = false;
        {
            scrollY = mScrollY;
            View focus;
            focus = mRealFocusedView;
            {
                mRealFocusedView = null;
            } //End block
            {
                rectangle = null;
            } //End block
            {
                mLastScrolledFocus = focus;
                mScrollMayChange = false;
                {
                    boolean var6E219E0A30DABE54C1FB5AE05AB0C96F_1046170756 = (focus.getGlobalVisibleRect(mVisRect, null));
                    {
                        {
                            focus.getFocusedRect(mTempRect);
                            {
                                ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focus, mTempRect);
                            } //End block
                        } //End block
                        {
                            mTempRect.set(rectangle);
                        } //End block
                        {
                            boolean var7B24AA8599694B5C184BD1D7A0EA3976_2121631243 = (mTempRect.intersect(mVisRect));
                            {
                                {
                                    boolean var3D339EB9AF254B1679979682435121C1_1630157564 = (mTempRect.height() >
                                (mView.getHeight()-vi.top-vi.bottom));
                                    {
                                        scrollY -= vi.top - (mTempRect.top-scrollY);
                                    } //End block
                                    {
                                        boolean var3406F2BDBAA7A3EBFD045E8954640BCE_141047942 = ((mTempRect.bottom-scrollY)
                                > (mView.getHeight()-vi.bottom));
                                        {
                                            scrollY += (mTempRect.bottom-scrollY)
                                    - (mView.getHeight()-vi.bottom);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                                handled = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    mScroller = new Scroller(mView.getContext());
                } //End block
                mScroller.startScroll(0, mScrollY, 0, scrollY-mScrollY);
            } //End block
            {
                mScroller.abortAnimation();
            } //End block
            mScrollY = scrollY;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.720 -0400", hash_original_method = "9E09AEB1258054D8E474B794DDE3DA53", hash_generated_method = "23B9A0BE6C9096A20D59EBD1FF8AC4E7")
    @DSModeled(DSC.SAFE)
    public void requestChildFocus(View child, View focused) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(focused.dsTaint);
        checkThread();
        {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            scheduleTraversals();
        } //End block
        mFocusedView = mRealFocusedView = focused;
        // ---------- Original Method ----------
        //checkThread();
        //if (mFocusedView != focused) {
            //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            //scheduleTraversals();
        //}
        //mFocusedView = mRealFocusedView = focused;
        //if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Request child focus: focus now "
                //+ mFocusedView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "D78AE43D1295D32838328E11498E7092", hash_generated_method = "55E542E8D319A5F8AB704BDD5276F76F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearChildFocus(View child) {
        dsTaint.addTaint(child.dsTaint);
        checkThread();
        View oldFocus;
        oldFocus = mFocusedView;
        mFocusedView = mRealFocusedView = null;
        {
            boolean var0C2CE9934D88CF89C62BF802E1814E91_1606084162 = (mView != null && !mView.hasFocus());
            {
                {
                    boolean varC84B37DB46E138B03F613C2E132675E1_662610484 = (!mView.requestFocus(View.FOCUS_FORWARD));
                    {
                        mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkThread();
        //View oldFocus = mFocusedView;
        //if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Clearing child focus");
        //mFocusedView = mRealFocusedView = null;
        //if (mView != null && !mView.hasFocus()) {
            //if (!mView.requestFocus(View.FOCUS_FORWARD)) {
                //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            //}
        //} else if (oldFocus != null) {
            //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "8AB5F5420D903C559791A9BF9B9BF8FD", hash_generated_method = "542C793319C0B28EFBC0D045FBE2A284")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusableViewAvailable(View v) {
        dsTaint.addTaint(v.dsTaint);
        checkThread();
        {
            {
                boolean var9C9B0C0875517AC338686EE7008FD35A_1659799995 = (!mView.hasFocus());
                {
                    v.requestFocus();
                } //End block
                {
                    mFocusedView = mView.findFocus();
                    boolean descendantsHaveDibsOnFocus;
                    descendantsHaveDibsOnFocus = (mFocusedView instanceof ViewGroup) &&
                            (((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    {
                        boolean var673A3BE5EE0B137534BC4B96ECEA81C3_1733907375 = (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView));
                        {
                            v.requestFocus();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView != null) {
            //if (!mView.hasFocus()) {
                //v.requestFocus();
            //} else {
                //mFocusedView = mView.findFocus();
                //boolean descendantsHaveDibsOnFocus =
                        //(mFocusedView instanceof ViewGroup) &&
                            //(((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    //ViewGroup.FOCUS_AFTER_DESCENDANTS);
                //if (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView)) {
                    //v.requestFocus();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "66451BF0E175BE00AB35036422B65D7E", hash_generated_method = "15981CE724A2C2C608A42E9DE98D8E95")
    @DSModeled(DSC.SAFE)
    public void recomputeViewAttributes(View child) {
        dsTaint.addTaint(child.dsTaint);
        checkThread();
        {
            mAttachInfo.mRecomputeGlobalAttributes = true;
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mAttachInfo.mRecomputeGlobalAttributes = true;
            //if (!mWillDrawSoon) {
                //scheduleTraversals();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "59E93FB376BDE71F69616A2B01BFF0AF", hash_generated_method = "98F16F51E2107CEC0A4728215B27EF4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchDetachedFromWindow() {
        {
            {
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_1957823052 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    mAttachInfo.mHardwareRenderer.validate();
                } //End block
            } //End collapsed parenthetic
            mView.dispatchDetachedFromWindow();
        } //End block
        mAccessibilityInteractionConnectionManager.ensureNoConnection();
        mAccessibilityManager.removeAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        removeSendWindowContentChangedCallback();
        mView = null;
        mAttachInfo.mRootView = null;
        mAttachInfo.mSurface = null;
        destroyHardwareRenderer();
        mSurface.release();
        {
            mInputQueueCallback.onInputQueueDestroyed(mInputQueue);
            mInputQueueCallback = null;
            mInputQueue = null;
        } //End block
        {
            InputQueue.unregisterInputChannel(mInputChannel);
        } //End block
        try 
        {
            sWindowSession.remove(mWindow);
        } //End block
        catch (RemoteException e)
        { }
        {
            mInputChannel.dispose();
            mInputChannel = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "095941099FB476714878603F2FD5257D", hash_generated_method = "10A735C5AB5A4F21B53D8201A464E12D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateConfiguration(Configuration config, boolean force) {
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(force);
        CompatibilityInfo ci;
        ci = mCompatibilityInfo.getIfNeeded();
        {
            config = new Configuration(config);
            ci.applyToConfiguration(config);
        } //End block
        {
            {
                int i;
                i = sConfigCallbacks.size()-1;
                {
                    sConfigCallbacks.get(i).onConfigurationChanged(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            config = mView.getResources().getConfiguration();
            {
                boolean var8C30D5838B256BB265C26C428C6B837E_1184914982 = (force || mLastConfiguration.diff(config) != 0);
                {
                    mLastConfiguration.setTo(config);
                    mView.dispatchConfigurationChanged(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.721 -0400", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "418459F41ADF951A5077179957FC2600")
    private static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }
        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.722 -0400", hash_original_method = "4A21A3C59CED96F8D51A1FA9FDD7BAE0", hash_generated_method = "486947955DF3791BB348E635C624758E")
    private static void forceLayout(View view) {
        view.forceLayout();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            final int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                forceLayout(group.getChildAt(i));
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.722 -0400", hash_original_method = "95F12947A9B342E5A748CE842344783A", hash_generated_method = "10FDDA54FAFCF20E8B269380771D157E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessageName(Message message) {
        dsTaint.addTaint(message.dsTaint);
        String var96322DF42F9AAAF04C6A6417DE435EFC_542828288 = (super.getMessageName(message));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.723 -0400", hash_original_method = "0C83FFF474CF8ADB1C57E65037847991", hash_generated_method = "1D6BA91ED85CDFE8FE29D894703FA8F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case View.AttachInfo.INVALIDATE_MSG 
        ((View) msg.obj).invalidate();
        //End case View.AttachInfo.INVALIDATE_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        final View.AttachInfo.InvalidateInfo info;
        info = (View.AttachInfo.InvalidateInfo) msg.obj;
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        info.target.invalidate(info.left, info.top, info.right, info.bottom);
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        info.release();
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case DO_TRAVERSAL 
        {
            Debug.startMethodTracing("ViewAncestor");
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        final long traversalStartTime;
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            traversalStartTime = System.nanoTime();
            mLastDrawDurationNanos = 0;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        performTraversals();
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            long now;
            now = System.nanoTime();
            Log.d(TAG, "Latency: Spent "
                        + ((now - traversalStartTime) * 0.000001f)
                        + "ms in performTraversals(), with "
                        + (mLastDrawDurationNanos * 0.000001f)
                        + "ms of that time in draw()");
            mLastTraversalFinishedTimeNanos = now;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            Debug.stopMethodTracing();
            mProfile = false;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case FINISHED_EVENT 
        handleFinishedEvent(msg.arg1, msg.arg2 != 0);
        //End case FINISHED_EVENT 
        //Begin case DISPATCH_KEY 
        deliverKeyEvent((KeyEvent)msg.obj, msg.arg1 != 0);
        //End case DISPATCH_KEY 
        //Begin case DISPATCH_POINTER 
        deliverPointerEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_POINTER 
        //Begin case DISPATCH_TRACKBALL 
        deliverTrackballEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_TRACKBALL 
        //Begin case DISPATCH_GENERIC_MOTION 
        deliverGenericMotionEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_GENERIC_MOTION 
        //Begin case PROCESS_INPUT_EVENTS 
        processInputEvents(false);
        //End case PROCESS_INPUT_EVENTS 
        //Begin case DISPATCH_APP_VISIBILITY 
        handleAppVisibility(msg.arg1 != 0);
        //End case DISPATCH_APP_VISIBILITY 
        //Begin case DISPATCH_GET_NEW_SURFACE 
        handleGetNewSurface();
        //End case DISPATCH_GET_NEW_SURFACE 
        //Begin case RESIZED 
        ResizedInfo ri;
        ri = (ResizedInfo)msg.obj;
        //End case RESIZED 
        //Begin case RESIZED 
        {
            boolean var143D5C08604C0AF03595F421C2A612C0_2123935243 = (mWinFrame.width() == msg.arg1 && mWinFrame.height() == msg.arg2
                    && mPendingContentInsets.equals(ri.coveredInsets)
                    && mPendingVisibleInsets.equals(ri.visibleInsets)
                    && ((ResizedInfo)msg.obj).newConfig == null);
        } //End collapsed parenthetic
        //End case RESIZED 
        //Begin case RESIZED_REPORT 
        {
            Configuration config;
            config = ((ResizedInfo)msg.obj).newConfig;
            {
                updateConfiguration(config, false);
            } //End block
            mWinFrame.left = 0;
            mWinFrame.right = msg.arg1;
            mWinFrame.top = 0;
            mWinFrame.bottom = msg.arg2;
            mPendingContentInsets.set(((ResizedInfo)msg.obj).coveredInsets);
            mPendingVisibleInsets.set(((ResizedInfo)msg.obj).visibleInsets);
            {
                mReportNextDraw = true;
            } //End block
            {
                forceLayout(mView);
            } //End block
            requestLayout();
        } //End block
        //End case RESIZED_REPORT 
        //Begin case WINDOW_FOCUS_CHANGED 
        {
            {
                boolean hasWindowFocus;
                hasWindowFocus = msg.arg1 != 0;
                mAttachInfo.mHasWindowFocus = hasWindowFocus;
                profileRendering(hasWindowFocus);
                {
                    boolean inTouchMode;
                    inTouchMode = msg.arg2 != 0;
                    ensureTouchModeLocally(inTouchMode);
                    {
                        boolean var3AE98E3D719D8E57E314A6EF6D2DA333_1382959460 = (mAttachInfo.mHardwareRenderer != null &&
                            mSurface != null && mSurface.isValid());
                        {
                            mFullRedrawNeeded = true;
                            try 
                            {
                                mAttachInfo.mHardwareRenderer.initializeIfNeeded(mWidth, mHeight,
                                    mAttachInfo, mHolder);
                            } //End block
                            catch (Surface.OutOfResourcesException e)
                            {
                                try 
                                {
                                    {
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_1004563225 = (!sWindowSession.outOfMemory(mWindow));
                                        {
                                            Process.killProcess(Process.myPid());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                catch (RemoteException ex)
                                { }
                                sendMessageDelayed(obtainMessage(msg.what, msg.arg1, msg.arg2), 500);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                mLastWasImTarget = WindowManager.LayoutParams
                        .mayUseInputMethod(mWindowAttributes.flags);
                InputMethodManager imm;
                imm = InputMethodManager.peekInstance();
                {
                    {
                        imm.startGettingWindowFocus(mView);
                    } //End block
                    mAttachInfo.mKeyDispatchState.reset();
                    mView.dispatchWindowFocusChanged(hasWindowFocus);
                } //End block
                {
                    {
                        imm.onWindowFocus(mView, mView.findFocus(),
                                mWindowAttributes.softInputMode,
                                !mHasHadWindowFocus, mWindowAttributes.flags);
                    } //End block
                    mWindowAttributes.softInputMode &=
                            ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    ((WindowManager.LayoutParams)mView.getLayoutParams())
                            .softInputMode &=
                                ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    mHasHadWindowFocus = true;
                } //End block
                {
                    sendAccessibilityEvents();
                } //End block
            } //End block
        } //End block
        //End case WINDOW_FOCUS_CHANGED 
        //Begin case DIE 
        doDie();
        //End case DIE 
        //Begin case DISPATCH_KEY_FROM_IME 
        {
            KeyEvent event;
            event = (KeyEvent)msg.obj;
            {
                boolean varE3C639C95D7D8182790DE92882BAC40A_1024039806 = ((event.getFlags()&KeyEvent.FLAG_FROM_SYSTEM) != 0);
                {
                    event = KeyEvent.changeFlags(event, event.getFlags() & ~KeyEvent.FLAG_FROM_SYSTEM);
                } //End block
            } //End collapsed parenthetic
            deliverKeyEventPostIme((KeyEvent)msg.obj, false);
        } //End block
        //End case DISPATCH_KEY_FROM_IME 
        //Begin case FINISH_INPUT_CONNECTION 
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                imm.reportFinishInputConnection((InputConnection)msg.obj);
            } //End block
        } //End block
        //End case FINISH_INPUT_CONNECTION 
        //Begin case CHECK_FOCUS 
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                imm.checkFocus();
            } //End block
        } //End block
        //End case CHECK_FOCUS 
        //Begin case CLOSE_SYSTEM_DIALOGS 
        {
            {
                mView.onCloseSystemDialogs((String)msg.obj);
            } //End block
        } //End block
        //End case CLOSE_SYSTEM_DIALOGS 
        //Begin case DISPATCH_DRAG_EVENT DISPATCH_DRAG_LOCATION_EVENT 
        {
            DragEvent event;
            event = (DragEvent)msg.obj;
            event.mLocalState = mLocalDragState;
            handleDragEvent(event);
        } //End block
        //End case DISPATCH_DRAG_EVENT DISPATCH_DRAG_LOCATION_EVENT 
        //Begin case DISPATCH_SYSTEM_UI_VISIBILITY 
        {
            handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo)msg.obj);
        } //End block
        //End case DISPATCH_SYSTEM_UI_VISIBILITY 
        //Begin case UPDATE_CONFIGURATION 
        {
            Configuration config;
            config = (Configuration)msg.obj;
            {
                boolean var1B1857A3FCA31AAF6E6915F53921CC12_779661629 = (config.isOtherSeqNewer(mLastConfiguration));
                {
                    config = mLastConfiguration;
                } //End block
            } //End collapsed parenthetic
            updateConfiguration(config, false);
        } //End block
        //End case UPDATE_CONFIGURATION 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        //Begin case DO_PERFORM_ACCESSIBILITY_ACTION 
        {
            {
                getAccessibilityInteractionController()
                    .perfromAccessibilityActionUiThread(msg);
            } //End block
        } //End block
        //End case DO_PERFORM_ACCESSIBILITY_ACTION 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.723 -0400", hash_original_method = "0B0FC84CA02F82927D98059C965571E0", hash_generated_method = "DA8F5E28021538B2645678DB525C29C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startInputEvent(InputQueue.FinishedCallback finishedCallback) {
        dsTaint.addTaint(finishedCallback.dsTaint);
        {
            mInputEventReceiveTimeNanos = System.nanoTime();
            mInputEventDeliverTimeNanos = 0;
            mInputEventDeliverPostImeTimeNanos = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mFinishedCallback != null) {
            //Slog.w(TAG, "Received a new input event from the input queue but there is "
                    //+ "already an unfinished input event in progress.");
        //}
        //if (ViewDebug.DEBUG_LATENCY) {
            //mInputEventReceiveTimeNanos = System.nanoTime();
            //mInputEventDeliverTimeNanos = 0;
            //mInputEventDeliverPostImeTimeNanos = 0;
        //}
        //mFinishedCallback = finishedCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.724 -0400", hash_original_method = "06AEBC75FF0DC9B70A4E2BB2CC6850C1", hash_generated_method = "E524D5B3C81A1B3E32C9504EF44272D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishInputEvent(InputEvent event, boolean handled) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(handled);
        {
            final long now;
            now = System.nanoTime();
            final long eventTime;
            eventTime = event.getEventTimeNano();
            final StringBuilder msg;
            msg = new StringBuilder();
            msg.append("Latency: Spent ");
            msg.append((now - mInputEventReceiveTimeNanos) * 0.000001f);
            msg.append("ms processing ");
            {
                final KeyEvent keyEvent;
                keyEvent = (KeyEvent)event;
                msg.append("key event, action=");
                msg.append(KeyEvent.actionToString(keyEvent.getAction()));
            } //End block
            {
                final MotionEvent motionEvent;
                motionEvent = (MotionEvent)event;
                msg.append("motion event, action=");
                msg.append(MotionEvent.actionToString(motionEvent.getAction()));
                msg.append(", historySize=");
                msg.append(motionEvent.getHistorySize());
            } //End block
            msg.append(", handled=");
            msg.append(handled);
            msg.append(", received at +");
            msg.append((mInputEventReceiveTimeNanos - eventTime) * 0.000001f);
            {
                msg.append("ms, delivered at +");
                msg.append((mInputEventDeliverTimeNanos - eventTime) * 0.000001f);
            } //End block
            {
                msg.append("ms, delivered post IME at +");
                msg.append((mInputEventDeliverPostImeTimeNanos - eventTime) * 0.000001f);
            } //End block
            msg.append("ms, finished at +");
            msg.append((now - eventTime) * 0.000001f);
            msg.append("ms.");
            Log.d(TAG, msg.toString());
        } //End block
        mFinishedCallback.finished(handled);
        mFinishedCallback = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.724 -0400", hash_original_method = "A6640F15C2D0A406B73F798DB9EA077C", hash_generated_method = "CEC61D61A3DDE016461D254D3844BE5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean ensureTouchMode(boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        try 
        {
            sWindowSession.setInTouchMode(inTouchMode);
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        } //End block
        boolean var7211DA2D02AAD3EC6219E770D8E33669_1434201494 = (ensureTouchModeLocally(inTouchMode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                //+ "touch mode is " + mAttachInfo.mInTouchMode);
        //if (mAttachInfo.mInTouchMode == inTouchMode) return false;
        //try {
            //sWindowSession.setInTouchMode(inTouchMode);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
        //return ensureTouchModeLocally(inTouchMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.724 -0400", hash_original_method = "A817FB22551D2F047707EAAC44367E27", hash_generated_method = "B891037C849FDBC40EDD3CF4F1287D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean ensureTouchModeLocally(boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        mAttachInfo.mInTouchMode = inTouchMode;
        mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        {
            Object varD5C5D13645C8843ADC3AA1EF553CA4E0_863413018 = (enterTouchMode());
            Object var1779B98836824743D0F81D690D2F09AF_2006359216 = (leaveTouchMode());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                //+ "touch mode is " + mAttachInfo.mInTouchMode);
        //if (mAttachInfo.mInTouchMode == inTouchMode) return false;
        //mAttachInfo.mInTouchMode = inTouchMode;
        //mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        //return (inTouchMode) ? enterTouchMode() : leaveTouchMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.724 -0400", hash_original_method = "4D22F5F97C319901FE80DD8DAA6DBF2B", hash_generated_method = "44747935739D394389C5EDA1EE28C892")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean enterTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_435787871 = (mView.hasFocus());
                {
                    final View focused;
                    focused = mView.findFocus();
                    {
                        boolean var672E3B133FEEB41FF55DF762226C4368_1963032159 = (focused != null && !focused.isFocusableInTouchMode());
                        {
                            final ViewGroup ancestorToTakeFocus;
                            ancestorToTakeFocus = findAncestorToTakeFocusInTouchMode(focused);
                            {
                                boolean var4BDB6BBF285F787DB5D62E792270B9CC_1899217703 = (ancestorToTakeFocus.requestFocus());
                            } //End block
                            {
                                mView.unFocus();
                                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(focused, null);
                                mFocusedView = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.725 -0400", hash_original_method = "A2FE4CBD06D42BF7C573F07F56417767", hash_generated_method = "C9790E57DF7DF57F7557864896FA2132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        dsTaint.addTaint(focused.dsTaint);
        ViewParent parent;
        parent = focused.getParent();
        {
            final ViewGroup vgParent;
            vgParent = (ViewGroup) parent;
            {
                boolean varC23A07520BE483EA425697E9FFE7255F_637937487 = (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    && vgParent.isFocusableInTouchMode());
            } //End collapsed parenthetic
            {
                boolean var410E9039314AA011024573FA45C6C4E3_1080467027 = (vgParent.isRootNamespace());
                {
                    parent = vgParent.getParent();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ViewGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ViewParent parent = focused.getParent();
        //while (parent instanceof ViewGroup) {
            //final ViewGroup vgParent = (ViewGroup) parent;
            //if (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    //&& vgParent.isFocusableInTouchMode()) {
                //return vgParent;
            //}
            //if (vgParent.isRootNamespace()) {
                //return null;
            //} else {
                //parent = vgParent.getParent();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.725 -0400", hash_original_method = "6D4A7A06FF255705F6FF85A0D8D1E147", hash_generated_method = "B0F8C684B68FE57922EFEDA33179DC66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean leaveTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_1381134058 = (mView.hasFocus());
                {
                    mFocusedView = mView.findFocus();
                    {
                        boolean var685A2905466615BFEF6173704AD9363B_102361281 = (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            final View focused;
            focused = focusSearch(null, View.FOCUS_DOWN);
            {
                boolean var36C6CFA2F3F9A6ADFC90E9AFC6590240_805953407 = (focused.requestFocus(View.FOCUS_DOWN));
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mView != null) {
            //if (mView.hasFocus()) {
                //mFocusedView = mView.findFocus();
                //if (!(mFocusedView instanceof ViewGroup)) {
                    //return false;
                //} else if (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        //ViewGroup.FOCUS_AFTER_DESCENDANTS) {
                    //return false;
                //}
            //}
            //final View focused = focusSearch(null, View.FOCUS_DOWN);
            //if (focused != null) {
                //return focused.requestFocus(View.FOCUS_DOWN);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.725 -0400", hash_original_method = "8F847D145475DB0C2BA683E62F600908", hash_generated_method = "F32EF10D19E037794F8504AA9F5F58BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverPointerEvent(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        final boolean isTouchEvent;
        isTouchEvent = event.isTouchEvent();
        {
            {
                mInputEventConsistencyVerifier.onTouchEvent(event, 0);
            } //End block
            {
                mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
            } //End block
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            mTranslator.translateEventInScreenToAppWindow(event);
        } //End block
        final int action;
        action = event.getAction();
        {
            ensureTouchMode(true);
        } //End block
        {
            event.offsetLocation(0, mCurScrollY);
        } //End block
        {
            lt.sample("A Dispatching PointerEvents", System.nanoTime() - event.getEventTimeNano());
        } //End block
        {
            mLastTouchPoint.x = event.getRawX();
            mLastTouchPoint.y = event.getRawY();
        } //End block
        boolean handled;
        handled = mView.dispatchPointerEvent(event);
        {
            lt.sample("B Dispatched PointerEvents ", System.nanoTime() - event.getEventTimeNano());
        } //End block
        {
            finishMotionEvent(event, sendDone, true);
        } //End block
        finishMotionEvent(event, sendDone, false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.725 -0400", hash_original_method = "DF90914307EFCD2CA23CDB09D8C7F95D", hash_generated_method = "ACF91395B20F967F8DD77E1B705A2232")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishMotionEvent(MotionEvent event, boolean sendDone, boolean handled) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        dsTaint.addTaint(handled);
        event.recycle();
        {
            finishInputEvent(event, handled);
        } //End block
        {
            {
                boolean varFE47529C887D16DE595A17210AB89645_966612232 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //event.recycle();
        //if (sendDone) {
            //finishInputEvent(event, handled);
        //}
        //if (LOCAL_LOGV || WATCH_POINTER) {
            //if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                //Log.i(TAG, "Done dispatching!");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.726 -0400", hash_original_method = "B306A4DB67A1B71DDAAA3D4C50CD59B0", hash_generated_method = "3AA836E0224C711E13D9ADA627FC622B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverTrackballEvent(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            boolean var0BF4F8530CCB1128C2413D92D7C48A33_1148248053 = (mView.dispatchTrackballEvent(event));
            {
                ensureTouchMode(false);
                finishMotionEvent(event, sendDone, true);
                mLastTrackballTime = Integer.MIN_VALUE;
            } //End block
        } //End collapsed parenthetic
        final TrackballAxis x;
        x = mTrackballAxisX;
        final TrackballAxis y;
        y = mTrackballAxisY;
        long curTime;
        curTime = SystemClock.uptimeMillis();
        {
            x.reset(0);
            y.reset(0);
            mLastTrackballTime = curTime;
        } //End block
        final int action;
        action = event.getAction();
        final int metaState;
        metaState = event.getMetaState();
        //Begin case MotionEvent.ACTION_DOWN 
        x.reset(2);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        y.reset(2);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_UP 
        x.reset(2);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        y.reset(2);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        //End case MotionEvent.ACTION_UP 
        final float xOff;
        xOff = x.collect(event.getX(), event.getEventTime(), "X");
        final float yOff;
        yOff = y.collect(event.getY(), event.getEventTime(), "Y");
        int keycode;
        keycode = 0;
        int movement;
        movement = 0;
        float accel;
        accel = 1;
        {
            movement = x.generate((2/event.getXPrecision()));
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_RIGHT
                        : KeyEvent.KEYCODE_DPAD_LEFT;
                accel = x.acceleration;
                y.reset(2);
            } //End block
        } //End block
        {
            movement = y.generate((2/event.getYPrecision()));
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_DOWN
                        : KeyEvent.KEYCODE_DPAD_UP;
                accel = y.acceleration;
                x.reset(2);
            } //End block
        } //End block
        {
            movement = -movement;
            int accelMovement;
            accelMovement = (int)(movement * accel);
            {
                movement--;
                int repeatCount;
                repeatCount = accelMovement - movement;
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_MULTIPLE, keycode, repeatCount, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            {
                movement--;
                curTime = SystemClock.uptimeMillis();
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            mLastTrackballTime = curTime;
        } //End block
        finishMotionEvent(event, sendDone, true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "D79206E9EE4BD2FB4F0103FA8C72904A", hash_generated_method = "A91B65450E6F26E076E181FF6F283C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverGenericMotionEvent(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        final int source;
        source = event.getSource();
        final boolean isJoystick;
        isJoystick = (source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0;
        {
            {
                updateJoystickDirection(event, false);
            } //End block
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            boolean var1480525DCF9F333BCCE9610B03BC6BD1_601740471 = (mView.dispatchGenericMotionEvent(event));
            {
                {
                    updateJoystickDirection(event, false);
                } //End block
                finishMotionEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            updateJoystickDirection(event, true);
            finishMotionEvent(event, sendDone, true);
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "3F24F6EAAF68F5E1EBCC50D38D5B0024", hash_generated_method = "BAB5FE449E27D2E2FD5BC19D010C2D9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateJoystickDirection(MotionEvent event, boolean synthesizeNewKeys) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(synthesizeNewKeys);
        final long time;
        time = event.getEventTime();
        final int metaState;
        metaState = event.getMetaState();
        final int deviceId;
        deviceId = event.getDeviceId();
        final int source;
        source = event.getSource();
        int xDirection;
        xDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_X));
        {
            xDirection = joystickAxisValueToDirection(event.getX());
        } //End block
        int yDirection;
        yDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_Y));
        {
            yDirection = joystickAxisValueToDirection(event.getY());
        } //End block
        {
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickXKeyCode = 0;
            } //End block
            mLastJoystickXDirection = xDirection;
            {
                mLastJoystickXKeyCode = xDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_RIGHT : KeyEvent.KEYCODE_DPAD_LEFT;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        {
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickYKeyCode = 0;
            } //End block
            mLastJoystickYDirection = yDirection;
            {
                mLastJoystickYKeyCode = yDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_DOWN : KeyEvent.KEYCODE_DPAD_UP;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "822C159A63B62845A16568D718169DEC", hash_generated_method = "0D9A3ACE204C7A37F242AB353E0C3216")
    private static int joystickAxisValueToDirection(float value) {
        if (value >= 0.5f) {
            return 1;
        } else if (value <= -0.5f) {
            return -1;
        } else {
            return 0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "7C2143BAA8152610397375F7B6D253AB", hash_generated_method = "73231264E9616A58A51CB5AF770D3937")
    private static boolean isNavigationKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_PAGE_UP:
        case KeyEvent.KEYCODE_PAGE_DOWN:
        case KeyEvent.KEYCODE_MOVE_HOME:
        case KeyEvent.KEYCODE_MOVE_END:
        case KeyEvent.KEYCODE_TAB:
        case KeyEvent.KEYCODE_SPACE:
        case KeyEvent.KEYCODE_ENTER:
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "553A2E860A4F6148EE15CCC8CC3C5F34", hash_generated_method = "E371B19500089A404A3F7B6A779D7ED9")
    private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.727 -0400", hash_original_method = "4A4EC0979E3C48040C37CBDD240E0778", hash_generated_method = "39CB1872C65B69E0D0FACB4A612F0467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        final int action;
        action = event.getAction();
        {
            boolean var374764C2EBA0004373F7F9D216C18EBE_38850952 = ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0);
        } //End collapsed parenthetic
        {
            boolean varC540748EA661E5534CCE6D53AFE70351_1025110650 = (isNavigationKey(event));
            {
                boolean varDCF046E768F735C43D4A4F2892DB8761_448366612 = (ensureTouchMode(false));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDC7BE1867293052F150F168518DBFDDE_126257289 = (isTypingKey(event));
            {
                ensureTouchMode(false);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mAttachInfo.mInTouchMode) {
            //return false;
        //}
        //final int action = event.getAction();
        //if (action != KeyEvent.ACTION_DOWN && action != KeyEvent.ACTION_MULTIPLE) {
            //return false;
        //}
        //if ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0) {
            //return false;
        //}
        //if (isNavigationKey(event)) {
            //return ensureTouchMode(false);
        //}
        //if (isTypingKey(event)) {
            //ensureTouchMode(false);
            //return false;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.728 -0400", hash_original_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84", hash_generated_method = "8C3972ED09336501C007393A34D21036")
    @DSModeled(DSC.SAFE)
     int enqueuePendingEvent(Object event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        int seq;
        seq = mPendingEventSeq+1;
        seq = 0;
        mPendingEventSeq = seq;
        mPendingEvents.put(seq, event);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int seq = mPendingEventSeq+1;
        //if (seq < 0) seq = 0;
        //mPendingEventSeq = seq;
        //mPendingEvents.put(seq, event);
        //return sendDone ? seq : -seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.728 -0400", hash_original_method = "D1881A2DE4A478B1C2476E8789D90C4F", hash_generated_method = "79A28D7C2002216BEFF36C065967DFE5")
    @DSModeled(DSC.SAFE)
     Object retrievePendingEvent(int seq) {
        dsTaint.addTaint(seq);
        seq = -seq;
        Object event;
        event = mPendingEvents.get(seq);
        {
            mPendingEvents.remove(seq);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (seq < 0) seq = -seq;
        //Object event = mPendingEvents.get(seq);
        //if (event != null) {
            //mPendingEvents.remove(seq);
        //}
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.728 -0400", hash_original_method = "7BC82D96B9DB6F7A084DA2256A5743DA", hash_generated_method = "3656EDA74BEB7309BB5304E331E882DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverKeyEvent(KeyEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        {
            finishKeyEvent(event, sendDone, false);
        } //End block
        {
            boolean var5290A33EAEDAF51EED599C106DE398FD_1219575592 = (mView.dispatchKeyEventPreIme(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                int seq;
                seq = enqueuePendingEvent(event, sendDone);
                imm.dispatchKeyEvent(mView.getContext(), seq, event, mInputMethodCallback);
            } //End block
        } //End block
        deliverKeyEventPostIme(event, sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.728 -0400", hash_original_method = "1D388C4C66D020B7A8C536C50B24E128", hash_generated_method = "9AAA7B18DCA565C8101F7714ED5A3909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleFinishedEvent(int seq, boolean handled) {
        dsTaint.addTaint(seq);
        dsTaint.addTaint(handled);
        final KeyEvent event;
        event = (KeyEvent)retrievePendingEvent(seq);
        {
            final boolean sendDone;
            sendDone = seq >= 0;
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
            {
                deliverKeyEventPostIme(event, sendDone);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final KeyEvent event = (KeyEvent)retrievePendingEvent(seq);
        //if (DEBUG_IMF) Log.v(TAG, "IME finished event: seq=" + seq
                //+ " handled=" + handled + " event=" + event);
        //if (event != null) {
            //final boolean sendDone = seq >= 0;
            //if (handled) {
                //finishKeyEvent(event, sendDone, true);
            //} else {
                //deliverKeyEventPostIme(event, sendDone);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.729 -0400", hash_original_method = "3773604D66AC7B7214885F4E3DA58090", hash_generated_method = "0DFAAB7811071B4458B9A73C3345D325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverKeyEventPostIme(KeyEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverPostImeTimeNanos = System.nanoTime();
        } //End block
        {
            finishKeyEvent(event, sendDone, false);
        } //End block
        {
            boolean var972B8A8CC08694C2525DE534B4F8BB01_328279026 = (checkForLeavingTouchModeAndConsume(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        mFallbackEventHandler.preDispatchKeyEvent(event);
        {
            boolean var9386095FD83FC6C0A38FFA49591950FC_1650628458 = (mView.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var85A8FDC8626CC7E23374B602A2E2C62C_703900400 = (event.getAction() == KeyEvent.ACTION_DOWN
                && event.isCtrlPressed()
                && event.getRepeatCount() == 0
                && !KeyEvent.isModifierKey(event.getKeyCode()));
            {
                {
                    boolean varF97DC0BD6AE66CDC354B90DB1D102EE2_466974132 = (mView.dispatchKeyShortcutEvent(event));
                    {
                        finishKeyEvent(event, sendDone, true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB867097ED2D7A136AEC6AB204A7A4421_1400184873 = (mFallbackEventHandler.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_1652434205 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                int direction;
                direction = 0;
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_1594310644 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_716826286 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_LEFT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_901188085 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_RIGHT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_2070192219 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_UP;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_2005341655 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_DOWN;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_TAB 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_588796286 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_FORWARD;
                        } //End block
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_1062432048 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                direction = View.FOCUS_BACKWARD;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_TAB 
                } //End collapsed parenthetic
                {
                    View focused;
                    focused = mView.findFocus();
                    focused = null;
                    {
                        View v;
                        v = focused.focusSearch(direction);
                        {
                            focused.getFocusedRect(mTempRect);
                            {
                                ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focused, mTempRect);
                                ((ViewGroup) mView).offsetRectIntoDescendantCoords(
                                    v, mTempRect);
                            } //End block
                            {
                                boolean var8E442CEC6A978F0FDB8EDCFD023A5F81_460559343 = (v.requestFocus(direction, mTempRect));
                                {
                                    playSoundEffect(
                                    SoundEffectConstants.getContantForFocusDirection(direction));
                                    finishKeyEvent(event, sendDone, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varF5C20EE82F62ADD0C6A5E46AE0DD38DF_1863196438 = (mView.dispatchUnhandledMove(focused, direction));
                            {
                                finishKeyEvent(event, sendDone, true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        finishKeyEvent(event, sendDone, false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.729 -0400", hash_original_method = "2621255CFED260FE88FD0E0DE76ACADD", hash_generated_method = "3FCC9D3D55DFDC2D00C5CE96ADD90408")
    @DSModeled(DSC.SAFE)
    private void finishKeyEvent(KeyEvent event, boolean sendDone, boolean handled) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        dsTaint.addTaint(handled);
        {
            finishInputEvent(event, handled);
        } //End block
        // ---------- Original Method ----------
        //if (sendDone) {
            //finishInputEvent(event, handled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.729 -0400", hash_original_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80", hash_generated_method = "229060BA2093D7E7114F51447748AC33")
    @DSModeled(DSC.SAFE)
     void setLocalDragState(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        // ---------- Original Method ----------
        //mLocalDragState = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.729 -0400", hash_original_method = "977584242F0720CC5E20503FC56D761D", hash_generated_method = "B6204B49753541B71EE25CC19EDBB884")
    @DSModeled(DSC.SAFE)
    private void handleDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            final int what;
            what = event.mAction;
            {
                mView.dispatchDragEvent(event);
            } //End block
            {
                {
                    mCurrentDragView = null;
                    mDragDescription = event.mClipDescription;
                } //End block
                {
                    event.mClipDescription = mDragDescription;
                } //End block
                {
                    mDragPoint.set(event.mX, event.mY);
                    {
                        mTranslator.translatePointInScreenToAppWindow(mDragPoint);
                    } //End block
                    {
                        mDragPoint.offset(0, mCurScrollY);
                    } //End block
                    event.mX = mDragPoint.x;
                    event.mY = mDragPoint.y;
                } //End block
                final View prevDragView;
                prevDragView = mCurrentDragView;
                boolean result;
                result = mView.dispatchDragEvent(event);
                {
                    try 
                    {
                        {
                            sWindowSession.dragRecipientExited(mWindow);
                        } //End block
                        {
                            sWindowSession.dragRecipientEntered(mWindow);
                        } //End block
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                {
                    mDragDescription = null;
                    try 
                    {
                        sWindowSession.reportDropResult(mWindow, result);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                {
                    setLocalDragState(null);
                } //End block
            } //End block
        } //End block
        event.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "504EE99E4FC1047B3EE4816C6C3CF55E", hash_generated_method = "39D306B6A8FBF89288683278F87E7CC0")
    @DSModeled(DSC.SAFE)
    public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo args) {
        dsTaint.addTaint(args.dsTaint);
        {
            mSeq = args.seq;
            mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();
        } //End block
        {
            {
                mAttachInfo.mSystemUiVisibility =
                        (mAttachInfo.mSystemUiVisibility&~args.localChanges)
                        | (args.localValue&args.localChanges);
            } //End block
            mView.updateLocalSystemUiVisibility(args.localValue, args.localChanges);
            mAttachInfo.mRecomputeGlobalAttributes = true;
            scheduleTraversals();
        } //End block
        mView.dispatchSystemUiVisibilityChanged(args.globalVisibility);
        // ---------- Original Method ----------
        //if (mSeq != args.seq) {
            //mSeq = args.seq;
            //mAttachInfo.mForceReportNewAttributes = true;
            //scheduleTraversals();            
        //}
        //if (mView == null) return;
        //if (args.localChanges != 0) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mSystemUiVisibility =
                        //(mAttachInfo.mSystemUiVisibility&~args.localChanges)
                        //| (args.localValue&args.localChanges);
            //}
            //mView.updateLocalSystemUiVisibility(args.localValue, args.localChanges);
            //mAttachInfo.mRecomputeGlobalAttributes = true;
            //scheduleTraversals();            
        //}
        //mView.dispatchSystemUiVisibilityChanged(args.globalVisibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "45F97324DFA9B47BC7B47DB7731173BB", hash_generated_method = "7322837A651CA8956A4E26F6B80A57BB")
    @DSModeled(DSC.SAFE)
    public void getLastTouchPoint(Point outLocation) {
        dsTaint.addTaint(outLocation.dsTaint);
        outLocation.x = (int) mLastTouchPoint.x;
        outLocation.y = (int) mLastTouchPoint.y;
        // ---------- Original Method ----------
        //outLocation.x = (int) mLastTouchPoint.x;
        //outLocation.y = (int) mLastTouchPoint.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "D8987F1AD41DCFCEC13505B3421C8BB0", hash_generated_method = "ADF4992383FD0BF804A2D6DCA81CA04F")
    @DSModeled(DSC.SAFE)
    public void setDragFocus(View newDragTarget) {
        dsTaint.addTaint(newDragTarget.dsTaint);
        // ---------- Original Method ----------
        //if (mCurrentDragView != newDragTarget) {
            //mCurrentDragView = newDragTarget;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "63BA605FA957D5097ED6886D9988BC53", hash_generated_method = "FEC845EBD439E00282F029330BFD5F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AudioManager getAudioManager() {
        {
            throw new IllegalStateException("getAudioManager called when there is no mView");
        } //End block
        {
            mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        } //End block
        return (AudioManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mView == null) {
            //throw new IllegalStateException("getAudioManager called when there is no mView");
        //}
        //if (mAudioManager == null) {
            //mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        //}
        //return mAudioManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "C22EE439EF1C63381F42BE80F34ED0C5", hash_generated_method = "A581349CB5278771D5ACF7B0EB1D8B3D")
    @DSModeled(DSC.SAFE)
    public AccessibilityInteractionController getAccessibilityInteractionController() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            throw new IllegalStateException("getAccessibilityInteractionController"
                    + " called when there is no mView");
        } //End block
        {
            mAccessibilityInteractionController = new AccessibilityInteractionController();
        } //End block
        return (AccessibilityInteractionController)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mView == null) {
            //throw new IllegalStateException("getAccessibilityInteractionController"
                    //+ " called when there is no mView");
        //}
        //if (mAccessibilityInteractionController == null) {
            //mAccessibilityInteractionController = new AccessibilityInteractionController();
        //}
        //return mAccessibilityInteractionController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.730 -0400", hash_original_method = "0B2FE2E2B393762D66EC0169ABC2799A", hash_generated_method = "12FC7762A32717A55B0A98926014F819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int relayoutWindow(WindowManager.LayoutParams params, int viewVisibility,
            boolean insetsPending) throws RemoteException {
        dsTaint.addTaint(insetsPending);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(viewVisibility);
        float appScale;
        appScale = mAttachInfo.mApplicationScale;
        boolean restore;
        restore = false;
        {
            restore = true;
            params.backup();
            mTranslator.translateWindowLayout(params);
        } //End block
        {
            Log.d(TAG, "WindowLayout in layoutWindow:" + params);
        } //End block
        mPendingConfiguration.seq = 0;
        {
            {
                params.type = mOrigWindowType;
            } //End block
        } //End block
        int relayoutResult;
        relayoutResult = sWindowSession.relayout(
                mWindow, mSeq, params,
                (int) (mView.getMeasuredWidth() * appScale + 0.5f),
                (int) (mView.getMeasuredHeight() * appScale + 0.5f),
                viewVisibility, insetsPending ? WindowManagerImpl.RELAYOUT_INSETS_PENDING : 0,
                mWinFrame, mPendingContentInsets, mPendingVisibleInsets,
                mPendingConfiguration, mSurface);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            params.restore();
        } //End block
        {
            mTranslator.translateRectInScreenToAppWinFrame(mWinFrame);
            mTranslator.translateRectInScreenToAppWindow(mPendingContentInsets);
            mTranslator.translateRectInScreenToAppWindow(mPendingVisibleInsets);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "15B8C68C65C02C1955DF774990289073", hash_generated_method = "AACF9456D5DF1A445D0C3837F657150F")
    @DSModeled(DSC.SAFE)
    public void playSoundEffect(int effectId) {
        dsTaint.addTaint(effectId);
        checkThread();
        try 
        {
            final AudioManager audioManager;
            audioManager = getAudioManager();
            //Begin case SoundEffectConstants.CLICK 
            audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);
            //End case SoundEffectConstants.CLICK 
            //Begin case SoundEffectConstants.NAVIGATION_DOWN 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_DOWN);
            //End case SoundEffectConstants.NAVIGATION_DOWN 
            //Begin case SoundEffectConstants.NAVIGATION_LEFT 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_LEFT);
            //End case SoundEffectConstants.NAVIGATION_LEFT 
            //Begin case SoundEffectConstants.NAVIGATION_RIGHT 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_RIGHT);
            //End case SoundEffectConstants.NAVIGATION_RIGHT 
            //Begin case SoundEffectConstants.NAVIGATION_UP 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_UP);
            //End case SoundEffectConstants.NAVIGATION_UP 
            //Begin case default 
            throw new IllegalArgumentException("unknown effect id " + effectId +
                            " not defined in " + SoundEffectConstants.class.getCanonicalName());
            //End case default 
        } //End block
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "B8D922B767BD06C4283BB3EF0BFA3172", hash_generated_method = "4B5585F32C2958307D036E1BEF3AF422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int effectId, boolean always) {
        dsTaint.addTaint(effectId);
        dsTaint.addTaint(always);
        try 
        {
            boolean varFBBA9023D273BC1BC4D4CED056000D00_1543563275 = (sWindowSession.performHapticFeedback(mWindow, effectId, always));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return sWindowSession.performHapticFeedback(mWindow, effectId, always);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "220A5158C443CFE1D4535C372C690545", hash_generated_method = "AEB83DFD867439DDA6E77598CC939BF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        checkThread();
        View varB98E74C6692446F9B2C9C3CE7AF3926B_1911974413 = (FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //if (!(mView instanceof ViewGroup)) {
            //return null;
        //}
        //return FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "5C67D040EE10672AA68B296434D2F63D", hash_generated_method = "92F43743AA30A45EA34991A74D1FB0CE")
    @DSModeled(DSC.SAFE)
    public void debug() {
        mView.debug();
        // ---------- Original Method ----------
        //mView.debug();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "818AD1A70B8E095131DC73E371E19514", hash_generated_method = "6186AB8DE655ED9A48AEB6EA22DE1FD7")
    @DSModeled(DSC.SAFE)
    public void dumpGfxInfo(PrintWriter pw, int[] info) {
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(info);
        {
            getGfxInfo(mView, info);
        } //End block
        {
            info[0] = info[1] = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mView != null) {
            //getGfxInfo(mView, info);
        //} else {
            //info[0] = info[1] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "CD86B0B9CE453C77251859969963B0E8", hash_generated_method = "ED6F2BB43B9A11A84B79F7E78AEAC500")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getGfxInfo(View view, int[] info) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(info);
        DisplayList displayList;
        displayList = view.mDisplayList;
        info[0]++;
        {
            info[1] += displayList.getSize();
        } //End block
        {
            ViewGroup group;
            group = (ViewGroup) view;
            int count;
            count = group.getChildCount();
            {
                int i;
                i = 0;
                {
                    getGfxInfo(group.getChildAt(i), info);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //DisplayList displayList = view.mDisplayList;
        //info[0]++;
        //if (displayList != null) {
            //info[1] += displayList.getSize();
        //}
        //if (view instanceof ViewGroup) {
            //ViewGroup group = (ViewGroup) view;
            //int count = group.getChildCount();
            //for (int i = 0; i < count; i++) {
                //getGfxInfo(group.getChildAt(i), info);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.731 -0400", hash_original_method = "F971131E8183B74AE14F7AE1993EB770", hash_generated_method = "46C86B257CDBE0EA02E6FE7301B9E6EA")
    @DSModeled(DSC.SAFE)
    public void die(boolean immediate) {
        dsTaint.addTaint(immediate);
        {
            doDie();
        } //End block
        {
            sendEmptyMessage(DIE);
        } //End block
        // ---------- Original Method ----------
        //if (immediate) {
            //doDie();
        //} else {
            //sendEmptyMessage(DIE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "8D1DF41E880ED97CD9EA450CBF8DEBA9", hash_generated_method = "7A9F21B8FE5E15CE78ED937DA994B18D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doDie() {
        checkThread();
        {
            {
                mAdded = false;
                dispatchDetachedFromWindow();
            } //End block
            {
                destroyHardwareRenderer();
                int viewVisibility;
                viewVisibility = mView.getVisibility();
                boolean viewVisibilityChanged;
                viewVisibilityChanged = mViewVisibility != viewVisibility;
                {
                    try 
                    {
                        {
                            boolean var9AE39921E95FF8EFBAECC8E0B3546A66_1457019261 = ((relayoutWindow(mWindowAttributes, viewVisibility, false)
                                & WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0);
                            {
                                sWindowSession.finishDrawing(mWindow);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                mSurface.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "C21E5BD1C0448C03922FA84C1B8F3673", hash_generated_method = "3D3CB273B4431811630D19181A14E9B1")
    @DSModeled(DSC.SAFE)
    public void requestUpdateConfiguration(Configuration config) {
        dsTaint.addTaint(config.dsTaint);
        Message msg;
        msg = obtainMessage(UPDATE_CONFIGURATION, config);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "83B5F7EEB6D7B3078A7769D15E86950B", hash_generated_method = "7B5906921C378606B5CF69F2CFC3EB91")
    @DSModeled(DSC.SAFE)
    private void destroyHardwareRenderer() {
        {
            mAttachInfo.mHardwareRenderer.destroy(true);
            mAttachInfo.mHardwareRenderer = null;
            mAttachInfo.mHardwareAccelerated = false;
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //mAttachInfo.mHardwareRenderer.destroy(true);
            //mAttachInfo.mHardwareRenderer = null;
            //mAttachInfo.mHardwareAccelerated = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "459EFA224EE61797FCF735DB24F377FF", hash_generated_method = "CDA24AC7C737D2BA653E34673E316ADB")
    @DSModeled(DSC.SAFE)
    public void dispatchFinishedEvent(int seq, boolean handled) {
        dsTaint.addTaint(seq);
        dsTaint.addTaint(handled);
        Message msg;
        msg = obtainMessage(FINISHED_EVENT);
        msg.arg1 = seq;
        msg.arg2 = handled ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FINISHED_EVENT);
        //msg.arg1 = seq;
        //msg.arg2 = handled ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "176F47B7EDC9D70A69736114EF5A25ED", hash_generated_method = "370BB6C06937115BD9B72516207373C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchResized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(visibleInsets.dsTaint);
        dsTaint.addTaint(reportDraw);
        dsTaint.addTaint(newConfig.dsTaint);
        dsTaint.addTaint(coveredInsets.dsTaint);
        dsTaint.addTaint(h);
        Message msg;
        msg = obtainMessage(reportDraw ? RESIZED_REPORT :RESIZED);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            mTranslator.translateRectInScreenToAppWindow(coveredInsets);
            mTranslator.translateRectInScreenToAppWindow(visibleInsets);
            w *= mTranslator.applicationInvertedScale;
            h *= mTranslator.applicationInvertedScale;
        } //End block
        msg.arg1 = w;
        msg.arg2 = h;
        ResizedInfo ri;
        ri = new ResizedInfo();
        ri.coveredInsets = new Rect(coveredInsets);
        ri.visibleInsets = new Rect(visibleInsets);
        ri.newConfig = newConfig;
        msg.obj = ri;
        sendMessage(msg);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.732 -0400", hash_original_method = "42F15B8B44D9B8805537AB8032035046", hash_generated_method = "55C6D736ECC65AB4DBFCE666AC7A208C")
    @DSModeled(DSC.SAFE)
    private void enqueueInputEvent(Message msg, long when) {
        dsTaint.addTaint(when);
        dsTaint.addTaint(msg.dsTaint);
        InputEventMessage inputMessage;
        inputMessage = InputEventMessage.obtain(msg);
        {
            mPendingInputEvents = inputMessage;
        } //End block
        {
            InputEventMessage currMessage;
            currMessage = mPendingInputEvents;
            {
                currMessage = currMessage.mNext;
            } //End block
            currMessage.mNext = inputMessage;
        } //End block
        sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
        // ---------- Original Method ----------
        //InputEventMessage inputMessage = InputEventMessage.obtain(msg);
        //if (mPendingInputEvents == null) {
            //mPendingInputEvents = inputMessage;
        //} else {
            //InputEventMessage currMessage = mPendingInputEvents;
            //while (currMessage.mNext != null) {
                //currMessage = currMessage.mNext;
            //}
            //currMessage.mNext = inputMessage;
        //}
        //sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "CF232D7D6B258A687467B35A15A72FA0", hash_generated_method = "62BE3E943B92AFCDD08C9777A41BCF6D")
    @DSModeled(DSC.SAFE)
    public void dispatchKey(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dispatchKey(event, false);
        // ---------- Original Method ----------
        //dispatchKey(event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "40FF3F3DF013E72EC5E96E0A49136BE3", hash_generated_method = "98B8E4F38B7CED14F39C73400DD6FF6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchKey(KeyEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            boolean var614B93C66D10470F75E816C5D006D92E_2113043867 = (false && event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    boolean var93BBE93F11B74C6BE1CA3CCD54D7C4DB_1360997306 = (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA);
                    {
                        Log.d("keydisp", "===================================================");
                        Log.d("keydisp", "Focused view Hierarchy is:");
                        debug();
                        Log.d("keydisp", "===================================================");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage(DISPATCH_KEY);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //if (false && event.getAction() == KeyEvent.ACTION_DOWN) {
            //if (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA) {
                //if (DBG) Log.d("keydisp", "===================================================");
                //if (DBG) Log.d("keydisp", "Focused view Hierarchy is:");
                //debug();
                //if (DBG) Log.d("keydisp", "===================================================");
            //}
        //}
        //Message msg = obtainMessage(DISPATCH_KEY);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //if (LOCAL_LOGV) Log.v(
            //TAG, "sending key " + event + " to " + mView);
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "F90A161CC4BD8998AC3B193B63EB7E53", hash_generated_method = "37178EB25F90C6F266BA0BCB32CAB3D9")
    @DSModeled(DSC.SAFE)
    private void dispatchMotion(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        int source;
        source = event.getSource();
        {
            dispatchPointer(event, sendDone);
        } //End block
        {
            dispatchTrackball(event, sendDone);
        } //End block
        {
            dispatchGenericMotion(event, sendDone);
        } //End block
        // ---------- Original Method ----------
        //int source = event.getSource();
        //if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            //dispatchPointer(event, sendDone);
        //} else if ((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
            //dispatchTrackball(event, sendDone);
        //} else {
            //dispatchGenericMotion(event, sendDone);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "DD56557FEAC8CACD87B056C5C0C702D1", hash_generated_method = "79109A7F4BAE1D6CDA36F44B58A766D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchPointer(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        Message msg;
        msg = obtainMessage(DISPATCH_POINTER);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_POINTER);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "CA2BFA17163311E1AAAA771C667E27EE", hash_generated_method = "826E768870E345F92F6ED392A4B1569D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchTrackball(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        Message msg;
        msg = obtainMessage(DISPATCH_TRACKBALL);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_TRACKBALL);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "BF71C2E204EC82729A1EA0969E06871A", hash_generated_method = "943CFFA855B14640CF0AF85A7E102AA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchGenericMotion(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        Message msg;
        msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.733 -0400", hash_original_method = "609DE6F7AC6918A6ED5E47157E290835", hash_generated_method = "4A21837032DE5947337A10C7B7F402C6")
    @DSModeled(DSC.SAFE)
    public void dispatchAppVisibility(boolean visible) {
        dsTaint.addTaint(visible);
        Message msg;
        msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        msg.arg1 = visible ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        //msg.arg1 = visible ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "4D3A3DC5DC743660725FA6A11A372A07", hash_generated_method = "251EACD52FE8F40AB09ECFFA4F82408D")
    @DSModeled(DSC.SAFE)
    public void dispatchGetNewSurface() {
        Message msg;
        msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "0CD487AEEAC72879653D2DB3DCCCEB86", hash_generated_method = "E01336B127E1DCBF21BC37D3548673F0")
    @DSModeled(DSC.SAFE)
    public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        dsTaint.addTaint(hasFocus);
        Message msg;
        msg = Message.obtain();
        msg.what = WINDOW_FOCUS_CHANGED;
        msg.arg1 = hasFocus ? 1 : 0;
        msg.arg2 = inTouchMode ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = WINDOW_FOCUS_CHANGED;
        //msg.arg1 = hasFocus ? 1 : 0;
        //msg.arg2 = inTouchMode ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "DCE84E54CF89AABF2B838105364C2821", hash_generated_method = "3D4841A6A8CA1A5E7EC2BEC021E6C57F")
    @DSModeled(DSC.SAFE)
    public void dispatchCloseSystemDialogs(String reason) {
        dsTaint.addTaint(reason);
        Message msg;
        msg = Message.obtain();
        msg.what = CLOSE_SYSTEM_DIALOGS;
        msg.obj = reason;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = CLOSE_SYSTEM_DIALOGS;
        //msg.obj = reason;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "786F6A89EC1BE66218A42841DB30F7AC", hash_generated_method = "A99C51EE4110A430278AB53829CF022B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        final int what;
        {
            boolean varB24B6A2E894360805412F219C1784FDD_978372104 = (event.getAction() == DragEvent.ACTION_DRAG_LOCATION);
            {
                what = DISPATCH_DRAG_LOCATION_EVENT;
                removeMessages(what);
            } //End block
            {
                what = DISPATCH_DRAG_EVENT;
            } //End block
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage(what, event);
        sendMessage(msg);
        // ---------- Original Method ----------
        //final int what;
        //if (event.getAction() == DragEvent.ACTION_DRAG_LOCATION) {
            //what = DISPATCH_DRAG_LOCATION_EVENT;
            //removeMessages(what);
        //} else {
            //what = DISPATCH_DRAG_EVENT;
        //}
        //Message msg = obtainMessage(what, event);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "95F6C6AC5462FA09198431CBF084B2BE", hash_generated_method = "8ACAA5170036C9D7144F6E9B09233AFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
            int localValue, int localChanges) {
        dsTaint.addTaint(localChanges);
        dsTaint.addTaint(localValue);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(globalVisibility);
        SystemUiVisibilityInfo args;
        args = new SystemUiVisibilityInfo();
        args.seq = seq;
        args.globalVisibility = globalVisibility;
        args.localValue = localValue;
        args.localChanges = localChanges;
        sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
        // ---------- Original Method ----------
        //SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        //args.seq = seq;
        //args.globalVisibility = globalVisibility;
        //args.localValue = localValue;
        //args.localChanges = localChanges;
        //sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "DE2DA8F2C91C4BAC5E71DE180C591B82", hash_generated_method = "4B351A518FF1F9C93B70B03E44BE5E88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendAccessibilityEvents() {
        {
            boolean var6B92FF47081CEAA2DFA035B3AA7C5808_136455917 = (!mAccessibilityManager.isEnabled());
        } //End collapsed parenthetic
        mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        View focusedView;
        focusedView = mView.findFocus();
        {
            focusedView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        } //End block
        // ---------- Original Method ----------
        //if (!mAccessibilityManager.isEnabled()) {
            //return;
        //}
        //mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        //View focusedView = mView.findFocus();
        //if (focusedView != null && focusedView != mView) {
            //focusedView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "3EBD42CE7AD44788B8B5975E509C0AD4", hash_generated_method = "78F3CB278F5A5CF4818230B7D4A8B1F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postSendWindowContentChangedCallback() {
        {
            mSendWindowContentChangedAccessibilityEvent =
                new SendWindowContentChangedAccessibilityEvent();
        } //End block
        {
            mSendWindowContentChangedAccessibilityEvent.mIsPending = true;
            postDelayed(mSendWindowContentChangedAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent == null) {
            //mSendWindowContentChangedAccessibilityEvent =
                //new SendWindowContentChangedAccessibilityEvent();
        //}
        //if (!mSendWindowContentChangedAccessibilityEvent.mIsPending) {
            //mSendWindowContentChangedAccessibilityEvent.mIsPending = true;
            //postDelayed(mSendWindowContentChangedAccessibilityEvent,
                    //ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.734 -0400", hash_original_method = "B38BF7B18A0D0C0D14C2E79D97568CE9", hash_generated_method = "63DC9D639ED66767D495CD94052EDFFD")
    @DSModeled(DSC.SAFE)
    private void removeSendWindowContentChangedCallback() {
        {
            removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent != null) {
            //removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "3A017950A97502A630256434B0EBF7E8", hash_generated_method = "35C4012DDEF9F75623E9B22FAD8551DA")
    @DSModeled(DSC.SAFE)
    public boolean showContextMenuForChild(View originalView) {
        dsTaint.addTaint(originalView.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "492AE6A9C9C6F2F7E659E19901E3E487", hash_generated_method = "46B01A7390BF41B89D59F6F45B9FD949")
    @DSModeled(DSC.SAFE)
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(originalView.dsTaint);
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "FB735C9133B887C07751FC797F168B65", hash_generated_method = "7880BC72ACDEBD9148E0097F362E51E1")
    @DSModeled(DSC.SAFE)
    public void createContextMenu(ContextMenu menu) {
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "C40FC95C25B6655ACCA9227D471DC892", hash_generated_method = "5FE5B3A754E53EAF5CC74939FF8F929D")
    @DSModeled(DSC.SAFE)
    public void childDrawableStateChanged(View child) {
        dsTaint.addTaint(child.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "975E17A58706A43B9CF06D84428C706E", hash_generated_method = "A7A6B9A94DBD0E4E9921D74130DD75F7")
    @DSModeled(DSC.SAFE)
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        mAccessibilityManager.sendAccessibilityEvent(event);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mView == null) {
            //return false;
        //}
        //mAccessibilityManager.sendAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "C963D9A99CD7BE986B275021EA99CB95", hash_generated_method = "15E1A87ED5308097A886DDB332A35739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkThread() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_2117286118 = (mThread != Thread.currentThread());
            {
                throw new CalledFromWrongThreadException(
                    "Only the original thread that created a view hierarchy can touch its views.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //throw new CalledFromWrongThreadException(
                    //"Only the original thread that created a view hierarchy can touch its views.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "F9834E22E1AF22274F19B27CD50E21E5", hash_generated_method = "B173C9153F6704229CA2115E30DF51A9")
    @DSModeled(DSC.SAFE)
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        dsTaint.addTaint(disallowIntercept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "176476ED7A31EA7594378C530DAA6036", hash_generated_method = "E832B75AA53EAADCC7BD8E61837A1824")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(rectangle.dsTaint);
        dsTaint.addTaint(immediate);
        boolean var01DB072A3F092F21B9D32C2DD4D3AD8E_472570150 = (scrollToRectOrFocus(rectangle, immediate));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollToRectOrFocus(rectangle, immediate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "0956BAC4E651A6EA7D6D5241504B2332", hash_generated_method = "83B934B4D7332837C02CA90AC2A39A1E")
    static RunQueue getRunQueue() {
        RunQueue rq = sRunQueues.get();
        if (rq != null) {
            return rq;
        }
        rq = new RunQueue();
        sRunQueues.set(rq);
        return rq;
    }

    
    class ResizedInfo {
        Rect coveredInsets;
        Rect visibleInsets;
        Configuration newConfig;
        
    }


    
    static final class SystemUiVisibilityInfo {
        int seq;
        int globalVisibility;
        int localValue;
        int localChanges;
        
    }


    
    static class InputEventMessage {
        Message mMessage;
        InputEventMessage mNext;
        private static final Object sPoolSync = new Object();
        private static InputEventMessage sPool;
        private static int sPoolSize = 0;
        private static final int MAX_POOL_SIZE = 10;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "B714885B0648B0EB69373E467D5A2ACF", hash_generated_method = "F4009A077F625E9C845346EE3B31DA0E")
        @DSModeled(DSC.SAFE)
        private InputEventMessage(Message m) {
            dsTaint.addTaint(m.dsTaint);
            mNext = null;
            // ---------- Original Method ----------
            //mMessage = m;
            //mNext = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "00E59ACDF972C6E7146BB1869D625C11", hash_generated_method = "AECBD11D2AF29C6DBB0AB5F019CE58D8")
        public static InputEventMessage obtain(Message msg) {
            synchronized (sPoolSync) {
                if (sPool != null) {
                    InputEventMessage m = sPool;
                    sPool = m.mNext;
                    m.mNext = null;
                    sPoolSize--;
                    m.mMessage = msg;
                    return m;
                }
            }
            return new InputEventMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.735 -0400", hash_original_method = "9F2D00AD0B3B7E97E6983E3E4DE01E8D", hash_generated_method = "7A4DC75C47A4DAF880A3D22AD9F60A24")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            mMessage.recycle();
            {
                {
                    mNext = sPool;
                    sPool = this;
                    sPoolSize++;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //mMessage.recycle();
            //synchronized (sPoolSync) {
                //if (sPoolSize < MAX_POOL_SIZE) {
                    //mNext = sPool;
                    //sPool = this;
                    //sPoolSize++;
                //}
            //}
        }

        
    }


    
    class TakenSurfaceHolder extends BaseSurfaceHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "93900AD5EB4A5A0D65615E175C2FC0CA", hash_generated_method = "892CD3558EEA1287C857F54A4C5E1D04")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean onAllowLockCanvas() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDrawingAllowed;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "CAFD67152D224915C2628F6ACAAF5E06", hash_generated_method = "9506BF21C5889E1CBA11EA0E3E64D826")
        @DSModeled(DSC.SAFE)
        @Override
        public void onRelayoutContainer() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "E07C2927AF02C0614ECCFDEAF72047C2", hash_generated_method = "75446937CE3F32559B584EFE02673EC4")
        @DSModeled(DSC.SAFE)
        public void setFormat(int format) {
            dsTaint.addTaint(format);
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "EE34E0B82BE2B114D60991753727E9A6", hash_generated_method = "DB085427C20E38E3B03ACE00E7DF953A")
        @DSModeled(DSC.SAFE)
        public void setType(int type) {
            dsTaint.addTaint(type);
            ((RootViewSurfaceTaker)mView).setSurfaceType(type);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceType(type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "65C8D4CF87AA6164C88CB73B7231A722", hash_generated_method = "94F6FC3AB3CABD3711A5E0A288A4F7CC")
        @DSModeled(DSC.SAFE)
        @Override
        public void onUpdateSurface() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            throw new IllegalStateException("Shouldn't be here");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Shouldn't be here");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "27BBBC85A8A87FE2AF07228E5D29CDAA")
        @DSModeled(DSC.SAFE)
        public boolean isCreating() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsCreating;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "DFAAE278D74727ACF1AA5508094F804D", hash_generated_method = "913893A3D808EDD1A9163574D3BEE4FC")
        @DSModeled(DSC.SAFE)
        @Override
        public void setFixedSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            throw new UnsupportedOperationException(
                    "Currently only support sizing from layout");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException(
                    //"Currently only support sizing from layout");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "21F6CF6D8B53BD856057ED05ABC33177", hash_generated_method = "A6054BB21ACB7607228EEA6F46A3AD40")
        @DSModeled(DSC.SAFE)
        public void setKeepScreenOn(boolean screenOn) {
            dsTaint.addTaint(screenOn);
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
        }

        
    }


    
    static class InputMethodCallback extends IInputMethodCallback.Stub {
        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "54191F901FEF749694D67ED7BF80E958", hash_generated_method = "DD22DFE8DC6894786E12B0E43266E6F9")
        @DSModeled(DSC.SAFE)
        public InputMethodCallback(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "BE17249E230FCA094C5B0C5E3A1F0AA4", hash_generated_method = "A6605444BAE2D3980512FEBA7781640C")
        @DSModeled(DSC.SAFE)
        public void finishedEvent(int seq, boolean handled) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(handled);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchFinishedEvent(seq, handled);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchFinishedEvent(seq, handled);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "93549AC7AA704598E881A2A0D800AB4C", hash_generated_method = "8E30B56DC625772B40EF37FDFF605DE7")
        @DSModeled(DSC.SAFE)
        public void sessionCreated(IInputMethodSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    static class W extends IWindow.Stub {
        private final WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.736 -0400", hash_original_method = "D1CF0E60435976F2AA38BD5BC7DA8E27", hash_generated_method = "20E67A2F8BB6DF81C623CAD9AD7E6F13")
        @DSModeled(DSC.SAFE)
         W(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "A648B76CE506B7CD274906DE238C17D8", hash_generated_method = "92C2475D117B64EF4DB22AEA0975B184")
        @DSModeled(DSC.SAFE)
        public void resized(int w, int h, Rect coveredInsets, Rect visibleInsets,
                boolean reportDraw, Configuration newConfig) {
            dsTaint.addTaint(w);
            dsTaint.addTaint(visibleInsets.dsTaint);
            dsTaint.addTaint(reportDraw);
            dsTaint.addTaint(newConfig.dsTaint);
            dsTaint.addTaint(coveredInsets.dsTaint);
            dsTaint.addTaint(h);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        newConfig);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        //newConfig);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "EB98E21C67C8D9A44F58CD671F491CDA", hash_generated_method = "69725710E59BBA15657E6BC646478ACB")
        @DSModeled(DSC.SAFE)
        public void dispatchAppVisibility(boolean visible) {
            dsTaint.addTaint(visible);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchAppVisibility(visible);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchAppVisibility(visible);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "5CE742A9FFA814199F790759E49D980E", hash_generated_method = "6A6910D5C2D24F997A92365082384023")
        @DSModeled(DSC.SAFE)
        public void dispatchGetNewSurface() {
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchGetNewSurface();
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchGetNewSurface();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "294D771D49852BEC83940B0D8623D316", hash_generated_method = "853A20E0EA7D0E4CF1B273F167C36360")
        @DSModeled(DSC.SAFE)
        public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
            dsTaint.addTaint(inTouchMode);
            dsTaint.addTaint(hasFocus);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "0F834A9D69D3D9A8D8102CFC29F0EF8E", hash_generated_method = "07BF2095C8AB8714CC7FFC034E0187CF")
        private static int checkCallingPermission(String permission) {
            try {
                return ActivityManagerNative.getDefault().checkPermission(
                        permission, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e) {
                return PackageManager.PERMISSION_DENIED;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "BAC64B61AF453BEA5AB28D214B8FF7C5", hash_generated_method = "34CEA6E7BB1A9B90CC7F38AA16343CFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            dsTaint.addTaint(command);
            dsTaint.addTaint(parameters);
            dsTaint.addTaint(out.dsTaint);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                final View view;
                view = viewAncestor.mView;
                {
                    {
                        boolean varD985B2C74752F819AC5BC1C5B2498154_163974553 = (checkCallingPermission(Manifest.permission.DUMP) !=
                            PackageManager.PERMISSION_GRANTED);
                        {
                            throw new SecurityException("Insufficient permissions to invoke"
                                + " executeCommand() from pid=" + Binder.getCallingPid()
                                + ", uid=" + Binder.getCallingUid());
                        } //End block
                    } //End collapsed parenthetic
                    OutputStream clientStream;
                    clientStream = null;
                    try 
                    {
                        clientStream = new ParcelFileDescriptor.AutoCloseOutputStream(out);
                        ViewDebug.dispatchCommand(view, command, parameters, clientStream);
                    } //End block
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    } //End block
                    finally 
                    {
                        {
                            try 
                            {
                                clientStream.close();
                            } //End block
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "0341134904B032AC1241DC2205E79E01", hash_generated_method = "DE0747FC95620FA238DCB94CE30B9A85")
        @DSModeled(DSC.SAFE)
        public void closeSystemDialogs(String reason) {
            dsTaint.addTaint(reason);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchCloseSystemDialogs(reason);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchCloseSystemDialogs(reason);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.737 -0400", hash_original_method = "0D1309853D34ED0E4A19A33B54F85778", hash_generated_method = "4E4B3E163CD5D356734B8BA5DCE31ADB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep,
                boolean sync) {
            dsTaint.addTaint(sync);
            dsTaint.addTaint(xStep);
            dsTaint.addTaint(y);
            dsTaint.addTaint(yStep);
            dsTaint.addTaint(x);
            {
                try 
                {
                    sWindowSession.wallpaperOffsetsComplete(asBinder());
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperOffsetsComplete(asBinder());
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.738 -0400", hash_original_method = "084CB00632E8F4F79253F4CBB0703969", hash_generated_method = "A42DFB33031FBB55451DC2AE75C2D4A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchWallpaperCommand(String action, int x, int y,
                int z, Bundle extras, boolean sync) {
            dsTaint.addTaint(sync);
            dsTaint.addTaint(action);
            dsTaint.addTaint(z);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            dsTaint.addTaint(extras.dsTaint);
            {
                try 
                {
                    sWindowSession.wallpaperCommandComplete(asBinder(), null);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperCommandComplete(asBinder(), null);
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.738 -0400", hash_original_method = "AE33DC8C57E72B3B1EEF7B37E6DC4CB6", hash_generated_method = "F918647123D533316C251C73892304AB")
        @DSModeled(DSC.SAFE)
        public void dispatchDragEvent(DragEvent event) {
            dsTaint.addTaint(event.dsTaint);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchDragEvent(event);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchDragEvent(event);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.738 -0400", hash_original_method = "0BC30404A661769E03F23017D2DE8196", hash_generated_method = "98E7FA041B751EA3A06E2E7BE1C91DEA")
        @DSModeled(DSC.SAFE)
        public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
                int localValue, int localChanges) {
            dsTaint.addTaint(localChanges);
            dsTaint.addTaint(localValue);
            dsTaint.addTaint(seq);
            dsTaint.addTaint(globalVisibility);
            final ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        localValue, localChanges);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        //localValue, localChanges);
            //}
        }

        
    }


    
    static final class TrackballAxis {
        static final float MAX_ACCELERATION = 20;
        static final long FAST_MOVE_TIME = 150;
        static final float ACCEL_MOVE_SCALING_FACTOR = (1.0f/40);
        float position;
        float absPosition;
        float acceleration = 1;
        long lastMoveTime = 0;
        int step;
        int dir;
        int nonAccelMovement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.738 -0400", hash_original_method = "A6304CADA1EF057D91BA6FF70064FCCC", hash_generated_method = "7FE833C46C82A93DD5596776F5ED1F44")
        @DSModeled(DSC.SAFE)
         void reset(int _step) {
            dsTaint.addTaint(_step);
            position = 0;
            acceleration = 1;
            lastMoveTime = 0;
            dir = 0;
            // ---------- Original Method ----------
            //position = 0;
            //acceleration = 1;
            //lastMoveTime = 0;
            //step = _step;
            //dir = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.738 -0400", hash_original_method = "7BE12B55CFE54AFD4A89AB866136213C", hash_generated_method = "36387CD1C338CF6223C7B143ED5D672B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         float collect(float off, long time, String axis) {
            dsTaint.addTaint(axis);
            dsTaint.addTaint(time);
            dsTaint.addTaint(off);
            long normTime;
            {
                normTime = (long)(off * FAST_MOVE_TIME);
                {
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = 1;
            } //End block
            {
                normTime = (long)((-off) * FAST_MOVE_TIME);
                {
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = -1;
            } //End block
            {
                normTime = 0;
            } //End block
            {
                long delta;
                delta = time - lastMoveTime;
                float acc;
                acc = acceleration;
                {
                    float scale;
                    scale = (normTime-delta) * ACCEL_MOVE_SCALING_FACTOR;
                    acc *= scale;
                    acceleration = acc < MAX_ACCELERATION ? acc : MAX_ACCELERATION;
                } //End block
                {
                    float scale;
                    scale = (delta-normTime) * ACCEL_MOVE_SCALING_FACTOR;
                    acc /= scale;
                    acceleration = acc > 1 ? acc : 1;
                } //End block
            } //End block
            float var529C98EBF363E511405F79C0EF23EDF4_1262648563 = ((absPosition = Math.abs(position)));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "94A3484B43A305FA2D2533E09119590B", hash_generated_method = "2A15645BCB0798C2F806B309C0FE26CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int generate(float precision) {
            dsTaint.addTaint(precision);
            int movement;
            movement = 0;
            nonAccelMovement = 0;
            {
                final int dir;
                dir = 1;
                dir = -1;
                //Begin case 0 
                movement += dir;
                //End case 0 
                //Begin case 0 
                nonAccelMovement += dir;
                //End case 0 
                //Begin case 0 
                step = 1;
                //End case 0 
                //Begin case 1 
                movement += dir;
                //End case 1 
                //Begin case 1 
                nonAccelMovement += dir;
                //End case 1 
                //Begin case 1 
                position += dir > 0 ? -2 : 2;
                //End case 1 
                //Begin case 1 
                absPosition = Math.abs(position);
                //End case 1 
                //Begin case 1 
                step = 2;
                //End case 1 
                //Begin case default 
                movement += dir;
                //End case default 
                //Begin case default 
                position += dir >= 0 ? -1 : 1;
                //End case default 
                //Begin case default 
                absPosition = Math.abs(position);
                //End case default 
                //Begin case default 
                float acc;
                acc = acceleration;
                //End case default 
                //Begin case default 
                acc *= 1.1f;
                //End case default 
                //Begin case default 
                acceleration = acc < MAX_ACCELERATION ? acc : acceleration;
                //End case default 
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "D704015D17B148E0274888D3BE6B5A1B", hash_generated_method = "D60F725A39769FB1482F881C070EA499")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CalledFromWrongThreadException(String msg) {
            super(msg);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    static final class RunQueue {
        private final ArrayList<HandlerAction> mActions = new ArrayList<HandlerAction>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "D30AD5886AAB6A1562A9D91A9C03E0DF", hash_generated_method = "EAAE204B3C4FA73D80568CA37BA84261")
        @DSModeled(DSC.SAFE)
         void post(Runnable action) {
            dsTaint.addTaint(action.dsTaint);
            postDelayed(action, 0);
            // ---------- Original Method ----------
            //postDelayed(action, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "37D90AC712BBF73BCC19C8079034F8F1", hash_generated_method = "BD8D60A554CA2A4964B8AF5F7BE86268")
        @DSModeled(DSC.SAFE)
         void postDelayed(Runnable action, long delayMillis) {
            dsTaint.addTaint(delayMillis);
            dsTaint.addTaint(action.dsTaint);
            HandlerAction handlerAction;
            handlerAction = new HandlerAction();
            handlerAction.action = action;
            handlerAction.delay = delayMillis;
            {
                mActions.add(handlerAction);
            } //End block
            // ---------- Original Method ----------
            //HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //handlerAction.delay = delayMillis;
            //synchronized (mActions) {
                //mActions.add(handlerAction);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "5BA3715297222A78241D425B9BCC6DE7", hash_generated_method = "8D9FEAE6C0B37876D79022603EBB9311")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void removeCallbacks(Runnable action) {
            dsTaint.addTaint(action.dsTaint);
            final HandlerAction handlerAction;
            handlerAction = new HandlerAction();
            handlerAction.action = action;
            {
                final ArrayList<HandlerAction> actions;
                actions = mActions;
                {
                    boolean var36C1E9EF466D02D50DB2A2AD92DBF5C4_124437479 = (actions.remove(handlerAction));
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //final HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //synchronized (mActions) {
                //final ArrayList<HandlerAction> actions = mActions;
                //while (actions.remove(handlerAction)) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "3626F7B757A14315643B29FE9818088B", hash_generated_method = "BB5E75B323799BD1EFBE62CC6F0A853E")
        @DSModeled(DSC.SAFE)
         void executeActions(Handler handler) {
            dsTaint.addTaint(handler.dsTaint);
            {
                final ArrayList<HandlerAction> actions;
                actions = mActions;
                final int count;
                count = actions.size();
                {
                    int i;
                    i = 0;
                    {
                        final HandlerAction handlerAction;
                        handlerAction = actions.get(i);
                        handler.postDelayed(handlerAction.action, handlerAction.delay);
                    } //End block
                } //End collapsed parenthetic
                actions.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mActions) {
                //final ArrayList<HandlerAction> actions = mActions;
                //final int count = actions.size();
                //for (int i = 0; i < count; i++) {
                    //final HandlerAction handlerAction = actions.get(i);
                    //handler.postDelayed(handlerAction.action, handlerAction.delay);
                //}
                //actions.clear();
            //}
        }

        
        private static class HandlerAction {
            Runnable action;
            long delay;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.739 -0400", hash_original_method = "EC304D8CC82834BC90F0FBE66AB5A5B9", hash_generated_method = "6BF9ABFFF3097B652F5702BB49731E29")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object o) {
                dsTaint.addTaint(o.dsTaint);
                {
                    boolean var282528ACEB1CC10074B7BD702EFB8F50_691229070 = (o == null || getClass() != o.getClass());
                } //End collapsed parenthetic
                HandlerAction that;
                that = (HandlerAction) o;
                boolean varB89771406AB9E6A784E553026517A2DD_1221652644 = (!(action != null ? !action.equals(that.action) : that.action != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (this == o) return true;
                //if (o == null || getClass() != o.getClass()) return false;
                //HandlerAction that = (HandlerAction) o;
                //return !(action != null ? !action.equals(that.action) : that.action != null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "09AD30FBB7C8AE284E2A2DAD39966BF7", hash_generated_method = "0ED6325336D8DA04898F5AC589DF7924")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int hashCode() {
                int result;
                result = action.hashCode();
                result = 0;
                result = 31 * result + (int) (delay ^ (delay >>> 32));
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //int result = action != null ? action.hashCode() : 0;
                //result = 31 * result + (int) (delay ^ (delay >>> 32));
                //return result;
            }

            
        }


        
    }


    
    final class AccessibilityInteractionConnectionManager implements AccessibilityStateChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "8A20E0BF76F2FE3CB2E135C12DE9692E", hash_generated_method = "3662A25F59AC8AA4EE537F45A40D3AED")
        @DSModeled(DSC.SAFE)
        public void onAccessibilityStateChanged(boolean enabled) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(enabled);
            {
                ensureConnection();
            } //End block
            {
                ensureNoConnection();
            } //End block
            // ---------- Original Method ----------
            //if (enabled) {
                //ensureConnection();
            //} else {
                //ensureNoConnection();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "92A9A6CA8F5EA055DBA3D736397E37E0", hash_generated_method = "3362632EF5F27AFF9ACCB54F738E16F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void ensureConnection() {
            final boolean registered;
            registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            {
                mAttachInfo.mAccessibilityWindowId =
                    mAccessibilityManager.addAccessibilityInteractionConnection(mWindow,
                            new AccessibilityInteractionConnection(ViewRootImpl.this));
            } //End block
            // ---------- Original Method ----------
            //final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            //if (!registered) {
                //mAttachInfo.mAccessibilityWindowId =
                    //mAccessibilityManager.addAccessibilityInteractionConnection(mWindow,
                            //new AccessibilityInteractionConnection(ViewRootImpl.this));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "C22E99B1A3881672FEB45F6BE843B278", hash_generated_method = "39A4935A0986E0F7E1C5D86D9006EEE1")
        @DSModeled(DSC.SAFE)
        public void ensureNoConnection() {
            final boolean registered;
            registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            {
                mAttachInfo.mAccessibilityWindowId = View.NO_ID;
                mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            } //End block
            // ---------- Original Method ----------
            //final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            //if (registered) {
                //mAttachInfo.mAccessibilityWindowId = View.NO_ID;
                //mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            //}
        }

        
    }


    
    static final class AccessibilityInteractionConnection extends IAccessibilityInteractionConnection.Stub {
        private final WeakReference<ViewRootImpl> mRootImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "D539A7CCB822AF3CDF20BB7941121D94", hash_generated_method = "2B0C4B11628FB5990C0438CEAA6259CF")
        @DSModeled(DSC.SAFE)
         AccessibilityInteractionConnection(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "EE5D719A51240BF55D02CDA16E5D3A9D", hash_generated_method = "7D458BA1258101D4407F6EBAE8DCF067")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            ViewRootImpl viewRootImpl;
            viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        //interactionId, callback, interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "150D2C0671760B2C49B4A2BEA648BFF0", hash_generated_method = "A969940F5749737CF92BF24392414A8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void performAccessibilityAction(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(action);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interogatingPid);
            dsTaint.addTaint(interrogatingTid);
            ViewRootImpl viewRootImpl;
            viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            callback, interogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            //callback, interogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.740 -0400", hash_original_method = "480C93EC256597CABC1B248D841B9A3E", hash_generated_method = "8168E2E6FF43296B24527C230CA90473")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByViewId(int viewId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            dsTaint.addTaint(viewId);
            ViewRootImpl viewRootImpl;
            viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            //interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.741 -0400", hash_original_method = "9891EE3B36B5E5E829B36E62164827F4", hash_generated_method = "E05D57319E8BDC663744318E8D7E0AC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfosByViewText(String text, int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(text);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            ViewRootImpl viewRootImpl;
            viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            //interactionId, callback, interrogatingPid, interrogatingTid);
            //}
        }

        
    }


    
    final class AccessibilityInteractionController {
        private static final int POOL_SIZE = 5;
        private ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList =
            new ArrayList<AccessibilityNodeInfo>();
        private final Pool<SomeArgs> mPool = Pools.synchronizedPool(Pools.finitePool(
                new PoolableManager<SomeArgs>() {
                    public SomeArgs newInstance() {
                        return new SomeArgs();
                    }

                    public void onAcquired(SomeArgs info) {
                        
                    }

                    public void onReleased(SomeArgs info) {
                        info.clear();
                    }
                }, POOL_SIZE)
        );
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.741 -0400", hash_original_method = "2F6D3BCB232629523E59C738D4AD3A95", hash_generated_method = "DFC308693DF5D4E685B90AC1FCA9BA73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByAccessibilityIdClientThread(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            Message message;
            message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            message.arg1 = accessibilityId;
            message.arg2 = interactionId;
            message.obj = callback;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_1334548012 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            //message.arg1 = accessibilityId;
            //message.arg2 = interactionId;
            //message.obj = callback;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.741 -0400", hash_original_method = "145D07D178B3372CAAF2CB93D024125F", hash_generated_method = "5ADFB23694C1FE1365A8480F6E2E84A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            final int accessibilityId;
            accessibilityId = message.arg1;
            final int interactionId;
            interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback;
            callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info;
            info = null;
            try 
            {
                View target;
                target = findViewByAccessibilityId(accessibilityId);
                {
                    info = target.createAccessibilityNodeInfo();
                } //End block
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            // ---------- Original Method ----------
            //final int accessibilityId = message.arg1;
            //final int interactionId = message.arg2;
            //final IAccessibilityInteractionConnectionCallback callback =
                //(IAccessibilityInteractionConnectionCallback) message.obj;
            //AccessibilityNodeInfo info = null;
            //try {
                //View target = findViewByAccessibilityId(accessibilityId);
                //if (target != null) {
                    //info = target.createAccessibilityNodeInfo();
                //}
            //} finally {
                //try {
                    //callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                //} catch (RemoteException re) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.741 -0400", hash_original_method = "ADA0B35A4DB3EC9F459DCBB8D66C434D", hash_generated_method = "8E7D12F9472C3E33FA8189A7CA09519D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByViewIdClientThread(int viewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            dsTaint.addTaint(viewId);
            Message message;
            message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            message.arg1 = viewId;
            message.arg2 = interactionId;
            message.obj = callback;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_539359421 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            //message.arg1 = viewId;
            //message.arg2 = interactionId;
            //message.obj = callback;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.742 -0400", hash_original_method = "6B2A3077FB5BC3E815A1727E6C950B5E", hash_generated_method = "6FACE77ED74919EFAC42FD141B5E8251")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            final int viewId;
            viewId = message.arg1;
            final int interactionId;
            interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback;
            callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info;
            info = null;
            try 
            {
                View root;
                root = ViewRootImpl.this.mView;
                View target;
                target = root.findViewById(viewId);
                {
                    boolean varAD6C034A8B4788EA6598018C4A7CCA13_729605953 = (target != null && target.getVisibility() == View.VISIBLE);
                    {
                        info = target.createAccessibilityNodeInfo();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            // ---------- Original Method ----------
            //final int viewId = message.arg1;
            //final int interactionId = message.arg2;
            //final IAccessibilityInteractionConnectionCallback callback =
                //(IAccessibilityInteractionConnectionCallback) message.obj;
            //AccessibilityNodeInfo info = null;
            //try {
                //View root = ViewRootImpl.this.mView;
                //View target = root.findViewById(viewId);
                //if (target != null && target.getVisibility() == View.VISIBLE) {
                    //info = target.createAccessibilityNodeInfo();
                //}
            //} finally {
                //try {
                    //callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                //} catch (RemoteException re) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.742 -0400", hash_original_method = "74A990105163D5D10216C3B475062D28", hash_generated_method = "3A59D746373D5144247BC939104DDE02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfosByViewTextClientThread(String text,
                int accessibilityViewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(accessibilityViewId);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(interrogatingTid);
            Message message;
            message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            SomeArgs args;
            args = mPool.acquire();
            args.arg1 = text;
            args.argi1 = accessibilityViewId;
            args.argi2 = interactionId;
            args.arg2 = callback;
            message.obj = args;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_214432480 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            //SomeArgs args = mPool.acquire();
            //args.arg1 = text;
            //args.argi1 = accessibilityViewId;
            //args.argi2 = interactionId;
            //args.arg2 = callback;
            //message.obj = args;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.742 -0400", hash_original_method = "51BC2DACC971DA52CB7F7912294499A7", hash_generated_method = "8230CD71498E9A67F435F4C4EB95234E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfosByViewTextUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            SomeArgs args;
            args = (SomeArgs) message.obj;
            final String text;
            text = (String) args.arg1;
            final int accessibilityViewId;
            accessibilityViewId = args.argi1;
            final int interactionId;
            interactionId = args.argi2;
            final IAccessibilityInteractionConnectionCallback callback;
            callback = (IAccessibilityInteractionConnectionCallback) args.arg2;
            mPool.release(args);
            List<AccessibilityNodeInfo> infos;
            infos = null;
            try 
            {
                ArrayList<View> foundViews;
                foundViews = mAttachInfo.mFocusablesTempList;
                foundViews.clear();
                View root;
                root = null;
                {
                    root = findViewByAccessibilityId(accessibilityViewId);
                } //End block
                {
                    root = ViewRootImpl.this.mView;
                } //End block
                {
                    boolean var9C0D384BF3EBA7F37FDD9A142533A8EE_1431803784 = (root == null || root.getVisibility() != View.VISIBLE);
                } //End collapsed parenthetic
                root.findViewsWithText(foundViews, text, View.FIND_VIEWS_WITH_TEXT
                        | View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                {
                    boolean var8A7BFE1EB8C1A34CA2C8E115CC06AAA3_2065521062 = (foundViews.isEmpty());
                } //End collapsed parenthetic
                infos = mTempAccessibilityNodeInfoList;
                infos.clear();
                final int viewCount;
                viewCount = foundViews.size();
                {
                    int i;
                    i = 0;
                    {
                        View foundView;
                        foundView = foundViews.get(i);
                        {
                            boolean var8598062468ACAD090E81AB592F4F32E5_1654034054 = (foundView.getVisibility() == View.VISIBLE);
                            {
                                infos.add(foundView.createAccessibilityNodeInfo());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfosResult(infos, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.743 -0400", hash_original_method = "10A09FD4DC34F1BE42EB309D47EC9715", hash_generated_method = "50BF5458F8056CBF66388EF56726A1BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void performAccessibilityActionClientThread(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(action);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interogatingPid);
            dsTaint.addTaint(interrogatingTid);
            Message message;
            message = Message.obtain();
            message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            SomeArgs args;
            args = mPool.acquire();
            args.argi1 = accessibilityId;
            args.argi2 = action;
            args.argi3 = interactionId;
            args.arg1 = callback;
            message.obj = args;
            {
                boolean varBA474D4A1DE421276FA94C5F81C7FD11_932100398 = (interogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            //SomeArgs args = mPool.acquire();
            //args.argi1 = accessibilityId;
            //args.argi2 = action;
            //args.argi3 = interactionId;
            //args.arg1 = callback;
            //message.obj = args;
            //if (interogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.743 -0400", hash_original_method = "B5557005BEFFE1DA9F706439FD376D18", hash_generated_method = "35FD5F442BB505007CBD42FED3434507")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void perfromAccessibilityActionUiThread(Message message) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(message.dsTaint);
            SomeArgs args;
            args = (SomeArgs) message.obj;
            final int accessibilityId;
            accessibilityId = args.argi1;
            final int action;
            action = args.argi2;
            final int interactionId;
            interactionId = args.argi3;
            final IAccessibilityInteractionConnectionCallback callback;
            callback = (IAccessibilityInteractionConnectionCallback) args.arg1;
            mPool.release(args);
            boolean succeeded;
            succeeded = false;
            try 
            {
                //Begin case AccessibilityNodeInfo.ACTION_FOCUS 
                {
                    succeeded = performActionFocus(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_FOCUS 
                //Begin case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS 
                {
                    succeeded = performActionClearFocus(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS 
                //Begin case AccessibilityNodeInfo.ACTION_SELECT 
                {
                    succeeded = performActionSelect(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_SELECT 
                //Begin case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION 
                {
                    succeeded = performActionClearSelection(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION 
            } //End block
            finally 
            {
                try 
                {
                    callback.setPerformAccessibilityActionResult(succeeded, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.743 -0400", hash_original_method = "0DF709A77C91001270CD6D5BCBC66D0E", hash_generated_method = "A39CDEEA869FCA68AB7E0CAA3C7C939B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionFocus(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_310979095 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            ensureTouchMode(false);
            boolean var0F57617D4E8F9359CC9AD7E4CA12AF24_1725067985 = (target.requestFocus());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //ensureTouchMode(false);
            //return target.requestFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.743 -0400", hash_original_method = "7E9614B48F5F4EC29BCF64D3A075976C", hash_generated_method = "4FC8387256A55124DF70E0F237B9E683")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionClearFocus(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_719262783 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean var85D47F37C8A8E496A11CE0CD99470B85_1531385458 = (!target.isFocused());
            } //End collapsed parenthetic
            target.clearFocus();
            boolean var6B4E7E773AB55FC14DC5D0B1ACCA65EC_1083269384 = (!target.isFocused());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (!target.isFocused()) {
                //return false;
            //}
            //target.clearFocus();
            //return !target.isFocused();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.743 -0400", hash_original_method = "AB7AA9516F9E78D5A5AD4BBEB80A41A0", hash_generated_method = "516C827E8CC1D0D06FB4119D039A6A03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionSelect(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_1906391534 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varB0F56BADB6D848BC74C2EB6E3BAB7BCC_1248732383 = (target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(true);
            boolean varE49BAE8F367158D1AAA608101541F1A5_1910427469 = (target.isSelected());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (target.isSelected()) {
                //return false;
            //}
            //target.setSelected(true);
            //return target.isSelected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "E102B39F5DF94C3320BE2ED1E2D3B323", hash_generated_method = "5AE1A56940DD2CA6CA3357C07AC54B5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionClearSelection(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_120612680 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varCEA2FEA7AB8ACAC93A58D6FAF61E7763_1898766148 = (!target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(false);
            boolean varDE00FAE324BEAA0EBABFEB29089F51C8_2035636784 = (!target.isSelected());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (!target.isSelected()) {
                //return false;
            //}
            //target.setSelected(false);
            //return !target.isSelected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "B9D971669B3F873AC0D1B0C38F7811F4", hash_generated_method = "90B9BDC41ECA2B2D518FC27440BCA1AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private View findViewByAccessibilityId(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View root;
            root = ViewRootImpl.this.mView;
            View foundView;
            foundView = root.findViewByAccessibilityId(accessibilityId);
            {
                boolean varB5E3FDDC281E79B82F6D09E4AAD9E0FF_1402317644 = (foundView != null && foundView.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View root = ViewRootImpl.this.mView;
            //if (root == null) {
                //return null;
            //}
            //View foundView = root.findViewByAccessibilityId(accessibilityId);
            //if (foundView != null && foundView.getVisibility() != View.VISIBLE) {
                //return null;
            //}
            //return foundView;
        }

        
        public class SomeArgs implements Poolable<SomeArgs> {
            private SomeArgs mNext;
            private boolean mIsPooled;
            public Object arg1;
            public Object arg2;
            public int argi1;
            public int argi2;
            public int argi3;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "BEE0522D727ED0DB1FBC81A3E3B176C5", hash_generated_method = "90605821903CBBFF1470A17C1794611C")
            @DSModeled(DSC.SAFE)
            public SomeArgs getNextPoolable() {
                return (SomeArgs)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return mNext;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "80FFB187A01961D0CBA265CB5CA66DE6")
            @DSModeled(DSC.SAFE)
            public boolean isPooled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "B595989EA0DDF2662B95D2584CF9AF77", hash_generated_method = "F0CDD934FA01297ACA849395CE3BC35A")
            @DSModeled(DSC.SAFE)
            public void setNextPoolable(SomeArgs args) {
                dsTaint.addTaint(args.dsTaint);
                // ---------- Original Method ----------
                //mNext = args;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "36A555F939A13685926002FBFBD79870")
            @DSModeled(DSC.SAFE)
            public void setPooled(boolean isPooled) {
                dsTaint.addTaint(isPooled);
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "95D0476EAE9CBD3221945617281C6DDB", hash_generated_method = "EB7A590852C374FA66427BD9A413E38C")
            @DSModeled(DSC.SAFE)
            private void clear() {
                arg1 = null;
                arg2 = null;
                argi1 = 0;
                argi2 = 0;
                argi3 = 0;
                // ---------- Original Method ----------
                //arg1 = null;
                //arg2 = null;
                //argi1 = 0;
                //argi2 = 0;
                //argi3 = 0;
            }

            
        }


        
    }


    
    private class SendWindowContentChangedAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.744 -0400", hash_original_method = "3411919DDECDF923DB080425515AE494", hash_generated_method = "C4F76454FCD401EEC7858D2666BE63D0")
        @DSModeled(DSC.SAFE)
        public void run() {
            {
                mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
                mIsPending = false;
            } //End block
            // ---------- Original Method ----------
            //if (mView != null) {
                //mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
                //mIsPending = false;
            //}
        }

        
    }


    
}


