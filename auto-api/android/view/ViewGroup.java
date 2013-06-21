package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
import java.util.ArrayList;
import java.util.HashSet;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    protected ArrayList<View> mDisappearingChildren;
    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    private View mFocused;
    private Transformation mChildTransformation = new Transformation();
    private RectF mInvalidateRegion;
    private Transformation mInvalidationTransformation;
    private View mCurrentDragView;
    private DragEvent mCurrentDrag;
    private HashSet<View> mDragNotifiedChildren;
    private boolean mChildAcceptsDrag;
    private PointF mLocalPoint = new PointF();
    private LayoutAnimationController mLayoutAnimationController;
    private Animation.AnimationListener mAnimationListener;
    private TouchTarget mFirstTouchTarget;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private long mLastTouchDownTime;
    @ViewDebug.ExportedProperty(category = "events") private int mLastTouchDownIndex = -1;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownX;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownY;
    private HoverTarget mFirstHoverTarget;
    private boolean mHoveredSelf;
    protected int mGroupFlags;
    protected int mPersistentDrawingCache;
    private View[] mChildren;
    private boolean mLayoutSuppressed = false;
    private int mChildrenCount;
    private Paint mCachePaint;
    private LayoutTransition mTransition;
    private ArrayList<View> mTransitioningViews;
    private ArrayList<View> mVisibilityChangingChildren;
    @ViewDebug.ExportedProperty(category = "drawing") private boolean mDrawLayers = true;
    private LayoutTransition.TransitionListener mLayoutTransitionListener = new LayoutTransition.TransitionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.491 -0400", hash_original_method = "BD73D83C5E4C50AAE7C2D0E44AB74A47", hash_generated_method = "7709F58BE403F41DDF4F934094D39EF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.492 -0400", hash_original_method = "04DFE6408D192F5CD42CA1A3B87396E7", hash_generated_method = "BDA366458FA0D129532808AE713BB592")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            dsTaint.addTaint(container.dsTaint);
            dsTaint.addTaint(transition.dsTaint);
            dsTaint.addTaint(transitionType);
            dsTaint.addTaint(view.dsTaint);
            {
                boolean var00EE79CB64B66FAC37BA4FE35CB2471D_1997288567 = (mLayoutSuppressed && !transition.isChangingLayout());
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.492 -0400", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "28884FA73BD50E12EE0AE1408EE908D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewGroup(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        initViewGroup();
        // ---------- Original Method ----------
        //initViewGroup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.492 -0400", hash_original_method = "01EF181B5B9BD1E2AA94519EF8FAEC5E", hash_generated_method = "99ACA408F37C9DAF90E881355FDB182F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.492 -0400", hash_original_method = "FE20AAD08B3866F38DB1C82409548865", hash_generated_method = "559D7F54761C71773022A09F91FA1DF3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.492 -0400", hash_original_method = "8201DDC69D3895B689FCA6813D812A1F", hash_generated_method = "9E40C34B27D45A0A04BFC0986C016C25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initViewGroup() {
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        {
            boolean varEEA1697260544E0A5861DD090A86C488_687117435 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.493 -0400", hash_original_method = "4BC426CDAC642CD3FACBBAAA9F56EF39", hash_generated_method = "7E7403AF01ADF6840E644B9ADC76012C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromAttributes(Context context, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                R.styleable.ViewGroup);
        int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.493 -0400", hash_original_method = "9DEFF27CA0C7CA0A646DEBC837B35971", hash_generated_method = "3EFB762183CB80FB4ED94D20022C1646")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.493 -0400", hash_original_method = "0404A0C2267D357D33DA2838086AAD01", hash_generated_method = "95E132D5A3D45A6F600BC3B806927455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.494 -0400", hash_original_method = "1894A66AF55103F8230E4E4C184BE483", hash_generated_method = "3B2A9E88D038C4D51FFE97E77142FF59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.494 -0400", hash_original_method = "18A4940B9B410F6E2A586E7BEB513255", hash_generated_method = "F34BC60E04606C3938560AF7140DFE4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestChildFocus(View child, View focused) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(focused.dsTaint);
        {
            System.out.println(this + " requestChildFocus()");
        } //End block
        {
            boolean varD47ACE2ACEC5C175A0471B099816BE37_704841655 = (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.494 -0400", hash_original_method = "B9C632089323DEB68745C50418B61ADF", hash_generated_method = "504748FCF3EE382F0BC8BA41AF454305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void focusableViewAvailable(View v) {
        dsTaint.addTaint(v.dsTaint);
        {
            boolean varB10813EF6870F670C964BBAED5788EED_2054453249 = (mParent != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.494 -0400", hash_original_method = "AAA08A22C93220CA5F37A81C00115203", hash_generated_method = "9E997CA045001070D904D66EFD228F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean showContextMenuForChild(View originalView) {
        dsTaint.addTaint(originalView.dsTaint);
        boolean varBA8B92D993B1A5B6CF969236EEAB6152_1992514743 = (mParent != null && mParent.showContextMenuForChild(originalView));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParent != null && mParent.showContextMenuForChild(originalView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.495 -0400", hash_original_method = "8C60B2F96F2B489988C14A93A463DAE3", hash_generated_method = "6DC848623A6DA022D8302C81FDFBF0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(originalView.dsTaint);
        {
            Object var5E408DB4443FE360E96CE9F1C5BBDCDF_2102095532 = (mParent.startActionModeForChild(originalView, callback));
        } //End flattened ternary
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.495 -0400", hash_original_method = "32394A633C776A8BC33A6BFC48D3DC37", hash_generated_method = "0958D713EE072DD37BA254E64FEF763F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View focusSearch(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        {
            boolean var6900EB30484F14AE1B69428931AEDE0D_1367892818 = (isRootNamespace());
            {
                View var0906A08A84901482622FE4727E85B5D8_113674872 = (FocusFinder.getInstance().findNextFocus(this, focused, direction));
            } //End block
            {
                View varEFEA41BC826299E92C70E785F9AC460C_1569475711 = (mParent.focusSearch(focused, direction));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.495 -0400", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "5B279C1ECDBF72EF2A8B9E1300FE1B06")
    @DSModeled(DSC.SAFE)
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(immediate);
        dsTaint.addTaint(rectangle.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.495 -0400", hash_original_method = "B4AA594F7D6DA64F58B166664BBA4580", hash_generated_method = "00235005CE3BF27E88B74FB2EDC4878A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        ViewParent parent;
        parent = getParent();
        boolean propagate;
        propagate = onRequestSendAccessibilityEvent(child, event);
        boolean var441FEE5B5C6B1D4A365CF02E122B98E7_761869676 = (parent.requestSendAccessibilityEvent(this, event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.496 -0400", hash_original_method = "0D2782B4A269D15DF81200BFDAFE535A", hash_generated_method = "175E98B12566CC61A0228DA9385F4D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5A0C8D77442C96677A25BCD888A43DDA_2110254758 = (mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event));
        } //End block
        {
            boolean var36AE0BB3330710CD64DFF9DF5BCECE4F_77325466 = (onRequestSendAccessibilityEventInternal(child, event));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        //} else {
            //return onRequestSendAccessibilityEventInternal(child, event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.496 -0400", hash_original_method = "F0DFCA5DE1F330F511BBFF62182D5BD4", hash_generated_method = "E751F66614E7E71ABB25FA34514476A3")
    @DSModeled(DSC.SAFE)
     boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.496 -0400", hash_original_method = "E35CCEA2DF29F8696C548F55094B5B73", hash_generated_method = "9C07B2EFAD3A72436123E0E116DF6A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(focused.dsTaint);
        boolean var661477CC7A374E9FA1E26C430B4E7B43_192915295 = (mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFocused != null &&
                //mFocused.dispatchUnhandledMove(focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.496 -0400", hash_original_method = "1A8D22FF280DB81B170D27815BE7BEAA", hash_generated_method = "6335B9E3E7A4FC695A4E0B9512F56160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.496 -0400", hash_original_method = "2A2B29C64ED25C5483BB6B32C5BD1628", hash_generated_method = "3342498F7A8B69ACA45B632AC7F311FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.497 -0400", hash_original_method = "AD8CA09F957410559E0C3DF16ADDE822", hash_generated_method = "F120404050A1F818C6DEF3758FDB7E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.497 -0400", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "B4609789159F56B587DF4EA59A2B5730")
    @DSModeled(DSC.SAFE)
    public View getFocusedChild() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFocused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.497 -0400", hash_original_method = "3D9AAFDE8E8826B256A10D32D774D94B", hash_generated_method = "7B9F2DA342389653DDFC63EA6B18B1E1")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasFocus() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.497 -0400", hash_original_method = "8D50679A3D30F96CD0297A05342EFA70", hash_generated_method = "402E1BE4EE406295B5534E954B3CE7B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View findFocus() {
        {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        } //End block
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_510083746 = (isFocused());
        } //End collapsed parenthetic
        {
            View varEF2A7660E1D3D149D3BDB7C10B3A63D6_296642455 = (mFocused.findFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.497 -0400", hash_original_method = "415824CC4E37F2B08D458BE00E3F5A3F", hash_generated_method = "D907AD634F5B3FC544ECD97326D718C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasFocusable() {
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_1056734630 = (isFocusable());
        } //End collapsed parenthetic
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var7DC29F4EF4EE5211D58EB348F2B6AE7E_1798805497 = (child.hasFocusable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.498 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "F8B82E42E2C79C19FB042F4D06E10D4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(views.dsTaint);
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.498 -0400", hash_original_method = "A281D125D4DD0434A87F479D62DD0361", hash_generated_method = "B0DAA8BAAC908044CA5760155C4494DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(focusableMode);
        int focusableCount;
        focusableCount = views.size();
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        child.addFocusables(views, direction, focusableMode);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var0F1BFD0DBC136B3E2580439E8453837C_2003774184 = (descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.498 -0400", hash_original_method = "01B0DFF5DFF6A04EF473202885B21AEA", hash_generated_method = "55DADAA488E2A1E4457CE27FD0C026E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(outViews.dsTaint);
        dsTaint.addTaint(flags);
        super.findViewsWithText(outViews, text, flags);
        int childrenCount;
        childrenCount = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.499 -0400", hash_original_method = "E63784DE90D03F6D10488691622E702B", hash_generated_method = "7BC8872873D626DA5D4AC4DF19AA1CC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        dsTaint.addTaint(accessibilityId);
        View foundView;
        foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        int childrenCount;
        childrenCount = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.499 -0400", hash_original_method = "8947E2F3FD45B1E1CD9A8BF9F902DE4D", hash_generated_method = "71D469C53364F61342BF0156871BFDCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        dsTaint.addTaint(hasFocus);
        super.dispatchWindowFocusChanged(hasFocus);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.499 -0400", hash_original_method = "3C050A87A5AA11FCC905DB1242C91519", hash_generated_method = "0E18916AEF3BC01FB272760FD8B47DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTouchables(ArrayList<View> views) {
        dsTaint.addTaint(views.dsTaint);
        super.addTouchables(views);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.499 -0400", hash_original_method = "E3ECA4D0183F28678AE9A73BEBE4A4C4", hash_generated_method = "675817A059AADC97045E0D6C7AF3F484")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchDisplayHint(int hint) {
        dsTaint.addTaint(hint);
        super.dispatchDisplayHint(hint);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.500 -0400", hash_original_method = "39046505104385736A9526E25AC3965D", hash_generated_method = "FC7E57060024F6D22FCF4E734BBD7D27")
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
                    boolean var062D8AB67088E18389484F6801BD9183_700354733 = (mTransitioningViews != null && mTransitioningViews.contains(child));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.500 -0400", hash_original_method = "66EC1DB8C5DE29B0D05D23F4BE080169", hash_generated_method = "F9FC27ADC9CBE7952922562611AFC60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(changedView.dsTaint);
        super.dispatchVisibilityChanged(changedView, visibility);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.500 -0400", hash_original_method = "110C8ADF44E81EF076420285F756776D", hash_generated_method = "F24024B767667085BCBA9EAB92D8D546")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        dsTaint.addTaint(visibility);
        super.dispatchWindowVisibilityChanged(visibility);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.500 -0400", hash_original_method = "4BA014AA7FB311F49457CF496AD5B6EF", hash_generated_method = "3B1BD53BBC66A13D22E2DAD92E44095E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        dsTaint.addTaint(newConfig.dsTaint);
        super.dispatchConfigurationChanged(newConfig);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.501 -0400", hash_original_method = "F881B5C75EE06984153060972C295D8F", hash_generated_method = "27A21812DEE732401659C39D49EFFE22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.501 -0400", hash_original_method = "99C97332C863B663BFCA518BE284DB35", hash_generated_method = "B3BD59099A9C6E79539F0F4543F5136A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void dispatchCollectViewAttributes(int visibility) {
        dsTaint.addTaint(visibility);
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.501 -0400", hash_original_method = "C5DA1A7419AFEADC86BA0783BA235334", hash_generated_method = "19B7079B6803400762259F2CCAC23BF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.519 -0400", hash_original_method = "0B94D743FFC1DE288527F02F6E8345CD", hash_generated_method = "C68E2ACAC9A0F9FB4A2E2B6186FD73FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean retval;
        retval = false;
        float tx;
        tx = event.mX;
        float ty;
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
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    child.mPrivateFlags2 &= ~View.DRAG_MASK;
                    {
                        boolean var93DCAA7E24F58D6762D32E351E886EF8_480969397 = (child.getVisibility() == VISIBLE);
                        {
                            boolean handled;
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
                    Iterator<View> var3378C5B405A48B24956CD00DB7CCC663_2094972186 = (mDragNotifiedChildren).iterator();
                    var3378C5B405A48B24956CD00DB7CCC663_2094972186.hasNext();
                    View child = var3378C5B405A48B24956CD00DB7CCC663_2094972186.next();
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
            View target;
            target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                root.setDragFocus(target);
                int action;
                action = event.mAction;
                {
                    View view;
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
                View view;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.520 -0400", hash_original_method = "A61A140E816A1C908C27B7F105ECC965", hash_generated_method = "0AEFE5DE939CCDD5D6AC238386A27AF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint) {
        dsTaint.addTaint(outLocalPoint.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = count - 1;
            {
                View child;
                child = children[i];
                {
                    boolean varDD9451246475E78E9B9862A08B40ED39_1724068767 = (!child.canAcceptDrag());
                } //End collapsed parenthetic
                {
                    boolean varB60C7CACEA3B7B85D44A4D6C320C4F52_276087021 = (isTransformedTouchPointInView(x, y, child, outLocalPoint));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.520 -0400", hash_original_method = "01B6DB1535B88ABBDA0897E44597D185", hash_generated_method = "645C8856D79337E851C3764A3DF5DD1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean notifyChildOfDrag(View child) {
        dsTaint.addTaint(child.dsTaint);
        {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        } //End block
        boolean canAccept;
        canAccept = false;
        {
            boolean var9513878AE6807A2BEC04686702F54F4D_305164457 = (! mDragNotifiedChildren.contains(child));
            {
                mDragNotifiedChildren.add(child);
                canAccept = child.dispatchDragEvent(mCurrentDrag);
                {
                    boolean var6E0AEBF66F234C4EF96F0B794A136F59_315753637 = (canAccept && !child.canAcceptDrag());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.521 -0400", hash_original_method = "6EA017C64305C1BE29415F2C64CCEDD4", hash_generated_method = "8EB0E72E32DF2AC49B22BB39B3E7B618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        dsTaint.addTaint(visible);
        super.dispatchSystemUiVisibilityChanged(visible);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.521 -0400", hash_original_method = "5F03A98EA003A081CE87491B56EF094D", hash_generated_method = "3492FC5D1C3E98B11D1DE58AF4A516C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        dsTaint.addTaint(localChanges);
        dsTaint.addTaint(localValue);
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.521 -0400", hash_original_method = "1796A9ED58069BDF38C7C072FE20CF71", hash_generated_method = "98ADA8DD8EF7CC847D836F54B804DD8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var69A4D5BA21F9754791BA96F9F5C71142_1443919247 = (super.dispatchKeyEventPreIme(event));
        } //End block
        {
            boolean varFE2571F324BFA6DB9FF0B9BEE57E874E_1416529866 = (mFocused.dispatchKeyEventPreIme(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.522 -0400", hash_original_method = "1E41A7E6E3EFA9117FFB3A56DB417CA0", hash_generated_method = "5B09A173F869A6834C1EB79823F9CEFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        } //End block
        {
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_509477718 = (super.dispatchKeyEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBA71E8F3A809B2219624C59EBC2DEB55_1359267684 = (mFocused.dispatchKeyEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.522 -0400", hash_original_method = "C8DF4A46704EEB88AB3A3DAEBDA2EE59", hash_generated_method = "5A5DCEF0DB71EB81AF1AE72FA9F344E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varF75FC08430B3CB671A7FC788738670A4_605003115 = (super.dispatchKeyShortcutEvent(event));
        } //End block
        {
            boolean var9C5A31847C19CF0D448BFF804D2D7DBC_840297145 = (mFocused.dispatchKeyShortcutEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.522 -0400", hash_original_method = "CF1D00451039D1CA46B97508DE17783C", hash_generated_method = "A71C3767159FCC8DBD34C5E25051D82F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        } //End block
        {
            {
                boolean varDD1D6069514DE34833A921C8364915DD_1254971151 = (super.dispatchTrackballEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var0FFB054D71651438CDA84A82C67C65B6_766264537 = (mFocused.dispatchTrackballEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.523 -0400", hash_original_method = "E0F6A76AF2BEDB6076446B6A929BAC84", hash_generated_method = "310B1894C7CA3EFB636167DBF4F80612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"ConstantConditions"})
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int action;
        action = event.getAction();
        boolean interceptHover;
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
            float x;
            x = event.getX();
            float y;
            y = event.getY();
            int childrenCount;
            childrenCount = mChildrenCount;
            {
                View[] children;
                children = mChildren;
                HoverTarget lastHoverTarget;
                lastHoverTarget = null;
                {
                    int i;
                    i = childrenCount - 1;
                    {
                        View child;
                        child = children[i];
                        {
                            boolean var39A5B2EF267FE4EA5711368BBCBF6FA1_1618916659 = (!canViewReceivePointerEvents(child)
                            || !isTransformedTouchPointInView(x, y, child, null));
                        } //End collapsed parenthetic
                        HoverTarget hoverTarget;
                        hoverTarget = firstOldHoverTarget;
                        boolean wasHovered;
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
                                    wasHovered = true;
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
            View child;
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
            HoverTarget nextOldHoverTarget;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.524 -0400", hash_original_method = "CAF0CE39145036A2F3E98F46F45FF397", hash_generated_method = "D5BF4317267EBE8DD87C017795C0D161")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean hasHoveredChild() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFirstHoverTarget != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.524 -0400", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "52C8E024F46F4E8C41AD0ADCEECE03BD")
    @DSModeled(DSC.SAFE)
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
        private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.524 -0400", hash_original_method = "8425E6039966203E8B52A55F0ACFD97E", hash_generated_method = "5F5B2EA278CE497AEDD390369EBF7C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int childrenCount;
        childrenCount = mChildrenCount;
        {
            View[] children;
            children = mChildren;
            float x;
            x = event.getX();
            float y;
            y = event.getY();
            {
                int i;
                i = childrenCount - 1;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var330479A3EB93BD7FBB36FC9D307449EC_2069612405 = (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null));
                    } //End collapsed parenthetic
                    {
                        boolean varE3F3EFAB7A0C507CFC1087341B7293FA_1078506556 = (dispatchTransformedGenericPointerEvent(event, child));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var08E200417CAE6114EB8B8E0EE91851EC_1713576608 = (super.dispatchGenericPointerEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.524 -0400", hash_original_method = "EF2476E6EC182ADC11908B65D0A31365", hash_generated_method = "B82DA2DB8562CF67EE78DAD9EBF300DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB46815DBC1BC9F2955B6C32C32EC3809_441103826 = (super.dispatchGenericFocusedEvent(event));
        } //End block
        {
            boolean varDAA7826F7D7AE31750BF98F87DE576DE_1731475996 = (mFocused.dispatchGenericMotionEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.525 -0400", hash_original_method = "89F3902132A72D71D534028C51E6FDBB", hash_generated_method = "C4A96D409E7915FB2234B84F844F3D14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        float offsetX;
        offsetX = mScrollX - child.mLeft;
        float offsetY;
        offsetY = mScrollY - child.mTop;
        boolean handled;
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_439285855 = (!child.hasIdentityMatrix());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.526 -0400", hash_original_method = "9A4777971E22B675E68E924B82246A95", hash_generated_method = "61EDEF712E663898D83462429D18304A")
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
            boolean var6CC6773C2F32650974B473D1B32A8111_206660738 = (onFilterTouchEventForSecurity(ev));
            {
                int action;
                action = ev.getAction();
                int actionMasked;
                actionMasked = action & MotionEvent.ACTION_MASK;
                {
                    cancelAndClearTouchTargets(ev);
                    resetTouchState();
                } //End block
                boolean intercepted;
                {
                    boolean disallowIntercept;
                    disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
                    {
                        intercepted = onInterceptTouchEvent(ev);
                        ev.setAction(action);
                    } //End block
                    {
                        intercepted = false;
                    } //End block
                } //End block
                {
                    intercepted = true;
                } //End block
                boolean canceled;
                canceled = resetCancelNextUpFlag(this)
                    || actionMasked == MotionEvent.ACTION_CANCEL;
                boolean split;
                split = (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) != 0;
                TouchTarget newTouchTarget;
                newTouchTarget = null;
                boolean alreadyDispatchedToNewTouchTarget;
                alreadyDispatchedToNewTouchTarget = false;
                {
                    {
                        int actionIndex;
                        actionIndex = ev.getActionIndex();
                        int idBitsToAssign;
                        idBitsToAssign = 1 << ev.getPointerId(actionIndex);
                        idBitsToAssign = TouchTarget.ALL_POINTER_IDS;
                        removePointersFromTouchTargets(idBitsToAssign);
                        int childrenCount;
                        childrenCount = mChildrenCount;
                        {
                            View[] children;
                            children = mChildren;
                            float x;
                            x = ev.getX(actionIndex);
                            float y;
                            y = ev.getY(actionIndex);
                            {
                                int i;
                                i = childrenCount - 1;
                                {
                                    View child;
                                    child = children[i];
                                    {
                                        boolean varA03062BDD929C4635E5C5D880ED86080_1822531973 = (!canViewReceivePointerEvents(child)
                                    || !isTransformedTouchPointInView(x, y, child, null));
                                    } //End collapsed parenthetic
                                    newTouchTarget = getTouchTarget(child);
                                    {
                                        newTouchTarget.pointerIdBits |= idBitsToAssign;
                                    } //End block
                                    resetCancelNextUpFlag(child);
                                    {
                                        boolean var4D2A48697299CECF9F8D426E12ED9A2F_1924585743 = (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign));
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
                        TouchTarget next;
                        next = target.next;
                        {
                            handled = true;
                        } //End block
                        {
                            boolean cancelChild;
                            cancelChild = resetCancelNextUpFlag(target.child)
                        || intercepted;
                            {
                                boolean varEA3E26DE3C0C658C465A175EDB865343_674730856 = (dispatchTransformedTouchEvent(ev, cancelChild,
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
                    int actionIndex;
                    actionIndex = ev.getActionIndex();
                    int idBitsToRemove;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.526 -0400", hash_original_method = "1B0EC47DAA405380670E223779C878A6", hash_generated_method = "FB0BEF6A0D13DDEE91DD6A9C23FE556F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        // ---------- Original Method ----------
        //clearTouchTargets();
        //resetCancelNextUpFlag(this);
        //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.527 -0400", hash_original_method = "B31FF6D343B2149E4D841C0A7CD04309", hash_generated_method = "3E8BECC61B73A6C8F8B7880FDA2BDD5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.527 -0400", hash_original_method = "C1060B6E54563910E15717B9621A0CC6", hash_generated_method = "8E13DFFCAD7CF241DE0CEFFDD2C00C53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.527 -0400", hash_original_method = "45B19A2C35386F46FF7561697C2C88B0", hash_generated_method = "EE7CB544D5448446F3162D121D5B02BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelAndClearTouchTargets(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean syntheticEvent;
            syntheticEvent = false;
            {
                long now;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.527 -0400", hash_original_method = "1855BFFFC59D88D1613C9B59C4B43D4C", hash_generated_method = "E88DD9FFF4F152D9A027142ECFAA3563")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.528 -0400", hash_original_method = "70A66C4E824C8984FFB5B6F600FB9D61", hash_generated_method = "2DEACBAD6547BC8E6CE5BCF9F1F85F62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.528 -0400", hash_original_method = "89D343983AE77FFA55E239C56C6BE82A", hash_generated_method = "E9AAEB0366A2D516A7DA6EACF1BFBAB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removePointersFromTouchTargets(int pointerIdBits) {
        dsTaint.addTaint(pointerIdBits);
        TouchTarget predecessor;
        predecessor = null;
        TouchTarget target;
        target = mFirstTouchTarget;
        {
            TouchTarget next;
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

    
        private static boolean canViewReceivePointerEvents(View child) {
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.528 -0400", hash_original_method = "DEC14653C28ED7E684FDD980020C985C", hash_generated_method = "E2B359168B3E425DFC80C25F26AEA77A")
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
            boolean var010B39BB8F6D9891F4618A1B3F847C15_626568457 = (! child.hasIdentityMatrix() && mAttachInfo != null);
            {
                float[] localXY;
                localXY = mAttachInfo.mTmpTransformLocation;
                localXY[0] = localX;
                localXY[1] = localY;
                child.getInverseMatrix().mapPoints(localXY);
                localX = localXY[0];
                localY = localXY[1];
            } //End block
        } //End collapsed parenthetic
        boolean isInView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.529 -0400", hash_original_method = "EAB22EDFF178A3FABE990E65ADB3332F", hash_generated_method = "BF9A68F7047F61C51B300EC1D35680B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(desiredPointerIdBits);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(cancel);
        boolean handled;
        int oldAction;
        oldAction = event.getAction();
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
            {
                handled = super.dispatchTouchEvent(event);
            } //End block
            {
                handled = child.dispatchTouchEvent(event);
            } //End block
            event.setAction(oldAction);
        } //End block
        int oldPointerIdBits;
        oldPointerIdBits = event.getPointerIdBits();
        int newPointerIdBits;
        newPointerIdBits = oldPointerIdBits & desiredPointerIdBits;
        MotionEvent transformedEvent;
        {
            {
                boolean varF3923A48A5FA342E540F86C39C1C463E_287189803 = (child == null || child.hasIdentityMatrix());
                {
                    {
                        handled = super.dispatchTouchEvent(event);
                    } //End block
                    {
                        float offsetX;
                        offsetX = mScrollX - child.mLeft;
                        float offsetY;
                        offsetY = mScrollY - child.mTop;
                        event.offsetLocation(offsetX, offsetY);
                        handled = child.dispatchTouchEvent(event);
                        event.offsetLocation(-offsetX, -offsetY);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            transformedEvent = MotionEvent.obtain(event);
        } //End block
        {
            transformedEvent = event.split(newPointerIdBits);
        } //End block
        {
            handled = super.dispatchTouchEvent(transformedEvent);
        } //End block
        {
            float offsetX;
            offsetX = mScrollX - child.mLeft;
            float offsetY;
            offsetY = mScrollY - child.mTop;
            transformedEvent.offsetLocation(offsetX, offsetY);
            {
                boolean varAB47417F79C7B7F4A08CD74D30CD9C74_825456566 = (! child.hasIdentityMatrix());
                {
                    transformedEvent.transform(child.getInverseMatrix());
                } //End block
            } //End collapsed parenthetic
            handled = child.dispatchTouchEvent(transformedEvent);
        } //End block
        transformedEvent.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.529 -0400", hash_original_method = "2F47BE30FCD7EA97F91B7B6F74081615", hash_generated_method = "53734DD96FAA6B3F3F0F233E14C909F6")
    @DSModeled(DSC.SAFE)
    public void setMotionEventSplittingEnabled(boolean split) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.530 -0400", hash_original_method = "F89425D39488194D486F55EA5F8582C3", hash_generated_method = "6A9EE3FA63D1AC5E69BD642E6ABC9A10")
    @DSModeled(DSC.SAFE)
    public boolean isMotionEventSplittingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.530 -0400", hash_original_method = "1DFD5D86FC853DC6CE8B88AE68ABB735", hash_generated_method = "E4EC6261CB7C44996E5D7984F2D8A3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.530 -0400", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "F330AD500356A4347C1B94B7B8E1EDDF")
    @DSModeled(DSC.SAFE)
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.531 -0400", hash_original_method = "C4273E4BE381C7F0CE1D54BE1CF759CA", hash_generated_method = "F8E883E427BE3ED473B515132750B626")
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
        boolean var47E40A2FCA4828C6DE42D7889D59C941_1175856371 = (super.requestFocus(direction, previouslyFocusedRect));
        //End case FOCUS_BLOCK_DESCENDANTS 
        //Begin case FOCUS_BEFORE_DESCENDANTS 
        {
            boolean took;
            took = super.requestFocus(direction, previouslyFocusedRect);
            {
                Object var3A5A180257AE9AD15DBCD18319037603_1191220098 = (onRequestFocusInDescendants(direction, previouslyFocusedRect));
            } //End flattened ternary
        } //End block
        //End case FOCUS_BEFORE_DESCENDANTS 
        //Begin case FOCUS_AFTER_DESCENDANTS 
        {
            boolean took;
            took = onRequestFocusInDescendants(direction, previouslyFocusedRect);
            {
                Object var7EEFFE453EE8B06336FEADC34AE77D1B_471673747 = (super.requestFocus(direction, previouslyFocusedRect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.531 -0400", hash_original_method = "47C4A34C6E68C9FD22237D5A1759ABE2", hash_generated_method = "28E6F511AEC0CA05BBFD4042AB33BAEB")
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
        View[] children;
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
                        boolean var86823278073885F35F11C1598EACBFE2_870406201 = (child.requestFocus(direction, previouslyFocusedRect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.531 -0400", hash_original_method = "C10088C0D1BE61F270AE8158B60FC677", hash_generated_method = "57EFD9E87569C626A9F08B1C2D773061")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.532 -0400", hash_original_method = "F13891122244193473AAFE5583088FC4", hash_generated_method = "BF5826173881135B413B26D368A082C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.532 -0400", hash_original_method = "8739A5508C26F7DDD3FFEBEE4CD95BC5", hash_generated_method = "B8025DE60F41C12A07FBE42F86900B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(info.dsTaint);
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.532 -0400", hash_original_method = "1EE087DB6D320A1AB0B1F5665AE9972D", hash_generated_method = "C61FDD8D02C52F3262CA24C8B2468EE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.533 -0400", hash_original_method = "D1F5A3B1D56655AA52CA4B460A89AF1D", hash_generated_method = "6FA54B1111B4146DBE516EAB0A3F61D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.533 -0400", hash_original_method = "C93583B1C6CD82E84CFB16E69C063BD6", hash_generated_method = "91DD6CB93750C5E045BCEA4BDE59D520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
        {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        } //End block
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.533 -0400", hash_original_method = "3A8CBF91275A500D30CEFAD8D7209E14", hash_generated_method = "28B0EFA046944EAE2B82CF68CDE7425A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.533 -0400", hash_original_method = "0EF6BC3550040660942BB4435DC1568A", hash_generated_method = "77CC74DF4462A9E76E43B572CF6E21B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchSaveInstanceState(container);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.534 -0400", hash_original_method = "38DCBB8C3886F11C25C07FC151CB762B", hash_generated_method = "7BE8E1E0AA11A230AD57B50DB43AB644")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.534 -0400", hash_original_method = "79E9ACE6A349ACE584637F3A31A0E869", hash_generated_method = "AD5915C245259BF2FAFAD4472C7FCED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchRestoreInstanceState(container);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.534 -0400", hash_original_method = "85A5428D5025B10E5C75238A5C358628", hash_generated_method = "CDD4048A8AA07267AF79684D509C6B36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.534 -0400", hash_original_method = "673779FD01170D0D857F4CAC6D3A5472", hash_generated_method = "2094D65B71D910C5FC23F08B6D5AA142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            View[] children;
            children = mChildren;
            int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.535 -0400", hash_original_method = "C6BD5BCC8D99F50AFC626E34071E2FAF", hash_generated_method = "DA4043F4D314EAC719DFE72472E0BE07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationStart();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            boolean buildCache;
            buildCache = !isHardwareAccelerated();
            {
                int i;
                i = 0;
                {
                    View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.535 -0400", hash_original_method = "D937B1A7AD9A1EFB7CAF69E9B3174965", hash_generated_method = "35CEF9D8DFD04C9C6DD4F44A075F19A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.535 -0400", hash_original_method = "8B8B5866E6978A8C0D1BC17BB86DCAFE", hash_generated_method = "8F5D6F59FFC36C53DA5C41E2137B6031")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.536 -0400", hash_original_method = "B43A05A63ADF740A4A15894A451E95C0", hash_generated_method = "65D37490C015BFBE79942DCDC9B1527F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        int flags;
        flags = mGroupFlags;
        {
            boolean var07BB33E4D87E2B5D2A8FEE502EA9E8CD_173103972 = ((flags & FLAG_RUN_ANIMATION) != 0 && canAnimate());
            {
                boolean cache;
                cache = (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
                boolean buildCache;
                buildCache = !isHardwareAccelerated();
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = children[i];
                        {
                            LayoutParams params;
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
                LayoutAnimationController controller;
                controller = mLayoutAnimationController;
                {
                    boolean varE5D19A1FB2EF5ECD65C0B52011051B10_1454685192 = (controller.willOverlap());
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
        boolean clipToPadding;
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
        long drawingTime;
        drawingTime = getDrawingTime();
        {
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_883274888 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
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
                    View child;
                    child = children[getChildDrawingOrder(count, i)];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_509947727 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            int disappearingCount;
            disappearingCount = disappearingChildren.size() - 1;
            {
                int i;
                i = disappearingCount;
                {
                    View child;
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
            boolean var76A6DBFAA8B517B1E30D0F77E8BBAB75_989678313 = ((flags & FLAG_ANIMATION_DONE) == 0 && (flags & FLAG_NOTIFY_ANIMATION_LISTENER) == 0 &&
                mLayoutAnimationController.isDone() && !more);
            {
                mGroupFlags |= FLAG_NOTIFY_ANIMATION_LISTENER;
                Runnable end;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.537 -0400", hash_original_method = "314AC469B646186EB8E30D4AB123CD56", hash_generated_method = "92E88BE3564E96E73C53A584E214D984")
    @DSModeled(DSC.SAFE)
    protected int getChildDrawingOrder(int childCount, int i) {
        dsTaint.addTaint(childCount);
        dsTaint.addTaint(i);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.538 -0400", hash_original_method = "396DFE394BEDDAB737694626CE3DE3EF", hash_generated_method = "99F89107A112AB4239272675542B368B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyAnimationListener() {
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        {
            Runnable end;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.539 -0400", hash_original_method = "F4EA27B0452D996E61B8467125C95A50", hash_generated_method = "441B8275009CF81B3905E5902CEC15F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchGetDisplayList() {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    boolean var735C012AD3EAE6449E3DE234B2B9D1C4_377684374 = (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.542 -0400", hash_original_method = "A5CF70DDE358EAA9D1CA892FF372BD55", hash_generated_method = "A8668856874EBC7A87C34C24D41F7A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(drawingTime);
        boolean more;
        more = false;
        int cl;
        cl = child.mLeft;
        int ct;
        ct = child.mTop;
        int cr;
        cr = child.mRight;
        int cb;
        cb = child.mBottom;
        boolean childHasIdentityMatrix;
        childHasIdentityMatrix = child.hasIdentityMatrix();
        int flags;
        flags = mGroupFlags;
        {
            mChildTransformation.clear();
            mGroupFlags &= ~FLAG_CLEAR_TRANSFORMATION;
        } //End block
        Transformation transformToApply;
        transformToApply = null;
        Transformation invalidationTransform;
        Animation a;
        a = child.getAnimation();
        boolean concatMatrix;
        concatMatrix = false;
        boolean scalingRequired;
        scalingRequired = false;
        boolean caching;
        int layerType;
        layerType = child.getLayerType();
        layerType = LAYER_TYPE_NONE;
        boolean hardwareAccelerated;
        hardwareAccelerated = canvas.isHardwareAccelerated();
        {
            caching = true;
            scalingRequired = mAttachInfo.mScalingRequired;
        } //End block
        {
            caching = (layerType != LAYER_TYPE_NONE) || hardwareAccelerated;
        } //End block
        {
            boolean initialized;
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
                    boolean var489AF36514F0C5F8ABF92D9ED1EEF69B_2030236902 = (!a.willChangeBounds());
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
                        RectF region;
                        region = mInvalidateRegion;
                        a.getInvalidateRegion(0, 0, cr - cl, cb - ct, region, invalidationTransform);
                        mPrivateFlags |= DRAW_ANIMATION;
                        int left;
                        left = cl + (int) region.left;
                        int top;
                        top = ct + (int) region.top;
                        invalidate(left, top, left + (int) (region.width() + .5f),
                            top + (int) (region.height() + .5f));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean hasTransform;
            hasTransform = getChildStaticTransformation(child, mChildTransformation);
            {
                int transformType;
                transformType = mChildTransformation.getTransformationType();
                transformToApply = transformType != Transformation.TYPE_IDENTITY ?
                        mChildTransformation : null;
                concatMatrix = (transformType & Transformation.TYPE_MATRIX) != 0;
            } //End block
        } //End block
        concatMatrix |= !childHasIdentityMatrix;
        child.mPrivateFlags |= DRAWN;
        {
            boolean var04A9779EE766FABCC1352F467BA0AB22_1227935183 = (!concatMatrix && canvas.quickReject(cl, ct, cr, cb, Canvas.EdgeType.BW) &&
                (child.mPrivateFlags & DRAW_ANIMATION) == 0);
        } //End collapsed parenthetic
        {
            child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
            child.mPrivateFlags &= ~INVALIDATED;
        } //End block
        child.computeScroll();
        int sx;
        sx = child.mScrollX;
        int sy;
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
        boolean hasNoCache;
        hasNoCache = cache == null || hasDisplayList;
        boolean offsetForScroll;
        offsetForScroll = cache == null && !hasDisplayList &&
                layerType != LAYER_TYPE_HARDWARE;
        int restoreTo;
        restoreTo = canvas.save();
        {
            canvas.translate(cl - sx, ct - sy);
        } //End block
        {
            canvas.translate(cl, ct);
            {
                float scale;
                scale = 1.0f / mAttachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
        } //End block
        float alpha;
        alpha = child.getAlpha();
        {
            boolean var934B3E69D3ACD833C0B88FE85A1125E9_875923656 = (transformToApply != null || alpha < 1.0f || !child.hasIdentityMatrix());
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
                        int multipliedAlpha;
                        multipliedAlpha = (int) (255 * alpha);
                        {
                            boolean varFF146FCD683FC819B246FAE0328227BA_2102998752 = (!child.onSetAlpha(multipliedAlpha));
                            {
                                int layerFlags;
                                layerFlags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
                                {
                                    layerFlags |= Canvas.CLIP_TO_LAYER_SAVE_FLAG;
                                } //End block
                                {
                                    int scrollX;
                                    scrollX = 0;
                                    scrollX = sx;
                                    int scrollY;
                                    scrollY = 0;
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
                boolean var9C584955B3CFEF7798B020C1B8079C6D_623007937 = (!displayList.isValid());
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
                HardwareLayer layer;
                layer = child.getHardwareLayer();
                {
                    boolean varF47BB7BA46927B23DD4F75E227100F6C_219223118 = (layer != null && layer.isValid());
                    {
                        child.mLayerPaint.setAlpha((int) (alpha * 255));
                        ((HardwareCanvas) canvas).drawHardwareLayer(layer, 0, 0, child.mLayerPaint);
                        layerRendered = true;
                    } //End block
                    {
                        int scrollX;
                        scrollX = 0;
                        scrollX = sx;
                        int scrollY;
                        scrollY = 0;
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
                boolean varAF4EC4CBE7F4BE862D45CC273E5600AE_50228270 = (!hardwareAccelerated && !a.getFillAfter());
                {
                    child.onSetAlpha(255);
                } //End block
            } //End collapsed parenthetic
            finishAnimatingView(child, a);
        } //End block
        {
            invalidate(true);
            {
                boolean var14BEB88AF6F19C239671B73A03DA27C1_693269575 = (a.hasAlpha() && (child.mPrivateFlags & ALPHA_SET) == ALPHA_SET);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.543 -0400", hash_original_method = "4095F0AE1BAE27A3A14B16FD7C3431AE", hash_generated_method = "FF20CE2A0CE020B71EF55B1602E11AB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.543 -0400", hash_original_method = "1DB85DBA1331DEE146504B0E70B65BE5", hash_generated_method = "840D9B9460872436BA3F2B25D4735F54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClipChildren(boolean clipChildren) {
        dsTaint.addTaint(clipChildren);
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.543 -0400", hash_original_method = "863AF54978AA2727D0D7509C22DC212D", hash_generated_method = "BF6F58E226B32789EC09E604F89435CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setClipToPadding(boolean clipToPadding) {
        dsTaint.addTaint(clipToPadding);
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.544 -0400", hash_original_method = "8ABEEBF76C5626CBEA0073E7871E08E9", hash_generated_method = "A877B5462A0257A4A5EBA469219777D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchSetSelected(boolean selected) {
        dsTaint.addTaint(selected);
        View[] children;
        children = mChildren;
        int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.544 -0400", hash_original_method = "2F91B8D19CDC8A9E83F3387815EB4D3F", hash_generated_method = "C8F636C81F59045F2E20884CB57179F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispatchSetActivated(boolean activated) {
        dsTaint.addTaint(activated);
        View[] children;
        children = mChildren;
        int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.544 -0400", hash_original_method = "741F0E8D45382BBF6BA56C96532A94D8", hash_generated_method = "5D93E07968889CAEBEDE39D6998FC2E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        View[] children;
        children = mChildren;
        int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.544 -0400", hash_original_method = "BD73AAD871B8740D29315EE305D10F4B", hash_generated_method = "4881998E6BC045A877129D7408902DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setStaticTransformationsEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.544 -0400", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "4196CA1C161D7992092A5E6A974D539C")
    @DSModeled(DSC.SAFE)
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(t.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.545 -0400", hash_original_method = "8C56D4BEA5FE426CA6EBD73A64039E70", hash_generated_method = "803FEBA74CD8F093D06E7F56F937AAEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewTraversal(int id) {
        dsTaint.addTaint(id);
        View[] where;
        where = mChildren;
        int len;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.545 -0400", hash_original_method = "D087F3465F923453754E64A11DB6BED1", hash_generated_method = "862A19AA91CB65A3EC82A4B4A1D6684A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        dsTaint.addTaint(tag.dsTaint);
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_1927179158 = (tag != null && tag.equals(mTag));
        } //End collapsed parenthetic
        View[] where;
        where = mChildren;
        int len;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.545 -0400", hash_original_method = "0EC5116F4AD2AA9CFA72F9149C3A9529", hash_generated_method = "36EDEEB322C5EEC22FBDE062F00622DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        dsTaint.addTaint(childToSkip.dsTaint);
        dsTaint.addTaint(predicate.dsTaint);
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_2143333151 = (predicate.apply(this));
        } //End collapsed parenthetic
        View[] where;
        where = mChildren;
        int len;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.545 -0400", hash_original_method = "CEC5DF3412108DC355B81A234F778717", hash_generated_method = "D63E2E04A0554BF1683F0834F2D9A25A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addView(View child) {
        dsTaint.addTaint(child.dsTaint);
        addView(child, -1);
        // ---------- Original Method ----------
        //addView(child, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.546 -0400", hash_original_method = "052049806EFDCB28F8B1780970FB4D61", hash_generated_method = "2F7C2AEBDD64367E930B860EDB48B0EF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.546 -0400", hash_original_method = "04069655751E8F150919B197DB2D0EF4", hash_generated_method = "2D51C8F66EA9CF140F7A2ECA4D352E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addView(View child, int width, int height) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        LayoutParams params;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.546 -0400", hash_original_method = "CAABD1DBDF747222034CC373BA6381CC", hash_generated_method = "BD1CA327DD7BBA94016FEB6AFE7AEEA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addView(View child, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        addView(child, -1, params);
        // ---------- Original Method ----------
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.546 -0400", hash_original_method = "BD78A36687CEEF62B7E0786E86501A2F", hash_generated_method = "3970E0FD9D864A2CB8656D0CD74E43BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.546 -0400", hash_original_method = "8137D76BAD6EAD8C2AFF7B0DC7EC38EA", hash_generated_method = "BB50D120AEDFF0ED8D5D28EFC4514065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1135210569 = (!checkLayoutParams(params));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8034A81DF8A049A1DEC5A101D1129C23_792445201 = (view.mParent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Given view not a child of " + this);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.547 -0400", hash_original_method = "C2EE5015ED0F9B04763A6A0F4C905EDB", hash_generated_method = "328C0024019FD0403B016657A6BF1BB9")
    @DSModeled(DSC.SAFE)
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return  p != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.547 -0400", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "EB5B2132426917235B4122BFFDF6C047")
    @DSModeled(DSC.SAFE)
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnHierarchyChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.547 -0400", hash_original_method = "7C8375F0DCFCC6770307465540C43F29", hash_generated_method = "4257393B08721C96EB964E6938C97478")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.547 -0400", hash_original_method = "2969A02DF6E73517C4A5610098A20201", hash_generated_method = "873E8B7D938601F95AC4D4F75CB20078")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.547 -0400", hash_original_method = "4EC56F492B64387EC5CDEE559C919DD8", hash_generated_method = "F63986E5E2DC5DAB1DF70A64FD6C6BE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(params.dsTaint);
        boolean varC93AA663A5550227DF73E011E019C03E_714979901 = (addViewInLayout(child, index, params, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addViewInLayout(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.548 -0400", hash_original_method = "621D5EA894CECBBA3C5FE5D7159CF1D3", hash_generated_method = "8D607EA2D6AF3059D2C87AD6E9E60712")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.548 -0400", hash_original_method = "156A75B155CF89ADA3C99A75E911D53A", hash_generated_method = "8D560BFF7ED92E59A9EEE9A53935CBE4")
    @DSModeled(DSC.SAFE)
    protected void cleanupLayoutState(View child) {
        dsTaint.addTaint(child.dsTaint);
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
        // ---------- Original Method ----------
        //child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.548 -0400", hash_original_method = "4623983FE5D2926EED9F934007E41D76", hash_generated_method = "727A60B84DA58B0733963DA542FDB246")
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
            boolean varA3364C4A63F6A263A8814AE455A29C59_287846389 = (child.getParent() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The specified child already has a parent. " +
                    "You must call removeView() on the child's parent first.");
            } //End block
        } //End collapsed parenthetic
        {
            mTransition.addChild(this, child);
        } //End block
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_319266884 = (!checkLayoutParams(params));
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
            boolean varDDA55DF480817D6313066967525E9186_531302793 = (child.hasFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.549 -0400", hash_original_method = "3DC226B361362F1A66E4DF7340FD46AC", hash_generated_method = "FE0E21080DADA1AF85AF0387C391AF07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addInArray(View child, int index) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        int size;
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
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.549 -0400", hash_original_method = "666B846103F98929B6C3984DF363A458", hash_generated_method = "E34D9E0A221EC2DDA24889C63F4533A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFromArray(int index) {
        dsTaint.addTaint(index);
        View[] children;
        children = mChildren;
        {
            boolean varFD7C05E4772169FABFE9822CC2FF40CC_115320220 = (!(mTransitioningViews != null && mTransitioningViews.contains(children[index])));
            {
                children[index].mParent = null;
            } //End block
        } //End collapsed parenthetic
        int count;
        count = mChildrenCount;
        {
            children[--mChildrenCount] = null;
        } //End block
        {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.550 -0400", hash_original_method = "7377DC4CCC7ACF33951FFC91A9C19242", hash_generated_method = "2EA2A4881C415343C97F05297696137E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFromArray(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        View[] children;
        children = mChildren;
        int childrenCount;
        childrenCount = mChildrenCount;
        start = Math.max(0, start);
        int end;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.550 -0400", hash_original_method = "0C13B6720EDD2CD731BF86C88080EC0A", hash_generated_method = "37DF0F8217AAC36BFBDCEBEA9C393860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void bindLayoutAnimation(View child) {
        dsTaint.addTaint(child.dsTaint);
        Animation a;
        a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
        // ---------- Original Method ----------
        //Animation a = mLayoutAnimationController.getAnimationForView(child);
        //child.setAnimation(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.550 -0400", hash_original_method = "53A696BC845D59D084861C4C39417C50", hash_generated_method = "B6FC74B1F414FAEC46F4AAB590F1F42F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.551 -0400", hash_original_method = "D47B7EA927C9C6E9F8463F22FA8E7751", hash_generated_method = "525F1F2611F5749BA306C70432DA462F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.551 -0400", hash_original_method = "9C0189C4A93DBFF4CA9135E979534627", hash_generated_method = "B39C1101C6D74B29D78B04B61950A626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeViewInLayout(View view) {
        dsTaint.addTaint(view.dsTaint);
        removeViewInternal(view);
        // ---------- Original Method ----------
        //removeViewInternal(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.551 -0400", hash_original_method = "CCED8E1F5C1435811C77FC8E195AA3ED", hash_generated_method = "CD4122AF1650D02F5265FCA707364349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeViewsInLayout(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        removeViewsInternal(start, count);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.551 -0400", hash_original_method = "C7B982345E14E4BA654D9B702D09B782", hash_generated_method = "12A1DF7108A566BE2EB79ADAA6E23A4D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.551 -0400", hash_original_method = "295E3CFFAAE54DAD76DF23980004A9FB", hash_generated_method = "53FF59BB4B8F678699F1BE3B904FFF90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.552 -0400", hash_original_method = "A8C7AA662547BF9F482FBD0CAAADED6D", hash_generated_method = "FF80CD22D5006FF9D2A61EE155DDEA69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeViewInternal(View view) {
        dsTaint.addTaint(view.dsTaint);
        int index;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.552 -0400", hash_original_method = "5145400D128FAA852B030ECA7E0E5CC6", hash_generated_method = "69437BD47676FEB5E68A93AB52D05A0B")
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
            boolean var74C8DDDF999D66AA3EB9771E0CD6D718_1368451976 = (view.getAnimation() != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.552 -0400", hash_original_method = "6CC26F3EB4840902E7233D2C3E46A07B", hash_generated_method = "4F843515B2F71B683517355579204B7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.552 -0400", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "0ABA0B75F8AD8BF1438D68CC5E6634D1")
    @DSModeled(DSC.SAFE)
    public LayoutTransition getLayoutTransition() {
        return (LayoutTransition)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.553 -0400", hash_original_method = "F40E247B6ABF822EB65FF56F80411035", hash_generated_method = "7C6FC4625A990CE7E89BEAFB7305F3A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeViewsInternal(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        View focused;
        focused = mFocused;
        boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        View[] children;
        children = mChildren;
        int end;
        end = start + count;
        {
            int i;
            i = start;
            {
                View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var771BCD00CE5FBF80B4F7B15D3C6EBC5E_1883094688 = (view.getAnimation() != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.553 -0400", hash_original_method = "C167CC912DB398153B3FBDE6D6503FBD", hash_generated_method = "251074A9D0FEFE564BF870888680CE2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeAllViewsInLayout();
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.553 -0400", hash_original_method = "8DFE71C1BEB57BA28106B31D5772632E", hash_generated_method = "FC8F5C9C987515AD19CC38FE74735958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllViewsInLayout() {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        mChildrenCount = 0;
        View focused;
        focused = mFocused;
        boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        needGlobalAttributesUpdate(false);
        {
            int i;
            i = count - 1;
            {
                View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var25706AD565CAAA05294A1680813DB393_1045791734 = (view.getAnimation() != null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.554 -0400", hash_original_method = "80D629C332B0E93DD7A33AD3708E672D", hash_generated_method = "40A98D80000FEEA7E2148F12E63C8E31")
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
            boolean varC784B3814A6616C601A69CC572D538AE_618815044 = ((animate && child.getAnimation() != null) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.554 -0400", hash_original_method = "8472A11DDB1452C7DB4257A960216E78", hash_generated_method = "6AB1E32207321B496D759CADB0CFB67D")
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
            boolean varDDA55DF480817D6313066967525E9186_188258280 = (child.hasFocus());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.554 -0400", hash_original_method = "635C6E5D7FA712D6D6BC98C85EEAD0AE", hash_generated_method = "A7B7FBC105B54150256CC836E81F06E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void detachViewFromParent(View child) {
        dsTaint.addTaint(child.dsTaint);
        removeFromArray(indexOfChild(child));
        // ---------- Original Method ----------
        //removeFromArray(indexOfChild(child));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.554 -0400", hash_original_method = "6B327774A5D40749E682A0800D955866", hash_generated_method = "024A77EA7480A83D04A49868E231D859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void detachViewFromParent(int index) {
        dsTaint.addTaint(index);
        removeFromArray(index);
        // ---------- Original Method ----------
        //removeFromArray(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.555 -0400", hash_original_method = "9419943F60DE9471E3CB31EABE2947F0", hash_generated_method = "EBDFF61C94271257FD6175493FC5F2D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void detachViewsFromParent(int start, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        removeFromArray(start, count);
        // ---------- Original Method ----------
        //removeFromArray(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.555 -0400", hash_original_method = "FD3027623927AF219788395D1D83AA06", hash_generated_method = "05683DB8C013E2C29E726864460B3AF0")
    @DSModeled(DSC.SAFE)
    protected void detachAllViewsFromParent() {
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.556 -0400", hash_original_method = "063B7BC13F01F04711683C921C10A0CE", hash_generated_method = "E921811F231D9BE5D397DF67A37BA6AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void invalidateChild(View child, final Rect dirty) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD);
        } //End block
        ViewParent parent;
        parent = this;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            boolean drawAnimation;
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
                                boolean var3DA0F6F5F2B1801DCC6F6E6927312986_2144640601 = (view.getParent() instanceof View);
                                {
                                    View grandParent;
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
                boolean isOpaque;
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
                int[] location;
                location = attachInfo.mInvalidateChildLocation;
                location[CHILD_LEFT_INDEX] = child.mLeft;
                location[CHILD_TOP_INDEX] = child.mTop;
                Matrix childMatrix;
                childMatrix = child.getMatrix();
                {
                    boolean varCFD88FFD44E20CB7F1D8D4D2556D2E8C_1604648567 = (!childMatrix.isIdentity());
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
                            boolean varC5230D1238FBEF65B7498AB998C6F0FA_1358404541 = (view.mLayerType != LAYER_TYPE_NONE &&
                                view.getParent() instanceof View);
                            {
                                View grandParent;
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
                            boolean var760C0A78BE5FDB84740BECBCA8BA8947_1371590677 = ((view.mViewFlags & FADING_EDGE_MASK) != 0 &&
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
                            boolean var8D882C39D7302E18C8FB45549919991D_380051073 = (!m.isIdentity());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.557 -0400", hash_original_method = "DC318C38544A42EB44071D5AE866F2AB", hash_generated_method = "BA74A5AAF9DD633BFDACC43813AAC5B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        dsTaint.addTaint(location[0]);
        dsTaint.addTaint(dirty.dsTaint);
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD_IN_PARENT);
        } //End block
        {
            {
                dirty.offset(location[CHILD_LEFT_INDEX] - mScrollX,
                        location[CHILD_TOP_INDEX] - mScrollY);
                int left;
                left = mLeft;
                int top;
                top = mTop;
                {
                    boolean var1FD08A580F456E7C6E817E871B882F95_1386828135 = ((mGroupFlags & FLAG_CLIP_CHILDREN) != FLAG_CLIP_CHILDREN ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.557 -0400", hash_original_method = "50571ED06CB8BFD92222BA4CF106E503", hash_generated_method = "5BB0629046B241405D67049AFD5B94C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.557 -0400", hash_original_method = "237D31B5A43A7733C9219A4289DB54A9", hash_generated_method = "DBBBAD93690B3FE418B7F963F5576377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(rect.dsTaint);
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.558 -0400", hash_original_method = "D3722A63E3ED25EA76952CBDD9156CED", hash_generated_method = "A5D2FC024C85C33CEE62364EFC2A5F8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds) {
        dsTaint.addTaint(offsetFromChildToParent);
        dsTaint.addTaint(descendant.dsTaint);
        dsTaint.addTaint(clipToBounds);
        dsTaint.addTaint(rect.dsTaint);
        {
            boolean var9866E6F62DFB6148F201138746ED5750_891029063 = (descendant == this);
        } //End collapsed parenthetic
        ViewParent theParent;
        theParent = descendant.mParent;
        {
            boolean varDD69D58089B270F3D4B28124BF640FA8_967168747 = ((theParent != null)
                && (theParent instanceof View)
                && (theParent != this));
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
        } //End collapsed parenthetic
        {
            boolean var643C98140D61F4DFE43564E3D036760F_752168982 = (theParent == this);
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
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("parameter must be a descendant of this view");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.558 -0400", hash_original_method = "7A1B0B3F062F0EF6FC199DD0C643A517", hash_generated_method = "40DB52D1CA041A6E8F4AEE05C039D904")
    @DSModeled(DSC.SAFE)
    public void offsetChildrenTopAndBottom(int offset) {
        dsTaint.addTaint(offset);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View v;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.600 -0400", hash_original_method = "5C31858D2677D0E5DD9194B8EDADFECC", hash_generated_method = "D3817B24E9751CBDB3ED938CD6D9DFD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(offset.dsTaint);
        RectF rect;
        rect = mAttachInfo.mTmpTransformRect;
        rect = new RectF();
        rect.set(r);
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_689840455 = (!child.hasIdentityMatrix());
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
                boolean var4909A00AAC5857DB675C7058066C1F45_619621035 = (!child.hasIdentityMatrix());
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
            boolean var08BB32A43948A9AA882E62C649D0F6D4_1186667153 = (rect.intersect(0, 0, mRight - mLeft, mBottom - mTop));
            {
                r.set((int) (rect.left + 0.5f), (int) (rect.top + 0.5f),
                    (int) (rect.right + 0.5f), (int) (rect.bottom + 0.5f));
                boolean var815D42ADB6C99D0ABB4FA68231A12D7A_1712810971 = (mParent.getChildVisibleRect(this, r, offset));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.601 -0400", hash_original_method = "89A2794B62BBEA7754F18155FA121F08", hash_generated_method = "1E51ED3E374EAC00C93E6BB4CBFC7E94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void layout(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        {
            boolean varFB56D3D497D368E0550C6286169A3692_227633891 = (mTransition == null || !mTransition.isChangingLayout());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.602 -0400", hash_original_method = "74094E4283ACC987205CEBE8397B866C", hash_generated_method = "2B914D257EDB1CF134415A8D64C7E8FE")
    @DSModeled(DSC.SAFE)
    protected boolean canAnimate() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayoutAnimationController != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.603 -0400", hash_original_method = "99174EE5664A8F981F50635AC5D4970E", hash_generated_method = "0ECC36E8F4901A7D90656B097B2D8AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.603 -0400", hash_original_method = "06C0C7BBCCF19FA4957838E03EE331C8", hash_generated_method = "79A372FB31048C6468EBF3B2058D214E")
    @DSModeled(DSC.SAFE)
    public void scheduleLayoutAnimation() {
        mGroupFlags |= FLAG_RUN_ANIMATION;
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_RUN_ANIMATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.603 -0400", hash_original_method = "76D54B6C61296EF04870B520A219B087", hash_generated_method = "C185E5505846FE16B1221103A2A59E75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.603 -0400", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "8AD0B0AC00BEDF83237C9E845E009F4F")
    @DSModeled(DSC.SAFE)
    public LayoutAnimationController getLayoutAnimation() {
        return (LayoutAnimationController)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayoutAnimationController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "91C32769C37DCC6F9F6B4528E4A57D15", hash_generated_method = "EB35237E7F4AA2F5A22A40424AAA09EB")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "DD639E9259A75AF16A9190E263F8776F", hash_generated_method = "09F3CE996503273A73729EF5D54F0131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnimationCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "B9ACD8DAE870BEF4EFBF779A704F6EA0", hash_generated_method = "DEB70B4667DB5B03837B1FD24513EBA3")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "ACB4830CB4940DD4B9F47560853379A8", hash_generated_method = "AB86993A26178AB4FE12630B9CFF534F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        dsTaint.addTaint(always);
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "4364C0D051F178DD0E8ADCB73D61750A", hash_generated_method = "5B0CAE87D22208BD6FF0569C32164F85")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.604 -0400", hash_original_method = "2230D982A122AD23513779DE65F20855", hash_generated_method = "871F6E39C889167E6908C283A21F75D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.605 -0400", hash_original_method = "5166D8925764E3FCE51BAB9F8B82BB83", hash_generated_method = "AE51580E1E9B83BA52A47593028D3F6B")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawingOrderEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.605 -0400", hash_original_method = "206BAF2A94AC84475BA4253F279E8423", hash_generated_method = "0764C9EAF23406FC0D8369EDB5621665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.605 -0400", hash_original_method = "DAA9F10BF0EA997E391E78BA1DF6ABEE", hash_generated_method = "24AAF5F8993AAFE2F1F352FBD8DDEBF7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.605 -0400", hash_original_method = "944A8E363FECEAC5FA18188B2A82EEA9", hash_generated_method = "8B12DE25C0456CD97B6D9BB8852D5C0E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.605 -0400", hash_original_method = "E1A853399F91DFB847E7C25FCC355E2E", hash_generated_method = "78D7938085A9581223E970F8ECAEC5F0")
    @DSModeled(DSC.SAFE)
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        dsTaint.addTaint(drawingCacheToKeep);
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
        // ---------- Original Method ----------
        //mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.606 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "E8494672259FAED8E12D22CA8C6EA409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams var1608545582BA25B7A0B072469C4B0958_932249110 = (new LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.606 -0400", hash_original_method = "732F05B425275E63BD87B7814AB2A9CD", hash_generated_method = "8C1FBB3980E821FD2E6260A8AAA1AE3F")
    @DSModeled(DSC.SAFE)
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.606 -0400", hash_original_method = "378AC11079CE6884A850F340A9660EF3", hash_generated_method = "03ACFB7853035447A9A12F1BDE89D4B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams var02344A0C0F12A93F9A31D474E79B2A07_1618515869 = (new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.606 -0400", hash_original_method = "4EE7CD38DD5C6A89B0A06AD3B67D59FC", hash_generated_method = "FDC7FF1EECB51BA3DFC3C0159DD058CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean dispatchConsistencyCheck(int consistency) {
        dsTaint.addTaint(consistency);
        boolean result;
        result = super.dispatchConsistencyCheck(consistency);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                {
                    boolean var701606913081A4231078EDA1C31F9544_2052929071 = (!children[i].dispatchConsistencyCheck(consistency));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.607 -0400", hash_original_method = "9938C74D91901C257958D174411BCA62", hash_generated_method = "D3E53770F4016D1DCD5C37D45F2BC778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consistency);
        boolean result;
        result = super.onConsistencyCheck(consistency);
        boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        boolean checkDrawing;
        checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varC3E3292263C4B7F2461A3F2B810768A5_1307963184 = (children[i].getParent() != this);
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
                ViewParent parent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.607 -0400", hash_original_method = "9209AC82FBA5456C7517DF8735B229C2", hash_generated_method = "A67AEE32A36690E996A3B4FDDD67092B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.607 -0400", hash_original_method = "A3819F4FC73AAB74FEBE19CD2546FBCA", hash_generated_method = "AB200B2827892E6407F4FF1C54424241")
    @DSModeled(DSC.SAFE)
    public int indexOfChild(View child) {
        dsTaint.addTaint(child.dsTaint);
        int count;
        count = mChildrenCount;
        View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.607 -0400", hash_original_method = "7030903D0CFC3D101159E57E177A8D82", hash_generated_method = "229C678CEFA5FCF61B6F981B57ECD044")
    @DSModeled(DSC.SAFE)
    public int getChildCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.608 -0400", hash_original_method = "DC55A008910617641F1AE978A0E895D4", hash_generated_method = "4450805E9E5DC4C0D8604C944C3AB015")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.608 -0400", hash_original_method = "542392FF7FE475C27FCC004AAEE4D21F", hash_generated_method = "75F5084733869BB19CEA5A532AB70C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int size;
        size = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.608 -0400", hash_original_method = "9EDA680ED83105527C80B1E780D1BEC7", hash_generated_method = "ADD40F08361A26DB9939545C50143258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        LayoutParams lp;
        lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        int childHeightMeasureSpec;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.608 -0400", hash_original_method = "DF0652AA16CC35609E8DBABD1504358F", hash_generated_method = "BF311673F2C728690F4C1C4DC2FC7010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(widthUsed);
        dsTaint.addTaint(parentHeightMeasureSpec);
        dsTaint.addTaint(parentWidthMeasureSpec);
        dsTaint.addTaint(heightUsed);
        MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        int childHeightMeasureSpec;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.609 -0400", hash_original_method = "92C99C7B01BA8D70EFEE87F46C0710D1", hash_generated_method = "20F827DDB021B8B88FD693FB75190E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearDisappearingChildren() {
        {
            mDisappearingChildren.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mDisappearingChildren != null) {
            //mDisappearingChildren.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.609 -0400", hash_original_method = "EFF49544FBF4F5023D4E3259D68E48A6", hash_generated_method = "790E3BAA862362077CE1F4BB84A12A71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.609 -0400", hash_original_method = "F02FCA79EB2173CD96A012235B90F902", hash_generated_method = "406C67FED4CAB8F7BD79202C8F19D47D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishAnimatingView(final View view, Animation animation) {
        dsTaint.addTaint(animation.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        ArrayList<View> disappearingChildren;
        disappearingChildren = mDisappearingChildren;
        {
            {
                boolean var469F1AC6EE958AE18E6E98146553974E_1731484601 = (disappearingChildren.contains(view));
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
            boolean var43425F3101AF26F025C7208DDDA7464F_674830081 = (animation != null && !animation.getFillAfter());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.610 -0400", hash_original_method = "663B00ABF4B2F32B3DAAC91DDA64BE32", hash_generated_method = "BAF709B7AEAD98E07F0FE73C6786E0E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isViewTransitioning(View view) {
        dsTaint.addTaint(view.dsTaint);
        boolean var2C744AD4F2EA7A3D608A882D8C3D4FED_1794935240 = ((mTransitioningViews != null && mTransitioningViews.contains(view)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.610 -0400", hash_original_method = "3DD17A0BC43336D376B4C3E60ACB3106", hash_generated_method = "4948493068DFF3C432DCAAC9C08582B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startViewTransition(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            boolean varA2172F77206C7C024C24C289D1254F67_541636673 = (view.mParent == this);
            {
                {
                    mTransitioningViews = new ArrayList<View>();
                } //End block
                mTransitioningViews.add(view);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (view.mParent == this) {
            //if (mTransitioningViews == null) {
                //mTransitioningViews = new ArrayList<View>();
            //}
            //mTransitioningViews.add(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.610 -0400", hash_original_method = "A78E74DD3F17BBF76B7245787E00733D", hash_generated_method = "E1BD9FE4186F39BDD896AACC04B7ECA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endViewTransition(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            mTransitioningViews.remove(view);
            ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            {
                boolean var8B6CC6761C9BD4F7C4819DDB2B1B39CF_317409687 = (disappearingChildren != null && disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        boolean var8D124A8F477EC519F378FF84BB0D8AF5_220358516 = (mVisibilityChangingChildren != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.611 -0400", hash_original_method = "90F24CF973A15FCB3D8EF936857F7660", hash_generated_method = "C210D83ABCE13BCBC187BD795C94BEBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        boolean meOpaque;
        meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        super.gatherTransparentRegion(region);
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent;
        noneOfTheChildrenAreTransparent = true;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    boolean var589A259560F2788DFC2988B1FA33F37B_1141826894 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                    {
                        {
                            boolean var02F3557A74971374C057D08F3D583563_983378534 = (!child.gatherTransparentRegion(region));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.611 -0400", hash_original_method = "5C4070054C131245FD376376D5198B5B", hash_generated_method = "777705F0916BB7DAFFA9A5A0017F8F0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.611 -0400", hash_original_method = "055C0C5E94DF77352535F2463E2E2F92", hash_generated_method = "04475E809809DA493FB54002A51A3A68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        dsTaint.addTaint(insets.dsTaint);
        boolean done;
        done = super.fitSystemWindows(insets);
        {
            int count;
            count = mChildrenCount;
            View[] children;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.611 -0400", hash_original_method = "B3B3B12C071F8F31617EDB75C1351CBC", hash_generated_method = "92FC26EF58CD5A2553BC7DBDF81FE663")
    @DSModeled(DSC.SAFE)
    public Animation.AnimationListener getLayoutAnimationListener() {
        return (Animation.AnimationListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAnimationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.612 -0400", hash_original_method = "309790593767800D49B3C7FD0CAB3F32", hash_generated_method = "93E6DA96DBB4248586F6ACA5F386E731")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            } //End block
            View[] children;
            children = mChildren;
            int count;
            count = mChildrenCount;
            {
                int i;
                i = 0;
                {
                    View child;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.612 -0400", hash_original_method = "9BFEBEB244ACA3F0CF8B6DCD826B4034", hash_generated_method = "4A7E546BECC18412ED1C19A1FFFDA99F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        View[] children;
        children = mChildren;
        int count;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.612 -0400", hash_original_method = "0411A3FE715B4530882EE6CBB1252DCB", hash_generated_method = "517D54FFFE22A2A1A92FA4EC6C163E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_602875041 = (super.onCreateDrawableState(extraSpace));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.612 -0400", hash_original_method = "1481B38AF6385F8F98E444294398E1C4", hash_generated_method = "2A93059D01B36F256AEAB20A8376733D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.613 -0400", hash_original_method = "026C4CEB09DFE602F5C11A5652FC3C1F", hash_generated_method = "666E0ADF0B55B913E310DD2340287784")
    @DSModeled(DSC.SAFE)
    public boolean addStatesFromChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.613 -0400", hash_original_method = "F32408C60FA79535F6423CE68328A516", hash_generated_method = "A6481861E1AFDBF573578126F7858960")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.613 -0400", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "3D53DF69EAC868F48B68A0CF9D1314FA")
    @DSModeled(DSC.SAFE)
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        dsTaint.addTaint(animationListener.dsTaint);
        // ---------- Original Method ----------
        //mAnimationListener = animationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.613 -0400", hash_original_method = "8473FDA62EFB348A51ABA227E5F80648", hash_generated_method = "CBBA2B6FB2D17435FBC84EB5B1E7F629")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestTransitionStart(LayoutTransition transition) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.613 -0400", hash_original_method = "438FE65F3DA47A9BB347952B8A6B02CD", hash_generated_method = "DECF122CD5F1BAE0D5FBBD2888351FBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean varB5612BFB22B66951C85039D6A4ADA2D6_512262434 = (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.614 -0400", hash_original_method = "83014321BD6411A92FC299225A8B4B68", hash_generated_method = "0E717957BC39710673605D5D63B31900")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var97DAD7DCB6178A82512069CD3DA52554_1773385637 = (child.getTextDirection() == TEXT_DIRECTION_INHERIT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.614 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "405DCA594DC08240E17EA724AB4B49BA")
    @DSModeled(DSC.SAFE)
    public boolean shouldDelayChildPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    public static class LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int width;
        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int height;
        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.614 -0400", hash_original_method = "15AB37D81442EE27D75B1677A2391AE7", hash_generated_method = "48EE3F79BF3A10D4BDEA4009C0591D99")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.614 -0400", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "A093FB141CD21BA5068CB49FFB64885A")
        @DSModeled(DSC.SAFE)
        public LayoutParams(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.614 -0400", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "4FD30E8CE83438D072F1340B61CD6560")
        @DSModeled(DSC.SAFE)
        public LayoutParams(LayoutParams source) {
            dsTaint.addTaint(source.dsTaint);
            this.width = source.width;
            this.height = source.height;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.615 -0400", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "45AC97A074BFD055B1BD45042F079476")
        @DSModeled(DSC.SAFE)
         LayoutParams() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.615 -0400", hash_original_method = "22F495DEF56CC03879FA6664450D6ACC", hash_generated_method = "39C62A90BC940D1C08A15CB575786962")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.615 -0400", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "FACA6A6887FCCDFDCE3F8C08B959DBFA")
        @DSModeled(DSC.SAFE)
        protected void resolveWithDirection(int layoutDirection) {
            dsTaint.addTaint(layoutDirection);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.615 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "C37B0E96DB5743A033C3C27447B9240D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String debug(String output) {
            dsTaint.addTaint(output);
            String var540B99D0D715C61DA2A46A0C4E3114DB_338477855 = (output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return output + "ViewGroup.LayoutParams={ width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }

        
                protected static String sizeToString(int size) {
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }

        
        @SuppressWarnings({"UnusedDeclaration"}) @Deprecated public static final int FILL_PARENT = -1;
        public static final int MATCH_PARENT = -1;
        public static final int WRAP_CONTENT = -2;
    }


    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout") public int leftMargin;
        @ViewDebug.ExportedProperty(category = "layout") public int topMargin;
        @ViewDebug.ExportedProperty(category = "layout") public int rightMargin;
        @ViewDebug.ExportedProperty(category = "layout") public int bottomMargin;
        @ViewDebug.ExportedProperty(category = "layout") protected int startMargin = DEFAULT_RELATIVE;
        @ViewDebug.ExportedProperty(category = "layout") protected int endMargin = DEFAULT_RELATIVE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.616 -0400", hash_original_method = "10E5D625CF55B3D944D3843050E826C6", hash_generated_method = "884A5AB824B7D8BC9B1828C5C8DA0918")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.616 -0400", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "FFF30F0D01BF4D5E6DA95F23921F293A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MarginLayoutParams(int width, int height) {
            super(width, height);
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.616 -0400", hash_original_method = "55868F7F983C11B537A625BA756EE7CC", hash_generated_method = "AAFC10DECBA0FA79A2223546AF14216B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.616 -0400", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "50744E003913B7CE65E953EE3095739B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MarginLayoutParams(LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.617 -0400", hash_original_method = "A7CFD8E9AA47AE278733C57B8CF5503F", hash_generated_method = "FAE41F6ECC95F8059F3DC4AFBA7EAC88")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.617 -0400", hash_original_method = "F5A63690A2F55CE5C4D6B1F24495E028", hash_generated_method = "9A813B8FC3EF9D36011EEC1613D262D6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.617 -0400", hash_original_method = "A60FB56334BFE35432A89BE021472DEF", hash_generated_method = "6BE32E819AC4D7DEEB0F64723B3DBEFF")
        @DSModeled(DSC.SAFE)
        public int getMarginStart() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return startMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.617 -0400", hash_original_method = "2B74CF4F3396E75552B1A46DF3D4BFD7", hash_generated_method = "4E11822049A115BBEF01CE7C583ED328")
        @DSModeled(DSC.SAFE)
        public int getMarginEnd() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.617 -0400", hash_original_method = "C9EA583BDFA2583A2B96D706C959CDBC", hash_generated_method = "D29EC10834E9AFE25B81816F837A4B49")
        @DSModeled(DSC.SAFE)
        public boolean isMarginRelative() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.618 -0400", hash_original_method = "25B74C4F994FDDCB83271E7B2F9BDDEE", hash_generated_method = "7D6503258BFF783321CB21074CDF0C6D")
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

        
        static private final int DEFAULT_RELATIVE = Integer.MIN_VALUE;
    }


    
    private static final class TouchTarget {
        public View child;
        public int pointerIdBits;
        public TouchTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.618 -0400", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "B32A208B999EE5B494ADD3A3C0776E12")
        @DSModeled(DSC.SAFE)
        private TouchTarget() {
            // ---------- Original Method ----------
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.618 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static final int MAX_RECYCLED = 32;
        private static final Object sRecycleLock = new Object();
        private static TouchTarget sRecycleBin;
        private static int sRecycledCount;
        public static final int ALL_POINTER_IDS = -1;
    }


    
    private static final class HoverTarget {
        public View child;
        public HoverTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.619 -0400", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "726B690AE07312555BAF165F7E5F62F6")
        @DSModeled(DSC.SAFE)
        private HoverTarget() {
            // ---------- Original Method ----------
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:00.619 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static final int MAX_RECYCLED = 32;
        private static final Object sRecycleLock = new Object();
        private static HoverTarget sRecycleBin;
        private static int sRecycledCount;
    }


    
    public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
    
    private static final boolean DBG = false;
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
    public static final int PERSISTENT_NO_CACHE = 0x0;
    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
    public static final int PERSISTENT_ALL_CACHES = 0x3;
    protected static final int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
    private static final int CHILD_LEFT_INDEX = 0;
    private static final int CHILD_TOP_INDEX = 1;
    private static final int ARRAY_INITIAL_CAPACITY = 12;
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
}

