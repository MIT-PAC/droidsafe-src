package android.view;

// Droidsafe Imports
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
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
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.LocaleUtil;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollBarDrawable;

import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.view.menu.MenuBuilder;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
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
    private SparseArray<Object> mKeyedTags;
    private static int sNextAccessibilityViewId;
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
    private static final float NONZERO_EPSILON = .001f;
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
    public static final int DRAG_FLAG_GLOBAL = 1;
    private float mVerticalScrollFactor;
    private int mVerticalScrollbarPosition;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
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
    public static final int TEXT_DIRECTION_INHERIT = 0;
    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    public static final int TEXT_DIRECTION_LTR = 3;
    public static final int TEXT_DIRECTION_RTL = 4;
    protected static int DEFAULT_TEXT_DIRECTION = TEXT_DIRECTION_INHERIT;
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
    public static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.940 -0400", hash_original_method = "1511B05B546CB67262D01EAC74D91223", hash_generated_method = "E763A590C774636ABDC6CED3D95815E2")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setAlpha(value);
            // ---------- Original Method ----------
            //object.setAlpha(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.940 -0400", hash_original_method = "0828A056C08A4787018BC5ECB849DDAD", hash_generated_method = "2BF3DCA17715C303B3F788C4F2BF1D35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var4D8B4B98C4B6EBE4133ECBD9FF81A200_290423943 = (object.getAlpha());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getAlpha();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "71D30789CC0083AAA14E647D4066A62B", hash_generated_method = "81DF5D6291196E69CCC28CB0739721A2")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setTranslationX(value);
            // ---------- Original Method ----------
            //object.setTranslationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "AE4ED8B1A0B86A64F67E6D55304484F8", hash_generated_method = "0B1155480E21D585BA729F780B47E346")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float varEED5F16AC80A07644913A2997B932751_280002469 = (object.getTranslationX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getTranslationX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "35EB991A21102AE6A66798A0E05F4EB7", hash_generated_method = "4B541B121A1DB761894CC38F21CC538D")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setTranslationY(value);
            // ---------- Original Method ----------
            //object.setTranslationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "602B4C29E3FDDB39DD10FBFA4C1D4EAD", hash_generated_method = "2E1D9C54788C3E627842AE9C500729D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var58A657CFB650C959DD8D322D0AC51070_1626269970 = (object.getTranslationY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getTranslationY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> X = new FloatProperty<View>("x") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "942D12A2907E436F9DD2D5A3BB599D1C", hash_generated_method = "8116926B91B6EBD7EF0B3279D6614CA0")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setX(value);
            // ---------- Original Method ----------
            //object.setX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "87F550DC0E1D4FED879AF17D796C775D", hash_generated_method = "E369ED826A1A4D0330446C580817DA93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var5F2CAE5DB7956D8489ACF37E9A5649C0_1022799922 = (object.getX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> Y = new FloatProperty<View>("y") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "F66C6BF603238C3B745DBF80CCB68E15", hash_generated_method = "5AEC7DC3D620C470A2BE94EB4B7ECDE7")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setY(value);
            // ---------- Original Method ----------
            //object.setY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "107F13AA20F45AE0A7AF10B2A89B1B3D", hash_generated_method = "A1A79B5CC243F25D0AC071D8F537CF95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float varEED6AA7425DB7680970822F5379F9BF2_1555327336 = (object.getY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "E4DD5C8F5E4B6A35D65B3372F3D8BFBA", hash_generated_method = "B78389828642E8D84EAE4394BDAF240A")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotation(value);
            // ---------- Original Method ----------
            //object.setRotation(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "6F0DC1763312BEA34F1272E5458BA30D", hash_generated_method = "7E168D867AD43694CFB8071B877AB62E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var2D180CFD31CAAC37E5188717E487F8A2_735366632 = (object.getRotation());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotation();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "D8E97A391BF9703940D7A06280ABBB3F", hash_generated_method = "55C955D2A6C2DF17EFD133C8FD60E4C5")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotationX(value);
            // ---------- Original Method ----------
            //object.setRotationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.941 -0400", hash_original_method = "3FE8B70962F32AF948528D0D6E8ED1AF", hash_generated_method = "97DD40B7F60534406E8DACFC01C70596")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var69F6E7E3C4CD70A17389B8C6B586AD28_1418491348 = (object.getRotationX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotationX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "CDE80AB2A44D5B173DB76AD6CA4559A4", hash_generated_method = "10757D155926BC8CE3338888FE9AB5FF")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotationY(value);
            // ---------- Original Method ----------
            //object.setRotationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "EE835584282672E99083546AE5304355", hash_generated_method = "143560DB245E1124D03DF021DC743950")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var3268E4C1849F09F30AA1DC8103BD3FED_235140056 = (object.getRotationY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotationY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "1B653DA1FDE36CFBF0835E42B933826F", hash_generated_method = "E27D53AB791304458BB4B382C57952C4")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setScaleX(value);
            // ---------- Original Method ----------
            //object.setScaleX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "A2F336BAC519262505475338F6D5EC55", hash_generated_method = "CF2EE67ED165506FFA5FD3190635D984")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var63093F1F9DC0856715E162B3BEA976CB_1844863075 = (object.getScaleX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getScaleX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "1D5FE7CAB5F43F92B9050D214C28178E", hash_generated_method = "8D97D2623D77B4DDBC308003B69CC8B7")
        @DSModeled(DSC.SAFE)
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setScaleY(value);
            // ---------- Original Method ----------
            //object.setScaleY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "CDBF0205ED6FCB3C37D74DE97C039D1E", hash_generated_method = "71EEE63DBE9D185DF1535BC2A6AF4DBD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var0084208E1E15478487BDC4032EB24659_1433355552 = (object.getScaleY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getScaleY();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "6E480C32A7FC910695FE07C33ABF7A7A", hash_generated_method = "516CCB830EBFECE04F361825C646C795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mResources = context != null ? context.getResources() : null;
        mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        mUserPaddingStart = -1;
        mUserPaddingEnd = -1;
        mUserPaddingRelative = false;
        // ---------- Original Method ----------
        //mContext = context;
        //mResources = context != null ? context.getResources() : null;
        //mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
        //mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        //setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        //mUserPaddingStart = -1;
        //mUserPaddingEnd = -1;
        //mUserPaddingRelative = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.942 -0400", hash_original_method = "7A0AD99F840E8369EC476A6B56BA8ADA", hash_generated_method = "628FB1DEBA7AB66001AD74D37618B9AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.944 -0400", hash_original_method = "F8E7269105FB2D522A5F7FAB2F89EE95", hash_generated_method = "C15EC7F9D2AB4FA1A2C08DA754554EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View(Context context, AttributeSet attrs, int defStyle) {
        this(context);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.View,
                defStyle, 0);
        Drawable background;
        background = null;
        int leftPadding;
        leftPadding = -1;
        int topPadding;
        topPadding = -1;
        int rightPadding;
        rightPadding = -1;
        int bottomPadding;
        bottomPadding = -1;
        int startPadding;
        startPadding = -1;
        int endPadding;
        endPadding = -1;
        int padding;
        padding = -1;
        int viewFlagValues;
        viewFlagValues = 0;
        int viewFlagMasks;
        viewFlagMasks = 0;
        boolean setScrollContainer;
        setScrollContainer = false;
        int x;
        x = 0;
        int y;
        y = 0;
        float tx;
        tx = 0;
        float ty;
        ty = 0;
        float rotation;
        rotation = 0;
        float rotationX;
        rotationX = 0;
        float rotationY;
        rotationY = 0;
        float sx;
        sx = 1f;
        float sy;
        sy = 1f;
        boolean transformSet;
        transformSet = false;
        int scrollbarStyle;
        scrollbarStyle = SCROLLBARS_INSIDE_OVERLAY;
        int overScrollMode;
        overScrollMode = mOverScrollMode;
        final int N;
        N = a.getIndexCount();
        {
            int i;
            i = 0;
            {
                int attr;
                attr = a.getIndex(i);
                //Begin case com.android.internal.R.styleable.View_background 
                background = a.getDrawable(attr);
                //End case com.android.internal.R.styleable.View_background 
                //Begin case com.android.internal.R.styleable.View_padding 
                padding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_padding 
                //Begin case com.android.internal.R.styleable.View_paddingLeft 
                leftPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingLeft 
                //Begin case com.android.internal.R.styleable.View_paddingTop 
                topPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingTop 
                //Begin case com.android.internal.R.styleable.View_paddingRight 
                rightPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingRight 
                //Begin case com.android.internal.R.styleable.View_paddingBottom 
                bottomPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingBottom 
                //Begin case com.android.internal.R.styleable.View_paddingStart 
                startPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingStart 
                //Begin case com.android.internal.R.styleable.View_paddingEnd 
                endPadding = a.getDimensionPixelSize(attr, -1);
                //End case com.android.internal.R.styleable.View_paddingEnd 
                //Begin case com.android.internal.R.styleable.View_scrollX 
                x = a.getDimensionPixelOffset(attr, 0);
                //End case com.android.internal.R.styleable.View_scrollX 
                //Begin case com.android.internal.R.styleable.View_scrollY 
                y = a.getDimensionPixelOffset(attr, 0);
                //End case com.android.internal.R.styleable.View_scrollY 
                //Begin case com.android.internal.R.styleable.View_alpha 
                setAlpha(a.getFloat(attr, 1f));
                //End case com.android.internal.R.styleable.View_alpha 
                //Begin case com.android.internal.R.styleable.View_transformPivotX 
                setPivotX(a.getDimensionPixelOffset(attr, 0));
                //End case com.android.internal.R.styleable.View_transformPivotX 
                //Begin case com.android.internal.R.styleable.View_transformPivotY 
                setPivotY(a.getDimensionPixelOffset(attr, 0));
                //End case com.android.internal.R.styleable.View_transformPivotY 
                //Begin case com.android.internal.R.styleable.View_translationX 
                tx = a.getDimensionPixelOffset(attr, 0);
                //End case com.android.internal.R.styleable.View_translationX 
                //Begin case com.android.internal.R.styleable.View_translationX 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_translationX 
                //Begin case com.android.internal.R.styleable.View_translationY 
                ty = a.getDimensionPixelOffset(attr, 0);
                //End case com.android.internal.R.styleable.View_translationY 
                //Begin case com.android.internal.R.styleable.View_translationY 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_translationY 
                //Begin case com.android.internal.R.styleable.View_rotation 
                rotation = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.View_rotation 
                //Begin case com.android.internal.R.styleable.View_rotation 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_rotation 
                //Begin case com.android.internal.R.styleable.View_rotationX 
                rotationX = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.View_rotationX 
                //Begin case com.android.internal.R.styleable.View_rotationX 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_rotationX 
                //Begin case com.android.internal.R.styleable.View_rotationY 
                rotationY = a.getFloat(attr, 0);
                //End case com.android.internal.R.styleable.View_rotationY 
                //Begin case com.android.internal.R.styleable.View_rotationY 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_rotationY 
                //Begin case com.android.internal.R.styleable.View_scaleX 
                sx = a.getFloat(attr, 1f);
                //End case com.android.internal.R.styleable.View_scaleX 
                //Begin case com.android.internal.R.styleable.View_scaleX 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_scaleX 
                //Begin case com.android.internal.R.styleable.View_scaleY 
                sy = a.getFloat(attr, 1f);
                //End case com.android.internal.R.styleable.View_scaleY 
                //Begin case com.android.internal.R.styleable.View_scaleY 
                transformSet = true;
                //End case com.android.internal.R.styleable.View_scaleY 
                //Begin case com.android.internal.R.styleable.View_id 
                mID = a.getResourceId(attr, NO_ID);
                //End case com.android.internal.R.styleable.View_id 
                //Begin case com.android.internal.R.styleable.View_tag 
                mTag = a.getText(attr);
                //End case com.android.internal.R.styleable.View_tag 
                //Begin case com.android.internal.R.styleable.View_fitsSystemWindows 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_708091988 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FITS_SYSTEM_WINDOWS;
                        viewFlagMasks |= FITS_SYSTEM_WINDOWS;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_fitsSystemWindows 
                //Begin case com.android.internal.R.styleable.View_focusable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1096410467 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_focusable 
                //Begin case com.android.internal.R.styleable.View_focusableInTouchMode 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_470135035 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_focusableInTouchMode 
                //Begin case com.android.internal.R.styleable.View_clickable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_124606599 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= CLICKABLE;
                        viewFlagMasks |= CLICKABLE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_clickable 
                //Begin case com.android.internal.R.styleable.View_longClickable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1261423096 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= LONG_CLICKABLE;
                        viewFlagMasks |= LONG_CLICKABLE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_longClickable 
                //Begin case com.android.internal.R.styleable.View_saveEnabled 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_738145036 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues |= SAVE_DISABLED;
                        viewFlagMasks |= SAVE_DISABLED_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_saveEnabled 
                //Begin case com.android.internal.R.styleable.View_duplicateParentState 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1836285660 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= DUPLICATE_PARENT_STATE;
                        viewFlagMasks |= DUPLICATE_PARENT_STATE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_duplicateParentState 
                //Begin case com.android.internal.R.styleable.View_visibility 
                final int visibility;
                visibility = a.getInt(attr, 0);
                //End case com.android.internal.R.styleable.View_visibility 
                //Begin case com.android.internal.R.styleable.View_visibility 
                {
                    viewFlagValues |= VISIBILITY_FLAGS[visibility];
                    viewFlagMasks |= VISIBILITY_MASK;
                } //End block
                //End case com.android.internal.R.styleable.View_visibility 
                //Begin case com.android.internal.R.styleable.View_layoutDirection 
                viewFlagValues &= ~LAYOUT_DIRECTION_MASK;
                //End case com.android.internal.R.styleable.View_layoutDirection 
                //Begin case com.android.internal.R.styleable.View_layoutDirection 
                final int layoutDirection;
                layoutDirection = a.getInt(attr, -1);
                //End case com.android.internal.R.styleable.View_layoutDirection 
                //Begin case com.android.internal.R.styleable.View_layoutDirection 
                {
                    viewFlagValues |= LAYOUT_DIRECTION_FLAGS[layoutDirection];
                } //End block
                {
                    viewFlagValues |= LAYOUT_DIRECTION_DEFAULT;
                } //End block
                //End case com.android.internal.R.styleable.View_layoutDirection 
                //Begin case com.android.internal.R.styleable.View_layoutDirection 
                viewFlagMasks |= LAYOUT_DIRECTION_MASK;
                //End case com.android.internal.R.styleable.View_layoutDirection 
                //Begin case com.android.internal.R.styleable.View_drawingCacheQuality 
                final int cacheQuality;
                cacheQuality = a.getInt(attr, 0);
                //End case com.android.internal.R.styleable.View_drawingCacheQuality 
                //Begin case com.android.internal.R.styleable.View_drawingCacheQuality 
                {
                    viewFlagValues |= DRAWING_CACHE_QUALITY_FLAGS[cacheQuality];
                    viewFlagMasks |= DRAWING_CACHE_QUALITY_MASK;
                } //End block
                //End case com.android.internal.R.styleable.View_drawingCacheQuality 
                //Begin case com.android.internal.R.styleable.View_contentDescription 
                mContentDescription = a.getString(attr);
                //End case com.android.internal.R.styleable.View_contentDescription 
                //Begin case com.android.internal.R.styleable.View_soundEffectsEnabled 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1961576484 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~SOUND_EFFECTS_ENABLED;
                        viewFlagMasks |= SOUND_EFFECTS_ENABLED;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_soundEffectsEnabled 
                //Begin case com.android.internal.R.styleable.View_hapticFeedbackEnabled 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_924862655 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~HAPTIC_FEEDBACK_ENABLED;
                        viewFlagMasks |= HAPTIC_FEEDBACK_ENABLED;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_hapticFeedbackEnabled 
                //Begin case R.styleable.View_scrollbars 
                final int scrollbars;
                scrollbars = a.getInt(attr, SCROLLBARS_NONE);
                //End case R.styleable.View_scrollbars 
                //Begin case R.styleable.View_scrollbars 
                {
                    viewFlagValues |= scrollbars;
                    viewFlagMasks |= SCROLLBARS_MASK;
                    initializeScrollbars(a);
                } //End block
                //End case R.styleable.View_scrollbars 
                //Begin case R.styleable.View_fadingEdge 
                {
                    boolean varC070C09F5C0916551B09381C0852B394_39437232 = (context.getApplicationInfo().targetSdkVersion >= ICE_CREAM_SANDWICH);
                } //End collapsed parenthetic
                //End case R.styleable.View_fadingEdge 
                //Begin case R.styleable.View_requiresFadingEdge 
                final int fadingEdge;
                fadingEdge = a.getInt(attr, FADING_EDGE_NONE);
                //End case R.styleable.View_requiresFadingEdge 
                //Begin case R.styleable.View_requiresFadingEdge 
                {
                    viewFlagValues |= fadingEdge;
                    viewFlagMasks |= FADING_EDGE_MASK;
                    initializeFadingEdge(a);
                } //End block
                //End case R.styleable.View_requiresFadingEdge 
                //Begin case R.styleable.View_scrollbarStyle 
                scrollbarStyle = a.getInt(attr, SCROLLBARS_INSIDE_OVERLAY);
                //End case R.styleable.View_scrollbarStyle 
                //Begin case R.styleable.View_scrollbarStyle 
                {
                    viewFlagValues |= scrollbarStyle & SCROLLBARS_STYLE_MASK;
                    viewFlagMasks |= SCROLLBARS_STYLE_MASK;
                } //End block
                //End case R.styleable.View_scrollbarStyle 
                //Begin case R.styleable.View_isScrollContainer 
                setScrollContainer = true;
                //End case R.styleable.View_isScrollContainer 
                //Begin case R.styleable.View_isScrollContainer 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1071422458 = (a.getBoolean(attr, false));
                    {
                        setScrollContainer(true);
                    } //End block
                } //End collapsed parenthetic
                //End case R.styleable.View_isScrollContainer 
                //Begin case com.android.internal.R.styleable.View_keepScreenOn 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1764254786 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= KEEP_SCREEN_ON;
                        viewFlagMasks |= KEEP_SCREEN_ON;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_keepScreenOn 
                //Begin case R.styleable.View_filterTouchesWhenObscured 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_279594233 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FILTER_TOUCHES_WHEN_OBSCURED;
                        viewFlagMasks |= FILTER_TOUCHES_WHEN_OBSCURED;
                    } //End block
                } //End collapsed parenthetic
                //End case R.styleable.View_filterTouchesWhenObscured 
                //Begin case R.styleable.View_nextFocusLeft 
                mNextFocusLeftId = a.getResourceId(attr, View.NO_ID);
                //End case R.styleable.View_nextFocusLeft 
                //Begin case R.styleable.View_nextFocusRight 
                mNextFocusRightId = a.getResourceId(attr, View.NO_ID);
                //End case R.styleable.View_nextFocusRight 
                //Begin case R.styleable.View_nextFocusUp 
                mNextFocusUpId = a.getResourceId(attr, View.NO_ID);
                //End case R.styleable.View_nextFocusUp 
                //Begin case R.styleable.View_nextFocusDown 
                mNextFocusDownId = a.getResourceId(attr, View.NO_ID);
                //End case R.styleable.View_nextFocusDown 
                //Begin case R.styleable.View_nextFocusForward 
                mNextFocusForwardId = a.getResourceId(attr, View.NO_ID);
                //End case R.styleable.View_nextFocusForward 
                //Begin case R.styleable.View_minWidth 
                mMinWidth = a.getDimensionPixelSize(attr, 0);
                //End case R.styleable.View_minWidth 
                //Begin case R.styleable.View_minHeight 
                mMinHeight = a.getDimensionPixelSize(attr, 0);
                //End case R.styleable.View_minHeight 
                //Begin case R.styleable.View_onClick 
                {
                    boolean var493A86E51AC82FCCEFBD5D9BA92432B0_1065480633 = (context.isRestricted());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The android:onClick attribute cannot "
                                + "be used within a restricted context");
                    } //End block
                } //End collapsed parenthetic
                //End case R.styleable.View_onClick 
                //Begin case R.styleable.View_onClick 
                final String handlerName;
                handlerName = a.getString(attr);
                //End case R.styleable.View_onClick 
                //Begin case R.styleable.View_onClick 
                {
                    setOnClickListener(new OnClickListener() {
                            private Method mHandler;
                            public void onClick(View v) {
                                if (mHandler == null) {
                                    try {
                                        mHandler = getContext().getClass().getMethod(handlerName,
                                                View.class);
                                    } catch (NoSuchMethodException e) {
                                        int id = getId();
                                        String idText = id == NO_ID ? "" : " with id '"
                                                + getContext().getResources().getResourceEntryName(
                                                    id) + "'";
                                        throw new IllegalStateException("Could not find a method " +
                                                handlerName + "(View) in the activity "
                                                + getContext().getClass() + " for onClick handler"
                                                + " on view " + View.this.getClass() + idText, e);
                                    }
                                }
                                try {
                                    mHandler.invoke(getContext(), View.this);
                                } catch (IllegalAccessException e) {
                                    throw new IllegalStateException("Could not execute non "
                                            + "public method of the activity", e);
                                } catch (InvocationTargetException e) {
                                    throw new IllegalStateException("Could not execute "
                                            + "method of the activity", e);
                                }
                            }
                        });
                } //End block
                //End case R.styleable.View_onClick 
                //Begin case R.styleable.View_overScrollMode 
                overScrollMode = a.getInt(attr, OVER_SCROLL_IF_CONTENT_SCROLLS);
                //End case R.styleable.View_overScrollMode 
                //Begin case R.styleable.View_verticalScrollbarPosition 
                mVerticalScrollbarPosition = a.getInt(attr, SCROLLBAR_POSITION_DEFAULT);
                //End case R.styleable.View_verticalScrollbarPosition 
                //Begin case R.styleable.View_layerType 
                setLayerType(a.getInt(attr, LAYER_TYPE_NONE), null);
                //End case R.styleable.View_layerType 
                //Begin case R.styleable.View_textDirection 
                mTextDirection = a.getInt(attr, DEFAULT_TEXT_DIRECTION);
                //End case R.styleable.View_textDirection 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        setOverScrollMode(overScrollMode);
        {
            setBackgroundDrawable(background);
        } //End block
        mUserPaddingRelative = (startPadding >= 0 || endPadding >= 0);
        mUserPaddingStart = startPadding;
        mUserPaddingEnd = endPadding;
        {
            leftPadding = padding;
            topPadding = padding;
            rightPadding = padding;
            bottomPadding = padding;
        } //End block
        setPadding(leftPadding >= 0 ? leftPadding : mPaddingLeft,
                topPadding >= 0 ? topPadding : mPaddingTop,
                rightPadding >= 0 ? rightPadding : mPaddingRight,
                bottomPadding >= 0 ? bottomPadding : mPaddingBottom);
        {
            setFlags(viewFlagValues, viewFlagMasks);
        } //End block
        {
            recomputePadding();
        } //End block
        {
            scrollTo(x, y);
        } //End block
        {
            setTranslationX(tx);
            setTranslationY(ty);
            setRotation(rotation);
            setRotationX(rotationX);
            setRotationY(rotationY);
            setScaleX(sx);
            setScaleY(sy);
        } //End block
        {
            setScrollContainer(true);
        } //End block
        computeOpaqueFlags();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "5C3A364FECC6F7D07E7A546170C25E98", hash_generated_method = "6E865C7877A106AC31486D4E54B9115D")
    @DSModeled(DSC.SAFE)
     View() {
        mResources = null;
        // ---------- Original Method ----------
        //mResources = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "F39CEBF0E5E47A818635618D8F975382", hash_generated_method = "3C64F884FDBFBD302582AFB1FFFECD8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initializeFadingEdge(TypedArray a) {
        dsTaint.addTaint(a.dsTaint);
        initScrollCache();
        mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                R.styleable.View_fadingEdgeLength,
                ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
        // ---------- Original Method ----------
        //initScrollCache();
        //mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                //R.styleable.View_fadingEdgeLength,
                //ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "48BE981E65F7E857DD7A9FF8EF5006FF", hash_generated_method = "708378C98CEE7F884DFE4E28DCCAF081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVerticalFadingEdgeLength() {
        {
            boolean var50B16E908CD6883BB4A53F1CCAB8FFC0_830893823 = (isVerticalFadingEdgeEnabled());
            {
                ScrollabilityCache cache;
                cache = mScrollCache;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isVerticalFadingEdgeEnabled()) {
            //ScrollabilityCache cache = mScrollCache;
            //if (cache != null) {
                //return cache.fadingEdgeLength;
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "F316E2F78DFC9160954B8650C58C0898", hash_generated_method = "DE25ED1EF02B66479B815D331C10E575")
    @DSModeled(DSC.SAFE)
    public void setFadingEdgeLength(int length) {
        dsTaint.addTaint(length);
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
        // ---------- Original Method ----------
        //initScrollCache();
        //mScrollCache.fadingEdgeLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "A8651530AFA26393AFB5F6425B22CDCD", hash_generated_method = "E9057BBAA7D124EA057F0FFD20360FF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHorizontalFadingEdgeLength() {
        {
            boolean var5D77CA7D5D90FF39CB3E108D33083F4D_58139953 = (isHorizontalFadingEdgeEnabled());
            {
                ScrollabilityCache cache;
                cache = mScrollCache;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isHorizontalFadingEdgeEnabled()) {
            //ScrollabilityCache cache = mScrollCache;
            //if (cache != null) {
                //return cache.fadingEdgeLength;
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.945 -0400", hash_original_method = "9E8BEE4EA7290E77910774FBF44231C2", hash_generated_method = "B89281A0168D83C77DE2990FF7C8AB30")
    @DSModeled(DSC.SAFE)
    public int getVerticalScrollbarWidth() {
        ScrollabilityCache cache;
        cache = mScrollCache;
        {
            ScrollBarDrawable scrollBar;
            scrollBar = cache.scrollBar;
            {
                int size;
                size = scrollBar.getSize(true);
                {
                    size = cache.scrollBarSize;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ScrollabilityCache cache = mScrollCache;
        //if (cache != null) {
            //ScrollBarDrawable scrollBar = cache.scrollBar;
            //if (scrollBar != null) {
                //int size = scrollBar.getSize(true);
                //if (size <= 0) {
                    //size = cache.scrollBarSize;
                //}
                //return size;
            //}
            //return 0;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "6872C13C59C68BCC5CF5DE777A5D5AA0", hash_generated_method = "5D4E138C05BC3C200068A4996585BAD8")
    @DSModeled(DSC.SAFE)
    protected int getHorizontalScrollbarHeight() {
        ScrollabilityCache cache;
        cache = mScrollCache;
        {
            ScrollBarDrawable scrollBar;
            scrollBar = cache.scrollBar;
            {
                int size;
                size = scrollBar.getSize(false);
                {
                    size = cache.scrollBarSize;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ScrollabilityCache cache = mScrollCache;
        //if (cache != null) {
            //ScrollBarDrawable scrollBar = cache.scrollBar;
            //if (scrollBar != null) {
                //int size = scrollBar.getSize(false);
                //if (size <= 0) {
                    //size = cache.scrollBarSize;
                //}
                //return size;
            //}
            //return 0;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "92AEC3F31170B251C0CC405CA4D3250A", hash_generated_method = "E679C4691C63C150F727AB4772486AD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initializeScrollbars(TypedArray a) {
        dsTaint.addTaint(a.dsTaint);
        initScrollCache();
        final ScrollabilityCache scrollabilityCache;
        scrollabilityCache = mScrollCache;
        {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        } //End block
        final boolean fadeScrollbars;
        fadeScrollbars = a.getBoolean(R.styleable.View_fadeScrollbars, true);
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } //End block
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        scrollabilityCache.scrollBarFadeDuration = a.getInt(
                R.styleable.View_scrollbarFadeDuration, ViewConfiguration
                        .getScrollBarFadeDuration());
        scrollabilityCache.scrollBarDefaultDelayBeforeFade = a.getInt(
                R.styleable.View_scrollbarDefaultDelayBeforeFade,
                ViewConfiguration.getScrollDefaultDelay());
        scrollabilityCache.scrollBarSize = a.getDimensionPixelSize(
                com.android.internal.R.styleable.View_scrollbarSize,
                ViewConfiguration.get(mContext).getScaledScrollBarSize());
        Drawable track;
        track = a.getDrawable(R.styleable.View_scrollbarTrackHorizontal);
        scrollabilityCache.scrollBar.setHorizontalTrackDrawable(track);
        Drawable thumb;
        thumb = a.getDrawable(R.styleable.View_scrollbarThumbHorizontal);
        {
            scrollabilityCache.scrollBar.setHorizontalThumbDrawable(thumb);
        } //End block
        boolean alwaysDraw;
        alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawHorizontalTrack,
                false);
        {
            scrollabilityCache.scrollBar.setAlwaysDrawHorizontalTrack(true);
        } //End block
        track = a.getDrawable(R.styleable.View_scrollbarTrackVertical);
        scrollabilityCache.scrollBar.setVerticalTrackDrawable(track);
        thumb = a.getDrawable(R.styleable.View_scrollbarThumbVertical);
        {
            scrollabilityCache.scrollBar.setVerticalThumbDrawable(thumb);
        } //End block
        alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawVerticalTrack,
                false);
        {
            scrollabilityCache.scrollBar.setAlwaysDrawVerticalTrack(true);
        } //End block
        resolvePadding();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "E049E8AF463EFBD39046D8F102EAF6B1", hash_generated_method = "84CBFFFF970646A93021319D3185AE5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initScrollCache() {
        {
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        } //End block
        // ---------- Original Method ----------
        //if (mScrollCache == null) {
            //mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "6A347D034BA88A40E4761231BE70B8AA", hash_generated_method = "2896F184985D662DFDA94C4934A1BA0B")
    @DSModeled(DSC.SAFE)
    public void setVerticalScrollbarPosition(int position) {
        dsTaint.addTaint(position);
        {
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (mVerticalScrollbarPosition != position) {
            //mVerticalScrollbarPosition = position;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "0B028AFE1E9609D00D97AC9B679932DA", hash_generated_method = "5F677D44B59E393CF374F0ACCEC3159B")
    @DSModeled(DSC.SAFE)
    public int getVerticalScrollbarPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVerticalScrollbarPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "3F6307E0FF2B24CF42D639D72702E7A3", hash_generated_method = "26F5F877467D04AEDD7B9AD16B02B74E")
    @DSModeled(DSC.SAFE)
     ListenerInfo getListenerInfo() {
        mListenerInfo = new ListenerInfo();
        return (ListenerInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mListenerInfo != null) {
            //return mListenerInfo;
        //}
        //mListenerInfo = new ListenerInfo();
        //return mListenerInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.946 -0400", hash_original_method = "D8AB5E19AA18F69BACA6EC368D2591FE", hash_generated_method = "D2FBBA4BCC28D70763B494BA89C8AE12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnFocusChangeListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnFocusChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "E2DB3817E7DB5D233E4A7D6EADE958A3", hash_generated_method = "7339F99AB7F636AD1517EBF798A6311A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        ListenerInfo li;
        li = getListenerInfo();
        {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        } //End block
        {
            boolean var5BC5FBAFE932C29989D14499066114E0_1884900049 = (!li.mOnLayoutChangeListeners.contains(listener));
            {
                li.mOnLayoutChangeListeners.add(listener);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ListenerInfo li = getListenerInfo();
        //if (li.mOnLayoutChangeListeners == null) {
            //li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        //}
        //if (!li.mOnLayoutChangeListeners.contains(listener)) {
            //li.mOnLayoutChangeListeners.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "98A56C49B0A9E0F5D269641F74288A13", hash_generated_method = "1DEEEE34EB76BDA0F8C1C3A2EA3ADCEA")
    @DSModeled(DSC.SAFE)
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        li.mOnLayoutChangeListeners.remove(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li == null || li.mOnLayoutChangeListeners == null) {
            //return;
        //}
        //li.mOnLayoutChangeListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "BCC986125DE454FD64FA8CF6FF7B3375", hash_generated_method = "F58E0A6FFCC7504FD8CC097D2537E856")
    @DSModeled(DSC.SAFE)
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        ListenerInfo li;
        li = getListenerInfo();
        {
            li.mOnAttachStateChangeListeners
                    = new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        } //End block
        li.mOnAttachStateChangeListeners.add(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = getListenerInfo();
        //if (li.mOnAttachStateChangeListeners == null) {
            //li.mOnAttachStateChangeListeners
                    //= new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        //}
        //li.mOnAttachStateChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "BB59F05E95A495FA9A30543444FC5E76", hash_generated_method = "28B277F856AF2B12C0EFC2FF1B37DA3A")
    @DSModeled(DSC.SAFE)
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        li.mOnAttachStateChangeListeners.remove(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li == null || li.mOnAttachStateChangeListeners == null) {
            //return;
        //}
        //li.mOnAttachStateChangeListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "A3D291AC9D619397F7033ECE59D11B86", hash_generated_method = "68A68E9FF12113C2A693C744A87DF063")
    @DSModeled(DSC.SAFE)
    public OnFocusChangeListener getOnFocusChangeListener() {
        ListenerInfo li;
        li = mListenerInfo;
        return (OnFocusChangeListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return li != null ? li.mOnFocusChangeListener : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "45F4C058CBC73D55564FBEB6E17C2099", hash_generated_method = "C2B0FA7F71FAB430440E1CB2FC4DEC6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnClickListener(OnClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var04EA38E4DA3FCC73953331C5213AFF9F_277639400 = (!isClickable());
            {
                setClickable(true);
            } //End block
        } //End collapsed parenthetic
        getListenerInfo().mOnClickListener = l;
        // ---------- Original Method ----------
        //if (!isClickable()) {
            //setClickable(true);
        //}
        //getListenerInfo().mOnClickListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "8038CCFA19DFF6DCB9855B2C21487DC3", hash_generated_method = "5FE74F81EB8DA6E9A324553D1883E85C")
    @DSModeled(DSC.SAFE)
    public boolean hasOnClickListeners() {
        ListenerInfo li;
        li = mListenerInfo;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return (li != null && li.mOnClickListener != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.947 -0400", hash_original_method = "C88CD920669EF9D2067A739196536F5A", hash_generated_method = "FB6A7089F2736C03EF44E4A089F2FB1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnLongClickListener(OnLongClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var4E9822764F29F607F332912995A375BC_1511720689 = (!isLongClickable());
            {
                setLongClickable(true);
            } //End block
        } //End collapsed parenthetic
        getListenerInfo().mOnLongClickListener = l;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //getListenerInfo().mOnLongClickListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "3B1D28314D3140C1C25951340EB50400", hash_generated_method = "B9ECBF73F697B3ED942899B0BE152E84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var4E9822764F29F607F332912995A375BC_1587224120 = (!isLongClickable());
            {
                setLongClickable(true);
            } //End block
        } //End collapsed parenthetic
        getListenerInfo().mOnCreateContextMenuListener = l;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //getListenerInfo().mOnCreateContextMenuListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "F0CE5BDD9B8548BAC9D7A1A1FC9F10B8", hash_generated_method = "DB347B9EB168D65BD958D6C45F651065")
    @DSModeled(DSC.SAFE)
    public boolean performClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        ListenerInfo li;
        li = mListenerInfo;
        {
            playSoundEffect(SoundEffectConstants.CLICK);
            li.mOnClickListener.onClick(this);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnClickListener != null) {
            //playSoundEffect(SoundEffectConstants.CLICK);
            //li.mOnClickListener.onClick(this);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "102D936797B9C1FC40617DF92F54CFE2", hash_generated_method = "38DF65D0067D5B370B9BBA45E476DAB6")
    @DSModeled(DSC.SAFE)
    public boolean callOnClick() {
        ListenerInfo li;
        li = mListenerInfo;
        {
            li.mOnClickListener.onClick(this);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnClickListener != null) {
            //li.mOnClickListener.onClick(this);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "00035430EA6437DC8BB5C07835F45B65", hash_generated_method = "6CA10E63C74F584F41A490DDC329AC8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performLongClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        boolean handled;
        handled = false;
        ListenerInfo li;
        li = mListenerInfo;
        {
            handled = li.mOnLongClickListener.onLongClick(View.this);
        } //End block
        {
            handled = showContextMenu();
        } //End block
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        //boolean handled = false;
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnLongClickListener != null) {
            //handled = li.mOnLongClickListener.onLongClick(View.this);
        //}
        //if (!handled) {
            //handled = showContextMenu();
        //}
        //if (handled) {
            //performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "0AFC4304DA44E934FA35FDC29342C80F", hash_generated_method = "64EB466F863FDF4986A65E5F79BE4F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean performButtonActionOnTouchDown(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var431FF76FC0879DE3BD003EA2EA16B78F_1407138915 = ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0);
            {
                {
                    boolean var1A9C8D31FBEACF9594778DB5C5D1B4C1_484894310 = (showContextMenu(event.getX(), event.getY(), event.getMetaState()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0) {
            //if (showContextMenu(event.getX(), event.getY(), event.getMetaState())) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "3A1C6F51C14FB3CA1856280BB08BDD78", hash_generated_method = "EDC1A5B4906389684AE5F4A17297D5CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenu() {
        boolean var57558D56D4CFDCF7F086DB96E3562251_1499406258 = (getParent().showContextMenuForChild(this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getParent().showContextMenuForChild(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "B2C2D020E619A9A69ACCD76F29CBF0A8", hash_generated_method = "70DB3DE03943318334003CCA5DFD7517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenu(float x, float y, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        boolean varA4958949E9E0853BF05BBEE347C0FF81_1061324939 = (showContextMenu());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "554809A43858BFBD98E9D476D5975BC9", hash_generated_method = "111D2AC83A33B34F96D4876080AA72DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        ActionMode varD65387F2F72B335099677E2229713742_271307564 = (getParent().startActionModeForChild(this, callback));
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getParent().startActionModeForChild(this, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.948 -0400", hash_original_method = "31C7524DA5B5B98F54BA6C8BE0DEBF7E", hash_generated_method = "E233096E6C6AB8CB38551C63E77E587A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnKeyListener(OnKeyListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnKeyListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnKeyListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "D8E89DFA5C4F927FE4D243F514232285", hash_generated_method = "DD9211861720F9B24BB976CCDF636433")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnTouchListener(OnTouchListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnTouchListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnTouchListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "A6ED4A9DC8C6B322504EFE7525CB31A1", hash_generated_method = "E94A764C227B49DE20573B45BC1C0CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnGenericMotionListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnGenericMotionListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "A231A17C6E4AE608F5CD4B1132C585A7", hash_generated_method = "478807CAF653753332F9F7107B2C2B8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnHoverListener(OnHoverListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnHoverListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnHoverListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "8FD55843B8D7F3FEDE7B7D516A1E3E35", hash_generated_method = "B4F2F2ED444C44C61C7109BD84CF575D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnDragListener(OnDragListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnDragListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnDragListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "16B5A8656CEB6785661CF48B92B45991", hash_generated_method = "C52F1636DC7A397E799028B17C9953B4")
    @DSModeled(DSC.SAFE)
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            System.out.println(this + " requestFocus()");
        } //End block
        {
            mPrivateFlags |= FOCUSED;
            {
                mParent.requestChildFocus(this, this);
            } //End block
            onFocusChanged(true, direction, previouslyFocusedRect);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " requestFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) == 0) {
            //mPrivateFlags |= FOCUSED;
            //if (mParent != null) {
                //mParent.requestChildFocus(this, this);
            //}
            //onFocusChanged(true, direction, previouslyFocusedRect);
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "2192BF4A933C90A79FE0C71F9C0B2F3D", hash_generated_method = "9296058A4143D4F43DF96B07BC99E514")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRectangleOnScreen(Rect rectangle) {
        dsTaint.addTaint(rectangle.dsTaint);
        boolean varB53A64F27CEF8B117CF782EC0F44B212_686614728 = (requestRectangleOnScreen(rectangle, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestRectangleOnScreen(rectangle, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "BDB750CCBE647F1CD5444CDF496F66A3", hash_generated_method = "BECC923CDEDBC5F1E2BD71F28CE0DE02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        dsTaint.addTaint(rectangle.dsTaint);
        dsTaint.addTaint(immediate);
        View child;
        child = this;
        ViewParent parent;
        parent = mParent;
        boolean scrolled;
        scrolled = false;
        {
            scrolled |= parent.requestChildRectangleOnScreen(child,
                    rectangle, immediate);
            rectangle.offset(child.getLeft(), child.getTop());
            rectangle.offset(-child.getScrollX(), -child.getScrollY());
            child = (View) parent;
            parent = child.getParent();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //View child = this;
        //ViewParent parent = mParent;
        //boolean scrolled = false;
        //while (parent != null) {
            //scrolled |= parent.requestChildRectangleOnScreen(child,
                    //rectangle, immediate);
            //rectangle.offset(child.getLeft(), child.getTop());
            //rectangle.offset(-child.getScrollX(), -child.getScrollY());
            //if (!(parent instanceof View)) {
                //break;
            //}
            //child = (View) parent;
            //parent = child.getParent();
        //}
        //return scrolled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.949 -0400", hash_original_method = "A6F69BAD809415BD5537E3FD153C267F", hash_generated_method = "D80B446FC442B1AA4D3A45D3AFDB2142")
    @DSModeled(DSC.SAFE)
    public void clearFocus() {
        {
            System.out.println(this + " clearFocus()");
        } //End block
        {
            mPrivateFlags &= ~FOCUSED;
            {
                mParent.clearChildFocus(this);
            } //End block
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " clearFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //if (mParent != null) {
                //mParent.clearChildFocus(this);
            //}
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "B948A77A86E2A2242F3F753171415A6F", hash_generated_method = "66877C69D4E72855B4E3D557C9302B88")
    @DSModeled(DSC.SAFE)
     void clearFocusForRemoval() {
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "895408B45B14DF7336768B76769FDFBE", hash_generated_method = "3A3DD005C00025402356F66AE4176E0B")
    @DSModeled(DSC.SAFE)
     void unFocus() {
        {
            System.out.println(this + " unFocus()");
        } //End block
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " unFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "337547862E6B052D2DEF8F8E7CCEA590", hash_generated_method = "FB4458FDD36029B3A98D6C93CC762412")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean hasFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "B2402A510BB29E4C255854E18659AE1B", hash_generated_method = "03912C2BFF5FB0C3D3222322EE2C333B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFocusable() {
        boolean var45438BF76A2F167C289F26830B3A9B93_1313974298 = ((mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "5A1E14083BB718E6700BA53BA3884697", hash_generated_method = "8BA30502A49C31446A3665E11587A825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(gainFocus);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        } //End block
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            {
                boolean varF27F491A5EAB0B2989FBEF44657192A7_762177775 = (isPressed());
                {
                    setPressed(false);
                } //End block
            } //End collapsed parenthetic
            {
                imm.focusOut(this);
            } //End block
            onFocusLost();
        } //End block
        {
            imm.focusIn(this);
        } //End block
        invalidate(true);
        ListenerInfo li;
        li = mListenerInfo;
        {
            li.mOnFocusChangeListener.onFocusChange(this, gainFocus);
        } //End block
        {
            mAttachInfo.mKeyDispatchState.reset(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "67C8279330D12E8D41FE4F9795D7EB79", hash_generated_method = "CB4855FD7E677EB4BBD5CCC7EBB185E7")
    @DSModeled(DSC.SAFE)
    public void sendAccessibilityEvent(int eventType) {
        dsTaint.addTaint(eventType);
        {
            mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        } //End block
        {
            sendAccessibilityEventInternal(eventType);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        //} else {
            //sendAccessibilityEventInternal(eventType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "BE2AB20B544FD38FEA2111E9FF446FAD", hash_generated_method = "C87B7BFE15E86DA4747FC9B471560243")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendAccessibilityEventInternal(int eventType) {
        dsTaint.addTaint(eventType);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_928997157 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "B790306D0C64AC6AB0D8747A1C899258", hash_generated_method = "B619B5909544233AFE924ECA8AB96202")
    @DSModeled(DSC.SAFE)
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        } //End block
        {
            sendAccessibilityEventUncheckedInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
           //mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        //} else {
            //sendAccessibilityEventUncheckedInternal(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.950 -0400", hash_original_method = "2BAF48857D95094002D2EF1740E1384F", hash_generated_method = "193332CA4CF2B98CCD26D1196066C1C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var2E2E2221860B3DCAB8C5D4F0DAD9AC26_324508756 = (!isShown());
        } //End collapsed parenthetic
        onInitializeAccessibilityEvent(event);
        {
            boolean var9D05604FB3FF39F2704B15C63CA7D337_2012630773 = ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0);
            {
                dispatchPopulateAccessibilityEvent(event);
            } //End block
        } //End collapsed parenthetic
        getParent().requestSendAccessibilityEvent(this, event);
        // ---------- Original Method ----------
        //if (!isShown()) {
            //return;
        //}
        //onInitializeAccessibilityEvent(event);
        //if ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0) {
            //dispatchPopulateAccessibilityEvent(event);
        //}
        //getParent().requestSendAccessibilityEvent(this, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "927EED19E22DB3C930EC71946191C691", hash_generated_method = "A7F48B57C30DCD98ABDDD4F62C87A1E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC130CACCC03E1AF22AC94D08B8319DCD_348513884 = (mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event));
        } //End block
        {
            boolean var372DEE9301D724A2D11E91D3D5BF5A44_983835512 = (dispatchPopulateAccessibilityEventInternal(event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event);
        //} else {
            //return dispatchPopulateAccessibilityEventInternal(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "8EC2668F1DC902F63C332D19DDE36094", hash_generated_method = "0A5BBD1C9D84DEEEF3B592905BA8CB83")
    @DSModeled(DSC.SAFE)
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        onPopulateAccessibilityEvent(event);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "A0DF1F515FF193F86B7E130DE16E38CE", hash_generated_method = "DCD2232AC9EF3867C1A6414CB88D9F76")
    @DSModeled(DSC.SAFE)
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        } //End block
        {
            onPopulateAccessibilityEventInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        //} else {
            //onPopulateAccessibilityEventInternal(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "CF40AA9C4C55BD5A22FC0E76716C7875", hash_generated_method = "E0F161945CD6AD75DC66FFA58EED6D06")
    @DSModeled(DSC.SAFE)
     void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "28310CBBAED9E8F097DF5C90DBA9CD0F", hash_generated_method = "DA5366DB0B2F75869BA10725C6DA7562")
    @DSModeled(DSC.SAFE)
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        } //End block
        {
            onInitializeAccessibilityEventInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        //} else {
            //onInitializeAccessibilityEventInternal(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "43B5B6E634D7CF960BF74CE0E1DDA2CD", hash_generated_method = "42B4A28D29B88803DCC1B6C07CDDDA8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onInitializeAccessibilityEventInternal(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        event.setSource(this);
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        event.setEnabled(isEnabled());
        event.setContentDescription(mContentDescription);
        {
            boolean var703D9E8BC245CC3A7B48B35F52188203_703673 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null);
            {
                ArrayList<View> focusablesTempList;
                focusablesTempList = mAttachInfo.mFocusablesTempList;
                getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    FOCUSABLES_ALL);
                event.setItemCount(focusablesTempList.size());
                event.setCurrentItemIndex(focusablesTempList.indexOf(this));
                focusablesTempList.clear();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //event.setSource(this);
        //event.setClassName(getClass().getName());
        //event.setPackageName(getContext().getPackageName());
        //event.setEnabled(isEnabled());
        //event.setContentDescription(mContentDescription);
        //if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null) {
            //ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
            //getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    //FOCUSABLES_ALL);
            //event.setItemCount(focusablesTempList.size());
            //event.setCurrentItemIndex(focusablesTempList.indexOf(this));
            //focusablesTempList.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "53F1596AC086DF0FD9B166B1443D793C", hash_generated_method = "9C9AC39A9C9EA35F09300500888B758F")
    @DSModeled(DSC.SAFE)
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo info;
        info = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(info);
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        //onInitializeAccessibilityNodeInfo(info);
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.951 -0400", hash_original_method = "BE2067901E907368432A8D9CCB431457", hash_generated_method = "1BAE1BEF60B9CBC4CC5A59A66B5ED3E8")
    @DSModeled(DSC.SAFE)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        {
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        } //End block
        {
            onInitializeAccessibilityNodeInfoInternal(info);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        //} else {
            //onInitializeAccessibilityNodeInfoInternal(info);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "8753AD1110C37F0E73AF31B4448B5211", hash_generated_method = "8BAF720D998D5905D15D75F0DB982C7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        Rect bounds;
        bounds = mAttachInfo.mTmpInvalRect;
        getDrawingRect(bounds);
        info.setBoundsInParent(bounds);
        int[] locationOnScreen;
        locationOnScreen = mAttachInfo.mInvalidateChildLocation;
        getLocationOnScreen(locationOnScreen);
        bounds.offsetTo(0, 0);
        bounds.offset(locationOnScreen[0], locationOnScreen[1]);
        info.setBoundsInScreen(bounds);
        {
            ViewParent parent;
            parent = getParent();
            {
                View parentView;
                parentView = (View) parent;
                info.setParent(parentView);
            } //End block
        } //End block
        info.setPackageName(mContext.getPackageName());
        info.setClassName(getClass().getName());
        info.setContentDescription(getContentDescription());
        info.setEnabled(isEnabled());
        info.setClickable(isClickable());
        info.setFocusable(isFocusable());
        info.setFocused(isFocused());
        info.setSelected(isSelected());
        info.setLongClickable(isLongClickable());
        info.addAction(AccessibilityNodeInfo.ACTION_SELECT);
        info.addAction(AccessibilityNodeInfo.ACTION_CLEAR_SELECTION);
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_554648405 = (isFocusable());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_681281626 = (isFocused());
                    {
                        info.addAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
                    } //End block
                    {
                        info.addAction(AccessibilityNodeInfo.ACTION_FOCUS);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "32F138BD45B7179C5519FF8B12AC5296", hash_generated_method = "3AF105B8A908A83CE8043DCC172484E5")
    @DSModeled(DSC.SAFE)
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        dsTaint.addTaint(delegate.dsTaint);
        // ---------- Original Method ----------
        //mAccessibilityDelegate = delegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "64D1C3C95C84965C0C27E168EBDF3A77", hash_generated_method = "5859E4C57D019ABDF8EAB6C8D47BE27C")
    @DSModeled(DSC.SAFE)
    public int getAccessibilityViewId() {
        {
            mAccessibilityViewId = sNextAccessibilityViewId++;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAccessibilityViewId == NO_ID) {
            //mAccessibilityViewId = sNextAccessibilityViewId++;
        //}
        //return mAccessibilityViewId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "ABBCC5D3939BB662168BF84991E4D81C", hash_generated_method = "2508793718DD455A32B62684D29FE7F3")
    @DSModeled(DSC.SAFE)
    public int getAccessibilityWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "BA259797571A91EE13C632E0DC69BD69")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "1087954D5CDD3C4C18E361D3DD728844", hash_generated_method = "4C293D7C4BCF6E283E5DF6BED913B3A9")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        // ---------- Original Method ----------
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "5C1A3C599F20DF55DE3C4471944CAAB7", hash_generated_method = "1F8D112BD587843E273EFF736E13CD21")
    @DSModeled(DSC.SAFE)
    protected void onFocusLost() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        resetPressedState();
        // ---------- Original Method ----------
        //resetPressedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "81136F7A8F96E00E1C77CED95B4F9DA3", hash_generated_method = "159B617737892796D2250DB7B92318A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetPressedState() {
        {
            boolean varCBC9727A244F165456D2D6CDD8022488_2030894613 = (isPressed());
            {
                setPressed(false);
                {
                    removeLongPressCallback();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
            //return;
        //}
        //if (isPressed()) {
            //setPressed(false);
            //if (!mHasPerformedLongPress) {
                //removeLongPressCallback();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "BAE18A1621CF10BDD62967DA8210DF90", hash_generated_method = "F852EDF9555A80C59F9A38D8A78F3E33")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.952 -0400", hash_original_method = "DDD0B2B4CCE06873AEE74BD63DE5A294", hash_generated_method = "D4A09F552BB92429DB25F8C464E29C2B")
    @DSModeled(DSC.SAFE)
    public View findFocus() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "1D4A87A45389821BFC7421CA2D7AD61B", hash_generated_method = "022E076C7DD8C8EB2156AF7BCBA6C3FF")
    @DSModeled(DSC.SAFE)
    public void setScrollContainer(boolean isScrollContainer) {
        dsTaint.addTaint(isScrollContainer);
        {
            {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            } //End block
            mPrivateFlags |= SCROLL_CONTAINER;
        } //End block
        {
            {
                mAttachInfo.mScrollContainers.remove(this);
            } //End block
            mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        } //End block
        // ---------- Original Method ----------
        //if (isScrollContainer) {
            //if (mAttachInfo != null && (mPrivateFlags&SCROLL_CONTAINER_ADDED) == 0) {
                //mAttachInfo.mScrollContainers.add(this);
                //mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            //}
            //mPrivateFlags |= SCROLL_CONTAINER;
        //} else {
            //if ((mPrivateFlags&SCROLL_CONTAINER_ADDED) != 0) {
                //mAttachInfo.mScrollContainers.remove(this);
            //}
            //mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "B2DEE8CA09FADC0B572CF46E784DEFD4", hash_generated_method = "2947A7C2E2178EEE45083F180704EB3B")
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheQuality() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "9D6669AC39CE9592E8D8B20B25494E51", hash_generated_method = "FB72B34B05FBD1FB06E5BD7C5F7FE3BA")
    @DSModeled(DSC.SAFE)
    public void setDrawingCacheQuality(int quality) {
        dsTaint.addTaint(quality);
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
        // ---------- Original Method ----------
        //setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "03B1D1993EB8539284C7E9AFB4C193D6", hash_generated_method = "DF435FA92F85640D4EC839943E8917B9")
    @DSModeled(DSC.SAFE)
    public boolean getKeepScreenOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & KEEP_SCREEN_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "99FBDDFD33142E06617327BD1E6B4E35", hash_generated_method = "BA00940BFA41918B9F63518BA5884A4E")
    @DSModeled(DSC.SAFE)
    public void setKeepScreenOn(boolean keepScreenOn) {
        dsTaint.addTaint(keepScreenOn);
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
        // ---------- Original Method ----------
        //setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "652E85B83FB56D2A13FFAE8255561FDD", hash_generated_method = "1D57E21D424E953C0B569D2A7C591B8F")
    @DSModeled(DSC.SAFE)
    public int getNextFocusLeftId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusLeftId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "38A879027311496175629221AC818202", hash_generated_method = "E04E0DCFF5534DDDE2FA1A1D89BD8D8A")
    @DSModeled(DSC.SAFE)
    public void setNextFocusLeftId(int nextFocusLeftId) {
        dsTaint.addTaint(nextFocusLeftId);
        // ---------- Original Method ----------
        //mNextFocusLeftId = nextFocusLeftId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "C88A703CE946F61F0459BFCDB166A908", hash_generated_method = "599F660BE9479A7BDD5C029DC6A115C5")
    @DSModeled(DSC.SAFE)
    public int getNextFocusRightId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusRightId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "2FF4A363CCED3B1F6EFFEC35EA0E0480", hash_generated_method = "7D68B9060CF06A02CFA1BED8FAB41003")
    @DSModeled(DSC.SAFE)
    public void setNextFocusRightId(int nextFocusRightId) {
        dsTaint.addTaint(nextFocusRightId);
        // ---------- Original Method ----------
        //mNextFocusRightId = nextFocusRightId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "88AE25872576F6D10940E7A2DFEC3C43", hash_generated_method = "AA8340F081E1FB5883EC298971646818")
    @DSModeled(DSC.SAFE)
    public int getNextFocusUpId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusUpId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.953 -0400", hash_original_method = "EB6C60D159C1D76D120BCAB59C29C293", hash_generated_method = "00280D91C0C7E78D27938A483629F2EB")
    @DSModeled(DSC.SAFE)
    public void setNextFocusUpId(int nextFocusUpId) {
        dsTaint.addTaint(nextFocusUpId);
        // ---------- Original Method ----------
        //mNextFocusUpId = nextFocusUpId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "D4E7D4D04A0684EEEE5B75921F57CEF0", hash_generated_method = "B1999AAA029817578C3AD67A418B5FAE")
    @DSModeled(DSC.SAFE)
    public int getNextFocusDownId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusDownId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "3F02629850152C987A67C858A1F48B49", hash_generated_method = "FD52471F426A92DEF8A4BA43CC5ACBAC")
    @DSModeled(DSC.SAFE)
    public void setNextFocusDownId(int nextFocusDownId) {
        dsTaint.addTaint(nextFocusDownId);
        // ---------- Original Method ----------
        //mNextFocusDownId = nextFocusDownId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "73A79720EFCAB292687913BA58A7941B", hash_generated_method = "E8E1DA7A6963922C3DA13B62255C1E5E")
    @DSModeled(DSC.SAFE)
    public int getNextFocusForwardId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusForwardId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "E9ABC127C8FB8F8FC934426D38CB5040", hash_generated_method = "CF737B1A193C0864490401BC401739C1")
    @DSModeled(DSC.SAFE)
    public void setNextFocusForwardId(int nextFocusForwardId) {
        dsTaint.addTaint(nextFocusForwardId);
        // ---------- Original Method ----------
        //mNextFocusForwardId = nextFocusForwardId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "9296F75E65D2F78CDC5D2F47E6CA50BF", hash_generated_method = "092373509262EFFC786F2A95C6EEB712")
    @DSModeled(DSC.SAFE)
    public boolean isShown() {
        View current;
        current = this;
        {
            ViewParent parent;
            parent = current.mParent;
            current = (View) parent;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //View current = this;
        //do {
            //if ((current.mViewFlags & VISIBILITY_MASK) != VISIBLE) {
                //return false;
            //}
            //ViewParent parent = current.mParent;
            //if (parent == null) {
                //return false; 
            //}
            //if (!(parent instanceof View)) {
                //return true;
            //}
            //current = (View) parent;
        //} while (current != null);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "A39140C8CB73A931FE842774091348D2", hash_generated_method = "E27B3F5ACDF39D6EFF442BC0F3EFC220")
    @DSModeled(DSC.SAFE)
    protected boolean fitSystemWindows(Rect insets) {
        dsTaint.addTaint(insets.dsTaint);
        {
            mPaddingLeft = insets.left;
            mPaddingTop = insets.top;
            mPaddingRight = insets.right;
            mPaddingBottom = insets.bottom;
            requestLayout();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS) {
            //mPaddingLeft = insets.left;
            //mPaddingTop = insets.top;
            //mPaddingRight = insets.right;
            //mPaddingBottom = insets.bottom;
            //requestLayout();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "E3CDF7FA6CDC2881F199FFB75CF3D7D5", hash_generated_method = "8950D3B4DB7C9EC6EEE3A83E35E19417")
    @DSModeled(DSC.SAFE)
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        dsTaint.addTaint(fitSystemWindows);
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
        // ---------- Original Method ----------
        //setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "5692CC010F12659264569BED146C3B41", hash_generated_method = "D52A98C5FC7023F2800DDAB76E6FF935")
    @DSModeled(DSC.SAFE)
    public boolean fitsSystemWindows() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "D2B31666DEBF08F8B4CA461C0B34FB1E", hash_generated_method = "A1F3A4A50D48A103745D3AEDE85EE818")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(mapping = {
        @ViewDebug.IntToString(from = VISIBLE,   to = "VISIBLE"),
        @ViewDebug.IntToString(from = INVISIBLE, to = "INVISIBLE"),
        @ViewDebug.IntToString(from = GONE,      to = "GONE")
    })
    public int getVisibility() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mViewFlags & VISIBILITY_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "02AF8E28E646A9214DED62901D5A05AB", hash_generated_method = "5B2DA1A890B49F837E3FC4416EBB4732")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public void setVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        setFlags(visibility, VISIBILITY_MASK);
        mBGDrawable.setVisible(visibility == VISIBLE, false);
        // ---------- Original Method ----------
        //setFlags(visibility, VISIBILITY_MASK);
        //if (mBGDrawable != null) mBGDrawable.setVisible(visibility == VISIBLE, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.954 -0400", hash_original_method = "1FAAF1AA1B65BC3CCFA44E36A044FBA3", hash_generated_method = "9265EA56A6056217F5A75296743AFEA4")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & ENABLED_MASK) == ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "82122684EF3D7563FCC0B376DF0849B5", hash_generated_method = "AF68EB588BC081B20701DA88C1B4F60A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_1585950975 = (enabled == isEnabled());
        } //End collapsed parenthetic
        setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        refreshDrawableState();
        invalidate(true);
        // ---------- Original Method ----------
        //if (enabled == isEnabled()) return;
        //setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        //refreshDrawableState();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "C9881A9860604453F19A8665970456AB", hash_generated_method = "E3A858AD9798AB71B7900767D49F7A89")
    @DSModeled(DSC.SAFE)
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        {
            setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        } //End block
        setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
        // ---------- Original Method ----------
        //if (!focusable) {
            //setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        //}
        //setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "2EADF8D169DEE1EA3C577B22372A4F29", hash_generated_method = "26A7ED2A1BBF1EE7A1AFD8510F296C7D")
    @DSModeled(DSC.SAFE)
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        dsTaint.addTaint(focusableInTouchMode);
        setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        {
            setFlags(FOCUSABLE, FOCUSABLE_MASK);
        } //End block
        // ---------- Original Method ----------
        //setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        //if (focusableInTouchMode) {
            //setFlags(FOCUSABLE, FOCUSABLE_MASK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "0616009511F2186FBF13D4B2BAEA6B3A", hash_generated_method = "068173AFD3C9CF0DB92E967E9778AED4")
    @DSModeled(DSC.SAFE)
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        dsTaint.addTaint(soundEffectsEnabled);
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
        // ---------- Original Method ----------
        //setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "04FBA67AC1724C494C94FB884C5C883F", hash_generated_method = "361F63CC195A13650E8991382ADD4433")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSoundEffectsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "665412B4BA3D450566C79B734C683A80", hash_generated_method = "B7EE899B71F8D9AD65D132CAC14C839B")
    @DSModeled(DSC.SAFE)
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        dsTaint.addTaint(hapticFeedbackEnabled);
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
        // ---------- Original Method ----------
        //setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "69619136C00391879489C4434A4D0191", hash_generated_method = "0AA345A5E15A75A3F4B9BBE521F01693")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "2C2C2D2C9CAFB887317333E5CB13B049", hash_generated_method = "34D62956F4D7B8DFE6EDE9CC830C80C0")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RTL"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_INHERIT, to = "INHERIT"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LOCALE,  to = "LOCALE")
    })
    public int getLayoutDirection() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mViewFlags & LAYOUT_DIRECTION_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "72BED775868D43D3C5AF7895C4FF8A44", hash_generated_method = "F88929FD40A12F2F20526D1C088F6AB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setLayoutDirection(int layoutDirection) {
        dsTaint.addTaint(layoutDirection);
        {
            boolean var321A562371C59BD383BBC58B39275A56_1497796362 = (getLayoutDirection() != layoutDirection);
            {
                resetResolvedLayoutDirection();
                setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getLayoutDirection() != layoutDirection) {
            //resetResolvedLayoutDirection();
            //setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "9F5111100CE328994E06DFE63B825110", hash_generated_method = "1BF2D9E7C8CD3051914DB79C15BCAB21")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "RESOLVED_DIRECTION_LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RESOLVED_DIRECTION_RTL")
    })
    public int getResolvedLayoutDirection() {
        resolveLayoutDirectionIfNeeded();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //resolveLayoutDirectionIfNeeded();
        //return ((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED_RTL) == LAYOUT_DIRECTION_RESOLVED_RTL) ?
                //LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "F4E28248D2C3D2566E14BBF2219E2BCD", hash_generated_method = "12A0ACF4FE405C7890F0A611F19C7A39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty(category = "layout")
    public boolean isLayoutRtl() {
        boolean varA36BF340EF5BBC5D48962FD8A0BF863A_1131476477 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.955 -0400", hash_original_method = "F9FAF3BB929B9847B181A3D88FABD842", hash_generated_method = "BCC2D6062305E2AAA92C1F1A75E6B493")
    @DSModeled(DSC.SAFE)
    public void setWillNotDraw(boolean willNotDraw) {
        dsTaint.addTaint(willNotDraw);
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
        // ---------- Original Method ----------
        //setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "B6E391CBFCFD7EA26D5A2732CEE40DF4", hash_generated_method = "C54E938FECA2EDDCED80E34D7E1849F1")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DRAW_MASK) == WILL_NOT_DRAW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "60A2EABB5E8AA4648C06B0E0E4A2AF9C", hash_generated_method = "BBC319FC842EDFE6134C8A11A9814C55")
    @DSModeled(DSC.SAFE)
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        dsTaint.addTaint(willNotCacheDrawing);
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
        // ---------- Original Method ----------
        //setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "4D65385BAE58DC536EC26F23A55907FF", hash_generated_method = "FF1CC4EFC08438BB7A02FBADFA5352FC")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "CAB421C9E4DB53058A0B9351F5E562C4", hash_generated_method = "77CDB450645A49028FFA7CCF3C939457")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isClickable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & CLICKABLE) == CLICKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "12111EA4E19255C8C0AB24AED3DDA51C", hash_generated_method = "CE4439D7F8D6B3BDF5F14EFF0B42B8E7")
    @DSModeled(DSC.SAFE)
    public void setClickable(boolean clickable) {
        dsTaint.addTaint(clickable);
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "03A713DEC8C026709970488D282B8F0B", hash_generated_method = "3DE0EC8F307FA7D93FF5166F66FCF8E3")
    @DSModeled(DSC.SAFE)
    public boolean isLongClickable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "43536DF18C7BAF4AF88A04663CE8F089", hash_generated_method = "79C7D7547845ADA75025B9D3680ABBC6")
    @DSModeled(DSC.SAFE)
    public void setLongClickable(boolean longClickable) {
        dsTaint.addTaint(longClickable);
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "EED851B5F13351F1D2A34CF3C577E6B2", hash_generated_method = "715E4950513BE86A1F7F8056292617CD")
    @DSModeled(DSC.SAFE)
    public void setPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        {
            mPrivateFlags |= PRESSED;
        } //End block
        {
            mPrivateFlags &= ~PRESSED;
        } //End block
        refreshDrawableState();
        dispatchSetPressed(pressed);
        // ---------- Original Method ----------
        //if (pressed) {
            //mPrivateFlags |= PRESSED;
        //} else {
            //mPrivateFlags &= ~PRESSED;
        //}
        //refreshDrawableState();
        //dispatchSetPressed(pressed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "DBE1A251608D584651DDE119BEFD8059")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "2EE8A3F216F87253226045E7C3E687D4", hash_generated_method = "BDF358C9151C44C870498D00E546D799")
    @DSModeled(DSC.SAFE)
    public boolean isPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & PRESSED) == PRESSED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "A0C463B2F7163F6CE9FACC921DDDC0C1", hash_generated_method = "C69C463AF09E48565844EAE38ABA47C0")
    @DSModeled(DSC.SAFE)
    public boolean isSaveEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "245457DBE539B6534978F5D496F585EA", hash_generated_method = "E8C1286A98810A044041149083AC03AD")
    @DSModeled(DSC.SAFE)
    public void setSaveEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "A79886E869A4527EDC4A240CAA54713C", hash_generated_method = "2639AA2EA03BFB7ECC42E4FB7B106C08")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.956 -0400", hash_original_method = "EDB53D9F0799F64121B32D1526967A47", hash_generated_method = "84F24C9287656524619232ED9A9689B8")
    @DSModeled(DSC.SAFE)
    public void setFilterTouchesWhenObscured(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                //FILTER_TOUCHES_WHEN_OBSCURED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "48E76F9595084274E97DBE24F2087BC5", hash_generated_method = "8BB3A3818D548457DD453A8356CFB2B2")
    @DSModeled(DSC.SAFE)
    public boolean isSaveFromParentEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "72C3E4C29A0B231006D33E493310EA89", hash_generated_method = "94E97BFBC9A6C3D13A317AD362C48D13")
    @DSModeled(DSC.SAFE)
    public void setSaveFromParentEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "C297173E860DE7426FAD1827D2AF0FEF", hash_generated_method = "9CEED621F9063ED87465364195821D54")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public final boolean isFocusable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return FOCUSABLE == (mViewFlags & FOCUSABLE_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "DC5548897986A7EA94B912A4E6E95490", hash_generated_method = "1E39F49D170F43457C31110B9E3C494A")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public final boolean isFocusableInTouchMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "0DA4F7FC608C37A46918AF583285CEAA", hash_generated_method = "0DD127A4C32F714A577A800AFCC10499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(int direction) {
        dsTaint.addTaint(direction);
        {
            View varDF2725BFF6E0DCC0AB37D8D4C46D43EE_647128888 = (mParent.focusSearch(this, direction));
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.focusSearch(this, direction);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "3A7E0D4CA01222234C5493EC87211574", hash_generated_method = "C8FD225646DAED2F307E98F91FC771CB")
    @DSModeled(DSC.SAFE)
    public boolean dispatchUnhandledMove(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "402D36B98ACE611B6285D11A0B7474BF", hash_generated_method = "256E74A19F94F2F9F54DE157CD74D014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findUserSetNextFocus(View root, int direction) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(direction);
        //Begin case FOCUS_LEFT 
        View var71598DDAC8A3CD8E8892CDCC875111FB_747008559 = (findViewInsideOutShouldExist(root, mNextFocusLeftId));
        //End case FOCUS_LEFT 
        //Begin case FOCUS_RIGHT 
        View var8D119958F6B6A370EB1BC1CE0AFE13DA_2071324784 = (findViewInsideOutShouldExist(root, mNextFocusRightId));
        //End case FOCUS_RIGHT 
        //Begin case FOCUS_UP 
        View var1D856002D07ECFBD263D89E69FEAC9D5_1954949527 = (findViewInsideOutShouldExist(root, mNextFocusUpId));
        //End case FOCUS_UP 
        //Begin case FOCUS_DOWN 
        View var8A93DDDBEAF6F274115EA4CE506C765B_1848581014 = (findViewInsideOutShouldExist(root, mNextFocusDownId));
        //End case FOCUS_DOWN 
        //Begin case FOCUS_FORWARD 
        View var157CC14CF45602C8CBCB089735AD1E07_1186549567 = (findViewInsideOutShouldExist(root, mNextFocusForwardId));
        //End case FOCUS_FORWARD 
        //Begin case FOCUS_BACKWARD 
        {
            final int id;
            id = mID;
            View var5619208D61C9FEBEABD1C7B5135A8F62_1481075512 = (root.findViewByPredicateInsideOut(this, new Predicate<View>() {
                    @Override
                    public boolean apply(View t) {
                        return t.mNextFocusForwardId == id;
                    }
                }));
        } //End block
        //End case FOCUS_BACKWARD 
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "B3DFEFAC3DA8B2AFE30A5DD5BC4E600A", hash_generated_method = "BDBFA457732240698723F8719DDEBB45")
    @DSModeled(DSC.SAFE)
    private View findViewInsideOutShouldExist(View root, final int childViewId) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(childViewId);
        View result;
        result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            @Override
            public boolean apply(View t) {
                return t.mID == childViewId;
            }
        });
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            //@Override
            //public boolean apply(View t) {
                //return t.mID == childViewId;
            //}
        //});
        //if (result == null) {
            //Log.w(VIEW_LOG_TAG, "couldn't find next focus view specified "
                    //+ "by user for id " + childViewId);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "464AB183F4A2042C34DE93C717198DDB", hash_generated_method = "0AE36995722FF68ACC42383F77AE201D")
    @DSModeled(DSC.SAFE)
    public ArrayList<View> getFocusables(int direction) {
        dsTaint.addTaint(direction);
        ArrayList<View> result;
        result = new ArrayList<View>(24);
        addFocusables(result, direction);
        return (ArrayList<View>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<View> result = new ArrayList<View>(24);
        //addFocusables(result, direction);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.957 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "C9D0F89EE5C4C453376F102E55CB25B0")
    @DSModeled(DSC.SAFE)
    public void addFocusables(ArrayList<View> views, int direction) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(direction);
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "C71740B3CD39B4D243A828C918021CDE", hash_generated_method = "1D68BD9EB58CB1DC4584272915B002CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focusableMode);
        {
            boolean var8DB70F00D9A309F787FE648FEF017045_1690209673 = (!isFocusable());
        } //End collapsed parenthetic
        {
            boolean var2850B2A852F5A5DCF1E2CF378227B555_53757398 = ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                isInTouchMode() && !isFocusableInTouchMode());
        } //End collapsed parenthetic
        {
            views.add(this);
        } //End block
        // ---------- Original Method ----------
        //if (!isFocusable()) {
            //return;
        //}
        //if ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                //isInTouchMode() && !isFocusableInTouchMode()) {
            //return;
        //}
        //if (views != null) {
            //views.add(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "DD343D81D813CE2B90520525DB465FA4", hash_generated_method = "8880C662FF4D2ED15E1CEECAE681B59B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        dsTaint.addTaint(outViews.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(searched);
        {
            boolean var14B0D5F38B5F4B978CEA9F4FD1437EE5_1566991561 = ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription));
            {
                String searchedLowerCase;
                searchedLowerCase = searched.toString().toLowerCase();
                String contentDescriptionLowerCase;
                contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
                {
                    boolean var5F42F50A6B3B93A57712332F7515E0D4_432188847 = (contentDescriptionLowerCase.contains(searchedLowerCase));
                    {
                        outViews.add(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                //&& !TextUtils.isEmpty(mContentDescription)) {
            //String searchedLowerCase = searched.toString().toLowerCase();
            //String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
            //if (contentDescriptionLowerCase.contains(searchedLowerCase)) {
                //outViews.add(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "FFA271D2293E365BAC2553CB237E7BDA", hash_generated_method = "FECEB138FB249AF5D8A6A1A47DA7D3F1")
    @DSModeled(DSC.SAFE)
    public ArrayList<View> getTouchables() {
        ArrayList<View> result;
        result = new ArrayList<View>();
        addTouchables(result);
        return (ArrayList<View>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<View> result = new ArrayList<View>();
        //addTouchables(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "4A9E887CF81CB13B9475E90E8F7B101A", hash_generated_method = "B4003F9A47FFA281B9955EA63551BD16")
    @DSModeled(DSC.SAFE)
    public void addTouchables(ArrayList<View> views) {
        dsTaint.addTaint(views.dsTaint);
        final int viewFlags;
        viewFlags = mViewFlags;
        {
            views.add(this);
        } //End block
        // ---------- Original Method ----------
        //final int viewFlags = mViewFlags;
        //if (((viewFlags & CLICKABLE) == CLICKABLE || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)
                //&& (viewFlags & ENABLED_MASK) == ENABLED) {
            //views.add(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "D80138743E3873A119DEBFC486319C6F", hash_generated_method = "ACCD7643DF153A7D35BEDFAF405FC4B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocus() {
        boolean varB33B1AB5B273EC528C5AE67F69172D01_1921113536 = (requestFocus(View.FOCUS_DOWN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestFocus(View.FOCUS_DOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.958 -0400", hash_original_method = "0231248B41677D14ABD4C75C00BF9F51", hash_generated_method = "7D6CE5054D2AB99EBCFB575A7B401CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocus(int direction) {
        dsTaint.addTaint(direction);
        boolean varBEB132F64DDBBBEA263C94C9131D5FCE_387858368 = (requestFocus(direction, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestFocus(direction, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "4D4D948013EFF9FDAFD5232E182C7F46", hash_generated_method = "0B3DE0DE872F9FAE913D9F33F2702CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            boolean varD02361A86C03997E5AE6B9686A81F1C2_1959676702 = (isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE)));
        } //End collapsed parenthetic
        {
            boolean varFCFFB1819C9B89AC39385EED17BA34F3_29399482 = (hasAncestorThatBlocksDescendantFocus());
        } //End collapsed parenthetic
        handleFocusGainInternal(direction, previouslyFocusedRect);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mViewFlags & FOCUSABLE_MASK) != FOCUSABLE ||
                //(mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            //return false;
        //}
        //if (isInTouchMode() &&
            //(FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE))) {
               //return false;
        //}
        //if (hasAncestorThatBlocksDescendantFocus()) {
            //return false;
        //}
        //handleFocusGainInternal(direction, previouslyFocusedRect);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "7FA91653ABFF57A00EB7068CB83E321B", hash_generated_method = "F9F658B86A1D25FFF325386294D617F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ViewRootImpl getViewRootImpl() {
        View root;
        root = getRootView();
        {
            Object var58F909C9DCF59E4BF5035C4CA0678945_530673822 = ((ViewRootImpl)root.getParent());
        } //End flattened ternary
        return (ViewRootImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View root = getRootView();
        //return root != null ? (ViewRootImpl)root.getParent() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "1F9F6F0DA182BB29AC330886C262C4C3", hash_generated_method = "7BD81CBCB21D2BA768A9CCEF82CB25EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocusFromTouch() {
        {
            boolean varA7F65F2C3551E1C19C22954843677DD3_533399518 = (isInTouchMode());
            {
                ViewRootImpl viewRoot;
                viewRoot = getViewRootImpl();
                {
                    viewRoot.ensureTouchMode(false);
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean varB33B1AB5B273EC528C5AE67F69172D01_281878570 = (requestFocus(View.FOCUS_DOWN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isInTouchMode()) {
            //ViewRootImpl viewRoot = getViewRootImpl();
            //if (viewRoot != null) {
                //viewRoot.ensureTouchMode(false);
            //}
        //}
        //return requestFocus(View.FOCUS_DOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "AF1FEBD7D3DF68D5685D255FEFA73D33", hash_generated_method = "945649E354B0FBFC5A0B7C15D57104F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasAncestorThatBlocksDescendantFocus() {
        ViewParent ancestor;
        ancestor = mParent;
        {
            final ViewGroup vgAncestor;
            vgAncestor = (ViewGroup) ancestor;
            {
                boolean var6A93B533F786283E71D28D2D3BB8654E_1667340978 = (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                {
                    ancestor = vgAncestor.getParent();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ViewParent ancestor = mParent;
        //while (ancestor instanceof ViewGroup) {
            //final ViewGroup vgAncestor = (ViewGroup) ancestor;
            //if (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS) {
                //return true;
            //} else {
                //ancestor = vgAncestor.getParent();
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "9E8D01E3E35914BE1B580652C44B6D92", hash_generated_method = "DBD953816DA33DB39100F8EE0CD1A607")
    @DSModeled(DSC.SAFE)
    public void dispatchStartTemporaryDetach() {
        onStartTemporaryDetach();
        // ---------- Original Method ----------
        //onStartTemporaryDetach();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "7B585748E6C2A3CE6D3BA7FDB91AA5A9", hash_generated_method = "ED7FECAC94BA44C15E13045B25103A26")
    @DSModeled(DSC.SAFE)
    public void onStartTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
        // ---------- Original Method ----------
        //removeUnsetPressCallback();
        //mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "07C22BEB43BC8453BE2AEA4BC85C2345", hash_generated_method = "9E3AF017EE48DDC80FF8A21A44E486ED")
    @DSModeled(DSC.SAFE)
    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
        // ---------- Original Method ----------
        //onFinishTemporaryDetach();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.972 -0400", hash_original_method = "B87297DA0096F2C31AB92D13B4246B81", hash_generated_method = "2CD00E17DC2AEECEE92EA26E8C46A280")
    @DSModeled(DSC.SAFE)
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "5346C33A691675BA7E77EC00779EE7C7", hash_generated_method = "2B31F3791BCE772E280ABA31598B4481")
    @DSModeled(DSC.SAFE)
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return (KeyEvent.DispatcherState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "6BC846EF16EEF6AFE683BBB51F853755", hash_generated_method = "67E49494AD55BFDC698BD2FA844B23CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean varA1D1F09794689B9E696354A29B1E7AC6_1015518275 = (onKeyPreIme(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onKeyPreIme(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "E10762B11C67C141BFF5425226FAC8FB", hash_generated_method = "C54B799E3BF371A163AD8594F352CF95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean var1AD81DB769C1B29F43EBC2BE5F7D22DB_1684019991 = (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event));
        } //End collapsed parenthetic
        {
            boolean varE1E9B80914776D83D3B032515F60B979_520590610 = (event.dispatch(this, mAttachInfo != null
                ? mAttachInfo.mKeyDispatchState : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        //}
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnKeyListener.onKey(this, event.getKeyCode(), event)) {
            //return true;
        //}
        //if (event.dispatch(this, mAttachInfo != null
                //? mAttachInfo.mKeyDispatchState : null, this)) {
            //return true;
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "24CC3891BCF06B080FB3833309F877D3", hash_generated_method = "4FEB61FF61143D5D2FCEE467A600FC03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean varB65319FC5255424F872A964CBDE1432E_1703811326 = (onKeyShortcut(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "600B8A393DB97B903182B7AB1891AC3E", hash_generated_method = "EF1B69C320501C8E1DCE108934E29EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTouchEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
        {
            boolean var6607193D9DAC59E34045E90E7ECB0599_1262062493 = (onFilterTouchEventForSecurity(event));
            {
                ListenerInfo li;
                li = mListenerInfo;
                {
                    boolean var710CB5FED0ECEB52EC22DD1CD141A5D7_1448498307 = (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event));
                } //End collapsed parenthetic
                {
                    boolean var430E552CCD38EECE5F1A81AADC330527_940841012 = (onTouchEvent(event));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        //}
        //if (onFilterTouchEventForSecurity(event)) {
            //ListenerInfo li = mListenerInfo;
            //if (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    //&& li.mOnTouchListener.onTouch(this, event)) {
                //return true;
            //}
            //if (onTouchEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "D22D4E22492930B2B9E3C8840958D4D7", hash_generated_method = "690916483BB85FC2062C832A4CE7A288")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var702D316B06A93F4CCE85A9302F846D5C_1345682998 = ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                && (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                //&& (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.973 -0400", hash_original_method = "7D8730AF428F1F83C6EA34686735DEE9", hash_generated_method = "5D8B8ADF1A4C80B84418B62AB250892C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTrackballEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        boolean var138C9D0D373C5EB915EF41E377253C34_623905152 = (onTrackballEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        //}
        //return onTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "4D54FFDFE0E351BCF8C37A3BD601042A", hash_generated_method = "A528F5909A006FAF53141A897F89E36A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        final int source;
        source = event.getSource();
        {
            final int action;
            action = event.getAction();
            {
                {
                    boolean varB883F6E8D34F34A7AC9A1C8473B6C6B6_1464394324 = (dispatchHoverEvent(event));
                } //End collapsed parenthetic
            } //End block
            {
                boolean var2FA64A05C793C37BF00E4ECBCAD6D479_1782462222 = (dispatchGenericPointerEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var1E07621182DE67A8830891F3EE4A3942_2081540930 = (dispatchGenericFocusedEvent(event));
        } //End collapsed parenthetic
        {
            boolean varB9448C36962D13B58BD66CC5B67304A5_695026311 = (dispatchGenericMotionEventInternal(event));
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "C7F259FDC1DD0446D3E9FDACCE813628", hash_generated_method = "008463EBD33F11C2C1E1A37BD8441893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchGenericMotionEventInternal(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean varF5508584668781871F7A8EEF6203DF63_1988873068 = (li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event));
        } //End collapsed parenthetic
        {
            boolean varB02F8946AC0F1C42DF139AA516995E2E_111234095 = (onGenericMotionEvent(event));
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnGenericMotionListener != null
                //&& (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnGenericMotionListener.onGenericMotion(this, event)) {
            //return true;
        //}
        //if (onGenericMotionEvent(event)) {
            //return true;
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "648EC8AE542E2EA418563108E4E24BE8", hash_generated_method = "D06110AEAF7988EEFA2EF9876FED3B05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean dispatchHoverEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean varE708EAD4945B3336974BCEC5E5692CEB_512973416 = (li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event));
        } //End collapsed parenthetic
        boolean var20FA514C60FFF8C5D29FC4243A17D964_706724020 = (onHoverEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnHoverListener != null
                //&& (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnHoverListener.onHover(this, event)) {
            //return true;
        //}
        //return onHoverEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "6C63870709E0BCE3150AB1DBD762BE1B", hash_generated_method = "56E1C3F57467987F8A15FBDB47B35BDE")
    @DSModeled(DSC.SAFE)
    protected boolean hasHoveredChild() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "3E380A63A40D63CB8A25C818C007B9B3", hash_generated_method = "E40C12B8399592A4CB16FE77D9E245E8")
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "A2221AB8B5038CA8B5C4F66BF8310DCB", hash_generated_method = "8623D5E9A31D2E292D27C782427130C4")
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "5F3F937CAC1AD8405FC854A70098D82C", hash_generated_method = "C2D0F44518E6D5CC59E88AF3C5E95F6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean dispatchPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var15DC5053D55881959B9A5AB5DA0AE67E_184582079 = (event.isTouchEvent());
            {
                boolean varB6BDA87406308A510ABCADF589E94032_933758582 = (dispatchTouchEvent(event));
            } //End block
            {
                boolean var34A3B038B9117B3BA5FBBDB0BBF251D9_579961806 = (dispatchGenericMotionEvent(event));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (event.isTouchEvent()) {
            //return dispatchTouchEvent(event);
        //} else {
            //return dispatchGenericMotionEvent(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.974 -0400", hash_original_method = "F6C86F5501B65BFAFB8121E3F717BD02", hash_generated_method = "5ADE18641C04DAA2032A7C3A62C0F080")
    @DSModeled(DSC.SAFE)
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        dsTaint.addTaint(hasFocus);
        onWindowFocusChanged(hasFocus);
        // ---------- Original Method ----------
        //onWindowFocusChanged(hasFocus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "F57E7738E41C9719BB0FA37E2B51EE61", hash_generated_method = "07EFA935C9A445DEFA17768C62CA313F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            {
                boolean varF27F491A5EAB0B2989FBEF44657192A7_560396061 = (isPressed());
                {
                    setPressed(false);
                } //End block
            } //End collapsed parenthetic
            {
                imm.focusOut(this);
            } //End block
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } //End block
        {
            imm.focusIn(this);
        } //End block
        refreshDrawableState();
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (!hasWindowFocus) {
            //if (isPressed()) {
                //setPressed(false);
            //}
            //if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
                //imm.focusOut(this);
            //}
            //removeLongPressCallback();
            //removeTapCallback();
            //onFocusLost();
        //} else if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
            //imm.focusIn(this);
        //}
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "43B27055CE530161D72F65ED0A59B9EC", hash_generated_method = "84BA75C699F281001E52137133358ABB")
    @DSModeled(DSC.SAFE)
    public boolean hasWindowFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHasWindowFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "5A92DDE8F02B8EC7BB05F90066C877DB", hash_generated_method = "5655EE2A5A30293FF336A2E77D64E356")
    @DSModeled(DSC.SAFE)
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        onVisibilityChanged(changedView, visibility);
        // ---------- Original Method ----------
        //onVisibilityChanged(changedView, visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "96367A8B641E87C53B477CCACD2EFDC5", hash_generated_method = "CFDE6607270B47D22D8378642E8AE778")
    @DSModeled(DSC.SAFE)
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        {
            {
                initialAwakenScrollBars();
            } //End block
            {
                mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visibility == VISIBLE) {
            //if (mAttachInfo != null) {
                //initialAwakenScrollBars();
            //} else {
                //mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "5C1461045BB49CF5D091FC620162B930", hash_generated_method = "AD32EEC3EB7B9EBB9F18C5B174B61E43")
    @DSModeled(DSC.SAFE)
    public void dispatchDisplayHint(int hint) {
        dsTaint.addTaint(hint);
        onDisplayHint(hint);
        // ---------- Original Method ----------
        //onDisplayHint(hint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "5A8656B423BEB4FF4CA5CD6E6B7C0CE2", hash_generated_method = "49AE282ABDBEE93939C62E08DF0BA78F")
    @DSModeled(DSC.SAFE)
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "3D097367CCB5A92F4CA94066B4093669", hash_generated_method = "3EE2915C65814AFF450378951114217D")
    @DSModeled(DSC.SAFE)
    public void dispatchWindowVisibilityChanged(int visibility) {
        dsTaint.addTaint(visibility);
        onWindowVisibilityChanged(visibility);
        // ---------- Original Method ----------
        //onWindowVisibilityChanged(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "B52A85A1B1D14AC974ADC7B2B6CB318A", hash_generated_method = "4F99C4C16E08E4E1CA37A45A20908AE1")
    @DSModeled(DSC.SAFE)
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        {
            initialAwakenScrollBars();
        } //End block
        // ---------- Original Method ----------
        //if (visibility == VISIBLE) {
            //initialAwakenScrollBars();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.975 -0400", hash_original_method = "B335923547853AC72EE9B6DCDADA38B5", hash_generated_method = "E68F23C07D8E7D35C6D8E72DBA87244C")
    @DSModeled(DSC.SAFE)
    public int getWindowVisibility() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "D236207A35AB4B4964A2350C5EB42480", hash_generated_method = "776C7F1F76AA24792266F81C20CF28EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        dsTaint.addTaint(outRect.dsTaint);
        {
            try 
            {
                mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            } //End block
            catch (RemoteException e)
            { }
            final Rect insets;
            insets = mAttachInfo.mVisibleInsets;
            outRect.left += insets.left;
            outRect.top += insets.top;
            outRect.right -= insets.right;
            outRect.bottom -= insets.bottom;
        } //End block
        Display d;
        d = WindowManagerImpl.getDefault().getDefaultDisplay();
        d.getRectSize(outRect);
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //try {
                //mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            //} catch (RemoteException e) {
                //return;
            //}
            //final Rect insets = mAttachInfo.mVisibleInsets;
            //outRect.left += insets.left;
            //outRect.top += insets.top;
            //outRect.right -= insets.right;
            //outRect.bottom -= insets.bottom;
            //return;
        //}
        //Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        //d.getRectSize(outRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "54CB795C069B52CC42B32E2AD26066B2", hash_generated_method = "FD549417BE66DFDEBD0C41EC84AD1ECC")
    @DSModeled(DSC.SAFE)
    public void dispatchConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        onConfigurationChanged(newConfig);
        // ---------- Original Method ----------
        //onConfigurationChanged(newConfig);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "CD8549EC20E40164D695765A910E1D23")
    @DSModeled(DSC.SAFE)
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "4092DD0F41D441E58BB892F3C094C4B3", hash_generated_method = "28FD105B1CF8DC4F8C817790D47D7C64")
    @DSModeled(DSC.SAFE)
     void dispatchCollectViewAttributes(int visibility) {
        dsTaint.addTaint(visibility);
        performCollectViewAttributes(visibility);
        // ---------- Original Method ----------
        //performCollectViewAttributes(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "01D7FE9ADD969187268E5CA00DFC8244", hash_generated_method = "598F56A8BD49B2ACA93B87A0C1A0BFE2")
    @DSModeled(DSC.SAFE)
     void performCollectViewAttributes(int visibility) {
        dsTaint.addTaint(visibility);
        {
            {
                mAttachInfo.mKeepScreenOn = true;
            } //End block
            mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            ListenerInfo li;
            li = mListenerInfo;
            {
                mAttachInfo.mHasSystemUiListeners = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((visibility & VISIBILITY_MASK) == VISIBLE && mAttachInfo != null) {
            //if ((mViewFlags & KEEP_SCREEN_ON) == KEEP_SCREEN_ON) {
                //mAttachInfo.mKeepScreenOn = true;
            //}
            //mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            //ListenerInfo li = mListenerInfo;
            //if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
                //mAttachInfo.mHasSystemUiListeners = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "9FE32A4CBB26C218394F35C255A8CF99", hash_generated_method = "101A3482C584BF921F13FA9CAD51DDA3")
    @DSModeled(DSC.SAFE)
     void needGlobalAttributesUpdate(boolean force) {
        dsTaint.addTaint(force);
        final AttachInfo ai;
        ai = mAttachInfo;
        {
            {
                ai.mRecomputeGlobalAttributes = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //if (force || ai.mKeepScreenOn || (ai.mSystemUiVisibility != 0)
                    //|| ai.mHasSystemUiListeners) {
                //ai.mRecomputeGlobalAttributes = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "ED47CAF0B3847455A70DC2CFF6AB9C90", hash_generated_method = "CEC66F31B6EEE656CF8A8909EA14E1F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty
    public boolean isInTouchMode() {
        {
            boolean varFF1875034CF47A81AA6602BEECB01842_15916517 = (ViewRootImpl.isInTouchMode());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mInTouchMode;
        //} else {
            //return ViewRootImpl.isInTouchMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "40476492CF1823239B163F06456CE6B2")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "3F070CAC61386FAD746F2003533AED25", hash_generated_method = "941753620FCDDF1B9361DB3DF5941107")
    @DSModeled(DSC.SAFE)
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.976 -0400", hash_original_method = "30943D321BC4BC956C4D9D744FC13942", hash_generated_method = "6AB01A9E12D9162B869D9ACA610A178C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean result;
        result = false;
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            {
                boolean var213035B3AC0E21AB8BF383FF63EBF5BC_736045259 = (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        (event.getRepeatCount() == 0));
                {
                    setPressed(true);
                    checkForLongClick(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_ENTER: {
                //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    //return true;
                //}
                //if (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        //(mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        //(event.getRepeatCount() == 0)) {
                    //setPressed(true);
                    //checkForLongClick(0);
                    //return true;
                //}
                //break;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DA9BC46836632D5DE2442CF165E2ADA1")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "5AB62313644D9CD032AD8CDBAB33BB4C", hash_generated_method = "A9D92482A04A427D81A0AA8D2118689F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean result;
        result = false;
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            {
                boolean var22CDF6A8C6A4F6AF8C611FA66D791C64_711557202 = ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed());
                {
                    setPressed(false);
                    {
                        removeLongPressCallback();
                        result = performClick();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_ENTER: {
                //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    //return true;
                //}
                //if ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed()) {
                    //setPressed(false);
                    //if (!mHasPerformedLongPress) {
                        //removeLongPressCallback();
                        //result = performClick();
                    //}
                //}
                //break;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "0E01544320A5CC465E03FDA462609D24")
    @DSModeled(DSC.SAFE)
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "364CE6898BE65A7CFF9904AA77AFAA75")
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "47FC099EDD591711C69A21361EB96357", hash_generated_method = "2FA9C6CF5075EC38597148228B92D179")
    @DSModeled(DSC.SAFE)
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "0601401EB37355AF70FCC37B4ABEB0DF", hash_generated_method = "008156B140A98271FED2772D34E67346")
    @DSModeled(DSC.SAFE)
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "225D79BB0F164EDB8833C9EDCA3E1422", hash_generated_method = "2ECE4BF2DF4AD4E815901D70FAC9A963")
    @DSModeled(DSC.SAFE)
    public boolean checkInputConnectionProxy(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "3CE367A3F7143B170AAF00E81005E914", hash_generated_method = "E10D6272A200CE7D4CD5E26102FC5C19")
    @DSModeled(DSC.SAFE)
    public void createContextMenu(ContextMenu menu) {
        dsTaint.addTaint(menu.dsTaint);
        ContextMenuInfo menuInfo;
        menuInfo = getContextMenuInfo();
        ((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        onCreateContextMenu(menu);
        ListenerInfo li;
        li = mListenerInfo;
        {
            li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        } //End block
        ((MenuBuilder)menu).setCurrentMenuInfo(null);
        {
            mParent.createContextMenu(menu);
        } //End block
        // ---------- Original Method ----------
        //ContextMenuInfo menuInfo = getContextMenuInfo();
        //((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        //onCreateContextMenu(menu);
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnCreateContextMenuListener != null) {
            //li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        //}
        //((MenuBuilder)menu).setCurrentMenuInfo(null);
        //if (mParent != null) {
            //mParent.createContextMenu(menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "5F63695E16A345A992F87C295B6530DF", hash_generated_method = "F5BBD690A65D3EE00594EA4E1C9EA554")
    @DSModeled(DSC.SAFE)
    protected ContextMenuInfo getContextMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "6522DD22D3C6D7A95FA248A3D5D95901", hash_generated_method = "AC5DC7BFF7D867C321A3E1C9BF6A4DDA")
    @DSModeled(DSC.SAFE)
    protected void onCreateContextMenu(ContextMenu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.977 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "B408743212A32554110D224D6DDF0567")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "BEBEED24402A14C8538F8CE978A041B5")
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "5922A88C022E21B0C70489BC0DBE35EF", hash_generated_method = "4C9D9BE5F37696E4493FD29FC263F4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        final int action;
        action = event.getAction();
        {
            {
                boolean var50C2C1648FCAD417F5DFCEAC97574026_2030444817 = ((action == MotionEvent.ACTION_HOVER_ENTER
                    || action == MotionEvent.ACTION_HOVER_MOVE)
                    && !hasHoveredChild()
                    && pointInView(event.getX(), event.getY()));
                {
                    mSendingHoverAccessibilityEvents = true;
                    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_ENTER);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var96DFD226589477FD552DD4E5C844A258_386366972 = (action == MotionEvent.ACTION_HOVER_EXIT
                    || (action == MotionEvent.ACTION_HOVER_MOVE
                            && !pointInView(event.getX(), event.getY())));
                {
                    mSendingHoverAccessibilityEvents = false;
                    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_EXIT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var25FE040CDD1CBE5B8AA6184119AEA24C_1624523474 = (isHoverable());
            {
                //Begin case MotionEvent.ACTION_HOVER_ENTER 
                setHovered(true);
                //End case MotionEvent.ACTION_HOVER_ENTER 
                //Begin case MotionEvent.ACTION_HOVER_EXIT 
                setHovered(false);
                //End case MotionEvent.ACTION_HOVER_EXIT 
                dispatchGenericMotionEventInternal(event);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "B9B35BD663CAB028DDAC5D67FB09103D", hash_generated_method = "2D35628B1C3C2C4231AE08888A479C73")
    @DSModeled(DSC.SAFE)
    private boolean isHoverable() {
        final int viewFlags;
        viewFlags = mViewFlags;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int viewFlags = mViewFlags;
        //if ((viewFlags & ENABLED_MASK) == DISABLED) {
            //return false;
        //}
        //return (viewFlags & CLICKABLE) == CLICKABLE
                //|| (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "0724AE81F4A3A3591BB9677111DA3959", hash_generated_method = "69742EEA0DE1BC83C755228865674D0C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isHovered() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & HOVERED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "6A44BB0DB1E9547ADB3859B33BB1BB33", hash_generated_method = "71A2AB7DEC208A66664FD1F52032D4B6")
    @DSModeled(DSC.SAFE)
    public void setHovered(boolean hovered) {
        dsTaint.addTaint(hovered);
        {
            {
                mPrivateFlags |= HOVERED;
                refreshDrawableState();
                onHoverChanged(true);
            } //End block
        } //End block
        {
            {
                mPrivateFlags &= ~HOVERED;
                refreshDrawableState();
                onHoverChanged(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (hovered) {
            //if ((mPrivateFlags & HOVERED) == 0) {
                //mPrivateFlags |= HOVERED;
                //refreshDrawableState();
                //onHoverChanged(true);
            //}
        //} else {
            //if ((mPrivateFlags & HOVERED) != 0) {
                //mPrivateFlags &= ~HOVERED;
                //refreshDrawableState();
                //onHoverChanged(false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.978 -0400", hash_original_method = "E702D19B1B952DDC0E28AFCA7C53007F", hash_generated_method = "51D012703CAE60BC824E42A8BF2B3813")
    @DSModeled(DSC.SAFE)
    public void onHoverChanged(boolean hovered) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hovered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "F0667DD3F99E763B1BFE85806FBAFB16", hash_generated_method = "686DE5A69C7061A865DF65E2B66F37D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        final int viewFlags;
        viewFlags = mViewFlags;
        {
            {
                boolean var603A4D4D69ECAA84FEB3324C67F6C844_1399975413 = (event.getAction() == MotionEvent.ACTION_UP && (mPrivateFlags & PRESSED) != 0);
                {
                    mPrivateFlags &= ~PRESSED;
                    refreshDrawableState();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var2FD9894A0B8D17E7D63035FBAFAC4F4A_1476759954 = (mTouchDelegate.onTouchEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                Object var96ADA7CB150D39A55358E742474108F2_1344243927 = (event.getAction());
                //Begin case MotionEvent.ACTION_UP 
                boolean prepressed;
                prepressed = (mPrivateFlags & PREPRESSED) != 0;
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                {
                    boolean focusTaken;
                    focusTaken = false;
                    {
                        boolean var4010B45C9110D5523B114A445C2F69F9_667477261 = (isFocusable() && isFocusableInTouchMode() && !isFocused());
                        {
                            focusTaken = requestFocus();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        mPrivateFlags |= PRESSED;
                        refreshDrawableState();
                    } //End block
                    {
                        removeLongPressCallback();
                        {
                            {
                                mPerformClick = new PerformClick();
                            } //End block
                            {
                                boolean var7529B8C360AE15DA8B22EFD2F54DEBE4_38739944 = (!post(mPerformClick));
                                {
                                    performClick();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        mUnsetPressedState = new UnsetPressedState();
                    } //End block
                    {
                        postDelayed(mUnsetPressedState,
                                    ViewConfiguration.getPressedStateDuration());
                    } //End block
                    {
                        boolean var78C79A084528017AFFB727F82C6C54F8_1781041702 = (!post(mUnsetPressedState));
                        {
                            mUnsetPressedState.run();
                        } //End block
                    } //End collapsed parenthetic
                    removeTapCallback();
                } //End block
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_DOWN 
                mHasPerformedLongPress = false;
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    boolean var05FA8261FD36A1DB58AD7618577A33AB_1758341838 = (performButtonActionOnTouchDown(event));
                } //End collapsed parenthetic
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                boolean isInScrollingContainer;
                isInScrollingContainer = isInScrollingContainer();
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    mPrivateFlags |= PREPRESSED;
                    {
                        mPendingCheckForTap = new CheckForTap();
                    } //End block
                    postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                } //End block
                {
                    mPrivateFlags |= PRESSED;
                    refreshDrawableState();
                    checkForLongClick(0);
                } //End block
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_CANCEL 
                mPrivateFlags &= ~PRESSED;
                //End case MotionEvent.ACTION_CANCEL 
                //Begin case MotionEvent.ACTION_CANCEL 
                refreshDrawableState();
                //End case MotionEvent.ACTION_CANCEL 
                //Begin case MotionEvent.ACTION_CANCEL 
                removeTapCallback();
                //End case MotionEvent.ACTION_CANCEL 
                //Begin case MotionEvent.ACTION_MOVE 
                final int x;
                x = (int) event.getX();
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_MOVE 
                final int y;
                y = (int) event.getY();
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_MOVE 
                {
                    boolean var08A986E19E681C372CEFA5E47F3A6BEE_1575082709 = (!pointInView(x, y, mTouchSlop));
                    {
                        removeTapCallback();
                        {
                            removeLongPressCallback();
                            mPrivateFlags &= ~PRESSED;
                            refreshDrawableState();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                //End case MotionEvent.ACTION_MOVE 
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "7808B21D2BE87077131F031A801646DE", hash_generated_method = "B886DF9B9EBE5AB53A5035E83A3D22C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInScrollingContainer() {
        ViewParent p;
        p = getParent();
        {
            {
                boolean var4881E0F2577352AD9B4EFF88E10A0FFC_503927635 = (((ViewGroup) p).shouldDelayChildPressedState());
            } //End collapsed parenthetic
            p = p.getParent();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ViewParent p = getParent();
        //while (p != null && p instanceof ViewGroup) {
            //if (((ViewGroup) p).shouldDelayChildPressedState()) {
                //return true;
            //}
            //p = p.getParent();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "A93CC85053AADAF4A404AD13182B9757", hash_generated_method = "E07A5CD2D42D2173F508BE237771FDED")
    @DSModeled(DSC.SAFE)
    private void removeLongPressCallback() {
        {
            removeCallbacks(mPendingCheckForLongPress);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingCheckForLongPress != null) {
          //removeCallbacks(mPendingCheckForLongPress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "E1C00ACE8BB8560C240B3C5D040006A3", hash_generated_method = "02314C40B2B8E1F27B00BB3209AD3578")
    @DSModeled(DSC.SAFE)
    private void removePerformClickCallback() {
        {
            removeCallbacks(mPerformClick);
        } //End block
        // ---------- Original Method ----------
        //if (mPerformClick != null) {
            //removeCallbacks(mPerformClick);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "6062C7F52024ACE8958D902CC4268271", hash_generated_method = "07EA02E92BD4486CBDE9218F73B61073")
    @DSModeled(DSC.SAFE)
    private void removeUnsetPressCallback() {
        {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        } //End block
        // ---------- Original Method ----------
        //if ((mPrivateFlags & PRESSED) != 0 && mUnsetPressedState != null) {
            //setPressed(false);
            //removeCallbacks(mUnsetPressedState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.979 -0400", hash_original_method = "B67FA3EAF595424C7D0F48DB4ECBF54E", hash_generated_method = "39AABC510B917E050108C715E3557649")
    @DSModeled(DSC.SAFE)
    private void removeTapCallback() {
        {
            mPrivateFlags &= ~PREPRESSED;
            removeCallbacks(mPendingCheckForTap);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingCheckForTap != null) {
            //mPrivateFlags &= ~PREPRESSED;
            //removeCallbacks(mPendingCheckForTap);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.980 -0400", hash_original_method = "B45EC6A62A5C3981A23AB3F41840A566", hash_generated_method = "A1F9D731502B04C662B49D299DF1D35F")
    @DSModeled(DSC.SAFE)
    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
        // ---------- Original Method ----------
        //removeLongPressCallback();
        //removeTapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.980 -0400", hash_original_method = "8D4D94E2FFA3D8907911FEF22F0F072D", hash_generated_method = "DEEC4DD25865C13BD973803BDC45DF4C")
    @DSModeled(DSC.SAFE)
    private void removeSendViewScrolledAccessibilityEventCallback() {
        {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendViewScrolledAccessibilityEvent != null) {
            //removeCallbacks(mSendViewScrolledAccessibilityEvent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.980 -0400", hash_original_method = "61F54D1D0A5A4D0B5C8BE62B3B180D19", hash_generated_method = "CA6282276474792E0F1FFFC9351827C0")
    @DSModeled(DSC.SAFE)
    public void setTouchDelegate(TouchDelegate delegate) {
        dsTaint.addTaint(delegate.dsTaint);
        // ---------- Original Method ----------
        //mTouchDelegate = delegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.980 -0400", hash_original_method = "C13C756E7E3DD9AFF35525DE74B6A0AE", hash_generated_method = "8B5F1E4590AD1A9932CBA1963D27E57F")
    @DSModeled(DSC.SAFE)
    public TouchDelegate getTouchDelegate() {
        return (TouchDelegate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTouchDelegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.980 -0400", hash_original_method = "DB01C6D64C7923FFF91C0044F6A0DAD3", hash_generated_method = "85C7E875CEAC2BE2753C42DA60B1D17B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setFlags(int flags, int mask) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(mask);
        int old;
        old = mViewFlags;
        mViewFlags = (mViewFlags & ~mask) | (flags & mask);
        int changed;
        changed = mViewFlags ^ old;
        int privateFlags;
        privateFlags = mPrivateFlags;
        {
            {
                clearFocus();
            } //End block
            {
                mParent.focusableViewAvailable(this);
            } //End block
        } //End block
        {
            {
                mPrivateFlags |= DRAWN;
                invalidate(true);
                needGlobalAttributesUpdate(true);
                {
                    mParent.focusableViewAvailable(this);
                } //End block
            } //End block
        } //End block
        {
            needGlobalAttributesUpdate(false);
            requestLayout();
            {
                {
                    boolean var045EBE37E9FC6E3EB86868C8822165CE_15569357 = (hasFocus());
                    clearFocus();
                } //End collapsed parenthetic
                destroyDrawingCache();
                {
                    ((View) mParent).invalidate(true);
                } //End block
                mPrivateFlags |= DRAWN;
            } //End block
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } //End block
        } //End block
        {
            needGlobalAttributesUpdate(false);
            mPrivateFlags |= DRAWN;
            {
                boolean varB31FEE083FA3FF4FCB5289BE9151CED2_957491347 = (((mViewFlags & VISIBILITY_MASK) == INVISIBLE) && hasFocus());
                {
                    {
                        boolean var7EE5FF448100B409C00AA55A4D5A2579_1261307702 = (getRootView() != this);
                        {
                            clearFocus();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } //End block
        } //End block
        {
            {
                ((ViewGroup) mParent).onChildVisibilityChanged(this, (flags & VISIBILITY_MASK));
                ((View) mParent).invalidate(true);
            } //End block
            {
                mParent.invalidateChild(this, null);
            } //End block
            dispatchVisibilityChanged(this, (flags & VISIBILITY_MASK));
        } //End block
        {
            destroyDrawingCache();
        } //End block
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            invalidateParentCaches();
        } //End block
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } //End block
        {
            {
                {
                    mPrivateFlags &= ~SKIP_DRAW;
                    mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                } //End block
                {
                    mPrivateFlags |= SKIP_DRAW;
                } //End block
            } //End block
            {
                mPrivateFlags &= ~SKIP_DRAW;
            } //End block
            requestLayout();
            invalidate(true);
        } //End block
        {
            {
                mParent.recomputeViewAttributes(this);
            } //End block
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "D3A1B9777480096EBBD21F82F884FF88", hash_generated_method = "7B5840F15323FCADB0F811385C7DFD22")
    @DSModeled(DSC.SAFE)
    public void bringToFront() {
        {
            mParent.bringChildToFront(this);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.bringChildToFront(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "EDEAEC3E48D287D80E86A711CB6F1FA1", hash_generated_method = "370BA876A3F240651CF8F28A049E001C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldt);
        dsTaint.addTaint(t);
        dsTaint.addTaint(oldl);
        dsTaint.addTaint(l);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_1562016676 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                postSendViewScrolledAccessibilityEventCallback();
            } //End block
        } //End collapsed parenthetic
        mBackgroundSizeChanged = true;
        final AttachInfo ai;
        ai = mAttachInfo;
        {
            ai.mViewScrollChanged = true;
        } //End block
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //postSendViewScrolledAccessibilityEventCallback();
        //}
        //mBackgroundSizeChanged = true;
        //final AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //ai.mViewScrollChanged = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "B552DCA4F8335CB071F137C97CB4545F", hash_generated_method = "7B74CCFC1C6F249B52C66DB66108D1E9")
    @DSModeled(DSC.SAFE)
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(h);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "919FC5066DC5E0DB74B96DE431E8D6B2")
    @DSModeled(DSC.SAFE)
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "23990FCA043695388FDF30165FAB53F8", hash_generated_method = "0843358577BC26419C74F0EBC6DEA2D6")
    @DSModeled(DSC.SAFE)
    public final ViewParent getParent() {
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "A54235C6FCDDA2041C8AFAE3E4C1E483", hash_generated_method = "2771694E785C1AA196B475E1F57BCE3D")
    @DSModeled(DSC.SAFE)
    public void setScrollX(int value) {
        dsTaint.addTaint(value);
        scrollTo(value, mScrollY);
        // ---------- Original Method ----------
        //scrollTo(value, mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "F511D71F344E6F66807E97ABB51DFE9B", hash_generated_method = "D100A7EE0A63B4B36422C48DB96BB757")
    @DSModeled(DSC.SAFE)
    public void setScrollY(int value) {
        dsTaint.addTaint(value);
        scrollTo(mScrollX, value);
        // ---------- Original Method ----------
        //scrollTo(mScrollX, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "C428FEC3E47D886B393B8FE7E34760FB")
    @DSModeled(DSC.SAFE)
    public final int getScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "D38228FB05D564D5B1A3597C5F27C3E6")
    @DSModeled(DSC.SAFE)
    public final int getScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "FFF18028F96DB13B23AA35EC8A354DA6", hash_generated_method = "5A44E3C7F7EED655FD71C978C9AC197C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRight - mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.981 -0400", hash_original_method = "DB8E3D4F51A57F2E0389486CC016C662", hash_generated_method = "E79B6754E467706C1AF9FD97B37AD8E8")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom - mTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "7CEA71A6443E0B0137E2E074FCAA909B", hash_generated_method = "3501880039EBAEE16A85F70A738411C2")
    @DSModeled(DSC.SAFE)
    public void getDrawingRect(Rect outRect) {
        dsTaint.addTaint(outRect.dsTaint);
        outRect.left = mScrollX;
        outRect.top = mScrollY;
        outRect.right = mScrollX + (mRight - mLeft);
        outRect.bottom = mScrollY + (mBottom - mTop);
        // ---------- Original Method ----------
        //outRect.left = mScrollX;
        //outRect.top = mScrollY;
        //outRect.right = mScrollX + (mRight - mLeft);
        //outRect.bottom = mScrollY + (mBottom - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "A160459557267C576C1546F5990AEB19", hash_generated_method = "94862D069428DAF9360D20F58FBBD65B")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredWidth & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "C38A45A87603EC21B0D791190210A10A", hash_generated_method = "C244FBB34D92E253119F3161D9F34D7F")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredWidthAndState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "DA51B2F5E67991A819725ED6FD645434", hash_generated_method = "80C676F74FCCEF50E990EA70557BA3E6")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredHeight & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "380B2985895F884CFF464A15E274F566", hash_generated_method = "78B0C199E8CED33AC60B46395FD11D82")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeightAndState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "12D9B5BDD1AC8F21212E58A2AB0D2736", hash_generated_method = "1754951769F3E155C2341C8647761C2A")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mMeasuredWidth&MEASURED_STATE_MASK)
                //| ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        //& (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "B4B4CEBFEE2F615BED379C4D0CB9432E", hash_generated_method = "A75847AD7368BAFC11043E43E16C9BC7")
    @DSModeled(DSC.SAFE)
    public Matrix getMatrix() {
        {
            updateMatrix();
        } //End block
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mTransformationInfo != null) {
            //updateMatrix();
            //return mTransformationInfo.mMatrix;
        //}
        //return Matrix.IDENTITY_MATRIX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "589623E980DA9AC2C7F0E7EB39A211D8", hash_generated_method = "FD9FDFAFC3C495C405B5EACE9571D307")
    private static boolean nonzero(float value) {
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "5E74D6706011574C7C512DCC96608456", hash_generated_method = "6EA45D184AAF093DAED07D86D8D2CDC8")
    @DSModeled(DSC.SAFE)
    final boolean hasIdentityMatrix() {
        {
            updateMatrix();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mTransformationInfo != null) {
            //updateMatrix();
            //return mTransformationInfo.mMatrixIsIdentity;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.982 -0400", hash_original_method = "4153D754422EE39DF2ACBB08A45B169B", hash_generated_method = "EC39C49057963CE693EB0C918C8F2911")
    @DSModeled(DSC.SAFE)
     void ensureTransformationInfo() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mTransformationInfo = new TransformationInfo();
        } //End block
        // ---------- Original Method ----------
        //if (mTransformationInfo == null) {
            //mTransformationInfo = new TransformationInfo();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.983 -0400", hash_original_method = "1DF4F5A3EE086291C2134A9A06069FA8", hash_generated_method = "ED80027B0C175AE94A7FD13996F839BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateMatrix() {
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            {
                {
                    info.mPrevWidth = mRight - mLeft;
                    info.mPrevHeight = mBottom - mTop;
                    info.mPivotX = info.mPrevWidth / 2f;
                    info.mPivotY = info.mPrevHeight / 2f;
                } //End block
            } //End block
            info.mMatrix.reset();
            {
                boolean varAB848ECD95BE565B20450DBD0CDBCCC2_148034721 = (!nonzero(info.mRotationX) && !nonzero(info.mRotationY));
                {
                    info.mMatrix.setTranslate(info.mTranslationX, info.mTranslationY);
                    info.mMatrix.preRotate(info.mRotation, info.mPivotX, info.mPivotY);
                    info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
                } //End block
                {
                    {
                        info.mCamera = new Camera();
                        info.matrix3D = new Matrix();
                    } //End block
                    info.mCamera.save();
                    info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
                    info.mCamera.rotate(info.mRotationX, info.mRotationY, -info.mRotation);
                    info.mCamera.getMatrix(info.matrix3D);
                    info.matrix3D.preTranslate(-info.mPivotX, -info.mPivotY);
                    info.matrix3D.postTranslate(info.mPivotX + info.mTranslationX,
                        info.mPivotY + info.mTranslationY);
                    info.mMatrix.postConcat(info.matrix3D);
                    info.mCamera.restore();
                } //End block
            } //End collapsed parenthetic
            info.mMatrixDirty = false;
            info.mMatrixIsIdentity = info.mMatrix.isIdentity();
            info.mInverseMatrixDirty = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.983 -0400", hash_original_method = "9D52A0CAB8326A9AD998EDD411D2DD92", hash_generated_method = "1FE2805FE053FFEBA0D6008BDFE655A8")
    @DSModeled(DSC.SAFE)
    final Matrix getInverseMatrix() {
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            updateMatrix();
            {
                {
                    info.mInverseMatrix = new Matrix();
                } //End block
                info.mMatrix.invert(info.mInverseMatrix);
                info.mInverseMatrixDirty = false;
            } //End block
        } //End block
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final TransformationInfo info = mTransformationInfo;
        //if (info != null) {
            //updateMatrix();
            //if (info.mInverseMatrixDirty) {
                //if (info.mInverseMatrix == null) {
                    //info.mInverseMatrix = new Matrix();
                //}
                //info.mMatrix.invert(info.mInverseMatrix);
                //info.mInverseMatrixDirty = false;
            //}
            //return info.mInverseMatrix;
        //}
        //return Matrix.IDENTITY_MATRIX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.983 -0400", hash_original_method = "210DCA800515E4777DE0E07A52837B76", hash_generated_method = "307436E6CFE2738B652B52370830CDC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCameraDistance(float distance) {
        dsTaint.addTaint(distance);
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        final float dpi;
        dpi = mResources.getDisplayMetrics().densityDpi;
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            info.mCamera = new Camera();
            info.matrix3D = new Matrix();
        } //End block
        info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        info.mMatrixDirty = true;
        invalidate(false);
        // ---------- Original Method ----------
        //invalidateParentCaches();
        //invalidate(false);
        //ensureTransformationInfo();
        //final float dpi = mResources.getDisplayMetrics().densityDpi;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mCamera == null) {
            //info.mCamera = new Camera();
            //info.matrix3D = new Matrix();
        //}
        //info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        //info.mMatrixDirty = true;
        //invalidate(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.983 -0400", hash_original_method = "6D5D42AE33FC6FF98224E10EE022285B", hash_generated_method = "85995209048E517A9D29E18AAE144B81")
    @DSModeled(DSC.SAFE)
    public float getRotation() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotation : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.983 -0400", hash_original_method = "5A5E2BB985CAA77255785D52BE0C3968", hash_generated_method = "71EDC6E787D24AF807988B941071F249")
    @DSModeled(DSC.SAFE)
    public void setRotation(float rotation) {
        dsTaint.addTaint(rotation);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotation = rotation;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotation != rotation) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotation = rotation;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "AE949F6C8375A0B1C86B95F13F6ACDFA", hash_generated_method = "077ED502FE82BBC50CFE9EDD9D141D0E")
    @DSModeled(DSC.SAFE)
    public float getRotationY() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "5A233F5FAA167B597E6F53F6A1ED05E0", hash_generated_method = "3DD8F0105E569B44039D0A2068CADE8D")
    @DSModeled(DSC.SAFE)
    public void setRotationY(float rotationY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(rotationY);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationY = rotationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotationY != rotationY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotationY = rotationY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "A555D00D0BA60E223889AA9DD2F251D5", hash_generated_method = "9D5E3CBD0AC41DD2597BE62B87A720FB")
    @DSModeled(DSC.SAFE)
    public float getRotationX() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "6E42F99146F1D6958E2B3C15F474346C", hash_generated_method = "49424954EB17391DF7567DCAD0AE5875")
    @DSModeled(DSC.SAFE)
    public void setRotationX(float rotationX) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(rotationX);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationX = rotationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotationX != rotationX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotationX = rotationX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "632CD3DC31F3C9373697ECAF67FAF844", hash_generated_method = "3599F0ECF4486179280D8B1F68FE0C58")
    @DSModeled(DSC.SAFE)
    public float getScaleX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleX : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "5D4E1982532E84086C93276B88F3BB0F", hash_generated_method = "4E26006BF31716EE6356636C3BB5A96E")
    @DSModeled(DSC.SAFE)
    public void setScaleX(float scaleX) {
        dsTaint.addTaint(scaleX);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleX = scaleX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mScaleX != scaleX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mScaleX = scaleX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "0DC96E7C5CC6BBD5C09BD0CF27C74A57", hash_generated_method = "6AE6346CAB294485FBFD2C1627BD1DFF")
    @DSModeled(DSC.SAFE)
    public float getScaleY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleY : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.984 -0400", hash_original_method = "31C6EE08A123288B2AD5FB7A2AB8A50C", hash_generated_method = "361F6BDE3F0CC035E1BCF68DE299DBC3")
    @DSModeled(DSC.SAFE)
    public void setScaleY(float scaleY) {
        dsTaint.addTaint(scaleY);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleY = scaleY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mScaleY != scaleY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mScaleY = scaleY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "AEC7496CCA4C936C6BC2B5B4BAFC57DA", hash_generated_method = "C5D30627F84DF879330F8EDFBF9C4EBE")
    @DSModeled(DSC.SAFE)
    public float getPivotX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "DBB537948450A8273883C6E25FB642C5", hash_generated_method = "6787895A46F262DB4779225616318536")
    @DSModeled(DSC.SAFE)
    public void setPivotX(float pivotX) {
        dsTaint.addTaint(pivotX);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotX = pivotX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mPivotX != pivotX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mPivotX = pivotX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "0240E9206D9E9715A6B3E78480FB3A00", hash_generated_method = "A792DA828C139C7A0357A70D88371685")
    @DSModeled(DSC.SAFE)
    public float getPivotY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "6A61D38311657070A62B2EA4ECB210D8", hash_generated_method = "800030700D17251055DE571A7CAD2ED2")
    @DSModeled(DSC.SAFE)
    public void setPivotY(float pivotY) {
        dsTaint.addTaint(pivotY);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotY = pivotY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mPivotY != pivotY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mPivotY = pivotY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "93EFA4392922E182D3B77409B1564364", hash_generated_method = "52BE25A4DDFDE00411CEA7DF93700794")
    @DSModeled(DSC.SAFE)
    public float getAlpha() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mAlpha : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "D47D7B67C2848D6684CE263C68979D07", hash_generated_method = "6F230FB092C24147BCAAF1441CEA5206")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
        {
            boolean var27A92F9962D09A8451E041A66077AE9B_815631167 = (onSetAlpha((int) (alpha * 255)));
            {
                mPrivateFlags |= ALPHA_SET;
                invalidate(true);
            } //End block
            {
                mPrivateFlags &= ~ALPHA_SET;
                invalidate(false);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
        //invalidateParentCaches();
        //if (onSetAlpha((int) (alpha * 255))) {
            //mPrivateFlags |= ALPHA_SET;
            //invalidate(true);
        //} else {
            //mPrivateFlags &= ~ALPHA_SET;
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.985 -0400", hash_original_method = "3CB99BAEF01722CCB474EC85E6659EEE", hash_generated_method = "A41043D54CEDF3C7DEC621768DE3D78D")
    @DSModeled(DSC.SAFE)
     boolean setAlphaNoInvalidation(float alpha) {
        dsTaint.addTaint(alpha);
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        boolean subclassHandlesAlpha;
        subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        {
            mPrivateFlags |= ALPHA_SET;
        } //End block
        {
            mPrivateFlags &= ~ALPHA_SET;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
        //boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        //if (subclassHandlesAlpha) {
            //mPrivateFlags |= ALPHA_SET;
        //} else {
            //mPrivateFlags &= ~ALPHA_SET;
        //}
        //return subclassHandlesAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "7F5BCC343553D8AF12DD736B7A32ED37", hash_generated_method = "A357132260A63CF51841CFFDA8EE095E")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "B40CE7C2F79D3592297A6568172CADD8", hash_generated_method = "294330140AE162AF481AE811DDFBB927")
    @DSModeled(DSC.SAFE)
    public final void setTop(int top) {
        dsTaint.addTaint(top);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int minTop;
                    int yLoc;
                    {
                        minTop = top;
                        yLoc = top - mTop;
                    } //End block
                    {
                        minTop = mTop;
                        yLoc = 0;
                    } //End block
                    invalidate(0, yLoc, mRight - mLeft, mBottom - minTop);
                } //End block
            } //End block
            {
                invalidate(true);
            } //End block
            int width;
            width = mRight - mLeft;
            int oldHeight;
            oldHeight = mBottom - mTop;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "D7B6007ED4F8CEAF5E034DAB4DC51ADC", hash_generated_method = "F0A0280F9831ED917444112202DAD07A")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "389E1BFAE78D9C18A209C3C1F1063911", hash_generated_method = "7082E096A21FEEBB20B94A150CD5E96B")
    @DSModeled(DSC.SAFE)
    public boolean isDirty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & DIRTY_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "23478A87AB3417F9EDAE904815FA444D", hash_generated_method = "75140F176DE78533607BE77FDC0D3C68")
    @DSModeled(DSC.SAFE)
    public final void setBottom(int bottom) {
        dsTaint.addTaint(bottom);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int maxBottom;
                    {
                        maxBottom = mBottom;
                    } //End block
                    {
                        maxBottom = bottom;
                    } //End block
                    invalidate(0, 0, mRight - mLeft, maxBottom - mTop);
                } //End block
            } //End block
            {
                invalidate(true);
            } //End block
            int width;
            width = mRight - mLeft;
            int oldHeight;
            oldHeight = mBottom - mTop;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.986 -0400", hash_original_method = "73B96062BAB5FB21A32F13529B38306E", hash_generated_method = "1C1CA2F28B49C25FE9ED7137F36BF304")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "400602AE9C159A853CD1519C8EEA2C4D", hash_generated_method = "7A9FBCB978F63058551EC80146EDC960")
    @DSModeled(DSC.SAFE)
    public final void setLeft(int left) {
        dsTaint.addTaint(left);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int minLeft;
                    int xLoc;
                    {
                        minLeft = left;
                        xLoc = left - mLeft;
                    } //End block
                    {
                        minLeft = mLeft;
                        xLoc = 0;
                    } //End block
                    invalidate(xLoc, 0, mRight - minLeft, mBottom - mTop);
                } //End block
            } //End block
            {
                invalidate(true);
            } //End block
            int oldWidth;
            oldWidth = mRight - mLeft;
            int height;
            height = mBottom - mTop;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "BAA591F437367FFFE3E50F2B2874B150", hash_generated_method = "A8BE34DD6608055E94863F72108966B8")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "2D86637EDDF21E63210ED8568FEA8F8B", hash_generated_method = "DEC2514CC96F0E321CCB5609FC5CF608")
    @DSModeled(DSC.SAFE)
    public final void setRight(int right) {
        dsTaint.addTaint(right);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int maxRight;
                    {
                        maxRight = mRight;
                    } //End block
                    {
                        maxRight = right;
                    } //End block
                    invalidate(0, 0, maxRight - mLeft, mBottom - mTop);
                } //End block
            } //End block
            {
                invalidate(true);
            } //End block
            int oldWidth;
            oldWidth = mRight - mLeft;
            int height;
            height = mBottom - mTop;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "245DBA10F47190D5F336E33CB089C2B3", hash_generated_method = "90964543E08D08569138ED40CE485C9B")
    @DSModeled(DSC.SAFE)
    public float getX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "CF32EA1F394F68FC79E0B0DE51F0C329", hash_generated_method = "8CCCE02EB9F6A0ED4FC9A592963C14CA")
    @DSModeled(DSC.SAFE)
    public void setX(float x) {
        dsTaint.addTaint(x);
        setTranslationX(x - mLeft);
        // ---------- Original Method ----------
        //setTranslationX(x - mLeft);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "52DD2F53B3B778139AEDE644F53CC413", hash_generated_method = "F47CA41F03B86D22E538BF287DCE4E5D")
    @DSModeled(DSC.SAFE)
    public float getY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.987 -0400", hash_original_method = "17990A784E3651A021C8D9C97053B995", hash_generated_method = "C4584D926A194C640E4BB661838941DE")
    @DSModeled(DSC.SAFE)
    public void setY(float y) {
        dsTaint.addTaint(y);
        setTranslationY(y - mTop);
        // ---------- Original Method ----------
        //setTranslationY(y - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "A376723ACFB723DF70FCDB72B84F3B74", hash_generated_method = "DC020A6298C26E9FAA944587A1B64428")
    @DSModeled(DSC.SAFE)
    public float getTranslationX() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "099C9E42CAA9B2F0466F96FB99A2B049", hash_generated_method = "D6607FF9AC5209A80821174A793123AF")
    @DSModeled(DSC.SAFE)
    public void setTranslationX(float translationX) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(translationX);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationX = translationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mTranslationX != translationX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mTranslationX = translationX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "3533DDBA4926D8143F5FEBC602AC7438", hash_generated_method = "EDF439014FC31731EB2C1D29ABD60000")
    @DSModeled(DSC.SAFE)
    public float getTranslationY() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "162C2FF9FF4565DE36BAE7FE449EEB59", hash_generated_method = "DFE50AD399BD74019D9B76E6931AA698")
    @DSModeled(DSC.SAFE)
    public void setTranslationY(float translationY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(translationY);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationY = translationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mTranslationY != translationY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mTranslationY = translationY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "02B92D2EDB4EF774368BD328DB9464D0", hash_generated_method = "AEAE9A5BC46ED632042C9DA48B005811")
    @DSModeled(DSC.SAFE)
    public void setFastTranslationX(float x) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "7A3DD70389071B86917A72495144388B", hash_generated_method = "D412EB983EA7AC502A882686A8CF5C65")
    @DSModeled(DSC.SAFE)
    public void setFastTranslationY(float y) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "27E5E5A6B58B43EDE1C38FBEFFB0B4F7", hash_generated_method = "A13A4F668242F0AA84D8156AFBEEFF9E")
    @DSModeled(DSC.SAFE)
    public void setFastX(float x) {
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x - mLeft;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.988 -0400", hash_original_method = "435AAC5941937B26A66754F689D5E36E", hash_generated_method = "C6B9531E8AAD186A2597CD06D9E13BA7")
    @DSModeled(DSC.SAFE)
    public void setFastY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y - mTop;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "8FBF5EB14D6023B3D32370623C07D6EB", hash_generated_method = "06A9619F9D2F69CCC73E535A0AAF05F6")
    @DSModeled(DSC.SAFE)
    public void setFastScaleX(float x) {
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "AA6BDD2065E69990CAD75C2A9525B2D0", hash_generated_method = "22D65203EDEA987F00CD9EBF60E23B35")
    @DSModeled(DSC.SAFE)
    public void setFastScaleY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "AD7F6BBA7BB1872387A16DCF0021D7AA", hash_generated_method = "67E8BE9E95E56DEA6B27E6892B8EE0F0")
    @DSModeled(DSC.SAFE)
    public void setFastAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "3ADB507BF62ACDA7E6B7E6725B1B98A0", hash_generated_method = "F592881DF72AB888A6FAE0477A94194C")
    @DSModeled(DSC.SAFE)
    public void setFastRotationY(float y) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info;
        info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mRotationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "CD4FEC45EB5F7DBC5B440DED4446311E", hash_generated_method = "A257F06B64379E2B358794408631B81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getHitRect(Rect outRect) {
        dsTaint.addTaint(outRect.dsTaint);
        updateMatrix();
        final TransformationInfo info;
        info = mTransformationInfo;
        {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } //End block
        {
            final RectF tmpRect;
            tmpRect = mAttachInfo.mTmpTransformRect;
            tmpRect.set(-info.mPivotX, -info.mPivotY,
                    getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            info.mMatrix.mapRect(tmpRect);
            outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    (int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        } //End block
        // ---------- Original Method ----------
        //updateMatrix();
        //final TransformationInfo info = mTransformationInfo;
        //if (info == null || info.mMatrixIsIdentity || mAttachInfo == null) {
            //outRect.set(mLeft, mTop, mRight, mBottom);
        //} else {
            //final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            //tmpRect.set(-info.mPivotX, -info.mPivotY,
                    //getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            //info.mMatrix.mapRect(tmpRect);
            //outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    //(int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "E2A76004025C1F44E382F6372B86BB53", hash_generated_method = "BAB5FE66078246800737337D1794A4AB")
    @DSModeled(DSC.SAFE)
    final boolean pointInView(float localX, float localY) {
        dsTaint.addTaint(localX);
        dsTaint.addTaint(localY);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return localX >= 0 && localX < (mRight - mLeft)
                //&& localY >= 0 && localY < (mBottom - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "D00244756776E7D2FD65633E1CF43263", hash_generated_method = "72E0D6F5C05AF845E4E5AD1A1A31CCFF")
    @DSModeled(DSC.SAFE)
    private boolean pointInView(float localX, float localY, float slop) {
        dsTaint.addTaint(localX);
        dsTaint.addTaint(localY);
        dsTaint.addTaint(slop);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return localX >= -slop && localY >= -slop && localX < ((mRight - mLeft) + slop) &&
                //localY < ((mBottom - mTop) + slop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.989 -0400", hash_original_method = "DDDABA6E6D899E7EA47B4452312088BE", hash_generated_method = "82AB5427FB3EBBC66A8890AE22CB8322")
    @DSModeled(DSC.SAFE)
    public void getFocusedRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        getDrawingRect(r);
        // ---------- Original Method ----------
        //getDrawingRect(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.990 -0400", hash_original_method = "24BDD9FA3E3C2FB6EA31ED75B384BDD9", hash_generated_method = "CA7D759A1F4E5B889A19FFCF58CC9211")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        dsTaint.addTaint(globalOffset.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        int width;
        width = mRight - mLeft;
        int height;
        height = mBottom - mTop;
        {
            r.set(0, 0, width, height);
            {
                globalOffset.set(-mScrollX, -mScrollY);
            } //End block
            boolean varD0C4A40C45EF46AFF22F080E1528CE15_1667094811 = (mParent == null || mParent.getChildVisibleRect(this, r, globalOffset));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int width = mRight - mLeft;
        //int height = mBottom - mTop;
        //if (width > 0 && height > 0) {
            //r.set(0, 0, width, height);
            //if (globalOffset != null) {
                //globalOffset.set(-mScrollX, -mScrollY);
            //}
            //return mParent == null || mParent.getChildVisibleRect(this, r, globalOffset);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.990 -0400", hash_original_method = "EADCD4C63731C6547F1C03CEAFC09A53", hash_generated_method = "731DBCA6288B1E804E844C74D7965426")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getGlobalVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varA0E19E10963694B496EAF71FD83982B3_1352871430 = (getGlobalVisibleRect(r, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getGlobalVisibleRect(r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.990 -0400", hash_original_method = "CB024757CF5A14ECB6F9DCD9789CD2F8", hash_generated_method = "288DC1460A6745D227D4AE19AD4126E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getLocalVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        Point offset;
        offset = new Point();
        {
            boolean varBBF18CCA515610662C9382F2D4C23619_1451699736 = (getGlobalVisibleRect(r, offset));
            {
                r.offset(-offset.x, -offset.y);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Point offset = new Point();
        //if (getGlobalVisibleRect(r, offset)) {
            //r.offset(-offset.x, -offset.y); 
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.990 -0400", hash_original_method = "5A4ADD2D1ADF5703ED27FAE1582BB62A", hash_generated_method = "99E15F9F3F9BD68BEEDB5811E1FD6974")
    @DSModeled(DSC.SAFE)
    public void offsetTopAndBottom(int offset) {
        dsTaint.addTaint(offset);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                final ViewParent p;
                p = mParent;
                {
                    final Rect r;
                    r = mAttachInfo.mTmpInvalRect;
                    int minTop;
                    int maxBottom;
                    int yLoc;
                    {
                        minTop = mTop + offset;
                        maxBottom = mBottom;
                        yLoc = offset;
                    } //End block
                    {
                        minTop = mTop;
                        maxBottom = mBottom + offset;
                        yLoc = 0;
                    } //End block
                    r.set(0, yLoc, mRight - mLeft, maxBottom - minTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
            {
                invalidate(false);
            } //End block
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } //End block
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "A934BA60BC3812BC980C4328CCEB9557", hash_generated_method = "76133D26488B852E21C716A55E254E5C")
    @DSModeled(DSC.SAFE)
    public void offsetLeftAndRight(int offset) {
        dsTaint.addTaint(offset);
        {
            updateMatrix();
            final boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                final ViewParent p;
                p = mParent;
                {
                    final Rect r;
                    r = mAttachInfo.mTmpInvalRect;
                    int minLeft;
                    int maxRight;
                    {
                        minLeft = mLeft + offset;
                        maxRight = mRight;
                    } //End block
                    {
                        minLeft = mLeft;
                        maxRight = mRight + offset;
                    } //End block
                    r.set(0, 0, maxRight - minLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
            {
                invalidate(false);
            } //End block
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } //End block
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "5EB740A9A129A62709C940CDC3C1FA90", hash_generated_method = "852A46B6D691595D126AB7359D4B8293")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "279E70A70FA2B2FEFF6E7E1E87EEDC2B", hash_generated_method = "26A9F7A23A0A57D19CAF4DE3DF01A64C")
    @DSModeled(DSC.SAFE)
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        dsTaint.addTaint(params.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Layout parameters cannot be null");
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new NullPointerException("Layout parameters cannot be null");
        //}
        //mLayoutParams = params;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "C9DC0366B539164245F3B3ACA0A07797", hash_generated_method = "F1B42694BB11A55FC4099257D4D3B53B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scrollTo(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            int oldX;
            oldX = mScrollX;
            int oldY;
            oldY = mScrollY;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                boolean varC828E793AFDA5CD988FA9008B6EB3B30_362395036 = (!awakenScrollBars());
                {
                    invalidate(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mScrollX != x || mScrollY != y) {
            //int oldX = mScrollX;
            //int oldY = mScrollY;
            //mScrollX = x;
            //mScrollY = y;
            //invalidateParentCaches();
            //onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            //if (!awakenScrollBars()) {
                //invalidate(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "9A3BFF0D9282AAB8B07B22048D68076B", hash_generated_method = "44EF964062407ACC25FE707B075C3DE4")
    @DSModeled(DSC.SAFE)
    public void scrollBy(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        scrollTo(mScrollX + x, mScrollY + y);
        // ---------- Original Method ----------
        //scrollTo(mScrollX + x, mScrollY + y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "08F687B40826EF7DBBF2573184DC2210", hash_generated_method = "12049705D1E0AD6FFD24350274416704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars() {
        boolean var70EE0F5768F31DAF2C1A8B4E95A75A4F_774511824 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "2B4CF6E85FAE9FF55F32C24BEFDC5081", hash_generated_method = "CF24943BB077D032031DCD33112A6AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean initialAwakenScrollBars() {
        boolean var92AEF1EA9E316D77EDD85ABCDC19B36B_827954634 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.991 -0400", hash_original_method = "D5CE7E5EDCD7F839910A14AF470AF787", hash_generated_method = "C55E1E264F30870C13E3D63B53DA71EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars(int startDelay) {
        dsTaint.addTaint(startDelay);
        boolean varF0BE7569E2898F8A7748258008B8FAFD_623666298 = (awakenScrollBars(startDelay, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return awakenScrollBars(startDelay, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.992 -0400", hash_original_method = "CAD4350A25772201F660B41D91481A2E", hash_generated_method = "0188B03977B5A0C0AF24C5137A74A1C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        dsTaint.addTaint(startDelay);
        dsTaint.addTaint(invalidate);
        final ScrollabilityCache scrollCache;
        scrollCache = mScrollCache;
        {
            scrollCache.scrollBar = new ScrollBarDrawable();
        } //End block
        {
            boolean var5422F660D44B0D1544FC157071290861_547239041 = (isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled());
            {
                {
                    invalidate(true);
                } //End block
                {
                    final int KEY_REPEAT_FIRST_DELAY;
                    KEY_REPEAT_FIRST_DELAY = 750;
                    startDelay = Math.max(KEY_REPEAT_FIRST_DELAY, startDelay);
                } //End block
                long fadeStartTime;
                fadeStartTime = AnimationUtils.currentAnimationTimeMillis() + startDelay;
                scrollCache.fadeStartTime = fadeStartTime;
                scrollCache.state = ScrollabilityCache.ON;
                {
                    mAttachInfo.mHandler.removeCallbacks(scrollCache);
                    mAttachInfo.mHandler.postAtTime(scrollCache, fadeStartTime);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.992 -0400", hash_original_method = "FC7DFAD8D0391FACDB1212D1D56F8C7D", hash_generated_method = "DA8D0B4210481088327E4E351EEEDBF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean skipInvalidate() {
        boolean var8D9B0BE46D426CBE2B5119C4603A668E_323213895 = ((mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                //(!(mParent instanceof ViewGroup) ||
                        //!((ViewGroup) mParent).isViewTransitioning(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.992 -0400", hash_original_method = "C9F4885B3240AC42BDB62659847A9804", hash_generated_method = "B4F90BBC438A97FAF49C375E23B96914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidate(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_1090013067 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p;
            p = mParent;
            final AttachInfo ai;
            ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } //End block
            } //End block
            {
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
                scrollY = mScrollY;
                final Rect r;
                r = ai.mTmpInvalRect;
                r.set(dirty.left - scrollX, dirty.top - scrollY,
                        dirty.right - scrollX, dirty.bottom - scrollY);
                mParent.invalidateChild(this, r);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.992 -0400", hash_original_method = "ADB8190FF1114977057C1857B6D8BC7D", hash_generated_method = "498D38CDDB26BD6E9859DD707894C413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidate(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_1743526066 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p;
            p = mParent;
            final AttachInfo ai;
            ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } //End block
            } //End block
            {
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
                scrollY = mScrollY;
                final Rect tmpr;
                tmpr = ai.mTmpInvalRect;
                tmpr.set(l - scrollX, t - scrollY, r - scrollX, b - scrollY);
                p.invalidateChild(this, tmpr);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "DD9880156AB041E4BB31F756D1AB2189", hash_generated_method = "79D3BF210A6A4294E0164CAE38D7B32A")
    @DSModeled(DSC.SAFE)
    public void invalidate() {
        invalidate(true);
        // ---------- Original Method ----------
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "2A2B8D7DA5636907090E85C40DC13DF0", hash_generated_method = "CC032FF3509281CCFB7A3BDA9CF20A00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void invalidate(boolean invalidateCache) {
        dsTaint.addTaint(invalidateCache);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_1061009413 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            boolean var5D4EC7C3849E23BFDACCE7FE932C2ED1_650789182 = ((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
                (invalidateCache && (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID) ||
                (mPrivateFlags & INVALIDATED) != INVALIDATED || isOpaque() != mLastIsOpaque);
            {
                mLastIsOpaque = isOpaque();
                mPrivateFlags &= ~DRAWN;
                mPrivateFlags |= DIRTY;
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                } //End block
                final AttachInfo ai;
                ai = mAttachInfo;
                final ViewParent p;
                p = mParent;
                {
                    {
                        p.invalidateChild(this, null);
                    } //End block
                } //End block
                {
                    final Rect r;
                    r = ai.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "9E49D44B70542B7D202A00B58BCD901B", hash_generated_method = "AB7EE9AB31CC88C33F0D5F538599A6E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fastInvalidate() {
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_234614325 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            {
                ((View) mParent).mPrivateFlags |= INVALIDATED;
            } //End block
            mPrivateFlags &= ~DRAWN;
            mPrivateFlags |= DIRTY;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            {
                {
                    mParent.invalidateChild(this, null);
                } //End block
                {
                    final Rect r;
                    r = mAttachInfo.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    mParent.invalidateChild(this, r);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "74A87B1768814B24E7FEDDF99D8537F0", hash_generated_method = "29843BFB377D177B9906107647011C94")
    @DSModeled(DSC.SAFE)
    protected void invalidateParentCaches() {
        {
            ((View) mParent).mPrivateFlags |= INVALIDATED;
        } //End block
        // ---------- Original Method ----------
        //if (mParent instanceof View) {
            //((View) mParent).mPrivateFlags |= INVALIDATED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "A648B59C2EE20F29A9B99BF448851618", hash_generated_method = "598AADF2D5152AB3C30B18071D34E438")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void invalidateParentIfNeeded() {
        {
            boolean var0CFA59CC9046639DFA3FC76B3FAFF415_127516692 = (isHardwareAccelerated() && mParent instanceof View);
            {
                ((View) mParent).invalidate(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isHardwareAccelerated() && mParent instanceof View) {
            //((View) mParent).invalidate(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.993 -0400", hash_original_method = "E9C24F17558159FB485FCFC13D70293E", hash_generated_method = "E322FA83CD86BF640043BC54D7287A37")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                //((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        //>= 1.0f - ViewConfiguration.ALPHA_THRESHOLD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "497EF7DE92B2945B2FEC8F46EAD33430", hash_generated_method = "41944253F29CA4E5D6BB6C57300C102E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computeOpaqueFlags() {
        {
            boolean var4EAF945C1787CBA8CB4548E7AF4BB4B5_254527542 = (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE);
            {
                mPrivateFlags |= OPAQUE_BACKGROUND;
            } //End block
            {
                mPrivateFlags &= ~OPAQUE_BACKGROUND;
            } //End block
        } //End collapsed parenthetic
        final int flags;
        flags = mViewFlags;
        {
            mPrivateFlags |= OPAQUE_SCROLLBARS;
        } //End block
        {
            mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE) {
            //mPrivateFlags |= OPAQUE_BACKGROUND;
        //} else {
            //mPrivateFlags &= ~OPAQUE_BACKGROUND;
        //}
        //final int flags = mViewFlags;
        //if (((flags & SCROLLBARS_VERTICAL) == 0 && (flags & SCROLLBARS_HORIZONTAL) == 0) ||
                //(flags & SCROLLBARS_STYLE_MASK) == SCROLLBARS_INSIDE_OVERLAY) {
            //mPrivateFlags |= OPAQUE_SCROLLBARS;
        //} else {
            //mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "7EE186D55064FCDB5B25DFE594562441", hash_generated_method = "506214E8598AA7C9D1E17E79ACA8AC5D")
    @DSModeled(DSC.SAFE)
    protected boolean hasOpaqueScrollbars() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "DDF5EC42ADE793605447903B93381C32", hash_generated_method = "B4B80B86F35BA2413763E790B5D0F83E")
    @DSModeled(DSC.SAFE)
    public Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mHandler;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "8EDFE6EE958B917F012E9131A0AEA287", hash_generated_method = "00CBE4AD8C565F297CA3F5102102EFB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean post(Runnable action) {
        dsTaint.addTaint(action.dsTaint);
        Handler handler;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } //End block
        {
            ViewRootImpl.getRunQueue().post(action);
        } //End block
        boolean var4B5FBEF08D1252F680BD85D523D3F99E_1769318321 = (handler.post(action));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().post(action);
            //return true;
        //}
        //return handler.post(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "D354828971EFD085BD14FC0D83048A19", hash_generated_method = "D5461C65FFA910410316CD11516E4EBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean postDelayed(Runnable action, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(action.dsTaint);
        Handler handler;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } //End block
        {
            ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
        } //End block
        boolean varA94056EFF6A774C97C990690CB98EF64_2140053303 = (handler.postDelayed(action, delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
            //return true;
        //}
        //return handler.postDelayed(action, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "924A8BEE16A312E53AB8660A02DEF27E", hash_generated_method = "F9CE9DE9015006CE118719E43CC0F370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeCallbacks(Runnable action) {
        dsTaint.addTaint(action.dsTaint);
        Handler handler;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } //End block
        {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
        } //End block
        handler.removeCallbacks(action);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().removeCallbacks(action);
            //return true;
        //}
        //handler.removeCallbacks(action);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "B784E31CF9F406A65D385399252675E5", hash_generated_method = "390AEF22F50A31A19F36DBF6FF95C077")
    @DSModeled(DSC.SAFE)
    public void postInvalidate() {
        postInvalidateDelayed(0);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "F30B35993A01DC68F672A7097988A2B2", hash_generated_method = "AB3968947FBEC76395AE12486B0DA605")
    @DSModeled(DSC.SAFE)
    public void postInvalidate(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        postInvalidateDelayed(0, left, top, right, bottom);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.994 -0400", hash_original_method = "04635C950E88519FA950A99E2186B20C", hash_generated_method = "945665813E40057C4257C0AD23D6D9B5")
    @DSModeled(DSC.SAFE)
    public void postInvalidateDelayed(long delayMilliseconds) {
        dsTaint.addTaint(delayMilliseconds);
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            Message msg;
            msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_MSG;
            msg.obj = this;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        } //End block
        // ---------- Original Method ----------
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //Message msg = Message.obtain();
            //msg.what = AttachInfo.INVALIDATE_MSG;
            //msg.obj = this;
            //attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "2AD5AD2CFDC403E5ADB3F0CF5F7AB2F6", hash_generated_method = "823F0B05C7A251A5D57610DA59D7D40B")
    @DSModeled(DSC.SAFE)
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top,
            int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(delayMilliseconds);
        dsTaint.addTaint(top);
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            final AttachInfo.InvalidateInfo info;
            info = AttachInfo.InvalidateInfo.acquire();
            info.target = this;
            info.left = left;
            info.top = top;
            info.right = right;
            info.bottom = bottom;
            final Message msg;
            msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            msg.obj = info;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        } //End block
        // ---------- Original Method ----------
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //final AttachInfo.InvalidateInfo info = AttachInfo.InvalidateInfo.acquire();
            //info.target = this;
            //info.left = left;
            //info.top = top;
            //info.right = right;
            //info.bottom = bottom;
            //final Message msg = Message.obtain();
            //msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            //msg.obj = info;
            //attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "BB237226F39DBA7BCAA624BDCB91F777", hash_generated_method = "E544166F7E04F78D79A63746F1CE5254")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postSendViewScrolledAccessibilityEventCallback() {
        {
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        } //End block
        {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } //End block
        // ---------- Original Method ----------
        //if (mSendViewScrolledAccessibilityEvent == null) {
            //mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        //}
        //if (!mSendViewScrolledAccessibilityEvent.mIsPending) {
            //mSendViewScrolledAccessibilityEvent.mIsPending = true;
            //postDelayed(mSendViewScrolledAccessibilityEvent,
                    //ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "7821AAE99E52242CE62352C839CCDCC3", hash_generated_method = "F2E0F5404BFBF204C3A79DDEC8ED78BD")
    @DSModeled(DSC.SAFE)
    public void computeScroll() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "2F1443E103CAC5C1C2808AA2ECBBD417", hash_generated_method = "D13572FBE0CB6BD80BD40FFB1336019B")
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalFadingEdgeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "EC0EB62D805892CAAD99FC80B5C4BCFE", hash_generated_method = "BAEDBEB868DFE5E044808FA4A5340F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        dsTaint.addTaint(horizontalFadingEdgeEnabled);
        {
            boolean varA3A448941DEDEC343F4D869D70054393_472089554 = (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled);
            {
                {
                    initScrollCache();
                } //End block
                mViewFlags ^= FADING_EDGE_HORIZONTAL;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            //if (horizontalFadingEdgeEnabled) {
                //initScrollCache();
            //}
            //mViewFlags ^= FADING_EDGE_HORIZONTAL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "DC4B7092961F5604BD589F14B65154AC", hash_generated_method = "2CA37FCF778C14F00E643658F211368F")
    @DSModeled(DSC.SAFE)
    public boolean isVerticalFadingEdgeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "EAF2758FE6F0D2FA48FD42C13EB7A789", hash_generated_method = "8C3A448481896C10E839FC55EBCB028E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        dsTaint.addTaint(verticalFadingEdgeEnabled);
        {
            boolean var01488E834A57F3E5162EDF629729F011_889498708 = (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled);
            {
                {
                    initScrollCache();
                } //End block
                mViewFlags ^= FADING_EDGE_VERTICAL;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled) {
            //if (verticalFadingEdgeEnabled) {
                //initScrollCache();
            //}
            //mViewFlags ^= FADING_EDGE_VERTICAL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.995 -0400", hash_original_method = "CA0383E2F77249B4067FF4C25AA980FC", hash_generated_method = "A35182F27DEACC490EF56FB886029083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getTopFadingEdgeStrength() {
        {
            boolean var95C748EB7173291A5F92BA7AE0D550D8_1546466375 = (computeVerticalScrollOffset() > 0);
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "DD443087D4013745234D8B8402D9412B", hash_generated_method = "ED68EDA1642D04BDF3D1F982740E5D74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varD919087A08EBAF1D1A5831A04C61CDFE_2003314180 = (computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                //computeVerticalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "7D1377787749722D9D47682EF553F1ED", hash_generated_method = "803584AB9ACFCA1C69EC40EB0CA7940B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getLeftFadingEdgeStrength() {
        {
            boolean var7654C1BFABAF507D7C3E35D81F9F8DFD_1234194079 = (computeHorizontalScrollOffset() > 0);
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "1558452CB016696B11D09745F34240BE", hash_generated_method = "1BEF22A0ADAC2246A45E6684120B87CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getRightFadingEdgeStrength() {
        {
            boolean var769CCFA152889A66107FC92852AF7E99_1185145603 = (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                //computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "4C9FBABF966493498122F359EE4D62B4", hash_generated_method = "6013DDFB44A0A059FA9F38B32ECE9D34")
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalScrollBarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "5F4F07B15655223ADE33A1CCE75F1A0B", hash_generated_method = "7AB5871F39AAF16E29A235153308076D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        dsTaint.addTaint(horizontalScrollBarEnabled);
        {
            boolean varCE11BC275FFF6C79CD0949C3947FA397_563019703 = (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled);
            {
                mViewFlags ^= SCROLLBARS_HORIZONTAL;
                computeOpaqueFlags();
                resolvePadding();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled) {
            //mViewFlags ^= SCROLLBARS_HORIZONTAL;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "0838EB3187C4C037AF0DBFBDE06C59DB", hash_generated_method = "413E3C6C3405A52C956AF44293BE9AB4")
    @DSModeled(DSC.SAFE)
    public boolean isVerticalScrollBarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "B0D859209D4F0DED05F4B405F254CC50", hash_generated_method = "1FA8B27EFC3ED076A97D210DEEC82E6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        dsTaint.addTaint(verticalScrollBarEnabled);
        {
            boolean varA8AB3C7A9451600FFE608568BE46B787_1980644690 = (isVerticalScrollBarEnabled() != verticalScrollBarEnabled);
            {
                mViewFlags ^= SCROLLBARS_VERTICAL;
                computeOpaqueFlags();
                resolvePadding();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isVerticalScrollBarEnabled() != verticalScrollBarEnabled) {
            //mViewFlags ^= SCROLLBARS_VERTICAL;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "DC71A98728014C366336C5BC467178FD", hash_generated_method = "E423C907CA1C7353731640B873ADEB26")
    @DSModeled(DSC.SAFE)
    protected void recomputePadding() {
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
        // ---------- Original Method ----------
        //setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "2388F31C9368DE1EC14347F689733603", hash_generated_method = "3314C2ADDE0AE76F99B2BB0E0C06B339")
    @DSModeled(DSC.SAFE)
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        dsTaint.addTaint(fadeScrollbars);
        initScrollCache();
        final ScrollabilityCache scrollabilityCache;
        scrollabilityCache = mScrollCache;
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        {
            scrollabilityCache.state = ScrollabilityCache.OFF;
        } //End block
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } //End block
        // ---------- Original Method ----------
        //initScrollCache();
        //final ScrollabilityCache scrollabilityCache = mScrollCache;
        //scrollabilityCache.fadeScrollBars = fadeScrollbars;
        //if (fadeScrollbars) {
            //scrollabilityCache.state = ScrollabilityCache.OFF;
        //} else {
            //scrollabilityCache.state = ScrollabilityCache.ON;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.996 -0400", hash_original_method = "95A2058DEEA36EE0618643627EDFFE13", hash_generated_method = "8CC9A8843E243CFA241AD726DBD39EE6")
    @DSModeled(DSC.SAFE)
    public boolean isScrollbarFadingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null && mScrollCache.fadeScrollBars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "A645B31717E594F6C2DC0D0454AA457D", hash_generated_method = "5D19E6BD76C7BE57AC240375116066EF")
    @DSModeled(DSC.SAFE)
    public void setScrollBarStyle(int style) {
        dsTaint.addTaint(style);
        {
            mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (style != (mViewFlags & SCROLLBARS_STYLE_MASK)) {
            //mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "05D4731F6FA79F6CC5101E8AAB13BDF7", hash_generated_method = "98DDE375973645DB1B937B90B68A3CE0")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(mapping = {
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_OVERLAY, to = "INSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_INSET, to = "INSIDE_INSET"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_OVERLAY, to = "OUTSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_INSET, to = "OUTSIDE_INSET")
    })
    public int getScrollBarStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mViewFlags & SCROLLBARS_STYLE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "70416A9E9D98F77424E9346E007FCC75", hash_generated_method = "318A3B7E44BC6184E47B1308FB200ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeHorizontalScrollRange() {
        int varF667BBC2F2CB62FFC46148012DBF7327_535729170 = (getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "1DA5A8790403B0D1F6BBC5796ED90152", hash_generated_method = "9870A9E006D923E5552E842278259C9F")
    @DSModeled(DSC.SAFE)
    protected int computeHorizontalScrollOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "4D7C9CACEB957F5429D7FE01BD0E831F", hash_generated_method = "0C0A9C65931B3B2A1969425D487F681D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeHorizontalScrollExtent() {
        int varF667BBC2F2CB62FFC46148012DBF7327_658068435 = (getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "BA8A199276036F5D8FAFD83598D6B62F", hash_generated_method = "2A096861501962843421C8CFE53C49D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeVerticalScrollRange() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_1114249332 = (getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "CE20178D0022D78BDA31343037F660C9", hash_generated_method = "C2040F07EDA4F154CD495D617A958112")
    @DSModeled(DSC.SAFE)
    protected int computeVerticalScrollOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "3058943AF0E0D63E8ED42ACDC59A7606", hash_generated_method = "7116CA7C233B0DD5646EA74704B065D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeVerticalScrollExtent() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_498891734 = (getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "F18C2F0ACE32F9BDC531C26946C884DB", hash_generated_method = "3138AF3DF7225A38FABB0165E4FF17C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canScrollHorizontally(int direction) {
        dsTaint.addTaint(direction);
        final int offset;
        offset = computeHorizontalScrollOffset();
        final int range;
        range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int offset = computeHorizontalScrollOffset();
        //final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        //if (range == 0) return false;
        //if (direction < 0) {
            //return offset > 0;
        //} else {
            //return offset < range - 1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.997 -0400", hash_original_method = "222CDEC9A5062ECAF96BF1766D04B3AA", hash_generated_method = "7D91C6FE32B2644497A1409B04C47F5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canScrollVertically(int direction) {
        dsTaint.addTaint(direction);
        final int offset;
        offset = computeVerticalScrollOffset();
        final int range;
        range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int offset = computeVerticalScrollOffset();
        //final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        //if (range == 0) return false;
        //if (direction < 0) {
            //return offset > 0;
        //} else {
            //return offset < range - 1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.998 -0400", hash_original_method = "BC6A073022E6E75A0ACBB97281459E6B", hash_generated_method = "BFF9E86983D57654EE5D4F833FC9FAB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void onDrawScrollBars(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        final ScrollabilityCache cache;
        cache = mScrollCache;
        {
            int state;
            state = cache.state;
            boolean invalidate;
            invalidate = false;
            {
                {
                    cache.interpolatorValues = new float[1];
                } //End block
                float[] values;
                values = cache.interpolatorValues;
                {
                    boolean var34F9F3B00BE1502DFF6FE96B14D049B7_770590821 = (cache.scrollBarInterpolator.timeToValues(values) ==
                        Interpolator.Result.FREEZE_END);
                    {
                        cache.state = ScrollabilityCache.OFF;
                    } //End block
                    {
                        cache.scrollBar.setAlpha(Math.round(values[0]));
                    } //End block
                } //End collapsed parenthetic
                invalidate = true;
            } //End block
            {
                cache.scrollBar.setAlpha(255);
            } //End block
            final int viewFlags;
            viewFlags = mViewFlags;
            final boolean drawHorizontalScrollBar;
            drawHorizontalScrollBar = (viewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
            final boolean drawVerticalScrollBar;
            drawVerticalScrollBar = (viewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL
                && !isVerticalScrollBarHidden();
            {
                final int width;
                width = mRight - mLeft;
                final int height;
                height = mBottom - mTop;
                final ScrollBarDrawable scrollBar;
                scrollBar = cache.scrollBar;
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
                scrollY = mScrollY;
                final int inside;
                inside = ~0;

                int left, top, right, bottom;
                {
                    int size;
                    size = scrollBar.getSize(false);
                    {
                        size = cache.scrollBarSize;
                    } //End block
                    scrollBar.setParameters(computeHorizontalScrollRange(),
                                            computeHorizontalScrollOffset(),
                                            computeHorizontalScrollExtent(), false);
                    final int verticalScrollBarGap;
                    verticalScrollBarGap = getVerticalScrollbarWidth();

                    top = scrollY + height - size - (mUserPaddingBottom & inside);
                    left = scrollX + (mPaddingLeft & inside);
                    right = scrollX + width - (mUserPaddingRight & inside) - verticalScrollBarGap;
                    bottom = top + size;
                    onDrawHorizontalScrollBar(canvas, scrollBar, left, top, right, bottom);
                    {
                        invalidate(left, top, right, bottom);
                    } //End block
                } //End block
                {
                    int size;
                    size = scrollBar.getSize(true);
                    {
                        size = cache.scrollBarSize;
                    } //End block
                    scrollBar.setParameters(computeVerticalScrollRange(),
                                            computeVerticalScrollOffset(),
                                            computeVerticalScrollExtent(), true);
                    //Begin case default SCROLLBAR_POSITION_DEFAULT SCROLLBAR_POSITION_RIGHT 
                    left = scrollX + width - size - (mUserPaddingRight & inside);
                    //End case default SCROLLBAR_POSITION_DEFAULT SCROLLBAR_POSITION_RIGHT 
                    //Begin case SCROLLBAR_POSITION_LEFT 
                    left = scrollX + (mUserPaddingLeft & inside);
                    //End case SCROLLBAR_POSITION_LEFT 
                    top = scrollY + (mPaddingTop & inside);
                    right = left + size;
                    bottom = scrollY + height - (mUserPaddingBottom & inside);
                    onDrawVerticalScrollBar(canvas, scrollBar, left, top, right, bottom);
                    {
                        invalidate(left, top, right, bottom);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.998 -0400", hash_original_method = "27496C077301642151620030AE06D353", hash_generated_method = "52E14E0D81F0B1156C73C2CF3D4FC24B")
    @DSModeled(DSC.SAFE)
    protected boolean isVerticalScrollBarHidden() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.998 -0400", hash_original_method = "2196C3E195A3664813647CA1F4571C34", hash_generated_method = "F85352FB26FC47A45FAFDDFAD2C273D9")
    @DSModeled(DSC.SAFE)
    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(l);
        dsTaint.addTaint(scrollBar.dsTaint);
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //scrollBar.setBounds(l, t, r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.998 -0400", hash_original_method = "4DC59479DF5AED0094F453B5C8C1A8B1", hash_generated_method = "0710319DB6633F46659C842A87537A6C")
    @DSModeled(DSC.SAFE)
    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(l);
        dsTaint.addTaint(scrollBar.dsTaint);
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //scrollBar.setBounds(l, t, r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.998 -0400", hash_original_method = "88C9EEC1EB66ECE8EDFB3E744FAAD32C", hash_generated_method = "F64D1A3B6270F1F4C12AED30253FDE49")
    @DSModeled(DSC.SAFE)
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "B5B7B4C6E477A3DDB1740C53E1D10BEA", hash_generated_method = "A6A280462D7B4552530A8A238BCE1F2D")
    @DSModeled(DSC.SAFE)
     void assignParent(ViewParent parent) {
        dsTaint.addTaint(parent.dsTaint);
        {
            mParent = null;
        } //End block
        {
            throw new RuntimeException("view " + this + " being added, but"
                    + " it already has a parent");
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //mParent = parent;
        //} else if (parent == null) {
            //mParent = null;
        //} else {
            //throw new RuntimeException("view " + this + " being added, but"
                    //+ " it already has a parent");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "6BE89DDC01776115240A35D213D194B1", hash_generated_method = "04767174DA7D478C397BB3B1AE435CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mParent.requestTransparentRegion(this);
        } //End block
        {
            initialAwakenScrollBars();
            mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        } //End block
        jumpDrawablesToCurrentState();
        resolveLayoutDirectionIfNeeded();
        resolvePadding();
        resolveTextDirection();
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_2007895717 = (isFocused());
            {
                InputMethodManager imm;
                imm = InputMethodManager.peekInstance();
                imm.focusIn(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mPrivateFlags & REQUEST_TRANSPARENT_REGIONS) != 0) {
            //mParent.requestTransparentRegion(this);
        //}
        //if ((mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH) != 0) {
            //initialAwakenScrollBars();
            //mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        //}
        //jumpDrawablesToCurrentState();
        //resolveLayoutDirectionIfNeeded();
        //resolvePadding();
        //resolveTextDirection();
        //if (isFocused()) {
            //InputMethodManager imm = InputMethodManager.peekInstance();
            //imm.focusIn(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "6355C1E1C593C70CD9AB72CB2C730A4B", hash_generated_method = "7D84AC10DBD0528DC2E9CB1C1668C458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resolveLayoutDirectionIfNeeded() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED_RTL;
        resetResolvedTextDirection();
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_1119434511 = (getLayoutDirection());
            //Begin case LAYOUT_DIRECTION_INHERIT 
            {
                ViewGroup viewGroup;
                viewGroup = ((ViewGroup) mParent);
                {
                    boolean varD7173ED74EF8FD4D8C167811281857D6_808893100 = (! viewGroup.canResolveLayoutDirection());
                } //End collapsed parenthetic
                {
                    boolean var8E862BF7D39882400271E2867FE65A16_140082249 = (viewGroup.getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
                    {
                        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case LAYOUT_DIRECTION_INHERIT 
            //Begin case LAYOUT_DIRECTION_RTL 
            mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_LOCALE 
            {
                boolean var9876FCC9113762996D6F4DE738D751FA_2138234152 = (isLayoutDirectionRtl(Locale.getDefault()));
                {
                    mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
                } //End block
            } //End collapsed parenthetic
            //End case LAYOUT_DIRECTION_LOCALE 
        } //End collapsed parenthetic
        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "9FC12AEA6DFF38CE52A88C8E970B863F", hash_generated_method = "5C75E0D887C9232D8105A540174C4781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void resolvePadding() {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1403947838 = (getResolvedLayoutDirection());
            //Begin case LAYOUT_DIRECTION_RTL 
            {
                mUserPaddingRight = mUserPaddingStart;
            } //End block
            {
                mUserPaddingRight = mPaddingRight;
            } //End block
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_RTL 
            {
                mUserPaddingLeft = mUserPaddingEnd;
            } //End block
            {
                mUserPaddingLeft = mPaddingLeft;
            } //End block
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_LTR default 
            {
                mUserPaddingLeft = mUserPaddingStart;
            } //End block
            {
                mUserPaddingLeft = mPaddingLeft;
            } //End block
            //End case LAYOUT_DIRECTION_LTR default 
            //Begin case LAYOUT_DIRECTION_LTR default 
            {
                mUserPaddingRight = mUserPaddingEnd;
            } //End block
            {
                mUserPaddingRight = mPaddingRight;
            } //End block
            //End case LAYOUT_DIRECTION_LTR default 
        } //End collapsed parenthetic
        mUserPaddingBottom = (mUserPaddingBottom >= 0) ? mUserPaddingBottom : mPaddingBottom;
        recomputePadding();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "2870C28D9742C58342A5849284011E72", hash_generated_method = "BBE1E60074E6F703516874E36C5EC1F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean canResolveLayoutDirection() {
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_1633711070 = (getLayoutDirection());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (getLayoutDirection()) {
            //case LAYOUT_DIRECTION_INHERIT:
                //return (mParent != null);
            //default:
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "A8A20BDA6F309AE6FE3C70FD4EB76C3B", hash_generated_method = "1EC677CDCF1956E07EC050A7CCB63687")
    @DSModeled(DSC.SAFE)
    protected void resetResolvedLayoutDirection() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
        // ---------- Original Method ----------
        //mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.999 -0400", hash_original_method = "92CD4C9F6FB5C915A46B2031E7E5CE2E", hash_generated_method = "16CAA5817FBB321431AE4D5C76FEFAA2")
    protected static boolean isLayoutDirectionRtl(Locale locale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "C1067653123E460806048F14F4245D8D", hash_generated_method = "AE8CA0D0CB1C7C118FF6C7C17A9C1C85")
    @DSModeled(DSC.SAFE)
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer();
        {
            mDisplayList.invalidate();
        } //End block
        {
            mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        } //End block
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
        // ---------- Original Method ----------
        //mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        //removeUnsetPressCallback();
        //removeLongPressCallback();
        //removePerformClickCallback();
        //removeSendViewScrolledAccessibilityEventCallback();
        //destroyDrawingCache();
        //destroyLayer();
        //if (mDisplayList != null) {
            //mDisplayList.invalidate();
        //}
        //if (mAttachInfo != null) {
            //mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        //}
        //mCurrentAnimation = null;
        //resetResolvedLayoutDirection();
        //resetResolvedTextDirection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "96241ADC2AE65F6434F9D187AAD690E3", hash_generated_method = "38765332A3854D4F7EDE4D923315532A")
    @DSModeled(DSC.SAFE)
    protected int getWindowAttachCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowAttachCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "B5E940E178CF821C1ABFCBA8A2963390", hash_generated_method = "B6977EA15BE236CDAC2DF7728508BB47")
    @DSModeled(DSC.SAFE)
    public IBinder getWindowToken() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowToken : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "2166F0BF16D53373B488A496114897F8", hash_generated_method = "10E905269F8CD72BE7F8879E32AAFEB5")
    @DSModeled(DSC.SAFE)
    public IBinder getApplicationWindowToken() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        AttachInfo ai;
        ai = mAttachInfo;
        {
            IBinder appWindowToken;
            appWindowToken = ai.mPanelParentWindowToken;
            {
                appWindowToken = ai.mWindowToken;
            } //End block
        } //End block
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //IBinder appWindowToken = ai.mPanelParentWindowToken;
            //if (appWindowToken == null) {
                //appWindowToken = ai.mWindowToken;
            //}
            //return appWindowToken;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "502E0CC6497F900AADF2990690A51539", hash_generated_method = "C63E684513BEADA0D741C49216EB17D6")
    @DSModeled(DSC.SAFE)
     IWindowSession getWindowSession() {
        return (IWindowSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mSession : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "8BF487FADEB8B54B52A076F5E8F3B4CC", hash_generated_method = "1D8F97EBE8CEB1D88DC035122ED88F69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(info.dsTaint);
        mWindowAttachCount++;
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        {
            info.mTreeObserver.merge(mFloatingTreeObserver);
            mFloatingTreeObserver = null;
        } //End block
        {
            mAttachInfo.mScrollContainers.add(this);
            mPrivateFlags |= SCROLL_CONTAINER_ADDED;
        } //End block
        performCollectViewAttributes(visibility);
        onAttachedToWindow();
        ListenerInfo li;
        li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1050308845 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnAttachStateChangeListener listener = seatecAstronomy42.next();
                    {
                        listener.onViewAttachedToWindow(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int vis;
        vis = info.mWindowVisibility;
        {
            onWindowVisibilityChanged(vis);
        } //End block
        {
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.000 -0400", hash_original_method = "6B0EA8A7D63E280C74DFE6EC34A7421B", hash_generated_method = "2DE1903714A0E85E6EA4F9F27DA52C8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchDetachedFromWindow() {
        AttachInfo info;
        info = mAttachInfo;
        {
            int vis;
            vis = info.mWindowVisibility;
            {
                onWindowVisibilityChanged(GONE);
            } //End block
        } //End block
        onDetachedFromWindow();
        ListenerInfo li;
        li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;

        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_919897144 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> seatecAstronomy42 = listeners.iterator();
                    seatecAstronomy42.hasNext();
                    OnAttachStateChangeListener listener = seatecAstronomy42.next();
                    {
                        listener.onViewDetachedFromWindow(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mAttachInfo.mScrollContainers.remove(this);
            mPrivateFlags &= ~SCROLL_CONTAINER_ADDED;
        } //End block
        mAttachInfo = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "DE35B85EA98822B631F87F0518C5E70D", hash_generated_method = "43D652F0A3F6FC5C27C2BC990A3346A3")
    @DSModeled(DSC.SAFE)
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "946C013753556BBC605C0B72B86403CC", hash_generated_method = "358F007750A3BF162F47EF644A7C17C3")
    @DSModeled(DSC.SAFE)
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        {
            mPrivateFlags &= ~SAVE_STATE_CALLED;
            Parcelable state;
            state = onSaveInstanceState();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
            } //End block
            {
                container.put(mID, state);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mID != NO_ID && (mViewFlags & SAVE_DISABLED_MASK) == 0) {
            //mPrivateFlags &= ~SAVE_STATE_CALLED;
            //Parcelable state = onSaveInstanceState();
            //if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                //throw new IllegalStateException(
                        //"Derived class did not call super.onSaveInstanceState()");
            //}
            //if (state != null) {
                //container.put(mID, state);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "071A0CD98D5CB5717BF4FD06D9363A03", hash_generated_method = "E42797ED3747F13FBB61F1EB2D1442F0")
    @DSModeled(DSC.SAFE)
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= SAVE_STATE_CALLED;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mPrivateFlags |= SAVE_STATE_CALLED;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "6EAC0E9F5E844401043B6CA1D363D57E", hash_generated_method = "285D75EAE1C296E86E55FE00AB199A9B")
    @DSModeled(DSC.SAFE)
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "1E9589C1E01E87FD9C38DCF9C7B7C90F", hash_generated_method = "CCE13EAE8F900BCCD1F0EAC8CC9053F4")
    @DSModeled(DSC.SAFE)
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        {
            Parcelable state;
            state = container.get(mID);
            {
                mPrivateFlags &= ~SAVE_STATE_CALLED;
                onRestoreInstanceState(state);
                {
                    throw new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mID != NO_ID) {
            //Parcelable state = container.get(mID);
            //if (state != null) {
                //mPrivateFlags &= ~SAVE_STATE_CALLED;
                //onRestoreInstanceState(state);
                //if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                    //throw new IllegalStateException(
                            //"Derived class did not call super.onRestoreInstanceState()");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "CCFCBEB3529A8F3F9E941DB1236D802B", hash_generated_method = "60C5182DBBC59DD44D925A10A6AFD9EF")
    @DSModeled(DSC.SAFE)
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        mPrivateFlags |= SAVE_STATE_CALLED;
        {
            throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    + "received " + state.getClass().toString() + " instead. This usually happens "
                    + "when two views of different type have the same id in the same hierarchy. "
                    + "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    + "other views do not use the same id.");
        } //End block
        // ---------- Original Method ----------
        //mPrivateFlags |= SAVE_STATE_CALLED;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    //+ "received " + state.getClass().toString() + " instead. This usually happens "
                    //+ "when two views of different type have the same id in the same hierarchy. "
                    //+ "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    //+ "other views do not use the same id.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "120BB71A812D687D5EF2F0B8F5C8CCD2", hash_generated_method = "AF6EF5F3E13AC0A61F271AF3EE451C9F")
    @DSModeled(DSC.SAFE)
    public long getDrawingTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mDrawingTime : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "CAE567A7C394D0DF999555076FD0D1ED", hash_generated_method = "9CBCBD0D9A82D5F1567FB5AC7A2B4244")
    @DSModeled(DSC.SAFE)
    public void setDuplicateParentStateEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
        // ---------- Original Method ----------
        //setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.001 -0400", hash_original_method = "AF26528701A515059D58013186164554", hash_generated_method = "50B1E7B032846C41862AB06F8203B96D")
    @DSModeled(DSC.SAFE)
    public boolean isDuplicateParentStateEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.002 -0400", hash_original_method = "280CFBA803CA9107455CB03D3F8C277D", hash_generated_method = "5DA009DA9B7E37EBB7C4DE99004BC267")
    @DSModeled(DSC.SAFE)
    public void setLayerType(int layerType, Paint paint) {
        dsTaint.addTaint(layerType);
        dsTaint.addTaint(paint.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control)  throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, "
                    + "LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        } //End block
        {
            {
                mLayerPaint = paint == null ? new Paint() : paint;
                invalidateParentCaches();
                invalidate(true);
            } //End block
        } //End block
        //Begin case LAYER_TYPE_HARDWARE 
        destroyLayer();
        //End case LAYER_TYPE_HARDWARE 
        //Begin case LAYER_TYPE_SOFTWARE 
        destroyDrawingCache();
        //End case LAYER_TYPE_SOFTWARE 
        final boolean layerDisabled;
        layerDisabled = mLayerType == LAYER_TYPE_NONE;
        mLayerPaint = layerDisabled ? null : (paint == null ? new Paint() : paint);
        mLocalDirtyRect = layerDisabled ? null : new Rect();
        invalidateParentCaches();
        invalidate(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.002 -0400", hash_original_method = "E009407DF0C30C68D152BB83BB3493E0", hash_generated_method = "0D1319B025A2D5E3BCE0A8543ED7F8F0")
    @DSModeled(DSC.SAFE)
     boolean hasStaticLayer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayerType == LAYER_TYPE_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.002 -0400", hash_original_method = "10BDECB6A9FC24A5B9656AF2BA9D9819", hash_generated_method = "D40447B088EE76277CEEB02790425852")
    @DSModeled(DSC.SAFE)
    public int getLayerType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.002 -0400", hash_original_method = "FDD83A77B112AC8CB3AC65707C3CB088", hash_generated_method = "158ABD6768644B580BDC851CF4F7F3CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void buildLayer() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This view must be attached to a window first");
        } //End block
        //Begin case LAYER_TYPE_HARDWARE 
        {
            boolean var938BC3BB177101C2D5D80B665B48EFE4_157688216 = (mAttachInfo.mHardwareRenderer != null &&
                        mAttachInfo.mHardwareRenderer.isEnabled() &&
                        mAttachInfo.mHardwareRenderer.validate());
            {
                getHardwareLayer();
            } //End block
        } //End collapsed parenthetic
        //End case LAYER_TYPE_HARDWARE 
        //Begin case LAYER_TYPE_SOFTWARE 
        buildDrawingCache(true);
        //End case LAYER_TYPE_SOFTWARE 
        // ---------- Original Method ----------
        //if (mLayerType == LAYER_TYPE_NONE) return;
        //if (mAttachInfo == null) {
            //throw new IllegalStateException("This view must be attached to a window first");
        //}
        //switch (mLayerType) {
            //case LAYER_TYPE_HARDWARE:
                //if (mAttachInfo.mHardwareRenderer != null &&
                        //mAttachInfo.mHardwareRenderer.isEnabled() &&
                        //mAttachInfo.mHardwareRenderer.validate()) {
                    //getHardwareLayer();
                //}
                //break;
            //case LAYER_TYPE_SOFTWARE:
                //buildDrawingCache(true);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.002 -0400", hash_original_method = "1C756BC3105DE982313252676EF7BEA5", hash_generated_method = "07D9B3F8CBEDC25B030C080B1FFA3E42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HardwareLayer getHardwareLayer() {
        {
            boolean var1795335A66B1FC7BB4C3B32BDFD3180D_1527109833 = (mAttachInfo == null || mAttachInfo.mHardwareRenderer == null ||
                !mAttachInfo.mHardwareRenderer.isEnabled());
        } //End collapsed parenthetic
        final int width;
        width = mRight - mLeft;
        final int height;
        height = mBottom - mTop;
        {
            {
                mHardwareLayer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                        width, height, isOpaque());
                mLocalDirtyRect.setEmpty();
            } //End block
            {
                boolean var5013B1CC39A5DD383313D5E39F51669C_215459698 = (mHardwareLayer.getWidth() != width || mHardwareLayer.getHeight() != height);
                {
                    mHardwareLayer.resize(width, height);
                    mLocalDirtyRect.setEmpty();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var08F8E6CAF5391532E58CACD43013438A_1408624227 = (!mHardwareLayer.isValid());
            } //End collapsed parenthetic
            HardwareCanvas currentCanvas;
            currentCanvas = mAttachInfo.mHardwareCanvas;
            final HardwareCanvas canvas;
            canvas = mHardwareLayer.start(currentCanvas);
            {
                mHardwareLayer.end(currentCanvas);
            } //End block
            mAttachInfo.mHardwareCanvas = canvas;
            try 
            {
                canvas.setViewport(width, height);
                canvas.onPreDraw(mLocalDirtyRect);
                mLocalDirtyRect.setEmpty();
                final int restoreCount;
                restoreCount = canvas.save();
                computeScroll();
                canvas.translate(-mScrollX, -mScrollY);
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                {
                    mPrivateFlags &= ~DIRTY_MASK;
                    dispatchDraw(canvas);
                } //End block
                {
                    draw(canvas);
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
            finally 
            {
                canvas.onPostDraw();
                mHardwareLayer.end(currentCanvas);
                mAttachInfo.mHardwareCanvas = currentCanvas;
            } //End block
        } //End block
        return (HardwareLayer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "46CD3F4D955A0CC35E16981FB59107BF", hash_generated_method = "75CD7EC12426E7A710606D50AB2DA7F7")
    @DSModeled(DSC.SAFE)
     boolean destroyLayer() {
        {
            mHardwareLayer.destroy();
            mHardwareLayer = null;
            invalidate(true);
            invalidateParentCaches();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mHardwareLayer != null) {
            //mHardwareLayer.destroy();
            //mHardwareLayer = null;
            //invalidate(true);
            //invalidateParentCaches();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "2A28B7876CAFDC07E0FAFA28070957E8", hash_generated_method = "55B086755D138B5560ECB750E96FD58F")
    @DSModeled(DSC.SAFE)
    protected void destroyHardwareResources() {
        destroyLayer();
        // ---------- Original Method ----------
        //destroyLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "8AD6975BC71E736FF7830468F6E8AB45", hash_generated_method = "332C86863746BB97591D929D9E089F21")
    @DSModeled(DSC.SAFE)
    public void setDrawingCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
        // ---------- Original Method ----------
        //mCachingFailed = false;
        //setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "B123D3E623B7638C240DD8280788F70C", hash_generated_method = "5965E9B75FDE987D69495D9B95E35315")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "ED3E6074026E0275E7BADCEAD02A1919", hash_generated_method = "C49226E4B631849C807314BBBCF7EB66")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    public void outputDirtyFlags(String indent, boolean clear, int clearMask) {
        dsTaint.addTaint(clear);
        dsTaint.addTaint(indent);
        dsTaint.addTaint(clearMask);
        Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                ") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                (mPrivateFlags & View.DRAWING_CACHE_VALID) +
                ") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        {
            ViewGroup parent;
            parent = (ViewGroup) this;
            final int count;
            count = parent.getChildCount();
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = parent.getChildAt(i);
                    child.outputDirtyFlags(indent + "  ", clear, clearMask);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                //") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                //(mPrivateFlags & View.DRAWING_CACHE_VALID) +
                //") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        //if (clear) {
            //mPrivateFlags &= clearMask;
        //}
        //if (this instanceof ViewGroup) {
            //ViewGroup parent = (ViewGroup) this;
            //final int count = parent.getChildCount();
            //for (int i = 0; i < count; i++) {
                //final View child = parent.getChildAt(i);
                //child.outputDirtyFlags(indent + "  ", clear, clearMask);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "F520ED30BD4141F0E67AE80815EDDC89", hash_generated_method = "7E181B4C7B9E07E79522B1546BFC6916")
    @DSModeled(DSC.SAFE)
    protected void dispatchGetDisplayList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.003 -0400", hash_original_method = "AB7D77CF9F94D5BD05F1DB3F0B62C9D0", hash_generated_method = "5A9BDD9CC30A12362604F03E91591944")
    @DSModeled(DSC.SAFE)
    public boolean canHaveDisplayList() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "A79479675DF460DA0EF507C879CE4B27", hash_generated_method = "0B6835A9DE9D50862BDFF36B66599618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DisplayList getDisplayList() {
        {
            boolean var1B563759F0FD29B833433E2C0DB5143B_803848695 = (!canHaveDisplayList());
        } //End collapsed parenthetic
        {
            boolean varCB7B81962DE3C7E60B368CFD3080CE5F_311602828 = (((mPrivateFlags & DRAWING_CACHE_VALID) == 0 ||
                mDisplayList == null || !mDisplayList.isValid() ||
                mRecreateDisplayList));
            {
                {
                    boolean var7C6A47F38E12A6EB14BB2C741855538D_738056991 = (mDisplayList != null && mDisplayList.isValid() &&
                    !mRecreateDisplayList);
                    {
                        mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                        mPrivateFlags &= ~DIRTY_MASK;
                        dispatchGetDisplayList();
                    } //End block
                } //End collapsed parenthetic
                mRecreateDisplayList = true;
                {
                    mDisplayList = mAttachInfo.mHardwareRenderer.createDisplayList();
                    invalidateParentCaches();
                } //End block
                final HardwareCanvas canvas;
                canvas = mDisplayList.start();
                int restoreCount;
                restoreCount = 0;
                try 
                {
                    int width;
                    width = mRight - mLeft;
                    int height;
                    height = mBottom - mTop;
                    canvas.setViewport(width, height);
                    canvas.onPreDraw(null);
                    computeScroll();
                    restoreCount = canvas.save();
                    canvas.translate(-mScrollX, -mScrollY);
                    mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                    mPrivateFlags &= ~DIRTY_MASK;
                    {
                        dispatchDraw(canvas);
                    } //End block
                    {
                        draw(canvas);
                    } //End block
                } //End block
                finally 
                {
                    canvas.restoreToCount(restoreCount);
                    canvas.onPostDraw();
                    mDisplayList.end();
                } //End block
            } //End block
            {
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                mPrivateFlags &= ~DIRTY_MASK;
            } //End block
        } //End collapsed parenthetic
        return (DisplayList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "16C485E3429312C7E841D79823374233", hash_generated_method = "A327AEA9AAC7B7A7C4F89B6154BF9563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getDrawingCache() {
        Bitmap varC02FB90FE084F637ACEE88B420CDF94F_602817185 = (getDrawingCache(false));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "CA92F18E14EB0519BF84A3C226CE3F4A", hash_generated_method = "B2F3BE5C5633481FE2B0BAD9FC044453")
    @DSModeled(DSC.SAFE)
    public Bitmap getDrawingCache(boolean autoScale) {
        dsTaint.addTaint(autoScale);
        {
            buildDrawingCache(autoScale);
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING) {
            //return null;
        //}
        //if ((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED) {
            //buildDrawingCache(autoScale);
        //}
        //return autoScale ? mDrawingCache : mUnscaledDrawingCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "0E5E783B90E69DDC86CBB5AF4D60343F", hash_generated_method = "5E83216661FD3BA9C4969AA091D21379")
    @DSModeled(DSC.SAFE)
    public void destroyDrawingCache() {
        {
            mDrawingCache.recycle();
            mDrawingCache = null;
        } //End block
        {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        } //End block
        // ---------- Original Method ----------
        //if (mDrawingCache != null) {
            //mDrawingCache.recycle();
            //mDrawingCache = null;
        //}
        //if (mUnscaledDrawingCache != null) {
            //mUnscaledDrawingCache.recycle();
            //mUnscaledDrawingCache = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "2126772517D4D51A0CCD7D5847A54B89", hash_generated_method = "D9284D408044B1950C942D3251F1997C")
    @DSModeled(DSC.SAFE)
    public void setDrawingCacheBackgroundColor(int color) {
        dsTaint.addTaint(color);
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } //End block
        // ---------- Original Method ----------
        //if (color != mDrawingCacheBackgroundColor) {
            //mDrawingCacheBackgroundColor = color;
            //mPrivateFlags &= ~DRAWING_CACHE_VALID;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "4BEC5ECE79612E1091BBCBD880B92D6A", hash_generated_method = "CB0B55AF83C52E0ACF0748DC021A5B15")
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDrawingCacheBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.004 -0400", hash_original_method = "8A1B171D557613DB7E4B9E775A2E64AA", hash_generated_method = "86E094D50984332F5AD00D8139920A60")
    @DSModeled(DSC.SAFE)
    public void buildDrawingCache() {
        buildDrawingCache(false);
        // ---------- Original Method ----------
        //buildDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.005 -0400", hash_original_method = "8AFFFACECE9FE8C2DF57758245D0721D", hash_generated_method = "255855C159DD756E305AB7F597CF24BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void buildDrawingCache(boolean autoScale) {
        dsTaint.addTaint(autoScale);
        {
            mCachingFailed = false;
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.BUILD_CACHE);
            } //End block
            int width;
            width = mRight - mLeft;
            int height;
            height = mBottom - mTop;
            final AttachInfo attachInfo;
            attachInfo = mAttachInfo;
            final boolean scalingRequired;
            scalingRequired = attachInfo != null && attachInfo.mScalingRequired;
            {
                width = (int) ((width * attachInfo.mApplicationScale) + 0.5f);
                height = (int) ((height * attachInfo.mApplicationScale) + 0.5f);
            } //End block
            final int drawingCacheBackgroundColor;
            drawingCacheBackgroundColor = mDrawingCacheBackgroundColor;
            final boolean opaque;
            opaque = drawingCacheBackgroundColor != 0 || isOpaque();
            final boolean use32BitCache;
            use32BitCache = attachInfo != null && attachInfo.mUse32BitDrawingCache;
            {
                boolean var555C1BA5A9771D8E1776E57A9469E7A6_1556982128 = (width <= 0 || height <= 0 ||
                    (width * height * (opaque && !use32BitCache ? 2 : 4) >
                            ViewConfiguration.get(mContext).getScaledMaximumDrawingCacheSize())); //DSFIXME:  CODE0008: Nested ternary operator in expression
                {
                    destroyDrawingCache();
                    mCachingFailed = true;
                } //End block
            } //End collapsed parenthetic
            boolean clear;
            clear = true;
            Bitmap bitmap;
            bitmap = mDrawingCache;
            bitmap = mUnscaledDrawingCache;
            {
                boolean var112855DB511D640A3CBF7592003CEA59_1473637304 = (bitmap == null || bitmap.getWidth() != width || bitmap.getHeight() != height);
                {
                    Bitmap.Config quality;
                    {
                        //Begin case DRAWING_CACHE_QUALITY_AUTO 
                        quality = Bitmap.Config.ARGB_8888;
                        //End case DRAWING_CACHE_QUALITY_AUTO 
                        //Begin case DRAWING_CACHE_QUALITY_LOW 
                        quality = Bitmap.Config.ARGB_8888;
                        //End case DRAWING_CACHE_QUALITY_LOW 
                        //Begin case DRAWING_CACHE_QUALITY_HIGH 
                        quality = Bitmap.Config.ARGB_8888;
                        //End case DRAWING_CACHE_QUALITY_HIGH 
                        //Begin case default 
                        quality = Bitmap.Config.ARGB_8888;
                        //End case default 
                    } //End block
                    {
                        quality = use32BitCache ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                    } //End block
                    bitmap.recycle();
                    try 
                    {
                        bitmap = Bitmap.createBitmap(width, height, quality);
                        bitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
                        {
                            mDrawingCache = bitmap;
                        } //End block
                        {
                            mUnscaledDrawingCache = bitmap;
                        } //End block
                        bitmap.setHasAlpha(false);
                    } //End block
                    catch (OutOfMemoryError e)
                    {
                        {
                            mDrawingCache = null;
                        } //End block
                        {
                            mUnscaledDrawingCache = null;
                        } //End block
                        mCachingFailed = true;
                    } //End block
                    clear = drawingCacheBackgroundColor != 0;
                } //End block
            } //End collapsed parenthetic
            Canvas canvas;
            {
                canvas = attachInfo.mCanvas;
                {
                    canvas = new Canvas();
                } //End block
                canvas.setBitmap(bitmap);
                attachInfo.mCanvas = null;
            } //End block
            {
                canvas = new Canvas(bitmap);
            } //End block
            {
                bitmap.eraseColor(drawingCacheBackgroundColor);
            } //End block
            computeScroll();
            final int restoreCount;
            restoreCount = canvas.save();
            {
                final float scale;
                scale = attachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
            canvas.translate(-mScrollX, -mScrollY);
            mPrivateFlags |= DRAWN;
            {
                mPrivateFlags |= DRAWING_CACHE_VALID;
            } //End block
            {
                {
                    ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                } //End block
                mPrivateFlags &= ~DIRTY_MASK;
                dispatchDraw(canvas);
            } //End block
            {
                draw(canvas);
            } //End block
            canvas.restoreToCount(restoreCount);
            canvas.setBitmap(null);
            {
                attachInfo.mCanvas = canvas;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.005 -0400", hash_original_method = "9EC32975405209F06A6AEBC988E2ADFA", hash_generated_method = "35999B58D0D899F750ED6792AABA1BF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        dsTaint.addTaint(skipChildren);
        dsTaint.addTaint(backgroundColor);
        dsTaint.addTaint(quality.dsTaint);
        int width;
        width = mRight - mLeft;
        int height;
        height = mBottom - mTop;
        final AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        final float scale;
        scale = attachInfo.mApplicationScale;
        
        width = (int) ((width * scale) + 0.5f);
        height = (int) ((height * scale) + 0.5f);
        Bitmap bitmap;
        bitmap = Bitmap.createBitmap(width > 0 ? width : 1, height > 0 ? height : 1, quality);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            if (DroidSafeAndroidRuntime.control) throw new OutOfMemoryError();
        } //End block
        Resources resources;
        resources = getResources();
        {
            bitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        } //End block
        Canvas canvas;
        {
            canvas = attachInfo.mCanvas;
            {
                canvas = new Canvas();
            } //End block
            canvas.setBitmap(bitmap);
            attachInfo.mCanvas = null;
        } //End block
        {
            canvas = new Canvas(bitmap);
        } //End block
        {
            bitmap.eraseColor(backgroundColor);
        } //End block
        computeScroll();
        final int restoreCount;
        restoreCount = canvas.save();
        canvas.scale(scale, scale);
        canvas.translate(-mScrollX, -mScrollY);
        int flags;
        flags = mPrivateFlags;
        mPrivateFlags &= ~DIRTY_MASK;
        {
            dispatchDraw(canvas);
        } //End block
        {
            draw(canvas);
        } //End block
        mPrivateFlags = flags;
        canvas.restoreToCount(restoreCount);
        canvas.setBitmap(null);
        {
            attachInfo.mCanvas = canvas;
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "B880B01C07154F288A73209778F72869", hash_generated_method = "35F3E8DB03289A19C046200E168AFC5D")
    @DSModeled(DSC.SAFE)
    public boolean isInEditMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "FAE0811CBF87AAE1D612614CB5EBE838", hash_generated_method = "5E863693DDD8C6A1755E01EB342BFD9E")
    @DSModeled(DSC.SAFE)
    protected boolean isPaddingOffsetRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "4C949B81A8DC7FEE598CF97986A5D947", hash_generated_method = "A0A23A963C3351D24E08291B94192963")
    @DSModeled(DSC.SAFE)
    protected int getLeftPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "074FFDE548FCC46FA1E9A30627AB8A7C", hash_generated_method = "E272B7C477A9E911DA48DF744196C485")
    @DSModeled(DSC.SAFE)
    protected int getRightPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "A9CEAAEF3075A726E0EAEBF5F9AFAFB2", hash_generated_method = "DE5120A0AE296681DED087C16C65AA17")
    @DSModeled(DSC.SAFE)
    protected int getTopPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "8428DF91FD33A9244C31B60F9D34D200", hash_generated_method = "CDF7053CC731F6C6B91D2DB549BA032D")
    @DSModeled(DSC.SAFE)
    protected int getBottomPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "6D1FD6806CEFCA87F4934C6F8CB34AD2", hash_generated_method = "45CC921452B94AC889BFA1C5C883FA55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getFadeTop(boolean offsetRequired) {
        dsTaint.addTaint(offsetRequired);
        int top;
        top = mPaddingTop;
        top += getTopPaddingOffset();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int top = mPaddingTop;
        //if (offsetRequired) top += getTopPaddingOffset();
        //return top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "9B6486C3AB53B66EA69662D43A443B3A", hash_generated_method = "9AF00AD9CFFB77FD1702BEF14ADCB7EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getFadeHeight(boolean offsetRequired) {
        dsTaint.addTaint(offsetRequired);
        int padding;
        padding = mPaddingTop;
        padding += getTopPaddingOffset();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int padding = mPaddingTop;
        //if (offsetRequired) padding += getTopPaddingOffset();
        //return mBottom - mTop - mPaddingBottom - padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.006 -0400", hash_original_method = "E6CC46F2CB7AE1B25C3F8DA9B9857709", hash_generated_method = "9F2305030D630109498E215985D8B675")
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHardwareAccelerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.007 -0400", hash_original_method = "788C5C753E694A468D30095348832570", hash_generated_method = "A3C018EBB3099B8A979697FDCB09E5CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
        } //End block
        final int privateFlags;
        privateFlags = mPrivateFlags;
        final boolean dirtyOpaque;
        dirtyOpaque = (privateFlags & DIRTY_MASK) == DIRTY_OPAQUE &&
                (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState);
        mPrivateFlags = (privateFlags & ~DIRTY_MASK) | DRAWN;
        int saveCount;
        {
            final Drawable background;
            background = mBGDrawable;
            {
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
                scrollY = mScrollY;
                {
                    background.setBounds(0, 0,  mRight - mLeft, mBottom - mTop);
                    mBackgroundSizeChanged = false;
                } //End block
                {
                    background.draw(canvas);
                } //End block
                {
                    canvas.translate(scrollX, scrollY);
                    background.draw(canvas);
                    canvas.translate(-scrollX, -scrollY);
                } //End block
            } //End block
        } //End block
        final int viewFlags;
        viewFlags = mViewFlags;
        boolean horizontalEdges;
        horizontalEdges = (viewFlags & FADING_EDGE_HORIZONTAL) != 0;
        boolean verticalEdges;
        verticalEdges = (viewFlags & FADING_EDGE_VERTICAL) != 0;
        {
            onDraw(canvas);
            dispatchDraw(canvas);
            onDrawScrollBars(canvas);
        } //End block
        boolean drawTop;
        drawTop = false;
        boolean drawBottom;
        drawBottom = false;
        boolean drawLeft;
        drawLeft = false;
        boolean drawRight;
        drawRight = false;
        float topFadeStrength;
        topFadeStrength = 0.0f;
        float bottomFadeStrength;
        bottomFadeStrength = 0.0f;
        float leftFadeStrength;
        leftFadeStrength = 0.0f;
        float rightFadeStrength;
        rightFadeStrength = 0.0f;
        int paddingLeft;
        paddingLeft = mPaddingLeft;
        final boolean offsetRequired;
        offsetRequired = isPaddingOffsetRequired();
        {
            paddingLeft += getLeftPaddingOffset();
        } //End block
        int left;
        left = mScrollX + paddingLeft;
        int right;
        right = left + mRight - mLeft - mPaddingRight - paddingLeft;
        int top;
        top = mScrollY + getFadeTop(offsetRequired);
        int bottom;
        bottom = top + getFadeHeight(offsetRequired);
        {
            right += getRightPaddingOffset();
            bottom += getBottomPaddingOffset();
        } //End block
        final ScrollabilityCache scrollabilityCache;
        scrollabilityCache = mScrollCache;
        final float fadeHeight;
        fadeHeight = scrollabilityCache.fadingEdgeLength;
        int length;
        length = (int) fadeHeight;
        {
            length = (bottom - top) / 2;
        } //End block
        {
            length = (right - left) / 2;
        } //End block
        {
            topFadeStrength = Math.max(0.0f, Math.min(1.0f, getTopFadingEdgeStrength()));
            drawTop = topFadeStrength * fadeHeight > 1.0f;
            bottomFadeStrength = Math.max(0.0f, Math.min(1.0f, getBottomFadingEdgeStrength()));
            drawBottom = bottomFadeStrength * fadeHeight > 1.0f;
        } //End block
        {
            leftFadeStrength = Math.max(0.0f, Math.min(1.0f, getLeftFadingEdgeStrength()));
            drawLeft = leftFadeStrength * fadeHeight > 1.0f;
            rightFadeStrength = Math.max(0.0f, Math.min(1.0f, getRightFadingEdgeStrength()));
            drawRight = rightFadeStrength * fadeHeight > 1.0f;
        } //End block
        saveCount = canvas.getSaveCount();
        int solidColor;
        solidColor = getSolidColor();
        {
            final int flags;
            flags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
            {
                canvas.saveLayer(left, top, right, top + length, null, flags);
            } //End block
            {
                canvas.saveLayer(left, bottom - length, right, bottom, null, flags);
            } //End block
            {
                canvas.saveLayer(left, top, left + length, bottom, null, flags);
            } //End block
            {
                canvas.saveLayer(right - length, top, right, bottom, null, flags);
            } //End block
        } //End block
        {
            scrollabilityCache.setFadeColor(solidColor);
        } //End block
        onDraw(canvas);
        dispatchDraw(canvas);
        final Paint p;
        p = scrollabilityCache.paint;
        final Matrix matrix;
        matrix = scrollabilityCache.matrix;
        final Shader fade;
        fade = scrollabilityCache.shader;
        {
            matrix.setScale(1, fadeHeight * topFadeStrength);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, right, top + length, p);
        } //End block
        {
            matrix.setScale(1, fadeHeight * bottomFadeStrength);
            matrix.postRotate(180);
            matrix.postTranslate(left, bottom);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, bottom - length, right, bottom, p);
        } //End block
        {
            matrix.setScale(1, fadeHeight * leftFadeStrength);
            matrix.postRotate(-90);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, left + length, bottom, p);
        } //End block
        {
            matrix.setScale(1, fadeHeight * rightFadeStrength);
            matrix.postRotate(90);
            matrix.postTranslate(right, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(right - length, top, right, bottom, p);
        } //End block
        canvas.restoreToCount(saveCount);
        onDrawScrollBars(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.007 -0400", hash_original_method = "6ABCD0F86C11EBC98FE78FD55BB4B1CF", hash_generated_method = "B53DDE1FAD12C0FCF4E1A4CFB04C7D4C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.007 -0400", hash_original_method = "1E771000A2DAECAF041D1A8D6047A104", hash_generated_method = "17C49454C4A4D45CEBA42CCF3984A5BE")
    private static String printFlags(int flags) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.007 -0400", hash_original_method = "4F68D1AA8946E291BE26B9CF8033EC43", hash_generated_method = "95DCD43B7A851968E1C7C9A82BA064D0")
    private static String printPrivateFlags(int privateFlags) {
        String output = "";
        int numFlags = 0;
        if ((privateFlags & WANTS_FOCUS) == WANTS_FOCUS) {
            output += "WANTS_FOCUS";
            numFlags++;
        }
        if ((privateFlags & FOCUSED) == FOCUSED) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "FOCUSED";
            numFlags++;
        }
        if ((privateFlags & SELECTED) == SELECTED) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "SELECTED";
            numFlags++;
        }
        if ((privateFlags & IS_ROOT_NAMESPACE) == IS_ROOT_NAMESPACE) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "IS_ROOT_NAMESPACE";
            numFlags++;
        }
        if ((privateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "HAS_BOUNDS";
            numFlags++;
        }
        if ((privateFlags & DRAWN) == DRAWN) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "DRAWN";
        }
        return output;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.008 -0400", hash_original_method = "AB08A97FC3701C702D6BD81573091B60", hash_generated_method = "9B4E4EFC9CCC3027A55483D507F303A8")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.008 -0400", hash_original_method = "288ECB50C55148E98CF66115292FF462", hash_generated_method = "6449C4B98B5F01A92359AC3AE7F69828")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"unchecked"})
    public void layout(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        int oldL;
        oldL = mLeft;
        int oldT;
        oldT = mTop;
        int oldB;
        oldB = mBottom;
        int oldR;
        oldR = mRight;
        boolean changed;
        changed = setFrame(l, t, r, b);
        {
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_LAYOUT);
            } //End block
            onLayout(changed, l, t, r, b);
            mPrivateFlags &= ~LAYOUT_REQUIRED;
            ListenerInfo li;
            li = mListenerInfo;
            {
                ArrayList<OnLayoutChangeListener> listenersCopy;
                listenersCopy = (ArrayList<OnLayoutChangeListener>)li.mOnLayoutChangeListeners.clone();
                int numListeners;
                numListeners = listenersCopy.size();
                {
                    int i;
                    i = 0;
                    {
                        listenersCopy.get(i).onLayoutChange(this, l, t, r, b, oldL, oldT, oldR, oldB);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mPrivateFlags &= ~FORCE_LAYOUT;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.008 -0400", hash_original_method = "E68A871B23A3BFC32DE9705D7524956B", hash_generated_method = "04EC615FB064A8A784DFED0D749C9852")
    @DSModeled(DSC.SAFE)
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(changed);
        dsTaint.addTaint(top);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.008 -0400", hash_original_method = "D0D9CDE5209D8FC4BFA1DB8710882914", hash_generated_method = "B7C4798A5FC9A5F57E46F6CC817B1DD4")
    @DSModeled(DSC.SAFE)
    protected boolean setFrame(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean changed;
        changed = false;
        {
            Log.d("View", this + " View.setFrame(" + left + "," + top + ","
                    + right + "," + bottom + ")");
        } //End block
        {
            changed = true;
            int drawn;
            drawn = mPrivateFlags & DRAWN;
            int oldWidth;
            oldWidth = mRight - mLeft;
            int oldHeight;
            oldHeight = mBottom - mTop;
            int newWidth;
            newWidth = right - left;
            int newHeight;
            newHeight = bottom - top;
            boolean sizeChanged;
            sizeChanged = (newWidth != oldWidth) || (newHeight != oldHeight);
            invalidate(sizeChanged);
            mPrivateFlags |= HAS_BOUNDS;
            {
                {
                    {
                        mTransformationInfo.mMatrixDirty = true;
                    } //End block
                } //End block
                onSizeChanged(newWidth, newHeight, oldWidth, oldHeight);
            } //End block
            {
                mPrivateFlags |= DRAWN;
                invalidate(sizeChanged);
                invalidateParentCaches();
            } //End block
            mPrivateFlags |= drawn;
            mBackgroundSizeChanged = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.008 -0400", hash_original_method = "BECA18BF96D1F48EBBDC02908C938AE4", hash_generated_method = "2D38EA59E29D6096BFF169EAC6A1265A")
    @DSModeled(DSC.SAFE)
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "BFF455DC997197BE3540FCE6012E70CA")
    @DSModeled(DSC.SAFE)
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "1B5315B2A2E6007B07F436EFC340A168", hash_generated_method = "5E16DC16686FDFAA7E0BFB85E3A5BECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_2012184926 = (verifyDrawable(drawable));
            {
                final Rect dirty;
                dirty = drawable.getBounds();
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
                scrollY = mScrollY;
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (verifyDrawable(drawable)) {
            //final Rect dirty = drawable.getBounds();
            //final int scrollX = mScrollX;
            //final int scrollY = mScrollY;
            //invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    //dirty.right + scrollX, dirty.bottom + scrollY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "8ECDB7E126F9B8C9FE155246E2EA10DA", hash_generated_method = "5C43E88AACF79BAFC3728C7FD185D65C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_1510321568 = (verifyDrawable(who) && what != null);
            {
                {
                    mAttachInfo.mHandler.postAtTime(what, who, when);
                } //End block
                {
                    ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (verifyDrawable(who) && what != null) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mHandler.postAtTime(what, who, when);
            //} else {
                //ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "20282D900D1527E5779752DD2D1E3601", hash_generated_method = "BA9C52D86DD95AD812EB6031E17446C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_804270146 = (verifyDrawable(who) && what != null);
            {
                {
                    mAttachInfo.mHandler.removeCallbacks(what, who);
                } //End block
                {
                    ViewRootImpl.getRunQueue().removeCallbacks(what);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (verifyDrawable(who) && what != null) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mHandler.removeCallbacks(what, who);
            //} else {
                //ViewRootImpl.getRunQueue().removeCallbacks(what);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "5631E9137ED00BCDF82AA1F70C739531", hash_generated_method = "AB985D2660F728EA8C25F2CF7B858C53")
    @DSModeled(DSC.SAFE)
    public void unscheduleDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "AE0F8179B8268398E41F65FF0C6F4434", hash_generated_method = "8F4BFA80FCDA98E819E3752F84023EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getResolvedLayoutDirection(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1878087214 = (getResolvedLayoutDirection());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "4F9A094C3230B8AB80716D2738225FBB", hash_generated_method = "FDD69D4649030584E990F6825DA535B5")
    @DSModeled(DSC.SAFE)
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return who == mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "73C0FB6C39E14C0EF8F5708E9524F27F", hash_generated_method = "9EA667DE54BB3627318C7B4D7F88D887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void drawableStateChanged() {
        Drawable d;
        d = mBGDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_329856669 = (d != null && d.isStateful());
            {
                d.setState(getDrawableState());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Drawable d = mBGDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.009 -0400", hash_original_method = "3D0ECB50F3069F68F8A036B0BBF9CAA8", hash_generated_method = "9A33CB968B0F53A4075138CE3F7D47C5")
    @DSModeled(DSC.SAFE)
    public void refreshDrawableState() {
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        drawableStateChanged();
        ViewParent parent;
        parent = mParent;
        {
            parent.childDrawableStateChanged(this);
        } //End block
        // ---------- Original Method ----------
        //mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        //drawableStateChanged();
        //ViewParent parent = mParent;
        //if (parent != null) {
            //parent.childDrawableStateChanged(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.010 -0400", hash_original_method = "7B628D8EF95C580B0BB9FD927C61FF3F", hash_generated_method = "5974D7510C065CB7173703A7F5A6B7BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] getDrawableState() {
        {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if ((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0)) {
            //return mDrawableState;
        //} else {
            //mDrawableState = onCreateDrawableState(0);
            //mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            //return mDrawableState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.010 -0400", hash_original_method = "65DFC58C78CED9A3B9AF9F7EEF9C3470", hash_generated_method = "EADAFF741F549137E7DECACEF343C479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varCE673B688BFA7856C9D2543AAE971FB2_1078781441 = (((View) mParent).onCreateDrawableState(extraSpace));
        } //End block
        int[] drawableState;
        int privateFlags;
        privateFlags = mPrivateFlags;
        int viewStateIndex;
        viewStateIndex = 0;
        viewStateIndex |= VIEW_STATE_PRESSED;
        viewStateIndex |= VIEW_STATE_ENABLED;
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1667056590 = (isFocused());
            viewStateIndex |= VIEW_STATE_FOCUSED;
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_SELECTED;
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_1187473373 = (hasWindowFocus());
            viewStateIndex |= VIEW_STATE_WINDOW_FOCUSED;
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_ACTIVATED;
        {
            boolean varFEAE3CEA2D5FFAE7121F7CB82052FEED_927080043 = (mAttachInfo != null && mAttachInfo.mHardwareAccelerationRequested &&
                HardwareRenderer.isAvailable());
            {
                viewStateIndex |= VIEW_STATE_ACCELERATED;
            } //End block
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_HOVERED;
        final int privateFlags2;
        privateFlags2 = mPrivateFlags2;
        viewStateIndex |= VIEW_STATE_DRAG_CAN_ACCEPT;
        viewStateIndex |= VIEW_STATE_DRAG_HOVERED;
        drawableState = VIEW_STATE_SETS[viewStateIndex];
        final int[] fullState;
        {
            fullState = new int[drawableState.length + extraSpace];
            System.arraycopy(drawableState, 0, fullState, 0, drawableState.length);
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.010 -0400", hash_original_method = "4661E77FB0E261F3EAD8CD32725FC0A9", hash_generated_method = "ADF19DD4C8D12F70CD9FABC658344E3A")
    protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState) {
        final int N = baseState.length;
        int i = N - 1;
        while (i >= 0 && baseState[i] == 0) {
            i--;
        }
        System.arraycopy(additionalState, 0, baseState, i + 1, additionalState.length);
        return baseState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.010 -0400", hash_original_method = "9FD34CE508D1EA4936B2EE985D9CB024", hash_generated_method = "37C9A85BEBEF13F10061ED7337144837")
    @DSModeled(DSC.SAFE)
    public void jumpDrawablesToCurrentState() {
        {
            mBGDrawable.jumpToCurrentState();
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable != null) {
            //mBGDrawable.jumpToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.010 -0400", hash_original_method = "0F7EB0FE33D439CD82034214A1B516F3", hash_generated_method = "F1C0FB2F8CE610EA552E71D563D3C618")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public void setBackgroundColor(int color) {
        dsTaint.addTaint(color);
        {
            ((ColorDrawable) mBGDrawable).setColor(color);
        } //End block
        {
            setBackgroundDrawable(new ColorDrawable(color));
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable instanceof ColorDrawable) {
            //((ColorDrawable) mBGDrawable).setColor(color);
        //} else {
            //setBackgroundDrawable(new ColorDrawable(color));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.011 -0400", hash_original_method = "009D5DD04F6FB534689B81D1D35D5DCC", hash_generated_method = "90510C1BE45C1CDD90B66869FB8E3F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setBackgroundResource(int resid) {
        dsTaint.addTaint(resid);
        Drawable d;
        d = null;
        {
            d = mResources.getDrawable(resid);
        } //End block
        setBackgroundDrawable(d);
        // ---------- Original Method ----------
        //if (resid != 0 && resid == mBackgroundResource) {
            //return;
        //}
        //Drawable d= null;
        //if (resid != 0) {
            //d = mResources.getDrawable(resid);
        //}
        //setBackgroundDrawable(d);
        //mBackgroundResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.011 -0400", hash_original_method = "925AEEB36C7C1277949151BD876A29D4", hash_generated_method = "F8D514C28085F9C3DF48881B4AF66C3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        boolean requestLayout;
        requestLayout = false;
        mBackgroundResource = 0;
        {
            mBGDrawable.setCallback(null);
            unscheduleDrawable(mBGDrawable);
        } //End block
        {
            Rect padding;
            padding = sThreadLocal.get();
            {
                padding = new Rect();
                sThreadLocal.set(padding);
            } //End block
            {
                boolean var77F8DEC95ED142E00E9340D4E6309A49_556519748 = (d.getPadding(padding));
                {
                    {
                        Object var539EB19FF2B3A749E138242972103033_301825687 = (d.getResolvedLayoutDirectionSelf());
                        //Begin case LAYOUT_DIRECTION_RTL 
                        setPadding(padding.right, padding.top, padding.left, padding.bottom);
                        //End case LAYOUT_DIRECTION_RTL 
                        //Begin case LAYOUT_DIRECTION_LTR default 
                        setPadding(padding.left, padding.top, padding.right, padding.bottom);
                        //End case LAYOUT_DIRECTION_LTR default 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD26CE81CD77ABD9AB1A61C65E203B0B1_623037788 = (mBGDrawable == null || mBGDrawable.getMinimumHeight() != d.getMinimumHeight() ||
                    mBGDrawable.getMinimumWidth() != d.getMinimumWidth());
                {
                    requestLayout = true;
                } //End block
            } //End collapsed parenthetic
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_1577555084 = (d.isStateful());
                {
                    d.setState(getDrawableState());
                } //End block
            } //End collapsed parenthetic
            d.setVisible(getVisibility() == VISIBLE, false);
            {
                mPrivateFlags &= ~SKIP_DRAW;
                mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                requestLayout = true;
            } //End block
        } //End block
        {
            mBGDrawable = null;
            {
                mPrivateFlags &= ~ONLY_DRAWS_BACKGROUND;
                mPrivateFlags |= SKIP_DRAW;
            } //End block
            requestLayout = true;
        } //End block
        computeOpaqueFlags();
        {
            requestLayout();
        } //End block
        mBackgroundSizeChanged = true;
        invalidate(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.011 -0400", hash_original_method = "80971671F36DCDE8D8060A8575F1E0DF", hash_generated_method = "936DDB36FEE3A4DA91B4D6FA0AD7B12B")
    @DSModeled(DSC.SAFE)
    public Drawable getBackground() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "518320784120938CAC15B0472A139DBB", hash_generated_method = "2C965FE9C5A9F94744916EC2DC302018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean changed;
        changed = false;
        mUserPaddingRelative = false;
        final int viewFlags;
        viewFlags = mViewFlags;
        {
            {
                final int offset;
      
                offset = getVerticalScrollbarWidth();
                //Begin case SCROLLBAR_POSITION_DEFAULT 
                {
                    boolean varDD88345AFC6B206805F2994C7FB7F6F7_1987834162 = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
                    {
                        left += offset;
                    } //End block
                    {
                        right += offset;
                    } //End block
                } //End collapsed parenthetic
                //End case SCROLLBAR_POSITION_DEFAULT 
                //Begin case SCROLLBAR_POSITION_RIGHT 
                right += offset;
                //End case SCROLLBAR_POSITION_RIGHT 
                //Begin case SCROLLBAR_POSITION_LEFT 
                left += offset;
                //End case SCROLLBAR_POSITION_LEFT 
            } //End block
            {
                bottom += (viewFlags & SCROLLBARS_INSET_MASK) == 0
                        ? 0 : getHorizontalScrollbarHeight();
            } //End block
        } //End block
        {
            changed = true;
        } //End block
        {
            changed = true;
        } //End block
        {
            changed = true;
        } //End block
        {
            changed = true;
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "F50D0F04B3AF13DC9F9192544EA8BA6E", hash_generated_method = "FD0BC0508FE2FAE520353221F8263827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        mUserPaddingRelative = true;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_723609298 = (getResolvedLayoutDirection());
            //Begin case LAYOUT_DIRECTION_RTL 
            setPadding(end, top, start, bottom);
            //End case LAYOUT_DIRECTION_RTL 
            //Begin case LAYOUT_DIRECTION_LTR default 
            setPadding(start, top, end, bottom);
            //End case LAYOUT_DIRECTION_LTR default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mUserPaddingRelative = true;
        //mUserPaddingStart = start;
        //mUserPaddingEnd = end;
        //switch(getResolvedLayoutDirection()) {
            //case LAYOUT_DIRECTION_RTL:
                //setPadding(end, top, start, bottom);
                //break;
            //case LAYOUT_DIRECTION_LTR:
            //default:
                //setPadding(start, top, end, bottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "71BE64DF9CA1E548604AD18ADE3DFBDD", hash_generated_method = "174969FBC6B127DA704438DC3E5B2551")
    @DSModeled(DSC.SAFE)
    public int getPaddingTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "472EE1BBE725DA831283E7FA94BE4536", hash_generated_method = "85B53992F7936C1FB56E6E85A2472E8B")
    @DSModeled(DSC.SAFE)
    public int getPaddingBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "F854F7F8F07B4C3AC7B7FE5B9B528BAE", hash_generated_method = "710562363B4EA6FB96CCFE75C979E2A2")
    @DSModeled(DSC.SAFE)
    public int getPaddingLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "78A5E196850432C8DD415DC0673D2C8F", hash_generated_method = "35E27AD2E2C087E86386C58746C070D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPaddingStart() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_826121846 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingRight : mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "6AC4AEB4D1AD621C23B7EB8B08E4182E", hash_generated_method = "563692867A811B14FF80635F4ED8A13F")
    @DSModeled(DSC.SAFE)
    public int getPaddingRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.012 -0400", hash_original_method = "EE58EF7C85312E1C063201AE8CA23F8D", hash_generated_method = "AFFBF7B0D94701EDDB73B7E9BD3275D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPaddingEnd() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_262950354 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingLeft : mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "84D71EDE4F7EF14E19771B4AB735B283", hash_generated_method = "CE5D1276226D94F6350E0CB64983C3A7")
    @DSModeled(DSC.SAFE)
    public boolean isPaddingRelative() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUserPaddingRelative;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "91676949986DAC4CFDCFD2A3FAD3A69B", hash_generated_method = "EF126A1B28D16FB907C32C466224929A")
    @DSModeled(DSC.SAFE)
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        {
            mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(selected);
        } //End block
        // ---------- Original Method ----------
        //if (((mPrivateFlags & SELECTED) != 0) != selected) {
            //mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            //if (!selected) resetPressedState();
            //invalidate(true);
            //refreshDrawableState();
            //dispatchSetSelected(selected);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "5BDB7F696AF7A22765F6FA6F6EF17DE0")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetSelected(boolean selected) {
        dsTaint.addTaint(selected);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "48002052E4D321A2B2BAD55BEF8E0A66", hash_generated_method = "96383FBE9048F5F9C9D81F2E54731187")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & SELECTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "449C65D8ABD541EEF5AF1DFBC99BE952", hash_generated_method = "7D158AD06A01DD13831D2D0A3ABC56EE")
    @DSModeled(DSC.SAFE)
    public void setActivated(boolean activated) {
        dsTaint.addTaint(activated);
        {
            mPrivateFlags = (mPrivateFlags & ~ACTIVATED) | (activated ? ACTIVATED : 0);
            invalidate(true);
            refreshDrawableState();
            dispatchSetActivated(activated);
        } //End block
        // ---------- Original Method ----------
        //if (((mPrivateFlags & ACTIVATED) != 0) != activated) {
            //mPrivateFlags = (mPrivateFlags & ~ACTIVATED) | (activated ? ACTIVATED : 0);
            //invalidate(true);
            //refreshDrawableState();
            //dispatchSetActivated(activated);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "857B49EDB2F7375261DD6F1ED2F34094", hash_generated_method = "A0FF88612BB32A8B23D46B1D0F00E051")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetActivated(boolean activated) {
        dsTaint.addTaint(activated);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "807E5BA633430E7244B8D5311A7423DE", hash_generated_method = "B5033EF16B1E7AF54397B8FD88260E47")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isActivated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & ACTIVATED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "99F6A92222C13DFFEF0BA3B363A5F1C1", hash_generated_method = "D66721273DCAF0179419B69C00EBDFF8")
    @DSModeled(DSC.SAFE)
    public ViewTreeObserver getViewTreeObserver() {
        {
            mFloatingTreeObserver = new ViewTreeObserver();
        } //End block
        return (ViewTreeObserver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mTreeObserver;
        //}
        //if (mFloatingTreeObserver == null) {
            //mFloatingTreeObserver = new ViewTreeObserver();
        //}
        //return mFloatingTreeObserver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "399BB6B1CB98987E45F7FD1BEC4104A8", hash_generated_method = "B7EA53ABB0CCC107D06B967E46AD889A")
    @DSModeled(DSC.SAFE)
    public View getRootView() {
        {
            final View v;
            v = mAttachInfo.mRootView;
        } //End block
        View parent;
        parent = this;
        {
            parent = (View) parent.mParent;
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //final View v = mAttachInfo.mRootView;
            //if (v != null) {
                //return v;
            //}
        //}
        //View parent = this;
        //while (parent.mParent != null && parent.mParent instanceof View) {
            //parent = (View) parent.mParent;
        //}
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.013 -0400", hash_original_method = "6E1F3A14CB89D70C54E776D2215F970D", hash_generated_method = "9DEFB66608F5A0C6D882520EC78A2FB5")
    @DSModeled(DSC.SAFE)
    public void getLocationOnScreen(int[] location) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(location);
        getLocationInWindow(location);
        final AttachInfo info;
        info = mAttachInfo;
        {
            location[0] += info.mWindowLeft;
            location[1] += info.mWindowTop;
        } //End block
        // ---------- Original Method ----------
        //getLocationInWindow(location);
        //final AttachInfo info = mAttachInfo;
        //if (info != null) {
            //location[0] += info.mWindowLeft;
            //location[1] += info.mWindowTop;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "D5745CE4077A3F8C966A99FAE28757B4", hash_generated_method = "A427CA74EA64F92D04F8CB09E07C776F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getLocationInWindow(int[] location) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(location);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("location must be an array of two integers");
        } //End block
        float[] position;
        position = mAttachInfo.mTmpTransformLocation;
        position[0] = position[1] = 0.0f;
        {
            boolean var72C5EB038B47497B7FA123412E9ED288_190554303 = (!hasIdentityMatrix());
            {
                getMatrix().mapPoints(position);
            } //End block
        } //End collapsed parenthetic
        position[0] += mLeft;
        position[1] += mTop;
        ViewParent viewParent;
        viewParent = mParent;
        {
            final View view;
            view = (View) viewParent;
            position[0] -= view.mScrollX;
            position[1] -= view.mScrollY;
            {
                boolean varA98FC0C227FABB5530C6DB9897E9E044_252629185 = (!view.hasIdentityMatrix());
                {
                    view.getMatrix().mapPoints(position);
                } //End block
            } //End collapsed parenthetic
            position[0] += view.mLeft;
            position[1] += view.mTop;
            viewParent = view.mParent;
        } //End block
        {
            final ViewRootImpl vr;
            vr = (ViewRootImpl) viewParent;
            position[1] -= vr.mCurScrollY;
        } //End block
        location[0] = (int) (position[0] + 0.5f);
        location[1] = (int) (position[1] + 0.5f);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "0641E50E124E0C6CE4C02F73E2175BDE", hash_generated_method = "05D62C3BB2FE6D6657FF312159EFA9A4")
    @DSModeled(DSC.SAFE)
    protected View findViewTraversal(int id) {
        dsTaint.addTaint(id);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (id == mID) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "B50CD4B4D228C210BD89E9DF598807C7", hash_generated_method = "E463B096AF0F523EC1D3A35FACB6BABA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View findViewWithTagTraversal(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_1499920501 = (tag != null && tag.equals(mTag));
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag != null && tag.equals(mTag)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "65DA32C16954A521B825F7D31B571CEF", hash_generated_method = "DDC70C134FFC208D0C197EFCF1776202")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        dsTaint.addTaint(childToSkip.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_1527080488 = (predicate.apply(this));
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (predicate.apply(this)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "C8E06C0ED5E3D035BF7CE8B77FB6FB02", hash_generated_method = "D59F69EA25EC0C762B71651DDFC6B8CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewById(int id) {
        dsTaint.addTaint(id);
        View var4AA29BCB5B142A204BD7DB16E419C652_1410684011 = (findViewTraversal(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (id < 0) {
            //return null;
        //}
        //return findViewTraversal(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "DAB2723BE4C5F25FDBDAA56D4A941A95", hash_generated_method = "E555A89A7D3BDE54EB68C2712D57772F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final View findViewByAccessibilityId(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        View var241B8B20A533D780A251CFCAA213F5CB_1239038124 = (findViewByAccessibilityIdTraversal(accessibilityId));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (accessibilityId < 0) {
            //return null;
        //}
        //return findViewByAccessibilityIdTraversal(accessibilityId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "0033D4DC027C6D84BC9CA79DB06FA7C7", hash_generated_method = "9234580FC721FF39C8915A30CA9FBD52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        {
            boolean varA0F894C9F7ECB9E8C9290E6F95BA5394_423991194 = (getAccessibilityViewId() == accessibilityId);
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getAccessibilityViewId() == accessibilityId) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "DB0D3478EC5FC406F90807706EB086DC", hash_generated_method = "E2D1C8DEF08E496E60CC733394BA32FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewWithTag(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        View varF6D3742523D93D79D78F9560B7ADBE9B_834473091 = (findViewWithTagTraversal(tag));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag == null) {
            //return null;
        //}
        //return findViewWithTagTraversal(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.014 -0400", hash_original_method = "1599799F36C9F7803A0B97DCCA829DED", hash_generated_method = "3125E0EA2CFF66AA4AD1B663F99F0C7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewByPredicate(Predicate<View> predicate) {
        dsTaint.addTaint(predicate.dsTaint);
        View varAED79EFE897269532E5B1F9D1682DD74_1567621910 = (findViewByPredicateTraversal(predicate, null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findViewByPredicateTraversal(predicate, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "485BA369E24687F2D5FF0693ABF816B2", hash_generated_method = "0E2A1989E5074DD32B6103F3AC9DF42E")
    @DSModeled(DSC.SAFE)
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        View childToSkip;
        childToSkip = null;
        {
            View view;
            view = start.findViewByPredicateTraversal(predicate, childToSkip);
            ViewParent parent;
            parent = start.getParent();
            childToSkip = start;
            start = (View) parent;
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View childToSkip = null;
        //for (;;) {
            //View view = start.findViewByPredicateTraversal(predicate, childToSkip);
            //if (view != null || start == this) {
                //return view;
            //}
            //ViewParent parent = start.getParent();
            //if (parent == null || !(parent instanceof View)) {
                //return null;
            //}
            //childToSkip = start;
            //start = (View) parent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "125195EB8F3EB02BBD72A4003F2E03BD", hash_generated_method = "1C7A63D467C649DF1F50F114B0E3D9D3")
    @DSModeled(DSC.SAFE)
    public void setId(int id) {
        dsTaint.addTaint(id);
        // ---------- Original Method ----------
        //mID = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "B06467135FDA3C6D538127B3AC355349", hash_generated_method = "F4FA28E013D02E3F11D0E9825CF43EBB")
    @DSModeled(DSC.SAFE)
    public void setIsRootNamespace(boolean isRoot) {
        dsTaint.addTaint(isRoot);
        {
            mPrivateFlags |= IS_ROOT_NAMESPACE;
        } //End block
        {
            mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        } //End block
        // ---------- Original Method ----------
        //if (isRoot) {
            //mPrivateFlags |= IS_ROOT_NAMESPACE;
        //} else {
            //mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "74A41C2D2B744E005149431B820C27E4", hash_generated_method = "052E5E89919D3A0BE7C2125ED00B0FD6")
    @DSModeled(DSC.SAFE)
    public boolean isRootNamespace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags&IS_ROOT_NAMESPACE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "B0378653037A8E20BF93620A5E0AA660", hash_generated_method = "14AB6AE0B4A6578B28447BA68B362F16")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "6DFDAF67782EFC1BD440431DF6298ECD")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public Object getTag() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "8D2B18A079B1EE90519A06D435C647B9", hash_generated_method = "78ADF2FD74B9BBE676A31CA5EDA664D4")
    @DSModeled(DSC.SAFE)
    public void setTag(final Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "8295DF3154C0458AF2AF3A51D79A598B", hash_generated_method = "186B4716E16B689CC6F3F1A199AD3B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getTag(int key) {
        dsTaint.addTaint(key);
        Object var0005D9494E73BC27C16F24DA493053C0_1573870687 = (mKeyedTags.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mKeyedTags != null) return mKeyedTags.get(key);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "C739488AB1D92CB0D6B67C6D73AEF4DA", hash_generated_method = "1564F7E4A63ACC12035EA26ADE042327")
    @DSModeled(DSC.SAFE)
    public void setTag(int key, final Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The key must be an application-specific "
                    + "resource id.");
        } //End block
        setKeyedTag(key, tag);
        // ---------- Original Method ----------
        //if ((key >>> 24) < 2) {
            //throw new IllegalArgumentException("The key must be an application-specific "
                    //+ "resource id.");
        //}
        //setKeyedTag(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.015 -0400", hash_original_method = "5A92838330F5A71B83A0155FDDE52450", hash_generated_method = "D0DD14A690C84875B588B04567E16793")
    @DSModeled(DSC.SAFE)
    public void setTagInternal(int key, Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The key must be a framework-specific "
                    + "resource id.");
        } //End block
        setKeyedTag(key, tag);
        // ---------- Original Method ----------
        //if ((key >>> 24) != 0x1) {
            //throw new IllegalArgumentException("The key must be a framework-specific "
                    //+ "resource id.");
        //}
        //setKeyedTag(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.016 -0400", hash_original_method = "0255761BE2D8372B1493AF7283C8F5B5", hash_generated_method = "E5B820C9A6293640A1C0C1F971090003")
    @DSModeled(DSC.SAFE)
    private void setKeyedTag(int key, Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        dsTaint.addTaint(key);
        {
            mKeyedTags = new SparseArray<Object>();
        } //End block
        mKeyedTags.put(key, tag);
        // ---------- Original Method ----------
        //if (mKeyedTags == null) {
            //mKeyedTags = new SparseArray<Object>();
        //}
        //mKeyedTags.put(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.016 -0400", hash_original_method = "C5EE38E619F11A07C2A1169818F1E749", hash_generated_method = "BAA46597C3D1A7BB6834B48A50D34921")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean dispatchConsistencyCheck(int consistency) {
        dsTaint.addTaint(consistency);
        boolean var696CB6BB2A7239589CBDDD711F9F9275_547797499 = (onConsistencyCheck(consistency));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onConsistencyCheck(consistency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.016 -0400", hash_original_method = "2064C42F46AA0108673BA11B037AF3A0", hash_generated_method = "817C347E6E230BF615480BF198DE1D6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consistency);
        boolean result;
        result = true;
        final boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing;
        checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            {
                boolean varDE1E2D0AA459DE6E8FAB425D9EAC441E_1283628684 = (getParent() == null);
                {
                    result = false;
                    android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " does not have a parent.");
                } //End block
            } //End collapsed parenthetic
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " is not attached to a window.");
            } //End block
        } //End block
        {
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " was invalidated but its drawing cache is valid.");
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.016 -0400", hash_original_method = "6F90E3DC82B178E80E1C9DDC98738197", hash_generated_method = "443C869BF89D747EC39187DC710AD534")
    @DSModeled(DSC.SAFE)
    public void debug() {
        debug(0);
        // ---------- Original Method ----------
        //debug(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.016 -0400", hash_original_method = "3D5CB916992FEDBE62B11876DD1CF29A", hash_generated_method = "634E33BB29C91C46FA5EFF04643F8098")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void debug(int depth) {
        dsTaint.addTaint(depth);
        String output;
        output = debugIndent(depth - 1);
        output += "+ " + this;
        int id;
        id = getId();
        {
            output += " (id=" + id + ")";
        } //End block
        Object tag;
        tag = getTag();
        {
            output += " (tag=" + tag + ")";
        } //End block
        Log.d(VIEW_LOG_TAG, output);
        {
            output = debugIndent(depth) + " FOCUSED";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        Log.d(VIEW_LOG_TAG, output);
        {
            output = debugIndent(depth);
            output += "padding={" + mPaddingLeft + ", " + mPaddingTop
                    + ", " + mPaddingRight + ", " + mPaddingBottom + "}";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        output = debugIndent(depth);
        output += "mMeasureWidth=" + mMeasuredWidth +
                " mMeasureHeight=" + mMeasuredHeight;
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        {
            output += "BAD! no layout params";
        } //End block
        {
            output = mLayoutParams.debug(output);
        } //End block
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        output += "flags={";
        output += View.printFlags(mViewFlags);
        output += "}";
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        output += "privateFlags={";
        output += View.printPrivateFlags(mPrivateFlags);
        output += "}";
        Log.d(VIEW_LOG_TAG, output);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "121BCDA314867760857B84FB1F7590A5", hash_generated_method = "6DAEA40F9EFC308FBA9573BDE4600328")
    protected static String debugIndent(int depth) {
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "04C72C8D15A6DF3440AFF547FAD30ABA", hash_generated_method = "95744175C9F59EF9D766C8088E4C994C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "B7CE3104FF9ED0677BFFACD05F948960", hash_generated_method = "F370A7D6FBF53DC0A988024140A52D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLayout() {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        } //End block
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        {
            {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            } //End block
            {
                boolean var3A2DB0BB7B6E5FB8768388F8E364ED16_2037354489 = (!mParent.isLayoutRequested());
                {
                    mParent.requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (ViewDebug.TRACE_HIERARCHY) {
            //ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        //}
        //mPrivateFlags |= FORCE_LAYOUT;
        //mPrivateFlags |= INVALIDATED;
        //if (mParent != null) {
            //if (mLayoutParams != null) {
                //mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            //}
            //if (!mParent.isLayoutRequested()) {
                //mParent.requestLayout();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "5F70867C98C203969EB162B4B724A790", hash_generated_method = "A3F55EDA961F82BA3F2BB365DAABD0BC")
    @DSModeled(DSC.SAFE)
    public void forceLayout() {
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        // ---------- Original Method ----------
        //mPrivateFlags |= FORCE_LAYOUT;
        //mPrivateFlags |= INVALIDATED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "26BA2349651C8679968382F6A84D9E92", hash_generated_method = "ECDD3FDF6175B06A99E70BB627BB7810")
    @DSModeled(DSC.SAFE)
    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        {
            mPrivateFlags &= ~MEASURED_DIMENSION_SET;
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_MEASURE);
            } //End block
            onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("onMeasure() did not set the"
                        + " measured dimension by calling"
                        + " setMeasuredDimension()");
            } //End block
            mPrivateFlags |= LAYOUT_REQUIRED;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "2024EA7D99B2D61F149E7A5A9BB7EB8E", hash_generated_method = "FFFEAF7CCA32DAA238C47FB2DB754888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        // ---------- Original Method ----------
        //setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                //getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.017 -0400", hash_original_method = "5AB327430FB1DFBD1DD895A1A32A2AA8", hash_generated_method = "684159CFC2155BDD53D1C5394B985908")
    @DSModeled(DSC.SAFE)
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight) {
        dsTaint.addTaint(measuredWidth);
        dsTaint.addTaint(measuredHeight);
        mPrivateFlags |= MEASURED_DIMENSION_SET;
        // ---------- Original Method ----------
        //mMeasuredWidth = measuredWidth;
        //mMeasuredHeight = measuredHeight;
        //mPrivateFlags |= MEASURED_DIMENSION_SET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "4AED27C0F303F253C8F2C8C2F5E26F9A", hash_generated_method = "AFAB5318D2F026EC8B5D133813C97B2B")
    public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "6877719E070E35AD0BD8042942A9B389", hash_generated_method = "251579915A936EB16BABC6620A01AA20")
    public static int resolveSize(int size, int measureSpec) {
        return resolveSizeAndState(size, measureSpec, 0) & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "39A5CACF01FE0DFAB920772094BEEAAA", hash_generated_method = "1EFF5672B9E5A45DC1FDD74A33B96A08")
    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "A360CCCC9204426D264D18E0CB980F27", hash_generated_method = "5C93C0281D868B779AB5622D350E4EA9")
    public static int getDefaultSize(int size, int measureSpec) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "B59EA0BF10E69D3FFCA86CC30267F8DC", hash_generated_method = "CD2483D4F539BC24FE68C5D588B522F8")
    @DSModeled(DSC.SAFE)
    protected int getSuggestedMinimumHeight() {
        int suggestedMinHeight;
        suggestedMinHeight = mMinHeight;
        {
            final int bgMinHeight;
            bgMinHeight = mBGDrawable.getMinimumHeight();
            {
                suggestedMinHeight = bgMinHeight;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int suggestedMinHeight = mMinHeight;
        //if (mBGDrawable != null) {
            //final int bgMinHeight = mBGDrawable.getMinimumHeight();
            //if (suggestedMinHeight < bgMinHeight) {
                //suggestedMinHeight = bgMinHeight;
            //}
        //}
        //return suggestedMinHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "008B87CD2B3ED33B965CD69B13D61BFC", hash_generated_method = "A41D78AE4163825F6237D40A5FB50B63")
    @DSModeled(DSC.SAFE)
    protected int getSuggestedMinimumWidth() {
        int suggestedMinWidth;
        suggestedMinWidth = mMinWidth;
        {
            final int bgMinWidth;
            bgMinWidth = mBGDrawable.getMinimumWidth();
            {
                suggestedMinWidth = bgMinWidth;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int suggestedMinWidth = mMinWidth;
        //if (mBGDrawable != null) {
            //final int bgMinWidth = mBGDrawable.getMinimumWidth();
            //if (suggestedMinWidth < bgMinWidth) {
                //suggestedMinWidth = bgMinWidth;
            //}
        //}
        //return suggestedMinWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.018 -0400", hash_original_method = "879BFA5FA0241047CB6974ED67682297", hash_generated_method = "085AD219FDB1D2B91A443DE9D3144B0F")
    @DSModeled(DSC.SAFE)
    public void setMinimumHeight(int minHeight) {
        dsTaint.addTaint(minHeight);
        // ---------- Original Method ----------
        //mMinHeight = minHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "CE129FBEAB6CCA0889899FF1E8E78A67", hash_generated_method = "257F4D5ACCC95AA06B7A4FE1B907B879")
    @DSModeled(DSC.SAFE)
    public void setMinimumWidth(int minWidth) {
        dsTaint.addTaint(minWidth);
        // ---------- Original Method ----------
        //mMinWidth = minWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "CDBB00D26F9C60D5F3E6B97847853936", hash_generated_method = "A0A2B8EBCC818720E321C40BB850D81F")
    @DSModeled(DSC.SAFE)
    public Animation getAnimation() {
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCurrentAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "8B9244EE03042EB67F130AFDAD9A68F9", hash_generated_method = "7E172482770CAEF3F94B010706C4C372")
    @DSModeled(DSC.SAFE)
    public void startAnimation(Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
        // ---------- Original Method ----------
        //animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        //setAnimation(animation);
        //invalidateParentCaches();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "743A148D3AA9DA63FB0D1635C16263C7", hash_generated_method = "944990CE24F3DB6D3B82E91044E3A36D")
    @DSModeled(DSC.SAFE)
    public void clearAnimation() {
        {
            mCurrentAnimation.detach();
        } //End block
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
        // ---------- Original Method ----------
        //if (mCurrentAnimation != null) {
            //mCurrentAnimation.detach();
        //}
        //mCurrentAnimation = null;
        //invalidateParentIfNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "80992FCFACCF22F26EEB305124C3026E", hash_generated_method = "70BA617370B536D8F101BF09FDBFF784")
    @DSModeled(DSC.SAFE)
    public void setAnimation(Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        {
            animation.reset();
        } //End block
        // ---------- Original Method ----------
        //mCurrentAnimation = animation;
        //if (animation != null) {
            //animation.reset();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "AAD5AA561778224F71E3AF6921CD4105", hash_generated_method = "C3FFC08BA47E501DAAD1B109471BE8FE")
    @DSModeled(DSC.SAFE)
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags |= ANIMATION_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "F4AD81FC3499666E7AC93E3735AFEF8E", hash_generated_method = "AC7E7B39DA72C0252D799E6B20713917")
    @DSModeled(DSC.SAFE)
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags &= ~ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags &= ~ANIMATION_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "568006CAA6CB37149160F88CE4C1964A")
    @DSModeled(DSC.SAFE)
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(alpha);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.019 -0400", hash_original_method = "A01500863A3F6668743C7034A9645220", hash_generated_method = "8D29161DCBEA33CAA6F2737B86CC4D3A")
    @DSModeled(DSC.SAFE)
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        final AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            final int pflags;
            pflags = mPrivateFlags;
            {
                final int[] location;
                location = attachInfo.mTransparentLocation;
                getLocationInWindow(location);
                region.op(location[0], location[1], location[0] + mRight - mLeft,
                        location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            } //End block
            {
                applyDrawableToTransparentRegion(mBGDrawable, region);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final AttachInfo attachInfo = mAttachInfo;
        //if (region != null && attachInfo != null) {
            //final int pflags = mPrivateFlags;
            //if ((pflags & SKIP_DRAW) == 0) {
                //final int[] location = attachInfo.mTransparentLocation;
                //getLocationInWindow(location);
                //region.op(location[0], location[1], location[0] + mRight - mLeft,
                        //location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            //} else if ((pflags & ONLY_DRAWS_BACKGROUND) != 0 && mBGDrawable != null) {
                //applyDrawableToTransparentRegion(mBGDrawable, region);
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "92BFD91D600C047225F186391F6079B0", hash_generated_method = "34943DD8481330ABD4BBBDB066C8FEB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSoundEffect(int soundConstant) {
        dsTaint.addTaint(soundConstant);
        {
            boolean var1E4326663BC68D529F79DE6FC2643778_1295767119 = (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled());
        } //End collapsed parenthetic
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
        // ---------- Original Method ----------
        //if (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            //return;
        //}
        //mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "75954C55ABC6CE5681E22BCDE96F4903", hash_generated_method = "7C4B11C3598F3D2417C5D2E121BDC582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int feedbackConstant) {
        dsTaint.addTaint(feedbackConstant);
        boolean var47DA1E759FDC3E51245046642463FE5C_1213894064 = (performHapticFeedback(feedbackConstant, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return performHapticFeedback(feedbackConstant, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "A19669526C11317AB6CCDC764945F176", hash_generated_method = "CC0DC703FEC37AAFCA90599F9998A2BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(feedbackConstant);
        {
            boolean varA5539A907B715B189715B7DC683584E6_22480714 = ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled());
        } //End collapsed parenthetic
        boolean var504ECB78099BB3639952FEB46DA1CEC5_2066611140 = (mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                (flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAttachInfo == null) {
            //return false;
        //}
        //if ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                //&& !isHapticFeedbackEnabled()) {
            //return false;
        //}
        //return mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                //(flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "1F6436CCBBD24CDC20D09B9CE44A0912", hash_generated_method = "BE7D03BAB8DB974821988602AE726A2E")
    @DSModeled(DSC.SAFE)
    public void setSystemUiVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        {
            {
                mParent.recomputeViewAttributes(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visibility != mSystemUiVisibility) {
            //mSystemUiVisibility = visibility;
            //if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
                //mParent.recomputeViewAttributes(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "FA02CCE186B627C6CF56D55D5156174E", hash_generated_method = "3DD9CB3903A435BA92A9112B4AD9FE9C")
    @DSModeled(DSC.SAFE)
    public int getSystemUiVisibility() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSystemUiVisibility;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "1911D5DDAC8087DF02FDB915711E3D30", hash_generated_method = "CD91DA36580C2481817931F4F67A728C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        {
            mParent.recomputeViewAttributes(this);
        } //End block
        // ---------- Original Method ----------
        //getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        //if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            //mParent.recomputeViewAttributes(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "31A60EE50D18A3986849FF003231E28E", hash_generated_method = "33DA8E3CDC3A25F899DE21FD9B62FA62")
    @DSModeled(DSC.SAFE)
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        dsTaint.addTaint(visibility);
        ListenerInfo li;
        li = mListenerInfo;
        {
            li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        } //End block
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
            //li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    //visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.020 -0400", hash_original_method = "BE707BAA551F425B19E1E4FBE454F716", hash_generated_method = "88EDFA3F7039F2BB13E36211F8020AD9")
    @DSModeled(DSC.SAFE)
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        dsTaint.addTaint(localChanges);
        dsTaint.addTaint(localValue);
        int val;
        val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        {
            setSystemUiVisibility(val);
        } //End block
        // ---------- Original Method ----------
        //int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        //if (val != mSystemUiVisibility) {
            //setSystemUiVisibility(val);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.021 -0400", hash_original_method = "F914DF1AC479022C6AA4BFD6DD1247D7", hash_generated_method = "943AFAF785E7D931B4A638B9B6945E90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags) {
        dsTaint.addTaint(myLocalState.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(shadowBuilder.dsTaint);
        {
            Log.d(VIEW_LOG_TAG, "startDrag: data=" + data + " flags=" + flags);
        } //End block
        boolean okay;
        okay = false;
        Point shadowSize;
        shadowSize = new Point();
        Point shadowTouchPoint;
        shadowTouchPoint = new Point();
        shadowBuilder.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Drag shadow dimensions must not be negative");
        } //End block
        {
            Log.d(VIEW_LOG_TAG, "drag shadow: width=" + shadowSize.x + " height=" + shadowSize.y
                    + " shadowX=" + shadowTouchPoint.x + " shadowY=" + shadowTouchPoint.y);
        } //End block
        Surface surface;
        surface = new Surface();
        try 
        {
            IBinder token;
            token = mAttachInfo.mSession.prepareDrag(mAttachInfo.mWindow,
                    flags, shadowSize.x, shadowSize.y, surface);
            Log.d(VIEW_LOG_TAG, "prepareDrag returned token=" + token
                    + " surface=" + surface);
            {
                Canvas canvas;
                canvas = surface.lockCanvas(null);
                try 
                {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    shadowBuilder.onDrawShadow(canvas);
                } //End block
                finally 
                {
                    surface.unlockCanvasAndPost(canvas);
                } //End block
                final ViewRootImpl root;
                root = getViewRootImpl();
                root.setLocalDragState(myLocalState);
                root.getLastTouchPoint(shadowSize);
                okay = mAttachInfo.mSession.performDrag(mAttachInfo.mWindow, token,
                        shadowSize.x, shadowSize.y,
                        shadowTouchPoint.x, shadowTouchPoint.y, data);
                Log.d(VIEW_LOG_TAG, "performDrag returned " + okay);
                surface.release();
            } //End block
        } //End block
        catch (Exception e)
        {
            surface.destroy();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.021 -0400", hash_original_method = "7E645D896E88F7A2CE991A302B5729A7", hash_generated_method = "77318E7A41BD0A309340BC7E5E84F748")
    @DSModeled(DSC.SAFE)
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.021 -0400", hash_original_method = "2E7102A43746FEAE9D11C37FDA834A21", hash_generated_method = "FAEAABB9566DF592287E310C9FC4F95E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean var335DF3A408D4F144DA69CF42853FDB1A_1158762342 = (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event));
        } //End collapsed parenthetic
        boolean var0587795787D505B85471C0D6F567FE89_289773133 = (onDragEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnDragListener.onDrag(this, event)) {
            //return true;
        //}
        //return onDragEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.021 -0400", hash_original_method = "C990D75777DFB098F96F21BE433F897F", hash_generated_method = "C548A7F538DB260ECA84D930F4BE4657")
    @DSModeled(DSC.SAFE)
     boolean canAcceptDrag() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.021 -0400", hash_original_method = "059265693C3FBF9CA8D6100876A0DA7C", hash_generated_method = "3457145CB852C77DAEC13DCBF106319C")
    @DSModeled(DSC.SAFE)
    public void onCloseSystemDialogs(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "14C9DBE3395E98A8750BC15A93AD3A45", hash_generated_method = "A42CF81E190F60E1A8811738477E7350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyDrawableToTransparentRegion(Drawable dr, Region region) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(dr.dsTaint);
        final Region r;
        r = dr.getTransparentRegion();
        final Rect db;
        db = dr.getBounds();
        final AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            final int w;
            w = getRight()-getLeft();
            final int h;
            h = getBottom()-getTop();
            {
                r.op(0, 0, db.left, h, Region.Op.UNION);
            } //End block
            {
                r.op(db.right, 0, w, h, Region.Op.UNION);
            } //End block
            {
                r.op(0, 0, w, db.top, Region.Op.UNION);
            } //End block
            {
                r.op(0, db.bottom, w, h, Region.Op.UNION);
            } //End block
            final int[] location;
            location = attachInfo.mTransparentLocation;
            getLocationInWindow(location);
            r.translate(location[0], location[1]);
            region.op(r, Region.Op.INTERSECT);
        } //End block
        {
            region.op(db, Region.Op.DIFFERENCE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "3A330A3DE83C0EE0C70042D452F74FC4", hash_generated_method = "F794B3F947DC5D1C257458E5563235E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkForLongClick(int delayOffset) {
        dsTaint.addTaint(delayOffset);
        {
            mHasPerformedLongPress = false;
            {
                mPendingCheckForLongPress = new CheckForLongPress();
            } //End block
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress,
                    ViewConfiguration.getLongPressTimeout() - delayOffset);
        } //End block
        // ---------- Original Method ----------
        //if ((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) {
            //mHasPerformedLongPress = false;
            //if (mPendingCheckForLongPress == null) {
                //mPendingCheckForLongPress = new CheckForLongPress();
            //}
            //mPendingCheckForLongPress.rememberWindowAttachCount();
            //postDelayed(mPendingCheckForLongPress,
                    //ViewConfiguration.getLongPressTimeout() - delayOffset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "2D12FAA45E30CCFE27E1B111173CDBDE", hash_generated_method = "4B75A9057408AA2F23276D79E03E056B")
    public static View inflate(Context context, int resource, ViewGroup root) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "5E47C984391EE91860CD25320EB410A4", hash_generated_method = "AA838D4AC5273077B4D7C6D3DB14DDAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent) {
        dsTaint.addTaint(scrollRangeX);
        dsTaint.addTaint(maxOverScrollY);
        dsTaint.addTaint(scrollRangeY);
        dsTaint.addTaint(isTouchEvent);
        dsTaint.addTaint(maxOverScrollX);
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(deltaY);
        dsTaint.addTaint(scrollX);
        final int overScrollMode;
        overScrollMode = mOverScrollMode;
        final boolean canScrollHorizontal;
        canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        final boolean canScrollVertical;
        canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        final boolean overScrollHorizontal;
        overScrollHorizontal = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollHorizontal);
        final boolean overScrollVertical;
        overScrollVertical = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollVertical);
        int newScrollX;
        newScrollX = scrollX + deltaX;
        {
            maxOverScrollX = 0;
        } //End block
        int newScrollY;
        newScrollY = scrollY + deltaY;
        {
            maxOverScrollY = 0;
        } //End block
        final int left;
        left = -maxOverScrollX;
        final int right;
        right = maxOverScrollX + scrollRangeX;
        final int top;
        top = -maxOverScrollY;
        final int bottom;
        bottom = maxOverScrollY + scrollRangeY;
        boolean clampedX;
        clampedX = false;
        {
            newScrollX = right;
            clampedX = true;
        } //End block
        {
            newScrollX = left;
            clampedX = true;
        } //End block
        boolean clampedY;
        clampedY = false;
        {
            newScrollY = bottom;
            clampedY = true;
        } //End block
        {
            newScrollY = top;
            clampedY = true;
        } //End block
        onOverScrolled(newScrollX, newScrollY, clampedX, clampedY);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "4CE95B84751ED417CECEABF7E9F1BBA1", hash_generated_method = "161E271F573AFE3261F78356B57E9F54")
    @DSModeled(DSC.SAFE)
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(scrollX);
        dsTaint.addTaint(clampedY);
        dsTaint.addTaint(clampedX);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "89CDC9D85B7569FFDF89FB6E096C8833", hash_generated_method = "DF0608BAE4A437B20F138A35DAFD4B27")
    @DSModeled(DSC.SAFE)
    public int getOverScrollMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.022 -0400", hash_original_method = "D7A7F397651806FFF8FA254EEF23303B", hash_generated_method = "4FC7FAD943EC0941241BD727FBCE4457")
    @DSModeled(DSC.SAFE)
    public void setOverScrollMode(int overScrollMode) {
        dsTaint.addTaint(overScrollMode);
        {
            throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        } //End block
        // ---------- Original Method ----------
        //if (overScrollMode != OVER_SCROLL_ALWAYS &&
                //overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                //overScrollMode != OVER_SCROLL_NEVER) {
            //throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        //}
        //mOverScrollMode = overScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "9CF1D38E8E376FF50D8C64A9F9733663", hash_generated_method = "3F95C764753FEFEBA681F3FCFDB85995")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getVerticalScrollFactor() {
        {
            TypedValue outValue;
            outValue = new TypedValue();
            {
                boolean var0AC7698B51F94BDA888C18D716FEABFB_1966914178 = (!mContext.getTheme().resolveAttribute(
                    com.android.internal.R.attr.listPreferredItemHeight, outValue, true));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Expected theme to define listPreferredItemHeight.");
                } //End block
            } //End collapsed parenthetic
            mVerticalScrollFactor = outValue.getDimension(
                    mContext.getResources().getDisplayMetrics());
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mVerticalScrollFactor == 0) {
            //TypedValue outValue = new TypedValue();
            //if (!mContext.getTheme().resolveAttribute(
                    //com.android.internal.R.attr.listPreferredItemHeight, outValue, true)) {
                //throw new IllegalStateException(
                        //"Expected theme to define listPreferredItemHeight.");
            //}
            //mVerticalScrollFactor = outValue.getDimension(
                    //mContext.getResources().getDisplayMetrics());
        //}
        //return mVerticalScrollFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "E54E00038FC64298D390BA41C98DC1D8", hash_generated_method = "51B779B9999664037D938C9B71C9D156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getHorizontalScrollFactor() {
        float varB4E039AD370F52FF248539199AD3C0AB_1269135418 = (getVerticalScrollFactor());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getVerticalScrollFactor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "66C84E939C2024746D4813377EE28DA8", hash_generated_method = "E87354DB7C217137DC293E6979EF6E5A")
    @DSModeled(DSC.SAFE)
    public int getTextDirection() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTextDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "A0414376D9ECFBC599F5D349FFC72987", hash_generated_method = "27D6F262789511F62F498879429BF7BF")
    @DSModeled(DSC.SAFE)
    public void setTextDirection(int textDirection) {
        dsTaint.addTaint(textDirection);
        {
            resetResolvedTextDirection();
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (textDirection != mTextDirection) {
            //mTextDirection = textDirection;
            //resetResolvedTextDirection();
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "99501F3EA14EF54863B388ACFA67B227", hash_generated_method = "377072C9A223C23C167F4BC94B9CAB0E")
    @DSModeled(DSC.SAFE)
    public int getResolvedTextDirection() {
        {
            resolveTextDirection();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mResolvedTextDirection == TEXT_DIRECTION_INHERIT) {
            //resolveTextDirection();
        //}
        //return mResolvedTextDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "DF8FC39519D36B1AC7371F6D87C199FC", hash_generated_method = "B928BE8C149238E124CDD00FA7058CF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void resolveTextDirection() {
        {
            mResolvedTextDirection = mTextDirection;
        } //End block
        {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
        } //End block
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
        // ---------- Original Method ----------
        //if (mTextDirection != TEXT_DIRECTION_INHERIT) {
            //mResolvedTextDirection = mTextDirection;
            //return;
        //}
        //if (mParent != null && mParent instanceof ViewGroup) {
            //mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            //return;
        //}
        //mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "BB79EF6AB24983F71C49AA466BBC15FC", hash_generated_method = "81A9BFA061AF7272D10CC595D2654F7B")
    @DSModeled(DSC.SAFE)
    protected void resetResolvedTextDirection() {
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
        // ---------- Original Method ----------
        //mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "AF21ED671E180E70DBE0B7255059F75E", hash_generated_method = "BD6224462EAA2B5F30C198F56388189D")
    @DSModeled(DSC.SAFE)
    public void hackTurnOffWindowResizeAnim(boolean off) {
        dsTaint.addTaint(off);
        mAttachInfo.mTurnOffWindowResizeAnim = off;
        // ---------- Original Method ----------
        //mAttachInfo.mTurnOffWindowResizeAnim = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.023 -0400", hash_original_method = "E195CA02B57C3CA07D3D00B98A2A4177", hash_generated_method = "FFFEC10683416EC4C5F00E3BB7671D94")
    @DSModeled(DSC.SAFE)
    public ViewPropertyAnimator animate() {
        {
            mAnimator = new ViewPropertyAnimator(this);
        } //End block
        return (ViewPropertyAnimator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAnimator == null) {
            //mAnimator = new ViewPropertyAnimator(this);
        //}
        //return mAnimator;
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
        
    }


    
    public static class DragShadowBuilder {
        private final WeakReference<View> mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "0B0DC4A9FB3A9C12A7904682E22ADAD8", hash_generated_method = "2E43C62DD20964205AE6FC984759541D")
        @DSModeled(DSC.SAFE)
        public DragShadowBuilder(View view) {
            dsTaint.addTaint(view.dsTaint);
            mView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "39157EB374747DFD28056DCE3D5D84EC", hash_generated_method = "E3630593D7B4E66869932E9397A6A2F9")
        @DSModeled(DSC.SAFE)
        public DragShadowBuilder() {
            mView = new WeakReference<View>(null);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "12EFA38B650211F3F0DA583E081C360F", hash_generated_method = "93F3F012243E9F371926E2E9A6B29020")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings({"JavadocReference"})
        final public View getView() {
            View varA6FA31E50E60277B6F29565A9C2288B3_650214535 = (mView.get());
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mView.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "7C575AFDC5B7223F530AD0DF57B52E75", hash_generated_method = "5C211B64DE73FD8F63A0C2932F73AB5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(shadowSize.dsTaint);
            dsTaint.addTaint(shadowTouchPoint.dsTaint);
            final View view;
            view = mView.get();
            {
                shadowSize.set(view.getWidth(), view.getHeight());
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            } //End block
            // ---------- Original Method ----------
            //final View view = mView.get();
            //if (view != null) {
                //shadowSize.set(view.getWidth(), view.getHeight());
                //shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            //} else {
                //Log.e(View.VIEW_LOG_TAG, "Asked for drag thumb metrics but no view");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "F5A2B90321F064D0A4C62262ED411079", hash_generated_method = "E1A6F8DD0A052D54A10456DFB4F6899A")
        @DSModeled(DSC.SAFE)
        public void onDrawShadow(Canvas canvas) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(canvas.dsTaint);
            final View view;
            view = mView.get();
            {
                view.draw(canvas);
            } //End block
            // ---------- Original Method ----------
            //final View view = mView.get();
            //if (view != null) {
                //view.draw(canvas);
            //} else {
                //Log.e(View.VIEW_LOG_TAG, "Asked to draw drag shadow but no view");
            //}
        }

        
    }


    
    public static class MeasureSpec {
        private static final int MODE_SHIFT = 30;
        private static final int MODE_MASK  = 0x3 << MODE_SHIFT;
        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
        public static final int EXACTLY     = 1 << MODE_SHIFT;
        public static final int AT_MOST     = 2 << MODE_SHIFT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "D4DD9EC0A4BB7A33CEC4D3BC428DF659", hash_generated_method = "841C049A18C561FA1AD7CF4F74A7C5B9")
        public static int makeMeasureSpec(int size, int mode) {
            return size + mode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "D8B2BF7ED13D8D2B1680FD29125A149E", hash_generated_method = "23A32DDDEB3F479A9F13C5E06A0D00F7")
        public static int getMode(int measureSpec) {
            return (measureSpec & MODE_MASK);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "76BD0632AD4F98584FC44D8BB28D8753", hash_generated_method = "AEDD691021E106AA9F1F825E5703E12D")
        public static int getSize(int measureSpec) {
            return (measureSpec & ~MODE_MASK);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "7B4431A87958DF8AA14AC1FB6CAF4E67", hash_generated_method = "1EDA928BC960C222A97A983A05C66127")
        public static String toString(int measureSpec) {
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

        
    }


    
    class CheckForLongPress implements Runnable {
        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "01CD5F3DDC5391038879A6F141003B2C", hash_generated_method = "9C801D54A30AC1FADD07E3C89BE9E974")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean varFB827A206CA2F483F96FD1D1A0A39D9F_308246950 = (isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount);
                {
                    {
                        boolean var9620ED46504D3117149539056E35032D_1320910206 = (performLongClick());
                        {
                            mHasPerformedLongPress = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isPressed() && (mParent != null)
                    //&& mOriginalWindowAttachCount == mWindowAttachCount) {
                //if (performLongClick()) {
                    //mHasPerformedLongPress = true;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "52714AB9B90C75C7141A8D07DDC0C4CA", hash_generated_method = "77D54F43F19AF0BE6982B2B38C66956C")
        @DSModeled(DSC.SAFE)
        public void rememberWindowAttachCount() {
            mOriginalWindowAttachCount = mWindowAttachCount;
            // ---------- Original Method ----------
            //mOriginalWindowAttachCount = mWindowAttachCount;
        }

        
    }


    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.024 -0400", hash_original_method = "8B4AC781B811E80364C995C3750D80D8", hash_generated_method = "3F62D1F08930F869264671836F4C7FF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            mPrivateFlags &= ~PREPRESSED;
            mPrivateFlags |= PRESSED;
            refreshDrawableState();
            checkForLongClick(ViewConfiguration.getTapTimeout());
            // ---------- Original Method ----------
            //mPrivateFlags &= ~PREPRESSED;
            //mPrivateFlags |= PRESSED;
            //refreshDrawableState();
            //checkForLongClick(ViewConfiguration.getTapTimeout());
        }

        
    }


    
    private final class PerformClick implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "566460B544C528A9D4CEF77A7D21BD20", hash_generated_method = "AC053BC106021FC0BB2E42F35D192C06")
        @DSModeled(DSC.SAFE)
        public void run() {
            performClick();
            // ---------- Original Method ----------
            //performClick();
        }

        
    }


    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "8ADFD7FB5655235FFF1C14FE5EF3EDC3", hash_generated_method = "08B631EFEED091423695B11D79427AF1")
        @DSModeled(DSC.SAFE)
        public void run() {
            setPressed(false);
            // ---------- Original Method ----------
            //setPressed(false);
        }

        
    }


    
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "35821D2EA4DFAF558F55A1E0F95556F9", hash_generated_method = "7D75F66BC30455FB35870FCC9CCA12A2")
            @DSModeled(DSC.SAFE)
            public BaseSavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (BaseSavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "6AB34CCCCE700DF19CB6D0E0E8A5F161", hash_generated_method = "2A85278F0E00494D21927DFE6D1DEE3F")
            @DSModeled(DSC.SAFE)
            public BaseSavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (BaseSavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "F5FA59E2DA20C073B259FE5D72E65085")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcel source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "42685FC1898A829EA8A0AC424464FB19")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
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
        static final int INVALIDATE_MSG = 0x1;
        static final int INVALIDATE_RECT_MSG = 0x2;
        final Rect mTmpInvalRect = new Rect();
        final RectF mTmpTransformRect = new RectF();
        final ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        int mAccessibilityWindowId = View.NO_ID;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "0CDE5ADA82BD9455683884E38A135C3D", hash_generated_method = "00EDFE97AAB11C19D738C6E83989943B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer) {
            dsTaint.addTaint(window.dsTaint);
            dsTaint.addTaint(effectPlayer.dsTaint);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mWindowToken = window.asBinder();
            mRootCallbacks = effectPlayer;
            mWindow = window;
            mSession = session;
            mHandler = handler;
            // ---------- Original Method ----------
            //mSession = session;
            //mWindow = window;
            //mWindowToken = window.asBinder();
            //mHandler = handler;
            //mRootCallbacks = effectPlayer;
        }

        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            private static final int POOL_LIMIT = 10;
            private static final Pool<InvalidateInfo> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<InvalidateInfo>() {
                        public InvalidateInfo newInstance() {
                            return new InvalidateInfo();
                        }

                        public void onAcquired(InvalidateInfo element) {
                        }

                        public void onReleased(InvalidateInfo element) {
                            element.target = null;
                        }
                    }, POOL_LIMIT)
            );
            private InvalidateInfo mNext;
            private boolean mIsPooled;
            View target;
            int left;
            int top;
            int right;
            int bottom;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "AAFC70DDA5FB82CEF5E58C1F01C303B7", hash_generated_method = "8BAA21FE59734AE7BD4A49DFFE6CDCFA")
            @DSModeled(DSC.SAFE)
            public void setNextPoolable(InvalidateInfo element) {
                dsTaint.addTaint(element.dsTaint);
                // ---------- Original Method ----------
                //mNext = element;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "8D8571C3CBC87318B5EA7A031BC44388", hash_generated_method = "34DCE4107806926E0D68E7B42196C4DD")
            @DSModeled(DSC.SAFE)
            public InvalidateInfo getNextPoolable() {
                return (InvalidateInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return mNext;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.025 -0400", hash_original_method = "FE2E1799C4EB7BCF5C4A1B14A6811ECF", hash_generated_method = "6A2D54FA71C87358C5EB83CFB08F53E6")
            static InvalidateInfo acquire() {
                return sPool.acquire();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "8830525D8149BF52E4AE797FF2AC88D3", hash_generated_method = "8EDBA6ED9C97EDA6866A3A9A41C70B04")
            @DSModeled(DSC.SAFE)
             void release() {
                sPool.release(this);
                // ---------- Original Method ----------
                //sPool.release(this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "80FFB187A01961D0CBA265CB5CA66DE6")
            @DSModeled(DSC.SAFE)
            public boolean isPooled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "36A555F939A13685926002FBFBD79870")
            @DSModeled(DSC.SAFE)
            public void setPooled(boolean isPooled) {
                dsTaint.addTaint(isPooled);
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
        }


        
        interface Callbacks {
            void playSoundEffect(int effectId);
            boolean performHapticFeedback(int effectId, boolean always);
        }
        
    }


    
    private static class ScrollabilityCache implements Runnable {
        public static final int OFF = 0;
        public static final int ON = 1;
        public static final int FADING = 2;
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
        private static final float[] OPAQUE = { 255 };
        private static final float[] TRANSPARENT = { 0.0f };
        public long fadeStartTime;
        public int state = OFF;
        private int mLastColor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "AB4B2D8281C9D79EC8FB184A37CE88FD", hash_generated_method = "CF028F1A437DD02A7280EC734B23DCDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScrollabilityCache(ViewConfiguration configuration, View host) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(configuration.dsTaint);
            fadingEdgeLength = configuration.getScaledFadingEdgeLength();
            scrollBarSize = configuration.getScaledScrollBarSize();
            scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
            scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
            paint = new Paint();
            matrix = new Matrix();
            shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            // ---------- Original Method ----------
            //fadingEdgeLength = configuration.getScaledFadingEdgeLength();
            //scrollBarSize = configuration.getScaledScrollBarSize();
            //scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
            //scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
            //paint = new Paint();
            //matrix = new Matrix();
            //shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
            //paint.setShader(shader);
            //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            //this.host = host;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "96C29AC8476B3BD548A01E55E35CBC04", hash_generated_method = "93227E8333690F937989B813AFC2C100")
        @DSModeled(DSC.SAFE)
        public void setFadeColor(int color) {
            dsTaint.addTaint(color);
            {
                color |= 0xFF000000;
                shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            } //End block
            // ---------- Original Method ----------
            //if (color != 0 && color != mLastColor) {
                //mLastColor = color;
                //color |= 0xFF000000;
                //shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        //color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                //paint.setShader(shader);
                //paint.setXfermode(null);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "14A33F30726B3AE59CE909C1A535F2F0", hash_generated_method = "9B8EE74246E4D6D23178717E3164B2C0")
        @DSModeled(DSC.SAFE)
        public void run() {
            long now;
            now = AnimationUtils.currentAnimationTimeMillis();
            {
                int nextFrame;
                nextFrame = (int) now;
                int framesCount;
                framesCount = 0;
                Interpolator interpolator;
                interpolator = scrollBarInterpolator;
                interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                nextFrame += scrollBarFadeDuration;
                interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                state = FADING;
                host.invalidate(true);
            } //End block
            // ---------- Original Method ----------
            //long now = AnimationUtils.currentAnimationTimeMillis();
            //if (now >= fadeStartTime) {
                //int nextFrame = (int) now;
                //int framesCount = 0;
                //Interpolator interpolator = scrollBarInterpolator;
                //interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                //nextFrame += scrollBarFadeDuration;
                //interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                //state = FADING;
                //host.invalidate(true);
            //}
        }

        
    }


    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "13F513362861425D1A8D234F009B3F81", hash_generated_method = "773F0863A08F336AA49524B9DDFD5664")
        @DSModeled(DSC.SAFE)
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            //mIsPending = false;
        }

        
    }


    
    public static class AccessibilityDelegate {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "BC0125D947E50318963E057CA3B612F3", hash_generated_method = "A853009D354BF6335166B019908DC364")
        @DSModeled(DSC.SAFE)
        public void sendAccessibilityEvent(View host, int eventType) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(eventType);
            host.sendAccessibilityEventInternal(eventType);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventInternal(eventType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.026 -0400", hash_original_method = "C58028C1DB413A86B928F475AB0100FB", hash_generated_method = "BC04D4096AF38E483E461C80D4DB5C09")
        @DSModeled(DSC.SAFE)
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.sendAccessibilityEventUncheckedInternal(event);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventUncheckedInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.027 -0400", hash_original_method = "5A39804E8EC5B74D862B80B866B8F576", hash_generated_method = "8EAB07E08764D77EF991454EA912201B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            boolean var07851A778B664A4380C5AF2DDC5C4AEC_2105480977 = (host.dispatchPopulateAccessibilityEventInternal(event));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return host.dispatchPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.027 -0400", hash_original_method = "D41C8BE91A25AAE323FB25E37AFB61F0", hash_generated_method = "BC6EF8B59F151AAC7060D35E75188677")
        @DSModeled(DSC.SAFE)
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.onPopulateAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.027 -0400", hash_original_method = "D490954174BD599BC02D1199D955E569", hash_generated_method = "31AD77C1A844EFA3185B49192FB5C56B")
        @DSModeled(DSC.SAFE)
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.onInitializeAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.027 -0400", hash_original_method = "E392CA582CA236DC9AD11007B17CF1A9", hash_generated_method = "997034E733F719B6C824556A24F0BC47")
        @DSModeled(DSC.SAFE)
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(info.dsTaint);
            host.onInitializeAccessibilityNodeInfoInternal(info);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityNodeInfoInternal(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.027 -0400", hash_original_method = "4AE2346D08FE5ECB588C47045A997DF1", hash_generated_method = "796A87DCCB49F9AED4C0D9A575FC5DFA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(child.dsTaint);
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            boolean var9559FB15F4F4402574377E5F8741F1FA_1695352477 = (host.onRequestSendAccessibilityEventInternal(child, event));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return host.onRequestSendAccessibilityEventInternal(child, event);
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
    
}


