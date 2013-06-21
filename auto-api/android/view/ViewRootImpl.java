package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    long mLastTrackballTime = 0;
    TrackballAxis mTrackballAxisX = new TrackballAxis();
    TrackballAxis mTrackballAxisY = new TrackballAxis();
    int mLastJoystickXDirection;
    int mLastJoystickYDirection;
    int mLastJoystickXKeyCode;
    int mLastJoystickYKeyCode;
    int[] mTmpLocation = new int[2];
    TypedValue mTmpValue = new TypedValue();
    InputMethodCallback mInputMethodCallback;
    SparseArray<Object> mPendingEvents = new SparseArray<Object>();
    int mPendingEventSeq = 0;
    Thread mThread;
    WindowLeaked mLocation;
    WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    W mWindow;
    int mTargetSdkVersion;
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
    Region mTransparentRegion;
    Region mPreviousTransparentRegion;
    int mWidth;
    int mHeight;
    Rect mDirty;
    Rect mCurrentDirty = new Rect();
    Rect mPreviousDirty = new Rect();
    boolean mIsAnimating;
    CompatibilityInfo.Translator mTranslator;
    View.AttachInfo mAttachInfo;
    InputChannel mInputChannel;
    InputQueue.Callback mInputQueueCallback;
    InputQueue mInputQueue;
    FallbackEventHandler mFallbackEventHandler;
    Rect mTempRect;
    Rect mVisRect;
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
    private Surface mSurface = new Surface();
    boolean mAdded;
    boolean mAddedTouchMode;
    CompatibilityInfoHolder mCompatibilityInfo;
    int mAddNesting;
    Rect mWinFrame;
    Rect mPendingVisibleInsets = new Rect();
    Rect mPendingContentInsets = new Rect();
    ViewTreeObserver.InternalInsetsInfo mLastGivenInsets
            = new ViewTreeObserver.InternalInsetsInfo();
    Configuration mLastConfiguration = new Configuration();
    Configuration mPendingConfiguration = new Configuration();
    boolean mScrollMayChange;
    int mSoftInputMode;
    View mLastScrolledFocus;
    int mScrollY;
    int mCurScrollY;
    Scroller mScroller;
    HardwareLayer mResizeBuffer;
    long mResizeBufferStartTime;
    int mResizeBufferDuration;
    private ArrayList<LayoutTransition> mPendingTransitions;
    ViewConfiguration mViewConfiguration;
    ClipDescription mDragDescription;
    View mCurrentDragView;
    volatile Object mLocalDragState;
    PointF mDragPoint = new PointF();
    PointF mLastTouchPoint = new PointF();
    private boolean mProfileRendering;
    private Thread mRenderProfiler;
    private volatile boolean mRenderProfilingEnabled;
    private long mFpsStartTime = -1;
    private long mFpsPrevTime = -1;
    private int mFpsNumFrames;
    AudioManager mAudioManager;
    AccessibilityManager mAccessibilityManager;
    AccessibilityInteractionController mAccessibilityInteractionController;
    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    private int mDensity;
    protected InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    private boolean mProfile = false;
    int mHardwareYOffset;
    int mResizeAlpha;
    Paint mResizePaint = new Paint();
    private long mInputEventReceiveTimeNanos;
    private long mInputEventDeliverTimeNanos;
    private long mInputEventDeliverPostImeTimeNanos;
    private InputQueue.FinishedCallback mFinishedCallback;
    private final InputHandler mInputHandler = new InputHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "DA8B85C0B97B283164189BFC107A0C51", hash_generated_method = "4F8BF8B94A34B2F19F90A4E1D25AD598")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
            dsTaint.addTaint(finishedCallback.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            startInputEvent(finishedCallback);
            dispatchKey(event, true);
            // ---------- Original Method ----------
            //startInputEvent(finishedCallback);
            //dispatchKey(event, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "BA251C4BE7EEF8348B6DA839AE6C5F99", hash_generated_method = "2EA1594D02D3A7D0E339F89FBF8A7E08")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "6892275B4B40A9EB5D5D8351C4113406")
        @DSModeled(DSC.SAFE)
        public Surface getSurface() {
            return (Surface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSurface;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "111414E0BC27432A58777D8D7A8A5313", hash_generated_method = "0F7DD69194824BA055C2DD5DAEDD639B")
        @DSModeled(DSC.SAFE)
        public boolean isCreating() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "1534EBA7EE38BC120F6309F5A1B3FF9E", hash_generated_method = "4CAF96CEFAC9D805EAE1515BEBB029C6")
        @DSModeled(DSC.SAFE)
        public void addCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.140 -0400", hash_original_method = "1D7F6566A3906AFA0AB54EE06949ABBB", hash_generated_method = "3CE3122FE280688AD341C24F3DE20D00")
        @DSModeled(DSC.SAFE)
        public void removeCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "0FF9F7AB4B875AE8A0C5A8C3535F85C8", hash_generated_method = "DB44A4745F18371E857ABBA8B3F2D825")
        @DSModeled(DSC.SAFE)
        public void setFixedSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "0794758F1C90C59C5D7A2C0BDE8FAA38", hash_generated_method = "2283705EABC76CCAA7D98B4015CCD0EC")
        @DSModeled(DSC.SAFE)
        public void setSizeFromLayout() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "CF1EA2FC05AD6DEBDFA26DEE8FD9DB43", hash_generated_method = "EA0923E0492D3CA020EC10069368F865")
        @DSModeled(DSC.SAFE)
        public void setFormat(int format) {
            dsTaint.addTaint(format);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "3D5433EE7774EE621B11389063DDB309")
        @DSModeled(DSC.SAFE)
        public void setType(int type) {
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "46E48CC06FE228B4151C3D83F1499F0C", hash_generated_method = "EDD7F9CB94C74B72BF95F361261CF7D8")
        @DSModeled(DSC.SAFE)
        public void setKeepScreenOn(boolean screenOn) {
            dsTaint.addTaint(screenOn);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.141 -0400", hash_original_method = "3082759B8090FD86F4392C9CC2C4FBD0", hash_generated_method = "0173D114F2ACBE6C0EC31D027084B74C")
        @DSModeled(DSC.SAFE)
        public Canvas lockCanvas() {
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.142 -0400", hash_original_method = "3E84C9B445B974E90BE60751B0E8F5B3", hash_generated_method = "AA3F03048672F74BB2B29B0F991E61EC")
        @DSModeled(DSC.SAFE)
        public Canvas lockCanvas(Rect dirty) {
            dsTaint.addTaint(dirty.dsTaint);
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.142 -0400", hash_original_method = "398534786B4B68CC68F8CE8B2E298404", hash_generated_method = "E0F63FAC44DB0F8A89D5459546A0993F")
        @DSModeled(DSC.SAFE)
        public void unlockCanvasAndPost(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.142 -0400", hash_original_method = "0458ACEC2C801E19AE11DF373ED70BEE", hash_generated_method = "FBF6A701C51ABBAD2B77499950A67A25")
        @DSModeled(DSC.SAFE)
        public Rect getSurfaceFrame() {
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.143 -0400", hash_original_method = "30AB3DC3CF45F6460C1B2C84DB6BEEC3", hash_generated_method = "091E0A5C750FA5F27F8B2E5F4F91185F")
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

    
        public static void addFirstDrawHandler(Runnable callback) {
        synchronized (sFirstDrawHandlers) {
            if (!sFirstDrawComplete) {
                sFirstDrawHandlers.add(callback);
            }
        }
    }

    
        public static void addConfigCallback(ComponentCallbacks callback) {
        synchronized (sConfigCallbacks) {
            sConfigCallbacks.add(callback);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.143 -0400", hash_original_method = "CC8B7F3C56C4BD3E79E20E40E6BC7183", hash_generated_method = "B1C47515DF4380EC2E00EEA4CF22D73A")
    @DSModeled(DSC.SAFE)
    public void profile() {
        mProfile = true;
        // ---------- Original Method ----------
        //mProfile = true;
    }

    
        static boolean isInTouchMode() {
        if (mInitialized) {
            try {
                return sWindowSession.getInTouchMode();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.145 -0400", hash_original_method = "41A7A71F10D2AEAE23E30A793138BBB4", hash_generated_method = "3B3724BB40755D31D69C8A469D559C4C")
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
                    boolean var2EEA59713A247080EA419945AB126FA8_1040180643 = (!compatibilityInfo.supportsScreen());
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
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Adding window failed", e);
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
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not valid; is your activity running?");
                    //End case WindowManagerImpl.ADD_BAD_APP_TOKEN WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN 
                    //Begin case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not for an application");
                    //End case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    //Begin case WindowManagerImpl.ADD_APP_EXITING 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- app for token " + attrs.token
                                + " is exiting");
                    //End case WindowManagerImpl.ADD_APP_EXITING 
                    //Begin case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- window " + mWindow
                                + " has already been added");
                    //End case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    //Begin case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- another window of this type already exists");
                    //End case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    //Begin case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- permission denied for this window type");
                    //End case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
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
                    boolean var9FA688D7A8792CFDE0FE1059C3B8F748_1955386230 = (mAccessibilityManager.isEnabled());
                    {
                        mAccessibilityInteractionConnectionManager.ensureConnection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.145 -0400", hash_original_method = "CB86722DA8E467DDCEDA5A630CA3194B", hash_generated_method = "DF7790EF8310BDC7A225C11C87764341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void destroyHardwareResources() {
        {
            {
                boolean var4CC7CC042FB1A0B872228C316C872BB4_469780981 = (mAttachInfo.mHardwareRenderer.isEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.145 -0400", hash_original_method = "E3F9E04A5716D71423EBE08431EEB223", hash_generated_method = "80B1CB47DAD8C3CC1A3F0A3833BB55F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.146 -0400", hash_original_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1", hash_generated_method = "6C6F306747E474CD609DCD81E33BD853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void destroyHardwareLayers() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_953819237 = (mThread != Thread.currentThread());
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_2054857482 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                    {
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_142633867 = (mAttachInfo.mHardwareRenderer != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.146 -0400", hash_original_method = "645D4C027059B67B04B5E1D1CDD7444E", hash_generated_method = "5013C7578CF7A3186D0802D9ACAAC079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;
        boolean hardwareAccelerated;
        hardwareAccelerated = (attrs.flags & WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) != 0;
        {
            {
                boolean varEAF487A08F9D7C7E236198761FEC371F_1645249466 = (!HardwareRenderer.isAvailable());
            } //End collapsed parenthetic
            boolean fakeHwAccelerated;
            fakeHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED) != 0;
            boolean forceHwAccelerated;
            forceHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED) != 0;
            {
                {
                    boolean var902B8BD79FA592FACE1DE1F2E5EEDD20_397131470 = (!HardwareRenderer.sSystemRendererDisabled
                        && Looper.getMainLooper() != Looper.myLooper());
                } //End collapsed parenthetic
                boolean translucent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.146 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "EF56CAABAD12D60EAF99B804892CE0F3")
    @DSModeled(DSC.SAFE)
    public View getView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.146 -0400", hash_original_method = "6C3085A5B27688C16B5F48D71E61D048", hash_generated_method = "33036E7792B63FAD960159C31D6D84D5")
    @DSModeled(DSC.SAFE)
    final WindowLeaked getLocation() {
        return (WindowLeaked)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.147 -0400", hash_original_method = "344B8CEF50FED73B6C66A984FDFE543C", hash_generated_method = "762A0DCF9FDD95065C85E8DD9D3687F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.147 -0400", hash_original_method = "F0FE5EE4E253DD8DC552809A1CA2533F", hash_generated_method = "0D4D5D42CE8270417CC5E5DCD5C9A658")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.147 -0400", hash_original_method = "18299B4078E7C7C61849ACAFD8526C89", hash_generated_method = "BB6EAB3409F9822032460A2B78E57E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //mNewSurfaceNeeded = true;
        //mFullRedrawNeeded = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.147 -0400", hash_original_method = "A2905530B195FBB19B3C3F0AC663BF20", hash_generated_method = "B4F533FE3D3C8C28D85C11EA8103DD14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //checkThread();
        //mLayoutRequested = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.147 -0400", hash_original_method = "13F945759D2C310C5D0BB68B6FB1E2B8", hash_generated_method = "C41268C47D017184DE242A6095B21D21")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.148 -0400", hash_original_method = "1BB28848D4C8EEFEA34E8E46FE6AC5D5", hash_generated_method = "A7DFABC5B02D3A7E7117DB347AE17ED1")
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
            boolean varEF86BD19BDAC3E37812F85F40921C01A_2036562712 = (!mDirty.isEmpty() && !mDirty.contains(dirty));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.148 -0400", hash_original_method = "813AAD1E42CFCCC731AB301BBB74FC18", hash_generated_method = "C9B69269B05104AFF802002D325AD2DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
        // ---------- Original Method ----------
        //mDirty.set(0, 0, mWidth, mHeight);
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.148 -0400", hash_original_method = "081DD37813B858E5AB3FA0820EF5D835", hash_generated_method = "B7748DD7CD56A68AAA5F90F708ADD5B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.148 -0400", hash_original_method = "DCC308262D5800610A000228CF8970A4", hash_generated_method = "0F483D6780219BA9A188D80AE3A4592C")
    @DSModeled(DSC.SAFE)
    public ViewParent getParent() {
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.149 -0400", hash_original_method = "67B0199062309B0E78F2F88E3E2AD59A", hash_generated_method = "41903AEFA05E3480B1ED319158E45BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        dsTaint.addTaint(location[0]);
        dsTaint.addTaint(dirty.dsTaint);
        invalidateChild(null, dirty);
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //invalidateChild(null, dirty);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.149 -0400", hash_original_method = "FB92C76BB083D5DC37740C978F02B71C", hash_generated_method = "783790263017F487AF493D061809C190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(offset.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("child is not mine, honest!");
        } //End block
        boolean var3C447C15080EDED58EBDD084A72DF38D_1859653523 = (r.intersect(0, 0, mWidth, mHeight));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (child != mView) {
            //throw new RuntimeException("child is not mine, honest!");
        //}
        //return r.intersect(0, 0, mWidth, mHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.149 -0400", hash_original_method = "57451ED91AC07EA69FA21499971D2B45", hash_generated_method = "C7FFBAE63CD65B142845CE636D91FDCC")
    @DSModeled(DSC.SAFE)
    public void bringChildToFront(View child) {
        dsTaint.addTaint(child.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.149 -0400", hash_original_method = "0E9A2AD60F5B60B1A096C27CF046877D", hash_generated_method = "99177F41C4759665C7DCBBBCE826136D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleTraversals() {
        {
            mTraversalScheduled = true;
            {
                long now;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.150 -0400", hash_original_method = "0B26D78664F51D8793A6008ECDA459E7", hash_generated_method = "BFA015F92D16949DEB22819F36EBF3B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.150 -0400", hash_original_method = "27A276950AD49DC3B2BCAC57214867E1", hash_generated_method = "49361E539EE1EF10D3B4C815237B5F9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getHostVisibility() {
        {
            Object var8D6CE5BDBC311FE3B049ABF0D70214FD_536513063 = (mView.getVisibility());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAppVisible ? mView.getVisibility() : View.GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.150 -0400", hash_original_method = "4A37F94A433BB0C51ABAD4CD2013B711", hash_generated_method = "0B7B046B5B1C7C45D8B416132FB9272C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.150 -0400", hash_original_method = "9CCD20C4D5BE58E51524A629AA69C9DE", hash_generated_method = "E8DD0BBD11A2418B3518C0D8988E58E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestTransitionStart(LayoutTransition transition) {
        dsTaint.addTaint(transition.dsTaint);
        {
            boolean var194FCB9DF54F69E97F56CE68C10354D0_1895581950 = (mPendingTransitions == null || !mPendingTransitions.contains(transition));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.150 -0400", hash_original_method = "E06FBD8158D133D090EB34C23F0C9FD1", hash_generated_method = "89DC00F688CB268F0915107D47A234DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.464 -0400", hash_original_method = "DF10FEADFB061504FA9A2B620C341C55", hash_generated_method = "F6C75D747FBE392A4AB5D6442ADA86D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performTraversals() {
        View host;
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
        View.AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        int viewVisibility;
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
            boolean var0A004AC3811C18545614B32625CEEC49_1639352881 = (compatibilityInfo.supportsScreen() == mLastInCompatMode);
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
            Resources res;
            res = mView.getContext().getResources();
            {
                mAttachInfo.mInTouchMode = !mAddedTouchMode;
                ensureTouchModeLocally(mAddedTouchMode);
            } //End block
            {
                {
                    boolean var62033EA88707C143C01D8EAFE9900154_1254104505 = (!mPendingContentInsets.equals(mAttachInfo.mContentInsets));
                    {
                        insetsChanged = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var0CAA9A1F030432324CBF6F78F99C9DD7_328917176 = (!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets));
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
                DisplayMetrics packageMetrics;
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
                        boolean var21D962C086164386A94062CBCB36B58F_1569258802 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
                        {
                            goodMeasure = true;
                        } //End block
                        {
                            baseSize = (baseSize+desiredWindowWidth)/2;
                            childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                            host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            {
                                boolean var9F98C604F7D547E03F47254F3D22799F_1292283337 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
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
                    boolean varDF7BF5380028FDCE8B63C5F6F1205021_2121126040 = (mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight());
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
                int N;
                N = attachInfo.mScrollContainers.size();
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varA64E9739EA7F01D5D1160845BAD0386A_812275813 = (attachInfo.mScrollContainers.get(i).isShown());
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
                boolean var124397EC8E035E35B1B90F57C49E8065_1719059920 = (!PixelFormat.formatHasAlpha(params.format));
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
        boolean computesInternalInsets;
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
                int surfaceGenerationId;
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
                        boolean var1E0539E09B573A600F6F1CFEAFBE4679_1694769497 = (mWidth > 0 && mHeight > 0 &&
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
                                    boolean var3E6D8158ACA9AC4B059634A10A6CF6F6_640889770 = (mResizeBuffer.getWidth() != mWidth ||
                                    mResizeBuffer.getHeight() != mHeight);
                                    {
                                        mResizeBuffer.resize(mWidth, mHeight);
                                    } //End block
                                } //End collapsed parenthetic
                                layerCanvas = mResizeBuffer.start(hwRendererCanvas);
                                layerCanvas.setViewport(mWidth, mHeight);
                                layerCanvas.onPreDraw(null);
                                int restoreCount;
                                restoreCount = layerCanvas.save();
                                layerCanvas.drawColor(0xff000000, PorterDuff.Mode.SRC);
                                int yoff;
                                boolean scrolling;
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
                        boolean var85F0101842CACF01F09324AA7EC986C7_1997402323 = (mSurface.isValid());
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
                                            boolean varDF4C39F3C79070D8F8930AEFD74A46C5_1148315768 = (!sWindowSession.outOfMemory(mWindow));
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
                    boolean var223FE8BD2DC3BE69B6019B00E048EE0C_1751880847 = (!mSurface.isValid());
                    {
                        mLastScrolledFocus = null;
                        mScrollY = mCurScrollY = 0;
                        {
                            mScroller.abortAnimation();
                        } //End block
                        disposeResizeBuffer();
                        {
                            boolean var750EE654262A2705CF0E4AE4A63530E4_1374376769 = (mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled());
                            {
                                mAttachInfo.mHardwareRenderer.destroy(true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varA621B9B0F4C63EC9228FD0CAB33867BD_771481539 = (surfaceGenerationId != mSurface.getGenerationId() &&
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
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_1702052325 = (!sWindowSession.outOfMemory(mWindow));
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
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_1178447155 = (mSurface.isValid());
                    {
                        mSurfaceHolder.mSurface = mSurface;
                    } //End block
                } //End collapsed parenthetic
                mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
                mSurfaceHolder.mSurfaceLock.unlock();
                {
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_516785529 = (mSurface.isValid());
                    {
                        {
                            mSurfaceHolder.ungetCallbacks();
                            mIsCreating = true;
                            mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
                            SurfaceHolder.Callback callbacks[];
                            callbacks = mSurfaceHolder.getCallbacks();
                            {
                                {
                                    SurfaceHolder.Callback c = callbacks[0];
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
                                    SurfaceHolder.Callback c = callbacks[0];
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
                                SurfaceHolder.Callback c = callbacks[0];
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
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_459746848 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    {
                        boolean var68BE6CA5337B3E1A6C30D35C34420F08_2115454177 = (hwInitialized || windowShouldResize ||
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
                    boolean varA6DAF762C1B830FF995EE7E2238847D5_2136271018 = (focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth()
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
        boolean didLayout;
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
                    boolean var31831045BDEFED9943FC4835790CC5A9_633461498 = (!host.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_LAYOUT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The view hierarchy is an inconsistent state,"
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
                    boolean var9116609D398330DBB934B3776C260A89_671812778 = (!mTransparentRegion.equals(mPreviousTransparentRegion));
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
                boolean var673B0FAE9DD6499A44EB4983D0077ABD_2042631654 = (AccessibilityManager.getInstance(host.mContext).isEnabled());
                {
                    postSendWindowContentChangedCallback();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            ViewTreeObserver.InternalInsetsInfo insets;
            insets = attachInfo.mGivenInternalInsets;
            insets.reset();
            attachInfo.mTreeObserver.dispatchOnComputeInternalInsets(insets);
            {
                boolean var0FBD0E114506B508CD538E9D69F15B52_601722212 = (insetsPending || !mLastGivenInsets.equals(insets));
                {
                    mLastGivenInsets.set(insets);
                    Rect contentInsets;
                    Rect visibleInsets;
                    Region touchableRegion;
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
                    boolean var4424A784A6C03CB3A8B3EDDFC8E02AD9_1573570263 = (!mView.hasFocus());
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
            boolean imTarget;
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
                boolean var01179B785E9234D284AD849ED1C97F52_716692704 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i;
                        i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_1713365100 = (i < mPendingTransitions.size());
                        {
                            mPendingTransitions.get(i).startChangingAnimations();
                        } //End block
                    } //End collapsed parenthetic
                    mPendingTransitions.clear();
                } //End block
            } //End collapsed parenthetic
            mFullRedrawNeeded = false;
            long drawStartTime;
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
                    boolean varFBA90BC0FA837508D9D80EA4B8A252E5_1596504134 = (mSurfaceHolder != null && mSurface.isValid());
                    {
                        mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
                        SurfaceHolder.Callback callbacks[];
                        callbacks = mSurfaceHolder.getCallbacks();
                        {
                            {
                                SurfaceHolder.Callback c = callbacks[0];
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
                boolean var01179B785E9234D284AD849ED1C97F52_1113911227 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i;
                        i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_766052753 = (i < mPendingTransitions.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.466 -0400", hash_original_method = "365202E212CCFCA6F73CFA951F572330", hash_generated_method = "8E12023293D2E124A0E461ADE8F92DF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.466 -0400", hash_original_method = "66EB141D637AEB4DAD3BF6AA91407C70", hash_generated_method = "AFF0BBD526FA76E00128A31C35D15986")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getRootMeasureSpec(int windowSize, int rootDimension) {
        dsTaint.addTaint(rootDimension);
        dsTaint.addTaint(windowSize);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.466 -0400", hash_original_method = "40FADC477E8B2549BFFAC38F5B19946C", hash_generated_method = "03B2CCB6CF0AF8B0EEED090BD3509798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onHardwarePreDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        canvas.translate(0, -mHardwareYOffset);
        // ---------- Original Method ----------
        //canvas.translate(0, -mHardwareYOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.467 -0400", hash_original_method = "0640B89EE45E5EFA4DD1A520BD523415", hash_generated_method = "45EEA69BFCF211EC481067F08C0F55B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.467 -0400", hash_original_method = "6ED7CE075B975161CAA5CFD7B073E953", hash_generated_method = "A25138E49DEBB1F0FF8DA49C8F8CB589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.468 -0400", hash_original_method = "910E3893A962467411DC222791137B30", hash_generated_method = "8AB7CFA52F132865CBCBAB904F896741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void profileRendering(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            {
                mRenderProfiler = new Thread(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.468 -0400", hash_original_method = "EA0E14B14C78DD1BF1B50C8FA4E06FFC", hash_generated_method = "705EDA88C9D10DBA31F87E3EBD90AF65")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void run() {
                        Log.d(TAG, "Starting profiling thread");
                        {
                            mAttachInfo.mHandler.post(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.468 -0400", hash_original_method = "4A3D1224B1F9A46A2478F0B98B77BC62", hash_generated_method = "3306EB70EC747DC660D40B63C10E33A1")
                                //DSFIXME:  CODE0002: Requires DSC value to be set
                                @Override
                                public void run() {
                                    mDirty.set(0, 0, mWidth, mHeight);
                                    scheduleTraversals();
                                    // ---------- Original Method ----------
                                    //mDirty.set(0, 0, mWidth, mHeight);
                                    //scheduleTraversals();
                                }
});
                            try 
                            {
                                Thread.sleep(15);
                            } //End block
                            catch (InterruptedException e)
                            {
                                Log.d(TAG, "Exiting profiling thread");
                            } //End block
                        } //End block
                        // ---------- Original Method ----------
                        //Log.d(TAG, "Starting profiling thread");
                        //while (mRenderProfilingEnabled) {
                            //mAttachInfo.mHandler.post(new Runnable() {
                                //@Override
                                //public void run() {
                                    //mDirty.set(0, 0, mWidth, mHeight);
                                    //scheduleTraversals();
                                //}
                            //});
                            //try {
                                //Thread.sleep(15);
                            //} catch (InterruptedException e) {
                                //Log.d(TAG, "Exiting profiling thread");
                            //}                            
                        //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.469 -0400", hash_original_method = "1AA1A4B748D7601F4F3826735499E6F6", hash_generated_method = "9142EC35AF48E8C926B3F49668F6E3FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trackFPS() {
        long nowTime;
        nowTime = System.currentTimeMillis();
        {
            mFpsStartTime = mFpsPrevTime = nowTime;
            mFpsNumFrames = 0;
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.470 -0400", hash_original_method = "E37EF3DCFB26F629DB3873EE57113F2D", hash_generated_method = "83F6866857FFE35532D7B38266B0C80C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void draw(boolean fullRedrawNeeded) {
        dsTaint.addTaint(fullRedrawNeeded);
        Surface surface;
        surface = mSurface;
        {
            boolean var2E815E81AF85D59B92EF3DD48D335D0C_2092455480 = (surface == null || !surface.isValid());
        } //End collapsed parenthetic
        {
            trackFPS();
        } //End block
        {
            {
                sFirstDrawComplete = true;
                int count;
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
            boolean var5D30B77E3F89F2623E0DAAFBA8BE8C49_445562365 = (mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled());
            {
                {
                    boolean varD5F827B9D34B0B1DC1F85ACE756947A8_1793326086 = (!dirty.isEmpty() || mIsAnimating);
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
                            boolean varDE04A2AF95D6F679E2E2203A2A073551_1551129346 = (mAttachInfo.mHardwareRenderer.draw(mView, mAttachInfo, this, currentDirty));
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
            boolean varAC62E7C7590DB61B5214E434C55175F8_1955903042 = (!dirty.isEmpty() || mIsAnimating);
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
                    long lockCanvasStartTime;
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
                            boolean var752BE542D442F142A9DEDCDCD20ADA9F_199201553 = (!sWindowSession.outOfMemory(mWindow));
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
                        boolean var94DD6BEDF06EB37762BEEC60B9337CF6_2117458177 = (!dirty.isEmpty() || mIsAnimating);
                        {
                            long startTime;
                            startTime = 0L;
                            {
                                startTime = SystemClock.elapsedRealtime();
                            } //End block
                            {
                                boolean varD1E08946F6E52A077FF56A289B9208C1_2058712390 = (!canvas.isOpaque() || yoff != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.472 -0400", hash_original_method = "FAD7953F436A3C038802D5DE07F19E9E", hash_generated_method = "9D1D3FFCEDD94FA87D019186C5C65CFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
        View.AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        Rect ci;
        ci = attachInfo.mContentInsets;
        Rect vi;
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
                    boolean var6E219E0A30DABE54C1FB5AE05AB0C96F_986960831 = (focus.getGlobalVisibleRect(mVisRect, null));
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
                            boolean var7B24AA8599694B5C184BD1D7A0EA3976_786978677 = (mTempRect.intersect(mVisRect));
                            {
                                {
                                    boolean var3D339EB9AF254B1679979682435121C1_1186640816 = (mTempRect.height() >
                                (mView.getHeight()-vi.top-vi.bottom));
                                    {
                                        scrollY -= vi.top - (mTempRect.top-scrollY);
                                    } //End block
                                    {
                                        boolean var3406F2BDBAA7A3EBFD045E8954640BCE_670620563 = ((mTempRect.bottom-scrollY)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.472 -0400", hash_original_method = "9E09AEB1258054D8E474B794DDE3DA53", hash_generated_method = "809212A182FDF6E3CF2C1973ABEA1906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.473 -0400", hash_original_method = "D78AE43D1295D32838328E11498E7092", hash_generated_method = "58C76B060FBD22E806CF030C9E880E3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearChildFocus(View child) {
        dsTaint.addTaint(child.dsTaint);
        checkThread();
        View oldFocus;
        oldFocus = mFocusedView;
        mFocusedView = mRealFocusedView = null;
        {
            boolean var0C2CE9934D88CF89C62BF802E1814E91_922082883 = (mView != null && !mView.hasFocus());
            {
                {
                    boolean varC84B37DB46E138B03F613C2E132675E1_303070601 = (!mView.requestFocus(View.FOCUS_FORWARD));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.473 -0400", hash_original_method = "8AB5F5420D903C559791A9BF9B9BF8FD", hash_generated_method = "C1040A06AD0D1C531C5F0E12C2246F46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusableViewAvailable(View v) {
        dsTaint.addTaint(v.dsTaint);
        checkThread();
        {
            {
                boolean var9C9B0C0875517AC338686EE7008FD35A_1657643377 = (!mView.hasFocus());
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
                        boolean var673A3BE5EE0B137534BC4B96ECEA81C3_823165447 = (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.473 -0400", hash_original_method = "66451BF0E175BE00AB35036422B65D7E", hash_generated_method = "443D2513915BD65E57F73A380AD46672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.474 -0400", hash_original_method = "59E93FB376BDE71F69616A2B01BFF0AF", hash_generated_method = "9DB8F5755988093BDB19CD07A613854F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchDetachedFromWindow() {
        {
            {
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_1850171476 = (mAttachInfo.mHardwareRenderer != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.474 -0400", hash_original_method = "095941099FB476714878603F2FD5257D", hash_generated_method = "73CE0C8B3851D7DC5B2EA59C48F56F97")
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
                boolean var8C30D5838B256BB265C26C428C6B837E_119230069 = (force || mLastConfiguration.diff(config) != 0);
                {
                    mLastConfiguration.setTo(config);
                    mView.dispatchConfigurationChanged(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }
        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.475 -0400", hash_original_method = "95F12947A9B342E5A748CE842344783A", hash_generated_method = "76360751CCBA6BE117FBC96ED949192B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessageName(Message message) {
        dsTaint.addTaint(message.dsTaint);
        String var96322DF42F9AAAF04C6A6417DE435EFC_267509138 = (super.getMessageName(message));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.477 -0400", hash_original_method = "0C83FFF474CF8ADB1C57E65037847991", hash_generated_method = "40172C40A661AB567F0096A132AF3576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case View.AttachInfo.INVALIDATE_MSG 
        ((View) msg.obj).invalidate();
        //End case View.AttachInfo.INVALIDATE_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        View.AttachInfo.InvalidateInfo info;
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
        long traversalStartTime;
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
            boolean var143D5C08604C0AF03595F421C2A612C0_337609628 = (mWinFrame.width() == msg.arg1 && mWinFrame.height() == msg.arg2
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
                        boolean var3AE98E3D719D8E57E314A6EF6D2DA333_713652556 = (mAttachInfo.mHardwareRenderer != null &&
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
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_1818659389 = (!sWindowSession.outOfMemory(mWindow));
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
                boolean varE3C639C95D7D8182790DE92882BAC40A_1409135042 = ((event.getFlags()&KeyEvent.FLAG_FROM_SYSTEM) != 0);
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
                boolean var1B1857A3FCA31AAF6E6915F53921CC12_294041731 = (config.isOtherSeqNewer(mLastConfiguration));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.478 -0400", hash_original_method = "0B0FC84CA02F82927D98059C965571E0", hash_generated_method = "3F37A4EFE892B65E14EF8A163130B5D9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.478 -0400", hash_original_method = "06AEBC75FF0DC9B70A4E2BB2CC6850C1", hash_generated_method = "EA3C3B7C7CDBEFB08C28E07685231680")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishInputEvent(InputEvent event, boolean handled) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(handled);
        {
            long now;
            now = System.nanoTime();
            long eventTime;
            eventTime = event.getEventTimeNano();
            StringBuilder msg;
            msg = new StringBuilder();
            msg.append("Latency: Spent ");
            msg.append((now - mInputEventReceiveTimeNanos) * 0.000001f);
            msg.append("ms processing ");
            {
                KeyEvent keyEvent;
                keyEvent = (KeyEvent)event;
                msg.append("key event, action=");
                msg.append(KeyEvent.actionToString(keyEvent.getAction()));
            } //End block
            {
                MotionEvent motionEvent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.478 -0400", hash_original_method = "A6640F15C2D0A406B73F798DB9EA077C", hash_generated_method = "5DF9EFACFADA71B31ABE24E05ACC8904")
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
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        boolean var7211DA2D02AAD3EC6219E770D8E33669_930485301 = (ensureTouchModeLocally(inTouchMode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.479 -0400", hash_original_method = "A817FB22551D2F047707EAAC44367E27", hash_generated_method = "179100BCBBD1697494FCDE54962EB53F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean ensureTouchModeLocally(boolean inTouchMode) {
        dsTaint.addTaint(inTouchMode);
        Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        mAttachInfo.mInTouchMode = inTouchMode;
        mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        {
            Object varD5C5D13645C8843ADC3AA1EF553CA4E0_847886756 = (enterTouchMode());
            Object var1779B98836824743D0F81D690D2F09AF_2088988309 = (leaveTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.479 -0400", hash_original_method = "4D22F5F97C319901FE80DD8DAA6DBF2B", hash_generated_method = "9295515406ADDB87C41A5D4FB65D9E1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean enterTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_1230777504 = (mView.hasFocus());
                {
                    View focused;
                    focused = mView.findFocus();
                    {
                        boolean var672E3B133FEEB41FF55DF762226C4368_221293835 = (focused != null && !focused.isFocusableInTouchMode());
                        {
                            ViewGroup ancestorToTakeFocus;
                            ancestorToTakeFocus = findAncestorToTakeFocusInTouchMode(focused);
                            {
                                boolean var4BDB6BBF285F787DB5D62E792270B9CC_241235533 = (ancestorToTakeFocus.requestFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.480 -0400", hash_original_method = "A2FE4CBD06D42BF7C573F07F56417767", hash_generated_method = "B4AD33FCFD1F8F8AC1020501404970DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        dsTaint.addTaint(focused.dsTaint);
        ViewParent parent;
        parent = focused.getParent();
        {
            ViewGroup vgParent;
            vgParent = (ViewGroup) parent;
            {
                boolean varC23A07520BE483EA425697E9FFE7255F_1973511412 = (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    && vgParent.isFocusableInTouchMode());
            } //End collapsed parenthetic
            {
                boolean var410E9039314AA011024573FA45C6C4E3_175864768 = (vgParent.isRootNamespace());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.480 -0400", hash_original_method = "6D4A7A06FF255705F6FF85A0D8D1E147", hash_generated_method = "332BC69A9A7DF25AA52387F09D30A7ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean leaveTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_899379474 = (mView.hasFocus());
                {
                    mFocusedView = mView.findFocus();
                    {
                        boolean var685A2905466615BFEF6173704AD9363B_799093694 = (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            View focused;
            focused = focusSearch(null, View.FOCUS_DOWN);
            {
                boolean var36C6CFA2F3F9A6ADFC90E9AFC6590240_129693556 = (focused.requestFocus(View.FOCUS_DOWN));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.481 -0400", hash_original_method = "8F847D145475DB0C2BA683E62F600908", hash_generated_method = "3F48C1CC19E15D10E17766A6427CF242")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverPointerEvent(MotionEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        boolean isTouchEvent;
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
        int action;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.481 -0400", hash_original_method = "DF90914307EFCD2CA23CDB09D8C7F95D", hash_generated_method = "483F82EA21AEFF0FDDB8D3A90332B388")
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
                boolean varFE47529C887D16DE595A17210AB89645_279587292 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.482 -0400", hash_original_method = "B306A4DB67A1B71DDAAA3D4C50CD59B0", hash_generated_method = "B986CA4C479295BC739069415BD03F3D")
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
            boolean var0BF4F8530CCB1128C2413D92D7C48A33_1659698452 = (mView.dispatchTrackballEvent(event));
            {
                ensureTouchMode(false);
                finishMotionEvent(event, sendDone, true);
                mLastTrackballTime = Integer.MIN_VALUE;
            } //End block
        } //End collapsed parenthetic
        TrackballAxis x;
        x = mTrackballAxisX;
        TrackballAxis y;
        y = mTrackballAxisY;
        long curTime;
        curTime = SystemClock.uptimeMillis();
        {
            x.reset(0);
            y.reset(0);
            mLastTrackballTime = curTime;
        } //End block
        int action;
        action = event.getAction();
        int metaState;
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
        float xOff;
        xOff = x.collect(event.getX(), event.getEventTime(), "X");
        float yOff;
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
                int repeatCount;
                repeatCount = accelMovement - movement;
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_MULTIPLE, keycode, repeatCount, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.483 -0400", hash_original_method = "D79206E9EE4BD2FB4F0103FA8C72904A", hash_generated_method = "9FF485C6F9A9CA94F8BF3DBCF80A9179")
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
        int source;
        source = event.getSource();
        boolean isJoystick;
        isJoystick = (source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0;
        {
            {
                updateJoystickDirection(event, false);
            } //End block
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            boolean var1480525DCF9F333BCCE9610B03BC6BD1_1892211960 = (mView.dispatchGenericMotionEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.483 -0400", hash_original_method = "3F24F6EAAF68F5E1EBCC50D38D5B0024", hash_generated_method = "40DD5D06DAD87B56A6AD6F5097303728")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateJoystickDirection(MotionEvent event, boolean synthesizeNewKeys) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(synthesizeNewKeys);
        long time;
        time = event.getEventTime();
        int metaState;
        metaState = event.getMetaState();
        int deviceId;
        deviceId = event.getDeviceId();
        int source;
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

    
        private static int joystickAxisValueToDirection(float value) {
        if (value >= 0.5f) {
            return 1;
        } else if (value <= -0.5f) {
            return -1;
        } else {
            return 0;
        }
    }

    
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

    
        private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.484 -0400", hash_original_method = "4A4EC0979E3C48040C37CBDD240E0778", hash_generated_method = "F80F99E6A901BBB3633E90240573F1C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int action;
        action = event.getAction();
        {
            boolean var374764C2EBA0004373F7F9D216C18EBE_1346094211 = ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0);
        } //End collapsed parenthetic
        {
            boolean varC540748EA661E5534CCE6D53AFE70351_790237010 = (isNavigationKey(event));
            {
                boolean varDCF046E768F735C43D4A4F2892DB8761_254441471 = (ensureTouchMode(false));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDC7BE1867293052F150F168518DBFDDE_1270533857 = (isTypingKey(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.485 -0400", hash_original_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84", hash_generated_method = "FB48BF4A9FDBD6A936F2BA243282F417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.485 -0400", hash_original_method = "D1881A2DE4A478B1C2476E8789D90C4F", hash_generated_method = "D83FC8B9F30FF4B798B57B3FA4BE80F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.485 -0400", hash_original_method = "7BC82D96B9DB6F7A084DA2256A5743DA", hash_generated_method = "8FB26BA892EF67433FC076E6E257B7C3")
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
            boolean var5290A33EAEDAF51EED599C106DE398FD_692633179 = (mView.dispatchKeyEventPreIme(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.486 -0400", hash_original_method = "1D388C4C66D020B7A8C536C50B24E128", hash_generated_method = "AAA5B9970E87703EB1C54DA3BA1472DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleFinishedEvent(int seq, boolean handled) {
        dsTaint.addTaint(seq);
        dsTaint.addTaint(handled);
        KeyEvent event;
        event = (KeyEvent)retrievePendingEvent(seq);
        {
            boolean sendDone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.487 -0400", hash_original_method = "3773604D66AC7B7214885F4E3DA58090", hash_generated_method = "165D4C6C0B6BE83F8DDE319BF5DEA8C1")
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
            boolean var972B8A8CC08694C2525DE534B4F8BB01_1160654201 = (checkForLeavingTouchModeAndConsume(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        mFallbackEventHandler.preDispatchKeyEvent(event);
        {
            boolean var9386095FD83FC6C0A38FFA49591950FC_1395776313 = (mView.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var85A8FDC8626CC7E23374B602A2E2C62C_203343949 = (event.getAction() == KeyEvent.ACTION_DOWN
                && event.isCtrlPressed()
                && event.getRepeatCount() == 0
                && !KeyEvent.isModifierKey(event.getKeyCode()));
            {
                {
                    boolean varF97DC0BD6AE66CDC354B90DB1D102EE2_898231742 = (mView.dispatchKeyShortcutEvent(event));
                    {
                        finishKeyEvent(event, sendDone, true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB867097ED2D7A136AEC6AB204A7A4421_748616097 = (mFallbackEventHandler.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_2132444861 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                int direction;
                direction = 0;
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_1748904386 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_344632343 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_LEFT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1195118893 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_RIGHT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1405165106 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_UP;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1684250886 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_DOWN;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_TAB 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1289804767 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_FORWARD;
                        } //End block
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_239968377 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
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
                                boolean var8E442CEC6A978F0FDB8EDCFD023A5F81_84049948 = (v.requestFocus(direction, mTempRect));
                                {
                                    playSoundEffect(
                                    SoundEffectConstants.getContantForFocusDirection(direction));
                                    finishKeyEvent(event, sendDone, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varF5C20EE82F62ADD0C6A5E46AE0DD38DF_854860038 = (mView.dispatchUnhandledMove(focused, direction));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.487 -0400", hash_original_method = "2621255CFED260FE88FD0E0DE76ACADD", hash_generated_method = "199905CD548AE31CA3E5D69B5CE577DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.497 -0400", hash_original_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80", hash_generated_method = "37ECF6C45F4806DED83F1F6C7CEF44AB")
    @DSModeled(DSC.SAFE)
     void setLocalDragState(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        // ---------- Original Method ----------
        //mLocalDragState = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.498 -0400", hash_original_method = "977584242F0720CC5E20503FC56D761D", hash_generated_method = "5938E63A0E19E4FEFEF7BDB1CFD6C5D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            int what;
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
                View prevDragView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.501 -0400", hash_original_method = "504EE99E4FC1047B3EE4816C6C3CF55E", hash_generated_method = "51E5B9EDF551BA67EA8E0C3F987E33AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.502 -0400", hash_original_method = "45F97324DFA9B47BC7B47DB7731173BB", hash_generated_method = "FE024CA31CB9FC3C685BD84F01500212")
    @DSModeled(DSC.SAFE)
    public void getLastTouchPoint(Point outLocation) {
        dsTaint.addTaint(outLocation.dsTaint);
        outLocation.x = (int) mLastTouchPoint.x;
        outLocation.y = (int) mLastTouchPoint.y;
        // ---------- Original Method ----------
        //outLocation.x = (int) mLastTouchPoint.x;
        //outLocation.y = (int) mLastTouchPoint.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.502 -0400", hash_original_method = "D8987F1AD41DCFCEC13505B3421C8BB0", hash_generated_method = "B8E119799B4D3B4CDD76300265D9C0C9")
    @DSModeled(DSC.SAFE)
    public void setDragFocus(View newDragTarget) {
        dsTaint.addTaint(newDragTarget.dsTaint);
        // ---------- Original Method ----------
        //if (mCurrentDragView != newDragTarget) {
            //mCurrentDragView = newDragTarget;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.503 -0400", hash_original_method = "63BA605FA957D5097ED6886D9988BC53", hash_generated_method = "BD6AEEB12018CDF08F06B8AD9B0680DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AudioManager getAudioManager() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getAudioManager called when there is no mView");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.505 -0400", hash_original_method = "C22EE439EF1C63381F42BE80F34ED0C5", hash_generated_method = "EE8BAECF7B1337F300A6B16D49A2147B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityInteractionController getAccessibilityInteractionController() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getAccessibilityInteractionController"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.506 -0400", hash_original_method = "0B2FE2E2B393762D66EC0169ABC2799A", hash_generated_method = "D9931F7E85952278E0B0DEBD2EDB8050")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.506 -0400", hash_original_method = "15B8C68C65C02C1955DF774990289073", hash_generated_method = "7614898AF9204305BDEFC142FA058979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSoundEffect(int effectId) {
        dsTaint.addTaint(effectId);
        checkThread();
        try 
        {
            AudioManager audioManager;
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
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown effect id " + effectId +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.507 -0400", hash_original_method = "B8D922B767BD06C4283BB3EF0BFA3172", hash_generated_method = "860F9B0CE19AAA9BE249CAFD84591D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int effectId, boolean always) {
        dsTaint.addTaint(effectId);
        dsTaint.addTaint(always);
        try 
        {
            boolean varFBBA9023D273BC1BC4D4CED056000D00_1813724350 = (sWindowSession.performHapticFeedback(mWindow, effectId, always));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.507 -0400", hash_original_method = "220A5158C443CFE1D4535C372C690545", hash_generated_method = "666B848E4F4CD3B88445B9AD4E91195D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        checkThread();
        View varB98E74C6692446F9B2C9C3CE7AF3926B_1789524526 = (FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkThread();
        //if (!(mView instanceof ViewGroup)) {
            //return null;
        //}
        //return FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.507 -0400", hash_original_method = "5C67D040EE10672AA68B296434D2F63D", hash_generated_method = "265CF6F642B6AAE7F0DC95CDCBD015E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void debug() {
        mView.debug();
        // ---------- Original Method ----------
        //mView.debug();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.508 -0400", hash_original_method = "818AD1A70B8E095131DC73E371E19514", hash_generated_method = "4382D1C11834E3B71D96761F7A65F3C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpGfxInfo(PrintWriter pw, int[] info) {
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(info[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.508 -0400", hash_original_method = "CD86B0B9CE453C77251859969963B0E8", hash_generated_method = "6C3CB1D2610F50AE0E9908A46F572E5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getGfxInfo(View view, int[] info) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(info[0]);
        DisplayList displayList;
        displayList = view.mDisplayList;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.508 -0400", hash_original_method = "F971131E8183B74AE14F7AE1993EB770", hash_generated_method = "60AA267B2EBAD35EBCAFD7B31C49C509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.508 -0400", hash_original_method = "8D1DF41E880ED97CD9EA450CBF8DEBA9", hash_generated_method = "F959AC6E71C6D3ED50085FB597D9D597")
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
                            boolean var9AE39921E95FF8EFBAECC8E0B3546A66_556773254 = ((relayoutWindow(mWindowAttributes, viewVisibility, false)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.509 -0400", hash_original_method = "C21E5BD1C0448C03922FA84C1B8F3673", hash_generated_method = "F2D6C5B7AF0716A1F65BE4AA0E551A54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestUpdateConfiguration(Configuration config) {
        dsTaint.addTaint(config.dsTaint);
        Message msg;
        msg = obtainMessage(UPDATE_CONFIGURATION, config);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.509 -0400", hash_original_method = "83B5F7EEB6D7B3078A7769D15E86950B", hash_generated_method = "8B0C7B51612C6768308E296410004249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.509 -0400", hash_original_method = "459EFA224EE61797FCF735DB24F377FF", hash_generated_method = "B1C7C42565887EF74330F1DA4038E920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.510 -0400", hash_original_method = "176F47B7EDC9D70A69736114EF5A25ED", hash_generated_method = "74D409DCCE271F7C8A40404664D32E18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.510 -0400", hash_original_method = "42F15B8B44D9B8805537AB8032035046", hash_generated_method = "5A8FD1C62B0CF829C4D7B6862C743EDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.510 -0400", hash_original_method = "CF232D7D6B258A687467B35A15A72FA0", hash_generated_method = "6865CF33D23BE97AA7D6485DECC81947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchKey(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dispatchKey(event, false);
        // ---------- Original Method ----------
        //dispatchKey(event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.511 -0400", hash_original_method = "40FF3F3DF013E72EC5E96E0A49136BE3", hash_generated_method = "19049D6A1DA5E9BBE5A497528AB32939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchKey(KeyEvent event, boolean sendDone) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(sendDone);
        {
            boolean var614B93C66D10470F75E816C5D006D92E_643744939 = (false && event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    boolean var93BBE93F11B74C6BE1CA3CCD54D7C4DB_1690735359 = (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.511 -0400", hash_original_method = "F90A161CC4BD8998AC3B193B63EB7E53", hash_generated_method = "9075F7A668B2CB8B08DB6F3A8501B215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.511 -0400", hash_original_method = "DD56557FEAC8CACD87B056C5C0C702D1", hash_generated_method = "F8C0F042BBC0D946F4A064777A718C82")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.512 -0400", hash_original_method = "CA2BFA17163311E1AAAA771C667E27EE", hash_generated_method = "FF077EF08D8EE4C84A6F8AEAEA2B7F87")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.512 -0400", hash_original_method = "BF71C2E204EC82729A1EA0969E06871A", hash_generated_method = "F79F74427FD1EF5E7646D17A5DC0F6D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.512 -0400", hash_original_method = "609DE6F7AC6918A6ED5E47157E290835", hash_generated_method = "D839B42E9EE785CD16D970CE2932ADC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.512 -0400", hash_original_method = "4D3A3DC5DC743660725FA6A11A372A07", hash_generated_method = "801FCC0FB0D85A9B99876EE9478533A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchGetNewSurface() {
        Message msg;
        msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.513 -0400", hash_original_method = "0CD487AEEAC72879653D2DB3DCCCEB86", hash_generated_method = "93BCE6E5C9CF8DB359915D90350774BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.513 -0400", hash_original_method = "DCE84E54CF89AABF2B838105364C2821", hash_generated_method = "BD4750D877108990E2942BE5EE34D35C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.513 -0400", hash_original_method = "786F6A89EC1BE66218A42841DB30F7AC", hash_generated_method = "495633D0BFB4B1D7FC3A95A433ACB6BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int what;
        {
            boolean varB24B6A2E894360805412F219C1784FDD_52619852 = (event.getAction() == DragEvent.ACTION_DRAG_LOCATION);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.514 -0400", hash_original_method = "95F6C6AC5462FA09198431CBF084B2BE", hash_generated_method = "630F2129688D6683A7D49110AEC3F275")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.514 -0400", hash_original_method = "DE2DA8F2C91C4BAC5E71DE180C591B82", hash_generated_method = "77F7C490598CD40737C887F6BAA1E4B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendAccessibilityEvents() {
        {
            boolean var6B92FF47081CEAA2DFA035B3AA7C5808_1358483286 = (!mAccessibilityManager.isEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.514 -0400", hash_original_method = "3EBD42CE7AD44788B8B5975E509C0AD4", hash_generated_method = "6430AC1E6ACAAA4B282708CE6E24FA0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.514 -0400", hash_original_method = "B38BF7B18A0D0C0D14C2E79D97568CE9", hash_generated_method = "FAC2CD6D88CE2CBA23C83AAB105F610D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeSendWindowContentChangedCallback() {
        {
            removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent != null) {
            //removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.515 -0400", hash_original_method = "3A017950A97502A630256434B0EBF7E8", hash_generated_method = "04218D67179E86E6C11F7997AEC035A5")
    @DSModeled(DSC.SAFE)
    public boolean showContextMenuForChild(View originalView) {
        dsTaint.addTaint(originalView.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.515 -0400", hash_original_method = "492AE6A9C9C6F2F7E659E19901E3E487", hash_generated_method = "37EF7EFD78D2751B35803EDD91A27F97")
    @DSModeled(DSC.SAFE)
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(originalView.dsTaint);
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.515 -0400", hash_original_method = "FB735C9133B887C07751FC797F168B65", hash_generated_method = "6EF67E772CC4ECB02F323B23CB09ED9D")
    @DSModeled(DSC.SAFE)
    public void createContextMenu(ContextMenu menu) {
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.515 -0400", hash_original_method = "C40FC95C25B6655ACCA9227D471DC892", hash_generated_method = "76DAA2BB90BF7B3BAC25A29811DCA6AF")
    @DSModeled(DSC.SAFE)
    public void childDrawableStateChanged(View child) {
        dsTaint.addTaint(child.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.515 -0400", hash_original_method = "975E17A58706A43B9CF06D84428C706E", hash_generated_method = "0D14280ACAEA322C646244A1BD44E532")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.516 -0400", hash_original_method = "C963D9A99CD7BE986B275021EA99CB95", hash_generated_method = "5D8EAA13DE13204DEBE898A7EC03204A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkThread() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_1676836453 = (mThread != Thread.currentThread());
            {
                if (DroidSafeAndroidRuntime.control) throw new CalledFromWrongThreadException(
                    "Only the original thread that created a view hierarchy can touch its views.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //throw new CalledFromWrongThreadException(
                    //"Only the original thread that created a view hierarchy can touch its views.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.516 -0400", hash_original_method = "F9834E22E1AF22274F19B27CD50E21E5", hash_generated_method = "3E9AD34D006FD1DEA8A131CC998E60E0")
    @DSModeled(DSC.SAFE)
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        dsTaint.addTaint(disallowIntercept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.516 -0400", hash_original_method = "176476ED7A31EA7594378C530DAA6036", hash_generated_method = "96EB952B4EFE45615163C9D5C605A0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
        boolean var01DB072A3F092F21B9D32C2DD4D3AD8E_167791719 = (scrollToRectOrFocus(rectangle, immediate));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return scrollToRectOrFocus(rectangle, immediate);
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.516 -0400", hash_original_method = "7D52580C54DDC128EB596C63281BD2B7", hash_generated_method = "7D52580C54DDC128EB596C63281BD2B7")
                public ResizedInfo ()
        {
        }


    }


    
    static final class SystemUiVisibilityInfo {
        int seq;
        int globalVisibility;
        int localValue;
        int localChanges;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.517 -0400", hash_original_method = "3DB2F829FF9D37653AE63A451E83F000", hash_generated_method = "3DB2F829FF9D37653AE63A451E83F000")
                public SystemUiVisibilityInfo ()
        {
        }


    }


    
    static class InputEventMessage {
        Message mMessage;
        InputEventMessage mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.517 -0400", hash_original_method = "B714885B0648B0EB69373E467D5A2ACF", hash_generated_method = "3F3039D9C1B597EA1CE738EB6A52BE59")
        @DSModeled(DSC.SAFE)
        private InputEventMessage(Message m) {
            dsTaint.addTaint(m.dsTaint);
            mNext = null;
            // ---------- Original Method ----------
            //mMessage = m;
            //mNext = null;
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.518 -0400", hash_original_method = "9F2D00AD0B3B7E97E6983E3E4DE01E8D", hash_generated_method = "FF5788078DC74AE3CD4E25C6ECEF7407")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void recycle() {
            mMessage.recycle();
            {
                {
                    mNext = sPool;
                    sPool = this;
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

        
        private static final Object sPoolSync = new Object();
        private static InputEventMessage sPool;
        private static int sPoolSize = 0;
        private static final int MAX_POOL_SIZE = 10;
    }


    
    class TakenSurfaceHolder extends BaseSurfaceHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.519 -0400", hash_original_method = "BE7AEC21DA34F9EEEB4800B7E4DC3016", hash_generated_method = "BE7AEC21DA34F9EEEB4800B7E4DC3016")
                public TakenSurfaceHolder ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.530 -0400", hash_original_method = "93900AD5EB4A5A0D65615E175C2FC0CA", hash_generated_method = "927B27AC494CB31DA34169FF09626FF3")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean onAllowLockCanvas() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDrawingAllowed;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.530 -0400", hash_original_method = "CAFD67152D224915C2628F6ACAAF5E06", hash_generated_method = "769E8A917A2AE0CACCF50C3D308C76DF")
        @DSModeled(DSC.SAFE)
        @Override
        public void onRelayoutContainer() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.530 -0400", hash_original_method = "E07C2927AF02C0614ECCFDEAF72047C2", hash_generated_method = "F7479ED428158182342272E3F749F7A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setFormat(int format) {
            dsTaint.addTaint(format);
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.530 -0400", hash_original_method = "EE34E0B82BE2B114D60991753727E9A6", hash_generated_method = "2B5F0281D3E6CA5A0E9E2A9A85601CA8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setType(int type) {
            dsTaint.addTaint(type);
            ((RootViewSurfaceTaker)mView).setSurfaceType(type);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceType(type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.531 -0400", hash_original_method = "65C8D4CF87AA6164C88CB73B7231A722", hash_generated_method = "F372C0B52A7977F3E6CD7075DE72C5D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onUpdateSurface() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Shouldn't be here");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Shouldn't be here");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.532 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "B19D481E062842C6A40151D647C40C32")
        @DSModeled(DSC.SAFE)
        public boolean isCreating() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsCreating;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.532 -0400", hash_original_method = "DFAAE278D74727ACF1AA5508094F804D", hash_generated_method = "F88EE69062D1DD6F5CA61B68695C3299")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setFixedSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                    "Currently only support sizing from layout");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException(
                    //"Currently only support sizing from layout");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.532 -0400", hash_original_method = "21F6CF6D8B53BD856057ED05ABC33177", hash_generated_method = "A77C70F70B6FB73952C8DFF1F790F167")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setKeepScreenOn(boolean screenOn) {
            dsTaint.addTaint(screenOn);
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
        }

        
    }


    
    static class InputMethodCallback extends IInputMethodCallback.Stub {
        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.532 -0400", hash_original_method = "54191F901FEF749694D67ED7BF80E958", hash_generated_method = "422A66EE636ED223E5B865B2FD072679")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputMethodCallback(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.533 -0400", hash_original_method = "BE17249E230FCA094C5B0C5E3A1F0AA4", hash_generated_method = "C71C1543FE0FD048993610BE8B013535")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finishedEvent(int seq, boolean handled) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(handled);
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.534 -0400", hash_original_method = "93549AC7AA704598E881A2A0D800AB4C", hash_generated_method = "E950473C27EA146EC894AC858472F23A")
        @DSModeled(DSC.SAFE)
        public void sessionCreated(IInputMethodSession session) {
            dsTaint.addTaint(session.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    static class W extends IWindow.Stub {
        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.534 -0400", hash_original_method = "D1CF0E60435976F2AA38BD5BC7DA8E27", hash_generated_method = "81EE98283715D68BD647D1EFCBB6EA20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         W(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.534 -0400", hash_original_method = "A648B76CE506B7CD274906DE238C17D8", hash_generated_method = "724418E2A03E9D2CCC62FF5915AE79ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void resized(int w, int h, Rect coveredInsets, Rect visibleInsets,
                boolean reportDraw, Configuration newConfig) {
            dsTaint.addTaint(w);
            dsTaint.addTaint(visibleInsets.dsTaint);
            dsTaint.addTaint(reportDraw);
            dsTaint.addTaint(newConfig.dsTaint);
            dsTaint.addTaint(coveredInsets.dsTaint);
            dsTaint.addTaint(h);
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.534 -0400", hash_original_method = "EB98E21C67C8D9A44F58CD671F491CDA", hash_generated_method = "8E81C10BF207D30DFB25FDAE4B77FF7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchAppVisibility(boolean visible) {
            dsTaint.addTaint(visible);
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.535 -0400", hash_original_method = "5CE742A9FFA814199F790759E49D980E", hash_generated_method = "5863AD4219353E1F1C1357C0F6710B31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchGetNewSurface() {
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.535 -0400", hash_original_method = "294D771D49852BEC83940B0D8623D316", hash_generated_method = "57A7E6C3A29BD4B231FFFD97F84B08BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
            dsTaint.addTaint(inTouchMode);
            dsTaint.addTaint(hasFocus);
            ViewRootImpl viewAncestor;
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

        
                private static int checkCallingPermission(String permission) {
            try {
                return ActivityManagerNative.getDefault().checkPermission(
                        permission, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e) {
                return PackageManager.PERMISSION_DENIED;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.535 -0400", hash_original_method = "BAC64B61AF453BEA5AB28D214B8FF7C5", hash_generated_method = "046E9A71B53E0B9EAB31CB7F0E623F97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            dsTaint.addTaint(command);
            dsTaint.addTaint(parameters);
            dsTaint.addTaint(out.dsTaint);
            ViewRootImpl viewAncestor;
            viewAncestor = mViewAncestor.get();
            {
                View view;
                view = viewAncestor.mView;
                {
                    {
                        boolean varD985B2C74752F819AC5BC1C5B2498154_1277644226 = (checkCallingPermission(Manifest.permission.DUMP) !=
                            PackageManager.PERMISSION_GRANTED);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Insufficient permissions to invoke"
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.536 -0400", hash_original_method = "0341134904B032AC1241DC2205E79E01", hash_generated_method = "F00EA8B5915637C6D9E215038CA9474B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void closeSystemDialogs(String reason) {
            dsTaint.addTaint(reason);
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.536 -0400", hash_original_method = "0D1309853D34ED0E4A19A33B54F85778", hash_generated_method = "D40E286C50DEADD449BDAEB4DA4EFFE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep,
                boolean sync) {
            dsTaint.addTaint(sync);
            dsTaint.addTaint(xStep);
            dsTaint.addTaint(yStep);
            dsTaint.addTaint(y);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.537 -0400", hash_original_method = "084CB00632E8F4F79253F4CBB0703969", hash_generated_method = "B16E598FE4DFF8234E1F2F1F05036483")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchWallpaperCommand(String action, int x, int y,
                int z, Bundle extras, boolean sync) {
            dsTaint.addTaint(sync);
            dsTaint.addTaint(action);
            dsTaint.addTaint(z);
            dsTaint.addTaint(y);
            dsTaint.addTaint(extras.dsTaint);
            dsTaint.addTaint(x);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.537 -0400", hash_original_method = "AE33DC8C57E72B3B1EEF7B37E6DC4CB6", hash_generated_method = "71CD8A126EA05001882A1346A50733FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchDragEvent(DragEvent event) {
            dsTaint.addTaint(event.dsTaint);
            ViewRootImpl viewAncestor;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.537 -0400", hash_original_method = "0BC30404A661769E03F23017D2DE8196", hash_generated_method = "9F9F06CC62A3806325A85BBEBF825FB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
                int localValue, int localChanges) {
            dsTaint.addTaint(localChanges);
            dsTaint.addTaint(localValue);
            dsTaint.addTaint(seq);
            dsTaint.addTaint(globalVisibility);
            ViewRootImpl viewAncestor;
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
        float position;
        float absPosition;
        float acceleration = 1;
        long lastMoveTime = 0;
        int step;
        int dir;
        int nonAccelMovement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.538 -0400", hash_original_method = "0C7EA154951275F23E03090A437C7470", hash_generated_method = "0C7EA154951275F23E03090A437C7470")
                public TrackballAxis ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.538 -0400", hash_original_method = "A6304CADA1EF057D91BA6FF70064FCCC", hash_generated_method = "7F66D824896F9EC49911D2757E29C942")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.540 -0400", hash_original_method = "7BE12B55CFE54AFD4A89AB866136213C", hash_generated_method = "482B84D601C2FD6CE8B7C8E64C9FAEB4")
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
            float var529C98EBF363E511405F79C0EF23EDF4_1269042428 = ((absPosition = Math.abs(position)));
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.540 -0400", hash_original_method = "94A3484B43A305FA2D2533E09119590B", hash_generated_method = "03F7D2FDBF1955150F9E447E269856E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int generate(float precision) {
            dsTaint.addTaint(precision);
            int movement;
            movement = 0;
            nonAccelMovement = 0;
            {
                int dir;
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

        
        static final float MAX_ACCELERATION = 20;
        static final long FAST_MOVE_TIME = 150;
        static final float ACCEL_MOVE_SCALING_FACTOR = (1.0f/40);
    }


    
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.541 -0400", hash_original_method = "D704015D17B148E0274888D3BE6B5A1B", hash_generated_method = "351D9F06991D6268850B166BB1F5470F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CalledFromWrongThreadException(String msg) {
            super(msg);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    static final class RunQueue {
        private ArrayList<HandlerAction> mActions = new ArrayList<HandlerAction>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.541 -0400", hash_original_method = "730D61418A59D28F8EF9F56EB0F266F2", hash_generated_method = "730D61418A59D28F8EF9F56EB0F266F2")
                public RunQueue ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.541 -0400", hash_original_method = "D30AD5886AAB6A1562A9D91A9C03E0DF", hash_generated_method = "4341E85CDCF94E57CCE50CE5220661A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void post(Runnable action) {
            dsTaint.addTaint(action.dsTaint);
            postDelayed(action, 0);
            // ---------- Original Method ----------
            //postDelayed(action, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.541 -0400", hash_original_method = "37D90AC712BBF73BCC19C8079034F8F1", hash_generated_method = "0AE9E542A07DD0547DB2DD5E051EDDDA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.541 -0400", hash_original_method = "5BA3715297222A78241D425B9BCC6DE7", hash_generated_method = "6762828BD71C7B2C783B3C53EF210257")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void removeCallbacks(Runnable action) {
            dsTaint.addTaint(action.dsTaint);
            HandlerAction handlerAction;
            handlerAction = new HandlerAction();
            handlerAction.action = action;
            {
                ArrayList<HandlerAction> actions;
                actions = mActions;
                {
                    boolean var36C1E9EF466D02D50DB2A2AD92DBF5C4_1357858090 = (actions.remove(handlerAction));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "3626F7B757A14315643B29FE9818088B", hash_generated_method = "172BADB6E44193B430C2D009DE9ED84B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void executeActions(Handler handler) {
            dsTaint.addTaint(handler.dsTaint);
            {
                ArrayList<HandlerAction> actions;
                actions = mActions;
                int count;
                count = actions.size();
                {
                    int i;
                    i = 0;
                    {
                        HandlerAction handlerAction;
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "0DE2CBF151F21CA3713C9C205746B980", hash_generated_method = "0DE2CBF151F21CA3713C9C205746B980")
                        public HandlerAction ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "EC304D8CC82834BC90F0FBE66AB5A5B9", hash_generated_method = "FAD81BA70E783B7EBF2E1777C76689E7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean equals(Object o) {
                dsTaint.addTaint(o.dsTaint);
                {
                    boolean var282528ACEB1CC10074B7BD702EFB8F50_393454939 = (o == null || getClass() != o.getClass());
                } //End collapsed parenthetic
                HandlerAction that;
                that = (HandlerAction) o;
                boolean varB89771406AB9E6A784E553026517A2DD_126026144 = (!(action != null ? !action.equals(that.action) : that.action != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (this == o) return true;
                //if (o == null || getClass() != o.getClass()) return false;
                //HandlerAction that = (HandlerAction) o;
                //return !(action != null ? !action.equals(that.action) : that.action != null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "09AD30FBB7C8AE284E2A2DAD39966BF7", hash_generated_method = "56C924A2F5D91D7B4A78C722678882AC")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "0E0F0B889EDBA451E8DD07CBC8B11C51", hash_generated_method = "0E0F0B889EDBA451E8DD07CBC8B11C51")
                public AccessibilityInteractionConnectionManager ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.542 -0400", hash_original_method = "8A20E0BF76F2FE3CB2E135C12DE9692E", hash_generated_method = "7E0474A8E6D40076CA9D22C959B61D8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.543 -0400", hash_original_method = "92A9A6CA8F5EA055DBA3D736397E37E0", hash_generated_method = "1224EF239655CE7CC401F03EBEF1D3EA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void ensureConnection() {
            boolean registered;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.543 -0400", hash_original_method = "C22E99B1A3881672FEB45F6BE843B278", hash_generated_method = "A2333ED83AF0D8414333FB37BE8C96C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void ensureNoConnection() {
            boolean registered;
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
        private WeakReference<ViewRootImpl> mRootImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.543 -0400", hash_original_method = "D539A7CCB822AF3CDF20BB7941121D94", hash_generated_method = "A3B3331665FC951DFE18E145985956FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AccessibilityInteractionConnection(ViewRootImpl viewAncestor) {
            dsTaint.addTaint(viewAncestor.dsTaint);
            mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.543 -0400", hash_original_method = "EE5D719A51240BF55D02CDA16E5D3A9D", hash_generated_method = "569D619336E365FAFDB9D958DA4083DB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.544 -0400", hash_original_method = "150D2C0671760B2C49B4A2BEA648BFF0", hash_generated_method = "7962E12221A6901C1C6D996C3C18F8DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void performAccessibilityAction(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(action);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.544 -0400", hash_original_method = "480C93EC256597CABC1B248D841B9A3E", hash_generated_method = "0B2C578822855E534A5772255D0A9C9F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.544 -0400", hash_original_method = "9891EE3B36B5E5E829B36E62164827F4", hash_generated_method = "6003CB248BBC29B7395E3CA9307A9A4F")
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
        private ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList =
            new ArrayList<AccessibilityNodeInfo>();
        private Pool<SomeArgs> mPool = Pools.synchronizedPool(Pools.finitePool(
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.544 -0400", hash_original_method = "CD08215D84712BF4DE587CBEBB75CEF8", hash_generated_method = "CD08215D84712BF4DE587CBEBB75CEF8")
                public AccessibilityInteractionController ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.544 -0400", hash_original_method = "2F6D3BCB232629523E59C738D4AD3A95", hash_generated_method = "ABEFF45DCB6EE41C3D60DC4170CFAFBE")
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
                boolean var8107759D1151D3101276FAAE5511E68D_946373185 = (interrogatingPid == Process.myPid()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.545 -0400", hash_original_method = "145D07D178B3372CAAF2CB93D024125F", hash_generated_method = "314AEB65093C3A800289899A7F894278")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            int accessibilityId;
            accessibilityId = message.arg1;
            int interactionId;
            interactionId = message.arg2;
            IAccessibilityInteractionConnectionCallback callback;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.545 -0400", hash_original_method = "ADA0B35A4DB3EC9F459DCBB8D66C434D", hash_generated_method = "B1E3EAA5D5260C2E8CA3881347FAA905")
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
                boolean var8107759D1151D3101276FAAE5511E68D_2056288274 = (interrogatingPid == Process.myPid()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.546 -0400", hash_original_method = "6B2A3077FB5BC3E815A1727E6C950B5E", hash_generated_method = "53E802471B01E597B8BDEC9CE8F47379")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            int viewId;
            viewId = message.arg1;
            int interactionId;
            interactionId = message.arg2;
            IAccessibilityInteractionConnectionCallback callback;
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
                    boolean varAD6C034A8B4788EA6598018C4A7CCA13_1608787328 = (target != null && target.getVisibility() == View.VISIBLE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.546 -0400", hash_original_method = "74A990105163D5D10216C3B475062D28", hash_generated_method = "9A5710647BA1BDE0D954FE7F41053F02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfosByViewTextClientThread(String text,
                int accessibilityViewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(interrogatingPid);
            dsTaint.addTaint(accessibilityViewId);
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
                boolean var8107759D1151D3101276FAAE5511E68D_515136285 = (interrogatingPid == Process.myPid()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.547 -0400", hash_original_method = "51BC2DACC971DA52CB7F7912294499A7", hash_generated_method = "DB0CAB3A2A7E7CAD10AD5AE54C32A7B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void findAccessibilityNodeInfosByViewTextUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            SomeArgs args;
            args = (SomeArgs) message.obj;
            String text;
            text = (String) args.arg1;
            int accessibilityViewId;
            accessibilityViewId = args.argi1;
            int interactionId;
            interactionId = args.argi2;
            IAccessibilityInteractionConnectionCallback callback;
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
                    boolean var9C0D384BF3EBA7F37FDD9A142533A8EE_993651693 = (root == null || root.getVisibility() != View.VISIBLE);
                } //End collapsed parenthetic
                root.findViewsWithText(foundViews, text, View.FIND_VIEWS_WITH_TEXT
                        | View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                {
                    boolean var8A7BFE1EB8C1A34CA2C8E115CC06AAA3_645166749 = (foundViews.isEmpty());
                } //End collapsed parenthetic
                infos = mTempAccessibilityNodeInfoList;
                infos.clear();
                int viewCount;
                viewCount = foundViews.size();
                {
                    int i;
                    i = 0;
                    {
                        View foundView;
                        foundView = foundViews.get(i);
                        {
                            boolean var8598062468ACAD090E81AB592F4F32E5_628833746 = (foundView.getVisibility() == View.VISIBLE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.547 -0400", hash_original_method = "10A09FD4DC34F1BE42EB309D47EC9715", hash_generated_method = "B725F064AB822357491BE28BBADD1E0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void performAccessibilityActionClientThread(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            dsTaint.addTaint(accessibilityId);
            dsTaint.addTaint(interactionId);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(action);
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
                boolean varBA474D4A1DE421276FA94C5F81C7FD11_746695972 = (interogatingPid == Process.myPid()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.547 -0400", hash_original_method = "B5557005BEFFE1DA9F706439FD376D18", hash_generated_method = "0F7850BFCE662AA4D0BA371CEFDCB7B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void perfromAccessibilityActionUiThread(Message message) {
            dsTaint.addTaint(message.dsTaint);
            SomeArgs args;
            args = (SomeArgs) message.obj;
            int accessibilityId;
            accessibilityId = args.argi1;
            int action;
            action = args.argi2;
            int interactionId;
            interactionId = args.argi3;
            IAccessibilityInteractionConnectionCallback callback;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.548 -0400", hash_original_method = "0DF709A77C91001270CD6D5BCBC66D0E", hash_generated_method = "75ECF1EAF002B7E84AD174516C2A679B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionFocus(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_2000650918 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            ensureTouchMode(false);
            boolean var0F57617D4E8F9359CC9AD7E4CA12AF24_75674808 = (target.requestFocus());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //ensureTouchMode(false);
            //return target.requestFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.548 -0400", hash_original_method = "7E9614B48F5F4EC29BCF64D3A075976C", hash_generated_method = "19A6C736FF0CC05B43DC74F54CC566F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionClearFocus(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_177460092 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean var85D47F37C8A8E496A11CE0CD99470B85_390657285 = (!target.isFocused());
            } //End collapsed parenthetic
            target.clearFocus();
            boolean var6B4E7E773AB55FC14DC5D0B1ACCA65EC_76332425 = (!target.isFocused());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.548 -0400", hash_original_method = "AB7AA9516F9E78D5A5AD4BBEB80A41A0", hash_generated_method = "02BAB2B487A22572CD974931EC6DE061")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionSelect(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_1345550251 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varB0F56BADB6D848BC74C2EB6E3BAB7BCC_2100609691 = (target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(true);
            boolean varE49BAE8F367158D1AAA608101541F1A5_2098321952 = (target.isSelected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.548 -0400", hash_original_method = "E102B39F5DF94C3320BE2ED1E2D3B323", hash_generated_method = "D1838A11DC9B2C811DF76897B0A93BA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean performActionClearSelection(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View target;
            target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_1784298910 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varCEA2FEA7AB8ACAC93A58D6FAF61E7763_1924699510 = (!target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(false);
            boolean varDE00FAE324BEAA0EBABFEB29089F51C8_940533578 = (!target.isSelected());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "B9D971669B3F873AC0D1B0C38F7811F4", hash_generated_method = "25A128CB1419130CAB0992219B7A2729")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private View findViewByAccessibilityId(int accessibilityId) {
            dsTaint.addTaint(accessibilityId);
            View root;
            root = ViewRootImpl.this.mView;
            View foundView;
            foundView = root.findViewByAccessibilityId(accessibilityId);
            {
                boolean varB5E3FDDC281E79B82F6D09E4AAD9E0FF_96780595 = (foundView != null && foundView.getVisibility() != View.VISIBLE);
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "1DC11EC4B8DE02C86752DC3C92AC9A78", hash_generated_method = "1DC11EC4B8DE02C86752DC3C92AC9A78")
                        public SomeArgs ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "BEE0522D727ED0DB1FBC81A3E3B176C5", hash_generated_method = "0CFBBE17AC04A00389A73588A7CDAB9D")
            @DSModeled(DSC.SAFE)
            public SomeArgs getNextPoolable() {
                return (SomeArgs)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return mNext;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "5D15E99725D43744F3178673C8B6AC3C")
            @DSModeled(DSC.SAFE)
            public boolean isPooled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "B595989EA0DDF2662B95D2584CF9AF77", hash_generated_method = "34A59A063D3BEAA8B0B630A03A52B960")
            @DSModeled(DSC.SAFE)
            public void setNextPoolable(SomeArgs args) {
                dsTaint.addTaint(args.dsTaint);
                // ---------- Original Method ----------
                //mNext = args;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.549 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "A19BE98D20006B14A3686F1F697F4E6E")
            @DSModeled(DSC.SAFE)
            public void setPooled(boolean isPooled) {
                dsTaint.addTaint(isPooled);
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.550 -0400", hash_original_method = "95D0476EAE9CBD3221945617281C6DDB", hash_generated_method = "316EB695B735DFEA458AF811F180A884")
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


        
        private static final int POOL_SIZE = 5;
    }


    
    private class SendWindowContentChangedAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.550 -0400", hash_original_method = "3D33A525D782F79581D1C32458A63511", hash_generated_method = "3D33A525D782F79581D1C32458A63511")
                public SendWindowContentChangedAccessibilityEvent ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.550 -0400", hash_original_method = "3411919DDECDF923DB080425515AE494", hash_generated_method = "47C531BB66138CE208DE726513162DE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
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
}

