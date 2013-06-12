package android.view;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.HashSet;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;

import com.android.internal.R;
import com.android.internal.util.Predicate;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    private static final boolean DBG = false;
    protected ArrayList<View> mDisappearingChildren;
    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    private View mFocused;
    private final Transformation mChildTransformation = new Transformation();
    private RectF mInvalidateRegion;
    private Transformation mInvalidationTransformation;
    private View mCurrentDragView;
    private DragEvent mCurrentDrag;
    private HashSet<View> mDragNotifiedChildren;
    private boolean mChildAcceptsDrag;
    private final PointF mLocalPoint = new PointF();
    private LayoutAnimationController mLayoutAnimationController;
    private Animation.AnimationListener mAnimationListener;
    private TouchTarget mFirstTouchTarget;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private long mLastTouchDownTime;
    @ViewDebug.ExportedProperty(category = "events")
    private int mLastTouchDownIndex = -1;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private float mLastTouchDownX;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private float mLastTouchDownY;
    private HoverTarget mFirstHoverTarget;
    private boolean mHoveredSelf;
    protected int mGroupFlags;
    private static final int FLAG_CLIP_CHILDREN = 0x1;
    private static final int FLAG_CLIP_TO_PADDING = 0x2;
    private static final int FLAG_INVALIDATE_REQUIRED  = 0x4;
    private static final int FLAG_RUN_ANIMATION = 0x8;
    private static final int FLAG_ANIMATION_DONE = 0x10;
    private static final int FLAG_PADDING_NOT_NULL = 0x20;
    private static final int FLAG_ANIMATION_CACHE = 0x40;
    private static final int FLAG_OPTIMIZE_INVALIDATE = 0x80;
    private static final int FLAG_CLEAR_TRANSFORMATION = 0x100;
    private static final int FLAG_NOTIFY_ANIMATION_LISTENER = 0x200;
    protected static final int FLAG_USE_CHILD_DRAWING_ORDER = 0x400;
    protected static final int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 0x800;
    private static final int FLAG_ALPHA_LOWER_THAN_ONE = 0x1000;
    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 0x2000;
    private static final int FLAG_ALWAYS_DRAWN_WITH_CACHE = 0x4000;
    private static final int FLAG_CHILDREN_DRAWN_WITH_CACHE = 0x8000;
    private static final int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 0x10000;
    private static final int FLAG_MASK_FOCUSABILITY = 0x60000;
    public static final int FOCUS_BEFORE_DESCENDANTS = 0x20000;
    public static final int FOCUS_AFTER_DESCENDANTS = 0x40000;
    public static final int FOCUS_BLOCK_DESCENDANTS = 0x60000;
    private static final int[] DESCENDANT_FOCUSABILITY_FLAGS =
            {FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS,
                    FOCUS_BLOCK_DESCENDANTS};
    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;
    private static final int FLAG_SPLIT_MOTION_EVENTS = 0x200000;
    private static final int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 0x400000;
    protected int mPersistentDrawingCache;
    public static final int PERSISTENT_NO_CACHE = 0x0;
    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
    public static final int PERSISTENT_ALL_CACHES = 0x3;
    protected static final int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
    private static final int CHILD_LEFT_INDEX = 0;
    private static final int CHILD_TOP_INDEX = 1;
    private View[] mChildren;
    private boolean mLayoutSuppressed = false;
    private int mChildrenCount;
    private static final int ARRAY_INITIAL_CAPACITY = 12;
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private Paint mCachePaint;
    private LayoutTransition mTransition;
    private ArrayList<View> mTransitioningViews;
    private ArrayList<View> mVisibilityChangingChildren;
    @ViewDebug.ExportedProperty(category = "drawing")
    private boolean mDrawLayers = true;
    private LayoutTransition.TransitionListener mLayoutTransitionListener = new LayoutTransition.TransitionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.263 -0400", hash_original_method = "BD73D83C5E4C50AAE7C2D0E44AB74A47", hash_generated_method = "44FD8FAFB1CE0F37A6C2D3AADDBDB005")
        @DSModeled(DSC.SAFE)
        @Override
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            dsTaint.addTaint(container.dsTaint);
            dsTaint.addTaint(transition.dsTaint);
            dsTaint.addTaint(transitionType);
            dsTaint.addTaint(view.dsTaint);
            {
                startViewTransition(view);
            } //End block
            // ---------- Original Method ----------
            //if (transitionType == LayoutTransition.DISAPPEARING) {
                //startViewTransition(view);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "04DFE6408D192F5CD42CA1A3B87396E7", hash_generated_method = "60D46AF8EEF3391DFD349836D992C3D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            dsTaint.addTaint(container.dsTaint);
            dsTaint.addTaint(transition.dsTaint);
            dsTaint.addTaint(transitionType);
            dsTaint.addTaint(view.dsTaint);
            {
                boolean var00EE79CB64B66FAC37BA4FE35CB2471D_1302508683 = (mLayoutSuppressed && !transition.isChangingLayout());
                {
                    requestLayout();
                    mLayoutSuppressed = false;
                } //End block
            } //End collapsed parenthetic
            {
                endViewTransition(view);
            } //End block
            // ---------- Original Method ----------
            //if (mLayoutSuppressed && !transition.isChangingLayout()) {
                //requestLayout();
                //mLayoutSuppressed = false;
            //}
            //if (transitionType == LayoutTransition.DISAPPEARING && mTransitioningViews != null) {
                //endViewTransition(view);
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "BB3ABAE42DB2573B678438304DA09BAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewGroup(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        initViewGroup();
        // ---------- Original Method ----------
        //initViewGroup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "01EF181B5B9BD1E2AA94519EF8FAEC5E", hash_generated_method = "37D65D0F9CCA5F0DAB771CA4B1D17590")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        initViewGroup();
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "FE20AAD08B3866F38DB1C82409548865", hash_generated_method = "1E8C92F89CA15C496FFBAA95CC5DC2A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        initViewGroup();
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "8201DDC69D3895B689FCA6813D812A1F", hash_generated_method = "9A4621ABEBC02ECEEFBF0907FC803EAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initViewGroup() {
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        {
            boolean varEEA1697260544E0A5861DD090A86C488_1296190284 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
            {
                mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
            } //End block
        } //End collapsed parenthetic
        setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        mChildren = new View[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;
        mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
        // ---------- Original Method ----------
        //setFlags(WILL_NOT_DRAW, DRAW_MASK);
        //mGroupFlags |= FLAG_CLIP_CHILDREN;
        //mGroupFlags |= FLAG_CLIP_TO_PADDING;
        //mGroupFlags |= FLAG_ANIMATION_DONE;
        //mGroupFlags |= FLAG_ANIMATION_CACHE;
        //mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        //if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB) {
            //mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        //}
        //setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        //mChildren = new View[ARRAY_INITIAL_CAPACITY];
        //mChildrenCount = 0;
        //mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "4BC426CDAC642CD3FACBBAAA9F56EF39", hash_generated_method = "0CFF864D231B1C2D2E3C7390121700E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromAttributes(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                R.styleable.ViewGroup);
        final int N;
        N = a.getIndexCount();
        {
            int i;
            i = 0;
            {
                int attr;
                attr = a.getIndex(i);
                //Begin case R.styleable.ViewGroup_clipChildren 
                setClipChildren(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_clipChildren 
                //Begin case R.styleable.ViewGroup_clipToPadding 
                setClipToPadding(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_clipToPadding 
                //Begin case R.styleable.ViewGroup_animationCache 
                setAnimationCacheEnabled(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_animationCache 
                //Begin case R.styleable.ViewGroup_persistentDrawingCache 
                setPersistentDrawingCache(a.getInt(attr, PERSISTENT_SCROLLING_CACHE));
                //End case R.styleable.ViewGroup_persistentDrawingCache 
                //Begin case R.styleable.ViewGroup_addStatesFromChildren 
                setAddStatesFromChildren(a.getBoolean(attr, false));
                //End case R.styleable.ViewGroup_addStatesFromChildren 
                //Begin case R.styleable.ViewGroup_alwaysDrawnWithCache 
                setAlwaysDrawnWithCacheEnabled(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_alwaysDrawnWithCache 
                //Begin case R.styleable.ViewGroup_layoutAnimation 
                int id;
                id = a.getResourceId(attr, -1);
                //End case R.styleable.ViewGroup_layoutAnimation 
                //Begin case R.styleable.ViewGroup_layoutAnimation 
                {
                    setLayoutAnimation(AnimationUtils.loadLayoutAnimation(mContext, id));
                } //End block
                //End case R.styleable.ViewGroup_layoutAnimation 
                //Begin case R.styleable.ViewGroup_descendantFocusability 
                setDescendantFocusability(DESCENDANT_FOCUSABILITY_FLAGS[a.getInt(attr, 0)]);
                //End case R.styleable.ViewGroup_descendantFocusability 
                //Begin case R.styleable.ViewGroup_splitMotionEvents 
                setMotionEventSplittingEnabled(a.getBoolean(attr, false));
                //End case R.styleable.ViewGroup_splitMotionEvents 
                //Begin case R.styleable.ViewGroup_animateLayoutChanges 
                boolean animateLayoutChanges;
                animateLayoutChanges = a.getBoolean(attr, false);
                //End case R.styleable.ViewGroup_animateLayoutChanges 
                //Begin case R.styleable.ViewGroup_animateLayoutChanges 
                {
                    setLayoutTransition(new LayoutTransition());
                } //End block
                //End case R.styleable.ViewGroup_animateLayoutChanges 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.264 -0400", hash_original_method = "9DEFF27CA0C7CA0A646DEBC837B35971", hash_generated_method = "56412A870031ADCDB7CFB4F219C55F3C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "focus", mapping = {
        @ViewDebug.IntToString(from = FOCUS_BEFORE_DESCENDANTS, to = "FOCUS_BEFORE_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_AFTER_DESCENDANTS, to = "FOCUS_AFTER_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_BLOCK_DESCENDANTS, to = "FOCUS_BLOCK_DESCENDANTS")
    })
    public int getDescendantFocusability() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGroupFlags & FLAG_MASK_FOCUSABILITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "0404A0C2267D357D33DA2838086AAD01", hash_generated_method = "CEDDB97D197341A7B49C227ACC88003F")
    @DSModeled(DSC.SAFE)
    public void setDescendantFocusability(int focusability) {
        dsTaint.addTaint(focusability);
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        //End case default 
        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
        // ---------- Original Method ----------
        //switch (focusability) {
            //case FOCUS_BEFORE_DESCENDANTS:
            //case FOCUS_AFTER_DESCENDANTS:
            //case FOCUS_BLOCK_DESCENDANTS:
                //break;
            //default:
                //throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        //+ "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        //}
        //mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        //mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "1894A66AF55103F8230E4E4C184BE483", hash_generated_method = "AE01709E6F8003DC8B6997A2F6B37776")
    @DSModeled(DSC.SAFE)
    @Override
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            mFocused.unFocus();
            mFocused = null;
        } //End block
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
        // ---------- Original Method ----------
        //if (mFocused != null) {
            //mFocused.unFocus();
            //mFocused = null;
        //}
        //super.handleFocusGainInternal(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "18A4940B9B410F6E2A586E7BEB513255", hash_generated_method = "F6B2094C72732CF4618AF82B1B3E218C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestChildFocus(View child, View focused) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(focused.dsTaint);
        {
            System.out.println(this + " requestChildFocus()");
        } //End block
        {
            boolean varD47ACE2ACEC5C175A0471B099816BE37_1433440844 = (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS);
        } //End collapsed parenthetic
        super.unFocus();
        {
            {
                mFocused.unFocus();
            } //End block
        } //End block
        {
            mParent.requestChildFocus(this, focused);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " requestChildFocus()");
        //}
        //if (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS) {
            //return;
        //}
        //super.unFocus();
        //if (mFocused != child) {
            //if (mFocused != null) {
                //mFocused.unFocus();
            //}
            //mFocused = child;
        //}
        //if (mParent != null) {
            //mParent.requestChildFocus(this, focused);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "B9C632089323DEB68745C50418B61ADF", hash_generated_method = "A8CABE93396EB30736ED8911F6863561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusableViewAvailable(View v) {
        dsTaint.addTaint(v.dsTaint);
        {
            boolean varB10813EF6870F670C964BBAED5788EED_1545740590 = (mParent != null
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS));
            {
                mParent.focusableViewAvailable(v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mParent != null
                //&& (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                //&& !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS)) {
            //mParent.focusableViewAvailable(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "AAA08A22C93220CA5F37A81C00115203", hash_generated_method = "CBE0F8F8569F648CFA12D96C258A0CF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenuForChild(View originalView) {
        dsTaint.addTaint(originalView.dsTaint);
        boolean varBA8B92D993B1A5B6CF969236EEAB6152_1838122667 = (mParent != null && mParent.showContextMenuForChild(originalView));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParent != null && mParent.showContextMenuForChild(originalView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "8C60B2F96F2B489988C14A93A463DAE3", hash_generated_method = "FC8B0A5736EC1E1A52A730BB99D87AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(originalView.dsTaint);
        {
            Object var5E408DB4443FE360E96CE9F1C5BBDCDF_1283074510 = (mParent.startActionModeForChild(originalView, callback));
        } //End flattened ternary
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "32394A633C776A8BC33A6BFC48D3DC37", hash_generated_method = "BA5E8D285EA4AC67C039C85ABC829B37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        {
            boolean var6900EB30484F14AE1B69428931AEDE0D_874474465 = (isRootNamespace());
            {
                View var0906A08A84901482622FE4727E85B5D8_1292807029 = (FocusFinder.getInstance().findNextFocus(this, focused, direction));
            } //End block
            {
                View varEFEA41BC826299E92C70E785F9AC460C_1731881503 = (mParent.focusSearch(focused, direction));
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (isRootNamespace()) {
            //return FocusFinder.getInstance().findNextFocus(this, focused, direction);
        //} else if (mParent != null) {
            //return mParent.focusSearch(focused, direction);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.265 -0400", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "584C2766B3A9FDB4F8C327964B5B9E3C")
    @DSModeled(DSC.SAFE)
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(rectangle.dsTaint);
        dsTaint.addTaint(immediate);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "B4AA594F7D6DA64F58B166664BBA4580", hash_generated_method = "F52ACD53F4683A683FFB47C8019D1690")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        ViewParent parent;
        parent = getParent();
        final boolean propagate;
        propagate = onRequestSendAccessibilityEvent(child, event);
        boolean var441FEE5B5C6B1D4A365CF02E122B98E7_1822158499 = (parent.requestSendAccessibilityEvent(this, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ViewParent parent = getParent();
        //if (parent == null) {
            //return false;
        //}
        //final boolean propagate = onRequestSendAccessibilityEvent(child, event);
        //if (!propagate) {
            //return false;
        //}
        //return parent.requestSendAccessibilityEvent(this, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "0D2782B4A269D15DF81200BFDAFE535A", hash_generated_method = "6C6DD9E70B5DCF110E50F0286EBA9B60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5A0C8D77442C96677A25BCD888A43DDA_338774624 = (mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event));
        } //End block
        {
            boolean var36AE0BB3330710CD64DFF9DF5BCECE4F_1309348220 = (onRequestSendAccessibilityEventInternal(child, event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        //} else {
            //return onRequestSendAccessibilityEventInternal(child, event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "F0DFCA5DE1F330F511BBFF62182D5BD4", hash_generated_method = "A5EDEA5962B85FFD5108352FC09E33CA")
    @DSModeled(DSC.SAFE)
     boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "E35CCEA2DF29F8696C548F55094B5B73", hash_generated_method = "83F2D20438421D92A059AD19AC51EBC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        boolean var661477CC7A374E9FA1E26C430B4E7B43_807625997 = (mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFocused != null &&
                //mFocused.dispatchUnhandledMove(focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "1A8D22FF280DB81B170D27815BE7BEAA", hash_generated_method = "AB31FD1404A8A9373C86CCF5B82C8AF6")
    @DSModeled(DSC.SAFE)
    public void clearChildFocus(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            System.out.println(this + " clearChildFocus()");
        } //End block
        mFocused = null;
        {
            mParent.clearChildFocus(this);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " clearChildFocus()");
        //}
        //mFocused = null;
        //if (mParent != null) {
            //mParent.clearChildFocus(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "2A2B29C64ED25C5483BB6B32C5BD1628", hash_generated_method = "A62671520FEDB6E999237EA9D549D17A")
    @DSModeled(DSC.SAFE)
    @Override
    public void clearFocus() {
        super.clearFocus();
        {
            mFocused.clearFocus();
        } //End block
        // ---------- Original Method ----------
        //super.clearFocus();
        //if (mFocused != null) {
            //mFocused.clearFocus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "AD8CA09F957410559E0C3DF16ADDE822", hash_generated_method = "E1F8BA95ED8E52303F78B0591BACBE99")
    @DSModeled(DSC.SAFE)
    @Override
     void unFocus() {
        {
            System.out.println(this + " unFocus()");
        } //End block
        super.unFocus();
        {
            mFocused.unFocus();
        } //End block
        mFocused = null;
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " unFocus()");
        //}
        //super.unFocus();
        //if (mFocused != null) {
            //mFocused.unFocus();
        //}
        //mFocused = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "6D122BC96403342A3B1B95F722F43D66")
    @DSModeled(DSC.SAFE)
    public View getFocusedChild() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFocused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "3D9AAFDE8E8826B256A10D32D774D94B", hash_generated_method = "DB680E0883469644C578BDC8CA8F2833")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.266 -0400", hash_original_method = "8D50679A3D30F96CD0297A05342EFA70", hash_generated_method = "29CF1C64600F30DE8987AC855914D6E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View findFocus() {
        {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        } //End block
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_912833525 = (isFocused());
        } //End collapsed parenthetic
        {
            View varEF2A7660E1D3D149D3BDB7C10B3A63D6_1089890851 = (mFocused.findFocus());
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println("Find focus in " + this + ": flags="
                    //+ isFocused() + ", child=" + mFocused);
        //}
        //if (isFocused()) {
            //return this;
        //}
        //if (mFocused != null) {
            //return mFocused.findFocus();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.267 -0400", hash_original_method = "415824CC4E37F2B08D458BE00E3F5A3F", hash_generated_method = "844F30DAD6D4F2D595CC7B6DF799509E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasFocusable() {
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_1566421558 = (isFocusable());
        } //End collapsed parenthetic
        final int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    {
                        boolean var7DC29F4EF4EE5211D58EB348F2B6AE7E_1199750478 = (child.hasFocusable());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            //return false;
        //}
        //if (isFocusable()) {
            //return true;
        //}
        //final int descendantFocusability = getDescendantFocusability();
        //if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if (child.hasFocusable()) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.267 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "EC9090CC394D0647445623A9062F130F")
    @DSModeled(DSC.SAFE)
    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(direction);
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.267 -0400", hash_original_method = "A281D125D4DD0434A87F479D62DD0361", hash_generated_method = "C24AA4A3F391A8CEDBA80A630CBE3BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focusableMode);
        final int focusableCount;
        focusableCount = views.size();
        final int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    {
                        child.addFocusables(views, direction, focusableMode);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var0F1BFD0DBC136B3E2580439E8453837C_1973408437 = (descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()));
            {
                super.addFocusables(views, direction, focusableMode);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int focusableCount = views.size();
        //final int descendantFocusability = getDescendantFocusability();
        //if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    //child.addFocusables(views, direction, focusableMode);
                //}
            //}
        //}
        //if (
            //descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                //(focusableCount == views.size())) {
            //super.addFocusables(views, direction, focusableMode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.267 -0400", hash_original_method = "01B0DFF5DFF6A04EF473202885B21AEA", hash_generated_method = "8A729BD83E8060A943838D48E72A357D")
    @DSModeled(DSC.SAFE)
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        dsTaint.addTaint(outViews.dsTaint);
        dsTaint.addTaint(text);
        dsTaint.addTaint(flags);
        super.findViewsWithText(outViews, text, flags);
        final int childrenCount;
        childrenCount = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    child.findViewsWithText(outViews, text, flags);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.findViewsWithText(outViews, text, flags);
        //final int childrenCount = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < childrenCount; i++) {
            //View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    //&& (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //child.findViewsWithText(outViews, text, flags);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.267 -0400", hash_original_method = "E63784DE90D03F6D10488691622E702B", hash_generated_method = "2381DC059C00957919994146AB8AE016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        View foundView;
        foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        final int childrenCount;
        childrenCount = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        //if (foundView != null) {
            //return foundView;
        //}
        //final int childrenCount = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < childrenCount; i++) {
            //View child = children[i];
            //foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
            //if (foundView != null) {
                //return foundView;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "8947E2F3FD45B1E1CD9A8BF9F902DE4D", hash_generated_method = "9477FDCEB981E065863D8E7C2740F450")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        dsTaint.addTaint(hasFocus);
        super.dispatchWindowFocusChanged(hasFocus);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchWindowFocusChanged(hasFocus);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchWindowFocusChanged(hasFocus);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowFocusChanged(hasFocus);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "3C050A87A5AA11FCC905DB1242C91519", hash_generated_method = "5BC46A98AB9207216A147C52AC2C6112")
    @DSModeled(DSC.SAFE)
    @Override
    public void addTouchables(ArrayList<View> views) {
        dsTaint.addTaint(views.dsTaint);
        super.addTouchables(views);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                {
                    child.addTouchables(views);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.addTouchables(views);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //child.addTouchables(views);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "E3ECA4D0183F28678AE9A73BEBE4A4C4", hash_generated_method = "4B4C20BDC33768447F68EBFBC4DAFC64")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchDisplayHint(int hint) {
        dsTaint.addTaint(hint);
        super.dispatchDisplayHint(hint);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchDisplayHint(hint);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchDisplayHint(hint);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchDisplayHint(hint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "39046505104385736A9526E25AC3965D", hash_generated_method = "143E45A31D7F18E4F6E92F6CB6FA6612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onChildVisibilityChanged(View child, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(visibility);
        {
            {
                mTransition.showChild(this, child);
            } //End block
            {
                mTransition.hideChild(this, child);
            } //End block
            {
                {
                    mVisibilityChangingChildren = new ArrayList<View>();
                } //End block
                mVisibilityChangingChildren.add(child);
                {
                    boolean var062D8AB67088E18389484F6801BD9183_1190947586 = (mTransitioningViews != null && mTransitioningViews.contains(child));
                    {
                        addDisappearingView(child);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                notifyChildOfDrag(child);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "66EC1DB8C5DE29B0D05D23F4BE080169", hash_generated_method = "341F0F2D4ED9DCC6D2799D2C17895995")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        super.dispatchVisibilityChanged(changedView, visibility);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchVisibilityChanged(changedView, visibility);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchVisibilityChanged(changedView, visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchVisibilityChanged(changedView, visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "110C8ADF44E81EF076420285F756776D", hash_generated_method = "D8C12EE7DD7131997041B537E9B8FA11")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        dsTaint.addTaint(visibility);
        super.dispatchWindowVisibilityChanged(visibility);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchWindowVisibilityChanged(visibility);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchWindowVisibilityChanged(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowVisibilityChanged(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.268 -0400", hash_original_method = "4BA014AA7FB311F49457CF496AD5B6EF", hash_generated_method = "599AC8FF9761F62B7AFCC35A387A39A5")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        super.dispatchConfigurationChanged(newConfig);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchConfigurationChanged(newConfig);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchConfigurationChanged(newConfig);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.269 -0400", hash_original_method = "F881B5C75EE06984153060972C295D8F", hash_generated_method = "1B376871950ADAC1F85064632B898680")
    @DSModeled(DSC.SAFE)
    public void recomputeViewAttributes(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            ViewParent parent;
            parent = mParent;
            parent.recomputeViewAttributes(this);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            //ViewParent parent = mParent;
            //if (parent != null) parent.recomputeViewAttributes(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.269 -0400", hash_original_method = "99C97332C863B663BFCA518BE284DB35", hash_generated_method = "E475637CDC91572109996D37CC3C76B0")
    @DSModeled(DSC.SAFE)
    @Override
     void dispatchCollectViewAttributes(int visibility) {
        dsTaint.addTaint(visibility);
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchCollectViewAttributes(visibility);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //visibility |= mViewFlags&VISIBILITY_MASK;
        //super.dispatchCollectViewAttributes(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchCollectViewAttributes(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.269 -0400", hash_original_method = "C5DA1A7419AFEADC86BA0783BA235334", hash_generated_method = "3A57BC3FFF9568C7B6E09392C09255A6")
    @DSModeled(DSC.SAFE)
    public void bringChildToFront(View child) {
        dsTaint.addTaint(child.dsTaint);
        int index;
        index = indexOfChild(child);
        {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        } //End block
        // ---------- Original Method ----------
        //int index = indexOfChild(child);
        //if (index >= 0) {
            //removeFromArray(index);
            //addInArray(child, mChildrenCount);
            //child.mParent = this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.269 -0400", hash_original_method = "0B94D743FFC1DE288527F02F6E8345CD", hash_generated_method = "3EBFF38AAC1A990A9E916E8B149F0971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean retval;
        retval = false;
        final float tx;
        tx = event.mX;
        final float ty;
        ty = event.mY;
        ViewRootImpl root;
        root = getViewRootImpl();
        //Begin case DragEvent.ACTION_DRAG_STARTED 
        {
            mCurrentDragView = null;
            mCurrentDrag = DragEvent.obtain(event);
            {
                mDragNotifiedChildren = new HashSet<View>();
            } //End block
            {
                mDragNotifiedChildren.clear();
            } //End block
            mChildAcceptsDrag = false;
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    child.mPrivateFlags2 &= ~View.DRAG_MASK;
                    {
                        boolean var93DCAA7E24F58D6762D32E351E886EF8_755975337 = (child.getVisibility() == VISIBLE);
                        {
                            final boolean handled;
                            handled = notifyChildOfDrag(children[i]);
                            {
                                mChildAcceptsDrag = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                retval = true;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_STARTED 
        //Begin case DragEvent.ACTION_DRAG_ENDED 
        {
            {
                {
                    Iterator<View> seatecAstronomy42 = mDragNotifiedChildren.iterator();
                    seatecAstronomy42.hasNext();
                    View child = seatecAstronomy42.next();
                    {
                        child.dispatchDragEvent(event);
                        child.mPrivateFlags2 &= ~View.DRAG_MASK;
                        child.refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
                mDragNotifiedChildren.clear();
                mCurrentDrag.recycle();
                mCurrentDrag = null;
            } //End block
            {
                retval = true;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_ENDED 
        //Begin case DragEvent.ACTION_DRAG_LOCATION 
        {
            final View target;
            target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                root.setDragFocus(target);
                final int action;
                action = event.mAction;
                {
                    final View view;
                    view = mCurrentDragView;
                    event.mAction = DragEvent.ACTION_DRAG_EXITED;
                    view.dispatchDragEvent(event);
                    view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                    view.refreshDrawableState();
                } //End block
                mCurrentDragView = target;
                {
                    event.mAction = DragEvent.ACTION_DRAG_ENTERED;
                    target.dispatchDragEvent(event);
                    target.mPrivateFlags2 |= View.DRAG_HOVERED;
                    target.refreshDrawableState();
                } //End block
                event.mAction = action;
            } //End block
            {
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_LOCATION 
        //Begin case DragEvent.ACTION_DRAG_EXITED 
        {
            {
                final View view;
                view = mCurrentDragView;
                view.dispatchDragEvent(event);
                view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                view.refreshDrawableState();
                mCurrentDragView = null;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_EXITED 
        //Begin case DragEvent.ACTION_DROP 
        {
            Log.d(View.VIEW_LOG_TAG, "Drop event: " + event);
            View target;
            target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                Log.d(View.VIEW_LOG_TAG, "   dispatch drop to " + target);
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
            {
                {
                    Log.d(View.VIEW_LOG_TAG, "   not dropped on an accepting view");
                } //End block
            } //End block
        } //End block
        //End case DragEvent.ACTION_DROP 
        {
            retval = super.dispatchDragEvent(event);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.270 -0400", hash_original_method = "A61A140E816A1C908C27B7F105ECC965", hash_generated_method = "5780989C5AC1221BA039CCC4FAA8FB7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint) {
        dsTaint.addTaint(outLocalPoint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = count - 1;
            {
                final View child;
                child = children[i];
                {
                    boolean varDD9451246475E78E9B9862A08B40ED39_73508889 = (!child.canAcceptDrag());
                } //End collapsed parenthetic
                {
                    boolean varB60C7CACEA3B7B85D44A4D6C320C4F52_1498753480 = (isTransformedTouchPointInView(x, y, child, outLocalPoint));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = count - 1; i >= 0; i--) {
            //final View child = children[i];
            //if (!child.canAcceptDrag()) {
                //continue;
            //}
            //if (isTransformedTouchPointInView(x, y, child, outLocalPoint)) {
                //return child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.270 -0400", hash_original_method = "01B6DB1535B88ABBDA0897E44597D185", hash_generated_method = "A4B8AE232CDEF863C008626A22AB67CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean notifyChildOfDrag(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        } //End block
        boolean canAccept;
        canAccept = false;
        {
            boolean var9513878AE6807A2BEC04686702F54F4D_523019238 = (! mDragNotifiedChildren.contains(child));
            {
                mDragNotifiedChildren.add(child);
                canAccept = child.dispatchDragEvent(mCurrentDrag);
                {
                    boolean var6E0AEBF66F234C4EF96F0B794A136F59_339429403 = (canAccept && !child.canAcceptDrag());
                    {
                        child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                        child.refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (ViewDebug.DEBUG_DRAG) {
            //Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        //}
        //boolean canAccept = false;
        //if (! mDragNotifiedChildren.contains(child)) {
            //mDragNotifiedChildren.add(child);
            //canAccept = child.dispatchDragEvent(mCurrentDrag);
            //if (canAccept && !child.canAcceptDrag()) {
                //child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                //child.refreshDrawableState();
            //}
        //}
        //return canAccept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.270 -0400", hash_original_method = "6EA017C64305C1BE29415F2C64CCEDD4", hash_generated_method = "479C67130F0BAEEDF47FFD1A65B234A8")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        dsTaint.addTaint(visible);
        super.dispatchSystemUiVisibilityChanged(visible);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                child.dispatchSystemUiVisibilityChanged(visible);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchSystemUiVisibilityChanged(visible);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.dispatchSystemUiVisibilityChanged(visible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.270 -0400", hash_original_method = "5F03A98EA003A081CE87491B56EF094D", hash_generated_method = "8F929E9C7844D8AD9631857925981D24")
    @DSModeled(DSC.SAFE)
    @Override
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        dsTaint.addTaint(localChanges);
        dsTaint.addTaint(localValue);
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                child.updateLocalSystemUiVisibility(localValue, localChanges);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.updateLocalSystemUiVisibility(localValue, localChanges);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.updateLocalSystemUiVisibility(localValue, localChanges);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.270 -0400", hash_original_method = "1796A9ED58069BDF38C7C072FE20CF71", hash_generated_method = "D7CE1390DC95E540B5ACDAD4DB4569B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var69A4D5BA21F9754791BA96F9F5C71142_428387912 = (super.dispatchKeyEventPreIme(event));
        } //End block
        {
            boolean varFE2571F324BFA6DB9FF0B9BEE57E874E_523911725 = (mFocused.dispatchKeyEventPreIme(event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyEventPreIme(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyEventPreIme(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.271 -0400", hash_original_method = "1E41A7E6E3EFA9117FFB3A56DB417CA0", hash_generated_method = "67BFE2353B2EED0020D1EF97219101F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        } //End block
        {
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_414211845 = (super.dispatchKeyEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBA71E8F3A809B2219624C59EBC2DEB55_996527405 = (mFocused.dispatchKeyEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        //}
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //if (super.dispatchKeyEvent(event)) {
                //return true;
            //}
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //if (mFocused.dispatchKeyEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.271 -0400", hash_original_method = "C8DF4A46704EEB88AB3A3DAEBDA2EE59", hash_generated_method = "712818EF020DCDA5B81D1C80DCC1BE54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF75FC08430B3CB671A7FC788738670A4_1315954955 = (super.dispatchKeyShortcutEvent(event));
        } //End block
        {
            boolean var9C5A31847C19CF0D448BFF804D2D7DBC_1132234460 = (mFocused.dispatchKeyShortcutEvent(event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyShortcutEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyShortcutEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.271 -0400", hash_original_method = "CF1D00451039D1CA46B97508DE17783C", hash_generated_method = "56F5784330D5C3DCA67751168FE12CCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        } //End block
        {
            {
                boolean varDD1D6069514DE34833A921C8364915DD_2113101805 = (super.dispatchTrackballEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var0FFB054D71651438CDA84A82C67C65B6_453849748 = (mFocused.dispatchTrackballEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        //}
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //if (super.dispatchTrackballEvent(event)) {
                //return true;
            //}
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //if (mFocused.dispatchTrackballEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.272 -0400", hash_original_method = "E0F6A76AF2BEDB6076446B6A929BAC84", hash_generated_method = "83C6E5CC0D126E78EBF933428E45DA23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"ConstantConditions"})
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        final int action;
        action = event.getAction();
        final boolean interceptHover;
        interceptHover = onInterceptHoverEvent(event);
        event.setAction(action);
        MotionEvent eventNoHistory;
        eventNoHistory = event;
        boolean handled;
        handled = false;
        HoverTarget firstOldHoverTarget;
        firstOldHoverTarget = mFirstHoverTarget;
        mFirstHoverTarget = null;
        {
            final float x;
            x = event.getX();
            final float y;
            y = event.getY();
            final int childrenCount;
            childrenCount = mChildrenCount;
            {
                final View[] children;
                children = mChildren;
                HoverTarget lastHoverTarget;
                lastHoverTarget = null;
                {
                    int i;
                    i = childrenCount - 1;
                    {
                        final View child;
                        child = children[i];
                        {
                            boolean var39A5B2EF267FE4EA5711368BBCBF6FA1_136899090 = (!canViewReceivePointerEvents(child)
                            || !isTransformedTouchPointInView(x, y, child, null));
                        } //End collapsed parenthetic
                        HoverTarget hoverTarget;
                        hoverTarget = firstOldHoverTarget;
                        final boolean wasHovered;
                        {
                            HoverTarget predecessor;
                            predecessor = null;
                            {
                                {
                                    hoverTarget = HoverTarget.obtain(child);
                                    wasHovered = false;
                                } //End block
                                {
                                    {
                                        predecessor.next = hoverTarget.next;
                                    } //End block
                                    {
                                        firstOldHoverTarget = hoverTarget.next;
                                    } //End block
                                    hoverTarget.next = null;

                                } //End block
                                predecessor = hoverTarget;
                                hoverTarget = hoverTarget.next;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            lastHoverTarget.next = hoverTarget;
                        } //End block
                        {
                            lastHoverTarget = hoverTarget;
                            mFirstHoverTarget = hoverTarget;
                        } //End block
                        {
                            {
                                handled |= dispatchTransformedGenericPointerEvent(
                                    event, child);
                            } //End block
                        } //End block
                        {
                            {
                                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                                eventNoHistory.setAction(action);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                            } //End block
                            {
                                handled |= dispatchTransformedGenericPointerEvent(event, child);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            final View child;
            child = firstOldHoverTarget.child;
            {
                handled |= dispatchTransformedGenericPointerEvent(
                        event, child);
            } //End block
            {
                {
                    dispatchTransformedGenericPointerEvent(
                            event, child);
                } //End block
                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                dispatchTransformedGenericPointerEvent(
                        eventNoHistory, child);
                eventNoHistory.setAction(action);
            } //End block
            final HoverTarget nextOldHoverTarget;
            nextOldHoverTarget = firstOldHoverTarget.next;
            firstOldHoverTarget.recycle();
            firstOldHoverTarget = nextOldHoverTarget;
        } //End block
        boolean newHoveredSelf;
        newHoveredSelf = !handled;
        {
            {
                handled |= super.dispatchHoverEvent(event);
            } //End block
        } //End block
        {
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                } //End block
                {
                    {
                        super.dispatchHoverEvent(event);
                    } //End block
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                    super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                } //End block
                mHoveredSelf = false;
            } //End block
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                    mHoveredSelf = true;
                } //End block
                {
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    mHoveredSelf = true;
                } //End block
            } //End block
        } //End block
        {
            eventNoHistory.recycle();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.272 -0400", hash_original_method = "CAF0CE39145036A2F3E98F46F45FF397", hash_generated_method = "E1710B50F3B9653F988D0A00311AF03F")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean hasHoveredChild() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFirstHoverTarget != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.272 -0400", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "BC46B9D15D3B7626A4FB83A90FE6F826")
    @DSModeled(DSC.SAFE)
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.272 -0400", hash_original_method = "3C4B461351AF94CBFA481AEA5D81EC08", hash_generated_method = "E9BAEB8FD408A7A94C4F16FE55B13E8E")
    private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.272 -0400", hash_original_method = "8425E6039966203E8B52A55F0ACFD97E", hash_generated_method = "09EA55F98E9E156D6BD3566613701D90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        final int childrenCount;
        childrenCount = mChildrenCount;
        {
            final View[] children;
            children = mChildren;
            final float x;
            x = event.getX();
            final float y;
            y = event.getY();
            {
                int i;
                i = childrenCount - 1;
                {
                    final View child;
                    child = children[i];
                    {
                        boolean var330479A3EB93BD7FBB36FC9D307449EC_119448625 = (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null));
                    } //End collapsed parenthetic
                    {
                        boolean varE3F3EFAB7A0C507CFC1087341B7293FA_1319368550 = (dispatchTransformedGenericPointerEvent(event, child));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var08E200417CAE6114EB8B8E0EE91851EC_2143940965 = (super.dispatchGenericPointerEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int childrenCount = mChildrenCount;
        //if (childrenCount != 0) {
            //final View[] children = mChildren;
            //final float x = event.getX();
            //final float y = event.getY();
            //for (int i = childrenCount - 1; i >= 0; i--) {
                //final View child = children[i];
                //if (!canViewReceivePointerEvents(child)
                        //|| !isTransformedTouchPointInView(x, y, child, null)) {
                    //continue;
                //}
                //if (dispatchTransformedGenericPointerEvent(event, child)) {
                    //return true;
                //}
            //}
        //}
        //return super.dispatchGenericPointerEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.273 -0400", hash_original_method = "EF2476E6EC182ADC11908B65D0A31365", hash_generated_method = "51AE8734ADC96257A338E77DC2C435C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB46815DBC1BC9F2955B6C32C32EC3809_827103995 = (super.dispatchGenericFocusedEvent(event));
        } //End block
        {
            boolean varDAA7826F7D7AE31750BF98F87DE576DE_1116478840 = (mFocused.dispatchGenericMotionEvent(event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchGenericFocusedEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchGenericMotionEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.273 -0400", hash_original_method = "89F3902132A72D71D534028C51E6FDBB", hash_generated_method = "15DDF1CEFFC063C8A810D12272A3D69F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        final float offsetX;
        offsetX = mScrollX - child.mLeft;
        final float offsetY;
        offsetY = mScrollY - child.mTop;
        boolean handled;
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_1557006786 = (!child.hasIdentityMatrix());
            {
                MotionEvent transformedEvent;
                transformedEvent = MotionEvent.obtain(event);
                transformedEvent.offsetLocation(offsetX, offsetY);
                transformedEvent.transform(child.getInverseMatrix());
                handled = child.dispatchGenericMotionEvent(transformedEvent);
                transformedEvent.recycle();
            } //End block
            {
                event.offsetLocation(offsetX, offsetY);
                handled = child.dispatchGenericMotionEvent(event);
                event.offsetLocation(-offsetX, -offsetY);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final float offsetX = mScrollX - child.mLeft;
        //final float offsetY = mScrollY - child.mTop;
        //boolean handled;
        //if (!child.hasIdentityMatrix()) {
            //MotionEvent transformedEvent = MotionEvent.obtain(event);
            //transformedEvent.offsetLocation(offsetX, offsetY);
            //transformedEvent.transform(child.getInverseMatrix());
            //handled = child.dispatchGenericMotionEvent(transformedEvent);
            //transformedEvent.recycle();
        //} else {
            //event.offsetLocation(offsetX, offsetY);
            //handled = child.dispatchGenericMotionEvent(event);
            //event.offsetLocation(-offsetX, -offsetY);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "9A4777971E22B675E68E924B82246A95", hash_generated_method = "E91B413424C02F7FB018ABA5E0B5335A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 1);
        } //End block
        boolean handled;
        handled = false;
        {
            boolean var6CC6773C2F32650974B473D1B32A8111_1761319573 = (onFilterTouchEventForSecurity(ev));
            {
                final int action;
                action = ev.getAction();
                final int actionMasked;
                actionMasked = action & MotionEvent.ACTION_MASK;
                {
                    cancelAndClearTouchTargets(ev);
                    resetTouchState();
                } //End block
                final boolean intercepted;
                {
                    final boolean disallowIntercept;
                    disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
                    {
                        intercepted = onInterceptTouchEvent(ev);
                        ev.setAction(action);
                    } //End block
                } //End block
                final boolean canceled;
                canceled = resetCancelNextUpFlag(this)
                    || actionMasked == MotionEvent.ACTION_CANCEL;
                final boolean split;
                split = (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) != 0;
                TouchTarget newTouchTarget;
                newTouchTarget = null;
                boolean alreadyDispatchedToNewTouchTarget;
                alreadyDispatchedToNewTouchTarget = false;
                {
                    {
                        final int actionIndex;
                        actionIndex = ev.getActionIndex();
                        final int idBitsToAssign;
                        idBitsToAssign = 1 << ev.getPointerId(actionIndex);
                        removePointersFromTouchTargets(idBitsToAssign);
                        final int childrenCount;
                        childrenCount = mChildrenCount;
                        {
                            final View[] children;
                            children = mChildren;
                            final float x;
                            x = ev.getX(actionIndex);
                            final float y;
                            y = ev.getY(actionIndex);
                            {
                                int i;
                                i = childrenCount - 1;
                                {
                                    final View child;
                                    child = children[i];
                                    {
                                        boolean varA03062BDD929C4635E5C5D880ED86080_860451138 = (!canViewReceivePointerEvents(child)
                                    || !isTransformedTouchPointInView(x, y, child, null));
                                    } //End collapsed parenthetic
                                    newTouchTarget = getTouchTarget(child);
                                    {
                                        newTouchTarget.pointerIdBits |= idBitsToAssign;
                                    } //End block
                                    resetCancelNextUpFlag(child);
                                    {
                                        boolean var4D2A48697299CECF9F8D426E12ED9A2F_1762721689 = (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign));
                                        {
                                            mLastTouchDownTime = ev.getDownTime();
                                            mLastTouchDownIndex = i;
                                            mLastTouchDownX = ev.getX();
                                            mLastTouchDownY = ev.getY();
                                            newTouchTarget = addTouchTarget(child, idBitsToAssign);
                                            alreadyDispatchedToNewTouchTarget = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            newTouchTarget = mFirstTouchTarget;
                            {
                                newTouchTarget = newTouchTarget.next;
                            } //End block
                            newTouchTarget.pointerIdBits |= idBitsToAssign;
                        } //End block
                    } //End block
                } //End block
                {
                    handled = dispatchTransformedTouchEvent(ev, canceled, null,
                        TouchTarget.ALL_POINTER_IDS);
                } //End block
                {
                    TouchTarget predecessor;
                    predecessor = null;
                    TouchTarget target;
                    target = mFirstTouchTarget;
                    {
                        final TouchTarget next;
                        next = target.next;
                        {
                            handled = true;
                        } //End block
                        {
                            final boolean cancelChild;
                            cancelChild = resetCancelNextUpFlag(target.child)
                        || intercepted;
                            {
                                boolean varEA3E26DE3C0C658C465A175EDB865343_1540833882 = (dispatchTransformedTouchEvent(ev, cancelChild,
                                target.child, target.pointerIdBits));
                                {
                                    handled = true;
                                } //End block
                            } //End collapsed parenthetic
                            {
                                {
                                    mFirstTouchTarget = next;
                                } //End block
                                {
                                    predecessor.next = next;
                                } //End block
                                target.recycle();
                                target = next;
                            } //End block
                        } //End block
                        predecessor = target;
                        target = next;
                    } //End block
                } //End block
                {
                    resetTouchState();
                } //End block
                {
                    final int actionIndex;
                    actionIndex = ev.getActionIndex();
                    final int idBitsToRemove;
                    idBitsToRemove = 1 << ev.getPointerId(actionIndex);
                    removePointersFromTouchTargets(idBitsToRemove);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 1);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "1B0EC47DAA405380670E223779C878A6", hash_generated_method = "660268D2143C42D1D7DB13B6840E36E4")
    @DSModeled(DSC.SAFE)
    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        // ---------- Original Method ----------
        //clearTouchTargets();
        //resetCancelNextUpFlag(this);
        //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "B31FF6D343B2149E4D841C0A7CD04309", hash_generated_method = "D88EA26AEEBAB6E1A6FB799A7FD0AF7E")
    @DSModeled(DSC.SAFE)
    private boolean resetCancelNextUpFlag(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0) {
            //view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "C1060B6E54563910E15717B9621A0CC6", hash_generated_method = "C47E48BF9F81A947C6BC9A40878FEB34")
    @DSModeled(DSC.SAFE)
    private void clearTouchTargets() {
        TouchTarget target;
        target = mFirstTouchTarget;
        {
            {
                TouchTarget next;
                next = target.next;
                target.recycle();
                target = next;
            } //End block
            mFirstTouchTarget = null;
        } //End block
        // ---------- Original Method ----------
        //TouchTarget target = mFirstTouchTarget;
        //if (target != null) {
            //do {
                //TouchTarget next = target.next;
                //target.recycle();
                //target = next;
            //} while (target != null);
            //mFirstTouchTarget = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "45B19A2C35386F46FF7561697C2C88B0", hash_generated_method = "1061DE16231E54915D7CAE1EEEFD71DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelAndClearTouchTargets(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean syntheticEvent;
            syntheticEvent = false;
            {
                final long now;
                now = SystemClock.uptimeMillis();
                event = MotionEvent.obtain(now, now,
                        MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                syntheticEvent = true;
            } //End block
            {
                TouchTarget target;
                target = mFirstTouchTarget;
                target = target.next;
                {
                    resetCancelNextUpFlag(target.child);
                    dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
                } //End block
            } //End collapsed parenthetic
            clearTouchTargets();
            {
                event.recycle();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mFirstTouchTarget != null) {
            //boolean syntheticEvent = false;
            //if (event == null) {
                //final long now = SystemClock.uptimeMillis();
                //event = MotionEvent.obtain(now, now,
                        //MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                //event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                //syntheticEvent = true;
            //}
            //for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
                //resetCancelNextUpFlag(target.child);
                //dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
            //}
            //clearTouchTargets();
            //if (syntheticEvent) {
                //event.recycle();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.274 -0400", hash_original_method = "1855BFFFC59D88D1613C9B59C4B43D4C", hash_generated_method = "E47591830DE309961044A8D0B5201608")
    @DSModeled(DSC.SAFE)
    private TouchTarget getTouchTarget(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            TouchTarget target;
            target = mFirstTouchTarget;
            target = target.next;
        } //End collapsed parenthetic
        return (TouchTarget)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
            //if (target.child == child) {
                //return target;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.275 -0400", hash_original_method = "70A66C4E824C8984FFB5B6F600FB9D61", hash_generated_method = "7635DFFF4817F64ECBDE7289C94707B2")
    @DSModeled(DSC.SAFE)
    private TouchTarget addTouchTarget(View child, int pointerIdBits) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(pointerIdBits);
        TouchTarget target;
        target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        return (TouchTarget)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        //target.next = mFirstTouchTarget;
        //mFirstTouchTarget = target;
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.275 -0400", hash_original_method = "89D343983AE77FFA55E239C56C6BE82A", hash_generated_method = "FF9219A6416ABD5F5BE738312C2E6EDB")
    @DSModeled(DSC.SAFE)
    private void removePointersFromTouchTargets(int pointerIdBits) {
        dsTaint.addTaint(pointerIdBits);
        TouchTarget predecessor;
        predecessor = null;
        TouchTarget target;
        target = mFirstTouchTarget;
        {
            final TouchTarget next;
            next = target.next;
            {
                target.pointerIdBits &= ~pointerIdBits;
                {
                    {
                        mFirstTouchTarget = next;
                    } //End block
                    {
                        predecessor.next = next;
                    } //End block
                    target.recycle();
                    target = next;
                } //End block
            } //End block
            predecessor = target;
            target = next;
        } //End block
        // ---------- Original Method ----------
        //TouchTarget predecessor = null;
        //TouchTarget target = mFirstTouchTarget;
        //while (target != null) {
            //final TouchTarget next = target.next;
            //if ((target.pointerIdBits & pointerIdBits) != 0) {
                //target.pointerIdBits &= ~pointerIdBits;
                //if (target.pointerIdBits == 0) {
                    //if (predecessor == null) {
                        //mFirstTouchTarget = next;
                    //} else {
                        //predecessor.next = next;
                    //}
                    //target.recycle();
                    //target = next;
                    //continue;
                //}
            //}
            //predecessor = target;
            //target = next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.275 -0400", hash_original_method = "5E78DBE908A174B59A44CE610A67A64A", hash_generated_method = "49FA5446EE13C8EC604BB2D49DF8615A")
    private static boolean canViewReceivePointerEvents(View child) {
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.275 -0400", hash_original_method = "DEC14653C28ED7E684FDD980020C985C", hash_generated_method = "213EDDE88B0573D2F0DA92C819B1897B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(outLocalPoint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        float localX;
        localX = x + mScrollX - child.mLeft;
        float localY;
        localY = y + mScrollY - child.mTop;
        {
            boolean var010B39BB8F6D9891F4618A1B3F847C15_1984893349 = (! child.hasIdentityMatrix() && mAttachInfo != null);
            {
                final float[] localXY;
                localXY = mAttachInfo.mTmpTransformLocation;
                localXY[0] = localX;
                localXY[1] = localY;
                child.getInverseMatrix().mapPoints(localXY);
                localX = localXY[0];
                localY = localXY[1];
            } //End block
        } //End collapsed parenthetic
        final boolean isInView;
        isInView = child.pointInView(localX, localY);
        {
            outLocalPoint.set(localX, localY);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //float localX = x + mScrollX - child.mLeft;
        //float localY = y + mScrollY - child.mTop;
        //if (! child.hasIdentityMatrix() && mAttachInfo != null) {
            //final float[] localXY = mAttachInfo.mTmpTransformLocation;
            //localXY[0] = localX;
            //localXY[1] = localY;
            //child.getInverseMatrix().mapPoints(localXY);
            //localX = localXY[0];
            //localY = localXY[1];
        //}
        //final boolean isInView = child.pointInView(localX, localY);
        //if (isInView && outLocalPoint != null) {
            //outLocalPoint.set(localX, localY);
        //}
        //return isInView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "EAB22EDFF178A3FABE990E65ADB3332F", hash_generated_method = "7D8C6FD593E432F92D72ED9197BF9FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(desiredPointerIdBits);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(cancel);
        final boolean handled;
        final int oldAction;
        oldAction = event.getAction();
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
            {
                handled = super.dispatchTouchEvent(event);
            } //End block
            event.setAction(oldAction);
        } //End block
        final int oldPointerIdBits;
        oldPointerIdBits = event.getPointerIdBits();
        final int newPointerIdBits;
        newPointerIdBits = oldPointerIdBits & desiredPointerIdBits;
        final MotionEvent transformedEvent;
        {
            {
                boolean varF3923A48A5FA342E540F86C39C1C463E_1097826874 = (child == null || child.hasIdentityMatrix());
                {
                    {
                        final float offsetX;
                        offsetX = mScrollX - child.mLeft;
                        final float offsetY;
                        offsetY = mScrollY - child.mTop;
                        event.offsetLocation(offsetX, offsetY);
                        event.offsetLocation(-offsetX, -offsetY);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            transformedEvent = MotionEvent.obtain(event);
        } //End block
        {
            final float offsetX;
            offsetX = mScrollX - child.mLeft;
            final float offsetY;
            offsetY = mScrollY - child.mTop;
            transformedEvent.offsetLocation(offsetX, offsetY);
            {
                boolean varAB47417F79C7B7F4A08CD74D30CD9C74_330607419 = (! child.hasIdentityMatrix());
                {
                    transformedEvent.transform(child.getInverseMatrix());
                } //End block
            } //End collapsed parenthetic
 
        } //End block
        transformedEvent.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "2F47BE30FCD7EA97F91B7B6F74081615", hash_generated_method = "A8CCAC1C407B245EE82CBF01C35C3305")
    @DSModeled(DSC.SAFE)
    public void setMotionEventSplittingEnabled(boolean split) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(split);
        {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        // ---------- Original Method ----------
        //if (split) {
            //mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        //} else {
            //mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "F89425D39488194D486F55EA5F8582C3", hash_generated_method = "08AA4B02235B7E11904C0E0A0DCFDD9F")
    @DSModeled(DSC.SAFE)
    public boolean isMotionEventSplittingEnabled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "1DFD5D86FC853DC6CE8B88AE68ABB735", hash_generated_method = "D08F114F05A9FC0AC05D822A633B1DF8")
    @DSModeled(DSC.SAFE)
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        dsTaint.addTaint(disallowIntercept);
        {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } //End block
        {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        } //End block
        {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        } //End block
        // ---------- Original Method ----------
        //if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            //return;
        //}
        //if (disallowIntercept) {
            //mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        //} else {
            //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        //}
        //if (mParent != null) {
            //mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "B4462738B2524326522C402AD869B0DD")
    @DSModeled(DSC.SAFE)
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.276 -0400", hash_original_method = "C4273E4BE381C7F0CE1D54BE1CF759CA", hash_generated_method = "CFFC230605306A257628EFD66E1B3F3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            System.out.println(this + " ViewGroup.requestFocus direction="
                    + direction);
        } //End block
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        //Begin case FOCUS_BLOCK_DESCENDANTS 
        boolean var47E40A2FCA4828C6DE42D7889D59C941_1562232793 = (super.requestFocus(direction, previouslyFocusedRect));
        //End case FOCUS_BLOCK_DESCENDANTS 
        //Begin case FOCUS_BEFORE_DESCENDANTS 
        {
            final boolean took;
            took = super.requestFocus(direction, previouslyFocusedRect);
            {
                Object var3A5A180257AE9AD15DBCD18319037603_276818753 = (onRequestFocusInDescendants(direction, previouslyFocusedRect));
            } //End flattened ternary
        } //End block
        //End case FOCUS_BEFORE_DESCENDANTS 
        //Begin case FOCUS_AFTER_DESCENDANTS 
        {
            final boolean took;
            took = onRequestFocusInDescendants(direction, previouslyFocusedRect);
            {
                Object var7EEFFE453EE8B06336FEADC34AE77D1B_1413608470 = (super.requestFocus(direction, previouslyFocusedRect));
            } //End flattened ternary
        } //End block
        //End case FOCUS_AFTER_DESCENDANTS 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("descendant focusability must be "
                        + "one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS "
                        + "but is " + descendantFocusability);
        //End case default 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "47C4A34C6E68C9FD22237D5A1759ABE2", hash_generated_method = "D227F17FD4A33AC3EA733D081F5E6917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"ConstantConditions"})
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        int index;
        int increment;
        int end;
        int count;
        count = mChildrenCount;
        {
            index = 0;
            increment = 1;
            end = count;
        } //End block
        {
            index = count - 1;
            increment = -1;
            end = -1;
        } //End block
        final View[] children;
        children = mChildren;
        {
            int i;
            i = index;
            i += increment;
            {
                View child;
                child = children[i];
                {
                    {
                        boolean var86823278073885F35F11C1598EACBFE2_1022641167 = (child.requestFocus(direction, previouslyFocusedRect));
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int index;
        //int increment;
        //int end;
        //int count = mChildrenCount;
        //if ((direction & FOCUS_FORWARD) != 0) {
            //index = 0;
            //increment = 1;
            //end = count;
        //} else {
            //index = count - 1;
            //increment = -1;
            //end = -1;
        //}
        //final View[] children = mChildren;
        //for (int i = index; i != end; i += increment) {
            //View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //if (child.requestFocus(direction, previouslyFocusedRect)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "C10088C0D1BE61F270AE8158B60FC677", hash_generated_method = "746FD2413E830890627C59A3A4517D3B")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchStartTemporaryDetach();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchStartTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchStartTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "F13891122244193473AAFE5583088FC4", hash_generated_method = "23850B615987ADC1B54799BFC5A8A678")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchFinishTemporaryDetach();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchFinishTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchFinishTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "8739A5508C26F7DDD3FFEBEE4CD95BC5", hash_generated_method = "C28663B3F9C07DC3EAB393E74F3CBB1C")
    @DSModeled(DSC.SAFE)
    @Override
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(info.dsTaint);
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchAttachedToWindow(info, visibility);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        //super.dispatchAttachedToWindow(info, visibility);
        //mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        //visibility |= mViewFlags & VISIBILITY_MASK;
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchAttachedToWindow(info, visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "1EE087DB6D320A1AB0B1F5665AE9972D", hash_generated_method = "F89DB860912B7506573E0C30D55B75A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean handled;
        handled = super.dispatchPopulateAccessibilityEventInternal(event);
        {
            int i, count;
            i = 0;
            count = getChildCount();
            {
                View child;
                child = getChildAt(i);
                {
                    handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
        //if (handled) {
            //return handled;
        //}
        //for (int i = 0, count = getChildCount(); i < count; i++) {
            //View child = getChildAt(i);
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                //if (handled) {
                    //return handled;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.277 -0400", hash_original_method = "D1F5A3B1D56655AA52CA4B460A89AF1D", hash_generated_method = "F42EF1A841F01AC25547C3056B26D462")
    @DSModeled(DSC.SAFE)
    @Override
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(info.dsTaint);
        super.onInitializeAccessibilityNodeInfoInternal(info);
        {
            int i, count;
            i = 0;
            count = mChildrenCount;
            {
                View child;
                child = mChildren[i];
                {
                    info.addChild(child);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfoInternal(info);
        //for (int i = 0, count = mChildrenCount; i < count; i++) {
            //View child = mChildren[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    //&& (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //info.addChild(child);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "C93583B1C6CD82E84CFB16E69C063BD6", hash_generated_method = "1C9A7E5308E87D2BD52CE390F2058324")
    @DSModeled(DSC.SAFE)
    @Override
     void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
        {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        } //End block
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        super.dispatchDetachedFromWindow();
        // ---------- Original Method ----------
        //cancelAndClearTouchTargets(null);
        //mLayoutSuppressed = false;
        //mDragNotifiedChildren = null;
        //if (mCurrentDrag != null) {
            //mCurrentDrag.recycle();
            //mCurrentDrag = null;
        //}
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchDetachedFromWindow();
        //}
        //super.dispatchDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "3A8CBF91275A500D30CEFAD8D7209E14", hash_generated_method = "56851524DF186C1A04A5984A194B94E9")
    @DSModeled(DSC.SAFE)
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        super.setPadding(left, top, right, bottom);
        {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } //End block
        {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        } //End block
        // ---------- Original Method ----------
        //super.setPadding(left, top, right, bottom);
        //if ((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0) {
            //mGroupFlags |= FLAG_PADDING_NOT_NULL;
        //} else {
            //mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "0EF6BC3550040660942BB4435DC1568A", hash_generated_method = "21FC94D3C2924FB155A2639B1DE9C12A")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchSaveInstanceState(container);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View c;
                c = children[i];
                {
                    c.dispatchSaveInstanceState(container);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //View c = children[i];
            //if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                //c.dispatchSaveInstanceState(container);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "38DCBB8C3886F11C25C07FC151CB762B", hash_generated_method = "3A479049D73C86C181784EC772EBA058")
    @DSModeled(DSC.SAFE)
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "79E9ACE6A349ACE584637F3A31A0E869", hash_generated_method = "EA521B229938F50D13AFD507EACABC94")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchRestoreInstanceState(container);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View c;
                c = children[i];
                {
                    c.dispatchRestoreInstanceState(container);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //View c = children[i];
            //if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                //c.dispatchRestoreInstanceState(container);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "85A5428D5025B10E5C75238A5C358628", hash_generated_method = "A14F8CA6843CC8A1192AEE6F25DF2417")
    @DSModeled(DSC.SAFE)
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.278 -0400", hash_original_method = "673779FD01170D0D857F4CAC6D3A5472", hash_generated_method = "2854916B2FB63EFE0AE2631091D77A4F")
    @DSModeled(DSC.SAFE)
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            final View[] children;
            children = mChildren;
            final int count;
            count = mChildrenCount;
            {
                int i;
                i = 0;
                {
                    children[i].setDrawingCacheEnabled(enabled);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES) {
            //final View[] children = mChildren;
            //final int count = mChildrenCount;
            //for (int i = 0; i < count; i++) {
                //children[i].setDrawingCacheEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.279 -0400", hash_original_method = "C6BD5BCC8D99F50AFC626E34071E2FAF", hash_generated_method = "844F972C700677D3C59D8D81E9AFEF5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationStart();
        {
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            final boolean buildCache;
            buildCache = !isHardwareAccelerated();
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    {
                        child.setDrawingCacheEnabled(true);
                        {
                            child.buildDrawingCache(true);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        } //End block
        // ---------- Original Method ----------
        //super.onAnimationStart();
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //final boolean buildCache = !isHardwareAccelerated();
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    //child.setDrawingCacheEnabled(true);
                    //if (buildCache) {
                        //child.buildDrawingCache(true);
                    //}
                //}
            //}
            //mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.279 -0400", hash_original_method = "D937B1A7AD9A1EFB7CAF69E9B3174965", hash_generated_method = "4BB156F3500AE2E9002B53A1EF15BC05")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationEnd();
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onAnimationEnd();
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            //if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                //setChildrenDrawingCacheEnabled(false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.279 -0400", hash_original_method = "8B8B5866E6978A8C0D1BC17BB86DCAFE", hash_generated_method = "4D0941D2F0D2B0C4001806554DD58647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        dsTaint.addTaint(skipChildren);
        dsTaint.addTaint(backgroundColor);
        dsTaint.addTaint(quality.dsTaint);
        int count;
        count = mChildrenCount;
        int[] visibilities;
        visibilities = null;
        {
            visibilities = new int[count];
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    visibilities[i] = child.getVisibility();
                    {
                        child.setVisibility(INVISIBLE);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        Bitmap b;
        b = super.createSnapshot(quality, backgroundColor, skipChildren);
        {
            {
                int i;
                i = 0;
                {
                    getChildAt(i).setVisibility(visibilities[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int count = mChildrenCount;
        //int[] visibilities = null;
        //if (skipChildren) {
            //visibilities = new int[count];
            //for (int i = 0; i < count; i++) {
                //View child = getChildAt(i);
                //visibilities[i] = child.getVisibility();
                //if (visibilities[i] == View.VISIBLE) {
                    //child.setVisibility(INVISIBLE);
                //}
            //}
        //}
        //Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);
        //if (skipChildren) {
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).setVisibility(visibilities[i]);
            //}
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.280 -0400", hash_original_method = "B43A05A63ADF740A4A15894A451E95C0", hash_generated_method = "E88A4C72A0F882852A335843A78D4B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        int flags;
        flags = mGroupFlags;
        {
            boolean var07BB33E4D87E2B5D2A8FEE502EA9E8CD_1982259105 = ((flags & FLAG_RUN_ANIMATION) != 0 && canAnimate());
            {
                final boolean cache;
                cache = (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
                final boolean buildCache;
                buildCache = !isHardwareAccelerated();
                {
                    int i;
                    i = 0;
                    {
                        final View child;
                        child = children[i];
                        {
                            final LayoutParams params;
                            params = child.getLayoutParams();
                            attachLayoutAnimationParameters(child, params, i, count);
                            bindLayoutAnimation(child);
                            {
                                child.setDrawingCacheEnabled(true);
                                {
                                    child.buildDrawingCache(true);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                final LayoutAnimationController controller;
                controller = mLayoutAnimationController;
                {
                    boolean varE5D19A1FB2EF5ECD65C0B52011051B10_1503405797 = (controller.willOverlap());
                    {
                        mGroupFlags |= FLAG_OPTIMIZE_INVALIDATE;
                    } //End block
                } //End collapsed parenthetic
                controller.start();
                mGroupFlags &= ~FLAG_RUN_ANIMATION;
                mGroupFlags &= ~FLAG_ANIMATION_DONE;
                {
                    mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
                } //End block
                {
                    mAnimationListener.onAnimationStart(controller.getAnimation());
                } //End block
            } //End block
        } //End collapsed parenthetic
        int saveCount;
        saveCount = 0;
        final boolean clipToPadding;
        clipToPadding = (flags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            canvas.clipRect(mScrollX + mPaddingLeft, mScrollY + mPaddingTop,
                    mScrollX + mRight - mLeft - mPaddingRight,
                    mScrollY + mBottom - mTop - mPaddingBottom);
        } //End block
        mPrivateFlags &= ~DRAW_ANIMATION;
        mGroupFlags &= ~FLAG_INVALIDATE_REQUIRED;
        boolean more;
        more = false;
        final long drawingTime;
        drawingTime = getDrawingTime();
        {
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_1749143051 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[getChildDrawingOrder(count, i)];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_1728114355 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            final ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            final int disappearingCount;
            disappearingCount = disappearingChildren.size() - 1;
            {
                int i;
                i = disappearingCount;
                {
                    final View child;
                    child = disappearingChildren.get(i);
                    more |= drawChild(canvas, child, drawingTime);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            canvas.restoreToCount(saveCount);
        } //End block
        flags = mGroupFlags;
        {
            invalidate(true);
        } //End block
        {
            boolean var76A6DBFAA8B517B1E30D0F77E8BBAB75_1812564794 = ((flags & FLAG_ANIMATION_DONE) == 0 && (flags & FLAG_NOTIFY_ANIMATION_LISTENER) == 0 &&
                mLayoutAnimationController.isDone() && !more);
            {
                mGroupFlags |= FLAG_NOTIFY_ANIMATION_LISTENER;
                final Runnable end;
                end = new Runnable() {
               public void run() {
                   notifyAnimationListener();
               }
            };
                post(end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.280 -0400", hash_original_method = "314AC469B646186EB8E30D4AB123CD56", hash_generated_method = "417561A12143ADE7C7DFB2B76F586A9B")
    @DSModeled(DSC.SAFE)
    protected int getChildDrawingOrder(int childCount, int i) {
        dsTaint.addTaint(childCount);
        dsTaint.addTaint(i);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.280 -0400", hash_original_method = "396DFE394BEDDAB737694626CE3DE3EF", hash_generated_method = "755397976219B65AB1C8F056AABF2E4A")
    @DSModeled(DSC.SAFE)
    private void notifyAnimationListener() {
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        {
            final Runnable end;
            end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
            post(end);
        } //End block
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } //End block
        } //End block
        invalidate(true);
        // ---------- Original Method ----------
        //mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        //mGroupFlags |= FLAG_ANIMATION_DONE;
        //if (mAnimationListener != null) {
           //final Runnable end = new Runnable() {
               //public void run() {
                   //mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               //}
           //};
           //post(end);
        //}
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            //if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                //setChildrenDrawingCacheEnabled(false);
            //}
        //}
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.280 -0400", hash_original_method = "F4EA27B0452D996E61B8467125C95A50", hash_generated_method = "8B8ED3EF8FFAE2DF2BB358FBD970F80B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchGetDisplayList() {
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                {
                    boolean var735C012AD3EAE6449E3DE234B2B9D1C4_64227663 = (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer());
                    {
                        child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                        child.mPrivateFlags &= ~INVALIDATED;
                        child.getDisplayList();
                        child.mRecreateDisplayList = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    //child.hasStaticLayer()) {
                //child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                //child.mPrivateFlags &= ~INVALIDATED;
                //child.getDisplayList();
                //child.mRecreateDisplayList = false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.283 -0400", hash_original_method = "A5CF70DDE358EAA9D1CA892FF372BD55", hash_generated_method = "81AA9F0D12EBA8AAAB6C2B3DE9EC265F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(drawingTime);
        boolean more;
        more = false;
        final int cl;
        cl = child.mLeft;
        final int ct;
        ct = child.mTop;
        final int cr;
        cr = child.mRight;
        final int cb;
        cb = child.mBottom;
        final boolean childHasIdentityMatrix;
        childHasIdentityMatrix = child.hasIdentityMatrix();
        final int flags;
        flags = mGroupFlags;
        {
            mChildTransformation.clear();
            mGroupFlags &= ~FLAG_CLEAR_TRANSFORMATION;
        } //End block
        Transformation transformToApply;
        transformToApply = null;
        Transformation invalidationTransform;
        final Animation a;
        a = child.getAnimation();
        boolean concatMatrix;
        concatMatrix = false;
        boolean scalingRequired;
        scalingRequired = false;
        boolean caching;
        int layerType;
        layerType = child.getLayerType();
        layerType = LAYER_TYPE_NONE;
        final boolean hardwareAccelerated;
        hardwareAccelerated = canvas.isHardwareAccelerated();
        {
            caching = true;
            scalingRequired = mAttachInfo.mScalingRequired;
        } //End block
        {
            caching = (layerType != LAYER_TYPE_NONE) || hardwareAccelerated;
        } //End block
        {
            final boolean initialized;
            initialized = a.isInitialized();
            {
                a.initialize(cr - cl, cb - ct, getWidth(), getHeight());
                a.initializeInvalidateRegion(0, 0, cr - cl, cb - ct);
                child.onAnimationStart();
            } //End block
            more = a.getTransformation(drawingTime, mChildTransformation,
                    scalingRequired ? mAttachInfo.mApplicationScale : 1f);
            {
                {
                    mInvalidationTransformation = new Transformation();
                } //End block
                invalidationTransform = mInvalidationTransformation;
                a.getTransformation(drawingTime, invalidationTransform, 1f);
            } //End block
            {
                invalidationTransform = mChildTransformation;
            } //End block
            transformToApply = mChildTransformation;
            concatMatrix = a.willChangeTransformationMatrix();
            {
                {
                    boolean var489AF36514F0C5F8ABF92D9ED1EEF69B_833256217 = (!a.willChangeBounds());
                    {
                        {
                            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                        } //End block
                        {
                            mPrivateFlags |= DRAW_ANIMATION;
                            invalidate(cl, ct, cr, cb);
                        } //End block
                    } //End block
                    {
                        {
                            mInvalidateRegion = new RectF();
                        } //End block
                        final RectF region;
                        region = mInvalidateRegion;
                        a.getInvalidateRegion(0, 0, cr - cl, cb - ct, region, invalidationTransform);
                        mPrivateFlags |= DRAW_ANIMATION;
                        final int left;
                        left = cl + (int) region.left;
                        final int top;
                        top = ct + (int) region.top;
                        invalidate(left, top, left + (int) (region.width() + .5f),
                            top + (int) (region.height() + .5f));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            final boolean hasTransform;
            hasTransform = getChildStaticTransformation(child, mChildTransformation);
            {
                final int transformType;
                transformType = mChildTransformation.getTransformationType();
                transformToApply = transformType != Transformation.TYPE_IDENTITY ?
                        mChildTransformation : null;
                concatMatrix = (transformType & Transformation.TYPE_MATRIX) != 0;
            } //End block
        } //End block
        concatMatrix |= !childHasIdentityMatrix;
        child.mPrivateFlags |= DRAWN;
        {
            boolean var04A9779EE766FABCC1352F467BA0AB22_750495664 = (!concatMatrix && canvas.quickReject(cl, ct, cr, cb, Canvas.EdgeType.BW) &&
                (child.mPrivateFlags & DRAW_ANIMATION) == 0);
        } //End collapsed parenthetic
        {
            child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
            child.mPrivateFlags &= ~INVALIDATED;
        } //End block
        child.computeScroll();
        final int sx;
        sx = child.mScrollX;
        final int sy;
        sy = child.mScrollY;
        DisplayList displayList;
        displayList = null;
        Bitmap cache;
        cache = null;
        boolean hasDisplayList;
        hasDisplayList = false;
        {
            {
                {
                    layerType = LAYER_TYPE_SOFTWARE;
                    child.buildDrawingCache(true);
                } //End block
                cache = child.getDrawingCache(true);
            } //End block
            {
                //Begin case LAYER_TYPE_SOFTWARE 
                child.buildDrawingCache(true);
                //End case LAYER_TYPE_SOFTWARE 
                //Begin case LAYER_TYPE_SOFTWARE 
                cache = child.getDrawingCache(true);
                //End case LAYER_TYPE_SOFTWARE 
                //Begin case LAYER_TYPE_NONE 
                hasDisplayList = child.canHaveDisplayList();
                //End case LAYER_TYPE_NONE 
            } //End block
        } //End block
        final boolean hasNoCache;
        hasNoCache = cache == null || hasDisplayList;
        final boolean offsetForScroll;
        offsetForScroll = cache == null && !hasDisplayList &&
                layerType != LAYER_TYPE_HARDWARE;
        final int restoreTo;
        restoreTo = canvas.save();
        {
            canvas.translate(cl - sx, ct - sy);
        } //End block
        {
            canvas.translate(cl, ct);
            {
                final float scale;
                scale = 1.0f / mAttachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
        } //End block
        float alpha;
        alpha = child.getAlpha();
        {
            boolean var934B3E69D3ACD833C0B88FE85A1125E9_723326017 = (transformToApply != null || alpha < 1.0f || !child.hasIdentityMatrix());
            {
                {
                    int transX;
                    transX = 0;
                    int transY;
                    transY = 0;
                    {
                        transX = -sx;
                        transY = -sy;
                    } //End block
                    {
                        {
                            canvas.translate(-transX, -transY);
                            canvas.concat(transformToApply.getMatrix());
                            canvas.translate(transX, transY);
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } //End block
                        float transformAlpha;
                        transformAlpha = transformToApply.getAlpha();
                        {
                            alpha *= transformToApply.getAlpha();
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } //End block
                    } //End block
                    {
                        canvas.translate(-transX, -transY);
                        canvas.concat(child.getMatrix());
                        canvas.translate(transX, transY);
                    } //End block
                } //End block
                {
                    mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                    {
                        final int multipliedAlpha;
                        multipliedAlpha = (int) (255 * alpha);
                        {
                            boolean varFF146FCD683FC819B246FAE0328227BA_449523157 = (!child.onSetAlpha(multipliedAlpha));
                            {
                                int layerFlags;
                                layerFlags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
                                {
                                    layerFlags |= Canvas.CLIP_TO_LAYER_SAVE_FLAG;
                                } //End block
                                {
                                    final int scrollX;
                                    scrollX = sx;
                                    final int scrollY;
                                    scrollY = sy;
                                    canvas.saveLayerAlpha(scrollX, scrollY, scrollX + cr - cl,
                                    scrollY + cb - ct, multipliedAlpha, layerFlags);
                                } //End block
                            } //End block
                            {
                                child.mPrivateFlags |= ALPHA_SET;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                child.onSetAlpha(255);
                child.mPrivateFlags &= ~ALPHA_SET;
            } //End block
        } //End collapsed parenthetic
        {
            {
                canvas.clipRect(sx, sy, sx + (cr - cl), sy + (cb - ct));
            } //End block
            {
                {
                    canvas.clipRect(0, 0, cr - cl, cb - ct);
                } //End block
                {
                    canvas.clipRect(0, 0, cache.getWidth(), cache.getHeight());
                } //End block
            } //End block
        } //End block
        {
            displayList = child.getDisplayList();
            {
                boolean var9C584955B3CFEF7798B020C1B8079C6D_328675618 = (!displayList.isValid());
                {
                    displayList = null;
                    hasDisplayList = false;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean layerRendered;
            layerRendered = false;
            {
                final HardwareLayer layer;
                layer = child.getHardwareLayer();
                {
                    boolean varF47BB7BA46927B23DD4F75E227100F6C_1607386350 = (layer != null && layer.isValid());
                    {
                        child.mLayerPaint.setAlpha((int) (alpha * 255));
                        ((HardwareCanvas) canvas).drawHardwareLayer(layer, 0, 0, child.mLayerPaint);
                        layerRendered = true;
                    } //End block
                    {
                        final int scrollX;
                        scrollX = sx;
                        final int scrollY;
                        scrollY = sy;
                        canvas.saveLayer(scrollX, scrollY,
                            scrollX + cr - cl, scrollY + cb - ct, child.mLayerPaint,
                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    {
                        {
                            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                        } //End block
                        child.mPrivateFlags &= ~DIRTY_MASK;
                        child.dispatchDraw(canvas);
                    } //End block
                    {
                        child.draw(canvas);
                    } //End block
                } //End block
                {
                    child.mPrivateFlags &= ~DIRTY_MASK;
                    ((HardwareCanvas) canvas).drawDisplayList(displayList, cr - cl, cb - ct, null);
                } //End block
            } //End block
        } //End block
        {
            child.mPrivateFlags &= ~DIRTY_MASK;
            Paint cachePaint;
            {
                cachePaint = mCachePaint;
                {
                    cachePaint = new Paint();
                    cachePaint.setDither(false);
                    mCachePaint = cachePaint;
                } //End block
                {
                    cachePaint.setAlpha((int) (alpha * 255));
                    mGroupFlags |= FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
                {
                    cachePaint.setAlpha(255);
                    mGroupFlags &= ~FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
            } //End block
            {
                cachePaint = child.mLayerPaint;
                cachePaint.setAlpha((int) (alpha * 255));
            } //End block
            canvas.drawBitmap(cache, 0.0f, 0.0f, cachePaint);
        } //End block
        canvas.restoreToCount(restoreTo);
        {
            {
                boolean varAF4EC4CBE7F4BE862D45CC273E5600AE_1432292847 = (!hardwareAccelerated && !a.getFillAfter());
                {
                    child.onSetAlpha(255);
                } //End block
            } //End collapsed parenthetic
            finishAnimatingView(child, a);
        } //End block
        {
            invalidate(true);
            {
                boolean var14BEB88AF6F19C239671B73A03DA27C1_16058010 = (a.hasAlpha() && (child.mPrivateFlags & ALPHA_SET) == ALPHA_SET);
                {
                    child.invalidate(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        child.mRecreateDisplayList = false;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.283 -0400", hash_original_method = "4095F0AE1BAE27A3A14B16FD7C3431AE", hash_generated_method = "1DBE547C10F4286516C98B2B83156B6A")
    @DSModeled(DSC.SAFE)
    public void setChildrenLayersEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            invalidate(true);
            {
                int i;
                i = 0;
                {
                    View child;
                    child = mChildren[i];
                    {
                        child.invalidate(true);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (enabled != mDrawLayers) {
            //mDrawLayers = enabled;
            //invalidate(true);
            //for (int i = 0; i < mChildrenCount; i++) {
                //View child = mChildren[i];
                //if (child.mLayerType != LAYER_TYPE_NONE) {
                    //child.invalidate(true);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.283 -0400", hash_original_method = "1DB85DBA1331DEE146504B0E70B65BE5", hash_generated_method = "9EF17773DAFD4BFDAF177B5023C3A990")
    @DSModeled(DSC.SAFE)
    public void setClipChildren(boolean clipChildren) {
        dsTaint.addTaint(clipChildren);
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.283 -0400", hash_original_method = "863AF54978AA2727D0D7509C22DC212D", hash_generated_method = "88E031769F7C3139BD6F26FD05DED776")
    @DSModeled(DSC.SAFE)
    public void setClipToPadding(boolean clipToPadding) {
        dsTaint.addTaint(clipToPadding);
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.283 -0400", hash_original_method = "8ABEEBF76C5626CBEA0073E7871E08E9", hash_generated_method = "BB0B16B6EBBE685A2F9117690EF52B64")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchSetSelected(boolean selected) {
        dsTaint.addTaint(selected);
        final View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setSelected(selected);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setSelected(selected);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "2F91B8D19CDC8A9E83F3387815EB4D3F", hash_generated_method = "B4788EB02946BBBAE0912A0D054D0353")
    @DSModeled(DSC.SAFE)
    @Override
    public void dispatchSetActivated(boolean activated) {
        dsTaint.addTaint(activated);
        final View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setActivated(activated);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setActivated(activated);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "741F0E8D45382BBF6BA56C96532A94D8", hash_generated_method = "0E397BDB6BD1142FBECFD6EC9E869201")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        final View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setPressed(pressed);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setPressed(pressed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "BD73AAD871B8740D29315EE305D10F4B", hash_generated_method = "926B2F59C4546FCB940866E9BC688BF7")
    @DSModeled(DSC.SAFE)
    protected void setStaticTransformationsEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "38350E8AB95E51C9F24ECCE262AEDBFF")
    @DSModeled(DSC.SAFE)
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(t.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "8C56D4BEA5FE426CA6EBD73A64039E70", hash_generated_method = "B1C432DDC8099DE4C63AEBB0828C7B6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewTraversal(int id) {
        dsTaint.addTaint(id);
        final View[] where;
        where = mChildren;
        final int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewById(id);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (id == mID) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewById(id);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "D087F3465F923453754E64A11DB6BED1", hash_generated_method = "2A1CCAE89C27D128E777C4A1DB7C68E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_619627279 = (tag != null && tag.equals(mTag));
        } //End collapsed parenthetic
        final View[] where;
        where = mChildren;
        final int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewWithTag(tag);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (tag != null && tag.equals(mTag)) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewWithTag(tag);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "0EC5116F4AD2AA9CFA72F9149C3A9529", hash_generated_method = "A84ADB2ACE54C2B390B13EFF4A275BDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        dsTaint.addTaint(childToSkip.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_31488920 = (predicate.apply(this));
        } //End collapsed parenthetic
        final View[] where;
        where = mChildren;
        final int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewByPredicate(predicate);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (predicate.apply(this)) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if (v != childToSkip && (v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewByPredicate(predicate);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.284 -0400", hash_original_method = "CEC5DF3412108DC355B81A234F778717", hash_generated_method = "EAC1E6B2600FC7E74B4A688B525BE72E")
    @DSModeled(DSC.SAFE)
    public void addView(View child) {
        dsTaint.addTaint(child.dsTaint);
        addView(child, -1);
        // ---------- Original Method ----------
        //addView(child, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "052049806EFDCB28F8B1780970FB4D61", hash_generated_method = "A4F8555450C1B8F7196E44600C105337")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addView(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        LayoutParams params;
        params = child.getLayoutParams();
        {
            params = generateDefaultLayoutParams();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            } //End block
        } //End block
        addView(child, index, params);
        // ---------- Original Method ----------
        //LayoutParams params = child.getLayoutParams();
        //if (params == null) {
            //params = generateDefaultLayoutParams();
            //if (params == null) {
                //throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            //}
        //}
        //addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "04069655751E8F150919B197DB2D0EF4", hash_generated_method = "C9B9DC2E0A475E837F7FD24E0B1F9FE4")
    @DSModeled(DSC.SAFE)
    public void addView(View child, int width, int height) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        final LayoutParams params;
        params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
        // ---------- Original Method ----------
        //final LayoutParams params = generateDefaultLayoutParams();
        //params.width = width;
        //params.height = height;
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "CAABD1DBDF747222034CC373BA6381CC", hash_generated_method = "9F54883BE50DC5C02975E57F09AE631B")
    @DSModeled(DSC.SAFE)
    public void addView(View child, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        addView(child, -1, params);
        // ---------- Original Method ----------
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "BD78A36687CEEF62B7E0786E86501A2F", hash_generated_method = "3DC1008EFC55CFAADFC4753750430950")
    @DSModeled(DSC.SAFE)
    public void addView(View child, int index, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        {
            System.out.println(this + " addView");
        } //End block
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " addView");
        //}
        //requestLayout();
        //invalidate(true);
        //addViewInner(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "8137D76BAD6EAD8C2AFF7B0DC7EC38EA", hash_generated_method = "E48A9CA877161CB234F10C3C228C216D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1257629703 = (!checkLayoutParams(params));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Given view not a child of " + this);
        } //End block
        view.setLayoutParams(params);
        // ---------- Original Method ----------
        //if (!checkLayoutParams(params)) {
            //throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        //}
        //if (view.mParent != this) {
            //throw new IllegalArgumentException("Given view not a child of " + this);
        //}
        //view.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "C2EE5015ED0F9B04763A6A0F4C905EDB", hash_generated_method = "082D1F36B19CA131A2B68486FDE7B355")
    @DSModeled(DSC.SAFE)
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return  p != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "324210219993D432F6F885E76211B432")
    @DSModeled(DSC.SAFE)
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnHierarchyChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.285 -0400", hash_original_method = "7C8375F0DCFCC6770307465540C43F29", hash_generated_method = "BA49F31259D9D379C7A955EC3C1EBE43")
    @DSModeled(DSC.SAFE)
    protected void onViewAdded(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        } //End block
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewAdded(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.286 -0400", hash_original_method = "2969A02DF6E73517C4A5610098A20201", hash_generated_method = "53457239DB87FA09EC38DB0E2E1DD341")
    @DSModeled(DSC.SAFE)
    protected void onViewRemoved(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        } //End block
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.286 -0400", hash_original_method = "4EC56F492B64387EC5CDEE559C919DD8", hash_generated_method = "CC80CBBCBB4EEF3657A999D372938D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        boolean varC93AA663A5550227DF73E011E019C03E_238766460 = (addViewInLayout(child, index, params, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addViewInLayout(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.286 -0400", hash_original_method = "621D5EA894CECBBA3C5FE5D7159CF1D3", hash_generated_method = "7EF9736BB4C3209F67E7AAC2C97B56D6")
    @DSModeled(DSC.SAFE)
    protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(preventRequestLayout);
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //child.mParent = null;
        //addViewInner(child, index, params, preventRequestLayout);
        //child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.286 -0400", hash_original_method = "156A75B155CF89ADA3C99A75E911D53A", hash_generated_method = "B72CEA999FFCDCA0D24406C7561B25BA")
    @DSModeled(DSC.SAFE)
    protected void cleanupLayoutState(View child) {
        dsTaint.addTaint(child.dsTaint);
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
        // ---------- Original Method ----------
        //child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.286 -0400", hash_original_method = "4623983FE5D2926EED9F934007E41D76", hash_generated_method = "476EF2F1C9BB725CB4CEE0122624116F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(preventRequestLayout);
        {
            mTransition.cancel(LayoutTransition.DISAPPEARING);
        } //End block
        {
            boolean varA3364C4A63F6A263A8814AE455A29C59_452840725 = (child.getParent() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The specified child already has a parent. " +
                    "You must call removeView() on the child's parent first.");
            } //End block
        } //End collapsed parenthetic
        {
            mTransition.addChild(this, child);
        } //End block
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_942100170 = (!checkLayoutParams(params));
            {
                params = generateLayoutParams(params);
            } //End block
        } //End collapsed parenthetic
        {
            child.mLayoutParams = params;
        } //End block
        {
            child.setLayoutParams(params);
        } //End block
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
        {
            child.assignParent(this);
        } //End block
        {
            child.mParent = this;
        } //End block
        {
            boolean varDDA55DF480817D6313066967525E9186_906249711 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } //End block
        } //End collapsed parenthetic
        AttachInfo ai;
        ai = mAttachInfo;
        {
            boolean lastKeepOn;
            lastKeepOn = ai.mKeepScreenOn;
            ai.mKeepScreenOn = false;
            child.dispatchAttachedToWindow(mAttachInfo, (mViewFlags&VISIBILITY_MASK));
            {
                needGlobalAttributesUpdate(true);
            } //End block
            ai.mKeepScreenOn = lastKeepOn;
        } //End block
        onViewAdded(child);
        {
            mGroupFlags |= FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "3DC226B361362F1A66E4DF7340FD46AC", hash_generated_method = "785B4C32287677929299E908D0BC3D94")
    @DSModeled(DSC.SAFE)
    private void addInArray(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        final int size;
        size = children.length;
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, size);
                children = mChildren;
            } //End block
            children[mChildrenCount++] = child;
        } //End block
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, index);
                System.arraycopy(children, index, mChildren, index + 1, count - index);
                children = mChildren;
            } //End block
            {
                System.arraycopy(children, index, children, index + 1, count - index);
            } //End block
            children[index] = child;
            mChildrenCount++;
            {
                mLastTouchDownIndex++;
            } //End block
        } //End block
        {
            throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "666B846103F98929B6C3984DF363A458", hash_generated_method = "9C769451D7F23F2FE93AF4CCB7DFBD29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFromArray(int index) {
        dsTaint.addTaint(index);
        final View[] children;
        children = mChildren;
        {
            boolean varFD7C05E4772169FABFE9822CC2FF40CC_1900260000 = (!(mTransitioningViews != null && mTransitioningViews.contains(children[index])));
            {
                children[index].mParent = null;
            } //End block
        } //End collapsed parenthetic
        final int count;
        count = mChildrenCount;
        {
            children[--mChildrenCount] = null;
        } //End block
        {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } //End block
        {
           if (DroidSafeAndroidRuntime.control)  throw new IndexOutOfBoundsException();
        } //End block
        {
            mLastTouchDownTime = 0;
        } //End block
        {
            mLastTouchDownIndex--;
        } //End block
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //if (!(mTransitioningViews != null && mTransitioningViews.contains(children[index]))) {
            //children[index].mParent = null;
        //}
        //final int count = mChildrenCount;
        //if (index == count - 1) {
            //children[--mChildrenCount] = null;
        //} else if (index >= 0 && index < count) {
            //System.arraycopy(children, index + 1, children, index, count - index - 1);
            //children[--mChildrenCount] = null;
        //} else {
            //throw new IndexOutOfBoundsException();
        //}
        //if (mLastTouchDownIndex == index) {
            //mLastTouchDownTime = 0;
            //mLastTouchDownIndex = -1;
        //} else if (mLastTouchDownIndex > index) {
            //mLastTouchDownIndex--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "7377DC4CCC7ACF33951FFC91A9C19242", hash_generated_method = "A872B6BB0EF4C571A312A2B1E14974AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFromArray(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        final View[] children;
        children = mChildren;
        final int childrenCount;
        childrenCount = mChildrenCount;
        start = Math.max(0, start);
        final int end;
        end = Math.min(childrenCount, start + count);
        {
            {
                int i;
                i = start;
                {
                    children[i].mParent = null;
                    children[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = start;
                {
                    children[i].mParent = null;
                } //End block
            } //End collapsed parenthetic
            System.arraycopy(children, end, children, start, childrenCount - end);
            {
                int i;
                i = childrenCount - (end - start);
                {
                    children[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mChildrenCount -= (end - start);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "0C13B6720EDD2CD731BF86C88080EC0A", hash_generated_method = "EEAF6BED92652F751FB8EBB1CD5B1620")
    @DSModeled(DSC.SAFE)
    private void bindLayoutAnimation(View child) {
        dsTaint.addTaint(child.dsTaint);
        Animation a;
        a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
        // ---------- Original Method ----------
        //Animation a = mLayoutAnimationController.getAnimationForView(child);
        //child.setAnimation(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "53A696BC845D59D084861C4C39417C50", hash_generated_method = "AAB302223685AF46B9BF2BC4F9D9A46A")
    @DSModeled(DSC.SAFE)
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(params.dsTaint);
        LayoutAnimationController.AnimationParameters animationParams;
        animationParams = params.layoutAnimationParameters;
        {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } //End block
        animationParams.count = count;
        animationParams.index = index;
        // ---------- Original Method ----------
        //LayoutAnimationController.AnimationParameters animationParams =
                    //params.layoutAnimationParameters;
        //if (animationParams == null) {
            //animationParams = new LayoutAnimationController.AnimationParameters();
            //params.layoutAnimationParameters = animationParams;
        //}
        //animationParams.count = count;
        //animationParams.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.287 -0400", hash_original_method = "D47B7EA927C9C6E9F8463F22FA8E7751", hash_generated_method = "14AD506BC33AEEFA33626314D1E079B1")
    @DSModeled(DSC.SAFE)
    public void removeView(View view) {
        dsTaint.addTaint(view.dsTaint);
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewInternal(view);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "9C0189C4A93DBFF4CA9135E979534627", hash_generated_method = "944BD83EE52A29A054DBDCEB581EAAC2")
    @DSModeled(DSC.SAFE)
    public void removeViewInLayout(View view) {
        dsTaint.addTaint(view.dsTaint);
        removeViewInternal(view);
        // ---------- Original Method ----------
        //removeViewInternal(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "CCED8E1F5C1435811C77FC8E195AA3ED", hash_generated_method = "9678CB45664D26F0F8EB3F286E3301DF")
    @DSModeled(DSC.SAFE)
    public void removeViewsInLayout(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        removeViewsInternal(start, count);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "C7B982345E14E4BA654D9B702D09B782", hash_generated_method = "54A9ABD6115A67D9CA62237C92E1EB9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeViewAt(int index) {
        dsTaint.addTaint(index);
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewInternal(index, getChildAt(index));
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "295E3CFFAAE54DAD76DF23980004A9FB", hash_generated_method = "4A4881C784E066B80538A008E6FEE0E1")
    @DSModeled(DSC.SAFE)
    public void removeViews(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "A8C7AA662547BF9F482FBD0CAAADED6D", hash_generated_method = "07F39DFD805926D2DB52B6B59DC7D77D")
    @DSModeled(DSC.SAFE)
    private void removeViewInternal(View view) {
        dsTaint.addTaint(view.dsTaint);
        final int index;
        index = indexOfChild(view);
        {
            removeViewInternal(index, view);
        } //End block
        // ---------- Original Method ----------
        //final int index = indexOfChild(view);
        //if (index >= 0) {
            //removeViewInternal(index, view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "5145400D128FAA852B030ECA7E0E5CC6", hash_generated_method = "1C7271983A036A1C648F50BA99AB1971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeViewInternal(int index, View view) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(view.dsTaint);
        {
            mTransition.removeChild(this, view);
        } //End block
        boolean clearChildFocus;
        clearChildFocus = false;
        {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        } //End block
        {
            boolean var74C8DDDF999D66AA3EB9771E0CD6D718_36197224 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
            {
                addDisappearingView(view);
            } //End block
            {
                view.dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        onViewRemoved(view);
        needGlobalAttributesUpdate(false);
        removeFromArray(index);
        {
            clearChildFocus(view);
        } //End block
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeChild(this, view);
        //}
        //boolean clearChildFocus = false;
        //if (view == mFocused) {
            //view.clearFocusForRemoval();
            //clearChildFocus = true;
        //}
        //if (view.getAnimation() != null ||
                //(mTransitioningViews != null && mTransitioningViews.contains(view))) {
            //addDisappearingView(view);
        //} else if (view.mAttachInfo != null) {
           //view.dispatchDetachedFromWindow();
        //}
        //onViewRemoved(view);
        //needGlobalAttributesUpdate(false);
        //removeFromArray(index);
        //if (clearChildFocus) {
            //clearChildFocus(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "6CC26F3EB4840902E7233D2C3E46A07B", hash_generated_method = "9BCC2F7124ABA322E7FA47265D9C4B0A")
    @DSModeled(DSC.SAFE)
    public void setLayoutTransition(LayoutTransition transition) {
        dsTaint.addTaint(transition.dsTaint);
        {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        } //End block
        {
            mTransition.addTransitionListener(mLayoutTransitionListener);
        } //End block
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeTransitionListener(mLayoutTransitionListener);
        //}
        //mTransition = transition;
        //if (mTransition != null) {
            //mTransition.addTransitionListener(mLayoutTransitionListener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.288 -0400", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "5D00560EDAACCC46737D0AF5B9118CAE")
    @DSModeled(DSC.SAFE)
    public LayoutTransition getLayoutTransition() {
        return (LayoutTransition)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "F40E247B6ABF822EB65FF56F80411035", hash_generated_method = "EBDD338F5518874FCD459B64D9017EF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeViewsInternal(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        final View focused;
        focused = mFocused;
        final boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        final View[] children;
        children = mChildren;
        final int end;
        end = start + count;
        {
            int i;
            i = start;
            {
                final View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var771BCD00CE5FBF80B4F7B15D3C6EBC5E_1453155520 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } //End block
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                } //End collapsed parenthetic
                needGlobalAttributesUpdate(false);
                onViewRemoved(view);
            } //End block
        } //End collapsed parenthetic
        removeFromArray(start, count);
        {
            clearChildFocus(clearChildFocus);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "C167CC912DB398153B3FBDE6D6503FBD", hash_generated_method = "00584DCE2542F724EFC0C7055B5F12E1")
    @DSModeled(DSC.SAFE)
    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeAllViewsInLayout();
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "8DFE71C1BEB57BA28106B31D5772632E", hash_generated_method = "0950E826F9773AADC4688E494FC9C247")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllViewsInLayout() {
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        mChildrenCount = 0;
        final View focused;
        focused = mFocused;
        final boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        needGlobalAttributesUpdate(false);
        {
            int i;
            i = count - 1;
            {
                final View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var25706AD565CAAA05294A1680813DB393_1224198157 = (view.getAnimation() != null ||
                    (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } //End block
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                } //End collapsed parenthetic
                onViewRemoved(view);
                view.mParent = null;
                children[i] = null;
            } //End block
        } //End collapsed parenthetic
        {
            clearChildFocus(clearChildFocus);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "80D629C332B0E93DD7A33AD3708E672D", hash_generated_method = "7903DCEA100988F42FF2625DCC1D62B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void removeDetachedView(View child, boolean animate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(animate);
        {
            mTransition.removeChild(this, child);
        } //End block
        {
            child.clearFocus();
        } //End block
        {
            boolean varC784B3814A6616C601A69CC572D538AE_163833635 = ((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child)));
            {
                addDisappearingView(child);
            } //End block
            {
                child.dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        onViewRemoved(child);
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeChild(this, child);
        //}
        //if (child == mFocused) {
            //child.clearFocus();
        //}
        //if ((animate && child.getAnimation() != null) ||
                //(mTransitioningViews != null && mTransitioningViews.contains(child))) {
            //addDisappearingView(child);
        //} else if (child.mAttachInfo != null) {
            //child.dispatchDetachedFromWindow();
        //}
        //onViewRemoved(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "8472A11DDB1452C7DB4257A960216E78", hash_generated_method = "1F1332593FE406BFAA2AF82ABCE954CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        child.mLayoutParams = params;
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;
        {
            boolean varDDA55DF480817D6313066967525E9186_1674438961 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //child.mLayoutParams = params;
        //if (index < 0) {
            //index = mChildrenCount;
        //}
        //addInArray(child, index);
        //child.mParent = this;
        //child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                //DRAWN | INVALIDATED;
        //this.mPrivateFlags |= INVALIDATED;
        //if (child.hasFocus()) {
            //requestChildFocus(child, child.findFocus());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.289 -0400", hash_original_method = "635C6E5D7FA712D6D6BC98C85EEAD0AE", hash_generated_method = "BC20AC380375E79EBE4098E019923372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void detachViewFromParent(View child) {
        dsTaint.addTaint(child.dsTaint);
        removeFromArray(indexOfChild(child));
        // ---------- Original Method ----------
        //removeFromArray(indexOfChild(child));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.290 -0400", hash_original_method = "6B327774A5D40749E682A0800D955866", hash_generated_method = "6DD6108A39727E9067D12843624F7A2B")
    @DSModeled(DSC.SAFE)
    protected void detachViewFromParent(int index) {
        dsTaint.addTaint(index);
        removeFromArray(index);
        // ---------- Original Method ----------
        //removeFromArray(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.290 -0400", hash_original_method = "9419943F60DE9471E3CB31EABE2947F0", hash_generated_method = "43A0FA125A56B0B771E48C8044042E09")
    @DSModeled(DSC.SAFE)
    protected void detachViewsFromParent(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        removeFromArray(start, count);
        // ---------- Original Method ----------
        //removeFromArray(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.290 -0400", hash_original_method = "FD3027623927AF219788395D1D83AA06", hash_generated_method = "942FD3E1ADC88A9414AE3FBA1B9C1ED0")
    @DSModeled(DSC.SAFE)
    protected void detachAllViewsFromParent() {
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        mChildrenCount = 0;
        {
            int i;
            i = count - 1;
            {
                children[i].mParent = null;
                children[i] = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //if (count <= 0) {
            //return;
        //}
        //final View[] children = mChildren;
        //mChildrenCount = 0;
        //for (int i = count - 1; i >= 0; i--) {
            //children[i].mParent = null;
            //children[i] = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.291 -0400", hash_original_method = "063B7BC13F01F04711683C921C10A0CE", hash_generated_method = "464B8053B0F3C8B5813CE78939CB538C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void invalidateChild(View child, final Rect dirty) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD);
        } //End block
        ViewParent parent;
        parent = this;
        final AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            final boolean drawAnimation;
            drawAnimation = (child.mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION;
            {
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.setEmpty();
                } //End block
                {
                    View view;
                    view = null;
                    {
                        view = (View) parent;
                        {
                            view.mLocalDirtyRect.setEmpty();
                            {
                                boolean var3DA0F6F5F2B1801DCC6F6E6927312986_1840146787 = (view.getParent() instanceof View);
                                {
                                    final View grandParent;
                                    grandParent = (View) view.getParent();
                                    grandParent.mPrivateFlags |= INVALIDATED;
                                    grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } //End block
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } //End block
                    } //End block
                    {
                        ((ViewRootImpl) parent).invalidate();
                        parent = null;
                    } //End block
                    {
                        {
                            view.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            view.mPrivateFlags |= DIRTY;
                            parent = view.mParent;
                        } //End block
                        {
                            parent = null;
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                final boolean isOpaque;
                isOpaque = child.isOpaque() && !drawAnimation &&
                        child.getAnimation() == null;
                int opaqueFlag;
                opaqueFlag = DIRTY_OPAQUE;
                opaqueFlag = DIRTY;
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.union(dirty);
                } //End block
                final int[] location;
                location = attachInfo.mInvalidateChildLocation;
                location[CHILD_LEFT_INDEX] = child.mLeft;
                location[CHILD_TOP_INDEX] = child.mTop;
                Matrix childMatrix;
                childMatrix = child.getMatrix();
                {
                    boolean varCFD88FFD44E20CB7F1D8D4D2556D2E8C_1149378492 = (!childMatrix.isIdentity());
                    {
                        RectF boundingRect;
                        boundingRect = attachInfo.mTmpTransformRect;
                        boundingRect.set(dirty);
                        childMatrix.mapRect(boundingRect);
                        dirty.set((int) (boundingRect.left - 0.5f),
                            (int) (boundingRect.top - 0.5f),
                            (int) (boundingRect.right + 0.5f),
                            (int) (boundingRect.bottom + 0.5f));
                    } //End block
                } //End collapsed parenthetic
                {
                    View view;
                    view = null;
                    {
                        view = (View) parent;
                        {
                            boolean varC5230D1238FBEF65B7498AB998C6F0FA_247703639 = (view.mLayerType != LAYER_TYPE_NONE &&
                                view.getParent() instanceof View);
                            {
                                final View grandParent;
                                grandParent = (View) view.getParent();
                                grandParent.mPrivateFlags |= INVALIDATED;
                                grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } //End block
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } //End block
                    } //End block
                    {
                        {
                            boolean var760C0A78BE5FDB84740BECBCA8BA8947_1158040202 = ((view.mViewFlags & FADING_EDGE_MASK) != 0 &&
                                view.getSolidColor() == 0);
                            {
                                opaqueFlag = DIRTY;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            view.mPrivateFlags = (view.mPrivateFlags & ~DIRTY_MASK) | opaqueFlag;
                        } //End block
                    } //End block
                    parent = parent.invalidateChildInParent(location, dirty);
                    {
                        Matrix m;
                        m = view.getMatrix();
                        {
                            boolean var8D882C39D7302E18C8FB45549919991D_1194714693 = (!m.isIdentity());
                            {
                                RectF boundingRect;
                                boundingRect = attachInfo.mTmpTransformRect;
                                boundingRect.set(dirty);
                                m.mapRect(boundingRect);
                                dirty.set((int) boundingRect.left, (int) boundingRect.top,
                                    (int) (boundingRect.right + 0.5f),
                                    (int) (boundingRect.bottom + 0.5f));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.291 -0400", hash_original_method = "DC318C38544A42EB44071D5AE866F2AB", hash_generated_method = "25C9D3BCDC03FA96B334C3166B830127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD_IN_PARENT);
        } //End block
        {
            {
                dirty.offset(location[CHILD_LEFT_INDEX] - mScrollX,
                        location[CHILD_TOP_INDEX] - mScrollY);
                final int left;
                left = mLeft;
                final int top;
                top = mTop;
                {
                    boolean var1FD08A580F456E7C6E817E871B882F95_103323718 = ((mGroupFlags & FLAG_CLIP_CHILDREN) != FLAG_CLIP_CHILDREN ||
                        dirty.intersect(0, 0, mRight - left, mBottom - top) ||
                        (mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION);
                    {
                        mPrivateFlags &= ~DRAWING_CACHE_VALID;
                        location[CHILD_LEFT_INDEX] = left;
                        location[CHILD_TOP_INDEX] = top;
                        {
                            mLocalDirtyRect.union(dirty);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mPrivateFlags &= ~DRAWN & ~DRAWING_CACHE_VALID;
                location[CHILD_LEFT_INDEX] = mLeft;
                location[CHILD_TOP_INDEX] = mTop;
                {
                    dirty.set(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
                {
                    dirty.union(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
                {
                    mLocalDirtyRect.union(dirty);
                } //End block
            } //End block
        } //End block
        return (ViewParent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.291 -0400", hash_original_method = "50571ED06CB8BFD92222BA4CF106E503", hash_generated_method = "5B53C2AAF332B652E31F4E2CB6E4A948")
    @DSModeled(DSC.SAFE)
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.291 -0400", hash_original_method = "237D31B5A43A7733C9219A4289DB54A9", hash_generated_method = "1A25AAE588ACC548D6A942CFFCD99355")
    @DSModeled(DSC.SAFE)
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.292 -0400", hash_original_method = "D3722A63E3ED25EA76952CBDD9156CED", hash_generated_method = "47B7678F13DC2281E6E2C4FD9D5A7B47")
    @DSModeled(DSC.SAFE)
     void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds) {
        dsTaint.addTaint(offsetFromChildToParent);
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(clipToBounds);
        dsTaint.addTaint(rect.dsTaint);
        ViewParent theParent;
        theParent = descendant.mParent;
        {
            {
                rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
                {
                    View p;
                    p = (View) theParent;
                    rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                } //End block
            } //End block
            {
                {
                    View p;
                    p = (View) theParent;
                    rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                } //End block
                rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
            } //End block
            descendant = (View) theParent;
            theParent = descendant.mParent;
        } //End block
        {
            {
                rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
            } //End block
            {
                rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
            } //End block
        } //End block
        {
            throw new IllegalArgumentException("parameter must be a descendant of this view");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.292 -0400", hash_original_method = "7A1B0B3F062F0EF6FC199DD0C643A517", hash_generated_method = "76FB9E35B531436589140CB62AEABAEC")
    @DSModeled(DSC.SAFE)
    public void offsetChildrenTopAndBottom(int offset) {
        dsTaint.addTaint(offset);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View v;
                v = children[i];
                v.mTop += offset;
                v.mBottom += offset;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View v = children[i];
            //v.mTop += offset;
            //v.mBottom += offset;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.292 -0400", hash_original_method = "5C31858D2677D0E5DD9194B8EDADFECC", hash_generated_method = "2C358D3511CDAE39F147B0FE68517882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(offset.dsTaint);
        final RectF rect;
        rect = new RectF();
        rect.set(r);
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_1208090991 = (!child.hasIdentityMatrix());
            {
                child.getMatrix().mapRect(rect);
            } //End block
        } //End collapsed parenthetic
        int dx;
        dx = child.mLeft - mScrollX;
        int dy;
        dy = child.mTop - mScrollY;
        rect.offset(dx, dy);
        {
            {
                boolean var4909A00AAC5857DB675C7058066C1F45_1017489156 = (!child.hasIdentityMatrix());
                {
                    float[] position;
                    position = mAttachInfo.mTmpTransformLocation;
                    position = new float[2];
                    position[0] = offset.x;
                    position[1] = offset.y;
                    child.getMatrix().mapPoints(position);
                    offset.x = (int) (position[0] + 0.5f);
                    offset.y = (int) (position[1] + 0.5f);
                } //End block
            } //End collapsed parenthetic
            offset.x += dx;
            offset.y += dy;
        } //End block
        {
            boolean var08BB32A43948A9AA882E62C649D0F6D4_1907939955 = (rect.intersect(0, 0, mRight - mLeft, mBottom - mTop));
            {
                r.set((int) (rect.left + 0.5f), (int) (rect.top + 0.5f),
                    (int) (rect.right + 0.5f), (int) (rect.bottom + 0.5f));
                boolean var815D42ADB6C99D0ABB4FA68231A12D7A_2014180398 = (mParent.getChildVisibleRect(this, r, offset));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.292 -0400", hash_original_method = "89A2794B62BBEA7754F18155FA121F08", hash_generated_method = "AE78906E7C8CFB5D987B78827C5FDBF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void layout(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        {
            boolean varFB56D3D497D368E0550C6286169A3692_1066054560 = (mTransition == null || !mTransition.isChangingLayout());
            {
                super.layout(l, t, r, b);
            } //End block
            {
                mLayoutSuppressed = true;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mTransition == null || !mTransition.isChangingLayout()) {
            //super.layout(l, t, r, b);
        //} else {
            //mLayoutSuppressed = true;
        //}
    }

    
        @Override
protected abstract void onLayout(boolean changed,
            int l, int t, int r, int b);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "74094E4283ACC987205CEBE8397B866C", hash_generated_method = "57B24CC198A34222F30F4CC7735206B3")
    @DSModeled(DSC.SAFE)
    protected boolean canAnimate() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutAnimationController != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "99174EE5664A8F981F50635AC5D4970E", hash_generated_method = "04315FEBA37E7751546EE2E2D23A2773")
    @DSModeled(DSC.SAFE)
    public void startLayoutAnimation() {
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mLayoutAnimationController != null) {
            //mGroupFlags |= FLAG_RUN_ANIMATION;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "06C0C7BBCCF19FA4957838E03EE331C8", hash_generated_method = "B710E2D8D1BB5BAEF7C77140AA5EB387")
    @DSModeled(DSC.SAFE)
    public void scheduleLayoutAnimation() {
        mGroupFlags |= FLAG_RUN_ANIMATION;
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_RUN_ANIMATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "76D54B6C61296EF04870B520A219B087", hash_generated_method = "BD19920B293BA8B92AB711944FBED2FE")
    @DSModeled(DSC.SAFE)
    public void setLayoutAnimation(LayoutAnimationController controller) {
        dsTaint.addTaint(controller.dsTaint);
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        } //End block
        // ---------- Original Method ----------
        //mLayoutAnimationController = controller;
        //if (mLayoutAnimationController != null) {
            //mGroupFlags |= FLAG_RUN_ANIMATION;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "F73529A9C6F3A35F255991BD21CDD8F9")
    @DSModeled(DSC.SAFE)
    public LayoutAnimationController getLayoutAnimation() {
        return (LayoutAnimationController)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayoutAnimationController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "91C32769C37DCC6F9F6B4528E4A57D15", hash_generated_method = "839C3FEE310E170AD4BFBF9DDFBFAF73")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "DD639E9259A75AF16A9190E263F8776F", hash_generated_method = "83FF8959EFDE1BB19887E6A586DF9DC4")
    @DSModeled(DSC.SAFE)
    public void setAnimationCacheEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "B9ACD8DAE870BEF4EFBF779A704F6EA0", hash_generated_method = "2083DC3ED9D7EDC60C13027077F23580")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "ACB4830CB4940DD4B9F47560853379A8", hash_generated_method = "6BE67B4104B69561B085DD9E2FCA0403")
    @DSModeled(DSC.SAFE)
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        dsTaint.addTaint(always);
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.293 -0400", hash_original_method = "4364C0D051F178DD0E8ADCB73D61750A", hash_generated_method = "5A52EA21409BF2D1FCF6CCB7B9A4BA3C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "2230D982A122AD23513779DE65F20855", hash_generated_method = "B537F17E0A07239B30700D9C07B98E44")
    @DSModeled(DSC.SAFE)
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "5166D8925764E3FCE51BAB9F8B82BB83", hash_generated_method = "C15F742E858EB51A6F0C7EC75D24CCD0")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawingOrderEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "206BAF2A94AC84475BA4253F279E8423", hash_generated_method = "41D19BCD44EE16BFD6D90F908D6F29CE")
    @DSModeled(DSC.SAFE)
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "DAA9F10BF0EA997E391E78BA1DF6ABEE", hash_generated_method = "195FB8AEAE79C29DD169CC671930BD6B")
    @DSModeled(DSC.SAFE)
    private void setBooleanFlag(int flag, boolean value) {
        dsTaint.addTaint(flag);
        dsTaint.addTaint(value);
        {
            mGroupFlags &= ~flag;
        } //End block
        // ---------- Original Method ----------
        //if (value) {
            //mGroupFlags |= flag;
        //} else {
            //mGroupFlags &= ~flag;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "944A8E363FECEAC5FA18188B2A82EEA9", hash_generated_method = "C6B2CA6CAC60D06EDF9220F9940B1F53")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
        @ViewDebug.IntToString(from = PERSISTENT_NO_CACHE,        to = "NONE"),
        @ViewDebug.IntToString(from = PERSISTENT_ANIMATION_CACHE, to = "ANIMATION"),
        @ViewDebug.IntToString(from = PERSISTENT_SCROLLING_CACHE, to = "SCROLLING"),
        @ViewDebug.IntToString(from = PERSISTENT_ALL_CACHES,      to = "ALL")
    })
    public int getPersistentDrawingCache() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPersistentDrawingCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "E1A853399F91DFB847E7C25FCC355E2E", hash_generated_method = "7CD2AC6D465DDF27B232BEABAD3CBF92")
    @DSModeled(DSC.SAFE)
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        dsTaint.addTaint(drawingCacheToKeep);
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
        // ---------- Original Method ----------
        //mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "D158252004EF5A293000F781E4C2272F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var1608545582BA25B7A0B072469C4B0958_531803978 = (new LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "732F05B425275E63BD87B7814AB2A9CD", hash_generated_method = "0C08F2CB8A8880985439FDD071B3B221")
    @DSModeled(DSC.SAFE)
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "378AC11079CE6884A850F340A9660EF3", hash_generated_method = "29301378220E8B6FB5A6B63018AD3D74")
    @DSModeled(DSC.SAFE)
    protected LayoutParams generateDefaultLayoutParams() {
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.294 -0400", hash_original_method = "4EE7CD38DD5C6A89B0A06AD3B67D59FC", hash_generated_method = "1D812EF366971216E623C43FE905A044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchConsistencyCheck(int consistency) {
        dsTaint.addTaint(consistency);
        boolean result;
        result = super.dispatchConsistencyCheck(consistency);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                {
                    boolean var701606913081A4231078EDA1C31F9544_1655191322 = (!children[i].dispatchConsistencyCheck(consistency));
                    result = false;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = super.dispatchConsistencyCheck(consistency);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //if (!children[i].dispatchConsistencyCheck(consistency)) result = false;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "9938C74D91901C257958D174411BCA62", hash_generated_method = "81AC94EAB3C372B116157B59246C22A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consistency);
        boolean result;
        result = super.onConsistencyCheck(consistency);
        final boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing;
        checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varC3E3292263C4B7F2461A3F2B810768A5_605641357 = (children[i].getParent() != this);
                        {
                            result = false;
                            android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "View " + children[i] + " has no parent/a parent that is not " + this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                final ViewParent parent;
                parent = getParent();
                {
                    {
                        result = false;
                        android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                                "ViewGroup " + this + " is dirty but its parent is not: " + this);
                    } //End block
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "9209AC82FBA5456C7517DF8735B229C2", hash_generated_method = "468D5F8E8890589C6EB2D1758669ED23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void debug(int depth) {
        dsTaint.addTaint(depth);
        super.debug(depth);
        String output;
        {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View child;
                child = mChildren[i];
                child.debug(depth + 1);
            } //End block
        } //End collapsed parenthetic
        {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        // ---------- Original Method ----------
        //super.debug(depth);
        //String output;
        //if (mFocused != null) {
            //output = debugIndent(depth);
            //output += "mFocused";
            //Log.d(VIEW_LOG_TAG, output);
        //}
        //if (mChildrenCount != 0) {
            //output = debugIndent(depth);
            //output += "{";
            //Log.d(VIEW_LOG_TAG, output);
        //}
        //int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //View child = mChildren[i];
            //child.debug(depth + 1);
        //}
        //if (mChildrenCount != 0) {
            //output = debugIndent(depth);
            //output += "}";
            //Log.d(VIEW_LOG_TAG, output);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "A3819F4FC73AAB74FEBE19CD2546FBCA", hash_generated_method = "B320D1185A5DF6A1055C9D5ACF6F9B29")
    @DSModeled(DSC.SAFE)
    public int indexOfChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        final int count;
        count = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //if (children[i] == child) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "7030903D0CFC3D101159E57E177A8D82", hash_generated_method = "9E1C8126D57C50EA030BBB580C152E11")
    @DSModeled(DSC.SAFE)
    public int getChildCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "DC55A008910617641F1AE978A0E895D4", hash_generated_method = "397BA806CD05C3C76CE66FD8AE8D0691")
    @DSModeled(DSC.SAFE)
    public View getChildAt(int index) {
        dsTaint.addTaint(index);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index < 0 || index >= mChildrenCount) {
            //return null;
        //}
        //return mChildren[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "542392FF7FE475C27FCC004AAEE4D21F", hash_generated_method = "D0C5BD26348660C5ADF5E40902F02ED5")
    @DSModeled(DSC.SAFE)
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        final int size;
        size = mChildrenCount;
        final View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                {
                    measureChild(child, widthMeasureSpec, heightMeasureSpec);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int size = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < size; ++i) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) != GONE) {
                //measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.295 -0400", hash_original_method = "9EDA680ED83105527C80B1E780D1BEC7", hash_generated_method = "00A4125E03C34AB0E80F87CD4FAD793A")
    @DSModeled(DSC.SAFE)
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        final LayoutParams lp;
        lp = child.getLayoutParams();
        final int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final LayoutParams lp = child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight, lp.width);
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom, lp.height);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "DF0652AA16CC35609E8DBABD1504358F", hash_generated_method = "8F2F5E56C5AA35766B91993DED66A807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(widthUsed);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        dsTaint.addTaint(heightUsed);
        final MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        //+ widthUsed, lp.width);
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        //+ heightUsed, lp.height);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "CE9BBFEF7EDAED30B70FA248C27ACD8B", hash_generated_method = "186E42137ADCD5F98A96B30562C09799")
    public static int getChildMeasureSpec(int spec, int padding, int childDimension) {
        int specMode = MeasureSpec.getMode(spec);
        int specSize = MeasureSpec.getSize(spec);
        int size = Math.max(0, specSize - padding);
        int resultSize = 0;
        int resultMode = 0;
        switch (specMode) {
        case MeasureSpec.EXACTLY:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = size;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;
        case MeasureSpec.AT_MOST:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;
        case MeasureSpec.UNSPECIFIED:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = 0;
                resultMode = MeasureSpec.UNSPECIFIED;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = 0;
                resultMode = MeasureSpec.UNSPECIFIED;
            }
            break;
        }
        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "92C99C7B01BA8D70EFEE87F46C0710D1", hash_generated_method = "BC645F31B03622CD5AE61DB98B56D54B")
    @DSModeled(DSC.SAFE)
    public void clearDisappearingChildren() {
        {
            mDisappearingChildren.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mDisappearingChildren != null) {
            //mDisappearingChildren.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "EFF49544FBF4F5023D4E3259D68E48A6", hash_generated_method = "B20909EABC04144D202D2A69ACBEC793")
    @DSModeled(DSC.SAFE)
    private void addDisappearingView(View v) {
        dsTaint.addTaint(v.dsTaint);
        ArrayList<View> disappearingChildren;
        disappearingChildren = mDisappearingChildren;
        {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        } //End block
        disappearingChildren.add(v);
        // ---------- Original Method ----------
        //ArrayList<View> disappearingChildren = mDisappearingChildren;
        //if (disappearingChildren == null) {
            //disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        //}
        //disappearingChildren.add(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "F02FCA79EB2173CD96A012235B90F902", hash_generated_method = "09CA00B4F57A3041D4E2DD937E88AED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishAnimatingView(final View view, Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        final ArrayList<View> disappearingChildren;
        disappearingChildren = mDisappearingChildren;
        {
            {
                boolean var469F1AC6EE958AE18E6E98146553974E_1835296139 = (disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                    view.clearAnimation();
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var43425F3101AF26F025C7208DDDA7464F_1387736276 = (animation != null && !animation.getFillAfter());
            {
                view.clearAnimation();
            } //End block
        } //End collapsed parenthetic
        {
            view.onAnimationEnd();
            view.mPrivateFlags &= ~ANIMATION_STARTED;
            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.296 -0400", hash_original_method = "663B00ABF4B2F32B3DAAC91DDA64BE32", hash_generated_method = "C104FE0BC32462C9020314EACFDFEF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isViewTransitioning(View view) {
        dsTaint.addTaint(view.dsTaint);
        boolean var2C744AD4F2EA7A3D608A882D8C3D4FED_123586150 = ((mTransitioningViews != null && mTransitioningViews.contains(view)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "3DD17A0BC43336D376B4C3E60ACB3106", hash_generated_method = "4DB260ABDA8B62660E229162F49DC05E")
    @DSModeled(DSC.SAFE)
    public void startViewTransition(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            {
                mTransitioningViews = new ArrayList<View>();
            } //End block
            mTransitioningViews.add(view);
        } //End block
        // ---------- Original Method ----------
        //if (view.mParent == this) {
            //if (mTransitioningViews == null) {
                //mTransitioningViews = new ArrayList<View>();
            //}
            //mTransitioningViews.add(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "A78E74DD3F17BBF76B7245787E00733D", hash_generated_method = "06C00F989020F23F895DA9A2EE9B76B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endViewTransition(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            mTransitioningViews.remove(view);
            final ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            {
                boolean var8B6CC6761C9BD4F7C4819DDB2B1B39CF_1798543348 = (disappearingChildren != null && disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        boolean var8D124A8F477EC519F378FF84BB0D8AF5_1177254475 = (mVisibilityChangingChildren != null &&
                        mVisibilityChangingChildren.contains(view));
                        {
                            mVisibilityChangingChildren.remove(view);
                        } //End block
                        {
                            {
                                view.dispatchDetachedFromWindow();
                            } //End block
                            {
                                view.mParent = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "90F24CF973A15FCB3D8EF936857F7660", hash_generated_method = "5C3D6F1AE689AEFA2EE6C3F84A126444")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        final boolean meOpaque;
        meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        super.gatherTransparentRegion(region);
        final View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent;
        noneOfTheChildrenAreTransparent = true;
        {
            int i;
            i = 0;
            {
                final View child;
                child = children[i];
                {
                    boolean var589A259560F2788DFC2988B1FA33F37B_1904225723 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                    {
                        {
                            boolean var02F3557A74971374C057D08F3D583563_1814714489 = (!child.gatherTransparentRegion(region));
                            {
                                noneOfTheChildrenAreTransparent = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        //if (meOpaque && region == null) {
            //return true;
        //}
        //super.gatherTransparentRegion(region);
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //boolean noneOfTheChildrenAreTransparent = true;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) {
                //if (!child.gatherTransparentRegion(region)) {
                    //noneOfTheChildrenAreTransparent = false;
                //}
            //}
        //}
        //return meOpaque || noneOfTheChildrenAreTransparent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "5C4070054C131245FD376376D5198B5B", hash_generated_method = "2BF690DA5099BB82620F53468F19D00A")
    @DSModeled(DSC.SAFE)
    public void requestTransparentRegion(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            {
                mParent.requestTransparentRegion(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (child != null) {
            //child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //if (mParent != null) {
                //mParent.requestTransparentRegion(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "055C0C5E94DF77352535F2463E2E2F92", hash_generated_method = "363356F812F2BD99EC1A093B31C1F952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        dsTaint.addTaint(insets.dsTaint);
        boolean done;
        done = super.fitSystemWindows(insets);
        {
            final int count;
            count = mChildrenCount;
            final View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    done = children[i].fitSystemWindows(insets);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean done = super.fitSystemWindows(insets);
        //if (!done) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //done = children[i].fitSystemWindows(insets);
                //if (done) {
                    //break;
                //}
            //}
        //}
        //return done;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.297 -0400", hash_original_method = "B3B3B12C071F8F31617EDB75C1351CBC", hash_generated_method = "82D47FCFCB28F30154B116E3F77DC865")
    @DSModeled(DSC.SAFE)
    public Animation.AnimationListener getLayoutAnimationListener() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Animation.AnimationListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "309790593767800D49B3C7FD0CAB3F32", hash_generated_method = "4723FC5D8C171315463C4B0FDF210996")
    @DSModeled(DSC.SAFE)
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            } //End block
            final View[] children;
            children = mChildren;
            final int count;
            count = mChildrenCount;
            {
                int i;
                i = 0;
                {
                    final View child;
                    child = children[i];
                    {
                        child.refreshDrawableState();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if ((mGroupFlags & FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE) != 0) {
            //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
                //throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        //+ " child has duplicateParentState set to true");
            //}
            //final View[] children = mChildren;
            //final int count = mChildrenCount;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & DUPLICATE_PARENT_STATE) != 0) {
                    //child.refreshDrawableState();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "9BFEBEB244ACA3F0CF8B6DCD826B4034", hash_generated_method = "2DBE7EDB7AC0591E335CBA215C0E8AE7")
    @DSModeled(DSC.SAFE)
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final View[] children;
        children = mChildren;
        final int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].jumpDrawablesToCurrentState();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].jumpDrawablesToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "0411A3FE715B4530882EE6CBB1252DCB", hash_generated_method = "A6DEF2268FFD44CC124ADBD362B01B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_234342935 = (super.onCreateDrawableState(extraSpace));
        } //End block
        int need;
        need = 0;
        int n;
        n = getChildCount();
        {
            int i;
            i = 0;
            {
                int[] childState;
                childState = getChildAt(i).getDrawableState();
                {
                    need += childState.length;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int[] state;
        state = super.onCreateDrawableState(extraSpace + need);
        {
            int i;
            i = 0;
            {
                int[] childState;
                childState = getChildAt(i).getDrawableState();
                {
                    state = mergeDrawableStates(state, childState);
                } //End block
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) == 0) {
            //return super.onCreateDrawableState(extraSpace);
        //}
        //int need = 0;
        //int n = getChildCount();
        //for (int i = 0; i < n; i++) {
            //int[] childState = getChildAt(i).getDrawableState();
            //if (childState != null) {
                //need += childState.length;
            //}
        //}
        //int[] state = super.onCreateDrawableState(extraSpace + need);
        //for (int i = 0; i < n; i++) {
            //int[] childState = getChildAt(i).getDrawableState();
            //if (childState != null) {
                //state = mergeDrawableStates(state, childState);
            //}
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "1481B38AF6385F8F98E444294398E1C4", hash_generated_method = "CACA4801B6974ACFC0698876E264955E")
    @DSModeled(DSC.SAFE)
    public void setAddStatesFromChildren(boolean addsStates) {
        dsTaint.addTaint(addsStates);
        {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        refreshDrawableState();
        // ---------- Original Method ----------
        //if (addsStates) {
            //mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        //} else {
            //mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        //}
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "026C4CEB09DFE602F5C11A5652FC3C1F", hash_generated_method = "9D9FD376BAFB0FBAEB12AA1C3CA142D3")
    @DSModeled(DSC.SAFE)
    public boolean addStatesFromChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "F32408C60FA79535F6423CE68328A516", hash_generated_method = "E8F55D137A08F37D4CCF12A14A46CA93")
    @DSModeled(DSC.SAFE)
    public void childDrawableStateChanged(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "E45304ED5749DB1604C2CBEA0F0ADC88")
    @DSModeled(DSC.SAFE)
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(animationListener.dsTaint);
        // ---------- Original Method ----------
        //mAnimationListener = animationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.298 -0400", hash_original_method = "8473FDA62EFB348A51ABA227E5F80648", hash_generated_method = "7A7081E121025A291F29504E4A882176")
    @DSModeled(DSC.SAFE)
    public void requestTransitionStart(LayoutTransition transition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(transition.dsTaint);
        ViewRootImpl viewAncestor;
        viewAncestor = getViewRootImpl();
        {
            viewAncestor.requestTransitionStart(transition);
        } //End block
        // ---------- Original Method ----------
        //ViewRootImpl viewAncestor = getViewRootImpl();
        //if (viewAncestor != null) {
            //viewAncestor.requestTransitionStart(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "438FE65F3DA47A9BB347952B8A6B02CD", hash_generated_method = "8D68E01137FEDA523CB535EE680F4A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        final int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = getChildAt(i);
                {
                    boolean varB5612BFB22B66951C85039D6A4ADA2D6_1188762445 = (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedLayoutDirection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.resetResolvedLayoutDirection();
        //final int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT) {
                //child.resetResolvedLayoutDirection();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "83014321BD6411A92FC299225A8B4B68", hash_generated_method = "EB5C2F269BF75B2E013898F5AB2F71FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        final int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                final View child;
                child = getChildAt(i);
                {
                    boolean var97DAD7DCB6178A82512069CD3DA52554_1001510237 = (child.getTextDirection() == TEXT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedTextDirection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.resetResolvedTextDirection();
        //final int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (child.getTextDirection() == TEXT_DIRECTION_INHERIT) {
                //child.resetResolvedTextDirection();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "5C9A659F019E607905CFD91DA9543097")
    @DSModeled(DSC.SAFE)
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    public static class LayoutParams {
        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;
        public static final int MATCH_PARENT = -1;
        public static final int WRAP_CONTENT = -2;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int width;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int height;
        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "15AB37D81442EE27D75B1677A2391AE7", hash_generated_method = "E499818DB0C5EA89A358E7842481DF76")
        @DSModeled(DSC.SAFE)
        public LayoutParams(Context c, AttributeSet attrs) {
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            //setBaseAttributes(a,
                    //R.styleable.ViewGroup_Layout_layout_width,
                    //R.styleable.ViewGroup_Layout_layout_height);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "5C88A43186A25AFB4AD3F871F52175E2")
        @DSModeled(DSC.SAFE)
        public LayoutParams(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "298525BAB9DC06EE53FD57488F861E07")
        @DSModeled(DSC.SAFE)
        public LayoutParams(LayoutParams source) {
            dsTaint.addTaint(source.dsTaint);
            this.width = source.width;
            this.height = source.height;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "AC329F6733AE799AA24404842D38F9DC")
        @DSModeled(DSC.SAFE)
         LayoutParams() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "22F495DEF56CC03879FA6664450D6ACC", hash_generated_method = "B26C4002035F9D66A707060A85DA1BFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            dsTaint.addTaint(heightAttr);
            dsTaint.addTaint(a.dsTaint);
            dsTaint.addTaint(widthAttr);
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
            // ---------- Original Method ----------
            //width = a.getLayoutDimension(widthAttr, "layout_width");
            //height = a.getLayoutDimension(heightAttr, "layout_height");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "F67605AB1738A0C558FBE86D3877EDF8")
        @DSModeled(DSC.SAFE)
        protected void resolveWithDirection(int layoutDirection) {
            dsTaint.addTaint(layoutDirection);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.299 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "61DE762DDA0369F3539A73BA33E92ECD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var540B99D0D715C61DA2A46A0C4E3114DB_24983553 = (output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return output + "ViewGroup.LayoutParams={ width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "F49787D872EDF63D212E65B6FD90D9FA", hash_generated_method = "B2E46279C79FF4777A0FAA227E0C80BB")
        protected static String sizeToString(int size) {
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }

        
    }


    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout")
        public int leftMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        public int topMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        public int rightMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        public int bottomMargin;
        @ViewDebug.ExportedProperty(category = "layout")
        protected int startMargin = DEFAULT_RELATIVE;
        @ViewDebug.ExportedProperty(category = "layout")
        protected int endMargin = DEFAULT_RELATIVE;
        static private final int DEFAULT_RELATIVE = Integer.MIN_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "10E5D625CF55B3D944D3843050E826C6", hash_generated_method = "7E121B58CE7BB5B4A812B530B26D1078")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MarginLayoutParams(Context c, AttributeSet attrs) {
            super();
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_MarginLayout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_MarginLayout_layout_width,
                    R.styleable.ViewGroup_MarginLayout_layout_height);
            int margin;
            margin = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.ViewGroup_MarginLayout_layout_margin, -1);
            {
                leftMargin = margin;
                topMargin = margin;
                rightMargin= margin;
                bottomMargin = margin;
            } //End block
            {
                leftMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginLeft, 0);
                topMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginTop, 0);
                rightMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginRight, 0);
                bottomMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginBottom, 0);
                startMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginStart, DEFAULT_RELATIVE);
                endMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginEnd, DEFAULT_RELATIVE);
            } //End block
            a.recycle();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "ECB3C1A8CE151650940015251C7EC12B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MarginLayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "55868F7F983C11B537A625BA756EE7CC", hash_generated_method = "51A2C5E5CC10F29399612B80753BEF14")
        @DSModeled(DSC.SAFE)
        public MarginLayoutParams(MarginLayoutParams source) {
            dsTaint.addTaint(source.dsTaint);
            this.width = source.width;
            this.height = source.height;
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
            this.startMargin = source.startMargin;
            this.endMargin = source.endMargin;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
            //this.leftMargin = source.leftMargin;
            //this.topMargin = source.topMargin;
            //this.rightMargin = source.rightMargin;
            //this.bottomMargin = source.bottomMargin;
            //this.startMargin = source.startMargin;
            //this.endMargin = source.endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "37C17B9C12DB67CE2F72DA411771AC12")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MarginLayoutParams(LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "A7CFD8E9AA47AE278733C57B8CF5503F", hash_generated_method = "51B1DA386C9402509B76EF5B70588675")
        @DSModeled(DSC.SAFE)
        public void setMargins(int left, int top, int right, int bottom) {
            dsTaint.addTaint(bottom);
            dsTaint.addTaint(left);
            dsTaint.addTaint(right);
            dsTaint.addTaint(top);
            // ---------- Original Method ----------
            //leftMargin = left;
            //topMargin = top;
            //rightMargin = right;
            //bottomMargin = bottom;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "F5A63690A2F55CE5C4D6B1F24495E028", hash_generated_method = "463616A7278CACF8E661D909C99FF7AE")
        @DSModeled(DSC.SAFE)
        public void setMarginsRelative(int start, int top, int end, int bottom) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(bottom);
            dsTaint.addTaint(end);
            dsTaint.addTaint(top);
            // ---------- Original Method ----------
            //startMargin = start;
            //topMargin = top;
            //endMargin = end;
            //bottomMargin = bottom;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.300 -0400", hash_original_method = "A60FB56334BFE35432A89BE021472DEF", hash_generated_method = "CD0444901EDBC20F19A4003DA4B59B7F")
        @DSModeled(DSC.SAFE)
        public int getMarginStart() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return startMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "2B74CF4F3396E75552B1A46DF3D4BFD7", hash_generated_method = "DE1B5C5FF686C90123408AE87C501D0E")
        @DSModeled(DSC.SAFE)
        public int getMarginEnd() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "C9EA583BDFA2583A2B96D706C959CDBC", hash_generated_method = "99829DE79A23E57FBAD597BC2CBACD97")
        @DSModeled(DSC.SAFE)
        public boolean isMarginRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "25B74C4F994FDDCB83271E7B2F9BDDEE", hash_generated_method = "59A45B9E0064571005C098ED42D41E5F")
        @DSModeled(DSC.SAFE)
        @Override
        protected void resolveWithDirection(int layoutDirection) {
            dsTaint.addTaint(layoutDirection);
            //Begin case View.LAYOUT_DIRECTION_RTL 
            leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
            //End case View.LAYOUT_DIRECTION_RTL 
            //Begin case View.LAYOUT_DIRECTION_RTL 
            rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
            //End case View.LAYOUT_DIRECTION_RTL 
            //Begin case View.LAYOUT_DIRECTION_LTR default 
            leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
            //End case View.LAYOUT_DIRECTION_LTR default 
            //Begin case View.LAYOUT_DIRECTION_LTR default 
            rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
            //End case View.LAYOUT_DIRECTION_LTR default 
            // ---------- Original Method ----------
            //switch(layoutDirection) {
                //case View.LAYOUT_DIRECTION_RTL:
                    //leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
                    //rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
                    //break;
                //case View.LAYOUT_DIRECTION_LTR:
                //default:
                    //leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
                    //rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
                    //break;
            //}
        }

        
    }


    
    private static final class TouchTarget {
        private static final int MAX_RECYCLED = 32;
        private static final Object sRecycleLock = new Object();
        private static TouchTarget sRecycleBin;
        private static int sRecycledCount;
        public static final int ALL_POINTER_IDS = -1;
        public View child;
        public int pointerIdBits;
        public TouchTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "30AFE349C3C230804980E34C71E3B1B2")
        @DSModeled(DSC.SAFE)
        private TouchTarget() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "0647B268AD32DD0CD121A6030B3ED68D", hash_generated_method = "90D13BBA16C485F225FBCCF2C7AB38A3")
        public static TouchTarget obtain(View child, int pointerIdBits) {
            final TouchTarget target;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    target = new TouchTarget();
                } else {
                    target = sRecycleBin;
                    sRecycleBin = target.next;
                     sRecycledCount--;
                    target.next = null;
                }
            }
            target.child = child;
            target.pointerIdBits = pointerIdBits;
            return target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "52E2A4A02C5EEF131AC73E7F0B0218F9")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                {
                    next = null;
                } //End block
                child = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (sRecycleLock) {
                //if (sRecycledCount < MAX_RECYCLED) {
                    //next = sRecycleBin;
                    //sRecycleBin = this;
                    //sRecycledCount += 1;
                //} else {
                    //next = null;
                //}
                //child = null;
            //}
        }

        
    }


    
    private static final class HoverTarget {
        private static final int MAX_RECYCLED = 32;
        private static final Object sRecycleLock = new Object();
        private static HoverTarget sRecycleBin;
        private static int sRecycledCount;
        public View child;
        public HoverTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "E2E5A564B1246A27359DEE09D1D640AA")
        @DSModeled(DSC.SAFE)
        private HoverTarget() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "D2DE25A44D743B097D4278E5DD90F8BF", hash_generated_method = "6D5659C2729975767D9AA0681E3FC091")
        public static HoverTarget obtain(View child) {
            final HoverTarget target;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    target = new HoverTarget();
                } else {
                    target = sRecycleBin;
                    sRecycleBin = target.next;
                     sRecycledCount--;
                    target.next = null;
                }
            }
            target.child = child;
            return target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.301 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "52E2A4A02C5EEF131AC73E7F0B0218F9")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                {
                    next = null;
                } //End block
                child = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (sRecycleLock) {
                //if (sRecycledCount < MAX_RECYCLED) {
                    //next = sRecycleBin;
                    //sRecycleBin = this;
                    //sRecycledCount += 1;
                //} else {
                    //next = null;
                //}
                //child = null;
            //}
        }

        
    }


    
    public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
    
}


