package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Debug;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.List;

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
    RecycleBin mRecycler = new RecycleBin();
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
    boolean[] mIsScrap = new boolean[1];
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.876 -0400", hash_original_method = "6A1152DD2F769DBF7D49F3027748695E", hash_generated_method = "75868CF53E18E0F4AA03FDC7BDA68EB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsListView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray a;
        a = context.obtainStyledAttributes(R.styleable.View);
        initializeScrollbars(a);
        a.recycle();
        // ---------- Original Method ----------
        //initAbsListView();
        //setVerticalScrollBarEnabled(true);
        //TypedArray a = context.obtainStyledAttributes(R.styleable.View);
        //initializeScrollbars(a);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.877 -0400", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "C9D04A10D4B80B19A704E2CD9D9A82BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.877 -0400", hash_original_method = "A8C0C093ECB8745800A88EB739981F47", hash_generated_method = "9E8A2664842313499CD55BA90ECBFCA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        initAbsListView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsListView, defStyle, 0);
        Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.AbsListView_listSelector);
        {
            setSelector(d);
        } //End block
        mDrawSelectorOnTop = a.getBoolean(
                com.android.internal.R.styleable.AbsListView_drawSelectorOnTop, false);
        boolean stackFromBottom;
        stackFromBottom = a.getBoolean(R.styleable.AbsListView_stackFromBottom, false);
        setStackFromBottom(stackFromBottom);
        boolean scrollingCacheEnabled;
        scrollingCacheEnabled = a.getBoolean(R.styleable.AbsListView_scrollingCache, true);
        setScrollingCacheEnabled(scrollingCacheEnabled);
        boolean useTextFilter;
        useTextFilter = a.getBoolean(R.styleable.AbsListView_textFilterEnabled, false);
        setTextFilterEnabled(useTextFilter);
        int transcriptMode;
        transcriptMode = a.getInt(R.styleable.AbsListView_transcriptMode,
                TRANSCRIPT_MODE_DISABLED);
        setTranscriptMode(transcriptMode);
        int color;
        color = a.getColor(R.styleable.AbsListView_cacheColorHint, 0);
        setCacheColorHint(color);
        boolean enableFastScroll;
        enableFastScroll = a.getBoolean(R.styleable.AbsListView_fastScrollEnabled, false);
        setFastScrollEnabled(enableFastScroll);
        boolean smoothScrollbar;
        smoothScrollbar = a.getBoolean(R.styleable.AbsListView_smoothScrollbar, true);
        setSmoothScrollbarEnabled(smoothScrollbar);
        setChoiceMode(a.getInt(R.styleable.AbsListView_choiceMode, CHOICE_MODE_NONE));
        setFastScrollAlwaysVisible(
                a.getBoolean(R.styleable.AbsListView_fastScrollAlwaysVisible, false));
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.878 -0400", hash_original_method = "2C481DB3FCB8FF016FB8E3D34F80B2B8", hash_generated_method = "A46123E89BB157CF7C93F7A05B67F91E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration configuration;
        configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        mDensityScale = getContext().getResources().getDisplayMetrics().density;
        // ---------- Original Method ----------
        //setClickable(true);
        //setFocusableInTouchMode(true);
        //setWillNotDraw(false);
        //setAlwaysDrawnWithCacheEnabled(false);
        //setScrollingCacheEnabled(true);
        //final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        //mTouchSlop = configuration.getScaledTouchSlop();
        //mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        //mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        //mOverscrollDistance = configuration.getScaledOverscrollDistance();
        //mOverflingDistance = configuration.getScaledOverflingDistance();
        //mDensityScale = getContext().getResources().getDisplayMetrics().density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.878 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "3DC0E706E2521C01E95A5DFA7B10157E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOverScrollMode(int mode) {
        dsTaint.addTaint(mode);
        {
            {
                Context context;
                context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } //End block
        } //End block
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } //End block
        super.setOverScrollMode(mode);
        // ---------- Original Method ----------
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mEdgeGlowTop == null) {
                //Context context = getContext();
                //mEdgeGlowTop = new EdgeEffect(context);
                //mEdgeGlowBottom = new EdgeEffect(context);
            //}
        //} else {
            //mEdgeGlowTop = null;
            //mEdgeGlowBottom = null;
        //}
        //super.setOverScrollMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.878 -0400", hash_original_method = "2831A8F535381CCEFB0BADB6BC86E26A", hash_generated_method = "FD35BC541FCF2255DDFFF891D11548C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            {
                boolean var38CEBABFDDE46DFC47E0A770A36F9546_2062119674 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
                    mCheckedIdStates == null);
                {
                    mCheckedIdStates = new LongSparseArray<Integer>();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mCheckStates.clear();
        } //End block
        {
            mCheckedIdStates.clear();
        } //End block
        // ---------- Original Method ----------
        //if (adapter != null) {
            //if (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
                    //mCheckedIdStates == null) {
                //mCheckedIdStates = new LongSparseArray<Integer>();
            //}
        //}
        //if (mCheckStates != null) {
            //mCheckStates.clear();
        //}
        //if (mCheckedIdStates != null) {
            //mCheckedIdStates.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.879 -0400", hash_original_method = "5DFF60E6C611266C8D61B940778B8222", hash_generated_method = "0674B18D8B6CC7298BA2A6E1CCF3DB4D")
    @DSModeled(DSC.SAFE)
    public int getCheckedItemCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCheckedItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.879 -0400", hash_original_method = "76DE4C8AF2033C88DA13B2D6D79BE8CC", hash_generated_method = "5CE868E55445864D0B388DA7CFDFBB6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isItemChecked(int position) {
        dsTaint.addTaint(position);
        {
            boolean var0D150F0C81FAF2A662314396EC0C31E7_485188872 = (mCheckStates.get(position));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null) {
            //return mCheckStates.get(position);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.879 -0400", hash_original_method = "40A1040C0B9BA1980C4FD0733FBB2F2E", hash_generated_method = "593A1D31AF60A35F8B4795CEFD2DF469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCheckedItemPosition() {
        {
            boolean varA1B9DE9EDBC04ECFD56B33C2A5BF45B0_2056961112 = (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1);
            {
                int varD7BABAE4F11D1568725A045F030C9B34_1747380224 = (mCheckStates.keyAt(0));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1) {
            //return mCheckStates.keyAt(0);
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.879 -0400", hash_original_method = "DD9B0503EDD82432AE0B7C0599D4B447", hash_generated_method = "4FE223AEE04118451493B2A01CBC7AEE")
    @DSModeled(DSC.SAFE)
    public SparseBooleanArray getCheckedItemPositions() {
        return (SparseBooleanArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE) {
            //return mCheckStates;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.880 -0400", hash_original_method = "C085907095DB552ED74D8B304576006A", hash_generated_method = "EC399FB52DC0A0AB7993C80842DB3C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] getCheckedItemIds() {
        {
            long[] var674FEB06102F8AD50D6DDBD530249D3A_430046665 = (new long[0]);
        } //End block
        LongSparseArray<Integer> idStates;
        idStates = mCheckedIdStates;
        int count;
        count = idStates.size();
        long[] ids;
        ids = new long[count];
        {
            int i;
            i = 0;
            {
                ids[i] = idStates.keyAt(i);
            } //End block
        } //End collapsed parenthetic
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mChoiceMode == CHOICE_MODE_NONE || mCheckedIdStates == null || mAdapter == null) {
            //return new long[0];
        //}
        //final LongSparseArray<Integer> idStates = mCheckedIdStates;
        //final int count = idStates.size();
        //final long[] ids = new long[count];
        //for (int i = 0; i < count; i++) {
            //ids[i] = idStates.keyAt(i);
        //}
        //return ids;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.880 -0400", hash_original_method = "A5D48B0328BC1A467504F22AFA94E40C", hash_generated_method = "B4A93F25373379F44D7CE7CEDE8E78AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearChoices() {
        {
            mCheckStates.clear();
        } //End block
        {
            mCheckedIdStates.clear();
        } //End block
        mCheckedItemCount = 0;
        // ---------- Original Method ----------
        //if (mCheckStates != null) {
            //mCheckStates.clear();
        //}
        //if (mCheckedIdStates != null) {
            //mCheckedIdStates.clear();
        //}
        //mCheckedItemCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.880 -0400", hash_original_method = "43E07392067BD1BC5F99F3882FA40E88", hash_generated_method = "398D6057B03DB78ED0023A92A1533BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setItemChecked(int position, boolean value) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(value);
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } //End block
        {
            boolean oldValue;
            oldValue = mCheckStates.get(position);
            mCheckStates.put(position, value);
            {
                boolean varDF5D6CF73909C5793DEDFF57AC70B3A9_1024958562 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                {
                    {
                        mCheckedIdStates.put(mAdapter.getItemId(position), position);
                    } //End block
                    {
                        mCheckedIdStates.delete(mAdapter.getItemId(position));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                long id;
                id = mAdapter.getItemId(position);
                mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                        position, id, value);
            } //End block
        } //End block
        {
            boolean updateIds;
            updateIds = mCheckedIdStates != null && mAdapter.hasStableIds();
            {
                boolean varE3E83AB27085DF4D75DE8758E514DAA9_623263634 = (value || isItemChecked(position));
                {
                    mCheckStates.clear();
                    {
                        mCheckedIdStates.clear();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                mCheckStates.put(position, true);
                {
                    mCheckedIdStates.put(mAdapter.getItemId(position), position);
                } //End block
                mCheckedItemCount = 1;
            } //End block
            {
                boolean var425458AA9F83015DB14C2404DEE4E159_340467347 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
                {
                    mCheckedItemCount = 0;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.881 -0400", hash_original_method = "9A0165787640E5C3A3D1AC60426CC2CC", hash_generated_method = "077B04658C846DA28CA12C66F924EFB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performItemClick(View view, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(view.dsTaint);
        boolean handled;
        handled = false;
        boolean dispatchItemClick;
        dispatchItemClick = true;
        {
            handled = true;
            {
                boolean newValue;
                newValue = !mCheckStates.get(position, false);
                mCheckStates.put(position, newValue);
                {
                    boolean varFFF95FDDB84D487F1FD71AE5B4D04DFA_671245984 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                    {
                        {
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } //End block
                        {
                            mCheckedIdStates.delete(mAdapter.getItemId(position));
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                            position, id, newValue);
                    dispatchItemClick = false;
                } //End block
            } //End block
            {
                boolean newValue;
                newValue = !mCheckStates.get(position, false);
                {
                    mCheckStates.clear();
                    mCheckStates.put(position, true);
                    {
                        boolean varD30D994107B77CF4004B51C1F80A4DE7_133728855 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                        {
                            mCheckedIdStates.clear();
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } //End block
                    } //End collapsed parenthetic
                    mCheckedItemCount = 1;
                } //End block
                {
                    boolean var6ACBF7B7E15B02DF34CBCD44F94045DE_223335383 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
                    {
                        mCheckedItemCount = 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } //End block
        {
            handled |= super.performItemClick(view, position, id);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.881 -0400", hash_original_method = "8E2D8E05EEC3041F2430430C00E99F2E", hash_generated_method = "FAAB75BEB5332BAC271F01C472A5A516")
    @DSModeled(DSC.SAFE)
    public int getChoiceMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChoiceMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.882 -0400", hash_original_method = "31284EBF9693FA29D08DAAB1651BB216", hash_generated_method = "FC6CE8AA84FF4A4C6B70C784EB242FE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChoiceMode(int choiceMode) {
        dsTaint.addTaint(choiceMode);
        {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        } //End block
        {
            {
                mCheckStates = new SparseBooleanArray();
            } //End block
            {
                boolean var2BF65510232B6C8CFF89CFE72E6D8ACB_724990078 = (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds());
                {
                    mCheckedIdStates = new LongSparseArray<Integer>();
                } //End block
            } //End collapsed parenthetic
            {
                clearChoices();
                setLongClickable(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mChoiceMode = choiceMode;
        //if (mChoiceActionMode != null) {
            //mChoiceActionMode.finish();
            //mChoiceActionMode = null;
        //}
        //if (mChoiceMode != CHOICE_MODE_NONE) {
            //if (mCheckStates == null) {
                //mCheckStates = new SparseBooleanArray();
            //}
            //if (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds()) {
                //mCheckedIdStates = new LongSparseArray<Integer>();
            //}
            //if (mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL) {
                //clearChoices();
                //setLongClickable(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.882 -0400", hash_original_method = "AB030C487B8A76B7A3B990C85D8D5284", hash_generated_method = "1D2FF1ADEDDEC5D69B54A26D4B2115CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        } //End block
        mMultiChoiceModeCallback.setWrapped(listener);
        // ---------- Original Method ----------
        //if (mMultiChoiceModeCallback == null) {
            //mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        //}
        //mMultiChoiceModeCallback.setWrapped(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.882 -0400", hash_original_method = "34BF563ABF29C3DFDECFCC44CD785338", hash_generated_method = "1711E0AAFDE08CD922E6DA0F6F3C8196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean contentFits() {
        int childCount;
        childCount = getChildCount();
        boolean varB916502A2FFF50967FBE5280BE01D3D7_66308943 = (getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount == 0) return true;
        //if (childCount != mItemCount) return false;
        //return getChildAt(0).getTop() >= mListPadding.top &&
                //getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.883 -0400", hash_original_method = "595588F5399A1D343B61A8313A8ACA6F", hash_generated_method = "B56B7D3695C707C646F246621661F149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastScrollEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            {
                mFastScroller = new FastScroller(getContext(), this);
            } //End block
        } //End block
        {
            {
                mFastScroller.stop();
                mFastScroller = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mFastScrollEnabled = enabled;
        //if (enabled) {
            //if (mFastScroller == null) {
                //mFastScroller = new FastScroller(getContext(), this);
            //}
        //} else {
            //if (mFastScroller != null) {
                //mFastScroller.stop();
                //mFastScroller = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.883 -0400", hash_original_method = "76A971EB75129863E10E67DBAAA59745", hash_generated_method = "940693219D128870026EABAF13733BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFastScrollAlwaysVisible(boolean alwaysShow) {
        dsTaint.addTaint(alwaysShow);
        {
            setFastScrollEnabled(true);
        } //End block
        {
            mFastScroller.setAlwaysShow(alwaysShow);
        } //End block
        computeOpaqueFlags();
        recomputePadding();
        // ---------- Original Method ----------
        //if (alwaysShow && !mFastScrollEnabled) {
            //setFastScrollEnabled(true);
        //}
        //if (mFastScroller != null) {
            //mFastScroller.setAlwaysShow(alwaysShow);
        //}
        //computeOpaqueFlags();
        //recomputePadding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.883 -0400", hash_original_method = "B8FB7506E98011F45E37A448BFD532A7", hash_generated_method = "210F1E4ADB4751DF35259FC3BC60AE96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFastScrollAlwaysVisible() {
        boolean var26B2F46AB3144EF80214E1227EB2F480_469258949 = (mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.883 -0400", hash_original_method = "7B9EF1235ED171F1370B12BB905DC3C9", hash_generated_method = "1458FA0774DD510A720361A223D834DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getVerticalScrollbarWidth() {
        {
            boolean var26909BC69BA2F3E69FEBFE306B4E5DAD_2049816689 = (isFastScrollAlwaysVisible());
            {
                int varFB51A5362339E3615BCF0229E08CB917_1045710452 = (Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth()));
            } //End block
        } //End collapsed parenthetic
        int var08FF7A4CA397B890F67D51D77687712B_649665725 = (super.getVerticalScrollbarWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isFastScrollAlwaysVisible()) {
            //return Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth());
        //}
        //return super.getVerticalScrollbarWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.883 -0400", hash_original_method = "0BC112ABD3166320C6B43E3AFC3B6D61", hash_generated_method = "750EDCA43657FC7CC144B1729F66F335")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScrollEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.884 -0400", hash_original_method = "A675D7279FF2D5DA4484C8480BA7553A", hash_generated_method = "86433C67756A9B3E97DA89BB07EFFABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVerticalScrollbarPosition(int position) {
        dsTaint.addTaint(position);
        super.setVerticalScrollbarPosition(position);
        {
            mFastScroller.setScrollbarPosition(position);
        } //End block
        // ---------- Original Method ----------
        //super.setVerticalScrollbarPosition(position);
        //if (mFastScroller != null) {
            //mFastScroller.setScrollbarPosition(position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.884 -0400", hash_original_method = "940CDB7D64F97F8EC4A4E1C87858DFBA", hash_generated_method = "94739890ABD6C34C07C9D757AF87D032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isVerticalScrollBarHidden() {
        boolean varEE7670B7B7BC0CBAC7B3A19E6E35E88F_1642408086 = (mFastScroller != null && mFastScroller.isVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScroller != null && mFastScroller.isVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.884 -0400", hash_original_method = "1698DB675ADDAA62665F2F04BB6F72CB", hash_generated_method = "FE0DD1742CDD06A271D0B0E09C1F4329")
    @DSModeled(DSC.SAFE)
    public void setSmoothScrollbarEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mSmoothScrollbarEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.884 -0400", hash_original_method = "475C5FFCF382FD26204BCB75E2B77D7D", hash_generated_method = "866AA5C053A2F55C5FA4BA0DCC99E134")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSmoothScrollbarEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.885 -0400", hash_original_method = "210B7E1D385EBACE9AEF47F53212EE62", hash_generated_method = "0AB9C1BE380A4A7E6640A8C9F187EC61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnScrollListener(OnScrollListener l) {
        dsTaint.addTaint(l.dsTaint);
        invokeOnItemScrollListener();
        // ---------- Original Method ----------
        //mOnScrollListener = l;
        //invokeOnItemScrollListener();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.885 -0400", hash_original_method = "BA8530F9EF3261CEDA66BF584A9CCD3E", hash_generated_method = "A9B81DB570E7184E3C81965E4D493FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void invokeOnItemScrollListener() {
        {
            mFastScroller.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } //End block
        {
            mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } //End block
        onScrollChanged(0, 0, 0, 0);
        // ---------- Original Method ----------
        //if (mFastScroller != null) {
            //mFastScroller.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        //}
        //if (mOnScrollListener != null) {
            //mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        //}
        //onScrollChanged(0, 0, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.885 -0400", hash_original_method = "B64F2C3012E6A3D7EFE9332FD2B83485", hash_generated_method = "ECF40006A9590366337C3C3D049F15BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void sendAccessibilityEvent(int eventType) {
        dsTaint.addTaint(eventType);
        {
            int firstVisiblePosition;
            firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition;
            lastVisiblePosition = getLastVisiblePosition();
            {
                mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            } //End block
        } //End block
        super.sendAccessibilityEvent(eventType);
        // ---------- Original Method ----------
        //if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            //final int firstVisiblePosition = getFirstVisiblePosition();
            //final int lastVisiblePosition = getLastVisiblePosition();
            //if (mLastAccessibilityScrollEventFromIndex == firstVisiblePosition
                    //&& mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                //return;   
            //} else {
                //mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                //mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            //}
        //}
        //super.sendAccessibilityEvent(eventType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.885 -0400", hash_original_method = "9414D347741A5DD8E57796525BCE5898", hash_generated_method = "205E4CD4601CE0F092ACA6CACE55EABD")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollingCacheEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.886 -0400", hash_original_method = "150D6943577E82022A370D7488992E67", hash_generated_method = "FFCC6CD015DB13C45C9711530A204976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScrollingCacheEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            clearScrollingCache();
        } //End block
        // ---------- Original Method ----------
        //if (mScrollingCacheEnabled && !enabled) {
            //clearScrollingCache();
        //}
        //mScrollingCacheEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.886 -0400", hash_original_method = "8476047A74E8C2792EEAD35F27B63501", hash_generated_method = "38364A4610A50291A3C99F5A89D530D9")
    @DSModeled(DSC.SAFE)
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        dsTaint.addTaint(textFilterEnabled);
        // ---------- Original Method ----------
        //mTextFilterEnabled = textFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.886 -0400", hash_original_method = "D536B611E01E5CFE1F666765CAB03290", hash_generated_method = "21930BD8A082BFEF494792D2738F5465")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.886 -0400", hash_original_method = "1C8D0A5FE9343035731EC5D6D9384599", hash_generated_method = "0FF69AF9DE45089A2CBD41D80B59C9AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getFocusedRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        View view;
        view = getSelectedView();
        {
            boolean varA78CB7AA6BC92F805E05829844E1ECE3_1772672700 = (view != null && view.getParent() == this);
            {
                view.getFocusedRect(r);
                offsetDescendantRectToMyCoords(view, r);
            } //End block
            {
                super.getFocusedRect(r);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //View view = getSelectedView();
        //if (view != null && view.getParent() == this) {
            //view.getFocusedRect(r);
            //offsetDescendantRectToMyCoords(view, r);
        //} else {
            //super.getFocusedRect(r);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.888 -0400", hash_original_method = "9E8C7705C9D325A7FB79BC94A2C5E742", hash_generated_method = "5E8864341AF6CB275CB3012A78EAE0CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(
                //com.android.internal.R.drawable.list_selector_background));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.888 -0400", hash_original_method = "991365D9D991378A506E868734A0B0D2", hash_generated_method = "91EC4CF08062EE4002EF06CC589B44A3")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStackFromBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.888 -0400", hash_original_method = "CFFEAD7E7BECCE023678F7841887953F", hash_generated_method = "3B312BAC0C4F79394E107102433D3E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStackFromBottom(boolean stackFromBottom) {
        dsTaint.addTaint(stackFromBottom);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (mStackFromBottom != stackFromBottom) {
            //mStackFromBottom = stackFromBottom;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.888 -0400", hash_original_method = "DBB2E77784FB40B043F5BACE416B5D38", hash_generated_method = "913AF492BE3878B8A0D4E567C044281D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestLayoutIfNecessary() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1295552991 = (getChildCount() > 0);
            {
                resetList();
                requestLayout();
                invalidate();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //resetList();
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.889 -0400", hash_original_method = "550511192552500388A3039280244936", hash_generated_method = "61FDC3F444C11D232FF9A9DA1615165F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismissPopup();
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        boolean haveChildren;
        haveChildren = getChildCount() > 0 && mItemCount > 0;
        long selectedId;
        selectedId = getSelectedItemId();
        ss.selectedId = selectedId;
        ss.height = getHeight();
        {
            ss.viewTop = mSelectedTop;
            ss.position = getSelectedItemPosition();
            ss.firstId = INVALID_POSITION;
        } //End block
        {
            {
                View v;
                v = getChildAt(0);
                ss.viewTop = v.getTop();
                int firstPos;
                firstPos = mFirstPosition;
                {
                    firstPos = mItemCount - 1;
                } //End block
                ss.position = firstPos;
                ss.firstId = mAdapter.getItemId(firstPos);
            } //End block
            {
                ss.viewTop = 0;
                ss.firstId = INVALID_POSITION;
                ss.position = 0;
            } //End block
        } //End block
        ss.filter = null;
        {
            EditText textFilter;
            textFilter = mTextFilter;
            {
                Editable filterText;
                filterText = textFilter.getText();
                {
                    ss.filter = filterText.toString();
                } //End block
            } //End block
        } //End block
        ss.inActionMode = mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL && mChoiceActionMode != null;
        {
            ss.checkState = mCheckStates.clone();
        } //End block
        {
            LongSparseArray<Integer> idState;
            idState = new LongSparseArray<Integer>();
            int count;
            count = mCheckedIdStates.size();
            {
                int i;
                i = 0;
                {
                    idState.put(mCheckedIdStates.keyAt(i), mCheckedIdStates.valueAt(i));
                } //End block
            } //End collapsed parenthetic
            ss.checkIdState = idState;
        } //End block
        ss.checkedItemCount = mCheckedItemCount;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.890 -0400", hash_original_method = "43BE5C5AD27C719005EFC4A46B8486A7", hash_generated_method = "AF76E502BFCE1C54246E9399047D337F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mDataChanged = true;
        mSyncHeight = ss.height;
        {
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSpecificTop = ss.viewTop;
            mSyncMode = SYNC_SELECTED_POSITION;
        } //End block
        {
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectorPosition = INVALID_POSITION;
            mNeedSync = true;
            mSyncRowId = ss.firstId;
            mSyncPosition = ss.position;
            mSpecificTop = ss.viewTop;
            mSyncMode = SYNC_FIRST_POSITION;
        } //End block
        setFilterText(ss.filter);
        {
            mCheckStates = ss.checkState;
        } //End block
        {
            mCheckedIdStates = ss.checkIdState;
        } //End block
        mCheckedItemCount = ss.checkedItemCount;
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.890 -0400", hash_original_method = "42E27AF1CE674CD4135EEA22852A217B", hash_generated_method = "9E530662EC2BCC36A626EBE616B6D422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean acceptFilter() {
        boolean varA2D4C9A63B028E8345B4157A680073A2_1564398378 = (mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextFilterEnabled && getAdapter() instanceof Filterable &&
                //((Filterable) getAdapter()).getFilter() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.890 -0400", hash_original_method = "A8CCB94844A67C45EFD075D798DD3AF0", hash_generated_method = "1A7E7A1EBE9DFEED7EE33F37A7A9CA74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilterText(String filterText) {
        dsTaint.addTaint(filterText);
        {
            boolean var190C1EE91DE344514DA2209FAF0C3D82_2062079856 = (mTextFilterEnabled && !TextUtils.isEmpty(filterText));
            {
                createTextFilter(false);
                mTextFilter.setText(filterText);
                mTextFilter.setSelection(filterText.length());
                {
                    {
                        Filter f;
                        f = ((Filterable) mAdapter).getFilter();
                        f.filter(filterText);
                    } //End block
                    mFiltered = true;
                    mDataSetObserver.clearSavedState();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mTextFilterEnabled && !TextUtils.isEmpty(filterText)) {
            //createTextFilter(false);
            //mTextFilter.setText(filterText);
            //mTextFilter.setSelection(filterText.length());
            //if (mAdapter instanceof Filterable) {
                //if (mPopup == null) {
                    //Filter f = ((Filterable) mAdapter).getFilter();
                    //f.filter(filterText);
                //}
                //mFiltered = true;
                //mDataSetObserver.clearSavedState();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.890 -0400", hash_original_method = "1C9B36BFA6AA511A6999C19189070FD4", hash_generated_method = "5C90B72A50B8BAB68DCEE09BD0F41D3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextFilter() {
        {
            CharSequence varDF6F55DC5C9DC328BEED19950632B8DE_1586116808 = (mTextFilter.getText());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mTextFilterEnabled && mTextFilter != null) {
            //return mTextFilter.getText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.891 -0400", hash_original_method = "0C025ACF6797C1095DC28C93A47B3E04", hash_generated_method = "80BD54B604D4ED7F6D3659BD189CAA93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(gainFocus);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        {
            boolean var8EB9364CA747E30AAC5C9F3175F02645_494182259 = (gainFocus && mSelectedPosition < 0 && !isInTouchMode());
            {
                {
                    mDataChanged = true;
                    mOldItemCount = mItemCount;
                    mItemCount = mAdapter.getCount();
                } //End block
                resurrectSelection();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        //if (gainFocus && mSelectedPosition < 0 && !isInTouchMode()) {
            //if (!mIsAttached && mAdapter != null) {
                //mDataChanged = true;
                //mOldItemCount = mItemCount;
                //mItemCount = mAdapter.getCount();
            //}
            //resurrectSelection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.891 -0400", hash_original_method = "B180005EA1177A66433DC47F81A1B223", hash_generated_method = "7FA434FB1BD0F76EE21405415ADD4E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void requestLayout() {
        {
            super.requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (!mBlockLayoutRequests && !mInLayout) {
            //super.requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.891 -0400", hash_original_method = "8DD5C430A497277A13BB6B282542179B", hash_generated_method = "7581B754A737045C6DFD1C880926F30E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void resetList() {
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
        // ---------- Original Method ----------
        //removeAllViewsInLayout();
        //mFirstPosition = 0;
        //mDataChanged = false;
        //mNeedSync = false;
        //mOldSelectedPosition = INVALID_POSITION;
        //mOldSelectedRowId = INVALID_ROW_ID;
        //setSelectedPositionInt(INVALID_POSITION);
        //setNextSelectedPositionInt(INVALID_POSITION);
        //mSelectedTop = 0;
        //mSelectorPosition = INVALID_POSITION;
        //mSelectorRect.setEmpty();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.892 -0400", hash_original_method = "EAD3946FC18204D61E6D52ABAEC42671", hash_generated_method = "9330965046B1FA5DB54793B048461920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollExtent() {
        int count;
        count = getChildCount();
        {
            {
                int extent;
                extent = count * 100;
                View view;
                view = getChildAt(0);
                int top;
                top = view.getTop();
                int height;
                height = view.getHeight();
                {
                    extent += (top * 100) / height;
                } //End block
                view = getChildAt(count - 1);
                int bottom;
                bottom = view.getBottom();
                height = view.getHeight();
                {
                    extent -= ((bottom - getHeight()) * 100) / height;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //if (count > 0) {
            //if (mSmoothScrollbarEnabled) {
                //int extent = count * 100;
                //View view = getChildAt(0);
                //final int top = view.getTop();
                //int height = view.getHeight();
                //if (height > 0) {
                    //extent += (top * 100) / height;
                //}
                //view = getChildAt(count - 1);
                //final int bottom = view.getBottom();
                //height = view.getHeight();
                //if (height > 0) {
                    //extent -= ((bottom - getHeight()) * 100) / height;
                //}
                //return extent;
            //} else {
                //return 1;
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.892 -0400", hash_original_method = "B342EEB15F9AC09DD167764D56209B72", hash_generated_method = "97CDA6A60C4111F0FCBDAD6BFF7EB182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollOffset() {
        int firstPosition;
        firstPosition = mFirstPosition;
        int childCount;
        childCount = getChildCount();
        {
            {
                View view;
                view = getChildAt(0);
                int top;
                top = view.getTop();
                int height;
                height = view.getHeight();
                {
                    int var813D884A4C0D547484060C54181A041A_368275505 = (Math.max(firstPosition * 100 - (top * 100) / height +
                            (int)((float)mScrollY / getHeight() * mItemCount * 100), 0));
                } //End block
            } //End block
            {
                int index;
                int count;
                count = mItemCount;
                {
                    index = 0;
                } //End block
                {
                    index = count;
                } //End block
                {
                    index = firstPosition + childCount / 2;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.893 -0400", hash_original_method = "4324030F56A09BCB8354791FE2A22081", hash_generated_method = "B4BE9071745F3E63FC299802D5772AF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollRange() {
        int result;
        {
            result = Math.max(mItemCount * 100, 0);
            {
                result += Math.abs((int) ((float) mScrollY / getHeight() * mItemCount * 100));
            } //End block
        } //End block
        {
            result = mItemCount;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result;
        //if (mSmoothScrollbarEnabled) {
            //result = Math.max(mItemCount * 100, 0);
            //if (mScrollY != 0) {
                //result += Math.abs((int) ((float) mScrollY / getHeight() * mItemCount * 100));
            //}
        //} else {
            //result = mItemCount;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.894 -0400", hash_original_method = "6B45AE0F220A2E6F043181E50094F343", hash_generated_method = "8BAC82A6D855CA0BDDA49BB71D8E12C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getTopFadingEdgeStrength() {
        int count;
        count = getChildCount();
        float fadeEdge;
        fadeEdge = super.getTopFadingEdgeStrength();
        {
            int top;
            top = getChildAt(0).getTop();
            float fadeLength;
            fadeLength = (float) getVerticalFadingEdgeLength();
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final float fadeEdge = super.getTopFadingEdgeStrength();
        //if (count == 0) {
            //return fadeEdge;
        //} else {
            //if (mFirstPosition > 0) {
                //return 1.0f;
            //}
            //final int top = getChildAt(0).getTop();
            //final float fadeLength = (float) getVerticalFadingEdgeLength();
            //return top < mPaddingTop ? (float) -(top - mPaddingTop) / fadeLength : fadeEdge;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.894 -0400", hash_original_method = "7783F8E763936950C57ED5516E6F7E94", hash_generated_method = "54D93DFB42CF1B39EBDD53720B423B01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected float getBottomFadingEdgeStrength() {
        int count;
        count = getChildCount();
        float fadeEdge;
        fadeEdge = super.getBottomFadingEdgeStrength();
        {
            int bottom;
            bottom = getChildAt(count - 1).getBottom();
            int height;
            height = getHeight();
            float fadeLength;
            fadeLength = (float) getVerticalFadingEdgeLength();
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final float fadeEdge = super.getBottomFadingEdgeStrength();
        //if (count == 0) {
            //return fadeEdge;
        //} else {
            //if (mFirstPosition + count - 1 < mItemCount - 1) {
                //return 1.0f;
            //}
            //final int bottom = getChildAt(count - 1).getBottom();
            //final int height = getHeight();
            //final float fadeLength = (float) getVerticalFadingEdgeLength();
            //return bottom > height - mPaddingBottom ?
                    //(float) (bottom - height + mPaddingBottom) / fadeLength : fadeEdge;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.895 -0400", hash_original_method = "7C6C2B65B4381736E49DE73CCD130327", hash_generated_method = "1D0EC1C6C28F68C19F89CA9425012ADC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        {
            useDefaultSelector();
        } //End block
        Rect listPadding;
        listPadding = mListPadding;
        listPadding.left = mSelectionLeftPadding + mPaddingLeft;
        listPadding.top = mSelectionTopPadding + mPaddingTop;
        listPadding.right = mSelectionRightPadding + mPaddingRight;
        listPadding.bottom = mSelectionBottomPadding + mPaddingBottom;
        {
            int childCount;
            childCount = getChildCount();
            int listBottom;
            listBottom = getHeight() - getPaddingBottom();
            View lastChild;
            lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            lastBottom = listBottom;
            mForceTranscriptScroll = mFirstPosition + childCount >= mLastHandledItemCount &&
                    lastBottom <= listBottom;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.895 -0400", hash_original_method = "46F44099FEFDB133D6B976408934CAC6", hash_generated_method = "E4BC24AAADA6789C59B56E268C170133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        dsTaint.addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        {
            int childCount;
            childCount = getChildCount();
            {
                int i;
                i = 0;
                {
                    getChildAt(i).forceLayout();
                } //End block
            } //End collapsed parenthetic
            mRecycler.markChildrenDirty();
        } //End block
        {
            mFastScroller.onItemCountChanged(mOldItemCount, mItemCount);
        } //End block
        layoutChildren();
        mInLayout = false;
        mOverscrollMax = (b - t) / OVERSCROLL_LIMIT_DIVISOR;
        // ---------- Original Method ----------
        //super.onLayout(changed, l, t, r, b);
        //mInLayout = true;
        //if (changed) {
            //int childCount = getChildCount();
            //for (int i = 0; i < childCount; i++) {
                //getChildAt(i).forceLayout();
            //}
            //mRecycler.markChildrenDirty();
        //}
        //if (mFastScroller != null && mItemCount != mOldItemCount) {
            //mFastScroller.onItemCountChanged(mOldItemCount, mItemCount);
        //}
        //layoutChildren();
        //mInLayout = false;
        //mOverscrollMax = (b - t) / OVERSCROLL_LIMIT_DIVISOR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.896 -0400", hash_original_method = "748FD791AA503E7E1D859CFD661EA755", hash_generated_method = "6C2D87A94F1D1FB79126CE8D991736B7")
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
            boolean visible;
            visible = getWindowVisibility() == View.VISIBLE;
            {
                boolean varFBED1B944623C6BCA164EC2723F71804_167145158 = (mFiltered && visible && mPopup != null && mPopup.isShowing());
                {
                    positionPopup();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean changed = super.setFrame(left, top, right, bottom);
        //if (changed) {
            //final boolean visible = getWindowVisibility() == View.VISIBLE;
            //if (mFiltered && visible && mPopup != null && mPopup.isShowing()) {
                //positionPopup();
            //}
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.896 -0400", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "7C7456ED8D2FB5B664E2AB60CCD22125")
    @DSModeled(DSC.SAFE)
    protected void layoutChildren() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.896 -0400", hash_original_method = "180044681435C2C9D1AB0FD8756137A4", hash_generated_method = "D6EAAE418DF0A77979820ECC821F6477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateScrollIndicators() {
        {
            boolean canScrollUp;
            canScrollUp = mFirstPosition > 0;
            {
                {
                    boolean var4813CB3BCCB7AE7282F404FB5F98BC43_1419243700 = (getChildCount() > 0);
                    {
                        View child;
                        child = getChildAt(0);
                        canScrollUp = child.getTop() < mListPadding.top;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mScrollUp.setVisibility(canScrollUp ? View.VISIBLE : View.INVISIBLE);
        } //End block
        {
            boolean canScrollDown;
            int count;
            count = getChildCount();
            canScrollDown = (mFirstPosition + count) < mItemCount;
            {
                View child;
                child = getChildAt(count - 1);
                canScrollDown = child.getBottom() > mBottom - mListPadding.bottom;
            } //End block
            mScrollDown.setVisibility(canScrollDown ? View.VISIBLE : View.INVISIBLE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.896 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "C15AAEAA947970D2A20EDDAF204A25F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        {
            View var32627160716DC777F524CC780C8B0164_754663505 = (getChildAt(mSelectedPosition - mFirstPosition));
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition >= 0) {
            //return getChildAt(mSelectedPosition - mFirstPosition);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.897 -0400", hash_original_method = "3B697574C47153B82BC97C5C46624F2C", hash_generated_method = "4E9B735F38A4499F1723C1AC48A360F3")
    @DSModeled(DSC.SAFE)
    public int getListPaddingTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.897 -0400", hash_original_method = "CEE980D8545C78DFB596AE8650DBF797", hash_generated_method = "D01163532AA3CB40E0064AAB933ACA55")
    @DSModeled(DSC.SAFE)
    public int getListPaddingBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.897 -0400", hash_original_method = "C8B939C15FBE7011BDF7672B6F924B56", hash_generated_method = "AEB8712B369C63682733382F2A915475")
    @DSModeled(DSC.SAFE)
    public int getListPaddingLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.897 -0400", hash_original_method = "1F1F9379D690EBB0F58C075805935B4C", hash_generated_method = "AF1E33B790EF1D66A6936AC58E72729E")
    @DSModeled(DSC.SAFE)
    public int getListPaddingRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.898 -0400", hash_original_method = "F1A94AACBC76DA4834C170841A9D4C37", hash_generated_method = "9D604F21EF1601927DCA15968F178262")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View obtainView(int position, boolean[] isScrap) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(isScrap[0]);
        isScrap[0] = false;
        View scrapView;
        scrapView = mRecycler.getScrapView(position);
        View child;
        {
            {
                ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.RECYCLE_FROM_SCRAP_HEAP,
                        position, -1);
            } //End block
            child = mAdapter.getView(position, scrapView, this);
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.BIND_VIEW,
                        position, getChildCount());
            } //End block
            {
                mRecycler.addScrapView(scrapView, position);
                {
                    child.setDrawingCacheBackgroundColor(mCacheColorHint);
                } //End block
                {
                    ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                            position, -1);
                } //End block
            } //End block
            {
                isScrap[0] = true;
                child.dispatchFinishTemporaryDetach();
            } //End block
        } //End block
        {
            child = mAdapter.getView(position, null, this);
            {
                child.setDrawingCacheBackgroundColor(mCacheColorHint);
            } //End block
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.NEW_VIEW,
                        position, getChildCount());
            } //End block
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.898 -0400", hash_original_method = "B068259C5BBCB2A7501108708CD5A4C4", hash_generated_method = "5396F64E9D55FA214249AE62B9999007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void positionSelector(int position, View sel) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(sel.dsTaint);
        Rect selectorRect;
        selectorRect = mSelectorRect;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        {
            ((SelectionBoundsAdjuster)sel).adjustListItemSelectionBounds(selectorRect);
        } //End block
        positionSelector(selectorRect.left, selectorRect.top, selectorRect.right,
                selectorRect.bottom);
        boolean isChildViewEnabled;
        isChildViewEnabled = mIsChildViewEnabled;
        {
            boolean varFB59463D8D8AB76E1E484CE2BBC5519D_1605674109 = (sel.isEnabled() != isChildViewEnabled);
            {
                mIsChildViewEnabled = !isChildViewEnabled;
                {
                    boolean var9ACEB0A565E658741B99EDC3F95405AB_933835812 = (getSelectedItemPosition() != INVALID_POSITION);
                    {
                        refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (position != INVALID_POSITION) {
            //mSelectorPosition = position;
        //}
        //final Rect selectorRect = mSelectorRect;
        //selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        //if (sel instanceof SelectionBoundsAdjuster) {
            //((SelectionBoundsAdjuster)sel).adjustListItemSelectionBounds(selectorRect);
        //}
        //positionSelector(selectorRect.left, selectorRect.top, selectorRect.right,
                //selectorRect.bottom);
        //final boolean isChildViewEnabled = mIsChildViewEnabled;
        //if (sel.isEnabled() != isChildViewEnabled) {
            //mIsChildViewEnabled = !isChildViewEnabled;
            //if (getSelectedItemPosition() != INVALID_POSITION) {
                //refreshDrawableState();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.898 -0400", hash_original_method = "9958A79674A9EAF808CC1CD0A2974C67", hash_generated_method = "9049D1584489CF5667CB85BCF0ABC437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void positionSelector(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                + mSelectionRightPadding, b + mSelectionBottomPadding);
        // ---------- Original Method ----------
        //mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                //+ mSelectionRightPadding, b + mSelectionBottomPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.899 -0400", hash_original_method = "EB6A446E7A5D607DB4BF2796F54D03FA", hash_generated_method = "71F8C7B1BEA9261D3E1B0AE72BB6B2BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int saveCount;
        saveCount = 0;
        boolean clipToPadding;
        clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            int scrollX;
            scrollX = mScrollX;
            int scrollY;
            scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
            mGroupFlags &= ~CLIP_TO_PADDING_MASK;
        } //End block
        boolean drawSelectorOnTop;
        drawSelectorOnTop = mDrawSelectorOnTop;
        {
            drawSelector(canvas);
        } //End block
        super.dispatchDraw(canvas);
        {
            drawSelector(canvas);
        } //End block
        {
            canvas.restoreToCount(saveCount);
            mGroupFlags |= CLIP_TO_PADDING_MASK;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.899 -0400", hash_original_method = "E1295B3F3CD2AED842AA5266ED41ED1A", hash_generated_method = "82304C1CBAD291496A25A42CBFC0547F")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isPaddingOffsetRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) != CLIP_TO_PADDING_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.899 -0400", hash_original_method = "C31A372B11969057E398197BABCC2FB9", hash_generated_method = "73B9345367F23C328C1B8EFC2CBDCD50")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getLeftPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.899 -0400", hash_original_method = "F0F07013F187EA8DBDDCF030EEADD0A0", hash_generated_method = "763BD0B019445A531BAC4E98A8E2E6B0")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getTopPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.900 -0400", hash_original_method = "D64BFD9DD2CC0187FA2BCDAC4D5056C0", hash_generated_method = "F2348D34EB1F1BCBB913C8B3BDCA7B0D")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getRightPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.900 -0400", hash_original_method = "A76EA354621A97D061AF35F7F0E022AA", hash_generated_method = "43AEFB79FE4FE31F66D62C5DD06C2042")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getBottomPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.900 -0400", hash_original_method = "7222D25647FA66D7134D6564AB03A11A", hash_generated_method = "B69E65032948ED538452F40336DA4FC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(h);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1192038520 = (getChildCount() > 0);
            {
                mDataChanged = true;
                rememberSyncState();
            } //End block
        } //End collapsed parenthetic
        {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        } //End block
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //mDataChanged = true;
            //rememberSyncState();
        //}
        //if (mFastScroller != null) {
            //mFastScroller.onSizeChanged(w, h, oldw, oldh);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.900 -0400", hash_original_method = "E2B9A99414FF2EE03BB0A755AC5DBB16", hash_generated_method = "B2869D19C8F590181985AF873AC4043A")
    @DSModeled(DSC.SAFE)
     boolean touchModeDrawsInPressedState() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (mTouchMode) {
        //case TOUCH_MODE_TAP:
        //case TOUCH_MODE_DONE_WAITING:
            //return true;
        //default:
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.900 -0400", hash_original_method = "FA7D742C09854F2E7F00273E8807D507", hash_generated_method = "0672F2C3BE8775620E5CA9DB6995CC58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean shouldShowSelector() {
        boolean var4246A524C7FBFC973820D2F78D9E8F98_1781674327 = ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.901 -0400", hash_original_method = "1653A38E1AF50A830D0C8CACED5D71E9", hash_generated_method = "989744536B4FAB79B363256CF3C2ED8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawSelector(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var101389AC9853324A8F2F4AC467A8FE5D_1193306805 = (!mSelectorRect.isEmpty());
            {
                Drawable selector;
                selector = mSelector;
                selector.setBounds(mSelectorRect);
                selector.draw(canvas);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mSelectorRect.isEmpty()) {
            //final Drawable selector = mSelector;
            //selector.setBounds(mSelectorRect);
            //selector.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.901 -0400", hash_original_method = "E224CB1DBFEAEB35D4CBDCEA1ACB7063", hash_generated_method = "AB8D63E7BB874B976FDFF81D5FA24B79")
    @DSModeled(DSC.SAFE)
    public void setDrawSelectorOnTop(boolean onTop) {
        dsTaint.addTaint(onTop);
        // ---------- Original Method ----------
        //mDrawSelectorOnTop = onTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.901 -0400", hash_original_method = "4BF5D497DEE1C8362CD452A22AD6FA64", hash_generated_method = "EFC80315A779346D37EC7EA02771A6C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelector(int resID) {
        dsTaint.addTaint(resID);
        setSelector(getResources().getDrawable(resID));
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.901 -0400", hash_original_method = "AF217D83F5B526992017BCFB165071E1", hash_generated_method = "9BB2817345AD901B19C5B68E6CF60071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelector(Drawable sel) {
        dsTaint.addTaint(sel.dsTaint);
        {
            mSelector.setCallback(null);
            unscheduleDrawable(mSelector);
        } //End block
        Rect padding;
        padding = new Rect();
        sel.getPadding(padding);
        mSelectionLeftPadding = padding.left;
        mSelectionTopPadding = padding.top;
        mSelectionRightPadding = padding.right;
        mSelectionBottomPadding = padding.bottom;
        sel.setCallback(this);
        updateSelectorState();
        // ---------- Original Method ----------
        //if (mSelector != null) {
            //mSelector.setCallback(null);
            //unscheduleDrawable(mSelector);
        //}
        //mSelector = sel;
        //Rect padding = new Rect();
        //sel.getPadding(padding);
        //mSelectionLeftPadding = padding.left;
        //mSelectionTopPadding = padding.top;
        //mSelectionRightPadding = padding.right;
        //mSelectionBottomPadding = padding.bottom;
        //sel.setCallback(this);
        //updateSelectorState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.903 -0400", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "3E3551BCDB000AE61836EA812CEAEFF5")
    @DSModeled(DSC.SAFE)
    public Drawable getSelector() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.904 -0400", hash_original_method = "2F7C78E24D2DA521609D152C286646B5", hash_generated_method = "F98451B7BBC15A6D28B23A3CE4819848")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void keyPressed() {
        {
            boolean varDBE5D4BF2CCFB471B80269545EAA1B3B_1402578274 = (!isEnabled() || !isClickable());
        } //End collapsed parenthetic
        Drawable selector;
        selector = mSelector;
        Rect selectorRect;
        selectorRect = mSelectorRect;
        {
            boolean var07FA5EC4F6C5A1F1386E6BB4E68E466A_1493147916 = (selector != null && (isFocused() || touchModeDrawsInPressedState())
                && !selectorRect.isEmpty());
            {
                View v;
                v = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    {
                        boolean varF2E1D044768D3B14172E86DA91C28BD1_207237175 = (v.hasFocusable());
                    } //End collapsed parenthetic
                    v.setPressed(true);
                } //End block
                setPressed(true);
                boolean longClickable;
                longClickable = isLongClickable();
                Drawable d;
                d = selector.getCurrent();
                {
                    {
                        ((TransitionDrawable) d).startTransition(
                            ViewConfiguration.getLongPressTimeout());
                    } //End block
                    {
                        ((TransitionDrawable) d).resetTransition();
                    } //End block
                } //End block
                {
                    {
                        mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                    } //End block
                    mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                    postDelayed(mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.904 -0400", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "A52B598080212225A16945251EC856C3")
    @DSModeled(DSC.SAFE)
    public void setScrollIndicators(View up, View down) {
        dsTaint.addTaint(down.dsTaint);
        dsTaint.addTaint(up.dsTaint);
        // ---------- Original Method ----------
        //mScrollUp = up;
        //mScrollDown = down;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.904 -0400", hash_original_method = "80EC646A43ECE5B1A4600CE8EDDA24B3", hash_generated_method = "49B1A5F0EA0503DB168815C1EA73E130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateSelectorState() {
        {
            {
                boolean var1EC35265200A237347BA89EC9F7CAA85_1853783459 = (shouldShowSelector());
                {
                    mSelector.setState(getDrawableState());
                } //End block
                {
                    mSelector.setState(StateSet.NOTHING);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mSelector != null) {
            //if (shouldShowSelector()) {
                //mSelector.setState(getDrawableState());
            //} else {
                //mSelector.setState(StateSet.NOTHING);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.905 -0400", hash_original_method = "5700D7A450170541F2788B92612441B3", hash_generated_method = "A585E16DC9FBE9BA5368D986ED938050")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateSelectorState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.905 -0400", hash_original_method = "1ED981B25374988410BBF6BB9A2499BB", hash_generated_method = "5F597C1748B74A69C125A3CF9BFEB868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_1547441642 = (super.onCreateDrawableState(extraSpace));
        } //End block
        int enabledState;
        enabledState = ENABLED_STATE_SET[0];
        int[] state;
        state = super.onCreateDrawableState(extraSpace + 1);
        int enabledPos;
        enabledPos = -1;
        {
            int i;
            i = state.length - 1;
            {
                {
                    enabledPos = i;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            System.arraycopy(state, enabledPos + 1, state, enabledPos,
                    state.length - enabledPos - 1);
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (mIsChildViewEnabled) {
            //return super.onCreateDrawableState(extraSpace);
        //}
        //final int enabledState = ENABLED_STATE_SET[0];
        //int[] state = super.onCreateDrawableState(extraSpace + 1);
        //int enabledPos = -1;
        //for (int i = state.length - 1; i >= 0; i--) {
            //if (state[i] == enabledState) {
                //enabledPos = i;
                //break;
            //}
        //}
        //if (enabledPos >= 0) {
            //System.arraycopy(state, enabledPos + 1, state, enabledPos,
                    //state.length - enabledPos - 1);
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.905 -0400", hash_original_method = "A6B05685C2044FBFF5332C34549C9055", hash_generated_method = "B78F546A4FD8234A2AA0D95EE57168E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean verifyDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        boolean var31983995A7CC0B4FFFDA846AE3697AC5_940114807 = (mSelector == dr || super.verifyDrawable(dr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSelector == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.906 -0400", hash_original_method = "7ED40C7CE5B566B3E07F33E9D37CCA58", hash_generated_method = "EEC30B3A9E5A1EA4E67E19E804024279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mSelector.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mSelector != null) mSelector.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.906 -0400", hash_original_method = "0EB97D149DFA0037A8214EEEE413FBAC", hash_generated_method = "96CF11EECD89E3A25F63B38C4749E0E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
        {
            treeObserver.addOnGlobalLayoutListener(this);
        } //End block
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        } //End block
        mIsAttached = true;
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //treeObserver.addOnTouchModeChangeListener(this);
        //if (mTextFilterEnabled && mPopup != null && !mGlobalLayoutListenerAddedFilter) {
            //treeObserver.addOnGlobalLayoutListener(this);
        //}
        //if (mAdapter != null && mDataSetObserver == null) {
            //mDataSetObserver = new AdapterDataSetObserver();
            //mAdapter.registerDataSetObserver(mDataSetObserver);
            //mDataChanged = true;
            //mOldItemCount = mItemCount;
            //mItemCount = mAdapter.getCount();
        //}
        //mIsAttached = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.906 -0400", hash_original_method = "91FA19273AD6EF1E2E7A8FCA605608DC", hash_generated_method = "02FA9D139996AD9D4D9864B60BEF8554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        dismissPopup();
        mRecycler.clear();
        ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        treeObserver.removeOnTouchModeChangeListener(this);
        {
            treeObserver.removeGlobalOnLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = false;
        } //End block
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        } //End block
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } //End block
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } //End block
        {
            removeCallbacks(mFlingRunnable);
        } //End block
        {
            mPositionScroller.stop();
        } //End block
        {
            removeCallbacks(mClearScrollingCache);
        } //End block
        {
            removeCallbacks(mPerformClick);
        } //End block
        {
            removeCallbacks(mTouchModeReset);
            mTouchModeReset = null;
        } //End block
        mIsAttached = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.907 -0400", hash_original_method = "F46E1D5E69E9A7961CEAA1CC31FCC74A", hash_generated_method = "491961ABB46772F9A46042E7A087AB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        int touchMode;
        boolean var49D8D6F90114322BA24D8547EE3F7B5B_159981330 = (isInTouchMode());
        touchMode = TOUCH_MODE_ON;
        touchMode = TOUCH_MODE_OFF;
        {
            setChildrenDrawingCacheEnabled(false);
            {
                removeCallbacks(mFlingRunnable);
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } //End block
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } //End block
            } //End block
            dismissPopup();
            {
                mResurrectToPosition = mSelectedPosition;
            } //End block
        } //End block
        {
            {
                showPopup();
            } //End block
            {
                {
                    resurrectSelection();
                } //End block
                {
                    hideSelector();
                    mLayoutMode = LAYOUT_NORMAL;
                    layoutChildren();
                } //End block
            } //End block
        } //End block
        mLastTouchMode = touchMode;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.907 -0400", hash_original_method = "5DA1B21EB8CB635B0040E7A9E537D496", hash_generated_method = "60F1FE54AE1709036EF47E0F86B9157C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ContextMenuInfo createContextMenuInfo(View view, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(view.dsTaint);
        ContextMenuInfo varF2CC585BB1D5C76D3B6245ED524C2BD7_2004199253 = (new AdapterContextMenuInfo(view, position, id));
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AdapterContextMenuInfo(view, position, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.907 -0400", hash_original_method = "5D95BDE73AAD1EC9BDE83FD3189DFC34", hash_generated_method = "7BD7D3F7F293268F1550E354063BD62E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(longPressId);
        dsTaint.addTaint(longPressPosition);
        {
            {
                boolean var00E98D05004FD0330F18AA64B0748865_1705023414 = (mChoiceActionMode == null &&
                    (mChoiceActionMode = startActionMode(mMultiChoiceModeCallback)) != null);
                {
                    setItemChecked(longPressPosition, true);
                    performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean handled;
        handled = false;
        {
            handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, child,
                    longPressPosition, longPressId);
        } //End block
        {
            mContextMenuInfo = createContextMenuInfo(child, longPressPosition, longPressId);
            handled = super.showContextMenuForChild(AbsListView.this);
        } //End block
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.908 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "57ABEC3685CFF14DEEC9B4536E36B652")
    @DSModeled(DSC.SAFE)
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContextMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.908 -0400", hash_original_method = "720F76E8125C4C6521A83756BA0DD98B", hash_generated_method = "F3B913192DEB62F3AF9B400B49E15695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean showContextMenu(float x, float y, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int position;
        position = pointToPosition((int)x, (int)y);
        {
            long id;
            id = mAdapter.getItemId(position);
            View child;
            child = getChildAt(position - mFirstPosition);
            {
                mContextMenuInfo = createContextMenuInfo(child, position, id);
                boolean var8897B192E808AB3EDB293923745D2D74_1814436822 = (super.showContextMenuForChild(AbsListView.this));
            } //End block
        } //End block
        boolean varE458CA81039B0A7729D96AA8ED00D0B8_925482266 = (super.showContextMenu(x, y, metaState));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int position = pointToPosition((int)x, (int)y);
        //if (position != INVALID_POSITION) {
            //final long id = mAdapter.getItemId(position);
            //View child = getChildAt(position - mFirstPosition);
            //if (child != null) {
                //mContextMenuInfo = createContextMenuInfo(child, position, id);
                //return super.showContextMenuForChild(AbsListView.this);
            //}
        //}
        //return super.showContextMenu(x, y, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.908 -0400", hash_original_method = "13B8C0CF7E224AA8E52D13CB23050F48", hash_generated_method = "C709AA649F4DA649BC1E5977EB11453B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean showContextMenuForChild(View originalView) {
        dsTaint.addTaint(originalView.dsTaint);
        int longPressPosition;
        longPressPosition = getPositionForView(originalView);
        {
            long longPressId;
            longPressId = mAdapter.getItemId(longPressPosition);
            boolean handled;
            handled = false;
            {
                handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, originalView,
                        longPressPosition, longPressId);
            } //End block
            {
                mContextMenuInfo = createContextMenuInfo(
                        getChildAt(longPressPosition - mFirstPosition),
                        longPressPosition, longPressId);
                handled = super.showContextMenuForChild(originalView);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int longPressPosition = getPositionForView(originalView);
        //if (longPressPosition >= 0) {
            //final long longPressId = mAdapter.getItemId(longPressPosition);
            //boolean handled = false;
            //if (mOnItemLongClickListener != null) {
                //handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, originalView,
                        //longPressPosition, longPressId);
            //}
            //if (!handled) {
                //mContextMenuInfo = createContextMenuInfo(
                        //getChildAt(longPressPosition - mFirstPosition),
                        //longPressPosition, longPressId);
                //handled = super.showContextMenuForChild(originalView);
            //}
            //return handled;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.909 -0400", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "5C8FCF841EA61740C997F251F5AA2125")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.909 -0400", hash_original_method = "DD8448F1B5F23CC0AD3E4D53FFC7D294", hash_generated_method = "CCC456E0F3523CEE157E5BC9D4241C58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1573554250 = (!isEnabled());
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD23167BEA6670E541F842804D07343DD_1538363282 = (isClickable() && isPressed() &&
                    mSelectedPosition >= 0 && mAdapter != null &&
                    mSelectedPosition < mAdapter.getCount());
            {
                View view;
                view = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    performItemClick(view, mSelectedPosition, mSelectedRowId);
                    view.setPressed(false);
                } //End block
                setPressed(false);
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        boolean varEDD771EBF66425AD21882AB08CD0EE48_706237882 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (keyCode) {
        //case KeyEvent.KEYCODE_DPAD_CENTER:
        //case KeyEvent.KEYCODE_ENTER:
            //if (!isEnabled()) {
                //return true;
            //}
            //if (isClickable() && isPressed() &&
                    //mSelectedPosition >= 0 && mAdapter != null &&
                    //mSelectedPosition < mAdapter.getCount()) {
                //final View view = getChildAt(mSelectedPosition - mFirstPosition);
                //if (view != null) {
                    //performItemClick(view, mSelectedPosition, mSelectedRowId);
                    //view.setPressed(false);
                //}
                //setPressed(false);
                //return true;
            //}
            //break;
        //}
        //return super.onKeyUp(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.909 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "588068610EA441BC765E85D3FD628CE7")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.909 -0400", hash_original_method = "C5D265B49C06947929C542FAD6DD4910", hash_generated_method = "DDE13B65981FDDEB7FD408BE4BD1A0AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pointToPosition(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        Rect frame;
        frame = mTouchFrame;
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } //End block
        int count;
        count = getChildCount();
        {
            int i;
            i = count - 1;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var02E23769C3E76AF1DC2C1CE956107022_1268861994 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_1150749719 = (frame.contains(x, y));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Rect frame = mTouchFrame;
        //if (frame == null) {
            //mTouchFrame = new Rect();
            //frame = mTouchFrame;
        //}
        //final int count = getChildCount();
        //for (int i = count - 1; i >= 0; i--) {
            //final View child = getChildAt(i);
            //if (child.getVisibility() == View.VISIBLE) {
                //child.getHitRect(frame);
                //if (frame.contains(x, y)) {
                    //return mFirstPosition + i;
                //}
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.910 -0400", hash_original_method = "0CE0E010C97C81E4AEC085897948D819", hash_generated_method = "D03E970FF502DA83F3F7411DCE7D7FEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long pointToRowId(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int position;
        position = pointToPosition(x, y);
        {
            long varD18EE374A3F0927116BA59F2A9A03256_1229468816 = (mAdapter.getItemId(position));
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //int position = pointToPosition(x, y);
        //if (position >= 0) {
            //return mAdapter.getItemId(position);
        //}
        //return INVALID_ROW_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.910 -0400", hash_original_method = "5EE86ADCFB65EEBAD1CBAFF86BFF869E", hash_generated_method = "C41C276E759C97DBBD65A956819059D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean startScrollIfNeeded(int y) {
        dsTaint.addTaint(y);
        int deltaY;
        deltaY = y - mMotionY;
        int distance;
        distance = Math.abs(deltaY);
        boolean overscroll;
        overscroll = mScrollY != 0;
        {
            createScrollingCache();
            {
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionCorrection = 0;
            } //End block
            {
                mTouchMode = TOUCH_MODE_SCROLL;
                mMotionCorrection = deltaY > 0 ? mTouchSlop : -mTouchSlop;
            } //End block
            Handler handler;
            handler = getHandler();
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } //End block
            setPressed(false);
            View motionView;
            motionView = getChildAt(mMotionPosition - mFirstPosition);
            {
                motionView.setPressed(false);
            } //End block
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            ViewParent parent;
            parent = getParent();
            {
                parent.requestDisallowInterceptTouchEvent(true);
            } //End block
            scrollIfNeeded(y);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.912 -0400", hash_original_method = "24BFB982D66DDF27FDD0EB3AFC04A401", hash_generated_method = "36C805AFC1A4A76D38531E6559401C90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void scrollIfNeeded(int y) {
        dsTaint.addTaint(y);
        int rawDeltaY;
        rawDeltaY = y - mMotionY;
        int deltaY;
        deltaY = rawDeltaY - mMotionCorrection;
        int incrementalDeltaY;
        incrementalDeltaY = y - mLastY;
        incrementalDeltaY = deltaY;
        {
            {
                {
                    Debug.startMethodTracing("AbsListViewScroll");
                    mScrollProfilingStarted = true;
                } //End block
            } //End block
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("AbsListView-scroll");
            } //End block
            {
                {
                    boolean var3B6B3092E9AEF7EFB8F7DB7C1090C559_562748865 = ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) == 0 &&
                        Math.abs(rawDeltaY) > mTouchSlop);
                    {
                        ViewParent parent;
                        parent = getParent();
                        {
                            parent.requestDisallowInterceptTouchEvent(true);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int motionIndex;
                {
                    motionIndex = mMotionPosition - mFirstPosition;
                } //End block
                {
                    motionIndex = getChildCount() / 2;
                } //End block
                int motionViewPrevTop;
                motionViewPrevTop = 0;
                View motionView;
                motionView = this.getChildAt(motionIndex);
                {
                    motionViewPrevTop = motionView.getTop();
                } //End block
                boolean atEdge;
                atEdge = false;
                {
                    atEdge = trackMotionScroll(deltaY, incrementalDeltaY);
                } //End block
                motionView = this.getChildAt(motionIndex);
                {
                    int motionViewRealTop;
                    motionViewRealTop = motionView.getTop();
                    {
                        int overscroll;
                        overscroll = -incrementalDeltaY -
                                (motionViewRealTop - motionViewPrevTop);
                        overScrollBy(0, overscroll, 0, mScrollY, 0, 0,
                                0, mOverscrollDistance, true);
                        {
                            boolean var879507118E22A9A52AEA797A263AF84E_552005849 = (Math.abs(mOverscrollDistance) == Math.abs(mScrollY));
                            {
                                {
                                    mVelocityTracker.clear();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        int overscrollMode;
                        overscrollMode = getOverScrollMode();
                        {
                            boolean varAE1D066723B1EA15FA5C10A14D662F56_1357160970 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                                (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                        !contentFits()));
                            {
                                mDirection = 0;
                                mTouchMode = TOUCH_MODE_OVERSCROLL;
                                {
                                    mEdgeGlowTop.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varA87047F469C00113B6AE83492D7AB59C_1974567223 = (!mEdgeGlowBottom.isFinished());
                                        {
                                            mEdgeGlowBottom.onRelease();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    mEdgeGlowBottom.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varF30E150A7784B932CC0A99DAB3E3524A_1135714768 = (!mEdgeGlowTop.isFinished());
                                        {
                                            mEdgeGlowTop.onRelease();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    invalidate();
                } //End block
            } //End block
        } //End block
        {
            {
                int oldScroll;
                oldScroll = mScrollY;
                int newScroll;
                newScroll = oldScroll - incrementalDeltaY;
                int newDirection;
                newDirection = 1;
                newDirection = -1;
                {
                    mDirection = newDirection;
                } //End block
                int overScrollDistance;
                overScrollDistance = -incrementalDeltaY;
                {
                    overScrollDistance = -oldScroll;
                    incrementalDeltaY += overScrollDistance;
                } //End block
                {
                    incrementalDeltaY = 0;
                } //End block
                {
                    overScrollBy(0, overScrollDistance, 0, mScrollY, 0, 0,
                            0, mOverscrollDistance, true);
                    int overscrollMode;
                    overscrollMode = getOverScrollMode();
                    {
                        boolean varA17BFA05D97ECE222863450A9B7218E6_84770267 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                    !contentFits()));
                        {
                            {
                                mEdgeGlowTop.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var352E8E7760F8F011E79FB28EFE62DA73_1469659308 = (!mEdgeGlowBottom.isFinished());
                                    {
                                        mEdgeGlowBottom.onRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                mEdgeGlowBottom.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var530787B3C000358ED8C3E02B71DC0120_505666298 = (!mEdgeGlowTop.isFinished());
                                    {
                                        mEdgeGlowTop.onRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mScrollY = 0;
                    invalidateParentIfNeeded();
                    {
                        trackMotionScroll(incrementalDeltaY, incrementalDeltaY);
                    } //End block
                    mTouchMode = TOUCH_MODE_SCROLL;
                    int motionPosition;
                    motionPosition = findClosestMotionRow(y);
                    mMotionCorrection = 0;
                    View motionView;
                    motionView = getChildAt(motionPosition - mFirstPosition);
                    mMotionViewOriginalTop = motionView != null ? motionView.getTop() : 0;
                    mMotionPosition = motionPosition;
                } //End block
                mDirection = newDirection;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.913 -0400", hash_original_method = "6F0203AFDEF2DCB43412C3F5E7A63F8C", hash_generated_method = "26128C9F284BEE4372BBF02DDC6AB3B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTouchModeChanged(boolean isInTouchMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isInTouchMode);
        {
            hideSelector();
            {
                boolean var18FDA06F2E4C20DCFBA70CFDB1F209F6_703086818 = (getHeight() > 0 && getChildCount() > 0);
                {
                    layoutChildren();
                } //End block
            } //End collapsed parenthetic
            updateSelectorState();
        } //End block
        {
            int touchMode;
            touchMode = mTouchMode;
            {
                {
                    mFlingRunnable.endFling();
                } //End block
                {
                    mPositionScroller.stop();
                } //End block
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.917 -0400", hash_original_method = "EC498F7AA9A002C93696F04D5F90A9F2", hash_generated_method = "AC87139408E5CD68FA5003054244F726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_690738777 = (!isEnabled());
            {
                boolean var78B3B137E9725C8407DD55321B456099_1591938481 = (isClickable() || isLongClickable());
            } //End block
        } //End collapsed parenthetic
        {
            boolean intercepted;
            intercepted = mFastScroller.onTouchEvent(ev);
        } //End block
        int action;
        action = ev.getAction();
        View v;
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        //Begin case MotionEvent.ACTION_DOWN 
        {
            //Begin case TOUCH_MODE_OVERFLING 
            {
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } //End block
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionX = (int) ev.getX();
                mMotionY = mLastY = (int) ev.getY();
                mMotionCorrection = 0;
                mActivePointerId = ev.getPointerId(0);
                mDirection = 0;
            } //End block
            //End case TOUCH_MODE_OVERFLING 
            //Begin case default 
            {
                mActivePointerId = ev.getPointerId(0);
                int x;
                x = (int) ev.getX();
                int y;
                y = (int) ev.getY();
                int motionPosition;
                motionPosition = pointToPosition(x, y);
                {
                    {
                        boolean varD00D6114E840F55D6764F4976AFF0726_630073272 = ((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0)
                            && (getAdapter().isEnabled(motionPosition)));
                        {
                            mTouchMode = TOUCH_MODE_DOWN;
                            {
                                mPendingCheckForTap = new CheckForTap();
                            } //End block
                            postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        } //End block
                        {
                            {
                                createScrollingCache();
                                mTouchMode = TOUCH_MODE_SCROLL;
                                mMotionCorrection = 0;
                                motionPosition = findMotionRow(y);
                                mFlingRunnable.flywheelTouch();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    v = getChildAt(motionPosition - mFirstPosition);
                    mMotionViewOriginalTop = v.getTop();
                } //End block
                mMotionX = x;
                mMotionY = y;
                mMotionPosition = motionPosition;
                mLastY = Integer.MIN_VALUE;
            } //End block
            //End case default 
            {
                boolean var10762BA5807EC5420815666D17984CE3_687239067 = (performButtonActionOnTouchDown(ev));
                {
                    {
                        removeCallbacks(mPendingCheckForTap);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            int pointerIndex;
            pointerIndex = ev.findPointerIndex(mActivePointerId);
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } //End block
            int y;
            y = (int) ev.getY(pointerIndex);
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            startScrollIfNeeded(y);
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_SCROLL TOUCH_MODE_OVERSCROLL 
            scrollIfNeeded(y);
            //End case TOUCH_MODE_SCROLL TOUCH_MODE_OVERSCROLL 
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            int motionPosition;
            motionPosition = mMotionPosition;
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            View child;
            child = getChildAt(motionPosition - mFirstPosition);
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            float x;
            x = ev.getX();
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            boolean inList;
            inList = x > mListPadding.left && x < getWidth() - mListPadding.right;
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            {
                boolean var645943845E190A2FFA4FE7562EA898F8_401426028 = (child != null && !child.hasFocusable() && inList);
                {
                    {
                        child.setPressed(false);
                    } //End block
                    {
                        mPerformClick = new PerformClick();
                    } //End block
                    AbsListView.PerformClick performClick;
                    performClick = mPerformClick;
                    performClick.mClickMotionPosition = motionPosition;
                    performClick.rememberWindowAttachCount();
                    mResurrectToPosition = motionPosition;
                    {
                        Handler handler;
                        handler = getHandler();
                        {
                            handler.removeCallbacks(mTouchMode == TOUCH_MODE_DOWN ?
                                    mPendingCheckForTap : mPendingCheckForLongPress);
                        } //End block
                        mLayoutMode = LAYOUT_NORMAL;
                        {
                            boolean varAD4E45D7D3DB8FFF6E14B37863D65B2D_2096578998 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
                            {
                                mTouchMode = TOUCH_MODE_TAP;
                                setSelectedPositionInt(mMotionPosition);
                                layoutChildren();
                                child.setPressed(true);
                                positionSelector(mMotionPosition, child);
                                setPressed(true);
                                {
                                    Drawable d;
                                    d = mSelector.getCurrent();
                                    {
                                        ((TransitionDrawable) d).resetTransition();
                                    } //End block
                                } //End block
                                {
                                    removeCallbacks(mTouchModeReset);
                                } //End block
                                mTouchModeReset = new Runnable() {                                    
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.915 -0400", hash_original_method = "A6EC1D4E4E60E1E8895C51DF141E43B7", hash_generated_method = "9285F265A17C80263E536A0E27728322")
                                    //DSFIXME:  CODE0002: Requires DSC value to be set
                                    @Override
                                    public void run() {
                                        mTouchMode = TOUCH_MODE_REST;
                                        child.setPressed(false);
                                        setPressed(false);
                                        {
                                            performClick.run();
                                        } //End block
                                        // ---------- Original Method ----------
                                        //mTouchMode = TOUCH_MODE_REST;
                                        //child.setPressed(false);
                                        //setPressed(false);
                                        //if (!mDataChanged) {
                                        //performClick.run();
                                    //}
                                    }
};
                                postDelayed(mTouchModeReset,
                                    ViewConfiguration.getPressedStateDuration());
                            } //End block
                            {
                                mTouchMode = TOUCH_MODE_REST;
                                updateSelectorState();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var523699F24A476A31015FCD9CC5BA98D8_763150980 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
                        {
                            performClick.run();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            mTouchMode = TOUCH_MODE_REST;
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            updateSelectorState();
            //End case TOUCH_MODE_DOWN TOUCH_MODE_TAP TOUCH_MODE_DONE_WAITING 
            //Begin case TOUCH_MODE_SCROLL 
            int childCount;
            childCount = getChildCount();
            //End case TOUCH_MODE_SCROLL 
            //Begin case TOUCH_MODE_SCROLL 
            {
                int firstChildTop;
                firstChildTop = getChildAt(0).getTop();
                int lastChildBottom;
                lastChildBottom = getChildAt(childCount - 1).getBottom();
                int contentTop;
                contentTop = mListPadding.top;
                int contentBottom;
                contentBottom = getHeight() - mListPadding.bottom;
                {
                    boolean varE3D06501EDBEFC68EB729C2818A34655_118178916 = (mFirstPosition == 0 && firstChildTop >= contentTop &&
                            mFirstPosition + childCount < mItemCount &&
                            lastChildBottom <= getHeight() - contentBottom);
                    {
                        mTouchMode = TOUCH_MODE_REST;
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                    } //End block
                    {
                        VelocityTracker velocityTracker;
                        velocityTracker = mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                        int initialVelocity;
                        initialVelocity = (int)
                                (velocityTracker.getYVelocity(mActivePointerId) * mVelocityScale);
                        {
                            boolean varD48B4459D536B53F6277D9F8CEC82F89_912190553 = (Math.abs(initialVelocity) > mMinimumVelocity &&
                                !((mFirstPosition == 0 &&
                                        firstChildTop == contentTop - mOverscrollDistance) ||
                                  (mFirstPosition + childCount == mItemCount &&
                                        lastChildBottom == contentBottom + mOverscrollDistance)));
                            {
                                {
                                    mFlingRunnable = new FlingRunnable();
                                } //End block
                                reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                                mFlingRunnable.start(-initialVelocity);
                            } //End block
                            {
                                mTouchMode = TOUCH_MODE_REST;
                                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                                {
                                    mFlingRunnable.endFling();
                                } //End block
                                {
                                    mPositionScroller.stop();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mTouchMode = TOUCH_MODE_REST;
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } //End block
            //End case TOUCH_MODE_SCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            {
                mFlingRunnable = new FlingRunnable();
            } //End block
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            VelocityTracker velocityTracker;
            velocityTracker = mVelocityTracker;
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            int initialVelocity;
            initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            {
                boolean varA56DF990188ABEF5AF3A9E103B5F2778_1100204278 = (Math.abs(initialVelocity) > mMinimumVelocity);
                {
                    mFlingRunnable.startOverfling(-initialVelocity);
                } //End block
                {
                    mFlingRunnable.startSpringback();
                } //End block
            } //End collapsed parenthetic
            //End case TOUCH_MODE_OVERSCROLL 
            setPressed(false);
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } //End block
            invalidate();
            Handler handler;
            handler = getHandler();
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } //End block
            recycleVelocityTracker();
            mActivePointerId = INVALID_POINTER;
            {
                {
                    Debug.stopMethodTracing();
                    mScrollProfilingStarted = false;
                } //End block
            } //End block
            {
                mScrollStrictSpan.finish();
                mScrollStrictSpan = null;
            } //End block
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            //Begin case TOUCH_MODE_OVERSCROLL 
            {
                mFlingRunnable = new FlingRunnable();
            } //End block
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case TOUCH_MODE_OVERSCROLL 
            mFlingRunnable.startSpringback();
            //End case TOUCH_MODE_OVERSCROLL 
            //Begin case default 
            mTouchMode = TOUCH_MODE_REST;
            //End case default 
            //Begin case default 
            setPressed(false);
            //End case default 
            //Begin case default 
            View motionView;
            motionView = this.getChildAt(mMotionPosition - mFirstPosition);
            //End case default 
            //Begin case default 
            {
                motionView.setPressed(false);
            } //End block
            //End case default 
            //Begin case default 
            clearScrollingCache();
            //End case default 
            //Begin case default 
            Handler handler;
            handler = getHandler();
            //End case default 
            //Begin case default 
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } //End block
            //End case default 
            //Begin case default 
            recycleVelocityTracker();
            //End case default 
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } //End block
            mActivePointerId = INVALID_POINTER;
        } //End block
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        {
            onSecondaryPointerUp(ev);
            int x;
            x = mMotionX;
            int y;
            y = mMotionY;
            int motionPosition;
            motionPosition = pointToPosition(x, y);
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } //End block
            mLastY = y;
        } //End block
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            int index;
            index = ev.getActionIndex();
            int id;
            id = ev.getPointerId(index);
            int x;
            x = (int) ev.getX(index);
            int y;
            y = (int) ev.getY(index);
            mMotionCorrection = 0;
            mActivePointerId = id;
            mMotionX = x;
            mMotionY = y;
            int motionPosition;
            motionPosition = pointToPosition(x, y);
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } //End block
            mLastY = y;
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.919 -0400", hash_original_method = "3A1744A3CB770F6FD9FFEB222E666622", hash_generated_method = "C3D321F63F15196E9B48041AC8DD9278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(scrollY);
        dsTaint.addTaint(scrollX);
        dsTaint.addTaint(clampedY);
        dsTaint.addTaint(clampedX);
        {
            onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            awakenScrollBars();
        } //End block
        // ---------- Original Method ----------
        //if (mScrollY != scrollY) {
            //onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            //mScrollY = scrollY;
            //invalidateParentIfNeeded();
            //awakenScrollBars();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.922 -0400", hash_original_method = "09132BF5E477A2B233231E384E8A2F27", hash_generated_method = "7F0F56296CE7617ED732C376564F05B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1122550591 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1386479552 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float vscroll;
                            vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                int delta;
                                delta = (int) (vscroll * getVerticalScrollFactor());
                                {
                                    boolean var5104A1C3A4166DC9AEBE0F45BFBBFDA2_833337480 = (!trackMotionScroll(delta, delta));
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_867560244 = (super.onGenericMotionEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            //switch (event.getAction()) {
                //case MotionEvent.ACTION_SCROLL: {
                    //if (mTouchMode == TOUCH_MODE_REST) {
                        //final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                        //if (vscroll != 0) {
                            //final int delta = (int) (vscroll * getVerticalScrollFactor());
                            //if (!trackMotionScroll(delta, delta)) {
                                //return true;
                            //}
                        //}
                    //}
                //}
            //}
        //}
        //return super.onGenericMotionEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.924 -0400", hash_original_method = "F146D016CF32B873211A043EDB782604", hash_generated_method = "21996382AF613580D1D896E3A6DDBE9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.draw(canvas);
        {
            int scrollY;
            scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_1632044324 = (!mEdgeGlowTop.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int leftPadding;
                    leftPadding = mListPadding.left + mGlowPaddingLeft;
                    int rightPadding;
                    rightPadding = mListPadding.right + mGlowPaddingRight;
                    int width;
                    width = getWidth() - leftPadding - rightPadding;
                    canvas.translate(leftPadding,
                        Math.min(0, scrollY + mFirstPositionDistanceGuess));
                    mEdgeGlowTop.setSize(width, getHeight());
                    {
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_816610988 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_2030760443 = (!mEdgeGlowBottom.isFinished());
                {
                    int restoreCount;
                    restoreCount = canvas.save();
                    int leftPadding;
                    leftPadding = mListPadding.left + mGlowPaddingLeft;
                    int rightPadding;
                    rightPadding = mListPadding.right + mGlowPaddingRight;
                    int width;
                    width = getWidth() - leftPadding - rightPadding;
                    int height;
                    height = getHeight();
                    canvas.translate(-width + leftPadding,
                        Math.max(height, scrollY + mLastPositionDistanceGuess));
                    canvas.rotate(180, width, 0);
                    mEdgeGlowBottom.setSize(width, height);
                    {
                        boolean var61CCF9557D478E1494862B3636E22888_1893321444 = (mEdgeGlowBottom.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int scrollY;
            scrollY = mScrollY;
            {
                int restoreCount;
                restoreCount = canvas.save();
                canvas.translate(0, (float) scrollY);
                mFastScroller.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
            {
                mFastScroller.draw(canvas);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.924 -0400", hash_original_method = "9FFFDAFD9442A3DE6BE69946897AC2B3", hash_generated_method = "916746AD2943400B2F5E574487D12E4A")
    @DSModeled(DSC.SAFE)
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding) {
        dsTaint.addTaint(leftPadding);
        dsTaint.addTaint(rightPadding);
        // ---------- Original Method ----------
        //mGlowPaddingLeft = leftPadding;
        //mGlowPaddingRight = rightPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.924 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        {
            mVelocityTracker.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //} else {
            //mVelocityTracker.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.924 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.925 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recycleVelocityTracker() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.925 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "865CE72BE478ED109800CF1DEE433CDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        dsTaint.addTaint(disallowIntercept);
        {
            recycleVelocityTracker();
        } //End block
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept) {
            //recycleVelocityTracker();
        //}
        //super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.926 -0400", hash_original_method = "BEACBA96FA37C833811279893053B3A1", hash_generated_method = "9672C39E50FE7D7C84AB9A197454B928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        int action;
        action = ev.getAction();
        View v;
        {
            boolean intercepted;
            intercepted = mFastScroller.onInterceptTouchEvent(ev);
        } //End block
        //Begin case MotionEvent.ACTION_DOWN 
        {
            int touchMode;
            touchMode = mTouchMode;
            {
                mMotionCorrection = 0;
            } //End block
            int x;
            x = (int) ev.getX();
            int y;
            y = (int) ev.getY();
            mActivePointerId = ev.getPointerId(0);
            int motionPosition;
            motionPosition = findMotionRow(y);
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionX = x;
                mMotionY = y;
                mMotionPosition = motionPosition;
                mTouchMode = TOUCH_MODE_DOWN;
                clearScrollingCache();
            } //End block
            mLastY = Integer.MIN_VALUE;
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            //Begin case TOUCH_MODE_DOWN 
            int pointerIndex;
            pointerIndex = ev.findPointerIndex(mActivePointerId);
            //End case TOUCH_MODE_DOWN 
            //Begin case TOUCH_MODE_DOWN 
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } //End block
            //End case TOUCH_MODE_DOWN 
            //Begin case TOUCH_MODE_DOWN 
            int y;
            y = (int) ev.getY(pointerIndex);
            //End case TOUCH_MODE_DOWN 
            //Begin case TOUCH_MODE_DOWN 
            initVelocityTrackerIfNotExists();
            //End case TOUCH_MODE_DOWN 
            //Begin case TOUCH_MODE_DOWN 
            mVelocityTracker.addMovement(ev);
            //End case TOUCH_MODE_DOWN 
            //Begin case TOUCH_MODE_DOWN 
            {
                boolean varBEAADC7EDD4EC70730C4344D280FA313_509258071 = (startScrollIfNeeded(y));
            } //End collapsed parenthetic
            //End case TOUCH_MODE_DOWN 
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        {
            mTouchMode = TOUCH_MODE_REST;
            mActivePointerId = INVALID_POINTER;
            recycleVelocityTracker();
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
        } //End block
        //End case MotionEvent.ACTION_CANCEL MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        {
            onSecondaryPointerUp(ev);
        } //End block
        //End case MotionEvent.ACTION_POINTER_UP 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.926 -0400", hash_original_method = "C5DD3809C32C06AD527DF2275274EBCF", hash_generated_method = "04F6C4C45B8D8E5C8AFAD207C55A0CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSecondaryPointerUp(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        int pointerIndex;
        pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        int pointerId;
        pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mMotionX = (int) ev.getX(newPointerIndex);
            mMotionY = (int) ev.getY(newPointerIndex);
            mMotionCorrection = 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
        } //End block
        // ---------- Original Method ----------
        //final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                //MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        //final int pointerId = ev.getPointerId(pointerIndex);
        //if (pointerId == mActivePointerId) {
            //final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            //mMotionX = (int) ev.getX(newPointerIndex);
            //mMotionY = (int) ev.getY(newPointerIndex);
            //mMotionCorrection = 0;
            //mActivePointerId = ev.getPointerId(newPointerIndex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.926 -0400", hash_original_method = "7406EAB31F4F45208F8FFDB2641D9148", hash_generated_method = "28B9D12D097768B99920B9B98BD028A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addTouchables(ArrayList<View> views) {
        dsTaint.addTaint(views.dsTaint);
        int count;
        count = getChildCount();
        int firstPosition;
        firstPosition = mFirstPosition;
        ListAdapter adapter;
        adapter = mAdapter;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var2E8FCA4FD70E922109B068B9683F621A_1592616122 = (adapter.isEnabled(firstPosition + i));
                    {
                        views.add(child);
                    } //End block
                } //End collapsed parenthetic
                child.addTouchables(views);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //final int firstPosition = mFirstPosition;
        //final ListAdapter adapter = mAdapter;
        //if (adapter == null) {
            //return;
        //}
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (adapter.isEnabled(firstPosition + i)) {
                //views.add(child);
            //}
            //child.addTouchables(views);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.927 -0400", hash_original_method = "53B60DC92C627A12BA76D6AAFD79D448", hash_generated_method = "B6EDA761563C38897E878DD8DAFF6AA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reportScrollStateChange(int newState) {
        dsTaint.addTaint(newState);
        {
            {
                mOnScrollListener.onScrollStateChanged(this, newState);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (newState != mLastScrollState) {
            //if (mOnScrollListener != null) {
                //mLastScrollState = newState;
                //mOnScrollListener.onScrollStateChanged(this, newState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.927 -0400", hash_original_method = "09656A4DFD81148F85DAB6B80BBEDF83", hash_generated_method = "7800391024A0CF9871D887A7676040FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFriction(float friction) {
        dsTaint.addTaint(friction);
        {
            mFlingRunnable = new FlingRunnable();
        } //End block
        mFlingRunnable.mScroller.setFriction(friction);
        // ---------- Original Method ----------
        //if (mFlingRunnable == null) {
            //mFlingRunnable = new FlingRunnable();
        //}
        //mFlingRunnable.mScroller.setFriction(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.927 -0400", hash_original_method = "0A97F6C2B71DEE1A9A851FDFBE6F2171", hash_generated_method = "91E5D1A44CA7EBC5AF64BBB8AC3169F7")
    @DSModeled(DSC.SAFE)
    public void setVelocityScale(float scale) {
        dsTaint.addTaint(scale);
        // ---------- Original Method ----------
        //mVelocityScale = scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.927 -0400", hash_original_method = "5ADECEDEBCB45348FEE18FEA2660C669", hash_generated_method = "342075910B25B1F6113E19C0BF01C83A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollToPosition(int position) {
        dsTaint.addTaint(position);
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.start(position);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.start(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.928 -0400", hash_original_method = "8931967DEF21C4BF02F7EE5F6DA25484", hash_generated_method = "9F5C9A9881026F39BF45BFAD70D2B334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(duration);
        dsTaint.addTaint(offset);
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.startWithOffset(position, offset, duration);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.startWithOffset(position, offset, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.928 -0400", hash_original_method = "481FD979A7BEB05C5D5FED69D6209380", hash_generated_method = "2B5313DA57C209B47792FB8F7A171331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollToPositionFromTop(int position, int offset) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(offset);
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.startWithOffset(position, offset);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.startWithOffset(position, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.928 -0400", hash_original_method = "D55175FA7A4D56B1E1633A69B89BF26C", hash_generated_method = "CDB89FC022A42126959964625AE8367F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollToPosition(int position, int boundPosition) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(boundPosition);
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.start(position, boundPosition);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.start(position, boundPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.929 -0400", hash_original_method = "F38F4C8B27D75B9B07425BD626A4F57B", hash_generated_method = "96FC32C4ED1A2C9B1090E64B67CBF569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollBy(int distance, int duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(distance);
        {
            mFlingRunnable = new FlingRunnable();
        } //End block
        int firstPos;
        firstPos = mFirstPosition;
        int childCount;
        childCount = getChildCount();
        int lastPos;
        lastPos = firstPos + childCount;
        int topLimit;
        topLimit = getPaddingTop();
        int bottomLimit;
        bottomLimit = getHeight() - getPaddingBottom();
        {
            boolean varE771752E61AAE94EE838BEB839D51E29_75631933 = (distance == 0 || mItemCount == 0 || childCount == 0 ||
                (firstPos == 0 && getChildAt(0).getTop() == topLimit && distance < 0) ||
                (lastPos == mItemCount - 1 &&
                        getChildAt(childCount - 1).getBottom() == bottomLimit && distance > 0));
            {
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } //End block
            } //End block
            {
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                mFlingRunnable.startScroll(distance, duration);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.929 -0400", hash_original_method = "C17AB5094757737D3C9F6E76AFA310E4", hash_generated_method = "6A75ED8DC449FC2507F3B586D49A0F2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void smoothScrollByOffset(int position) {
        dsTaint.addTaint(position);
        int index;
        index = -1;
        {
            index = getFirstVisiblePosition();
        } //End block
        {
            index = getLastVisiblePosition();
        } //End block
        {
            View child;
            child = getChildAt(index - getFirstVisiblePosition());
            {
                Rect visibleRect;
                visibleRect = new Rect();
                {
                    boolean var18BDB2D3799631890650FD697075D5F9_533954761 = (child.getGlobalVisibleRect(visibleRect));
                    {
                        int childRectArea;
                        childRectArea = child.getWidth() * child.getHeight();
                        int visibleRectArea;
                        visibleRectArea = visibleRect.width() * visibleRect.height();
                        float visibleArea;
                        visibleArea = (visibleRectArea / (float) childRectArea);
                        float visibleThreshold;
                        visibleThreshold = 0.75f;
                    } //End block
                } //End collapsed parenthetic
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), index + position)));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.929 -0400", hash_original_method = "81BA0C283B501CA4B76891C73CF6304F", hash_generated_method = "4F2D2548096503CB8CD1B64A3B2D9FBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createScrollingCache() {
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingStarted = mCachingActive = true;
        } //End block
        // ---------- Original Method ----------
        //if (mScrollingCacheEnabled && !mCachingStarted) {
            //setChildrenDrawnWithCacheEnabled(true);
            //setChildrenDrawingCacheEnabled(true);
            //mCachingStarted = mCachingActive = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.930 -0400", hash_original_method = "5EE1F7DCF1506371E8A50F14184A0F0B", hash_generated_method = "66B6F773E23DD3CDA7121D19B16E38A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearScrollingCache() {
        {
            mClearScrollingCache = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.930 -0400", hash_original_method = "C1A06A57DD958FE417CF10EBDAA96EFE", hash_generated_method = "0B75BFD431919831E51B40289256A127")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    {
                        mCachingStarted = mCachingActive = false;
                        setChildrenDrawnWithCacheEnabled(false);
                        {
                            setChildrenDrawingCacheEnabled(false);
                        } //End block
                        {
                            boolean var600D0F7D7BFFDAD0124DB110898B3A19_1554309403 = (!isAlwaysDrawnWithCacheEnabled());
                            {
                                invalidate();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    // ---------- Original Method ----------
                    //if (mCachingStarted) {
                        //mCachingStarted = mCachingActive = false;
                        //setChildrenDrawnWithCacheEnabled(false);
                        //if ((mPersistentDrawingCache & PERSISTENT_SCROLLING_CACHE) == 0) {
                            //setChildrenDrawingCacheEnabled(false);
                        //}
                        //if (!isAlwaysDrawnWithCacheEnabled()) {
                            //invalidate();
                        //}
                    //}
                }
};
        } //End block
        post(mClearScrollingCache);
        // ---------- Original Method ----------
        //if (mClearScrollingCache == null) {
            //mClearScrollingCache = new Runnable() {
                //public void run() {
                    //if (mCachingStarted) {
                        //mCachingStarted = mCachingActive = false;
                        //setChildrenDrawnWithCacheEnabled(false);
                        //if ((mPersistentDrawingCache & PERSISTENT_SCROLLING_CACHE) == 0) {
                            //setChildrenDrawingCacheEnabled(false);
                        //}
                        //if (!isAlwaysDrawnWithCacheEnabled()) {
                            //invalidate();
                        //}
                    //}
                //}
            //};
        //}
        //post(mClearScrollingCache);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.931 -0400", hash_original_method = "A42371BB3F2D334094B7131C15A0F3E8", hash_generated_method = "4B83B31EA326B0CB8E81DC7E7BE3CE0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean trackMotionScroll(int deltaY, int incrementalDeltaY) {
        dsTaint.addTaint(incrementalDeltaY);
        dsTaint.addTaint(deltaY);
        int childCount;
        childCount = getChildCount();
        int firstTop;
        firstTop = getChildAt(0).getTop();
        int lastBottom;
        lastBottom = getChildAt(childCount - 1).getBottom();
        Rect listPadding;
        listPadding = mListPadding;
        int effectivePaddingTop;
        effectivePaddingTop = 0;
        int effectivePaddingBottom;
        effectivePaddingBottom = 0;
        {
            effectivePaddingTop = listPadding.top;
            effectivePaddingBottom = listPadding.bottom;
        } //End block
        int spaceAbove;
        spaceAbove = effectivePaddingTop - firstTop;
        int end;
        end = getHeight() - effectivePaddingBottom;
        int spaceBelow;
        spaceBelow = lastBottom - end;
        int height;
        height = getHeight() - mPaddingBottom - mPaddingTop;
        {
            deltaY = Math.max(-(height - 1), deltaY);
        } //End block
        {
            deltaY = Math.min(height - 1, deltaY);
        } //End block
        {
            incrementalDeltaY = Math.max(-(height - 1), incrementalDeltaY);
        } //End block
        {
            incrementalDeltaY = Math.min(height - 1, incrementalDeltaY);
        } //End block
        int firstPosition;
        firstPosition = mFirstPosition;
        {
            mFirstPositionDistanceGuess = firstTop - listPadding.top;
        } //End block
        {
            mLastPositionDistanceGuess = lastBottom + listPadding.bottom;
        } //End block
        boolean cannotScrollDown;
        cannotScrollDown = (firstPosition == 0 &&
                firstTop >= listPadding.top && incrementalDeltaY >= 0);
        boolean cannotScrollUp;
        cannotScrollUp = (firstPosition + childCount == mItemCount &&
                lastBottom <= getHeight() - listPadding.bottom && incrementalDeltaY <= 0);
        boolean down;
        down = incrementalDeltaY < 0;
        boolean inTouchMode;
        inTouchMode = isInTouchMode();
        {
            hideSelector();
        } //End block
        int headerViewsCount;
        headerViewsCount = getHeaderViewsCount();
        int footerViewsStart;
        footerViewsStart = mItemCount - getFooterViewsCount();
        int start;
        start = 0;
        int count;
        count = 0;
        {
            int top;
            top = -incrementalDeltaY;
            {
                top += listPadding.top;
            } //End block
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    {
                        boolean varEA5CC9EA6E04B02875DA6B296CDA3DF6_778730549 = (child.getBottom() >= top);
                        {
                            int position;
                            position = firstPosition + i;
                            {
                                mRecycler.addScrapView(child, position);
                                {
                                    ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int bottom;
            bottom = getHeight() - incrementalDeltaY;
            {
                bottom -= listPadding.bottom;
            } //End block
            {
                int i;
                i = childCount - 1;
                {
                    View child;
                    child = getChildAt(i);
                    {
                        boolean var0C9792EB8E72B1E8C3A203B5FF9D7EBC_454395402 = (child.getTop() <= bottom);
                        {
                            start = i;
                            int position;
                            position = firstPosition + i;
                            {
                                mRecycler.addScrapView(child, position);
                                {
                                    ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mMotionViewNewTop = mMotionViewOriginalTop + deltaY;
        mBlockLayoutRequests = true;
        {
            detachViewsFromParent(start, count);
        } //End block
        offsetChildrenTopAndBottom(incrementalDeltaY);
        {
            mFirstPosition += count;
        } //End block
        invalidate();
        int absIncrementalDeltaY;
        absIncrementalDeltaY = Math.abs(incrementalDeltaY);
        {
            fillGap(down);
        } //End block
        {
            int childIndex;
            childIndex = mSelectedPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_1882337601 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(mSelectedPosition, getChildAt(childIndex));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int childIndex;
            childIndex = mSelectorPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_1348320364 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(INVALID_POSITION, getChildAt(childIndex));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mSelectorRect.setEmpty();
        } //End block
        mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        awakenScrollBars();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.932 -0400", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "A9D70361A971D401BBFD15CADDF35D10")
    @DSModeled(DSC.SAFE)
     int getHeaderViewsCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.932 -0400", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "1BAA798BC0D231F35F4D874FC4B9F800")
    @DSModeled(DSC.SAFE)
     int getFooterViewsCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    abstract void fillGap(boolean down);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.932 -0400", hash_original_method = "01CAE4EB89DA7F2FB8FB8C551B8C7558", hash_generated_method = "3397357B75DA44B7D8439BB69C481809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hideSelector() {
        {
            {
                mResurrectToPosition = mSelectedPosition;
            } //End block
            {
                mResurrectToPosition = mNextSelectedPosition;
            } //End block
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectedTop = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mSelectedPosition != INVALID_POSITION) {
            //if (mLayoutMode != LAYOUT_SPECIFIC) {
                //mResurrectToPosition = mSelectedPosition;
            //}
            //if (mNextSelectedPosition >= 0 && mNextSelectedPosition != mSelectedPosition) {
                //mResurrectToPosition = mNextSelectedPosition;
            //}
            //setSelectedPositionInt(INVALID_POSITION);
            //setNextSelectedPositionInt(INVALID_POSITION);
            //mSelectedTop = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.933 -0400", hash_original_method = "3C42E05D1FE66CE321CE689DCD7609AF", hash_generated_method = "C2ECF08DF2CE548202DF90EA03E4DDD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int reconcileSelectedPosition() {
        int position;
        position = mSelectedPosition;
        {
            position = mResurrectToPosition;
        } //End block
        position = Math.max(0, position);
        position = Math.min(position, mItemCount - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int position = mSelectedPosition;
        //if (position < 0) {
            //position = mResurrectToPosition;
        //}
        //position = Math.max(0, position);
        //position = Math.min(position, mItemCount - 1);
        //return position;
    }

    
    abstract int findMotionRow(int y);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.933 -0400", hash_original_method = "620BFFA3FACC4E59D7B8719ED5062EB2", hash_generated_method = "862174857FB7705D09C54C364C9BE7D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int findClosestMotionRow(int y) {
        dsTaint.addTaint(y);
        int childCount;
        childCount = getChildCount();
        int motionRow;
        motionRow = findMotionRow(y);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount == 0) {
            //return INVALID_POSITION;
        //}
        //final int motionRow = findMotionRow(y);
        //return motionRow != INVALID_POSITION ? motionRow : mFirstPosition + childCount - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.933 -0400", hash_original_method = "48746A94CCDD3AA210B8334DFA5415FB", hash_generated_method = "60F28DC437B80BF897562B54CF102004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateViews() {
        mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mDataChanged = true;
        //rememberSyncState();
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.933 -0400", hash_original_method = "DCA216018FB5348F17E51D7322AEEFD4", hash_generated_method = "F4E688242FB593C5CE46F22563BB2661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean resurrectSelectionIfNeeded() {
        {
            boolean varA94BDD63AC24FE4C16F032614F7038B6_1176429303 = (mSelectedPosition < 0 && resurrectSelection());
            {
                updateSelectorState();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSelectedPosition < 0 && resurrectSelection()) {
            //updateSelectorState();
            //return true;
        //}
        //return false;
    }

    
    abstract void setSelectionInt(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.934 -0400", hash_original_method = "46DC118C185645539DC69AE3B021DB61", hash_generated_method = "9C56EBF05BC2ABB853C55E68BB857140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean resurrectSelection() {
        int childCount;
        childCount = getChildCount();
        int selectedTop;
        selectedTop = 0;
        int selectedPos;
        int childrenTop;
        childrenTop = mListPadding.top;
        int childrenBottom;
        childrenBottom = mBottom - mTop - mListPadding.bottom;
        int firstPosition;
        firstPosition = mFirstPosition;
        int toPosition;
        toPosition = mResurrectToPosition;
        boolean down;
        down = true;
        {
            selectedPos = toPosition;
            View selected;
            selected = getChildAt(selectedPos - mFirstPosition);
            selectedTop = selected.getTop();
            int selectedBottom;
            selectedBottom = selected.getBottom();
            {
                selectedTop = childrenTop + getVerticalFadingEdgeLength();
            } //End block
            {
                selectedTop = childrenBottom - selected.getMeasuredHeight()
                        - getVerticalFadingEdgeLength();
            } //End block
        } //End block
        {
            {
                selectedPos = firstPosition;
                {
                    int i;
                    i = 0;
                    {
                        View v;
                        v = getChildAt(i);
                        int top;
                        top = v.getTop();
                        {
                            selectedTop = top;
                            {
                                childrenTop += getVerticalFadingEdgeLength();
                            } //End block
                        } //End block
                        {
                            selectedPos = firstPosition + i;
                            selectedTop = top;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int itemCount;
                itemCount = mItemCount;
                down = false;
                selectedPos = firstPosition + childCount - 1;
                {
                    int i;
                    i = childCount - 1;
                    {
                        View v;
                        v = getChildAt(i);
                        int top;
                        top = v.getTop();
                        int bottom;
                        bottom = v.getBottom();
                        {
                            selectedTop = top;
                            {
                                childrenBottom -= getVerticalFadingEdgeLength();
                            } //End block
                        } //End block
                        {
                            selectedPos = firstPosition + i;
                            selectedTop = top;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mResurrectToPosition = INVALID_POSITION;
        removeCallbacks(mFlingRunnable);
        {
            mPositionScroller.stop();
        } //End block
        mTouchMode = TOUCH_MODE_REST;
        clearScrollingCache();
        mSpecificTop = selectedTop;
        selectedPos = lookForSelectablePosition(selectedPos, down);
        {
            boolean var62F8C3AE45B38B2DECAE10F01A4F320D_94492737 = (selectedPos >= firstPosition && selectedPos <= getLastVisiblePosition());
            {
                mLayoutMode = LAYOUT_SPECIFIC;
                updateSelectorState();
                setSelectionInt(selectedPos);
                invokeOnItemScrollListener();
            } //End block
            {
                selectedPos = INVALID_POSITION;
            } //End block
        } //End collapsed parenthetic
        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.937 -0400", hash_original_method = "7A1DBAB399A1231E28D6D54E2346B36F", hash_generated_method = "F0D7A01C30F449E76A56C51EB9B727A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void confirmCheckedPositionsById() {
        mCheckStates.clear();
        boolean checkedCountChanged;
        checkedCountChanged = false;
        {
            int checkedIndex;
            checkedIndex = 0;
            boolean var345B3951F4A2E6483B2D033F362E91E2_494599612 = (checkedIndex < mCheckedIdStates.size());
            {
                long id;
                id = mCheckedIdStates.keyAt(checkedIndex);
                int lastPos;
                lastPos = mCheckedIdStates.valueAt(checkedIndex);
                long lastPosId;
                lastPosId = mAdapter.getItemId(lastPos);
                {
                    int start;
                    start = Math.max(0, lastPos - CHECK_POSITION_SEARCH_DISTANCE);
                    int end;
                    end = Math.min(lastPos + CHECK_POSITION_SEARCH_DISTANCE, mItemCount);
                    boolean found;
                    found = false;
                    {
                        int searchPos;
                        searchPos = start;
                        {
                            long searchId;
                            searchId = mAdapter.getItemId(searchPos);
                            {
                                found = true;
                                mCheckStates.put(searchPos, true);
                                mCheckedIdStates.setValueAt(checkedIndex, searchPos);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        mCheckedIdStates.delete(id);
                        checkedCountChanged = true;
                        {
                            mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                                lastPos, id, false);
                        } //End block
                    } //End block
                } //End block
                {
                    mCheckStates.put(lastPos, true);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mChoiceActionMode.invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.938 -0400", hash_original_method = "988EE7458DA5CAE45D4D8EEE7B510700", hash_generated_method = "6B88916D1FC0C5E59A30AB57AEFEB06E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void handleDataChanged() {
        int count;
        count = mItemCount;
        int lastHandledItemCount;
        lastHandledItemCount = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
        {
            boolean var1BF5A9488574E2FA74D8264040FC0893_544405708 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter != null && mAdapter.hasStableIds());
            {
                confirmCheckedPositionsById();
            } //End block
        } //End collapsed parenthetic
        {
            int newPos;
            int selectablePos;
            {
                mNeedSync = false;
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                } //End block
                {
                    {
                        mForceTranscriptScroll = false;
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } //End block
                    int childCount;
                    childCount = getChildCount();
                    int listBottom;
                    listBottom = getHeight() - getPaddingBottom();
                    View lastChild;
                    lastChild = getChildAt(childCount - 1);
                    int lastBottom;
                    lastBottom = lastChild.getBottom();
                    lastBottom = listBottom;
                    {
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } //End block
                    awakenScrollBars();
                } //End block
                //Begin case SYNC_SELECTED_POSITION 
                {
                    boolean varAFC77293C02F773029137FDE42129C14_397850399 = (isInTouchMode());
                    {
                        mLayoutMode = LAYOUT_SYNC;
                        mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                    } //End block
                    {
                        newPos = findSyncPosition();
                        {
                            selectablePos = lookForSelectablePosition(newPos, true);
                            {
                                mSyncPosition = newPos;
                                {
                                    boolean varE6F64662C76820CEAED04C173D145196_65204352 = (mSyncHeight == getHeight());
                                    {
                                        mLayoutMode = LAYOUT_SYNC;
                                    } //End block
                                    {
                                        mLayoutMode = LAYOUT_SET_SELECTION;
                                    } //End block
                                } //End collapsed parenthetic
                                setNextSelectedPositionInt(newPos);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                //End case SYNC_SELECTED_POSITION 
                //Begin case SYNC_FIRST_POSITION 
                mLayoutMode = LAYOUT_SYNC;
                //End case SYNC_FIRST_POSITION 
                //Begin case SYNC_FIRST_POSITION 
                mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                //End case SYNC_FIRST_POSITION 
            } //End block
            {
                boolean var12100596BD466B0E4730696B6E3F9C25_654041208 = (!isInTouchMode());
                {
                    newPos = getSelectedItemPosition();
                    {
                        newPos = count - 1;
                    } //End block
                    {
                        newPos = 0;
                    } //End block
                    selectablePos = lookForSelectablePosition(newPos, true);
                    {
                        setNextSelectedPositionInt(selectablePos);
                    } //End block
                    {
                        selectablePos = lookForSelectablePosition(newPos, false);
                        {
                            setNextSelectedPositionInt(selectablePos);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        mLayoutMode = mStackFromBottom ? LAYOUT_FORCE_BOTTOM : LAYOUT_FORCE_TOP;
        mSelectedPosition = INVALID_POSITION;
        mSelectedRowId = INVALID_ROW_ID;
        mNextSelectedPosition = INVALID_POSITION;
        mNextSelectedRowId = INVALID_ROW_ID;
        mNeedSync = false;
        mSelectorPosition = INVALID_POSITION;
        checkSelectionChanged();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.938 -0400", hash_original_method = "C562B15A4430BC762CC4B771E60D70AF", hash_generated_method = "1719B08C6461C04E3113D6E2094497F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hint);
        super.onDisplayHint(hint);
        //Begin case INVISIBLE 
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_1700578271 = (mPopup != null && mPopup.isShowing());
            {
                dismissPopup();
            } //End block
        } //End collapsed parenthetic
        //End case INVISIBLE 
        //Begin case VISIBLE 
        {
            boolean var003C494DA1AA746A5D5A0908F950DF91_782392594 = (mFiltered && mPopup != null && !mPopup.isShowing());
            {
                showPopup();
            } //End block
        } //End collapsed parenthetic
        //End case VISIBLE 
        mPopupHidden = hint == INVISIBLE;
        // ---------- Original Method ----------
        //super.onDisplayHint(hint);
        //switch (hint) {
            //case INVISIBLE:
                //if (mPopup != null && mPopup.isShowing()) {
                    //dismissPopup();
                //}
                //break;
            //case VISIBLE:
                //if (mFiltered && mPopup != null && !mPopup.isShowing()) {
                    //showPopup();
                //}
                //break;
        //}
        //mPopupHidden = hint == INVISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.938 -0400", hash_original_method = "86B533D40AC94020BA9211F436996CAA", hash_generated_method = "6F219CE9A5114FCF258245673A1C0226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissPopup() {
        {
            mPopup.dismiss();
        } //End block
        // ---------- Original Method ----------
        //if (mPopup != null) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.939 -0400", hash_original_method = "6C07C7201C3F8F7AE411CAF5368DC26F", hash_generated_method = "8C0B4FB35090998FF7E1763B58DCCDA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showPopup() {
        {
            boolean varEC31A88682EDD8797910B3EFA4C60835_1695646933 = (getWindowVisibility() == View.VISIBLE);
            {
                createTextFilter(true);
                positionPopup();
                checkFocus();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getWindowVisibility() == View.VISIBLE) {
            //createTextFilter(true);
            //positionPopup();
            //checkFocus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.939 -0400", hash_original_method = "84FE8B62D6AD62C84F51A39D7331FBA6", hash_generated_method = "EF540A1CE3CF51284C61A7D81D9E3818")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void positionPopup() {
        int screenHeight;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        int[] xy;
        xy = new int[2];
        getLocationOnScreen(xy);
        int bottomGap;
        bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
        {
            boolean varE8127168ED545283F844FC09586AD49B_77672508 = (!mPopup.isShowing());
            {
                mPopup.showAtLocation(this, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    xy[0], bottomGap);
            } //End block
            {
                mPopup.update(xy[0], bottomGap, -1, -1);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int screenHeight = getResources().getDisplayMetrics().heightPixels;
        //final int[] xy = new int[2];
        //getLocationOnScreen(xy);
        //final int bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
        //if (!mPopup.isShowing()) {
            //mPopup.showAtLocation(this, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    //xy[0], bottomGap);
        //} else {
            //mPopup.update(xy[0], bottomGap, -1, -1);
        //}
    }

    
        static int getDistance(Rect source, Rect dest, int direction) {
        int sX, sY;
        int dX, dY;
        switch (direction) {
        case View.FOCUS_RIGHT:
            sX = source.right;
            sY = source.top + source.height() / 2;
            dX = dest.left;
            dY = dest.top + dest.height() / 2;
            break;
        case View.FOCUS_DOWN:
            sX = source.left + source.width() / 2;
            sY = source.bottom;
            dX = dest.left + dest.width() / 2;
            dY = dest.top;
            break;
        case View.FOCUS_LEFT:
            sX = source.left;
            sY = source.top + source.height() / 2;
            dX = dest.right;
            dY = dest.top + dest.height() / 2;
            break;
        case View.FOCUS_UP:
            sX = source.left + source.width() / 2;
            sY = source.top;
            dX = dest.left + dest.width() / 2;
            dY = dest.bottom;
            break;
        case View.FOCUS_FORWARD:
        case View.FOCUS_BACKWARD:
            sX = source.right + source.width() / 2;
            sY = source.top + source.height() / 2;
            dX = dest.left + dest.width() / 2;
            dY = dest.top + dest.height() / 2;
            break;
        default:
            throw new IllegalArgumentException("direction must be one of "
                    + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                    + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        int deltaX = dX - sX;
        int deltaY = dY - sY;
        return deltaY * deltaY + deltaX * deltaX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.939 -0400", hash_original_method = "E53786E832898AFD8F3D1858C7ADFC0B", hash_generated_method = "772B5A618F3F152D924D525884E8C27A")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isInFilterMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.940 -0400", hash_original_method = "E9CFCD950A6A0EAC13FE4A21D8302AE8", hash_generated_method = "06CD4662471BE5416B937B3F5CB095CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean sendToTextFilter(int keyCode, int count, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var8E508D5098333C3DF9E9AC1534499251_1432243350 = (!acceptFilter());
        } //End collapsed parenthetic
        boolean handled;
        handled = false;
        boolean okToSend;
        okToSend = true;
        //Begin case KeyEvent.KEYCODE_DPAD_UP KeyEvent.KEYCODE_DPAD_DOWN KeyEvent.KEYCODE_DPAD_LEFT KeyEvent.KEYCODE_DPAD_RIGHT KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        okToSend = false;
        //End case KeyEvent.KEYCODE_DPAD_UP KeyEvent.KEYCODE_DPAD_DOWN KeyEvent.KEYCODE_DPAD_LEFT KeyEvent.KEYCODE_DPAD_RIGHT KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_BACK 
        {
            boolean var39DB415F3D8E94BAF1BCAFDEBBF4C6EF_205619529 = (mFiltered && mPopup != null && mPopup.isShowing());
            {
                {
                    boolean varF129D97EB58BBADBA4875AF25E33B341_90596353 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                        handled = true;
                    } //End block
                    {
                        boolean varF38DB653E52CB4D0E4EDFCBA5E49A3DF_1450201980 = (event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled());
                        {
                            handled = true;
                            mTextFilter.setText("");
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_BACK 
        //Begin case KeyEvent.KEYCODE_BACK 
        okToSend = false;
        //End case KeyEvent.KEYCODE_BACK 
        //Begin case KeyEvent.KEYCODE_SPACE 
        okToSend = mFiltered;
        //End case KeyEvent.KEYCODE_SPACE 
        {
            createTextFilter(true);
            KeyEvent forwardEvent;
            forwardEvent = event;
            {
                boolean var6A7BE4CA28243E587EACA0203B08BD67_1656252795 = (forwardEvent.getRepeatCount() > 0);
                {
                    forwardEvent = KeyEvent.changeTimeRepeat(event, event.getEventTime(), 0);
                } //End block
            } //End collapsed parenthetic
            int action;
            action = event.getAction();
            //Begin case KeyEvent.ACTION_DOWN 
            handled = mTextFilter.onKeyDown(keyCode, forwardEvent);
            //End case KeyEvent.ACTION_DOWN 
            //Begin case KeyEvent.ACTION_UP 
            handled = mTextFilter.onKeyUp(keyCode, forwardEvent);
            //End case KeyEvent.ACTION_UP 
            //Begin case KeyEvent.ACTION_MULTIPLE 
            handled = mTextFilter.onKeyMultiple(keyCode, count, event);
            //End case KeyEvent.ACTION_MULTIPLE 
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.942 -0400", hash_original_method = "D11D50B93967E008BF298EC93C5B84EB", hash_generated_method = "087EBC0368F7F9DF867289B602B72DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        {
            boolean var402F49E4B8F4D68C8A96D34BD4EE8DD9_1451292 = (isTextFilterEnabled());
            {
                createTextFilter(false);
                {
                    mDefInputConnection = new BaseInputConnection(this, false);
                    mPublicInputConnection = new InputConnectionWrapper(
                        mTextFilter.onCreateInputConnection(outAttrs), true) {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.941 -0400", hash_original_method = "BF513EB07D63CFAF3DB0C9E86F478409", hash_generated_method = "C09C132D59CC3076A2DA0E0100233E8B")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public boolean reportFullscreenMode(boolean enabled) {
                            dsTaint.addTaint(enabled);
                            boolean var75DA12718785A0AA273693F989B797D6_1043569676 = (mDefInputConnection.reportFullscreenMode(enabled));
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //return mDefInputConnection.reportFullscreenMode(enabled);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.941 -0400", hash_original_method = "D9C91C9E69679EA1CEEF772A4C39F6DE", hash_generated_method = "670A2987395BA0C6D59CFFFA7F70412D")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public boolean performEditorAction(int editorAction) {
                            dsTaint.addTaint(editorAction);
                            {
                                InputMethodManager imm;
                                imm = (InputMethodManager)
                                    getContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
                                {
                                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                } //End block
                            } //End block
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //if (editorAction == EditorInfo.IME_ACTION_DONE) {
                            //InputMethodManager imm = (InputMethodManager)
                                    //getContext().getSystemService(
                                            //Context.INPUT_METHOD_SERVICE);
                            //if (imm != null) {
                                //imm.hideSoftInputFromWindow(getWindowToken(), 0);
                            //}
                            //return true;
                        //}
                            //return false;
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.942 -0400", hash_original_method = "4DB1D1C6C2201E74EC410884B47F862A", hash_generated_method = "6467C780E1E6B766B19FD671D08AD944")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public boolean sendKeyEvent(KeyEvent event) {
                            dsTaint.addTaint(event.dsTaint);
                            boolean varDB2D5BE018F84A831888EA06678F8604_1580586636 = (mDefInputConnection.sendKeyEvent(event));
                            return dsTaint.getTaintBoolean();
                            // ---------- Original Method ----------
                            //return mDefInputConnection.sendKeyEvent(event);
                        }
};
                } //End block
                outAttrs.inputType = EditorInfo.TYPE_CLASS_TEXT
                    | EditorInfo.TYPE_TEXT_VARIATION_FILTER;
                outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE;
            } //End block
        } //End collapsed parenthetic
        return (InputConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.942 -0400", hash_original_method = "44BA525DE8B7DBBB72825E23CC2BB1F6", hash_generated_method = "9C1EE6328DD2D3D7C5DB7134504F6B16")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean checkInputConnectionProxy(View view) {
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return view == mTextFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.942 -0400", hash_original_method = "F3682B44558BD825C5F832A45B68670A", hash_generated_method = "F77B9E5BA144BE18AA6A2810AC1D999D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createTextFilter(boolean animateEntrance) {
        dsTaint.addTaint(animateEntrance);
        {
            Context c;
            c = getContext();
            PopupWindow p;
            p = new PopupWindow(c);
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater)
                    c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mTextFilter = (EditText) layoutInflater.inflate(
                    com.android.internal.R.layout.typing_filter, null);
            mTextFilter.setRawInputType(EditorInfo.TYPE_CLASS_TEXT
                    | EditorInfo.TYPE_TEXT_VARIATION_FILTER);
            mTextFilter.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
            mTextFilter.addTextChangedListener(this);
            p.setFocusable(false);
            p.setTouchable(false);
            p.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            p.setContentView(mTextFilter);
            p.setWidth(LayoutParams.WRAP_CONTENT);
            p.setHeight(LayoutParams.WRAP_CONTENT);
            p.setBackgroundDrawable(null);
            mPopup = p;
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = true;
        } //End block
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilter);
        } //End block
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilterRestore);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.943 -0400", hash_original_method = "32E21A2D6552DD3A6789EF27520CDF5A", hash_generated_method = "6BFB84846B38FC3E32D2A8F44DE1A8FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearTextFilter() {
        {
            mTextFilter.setText("");
            mFiltered = false;
            {
                boolean var8B43E06806BC96AC7F4A8D7A0BE622AC_413099384 = (mPopup != null && mPopup.isShowing());
                {
                    dismissPopup();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mFiltered) {
            //mTextFilter.setText("");
            //mFiltered = false;
            //if (mPopup != null && mPopup.isShowing()) {
                //dismissPopup();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.943 -0400", hash_original_method = "65ACBB1BC8C4B28B951746B0589E48B4", hash_generated_method = "D1A2D8C48678090BB0440CA78BE82627")
    @DSModeled(DSC.SAFE)
    public boolean hasTextFilter() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.944 -0400", hash_original_method = "11A5FC28E28C3DFE2639108D4141B162", hash_generated_method = "72D301D31FCDC9BF831059086B1C371D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_1335925153 = (isShown());
            {
                {
                    boolean varDA5B3CFD94DC14795F693BACD8E64777_147537754 = (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden);
                    {
                        showPopup();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varF98F363210E79C98D906F19BE26A0AAC_548730771 = (mPopup != null && mPopup.isShowing());
                    {
                        dismissPopup();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShown()) {
            //if (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden) {
                //showPopup();
            //}
        //} else {
            //if (mPopup != null && mPopup.isShowing()) {
                //dismissPopup();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.944 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "6037A3A1E287DC3D909FC0A30E71C281")
    @DSModeled(DSC.SAFE)
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.944 -0400", hash_original_method = "971B961D673D514356DF6D21C3AC22CE", hash_generated_method = "3277BB8A315D13AA870727D839CF0361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        {
            boolean varCB324F139DAF9E78619086072BD20A85_1217533222 = (mPopup != null && isTextFilterEnabled());
            {
                int length;
                length = s.length();
                boolean showing;
                showing = mPopup.isShowing();
                {
                    showPopup();
                    mFiltered = true;
                } //End block
                {
                    dismissPopup();
                    mFiltered = false;
                } //End block
                {
                    Filter f;
                    f = ((Filterable) mAdapter).getFilter();
                    {
                        f.filter(s, this);
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You cannot call onTextChanged with a non "
                            + "filterable adapter");
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.945 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "E1E9B48623236A758AA5D88D665C2448")
    @DSModeled(DSC.SAFE)
    public void afterTextChanged(Editable s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.945 -0400", hash_original_method = "5FB3F90813AE5A23A23BDBAA76A97056", hash_generated_method = "FE7CF4A586BA255B4ADB9CD37444F13B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFilterComplete(int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        {
            mResurrectToPosition = INVALID_POSITION;
            resurrectSelection();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectedPosition < 0 && count > 0) {
            //mResurrectToPosition = INVALID_POSITION;
            //resurrectSelection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.946 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "B7FAC9880DBF575BC4F7AB08467EC93D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        ViewGroup.LayoutParams varAE4B968C4C0301DC2CC83C8A9F56D84B_549787052 = (new LayoutParams(p));
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.946 -0400", hash_original_method = "D7DCCEE0C1D1153E18E019649E6F2D80", hash_generated_method = "1EC3361761A650DA43846044616B5394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams varE6715DFC3A5359CE2D0ED893D38A28C7_35815897 = (new AbsListView.LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AbsListView.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.946 -0400", hash_original_method = "7C8047E4E7C938CA1D7BE889EE17D059", hash_generated_method = "C83134860102766AE512149EB6B93017")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof AbsListView.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.946 -0400", hash_original_method = "1385B81082A7F6F42283DE7C72A352C9", hash_generated_method = "97791DB0E0DBDFC2FAF7C6D771158C80")
    @DSModeled(DSC.SAFE)
    public void setTranscriptMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mTranscriptMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.946 -0400", hash_original_method = "EADF20E51473F5B82FC89B630E89BCE7", hash_generated_method = "07F9E18EEF29EE6BCA400163E12A9856")
    @DSModeled(DSC.SAFE)
    public int getTranscriptMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTranscriptMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.947 -0400", hash_original_method = "3A641BF6273957C36676C590B4CC3444", hash_generated_method = "63494F2FFA6F583CDA334B782082337E")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSolidColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.947 -0400", hash_original_method = "B2E4EFE21735BA4D4CA20D9D2323DF5E", hash_generated_method = "CB458DEE938E80D76D33160CF45C6A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCacheColorHint(int color) {
        dsTaint.addTaint(color);
        {
            int count;
            count = getChildCount();
            {
                int i;
                i = 0;
                {
                    getChildAt(i).setDrawingCacheBackgroundColor(color);
                } //End block
            } //End collapsed parenthetic
            mRecycler.setCacheColorHint(color);
        } //End block
        // ---------- Original Method ----------
        //if (color != mCacheColorHint) {
            //mCacheColorHint = color;
            //int count = getChildCount();
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).setDrawingCacheBackgroundColor(color);
            //}
            //mRecycler.setCacheColorHint(color);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.947 -0400", hash_original_method = "75945C93CA5A574EC2A11912410CB0E0", hash_generated_method = "A2504607B128C5A98488CF92B671311F")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.948 -0400", hash_original_method = "012761D54D3EA9FE8C837ED35E18F05A", hash_generated_method = "AFE53D6D387462B5B8E54A0C5E0D5C23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reclaimViews(List<View> views) {
        dsTaint.addTaint(views.dsTaint);
        int childCount;
        childCount = getChildCount();
        RecyclerListener listener;
        listener = mRecycler.mRecyclerListener;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                AbsListView.LayoutParams lp;
                lp = (AbsListView.LayoutParams) child.getLayoutParams();
                {
                    boolean var248D80F0B10623F58D6026D84DE5E671_1962418442 = (lp != null && mRecycler.shouldRecycleViewType(lp.viewType));
                    {
                        views.add(child);
                        {
                            listener.onMovedToScrapHeap(child);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mRecycler.reclaimScrapViews(views);
        removeAllViewsInLayout();
        // ---------- Original Method ----------
        //int childCount = getChildCount();
        //RecyclerListener listener = mRecycler.mRecyclerListener;
        //for (int i = 0; i < childCount; i++) {
            //View child = getChildAt(i);
            //AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
            //if (lp != null && mRecycler.shouldRecycleViewType(lp.viewType)) {
                //views.add(child);
                //if (listener != null) {
                    //listener.onMovedToScrapHeap(child);
                //}
            //}
        //}
        //mRecycler.reclaimScrapViews(views);
        //removeAllViewsInLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.948 -0400", hash_original_method = "63F1E187EEAD4E39E30E7C6F8BC8B8CA", hash_generated_method = "B4389B5AB25B85445A3D1BBF12AE145B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consistency);
        boolean result;
        result = super.onConsistencyCheck(consistency);
        boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        {
            View[] activeViews;
            activeViews = mRecycler.mActiveViews;
            int count;
            count = activeViews.length;
            {
                int i;
                i = 0;
                {
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "AbsListView " + this + " has a view in its active recycler: " +
                                    activeViews[i]);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            ArrayList<View> scrap;
            scrap = mRecycler.mCurrentScrap;
            {
                boolean var1B9DDC99DC36041733636881A6D6F2A7_1299459651 = (!checkScrap(scrap));
                result = false;
            } //End collapsed parenthetic
            ArrayList<View>[] scraps;
            scraps = mRecycler.mScrapViews;
            count = scraps.length;
            {
                int i;
                i = 0;
                {
                    {
                        boolean var152726F7FF3AB1D0325523449C0C26DB_1392682921 = (!checkScrap(scraps[i]));
                        result = false;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.949 -0400", hash_original_method = "256B8EB3FFECB4266216E5C3F84B8A1E", hash_generated_method = "2D919841C52855AC9A66BEFBC607B824")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkScrap(ArrayList<View> scrap) {
        dsTaint.addTaint(scrap.dsTaint);
        boolean result;
        result = true;
        int count;
        count = scrap.size();
        {
            int i;
            i = 0;
            {
                View view;
                view = scrap.get(i);
                {
                    boolean varC649C41AA848C000C1488527EB85E854_1031162101 = (view.getParent() != null);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var6F0CAFE49F301E66083476B8CB251F7E_1299000067 = (indexOfChild(view) >= 0);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap that is also a direct child: " + view);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (scrap == null) return true;
        //boolean result = true;
        //final int count = scrap.size();
        //for (int i = 0; i < count; i++) {
            //final View view = scrap.get(i);
            //if (view.getParent() != null) {
                //result = false;
                //Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        //" has a view in its scrap heap still attached to a parent: " + view);
            //}
            //if (indexOfChild(view) >= 0) {
                //result = false;
                //Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        //" has a view in its scrap heap that is also a direct child: " + view);
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.949 -0400", hash_original_method = "D0C284A2FBB36CA42A8E7F826DDB725F", hash_generated_method = "4702EDEA243C09BBFD77258C1ACBC569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishGlows() {
        {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mEdgeGlowTop != null) {
            //mEdgeGlowTop.finish();
            //mEdgeGlowBottom.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.949 -0400", hash_original_method = "C1CCFF5C419F753BE2BE6DDA2ACFD3CA", hash_generated_method = "86550A51BB26D4136834849B127682FB")
    @DSModeled(DSC.SPEC)
    public void setRemoteViewsAdapter(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            Intent.FilterComparison fcNew;
            fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld;
            fcOld = new Intent.FilterComparison(
                    mRemoteAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_685247233 = (fcNew.equals(fcOld));
            } //End collapsed parenthetic
        } //End block
        mDeferNotifyDataSetChanged = false;
        mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        // ---------- Original Method ----------
        //if (mRemoteAdapter != null) {
            //Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            //Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    //mRemoteAdapter.getRemoteViewsServiceIntent());
            //if (fcNew.equals(fcOld)) {
                //return;
            //}
        //}
        //mDeferNotifyDataSetChanged = false;
        //mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.949 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    @DSModeled(DSC.SAFE)
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.950 -0400", hash_original_method = "28DEF371BA940ACF691CB065E03F3A69", hash_generated_method = "E52D42E1AFDE98C003D89480D711778A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onRemoteAdapterConnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            setAdapter(mRemoteAdapter);
            {
                mRemoteAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } //End block
        } //End block
        {
            mRemoteAdapter.superNotifyDataSetChanged();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mRemoteAdapter != mAdapter) {
            //setAdapter(mRemoteAdapter);
            //if (mDeferNotifyDataSetChanged) {
                //mRemoteAdapter.notifyDataSetChanged();
                //mDeferNotifyDataSetChanged = false;
            //}
            //return false;
        //} else if (mRemoteAdapter != null) {
            //mRemoteAdapter.superNotifyDataSetChanged();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.950 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    @DSModeled(DSC.SAFE)
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.950 -0400", hash_original_method = "A10CF4C818C12AB96D88DAC8638A238F", hash_generated_method = "29173BAF9AD54182F350A468BA77876D")
    @DSModeled(DSC.SAFE)
    public void setRecyclerListener(RecyclerListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mRecycler.mRecyclerListener = listener;
        // ---------- Original Method ----------
        //mRecycler.mRecyclerListener = listener;
    }

    
        static View retrieveFromScrap(ArrayList<View> scrapViews, int position) {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.951 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB6E14E26999AC4D7AF1972CF22F65E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.951 -0400", hash_original_method = "9305A5F2B13D160808C7DFC7D0F396F1", hash_generated_method = "E4F86E8AAE7F0E2FA502907EE88EE4F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            selectedId = in.readLong();
            firstId = in.readLong();
            viewTop = in.readInt();
            position = in.readInt();
            height = in.readInt();
            filter = in.readString();
            inActionMode = in.readByte() != 0;
            checkedItemCount = in.readInt();
            checkState = in.readSparseBooleanArray();
            int N;
            N = in.readInt();
            {
                checkIdState = new LongSparseArray<Integer>();
                {
                    int i;
                    i = 0;
                    {
                        long key;
                        key = in.readLong();
                        int value;
                        value = in.readInt();
                        checkIdState.put(key, value);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //selectedId = in.readLong();
            //firstId = in.readLong();
            //viewTop = in.readInt();
            //position = in.readInt();
            //height = in.readInt();
            //filter = in.readString();
            //inActionMode = in.readByte() != 0;
            //checkedItemCount = in.readInt();
            //checkState = in.readSparseBooleanArray();
            //final int N = in.readInt();
            //if (N > 0) {
                //checkIdState = new LongSparseArray<Integer>();
                //for (int i=0; i<N; i++) {
                    //final long key = in.readLong();
                    //final int value = in.readInt();
                    //checkIdState.put(key, value);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.953 -0400", hash_original_method = "3B46B91B7C73B4C6AC70E6F2F8A95E0E", hash_generated_method = "5321A96CC1246D09816A688ED0100543")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
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
            int N;
            N = checkIdState.size();
            N = 0;
            out.writeInt(N);
            {
                int i;
                i = 0;
                {
                    out.writeLong(checkIdState.keyAt(i));
                    out.writeInt(checkIdState.valueAt(i));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeLong(selectedId);
            //out.writeLong(firstId);
            //out.writeInt(viewTop);
            //out.writeInt(position);
            //out.writeInt(height);
            //out.writeString(filter);
            //out.writeByte((byte) (inActionMode ? 1 : 0));
            //out.writeInt(checkedItemCount);
            //out.writeSparseBooleanArray(checkState);
            //final int N = checkIdState != null ? checkIdState.size() : 0;
            //out.writeInt(N);
            //for (int i=0; i<N; i++) {
                //out.writeLong(checkIdState.keyAt(i));
                //out.writeInt(checkIdState.valueAt(i));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.955 -0400", hash_original_method = "28CD4AAEE48E548227BD32788E936C86", hash_generated_method = "E6317B094766D9281991821CD17241FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var48C38BDCB5EBD69675A62C2D31FCBF6E_18559158 = ("AbsListView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " firstId=" + firstId
                    + " viewTop=" + viewTop
                    + " position=" + position
                    + " height=" + height
                    + " filter=" + filter
                    + " checkState=" + checkState + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AbsListView.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " selectedId=" + selectedId
                    //+ " firstId=" + firstId
                    //+ " viewTop=" + viewTop
                    //+ " position=" + position
                    //+ " height=" + height
                    //+ " filter=" + filter
                    //+ " checkState=" + checkState + "}";
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.957 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "80E17E34C23AC50A5722B3B5AC5769BF")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_851277939 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.957 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "2E205BAB5217AFD63B0169E83A5EA28E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_256067745 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    private class WindowRunnnable {
        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.957 -0400", hash_original_method = "728AB98FE9BCCBBFB3573DE5236107D8", hash_generated_method = "728AB98FE9BCCBBFB3573DE5236107D8")
                public WindowRunnnable ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.958 -0400", hash_original_method = "CFEEFBABEEA41C591AAAAD229F2BB0E7", hash_generated_method = "3CF34E449DE44A2D47EB624B8E366E7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
            // ---------- Original Method ----------
            //mOriginalAttachCount = getWindowAttachCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.958 -0400", hash_original_method = "A209657341959E6933B2954972D0CEE9", hash_generated_method = "62E23429F808B1ADBEE21129B0A84147")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean sameWindow() {
            boolean var8C6821449255A008A670CF7CA64A93AB_762053988 = (hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.958 -0400", hash_original_method = "C0C80404DC27C2C3C59E89BEAEB36157", hash_generated_method = "C0C80404DC27C2C3C59E89BEAEB36157")
                public PerformClick ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.958 -0400", hash_original_method = "A958048F64A683459F522CCD37FE7D11", hash_generated_method = "578E1F94A9FE3E750822BC8CEAB2F03E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ListAdapter adapter;
            adapter = mAdapter;
            int motionPosition;
            motionPosition = mClickMotionPosition;
            {
                boolean varB13BDDA7CDF6AF0E3819BBDA363D7ED8_1144490502 = (adapter != null && mItemCount > 0 &&
                    motionPosition != INVALID_POSITION &&
                    motionPosition < adapter.getCount() && sameWindow());
                {
                    View view;
                    view = getChildAt(motionPosition - mFirstPosition);
                    {
                        performItemClick(view, motionPosition, adapter.getItemId(motionPosition));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (mDataChanged) return;
            //final ListAdapter adapter = mAdapter;
            //final int motionPosition = mClickMotionPosition;
            //if (adapter != null && mItemCount > 0 &&
                    //motionPosition != INVALID_POSITION &&
                    //motionPosition < adapter.getCount() && sameWindow()) {
                //final View view = getChildAt(motionPosition - mFirstPosition);
                //if (view != null) {
                    //performItemClick(view, motionPosition, adapter.getItemId(motionPosition));
                //}
            //}
        }

        
    }


    
    private class CheckForLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.958 -0400", hash_original_method = "B3B2819DF408D57079A50D03B673BFB4", hash_generated_method = "B3B2819DF408D57079A50D03B673BFB4")
                public CheckForLongPress ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.959 -0400", hash_original_method = "6FF0C5D4F5CC73F85A2BCE7243EBBA32", hash_generated_method = "14AF04D9E30057EAAE7F1221CE53C639")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            int motionPosition;
            motionPosition = mMotionPosition;
            View child;
            child = getChildAt(motionPosition - mFirstPosition);
            {
                int longPressPosition;
                longPressPosition = mMotionPosition;
                long longPressId;
                longPressId = mAdapter.getItemId(mMotionPosition);
                boolean handled;
                handled = false;
                {
                    boolean var67E4CE6BEABC0BB93EA224EBEDE2210E_1940754108 = (sameWindow() && !mDataChanged);
                    {
                        handled = performLongPress(child, longPressPosition, longPressId);
                    } //End block
                } //End collapsed parenthetic
                {
                    mTouchMode = TOUCH_MODE_REST;
                    setPressed(false);
                    child.setPressed(false);
                } //End block
                {
                    mTouchMode = TOUCH_MODE_DONE_WAITING;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final int motionPosition = mMotionPosition;
            //final View child = getChildAt(motionPosition - mFirstPosition);
            //if (child != null) {
                //final int longPressPosition = mMotionPosition;
                //final long longPressId = mAdapter.getItemId(mMotionPosition);
                //boolean handled = false;
                //if (sameWindow() && !mDataChanged) {
                    //handled = performLongPress(child, longPressPosition, longPressId);
                //}
                //if (handled) {
                    //mTouchMode = TOUCH_MODE_REST;
                    //setPressed(false);
                    //child.setPressed(false);
                //} else {
                    //mTouchMode = TOUCH_MODE_DONE_WAITING;
                //}
            //}
        }

        
    }


    
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.959 -0400", hash_original_method = "869E1D696ECFD7F574739A1B4D51B4B0", hash_generated_method = "869E1D696ECFD7F574739A1B4D51B4B0")
                public CheckForKeyLongPress ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.959 -0400", hash_original_method = "A3D23752A2B3700EB42478E66A11709C", hash_generated_method = "BB82A16342C574708F0DEF69FE0DDD52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean varA166426E2772E5B5C6CC900A627665FC_1472080572 = (isPressed() && mSelectedPosition >= 0);
                {
                    int index;
                    index = mSelectedPosition - mFirstPosition;
                    View v;
                    v = getChildAt(index);
                    {
                        boolean handled;
                        handled = false;
                        {
                            boolean var15017B83B2D3E709399CA037CED2AFF9_182494656 = (sameWindow());
                            {
                                handled = performLongPress(v, mSelectedPosition, mSelectedRowId);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            setPressed(false);
                            v.setPressed(false);
                        } //End block
                    } //End block
                    {
                        setPressed(false);
                        v.setPressed(false);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isPressed() && mSelectedPosition >= 0) {
                //int index = mSelectedPosition - mFirstPosition;
                //View v = getChildAt(index);
                //if (!mDataChanged) {
                    //boolean handled = false;
                    //if (sameWindow()) {
                        //handled = performLongPress(v, mSelectedPosition, mSelectedRowId);
                    //}
                    //if (handled) {
                        //setPressed(false);
                        //v.setPressed(false);
                    //}
                //} else {
                    //setPressed(false);
                    //if (v != null) v.setPressed(false);
                //}
            //}
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.959 -0400", hash_original_method = "DDE2B97FC218E2B375A63A291079A391", hash_generated_method = "DDE2B97FC218E2B375A63A291079A391")
                public CheckForTap ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.960 -0400", hash_original_method = "BD1CF9A4027AFE49AD3D9DDE12B9EB2A", hash_generated_method = "2569C61EAE898C19D232FC0E62D9D4D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                mTouchMode = TOUCH_MODE_TAP;
                View child;
                child = getChildAt(mMotionPosition - mFirstPosition);
                {
                    boolean varEFC9B5F6E2423C87CACF29EB92D1C650_815295602 = (child != null && !child.hasFocusable());
                    {
                        mLayoutMode = LAYOUT_NORMAL;
                        {
                            child.setPressed(true);
                            setPressed(true);
                            layoutChildren();
                            positionSelector(mMotionPosition, child);
                            refreshDrawableState();
                            int longPressTimeout;
                            longPressTimeout = ViewConfiguration.getLongPressTimeout();
                            boolean longClickable;
                            longClickable = isLongClickable();
                            {
                                Drawable d;
                                d = mSelector.getCurrent();
                                {
                                    {
                                        ((TransitionDrawable) d).startTransition(longPressTimeout);
                                    } //End block
                                    {
                                        ((TransitionDrawable) d).resetTransition();
                                    } //End block
                                } //End block
                            } //End block
                            {
                                {
                                    mPendingCheckForLongPress = new CheckForLongPress();
                                } //End block
                                mPendingCheckForLongPress.rememberWindowAttachCount();
                                postDelayed(mPendingCheckForLongPress, longPressTimeout);
                            } //End block
                            {
                                mTouchMode = TOUCH_MODE_DONE_WAITING;
                            } //End block
                        } //End block
                        {
                            mTouchMode = TOUCH_MODE_DONE_WAITING;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class FlingRunnable implements Runnable {
        private OverScroller mScroller;
        private int mLastFlingY;
        private final Runnable mCheckFlywheel = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.960 -0400", hash_original_method = "794342E61B0741E0D2D0BA9CCE24C214", hash_generated_method = "4D1582E00383BD2DE8A590AEEA0BD2BC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                int activeId;
                activeId = mActivePointerId;
                VelocityTracker vt;
                vt = mVelocityTracker;
                OverScroller scroller;
                scroller = mScroller;
                vt.computeCurrentVelocity(1000, mMaximumVelocity);
                float yvel;
                yvel = -vt.getYVelocity(activeId);
                {
                    boolean varD670105D084B3EC9810CA2EF9B5779A0_1698053718 = (Math.abs(yvel) >= mMinimumVelocity
                        && scroller.isScrollingInDirection(0, yvel));
                    {
                        postDelayed(this, FLYWHEEL_TIMEOUT);
                    } //End block
                    {
                        endFling();
                        mTouchMode = TOUCH_MODE_SCROLL;
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.960 -0400", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "85D92534340BCEFCD6A4F33FFFEF2C53")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FlingRunnable() {
            mScroller = new OverScroller(getContext());
            // ---------- Original Method ----------
            //mScroller = new OverScroller(getContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.961 -0400", hash_original_method = "03D4FA54CBC93A7E96ECD2486CBEE621", hash_generated_method = "09043309FDF6D71B35058AA0DADE0A79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void start(int initialVelocity) {
            dsTaint.addTaint(initialVelocity);
            int initialY;
            initialY = Integer.MAX_VALUE;
            initialY = 0;
            mLastFlingY = initialY;
            mScroller.fling(0, initialY, 0, initialVelocity,
                    0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
            {
                {
                    Debug.startMethodTracing("AbsListViewFling");
                    mFlingProfilingStarted = true;
                } //End block
            } //End block
            {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            } //End block
            // ---------- Original Method ----------
            //int initialY = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            //mLastFlingY = initialY;
            //mScroller.fling(0, initialY, 0, initialVelocity,
                    //0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            //mTouchMode = TOUCH_MODE_FLING;
            //post(this);
            //if (PROFILE_FLINGING) {
                //if (!mFlingProfilingStarted) {
                    //Debug.startMethodTracing("AbsListViewFling");
                    //mFlingProfilingStarted = true;
                //}
            //}
            //if (mFlingStrictSpan == null) {
                //mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.961 -0400", hash_original_method = "7C6D2E7D970FED93FF739DAAC6CC80C2", hash_generated_method = "64626A3EA260A44ADBA6552EB67FA039")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startSpringback() {
            {
                boolean var059811778A6969FDC20EDCB87A1E9DD0_2125951143 = (mScroller.springBack(0, mScrollY, 0, 0, 0, 0));
                {
                    mTouchMode = TOUCH_MODE_OVERFLING;
                    invalidate();
                    post(this);
                } //End block
                {
                    mTouchMode = TOUCH_MODE_REST;
                    reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (mScroller.springBack(0, mScrollY, 0, 0, 0, 0)) {
                //mTouchMode = TOUCH_MODE_OVERFLING;
                //invalidate();
                //post(this);
            //} else {
                //mTouchMode = TOUCH_MODE_REST;
                //reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.961 -0400", hash_original_method = "57B70ADF06D2A10A257A1E350228503E", hash_generated_method = "9631A962CC92680729EBC246EC459719")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startOverfling(int initialVelocity) {
            dsTaint.addTaint(initialVelocity);
            mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            mTouchMode = TOUCH_MODE_OVERFLING;
            invalidate();
            post(this);
            // ---------- Original Method ----------
            //mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    //Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            //mTouchMode = TOUCH_MODE_OVERFLING;
            //invalidate();
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.961 -0400", hash_original_method = "F0692CC07A14DB0F1E581AFC2CDF3E90", hash_generated_method = "929ECD8AC68E751544A27A2483BFE460")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void edgeReached(int delta) {
            dsTaint.addTaint(delta);
            mScroller.notifyVerticalEdgeReached(mScrollY, 0, mOverflingDistance);
            int overscrollMode;
            overscrollMode = getOverScrollMode();
            {
                boolean var38522C672435F8008EBC1E11034D946B_1625618496 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                    (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && !contentFits()));
                {
                    mTouchMode = TOUCH_MODE_OVERFLING;
                    int vel;
                    vel = (int) mScroller.getCurrVelocity();
                    {
                        mEdgeGlowTop.onAbsorb(vel);
                    } //End block
                    {
                        mEdgeGlowBottom.onAbsorb(vel);
                    } //End block
                } //End block
                {
                    mTouchMode = TOUCH_MODE_REST;
                    {
                        mPositionScroller.stop();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            invalidate();
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.962 -0400", hash_original_method = "16B3910BA949F2F73CCA1E8DA35CE0FF", hash_generated_method = "39B02B106F56AB729F09E090EFC311BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startScroll(int distance, int duration) {
            dsTaint.addTaint(duration);
            dsTaint.addTaint(distance);
            int initialY;
            initialY = Integer.MAX_VALUE;
            initialY = 0;
            mLastFlingY = initialY;
            mScroller.startScroll(0, initialY, 0, distance, duration);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
            // ---------- Original Method ----------
            //int initialY = distance < 0 ? Integer.MAX_VALUE : 0;
            //mLastFlingY = initialY;
            //mScroller.startScroll(0, initialY, 0, distance, duration);
            //mTouchMode = TOUCH_MODE_FLING;
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.962 -0400", hash_original_method = "EC718B25FAE44F694CA340373A32BE29", hash_generated_method = "2B0EEAA019059AF768DC2BD4BEFE8E7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void endFling() {
            mTouchMode = TOUCH_MODE_REST;
            removeCallbacks(this);
            removeCallbacks(mCheckFlywheel);
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            clearScrollingCache();
            mScroller.abortAnimation();
            {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            } //End block
            // ---------- Original Method ----------
            //mTouchMode = TOUCH_MODE_REST;
            //removeCallbacks(this);
            //removeCallbacks(mCheckFlywheel);
            //reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            //clearScrollingCache();
            //mScroller.abortAnimation();
            //if (mFlingStrictSpan != null) {
                //mFlingStrictSpan.finish();
                //mFlingStrictSpan = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.962 -0400", hash_original_method = "5D655CDBCE73395DC3C27E060B822A32", hash_generated_method = "AF0A59A6E58D426EFA985AB4A1AD55DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void flywheelTouch() {
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
            // ---------- Original Method ----------
            //postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.963 -0400", hash_original_method = "4DD83535EAA65B570F4DB1073D459909", hash_generated_method = "6C3A25CE1FBFFB7339BC229B0145EB77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            //Begin case default 
            endFling();
            //End case default 
            //Begin case TOUCH_MODE_SCROLL 
            {
                boolean var8C879AC9111FA456E4D5E672C40ED1D8_825541901 = (mScroller.isFinished());
            } //End collapsed parenthetic
            //End case TOUCH_MODE_SCROLL 
            //Begin case TOUCH_MODE_FLING 
            {
                {
                    layoutChildren();
                } //End block
                {
                    boolean varF1747C254517DB9417BE3B51D681F089_617888449 = (mItemCount == 0 || getChildCount() == 0);
                    {
                        endFling();
                    } //End block
                } //End collapsed parenthetic
                OverScroller scroller;
                scroller = mScroller;
                boolean more;
                more = scroller.computeScrollOffset();
                int y;
                y = scroller.getCurrY();
                int delta;
                delta = mLastFlingY - y;
                {
                    mMotionPosition = mFirstPosition;
                    View firstView;
                    firstView = getChildAt(0);
                    mMotionViewOriginalTop = firstView.getTop();
                    delta = Math.min(getHeight() - mPaddingBottom - mPaddingTop - 1, delta);
                } //End block
                {
                    int offsetToLast;
                    offsetToLast = getChildCount() - 1;
                    mMotionPosition = mFirstPosition + offsetToLast;
                    View lastView;
                    lastView = getChildAt(offsetToLast);
                    mMotionViewOriginalTop = lastView.getTop();
                    delta = Math.max(-(getHeight() - mPaddingBottom - mPaddingTop - 1), delta);
                } //End block
                View motionView;
                motionView = getChildAt(mMotionPosition - mFirstPosition);
                int oldTop;
                oldTop = 0;
                {
                    oldTop = motionView.getTop();
                } //End block
                boolean atEnd;
                atEnd = trackMotionScroll(delta, delta) && (delta != 0);
                {
                    {
                        int overshoot;
                        overshoot = -(delta - (motionView.getTop() - oldTop));
                        overScrollBy(0, overshoot, 0, mScrollY, 0, 0,
                                0, mOverflingDistance, false);
                    } //End block
                    {
                        edgeReached(delta);
                    } //End block
                } //End block
                {
                    invalidate();
                    mLastFlingY = y;
                    post(this);
                } //End block
                {
                    endFling();
                    {
                        {
                            Debug.stopMethodTracing();
                            mFlingProfilingStarted = false;
                        } //End block
                        {
                            mFlingStrictSpan.finish();
                            mFlingStrictSpan = null;
                        } //End block
                    } //End block
                } //End block
            } //End block
            //End case TOUCH_MODE_FLING 
            //Begin case TOUCH_MODE_OVERFLING 
            {
                OverScroller scroller;
                scroller = mScroller;
                {
                    boolean var0C92AC4985E057FF9B563A127E8C3B23_1438724885 = (scroller.computeScrollOffset());
                    {
                        int scrollY;
                        scrollY = mScrollY;
                        int currY;
                        currY = scroller.getCurrY();
                        int deltaY;
                        deltaY = currY - scrollY;
                        {
                            boolean var27491E7A6C26FA30763C389A29F73077_3424911 = (overScrollBy(0, deltaY, 0, scrollY, 0, 0,
                            0, mOverflingDistance, false));
                            {
                                boolean crossDown;
                                crossDown = scrollY <= 0 && currY > 0;
                                boolean crossUp;
                                crossUp = scrollY >= 0 && currY < 0;
                                {
                                    int velocity;
                                    velocity = (int) scroller.getCurrVelocity();
                                    velocity = -velocity;
                                    scroller.abortAnimation();
                                    start(velocity);
                                } //End block
                                {
                                    startSpringback();
                                } //End block
                            } //End block
                            {
                                invalidate();
                                post(this);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        endFling();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case TOUCH_MODE_OVERFLING 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int FLYWHEEL_TIMEOUT = 40;
    }


    
    class PositionScroller implements Runnable {
        private int mMode;
        private int mTargetPos;
        private int mBoundPos;
        private int mLastSeenPos;
        private int mScrollDuration;
        private int mExtraScroll;
        private int mOffsetFromTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.963 -0400", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "39D3C7BDBFB04AD5ABE46AB28461C81D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
            // ---------- Original Method ----------
            //mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.964 -0400", hash_original_method = "FDCD353E7B4C16B389C07FF98024D1F6", hash_generated_method = "0203BAB225BF9AB6F6EB41A257282722")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void start(int position) {
            dsTaint.addTaint(position);
            stop();
            int firstPos;
            firstPos = mFirstPosition;
            int lastPos;
            lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
            {
                viewTravelCount = firstPos - position + 1;
                mMode = MOVE_UP_POS;
            } //End block
            {
                viewTravelCount = position - lastPos + 1;
                mMode = MOVE_DOWN_POS;
            } //End block
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } //End block
            {
                mScrollDuration = SCROLL_DURATION;
            } //End block
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.964 -0400", hash_original_method = "84EF03A180BC8A392D5F6234ABF1A7D7", hash_generated_method = "674585EC14FE2D51E40ECB7D5B65DBC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void start(int position, int boundPosition) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(boundPosition);
            stop();
            {
                start(position);
            } //End block
            int firstPos;
            firstPos = mFirstPosition;
            int lastPos;
            lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
            {
                int boundPosFromLast;
                boundPosFromLast = lastPos - boundPosition;
                int posTravel;
                posTravel = firstPos - position + 1;
                int boundTravel;
                boundTravel = boundPosFromLast - 1;
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_UP_BOUND;
                } //End block
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_UP_POS;
                } //End block
            } //End block
            {
                int boundPosFromFirst;
                boundPosFromFirst = boundPosition - firstPos;
                int posTravel;
                posTravel = position - lastPos + 1;
                int boundTravel;
                boundTravel = boundPosFromFirst - 1;
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_DOWN_BOUND;
                } //End block
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_DOWN_POS;
                } //End block
            } //End block
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } //End block
            {
                mScrollDuration = SCROLL_DURATION;
            } //End block
            mLastSeenPos = INVALID_POSITION;
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.964 -0400", hash_original_method = "BE41DE2B3819156F24DD50B9D9C0C2E0", hash_generated_method = "6F20CEF815837469B0E0A48F93E9399C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startWithOffset(int position, int offset) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(offset);
            startWithOffset(position, offset, SCROLL_DURATION);
            // ---------- Original Method ----------
            //startWithOffset(position, offset, SCROLL_DURATION);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.965 -0400", hash_original_method = "6B17946EC33D794252BA778D04AAD100", hash_generated_method = "63AAEEE61688C3AA0A88B58B6080A080")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startWithOffset(int position, int offset, int duration) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(duration);
            dsTaint.addTaint(offset);
            stop();
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            mMode = MOVE_OFFSET;
            int firstPos;
            firstPos = mFirstPosition;
            int childCount;
            childCount = getChildCount();
            int lastPos;
            lastPos = firstPos + childCount - 1;
            int viewTravelCount;
            {
                viewTravelCount = firstPos - position;
            } //End block
            {
                viewTravelCount = position - lastPos;
            } //End block
            {
                int targetTop;
                targetTop = getChildAt(position - firstPos).getTop();
                smoothScrollBy(targetTop - offset, duration);
            } //End block
            float screenTravelCount;
            screenTravelCount = (float) viewTravelCount / childCount;
            mScrollDuration = screenTravelCount < 1 ? (int) (screenTravelCount * duration) :
                    (int) (duration / screenTravelCount);
            mLastSeenPos = INVALID_POSITION;
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.967 -0400", hash_original_method = "EE84C7B9935E89C7F265FE60CF403C46", hash_generated_method = "8545B8FD33B72FF1E0D42710AB6A286F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void stop() {
            removeCallbacks(this);
            // ---------- Original Method ----------
            //removeCallbacks(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.968 -0400", hash_original_method = "BF3ECE172F6D799B3639990958E45277", hash_generated_method = "541A4A7060C1ACC870F4ECE2FC5604DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            int listHeight;
            listHeight = getHeight();
            int firstPos;
            firstPos = mFirstPosition;
            //Begin case MOVE_DOWN_POS 
            {
                int lastViewIndex;
                lastViewIndex = getChildCount() - 1;
                int lastPos;
                lastPos = firstPos + lastViewIndex;
                {
                    post(this);
                } //End block
                View lastView;
                lastView = getChildAt(lastViewIndex);
                int lastViewHeight;
                lastViewHeight = lastView.getHeight();
                int lastViewTop;
                lastViewTop = lastView.getTop();
                int lastViewPixelsShowing;
                lastViewPixelsShowing = listHeight - lastViewTop;
                int extraScroll;
                extraScroll = mExtraScroll;
                extraScroll = mListPadding.bottom;
                smoothScrollBy(lastViewHeight - lastViewPixelsShowing + extraScroll,
                        mScrollDuration);
                mLastSeenPos = lastPos;
                {
                    post(this);
                } //End block
            } //End block
            //End case MOVE_DOWN_POS 
            //Begin case MOVE_DOWN_BOUND 
            {
                int nextViewIndex;
                nextViewIndex = 1;
                int childCount;
                childCount = getChildCount();
                int nextPos;
                nextPos = firstPos + nextViewIndex;
                {
                    post(this);
                } //End block
                View nextView;
                nextView = getChildAt(nextViewIndex);
                int nextViewHeight;
                nextViewHeight = nextView.getHeight();
                int nextViewTop;
                nextViewTop = nextView.getTop();
                int extraScroll;
                extraScroll = mExtraScroll;
                {
                    smoothScrollBy(Math.max(0, nextViewHeight + nextViewTop - extraScroll),
                            mScrollDuration);
                    mLastSeenPos = nextPos;
                    post(this);
                } //End block
                {
                    {
                        smoothScrollBy(nextViewTop - extraScroll, mScrollDuration);
                    } //End block
                } //End block
            } //End block
            //End case MOVE_DOWN_BOUND 
            //Begin case MOVE_UP_POS 
            {
                {
                    post(this);
                } //End block
                View firstView;
                firstView = getChildAt(0);
                int firstViewTop;
                firstViewTop = firstView.getTop();
                int extraScroll;
                extraScroll = mExtraScroll;
                extraScroll = mListPadding.top;
                smoothScrollBy(firstViewTop - extraScroll, mScrollDuration);
                mLastSeenPos = firstPos;
                {
                    post(this);
                } //End block
            } //End block
            //End case MOVE_UP_POS 
            //Begin case MOVE_UP_BOUND 
            {
                int lastViewIndex;
                lastViewIndex = getChildCount() - 2;
                int lastPos;
                lastPos = firstPos + lastViewIndex;
                {
                    post(this);
                } //End block
                View lastView;
                lastView = getChildAt(lastViewIndex);
                int lastViewHeight;
                lastViewHeight = lastView.getHeight();
                int lastViewTop;
                lastViewTop = lastView.getTop();
                int lastViewPixelsShowing;
                lastViewPixelsShowing = listHeight - lastViewTop;
                mLastSeenPos = lastPos;
                {
                    smoothScrollBy(-(lastViewPixelsShowing - mExtraScroll), mScrollDuration);
                    post(this);
                } //End block
                {
                    int bottom;
                    bottom = listHeight - mExtraScroll;
                    int lastViewBottom;
                    lastViewBottom = lastViewTop + lastViewHeight;
                    {
                        smoothScrollBy(-(bottom - lastViewBottom), mScrollDuration);
                    } //End block
                } //End block
            } //End block
            //End case MOVE_UP_BOUND 
            //Begin case MOVE_OFFSET 
            {
                {
                    post(this);
                } //End block
                mLastSeenPos = firstPos;
                int childCount;
                childCount = getChildCount();
                int position;
                position = mTargetPos;
                int lastPos;
                lastPos = firstPos + childCount - 1;
                int viewTravelCount;
                viewTravelCount = 0;
                {
                    viewTravelCount = firstPos - position + 1;
                } //End block
                {
                    viewTravelCount = position - lastPos;
                } //End block
                float screenTravelCount;
                screenTravelCount = (float) viewTravelCount / childCount;
                float modifier;
                modifier = Math.min(Math.abs(screenTravelCount), 1.f);
                {
                    smoothScrollBy((int) (-getHeight() * modifier), mScrollDuration);
                    post(this);
                } //End block
                {
                    smoothScrollBy((int) (getHeight() * modifier), mScrollDuration);
                    post(this);
                } //End block
                {
                    int targetTop;
                    targetTop = getChildAt(position - firstPos).getTop();
                    int distance;
                    distance = targetTop - mOffsetFromTop;
                    smoothScrollBy(distance,
                            (int) (mScrollDuration * ((float) distance / getHeight())));
                } //End block
            } //End block
            //End case MOVE_OFFSET 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int SCROLL_DURATION = 400;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_UP_POS = 2;
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_OFFSET = 5;
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.968 -0400", hash_original_method = "273FED591BB98950FDD1BF5E03A12471", hash_generated_method = "273FED591BB98950FDD1BF5E03A12471")
                public AdapterDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.968 -0400", hash_original_method = "70826FE759108269AA8BACD409E1C863", hash_generated_method = "DE01F6EC3ED43C4CD1396D4089463EFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onChanged();
            {
                mFastScroller.onSectionsChanged();
            } //End block
            // ---------- Original Method ----------
            //super.onChanged();
            //if (mFastScroller != null) {
                //mFastScroller.onSectionsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.969 -0400", hash_original_method = "4570C5F375E9950A79093241C88AF34D", hash_generated_method = "122CC95F86F15B9927F1E8118900CD7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onInvalidated();
            {
                mFastScroller.onSectionsChanged();
            } //End block
            // ---------- Original Method ----------
            //super.onInvalidated();
            //if (mFastScroller != null) {
                //mFastScroller.onSectionsChanged();
            //}
        }

        
    }


    
    class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.969 -0400", hash_original_method = "5296A2C1EA6411CB9788AB3F96A54C03", hash_generated_method = "5296A2C1EA6411CB9788AB3F96A54C03")
                public MultiChoiceModeWrapper ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.969 -0400", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "0E1C19B1035ECF220CE33F115AA5BFD1")
        @DSModeled(DSC.SAFE)
        public void setWrapped(MultiChoiceModeListener wrapped) {
            dsTaint.addTaint(wrapped.dsTaint);
            // ---------- Original Method ----------
            //mWrapped = wrapped;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.969 -0400", hash_original_method = "92496BA2B215F9BD39661C34B9C10361", hash_generated_method = "5C1BBA60EB35E2079FB82CFE502BFF24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            {
                boolean varD6C93448152EF2C372CDE7A0E8CB7504_104453980 = (mWrapped.onCreateActionMode(mode, menu));
                {
                    setLongClickable(false);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mWrapped.onCreateActionMode(mode, menu)) {
                //setLongClickable(false);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.969 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "7EA0255FF6006A055630C9BA6A4A645F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            boolean var889963BD11CE1DC6E3538FA5CA769B04_1844975945 = (mWrapped.onPrepareActionMode(mode, menu));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mWrapped.onPrepareActionMode(mode, menu);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.970 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "CED7916342AFB1EAE10D759DC851A201")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            boolean varFD1FD09DE497AC204C6AFB08C6591DDB_610096460 = (mWrapped.onActionItemClicked(mode, item));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mWrapped.onActionItemClicked(mode, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.970 -0400", hash_original_method = "38D50D306A79D91BC9BAC512614B14E4", hash_generated_method = "B9A8A9E60B6F0E1D2E676F431C6EE411")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onDestroyActionMode(ActionMode mode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(mode.dsTaint);
            mWrapped.onDestroyActionMode(mode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
            // ---------- Original Method ----------
            //mWrapped.onDestroyActionMode(mode);
            //mChoiceActionMode = null;
            //clearChoices();
            //mDataChanged = true;
            //rememberSyncState();
            //requestLayout();
            //setLongClickable(true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.970 -0400", hash_original_method = "54A7C456AE4C179767C141D1533A24F9", hash_generated_method = "DE4157B0C4927F2BB0CF94AC27C16909")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(id);
            dsTaint.addTaint(position);
            dsTaint.addTaint(checked);
            dsTaint.addTaint(mode.dsTaint);
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            {
                boolean var9E354D1EAEB52E913322B0C21F0A7D1D_325609590 = (getCheckedItemCount() == 0);
                {
                    mode.finish();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            //if (getCheckedItemCount() == 0) {
                //mode.finish();
            //}
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        }) int viewType;
        @ViewDebug.ExportedProperty(category = "list") boolean recycledHeaderFooter;
        @ViewDebug.ExportedProperty(category = "list") boolean forceAdd;
        int scrappedFromPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.970 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "29097574B95BAB8FE5C81F6EF894805C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.971 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "F71B67880A1259DC17133E677BB52754")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int w, int h) {
            super(w, h);
            dsTaint.addTaint(w);
            dsTaint.addTaint(h);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.971 -0400", hash_original_method = "CB5E57490495E3D022159C4744E426CF", hash_generated_method = "8065F8D29F26C408A17CA23D298B5345")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int w, int h, int viewType) {
            super(w, h);
            dsTaint.addTaint(w);
            dsTaint.addTaint(viewType);
            dsTaint.addTaint(h);
            // ---------- Original Method ----------
            //this.viewType = viewType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.971 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "1B8A923CB2D1359AEB1E56B11A4FD570")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    class RecycleBin {
        private RecyclerListener mRecyclerListener;
        private int mFirstActivePosition;
        private View[] mActiveViews = new View[0];
        private ArrayList<View>[] mScrapViews;
        private int mViewTypeCount;
        private ArrayList<View> mCurrentScrap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.971 -0400", hash_original_method = "77072A41A6368207FF0B7DC6E8B24F28", hash_generated_method = "77072A41A6368207FF0B7DC6E8B24F28")
                public RecycleBin ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.971 -0400", hash_original_method = "2027E38C638AFAF08EBC73DB2999B11D", hash_generated_method = "57383540E29B36C27C7D0550D0DC8798")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setViewTypeCount(int viewTypeCount) {
            dsTaint.addTaint(viewTypeCount);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            } //End block
            ArrayList<View>[] scrapViews;
            scrapViews = new ArrayList[viewTypeCount];
            {
                int i;
                i = 0;
                {
                    scrapViews[i] = new ArrayList<View>();
                } //End block
            } //End collapsed parenthetic
            mCurrentScrap = scrapViews[0];
            mScrapViews = scrapViews;
            // ---------- Original Method ----------
            //if (viewTypeCount < 1) {
                //throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            //}
            //ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
            //for (int i = 0; i < viewTypeCount; i++) {
                //scrapViews[i] = new ArrayList<View>();
            //}
            //mViewTypeCount = viewTypeCount;
            //mCurrentScrap = scrapViews[0];
            //mScrapViews = scrapViews;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.972 -0400", hash_original_method = "84FB41DBF94FAC74E383190ECD19AC3F", hash_generated_method = "B7905DF833EFD25178251E1C5FF4CCF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void markChildrenDirty() {
            {
                ArrayList<View> scrap;
                scrap = mCurrentScrap;
                int scrapCount;
                scrapCount = scrap.size();
                {
                    int i;
                    i = 0;
                    {
                        scrap.get(i).forceLayout();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int typeCount;
                typeCount = mViewTypeCount;
                {
                    int i;
                    i = 0;
                    {
                        ArrayList<View> scrap;
                        scrap = mScrapViews[i];
                        int scrapCount;
                        scrapCount = scrap.size();
                        {
                            int j;
                            j = 0;
                            {
                                scrap.get(j).forceLayout();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //if (mViewTypeCount == 1) {
                //final ArrayList<View> scrap = mCurrentScrap;
                //final int scrapCount = scrap.size();
                //for (int i = 0; i < scrapCount; i++) {
                    //scrap.get(i).forceLayout();
                //}
            //} else {
                //final int typeCount = mViewTypeCount;
                //for (int i = 0; i < typeCount; i++) {
                    //final ArrayList<View> scrap = mScrapViews[i];
                    //final int scrapCount = scrap.size();
                    //for (int j = 0; j < scrapCount; j++) {
                        //scrap.get(j).forceLayout();
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.972 -0400", hash_original_method = "511AFE11A00C49C0B36C81F833AD1339", hash_generated_method = "9FE31748252841C3DC0054831876B9FA")
        @DSModeled(DSC.SAFE)
        public boolean shouldRecycleViewType(int viewType) {
            dsTaint.addTaint(viewType);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return viewType >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.972 -0400", hash_original_method = "D3A3C7CFD0DB416C40300347744B44D9", hash_generated_method = "EAA7B8E911CBEEAE8B2178784036FBBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void clear() {
            {
                ArrayList<View> scrap;
                scrap = mCurrentScrap;
                int scrapCount;
                scrapCount = scrap.size();
                {
                    int i;
                    i = 0;
                    {
                        removeDetachedView(scrap.remove(scrapCount - 1 - i), false);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int typeCount;
                typeCount = mViewTypeCount;
                {
                    int i;
                    i = 0;
                    {
                        ArrayList<View> scrap;
                        scrap = mScrapViews[i];
                        int scrapCount;
                        scrapCount = scrap.size();
                        {
                            int j;
                            j = 0;
                            {
                                removeDetachedView(scrap.remove(scrapCount - 1 - j), false);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //if (mViewTypeCount == 1) {
                //final ArrayList<View> scrap = mCurrentScrap;
                //final int scrapCount = scrap.size();
                //for (int i = 0; i < scrapCount; i++) {
                    //removeDetachedView(scrap.remove(scrapCount - 1 - i), false);
                //}
            //} else {
                //final int typeCount = mViewTypeCount;
                //for (int i = 0; i < typeCount; i++) {
                    //final ArrayList<View> scrap = mScrapViews[i];
                    //final int scrapCount = scrap.size();
                    //for (int j = 0; j < scrapCount; j++) {
                        //removeDetachedView(scrap.remove(scrapCount - 1 - j), false);
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.973 -0400", hash_original_method = "8EEC6DB7AE7CDFC4B2320C472F7412E6", hash_generated_method = "A011E1DB5C4418B35757B9D04ED12AB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void fillActiveViews(int childCount, int firstActivePosition) {
            dsTaint.addTaint(childCount);
            dsTaint.addTaint(firstActivePosition);
            {
                mActiveViews = new View[childCount];
            } //End block
            View[] activeViews;
            activeViews = mActiveViews;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    AbsListView.LayoutParams lp;
                    lp = (AbsListView.LayoutParams) child.getLayoutParams();
                    {
                        activeViews[i] = child;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (mActiveViews.length < childCount) {
                //mActiveViews = new View[childCount];
            //}
            //mFirstActivePosition = firstActivePosition;
            //final View[] activeViews = mActiveViews;
            //for (int i = 0; i < childCount; i++) {
                //View child = getChildAt(i);
                //AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
                //if (lp != null && lp.viewType != ITEM_VIEW_TYPE_HEADER_OR_FOOTER) {
                    //activeViews[i] = child;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.973 -0400", hash_original_method = "6DDE0EAFBBDE35C2F4BC64D693E74936", hash_generated_method = "B03703BDADFF29A0EE80BBF26220EF74")
        @DSModeled(DSC.SAFE)
         View getActiveView(int position) {
            dsTaint.addTaint(position);
            int index;
            index = position - mFirstActivePosition;
            View[] activeViews;
            activeViews = mActiveViews;
            {
                View match;
                match = activeViews[index];
                activeViews[index] = null;
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int index = position - mFirstActivePosition;
            //final View[] activeViews = mActiveViews;
            //if (index >=0 && index < activeViews.length) {
                //final View match = activeViews[index];
                //activeViews[index] = null;
                //return match;
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.973 -0400", hash_original_method = "7C1BB02F0CFB7D7F7BDB0DC42C0788DA", hash_generated_method = "A54A7B9937474C2D0B80DD6328147153")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         View getScrapView(int position) {
            dsTaint.addTaint(position);
            {
                View varA923EEA0464BA2DCF247B08DE4AB8E85_815849720 = (retrieveFromScrap(mCurrentScrap, position));
            } //End block
            {
                int whichScrap;
                whichScrap = mAdapter.getItemViewType(position);
                {
                    View var06E35DD32C4D93E075CDF1EE9C79FA1E_178519654 = (retrieveFromScrap(mScrapViews[whichScrap], position));
                } //End block
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mViewTypeCount == 1) {
                //return retrieveFromScrap(mCurrentScrap, position);
            //} else {
                //int whichScrap = mAdapter.getItemViewType(position);
                //if (whichScrap >= 0 && whichScrap < mScrapViews.length) {
                    //return retrieveFromScrap(mScrapViews[whichScrap], position);
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.974 -0400", hash_original_method = "ED120D0157D66531494A9FD53EAE380E", hash_generated_method = "06FE026815B38E1273DD065147DE99BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void addScrapView(View scrap, int position) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(scrap.dsTaint);
            AbsListView.LayoutParams lp;
            lp = (AbsListView.LayoutParams) scrap.getLayoutParams();
            int viewType;
            viewType = lp.viewType;
            {
                boolean var78318F84F970183913C3A58475F2628A_2063405958 = (!shouldRecycleViewType(viewType));
                {
                    {
                        removeDetachedView(scrap, false);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            lp.scrappedFromPosition = position;
            {
                scrap.dispatchStartTemporaryDetach();
                mCurrentScrap.add(scrap);
            } //End block
            {
                scrap.dispatchStartTemporaryDetach();
                mScrapViews[viewType].add(scrap);
            } //End block
            {
                mRecyclerListener.onMovedToScrapHeap(scrap);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.975 -0400", hash_original_method = "3138270AA2660474D2B7E99137A02556", hash_generated_method = "5F32C106AC21B92028950E28A4FE57EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void scrapActiveViews() {
            View[] activeViews;
            activeViews = mActiveViews;
            boolean hasListener;
            hasListener = mRecyclerListener != null;
            boolean multipleScraps;
            multipleScraps = mViewTypeCount > 1;
            ArrayList<View> scrapViews;
            scrapViews = mCurrentScrap;
            int count;
            count = activeViews.length;
            {
                int i;
                i = count - 1;
                {
                    View victim;
                    victim = activeViews[i];
                    {
                        AbsListView.LayoutParams lp;
                        lp = (AbsListView.LayoutParams) victim.getLayoutParams();
                        int whichScrap;
                        whichScrap = lp.viewType;
                        activeViews[i] = null;
                        {
                            boolean var51E473BD444D9F2F14A7E3EC67387565_1202274428 = (!shouldRecycleViewType(whichScrap));
                            {
                                {
                                    removeDetachedView(victim, false);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            scrapViews = mScrapViews[whichScrap];
                        } //End block
                        victim.dispatchStartTemporaryDetach();
                        lp.scrappedFromPosition = mFirstActivePosition + i;
                        scrapViews.add(victim);
                        {
                            mRecyclerListener.onMovedToScrapHeap(victim);
                        } //End block
                        {
                            ViewDebug.trace(victim,
                                ViewDebug.RecyclerTraceType.MOVE_FROM_ACTIVE_TO_SCRAP_HEAP,
                                mFirstActivePosition + i, -1);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            pruneScrapViews();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.975 -0400", hash_original_method = "EA58D1FE496277FE2ED85A93396A169A", hash_generated_method = "55567F6691B28724F3D86D3D21366CBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void pruneScrapViews() {
            int maxViews;
            maxViews = mActiveViews.length;
            int viewTypeCount;
            viewTypeCount = mViewTypeCount;
            ArrayList<View>[] scrapViews;
            scrapViews = mScrapViews;
            {
                int i;
                i = 0;
                {
                    ArrayList<View> scrapPile;
                    scrapPile = scrapViews[i];
                    int size;
                    size = scrapPile.size();
                    int extras;
                    extras = size - maxViews;
                    {
                        int j;
                        j = 0;
                        {
                            removeDetachedView(scrapPile.remove(size--), false);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //final int maxViews = mActiveViews.length;
            //final int viewTypeCount = mViewTypeCount;
            //final ArrayList<View>[] scrapViews = mScrapViews;
            //for (int i = 0; i < viewTypeCount; ++i) {
                //final ArrayList<View> scrapPile = scrapViews[i];
                //int size = scrapPile.size();
                //final int extras = size - maxViews;
                //size--;
                //for (int j = 0; j < extras; j++) {
                    //removeDetachedView(scrapPile.remove(size--), false);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.975 -0400", hash_original_method = "3FD0A968FC7E2613466435C98B02B7BD", hash_generated_method = "267F70FD9D6EA9F1F3E73F44C270F011")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void reclaimScrapViews(List<View> views) {
            dsTaint.addTaint(views.dsTaint);
            {
                views.addAll(mCurrentScrap);
            } //End block
            {
                int viewTypeCount;
                viewTypeCount = mViewTypeCount;
                ArrayList<View>[] scrapViews;
                scrapViews = mScrapViews;
                {
                    int i;
                    i = 0;
                    {
                        ArrayList<View> scrapPile;
                        scrapPile = scrapViews[i];
                        views.addAll(scrapPile);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //if (mViewTypeCount == 1) {
                //views.addAll(mCurrentScrap);
            //} else {
                //final int viewTypeCount = mViewTypeCount;
                //final ArrayList<View>[] scrapViews = mScrapViews;
                //for (int i = 0; i < viewTypeCount; ++i) {
                    //final ArrayList<View> scrapPile = scrapViews[i];
                    //views.addAll(scrapPile);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.976 -0400", hash_original_method = "BA10D81754F1A95A0F7C755DD4764D3B", hash_generated_method = "C4F1D0DCC2ADE02098250228C55E8DCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void setCacheColorHint(int color) {
            dsTaint.addTaint(color);
            {
                ArrayList<View> scrap;
                scrap = mCurrentScrap;
                int scrapCount;
                scrapCount = scrap.size();
                {
                    int i;
                    i = 0;
                    {
                        scrap.get(i).setDrawingCacheBackgroundColor(color);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int typeCount;
                typeCount = mViewTypeCount;
                {
                    int i;
                    i = 0;
                    {
                        ArrayList<View> scrap;
                        scrap = mScrapViews[i];
                        int scrapCount;
                        scrapCount = scrap.size();
                        {
                            int j;
                            j = 0;
                            {
                                scrap.get(j).setDrawingCacheBackgroundColor(color);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            View[] activeViews;
            activeViews = mActiveViews;
            int count;
            count = activeViews.length;
            {
                int i;
                i = 0;
                {
                    View victim;
                    victim = activeViews[i];
                    {
                        victim.setDrawingCacheBackgroundColor(color);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
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

