package android.widget;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import droidsafe.annotations.DSGenerator;

public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener, RemoteViewsAdapter.RemoteAdapterConnectionCallback {
    int mChoiceMode = CHOICE_MODE_NONE;
    ActionMode mChoiceActionMode;
    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    int mCheckedItemCount;
    SparseBooleanArray mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    int mLayoutMode = LAYOUT_NORMAL;
    AdapterDataSetObserver mDataSetObserver;
    ListAdapter mAdapter;
    private RemoteViewsAdapter mRemoteAdapter;
    private boolean mDeferNotifyDataSetChanged = false;
    boolean mDrawSelectorOnTop = false;
    Drawable mSelector;
    int mSelectorPosition = INVALID_POSITION;
    Rect mSelectorRect = new Rect();
    final RecycleBin mRecycler = new RecycleBin();
    int mSelectionLeftPadding = 0;
    int mSelectionTopPadding = 0;
    int mSelectionRightPadding = 0;
    int mSelectionBottomPadding = 0;
    Rect mListPadding = new Rect();
    int mWidthMeasureSpec = 0;
    View mScrollUp;
    View mScrollDown;
    boolean mCachingStarted;
    boolean mCachingActive;
    int mMotionPosition;
    int mMotionViewOriginalTop;
    int mMotionViewNewTop;
    int mMotionX;
    int mMotionY;
    int mTouchMode = TOUCH_MODE_REST;
    int mLastY;
    int mMotionCorrection;
    private VelocityTracker mVelocityTracker;
    private FlingRunnable mFlingRunnable;
    private PositionScroller mPositionScroller;
    int mSelectedTop = 0;
    boolean mStackFromBottom;
    boolean mScrollingCacheEnabled;
    boolean mFastScrollEnabled;
    private OnScrollListener mOnScrollListener;
    PopupWindow mPopup;
    EditText mTextFilter;
    private boolean mSmoothScrollbarEnabled = true;
    private boolean mTextFilterEnabled;
    private boolean mFiltered;
    private Rect mTouchFrame;
    int mResurrectToPosition = INVALID_POSITION;
    private ContextMenuInfo mContextMenuInfo = null;
    int mOverscrollMax;
    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
    private boolean mScrollProfilingStarted = false;
    private boolean mFlingProfilingStarted = false;
    private StrictMode.Span mScrollStrictSpan = null;
    private StrictMode.Span mFlingStrictSpan = null;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private AbsListView.PerformClick mPerformClick;
    private Runnable mTouchModeReset;
    private int mTranscriptMode;
    private int mCacheColorHint;
    private boolean mIsChildViewEnabled;
    private int mLastScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    private FastScroller mFastScroller;
    private boolean mGlobalLayoutListenerAddedFilter;
    private int mTouchSlop;
    private float mDensityScale;
    private InputConnection mDefInputConnection;
    private InputConnectionWrapper mPublicInputConnection;
    private Runnable mClearScrollingCache;
    private int mMinimumVelocity;
    private int mMaximumVelocity;
    private float mVelocityScale = 1.0f;
    final boolean[] mIsScrap = new boolean[1];
    private boolean mPopupHidden;
    private int mActivePointerId = INVALID_POINTER;
    int mOverscrollDistance;
    int mOverflingDistance;
    private EdgeEffect mEdgeGlowTop;
    private EdgeEffect mEdgeGlowBottom;
    private int mFirstPositionDistanceGuess;
    private int mLastPositionDistanceGuess;
    private int mDirection = 0;
    private boolean mForceTranscriptScroll;
    private int mGlowPaddingLeft;
    private int mGlowPaddingRight;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    boolean mIsAttached;
    private int mLastHandledItemCount;
    
    public AbsListView(Context context){
		super(context);
		/*
		initAbsListView();
		setVerticalScrollBarEnabled(true);
		TypedArray a = context.obtainStyledAttributes(R.styleable.View);
		initializeScrollbars(a);
		a.recycle();
		*/
	}

    
    public AbsListView(Context context, AttributeSet attrs){
		this(context, attrs, com.android.internal.R.attr.absListViewStyle);
	}

    
    public AbsListView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    private void initAbsListView(){
		// Original method
		/*
		{
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        mDensityScale = getContext().getResources().getDisplayMetrics().density;
    }
		*/
		//Return nothing
	}

    
    @Override public void setOverScrollMode(int mode){
		// Original method
		/*
		{
        if (mode != OVER_SCROLL_NEVER) {
            if (mEdgeGlowTop == null) {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            }
        } else {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(mode);
    }
		*/
		//Return nothing
	}

    
    @Override public void setAdapter(ListAdapter adapter){
		// Original method
		/*
		{
        if (adapter != null) {
            if (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
                    mCheckedIdStates == null) {
                mCheckedIdStates = new LongSparseArray<Integer>();
            }
        }
        if (mCheckStates != null) {
            mCheckStates.clear();
        }
        if (mCheckedIdStates != null) {
            mCheckedIdStates.clear();
        }
    }
		*/
		//Return nothing
	}

    
    public int getCheckedItemCount(){
		return getTaintInt();
		// Original method
		/*
		{
        return mCheckedItemCount;
    }
		*/
	}

    
    public boolean isItemChecked(int position){
		// Original method
		/*
		{
        if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null) {
            return mCheckStates.get(position);
        }
        return false;
    }
		*/
		return false;
	}

    
    public int getCheckedItemPosition(){
		// Original method
		/*
		{
        if (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1) {
            return mCheckStates.keyAt(0);
        }
        return INVALID_POSITION;
    }
		*/
		return 0;
	}

    
    public SparseBooleanArray getCheckedItemPositions(){
		// Original method
		/*
		{
        if (mChoiceMode != CHOICE_MODE_NONE) {
            return mCheckStates;
        }
        return null;
    }
		*/
		return null;
	}

    
    public long[] getCheckedItemIds(){
		// Original method
		/*
		{
        if (mChoiceMode == CHOICE_MODE_NONE || mCheckedIdStates == null || mAdapter == null) {
            return new long[0];
        }
        final LongSparseArray<Integer> idStates = mCheckedIdStates;
        final int count = idStates.size();
        final long[] ids = new long[count];
        for (int i = 0; i < count; i++) {
            ids[i] = idStates.keyAt(i);
        }
        return ids;
    }
		*/
		return null;
	}

    
    public void clearChoices(){
		// Original method
		/*
		{
        if (mCheckStates != null) {
            mCheckStates.clear();
        }
        if (mCheckedIdStates != null) {
            mCheckedIdStates.clear();
        }
        mCheckedItemCount = 0;
    }
		*/
		//Return nothing
	}

    
    public void setItemChecked(int position, boolean value){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override public boolean performItemClick(View view, int position, long id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    public int getChoiceMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mChoiceMode;
    }
		*/
	}

    
    public void setChoiceMode(int choiceMode){
		addTaint(choiceMode);
		mChoiceMode = choiceMode;  //Preserved
		// Original method
		/*
		{
        mChoiceMode = choiceMode;
        if (mChoiceActionMode != null) {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        }
        if (mChoiceMode != CHOICE_MODE_NONE) {
            if (mCheckStates == null) {
                mCheckStates = new SparseBooleanArray();
            }
            if (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds()) {
                mCheckedIdStates = new LongSparseArray<Integer>();
            }
            if (mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener){
		// Original method
		/*
		{
        if (mMultiChoiceModeCallback == null) {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        mMultiChoiceModeCallback.setWrapped(listener);
    }
		*/
		//Return nothing
	}

    
    private boolean contentFits(){
		// Original method
		/*
		{
        final int childCount = getChildCount();
        if (childCount == 0) return true;
        if (childCount != mItemCount) return false;
        return getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom;
    }
		*/
		return false;
	}

    
    public void setFastScrollEnabled(boolean enabled){
		addTaint(enabled);
		mFastScrollEnabled = enabled;  //Preserved
		// Original method
		/*
		{
        mFastScrollEnabled = enabled;
        if (enabled) {
            if (mFastScroller == null) {
                mFastScroller = new FastScroller(getContext(), this);
            }
        } else {
            if (mFastScroller != null) {
                mFastScroller.stop();
                mFastScroller = null;
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void setFastScrollAlwaysVisible(boolean alwaysShow){
		// Original method
		/*
		{
        if (alwaysShow && !mFastScrollEnabled) {
            setFastScrollEnabled(true);
        }
        if (mFastScroller != null) {
            mFastScroller.setAlwaysShow(alwaysShow);
        }
        computeOpaqueFlags();
        recomputePadding();
    }
		*/
		//Return nothing
	}

    
    public boolean isFastScrollAlwaysVisible(){
		// Original method
		/*
		{
        return mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled();
    }
		*/
		return false;
	}

    
    @Override public int getVerticalScrollbarWidth(){
		// Original method
		/*
		{
        if (isFastScrollAlwaysVisible()) {
            return Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth());
        }
        return super.getVerticalScrollbarWidth();
    }
		*/
		return 0;
	}

    
    @ViewDebug.ExportedProperty public boolean isFastScrollEnabled(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mFastScrollEnabled;
    }
		*/
	}

    
    @Override public void setVerticalScrollbarPosition(int position){
		// Original method
		/*
		{
        super.setVerticalScrollbarPosition(position);
        if (mFastScroller != null) {
            mFastScroller.setScrollbarPosition(position);
        }
    }
		*/
		//Return nothing
	}

    
    @Override protected boolean isVerticalScrollBarHidden(){
		// Original method
		/*
		{
        return mFastScroller != null && mFastScroller.isVisible();
    }
		*/
		return false;
	}

    
    public void setSmoothScrollbarEnabled(boolean enabled){
		addTaint(enabled);
		mSmoothScrollbarEnabled = enabled;  //Preserved
		// Original method
		/*
		{
        mSmoothScrollbarEnabled = enabled;
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty public boolean isSmoothScrollbarEnabled(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mSmoothScrollbarEnabled;
    }
		*/
	}

    
    public void setOnScrollListener(OnScrollListener l){
		mOnScrollListener = l;  //Preserved
		mOnScrollListener.onScroll(this, 1, 10, 10);
		mOnScrollListener.onScrollStateChanged(this, 1);
		// Original method
		/*
		{
        mOnScrollListener = l;
        invokeOnItemScrollListener();
    }
		*/
		//Return nothing
	}

    
    void invokeOnItemScrollListener(){
		// Original method
		/*
		{
        if (mFastScroller != null) {
            mFastScroller.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        }
        if (mOnScrollListener != null) {
            mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        }
        onScrollChanged(0, 0, 0, 0); 
    }
		*/
		//Return nothing
	}

    
    @Override public void sendAccessibilityEvent(int eventType){
		// Original method
		/*
		{
        if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            final int firstVisiblePosition = getFirstVisiblePosition();
            final int lastVisiblePosition = getLastVisiblePosition();
            if (mLastAccessibilityScrollEventFromIndex == firstVisiblePosition
                    && mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;   
            } else {
                mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            }
        }
        super.sendAccessibilityEvent(eventType);
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty public boolean isScrollingCacheEnabled(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mScrollingCacheEnabled;
    }
		*/
	}

    
    public void setScrollingCacheEnabled(boolean enabled){
		addTaint(enabled);
		mScrollingCacheEnabled = enabled;  //Preserved
		// Original method
		/*
		{
        if (mScrollingCacheEnabled && !enabled) {
            clearScrollingCache();
        }
        mScrollingCacheEnabled = enabled;
    }
		*/
		//Return nothing
	}

    
    public void setTextFilterEnabled(boolean textFilterEnabled){
		addTaint(textFilterEnabled);
		mTextFilterEnabled = textFilterEnabled;  //Preserved
		// Original method
		/*
		{
        mTextFilterEnabled = textFilterEnabled;
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty public boolean isTextFilterEnabled(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mTextFilterEnabled;
    }
		*/
	}

    
    @Override public void getFocusedRect(Rect r){
		// Original method
		/*
		{
        View view = getSelectedView();
        if (view != null && view.getParent() == this) {
            view.getFocusedRect(r);
            offsetDescendantRectToMyCoords(view, r);
        } else {
            super.getFocusedRect(r);
        }
    }
		*/
		//Return nothing
	}

    
    private void useDefaultSelector(){
		// Original method
		/*
		{
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty public boolean isStackFromBottom(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mStackFromBottom;
    }
		*/
	}

    
    public void setStackFromBottom(boolean stackFromBottom){
		// Original method
		/*
		{
        if (mStackFromBottom != stackFromBottom) {
            mStackFromBottom = stackFromBottom;
            requestLayoutIfNecessary();
        }
    }
		*/
		//Return nothing
	}

    
    void requestLayoutIfNecessary(){
		// Original method
		/*
		{
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }
		*/
		//Return nothing
	}

    
    @Override public Parcelable onSaveInstanceState(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @Override public void onRestoreInstanceState(Parcelable state){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    private boolean acceptFilter(){
		// Original method
		/*
		{
        return mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null;
    }
		*/
		return false;
	}

    
    public void setFilterText(String filterText){
		// Original method
		/*
		{
        if (mTextFilterEnabled && !TextUtils.isEmpty(filterText)) {
            createTextFilter(false);
            mTextFilter.setText(filterText);
            mTextFilter.setSelection(filterText.length());
            if (mAdapter instanceof Filterable) {
                if (mPopup == null) {
                    Filter f = ((Filterable) mAdapter).getFilter();
                    f.filter(filterText);
                }
                mFiltered = true;
                mDataSetObserver.clearSavedState();
            }
        }
    }
		*/
		//Return nothing
	}

    
    public CharSequence getTextFilter(){
		// Original method
		/*
		{
        if (mTextFilterEnabled && mTextFilter != null) {
            return mTextFilter.getText();
        }
        return null;
    }
		*/
		return null;
	}

    
    @Override protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect){
		// Original method
		/*
		{
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus && mSelectedPosition < 0 && !isInTouchMode()) {
            if (!mIsAttached && mAdapter != null) {
                mDataChanged = true;
                mOldItemCount = mItemCount;
                mItemCount = mAdapter.getCount();
            }
            resurrectSelection();
        }
    }
		*/
		//Return nothing
	}

    
    @Override public void requestLayout(){
		// Original method
		/*
		{
        if (!mBlockLayoutRequests && !mInLayout) {
            super.requestLayout();
        }
    }
		*/
		//Return nothing
	}

    
    void resetList(){
		// Original method
		/*
		{
        removeAllViewsInLayout();
        mFirstPosition = 0;
        mDataChanged = false;
        mNeedSync = false;
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        setSelectedPositionInt(INVALID_POSITION);
        setNextSelectedPositionInt(INVALID_POSITION);
        mSelectedTop = 0;
        mSelectorPosition = INVALID_POSITION;
        mSelectorRect.setEmpty();
        invalidate();
    }
		*/
		//Return nothing
	}

    
    @Override protected int computeVerticalScrollExtent(){
		// Original method
		/*
		{
        final int count = getChildCount();
        if (count > 0) {
            if (mSmoothScrollbarEnabled) {
                int extent = count * 100;
                View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
                if (height > 0) {
                    extent += (top * 100) / height;
                }
                view = getChildAt(count - 1);
                final int bottom = view.getBottom();
                height = view.getHeight();
                if (height > 0) {
                    extent -= ((bottom - getHeight()) * 100) / height;
                }
                return extent;
            } else {
                return 1;
            }
        }
        return 0;
    }
		*/
		return 0;
	}

    
    @Override protected int computeVerticalScrollOffset(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return 0;
	}

    
    @Override protected int computeVerticalScrollRange(){
		// Original method
		/*
		{
        int result;
        if (mSmoothScrollbarEnabled) {
            result = Math.max(mItemCount * 100, 0);
            if (mScrollY != 0) {
                result += Math.abs((int) ((float) mScrollY / getHeight() * mItemCount * 100));
            }
        } else {
            result = mItemCount;
        }
        return result;
    }
		*/
		return 0;
	}

    
    @Override protected float getTopFadingEdgeStrength(){
		// Original method
		/*
		{
        final int count = getChildCount();
        final float fadeEdge = super.getTopFadingEdgeStrength();
        if (count == 0) {
            return fadeEdge;
        } else {
            if (mFirstPosition > 0) {
                return 1.0f;
            }
            final int top = getChildAt(0).getTop();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
            return top < mPaddingTop ? (float) -(top - mPaddingTop) / fadeLength : fadeEdge;
        }
    }
		*/
		return 0;
	}

    
    @Override protected float getBottomFadingEdgeStrength(){
		// Original method
		/*
		{
        final int count = getChildCount();
        final float fadeEdge = super.getBottomFadingEdgeStrength();
        if (count == 0) {
            return fadeEdge;
        } else {
            if (mFirstPosition + count - 1 < mItemCount - 1) {
                return 1.0f;
            }
            final int bottom = getChildAt(count - 1).getBottom();
            final int height = getHeight();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
            return bottom > height - mPaddingBottom ?
                    (float) (bottom - height + mPaddingBottom) / fadeLength : fadeEdge;
        }
    }
		*/
		return 0;
	}

    
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override protected void onLayout(boolean changed, int l, int t, int r, int b){
		// Original method
		/*
		{
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).forceLayout();
            }
            mRecycler.markChildrenDirty();
        }
        if (mFastScroller != null && mItemCount != mOldItemCount) {
            mFastScroller.onItemCountChanged(mOldItemCount, mItemCount);
        }
        layoutChildren();
        mInLayout = false;
        mOverscrollMax = (b - t) / OVERSCROLL_LIMIT_DIVISOR;
    }
		*/
		//Return nothing
	}

    
    @Override protected boolean setFrame(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        final boolean changed = super.setFrame(left, top, right, bottom);
        if (changed) {
            final boolean visible = getWindowVisibility() == View.VISIBLE;
            if (mFiltered && visible && mPopup != null && mPopup.isShowing()) {
                positionPopup();
            }
        }
        return changed;
    }
		*/
		return false;
	}

    
    protected void layoutChildren(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    void updateScrollIndicators(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override @ViewDebug.ExportedProperty public View getSelectedView(){
		// Original method
		/*
		{
        if (mItemCount > 0 && mSelectedPosition >= 0) {
            return getChildAt(mSelectedPosition - mFirstPosition);
        } else {
            return null;
        }
    }
		*/
		return null;
	}

    
    public int getListPaddingTop(){
		// Original method
		/*
		{
        return mListPadding.top;
    }
		*/
		return 0;
	}

    
    public int getListPaddingBottom(){
		// Original method
		/*
		{
        return mListPadding.bottom;
    }
		*/
		return 0;
	}

    
    public int getListPaddingLeft(){
		// Original method
		/*
		{
        return mListPadding.left;
    }
		*/
		return 0;
	}

    
    public int getListPaddingRight(){
		// Original method
		/*
		{
        return mListPadding.right;
    }
		*/
		return 0;
	}

    
    View obtainView(int position, boolean[] isScrap){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    void positionSelector(int position, View sel){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    private void positionSelector(int l, int t, int r, int b){
		// Original method
		/*
		{
        mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                + mSelectionRightPadding, b + mSelectionBottomPadding);
    }
		*/
		//Return nothing
	}

    
    @Override protected void dispatchDraw(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override protected boolean isPaddingOffsetRequired(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) != CLIP_TO_PADDING_MASK;
    }
		*/
		return false;
	}

    
    @Override protected int getLeftPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft;
    }
		*/
		return 0;
	}

    
    @Override protected int getTopPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop;
    }
		*/
		return 0;
	}

    
    @Override protected int getRightPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight;
    }
		*/
		return 0;
	}

    
    @Override protected int getBottomPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingBottom;
    }
		*/
		return 0;
	}

    
    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh){
		// Original method
		/*
		{
        if (getChildCount() > 0) {
            mDataChanged = true;
            rememberSyncState();
        }
        if (mFastScroller != null) {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        }
    }
		*/
		//Return nothing
	}

    
    boolean touchModeDrawsInPressedState(){
		// Original method
		/*
		{
        switch (mTouchMode) {
        case TOUCH_MODE_TAP:
        case TOUCH_MODE_DONE_WAITING:
            return true;
        default:
            return false;
        }
    }
		*/
		return false;
	}

    
    boolean shouldShowSelector(){
		// Original method
		/*
		{
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }
		*/
		return false;
	}

    
    private void drawSelector(Canvas canvas){
		// Original method
		/*
		{
        if (!mSelectorRect.isEmpty()) {
            final Drawable selector = mSelector;
            selector.setBounds(mSelectorRect);
            selector.draw(canvas);
        }
    }
		*/
		//Return nothing
	}

    
    public void setDrawSelectorOnTop(boolean onTop){
		addTaint(onTop);
		mDrawSelectorOnTop = onTop;  //Preserved
		// Original method
		/*
		{
        mDrawSelectorOnTop = onTop;
    }
		*/
		//Return nothing
	}

    
    public void setSelector(int resID){
		// Original method
		/*
		{
        setSelector(getResources().getDrawable(resID));
    }
		*/
		//Return nothing
	}

    
    public void setSelector(Drawable sel){
		mSelector = sel;  //Preserved
		// Original method
		/*
		{
        if (mSelector != null) {
            mSelector.setCallback(null);
            unscheduleDrawable(mSelector);
        }
        mSelector = sel;
        Rect padding = new Rect();
        sel.getPadding(padding);
        mSelectionLeftPadding = padding.left;
        mSelectionTopPadding = padding.top;
        mSelectionRightPadding = padding.right;
        mSelectionBottomPadding = padding.bottom;
        sel.setCallback(this);
        updateSelectorState();
    }
		*/
		//Return nothing
	}

    
    public Drawable getSelector(){
        return mSelector;
	}

    
    void keyPressed(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void setScrollIndicators(View up, View down){
		mScrollUp = up;  //Preserved
		mScrollDown = down;  //Preserved
		// Original method
		/*
		{
        mScrollUp = up;
        mScrollDown = down;
    }
		*/
		//Return nothing
	}

    
    void updateSelectorState(){
		// Original method
		/*
		{
        if (mSelector != null) {
            if (shouldShowSelector()) {
                mSelector.setState(getDrawableState());
            } else {
                mSelector.setState(StateSet.NOTHING);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @Override protected void drawableStateChanged(){
		// Original method
		/*
		{
        super.drawableStateChanged();
        updateSelectorState();
    }
		*/
		//Return nothing
	}

    
    @Override protected int[] onCreateDrawableState(int extraSpace){
		// Original method
		/*
		{
        if (mIsChildViewEnabled) {
            return super.onCreateDrawableState(extraSpace);
        }
        final int enabledState = ENABLED_STATE_SET[0];
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        int enabledPos = -1;
        for (int i = state.length - 1; i >= 0; i--) {
            if (state[i] == enabledState) {
                enabledPos = i;
                break;
            }
        }
        if (enabledPos >= 0) {
            System.arraycopy(state, enabledPos + 1, state, enabledPos,
                    state.length - enabledPos - 1);
        }
        return state;
    }
		*/
		return null;
	}

    
    @Override public boolean verifyDrawable(Drawable dr){
		// Original method
		/*
		{
        return mSelector == dr || super.verifyDrawable(dr);
    }
		*/
		return false;
	}

    
    @Override public void jumpDrawablesToCurrentState(){
		// Original method
		/*
		{
        super.jumpDrawablesToCurrentState();
        if (mSelector != null) mSelector.jumpToCurrentState();
    }
		*/
		//Return nothing
	}

    
    @Override protected void onAttachedToWindow(){
		// Original method
		/*
		{
        super.onAttachedToWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
        if (mTextFilterEnabled && mPopup != null && !mGlobalLayoutListenerAddedFilter) {
            treeObserver.addOnGlobalLayoutListener(this);
        }
        if (mAdapter != null && mDataSetObserver == null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        }
        mIsAttached = true;
    }
		*/
		//Return nothing
	}

    
    @Override protected void onDetachedFromWindow(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override public void onWindowFocusChanged(boolean hasWindowFocus){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    ContextMenuInfo createContextMenuInfo(View view, int position, long id){
		// Original method
		/*
		{
        return new AdapterContextMenuInfo(view, position, id);
    }
		*/
		return null;
	}

    
    boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @Override protected ContextMenuInfo getContextMenuInfo(){
		return (ContextMenuInfo)getTaint();
		// Original method
		/*
		{
        return mContextMenuInfo;
    }
		*/
	}

    
    @Override public boolean showContextMenu(float x, float y, int metaState){
		// Original method
		/*
		{
        final int position = pointToPosition((int)x, (int)y);
        if (position != INVALID_POSITION) {
            final long id = mAdapter.getItemId(position);
            View child = getChildAt(position - mFirstPosition);
            if (child != null) {
                mContextMenuInfo = createContextMenuInfo(child, position, id);
                return super.showContextMenuForChild(AbsListView.this);
            }
        }
        return super.showContextMenu(x, y, metaState);
    }
		*/
		return false;
	}

    
    @Override public boolean showContextMenuForChild(View originalView){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @Override public boolean onKeyDown(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @Override public boolean onKeyUp(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() &&
                    mSelectedPosition >= 0 && mAdapter != null &&
                    mSelectedPosition < mAdapter.getCount()) {
                final View view = getChildAt(mSelectedPosition - mFirstPosition);
                if (view != null) {
                    performItemClick(view, mSelectedPosition, mSelectedRowId);
                    view.setPressed(false);
                }
                setPressed(false);
                return true;
            }
            break;
        }
        return super.onKeyUp(keyCode, event);
    }
		*/
		return false;
	}

    
    @Override protected void dispatchSetPressed(boolean pressed){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    public int pointToPosition(int x, int y){
		// Original method
		/*
		{
        Rect frame = mTouchFrame;
        if (frame == null) {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        }
        final int count = getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            final View child = getChildAt(i);
            if (child.getVisibility() == View.VISIBLE) {
                child.getHitRect(frame);
                if (frame.contains(x, y)) {
                    return mFirstPosition + i;
                }
            }
        }
        return INVALID_POSITION;
    }
		*/
		return 0;
	}

    
    public long pointToRowId(int x, int y){
		// Original method
		/*
		{
        int position = pointToPosition(x, y);
        if (position >= 0) {
            return mAdapter.getItemId(position);
        }
        return INVALID_ROW_ID;
    }
		*/
		return 0;
	}

    
    private boolean startScrollIfNeeded(int y){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    private void scrollIfNeeded(int y){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void onTouchModeChanged(boolean isInTouchMode){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override public boolean onTouchEvent(MotionEvent ev){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @Override protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY){
		// Original method
		/*
		{
        if (mScrollY != scrollY) {
            onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }
		*/
		//Return nothing
	}

    
    @Override public boolean onGenericMotionEvent(MotionEvent event){
		// Original method
		/*
		{
        if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_SCROLL: {
                    if (mTouchMode == TOUCH_MODE_REST) {
                        final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                        if (vscroll != 0) {
                            final int delta = (int) (vscroll * getVerticalScrollFactor());
                            if (!trackMotionScroll(delta, delta)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return super.onGenericMotionEvent(event);
    }
		*/
		return false;
	}

    
    @Override public void draw(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding){
		addTaint(leftPadding);
		mGlowPaddingLeft = leftPadding;  //Preserved
		addTaint(rightPadding);
		mGlowPaddingRight = rightPadding;  //Preserved
		// Original method
		/*
		{
        mGlowPaddingLeft = leftPadding;
        mGlowPaddingRight = rightPadding;
    }
		*/
		//Return nothing
	}

    
    private void initOrResetVelocityTracker(){
		// Original method
		/*
		{
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        } else {
            mVelocityTracker.clear();
        }
    }
		*/
		//Return nothing
	}

    
    private void initVelocityTrackerIfNotExists(){
		// Original method
		/*
		{
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }
		*/
		//Return nothing
	}

    
    private void recycleVelocityTracker(){
		// Original method
		/*
		{
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
		*/
		//Return nothing
	}

    
    @Override public void requestDisallowInterceptTouchEvent(boolean disallowIntercept){
		// Original method
		/*
		{
        if (disallowIntercept) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
		*/
		//Return nothing
	}

    
    @Override public boolean onInterceptTouchEvent(MotionEvent ev){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    private void onSecondaryPointerUp(MotionEvent ev){
		// Original method
		/*
		{
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == mActivePointerId) {
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mMotionX = (int) ev.getX(newPointerIndex);
            mMotionY = (int) ev.getY(newPointerIndex);
            mMotionCorrection = 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
        }
    }
		*/
		//Return nothing
	}

    
    @Override public void addTouchables(ArrayList<View> views){
		// Original method
		/*
		{
        final int count = getChildCount();
        final int firstPosition = mFirstPosition;
        final ListAdapter adapter = mAdapter;
        if (adapter == null) {
            return;
        }
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (adapter.isEnabled(firstPosition + i)) {
                views.add(child);
            }
            child.addTouchables(views);
        }
    }
		*/
		//Return nothing
	}

    
    void reportScrollStateChange(int newState){
		// Original method
		/*
		{
        if (newState != mLastScrollState) {
            if (mOnScrollListener != null) {
                mLastScrollState = newState;
                mOnScrollListener.onScrollStateChanged(this, newState);
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void setFriction(float friction){
		// Original method
		/*
		{
        if (mFlingRunnable == null) {
            mFlingRunnable = new FlingRunnable();
        }
        mFlingRunnable.mScroller.setFriction(friction);
    }
		*/
		//Return nothing
	}

    
    public void setVelocityScale(float scale){
		addTaint(scale);
		mVelocityScale = scale;  //Preserved
		// Original method
		/*
		{
        mVelocityScale = scale;
    }
		*/
		//Return nothing
	}

    
    public void smoothScrollToPosition(int position){
		// Original method
		/*
		{
        if (mPositionScroller == null) {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.start(position);
    }
		*/
		//Return nothing
	}

    
    public void smoothScrollToPositionFromTop(int position, int offset, int duration){
		// Original method
		/*
		{
        if (mPositionScroller == null) {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.startWithOffset(position, offset, duration);
    }
		*/
		//Return nothing
	}

    
    public void smoothScrollToPositionFromTop(int position, int offset){
		// Original method
		/*
		{
        if (mPositionScroller == null) {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.startWithOffset(position, offset);
    }
		*/
		//Return nothing
	}

    
    public void smoothScrollToPosition(int position, int boundPosition){
		// Original method
		/*
		{
        if (mPositionScroller == null) {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.start(position, boundPosition);
    }
		*/
		//Return nothing
	}

    
    public void smoothScrollBy(int distance, int duration){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    void smoothScrollByOffset(int position){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    private void createScrollingCache(){
		// Original method
		/*
		{
        if (mScrollingCacheEnabled && !mCachingStarted) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingStarted = mCachingActive = true;
        }
    }
		*/
		//Return nothing
	}

    
    private void clearScrollingCache(){
		// Original method
		/*
		{
        if (mClearScrollingCache == null) {
            mClearScrollingCache = new Runnable() {
                public void run() {
                    if (mCachingStarted) {
                        mCachingStarted = mCachingActive = false;
                        setChildrenDrawnWithCacheEnabled(false);
                        if ((mPersistentDrawingCache & PERSISTENT_SCROLLING_CACHE) == 0) {
                            setChildrenDrawingCacheEnabled(false);
                        }
                        if (!isAlwaysDrawnWithCacheEnabled()) {
                            invalidate();
                        }
                    }
                }
            };
        }
        post(mClearScrollingCache);
    }
		*/
		//Return nothing
	}

    
    boolean trackMotionScroll(int deltaY, int incrementalDeltaY){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    int getHeaderViewsCount(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    int getFooterViewsCount(){
		// Original method
		/*
		{
        return 0;
    }
		*/
		return 0;
	}

    
    abstract void fillGap(boolean down);

    
    void hideSelector(){
		// Original method
		/*
		{
        if (mSelectedPosition != INVALID_POSITION) {
            if (mLayoutMode != LAYOUT_SPECIFIC) {
                mResurrectToPosition = mSelectedPosition;
            }
            if (mNextSelectedPosition >= 0 && mNextSelectedPosition != mSelectedPosition) {
                mResurrectToPosition = mNextSelectedPosition;
            }
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectedTop = 0;
        }
    }
		*/
		//Return nothing
	}

    
    int reconcileSelectedPosition(){
		return getTaintInt();
		// Original method
		/*
		{
        int position = mSelectedPosition;
        if (position < 0) {
            position = mResurrectToPosition;
        }
        position = Math.max(0, position);
        position = Math.min(position, mItemCount - 1);
        return position;
    }
		*/
	}

    
    abstract int findMotionRow(int y);

    
    int findClosestMotionRow(int y){
		// Original method
		/*
		{
        final int childCount = getChildCount();
        if (childCount == 0) {
            return INVALID_POSITION;
        }
        final int motionRow = findMotionRow(y);
        return motionRow != INVALID_POSITION ? motionRow : mFirstPosition + childCount - 1;
    }
		*/
		return 0;
	}

    
    public void invalidateViews(){
		// Original method
		/*
		{
        mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }
		*/
		//Return nothing
	}

    
    boolean resurrectSelectionIfNeeded(){
		// Original method
		/*
		{
        if (mSelectedPosition < 0 && resurrectSelection()) {
            updateSelectorState();
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    abstract void setSelectionInt(int position);

    
    boolean resurrectSelection(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    void confirmCheckedPositionsById(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override protected void handleDataChanged(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @Override protected void onDisplayHint(int hint){
		// Original method
		/*
		{
        super.onDisplayHint(hint);
        switch (hint) {
            case INVISIBLE:
                if (mPopup != null && mPopup.isShowing()) {
                    dismissPopup();
                }
                break;
            case VISIBLE:
                if (mFiltered && mPopup != null && !mPopup.isShowing()) {
                    showPopup();
                }
                break;
        }
        mPopupHidden = hint == INVISIBLE;
    }
		*/
		//Return nothing
	}

    
    private void dismissPopup(){
		// Original method
		/*
		{
        if (mPopup != null) {
            mPopup.dismiss();
        }
    }
		*/
		//Return nothing
	}

    
    private void showPopup(){
		// Original method
		/*
		{
        if (getWindowVisibility() == View.VISIBLE) {
            createTextFilter(true);
            positionPopup();
            checkFocus();
        }
    }
		*/
		//Return nothing
	}

    
    private void positionPopup(){
		// Original method
		/*
		{
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        final int[] xy = new int[2];
        getLocationOnScreen(xy);
        final int bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
        if (!mPopup.isShowing()) {
            mPopup.showAtLocation(this, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    xy[0], bottomGap);
        } else {
            mPopup.update(xy[0], bottomGap, -1, -1);
        }
    }
		*/
		//Return nothing
	}

    
    static int getDistance(Rect source, Rect dest, int direction){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return 0;
	}

    
    @Override protected boolean isInFilterMode(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mFiltered;
    }
		*/
	}

    
    boolean sendToTextFilter(int keyCode, int count, KeyEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @Override public InputConnection onCreateInputConnection(EditorInfo outAttrs){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @Override public boolean checkInputConnectionProxy(View view){
		// Original method
		/*
		{
        return view == mTextFilter;
    }
		*/
		return false;
	}

    
    private void createTextFilter(boolean animateEntrance){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void clearTextFilter(){
		// Original method
		/*
		{
        if (mFiltered) {
            mTextFilter.setText("");
            mFiltered = false;
            if (mPopup != null && mPopup.isShowing()) {
                dismissPopup();
            }
        }
    }
		*/
		//Return nothing
	}

    
    public boolean hasTextFilter(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mFiltered;
    }
		*/
	}

    
    public void onGlobalLayout(){
		// Original method
		/*
		{
        if (isShown()) {
            if (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden) {
                showPopup();
            }
        } else {
            if (mPopup != null && mPopup.isShowing()) {
                dismissPopup();
            }
        }
    }
		*/
		//Return nothing
	}

    
    public void beforeTextChanged(CharSequence s, int start, int count, int after){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    public void onTextChanged(CharSequence s, int start, int before, int count){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void afterTextChanged(Editable s){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    public void onFilterComplete(int count){
		// Original method
		/*
		{
        if (mSelectedPosition < 0 && count > 0) {
            mResurrectToPosition = INVALID_POSITION;
            resurrectSelection();
        }
    }
		*/
		//Return nothing
	}

    
    @Override protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p){
		// Original method
		/*
		{
        return new LayoutParams(p);
    }
		*/
		return null;
	}

    
    @Override public LayoutParams generateLayoutParams(AttributeSet attrs){
		// Original method
		/*
		{
        return new AbsListView.LayoutParams(getContext(), attrs);
    }
		*/
		return null;
	}

    
    @Override protected boolean checkLayoutParams(ViewGroup.LayoutParams p){
		// Original method
		/*
		{
        return p instanceof AbsListView.LayoutParams;
    }
		*/
		return false;
	}

    
    public void setTranscriptMode(int mode){
		addTaint(mode);
		mTranscriptMode = mode;  //Preserved
		// Original method
		/*
		{
        mTranscriptMode = mode;
    }
		*/
		//Return nothing
	}

    
    public int getTranscriptMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTranscriptMode;
    }
		*/
	}

    
    @Override public int getSolidColor(){
		return getTaintInt();
		// Original method
		/*
		{
        return mCacheColorHint;
    }
		*/
	}

    
    public void setCacheColorHint(int color){
		// Original method
		/*
		{
        if (color != mCacheColorHint) {
            mCacheColorHint = color;
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                getChildAt(i).setDrawingCacheBackgroundColor(color);
            }
            mRecycler.setCacheColorHint(color);
        }
    }
		*/
		//Return nothing
	}

    
    @ViewDebug.ExportedProperty(category="drawing") public int getCacheColorHint(){
		return getTaintInt();
		// Original method
		/*
		{
        return mCacheColorHint;
    }
		*/
	}

    
    public void reclaimViews(List<View> views){
		// Original method
		/*
		{
        int childCount = getChildCount();
        RecyclerListener listener = mRecycler.mRecyclerListener;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
            if (lp != null && mRecycler.shouldRecycleViewType(lp.viewType)) {
                views.add(child);
                if (listener != null) {
                    listener.onMovedToScrapHeap(child);
                }
            }
        }
        mRecycler.reclaimScrapViews(views);
        removeAllViewsInLayout();
    }
		*/
		//Return nothing
	}

    
    @Override protected boolean onConsistencyCheck(int consistency){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    private boolean checkScrap(ArrayList<View> scrap){
		// Original method
		/*
		{
        if (scrap == null) return true;
        boolean result = true;
        final int count = scrap.size();
        for (int i = 0; i < count; i++) {
            final View view = scrap.get(i);
            if (view.getParent() != null) {
                result = false;
                Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
            }
            if (indexOfChild(view) >= 0) {
                result = false;
                Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap that is also a direct child: " + view);
            }
        }
        return result;
    }
		*/
		return false;
	}

    
    private void finishGlows(){
		// Original method
		/*
		{
        if (mEdgeGlowTop != null) {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        }
    }
		*/
		//Return nothing
	}

    
    public void setRemoteViewsAdapter(Intent intent){
		// Original method
		/*
		{
        if (mRemoteAdapter != null) {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteAdapter.getRemoteViewsServiceIntent());
            if (fcNew.equals(fcOld)) {
                return;
            }
        }
        mDeferNotifyDataSetChanged = false;
        mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
    }
		*/
		//Return nothing
	}

    
    public void deferNotifyDataSetChanged(){
		// Original method
		/*
		{
        mDeferNotifyDataSetChanged = true;
    }
		*/
		//Return nothing
	}

    
    public boolean onRemoteAdapterConnected(){
		// Original method
		/*
		{
        if (mRemoteAdapter != mAdapter) {
            setAdapter(mRemoteAdapter);
            if (mDeferNotifyDataSetChanged) {
                mRemoteAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            }
            return false;
        } else if (mRemoteAdapter != null) {
            mRemoteAdapter.superNotifyDataSetChanged();
            return true;
        }
        return false;
    }
		*/
		return false;
	}

    
    public void onRemoteAdapterDisconnected(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    public void setRecyclerListener(RecyclerListener listener){
		// Original method
		/*
		{
        mRecycler.mRecyclerListener = listener;
    }
		*/
		//Return nothing
	}

    
    static View retrieveFromScrap(ArrayList<View> scrapViews, int position){
		// Original method
		/*
		{
        int size = scrapViews.size();
        if (size > 0) {
            for (int i=0; i<size; i++) {
                View view = scrapViews.get(i);
                if (((AbsListView.LayoutParams)view.getLayoutParams())
                        .scrappedFromPosition == position) {
                    scrapViews.remove(i);
                    return view;
                }
            }
            return scrapViews.remove(size - 1);
        } else {
            return null;
        }
    }
		*/
		return null;
	}

    
    static class SavedState extends BaseSavedState {
        long selectedId;
        long firstId;
        int viewTop;
        int position;
        int height;
        String filter;
        boolean inActionMode;
        int checkedItemCount;
        SparseBooleanArray checkState;
        LongSparseArray<Integer> checkIdState;
        
        SavedState(Parcelable superState){
			super(superState);
		}

        
        private SavedState(Parcel in){
			super(in);
			/*
			selectedId = in.readLong();
			firstId = in.readLong();
			viewTop = in.readInt();
			position = in.readInt();
			height = in.readInt();
			filter = in.readString();
			inActionMode = in.readByte() != 0;
			checkedItemCount = in.readInt();
			checkState = in.readSparseBooleanArray();
			final int N = in.readInt();
			if (N > 0) {
                checkIdState = new LongSparseArray<Integer>();
                for (int i=0; i<N; i++) {
                    final long key = in.readLong();
                    final int value = in.readInt();
                    checkIdState.put(key, value);
                }
            }
			*/
		}

        
        @Override public void writeToParcel(Parcel out, int flags){
			// Original method
			/*
			{
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeLong(firstId);
            out.writeInt(viewTop);
            out.writeInt(position);
            out.writeInt(height);
            out.writeString(filter);
            out.writeByte((byte) (inActionMode ? 1 : 0));
            out.writeInt(checkedItemCount);
            out.writeSparseBooleanArray(checkState);
            final int N = checkIdState != null ? checkIdState.size() : 0;
            out.writeInt(N);
            for (int i=0; i<N; i++) {
                out.writeLong(checkIdState.keyAt(i));
                out.writeInt(checkIdState.valueAt(i));
            }
        }
			*/
			//Return nothing
		}

        
        @Override public String toString(){
			// Original method
			/*
			{
            return "AbsListView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " firstId=" + firstId
                    + " viewTop=" + viewTop
                    + " position=" + position
                    + " height=" + height
                    + " filter=" + filter
                    + " checkState=" + checkState + "}";
        }
			*/
			return "";
		}

        
        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    private class WindowRunnnable {
        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.909 -0400", hash_original_method = "A658DB72BEF305C977658A79961C7172", hash_generated_method = "A658DB72BEF305C977658A79961C7172")
        public WindowRunnnable ()
        {
            //Synthesized constructor
        }


        public void rememberWindowAttachCount(){
			// Original method
			/*
			{
            mOriginalAttachCount = getWindowAttachCount();
        }
			*/
			//Return nothing
		}

        
        public boolean sameWindow(){
			// Original method
			/*
			{
            return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }
			*/
			return false;
		}

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.909 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            if (mDataChanged) return;
            final ListAdapter adapter = mAdapter;
            final int motionPosition = mClickMotionPosition;
            if (adapter != null && mItemCount > 0 &&
                    motionPosition != INVALID_POSITION &&
                    motionPosition < adapter.getCount() && sameWindow()) {
                final View view = getChildAt(motionPosition - mFirstPosition);
                if (view != null) {
                    performItemClick(view, motionPosition, adapter.getItemId(motionPosition));
                }
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    private class CheckForLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.910 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            final int motionPosition = mMotionPosition;
            final View child = getChildAt(motionPosition - mFirstPosition);
            if (child != null) {
                final int longPressPosition = mMotionPosition;
                final long longPressId = mAdapter.getItemId(mMotionPosition);
                boolean handled = false;
                if (sameWindow() && !mDataChanged) {
                    handled = performLongPress(child, longPressPosition, longPressId);
                }
                if (handled) {
                    mTouchMode = TOUCH_MODE_REST;
                    setPressed(false);
                    child.setPressed(false);
                } else {
                    mTouchMode = TOUCH_MODE_DONE_WAITING;
                }
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.910 -0400", hash_original_method = "D4E5218C094B479D486A451FD5B82AD6", hash_generated_method = "D4E5218C094B479D486A451FD5B82AD6")
        public CheckForKeyLongPress ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/*
			{
            if (isPressed() && mSelectedPosition >= 0) {
                int index = mSelectedPosition - mFirstPosition;
                View v = getChildAt(index);
                if (!mDataChanged) {
                    boolean handled = false;
                    if (sameWindow()) {
                        handled = performLongPress(v, mSelectedPosition, mSelectedRowId);
                    }
                    if (handled) {
                        setPressed(false);
                        v.setPressed(false);
                    }
                } else {
                    setPressed(false);
                    if (v != null) v.setPressed(false);
                }
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.911 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        public void run(){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
    }


    
    private class FlingRunnable implements Runnable {
        private final OverScroller mScroller;
        private int mLastFlingY;
        private final Runnable mCheckFlywheel = new Runnable() {
            public void run() {
                final int activeId = mActivePointerId;
                final VelocityTracker vt = mVelocityTracker;
                final OverScroller scroller = mScroller;
                if (vt == null || activeId == INVALID_POINTER) {
                    return;
                }

                vt.computeCurrentVelocity(1000, mMaximumVelocity);
                final float yvel = -vt.getYVelocity(activeId);

                if (Math.abs(yvel) >= mMinimumVelocity
                        && scroller.isScrollingInDirection(0, yvel)) {
                    
                    postDelayed(this, FLYWHEEL_TIMEOUT);
                } else {
                    endFling();
                    mTouchMode = TOUCH_MODE_SCROLL;
                    reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                }
            }
        };
        
        FlingRunnable(){
			mScroller = new OverScroller(getContext());
			/*
			mScroller = new OverScroller(getContext());
			*/
		}

        
        void start(int initialVelocity){
			// Original method
			/*
			{
            int initialY = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingY = initialY;
            mScroller.fling(0, initialY, 0, initialVelocity,
                    0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
            if (PROFILE_FLINGING) {
                if (!mFlingProfilingStarted) {
                    Debug.startMethodTracing("AbsListViewFling");
                    mFlingProfilingStarted = true;
                }
            }
            if (mFlingStrictSpan == null) {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            }
        }
			*/
			//Return nothing
		}

        
        void startSpringback(){
			// Original method
			/*
			{
            if (mScroller.springBack(0, mScrollY, 0, 0, 0, 0)) {
                mTouchMode = TOUCH_MODE_OVERFLING;
                invalidate();
                post(this);
            } else {
                mTouchMode = TOUCH_MODE_REST;
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            }
        }
			*/
			//Return nothing
		}

        
        void startOverfling(int initialVelocity){
			// Original method
			/*
			{
            mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            mTouchMode = TOUCH_MODE_OVERFLING;
            invalidate();
            post(this);
        }
			*/
			//Return nothing
		}

        
        void edgeReached(int delta){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        void startScroll(int distance, int duration){
			// Original method
			/*
			{
            int initialY = distance < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingY = initialY;
            mScroller.startScroll(0, initialY, 0, distance, duration);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
        }
			*/
			//Return nothing
		}

        
        void endFling(){
			// Original method
			/*
			{
            mTouchMode = TOUCH_MODE_REST;
            removeCallbacks(this);
            removeCallbacks(mCheckFlywheel);
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            clearScrollingCache();
            mScroller.abortAnimation();
            if (mFlingStrictSpan != null) {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            }
        }
			*/
			//Return nothing
		}

        
        void flywheelTouch(){
			// Original method
			/*
			{
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
        }
			*/
			//Return nothing
		}

        
        public void run(){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        private static final int FLYWHEEL_TIMEOUT = 40;
    }


    
    class PositionScroller implements Runnable {
        private int mMode;
        private int mTargetPos;
        private int mBoundPos;
        private int mLastSeenPos;
        private int mScrollDuration;
        private final int mExtraScroll;
        private int mOffsetFromTop;
        
        PositionScroller(){
			mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
			/*
			mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
			*/
		}

        
        void start(int position){
			addTaint(position);
			mTargetPos = position;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        void start(int position, int boundPosition){
			addTaint(position);
			mTargetPos = position;  //Preserved
			addTaint(boundPosition);
			mBoundPos = boundPosition;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        void startWithOffset(int position, int offset){
			// Original method
			/*
			{
            startWithOffset(position, offset, SCROLL_DURATION);
        }
			*/
			//Return nothing
		}

        
        void startWithOffset(int position, int offset, int duration){
			addTaint(position);
			mTargetPos = position;  //Preserved
			addTaint(offset);
			mOffsetFromTop = offset;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        void stop(){
			// Original method
			/*
			{
            removeCallbacks(this);
        }
			*/
			//Return nothing
		}

        
        public void run(){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        private static final int SCROLL_DURATION = 400;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_UP_POS = 2;
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_OFFSET = 5;
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.923 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }


        @Override public void onChanged(){
			// Original method
			/*
			{
            super.onChanged();
            if (mFastScroller != null) {
                mFastScroller.onSectionsChanged();
            }
        }
			*/
			//Return nothing
		}

        
        @Override public void onInvalidated(){
			// Original method
			/*
			{
            super.onInvalidated();
            if (mFastScroller != null) {
                mFastScroller.onSectionsChanged();
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.924 -0400", hash_original_method = "55A4C0C73524FA4BF08CABB1B8DF874B", hash_generated_method = "55A4C0C73524FA4BF08CABB1B8DF874B")
        public MultiChoiceModeWrapper ()
        {
            //Synthesized constructor
        }


        public void setWrapped(MultiChoiceModeListener wrapped){
			mWrapped = wrapped;  //Preserved
			// Original method
			/*
			{
            mWrapped = wrapped;
        }
			*/
			//Return nothing
		}

        
        public boolean onCreateActionMode(ActionMode mode, Menu menu){
			// Original method
			/*
			{
            if (mWrapped.onCreateActionMode(mode, menu)) {
                setLongClickable(false);
                return true;
            }
            return false;
        }
			*/
			return false;
		}

        
        public boolean onPrepareActionMode(ActionMode mode, Menu menu){
			// Original method
			/*
			{
            return mWrapped.onPrepareActionMode(mode, menu);
        }
			*/
			return false;
		}

        
        public boolean onActionItemClicked(ActionMode mode, MenuItem item){
			// Original method
			/*
			{
            return mWrapped.onActionItemClicked(mode, item);
        }
			*/
			return false;
		}

        
        public void onDestroyActionMode(ActionMode mode){
			// Original method
			/*
			{
            mWrapped.onDestroyActionMode(mode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
        }
			*/
			//Return nothing
		}

        
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked){
			// Original method
			/*
			{
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            if (getCheckedItemCount() == 0) {
                mode.finish();
            }
        }
			*/
			//Return nothing
		}

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        })
        int viewType;
        @ViewDebug.ExportedProperty(category = "list")
        boolean recycledHeaderFooter;
        @ViewDebug.ExportedProperty(category = "list")
        boolean forceAdd;
        int scrappedFromPosition;
        
        public LayoutParams(Context c, AttributeSet attrs){
			super(c, attrs);
		}

        
        public LayoutParams(int w, int h){
			super(w, h);
		}

        
        public LayoutParams(int w, int h, int viewType){
			super(w, h);
			/*
			this.viewType = viewType;
			*/
		}

        
        public LayoutParams(ViewGroup.LayoutParams source){
			super(source);
		}

        
    }


    
    class RecycleBin {
        private RecyclerListener mRecyclerListener;
        private int mFirstActivePosition;
        private View[] mActiveViews = new View[0];
        private ArrayList<View>[] mScrapViews;
        private int mViewTypeCount;
        private ArrayList<View> mCurrentScrap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.928 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            //Synthesized constructor
        }


        public void setViewTypeCount(int viewTypeCount){
			addTaint(viewTypeCount);
			mViewTypeCount = viewTypeCount;  //Preserved
			// Original method
			/*
			{
            if (viewTypeCount < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
            for (int i = 0; i < viewTypeCount; i++) {
                scrapViews[i] = new ArrayList<View>();
            }
            mViewTypeCount = viewTypeCount;
            mCurrentScrap = scrapViews[0];
            mScrapViews = scrapViews;
        }
			*/
			//Return nothing
		}

        
        public void markChildrenDirty(){
			// Original method
			/*
			{
            if (mViewTypeCount == 1) {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
                for (int i = 0; i < scrapCount; i++) {
                    scrap.get(i).forceLayout();
                }
            } else {
                final int typeCount = mViewTypeCount;
                for (int i = 0; i < typeCount; i++) {
                    final ArrayList<View> scrap = mScrapViews[i];
                    final int scrapCount = scrap.size();
                    for (int j = 0; j < scrapCount; j++) {
                        scrap.get(j).forceLayout();
                    }
                }
            }
        }
			*/
			//Return nothing
		}

        
        public boolean shouldRecycleViewType(int viewType){
			// Original method
			/*
			{
            return viewType >= 0;
        }
			*/
			return false;
		}

        
        void clear(){
			// Original method
			/*
			{
            if (mViewTypeCount == 1) {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
                for (int i = 0; i < scrapCount; i++) {
                    removeDetachedView(scrap.remove(scrapCount - 1 - i), false);
                }
            } else {
                final int typeCount = mViewTypeCount;
                for (int i = 0; i < typeCount; i++) {
                    final ArrayList<View> scrap = mScrapViews[i];
                    final int scrapCount = scrap.size();
                    for (int j = 0; j < scrapCount; j++) {
                        removeDetachedView(scrap.remove(scrapCount - 1 - j), false);
                    }
                }
            }
        }
			*/
			//Return nothing
		}

        
        void fillActiveViews(int childCount, int firstActivePosition){
			addTaint(firstActivePosition);
			mFirstActivePosition = firstActivePosition;  //Preserved
			// Original method
			/*
			{
            if (mActiveViews.length < childCount) {
                mActiveViews = new View[childCount];
            }
            mFirstActivePosition = firstActivePosition;
            final View[] activeViews = mActiveViews;
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
                if (lp != null && lp.viewType != ITEM_VIEW_TYPE_HEADER_OR_FOOTER) {
                    activeViews[i] = child;
                }
            }
        }
			*/
			//Return nothing
		}

        
        View getActiveView(int position){
			// Original method
			/*
			{
            int index = position - mFirstActivePosition;
            final View[] activeViews = mActiveViews;
            if (index >=0 && index < activeViews.length) {
                final View match = activeViews[index];
                activeViews[index] = null;
                return match;
            }
            return null;
        }
			*/
			return null;
		}

        
        View getScrapView(int position){
			// Original method
			/*
			{
            if (mViewTypeCount == 1) {
                return retrieveFromScrap(mCurrentScrap, position);
            } else {
                int whichScrap = mAdapter.getItemViewType(position);
                if (whichScrap >= 0 && whichScrap < mScrapViews.length) {
                    return retrieveFromScrap(mScrapViews[whichScrap], position);
                }
            }
            return null;
        }
			*/
			return null;
		}

        
        void addScrapView(View scrap, int position){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        void scrapActiveViews(){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
        private void pruneScrapViews(){
			// Original method
			/*
			{
            final int maxViews = mActiveViews.length;
            final int viewTypeCount = mViewTypeCount;
            final ArrayList<View>[] scrapViews = mScrapViews;
            for (int i = 0; i < viewTypeCount; ++i) {
                final ArrayList<View> scrapPile = scrapViews[i];
                int size = scrapPile.size();
                final int extras = size - maxViews;
                size--;
                for (int j = 0; j < extras; j++) {
                    removeDetachedView(scrapPile.remove(size--), false);
                }
            }
        }
			*/
			//Return nothing
		}

        
        void reclaimScrapViews(List<View> views){
			// Original method
			/*
			{
            if (mViewTypeCount == 1) {
                views.addAll(mCurrentScrap);
            } else {
                final int viewTypeCount = mViewTypeCount;
                final ArrayList<View>[] scrapViews = mScrapViews;
                for (int i = 0; i < viewTypeCount; ++i) {
                    final ArrayList<View> scrapPile = scrapViews[i];
                    views.addAll(scrapPile);
                }
            }
        }
			*/
			//Return nothing
		}

        
        void setCacheColorHint(int color){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}

        
    }


    
    public interface OnScrollListener {

        
        public static int SCROLL_STATE_IDLE = 0;

        
        public static int SCROLL_STATE_TOUCH_SCROLL = 1;

        
        public static int SCROLL_STATE_FLING = 2;

        
        public void onScrollStateChanged(AbsListView view, int scrollState);

        
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount);
    }
    
    public interface SelectionBoundsAdjuster {
        
        public void adjustListItemSelectionBounds(Rect bounds);
    }
    
    public interface MultiChoiceModeListener extends ActionMode.Callback {
        
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked);
    }
    
    public static interface RecyclerListener {
        
        void onMovedToScrapHeap(View view);
    }
    
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_DOWN = 0;
    static final int TOUCH_MODE_TAP = 1;
    static final int TOUCH_MODE_DONE_WAITING = 2;
    static final int TOUCH_MODE_SCROLL = 3;
    static final int TOUCH_MODE_FLING = 4;
    static final int TOUCH_MODE_OVERSCROLL = 5;
    static final int TOUCH_MODE_OVERFLING = 6;
    static final int LAYOUT_NORMAL = 0;
    static final int LAYOUT_FORCE_TOP = 1;
    static final int LAYOUT_SET_SELECTION = 2;
    static final int LAYOUT_FORCE_BOTTOM = 3;
    static final int LAYOUT_SPECIFIC = 4;
    static final int LAYOUT_SYNC = 5;
    static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    private static final int TOUCH_MODE_ON = 0;
    private static final int TOUCH_MODE_OFF = 1;
    private static final boolean PROFILE_SCROLLING = false;
    private static final boolean PROFILE_FLINGING = false;
    private static final int INVALID_POINTER = -1;
}

