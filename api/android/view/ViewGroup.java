package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

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
	
	@DSModeled(DSC.SAFE)
	public ViewGroup(Context context){
		super(context);
		initViewGroup();
	}
	
	@DSModeled(DSC.SAFE)
	public ViewGroup(Context context, AttributeSet attrs){
		super(context, attrs);
		initViewGroup();
		/*
		initFromAttributes(context, attrs);
		*/
	}
	
	@DSModeled(DSC.SAFE)
	public ViewGroup(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);// Taint tracked in super class, View.
		initViewGroup();
		/*
		initFromAttributes(context, attrs);
		*/
	}
	
	@DSModeled(DSC.SAFE)
	private void initViewGroup(){
		
		// Original method
		/*
		{
        
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;

        if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB) {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        }

        setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);

        mChildren = new View[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;

        mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
    }
		*/
		//Return nothing
	    mChildren = new View[ARRAY_INITIAL_CAPACITY];
	}
	
	private void initFromAttributes(Context context, AttributeSet attrs){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	@ViewDebug.ExportedProperty(category="focus",mapping={@ViewDebug.IntToString(from=FOCUS_BEFORE_DESCENDANTS,to="FOCUS_BEFORE_DESCENDANTS"),@ViewDebug.IntToString(from=FOCUS_AFTER_DESCENDANTS,to="FOCUS_AFTER_DESCENDANTS"),@ViewDebug.IntToString(from=FOCUS_BLOCK_DESCENDANTS,to="FOCUS_BLOCK_DESCENDANTS")}) public int getDescendantFocusability(){
		
		// Original method
		/*
		{
        return mGroupFlags & FLAG_MASK_FOCUSABILITY;
    }
		*/
		return 0;
	}
	
	public void setDescendantFocusability(int focusability){
		
		// Original method
		/*
		{
        switch (focusability) {
            case FOCUS_BEFORE_DESCENDANTS:
            case FOCUS_AFTER_DESCENDANTS:
            case FOCUS_BLOCK_DESCENDANTS:
                break;
            default:
                throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        }
        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
    }
		*/
		//Return nothing
	}
	
	@Override void handleFocusGainInternal(int direction, Rect previouslyFocusedRect){
		
		// Original method
		/*
		{
        if (mFocused != null) {
            mFocused.unFocus();
            mFocused = null;
        }
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
    }
		*/
		//Return nothing
	}
	
	public void requestChildFocus(View child, View focused){
		
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " requestChildFocus()");
        }
        if (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS) {
            return;
        }

        
        super.unFocus();

        
        if (mFocused != child) {
            if (mFocused != null) {
                mFocused.unFocus();
            }

            mFocused = child;
        }
        if (mParent != null) {
            mParent.requestChildFocus(this, focused);
        }
    }
		*/
		//Return nothing
	}
	
	public void focusableViewAvailable(View v){
		
		// Original method
		/*
		{
        if (mParent != null
                
                
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                
                
                
                
                
                
                
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS)) {
            mParent.focusableViewAvailable(v);
        }
    }
		*/
		//Return nothing
	}
	
	public boolean showContextMenuForChild(View originalView){
		
		// Original method
		/*
		{
        return mParent != null && mParent.showContextMenuForChild(originalView);
    }
		*/
		return false;
	}
	
	public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback){
		
		// Original method
		/*
		{
        return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
    }
		*/
		return null;
	}
	
	public View focusSearch(View focused, int direction){
		
		// Original method
		/*
		{
        if (isRootNamespace()) {
            
            
            
            return FocusFinder.getInstance().findNextFocus(this, focused, direction);
        } else if (mParent != null) {
            return mParent.focusSearch(focused, direction);
        }
        return null;
    }
		*/
		return null;
	}
	
	public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate){
		
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}
	
	public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event){
		
		// Original method
		/*
		{
        ViewParent parent = getParent();
        if (parent == null) {
            return false;
        }
        final boolean propagate = onRequestSendAccessibilityEvent(child, event);
        
        if (!propagate) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this, event);
    }
		*/
		return false;
	}
	
	public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event){
		
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        } else {
            return onRequestSendAccessibilityEventInternal(child, event);
        }
    }
		*/
		return false;
	}
	
	boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event){
		
		// Original method
		/*
		{
        return true;
    }
		*/
		return false;
	}
	
	@Override public boolean dispatchUnhandledMove(View focused, int direction){
		
		// Original method
		/*
		{
        return mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction);
    }
		*/
		return false;
	}
	
	public void clearChildFocus(View child){
		
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " clearChildFocus()");
        }

        mFocused = null;
        if (mParent != null) {
            mParent.clearChildFocus(this);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void clearFocus(){
		
		// Original method
		/*
		{
        super.clearFocus();

        
        if (mFocused != null) {
            mFocused.clearFocus();
        }
    }
		*/
		//Return nothing
	}
	
	@Override void unFocus(){
		
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " unFocus()");
        }

        super.unFocus();
        if (mFocused != null) {
            mFocused.unFocus();
        }
        mFocused = null;
    }
		*/
		//Return nothing
	}
	
	public View getFocusedChild(){
		return (View)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return mFocused;
    }
		*/
	}
	
	@Override public boolean hasFocus(){
		
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }
		*/
		return false;
	}
	
	@Override public View findFocus(){
		
		// Original method
		/*
		{
        if (DBG) {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        }

        if (isFocused()) {
            return this;
        }

        if (mFocused != null) {
            return mFocused.findFocus();
        }
        return null;
    }
		*/
		return null;
	}
	
	@Override public boolean hasFocusable(){
		
		// Original method
		/*
		{
        if ((mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            return false;
        }

        if (isFocusable()) {
            return true;
        }

        final int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            final int count = mChildrenCount;
            final View[] children = mChildren;

            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if (child.hasFocusable()) {
                    return true;
                }
            }
        }

        return false;
    }
		*/
		return false;
	}
	
	@Override public void addFocusables(ArrayList<View> views, int direction){
		
		// Original method
		/*
		{
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }
		*/
		//Return nothing
	}
	
	@Override public void addFocusables(ArrayList<View> views, int direction, int focusableMode){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	@Override public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags){
		
		// Original method
		/*
		{
        super.findViewsWithText(outViews, text, flags);
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < childrenCount; i++) {
            View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                child.findViewsWithText(outViews, text, flags);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override View findViewByAccessibilityIdTraversal(int accessibilityId){
		
		// Original method
		/*
		{
        View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        if (foundView != null) {
            return foundView;
        }
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < childrenCount; i++) {
            View child = children[i];
            foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
            if (foundView != null) {
                return foundView;
            }
        }
        return null;
    }
		*/
		return null;
	}
	
	@Override public void dispatchWindowFocusChanged(boolean hasFocus){
		
		// Original method
		/*
		{
        super.dispatchWindowFocusChanged(hasFocus);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchWindowFocusChanged(hasFocus);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void addTouchables(ArrayList<View> views){
		
		// Original method
		/*
		{
        super.addTouchables(views);

        final int count = mChildrenCount;
        final View[] children = mChildren;

        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                child.addTouchables(views);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchDisplayHint(int hint){
		
		// Original method
		/*
		{
        super.dispatchDisplayHint(hint);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchDisplayHint(hint);
        }
    }
		*/
		//Return nothing
	}
	
	protected void onChildVisibilityChanged(View child, int visibility){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	@Override protected void dispatchVisibilityChanged(View changedView, int visibility){
		
		// Original method
		/*
		{
        super.dispatchVisibilityChanged(changedView, visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchVisibilityChanged(changedView, visibility);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchWindowVisibilityChanged(int visibility){
		
		// Original method
		/*
		{
        super.dispatchWindowVisibilityChanged(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchWindowVisibilityChanged(visibility);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchConfigurationChanged(Configuration newConfig){
		
		// Original method
		/*
		{
        super.dispatchConfigurationChanged(newConfig);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchConfigurationChanged(newConfig);
        }
    }
		*/
		//Return nothing
	}
	
	public void recomputeViewAttributes(View child){
		
		// Original method
		/*
		{
        if (mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            ViewParent parent = mParent;
            if (parent != null) parent.recomputeViewAttributes(this);
        }
    }
		*/
		//Return nothing
	}
	
	@Override void dispatchCollectViewAttributes(int visibility){
		
		// Original method
		/*
		{
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchCollectViewAttributes(visibility);
        }
    }
		*/
		//Return nothing
	}
	
	public void bringChildToFront(View child){
		
		// Original method
		/*
		{
        int index = indexOfChild(child);
        if (index >= 0) {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        }
    }
		*/
		//Return nothing
	}
	
	@Override public boolean dispatchDragEvent(DragEvent event){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint){
		
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = count - 1; i >= 0; i--) {
            final View child = children[i];
            if (!child.canAcceptDrag()) {
                continue;
            }

            if (isTransformedTouchPointInView(x, y, child, outLocalPoint)) {
                return child;
            }
        }
        return null;
    }
		*/
		return null;
	}
	
	boolean notifyChildOfDrag(View child){
		
		// Original method
		/*
		{
        if (ViewDebug.DEBUG_DRAG) {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        }

        boolean canAccept = false;
        if (! mDragNotifiedChildren.contains(child)) {
            mDragNotifiedChildren.add(child);
            canAccept = child.dispatchDragEvent(mCurrentDrag);
            if (canAccept && !child.canAcceptDrag()) {
                child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                child.refreshDrawableState();
            }
        }
        return canAccept;
    }
		*/
		return false;
	}
	
	@Override public void dispatchSystemUiVisibilityChanged(int visible){
		
		// Original method
		/*
		{
        super.dispatchSystemUiVisibilityChanged(visible);

        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i=0; i <count; i++) {
            final View child = children[i];
            child.dispatchSystemUiVisibilityChanged(visible);
        }
    }
		*/
		//Return nothing
	}
	
	@Override void updateLocalSystemUiVisibility(int localValue, int localChanges){
		
		// Original method
		/*
		{
        super.updateLocalSystemUiVisibility(localValue, localChanges);

        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i=0; i <count; i++) {
            final View child = children[i];
            child.updateLocalSystemUiVisibility(localValue, localChanges);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public boolean dispatchKeyEventPreIme(KeyEvent event){
		
		// Original method
		/*
		{
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchKeyEventPreIme(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchKeyEventPreIme(event);
        }
        return false;
    }
		*/
		return false;
	}
	
	@Override public boolean dispatchKeyEvent(KeyEvent event){
		
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        }

        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            if (super.dispatchKeyEvent(event)) {
                return true;
            }
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (mFocused.dispatchKeyEvent(event)) {
                return true;
            }
        }

        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        }
        return false;
    }
		*/
		return false;
	}
	
	@Override public boolean dispatchKeyShortcutEvent(KeyEvent event){
		
		// Original method
		/*
		{
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchKeyShortcutEvent(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchKeyShortcutEvent(event);
        }
        return false;
    }
		*/
		return false;
	}
	
	@Override public boolean dispatchTrackballEvent(MotionEvent event){
		
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        }

        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            if (super.dispatchTrackballEvent(event)) {
                return true;
            }
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (mFocused.dispatchTrackballEvent(event)) {
                return true;
            }
        }

        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        }
        return false;
    }
		*/
		return false;
	}
	
	@SuppressWarnings({"ConstantConditions"}) @Override protected boolean dispatchHoverEvent(MotionEvent event){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	@Override protected boolean hasHoveredChild(){
		
		// Original method
		/*
		{
        return mFirstHoverTarget != null;
    }
		*/
		return false;
	}
	
	public boolean onInterceptHoverEvent(MotionEvent event){
		
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}
	
	private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event){
		
		// Original method
		/*
		{
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }
		*/
		return null;
	}
	
	@Override protected boolean dispatchGenericPointerEvent(MotionEvent event){
		
		// Original method
		/*
		{
        
        final int childrenCount = mChildrenCount;
        if (childrenCount != 0) {
            final View[] children = mChildren;
            final float x = event.getX();
            final float y = event.getY();

            for (int i = childrenCount - 1; i >= 0; i--) {
                final View child = children[i];
                if (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null)) {
                    continue;
                }

                if (dispatchTransformedGenericPointerEvent(event, child)) {
                    return true;
                }
            }
        }

        
        return super.dispatchGenericPointerEvent(event);
    }
		*/
		return false;
	}
	
	@Override protected boolean dispatchGenericFocusedEvent(MotionEvent event){
		
		// Original method
		/*
		{
        
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchGenericFocusedEvent(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchGenericMotionEvent(event);
        }
        return false;
    }
		*/
		return false;
	}
	
	private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child){
		
		// Original method
		/*
		{
        final float offsetX = mScrollX - child.mLeft;
        final float offsetY = mScrollY - child.mTop;

        boolean handled;
        if (!child.hasIdentityMatrix()) {
            MotionEvent transformedEvent = MotionEvent.obtain(event);
            transformedEvent.offsetLocation(offsetX, offsetY);
            transformedEvent.transform(child.getInverseMatrix());
            handled = child.dispatchGenericMotionEvent(transformedEvent);
            transformedEvent.recycle();
        } else {
            event.offsetLocation(offsetX, offsetY);
            handled = child.dispatchGenericMotionEvent(event);
            event.offsetLocation(-offsetX, -offsetY);
        }
        return handled;
    }
		*/
		return false;
	}
	
	@Override public boolean dispatchTouchEvent(MotionEvent ev){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	private void resetTouchState(){
		
		// Original method
		/*
		{
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }
		*/
		//Return nothing
	}
	
	private boolean resetCancelNextUpFlag(View view){
		
		// Original method
		/*
		{
        if ((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0) {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            return true;
        }
        return false;
    }
		*/
		return false;
	}
	
	private void clearTouchTargets(){
		
		// Original method
		/*
		{
        TouchTarget target = mFirstTouchTarget;
        if (target != null) {
            do {
                TouchTarget next = target.next;
                target.recycle();
                target = next;
            } while (target != null);
            mFirstTouchTarget = null;
        }
    }
		*/
		//Return nothing
	}
	
	private void cancelAndClearTouchTargets(MotionEvent event){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	private TouchTarget getTouchTarget(View child){
		
		// Original method
		/*
		{
        for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
            if (target.child == child) {
                return target;
            }
        }
        return null;
    }
		*/
		return null;
	}
	
	private TouchTarget addTouchTarget(View child, int pointerIdBits){
		
		// Original method
		/*
		{
        TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        return target;
    }
		*/
		return null;
	}
	
	private void removePointersFromTouchTargets(int pointerIdBits){
		
		// Original method
		/*
		{
        TouchTarget predecessor = null;
        TouchTarget target = mFirstTouchTarget;
        while (target != null) {
            final TouchTarget next = target.next;
            if ((target.pointerIdBits & pointerIdBits) != 0) {
                target.pointerIdBits &= ~pointerIdBits;
                if (target.pointerIdBits == 0) {
                    if (predecessor == null) {
                        mFirstTouchTarget = next;
                    } else {
                        predecessor.next = next;
                    }
                    target.recycle();
                    target = next;
                    continue;
                }
            }
            predecessor = target;
            target = next;
        }
    }
		*/
		//Return nothing
	}
	
	private static boolean canViewReceivePointerEvents(View child){
		
		// Original method
		/*
		{
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }
		*/
		return false;
	}
	
	protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint){
		
		// Original method
		/*
		{
        float localX = x + mScrollX - child.mLeft;
        float localY = y + mScrollY - child.mTop;
        if (! child.hasIdentityMatrix() && mAttachInfo != null) {
            final float[] localXY = mAttachInfo.mTmpTransformLocation;
            localXY[0] = localX;
            localXY[1] = localY;
            child.getInverseMatrix().mapPoints(localXY);
            localX = localXY[0];
            localY = localXY[1];
        }
        final boolean isInView = child.pointInView(localX, localY);
        if (isInView && outLocalPoint != null) {
            outLocalPoint.set(localX, localY);
        }
        return isInView;
    }
		*/
		return false;
	}
	
	private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	public void setMotionEventSplittingEnabled(boolean split){
		
		// Original method
		/*
		{
        
        
        
        if (split) {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } else {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        }
    }
		*/
		//Return nothing
	}
	
	public boolean isMotionEventSplittingEnabled(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }
		*/
		return false;
	}
	
	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept){
		
		// Original method
		/*
		{

        if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            
            return;
        }

        if (disallowIntercept) {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } else {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        }

        
        if (mParent != null) {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }
		*/
		//Return nothing
	}
	
	public boolean onInterceptTouchEvent(MotionEvent ev){
		
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}
	
	@Override public boolean requestFocus(int direction, Rect previouslyFocusedRect){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	@SuppressWarnings({"ConstantConditions"}) protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect){
		
		// Original method
		/*
		{
        int index;
        int increment;
        int end;
        int count = mChildrenCount;
        if ((direction & FOCUS_FORWARD) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        final View[] children = mChildren;
        for (int i = index; i != end; i += increment) {
            View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                if (child.requestFocus(direction, previouslyFocusedRect)) {
                    return true;
                }
            }
        }
        return false;
    }
		*/
		return false;
	}
	
	@Override public void dispatchStartTemporaryDetach(){
		
		// Original method
		/*
		{
        super.dispatchStartTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchStartTemporaryDetach();
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchFinishTemporaryDetach(){
		
		// Original method
		/*
		{
        super.dispatchFinishTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchFinishTemporaryDetach();
        }
    }
		*/
		//Return nothing
	}
	
	@Override void dispatchAttachedToWindow(AttachInfo info, int visibility){
		
		// Original method
		/*
		{
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;

        visibility |= mViewFlags & VISIBILITY_MASK;

        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchAttachedToWindow(info, visibility);
        }
    }
		*/
		//Return nothing
	}
	
	@Override boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event){
		
		// Original method
		/*
		{
        boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
        if (handled) {
            return handled;
        }
        
        for (int i = 0, count = getChildCount(); i < count; i++) {
            View child = getChildAt(i);
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                if (handled) {
                    return handled;
                }
            }
        }
        return false;
    }
		*/
		return false;
	}
	
	@Override void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info){
		
		// Original method
		/*
		{
        super.onInitializeAccessibilityNodeInfoInternal(info);
        for (int i = 0, count = mChildrenCount; i < count; i++) {
            View child = mChildren[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                info.addChild(child);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override void dispatchDetachedFromWindow(){
		
		// Original method
		/*
		{
        
        
        
        
        
        cancelAndClearTouchTargets(null);

        
        mLayoutSuppressed = false;

        
        mDragNotifiedChildren = null;
        if (mCurrentDrag != null) {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        }

        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchDetachedFromWindow();
        }
        super.dispatchDetachedFromWindow();
    }
		*/
		//Return nothing
	}
	
	@Override public void setPadding(int left, int top, int right, int bottom){
		
		// Original method
		/*
		{
        super.setPadding(left, top, right, bottom);

        if ((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0) {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } else {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void dispatchSaveInstanceState(SparseArray<Parcelable> container){
		
		// Original method
		/*
		{
        super.dispatchSaveInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            View c = children[i];
            if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                c.dispatchSaveInstanceState(container);
            }
        }
    }
		*/
		//Return nothing
	}
	
	protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container){
		
		// Original method
		/*
		{
        super.dispatchSaveInstanceState(container);
    }
		*/
		//Return nothing
	}
	
	@Override protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container){
		
		// Original method
		/*
		{
        super.dispatchRestoreInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            View c = children[i];
            if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                c.dispatchRestoreInstanceState(container);
            }
        }
    }
		*/
		//Return nothing
	}
	
	protected void dispatchThawSelfOnly(SparseArray<Parcelable> container){
		
		// Original method
		/*
		{
        super.dispatchRestoreInstanceState(container);
    }
		*/
		//Return nothing
	}
	
	protected void setChildrenDrawingCacheEnabled(boolean enabled){
		
		// Original method
		/*
		{
        if (enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES) {
            final View[] children = mChildren;
            final int count = mChildrenCount;
            for (int i = 0; i < count; i++) {
                children[i].setDrawingCacheEnabled(enabled);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void onAnimationStart(){
		
		// Original method
		/*
		{
        super.onAnimationStart();

        
        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            final boolean buildCache = !isHardwareAccelerated();

            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    child.setDrawingCacheEnabled(true);
                    if (buildCache) {
                        child.buildDrawingCache(true);
                    }
                }
            }

            mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void onAnimationEnd(){
		
		// Original method
		/*
		{
        super.onAnimationEnd();

        
        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;

            if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren){
		
		// Original method
		/*
		{
        int count = mChildrenCount;
        int[] visibilities = null;

        if (skipChildren) {
            visibilities = new int[count];
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                visibilities[i] = child.getVisibility();
                if (visibilities[i] == View.VISIBLE) {
                    child.setVisibility(INVISIBLE);
                }
            }
        }

        Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);

        if (skipChildren) {
            for (int i = 0; i < count; i++) {
                getChildAt(i).setVisibility(visibilities[i]);
            }
        }

        return b;
    }
		*/
		return null;
	}
	
	@Override protected void dispatchDraw(Canvas canvas){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	protected int getChildDrawingOrder(int childCount, int i){
		
		// Original method
		/*
		{
        return i;
    }
		*/
		return 0;
	}
	
	private void notifyAnimationListener(){
		
		// Original method
		/*
		{
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;

        if (mAnimationListener != null) {
           final Runnable end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
           post(end);
        }

        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }

        invalidate(true);
    }
		*/
		//Return nothing
	}
	
	@Override protected void dispatchGetDisplayList(){
		
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer()) {
                child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                child.mPrivateFlags &= ~INVALIDATED;
                child.getDisplayList();
                child.mRecreateDisplayList = false;
            }
        }
    }
		*/
		//Return nothing
	}
	
	protected boolean drawChild(Canvas canvas, View child, long drawingTime){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	public void setChildrenLayersEnabled(boolean enabled){
		
		// Original method
		/*
		{
        if (enabled != mDrawLayers) {
            mDrawLayers = enabled;
            invalidate(true);

            
            
            
            
            
            
            
            for (int i = 0; i < mChildrenCount; i++) {
                View child = mChildren[i];
                if (child.mLayerType != LAYER_TYPE_NONE) {
                    child.invalidate(true);
                }
            }
        }
    }
		*/
		//Return nothing
	}
	
	public void setClipChildren(boolean clipChildren){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }
		*/
		//Return nothing
	}
	
	public void setClipToPadding(boolean clipToPadding){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchSetSelected(boolean selected){
		
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setSelected(selected);
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void dispatchSetActivated(boolean activated){
		
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setActivated(activated);
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void dispatchSetPressed(boolean pressed){
		
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setPressed(pressed);
        }
    }
		*/
		//Return nothing
	}
	
	protected void setStaticTransformationsEnabled(boolean enabled){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }
		*/
		//Return nothing
	}
	
	protected boolean getChildStaticTransformation(View child, Transformation t){
		
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}
	
	@Override protected View findViewTraversal(int id){
		
		// Original method
		/*
		{
        if (id == mID) {
            return this;
        }

        final View[] where = mChildren;
        final int len = mChildrenCount;

        for (int i = 0; i < len; i++) {
            View v = where[i];

            if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewById(id);

                if (v != null) {
                    return v;
                }
            }
        }

        return null;
    }
		*/
		return null;
	}
	
	@Override protected View findViewWithTagTraversal(Object tag){
		
		// Original method
		/*
		{
        if (tag != null && tag.equals(mTag)) {
            return this;
        }

        final View[] where = mChildren;
        final int len = mChildrenCount;

        for (int i = 0; i < len; i++) {
            View v = where[i];

            if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewWithTag(tag);

                if (v != null) {
                    return v;
                }
            }
        }

        return null;
    }
		*/
		return null;
	}
	
	@Override protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip){
		
		// Original method
		/*
		{
        if (predicate.apply(this)) {
            return this;
        }

        final View[] where = mChildren;
        final int len = mChildrenCount;

        for (int i = 0; i < len; i++) {
            View v = where[i];

            if (v != childToSkip && (v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewByPredicate(predicate);

                if (v != null) {
                    return v;
                }
            }
        }

        return null;
    }
		*/
		return null;
	}
	
	public void addView(View child){
		
		// Original method
		/*
		{
        addView(child, -1);
    }
		*/
		//Return nothing
	}
	
	public void addView(View child, int index){
		
		// Original method
		/*
		{
        LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = generateDefaultLayoutParams();
            if (params == null) {
                throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            }
        }
        addView(child, index, params);
    }
		*/
		//Return nothing
	}
	
	public void addView(View child, int width, int height){
		
		// Original method
		/*
		{
        final LayoutParams params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
    }
		*/
		//Return nothing
	}
	
	public void addView(View child, LayoutParams params){
		
		// Original method
		/*
		{
        addView(child, -1, params);
    }
		*/
		//Return nothing
	}
	
	public void addView(View child, int index, LayoutParams params){
		
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " addView");
        }

        
        
        
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
    }
		*/
		//Return nothing
	}
	
	public void updateViewLayout(View view, ViewGroup.LayoutParams params){
		
		// Original method
		/*
		{
        if (!checkLayoutParams(params)) {
            throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        }
        if (view.mParent != this) {
            throw new IllegalArgumentException("Given view not a child of " + this);
        }
        view.setLayoutParams(params);
    }
		*/
		//Return nothing
	}
	
	protected boolean checkLayoutParams(ViewGroup.LayoutParams p){
		
		// Original method
		/*
		{
        return  p != null;
    }
		*/
		return false;
	}
	
	public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
	
	public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener){
		mOnHierarchyChangeListener = listener;  //Preserved
		
		// Original method
		/*
		{
        mOnHierarchyChangeListener = listener;
    }
		*/
		//Return nothing
	}
	
	protected void onViewAdded(View child){
		
		// Original method
		/*
		{
        if (mOnHierarchyChangeListener != null) {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        }
    }
		*/
		//Return nothing
	}
	
	protected void onViewRemoved(View child){
		
		// Original method
		/*
		{
        if (mOnHierarchyChangeListener != null) {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        }
    }
		*/
		//Return nothing
	}
	
	protected boolean addViewInLayout(View child, int index, LayoutParams params){
		
		// Original method
		/*
		{
        return addViewInLayout(child, index, params, false);
    }
		*/
		return false;
	}
	
	protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout){
		
		// Original method
		/*
		{
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        return true;
    }
		*/
		return false;
	}
	
	protected void cleanupLayoutState(View child){
		
		// Original method
		/*
		{
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }
		*/
		//Return nothing
	}
	
	private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	private void addInArray(View child, int index){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	private void removeFromArray(int index){
		
		// Original method
		/*
		{
        final View[] children = mChildren;
        if (!(mTransitioningViews != null && mTransitioningViews.contains(children[index]))) {
            children[index].mParent = null;
        }
        final int count = mChildrenCount;
        if (index == count - 1) {
            children[--mChildrenCount] = null;
        } else if (index >= 0 && index < count) {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } else {
            throw new IndexOutOfBoundsException();
        }
        if (mLastTouchDownIndex == index) {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
        } else if (mLastTouchDownIndex > index) {
            mLastTouchDownIndex--;
        }
    }
		*/
		//Return nothing
	}
	
	private void removeFromArray(int start, int count){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	private void bindLayoutAnimation(View child){
		
		// Original method
		/*
		{
        Animation a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
    }
		*/
		//Return nothing
	}
	
	protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count){
		
		// Original method
		/*
		{
        LayoutAnimationController.AnimationParameters animationParams =
                    params.layoutAnimationParameters;
        if (animationParams == null) {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        }

        animationParams.count = count;
        animationParams.index = index;
    }
		*/
		//Return nothing
	}
	
	public void removeView(View view){
		
		// Original method
		/*
		{
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
	
	public void removeViewInLayout(View view){
		
		// Original method
		/*
		{
        removeViewInternal(view);
    }
		*/
		//Return nothing
	}
	
	public void removeViewsInLayout(int start, int count){
		
		// Original method
		/*
		{
        removeViewsInternal(start, count);
    }
		*/
		//Return nothing
	}
	
	public void removeViewAt(int index){
		
		// Original method
		/*
		{
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
	
	public void removeViews(int start, int count){
		
		// Original method
		/*
		{
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
	
	private void removeViewInternal(View view){
		
		// Original method
		/*
		{
        final int index = indexOfChild(view);
        if (index >= 0) {
            removeViewInternal(index, view);
        }
    }
		*/
		//Return nothing
	}
	
	private void removeViewInternal(int index, View view){
		
		// Original method
		/*
		{

        if (mTransition != null) {
            mTransition.removeChild(this, view);
        }

        boolean clearChildFocus = false;
        if (view == mFocused) {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        }

        if (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view))) {
            addDisappearingView(view);
        } else if (view.mAttachInfo != null) {
           view.dispatchDetachedFromWindow();
        }

        onViewRemoved(view);

        needGlobalAttributesUpdate(false);

        removeFromArray(index);

        if (clearChildFocus) {
            clearChildFocus(view);
        }
    }
		*/
		//Return nothing
	}
	
	public void setLayoutTransition(LayoutTransition transition){
		mTransition = transition;  //Preserved
		
		// Original method
		/*
		{
        if (mTransition != null) {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        }
        mTransition = transition;
        if (mTransition != null) {
            mTransition.addTransitionListener(mLayoutTransitionListener);
        }
    }
		*/
		//Return nothing
	}
	
	public LayoutTransition getLayoutTransition(){
		return (LayoutTransition)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return mTransition;
    }
		*/
	}
	
	private void removeViewsInternal(int start, int count){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	public void removeAllViews(){
		
		// Original method
		/*
		{
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
	
	public void removeAllViewsInLayout(){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	protected void removeDetachedView(View child, boolean animate){
		
		// Original method
		/*
		{
        if (mTransition != null) {
            mTransition.removeChild(this, child);
        }

        if (child == mFocused) {
            child.clearFocus();
        }

        if ((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child))) {
            addDisappearingView(child);
        } else if (child.mAttachInfo != null) {
            child.dispatchDetachedFromWindow();
        }

        onViewRemoved(child);
    }
		*/
		//Return nothing
	}
	
	protected void attachViewToParent(View child, int index, LayoutParams params){
		
		// Original method
		/*
		{
        child.mLayoutParams = params;

        if (index < 0) {
            index = mChildrenCount;
        }

        addInArray(child, index);

        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;

        if (child.hasFocus()) {
            requestChildFocus(child, child.findFocus());
        }
    }
		*/
		//Return nothing
	}
	
	protected void detachViewFromParent(View child){
		
		// Original method
		/*
		{
        removeFromArray(indexOfChild(child));
    }
		*/
		//Return nothing
	}
	
	protected void detachViewFromParent(int index){
		
		// Original method
		/*
		{
        removeFromArray(index);
    }
		*/
		//Return nothing
	}
	
	protected void detachViewsFromParent(int start, int count){
		
		// Original method
		/*
		{
        removeFromArray(start, count);
    }
		*/
		//Return nothing
	}
	
	protected void detachAllViewsFromParent(){
		
		// Original method
		/*
		{
        final int count = mChildrenCount;
        if (count <= 0) {
            return;
        }

        final View[] children = mChildren;
        mChildrenCount = 0;

        for (int i = count - 1; i >= 0; i--) {
            children[i].mParent = null;
            children[i] = null;
        }
    }
		*/
		//Return nothing
	}
	
	public final void invalidateChild(View child, final Rect dirty){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	public ViewParent invalidateChildInParent(final int[] location, final Rect dirty){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
	
	public final void offsetDescendantRectToMyCoords(View descendant, Rect rect){
		
		// Original method
		/*
		{
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }
		*/
		//Return nothing
	}
	
	public final void offsetRectIntoDescendantCoords(View descendant, Rect rect){
		
		// Original method
		/*
		{
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }
		*/
		//Return nothing
	}
	
	void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	public void offsetChildrenTopAndBottom(int offset){
		
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;

        for (int i = 0; i < count; i++) {
            final View v = children[i];
            v.mTop += offset;
            v.mBottom += offset;
        }
    }
		*/
		//Return nothing
	}
	
	public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	@Override public final void layout(int l, int t, int r, int b){
		
		// Original method
		/*
		{
        if (mTransition == null || !mTransition.isChangingLayout()) {
            super.layout(l, t, r, b);
        } else {
            
            mLayoutSuppressed = true;
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected abstract void onLayout(boolean changed,
            int l, int t, int r, int b);
	
	protected boolean canAnimate(){
		
		// Original method
		/*
		{
        return mLayoutAnimationController != null;
    }
		*/
		return false;
	}
	
	public void startLayoutAnimation(){
		
		// Original method
		/*
		{
        if (mLayoutAnimationController != null) {
            mGroupFlags |= FLAG_RUN_ANIMATION;
            requestLayout();
        }
    }
		*/
		//Return nothing
	}
	
	public void scheduleLayoutAnimation(){
		
		// Original method
		/*
		{
        mGroupFlags |= FLAG_RUN_ANIMATION;
    }
		*/
		//Return nothing
	}
	
	public void setLayoutAnimation(LayoutAnimationController controller){
		mLayoutAnimationController = controller;  //Preserved
		
		// Original method
		/*
		{
        mLayoutAnimationController = controller;
        if (mLayoutAnimationController != null) {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        }
    }
		*/
		//Return nothing
	}
	
	public LayoutAnimationController getLayoutAnimation(){
		return (LayoutAnimationController)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return mLayoutAnimationController;
    }
		*/
	}
	
	@ViewDebug.ExportedProperty public boolean isAnimationCacheEnabled(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }
		*/
		return false;
	}
	
	public void setAnimationCacheEnabled(boolean enabled){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }
		*/
		//Return nothing
	}
	
	@ViewDebug.ExportedProperty(category="drawing") public boolean isAlwaysDrawnWithCacheEnabled(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }
		*/
		return false;
	}
	
	public void setAlwaysDrawnWithCacheEnabled(boolean always){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }
		*/
		//Return nothing
	}
	
	@ViewDebug.ExportedProperty(category="drawing") protected boolean isChildrenDrawnWithCacheEnabled(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }
		*/
		return false;
	}
	
	protected void setChildrenDrawnWithCacheEnabled(boolean enabled){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }
		*/
		//Return nothing
	}
	
	@ViewDebug.ExportedProperty(category="drawing") protected boolean isChildrenDrawingOrderEnabled(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }
		*/
		return false;
	}
	
	protected void setChildrenDrawingOrderEnabled(boolean enabled){
		
		// Original method
		/*
		{
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }
		*/
		//Return nothing
	}
	
	private void setBooleanFlag(int flag, boolean value){
		
		// Original method
		/*
		{
        if (value) {
            mGroupFlags |= flag;
        } else {
            mGroupFlags &= ~flag;
        }
    }
		*/
		//Return nothing
	}
	
	@ViewDebug.ExportedProperty(category="drawing",mapping={@ViewDebug.IntToString(from=PERSISTENT_NO_CACHE,to="NONE"),@ViewDebug.IntToString(from=PERSISTENT_ANIMATION_CACHE,to="ANIMATION"),@ViewDebug.IntToString(from=PERSISTENT_SCROLLING_CACHE,to="SCROLLING"),@ViewDebug.IntToString(from=PERSISTENT_ALL_CACHES,to="ALL")}) public int getPersistentDrawingCache(){
		return dsTaint.getTaintInt();
		
		// Original method
		/*
		{
        return mPersistentDrawingCache;
    }
		*/
	}
	
	public void setPersistentDrawingCache(int drawingCacheToKeep){
		
		// Original method
		/*
		{
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }
		*/
		//Return nothing
	}
	
	public LayoutParams generateLayoutParams(AttributeSet attrs){
		
		// Original method
		/*
		{
        return new LayoutParams(getContext(), attrs);
    }
		*/
		return null;
	}
	
	protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p){
		
		// Original method
		/*
		{
        return p;
    }
		*/
		return null;
	}
	
	protected LayoutParams generateDefaultLayoutParams(){
		
		// Original method
		/*
		{
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
		*/
		return null;
	}
	
	@Override protected boolean dispatchConsistencyCheck(int consistency){
		
		// Original method
		/*
		{
        boolean result = super.dispatchConsistencyCheck(consistency);

        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            if (!children[i].dispatchConsistencyCheck(consistency)) result = false;
        }

        return result;
    }
		*/
		return false;
	}
	
	@Override protected boolean onConsistencyCheck(int consistency){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
	
	@Override protected void debug(int depth){
		
		// Original method
		/*
		{
        super.debug(depth);
        String output;

        if (mFocused != null) {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        }
        if (mChildrenCount != 0) {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        }
        int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            View child = mChildren[i];
            child.debug(depth + 1);
        }

        if (mChildrenCount != 0) {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        }
    }
		*/
		//Return nothing
	}
	
	public int indexOfChild(View child){
		
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            if (children[i] == child) {
                return i;
            }
        }
        return -1;
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public int getChildCount(){
		return dsTaint.getTaintInt();
	}
	
	@DSModeled
	public View getChildAt(int index){
		return mChildren[0];
	}
	
	protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec){
		
		// Original method
		/*
		{
        final int size = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < size; ++i) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) != GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }
		*/
		//Return nothing
	}
	
	protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec){
		
		// Original method
		/*
		{
        final LayoutParams lp = child.getLayoutParams();

        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }
		*/
		//Return nothing
	}
	
	protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed){
		
		// Original method
		/*
		{
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }
		*/
		//Return nothing
	}
	
	public static int getChildMeasureSpec(int spec, int padding, int childDimension){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return 0;
	}
	
	public void clearDisappearingChildren(){
		
		// Original method
		/*
		{
        if (mDisappearingChildren != null) {
            mDisappearingChildren.clear();
        }
    }
		*/
		//Return nothing
	}
	
	private void addDisappearingView(View v){
		
		// Original method
		/*
		{
        ArrayList<View> disappearingChildren = mDisappearingChildren;

        if (disappearingChildren == null) {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        }

        disappearingChildren.add(v);
    }
		*/
		//Return nothing
	}
	
	private void finishAnimatingView(final View view, Animation animation){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	boolean isViewTransitioning(View view){
		
		// Original method
		/*
		{
        return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }
		*/
		return false;
	}
	
	public void startViewTransition(View view){
		
		// Original method
		/*
		{
        if (view.mParent == this) {
            if (mTransitioningViews == null) {
                mTransitioningViews = new ArrayList<View>();
            }
            mTransitioningViews.add(view);
        }
    }
		*/
		//Return nothing
	}
	
	public void endViewTransition(View view){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
	
	private class MyTransitionListener implements LayoutTransition.TransitionListener {
	    
	    @DSModeled
	    public MyTransitionListener(ViewGroup viewGroup) {
	        
	    }
	    
        @Override
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            
            
            if (transitionType == LayoutTransition.DISAPPEARING) {
                startViewTransition(view);
            }
        }

        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            if (mLayoutSuppressed && !transition.isChangingLayout()) {
                requestLayout();
                mLayoutSuppressed = false;
            }
            if (transitionType == LayoutTransition.DISAPPEARING && mTransitioningViews != null) {
                endViewTransition(view);
            }
        }
    }
	
	
	private LayoutTransition.TransitionListener mLayoutTransitionListener = new MyTransitionListener(this);
	
	@Override public boolean gatherTransparentRegion(Region region){
		
		// Original method
		/*
		{
        
        final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        if (meOpaque && region == null) {
            
            return true;
        }
        super.gatherTransparentRegion(region);
        final View[] children = mChildren;
        final int count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent = true;
        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) {
                if (!child.gatherTransparentRegion(region)) {
                    noneOfTheChildrenAreTransparent = false;
                }
            }
        }
        return meOpaque || noneOfTheChildrenAreTransparent;
    }
		*/
		return false;
	}
	
	public void requestTransparentRegion(View child){
		
		// Original method
		/*
		{
        if (child != null) {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            if (mParent != null) {
                mParent.requestTransparentRegion(this);
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected boolean fitSystemWindows(Rect insets){
		
		// Original method
		/*
		{
        boolean done = super.fitSystemWindows(insets);
        if (!done) {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            for (int i = 0; i < count; i++) {
                done = children[i].fitSystemWindows(insets);
                if (done) {
                    break;
                }
            }
        }
        return done;
    }
		*/
		return false;
	}
	
	public Animation.AnimationListener getLayoutAnimationListener(){
		return (Animation.AnimationListener)dsTaint.getTaint();
		
		// Original method
		/*
		{
        return mAnimationListener;
    }
		*/
	}
	
	@Override protected void drawableStateChanged(){
		
		// Original method
		/*
		{
        super.drawableStateChanged();

        if ((mGroupFlags & FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE) != 0) {
            if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
                throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            }

            final View[] children = mChildren;
            final int count = mChildrenCount;

            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if ((child.mViewFlags & DUPLICATE_PARENT_STATE) != 0) {
                    child.refreshDrawableState();
                }
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override public void jumpDrawablesToCurrentState(){
		
		// Original method
		/*
		{
        super.jumpDrawablesToCurrentState();
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].jumpDrawablesToCurrentState();
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected int[] onCreateDrawableState(int extraSpace){
		
		// Original method
		/*
		{
        if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) == 0) {
            return super.onCreateDrawableState(extraSpace);
        }

        int need = 0;
        int n = getChildCount();
        for (int i = 0; i < n; i++) {
            int[] childState = getChildAt(i).getDrawableState();

            if (childState != null) {
                need += childState.length;
            }
        }

        int[] state = super.onCreateDrawableState(extraSpace + need);

        for (int i = 0; i < n; i++) {
            int[] childState = getChildAt(i).getDrawableState();

            if (childState != null) {
                state = mergeDrawableStates(state, childState);
            }
        }

        return state;
    }
		*/
		return null;
	}
	
	public void setAddStatesFromChildren(boolean addsStates){
		
		// Original method
		/*
		{
        if (addsStates) {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } else {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        }

        refreshDrawableState();
    }
		*/
		//Return nothing
	}
	
	public boolean addStatesFromChildren(){
		
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }
		*/
		return false;
	}
	
	public void childDrawableStateChanged(View child){
		
		// Original method
		/*
		{
        if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}
	
	public void setLayoutAnimationListener(Animation.AnimationListener animationListener){
		mAnimationListener = animationListener;  //Preserved
		// Original method
		/*
		{
        mAnimationListener = animationListener;
    }
		*/
		//Return nothing
	}
	
	public void requestTransitionStart(LayoutTransition transition){
		
		// Original method
		/*
		{
        ViewRootImpl viewAncestor = getViewRootImpl();
        if (viewAncestor != null) {
            viewAncestor.requestTransitionStart(transition);
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void resetResolvedLayoutDirection(){
		
		// Original method
		/*
		{
        super.resetResolvedLayoutDirection();

        
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT) {
                child.resetResolvedLayoutDirection();
            }
        }
    }
		*/
		//Return nothing
	}
	
	@Override protected void resetResolvedTextDirection(){
		
		// Original method
		/*
		{
        super.resetResolvedTextDirection();

        
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getTextDirection() == TEXT_DIRECTION_INHERIT) {
                child.resetResolvedTextDirection();
            }
        }
    }
		*/
		//Return nothing
	}
	
	public boolean shouldDelayChildPressedState(){
		
		// Original method
		/*
		{
        return true;
    }
		*/
		return false;
	}
	
	public static class LayoutParams {
		private DSTaintObject dsTaint = new DSTaintObject();
		
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
		
		public LayoutParams(Context c, AttributeSet attrs){
			/*
			TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
			setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
			a.recycle();
			*/
		}
		
		public LayoutParams(int width, int height){
			/*
			this.width = width;
			this.height = height;
			*/
		}
		
		public LayoutParams(LayoutParams source){
			/*
			this.width = source.width;
			this.height = source.height;
			*/
		}
		
		LayoutParams(){
		}
		
		protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr){
			
			// Original method
			/*
			{
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
        }
			*/
			//Return nothing
		}
		
		protected void resolveWithDirection(int layoutDirection){
			
			// Original method
			/*
			{
        }
			*/
			//Return nothing
		}
		
		public String debug(String output){
			
			// Original method
			/*
			{
            return output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }
			*/
			return "";
		}
		
		protected static String sizeToString(int size){
			
			// Original method
			/*
			{
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }
			*/
			return "";
		}
	}
	
	
	public static class MarginLayoutParams extends ViewGroup.LayoutParams {
		private DSTaintObject dsTaint = new DSTaintObject();
		
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
		
		public MarginLayoutParams(Context c, AttributeSet attrs){
			super();
			/* Original Method Too Long, Refer to Original Implementation */
		}
		
		public MarginLayoutParams(int width, int height){
			super(width, height);
		}
		
		public MarginLayoutParams(MarginLayoutParams source){
			/*
			this.width = source.width;
			this.height = source.height;
			this.leftMargin = source.leftMargin;
			this.topMargin = source.topMargin;
			this.rightMargin = source.rightMargin;
			this.bottomMargin = source.bottomMargin;
			this.startMargin = source.startMargin;
			this.endMargin = source.endMargin;
			*/
		}
		
		public MarginLayoutParams(LayoutParams source){
			super(source);
		}
		
		public void setMargins(int left, int top, int right, int bottom){
			dsTaint.addTaint(left);
			leftMargin = left;  //Preserved
			dsTaint.addTaint(top);
			topMargin = top;  //Preserved
			dsTaint.addTaint(right);
			rightMargin = right;  //Preserved
			dsTaint.addTaint(bottom);
			bottomMargin = bottom;  //Preserved
			
			// Original method
			/*
			{
            leftMargin = left;
            topMargin = top;
            rightMargin = right;
            bottomMargin = bottom;
        }
			*/
			//Return nothing
		}
		
		public void setMarginsRelative(int start, int top, int end, int bottom){
			dsTaint.addTaint(start);
			startMargin = start;  //Preserved
			dsTaint.addTaint(top);
			topMargin = top;  //Preserved
			dsTaint.addTaint(end);
			endMargin = end;  //Preserved
			dsTaint.addTaint(bottom);
			bottomMargin = bottom;  //Preserved
			
			// Original method
			/*
			{
            startMargin = start;
            topMargin = top;
            endMargin = end;
            bottomMargin = bottom;
        }
			*/
			//Return nothing
		}
		
		public int getMarginStart(){
			return dsTaint.getTaintInt();
			
			// Original method
			/*
			{
            return startMargin;
        }
			*/
		}
		
		public int getMarginEnd(){
			return dsTaint.getTaintInt();
			
			// Original method
			/*
			{
            return endMargin;
        }
			*/
		}
		
		public boolean isMarginRelative(){
			
			// Original method
			/*
			{
            return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }
			*/
			return false;
		}
		
		@Override protected void resolveWithDirection(int layoutDirection){
			
			// Original method
			/*
			{
            switch(layoutDirection) {
                case View.LAYOUT_DIRECTION_RTL:
                    leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
                    rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
                    break;
                case View.LAYOUT_DIRECTION_LTR:
                default:
                    leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
                    rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
                    break;
            }
        }
			*/
			//Return nothing
		}
	}
	
	
	private static final class TouchTarget {
		private DSTaintObject dsTaint = new DSTaintObject();
		
		private static final int MAX_RECYCLED = 32;
		private static final Object sRecycleLock = new Object();
		private static TouchTarget sRecycleBin;
		private static int sRecycledCount;
		public static final int ALL_POINTER_IDS = -1;
		public View child;
		public int pointerIdBits;
		public TouchTarget next;
		
		private TouchTarget(){
		}
		
		public static TouchTarget obtain(View child, int pointerIdBits){
			
			// Original method
			/*
			{
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
			*/
			return null;
		}
		
		public void recycle(){
			
			// Original method
			/*
			{
            synchronized (sRecycleLock) {
                if (sRecycledCount < MAX_RECYCLED) {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } else {
                    next = null;
                }
                child = null;
            }
        }
			*/
			//Return nothing
		}
	}
	
	
	private static final class HoverTarget {
		private DSTaintObject dsTaint = new DSTaintObject();
		
		private static final int MAX_RECYCLED = 32;
		private static final Object sRecycleLock = new Object();
		private static HoverTarget sRecycleBin;
		private static int sRecycledCount;
		public View child;
		public HoverTarget next;
		
		private HoverTarget(){
		}
		
		public static HoverTarget obtain(View child){
			
			// Original method
			/*
			{
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
			*/
			return null;
		}
		
		public void recycle(){
			
			// Original method
			/*
			{
            synchronized (sRecycleLock) {
                if (sRecycledCount < MAX_RECYCLED) {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } else {
                    next = null;
                }
                child = null;
            }
        }
			*/
			//Return nothing
		}
	}
	
}


