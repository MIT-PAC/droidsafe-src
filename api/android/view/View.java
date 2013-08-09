package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.ScrollBarDrawable;

import com.android.internal.R;
import com.android.internal.util.Predicate;






public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
    private SparseArray<Object> mKeyedTags;
    protected Animation mCurrentAnimation = null;
    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredWidth;
    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredHeight;
    boolean mRecreateDisplayList = false;
    @ViewDebug.ExportedProperty(resolveId = true)
    int mID = NO_ID;
    int mAccessibilityViewId = NO_ID;
    protected Object mTag;
    private int mOverScrollMode;
    protected ViewParent mParent;
    AttachInfo mAttachInfo;
    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = FORCE_LAYOUT, equals = FORCE_LAYOUT,
                name = "FORCE_LAYOUT"),
        @ViewDebug.FlagToString(mask = LAYOUT_REQUIRED, equals = LAYOUT_REQUIRED,
                name = "LAYOUT_REQUIRED"),
        @ViewDebug.FlagToString(mask = DRAWING_CACHE_VALID, equals = DRAWING_CACHE_VALID,
            name = "DRAWING_CACHE_INVALID", outputIf = false),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "DRAWN", outputIf = true),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "NOT_DRAWN", outputIf = false),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY_OPAQUE, name = "DIRTY_OPAQUE"),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY, name = "DIRTY")
    })
    int mPrivateFlags;
    int mPrivateFlags2;
    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_LOW_PROFILE,
                                equals = SYSTEM_UI_FLAG_LOW_PROFILE,
                                name = "SYSTEM_UI_FLAG_LOW_PROFILE", outputIf = true),
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                equals = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                name = "SYSTEM_UI_FLAG_HIDE_NAVIGATION", outputIf = true),
        @ViewDebug.FlagToString(mask = PUBLIC_STATUS_BAR_VISIBILITY_MASK,
                                equals = SYSTEM_UI_FLAG_VISIBLE,
                                name = "SYSTEM_UI_FLAG_VISIBLE", outputIf = true)
    })
    int mSystemUiVisibility;
    int mWindowAttachCount;
    protected ViewGroup.LayoutParams mLayoutParams;
    @ViewDebug.ExportedProperty
    int mViewFlags;
    TransformationInfo mTransformationInfo;
    private boolean mLastIsOpaque;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mLeft;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mRight;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mTop;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mBottom;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollX;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollY;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingTop;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingBottom;
    private CharSequence mContentDescription;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingBottom;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding")
    boolean mUserPaddingRelative;
    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingStart;
    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingEnd;
    int mOldWidthMeasureSpec = Integer.MIN_VALUE;
    int mOldHeightMeasureSpec = Integer.MIN_VALUE;
    private Drawable mBGDrawable;
    private int mBackgroundResource;
    private boolean mBackgroundSizeChanged;
    ListenerInfo mListenerInfo;
    protected Context mContext;
    private final Resources mResources;
    private ScrollabilityCache mScrollCache;
    private int[] mDrawableState = null;
    public boolean mCachingFailed;
    private Bitmap mDrawingCache;
    private Bitmap mUnscaledDrawingCache;
    private HardwareLayer mHardwareLayer;
    DisplayList mDisplayList;
    private int mNextFocusLeftId = View.NO_ID;
    private int mNextFocusRightId = View.NO_ID;
    private int mNextFocusUpId = View.NO_ID;
    private int mNextFocusDownId = View.NO_ID;
    int mNextFocusForwardId = View.NO_ID;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap = null;
    private PerformClick mPerformClick;
    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
    private UnsetPressedState mUnsetPressedState;
    private boolean mHasPerformedLongPress;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinHeight;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinWidth;
    private TouchDelegate mTouchDelegate = null;
    private int mDrawingCacheBackgroundColor = 0;
    private ViewTreeObserver mFloatingTreeObserver;
    private int mTouchSlop;
    private ViewPropertyAnimator mAnimator = null;
    private float mVerticalScrollFactor;
    private int mVerticalScrollbarPosition;
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
            @ViewDebug.IntToString(from = LAYER_TYPE_NONE, to = "NONE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_SOFTWARE, to = "SOFTWARE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_HARDWARE, to = "HARDWARE")
    })
    int mLayerType = LAYER_TYPE_NONE;
    Paint mLayerPaint;
    Rect mLocalDirtyRect;
    private boolean mSendingHoverAccessibilityEvents;
    AccessibilityDelegate mAccessibilityDelegate;
    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    })
    private int mTextDirection = DEFAULT_TEXT_DIRECTION;
    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    })
    private int mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSModeled(DSC.SAFE)
	public View(Context context){
		mContext = context;
		onSizeChanged(0,0,0,0);
        onDraw(new Canvas());
        mResources = context.getResources();
        mKeyedTags = new SparseArray<Object>();
		/*
		mContext = context;
		mResources = context != null ? context.getResources() : null;
		mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
		mUserPaddingStart = -1;
		mUserPaddingEnd = -1;
		mUserPaddingRelative = false;
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public View(Context context, AttributeSet attrs){
		this(context, attrs, 0);
	}

    
    @DSModeled(DSC.SAFE)
	public View(Context context, AttributeSet attrs, int defStyle){
		this(context);
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    @DSModeled(DSC.SAFE)
	View(){
		mResources = null;
		/*
		mResources = null;
		*/
	}

    
    @DSModeled(DSC.SAFE)
    protected void initializeFadingEdge(TypedArray a){
		// Original method
		/*
		{
        initScrollCache();
        mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                R.styleable.View_fadingEdgeLength,
                ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getVerticalFadingEdgeLength(){
		// Original method
		/*
		{
        if (isVerticalFadingEdgeEnabled()) {
            ScrollabilityCache cache = mScrollCache;
            if (cache != null) {
                return cache.fadingEdgeLength;
            }
        }
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public void setFadingEdgeLength(int length){
		// Original method
		/*
		{
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getHorizontalFadingEdgeLength(){
		// Original method
		/*
		{
        if (isHorizontalFadingEdgeEnabled()) {
            ScrollabilityCache cache = mScrollCache;
            if (cache != null) {
                return cache.fadingEdgeLength;
            }
        }
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public int getVerticalScrollbarWidth(){
		// Original method
		/*
		{
        ScrollabilityCache cache = mScrollCache;
        if (cache != null) {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            if (scrollBar != null) {
                int size = scrollBar.getSize(true);
                if (size <= 0) {
                    size = cache.scrollBarSize;
                }
                return size;
            }
            return 0;
        }
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int getHorizontalScrollbarHeight(){
		// Original method
		/*
		{
        ScrollabilityCache cache = mScrollCache;
        if (cache != null) {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            if (scrollBar != null) {
                int size = scrollBar.getSize(false);
                if (size <= 0) {
                    size = cache.scrollBarSize;
                }
                return size;
            }
            return 0;
        }
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected void initializeScrollbars(TypedArray a){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void initScrollCache(){
		// Original method
		/*
		{
        if (mScrollCache == null) {
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setVerticalScrollbarPosition(int position){
		// Original method
		/*
		{
        if (mVerticalScrollbarPosition != position) {
            mVerticalScrollbarPosition = position;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getVerticalScrollbarPosition(){
		return getTaintInt();
		// Original method
		/*
		{
        return mVerticalScrollbarPosition;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    ListenerInfo getListenerInfo(){
            if (mListenerInfo != null) {
                return mListenerInfo;
            }
            mListenerInfo = new ListenerInfo();
            return mListenerInfo;
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnFocusChangeListener(OnFocusChangeListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnFocusChangeListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = getListenerInfo();
        if (li.mOnLayoutChangeListeners == null) {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        }
        if (!li.mOnLayoutChangeListeners.contains(listener)) {
            li.mOnLayoutChangeListeners.add(listener);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li == null || li.mOnLayoutChangeListeners == null) {
            return;
        }
        li.mOnLayoutChangeListeners.remove(listener);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = getListenerInfo();
        if (li.mOnAttachStateChangeListeners == null) {
            li.mOnAttachStateChangeListeners
                    = new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        }
        li.mOnAttachStateChangeListeners.add(listener);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li == null || li.mOnAttachStateChangeListeners == null) {
            return;
        }
        li.mOnAttachStateChangeListeners.remove(listener);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public OnFocusChangeListener getOnFocusChangeListener(){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        return li != null ? li.mOnFocusChangeListener : null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public void setOnClickListener(OnClickListener l){
		l.onClick(this);
		// Original method
		/*
		{
        if (!isClickable()) {
            setClickable(true);
        }
        getListenerInfo().mOnClickListener = l;
    }
		*/
		//Return nothing
	}
	
	@DSModeled(DSC.SAFE)
	public boolean hasOnClickListeners(){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        return (li != null && li.mOnClickListener != null);
    }
		*/
		return false;
	}
	
	@DSModeled(DSC.SAFE)
	public void setOnLongClickListener(OnLongClickListener l){
		// Original method
		/*
		{
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        getListenerInfo().mOnLongClickListener = l;
    }
		*/
		//Return nothing
		l.onLongClick(this);
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l){
		// Original method
		/*
		{
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        getListenerInfo().mOnCreateContextMenuListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean performClick(){
		// Original method
		/*
		{
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnClickListener != null) {
            playSoundEffect(SoundEffectConstants.CLICK);
            li.mOnClickListener.onClick(this);
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean callOnClick(){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnClickListener != null) {
            li.mOnClickListener.onClick(this);
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean performLongClick(){
		// Original method
		/*
		{
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        boolean handled = false;
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnLongClickListener != null) {
            handled = li.mOnLongClickListener.onLongClick(View.this);
        }
        if (!handled) {
            handled = showContextMenu();
        }
        if (handled) {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }
        return handled;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    protected boolean performButtonActionOnTouchDown(MotionEvent event){
		// Original method
		/*
		{
        if ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0) {
            if (showContextMenu(event.getX(), event.getY(), event.getMetaState())) {
                return true;
            }
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
	public boolean showContextMenu(){
		// Original method
		/*
		{
        return getParent().showContextMenuForChild(this);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    public boolean showContextMenu(float x, float y, int metaState){
		// Original method
		/*
		{
        return showContextMenu();
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public ActionMode startActionMode(ActionMode.Callback callback){
		// Original method
		/*
		{
        return getParent().startActionModeForChild(this, callback);
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnKeyListener(OnKeyListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnKeyListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnTouchListener(OnTouchListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnTouchListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnGenericMotionListener(OnGenericMotionListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnGenericMotionListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnHoverListener(OnHoverListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnHoverListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setOnDragListener(OnDragListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnDragListener = l;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void handleFocusGainInternal(int direction, Rect previouslyFocusedRect){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " requestFocus()");
        }
        if ((mPrivateFlags & FOCUSED) == 0) {
            mPrivateFlags |= FOCUSED;
            if (mParent != null) {
                mParent.requestChildFocus(this, this);
            }
            onFocusChanged(true, direction, previouslyFocusedRect);
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean requestRectangleOnScreen(Rect rectangle){
		// Original method
		/*
		{
        return requestRectangleOnScreen(rectangle, false);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate){
		// Original method
		/*
		{
        View child = this;
        ViewParent parent = mParent;
        boolean scrolled = false;
        while (parent != null) {
            scrolled |= parent.requestChildRectangleOnScreen(child,
                    rectangle, immediate);
            rectangle.offset(child.getLeft(), child.getTop());
            rectangle.offset(-child.getScrollX(), -child.getScrollY());
            if (!(parent instanceof View)) {
                break;
            }
            child = (View) parent;
            parent = child.getParent();
        }
        return scrolled;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void clearFocus(){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " clearFocus()");
        }
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            if (mParent != null) {
                mParent.clearChildFocus(this);
            }
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void clearFocusForRemoval(){
		// Original method
		/*
		{
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void unFocus(){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " unFocus()");
        }
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="focus") public boolean hasFocus(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean hasFocusable(){
		// Original method
		/*
		{
        return (mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable();
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void sendAccessibilityEvent(int eventType){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        } else {
            sendAccessibilityEventInternal(eventType);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void sendAccessibilityEventInternal(int eventType){
		// Original method
		/*
		{
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
           mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        } else {
            sendAccessibilityEventUncheckedInternal(event);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event){
		// Original method
		/*
		{
        if (!isShown()) {
            return;
        }
        onInitializeAccessibilityEvent(event);
        if ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0) {
            dispatchPopulateAccessibilityEvent(event);
        }
        getParent().requestSendAccessibilityEvent(this, event);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            return mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event);
        } else {
            return dispatchPopulateAccessibilityEventInternal(event);
        }
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
		/*
		{
        onPopulateAccessibilityEvent(event);
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void onPopulateAccessibilityEvent(AccessibilityEvent event){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        } else {
            onPopulateAccessibilityEventInternal(event);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void onPopulateAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onInitializeAccessibilityEvent(AccessibilityEvent event){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        } else {
            onInitializeAccessibilityEventInternal(event);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void onInitializeAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
		/*
		{
        event.setSource(this);
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        event.setEnabled(isEnabled());
        event.setContentDescription(mContentDescription);
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null) {
            ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
            getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    FOCUSABLES_ALL);
            event.setItemCount(focusablesTempList.size());
            event.setCurrentItemIndex(focusablesTempList.indexOf(this));
            focusablesTempList.clear();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public AccessibilityNodeInfo createAccessibilityNodeInfo(){
		// Original method
		/*
		{
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(info);
        return info;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        } else {
            onInitializeAccessibilityNodeInfoInternal(info);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setAccessibilityDelegate(AccessibilityDelegate delegate){
		mAccessibilityDelegate = delegate;
		// Original method
		/*
		{
        mAccessibilityDelegate = delegate;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public int getAccessibilityViewId(){
		return getTaintInt();
		// Original method
		/*
		{
        if (mAccessibilityViewId == NO_ID) {
            mAccessibilityViewId = sNextAccessibilityViewId++;
        }
        return mAccessibilityViewId;
    }
		*/
	}

    
    @DSModeled(DSC.BAN)
    public int getAccessibilityWindowId(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription(){
		return (CharSequence)getTaint();
		// Original method
		/*
		{
        return mContentDescription;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod public void setContentDescription(CharSequence contentDescription){
		mContentDescription = contentDescription;
		//addTaint(contentDescription.toString().getTaint());
		// Original method
		/*
		{
        mContentDescription = contentDescription;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    protected void onFocusLost(){
		// Original method
		/*
		{
        resetPressedState();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void resetPressedState(){
		// Original method
		/*
		{
        if ((mViewFlags & ENABLED_MASK) == DISABLED) {
            return;
        }
        if (isPressed()) {
            setPressed(false);
            if (!mHasPerformedLongPress) {
                removeLongPressCallback();
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="focus") public boolean isFocused(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public View findFocus(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0 ? this : null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void setScrollContainer(boolean isScrollContainer){
		// Original method
		/*
		{
        if (isScrollContainer) {
            if (mAttachInfo != null && (mPrivateFlags&SCROLL_CONTAINER_ADDED) == 0) {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            }
            mPrivateFlags |= SCROLL_CONTAINER;
        } else {
            if ((mPrivateFlags&SCROLL_CONTAINER_ADDED) != 0) {
                mAttachInfo.mScrollContainers.remove(this);
            }
            mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheQuality(){
		// Original method
		/*
		{
        return mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public void setDrawingCacheQuality(int quality){
		// Original method
		/*
		{
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean getKeepScreenOn(){
		// Original method
		/*
		{
        return (mViewFlags & KEEP_SCREEN_ON) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setKeepScreenOn(boolean keepScreenOn){
		// Original method
		/*
		{
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getNextFocusLeftId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusLeftId;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setNextFocusLeftId(int nextFocusLeftId){
		addTaint(nextFocusLeftId);
		// Original method
		/*
		{
        mNextFocusLeftId = nextFocusLeftId;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getNextFocusRightId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusRightId;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setNextFocusRightId(int nextFocusRightId){
		addTaint(nextFocusRightId);
		// Original method
		/*
		{
        mNextFocusRightId = nextFocusRightId;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getNextFocusUpId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusUpId;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setNextFocusUpId(int nextFocusUpId){
		addTaint(nextFocusUpId);
		// Original method
		/*
		{
        mNextFocusUpId = nextFocusUpId;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getNextFocusDownId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusDownId;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setNextFocusDownId(int nextFocusDownId){
		addTaint(nextFocusDownId);
		// Original method
		/*
		{
        mNextFocusDownId = nextFocusDownId;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getNextFocusForwardId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusForwardId;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setNextFocusForwardId(int nextFocusForwardId){
		addTaint(nextFocusForwardId);
		// Original method
		/*
		{
        mNextFocusForwardId = nextFocusForwardId;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isShown(){
		// Original method
		/*
		{
        View current = this;
        do {
            if ((current.mViewFlags & VISIBILITY_MASK) != VISIBLE) {
                return false;
            }
            ViewParent parent = current.mParent;
            if (parent == null) {
                return false; 
            }
            if (!(parent instanceof View)) {
                return true;
            }
            current = (View) parent;
        } while (current != null);
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean fitSystemWindows(Rect insets){
		// Original method
		/*
		{
        if ((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS) {
            mPaddingLeft = insets.left;
            mPaddingTop = insets.top;
            mPaddingRight = insets.right;
            mPaddingBottom = insets.bottom;
            requestLayout();
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setFitsSystemWindows(boolean fitSystemWindows){
		// Original method
		/*
		{
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean fitsSystemWindows(){
		// Original method
		/*
		{
        return (mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=VISIBLE,to="VISIBLE"),@ViewDebug.IntToString(from=INVISIBLE,to="INVISIBLE"),@ViewDebug.IntToString(from=GONE,to="GONE")}) 
	public int getVisibility(){
		// Original method
		/*
		{
        return mViewFlags & VISIBILITY_MASK;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
	@RemotableViewMethod 
	public void setVisibility(int visibility){
		addTaint(visibility);
		// Original method
		/*
		{
        setFlags(visibility, VISIBILITY_MASK);
        if (mBGDrawable != null) mBGDrawable.setVisible(visibility == VISIBLE, false);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & ENABLED_MASK) == ENABLED;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod 
	public void setEnabled(boolean enabled){
		// Original method
		/*
		{
        if (enabled == isEnabled()) return;
        setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        refreshDrawableState();
        invalidate(true);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setFocusable(boolean focusable){
		// Original method
		/*
		{
        if (!focusable) {
            setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        }
        setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setFocusableInTouchMode(boolean focusableInTouchMode){
		// Original method
		/*
		{
        setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        if (focusableInTouchMode) {
            setFlags(FOCUSABLE, FOCUSABLE_MASK);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled){
		// Original method
		/*
		{
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isSoundEffectsEnabled(){
		// Original method
		/*
		{
        return SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled){
		// Original method
		/*
		{
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isHapticFeedbackEnabled(){
		// Original method
		/*
		{
        return HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    @ViewDebug.ExportedProperty(category="layout",mapping={@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LTR,to="LTR"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_RTL,to="RTL"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_INHERIT,to="INHERIT"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LOCALE,to="LOCALE")}) 
	public int getLayoutDirection(){
		// Original method
		/*
		{
        return mViewFlags & LAYOUT_DIRECTION_MASK;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.BAN)
    @RemotableViewMethod 
	public void setLayoutDirection(int layoutDirection){
		// Original method
		/*
		{
        if (getLayoutDirection() != layoutDirection) {
            resetResolvedLayoutDirection();
            setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    @ViewDebug.ExportedProperty(category="layout",mapping={@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LTR,to="RESOLVED_DIRECTION_LTR"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_RTL,to="RESOLVED_DIRECTION_RTL")}) 
	public int getResolvedLayoutDirection(){
		// Original method
		/*
		{
        resolveLayoutDirectionIfNeeded();
        return ((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED_RTL) == LAYOUT_DIRECTION_RESOLVED_RTL) ?
                LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.BAN)
    @ViewDebug.ExportedProperty(category="layout") 
	public boolean isLayoutRtl(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setWillNotDraw(boolean willNotDraw){
		// Original method
		/*
		{
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean willNotDraw(){
		// Original method
		/*
		{
        return (mViewFlags & DRAW_MASK) == WILL_NOT_DRAW;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing){
		// Original method
		/*
		{
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean willNotCacheDrawing(){
		// Original method
		/*
		{
        return (mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isClickable(){
		// Original method
		/*
		{
        return (mViewFlags & CLICKABLE) == CLICKABLE;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setClickable(boolean clickable){
		// Original method
		/*
		{
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isLongClickable(){
		// Original method
		/*
		{
        return (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setLongClickable(boolean longClickable){
		// Original method
		/*
		{
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setPressed(boolean pressed){
		// Original method
		/*
		{
        if (pressed) {
            mPrivateFlags |= PRESSED;
        } else {
            mPrivateFlags &= ~PRESSED;
        }
        refreshDrawableState();
        dispatchSetPressed(pressed);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void dispatchSetPressed(boolean pressed){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isPressed(){
		// Original method
		/*
		{
        return (mPrivateFlags & PRESSED) == PRESSED;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isSaveEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setSaveEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean getFilterTouchesWhenObscured(){
		// Original method
		/*
		{
        return (mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setFilterTouchesWhenObscured(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isSaveFromParentEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setSaveFromParentEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="focus") 
	public final boolean isFocusable(){
		// Original method
		/*
		{
        return FOCUSABLE == (mViewFlags & FOCUSABLE_MASK);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public final boolean isFocusableInTouchMode(){
		// Original method
		/*
		{
        return FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public View focusSearch(int direction){
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.focusSearch(this, direction);
        } else {
            return null;
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchUnhandledMove(View focused, int direction){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    View findUserSetNextFocus(View root, int direction){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    private View findViewInsideOutShouldExist(View root, final int childViewId){
		// Original method
		/*
		{
        View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            @Override
            public boolean apply(View t) {
                return t.mID == childViewId;
            }
        });
        if (result == null) {
            Log.w(VIEW_LOG_TAG, "couldn't find next focus view specified "
                    + "by user for id " + childViewId);
        }
        return result;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public ArrayList<View> getFocusables(int direction){
		// Original method
		/*
		{
        ArrayList<View> result = new ArrayList<View>(24);
        addFocusables(result, direction);
        return result;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void addFocusables(ArrayList<View> views, int direction){
		// Original method
		/*
		{
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode){
		// Original method
		/*
		{
        if (!isFocusable()) {
            return;
        }
        if ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        if (views != null) {
            views.add(this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags){
		// Original method
		/*
		{
        if ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription)) {
            String searchedLowerCase = searched.toString().toLowerCase();
            String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
            if (contentDescriptionLowerCase.contains(searchedLowerCase)) {
                outViews.add(this);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public ArrayList<View> getTouchables(){
		// Original method
		/*
		{
        ArrayList<View> result = new ArrayList<View>();
        addTouchables(result);
        return result;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void addTouchables(ArrayList<View> views){
		// Original method
		/*
		{
        final int viewFlags = mViewFlags;
        if (((viewFlags & CLICKABLE) == CLICKABLE || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)
                && (viewFlags & ENABLED_MASK) == ENABLED) {
            views.add(this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean requestFocus(){
		// Original method
		/*
		{
        return requestFocus(View.FOCUS_DOWN);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean requestFocus(int direction){
		// Original method
		/*
		{
        return requestFocus(direction, null);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean requestFocus(int direction, Rect previouslyFocusedRect){
		// Original method
		/*
		{
        if ((mViewFlags & FOCUSABLE_MASK) != FOCUSABLE ||
                (mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            return false;
        }
        if (isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE))) {
               return false;
        }
        if (hasAncestorThatBlocksDescendantFocus()) {
            return false;
        }
        handleFocusGainInternal(direction, previouslyFocusedRect);
        return true;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    ViewRootImpl getViewRootImpl(){
		// Original method
		/*
		{
        View root = getRootView();
        return root != null ? (ViewRootImpl)root.getParent() : null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean requestFocusFromTouch(){
		// Original method
		/*
		{
        if (isInTouchMode()) {
            ViewRootImpl viewRoot = getViewRootImpl();
            if (viewRoot != null) {
                viewRoot.ensureTouchMode(false);
            }
        }
        return requestFocus(View.FOCUS_DOWN);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean hasAncestorThatBlocksDescendantFocus(){
		// Original method
		/*
		{
        ViewParent ancestor = mParent;
        while (ancestor instanceof ViewGroup) {
            final ViewGroup vgAncestor = (ViewGroup) ancestor;
            if (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS) {
                return true;
            } else {
                ancestor = vgAncestor.getParent();
            }
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    public void dispatchStartTemporaryDetach(){
		// Original method
		/*
		{
        onStartTemporaryDetach();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onStartTemporaryDetach(){
		// Original method
		/*
		{
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public void dispatchFinishTemporaryDetach(){
		// Original method
		/*
		{
        onFinishTemporaryDetach();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onFinishTemporaryDetach(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public KeyEvent.DispatcherState getKeyDispatcherState(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchKeyEventPreIme(KeyEvent event){
		// Original method
		/*
		{
        return onKeyPreIme(event.getKeyCode(), event);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchKeyEvent(KeyEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        }
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event)) {
            return true;
        }
        if (event.dispatch(this, mAttachInfo != null
                ? mAttachInfo.mKeyDispatchState : null, this)) {
            return true;
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchKeyShortcutEvent(KeyEvent event){
		// Original method
		/*
		{
        return onKeyShortcut(event.getKeyCode(), event);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchTouchEvent(MotionEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        }
        if (onFilterTouchEventForSecurity(event)) {
            ListenerInfo li = mListenerInfo;
            if (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event)) {
                return true;
            }
            if (onTouchEvent(event)) {
                return true;
            }
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onFilterTouchEventForSecurity(MotionEvent event){
		// Original method
		/*
		{
        if ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                && (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
            return false;
        }
        return true;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchTrackballEvent(MotionEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        }
        return onTrackballEvent(event);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchGenericMotionEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean dispatchGenericMotionEventInternal(MotionEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event)) {
            return true;
        }
        if (onGenericMotionEvent(event)) {
            return true;
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean dispatchHoverEvent(MotionEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event)) {
            return true;
        }
        return onHoverEvent(event);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    protected boolean hasHoveredChild(){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericPointerEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericFocusedEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    public final boolean dispatchPointerEvent(MotionEvent event){
		// Original method
		/*
		{
        if (event.isTouchEvent()) {
            return dispatchTouchEvent(event);
        } else {
            return dispatchGenericMotionEvent(event);
        }
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void dispatchWindowFocusChanged(boolean hasFocus){
		// Original method
		/*
		{
        onWindowFocusChanged(hasFocus);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onWindowFocusChanged(boolean hasWindowFocus){
		// Original method
		/*
		{
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (!hasWindowFocus) {
            if (isPressed()) {
                setPressed(false);
            }
            if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
                imm.focusOut(this);
            }
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } else if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
            imm.focusIn(this);
        }
        refreshDrawableState();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean hasWindowFocus(){
		// Original method
		/*
		{
        return mAttachInfo != null && mAttachInfo.mHasWindowFocus;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected void dispatchVisibilityChanged(View changedView, int visibility){
		// Original method
		/*
		{
        onVisibilityChanged(changedView, visibility);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onVisibilityChanged(View changedView, int visibility){
		// Original method
		/*
		{
        if (visibility == VISIBLE) {
            if (mAttachInfo != null) {
                initialAwakenScrollBars();
            } else {
                mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void dispatchDisplayHint(int hint){
		// Original method
		/*
		{
        onDisplayHint(hint);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onDisplayHint(int hint){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void dispatchWindowVisibilityChanged(int visibility){
		// Original method
		/*
		{
        onWindowVisibilityChanged(visibility);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onWindowVisibilityChanged(int visibility){
		// Original method
		/*
		{
        if (visibility == VISIBLE) {
            initialAwakenScrollBars();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getWindowVisibility(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public void getWindowVisibleDisplayFrame(Rect outRect){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            try {
                mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            } catch (RemoteException e) {
                return;
            }
            final Rect insets = mAttachInfo.mVisibleInsets;
            outRect.left += insets.left;
            outRect.top += insets.top;
            outRect.right -= insets.right;
            outRect.bottom -= insets.bottom;
            return;
        }
        Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        d.getRectSize(outRect);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void dispatchConfigurationChanged(Configuration newConfig){
		// Original method
		/*
		{
        onConfigurationChanged(newConfig);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onConfigurationChanged(Configuration newConfig){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void dispatchCollectViewAttributes(int visibility){
		// Original method
		/*
		{
        performCollectViewAttributes(visibility);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void performCollectViewAttributes(int visibility){
		// Original method
		/*
		{
        if ((visibility & VISIBILITY_MASK) == VISIBLE && mAttachInfo != null) {
            if ((mViewFlags & KEEP_SCREEN_ON) == KEEP_SCREEN_ON) {
                mAttachInfo.mKeepScreenOn = true;
            }
            mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            ListenerInfo li = mListenerInfo;
            if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
                mAttachInfo.mHasSystemUiListeners = true;
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    void needGlobalAttributesUpdate(boolean force){
		// Original method
		/*
		{
        final AttachInfo ai = mAttachInfo;
        if (ai != null) {
            if (force || ai.mKeepScreenOn || (ai.mSystemUiVisibility != 0)
                    || ai.mHasSystemUiListeners) {
                ai.mRecomputeGlobalAttributes = true;
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isInTouchMode(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mInTouchMode;
        } else {
            return ViewRootImpl.isInTouchMode();
        }
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty 
	public final Context getContext(){
		return mContext;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyPreIme(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyDown(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        boolean result = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER: {
                if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    return true;
                }
                if (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        (event.getRepeatCount() == 0)) {
                    setPressed(true);
                    checkForLongClick(0);
                    return true;
                }
                break;
            }
        }
        return result;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyUp(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        boolean result = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER: {
                if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    return true;
                }
                if ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed()) {
                    setPressed(false);
                    if (!mHasPerformedLongPress) {
                        removeLongPressCallback();
                        result = performClick();
                    }
                }
                break;
            }
        }
        return result;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onCheckIsTextEditor(){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public InputConnection onCreateInputConnection(EditorInfo outAttrs){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean checkInputConnectionProxy(View view){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void createContextMenu(ContextMenu menu){
		// Original method
		/*
		{
        ContextMenuInfo menuInfo = getContextMenuInfo();
        ((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        onCreateContextMenu(menu);
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnCreateContextMenuListener != null) {
            li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        }
        ((MenuBuilder)menu).setCurrentMenuInfo(null);
        if (mParent != null) {
            mParent.createContextMenu(menu);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected ContextMenuInfo getContextMenuInfo(){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    protected void onCreateContextMenu(ContextMenu menu){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onHoverEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean isHoverable(){
		// Original method
		/*
		{
        final int viewFlags = mViewFlags;
        if ((viewFlags & ENABLED_MASK) == DISABLED) {
            return false;
        }
        return (viewFlags & CLICKABLE) == CLICKABLE
                || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty 
	public boolean isHovered(){
		// Original method
		/*
		{
        return (mPrivateFlags & HOVERED) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void setHovered(boolean hovered){
		// Original method
		/*
		{
        if (hovered) {
            if ((mPrivateFlags & HOVERED) == 0) {
                mPrivateFlags |= HOVERED;
                refreshDrawableState();
                onHoverChanged(true);
            }
        } else {
            if ((mPrivateFlags & HOVERED) != 0) {
                mPrivateFlags &= ~HOVERED;
                refreshDrawableState();
                onHoverChanged(false);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onHoverChanged(boolean hovered){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onTouchEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.BAN)
    public boolean isInScrollingContainer(){
		// Original method
		/*
		{
        ViewParent p = getParent();
        while (p != null && p instanceof ViewGroup) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = p.getParent();
        }
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private void removeLongPressCallback(){
		// Original method
		/*
		{
        if (mPendingCheckForLongPress != null) {
          removeCallbacks(mPendingCheckForLongPress);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void removePerformClickCallback(){
		// Original method
		/*
		{
        if (mPerformClick != null) {
            removeCallbacks(mPerformClick);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void removeUnsetPressCallback(){
		// Original method
		/*
		{
        if ((mPrivateFlags & PRESSED) != 0 && mUnsetPressedState != null) {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void removeTapCallback(){
		// Original method
		/*
		{
        if (mPendingCheckForTap != null) {
            mPrivateFlags &= ~PREPRESSED;
            removeCallbacks(mPendingCheckForTap);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void cancelLongPress(){
		// Original method
		/*
		{
        removeLongPressCallback();
        removeTapCallback();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void removeSendViewScrolledAccessibilityEventCallback(){
		// Original method
		/*
		{
        if (mSendViewScrolledAccessibilityEvent != null) {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setTouchDelegate(TouchDelegate delegate){
		mTouchDelegate = delegate;
		// Original method
		/*
		{
        mTouchDelegate = delegate;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public TouchDelegate getTouchDelegate(){
		return mTouchDelegate;
	}

    
    @DSModeled(DSC.SAFE)
    void setFlags(int flags, int mask){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void bringToFront(){
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.bringChildToFront(this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onScrollChanged(int l, int t, int oldl, int oldt){
		// Original method
		/*
		{
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            postSendViewScrolledAccessibilityEventCallback();
        }
        mBackgroundSizeChanged = true;
        final AttachInfo ai = mAttachInfo;
        if (ai != null) {
            ai.mViewScrollChanged = true;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void dispatchDraw(Canvas canvas){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final ViewParent getParent(){
		return (ViewParent)getTaint();
		// Original method
		/*
		{
        return mParent;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public void setScrollX(int value){
	    addTaint(value);
		// Original method
		/*
		{
        scrollTo(value, mScrollY);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void setScrollY(int value){
		// Original method
		/*
		{
        scrollTo(mScrollX, value);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public final int getScrollX(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollX;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public final int getScrollY(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollY;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	@ViewDebug.ExportedProperty(category="layout") 
	public final int getWidth(){
		// Original method
		/*
		{
        return mRight - mLeft;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
	@ViewDebug.ExportedProperty(category="layout") 
	public final int getHeight(){
		// Original method
		/*
		{
        return mBottom - mTop;
    }
		*/
		return getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
    public void getDrawingRect(Rect outRect){
		// Original method
		/*
		{
        outRect.left = mScrollX;
        outRect.top = mScrollY;
        outRect.right = mScrollX + (mRight - mLeft);
        outRect.bottom = mScrollY + (mBottom - mTop);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public final int getMeasuredWidth(){
		return getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
    public final int getMeasuredWidthAndState(){
		return getTaintInt();
		// Original method
		/*
		{
        return mMeasuredWidth;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeight(){
		// Original method
		/*
		{
        return mMeasuredHeight & MEASURED_SIZE_MASK;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeightAndState(){
		return getTaintInt();
		// Original method
		/*
		{
        return mMeasuredHeight;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public final int getMeasuredState(){
		// Original method
		/*
		{
        return (mMeasuredWidth&MEASURED_STATE_MASK)
                | ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
    }
		*/
		return 0;
	}

    
    public Matrix getMatrix(){
		// Original method
		/*
		{
        if (mTransformationInfo != null) {
            updateMatrix();
            return mTransformationInfo.mMatrix;
        }
        return Matrix.IDENTITY_MATRIX;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.BAN)
    private static boolean nonzero(float value){
		// Original method
		/*
		{
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }
		*/
		return false;
	}

    
    final boolean hasIdentityMatrix(){
		// Original method
		/*
		{
        if (mTransformationInfo != null) {
            updateMatrix();
            return mTransformationInfo.mMatrixIsIdentity;
        }
        return true;
    }
		*/
		return false;
	}

    
    void ensureTransformationInfo(){
		// Original method
		/*
		{
        if (mTransformationInfo == null) {
            mTransformationInfo = new TransformationInfo();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void updateMatrix(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    final Matrix getInverseMatrix(){
		// Original method
		/*
		{
        final TransformationInfo info = mTransformationInfo;
        if (info != null) {
            updateMatrix();
            if (info.mInverseMatrixDirty) {
                if (info.mInverseMatrix == null) {
                    info.mInverseMatrix = new Matrix();
                }
                info.mMatrix.invert(info.mInverseMatrix);
                info.mInverseMatrixDirty = false;
            }
            return info.mInverseMatrix;
        }
        return Matrix.IDENTITY_MATRIX;
    }
		*/
		return null;
	}

    
    public void setCameraDistance(float distance){
		// Original method
		/*
		{
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        final float dpi = mResources.getDisplayMetrics().densityDpi;
        final TransformationInfo info = mTransformationInfo;
        if (info.mCamera == null) {
            info.mCamera = new Camera();
            info.matrix3D = new Matrix();
        }
        info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        info.mMatrixDirty = true;
        invalidate(false);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getRotation(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotation : 0;
    }
		*/
		return 0;
	}

    
    public void setRotation(float rotation){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotation != rotation) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotation = rotation;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getRotationY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotationY : 0;
    }
		*/
		return 0;
	}

    
    public void setRotationY(float rotationY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotationY != rotationY) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationY = rotationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getRotationX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotationX : 0;
    }
		*/
		return 0;
	}

    
    public void setRotationX(float rotationX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotationX != rotationX) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationX = rotationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getScaleX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mScaleX : 1;
    }
		*/
		return 0;
	}

    
    public void setScaleX(float scaleX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mScaleX != scaleX) {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleX = scaleX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getScaleY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mScaleY : 1;
    }
		*/
		return 0;
	}

    
    public void setScaleY(float scaleY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mScaleY != scaleY) {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleY = scaleY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getPivotX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mPivotX : 0;
    }
		*/
		return 0;
	}

    
    public void setPivotX(float pivotX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        if (info.mPivotX != pivotX) {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotX = pivotX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getPivotY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mPivotY : 0;
    }
		*/
		return 0;
	}

    
    public void setPivotY(float pivotY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        if (info.mPivotY != pivotY) {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotY = pivotY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getAlpha(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mAlpha : 1;
    }
		*/
		return 0;
	}

    
    public void setAlpha(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
        if (onSetAlpha((int) (alpha * 255))) {
            mPrivateFlags |= ALPHA_SET;
            invalidate(true);
        } else {
            mPrivateFlags &= ~ALPHA_SET;
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    boolean setAlphaNoInvalidation(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        if (subclassHandlesAlpha) {
            mPrivateFlags |= ALPHA_SET;
        } else {
            mPrivateFlags &= ~ALPHA_SET;
        }
        return subclassHandlesAlpha;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty 
	public final int getTop(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTop;
    }
		*/
	}

    
    public final void setTop(int top){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty 
	public final int getBottom(){
		return getTaintInt();
		// Original method
		/*
		{
        return mBottom;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isDirty(){
		// Original method
		/*
		{
        return (mPrivateFlags & DIRTY_MASK) != 0;
    }
		*/
		return false;
	}

    
    public final void setBottom(int bottom){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty 
	public final int getLeft(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLeft;
    }
		*/
	}

    
    public final void setLeft(int left){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty 
	public final int getRight(){
		return getTaintInt();
		// Original method
		/*
		{
        return mRight;
    }
		*/
	}

    
    public final void setRight(int right){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getX(){
		// Original method
		/*
		{
        return mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
    }
		*/
		return 0;
	}

    
    public void setX(float x){
		// Original method
		/*
		{
        setTranslationX(x - mLeft);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getY(){
		// Original method
		/*
		{
        return mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
    }
		*/
		return 0;
	}

    
    public void setY(float y){
		// Original method
		/*
		{
        setTranslationY(y - mTop);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getTranslationX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0;
    }
		*/
		return 0;
	}

    
    public void setTranslationX(float translationX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mTranslationX != translationX) {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationX = translationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public float getTranslationY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0;
    }
		*/
		return 0;
	}

    
    public void setTranslationY(float translationY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mTranslationY != translationY) {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationY = translationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}

    
    public void setFastTranslationX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastTranslationY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastScaleX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastScaleY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void setFastAlpha(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
    }
		*/
		//Return nothing
	}

    
    public void setFastRotationY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}

    
    public void getHitRect(Rect outRect){
		// Original method
		/*
		{
        updateMatrix();
        final TransformationInfo info = mTransformationInfo;
        if (info == null || info.mMatrixIsIdentity || mAttachInfo == null) {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } else {
            final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            tmpRect.set(-info.mPivotX, -info.mPivotY,
                    getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            info.mMatrix.mapRect(tmpRect);
            outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    (int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final boolean pointInView(float localX, float localY){
		// Original method
		/*
		{
        return localX >= 0 && localX < (mRight - mLeft)
                && localY >= 0 && localY < (mBottom - mTop);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean pointInView(float localX, float localY, float slop){
		// Original method
		/*
		{
        return localX >= -slop && localY >= -slop && localX < ((mRight - mLeft) + slop) &&
                localY < ((mBottom - mTop) + slop);
    }
		*/
		return false;
	}

    
    public void getFocusedRect(Rect r){
		// Original method
		/*
		{
        getDrawingRect(r);
    }
		*/
		//Return nothing
	}

    
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset){
		// Original method
		/*
		{
        int width = mRight - mLeft;
        int height = mBottom - mTop;
        if (width > 0 && height > 0) {
            r.set(0, 0, width, height);
            if (globalOffset != null) {
                globalOffset.set(-mScrollX, -mScrollY);
            }
            return mParent == null || mParent.getChildVisibleRect(this, r, globalOffset);
        }
        return false;
    }
		*/
		return false;
	}

    
    public final boolean getGlobalVisibleRect(Rect r){
		// Original method
		/*
		{
        return getGlobalVisibleRect(r, null);
    }
		*/
		return false;
	}

    
    public final boolean getLocalVisibleRect(Rect r){
		// Original method
		/*
		{
        Point offset = new Point();
        if (getGlobalVisibleRect(r, offset)) {
            r.offset(-offset.x, -offset.y); 
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    public void offsetTopAndBottom(int offset){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void offsetLeftAndRight(int offset){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(deepExport=true,prefix="layout_") 
	public ViewGroup.LayoutParams getLayoutParams(){
        return mLayoutParams;
    }

    
    public void setLayoutParams(ViewGroup.LayoutParams params){
		mLayoutParams = params;
		requestLayout();
		// Original method
		/*
		{
        if (params == null) {
            throw new NullPointerException("Layout parameters cannot be null");
        }
        mLayoutParams = params;
        requestLayout();
    }
		*/
		//Return nothing
	}

    
    public void scrollTo(int x, int y){
		// Original method
		/*
		{
        if (mScrollX != x || mScrollY != y) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            if (!awakenScrollBars()) {
                invalidate(true);
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void scrollBy(int x, int y){
		// Original method
		/*
		{
        scrollTo(mScrollX + x, mScrollY + y);
    }
		*/
		//Return nothing
	}

    
    protected boolean awakenScrollBars(){
		// Original method
		/*
		{
        return mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean initialAwakenScrollBars(){
		// Original method
		/*
		{
        return mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }
		*/
		return false;
	}

    
    protected boolean awakenScrollBars(int startDelay){
		// Original method
		/*
		{
        return awakenScrollBars(startDelay, true);
    }
		*/
		return false;
	}

    
    protected boolean awakenScrollBars(int startDelay, boolean invalidate){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.BAN)
    private boolean skipInvalidate(){
		// Original method
		/*
		{
        return (mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this));
    }
		*/
		return false;
	}

    
    public void invalidate(Rect dirty){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void invalidate(int l, int t, int r, int b){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void invalidate(){
		invalidate(true);
		// Original method
		/*
		{
        invalidate(true);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	void invalidate(boolean invalidateCache){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void fastInvalidate(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void invalidateParentCaches(){
		// Original method
		/*
		{
        if (mParent instanceof View) {
            ((View) mParent).mPrivateFlags |= INVALIDATED;
        }
    }
		*/
		//Return nothing
	}

    
    protected void invalidateParentIfNeeded(){
		// Original method
		/*
		{
        if (isHardwareAccelerated() && mParent instanceof View) {
            ((View) mParent).invalidate(true);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean isOpaque(){
		// Original method
		/*
		{
        return (mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                ((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        >= 1.0f - ViewConfiguration.ALPHA_THRESHOLD);
    }
		*/
		return false;
	}

    
    protected void computeOpaqueFlags(){
		// Original method
		/*
		{
        if (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE) {
            mPrivateFlags |= OPAQUE_BACKGROUND;
        } else {
            mPrivateFlags &= ~OPAQUE_BACKGROUND;
        }
        final int flags = mViewFlags;
        if (((flags & SCROLLBARS_VERTICAL) == 0 && (flags & SCROLLBARS_HORIZONTAL) == 0) ||
                (flags & SCROLLBARS_STYLE_MASK) == SCROLLBARS_INSIDE_OVERLAY) {
            mPrivateFlags |= OPAQUE_SCROLLBARS;
        } else {
            mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean hasOpaqueScrollbars(){
		// Original method
		/*
		{
        return (mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public Handler getHandler(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mHandler;
        }
        return null;
    }
		*/
		return null;
	}

    
    public boolean post(Runnable action){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().post(action);
            return true;
        }
        return handler.post(action);
    }
		*/
    	addTaint(action.getTaint());
    	Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
            handler.post(action);
        } else {
            ViewRootImpl.getRunQueue().post(action);
        }
        return getTaintBoolean();
	}

    
    public boolean postDelayed(Runnable action, long delayMillis){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
            return true;
        }
        return handler.postDelayed(action, delayMillis);
    }
		*/
		return false;
	}

    
    public boolean removeCallbacks(Runnable action){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
            return true;
        }
        handler.removeCallbacks(action);
        return true;
    }
		*/
    	addTaint(action.getTaint());
    	Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
            handler.removeCallbacks(action);
        } else {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
        }
        
        return getTaintBoolean();
	}

    
    public void postInvalidate(){
		// Original method
		/*
		{
        postInvalidateDelayed(0);
    }
		*/
		//Return nothing
	}

    
    public void postInvalidate(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        postInvalidateDelayed(0, left, top, right, bottom);
    }
		*/
		//Return nothing
	}

    
    public void postInvalidateDelayed(long delayMilliseconds){
		// Original method
		/*
		{
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_MSG;
            msg.obj = this;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        }
    }
		*/
		//Return nothing
	}

    
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top,
            int right, int bottom){
		// Original method
		/*
		{
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            final AttachInfo.InvalidateInfo info = AttachInfo.InvalidateInfo.acquire();
            info.target = this;
            info.left = left;
            info.top = top;
            info.right = right;
            info.bottom = bottom;
            final Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            msg.obj = info;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void postSendViewScrolledAccessibilityEventCallback(){
		// Original method
		/*
		{
        if (mSendViewScrolledAccessibilityEvent == null) {
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        }
        if (!mSendViewScrolledAccessibilityEvent.mIsPending) {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void computeScroll(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalFadingEdgeEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL;
    }
		*/
		return false;
	}

    
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled){
		// Original method
		/*
		{
        if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            if (horizontalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_HORIZONTAL;
        }
    }
		*/
		//Return nothing
    	addTaint(horizontalFadingEdgeEnabled);
    	if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            if (horizontalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_HORIZONTAL;
        }
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isVerticalFadingEdgeEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL;
    }
		*/
		return false;
	}

    
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled){
		// Original method
		/*
		{
        if (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled) {
            if (verticalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_VERTICAL;
        }
    }
		*/
		//Return nothing
	}

    
    protected float getTopFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}

    
    protected float getBottomFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange() ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}

    
    protected float getLeftFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}

    
    protected float getRightFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalScrollBarEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
    }
		*/
		return false;
	}

    
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled){
		// Original method
		/*
		{
        if (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled) {
            mViewFlags ^= SCROLLBARS_HORIZONTAL;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isVerticalScrollBarEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL;
    }
		*/
		return false;
	}

    
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled){
		// Original method
		/*
		{
        if (isVerticalScrollBarEnabled() != verticalScrollBarEnabled) {
            mViewFlags ^= SCROLLBARS_VERTICAL;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}

    
    protected void recomputePadding(){
		// Original method
		/*
		{
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }
		*/
		//Return nothing
	}

    
    public void setScrollbarFadingEnabled(boolean fadeScrollbars){
		// Original method
		/*
		{
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        if (fadeScrollbars) {
            scrollabilityCache.state = ScrollabilityCache.OFF;
        } else {
            scrollabilityCache.state = ScrollabilityCache.ON;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isScrollbarFadingEnabled(){
		// Original method
		/*
		{
        return mScrollCache != null && mScrollCache.fadeScrollBars;
    }
		*/
		return false;
	}

    
    public void setScrollBarStyle(int style){
		// Original method
		/*
		{
        if (style != (mViewFlags & SCROLLBARS_STYLE_MASK)) {
            mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=SCROLLBARS_INSIDE_OVERLAY,to="INSIDE_OVERLAY"),@ViewDebug.IntToString(from=SCROLLBARS_INSIDE_INSET,to="INSIDE_INSET"),@ViewDebug.IntToString(from=SCROLLBARS_OUTSIDE_OVERLAY,to="OUTSIDE_OVERLAY"),@ViewDebug.IntToString(from=SCROLLBARS_OUTSIDE_INSET,to="OUTSIDE_INSET")}) public int getScrollBarStyle(){
		// Original method
		/*
		{
        return mViewFlags & SCROLLBARS_STYLE_MASK;
    }
		*/
		return 0;
	}

    
    protected int computeHorizontalScrollRange(){
		// Original method
		/*
		{
        return getWidth();
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int computeHorizontalScrollOffset(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollX;
    }
		*/
	}

    
    protected int computeHorizontalScrollExtent(){
		// Original method
		/*
		{
        return getWidth();
    }
		*/
		return 0;
	}

    
    protected int computeVerticalScrollRange(){
		// Original method
		/*
		{
        return getHeight();
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int computeVerticalScrollOffset(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollY;
    }
		*/
	}

    
    protected int computeVerticalScrollExtent(){
		// Original method
		/*
		{
        return getHeight();
    }
		*/
		return 0;
	}

    
    public boolean canScrollHorizontally(int direction){
		// Original method
		/*
		{
        final int offset = computeHorizontalScrollOffset();
        final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
		*/
		return false;
	}

    
    public boolean canScrollVertically(int direction){
		// Original method
		/*
		{
        final int offset = computeVerticalScrollOffset();
        final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
		*/
		return false;
	}

    
    protected final void onDrawScrollBars(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean isVerticalScrollBarHidden(){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b){
		// Original method
		/*
		{
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
    }
		*/
		//Return nothing
	}

    
    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b){
		// Original method
		/*
		{
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	protected void onDraw(Canvas canvas){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    void assignParent(ViewParent parent){
		// Original method
		/*
		{
        if (mParent == null) {
            mParent = parent;
        } else if (parent == null) {
            mParent = null;
        } else {
            throw new RuntimeException("view " + this + " being added, but"
                    + " it already has a parent");
        }
    }
		*/
		//Return nothing
	}

    
    protected void onAttachedToWindow(){
		// Original method
		/*
		{
        if ((mPrivateFlags & REQUEST_TRANSPARENT_REGIONS) != 0) {
            mParent.requestTransparentRegion(this);
        }
        if ((mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH) != 0) {
            initialAwakenScrollBars();
            mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        }
        jumpDrawablesToCurrentState();
        resolveLayoutDirectionIfNeeded();
        resolvePadding();
        resolveTextDirection();
        if (isFocused()) {
            InputMethodManager imm = InputMethodManager.peekInstance();
            imm.focusIn(this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void resolveLayoutDirectionIfNeeded(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    protected void resolvePadding(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    protected boolean canResolveLayoutDirection(){
		// Original method
		/*
		{
        switch (getLayoutDirection()) {
            case LAYOUT_DIRECTION_INHERIT:
                return (mParent != null);
            default:
                return true;
        }
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected void resetResolvedLayoutDirection(){
		// Original method
		/*
		{
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
    }
		*/
		//Return nothing
	}

    
    protected static boolean isLayoutDirectionRtl(Locale locale){
		// Original method
		/*
		{
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }
		*/
		return false;
	}

    
    protected void onDetachedFromWindow(){
		// Original method
		/*
		{
        mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer();
        if (mDisplayList != null) {
            mDisplayList.invalidate();
        }
        if (mAttachInfo != null) {
            mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        }
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected int getWindowAttachCount(){
		return getTaintInt();
		// Original method
		/*
		{
        return mWindowAttachCount;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public IBinder getWindowToken(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mWindowToken : null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public IBinder getApplicationWindowToken(){
		// Original method
		/*
		{
        AttachInfo ai = mAttachInfo;
        if (ai != null) {
            IBinder appWindowToken = ai.mPanelParentWindowToken;
            if (appWindowToken == null) {
                appWindowToken = ai.mWindowToken;
            }
            return appWindowToken;
        }
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    IWindowSession getWindowSession(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mSession : null;
    }
		*/
		return null;
	}

    
    void dispatchAttachedToWindow(AttachInfo info, int visibility){
		mAttachInfo = info;
		info.mTreeObserver.merge(mFloatingTreeObserver);
		mAttachInfo.mScrollContainers.add(this);
		performCollectViewAttributes(visibility);
        onAttachedToWindow();
        ListenerInfo li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners =
                li != null ? li.mOnAttachStateChangeListeners : null;
        for (OnAttachStateChangeListener listener : listeners) {
            listener.onViewAttachedToWindow(this);
        }
        int vis = info.mWindowVisibility;
        onWindowVisibilityChanged(vis);
        refreshDrawableState();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    void dispatchDetachedFromWindow(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void saveHierarchyState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        dispatchSaveInstanceState(container);
    }
		*/
		//Return nothing
	}

    
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        if (mID != NO_ID && (mViewFlags & SAVE_DISABLED_MASK) == 0) {
            mPrivateFlags &= ~SAVE_STATE_CALLED;
            Parcelable state = onSaveInstanceState();
            if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
            }
            if (state != null) {
                container.put(mID, state);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected Parcelable onSaveInstanceState(){
		// Original method
		/*
		{
        mPrivateFlags |= SAVE_STATE_CALLED;
        return BaseSavedState.EMPTY_STATE;
    }
		*/
		return null;
	}

    
    public void restoreHierarchyState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        dispatchRestoreInstanceState(container);
    }
		*/
		//Return nothing
	}

    
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        if (mID != NO_ID) {
            Parcelable state = container.get(mID);
            if (state != null) {
                mPrivateFlags &= ~SAVE_STATE_CALLED;
                onRestoreInstanceState(state);
                if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                    throw new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }
		*/
		//Return nothing
	}

    
    protected void onRestoreInstanceState(Parcelable state){
		// Original method
		/*
		{
        mPrivateFlags |= SAVE_STATE_CALLED;
        if (state != BaseSavedState.EMPTY_STATE && state != null) {
            throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    + "received " + state.getClass().toString() + " instead. This usually happens "
                    + "when two views of different type have the same id in the same hierarchy. "
                    + "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    + "other views do not use the same id.");
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public long getDrawingTime(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mDrawingTime : 0;
    }
		*/
		return 0;
	}

    
    public void setDuplicateParentStateEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isDuplicateParentStateEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE;
    }
		*/
		return false;
	}

    
    public void setLayerType(int layerType, Paint paint){
		addTaint(layerType);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    boolean hasStaticLayer(){
		// Original method
		/*
		{
        return mLayerType == LAYER_TYPE_NONE;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public int getLayerType(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLayerType;
    }
		*/
	}

    
    public void buildLayer(){
		// Original method
		/*
		{
        if (mLayerType == LAYER_TYPE_NONE) return;
        if (mAttachInfo == null) {
            throw new IllegalStateException("This view must be attached to a window first");
        }
        switch (mLayerType) {
            case LAYER_TYPE_HARDWARE:
                if (mAttachInfo.mHardwareRenderer != null &&
                        mAttachInfo.mHardwareRenderer.isEnabled() &&
                        mAttachInfo.mHardwareRenderer.validate()) {
                    getHardwareLayer();
                }
                break;
            case LAYER_TYPE_SOFTWARE:
                buildDrawingCache(true);
                break;
        }
    }
		*/
		//Return nothing
	}

    
    HardwareLayer getHardwareLayer(){
		return mHardwareLayer;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    boolean destroyLayer(){
		// Original method
		/*
		{
        if (mHardwareLayer != null) {
            mHardwareLayer.destroy();
            mHardwareLayer = null;
            invalidate(true);
            invalidateParentCaches();
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    protected void destroyHardwareResources(){
		// Original method
		/*
		{
        destroyLayer();
    }
		*/
		//Return nothing
	}

    
    public void setDrawingCacheEnabled(boolean enabled){
		// Original method
		/*
		{
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean isDrawingCacheEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED;
    }
		*/
		return false;
	}

    
    @SuppressWarnings({"UnusedDeclaration"}) 
	public void outputDirtyFlags(String indent, boolean clear, int clearMask){
		// Original method
		/*
		{
        Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                ") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                (mPrivateFlags & View.DRAWING_CACHE_VALID) +
                ") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        if (clear) {
            mPrivateFlags &= clearMask;
        }
        if (this instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) this;
            final int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                final View child = parent.getChildAt(i);
                child.outputDirtyFlags(indent + "  ", clear, clearMask);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void dispatchGetDisplayList(){
		// Original method
		/*
		{}
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean canHaveDisplayList(){
		// Original method
		/*
		{
        return !(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null);
    }
		*/
		return false;
	}

    
    public DisplayList getDisplayList(){
		return mDisplayList;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    public Bitmap getDrawingCache(){
		// Original method
		/*
		{
        return getDrawingCache(false);
    }
		*/
		return null;
	}

    
    public Bitmap getDrawingCache(boolean autoScale){
		// Original method
		/*
		{
        if ((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING) {
            return null;
        }
        if ((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED) {
            buildDrawingCache(autoScale);
        }
        return autoScale ? mDrawingCache : mUnscaledDrawingCache;
    }
		*/
		return null;
	}

    
    public void destroyDrawingCache(){
		// Original method
		/*
		{
        if (mDrawingCache != null) {
            mDrawingCache.recycle();
            mDrawingCache = null;
        }
        if (mUnscaledDrawingCache != null) {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setDrawingCacheBackgroundColor(int color){
		// Original method
		/*
		{
        if (color != mDrawingCacheBackgroundColor) {
            mDrawingCacheBackgroundColor = color;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheBackgroundColor(){
		return getTaintInt();
		// Original method
		/*
		{
        return mDrawingCacheBackgroundColor;
    }
		*/
	}

    
    public void buildDrawingCache(){
		// Original method
		/*
		{
        buildDrawingCache(false);
    }
		*/
		//Return nothing
	}

    
    public void buildDrawingCache(boolean autoScale){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isInEditMode(){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean isPaddingOffsetRequired(){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected int getLeftPaddingOffset(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int getRightPaddingOffset(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int getTopPaddingOffset(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected int getBottomPaddingOffset(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    protected int getFadeTop(boolean offsetRequired){
		// Original method
		/*
		{
        int top = mPaddingTop;
        if (offsetRequired) top += getTopPaddingOffset();
        return top;
    }
		*/
		return 0;
	}

    
    protected int getFadeHeight(boolean offsetRequired){
		// Original method
		/*
		{
        int padding = mPaddingTop;
        if (offsetRequired) padding += getTopPaddingOffset();        
        return mBottom - mTop - mPaddingBottom - padding;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated(){
		// Original method
		/*
		{
        return mAttachInfo != null && mAttachInfo.mHardwareAccelerated;
    }
		*/
		return false;
	}

    
    public void draw(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="drawing") 
	public int getSolidColor(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.BAN)
    private static String printFlags(int flags){
		// Original method
		/*
		{
        String output = "";
        int numFlags = 0;
        if ((flags & FOCUSABLE_MASK) == FOCUSABLE) {
            output += "TAKES_FOCUS";
            numFlags++;
        }
        switch (flags & VISIBILITY_MASK) {
        case INVISIBLE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "INVISIBLE";
            break;
        case GONE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "GONE";
            break;
        default:
            break;
        }
        return output;
    }
		*/
		return "";
	}

    
    @DSModeled(DSC.BAN)
    private static String printPrivateFlags(int privateFlags){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return "";
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isLayoutRequested(){
		// Original method
		/*
		{
        return (mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT;
    }
		*/
		return false;
	}

    
    @SuppressWarnings({"unchecked"}) public void layout(int l, int t, int r, int b){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onLayout(boolean changed, int left, int top, int right, int bottom){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    protected boolean setFrame(int left, int top, int right, int bottom){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected void onFinishInflate(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public Resources getResources(){
		return mResources;
	}

    
    public void invalidateDrawable(Drawable drawable){
		// Original method
		/*
		{
        if (verifyDrawable(drawable)) {
            final Rect dirty = drawable.getBounds();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
        }
    }
		*/
		//Return nothing
	}

    
    public void scheduleDrawable(Drawable who, Runnable what, long when){
		// Original method
		/*
		{
        if (verifyDrawable(who) && what != null) {
            if (mAttachInfo != null) {
                mAttachInfo.mHandler.postAtTime(what, who, when);
            } else {
                ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void unscheduleDrawable(Drawable who, Runnable what){
		// Original method
		/*
		{
        if (verifyDrawable(who) && what != null) {
            if (mAttachInfo != null) {
                mAttachInfo.mHandler.removeCallbacks(what, who);
            } else {
                ViewRootImpl.getRunQueue().removeCallbacks(what);
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void unscheduleDrawable(Drawable who){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        }
    }
		*/
		//Return nothing
	}

    
    public int getResolvedLayoutDirection(Drawable who){
		// Original method
		/*
		{
        return (who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean verifyDrawable(Drawable who){
		// Original method
		/*
		{
        return who == mBGDrawable;
    }
		*/
		return false;
	}

    
    protected void drawableStateChanged(){
		// Original method
		/*
		{
        Drawable d = mBGDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }
		*/
		//Return nothing
	}

    
    public void refreshDrawableState(){
		// Original method
		/*
		{
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        drawableStateChanged();
        ViewParent parent = mParent;
        if (parent != null) {
            parent.childDrawableStateChanged(this);
        }
    }
		*/
		//Return nothing
	}

    
    public final int[] getDrawableState(){
		// Original method
		/*
		{
        if ((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0)) {
            return mDrawableState;
        } else {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            return mDrawableState;
        }
    }
		*/
    	if ((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0)) {
            return mDrawableState;
        } else {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            return mDrawableState;
        }
	}

    
    protected int[] onCreateDrawableState(int extraSpace){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState){
		// Original method
		/*
		{
        final int N = baseState.length;
        int i = N - 1;
        while (i >= 0 && baseState[i] == 0) {
            i--;
        }
        System.arraycopy(additionalState, 0, baseState, i + 1, additionalState.length);
        return baseState;
    }
		*/
		return null;
	}

    
    public void jumpDrawablesToCurrentState(){
		// Original method
		/*
		{
        if (mBGDrawable != null) {
            mBGDrawable.jumpToCurrentState();
        }
    }
		*/
		//Return nothing
	}

    
    @RemotableViewMethod 
	public void setBackgroundColor(int color){
		// Original method
		/*
		{
        if (mBGDrawable instanceof ColorDrawable) {
            ((ColorDrawable) mBGDrawable).setColor(color);
        } else {
            setBackgroundDrawable(new ColorDrawable(color));
        }
    }
		*/
		//Return nothing
	}

    
    @RemotableViewMethod 
	public void setBackgroundResource(int resid){
		addTaint(resid);
		// Original method
		/*
		{
        if (resid != 0 && resid == mBackgroundResource) {
            return;
        }
        Drawable d= null;
        if (resid != 0) {
            d = mResources.getDrawable(resid);
        }
        setBackgroundDrawable(d);
        mBackgroundResource = resid;
    }
		*/
		//Return nothing
	}

    
    public void setBackgroundDrawable(Drawable d){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public Drawable getBackground(){
		return mBGDrawable;
	}

    
    public void setPadding(int left, int top, int right, int bottom){
		addTaint(left);
		addTaint(right);
		addTaint(bottom);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void setPaddingRelative(int start, int top, int end, int bottom){
		addTaint(start);
		addTaint(end);
		// Original method
		/*
		{
        mUserPaddingRelative = true;
        mUserPaddingStart = start;
        mUserPaddingEnd = end;
        switch(getResolvedLayoutDirection()) {
            case LAYOUT_DIRECTION_RTL:
                setPadding(end, top, start, bottom);
                break;
            case LAYOUT_DIRECTION_LTR:
            default:
                setPadding(start, top, end, bottom);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingTop(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingTop;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingBottom(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingBottom;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingLeft(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingLeft;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingStart(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingRight : mPaddingLeft;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingRight(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingRight;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public int getPaddingEnd(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingLeft : mPaddingRight;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
	public boolean isPaddingRelative(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mUserPaddingRelative;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public void setSelected(boolean selected){
	    addTaint(selected); 
		// Original method
		/*
		{
        if (((mPrivateFlags & SELECTED) != 0) != selected) {
            mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            if (!selected) resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(selected);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	protected void dispatchSetSelected(boolean selected){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty public boolean isSelected(){
		// Original method
		/*
		{
        return (mPrivateFlags & SELECTED) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
	public void setActivated(boolean activated){
	    addTaint(activated);
	}

    
    @DSModeled(DSC.SAFE)
	protected void dispatchSetActivated(boolean activated){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty 
	@DSModeled(DSC.SAFE)
	public boolean isActivated(){
		// Original method
		/*
		{
        return (mPrivateFlags & ACTIVATED) != 0;
    }
		*/
		return getTaintBoolean();
	}

    
    public ViewTreeObserver getViewTreeObserver(){
		return mFloatingTreeObserver;
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mTreeObserver;
        }
        if (mFloatingTreeObserver == null) {
            mFloatingTreeObserver = new ViewTreeObserver();
        }
        return mFloatingTreeObserver;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public View getRootView(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            final View v = mAttachInfo.mRootView;
            if (v != null) {
                return v;
            }
        }
        View parent = this;
        while (parent.mParent != null && parent.mParent instanceof View) {
            parent = (View) parent.mParent;
        }
        return parent;
    }
		*/
		return null;
	}

    
    public void getLocationOnScreen(int[] location){
		// Original method
		/*
		{
        getLocationInWindow(location);
        final AttachInfo info = mAttachInfo;
        if (info != null) {
            location[0] += info.mWindowLeft;
            location[1] += info.mWindowTop;
        }
    }
		*/
		//Return nothing
	}

    
    public void getLocationInWindow(int[] location){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected View findViewTraversal(int id){
		return this;
		// Original method
		/*
		{
        if (id == mID) {
            return this;
        }
        return null;
    }
		*/
	}

    
    protected View findViewWithTagTraversal(Object tag){
		// Original method
		/*
		{
        if (tag != null && tag.equals(mTag)) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}

    
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip){
		// Original method
		/*
		{
        if (predicate.apply(this)) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}

    
    public final View findViewById(int id){
		return this;
		// Original method
		/*
		{
        if (id < 0) {
            return null;
        }
        return findViewTraversal(id);
    }
		*/
	}

    
    final View findViewByAccessibilityId(int accessibilityId){
		// Original method
		/*
		{
        if (accessibilityId < 0) {
            return null;
        }
        return findViewByAccessibilityIdTraversal(accessibilityId);
    }
		*/
		return null;
	}

    
    View findViewByAccessibilityIdTraversal(int accessibilityId){
		// Original method
		/*
		{
        if (getAccessibilityViewId() == accessibilityId) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}

    
    public final View findViewWithTag(Object tag){
		// Original method
		/*
		{
        if (tag == null) {
            return null;
        }
        return findViewWithTagTraversal(tag);
    }
		*/
		return null;
	}

    
    public final View findViewByPredicate(Predicate<View> predicate){
		// Original method
		/*
		{
        return findViewByPredicateTraversal(predicate, null);
    }
		*/
		return null;
	}

    
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate){
		// Original method
		/*
		{
        View childToSkip = null;
        for (;;) {
            View view = start.findViewByPredicateTraversal(predicate, childToSkip);
            if (view != null || start == this) {
                return view;
            }
            ViewParent parent = start.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            childToSkip = start;
            start = (View) parent;
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public void setId(int id){
		addTaint(id);
		// Original method
		/*
		{
        mID = id;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setIsRootNamespace(boolean isRoot){
		// Original method
		/*
		{
        if (isRoot) {
            mPrivateFlags |= IS_ROOT_NAMESPACE;
        } else {
            mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isRootNamespace(){
		// Original method
		/*
		{
        return (mPrivateFlags&IS_ROOT_NAMESPACE) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
	@ViewDebug.CapturedViewProperty 
	public int getId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mID;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	@ViewDebug.ExportedProperty 
	public Object getTag(){
		return (Object)getTaint();
		// Original method
		/*
		{
        return mTag;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public void setTag(final Object tag){
		mTag = tag;
		// Original method
		/*
		{
        mTag = tag;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public Object getTag(int key){
		return mKeyedTags.get(key);
		// Original method
		/*
		{
        if (mKeyedTags != null) return mKeyedTags.get(key);
        return null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public void setTag(int key, final Object tag){
		setKeyedTag(key, tag);
		// Original method
		/*
		{
        if ((key >>> 24) < 2) {
            throw new IllegalArgumentException("The key must be an application-specific "
                    + "resource id.");
        }
        setKeyedTag(key, tag);
    }
		*/
		//Return nothing
	}

    
    public void setTagInternal(int key, Object tag){
		setKeyedTag(key, tag);
		// Original method
		/*
		{
        if ((key >>> 24) != 0x1) {
            throw new IllegalArgumentException("The key must be a framework-specific "
                    + "resource id.");
        }
        setKeyedTag(key, tag);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void setKeyedTag(int key, Object tag){
		mKeyedTags.put(key, tag);
		// Original method
		/*
		{
        if (mKeyedTags == null) {
            mKeyedTags = new SparseArray<Object>();
        }
        mKeyedTags.put(key, tag);
    }
		*/
		//Return nothing
	}

    
    protected boolean dispatchConsistencyCheck(int consistency){
		// Original method
		/*
		{
        return onConsistencyCheck(consistency);
    }
		*/
		return false;
	}

    
    protected boolean onConsistencyCheck(int consistency){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    public void debug(){
		// Original method
		/*
		{
        debug(0);
    }
		*/
		//Return nothing
	}

    
    protected void debug(int depth){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    protected static String debugIndent(int depth){
		// Original method
		/*
		{
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }
		*/
		return "";
	}

    
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category="layout") 
	public int getBaseline(){
		// Original method
		/*
		{
        return -1;
    }
		*/
		return 0;
	}

    
    public void requestLayout(){
		// Original method
		/*
		{
        if (ViewDebug.TRACE_HIERARCHY) {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        }
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        if (mParent != null) {
            if (mLayoutParams != null) {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            }
            if (!mParent.isLayoutRequested()) {
                mParent.requestLayout();
            }
        }
    }
		*/
		//Return nothing
    	if (ViewDebug.TRACE_HIERARCHY) {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        }
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        if (mParent != null) {
            if (mLayoutParams != null) {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            }
            if (!mParent.isLayoutRequested()) {
                mParent.requestLayout();
            }
        }
	}

    
    @DSModeled(DSC.SAFE)
    public void forceLayout(){
		// Original method
		/*
		{
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
    }
		*/
		//Return nothing
	}

    
    public final void measure(int widthMeasureSpec, int heightMeasureSpec){
		addTaint(widthMeasureSpec);
		addTaint(heightMeasureSpec);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		// Original method
		/*
		{
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight){
		addTaint(measuredWidth);
		addTaint(measuredHeight);
		// Original method
		/*
		{
        mMeasuredWidth = measuredWidth;
        mMeasuredHeight = measuredHeight;
        mPrivateFlags |= MEASURED_DIMENSION_SET;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public static int combineMeasuredStates(int curState, int newState){
		// Original method
		/*
		{
        return curState | newState;
    }
		*/
		return 0;
	}

    
    public static int resolveSize(int size, int measureSpec){
		// Original method
		/*
		{
        return resolveSizeAndState(size, measureSpec, 0) & MEASURED_SIZE_MASK;
    }
		*/
		return 0;
	}

    
    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState){
		// Original method
		/*
		{
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize =  MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
            if (specSize < size) {
                result = specSize | MEASURED_STATE_TOO_SMALL;
            } else {
                result = size;
            }
            break;
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result | (childMeasuredState&MEASURED_STATE_MASK);
    }
		*/
		return 0;
	}

    
    public static int getDefaultSize(int size, int measureSpec){
		// Original method
		/*
		{
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result;
    }
		*/
		return 0;
	}

    
    protected int getSuggestedMinimumHeight(){
		// Original method
		/*
		{
        int suggestedMinHeight = mMinHeight;
        if (mBGDrawable != null) {
            final int bgMinHeight = mBGDrawable.getMinimumHeight();
            if (suggestedMinHeight < bgMinHeight) {
                suggestedMinHeight = bgMinHeight;
            }
        }
        return suggestedMinHeight;
    }
		*/
		return 0;
	}

    
    protected int getSuggestedMinimumWidth(){
		// Original method
		/*
		{
        int suggestedMinWidth = mMinWidth;
        if (mBGDrawable != null) {
            final int bgMinWidth = mBGDrawable.getMinimumWidth();
            if (suggestedMinWidth < bgMinWidth) {
                suggestedMinWidth = bgMinWidth;
            }
        }
        return suggestedMinWidth;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public void setMinimumHeight(int minHeight){
		addTaint(minHeight);
		// Original method
		/*
		{
        mMinHeight = minHeight;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setMinimumWidth(int minWidth){
		addTaint(minWidth);
		// Original method
		/*
		{
        mMinWidth = minWidth;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public Animation getAnimation(){
        return mCurrentAnimation;
	}

    
    public void startAnimation(Animation animation){
		// Original method
		/*
		{
        animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
    }
		*/
		//Return nothing
	}

    
    public void clearAnimation(){
		// Original method
		/*
		{
        if (mCurrentAnimation != null) {
            mCurrentAnimation.detach();
        }
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
    }
		*/
		//Return nothing
	}

    
    public void setAnimation(Animation animation){
		mCurrentAnimation = animation;
		animation.reset();
		// Original method
		/*
		{
        mCurrentAnimation = animation;
        if (animation != null) {
            animation.reset();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onAnimationStart(){
		// Original method
		/*
		{
        mPrivateFlags |= ANIMATION_STARTED;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onAnimationEnd(){
		// Original method
		/*
		{
        mPrivateFlags &= ~ANIMATION_STARTED;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected boolean onSetAlpha(int alpha){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    public boolean gatherTransparentRegion(Region region){
		// Original method
		/*
		{
        final AttachInfo attachInfo = mAttachInfo;
        if (region != null && attachInfo != null) {
            final int pflags = mPrivateFlags;
            if ((pflags & SKIP_DRAW) == 0) {
                final int[] location = attachInfo.mTransparentLocation;
                getLocationInWindow(location);
                region.op(location[0], location[1], location[0] + mRight - mLeft,
                        location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            } else if ((pflags & ONLY_DRAWS_BACKGROUND) != 0 && mBGDrawable != null) {
                applyDrawableToTransparentRegion(mBGDrawable, region);
            }
        }
        return true;
    }
		*/
		return false;
	}

    
    public void playSoundEffect(int soundConstant){
		// Original method
		/*
		{
        if (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            return;
        }
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
    }
		*/
		//Return nothing
	}

    
    public boolean performHapticFeedback(int feedbackConstant){
		// Original method
		/*
		{
        return performHapticFeedback(feedbackConstant, 0);
    }
		*/
		return false;
	}

    
    public boolean performHapticFeedback(int feedbackConstant, int flags){
		// Original method
		/*
		{
        if (mAttachInfo == null) {
            return false;
        }
        if ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled()) {
            return false;
        }
        return mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                (flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0);
    }
		*/
		return false;
	}

    
    public void setSystemUiVisibility(int visibility){
		// Original method
		/*
		{
        if (visibility != mSystemUiVisibility) {
            mSystemUiVisibility = visibility;
            if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
                mParent.recomputeViewAttributes(this);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getSystemUiVisibility(){
		return getTaintInt();
		// Original method
		/*
		{
        return mSystemUiVisibility;
    }
		*/
	}

    
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            mParent.recomputeViewAttributes(this);
        }
    }
		*/
		//Return nothing
	}

    
    public void dispatchSystemUiVisibilityChanged(int visibility){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
            li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        }
    }
		*/
		//Return nothing
	}

    
    void updateLocalSystemUiVisibility(int localValue, int localChanges){
		// Original method
		/*
		{
        int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        if (val != mSystemUiVisibility) {
            setSystemUiVisibility(val);
        }
    }
		*/
		//Return nothing
	}

    
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onDragEvent(DragEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    public boolean dispatchDragEvent(DragEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event)) {
            return true;
        }
        return onDragEvent(event);
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    boolean canAcceptDrag(){
		// Original method
		/*
		{
        return (mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void onCloseSystemDialogs(String reason){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    public void applyDrawableToTransparentRegion(Drawable dr, Region region){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void checkForLongClick(int delayOffset){
		// Original method
		/*
		{
        if ((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) {
            mHasPerformedLongPress = false;
            if (mPendingCheckForLongPress == null) {
                mPendingCheckForLongPress = new CheckForLongPress();
            }
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress,
                    ViewConfiguration.getLongPressTimeout() - delayOffset);
        }
    }
		*/
		//Return nothing
	}

    
    public static View inflate(Context context, int resource, ViewGroup root){
		// Original method
		/*
		{
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }
		*/
		return null;
	}

    
    @SuppressWarnings({"UnusedParameters"}) 
	protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getOverScrollMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mOverScrollMode;
    }
		*/
	}

    
    public void setOverScrollMode(int overScrollMode){
		addTaint(overScrollMode);
		// Original method
		/*
		{
        if (overScrollMode != OVER_SCROLL_ALWAYS &&
                overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                overScrollMode != OVER_SCROLL_NEVER) {
            throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        }
        mOverScrollMode = overScrollMode;
    }
		*/
		//Return nothing
	}

    
    protected float getVerticalScrollFactor(){
		return getTaintFloat();
		// Original method
		/*
		{
        if (mVerticalScrollFactor == 0) {
            TypedValue outValue = new TypedValue();
            if (!mContext.getTheme().resolveAttribute(
                    com.android.internal.R.attr.listPreferredItemHeight, outValue, true)) {
                throw new IllegalStateException(
                        "Expected theme to define listPreferredItemHeight.");
            }
            mVerticalScrollFactor = outValue.getDimension(
                    mContext.getResources().getDisplayMetrics());
        }
        return mVerticalScrollFactor;
    }
		*/
	}

    
    protected float getHorizontalScrollFactor(){
		// Original method
		/*
		{
        return getVerticalScrollFactor();
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    public int getTextDirection(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTextDirection;
    }
		*/
	}

    
    public void setTextDirection(int textDirection){
		// Original method
		/*
		{
        if (textDirection != mTextDirection) {
            mTextDirection = textDirection;
            resetResolvedTextDirection();
            requestLayout();
        }
    }
		*/
		//Return nothing
	}

    
    public int getResolvedTextDirection(){
		// Original method
		/*
		{
        if (mResolvedTextDirection == TEXT_DIRECTION_INHERIT) {
            resolveTextDirection();
        }
        return mResolvedTextDirection;
    }
		*/
    	if (mResolvedTextDirection == TEXT_DIRECTION_INHERIT) {
            resolveTextDirection();
        }
        return mResolvedTextDirection;
	}

    
    protected void resolveTextDirection(){
		// Original method
		/*
		{
        if (mTextDirection != TEXT_DIRECTION_INHERIT) {
            mResolvedTextDirection = mTextDirection;
            return;
        }
        if (mParent != null && mParent instanceof ViewGroup) {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            return;
        }
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
    }
		*/
		//Return nothing
    	if (mTextDirection != TEXT_DIRECTION_INHERIT) {
            mResolvedTextDirection = mTextDirection;
            return;
        }
        if (mParent != null && mParent instanceof ViewGroup) {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            return;
        }
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
	}

    
    @DSModeled(DSC.SAFE)
    protected void resetResolvedTextDirection(){
		// Original method
		/*
		{
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void hackTurnOffWindowResizeAnim(boolean off){
		// Original method
		/*
		{
        mAttachInfo.mTurnOffWindowResizeAnim = off;
    }
		*/
		//Return nothing
	}

    
    public ViewPropertyAnimator animate(){
        mAnimator = new ViewPropertyAnimator(this);
        return mAnimator;
		// Original method
		/*
		{
        if (mAnimator == null) {
            mAnimator = new ViewPropertyAnimator(this);
        }
        return mAnimator;
    }
		*/
	}

    
    static class TransformationInfo {
        private final Matrix mMatrix = new Matrix();
        private Matrix mInverseMatrix;
        boolean mMatrixDirty = false;
        private boolean mInverseMatrixDirty = true;
        private boolean mMatrixIsIdentity = true;
        private Camera mCamera = null;
        private Matrix matrix3D = null;
        private int mPrevWidth = -1;
        private int mPrevHeight = -1;
        @ViewDebug.ExportedProperty
        float mRotationY = 0f;
        @ViewDebug.ExportedProperty
        float mRotationX = 0f;
        @ViewDebug.ExportedProperty
        float mRotation = 0f;
        @ViewDebug.ExportedProperty
        float mTranslationX = 0f;
        @ViewDebug.ExportedProperty
        float mTranslationY = 0f;
        @ViewDebug.ExportedProperty
        float mScaleX = 1f;
        @ViewDebug.ExportedProperty
        float mScaleY = 1f;
        @ViewDebug.ExportedProperty
        float mPivotX = 0f;
        @ViewDebug.ExportedProperty
        float mPivotY = 0f;
        @ViewDebug.ExportedProperty
        float mAlpha = 1f;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.648 -0400", hash_original_method = "047CC1B263AEE84E056E34E366D57D72", hash_generated_method = "047CC1B263AEE84E056E34E366D57D72")
        public TransformationInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static class ListenerInfo {
        protected OnFocusChangeListener mOnFocusChangeListener;
        private ArrayList<OnLayoutChangeListener> mOnLayoutChangeListeners;
        private CopyOnWriteArrayList<OnAttachStateChangeListener> mOnAttachStateChangeListeners;
        public OnClickListener mOnClickListener;
        protected OnLongClickListener mOnLongClickListener;
        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
        private OnKeyListener mOnKeyListener;
        private OnTouchListener mOnTouchListener;
        private OnHoverListener mOnHoverListener;
        private OnGenericMotionListener mOnGenericMotionListener;
        private OnDragListener mOnDragListener;
        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.649 -0400", hash_original_method = "30D31F497118E5B2F2D60734B7298038", hash_generated_method = "30D31F497118E5B2F2D60734B7298038")
        public ListenerInfo ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DragShadowBuilder {
        private final WeakReference<View> mView;
        
        public DragShadowBuilder(View view){
			mView = new WeakReference<View>(view);
			/*
			mView = new WeakReference<View>(view);
			*/
		}

        
        DragShadowBuilder(){
			mView = new WeakReference<View>(null);
			/*
			mView = new WeakReference<View>(null);
			*/
		}

        
        @SuppressWarnings({"JavadocReference"}) 
		final public View getView(){
			// Original method
			/*
			{
            return mView.get();
        }
			*/
			return null;
		}

        
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint){
			// Original method
			/*
			{
            final View view = mView.get();
            if (view != null) {
                shadowSize.set(view.getWidth(), view.getHeight());
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            } else {
                Log.e(View.VIEW_LOG_TAG, "Asked for drag thumb metrics but no view");
            }
        }
			*/
			//Return nothing
		}

        
        public void onDrawShadow(Canvas canvas){
			// Original method
			/*
			{
            final View view = mView.get();
            if (view != null) {
                view.draw(canvas);
            } else {
                Log.e(View.VIEW_LOG_TAG, "Asked to draw drag shadow but no view");
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    public static class MeasureSpec {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.651 -0400", hash_original_method = "2EA619F0F89BA048B9092F3C9EFB9775", hash_generated_method = "2EA619F0F89BA048B9092F3C9EFB9775")
        public MeasureSpec ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public static int makeMeasureSpec(int size, int mode){
			// Original method
			/*
			{
            return size + mode;
        }
			*/
			return 0;
		}

        
        @DSModeled(DSC.SAFE)
        public static int getMode(int measureSpec){
			// Original method
			/*
			{
            return (measureSpec & MODE_MASK);
        }
			*/
			return 0;
		}

        
        @DSModeled(DSC.SAFE)
        public static int getSize(int measureSpec){
			// Original method
			/*
			{
            return (measureSpec & ~MODE_MASK);
        }
			*/
			return 0;
		}

        
        public static String toString(int measureSpec){
			// Original method
			/*
			{
            int mode = getMode(measureSpec);
            int size = getSize(measureSpec);
            StringBuilder sb = new StringBuilder("MeasureSpec: ");
            if (mode == UNSPECIFIED)
                sb.append("UNSPECIFIED ");
            else if (mode == EXACTLY)
                sb.append("EXACTLY ");
            else if (mode == AT_MOST)
                sb.append("AT_MOST ");
            else
                sb.append(mode).append(" ");
            sb.append(size);
            return sb.toString();
        }
			*/
			return "";
		}

        
        private static final int MODE_SHIFT = 30;
        private static final int MODE_MASK  = 0x3 << MODE_SHIFT;
        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
        public static final int EXACTLY     = 1 << MODE_SHIFT;
        public static final int AT_MOST     = 2 << MODE_SHIFT;
    }


    
    class CheckForLongPress implements Runnable {
        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.652 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            if (isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount) {
                if (performLongClick()) {
                    mHasPerformedLongPress = true;
                }
            }
        }
			*/
			//Return nothing
		}

        
        @DSModeled(DSC.SAFE)
        public void rememberWindowAttachCount(){
			// Original method
			/*
			{
            mOriginalWindowAttachCount = mWindowAttachCount;
        }
			*/
			//Return nothing
		}

        
    }


    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            mPrivateFlags &= ~PREPRESSED;
            mPrivateFlags |= PRESSED;
            refreshDrawableState();
            checkForLongClick(ViewConfiguration.getTapTimeout());
        }
			*/
			//Return nothing
		}

        
    }


    
    private final class PerformClick implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            performClick();
        }
			*/
			//Return nothing
		}

        
    }


    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "6C14B43BA30389F098070D93AD09F5B4", hash_generated_method = "6C14B43BA30389F098070D93AD09F5B4")
        public UnsetPressedState ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            setPressed(false);
        }
			*/
			//Return nothing
		}

        
    }


    
    public static class BaseSavedState extends AbsSavedState {
        
        public BaseSavedState(Parcel source){
			super(source);
		}

        
        public BaseSavedState(Parcelable superState){
			super(superState);
		}

        
        public static final Parcelable.Creator<BaseSavedState> CREATOR =
                new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };
    }


    
    static class AttachInfo {
        final IWindowSession mSession;
        final IWindow mWindow;
        final IBinder mWindowToken;
        final Callbacks mRootCallbacks;
        HardwareCanvas mHardwareCanvas;
        View mRootView;
        IBinder mPanelParentWindowToken;
        Surface mSurface;
        boolean mHardwareAccelerated;
        boolean mHardwareAccelerationRequested;
        HardwareRenderer mHardwareRenderer;
        float mApplicationScale;
        boolean mScalingRequired;
        boolean mTurnOffWindowResizeAnim;
        int mWindowLeft;
        int mWindowTop;
        boolean mUse32BitDrawingCache;
        final Rect mContentInsets = new Rect();
        final Rect mVisibleInsets = new Rect();
        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets
                = new ViewTreeObserver.InternalInsetsInfo();
        final ArrayList<View> mScrollContainers = new ArrayList<View>();
        final KeyEvent.DispatcherState mKeyDispatchState
                = new KeyEvent.DispatcherState();
        boolean mHasWindowFocus;
        int mWindowVisibility;
        long mDrawingTime;
        boolean mIgnoreDirtyState;
        boolean mSetIgnoreDirtyState = false;
        boolean mInTouchMode;
        boolean mRecomputeGlobalAttributes;
        boolean mForceReportNewAttributes;
        boolean mKeepScreenOn;
        int mSystemUiVisibility;
        boolean mHasSystemUiListeners;
        boolean mViewVisibilityChanged;
        boolean mViewScrollChanged;
        final int[] mTransparentLocation = new int[2];
        final int[] mInvalidateChildLocation = new int[2];
        final float[] mTmpTransformLocation = new float[2];
        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        Canvas mCanvas;
        final Handler mHandler;
        final Rect mTmpInvalRect = new Rect();
        final RectF mTmpTransformRect = new RectF();
        final ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        int mAccessibilityWindowId = View.NO_ID;
        
        AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer){
			mSession = session;  //Preserved
			mWindow = window;  //Preserved
			mWindowToken = window.asBinder();  //Preserved DSFIXME:  Track the taint!
			mHandler = handler;  //Preserved
			mRootCallbacks = effectPlayer;  //Preserved
			/*
			mSession = session;
			mWindow = window;
			mWindowToken = window.asBinder();
			mHandler = handler;
			mRootCallbacks = effectPlayer;
			*/
		}

        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            private InvalidateInfo mNext;
            private boolean mIsPooled;
            View target;
            int left;
            int top;
            int right;
            int bottom;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.656 -0400", hash_original_method = "7F8409C46E15AE6EC7087A7F4E97E2BF", hash_generated_method = "7F8409C46E15AE6EC7087A7F4E97E2BF")
            public InvalidateInfo ()
            {
                //Synthesized constructor
            }


            @DSModeled(DSC.SAFE)
            public void setNextPoolable(InvalidateInfo element){
				mNext = element;
				// Original method
				/*
				{
                mNext = element;
            }
				*/
				//Return nothing
			}

            
            @DSModeled(DSC.SAFE)
            public InvalidateInfo getNextPoolable(){
				return mNext;
				// Original method
				/*
				{
                return mNext;
            }
				*/
			}

            
            static InvalidateInfo acquire(){
				// Original method
				/*
				{
                return sPool.acquire();
            }
				*/
				return null;
			}

            
            void release(){
				// Original method
				/*
				{
                sPool.release(this);
            }
				*/
				//Return nothing
			}

            
            @DSModeled(DSC.SAFE)
            public boolean isPooled(){
				return getTaintBoolean();
				// Original method
				/*
				{
                return mIsPooled;
            }
				*/
			}

            
            @DSModeled(DSC.SAFE)
            public void setPooled(boolean isPooled){
				addTaint(isPooled);
				// Original method
				/*
				{
                mIsPooled = isPooled;
            }
				*/
				//Return nothing
			}

            
            private static final int POOL_LIMIT = 10;
            private static final Pool<InvalidateInfo> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<InvalidateInfo>() {
                        public InvalidateInfo newInstance() {
                            return new InvalidateInfo();
                        }

                        @DSModeled(DSC.SAFE)
                public void onAcquired(InvalidateInfo element) {
                        }

                        @DSModeled(DSC.SAFE)
                public void onReleased(InvalidateInfo element) {
                            element.target = null;
                        }
                    }, POOL_LIMIT)
            );
        }


        
        interface Callbacks {
            void playSoundEffect(int effectId);
            boolean performHapticFeedback(int effectId, boolean always);
        }
        
        static final int INVALIDATE_MSG = 0x1;
        static final int INVALIDATE_RECT_MSG = 0x2;
    }


    
    private static class ScrollabilityCache implements Runnable {
        public boolean fadeScrollBars;
        public int fadingEdgeLength;
        public int scrollBarDefaultDelayBeforeFade;
        public int scrollBarFadeDuration;
        public int scrollBarSize;
        public ScrollBarDrawable scrollBar;
        public float[] interpolatorValues;
        public View host;
        public final Paint paint;
        public final Matrix matrix;
        public Shader shader;
        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        public long fadeStartTime;
        public int state = OFF;
        private int mLastColor;
        
        ScrollabilityCache(ViewConfiguration configuration, View host){
			paint = new Paint();
			matrix = new Matrix();
			/*
			fadingEdgeLength = configuration.getScaledFadingEdgeLength();
			scrollBarSize = configuration.getScaledScrollBarSize();
			scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
			scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
			paint = new Paint();
			matrix = new Matrix();
			shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
			this.host = host;
			*/
		}

        
        public void setFadeColor(int color){
			// Original method
			/*
			{
            if (color != 0 && color != mLastColor) {
                mLastColor = color;
                color |= 0xFF000000;
                shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            }
        }
			*/
			//Return nothing
		}

        
        public void run(){
			// Original method
			/*
			{
            long now = AnimationUtils.currentAnimationTimeMillis();
            if (now >= fadeStartTime) {
                int nextFrame = (int) now;
                int framesCount = 0;
                Interpolator interpolator = scrollBarInterpolator;
                interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                nextFrame += scrollBarFadeDuration;
                interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                state = FADING;
                host.invalidate(true);
            }
        }
			*/
			//Return nothing
		}

        
        public static final int OFF = 0;
        public static final int ON = 1;
        public static final int FADING = 2;
        private static final float[] OPAQUE = { 255 };
        private static final float[] TRANSPARENT = { 0.0f };
    }


    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.663 -0400", hash_original_method = "67D827D7B507D3EF133C26B0E057ECB2", hash_generated_method = "67D827D7B507D3EF133C26B0E057ECB2")
        public SendViewScrolledAccessibilityEvent ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
        }
			*/
			//Return nothing
		}

        
    }


    
    public static class AccessibilityDelegate {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.663 -0400", hash_original_method = "B81C1E38B66B1195ED1D00E194D402D3", hash_generated_method = "B81C1E38B66B1195ED1D00E194D402D3")
        public AccessibilityDelegate ()
        {
            //Synthesized constructor
        }


        public void sendAccessibilityEvent(View host, int eventType){
			// Original method
			/*
			{
            host.sendAccessibilityEventInternal(eventType);
        }
			*/
			//Return nothing
		}

        
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event){
			// Original method
			/*
			{
            host.sendAccessibilityEventUncheckedInternal(event);
        }
			*/
			//Return nothing
		}

        
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event){
			// Original method
			/*
			{
            return host.dispatchPopulateAccessibilityEventInternal(event);
        }
			*/
			return false;
		}

        
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event){
			// Original method
			/*
			{
            host.onPopulateAccessibilityEventInternal(event);
        }
			*/
			//Return nothing
		}

        
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event){
			// Original method
			/*
			{
            host.onInitializeAccessibilityEventInternal(event);
        }
			*/
			//Return nothing
		}

        
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info){
			// Original method
			/*
			{
            host.onInitializeAccessibilityNodeInfoInternal(info);
        }
			*/
			//Return nothing
		}

        
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event){
			// Original method
			/*
			{
            return host.onRequestSendAccessibilityEventInternal(child, event);
        }
			*/
			return false;
		}

        
    }


    
    public interface OnLayoutChangeListener {
        
        void onLayoutChange(View v, int left, int top, int right, int bottom,
            int oldLeft, int oldTop, int oldRight, int oldBottom);
    }
    
    public interface OnKeyListener {
        
        boolean onKey(View v, int keyCode, KeyEvent event);
    }
    
    public interface OnTouchListener {
        
        boolean onTouch(View v, MotionEvent event);
    }
    
    public interface OnHoverListener {
        
        boolean onHover(View v, MotionEvent event);
    }
    
    public interface OnGenericMotionListener {
        
        boolean onGenericMotion(View v, MotionEvent event);
    }
    
    public interface OnLongClickListener {
        
        boolean onLongClick(View v);
    }
    
    public interface OnDragListener {
        
        boolean onDrag(View v, DragEvent event);
    }
    
    public interface OnFocusChangeListener {
        
        void onFocusChange(View v, boolean hasFocus);
    }
    
    public interface OnClickListener {
        
        void onClick(View v);
    }
    
    public interface OnCreateContextMenuListener {
        
        void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo);
    }
    
    public interface OnSystemUiVisibilityChangeListener {
        
        public void onSystemUiVisibilityChange(int visibility);
    }
    
    public interface OnAttachStateChangeListener {
        
        public void onViewAttachedToWindow(View v);
        
        public void onViewDetachedFromWindow(View v);
    }
    
    private static final boolean DBG = false;
    protected static final String VIEW_LOG_TAG = "View";
    public static final int NO_ID = -1;
    private static final int NOT_FOCUSABLE = 0x00000000;
    private static final int FOCUSABLE = 0x00000001;
    private static final int FOCUSABLE_MASK = 0x00000001;
    private static final int FITS_SYSTEM_WINDOWS = 0x00000002;
    public static final int VISIBLE = 0x00000000;
    public static final int INVISIBLE = 0x00000004;
    public static final int GONE = 0x00000008;
    static final int VISIBILITY_MASK = 0x0000000C;
    private static final int[] VISIBILITY_FLAGS = {VISIBLE, INVISIBLE, GONE};
    static final int ENABLED = 0x00000000;
    static final int DISABLED = 0x00000020;
    static final int ENABLED_MASK = 0x00000020;
    static final int WILL_NOT_DRAW = 0x00000080;
    static final int DRAW_MASK = 0x00000080;
    static final int SCROLLBARS_NONE = 0x00000000;
    static final int SCROLLBARS_HORIZONTAL = 0x00000100;
    static final int SCROLLBARS_VERTICAL = 0x00000200;
    static final int SCROLLBARS_MASK = 0x00000300;
    static final int FILTER_TOUCHES_WHEN_OBSCURED = 0x00000400;
    static final int FADING_EDGE_NONE = 0x00000000;
    static final int FADING_EDGE_HORIZONTAL = 0x00001000;
    static final int FADING_EDGE_VERTICAL = 0x00002000;
    static final int FADING_EDGE_MASK = 0x00003000;
    static final int CLICKABLE = 0x00004000;
    static final int DRAWING_CACHE_ENABLED = 0x00008000;
    static final int SAVE_DISABLED = 0x000010000;
    static final int SAVE_DISABLED_MASK = 0x000010000;
    static final int WILL_NOT_CACHE_DRAWING = 0x000020000;
    static final int FOCUSABLE_IN_TOUCH_MODE = 0x00040000;
    public static final int DRAWING_CACHE_QUALITY_LOW = 0x00080000;
    public static final int DRAWING_CACHE_QUALITY_HIGH = 0x00100000;
    public static final int DRAWING_CACHE_QUALITY_AUTO = 0x00000000;
    private static final int[] DRAWING_CACHE_QUALITY_FLAGS = {
            DRAWING_CACHE_QUALITY_AUTO, DRAWING_CACHE_QUALITY_LOW, DRAWING_CACHE_QUALITY_HIGH
    };
    static final int DRAWING_CACHE_QUALITY_MASK = 0x00180000;
    static final int LONG_CLICKABLE = 0x00200000;
    static final int DUPLICATE_PARENT_STATE = 0x00400000;
    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    public static final int SCROLLBARS_INSIDE_INSET = 0x01000000;
    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 0x02000000;
    public static final int SCROLLBARS_OUTSIDE_INSET = 0x03000000;
    static final int SCROLLBARS_INSET_MASK = 0x01000000;
    static final int SCROLLBARS_OUTSIDE_MASK = 0x02000000;
    static final int SCROLLBARS_STYLE_MASK = 0x03000000;
    public static final int KEEP_SCREEN_ON = 0x04000000;
    public static final int SOUND_EFFECTS_ENABLED = 0x08000000;
    public static final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
    static final int PARENT_SAVE_DISABLED = 0x20000000;
    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;
    public static final int LAYOUT_DIRECTION_LTR = 0x00000000;
    public static final int LAYOUT_DIRECTION_RTL = 0x40000000;
    public static final int LAYOUT_DIRECTION_INHERIT = 0x80000000;
    public static final int LAYOUT_DIRECTION_LOCALE = 0xC0000000;
    static final int LAYOUT_DIRECTION_MASK = 0xC0000000;
    private static final int[] LAYOUT_DIRECTION_FLAGS = {LAYOUT_DIRECTION_LTR,
        LAYOUT_DIRECTION_RTL, LAYOUT_DIRECTION_INHERIT, LAYOUT_DIRECTION_LOCALE};
    private static final int LAYOUT_DIRECTION_DEFAULT = LAYOUT_DIRECTION_INHERIT;
    public static final int FOCUSABLES_ALL = 0x00000000;
    public static final int FOCUSABLES_TOUCH_MODE = 0x00000001;
    public static final int FOCUS_BACKWARD = 0x00000001;
    public static final int FOCUS_FORWARD = 0x00000002;
    public static final int FOCUS_LEFT = 0x00000011;
    public static final int FOCUS_UP = 0x00000021;
    public static final int FOCUS_RIGHT = 0x00000042;
    public static final int FOCUS_DOWN = 0x00000082;
    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
    public static final int MEASURED_STATE_MASK = 0xff000000;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_STATE_TOO_SMALL = 0x01000000;
    protected static final int[] EMPTY_STATE_SET;
    protected static final int[] ENABLED_STATE_SET;
    protected static final int[] FOCUSED_STATE_SET;
    protected static final int[] SELECTED_STATE_SET;
    protected static final int[] PRESSED_STATE_SET;
    protected static final int[] WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_SELECTED_STATE_SET;
    protected static final int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] FOCUSED_SELECTED_STATE_SET;
    protected static final int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    private static final int[][] VIEW_STATE_SETS;
    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    static final int VIEW_STATE_SELECTED = 1 << 1;
    static final int VIEW_STATE_FOCUSED = 1 << 2;
    static final int VIEW_STATE_ENABLED = 1 << 3;
    static final int VIEW_STATE_PRESSED = 1 << 4;
    static final int VIEW_STATE_ACTIVATED = 1 << 5;
    static final int VIEW_STATE_ACCELERATED = 1 << 6;
    static final int VIEW_STATE_HOVERED = 1 << 7;
    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 1 << 8;
    static final int VIEW_STATE_DRAG_HOVERED = 1 << 9;
    static final int[] VIEW_STATE_IDS = new int[] {
        R.attr.state_window_focused,    VIEW_STATE_WINDOW_FOCUSED,
        R.attr.state_selected,          VIEW_STATE_SELECTED,
        R.attr.state_focused,           VIEW_STATE_FOCUSED,
        R.attr.state_enabled,           VIEW_STATE_ENABLED,
        R.attr.state_pressed,           VIEW_STATE_PRESSED,
        R.attr.state_activated,         VIEW_STATE_ACTIVATED,
        R.attr.state_accelerated,       VIEW_STATE_ACCELERATED,
        R.attr.state_hovered,           VIEW_STATE_HOVERED,
        R.attr.state_drag_can_accept,   VIEW_STATE_DRAG_CAN_ACCEPT,
        R.attr.state_drag_hovered,      VIEW_STATE_DRAG_HOVERED,
    };
    static {
        if ((VIEW_STATE_IDS.length/2) != R.styleable.ViewDrawableStates.length) {
            throw new IllegalStateException(
                    "VIEW_STATE_IDs array length does not match ViewDrawableStates style array");
        }
        int[] orderedIds = new int[VIEW_STATE_IDS.length];
        for (int i = 0; i < R.styleable.ViewDrawableStates.length; i++) {
            int viewState = R.styleable.ViewDrawableStates[i];
            for (int j = 0; j<VIEW_STATE_IDS.length; j += 2) {
                if (VIEW_STATE_IDS[j] == viewState) {
                    orderedIds[i * 2] = viewState;
                    orderedIds[i * 2 + 1] = VIEW_STATE_IDS[j + 1];
                }
            }
        }
        final int NUM_BITS = VIEW_STATE_IDS.length / 2;
        VIEW_STATE_SETS = new int[1 << NUM_BITS][];
        for (int i = 0; i < VIEW_STATE_SETS.length; i++) {
            int numBits = Integer.bitCount(i);
            int[] set = new int[numBits];
            int pos = 0;
            for (int j = 0; j < orderedIds.length; j += 2) {
                if ((i & orderedIds[j+1]) != 0) {
                    set[pos++] = orderedIds[j];
                }
            }
            VIEW_STATE_SETS[i] = set;
        }
        EMPTY_STATE_SET = VIEW_STATE_SETS[0];
        WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_WINDOW_FOCUSED];
        SELECTED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_SELECTED];
        SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED];
        FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_FOCUSED];
        FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED];
        ENABLED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_ENABLED];
        ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED];
        PRESSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_PRESSED];
        PRESSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
    }
    
    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES =
            AccessibilityEvent.TYPE_VIEW_CLICKED
            | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
            | AccessibilityEvent.TYPE_VIEW_SELECTED
            | AccessibilityEvent.TYPE_VIEW_FOCUSED
            | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            | AccessibilityEvent.TYPE_VIEW_HOVER_ENTER
            | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT
            | AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
            | AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
    static final ThreadLocal<Rect> sThreadLocal = new ThreadLocal<Rect>();
    private static int sNextAccessibilityViewId;
    static final int WANTS_FOCUS                    = 0x00000001;
    static final int FOCUSED                        = 0x00000002;
    static final int SELECTED                       = 0x00000004;
    static final int IS_ROOT_NAMESPACE              = 0x00000008;
    static final int HAS_BOUNDS                     = 0x00000010;
    static final int DRAWN                          = 0x00000020;
    static final int DRAW_ANIMATION                 = 0x00000040;
    static final int SKIP_DRAW                      = 0x00000080;
    static final int ONLY_DRAWS_BACKGROUND          = 0x00000100;
    static final int REQUEST_TRANSPARENT_REGIONS    = 0x00000200;
    static final int DRAWABLE_STATE_DIRTY           = 0x00000400;
    static final int MEASURED_DIMENSION_SET         = 0x00000800;
    static final int FORCE_LAYOUT                   = 0x00001000;
    static final int LAYOUT_REQUIRED                = 0x00002000;
    private static final int PRESSED                = 0x00004000;
    static final int DRAWING_CACHE_VALID            = 0x00008000;
    static final int ANIMATION_STARTED              = 0x00010000;
    private static final int SAVE_STATE_CALLED      = 0x00020000;
    static final int ALPHA_SET                      = 0x00040000;
    static final int SCROLL_CONTAINER               = 0x00080000;
    static final int SCROLL_CONTAINER_ADDED         = 0x00100000;
    static final int DIRTY                          = 0x00200000;
    static final int DIRTY_OPAQUE                   = 0x00400000;
    static final int DIRTY_MASK                     = 0x00600000;
    static final int OPAQUE_BACKGROUND              = 0x00800000;
    static final int OPAQUE_SCROLLBARS              = 0x01000000;
    static final int OPAQUE_MASK                    = 0x01800000;
    private static final int PREPRESSED             = 0x02000000;
    static final int CANCEL_NEXT_UP_EVENT = 0x04000000;
    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x08000000;
    private static final int HOVERED              = 0x10000000;
    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;
    static final int ACTIVATED                    = 0x40000000;
    static final int INVALIDATED                  = 0x80000000;
    static final int DRAG_CAN_ACCEPT              = 0x00000001;
    static final int DRAG_HOVERED                 = 0x00000002;
    static final int LAYOUT_DIRECTION_RESOLVED_RTL = 0x00000004;
    static final int LAYOUT_DIRECTION_RESOLVED = 0x00000008;
    static final int DRAG_MASK = DRAG_CAN_ACCEPT | DRAG_HOVERED;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 0x00000001;
    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 0x00000002;
    public static final int STATUS_BAR_HIDDEN = SYSTEM_UI_FLAG_LOW_PROFILE;
    public static final int STATUS_BAR_VISIBLE = SYSTEM_UI_FLAG_VISIBLE;
    public static final int STATUS_BAR_DISABLE_EXPAND = 0x00010000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 0x00020000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 0x00040000;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 0x00080000;
    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 0x00100000;
    public static final int STATUS_BAR_DISABLE_HOME = 0x00200000;
    public static final int STATUS_BAR_DISABLE_BACK = 0x00400000;
    public static final int STATUS_BAR_DISABLE_CLOCK = 0x00800000;
    public static final int STATUS_BAR_DISABLE_RECENT = 0x01000000;
    @Deprecated
    public static final int STATUS_BAR_DISABLE_NAVIGATION = 
            STATUS_BAR_DISABLE_HOME | STATUS_BAR_DISABLE_RECENT;
    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 0x0000FFFF;
    public static final int SYSTEM_UI_CLEARABLE_FLAGS =
            SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    public static final int FIND_VIEWS_WITH_TEXT = 0x00000001;
    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 0x00000002;
    private static final float NONZERO_EPSILON = .001f;
    public static final int DRAG_FLAG_GLOBAL = 1;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int TEXT_DIRECTION_INHERIT = 0;
    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    public static final int TEXT_DIRECTION_LTR = 3;
    public static final int TEXT_DIRECTION_RTL = 4;
    protected static int DEFAULT_TEXT_DIRECTION = TEXT_DIRECTION_INHERIT;
    
    static class MyFloatPropertyView extends FloatProperty<View> {

        @DSModeled(DSC.SAFE)
        public MyFloatPropertyView(String str) {
            super(str);
        }

        public Float get(View v) {
            return Float.valueOf(getTaintFloat());
        }
    }

    public static Property<View, Float> ALPHA = new MyFloatPropertyView("alpha");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.675 -0400", hash_original_field = "2463A82C1B3B068FBED45F14B07DEA60", hash_generated_field = "2E88A25ECF88D0581B11F01DDC5B788E")

    public static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.675 -0400", hash_original_method = "71D30789CC0083AAA14E647D4066A62B", hash_generated_method = "A4CA630E3A6CE2DB963A21903A3B8B1A")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setTranslationX(value);
            // ---------- Original Method ----------
            //object.setTranslationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.675 -0400", hash_original_method = "AE4ED8B1A0B86A64F67E6D55304484F8", hash_generated_method = "1D8264874C1928BE149BE425BFCA7426")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var1EE961A971645330A9017F7FA3785D71_957435700 =             object.getTranslationX();
            var1EE961A971645330A9017F7FA3785D71_957435700.addTaint(taint);
            return var1EE961A971645330A9017F7FA3785D71_957435700;
            // ---------- Original Method ----------
            //return object.getTranslationX();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.676 -0400", hash_original_field = "7372D8389B757BEF40F84E15ACD0B19E", hash_generated_field = "3514365D38BDAF2F2F1CD4EFBC59F1B9")

    public static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.676 -0400", hash_original_method = "35EB991A21102AE6A66798A0E05F4EB7", hash_generated_method = "A5EBF576D4F376228384178650B915B8")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setTranslationY(value);
            // ---------- Original Method ----------
            //object.setTranslationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.676 -0400", hash_original_method = "602B4C29E3FDDB39DD10FBFA4C1D4EAD", hash_generated_method = "6FB57E8001B90DEEE9BE11440DF351D9")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var2F73F18B2F448957B7F4A6042BFE42D7_1141995321 =             object.getTranslationY();
            var2F73F18B2F448957B7F4A6042BFE42D7_1141995321.addTaint(taint);
            return var2F73F18B2F448957B7F4A6042BFE42D7_1141995321;
            // ---------- Original Method ----------
            //return object.getTranslationY();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.677 -0400", hash_original_field = "7ABCFD2CD0D4C099DC453E558FE85F44", hash_generated_field = "9AE8BCB9ADF5964753832A0E9C82085F")

    public static Property<View, Float> X = new FloatProperty<View>("x") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.677 -0400", hash_original_method = "942D12A2907E436F9DD2D5A3BB599D1C", hash_generated_method = "5AD321261CD4E7CAE9C55D29082D3984")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setX(value);
            // ---------- Original Method ----------
            //object.setX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.677 -0400", hash_original_method = "87F550DC0E1D4FED879AF17D796C775D", hash_generated_method = "F776345D7AF71C0CCC5CABC0EAE37559")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var79139FA0C6BFD7D541A918F05D3438FA_746831689 =             object.getX();
            var79139FA0C6BFD7D541A918F05D3438FA_746831689.addTaint(taint);
            return var79139FA0C6BFD7D541A918F05D3438FA_746831689;
            // ---------- Original Method ----------
            //return object.getX();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.678 -0400", hash_original_field = "CFD3CAFD4126436BCB87BFC085957E57", hash_generated_field = "D23D2D01DF692E441C62FAF9235D2C1B")

    public static Property<View, Float> Y = new FloatProperty<View>("y") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.677 -0400", hash_original_method = "F66C6BF603238C3B745DBF80CCB68E15", hash_generated_method = "125CC8AFE1A0A06C7B8226AAB9171D95")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setY(value);
            // ---------- Original Method ----------
            //object.setY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.678 -0400", hash_original_method = "107F13AA20F45AE0A7AF10B2A89B1B3D", hash_generated_method = "60F1EA2015E6D9801FCE3C335A8D2C71")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var9946FB3F09262FEAAE01246CE687D806_312564050 =             object.getY();
            var9946FB3F09262FEAAE01246CE687D806_312564050.addTaint(taint);
            return var9946FB3F09262FEAAE01246CE687D806_312564050;
            // ---------- Original Method ----------
            //return object.getY();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_field = "E56D0E5046417B3F74FFC7B03E80BE5C", hash_generated_field = "FB557AFE67B470E71F7C64EE24F6E3BE")

    public static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.678 -0400", hash_original_method = "E4DD5C8F5E4B6A35D65B3372F3D8BFBA", hash_generated_method = "55BCC4A7C747CD5CD469C514CC0ACBCC")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setRotation(value);
            // ---------- Original Method ----------
            //object.setRotation(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.678 -0400", hash_original_method = "6F0DC1763312BEA34F1272E5458BA30D", hash_generated_method = "93A1247B93F525A70AF24AACE1BCE202")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float varD66D8769C4B60D584C7FF909FDCA35BF_1043115386 =             object.getRotation();
            varD66D8769C4B60D584C7FF909FDCA35BF_1043115386.addTaint(taint);
            return varD66D8769C4B60D584C7FF909FDCA35BF_1043115386;
            // ---------- Original Method ----------
            //return object.getRotation();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_field = "E6B3F0C9E4238E32ABB7463CE9AD008B", hash_generated_field = "325BD964137AF15B5513B111B09E57AF")

    public static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_method = "D8E97A391BF9703940D7A06280ABBB3F", hash_generated_method = "F3C04BF826D916D7D1A9BBCDB86E7972")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setRotationX(value);
            // ---------- Original Method ----------
            //object.setRotationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_method = "3FE8B70962F32AF948528D0D6E8ED1AF", hash_generated_method = "C643B80BDEE48811955C32164EE25D31")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var26159A98B1309CAF2C6FE688F8F28145_1018722032 =             object.getRotationX();
            var26159A98B1309CAF2C6FE688F8F28145_1018722032.addTaint(taint);
            return var26159A98B1309CAF2C6FE688F8F28145_1018722032;
            // ---------- Original Method ----------
            //return object.getRotationX();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.681 -0400", hash_original_field = "E871DD5638C4B35E145FF614A448D053", hash_generated_field = "BA1634E8F9B2BA862DD6DB1E36053562")

    public static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.680 -0400", hash_original_method = "CDE80AB2A44D5B173DB76AD6CA4559A4", hash_generated_method = "4D4247D1DC57CB25069C48F0A3026E18")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setRotationY(value);
            // ---------- Original Method ----------
            //object.setRotationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.680 -0400", hash_original_method = "EE835584282672E99083546AE5304355", hash_generated_method = "EC3104706FF00573D1C74D896F7BC9D4")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float varFEFF6D02FE31E0E71A8B442456325A47_978011147 =             object.getRotationY();
            varFEFF6D02FE31E0E71A8B442456325A47_978011147.addTaint(taint);
            return varFEFF6D02FE31E0E71A8B442456325A47_978011147;
            // ---------- Original Method ----------
            //return object.getRotationY();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.682 -0400", hash_original_field = "D10E65978F70513DFF3F1897F968D4D2", hash_generated_field = "5F4C99EEC421BEF559C61A599C6B6AA3")

    public static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.681 -0400", hash_original_method = "1B653DA1FDE36CFBF0835E42B933826F", hash_generated_method = "F8E41B724A022763691029E682DBD544")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setScaleX(value);
            // ---------- Original Method ----------
            //object.setScaleX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.682 -0400", hash_original_method = "A2F336BAC519262505475338F6D5EC55", hash_generated_method = "7C0D10D0B10CEFE8BE321B44DFB2FDC6")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var29A25D8E5214EC0587BAF5FE326BDD85_1350607049 =             object.getScaleX();
            var29A25D8E5214EC0587BAF5FE326BDD85_1350607049.addTaint(taint);
            return var29A25D8E5214EC0587BAF5FE326BDD85_1350607049;
            // ---------- Original Method ----------
            //return object.getScaleX();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.690 -0400", hash_original_field = "5ABACA635607E234A6DDA7D7BAA57212", hash_generated_field = "F34310CAD52C1DF136CCDA6F7447C004")

    public static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.690 -0400", hash_original_method = "1D5FE7CAB5F43F92B9050D214C28178E", hash_generated_method = "7FC16C60655737E43F2B16325C8FC494")
        @Override
        public void setValue(View object, float value) {
            addTaint(value);
            addTaint(object.getTaint());
            object.setScaleY(value);
            // ---------- Original Method ----------
            //object.setScaleY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.690 -0400", hash_original_method = "CDBF0205ED6FCB3C37D74DE97C039D1E", hash_generated_method = "9BE4EC4F0B6D79FFD0D814D710A167BC")
        @Override
        public Float get(View object) {
            addTaint(object.getTaint());
Float var269904901BF66F58BB5F621B6830EE61_229098329 =             object.getScaleY();
            var269904901BF66F58BB5F621B6830EE61_229098329.addTaint(taint);
            return var269904901BF66F58BB5F621B6830EE61_229098329;
            // ---------- Original Method ----------
            //return object.getScaleY();
        }

        
};
}

