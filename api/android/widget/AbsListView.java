package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.387 -0400", hash_original_field = "FDB445A6FE3D3AE5BF46B0E337AD4937", hash_generated_field = "383DDBE003D416456C310D4158C4CFB9")

    int mChoiceMode = CHOICE_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.387 -0400", hash_original_field = "3D0732796D8971C4EE44D7D21A3E57FC", hash_generated_field = "48C1F0333DFD0DC72046CFA915BFC8E8")

    ActionMode mChoiceActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.387 -0400", hash_original_field = "14B80F5AC98F0F6EA047E368DBDFB9E6", hash_generated_field = "8DB318A3968ACAA4E72C29D459103061")

    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.387 -0400", hash_original_field = "15A65D8079003A56299BBC3EC8F634A7", hash_generated_field = "69D140D043E457BD61D5B9F6552EF517")

    int mCheckedItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.387 -0400", hash_original_field = "FFDCDF85D0490AC0CCCFF2CB523F8053", hash_generated_field = "CA6CC91745E43EBBCA6C857FDAD05357")

    SparseBooleanArray mCheckStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "9B60E0D0F065913372A6ACFC5498034B", hash_generated_field = "869EB89A549CFEBFB16DD4FED9649B6E")

    LongSparseArray<Integer> mCheckedIdStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "4E9548BDDA1DC25FD9BD2651109B61A0", hash_generated_field = "D9E7894D012FFAF92CE958370EAAE107")

    int mLayoutMode = LAYOUT_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "BA07A3DE43E99CA12488218E7E590AA0", hash_generated_field = "386E575B164CBA38A9F16CB0F74210CE")

    private RemoteViewsAdapter mRemoteAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "A4A26F367FC0C1227F7A5E61B89ABBBE")

    private boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "3331386BB2D82834F199D617F558D297", hash_generated_field = "A1E757D1ECB75F11B7A5FD22CFD8D6DE")

    boolean mDrawSelectorOnTop = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "D697BABF55DFD739589D0F84316D9938", hash_generated_field = "FF4158F9C935D5CC585FE18F81632212")

    Drawable mSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "03D1E6E3F8B7161297631CBC27F2E39C", hash_generated_field = "15C7707915A6B0B74E44A43E1542C958")

    int mSelectorPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "E616CA52B8CBE0A879AD74D361065EF6", hash_generated_field = "C524FC1C3E6AAF765E2CAB633026E31B")

    Rect mSelectorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "850AAD212EF4F4A7E8993BB802A79E8B", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "EC383219D6D8A4B6B87A786F4327EE03", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "FA8EABBC9D79FB4F912796BE168AD76D", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "F2D6183DA068D77902D36BB38A7570E0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "63EC0412604CE1A7BE02B1C77E43E6CF", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "43539E3842DB97BCC325856D94133A8F", hash_generated_field = "05D43BB1A495A731310553613FE206DD")

    Rect mListPadding = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "D1D6B0DE36366002E2A19031D3776ED0", hash_generated_field = "F34547E4E9C4393B08D5498F65FC370A")

    int mWidthMeasureSpec = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.388 -0400", hash_original_field = "8A37B3642AE63312BB9AEE8EDA851905", hash_generated_field = "00AF12951227F69DA5FB3783B6D532DB")

    View mScrollUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "B3BBDA53E3217BD8FB4C3525F2C8FB8D", hash_generated_field = "045245010980799FDB6036E67E9F436F")

    View mScrollDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "3AA53ED1199B42ED017A1F3E2400A292", hash_generated_field = "6E445E4EED263A45A094087A50B7126E")

    boolean mCachingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "56FC3C5C26F1649CC65F1FB2A1EA9DC9", hash_generated_field = "0AB9D53170F11322593A4B241676E18D")

    boolean mCachingActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "981700988B7F4FB2FEF9A4D8DDC3B56E", hash_generated_field = "6516B57613A0784EC2DDB500ABA92556")

    int mMotionPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "CB13AD9208BD36E3C502183D21166D8E", hash_generated_field = "9D04282A1BDDC504BC19852147A5D64D")

    int mMotionViewOriginalTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "064676185859A1F3857E03A91BADBB72", hash_generated_field = "2086F63C3164AF1AA06DFC0C51452109")

    int mMotionViewNewTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "5518D15E5E059B7526448CC0900DCECE", hash_generated_field = "E9714F671BCE6666EDE234DD36661DA0")

    int mMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "E24F0E4927BC6420254A5B51253AB150", hash_generated_field = "BAC7C8FFD482868C2E281DB29DBFE06D")

    int mMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "3E0C99B6B345CE34A5565B62F1083D79", hash_generated_field = "7C51C810E963B7D188B47B8F49B7DDE4")

    int mTouchMode = TOUCH_MODE_REST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "048ECB2D11DDC21BDA8C31B82C3211AD", hash_generated_field = "C4455B3957BD1EE48827818491DAA168")

    int mLastY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "7FDF3596AB5C6361CE994F6A8201D88E", hash_generated_field = "1C8B3319825706CAEF653B7569131ADE")

    int mMotionCorrection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.389 -0400", hash_original_field = "55E8748CF9C4663AD1425AFFC03DE229", hash_generated_field = "6E948CA7630EFB6162DA2EBAA4208363")

    private FlingRunnable mFlingRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "B2332CA85B873A0B0263A4DD84BB9442", hash_generated_field = "3A7EBB83D687A969A9AA75982B56B68B")

    private PositionScroller mPositionScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "4D232D35AB2F2A91FDF0192889384336", hash_generated_field = "77BDF9079A717E33AEBAD612261D859E")

    int mSelectedTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "452AAACA6529C6DDC61AC74D560EC80F", hash_generated_field = "A2083A1B78272D6D26A8F8E0BA5E2327")

    boolean mStackFromBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "7FB4BC12E46C9E48428AFBC608C49853", hash_generated_field = "3BD9FEE95F32C4889FDFAAEB81585604")

    boolean mScrollingCacheEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "15797563431B975E4FF5A08BDEC264DA", hash_generated_field = "AB477B88BF820ABA168568369EF3F457")

    boolean mFastScrollEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "0970AE3033B8F8E13936EF3E29D48B2E", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "7E4C7D8A72122A6640DF0AA884C2245D")

    PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "722CD50A11B36E9DDDD2F9392836F175", hash_generated_field = "E12C98919B28D2782FD5E54CA9C7E663")

    EditText mTextFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "16D582D908E13FC506985FFCA54C3849", hash_generated_field = "99B5A44FD56940F18C75CE655B9A1668")

    private boolean mSmoothScrollbarEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "586CD8929678603BADF3EAE99555BE68", hash_generated_field = "10C9AD0517CE8D8A09913559356A8C56")

    private boolean mTextFilterEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "36C832B0627AFDF6338A4E9703CAD999", hash_generated_field = "E5AC0509E741D92E16D3D731D4E96C35")

    private boolean mFiltered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "2D90C7DCE7997683B43703723C5CE198", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "064FE42B46208CBC35991D5A7C24006E", hash_generated_field = "A7BFECA874263BCC8A6464704B9D41D9")

    int mResurrectToPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "C7741A0A622E5D31931CC54BDFAA705B", hash_generated_field = "83C7C32482C7E5A03D695886EA4705D5")

    private ContextMenuInfo mContextMenuInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "B3EE28A70FD254A5A734CAFFFD9F2578", hash_generated_field = "CAABAA47CA52B1F5C0386B90B683E22C")

    int mOverscrollMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "50D6DEF2D13611E8D0E41D610E4194EC", hash_generated_field = "CFC250691336B4B39585FE305D07A5A8")

    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "DFFFABFC0994B627F8D236F3905F6919", hash_generated_field = "8AE445FC94FDAEC334CFCA8838E3B70E")

    private boolean mScrollProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.390 -0400", hash_original_field = "8C5835FEC163B16D102063BC8F2C1248", hash_generated_field = "69AFA437C5D84E7EE29B4FE44E13B088")

    private boolean mFlingProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "956789F3DA470AD87E91A7076E41578B", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "9567FFD92CF28040BB18362734DD4369", hash_generated_field = "6BA43AA573D039EEDC72EB768AE06B64")

    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "83D78F1B989F8D62D88496F5EC6FF33F", hash_generated_field = "07CC57CA51A809E0D650A47A9B235FD7")

    private AbsListView.PerformClick mPerformClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "66EF6F4B5EA8F655178F52CF9F60EB91", hash_generated_field = "04EA068A0D45E96537B1140190A89770")

    private Runnable mTouchModeReset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "B59250E72778FF38D50B7661501C8F31", hash_generated_field = "1526254A73CD23B3F5170A2D59CF9F76")

    private int mTranscriptMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "5CB078F03E28D94B5DD6707B7823D2ED", hash_generated_field = "1B8E8F372FC2DAC037EC526954D125A4")

    private int mCacheColorHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "33F961CDAC96AE08DD70684978D9836B", hash_generated_field = "0F85F813AE78D809D6545B656F7C07C7")

    private boolean mIsChildViewEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "DB0605A6A9286B4B3CF497EAF4906666", hash_generated_field = "9D6B53868A098EC5A838EECA6460C254")

    private int mLastScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "4F737BBBBA31571ABB2F993907F88669", hash_generated_field = "FE09333368CBF6471ABE6F31E47E522C")

    private FastScroller mFastScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "5612C2662D978BF558FD7AA146C3290E", hash_generated_field = "8D12711C83D9C6A8E3A8DA9BEC091FCE")

    private boolean mGlobalLayoutListenerAddedFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "D9269244F21F5C31BC4C06A0545F0761", hash_generated_field = "3CCF90D786BE55C250C6CD780F8D19C3")

    private float mDensityScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.391 -0400", hash_original_field = "300ACBBBBD6F3498749333183FF92783", hash_generated_field = "92752ACB14767626BA8FAB32711AE1A6")

    private InputConnection mDefInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "C2FA9D2B5583B9601295BA7FB05D7F95", hash_generated_field = "048E465914FAB6B457D7426F9FB399BD")

    private InputConnectionWrapper mPublicInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "52C2576C8945A7A83AF5BFD6781D387F", hash_generated_field = "20FDBC6BCA9CEE1B1E479A246AC00217")

    private Runnable mClearScrollingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "ACAB612EAF9F4A8FD31B6DAD171C86FC", hash_generated_field = "32DD593911EBA2DE7D4B7E5052058A82")

    private float mVelocityScale = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "592389443AC9BF2094ADFD76AA22F7AE", hash_generated_field = "3A7729712A4A2CC963B04549E3BBA6B5")

    final boolean[] mIsScrap = new boolean[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "06749DD524BE381345057152BDEA5C9E", hash_generated_field = "AD55617BE800751F5B53C823CD34BAAE")

    private boolean mPopupHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "3140A319F32CA873045621864B655537")

    int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "F239C82AEB45C28104273F86A78E6F04")

    int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "445A0C2969A51E83292F7A48A01F98A3", hash_generated_field = "C116882C31FC92381FC21BBC7F61A670")

    private int mFirstPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "0EB1273195375A97262E41F466E36FAF", hash_generated_field = "0D7647AA84F359D8EC76D4A85F02F8A5")

    private int mLastPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "04081D36EE14DF5AD4E0EC7150A5F126", hash_generated_field = "BE4199720272019245F0BE0F2D9EF958")

    private int mDirection = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "39ABF7FC59545839E1E692CD25B4EABA", hash_generated_field = "D5B94B1CE48D1F35D7827F180B43A659")

    private boolean mForceTranscriptScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "02F451968FD533EEF7D3944E7669E9A2", hash_generated_field = "13A0640F3C08F553786642C29E645CCC")

    private int mGlowPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.392 -0400", hash_original_field = "22F2EAAA4524A77ECA0826E1C2B0F476", hash_generated_field = "9E94FEEAC15232AEE61DC08B2319DDAA")

    private int mGlowPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_field = "6256DF52CF0ED50BC6EE01394EF5CB10", hash_generated_field = "740236379897EF8ABD678F65696A25EA")

    private int mLastAccessibilityScrollEventFromIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_field = "81F3A0960933278C26B58CAE75D60E40", hash_generated_field = "9F103C6DB9B3EB29E780CB30462F5591")

    private int mLastAccessibilityScrollEventToIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_field = "0AD971D9895BFC06CF48F77D1B9D890A", hash_generated_field = "4F9C4241EE9024683E4B1C2A3BA5C180")

    boolean mIsAttached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_field = "4A894AB51819552684504464AA94B729", hash_generated_field = "9CAD0235527F91F182E61802511E0DCF")

    private int mLastHandledItemCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_method = "6A1152DD2F769DBF7D49F3027748695E", hash_generated_method = "22AC43F25D406401F2D47100407D88DA")
    public  AbsListView(Context context) {
        super(context);
        addTaint(context.getTaint());
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray a = context.obtainStyledAttributes(R.styleable.View);
        initializeScrollbars(a);
        a.recycle();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.393 -0400", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "618200BD3AA9E5ED1E0C7EDCD33076B7")
    public  AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.394 -0400", hash_original_method = "A8C0C093ECB8745800A88EB739981F47", hash_generated_method = "8E237A7DC81872C71AE759C90D7018A4")
    public  AbsListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initAbsListView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsListView, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.AbsListView_listSelector);
    if(d != null)        
        {
            setSelector(d);
        } 
        mDrawSelectorOnTop = a.getBoolean(
                com.android.internal.R.styleable.AbsListView_drawSelectorOnTop, false);
        boolean stackFromBottom = a.getBoolean(R.styleable.AbsListView_stackFromBottom, false);
        setStackFromBottom(stackFromBottom);
        boolean scrollingCacheEnabled = a.getBoolean(R.styleable.AbsListView_scrollingCache, true);
        setScrollingCacheEnabled(scrollingCacheEnabled);
        boolean useTextFilter = a.getBoolean(R.styleable.AbsListView_textFilterEnabled, false);
        setTextFilterEnabled(useTextFilter);
        int transcriptMode = a.getInt(R.styleable.AbsListView_transcriptMode,
                TRANSCRIPT_MODE_DISABLED);
        setTranscriptMode(transcriptMode);
        int color = a.getColor(R.styleable.AbsListView_cacheColorHint, 0);
        setCacheColorHint(color);
        boolean enableFastScroll = a.getBoolean(R.styleable.AbsListView_fastScrollEnabled, false);
        setFastScrollEnabled(enableFastScroll);
        boolean smoothScrollbar = a.getBoolean(R.styleable.AbsListView_smoothScrollbar, true);
        setSmoothScrollbarEnabled(smoothScrollbar);
        setChoiceMode(a.getInt(R.styleable.AbsListView_choiceMode, CHOICE_MODE_NONE));
        setFastScrollAlwaysVisible(
                a.getBoolean(R.styleable.AbsListView_fastScrollAlwaysVisible, false));
        a.recycle();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.395 -0400", hash_original_method = "2C481DB3FCB8FF016FB8E3D34F80B2B8", hash_generated_method = "4EE40469C2C86DCD6B9F429C4CCE0F16")
    private void initAbsListView() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.396 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "43AD6AF537E38C837754F889C2E9FA53")
    @Override
    public void setOverScrollMode(int mode) {
        addTaint(mode);
    if(mode != OVER_SCROLL_NEVER)        
        {
    if(mEdgeGlowTop == null)            
            {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } 
        } 
        else
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } 
        super.setOverScrollMode(mode);
        
        
            
                
                
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.396 -0400", hash_original_method = "2831A8F535381CCEFB0BADB6BC86E26A", hash_generated_method = "7A5C1BC442106BE982F6143D35096787")
    @Override
    public void setAdapter(ListAdapter adapter) {
        addTaint(adapter.getTaint());
    if(adapter != null)        
        {
    if(mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
                    mCheckedIdStates == null)            
            {
                mCheckedIdStates = new LongSparseArray<Integer>();
            } 
        } 
    if(mCheckStates != null)        
        {
            mCheckStates.clear();
        } 
    if(mCheckedIdStates != null)        
        {
            mCheckedIdStates.clear();
        } 
        
        
            
                    
                
            
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.397 -0400", hash_original_method = "5DFF60E6C611266C8D61B940778B8222", hash_generated_method = "D1E66D441C3B5E3FB6FF80E84CDA9E06")
    public int getCheckedItemCount() {
        int var15A65D8079003A56299BBC3EC8F634A7_1503089045 = (mCheckedItemCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633144370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633144370;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.397 -0400", hash_original_method = "76DE4C8AF2033C88DA13B2D6D79BE8CC", hash_generated_method = "8390DC058B6C20CFD2A136FD7945CFEC")
    public boolean isItemChecked(int position) {
        addTaint(position);
    if(mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null)        
        {
            boolean var6FB4A1B59EFFDB3315DE97A9EDA8F3F3_52531142 = (mCheckStates.get(position));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950295602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950295602;
        } 
        boolean var68934A3E9455FA72420237EB05902327_454084319 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187873587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187873587;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.398 -0400", hash_original_method = "40A1040C0B9BA1980C4FD0733FBB2F2E", hash_generated_method = "348A4D075E147249B969AB4E59F69045")
    public int getCheckedItemPosition() {
    if(mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1)        
        {
            int varAADAA75BBDA6510BEB60EC60A8EA2E12_642893567 = (mCheckStates.keyAt(0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553411789 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553411789;
        } 
        int var296D6C732A05FBA51C5854FA7933FE23_523330574 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657462412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657462412;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.398 -0400", hash_original_method = "DD9B0503EDD82432AE0B7C0599D4B447", hash_generated_method = "30426B84372CCF9C1CD9C5CB07D78150")
    public SparseBooleanArray getCheckedItemPositions() {
    if(mChoiceMode != CHOICE_MODE_NONE)        
        {
SparseBooleanArray var2D04307C8DDF2555B03DC58B0E6487B8_1124726135 =             mCheckStates;
            var2D04307C8DDF2555B03DC58B0E6487B8_1124726135.addTaint(taint);
            return var2D04307C8DDF2555B03DC58B0E6487B8_1124726135;
        } 
SparseBooleanArray var540C13E9E156B687226421B24F2DF178_926269609 =         null;
        var540C13E9E156B687226421B24F2DF178_926269609.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_926269609;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.399 -0400", hash_original_method = "C085907095DB552ED74D8B304576006A", hash_generated_method = "454E7820EB0AD38644DB2780421852FC")
    public long[] getCheckedItemIds() {
    if(mChoiceMode == CHOICE_MODE_NONE || mCheckedIdStates == null || mAdapter == null)        
        {
            long[] var349254FC737BA061D0B4F7515D9FED58_1502068562 = (new long[0]);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_873909827 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_873909827;
        } 
        final LongSparseArray<Integer> idStates = mCheckedIdStates;
        final int count = idStates.size();
        final long[] ids = new long[count];
for(int i = 0;i < count;i++)
        {
            ids[i] = idStates.keyAt(i);
        } 
        long[] varBF516925BB37A8544C8EE19A24E15C05_1357042782 = (ids);
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_74800675 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_74800675;
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.399 -0400", hash_original_method = "A5D48B0328BC1A467504F22AFA94E40C", hash_generated_method = "E6C692786E3C772EFCB1BA6E47F05D94")
    public void clearChoices() {
    if(mCheckStates != null)        
        {
            mCheckStates.clear();
        } 
    if(mCheckedIdStates != null)        
        {
            mCheckedIdStates.clear();
        } 
        mCheckedItemCount = 0;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.400 -0400", hash_original_method = "43E07392067BD1BC5F99F3882FA40E88", hash_generated_method = "8BC82AE74D2E301215C37C789C76F4E5")
    public void setItemChecked(int position, boolean value) {
        addTaint(value);
        addTaint(position);
    if(mChoiceMode == CHOICE_MODE_NONE)        
        {
            return;
        } 
    if(value && mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL && mChoiceActionMode == null)        
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } 
    if(mChoiceMode == CHOICE_MODE_MULTIPLE || mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL)        
        {
            boolean oldValue = mCheckStates.get(position);
            mCheckStates.put(position, value);
    if(mCheckedIdStates != null && mAdapter.hasStableIds())            
            {
    if(value)                
                {
                    mCheckedIdStates.put(mAdapter.getItemId(position), position);
                } 
                else
                {
                    mCheckedIdStates.delete(mAdapter.getItemId(position));
                } 
            } 
    if(oldValue != value)            
            {
    if(value)                
                {
                    mCheckedItemCount++;
                } 
                else
                {
                    mCheckedItemCount--;
                } 
            } 
    if(mChoiceActionMode != null)            
            {
                final long id = mAdapter.getItemId(position);
                mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                        position, id, value);
            } 
        } 
        else
        {
            boolean updateIds = mCheckedIdStates != null && mAdapter.hasStableIds();
    if(value || isItemChecked(position))            
            {
                mCheckStates.clear();
    if(updateIds)                
                {
                    mCheckedIdStates.clear();
                } 
            } 
    if(value)            
            {
                mCheckStates.put(position, true);
    if(updateIds)                
                {
                    mCheckedIdStates.put(mAdapter.getItemId(position), position);
                } 
                mCheckedItemCount = 1;
            } 
            else
    if(mCheckStates.size() == 0 || !mCheckStates.valueAt(0))            
            {
                mCheckedItemCount = 0;
            } 
        } 
    if(!mInLayout && !mBlockLayoutRequests)        
        {
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.402 -0400", hash_original_method = "9A0165787640E5C3A3D1AC60426CC2CC", hash_generated_method = "BAF911186ECF620E2086EB7D47682DE4")
    @Override
    public boolean performItemClick(View view, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        boolean handled = false;
        boolean dispatchItemClick = true;
    if(mChoiceMode != CHOICE_MODE_NONE)        
        {
            handled = true;
    if(mChoiceMode == CHOICE_MODE_MULTIPLE ||
                    (mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL && mChoiceActionMode != null))            
            {
                boolean newValue = !mCheckStates.get(position, false);
                mCheckStates.put(position, newValue);
    if(mCheckedIdStates != null && mAdapter.hasStableIds())                
                {
    if(newValue)                    
                    {
                        mCheckedIdStates.put(mAdapter.getItemId(position), position);
                    } 
                    else
                    {
                        mCheckedIdStates.delete(mAdapter.getItemId(position));
                    } 
                } 
    if(newValue)                
                {
                    mCheckedItemCount++;
                } 
                else
                {
                    mCheckedItemCount--;
                } 
    if(mChoiceActionMode != null)                
                {
                    mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                            position, id, newValue);
                    dispatchItemClick = false;
                } 
            } 
            else
    if(mChoiceMode == CHOICE_MODE_SINGLE)            
            {
                boolean newValue = !mCheckStates.get(position, false);
    if(newValue)                
                {
                    mCheckStates.clear();
                    mCheckStates.put(position, true);
    if(mCheckedIdStates != null && mAdapter.hasStableIds())                    
                    {
                        mCheckedIdStates.clear();
                        mCheckedIdStates.put(mAdapter.getItemId(position), position);
                    } 
                    mCheckedItemCount = 1;
                } 
                else
    if(mCheckStates.size() == 0 || !mCheckStates.valueAt(0))                
                {
                    mCheckedItemCount = 0;
                } 
            } 
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } 
    if(dispatchItemClick)        
        {
            handled |= super.performItemClick(view, position, id);
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_176751858 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951026397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951026397;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.403 -0400", hash_original_method = "8E2D8E05EEC3041F2430430C00E99F2E", hash_generated_method = "2AB2704ADB2B1F2109D5E9B1DDE3573E")
    public int getChoiceMode() {
        int varFE37534C0F831F910316E2E5E2384778_2110939127 = (mChoiceMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794523776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794523776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.404 -0400", hash_original_method = "31284EBF9693FA29D08DAAB1651BB216", hash_generated_method = "7865D8A8ADFE38FF0724949F1B106455")
    public void setChoiceMode(int choiceMode) {
        mChoiceMode = choiceMode;
    if(mChoiceActionMode != null)        
        {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        } 
    if(mChoiceMode != CHOICE_MODE_NONE)        
        {
    if(mCheckStates == null)            
            {
                mCheckStates = new SparseBooleanArray();
            } 
    if(mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds())            
            {
                mCheckedIdStates = new LongSparseArray<Integer>();
            } 
    if(mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL)            
            {
                clearChoices();
                setLongClickable(true);
            } 
        } 
        
        
        
            
            
        
        
            
                
            
            
                
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.405 -0400", hash_original_method = "AB030C487B8A76B7A3B990C85D8D5284", hash_generated_method = "35E96AAC2FDEC772DF732A8949907F98")
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener) {
        addTaint(listener.getTaint());
    if(mMultiChoiceModeCallback == null)        
        {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        } 
        mMultiChoiceModeCallback.setWrapped(listener);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.405 -0400", hash_original_method = "34BF563ABF29C3DFDECFCC44CD785338", hash_generated_method = "67C8D6C30305B436250D96FE0BB33412")
    private boolean contentFits() {
        final int childCount = getChildCount();
    if(childCount == 0)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_727725589 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835344513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835344513;
        }
    if(childCount != mItemCount)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1766252225 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852768718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852768718;
        }
        boolean varF028B93BC4E7CC0965BF7FBA6EC9BE80_555854986 = (getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083336378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083336378;
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.406 -0400", hash_original_method = "595588F5399A1D343B61A8313A8ACA6F", hash_generated_method = "86BF42828C62B8A7C5F4F10CEC0C4BF1")
    public void setFastScrollEnabled(boolean enabled) {
        mFastScrollEnabled = enabled;
    if(enabled)        
        {
    if(mFastScroller == null)            
            {
                mFastScroller = new FastScroller(getContext(), this);
            } 
        } 
        else
        {
    if(mFastScroller != null)            
            {
                mFastScroller.stop();
                mFastScroller = null;
            } 
        } 
        
        
        
            
                
            
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.406 -0400", hash_original_method = "76A971EB75129863E10E67DBAAA59745", hash_generated_method = "AECEBA3FC4578BC121403BA10CA5F0B8")
    public void setFastScrollAlwaysVisible(boolean alwaysShow) {
        addTaint(alwaysShow);
    if(alwaysShow && !mFastScrollEnabled)        
        {
            setFastScrollEnabled(true);
        } 
    if(mFastScroller != null)        
        {
            mFastScroller.setAlwaysShow(alwaysShow);
        } 
        computeOpaqueFlags();
        recomputePadding();
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.407 -0400", hash_original_method = "B8FB7506E98011F45E37A448BFD532A7", hash_generated_method = "0EC130B45536A2E102D5BEDD8ABB1EC0")
    public boolean isFastScrollAlwaysVisible() {
        boolean var42F877B269DAA22B01B4A8900DAB94EB_80513434 = (mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723840376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723840376;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.407 -0400", hash_original_method = "7B9EF1235ED171F1370B12BB905DC3C9", hash_generated_method = "15817AEA72615889C4A741D0B624B59D")
    @Override
    public int getVerticalScrollbarWidth() {
    if(isFastScrollAlwaysVisible())        
        {
            int var1FBD7EE0627D6C422F3D8D06AE67B64A_159028218 = (Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753166213 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753166213;
        } 
        int varD0641DFD99889506786301563592303E_665686406 = (super.getVerticalScrollbarWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380732076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380732076;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.408 -0400", hash_original_method = "0BC112ABD3166320C6B43E3AFC3B6D61", hash_generated_method = "3BF19845F3A25C406E76DD503A62541D")
    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        boolean var15797563431B975E4FF5A08BDEC264DA_1726753506 = (mFastScrollEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710136419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710136419;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.408 -0400", hash_original_method = "A675D7279FF2D5DA4484C8480BA7553A", hash_generated_method = "2691476F8E818182A6FB9C40F0633753")
    @Override
    public void setVerticalScrollbarPosition(int position) {
        addTaint(position);
        super.setVerticalScrollbarPosition(position);
    if(mFastScroller != null)        
        {
            mFastScroller.setScrollbarPosition(position);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.409 -0400", hash_original_method = "940CDB7D64F97F8EC4A4E1C87858DFBA", hash_generated_method = "2E9E870E5F52F621F653B3A3F0616B90")
    @Override
    protected boolean isVerticalScrollBarHidden() {
        boolean var997676F41E4E52F879DC24BDEB1E4B1E_391785573 = (mFastScroller != null && mFastScroller.isVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1420674413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1420674413;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.409 -0400", hash_original_method = "1698DB675ADDAA62665F2F04BB6F72CB", hash_generated_method = "D64E9DF10E031F8E4DDF09544BB4BA0A")
    public void setSmoothScrollbarEnabled(boolean enabled) {
        mSmoothScrollbarEnabled = enabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.409 -0400", hash_original_method = "475C5FFCF382FD26204BCB75E2B77D7D", hash_generated_method = "FC946C34D0F3A01214555303CC416D19")
    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        boolean var521A5426D725D811EB931803FF71C584_725069663 = (mSmoothScrollbarEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368028482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368028482;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.410 -0400", hash_original_method = "210B7E1D385EBACE9AEF47F53212EE62", hash_generated_method = "7891AA0536D9A3BB23A5AA51B1644A4C")
    public void setOnScrollListener(OnScrollListener l) {
        mOnScrollListener = l;
        invokeOnItemScrollListener();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.410 -0400", hash_original_method = "BA8530F9EF3261CEDA66BF584A9CCD3E", hash_generated_method = "02EC383FE9C31679229A2B71B57865FE")
     void invokeOnItemScrollListener() {
    if(mFastScroller != null)        
        {
            mFastScroller.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } 
    if(mOnScrollListener != null)        
        {
            mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } 
        onScrollChanged(0, 0, 0, 0);
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.411 -0400", hash_original_method = "B64F2C3012E6A3D7EFE9332FD2B83485", hash_generated_method = "1ED4B5E01A9E7525841BEC072A77A025")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
    if(eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED)        
        {
            final int firstVisiblePosition = getFirstVisiblePosition();
            final int lastVisiblePosition = getLastVisiblePosition();
    if(mLastAccessibilityScrollEventFromIndex == firstVisiblePosition
                    && mLastAccessibilityScrollEventToIndex == lastVisiblePosition)            
            {
                return;
            } 
            else
            {
                mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            } 
        } 
        super.sendAccessibilityEvent(eventType);
        
        
            
            
            
                    
                
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.411 -0400", hash_original_method = "9414D347741A5DD8E57796525BCE5898", hash_generated_method = "1D531AB63DEC7CEFEAC4039D58FA7F20")
    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        boolean var7FB4BC12E46C9E48428AFBC608C49853_1292829977 = (mScrollingCacheEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303883913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_303883913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.412 -0400", hash_original_method = "150D6943577E82022A370D7488992E67", hash_generated_method = "4C03B079E9905E10B4DB39B574061348")
    public void setScrollingCacheEnabled(boolean enabled) {
    if(mScrollingCacheEnabled && !enabled)        
        {
            clearScrollingCache();
        } 
        mScrollingCacheEnabled = enabled;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.412 -0400", hash_original_method = "8476047A74E8C2792EEAD35F27B63501", hash_generated_method = "264A2BADB5D79F4C262375A12D707EBE")
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        mTextFilterEnabled = textFilterEnabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.412 -0400", hash_original_method = "D536B611E01E5CFE1F666765CAB03290", hash_generated_method = "F3A149F7CC348C7FB1F3F7FB44E84311")
    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        boolean var586CD8929678603BADF3EAE99555BE68_936124854 = (mTextFilterEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726831396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726831396;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.413 -0400", hash_original_method = "1C8D0A5FE9343035731EC5D6D9384599", hash_generated_method = "7E9FD2EB3531C0E52B9F4F2DAB27C7DF")
    @Override
    public void getFocusedRect(Rect r) {
        addTaint(r.getTaint());
        View view = getSelectedView();
    if(view != null && view.getParent() == this)        
        {
            view.getFocusedRect(r);
            offsetDescendantRectToMyCoords(view, r);
        } 
        else
        {
            super.getFocusedRect(r);
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.413 -0400", hash_original_method = "9E8C7705C9D325A7FB79BC94A2C5E742", hash_generated_method = "5E8864341AF6CB275CB3012A78EAE0CA")
    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.413 -0400", hash_original_method = "991365D9D991378A506E868734A0B0D2", hash_generated_method = "33BD23F1984CFD48A3301A9E7B95E179")
    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        boolean var452AAACA6529C6DDC61AC74D560EC80F_1728459511 = (mStackFromBottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672482774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672482774;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.414 -0400", hash_original_method = "CFFEAD7E7BECCE023678F7841887953F", hash_generated_method = "7C343F43473DE5C4ECC1104C99B1BB50")
    public void setStackFromBottom(boolean stackFromBottom) {
    if(mStackFromBottom != stackFromBottom)        
        {
            mStackFromBottom = stackFromBottom;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.414 -0400", hash_original_method = "DBB2E77784FB40B043F5BACE416B5D38", hash_generated_method = "2E0CDC5F61F9B4EEDCB4012171468ACB")
     void requestLayoutIfNecessary() {
    if(getChildCount() > 0)        
        {
            resetList();
            requestLayout();
            invalidate();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.417 -0400", hash_original_method = "550511192552500388A3039280244936", hash_generated_method = "E620C1959C55CED7508CB2F224F12E78")
    @Override
    public Parcelable onSaveInstanceState() {
        
        dismissPopup();
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        boolean haveChildren = getChildCount() > 0 && mItemCount > 0;
        long selectedId = getSelectedItemId();
        ss.selectedId = selectedId;
        ss.height = getHeight();
    if(selectedId >= 0)        
        {
            ss.viewTop = mSelectedTop;
            ss.position = getSelectedItemPosition();
            ss.firstId = INVALID_POSITION;
        } 
        else
        {
    if(haveChildren && mFirstPosition > 0)            
            {
                View v = getChildAt(0);
                ss.viewTop = v.getTop();
                int firstPos = mFirstPosition;
    if(firstPos >= mItemCount)                
                {
                    firstPos = mItemCount - 1;
                } 
                ss.position = firstPos;
                ss.firstId = mAdapter.getItemId(firstPos);
            } 
            else
            {
                ss.viewTop = 0;
                ss.firstId = INVALID_POSITION;
                ss.position = 0;
            } 
        } 
        ss.filter = null;
    if(mFiltered)        
        {
            final EditText textFilter = mTextFilter;
    if(textFilter != null)            
            {
                Editable filterText = textFilter.getText();
    if(filterText != null)                
                {
                    ss.filter = filterText.toString();
                } 
            } 
        } 
        ss.inActionMode = mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL && mChoiceActionMode != null;
    if(mCheckStates != null)        
        {
            ss.checkState = mCheckStates.clone();
        } 
    if(mCheckedIdStates != null)        
        {
            final LongSparseArray<Integer> idState = new LongSparseArray<Integer>();
            final int count = mCheckedIdStates.size();
for(int i = 0;i < count;i++)
            {
                idState.put(mCheckedIdStates.keyAt(i), mCheckedIdStates.valueAt(i));
            } 
            ss.checkIdState = idState;
        } 
        ss.checkedItemCount = mCheckedItemCount;
Parcelable var182E37827114C3F455816E0E29D81D76_1597872532 =         ss;
        var182E37827114C3F455816E0E29D81D76_1597872532.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_1597872532;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.424 -0400", hash_original_method = "43BE5C5AD27C719005EFC4A46B8486A7", hash_generated_method = "91E2E380E449F491172966974E5692D8")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mDataChanged = true;
        mSyncHeight = ss.height;
    if(ss.selectedId >= 0)        
        {
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSpecificTop = ss.viewTop;
            mSyncMode = SYNC_SELECTED_POSITION;
        } 
        else
    if(ss.firstId >= 0)        
        {
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectorPosition = INVALID_POSITION;
            mNeedSync = true;
            mSyncRowId = ss.firstId;
            mSyncPosition = ss.position;
            mSpecificTop = ss.viewTop;
            mSyncMode = SYNC_FIRST_POSITION;
        } 
        setFilterText(ss.filter);
    if(ss.checkState != null)        
        {
            mCheckStates = ss.checkState;
        } 
    if(ss.checkIdState != null)        
        {
            mCheckedIdStates = ss.checkIdState;
        } 
        mCheckedItemCount = ss.checkedItemCount;
    if(ss.inActionMode && mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL &&
                mMultiChoiceModeCallback != null)        
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } 
        requestLayout();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.425 -0400", hash_original_method = "42E27AF1CE674CD4135EEA22852A217B", hash_generated_method = "BEDB30E3754830D7FF1982D79F5445DB")
    private boolean acceptFilter() {
        boolean varDA4D47176E4B5A1B76C04E3B4FC59014_554662636 = (mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228526298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_228526298;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.425 -0400", hash_original_method = "A8CCB94844A67C45EFD075D798DD3AF0", hash_generated_method = "1DD9D43B7CE5CF23081FCD21185BE350")
    public void setFilterText(String filterText) {
        addTaint(filterText.getTaint());
    if(mTextFilterEnabled && !TextUtils.isEmpty(filterText))        
        {
            createTextFilter(false);
            mTextFilter.setText(filterText);
            mTextFilter.setSelection(filterText.length());
    if(mAdapter instanceof Filterable)            
            {
    if(mPopup == null)                
                {
                    Filter f = ((Filterable) mAdapter).getFilter();
                    f.filter(filterText);
                } 
                mFiltered = true;
                mDataSetObserver.clearSavedState();
            } 
        } 
        
        
            
            
            
            
                
                    
                    
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.426 -0400", hash_original_method = "1C9B36BFA6AA511A6999C19189070FD4", hash_generated_method = "69C4E1BF13BB2C6362C158FFF214C615")
    public CharSequence getTextFilter() {
    if(mTextFilterEnabled && mTextFilter != null)        
        {
CharSequence var950048B5DF053AA5DF1FA461BC2D5469_1831796668 =             mTextFilter.getText();
            var950048B5DF053AA5DF1FA461BC2D5469_1831796668.addTaint(taint);
            return var950048B5DF053AA5DF1FA461BC2D5469_1831796668;
        } 
CharSequence var540C13E9E156B687226421B24F2DF178_539091837 =         null;
        var540C13E9E156B687226421B24F2DF178_539091837.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_539091837;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.427 -0400", hash_original_method = "0C025ACF6797C1095DC28C93A47B3E04", hash_generated_method = "0961701860EA751C583F2C057F0422BE")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(gainFocus);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    if(gainFocus && mSelectedPosition < 0 && !isInTouchMode())        
        {
    if(!mIsAttached && mAdapter != null)            
            {
                mDataChanged = true;
                mOldItemCount = mItemCount;
                mItemCount = mAdapter.getCount();
            } 
            resurrectSelection();
        } 
        
        
        
            
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.427 -0400", hash_original_method = "B180005EA1177A66433DC47F81A1B223", hash_generated_method = "9C9D7E350D091D5F9C274AA9D7B36512")
    @Override
    public void requestLayout() {
    if(!mBlockLayoutRequests && !mInLayout)        
        {
            super.requestLayout();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.428 -0400", hash_original_method = "8DD5C430A497277A13BB6B282542179B", hash_generated_method = "7581B754A737045C6DFD1C880926F30E")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.429 -0400", hash_original_method = "EAD3946FC18204D61E6D52ABAEC42671", hash_generated_method = "2187D520C6126F0B9363BA9F17849D64")
    @Override
    protected int computeVerticalScrollExtent() {
        final int count = getChildCount();
    if(count > 0)        
        {
    if(mSmoothScrollbarEnabled)            
            {
                int extent = count * 100;
                View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
    if(height > 0)                
                {
                    extent += (top * 100) / height;
                } 
                view = getChildAt(count - 1);
                final int bottom = view.getBottom();
                height = view.getHeight();
    if(height > 0)                
                {
                    extent -= ((bottom - getHeight()) * 100) / height;
                } 
                int var0793046CD12DB418149C2B688AF9B27F_323781013 = (extent);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573306202 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573306202;
            } 
            else
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1051349575 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423243166 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_423243166;
            } 
        } 
        int varCFCD208495D565EF66E7DFF9F98764DA_1387796207 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054317232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054317232;
        
        
        
            
                
                
                
                
                
                    
                
                
                
                
                
                    
                
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.431 -0400", hash_original_method = "B342EEB15F9AC09DD167764D56209B72", hash_generated_method = "C05C3E47891F23800B3E5479C3F39303")
    @Override
    protected int computeVerticalScrollOffset() {
        final int firstPosition = mFirstPosition;
        final int childCount = getChildCount();
    if(firstPosition >= 0 && childCount > 0)        
        {
    if(mSmoothScrollbarEnabled)            
            {
                final View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
    if(height > 0)                
                {
                    int var182F05D74F03293217D1805246D0432C_189352953 = (Math.max(firstPosition * 100 - (top * 100) / height +
                            (int)((float)mScrollY / getHeight() * mItemCount * 100), 0));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51241595 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51241595;
                } 
            } 
            else
            {
                int index;
                final int count = mItemCount;
    if(firstPosition == 0)                
                {
                    index = 0;
                } 
                else
    if(firstPosition + childCount == count)                
                {
                    index = count;
                } 
                else
                {
                    index = firstPosition + childCount / 2;
                } 
                int var95840C113D31BDADAB50C9E08A8A744A_334122780 = ((int) (firstPosition + childCount * (index / (float) count)));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905959211 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905959211;
            } 
        } 
        int varCFCD208495D565EF66E7DFF9F98764DA_393246960 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004994788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004994788;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.432 -0400", hash_original_method = "4324030F56A09BCB8354791FE2A22081", hash_generated_method = "BF44CF995704C5809CC8958885BF478F")
    @Override
    protected int computeVerticalScrollRange() {
        int result;
    if(mSmoothScrollbarEnabled)        
        {
            result = Math.max(mItemCount * 100, 0);
    if(mScrollY != 0)            
            {
                result += Math.abs((int) ((float) mScrollY / getHeight() * mItemCount * 100));
            } 
        } 
        else
        {
            result = mItemCount;
        } 
        int varB4A88417B3D0170D754C647C30B7216A_2094938801 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947847490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947847490;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.432 -0400", hash_original_method = "6B45AE0F220A2E6F043181E50094F343", hash_generated_method = "8AC973853ACAA82DFBA88C7159363584")
    @Override
    protected float getTopFadingEdgeStrength() {
        final int count = getChildCount();
        final float fadeEdge = super.getTopFadingEdgeStrength();
    if(count == 0)        
        {
            float varC3618E075D507258322D441182BA51CA_636414475 = (fadeEdge);
                        float var546ADE640B6EDFBC8A086EF31347E768_359281116 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_359281116;
        } 
        else
        {
    if(mFirstPosition > 0)            
            {
                float varCFE70293CC98B68AC513E2798BAD793D_2035579197 = (1.0f);
                                float var546ADE640B6EDFBC8A086EF31347E768_582387221 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_582387221;
            } 
            final int top = getChildAt(0).getTop();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
            float var8008B8FEE58D9775401A3EDDE68904ED_1875367395 = (top < mPaddingTop ? (float) -(top - mPaddingTop) / fadeLength : fadeEdge);
                        float var546ADE640B6EDFBC8A086EF31347E768_150760832 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_150760832;
        } 
        
        
        
        
            
        
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.433 -0400", hash_original_method = "7783F8E763936950C57ED5516E6F7E94", hash_generated_method = "6C0F753EB1137750E2DCD83FAEA93CE9")
    @Override
    protected float getBottomFadingEdgeStrength() {
        final int count = getChildCount();
        final float fadeEdge = super.getBottomFadingEdgeStrength();
    if(count == 0)        
        {
            float varC3618E075D507258322D441182BA51CA_231213511 = (fadeEdge);
                        float var546ADE640B6EDFBC8A086EF31347E768_608871061 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_608871061;
        } 
        else
        {
    if(mFirstPosition + count - 1 < mItemCount - 1)            
            {
                float varCFE70293CC98B68AC513E2798BAD793D_1831321469 = (1.0f);
                                float var546ADE640B6EDFBC8A086EF31347E768_1040598922 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1040598922;
            } 
            final int bottom = getChildAt(count - 1).getBottom();
            final int height = getHeight();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
            float var967C881553A24CAD07E6D3DCEB81513A_248486942 = (bottom > height - mPaddingBottom ?
                    (float) (bottom - height + mPaddingBottom) / fadeLength : fadeEdge);
                        float var546ADE640B6EDFBC8A086EF31347E768_1184442240 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1184442240;
        } 
        
        
        
        
            
        
            
                
            
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.434 -0400", hash_original_method = "7C6C2B65B4381736E49DE73CCD130327", hash_generated_method = "7258571BDE87817F10E978493C48B8B0")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
    if(mSelector == null)        
        {
            useDefaultSelector();
        } 
        final Rect listPadding = mListPadding;
        listPadding.left = mSelectionLeftPadding + mPaddingLeft;
        listPadding.top = mSelectionTopPadding + mPaddingTop;
        listPadding.right = mSelectionRightPadding + mPaddingRight;
        listPadding.bottom = mSelectionBottomPadding + mPaddingBottom;
    if(mTranscriptMode == TRANSCRIPT_MODE_NORMAL)        
        {
            final int childCount = getChildCount();
            final int listBottom = getHeight() - getPaddingBottom();
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild != null ? lastChild.getBottom() : listBottom;
            mForceTranscriptScroll = mFirstPosition + childCount >= mLastHandledItemCount &&
                    lastBottom <= listBottom;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.435 -0400", hash_original_method = "46F44099FEFDB133D6B976408934CAC6", hash_generated_method = "8CD39A00A986CE68BF098B249D41681F")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        addTaint(r);
        addTaint(l);
        addTaint(changed);
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
    if(changed)        
        {
            int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
            {
                getChildAt(i).forceLayout();
            } 
            mRecycler.markChildrenDirty();
        } 
    if(mFastScroller != null && mItemCount != mOldItemCount)        
        {
            mFastScroller.onItemCountChanged(mOldItemCount, mItemCount);
        } 
        layoutChildren();
        mInLayout = false;
        mOverscrollMax = (b - t) / OVERSCROLL_LIMIT_DIVISOR;
        
        
        
        
            
            
                
            
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.436 -0400", hash_original_method = "748FD791AA503E7E1D859CFD661EA755", hash_generated_method = "2F9D584E5719706DEC4C8AC3933826CC")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final boolean changed = super.setFrame(left, top, right, bottom);
    if(changed)        
        {
            final boolean visible = getWindowVisibility() == View.VISIBLE;
    if(mFiltered && visible && mPopup != null && mPopup.isShowing())            
            {
                positionPopup();
            } 
        } 
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_297164726 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369264945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369264945;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.436 -0400", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "7C7456ED8D2FB5B664E2AB60CCD22125")
    protected void layoutChildren() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.437 -0400", hash_original_method = "180044681435C2C9D1AB0FD8756137A4", hash_generated_method = "F0DA569AE7E846AC85C75C5CBE43614E")
     void updateScrollIndicators() {
    if(mScrollUp != null)        
        {
            boolean canScrollUp;
            canScrollUp = mFirstPosition > 0;
    if(!canScrollUp)            
            {
    if(getChildCount() > 0)                
                {
                    View child = getChildAt(0);
                    canScrollUp = child.getTop() < mListPadding.top;
                } 
            } 
            mScrollUp.setVisibility(canScrollUp ? View.VISIBLE : View.INVISIBLE);
        } 
    if(mScrollDown != null)        
        {
            boolean canScrollDown;
            int count = getChildCount();
            canScrollDown = (mFirstPosition + count) < mItemCount;
    if(!canScrollDown && count > 0)            
            {
                View child = getChildAt(count - 1);
                canScrollDown = child.getBottom() > mBottom - mListPadding.bottom;
            } 
            mScrollDown.setVisibility(canScrollDown ? View.VISIBLE : View.INVISIBLE);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.437 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "54EDD5BD5118F990E06ED0B215080C27")
    @Override
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
    if(mItemCount > 0 && mSelectedPosition >= 0)        
        {
View var9232114380D348AA08914BA6993F21A2_2000083043 =             getChildAt(mSelectedPosition - mFirstPosition);
            var9232114380D348AA08914BA6993F21A2_2000083043.addTaint(taint);
            return var9232114380D348AA08914BA6993F21A2_2000083043;
        } 
        else
        {
View var540C13E9E156B687226421B24F2DF178_353281864 =             null;
            var540C13E9E156B687226421B24F2DF178_353281864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_353281864;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.437 -0400", hash_original_method = "3B697574C47153B82BC97C5C46624F2C", hash_generated_method = "90FE833B0AE5E38178E85BFB6F86D431")
    public int getListPaddingTop() {
        int var063E164F0483E31A9930E307E7BEB1FE_1142773984 = (mListPadding.top);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068565831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068565831;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.438 -0400", hash_original_method = "CEE980D8545C78DFB596AE8650DBF797", hash_generated_method = "DB2A04EC2C531252F30EE3592D641052")
    public int getListPaddingBottom() {
        int var0E05D85176E005D709CEEBF49FFAAB6D_1613879650 = (mListPadding.bottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054447508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054447508;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.438 -0400", hash_original_method = "C8B939C15FBE7011BDF7672B6F924B56", hash_generated_method = "F5CCCAF4C66ED07C7B566F2D15B40EA8")
    public int getListPaddingLeft() {
        int var9CA2CD8F9AD21522B950A0E114FE6F08_1525041986 = (mListPadding.left);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118537764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118537764;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.438 -0400", hash_original_method = "1F1F9379D690EBB0F58C075805935B4C", hash_generated_method = "17C3A41E6B14B96DC436096D8BA41006")
    public int getListPaddingRight() {
        int varA53868C209699C857F02A96DC0AD78CE_2096798853 = (mListPadding.right);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968935955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968935955;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.440 -0400", hash_original_method = "F1A94AACBC76DA4834C170841A9D4C37", hash_generated_method = "AE5941B02C2AAA3A94290B2266BA4220")
     View obtainView(int position, boolean[] isScrap) {
        addTaint(isScrap[0]);
        addTaint(position);
        isScrap[0] = false;
        View scrapView;
        scrapView = mRecycler.getScrapView(position);
        View child;
    if(scrapView != null)        
        {
    if(ViewDebug.TRACE_RECYCLER)            
            {
                ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.RECYCLE_FROM_SCRAP_HEAP,
                        position, -1);
            } 
            child = mAdapter.getView(position, scrapView, this);
    if(ViewDebug.TRACE_RECYCLER)            
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.BIND_VIEW,
                        position, getChildCount());
            } 
    if(child != scrapView)            
            {
                mRecycler.addScrapView(scrapView, position);
    if(mCacheColorHint != 0)                
                {
                    child.setDrawingCacheBackgroundColor(mCacheColorHint);
                } 
    if(ViewDebug.TRACE_RECYCLER)                
                {
                    ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                            position, -1);
                } 
            } 
            else
            {
                isScrap[0] = true;
                child.dispatchFinishTemporaryDetach();
            } 
        } 
        else
        {
            child = mAdapter.getView(position, null, this);
    if(mCacheColorHint != 0)            
            {
                child.setDrawingCacheBackgroundColor(mCacheColorHint);
            } 
    if(ViewDebug.TRACE_RECYCLER)            
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.NEW_VIEW,
                        position, getChildCount());
            } 
        } 
View var73902FD3E151130B4329B76EF04D2A54_1539772008 =         child;
        var73902FD3E151130B4329B76EF04D2A54_1539772008.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_1539772008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.442 -0400", hash_original_method = "B068259C5BBCB2A7501108708CD5A4C4", hash_generated_method = "9BC5D4B36B8950CA52E26A16C65D6DFC")
     void positionSelector(int position, View sel) {
        addTaint(sel.getTaint());
    if(position != INVALID_POSITION)        
        {
            mSelectorPosition = position;
        } 
        final Rect selectorRect = mSelectorRect;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
    if(sel instanceof SelectionBoundsAdjuster)        
        {
            ((SelectionBoundsAdjuster)sel).adjustListItemSelectionBounds(selectorRect);
        } 
        positionSelector(selectorRect.left, selectorRect.top, selectorRect.right,
                selectorRect.bottom);
        final boolean isChildViewEnabled = mIsChildViewEnabled;
    if(sel.isEnabled() != isChildViewEnabled)        
        {
            mIsChildViewEnabled = !isChildViewEnabled;
    if(getSelectedItemPosition() != INVALID_POSITION)            
            {
                refreshDrawableState();
            } 
        } 
        
        
            
        
        
        
        
            
        
        
                
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.443 -0400", hash_original_method = "9958A79674A9EAF808CC1CD0A2974C67", hash_generated_method = "B27F5C27194FF16B24BD6D479A727783")
    private void positionSelector(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                + mSelectionRightPadding, b + mSelectionBottomPadding);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.443 -0400", hash_original_method = "EB6A446E7A5D607DB4BF2796F54D03FA", hash_generated_method = "94DB7E16D7A2906EF5DF47AD79E42289")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        int saveCount = 0;
        final boolean clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
    if(clipToPadding)        
        {
            saveCount = canvas.save();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
            mGroupFlags &= ~CLIP_TO_PADDING_MASK;
        } 
        final boolean drawSelectorOnTop = mDrawSelectorOnTop;
    if(!drawSelectorOnTop)        
        {
            drawSelector(canvas);
        } 
        super.dispatchDraw(canvas);
    if(drawSelectorOnTop)        
        {
            drawSelector(canvas);
        } 
    if(clipToPadding)        
        {
            canvas.restoreToCount(saveCount);
            mGroupFlags |= CLIP_TO_PADDING_MASK;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.444 -0400", hash_original_method = "E1295B3F3CD2AED842AA5266ED41ED1A", hash_generated_method = "BD2BF9CE0203052E2F117B161FE9A13E")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean varF6C81ADCF06092D1258CB87033D3126B_295178533 = ((mGroupFlags & CLIP_TO_PADDING_MASK) != CLIP_TO_PADDING_MASK);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202301912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202301912;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.444 -0400", hash_original_method = "C31A372B11969057E398197BABCC2FB9", hash_generated_method = "49D05F50B356FF66D297C1A780EA0EC2")
    @Override
    protected int getLeftPaddingOffset() {
        int var7DA0557D43E0BF3D411DEBEC0BE10C20_2004319741 = ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995814615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995814615;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.445 -0400", hash_original_method = "F0F07013F187EA8DBDDCF030EEADD0A0", hash_generated_method = "52A184514284190CFF00AC90AE5764D1")
    @Override
    protected int getTopPaddingOffset() {
        int varCA4084CAE072D01B2ABDFD5BF60A8D97_245427157 = ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453571570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453571570;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.446 -0400", hash_original_method = "D64BFD9DD2CC0187FA2BCDAC4D5056C0", hash_generated_method = "F28DB9C1EE048532A80AD1593F90838B")
    @Override
    protected int getRightPaddingOffset() {
        int var736BBF3EC6C9ED4033288E78F914D8D0_948379521 = ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865571170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865571170;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.446 -0400", hash_original_method = "A76EA354621A97D061AF35F7F0E022AA", hash_generated_method = "99FC2B2EA2D84F17287CDC6EEA78BB90")
    @Override
    protected int getBottomPaddingOffset() {
        int var83A8283C9AAD4653C26CCD4E39019CFC_1542170636 = ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingBottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135777373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135777373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.447 -0400", hash_original_method = "7222D25647FA66D7134D6564AB03A11A", hash_generated_method = "2B3A2D6677E5F14E3617A4996CE4064D")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
    if(getChildCount() > 0)        
        {
            mDataChanged = true;
            rememberSyncState();
        } 
    if(mFastScroller != null)        
        {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        } 
        
        
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.447 -0400", hash_original_method = "E2B9A99414FF2EE03BB0A755AC5DBB16", hash_generated_method = "D516BA7C214AE1DA00C39EBF67DBE326")
     boolean touchModeDrawsInPressedState() {
switch(mTouchMode){
        case TOUCH_MODE_TAP:
        case TOUCH_MODE_DONE_WAITING:
        boolean varB326B5062B2F0E69046810717534CB09_688041587 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129569862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129569862;
        default:
        boolean var68934A3E9455FA72420237EB05902327_2002956454 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873790328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873790328;
}
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.448 -0400", hash_original_method = "FA7D742C09854F2E7F00273E8807D507", hash_generated_method = "A27A2CBBF49B2F53083B8EA521F15E78")
     boolean shouldShowSelector() {
        boolean var56499452FDA718C33BFC635A822F61FC_749328413 = ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663875031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663875031;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.448 -0400", hash_original_method = "1653A38E1AF50A830D0C8CACED5D71E9", hash_generated_method = "612647226C36EE5446E43919BEB3EF51")
    private void drawSelector(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(!mSelectorRect.isEmpty())        
        {
            final Drawable selector = mSelector;
            selector.setBounds(mSelectorRect);
            selector.draw(canvas);
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.448 -0400", hash_original_method = "E224CB1DBFEAEB35D4CBDCEA1ACB7063", hash_generated_method = "C23273762128D8B0257C96DB47B6A628")
    public void setDrawSelectorOnTop(boolean onTop) {
        mDrawSelectorOnTop = onTop;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.449 -0400", hash_original_method = "4BF5D497DEE1C8362CD452A22AD6FA64", hash_generated_method = "90CDAD56BD161685788EE9D2CC0D2605")
    public void setSelector(int resID) {
        addTaint(resID);
        setSelector(getResources().getDrawable(resID));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.449 -0400", hash_original_method = "AF217D83F5B526992017BCFB165071E1", hash_generated_method = "A63715066BF20FFE607A40F2795A0FF2")
    public void setSelector(Drawable sel) {
    if(mSelector != null)        
        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.449 -0400", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "1BB989D8A7063235F727E70B36E71825")
    public Drawable getSelector() {
Drawable var44BB8E3AFA16E93BC70CCD822DE8222C_1251309513 =         mSelector;
        var44BB8E3AFA16E93BC70CCD822DE8222C_1251309513.addTaint(taint);
        return var44BB8E3AFA16E93BC70CCD822DE8222C_1251309513;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.450 -0400", hash_original_method = "2F7C78E24D2DA521609D152C286646B5", hash_generated_method = "E0741DA2AD4BE18DB4538BBB79F0371D")
     void keyPressed() {
    if(!isEnabled() || !isClickable())        
        {
            return;
        } 
        Drawable selector = mSelector;
        Rect selectorRect = mSelectorRect;
    if(selector != null && (isFocused() || touchModeDrawsInPressedState())
                && !selectorRect.isEmpty())        
        {
            final View v = getChildAt(mSelectedPosition - mFirstPosition);
    if(v != null)            
            {
    if(v.hasFocusable())                
                return;
                v.setPressed(true);
            } 
            setPressed(true);
            final boolean longClickable = isLongClickable();
            Drawable d = selector.getCurrent();
    if(d != null && d instanceof TransitionDrawable)            
            {
    if(longClickable)                
                {
                    ((TransitionDrawable) d).startTransition(
                            ViewConfiguration.getLongPressTimeout());
                } 
                else
                {
                    ((TransitionDrawable) d).resetTransition();
                } 
            } 
    if(longClickable && !mDataChanged)            
            {
    if(mPendingCheckForKeyLongPress == null)                
                {
                    mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                } 
                mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                postDelayed(mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.451 -0400", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "21A7C287E27C4D3CE4CA7765A0F74054")
    public void setScrollIndicators(View up, View down) {
        mScrollUp = up;
        mScrollDown = down;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.451 -0400", hash_original_method = "80EC646A43ECE5B1A4600CE8EDDA24B3", hash_generated_method = "2134B144EDC2217937C142B26B41861C")
     void updateSelectorState() {
    if(mSelector != null)        
        {
    if(shouldShowSelector())            
            {
                mSelector.setState(getDrawableState());
            } 
            else
            {
                mSelector.setState(StateSet.NOTHING);
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.452 -0400", hash_original_method = "5700D7A450170541F2788B92612441B3", hash_generated_method = "A585E16DC9FBE9BA5368D986ED938050")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.452 -0400", hash_original_method = "1ED981B25374988410BBF6BB9A2499BB", hash_generated_method = "1D289073BD8CA0603CB58946F8D087FA")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        
        addTaint(extraSpace);
    if(mIsChildViewEnabled)        
        {
            int[] var66AAC6FF29C922B79B81CD6E0D9D06DC_711908890 = (super.onCreateDrawableState(extraSpace));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_569211523 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_569211523;
        } 
        final int enabledState = ENABLED_STATE_SET[0];
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        int enabledPos = -1;
for(int i = state.length - 1;i >= 0;i--)
        {
    if(state[i] == enabledState)            
            {
                enabledPos = i;
                break;
            } 
        } 
    if(enabledPos >= 0)        
        {
            System.arraycopy(state, enabledPos + 1, state, enabledPos,
                    state.length - enabledPos - 1);
        } 
        int[] var9ED39E2EA931586B6A985A6942EF573E_1426070721 = (state);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_116785132 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_116785132;
        
        
            
        
        
        
        
        
            
                
                
            
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.453 -0400", hash_original_method = "A6B05685C2044FBFF5332C34549C9055", hash_generated_method = "0428B2BC8C80945E3DC0CEE9AAADDA80")
    @Override
    public boolean verifyDrawable(Drawable dr) {
        addTaint(dr.getTaint());
        boolean varAD1BC9B7C355347B4655B336E1C15066_655477475 = (mSelector == dr || super.verifyDrawable(dr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438165280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438165280;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.453 -0400", hash_original_method = "7ED40C7CE5B566B3E07F33E9D37CCA58", hash_generated_method = "435DFA06ECB89A95191235B12D8F3D35")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    if(mSelector != null)        
        mSelector.jumpToCurrentState();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.454 -0400", hash_original_method = "0EB97D149DFA0037A8214EEEE413FBAC", hash_generated_method = "278A5CA744BB72A70E602D75C29DE5DB")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
    if(mTextFilterEnabled && mPopup != null && !mGlobalLayoutListenerAddedFilter)        
        {
            treeObserver.addOnGlobalLayoutListener(this);
        } 
    if(mAdapter != null && mDataSetObserver == null)        
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        } 
        mIsAttached = true;
        
        
        
        
        
            
        
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.455 -0400", hash_original_method = "91FA19273AD6EF1E2E7A8FCA605608DC", hash_generated_method = "73DE71C59336EA004D0ACC8F82F614B4")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        dismissPopup();
        mRecycler.clear();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.removeOnTouchModeChangeListener(this);
    if(mTextFilterEnabled && mPopup != null)        
        {
            treeObserver.removeGlobalOnLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = false;
        } 
    if(mAdapter != null)        
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        } 
    if(mScrollStrictSpan != null)        
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } 
    if(mFlingStrictSpan != null)        
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } 
    if(mFlingRunnable != null)        
        {
            removeCallbacks(mFlingRunnable);
        } 
    if(mPositionScroller != null)        
        {
            mPositionScroller.stop();
        } 
    if(mClearScrollingCache != null)        
        {
            removeCallbacks(mClearScrollingCache);
        } 
    if(mPerformClick != null)        
        {
            removeCallbacks(mPerformClick);
        } 
    if(mTouchModeReset != null)        
        {
            removeCallbacks(mTouchModeReset);
            mTouchModeReset = null;
        } 
        mIsAttached = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.456 -0400", hash_original_method = "F46E1D5E69E9A7961CEAA1CC31FCC74A", hash_generated_method = "81F6E67B8B50AFB1036FF430C04B8818")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        final int touchMode = isInTouchMode() ? TOUCH_MODE_ON : TOUCH_MODE_OFF;
    if(!hasWindowFocus)        
        {
            setChildrenDrawingCacheEnabled(false);
    if(mFlingRunnable != null)            
            {
                removeCallbacks(mFlingRunnable);
                mFlingRunnable.endFling();
    if(mPositionScroller != null)                
                {
                    mPositionScroller.stop();
                } 
    if(mScrollY != 0)                
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } 
            } 
            dismissPopup();
    if(touchMode == TOUCH_MODE_OFF)            
            {
                mResurrectToPosition = mSelectedPosition;
            } 
        } 
        else
        {
    if(mFiltered && !mPopupHidden)            
            {
                showPopup();
            } 
    if(touchMode != mLastTouchMode && mLastTouchMode != TOUCH_MODE_UNKNOWN)            
            {
    if(touchMode == TOUCH_MODE_OFF)                
                {
                    resurrectSelection();
                } 
                else
                {
                    hideSelector();
                    mLayoutMode = LAYOUT_NORMAL;
                    layoutChildren();
                } 
            } 
        } 
        mLastTouchMode = touchMode;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.457 -0400", hash_original_method = "5DA1B21EB8CB635B0040E7A9E537D496", hash_generated_method = "1A0B6E26AA8A640429379C38C0560EC0")
     ContextMenuInfo createContextMenuInfo(View view, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
ContextMenuInfo var47CD7FAF3662C47C984E7447764F3EAE_1968118289 =         new AdapterContextMenuInfo(view, position, id);
        var47CD7FAF3662C47C984E7447764F3EAE_1968118289.addTaint(taint);
        return var47CD7FAF3662C47C984E7447764F3EAE_1968118289;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.457 -0400", hash_original_method = "5D95BDE73AAD1EC9BDE83FD3189DFC34", hash_generated_method = "056E58C9A6C72D46E39BC89F0C82B8B9")
     boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId) {
    if(mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL)        
        {
    if(mChoiceActionMode == null &&
                    (mChoiceActionMode = startActionMode(mMultiChoiceModeCallback)) != null)            
            {
                setItemChecked(longPressPosition, true);
                performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            } 
            boolean varB326B5062B2F0E69046810717534CB09_2023336521 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346029304 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346029304;
        } 
        boolean handled = false;
    if(mOnItemLongClickListener != null)        
        {
            handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, child,
                    longPressPosition, longPressId);
        } 
    if(!handled)        
        {
            mContextMenuInfo = createContextMenuInfo(child, longPressPosition, longPressId);
            handled = super.showContextMenuForChild(AbsListView.this);
        } 
    if(handled)        
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1199098069 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735740000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735740000;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.458 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "BB0EB5BFC01EECE74C7DE3625D0AA90E")
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
ContextMenuInfo varE506317E2879F3E77DE1B46834975588_1081488229 =         mContextMenuInfo;
        varE506317E2879F3E77DE1B46834975588_1081488229.addTaint(taint);
        return varE506317E2879F3E77DE1B46834975588_1081488229;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.458 -0400", hash_original_method = "720F76E8125C4C6521A83756BA0DD98B", hash_generated_method = "C81702CDE616C934F0BA63C4429EF035")
    @Override
    public boolean showContextMenu(float x, float y, int metaState) {
        addTaint(metaState);
        addTaint(y);
        addTaint(x);
        final int position = pointToPosition((int)x, (int)y);
    if(position != INVALID_POSITION)        
        {
            final long id = mAdapter.getItemId(position);
            View child = getChildAt(position - mFirstPosition);
    if(child != null)            
            {
                mContextMenuInfo = createContextMenuInfo(child, position, id);
                boolean var4B3A49F17BEDB803A08329DA7FECEFEB_412631942 = (super.showContextMenuForChild(AbsListView.this));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369690850 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_369690850;
            } 
        } 
        boolean var2CE57A0D8C4730F9BEA81A50974FC905_208259718 = (super.showContextMenu(x, y, metaState));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064839953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064839953;
        
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.459 -0400", hash_original_method = "13B8C0CF7E224AA8E52D13CB23050F48", hash_generated_method = "CF456F3721E37376627E15632CD6F053")
    @Override
    public boolean showContextMenuForChild(View originalView) {
        addTaint(originalView.getTaint());
        final int longPressPosition = getPositionForView(originalView);
    if(longPressPosition >= 0)        
        {
            final long longPressId = mAdapter.getItemId(longPressPosition);
            boolean handled = false;
    if(mOnItemLongClickListener != null)            
            {
                handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, originalView,
                        longPressPosition, longPressId);
            } 
    if(!handled)            
            {
                mContextMenuInfo = createContextMenuInfo(
                        getChildAt(longPressPosition - mFirstPosition),
                        longPressPosition, longPressId);
                handled = super.showContextMenuForChild(originalView);
            } 
            boolean var98F0599AF776A1FE4101C199A40EEB8F_1869237558 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012991354 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012991354;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1911822939 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1882940431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1882940431;
        
        
        
            
            
            
                
                        
            
            
                
                        
                        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.459 -0400", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "D950197EA5B4041C1FDD1D27DE779A9B")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1299132801 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578953308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578953308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.460 -0400", hash_original_method = "DD8448F1B5F23CC0AD3E4D53FFC7D294", hash_generated_method = "5AEB8BFA12DEC1068B811ABDF8140943")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
    if(!isEnabled())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1144143193 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112491754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112491754;
        } 
    if(isClickable() && isPressed() &&
                    mSelectedPosition >= 0 && mAdapter != null &&
                    mSelectedPosition < mAdapter.getCount())        
        {
            final View view = getChildAt(mSelectedPosition - mFirstPosition);
    if(view != null)            
            {
                performItemClick(view, mSelectedPosition, mSelectedRowId);
                view.setPressed(false);
            } 
            setPressed(false);
            boolean varB326B5062B2F0E69046810717534CB09_1349331676 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690299481 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690299481;
        } 
        break;
}        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_679198141 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211003132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211003132;
        
        
        
        
            
                
            
            
                    
                    
                
                
                    
                    
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.460 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "083281D026E9BBF12BAB21E0084CD5D6")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.461 -0400", hash_original_method = "C5D265B49C06947929C542FAD6DD4910", hash_generated_method = "2CBCD308409071A0A3E85C975A02F985")
    public int pointToPosition(int x, int y) {
        addTaint(y);
        addTaint(x);
        Rect frame = mTouchFrame;
    if(frame == null)        
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } 
        final int count = getChildCount();
for(int i = count - 1;i >= 0;i--)
        {
            final View child = getChildAt(i);
    if(child.getVisibility() == View.VISIBLE)            
            {
                child.getHitRect(frame);
    if(frame.contains(x, y))                
                {
                    int varB4D2F09D0AD5244C9E57B5AF8AB759AE_2097368910 = (mFirstPosition + i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830426794 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830426794;
                } 
            } 
        } 
        int var296D6C732A05FBA51C5854FA7933FE23_353900415 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579263672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579263672;
        
        
        
            
            
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.461 -0400", hash_original_method = "0CE0E010C97C81E4AEC085897948D819", hash_generated_method = "5DAAA710F5522FAE7B3FD792B6F7A5C2")
    public long pointToRowId(int x, int y) {
        addTaint(y);
        addTaint(x);
        int position = pointToPosition(x, y);
    if(position >= 0)        
        {
            long varB9247D4F427D1E850A5AB9133BDCC8D5_1338191568 = (mAdapter.getItemId(position));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_999852475 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_999852475;
        } 
        long var38FBE1A15A33307A244C783BF4BC31A0_392550543 = (INVALID_ROW_ID);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1983107630 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1983107630;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.462 -0400", hash_original_method = "5EE86ADCFB65EEBAD1CBAFF86BFF869E", hash_generated_method = "2A31FB8B8E7252387830F4F38E3E5142")
    private boolean startScrollIfNeeded(int y) {
        addTaint(y);
        final int deltaY = y - mMotionY;
        final int distance = Math.abs(deltaY);
        final boolean overscroll = mScrollY != 0;
    if(overscroll || distance > mTouchSlop)        
        {
            createScrollingCache();
    if(overscroll)            
            {
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionCorrection = 0;
            } 
            else
            {
                mTouchMode = TOUCH_MODE_SCROLL;
                mMotionCorrection = deltaY > 0 ? mTouchSlop : -mTouchSlop;
            } 
            final Handler handler = getHandler();
    if(handler != null)            
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            setPressed(false);
            View motionView = getChildAt(mMotionPosition - mFirstPosition);
    if(motionView != null)            
            {
                motionView.setPressed(false);
            } 
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            final ViewParent parent = getParent();
    if(parent != null)            
            {
                parent.requestDisallowInterceptTouchEvent(true);
            } 
            scrollIfNeeded(y);
            boolean varB326B5062B2F0E69046810717534CB09_219220019 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245025082 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245025082;
        } 
        boolean var68934A3E9455FA72420237EB05902327_345014632 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806627275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806627275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.466 -0400", hash_original_method = "24BFB982D66DDF27FDD0EB3AFC04A401", hash_generated_method = "DD80DCDF46243B286D3622D7D5AB4A6B")
    private void scrollIfNeeded(int y) {
        final int rawDeltaY = y - mMotionY;
        final int deltaY = rawDeltaY - mMotionCorrection;
        int incrementalDeltaY = mLastY != Integer.MIN_VALUE ? y - mLastY : deltaY;
    if(mTouchMode == TOUCH_MODE_SCROLL)        
        {
    if(PROFILE_SCROLLING)            
            {
    if(!mScrollProfilingStarted)                
                {
                    Debug.startMethodTracing("AbsListViewScroll");
                    mScrollProfilingStarted = true;
                } 
            } 
    if(mScrollStrictSpan == null)            
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("AbsListView-scroll");
            } 
    if(y != mLastY)            
            {
    if((mGroupFlags & FLAG_DISALLOW_INTERCEPT) == 0 &&
                        Math.abs(rawDeltaY) > mTouchSlop)                
                {
                    final ViewParent parent = getParent();
    if(parent != null)                    
                    {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } 
                } 
                int motionIndex;
    if(mMotionPosition >= 0)                
                {
                    motionIndex = mMotionPosition - mFirstPosition;
                } 
                else
                {
                    motionIndex = getChildCount() / 2;
                } 
                int motionViewPrevTop = 0;
                View motionView = this.getChildAt(motionIndex);
    if(motionView != null)                
                {
                    motionViewPrevTop = motionView.getTop();
                } 
                boolean atEdge = false;
    if(incrementalDeltaY != 0)                
                {
                    atEdge = trackMotionScroll(deltaY, incrementalDeltaY);
                } 
                motionView = this.getChildAt(motionIndex);
    if(motionView != null)                
                {
                    final int motionViewRealTop = motionView.getTop();
    if(atEdge)                    
                    {
                        int overscroll = -incrementalDeltaY -
                                (motionViewRealTop - motionViewPrevTop);
                        overScrollBy(0, overscroll, 0, mScrollY, 0, 0,
                                0, mOverscrollDistance, true);
    if(Math.abs(mOverscrollDistance) == Math.abs(mScrollY))                        
                        {
    if(mVelocityTracker != null)                            
                            {
                                mVelocityTracker.clear();
                            } 
                        } 
                        final int overscrollMode = getOverScrollMode();
    if(overscrollMode == OVER_SCROLL_ALWAYS ||
                                (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                        !contentFits()))                        
                        {
                            mDirection = 0;
                            mTouchMode = TOUCH_MODE_OVERSCROLL;
    if(rawDeltaY > 0)                            
                            {
                                mEdgeGlowTop.onPull((float) overscroll / getHeight());
    if(!mEdgeGlowBottom.isFinished())                                
                                {
                                    mEdgeGlowBottom.onRelease();
                                } 
                            } 
                            else
    if(rawDeltaY < 0)                            
                            {
                                mEdgeGlowBottom.onPull((float) overscroll / getHeight());
    if(!mEdgeGlowTop.isFinished())                                
                                {
                                    mEdgeGlowTop.onRelease();
                                } 
                            } 
                        } 
                    } 
                    mMotionY = y;
                    invalidate();
                } 
                mLastY = y;
            } 
        } 
        else
    if(mTouchMode == TOUCH_MODE_OVERSCROLL)        
        {
    if(y != mLastY)            
            {
                final int oldScroll = mScrollY;
                final int newScroll = oldScroll - incrementalDeltaY;
                int newDirection = y > mLastY ? 1 : -1;
    if(mDirection == 0)                
                {
                    mDirection = newDirection;
                } 
                int overScrollDistance = -incrementalDeltaY;
    if((newScroll < 0 && oldScroll >= 0) || (newScroll > 0 && oldScroll <= 0))                
                {
                    overScrollDistance = -oldScroll;
                    incrementalDeltaY += overScrollDistance;
                } 
                else
                {
                    incrementalDeltaY = 0;
                } 
    if(overScrollDistance != 0)                
                {
                    overScrollBy(0, overScrollDistance, 0, mScrollY, 0, 0,
                            0, mOverscrollDistance, true);
                    final int overscrollMode = getOverScrollMode();
    if(overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                    !contentFits()))                    
                    {
    if(rawDeltaY > 0)                        
                        {
                            mEdgeGlowTop.onPull((float) overScrollDistance / getHeight());
    if(!mEdgeGlowBottom.isFinished())                            
                            {
                                mEdgeGlowBottom.onRelease();
                            } 
                        } 
                        else
    if(rawDeltaY < 0)                        
                        {
                            mEdgeGlowBottom.onPull((float) overScrollDistance / getHeight());
    if(!mEdgeGlowTop.isFinished())                            
                            {
                                mEdgeGlowTop.onRelease();
                            } 
                        } 
                        invalidate();
                    } 
                } 
    if(incrementalDeltaY != 0)                
                {
                    mScrollY = 0;
                    invalidateParentIfNeeded();
    if(incrementalDeltaY != 0)                    
                    {
                        trackMotionScroll(incrementalDeltaY, incrementalDeltaY);
                    } 
                    mTouchMode = TOUCH_MODE_SCROLL;
                    final int motionPosition = findClosestMotionRow(y);
                    mMotionCorrection = 0;
                    View motionView = getChildAt(motionPosition - mFirstPosition);
                    mMotionViewOriginalTop = motionView != null ? motionView.getTop() : 0;
                    mMotionY = y;
                    mMotionPosition = motionPosition;
                } 
                mLastY = y;
                mDirection = newDirection;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.467 -0400", hash_original_method = "6F0203AFDEF2DCB43412C3F5E7A63F8C", hash_generated_method = "A95D704899DE277B4FE8712D9E2D1E69")
    public void onTouchModeChanged(boolean isInTouchMode) {
        
        addTaint(isInTouchMode);
    if(isInTouchMode)        
        {
            hideSelector();
    if(getHeight() > 0 && getChildCount() > 0)            
            {
                layoutChildren();
            } 
            updateSelectorState();
        } 
        else
        {
            int touchMode = mTouchMode;
    if(touchMode == TOUCH_MODE_OVERSCROLL || touchMode == TOUCH_MODE_OVERFLING)            
            {
    if(mFlingRunnable != null)                
                {
                    mFlingRunnable.endFling();
                } 
    if(mPositionScroller != null)                
                {
                    mPositionScroller.stop();
                } 
    if(mScrollY != 0)                
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.475 -0400", hash_original_method = "EC498F7AA9A002C93696F04D5F90A9F2", hash_generated_method = "9DF61DC7C98C82BE852104005E18ED33")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
    if(!isEnabled())        
        {
            boolean var54A2EB08B4EA0140209C589923D931E8_770475687 = (isClickable() || isLongClickable());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495472701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495472701;
        } 
    if(mFastScroller != null)        
        {
            boolean intercepted = mFastScroller.onTouchEvent(ev);
    if(intercepted)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1617783646 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586146121 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_586146121;
            } 
        } 
        final int action = ev.getAction();
        View v;
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
        {
switch(mTouchMode){
            case TOUCH_MODE_OVERFLING:
            {
                mFlingRunnable.endFling();
    if(mPositionScroller != null)                
                {
                    mPositionScroller.stop();
                } 
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionX = (int) ev.getX();
                mMotionY = mLastY = (int) ev.getY();
                mMotionCorrection = 0;
                mActivePointerId = ev.getPointerId(0);
                mDirection = 0;
                break;
            } 
            default:
            {
                mActivePointerId = ev.getPointerId(0);
                final int x = (int) ev.getX();
                final int y = (int) ev.getY();
                int motionPosition = pointToPosition(x, y);
    if(!mDataChanged)                
                {
    if((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0)
                            && (getAdapter().isEnabled(motionPosition)))                    
                    {
                        mTouchMode = TOUCH_MODE_DOWN;
    if(mPendingCheckForTap == null)                        
                        {
                            mPendingCheckForTap = new CheckForTap();
                        } 
                        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } 
                    else
                    {
    if(mTouchMode == TOUCH_MODE_FLING)                        
                        {
                            createScrollingCache();
                            mTouchMode = TOUCH_MODE_SCROLL;
                            mMotionCorrection = 0;
                            motionPosition = findMotionRow(y);
                            mFlingRunnable.flywheelTouch();
                        } 
                    } 
                } 
    if(motionPosition >= 0)                
                {
                    v = getChildAt(motionPosition - mFirstPosition);
                    mMotionViewOriginalTop = v.getTop();
                } 
                mMotionX = x;
                mMotionY = y;
                mMotionPosition = motionPosition;
                mLastY = Integer.MIN_VALUE;
                break;
            } 
}    if(performButtonActionOnTouchDown(ev))            
            {
    if(mTouchMode == TOUCH_MODE_DOWN)                
                {
                    removeCallbacks(mPendingCheckForTap);
                } 
            } 
            break;
        } 
        case MotionEvent.ACTION_MOVE:
        {
            int pointerIndex = ev.findPointerIndex(mActivePointerId);
    if(pointerIndex == -1)            
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } 
            final int y = (int) ev.getY(pointerIndex);
switch(mTouchMode){
            case TOUCH_MODE_DOWN:
            case TOUCH_MODE_TAP:
            case TOUCH_MODE_DONE_WAITING:
            startScrollIfNeeded(y);
            break;
            case TOUCH_MODE_SCROLL:
            case TOUCH_MODE_OVERSCROLL:
            scrollIfNeeded(y);
            break;
}            break;
        } 
        case MotionEvent.ACTION_UP:
        {
switch(mTouchMode){
            case TOUCH_MODE_DOWN:
            case TOUCH_MODE_TAP:
            case TOUCH_MODE_DONE_WAITING:
            final int motionPosition = mMotionPosition;
            final View child = getChildAt(motionPosition - mFirstPosition);
            final float x = ev.getX();
            final boolean inList = x > mListPadding.left && x < getWidth() - mListPadding.right;
    if(child != null && !child.hasFocusable() && inList)            
            {
    if(mTouchMode != TOUCH_MODE_DOWN)                
                {
                    child.setPressed(false);
                } 
    if(mPerformClick == null)                
                {
                    mPerformClick = new PerformClick();
                } 
                final AbsListView.PerformClick performClick = mPerformClick;
                performClick.mClickMotionPosition = motionPosition;
                performClick.rememberWindowAttachCount();
                mResurrectToPosition = motionPosition;
    if(mTouchMode == TOUCH_MODE_DOWN || mTouchMode == TOUCH_MODE_TAP)                
                {
                    final Handler handler = getHandler();
    if(handler != null)                    
                    {
                        handler.removeCallbacks(mTouchMode == TOUCH_MODE_DOWN ?
                                    mPendingCheckForTap : mPendingCheckForLongPress);
                    } 
                    mLayoutMode = LAYOUT_NORMAL;
    if(!mDataChanged && mAdapter.isEnabled(motionPosition))                    
                    {
                        mTouchMode = TOUCH_MODE_TAP;
                        setSelectedPositionInt(mMotionPosition);
                        layoutChildren();
                        child.setPressed(true);
                        positionSelector(mMotionPosition, child);
                        setPressed(true);
    if(mSelector != null)                        
                        {
                            Drawable d = mSelector.getCurrent();
    if(d != null && d instanceof TransitionDrawable)                            
                            {
                                ((TransitionDrawable) d).resetTransition();
                            } 
                        } 
    if(mTouchModeReset != null)                        
                        {
                            removeCallbacks(mTouchModeReset);
                        } 
                        mTouchModeReset = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.473 -0400", hash_original_method = "A6EC1D4E4E60E1E8895C51DF141E43B7", hash_generated_method = "130C723B6BCFCD9C686506D4E1F23A39")
        @Override
        public void run() {
            mTouchMode = TOUCH_MODE_REST;
            child.setPressed(false);
            setPressed(false);
    if(!mDataChanged)            
            {
                performClick.run();
            } 
            
            
            
            
            
                                        
                                    
        }
};
                        postDelayed(mTouchModeReset,
                                    ViewConfiguration.getPressedStateDuration());
                    } 
                    else
                    {
                        mTouchMode = TOUCH_MODE_REST;
                        updateSelectorState();
                    } 
                    boolean varB326B5062B2F0E69046810717534CB09_1855996166 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83176854 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_83176854;
                } 
                else
    if(!mDataChanged && mAdapter.isEnabled(motionPosition))                
                {
                    performClick.run();
                } 
            } 
            mTouchMode = TOUCH_MODE_REST;
            updateSelectorState();
            break;
            case TOUCH_MODE_SCROLL:
            final int childCount = getChildCount();
    if(childCount > 0)            
            {
                final int firstChildTop = getChildAt(0).getTop();
                final int lastChildBottom = getChildAt(childCount - 1).getBottom();
                final int contentTop = mListPadding.top;
                final int contentBottom = getHeight() - mListPadding.bottom;
    if(mFirstPosition == 0 && firstChildTop >= contentTop &&
                            mFirstPosition + childCount < mItemCount &&
                            lastChildBottom <= getHeight() - contentBottom)                
                {
                    mTouchMode = TOUCH_MODE_REST;
                    reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } 
                else
                {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    final int initialVelocity = (int)
                                (velocityTracker.getYVelocity(mActivePointerId) * mVelocityScale);
    if(Math.abs(initialVelocity) > mMinimumVelocity &&
                                !((mFirstPosition == 0 &&
                                        firstChildTop == contentTop - mOverscrollDistance) ||
                                  (mFirstPosition + childCount == mItemCount &&
                                        lastChildBottom == contentBottom + mOverscrollDistance)))                    
                    {
    if(mFlingRunnable == null)                        
                        {
                            mFlingRunnable = new FlingRunnable();
                        } 
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                        mFlingRunnable.start(-initialVelocity);
                    } 
                    else
                    {
                        mTouchMode = TOUCH_MODE_REST;
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
    if(mFlingRunnable != null)                        
                        {
                            mFlingRunnable.endFling();
                        } 
    if(mPositionScroller != null)                        
                        {
                            mPositionScroller.stop();
                        } 
                    } 
                } 
            } 
            else
            {
                mTouchMode = TOUCH_MODE_REST;
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } 
            break;
            case TOUCH_MODE_OVERSCROLL:
    if(mFlingRunnable == null)            
            {
                mFlingRunnable = new FlingRunnable();
            } 
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            final int initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
    if(Math.abs(initialVelocity) > mMinimumVelocity)            
            {
                mFlingRunnable.startOverfling(-initialVelocity);
            } 
            else
            {
                mFlingRunnable.startSpringback();
            } 
            break;
}            setPressed(false);
    if(mEdgeGlowTop != null)            
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } 
            invalidate();
            final Handler handler = getHandler();
    if(handler != null)            
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            recycleVelocityTracker();
            mActivePointerId = INVALID_POINTER;
    if(PROFILE_SCROLLING)            
            {
    if(mScrollProfilingStarted)                
                {
                    Debug.stopMethodTracing();
                    mScrollProfilingStarted = false;
                } 
            } 
    if(mScrollStrictSpan != null)            
            {
                mScrollStrictSpan.finish();
                mScrollStrictSpan = null;
            } 
            break;
        } 
        case MotionEvent.ACTION_CANCEL:
        {
switch(mTouchMode){
            case TOUCH_MODE_OVERSCROLL:
    if(mFlingRunnable == null)            
            {
                mFlingRunnable = new FlingRunnable();
            } 
            mFlingRunnable.startSpringback();
            break;
            case TOUCH_MODE_OVERFLING:
            break;
            default:
            mTouchMode = TOUCH_MODE_REST;
            setPressed(false);
            View motionView = this.getChildAt(mMotionPosition - mFirstPosition);
    if(motionView != null)            
            {
                motionView.setPressed(false);
            } 
            clearScrollingCache();
            final Handler handler = getHandler();
    if(handler != null)            
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            recycleVelocityTracker();
}    if(mEdgeGlowTop != null)            
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } 
            mActivePointerId = INVALID_POINTER;
            break;
        } 
        case MotionEvent.ACTION_POINTER_UP:
        {
            onSecondaryPointerUp(ev);
            final int x = mMotionX;
            final int y = mMotionY;
            final int motionPosition = pointToPosition(x, y);
    if(motionPosition >= 0)            
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } 
            mLastY = y;
            break;
        } 
        case MotionEvent.ACTION_POINTER_DOWN:
        {
            final int index = ev.getActionIndex();
            final int id = ev.getPointerId(index);
            final int x = (int) ev.getX(index);
            final int y = (int) ev.getY(index);
            mMotionCorrection = 0;
            mActivePointerId = id;
            mMotionX = x;
            mMotionY = y;
            final int motionPosition = pointToPosition(x, y);
    if(motionPosition >= 0)            
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } 
            mLastY = y;
            break;
        } 
}        boolean varB326B5062B2F0E69046810717534CB09_576216924 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106624577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106624577;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.476 -0400", hash_original_method = "3A1744A3CB770F6FD9FFEB222E666622", hash_generated_method = "4AE89664E6E4AC880CDCFC6C09CAB336")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        
        addTaint(clampedY);
        addTaint(clampedX);
        addTaint(scrollY);
        addTaint(scrollX);
    if(mScrollY != scrollY)        
        {
            onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            awakenScrollBars();
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.477 -0400", hash_original_method = "09132BF5E477A2B233231E384E8A2F27", hash_generated_method = "B53848550F4D449723EED5CA1BA43D86")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
    if((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
switch(event.getAction()){
            case MotionEvent.ACTION_SCROLL:
            {
    if(mTouchMode == TOUCH_MODE_REST)                
                {
                    final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
    if(vscroll != 0)                    
                    {
                        final int delta = (int) (vscroll * getVerticalScrollFactor());
    if(!trackMotionScroll(delta, delta))                        
                        {
                            boolean varB326B5062B2F0E69046810717534CB09_1876163966 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979810536 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_979810536;
                        } 
                    } 
                } 
            } 
}
        } 
        boolean var3B54C423A43BA14BBEA440506237FA4B_1036688339 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895764913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895764913;
        
        
            
                
                    
                        
                        
                            
                            
                                
                            
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.477 -0400", hash_original_method = "F146D016CF32B873211A043EDB782604", hash_generated_method = "1D90E338CB2930FBD42F968D4C5A2F76")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.draw(canvas);
    if(mEdgeGlowTop != null)        
        {
            final int scrollY = mScrollY;
    if(!mEdgeGlowTop.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int leftPadding = mListPadding.left + mGlowPaddingLeft;
                final int rightPadding = mListPadding.right + mGlowPaddingRight;
                final int width = getWidth() - leftPadding - rightPadding;
                canvas.translate(leftPadding,
                        Math.min(0, scrollY + mFirstPositionDistanceGuess));
                mEdgeGlowTop.setSize(width, getHeight());
    if(mEdgeGlowTop.draw(canvas))                
                {
                    invalidate();
                } 
                canvas.restoreToCount(restoreCount);
            } 
    if(!mEdgeGlowBottom.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int leftPadding = mListPadding.left + mGlowPaddingLeft;
                final int rightPadding = mListPadding.right + mGlowPaddingRight;
                final int width = getWidth() - leftPadding - rightPadding;
                final int height = getHeight();
                canvas.translate(-width + leftPadding,
                        Math.max(height, scrollY + mLastPositionDistanceGuess));
                canvas.rotate(180, width, 0);
                mEdgeGlowBottom.setSize(width, height);
    if(mEdgeGlowBottom.draw(canvas))                
                {
                    invalidate();
                } 
                canvas.restoreToCount(restoreCount);
            } 
        } 
    if(mFastScroller != null)        
        {
            final int scrollY = mScrollY;
    if(scrollY != 0)            
            {
                int restoreCount = canvas.save();
                canvas.translate(0, (float) scrollY);
                mFastScroller.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } 
            else
            {
                mFastScroller.draw(canvas);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.477 -0400", hash_original_method = "9FFFDAFD9442A3DE6BE69946897AC2B3", hash_generated_method = "763087F4905BF1A44B4D70DFA37C4F6C")
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding) {
        mGlowPaddingLeft = leftPadding;
        mGlowPaddingRight = rightPadding;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.477 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "E6A2459F70C94EEE4F8E0DC05B01F193")
    private void initOrResetVelocityTracker() {
    if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        else
        {
            mVelocityTracker.clear();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.478 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "2B8D7737D5D71D4902AEB864DE542716")
    private void initVelocityTrackerIfNotExists() {
    if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.478 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "701A7C43D055D340A0D18EE9D957EDFF")
    private void recycleVelocityTracker() {
    if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.478 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "0484ACC96D68F9484E340AA90FA16493")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
    if(disallowIntercept)        
        {
            recycleVelocityTracker();
        } 
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.478 -0400", hash_original_method = "BEACBA96FA37C833811279893053B3A1", hash_generated_method = "EB032364C4EE9FFDEC03677B41BC0873")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        int action = ev.getAction();
        View v;
    if(mFastScroller != null)        
        {
            boolean intercepted = mFastScroller.onInterceptTouchEvent(ev);
    if(intercepted)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_519027310 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661364994 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_661364994;
            } 
        } 
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
        {
            int touchMode = mTouchMode;
    if(touchMode == TOUCH_MODE_OVERFLING || touchMode == TOUCH_MODE_OVERSCROLL)            
            {
                mMotionCorrection = 0;
                boolean varB326B5062B2F0E69046810717534CB09_152070098 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165581410 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_165581410;
            } 
            final int x = (int) ev.getX();
            final int y = (int) ev.getY();
            mActivePointerId = ev.getPointerId(0);
            int motionPosition = findMotionRow(y);
    if(touchMode != TOUCH_MODE_FLING && motionPosition >= 0)            
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionX = x;
                mMotionY = y;
                mMotionPosition = motionPosition;
                mTouchMode = TOUCH_MODE_DOWN;
                clearScrollingCache();
            } 
            mLastY = Integer.MIN_VALUE;
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(ev);
    if(touchMode == TOUCH_MODE_FLING)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_631273422 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144737491 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144737491;
            } 
            break;
        } 
        case MotionEvent.ACTION_MOVE:
        {
switch(mTouchMode){
            case TOUCH_MODE_DOWN:
            int pointerIndex = ev.findPointerIndex(mActivePointerId);
    if(pointerIndex == -1)            
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } 
            final int y = (int) ev.getY(pointerIndex);
            initVelocityTrackerIfNotExists();
            mVelocityTracker.addMovement(ev);
    if(startScrollIfNeeded(y))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_91189150 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001775977 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001775977;
            } 
            break;
}            break;
        } 
        case MotionEvent.ACTION_CANCEL:
        case MotionEvent.ACTION_UP:
        {
            mTouchMode = TOUCH_MODE_REST;
            mActivePointerId = INVALID_POINTER;
            recycleVelocityTracker();
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            break;
        } 
        case MotionEvent.ACTION_POINTER_UP:
        {
            onSecondaryPointerUp(ev);
            break;
        } 
}        boolean var68934A3E9455FA72420237EB05902327_961094114 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873238336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873238336;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.479 -0400", hash_original_method = "C5DD3809C32C06AD527DF2275274EBCF", hash_generated_method = "F4BAAC931B8916D72C1ABDB8DE80F1D9")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
    if(pointerId == mActivePointerId)        
        {
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mMotionX = (int) ev.getX(newPointerIndex);
            mMotionY = (int) ev.getY(newPointerIndex);
            mMotionCorrection = 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
        } 
        
        
                
        
        
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.479 -0400", hash_original_method = "7406EAB31F4F45208F8FFDB2641D9148", hash_generated_method = "9A43D4C41DE50A3FD03F74A2647BEBA9")
    @Override
    public void addTouchables(ArrayList<View> views) {
        addTaint(views.getTaint());
        final int count = getChildCount();
        final int firstPosition = mFirstPosition;
        final ListAdapter adapter = mAdapter;
    if(adapter == null)        
        {
            return;
        } 
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
    if(adapter.isEnabled(firstPosition + i))            
            {
                views.add(child);
            } 
            child.addTouchables(views);
        } 
        
        
        
        
        
            
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.479 -0400", hash_original_method = "53B60DC92C627A12BA76D6AAFD79D448", hash_generated_method = "1F554B33FBDFC0FDE414C52F58ED1EE7")
     void reportScrollStateChange(int newState) {
    if(newState != mLastScrollState)        
        {
    if(mOnScrollListener != null)            
            {
                mLastScrollState = newState;
                mOnScrollListener.onScrollStateChanged(this, newState);
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.479 -0400", hash_original_method = "09656A4DFD81148F85DAB6B80BBEDF83", hash_generated_method = "1A95BC2777EB34DB7331B3F91A608F40")
    public void setFriction(float friction) {
        addTaint(friction);
    if(mFlingRunnable == null)        
        {
            mFlingRunnable = new FlingRunnable();
        } 
        mFlingRunnable.mScroller.setFriction(friction);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "0A97F6C2B71DEE1A9A851FDFBE6F2171", hash_generated_method = "22912162971CDA2675BA2D8F41874A24")
    public void setVelocityScale(float scale) {
        mVelocityScale = scale;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "5ADECEDEBCB45348FEE18FEA2660C669", hash_generated_method = "584073E65D6B812C435658DDCD638CC8")
    public void smoothScrollToPosition(int position) {
        addTaint(position);
    if(mPositionScroller == null)        
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.start(position);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "8931967DEF21C4BF02F7EE5F6DA25484", hash_generated_method = "267227AD923D9B7A14163FAD7CA0337F")
    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        addTaint(duration);
        addTaint(offset);
        addTaint(position);
    if(mPositionScroller == null)        
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.startWithOffset(position, offset, duration);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "481FD979A7BEB05C5D5FED69D6209380", hash_generated_method = "D9793D12C9E6B78158DDFD2F6C750A4A")
    public void smoothScrollToPositionFromTop(int position, int offset) {
        addTaint(offset);
        addTaint(position);
    if(mPositionScroller == null)        
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.startWithOffset(position, offset);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "D55175FA7A4D56B1E1633A69B89BF26C", hash_generated_method = "30D3A8BCD6FB6E47660501F75490329D")
    public void smoothScrollToPosition(int position, int boundPosition) {
        addTaint(boundPosition);
        addTaint(position);
    if(mPositionScroller == null)        
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.start(position, boundPosition);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.480 -0400", hash_original_method = "F38F4C8B27D75B9B07425BD626A4F57B", hash_generated_method = "2587F0C5DDA8D1AC96DEE0CCC1F76D26")
    public void smoothScrollBy(int distance, int duration) {
        addTaint(duration);
        addTaint(distance);
    if(mFlingRunnable == null)        
        {
            mFlingRunnable = new FlingRunnable();
        } 
        final int firstPos = mFirstPosition;
        final int childCount = getChildCount();
        final int lastPos = firstPos + childCount;
        final int topLimit = getPaddingTop();
        final int bottomLimit = getHeight() - getPaddingBottom();
    if(distance == 0 || mItemCount == 0 || childCount == 0 ||
                (firstPos == 0 && getChildAt(0).getTop() == topLimit && distance < 0) ||
                (lastPos == mItemCount - 1 &&
                        getChildAt(childCount - 1).getBottom() == bottomLimit && distance > 0))        
        {
            mFlingRunnable.endFling();
    if(mPositionScroller != null)            
            {
                mPositionScroller.stop();
            } 
        } 
        else
        {
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
            mFlingRunnable.startScroll(distance, duration);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.481 -0400", hash_original_method = "C17AB5094757737D3C9F6E76AFA310E4", hash_generated_method = "71BC307AFE1596B9A578AF0AC6234FE4")
     void smoothScrollByOffset(int position) {
        addTaint(position);
        int index = -1;
    if(position < 0)        
        {
            index = getFirstVisiblePosition();
        } 
        else
    if(position > 0)        
        {
            index = getLastVisiblePosition();
        } 
    if(index > -1)        
        {
            View child = getChildAt(index - getFirstVisiblePosition());
    if(child != null)            
            {
                Rect visibleRect = new Rect();
    if(child.getGlobalVisibleRect(visibleRect))                
                {
                    int childRectArea = child.getWidth() * child.getHeight();
                    int visibleRectArea = visibleRect.width() * visibleRect.height();
                    float visibleArea = (visibleRectArea / (float) childRectArea);
                    final float visibleThreshold = 0.75f;
    if((position < 0) && (visibleArea < visibleThreshold))                    
                    {
                        ++index;
                    } 
                    else
    if((position > 0) && (visibleArea < visibleThreshold))                    
                    {
                        --index;
                    } 
                } 
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), index + position)));
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.481 -0400", hash_original_method = "81BA0C283B501CA4B76891C73CF6304F", hash_generated_method = "89B31C88C1D3E01037CF07ED6EEF9849")
    private void createScrollingCache() {
    if(mScrollingCacheEnabled && !mCachingStarted)        
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingStarted = mCachingActive = true;
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.481 -0400", hash_original_method = "5EE1F7DCF1506371E8A50F14184A0F0B", hash_generated_method = "1E03B437739354F0EA44CFDA6DA37134")
    private void clearScrollingCache() {
    if(mClearScrollingCache == null)        
        {
            mClearScrollingCache = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.481 -0400", hash_original_method = "C1A06A57DD958FE417CF10EBDAA96EFE", hash_generated_method = "FD7B7C6070920041CF4829F5B9BC56EF")
        public void run() {
    if(mCachingStarted)            
            {
                mCachingStarted = mCachingActive = false;
                setChildrenDrawnWithCacheEnabled(false);
    if((mPersistentDrawingCache & PERSISTENT_SCROLLING_CACHE) == 0)                
                {
                    setChildrenDrawingCacheEnabled(false);
                } 
    if(!isAlwaysDrawnWithCacheEnabled())                
                {
                    invalidate();
                } 
            } 
            
            
                        
                        
                        
                            
                        
                        
                            
                        
                    
        }
};
        } 
        post(mClearScrollingCache);
        
        
            
                
                    
                        
                        
                        
                            
                        
                        
                            
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.483 -0400", hash_original_method = "A42371BB3F2D334094B7131C15A0F3E8", hash_generated_method = "A650AE477E5BCA07E74AB9B080AB95B3")
     boolean trackMotionScroll(int deltaY, int incrementalDeltaY) {
        final int childCount = getChildCount();
    if(childCount == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1988261014 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053122699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053122699;
        } 
        final int firstTop = getChildAt(0).getTop();
        final int lastBottom = getChildAt(childCount - 1).getBottom();
        final Rect listPadding = mListPadding;
        int effectivePaddingTop = 0;
        int effectivePaddingBottom = 0;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)        
        {
            effectivePaddingTop = listPadding.top;
            effectivePaddingBottom = listPadding.bottom;
        } 
        final int spaceAbove = effectivePaddingTop - firstTop;
        final int end = getHeight() - effectivePaddingBottom;
        final int spaceBelow = lastBottom - end;
        final int height = getHeight() - mPaddingBottom - mPaddingTop;
    if(deltaY < 0)        
        {
            deltaY = Math.max(-(height - 1), deltaY);
        } 
        else
        {
            deltaY = Math.min(height - 1, deltaY);
        } 
    if(incrementalDeltaY < 0)        
        {
            incrementalDeltaY = Math.max(-(height - 1), incrementalDeltaY);
        } 
        else
        {
            incrementalDeltaY = Math.min(height - 1, incrementalDeltaY);
        } 
        final int firstPosition = mFirstPosition;
    if(firstPosition == 0)        
        {
            mFirstPositionDistanceGuess = firstTop - listPadding.top;
        } 
        else
        {
            mFirstPositionDistanceGuess += incrementalDeltaY;
        } 
    if(firstPosition + childCount == mItemCount)        
        {
            mLastPositionDistanceGuess = lastBottom + listPadding.bottom;
        } 
        else
        {
            mLastPositionDistanceGuess += incrementalDeltaY;
        } 
        final boolean cannotScrollDown = (firstPosition == 0 &&
                firstTop >= listPadding.top && incrementalDeltaY >= 0);
        final boolean cannotScrollUp = (firstPosition + childCount == mItemCount &&
                lastBottom <= getHeight() - listPadding.bottom && incrementalDeltaY <= 0);
    if(cannotScrollDown || cannotScrollUp)        
        {
            boolean varEC163E888202DAD1588BED3D66FBF348_2013110776 = (incrementalDeltaY != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388714705 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_388714705;
        } 
        final boolean down = incrementalDeltaY < 0;
        final boolean inTouchMode = isInTouchMode();
    if(inTouchMode)        
        {
            hideSelector();
        } 
        final int headerViewsCount = getHeaderViewsCount();
        final int footerViewsStart = mItemCount - getFooterViewsCount();
        int start = 0;
        int count = 0;
    if(down)        
        {
            int top = -incrementalDeltaY;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)            
            {
                top += listPadding.top;
            } 
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
    if(child.getBottom() >= top)                
                {
                    break;
                } 
                else
                {
                    count++;
                    int position = firstPosition + i;
    if(position >= headerViewsCount && position < footerViewsStart)                    
                    {
                        mRecycler.addScrapView(child, position);
    if(ViewDebug.TRACE_RECYCLER)                        
                        {
                            ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                        } 
                    } 
                } 
            } 
        } 
        else
        {
            int bottom = getHeight() - incrementalDeltaY;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)            
            {
                bottom -= listPadding.bottom;
            } 
for(int i = childCount - 1;i >= 0;i--)
            {
                final View child = getChildAt(i);
    if(child.getTop() <= bottom)                
                {
                    break;
                } 
                else
                {
                    start = i;
                    count++;
                    int position = firstPosition + i;
    if(position >= headerViewsCount && position < footerViewsStart)                    
                    {
                        mRecycler.addScrapView(child, position);
    if(ViewDebug.TRACE_RECYCLER)                        
                        {
                            ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                        } 
                    } 
                } 
            } 
        } 
        mMotionViewNewTop = mMotionViewOriginalTop + deltaY;
        mBlockLayoutRequests = true;
    if(count > 0)        
        {
            detachViewsFromParent(start, count);
        } 
        offsetChildrenTopAndBottom(incrementalDeltaY);
    if(down)        
        {
            mFirstPosition += count;
        } 
        invalidate();
        final int absIncrementalDeltaY = Math.abs(incrementalDeltaY);
    if(spaceAbove < absIncrementalDeltaY || spaceBelow < absIncrementalDeltaY)        
        {
            fillGap(down);
        } 
    if(!inTouchMode && mSelectedPosition != INVALID_POSITION)        
        {
            final int childIndex = mSelectedPosition - mFirstPosition;
    if(childIndex >= 0 && childIndex < getChildCount())            
            {
                positionSelector(mSelectedPosition, getChildAt(childIndex));
            } 
        } 
        else
    if(mSelectorPosition != INVALID_POSITION)        
        {
            final int childIndex = mSelectorPosition - mFirstPosition;
    if(childIndex >= 0 && childIndex < getChildCount())            
            {
                positionSelector(INVALID_POSITION, getChildAt(childIndex));
            } 
        } 
        else
        {
            mSelectorRect.setEmpty();
        } 
        mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        awakenScrollBars();
        boolean var68934A3E9455FA72420237EB05902327_1318402501 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689347223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689347223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.483 -0400", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "E6C9B6BEE4E0A36DD8559B7C49021F8B")
     int getHeaderViewsCount() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1996360105 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257530414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257530414;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.483 -0400", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "BCAF29830ABAB25468EB75C4FCA57824")
     int getFooterViewsCount() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1842176323 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785433130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785433130;
        
        
    }

    
    abstract void fillGap(boolean down);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.483 -0400", hash_original_method = "01CAE4EB89DA7F2FB8FB8C551B8C7558", hash_generated_method = "DDC9FA68FE9DC9A0220BF691F97CF05B")
     void hideSelector() {
    if(mSelectedPosition != INVALID_POSITION)        
        {
    if(mLayoutMode != LAYOUT_SPECIFIC)            
            {
                mResurrectToPosition = mSelectedPosition;
            } 
    if(mNextSelectedPosition >= 0 && mNextSelectedPosition != mSelectedPosition)            
            {
                mResurrectToPosition = mNextSelectedPosition;
            } 
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectedTop = 0;
        } 
        
        
            
                
            
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.484 -0400", hash_original_method = "3C42E05D1FE66CE321CE689DCD7609AF", hash_generated_method = "E19C6737C7C346B0A70A39D6E876A90A")
     int reconcileSelectedPosition() {
        int position = mSelectedPosition;
    if(position < 0)        
        {
            position = mResurrectToPosition;
        } 
        position = Math.max(0, position);
        position = Math.min(position, mItemCount - 1);
        int var4757FE07FD492A8BE0EA6A760D683D6E_511504262 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929882548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929882548;
        
        
        
            
        
        
        
        
    }

    
    abstract int findMotionRow(int y);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.484 -0400", hash_original_method = "620BFFA3FACC4E59D7B8719ED5062EB2", hash_generated_method = "D63AF17A0A1C32F986FF98FAABBFDA03")
     int findClosestMotionRow(int y) {
        addTaint(y);
        final int childCount = getChildCount();
    if(childCount == 0)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_1942146817 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055358905 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055358905;
        } 
        final int motionRow = findMotionRow(y);
        int varCA4499DEE38CFB82A88C93D55A879C92_894333025 = (motionRow != INVALID_POSITION ? motionRow : mFirstPosition + childCount - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263941637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263941637;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.484 -0400", hash_original_method = "48746A94CCDD3AA210B8334DFA5415FB", hash_generated_method = "60F28DC437B80BF897562B54CF102004")
    public void invalidateViews() {
        mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.484 -0400", hash_original_method = "DCA216018FB5348F17E51D7322AEEFD4", hash_generated_method = "CB66159EE6A6D6354D681C85034EC9EB")
     boolean resurrectSelectionIfNeeded() {
    if(mSelectedPosition < 0 && resurrectSelection())        
        {
            updateSelectorState();
            boolean varB326B5062B2F0E69046810717534CB09_167628785 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618260605 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618260605;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1310110984 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863893925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863893925;
        
        
            
            
        
        
    }

    
    abstract void setSelectionInt(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.486 -0400", hash_original_method = "46DC118C185645539DC69AE3B021DB61", hash_generated_method = "F34B8B8D452ED6395D4D13A9A8F7ADA6")
     boolean resurrectSelection() {
        final int childCount = getChildCount();
    if(childCount <= 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_603710424 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566764553 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_566764553;
        } 
        int selectedTop = 0;
        int selectedPos;
        int childrenTop = mListPadding.top;
        int childrenBottom = mBottom - mTop - mListPadding.bottom;
        final int firstPosition = mFirstPosition;
        final int toPosition = mResurrectToPosition;
        boolean down = true;
    if(toPosition >= firstPosition && toPosition < firstPosition + childCount)        
        {
            selectedPos = toPosition;
            final View selected = getChildAt(selectedPos - mFirstPosition);
            selectedTop = selected.getTop();
            int selectedBottom = selected.getBottom();
    if(selectedTop < childrenTop)            
            {
                selectedTop = childrenTop + getVerticalFadingEdgeLength();
            } 
            else
    if(selectedBottom > childrenBottom)            
            {
                selectedTop = childrenBottom - selected.getMeasuredHeight()
                        - getVerticalFadingEdgeLength();
            } 
        } 
        else
        {
    if(toPosition < firstPosition)            
            {
                selectedPos = firstPosition;
for(int i = 0;i < childCount;i++)
                {
                    final View v = getChildAt(i);
                    final int top = v.getTop();
    if(i == 0)                    
                    {
                        selectedTop = top;
    if(firstPosition > 0 || top < childrenTop)                        
                        {
                            childrenTop += getVerticalFadingEdgeLength();
                        } 
                    } 
    if(top >= childrenTop)                    
                    {
                        selectedPos = firstPosition + i;
                        selectedTop = top;
                        break;
                    } 
                } 
            } 
            else
            {
                final int itemCount = mItemCount;
                down = false;
                selectedPos = firstPosition + childCount - 1;
for(int i = childCount - 1;i >= 0;i--)
                {
                    final View v = getChildAt(i);
                    final int top = v.getTop();
                    final int bottom = v.getBottom();
    if(i == childCount - 1)                    
                    {
                        selectedTop = top;
    if(firstPosition + childCount < itemCount || bottom > childrenBottom)                        
                        {
                            childrenBottom -= getVerticalFadingEdgeLength();
                        } 
                    } 
    if(bottom <= childrenBottom)                    
                    {
                        selectedPos = firstPosition + i;
                        selectedTop = top;
                        break;
                    } 
                } 
            } 
        } 
        mResurrectToPosition = INVALID_POSITION;
        removeCallbacks(mFlingRunnable);
    if(mPositionScroller != null)        
        {
            mPositionScroller.stop();
        } 
        mTouchMode = TOUCH_MODE_REST;
        clearScrollingCache();
        mSpecificTop = selectedTop;
        selectedPos = lookForSelectablePosition(selectedPos, down);
    if(selectedPos >= firstPosition && selectedPos <= getLastVisiblePosition())        
        {
            mLayoutMode = LAYOUT_SPECIFIC;
            updateSelectorState();
            setSelectionInt(selectedPos);
            invokeOnItemScrollListener();
        } 
        else
        {
            selectedPos = INVALID_POSITION;
        } 
        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
        boolean var6019F9AD381E1844C02CA1829669BB7F_164231266 = (selectedPos >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599300978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599300978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.486 -0400", hash_original_method = "7A1DBAB399A1231E28D6D54E2346B36F", hash_generated_method = "61091F6B394A8EB626532B18E4D3763E")
     void confirmCheckedPositionsById() {
        mCheckStates.clear();
        boolean checkedCountChanged = false;
for(int checkedIndex = 0;checkedIndex < mCheckedIdStates.size();checkedIndex++)
        {
            final long id = mCheckedIdStates.keyAt(checkedIndex);
            final int lastPos = mCheckedIdStates.valueAt(checkedIndex);
            final long lastPosId = mAdapter.getItemId(lastPos);
    if(id != lastPosId)            
            {
                final int start = Math.max(0, lastPos - CHECK_POSITION_SEARCH_DISTANCE);
                final int end = Math.min(lastPos + CHECK_POSITION_SEARCH_DISTANCE, mItemCount);
                boolean found = false;
for(int searchPos = start;searchPos < end;searchPos++)
                {
                    final long searchId = mAdapter.getItemId(searchPos);
    if(id == searchId)                    
                    {
                        found = true;
                        mCheckStates.put(searchPos, true);
                        mCheckedIdStates.setValueAt(checkedIndex, searchPos);
                        break;
                    } 
                } 
    if(!found)                
                {
                    mCheckedIdStates.delete(id);
                    checkedIndex--;
                    mCheckedItemCount--;
                    checkedCountChanged = true;
    if(mChoiceActionMode != null && mMultiChoiceModeCallback != null)                    
                    {
                        mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                                lastPos, id, false);
                    } 
                } 
            } 
            else
            {
                mCheckStates.put(lastPos, true);
            } 
        } 
    if(checkedCountChanged && mChoiceActionMode != null)        
        {
            mChoiceActionMode.invalidate();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.490 -0400", hash_original_method = "988EE7458DA5CAE45D4D8EEE7B510700", hash_generated_method = "464EF04335CED122C238A58A4259965D")
    @Override
    protected void handleDataChanged() {
        int count = mItemCount;
        int lastHandledItemCount = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
    if(mChoiceMode != CHOICE_MODE_NONE && mAdapter != null && mAdapter.hasStableIds())        
        {
            confirmCheckedPositionsById();
        } 
    if(count > 0)        
        {
            int newPos;
            int selectablePos;
    if(mNeedSync)            
            {
                mNeedSync = false;
    if(mTranscriptMode == TRANSCRIPT_MODE_ALWAYS_SCROLL)                
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    return;
                } 
                else
    if(mTranscriptMode == TRANSCRIPT_MODE_NORMAL)                
                {
    if(mForceTranscriptScroll)                    
                    {
                        mForceTranscriptScroll = false;
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                        return;
                    } 
                    final int childCount = getChildCount();
                    final int listBottom = getHeight() - getPaddingBottom();
                    final View lastChild = getChildAt(childCount - 1);
                    final int lastBottom = lastChild != null ? lastChild.getBottom() : listBottom;
    if(mFirstPosition + childCount >= lastHandledItemCount &&
                            lastBottom <= listBottom)                    
                    {
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                        return;
                    } 
                    awakenScrollBars();
                } 
switch(mSyncMode){
                case SYNC_SELECTED_POSITION:
    if(isInTouchMode())                
                {
                    mLayoutMode = LAYOUT_SYNC;
                    mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                    return;
                } 
                else
                {
                    newPos = findSyncPosition();
    if(newPos >= 0)                    
                    {
                        selectablePos = lookForSelectablePosition(newPos, true);
    if(selectablePos == newPos)                        
                        {
                            mSyncPosition = newPos;
    if(mSyncHeight == getHeight())                            
                            {
                                mLayoutMode = LAYOUT_SYNC;
                            } 
                            else
                            {
                                mLayoutMode = LAYOUT_SET_SELECTION;
                            } 
                            setNextSelectedPositionInt(newPos);
                            return;
                        } 
                    } 
                } 
                break;
                case SYNC_FIRST_POSITION:
                mLayoutMode = LAYOUT_SYNC;
                mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                return;
}
            } 
    if(!isInTouchMode())            
            {
                newPos = getSelectedItemPosition();
    if(newPos >= count)                
                {
                    newPos = count - 1;
                } 
    if(newPos < 0)                
                {
                    newPos = 0;
                } 
                selectablePos = lookForSelectablePosition(newPos, true);
    if(selectablePos >= 0)                
                {
                    setNextSelectedPositionInt(selectablePos);
                    return;
                } 
                else
                {
                    selectablePos = lookForSelectablePosition(newPos, false);
    if(selectablePos >= 0)                    
                    {
                        setNextSelectedPositionInt(selectablePos);
                        return;
                    } 
                } 
            } 
            else
            {
    if(mResurrectToPosition >= 0)                
                {
                    return;
                } 
            } 
        } 
        mLayoutMode = mStackFromBottom ? LAYOUT_FORCE_BOTTOM : LAYOUT_FORCE_TOP;
        mSelectedPosition = INVALID_POSITION;
        mSelectedRowId = INVALID_ROW_ID;
        mNextSelectedPosition = INVALID_POSITION;
        mNextSelectedRowId = INVALID_ROW_ID;
        mNeedSync = false;
        mSelectorPosition = INVALID_POSITION;
        checkSelectionChanged();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.493 -0400", hash_original_method = "C562B15A4430BC762CC4B771E60D70AF", hash_generated_method = "600E7538E16563AF09FB867D16C2BE42")
    @Override
    protected void onDisplayHint(int hint) {
        
        super.onDisplayHint(hint);
switch(hint){
        case INVISIBLE:
    if(mPopup != null && mPopup.isShowing())        
        {
            dismissPopup();
        } 
        break;
        case VISIBLE:
    if(mFiltered && mPopup != null && !mPopup.isShowing())        
        {
            showPopup();
        } 
        break;
}        mPopupHidden = hint == INVISIBLE;
        
        
        
            
                
                    
                
                
            
                
                    
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.493 -0400", hash_original_method = "86B533D40AC94020BA9211F436996CAA", hash_generated_method = "B94507DA877D6DC9AD5B4B2F8A2A5E61")
    private void dismissPopup() {
    if(mPopup != null)        
        {
            mPopup.dismiss();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.493 -0400", hash_original_method = "6C07C7201C3F8F7AE411CAF5368DC26F", hash_generated_method = "6A326391BD92133BB23819E4DD256F4B")
    private void showPopup() {
    if(getWindowVisibility() == View.VISIBLE)        
        {
            createTextFilter(true);
            positionPopup();
            checkFocus();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.494 -0400", hash_original_method = "84FE8B62D6AD62C84F51A39D7331FBA6", hash_generated_method = "67E86568A440FC84DF147FF33FB80BDF")
    private void positionPopup() {
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        final int[] xy = new int[2];
        getLocationOnScreen(xy);
        final int bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
    if(!mPopup.isShowing())        
        {
            mPopup.showAtLocation(this, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    xy[0], bottomGap);
        } 
        else
        {
            mPopup.update(xy[0], bottomGap, -1, -1);
        } 
        
        
        
        
        
        
            
                    
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.496 -0400", hash_original_method = "E53786E832898AFD8F3D1858C7ADFC0B", hash_generated_method = "2D484720A599DED15B739AE8A0C5235A")
    @Override
    protected boolean isInFilterMode() {
        boolean var36C832B0627AFDF6338A4E9703CAD999_2116349659 = (mFiltered);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104350887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104350887;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.497 -0400", hash_original_method = "E9CFCD950A6A0EAC13FE4A21D8302AE8", hash_generated_method = "FE03A9B5F55FC70F11EE6D7BB21B65F8")
     boolean sendToTextFilter(int keyCode, int count, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(count);
        addTaint(keyCode);
    if(!acceptFilter())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1036021524 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23091886 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_23091886;
        } 
        boolean handled = false;
        boolean okToSend = true;
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
        okToSend = false;
        break;
        case KeyEvent.KEYCODE_BACK:
    if(mFiltered && mPopup != null && mPopup.isShowing())        
        {
    if(event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0)            
            {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
    if(state != null)                
                {
                    state.startTracking(event, this);
                } 
                handled = true;
            } 
            else
    if(event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled())            
            {
                handled = true;
                mTextFilter.setText("");
            } 
        } 
        okToSend = false;
        break;
        case KeyEvent.KEYCODE_SPACE:
        okToSend = mFiltered;
        break;
}    if(okToSend)        
        {
            createTextFilter(true);
            KeyEvent forwardEvent = event;
    if(forwardEvent.getRepeatCount() > 0)            
            {
                forwardEvent = KeyEvent.changeTimeRepeat(event, event.getEventTime(), 0);
            } 
            int action = event.getAction();
switch(action){
            case KeyEvent.ACTION_DOWN:
            handled = mTextFilter.onKeyDown(keyCode, forwardEvent);
            break;
            case KeyEvent.ACTION_UP:
            handled = mTextFilter.onKeyUp(keyCode, forwardEvent);
            break;
            case KeyEvent.ACTION_MULTIPLE:
            handled = mTextFilter.onKeyMultiple(keyCode, count, event);
            break;
}
        } 
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1919937748 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409883606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409883606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.499 -0400", hash_original_method = "D11D50B93967E008BF298EC93C5B84EB", hash_generated_method = "BD1D1600963C5D79F2FEBED4C29BA2CA")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        
    if(isTextFilterEnabled())        
        {
            createTextFilter(false);
    if(mPublicInputConnection == null)            
            {
                mDefInputConnection = new BaseInputConnection(this, false);
                mPublicInputConnection = new InputConnectionWrapper(
                        mTextFilter.onCreateInputConnection(outAttrs), true) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.499 -0400", hash_original_method = "BF513EB07D63CFAF3DB0C9E86F478409", hash_generated_method = "966A2DA444A2B9A8C9EE36C1B2ED2C57")
        @Override
        public boolean reportFullscreenMode(boolean enabled) {
            addTaint(enabled);
            boolean var8F96BE0DB3CCE16E4367B486E61C359B_227817482 = (mDefInputConnection.reportFullscreenMode(enabled));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418483199 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_418483199;
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.499 -0400", hash_original_method = "D9C91C9E69679EA1CEEF772A4C39F6DE", hash_generated_method = "92A7190C39B480E5101EF319689B91F6")
        @Override
        public boolean performEditorAction(int editorAction) {
            addTaint(editorAction);
    if(editorAction == EditorInfo.IME_ACTION_DONE)            
            {
                InputMethodManager imm = (InputMethodManager)
                                    getContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
    if(imm != null)                
                {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                } 
                boolean varB326B5062B2F0E69046810717534CB09_940542830 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483546839 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_483546839;
            } 
            boolean var68934A3E9455FA72420237EB05902327_2075887434 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376147563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_376147563;
            
            
                            
                                    
                                            
                            
                                
                            
                            
                        
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.499 -0400", hash_original_method = "4DB1D1C6C2201E74EC410884B47F862A", hash_generated_method = "FE44F72D80E7C0E67986FC4DF49E2409")
        @Override
        public boolean sendKeyEvent(KeyEvent event) {
            addTaint(event.getTaint());
            boolean var1199E46A49396F357404A5DD6BBD555A_233514087 = (mDefInputConnection.sendKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624992153 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624992153;
            
            
        }
};
            } 
            outAttrs.inputType = EditorInfo.TYPE_CLASS_TEXT
                    | EditorInfo.TYPE_TEXT_VARIATION_FILTER;
            outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE;
InputConnection var98A3C8ED4CCB33FE20C0790B1005183A_403547718 =             mPublicInputConnection;
            var98A3C8ED4CCB33FE20C0790B1005183A_403547718.addTaint(taint);
            return var98A3C8ED4CCB33FE20C0790B1005183A_403547718;
        } 
InputConnection var540C13E9E156B687226421B24F2DF178_347544867 =         null;
        var540C13E9E156B687226421B24F2DF178_347544867.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_347544867;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.501 -0400", hash_original_method = "44BA525DE8B7DBBB72825E23CC2BB1F6", hash_generated_method = "EA50601FA464E9A62AA074C9647E279A")
    @Override
    public boolean checkInputConnectionProxy(View view) {
        addTaint(view.getTaint());
        boolean var17BB4F5820E7689DE8BF02EAF038DD2E_702748537 = (view == mTextFilter);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444368131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444368131;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.501 -0400", hash_original_method = "F3682B44558BD825C5F832A45B68670A", hash_generated_method = "CBA6D2DED012DC51C5043707C1135BE5")
    private void createTextFilter(boolean animateEntrance) {
        addTaint(animateEntrance);
    if(mPopup == null)        
        {
            Context c = getContext();
            PopupWindow p = new PopupWindow(c);
            LayoutInflater layoutInflater = (LayoutInflater)
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
        } 
    if(animateEntrance)        
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilter);
        } 
        else
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilterRestore);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.501 -0400", hash_original_method = "32E21A2D6552DD3A6789EF27520CDF5A", hash_generated_method = "8310BABBAD98D315F1FA044DA35AFEE7")
    public void clearTextFilter() {
    if(mFiltered)        
        {
            mTextFilter.setText("");
            mFiltered = false;
    if(mPopup != null && mPopup.isShowing())            
            {
                dismissPopup();
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.502 -0400", hash_original_method = "65ACBB1BC8C4B28B951746B0589E48B4", hash_generated_method = "72AEAA476F3876203C37F50E1C69B225")
    public boolean hasTextFilter() {
        boolean var36C832B0627AFDF6338A4E9703CAD999_320070893 = (mFiltered);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891839145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891839145;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.502 -0400", hash_original_method = "11A5FC28E28C3DFE2639108D4141B162", hash_generated_method = "40011701587F2FC67CE7373AE53F2377")
    public void onGlobalLayout() {
        
    if(isShown())        
        {
    if(mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden)            
            {
                showPopup();
            } 
        } 
        else
        {
    if(mPopup != null && mPopup.isShowing())            
            {
                dismissPopup();
            } 
        } 
        
        
            
                
            
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.503 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "63445082BCC7E22464CE7B1B497FEB87")
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        addTaint(after);
        addTaint(count);
        addTaint(start);
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.503 -0400", hash_original_method = "971B961D673D514356DF6D21C3AC22CE", hash_generated_method = "04027A14EBF32B8CB5232CD4A828BA8F")
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        
        addTaint(count);
        addTaint(before);
        addTaint(start);
        addTaint(s.getTaint());
    if(mPopup != null && isTextFilterEnabled())        
        {
            int length = s.length();
            boolean showing = mPopup.isShowing();
    if(!showing && length > 0)            
            {
                showPopup();
                mFiltered = true;
            } 
            else
    if(showing && length == 0)            
            {
                dismissPopup();
                mFiltered = false;
            } 
    if(mAdapter instanceof Filterable)            
            {
                Filter f = ((Filterable) mAdapter).getFilter();
    if(f != null)                
                {
                    f.filter(s, this);
                } 
                else
                {
                    IllegalStateException var1AC4EBCFCD944999E1E6475378119C01_846518508 = new IllegalStateException("You cannot call onTextChanged with a non "
                            + "filterable adapter");
                    var1AC4EBCFCD944999E1E6475378119C01_846518508.addTaint(taint);
                    throw var1AC4EBCFCD944999E1E6475378119C01_846518508;
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.503 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.503 -0400", hash_original_method = "5FB3F90813AE5A23A23BDBAA76A97056", hash_generated_method = "E7A10F4FE06F5A115D179EBD8AD44BC5")
    public void onFilterComplete(int count) {
        
        addTaint(count);
    if(mSelectedPosition < 0 && count > 0)        
        {
            mResurrectToPosition = INVALID_POSITION;
            resurrectSelection();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.503 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "AAD41454C90B858CADC114F31E7737A5")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
ViewGroup.LayoutParams varB945D213E5036F8DDF9B40811234DF64_1472641380 =         new LayoutParams(p);
        varB945D213E5036F8DDF9B40811234DF64_1472641380.addTaint(taint);
        return varB945D213E5036F8DDF9B40811234DF64_1472641380;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "D7DCCEE0C1D1153E18E019649E6F2D80", hash_generated_method = "05CB8977BB524AC5DD5C503C346DC22C")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams varBFB6505F03D0CA54C34B00D27F261D54_848563395 =         new AbsListView.LayoutParams(getContext(), attrs);
        varBFB6505F03D0CA54C34B00D27F261D54_848563395.addTaint(taint);
        return varBFB6505F03D0CA54C34B00D27F261D54_848563395;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "7C8047E4E7C938CA1D7BE889EE17D059", hash_generated_method = "AB1D970EBDA1A66AD6AD0CBE1C085F77")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var10CE07C8F1845E88B1DF22390CBD6796_313141769 = (p instanceof AbsListView.LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538229938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538229938;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "1385B81082A7F6F42283DE7C72A352C9", hash_generated_method = "EDB13FA3924957A0F3CE2B87C521F371")
    public void setTranscriptMode(int mode) {
        mTranscriptMode = mode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "EADF20E51473F5B82FC89B630E89BCE7", hash_generated_method = "A099DCDC866E6104ABD957A803A6E870")
    public int getTranscriptMode() {
        int varB59250E72778FF38D50B7661501C8F31_826482914 = (mTranscriptMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608598036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608598036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "3A641BF6273957C36676C590B4CC3444", hash_generated_method = "D2AB9ACFA1C57A4A9701B141336E2DD9")
    @Override
    public int getSolidColor() {
        int var5CB078F03E28D94B5DD6707B7823D2ED_1603348214 = (mCacheColorHint);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270544429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270544429;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.505 -0400", hash_original_method = "B2E4EFE21735BA4D4CA20D9D2323DF5E", hash_generated_method = "BBE27DE80EC2B573AAD7741309DDF74F")
    public void setCacheColorHint(int color) {
    if(color != mCacheColorHint)        
        {
            mCacheColorHint = color;
            int count = getChildCount();
for(int i = 0;i < count;i++)
            {
                getChildAt(i).setDrawingCacheBackgroundColor(color);
            } 
            mRecycler.setCacheColorHint(color);
        } 
        
        
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.506 -0400", hash_original_method = "75945C93CA5A574EC2A11912410CB0E0", hash_generated_method = "298C449029F115A7CF64B50B1A4A0CDA")
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        int var5CB078F03E28D94B5DD6707B7823D2ED_982125004 = (mCacheColorHint);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640632794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640632794;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.507 -0400", hash_original_method = "012761D54D3EA9FE8C837ED35E18F05A", hash_generated_method = "F22F1B0A768354EAD57EEF49B307BA13")
    public void reclaimViews(List<View> views) {
        addTaint(views.getTaint());
        int childCount = getChildCount();
        RecyclerListener listener = mRecycler.mRecyclerListener;
for(int i = 0;i < childCount;i++)
        {
            View child = getChildAt(i);
            AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
    if(lp != null && mRecycler.shouldRecycleViewType(lp.viewType))            
            {
                views.add(child);
    if(listener != null)                
                {
                    listener.onMovedToScrapHeap(child);
                } 
            } 
        } 
        mRecycler.reclaimScrapViews(views);
        removeAllViewsInLayout();
        
        
        
        
            
            
            
                
                
                    
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.507 -0400", hash_original_method = "63F1E187EEAD4E39E30E7C6F8BC8B8CA", hash_generated_method = "74491C33D5910D41AF8293FACE0C763A")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        
        addTaint(consistency);
        boolean result = super.onConsistencyCheck(consistency);
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
    if(checkLayout)        
        {
            final View[] activeViews = mRecycler.mActiveViews;
            int count = activeViews.length;
for(int i = 0;i < count;i++)
            {
    if(activeViews[i] != null)                
                {
                    result = false;
                    Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "AbsListView " + this + " has a view in its active recycler: " +
                                    activeViews[i]);
                } 
            } 
            final ArrayList<View> scrap = mRecycler.mCurrentScrap;
    if(!checkScrap(scrap))            
            result = false;
            final ArrayList<View>[] scraps = mRecycler.mScrapViews;
            count = scraps.length;
for(int i = 0;i < count;i++)
            {
    if(!checkScrap(scraps[i]))                
                result = false;
            } 
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_1620743731 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460709445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460709445;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.508 -0400", hash_original_method = "256B8EB3FFECB4266216E5C3F84B8A1E", hash_generated_method = "959F0DC47181438E945C91F30D5BBC0B")
    private boolean checkScrap(ArrayList<View> scrap) {
        addTaint(scrap.getTaint());
    if(scrap == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1414807394 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870030766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870030766;
        }
        boolean result = true;
        final int count = scrap.size();
for(int i = 0;i < count;i++)
        {
            final View view = scrap.get(i);
    if(view.getParent() != null)            
            {
                result = false;
                Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
            } 
    if(indexOfChild(view) >= 0)            
            {
                result = false;
                Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap that is also a direct child: " + view);
            } 
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_621122514 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103217449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103217449;
        
        
        
        
        
            
            
                
                
                        
            
            
                
                
                        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.509 -0400", hash_original_method = "D0C284A2FBB36CA42A8E7F826DDB725F", hash_generated_method = "24F962F5A80FABE3DD09DB3C3A2EB478")
    private void finishGlows() {
    if(mEdgeGlowTop != null)        
        {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.510 -0400", hash_original_method = "C1CCFF5C419F753BE2BE6DDA2ACFD3CA", hash_generated_method = "41AD6D8A0BCCA4DC82698799B3E5CB09")
    public void setRemoteViewsAdapter(Intent intent) {
    if(mRemoteAdapter != null)        
        {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteAdapter.getRemoteViewsServiceIntent());
    if(fcNew.equals(fcOld))            
            {
                return;
            } 
        } 
        mDeferNotifyDataSetChanged = false;
        mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        
        
            
            
                    
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.510 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.510 -0400", hash_original_method = "28DEF371BA940ACF691CB065E03F3A69", hash_generated_method = "5C9866EEB52B85B896A696E78D3109F4")
    public boolean onRemoteAdapterConnected() {
        
    if(mRemoteAdapter != mAdapter)        
        {
            setAdapter(mRemoteAdapter);
    if(mDeferNotifyDataSetChanged)            
            {
                mRemoteAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } 
            boolean var68934A3E9455FA72420237EB05902327_1140942377 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177352305 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177352305;
        } 
        else
    if(mRemoteAdapter != null)        
        {
            mRemoteAdapter.superNotifyDataSetChanged();
            boolean varB326B5062B2F0E69046810717534CB09_640427582 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113073169 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113073169;
        } 
        boolean var68934A3E9455FA72420237EB05902327_87189179 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908825986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908825986;
        
        
            
            
                
                
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.510 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.511 -0400", hash_original_method = "A10CF4C818C12AB96D88DAC8638A238F", hash_generated_method = "404EE273DAE2437904EE1226A8B166EC")
    public void setRecyclerListener(RecyclerListener listener) {
        mRecycler.mRecyclerListener = listener;
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.511 -0400", hash_original_field = "74B7CE7BE804A955E8E20EA04653DEE6", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.511 -0400", hash_original_field = "22E8B3D384A8481DE4964CE4DE9406EA", hash_generated_field = "0BDE14D7CA4854CAEFC01406C97CEF7F")

        long firstId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "D1400BAE47A67FF79088280865144D7B", hash_generated_field = "56346AA9CA8DBF7744AF68AF06173D8A")

        int viewTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "8F36DB7D8F52F07B49D496BF7578B9B0")

        String filter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "056850EF315F5D6E6668719E2250DB2D", hash_generated_field = "5A1FA0BDDD0CC1410D12AF217F54B1FD")

        boolean inActionMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "934BB5987834E703FF3C24EA9FABB4CC", hash_generated_field = "B7E6911A4E2ECF81E111555BDE3C9E25")

        int checkedItemCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "9DD4030F43EEA8422A0B20FE0265BCBA", hash_generated_field = "6CA6AED4CE00926047251B3E7BCD1BAB")

        SparseBooleanArray checkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_field = "4E89343A86D5E5558CBC6356B8A823D3", hash_generated_field = "9634971E46A47F441AB88BCA83B02BB2")

        LongSparseArray<Integer> checkIdState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.512 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.514 -0400", hash_original_method = "9305A5F2B13D160808C7DFC7D0F396F1", hash_generated_method = "962661E2F7B8052DE4883311106650AD")
        private  SavedState(Parcel in) {
            super(in);
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
    if(N > 0)            
            {
                checkIdState = new LongSparseArray<Integer>();
for(int i=0;i<N;i++)
                {
                    final long key = in.readLong();
                    final int value = in.readInt();
                    checkIdState.put(key, value);
                } 
            } 
            
            
            
            
            
            
            
            
            
            
            
            
                
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.514 -0400", hash_original_method = "3B46B91B7C73B4C6AC70E6F2F8A95E0E", hash_generated_method = "3A7C9B2A2E18E20F5809F66AB7DB6EDA")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
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
for(int i=0;i<N;i++)
            {
                out.writeLong(checkIdState.keyAt(i));
                out.writeInt(checkIdState.valueAt(i));
            } 
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_method = "28CD4AAEE48E548227BD32788E936C86", hash_generated_method = "907B760A67CEE294B2E2EE48DABAFA82")
        @Override
        public String toString() {
String varFAB9679CD855D3E387266102B6FF30B8_40596785 =             "AbsListView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " firstId=" + firstId
                    + " viewTop=" + viewTop
                    + " position=" + position
                    + " height=" + height
                    + " filter=" + filter
                    + " checkState=" + checkState + "}";
            varFAB9679CD855D3E387266102B6FF30B8_40596785.addTaint(taint);
            return varFAB9679CD855D3E387266102B6FF30B8_40596785;
            
            
                    
                    
                    
                    
                    
                    
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_field = "71E0FB0329E33FA478C7BD9F2EB990C7", hash_generated_field = "C8F22F4E13BEEC60720F9AB64A1792E3")

        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_method = "A658DB72BEF305C977658A79961C7172", hash_generated_method = "A658DB72BEF305C977658A79961C7172")
        public WindowRunnnable ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_method = "CFEEFBABEEA41C591AAAAD229F2BB0E7", hash_generated_method = "3CF34E449DE44A2D47EB624B8E366E7B")
        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.515 -0400", hash_original_method = "A209657341959E6933B2954972D0CEE9", hash_generated_method = "EA18EEC93D1FF07269927A0924AEC4C3")
        public boolean sameWindow() {
            boolean var3A65608EF4B6F0351582B4E41522764A_1366681091 = (hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964216651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964216651;
            
            
        }

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_field = "4D3D586E79B5D45386198E5887F48792", hash_generated_field = "C001E24B1020A024FC58CC124DF01D4E")

        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "A958048F64A683459F522CCD37FE7D11", hash_generated_method = "DAA26BFD27A723C995CB5126AE6F4887")
        public void run() {
    if(mDataChanged)            
            return;
            final ListAdapter adapter = mAdapter;
            final int motionPosition = mClickMotionPosition;
    if(adapter != null && mItemCount > 0 &&
                    motionPosition != INVALID_POSITION &&
                    motionPosition < adapter.getCount() && sameWindow())            
            {
                final View view = getChildAt(motionPosition - mFirstPosition);
    if(view != null)                
                {
                    performItemClick(view, motionPosition, adapter.getItemId(motionPosition));
                } 
            } 
            
            
            
            
            
                    
                    
                
                
                    
                
            
        }

        
    }


    
    private class CheckForLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "6FF0C5D4F5CC73F85A2BCE7243EBBA32", hash_generated_method = "DB76985C0A2C7410241517C0799CA520")
        public void run() {
            final int motionPosition = mMotionPosition;
            final View child = getChildAt(motionPosition - mFirstPosition);
    if(child != null)            
            {
                final int longPressPosition = mMotionPosition;
                final long longPressId = mAdapter.getItemId(mMotionPosition);
                boolean handled = false;
    if(sameWindow() && !mDataChanged)                
                {
                    handled = performLongPress(child, longPressPosition, longPressId);
                } 
    if(handled)                
                {
                    mTouchMode = TOUCH_MODE_REST;
                    setPressed(false);
                    child.setPressed(false);
                } 
                else
                {
                    mTouchMode = TOUCH_MODE_DONE_WAITING;
                } 
            } 
            
            
            
            
                
                
                
                
                    
                
                
                    
                    
                    
                
                    
                
            
        }

        
    }


    
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "D4E5218C094B479D486A451FD5B82AD6", hash_generated_method = "D4E5218C094B479D486A451FD5B82AD6")
        public CheckForKeyLongPress ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.516 -0400", hash_original_method = "A3D23752A2B3700EB42478E66A11709C", hash_generated_method = "FC0792D05E4213DA086DEF8428BC1B8F")
        public void run() {
    if(isPressed() && mSelectedPosition >= 0)            
            {
                int index = mSelectedPosition - mFirstPosition;
                View v = getChildAt(index);
    if(!mDataChanged)                
                {
                    boolean handled = false;
    if(sameWindow())                    
                    {
                        handled = performLongPress(v, mSelectedPosition, mSelectedRowId);
                    } 
    if(handled)                    
                    {
                        setPressed(false);
                        v.setPressed(false);
                    } 
                } 
                else
                {
                    setPressed(false);
    if(v != null)                    
                    v.setPressed(false);
                } 
            } 
            
            
                
                
                
                    
                    
                        
                    
                    
                        
                        
                    
                
                    
                    
                
            
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.517 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.518 -0400", hash_original_method = "BD1CF9A4027AFE49AD3D9DDE12B9EB2A", hash_generated_method = "DE066A06A03F74B1895A078844445AC3")
        public void run() {
    if(mTouchMode == TOUCH_MODE_DOWN)            
            {
                mTouchMode = TOUCH_MODE_TAP;
                final View child = getChildAt(mMotionPosition - mFirstPosition);
    if(child != null && !child.hasFocusable())                
                {
                    mLayoutMode = LAYOUT_NORMAL;
    if(!mDataChanged)                    
                    {
                        child.setPressed(true);
                        setPressed(true);
                        layoutChildren();
                        positionSelector(mMotionPosition, child);
                        refreshDrawableState();
                        final int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        final boolean longClickable = isLongClickable();
    if(mSelector != null)                        
                        {
                            Drawable d = mSelector.getCurrent();
    if(d != null && d instanceof TransitionDrawable)                            
                            {
    if(longClickable)                                
                                {
                                    ((TransitionDrawable) d).startTransition(longPressTimeout);
                                } 
                                else
                                {
                                    ((TransitionDrawable) d).resetTransition();
                                } 
                            } 
                        } 
    if(longClickable)                        
                        {
    if(mPendingCheckForLongPress == null)                            
                            {
                                mPendingCheckForLongPress = new CheckForLongPress();
                            } 
                            mPendingCheckForLongPress.rememberWindowAttachCount();
                            postDelayed(mPendingCheckForLongPress, longPressTimeout);
                        } 
                        else
                        {
                            mTouchMode = TOUCH_MODE_DONE_WAITING;
                        } 
                    } 
                    else
                    {
                        mTouchMode = TOUCH_MODE_DONE_WAITING;
                    } 
                } 
            } 
            
            
        }

        
    }


    
    private class FlingRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.519 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

        private OverScroller mScroller;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.519 -0400", hash_original_field = "9423EF5EE80CF667F79CA444C6185EF3", hash_generated_field = "86847DC6149E26E8E3AF7D833983C21E")

        private int mLastFlingY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.983 -0400", hash_original_field = "096BC0A6588940F4E79A408DFF90CE94", hash_generated_field = "9F014DEA39CCE3B44059EBF714457BE4")

        private final Runnable mCheckFlywheel = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.982 -0400", hash_original_method = "794342E61B0741E0D2D0BA9CCE24C214", hash_generated_method = "05A6D06000C04FEEEC863E17B0649D09")
            public void run() {
                final int activeId = mActivePointerId;
                final VelocityTracker vt = mVelocityTracker;
                final OverScroller scroller = mScroller;
                vt.computeCurrentVelocity(1000, mMaximumVelocity);
                final float yvel = -vt.getYVelocity(activeId);
                {
                    boolean varD670105D084B3EC9810CA2EF9B5779A0_90185550 = (Math.abs(yvel) >= mMinimumVelocity
                        && scroller.isScrollingInDirection(0, yvel));
                    {
                        postDelayed(this, FLYWHEEL_TIMEOUT);
                    } 
                    {
                        endFling();
                        mTouchMode = TOUCH_MODE_SCROLL;
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                    } 
                } 
                
                
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.519 -0400", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "85D92534340BCEFCD6A4F33FFFEF2C53")
          FlingRunnable() {
            mScroller = new OverScroller(getContext());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.520 -0400", hash_original_method = "03D4FA54CBC93A7E96ECD2486CBEE621", hash_generated_method = "8107467CFCBD9F7D8B0D1EE35324D523")
         void start(int initialVelocity) {
            addTaint(initialVelocity);
            int initialY = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingY = initialY;
            mScroller.fling(0, initialY, 0, initialVelocity,
                    0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
    if(PROFILE_FLINGING)            
            {
    if(!mFlingProfilingStarted)                
                {
                    Debug.startMethodTracing("AbsListViewFling");
                    mFlingProfilingStarted = true;
                } 
            } 
    if(mFlingStrictSpan == null)            
            {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            } 
            
            
            
            
                    
            
            
            
                
                    
                    
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.520 -0400", hash_original_method = "7C6D2E7D970FED93FF739DAAC6CC80C2", hash_generated_method = "080F156F5C9A7E2EB919812C0C1E3FFB")
         void startSpringback() {
    if(mScroller.springBack(0, mScrollY, 0, 0, 0, 0))            
            {
                mTouchMode = TOUCH_MODE_OVERFLING;
                invalidate();
                post(this);
            } 
            else
            {
                mTouchMode = TOUCH_MODE_REST;
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } 
            
            
                
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.520 -0400", hash_original_method = "57B70ADF06D2A10A257A1E350228503E", hash_generated_method = "52A206CBE7C21D3660F07B788351F5F6")
         void startOverfling(int initialVelocity) {
            addTaint(initialVelocity);
            mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            mTouchMode = TOUCH_MODE_OVERFLING;
            invalidate();
            post(this);
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.521 -0400", hash_original_method = "F0692CC07A14DB0F1E581AFC2CDF3E90", hash_generated_method = "07731DB9FF93AEDC69EFC1DE1864DCF5")
         void edgeReached(int delta) {
            addTaint(delta);
            mScroller.notifyVerticalEdgeReached(mScrollY, 0, mOverflingDistance);
            final int overscrollMode = getOverScrollMode();
    if(overscrollMode == OVER_SCROLL_ALWAYS ||
                    (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && !contentFits()))            
            {
                mTouchMode = TOUCH_MODE_OVERFLING;
                final int vel = (int) mScroller.getCurrVelocity();
    if(delta > 0)                
                {
                    mEdgeGlowTop.onAbsorb(vel);
                } 
                else
                {
                    mEdgeGlowBottom.onAbsorb(vel);
                } 
            } 
            else
            {
                mTouchMode = TOUCH_MODE_REST;
    if(mPositionScroller != null)                
                {
                    mPositionScroller.stop();
                } 
            } 
            invalidate();
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.522 -0400", hash_original_method = "16B3910BA949F2F73CCA1E8DA35CE0FF", hash_generated_method = "68A62758A2B21B650EBFDDE5AF4C4B8A")
         void startScroll(int distance, int duration) {
            addTaint(duration);
            addTaint(distance);
            int initialY = distance < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingY = initialY;
            mScroller.startScroll(0, initialY, 0, distance, duration);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.523 -0400", hash_original_method = "EC718B25FAE44F694CA340373A32BE29", hash_generated_method = "3C08D35204E0D3B4029035EC6FA260EF")
         void endFling() {
            mTouchMode = TOUCH_MODE_REST;
            removeCallbacks(this);
            removeCallbacks(mCheckFlywheel);
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            clearScrollingCache();
            mScroller.abortAnimation();
    if(mFlingStrictSpan != null)            
            {
                mFlingStrictSpan.finish();
                mFlingStrictSpan = null;
            } 
            
            
            
            
            
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.523 -0400", hash_original_method = "5D655CDBCE73395DC3C27E060B822A32", hash_generated_method = "AF0A59A6E58D426EFA985AB4A1AD55DE")
         void flywheelTouch() {
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.524 -0400", hash_original_method = "4DD83535EAA65B570F4DB1073D459909", hash_generated_method = "3D40292980B7D6A92338FD9E987A5B84")
        public void run() {
switch(mTouchMode){
            default:
            endFling();
            return;
            case TOUCH_MODE_SCROLL:
    if(mScroller.isFinished())            
            {
                return;
            } 
            case TOUCH_MODE_FLING:
            {
    if(mDataChanged)                
                {
                    layoutChildren();
                } 
    if(mItemCount == 0 || getChildCount() == 0)                
                {
                    endFling();
                    return;
                } 
                final OverScroller scroller = mScroller;
                boolean more = scroller.computeScrollOffset();
                final int y = scroller.getCurrY();
                int delta = mLastFlingY - y;
    if(delta > 0)                
                {
                    mMotionPosition = mFirstPosition;
                    final View firstView = getChildAt(0);
                    mMotionViewOriginalTop = firstView.getTop();
                    delta = Math.min(getHeight() - mPaddingBottom - mPaddingTop - 1, delta);
                } 
                else
                {
                    int offsetToLast = getChildCount() - 1;
                    mMotionPosition = mFirstPosition + offsetToLast;
                    final View lastView = getChildAt(offsetToLast);
                    mMotionViewOriginalTop = lastView.getTop();
                    delta = Math.max(-(getHeight() - mPaddingBottom - mPaddingTop - 1), delta);
                } 
                View motionView = getChildAt(mMotionPosition - mFirstPosition);
                int oldTop = 0;
    if(motionView != null)                
                {
                    oldTop = motionView.getTop();
                } 
                final boolean atEnd = trackMotionScroll(delta, delta) && (delta != 0);
    if(atEnd)                
                {
    if(motionView != null)                    
                    {
                        int overshoot = -(delta - (motionView.getTop() - oldTop));
                        overScrollBy(0, overshoot, 0, mScrollY, 0, 0,
                                0, mOverflingDistance, false);
                    } 
    if(more)                    
                    {
                        edgeReached(delta);
                    } 
                    break;
                } 
    if(more && !atEnd)                
                {
                    invalidate();
                    mLastFlingY = y;
                    post(this);
                } 
                else
                {
                    endFling();
    if(PROFILE_FLINGING)                    
                    {
    if(mFlingProfilingStarted)                        
                        {
                            Debug.stopMethodTracing();
                            mFlingProfilingStarted = false;
                        } 
    if(mFlingStrictSpan != null)                        
                        {
                            mFlingStrictSpan.finish();
                            mFlingStrictSpan = null;
                        } 
                    } 
                } 
                break;
            } 
            case TOUCH_MODE_OVERFLING:
            {
                final OverScroller scroller = mScroller;
    if(scroller.computeScrollOffset())                
                {
                    final int scrollY = mScrollY;
                    final int currY = scroller.getCurrY();
                    final int deltaY = currY - scrollY;
    if(overScrollBy(0, deltaY, 0, scrollY, 0, 0,
                            0, mOverflingDistance, false))                    
                    {
                        final boolean crossDown = scrollY <= 0 && currY > 0;
                        final boolean crossUp = scrollY >= 0 && currY < 0;
    if(crossDown || crossUp)                        
                        {
                            int velocity = (int) scroller.getCurrVelocity();
    if(crossUp)                            
                            velocity = -velocity;
                            scroller.abortAnimation();
                            start(velocity);
                        } 
                        else
                        {
                            startSpringback();
                        } 
                    } 
                    else
                    {
                        invalidate();
                        post(this);
                    } 
                } 
                else
                {
                    endFling();
                } 
                break;
            } 
}
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "1135E78FD7F0199281F6A90573FF1A21", hash_generated_field = "B974BC706FB203D2BBE61C1339EC973E")

        private static final int FLYWHEEL_TIMEOUT = 40;
    }


    
    class PositionScroller implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

        private int mMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "5F5170865EC69F6B24AEF73CD54B04BC", hash_generated_field = "35DC5F27F96B58A562B22555A8E37DA2")

        private int mTargetPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "6F001A96E4362F7D43184AD4169A147D", hash_generated_field = "001157AAC2240D5D9104D4D4F24CB9C2")

        private int mBoundPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "0CBDF658C2D1AD50575CB7EA8E63F15A", hash_generated_field = "891ABFC466B178DF3188D6BA9AF5BFB7")

        private int mLastSeenPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "BD4F087E6D2FF4D0C8D456B181206FDE", hash_generated_field = "0A9D921182A874240E73B3AC5A654444")

        private int mScrollDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "02F4FC33F196F5F1FB41D460018A21E5", hash_generated_field = "6B555669DDE5E4DA69AE4203D3212DA1")

        private int mExtraScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_field = "C1AA32DDC2CA704B66F75B57225BB113", hash_generated_field = "D33BBF09949BE3C4FE4DC46E6E79C30E")

        private int mOffsetFromTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.525 -0400", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "39D3C7BDBFB04AD5ABE46AB28461C81D")
          PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.527 -0400", hash_original_method = "FDCD353E7B4C16B389C07FF98024D1F6", hash_generated_method = "A3B286C18B61790152A6DFEDD9132458")
         void start(int position) {
            stop();
            final int firstPos = mFirstPosition;
            final int lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
    if(position <= firstPos)            
            {
                viewTravelCount = firstPos - position + 1;
                mMode = MOVE_UP_POS;
            } 
            else
    if(position >= lastPos)            
            {
                viewTravelCount = position - lastPos + 1;
                mMode = MOVE_DOWN_POS;
            } 
            else
            {
                return;
            } 
    if(viewTravelCount > 0)            
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } 
            else
            {
                mScrollDuration = SCROLL_DURATION;
            } 
            mTargetPos = position;
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.529 -0400", hash_original_method = "84EF03A180BC8A392D5F6234ABF1A7D7", hash_generated_method = "6478E8B90746AF88C104F70854D2A165")
         void start(int position, int boundPosition) {
            stop();
    if(boundPosition == INVALID_POSITION)            
            {
                start(position);
                return;
            } 
            final int firstPos = mFirstPosition;
            final int lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
    if(position <= firstPos)            
            {
                final int boundPosFromLast = lastPos - boundPosition;
    if(boundPosFromLast < 1)                
                {
                    return;
                } 
                final int posTravel = firstPos - position + 1;
                final int boundTravel = boundPosFromLast - 1;
    if(boundTravel < posTravel)                
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_UP_BOUND;
                } 
                else
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_UP_POS;
                } 
            } 
            else
    if(position >= lastPos)            
            {
                final int boundPosFromFirst = boundPosition - firstPos;
    if(boundPosFromFirst < 1)                
                {
                    return;
                } 
                final int posTravel = position - lastPos + 1;
                final int boundTravel = boundPosFromFirst - 1;
    if(boundTravel < posTravel)                
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_DOWN_BOUND;
                } 
                else
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_DOWN_POS;
                } 
            } 
            else
            {
                return;
            } 
    if(viewTravelCount > 0)            
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } 
            else
            {
                mScrollDuration = SCROLL_DURATION;
            } 
            mTargetPos = position;
            mBoundPos = boundPosition;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.529 -0400", hash_original_method = "BE41DE2B3819156F24DD50B9D9C0C2E0", hash_generated_method = "A394087E727D1F19D6E998D8755DEB00")
         void startWithOffset(int position, int offset) {
            addTaint(offset);
            addTaint(position);
            startWithOffset(position, offset, SCROLL_DURATION);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.531 -0400", hash_original_method = "6B17946EC33D794252BA778D04AAD100", hash_generated_method = "E2AFDB2D7D99538A7A226F9BC60A0458")
         void startWithOffset(int position, int offset, int duration) {
            stop();
            mTargetPos = position;
            mOffsetFromTop = offset;
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            mMode = MOVE_OFFSET;
            final int firstPos = mFirstPosition;
            final int childCount = getChildCount();
            final int lastPos = firstPos + childCount - 1;
            int viewTravelCount;
    if(position < firstPos)            
            {
                viewTravelCount = firstPos - position;
            } 
            else
    if(position > lastPos)            
            {
                viewTravelCount = position - lastPos;
            } 
            else
            {
                final int targetTop = getChildAt(position - firstPos).getTop();
                smoothScrollBy(targetTop - offset, duration);
                return;
            } 
            final float screenTravelCount = (float) viewTravelCount / childCount;
            mScrollDuration = screenTravelCount < 1 ? (int) (screenTravelCount * duration) :
                    (int) (duration / screenTravelCount);
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.531 -0400", hash_original_method = "EE84C7B9935E89C7F265FE60CF403C46", hash_generated_method = "8545B8FD33B72FF1E0D42710AB6A286F")
         void stop() {
            removeCallbacks(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.533 -0400", hash_original_method = "BF3ECE172F6D799B3639990958E45277", hash_generated_method = "7BE081EA7D596159B4A123B1CAC2DDDD")
        public void run() {
    if(mTouchMode != TOUCH_MODE_FLING && mLastSeenPos != INVALID_POSITION)            
            {
                return;
            } 
            final int listHeight = getHeight();
            final int firstPos = mFirstPosition;
switch(mMode){
            case MOVE_DOWN_POS:
            {
                final int lastViewIndex = getChildCount() - 1;
                final int lastPos = firstPos + lastViewIndex;
    if(lastViewIndex < 0)                
                {
                    return;
                } 
    if(lastPos == mLastSeenPos)                
                {
                    post(this);
                    return;
                } 
                final View lastView = getChildAt(lastViewIndex);
                final int lastViewHeight = lastView.getHeight();
                final int lastViewTop = lastView.getTop();
                final int lastViewPixelsShowing = listHeight - lastViewTop;
                final int extraScroll = lastPos < mItemCount - 1 ? mExtraScroll : mListPadding.bottom;
                smoothScrollBy(lastViewHeight - lastViewPixelsShowing + extraScroll,
                        mScrollDuration);
                mLastSeenPos = lastPos;
    if(lastPos < mTargetPos)                
                {
                    post(this);
                } 
                break;
            } 
            case MOVE_DOWN_BOUND:
            {
                final int nextViewIndex = 1;
                final int childCount = getChildCount();
    if(firstPos == mBoundPos || childCount <= nextViewIndex
                        || firstPos + childCount >= mItemCount)                
                {
                    return;
                } 
                final int nextPos = firstPos + nextViewIndex;
    if(nextPos == mLastSeenPos)                
                {
                    post(this);
                    return;
                } 
                final View nextView = getChildAt(nextViewIndex);
                final int nextViewHeight = nextView.getHeight();
                final int nextViewTop = nextView.getTop();
                final int extraScroll = mExtraScroll;
    if(nextPos < mBoundPos)                
                {
                    smoothScrollBy(Math.max(0, nextViewHeight + nextViewTop - extraScroll),
                            mScrollDuration);
                    mLastSeenPos = nextPos;
                    post(this);
                } 
                else
                {
    if(nextViewTop > extraScroll)                    
                    {
                        smoothScrollBy(nextViewTop - extraScroll, mScrollDuration);
                    } 
                } 
                break;
            } 
            case MOVE_UP_POS:
            {
    if(firstPos == mLastSeenPos)                
                {
                    post(this);
                    return;
                } 
                final View firstView = getChildAt(0);
    if(firstView == null)                
                {
                    return;
                } 
                final int firstViewTop = firstView.getTop();
                final int extraScroll = firstPos > 0 ? mExtraScroll : mListPadding.top;
                smoothScrollBy(firstViewTop - extraScroll, mScrollDuration);
                mLastSeenPos = firstPos;
    if(firstPos > mTargetPos)                
                {
                    post(this);
                } 
                break;
            } 
            case MOVE_UP_BOUND:
            {
                final int lastViewIndex = getChildCount() - 2;
    if(lastViewIndex < 0)                
                {
                    return;
                } 
                final int lastPos = firstPos + lastViewIndex;
    if(lastPos == mLastSeenPos)                
                {
                    post(this);
                    return;
                } 
                final View lastView = getChildAt(lastViewIndex);
                final int lastViewHeight = lastView.getHeight();
                final int lastViewTop = lastView.getTop();
                final int lastViewPixelsShowing = listHeight - lastViewTop;
                mLastSeenPos = lastPos;
    if(lastPos > mBoundPos)                
                {
                    smoothScrollBy(-(lastViewPixelsShowing - mExtraScroll), mScrollDuration);
                    post(this);
                } 
                else
                {
                    final int bottom = listHeight - mExtraScroll;
                    final int lastViewBottom = lastViewTop + lastViewHeight;
    if(bottom > lastViewBottom)                    
                    {
                        smoothScrollBy(-(bottom - lastViewBottom), mScrollDuration);
                    } 
                } 
                break;
            } 
            case MOVE_OFFSET:
            {
    if(mLastSeenPos == firstPos)                
                {
                    post(this);
                    return;
                } 
                mLastSeenPos = firstPos;
                final int childCount = getChildCount();
                final int position = mTargetPos;
                final int lastPos = firstPos + childCount - 1;
                int viewTravelCount = 0;
    if(position < firstPos)                
                {
                    viewTravelCount = firstPos - position + 1;
                } 
                else
    if(position > lastPos)                
                {
                    viewTravelCount = position - lastPos;
                } 
                final float screenTravelCount = (float) viewTravelCount / childCount;
                final float modifier = Math.min(Math.abs(screenTravelCount), 1.f);
    if(position < firstPos)                
                {
                    smoothScrollBy((int) (-getHeight() * modifier), mScrollDuration);
                    post(this);
                } 
                else
    if(position > lastPos)                
                {
                    smoothScrollBy((int) (getHeight() * modifier), mScrollDuration);
                    post(this);
                } 
                else
                {
                    final int targetTop = getChildAt(position - firstPos).getTop();
                    final int distance = targetTop - mOffsetFromTop;
                    smoothScrollBy(distance,
                            (int) (mScrollDuration * ((float) distance / getHeight())));
                } 
                break;
            } 
            default:
            break;
}
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "6D32BAB94AC52022ABE497778A495DAC", hash_generated_field = "8760D23EE3F52FD3EFA30CB2F922726A")

        private static final int SCROLL_DURATION = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "02C82B162D2A85797A66CB01E29B70B0", hash_generated_field = "DCF6966CB5E1D949B06701433BC1589F")

        private static final int MOVE_DOWN_POS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "63A071222A87531676875677B0989E32", hash_generated_field = "F5258406C91B10C35A200A14E23D83E8")

        private static final int MOVE_UP_POS = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "C032FEC22130B64512CC98C267B48A52", hash_generated_field = "F8253C6298924F79488F04EA928D548B")

        private static final int MOVE_DOWN_BOUND = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "BBA76F34EBD7F64DEFAC7A360A8B5B08", hash_generated_field = "F7D82C60FE0B843E3D09E43A9DCA6526")

        private static final int MOVE_UP_BOUND = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_field = "83197AE6299B7EAE58463509EF4FB028", hash_generated_field = "DCC3D3F749A0C671A9C741C7465D6AEC")

        private static final int MOVE_OFFSET = 5;
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.534 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.535 -0400", hash_original_method = "70826FE759108269AA8BACD409E1C863", hash_generated_method = "E26A3198F099257097F82026234CFD8D")
        @Override
        public void onChanged() {
            
            super.onChanged();
    if(mFastScroller != null)            
            {
                mFastScroller.onSectionsChanged();
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.535 -0400", hash_original_method = "4570C5F375E9950A79093241C88AF34D", hash_generated_method = "998A61012C470C10CEE76ECE5B390EC1")
        @Override
        public void onInvalidated() {
            
            super.onInvalidated();
    if(mFastScroller != null)            
            {
                mFastScroller.onSectionsChanged();
            } 
            
            
            
                
            
        }

        
    }


    
    class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.535 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "8BFC2A3FD2E90E6CAECA368B78AA0988")

        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.535 -0400", hash_original_method = "55A4C0C73524FA4BF08CABB1B8DF874B", hash_generated_method = "55A4C0C73524FA4BF08CABB1B8DF874B")
        public MultiChoiceModeWrapper ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.536 -0400", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "3BE0D93844CB69FC6467C6B3B65058ED")
        public void setWrapped(MultiChoiceModeListener wrapped) {
            mWrapped = wrapped;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.536 -0400", hash_original_method = "92496BA2B215F9BD39661C34B9C10361", hash_generated_method = "A24967210DA5FE5BC31B3F93A23D77EC")
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            
            addTaint(menu.getTaint());
            addTaint(mode.getTaint());
    if(mWrapped.onCreateActionMode(mode, menu))            
            {
                setLongClickable(false);
                boolean varB326B5062B2F0E69046810717534CB09_192302802 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889569982 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889569982;
            } 
            boolean var68934A3E9455FA72420237EB05902327_336957953 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020953110 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020953110;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.536 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "3CE07A9967887E89E233381750101AD1")
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            
            addTaint(menu.getTaint());
            addTaint(mode.getTaint());
            boolean var55A4B186F0A789314BD40982435B2F2D_1753816100 = (mWrapped.onPrepareActionMode(mode, menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885662973 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_885662973;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.536 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "B21892A3777A441099304E81E9F97060")
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            
            addTaint(item.getTaint());
            addTaint(mode.getTaint());
            boolean varA67BC1BFCCEC726462A8C31B6FE3D86A_1974165987 = (mWrapped.onActionItemClicked(mode, item));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728283098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728283098;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.537 -0400", hash_original_method = "38D50D306A79D91BC9BAC512614B14E4", hash_generated_method = "A9BED5FEF65918068126A34C53A7F6C4")
        public void onDestroyActionMode(ActionMode mode) {
            
            addTaint(mode.getTaint());
            mWrapped.onDestroyActionMode(mode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_method = "54A7C456AE4C179767C141D1533A24F9", hash_generated_method = "C5AD1937D7C1CE8A5E3305BADFDB56C2")
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked) {
            
            addTaint(checked);
            addTaint(id);
            addTaint(position);
            addTaint(mode.getTaint());
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
    if(getCheckedItemCount() == 0)            
            {
                mode.finish();
            } 
            
            
            
                
            
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_field = "BE99FDADF4634E48B1DF67A9485E0784", hash_generated_field = "D0AF750B588A0A8385D3506BD31A2EB8")

        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        }) int viewType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_field = "55471D4F82D5EFF522A6B7E31CC4A788", hash_generated_field = "211C82A03CAC4BFE4A39D3AFA73F8466")

        @ViewDebug.ExportedProperty(category = "list") boolean recycledHeaderFooter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_field = "330307ED6FC7975F67F11BB81BE3F1A9", hash_generated_field = "D6FCB86C3CDA915253A7995A3263A2E5")

        @ViewDebug.ExportedProperty(category = "list") boolean forceAdd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_field = "E573CA3738335F5135D0DDAEEA121E67", hash_generated_field = "9656FC663DC419C2046BE7A145261352")

        int scrappedFromPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "503F8BCA6BB39449EFF41178BE64A21C")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.538 -0400", hash_original_method = "CB5E57490495E3D022159C4744E426CF", hash_generated_method = "DD156D22C1ED36A6CD7316161C04548F")
        public  LayoutParams(int w, int h, int viewType) {
            super(w, h);
            addTaint(h);
            addTaint(w);
            this.viewType = viewType;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
    }


    
    class RecycleBin {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "63E890074C591F3B9ADCE0E62142C93F", hash_generated_field = "6E808820BD4FD463611A15BFE36E91A3")

        private RecyclerListener mRecyclerListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "F9B783D9BCAFBFD5783C0A59D5D53319", hash_generated_field = "3638089149F436DC275AC3B59DF7B7C3")

        private int mFirstActivePosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "424ED9F881A5AEDE2DC7FD2B4F700F0E", hash_generated_field = "4E509E23454F116649D54EFD8741D664")

        private View[] mActiveViews = new View[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "D4FAB650ECA27500DEB6EEAEC3D1EB1D", hash_generated_field = "D87C278D091E93A90D61A3043FADF22D")

        private ArrayList<View>[] mScrapViews;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "E54D91FDD7887C0F3B4A327DE6D111A6", hash_generated_field = "F891A96632BBCEAB30959FDFBD22CDE9")

        private int mViewTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_field = "D044D48CB87C97DCEB31A7992E06F2A4", hash_generated_field = "6256C7755218C1B9CBEA2B18392BAB2B")

        private ArrayList<View> mCurrentScrap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.539 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.540 -0400", hash_original_method = "2027E38C638AFAF08EBC73DB2999B11D", hash_generated_method = "723B15D44FB66E38A22A594FF7DD8C5E")
        public void setViewTypeCount(int viewTypeCount) {
    if(viewTypeCount < 1)            
            {
                IllegalArgumentException var82CCC422D6A4AE9F384389AA639A4C01_1887939484 = new IllegalArgumentException("Can't have a viewTypeCount < 1");
                var82CCC422D6A4AE9F384389AA639A4C01_1887939484.addTaint(taint);
                throw var82CCC422D6A4AE9F384389AA639A4C01_1887939484;
            } 
            ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
for(int i = 0;i < viewTypeCount;i++)
            {
                scrapViews[i] = new ArrayList<View>();
            } 
            mViewTypeCount = viewTypeCount;
            mCurrentScrap = scrapViews[0];
            mScrapViews = scrapViews;
            
            
                
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.540 -0400", hash_original_method = "84FB41DBF94FAC74E383190ECD19AC3F", hash_generated_method = "9A9319D2364900C8800856D20A094144")
        public void markChildrenDirty() {
    if(mViewTypeCount == 1)            
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
for(int i = 0;i < scrapCount;i++)
                {
                    scrap.get(i).forceLayout();
                } 
            } 
            else
            {
                final int typeCount = mViewTypeCount;
for(int i = 0;i < typeCount;i++)
                {
                    final ArrayList<View> scrap = mScrapViews[i];
                    final int scrapCount = scrap.size();
for(int j = 0;j < scrapCount;j++)
                    {
                        scrap.get(j).forceLayout();
                    } 
                } 
            } 
            
            
                
                
                
                    
                
            
                
                
                    
                    
                    
                        
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.540 -0400", hash_original_method = "511AFE11A00C49C0B36C81F833AD1339", hash_generated_method = "0A7FE0DA84DB6C5D790AD5A1393A0EAB")
        public boolean shouldRecycleViewType(int viewType) {
            addTaint(viewType);
            boolean var9B5598882E3194D9C367A0D5A13DFA1A_1082970489 = (viewType >= 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759561094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_759561094;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.542 -0400", hash_original_method = "D3A3C7CFD0DB416C40300347744B44D9", hash_generated_method = "F4983350841F5AB3246BA267B7F73BF2")
         void clear() {
    if(mViewTypeCount == 1)            
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
for(int i = 0;i < scrapCount;i++)
                {
                    removeDetachedView(scrap.remove(scrapCount - 1 - i), false);
                } 
            } 
            else
            {
                final int typeCount = mViewTypeCount;
for(int i = 0;i < typeCount;i++)
                {
                    final ArrayList<View> scrap = mScrapViews[i];
                    final int scrapCount = scrap.size();
for(int j = 0;j < scrapCount;j++)
                    {
                        removeDetachedView(scrap.remove(scrapCount - 1 - j), false);
                    } 
                } 
            } 
            
            
                
                
                
                    
                
            
                
                
                    
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.542 -0400", hash_original_method = "8EEC6DB7AE7CDFC4B2320C472F7412E6", hash_generated_method = "0FDCC1FD9DCF459E5990E783ACD53746")
         void fillActiveViews(int childCount, int firstActivePosition) {
    if(mActiveViews.length < childCount)            
            {
                mActiveViews = new View[childCount];
            } 
            mFirstActivePosition = firstActivePosition;
            final View[] activeViews = mActiveViews;
for(int i = 0;i < childCount;i++)
            {
                View child = getChildAt(i);
                AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
    if(lp != null && lp.viewType != ITEM_VIEW_TYPE_HEADER_OR_FOOTER)                
                {
                    activeViews[i] = child;
                } 
            } 
            
            
                
            
            
            
            
                
                
                
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.543 -0400", hash_original_method = "6DDE0EAFBBDE35C2F4BC64D693E74936", hash_generated_method = "5362CE189465FC6D9E1C82B32FB58BE0")
         View getActiveView(int position) {
            addTaint(position);
            int index = position - mFirstActivePosition;
            final View[] activeViews = mActiveViews;
    if(index >=0 && index < activeViews.length)            
            {
                final View match = activeViews[index];
                activeViews[index] = null;
View varED81284B0460DBAE2301CCD33AC92E85_1073597817 =                 match;
                varED81284B0460DBAE2301CCD33AC92E85_1073597817.addTaint(taint);
                return varED81284B0460DBAE2301CCD33AC92E85_1073597817;
            } 
View var540C13E9E156B687226421B24F2DF178_904738142 =             null;
            var540C13E9E156B687226421B24F2DF178_904738142.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_904738142;
            
            
            
            
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.543 -0400", hash_original_method = "7C1BB02F0CFB7D7F7BDB0DC42C0788DA", hash_generated_method = "3459A2763163568663A85B82201ABCF9")
         View getScrapView(int position) {
            addTaint(position);
    if(mViewTypeCount == 1)            
            {
View var07B971F5A8DEF5D56AA1B34CA6C8B893_1528113774 =                 retrieveFromScrap(mCurrentScrap, position);
                var07B971F5A8DEF5D56AA1B34CA6C8B893_1528113774.addTaint(taint);
                return var07B971F5A8DEF5D56AA1B34CA6C8B893_1528113774;
            } 
            else
            {
                int whichScrap = mAdapter.getItemViewType(position);
    if(whichScrap >= 0 && whichScrap < mScrapViews.length)                
                {
View var7FB62EDA92367AF65A4822D6E0793912_1775339337 =                     retrieveFromScrap(mScrapViews[whichScrap], position);
                    var7FB62EDA92367AF65A4822D6E0793912_1775339337.addTaint(taint);
                    return var7FB62EDA92367AF65A4822D6E0793912_1775339337;
                } 
            } 
View var540C13E9E156B687226421B24F2DF178_1938456085 =             null;
            var540C13E9E156B687226421B24F2DF178_1938456085.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1938456085;
            
            
                
            
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.544 -0400", hash_original_method = "ED120D0157D66531494A9FD53EAE380E", hash_generated_method = "494261567A99B78B96388254C6B75B86")
         void addScrapView(View scrap, int position) {
            addTaint(position);
            addTaint(scrap.getTaint());
            AbsListView.LayoutParams lp = (AbsListView.LayoutParams) scrap.getLayoutParams();
    if(lp == null)            
            {
                return;
            } 
            int viewType = lp.viewType;
    if(!shouldRecycleViewType(viewType))            
            {
    if(viewType != ITEM_VIEW_TYPE_HEADER_OR_FOOTER)                
                {
                    removeDetachedView(scrap, false);
                } 
                return;
            } 
            lp.scrappedFromPosition = position;
    if(mViewTypeCount == 1)            
            {
                scrap.dispatchStartTemporaryDetach();
                mCurrentScrap.add(scrap);
            } 
            else
            {
                scrap.dispatchStartTemporaryDetach();
                mScrapViews[viewType].add(scrap);
            } 
    if(mRecyclerListener != null)            
            {
                mRecyclerListener.onMovedToScrapHeap(scrap);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.545 -0400", hash_original_method = "3138270AA2660474D2B7E99137A02556", hash_generated_method = "2CA9D15A69413A9E8194BAF64C4E94E5")
         void scrapActiveViews() {
            final View[] activeViews = mActiveViews;
            final boolean hasListener = mRecyclerListener != null;
            final boolean multipleScraps = mViewTypeCount > 1;
            ArrayList<View> scrapViews = mCurrentScrap;
            final int count = activeViews.length;
for(int i = count - 1;i >= 0;i--)
            {
                final View victim = activeViews[i];
    if(victim != null)                
                {
                    final AbsListView.LayoutParams lp = (AbsListView.LayoutParams) victim.getLayoutParams();
                    int whichScrap = lp.viewType;
                    activeViews[i] = null;
    if(!shouldRecycleViewType(whichScrap))                    
                    {
    if(whichScrap != ITEM_VIEW_TYPE_HEADER_OR_FOOTER)                        
                        {
                            removeDetachedView(victim, false);
                        } 
                        continue;
                    } 
    if(multipleScraps)                    
                    {
                        scrapViews = mScrapViews[whichScrap];
                    } 
                    victim.dispatchStartTemporaryDetach();
                    lp.scrappedFromPosition = mFirstActivePosition + i;
                    scrapViews.add(victim);
    if(hasListener)                    
                    {
                        mRecyclerListener.onMovedToScrapHeap(victim);
                    } 
    if(ViewDebug.TRACE_RECYCLER)                    
                    {
                        ViewDebug.trace(victim,
                                ViewDebug.RecyclerTraceType.MOVE_FROM_ACTIVE_TO_SCRAP_HEAP,
                                mFirstActivePosition + i, -1);
                    } 
                } 
            } 
            pruneScrapViews();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.546 -0400", hash_original_method = "EA58D1FE496277FE2ED85A93396A169A", hash_generated_method = "DD00E4938C144AC8B26A18649AC5466F")
        private void pruneScrapViews() {
            final int maxViews = mActiveViews.length;
            final int viewTypeCount = mViewTypeCount;
            final ArrayList<View>[] scrapViews = mScrapViews;
for(int i = 0;i < viewTypeCount;++i)
            {
                final ArrayList<View> scrapPile = scrapViews[i];
                int size = scrapPile.size();
                final int extras = size - maxViews;
                size--;
for(int j = 0;j < extras;j++)
                {
                    removeDetachedView(scrapPile.remove(size--), false);
                } 
            } 
            
            
            
            
            
                
                
                
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.547 -0400", hash_original_method = "3FD0A968FC7E2613466435C98B02B7BD", hash_generated_method = "EEDFC3E74D6FD21E2890B660CB986A7F")
         void reclaimScrapViews(List<View> views) {
            addTaint(views.getTaint());
    if(mViewTypeCount == 1)            
            {
                views.addAll(mCurrentScrap);
            } 
            else
            {
                final int viewTypeCount = mViewTypeCount;
                final ArrayList<View>[] scrapViews = mScrapViews;
for(int i = 0;i < viewTypeCount;++i)
                {
                    final ArrayList<View> scrapPile = scrapViews[i];
                    views.addAll(scrapPile);
                } 
            } 
            
            
                
            
                
                
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.547 -0400", hash_original_method = "BA10D81754F1A95A0F7C755DD4764D3B", hash_generated_method = "1CD8E06B78664ACD174D333F857A9010")
         void setCacheColorHint(int color) {
            addTaint(color);
    if(mViewTypeCount == 1)            
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
for(int i = 0;i < scrapCount;i++)
                {
                    scrap.get(i).setDrawingCacheBackgroundColor(color);
                } 
            } 
            else
            {
                final int typeCount = mViewTypeCount;
for(int i = 0;i < typeCount;i++)
                {
                    final ArrayList<View> scrap = mScrapViews[i];
                    final int scrapCount = scrap.size();
for(int j = 0;j < scrapCount;j++)
                    {
                        scrap.get(j).setDrawingCacheBackgroundColor(color);
                    } 
                } 
            } 
            final View[] activeViews = mActiveViews;
            final int count = activeViews.length;
for(int i = 0;i < count;++i)
            {
                final View victim = activeViews[i];
    if(victim != null)                
                {
                    victim.setDrawingCacheBackgroundColor(color);
                } 
            } 
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.547 -0400", hash_original_field = "7D1F549A875745DA59610A279FF98C6A", hash_generated_field = "E0C0A7FB76C7D7FDA0F484B266D28899")

    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "CDE4EB733ED72E76C38D63649282466C", hash_generated_field = "421A8713FDFFB5C0C2BFB5F481F1F2FC")

    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "FE06291F5D87ED7DD9A7BB8F8A0D4CA7", hash_generated_field = "E1312AD0C8B74E42EC3EE6028B1137B6")

    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "B17A4043A5EC6ADB4C25FF7C74A22435", hash_generated_field = "1A65913029CD13477BA64563C54FFD4B")

    static final int TOUCH_MODE_REST = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "693680368AD0BD02276179792348EADA", hash_generated_field = "BF46F64D4AB1CB6C3D3AFC128E88F131")

    static final int TOUCH_MODE_DOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "EC76282AC2561CD363039347CF179E7A", hash_generated_field = "B0569807CBB5B462D97BD49753CF9491")

    static final int TOUCH_MODE_TAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "9F4456FE44624E2AFC940A0465B3A097", hash_generated_field = "A74A1CE702CCC92436644F77B7A85141")

    static final int TOUCH_MODE_DONE_WAITING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "2EEB434A0367FA7DF75FCCCA418ED5A6", hash_generated_field = "A7874F652310534ED2E48713722C968E")

    static final int TOUCH_MODE_SCROLL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "A3F3E68500FFCA6BEC388A593AD55E8D", hash_generated_field = "F745E8763A46E798FA58BA919DF435B6")

    static final int TOUCH_MODE_FLING = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "6912EC2E8C428C3E5EF5E2B1D6B96D97", hash_generated_field = "65D38BF1EEECB664AFC79AB59359D9F2")

    static final int TOUCH_MODE_OVERSCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "CFF51771A57BB12D98CF3DBA460C3142", hash_generated_field = "D34672476DCFE73B3F16CA72EB28F066")

    static final int TOUCH_MODE_OVERFLING = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "E29B3AF9E5F6AEE4BA465DAE46CAAC41", hash_generated_field = "307F2C2AACAC6613A6B819B1C46E9BEC")

    static final int LAYOUT_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "4D7A3B72023A68BEFFC3ED5BE8F99A79", hash_generated_field = "8858F00D2FC0F97FA91A4A452FE42A3E")

    static final int LAYOUT_FORCE_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "3B2B6E287126A61BA2B94A3B61A31DEB", hash_generated_field = "C9D08A824763C3FF89EC230BC5EBEA19")

    static final int LAYOUT_SET_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "A2D8EBC46AF970886DB38E17FA3DF022", hash_generated_field = "504C59967FB303DF657FE1D3F305C5D0")

    static final int LAYOUT_FORCE_BOTTOM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "E766E3DD98613EBA901DF572ED840902", hash_generated_field = "F1FBE80C1B23C45E6D01D0BA249DB345")

    static final int LAYOUT_SPECIFIC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "032014FE7C510E0E4B984E3FDB4FFC5E", hash_generated_field = "846A9498FB0ABE0CE7726FC2AB67A29C")

    static final int LAYOUT_SYNC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "EECD2AD33B6C7CC83F468CC38D4F5EBA", hash_generated_field = "227AB8582020535483796213A6EBF50A")

    static final int LAYOUT_MOVE_SELECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "8D280EE6CE7BD607DD9CFD2FEBD4331A", hash_generated_field = "C4D29CBAF23D3100F74985968BC044B6")

    public static final int CHOICE_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "A88E8015B5E7C102D0E4E5C329EE0B0A", hash_generated_field = "8ACFD8F9A2D07A54C73A4603D3C11699")

    public static final int CHOICE_MODE_SINGLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "191E984C863FDD720FB7803FEB1E5AC7", hash_generated_field = "35513B4AE78E0FC364C3E99A7BACE878")

    public static final int CHOICE_MODE_MULTIPLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "55297737093C40EB0446D105E6BC2BF6", hash_generated_field = "8C15E8901DB2548719C9BDD4426BD6C4")

    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "DF83619CF8CE79415D5849EAB6531F4D", hash_generated_field = "5D646DC42A86BD62288C592A5533029A")

    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "D16CE528694D125BEF5912F00C5A2E99", hash_generated_field = "33995481F66B2BB4E0A516C56A797FAE")

    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "155C3D6D52A3AC47DB7F11D2D6ABC0C9", hash_generated_field = "4232090D870E37044033C5A96825AC60")

    private static final int TOUCH_MODE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.548 -0400", hash_original_field = "25D4A8329815B118CAB37A548D0C8D7A", hash_generated_field = "38D3EC1233BE9FEC7E013AE0CFEBD8DD")

    private static final int TOUCH_MODE_ON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.549 -0400", hash_original_field = "E986EE0A950AB519A9D78E5F63C4BE79", hash_generated_field = "7D9ADB0F602E4659CCF6E8DDDB3ED6E5")

    private static final int TOUCH_MODE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.549 -0400", hash_original_field = "A07FD6552E4DC46AC3F39BFD68136463", hash_generated_field = "E7D81FF0F37E8DBAE850DA049B83B27B")

    private static final boolean PROFILE_SCROLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.549 -0400", hash_original_field = "CB81333E4C8FBCF9DC4472A4127AA8DB", hash_generated_field = "10908BC5D74B320FCDD3C04619CCD594")

    private static final boolean PROFILE_FLINGING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:03.549 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

