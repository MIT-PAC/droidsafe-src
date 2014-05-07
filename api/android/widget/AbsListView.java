package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import com.android.internal.view.menu.MenuBuilder;

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
import android.view.ActionMode.SimpleActionMode;
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

public abstract class AbsListView extends AdapterView<ListAdapter> implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, Filter.FilterListener, ViewTreeObserver.OnTouchModeChangeListener, RemoteViewsAdapter.RemoteAdapterConnectionCallback {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    static int getDistance(Rect source, Rect dest, int direction){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        return (source.getTaintInt() + dest.getTaintInt() + direction);
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static View retrieveFromScrap(ArrayList<View> scrapViews, int position){
		// Original method

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
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.797 -0500", hash_original_field = "38E044CB52C13C2CC72B802D346B5A5F", hash_generated_field = "E0C0A7FB76C7D7FDA0F484B266D28899")

    public static final int TRANSCRIPT_MODE_DISABLED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.799 -0500", hash_original_field = "728782E70CA22025AD537D81E9B84A19", hash_generated_field = "421A8713FDFFB5C0C2BFB5F481F1F2FC")

    public static final int TRANSCRIPT_MODE_NORMAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.802 -0500", hash_original_field = "64E01419ABF2CDEC8DADA173028140F6", hash_generated_field = "E1312AD0C8B74E42EC3EE6028B1137B6")

    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.804 -0500", hash_original_field = "5A4C203D59EC551B9B54DFABCFEA827B", hash_generated_field = "1A65913029CD13477BA64563C54FFD4B")

    static final int TOUCH_MODE_REST = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.806 -0500", hash_original_field = "1C54B58FF737990261A30DB6D38B6DA4", hash_generated_field = "BF46F64D4AB1CB6C3D3AFC128E88F131")

    static final int TOUCH_MODE_DOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.808 -0500", hash_original_field = "746EC81C31589BE06463A3B529DE4D73", hash_generated_field = "B0569807CBB5B462D97BD49753CF9491")

    static final int TOUCH_MODE_TAP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.811 -0500", hash_original_field = "E23256F0C40AC661922382B7D6ACA11B", hash_generated_field = "A74A1CE702CCC92436644F77B7A85141")

    static final int TOUCH_MODE_DONE_WAITING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.813 -0500", hash_original_field = "2C4BC4E6C91BB6693EB02F156E094230", hash_generated_field = "A7874F652310534ED2E48713722C968E")

    static final int TOUCH_MODE_SCROLL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.816 -0500", hash_original_field = "1ABEDA1AC4317DA1F322B47F78C980BA", hash_generated_field = "F745E8763A46E798FA58BA919DF435B6")

    static final int TOUCH_MODE_FLING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.818 -0500", hash_original_field = "F502E078221C0D36062356AEBE1E62B9", hash_generated_field = "65D38BF1EEECB664AFC79AB59359D9F2")

    static final int TOUCH_MODE_OVERSCROLL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.820 -0500", hash_original_field = "6E97655EF912642E56AFAE352B23F686", hash_generated_field = "D34672476DCFE73B3F16CA72EB28F066")

    static final int TOUCH_MODE_OVERFLING = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.822 -0500", hash_original_field = "227F580E4C96D2ED772142BE307A03CD", hash_generated_field = "307F2C2AACAC6613A6B819B1C46E9BEC")

    static final int LAYOUT_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.824 -0500", hash_original_field = "8BC9B906504D1BC7CFAE6B42F77CC270", hash_generated_field = "8858F00D2FC0F97FA91A4A452FE42A3E")

    static final int LAYOUT_FORCE_TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.826 -0500", hash_original_field = "7E1908F5E76E78D1B94AE7AD2D0C716D", hash_generated_field = "C9D08A824763C3FF89EC230BC5EBEA19")

    static final int LAYOUT_SET_SELECTION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.829 -0500", hash_original_field = "2AD2710A91D2F41EDF02C6E66E884C98", hash_generated_field = "504C59967FB303DF657FE1D3F305C5D0")

    static final int LAYOUT_FORCE_BOTTOM = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.831 -0500", hash_original_field = "E224E6E0D8A2052C6EB14EE765DFD076", hash_generated_field = "F1FBE80C1B23C45E6D01D0BA249DB345")

    static final int LAYOUT_SPECIFIC = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.833 -0500", hash_original_field = "7039DD8C87324A198A66BF3CE7F86344", hash_generated_field = "846A9498FB0ABE0CE7726FC2AB67A29C")

    static final int LAYOUT_SYNC = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.835 -0500", hash_original_field = "CD5982671835FD52A040E587C041AA7C", hash_generated_field = "227AB8582020535483796213A6EBF50A")

    static final int LAYOUT_MOVE_SELECTION = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.838 -0500", hash_original_field = "918AC0AA6979282622F488BD86170186", hash_generated_field = "C4D29CBAF23D3100F74985968BC044B6")

    public static final int CHOICE_MODE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.840 -0500", hash_original_field = "BAC3FC90CD3C899B5EDD310B8BA9D49A", hash_generated_field = "8ACFD8F9A2D07A54C73A4603D3C11699")

    public static final int CHOICE_MODE_SINGLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.842 -0500", hash_original_field = "2A1D3A21C5BBD149CDDE2D02C248768C", hash_generated_field = "35513B4AE78E0FC364C3E99A7BACE878")

    public static final int CHOICE_MODE_MULTIPLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.845 -0500", hash_original_field = "38ABB4DA9B9F1A248D3C035A0FEBB9F3", hash_generated_field = "8C15E8901DB2548719C9BDD4426BD6C4")

    public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.949 -0500", hash_original_field = "F78EB404BF8C10BD7372A698C65E60C3", hash_generated_field = "5D646DC42A86BD62288C592A5533029A")

    static final int OVERSCROLL_LIMIT_DIVISOR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.951 -0500", hash_original_field = "54E1C4951279F7EF0DECF6F448B4FA33", hash_generated_field = "33995481F66B2BB4E0A516C56A797FAE")

    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.953 -0500", hash_original_field = "6BD42AE33FA554735841B456EA3E50AA", hash_generated_field = "4232090D870E37044033C5A96825AC60")

    private static final int TOUCH_MODE_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.956 -0500", hash_original_field = "C17D4126BB77046A36968C1B8A15A2E5", hash_generated_field = "38D3EC1233BE9FEC7E013AE0CFEBD8DD")

    private static final int TOUCH_MODE_ON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.959 -0500", hash_original_field = "921C0F41D7483BDFB69BAFF2D8EA4E6C", hash_generated_field = "7D9ADB0F602E4659CCF6E8DDDB3ED6E5")

    private static final int TOUCH_MODE_OFF = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.964 -0500", hash_original_field = "F352B9A1EB51EB0E17E0BAB80DFA9EFA", hash_generated_field = "E7D81FF0F37E8DBAE850DA049B83B27B")

    private static final boolean PROFILE_SCROLLING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.968 -0500", hash_original_field = "D037B61D3E48CE32A2444C0D64B1F35A", hash_generated_field = "10908BC5D74B320FCDD3C04619CCD594")

    private static final boolean PROFILE_FLINGING = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.023 -0500", hash_original_field = "394D213079DFA0C7024EC13F5673BC94", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.847 -0500", hash_original_field = "383DDBE003D416456C310D4158C4CFB9", hash_generated_field = "383DDBE003D416456C310D4158C4CFB9")

    int mChoiceMode = CHOICE_MODE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.849 -0500", hash_original_field = "48C1F0333DFD0DC72046CFA915BFC8E8", hash_generated_field = "48C1F0333DFD0DC72046CFA915BFC8E8")

    ActionMode mChoiceActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.851 -0500", hash_original_field = "8DB318A3968ACAA4E72C29D459103061", hash_generated_field = "8DB318A3968ACAA4E72C29D459103061")

    MultiChoiceModeWrapper mMultiChoiceModeCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.852 -0500", hash_original_field = "69D140D043E457BD61D5B9F6552EF517", hash_generated_field = "69D140D043E457BD61D5B9F6552EF517")

    int mCheckedItemCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.854 -0500", hash_original_field = "CA6CC91745E43EBBCA6C857FDAD05357", hash_generated_field = "CA6CC91745E43EBBCA6C857FDAD05357")

    SparseBooleanArray mCheckStates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.856 -0500", hash_original_field = "869EB89A549CFEBFB16DD4FED9649B6E", hash_generated_field = "869EB89A549CFEBFB16DD4FED9649B6E")

    LongSparseArray<Integer> mCheckedIdStates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.858 -0500", hash_original_field = "D9E7894D012FFAF92CE958370EAAE107", hash_generated_field = "D9E7894D012FFAF92CE958370EAAE107")

    int mLayoutMode = LAYOUT_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.860 -0500", hash_original_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2", hash_generated_field = "C2A92A98CA414A0C47C4CCACBB8EA2C2")

    AdapterDataSetObserver mDataSetObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.862 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    public ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.864 -0500", hash_original_field = "E7B644709228FDC2A568B05600FADA2E", hash_generated_field = "386E575B164CBA38A9F16CB0F74210CE")

    private RemoteViewsAdapter mRemoteAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.867 -0500", hash_original_field = "D8481D38E4E063E4EC28948859294EB6", hash_generated_field = "A4A26F367FC0C1227F7A5E61B89ABBBE")

    private boolean mDeferNotifyDataSetChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.869 -0500", hash_original_field = "A1E757D1ECB75F11B7A5FD22CFD8D6DE", hash_generated_field = "A1E757D1ECB75F11B7A5FD22CFD8D6DE")

    boolean mDrawSelectorOnTop = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.871 -0500", hash_original_field = "FF4158F9C935D5CC585FE18F81632212", hash_generated_field = "FF4158F9C935D5CC585FE18F81632212")

    Drawable mSelector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.873 -0500", hash_original_field = "15C7707915A6B0B74E44A43E1542C958", hash_generated_field = "15C7707915A6B0B74E44A43E1542C958")

    int mSelectorPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.875 -0500", hash_original_field = "C524FC1C3E6AAF765E2CAB633026E31B", hash_generated_field = "C524FC1C3E6AAF765E2CAB633026E31B")

    Rect mSelectorRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.877 -0500", hash_original_field = "707525CCDB9513E977E0C2123AF49590", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.878 -0500", hash_original_field = "753C8FC0C4D631C54FF77F2B10210084", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.881 -0500", hash_original_field = "50BDF542563848097B98D0F9CA864924", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.883 -0500", hash_original_field = "3DC4FB7C9491C740968135A630596AA0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.885 -0500", hash_original_field = "7187B403BE2B79CEAB01DB70095A8709", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.887 -0500", hash_original_field = "05D43BB1A495A731310553613FE206DD", hash_generated_field = "05D43BB1A495A731310553613FE206DD")

    Rect mListPadding = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.889 -0500", hash_original_field = "F34547E4E9C4393B08D5498F65FC370A", hash_generated_field = "F34547E4E9C4393B08D5498F65FC370A")

    int mWidthMeasureSpec = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.891 -0500", hash_original_field = "00AF12951227F69DA5FB3783B6D532DB", hash_generated_field = "00AF12951227F69DA5FB3783B6D532DB")

    View mScrollUp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.893 -0500", hash_original_field = "045245010980799FDB6036E67E9F436F", hash_generated_field = "045245010980799FDB6036E67E9F436F")

    View mScrollDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.895 -0500", hash_original_field = "6E445E4EED263A45A094087A50B7126E", hash_generated_field = "6E445E4EED263A45A094087A50B7126E")

    boolean mCachingStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.897 -0500", hash_original_field = "0AB9D53170F11322593A4B241676E18D", hash_generated_field = "0AB9D53170F11322593A4B241676E18D")

    boolean mCachingActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.898 -0500", hash_original_field = "6516B57613A0784EC2DDB500ABA92556", hash_generated_field = "6516B57613A0784EC2DDB500ABA92556")

    int mMotionPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.900 -0500", hash_original_field = "9D04282A1BDDC504BC19852147A5D64D", hash_generated_field = "9D04282A1BDDC504BC19852147A5D64D")

    int mMotionViewOriginalTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.902 -0500", hash_original_field = "2086F63C3164AF1AA06DFC0C51452109", hash_generated_field = "2086F63C3164AF1AA06DFC0C51452109")

    int mMotionViewNewTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.904 -0500", hash_original_field = "E9714F671BCE6666EDE234DD36661DA0", hash_generated_field = "E9714F671BCE6666EDE234DD36661DA0")

    int mMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.906 -0500", hash_original_field = "BAC7C8FFD482868C2E281DB29DBFE06D", hash_generated_field = "BAC7C8FFD482868C2E281DB29DBFE06D")

    int mMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.907 -0500", hash_original_field = "7C51C810E963B7D188B47B8F49B7DDE4", hash_generated_field = "7C51C810E963B7D188B47B8F49B7DDE4")

    int mTouchMode = TOUCH_MODE_REST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.910 -0500", hash_original_field = "C4455B3957BD1EE48827818491DAA168", hash_generated_field = "C4455B3957BD1EE48827818491DAA168")

    int mLastY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.912 -0500", hash_original_field = "1C8B3319825706CAEF653B7569131ADE", hash_generated_field = "1C8B3319825706CAEF653B7569131ADE")

    int mMotionCorrection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.914 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.916 -0500", hash_original_field = "602880E724AC210718E45409F322A0FE", hash_generated_field = "6E948CA7630EFB6162DA2EBAA4208363")

    private FlingRunnable mFlingRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.919 -0500", hash_original_field = "EAEF5BFBCD673DF3BDE06D2DD578841B", hash_generated_field = "3A7EBB83D687A969A9AA75982B56B68B")

    private PositionScroller mPositionScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.921 -0500", hash_original_field = "77BDF9079A717E33AEBAD612261D859E", hash_generated_field = "77BDF9079A717E33AEBAD612261D859E")

    int mSelectedTop = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.923 -0500", hash_original_field = "A2083A1B78272D6D26A8F8E0BA5E2327", hash_generated_field = "A2083A1B78272D6D26A8F8E0BA5E2327")

    boolean mStackFromBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.925 -0500", hash_original_field = "3BD9FEE95F32C4889FDFAAEB81585604", hash_generated_field = "3BD9FEE95F32C4889FDFAAEB81585604")

    boolean mScrollingCacheEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.927 -0500", hash_original_field = "AB477B88BF820ABA168568369EF3F457", hash_generated_field = "AB477B88BF820ABA168568369EF3F457")

    boolean mFastScrollEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.929 -0500", hash_original_field = "DEE4ABF5D3BA14C8164960F187FBF71B", hash_generated_field = "0E000F63F4EDDECD3CA33DA7CA7FEA0C")

    private OnScrollListener mOnScrollListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.931 -0500", hash_original_field = "7E4C7D8A72122A6640DF0AA884C2245D", hash_generated_field = "7E4C7D8A72122A6640DF0AA884C2245D")

    PopupWindow mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.933 -0500", hash_original_field = "E12C98919B28D2782FD5E54CA9C7E663", hash_generated_field = "E12C98919B28D2782FD5E54CA9C7E663")

    EditText mTextFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.935 -0500", hash_original_field = "224758EF48E9D0BF77AE50AD19A31269", hash_generated_field = "99B5A44FD56940F18C75CE655B9A1668")

    private boolean mSmoothScrollbarEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.937 -0500", hash_original_field = "24E1411AB172275959A8F7C4F48E457F", hash_generated_field = "10C9AD0517CE8D8A09913559356A8C56")

    private boolean mTextFilterEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.939 -0500", hash_original_field = "EF6704DACE17497D6478386C0287ECFE", hash_generated_field = "E5AC0509E741D92E16D3D731D4E96C35")

    private boolean mFiltered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.941 -0500", hash_original_field = "4B8DBDF8B13299F4A9AA8215ABC5FF7F", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.943 -0500", hash_original_field = "A7BFECA874263BCC8A6464704B9D41D9", hash_generated_field = "A7BFECA874263BCC8A6464704B9D41D9")

    int mResurrectToPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.945 -0500", hash_original_field = "11D12765538080AF0A0CA81FE9089107", hash_generated_field = "83C7C32482C7E5A03D695886EA4705D5")

    private ContextMenuInfo mContextMenuInfo = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.947 -0500", hash_original_field = "CAABAA47CA52B1F5C0386B90B683E22C", hash_generated_field = "CAABAA47CA52B1F5C0386B90B683E22C")

    int mOverscrollMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.961 -0500", hash_original_field = "779C99950396DC4C08D287054E8C580C", hash_generated_field = "CFC250691336B4B39585FE305D07A5A8")

    private int mLastTouchMode = TOUCH_MODE_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.966 -0500", hash_original_field = "D7E6CDDF00C553DE08F1779CBF06BF1C", hash_generated_field = "8AE445FC94FDAEC334CFCA8838E3B70E")

    private boolean mScrollProfilingStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.970 -0500", hash_original_field = "E381870E9F2F2BADCC8AD0F5C997AFE6", hash_generated_field = "69AFA437C5D84E7EE29B4FE44E13B088")

    private boolean mFlingProfilingStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.972 -0500", hash_original_field = "070062287C2ECF68F959A57924644C87", hash_generated_field = "BA5EBFF9CCBAD624E5B38890A6227093")

    private StrictMode.Span mScrollStrictSpan = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.974 -0500", hash_original_field = "72859A1AE349B842BE8E7399ED58C2B8", hash_generated_field = "1B2DFB133C9B4AE33C58293244DDF261")

    private StrictMode.Span mFlingStrictSpan = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.976 -0500", hash_original_field = "39A3A6C60445CD08D83FC3B94CFC91FD", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.978 -0500", hash_original_field = "F3CF806FFB4C33156882341FD42C8EAB", hash_generated_field = "C7859F448E179D513123D1E080D96FF5")

    private Runnable mPendingCheckForTap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.980 -0500", hash_original_field = "9D97A56788E62E79709D02EC3BB4E538", hash_generated_field = "6BA43AA573D039EEDC72EB768AE06B64")

    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.983 -0500", hash_original_field = "F30FF1DE5CDA2E86EDF3673B3B48848D", hash_generated_field = "07CC57CA51A809E0D650A47A9B235FD7")

    private AbsListView.PerformClick mPerformClick;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.985 -0500", hash_original_field = "6568B86A3C01040790D5A38EAB919F85", hash_generated_field = "04EA068A0D45E96537B1140190A89770")

    private Runnable mTouchModeReset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.987 -0500", hash_original_field = "5CA1E0B90C284B70F3A71A1DEED43BCD", hash_generated_field = "1526254A73CD23B3F5170A2D59CF9F76")

    private int mTranscriptMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.989 -0500", hash_original_field = "BFECF28B592B00FE3B1CC8955E1A4C1B", hash_generated_field = "1B8E8F372FC2DAC037EC526954D125A4")

    private int mCacheColorHint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.991 -0500", hash_original_field = "AE382C074772FE974110202C34024376", hash_generated_field = "0F85F813AE78D809D6545B656F7C07C7")

    private boolean mIsChildViewEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.993 -0500", hash_original_field = "EEBABD06ACB6ABAB5E667E7B44BC7901", hash_generated_field = "9D6B53868A098EC5A838EECA6460C254")

    private int mLastScrollState = OnScrollListener.SCROLL_STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.995 -0500", hash_original_field = "8048674055FE91FCFC4664F41682E8CC", hash_generated_field = "FE09333368CBF6471ABE6F31E47E522C")

    private FastScroller mFastScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.997 -0500", hash_original_field = "E92578B5EE90B806FFF8091BF142FC3E", hash_generated_field = "8D12711C83D9C6A8E3A8DA9BEC091FCE")

    private boolean mGlobalLayoutListenerAddedFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:52.999 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.002 -0500", hash_original_field = "DD9229867FE5117C4B714822940E2834", hash_generated_field = "3CCF90D786BE55C250C6CD780F8D19C3")

    private float mDensityScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.004 -0500", hash_original_field = "0C1E800128D38F93F0B20F8D8033A073", hash_generated_field = "92752ACB14767626BA8FAB32711AE1A6")

    private InputConnection mDefInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.006 -0500", hash_original_field = "986DA99674B09AD3A8F3B5206297E53F", hash_generated_field = "048E465914FAB6B457D7426F9FB399BD")

    private InputConnectionWrapper mPublicInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.009 -0500", hash_original_field = "32E744C5D372104B4D0CC46BA30C9D77", hash_generated_field = "20FDBC6BCA9CEE1B1E479A246AC00217")

    private Runnable mClearScrollingCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.011 -0500", hash_original_field = "0DAB51CD5AD14EAFA0DBAE048171A484", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.013 -0500", hash_original_field = "EBB696916B500EA5521AFFF60D013E17", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.015 -0500", hash_original_field = "140A0D1E54EC680AC3FCD5561B71CEE3", hash_generated_field = "32DD593911EBA2DE7D4B7E5052058A82")

    private float mVelocityScale = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.017 -0500", hash_original_field = "B6AD59D19B211FC685CE87567BA82386", hash_generated_field = "3A7729712A4A2CC963B04549E3BBA6B5")

    final boolean[] mIsScrap = new boolean[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.019 -0500", hash_original_field = "6ED1AAA72B9DB69535CBA85A01375A9C", hash_generated_field = "79473BC5CF0606B5E3762DA4A5A065CF")

    // dispatchDisplayHint()
    private boolean mPopupHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.021 -0500", hash_original_field = "D0914C40920996908439839B104BE272", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.025 -0500", hash_original_field = "3140A319F32CA873045621864B655537", hash_generated_field = "3140A319F32CA873045621864B655537")

    int mOverscrollDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.027 -0500", hash_original_field = "F239C82AEB45C28104273F86A78E6F04", hash_generated_field = "F239C82AEB45C28104273F86A78E6F04")

    int mOverflingDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.029 -0500", hash_original_field = "EBA81B43EFC8B93C48CA8AD590604F1F", hash_generated_field = "DBF2847811AC7BE0A78F912706FB3984")

    // Checking one for null is as good as checking both.

    /**
     * Tracks the state of the top edge glow.
     */
    private EdgeEffect mEdgeGlowTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.032 -0500", hash_original_field = "726BFD4CA9E773D9EEEE503CF0DA68EC", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.034 -0500", hash_original_field = "0D94E9EFEC9B4D05871350930D0C92A3", hash_generated_field = "C116882C31FC92381FC21BBC7F61A670")

    private int mFirstPositionDistanceGuess;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.036 -0500", hash_original_field = "8035D2F4D6B03629453FB06C79C39219", hash_generated_field = "0D7647AA84F359D8EC76D4A85F02F8A5")

    private int mLastPositionDistanceGuess;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.037 -0500", hash_original_field = "F9044B9E6268F8B1253C1BE0D189CA6F", hash_generated_field = "BE4199720272019245F0BE0F2D9EF958")

    private int mDirection = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.039 -0500", hash_original_field = "15B11E5CD540C26F3E0D772BCB99122E", hash_generated_field = "D5B94B1CE48D1F35D7827F180B43A659")

    private boolean mForceTranscriptScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.041 -0500", hash_original_field = "991B01A811EB30155A9AFA3991386833", hash_generated_field = "13A0640F3C08F553786642C29E645CCC")

    private int mGlowPaddingLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.043 -0500", hash_original_field = "C886710F46A56EC674804984A472C7D2", hash_generated_field = "9E94FEEAC15232AEE61DC08B2319DDAA")

    private int mGlowPaddingRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.046 -0500", hash_original_field = "0AE9C1A4279BD072F201403DCD3CCE4B", hash_generated_field = "740236379897EF8ABD678F65696A25EA")

    private int mLastAccessibilityScrollEventFromIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.048 -0500", hash_original_field = "15EAB64B9F738CE3B776524FF65E6D3D", hash_generated_field = "9F103C6DB9B3EB29E780CB30462F5591")

    private int mLastAccessibilityScrollEventToIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.050 -0500", hash_original_field = "4F9C4241EE9024683E4B1C2A3BA5C180", hash_generated_field = "4F9C4241EE9024683E4B1C2A3BA5C180")

    boolean mIsAttached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.052 -0500", hash_original_field = "961186D3D26B2460471F5911371126E4", hash_generated_field = "9CAD0235527F91F182E61802511E0DCF")

    private int mLastHandledItemCount;
    
    @DSSafe(DSCat.SAFE_OTHERS)
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

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.064 -0500", hash_original_method = "7DDDAAAF35FACBC75E4AE745F69121D4", hash_generated_method = "4637FB18A2EACE0A46AFED02056DE2C3")
    
public AbsListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.absListViewStyle);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public AbsListView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    //droidsafe hook
    @Override
    public void droidsafeCallbackHook() {
        super.droidsafeCallbackHook();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getCheckedItemCount(){
		return getTaintInt();
		// Original method
		/*
		{
        return mCheckedItemCount;
    }
		*/
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    	SparseBooleanArray sb = new SparseBooleanArray();
    	sb.addTaint(getTaint());
		return sb;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    	long[] la = new long[1];
		return la;
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setItemChecked(int position, boolean value){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override public boolean performItemClick(View view, int position, long id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getChoiceMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mChoiceMode;
    }
		*/
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setMultiChoiceModeListener(MultiChoiceModeListener listener){
		// Original method
        if (mMultiChoiceModeCallback == null) {
            mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        mMultiChoiceModeCallback.setWrapped(listener);
        if (listener != null) {
            ActionMode mode = new ActionMode.SimpleActionMode();

            MenuBuilder builder = new MenuBuilder(getContext());
            //technically we should use the menu from external source
            Menu menu = builder.addSubMenu(DSUtils.FAKE_INT);
            MenuItem item = menu.add(DSUtils.FAKE_INT);
            
            listener.onPrepareActionMode(mode, menu);
            listener.onItemCheckedStateChanged(mode, DSUtils.FAKE_INT,
                    DSUtils.FAKE_INT, DSUtils.UNKNOWN_BOOLEAN);
            listener.onCreateActionMode(mode, menu);
            listener.onActionItemClicked(mode, item); 
            listener.onDestroyActionMode(mode);
        }
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnScrollListener(OnScrollListener l){
		mOnScrollListener = l;  //Preserved
		mOnScrollListener.onScroll(this, DSUtils.FAKE_INT, DSUtils.FAKE_INT,
		        DSUtils.FAKE_INT);
		mOnScrollListener.onScrollStateChanged(this, DSUtils.FAKE_INT);
		// Original method
		/*
		{
        mOnScrollListener = l;
        invokeOnItemScrollListener();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override public Parcelable onSaveInstanceState(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return super.onSaveInstanceState();
	}
    
    @Override public void onRestoreInstanceState(Parcelable state){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence getTextFilter(){
		// Original method
		{
        if (mTextFilterEnabled && mTextFilter != null) {
            return mTextFilter.getText();
        }
        return null;
    }
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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

    /**
     * Subclasses must override this method to layout their children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.238 -0500", hash_original_method = "402FE2CFEE98322FA56302826EFCFBC7", hash_generated_method = "D80DE3D869DDB296835111BED8B895E3")
    
protected void layoutChildren() {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void updateScrollIndicators(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override @ViewDebug.ExportedProperty public View getSelectedView(){
		// Original method
		{
        if (mItemCount > 0 && mSelectedPosition >= 0) {
            return getChildAt(mSelectedPosition - mFirstPosition);
        } else {
            return null;
        }
    }
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getListPaddingTop(){
		// Original method
		/*
		{
        return mListPadding.top;
    }
		*/
		return 0;
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getListPaddingBottom(){
		// Original method
		/*
		{
        return mListPadding.bottom;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getListPaddingLeft(){
		// Original method
		/*
		{
        return mListPadding.left;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getListPaddingRight(){
		// Original method
		/*
		{
        return mListPadding.right;
    }
		*/
		return 0;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    View obtainView(int position, boolean[] isScrap){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        View v = new View(DSOnlyType.DONTCARE);
        v.addTaint(getTaint());
        v.addTaint(position);
        v.addTaint(isScrap[0]);
    	return v;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void positionSelector(int position, View sel){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override protected int getLeftPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingLeft;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override protected int getTopPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : -mPaddingTop;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override protected int getRightPaddingOffset(){
		// Original method
		/*
		{
        return (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK ? 0 : mPaddingRight;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean shouldShowSelector(){
		// Original method
		/*
		{
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSelector(int resID){
		// Original method
		/*
		{
        setSelector(getResources().getDrawable(resID));
    }
		*/
		//Return nothing
	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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

    /**
     * Returns the selector {@link android.graphics.drawable.Drawable} that is used to draw the
     * selection in the list.
     *
     * @return the drawable used to display the selector
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.291 -0500", hash_original_method = "021D90A72F3883D0847A93B24BC54541", hash_generated_method = "5B9462028C894E57F330D82415EC1E27")
    
public Drawable getSelector() {
        return mSelector;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void keyPressed(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.296 -0500", hash_original_method = "130833F22A002ECC6A8AECA69F90873D", hash_generated_method = "ED269748A9C6150210F7674E7A0084AF")
    
public void setScrollIndicators(View up, View down) {
        mScrollUp = up;
        mScrollDown = down;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    	int[] i = new int[1];
		return i;
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
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override protected void onDetachedFromWindow(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override public void onWindowFocusChanged(boolean hasWindowFocus){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    ContextMenuInfo createContextMenuInfo(View view, int position, long id){
		// Original method
		{
        return new AdapterContextMenuInfo(view, position, id);
    }

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.358 -0500", hash_original_method = "9B8E7EBB8FE64DE94387A936F5D592CB", hash_generated_method = "53E16ECA8EACEE71C299F59125A5A5CD")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.363 -0500", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "955E0B0556925E24F9FC8D8714ED67AD")
    
@Override
    protected void dispatchSetPressed(boolean pressed) {
        // Don't dispatch setPressed to our children. We call setPressed on ourselves to
        // get the selector in the right state, but we don't want to press each child.
    }
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean startScrollIfNeeded(int y){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void smoothScrollByOffset(int position){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean trackMotionScroll(int deltaY, int incrementalDeltaY){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    /**
     * Returns the number of header views in the list. Header views are special views
     * at the top of the list that should not be recycled during a layout.
     *
     * @return The number of header views, 0 in the default implementation.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.563 -0500", hash_original_method = "D1E5D38495D64541AC6B328A03DDBBE5", hash_generated_method = "D1E5D38495D64541AC6B328A03DDBBE5")
    
int getHeaderViewsCount() {
        return 0;
    }

    /**
     * Returns the number of footer views in the list. Footer views are special views
     * at the bottom of the list that should not be recycled during a layout.
     *
     * @return The number of footer views, 0 in the default implementation.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.565 -0500", hash_original_method = "0C261F26A2F08E82991D35E703E8BFEF", hash_generated_method = "0C261F26A2F08E82991D35E703E8BFEF")
    
int getFooterViewsCount() {
        return 0;
    }

    /**
     * Fills the gap left open by a touch-scroll. During a touch scroll, children that
     * remain on screen are shifted and the other ones are discarded. The role of this
     * method is to fill the gap thus created by performing a partial layout in the
     * empty space.
     *
     * @param down true if the scroll is going down, false if it is going up
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.567 -0500", hash_original_method = "1A0DD5CAE49B88D0010F0706FE7E6BFB", hash_generated_method = "4064B847A8B2BD327A779F8685BB2922")
    
abstract void fillGap(boolean down);
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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

    /**
     * Find the row closest to y. This row will be used as the motion row when scrolling
     *
     * @param y Where the user touched
     * @return The position of the first (or only) item in the row containing y
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.574 -0500", hash_original_method = "E46451AE22F0145DA5E4FBD96B5A06AA", hash_generated_method = "5B8E607A1EC9D001D7764A42BE7A1A5C")
    
abstract int findMotionRow(int y);
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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

    /**
     * Makes the item at the supplied position selected.
     *
     * @param position the position of the new selection
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.582 -0500", hash_original_method = "298D17F915674885198799233E52EA39", hash_generated_method = "BA596FCCA75DD0D797589AC9E6CEBC56")
    
abstract void setSelectionInt(int position);
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean resurrectSelection(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.192 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.154 -0500", hash_original_field = "C7298A539520D9945816CD36ABAD339C", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.156 -0500", hash_original_field = "0BDE14D7CA4854CAEFC01406C97CEF7F", hash_generated_field = "0BDE14D7CA4854CAEFC01406C97CEF7F")

        long firstId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.158 -0500", hash_original_field = "56346AA9CA8DBF7744AF68AF06173D8A", hash_generated_field = "56346AA9CA8DBF7744AF68AF06173D8A")

        int viewTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.160 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.162 -0500", hash_original_field = "CE84F1587D182C1F0A32D7CD44443A18", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.164 -0500", hash_original_field = "8F36DB7D8F52F07B49D496BF7578B9B0", hash_generated_field = "8F36DB7D8F52F07B49D496BF7578B9B0")

        String filter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.166 -0500", hash_original_field = "5A1FA0BDDD0CC1410D12AF217F54B1FD", hash_generated_field = "5A1FA0BDDD0CC1410D12AF217F54B1FD")

        boolean inActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.168 -0500", hash_original_field = "B7E6911A4E2ECF81E111555BDE3C9E25", hash_generated_field = "B7E6911A4E2ECF81E111555BDE3C9E25")

        int checkedItemCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.170 -0500", hash_original_field = "6CA6AED4CE00926047251B3E7BCD1BAB", hash_generated_field = "6CA6AED4CE00926047251B3E7BCD1BAB")

        SparseBooleanArray checkState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.172 -0500", hash_original_field = "9634971E46A47F441AB88BCA83B02BB2", hash_generated_field = "9634971E46A47F441AB88BCA83B02BB2")

        LongSparseArray<Integer> checkIdState;

        /**
         * Constructor called from {@link AbsListView#onSaveInstanceState()}
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.174 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
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
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
    }
    
    private class WindowRunnnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.321 -0500", hash_original_field = "DC42A5BB5254E69570BD1F4A3686FFB9", hash_generated_field = "C8F22F4E13BEEC60720F9AB64A1792E3")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.331 -0500", hash_original_field = "C001E24B1020A024FC58CC124DF01D4E", hash_generated_field = "C001E24B1020A024FC58CC124DF01D4E")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.443 -0500", hash_original_field = "D1285008815F376C77C6EE6305F1A364", hash_generated_field = "B974BC706FB203D2BBE61C1339EC973E")

        private static final int FLYWHEEL_TIMEOUT = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.432 -0500", hash_original_field = "63F6CA74EEC786DAEE7A49BF47815C33", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

        private  OverScroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.434 -0500", hash_original_field = "AB63A1A1A7695734935B35665D286196", hash_generated_field = "86847DC6149E26E8E3AF7D833983C21E")

        private int mLastFlingY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.440 -0500", hash_original_field = "FA53AA3752A220542656F6683D649C3A", hash_generated_field = "F27C63A86D38808CFF0850988FFA3D30")

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
                    // Keep the fling alive a little longer
                    postDelayed(this, FLYWHEEL_TIMEOUT);
                } else {
                    endFling();
                    mTouchMode = TOUCH_MODE_SCROLL;
                    reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                }
            }
        }; // milliseconds

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.445 -0500", hash_original_method = "361AA84D9C3BD42F341546EA08BE10C6", hash_generated_method = "361AA84D9C3BD42F341546EA08BE10C6")
        
FlingRunnable() {
            mScroller = new OverScroller(getContext());
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        void edgeReached(int delta){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
    }
    
    class PositionScroller implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.473 -0500", hash_original_field = "5D14C8D7590363C2C153C840A2A1ED3D", hash_generated_field = "8760D23EE3F52FD3EFA30CB2F922726A")

        private static final int SCROLL_DURATION = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.476 -0500", hash_original_field = "296EE01C7C0311C8B02942BFFDD37B47", hash_generated_field = "DCF6966CB5E1D949B06701433BC1589F")

        private static final int MOVE_DOWN_POS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.478 -0500", hash_original_field = "06F16CD7849862678B58921CF4795FFE", hash_generated_field = "F5258406C91B10C35A200A14E23D83E8")

        private static final int MOVE_UP_POS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.481 -0500", hash_original_field = "7A2DE3813A48778365FB2AF8FCCD6436", hash_generated_field = "F8253C6298924F79488F04EA928D548B")

        private static final int MOVE_DOWN_BOUND = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.483 -0500", hash_original_field = "47782191A430C8448A0143674DB0EF5D", hash_generated_field = "F7D82C60FE0B843E3D09E43A9DCA6526")

        private static final int MOVE_UP_BOUND = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.486 -0500", hash_original_field = "412335908E26B9D142902A86B90CC3FF", hash_generated_field = "DCC3D3F749A0C671A9C741C7465D6AEC")

        private static final int MOVE_OFFSET = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.488 -0500", hash_original_field = "556F09336B3BD1BEFE7C8BF0B32BAF35", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

        private int mMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.490 -0500", hash_original_field = "900F81C482C1752F828423C9D7263627", hash_generated_field = "35DC5F27F96B58A562B22555A8E37DA2")

        private int mTargetPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.493 -0500", hash_original_field = "D3F84AAA4F3DBDF0EB5F4648C7ED4A58", hash_generated_field = "001157AAC2240D5D9104D4D4F24CB9C2")

        private int mBoundPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.495 -0500", hash_original_field = "C27A8C8D9F8D86137B2AC65649BE90F3", hash_generated_field = "891ABFC466B178DF3188D6BA9AF5BFB7")

        private int mLastSeenPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.497 -0500", hash_original_field = "579A4DCE4B75EEEA4C0FCB251FC8DBB3", hash_generated_field = "0A9D921182A874240E73B3AC5A654444")

        private int mScrollDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.499 -0500", hash_original_field = "C0C7C0666710916615366D090AF17688", hash_generated_field = "6B555669DDE5E4DA69AE4203D3212DA1")

        private  int mExtraScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.501 -0500", hash_original_field = "50FA5CF54DFCB198C915BA9A2C8369DB", hash_generated_field = "D33BBF09949BE3C4FE4DC46E6E79C30E")

        private int mOffsetFromTop;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.504 -0500", hash_original_method = "7F3588C5B47E2E7FF0D768230775AB8B", hash_generated_method = "7F3588C5B47E2E7FF0D768230775AB8B")
        
PositionScroller() {
            mExtraScroll = ViewConfiguration.get(mContext).getScaledFadingEdgeLength();
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        void start(int position){
			addTaint(position);
			mTargetPos = position;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        void start(int position, int boundPosition){
			addTaint(position);
			mTargetPos = position;  //Preserved
			addTaint(boundPosition);
			mBoundPos = boundPosition;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        void startWithOffset(int position, int offset){
			// Original method
			/*
			{
            startWithOffset(position, offset, SCROLL_DURATION);
        }
			*/
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        void startWithOffset(int position, int offset, int duration){
			addTaint(position);
			mTargetPos = position;  //Preserved
			addTaint(offset);
			mOffsetFromTop = offset;  //Preserved
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
    }
    
    class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.923 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }

        @Override public void onChanged(){
            super.onChanged();
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.697 -0500", hash_original_field = "C185E064FA7551549A4C3BD77A97BF8B", hash_generated_field = "8BFC2A3FD2E90E6CAECA368B78AA0988")

        private MultiChoiceModeListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.924 -0400", hash_original_method = "55A4C0C73524FA4BF08CABB1B8DF874B", hash_generated_method = "55A4C0C73524FA4BF08CABB1B8DF874B")
        public MultiChoiceModeWrapper ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.700 -0500", hash_original_method = "57C233A5EDE21FDF3E40ACFA65FCBA6D", hash_generated_method = "3A4C9A8447C9E1CE524D336BDC2DCE5B")
        
public void setWrapped(MultiChoiceModeListener wrapped) {
            mWrapped = wrapped;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.717 -0500", hash_original_field = "943CFBD7D1511435767CCE91EBA9EB7F", hash_generated_field = "D0AF750B588A0A8385D3506BD31A2EB8")

        @ViewDebug.ExportedProperty(category = "list", mapping = {
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_IGNORE, to = "ITEM_VIEW_TYPE_IGNORE"),
            @ViewDebug.IntToString(from = ITEM_VIEW_TYPE_HEADER_OR_FOOTER, to = "ITEM_VIEW_TYPE_HEADER_OR_FOOTER")
        })
        int viewType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.720 -0500", hash_original_field = "53D721DEB7BB85F1327CBE1FEE406FD3", hash_generated_field = "211C82A03CAC4BFE4A39D3AFA73F8466")

        @ViewDebug.ExportedProperty(category = "list")
        boolean recycledHeaderFooter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.722 -0500", hash_original_field = "13C964CADFC4FE4F4A40CFDBE47AB85A", hash_generated_field = "D6FCB86C3CDA915253A7995A3263A2E5")

        @ViewDebug.ExportedProperty(category = "list")
        boolean forceAdd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.724 -0500", hash_original_field = "9656FC663DC419C2046BE7A145261352", hash_generated_field = "9656FC663DC419C2046BE7A145261352")

        int scrappedFromPosition;

        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.726 -0500", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.729 -0500", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A7516D57E99F3298A4CB1C063C44A289")
        
public LayoutParams(int w, int h) {
            super(w, h);
        }
        
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        public LayoutParams(int w, int h, int viewType){
			super(w, h);
			/*
			this.viewType = viewType;
			*/
		}

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.734 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
        @DSSafe(DSCat.SAFE_OTHERS)
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
        
    }
    
    class RecycleBin {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.741 -0500", hash_original_field = "2239C5606E861084F73639EC648775DA", hash_generated_field = "6E808820BD4FD463611A15BFE36E91A3")

        private RecyclerListener mRecyclerListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.743 -0500", hash_original_field = "3D7C5903DFC9662B3B469E5A3B483E18", hash_generated_field = "3638089149F436DC275AC3B59DF7B7C3")

        private int mFirstActivePosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.745 -0500", hash_original_field = "E468A65A50C17BF070CFABD209E07EA9", hash_generated_field = "4E509E23454F116649D54EFD8741D664")

        private View[] mActiveViews = new View[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.747 -0500", hash_original_field = "8F241BE591C36B01BA2D6A02EBB2AD0F", hash_generated_field = "D87C278D091E93A90D61A3043FADF22D")

        private ArrayList<View>[] mScrapViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.749 -0500", hash_original_field = "26263325E40D8E8A9DF7684F6FBDACC0", hash_generated_field = "F891A96632BBCEAB30959FDFBD22CDE9")

        private int mViewTypeCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.752 -0500", hash_original_field = "5108F6980753FDAFFC73407E6C793CFF", hash_generated_field = "6256C7755218C1B9CBEA2B18392BAB2B")

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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        View getActiveView(int position){
			// Original method
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

		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        View getScrapView(int position){
			// Original method
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
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        void addScrapView(View scrap, int position){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        void scrapActiveViews(){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			//Return nothing
		}
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
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
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onScrollStateChanged(AbsListView view, int scrollState);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount);
    }
    
    public interface SelectionBoundsAdjuster {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void adjustListItemSelectionBounds(Rect bounds);
    }
    
    public interface MultiChoiceModeListener extends ActionMode.Callback {
        
        @DSVerified("Called in AbsListView")
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onItemCheckedStateChanged(ActionMode mode,
                int position, long id, boolean checked);
    }
    
    public static interface RecyclerListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onMovedToScrapHeap(View view);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @Override protected boolean isInFilterMode(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mFiltered;
    }
		*/
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean sendToTextFilter(int keyCode, int count, KeyEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @Override public InputConnection onCreateInputConnection(EditorInfo outAttrs){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
   	 if (isTextFilterEnabled()) {
   		createTextFilter(false);
   		return new InputConnectionWrapper(mTextFilter.onCreateInputConnection(outAttrs), true);
   	 }else {
		return null;
   	 }
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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

    /**
     * For our text watcher that is associated with the text filter.  Does
     * nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.639 -0500", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "C4A2617EA21CA54DFBFEDC562D06B870")
    
public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    
    public void onTextChanged(CharSequence s, int start, int before, int count){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * For our text watcher that is associated with the text filter.  Does
     * nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.644 -0500", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "2CA8AA1A2C364C11E3B9B522008CAC9F")
    
public void afterTextChanged(Editable s) {
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
		{
        return new LayoutParams(p);
    }
	}
    
    @Override public LayoutParams generateLayoutParams(AttributeSet attrs){
		// Original method
		{
        return new AbsListView.LayoutParams(getContext(), attrs);
    }
	}
    
    @Override protected boolean checkLayoutParams(ViewGroup.LayoutParams p){
		// Original method
		{
        return p instanceof AbsListView.LayoutParams;
    }

	}
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getTranscriptMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTranscriptMode;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Abstract AbsListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
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

    /**
     * Called back when the adapter disconnects from the RemoteViewsService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:53.684 -0500", hash_original_method = "062C10606C6763A75AEC213E65863835", hash_generated_method = "2A1BDF8455F53C3793A6BB8693DAE109")
    
public void onRemoteAdapterDisconnected() {
        // If the remote adapter disconnects, we keep it around
        // since the currently displayed items are still cached.
        // Further, we want the service to eventually reconnect
        // when necessary, as triggered by this view requesting
        // items from the Adapter.
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
}

