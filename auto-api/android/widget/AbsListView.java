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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "FDB445A6FE3D3AE5BF46B0E337AD4937", hash_generated_field = "383DDBE003D416456C310D4158C4CFB9")

    int mChoiceMode = CHOICE_MODE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "3D0732796D8971C4EE44D7D21A3E57FC", hash_generated_field = "48C1F0333DFD0DC72046CFA915BFC8E8")

    ActionMode mChoiceActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "14B80F5AC98F0F6EA047E368DBDFB9E6", hash_generated_field = "8DB318A3968ACAA4E72C29D459103061")

    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "15A65D8079003A56299BBC3EC8F634A7", hash_generated_field = "69D140D043E457BD61D5B9F6552EF517")

    int mCheckedItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "FFDCDF85D0490AC0CCCFF2CB523F8053", hash_generated_field = "CA6CC91745E43EBBCA6C857FDAD05357")

    SparseBooleanArray mCheckStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "9B60E0D0F065913372A6ACFC5498034B", hash_generated_field = "869EB89A549CFEBFB16DD4FED9649B6E")

    LongSparseArray<Integer> mCheckedIdStates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "4E9548BDDA1DC25FD9BD2651109B61A0", hash_generated_field = "D9E7894D012FFAF92CE958370EAAE107")

    int mLayoutMode = LAYOUT_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.287 -0400", hash_original_field = "BA07A3DE43E99CA12488218E7E590AA0", hash_generated_field = "386E575B164CBA38A9F16CB0F74210CE")

    private RemoteViewsAdapter mRemoteAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "8DBD1724A62493247BCB06E14E790DDB", hash_generated_field = "A4A26F367FC0C1227F7A5E61B89ABBBE")

    private boolean mDeferNotifyDataSetChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "3331386BB2D82834F199D617F558D297", hash_generated_field = "A1E757D1ECB75F11B7A5FD22CFD8D6DE")

    boolean mDrawSelectorOnTop = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "D697BABF55DFD739589D0F84316D9938", hash_generated_field = "FF4158F9C935D5CC585FE18F81632212")

    Drawable mSelector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "03D1E6E3F8B7161297631CBC27F2E39C", hash_generated_field = "15C7707915A6B0B74E44A43E1542C958")

    int mSelectorPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "E616CA52B8CBE0A879AD74D361065EF6", hash_generated_field = "C524FC1C3E6AAF765E2CAB633026E31B")

    Rect mSelectorRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "850AAD212EF4F4A7E8993BB802A79E8B", hash_generated_field = "707525CCDB9513E977E0C2123AF49590")

    RecycleBin mRecycler = new RecycleBin();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "EC383219D6D8A4B6B87A786F4327EE03", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "FA8EABBC9D79FB4F912796BE168AD76D", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "F2D6183DA068D77902D36BB38A7570E0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "63EC0412604CE1A7BE02B1C77E43E6CF", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "43539E3842DB97BCC325856D94133A8F", hash_generated_field = "05D43BB1A495A731310553613FE206DD")

    Rect mListPadding = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "D1D6B0DE36366002E2A19031D3776ED0", hash_generated_field = "F34547E4E9C4393B08D5498F65FC370A")

    int mWidthMeasureSpec = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "8A37B3642AE63312BB9AEE8EDA851905", hash_generated_field = "00AF12951227F69DA5FB3783B6D532DB")

    View mScrollUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "B3BBDA53E3217BD8FB4C3525F2C8FB8D", hash_generated_field = "045245010980799FDB6036E67E9F436F")

    View mScrollDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "3AA53ED1199B42ED017A1F3E2400A292", hash_generated_field = "6E445E4EED263A45A094087A50B7126E")

    boolean mCachingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "56FC3C5C26F1649CC65F1FB2A1EA9DC9", hash_generated_field = "0AB9D53170F11322593A4B241676E18D")

    boolean mCachingActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "981700988B7F4FB2FEF9A4D8DDC3B56E", hash_generated_field = "6516B57613A0784EC2DDB500ABA92556")

    int mMotionPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "CB13AD9208BD36E3C502183D21166D8E", hash_generated_field = "9D04282A1BDDC504BC19852147A5D64D")

    int mMotionViewOriginalTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "064676185859A1F3857E03A91BADBB72", hash_generated_field = "2086F63C3164AF1AA06DFC0C51452109")

    int mMotionViewNewTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "5518D15E5E059B7526448CC0900DCECE", hash_generated_field = "E9714F671BCE6666EDE234DD36661DA0")

    int mMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "E24F0E4927BC6420254A5B51253AB150", hash_generated_field = "BAC7C8FFD482868C2E281DB29DBFE06D")

    int mMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "3E0C99B6B345CE34A5565B62F1083D79", hash_generated_field = "7C51C810E963B7D188B47B8F49B7DDE4")

    int mTouchMode = TOUCH_MODE_REST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "048ECB2D11DDC21BDA8C31B82C3211AD", hash_generated_field = "C4455B3957BD1EE48827818491DAA168")

    int mLastY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "7FDF3596AB5C6361CE994F6A8201D88E", hash_generated_field = "1C8B3319825706CAEF653B7569131ADE")

    int mMotionCorrection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "55E8748CF9C4663AD1425AFFC03DE229", hash_generated_field = "6E948CA7630EFB6162DA2EBAA4208363")

    private FlingRunnable mFlingRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "B2332CA85B873A0B0263A4DD84BB9442", hash_generated_field = "3A7EBB83D687A969A9AA75982B56B68B")

    private PositionScroller mPositionScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "4D232D35AB2F2A91FDF0192889384336", hash_generated_field = "77BDF9079A717E33AEBAD612261D859E")

    int mSelectedTop = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "452AAACA6529C6DDC61AC74D560EC80F", hash_generated_field = "A2083A1B78272D6D26A8F8E0BA5E2327")

    boolean mStackFromBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "7FB4BC12E46C9E48428AFBC608C49853", hash_generated_field = "3BD9FEE95F32C4889FDFAAEB81585604")

    boolean mScrollingCacheEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "15797563431B975E4FF5A08BDEC264DA", hash_generated_field = "AB477B88BF820ABA168568369EF3F457")

    boolean mFastScrollEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "0970AE3033B8F8E13936EF3E29D48B2E", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "7E4C7D8A72122A6640DF0AA884C2245D")

    PopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "722CD50A11B36E9DDDD2F9392836F175", hash_generated_field = "E12C98919B28D2782FD5E54CA9C7E663")

    EditText mTextFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.288 -0400", hash_original_field = "16D582D908E13FC506985FFCA54C3849", hash_generated_field = "99B5A44FD56940F18C75CE655B9A1668")

    private boolean mSmoothScrollbarEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "586CD8929678603BADF3EAE99555BE68", hash_generated_field = "10C9AD0517CE8D8A09913559356A8C56")

    private boolean mTextFilterEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "36C832B0627AFDF6338A4E9703CAD999", hash_generated_field = "E5AC0509E741D92E16D3D731D4E96C35")

    private boolean mFiltered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "2D90C7DCE7997683B43703723C5CE198", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "064FE42B46208CBC35991D5A7C24006E", hash_generated_field = "A7BFECA874263BCC8A6464704B9D41D9")

    int mResurrectToPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "C7741A0A622E5D31931CC54BDFAA705B", hash_generated_field = "83C7C32482C7E5A03D695886EA4705D5")

    private ContextMenuInfo mContextMenuInfo = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "B3EE28A70FD254A5A734CAFFFD9F2578", hash_generated_field = "CAABAA47CA52B1F5C0386B90B683E22C")

    int mOverscrollMax;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "50D6DEF2D13611E8D0E41D610E4194EC", hash_generated_field = "CFC250691336B4B39585FE305D07A5A8")

    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "DFFFABFC0994B627F8D236F3905F6919", hash_generated_field = "8AE445FC94FDAEC334CFCA8838E3B70E")

    private boolean mScrollProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "8C5835FEC163B16D102063BC8F2C1248", hash_generated_field = "69AFA437C5D84E7EE29B4FE44E13B088")

    private boolean mFlingProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "D2BBDD4FC0A41CFC280764A4FBDC4D52", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "A914CE4AFB85B902CB007BE88097BB3F", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "956789F3DA470AD87E91A7076E41578B", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "4349FC27F2087C20272E81AADEE9392A", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "9567FFD92CF28040BB18362734DD4369", hash_generated_field = "6BA43AA573D039EEDC72EB768AE06B64")

    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "83D78F1B989F8D62D88496F5EC6FF33F", hash_generated_field = "07CC57CA51A809E0D650A47A9B235FD7")

    private AbsListView.PerformClick mPerformClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "66EF6F4B5EA8F655178F52CF9F60EB91", hash_generated_field = "04EA068A0D45E96537B1140190A89770")

    private Runnable mTouchModeReset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "B59250E72778FF38D50B7661501C8F31", hash_generated_field = "1526254A73CD23B3F5170A2D59CF9F76")

    private int mTranscriptMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "5CB078F03E28D94B5DD6707B7823D2ED", hash_generated_field = "1B8E8F372FC2DAC037EC526954D125A4")

    private int mCacheColorHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "33F961CDAC96AE08DD70684978D9836B", hash_generated_field = "0F85F813AE78D809D6545B656F7C07C7")

    private boolean mIsChildViewEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "DB0605A6A9286B4B3CF497EAF4906666", hash_generated_field = "9D6B53868A098EC5A838EECA6460C254")

    private int mLastScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "4F737BBBBA31571ABB2F993907F88669", hash_generated_field = "FE09333368CBF6471ABE6F31E47E522C")

    private FastScroller mFastScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "5612C2662D978BF558FD7AA146C3290E", hash_generated_field = "8D12711C83D9C6A8E3A8DA9BEC091FCE")

    private boolean mGlobalLayoutListenerAddedFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "D9269244F21F5C31BC4C06A0545F0761", hash_generated_field = "3CCF90D786BE55C250C6CD780F8D19C3")

    private float mDensityScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "300ACBBBBD6F3498749333183FF92783", hash_generated_field = "92752ACB14767626BA8FAB32711AE1A6")

    private InputConnection mDefInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "C2FA9D2B5583B9601295BA7FB05D7F95", hash_generated_field = "048E465914FAB6B457D7426F9FB399BD")

    private InputConnectionWrapper mPublicInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "52C2576C8945A7A83AF5BFD6781D387F", hash_generated_field = "20FDBC6BCA9CEE1B1E479A246AC00217")

    private Runnable mClearScrollingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "ACAB612EAF9F4A8FD31B6DAD171C86FC", hash_generated_field = "32DD593911EBA2DE7D4B7E5052058A82")

    private float mVelocityScale = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "592389443AC9BF2094ADFD76AA22F7AE", hash_generated_field = "B6AD59D19B211FC685CE87567BA82386")

    boolean[] mIsScrap = new boolean[1];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "06749DD524BE381345057152BDEA5C9E", hash_generated_field = "AD55617BE800751F5B53C823CD34BAAE")

    private boolean mPopupHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "3140A319F32CA873045621864B655537")

    int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.289 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "F239C82AEB45C28104273F86A78E6F04")

    int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "445A0C2969A51E83292F7A48A01F98A3", hash_generated_field = "C116882C31FC92381FC21BBC7F61A670")

    private int mFirstPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "0EB1273195375A97262E41F466E36FAF", hash_generated_field = "0D7647AA84F359D8EC76D4A85F02F8A5")

    private int mLastPositionDistanceGuess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "04081D36EE14DF5AD4E0EC7150A5F126", hash_generated_field = "BE4199720272019245F0BE0F2D9EF958")

    private int mDirection = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "39ABF7FC59545839E1E692CD25B4EABA", hash_generated_field = "D5B94B1CE48D1F35D7827F180B43A659")

    private boolean mForceTranscriptScroll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "02F451968FD533EEF7D3944E7669E9A2", hash_generated_field = "13A0640F3C08F553786642C29E645CCC")

    private int mGlowPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "22F2EAAA4524A77ECA0826E1C2B0F476", hash_generated_field = "9E94FEEAC15232AEE61DC08B2319DDAA")

    private int mGlowPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "6256DF52CF0ED50BC6EE01394EF5CB10", hash_generated_field = "740236379897EF8ABD678F65696A25EA")

    private int mLastAccessibilityScrollEventFromIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "81F3A0960933278C26B58CAE75D60E40", hash_generated_field = "9F103C6DB9B3EB29E780CB30462F5591")

    private int mLastAccessibilityScrollEventToIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "0AD971D9895BFC06CF48F77D1B9D890A", hash_generated_field = "4F9C4241EE9024683E4B1C2A3BA5C180")

    boolean mIsAttached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.290 -0400", hash_original_field = "4A894AB51819552684504464AA94B729", hash_generated_field = "9CAD0235527F91F182E61802511E0DCF")

    private int mLastHandledItemCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.320 -0400", hash_original_method = "6A1152DD2F769DBF7D49F3027748695E", hash_generated_method = "3525F74F0E5A79CC5A92A637A26C4E06")
    public  AbsListView(Context context) {
        super(context);
        initAbsListView();
        setVerticalScrollBarEnabled(true);
        TypedArray a;
        a = context.obtainStyledAttributes(R.styleable.View);
        initializeScrollbars(a);
        a.recycle();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initAbsListView();
        //setVerticalScrollBarEnabled(true);
        //TypedArray a = context.obtainStyledAttributes(R.styleable.View);
        //initializeScrollbars(a);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.320 -0400", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "BA92C15F48D9FE5175CCC53C3BA0B19F")
    public  AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.321 -0400", hash_original_method = "A8C0C093ECB8745800A88EB739981F47", hash_generated_method = "5BC1D30444F01681CC6FF0C0A14C58FA")
    public  AbsListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.322 -0400", hash_original_method = "2C481DB3FCB8FF016FB8E3D34F80B2B8", hash_generated_method = "A46123E89BB157CF7C93F7A05B67F91E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.322 -0400", hash_original_method = "3BD104A12D7CF3E01CAF1DA422C489F3", hash_generated_method = "4CBA9234CB0696D0322C8E3B63FAF9C9")
    @Override
    public void setOverScrollMode(int mode) {
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
        addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.328 -0400", hash_original_method = "2831A8F535381CCEFB0BADB6BC86E26A", hash_generated_method = "7803A029C2BD17F51AAEBDD28B2F52E1")
    @Override
    public void setAdapter(ListAdapter adapter) {
        {
            {
                boolean var38CEBABFDDE46DFC47E0A770A36F9546_1679766821 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter.hasStableIds() &&
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
        addTaint(adapter.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.328 -0400", hash_original_method = "5DFF60E6C611266C8D61B940778B8222", hash_generated_method = "531AB77AF4C375EB1F5F2ED726C9ED95")
    public int getCheckedItemCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099833574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099833574;
        // ---------- Original Method ----------
        //return mCheckedItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.329 -0400", hash_original_method = "76DE4C8AF2033C88DA13B2D6D79BE8CC", hash_generated_method = "7648395FA7C25FC3C763C832EC880299")
    public boolean isItemChecked(int position) {
        {
            boolean var0D150F0C81FAF2A662314396EC0C31E7_1097848764 = (mCheckStates.get(position));
        } //End block
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96298900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96298900;
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null) {
            //return mCheckStates.get(position);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.329 -0400", hash_original_method = "40A1040C0B9BA1980C4FD0733FBB2F2E", hash_generated_method = "074D5EB4D01EDE2B14700BBA9DB4056C")
    public int getCheckedItemPosition() {
        {
            boolean varA1B9DE9EDBC04ECFD56B33C2A5BF45B0_252957109 = (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1);
            {
                int varD7BABAE4F11D1568725A045F030C9B34_1672359356 = (mCheckStates.keyAt(0));
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189446061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189446061;
        // ---------- Original Method ----------
        //if (mChoiceMode == CHOICE_MODE_SINGLE && mCheckStates != null && mCheckStates.size() == 1) {
            //return mCheckStates.keyAt(0);
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.330 -0400", hash_original_method = "DD9B0503EDD82432AE0B7C0599D4B447", hash_generated_method = "93A048CD96A3F81157EC7C601E88DA3A")
    public SparseBooleanArray getCheckedItemPositions() {
        SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_1095097763 = null; //Variable for return #1
        SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_2053280531 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1095097763 = mCheckStates;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2053280531 = null;
        SparseBooleanArray varA7E53CE21691AB073D9660D615818899_1330635896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1330635896 = varB4EAC82CA7396A68D541C85D26508E83_1095097763;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1330635896 = varB4EAC82CA7396A68D541C85D26508E83_2053280531;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1330635896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1330635896;
        // ---------- Original Method ----------
        //if (mChoiceMode != CHOICE_MODE_NONE) {
            //return mCheckStates;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.331 -0400", hash_original_method = "C085907095DB552ED74D8B304576006A", hash_generated_method = "D9681C02D7BD4B2D9D279311A3335508")
    public long[] getCheckedItemIds() {
        {
            long[] var674FEB06102F8AD50D6DDBD530249D3A_850179262 = (new long[0]);
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
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_2105181814 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_2105181814;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.331 -0400", hash_original_method = "A5D48B0328BC1A467504F22AFA94E40C", hash_generated_method = "B4A93F25373379F44D7CE7CEDE8E78AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.337 -0400", hash_original_method = "43E07392067BD1BC5F99F3882FA40E88", hash_generated_method = "316AA51E70EE3A61AFB74760CEF917D2")
    public void setItemChecked(int position, boolean value) {
        {
            mChoiceActionMode = startActionMode(mMultiChoiceModeCallback);
        } //End block
        {
            boolean oldValue;
            oldValue = mCheckStates.get(position);
            mCheckStates.put(position, value);
            {
                boolean varDF5D6CF73909C5793DEDFF57AC70B3A9_906212833 = (mCheckedIdStates != null && mAdapter.hasStableIds());
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
                boolean varE3E83AB27085DF4D75DE8758E514DAA9_4946651 = (value || isItemChecked(position));
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
                boolean var425458AA9F83015DB14C2404DEE4E159_1001718483 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
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
        addTaint(position);
        addTaint(value);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.339 -0400", hash_original_method = "9A0165787640E5C3A3D1AC60426CC2CC", hash_generated_method = "99D1C264D8401031C33A060FFA5D2821")
    @Override
    public boolean performItemClick(View view, int position, long id) {
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
                    boolean varFFF95FDDB84D487F1FD71AE5B4D04DFA_1188057546 = (mCheckedIdStates != null && mAdapter.hasStableIds());
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
                        boolean varD30D994107B77CF4004B51C1F80A4DE7_951952702 = (mCheckedIdStates != null && mAdapter.hasStableIds());
                        {
                            mCheckedIdStates.clear();
                            mCheckedIdStates.put(mAdapter.getItemId(position), position);
                        } //End block
                    } //End collapsed parenthetic
                    mCheckedItemCount = 1;
                } //End block
                {
                    boolean var6ACBF7B7E15B02DF34CBCD44F94045DE_977656730 = (mCheckStates.size() == 0 || !mCheckStates.valueAt(0));
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
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117156850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117156850;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.339 -0400", hash_original_method = "8E2D8E05EEC3041F2430430C00E99F2E", hash_generated_method = "3E273784EA6CA02C93DD6714ADA18315")
    public int getChoiceMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723147158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723147158;
        // ---------- Original Method ----------
        //return mChoiceMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.340 -0400", hash_original_method = "31284EBF9693FA29D08DAAB1651BB216", hash_generated_method = "E67804FCB130213D172595C60421A9AB")
    public void setChoiceMode(int choiceMode) {
        mChoiceMode = choiceMode;
        {
            mChoiceActionMode.finish();
            mChoiceActionMode = null;
        } //End block
        {
            {
                mCheckStates = new SparseBooleanArray();
            } //End block
            {
                boolean var2BF65510232B6C8CFF89CFE72E6D8ACB_2037068648 = (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.340 -0400", hash_original_method = "AB030C487B8A76B7A3B990C85D8D5284", hash_generated_method = "03CDA87A96CFE3F2496718C37939D57F")
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener) {
        {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        } //End block
        mMultiChoiceModeCallback.setWrapped(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mMultiChoiceModeCallback == null) {
            //mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        //}
        //mMultiChoiceModeCallback.setWrapped(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.341 -0400", hash_original_method = "34BF563ABF29C3DFDECFCC44CD785338", hash_generated_method = "0AD0349FA86683BBA89B2E210418C4B1")
    private boolean contentFits() {
        int childCount;
        childCount = getChildCount();
        boolean varB916502A2FFF50967FBE5280BE01D3D7_733854709 = (getChildAt(0).getTop() >= mListPadding.top &&
                getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534985621 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534985621;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount == 0) return true;
        //if (childCount != mItemCount) return false;
        //return getChildAt(0).getTop() >= mListPadding.top &&
                //getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.346 -0400", hash_original_method = "595588F5399A1D343B61A8313A8ACA6F", hash_generated_method = "E1754E1D20827C2E7FB18D71C197611F")
    public void setFastScrollEnabled(boolean enabled) {
        mFastScrollEnabled = enabled;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.347 -0400", hash_original_method = "76A971EB75129863E10E67DBAAA59745", hash_generated_method = "866060DEFC16C25E08080F85A7696E7E")
    public void setFastScrollAlwaysVisible(boolean alwaysShow) {
        {
            setFastScrollEnabled(true);
        } //End block
        {
            mFastScroller.setAlwaysShow(alwaysShow);
        } //End block
        computeOpaqueFlags();
        recomputePadding();
        addTaint(alwaysShow);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.347 -0400", hash_original_method = "B8FB7506E98011F45E37A448BFD532A7", hash_generated_method = "37049675D636FC2C20D1D7A12E451E33")
    public boolean isFastScrollAlwaysVisible() {
        boolean var26B2F46AB3144EF80214E1227EB2F480_1666418548 = (mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767067763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767067763;
        // ---------- Original Method ----------
        //return mFastScrollEnabled && mFastScroller.isAlwaysShowEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.347 -0400", hash_original_method = "7B9EF1235ED171F1370B12BB905DC3C9", hash_generated_method = "5EFA41036CFFE6644489321E92749FA9")
    @Override
    public int getVerticalScrollbarWidth() {
        {
            boolean var26909BC69BA2F3E69FEBFE306B4E5DAD_905280298 = (isFastScrollAlwaysVisible());
            {
                int varFB51A5362339E3615BCF0229E08CB917_455655503 = (Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth()));
            } //End block
        } //End collapsed parenthetic
        int var08FF7A4CA397B890F67D51D77687712B_518111864 = (super.getVerticalScrollbarWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133196577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133196577;
        // ---------- Original Method ----------
        //if (isFastScrollAlwaysVisible()) {
            //return Math.max(super.getVerticalScrollbarWidth(), mFastScroller.getWidth());
        //}
        //return super.getVerticalScrollbarWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.348 -0400", hash_original_method = "0BC112ABD3166320C6B43E3AFC3B6D61", hash_generated_method = "D0F9003677BD38C42CD0DA75614A9E5C")
    @ViewDebug.ExportedProperty
    public boolean isFastScrollEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276245511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276245511;
        // ---------- Original Method ----------
        //return mFastScrollEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.348 -0400", hash_original_method = "A675D7279FF2D5DA4484C8480BA7553A", hash_generated_method = "A1793C19ED7CECF3927AEF4BCE90B044")
    @Override
    public void setVerticalScrollbarPosition(int position) {
        super.setVerticalScrollbarPosition(position);
        {
            mFastScroller.setScrollbarPosition(position);
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //super.setVerticalScrollbarPosition(position);
        //if (mFastScroller != null) {
            //mFastScroller.setScrollbarPosition(position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.348 -0400", hash_original_method = "940CDB7D64F97F8EC4A4E1C87858DFBA", hash_generated_method = "C02E52D6114AD71E64FAE32DE31F37ED")
    @Override
    protected boolean isVerticalScrollBarHidden() {
        boolean varEE7670B7B7BC0CBAC7B3A19E6E35E88F_1167140441 = (mFastScroller != null && mFastScroller.isVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827582706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827582706;
        // ---------- Original Method ----------
        //return mFastScroller != null && mFastScroller.isVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.349 -0400", hash_original_method = "1698DB675ADDAA62665F2F04BB6F72CB", hash_generated_method = "D64E9DF10E031F8E4DDF09544BB4BA0A")
    public void setSmoothScrollbarEnabled(boolean enabled) {
        mSmoothScrollbarEnabled = enabled;
        // ---------- Original Method ----------
        //mSmoothScrollbarEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.349 -0400", hash_original_method = "475C5FFCF382FD26204BCB75E2B77D7D", hash_generated_method = "0673E5FA8F77EEB882E130C302A5FF10")
    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339981969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339981969;
        // ---------- Original Method ----------
        //return mSmoothScrollbarEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.349 -0400", hash_original_method = "210B7E1D385EBACE9AEF47F53212EE62", hash_generated_method = "7891AA0536D9A3BB23A5AA51B1644A4C")
    public void setOnScrollListener(OnScrollListener l) {
        mOnScrollListener = l;
        invokeOnItemScrollListener();
        // ---------- Original Method ----------
        //mOnScrollListener = l;
        //invokeOnItemScrollListener();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.354 -0400", hash_original_method = "BA8530F9EF3261CEDA66BF584A9CCD3E", hash_generated_method = "A9B81DB570E7184E3C81965E4D493FD7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.355 -0400", hash_original_method = "B64F2C3012E6A3D7EFE9332FD2B83485", hash_generated_method = "613F2C549B244EE393B2DD9FA078F7A9")
    @Override
    public void sendAccessibilityEvent(int eventType) {
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
        addTaint(eventType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.355 -0400", hash_original_method = "9414D347741A5DD8E57796525BCE5898", hash_generated_method = "E4F511B24B251A0340DA11AB7F2CC9B7")
    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688432497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688432497;
        // ---------- Original Method ----------
        //return mScrollingCacheEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.355 -0400", hash_original_method = "150D6943577E82022A370D7488992E67", hash_generated_method = "22BFA28B65E057BC19AD1664B0D74CD8")
    public void setScrollingCacheEnabled(boolean enabled) {
        {
            clearScrollingCache();
        } //End block
        mScrollingCacheEnabled = enabled;
        // ---------- Original Method ----------
        //if (mScrollingCacheEnabled && !enabled) {
            //clearScrollingCache();
        //}
        //mScrollingCacheEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.356 -0400", hash_original_method = "8476047A74E8C2792EEAD35F27B63501", hash_generated_method = "264A2BADB5D79F4C262375A12D707EBE")
    public void setTextFilterEnabled(boolean textFilterEnabled) {
        mTextFilterEnabled = textFilterEnabled;
        // ---------- Original Method ----------
        //mTextFilterEnabled = textFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.356 -0400", hash_original_method = "D536B611E01E5CFE1F666765CAB03290", hash_generated_method = "7AEAEEC23920259E524E7DAADF6E33CB")
    @ViewDebug.ExportedProperty
    public boolean isTextFilterEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1069309872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1069309872;
        // ---------- Original Method ----------
        //return mTextFilterEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.356 -0400", hash_original_method = "1C8D0A5FE9343035731EC5D6D9384599", hash_generated_method = "3F8846B6D05DE392904794C97694BA93")
    @Override
    public void getFocusedRect(Rect r) {
        View view;
        view = getSelectedView();
        {
            boolean varA78CB7AA6BC92F805E05829844E1ECE3_911090185 = (view != null && view.getParent() == this);
            {
                view.getFocusedRect(r);
                offsetDescendantRectToMyCoords(view, r);
            } //End block
            {
                super.getFocusedRect(r);
            } //End block
        } //End collapsed parenthetic
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //View view = getSelectedView();
        //if (view != null && view.getParent() == this) {
            //view.getFocusedRect(r);
            //offsetDescendantRectToMyCoords(view, r);
        //} else {
            //super.getFocusedRect(r);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.357 -0400", hash_original_method = "9E8C7705C9D325A7FB79BC94A2C5E742", hash_generated_method = "5E8864341AF6CB275CB3012A78EAE0CA")
    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(
                com.android.internal.R.drawable.list_selector_background));
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(
                //com.android.internal.R.drawable.list_selector_background));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.357 -0400", hash_original_method = "991365D9D991378A506E868734A0B0D2", hash_generated_method = "F06E1F3DBA2CDE2D485E37D7B33AF6A1")
    @ViewDebug.ExportedProperty
    public boolean isStackFromBottom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605529353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605529353;
        // ---------- Original Method ----------
        //return mStackFromBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.358 -0400", hash_original_method = "CFFEAD7E7BECCE023678F7841887953F", hash_generated_method = "588D3A603EDEFCB89D22D75113F6AE73")
    public void setStackFromBottom(boolean stackFromBottom) {
        {
            mStackFromBottom = stackFromBottom;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (mStackFromBottom != stackFromBottom) {
            //mStackFromBottom = stackFromBottom;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.358 -0400", hash_original_method = "DBB2E77784FB40B043F5BACE416B5D38", hash_generated_method = "82DC56EC62CE4776A40C38C8B39F9732")
     void requestLayoutIfNecessary() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1182740012 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.360 -0400", hash_original_method = "550511192552500388A3039280244936", hash_generated_method = "7FAA1B89B544DD435D454BF9C984C9F5")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_224135144 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_224135144 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_224135144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224135144;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.367 -0400", hash_original_method = "43BE5C5AD27C719005EFC4A46B8486A7", hash_generated_method = "33C1BF46B05FF5797685BEDF61E3E762")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.368 -0400", hash_original_method = "42E27AF1CE674CD4135EEA22852A217B", hash_generated_method = "7DEA492442384451600B6EF477317CE1")
    private boolean acceptFilter() {
        boolean varA2D4C9A63B028E8345B4157A680073A2_1240683631 = (mTextFilterEnabled && getAdapter() instanceof Filterable &&
                ((Filterable) getAdapter()).getFilter() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975013775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975013775;
        // ---------- Original Method ----------
        //return mTextFilterEnabled && getAdapter() instanceof Filterable &&
                //((Filterable) getAdapter()).getFilter() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.368 -0400", hash_original_method = "A8CCB94844A67C45EFD075D798DD3AF0", hash_generated_method = "C5315E43DE4CDDF04523773EE987490E")
    public void setFilterText(String filterText) {
        {
            boolean var190C1EE91DE344514DA2209FAF0C3D82_1655566803 = (mTextFilterEnabled && !TextUtils.isEmpty(filterText));
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
        addTaint(filterText.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.379 -0400", hash_original_method = "1C9B36BFA6AA511A6999C19189070FD4", hash_generated_method = "6A78B52C54D3583E5184D6BD31DAD50C")
    public CharSequence getTextFilter() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1496219174 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_829345871 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1496219174 = mTextFilter.getText();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_829345871 = null;
        CharSequence varA7E53CE21691AB073D9660D615818899_2004068094; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004068094 = varB4EAC82CA7396A68D541C85D26508E83_1496219174;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004068094 = varB4EAC82CA7396A68D541C85D26508E83_829345871;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004068094.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004068094;
        // ---------- Original Method ----------
        //if (mTextFilterEnabled && mTextFilter != null) {
            //return mTextFilter.getText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.385 -0400", hash_original_method = "0C025ACF6797C1095DC28C93A47B3E04", hash_generated_method = "29653D6EC14F135B63DDBA72C85F8C83")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        {
            boolean var8EB9364CA747E30AAC5C9F3175F02645_241220592 = (gainFocus && mSelectedPosition < 0 && !isInTouchMode());
            {
                {
                    mDataChanged = true;
                    mOldItemCount = mItemCount;
                    mItemCount = mAdapter.getCount();
                } //End block
                resurrectSelection();
            } //End block
        } //End collapsed parenthetic
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.386 -0400", hash_original_method = "B180005EA1177A66433DC47F81A1B223", hash_generated_method = "7FA434FB1BD0F76EE21405415ADD4E7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.387 -0400", hash_original_method = "8DD5C430A497277A13BB6B282542179B", hash_generated_method = "7581B754A737045C6DFD1C880926F30E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.387 -0400", hash_original_method = "EAD3946FC18204D61E6D52ABAEC42671", hash_generated_method = "42D1A8DF0BCF784E4353F6D803F300FC")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003740490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003740490;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.388 -0400", hash_original_method = "B342EEB15F9AC09DD167764D56209B72", hash_generated_method = "F958F87DEFC081ED4A83AA73E4B688BF")
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
                    int var813D884A4C0D547484060C54181A041A_1062610792 = (Math.max(firstPosition * 100 - (top * 100) / height +
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224659330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224659330;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.396 -0400", hash_original_method = "4324030F56A09BCB8354791FE2A22081", hash_generated_method = "4CB4AE30E3C971DF76F3F7772A461541")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636462416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636462416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.396 -0400", hash_original_method = "6B45AE0F220A2E6F043181E50094F343", hash_generated_method = "C2202A52476579EB9879BBA4087AFE81")
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
        float var546ADE640B6EDFBC8A086EF31347E768_1230044579 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1230044579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.397 -0400", hash_original_method = "7783F8E763936950C57ED5516E6F7E94", hash_generated_method = "F83F7588EFB6B77BE48D6D02313F21D2")
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
        float var546ADE640B6EDFBC8A086EF31347E768_1127355434 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1127355434;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.409 -0400", hash_original_method = "7C6C2B65B4381736E49DE73CCD130327", hash_generated_method = "B0DA4C968DC9E41FF8EAB062E5A98D15")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.410 -0400", hash_original_method = "46F44099FEFDB133D6B976408934CAC6", hash_generated_method = "8B4BB1B8759328A673A77D78166C2888")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(changed);
        addTaint(l);
        addTaint(r);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.411 -0400", hash_original_method = "748FD791AA503E7E1D859CFD661EA755", hash_generated_method = "344A183A8AA7508DCB7F645EF1DA2D84")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed;
        changed = super.setFrame(left, top, right, bottom);
        {
            boolean visible;
            visible = getWindowVisibility() == View.VISIBLE;
            {
                boolean varFBED1B944623C6BCA164EC2723F71804_635154667 = (mFiltered && visible && mPopup != null && mPopup.isShowing());
                {
                    positionPopup();
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513267608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513267608;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.411 -0400", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "7C7456ED8D2FB5B664E2AB60CCD22125")
    protected void layoutChildren() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.422 -0400", hash_original_method = "180044681435C2C9D1AB0FD8756137A4", hash_generated_method = "69053FE68E1954EF10E78ED84CC50316")
     void updateScrollIndicators() {
        {
            boolean canScrollUp;
            canScrollUp = mFirstPosition > 0;
            {
                {
                    boolean var4813CB3BCCB7AE7282F404FB5F98BC43_796766364 = (getChildCount() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.422 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "0DE2E52AAF5E6FD8CEA0EB1DCEEF2FF6")
    @Override
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_58846191 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1830031096 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_58846191 = getChildAt(mSelectedPosition - mFirstPosition);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1830031096 = null;
        } //End block
        View varA7E53CE21691AB073D9660D615818899_365880429; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_365880429 = varB4EAC82CA7396A68D541C85D26508E83_58846191;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_365880429 = varB4EAC82CA7396A68D541C85D26508E83_1830031096;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_365880429.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_365880429;
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition >= 0) {
            //return getChildAt(mSelectedPosition - mFirstPosition);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.423 -0400", hash_original_method = "3B697574C47153B82BC97C5C46624F2C", hash_generated_method = "A4DBCE7F16E1E68F2DCEF2F354061675")
    public int getListPaddingTop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078476528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078476528;
        // ---------- Original Method ----------
        //return mListPadding.top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.423 -0400", hash_original_method = "CEE980D8545C78DFB596AE8650DBF797", hash_generated_method = "00798A7B155ABAC387F56B35FA196C14")
    public int getListPaddingBottom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098102612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098102612;
        // ---------- Original Method ----------
        //return mListPadding.bottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.423 -0400", hash_original_method = "C8B939C15FBE7011BDF7672B6F924B56", hash_generated_method = "2078693F08001895F825FA81FA3B5653")
    public int getListPaddingLeft() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16280851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16280851;
        // ---------- Original Method ----------
        //return mListPadding.left;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.434 -0400", hash_original_method = "1F1F9379D690EBB0F58C075805935B4C", hash_generated_method = "7B8335A89CA51E3652AAF58F56E59A5B")
    public int getListPaddingRight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227806240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227806240;
        // ---------- Original Method ----------
        //return mListPadding.right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.437 -0400", hash_original_method = "F1A94AACBC76DA4834C170841A9D4C37", hash_generated_method = "EBC6956CD356917F33F698270CD1E233")
     View obtainView(int position, boolean[] isScrap) {
        View varB4EAC82CA7396A68D541C85D26508E83_1614769267 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1614769267 = child;
        addTaint(position);
        addTaint(isScrap[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1614769267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1614769267;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.439 -0400", hash_original_method = "B068259C5BBCB2A7501108708CD5A4C4", hash_generated_method = "D3AF870E0A4703225242851C31E97AFB")
     void positionSelector(int position, View sel) {
        {
            mSelectorPosition = position;
        } //End block
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
            boolean varFB59463D8D8AB76E1E484CE2BBC5519D_681390856 = (sel.isEnabled() != isChildViewEnabled);
            {
                mIsChildViewEnabled = !isChildViewEnabled;
                {
                    boolean var9ACEB0A565E658741B99EDC3F95405AB_1345609590 = (getSelectedItemPosition() != INVALID_POSITION);
                    {
                        refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(sel.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.440 -0400", hash_original_method = "9958A79674A9EAF808CC1CD0A2974C67", hash_generated_method = "3CBE6806D0404AB507608A934337F43C")
    private void positionSelector(int l, int t, int r, int b) {
        mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                + mSelectionRightPadding, b + mSelectionBottomPadding);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //mSelectorRect.set(l - mSelectionLeftPadding, t - mSelectionTopPadding, r
                //+ mSelectionRightPadding, b + mSelectionBottomPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.445 -0400", hash_original_method = "EB6A446E7A5D607DB4BF2796F54D03FA", hash_generated_method = "D194735050C472A41535BC3DD42D2A74")
    @Override
    protected void dispatchDraw(Canvas canvas) {
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.449 -0400", hash_original_method = "E1295B3F3CD2AED842AA5266ED41ED1A", hash_generated_method = "29E782A0DB22BFFEFBF5D327F4A23E69")
    @Override
    protected boolean isPaddingOffsetRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344300811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344300811;
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) != CLIP_TO_PADDING_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.449 -0400", hash_original_method = "C31A372B11969057E398197BABCC2FB9", hash_generated_method = "242C6AADCE3352CB72B75E3014926997")
    @Override
    protected int getLeftPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928758378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928758378;
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.450 -0400", hash_original_method = "F0F07013F187EA8DBDDCF030EEADD0A0", hash_generated_method = "F5FDDAEE3F309730E2899B953F0BB6EE")
    @Override
    protected int getTopPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33773345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33773345;
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.450 -0400", hash_original_method = "D64BFD9DD2CC0187FA2BCDAC4D5056C0", hash_generated_method = "6BB206CA6D86B51E70A06F24748BA926")
    @Override
    protected int getRightPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546784571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546784571;
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.450 -0400", hash_original_method = "A76EA354621A97D061AF35F7F0E022AA", hash_generated_method = "477A48FA9D18C96A8397396E6E6975F2")
    @Override
    protected int getBottomPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147501369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147501369;
        // ---------- Original Method ----------
        //return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.465 -0400", hash_original_method = "7222D25647FA66D7134D6564AB03A11A", hash_generated_method = "325BB0EA3ABB0F3C289E28CFAAD963BD")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1130333038 = (getChildCount() > 0);
            {
                mDataChanged = true;
                rememberSyncState();
            } //End block
        } //End collapsed parenthetic
        {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        } //End block
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //if (getChildCount() > 0) {
            //mDataChanged = true;
            //rememberSyncState();
        //}
        //if (mFastScroller != null) {
            //mFastScroller.onSizeChanged(w, h, oldw, oldh);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.465 -0400", hash_original_method = "E2B9A99414FF2EE03BB0A755AC5DBB16", hash_generated_method = "532D0DFC40ADD02721567C4F059B93E6")
     boolean touchModeDrawsInPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864688954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864688954;
        // ---------- Original Method ----------
        //switch (mTouchMode) {
        //case TOUCH_MODE_TAP:
        //case TOUCH_MODE_DONE_WAITING:
            //return true;
        //default:
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.466 -0400", hash_original_method = "FA7D742C09854F2E7F00273E8807D507", hash_generated_method = "147690D19292DC178466AD06C15326F6")
     boolean shouldShowSelector() {
        boolean var4246A524C7FBFC973820D2F78D9E8F98_1388988039 = ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790497963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790497963;
        // ---------- Original Method ----------
        //return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.466 -0400", hash_original_method = "1653A38E1AF50A830D0C8CACED5D71E9", hash_generated_method = "51D2696FA690FEBCEACE32F53122E339")
    private void drawSelector(Canvas canvas) {
        {
            boolean var101389AC9853324A8F2F4AC467A8FE5D_1179996155 = (!mSelectorRect.isEmpty());
            {
                Drawable selector;
                selector = mSelector;
                selector.setBounds(mSelectorRect);
                selector.draw(canvas);
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if (!mSelectorRect.isEmpty()) {
            //final Drawable selector = mSelector;
            //selector.setBounds(mSelectorRect);
            //selector.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.486 -0400", hash_original_method = "E224CB1DBFEAEB35D4CBDCEA1ACB7063", hash_generated_method = "C23273762128D8B0257C96DB47B6A628")
    public void setDrawSelectorOnTop(boolean onTop) {
        mDrawSelectorOnTop = onTop;
        // ---------- Original Method ----------
        //mDrawSelectorOnTop = onTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.486 -0400", hash_original_method = "4BF5D497DEE1C8362CD452A22AD6FA64", hash_generated_method = "80C2C33A0EB46039BD9348F47A7188EF")
    public void setSelector(int resID) {
        setSelector(getResources().getDrawable(resID));
        addTaint(resID);
        // ---------- Original Method ----------
        //setSelector(getResources().getDrawable(resID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.487 -0400", hash_original_method = "AF217D83F5B526992017BCFB165071E1", hash_generated_method = "4D0D8E845A476371DC8109AE70633835")
    public void setSelector(Drawable sel) {
        {
            mSelector.setCallback(null);
            unscheduleDrawable(mSelector);
        } //End block
        mSelector = sel;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.491 -0400", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "2A494350564713E257E3E994FDD46CEF")
    public Drawable getSelector() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_540795187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_540795187 = mSelector;
        varB4EAC82CA7396A68D541C85D26508E83_540795187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_540795187;
        // ---------- Original Method ----------
        //return mSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.492 -0400", hash_original_method = "2F7C78E24D2DA521609D152C286646B5", hash_generated_method = "7158FE92FCDBCA97E395C1E3CC9CF2FB")
     void keyPressed() {
        {
            boolean varDBE5D4BF2CCFB471B80269545EAA1B3B_152037747 = (!isEnabled() || !isClickable());
        } //End collapsed parenthetic
        Drawable selector;
        selector = mSelector;
        Rect selectorRect;
        selectorRect = mSelectorRect;
        {
            boolean var07FA5EC4F6C5A1F1386E6BB4E68E466A_1999188661 = (selector != null && (isFocused() || touchModeDrawsInPressedState())
                && !selectorRect.isEmpty());
            {
                View v;
                v = getChildAt(mSelectedPosition - mFirstPosition);
                {
                    {
                        boolean varF2E1D044768D3B14172E86DA91C28BD1_354776705 = (v.hasFocusable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.493 -0400", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "21A7C287E27C4D3CE4CA7765A0F74054")
    public void setScrollIndicators(View up, View down) {
        mScrollUp = up;
        mScrollDown = down;
        // ---------- Original Method ----------
        //mScrollUp = up;
        //mScrollDown = down;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.493 -0400", hash_original_method = "80EC646A43ECE5B1A4600CE8EDDA24B3", hash_generated_method = "813933AD4AFDFE98B3097A300C12C1AD")
     void updateSelectorState() {
        {
            {
                boolean var1EC35265200A237347BA89EC9F7CAA85_831378138 = (shouldShowSelector());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.504 -0400", hash_original_method = "5700D7A450170541F2788B92612441B3", hash_generated_method = "A585E16DC9FBE9BA5368D986ED938050")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //updateSelectorState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.505 -0400", hash_original_method = "1ED981B25374988410BBF6BB9A2499BB", hash_generated_method = "AA700FF2EFFE05068DE82329E7493AF0")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_148285746 = (super.onCreateDrawableState(extraSpace));
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
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_375843694 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_375843694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.505 -0400", hash_original_method = "A6B05685C2044FBFF5332C34549C9055", hash_generated_method = "88B4BB758BC500390A448A82FAA7149F")
    @Override
    public boolean verifyDrawable(Drawable dr) {
        boolean var31983995A7CC0B4FFFDA846AE3697AC5_1790942866 = (mSelector == dr || super.verifyDrawable(dr));
        addTaint(dr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456337391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456337391;
        // ---------- Original Method ----------
        //return mSelector == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.509 -0400", hash_original_method = "7ED40C7CE5B566B3E07F33E9D37CCA58", hash_generated_method = "EEC30B3A9E5A1EA4E67E19E804024279")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mSelector.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mSelector != null) mSelector.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.510 -0400", hash_original_method = "0EB97D149DFA0037A8214EEEE413FBAC", hash_generated_method = "96CF11EECD89E3A25F63B38C4749E0E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.511 -0400", hash_original_method = "91FA19273AD6EF1E2E7A8FCA605608DC", hash_generated_method = "02FA9D139996AD9D4D9864B60BEF8554")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.525 -0400", hash_original_method = "F46E1D5E69E9A7961CEAA1CC31FCC74A", hash_generated_method = "6B263B7AB29235A106C1F40B8270DE8C")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowFocusChanged(hasWindowFocus);
        int touchMode;
        boolean var49D8D6F90114322BA24D8547EE3F7B5B_164827767 = (isInTouchMode());
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
        addTaint(hasWindowFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.526 -0400", hash_original_method = "5DA1B21EB8CB635B0040E7A9E537D496", hash_generated_method = "FE7D5297299ED9E5EA7F9AD43BDB265D")
     ContextMenuInfo createContextMenuInfo(View view, int position, long id) {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_1365245768 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1365245768 = new AdapterContextMenuInfo(view, position, id);
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1365245768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1365245768;
        // ---------- Original Method ----------
        //return new AdapterContextMenuInfo(view, position, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.526 -0400", hash_original_method = "5D95BDE73AAD1EC9BDE83FD3189DFC34", hash_generated_method = "5004EDEE7F5377B92FB4E9206F249E1F")
     boolean performLongPress(final View child,
            final int longPressPosition, final long longPressId) {
        {
            {
                boolean var00E98D05004FD0330F18AA64B0748865_589566476 = (mChoiceActionMode == null &&
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966267355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966267355;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.534 -0400", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "5350E7552D69D8BE0186083FAEE5E868")
    @Override
    protected ContextMenuInfo getContextMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_2041957682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2041957682 = mContextMenuInfo;
        varB4EAC82CA7396A68D541C85D26508E83_2041957682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041957682;
        // ---------- Original Method ----------
        //return mContextMenuInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.538 -0400", hash_original_method = "720F76E8125C4C6521A83756BA0DD98B", hash_generated_method = "EF004E21C72D6558C66BF75F73A10CC2")
    @Override
    public boolean showContextMenu(float x, float y, int metaState) {
        int position;
        position = pointToPosition((int)x, (int)y);
        {
            long id;
            id = mAdapter.getItemId(position);
            View child;
            child = getChildAt(position - mFirstPosition);
            {
                mContextMenuInfo = createContextMenuInfo(child, position, id);
                boolean var8897B192E808AB3EDB293923745D2D74_1388216112 = (super.showContextMenuForChild(AbsListView.this));
            } //End block
        } //End block
        boolean varE458CA81039B0A7729D96AA8ED00D0B8_39551084 = (super.showContextMenu(x, y, metaState));
        addTaint(x);
        addTaint(y);
        addTaint(metaState);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520355917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520355917;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.544 -0400", hash_original_method = "13B8C0CF7E224AA8E52D13CB23050F48", hash_generated_method = "B2E2B949FC577AF5D1BA367E8373B1E5")
    @Override
    public boolean showContextMenuForChild(View originalView) {
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
        addTaint(originalView.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222894401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222894401;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.548 -0400", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "DF4884D2D716E5AD5B91A09F14458E90")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590738069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590738069;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.570 -0400", hash_original_method = "DD8448F1B5F23CC0AD3E4D53FFC7D294", hash_generated_method = "89F810E06C1C31E290A4C956C66FDC02")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_574593015 = (!isEnabled());
        } //End collapsed parenthetic
        //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
        {
            boolean varD23167BEA6670E541F842804D07343DD_695629078 = (isClickable() && isPressed() &&
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
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1241295611 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566232874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_566232874;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.570 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "083281D026E9BBF12BAB21E0084CD5D6")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.571 -0400", hash_original_method = "C5D265B49C06947929C542FAD6DD4910", hash_generated_method = "6562B8E4209D80B7C4A4DDECA6B887E4")
    public int pointToPosition(int x, int y) {
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
                    boolean var02E23769C3E76AF1DC2C1CE956107022_886258689 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_1462447408 = (frame.contains(x, y));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153962575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153962575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.572 -0400", hash_original_method = "0CE0E010C97C81E4AEC085897948D819", hash_generated_method = "C2EEED3B98D1C1A875CDFE24EBBC9B6A")
    public long pointToRowId(int x, int y) {
        int position;
        position = pointToPosition(x, y);
        {
            long varD18EE374A3F0927116BA59F2A9A03256_2122151131 = (mAdapter.getItemId(position));
        } //End block
        addTaint(x);
        addTaint(y);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_796293940 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_796293940;
        // ---------- Original Method ----------
        //int position = pointToPosition(x, y);
        //if (position >= 0) {
            //return mAdapter.getItemId(position);
        //}
        //return INVALID_ROW_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.591 -0400", hash_original_method = "5EE86ADCFB65EEBAD1CBAFF86BFF869E", hash_generated_method = "3F26F4518CD92D063A8240ED09BB9862")
    private boolean startScrollIfNeeded(int y) {
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
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993236193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993236193;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.595 -0400", hash_original_method = "24BFB982D66DDF27FDD0EB3AFC04A401", hash_generated_method = "B1944479F26178CE438DCEC6FF382951")
    private void scrollIfNeeded(int y) {
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
                    boolean var3B6B3092E9AEF7EFB8F7DB7C1090C559_1596349835 = ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) == 0 &&
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
                            boolean var879507118E22A9A52AEA797A263AF84E_2082419258 = (Math.abs(mOverscrollDistance) == Math.abs(mScrollY));
                            {
                                {
                                    mVelocityTracker.clear();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        int overscrollMode;
                        overscrollMode = getOverScrollMode();
                        {
                            boolean varAE1D066723B1EA15FA5C10A14D662F56_73595073 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                                (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                        !contentFits()));
                            {
                                mDirection = 0;
                                mTouchMode = TOUCH_MODE_OVERSCROLL;
                                {
                                    mEdgeGlowTop.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varA87047F469C00113B6AE83492D7AB59C_1042226325 = (!mEdgeGlowBottom.isFinished());
                                        {
                                            mEdgeGlowBottom.onRelease();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    mEdgeGlowBottom.onPull((float) overscroll / getHeight());
                                    {
                                        boolean varF30E150A7784B932CC0A99DAB3E3524A_1279511598 = (!mEdgeGlowTop.isFinished());
                                        {
                                            mEdgeGlowTop.onRelease();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mMotionY = y;
                    invalidate();
                } //End block
                mLastY = y;
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
                        boolean varA17BFA05D97ECE222863450A9B7218E6_497673812 = (overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS &&
                                    !contentFits()));
                        {
                            {
                                mEdgeGlowTop.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var352E8E7760F8F011E79FB28EFE62DA73_1986050154 = (!mEdgeGlowBottom.isFinished());
                                    {
                                        mEdgeGlowBottom.onRelease();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                mEdgeGlowBottom.onPull((float) overScrollDistance / getHeight());
                                {
                                    boolean var530787B3C000358ED8C3E02B71DC0120_272707662 = (!mEdgeGlowTop.isFinished());
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
                    mMotionY = y;
                    mMotionPosition = motionPosition;
                } //End block
                mLastY = y;
                mDirection = newDirection;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.702 -0400", hash_original_method = "6F0203AFDEF2DCB43412C3F5E7A63F8C", hash_generated_method = "5C263BB1056556A06FC5CDA18ED135B1")
    public void onTouchModeChanged(boolean isInTouchMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            hideSelector();
            {
                boolean var18FDA06F2E4C20DCFBA70CFDB1F209F6_987822145 = (getHeight() > 0 && getChildCount() > 0);
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
        addTaint(isInTouchMode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.732 -0400", hash_original_method = "EC498F7AA9A002C93696F04D5F90A9F2", hash_generated_method = "90D72BA4FC3B6DB329EA280030AA0ABF")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1984615460 = (!isEnabled());
            {
                boolean var78B3B137E9725C8407DD55321B456099_1784929248 = (isClickable() || isLongClickable());
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
                        boolean varD00D6114E840F55D6764F4976AFF0726_493020979 = ((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0)
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
                boolean var10762BA5807EC5420815666D17984CE3_78626420 = (performButtonActionOnTouchDown(ev));
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
                boolean var645943845E190A2FFA4FE7562EA898F8_1471867370 = (child != null && !child.hasFocusable() && inList);
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
                            boolean varAD4E45D7D3DB8FFF6E14B37863D65B2D_982127930 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
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
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.715 -0400", hash_original_method = "A6EC1D4E4E60E1E8895C51DF141E43B7", hash_generated_method = "9285F265A17C80263E536A0E27728322")
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
                        boolean var523699F24A476A31015FCD9CC5BA98D8_642651853 = (!mDataChanged && mAdapter.isEnabled(motionPosition));
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
                    boolean varE3D06501EDBEFC68EB729C2818A34655_821982602 = (mFirstPosition == 0 && firstChildTop >= contentTop &&
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
                            boolean varD48B4459D536B53F6277D9F8CEC82F89_142481974 = (Math.abs(initialVelocity) > mMinimumVelocity &&
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
                boolean varA56DF990188ABEF5AF3A9E103B5F2778_14672015 = (Math.abs(initialVelocity) > mMinimumVelocity);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712875386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_712875386;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.750 -0400", hash_original_method = "3A1744A3CB770F6FD9FFEB222E666622", hash_generated_method = "A65F9FBE4B732045E9C138C85F43B1D4")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            awakenScrollBars();
        } //End block
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        // ---------- Original Method ----------
        //if (mScrollY != scrollY) {
            //onScrollChanged(mScrollX, scrollY, mScrollX, mScrollY);
            //mScrollY = scrollY;
            //invalidateParentIfNeeded();
            //awakenScrollBars();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.751 -0400", hash_original_method = "09132BF5E477A2B233231E384E8A2F27", hash_generated_method = "D7A5E9B5DD6FA0E50FC185946D7EE274")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1967520551 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1143233784 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        {
                            float vscroll;
                            vscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            {
                                int delta;
                                delta = (int) (vscroll * getVerticalScrollFactor());
                                {
                                    boolean var5104A1C3A4166DC9AEBE0F45BFBBFDA2_860001869 = (!trackMotionScroll(delta, delta));
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1583697055 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928439730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928439730;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.759 -0400", hash_original_method = "F146D016CF32B873211A043EDB782604", hash_generated_method = "B50747C43A801A04B21E59E562DEA842")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        {
            int scrollY;
            scrollY = mScrollY;
            {
                boolean varD7662701013542BC2CCE8B2B50437EBA_468309919 = (!mEdgeGlowTop.isFinished());
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
                        boolean varAE9426D05B3D52BFC4B9E7AA44588485_901046195 = (mEdgeGlowTop.draw(canvas));
                        {
                            invalidate();
                        } //End block
                    } //End collapsed parenthetic
                    canvas.restoreToCount(restoreCount);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var71AB611E918A4C599E2F06D4154D257E_159506530 = (!mEdgeGlowBottom.isFinished());
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
                        boolean var61CCF9557D478E1494862B3636E22888_834836052 = (mEdgeGlowBottom.draw(canvas));
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.759 -0400", hash_original_method = "9FFFDAFD9442A3DE6BE69946897AC2B3", hash_generated_method = "763087F4905BF1A44B4D70DFA37C4F6C")
    public void setOverScrollEffectPadding(int leftPadding, int rightPadding) {
        mGlowPaddingLeft = leftPadding;
        mGlowPaddingRight = rightPadding;
        // ---------- Original Method ----------
        //mGlowPaddingLeft = leftPadding;
        //mGlowPaddingRight = rightPadding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.760 -0400", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "D2F7B701FF4A7C7D5D9BBE60A4204A34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.760 -0400", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "A47C5AEFF80C521B346EFD43CCEC463A")
    private void initVelocityTrackerIfNotExists() {
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        // ---------- Original Method ----------
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.760 -0400", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "4A5B29B306AF5EDD25C8547D1436EB51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.761 -0400", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "9EE44C43E2819EE39A2C95C618F793B6")
    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            recycleVelocityTracker();
        } //End block
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        addTaint(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept) {
            //recycleVelocityTracker();
        //}
        //super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.778 -0400", hash_original_method = "BEACBA96FA37C833811279893053B3A1", hash_generated_method = "B5810E921735F490F7BEAE2B5C866CC0")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                boolean varBEAADC7EDD4EC70730C4344D280FA313_636972236 = (startScrollIfNeeded(y));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18993676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18993676;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.780 -0400", hash_original_method = "C5DD3809C32C06AD527DF2275274EBCF", hash_generated_method = "1CB7AF19BC61609271355206A3F51964")
    private void onSecondaryPointerUp(MotionEvent ev) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.794 -0400", hash_original_method = "7406EAB31F4F45208F8FFDB2641D9148", hash_generated_method = "980DCFBE83137EE7962264B1EB048BB7")
    @Override
    public void addTouchables(ArrayList<View> views) {
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
                    boolean var2E8FCA4FD70E922109B068B9683F621A_1562008275 = (adapter.isEnabled(firstPosition + i));
                    {
                        views.add(child);
                    } //End block
                } //End collapsed parenthetic
                child.addTouchables(views);
            } //End block
        } //End collapsed parenthetic
        addTaint(views.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.800 -0400", hash_original_method = "53B60DC92C627A12BA76D6AAFD79D448", hash_generated_method = "5393B681A4461AB81DBE3337E826FE9E")
     void reportScrollStateChange(int newState) {
        {
            {
                mLastScrollState = newState;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.800 -0400", hash_original_method = "09656A4DFD81148F85DAB6B80BBEDF83", hash_generated_method = "B7F397FB63B938D69592A5A5BEFF477A")
    public void setFriction(float friction) {
        {
            mFlingRunnable = new FlingRunnable();
        } //End block
        mFlingRunnable.mScroller.setFriction(friction);
        addTaint(friction);
        // ---------- Original Method ----------
        //if (mFlingRunnable == null) {
            //mFlingRunnable = new FlingRunnable();
        //}
        //mFlingRunnable.mScroller.setFriction(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.802 -0400", hash_original_method = "0A97F6C2B71DEE1A9A851FDFBE6F2171", hash_generated_method = "22912162971CDA2675BA2D8F41874A24")
    public void setVelocityScale(float scale) {
        mVelocityScale = scale;
        // ---------- Original Method ----------
        //mVelocityScale = scale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.802 -0400", hash_original_method = "5ADECEDEBCB45348FEE18FEA2660C669", hash_generated_method = "E2A85D26F4AF3D5C48B6FA845A035F3A")
    public void smoothScrollToPosition(int position) {
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.start(position);
        addTaint(position);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.start(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.806 -0400", hash_original_method = "8931967DEF21C4BF02F7EE5F6DA25484", hash_generated_method = "9028CC58FCE919AD6DFD04627C596854")
    public void smoothScrollToPositionFromTop(int position, int offset, int duration) {
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.startWithOffset(position, offset, duration);
        addTaint(position);
        addTaint(offset);
        addTaint(duration);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.startWithOffset(position, offset, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.806 -0400", hash_original_method = "481FD979A7BEB05C5D5FED69D6209380", hash_generated_method = "743C4C8BE2F1287998AB3C500F30F686")
    public void smoothScrollToPositionFromTop(int position, int offset) {
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.startWithOffset(position, offset);
        addTaint(position);
        addTaint(offset);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.startWithOffset(position, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.820 -0400", hash_original_method = "D55175FA7A4D56B1E1633A69B89BF26C", hash_generated_method = "078C38FE8B95A8000028138D21023F5E")
    public void smoothScrollToPosition(int position, int boundPosition) {
        {
            mPositionScroller = new PositionScroller();
        } //End block
        mPositionScroller.start(position, boundPosition);
        addTaint(position);
        addTaint(boundPosition);
        // ---------- Original Method ----------
        //if (mPositionScroller == null) {
            //mPositionScroller = new PositionScroller();
        //}
        //mPositionScroller.start(position, boundPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.825 -0400", hash_original_method = "F38F4C8B27D75B9B07425BD626A4F57B", hash_generated_method = "AB6D8E7B12DC34D7DE04A32054D88D1A")
    public void smoothScrollBy(int distance, int duration) {
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
            boolean varE771752E61AAE94EE838BEB839D51E29_1364316464 = (distance == 0 || mItemCount == 0 || childCount == 0 ||
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
        addTaint(distance);
        addTaint(duration);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.829 -0400", hash_original_method = "C17AB5094757737D3C9F6E76AFA310E4", hash_generated_method = "2376EEC4812C44965179133D1E6392B7")
     void smoothScrollByOffset(int position) {
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
                    boolean var18BDB2D3799631890650FD697075D5F9_567776939 = (child.getGlobalVisibleRect(visibleRect));
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
        addTaint(position);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.841 -0400", hash_original_method = "81BA0C283B501CA4B76891C73CF6304F", hash_generated_method = "4F2D2548096503CB8CD1B64A3B2D9FBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.843 -0400", hash_original_method = "5EE1F7DCF1506371E8A50F14184A0F0B", hash_generated_method = "4CE0F67F01F29E1194BA651119CB6CAC")
    private void clearScrollingCache() {
        {
            mClearScrollingCache = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.843 -0400", hash_original_method = "C1A06A57DD958FE417CF10EBDAA96EFE", hash_generated_method = "5DEC999EC9E42DA3C94FE323B5367B3D")
                public void run() {
                    {
                        mCachingStarted = mCachingActive = false;
                        setChildrenDrawnWithCacheEnabled(false);
                        {
                            setChildrenDrawingCacheEnabled(false);
                        } //End block
                        {
                            boolean var600D0F7D7BFFDAD0124DB110898B3A19_1383160003 = (!isAlwaysDrawnWithCacheEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.872 -0400", hash_original_method = "A42371BB3F2D334094B7131C15A0F3E8", hash_generated_method = "05D7098018DFBC16D68EEE9FFC1A6759")
     boolean trackMotionScroll(int deltaY, int incrementalDeltaY) {
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
            mFirstPositionDistanceGuess += incrementalDeltaY;
        } //End block
        {
            mLastPositionDistanceGuess = lastBottom + listPadding.bottom;
        } //End block
        {
            mLastPositionDistanceGuess += incrementalDeltaY;
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
                        boolean varEA5CC9EA6E04B02875DA6B296CDA3DF6_1942107235 = (child.getBottom() >= top);
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
                        boolean var0C9792EB8E72B1E8C3A203B5FF9D7EBC_852869082 = (child.getTop() <= bottom);
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
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_72091747 = (childIndex >= 0 && childIndex < getChildCount());
                {
                    positionSelector(mSelectedPosition, getChildAt(childIndex));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int childIndex;
            childIndex = mSelectorPosition - mFirstPosition;
            {
                boolean varE4C29A15947D7CEF0EFEE58A70FEE3AA_1182878437 = (childIndex >= 0 && childIndex < getChildCount());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196572663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196572663;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.873 -0400", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "4000CEC48748407CF61B4E35A3FD8689")
     int getHeaderViewsCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443783908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443783908;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.873 -0400", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "8622D9BDEE6642F0BA442440809AC8F0")
     int getFooterViewsCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330939452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330939452;
        // ---------- Original Method ----------
        //return 0;
    }

    
    abstract void fillGap(boolean down);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.874 -0400", hash_original_method = "01CAE4EB89DA7F2FB8FB8C551B8C7558", hash_generated_method = "3397357B75DA44B7D8439BB69C481809")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.874 -0400", hash_original_method = "3C42E05D1FE66CE321CE689DCD7609AF", hash_generated_method = "433E6AD8FC468B7E14881E3ED29D6D95")
     int reconcileSelectedPosition() {
        int position;
        position = mSelectedPosition;
        {
            position = mResurrectToPosition;
        } //End block
        position = Math.max(0, position);
        position = Math.min(position, mItemCount - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169322476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169322476;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.875 -0400", hash_original_method = "620BFFA3FACC4E59D7B8719ED5062EB2", hash_generated_method = "94267F077289720C2E631B69C1348605")
     int findClosestMotionRow(int y) {
        int childCount;
        childCount = getChildCount();
        int motionRow;
        motionRow = findMotionRow(y);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1506686138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1506686138;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount == 0) {
            //return INVALID_POSITION;
        //}
        //final int motionRow = findMotionRow(y);
        //return motionRow != INVALID_POSITION ? motionRow : mFirstPosition + childCount - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.876 -0400", hash_original_method = "48746A94CCDD3AA210B8334DFA5415FB", hash_generated_method = "60F28DC437B80BF897562B54CF102004")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.877 -0400", hash_original_method = "DCA216018FB5348F17E51D7322AEEFD4", hash_generated_method = "ECCCC84DB40DC57E3BFCBB95B997A245")
     boolean resurrectSelectionIfNeeded() {
        {
            boolean varA94BDD63AC24FE4C16F032614F7038B6_1519434752 = (mSelectedPosition < 0 && resurrectSelection());
            {
                updateSelectorState();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627687532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627687532;
        // ---------- Original Method ----------
        //if (mSelectedPosition < 0 && resurrectSelection()) {
            //updateSelectorState();
            //return true;
        //}
        //return false;
    }

    
    abstract void setSelectionInt(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.893 -0400", hash_original_method = "46DC118C185645539DC69AE3B021DB61", hash_generated_method = "1A132EA55CA327DD4E69F8038AD8C985")
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
            boolean var62F8C3AE45B38B2DECAE10F01A4F320D_1361986242 = (selectedPos >= firstPosition && selectedPos <= getLastVisiblePosition());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307140800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307140800;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.895 -0400", hash_original_method = "7A1DBAB399A1231E28D6D54E2346B36F", hash_generated_method = "43CF1D9640A489A8107BA5F9EDBA044E")
     void confirmCheckedPositionsById() {
        mCheckStates.clear();
        boolean checkedCountChanged;
        checkedCountChanged = false;
        {
            int checkedIndex;
            checkedIndex = 0;
            boolean var345B3951F4A2E6483B2D033F362E91E2_416139103 = (checkedIndex < mCheckedIdStates.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.909 -0400", hash_original_method = "988EE7458DA5CAE45D4D8EEE7B510700", hash_generated_method = "2FF417C288A7E62664DF8B71DBCCB7A2")
    @Override
    protected void handleDataChanged() {
        int count;
        count = mItemCount;
        int lastHandledItemCount;
        lastHandledItemCount = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
        {
            boolean var1BF5A9488574E2FA74D8264040FC0893_1836958056 = (mChoiceMode != CHOICE_MODE_NONE && mAdapter != null && mAdapter.hasStableIds());
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
                    boolean varAFC77293C02F773029137FDE42129C14_1131259191 = (isInTouchMode());
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
                                    boolean varE6F64662C76820CEAED04C173D145196_2005563372 = (mSyncHeight == getHeight());
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
                boolean var12100596BD466B0E4730696B6E3F9C25_266736797 = (!isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.920 -0400", hash_original_method = "C562B15A4430BC762CC4B771E60D70AF", hash_generated_method = "9A39621834242436D3BE32DEFFA22A99")
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDisplayHint(hint);
        //Begin case INVISIBLE 
        {
            boolean varD929D8531D595F5EA0B4A8A252DF969D_595705215 = (mPopup != null && mPopup.isShowing());
            {
                dismissPopup();
            } //End block
        } //End collapsed parenthetic
        //End case INVISIBLE 
        //Begin case VISIBLE 
        {
            boolean var003C494DA1AA746A5D5A0908F950DF91_2114226757 = (mFiltered && mPopup != null && !mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.920 -0400", hash_original_method = "86B533D40AC94020BA9211F436996CAA", hash_generated_method = "6F219CE9A5114FCF258245673A1C0226")
    private void dismissPopup() {
        {
            mPopup.dismiss();
        } //End block
        // ---------- Original Method ----------
        //if (mPopup != null) {
            //mPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.920 -0400", hash_original_method = "6C07C7201C3F8F7AE411CAF5368DC26F", hash_generated_method = "C4FC71D0DB6F7B7E26B126A9C316299E")
    private void showPopup() {
        {
            boolean varEC31A88682EDD8797910B3EFA4C60835_634057221 = (getWindowVisibility() == View.VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.921 -0400", hash_original_method = "84FE8B62D6AD62C84F51A39D7331FBA6", hash_generated_method = "D545EF5463E1C2AE0563947B6F0A685E")
    private void positionPopup() {
        int screenHeight;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        int[] xy;
        xy = new int[2];
        getLocationOnScreen(xy);
        int bottomGap;
        bottomGap = screenHeight - xy[1] - getHeight() + (int) (mDensityScale * 20);
        {
            boolean varE8127168ED545283F844FC09586AD49B_1758734885 = (!mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.922 -0400", hash_original_method = "E53786E832898AFD8F3D1858C7ADFC0B", hash_generated_method = "782FEA6FBBE16826C41764E736FB31BF")
    @Override
    protected boolean isInFilterMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578122926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578122926;
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.923 -0400", hash_original_method = "E9CFCD950A6A0EAC13FE4A21D8302AE8", hash_generated_method = "9C6E4B57AE0AACD92081886EB6863845")
     boolean sendToTextFilter(int keyCode, int count, KeyEvent event) {
        {
            boolean var8E508D5098333C3DF9E9AC1534499251_838386559 = (!acceptFilter());
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
            boolean var39DB415F3D8E94BAF1BCAFDEBBF4C6EF_2122939932 = (mFiltered && mPopup != null && mPopup.isShowing());
            {
                {
                    boolean varF129D97EB58BBADBA4875AF25E33B341_1891322667 = (event.getAction() == KeyEvent.ACTION_DOWN
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
                        boolean varF38DB653E52CB4D0E4EDFCBA5E49A3DF_681296799 = (event.getAction() == KeyEvent.ACTION_UP
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
                boolean var6A7BE4CA28243E587EACA0203B08BD67_111699198 = (forwardEvent.getRepeatCount() > 0);
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
        addTaint(keyCode);
        addTaint(count);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184155920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184155920;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.955 -0400", hash_original_method = "D11D50B93967E008BF298EC93C5B84EB", hash_generated_method = "2D0CC144EFDE2EDE935CBBE4F6AEF2E1")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_785843468 = null; //Variable for return #1
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_939604637 = null; //Variable for return #2
        {
            boolean var402F49E4B8F4D68C8A96D34BD4EE8DD9_544487185 = (isTextFilterEnabled());
            {
                createTextFilter(false);
                {
                    mDefInputConnection = new BaseInputConnection(this, false);
                    mPublicInputConnection = new InputConnectionWrapper(
                        mTextFilter.onCreateInputConnection(outAttrs), true) {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.952 -0400", hash_original_method = "BF513EB07D63CFAF3DB0C9E86F478409", hash_generated_method = "D78AB776F637D1BB41DE366168CE3E52")
                        @Override
                        public boolean reportFullscreenMode(boolean enabled) {
                            boolean var75DA12718785A0AA273693F989B797D6_1859657885 = (mDefInputConnection.reportFullscreenMode(enabled));
                            addTaint(enabled);
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186383300 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_186383300;
                            // ---------- Original Method ----------
                            //return mDefInputConnection.reportFullscreenMode(enabled);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.953 -0400", hash_original_method = "D9C91C9E69679EA1CEEF772A4C39F6DE", hash_generated_method = "ACAC8C8E218DE7AE95CA1916CEA61C19")
                        @Override
                        public boolean performEditorAction(int editorAction) {
                            {
                                InputMethodManager imm;
                                imm = (InputMethodManager)
                                    getContext().getSystemService(
                                            Context.INPUT_METHOD_SERVICE);
                                {
                                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                } //End block
                            } //End block
                            addTaint(editorAction);
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865830597 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865830597;
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.954 -0400", hash_original_method = "4DB1D1C6C2201E74EC410884B47F862A", hash_generated_method = "CDF99783FD0BE8BB51202FFA75822018")
                        @Override
                        public boolean sendKeyEvent(KeyEvent event) {
                            boolean varDB2D5BE018F84A831888EA06678F8604_519869370 = (mDefInputConnection.sendKeyEvent(event));
                            addTaint(event.getTaint());
                            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822738085 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822738085;
                            // ---------- Original Method ----------
                            //return mDefInputConnection.sendKeyEvent(event);
                        }
};
                } //End block
                outAttrs.inputType = EditorInfo.TYPE_CLASS_TEXT
                    | EditorInfo.TYPE_TEXT_VARIATION_FILTER;
                outAttrs.imeOptions = EditorInfo.IME_ACTION_DONE;
                varB4EAC82CA7396A68D541C85D26508E83_785843468 = mPublicInputConnection;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_939604637 = null;
        InputConnection varA7E53CE21691AB073D9660D615818899_316238114; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_316238114 = varB4EAC82CA7396A68D541C85D26508E83_785843468;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_316238114 = varB4EAC82CA7396A68D541C85D26508E83_939604637;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_316238114.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_316238114;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.956 -0400", hash_original_method = "44BA525DE8B7DBBB72825E23CC2BB1F6", hash_generated_method = "0285A5BFF93CF905669A6285A82C9002")
    @Override
    public boolean checkInputConnectionProxy(View view) {
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368411443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368411443;
        // ---------- Original Method ----------
        //return view == mTextFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.957 -0400", hash_original_method = "F3682B44558BD825C5F832A45B68670A", hash_generated_method = "10B69DD11459AE8505C18EA0CEA5E753")
    private void createTextFilter(boolean animateEntrance) {
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
        addTaint(animateEntrance);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.979 -0400", hash_original_method = "32E21A2D6552DD3A6789EF27520CDF5A", hash_generated_method = "C9566FB994FB319258C42C1A39F1EB42")
    public void clearTextFilter() {
        {
            mTextFilter.setText("");
            mFiltered = false;
            {
                boolean var8B43E06806BC96AC7F4A8D7A0BE622AC_1937311804 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.979 -0400", hash_original_method = "65ACBB1BC8C4B28B951746B0589E48B4", hash_generated_method = "C3B057C318264049164D677C4615B5C9")
    public boolean hasTextFilter() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439180162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439180162;
        // ---------- Original Method ----------
        //return mFiltered;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.980 -0400", hash_original_method = "11A5FC28E28C3DFE2639108D4141B162", hash_generated_method = "9A6498BFFBD737884411E2CEE2B81B71")
    public void onGlobalLayout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var3CDBC35A1363DD4CC94823B3022E2382_2133461823 = (isShown());
            {
                {
                    boolean varDA5B3CFD94DC14795F693BACD8E64777_1812462043 = (mFiltered && mPopup != null && !mPopup.isShowing() && !mPopupHidden);
                    {
                        showPopup();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varF98F363210E79C98D906F19BE26A0AAC_1202786271 = (mPopup != null && mPopup.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.980 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "D46551DFD7C1F01B7CC6C2850BBA7577")
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(count);
        addTaint(after);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.981 -0400", hash_original_method = "971B961D673D514356DF6D21C3AC22CE", hash_generated_method = "58BD674A4024EC0DC818CF5621805222")
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varCB324F139DAF9E78619086072BD20A85_1061281181 = (mPopup != null && isTextFilterEnabled());
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
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(before);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.982 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.982 -0400", hash_original_method = "5FB3F90813AE5A23A23BDBAA76A97056", hash_generated_method = "0F0B22EF0C1B46EE125EA505154531EA")
    public void onFilterComplete(int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mResurrectToPosition = INVALID_POSITION;
            resurrectSelection();
        } //End block
        addTaint(count);
        // ---------- Original Method ----------
        //if (mSelectedPosition < 0 && count > 0) {
            //mResurrectToPosition = INVALID_POSITION;
            //resurrectSelection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.986 -0400", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "3701D2EC41AC3CBDAFD2006F2DE14529")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1766892261 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1766892261 = new LayoutParams(p);
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1766892261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766892261;
        // ---------- Original Method ----------
        //return new LayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.986 -0400", hash_original_method = "D7DCCEE0C1D1153E18E019649E6F2D80", hash_generated_method = "34BB4193A90130D436480D80DDB2F26F")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1931644019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1931644019 = new AbsListView.LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1931644019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1931644019;
        // ---------- Original Method ----------
        //return new AbsListView.LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.986 -0400", hash_original_method = "7C8047E4E7C938CA1D7BE889EE17D059", hash_generated_method = "A309563504E62D9EE243EA8AD7895ABD")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155383099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155383099;
        // ---------- Original Method ----------
        //return p instanceof AbsListView.LayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.005 -0400", hash_original_method = "1385B81082A7F6F42283DE7C72A352C9", hash_generated_method = "EDB13FA3924957A0F3CE2B87C521F371")
    public void setTranscriptMode(int mode) {
        mTranscriptMode = mode;
        // ---------- Original Method ----------
        //mTranscriptMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.006 -0400", hash_original_method = "EADF20E51473F5B82FC89B630E89BCE7", hash_generated_method = "9B03510E88249442CE4360E4DAD8601C")
    public int getTranscriptMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745795171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745795171;
        // ---------- Original Method ----------
        //return mTranscriptMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.006 -0400", hash_original_method = "3A641BF6273957C36676C590B4CC3444", hash_generated_method = "71697F76BC3C17666F9856C97C303D69")
    @Override
    public int getSolidColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128135245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128135245;
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.007 -0400", hash_original_method = "B2E4EFE21735BA4D4CA20D9D2323DF5E", hash_generated_method = "FC32225F5EB9FDA388F48B881465B1E8")
    public void setCacheColorHint(int color) {
        {
            mCacheColorHint = color;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.007 -0400", hash_original_method = "75945C93CA5A574EC2A11912410CB0E0", hash_generated_method = "5F341504B36AC77467E01A4861A815DB")
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955280865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955280865;
        // ---------- Original Method ----------
        //return mCacheColorHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.007 -0400", hash_original_method = "012761D54D3EA9FE8C837ED35E18F05A", hash_generated_method = "27E87EBA1C8382611A29267AD27BF8A0")
    public void reclaimViews(List<View> views) {
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
                    boolean var248D80F0B10623F58D6026D84DE5E671_420076987 = (lp != null && mRecycler.shouldRecycleViewType(lp.viewType));
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
        addTaint(views.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.009 -0400", hash_original_method = "63F1E187EEAD4E39E30E7C6F8BC8B8CA", hash_generated_method = "4992C5FC658DB131A6691402D925E03F")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                boolean var1B9DDC99DC36041733636881A6D6F2A7_949808056 = (!checkScrap(scrap));
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
                        boolean var152726F7FF3AB1D0325523449C0C26DB_1032198100 = (!checkScrap(scraps[i]));
                        result = false;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506211694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506211694;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.026 -0400", hash_original_method = "256B8EB3FFECB4266216E5C3F84B8A1E", hash_generated_method = "166EAFCF6457D6C98E4D8F5F386A405C")
    private boolean checkScrap(ArrayList<View> scrap) {
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
                    boolean varC649C41AA848C000C1488527EB85E854_1416018682 = (view.getParent() != null);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap still attached to a parent: " + view);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var6F0CAFE49F301E66083476B8CB251F7E_85986485 = (indexOfChild(view) >= 0);
                    {
                        result = false;
                        Log.d(ViewDebug.CONSISTENCY_LOG_TAG, "AbsListView " + this +
                        " has a view in its scrap heap that is also a direct child: " + view);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(scrap.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717486265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717486265;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.027 -0400", hash_original_method = "D0C284A2FBB36CA42A8E7F826DDB725F", hash_generated_method = "4702EDEA243C09BBFD77258C1ACBC569")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.029 -0400", hash_original_method = "C1CCFF5C419F753BE2BE6DDA2ACFD3CA", hash_generated_method = "5810B1414480671E80D52035D05DC8BB")
    public void setRemoteViewsAdapter(Intent intent) {
        {
            Intent.FilterComparison fcNew;
            fcNew = new Intent.FilterComparison(intent);
            Intent.FilterComparison fcOld;
            fcOld = new Intent.FilterComparison(
                    mRemoteAdapter.getRemoteViewsServiceIntent());
            {
                boolean var45C20E8BCA952BA88AD2862513B06923_1449811240 = (fcNew.equals(fcOld));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.029 -0400", hash_original_method = "0410210FC7BC336B3896BEA7510AAE3D", hash_generated_method = "9D38AC80197E9738EE138974F1EA14DE")
    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
        // ---------- Original Method ----------
        //mDeferNotifyDataSetChanged = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.052 -0400", hash_original_method = "28DEF371BA940ACF691CB065E03F3A69", hash_generated_method = "DB33B0FDB3136F97F132D980F84634DD")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822891526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822891526;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.052 -0400", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "64085B2EAF9EA39B9EA364A5E4CA7F63")
    public void onRemoteAdapterDisconnected() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.058 -0400", hash_original_method = "A10CF4C818C12AB96D88DAC8638A238F", hash_generated_method = "404EE273DAE2437904EE1226A8B166EC")
    public void setRecyclerListener(RecyclerListener listener) {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.058 -0400", hash_original_field = "74B7CE7BE804A955E8E20EA04653DEE6", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "22E8B3D384A8481DE4964CE4DE9406EA", hash_generated_field = "0BDE14D7CA4854CAEFC01406C97CEF7F")

        long firstId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "D1400BAE47A67FF79088280865144D7B", hash_generated_field = "56346AA9CA8DBF7744AF68AF06173D8A")

        int viewTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "8F36DB7D8F52F07B49D496BF7578B9B0")

        String filter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "056850EF315F5D6E6668719E2250DB2D", hash_generated_field = "5A1FA0BDDD0CC1410D12AF217F54B1FD")

        boolean inActionMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "934BB5987834E703FF3C24EA9FABB4CC", hash_generated_field = "B7E6911A4E2ECF81E111555BDE3C9E25")

        int checkedItemCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "9DD4030F43EEA8422A0B20FE0265BCBA", hash_generated_field = "6CA6AED4CE00926047251B3E7BCD1BAB")

        SparseBooleanArray checkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.059 -0400", hash_original_field = "4E89343A86D5E5558CBC6356B8A823D3", hash_generated_field = "9634971E46A47F441AB88BCA83B02BB2")

        LongSparseArray<Integer> checkIdState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.060 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.086 -0400", hash_original_method = "9305A5F2B13D160808C7DFC7D0F396F1", hash_generated_method = "58CE5784CBEF88DEA7FD823B6D358B15")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.088 -0400", hash_original_method = "3B46B91B7C73B4C6AC70E6F2F8A95E0E", hash_generated_method = "C7C2468781762B8AB0BF7BA01A1835E8")
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
                int i;
                i = 0;
                {
                    out.writeLong(checkIdState.keyAt(i));
                    out.writeInt(checkIdState.valueAt(i));
                } //End block
            } //End collapsed parenthetic
            addTaint(out.getTaint());
            addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.088 -0400", hash_original_method = "28CD4AAEE48E548227BD32788E936C86", hash_generated_method = "225DB6E7F2FE35EE223D64BA4BB3A150")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2062890957 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2062890957 = "AbsListView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " firstId=" + firstId
                    + " viewTop=" + viewTop
                    + " position=" + position
                    + " height=" + height
                    + " filter=" + filter
                    + " checkState=" + checkState + "}";
            varB4EAC82CA7396A68D541C85D26508E83_2062890957.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2062890957;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.088 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.178 -0400", hash_original_field = "71E0FB0329E33FA478C7BD9F2EB990C7", hash_generated_field = "C8F22F4E13BEEC60720F9AB64A1792E3")

        private int mOriginalAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.178 -0400", hash_original_method = "A658DB72BEF305C977658A79961C7172", hash_generated_method = "A658DB72BEF305C977658A79961C7172")
        public WindowRunnnable ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.179 -0400", hash_original_method = "CFEEFBABEEA41C591AAAAD229F2BB0E7", hash_generated_method = "3CF34E449DE44A2D47EB624B8E366E7B")
        public void rememberWindowAttachCount() {
            mOriginalAttachCount = getWindowAttachCount();
            // ---------- Original Method ----------
            //mOriginalAttachCount = getWindowAttachCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.180 -0400", hash_original_method = "A209657341959E6933B2954972D0CEE9", hash_generated_method = "313D46B01A77996F4AEC2478BDC8C137")
        public boolean sameWindow() {
            boolean var8C6821449255A008A670CF7CA64A93AB_71913467 = (hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47062402 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47062402;
            // ---------- Original Method ----------
            //return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        
    }


    
    private class PerformClick extends WindowRunnnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.180 -0400", hash_original_field = "4D3D586E79B5D45386198E5887F48792", hash_generated_field = "C001E24B1020A024FC58CC124DF01D4E")

        int mClickMotionPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.180 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.187 -0400", hash_original_method = "A958048F64A683459F522CCD37FE7D11", hash_generated_method = "65F66B97708E983C6955D02AF677213A")
        public void run() {
            ListAdapter adapter;
            adapter = mAdapter;
            int motionPosition;
            motionPosition = mClickMotionPosition;
            {
                boolean varB13BDDA7CDF6AF0E3819BBDA363D7ED8_1400493389 = (adapter != null && mItemCount > 0 &&
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.196 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.198 -0400", hash_original_method = "6FF0C5D4F5CC73F85A2BCE7243EBBA32", hash_generated_method = "17200411E6969C945BE4E942D216838E")
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
                    boolean var67E4CE6BEABC0BB93EA224EBEDE2210E_309732291 = (sameWindow() && !mDataChanged);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.198 -0400", hash_original_method = "D4E5218C094B479D486A451FD5B82AD6", hash_generated_method = "D4E5218C094B479D486A451FD5B82AD6")
        public CheckForKeyLongPress ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.199 -0400", hash_original_method = "A3D23752A2B3700EB42478E66A11709C", hash_generated_method = "33DDCDB5BAB806910ACA5AFAEC18702D")
        public void run() {
            {
                boolean varA166426E2772E5B5C6CC900A627665FC_1842697469 = (isPressed() && mSelectedPosition >= 0);
                {
                    int index;
                    index = mSelectedPosition - mFirstPosition;
                    View v;
                    v = getChildAt(index);
                    {
                        boolean handled;
                        handled = false;
                        {
                            boolean var15017B83B2D3E709399CA037CED2AFF9_1978230093 = (sameWindow());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.199 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.207 -0400", hash_original_method = "BD1CF9A4027AFE49AD3D9DDE12B9EB2A", hash_generated_method = "7EA1AA824295BE7254890F16FABDB650")
        public void run() {
            {
                mTouchMode = TOUCH_MODE_TAP;
                View child;
                child = getChildAt(mMotionPosition - mFirstPosition);
                {
                    boolean varEFC9B5F6E2423C87CACF29EB92D1C650_1635690046 = (child != null && !child.hasFocusable());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.207 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

        private OverScroller mScroller;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.207 -0400", hash_original_field = "9423EF5EE80CF667F79CA444C6185EF3", hash_generated_field = "86847DC6149E26E8E3AF7D833983C21E")

        private int mLastFlingY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.209 -0400", hash_original_field = "096BC0A6588940F4E79A408DFF90CE94", hash_generated_field = "64AFDC87BBF7A8277815899B878C1FD7")

        private Runnable mCheckFlywheel = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.209 -0400", hash_original_method = "794342E61B0741E0D2D0BA9CCE24C214", hash_generated_method = "5F9352099C9286C3C3AACA4E1A3DF4C2")
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
                    boolean varD670105D084B3EC9810CA2EF9B5779A0_973456372 = (Math.abs(yvel) >= mMinimumVelocity
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

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.214 -0400", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "85D92534340BCEFCD6A4F33FFFEF2C53")
          FlingRunnable() {
            mScroller = new OverScroller(getContext());
            // ---------- Original Method ----------
            //mScroller = new OverScroller(getContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.224 -0400", hash_original_method = "03D4FA54CBC93A7E96ECD2486CBEE621", hash_generated_method = "B384F47DC09208E561F22A2C05CB2D1E")
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
                } //End block
            } //End block
            {
                mFlingStrictSpan = StrictMode.enterCriticalSpan("AbsListView-fling");
            } //End block
            addTaint(initialVelocity);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.225 -0400", hash_original_method = "7C6D2E7D970FED93FF739DAAC6CC80C2", hash_generated_method = "201EA955A9C5D2689A925FC4BAEDCD47")
         void startSpringback() {
            {
                boolean var059811778A6969FDC20EDCB87A1E9DD0_1683991740 = (mScroller.springBack(0, mScrollY, 0, 0, 0, 0));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.225 -0400", hash_original_method = "57B70ADF06D2A10A257A1E350228503E", hash_generated_method = "02711FE6BB92CE9C9431001BE46A0C6F")
         void startOverfling(int initialVelocity) {
            mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            mTouchMode = TOUCH_MODE_OVERFLING;
            invalidate();
            post(this);
            addTaint(initialVelocity);
            // ---------- Original Method ----------
            //mScroller.fling(0, mScrollY, 0, initialVelocity, 0, 0,
                    //Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight());
            //mTouchMode = TOUCH_MODE_OVERFLING;
            //invalidate();
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.226 -0400", hash_original_method = "F0692CC07A14DB0F1E581AFC2CDF3E90", hash_generated_method = "5A24A3455D295F372B8B1F3D58126366")
         void edgeReached(int delta) {
            mScroller.notifyVerticalEdgeReached(mScrollY, 0, mOverflingDistance);
            int overscrollMode;
            overscrollMode = getOverScrollMode();
            {
                boolean var38522C672435F8008EBC1E11034D946B_1583309561 = (overscrollMode == OVER_SCROLL_ALWAYS ||
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
            addTaint(delta);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.226 -0400", hash_original_method = "16B3910BA949F2F73CCA1E8DA35CE0FF", hash_generated_method = "90A735FC2AAC1CCE03B8E25E3D3EFB14")
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
            // ---------- Original Method ----------
            //int initialY = distance < 0 ? Integer.MAX_VALUE : 0;
            //mLastFlingY = initialY;
            //mScroller.startScroll(0, initialY, 0, distance, duration);
            //mTouchMode = TOUCH_MODE_FLING;
            //post(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.227 -0400", hash_original_method = "EC718B25FAE44F694CA340373A32BE29", hash_generated_method = "2B0EEAA019059AF768DC2BD4BEFE8E7C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.227 -0400", hash_original_method = "5D655CDBCE73395DC3C27E060B822A32", hash_generated_method = "AF0A59A6E58D426EFA985AB4A1AD55DE")
         void flywheelTouch() {
            postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
            // ---------- Original Method ----------
            //postDelayed(mCheckFlywheel, FLYWHEEL_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_method = "4DD83535EAA65B570F4DB1073D459909", hash_generated_method = "805570E72DF5AB37D16FD5AF9B5BCBB3")
        public void run() {
            //Begin case default 
            endFling();
            //End case default 
            //Begin case TOUCH_MODE_SCROLL 
            {
                boolean var8C879AC9111FA456E4D5E672C40ED1D8_1952467400 = (mScroller.isFinished());
            } //End collapsed parenthetic
            //End case TOUCH_MODE_SCROLL 
            //Begin case TOUCH_MODE_FLING 
            {
                {
                    layoutChildren();
                } //End block
                {
                    boolean varF1747C254517DB9417BE3B51D681F089_1557602843 = (mItemCount == 0 || getChildCount() == 0);
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
                    boolean var0C92AC4985E057FF9B563A127E8C3B23_2051252932 = (scroller.computeScrollOffset());
                    {
                        int scrollY;
                        scrollY = mScrollY;
                        int currY;
                        currY = scroller.getCurrY();
                        int deltaY;
                        deltaY = currY - scrollY;
                        {
                            boolean var27491E7A6C26FA30763C389A29F73077_1872780130 = (overScrollBy(0, deltaY, 0, scrollY, 0, 0,
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "1135E78FD7F0199281F6A90573FF1A21", hash_generated_field = "423BC5DE09DA5B4AFD6A9C1712408027")

        private static int FLYWHEEL_TIMEOUT = 40;
    }


    
    class PositionScroller implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

        private int mMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "5F5170865EC69F6B24AEF73CD54B04BC", hash_generated_field = "35DC5F27F96B58A562B22555A8E37DA2")

        private int mTargetPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "6F001A96E4362F7D43184AD4169A147D", hash_generated_field = "001157AAC2240D5D9104D4D4F24CB9C2")

        private int mBoundPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "0CBDF658C2D1AD50575CB7EA8E63F15A", hash_generated_field = "891ABFC466B178DF3188D6BA9AF5BFB7")

        private int mLastSeenPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "BD4F087E6D2FF4D0C8D456B181206FDE", hash_generated_field = "0A9D921182A874240E73B3AC5A654444")

        private int mScrollDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "02F4FC33F196F5F1FB41D460018A21E5", hash_generated_field = "6B555669DDE5E4DA69AE4203D3212DA1")

        private int mExtraScroll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.252 -0400", hash_original_field = "C1AA32DDC2CA704B66F75B57225BB113", hash_generated_field = "D33BBF09949BE3C4FE4DC46E6E79C30E")

        private int mOffsetFromTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.253 -0400", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "39D3C7BDBFB04AD5ABE46AB28461C81D")
          PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
            // ---------- Original Method ----------
            //mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.264 -0400", hash_original_method = "FDCD353E7B4C16B389C07FF98024D1F6", hash_generated_method = "851CFDA984577D849146B09135B241E5")
         void start(int position) {
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
            mTargetPos = position;
            mBoundPos = INVALID_POSITION;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.265 -0400", hash_original_method = "84EF03A180BC8A392D5F6234ABF1A7D7", hash_generated_method = "21FE3BF64B2DFBE535FC2BE183C07004")
         void start(int position, int boundPosition) {
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
            mTargetPos = position;
            mBoundPos = boundPosition;
            mLastSeenPos = INVALID_POSITION;
            post(this);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.266 -0400", hash_original_method = "BE41DE2B3819156F24DD50B9D9C0C2E0", hash_generated_method = "21C42CBF55FF4200D6CDA7236BAC5184")
         void startWithOffset(int position, int offset) {
            startWithOffset(position, offset, SCROLL_DURATION);
            addTaint(position);
            addTaint(offset);
            // ---------- Original Method ----------
            //startWithOffset(position, offset, SCROLL_DURATION);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.283 -0400", hash_original_method = "6B17946EC33D794252BA778D04AAD100", hash_generated_method = "6B01D173DABFDDBA267AD10C3EB89C65")
         void startWithOffset(int position, int offset, int duration) {
            stop();
            mTargetPos = position;
            mOffsetFromTop = offset;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.283 -0400", hash_original_method = "EE84C7B9935E89C7F265FE60CF403C46", hash_generated_method = "8545B8FD33B72FF1E0D42710AB6A286F")
         void stop() {
            removeCallbacks(this);
            // ---------- Original Method ----------
            //removeCallbacks(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.286 -0400", hash_original_method = "BF3ECE172F6D799B3639990958E45277", hash_generated_method = "541A4A7060C1ACC870F4ECE2FC5604DD")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "6D32BAB94AC52022ABE497778A495DAC", hash_generated_field = "B51F3DF03CEC86E257B68A615A10CDD5")

        private static int SCROLL_DURATION = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "02C82B162D2A85797A66CB01E29B70B0", hash_generated_field = "6B509CEF0BEEFA32266B2413CDA67E4F")

        private static int MOVE_DOWN_POS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "63A071222A87531676875677B0989E32", hash_generated_field = "3A2DA8AA41570EA802FA321A370C352C")

        private static int MOVE_UP_POS = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "C032FEC22130B64512CC98C267B48A52", hash_generated_field = "4E4D812D91375C817522AED99AD894E2")

        private static int MOVE_DOWN_BOUND = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "BBA76F34EBD7F64DEFAC7A360A8B5B08", hash_generated_field = "0C0E32A9D31382248E89D47A548E6BC5")

        private static int MOVE_UP_BOUND = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_field = "83197AE6299B7EAE58463509EF4FB028", hash_generated_field = "6D2B41A7FBA26113F7FD0AB97EE70172")

        private static int MOVE_OFFSET = 5;
    }


    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.301 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.313 -0400", hash_original_method = "70826FE759108269AA8BACD409E1C863", hash_generated_method = "DE01F6EC3ED43C4CD1396D4089463EFC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.314 -0400", hash_original_method = "4570C5F375E9950A79093241C88AF34D", hash_generated_method = "122CC95F86F15B9927F1E8118900CD7B")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.314 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "8BFC2A3FD2E90E6CAECA368B78AA0988")

        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.314 -0400", hash_original_method = "55A4C0C73524FA4BF08CABB1B8DF874B", hash_generated_method = "55A4C0C73524FA4BF08CABB1B8DF874B")
        public MultiChoiceModeWrapper ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.314 -0400", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "3BE0D93844CB69FC6467C6B3B65058ED")
        public void setWrapped(MultiChoiceModeListener wrapped) {
            mWrapped = wrapped;
            // ---------- Original Method ----------
            //mWrapped = wrapped;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.315 -0400", hash_original_method = "92496BA2B215F9BD39661C34B9C10361", hash_generated_method = "62AAADEDD3CD6376123AB08EF76B166B")
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varD6C93448152EF2C372CDE7A0E8CB7504_136778253 = (mWrapped.onCreateActionMode(mode, menu));
                {
                    setLongClickable(false);
                } //End block
            } //End collapsed parenthetic
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21017965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21017965;
            // ---------- Original Method ----------
            //if (mWrapped.onCreateActionMode(mode, menu)) {
                //setLongClickable(false);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.315 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "A30DB4A785FB45F90D86501F3F7C49CF")
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var889963BD11CE1DC6E3538FA5CA769B04_1374570938 = (mWrapped.onPrepareActionMode(mode, menu));
            addTaint(mode.getTaint());
            addTaint(menu.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857269143 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857269143;
            // ---------- Original Method ----------
            //return mWrapped.onPrepareActionMode(mode, menu);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.316 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "689BB01FB228A94C31271F11F7D0480F")
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean varFD1FD09DE497AC204C6AFB08C6591DDB_289649072 = (mWrapped.onActionItemClicked(mode, item));
            addTaint(mode.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338053893 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_338053893;
            // ---------- Original Method ----------
            //return mWrapped.onActionItemClicked(mode, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.316 -0400", hash_original_method = "38D50D306A79D91BC9BAC512614B14E4", hash_generated_method = "D5DA3B7D6035D5BD361BAB2BD4A299C9")
        public void onDestroyActionMode(ActionMode mode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mWrapped.onDestroyActionMode(mode);
            mChoiceActionMode = null;
            clearChoices();
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            setLongClickable(true);
            addTaint(mode.getTaint());
            // ---------- Original Method ----------
            //mWrapped.onDestroyActionMode(mode);
            //mChoiceActionMode = null;
            //clearChoices();
            //mDataChanged = true;
            //rememberSyncState();
            //requestLayout();
            //setLongClickable(true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_method = "54A7C456AE4C179767C141D1533A24F9", hash_generated_method = "BC070AC2C8FFB307812E6D10AF8ABC9F")
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            {
                boolean var9E354D1EAEB52E913322B0C21F0A7D1D_493874431 = (getCheckedItemCount() == 0);
                {
                    mode.finish();
                } //End block
            } //End collapsed parenthetic
            addTaint(mode.getTaint());
            addTaint(position);
            addTaint(id);
            addTaint(checked);
            // ---------- Original Method ----------
            //mWrapped.onItemCheckedStateChanged(mode, position, id, checked);
            //if (getCheckedItemCount() == 0) {
                //mode.finish();
            //}
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_field = "BE99FDADF4634E48B1DF67A9485E0784", hash_generated_field = "D0AF750B588A0A8385D3506BD31A2EB8")

        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        }) int viewType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_field = "55471D4F82D5EFF522A6B7E31CC4A788", hash_generated_field = "211C82A03CAC4BFE4A39D3AFA73F8466")

        @ViewDebug.ExportedProperty(category = "list") boolean recycledHeaderFooter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_field = "330307ED6FC7975F67F11BB81BE3F1A9", hash_generated_field = "D6FCB86C3CDA915253A7995A3263A2E5")

        @ViewDebug.ExportedProperty(category = "list") boolean forceAdd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_field = "E573CA3738335F5135D0DDAEEA121E67", hash_generated_field = "9656FC663DC419C2046BE7A145261352")

        int scrappedFromPosition;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.320 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "0DBD7DD67030DB53521B4CBB550D5399")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A0678A9E2024BFE51CD3F973D466AEAF")
        public  LayoutParams(int w, int h) {
            super(w, h);
            addTaint(w);
            addTaint(h);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_method = "CB5E57490495E3D022159C4744E426CF", hash_generated_method = "12BE998CA1232185CC1E0013A33AC1A4")
        public  LayoutParams(int w, int h, int viewType) {
            super(w, h);
            this.viewType = viewType;
            addTaint(w);
            addTaint(h);
            // ---------- Original Method ----------
            //this.viewType = viewType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "37A5DBEF9177864A03971A9D81D7D3EE")
        public  LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    class RecycleBin {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_field = "63E890074C591F3B9ADCE0E62142C93F", hash_generated_field = "6E808820BD4FD463611A15BFE36E91A3")

        private RecyclerListener mRecyclerListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_field = "F9B783D9BCAFBFD5783C0A59D5D53319", hash_generated_field = "3638089149F436DC275AC3B59DF7B7C3")

        private int mFirstActivePosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_field = "424ED9F881A5AEDE2DC7FD2B4F700F0E", hash_generated_field = "4E509E23454F116649D54EFD8741D664")

        private View[] mActiveViews = new View[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_field = "D4FAB650ECA27500DEB6EEAEC3D1EB1D", hash_generated_field = "D87C278D091E93A90D61A3043FADF22D")

        private ArrayList<View>[] mScrapViews;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.321 -0400", hash_original_field = "E54D91FDD7887C0F3B4A327DE6D111A6", hash_generated_field = "F891A96632BBCEAB30959FDFBD22CDE9")

        private int mViewTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.322 -0400", hash_original_field = "D044D48CB87C97DCEB31A7992E06F2A4", hash_generated_field = "6256C7755218C1B9CBEA2B18392BAB2B")

        private ArrayList<View> mCurrentScrap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.322 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.322 -0400", hash_original_method = "2027E38C638AFAF08EBC73DB2999B11D", hash_generated_method = "EDC956D523628E4CF2C94350A4F48166")
        public void setViewTypeCount(int viewTypeCount) {
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
            mViewTypeCount = viewTypeCount;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.323 -0400", hash_original_method = "84FB41DBF94FAC74E383190ECD19AC3F", hash_generated_method = "B7905DF833EFD25178251E1C5FF4CCF5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.333 -0400", hash_original_method = "511AFE11A00C49C0B36C81F833AD1339", hash_generated_method = "4B083AE6327AA8DDA12EBFE202009369")
        public boolean shouldRecycleViewType(int viewType) {
            addTaint(viewType);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446247337 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_446247337;
            // ---------- Original Method ----------
            //return viewType >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.333 -0400", hash_original_method = "D3A3C7CFD0DB416C40300347744B44D9", hash_generated_method = "EAA7B8E911CBEEAE8B2178784036FBBE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.346 -0400", hash_original_method = "8EEC6DB7AE7CDFC4B2320C472F7412E6", hash_generated_method = "2FDF672608F2DB2DA93F0CB1BDA480F5")
         void fillActiveViews(int childCount, int firstActivePosition) {
            {
                mActiveViews = new View[childCount];
            } //End block
            mFirstActivePosition = firstActivePosition;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.347 -0400", hash_original_method = "6DDE0EAFBBDE35C2F4BC64D693E74936", hash_generated_method = "9F5D5D16E4ABCAA3CE92E89E9074AA57")
         View getActiveView(int position) {
            View varB4EAC82CA7396A68D541C85D26508E83_685768289 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_502607411 = null; //Variable for return #2
            int index;
            index = position - mFirstActivePosition;
            View[] activeViews;
            activeViews = mActiveViews;
            {
                View match;
                match = activeViews[index];
                activeViews[index] = null;
                varB4EAC82CA7396A68D541C85D26508E83_685768289 = match;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_502607411 = null;
            addTaint(position);
            View varA7E53CE21691AB073D9660D615818899_664908908; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_664908908 = varB4EAC82CA7396A68D541C85D26508E83_685768289;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_664908908 = varB4EAC82CA7396A68D541C85D26508E83_502607411;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_664908908.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_664908908;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.348 -0400", hash_original_method = "7C1BB02F0CFB7D7F7BDB0DC42C0788DA", hash_generated_method = "A309A204DA12917E78BA5DBA9A936086")
         View getScrapView(int position) {
            View varB4EAC82CA7396A68D541C85D26508E83_2031599642 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_1347073065 = null; //Variable for return #2
            View varB4EAC82CA7396A68D541C85D26508E83_1776846819 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_2031599642 = retrieveFromScrap(mCurrentScrap, position);
            } //End block
            {
                int whichScrap;
                whichScrap = mAdapter.getItemViewType(position);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1347073065 = retrieveFromScrap(mScrapViews[whichScrap], position);
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1776846819 = null;
            addTaint(position);
            View varA7E53CE21691AB073D9660D615818899_562739936; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_562739936 = varB4EAC82CA7396A68D541C85D26508E83_2031599642;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_562739936 = varB4EAC82CA7396A68D541C85D26508E83_1347073065;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_562739936 = varB4EAC82CA7396A68D541C85D26508E83_1776846819;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_562739936.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_562739936;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.357 -0400", hash_original_method = "ED120D0157D66531494A9FD53EAE380E", hash_generated_method = "70477270F9BC21E2CADE0A9D686C8470")
         void addScrapView(View scrap, int position) {
            AbsListView.LayoutParams lp;
            lp = (AbsListView.LayoutParams) scrap.getLayoutParams();
            int viewType;
            viewType = lp.viewType;
            {
                boolean var78318F84F970183913C3A58475F2628A_1644170411 = (!shouldRecycleViewType(viewType));
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
            addTaint(scrap.getTaint());
            addTaint(position);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.358 -0400", hash_original_method = "3138270AA2660474D2B7E99137A02556", hash_generated_method = "FA2865CB2A9AFC2DF0ED151DB9485FD8")
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
                            boolean var51E473BD444D9F2F14A7E3EC67387565_762703367 = (!shouldRecycleViewType(whichScrap));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.358 -0400", hash_original_method = "EA58D1FE496277FE2ED85A93396A169A", hash_generated_method = "55567F6691B28724F3D86D3D21366CBA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.362 -0400", hash_original_method = "3FD0A968FC7E2613466435C98B02B7BD", hash_generated_method = "A88966DE3217B6A092EE3F0FCD783C26")
         void reclaimScrapViews(List<View> views) {
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
            addTaint(views.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.362 -0400", hash_original_method = "BA10D81754F1A95A0F7C755DD4764D3B", hash_generated_method = "CF6FCEC450CDCDC295545A09A5A53DBF")
         void setCacheColorHint(int color) {
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
            addTaint(color);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.362 -0400", hash_original_field = "7D1F549A875745DA59610A279FF98C6A", hash_generated_field = "E0C0A7FB76C7D7FDA0F484B266D28899")

    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.362 -0400", hash_original_field = "CDE4EB733ED72E76C38D63649282466C", hash_generated_field = "421A8713FDFFB5C0C2BFB5F481F1F2FC")

    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.362 -0400", hash_original_field = "FE06291F5D87ED7DD9A7BB8F8A0D4CA7", hash_generated_field = "E1312AD0C8B74E42EC3EE6028B1137B6")

    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "B17A4043A5EC6ADB4C25FF7C74A22435", hash_generated_field = "EC66217389B14B1200A259EC24022418")

    static int TOUCH_MODE_REST = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "693680368AD0BD02276179792348EADA", hash_generated_field = "90A3E1017BA7C78E5932A380AF60EAB6")

    static int TOUCH_MODE_DOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "EC76282AC2561CD363039347CF179E7A", hash_generated_field = "2ED6DD090718FBE9EE8E1EE3FB638E80")

    static int TOUCH_MODE_TAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "9F4456FE44624E2AFC940A0465B3A097", hash_generated_field = "1DB91C9642A6EAFDB17B5A5E51A96100")

    static int TOUCH_MODE_DONE_WAITING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "2EEB434A0367FA7DF75FCCCA418ED5A6", hash_generated_field = "FCA4999AB153FA0EBC8E55663830D894")

    static int TOUCH_MODE_SCROLL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "A3F3E68500FFCA6BEC388A593AD55E8D", hash_generated_field = "2211A6B415D8458D483619BF415E48D6")

    static int TOUCH_MODE_FLING = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "6912EC2E8C428C3E5EF5E2B1D6B96D97", hash_generated_field = "401DA60976794F3F52E7AAAC25C2741B")

    static int TOUCH_MODE_OVERSCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "CFF51771A57BB12D98CF3DBA460C3142", hash_generated_field = "FE96877D7FF5C3268E5477E548C1CF53")

    static int TOUCH_MODE_OVERFLING = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "E29B3AF9E5F6AEE4BA465DAE46CAAC41", hash_generated_field = "B80CA43760F9A42956C330F76550BE65")

    static int LAYOUT_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "4D7A3B72023A68BEFFC3ED5BE8F99A79", hash_generated_field = "457B4E8EDA900FAD1721993B513CF2A3")

    static int LAYOUT_FORCE_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "3B2B6E287126A61BA2B94A3B61A31DEB", hash_generated_field = "A72BCB67922BC5B7C75FC290478B981B")

    static int LAYOUT_SET_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "A2D8EBC46AF970886DB38E17FA3DF022", hash_generated_field = "4787A4435FE730F4D18B12AF440ACFE4")

    static int LAYOUT_FORCE_BOTTOM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "E766E3DD98613EBA901DF572ED840902", hash_generated_field = "89AACA0E8CF18CA5BD2BC9A2AB88D3A8")

    static int LAYOUT_SPECIFIC = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "032014FE7C510E0E4B984E3FDB4FFC5E", hash_generated_field = "E64F51ED15F14F182DB3DD79966FA7E1")

    static int LAYOUT_SYNC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "EECD2AD33B6C7CC83F468CC38D4F5EBA", hash_generated_field = "1BB2AA5B974BAC0305EFCD565FC59B11")

    static int LAYOUT_MOVE_SELECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "8D280EE6CE7BD607DD9CFD2FEBD4331A", hash_generated_field = "C4D29CBAF23D3100F74985968BC044B6")

    public static final int CHOICE_MODE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.363 -0400", hash_original_field = "A88E8015B5E7C102D0E4E5C329EE0B0A", hash_generated_field = "8ACFD8F9A2D07A54C73A4603D3C11699")

    public static final int CHOICE_MODE_SINGLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.364 -0400", hash_original_field = "191E984C863FDD720FB7803FEB1E5AC7", hash_generated_field = "35513B4AE78E0FC364C3E99A7BACE878")

    public static final int CHOICE_MODE_MULTIPLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.364 -0400", hash_original_field = "55297737093C40EB0446D105E6BC2BF6", hash_generated_field = "8C15E8901DB2548719C9BDD4426BD6C4")

    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "DF83619CF8CE79415D5849EAB6531F4D", hash_generated_field = "A94624F82CAE37C926DF8CF57B34F3B5")

    static int OVERSCROLL_LIMIT_DIVISOR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "D16CE528694D125BEF5912F00C5A2E99", hash_generated_field = "402C6D67C56EAE33589136DE627F846E")

    private static int CHECK_POSITION_SEARCH_DISTANCE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "155C3D6D52A3AC47DB7F11D2D6ABC0C9", hash_generated_field = "BF22539FC86C9DB28DB517F211AAE279")

    private static int TOUCH_MODE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "25D4A8329815B118CAB37A548D0C8D7A", hash_generated_field = "0358937B51E3AB464C60B7E9E0CA9DE2")

    private static int TOUCH_MODE_ON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "E986EE0A950AB519A9D78E5F63C4BE79", hash_generated_field = "51854CCBDDE11234E95F3CFA80B7B413")

    private static int TOUCH_MODE_OFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "A07FD6552E4DC46AC3F39BFD68136463", hash_generated_field = "509C070A389D694974E86B4E782CCEDF")

    private static boolean PROFILE_SCROLLING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "CB81333E4C8FBCF9DC4472A4127AA8DB", hash_generated_field = "9A32E4EF3EA411D5645366755B2A7174")

    private static boolean PROFILE_FLINGING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.368 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "EC0CE8121C7A62BAD74595655C619E28")

    private static int INVALID_POINTER = -1;
}

