package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import static android.os.Build.VERSION_CODES.*;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.view.menu.MenuBuilder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
    private SparseArray<Object> mKeyedTags;
    protected Animation mCurrentAnimation = null;
    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredWidth;
    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredHeight;
    boolean mRecreateDisplayList = false;
    @ViewDebug.ExportedProperty(resolveId = true) int mID = NO_ID;
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
    }) int mPrivateFlags;
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
    }) int mSystemUiVisibility;
    int mWindowAttachCount;
    protected ViewGroup.LayoutParams mLayoutParams;
    @ViewDebug.ExportedProperty int mViewFlags;
    TransformationInfo mTransformationInfo;
    private boolean mLastIsOpaque;
    @ViewDebug.ExportedProperty(category = "layout") protected int mLeft;
    @ViewDebug.ExportedProperty(category = "layout") protected int mRight;
    @ViewDebug.ExportedProperty(category = "layout") protected int mTop;
    @ViewDebug.ExportedProperty(category = "layout") protected int mBottom;
    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollX;
    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollY;
    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingTop;
    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingBottom;
    private CharSequence mContentDescription;
    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingBottom;
    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding") boolean mUserPaddingRelative;
    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingStart;
    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingEnd;
    int mOldWidthMeasureSpec = Integer.MIN_VALUE;
    int mOldHeightMeasureSpec = Integer.MIN_VALUE;
    private Drawable mBGDrawable;
    private int mBackgroundResource;
    private boolean mBackgroundSizeChanged;
    ListenerInfo mListenerInfo;
    protected Context mContext;
    private Resources mResources;
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
    @ViewDebug.ExportedProperty(category = "measurement") private int mMinHeight;
    @ViewDebug.ExportedProperty(category = "measurement") private int mMinWidth;
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
    }) int mLayerType = LAYER_TYPE_NONE;
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
    }) private int mTextDirection = DEFAULT_TEXT_DIRECTION;
    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    }) private int mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    protected InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.963 -0400", hash_original_method = "6E480C32A7FC910695FE07C33ABF7A7A", hash_generated_method = "3A01B612100BF4A82BD3B836C5DB4C88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.964 -0400", hash_original_method = "7A0AD99F840E8369EC476A6B56BA8ADA", hash_generated_method = "89925DBC4DB53C50ED8A7D6F5EFC9D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.967 -0400", hash_original_method = "F8E7269105FB2D522A5F7FAB2F89EE95", hash_generated_method = "6C98DF9AF4BBF7F035D7ACDA09ECF470")
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
        int N;
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
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1830342844 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FITS_SYSTEM_WINDOWS;
                        viewFlagMasks |= FITS_SYSTEM_WINDOWS;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_fitsSystemWindows 
                //Begin case com.android.internal.R.styleable.View_focusable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1654639181 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_focusable 
                //Begin case com.android.internal.R.styleable.View_focusableInTouchMode 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1662530999 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_focusableInTouchMode 
                //Begin case com.android.internal.R.styleable.View_clickable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_2137193296 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= CLICKABLE;
                        viewFlagMasks |= CLICKABLE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_clickable 
                //Begin case com.android.internal.R.styleable.View_longClickable 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1424531355 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= LONG_CLICKABLE;
                        viewFlagMasks |= LONG_CLICKABLE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_longClickable 
                //Begin case com.android.internal.R.styleable.View_saveEnabled 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1804903616 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues |= SAVE_DISABLED;
                        viewFlagMasks |= SAVE_DISABLED_MASK;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_saveEnabled 
                //Begin case com.android.internal.R.styleable.View_duplicateParentState 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1790341367 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= DUPLICATE_PARENT_STATE;
                        viewFlagMasks |= DUPLICATE_PARENT_STATE;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_duplicateParentState 
                //Begin case com.android.internal.R.styleable.View_visibility 
                int visibility;
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
                int layoutDirection;
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
                int cacheQuality;
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
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_1661616349 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~SOUND_EFFECTS_ENABLED;
                        viewFlagMasks |= SOUND_EFFECTS_ENABLED;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_soundEffectsEnabled 
                //Begin case com.android.internal.R.styleable.View_hapticFeedbackEnabled 
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_47644154 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~HAPTIC_FEEDBACK_ENABLED;
                        viewFlagMasks |= HAPTIC_FEEDBACK_ENABLED;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_hapticFeedbackEnabled 
                //Begin case R.styleable.View_scrollbars 
                int scrollbars;
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
                    boolean varC070C09F5C0916551B09381C0852B394_1006169060 = (context.getApplicationInfo().targetSdkVersion >= ICE_CREAM_SANDWICH);
                } //End collapsed parenthetic
                //End case R.styleable.View_fadingEdge 
                //Begin case R.styleable.View_requiresFadingEdge 
                int fadingEdge;
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
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1035528712 = (a.getBoolean(attr, false));
                    {
                        setScrollContainer(true);
                    } //End block
                } //End collapsed parenthetic
                //End case R.styleable.View_isScrollContainer 
                //Begin case com.android.internal.R.styleable.View_keepScreenOn 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_466120672 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= KEEP_SCREEN_ON;
                        viewFlagMasks |= KEEP_SCREEN_ON;
                    } //End block
                } //End collapsed parenthetic
                //End case com.android.internal.R.styleable.View_keepScreenOn 
                //Begin case R.styleable.View_filterTouchesWhenObscured 
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1247347455 = (a.getBoolean(attr, false));
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
                    boolean var493A86E51AC82FCCEFBD5D9BA92432B0_1978632713 = (context.isRestricted());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The android:onClick attribute cannot "
                                + "be used within a restricted context");
                    } //End block
                } //End collapsed parenthetic
                //End case R.styleable.View_onClick 
                //Begin case R.styleable.View_onClick 
                String handlerName;
                handlerName = a.getString(attr);
                //End case R.styleable.View_onClick 
                //Begin case R.styleable.View_onClick 
                {
                    setOnClickListener(new OnClickListener() {                        private Method mHandler;
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.966 -0400", hash_original_method = "E9EFDD10534D1BAF541333BA74E853ED", hash_generated_method = "C50340A723A2009D27A080AF1DD27D1D")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void onClick(View v) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(v.dsTaint);
                            {
                                try 
                                {
                                    mHandler = getContext().getClass().getMethod(handlerName,
                                                View.class);
                                } //End block
                                catch (NoSuchMethodException e)
                                {
                                    int id;
                                    id = getId();
                                    String idText;
                                    idText = "";
                                    idText = " with id '"
                                                + getContext().getResources().getResourceEntryName(
                                                    id) + "'";
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not find a method " +
                                                handlerName + "(View) in the activity "
                                                + getContext().getClass() + " for onClick handler"
                                                + " on view " + View.this.getClass() + idText, e);
                                } //End block
                            } //End block
                            try 
                            {
                                mHandler.invoke(getContext(), View.this);
                            } //End block
                            catch (IllegalAccessException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not execute non "
                                            + "public method of the activity", e);
                            } //End block
                            catch (InvocationTargetException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not execute "
                                            + "method of the activity", e);
                            } //End block
                            // ---------- Original Method ----------
                            // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.968 -0400", hash_original_method = "5C3A364FECC6F7D07E7A546170C25E98", hash_generated_method = "32A2A5FFE588BE14FBF7F5D017C5A252")
    @DSModeled(DSC.SAFE)
     View() {
        mResources = null;
        // ---------- Original Method ----------
        //mResources = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.968 -0400", hash_original_method = "F39CEBF0E5E47A818635618D8F975382", hash_generated_method = "1FA812928C96D567F7BC3881D27F00F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.968 -0400", hash_original_method = "48BE981E65F7E857DD7A9FF8EF5006FF", hash_generated_method = "2F9461C48BB45ADB0D10F5CEAF46D032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVerticalFadingEdgeLength() {
        {
            boolean var50B16E908CD6883BB4A53F1CCAB8FFC0_1995433164 = (isVerticalFadingEdgeEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.968 -0400", hash_original_method = "F316E2F78DFC9160954B8650C58C0898", hash_generated_method = "C8E3331E9B90810C867FACD41AECD914")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFadingEdgeLength(int length) {
        dsTaint.addTaint(length);
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
        // ---------- Original Method ----------
        //initScrollCache();
        //mScrollCache.fadingEdgeLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.968 -0400", hash_original_method = "A8651530AFA26393AFB5F6425B22CDCD", hash_generated_method = "DC1824CDB5F725830776F2FDA1040E17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHorizontalFadingEdgeLength() {
        {
            boolean var5D77CA7D5D90FF39CB3E108D33083F4D_839165149 = (isHorizontalFadingEdgeEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.969 -0400", hash_original_method = "9E8BEE4EA7290E77910774FBF44231C2", hash_generated_method = "4A65BC3A2198974C7523F522BCAB0C4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.969 -0400", hash_original_method = "6872C13C59C68BCC5CF5DE777A5D5AA0", hash_generated_method = "DD4FEE3493E55E5084274859A99798AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.970 -0400", hash_original_method = "92AEC3F31170B251C0CC405CA4D3250A", hash_generated_method = "7ED8EB2B0E16D6BA4B166AA65950DD46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initializeScrollbars(TypedArray a) {
        dsTaint.addTaint(a.dsTaint);
        initScrollCache();
        ScrollabilityCache scrollabilityCache;
        scrollabilityCache = mScrollCache;
        {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        } //End block
        boolean fadeScrollbars;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.970 -0400", hash_original_method = "E049E8AF463EFBD39046D8F102EAF6B1", hash_generated_method = "006228A8170D06675B7944AFD610FE31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.970 -0400", hash_original_method = "6A347D034BA88A40E4761231BE70B8AA", hash_generated_method = "42AC58E1275065226406BFFA7436C73A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.970 -0400", hash_original_method = "0B028AFE1E9609D00D97AC9B679932DA", hash_generated_method = "16EBC48ADED77331C4AA0B169A075783")
    @DSModeled(DSC.SAFE)
    public int getVerticalScrollbarPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVerticalScrollbarPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.970 -0400", hash_original_method = "3F6307E0FF2B24CF42D639D72702E7A3", hash_generated_method = "60DAD2A6F64383DCC9B3CBD5FA5F6212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.971 -0400", hash_original_method = "D8AB5E19AA18F69BACA6EC368D2591FE", hash_generated_method = "C3C071B597AD1C01F78B8EBB8B502F46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnFocusChangeListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnFocusChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.971 -0400", hash_original_method = "E2DB3817E7DB5D233E4A7D6EADE958A3", hash_generated_method = "B0C043F6939264AA7B5049E0D67A2C0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        ListenerInfo li;
        li = getListenerInfo();
        {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        } //End block
        {
            boolean var5BC5FBAFE932C29989D14499066114E0_2109462921 = (!li.mOnLayoutChangeListeners.contains(listener));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.971 -0400", hash_original_method = "98A56C49B0A9E0F5D269641F74288A13", hash_generated_method = "2880DE8D2F9C2A6F26C4E1C3845ED021")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.971 -0400", hash_original_method = "BCC986125DE454FD64FA8CF6FF7B3375", hash_generated_method = "51725E8A73553832BB2BC43FBFE41546")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.971 -0400", hash_original_method = "BB59F05E95A495FA9A30543444FC5E76", hash_generated_method = "BD59A81406174540DD9C5A246EC3ABDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.972 -0400", hash_original_method = "A3D291AC9D619397F7033ECE59D11B86", hash_generated_method = "2B38CAEFD584AE0DE157890EB4A7707D")
    @DSModeled(DSC.SAFE)
    public OnFocusChangeListener getOnFocusChangeListener() {
        ListenerInfo li;
        li = mListenerInfo;
        return (OnFocusChangeListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return li != null ? li.mOnFocusChangeListener : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.972 -0400", hash_original_method = "45F4C058CBC73D55564FBEB6E17C2099", hash_generated_method = "A0B771255429CC94A5F4C8F6B25C6F25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnClickListener(OnClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var04EA38E4DA3FCC73953331C5213AFF9F_2007310030 = (!isClickable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.972 -0400", hash_original_method = "8038CCFA19DFF6DCB9855B2C21487DC3", hash_generated_method = "BD4E7AD5BA80C1A435E61EC5F183DFBB")
    @DSModeled(DSC.SAFE)
    public boolean hasOnClickListeners() {
        ListenerInfo li;
        li = mListenerInfo;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return (li != null && li.mOnClickListener != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.972 -0400", hash_original_method = "C88CD920669EF9D2067A739196536F5A", hash_generated_method = "8629ED7402EC889E514591991B5A26AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnLongClickListener(OnLongClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var4E9822764F29F607F332912995A375BC_719700306 = (!isLongClickable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.972 -0400", hash_original_method = "3B1D28314D3140C1C25951340EB50400", hash_generated_method = "BCE87E0B51EC6628320B5A2BD519A212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            boolean var4E9822764F29F607F332912995A375BC_2080178330 = (!isLongClickable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.973 -0400", hash_original_method = "F0CE5BDD9B8548BAC9D7A1A1FC9F10B8", hash_generated_method = "3B5A668E929AEDDB2BA06412B0C3D9A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.973 -0400", hash_original_method = "102D936797B9C1FC40617DF92F54CFE2", hash_generated_method = "D204E5B6AB24816740E60F598CA8B661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.973 -0400", hash_original_method = "00035430EA6437DC8BB5C07835F45B65", hash_generated_method = "643D468DB330285237C19DDA66CE0D05")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.973 -0400", hash_original_method = "0AFC4304DA44E934FA35FDC29342C80F", hash_generated_method = "8D21BF8CD04E03CA86EFB928458163B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean performButtonActionOnTouchDown(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var431FF76FC0879DE3BD003EA2EA16B78F_1303899309 = ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0);
            {
                {
                    boolean var1A9C8D31FBEACF9594778DB5C5D1B4C1_428627058 = (showContextMenu(event.getX(), event.getY(), event.getMetaState()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "3A1C6F51C14FB3CA1856280BB08BDD78", hash_generated_method = "C19A907F73600208347F957239A11923")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenu() {
        boolean var57558D56D4CFDCF7F086DB96E3562251_244783588 = (getParent().showContextMenuForChild(this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getParent().showContextMenuForChild(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "B2C2D020E619A9A69ACCD76F29CBF0A8", hash_generated_method = "70259F5619BE962EBDE2B366E03BA74A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenu(float x, float y, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        boolean varA4958949E9E0853BF05BBEE347C0FF81_2084341978 = (showContextMenu());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "554809A43858BFBD98E9D476D5975BC9", hash_generated_method = "C67D4580237FC8527CE4307EC0663150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionMode(ActionMode.Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        ActionMode varD65387F2F72B335099677E2229713742_1350512848 = (getParent().startActionModeForChild(this, callback));
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getParent().startActionModeForChild(this, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "31C7524DA5B5B98F54BA6C8BE0DEBF7E", hash_generated_method = "3E0A6C3B26B4DDBD06CCD6105C0ECAF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnKeyListener(OnKeyListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnKeyListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnKeyListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "D8E89DFA5C4F927FE4D243F514232285", hash_generated_method = "A26DF1E2E4626A94BADEB796F8A98B04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnTouchListener(OnTouchListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnTouchListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnTouchListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.974 -0400", hash_original_method = "A6ED4A9DC8C6B322504EFE7525CB31A1", hash_generated_method = "BDD15DB208AB4FD9FF7DC6C432611BB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnGenericMotionListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnGenericMotionListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.975 -0400", hash_original_method = "A231A17C6E4AE608F5CD4B1132C585A7", hash_generated_method = "1C0FC124E65467242E3DE4C824E31BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnHoverListener(OnHoverListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnHoverListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnHoverListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.975 -0400", hash_original_method = "8FD55843B8D7F3FEDE7B7D516A1E3E35", hash_generated_method = "7343295D39A6107C2031127AFCA07AD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnDragListener(OnDragListener l) {
        dsTaint.addTaint(l.dsTaint);
        getListenerInfo().mOnDragListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnDragListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.975 -0400", hash_original_method = "16B5A8656CEB6785661CF48B92B45991", hash_generated_method = "329AB350CE731634B76E61438593EA33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.975 -0400", hash_original_method = "2192BF4A933C90A79FE0C71F9C0B2F3D", hash_generated_method = "6B123154EDA7507D8E08A53DA87C581E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRectangleOnScreen(Rect rectangle) {
        dsTaint.addTaint(rectangle.dsTaint);
        boolean varB53A64F27CEF8B117CF782EC0F44B212_151805918 = (requestRectangleOnScreen(rectangle, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestRectangleOnScreen(rectangle, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.976 -0400", hash_original_method = "BDB750CCBE647F1CD5444CDF496F66A3", hash_generated_method = "27392E4168D762FAD3A299ECD03C2016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.976 -0400", hash_original_method = "A6F69BAD809415BD5537E3FD153C267F", hash_generated_method = "E804AFE297232281A3D184C897B2A3B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.976 -0400", hash_original_method = "B948A77A86E2A2242F3F753171415A6F", hash_generated_method = "E185FEEAEED513A145564C4D000D5AD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.976 -0400", hash_original_method = "895408B45B14DF7336768B76769FDFBE", hash_generated_method = "8CFD639286A261F7C8B5F8F3C689E3F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.977 -0400", hash_original_method = "337547862E6B052D2DEF8F8E7CCEA590", hash_generated_method = "ECB5E568329D0AA3A50129F244BA4689")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean hasFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.977 -0400", hash_original_method = "B2402A510BB29E4C255854E18659AE1B", hash_generated_method = "D69B74A89EE1A680F9D2939DC0CED690")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFocusable() {
        boolean var45438BF76A2F167C289F26830B3A9B93_1700115323 = ((mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.977 -0400", hash_original_method = "5A1E14083BB718E6700BA53BA3884697", hash_generated_method = "DB352C9960074BD62D877246E4D1D768")
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
                boolean varF27F491A5EAB0B2989FBEF44657192A7_368680907 = (isPressed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.977 -0400", hash_original_method = "67C8279330D12E8D41FE4F9795D7EB79", hash_generated_method = "EB604001BCEC618FD42CAAE1563C64D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.977 -0400", hash_original_method = "BE2AB20B544FD38FEA2111E9FF446FAD", hash_generated_method = "6E61CAA1C9B40A90AC1D21E7AB7F6E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendAccessibilityEventInternal(int eventType) {
        dsTaint.addTaint(eventType);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_1307025122 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.978 -0400", hash_original_method = "B790306D0C64AC6AB0D8747A1C899258", hash_generated_method = "E7231C88827586DB5ECC9BDB3D0964B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.978 -0400", hash_original_method = "2BAF48857D95094002D2EF1740E1384F", hash_generated_method = "741441548802817B19E42E3225ADC02A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var2E2E2221860B3DCAB8C5D4F0DAD9AC26_611541709 = (!isShown());
        } //End collapsed parenthetic
        onInitializeAccessibilityEvent(event);
        {
            boolean var9D05604FB3FF39F2704B15C63CA7D337_599525147 = ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.978 -0400", hash_original_method = "927EED19E22DB3C930EC71946191C691", hash_generated_method = "AA1BF263EB17A523D119AE27438DED13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC130CACCC03E1AF22AC94D08B8319DCD_62219668 = (mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event));
        } //End block
        {
            boolean var372DEE9301D724A2D11E91D3D5BF5A44_1959588773 = (dispatchPopulateAccessibilityEventInternal(event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event);
        //} else {
            //return dispatchPopulateAccessibilityEventInternal(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.978 -0400", hash_original_method = "8EC2668F1DC902F63C332D19DDE36094", hash_generated_method = "9E9A5F73FF9940D1091A800BD11C3F56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        onPopulateAccessibilityEvent(event);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.979 -0400", hash_original_method = "A0DF1F515FF193F86B7E130DE16E38CE", hash_generated_method = "FB1306D22013D011BCDD210D9DCBC900")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.979 -0400", hash_original_method = "CF40AA9C4C55BD5A22FC0E76716C7875", hash_generated_method = "0FBFA7C816E7CBEB4A88BD922CB317C2")
    @DSModeled(DSC.SAFE)
     void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.979 -0400", hash_original_method = "28310CBBAED9E8F097DF5C90DBA9CD0F", hash_generated_method = "92045B2AB8759BA584311BE8BA4BA620")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.980 -0400", hash_original_method = "43B5B6E634D7CF960BF74CE0E1DDA2CD", hash_generated_method = "6B82FDE852A31541C7F24747537BADAE")
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
            boolean var703D9E8BC245CC3A7B48B35F52188203_901824879 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.981 -0400", hash_original_method = "53F1596AC086DF0FD9B166B1443D793C", hash_generated_method = "527337FEA13454688518F1F0DD0633F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.981 -0400", hash_original_method = "BE2067901E907368432A8D9CCB431457", hash_generated_method = "0A82376E4A92214F0D619FFD0B52D39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.981 -0400", hash_original_method = "8753AD1110C37F0E73AF31B4448B5211", hash_generated_method = "34C4A9EF0D3A78C0431E79E301FAF8F4")
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
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_569812888 = (isFocusable());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_238379586 = (isFocused());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.982 -0400", hash_original_method = "32F138BD45B7179C5519FF8B12AC5296", hash_generated_method = "F06242BBB967BF4D0F6E9300E7E5EF03")
    @DSModeled(DSC.SAFE)
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        dsTaint.addTaint(delegate.dsTaint);
        // ---------- Original Method ----------
        //mAccessibilityDelegate = delegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.982 -0400", hash_original_method = "64D1C3C95C84965C0C27E168EBDF3A77", hash_generated_method = "2A6CD0ED0A8018A55EE369919FD7519A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.982 -0400", hash_original_method = "ABBCC5D3939BB662168BF84991E4D81C", hash_generated_method = "43EF4563A0E62B978D3C0357FBCA6B9E")
    @DSModeled(DSC.SAFE)
    public int getAccessibilityWindowId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.982 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "9AEA7AC2805E6F06BD7FB29C1CE6CB3E")
    @DSModeled(DSC.SAFE)
    public CharSequence getContentDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.982 -0400", hash_original_method = "1087954D5CDD3C4C18E361D3DD728844", hash_generated_method = "7632D7D6A8AA1483843E85FF9A3AD586")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public void setContentDescription(CharSequence contentDescription) {
        dsTaint.addTaint(contentDescription);
        // ---------- Original Method ----------
        //mContentDescription = contentDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.983 -0400", hash_original_method = "5C1A3C599F20DF55DE3C4471944CAAB7", hash_generated_method = "38E1F736D1D0CE663B8F46A26D06B1FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onFocusLost() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        resetPressedState();
        // ---------- Original Method ----------
        //resetPressedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.983 -0400", hash_original_method = "81136F7A8F96E00E1C77CED95B4F9DA3", hash_generated_method = "8BF55AB8FD719D591E04E55ECEDAE91A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetPressedState() {
        {
            boolean varCBC9727A244F165456D2D6CDD8022488_1679851207 = (isPressed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.983 -0400", hash_original_method = "BAE18A1621CF10BDD62967DA8210DF90", hash_generated_method = "50BBE27ED107F260E2FBDFAD6F045438")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.983 -0400", hash_original_method = "DDD0B2B4CCE06873AEE74BD63DE5A294", hash_generated_method = "95BC58C9509B3629A64749312C9ADB14")
    @DSModeled(DSC.SAFE)
    public View findFocus() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.983 -0400", hash_original_method = "1D4A87A45389821BFC7421CA2D7AD61B", hash_generated_method = "6FAEA8A5476BE45C66455F85BE998162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "B2DEE8CA09FADC0B572CF46E784DEFD4", hash_generated_method = "D82F64E36FCB45169096CBC31697B2DB")
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheQuality() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "9D6669AC39CE9592E8D8B20B25494E51", hash_generated_method = "D7C0D4D83D13673F88263A0607A15D25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDrawingCacheQuality(int quality) {
        dsTaint.addTaint(quality);
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
        // ---------- Original Method ----------
        //setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "03B1D1993EB8539284C7E9AFB4C193D6", hash_generated_method = "01A2A945DFF6FEEB9E63D96EC330261D")
    @DSModeled(DSC.SAFE)
    public boolean getKeepScreenOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & KEEP_SCREEN_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "99FBDDFD33142E06617327BD1E6B4E35", hash_generated_method = "3AA97801C819BBFE818334227F14955E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeepScreenOn(boolean keepScreenOn) {
        dsTaint.addTaint(keepScreenOn);
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
        // ---------- Original Method ----------
        //setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "652E85B83FB56D2A13FFAE8255561FDD", hash_generated_method = "28104A9E27C30ECEC4276FFFF3A64F1B")
    @DSModeled(DSC.SAFE)
    public int getNextFocusLeftId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusLeftId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.984 -0400", hash_original_method = "38A879027311496175629221AC818202", hash_generated_method = "032C5244199FCDF4453F914289B5EBE1")
    @DSModeled(DSC.SAFE)
    public void setNextFocusLeftId(int nextFocusLeftId) {
        dsTaint.addTaint(nextFocusLeftId);
        // ---------- Original Method ----------
        //mNextFocusLeftId = nextFocusLeftId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "C88A703CE946F61F0459BFCDB166A908", hash_generated_method = "7F9B6763B457EE16381A408650CDFDF9")
    @DSModeled(DSC.SAFE)
    public int getNextFocusRightId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusRightId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "2FF4A363CCED3B1F6EFFEC35EA0E0480", hash_generated_method = "75C8B3161506D46AA06058E7077630FB")
    @DSModeled(DSC.SAFE)
    public void setNextFocusRightId(int nextFocusRightId) {
        dsTaint.addTaint(nextFocusRightId);
        // ---------- Original Method ----------
        //mNextFocusRightId = nextFocusRightId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "88AE25872576F6D10940E7A2DFEC3C43", hash_generated_method = "B91A75EA278A2BFEE1095D62C206D7CC")
    @DSModeled(DSC.SAFE)
    public int getNextFocusUpId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusUpId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "EB6C60D159C1D76D120BCAB59C29C293", hash_generated_method = "9A6E76CDDE99CDF655482ECBE5483D30")
    @DSModeled(DSC.SAFE)
    public void setNextFocusUpId(int nextFocusUpId) {
        dsTaint.addTaint(nextFocusUpId);
        // ---------- Original Method ----------
        //mNextFocusUpId = nextFocusUpId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "D4E7D4D04A0684EEEE5B75921F57CEF0", hash_generated_method = "255DCA0A02A583F2DEBD5D6827BBE358")
    @DSModeled(DSC.SAFE)
    public int getNextFocusDownId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusDownId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "3F02629850152C987A67C858A1F48B49", hash_generated_method = "5CBAD9E64B44AB122C3E11A08E0F334E")
    @DSModeled(DSC.SAFE)
    public void setNextFocusDownId(int nextFocusDownId) {
        dsTaint.addTaint(nextFocusDownId);
        // ---------- Original Method ----------
        //mNextFocusDownId = nextFocusDownId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.985 -0400", hash_original_method = "73A79720EFCAB292687913BA58A7941B", hash_generated_method = "07AA88386EA7AED9EA917BFC44307D01")
    @DSModeled(DSC.SAFE)
    public int getNextFocusForwardId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNextFocusForwardId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.986 -0400", hash_original_method = "E9ABC127C8FB8F8FC934426D38CB5040", hash_generated_method = "C3D133C3F01A9D8626D49BB93BC15A40")
    @DSModeled(DSC.SAFE)
    public void setNextFocusForwardId(int nextFocusForwardId) {
        dsTaint.addTaint(nextFocusForwardId);
        // ---------- Original Method ----------
        //mNextFocusForwardId = nextFocusForwardId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.986 -0400", hash_original_method = "9296F75E65D2F78CDC5D2F47E6CA50BF", hash_generated_method = "FC9DCA794DA8F932237B32B3FB493698")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.986 -0400", hash_original_method = "A39140C8CB73A931FE842774091348D2", hash_generated_method = "E360680F753816EE525A633899D9B70F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.986 -0400", hash_original_method = "E3CDF7FA6CDC2881F199FFB75CF3D7D5", hash_generated_method = "891E75862A05BA76F862EBBCB7444C7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        dsTaint.addTaint(fitSystemWindows);
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
        // ---------- Original Method ----------
        //setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "5692CC010F12659264569BED146C3B41", hash_generated_method = "5334834A3620B53874DA401AF72145A2")
    @DSModeled(DSC.SAFE)
    public boolean fitsSystemWindows() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "D2B31666DEBF08F8B4CA461C0B34FB1E", hash_generated_method = "4AFE6BE2539C055036B5901A3E2103F3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "02AF8E28E646A9214DED62901D5A05AB", hash_generated_method = "233DDC84C56B1972AD2EB1051EFD697F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        setFlags(visibility, VISIBILITY_MASK);
        mBGDrawable.setVisible(visibility == VISIBLE, false);
        // ---------- Original Method ----------
        //setFlags(visibility, VISIBILITY_MASK);
        //if (mBGDrawable != null) mBGDrawable.setVisible(visibility == VISIBLE, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "1FAAF1AA1B65BC3CCFA44E36A044FBA3", hash_generated_method = "6E4700E24F76EE5F095E944C25F57EE2")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & ENABLED_MASK) == ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "82122684EF3D7563FCC0B376DF0849B5", hash_generated_method = "A7AA333AC1FE0997F467E49DFC3559F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_547134175 = (enabled == isEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.987 -0400", hash_original_method = "C9881A9860604453F19A8665970456AB", hash_generated_method = "93C0F2CC57355838F29704967E5442A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "2EADF8D169DEE1EA3C577B22372A4F29", hash_generated_method = "EBE951B36AF6C20EF390F74BD9F48BCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "0616009511F2186FBF13D4B2BAEA6B3A", hash_generated_method = "6885963D655233577569152B51346EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        dsTaint.addTaint(soundEffectsEnabled);
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
        // ---------- Original Method ----------
        //setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "04FBA67AC1724C494C94FB884C5C883F", hash_generated_method = "ACF024B57D00CFDAF323EC10D7A999F7")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSoundEffectsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "665412B4BA3D450566C79B734C683A80", hash_generated_method = "DAEF349AC5810F0362D3B78AA6B850A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        dsTaint.addTaint(hapticFeedbackEnabled);
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
        // ---------- Original Method ----------
        //setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "69619136C00391879489C4434A4D0191", hash_generated_method = "DE38A2DA553081BF5718ADBB1C05235B")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.988 -0400", hash_original_method = "2C2C2D2C9CAFB887317333E5CB13B049", hash_generated_method = "2B6228AF564D9CBAA0942B1477CF48BC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "72BED775868D43D3C5AF7895C4FF8A44", hash_generated_method = "20392B0D98B9201F91A9D444BC4B88A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @RemotableViewMethod
    public void setLayoutDirection(int layoutDirection) {
        dsTaint.addTaint(layoutDirection);
        {
            boolean var321A562371C59BD383BBC58B39275A56_1283596463 = (getLayoutDirection() != layoutDirection);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "9F5111100CE328994E06DFE63B825110", hash_generated_method = "B755C4AAFFA1DBA56EBFD5C6D1678E0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "F4E28248D2C3D2566E14BBF2219E2BCD", hash_generated_method = "B1B5885CD28B531614F2C75D07296E15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty(category = "layout")
    public boolean isLayoutRtl() {
        boolean varA36BF340EF5BBC5D48962FD8A0BF863A_1645331833 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "F9FAF3BB929B9847B181A3D88FABD842", hash_generated_method = "B077414B4C169542270B6C4FF3CF9780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWillNotDraw(boolean willNotDraw) {
        dsTaint.addTaint(willNotDraw);
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
        // ---------- Original Method ----------
        //setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "B6E391CBFCFD7EA26D5A2732CEE40DF4", hash_generated_method = "2A68F13DAB9BE074F7DEBC252C350709")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DRAW_MASK) == WILL_NOT_DRAW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.989 -0400", hash_original_method = "60A2EABB5E8AA4648C06B0E0E4A2AF9C", hash_generated_method = "E391D027845E724898898132C6FC0AB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        dsTaint.addTaint(willNotCacheDrawing);
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
        // ---------- Original Method ----------
        //setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "4D65385BAE58DC536EC26F23A55907FF", hash_generated_method = "4300C2953AEAD32CB5E480DD16866A2B")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "CAB421C9E4DB53058A0B9351F5E562C4", hash_generated_method = "085198F21BE8CB586A3909971242BACD")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isClickable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & CLICKABLE) == CLICKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "12111EA4E19255C8C0AB24AED3DDA51C", hash_generated_method = "72449AF2DA9B3AADBDEC4F640FAD30B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClickable(boolean clickable) {
        dsTaint.addTaint(clickable);
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "03A713DEC8C026709970488D282B8F0B", hash_generated_method = "B83A50E9C1EC1B1CCC76BADC8536ABCC")
    @DSModeled(DSC.SAFE)
    public boolean isLongClickable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "43536DF18C7BAF4AF88A04663CE8F089", hash_generated_method = "6A95A24B0E3A7B357CC019CBB264EE43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLongClickable(boolean longClickable) {
        dsTaint.addTaint(longClickable);
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "EED851B5F13351F1D2A34CF3C577E6B2", hash_generated_method = "7325E03DBF0894A7F58FB789E52A549F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.990 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "06D6034BB01B3EB6FEF9D8311A4558AF")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "2EE8A3F216F87253226045E7C3E687D4", hash_generated_method = "7F94D1043B22BB836E7E297983F9C8E8")
    @DSModeled(DSC.SAFE)
    public boolean isPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & PRESSED) == PRESSED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "A0C463B2F7163F6CE9FACC921DDDC0C1", hash_generated_method = "0564BB32C7A0FFFDA986D8C9F8A95F36")
    @DSModeled(DSC.SAFE)
    public boolean isSaveEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "245457DBE539B6534978F5D496F585EA", hash_generated_method = "7FFC9263F49E607B4E5ADAE6F41FF364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSaveEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "A79886E869A4527EDC4A240CAA54713C", hash_generated_method = "5B54397166D987A643CB61934335A3A5")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "EDB53D9F0799F64121B32D1526967A47", hash_generated_method = "D7B69BC91B81D2690F8249BA7EC6B659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilterTouchesWhenObscured(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                //FILTER_TOUCHES_WHEN_OBSCURED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.991 -0400", hash_original_method = "48E76F9595084274E97DBE24F2087BC5", hash_generated_method = "C9AC0B3094765EBB8A8DFD17CE500838")
    @DSModeled(DSC.SAFE)
    public boolean isSaveFromParentEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.992 -0400", hash_original_method = "72C3E4C29A0B231006D33E493310EA89", hash_generated_method = "D77E3273449F97623C1F7EF7B3BBEFBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSaveFromParentEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.992 -0400", hash_original_method = "C297173E860DE7426FAD1827D2AF0FEF", hash_generated_method = "F5627F44D767C16F18B946AE702484C9")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus")
    public final boolean isFocusable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return FOCUSABLE == (mViewFlags & FOCUSABLE_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.992 -0400", hash_original_method = "DC5548897986A7EA94B912A4E6E95490", hash_generated_method = "1A9FCD519181E03972E543BDC91849D5")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public final boolean isFocusableInTouchMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.992 -0400", hash_original_method = "0DA4F7FC608C37A46918AF583285CEAA", hash_generated_method = "A621C75A24033D924E68DB956755335F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(int direction) {
        dsTaint.addTaint(direction);
        {
            View varDF2725BFF6E0DCC0AB37D8D4C46D43EE_1311167068 = (mParent.focusSearch(this, direction));
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.focusSearch(this, direction);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.992 -0400", hash_original_method = "3A7E0D4CA01222234C5493EC87211574", hash_generated_method = "997BBD417BE31DD072EBB33944DB1722")
    @DSModeled(DSC.SAFE)
    public boolean dispatchUnhandledMove(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.993 -0400", hash_original_method = "402D36B98ACE611B6285D11A0B7474BF", hash_generated_method = "9BC97EAD5584DC40D097667CFCD3310C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findUserSetNextFocus(View root, int direction) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(direction);
        //Begin case FOCUS_LEFT 
        View var71598DDAC8A3CD8E8892CDCC875111FB_816316040 = (findViewInsideOutShouldExist(root, mNextFocusLeftId));
        //End case FOCUS_LEFT 
        //Begin case FOCUS_RIGHT 
        View var8D119958F6B6A370EB1BC1CE0AFE13DA_517868835 = (findViewInsideOutShouldExist(root, mNextFocusRightId));
        //End case FOCUS_RIGHT 
        //Begin case FOCUS_UP 
        View var1D856002D07ECFBD263D89E69FEAC9D5_1614997037 = (findViewInsideOutShouldExist(root, mNextFocusUpId));
        //End case FOCUS_UP 
        //Begin case FOCUS_DOWN 
        View var8A93DDDBEAF6F274115EA4CE506C765B_106474659 = (findViewInsideOutShouldExist(root, mNextFocusDownId));
        //End case FOCUS_DOWN 
        //Begin case FOCUS_FORWARD 
        View var157CC14CF45602C8CBCB089735AD1E07_595384927 = (findViewInsideOutShouldExist(root, mNextFocusForwardId));
        //End case FOCUS_FORWARD 
        //Begin case FOCUS_BACKWARD 
        {
            int id;
            id = mID;
            View var649EFD03FFB9861B9C300639000E6295_2134480413 = (root.findViewByPredicateInsideOut(this, new Predicate<View>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.993 -0400", hash_original_method = "3BEF333C61A2928B61AE6075EB704595", hash_generated_method = "D206C86F9D6FFE1C357E53A11C1CA69B")
                @DSModeled(DSC.SAFE)
                @Override
                public boolean apply(View t) {
                    dsTaint.addTaint(t.dsTaint);
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return t.mNextFocusForwardId == id;
                }
}));
        } //End block
        //End case FOCUS_BACKWARD 
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.993 -0400", hash_original_method = "B3DFEFAC3DA8B2AFE30A5DD5BC4E600A", hash_generated_method = "4BF2667E7B33766B147F3D3B073D15FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.993 -0400", hash_original_method = "464AB183F4A2042C34DE93C717198DDB", hash_generated_method = "547E85107E183E5DE1458E1B07F7CDA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.993 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "32145A288F94716A9237DEDDE94A7AB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFocusables(ArrayList<View> views, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(views.dsTaint);
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.994 -0400", hash_original_method = "C71740B3CD39B4D243A828C918021CDE", hash_generated_method = "3F2E98DA3AFC5CB399CD66BB5C2D8AF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(focusableMode);
        {
            boolean var8DB70F00D9A309F787FE648FEF017045_15085817 = (!isFocusable());
        } //End collapsed parenthetic
        {
            boolean var2850B2A852F5A5DCF1E2CF378227B555_666449570 = ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.994 -0400", hash_original_method = "DD343D81D813CE2B90520525DB465FA4", hash_generated_method = "648F8D234250A7F9DAAD8B85FFEBA601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        dsTaint.addTaint(outViews.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(searched);
        {
            boolean var14B0D5F38B5F4B978CEA9F4FD1437EE5_2133912560 = ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription));
            {
                String searchedLowerCase;
                searchedLowerCase = searched.toString().toLowerCase();
                String contentDescriptionLowerCase;
                contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
                {
                    boolean var5F42F50A6B3B93A57712332F7515E0D4_871464376 = (contentDescriptionLowerCase.contains(searchedLowerCase));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.994 -0400", hash_original_method = "FFA271D2293E365BAC2553CB237E7BDA", hash_generated_method = "BA169D4811F8404E07838E9C7665B992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.994 -0400", hash_original_method = "4A9E887CF81CB13B9475E90E8F7B101A", hash_generated_method = "31BEBF0683E37B5AB539D6A7239D34B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addTouchables(ArrayList<View> views) {
        dsTaint.addTaint(views.dsTaint);
        int viewFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.994 -0400", hash_original_method = "D80138743E3873A119DEBFC486319C6F", hash_generated_method = "D9C0700D2F0DCB055FBA2D47D0988DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocus() {
        boolean varB33B1AB5B273EC528C5AE67F69172D01_1395821928 = (requestFocus(View.FOCUS_DOWN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestFocus(View.FOCUS_DOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.995 -0400", hash_original_method = "0231248B41677D14ABD4C75C00BF9F51", hash_generated_method = "24D0EC72C34C4FC8B920B6873496C010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocus(int direction) {
        dsTaint.addTaint(direction);
        boolean varBEB132F64DDBBBEA263C94C9131D5FCE_222429276 = (requestFocus(direction, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return requestFocus(direction, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.995 -0400", hash_original_method = "4D4D948013EFF9FDAFD5232E182C7F46", hash_generated_method = "BCB55CDF1EA2C12B08858C63B159F6F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            boolean varD02361A86C03997E5AE6B9686A81F1C2_1038713210 = (isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE)));
        } //End collapsed parenthetic
        {
            boolean varFCFFB1819C9B89AC39385EED17BA34F3_423939696 = (hasAncestorThatBlocksDescendantFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.995 -0400", hash_original_method = "7FA91653ABFF57A00EB7068CB83E321B", hash_generated_method = "192FCA32F415FFBCFB8167791CE582C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ViewRootImpl getViewRootImpl() {
        View root;
        root = getRootView();
        {
            Object var58F909C9DCF59E4BF5035C4CA0678945_2025190020 = ((ViewRootImpl)root.getParent());
        } //End flattened ternary
        return (ViewRootImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View root = getRootView();
        //return root != null ? (ViewRootImpl)root.getParent() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.995 -0400", hash_original_method = "1F9F6F0DA182BB29AC330886C262C4C3", hash_generated_method = "C12F5CD79829072AB098437269CADCF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestFocusFromTouch() {
        {
            boolean varA7F65F2C3551E1C19C22954843677DD3_193610425 = (isInTouchMode());
            {
                ViewRootImpl viewRoot;
                viewRoot = getViewRootImpl();
                {
                    viewRoot.ensureTouchMode(false);
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean varB33B1AB5B273EC528C5AE67F69172D01_1726122915 = (requestFocus(View.FOCUS_DOWN));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.996 -0400", hash_original_method = "AF1FEBD7D3DF68D5685D255FEFA73D33", hash_generated_method = "F5FFD4434FCC0B05CADF7CB5D2420C9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasAncestorThatBlocksDescendantFocus() {
        ViewParent ancestor;
        ancestor = mParent;
        {
            ViewGroup vgAncestor;
            vgAncestor = (ViewGroup) ancestor;
            {
                boolean var6A93B533F786283E71D28D2D3BB8654E_1721587837 = (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.996 -0400", hash_original_method = "9E8D01E3E35914BE1B580652C44B6D92", hash_generated_method = "4068A66B11C8A715D0155C9B0F768AA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchStartTemporaryDetach() {
        onStartTemporaryDetach();
        // ---------- Original Method ----------
        //onStartTemporaryDetach();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.996 -0400", hash_original_method = "7B585748E6C2A3CE6D3BA7FDB91AA5A9", hash_generated_method = "835E4082F4217105CFFD467CF28422B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onStartTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
        // ---------- Original Method ----------
        //removeUnsetPressCallback();
        //mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.996 -0400", hash_original_method = "07C22BEB43BC8453BE2AEA4BC85C2345", hash_generated_method = "3223FB93CB255E66A3AC95410D228D51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
        // ---------- Original Method ----------
        //onFinishTemporaryDetach();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.996 -0400", hash_original_method = "B87297DA0096F2C31AB92D13B4246B81", hash_generated_method = "25EA709CBA250441F08254F97B05DEE6")
    @DSModeled(DSC.SAFE)
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.997 -0400", hash_original_method = "5346C33A691675BA7E77EC00779EE7C7", hash_generated_method = "8C78BB18479CBD0E9DCBA21E3AA27655")
    @DSModeled(DSC.SAFE)
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return (KeyEvent.DispatcherState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.997 -0400", hash_original_method = "6BC846EF16EEF6AFE683BBB51F853755", hash_generated_method = "5E31624DAC6BFC3053969C4B5739F5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean varA1D1F09794689B9E696354A29B1E7AC6_9191494 = (onKeyPreIme(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onKeyPreIme(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.997 -0400", hash_original_method = "E10762B11C67C141BFF5425226FAC8FB", hash_generated_method = "C37CF8BD79EA97AC82931CE336E75EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean var1AD81DB769C1B29F43EBC2BE5F7D22DB_2074144643 = (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event));
        } //End collapsed parenthetic
        {
            boolean varE1E9B80914776D83D3B032515F60B979_1074606766 = (event.dispatch(this, mAttachInfo != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.997 -0400", hash_original_method = "24CC3891BCF06B080FB3833309F877D3", hash_generated_method = "A93A33900522FC5C7B660055E1196D72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean varB65319FC5255424F872A964CBDE1432E_1476726012 = (onKeyShortcut(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.998 -0400", hash_original_method = "600B8A393DB97B903182B7AB1891AC3E", hash_generated_method = "8B9A0DC5236F987AE23CC09DC9DD386B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTouchEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
        {
            boolean var6607193D9DAC59E34045E90E7ECB0599_1258664866 = (onFilterTouchEventForSecurity(event));
            {
                ListenerInfo li;
                li = mListenerInfo;
                {
                    boolean var710CB5FED0ECEB52EC22DD1CD141A5D7_1805627644 = (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event));
                } //End collapsed parenthetic
                {
                    boolean var430E552CCD38EECE5F1A81AADC330527_1565641211 = (onTouchEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.998 -0400", hash_original_method = "D22D4E22492930B2B9E3C8840958D4D7", hash_generated_method = "B248E925945BCB90521D57C0E47ADB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var702D316B06A93F4CCE85A9302F846D5C_2067718591 = ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.998 -0400", hash_original_method = "7D8730AF428F1F83C6EA34686735DEE9", hash_generated_method = "D86964CE1847DE8D0F0D314B93DBDFE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTrackballEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        boolean var138C9D0D373C5EB915EF41E377253C34_266104953 = (onTrackballEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        //}
        //return onTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.999 -0400", hash_original_method = "4D54FFDFE0E351BCF8C37A3BD601042A", hash_generated_method = "182DE8A8B96B00C0FFD38C0AD2532FAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        int source;
        source = event.getSource();
        {
            int action;
            action = event.getAction();
            {
                {
                    boolean varB883F6E8D34F34A7AC9A1C8473B6C6B6_1185879894 = (dispatchHoverEvent(event));
                } //End collapsed parenthetic
            } //End block
            {
                boolean var2FA64A05C793C37BF00E4ECBCAD6D479_717161082 = (dispatchGenericPointerEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var1E07621182DE67A8830891F3EE4A3942_1867527984 = (dispatchGenericFocusedEvent(event));
        } //End collapsed parenthetic
        {
            boolean varB9448C36962D13B58BD66CC5B67304A5_72019296 = (dispatchGenericMotionEventInternal(event));
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.999 -0400", hash_original_method = "C7F259FDC1DD0446D3E9FDACCE813628", hash_generated_method = "286781F935C415C482540B2BE31E360B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchGenericMotionEventInternal(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean varF5508584668781871F7A8EEF6203DF63_49964098 = (li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event));
        } //End collapsed parenthetic
        {
            boolean varB02F8946AC0F1C42DF139AA516995E2E_1414875686 = (onGenericMotionEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.999 -0400", hash_original_method = "648EC8AE542E2EA418563108E4E24BE8", hash_generated_method = "A5D5FA7510B65B2B9AEF56FE18EC0EB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean dispatchHoverEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean varE708EAD4945B3336974BCEC5E5692CEB_1575533826 = (li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event));
        } //End collapsed parenthetic
        boolean var20FA514C60FFF8C5D29FC4243A17D964_1817197540 = (onHoverEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.999 -0400", hash_original_method = "6C63870709E0BCE3150AB1DBD762BE1B", hash_generated_method = "BB4E2126BF90EED80340916D007A9719")
    @DSModeled(DSC.SAFE)
    protected boolean hasHoveredChild() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.000 -0400", hash_original_method = "3E380A63A40D63CB8A25C818C007B9B3", hash_generated_method = "C2A8E9ACF9C052CC70A114BAAC954CFE")
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.000 -0400", hash_original_method = "A2221AB8B5038CA8B5C4F66BF8310DCB", hash_generated_method = "B28EEE4137E3E517B0BA69B43BE133F5")
    @DSModeled(DSC.SAFE)
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.000 -0400", hash_original_method = "5F3F937CAC1AD8405FC854A70098D82C", hash_generated_method = "1105F5EFE94C01F4A8056122BE1CE3E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean dispatchPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var15DC5053D55881959B9A5AB5DA0AE67E_1364897893 = (event.isTouchEvent());
            {
                boolean varB6BDA87406308A510ABCADF589E94032_565208956 = (dispatchTouchEvent(event));
            } //End block
            {
                boolean var34A3B038B9117B3BA5FBBDB0BBF251D9_1450772456 = (dispatchGenericMotionEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.000 -0400", hash_original_method = "F6C86F5501B65BFAFB8121E3F717BD02", hash_generated_method = "985401F1070CC6A67CD0171EA583EAC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        dsTaint.addTaint(hasFocus);
        onWindowFocusChanged(hasFocus);
        // ---------- Original Method ----------
        //onWindowFocusChanged(hasFocus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.000 -0400", hash_original_method = "F57E7738E41C9719BB0FA37E2B51EE61", hash_generated_method = "8F66BC15E550D69ADB11297A692F7309")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            {
                boolean varF27F491A5EAB0B2989FBEF44657192A7_148607295 = (isPressed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "43B27055CE530161D72F65ED0A59B9EC", hash_generated_method = "FA16F072EF1FE744401DAF737BD0BCD7")
    @DSModeled(DSC.SAFE)
    public boolean hasWindowFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHasWindowFocus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "5A92DDE8F02B8EC7BB05F90066C877DB", hash_generated_method = "9803A8FC4922A7B05A789FB96ABA0CFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        onVisibilityChanged(changedView, visibility);
        // ---------- Original Method ----------
        //onVisibilityChanged(changedView, visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "96367A8B641E87C53B477CCACD2EFDC5", hash_generated_method = "F7BF1451D6A943DD2778CD4FF7B7C566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "5C1461045BB49CF5D091FC620162B930", hash_generated_method = "EFC134E8BB3E4AE727B245482B179743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchDisplayHint(int hint) {
        dsTaint.addTaint(hint);
        onDisplayHint(hint);
        // ---------- Original Method ----------
        //onDisplayHint(hint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "5A8656B423BEB4FF4CA5CD6E6B7C0CE2", hash_generated_method = "64AD0BDDBB165953AFF09665D839E182")
    @DSModeled(DSC.SAFE)
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.001 -0400", hash_original_method = "3D097367CCB5A92F4CA94066B4093669", hash_generated_method = "5553D1D2D981C0843835BA6DAE1E8039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchWindowVisibilityChanged(int visibility) {
        dsTaint.addTaint(visibility);
        onWindowVisibilityChanged(visibility);
        // ---------- Original Method ----------
        //onWindowVisibilityChanged(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.002 -0400", hash_original_method = "B52A85A1B1D14AC974ADC7B2B6CB318A", hash_generated_method = "FF9F3DE3D47252016B0C3B5C33CC85D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.002 -0400", hash_original_method = "B335923547853AC72EE9B6DCDADA38B5", hash_generated_method = "A408D603B5F93AC0E3DB1F4883A747CC")
    @DSModeled(DSC.SAFE)
    public int getWindowVisibility() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.002 -0400", hash_original_method = "D236207A35AB4B4964A2350C5EB42480", hash_generated_method = "86B949B3839FEB5ECEAE73A1B6A35E4F")
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
            Rect insets;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.003 -0400", hash_original_method = "54CB795C069B52CC42B32E2AD26066B2", hash_generated_method = "B5A05DB162E9C89310A561337E4B26BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchConfigurationChanged(Configuration newConfig) {
        dsTaint.addTaint(newConfig.dsTaint);
        onConfigurationChanged(newConfig);
        // ---------- Original Method ----------
        //onConfigurationChanged(newConfig);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.003 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "7E6BC7F584BBEA5DEA1D6F0326806365")
    @DSModeled(DSC.SAFE)
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.003 -0400", hash_original_method = "4092DD0F41D441E58BB892F3C094C4B3", hash_generated_method = "E2F2510F287A05D7132C11F0E9ABA0BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchCollectViewAttributes(int visibility) {
        dsTaint.addTaint(visibility);
        performCollectViewAttributes(visibility);
        // ---------- Original Method ----------
        //performCollectViewAttributes(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.003 -0400", hash_original_method = "01D7FE9ADD969187268E5CA00DFC8244", hash_generated_method = "8CAA4B3E84AD9817BF9DADCCE30E23CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.004 -0400", hash_original_method = "9FE32A4CBB26C218394F35C255A8CF99", hash_generated_method = "10AB5130E3C9EFFD96E5C811DC64FD89")
    @DSModeled(DSC.SAFE)
     void needGlobalAttributesUpdate(boolean force) {
        dsTaint.addTaint(force);
        AttachInfo ai;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.004 -0400", hash_original_method = "ED47CAF0B3847455A70DC2CFF6AB9C90", hash_generated_method = "C2F34A4CA1F19D2E0829469FB67406C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @ViewDebug.ExportedProperty
    public boolean isInTouchMode() {
        {
            boolean varFF1875034CF47A81AA6602BEECB01842_565099543 = (ViewRootImpl.isInTouchMode());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mInTouchMode;
        //} else {
            //return ViewRootImpl.isInTouchMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.005 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "A05140980C469E6688E8E7352B53E370")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.006 -0400", hash_original_method = "3F070CAC61386FAD746F2003533AED25", hash_generated_method = "2D43C4D90BB4F2A978E2A154A9FB724D")
    @DSModeled(DSC.SAFE)
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.006 -0400", hash_original_method = "30943D321BC4BC956C4D9D744FC13942", hash_generated_method = "D048A4906413EA607CB1A49BFDF2D526")
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
                boolean var213035B3AC0E21AB8BF383FF63EBF5BC_1370937171 = (((mViewFlags & CLICKABLE) == CLICKABLE ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.006 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "121675FEA65080179B4E07A9D8940A28")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.006 -0400", hash_original_method = "5AB62313644D9CD032AD8CDBAB33BB4C", hash_generated_method = "D394A6E677A8C3D30A43D0AFAE7CAC53")
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
                boolean var22CDF6A8C6A4F6AF8C611FA66D791C64_2052369731 = ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "04DCF4ED60D6FB5861B483E64E603EE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "7AE552AEBA435B6260303AF26A8BCBA8")
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "47FC099EDD591711C69A21361EB96357", hash_generated_method = "3F85064471F487758ABFFC55DC24A8D2")
    @DSModeled(DSC.SAFE)
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "0601401EB37355AF70FCC37B4ABEB0DF", hash_generated_method = "A79706C2FCA36539E1BCA4F8E6115E56")
    @DSModeled(DSC.SAFE)
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "225D79BB0F164EDB8833C9EDCA3E1422", hash_generated_method = "2D32B4D24453338E64F58486CE131D59")
    @DSModeled(DSC.SAFE)
    public boolean checkInputConnectionProxy(View view) {
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.007 -0400", hash_original_method = "3CE367A3F7143B170AAF00E81005E914", hash_generated_method = "8B7481EAD1FDB2A695BC0CA6C93085AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.008 -0400", hash_original_method = "5F63695E16A345A992F87C295B6530DF", hash_generated_method = "A70F4FBC9DA75644A6C6D80590DCBB6F")
    @DSModeled(DSC.SAFE)
    protected ContextMenuInfo getContextMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.008 -0400", hash_original_method = "6522DD22D3C6D7A95FA248A3D5D95901", hash_generated_method = "A882E0680417B8462F720774A5E42BAF")
    @DSModeled(DSC.SAFE)
    protected void onCreateContextMenu(ContextMenu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.008 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "833D77A11226C846CBB638957F249990")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.008 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "ED84870AAC7E1EEE24DEDDB0C34D9E1A")
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.009 -0400", hash_original_method = "5922A88C022E21B0C70489BC0DBE35EF", hash_generated_method = "E56EBAC69711C653FADECD55DF9A103B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        int action;
        action = event.getAction();
        {
            {
                boolean var50C2C1648FCAD417F5DFCEAC97574026_920635065 = ((action == MotionEvent.ACTION_HOVER_ENTER
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
                boolean var96DFD226589477FD552DD4E5C844A258_629388765 = (action == MotionEvent.ACTION_HOVER_EXIT
                    || (action == MotionEvent.ACTION_HOVER_MOVE
                            && !pointInView(event.getX(), event.getY())));
                {
                    mSendingHoverAccessibilityEvents = false;
                    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_EXIT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var25FE040CDD1CBE5B8AA6184119AEA24C_882897069 = (isHoverable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.009 -0400", hash_original_method = "B9B35BD663CAB028DDAC5D67FB09103D", hash_generated_method = "695BE8DE7C949A5A41A2AA7A4EFBF8E7")
    @DSModeled(DSC.SAFE)
    private boolean isHoverable() {
        int viewFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.009 -0400", hash_original_method = "0724AE81F4A3A3591BB9677111DA3959", hash_generated_method = "A110CEDB46DB7D87447DB44AB2B9849F")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isHovered() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & HOVERED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.009 -0400", hash_original_method = "6A44BB0DB1E9547ADB3859B33BB1BB33", hash_generated_method = "E3F7A9F6F6B3E4B2F1082431290D6990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.009 -0400", hash_original_method = "E702D19B1B952DDC0E28AFCA7C53007F", hash_generated_method = "340C27186D56F6F14C56ED48ECA8938B")
    @DSModeled(DSC.SAFE)
    public void onHoverChanged(boolean hovered) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hovered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.010 -0400", hash_original_method = "F0667DD3F99E763B1BFE85806FBAFB16", hash_generated_method = "2D6EDA003FE7918245993B154E8054F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        int viewFlags;
        viewFlags = mViewFlags;
        {
            {
                boolean var603A4D4D69ECAA84FEB3324C67F6C844_1333207804 = (event.getAction() == MotionEvent.ACTION_UP && (mPrivateFlags & PRESSED) != 0);
                {
                    mPrivateFlags &= ~PRESSED;
                    refreshDrawableState();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var2FD9894A0B8D17E7D63035FBAFAC4F4A_870944797 = (mTouchDelegate.onTouchEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                Object var96ADA7CB150D39A55358E742474108F2_1772279516 = (event.getAction());
                //Begin case MotionEvent.ACTION_UP 
                boolean prepressed;
                prepressed = (mPrivateFlags & PREPRESSED) != 0;
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                {
                    boolean focusTaken;
                    focusTaken = false;
                    {
                        boolean var4010B45C9110D5523B114A445C2F69F9_1165489063 = (isFocusable() && isFocusableInTouchMode() && !isFocused());
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
                                boolean var7529B8C360AE15DA8B22EFD2F54DEBE4_862452545 = (!post(mPerformClick));
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
                        boolean var78C79A084528017AFFB727F82C6C54F8_119853857 = (!post(mUnsetPressedState));
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
                    boolean var05FA8261FD36A1DB58AD7618577A33AB_497230316 = (performButtonActionOnTouchDown(event));
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
                int x;
                x = (int) event.getX();
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_MOVE 
                int y;
                y = (int) event.getY();
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_MOVE 
                {
                    boolean var08A986E19E681C372CEFA5E47F3A6BEE_633900047 = (!pointInView(x, y, mTouchSlop));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.011 -0400", hash_original_method = "7808B21D2BE87077131F031A801646DE", hash_generated_method = "AFA087ECA6B79698C9FA897BD871445E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInScrollingContainer() {
        ViewParent p;
        p = getParent();
        {
            {
                boolean var4881E0F2577352AD9B4EFF88E10A0FFC_1935704360 = (((ViewGroup) p).shouldDelayChildPressedState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.011 -0400", hash_original_method = "A93CC85053AADAF4A404AD13182B9757", hash_generated_method = "4E0E89E0095C87865BEDCEA23B30D854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeLongPressCallback() {
        {
            removeCallbacks(mPendingCheckForLongPress);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingCheckForLongPress != null) {
          //removeCallbacks(mPendingCheckForLongPress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.011 -0400", hash_original_method = "E1C00ACE8BB8560C240B3C5D040006A3", hash_generated_method = "2A0B9175108CA8E4055A6F572B30050D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removePerformClickCallback() {
        {
            removeCallbacks(mPerformClick);
        } //End block
        // ---------- Original Method ----------
        //if (mPerformClick != null) {
            //removeCallbacks(mPerformClick);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.011 -0400", hash_original_method = "6062C7F52024ACE8958D902CC4268271", hash_generated_method = "D17473916BA8EEE9CD65D95E79C2DB43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.011 -0400", hash_original_method = "B67FA3EAF595424C7D0F48DB4ECBF54E", hash_generated_method = "29D4BD3D693368C16CBA0386A785A065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.012 -0400", hash_original_method = "B45EC6A62A5C3981A23AB3F41840A566", hash_generated_method = "B4CC4E5CE3C81DAAFE2FEB90BADA5B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
        // ---------- Original Method ----------
        //removeLongPressCallback();
        //removeTapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.012 -0400", hash_original_method = "8D4D94E2FFA3D8907911FEF22F0F072D", hash_generated_method = "15573115AF3E86DFF34CBB843D8CC1D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeSendViewScrolledAccessibilityEventCallback() {
        {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendViewScrolledAccessibilityEvent != null) {
            //removeCallbacks(mSendViewScrolledAccessibilityEvent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.012 -0400", hash_original_method = "61F54D1D0A5A4D0B5C8BE62B3B180D19", hash_generated_method = "5254A5C27058E8C7823476AD6C645759")
    @DSModeled(DSC.SAFE)
    public void setTouchDelegate(TouchDelegate delegate) {
        dsTaint.addTaint(delegate.dsTaint);
        // ---------- Original Method ----------
        //mTouchDelegate = delegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.012 -0400", hash_original_method = "C13C756E7E3DD9AFF35525DE74B6A0AE", hash_generated_method = "8C2BBF86C2EB0FC21B7951D0594685C0")
    @DSModeled(DSC.SAFE)
    public TouchDelegate getTouchDelegate() {
        return (TouchDelegate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTouchDelegate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.013 -0400", hash_original_method = "DB01C6D64C7923FFF91C0044F6A0DAD3", hash_generated_method = "1E876A9DB30F8CFC4911F675DAC23A85")
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
                    boolean var045EBE37E9FC6E3EB86868C8822165CE_1320321034 = (hasFocus());
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
                boolean varB31FEE083FA3FF4FCB5289BE9151CED2_1434020728 = (((mViewFlags & VISIBILITY_MASK) == INVISIBLE) && hasFocus());
                {
                    {
                        boolean var7EE5FF448100B409C00AA55A4D5A2579_594181250 = (getRootView() != this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.013 -0400", hash_original_method = "D3A1B9777480096EBBD21F82F884FF88", hash_generated_method = "B3254F2076864AE69DB273BC05B806B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bringToFront() {
        {
            mParent.bringChildToFront(this);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.bringChildToFront(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "EDEAEC3E48D287D80E86A711CB6F1FA1", hash_generated_method = "9DB4748EABF6E79BE786E55F88693620")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldt);
        dsTaint.addTaint(t);
        dsTaint.addTaint(oldl);
        dsTaint.addTaint(l);
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_462204081 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                postSendViewScrolledAccessibilityEventCallback();
            } //End block
        } //End collapsed parenthetic
        mBackgroundSizeChanged = true;
        AttachInfo ai;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "B552DCA4F8335CB071F137C97CB4545F", hash_generated_method = "803C60CB95D24628207FB3A69277AC00")
    @DSModeled(DSC.SAFE)
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "60722D2F8A513A457CE7BBFB67142DDA")
    @DSModeled(DSC.SAFE)
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "23990FCA043695388FDF30165FAB53F8", hash_generated_method = "5E1624A66FB6CC96E211FE244D600233")
    @DSModeled(DSC.SAFE)
    public final ViewParent getParent() {
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "A54235C6FCDDA2041C8AFAE3E4C1E483", hash_generated_method = "4FECB0E869FC43EEFF4D776759129874")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollX(int value) {
        dsTaint.addTaint(value);
        scrollTo(value, mScrollY);
        // ---------- Original Method ----------
        //scrollTo(value, mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.014 -0400", hash_original_method = "F511D71F344E6F66807E97ABB51DFE9B", hash_generated_method = "4CCED662C52BDA6DD3A50DDAE55DFADE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollY(int value) {
        dsTaint.addTaint(value);
        scrollTo(mScrollX, value);
        // ---------- Original Method ----------
        //scrollTo(mScrollX, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "D9F07FD9691CD867562496B9D8C346FC")
    @DSModeled(DSC.SAFE)
    public final int getScrollX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "E16F83A4D1F1EA74F021242FFAAAE5D7")
    @DSModeled(DSC.SAFE)
    public final int getScrollY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "FFF18028F96DB13B23AA35EC8A354DA6", hash_generated_method = "C212A34C0444983E3D08B46A5478B541")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRight - mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "DB8E3D4F51A57F2E0389486CC016C662", hash_generated_method = "3B5E5BD68C043FEFF13CF6F7070D4F0A")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom - mTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "7CEA71A6443E0B0137E2E074FCAA909B", hash_generated_method = "DCD77C4151BA58D85A939EAF1D25E00F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.015 -0400", hash_original_method = "A160459557267C576C1546F5990AEB19", hash_generated_method = "2FC18636425367A602FBAB54A32F7CFC")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredWidth & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.016 -0400", hash_original_method = "C38A45A87603EC21B0D791190210A10A", hash_generated_method = "F197032ADEB8E7627A5E99C67962BA41")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredWidthAndState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.016 -0400", hash_original_method = "DA51B2F5E67991A819725ED6FD645434", hash_generated_method = "79A377E34B0FF1E822F3203166BDCC46")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredHeight & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.016 -0400", hash_original_method = "380B2985895F884CFF464A15E274F566", hash_generated_method = "E9A0BE15DDA79BEE71CBD6E04E87DF7C")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredHeightAndState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMeasuredHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.016 -0400", hash_original_method = "12D9B5BDD1AC8F21212E58A2AB0D2736", hash_generated_method = "45152E6F1D1D3C84ACFDAEAB6A4FA3F2")
    @DSModeled(DSC.SAFE)
    public final int getMeasuredState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mMeasuredWidth&MEASURED_STATE_MASK)
                //| ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        //& (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.016 -0400", hash_original_method = "B4B4CEBFEE2F615BED379C4D0CB9432E", hash_generated_method = "D4D41AF2014176514CAD10A2BE658475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static boolean nonzero(float value) {
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.017 -0400", hash_original_method = "5E74D6706011574C7C512DCC96608456", hash_generated_method = "E91D8A344340E850C02041AE6783A782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.017 -0400", hash_original_method = "4153D754422EE39DF2ACBB08A45B169B", hash_generated_method = "BD5D26DA166F862ABB1F598913894B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void ensureTransformationInfo() {
        {
            mTransformationInfo = new TransformationInfo();
        } //End block
        // ---------- Original Method ----------
        //if (mTransformationInfo == null) {
            //mTransformationInfo = new TransformationInfo();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.018 -0400", hash_original_method = "1DF4F5A3EE086291C2134A9A06069FA8", hash_generated_method = "55881855BD2CD810AE16443C261FC35D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateMatrix() {
        TransformationInfo info;
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
                boolean varAB848ECD95BE565B20450DBD0CDBCCC2_2094974229 = (!nonzero(info.mRotationX) && !nonzero(info.mRotationY));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.018 -0400", hash_original_method = "9D52A0CAB8326A9AD998EDD411D2DD92", hash_generated_method = "16C2EAAB20BA606A418259A747E13504")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Matrix getInverseMatrix() {
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.019 -0400", hash_original_method = "210DCA800515E4777DE0E07A52837B76", hash_generated_method = "1A28CC3F1AFB3DD87B962D17C8D6CE6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCameraDistance(float distance) {
        dsTaint.addTaint(distance);
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        float dpi;
        dpi = mResources.getDisplayMetrics().densityDpi;
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.019 -0400", hash_original_method = "6D5D42AE33FC6FF98224E10EE022285B", hash_generated_method = "0BAA5A4868E661A975275106880EB176")
    @DSModeled(DSC.SAFE)
    public float getRotation() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotation : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.020 -0400", hash_original_method = "5A5E2BB985CAA77255785D52BE0C3968", hash_generated_method = "3CD61357AA404DE3060C97536B13225F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRotation(float rotation) {
        dsTaint.addTaint(rotation);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.020 -0400", hash_original_method = "AE949F6C8375A0B1C86B95F13F6ACDFA", hash_generated_method = "0F5894107B01838017567E13ED3BFC63")
    @DSModeled(DSC.SAFE)
    public float getRotationY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.020 -0400", hash_original_method = "5A233F5FAA167B597E6F53F6A1ED05E0", hash_generated_method = "B7C2B6704BDDB516DD56D34FA92D8C8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRotationY(float rotationY) {
        dsTaint.addTaint(rotationY);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.020 -0400", hash_original_method = "A555D00D0BA60E223889AA9DD2F251D5", hash_generated_method = "0A09EDC211590F7667882BBB4F4926AA")
    @DSModeled(DSC.SAFE)
    public float getRotationX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.021 -0400", hash_original_method = "6E42F99146F1D6958E2B3C15F474346C", hash_generated_method = "FC6070E1C49F087CCAC7C53F753C367A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRotationX(float rotationX) {
        dsTaint.addTaint(rotationX);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.021 -0400", hash_original_method = "632CD3DC31F3C9373697ECAF67FAF844", hash_generated_method = "B620E40C3BDC223BF930FCE4DA2CE667")
    @DSModeled(DSC.SAFE)
    public float getScaleX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleX : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.021 -0400", hash_original_method = "5D4E1982532E84086C93276B88F3BB0F", hash_generated_method = "E300628EE29E921327B9472B6D8931AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScaleX(float scaleX) {
        dsTaint.addTaint(scaleX);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.021 -0400", hash_original_method = "0DC96E7C5CC6BBD5C09BD0CF27C74A57", hash_generated_method = "BF6FBD25E15AFF36B58512E10AEA826A")
    @DSModeled(DSC.SAFE)
    public float getScaleY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleY : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.021 -0400", hash_original_method = "31C6EE08A123288B2AD5FB7A2AB8A50C", hash_generated_method = "84C09FD3CC5D3F596640068A48F57F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScaleY(float scaleY) {
        dsTaint.addTaint(scaleY);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.022 -0400", hash_original_method = "AEC7496CCA4C936C6BC2B5B4BAFC57DA", hash_generated_method = "AA7C2F55B551BDB4F1954FCE3C2BB44D")
    @DSModeled(DSC.SAFE)
    public float getPivotX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.022 -0400", hash_original_method = "DBB537948450A8273883C6E25FB642C5", hash_generated_method = "5A70A061DC3A9ED9AB0DB93FB4C1CFF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPivotX(float pivotX) {
        dsTaint.addTaint(pivotX);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.022 -0400", hash_original_method = "0240E9206D9E9715A6B3E78480FB3A00", hash_generated_method = "11BA78F6E68C12A9A7A61574D0AC8362")
    @DSModeled(DSC.SAFE)
    public float getPivotY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.022 -0400", hash_original_method = "6A61D38311657070A62B2EA4ECB210D8", hash_generated_method = "BA26F6BEB67EC43E18D0D2305FF4065D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPivotY(float pivotY) {
        dsTaint.addTaint(pivotY);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.022 -0400", hash_original_method = "93EFA4392922E182D3B77409B1564364", hash_generated_method = "B7FCD83DBCBA5F805507841A5E3D4851")
    @DSModeled(DSC.SAFE)
    public float getAlpha() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mAlpha : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.023 -0400", hash_original_method = "D47D7B67C2848D6684CE263C68979D07", hash_generated_method = "65089AF3CEEA4C16ADEE24C85AA3D1CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
        {
            boolean var27A92F9962D09A8451E041A66077AE9B_1481681499 = (onSetAlpha((int) (alpha * 255)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.023 -0400", hash_original_method = "3CB99BAEF01722CCB474EC85E6659EEE", hash_generated_method = "A5234807763318BED7F80CBF5CC94025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.023 -0400", hash_original_method = "7F5BCC343553D8AF12DD736B7A32ED37", hash_generated_method = "9BD718C5033BE770D9CBEA5543E7688B")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.023 -0400", hash_original_method = "B40CE7C2F79D3592297A6568172CADD8", hash_generated_method = "A8BEF222E7C8CDB972251E6750BC93D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setTop(int top) {
        dsTaint.addTaint(top);
        {
            updateMatrix();
            boolean matrixIsIdentity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.024 -0400", hash_original_method = "D7B6007ED4F8CEAF5E034DAB4DC51ADC", hash_generated_method = "17A7B7DBB252BADE25297AA79D3625FA")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.024 -0400", hash_original_method = "389E1BFAE78D9C18A209C3C1F1063911", hash_generated_method = "44CC9C40372C1C65816B44E3E0D9BAD9")
    @DSModeled(DSC.SAFE)
    public boolean isDirty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & DIRTY_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.024 -0400", hash_original_method = "23478A87AB3417F9EDAE904815FA444D", hash_generated_method = "3FD9D5955A5122800E6FFFED39246E62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setBottom(int bottom) {
        dsTaint.addTaint(bottom);
        {
            updateMatrix();
            boolean matrixIsIdentity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.024 -0400", hash_original_method = "73B96062BAB5FB21A32F13529B38306E", hash_generated_method = "52B120EBDA60AD22E74B8C95A57957BB")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.025 -0400", hash_original_method = "400602AE9C159A853CD1519C8EEA2C4D", hash_generated_method = "91868BABAB75E1BDF9D004C975388BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setLeft(int left) {
        dsTaint.addTaint(left);
        {
            updateMatrix();
            boolean matrixIsIdentity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.025 -0400", hash_original_method = "BAA591F437367FFFE3E50F2B2874B150", hash_generated_method = "35976B764A1CF501B135ED45B55C51C2")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public final int getRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.025 -0400", hash_original_method = "2D86637EDDF21E63210ED8568FEA8F8B", hash_generated_method = "F72306FA27A1CB0D5050D5D17AD5CA99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setRight(int right) {
        dsTaint.addTaint(right);
        {
            updateMatrix();
            boolean matrixIsIdentity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.025 -0400", hash_original_method = "245DBA10F47190D5F336E33CB089C2B3", hash_generated_method = "F616A88DDE396ECF9781D905645E2035")
    @DSModeled(DSC.SAFE)
    public float getX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.026 -0400", hash_original_method = "CF32EA1F394F68FC79E0B0DE51F0C329", hash_generated_method = "1CE053C5CDD6A53CC6541980EC90F4F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setX(float x) {
        dsTaint.addTaint(x);
        setTranslationX(x - mLeft);
        // ---------- Original Method ----------
        //setTranslationX(x - mLeft);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.026 -0400", hash_original_method = "52DD2F53B3B778139AEDE644F53CC413", hash_generated_method = "025614A4D781FF69B747ACACC9A506BB")
    @DSModeled(DSC.SAFE)
    public float getY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.026 -0400", hash_original_method = "17990A784E3651A021C8D9C97053B995", hash_generated_method = "11E409F05C5655796FBCF945F996BB7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setY(float y) {
        dsTaint.addTaint(y);
        setTranslationY(y - mTop);
        // ---------- Original Method ----------
        //setTranslationY(y - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.026 -0400", hash_original_method = "A376723ACFB723DF70FCDB72B84F3B74", hash_generated_method = "70A2AA30BF25910642435D52FE15BDFD")
    @DSModeled(DSC.SAFE)
    public float getTranslationX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.026 -0400", hash_original_method = "099C9E42CAA9B2F0466F96FB99A2B049", hash_generated_method = "22E9DD2E709B50CCD03E987FF4C11FD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTranslationX(float translationX) {
        dsTaint.addTaint(translationX);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.027 -0400", hash_original_method = "3533DDBA4926D8143F5FEBC602AC7438", hash_generated_method = "C0F7DA94E09717E4580C0F4BBCB2EDBA")
    @DSModeled(DSC.SAFE)
    public float getTranslationY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.027 -0400", hash_original_method = "162C2FF9FF4565DE36BAE7FE449EEB59", hash_generated_method = "CE7DF37D20B82BEC9A466B325A041C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTranslationY(float translationY) {
        dsTaint.addTaint(translationY);
        ensureTransformationInfo();
        TransformationInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.027 -0400", hash_original_method = "02B92D2EDB4EF774368BD328DB9464D0", hash_generated_method = "3D2BAD5A35C3DEA29D39035C7136844C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastTranslationX(float x) {
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.027 -0400", hash_original_method = "7A3DD70389071B86917A72495144388B", hash_generated_method = "A14D9EEB9038321F108E8FCD461339E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastTranslationY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.027 -0400", hash_original_method = "27E5E5A6B58B43EDE1C38FBEFFB0B4F7", hash_generated_method = "02177CBB677C2D14DEC6581A64162AAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastX(float x) {
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x - mLeft;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.028 -0400", hash_original_method = "435AAC5941937B26A66754F689D5E36E", hash_generated_method = "364FD35D69B111E79EB45FAE3CF7F3EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y - mTop;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.028 -0400", hash_original_method = "8FBF5EB14D6023B3D32370623C07D6EB", hash_generated_method = "94A33DFA1FBDDD9D8454DD00AF666A17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastScaleX(float x) {
        dsTaint.addTaint(x);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.028 -0400", hash_original_method = "AA6BDD2065E69990CAD75C2A9525B2D0", hash_generated_method = "F977528AECBCD9868EBB89A95F3457E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastScaleY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.028 -0400", hash_original_method = "AD7F6BBA7BB1872387A16DCF0021D7AA", hash_generated_method = "168DC9FFE606A104FB6BA18BC0DD7A2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastAlpha(float alpha) {
        dsTaint.addTaint(alpha);
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.028 -0400", hash_original_method = "3ADB507BF62ACDA7E6B7E6725B1B98A0", hash_generated_method = "1843FEE1F6EAE315BFD9F91C98D72DA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastRotationY(float y) {
        dsTaint.addTaint(y);
        ensureTransformationInfo();
        TransformationInfo info;
        info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mRotationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.029 -0400", hash_original_method = "CD4FEC45EB5F7DBC5B440DED4446311E", hash_generated_method = "4F45A22FACB51483C2020983EB022995")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getHitRect(Rect outRect) {
        dsTaint.addTaint(outRect.dsTaint);
        updateMatrix();
        TransformationInfo info;
        info = mTransformationInfo;
        {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } //End block
        {
            RectF tmpRect;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.029 -0400", hash_original_method = "E2A76004025C1F44E382F6372B86BB53", hash_generated_method = "DE7E8F2E6E03D969A5E4D90F21532AFF")
    @DSModeled(DSC.SAFE)
    final boolean pointInView(float localX, float localY) {
        dsTaint.addTaint(localX);
        dsTaint.addTaint(localY);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return localX >= 0 && localX < (mRight - mLeft)
                //&& localY >= 0 && localY < (mBottom - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.029 -0400", hash_original_method = "D00244756776E7D2FD65633E1CF43263", hash_generated_method = "C05F647BA041BCE59315C049CA50CE22")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.029 -0400", hash_original_method = "DDDABA6E6D899E7EA47B4452312088BE", hash_generated_method = "57FD9B1916CE444D04635E50B178244D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getFocusedRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        getDrawingRect(r);
        // ---------- Original Method ----------
        //getDrawingRect(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.030 -0400", hash_original_method = "24BDD9FA3E3C2FB6EA31ED75B384BDD9", hash_generated_method = "9AEDE1E93CC54192DCE0F0E7E7E19DFA")
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
            boolean varD0C4A40C45EF46AFF22F080E1528CE15_474816326 = (mParent == null || mParent.getChildVisibleRect(this, r, globalOffset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.030 -0400", hash_original_method = "EADCD4C63731C6547F1C03CEAFC09A53", hash_generated_method = "A1AC2F954326C059F457AD2DF23E9FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getGlobalVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varA0E19E10963694B496EAF71FD83982B3_658105883 = (getGlobalVisibleRect(r, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getGlobalVisibleRect(r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.030 -0400", hash_original_method = "CB024757CF5A14ECB6F9DCD9789CD2F8", hash_generated_method = "24653A1C2342222A23B225DC415C4229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean getLocalVisibleRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        Point offset;
        offset = new Point();
        {
            boolean varBBF18CCA515610662C9382F2D4C23619_671975039 = (getGlobalVisibleRect(r, offset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.030 -0400", hash_original_method = "5A4ADD2D1ADF5703ED27FAE1582BB62A", hash_generated_method = "4C43D5DF33EC8173B1EFB1B8A445F319")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void offsetTopAndBottom(int offset) {
        dsTaint.addTaint(offset);
        {
            updateMatrix();
            boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                ViewParent p;
                p = mParent;
                {
                    Rect r;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.031 -0400", hash_original_method = "A934BA60BC3812BC980C4328CCEB9557", hash_generated_method = "FDD4AD1283D0B96A82C21400CF21E3CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void offsetLeftAndRight(int offset) {
        dsTaint.addTaint(offset);
        {
            updateMatrix();
            boolean matrixIsIdentity;
            matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                ViewParent p;
                p = mParent;
                {
                    Rect r;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.031 -0400", hash_original_method = "5EB740A9A129A62709C940CDC3C1FA90", hash_generated_method = "F2D37A5566CE6BF257CBFE9D7909DBEB")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.031 -0400", hash_original_method = "279E70A70FA2B2FEFF6E7E1E87EEDC2B", hash_generated_method = "D71DA6E7F404823EC781209452C019CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.031 -0400", hash_original_method = "C9DC0366B539164245F3B3ACA0A07797", hash_generated_method = "8F52FFFC3C9DD360E307338FB85C1C88")
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
                boolean varC828E793AFDA5CD988FA9008B6EB3B30_1960023782 = (!awakenScrollBars());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.032 -0400", hash_original_method = "9A3BFF0D9282AAB8B07B22048D68076B", hash_generated_method = "10A1E56BD9FBCB5EA36A9C3A7BE33C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scrollBy(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        scrollTo(mScrollX + x, mScrollY + y);
        // ---------- Original Method ----------
        //scrollTo(mScrollX + x, mScrollY + y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.032 -0400", hash_original_method = "08F687B40826EF7DBBF2573184DC2210", hash_generated_method = "9D43E43107060352EA7FF165A50D734C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars() {
        boolean var70EE0F5768F31DAF2C1A8B4E95A75A4F_1074372634 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.032 -0400", hash_original_method = "2B4CF6E85FAE9FF55F32C24BEFDC5081", hash_generated_method = "995DD3974A8E185F59A7EDCA14F34014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean initialAwakenScrollBars() {
        boolean var92AEF1EA9E316D77EDD85ABCDC19B36B_956316570 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.032 -0400", hash_original_method = "D5CE7E5EDCD7F839910A14AF470AF787", hash_generated_method = "7898E0C527CC80F63E09D2FD65D06645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars(int startDelay) {
        dsTaint.addTaint(startDelay);
        boolean varF0BE7569E2898F8A7748258008B8FAFD_594782307 = (awakenScrollBars(startDelay, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return awakenScrollBars(startDelay, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.033 -0400", hash_original_method = "CAD4350A25772201F660B41D91481A2E", hash_generated_method = "D9F8DD531625EAE805A4C1739706852D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        dsTaint.addTaint(startDelay);
        dsTaint.addTaint(invalidate);
        ScrollabilityCache scrollCache;
        scrollCache = mScrollCache;
        {
            scrollCache.scrollBar = new ScrollBarDrawable();
        } //End block
        {
            boolean var5422F660D44B0D1544FC157071290861_1168455937 = (isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled());
            {
                {
                    invalidate(true);
                } //End block
                {
                    int KEY_REPEAT_FIRST_DELAY;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.033 -0400", hash_original_method = "FC7DFAD8D0391FACDB1212D1D56F8C7D", hash_generated_method = "4BDF917921646E60B0148681780610E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean skipInvalidate() {
        boolean var8D9B0BE46D426CBE2B5119C4603A668E_996758265 = ((mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                //(!(mParent instanceof ViewGroup) ||
                        //!((ViewGroup) mParent).isViewTransitioning(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.033 -0400", hash_original_method = "C9F4885B3240AC42BDB62659847A9804", hash_generated_method = "3C97AA7360F6764845C629082BD22DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidate(Rect dirty) {
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_1298441124 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            ViewParent p;
            p = mParent;
            AttachInfo ai;
            ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } //End block
            } //End block
            {
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                Rect r;
                r = ai.mTmpInvalRect;
                r.set(dirty.left - scrollX, dirty.top - scrollY,
                        dirty.right - scrollX, dirty.bottom - scrollY);
                mParent.invalidateChild(this, r);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.034 -0400", hash_original_method = "ADB8190FF1114977057C1857B6D8BC7D", hash_generated_method = "CCD6A644AA7412AE3A91A02F5E0D0749")
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
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_1984780771 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            ViewParent p;
            p = mParent;
            AttachInfo ai;
            ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } //End block
            } //End block
            {
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                Rect tmpr;
                tmpr = ai.mTmpInvalRect;
                tmpr.set(l - scrollX, t - scrollY, r - scrollX, b - scrollY);
                p.invalidateChild(this, tmpr);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.034 -0400", hash_original_method = "DD9880156AB041E4BB31F756D1AB2189", hash_generated_method = "BF85BB9D7AA11B7869ED1AB59ACA8EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidate() {
        invalidate(true);
        // ---------- Original Method ----------
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.034 -0400", hash_original_method = "2A2B8D7DA5636907090E85C40DC13DF0", hash_generated_method = "84875E858EF77716D73BE3C7C9A25701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void invalidate(boolean invalidateCache) {
        dsTaint.addTaint(invalidateCache);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_915147880 = (skipInvalidate());
        } //End collapsed parenthetic
        {
            boolean var5D4EC7C3849E23BFDACCE7FE932C2ED1_1968588511 = ((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
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
                AttachInfo ai;
                ai = mAttachInfo;
                ViewParent p;
                p = mParent;
                {
                    {
                        p.invalidateChild(this, null);
                    } //End block
                } //End block
                {
                    Rect r;
                    r = ai.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.035 -0400", hash_original_method = "9E49D44B70542B7D202A00B58BCD901B", hash_generated_method = "A5495149884411E14397C2E8C1DAECBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fastInvalidate() {
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_368298331 = (skipInvalidate());
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
                    Rect r;
                    r = mAttachInfo.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    mParent.invalidateChild(this, r);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.035 -0400", hash_original_method = "74A87B1768814B24E7FEDDF99D8537F0", hash_generated_method = "259EF29A518D154D0008BBE13AE3F86A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.035 -0400", hash_original_method = "A648B59C2EE20F29A9B99BF448851618", hash_generated_method = "07A2E42EA0D5DB3A5FE5840F10679374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void invalidateParentIfNeeded() {
        {
            boolean var0CFA59CC9046639DFA3FC76B3FAFF415_494723742 = (isHardwareAccelerated() && mParent instanceof View);
            {
                ((View) mParent).invalidate(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isHardwareAccelerated() && mParent instanceof View) {
            //((View) mParent).invalidate(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.035 -0400", hash_original_method = "E9C24F17558159FB485FCFC13D70293E", hash_generated_method = "28AFED2483D3832B8923B51CF2DEFA55")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                //((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        //>= 1.0f - ViewConfiguration.ALPHA_THRESHOLD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.036 -0400", hash_original_method = "497EF7DE92B2945B2FEC8F46EAD33430", hash_generated_method = "2CBE424AEF0918788DB34341EC935FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void computeOpaqueFlags() {
        {
            boolean var4EAF945C1787CBA8CB4548E7AF4BB4B5_990588793 = (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE);
            {
                mPrivateFlags |= OPAQUE_BACKGROUND;
            } //End block
            {
                mPrivateFlags &= ~OPAQUE_BACKGROUND;
            } //End block
        } //End collapsed parenthetic
        int flags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.036 -0400", hash_original_method = "7EE186D55064FCDB5B25DFE594562441", hash_generated_method = "D75DA0561640666017C7824C6BD39E32")
    @DSModeled(DSC.SAFE)
    protected boolean hasOpaqueScrollbars() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.036 -0400", hash_original_method = "DDF5EC42ADE793605447903B93381C32", hash_generated_method = "4922DA4675D64761C806D99498F326EE")
    @DSModeled(DSC.SAFE)
    public Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mHandler;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.036 -0400", hash_original_method = "8EDFE6EE958B917F012E9131A0AEA287", hash_generated_method = "B529B70B72FCCEB5DA1615E4AF88DEEE")
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
        boolean var4B5FBEF08D1252F680BD85D523D3F99E_1885256027 = (handler.post(action));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.037 -0400", hash_original_method = "D354828971EFD085BD14FC0D83048A19", hash_generated_method = "33CBE8412DA28888EB1D2BB3BB9542FE")
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
        boolean varA94056EFF6A774C97C990690CB98EF64_224199736 = (handler.postDelayed(action, delayMillis));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.037 -0400", hash_original_method = "924A8BEE16A312E53AB8660A02DEF27E", hash_generated_method = "263EDA90D0E6EB87C5251AE11F4EAB5B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.037 -0400", hash_original_method = "B784E31CF9F406A65D385399252675E5", hash_generated_method = "E1CD8F02A4425412097D3886A78B39EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postInvalidate() {
        postInvalidateDelayed(0);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.037 -0400", hash_original_method = "F30B35993A01DC68F672A7097988A2B2", hash_generated_method = "21A04B93AAC7BA012253B9AD059F20BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postInvalidate(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        postInvalidateDelayed(0, left, top, right, bottom);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.037 -0400", hash_original_method = "04635C950E88519FA950A99E2186B20C", hash_generated_method = "211782E17927D9D4E5DD012BCA35A7B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.038 -0400", hash_original_method = "2AD5AD2CFDC403E5ADB3F0CF5F7AB2F6", hash_generated_method = "EFC25BC41E032ED6F9468D1FD75D0C70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            AttachInfo.InvalidateInfo info;
            info = AttachInfo.InvalidateInfo.acquire();
            info.target = this;
            info.left = left;
            info.top = top;
            info.right = right;
            info.bottom = bottom;
            Message msg;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.038 -0400", hash_original_method = "BB237226F39DBA7BCAA624BDCB91F777", hash_generated_method = "37B71AD809B5E3FDDFA60D04296093DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.038 -0400", hash_original_method = "7821AAE99E52242CE62352C839CCDCC3", hash_generated_method = "DC60F051596188244856202A1C5C2CDD")
    @DSModeled(DSC.SAFE)
    public void computeScroll() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.038 -0400", hash_original_method = "2F1443E103CAC5C1C2808AA2ECBBD417", hash_generated_method = "83C88D4EA502F66E22570DC55BF104EF")
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalFadingEdgeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.039 -0400", hash_original_method = "EC0EB62D805892CAAD99FC80B5C4BCFE", hash_generated_method = "9ECDFF94DDB25A7E0E10514B8E3F7463")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        dsTaint.addTaint(horizontalFadingEdgeEnabled);
        {
            boolean varA3A448941DEDEC343F4D869D70054393_198243081 = (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.039 -0400", hash_original_method = "DC4B7092961F5604BD589F14B65154AC", hash_generated_method = "507B0914A8FE164A210951AE67F604F5")
    @DSModeled(DSC.SAFE)
    public boolean isVerticalFadingEdgeEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.039 -0400", hash_original_method = "EAF2758FE6F0D2FA48FD42C13EB7A789", hash_generated_method = "E658A087ED73B98CE1F9B9B355B80195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        dsTaint.addTaint(verticalFadingEdgeEnabled);
        {
            boolean var01488E834A57F3E5162EDF629729F011_1484947771 = (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.039 -0400", hash_original_method = "CA0383E2F77249B4067FF4C25AA980FC", hash_generated_method = "4014133D6453EA17D479A7826A3E7A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getTopFadingEdgeStrength() {
        {
            boolean var95C748EB7173291A5F92BA7AE0D550D8_60770599 = (computeVerticalScrollOffset() > 0);
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.040 -0400", hash_original_method = "DD443087D4013745234D8B8402D9412B", hash_generated_method = "1D08EEBF7AEE9BB5D24C672CF40E821E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varD919087A08EBAF1D1A5831A04C61CDFE_791024690 = (computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                //computeVerticalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.040 -0400", hash_original_method = "7D1377787749722D9D47682EF553F1ED", hash_generated_method = "83CE920BB2DF9F556CBBF39BC39FB0B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getLeftFadingEdgeStrength() {
        {
            boolean var7654C1BFABAF507D7C3E35D81F9F8DFD_2054333394 = (computeHorizontalScrollOffset() > 0);
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.040 -0400", hash_original_method = "1558452CB016696B11D09745F34240BE", hash_generated_method = "158FCE7F8F6CCFA3556086D50C803744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getRightFadingEdgeStrength() {
        {
            boolean var769CCFA152889A66107FC92852AF7E99_1037821022 = (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                //computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.040 -0400", hash_original_method = "4C9FBABF966493498122F359EE4D62B4", hash_generated_method = "4A4FCDF9EA32D69204D5A6A2EBA400CF")
    @DSModeled(DSC.SAFE)
    public boolean isHorizontalScrollBarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.041 -0400", hash_original_method = "5F4F07B15655223ADE33A1CCE75F1A0B", hash_generated_method = "2D029A34213D61703A00E238DE8C3CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        dsTaint.addTaint(horizontalScrollBarEnabled);
        {
            boolean varCE11BC275FFF6C79CD0949C3947FA397_343667629 = (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.041 -0400", hash_original_method = "0838EB3187C4C037AF0DBFBDE06C59DB", hash_generated_method = "C4B9FB118ECBCFF0006D999ED75DE70E")
    @DSModeled(DSC.SAFE)
    public boolean isVerticalScrollBarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.041 -0400", hash_original_method = "B0D859209D4F0DED05F4B405F254CC50", hash_generated_method = "ACE583966B7C8EFECE101759DD829ADA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        dsTaint.addTaint(verticalScrollBarEnabled);
        {
            boolean varA8AB3C7A9451600FFE608568BE46B787_1068848091 = (isVerticalScrollBarEnabled() != verticalScrollBarEnabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.041 -0400", hash_original_method = "DC71A98728014C366336C5BC467178FD", hash_generated_method = "796EA4F4D2AC58DE61356F54ACDA4918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void recomputePadding() {
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
        // ---------- Original Method ----------
        //setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.041 -0400", hash_original_method = "2388F31C9368DE1EC14347F689733603", hash_generated_method = "5807EE479FC56DC9B23BB61FE3AAEB08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        dsTaint.addTaint(fadeScrollbars);
        initScrollCache();
        ScrollabilityCache scrollabilityCache;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.042 -0400", hash_original_method = "95A2058DEEA36EE0618643627EDFFE13", hash_generated_method = "904155171782D03C8600B07B5ACF748C")
    @DSModeled(DSC.SAFE)
    public boolean isScrollbarFadingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollCache != null && mScrollCache.fadeScrollBars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.042 -0400", hash_original_method = "A645B31717E594F6C2DC0D0454AA457D", hash_generated_method = "07D57F615D0FAD47A3A9C175DE35DCED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.042 -0400", hash_original_method = "05D4731F6FA79F6CC5101E8AAB13BDF7", hash_generated_method = "64D89FCAA951E61ECB7B71725D3FDC80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.042 -0400", hash_original_method = "70416A9E9D98F77424E9346E007FCC75", hash_generated_method = "D30FCCDB501293BAF8DC552D94B58AAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeHorizontalScrollRange() {
        int varF667BBC2F2CB62FFC46148012DBF7327_1553404242 = (getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.042 -0400", hash_original_method = "1DA5A8790403B0D1F6BBC5796ED90152", hash_generated_method = "779C5BDAFC47F38F97F0AF916E42772F")
    @DSModeled(DSC.SAFE)
    protected int computeHorizontalScrollOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.043 -0400", hash_original_method = "4D7C9CACEB957F5429D7FE01BD0E831F", hash_generated_method = "BB0438251068199BB86208102A384267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeHorizontalScrollExtent() {
        int varF667BBC2F2CB62FFC46148012DBF7327_1817226768 = (getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.043 -0400", hash_original_method = "BA8A199276036F5D8FAFD83598D6B62F", hash_generated_method = "7CAB12E54E9CD8E1930AA5BB09500367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeVerticalScrollRange() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_1035774431 = (getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.043 -0400", hash_original_method = "CE20178D0022D78BDA31343037F660C9", hash_generated_method = "064D3122320F222E3E74182A94CFB076")
    @DSModeled(DSC.SAFE)
    protected int computeVerticalScrollOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.043 -0400", hash_original_method = "3058943AF0E0D63E8ED42ACDC59A7606", hash_generated_method = "C8DE429A91451F77E8BDDC76DB3701A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int computeVerticalScrollExtent() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_26775495 = (getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.043 -0400", hash_original_method = "F18C2F0ACE32F9BDC531C26946C884DB", hash_generated_method = "2C6B1D8472B5DE6CD2AA3EBD541C7D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canScrollHorizontally(int direction) {
        dsTaint.addTaint(direction);
        int offset;
        offset = computeHorizontalScrollOffset();
        int range;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.044 -0400", hash_original_method = "222CDEC9A5062ECAF96BF1766D04B3AA", hash_generated_method = "88D8EA1B1C6DB7EE2E7A62342A49DEF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canScrollVertically(int direction) {
        dsTaint.addTaint(direction);
        int offset;
        offset = computeVerticalScrollOffset();
        int range;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.046 -0400", hash_original_method = "BC6A073022E6E75A0ACBB97281459E6B", hash_generated_method = "8D7D68CFB1A05F6EB209CA76ED9B9EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void onDrawScrollBars(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        ScrollabilityCache cache;
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
                    boolean var34F9F3B00BE1502DFF6FE96B14D049B7_95975729 = (cache.scrollBarInterpolator.timeToValues(values) ==
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
            int viewFlags;
            viewFlags = mViewFlags;
            boolean drawHorizontalScrollBar;
            drawHorizontalScrollBar = (viewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
            boolean drawVerticalScrollBar;
            drawVerticalScrollBar = (viewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL
                && !isVerticalScrollBarHidden();
            {
                int width;
                width = mRight - mLeft;
                int height;
                height = mBottom - mTop;
                ScrollBarDrawable scrollBar;
                scrollBar = cache.scrollBar;
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                int inside;
                inside = ~0;
                inside = 0;
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
                    int verticalScrollBarGap;
                    verticalScrollBarGap = getVerticalScrollbarWidth();
                    verticalScrollBarGap = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.047 -0400", hash_original_method = "27496C077301642151620030AE06D353", hash_generated_method = "7C21E7C7109762EA01790B9C0420EB8C")
    @DSModeled(DSC.SAFE)
    protected boolean isVerticalScrollBarHidden() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.047 -0400", hash_original_method = "2196C3E195A3664813647CA1F4571C34", hash_generated_method = "F651B41809E39A82DA705D3974683DFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.047 -0400", hash_original_method = "4DC59479DF5AED0094F453B5C8C1A8B1", hash_generated_method = "9D2C9247834C07CE10BDCBC37F78BFB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.047 -0400", hash_original_method = "88C9EEC1EB66ECE8EDFB3E744FAAD32C", hash_generated_method = "6EA15FB7C8EE328749ECA06B61B23E29")
    @DSModeled(DSC.SAFE)
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.047 -0400", hash_original_method = "B5B7B4C6E477A3DDB1740C53E1D10BEA", hash_generated_method = "E64C867FB5926AE8E2629839CFAA4058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void assignParent(ViewParent parent) {
        dsTaint.addTaint(parent.dsTaint);
        {
            mParent = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("view " + this + " being added, but"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.048 -0400", hash_original_method = "6BE89DDC01776115240A35D213D194B1", hash_generated_method = "1FE98DD32DB3EE846F1851C89C07394B")
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
            boolean var1C23F183BE3EEE2A8667855A22865324_100695071 = (isFocused());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.048 -0400", hash_original_method = "6355C1E1C593C70CD9AB72CB2C730A4B", hash_generated_method = "0B66215703161E328250218033B5D6C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resolveLayoutDirectionIfNeeded() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED_RTL;
        resetResolvedTextDirection();
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_735250361 = (getLayoutDirection());
            //Begin case LAYOUT_DIRECTION_INHERIT 
            {
                ViewGroup viewGroup;
                viewGroup = ((ViewGroup) mParent);
                {
                    boolean varD7173ED74EF8FD4D8C167811281857D6_1712013925 = (! viewGroup.canResolveLayoutDirection());
                } //End collapsed parenthetic
                {
                    boolean var8E862BF7D39882400271E2867FE65A16_931684611 = (viewGroup.getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
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
                boolean var9876FCC9113762996D6F4DE738D751FA_1693910173 = (isLayoutDirectionRtl(Locale.getDefault()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.048 -0400", hash_original_method = "9FC12AEA6DFF38CE52A88C8E970B863F", hash_generated_method = "57DFC3F1CB587E09AE5AF1189C56C783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void resolvePadding() {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_682132719 = (getResolvedLayoutDirection());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.049 -0400", hash_original_method = "2870C28D9742C58342A5849284011E72", hash_generated_method = "AEB4FBAE92658D68FB3FBD7E8B79C50F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean canResolveLayoutDirection() {
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_710138139 = (getLayoutDirection());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.049 -0400", hash_original_method = "A8A20BDA6F309AE6FE3C70FD4EB76C3B", hash_generated_method = "146E092F23602F5144B45F38ADE2CB14")
    @DSModeled(DSC.SAFE)
    protected void resetResolvedLayoutDirection() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
        // ---------- Original Method ----------
        //mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
    }

    
        protected static boolean isLayoutDirectionRtl(Locale locale) {
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.049 -0400", hash_original_method = "C1067653123E460806048F14F4245D8D", hash_generated_method = "82C2297B1CF23C48EAF943AEB85EF44C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.049 -0400", hash_original_method = "96241ADC2AE65F6434F9D187AAD690E3", hash_generated_method = "0C1F90A99727C017AF4CCB8969A54F4E")
    @DSModeled(DSC.SAFE)
    protected int getWindowAttachCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWindowAttachCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.049 -0400", hash_original_method = "B5E940E178CF821C1ABFCBA8A2963390", hash_generated_method = "CACEC68337EEDC95CB4A3DC94FDD58EF")
    @DSModeled(DSC.SAFE)
    public IBinder getWindowToken() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowToken : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.050 -0400", hash_original_method = "2166F0BF16D53373B488A496114897F8", hash_generated_method = "493A8B52E1EB4A8D64F87C38345A419F")
    @DSModeled(DSC.SAFE)
    public IBinder getApplicationWindowToken() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.050 -0400", hash_original_method = "502E0CC6497F900AADF2990690A51539", hash_generated_method = "002F2A8F62A534F3D0F4B9348B7E723E")
    @DSModeled(DSC.SAFE)
     IWindowSession getWindowSession() {
        return (IWindowSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mSession : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.072 -0400", hash_original_method = "8BF487FADEB8B54B52A076F5E8F3B4CC", hash_generated_method = "638D6F4DC8E458AB91507DB83B8C1174")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(info.dsTaint);
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
        CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;
        listeners = null;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_876760048 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> varE0997CFEC81DEDF84B9808E9E6718DCA_1893438679 = (listeners).iterator();
                    varE0997CFEC81DEDF84B9808E9E6718DCA_1893438679.hasNext();
                    OnAttachStateChangeListener listener = varE0997CFEC81DEDF84B9808E9E6718DCA_1893438679.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.092 -0400", hash_original_method = "6B0EA8A7D63E280C74DFE6EC34A7421B", hash_generated_method = "F588CE8CB54EAFA4365D730F35326D15")
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
        CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;
        listeners = null;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_1789598378 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> varE0997CFEC81DEDF84B9808E9E6718DCA_1539510582 = (listeners).iterator();
                    varE0997CFEC81DEDF84B9808E9E6718DCA_1539510582.hasNext();
                    OnAttachStateChangeListener listener = varE0997CFEC81DEDF84B9808E9E6718DCA_1539510582.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.093 -0400", hash_original_method = "DE35B85EA98822B631F87F0518C5E70D", hash_generated_method = "50E9D6D9BDD5AEF75952BF00DEB73F71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.093 -0400", hash_original_method = "946C013753556BBC605C0B72B86403CC", hash_generated_method = "14312C00A3DE7AAF0FF67E3B89E3810E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.093 -0400", hash_original_method = "071A0CD98D5CB5717BF4FD06D9363A03", hash_generated_method = "CC8D78E5F18FFF6DA11C32A73F8E65A4")
    @DSModeled(DSC.SAFE)
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= SAVE_STATE_CALLED;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mPrivateFlags |= SAVE_STATE_CALLED;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.093 -0400", hash_original_method = "6EAC0E9F5E844401043B6CA1D363D57E", hash_generated_method = "9EBDDE4C7EB4860F33B9AD4B58A03EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.094 -0400", hash_original_method = "1E9589C1E01E87FD9C38DCF9C7B7C90F", hash_generated_method = "2123E7228F262E64038999188CD60A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        {
            Parcelable state;
            state = container.get(mID);
            {
                mPrivateFlags &= ~SAVE_STATE_CALLED;
                onRestoreInstanceState(state);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.094 -0400", hash_original_method = "CCFCBEB3529A8F3F9E941DB1236D802B", hash_generated_method = "A0D5DA9292E1A4D8F077DEA8874F8AB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        mPrivateFlags |= SAVE_STATE_CALLED;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Wrong state class, expecting View State but "
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.094 -0400", hash_original_method = "120BB71A812D687D5EF2F0B8F5C8CCD2", hash_generated_method = "DB66B6B9850B61800EFB6C2894002533")
    @DSModeled(DSC.SAFE)
    public long getDrawingTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mDrawingTime : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.094 -0400", hash_original_method = "CAE567A7C394D0DF999555076FD0D1ED", hash_generated_method = "AD1FA0212984763FAEE0DB7B6AB3372A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDuplicateParentStateEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
        // ---------- Original Method ----------
        //setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.094 -0400", hash_original_method = "AF26528701A515059D58013186164554", hash_generated_method = "6CBF782197B36F0F6796B61645D54B6D")
    @DSModeled(DSC.SAFE)
    public boolean isDuplicateParentStateEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.095 -0400", hash_original_method = "280CFBA803CA9107455CB03D3F8C277D", hash_generated_method = "8451B4F2B3A8F5ACA809D288215EE2B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLayerType(int layerType, Paint paint) {
        dsTaint.addTaint(layerType);
        dsTaint.addTaint(paint.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, "
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
        boolean layerDisabled;
        layerDisabled = mLayerType == LAYER_TYPE_NONE;
        mLayerPaint = layerDisabled ? null : (paint == null ? new Paint() : paint);
        mLocalDirtyRect = layerDisabled ? null : new Rect();
        invalidateParentCaches();
        invalidate(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.095 -0400", hash_original_method = "E009407DF0C30C68D152BB83BB3493E0", hash_generated_method = "76A326EEE10C2CC5542180E8851D8CAD")
    @DSModeled(DSC.SAFE)
     boolean hasStaticLayer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayerType == LAYER_TYPE_NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.095 -0400", hash_original_method = "10BDECB6A9FC24A5B9656AF2BA9D9819", hash_generated_method = "C0FCB5398BA107D74553AA4093A12FB6")
    @DSModeled(DSC.SAFE)
    public int getLayerType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.096 -0400", hash_original_method = "FDD83A77B112AC8CB3AC65707C3CB088", hash_generated_method = "15E29686FE61F1B28C0323B1B35E802C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void buildLayer() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This view must be attached to a window first");
        } //End block
        //Begin case LAYER_TYPE_HARDWARE 
        {
            boolean var938BC3BB177101C2D5D80B665B48EFE4_1250833139 = (mAttachInfo.mHardwareRenderer != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.096 -0400", hash_original_method = "1C756BC3105DE982313252676EF7BEA5", hash_generated_method = "FA8B2636E86D1BBF9511E14932B95CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HardwareLayer getHardwareLayer() {
        {
            boolean var1795335A66B1FC7BB4C3B32BDFD3180D_902738918 = (mAttachInfo == null || mAttachInfo.mHardwareRenderer == null ||
                !mAttachInfo.mHardwareRenderer.isEnabled());
        } //End collapsed parenthetic
        int width;
        width = mRight - mLeft;
        int height;
        height = mBottom - mTop;
        {
            {
                mHardwareLayer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                        width, height, isOpaque());
                mLocalDirtyRect.setEmpty();
            } //End block
            {
                boolean var5013B1CC39A5DD383313D5E39F51669C_1993770077 = (mHardwareLayer.getWidth() != width || mHardwareLayer.getHeight() != height);
                {
                    mHardwareLayer.resize(width, height);
                    mLocalDirtyRect.setEmpty();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var08F8E6CAF5391532E58CACD43013438A_751090039 = (!mHardwareLayer.isValid());
            } //End collapsed parenthetic
            HardwareCanvas currentCanvas;
            currentCanvas = mAttachInfo.mHardwareCanvas;
            HardwareCanvas canvas;
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
                int restoreCount;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.096 -0400", hash_original_method = "46CD3F4D955A0CC35E16981FB59107BF", hash_generated_method = "AC37F61930A65BB251C45B03252D74B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.097 -0400", hash_original_method = "2A28B7876CAFDC07E0FAFA28070957E8", hash_generated_method = "40E2B8629BC48C8FF763F010A3364CFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void destroyHardwareResources() {
        destroyLayer();
        // ---------- Original Method ----------
        //destroyLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.097 -0400", hash_original_method = "8AD6975BC71E736FF7830468F6E8AB45", hash_generated_method = "C8E589553DC907B502E05B8C8A1ADB9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDrawingCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
        // ---------- Original Method ----------
        //mCachingFailed = false;
        //setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.097 -0400", hash_original_method = "B123D3E623B7638C240DD8280788F70C", hash_generated_method = "E688B8C11A411863344A4ACE5155C4D6")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.098 -0400", hash_original_method = "ED3E6074026E0275E7BADCEAD02A1919", hash_generated_method = "5629EFEB214D64DB49F0117351D3723F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            int count;
            count = parent.getChildCount();
            {
                int i;
                i = 0;
                {
                    View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.098 -0400", hash_original_method = "F520ED30BD4141F0E67AE80815EDDC89", hash_generated_method = "7D5447D36AD4507DE6BB8070E0DEAF7B")
    @DSModeled(DSC.SAFE)
    protected void dispatchGetDisplayList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.098 -0400", hash_original_method = "AB7D77CF9F94D5BD05F1DB3F0B62C9D0", hash_generated_method = "71AE735F488BA44C3EB6A2722C4E53B4")
    @DSModeled(DSC.SAFE)
    public boolean canHaveDisplayList() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.099 -0400", hash_original_method = "A79479675DF460DA0EF507C879CE4B27", hash_generated_method = "39B30799ED2632B4404DDEC3931CF72E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DisplayList getDisplayList() {
        {
            boolean var1B563759F0FD29B833433E2C0DB5143B_1424573483 = (!canHaveDisplayList());
        } //End collapsed parenthetic
        {
            boolean varCB7B81962DE3C7E60B368CFD3080CE5F_523414666 = (((mPrivateFlags & DRAWING_CACHE_VALID) == 0 ||
                mDisplayList == null || !mDisplayList.isValid() ||
                mRecreateDisplayList));
            {
                {
                    boolean var7C6A47F38E12A6EB14BB2C741855538D_566762473 = (mDisplayList != null && mDisplayList.isValid() &&
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
                HardwareCanvas canvas;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.099 -0400", hash_original_method = "16C485E3429312C7E841D79823374233", hash_generated_method = "317E4E264153BF5E6E077C86663B1413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getDrawingCache() {
        Bitmap varC02FB90FE084F637ACEE88B420CDF94F_2138755429 = (getDrawingCache(false));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.099 -0400", hash_original_method = "CA92F18E14EB0519BF84A3C226CE3F4A", hash_generated_method = "A2BA71D2386B51C1EC69B4C3C82428E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.100 -0400", hash_original_method = "0E5E783B90E69DDC86CBB5AF4D60343F", hash_generated_method = "C9706D70B692B74D47204D29B73FA2A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.100 -0400", hash_original_method = "2126772517D4D51A0CCD7D5847A54B89", hash_generated_method = "525F439F12312DFEC76BC71A603B6700")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.100 -0400", hash_original_method = "4BEC5ECE79612E1091BBCBD880B92D6A", hash_generated_method = "CFFF5AC171E2B5DDCC4F7D0AB864F718")
    @DSModeled(DSC.SAFE)
    public int getDrawingCacheBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDrawingCacheBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.100 -0400", hash_original_method = "8A1B171D557613DB7E4B9E775A2E64AA", hash_generated_method = "7863622F5BA5FABAB7E5B62D4108044D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void buildDrawingCache() {
        buildDrawingCache(false);
        // ---------- Original Method ----------
        //buildDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.101 -0400", hash_original_method = "8AFFFACECE9FE8C2DF57758245D0721D", hash_generated_method = "EA1820C52FEDC1D50EF5554359827BB2")
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
            AttachInfo attachInfo;
            attachInfo = mAttachInfo;
            boolean scalingRequired;
            scalingRequired = attachInfo != null && attachInfo.mScalingRequired;
            {
                width = (int) ((width * attachInfo.mApplicationScale) + 0.5f);
                height = (int) ((height * attachInfo.mApplicationScale) + 0.5f);
            } //End block
            int drawingCacheBackgroundColor;
            drawingCacheBackgroundColor = mDrawingCacheBackgroundColor;
            boolean opaque;
            opaque = drawingCacheBackgroundColor != 0 || isOpaque();
            boolean use32BitCache;
            use32BitCache = attachInfo != null && attachInfo.mUse32BitDrawingCache;
            {
                boolean var555C1BA5A9771D8E1776E57A9469E7A6_1915103839 = (width <= 0 || height <= 0 ||
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
                boolean var112855DB511D640A3CBF7592003CEA59_34753989 = (bitmap == null || bitmap.getWidth() != width || bitmap.getHeight() != height);
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
            int restoreCount;
            restoreCount = canvas.save();
            {
                float scale;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.102 -0400", hash_original_method = "9EC32975405209F06A6AEBC988E2ADFA", hash_generated_method = "2BEE169288E4BB46FA511DD72DE02314")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        dsTaint.addTaint(skipChildren);
        dsTaint.addTaint(backgroundColor);
        dsTaint.addTaint(quality.dsTaint);
        int width;
        width = mRight - mLeft;
        int height;
        height = mBottom - mTop;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        float scale;
        scale = attachInfo.mApplicationScale;
        scale = 1.0f;
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
        int restoreCount;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.102 -0400", hash_original_method = "B880B01C07154F288A73209778F72869", hash_generated_method = "FC6DC20C9025DD7DFC07E124FAB1A96D")
    @DSModeled(DSC.SAFE)
    public boolean isInEditMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.102 -0400", hash_original_method = "FAE0811CBF87AAE1D612614CB5EBE838", hash_generated_method = "0FA05C49809DEDFE146FD0B7AC81A233")
    @DSModeled(DSC.SAFE)
    protected boolean isPaddingOffsetRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.103 -0400", hash_original_method = "4C949B81A8DC7FEE598CF97986A5D947", hash_generated_method = "82B9E856072FC09F0F78FB74A1009974")
    @DSModeled(DSC.SAFE)
    protected int getLeftPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.103 -0400", hash_original_method = "074FFDE548FCC46FA1E9A30627AB8A7C", hash_generated_method = "F64ABC5A55AECC28FCB25124F93AD057")
    @DSModeled(DSC.SAFE)
    protected int getRightPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.103 -0400", hash_original_method = "A9CEAAEF3075A726E0EAEBF5F9AFAFB2", hash_generated_method = "9DEFB0DE2C73DD7CE4CD474F51BC75A5")
    @DSModeled(DSC.SAFE)
    protected int getTopPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.103 -0400", hash_original_method = "8428DF91FD33A9244C31B60F9D34D200", hash_generated_method = "99560262D8FBA5C33FB5C89947821DC0")
    @DSModeled(DSC.SAFE)
    protected int getBottomPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.103 -0400", hash_original_method = "6D1FD6806CEFCA87F4934C6F8CB34AD2", hash_generated_method = "6329F5D5519301999C6B01C250930002")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.104 -0400", hash_original_method = "9B6486C3AB53B66EA69662D43A443B3A", hash_generated_method = "3AFA45F379C22BE0365CE60D55530BF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.104 -0400", hash_original_method = "E6CC46F2CB7AE1B25C3F8DA9B9857709", hash_generated_method = "81C18F5BD475D50CEBA8354A89F12385")
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHardwareAccelerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.106 -0400", hash_original_method = "788C5C753E694A468D30095348832570", hash_generated_method = "22633C9FDD5D50806E7607132391A238")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
        } //End block
        int privateFlags;
        privateFlags = mPrivateFlags;
        boolean dirtyOpaque;
        dirtyOpaque = (privateFlags & DIRTY_MASK) == DIRTY_OPAQUE &&
                (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState);
        mPrivateFlags = (privateFlags & ~DIRTY_MASK) | DRAWN;
        int saveCount;
        {
            Drawable background;
            background = mBGDrawable;
            {
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
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
        int viewFlags;
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
        boolean offsetRequired;
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
        ScrollabilityCache scrollabilityCache;
        scrollabilityCache = mScrollCache;
        float fadeHeight;
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
            int flags;
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
        Paint p;
        p = scrollabilityCache.paint;
        Matrix matrix;
        matrix = scrollabilityCache.matrix;
        Shader fade;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.107 -0400", hash_original_method = "6ABCD0F86C11EBC98FE78FD55BB4B1CF", hash_generated_method = "435AB96E20EA620D4FDB5321ABFDB6B5")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.108 -0400", hash_original_method = "AB08A97FC3701C702D6BD81573091B60", hash_generated_method = "C39E5131DB1E13502B85D8F8F8500B06")
    @DSModeled(DSC.SAFE)
    public boolean isLayoutRequested() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.108 -0400", hash_original_method = "288ECB50C55148E98CF66115292FF462", hash_generated_method = "2CD8F8521168731F0371DF424B99E6DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.108 -0400", hash_original_method = "E68A871B23A3BFC32DE9705D7524956B", hash_generated_method = "DFAC7C53DA0843C870B1E37BE1A0218F")
    @DSModeled(DSC.SAFE)
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        dsTaint.addTaint(changed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.109 -0400", hash_original_method = "D0D9CDE5209D8FC4BFA1DB8710882914", hash_generated_method = "3964E3AF84D49EFB3DC0C00EEACA6ECC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.109 -0400", hash_original_method = "BECA18BF96D1F48EBBDC02908C938AE4", hash_generated_method = "A5AD1675E772B469DDBDD7D413837A2E")
    @DSModeled(DSC.SAFE)
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.109 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "6AE48ABE156B960146B435295FB83025")
    @DSModeled(DSC.SAFE)
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.110 -0400", hash_original_method = "1B5315B2A2E6007B07F436EFC340A168", hash_generated_method = "2A113C133B4B742114084F3D8837AEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_1621906436 = (verifyDrawable(drawable));
            {
                Rect dirty;
                dirty = drawable.getBounds();
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.110 -0400", hash_original_method = "8ECDB7E126F9B8C9FE155246E2EA10DA", hash_generated_method = "278BBE59DD03B749D49BCD60D1243CF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_333979181 = (verifyDrawable(who) && what != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.110 -0400", hash_original_method = "20282D900D1527E5779752DD2D1E3601", hash_generated_method = "6282F7621C587E042A64D566A71DF6FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_582021846 = (verifyDrawable(who) && what != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.110 -0400", hash_original_method = "5631E9137ED00BCDF82AA1F70C739531", hash_generated_method = "05604888C59E06739B1EC135BB9EB36E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.111 -0400", hash_original_method = "AE0F8179B8268398E41F65FF0C6F4434", hash_generated_method = "045EC00ED27034B93EED28AF002B0952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getResolvedLayoutDirection(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1982088171 = (getResolvedLayoutDirection());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.111 -0400", hash_original_method = "4F9A094C3230B8AB80716D2738225FBB", hash_generated_method = "51DBC7C356B12CBBAF4AA7306067DA77")
    @DSModeled(DSC.SAFE)
    protected boolean verifyDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return who == mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.111 -0400", hash_original_method = "73C0FB6C39E14C0EF8F5708E9524F27F", hash_generated_method = "FC68853F390FB98955ECD7D530EAF2B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void drawableStateChanged() {
        Drawable d;
        d = mBGDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_2144387040 = (d != null && d.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.111 -0400", hash_original_method = "3D0ECB50F3069F68F8A036B0BBF9CAA8", hash_generated_method = "41E30C873BB11DFD438925E1193393D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.112 -0400", hash_original_method = "7B628D8EF95C580B0BB9FD927C61FF3F", hash_generated_method = "7805C5A4CFA063BC359DB140A4D55C23")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.112 -0400", hash_original_method = "65DFC58C78CED9A3B9AF9F7EEF9C3470", hash_generated_method = "8356715726740BB20B44EB9A132F4A89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varCE673B688BFA7856C9D2543AAE971FB2_218711426 = (((View) mParent).onCreateDrawableState(extraSpace));
        } //End block
        int[] drawableState;
        int privateFlags;
        privateFlags = mPrivateFlags;
        int viewStateIndex;
        viewStateIndex = 0;
        viewStateIndex |= VIEW_STATE_PRESSED;
        viewStateIndex |= VIEW_STATE_ENABLED;
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_32600674 = (isFocused());
            viewStateIndex |= VIEW_STATE_FOCUSED;
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_SELECTED;
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_323448482 = (hasWindowFocus());
            viewStateIndex |= VIEW_STATE_WINDOW_FOCUSED;
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_ACTIVATED;
        {
            boolean varFEAE3CEA2D5FFAE7121F7CB82052FEED_906895860 = (mAttachInfo != null && mAttachInfo.mHardwareAccelerationRequested &&
                HardwareRenderer.isAvailable());
            {
                viewStateIndex |= VIEW_STATE_ACCELERATED;
            } //End block
        } //End collapsed parenthetic
        viewStateIndex |= VIEW_STATE_HOVERED;
        int privateFlags2;
        privateFlags2 = mPrivateFlags2;
        viewStateIndex |= VIEW_STATE_DRAG_CAN_ACCEPT;
        viewStateIndex |= VIEW_STATE_DRAG_HOVERED;
        drawableState = VIEW_STATE_SETS[viewStateIndex];
        int[] fullState;
        {
            fullState = new int[drawableState.length + extraSpace];
            System.arraycopy(drawableState, 0, fullState, 0, drawableState.length);
        } //End block
        {
            fullState = new int[extraSpace];
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState) {
        final int N = baseState.length;
        int i = N - 1;
        while (i >= 0 && baseState[i] == 0) {
            i--;
        }
        System.arraycopy(additionalState, 0, baseState, i + 1, additionalState.length);
        return baseState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.113 -0400", hash_original_method = "9FD34CE508D1EA4936B2EE985D9CB024", hash_generated_method = "737A8B438A0C896E7E589DCB6D2BBB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void jumpDrawablesToCurrentState() {
        {
            mBGDrawable.jumpToCurrentState();
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable != null) {
            //mBGDrawable.jumpToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.113 -0400", hash_original_method = "0F7EB0FE33D439CD82034214A1B516F3", hash_generated_method = "143CE770BFA95B3D958D04D46A330F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.113 -0400", hash_original_method = "009D5DD04F6FB534689B81D1D35D5DCC", hash_generated_method = "E5D3CA0802B00999B102610330618608")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.156 -0400", hash_original_method = "925AEEB36C7C1277949151BD876A29D4", hash_generated_method = "D8DE12D4B8ADE62C1288A5583A0DCA4B")
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
                boolean var77F8DEC95ED142E00E9340D4E6309A49_1333968716 = (d.getPadding(padding));
                {
                    {
                        Object var539EB19FF2B3A749E138242972103033_365072098 = (d.getResolvedLayoutDirectionSelf());
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
                boolean varD26CE81CD77ABD9AB1A61C65E203B0B1_497445656 = (mBGDrawable == null || mBGDrawable.getMinimumHeight() != d.getMinimumHeight() ||
                    mBGDrawable.getMinimumWidth() != d.getMinimumWidth());
                {
                    requestLayout = true;
                } //End block
            } //End collapsed parenthetic
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_1006600247 = (d.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.156 -0400", hash_original_method = "80971671F36DCDE8D8060A8575F1E0DF", hash_generated_method = "3413BB21BCB2FCC85E9320E812A3E45C")
    @DSModeled(DSC.SAFE)
    public Drawable getBackground() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.157 -0400", hash_original_method = "518320784120938CAC15B0472A139DBB", hash_generated_method = "09BD4CCF3A9818F89BFA62BE10EAB2E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean changed;
        changed = false;
        mUserPaddingRelative = false;
        int viewFlags;
        viewFlags = mViewFlags;
        {
            {
                int offset;
                offset = 0;
                offset = getVerticalScrollbarWidth();
                //Begin case SCROLLBAR_POSITION_DEFAULT 
                {
                    boolean varDD88345AFC6B206805F2994C7FB7F6F7_1301679304 = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.157 -0400", hash_original_method = "F50D0F04B3AF13DC9F9192544EA8BA6E", hash_generated_method = "56E69E7E658C2843B6FEA5F5FB276BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(end);
        dsTaint.addTaint(top);
        mUserPaddingRelative = true;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_281361394 = (getResolvedLayoutDirection());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.157 -0400", hash_original_method = "71BE64DF9CA1E548604AD18ADE3DFBDD", hash_generated_method = "59C02283F542F01FC51FAACDBDA1B02C")
    @DSModeled(DSC.SAFE)
    public int getPaddingTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.157 -0400", hash_original_method = "472EE1BBE725DA831283E7FA94BE4536", hash_generated_method = "F5CC37F6970392C95CFE3D03A69BBA9C")
    @DSModeled(DSC.SAFE)
    public int getPaddingBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.157 -0400", hash_original_method = "F854F7F8F07B4C3AC7B7FE5B9B528BAE", hash_generated_method = "32A2BD744464871529066EE7FB21FED6")
    @DSModeled(DSC.SAFE)
    public int getPaddingLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.158 -0400", hash_original_method = "78A5E196850432C8DD415DC0673D2C8F", hash_generated_method = "7C6EE4D201A3F3D02921BB0F7195EB25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPaddingStart() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_164746837 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingRight : mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.158 -0400", hash_original_method = "6AC4AEB4D1AD621C23B7EB8B08E4182E", hash_generated_method = "9692A31CAC49A954E1959BBAD33395E4")
    @DSModeled(DSC.SAFE)
    public int getPaddingRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.158 -0400", hash_original_method = "EE58EF7C85312E1C063201AE8CA23F8D", hash_generated_method = "734E285261D6B69DAA09E06123483684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPaddingEnd() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_1315261845 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingLeft : mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.158 -0400", hash_original_method = "84D71EDE4F7EF14E19771B4AB735B283", hash_generated_method = "8281A12724C0205007F2C8648EE26C18")
    @DSModeled(DSC.SAFE)
    public boolean isPaddingRelative() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUserPaddingRelative;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.159 -0400", hash_original_method = "91676949986DAC4CFDCFD2A3FAD3A69B", hash_generated_method = "8BD98674A59A075E2D13FA3F27A6DD1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.159 -0400", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "2B4CECA3C698025847AA1FBEDBF34E1C")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetSelected(boolean selected) {
        dsTaint.addTaint(selected);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.159 -0400", hash_original_method = "48002052E4D321A2B2BAD55BEF8E0A66", hash_generated_method = "83962985FC484CF617926FDE40DC20B8")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & SELECTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.159 -0400", hash_original_method = "449C65D8ABD541EEF5AF1DFBC99BE952", hash_generated_method = "FFCB6EC5B0C8414263B020850C084301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.159 -0400", hash_original_method = "857B49EDB2F7375261DD6F1ED2F34094", hash_generated_method = "58F3B116A54AA6CB3A8998E463A8E337")
    @DSModeled(DSC.SAFE)
    protected void dispatchSetActivated(boolean activated) {
        dsTaint.addTaint(activated);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.160 -0400", hash_original_method = "807E5BA633430E7244B8D5311A7423DE", hash_generated_method = "1AC513DBB730BA6EFD738E820712D8B8")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isActivated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & ACTIVATED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.160 -0400", hash_original_method = "99F6A92222C13DFFEF0BA3B363A5F1C1", hash_generated_method = "BEB21E57856A3E334E57F77624DC8D9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.160 -0400", hash_original_method = "399BB6B1CB98987E45F7FD1BEC4104A8", hash_generated_method = "7B975AFD7248EDB1AB9A5D1333BB7620")
    @DSModeled(DSC.SAFE)
    public View getRootView() {
        {
            View v;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.160 -0400", hash_original_method = "6E1F3A14CB89D70C54E776D2215F970D", hash_generated_method = "5BDC590C2C3C306663496B6A272E9C3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getLocationOnScreen(int[] location) {
        dsTaint.addTaint(location[0]);
        getLocationInWindow(location);
        AttachInfo info;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.161 -0400", hash_original_method = "D5745CE4077A3F8C966A99FAE28757B4", hash_generated_method = "C771487A0E78DABAD1F19501AF904224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getLocationInWindow(int[] location) {
        dsTaint.addTaint(location[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("location must be an array of two integers");
        } //End block
        float[] position;
        position = mAttachInfo.mTmpTransformLocation;
        position[0] = position[1] = 0.0f;
        {
            boolean var72C5EB038B47497B7FA123412E9ED288_1540196133 = (!hasIdentityMatrix());
            {
                getMatrix().mapPoints(position);
            } //End block
        } //End collapsed parenthetic
        position[0] += mLeft;
        position[1] += mTop;
        ViewParent viewParent;
        viewParent = mParent;
        {
            View view;
            view = (View) viewParent;
            position[0] -= view.mScrollX;
            position[1] -= view.mScrollY;
            {
                boolean varA98FC0C227FABB5530C6DB9897E9E044_1603119244 = (!view.hasIdentityMatrix());
                {
                    view.getMatrix().mapPoints(position);
                } //End block
            } //End collapsed parenthetic
            position[0] += view.mLeft;
            position[1] += view.mTop;
            viewParent = view.mParent;
        } //End block
        {
            ViewRootImpl vr;
            vr = (ViewRootImpl) viewParent;
            position[1] -= vr.mCurScrollY;
        } //End block
        location[0] = (int) (position[0] + 0.5f);
        location[1] = (int) (position[1] + 0.5f);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.161 -0400", hash_original_method = "0641E50E124E0C6CE4C02F73E2175BDE", hash_generated_method = "5BEAB33FB57E73199DFB7CA2ACE3BCCD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.161 -0400", hash_original_method = "B50CD4B4D228C210BD89E9DF598807C7", hash_generated_method = "BA75F6AC7EA4EBB135635DCFCF5A1D72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View findViewWithTagTraversal(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_1255222374 = (tag != null && tag.equals(mTag));
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag != null && tag.equals(mTag)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "65DA32C16954A521B825F7D31B571CEF", hash_generated_method = "009B2BFA9C1CAD4121F48DF3BE6BACC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        dsTaint.addTaint(childToSkip.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_1130501131 = (predicate.apply(this));
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (predicate.apply(this)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "C8E06C0ED5E3D035BF7CE8B77FB6FB02", hash_generated_method = "8AFA98B1FA52BCC4BFDB69016C57750A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewById(int id) {
        dsTaint.addTaint(id);
        View var4AA29BCB5B142A204BD7DB16E419C652_101354193 = (findViewTraversal(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (id < 0) {
            //return null;
        //}
        //return findViewTraversal(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "DAB2723BE4C5F25FDBDAA56D4A941A95", hash_generated_method = "505BD13390F637290510E9247843F9C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final View findViewByAccessibilityId(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        View var241B8B20A533D780A251CFCAA213F5CB_1151826643 = (findViewByAccessibilityIdTraversal(accessibilityId));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (accessibilityId < 0) {
            //return null;
        //}
        //return findViewByAccessibilityIdTraversal(accessibilityId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "0033D4DC027C6D84BC9CA79DB06FA7C7", hash_generated_method = "0575D7DBE11D3D9A2F564C66D8F9C5F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        {
            boolean varA0F894C9F7ECB9E8C9290E6F95BA5394_1925550325 = (getAccessibilityViewId() == accessibilityId);
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getAccessibilityViewId() == accessibilityId) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "DB0D3478EC5FC406F90807706EB086DC", hash_generated_method = "9CD59151E1E7911FFD37C498998A2022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewWithTag(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        View varF6D3742523D93D79D78F9560B7ADBE9B_573827839 = (findViewWithTagTraversal(tag));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag == null) {
            //return null;
        //}
        //return findViewWithTagTraversal(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.162 -0400", hash_original_method = "1599799F36C9F7803A0B97DCCA829DED", hash_generated_method = "7EEC4E93F877031B87E6C854E9596D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewByPredicate(Predicate<View> predicate) {
        dsTaint.addTaint(predicate.dsTaint);
        View varAED79EFE897269532E5B1F9D1682DD74_710931648 = (findViewByPredicateTraversal(predicate, null));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return findViewByPredicateTraversal(predicate, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.163 -0400", hash_original_method = "485BA369E24687F2D5FF0693ABF816B2", hash_generated_method = "9CFD8F3FEA7DF4A93A79C6E763B9B8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate) {
        dsTaint.addTaint(start.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        View childToSkip;
        childToSkip = null;
        {
            View view;
            view = start.findViewByPredicateTraversal(predicate, childToSkip);
            {
                boolean var7558536A6954E6545716F82725118232_168643413 = (view != null || start == this);
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.163 -0400", hash_original_method = "125195EB8F3EB02BBD72A4003F2E03BD", hash_generated_method = "22CAC7D4661B6315E8E3A93A0B996645")
    @DSModeled(DSC.SAFE)
    public void setId(int id) {
        dsTaint.addTaint(id);
        // ---------- Original Method ----------
        //mID = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.163 -0400", hash_original_method = "B06467135FDA3C6D538127B3AC355349", hash_generated_method = "B0632D20D0BC15A5741EC0FE2EA43929")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.163 -0400", hash_original_method = "74A41C2D2B744E005149431B820C27E4", hash_generated_method = "A4CC397A5054FD2A5B8970D0F1CACC3F")
    @DSModeled(DSC.SAFE)
    public boolean isRootNamespace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags&IS_ROOT_NAMESPACE) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.163 -0400", hash_original_method = "B0378653037A8E20BF93620A5E0AA660", hash_generated_method = "55D387CDF53AAE620A0EAE824BBB268D")
    @DSModeled(DSC.SAFE)
    @ViewDebug.CapturedViewProperty
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.164 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "97D376110B6BFB73B5C9AA3D73DF2E64")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public Object getTag() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.164 -0400", hash_original_method = "8D2B18A079B1EE90519A06D435C647B9", hash_generated_method = "1157344C2D339D15D1B317AF2358E63C")
    @DSModeled(DSC.SAFE)
    public void setTag(final Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.164 -0400", hash_original_method = "8295DF3154C0458AF2AF3A51D79A598B", hash_generated_method = "DC29EBC3D5C59C692C33F8A31BD090D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getTag(int key) {
        dsTaint.addTaint(key);
        Object var0005D9494E73BC27C16F24DA493053C0_1188547614 = (mKeyedTags.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mKeyedTags != null) return mKeyedTags.get(key);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.164 -0400", hash_original_method = "C739488AB1D92CB0D6B67C6D73AEF4DA", hash_generated_method = "28443E21D71CDD5D84B2250DA3015AFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.164 -0400", hash_original_method = "5A92838330F5A71B83A0155FDDE52450", hash_generated_method = "5A86E030A1A1EECECF4E740F0382B254")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.165 -0400", hash_original_method = "0255761BE2D8372B1493AF7283C8F5B5", hash_generated_method = "5556C4344F123AB4ABF130651024BAF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.165 -0400", hash_original_method = "C5EE38E619F11A07C2A1169818F1E749", hash_generated_method = "6F490D502F052C31491B836A218B7486")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean dispatchConsistencyCheck(int consistency) {
        dsTaint.addTaint(consistency);
        boolean var696CB6BB2A7239589CBDDD711F9F9275_565045165 = (onConsistencyCheck(consistency));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onConsistencyCheck(consistency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.165 -0400", hash_original_method = "2064C42F46AA0108673BA11B037AF3A0", hash_generated_method = "50D2E6F06579490176E141EA726F3CE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consistency);
        boolean result;
        result = true;
        boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        boolean checkDrawing;
        checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            {
                boolean varDE1E2D0AA459DE6E8FAB425D9EAC441E_273810787 = (getParent() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.165 -0400", hash_original_method = "6F90E3DC82B178E80E1C9DDC98738197", hash_generated_method = "D147ED463C0B27338F948465FB673FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void debug() {
        debug(0);
        // ---------- Original Method ----------
        //debug(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.166 -0400", hash_original_method = "3D5CB916992FEDBE62B11876DD1CF29A", hash_generated_method = "4123A14A1FC55D21DC803C98A2D3B54B")
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

    
        protected static String debugIndent(int depth) {
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.167 -0400", hash_original_method = "04C72C8D15A6DF3440AFF547FAD30ABA", hash_generated_method = "BB9C3E6AD532004100276C1A411441E8")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.167 -0400", hash_original_method = "B7CE3104FF9ED0677BFFACD05F948960", hash_generated_method = "DBA58CD63A97F84734D1BC8742F1C0B7")
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
                boolean var3A2DB0BB7B6E5FB8768388F8E364ED16_672182584 = (!mParent.isLayoutRequested());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.167 -0400", hash_original_method = "5F70867C98C203969EB162B4B724A790", hash_generated_method = "1F7ADA8EF52B745DA17A5F28CC890DA3")
    @DSModeled(DSC.SAFE)
    public void forceLayout() {
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        // ---------- Original Method ----------
        //mPrivateFlags |= FORCE_LAYOUT;
        //mPrivateFlags |= INVALIDATED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.167 -0400", hash_original_method = "26BA2349651C8679968382F6A84D9E92", hash_generated_method = "E005E035942AD21C6AE9DF1079D4B7DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.167 -0400", hash_original_method = "2024EA7D99B2D61F149E7A5A9BB7EB8E", hash_generated_method = "01B952C1043694D31111228C69B97CB1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.168 -0400", hash_original_method = "5AB327430FB1DFBD1DD895A1A32A2AA8", hash_generated_method = "B71D8F51121929329DF8677008CBA8F1")
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

    
        public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }

    
        public static int resolveSize(int size, int measureSpec) {
        return resolveSizeAndState(size, measureSpec, 0) & MEASURED_SIZE_MASK;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.168 -0400", hash_original_method = "B59EA0BF10E69D3FFCA86CC30267F8DC", hash_generated_method = "5A364AE7147C07B8877B119B0D0FDC3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getSuggestedMinimumHeight() {
        int suggestedMinHeight;
        suggestedMinHeight = mMinHeight;
        {
            int bgMinHeight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.169 -0400", hash_original_method = "008B87CD2B3ED33B965CD69B13D61BFC", hash_generated_method = "982671538CDD2D3D7FFCC3905E98C43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getSuggestedMinimumWidth() {
        int suggestedMinWidth;
        suggestedMinWidth = mMinWidth;
        {
            int bgMinWidth;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.169 -0400", hash_original_method = "879BFA5FA0241047CB6974ED67682297", hash_generated_method = "C6AAD572836591C54B992A72156CA6A0")
    @DSModeled(DSC.SAFE)
    public void setMinimumHeight(int minHeight) {
        dsTaint.addTaint(minHeight);
        // ---------- Original Method ----------
        //mMinHeight = minHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.169 -0400", hash_original_method = "CE129FBEAB6CCA0889899FF1E8E78A67", hash_generated_method = "E667AF8C4A1818909D930D4B406373C8")
    @DSModeled(DSC.SAFE)
    public void setMinimumWidth(int minWidth) {
        dsTaint.addTaint(minWidth);
        // ---------- Original Method ----------
        //mMinWidth = minWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.169 -0400", hash_original_method = "CDBB00D26F9C60D5F3E6B97847853936", hash_generated_method = "FEF8C3B9B225B43F9AA6E5F085ABD588")
    @DSModeled(DSC.SAFE)
    public Animation getAnimation() {
        return (Animation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCurrentAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.169 -0400", hash_original_method = "8B9244EE03042EB67F130AFDAD9A68F9", hash_generated_method = "A97B39001313591A85D0011ACD5F8461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.170 -0400", hash_original_method = "743A148D3AA9DA63FB0D1635C16263C7", hash_generated_method = "D8BDC865788F545FD5DB6A92DA533D21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.170 -0400", hash_original_method = "80992FCFACCF22F26EEB305124C3026E", hash_generated_method = "B91EF3BE0507C43A772F4263450A6D85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.170 -0400", hash_original_method = "AAD5AA561778224F71E3AF6921CD4105", hash_generated_method = "06D6C8F61FFE52559A40E6B98F790853")
    @DSModeled(DSC.SAFE)
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags |= ANIMATION_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.170 -0400", hash_original_method = "F4AD81FC3499666E7AC93E3735AFEF8E", hash_generated_method = "05026BAADDDB17252B779F88E55782F5")
    @DSModeled(DSC.SAFE)
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags &= ~ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags &= ~ANIMATION_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.170 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "4F6B00050D0DD98EE19F958B92CF190D")
    @DSModeled(DSC.SAFE)
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(alpha);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.171 -0400", hash_original_method = "A01500863A3F6668743C7034A9645220", hash_generated_method = "B57CB62A73CEBC54BB533DF4A8D62C29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            int pflags;
            pflags = mPrivateFlags;
            {
                int[] location;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.171 -0400", hash_original_method = "92BFD91D600C047225F186391F6079B0", hash_generated_method = "E6D1697A7B4E98D1ACAFD684A8C19105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSoundEffect(int soundConstant) {
        dsTaint.addTaint(soundConstant);
        {
            boolean var1E4326663BC68D529F79DE6FC2643778_1836739190 = (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled());
        } //End collapsed parenthetic
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
        // ---------- Original Method ----------
        //if (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            //return;
        //}
        //mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.171 -0400", hash_original_method = "75954C55ABC6CE5681E22BCDE96F4903", hash_generated_method = "E51359DF547EA0D29C314DA77E8AE091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int feedbackConstant) {
        dsTaint.addTaint(feedbackConstant);
        boolean var47DA1E759FDC3E51245046642463FE5C_1885427865 = (performHapticFeedback(feedbackConstant, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return performHapticFeedback(feedbackConstant, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.171 -0400", hash_original_method = "A19669526C11317AB6CCDC764945F176", hash_generated_method = "D0F715844E3E28D21DD74FE637797418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(feedbackConstant);
        {
            boolean varA5539A907B715B189715B7DC683584E6_1434834331 = ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled());
        } //End collapsed parenthetic
        boolean var504ECB78099BB3639952FEB46DA1CEC5_337805952 = (mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.172 -0400", hash_original_method = "1F6436CCBBD24CDC20D09B9CE44A0912", hash_generated_method = "A98E772816C3ED7D2E88696117C7DC80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.172 -0400", hash_original_method = "FA02CCE186B627C6CF56D55D5156174E", hash_generated_method = "F7500F17BACC2A074392C8F94A57E604")
    @DSModeled(DSC.SAFE)
    public int getSystemUiVisibility() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSystemUiVisibility;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.172 -0400", hash_original_method = "1911D5DDAC8087DF02FDB915711E3D30", hash_generated_method = "367067B44E7D97A51C8E3476AD977577")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.173 -0400", hash_original_method = "31A60EE50D18A3986849FF003231E28E", hash_generated_method = "122FC9F234A995828A20A3F7F7AD6175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.173 -0400", hash_original_method = "BE707BAA551F425B19E1E4FBE454F716", hash_generated_method = "C5D58DFCCFAD979B6E6805DB2E8BC33E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.174 -0400", hash_original_method = "F914DF1AC479022C6AA4BFD6DD1247D7", hash_generated_method = "86D24EA3576531286EE5DC2C18E424C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags) {
        dsTaint.addTaint(myLocalState.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(shadowBuilder.dsTaint);
        dsTaint.addTaint(data.dsTaint);
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
                ViewRootImpl root;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.174 -0400", hash_original_method = "7E645D896E88F7A2CE991A302B5729A7", hash_generated_method = "961BE9110780AE86740B15060131406E")
    @DSModeled(DSC.SAFE)
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.174 -0400", hash_original_method = "2E7102A43746FEAE9D11C37FDA834A21", hash_generated_method = "A34DB69A9FAC86EA0904A80F81721ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        ListenerInfo li;
        li = mListenerInfo;
        {
            boolean var335DF3A408D4F144DA69CF42853FDB1A_1016153616 = (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event));
        } //End collapsed parenthetic
        boolean var0587795787D505B85471C0D6F567FE89_1246909184 = (onDragEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnDragListener.onDrag(this, event)) {
            //return true;
        //}
        //return onDragEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.175 -0400", hash_original_method = "C990D75777DFB098F96F21BE433F897F", hash_generated_method = "5409A1415F5CA0501CD47583627D3289")
    @DSModeled(DSC.SAFE)
     boolean canAcceptDrag() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.175 -0400", hash_original_method = "059265693C3FBF9CA8D6100876A0DA7C", hash_generated_method = "B15A5C60A69857D291ADBEF426F0EE5E")
    @DSModeled(DSC.SAFE)
    public void onCloseSystemDialogs(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.175 -0400", hash_original_method = "14C9DBE3395E98A8750BC15A93AD3A45", hash_generated_method = "EE2E05047D4484AE1364BFB19BDA8EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyDrawableToTransparentRegion(Drawable dr, Region region) {
        dsTaint.addTaint(region.dsTaint);
        dsTaint.addTaint(dr.dsTaint);
        Region r;
        r = dr.getTransparentRegion();
        Rect db;
        db = dr.getBounds();
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            int w;
            w = getRight()-getLeft();
            int h;
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
            int[] location;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.175 -0400", hash_original_method = "3A330A3DE83C0EE0C70042D452F74FC4", hash_generated_method = "1B24F6003CF7F4258222885D021F070C")
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

    
        public static View inflate(Context context, int resource, ViewGroup root) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.176 -0400", hash_original_method = "5E47C984391EE91860CD25320EB410A4", hash_generated_method = "6FD81255509DB16BE44DBBF6EF7CEFE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedParameters"})
    protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent) {
        dsTaint.addTaint(maxOverScrollY);
        dsTaint.addTaint(scrollRangeX);
        dsTaint.addTaint(scrollRangeY);
        dsTaint.addTaint(isTouchEvent);
        dsTaint.addTaint(maxOverScrollX);
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(scrollX);
        dsTaint.addTaint(deltaY);
        int overScrollMode;
        overScrollMode = mOverScrollMode;
        boolean canScrollHorizontal;
        canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean canScrollVertical;
        canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean overScrollHorizontal;
        overScrollHorizontal = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollHorizontal);
        boolean overScrollVertical;
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
        int left;
        left = -maxOverScrollX;
        int right;
        right = maxOverScrollX + scrollRangeX;
        int top;
        top = -maxOverScrollY;
        int bottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.176 -0400", hash_original_method = "4CE95B84751ED417CECEABF7E9F1BBA1", hash_generated_method = "B3CD509CE419C48175EDBC3B7D3EEE48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.176 -0400", hash_original_method = "89CDC9D85B7569FFDF89FB6E096C8833", hash_generated_method = "45706C9B9CF235EBA634B102C1B88586")
    @DSModeled(DSC.SAFE)
    public int getOverScrollMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOverScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.177 -0400", hash_original_method = "D7A7F397651806FFF8FA254EEF23303B", hash_generated_method = "AB1A23D7D2C83C91EAD21CA6F5CA49C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOverScrollMode(int overScrollMode) {
        dsTaint.addTaint(overScrollMode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        } //End block
        // ---------- Original Method ----------
        //if (overScrollMode != OVER_SCROLL_ALWAYS &&
                //overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                //overScrollMode != OVER_SCROLL_NEVER) {
            //throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        //}
        //mOverScrollMode = overScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.177 -0400", hash_original_method = "9CF1D38E8E376FF50D8C64A9F9733663", hash_generated_method = "6E32D745FB901D06C9729B766CE287A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getVerticalScrollFactor() {
        {
            TypedValue outValue;
            outValue = new TypedValue();
            {
                boolean var0AC7698B51F94BDA888C18D716FEABFB_1653652665 = (!mContext.getTheme().resolveAttribute(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.177 -0400", hash_original_method = "E54E00038FC64298D390BA41C98DC1D8", hash_generated_method = "D8E4AED4F6DB2123DC23A7B043DE2F90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getHorizontalScrollFactor() {
        float varB4E039AD370F52FF248539199AD3C0AB_2008100544 = (getVerticalScrollFactor());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getVerticalScrollFactor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.177 -0400", hash_original_method = "66C84E939C2024746D4813377EE28DA8", hash_generated_method = "EC9D9F6D1FA2105B444165A4090DB8BF")
    @DSModeled(DSC.SAFE)
    public int getTextDirection() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTextDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.177 -0400", hash_original_method = "A0414376D9ECFBC599F5D349FFC72987", hash_generated_method = "8D43D714A128AB4B0186BCB558F99B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.178 -0400", hash_original_method = "99501F3EA14EF54863B388ACFA67B227", hash_generated_method = "7E09A2E453CB6533324CDCCF7DFA72ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.178 -0400", hash_original_method = "DF8FC39519D36B1AC7371F6D87C199FC", hash_generated_method = "D6167440D0E281A5592F1E06303EA124")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.178 -0400", hash_original_method = "BB79EF6AB24983F71C49AA466BBC15FC", hash_generated_method = "7309B27E3B8E0EA585A6CF1593E51E30")
    @DSModeled(DSC.SAFE)
    protected void resetResolvedTextDirection() {
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
        // ---------- Original Method ----------
        //mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.178 -0400", hash_original_method = "AF21ED671E180E70DBE0B7255059F75E", hash_generated_method = "B346593CACA3903F7E3358974E1D1247")
    @DSModeled(DSC.SAFE)
    public void hackTurnOffWindowResizeAnim(boolean off) {
        dsTaint.addTaint(off);
        mAttachInfo.mTurnOffWindowResizeAnim = off;
        // ---------- Original Method ----------
        //mAttachInfo.mTurnOffWindowResizeAnim = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.178 -0400", hash_original_method = "E195CA02B57C3CA07D3D00B98A2A4177", hash_generated_method = "38BF61BC02353BFEA11DB295D09B5747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private Matrix mMatrix = new Matrix();
        private Matrix mInverseMatrix;
        boolean mMatrixDirty = false;
        private boolean mInverseMatrixDirty = true;
        private boolean mMatrixIsIdentity = true;
        private Camera mCamera = null;
        private Matrix matrix3D = null;
        private int mPrevWidth = -1;
        private int mPrevHeight = -1;
        @ViewDebug.ExportedProperty float mRotationY = 0f;
        @ViewDebug.ExportedProperty float mRotationX = 0f;
        @ViewDebug.ExportedProperty float mRotation = 0f;
        @ViewDebug.ExportedProperty float mTranslationX = 0f;
        @ViewDebug.ExportedProperty float mTranslationY = 0f;
        @ViewDebug.ExportedProperty float mScaleX = 1f;
        @ViewDebug.ExportedProperty float mScaleY = 1f;
        @ViewDebug.ExportedProperty float mPivotX = 0f;
        @ViewDebug.ExportedProperty float mPivotY = 0f;
        @ViewDebug.ExportedProperty float mAlpha = 1f;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "97A1283EED560149B941CA60E064E334", hash_generated_method = "97A1283EED560149B941CA60E064E334")
                public TransformationInfo ()
        {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "7239ACAF30B95DB21E303E820E516045", hash_generated_method = "7239ACAF30B95DB21E303E820E516045")
                public ListenerInfo ()
        {
        }


    }


    
    public static class DragShadowBuilder {
        private WeakReference<View> mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "0B0DC4A9FB3A9C12A7904682E22ADAD8", hash_generated_method = "75868FE34FCB127DBFF50714D5A05D09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DragShadowBuilder(View view) {
            dsTaint.addTaint(view.dsTaint);
            mView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "39157EB374747DFD28056DCE3D5D84EC", hash_generated_method = "1653C54FAA06D8A2D8309AF09F1D8648")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DragShadowBuilder() {
            mView = new WeakReference<View>(null);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "12EFA38B650211F3F0DA583E081C360F", hash_generated_method = "906576C3054CD699BF0AC6A86113B7C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings({"JavadocReference"})
        final public View getView() {
            View varA6FA31E50E60277B6F29565A9C2288B3_2021021241 = (mView.get());
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mView.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.179 -0400", hash_original_method = "7C575AFDC5B7223F530AD0DF57B52E75", hash_generated_method = "142CB2A5A7ECAD303B9BC38A7C694958")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(shadowSize.dsTaint);
            dsTaint.addTaint(shadowTouchPoint.dsTaint);
            View view;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.180 -0400", hash_original_method = "F5A2B90321F064D0A4C62262ED411079", hash_generated_method = "F4B09BCC3DFBCBBB8F3A2B2B95325906")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onDrawShadow(Canvas canvas) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(canvas.dsTaint);
            View view;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.180 -0400", hash_original_method = "C851297822375FD81DA9285687044329", hash_generated_method = "C851297822375FD81DA9285687044329")
                public MeasureSpec ()
        {
        }


                public static int makeMeasureSpec(int size, int mode) {
            return size + mode;
        }

        
                public static int getMode(int measureSpec) {
            return (measureSpec & MODE_MASK);
        }

        
                public static int getSize(int measureSpec) {
            return (measureSpec & ~MODE_MASK);
        }

        
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

        
        private static final int MODE_SHIFT = 30;
        private static final int MODE_MASK  = 0x3 << MODE_SHIFT;
        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
        public static final int EXACTLY     = 1 << MODE_SHIFT;
        public static final int AT_MOST     = 2 << MODE_SHIFT;
    }


    
    class CheckForLongPress implements Runnable {
        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.180 -0400", hash_original_method = "B3B2819DF408D57079A50D03B673BFB4", hash_generated_method = "B3B2819DF408D57079A50D03B673BFB4")
                public CheckForLongPress ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "01CD5F3DDC5391038879A6F141003B2C", hash_generated_method = "BEDB003B39915387CC95EF134DA0F857")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean varFB827A206CA2F483F96FD1D1A0A39D9F_1606478695 = (isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount);
                {
                    {
                        boolean var9620ED46504D3117149539056E35032D_613480220 = (performLongClick());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "52714AB9B90C75C7141A8D07DDC0C4CA", hash_generated_method = "AB01C47E8931054C927C8BF677A5865E")
        @DSModeled(DSC.SAFE)
        public void rememberWindowAttachCount() {
            mOriginalWindowAttachCount = mWindowAttachCount;
            // ---------- Original Method ----------
            //mOriginalWindowAttachCount = mWindowAttachCount;
        }

        
    }


    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "DDE2B97FC218E2B375A63A291079A391", hash_generated_method = "DDE2B97FC218E2B375A63A291079A391")
                public CheckForTap ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "8B4AC781B811E80364C995C3750D80D8", hash_generated_method = "AB19EB04DF28937B1DF516E63AC74EFA")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "C0C80404DC27C2C3C59E89BEAEB36157", hash_generated_method = "C0C80404DC27C2C3C59E89BEAEB36157")
                public PerformClick ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "566460B544C528A9D4CEF77A7D21BD20", hash_generated_method = "6E0C9FA1A1110473D753CE2E91D91FD7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            performClick();
            // ---------- Original Method ----------
            //performClick();
        }

        
    }


    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "DA7A66D74268696ADBC137170572A5CD", hash_generated_method = "DA7A66D74268696ADBC137170572A5CD")
                public UnsetPressedState ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.181 -0400", hash_original_method = "8ADFD7FB5655235FFF1C14FE5EF3EDC3", hash_generated_method = "51E5C56E0FC59533122E120E30019564")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            setPressed(false);
            // ---------- Original Method ----------
            //setPressed(false);
        }

        
    }


    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.182 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "4ACD3512EDAF0CD436A59D7D43996808")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcel source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.182 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "2B77CAA5F5D8683ABCBEA23D85C3C576")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.182 -0400", hash_original_method = "35821D2EA4DFAF558F55A1E0F95556F9", hash_generated_method = "A5A540FC7B682051A55FD3D4429B8ADC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public BaseSavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                BaseSavedState varB73976D4028B8584E1B119E4444E1DA9_317617257 = (new BaseSavedState(in));
                return (BaseSavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.182 -0400", hash_original_method = "6AB34CCCCE700DF19CB6D0E0E8A5F161", hash_generated_method = "6D815754C0417BE747F241223194D707")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public BaseSavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                BaseSavedState[] var7EF7841C2B7A5BA6B50A897F1043D76A_1690878208 = (new BaseSavedState[size]);
                return (BaseSavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    static class AttachInfo {
        IWindowSession mSession;
        IWindow mWindow;
        IBinder mWindowToken;
        Callbacks mRootCallbacks;
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
        Rect mContentInsets = new Rect();
        Rect mVisibleInsets = new Rect();
        ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets
                = new ViewTreeObserver.InternalInsetsInfo();
        ArrayList<View> mScrollContainers = new ArrayList<View>();
        KeyEvent.DispatcherState mKeyDispatchState
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
        int[] mTransparentLocation = new int[2];
        int[] mInvalidateChildLocation = new int[2];
        float[] mTmpTransformLocation = new float[2];
        ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        Canvas mCanvas;
        Handler mHandler;
        Rect mTmpInvalRect = new Rect();
        RectF mTmpTransformRect = new RectF();
        ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        int mAccessibilityWindowId = View.NO_ID;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.182 -0400", hash_original_method = "0CDE5ADA82BD9455683884E38A135C3D", hash_generated_method = "3297C8C15C48DDF2377D5C549DDEBF05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer) {
            dsTaint.addTaint(effectPlayer.dsTaint);
            dsTaint.addTaint(window.dsTaint);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            mWindowToken = window.asBinder();
            // ---------- Original Method ----------
            //mSession = session;
            //mWindow = window;
            //mWindowToken = window.asBinder();
            //mHandler = handler;
            //mRootCallbacks = effectPlayer;
        }

        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            private InvalidateInfo mNext;
            private boolean mIsPooled;
            View target;
            int left;
            int top;
            int right;
            int bottom;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "04FDC76E52A26DB7DDF924F9433C691C", hash_generated_method = "04FDC76E52A26DB7DDF924F9433C691C")
                        public InvalidateInfo ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "AAFC70DDA5FB82CEF5E58C1F01C303B7", hash_generated_method = "D602346C1EC8303A2BF4ED4588555C6A")
            @DSModeled(DSC.SAFE)
            public void setNextPoolable(InvalidateInfo element) {
                dsTaint.addTaint(element.dsTaint);
                // ---------- Original Method ----------
                //mNext = element;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "8D8571C3CBC87318B5EA7A031BC44388", hash_generated_method = "082C46D54981C22D3C031C07848302E0")
            @DSModeled(DSC.SAFE)
            public InvalidateInfo getNextPoolable() {
                return (InvalidateInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return mNext;
            }

            
                        static InvalidateInfo acquire() {
                return sPool.acquire();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "8830525D8149BF52E4AE797FF2AC88D3", hash_generated_method = "E9DF48B1A3244CDF3D09900CA1C3DD95")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             void release() {
                sPool.release(this);
                // ---------- Original Method ----------
                //sPool.release(this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "5D15E99725D43744F3178673C8B6AC3C")
            @DSModeled(DSC.SAFE)
            public boolean isPooled() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.183 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "A19BE98D20006B14A3686F1F697F4E6E")
            @DSModeled(DSC.SAFE)
            public void setPooled(boolean isPooled) {
                dsTaint.addTaint(isPooled);
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
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
        public Paint paint;
        public Matrix matrix;
        public Shader shader;
        public Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        public long fadeStartTime;
        public int state = OFF;
        private int mLastColor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.184 -0400", hash_original_method = "AB4B2D8281C9D79EC8FB184A37CE88FD", hash_generated_method = "04A01246D6A93F798367BE07F8AD2D83")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.185 -0400", hash_original_method = "96C29AC8476B3BD548A01E55E35CBC04", hash_generated_method = "971446D72CDFAFED29642B9825CCD7E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.185 -0400", hash_original_method = "14A33F30726B3AE59CE909C1A535F2F0", hash_generated_method = "D0408B972431EC505803D096E7C8DC6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        public static final int OFF = 0;
        public static final int ON = 1;
        public static final int FADING = 2;
        private static final float[] OPAQUE = { 255 };
        private static final float[] TRANSPARENT = { 0.0f };
    }


    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.185 -0400", hash_original_method = "C82F9AC36650F36F3F759862710EB354", hash_generated_method = "C82F9AC36650F36F3F759862710EB354")
                public SendViewScrolledAccessibilityEvent ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.186 -0400", hash_original_method = "13F513362861425D1A8D234F009B3F81", hash_generated_method = "53A034A606164AD076ADC134C6992AE7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            //mIsPending = false;
        }

        
    }


    
    public static class AccessibilityDelegate {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.186 -0400", hash_original_method = "DD1B2D746AA3B6786CF1D8C74949DD6B", hash_generated_method = "DD1B2D746AA3B6786CF1D8C74949DD6B")
                public AccessibilityDelegate ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.186 -0400", hash_original_method = "BC0125D947E50318963E057CA3B612F3", hash_generated_method = "6196CD405F5873259840C10C259ADC5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void sendAccessibilityEvent(View host, int eventType) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(eventType);
            host.sendAccessibilityEventInternal(eventType);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventInternal(eventType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.186 -0400", hash_original_method = "C58028C1DB413A86B928F475AB0100FB", hash_generated_method = "AD2C278251E1E36EF64037BCEA3DB334")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.sendAccessibilityEventUncheckedInternal(event);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventUncheckedInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.187 -0400", hash_original_method = "5A39804E8EC5B74D862B80B866B8F576", hash_generated_method = "3C2A1B87FD79DA91488A331D63ACA3F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            boolean var07851A778B664A4380C5AF2DDC5C4AEC_241770984 = (host.dispatchPopulateAccessibilityEventInternal(event));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return host.dispatchPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.187 -0400", hash_original_method = "D41C8BE91A25AAE323FB25E37AFB61F0", hash_generated_method = "97FD5D3789D3787A7D5BDFF0751715A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.onPopulateAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.187 -0400", hash_original_method = "D490954174BD599BC02D1199D955E569", hash_generated_method = "911AE7E0A393EF538B9DCF498F4FCC26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            host.onInitializeAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.187 -0400", hash_original_method = "E392CA582CA236DC9AD11007B17CF1A9", hash_generated_method = "19A62EA3E5282EFEBDDC2C084CD564BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(info.dsTaint);
            host.onInitializeAccessibilityNodeInfoInternal(info);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityNodeInfoInternal(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.187 -0400", hash_original_method = "4AE2346D08FE5ECB588C47045A997DF1", hash_generated_method = "A4AE1BD2D68076D0D42FA448B0848445")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(child.dsTaint);
            dsTaint.addTaint(host.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            boolean var9559FB15F4F4402574377E5F8741F1FA_416014215 = (host.onRequestSendAccessibilityEventInternal(child, event));
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
    @Deprecated public static final int STATUS_BAR_DISABLE_NAVIGATION = 
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
    public static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.188 -0400", hash_original_method = "1511B05B546CB67262D01EAC74D91223", hash_generated_method = "803EE5CE3626CEB9EB5B88426E6A8B9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setAlpha(value);
            // ---------- Original Method ----------
            //object.setAlpha(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.188 -0400", hash_original_method = "0828A056C08A4787018BC5ECB849DDAD", hash_generated_method = "EA91A90986A27C191398F652F6C72076")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var4D8B4B98C4B6EBE4133ECBD9FF81A200_567463541 = (object.getAlpha());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getAlpha();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "71D30789CC0083AAA14E647D4066A62B", hash_generated_method = "A3772D47FAB1F20FEBB43AFA20195FAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setTranslationX(value);
            // ---------- Original Method ----------
            //object.setTranslationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "AE4ED8B1A0B86A64F67E6D55304484F8", hash_generated_method = "049893819B3CE4C699D33BF1E017B775")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float varEED5F16AC80A07644913A2997B932751_182537945 = (object.getTranslationX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getTranslationX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "35EB991A21102AE6A66798A0E05F4EB7", hash_generated_method = "57E58EDDBF681FBF98A02427B19DE2AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setTranslationY(value);
            // ---------- Original Method ----------
            //object.setTranslationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "602B4C29E3FDDB39DD10FBFA4C1D4EAD", hash_generated_method = "980418DC38EA1F2B19BF29A67D72A3CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var58A657CFB650C959DD8D322D0AC51070_84437632 = (object.getTranslationY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getTranslationY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> X = new FloatProperty<View>("x") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "942D12A2907E436F9DD2D5A3BB599D1C", hash_generated_method = "8FC3B62E0D8B20A3F327EBC20C79554D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setX(value);
            // ---------- Original Method ----------
            //object.setX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.189 -0400", hash_original_method = "87F550DC0E1D4FED879AF17D796C775D", hash_generated_method = "1EB146BA01556DD524D4F3DB8844FBDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var5F2CAE5DB7956D8489ACF37E9A5649C0_906655885 = (object.getX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> Y = new FloatProperty<View>("y") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "F66C6BF603238C3B745DBF80CCB68E15", hash_generated_method = "A6895AE92454C2D35C21591896E491C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setY(value);
            // ---------- Original Method ----------
            //object.setY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "107F13AA20F45AE0A7AF10B2A89B1B3D", hash_generated_method = "A809A5DBEE0F9BB12DAB0DE914DDC5BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float varEED6AA7425DB7680970822F5379F9BF2_1244142398 = (object.getY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "E4DD5C8F5E4B6A35D65B3372F3D8BFBA", hash_generated_method = "CFBE1DDEA6D0C294607DC863A6D866C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotation(value);
            // ---------- Original Method ----------
            //object.setRotation(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "6F0DC1763312BEA34F1272E5458BA30D", hash_generated_method = "9AC0FF1EC778EC9E5A8CBD9CC899D7E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var2D180CFD31CAAC37E5188717E487F8A2_164957428 = (object.getRotation());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotation();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "D8E97A391BF9703940D7A06280ABBB3F", hash_generated_method = "FCC6C249AEB0A443C12ADEAB95D4B116")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotationX(value);
            // ---------- Original Method ----------
            //object.setRotationX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.190 -0400", hash_original_method = "3FE8B70962F32AF948528D0D6E8ED1AF", hash_generated_method = "8E5AF68EF4AC0767FD9C0A42716F77DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var69F6E7E3C4CD70A17389B8C6B586AD28_582152403 = (object.getRotationX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotationX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.191 -0400", hash_original_method = "CDE80AB2A44D5B173DB76AD6CA4559A4", hash_generated_method = "92CFB71A8AD52AEC7AFD266511E1948E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setRotationY(value);
            // ---------- Original Method ----------
            //object.setRotationY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.191 -0400", hash_original_method = "EE835584282672E99083546AE5304355", hash_generated_method = "60E08D6F51D29EB203531A7E1D09A98F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var3268E4C1849F09F30AA1DC8103BD3FED_2061251890 = (object.getRotationY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getRotationY();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.191 -0400", hash_original_method = "1B653DA1FDE36CFBF0835E42B933826F", hash_generated_method = "647360D15AF35FB6B7EB14BD9A7AF3C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setScaleX(value);
            // ---------- Original Method ----------
            //object.setScaleX(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.191 -0400", hash_original_method = "A2F336BAC519262505475338F6D5EC55", hash_generated_method = "1BE150A8EEBCA8E68C66764FCF19297D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var63093F1F9DC0856715E162B3BEA976CB_1961959603 = (object.getScaleX());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getScaleX();
        }

        
}; //Transformed anonymous class
    public static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.191 -0400", hash_original_method = "1D5FE7CAB5F43F92B9050D214C28178E", hash_generated_method = "8F2F606A424B32F4F82518E94D6D9112")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setValue(View object, float value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(object.dsTaint);
            object.setScaleY(value);
            // ---------- Original Method ----------
            //object.setScaleY(value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.192 -0400", hash_original_method = "CDBF0205ED6FCB3C37D74DE97C039D1E", hash_generated_method = "5225517B9A2971D1022D33FA8D6D7A23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Float get(View object) {
            dsTaint.addTaint(object.dsTaint);
            Float var0084208E1E15478487BDC4032EB24659_506039102 = (object.getScaleY());
            return (Float)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object.getScaleY();
        }

        
}; //Transformed anonymous class
}

