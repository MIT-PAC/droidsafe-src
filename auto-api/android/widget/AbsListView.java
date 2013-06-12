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
    public static int TRANSCRIPT_MODE_DISABLED = 0;
    public static int TRANSCRIPT_MODE_NORMAL = 1;
    public static int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    static int TOUCH_MODE_REST = -1;
    static int TOUCH_MODE_DOWN = 0;
    static int TOUCH_MODE_TAP = 1;
    static int TOUCH_MODE_DONE_WAITING = 2;
    static int TOUCH_MODE_SCROLL = 3;
    static int TOUCH_MODE_FLING = 4;
    static int TOUCH_MODE_OVERSCROLL = 5;
    static int TOUCH_MODE_OVERFLING = 6;
    static int LAYOUT_NORMAL = 0;
    static int LAYOUT_FORCE_TOP = 1;
    static int LAYOUT_SET_SELECTION = 2;
    static int LAYOUT_FORCE_BOTTOM = 3;
    static int LAYOUT_SPECIFIC = 4;
    static int LAYOUT_SYNC = 5;
    static int LAYOUT_MOVE_SELECTION = 6;
    public static int CHOICE_MODE_NONE = 0;
    public static int CHOICE_MODE_SINGLE = 1;
    public static int CHOICE_MODE_MULTIPLE = 2;
    public static int CHOICE_MODE_MULTIPLE_MODAL = 3;
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
    static int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static int CHECK_POSITION_SEARCH_DISTANCE = 20;
    private static int TOUCH_MODE_UNKNOWN = -1;
    private static int TOUCH_MODE_ON = 0;
    private static int TOUCH_MODE_OFF = 1;
    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
    private static boolean PROFILE_SCROLLING = false;
    private boolean mScrollProfilingStarted = false;
    private static boolean PROFILE_FLINGING = false;
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
    private static int INVALID_POINTER = -1;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.726 -0400", hash_original_method = "6A1152DD2F769DBF7D49F3027748695E", hash_generated_method = "1A883D1294E795BE38FA2A0BA9ECC3FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.736 -0400", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "99B06368A2016C1DBED5070511CAEA3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.767 -0400", hash_original_method = "A8C0C093ECB8745800A88EB739981F47", hash_generated_method = "DED9ED439E9DFFBBBD628F06E8881FA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.803 -0400", hash_original_method = "2C481DB3FCB8FF016FB8E3D34F80B2B8", hash_generated_method = "DCF0451A07C7627A62B77BF2B27704F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.815 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "49E4C3EEDA409DC13AA987494CC17B17")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.833 -0400", hash_original_method = "2831A8F535381CCEFB0BADB6BC86E26A", hash_generated_method = "9A66170594810BD425E46BD859A8B8DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            {
                boolean var38CEBABFDDE46DFC47E0A770A36F9546_759733239 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.839 -0400", hash_original_method = "5DFF60E6C611266C8D61B940778B8222", hash_generated_method = "3872D9127F163978E60E3B65E662B737")
    @DSModeled(DSC.SAFE)
    public int getCheckedItemCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCheckedItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.846 -0400", hash_original_method = "76DE4C8AF2033C88DA13B2D6D79BE8CC", hash_generated_method = "4C04676F93745168D6F4C900884ECC87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isItemChecked(int position) {
        dsTaint.addTaint(position);
        {
            boolean var0D150F0C81FAF2A662314396EC0C31E7_1040331060 = (mCheckStates.get(position));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null) {
            //return mCheckStates.get(position);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.854 -0400", hash_original_method = "40A1040C0B9BA1980C4FD0733FBB2F2E", hash_generated_method = "D73B86D8442137B66098C59AF7DEC39D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCheckedItemPosition() {
        {
            boolean varA1B9DE9EDBC04ECFD56B33C2A5BF45B0_758700905 = (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1);
            {
                int varD7BABAE4F11D1568725A045F030C9B34_606726361 = (mCheckStates.keyAt(0));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1) {
            //return mCheckStates.keyAt(0);
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.860 -0400", hash_original_method = "DD9B0503EDD82432AE0B7C0599D4B447", hash_generated_method = "EC8BDEED1EEBFFC52C6C05D9A852C2AF")
    @DSModeled(DSC.SAFE)
    public SparseBooleanArray getCheckedItemPositions() {
        return (SparseBooleanArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE) {
            //return mCheckStates;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.891 -0400", hash_original_method = "C085907095DB552ED74D8B304576006A", hash_generated_method = "FED1747F93CAB28F4F6FF513EFC087EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] getCheckedItemIds() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.903 -0400", hash_original_method = "A5D48B0328BC1A467504F22AFA94E40C", hash_generated_method = "5C7103E7897876658DAD3F77ABF29692")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.946 -0400", hash_original_method = "43E07392067BD1BC5F99F3882FA40E88", hash_generated_method = "D1501EB283815096BDA25E4960C6D611")
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
                boolean varDF5D6CF73909C5793DEDFF57AC70B3A9_432745302 = (mCheckedIdStates != null && mAdapter.hasStableIds());
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
                {
                    mCheckedItemCount++;
                } //End block
                {
                    mCheckedItemCount--;
                } //End block
            } //End block
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
                boolean varE3E83AB27085DF4D75DE8758E514DAA9_680880614 = (value || isItemChecked(position));
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
                boolean var425458AA9F83015DB14C2404DEE4E159_299914530 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:43.989 -0400", hash_original_method = "9A0165787640E5C3A3D1AC60426CC2CC", hash_generated_method = "DC866783D01202E11C79E3B81D2F4A8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performItemClick(View view, int position, long id) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(id);
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
                    boolean varFFF95FDDB84D487F1FD71AE5B4D04DFA_932025408 = (mCheckedIdStates != null && mAdapter.hasStableIds());
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
                    mCheckedItemCount++;
                } //End block
                {
                    mCheckedItemCount--;
                } //End block
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
                        boolean varD30D994107B77CF4004B51C1F80A4DE7_1087540884 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                        {
                            mCheckedIdStates.clear();
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } //End block
                    } //End collapsed parenthetic
                    mCheckedItemCount = 1;
                } //End block
                {
                    boolean var6ACBF7B7E15B02DF34CBCD44F94045DE_151545096 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.004 -0400", hash_original_method = "8E2D8E05EEC3041F2430430C00E99F2E", hash_generated_method = "1992BBDB6D27971182BEA4F21A0CBAEB")
    @DSModeled(DSC.SAFE)
    public int getChoiceMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChoiceMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.020 -0400", hash_original_method = "31284EBF9693FA29D08DAAB1651BB216", hash_generated_method = "C23B96B555C97D14F778DD6A237DB104")
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
                boolean var2BF65510232B6C8CFF89CFE72E6D8ACB_445385753 = (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.027 -0400", hash_original_method = "AB030C487B8A76B7A3B990C85D8D5284", hash_generated_method = "754D74694E5FB533C363DCFF28525154")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.035 -0400", hash_original_method = "34BF563ABF29C3DFDECFCC44CD785338", hash_generated_method = "A21836CA5802C813AEC674B8EC83C0C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean contentFits() {
        int childCount;
        childCount = getChildCount();
        boolean varB916502A2FFF50967FBE5280BE01D3D7_1949522922 = (getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount == 0) return true;
        //if (childCount != mItemCount) return false;
        //return getChildAt(0).getTop() >= mListPadding.top &&
                //getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.042 -0400", hash_original_method = "595588F5399A1D343B61A8313A8ACA6F", hash_generated_method = "0E23521EB2703EA47442E602AB2A36DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.048 -0400", hash_original_method = "76A971EB75129863E10E67DBAAA59745", hash_generated_method = "B254D2BC8840A168FB78113B37F6E3B0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.053 -0400", hash_original_method = "B8FB7506E98011F45E37A448BFD532A7", hash_generated_method = "2BD0F0B962AB62DBFB6212A8EC870E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFastScrollAlwaysVisible() {
        boolean var26B2F46AB3144EF80214E1227EB2F480_1556459077 = (mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.059 -0400", hash_original_method = "7B9EF1235ED171F1370B12BB905DC3C9", hash_generated_method = "74EB7D45A258B8A687893B7C5DD80935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getVerticalScrollbarWidth() {
        {
            boolean var26909BC69BA2F3E69FEBFE306B4E5DAD_595141964 = (isFastScrollAlwaysVisible());
            {
                int varFB51A5362339E3615BCF0229E08CB917_1712597063 = (Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth()));
            } //End block
        } //End collapsed parenthetic
        int var08FF7A4CA397B890F67D51D77687712B_227674549 = (super.getVerticalScrollbarWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (isFastScrollAlwaysVisible()) {
            //return Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth());
        //}
        //return super.getVerticalScrollbarWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.063 -0400", hash_original_method = "0BC112ABD3166320C6B43E3AFC3B6D61", hash_generated_method = "519E3CEBD748667B890A874B3D9E71E7")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScrollEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.068 -0400", hash_original_method = "A675D7279FF2D5DA4484C8480BA7553A", hash_generated_method = "53A122F97D3D9DBD64D05B4D55D411F1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.073 -0400", hash_original_method = "940CDB7D64F97F8EC4A4E1C87858DFBA", hash_generated_method = "6207CDB5B38F97067239FBB0BE82EDC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isVerticalScrollBarHidden() {
        boolean varEE7670B7B7BC0CBAC7B3A19E6E35E88F_1929198459 = (mFastScroller != null && mFastScroller.isVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFastScroller != null && mFastScroller.isVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.078 -0400", hash_original_method = "1698DB675ADDAA62665F2F04BB6F72CB", hash_generated_method = "68B822AC49DD981908C46EF14340D018")
    @DSModeled(DSC.SAFE)
    public void setSmoothScrollbarEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        // ---------- Original Method ----------
        //mSmoothScrollbarEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.081 -0400", hash_original_method = "475C5FFCF382FD26204BCB75E2B77D7D", hash_generated_method = "65A9696C30509C9E7DD8577AEED03C49")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSmoothScrollbarEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.085 -0400", hash_original_method = "210B7E1D385EBACE9AEF47F53212EE62", hash_generated_method = "FFD5D8B6794F3A17CEBDB4B9A922D1AD")
    @DSModeled(DSC.SAFE)
    public void setOnScrollListener(OnScrollListener l) {
        dsTaint.addTaint(l.dsTaint);
        invokeOnItemScrollListener();
        // ---------- Original Method ----------
        //mOnScrollListener = l;
        //invokeOnItemScrollListener();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.102 -0400", hash_original_method = "BA8530F9EF3261CEDA66BF584A9CCD3E", hash_generated_method = "4490C6700218B8942C40D7B0439191F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.109 -0400", hash_original_method = "B64F2C3012E6A3D7EFE9332FD2B83485", hash_generated_method = "5C30422A8A71584373B08F6CB437960D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.113 -0400", hash_original_method = "9414D347741A5DD8E57796525BCE5898", hash_generated_method = "090F83CCE7141AF322AF3A3F56746F05")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollingCacheEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.123 -0400", hash_original_method = "150D6943577E82022A370D7488992E67", hash_generated_method = "BE2793E43E0A2775964909E531AA4E62")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.126 -0400", hash_original_method = "8476047A74E8C2792EEAD35F27B63501", hash_generated_method = "54B40F6540DB4F5D82F322B1F0C43D10")
    @DSModeled(DSC.SAFE)
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        dsTaint.addTaint(textFilterEnabled);
        // ---------- Original Method ----------
        //mTextFilterEnabled = textFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.130 -0400", hash_original_method = "D536B611E01E5CFE1F666765CAB03290", hash_generated_method = "8F0BA7DE2C83127BA869BE325E00E05C")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.135 -0400", hash_original_method = "1C8D0A5FE9343035731EC5D6D9384599", hash_generated_method = "45E1652D3C37027A9DD9EA996CDBE923")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getFocusedRect(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        View view;
        view = getSelectedView();
        {
            boolean varA78CB7AA6BC92F805E05829844E1ECE3_1859311629 = (view != null && view.getParent() == this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.139 -0400", hash_original_method = "9E8C7705C9D325A7FB79BC94A2C5E742", hash_generated_method = "A902C6E379654B57A9A5D7717F7287F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(
                //com.android.internal.R.drawable.list_selector_background));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.142 -0400", hash_original_method = "991365D9D991378A506E868734A0B0D2", hash_generated_method = "FF743961B12BFA1C1C9372EB2D4EE511")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStackFromBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.146 -0400", hash_original_method = "CFFEAD7E7BECCE023678F7841887953F", hash_generated_method = "B4168999A02889D4CB82CE98265191E5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.150 -0400", hash_original_method = "DBB2E77784FB40B043F5BACE416B5D38", hash_generated_method = "89B13137991869E67D77626B17E75CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requestLayoutIfNecessary() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1358487736 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.164 -0400", hash_original_method = "550511192552500388A3039280244936", hash_generated_method = "556A88A59D02699FDADE262A728605EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.175 -0400", hash_original_method = "43BE5C5AD27C719005EFC4A46B8486A7", hash_generated_method = "FC08546170CA74D1E75263604B92F803")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.179 -0400", hash_original_method = "42E27AF1CE674CD4135EEA22852A217B", hash_generated_method = "E82EE111035BB980D545957FF246BF90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean acceptFilter() {
        boolean varA2D4C9A63B028E8345B4157A680073A2_297535638 = (mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextFilterEnabled && getAdapter() instanceof Filterable &&
                //((Filterable) getAdapter()).getFilter() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.185 -0400", hash_original_method = "A8CCB94844A67C45EFD075D798DD3AF0", hash_generated_method = "D7D79C4E4062966CD7F4862063812D7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFilterText(String filterText) {
        dsTaint.addTaint(filterText);
        {
            boolean var190C1EE91DE344514DA2209FAF0C3D82_2038465558 = (mTextFilterEnabled && !TextUtils.isEmpty(filterText));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.190 -0400", hash_original_method = "1C9B36BFA6AA511A6999C19189070FD4", hash_generated_method = "FD9DFBF132FF5100B9742641842EF4B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextFilter() {
        {
            CharSequence varDF6F55DC5C9DC328BEED19950632B8DE_1511506764 = (mTextFilter.getText());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mTextFilterEnabled && mTextFilter != null) {
            //return mTextFilter.getText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.196 -0400", hash_original_method = "0C025ACF6797C1095DC28C93A47B3E04", hash_generated_method = "93D634EA0168C5BC81E7A94DA516D268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(gainFocus);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        {
            boolean var8EB9364CA747E30AAC5C9F3175F02645_986168456 = (gainFocus && mSelectedPosition < 0 && !isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.200 -0400", hash_original_method = "B180005EA1177A66433DC47F81A1B223", hash_generated_method = "175D942DF737AF392287DB85FC9526F6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.204 -0400", hash_original_method = "8DD5C430A497277A13BB6B282542179B", hash_generated_method = "FDBC3DD61E0CEA623B9A70F23F79C8B0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.212 -0400", hash_original_method = "EAD3946FC18204D61E6D52ABAEC42671", hash_generated_method = "7056947F5CF883ECB0053C065F362482")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.221 -0400", hash_original_method = "B342EEB15F9AC09DD167764D56209B72", hash_generated_method = "E12F1E5D003F13D25FEDD17D72436610")
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
                    int var813D884A4C0D547484060C54181A041A_1506882274 = (Math.max(firstPosition * 100 - (top * 100) / height +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.226 -0400", hash_original_method = "4324030F56A09BCB8354791FE2A22081", hash_generated_method = "2A7081FAE3D54665C503B12148441D6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.232 -0400", hash_original_method = "6B45AE0F220A2E6F043181E50094F343", hash_generated_method = "405FE1A15F060865FC31FDD5C6AF227F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.250 -0400", hash_original_method = "7783F8E763936950C57ED5516E6F7E94", hash_generated_method = "7F8F0CC04A5B5010143A09844201045E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.260 -0400", hash_original_method = "7C6C2B65B4381736E49DE73CCD130327", hash_generated_method = "52E5B1332340A409615AC8946FECC725")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.275 -0400", hash_original_method = "46F44099FEFDB133D6B976408934CAC6", hash_generated_method = "5953B920E51418C5F935C0B8B33F736B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.283 -0400", hash_original_method = "748FD791AA503E7E1D859CFD661EA755", hash_generated_method = "ECAA338204B0B06FD74DF926B7583F66")
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
                boolean varFBED1B944623C6BCA164EC2723F71804_1785301441 = (mFiltered && visible && mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.287 -0400", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "7AB60EE910C1FABE0EBC2178812FE2CB")
    @DSModeled(DSC.SAFE)
    protected void layoutChildren() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.311 -0400", hash_original_method = "180044681435C2C9D1AB0FD8756137A4", hash_generated_method = "4CB85FA69F42AF9F9FBEF3CD0D15BB2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateScrollIndicators() {
        {
            boolean canScrollUp;
            canScrollUp = mFirstPosition > 0;
            {
                {
                    boolean var4813CB3BCCB7AE7282F404FB5F98BC43_1353311361 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.317 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "A8EC38E698639AA55C7E13F044A47CCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        {
            View var32627160716DC777F524CC780C8B0164_446362800 = (getChildAt(mSelectedPosition - mFirstPosition));
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition >= 0) {
            //return getChildAt(mSelectedPosition - mFirstPosition);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.325 -0400", hash_original_method = "3B697574C47153B82BC97C5C46624F2C", hash_generated_method = "F52A6A558D017CECC511568133B301DB")
    @DSModeled(DSC.SAFE)
    public int getListPaddingTop() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.330 -0400", hash_original_method = "CEE980D8545C78DFB596AE8650DBF797", hash_generated_method = "57AA64E72E6F99BABB1AD55C304ED31F")
    @DSModeled(DSC.SAFE)
    public int getListPaddingBottom() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.334 -0400", hash_original_method = "C8B939C15FBE7011BDF7672B6F924B56", hash_generated_method = "F1D5E95D717592053B3EA94A470A39C4")
    @DSModeled(DSC.SAFE)
    public int getListPaddingLeft() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.337 -0400", hash_original_method = "1F1F9379D690EBB0F58C075805935B4C", hash_generated_method = "F1F24C2F1822152FB486AE4997FEDFC6")
    @DSModeled(DSC.SAFE)
    public int getListPaddingRight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mListPadding.right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.345 -0400", hash_original_method = "F1A94AACBC76DA4834C170841A9D4C37", hash_generated_method = "50F68474C24EA392F5E25364399FA5D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.354 -0400", hash_original_method = "B068259C5BBCB2A7501108708CD5A4C4", hash_generated_method = "60534E68DC779D8DCF240F5E400EE5D0")
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
            boolean varFB59463D8D8AB76E1E484CE2BBC5519D_17818807 = (sel.isEnabled() != isChildViewEnabled);
            {
                mIsChildViewEnabled = !isChildViewEnabled;
                {
                    boolean var9ACEB0A565E658741B99EDC3F95405AB_1022156446 = (getSelectedItemPosition() != INVALID_POSITION);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.358 -0400", hash_original_method = "9958A79674A9EAF808CC1CD0A2974C67", hash_generated_method = "2ADD7AAF7B65AD07AE9D2599E646ECDE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.368 -0400", hash_original_method = "EB6A446E7A5D607DB4BF2796F54D03FA", hash_generated_method = "A42FC92A38BD72F76898B70F1F936C07")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.373 -0400", hash_original_method = "E1295B3F3CD2AED842AA5266ED41ED1A", hash_generated_method = "61B4078731DF7016B0D589C6DA0D728C")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isPaddingOffsetRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) != CLIP_TO_PADDING_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.377 -0400", hash_original_method = "C31A372B11969057E398197BABCC2FB9", hash_generated_method = "AD0EDF266B5DB67D918CB8C3735EFD3E")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getLeftPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.380 -0400", hash_original_method = "F0F07013F187EA8DBDDCF030EEADD0A0", hash_generated_method = "FC9B6E0089C692D39E666F2F17CA8E31")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getTopPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.383 -0400", hash_original_method = "D64BFD9DD2CC0187FA2BCDAC4D5056C0", hash_generated_method = "B74A448C643288C4D66A1BED5D457B0C")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getRightPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.386 -0400", hash_original_method = "A76EA354621A97D061AF35F7F0E022AA", hash_generated_method = "F52B386E7E2FB50308C3957E6D22E489")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getBottomPaddingOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.393 -0400", hash_original_method = "7222D25647FA66D7134D6564AB03A11A", hash_generated_method = "CF7E70687C60F1C86DAB96DEEB20BA51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(w);
        dsTaint.addTaint(oldw);
        dsTaint.addTaint(oldh);
        dsTaint.addTaint(h);
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_2030105196 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.410 -0400", hash_original_method = "E2B9A99414FF2EE03BB0A755AC5DBB16", hash_generated_method = "FF421EB84682070FB3064AA81F138B97")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.428 -0400", hash_original_method = "FA7D742C09854F2E7F00273E8807D507", hash_generated_method = "AA071D6F515DD0F61BD2409DBDF64C99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean shouldShowSelector() {
        boolean var4246A524C7FBFC973820D2F78D9E8F98_694471755 = ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.438 -0400", hash_original_method = "1653A38E1AF50A830D0C8CACED5D71E9", hash_generated_method = "D37CC1B5D9C37787A43159F10A5C4653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drawSelector(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean var101389AC9853324A8F2F4AC467A8FE5D_455594003 = (!mSelectorRect.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.444 -0400", hash_original_method = "E224CB1DBFEAEB35D4CBDCEA1ACB7063", hash_generated_method = "C39D9181BCD72CE83EFBF150259B142C")
    @DSModeled(DSC.SAFE)
    public void setDrawSelectorOnTop(boolean onTop) {
        dsTaint.addTaint(onTop);
        // ---------- Original Method ----------
        //mDrawSelectorOnTop = onTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.447 -0400", hash_original_method = "4BF5D497DEE1C8362CD452A22AD6FA64", hash_generated_method = "D1DBFA8CC2F488AB4F5AB91DD2783134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelector(int resID) {
        dsTaint.addTaint(resID);
        setSelector(getResources().getDrawable(resID));
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.453 -0400", hash_original_method = "AF217D83F5B526992017BCFB165071E1", hash_generated_method = "BBA8606D1D936903B6DC856AE1816F3B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.457 -0400", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "03429B4354ADAD0090160F59EF7EA12D")
    @DSModeled(DSC.SAFE)
    public Drawable getSelector() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.466 -0400", hash_original_method = "2F7C78E24D2DA521609D152C286646B5", hash_generated_method = "8D5664882320428CF011746A6CE2C62F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void keyPressed() {
        {
            boolean varDBE5D4BF2CCFB471B80269545EAA1B3B_1107442693 = (!isEnabled() || !isClickable());
        } //End collapsed parenthetic
        Drawable selector;
        selector = mSelector;
        Rect selectorRect;
        selectorRect = mSelectorRect;
        {
            boolean var07FA5EC4F6C5A1F1386E6BB4E68E466A_759435821 = (selector != null && (isFocused() || touchModeDrawsInPressedState())
                && !selectorRect.isEmpty());
            {
                View v;
                v = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    {
                        boolean varF2E1D044768D3B14172E86DA91C28BD1_1967203696 = (v.hasFocusable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.471 -0400", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "938804C238FC8A8D7AA271526001F70A")
    @DSModeled(DSC.SAFE)
    public void setScrollIndicators(View up, View down) {
        dsTaint.addTaint(down.dsTaint);
        dsTaint.addTaint(up.dsTaint);
        // ---------- Original Method ----------
        //mScrollUp = up;
        //mScrollDown = down;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.475 -0400", hash_original_method = "80EC646A43ECE5B1A4600CE8EDDA24B3", hash_generated_method = "B38A6CAB2442F8A59211A87664F7050E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void updateSelectorState() {
        {
            {
                boolean var1EC35265200A237347BA89EC9F7CAA85_1366586228 = (shouldShowSelector());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.478 -0400", hash_original_method = "5700D7A450170541F2788B92612441B3", hash_generated_method = "BE2E0DAA4F1B9A3E2F7D52B4FE053A88")
    @DSModeled(DSC.SAFE)
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateSelectorState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.484 -0400", hash_original_method = "1ED981B25374988410BBF6BB9A2499BB", hash_generated_method = "EAE7CC455ED7240623C0C7047EE9C12C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_563197896 = (super.onCreateDrawableState(extraSpace));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.489 -0400", hash_original_method = "A6B05685C2044FBFF5332C34549C9055", hash_generated_method = "D44EE992ED8EEDE911B560059864288B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean verifyDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        boolean var31983995A7CC0B4FFFDA846AE3697AC5_1112976091 = (mSelector == dr || super.verifyDrawable(dr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSelector == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.494 -0400", hash_original_method = "7ED40C7CE5B566B3E07F33E9D37CCA58", hash_generated_method = "BFFC225CA2A1E186F1C88A9F24D455F7")
    @DSModeled(DSC.SAFE)
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mSelector.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mSelector != null) mSelector.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.498 -0400", hash_original_method = "0EB97D149DFA0037A8214EEEE413FBAC", hash_generated_method = "B45C0AD0816F23BB15170FE6503DC916")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.506 -0400", hash_original_method = "91FA19273AD6EF1E2E7A8FCA605608DC", hash_generated_method = "496A039A1314503C49ACFF619D6F645D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.515 -0400", hash_original_method = "F46E1D5E69E9A7961CEAA1CC31FCC74A", hash_generated_method = "B4A2E3DB7794AA21F90C17CFB079B9B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        int touchMode;
        boolean var49D8D6F90114322BA24D8547EE3F7B5B_439839618 = (isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.520 -0400", hash_original_method = "5DA1B21EB8CB635B0040E7A9E537D496", hash_generated_method = "5F8CE658A6DF2EB6EBF19CFC5E6D97C3")
    @DSModeled(DSC.SAFE)
     ContextMenuInfo createContextMenuInfo(View view, int position, long id) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(id);
        dsTaint.addTaint(view.dsTaint);
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AdapterContextMenuInfo(view, position, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.526 -0400", hash_original_method = "5D95BDE73AAD1EC9BDE83FD3189DFC34", hash_generated_method = "343862D25562AE83CA71077C3C5FDE82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(longPressId);
        dsTaint.addTaint(longPressPosition);
        {
            {
                boolean var00E98D05004FD0330F18AA64B0748865_864254685 = (mChoiceActionMode == null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.529 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "772585C1AE35B7A1E276B43333291E1F")
    @DSModeled(DSC.SAFE)
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
        return (ContextMenuInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContextMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.535 -0400", hash_original_method = "720F76E8125C4C6521A83756BA0DD98B", hash_generated_method = "AFC74F0822D597A5609F978276A1E940")
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
                boolean var8897B192E808AB3EDB293923745D2D74_659585076 = (super.showContextMenuForChild(AbsListView.this));
            } //End block
        } //End block
        boolean varE458CA81039B0A7729D96AA8ED00D0B8_1952436946 = (super.showContextMenu(x, y, metaState));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.552 -0400", hash_original_method = "13B8C0CF7E224AA8E52D13CB23050F48", hash_generated_method = "E895DEB3C4F59C799D8214338F8B2B1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.556 -0400", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "D9C658CAAA9C82875D8A0176E0702827")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.563 -0400", hash_original_method = "DD8448F1B5F23CC0AD3E4D53FFC7D294", hash_generated_method = "7B6210E995D3B71D42CF93465DAAA71C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_565468297 = (!isEnabled());
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD23167BEA6670E541F842804D07343DD_656363219 = (isClickable() && isPressed() &&
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
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1468214214 = (super.onKeyUp(keyCode, event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.566 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "DF9F8748422E25A565E9D40F1B78D629")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        dsTaint.addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.572 -0400", hash_original_method = "C5D265B49C06947929C542FAD6DD4910", hash_generated_method = "41C1ACBB534E9E20BDD9F3C6377D2AB9")
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
                    boolean var02E23769C3E76AF1DC2C1CE956107022_1195967504 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_646096977 = (frame.contains(x, y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.580 -0400", hash_original_method = "0CE0E010C97C81E4AEC085897948D819", hash_generated_method = "4BE2AEBD2A7F5E511F04AF76A6758356")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long pointToRowId(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        int position;
        position = pointToPosition(x, y);
        {
            long varD18EE374A3F0927116BA59F2A9A03256_625395707 = (mAdapter.getItemId(position));
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //int position = pointToPosition(x, y);
        //if (position >= 0) {
            //return mAdapter.getItemId(position);
        //}
        //return INVALID_ROW_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.586 -0400", hash_original_method = "5EE86ADCFB65EEBAD1CBAFF86BFF869E", hash_generated_method = "04E2DA7E354B1F6FD1F6D20F1D359CCF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.614 -0400", hash_original_method = "24BFB982D66DDF27FDD0EB3AFC04A401", hash_generated_method = "A16B6018FBAF06ABB204734EDA3D5F76")
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
                    boolean var3B6B3092E9AEF7EFB8F7DB7C1090C559_223952722 = ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) == 0 &&
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
                            boolean var879507118E22A9A52AEA797A263AF84E_938894868 = (Math.abs(mOverscrollDistance) == Math.abs(mScrollY));
                            {
                                {
                                    mVelocityTracker.clear();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        int overscrollMode;
                        overscrollMode = getOverScrollMode();
                        {
                            boolean varAE1D066723B1EA15FA5C10A14D662F56_1400392945 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                                (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                        !contentFits()));
                            {
                                mDirection = 0;
                                mTouchMode = TOUCH_MODE_OVERSCROLL;
                                {
                                    mEdgeGlowTop.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varA87047F469C00113B6AE83492D7AB59C_1408844768 = (!mEdgeGlowBottom.isFinished());
                                        {
                                            mEdgeGlowBottom.onRelease();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    mEdgeGlowBottom.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varF30E150A7784B932CC0A99DAB3E3524A_49571836 = (!mEdgeGlowTop.isFinished());
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
                        boolean varA17BFA05D97ECE222863450A9B7218E6_1005178128 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                    !contentFits()));
                        {
                            {
                                mEdgeGlowTop.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var352E8E7760F8F011E79FB28EFE62DA73_1674309712 = (!mEdgeGlowBottom.isFinished());
                                    {
                                        mEdgeGlowBottom.onRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                mEdgeGlowBottom.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var530787B3C000358ED8C3E02B71DC0120_467550401 = (!mEdgeGlowTop.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.631 -0400", hash_original_method = "6F0203AFDEF2DCB43412C3F5E7A63F8C", hash_generated_method = "5887859069BE7AA2B9B62AEA59FA8F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTouchModeChanged(boolean isInTouchMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(isInTouchMode);
        {
            hideSelector();
            {
                boolean var18FDA06F2E4C20DCFBA70CFDB1F209F6_1971900212 = (getHeight() > 0 && getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.686 -0400", hash_original_method = "EC498F7AA9A002C93696F04D5F90A9F2", hash_generated_method = "BB23E594A05E29D65C21540FEEF27836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_2127063323 = (!isEnabled());
            {
                boolean var78B3B137E9725C8407DD55321B456099_23599421 = (isClickable() || isLongClickable());
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
                        boolean varD00D6114E840F55D6764F4976AFF0726_1311932621 = ((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0)
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
                boolean var10762BA5807EC5420815666D17984CE3_1235486380 = (performButtonActionOnTouchDown(ev));
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
            final View child;
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
                boolean var645943845E190A2FFA4FE7562EA898F8_1045860756 = (child != null && !child.hasFocusable() && inList);
                {
                    {
                        child.setPressed(false);
                    } //End block
                    {
                        mPerformClick = new PerformClick();
                    } //End block
                    final AbsListView.PerformClick performClick;
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
                            boolean varAD4E45D7D3DB8FFF6E14B37863D65B2D_902529029 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
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
                                @Override
                                public void run() {
                                    mTouchMode = TOUCH_MODE_REST;
                                    child.setPressed(false);
                                    setPressed(false);
                                    if (!mDataChanged) {
                                        performClick.run();
                                    }
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
                        boolean var523699F24A476A31015FCD9CC5BA98D8_1902239850 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
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
                    boolean varE3D06501EDBEFC68EB729C2818A34655_407429017 = (mFirstPosition == 0 && firstChildTop >= contentTop &&
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
                            boolean varD48B4459D536B53F6277D9F8CEC82F89_1843091715 = (Math.abs(initialVelocity) > mMinimumVelocity &&
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
                boolean varA56DF990188ABEF5AF3A9E103B5F2778_1794096670 = (Math.abs(initialVelocity) > mMinimumVelocity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.708 -0400", hash_original_method = "3A1744A3CB770F6FD9FFEB222E666622", hash_generated_method = "8085DB324A9E7B7F04637DAF273798CC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.715 -0400", hash_original_method = "09132BF5E477A2B233231E384E8A2F27", hash_generated_method = "6237F55441FABD915C3F80D64D2F2707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_653260409 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1816037921 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float vscroll;
                            vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                int delta;
                                delta = (int) (vscroll * getVerticalScrollFactor());
                                {
                                    boolean var5104A1C3A4166DC9AEBE0F45BFBBFDA2_1999000392 = (!trackMotionScroll(delta, delta));
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_798565582 = (super.onGenericMotionEvent(event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.727 -0400", hash_original_method = "F146D016CF32B873211A043EDB782604", hash_generated_method = "D9E498B469DD083A890902CAF35E75D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        super.draw(canvas);
        {
            int scrollY;
            scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_907239756 = (!mEdgeGlowTop.isFinished());
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
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_1430014127 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_335964554 = (!mEdgeGlowBottom.isFinished());
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
                        boolean var61CCF9557D478E1494862B3636E22888_98025278 = (mEdgeGlowBottom.draw(canvas));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.735 -0400", hash_original_method = "9FFFDAFD9442A3DE6BE69946897AC2B3", hash_generated_method = "B6637F314197B5BA1C6218FF4FCFADA8")
    @DSModeled(DSC.SAFE)
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding) {
        dsTaint.addTaint(leftPadding);
        dsTaint.addTaint(rightPadding);
        // ---------- Original Method ----------
        //mGlowPaddingLeft = leftPadding;
        //mGlowPaddingRight = rightPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.738 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "43200DD00A758A81245813B01E7050CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.740 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "154B8421283BEBB50C613A81D4F65445")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.743 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "722D9035C242C77366688C9524CCD357")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.748 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "2B136DF901568B223FCA9653C4C29759")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.762 -0400", hash_original_method = "BEACBA96FA37C833811279893053B3A1", hash_generated_method = "91285F0F5A969BFAC797E10B7FB7567D")
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
                boolean varBEAADC7EDD4EC70730C4344D280FA313_43680374 = (startScrollIfNeeded(y));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.770 -0400", hash_original_method = "C5DD3809C32C06AD527DF2275274EBCF", hash_generated_method = "34F9C9E6A6792370E0BBAD222CBF8DFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.776 -0400", hash_original_method = "7406EAB31F4F45208F8FFDB2641D9148", hash_generated_method = "CEFCD712FA15A46B675D0DA7FEAD40FE")
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
                    boolean var2E8FCA4FD70E922109B068B9683F621A_456165509 = (adapter.isEnabled(firstPosition + i));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.784 -0400", hash_original_method = "53B60DC92C627A12BA76D6AAFD79D448", hash_generated_method = "03DAB3FED79A51B05606A1F2BAA16B3F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.789 -0400", hash_original_method = "09656A4DFD81148F85DAB6B80BBEDF83", hash_generated_method = "1C84FCDB19983FF246BBB8C984C64B54")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.793 -0400", hash_original_method = "0A97F6C2B71DEE1A9A851FDFBE6F2171", hash_generated_method = "E53366720EEF67A8DF1B39028BB78EBE")
    @DSModeled(DSC.SAFE)
    public void setVelocityScale(float scale) {
        dsTaint.addTaint(scale);
        // ---------- Original Method ----------
        //mVelocityScale = scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.796 -0400", hash_original_method = "5ADECEDEBCB45348FEE18FEA2660C669", hash_generated_method = "1C3B5C4AD3DDBAA62DFBD9A2745FC9D7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.801 -0400", hash_original_method = "8931967DEF21C4BF02F7EE5F6DA25484", hash_generated_method = "834A9349851644D12EE664318E9CAA31")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.811 -0400", hash_original_method = "481FD979A7BEB05C5D5FED69D6209380", hash_generated_method = "2F4A92958E67B8D95EFBF4D163ECBDC2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.814 -0400", hash_original_method = "D55175FA7A4D56B1E1633A69B89BF26C", hash_generated_method = "A7D2251842529225191FEE163FDA0905")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.829 -0400", hash_original_method = "F38F4C8B27D75B9B07425BD626A4F57B", hash_generated_method = "20F6AE0689DCEDB0F5EB04B205426315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void smoothScrollBy(int distance, int duration) {
        dsTaint.addTaint(distance);
        dsTaint.addTaint(duration);
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
            boolean varE771752E61AAE94EE838BEB839D51E29_2119398162 = (distance == 0 || mItemCount == 0 || childCount == 0 ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.847 -0400", hash_original_method = "C17AB5094757737D3C9F6E76AFA310E4", hash_generated_method = "FD863C5CC824BAC1DEC91341F84610AD")
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
                    boolean var18BDB2D3799631890650FD697075D5F9_309668421 = (child.getGlobalVisibleRect(visibleRect));
                    {
                        int childRectArea;
                        childRectArea = child.getWidth() * child.getHeight();
                        int visibleRectArea;
                        visibleRectArea = visibleRect.width() * visibleRect.height();
                        float visibleArea;
                        visibleArea = (visibleRectArea / (float) childRectArea);
                        float visibleThreshold;
                        visibleThreshold = 0.75f;
                        {
                            ++index;
                        } //End block
                        {
                            --index;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), index + position)));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.856 -0400", hash_original_method = "81BA0C283B501CA4B76891C73CF6304F", hash_generated_method = "8C6A47691AD2825CF47D3A0D9D87E381")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.858 -0400", hash_original_method = "5EE1F7DCF1506371E8A50F14184A0F0B", hash_generated_method = "3765A6DD8E2C22A1CF99FA0644F58121")
    @DSModeled(DSC.SAFE)
    private void clearScrollingCache() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.906 -0400", hash_original_method = "A42371BB3F2D334094B7131C15A0F3E8", hash_generated_method = "58AF5B65A2250B40CD0DEA182FA22051")
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
                        boolean varEA5CC9EA6E04B02875DA6B296CDA3DF6_1585895773 = (child.getBottom() >= top);
                        {
                            count++;
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
                        boolean var0C9792EB8E72B1E8C3A203B5FF9D7EBC_368406745 = (child.getTop() <= bottom);
                        {
                            start = i;
                            count++;
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
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_754855189 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(mSelectedPosition, getChildAt(childIndex));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int childIndex;
            childIndex = mSelectorPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_1309787798 = (childIndex >= 0 && childIndex < getChildCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.939 -0400", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "055691AD274F1C61808D008EDF2A5EE6")
    @DSModeled(DSC.SAFE)
     int getHeaderViewsCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.947 -0400", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "F0AF59F493122337B97FA5981B986DC1")
    @DSModeled(DSC.SAFE)
     int getFooterViewsCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    abstract void fillGap(boolean down);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.952 -0400", hash_original_method = "01CAE4EB89DA7F2FB8FB8C551B8C7558", hash_generated_method = "C1B62437F2092924E7628E380934985B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.955 -0400", hash_original_method = "3C42E05D1FE66CE321CE689DCD7609AF", hash_generated_method = "F6BE5E268C6A3399C200C2D701B0E56B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.959 -0400", hash_original_method = "620BFFA3FACC4E59D7B8719ED5062EB2", hash_generated_method = "30DB51B25D71CAE88BC6692ED8B9512E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.963 -0400", hash_original_method = "48746A94CCDD3AA210B8334DFA5415FB", hash_generated_method = "044634FA697086B7454D3940A7F501C6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.967 -0400", hash_original_method = "DCA216018FB5348F17E51D7322AEEFD4", hash_generated_method = "1CB7FD79240F7A2113C76BC6AE807A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean resurrectSelectionIfNeeded() {
        {
            boolean varA94BDD63AC24FE4C16F032614F7038B6_392534358 = (mSelectedPosition < 0 && resurrectSelection());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.979 -0400", hash_original_method = "46DC118C185645539DC69AE3B021DB61", hash_generated_method = "F8023C2ABC4F6C71B83C13A1251B5C6B")
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
            boolean var62F8C3AE45B38B2DECAE10F01A4F320D_264959797 = (selectedPos >= firstPosition && selectedPos <= getLastVisiblePosition());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:44.989 -0400", hash_original_method = "7A1DBAB399A1231E28D6D54E2346B36F", hash_generated_method = "DDE05E7ECF5ADE8502BA4F2157D649EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void confirmCheckedPositionsById() {
        mCheckStates.clear();
        boolean checkedCountChanged;
        checkedCountChanged = false;
        {
            int checkedIndex;
            checkedIndex = 0;
            boolean var345B3951F4A2E6483B2D033F362E91E2_1642015559 = (checkedIndex < mCheckedIdStates.size());
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
                        checkedIndex--;
                        mCheckedItemCount--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.007 -0400", hash_original_method = "988EE7458DA5CAE45D4D8EEE7B510700", hash_generated_method = "5924F6CC04FC27EFF7EB3BB032C36A8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void handleDataChanged() {
        int count;
        count = mItemCount;
        int lastHandledItemCount;
        lastHandledItemCount = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
        {
            boolean var1BF5A9488574E2FA74D8264040FC0893_1518195781 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter != null && mAdapter.hasStableIds());
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
                    boolean varAFC77293C02F773029137FDE42129C14_102185533 = (isInTouchMode());
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
                                    boolean varE6F64662C76820CEAED04C173D145196_2060488521 = (mSyncHeight == getHeight());
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
                boolean var12100596BD466B0E4730696B6E3F9C25_621747200 = (!isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.015 -0400", hash_original_method = "C562B15A4430BC762CC4B771E60D70AF", hash_generated_method = "CEF126A5E02CE75E19C382CDB95DAC59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hint);
        super.onDisplayHint(hint);
        //Begin case INVISIBLE 
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_1262629412 = (mPopup != null && mPopup.isShowing());
            {
                dismissPopup();
            } //End block
        } //End collapsed parenthetic
        //End case INVISIBLE 
        //Begin case VISIBLE 
        {
            boolean var003C494DA1AA746A5D5A0908F950DF91_1407212470 = (mFiltered && mPopup != null && !mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.018 -0400", hash_original_method = "86B533D40AC94020BA9211F436996CAA", hash_generated_method = "60ED3D340DD8618B8173B8E50184B4DA")
    @DSModeled(DSC.SAFE)
    private void dismissPopup() {
        {
            mPopup.dismiss();
        } //End block
        // ---------- Original Method ----------
        //if (mPopup != null) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.021 -0400", hash_original_method = "6C07C7201C3F8F7AE411CAF5368DC26F", hash_generated_method = "1DE6FAE67AF8AF08F2DFA31878A1E18B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showPopup() {
        {
            boolean varEC31A88682EDD8797910B3EFA4C60835_1687255479 = (getWindowVisibility() == View.VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.024 -0400", hash_original_method = "84FE8B62D6AD62C84F51A39D7331FBA6", hash_generated_method = "D26B3A23206F5D0522CEB9B5E231895F")
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
            boolean varE8127168ED545283F844FC09586AD49B_17606958 = (!mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.027 -0400", hash_original_method = "564DB73982CD20F7720FD8D707AB5026", hash_generated_method = "A81D7BA3497D3E18ADF15D23D1E0311C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.030 -0400", hash_original_method = "E53786E832898AFD8F3D1858C7ADFC0B", hash_generated_method = "57C9A234B2259C052379ACEE412B6F3F")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isInFilterMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.039 -0400", hash_original_method = "E9CFCD950A6A0EAC13FE4A21D8302AE8", hash_generated_method = "AB2DC6528244FCAA236ECFDB0B17E385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean sendToTextFilter(int keyCode, int count, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var8E508D5098333C3DF9E9AC1534499251_1240443457 = (!acceptFilter());
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
            boolean var39DB415F3D8E94BAF1BCAFDEBBF4C6EF_233475011 = (mFiltered && mPopup != null && mPopup.isShowing());
            {
                {
                    boolean varF129D97EB58BBADBA4875AF25E33B341_1769963671 = (event.getAction() == KeyEvent.ACTION_DOWN
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
                        boolean varF38DB653E52CB4D0E4EDFCBA5E49A3DF_2131042011 = (event.getAction() == KeyEvent.ACTION_UP
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
                boolean var6A7BE4CA28243E587EACA0203B08BD67_144056603 = (forwardEvent.getRepeatCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.047 -0400", hash_original_method = "D11D50B93967E008BF298EC93C5B84EB", hash_generated_method = "18C4A6DBFFFE840B459556630F8D1C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outAttrs.dsTaint);
        {
            boolean var402F49E4B8F4D68C8A96D34BD4EE8DD9_1511400070 = (isTextFilterEnabled());
            {
                createTextFilter(false);
                {
                    mDefInputConnection = new BaseInputConnection(this, false);
                    mPublicInputConnection = new InputConnectionWrapper(
                        mTextFilter.onCreateInputConnection(outAttrs), true) {
                    @Override
                    public boolean reportFullscreenMode(boolean enabled) {
                        return mDefInputConnection.reportFullscreenMode(enabled);
                    }
                    @Override
                    public boolean performEditorAction(int editorAction) {
                        if (editorAction == EditorInfo.IME_ACTION_DONE) {
                            InputMethodManager imm = (InputMethodManager)
                                    getContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
                            if (imm != null) {
                                imm.hideSoftInputFromWindow(getWindowToken(), 0);
                            }
                            return true;
                        }
                        return false;
                    }
                    @Override
                    public boolean sendKeyEvent(KeyEvent event) {
                        return mDefInputConnection.sendKeyEvent(event);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.052 -0400", hash_original_method = "44BA525DE8B7DBBB72825E23CC2BB1F6", hash_generated_method = "F195BE14A8EBE5A260069153C15DFE4D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean checkInputConnectionProxy(View view) {
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return view == mTextFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.067 -0400", hash_original_method = "F3682B44558BD825C5F832A45B68670A", hash_generated_method = "AEE95DE51C62BE8D8717B8B2C6B3EDD0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.078 -0400", hash_original_method = "32E21A2D6552DD3A6789EF27520CDF5A", hash_generated_method = "0B246B5B4EF847DD1301CACF551E6C07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearTextFilter() {
        {
            mTextFilter.setText("");
            mFiltered = false;
            {
                boolean var8B43E06806BC96AC7F4A8D7A0BE622AC_799652887 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.082 -0400", hash_original_method = "65ACBB1BC8C4B28B951746B0589E48B4", hash_generated_method = "FF21A1291E509EA2DB7BC51C95DEF8F2")
    @DSModeled(DSC.SAFE)
    public boolean hasTextFilter() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.094 -0400", hash_original_method = "11A5FC28E28C3DFE2639108D4141B162", hash_generated_method = "BD66CDB8AA6961ED8B4459974BA3FBDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_1833312215 = (isShown());
            {
                {
                    boolean varDA5B3CFD94DC14795F693BACD8E64777_1463097413 = (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden);
                    {
                        showPopup();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varF98F363210E79C98D906F19BE26A0AAC_785198631 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.105 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "793050964D08C1174D57F8F1A6A4BBD2")
    @DSModeled(DSC.SAFE)
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        dsTaint.addTaint(after);
        dsTaint.addTaint(s);
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.112 -0400", hash_original_method = "971B961D673D514356DF6D21C3AC22CE", hash_generated_method = "69F851CF3B403B9C4012EA2B3257139B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s);
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        dsTaint.addTaint(before);
        {
            boolean varCB324F139DAF9E78619086072BD20A85_34352123 = (mPopup != null && isTextFilterEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.120 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "70C7C3A423EAFEF222D7D6A3D8B2625A")
    @DSModeled(DSC.SAFE)
    public void afterTextChanged(Editable s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.124 -0400", hash_original_method = "5FB3F90813AE5A23A23BDBAA76A97056", hash_generated_method = "78D139F6DD38C5C25282DCD00B185B8A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.127 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "29644007F7CFEED57C9F56BE3742304B")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.132 -0400", hash_original_method = "D7DCCEE0C1D1153E18E019649E6F2D80", hash_generated_method = "13430C26253CB907986C27C9776FDA49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        LayoutParams varE6715DFC3A5359CE2D0ED893D38A28C7_1770325693 = (new AbsListView.LayoutParams(getContext(), attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AbsListView.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.134 -0400", hash_original_method = "7C8047E4E7C938CA1D7BE889EE17D059", hash_generated_method = "892C754169CB63B03FF20066A09908F6")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        dsTaint.addTaint(p.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return p instanceof AbsListView.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.138 -0400", hash_original_method = "1385B81082A7F6F42283DE7C72A352C9", hash_generated_method = "DF8ED102269D68B854C93C1132E24A46")
    @DSModeled(DSC.SAFE)
    public void setTranscriptMode(int mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //mTranscriptMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.142 -0400", hash_original_method = "EADF20E51473F5B82FC89B630E89BCE7", hash_generated_method = "D37E78995FA4F11F4FA55C946DCC3E1F")
    @DSModeled(DSC.SAFE)
    public int getTranscriptMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTranscriptMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.145 -0400", hash_original_method = "3A641BF6273957C36676C590B4CC3444", hash_generated_method = "A9D3429C25AF1D47D97528394125FE0D")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSolidColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.149 -0400", hash_original_method = "B2E4EFE21735BA4D4CA20D9D2323DF5E", hash_generated_method = "9FB13E0D2C00DA9A6ECAD14AD13035FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.153 -0400", hash_original_method = "75945C93CA5A574EC2A11912410CB0E0", hash_generated_method = "4285EBFA8254DBFBD3B60F6F9C8D3AF4")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.157 -0400", hash_original_method = "012761D54D3EA9FE8C837ED35E18F05A", hash_generated_method = "BD2E9611EEF6BC1F6F485B65FF0F73F8")
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
                    boolean var248D80F0B10623F58D6026D84DE5E671_1853336780 = (lp != null && mRecycler.shouldRecycleViewType(lp.viewType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.166 -0400", hash_original_method = "63F1E187EEAD4E39E30E7C6F8BC8B8CA", hash_generated_method = "5AE9738B75E57115743EAAF2EC19A21D")
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
                boolean var1B9DDC99DC36041733636881A6D6F2A7_2065420454 = (!checkScrap(scrap));
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
                        boolean var152726F7FF3AB1D0325523449C0C26DB_380567728 = (!checkScrap(scraps[i]));
                        result = false;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.176 -0400", hash_original_method = "256B8EB3FFECB4266216E5C3F84B8A1E", hash_generated_method = "FCA56BA3C3C38FC5509637C29CAD6471")
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
                    boolean varC649C41AA848C000C1488527EB85E854_374683479 = (view.getParent() != null);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var6F0CAFE49F301E66083476B8CB251F7E_2005044351 = (indexOfChild(view) >= 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.179 -0400", hash_original_method = "D0C284A2FBB36CA42A8E7F826DDB725F", hash_generated_method = "043D56F3C1B900C730A078E73A73A041")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.184 -0400", hash_original_method = "C1CCFF5C419F753BE2BE6DDA2ACFD3CA", hash_generated_method = "19F2F8E00BE9A0107A05DCB82339E1A8")
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
                boolean var45C20E8BCA952BA88AD2862513B06923_269882277 = (fcNew.equals(fcOld));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.187 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "24E63AA5C0ED0E22149D496EB356AF76")
    @DSModeled(DSC.SAFE)
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.191 -0400", hash_original_method = "28DEF371BA940ACF691CB065E03F3A69", hash_generated_method = "9832DF655552F0641267B817F9395C67")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.193 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "FC013EA7820589FBCF2A5C0582DC8541")
    @DSModeled(DSC.SAFE)
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.196 -0400", hash_original_method = "A10CF4C818C12AB96D88DAC8638A238F", hash_generated_method = "859A1FF8298FBCB699FCF0196FCC8B24")
    @DSModeled(DSC.SAFE)
    public void setRecyclerListener(RecyclerListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mRecycler.mRecyclerListener = listener;
        // ---------- Original Method ----------
        //mRecycler.mRecyclerListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.198 -0400", hash_original_method = "AE43FD0671E8B91C49C719592288E3E2", hash_generated_method = "6EAE2AA8C7AD3423F7AA775DC155BE9F")
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.201 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.204 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.206 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "BBD854AA7A117C86D9FBF897ADE36FE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.210 -0400", hash_original_method = "9305A5F2B13D160808C7DFC7D0F396F1", hash_generated_method = "CCE13F2ED25CFA67B89721DF304E4CDF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.214 -0400", hash_original_method = "3B46B91B7C73B4C6AC70E6F2F8A95E0E", hash_generated_method = "2920885291704898EEC526A640D066D2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.218 -0400", hash_original_method = "28CD4AAEE48E548227BD32788E936C86", hash_generated_method = "523FD12D097896DA57FB9E645CD5300B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var48C38BDCB5EBD69675A62C2D31FCBF6E_1166982849 = ("AbsListView.SavedState{"
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

        
    }


    
    private class WindowRunnnable {
        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.222 -0400", hash_original_method = "CFEEFBABEEA41C591AAAAD229F2BB0E7", hash_generated_method = "BB24A447ABBD4ACE12294B24CC279DA1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
            // ---------- Original Method ----------
            //mOriginalAttachCount = getWindowAttachCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.224 -0400", hash_original_method = "A209657341959E6933B2954972D0CEE9", hash_generated_method = "A3E28F82AE04C5F2C52023A56E4C015F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean sameWindow() {
            boolean var8C6821449255A008A670CF7CA64A93AB_799465678 = (hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.229 -0400", hash_original_method = "A958048F64A683459F522CCD37FE7D11", hash_generated_method = "0A233182944D8BE9A85FE54BA4F17EDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            ListAdapter adapter;
            adapter = mAdapter;
            int motionPosition;
            motionPosition = mClickMotionPosition;
            {
                boolean varB13BDDA7CDF6AF0E3819BBDA363D7ED8_51165870 = (adapter != null && mItemCount > 0 &&
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.245 -0400", hash_original_method = "6FF0C5D4F5CC73F85A2BCE7243EBBA32", hash_generated_method = "27AD0FE1A79F422C3548474F353387E0")
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
                    boolean var67E4CE6BEABC0BB93EA224EBEDE2210E_1279285919 = (sameWindow() && !mDataChanged);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.251 -0400", hash_original_method = "A3D23752A2B3700EB42478E66A11709C", hash_generated_method = "CD6EB6B350F3DFE9D4D1D27486C198E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                boolean varA166426E2772E5B5C6CC900A627665FC_1255106209 = (isPressed() && mSelectedPosition >= 0);
                {
                    int index;
                    index = mSelectedPosition - mFirstPosition;
                    View v;
                    v = getChildAt(index);
                    {
                        boolean handled;
                        handled = false;
                        {
                            boolean var15017B83B2D3E709399CA037CED2AFF9_47680087 = (sameWindow());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.258 -0400", hash_original_method = "BD1CF9A4027AFE49AD3D9DDE12B9EB2A", hash_generated_method = "81F55AC9433A9B37A9CA246AFD9E7564")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                mTouchMode = TOUCH_MODE_TAP;
                View child;
                child = getChildAt(mMotionPosition - mFirstPosition);
                {
                    boolean varEFC9B5F6E2423C87CACF29EB92D1C650_1743727428 = (child != null && !child.hasFocusable());
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.267 -0400", hash_original_method = "794342E61B0741E0D2D0BA9CCE24C214", hash_generated_method = "D437E30E79A0A26E124E07977572D87A")
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
                    boolean varD670105D084B3EC9810CA2EF9B5779A0_1991991611 = (Math.abs(yvel) >= mMinimumVelocity
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
        private static final int FLYWHEEL_TIMEOUT = 40;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.270 -0400", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "1C5B621F79B2764B443D85B129A2C803")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FlingRunnable() {
            mScroller = new OverScroller(getContext());
            // ---------- Original Method ----------
            //mScroller = new OverScroller(getContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.275 -0400", hash_original_method = "03D4FA54CBC93A7E96ECD2486CBEE621", hash_generated_method = "2B7E079B38A9A0328B9C1F33D49546D6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.279 -0400", hash_original_method = "7C6D2E7D970FED93FF739DAAC6CC80C2", hash_generated_method = "EEC22F60AA11A28CA1B0192EBEB232E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startSpringback() {
            {
                boolean var059811778A6969FDC20EDCB87A1E9DD0_594255761 = (mScroller.springBack(0, mScrollY, 0, 0, 0, 0));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.282 -0400", hash_original_method = "57B70ADF06D2A10A257A1E350228503E", hash_generated_method = "7AC827FE2746F247F7556495DFF4294A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.288 -0400", hash_original_method = "F0692CC07A14DB0F1E581AFC2CDF3E90", hash_generated_method = "15EDBFA8FB7D25FDC049695E16B23058")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void edgeReached(int delta) {
            dsTaint.addTaint(delta);
            mScroller.notifyVerticalEdgeReached(mScrollY, 0, mOverflingDistance);
            int overscrollMode;
            overscrollMode = getOverScrollMode();
            {
                boolean var38522C672435F8008EBC1E11034D946B_1709540696 = (overscrollMode == OVER_SCROLL_ALWAYS ||
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.292 -0400", hash_original_method = "16B3910BA949F2F73CCA1E8DA35CE0FF", hash_generated_method = "845F601788DB50FE7D42426719906990")
        @DSModeled(DSC.SAFE)
         void startScroll(int distance, int duration) {
            dsTaint.addTaint(distance);
            dsTaint.addTaint(duration);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.294 -0400", hash_original_method = "EC718B25FAE44F694CA340373A32BE29", hash_generated_method = "588FB0CEEC778B8D38EB82AD83CA5360")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.297 -0400", hash_original_method = "5D655CDBCE73395DC3C27E060B822A32", hash_generated_method = "B24B36911BFB873DE726EC36EC8BFF4D")
        @DSModeled(DSC.SAFE)
         void flywheelTouch() {
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
            // ---------- Original Method ----------
            //postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.310 -0400", hash_original_method = "4DD83535EAA65B570F4DB1073D459909", hash_generated_method = "B3875DEBA68CAB7A02B89016ED34EEE7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            //Begin case default 
            endFling();
            //End case default 
            //Begin case TOUCH_MODE_SCROLL 
            {
                boolean var8C879AC9111FA456E4D5E672C40ED1D8_581885147 = (mScroller.isFinished());
            } //End collapsed parenthetic
            //End case TOUCH_MODE_SCROLL 
            //Begin case TOUCH_MODE_FLING 
            {
                {
                    layoutChildren();
                } //End block
                {
                    boolean varF1747C254517DB9417BE3B51D681F089_172462738 = (mItemCount == 0 || getChildCount() == 0);
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
                    boolean var0C92AC4985E057FF9B563A127E8C3B23_2106551249 = (scroller.computeScrollOffset());
                    {
                        int scrollY;
                        scrollY = mScrollY;
                        int currY;
                        currY = scroller.getCurrY();
                        int deltaY;
                        deltaY = currY - scrollY;
                        {
                            boolean var27491E7A6C26FA30763C389A29F73077_279094736 = (overScrollBy(0, deltaY, 0, scrollY, 0, 0,
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

        
    }


    
    class PositionScroller implements Runnable {
        private static final int SCROLL_DURATION = 400;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_UP_POS = 2;
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_OFFSET = 5;
        private int mMode;
        private int mTargetPos;
        private int mBoundPos;
        private int mLastSeenPos;
        private int mScrollDuration;
        private int mExtraScroll;
        private int mOffsetFromTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.317 -0400", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "558CDF465726341CE4B4E95BC52B9B64")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
            // ---------- Original Method ----------
            //mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.320 -0400", hash_original_method = "FDCD353E7B4C16B389C07FF98024D1F6", hash_generated_method = "049C0B098F1B55310A3CC1D25EAE6808")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.327 -0400", hash_original_method = "84EF03A180BC8A392D5F6234ABF1A7D7", hash_generated_method = "1C4DCABC4B65B8B572C0C10778A09A8F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.330 -0400", hash_original_method = "BE41DE2B3819156F24DD50B9D9C0C2E0", hash_generated_method = "0DB773A3E95F48243B13BC103C8B4297")
        @DSModeled(DSC.SAFE)
         void startWithOffset(int position, int offset) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(offset);
            startWithOffset(position, offset, SCROLL_DURATION);
            // ---------- Original Method ----------
            //startWithOffset(position, offset, SCROLL_DURATION);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.334 -0400", hash_original_method = "6B17946EC33D794252BA778D04AAD100", hash_generated_method = "A771F86C05F44E84E5AB624459715876")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.337 -0400", hash_original_method = "EE84C7B9935E89C7F265FE60CF403C46", hash_generated_method = "F66BC6D91F03A7F0DA45EA07CBD856FF")
        @DSModeled(DSC.SAFE)
         void stop() {
            removeCallbacks(this);
            // ---------- Original Method ----------
            //removeCallbacks(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.347 -0400", hash_original_method = "BF3ECE172F6D799B3639990958E45277", hash_generated_method = "401992C6AA25BF73B19B0E3B8820808D")
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

        
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.354 -0400", hash_original_method = "70826FE759108269AA8BACD409E1C863", hash_generated_method = "DB405082D9EC010DA03FDA2644BB6815")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.357 -0400", hash_original_method = "4570C5F375E9950A79093241C88AF34D", hash_generated_method = "163463F2B6FBA95783CB67C1DEC79A29")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.360 -0400", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "BA6BCDFE73371F37F04B4580724CF81E")
        @DSModeled(DSC.SAFE)
        public void setWrapped(MultiChoiceModeListener wrapped) {
            dsTaint.addTaint(wrapped.dsTaint);
            // ---------- Original Method ----------
            //mWrapped = wrapped;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.365 -0400", hash_original_method = "92496BA2B215F9BD39661C34B9C10361", hash_generated_method = "1B7A6A63C682C42ECE2A12FBD08BB458")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            {
                boolean varD6C93448152EF2C372CDE7A0E8CB7504_2056825254 = (mWrapped.onCreateActionMode(mode, menu));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.369 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "369317C9BDCCAC7831221C848A0C58F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            boolean var889963BD11CE1DC6E3538FA5CA769B04_1049820019 = (mWrapped.onPrepareActionMode(mode, menu));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mWrapped.onPrepareActionMode(mode, menu);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.372 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "488B0C287B54E8A0C28C8B048A83145D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            boolean varFD1FD09DE497AC204C6AFB08C6591DDB_11813698 = (mWrapped.onActionItemClicked(mode, item));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mWrapped.onActionItemClicked(mode, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.374 -0400", hash_original_method = "38D50D306A79D91BC9BAC512614B14E4", hash_generated_method = "194BF2D68DE138C482D26B73ECDC6611")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.377 -0400", hash_original_method = "54A7C456AE4C179767C141D1533A24F9", hash_generated_method = "4BD56AD9A4EDF5E35D9244195CCDCC1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(position);
            dsTaint.addTaint(id);
            dsTaint.addTaint(checked);
            dsTaint.addTaint(mode.dsTaint);
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            {
                boolean var9E354D1EAEB52E913322B0C21F0A7D1D_21345387 = (getCheckedItemCount() == 0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.380 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "27AA4F047E6B38797AD586ED7B1454BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(attrs.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.383 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "4E89BA887C1433BB59EDBB6A5307B13A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int w, int h) {
            super(w, h);
            dsTaint.addTaint(w);
            dsTaint.addTaint(h);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.385 -0400", hash_original_method = "CB5E57490495E3D022159C4744E426CF", hash_generated_method = "C2C3D5B45917B20599EDFF73DF7F99F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LayoutParams(int w, int h, int viewType) {
            super(w, h);
            dsTaint.addTaint(w);
            dsTaint.addTaint(viewType);
            dsTaint.addTaint(h);
            // ---------- Original Method ----------
            //this.viewType = viewType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.387 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "56865DF2AAA17BD60F7856200319F1B6")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.391 -0400", hash_original_method = "2027E38C638AFAF08EBC73DB2999B11D", hash_generated_method = "9D67E8468B0C02E8E80EA84A3F508C79")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.394 -0400", hash_original_method = "84FB41DBF94FAC74E383190ECD19AC3F", hash_generated_method = "87770040F2AD576FC52060DB52A3882A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.399 -0400", hash_original_method = "511AFE11A00C49C0B36C81F833AD1339", hash_generated_method = "4F01AE633DBF5B8D64D09DBEE5D18D93")
        @DSModeled(DSC.SAFE)
        public boolean shouldRecycleViewType(int viewType) {
            dsTaint.addTaint(viewType);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return viewType >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.402 -0400", hash_original_method = "D3A3C7CFD0DB416C40300347744B44D9", hash_generated_method = "63F1EFAEC6199074EE7443071355505A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.406 -0400", hash_original_method = "8EEC6DB7AE7CDFC4B2320C472F7412E6", hash_generated_method = "4637D98951F3B3EDBA3AA76934F52B58")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.411 -0400", hash_original_method = "6DDE0EAFBBDE35C2F4BC64D693E74936", hash_generated_method = "525951F1624BE74361DB767984A69F7A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.415 -0400", hash_original_method = "7C1BB02F0CFB7D7F7BDB0DC42C0788DA", hash_generated_method = "A482BF163D72AED608AC8004C47844C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         View getScrapView(int position) {
            dsTaint.addTaint(position);
            {
                View varA923EEA0464BA2DCF247B08DE4AB8E85_1370570096 = (retrieveFromScrap(mCurrentScrap, position));
            } //End block
            {
                int whichScrap;
                whichScrap = mAdapter.getItemViewType(position);
                {
                    View var06E35DD32C4D93E075CDF1EE9C79FA1E_1539339702 = (retrieveFromScrap(mScrapViews[whichScrap], position));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.420 -0400", hash_original_method = "ED120D0157D66531494A9FD53EAE380E", hash_generated_method = "ADEBF5F982020FF247B3EA60D22F3381")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void addScrapView(View scrap, int position) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(scrap.dsTaint);
            AbsListView.LayoutParams lp;
            lp = (AbsListView.LayoutParams) scrap.getLayoutParams();
            int viewType;
            viewType = lp.viewType;
            {
                boolean var78318F84F970183913C3A58475F2628A_1863492452 = (!shouldRecycleViewType(viewType));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.427 -0400", hash_original_method = "3138270AA2660474D2B7E99137A02556", hash_generated_method = "F38FEA06FAB4E93E6199B71C9BEF959C")
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
                            boolean var51E473BD444D9F2F14A7E3EC67387565_1176191278 = (!shouldRecycleViewType(whichScrap));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.432 -0400", hash_original_method = "EA58D1FE496277FE2ED85A93396A169A", hash_generated_method = "8CADE124F3D3490018B38D1A94C15BB0")
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
                    size--;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.436 -0400", hash_original_method = "3FD0A968FC7E2613466435C98B02B7BD", hash_generated_method = "72FE05871AE7ECB3B653CEF83D8157CA")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:26:45.443 -0400", hash_original_method = "BA10D81754F1A95A0F7C755DD4764D3B", hash_generated_method = "63E7DDB622FF007686A4A459181CD41A")
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
    
}


