package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "FDB445A6FE3D3AE5BF46B0E337AD4937", hash_generated_field = "383DDBE003D416456C310D4158C4CFB9")

    int mChoiceMode = CHOICE_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "3D0732796D8971C4EE44D7D21A3E57FC", hash_generated_field = "48C1F0333DFD0DC72046CFA915BFC8E8")

    ActionMode mChoiceActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "14B80F5AC98F0F6EA047E368DBDFB9E6", hash_generated_field = "8DB318A3968ACAA4E72C29D459103061")

    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "15A65D8079003A56299BBC3EC8F634A7", hash_generated_field = "69D140D043E457BD61D5B9F6552EF517")

    int mCheckedItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "FFDCDF85D0490AC0CCCFF2CB523F8053", hash_generated_field = "CA6CC91745E43EBBCA6C857FDAD05357")

    SparseBooleanArray mCheckStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "9B60E0D0F065913372A6ACFC5498034B", hash_generated_field = "869EB89A549CFEBFB16DD4FED9649B6E")

    LongSparseArray<Integer> mCheckedIdStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "4E9548BDDA1DC25FD9BD2651109B61A0", hash_generated_field = "D9E7894D012FFAF92CE958370EAAE107")

    int mLayoutMode = LAYOUT_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "BA07A3DE43E99CA12488218E7E590AA0", hash_generated_field = "386E575B164CBA38A9F16CB0F74210CE")

    private RemoteViewsAdapter mRemoteAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "A4A26F367FC0C1227F7A5E61B89ABBBE")

    private boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "3331386BB2D82834F199D617F558D297", hash_generated_field = "A1E757D1ECB75F11B7A5FD22CFD8D6DE")

    boolean mDrawSelectorOnTop = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "D697BABF55DFD739589D0F84316D9938", hash_generated_field = "FF4158F9C935D5CC585FE18F81632212")

    Drawable mSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "03D1E6E3F8B7161297631CBC27F2E39C", hash_generated_field = "15C7707915A6B0B74E44A43E1542C958")

    int mSelectorPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "E616CA52B8CBE0A879AD74D361065EF6", hash_generated_field = "C524FC1C3E6AAF765E2CAB633026E31B")

    Rect mSelectorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "850AAD212EF4F4A7E8993BB802A79E8B", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "EC383219D6D8A4B6B87A786F4327EE03", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "FA8EABBC9D79FB4F912796BE168AD76D", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "F2D6183DA068D77902D36BB38A7570E0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "63EC0412604CE1A7BE02B1C77E43E6CF", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "43539E3842DB97BCC325856D94133A8F", hash_generated_field = "05D43BB1A495A731310553613FE206DD")

    Rect mListPadding = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "D1D6B0DE36366002E2A19031D3776ED0", hash_generated_field = "F34547E4E9C4393B08D5498F65FC370A")

    int mWidthMeasureSpec = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "8A37B3642AE63312BB9AEE8EDA851905", hash_generated_field = "00AF12951227F69DA5FB3783B6D532DB")

    View mScrollUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "B3BBDA53E3217BD8FB4C3525F2C8FB8D", hash_generated_field = "045245010980799FDB6036E67E9F436F")

    View mScrollDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "3AA53ED1199B42ED017A1F3E2400A292", hash_generated_field = "6E445E4EED263A45A094087A50B7126E")

    boolean mCachingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "56FC3C5C26F1649CC65F1FB2A1EA9DC9", hash_generated_field = "0AB9D53170F11322593A4B241676E18D")

    boolean mCachingActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "981700988B7F4FB2FEF9A4D8DDC3B56E", hash_generated_field = "6516B57613A0784EC2DDB500ABA92556")

    int mMotionPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "CB13AD9208BD36E3C502183D21166D8E", hash_generated_field = "9D04282A1BDDC504BC19852147A5D64D")

    int mMotionViewOriginalTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "064676185859A1F3857E03A91BADBB72", hash_generated_field = "2086F63C3164AF1AA06DFC0C51452109")

    int mMotionViewNewTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "5518D15E5E059B7526448CC0900DCECE", hash_generated_field = "E9714F671BCE6666EDE234DD36661DA0")

    int mMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "E24F0E4927BC6420254A5B51253AB150", hash_generated_field = "BAC7C8FFD482868C2E281DB29DBFE06D")

    int mMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "3E0C99B6B345CE34A5565B62F1083D79", hash_generated_field = "7C51C810E963B7D188B47B8F49B7DDE4")

    int mTouchMode = TOUCH_MODE_REST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "048ECB2D11DDC21BDA8C31B82C3211AD", hash_generated_field = "C4455B3957BD1EE48827818491DAA168")

    int mLastY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "7FDF3596AB5C6361CE994F6A8201D88E", hash_generated_field = "1C8B3319825706CAEF653B7569131ADE")

    int mMotionCorrection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "55E8748CF9C4663AD1425AFFC03DE229", hash_generated_field = "6E948CA7630EFB6162DA2EBAA4208363")

    private FlingRunnable mFlingRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "B2332CA85B873A0B0263A4DD84BB9442", hash_generated_field = "3A7EBB83D687A969A9AA75982B56B68B")

    private PositionScroller mPositionScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "4D232D35AB2F2A91FDF0192889384336", hash_generated_field = "77BDF9079A717E33AEBAD612261D859E")

    int mSelectedTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "452AAACA6529C6DDC61AC74D560EC80F", hash_generated_field = "A2083A1B78272D6D26A8F8E0BA5E2327")

    boolean mStackFromBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "7FB4BC12E46C9E48428AFBC608C49853", hash_generated_field = "3BD9FEE95F32C4889FDFAAEB81585604")

    boolean mScrollingCacheEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "15797563431B975E4FF5A08BDEC264DA", hash_generated_field = "AB477B88BF820ABA168568369EF3F457")

    boolean mFastScrollEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "0970AE3033B8F8E13936EF3E29D48B2E", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.858 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "7E4C7D8A72122A6640DF0AA884C2245D")

    PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "722CD50A11B36E9DDDD2F9392836F175", hash_generated_field = "E12C98919B28D2782FD5E54CA9C7E663")

    EditText mTextFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "16D582D908E13FC506985FFCA54C3849", hash_generated_field = "99B5A44FD56940F18C75CE655B9A1668")

    private boolean mSmoothScrollbarEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "586CD8929678603BADF3EAE99555BE68", hash_generated_field = "10C9AD0517CE8D8A09913559356A8C56")

    private boolean mTextFilterEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "36C832B0627AFDF6338A4E9703CAD999", hash_generated_field = "E5AC0509E741D92E16D3D731D4E96C35")

    private boolean mFiltered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "2D90C7DCE7997683B43703723C5CE198", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "064FE42B46208CBC35991D5A7C24006E", hash_generated_field = "A7BFECA874263BCC8A6464704B9D41D9")

    int mResurrectToPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "C7741A0A622E5D31931CC54BDFAA705B", hash_generated_field = "83C7C32482C7E5A03D695886EA4705D5")

    private ContextMenuInfo mContextMenuInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "B3EE28A70FD254A5A734CAFFFD9F2578", hash_generated_field = "CAABAA47CA52B1F5C0386B90B683E22C")

    int mOverscrollMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "50D6DEF2D13611E8D0E41D610E4194EC", hash_generated_field = "CFC250691336B4B39585FE305D07A5A8")

    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "DFFFABFC0994B627F8D236F3905F6919", hash_generated_field = "8AE445FC94FDAEC334CFCA8838E3B70E")

    private boolean mScrollProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "8C5835FEC163B16D102063BC8F2C1248", hash_generated_field = "69AFA437C5D84E7EE29B4FE44E13B088")

    private boolean mFlingProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "956789F3DA470AD87E91A7076E41578B", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "9567FFD92CF28040BB18362734DD4369", hash_generated_field = "6BA43AA573D039EEDC72EB768AE06B64")

    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "83D78F1B989F8D62D88496F5EC6FF33F", hash_generated_field = "07CC57CA51A809E0D650A47A9B235FD7")

    private AbsListView.PerformClick mPerformClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "66EF6F4B5EA8F655178F52CF9F60EB91", hash_generated_field = "04EA068A0D45E96537B1140190A89770")

    private Runnable mTouchModeReset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "B59250E72778FF38D50B7661501C8F31", hash_generated_field = "1526254A73CD23B3F5170A2D59CF9F76")

    private int mTranscriptMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "5CB078F03E28D94B5DD6707B7823D2ED", hash_generated_field = "1B8E8F372FC2DAC037EC526954D125A4")

    private int mCacheColorHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "33F961CDAC96AE08DD70684978D9836B", hash_generated_field = "0F85F813AE78D809D6545B656F7C07C7")

    private boolean mIsChildViewEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "DB0605A6A9286B4B3CF497EAF4906666", hash_generated_field = "9D6B53868A098EC5A838EECA6460C254")

    private int mLastScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "4F737BBBBA31571ABB2F993907F88669", hash_generated_field = "FE09333368CBF6471ABE6F31E47E522C")

    private FastScroller mFastScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "5612C2662D978BF558FD7AA146C3290E", hash_generated_field = "8D12711C83D9C6A8E3A8DA9BEC091FCE")

    private boolean mGlobalLayoutListenerAddedFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "D9269244F21F5C31BC4C06A0545F0761", hash_generated_field = "3CCF90D786BE55C250C6CD780F8D19C3")

    private float mDensityScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "300ACBBBBD6F3498749333183FF92783", hash_generated_field = "92752ACB14767626BA8FAB32711AE1A6")

    private InputConnection mDefInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "C2FA9D2B5583B9601295BA7FB05D7F95", hash_generated_field = "048E465914FAB6B457D7426F9FB399BD")

    private InputConnectionWrapper mPublicInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "52C2576C8945A7A83AF5BFD6781D387F", hash_generated_field = "20FDBC6BCA9CEE1B1E479A246AC00217")

    private Runnable mClearScrollingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "ACAB612EAF9F4A8FD31B6DAD171C86FC", hash_generated_field = "32DD593911EBA2DE7D4B7E5052058A82")

    private float mVelocityScale = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "592389443AC9BF2094ADFD76AA22F7AE", hash_generated_field = "3A7729712A4A2CC963B04549E3BBA6B5")

    final boolean[] mIsScrap = new boolean[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "06749DD524BE381345057152BDEA5C9E", hash_generated_field = "AD55617BE800751F5B53C823CD34BAAE")

    private boolean mPopupHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "3140A319F32CA873045621864B655537")

    int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "F239C82AEB45C28104273F86A78E6F04")

    int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "445A0C2969A51E83292F7A48A01F98A3", hash_generated_field = "C116882C31FC92381FC21BBC7F61A670")

    private int mFirstPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "0EB1273195375A97262E41F466E36FAF", hash_generated_field = "0D7647AA84F359D8EC76D4A85F02F8A5")

    private int mLastPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "04081D36EE14DF5AD4E0EC7150A5F126", hash_generated_field = "BE4199720272019245F0BE0F2D9EF958")

    private int mDirection = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "39ABF7FC59545839E1E692CD25B4EABA", hash_generated_field = "D5B94B1CE48D1F35D7827F180B43A659")

    private boolean mForceTranscriptScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "02F451968FD533EEF7D3944E7669E9A2", hash_generated_field = "13A0640F3C08F553786642C29E645CCC")

    private int mGlowPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "22F2EAAA4524A77ECA0826E1C2B0F476", hash_generated_field = "9E94FEEAC15232AEE61DC08B2319DDAA")

    private int mGlowPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "6256DF52CF0ED50BC6EE01394EF5CB10", hash_generated_field = "740236379897EF8ABD678F65696A25EA")

    private int mLastAccessibilityScrollEventFromIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "81F3A0960933278C26B58CAE75D60E40", hash_generated_field = "9F103C6DB9B3EB29E780CB30462F5591")

    private int mLastAccessibilityScrollEventToIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "0AD971D9895BFC06CF48F77D1B9D890A", hash_generated_field = "4F9C4241EE9024683E4B1C2A3BA5C180")

    boolean mIsAttached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.859 -0400", hash_original_field = "4A894AB51819552684504464AA94B729", hash_generated_field = "9CAD0235527F91F182E61802511E0DCF")

    private int mLastHandledItemCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.860 -0400", hash_original_method = "6A1152DD2F769DBF7D49F3027748695E", hash_generated_method = "F606CC956527B916BCBC67315C95F384")
    public  AbsListView(Context context) {
        super(context);
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray a = context.obtainStyledAttributes(R.styleable.View);
        initializeScrollbars(a);
        a.recycle();
        addTaint(context.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.860 -0400", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "BA92C15F48D9FE5175CCC53C3BA0B19F")
    public  AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.861 -0400", hash_original_method = "A8C0C093ECB8745800A88EB739981F47", hash_generated_method = "D079EE27BCA85E9C507442B0ECFBE291")
    public  AbsListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAbsListView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsListView, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.AbsListView_listSelector);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.861 -0400", hash_original_method = "2C481DB3FCB8FF016FB8E3D34F80B2B8", hash_generated_method = "4EE40469C2C86DCD6B9F429C4CCE0F16")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.862 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "1CA11FD4B7CABC4E3AF912A1AAF56E24")
    @Override
    public void setOverScrollMode(int mode) {
        {
            {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context);
                mEdgeGlowBottom = new EdgeEffect(context);
            } 
        } 
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        } 
        super.setOverScrollMode(mode);
        addTaint(mode);
        
        
            
                
                
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.863 -0400", hash_original_method = "2831A8F535381CCEFB0BADB6BC86E26A", hash_generated_method = "D7E926F4F8C7903594E430AF21FC2F3E")
    @Override
    public void setAdapter(ListAdapter adapter) {
        {
            {
                boolean var38CEBABFDDE46DFC47E0A770A36F9546_416928741 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
                    mCheckedIdStates == null);
                {
                    mCheckedIdStates = new LongSparseArray<Integer>();
                } 
            } 
        } 
        {
            mCheckStates.clear();
        } 
        {
            mCheckedIdStates.clear();
        } 
        addTaint(adapter.getTaint());
        
        
            
                    
                
            
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.863 -0400", hash_original_method = "5DFF60E6C611266C8D61B940778B8222", hash_generated_method = "F48516B66B1EF2E32EDEC41E1872DBF4")
    public int getCheckedItemCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051337871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051337871;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.864 -0400", hash_original_method = "76DE4C8AF2033C88DA13B2D6D79BE8CC", hash_generated_method = "F2579413DEDE01DE63E1513518A53721")
    public boolean isItemChecked(int position) {
        {
            boolean var0D150F0C81FAF2A662314396EC0C31E7_1461058533 = (mCheckStates.get(position));
        } 
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775864653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_775864653;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.864 -0400", hash_original_method = "40A1040C0B9BA1980C4FD0733FBB2F2E", hash_generated_method = "19734C28EC8D87C7BF48966336E5E3D7")
    public int getCheckedItemPosition() {
        {
            boolean varA1B9DE9EDBC04ECFD56B33C2A5BF45B0_747599941 = (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1);
            {
                int varD7BABAE4F11D1568725A045F030C9B34_1788878421 = (mCheckStates.keyAt(0));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142866115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142866115;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.865 -0400", hash_original_method = "DD9B0503EDD82432AE0B7C0599D4B447", hash_generated_method = "2682EFD7D59A5C8BC46815D4DF93706D")
    public SparseBooleanArray getCheckedItemPositions() {
        SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_2105680336 = null; 
        SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_1001761364 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2105680336 = mCheckStates;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1001761364 = null;
        SparseBooleanArray varA7E53CE21691AB073D9660D615818899_2100237420; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2100237420 = varB4EAC82CA7396A68D541C85D26508E83_2105680336;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2100237420 = varB4EAC82CA7396A68D541C85D26508E83_1001761364;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2100237420.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2100237420;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.865 -0400", hash_original_method = "C085907095DB552ED74D8B304576006A", hash_generated_method = "9FD47200C61E8DA783A50507CDCD4B32")
    public long[] getCheckedItemIds() {
        {
            long[] var674FEB06102F8AD50D6DDBD530249D3A_638068076 = (new long[0]);
        } 
        final LongSparseArray<Integer> idStates = mCheckedIdStates;
        final int count = idStates.size();
        final long[] ids = new long[count];
        {
            int i = 0;
            {
                ids[i] = idStates.keyAt(i);
            } 
        } 
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1295601905 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1295601905;
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.866 -0400", hash_original_method = "A5D48B0328BC1A467504F22AFA94E40C", hash_generated_method = "B4A93F25373379F44D7CE7CEDE8E78AC")
    public void clearChoices() {
        {
            mCheckStates.clear();
        } 
        {
            mCheckedIdStates.clear();
        } 
        mCheckedItemCount = 0;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.866 -0400", hash_original_method = "43E07392067BD1BC5F99F3882FA40E88", hash_generated_method = "4F806E848A5A2178A0AFD2A10D94AD06")
    public void setItemChecked(int position, boolean value) {
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } 
        {
            boolean oldValue = mCheckStates.get(position);
            mCheckStates.put(position, value);
            {
                boolean varDF5D6CF73909C5793DEDFF57AC70B3A9_325681991 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                {
                    {
                        mCheckedIdStates.put(mAdapter.getItemId(position), position);
                    } 
                    {
                        mCheckedIdStates.delete(mAdapter.getItemId(position));
                    } 
                } 
            } 
            {
                final long id = mAdapter.getItemId(position);
                mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                        position, id, value);
            } 
        } 
        {
            boolean updateIds = mCheckedIdStates != null && mAdapter.hasStableIds();
            {
                boolean varE3E83AB27085DF4D75DE8758E514DAA9_21521328 = (value || isItemChecked(position));
                {
                    mCheckStates.clear();
                    {
                        mCheckedIdStates.clear();
                    } 
                } 
            } 
            {
                mCheckStates.put(position, true);
                {
                    mCheckedIdStates.put(mAdapter.getItemId(position), position);
                } 
                mCheckedItemCount = 1;
            } 
            {
                boolean var425458AA9F83015DB14C2404DEE4E159_1433496505 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
                {
                    mCheckedItemCount = 0;
                } 
            } 
        } 
        {
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } 
        addTaint(position);
        addTaint(value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.867 -0400", hash_original_method = "9A0165787640E5C3A3D1AC60426CC2CC", hash_generated_method = "A002845DC246C03AC6A09ED2D71A670C")
    @Override
    public boolean performItemClick(View view, int position, long id) {
        boolean handled = false;
        boolean dispatchItemClick = true;
        {
            handled = true;
            {
                boolean newValue = !mCheckStates.get(position, false);
                mCheckStates.put(position, newValue);
                {
                    boolean varFFF95FDDB84D487F1FD71AE5B4D04DFA_386041470 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                    {
                        {
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } 
                        {
                            mCheckedIdStates.delete(mAdapter.getItemId(position));
                        } 
                    } 
                } 
                {
                    mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                            position, id, newValue);
                    dispatchItemClick = false;
                } 
            } 
            {
                boolean newValue = !mCheckStates.get(position, false);
                {
                    mCheckStates.clear();
                    mCheckStates.put(position, true);
                    {
                        boolean varD30D994107B77CF4004B51C1F80A4DE7_1547006343 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                        {
                            mCheckedIdStates.clear();
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } 
                    } 
                    mCheckedItemCount = 1;
                } 
                {
                    boolean var6ACBF7B7E15B02DF34CBCD44F94045DE_1678086123 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
                    {
                        mCheckedItemCount = 0;
                    } 
                } 
            } 
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
        } 
        {
            handled |= super.performItemClick(view, position, id);
        } 
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139621989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139621989;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.867 -0400", hash_original_method = "8E2D8E05EEC3041F2430430C00E99F2E", hash_generated_method = "65DC33E45ACF388333C20B22D11B0636")
    public int getChoiceMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619918388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619918388;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.868 -0400", hash_original_method = "31284EBF9693FA29D08DAAB1651BB216", hash_generated_method = "BBE8C1D5276ED4A505BF38D66E17BA8A")
    public void setChoiceMode(int choiceMode) {
        mChoiceMode = choiceMode;
        {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        } 
        {
            {
                mCheckStates = new SparseBooleanArray();
            } 
            {
                boolean var2BF65510232B6C8CFF89CFE72E6D8ACB_827621207 = (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds());
                {
                    mCheckedIdStates = new LongSparseArray<Integer>();
                } 
            } 
            {
                clearChoices();
                setLongClickable(true);
            } 
        } 
        
        
        
            
            
        
        
            
                
            
            
                
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.868 -0400", hash_original_method = "AB030C487B8A76B7A3B990C85D8D5284", hash_generated_method = "03CDA87A96CFE3F2496718C37939D57F")
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener) {
        {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        } 
        mMultiChoiceModeCallback.setWrapped(listener);
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.869 -0400", hash_original_method = "34BF563ABF29C3DFDECFCC44CD785338", hash_generated_method = "6AC2AC61B80861F49657B192AD698BD2")
    private boolean contentFits() {
        final int childCount = getChildCount();
        boolean varB916502A2FFF50967FBE5280BE01D3D7_1867824486 = (getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353754537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353754537;
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.869 -0400", hash_original_method = "595588F5399A1D343B61A8313A8ACA6F", hash_generated_method = "E1754E1D20827C2E7FB18D71C197611F")
    public void setFastScrollEnabled(boolean enabled) {
        mFastScrollEnabled = enabled;
        {
            {
                mFastScroller = new FastScroller(getContext(), this);
            } 
        } 
        {
            {
                mFastScroller.stop();
                mFastScroller = null;
            } 
        } 
        
        
        
            
                
            
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.869 -0400", hash_original_method = "76A971EB75129863E10E67DBAAA59745", hash_generated_method = "866060DEFC16C25E08080F85A7696E7E")
    public void setFastScrollAlwaysVisible(boolean alwaysShow) {
        {
            setFastScrollEnabled(true);
        } 
        {
            mFastScroller.setAlwaysShow(alwaysShow);
        } 
        computeOpaqueFlags();
        recomputePadding();
        addTaint(alwaysShow);
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.870 -0400", hash_original_method = "B8FB7506E98011F45E37A448BFD532A7", hash_generated_method = "8B1BC4C673C74C324A4CB2DAA30A932D")
    public boolean isFastScrollAlwaysVisible() {
        boolean var26B2F46AB3144EF80214E1227EB2F480_1789023290 = (mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65212503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65212503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.870 -0400", hash_original_method = "7B9EF1235ED171F1370B12BB905DC3C9", hash_generated_method = "D19E8DA6989416848E1524C2F298F0BC")
    @Override
    public int getVerticalScrollbarWidth() {
        {
            boolean var26909BC69BA2F3E69FEBFE306B4E5DAD_1096632066 = (isFastScrollAlwaysVisible());
            {
                int varFB51A5362339E3615BCF0229E08CB917_1760956479 = (Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth()));
            } 
        } 
        int var08FF7A4CA397B890F67D51D77687712B_1564739270 = (super.getVerticalScrollbarWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793623520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793623520;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.870 -0400", hash_original_method = "0BC112ABD3166320C6B43E3AFC3B6D61", hash_generated_method = "30517E6E39767602AA96A0E14D653C33")
    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884158127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884158127;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.871 -0400", hash_original_method = "A675D7279FF2D5DA4484C8480BA7553A", hash_generated_method = "A1793C19ED7CECF3927AEF4BCE90B044")
    @Override
    public void setVerticalScrollbarPosition(int position) {
        super.setVerticalScrollbarPosition(position);
        {
            mFastScroller.setScrollbarPosition(position);
        } 
        addTaint(position);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.871 -0400", hash_original_method = "940CDB7D64F97F8EC4A4E1C87858DFBA", hash_generated_method = "2DE74E46A67C52479E42D5197216FF54")
    @Override
    protected boolean isVerticalScrollBarHidden() {
        boolean varEE7670B7B7BC0CBAC7B3A19E6E35E88F_402445282 = (mFastScroller != null && mFastScroller.isVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800178983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800178983;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.871 -0400", hash_original_method = "1698DB675ADDAA62665F2F04BB6F72CB", hash_generated_method = "D64E9DF10E031F8E4DDF09544BB4BA0A")
    public void setSmoothScrollbarEnabled(boolean enabled) {
        mSmoothScrollbarEnabled = enabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.872 -0400", hash_original_method = "475C5FFCF382FD26204BCB75E2B77D7D", hash_generated_method = "0F701411362B8ADE67F43262DBD09CBE")
    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427052474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427052474;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.872 -0400", hash_original_method = "210B7E1D385EBACE9AEF47F53212EE62", hash_generated_method = "7891AA0536D9A3BB23A5AA51B1644A4C")
    public void setOnScrollListener(OnScrollListener l) {
        mOnScrollListener = l;
        invokeOnItemScrollListener();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.873 -0400", hash_original_method = "BA8530F9EF3261CEDA66BF584A9CCD3E", hash_generated_method = "A9B81DB570E7184E3C81965E4D493FD7")
     void invokeOnItemScrollListener() {
        {
            mFastScroller.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } 
        {
            mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        } 
        onScrollChanged(0, 0, 0, 0);
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.873 -0400", hash_original_method = "B64F2C3012E6A3D7EFE9332FD2B83485", hash_generated_method = "8433342B4FB88869683E03F639A8C5E9")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        {
            final int firstVisiblePosition = getFirstVisiblePosition();
            final int lastVisiblePosition = getLastVisiblePosition();
            {
                mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            } 
        } 
        super.sendAccessibilityEvent(eventType);
        addTaint(eventType);
        
        
            
            
            
                    
                
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.873 -0400", hash_original_method = "9414D347741A5DD8E57796525BCE5898", hash_generated_method = "3A26F14536B132D99C11AD7ECC0C623F")
    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382149774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382149774;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.874 -0400", hash_original_method = "150D6943577E82022A370D7488992E67", hash_generated_method = "22BFA28B65E057BC19AD1664B0D74CD8")
    public void setScrollingCacheEnabled(boolean enabled) {
        {
            clearScrollingCache();
        } 
        mScrollingCacheEnabled = enabled;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.874 -0400", hash_original_method = "8476047A74E8C2792EEAD35F27B63501", hash_generated_method = "264A2BADB5D79F4C262375A12D707EBE")
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        mTextFilterEnabled = textFilterEnabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.876 -0400", hash_original_method = "D536B611E01E5CFE1F666765CAB03290", hash_generated_method = "504962D4DBBAB2E86E5840A24D08E869")
    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651951603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651951603;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.876 -0400", hash_original_method = "1C8D0A5FE9343035731EC5D6D9384599", hash_generated_method = "5EFE36AE166F6D6BB06D679D5E67888E")
    @Override
    public void getFocusedRect(Rect r) {
        View view = getSelectedView();
        {
            boolean varA78CB7AA6BC92F805E05829844E1ECE3_1552966071 = (view != null && view.getParent() == this);
            {
                view.getFocusedRect(r);
                offsetDescendantRectToMyCoords(view, r);
            } 
            {
                super.getFocusedRect(r);
            } 
        } 
        addTaint(r.getTaint());
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.877 -0400", hash_original_method = "9E8C7705C9D325A7FB79BC94A2C5E742", hash_generated_method = "5E8864341AF6CB275CB3012A78EAE0CA")
    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.877 -0400", hash_original_method = "991365D9D991378A506E868734A0B0D2", hash_generated_method = "D6CE2681604589238D239A2A80B18647")
    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1543525980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1543525980;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.877 -0400", hash_original_method = "CFFEAD7E7BECCE023678F7841887953F", hash_generated_method = "588D3A603EDEFCB89D22D75113F6AE73")
    public void setStackFromBottom(boolean stackFromBottom) {
        {
            mStackFromBottom = stackFromBottom;
            requestLayoutIfNecessary();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.878 -0400", hash_original_method = "DBB2E77784FB40B043F5BACE416B5D38", hash_generated_method = "C1EA88E03647D707AD3D69A488AE18FE")
     void requestLayoutIfNecessary() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_210487753 = (getChildCount() > 0);
            {
                resetList();
                requestLayout();
                invalidate();
            } 
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.879 -0400", hash_original_method = "550511192552500388A3039280244936", hash_generated_method = "892ECD987E18CC1E66370CAB6CDD17B9")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1162104761 = null; 
        dismissPopup();
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        boolean haveChildren = getChildCount() > 0 && mItemCount > 0;
        long selectedId = getSelectedItemId();
        ss.selectedId = selectedId;
        ss.height = getHeight();
        {
            ss.viewTop = mSelectedTop;
            ss.position = getSelectedItemPosition();
            ss.firstId = INVALID_POSITION;
        } 
        {
            {
                View v = getChildAt(0);
                ss.viewTop = v.getTop();
                int firstPos = mFirstPosition;
                {
                    firstPos = mItemCount - 1;
                } 
                ss.position = firstPos;
                ss.firstId = mAdapter.getItemId(firstPos);
            } 
            {
                ss.viewTop = 0;
                ss.firstId = INVALID_POSITION;
                ss.position = 0;
            } 
        } 
        ss.filter = null;
        {
            final EditText textFilter = mTextFilter;
            {
                Editable filterText = textFilter.getText();
                {
                    ss.filter = filterText.toString();
                } 
            } 
        } 
        ss.inActionMode = mChoiceMode == CHOICE_MODE_MULTIPLE_MODAL && mChoiceActionMode != null;
        {
            ss.checkState = mCheckStates.clone();
        } 
        {
            final LongSparseArray<Integer> idState = new LongSparseArray<Integer>();
            final int count = mCheckedIdStates.size();
            {
                int i = 0;
                {
                    idState.put(mCheckedIdStates.keyAt(i), mCheckedIdStates.valueAt(i));
                } 
            } 
            ss.checkIdState = idState;
        } 
        ss.checkedItemCount = mCheckedItemCount;
        varB4EAC82CA7396A68D541C85D26508E83_1162104761 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_1162104761.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1162104761;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.880 -0400", hash_original_method = "43BE5C5AD27C719005EFC4A46B8486A7", hash_generated_method = "205CA2B520068DD4D73AEDCFCD3024C2")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        mDataChanged = true;
        mSyncHeight = ss.height;
        {
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSpecificTop = ss.viewTop;
            mSyncMode = SYNC_SELECTED_POSITION;
        } 
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
        {
            mCheckStates = ss.checkState;
        } 
        {
            mCheckedIdStates = ss.checkIdState;
        } 
        mCheckedItemCount = ss.checkedItemCount;
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } 
        requestLayout();
        addTaint(state.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.881 -0400", hash_original_method = "42E27AF1CE674CD4135EEA22852A217B", hash_generated_method = "575F7ABB2483BCD65115E8D215412153")
    private boolean acceptFilter() {
        boolean varA2D4C9A63B028E8345B4157A680073A2_1240182490 = (mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916627140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916627140;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.881 -0400", hash_original_method = "A8CCB94844A67C45EFD075D798DD3AF0", hash_generated_method = "83A09D49D0398E1238949F221B0B32D4")
    public void setFilterText(String filterText) {
        {
            boolean var190C1EE91DE344514DA2209FAF0C3D82_1617383260 = (mTextFilterEnabled && !TextUtils.isEmpty(filterText));
            {
                createTextFilter(false);
                mTextFilter.setText(filterText);
                mTextFilter.setSelection(filterText.length());
                {
                    {
                        Filter f = ((Filterable) mAdapter).getFilter();
                        f.filter(filterText);
                    } 
                    mFiltered = true;
                    mDataSetObserver.clearSavedState();
                } 
            } 
        } 
        addTaint(filterText.getTaint());
        
        
            
            
            
            
                
                    
                    
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.882 -0400", hash_original_method = "1C9B36BFA6AA511A6999C19189070FD4", hash_generated_method = "19190E60315086985453B57E9ACFF6D9")
    public CharSequence getTextFilter() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1407345069 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1494766817 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1407345069 = mTextFilter.getText();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1494766817 = null;
        CharSequence varA7E53CE21691AB073D9660D615818899_1607797177; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1607797177 = varB4EAC82CA7396A68D541C85D26508E83_1407345069;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1607797177 = varB4EAC82CA7396A68D541C85D26508E83_1494766817;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1607797177.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1607797177;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.882 -0400", hash_original_method = "0C025ACF6797C1095DC28C93A47B3E04", hash_generated_method = "B6B2BF38E1840BEB3761B8EF3A85F342")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        {
            boolean var8EB9364CA747E30AAC5C9F3175F02645_201734905 = (gainFocus && mSelectedPosition < 0 && !isInTouchMode());
            {
                {
                    mDataChanged = true;
                    mOldItemCount = mItemCount;
                    mItemCount = mAdapter.getCount();
                } 
                resurrectSelection();
            } 
        } 
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
        
            
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.883 -0400", hash_original_method = "B180005EA1177A66433DC47F81A1B223", hash_generated_method = "7FA434FB1BD0F76EE21405415ADD4E7C")
    @Override
    public void requestLayout() {
        {
            super.requestLayout();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.883 -0400", hash_original_method = "8DD5C430A497277A13BB6B282542179B", hash_generated_method = "7581B754A737045C6DFD1C880926F30E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.884 -0400", hash_original_method = "EAD3946FC18204D61E6D52ABAEC42671", hash_generated_method = "65A13FA0358F0DF05D019C822AF6FA2E")
    @Override
    protected int computeVerticalScrollExtent() {
        final int count = getChildCount();
        {
            {
                int extent = count * 100;
                View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
                {
                    extent += (top * 100) / height;
                } 
                view = getChildAt(count - 1);
                final int bottom = view.getBottom();
                height = view.getHeight();
                {
                    extent -= ((bottom - getHeight()) * 100) / height;
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236632344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236632344;
        
        
        
            
                
                
                
                
                
                    
                
                
                
                
                
                    
                
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.884 -0400", hash_original_method = "B342EEB15F9AC09DD167764D56209B72", hash_generated_method = "BE3DF2D6EAF3B1AA22A29C7438614DAB")
    @Override
    protected int computeVerticalScrollOffset() {
        final int firstPosition = mFirstPosition;
        final int childCount = getChildCount();
        {
            {
                final View view = getChildAt(0);
                final int top = view.getTop();
                int height = view.getHeight();
                {
                    int var813D884A4C0D547484060C54181A041A_663869377 = (Math.max(firstPosition * 100 - (top * 100) / height +
                            (int)((float)mScrollY / getHeight() * mItemCount * 100), 0));
                } 
            } 
            {
                int index;
                final int count = mItemCount;
                {
                    index = 0;
                } 
                {
                    index = count;
                } 
                {
                    index = firstPosition + childCount / 2;
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413496982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413496982;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.885 -0400", hash_original_method = "4324030F56A09BCB8354791FE2A22081", hash_generated_method = "3338AD1A1241F7FD9FC5075253378BAB")
    @Override
    protected int computeVerticalScrollRange() {
        int result;
        {
            result = Math.max(mItemCount * 100, 0);
            {
                result += Math.abs((int) ((float) mScrollY / getHeight() * mItemCount * 100));
            } 
        } 
        {
            result = mItemCount;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531153393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531153393;
        
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.885 -0400", hash_original_method = "6B45AE0F220A2E6F043181E50094F343", hash_generated_method = "336370792B00445C7F5F3AD543ADEF4D")
    @Override
    protected float getTopFadingEdgeStrength() {
        final int count = getChildCount();
        final float fadeEdge = super.getTopFadingEdgeStrength();
        {
            final int top = getChildAt(0).getTop();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1332845182 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1332845182;
        
        
        
        
            
        
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.886 -0400", hash_original_method = "7783F8E763936950C57ED5516E6F7E94", hash_generated_method = "7CCB85B11D0F05B7A177D9F449FDB978")
    @Override
    protected float getBottomFadingEdgeStrength() {
        final int count = getChildCount();
        final float fadeEdge = super.getBottomFadingEdgeStrength();
        {
            final int bottom = getChildAt(count - 1).getBottom();
            final int height = getHeight();
            final float fadeLength = (float) getVerticalFadingEdgeLength();
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1545897073 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1545897073;
        
        
        
        
            
        
            
                
            
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.887 -0400", hash_original_method = "7C6C2B65B4381736E49DE73CCD130327", hash_generated_method = "80F0C58D6BF6F7E1E5FC7A6FC2F6E102")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        {
            useDefaultSelector();
        } 
        final Rect listPadding = mListPadding;
        listPadding.left = mSelectionLeftPadding + mPaddingLeft;
        listPadding.top = mSelectionTopPadding + mPaddingTop;
        listPadding.right = mSelectionRightPadding + mPaddingRight;
        listPadding.bottom = mSelectionBottomPadding + mPaddingBottom;
        {
            final int childCount = getChildCount();
            final int listBottom = getHeight() - getPaddingBottom();
            final View lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            lastBottom = listBottom;
            mForceTranscriptScroll = mFirstPosition + childCount >= mLastHandledItemCount &&
                    lastBottom <= listBottom;
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.888 -0400", hash_original_method = "46F44099FEFDB133D6B976408934CAC6", hash_generated_method = "6EF3425F765955127479689D10F4C294")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
        super.onLayout(changed, l, t, r, b);
        mInLayout = true;
        {
            int childCount = getChildCount();
            {
                int i = 0;
                {
                    getChildAt(i).forceLayout();
                } 
            } 
            mRecycler.markChildrenDirty();
        } 
        {
            mFastScroller.onItemCountChanged(mOldItemCount, mItemCount);
        } 
        layoutChildren();
        mInLayout = false;
        mOverscrollMax = (b - t) / OVERSCROLL_LIMIT_DIVISOR;
        addTaint(changed);
        addTaint(l);
        addTaint(r);
        
        
        
        
            
            
                
            
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.889 -0400", hash_original_method = "748FD791AA503E7E1D859CFD661EA755", hash_generated_method = "FCB27BA304B7FE14E3E5C46ABB1F622D")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        final boolean changed = super.setFrame(left, top, right, bottom);
        {
            final boolean visible = getWindowVisibility() == View.VISIBLE;
            {
                boolean varFBED1B944623C6BCA164EC2723F71804_1381861795 = (mFiltered && visible && mPopup != null && mPopup.isShowing());
                {
                    positionPopup();
                } 
            } 
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944244806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944244806;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.889 -0400", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "7C7456ED8D2FB5B664E2AB60CCD22125")
    protected void layoutChildren() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.889 -0400", hash_original_method = "180044681435C2C9D1AB0FD8756137A4", hash_generated_method = "BA271A945708EF17C8E6A604698849E4")
     void updateScrollIndicators() {
        {
            boolean canScrollUp;
            canScrollUp = mFirstPosition > 0;
            {
                {
                    boolean var4813CB3BCCB7AE7282F404FB5F98BC43_265619956 = (getChildCount() > 0);
                    {
                        View child = getChildAt(0);
                        canScrollUp = child.getTop() < mListPadding.top;
                    } 
                } 
            } 
            mScrollUp.setVisibility(canScrollUp ? View.VISIBLE : View.INVISIBLE);
        } 
        {
            boolean canScrollDown;
            int count = getChildCount();
            canScrollDown = (mFirstPosition + count) < mItemCount;
            {
                View child = getChildAt(count - 1);
                canScrollDown = child.getBottom() > mBottom - mListPadding.bottom;
            } 
            mScrollDown.setVisibility(canScrollDown ? View.VISIBLE : View.INVISIBLE);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.890 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "F2C0341DCB75E7AE58E9A4AD6B338F27")
    @Override
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1270001448 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_69527101 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1270001448 = getChildAt(mSelectedPosition - mFirstPosition);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_69527101 = null;
        } 
        View varA7E53CE21691AB073D9660D615818899_107445013; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_107445013 = varB4EAC82CA7396A68D541C85D26508E83_1270001448;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_107445013 = varB4EAC82CA7396A68D541C85D26508E83_69527101;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_107445013.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_107445013;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.891 -0400", hash_original_method = "3B697574C47153B82BC97C5C46624F2C", hash_generated_method = "625F664B45BF2EE19F13F2B62FC3B902")
    public int getListPaddingTop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964102039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964102039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.891 -0400", hash_original_method = "CEE980D8545C78DFB596AE8650DBF797", hash_generated_method = "09141E14779C68FC6E73F5EFC296BAF7")
    public int getListPaddingBottom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046398980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046398980;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.891 -0400", hash_original_method = "C8B939C15FBE7011BDF7672B6F924B56", hash_generated_method = "600C47AA6F15030A08A5335A02366C79")
    public int getListPaddingLeft() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419565941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419565941;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.891 -0400", hash_original_method = "1F1F9379D690EBB0F58C075805935B4C", hash_generated_method = "2AB4D39E8754890235F61A41518E6377")
    public int getListPaddingRight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496482954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496482954;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.892 -0400", hash_original_method = "F1A94AACBC76DA4834C170841A9D4C37", hash_generated_method = "CDDB36948904E1CAEE204CE15111D8E4")
     View obtainView(int position, boolean[] isScrap) {
        View varB4EAC82CA7396A68D541C85D26508E83_269264765 = null; 
        isScrap[0] = false;
        View scrapView;
        scrapView = mRecycler.getScrapView(position);
        View child;
        {
            {
                ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.RECYCLE_FROM_SCRAP_HEAP,
                        position, -1);
            } 
            child = mAdapter.getView(position, scrapView, this);
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.BIND_VIEW,
                        position, getChildCount());
            } 
            {
                mRecycler.addScrapView(scrapView, position);
                {
                    child.setDrawingCacheBackgroundColor(mCacheColorHint);
                } 
                {
                    ViewDebug.trace(scrapView, ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                            position, -1);
                } 
            } 
            {
                isScrap[0] = true;
                child.dispatchFinishTemporaryDetach();
            } 
        } 
        {
            child = mAdapter.getView(position, null, this);
            {
                child.setDrawingCacheBackgroundColor(mCacheColorHint);
            } 
            {
                ViewDebug.trace(child, ViewDebug.RecyclerTraceType.NEW_VIEW,
                        position, getChildCount());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_269264765 = child;
        addTaint(position);
        addTaint(isScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_269264765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_269264765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.893 -0400", hash_original_method = "B068259C5BBCB2A7501108708CD5A4C4", hash_generated_method = "E21DCFF3EDD36B7765770DE56F0F712F")
     void positionSelector(int position, View sel) {
        {
            mSelectorPosition = position;
        } 
        final Rect selectorRect = mSelectorRect;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        {
            ((SelectionBoundsAdjuster)sel).adjustListItemSelectionBounds(selectorRect);
        } 
        positionSelector(selectorRect.left, selectorRect.top, selectorRect.right,
                selectorRect.bottom);
        final boolean isChildViewEnabled = mIsChildViewEnabled;
        {
            boolean varFB59463D8D8AB76E1E484CE2BBC5519D_1800667328 = (sel.isEnabled() != isChildViewEnabled);
            {
                mIsChildViewEnabled = !isChildViewEnabled;
                {
                    boolean var9ACEB0A565E658741B99EDC3F95405AB_1493928574 = (getSelectedItemPosition() != INVALID_POSITION);
                    {
                        refreshDrawableState();
                    } 
                } 
            } 
        } 
        addTaint(sel.getTaint());
        
        
            
        
        
        
        
            
        
        
                
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.893 -0400", hash_original_method = "9958A79674A9EAF808CC1CD0A2974C67", hash_generated_method = "3CBE6806D0404AB507608A934337F43C")
    private void positionSelector(int l, int t, int r, int b) {
        mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                + mSelectionRightPadding, b + mSelectionBottomPadding);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.894 -0400", hash_original_method = "EB6A446E7A5D607DB4BF2796F54D03FA", hash_generated_method = "C2FA6B877702338B44AC964729131CA0")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = 0;
        final boolean clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
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
        {
            drawSelector(canvas);
        } 
        super.dispatchDraw(canvas);
        {
            drawSelector(canvas);
        } 
        {
            canvas.restoreToCount(saveCount);
            mGroupFlags |= CLIP_TO_PADDING_MASK;
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.895 -0400", hash_original_method = "E1295B3F3CD2AED842AA5266ED41ED1A", hash_generated_method = "156CC2712538545003D659ED3D79CF9A")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129029101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129029101;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.895 -0400", hash_original_method = "C31A372B11969057E398197BABCC2FB9", hash_generated_method = "9562C6F5E5F8D26FB7190D33AF4852A9")
    @Override
    protected int getLeftPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723333696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723333696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.896 -0400", hash_original_method = "F0F07013F187EA8DBDDCF030EEADD0A0", hash_generated_method = "5A8850D597655677505D2DDF807E7AF2")
    @Override
    protected int getTopPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971629086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971629086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.897 -0400", hash_original_method = "D64BFD9DD2CC0187FA2BCDAC4D5056C0", hash_generated_method = "1784D8D8A889E1F1909CD00F2C3E9CE9")
    @Override
    protected int getRightPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828553147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828553147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.897 -0400", hash_original_method = "A76EA354621A97D061AF35F7F0E022AA", hash_generated_method = "47B0E5EA7A278853AC63AE71039F02D1")
    @Override
    protected int getBottomPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399202376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399202376;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.898 -0400", hash_original_method = "7222D25647FA66D7134D6564AB03A11A", hash_generated_method = "1A6CB64FF9A3B262C9959B6CFC3C726A")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1734370584 = (getChildCount() > 0);
            {
                mDataChanged = true;
                rememberSyncState();
            } 
        } 
        {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        } 
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.898 -0400", hash_original_method = "E2B9A99414FF2EE03BB0A755AC5DBB16", hash_generated_method = "9A732E7792C6518F029140CA4FBB1006")
     boolean touchModeDrawsInPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_499568531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_499568531;
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.899 -0400", hash_original_method = "FA7D742C09854F2E7F00273E8807D507", hash_generated_method = "8D466069A38322B60C66F30129D34220")
     boolean shouldShowSelector() {
        boolean var4246A524C7FBFC973820D2F78D9E8F98_769050730 = ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636948667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636948667;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.899 -0400", hash_original_method = "1653A38E1AF50A830D0C8CACED5D71E9", hash_generated_method = "0601BD375AE671ADE512E70CDE0C2AC9")
    private void drawSelector(Canvas canvas) {
        {
            boolean var101389AC9853324A8F2F4AC467A8FE5D_1417020857 = (!mSelectorRect.isEmpty());
            {
                final Drawable selector = mSelector;
                selector.setBounds(mSelectorRect);
                selector.draw(canvas);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.899 -0400", hash_original_method = "E224CB1DBFEAEB35D4CBDCEA1ACB7063", hash_generated_method = "C23273762128D8B0257C96DB47B6A628")
    public void setDrawSelectorOnTop(boolean onTop) {
        mDrawSelectorOnTop = onTop;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.900 -0400", hash_original_method = "4BF5D497DEE1C8362CD452A22AD6FA64", hash_generated_method = "80C2C33A0EB46039BD9348F47A7188EF")
    public void setSelector(int resID) {
        setSelector(getResources().getDrawable(resID));
        addTaint(resID);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.900 -0400", hash_original_method = "AF217D83F5B526992017BCFB165071E1", hash_generated_method = "03FD2AB577E35C84474A67016D915062")
    public void setSelector(Drawable sel) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.901 -0400", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "D8F2052080E4C0C5FCB8633731C39CC9")
    public Drawable getSelector() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1369922638 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1369922638 = mSelector;
        varB4EAC82CA7396A68D541C85D26508E83_1369922638.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1369922638;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.902 -0400", hash_original_method = "2F7C78E24D2DA521609D152C286646B5", hash_generated_method = "40B3FEB199EBD69481E6BDBA95615A0D")
     void keyPressed() {
        {
            boolean varDBE5D4BF2CCFB471B80269545EAA1B3B_2006817954 = (!isEnabled() || !isClickable());
        } 
        Drawable selector = mSelector;
        Rect selectorRect = mSelectorRect;
        {
            boolean var07FA5EC4F6C5A1F1386E6BB4E68E466A_1968874525 = (selector != null && (isFocused() || touchModeDrawsInPressedState())
                && !selectorRect.isEmpty());
            {
                final View v = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    {
                        boolean varF2E1D044768D3B14172E86DA91C28BD1_370096497 = (v.hasFocusable());
                    } 
                    v.setPressed(true);
                } 
                setPressed(true);
                final boolean longClickable = isLongClickable();
                Drawable d = selector.getCurrent();
                {
                    {
                        ((TransitionDrawable) d).startTransition(
                            ViewConfiguration.getLongPressTimeout());
                    } 
                    {
                        ((TransitionDrawable) d).resetTransition();
                    } 
                } 
                {
                    {
                        mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                    } 
                    mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                    postDelayed(mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.902 -0400", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "21A7C287E27C4D3CE4CA7765A0F74054")
    public void setScrollIndicators(View up, View down) {
        mScrollUp = up;
        mScrollDown = down;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.902 -0400", hash_original_method = "80EC646A43ECE5B1A4600CE8EDDA24B3", hash_generated_method = "1E0006BC10249FCD32EC9437A79EAD4C")
     void updateSelectorState() {
        {
            {
                boolean var1EC35265200A237347BA89EC9F7CAA85_1864028326 = (shouldShowSelector());
                {
                    mSelector.setState(getDrawableState());
                } 
                {
                    mSelector.setState(StateSet.NOTHING);
                } 
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.903 -0400", hash_original_method = "5700D7A450170541F2788B92612441B3", hash_generated_method = "A585E16DC9FBE9BA5368D986ED938050")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.903 -0400", hash_original_method = "1ED981B25374988410BBF6BB9A2499BB", hash_generated_method = "2BCAF3CBAAD2EF0C17FF41F1A9742560")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_40473930 = (super.onCreateDrawableState(extraSpace));
        } 
        final int enabledState = ENABLED_STATE_SET[0];
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        int enabledPos = -1;
        {
            int i = state.length - 1;
            {
                {
                    enabledPos = i;
                } 
            } 
        } 
        {
            System.arraycopy(state, enabledPos + 1, state, enabledPos,
                    state.length - enabledPos - 1);
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1858348220 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1858348220;
        
        
            
        
        
        
        
        
            
                
                
            
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.904 -0400", hash_original_method = "A6B05685C2044FBFF5332C34549C9055", hash_generated_method = "53CF37422C76D00560A8E31E57A6AA1B")
    @Override
    public boolean verifyDrawable(Drawable dr) {
        boolean var31983995A7CC0B4FFFDA846AE3697AC5_975721567 = (mSelector == dr || super.verifyDrawable(dr));
        addTaint(dr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435677599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435677599;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.904 -0400", hash_original_method = "7ED40C7CE5B566B3E07F33E9D37CCA58", hash_generated_method = "EEC30B3A9E5A1EA4E67E19E804024279")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mSelector.jumpToCurrentState();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.904 -0400", hash_original_method = "0EB97D149DFA0037A8214EEEE413FBAC", hash_generated_method = "77FCB5C2D10DBE09BAB8AC5DB9E6DEA7")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
        {
            treeObserver.addOnGlobalLayoutListener(this);
        } 
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        } 
        mIsAttached = true;
        
        
        
        
        
            
        
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.905 -0400", hash_original_method = "91FA19273AD6EF1E2E7A8FCA605608DC", hash_generated_method = "F8A51E1E2EEF62A1F919E3E4A349428A")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        dismissPopup();
        mRecycler.clear();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.removeOnTouchModeChangeListener(this);
        {
            treeObserver.removeGlobalOnLayoutListener(this);
            mGlobalLayoutListenerAddedFilter = false;
        } 
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        } 
        {
            mScrollStrictSpan.finish();
            mScrollStrictSpan = null;
        } 
        {
            mFlingStrictSpan.finish();
            mFlingStrictSpan = null;
        } 
        {
            removeCallbacks(mFlingRunnable);
        } 
        {
            mPositionScroller.stop();
        } 
        {
            removeCallbacks(mClearScrollingCache);
        } 
        {
            removeCallbacks(mPerformClick);
        } 
        {
            removeCallbacks(mTouchModeReset);
            mTouchModeReset = null;
        } 
        mIsAttached = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.906 -0400", hash_original_method = "F46E1D5E69E9A7961CEAA1CC31FCC74A", hash_generated_method = "7EFD72E2AAE804FAF702EF30B1AF27E1")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        super.onWindowFocusChanged(hasWindowFocus);
        int touchMode;
        boolean var49D8D6F90114322BA24D8547EE3F7B5B_1640164964 = (isInTouchMode());
        touchMode = TOUCH_MODE_ON;
        touchMode = TOUCH_MODE_OFF;
        {
            setChildrenDrawingCacheEnabled(false);
            {
                removeCallbacks(mFlingRunnable);
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } 
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } 
            } 
            dismissPopup();
            {
                mResurrectToPosition = mSelectedPosition;
            } 
        } 
        {
            {
                showPopup();
            } 
            {
                {
                    resurrectSelection();
                } 
                {
                    hideSelector();
                    mLayoutMode = LAYOUT_NORMAL;
                    layoutChildren();
                } 
            } 
        } 
        mLastTouchMode = touchMode;
        addTaint(hasWindowFocus);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.908 -0400", hash_original_method = "5DA1B21EB8CB635B0040E7A9E537D496", hash_generated_method = "FA38A0A302524E4D4BE27136E2AFAF1E")
     ContextMenuInfo createContextMenuInfo(View view, int position, long id) {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_2000543485 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2000543485 = new AdapterContextMenuInfo(view, position, id);
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_2000543485.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2000543485;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.908 -0400", hash_original_method = "5D95BDE73AAD1EC9BDE83FD3189DFC34", hash_generated_method = "98C2628DB3A0BE9F15B4D2AE6A844603")
     boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId) {
        {
            {
                boolean var00E98D05004FD0330F18AA64B0748865_200351140 = (mChoiceActionMode == null &&
                    (mChoiceActionMode = startActionMode(mMultiChoiceModeCallback)) != null);
                {
                    setItemChecked(longPressPosition, true);
                    performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                } 
            } 
        } 
        boolean handled = false;
        {
            handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, child,
                    longPressPosition, longPressId);
        } 
        {
            mContextMenuInfo = createContextMenuInfo(child, longPressPosition, longPressId);
            handled = super.showContextMenuForChild(AbsListView.this);
        } 
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102464122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102464122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.909 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "B423DB2F5B1B99570C15A3607CE4F411")
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_551777437 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_551777437 = mContextMenuInfo;
        varB4EAC82CA7396A68D541C85D26508E83_551777437.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_551777437;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.910 -0400", hash_original_method = "720F76E8125C4C6521A83756BA0DD98B", hash_generated_method = "805C8F6183E4A9B68C94D4743A0575B6")
    @Override
    public boolean showContextMenu(float x, float y, int metaState) {
        final int position = pointToPosition((int)x, (int)y);
        {
            final long id = mAdapter.getItemId(position);
            View child = getChildAt(position - mFirstPosition);
            {
                mContextMenuInfo = createContextMenuInfo(child, position, id);
                boolean var8897B192E808AB3EDB293923745D2D74_90272919 = (super.showContextMenuForChild(AbsListView.this));
            } 
        } 
        boolean varE458CA81039B0A7729D96AA8ED00D0B8_1976033321 = (super.showContextMenu(x, y, metaState));
        addTaint(x);
        addTaint(y);
        addTaint(metaState);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730131920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_730131920;
        
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.910 -0400", hash_original_method = "13B8C0CF7E224AA8E52D13CB23050F48", hash_generated_method = "BE65CC56A39AA0AC1D9865771AEF9DC7")
    @Override
    public boolean showContextMenuForChild(View originalView) {
        final int longPressPosition = getPositionForView(originalView);
        {
            final long longPressId = mAdapter.getItemId(longPressPosition);
            boolean handled = false;
            {
                handled = mOnItemLongClickListener.onItemLongClick(AbsListView.this, originalView,
                        longPressPosition, longPressId);
            } 
            {
                mContextMenuInfo = createContextMenuInfo(
                        getChildAt(longPressPosition - mFirstPosition),
                        longPressPosition, longPressId);
                handled = super.showContextMenuForChild(originalView);
            } 
        } 
        addTaint(originalView.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413243576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413243576;
        
        
        
            
            
            
                
                        
            
            
                
                        
                        
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.911 -0400", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "1E552177A1EF875F2281F499DBF9DE4D")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1135375060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1135375060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.911 -0400", hash_original_method = "DD8448F1B5F23CC0AD3E4D53FFC7D294", hash_generated_method = "83784B9261494DF1A562FD2CDE9EE236")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_806548587 = (!isEnabled());
        } 
        
        
        {
            boolean varD23167BEA6670E541F842804D07343DD_253517698 = (isClickable() && isPressed() &&
                    mSelectedPosition >= 0 && mAdapter != null &&
                    mSelectedPosition < mAdapter.getCount());
            {
                final View view = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    performItemClick(view, mSelectedPosition, mSelectedRowId);
                    view.setPressed(false);
                } 
                setPressed(false);
            } 
        } 
        
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1716758569 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025376850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025376850;
        
        
        
        
            
                
            
            
                    
                    
                
                
                    
                    
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.912 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "083281D026E9BBF12BAB21E0084CD5D6")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.912 -0400", hash_original_method = "C5D265B49C06947929C542FAD6DD4910", hash_generated_method = "2D1DFD2DE02D229F33A8E3DE23AFDA40")
    public int pointToPosition(int x, int y) {
        Rect frame = mTouchFrame;
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } 
        final int count = getChildCount();
        {
            int i = count - 1;
            {
                final View child = getChildAt(i);
                {
                    boolean var02E23769C3E76AF1DC2C1CE956107022_29396308 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_1636256921 = (frame.contains(x, y));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340156224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340156224;
        
        
        
            
            
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.912 -0400", hash_original_method = "0CE0E010C97C81E4AEC085897948D819", hash_generated_method = "DCCC056E94316A96B1D9B051C1943057")
    public long pointToRowId(int x, int y) {
        int position = pointToPosition(x, y);
        {
            long varD18EE374A3F0927116BA59F2A9A03256_1491588171 = (mAdapter.getItemId(position));
        } 
        addTaint(x);
        addTaint(y);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_549057065 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_549057065;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.913 -0400", hash_original_method = "5EE86ADCFB65EEBAD1CBAFF86BFF869E", hash_generated_method = "762DBE34E025D8E45484C7A75EA17E31")
    private boolean startScrollIfNeeded(int y) {
        final int deltaY = y - mMotionY;
        final int distance = Math.abs(deltaY);
        final boolean overscroll = mScrollY != 0;
        {
            createScrollingCache();
            {
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionCorrection = 0;
            } 
            {
                mTouchMode = TOUCH_MODE_SCROLL;
                mMotionCorrection = deltaY > 0 ? mTouchSlop : -mTouchSlop;
            } 
            final Handler handler = getHandler();
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            setPressed(false);
            View motionView = getChildAt(mMotionPosition - mFirstPosition);
            {
                motionView.setPressed(false);
            } 
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
            final ViewParent parent = getParent();
            {
                parent.requestDisallowInterceptTouchEvent(true);
            } 
            scrollIfNeeded(y);
        } 
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725814608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725814608;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.915 -0400", hash_original_method = "24BFB982D66DDF27FDD0EB3AFC04A401", hash_generated_method = "827B81A7454FE9C4804F64CC32D645DB")
    private void scrollIfNeeded(int y) {
        final int rawDeltaY = y - mMotionY;
        final int deltaY = rawDeltaY - mMotionCorrection;
        int incrementalDeltaY;
        incrementalDeltaY = y - mLastY;
        incrementalDeltaY = deltaY;
        {
            {
                {
                    Debug.startMethodTracing("AbsListViewScroll");
                    mScrollProfilingStarted = true;
                } 
            } 
            {
                mScrollStrictSpan = StrictMode.enterCriticalSpan("AbsListView-scroll");
            } 
            {
                {
                    boolean var3B6B3092E9AEF7EFB8F7DB7C1090C559_1197746430 = ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) == 0 &&
                        Math.abs(rawDeltaY) > mTouchSlop);
                    {
                        final ViewParent parent = getParent();
                        {
                            parent.requestDisallowInterceptTouchEvent(true);
                        } 
                    } 
                } 
                int motionIndex;
                {
                    motionIndex = mMotionPosition - mFirstPosition;
                } 
                {
                    motionIndex = getChildCount() / 2;
                } 
                int motionViewPrevTop = 0;
                View motionView = this.getChildAt(motionIndex);
                {
                    motionViewPrevTop = motionView.getTop();
                } 
                boolean atEdge = false;
                {
                    atEdge = trackMotionScroll(deltaY, incrementalDeltaY);
                } 
                motionView = this.getChildAt(motionIndex);
                {
                    final int motionViewRealTop = motionView.getTop();
                    {
                        int overscroll = -incrementalDeltaY -
                                (motionViewRealTop - motionViewPrevTop);
                        overScrollBy(0, overscroll, 0, mScrollY, 0, 0,
                                0, mOverscrollDistance, true);
                        {
                            boolean var879507118E22A9A52AEA797A263AF84E_1549155082 = (Math.abs(mOverscrollDistance) == Math.abs(mScrollY));
                            {
                                {
                                    mVelocityTracker.clear();
                                } 
                            } 
                        } 
                        final int overscrollMode = getOverScrollMode();
                        {
                            boolean varAE1D066723B1EA15FA5C10A14D662F56_1971666967 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                                (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                        !contentFits()));
                            {
                                mDirection = 0;
                                mTouchMode = TOUCH_MODE_OVERSCROLL;
                                {
                                    mEdgeGlowTop.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varA87047F469C00113B6AE83492D7AB59C_365538177 = (!mEdgeGlowBottom.isFinished());
                                        {
                                            mEdgeGlowBottom.onRelease();
                                        } 
                                    } 
                                } 
                                {
                                    mEdgeGlowBottom.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varF30E150A7784B932CC0A99DAB3E3524A_1874063072 = (!mEdgeGlowTop.isFinished());
                                        {
                                            mEdgeGlowTop.onRelease();
                                        } 
                                    } 
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
        {
            {
                final int oldScroll = mScrollY;
                final int newScroll = oldScroll - incrementalDeltaY;
                int newDirection;
                newDirection = 1;
                newDirection = -1;
                {
                    mDirection = newDirection;
                } 
                int overScrollDistance = -incrementalDeltaY;
                {
                    overScrollDistance = -oldScroll;
                    incrementalDeltaY += overScrollDistance;
                } 
                {
                    incrementalDeltaY = 0;
                } 
                {
                    overScrollBy(0, overScrollDistance, 0, mScrollY, 0, 0,
                            0, mOverscrollDistance, true);
                    final int overscrollMode = getOverScrollMode();
                    {
                        boolean varA17BFA05D97ECE222863450A9B7218E6_1663957006 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                    !contentFits()));
                        {
                            {
                                mEdgeGlowTop.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var352E8E7760F8F011E79FB28EFE62DA73_295445813 = (!mEdgeGlowBottom.isFinished());
                                    {
                                        mEdgeGlowBottom.onRelease();
                                    } 
                                } 
                            } 
                            {
                                mEdgeGlowBottom.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var530787B3C000358ED8C3E02B71DC0120_267255957 = (!mEdgeGlowTop.isFinished());
                                    {
                                        mEdgeGlowTop.onRelease();
                                    } 
                                } 
                            } 
                            invalidate();
                        } 
                    } 
                } 
                {
                    mScrollY = 0;
                    invalidateParentIfNeeded();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.916 -0400", hash_original_method = "6F0203AFDEF2DCB43412C3F5E7A63F8C", hash_generated_method = "2E2FAA07BD3C7C595ABE611F80FE7F8A")
    public void onTouchModeChanged(boolean isInTouchMode) {
        
        {
            hideSelector();
            {
                boolean var18FDA06F2E4C20DCFBA70CFDB1F209F6_241636461 = (getHeight() > 0 && getChildCount() > 0);
                {
                    layoutChildren();
                } 
            } 
            updateSelectorState();
        } 
        {
            int touchMode = mTouchMode;
            {
                {
                    mFlingRunnable.endFling();
                } 
                {
                    mPositionScroller.stop();
                } 
                {
                    mScrollY = 0;
                    invalidateParentCaches();
                    finishGlows();
                    invalidate();
                } 
            } 
        } 
        addTaint(isInTouchMode);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.920 -0400", hash_original_method = "EC498F7AA9A002C93696F04D5F90A9F2", hash_generated_method = "CC4708614D08460AA88F48DE25D01D28")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1726350788 = (!isEnabled());
            {
                boolean var78B3B137E9725C8407DD55321B456099_305455435 = (isClickable() || isLongClickable());
            } 
        } 
        {
            boolean intercepted = mFastScroller.onTouchEvent(ev);
        } 
        final int action = ev.getAction();
        View v;
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        
        {
            
            {
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } 
                mTouchMode = TOUCH_MODE_OVERSCROLL;
                mMotionX = (int) ev.getX();
                mMotionY = mLastY = (int) ev.getY();
                mMotionCorrection = 0;
                mActivePointerId = ev.getPointerId(0);
                mDirection = 0;
            } 
            
            
            {
                mActivePointerId = ev.getPointerId(0);
                final int x = (int) ev.getX();
                final int y = (int) ev.getY();
                int motionPosition = pointToPosition(x, y);
                {
                    {
                        boolean varD00D6114E840F55D6764F4976AFF0726_1367665810 = ((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0)
                            && (getAdapter().isEnabled(motionPosition)));
                        {
                            mTouchMode = TOUCH_MODE_DOWN;
                            {
                                mPendingCheckForTap = new CheckForTap();
                            } 
                            postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        } 
                        {
                            {
                                createScrollingCache();
                                mTouchMode = TOUCH_MODE_SCROLL;
                                mMotionCorrection = 0;
                                motionPosition = findMotionRow(y);
                                mFlingRunnable.flywheelTouch();
                            } 
                        } 
                    } 
                } 
                {
                    v = getChildAt(motionPosition - mFirstPosition);
                    mMotionViewOriginalTop = v.getTop();
                } 
                mMotionX = x;
                mMotionY = y;
                mMotionPosition = motionPosition;
                mLastY = Integer.MIN_VALUE;
            } 
            
            {
                boolean var10762BA5807EC5420815666D17984CE3_1982119158 = (performButtonActionOnTouchDown(ev));
                {
                    {
                        removeCallbacks(mPendingCheckForTap);
                    } 
                } 
            } 
        } 
        
        
        {
            int pointerIndex = ev.findPointerIndex(mActivePointerId);
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } 
            final int y = (int) ev.getY(pointerIndex);
            
            startScrollIfNeeded(y);
            
            
            scrollIfNeeded(y);
            
        } 
        
        
        {
            
            final int motionPosition = mMotionPosition;
            
            
            final View child = getChildAt(motionPosition - mFirstPosition);
            
            
            final float x = ev.getX();
            
            
            final boolean inList = x > mListPadding.left && x < getWidth() - mListPadding.right;
            
            
            {
                boolean var645943845E190A2FFA4FE7562EA898F8_103185673 = (child != null && !child.hasFocusable() && inList);
                {
                    {
                        child.setPressed(false);
                    } 
                    {
                        mPerformClick = new PerformClick();
                    } 
                    final AbsListView.PerformClick performClick = mPerformClick;
                    performClick.mClickMotionPosition = motionPosition;
                    performClick.rememberWindowAttachCount();
                    mResurrectToPosition = motionPosition;
                    {
                        final Handler handler = getHandler();
                        {
                            handler.removeCallbacks(mTouchMode == TOUCH_MODE_DOWN ?
                                    mPendingCheckForTap : mPendingCheckForLongPress);
                        } 
                        mLayoutMode = LAYOUT_NORMAL;
                        {
                            boolean varAD4E45D7D3DB8FFF6E14B37863D65B2D_890576304 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
                            {
                                mTouchMode = TOUCH_MODE_TAP;
                                setSelectedPositionInt(mMotionPosition);
                                layoutChildren();
                                child.setPressed(true);
                                positionSelector(mMotionPosition, child);
                                setPressed(true);
                                {
                                    Drawable d = mSelector.getCurrent();
                                    {
                                        ((TransitionDrawable) d).resetTransition();
                                    } 
                                } 
                                {
                                    removeCallbacks(mTouchModeReset);
                                } 
                                mTouchModeReset = new Runnable() {                                    
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.919 -0400", hash_original_method = "A6EC1D4E4E60E1E8895C51DF141E43B7", hash_generated_method = "9285F265A17C80263E536A0E27728322")
                                    @Override
                                    public void run() {
                                        mTouchMode = TOUCH_MODE_REST;
                                        child.setPressed(false);
                                        setPressed(false);
                                        {
                                            performClick.run();
                                        } 
                                        
                                        
                                        
                                        
                                        
                                        
                                    
                                    }
};
                                postDelayed(mTouchModeReset,
                                    ViewConfiguration.getPressedStateDuration());
                            } 
                            {
                                mTouchMode = TOUCH_MODE_REST;
                                updateSelectorState();
                            } 
                        } 
                    } 
                    {
                        boolean var523699F24A476A31015FCD9CC5BA98D8_939613639 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
                        {
                            performClick.run();
                        } 
                    } 
                } 
            } 
            
            
            mTouchMode = TOUCH_MODE_REST;
            
            
            updateSelectorState();
            
            
            final int childCount = getChildCount();
            
            
            {
                final int firstChildTop = getChildAt(0).getTop();
                final int lastChildBottom = getChildAt(childCount - 1).getBottom();
                final int contentTop = mListPadding.top;
                final int contentBottom = getHeight() - mListPadding.bottom;
                {
                    boolean varE3D06501EDBEFC68EB729C2818A34655_586792659 = (mFirstPosition == 0 && firstChildTop >= contentTop &&
                            mFirstPosition + childCount < mItemCount &&
                            lastChildBottom <= getHeight() - contentBottom);
                    {
                        mTouchMode = TOUCH_MODE_REST;
                        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                    } 
                    {
                        final VelocityTracker velocityTracker = mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                        final int initialVelocity = (int)
                                (velocityTracker.getYVelocity(mActivePointerId) * mVelocityScale);
                        {
                            boolean varD48B4459D536B53F6277D9F8CEC82F89_217602209 = (Math.abs(initialVelocity) > mMinimumVelocity &&
                                !((mFirstPosition == 0 &&
                                        firstChildTop == contentTop - mOverscrollDistance) ||
                                  (mFirstPosition + childCount == mItemCount &&
                                        lastChildBottom == contentBottom + mOverscrollDistance)));
                            {
                                {
                                    mFlingRunnable = new FlingRunnable();
                                } 
                                reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                                mFlingRunnable.start(-initialVelocity);
                            } 
                            {
                                mTouchMode = TOUCH_MODE_REST;
                                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                                {
                                    mFlingRunnable.endFling();
                                } 
                                {
                                    mPositionScroller.stop();
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                mTouchMode = TOUCH_MODE_REST;
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
            } 
            
            
            {
                mFlingRunnable = new FlingRunnable();
            } 
            
            
            final VelocityTracker velocityTracker = mVelocityTracker;
            
            
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            
            
            final int initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
            
            
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
            
            
            {
                boolean varA56DF990188ABEF5AF3A9E103B5F2778_861000080 = (Math.abs(initialVelocity) > mMinimumVelocity);
                {
                    mFlingRunnable.startOverfling(-initialVelocity);
                } 
                {
                    mFlingRunnable.startSpringback();
                } 
            } 
            
            setPressed(false);
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } 
            invalidate();
            final Handler handler = getHandler();
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            recycleVelocityTracker();
            mActivePointerId = INVALID_POINTER;
            {
                {
                    Debug.stopMethodTracing();
                    mScrollProfilingStarted = false;
                } 
            } 
            {
                mScrollStrictSpan.finish();
                mScrollStrictSpan = null;
            } 
        } 
        
        
        {
            
            {
                mFlingRunnable = new FlingRunnable();
            } 
            
            
            mFlingRunnable.startSpringback();
            
            
            mTouchMode = TOUCH_MODE_REST;
            
            
            setPressed(false);
            
            
            View motionView = this.getChildAt(mMotionPosition - mFirstPosition);
            
            
            {
                motionView.setPressed(false);
            } 
            
            
            clearScrollingCache();
            
            
            final Handler handler = getHandler();
            
            
            {
                handler.removeCallbacks(mPendingCheckForLongPress);
            } 
            
            
            recycleVelocityTracker();
            
            {
                mEdgeGlowTop.onRelease();
                mEdgeGlowBottom.onRelease();
            } 
            mActivePointerId = INVALID_POINTER;
        } 
        
        
        {
            onSecondaryPointerUp(ev);
            final int x = mMotionX;
            final int y = mMotionY;
            final int motionPosition = pointToPosition(x, y);
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } 
            mLastY = y;
        } 
        
        
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
            {
                v = getChildAt(motionPosition - mFirstPosition);
                mMotionViewOriginalTop = v.getTop();
                mMotionPosition = motionPosition;
            } 
            mLastY = y;
        } 
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85396894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_85396894;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.921 -0400", hash_original_method = "3A1744A3CB770F6FD9FFEB222E666622", hash_generated_method = "A65F9FBE4B732045E9C138C85F43B1D4")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        
        {
            onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            awakenScrollBars();
        } 
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.921 -0400", hash_original_method = "09132BF5E477A2B233231E384E8A2F27", hash_generated_method = "C0BA2BAFE941665C3FFCDB243ACB6574")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1802082851 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1997103468 = (event.getAction());
                    
                    {
                        {
                            final float vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                final int delta = (int) (vscroll * getVerticalScrollFactor());
                                {
                                    boolean var5104A1C3A4166DC9AEBE0F45BFBBFDA2_1022468557 = (!trackMotionScroll(delta, delta));
                                } 
                            } 
                        } 
                    } 
                    
                } 
            } 
        } 
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_66220038 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996789865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996789865;
        
        
            
                
                    
                        
                        
                            
                            
                                
                            
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.922 -0400", hash_original_method = "F146D016CF32B873211A043EDB782604", hash_generated_method = "B8BB6347FE87E4DF6258B709E3947487")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            final int scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_1761677977 = (!mEdgeGlowTop.isFinished());
                {
                    final int restoreCount = canvas.save();
                    final int leftPadding = mListPadding.left + mGlowPaddingLeft;
                    final int rightPadding = mListPadding.right + mGlowPaddingRight;
                    final int width = getWidth() - leftPadding - rightPadding;
                    canvas.translate(leftPadding,
                        Math.min(0, scrollY + mFirstPositionDistanceGuess));
                    mEdgeGlowTop.setSize(width, getHeight());
                    {
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_1659105354 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } 
                    } 
                    canvas.restoreToCount(restoreCount);
                } 
            } 
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_360457407 = (!mEdgeGlowBottom.isFinished());
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
                    {
                        boolean var61CCF9557D478E1494862B3636E22888_393804524 = (mEdgeGlowBottom.draw(canvas));
                        {
                            invalidate();
                        } 
                    } 
                    canvas.restoreToCount(restoreCount);
                } 
            } 
        } 
        {
            final int scrollY = mScrollY;
            {
                int restoreCount = canvas.save();
                canvas.translate(0, (float) scrollY);
                mFastScroller.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } 
            {
                mFastScroller.draw(canvas);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.923 -0400", hash_original_method = "9FFFDAFD9442A3DE6BE69946897AC2B3", hash_generated_method = "763087F4905BF1A44B4D70DFA37C4F6C")
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding) {
        mGlowPaddingLeft = leftPadding;
        mGlowPaddingRight = rightPadding;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.923 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
    private void initOrResetVelocityTracker() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        {
            mVelocityTracker.clear();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.923 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.923 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
    private void recycleVelocityTracker() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.924 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            recycleVelocityTracker();
        } 
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        addTaint(disallowIntercept);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.925 -0400", hash_original_method = "BEACBA96FA37C833811279893053B3A1", hash_generated_method = "57ED5853AF20C038C9D19B1CCE67E040")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        int action = ev.getAction();
        View v;
        {
            boolean intercepted = mFastScroller.onInterceptTouchEvent(ev);
        } 
        
        {
            int touchMode = mTouchMode;
            {
                mMotionCorrection = 0;
            } 
            final int x = (int) ev.getX();
            final int y = (int) ev.getY();
            mActivePointerId = ev.getPointerId(0);
            int motionPosition = findMotionRow(y);
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
        } 
        
        
        {
            
            int pointerIndex = ev.findPointerIndex(mActivePointerId);
            
            
            {
                pointerIndex = 0;
                mActivePointerId = ev.getPointerId(pointerIndex);
            } 
            
            
            final int y = (int) ev.getY(pointerIndex);
            
            
            initVelocityTrackerIfNotExists();
            
            
            mVelocityTracker.addMovement(ev);
            
            
            {
                boolean varBEAADC7EDD4EC70730C4344D280FA313_585325482 = (startScrollIfNeeded(y));
            } 
            
        } 
        
        
        {
            mTouchMode = TOUCH_MODE_REST;
            mActivePointerId = INVALID_POINTER;
            recycleVelocityTracker();
            reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
        } 
        
        
        {
            onSecondaryPointerUp(ev);
        } 
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045391598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045391598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.925 -0400", hash_original_method = "C5DD3809C32C06AD527DF2275274EBCF", hash_generated_method = "E0774D5D44BB32FE14732A34F10B5FF8")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mMotionX = (int) ev.getX(newPointerIndex);
            mMotionY = (int) ev.getY(newPointerIndex);
            mMotionCorrection = 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
        } 
        
        
                
        
        
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.926 -0400", hash_original_method = "7406EAB31F4F45208F8FFDB2641D9148", hash_generated_method = "F450C89A2EC803A60F19098D32D155F9")
    @Override
    public void addTouchables(ArrayList<View> views) {
        final int count = getChildCount();
        final int firstPosition = mFirstPosition;
        final ListAdapter adapter = mAdapter;
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var2E8FCA4FD70E922109B068B9683F621A_47399916 = (adapter.isEnabled(firstPosition + i));
                    {
                        views.add(child);
                    } 
                } 
                child.addTouchables(views);
            } 
        } 
        addTaint(views.getTaint());
        
        
        
        
        
            
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.927 -0400", hash_original_method = "53B60DC92C627A12BA76D6AAFD79D448", hash_generated_method = "5393B681A4461AB81DBE3337E826FE9E")
     void reportScrollStateChange(int newState) {
        {
            {
                mLastScrollState = newState;
                mOnScrollListener.onScrollStateChanged(this, newState);
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.928 -0400", hash_original_method = "09656A4DFD81148F85DAB6B80BBEDF83", hash_generated_method = "B7F397FB63B938D69592A5A5BEFF477A")
    public void setFriction(float friction) {
        {
            mFlingRunnable = new FlingRunnable();
        } 
        mFlingRunnable.mScroller.setFriction(friction);
        addTaint(friction);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.928 -0400", hash_original_method = "0A97F6C2B71DEE1A9A851FDFBE6F2171", hash_generated_method = "22912162971CDA2675BA2D8F41874A24")
    public void setVelocityScale(float scale) {
        mVelocityScale = scale;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.929 -0400", hash_original_method = "5ADECEDEBCB45348FEE18FEA2660C669", hash_generated_method = "E2A85D26F4AF3D5C48B6FA845A035F3A")
    public void smoothScrollToPosition(int position) {
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.start(position);
        addTaint(position);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.929 -0400", hash_original_method = "8931967DEF21C4BF02F7EE5F6DA25484", hash_generated_method = "9028CC58FCE919AD6DFD04627C596854")
    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.startWithOffset(position, offset, duration);
        addTaint(position);
        addTaint(offset);
        addTaint(duration);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.929 -0400", hash_original_method = "481FD979A7BEB05C5D5FED69D6209380", hash_generated_method = "743C4C8BE2F1287998AB3C500F30F686")
    public void smoothScrollToPositionFromTop(int position, int offset) {
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.startWithOffset(position, offset);
        addTaint(position);
        addTaint(offset);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.930 -0400", hash_original_method = "D55175FA7A4D56B1E1633A69B89BF26C", hash_generated_method = "078C38FE8B95A8000028138D21023F5E")
    public void smoothScrollToPosition(int position, int boundPosition) {
        {
            mPositionScroller = new PositionScroller();
        } 
        mPositionScroller.start(position, boundPosition);
        addTaint(position);
        addTaint(boundPosition);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.930 -0400", hash_original_method = "F38F4C8B27D75B9B07425BD626A4F57B", hash_generated_method = "554503F2114EE840EC088BD5ABED4D81")
    public void smoothScrollBy(int distance, int duration) {
        {
            mFlingRunnable = new FlingRunnable();
        } 
        final int firstPos = mFirstPosition;
        final int childCount = getChildCount();
        final int lastPos = firstPos + childCount;
        final int topLimit = getPaddingTop();
        final int bottomLimit = getHeight() - getPaddingBottom();
        {
            boolean varE771752E61AAE94EE838BEB839D51E29_505938376 = (distance == 0 || mItemCount == 0 || childCount == 0 ||
                (firstPos == 0 && getChildAt(0).getTop() == topLimit && distance < 0) ||
                (lastPos == mItemCount - 1 &&
                        getChildAt(childCount - 1).getBottom() == bottomLimit && distance > 0));
            {
                mFlingRunnable.endFling();
                {
                    mPositionScroller.stop();
                } 
            } 
            {
                reportScrollStateChange(OnScrollListener.SCROLL_STATE_FLING);
                mFlingRunnable.startScroll(distance, duration);
            } 
        } 
        addTaint(distance);
        addTaint(duration);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.931 -0400", hash_original_method = "C17AB5094757737D3C9F6E76AFA310E4", hash_generated_method = "21A1F737D17F2644C97C7E9109D6937D")
     void smoothScrollByOffset(int position) {
        int index = -1;
        {
            index = getFirstVisiblePosition();
        } 
        {
            index = getLastVisiblePosition();
        } 
        {
            View child = getChildAt(index - getFirstVisiblePosition());
            {
                Rect visibleRect = new Rect();
                {
                    boolean var18BDB2D3799631890650FD697075D5F9_1598331488 = (child.getGlobalVisibleRect(visibleRect));
                    {
                        int childRectArea = child.getWidth() * child.getHeight();
                        int visibleRectArea = visibleRect.width() * visibleRect.height();
                        float visibleArea = (visibleRectArea / (float) childRectArea);
                        final float visibleThreshold = 0.75f;
                    } 
                } 
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), index + position)));
            } 
        } 
        addTaint(position);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.931 -0400", hash_original_method = "81BA0C283B501CA4B76891C73CF6304F", hash_generated_method = "4F2D2548096503CB8CD1B64A3B2D9FBF")
    private void createScrollingCache() {
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingStarted = mCachingActive = true;
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.932 -0400", hash_original_method = "5EE1F7DCF1506371E8A50F14184A0F0B", hash_generated_method = "7023E32C5780D01C571220EBB043CCD3")
    private void clearScrollingCache() {
        {
            mClearScrollingCache = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.932 -0400", hash_original_method = "C1A06A57DD958FE417CF10EBDAA96EFE", hash_generated_method = "9387EFDE7CA35B48F1999C8488243E79")
                public void run() {
                    {
                        mCachingStarted = mCachingActive = false;
                        setChildrenDrawnWithCacheEnabled(false);
                        {
                            setChildrenDrawingCacheEnabled(false);
                        } 
                        {
                            boolean var600D0F7D7BFFDAD0124DB110898B3A19_526201372 = (!isAlwaysDrawnWithCacheEnabled());
                            {
                                invalidate();
                            } 
                        } 
                    } 
                    
                    
                        
                        
                        
                            
                        
                        
                            
                        
                    
                }
};
        } 
        post(mClearScrollingCache);
        
        
            
                
                    
                        
                        
                        
                            
                        
                        
                            
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.934 -0400", hash_original_method = "A42371BB3F2D334094B7131C15A0F3E8", hash_generated_method = "7488D9969FB87CD58038A1A1147235DF")
     boolean trackMotionScroll(int deltaY, int incrementalDeltaY) {
        final int childCount = getChildCount();
        final int firstTop = getChildAt(0).getTop();
        final int lastBottom = getChildAt(childCount - 1).getBottom();
        final Rect listPadding = mListPadding;
        int effectivePaddingTop = 0;
        int effectivePaddingBottom = 0;
        {
            effectivePaddingTop = listPadding.top;
            effectivePaddingBottom = listPadding.bottom;
        } 
        final int spaceAbove = effectivePaddingTop - firstTop;
        final int end = getHeight() - effectivePaddingBottom;
        final int spaceBelow = lastBottom - end;
        final int height = getHeight() - mPaddingBottom - mPaddingTop;
        {
            deltaY = Math.max(-(height - 1), deltaY);
        } 
        {
            deltaY = Math.min(height - 1, deltaY);
        } 
        {
            incrementalDeltaY = Math.max(-(height - 1), incrementalDeltaY);
        } 
        {
            incrementalDeltaY = Math.min(height - 1, incrementalDeltaY);
        } 
        final int firstPosition = mFirstPosition;
        {
            mFirstPositionDistanceGuess = firstTop - listPadding.top;
        } 
        {
            mFirstPositionDistanceGuess += incrementalDeltaY;
        } 
        {
            mLastPositionDistanceGuess = lastBottom + listPadding.bottom;
        } 
        {
            mLastPositionDistanceGuess += incrementalDeltaY;
        } 
        final boolean cannotScrollDown = (firstPosition == 0 &&
                firstTop >= listPadding.top && incrementalDeltaY >= 0);
        final boolean cannotScrollUp = (firstPosition + childCount == mItemCount &&
                lastBottom <= getHeight() - listPadding.bottom && incrementalDeltaY <= 0);
        final boolean down = incrementalDeltaY < 0;
        final boolean inTouchMode = isInTouchMode();
        {
            hideSelector();
        } 
        final int headerViewsCount = getHeaderViewsCount();
        final int footerViewsStart = mItemCount - getFooterViewsCount();
        int start = 0;
        int count = 0;
        {
            int top = -incrementalDeltaY;
            {
                top += listPadding.top;
            } 
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    {
                        boolean varEA5CC9EA6E04B02875DA6B296CDA3DF6_1258220126 = (child.getBottom() >= top);
                        {
                            int position = firstPosition + i;
                            {
                                mRecycler.addScrapView(child, position);
                                {
                                    ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            int bottom = getHeight() - incrementalDeltaY;
            {
                bottom -= listPadding.bottom;
            } 
            {
                int i = childCount - 1;
                {
                    final View child = getChildAt(i);
                    {
                        boolean var0C9792EB8E72B1E8C3A203B5FF9D7EBC_357429898 = (child.getTop() <= bottom);
                        {
                            start = i;
                            int position = firstPosition + i;
                            {
                                mRecycler.addScrapView(child, position);
                                {
                                    ViewDebug.trace(child,
                                    ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
                                    firstPosition + i, -1);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        mMotionViewNewTop = mMotionViewOriginalTop + deltaY;
        mBlockLayoutRequests = true;
        {
            detachViewsFromParent(start, count);
        } 
        offsetChildrenTopAndBottom(incrementalDeltaY);
        {
            mFirstPosition += count;
        } 
        invalidate();
        final int absIncrementalDeltaY = Math.abs(incrementalDeltaY);
        {
            fillGap(down);
        } 
        {
            final int childIndex = mSelectedPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_542514002 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(mSelectedPosition, getChildAt(childIndex));
                } 
            } 
        } 
        {
            final int childIndex = mSelectorPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_1768466641 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(INVALID_POSITION, getChildAt(childIndex));
                } 
            } 
        } 
        {
            mSelectorRect.setEmpty();
        } 
        mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        awakenScrollBars();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931463415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931463415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.935 -0400", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "6BF73E02079C728D976373AAF012B968")
     int getHeaderViewsCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298792419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298792419;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.936 -0400", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "D28EFF1E85533B568D7394C248609196")
     int getFooterViewsCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352040655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_352040655;
        
        
    }

    
    abstract void fillGap(boolean down);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.937 -0400", hash_original_method = "01CAE4EB89DA7F2FB8FB8C551B8C7558", hash_generated_method = "3397357B75DA44B7D8439BB69C481809")
     void hideSelector() {
        {
            {
                mResurrectToPosition = mSelectedPosition;
            } 
            {
                mResurrectToPosition = mNextSelectedPosition;
            } 
            setSelectedPositionInt(INVALID_POSITION);
            setNextSelectedPositionInt(INVALID_POSITION);
            mSelectedTop = 0;
        } 
        
        
            
                
            
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.938 -0400", hash_original_method = "3C42E05D1FE66CE321CE689DCD7609AF", hash_generated_method = "CCEB19C41B6AAF67C57E0C971E80360E")
     int reconcileSelectedPosition() {
        int position = mSelectedPosition;
        {
            position = mResurrectToPosition;
        } 
        position = Math.max(0, position);
        position = Math.min(position, mItemCount - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658239239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658239239;
        
        
        
            
        
        
        
        
    }

    
    abstract int findMotionRow(int y);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.938 -0400", hash_original_method = "620BFFA3FACC4E59D7B8719ED5062EB2", hash_generated_method = "622310DDD67C8117D7F259E88ED83033")
     int findClosestMotionRow(int y) {
        final int childCount = getChildCount();
        final int motionRow = findMotionRow(y);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546295798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546295798;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.939 -0400", hash_original_method = "48746A94CCDD3AA210B8334DFA5415FB", hash_generated_method = "60F28DC437B80BF897562B54CF102004")
    public void invalidateViews() {
        mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.939 -0400", hash_original_method = "DCA216018FB5348F17E51D7322AEEFD4", hash_generated_method = "CD2D76F7230FF1AFF6842890840ED55E")
     boolean resurrectSelectionIfNeeded() {
        {
            boolean varA94BDD63AC24FE4C16F032614F7038B6_2043268534 = (mSelectedPosition < 0 && resurrectSelection());
            {
                updateSelectorState();
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109150134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109150134;
        
        
            
            
        
        
    }

    
    abstract void setSelectionInt(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.941 -0400", hash_original_method = "46DC118C185645539DC69AE3B021DB61", hash_generated_method = "CB931F6906C41E1FD40DEE1E8A94D7D9")
     boolean resurrectSelection() {
        final int childCount = getChildCount();
        int selectedTop = 0;
        int selectedPos;
        int childrenTop = mListPadding.top;
        int childrenBottom = mBottom - mTop - mListPadding.bottom;
        final int firstPosition = mFirstPosition;
        final int toPosition = mResurrectToPosition;
        boolean down = true;
        {
            selectedPos = toPosition;
            final View selected = getChildAt(selectedPos - mFirstPosition);
            selectedTop = selected.getTop();
            int selectedBottom = selected.getBottom();
            {
                selectedTop = childrenTop + getVerticalFadingEdgeLength();
            } 
            {
                selectedTop = childrenBottom - selected.getMeasuredHeight()
                        - getVerticalFadingEdgeLength();
            } 
        } 
        {
            {
                selectedPos = firstPosition;
                {
                    int i = 0;
                    {
                        final View v = getChildAt(i);
                        final int top = v.getTop();
                        {
                            selectedTop = top;
                            {
                                childrenTop += getVerticalFadingEdgeLength();
                            } 
                        } 
                        {
                            selectedPos = firstPosition + i;
                            selectedTop = top;
                        } 
                    } 
                } 
            } 
            {
                final int itemCount = mItemCount;
                down = false;
                selectedPos = firstPosition + childCount - 1;
                {
                    int i = childCount - 1;
                    {
                        final View v = getChildAt(i);
                        final int top = v.getTop();
                        final int bottom = v.getBottom();
                        {
                            selectedTop = top;
                            {
                                childrenBottom -= getVerticalFadingEdgeLength();
                            } 
                        } 
                        {
                            selectedPos = firstPosition + i;
                            selectedTop = top;
                        } 
                    } 
                } 
            } 
        } 
        mResurrectToPosition = INVALID_POSITION;
        removeCallbacks(mFlingRunnable);
        {
            mPositionScroller.stop();
        } 
        mTouchMode = TOUCH_MODE_REST;
        clearScrollingCache();
        mSpecificTop = selectedTop;
        selectedPos = lookForSelectablePosition(selectedPos, down);
        {
            boolean var62F8C3AE45B38B2DECAE10F01A4F320D_262283537 = (selectedPos >= firstPosition && selectedPos <= getLastVisiblePosition());
            {
                mLayoutMode = LAYOUT_SPECIFIC;
                updateSelectorState();
                setSelectionInt(selectedPos);
                invokeOnItemScrollListener();
            } 
            {
                selectedPos = INVALID_POSITION;
            } 
        } 
        reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348285609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348285609;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.941 -0400", hash_original_method = "7A1DBAB399A1231E28D6D54E2346B36F", hash_generated_method = "D57CE6FF829C68DBA36A3ECA7794238A")
     void confirmCheckedPositionsById() {
        mCheckStates.clear();
        boolean checkedCountChanged = false;
        {
            int checkedIndex = 0;
            boolean var345B3951F4A2E6483B2D033F362E91E2_478897083 = (checkedIndex < mCheckedIdStates.size());
            {
                final long id = mCheckedIdStates.keyAt(checkedIndex);
                final int lastPos = mCheckedIdStates.valueAt(checkedIndex);
                final long lastPosId = mAdapter.getItemId(lastPos);
                {
                    final int start = Math.max(0, lastPos - CHECK_POSITION_SEARCH_DISTANCE);
                    final int end = Math.min(lastPos + CHECK_POSITION_SEARCH_DISTANCE, mItemCount);
                    boolean found = false;
                    {
                        int searchPos = start;
                        {
                            final long searchId = mAdapter.getItemId(searchPos);
                            {
                                found = true;
                                mCheckStates.put(searchPos, true);
                                mCheckedIdStates.setValueAt(checkedIndex, searchPos);
                            } 
                        } 
                    } 
                    {
                        mCheckedIdStates.delete(id);
                        checkedCountChanged = true;
                        {
                            mMultiChoiceModeCallback.onItemCheckedStateChanged(mChoiceActionMode,
                                lastPos, id, false);
                        } 
                    } 
                } 
                {
                    mCheckStates.put(lastPos, true);
                } 
            } 
        } 
        {
            mChoiceActionMode.invalidate();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.943 -0400", hash_original_method = "988EE7458DA5CAE45D4D8EEE7B510700", hash_generated_method = "2ECEF74BB92CBDF689637A53B4568355")
    @Override
    protected void handleDataChanged() {
        int count = mItemCount;
        int lastHandledItemCount = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
        {
            boolean var1BF5A9488574E2FA74D8264040FC0893_1367983463 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter != null && mAdapter.hasStableIds());
            {
                confirmCheckedPositionsById();
            } 
        } 
        {
            int newPos;
            int selectablePos;
            {
                mNeedSync = false;
                {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                } 
                {
                    {
                        mForceTranscriptScroll = false;
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } 
                    final int childCount = getChildCount();
                    final int listBottom = getHeight() - getPaddingBottom();
                    final View lastChild = getChildAt(childCount - 1);
                    int lastBottom;
                    lastBottom = lastChild.getBottom();
                    lastBottom = listBottom;
                    {
                        mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    } 
                    awakenScrollBars();
                } 
                
                {
                    boolean varAFC77293C02F773029137FDE42129C14_2040706335 = (isInTouchMode());
                    {
                        mLayoutMode = LAYOUT_SYNC;
                        mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                    } 
                    {
                        newPos = findSyncPosition();
                        {
                            selectablePos = lookForSelectablePosition(newPos, true);
                            {
                                mSyncPosition = newPos;
                                {
                                    boolean varE6F64662C76820CEAED04C173D145196_2059607628 = (mSyncHeight == getHeight());
                                    {
                                        mLayoutMode = LAYOUT_SYNC;
                                    } 
                                    {
                                        mLayoutMode = LAYOUT_SET_SELECTION;
                                    } 
                                } 
                                setNextSelectedPositionInt(newPos);
                            } 
                        } 
                    } 
                } 
                
                
                mLayoutMode = LAYOUT_SYNC;
                
                
                mSyncPosition = Math.min(Math.max(0, mSyncPosition), count - 1);
                
            } 
            {
                boolean var12100596BD466B0E4730696B6E3F9C25_1207924019 = (!isInTouchMode());
                {
                    newPos = getSelectedItemPosition();
                    {
                        newPos = count - 1;
                    } 
                    {
                        newPos = 0;
                    } 
                    selectablePos = lookForSelectablePosition(newPos, true);
                    {
                        setNextSelectedPositionInt(selectablePos);
                    } 
                    {
                        selectablePos = lookForSelectablePosition(newPos, false);
                        {
                            setNextSelectedPositionInt(selectablePos);
                        } 
                    } 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.943 -0400", hash_original_method = "C562B15A4430BC762CC4B771E60D70AF", hash_generated_method = "5F0FD14F7995E07F5E127B204C89E5E0")
    @Override
    protected void onDisplayHint(int hint) {
        
        super.onDisplayHint(hint);
        
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_1727306786 = (mPopup != null && mPopup.isShowing());
            {
                dismissPopup();
            } 
        } 
        
        
        {
            boolean var003C494DA1AA746A5D5A0908F950DF91_835756382 = (mFiltered && mPopup != null && !mPopup.isShowing());
            {
                showPopup();
            } 
        } 
        
        mPopupHidden = hint == INVISIBLE;
        
        
        
            
                
                    
                
                
            
                
                    
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.944 -0400", hash_original_method = "86B533D40AC94020BA9211F436996CAA", hash_generated_method = "6F219CE9A5114FCF258245673A1C0226")
    private void dismissPopup() {
        {
            mPopup.dismiss();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.944 -0400", hash_original_method = "6C07C7201C3F8F7AE411CAF5368DC26F", hash_generated_method = "73201E92F8E51D96C6A92ED207456B09")
    private void showPopup() {
        {
            boolean varEC31A88682EDD8797910B3EFA4C60835_1740776676 = (getWindowVisibility() == View.VISIBLE);
            {
                createTextFilter(true);
                positionPopup();
                checkFocus();
            } 
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.944 -0400", hash_original_method = "84FE8B62D6AD62C84F51A39D7331FBA6", hash_generated_method = "2BED25C4F93C492C88E5480847FA41E5")
    private void positionPopup() {
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        final int[] xy = new int[2];
        getLocationOnScreen(xy);
        final int bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
        {
            boolean varE8127168ED545283F844FC09586AD49B_1405207288 = (!mPopup.isShowing());
            {
                mPopup.showAtLocation(this, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                    xy[0], bottomGap);
            } 
            {
                mPopup.update(xy[0], bottomGap, -1, -1);
            } 
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.945 -0400", hash_original_method = "E53786E832898AFD8F3D1858C7ADFC0B", hash_generated_method = "F54B0739DECC462B1E547F02A0E321D6")
    @Override
    protected boolean isInFilterMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89264430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89264430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.947 -0400", hash_original_method = "E9CFCD950A6A0EAC13FE4A21D8302AE8", hash_generated_method = "D58B63C9B0EA96DF8F6D46A394DCDE11")
     boolean sendToTextFilter(int keyCode, int count, KeyEvent event) {
        {
            boolean var8E508D5098333C3DF9E9AC1534499251_2108740591 = (!acceptFilter());
        } 
        boolean handled = false;
        boolean okToSend = true;
        
        okToSend = false;
        
        
        {
            boolean var39DB415F3D8E94BAF1BCAFDEBBF4C6EF_162800594 = (mFiltered && mPopup != null && mPopup.isShowing());
            {
                {
                    boolean varF129D97EB58BBADBA4875AF25E33B341_1343143031 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } 
                        handled = true;
                    } 
                    {
                        boolean varF38DB653E52CB4D0E4EDFCBA5E49A3DF_796153341 = (event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled());
                        {
                            handled = true;
                            mTextFilter.setText("");
                        } 
                    } 
                } 
            } 
        } 
        
        
        okToSend = false;
        
        
        okToSend = mFiltered;
        
        {
            createTextFilter(true);
            KeyEvent forwardEvent = event;
            {
                boolean var6A7BE4CA28243E587EACA0203B08BD67_25061034 = (forwardEvent.getRepeatCount() > 0);
                {
                    forwardEvent = KeyEvent.changeTimeRepeat(event, event.getEventTime(), 0);
                } 
            } 
            int action = event.getAction();
            
            handled = mTextFilter.onKeyDown(keyCode, forwardEvent);
            
            
            handled = mTextFilter.onKeyUp(keyCode, forwardEvent);
            
            
            handled = mTextFilter.onKeyMultiple(keyCode, count, event);
            
        } 
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982126424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982126424;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.951 -0400", hash_original_method = "D11D50B93967E008BF298EC93C5B84EB", hash_generated_method = "2C9C8B1C8F880477778EAC927F3FB34F")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_24591920 = null; 
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_67914795 = null; 
        {
            boolean var402F49E4B8F4D68C8A96D34BD4EE8DD9_2012755048 = (isTextFilterEnabled());
            {
                createTextFilter(false);
                {
                    mDefInputConnection = new BaseInputConnection(this, false);
                    mPublicInputConnection = new InputConnectionWrapper(
                        mTextFilter.onCreateInputConnection(outAttrs), true) {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.950 -0400", hash_original_method = "BF513EB07D63CFAF3DB0C9E86F478409", hash_generated_method = "B4D160BCA9AB26D6B4CCD1062424E630")
                        @Override
                        public boolean reportFullscreenMode(boolean enabled) {
                            boolean var75DA12718785A0AA273693F989B797D6_1858644889 = (mDefInputConnection.reportFullscreenMode(enabled));
                            addTaint(enabled);
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696195494 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696195494;
                            
                            
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.950 -0400", hash_original_method = "D9C91C9E69679EA1CEEF772A4C39F6DE", hash_generated_method = "0414409B4B3EA515CC4D6E3D66E096D1")
                        @Override
                        public boolean performEditorAction(int editorAction) {
                            {
                                InputMethodManager imm = (InputMethodManager)
                                    getContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
                                {
                                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                } 
                            } 
                            addTaint(editorAction);
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329340652 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329340652;
                            
                            
                            
                                    
                                            
                            
                                
                            
                            
                        
                            
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.950 -0400", hash_original_method = "4DB1D1C6C2201E74EC410884B47F862A", hash_generated_method = "C4A80FCD65DB18A3D0D4EF3DD74348CE")
                        @Override
                        public boolean sendKeyEvent(KeyEvent event) {
                            boolean varDB2D5BE018F84A831888EA06678F8604_447627940 = (mDefInputConnection.sendKeyEvent(event));
                            addTaint(event.getTaint());
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990013236 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_990013236;
                            
                            
                        }
};
                } 
                outAttrs.inputType = EditorInfo.TYPE_CLASS_TEXT
                    | EditorInfo.TYPE_TEXT_VARIATION_FILTER;
                outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE;
                varB4EAC82CA7396A68D541C85D26508E83_24591920 = mPublicInputConnection;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_67914795 = null;
        InputConnection varA7E53CE21691AB073D9660D615818899_529547871; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_529547871 = varB4EAC82CA7396A68D541C85D26508E83_24591920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_529547871 = varB4EAC82CA7396A68D541C85D26508E83_67914795;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_529547871.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_529547871;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.951 -0400", hash_original_method = "44BA525DE8B7DBBB72825E23CC2BB1F6", hash_generated_method = "BDC7C36613BFBC82EB8729A8D60F4958")
    @Override
    public boolean checkInputConnectionProxy(View view) {
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703070596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703070596;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.952 -0400", hash_original_method = "F3682B44558BD825C5F832A45B68670A", hash_generated_method = "C9FC1A36AB03BBF0C2D004C4AA499FF0")
    private void createTextFilter(boolean animateEntrance) {
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
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilter);
        } 
        {
            mPopup.setAnimationStyle(com.android.internal.R.style.Animation_TypingFilterRestore);
        } 
        addTaint(animateEntrance);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.953 -0400", hash_original_method = "32E21A2D6552DD3A6789EF27520CDF5A", hash_generated_method = "E385F44AD4BC37FAD38A5ED8A234304D")
    public void clearTextFilter() {
        {
            mTextFilter.setText("");
            mFiltered = false;
            {
                boolean var8B43E06806BC96AC7F4A8D7A0BE622AC_1383489186 = (mPopup != null && mPopup.isShowing());
                {
                    dismissPopup();
                } 
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.953 -0400", hash_original_method = "65ACBB1BC8C4B28B951746B0589E48B4", hash_generated_method = "FC67E8F6EAB56D69E49FEDB528E0ABED")
    public boolean hasTextFilter() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213258062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213258062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.953 -0400", hash_original_method = "11A5FC28E28C3DFE2639108D4141B162", hash_generated_method = "DDAA310FC1BF4F19674CE9425D72485F")
    public void onGlobalLayout() {
        
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_156624230 = (isShown());
            {
                {
                    boolean varDA5B3CFD94DC14795F693BACD8E64777_813028646 = (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden);
                    {
                        showPopup();
                    } 
                } 
            } 
            {
                {
                    boolean varF98F363210E79C98D906F19BE26A0AAC_639100226 = (mPopup != null && mPopup.isShowing());
                    {
                        dismissPopup();
                    } 
                } 
            } 
        } 
        
        
            
                
            
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.954 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "D46551DFD7C1F01B7CC6C2850BBA7577")
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(count);
        addTaint(after);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.954 -0400", hash_original_method = "971B961D673D514356DF6D21C3AC22CE", hash_generated_method = "980DF5D4779A265D50CAFD0F3DC51070")
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        
        {
            boolean varCB324F139DAF9E78619086072BD20A85_794416822 = (mPopup != null && isTextFilterEnabled());
            {
                int length = s.length();
                boolean showing = mPopup.isShowing();
                {
                    showPopup();
                    mFiltered = true;
                } 
                {
                    dismissPopup();
                    mFiltered = false;
                } 
                {
                    Filter f = ((Filterable) mAdapter).getFilter();
                    {
                        f.filter(s, this);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("You cannot call onTextChanged with a non "
                            + "filterable adapter");
                    } 
                } 
            } 
        } 
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.955 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.956 -0400", hash_original_method = "5FB3F90813AE5A23A23BDBAA76A97056", hash_generated_method = "0F0B22EF0C1B46EE125EA505154531EA")
    public void onFilterComplete(int count) {
        
        {
            mResurrectToPosition = INVALID_POSITION;
            resurrectSelection();
        } 
        addTaint(count);
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.956 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "C5A4B0E9A55DBA91F468E403882EE931")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1272281969 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1272281969 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1272281969.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1272281969;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.958 -0400", hash_original_method = "D7DCCEE0C1D1153E18E019649E6F2D80", hash_generated_method = "18252BF09E63744DD9DAD7F17A2836FD")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_300537759 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_300537759 = new AbsListView.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_300537759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_300537759;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.958 -0400", hash_original_method = "7C8047E4E7C938CA1D7BE889EE17D059", hash_generated_method = "BD24FB81695A51A6F35802F1708A76E0")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079219702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079219702;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.958 -0400", hash_original_method = "1385B81082A7F6F42283DE7C72A352C9", hash_generated_method = "EDB13FA3924957A0F3CE2B87C521F371")
    public void setTranscriptMode(int mode) {
        mTranscriptMode = mode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.959 -0400", hash_original_method = "EADF20E51473F5B82FC89B630E89BCE7", hash_generated_method = "77ACA101D36DEA315CB9E2AF248CF933")
    public int getTranscriptMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242184388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242184388;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.959 -0400", hash_original_method = "3A641BF6273957C36676C590B4CC3444", hash_generated_method = "2A9426135A9B325C82545C0DE5C17246")
    @Override
    public int getSolidColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032672270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032672270;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.959 -0400", hash_original_method = "B2E4EFE21735BA4D4CA20D9D2323DF5E", hash_generated_method = "87BAE0904CDD8BC05951E7851E772268")
    public void setCacheColorHint(int color) {
        {
            mCacheColorHint = color;
            int count = getChildCount();
            {
                int i = 0;
                {
                    getChildAt(i).setDrawingCacheBackgroundColor(color);
                } 
            } 
            mRecycler.setCacheColorHint(color);
        } 
        
        
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.960 -0400", hash_original_method = "75945C93CA5A574EC2A11912410CB0E0", hash_generated_method = "136EA61FA16D056B7CE8DA1B87BA289C")
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877728218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877728218;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.960 -0400", hash_original_method = "012761D54D3EA9FE8C837ED35E18F05A", hash_generated_method = "2D1C47233900DBEE950901A9CE433CC6")
    public void reclaimViews(List<View> views) {
        int childCount = getChildCount();
        RecyclerListener listener = mRecycler.mRecyclerListener;
        {
            int i = 0;
            {
                View child = getChildAt(i);
                AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
                {
                    boolean var248D80F0B10623F58D6026D84DE5E671_1176861471 = (lp != null && mRecycler.shouldRecycleViewType(lp.viewType));
                    {
                        views.add(child);
                        {
                            listener.onMovedToScrapHeap(child);
                        } 
                    } 
                } 
            } 
        } 
        mRecycler.reclaimScrapViews(views);
        removeAllViewsInLayout();
        addTaint(views.getTaint());
        
        
        
        
            
            
            
                
                
                    
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.961 -0400", hash_original_method = "63F1E187EEAD4E39E30E7C6F8BC8B8CA", hash_generated_method = "518A4E72749878997482715418B18D45")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        
        boolean result = super.onConsistencyCheck(consistency);
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        {
            final View[] activeViews = mRecycler.mActiveViews;
            int count = activeViews.length;
            {
                int i = 0;
                {
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "AbsListView " + this + " has a view in its active recycler: " +
                                    activeViews[i]);
                    } 
                } 
            } 
            final ArrayList<View> scrap = mRecycler.mCurrentScrap;
            {
                boolean var1B9DDC99DC36041733636881A6D6F2A7_1142725812 = (!checkScrap(scrap));
                result = false;
            } 
            final ArrayList<View>[] scraps = mRecycler.mScrapViews;
            count = scraps.length;
            {
                int i = 0;
                {
                    {
                        boolean var152726F7FF3AB1D0325523449C0C26DB_667032719 = (!checkScrap(scraps[i]));
                        result = false;
                    } 
                } 
            } 
        } 
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2004060731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2004060731;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.961 -0400", hash_original_method = "256B8EB3FFECB4266216E5C3F84B8A1E", hash_generated_method = "A32CEDE7A6CE154E8088EC1847849B89")
    private boolean checkScrap(ArrayList<View> scrap) {
        boolean result = true;
        final int count = scrap.size();
        {
            int i = 0;
            {
                final View view = scrap.get(i);
                {
                    boolean varC649C41AA848C000C1488527EB85E854_1518852230 = (view.getParent() != null);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
                    } 
                } 
                {
                    boolean var6F0CAFE49F301E66083476B8CB251F7E_335757448 = (indexOfChild(view) >= 0);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap that is also a direct child: " + view);
                    } 
                } 
            } 
        } 
        addTaint(scrap.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633444966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633444966;
        
        
        
        
        
            
            
                
                
                        
            
            
                
                
                        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.962 -0400", hash_original_method = "D0C284A2FBB36CA42A8E7F826DDB725F", hash_generated_method = "4702EDEA243C09BBFD77258C1ACBC569")
    private void finishGlows() {
        {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.962 -0400", hash_original_method = "C1CCFF5C419F753BE2BE6DDA2ACFD3CA", hash_generated_method = "03F25D29CCB11E2CC644BAEB152E7A8F")
    public void setRemoteViewsAdapter(Intent intent) {
        {
            Intent.FilterComparison fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld = new Intent.FilterComparison(
                    mRemoteAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_606525803 = (fcNew.equals(fcOld));
            } 
        } 
        mDeferNotifyDataSetChanged = false;
        mRemoteAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        
        
            
            
                    
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.962 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.963 -0400", hash_original_method = "28DEF371BA940ACF691CB065E03F3A69", hash_generated_method = "E344F6340416416A1956D992ECEE40FF")
    public boolean onRemoteAdapterConnected() {
        
        {
            setAdapter(mRemoteAdapter);
            {
                mRemoteAdapter.notifyDataSetChanged();
                mDeferNotifyDataSetChanged = false;
            } 
        } 
        {
            mRemoteAdapter.superNotifyDataSetChanged();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140582394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140582394;
        
        
            
            
                
                
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.963 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.963 -0400", hash_original_method = "A10CF4C818C12AB96D88DAC8638A238F", hash_generated_method = "404EE273DAE2437904EE1226A8B166EC")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.976 -0400", hash_original_field = "74B7CE7BE804A955E8E20EA04653DEE6", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "22E8B3D384A8481DE4964CE4DE9406EA", hash_generated_field = "0BDE14D7CA4854CAEFC01406C97CEF7F")

        long firstId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "D1400BAE47A67FF79088280865144D7B", hash_generated_field = "56346AA9CA8DBF7744AF68AF06173D8A")

        int viewTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "8F36DB7D8F52F07B49D496BF7578B9B0")

        String filter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "056850EF315F5D6E6668719E2250DB2D", hash_generated_field = "5A1FA0BDDD0CC1410D12AF217F54B1FD")

        boolean inActionMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "934BB5987834E703FF3C24EA9FABB4CC", hash_generated_field = "B7E6911A4E2ECF81E111555BDE3C9E25")

        int checkedItemCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "9DD4030F43EEA8422A0B20FE0265BCBA", hash_generated_field = "6CA6AED4CE00926047251B3E7BCD1BAB")

        SparseBooleanArray checkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_field = "4E89343A86D5E5558CBC6356B8A823D3", hash_generated_field = "9634971E46A47F441AB88BCA83B02BB2")

        LongSparseArray<Integer> checkIdState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.977 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.978 -0400", hash_original_method = "9305A5F2B13D160808C7DFC7D0F396F1", hash_generated_method = "DA697611FAFC9602A642CB5ED7948F89")
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
            {
                checkIdState = new LongSparseArray<Integer>();
                {
                    int i = 0;
                    {
                        final long key = in.readLong();
                        final int value = in.readInt();
                        checkIdState.put(key, value);
                    } 
                } 
            } 
            
            
            
            
            
            
            
            
            
            
            
            
                
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.978 -0400", hash_original_method = "3B46B91B7C73B4C6AC70E6F2F8A95E0E", hash_generated_method = "C29E9AAA4BCD9BF04803C5399C55DB7A")
        @Override
        public void writeToParcel(Parcel out, int flags) {
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
                int i = 0;
                {
                    out.writeLong(checkIdState.keyAt(i));
                    out.writeInt(checkIdState.valueAt(i));
                } 
            } 
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.979 -0400", hash_original_method = "28CD4AAEE48E548227BD32788E936C86", hash_generated_method = "4B302BE736465B81DFA4C8A8259D3711")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1901241364 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1901241364 = "AbsListView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " firstId=" + firstId
                    + " viewTop=" + viewTop
                    + " position=" + position
                    + " height=" + height
                    + " filter=" + filter
                    + " checkState=" + checkState + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1901241364.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1901241364;
            
            
                    
                    
                    
                    
                    
                    
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.979 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_field = "71E0FB0329E33FA478C7BD9F2EB990C7", hash_generated_field = "C8F22F4E13BEEC60720F9AB64A1792E3")

        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_method = "A658DB72BEF305C977658A79961C7172", hash_generated_method = "A658DB72BEF305C977658A79961C7172")
        public WindowRunnnable ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_method = "CFEEFBABEEA41C591AAAAD229F2BB0E7", hash_generated_method = "3CF34E449DE44A2D47EB624B8E366E7B")
        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_method = "A209657341959E6933B2954972D0CEE9", hash_generated_method = "7F9AB827D032C8B69DA61C512A1E72AB")
        public boolean sameWindow() {
            boolean var8C6821449255A008A670CF7CA64A93AB_354145922 = (hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211342593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_211342593;
            
            
        }

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_field = "4D3D586E79B5D45386198E5887F48792", hash_generated_field = "C001E24B1020A024FC58CC124DF01D4E")

        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.980 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.981 -0400", hash_original_method = "A958048F64A683459F522CCD37FE7D11", hash_generated_method = "5EF6E1137727B2D6518232EF2527B939")
        public void run() {
            final ListAdapter adapter = mAdapter;
            final int motionPosition = mClickMotionPosition;
            {
                boolean varB13BDDA7CDF6AF0E3819BBDA363D7ED8_70454868 = (adapter != null && mItemCount > 0 &&
                    motionPosition != INVALID_POSITION &&
                    motionPosition < adapter.getCount() && sameWindow());
                {
                    final View view = getChildAt(motionPosition - mFirstPosition);
                    {
                        performItemClick(view, motionPosition, adapter.getItemId(motionPosition));
                    } 
                } 
            } 
            
            
            
            
            
                    
                    
                
                
                    
                
            
        }

        
    }


    
    private class CheckForLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.981 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.981 -0400", hash_original_method = "6FF0C5D4F5CC73F85A2BCE7243EBBA32", hash_generated_method = "B41E8E209F7FA971B6E225312189A275")
        public void run() {
            final int motionPosition = mMotionPosition;
            final View child = getChildAt(motionPosition - mFirstPosition);
            {
                final int longPressPosition = mMotionPosition;
                final long longPressId = mAdapter.getItemId(mMotionPosition);
                boolean handled = false;
                {
                    boolean var67E4CE6BEABC0BB93EA224EBEDE2210E_1807871412 = (sameWindow() && !mDataChanged);
                    {
                        handled = performLongPress(child, longPressPosition, longPressId);
                    } 
                } 
                {
                    mTouchMode = TOUCH_MODE_REST;
                    setPressed(false);
                    child.setPressed(false);
                } 
                {
                    mTouchMode = TOUCH_MODE_DONE_WAITING;
                } 
            } 
            
            
            
            
                
                
                
                
                    
                
                
                    
                    
                    
                
                    
                
            
        }

        
    }


    
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.981 -0400", hash_original_method = "D4E5218C094B479D486A451FD5B82AD6", hash_generated_method = "D4E5218C094B479D486A451FD5B82AD6")
        public CheckForKeyLongPress ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.981 -0400", hash_original_method = "A3D23752A2B3700EB42478E66A11709C", hash_generated_method = "3541318A24743A8D0F83523B71A10FB9")
        public void run() {
            {
                boolean varA166426E2772E5B5C6CC900A627665FC_514356419 = (isPressed() && mSelectedPosition >= 0);
                {
                    int index = mSelectedPosition - mFirstPosition;
                    View v = getChildAt(index);
                    {
                        boolean handled = false;
                        {
                            boolean var15017B83B2D3E709399CA037CED2AFF9_377380847 = (sameWindow());
                            {
                                handled = performLongPress(v, mSelectedPosition, mSelectedRowId);
                            } 
                        } 
                        {
                            setPressed(false);
                            v.setPressed(false);
                        } 
                    } 
                    {
                        setPressed(false);
                        v.setPressed(false);
                    } 
                } 
            } 
            
            
                
                
                
                    
                    
                        
                    
                    
                        
                        
                    
                
                    
                    
                
            
        }

        
    }


    
    final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.982 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.982 -0400", hash_original_method = "BD1CF9A4027AFE49AD3D9DDE12B9EB2A", hash_generated_method = "2DB2E15B7D0D5AF9DB379F4D3A70920A")
        public void run() {
            {
                mTouchMode = TOUCH_MODE_TAP;
                final View child = getChildAt(mMotionPosition - mFirstPosition);
                {
                    boolean varEFC9B5F6E2423C87CACF29EB92D1C650_1072682291 = (child != null && !child.hasFocusable());
                    {
                        mLayoutMode = LAYOUT_NORMAL;
                        {
                            child.setPressed(true);
                            setPressed(true);
                            layoutChildren();
                            positionSelector(mMotionPosition, child);
                            refreshDrawableState();
                            final int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                            final boolean longClickable = isLongClickable();
                            {
                                Drawable d = mSelector.getCurrent();
                                {
                                    {
                                        ((TransitionDrawable) d).startTransition(longPressTimeout);
                                    } 
                                    {
                                        ((TransitionDrawable) d).resetTransition();
                                    } 
                                } 
                            } 
                            {
                                {
                                    mPendingCheckForLongPress = new CheckForLongPress();
                                } 
                                mPendingCheckForLongPress.rememberWindowAttachCount();
                                postDelayed(mPendingCheckForLongPress, longPressTimeout);
                            } 
                            {
                                mTouchMode = TOUCH_MODE_DONE_WAITING;
                            } 
                        } 
                        {
                            mTouchMode = TOUCH_MODE_DONE_WAITING;
                        } 
                    } 
                } 
            } 
            
            
        }

        
    }


    
    private class FlingRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.982 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

        private OverScroller mScroller;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.982 -0400", hash_original_field = "9423EF5EE80CF667F79CA444C6185EF3", hash_generated_field = "86847DC6149E26E8E3AF7D833983C21E")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.983 -0400", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "85D92534340BCEFCD6A4F33FFFEF2C53")
          FlingRunnable() {
            mScroller = new OverScroller(getContext());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.983 -0400", hash_original_method = "03D4FA54CBC93A7E96ECD2486CBEE621", hash_generated_method = "B384F47DC09208E561F22A2C05CB2D1E")
         void start(int initialVelocity) {
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
                } 
            } 
            {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            } 
            addTaint(initialVelocity);
            
            
            
            
                    
            
            
            
                
                    
                    
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.983 -0400", hash_original_method = "7C6D2E7D970FED93FF739DAAC6CC80C2", hash_generated_method = "7C41CFEE57EA1BC21990FED21F3B2E9C")
         void startSpringback() {
            {
                boolean var059811778A6969FDC20EDCB87A1E9DD0_982137409 = (mScroller.springBack(0, mScrollY, 0, 0, 0, 0));
                {
                    mTouchMode = TOUCH_MODE_OVERFLING;
                    invalidate();
                    post(this);
                } 
                {
                    mTouchMode = TOUCH_MODE_REST;
                    reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } 
            } 
            
            
                
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.983 -0400", hash_original_method = "57B70ADF06D2A10A257A1E350228503E", hash_generated_method = "02711FE6BB92CE9C9431001BE46A0C6F")
         void startOverfling(int initialVelocity) {
            mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            mTouchMode = TOUCH_MODE_OVERFLING;
            invalidate();
            post(this);
            addTaint(initialVelocity);
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.984 -0400", hash_original_method = "F0692CC07A14DB0F1E581AFC2CDF3E90", hash_generated_method = "44B176ED58B10DAA4ACC8FD75CF31EE7")
         void edgeReached(int delta) {
            mScroller.notifyVerticalEdgeReached(mScrollY, 0, mOverflingDistance);
            final int overscrollMode = getOverScrollMode();
            {
                boolean var38522C672435F8008EBC1E11034D946B_1069833332 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                    (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && !contentFits()));
                {
                    mTouchMode = TOUCH_MODE_OVERFLING;
                    final int vel = (int) mScroller.getCurrVelocity();
                    {
                        mEdgeGlowTop.onAbsorb(vel);
                    } 
                    {
                        mEdgeGlowBottom.onAbsorb(vel);
                    } 
                } 
                {
                    mTouchMode = TOUCH_MODE_REST;
                    {
                        mPositionScroller.stop();
                    } 
                } 
            } 
            invalidate();
            post(this);
            addTaint(delta);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.984 -0400", hash_original_method = "16B3910BA949F2F73CCA1E8DA35CE0FF", hash_generated_method = "90A735FC2AAC1CCE03B8E25E3D3EFB14")
         void startScroll(int distance, int duration) {
            int initialY;
            initialY = Integer.MAX_VALUE;
            initialY = 0;
            mLastFlingY = initialY;
            mScroller.startScroll(0, initialY, 0, distance, duration);
            mTouchMode = TOUCH_MODE_FLING;
            post(this);
            addTaint(distance);
            addTaint(duration);
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.984 -0400", hash_original_method = "EC718B25FAE44F694CA340373A32BE29", hash_generated_method = "2B0EEAA019059AF768DC2BD4BEFE8E7C")
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
            } 
            
            
            
            
            
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.984 -0400", hash_original_method = "5D655CDBCE73395DC3C27E060B822A32", hash_generated_method = "AF0A59A6E58D426EFA985AB4A1AD55DE")
         void flywheelTouch() {
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.985 -0400", hash_original_method = "4DD83535EAA65B570F4DB1073D459909", hash_generated_method = "9DB1679AD566A07BC1E015962825681A")
        public void run() {
            
            endFling();
            
            
            {
                boolean var8C879AC9111FA456E4D5E672C40ED1D8_2046580520 = (mScroller.isFinished());
            } 
            
            
            {
                {
                    layoutChildren();
                } 
                {
                    boolean varF1747C254517DB9417BE3B51D681F089_1509414287 = (mItemCount == 0 || getChildCount() == 0);
                    {
                        endFling();
                    } 
                } 
                final OverScroller scroller = mScroller;
                boolean more = scroller.computeScrollOffset();
                final int y = scroller.getCurrY();
                int delta = mLastFlingY - y;
                {
                    mMotionPosition = mFirstPosition;
                    final View firstView = getChildAt(0);
                    mMotionViewOriginalTop = firstView.getTop();
                    delta = Math.min(getHeight() - mPaddingBottom - mPaddingTop - 1, delta);
                } 
                {
                    int offsetToLast = getChildCount() - 1;
                    mMotionPosition = mFirstPosition + offsetToLast;
                    final View lastView = getChildAt(offsetToLast);
                    mMotionViewOriginalTop = lastView.getTop();
                    delta = Math.max(-(getHeight() - mPaddingBottom - mPaddingTop - 1), delta);
                } 
                View motionView = getChildAt(mMotionPosition - mFirstPosition);
                int oldTop = 0;
                {
                    oldTop = motionView.getTop();
                } 
                final boolean atEnd = trackMotionScroll(delta, delta) && (delta != 0);
                {
                    {
                        int overshoot = -(delta - (motionView.getTop() - oldTop));
                        overScrollBy(0, overshoot, 0, mScrollY, 0, 0,
                                0, mOverflingDistance, false);
                    } 
                    {
                        edgeReached(delta);
                    } 
                } 
                {
                    invalidate();
                    mLastFlingY = y;
                    post(this);
                } 
                {
                    endFling();
                    {
                        {
                            Debug.stopMethodTracing();
                            mFlingProfilingStarted = false;
                        } 
                        {
                            mFlingStrictSpan.finish();
                            mFlingStrictSpan = null;
                        } 
                    } 
                } 
            } 
            
            
            {
                final OverScroller scroller = mScroller;
                {
                    boolean var0C92AC4985E057FF9B563A127E8C3B23_1117405667 = (scroller.computeScrollOffset());
                    {
                        final int scrollY = mScrollY;
                        final int currY = scroller.getCurrY();
                        final int deltaY = currY - scrollY;
                        {
                            boolean var27491E7A6C26FA30763C389A29F73077_912428623 = (overScrollBy(0, deltaY, 0, scrollY, 0, 0,
                            0, mOverflingDistance, false));
                            {
                                final boolean crossDown = scrollY <= 0 && currY > 0;
                                final boolean crossUp = scrollY >= 0 && currY < 0;
                                {
                                    int velocity = (int) scroller.getCurrVelocity();
                                    velocity = -velocity;
                                    scroller.abortAnimation();
                                    start(velocity);
                                } 
                                {
                                    startSpringback();
                                } 
                            } 
                            {
                                invalidate();
                                post(this);
                            } 
                        } 
                    } 
                    {
                        endFling();
                    } 
                } 
            } 
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.985 -0400", hash_original_field = "1135E78FD7F0199281F6A90573FF1A21", hash_generated_field = "B974BC706FB203D2BBE61C1339EC973E")

        private static final int FLYWHEEL_TIMEOUT = 40;
    }


    
    class PositionScroller implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.985 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

        private int mMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "5F5170865EC69F6B24AEF73CD54B04BC", hash_generated_field = "35DC5F27F96B58A562B22555A8E37DA2")

        private int mTargetPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "6F001A96E4362F7D43184AD4169A147D", hash_generated_field = "001157AAC2240D5D9104D4D4F24CB9C2")

        private int mBoundPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "0CBDF658C2D1AD50575CB7EA8E63F15A", hash_generated_field = "891ABFC466B178DF3188D6BA9AF5BFB7")

        private int mLastSeenPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "BD4F087E6D2FF4D0C8D456B181206FDE", hash_generated_field = "0A9D921182A874240E73B3AC5A654444")

        private int mScrollDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "02F4FC33F196F5F1FB41D460018A21E5", hash_generated_field = "6B555669DDE5E4DA69AE4203D3212DA1")

        private int mExtraScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_field = "C1AA32DDC2CA704B66F75B57225BB113", hash_generated_field = "D33BBF09949BE3C4FE4DC46E6E79C30E")

        private int mOffsetFromTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.986 -0400", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "39D3C7BDBFB04AD5ABE46AB28461C81D")
          PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.987 -0400", hash_original_method = "FDCD353E7B4C16B389C07FF98024D1F6", hash_generated_method = "64085AEA3451E75B4CFABECF57B39CDB")
         void start(int position) {
            stop();
            final int firstPos = mFirstPosition;
            final int lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
            {
                viewTravelCount = firstPos - position + 1;
                mMode = MOVE_UP_POS;
            } 
            {
                viewTravelCount = position - lastPos + 1;
                mMode = MOVE_DOWN_POS;
            } 
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } 
            {
                mScrollDuration = SCROLL_DURATION;
            } 
            mTargetPos = position;
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.987 -0400", hash_original_method = "84EF03A180BC8A392D5F6234ABF1A7D7", hash_generated_method = "B3A9501C819FF87729E294DEAA836B4C")
         void start(int position, int boundPosition) {
            stop();
            {
                start(position);
            } 
            final int firstPos = mFirstPosition;
            final int lastPos = firstPos + getChildCount() - 1;
            int viewTravelCount;
            {
                final int boundPosFromLast = lastPos - boundPosition;
                final int posTravel = firstPos - position + 1;
                final int boundTravel = boundPosFromLast - 1;
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_UP_BOUND;
                } 
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_UP_POS;
                } 
            } 
            {
                final int boundPosFromFirst = boundPosition - firstPos;
                final int posTravel = position - lastPos + 1;
                final int boundTravel = boundPosFromFirst - 1;
                {
                    viewTravelCount = boundTravel;
                    mMode = MOVE_DOWN_BOUND;
                } 
                {
                    viewTravelCount = posTravel;
                    mMode = MOVE_DOWN_POS;
                } 
            } 
            {
                mScrollDuration = SCROLL_DURATION / viewTravelCount;
            } 
            {
                mScrollDuration = SCROLL_DURATION;
            } 
            mTargetPos = position;
            mBoundPos = boundPosition;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.988 -0400", hash_original_method = "BE41DE2B3819156F24DD50B9D9C0C2E0", hash_generated_method = "21C42CBF55FF4200D6CDA7236BAC5184")
         void startWithOffset(int position, int offset) {
            startWithOffset(position, offset, SCROLL_DURATION);
            addTaint(position);
            addTaint(offset);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.989 -0400", hash_original_method = "6B17946EC33D794252BA778D04AAD100", hash_generated_method = "CE3B3A912B563B1464291B869D8A403F")
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
            {
                viewTravelCount = firstPos - position;
            } 
            {
                viewTravelCount = position - lastPos;
            } 
            {
                final int targetTop = getChildAt(position - firstPos).getTop();
                smoothScrollBy(targetTop - offset, duration);
            } 
            final float screenTravelCount = (float) viewTravelCount / childCount;
            mScrollDuration = screenTravelCount < 1 ? (int) (screenTravelCount * duration) :
                    (int) (duration / screenTravelCount);
            mLastSeenPos = INVALID_POSITION;
            post(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.990 -0400", hash_original_method = "EE84C7B9935E89C7F265FE60CF403C46", hash_generated_method = "8545B8FD33B72FF1E0D42710AB6A286F")
         void stop() {
            removeCallbacks(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.991 -0400", hash_original_method = "BF3ECE172F6D799B3639990958E45277", hash_generated_method = "EBF88A83CA7C00E59D27EE2313BD4061")
        public void run() {
            final int listHeight = getHeight();
            final int firstPos = mFirstPosition;
            
            {
                final int lastViewIndex = getChildCount() - 1;
                final int lastPos = firstPos + lastViewIndex;
                {
                    post(this);
                } 
                final View lastView = getChildAt(lastViewIndex);
                final int lastViewHeight = lastView.getHeight();
                final int lastViewTop = lastView.getTop();
                final int lastViewPixelsShowing = listHeight - lastViewTop;
                int extraScroll;
                extraScroll = mExtraScroll;
                extraScroll = mListPadding.bottom;
                smoothScrollBy(lastViewHeight - lastViewPixelsShowing + extraScroll,
                        mScrollDuration);
                mLastSeenPos = lastPos;
                {
                    post(this);
                } 
            } 
            
            
            {
                final int nextViewIndex = 1;
                final int childCount = getChildCount();
                final int nextPos = firstPos + nextViewIndex;
                {
                    post(this);
                } 
                final View nextView = getChildAt(nextViewIndex);
                final int nextViewHeight = nextView.getHeight();
                final int nextViewTop = nextView.getTop();
                final int extraScroll = mExtraScroll;
                {
                    smoothScrollBy(Math.max(0, nextViewHeight + nextViewTop - extraScroll),
                            mScrollDuration);
                    mLastSeenPos = nextPos;
                    post(this);
                } 
                {
                    {
                        smoothScrollBy(nextViewTop - extraScroll, mScrollDuration);
                    } 
                } 
            } 
            
            
            {
                {
                    post(this);
                } 
                final View firstView = getChildAt(0);
                final int firstViewTop = firstView.getTop();
                int extraScroll;
                extraScroll = mExtraScroll;
                extraScroll = mListPadding.top;
                smoothScrollBy(firstViewTop - extraScroll, mScrollDuration);
                mLastSeenPos = firstPos;
                {
                    post(this);
                } 
            } 
            
            
            {
                final int lastViewIndex = getChildCount() - 2;
                final int lastPos = firstPos + lastViewIndex;
                {
                    post(this);
                } 
                final View lastView = getChildAt(lastViewIndex);
                final int lastViewHeight = lastView.getHeight();
                final int lastViewTop = lastView.getTop();
                final int lastViewPixelsShowing = listHeight - lastViewTop;
                mLastSeenPos = lastPos;
                {
                    smoothScrollBy(-(lastViewPixelsShowing - mExtraScroll), mScrollDuration);
                    post(this);
                } 
                {
                    final int bottom = listHeight - mExtraScroll;
                    final int lastViewBottom = lastViewTop + lastViewHeight;
                    {
                        smoothScrollBy(-(bottom - lastViewBottom), mScrollDuration);
                    } 
                } 
            } 
            
            
            {
                {
                    post(this);
                } 
                mLastSeenPos = firstPos;
                final int childCount = getChildCount();
                final int position = mTargetPos;
                final int lastPos = firstPos + childCount - 1;
                int viewTravelCount = 0;
                {
                    viewTravelCount = firstPos - position + 1;
                } 
                {
                    viewTravelCount = position - lastPos;
                } 
                final float screenTravelCount = (float) viewTravelCount / childCount;
                final float modifier = Math.min(Math.abs(screenTravelCount), 1.f);
                {
                    smoothScrollBy((int) (-getHeight() * modifier), mScrollDuration);
                    post(this);
                } 
                {
                    smoothScrollBy((int) (getHeight() * modifier), mScrollDuration);
                    post(this);
                } 
                {
                    final int targetTop = getChildAt(position - firstPos).getTop();
                    final int distance = targetTop - mOffsetFromTop;
                    smoothScrollBy(distance,
                            (int) (mScrollDuration * ((float) distance / getHeight())));
                } 
            } 
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.991 -0400", hash_original_field = "6D32BAB94AC52022ABE497778A495DAC", hash_generated_field = "8760D23EE3F52FD3EFA30CB2F922726A")

        private static final int SCROLL_DURATION = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.991 -0400", hash_original_field = "02C82B162D2A85797A66CB01E29B70B0", hash_generated_field = "DCF6966CB5E1D949B06701433BC1589F")

        private static final int MOVE_DOWN_POS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_field = "63A071222A87531676875677B0989E32", hash_generated_field = "F5258406C91B10C35A200A14E23D83E8")

        private static final int MOVE_UP_POS = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_field = "C032FEC22130B64512CC98C267B48A52", hash_generated_field = "F8253C6298924F79488F04EA928D548B")

        private static final int MOVE_DOWN_BOUND = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_field = "BBA76F34EBD7F64DEFAC7A360A8B5B08", hash_generated_field = "F7D82C60FE0B843E3D09E43A9DCA6526")

        private static final int MOVE_UP_BOUND = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_field = "83197AE6299B7EAE58463509EF4FB028", hash_generated_field = "DCC3D3F749A0C671A9C741C7465D6AEC")

        private static final int MOVE_OFFSET = 5;
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_method = "70826FE759108269AA8BACD409E1C863", hash_generated_method = "DE01F6EC3ED43C4CD1396D4089463EFC")
        @Override
        public void onChanged() {
            
            super.onChanged();
            {
                mFastScroller.onSectionsChanged();
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_method = "4570C5F375E9950A79093241C88AF34D", hash_generated_method = "122CC95F86F15B9927F1E8118900CD7B")
        @Override
        public void onInvalidated() {
            
            super.onInvalidated();
            {
                mFastScroller.onSectionsChanged();
            } 
            
            
            
                
            
        }

        
    }


    
    class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "8BFC2A3FD2E90E6CAECA368B78AA0988")

        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.992 -0400", hash_original_method = "55A4C0C73524FA4BF08CABB1B8DF874B", hash_generated_method = "55A4C0C73524FA4BF08CABB1B8DF874B")
        public MultiChoiceModeWrapper ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.993 -0400", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "3BE0D93844CB69FC6467C6B3B65058ED")
        public void setWrapped(MultiChoiceModeListener wrapped) {
            mWrapped = wrapped;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.993 -0400", hash_original_method = "92496BA2B215F9BD39661C34B9C10361", hash_generated_method = "6268BD557C0DD7C4074F17A97AF23537")
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            
            {
                boolean varD6C93448152EF2C372CDE7A0E8CB7504_658253393 = (mWrapped.onCreateActionMode(mode, menu));
                {
                    setLongClickable(false);
                } 
            } 
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703818118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703818118;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.993 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "E2E9DDA8AD5D50EDD204439158827D79")
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            
            boolean var889963BD11CE1DC6E3538FA5CA769B04_935522319 = (mWrapped.onPrepareActionMode(mode, menu));
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161919943 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_161919943;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.993 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "B61754DE5F3ECC75898597C3A1B565AB")
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            
            boolean varFD1FD09DE497AC204C6AFB08C6591DDB_192492583 = (mWrapped.onActionItemClicked(mode, item));
            addTaint(mode.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2289171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2289171;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_method = "38D50D306A79D91BC9BAC512614B14E4", hash_generated_method = "D5DA3B7D6035D5BD361BAB2BD4A299C9")
        public void onDestroyActionMode(ActionMode mode) {
            
            mWrapped.onDestroyActionMode(mode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
            addTaint(mode.getTaint());
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_method = "54A7C456AE4C179767C141D1533A24F9", hash_generated_method = "3333BE1F16FEA041D1EFB5A708DEFAD5")
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked) {
            
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            {
                boolean var9E354D1EAEB52E913322B0C21F0A7D1D_1549745326 = (getCheckedItemCount() == 0);
                {
                    mode.finish();
                } 
            } 
            addTaint(mode.getTaint());
            addTaint(position);
            addTaint(id);
            addTaint(checked);
            
            
            
                
            
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_field = "BE99FDADF4634E48B1DF67A9485E0784", hash_generated_field = "D0AF750B588A0A8385D3506BD31A2EB8")

        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        }) int viewType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_field = "55471D4F82D5EFF522A6B7E31CC4A788", hash_generated_field = "211C82A03CAC4BFE4A39D3AFA73F8466")

        @ViewDebug.ExportedProperty(category = "list") boolean recycledHeaderFooter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_field = "330307ED6FC7975F67F11BB81BE3F1A9", hash_generated_field = "D6FCB86C3CDA915253A7995A3263A2E5")

        @ViewDebug.ExportedProperty(category = "list") boolean forceAdd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_field = "E573CA3738335F5135D0DDAEEA121E67", hash_generated_field = "9656FC663DC419C2046BE7A145261352")

        int scrappedFromPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "0DBD7DD67030DB53521B4CBB550D5399")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.994 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A0678A9E2024BFE51CD3F973D466AEAF")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(w);
            addTaint(h);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_method = "CB5E57490495E3D022159C4744E426CF", hash_generated_method = "12BE998CA1232185CC1E0013A33AC1A4")
        public  LayoutParams(int w, int h, int viewType) {
            super(w, h);
            this.viewType = viewType;
            addTaint(w);
            addTaint(h);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
    }


    
    class RecycleBin {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "63E890074C591F3B9ADCE0E62142C93F", hash_generated_field = "6E808820BD4FD463611A15BFE36E91A3")

        private RecyclerListener mRecyclerListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "F9B783D9BCAFBFD5783C0A59D5D53319", hash_generated_field = "3638089149F436DC275AC3B59DF7B7C3")

        private int mFirstActivePosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "424ED9F881A5AEDE2DC7FD2B4F700F0E", hash_generated_field = "4E509E23454F116649D54EFD8741D664")

        private View[] mActiveViews = new View[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "D4FAB650ECA27500DEB6EEAEC3D1EB1D", hash_generated_field = "D87C278D091E93A90D61A3043FADF22D")

        private ArrayList<View>[] mScrapViews;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "E54D91FDD7887C0F3B4A327DE6D111A6", hash_generated_field = "F891A96632BBCEAB30959FDFBD22CDE9")

        private int mViewTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_field = "D044D48CB87C97DCEB31A7992E06F2A4", hash_generated_field = "6256C7755218C1B9CBEA2B18392BAB2B")

        private ArrayList<View> mCurrentScrap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.995 -0400", hash_original_method = "2027E38C638AFAF08EBC73DB2999B11D", hash_generated_method = "7D5A437E43263F3120B74E3908529406")
        public void setViewTypeCount(int viewTypeCount) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            } 
            ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
            {
                int i = 0;
                {
                    scrapViews[i] = new ArrayList<View>();
                } 
            } 
            mViewTypeCount = viewTypeCount;
            mCurrentScrap = scrapViews[0];
            mScrapViews = scrapViews;
            
            
                
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.996 -0400", hash_original_method = "84FB41DBF94FAC74E383190ECD19AC3F", hash_generated_method = "4BE4F7A859EF00B0E2B31113EB7385DB")
        public void markChildrenDirty() {
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
                {
                    int i = 0;
                    {
                        scrap.get(i).forceLayout();
                    } 
                } 
            } 
            {
                final int typeCount = mViewTypeCount;
                {
                    int i = 0;
                    {
                        final ArrayList<View> scrap = mScrapViews[i];
                        final int scrapCount = scrap.size();
                        {
                            int j = 0;
                            {
                                scrap.get(j).forceLayout();
                            } 
                        } 
                    } 
                } 
            } 
            
            
                
                
                
                    
                
            
                
                
                    
                    
                    
                        
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.997 -0400", hash_original_method = "511AFE11A00C49C0B36C81F833AD1339", hash_generated_method = "9262277D5F81CC07A8F83F400DD04180")
        public boolean shouldRecycleViewType(int viewType) {
            addTaint(viewType);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98249808 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_98249808;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.997 -0400", hash_original_method = "D3A3C7CFD0DB416C40300347744B44D9", hash_generated_method = "158248798225AA4835D2982A5D57C314")
         void clear() {
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
                {
                    int i = 0;
                    {
                        removeDetachedView(scrap.remove(scrapCount - 1 - i), false);
                    } 
                } 
            } 
            {
                final int typeCount = mViewTypeCount;
                {
                    int i = 0;
                    {
                        final ArrayList<View> scrap = mScrapViews[i];
                        final int scrapCount = scrap.size();
                        {
                            int j = 0;
                            {
                                removeDetachedView(scrap.remove(scrapCount - 1 - j), false);
                            } 
                        } 
                    } 
                } 
            } 
            
            
                
                
                
                    
                
            
                
                
                    
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.998 -0400", hash_original_method = "8EEC6DB7AE7CDFC4B2320C472F7412E6", hash_generated_method = "3F952C9A5B268A55CE1ED2D9058D235D")
         void fillActiveViews(int childCount, int firstActivePosition) {
            {
                mActiveViews = new View[childCount];
            } 
            mFirstActivePosition = firstActivePosition;
            final View[] activeViews = mActiveViews;
            {
                int i = 0;
                {
                    View child = getChildAt(i);
                    AbsListView.LayoutParams lp = (AbsListView.LayoutParams) child.getLayoutParams();
                    {
                        activeViews[i] = child;
                    } 
                } 
            } 
            
            
                
            
            
            
            
                
                
                
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.000 -0400", hash_original_method = "6DDE0EAFBBDE35C2F4BC64D693E74936", hash_generated_method = "06E07503C3DDDFB58268EED896EB89A7")
         View getActiveView(int position) {
            View varB4EAC82CA7396A68D541C85D26508E83_154285438 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_71180813 = null; 
            int index = position - mFirstActivePosition;
            final View[] activeViews = mActiveViews;
            {
                final View match = activeViews[index];
                activeViews[index] = null;
                varB4EAC82CA7396A68D541C85D26508E83_154285438 = match;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_71180813 = null;
            addTaint(position);
            View varA7E53CE21691AB073D9660D615818899_523972070; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_523972070 = varB4EAC82CA7396A68D541C85D26508E83_154285438;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_523972070 = varB4EAC82CA7396A68D541C85D26508E83_71180813;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_523972070.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_523972070;
            
            
            
            
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.001 -0400", hash_original_method = "7C1BB02F0CFB7D7F7BDB0DC42C0788DA", hash_generated_method = "FE896D8F2EE87B8A0417557D05D89FA5")
         View getScrapView(int position) {
            View varB4EAC82CA7396A68D541C85D26508E83_575981748 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_385089540 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_999956170 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_575981748 = retrieveFromScrap(mCurrentScrap, position);
            } 
            {
                int whichScrap = mAdapter.getItemViewType(position);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_385089540 = retrieveFromScrap(mScrapViews[whichScrap], position);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_999956170 = null;
            addTaint(position);
            View varA7E53CE21691AB073D9660D615818899_1456489333; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1456489333 = varB4EAC82CA7396A68D541C85D26508E83_575981748;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1456489333 = varB4EAC82CA7396A68D541C85D26508E83_385089540;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1456489333 = varB4EAC82CA7396A68D541C85D26508E83_999956170;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1456489333.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1456489333;
            
            
                
            
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.001 -0400", hash_original_method = "ED120D0157D66531494A9FD53EAE380E", hash_generated_method = "302B628A8C6AD5C52D8CCAEE14B1EF2B")
         void addScrapView(View scrap, int position) {
            AbsListView.LayoutParams lp = (AbsListView.LayoutParams) scrap.getLayoutParams();
            int viewType = lp.viewType;
            {
                boolean var78318F84F970183913C3A58475F2628A_1901408285 = (!shouldRecycleViewType(viewType));
                {
                    {
                        removeDetachedView(scrap, false);
                    } 
                } 
            } 
            lp.scrappedFromPosition = position;
            {
                scrap.dispatchStartTemporaryDetach();
                mCurrentScrap.add(scrap);
            } 
            {
                scrap.dispatchStartTemporaryDetach();
                mScrapViews[viewType].add(scrap);
            } 
            {
                mRecyclerListener.onMovedToScrapHeap(scrap);
            } 
            addTaint(scrap.getTaint());
            addTaint(position);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.002 -0400", hash_original_method = "3138270AA2660474D2B7E99137A02556", hash_generated_method = "88E2A25B53D2A91117447563C3499A13")
         void scrapActiveViews() {
            final View[] activeViews = mActiveViews;
            final boolean hasListener = mRecyclerListener != null;
            final boolean multipleScraps = mViewTypeCount > 1;
            ArrayList<View> scrapViews = mCurrentScrap;
            final int count = activeViews.length;
            {
                int i = count - 1;
                {
                    final View victim = activeViews[i];
                    {
                        final AbsListView.LayoutParams lp = (AbsListView.LayoutParams) victim.getLayoutParams();
                        int whichScrap = lp.viewType;
                        activeViews[i] = null;
                        {
                            boolean var51E473BD444D9F2F14A7E3EC67387565_1666222583 = (!shouldRecycleViewType(whichScrap));
                            {
                                {
                                    removeDetachedView(victim, false);
                                } 
                            } 
                        } 
                        {
                            scrapViews = mScrapViews[whichScrap];
                        } 
                        victim.dispatchStartTemporaryDetach();
                        lp.scrappedFromPosition = mFirstActivePosition + i;
                        scrapViews.add(victim);
                        {
                            mRecyclerListener.onMovedToScrapHeap(victim);
                        } 
                        {
                            ViewDebug.trace(victim,
                                ViewDebug.RecyclerTraceType.MOVE_FROM_ACTIVE_TO_SCRAP_HEAP,
                                mFirstActivePosition + i, -1);
                        } 
                    } 
                } 
            } 
            pruneScrapViews();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.002 -0400", hash_original_method = "EA58D1FE496277FE2ED85A93396A169A", hash_generated_method = "21F465BFC18E4018A2084FEAA88B661C")
        private void pruneScrapViews() {
            final int maxViews = mActiveViews.length;
            final int viewTypeCount = mViewTypeCount;
            final ArrayList<View>[] scrapViews = mScrapViews;
            {
                int i = 0;
                {
                    final ArrayList<View> scrapPile = scrapViews[i];
                    int size = scrapPile.size();
                    final int extras = size - maxViews;
                    {
                        int j = 0;
                        {
                            removeDetachedView(scrapPile.remove(size--), false);
                        } 
                    } 
                } 
            } 
            
            
            
            
            
                
                
                
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_method = "3FD0A968FC7E2613466435C98B02B7BD", hash_generated_method = "04C47F4AEAA4C9E4ABDF1FAEF8535DCB")
         void reclaimScrapViews(List<View> views) {
            {
                views.addAll(mCurrentScrap);
            } 
            {
                final int viewTypeCount = mViewTypeCount;
                final ArrayList<View>[] scrapViews = mScrapViews;
                {
                    int i = 0;
                    {
                        final ArrayList<View> scrapPile = scrapViews[i];
                        views.addAll(scrapPile);
                    } 
                } 
            } 
            addTaint(views.getTaint());
            
            
                
            
                
                
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_method = "BA10D81754F1A95A0F7C755DD4764D3B", hash_generated_method = "2DE5F80B27B0A8D1E408FE5730F5532E")
         void setCacheColorHint(int color) {
            {
                final ArrayList<View> scrap = mCurrentScrap;
                final int scrapCount = scrap.size();
                {
                    int i = 0;
                    {
                        scrap.get(i).setDrawingCacheBackgroundColor(color);
                    } 
                } 
            } 
            {
                final int typeCount = mViewTypeCount;
                {
                    int i = 0;
                    {
                        final ArrayList<View> scrap = mScrapViews[i];
                        final int scrapCount = scrap.size();
                        {
                            int j = 0;
                            {
                                scrap.get(j).setDrawingCacheBackgroundColor(color);
                            } 
                        } 
                    } 
                } 
            } 
            final View[] activeViews = mActiveViews;
            final int count = activeViews.length;
            {
                int i = 0;
                {
                    final View victim = activeViews[i];
                    {
                        victim.setDrawingCacheBackgroundColor(color);
                    } 
                } 
            } 
            addTaint(color);
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "7D1F549A875745DA59610A279FF98C6A", hash_generated_field = "E0C0A7FB76C7D7FDA0F484B266D28899")

    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "CDE4EB733ED72E76C38D63649282466C", hash_generated_field = "421A8713FDFFB5C0C2BFB5F481F1F2FC")

    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "FE06291F5D87ED7DD9A7BB8F8A0D4CA7", hash_generated_field = "E1312AD0C8B74E42EC3EE6028B1137B6")

    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "B17A4043A5EC6ADB4C25FF7C74A22435", hash_generated_field = "1A65913029CD13477BA64563C54FFD4B")

    static final int TOUCH_MODE_REST = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "693680368AD0BD02276179792348EADA", hash_generated_field = "BF46F64D4AB1CB6C3D3AFC128E88F131")

    static final int TOUCH_MODE_DOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "EC76282AC2561CD363039347CF179E7A", hash_generated_field = "B0569807CBB5B462D97BD49753CF9491")

    static final int TOUCH_MODE_TAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "9F4456FE44624E2AFC940A0465B3A097", hash_generated_field = "A74A1CE702CCC92436644F77B7A85141")

    static final int TOUCH_MODE_DONE_WAITING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "2EEB434A0367FA7DF75FCCCA418ED5A6", hash_generated_field = "A7874F652310534ED2E48713722C968E")

    static final int TOUCH_MODE_SCROLL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "A3F3E68500FFCA6BEC388A593AD55E8D", hash_generated_field = "F745E8763A46E798FA58BA919DF435B6")

    static final int TOUCH_MODE_FLING = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.003 -0400", hash_original_field = "6912EC2E8C428C3E5EF5E2B1D6B96D97", hash_generated_field = "65D38BF1EEECB664AFC79AB59359D9F2")

    static final int TOUCH_MODE_OVERSCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "CFF51771A57BB12D98CF3DBA460C3142", hash_generated_field = "D34672476DCFE73B3F16CA72EB28F066")

    static final int TOUCH_MODE_OVERFLING = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "E29B3AF9E5F6AEE4BA465DAE46CAAC41", hash_generated_field = "307F2C2AACAC6613A6B819B1C46E9BEC")

    static final int LAYOUT_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "4D7A3B72023A68BEFFC3ED5BE8F99A79", hash_generated_field = "8858F00D2FC0F97FA91A4A452FE42A3E")

    static final int LAYOUT_FORCE_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "3B2B6E287126A61BA2B94A3B61A31DEB", hash_generated_field = "C9D08A824763C3FF89EC230BC5EBEA19")

    static final int LAYOUT_SET_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "A2D8EBC46AF970886DB38E17FA3DF022", hash_generated_field = "504C59967FB303DF657FE1D3F305C5D0")

    static final int LAYOUT_FORCE_BOTTOM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "E766E3DD98613EBA901DF572ED840902", hash_generated_field = "F1FBE80C1B23C45E6D01D0BA249DB345")

    static final int LAYOUT_SPECIFIC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "032014FE7C510E0E4B984E3FDB4FFC5E", hash_generated_field = "846A9498FB0ABE0CE7726FC2AB67A29C")

    static final int LAYOUT_SYNC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "EECD2AD33B6C7CC83F468CC38D4F5EBA", hash_generated_field = "227AB8582020535483796213A6EBF50A")

    static final int LAYOUT_MOVE_SELECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "8D280EE6CE7BD607DD9CFD2FEBD4331A", hash_generated_field = "C4D29CBAF23D3100F74985968BC044B6")

    public static final int CHOICE_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "A88E8015B5E7C102D0E4E5C329EE0B0A", hash_generated_field = "8ACFD8F9A2D07A54C73A4603D3C11699")

    public static final int CHOICE_MODE_SINGLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "191E984C863FDD720FB7803FEB1E5AC7", hash_generated_field = "35513B4AE78E0FC364C3E99A7BACE878")

    public static final int CHOICE_MODE_MULTIPLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "55297737093C40EB0446D105E6BC2BF6", hash_generated_field = "8C15E8901DB2548719C9BDD4426BD6C4")

    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "DF83619CF8CE79415D5849EAB6531F4D", hash_generated_field = "5D646DC42A86BD62288C592A5533029A")

    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "D16CE528694D125BEF5912F00C5A2E99", hash_generated_field = "33995481F66B2BB4E0A516C56A797FAE")

    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "155C3D6D52A3AC47DB7F11D2D6ABC0C9", hash_generated_field = "4232090D870E37044033C5A96825AC60")

    private static final int TOUCH_MODE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "25D4A8329815B118CAB37A548D0C8D7A", hash_generated_field = "38D3EC1233BE9FEC7E013AE0CFEBD8DD")

    private static final int TOUCH_MODE_ON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "E986EE0A950AB519A9D78E5F63C4BE79", hash_generated_field = "7D9ADB0F602E4659CCF6E8DDDB3ED6E5")

    private static final int TOUCH_MODE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "A07FD6552E4DC46AC3F39BFD68136463", hash_generated_field = "E7D81FF0F37E8DBAE850DA049B83B27B")

    private static final boolean PROFILE_SCROLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "CB81333E4C8FBCF9DC4472A4127AA8DB", hash_generated_field = "10908BC5D74B320FCDD3C04619CCD594")

    private static final boolean PROFILE_FLINGING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.004 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
}

