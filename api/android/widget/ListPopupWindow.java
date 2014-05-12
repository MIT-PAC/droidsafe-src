package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ListPopupWindow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.914 -0500", hash_original_field = "9B22868DBB778B77630F608FF41CCE95", hash_generated_field = "0887B70F50539FED12873EB1C34B6CEE")

    private static final String TAG = "ListPopupWindow";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.917 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.919 -0500", hash_original_field = "63E31023FAF651A8B13F7E116CC0E635", hash_generated_field = "F8D801998654223FA4FA41D41E9F5E7A")

    private static final int EXPAND_LIST_TIMEOUT = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.980 -0500", hash_original_field = "5D4DDA54BDBCC4B2BCCBA859119EDD58", hash_generated_field = "513C25DC2079D3E3F448C17AD7E45103")

    public static final int POSITION_PROMPT_ABOVE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.982 -0500", hash_original_field = "22C7D2938BD863FDD9C2E4B7EB8903FA", hash_generated_field = "0DC2E01EB82FA75DF06F7820DDC407FC")

    public static final int POSITION_PROMPT_BELOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.985 -0500", hash_original_field = "187C676C2EF71799F06128D964F264AE", hash_generated_field = "66FD18D4009B660D801EA24128E20B3A")

    public static final int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.987 -0500", hash_original_field = "966C6C7D7E8915D4E16EB7C44380872C", hash_generated_field = "09891BB8998BC15D0579567ED28F8125")

    public static final int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.989 -0500", hash_original_field = "51C805E580F4804E6EB846E2806A998C", hash_generated_field = "25DC4C7F5035D071A009268061A8DECC")

    public static final int INPUT_METHOD_FROM_FOCUSABLE = PopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.992 -0500", hash_original_field = "5234FA127C35862ABEA72AA56D02CE31", hash_generated_field = "BC380AA3102B060D07B4A59A29280852")

    public static final int INPUT_METHOD_NEEDED = PopupWindow.INPUT_METHOD_NEEDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.995 -0500", hash_original_field = "6E80BB3A1EABC6287A401C3AB04C3CE7", hash_generated_field = "B45F005145864928FF3B5CE220951262")

    public static final int INPUT_METHOD_NOT_NEEDED = PopupWindow.INPUT_METHOD_NOT_NEEDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.921 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.924 -0500", hash_original_field = "7E4C7D8A72122A6640DF0AA884C2245D", hash_generated_field = "DD5B28EB4059D1AC7E72BAEDE50FACDF")

    private PopupWindow mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.926 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.928 -0500", hash_original_field = "D2EA713CFF74C79305B1A85CAA4758A3", hash_generated_field = "680F69659AC661E81526EC1B57AD0760")

    private DropDownListView mDropDownList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.930 -0500", hash_original_field = "47629D9301A11E5A90DB7FD16C630178", hash_generated_field = "95C5FD2B2227A2419A547D55212619CB")

    private int mDropDownHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.932 -0500", hash_original_field = "1FBF54D200826BE24A98634613FB66C2", hash_generated_field = "DE8B8CD76D1AB415FF96E39AF3C5D34E")

    private int mDropDownWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.934 -0500", hash_original_field = "F488E81DEDCF27807554F505CB261AEB", hash_generated_field = "E0B55CC77CB214A3579F9BF96330095D")

    private int mDropDownHorizontalOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.936 -0500", hash_original_field = "34094FADF72E1CFF7A6E4691913199A5", hash_generated_field = "3B23099D02FB8FF58FFC662868C0BB03")

    private int mDropDownVerticalOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.938 -0500", hash_original_field = "B50C09E974CBAB52C3A2CAAC73824C09", hash_generated_field = "EF2837EA9E1F32EA5B98F304DCD2B02D")

    private boolean mDropDownVerticalOffsetSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.940 -0500", hash_original_field = "E408A4A94243B7CFBFDDDE18659D6637", hash_generated_field = "A2A88CD1765159B88DD7DB6DD2826AA7")

    private boolean mDropDownAlwaysVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.943 -0500", hash_original_field = "38CCFB5B729C0D1016E8CD1FEEC6A290", hash_generated_field = "D1BD29312DE39A83C4D6D5BDC2010A61")

    private boolean mForceIgnoreOutsideTouch = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.945 -0500", hash_original_field = "B5EDBF08EC87E5E419CCBD4768539463", hash_generated_field = "B5EDBF08EC87E5E419CCBD4768539463")

    int mListItemExpandMaximum = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.947 -0500", hash_original_field = "5449FEC726829211DD8244A31A4FD026", hash_generated_field = "5F49A121459BF7DF82F93F51F66D9AFA")

    private View mPromptView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.949 -0500", hash_original_field = "CC2799DFE9A02CE4FAA05B620FA5203C", hash_generated_field = "D0EDBCF4B24F722A68C83DBD4FA7D38D")

    private int mPromptPosition = POSITION_PROMPT_ABOVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.952 -0500", hash_original_field = "7F4E88E932CA04F746195B78340FAF19", hash_generated_field = "3BA4BCC5F225A10F755FE4D117871D40")

    private DataSetObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.954 -0500", hash_original_field = "9E0D6B2D2C41BFB970F7F40314CA67CA", hash_generated_field = "0AD13AB5208CE821A0A2BF31AEC73CB4")

    private View mDropDownAnchorView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.956 -0500", hash_original_field = "CF26749AC69E503F0E6CEE9E8D3F679D", hash_generated_field = "D7FBC36DD90F3884476AF7A145F7D085")

    private Drawable mDropDownListHighlight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.957 -0500", hash_original_field = "C3BCFE8177AEF338D4004A6DD4D2D8EF", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.959 -0500", hash_original_field = "95D49B221C26B1A3334D3BD6A6E6E61A", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.961 -0500", hash_original_field = "870EB41A3AD8AF770D57D2B2C2386419", hash_generated_field = "821F70C70BBBE64322F054DCBDCBD65D")

    private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.964 -0500", hash_original_field = "9EC385C13CED9DB47D8864C0559278A1", hash_generated_field = "C2DF6DA91E71FE1B73AF2F99DA491C65")

    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.966 -0500", hash_original_field = "3770B47A24DD321648564621CF0B3704", hash_generated_field = "7119F706A3F3F75D0AB9F70CFDF2D458")

    private final PopupScrollListener mScrollListener = new PopupScrollListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.969 -0500", hash_original_field = "E2D3F2C921CE1BBE9E4E348336B0A9D5", hash_generated_field = "368F7081BBFDFED86D539FFD5855A591")

    private final ListSelectorHider mHideSelector = new ListSelectorHider();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.971 -0500", hash_original_field = "AF08E013791944040F11EFFF718596A9", hash_generated_field = "61A25C839F09B3FC31C414DE40E67DB5")

    private Runnable mShowDropDownRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.973 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.975 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.977 -0500", hash_original_field = "35472579238A24390A4D232395567A7B", hash_generated_field = "2CBF8E91F49F039C5D23189C3E7CE590")

    private boolean mModal;

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter.
     * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
     * 
     * @param context Context used for contained views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:09.998 -0500", hash_original_method = "EE0C6E46788D5D6F0175B90B5CCF0B4A", hash_generated_method = "535CA03881CAD22B0A89513673AF3B8F")
    
public ListPopupWindow(Context context) {
        this(context, null, com.android.internal.R.attr.listPopupWindowStyle, 0);
    }

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter.
     * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
     * 
     * @param context Context used for contained views.
     * @param attrs Attributes from inflating parent views used to style the popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.000 -0500", hash_original_method = "C9E1E41EEB8F4220F08A0D28BC21C4EB", hash_generated_method = "C90B7B3E3C36EA2768CA911D5D6C683C")
    
public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.listPopupWindowStyle, 0);
    }

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter.
     * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
     * 
     * @param context Context used for contained views.
     * @param attrs Attributes from inflating parent views used to style the popup.
     * @param defStyleAttr Default style attribute to use for popup content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.002 -0500", hash_original_method = "449FC27C9387B8AAB93C584A7B8B7579", hash_generated_method = "EFE43904AE9BD6D7C666FED663E7B3AC")
    
public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * Create a new, empty popup window capable of displaying items from a ListAdapter.
     * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
     * 
     * @param context Context used for contained views.
     * @param attrs Attributes from inflating parent views used to style the popup.
     * @param defStyleAttr Style attribute to read for default styling of popup content.
     * @param defStyleRes Style resource ID to use for default styling of popup content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.005 -0500", hash_original_method = "F8B1DB93A85ECDB9C2D2CE8639D222AE", hash_generated_method = "F9BE63A12D428EA88A5D5BC27912D4D7")
    
public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
    }

    /**
     * Sets the adapter that provides the data and the views to represent the data
     * in this popup window.
     *
     * @param adapter The adapter to use to create this window's content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.007 -0500", hash_original_method = "B55D1F7EE07C2CDF60B7B314069C1E48", hash_generated_method = "B764CB836CA397C20E9F89EB820E1329")
    
public void setAdapter(ListAdapter adapter) {
        if (mObserver == null) {
            mObserver = new PopupDataSetObserver();
        } else if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mObserver);
        }
        mAdapter = adapter;
        if (mAdapter != null) {
            adapter.registerDataSetObserver(mObserver);
        }
        
        if (mDropDownList != null) {
            mDropDownList.setAdapter(mAdapter);
        }
    }

    /**
     * Set where the optional prompt view should appear. The default is
     * {@link #POSITION_PROMPT_ABOVE}.
     * 
     * @param position A position constant declaring where the prompt should be displayed.
     * 
     * @see #POSITION_PROMPT_ABOVE
     * @see #POSITION_PROMPT_BELOW
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.009 -0500", hash_original_method = "7CC61A3797371517F86E3D676D22847C", hash_generated_method = "F9B7E352B31FDFA171B19567C2207FC5")
    
public void setPromptPosition(int position) {
        mPromptPosition = position;
    }

    /**
     * @return Where the optional prompt view should appear.
     * 
     * @see #POSITION_PROMPT_ABOVE
     * @see #POSITION_PROMPT_BELOW
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.012 -0500", hash_original_method = "DF9D97B46096A1E4CCF9033CE8B43A47", hash_generated_method = "ED70513AB0BFFA1311B014B32D36D7DC")
    
public int getPromptPosition() {
        return mPromptPosition;
    }

    /**
     * Set whether this window should be modal when shown.
     * 
     * <p>If a popup window is modal, it will receive all touch and key input.
     * If the user touches outside the popup window's content area the popup window
     * will be dismissed.
     * 
     * @param modal {@code true} if the popup window should be modal, {@code false} otherwise.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.014 -0500", hash_original_method = "320A57FA9129485B3F1A01EDA8808ED5", hash_generated_method = "6C2C1410866D1D61A1A62A8C0391C92E")
    
public void setModal(boolean modal) {
        mModal = true;
        mPopup.setFocusable(modal);
    }

    /**
     * Returns whether the popup window will be modal when shown.
     * 
     * @return {@code true} if the popup window will be modal, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.016 -0500", hash_original_method = "195244B0122E9C532D039816F791192C", hash_generated_method = "E010DC4AD1AE58BC0D2925422A5D303B")
    
public boolean isModal() {
        return mModal;
    }

    /**
     * Forces outside touches to be ignored. Normally if {@link #isDropDownAlwaysVisible()} is
     * false, we allow outside touch to dismiss the dropdown. If this is set to true, then we
     * ignore outside touch even when the drop down is not set to always visible.
     * 
     * @hide Used only by AutoCompleteTextView to handle some internal special cases.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.018 -0500", hash_original_method = "B51F6D3B2B582EB2529861E286FFBDAA", hash_generated_method = "3174FFB3813C26E1F0A01179B54B8139")
    
public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    /**
     * Sets whether the drop-down should remain visible under certain conditions.
     *
     * The drop-down will occupy the entire screen below {@link #getAnchorView} regardless
     * of the size or content of the list.  {@link #getBackground()} will fill any space
     * that is not used by the list.
     *
     * @param dropDownAlwaysVisible Whether to keep the drop-down visible.
     *
     * @hide Only used by AutoCompleteTextView under special conditions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.020 -0500", hash_original_method = "0D7558B683A811B4FB459E3A92DCFACB", hash_generated_method = "CF697164CB7A979E67CC23BB02F0C16F")
    
public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    /**
     * @return Whether the drop-down is visible under special conditions.
     *
     * @hide Only used by AutoCompleteTextView under special conditions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.022 -0500", hash_original_method = "452BC62A357E5A143092E81C66B09D6A", hash_generated_method = "D16C0015621EAF41B3CE3173EE0781BF")
    
public boolean isDropDownAlwaysVisible() {
        return mDropDownAlwaysVisible;
    }

    /**
     * Sets the operating mode for the soft input area.
     *
     * @param mode The desired mode, see
     *        {@link android.view.WindowManager.LayoutParams#softInputMode}
     *        for the full list
     *
     * @see android.view.WindowManager.LayoutParams#softInputMode
     * @see #getSoftInputMode()
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.024 -0500", hash_original_method = "E80B835CA17A4D3E815EC079FA1EE953", hash_generated_method = "6F33DB8F703DFF6D3352DF67AA4D9723")
    
public void setSoftInputMode(int mode) {
        mPopup.setSoftInputMode(mode);
    }

    /**
     * Returns the current value in {@link #setSoftInputMode(int)}.
     *
     * @see #setSoftInputMode(int)
     * @see android.view.WindowManager.LayoutParams#softInputMode
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.026 -0500", hash_original_method = "EF5235E70AE7C9521CFD0F4410B9073C", hash_generated_method = "34F28FB52B6DAFF7E76E087895AE72A9")
    
public int getSoftInputMode() {
        return mPopup.getSoftInputMode();
    }

    /**
     * Sets a drawable to use as the list item selector.
     * 
     * @param selector List selector drawable to use in the popup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.029 -0500", hash_original_method = "00D6E099D8DC922D12B17B03F893B884", hash_generated_method = "383695E39099FD03667C952B7D41FE4A")
    
public void setListSelector(Drawable selector) {
        mDropDownListHighlight = selector;
    }

    /**
     * @return The background drawable for the popup window.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.031 -0500", hash_original_method = "48A20BD7A1656DF8848E524613AD69C1", hash_generated_method = "8361F633C9EE2A209A5F0E8043587AC9")
    
public Drawable getBackground() {
        return mPopup.getBackground();
    }

    /**
     * Sets a drawable to be the background for the popup window.
     * 
     * @param d A drawable to set as the background.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.033 -0500", hash_original_method = "53EE8E67A046C4A20122C0C008F8CCAA", hash_generated_method = "3F2D5FAE7B7F15768348E05BF53B40CD")
    
public void setBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
    }

    /**
     * Set an animation style to use when the popup window is shown or dismissed.
     * 
     * @param animationStyle Animation style to use.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.035 -0500", hash_original_method = "CF4F09D135A7A5849055A447382D076E", hash_generated_method = "51C2A0238784BAF4CD2E35C1C31D1F1C")
    
public void setAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
    }

    /**
     * Returns the animation style that will be used when the popup window is
     * shown or dismissed.
     * 
     * @return Animation style that will be used.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.037 -0500", hash_original_method = "A53F654A1BF514C432C9F43DB9ED5E7B", hash_generated_method = "1306DC89DF94081356E55A19EE8661CD")
    
public int getAnimationStyle() {
        return mPopup.getAnimationStyle();
    }

    /**
     * Returns the view that will be used to anchor this popup.
     * 
     * @return The popup's anchor view
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.040 -0500", hash_original_method = "875C75F19631B214BE64A011FD6A41E4", hash_generated_method = "018CCB43785B73150669A8D96162E023")
    
public View getAnchorView() {
        return mDropDownAnchorView;
    }

    /**
     * Sets the popup's anchor view. This popup will always be positioned relative to
     * the anchor view when shown.
     * 
     * @param anchor The view to use as an anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.042 -0500", hash_original_method = "91753F7FEC6E3180927B7B9D55B8E090", hash_generated_method = "05957B93E91DF796FD2FC16581760FF3")
    
public void setAnchorView(View anchor) {
        mDropDownAnchorView = anchor;
    }

    /**
     * @return The horizontal offset of the popup from its anchor in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.044 -0500", hash_original_method = "2C5F7D64A15BDC64E0A7D1677E996184", hash_generated_method = "13EFA9158560F614588B8F5CF120A6A9")
    
public int getHorizontalOffset() {
        return mDropDownHorizontalOffset;
    }

    /**
     * Set the horizontal offset of this popup from its anchor view in pixels.
     * 
     * @param offset The horizontal offset of the popup from its anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.046 -0500", hash_original_method = "37914D7AC2B7A80AA5FE528B058A9DBC", hash_generated_method = "9895E3FFBA6000436D485FAD8DC69D5D")
    
public void setHorizontalOffset(int offset) {
        mDropDownHorizontalOffset = offset;
    }

    /**
     * @return The vertical offset of the popup from its anchor in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.048 -0500", hash_original_method = "06BDE5646BE562A7D86252C676418C82", hash_generated_method = "DA7FAA8E025244FD39561BA6F341391F")
    
public int getVerticalOffset() {
        if (!mDropDownVerticalOffsetSet) {
            return 0;
        }
        return mDropDownVerticalOffset;
    }

    /**
     * Set the vertical offset of this popup from its anchor view in pixels.
     * 
     * @param offset The vertical offset of the popup from its anchor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.050 -0500", hash_original_method = "F61671411958DBF85FB58F84EEE162C4", hash_generated_method = "F2E0C247361B54640FD6BE9AB2AD3808")
    
public void setVerticalOffset(int offset) {
        mDropDownVerticalOffset = offset;
        mDropDownVerticalOffsetSet = true;
    }

    /**
     * @return The width of the popup window in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.052 -0500", hash_original_method = "6205F90E667ADE4444482E9AC195FB48", hash_generated_method = "52ADB8330CF1D99BDB9100B431908C2D")
    
public int getWidth() {
        return mDropDownWidth;
    }

    /**
     * Sets the width of the popup window in pixels. Can also be {@link #MATCH_PARENT}
     * or {@link #WRAP_CONTENT}.
     * 
     * @param width Width of the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.054 -0500", hash_original_method = "1FDBBF009B47D57DAE1EE309EAA8DA19", hash_generated_method = "8822955A1449CC5CD1B2A22976B7B662")
    
public void setWidth(int width) {
        mDropDownWidth = width;
    }

    /**
     * Sets the width of the popup window by the size of its content. The final width may be
     * larger to accommodate styled window dressing.
     *
     * @param width Desired width of content in pixels.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.057 -0500", hash_original_method = "1CC81B1489D8EBDAA358E87EA72284F9", hash_generated_method = "B7561C3A7CA7F311BEEA8084196A7B42")
    
public void setContentWidth(int width) {
        Drawable popupBackground = mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + width;
        } else {
            setWidth(width);
        }
    }

    /**
     * @return The height of the popup window in pixels.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.059 -0500", hash_original_method = "2B0617362C23A2A1F29E0E83641579F9", hash_generated_method = "D37B95D83D167F9C4FBCCC7EF8DB8E0F")
    
public int getHeight() {
        return mDropDownHeight;
    }

    /**
     * Sets the height of the popup window in pixels. Can also be {@link #MATCH_PARENT}.
     * 
     * @param height Height of the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.062 -0500", hash_original_method = "CAA84DCA25312E828BE740B15493FB25", hash_generated_method = "1307ECD2360B8192F17D2690E76D1BD3")
    
public void setHeight(int height) {
        mDropDownHeight = height;
    }

    /**
     * Sets a listener to receive events when a list item is clicked.
     * 
     * @param clickListener Listener to register
     * 
     * @see ListView#setOnItemClickListener(android.widget.AdapterView.OnItemClickListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.064 -0500", hash_original_method = "500645EE5CDA87E171AAE4D175AC763E", hash_generated_method = "4F93B27CDA566E1947C562DDACAB23C1")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        mItemClickListener = clickListener;
        if (clickListener != null) {
            AdapterView<?> a = (AdapterView<?>)getListView();
            clickListener.onItemClick(a, new View(DSOnlyType.NOT_VALID), DSUtils.FAKE_INT,
                    (long)DSUtils.FAKE_INT);
        }
    }

    /**
     * Sets a listener to receive events when a list item is selected.
     * 
     * @param selectedListener Listener to register.
     * 
     * @see ListView#setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.066 -0500", hash_original_method = "77C1F384A6316C978289202E5719DEEE", hash_generated_method = "080AB42266AF6BB9870333E8AD2B5DFF")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        mItemSelectedListener = selectedListener;
        if (selectedListener != null) {
            AdapterView<?> a = (AdapterView<?>)getListView();
            selectedListener.onItemSelected(a, new View(DSOnlyType.NOT_VALID), DSUtils.FAKE_INT, DSUtils.FAKE_INT);
            selectedListener.onNothingSelected(a);
        }
    }

    /**
     * Set a view to act as a user prompt for this popup window. Where the prompt view will appear
     * is controlled by {@link #setPromptPosition(int)}.
     * 
     * @param prompt View to use as an informational prompt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.068 -0500", hash_original_method = "F870D6C36930B52993EA962C5CEE4741", hash_generated_method = "9316FBCE25514633177B4C3FB50BD709")
    
public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    /**
     * Post a {@link #show()} call to the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.070 -0500", hash_original_method = "6F8BB8AB5CFBCAF655CCF7F8C4D42CCD", hash_generated_method = "348EE165671531E3C9C5D9CD3C8DCFB4")
    
public void postShow() {
        mHandler.post(mShowDropDownRunnable);
    }

    /**
     * Show the popup list. If the list is already showing, this method
     * will recalculate the popup's size and position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.074 -0500", hash_original_method = "B0532D10D967B708828191A62293AA30", hash_generated_method = "782FFA21521B093AB9681D590628F82A")
    
public void show() {
        int height = buildDropDown();

        int widthSpec = 0;
        int heightSpec = 0;

        boolean noInputMethod = isInputMethodNotNeeded();
        mPopup.setAllowScrollingAnchorParent(!noInputMethod);

        if (mPopup.isShowing()) {
            if (mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT) {
                // The call to PopupWindow's update method below can accept -1 for any
                // value you do not want to update.
                widthSpec = -1;
            } else if (mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
                widthSpec = getAnchorView().getWidth();
            } else {
                widthSpec = mDropDownWidth;
            }

            if (mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT) {
                // The call to PopupWindow's update method below can accept -1 for any
                // value you do not want to update.
                heightSpec = noInputMethod ? height : ViewGroup.LayoutParams.MATCH_PARENT;
                if (noInputMethod) {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0, 0);
                } else {
                    mPopup.setWindowLayoutMode(
                            mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT ?
                                    ViewGroup.LayoutParams.MATCH_PARENT : 0,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                }
            } else if (mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT) {
                heightSpec = height;
            } else {
                heightSpec = mDropDownHeight;
            }

            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);

            mPopup.update(getAnchorView(), mDropDownHorizontalOffset,
                    mDropDownVerticalOffset, widthSpec, heightSpec);
        } else {
            if (mDropDownWidth == ViewGroup.LayoutParams.MATCH_PARENT) {
                widthSpec = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                if (mDropDownWidth == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    mPopup.setWidth(getAnchorView().getWidth());
                } else {
                    mPopup.setWidth(mDropDownWidth);
                }
            }

            if (mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT) {
                heightSpec = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                if (mDropDownHeight == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    mPopup.setHeight(height);
                } else {
                    mPopup.setHeight(mDropDownHeight);
                }
            }

            mPopup.setWindowLayoutMode(widthSpec, heightSpec);
            mPopup.setClipToScreenEnabled(true);
            
            // use outside touchable to dismiss drop down when touching outside of it, so
            // only set this if the dropdown is not always visible
            mPopup.setOutsideTouchable(!mForceIgnoreOutsideTouch && !mDropDownAlwaysVisible);
            mPopup.setTouchInterceptor(mTouchInterceptor);
            mPopup.showAsDropDown(getAnchorView(),
                    mDropDownHorizontalOffset, mDropDownVerticalOffset);
            mDropDownList.setSelection(ListView.INVALID_POSITION);
            
            if (!mModal || mDropDownList.isInTouchMode()) {
                clearListSelection();
            }
            if (!mModal) {
                mHandler.post(mHideSelector);
            }
        }
    }

    /**
     * Dismiss the popup window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.076 -0500", hash_original_method = "B4B1B4676A26C0E0D07AD81974E2090B", hash_generated_method = "50D7A428D0408225B9A85847B875AC8B")
    
public void dismiss() {
        mPopup.dismiss();
        removePromptView();
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
    }

    /**
     * Set a listener to receive a callback when the popup is dismissed.
     *
     * @param listener Listener that will be notified when the popup is dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.078 -0500", hash_original_method = "C7BE29500BF4339E2FDC892E2A139524", hash_generated_method = "5C97EF6AB530266F013AE5B9157C4053")
    
public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mPopup.setOnDismissListener(listener);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.080 -0500", hash_original_method = "202D4492803683737094012DDF6DD86F", hash_generated_method = "3AA7D4B2D9BCE578A6C1E3296F0D706C")
    
private void removePromptView() {
        if (mPromptView != null) {
            final ViewParent parent = mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                final ViewGroup group = (ViewGroup) parent;
                group.removeView(mPromptView);
            }
        }
    }

    /**
     * Control how the popup operates with an input method: one of
     * {@link #INPUT_METHOD_FROM_FOCUSABLE}, {@link #INPUT_METHOD_NEEDED},
     * or {@link #INPUT_METHOD_NOT_NEEDED}.
     * 
     * <p>If the popup is showing, calling this method will take effect only
     * the next time the popup is shown or through a manual call to the {@link #show()}
     * method.</p>
     * 
     * @see #getInputMethodMode()
     * @see #show()
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.082 -0500", hash_original_method = "288B7DB6446AD4FA82AB3ACE9506A35B", hash_generated_method = "664404492444FE4EDB8C9EF235897445")
    
public void setInputMethodMode(int mode) {
        mPopup.setInputMethodMode(mode);
    }

    /**
     * Return the current value in {@link #setInputMethodMode(int)}.
     * 
     * @see #setInputMethodMode(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.085 -0500", hash_original_method = "341CBB053B214C5E0FB1B54637325DA3", hash_generated_method = "E24A5236B5374EA3523D770364798036")
    
public int getInputMethodMode() {
        return mPopup.getInputMethodMode();
    }

    /**
     * Set the selected position of the list.
     * Only valid when {@link #isShowing()} == {@code true}.
     * 
     * @param position List position to set as selected.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.087 -0500", hash_original_method = "119CA9359C56E2DDD442B9A05EFE812C", hash_generated_method = "3B3BC52D181D5841E7CE1A55B23BB93A")
    
public void setSelection(int position) {
        DropDownListView list = mDropDownList;
        if (isShowing() && list != null) {
            list.mListSelectionHidden = false;
            list.setSelection(position);
            if (list.getChoiceMode() != ListView.CHOICE_MODE_NONE) {
                list.setItemChecked(position, true);
            }
        }
    }

    /**
     * Clear any current list selection.
     * Only valid when {@link #isShowing()} == {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.089 -0500", hash_original_method = "5E25633D1BEAE372BF50698DAAA66CA7", hash_generated_method = "13576BB7F7329A5DDF2A41719C2C05F4")
    
public void clearListSelection() {
        final DropDownListView list = mDropDownList;
        if (list != null) {
            // WARNING: Please read the comment where mListSelectionHidden is declared
            list.mListSelectionHidden = true;
            list.hideSelector();
            list.requestLayout();
        }
    }

    /**
     * @return {@code true} if the popup is currently showing, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.092 -0500", hash_original_method = "CA9C4C0CD645F38E1AAA797FE00ECFCE", hash_generated_method = "A74A360685D68080E9B081E8BB4886F7")
    
public boolean isShowing() {
        return mPopup.isShowing();
    }

    /**
     * @return {@code true} if this popup is configured to assume the user does not need
     * to interact with the IME while it is showing, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.094 -0500", hash_original_method = "C5EEC00F4CE1C916DAF561B7CF397229", hash_generated_method = "304924423F1B5B5A901202A22B2D39F6")
    
public boolean isInputMethodNotNeeded() {
        return mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED;
    }

    /**
     * Perform an item click operation on the specified list adapter position.
     * 
     * @param position Adapter position for performing the click
     * @return true if the click action could be performed, false if not.
     *         (e.g. if the popup was not showing, this method would return false.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.096 -0500", hash_original_method = "5D56F9149CAA09C31AB36A31C90B128D", hash_generated_method = "AE20ADFEF2EF4BCDBDC5219F11D53EF7")
    
public boolean performItemClick(int position) {
        if (isShowing()) {
            if (mItemClickListener != null) {
                final DropDownListView list = mDropDownList;
                final View child = list.getChildAt(position - list.getFirstVisiblePosition());
                final ListAdapter adapter = list.getAdapter();
                mItemClickListener.onItemClick(list, child, position, adapter.getItemId(position));
            }
            return true;
        }
        return false;
    }
    
    private static class DropDownListView extends ListView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.135 -0500", hash_original_field = "D20F3A87D43862A7B37B125A3FEE7F98", hash_generated_field = "23928DA4DE83E1135FB8A9793C3625F7")

        private static final String TAG = ListPopupWindow.TAG + ".DropDownListView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.137 -0500", hash_original_field = "9E91D73F2D56D01A7B3EAC2472AE2C6F", hash_generated_field = "3F3C05952474F71A545A45E3C3CCA4F6")

        private boolean mListSelectionHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.139 -0500", hash_original_field = "0471724893E35540EA0391951CEF0974", hash_generated_field = "527E1B04AF4AD8C6C618A0336B748CF0")

        private boolean mHijackFocus;

        /**
         * <p>Creates a new list view wrapper.</p>
         *
         * @param context this view's context
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.142 -0500", hash_original_method = "BBC42F17FDBB7B5F7851EFDC7F6F1B4C", hash_generated_method = "8ACB45F234E9095A9AEF51B97D5E5D8A")
        
public DropDownListView(Context context, boolean hijackFocus) {
            super(context, null, com.android.internal.R.attr.dropDownListViewStyle);
            mHijackFocus = hijackFocus;
            // TODO: Add an API to control this
            setCacheColorHint(0); // Transparent, since the background drawable could be anything.
        }

        /**
         * <p>Avoids jarring scrolling effect by ensuring that list elements
         * made of a text view fit on a single line.</p>
         *
         * @param position the item index in the list to get a view for
         * @return the view for the specified item
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.144 -0500", hash_original_method = "3F1E6A7533EB0FC6DBDDA209BB95D590", hash_generated_method = "5B1E71941BEC4631C343B211F7143977")
        
@Override
        View obtainView(int position, boolean[] isScrap) {
            View view = super.obtainView(position, isScrap);

            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(true);
            }

            return view;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.147 -0500", hash_original_method = "4691130934AB8C0281F78748C377FD01", hash_generated_method = "5635BEFC456639E758A346DB28420B77")
        
@Override
        public boolean isInTouchMode() {
            // WARNING: Please read the comment where mListSelectionHidden is declared
            return (mHijackFocus && mListSelectionHidden) || super.isInTouchMode();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.150 -0500", hash_original_method = "561EA8BFAB26A78C0A50D34CA2B435FA", hash_generated_method = "468FFE45110A504986317139157A6B4F")
        
@Override
        public boolean hasWindowFocus() {
            return mHijackFocus || super.hasWindowFocus();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.152 -0500", hash_original_method = "C2BF4E069A702887BC745C139DC71739", hash_generated_method = "AD9FA9DCAB55E98576D3E8A5D1496AF0")
        
@Override
        public boolean isFocused() {
            return mHijackFocus || super.isFocused();
        }

        /**
         * <p>Returns the focus state in the drop down.</p>
         *
         * @return true always if hijacking focus
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.154 -0500", hash_original_method = "1102992DDCFDFABDAA31FDFA580154D8", hash_generated_method = "41F703DC5FE9C3F800A12C7C5F5E495F")
        
@Override
        public boolean hasFocus() {
            return mHijackFocus || super.hasFocus();
        }
    }
    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.726 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.159 -0500", hash_original_method = "6E4DA5A5D077D6C0AA24FD2BF6BDF53A", hash_generated_method = "43AD078EA30F732A83D9ACE08BA25F54")
        
@Override
        public void onChanged() {
            if (isShowing()) {
                // Resize the popup to fit new content
                show();
            }
        }
        
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.162 -0500", hash_original_method = "BEB5883597D4F7E6EC69D5E4B00F4808", hash_generated_method = "F3E9793446B00E60EB5817FCD52182CB")
        
@Override
        public void onInvalidated() {
            dismiss();
        }
        
    }
    
    private class ListSelectorHider implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.726 -0400", hash_original_method = "850B001590E034AECBB57C89D4E5B01F", hash_generated_method = "850B001590E034AECBB57C89D4E5B01F")
        public ListSelectorHider ()
        {
            //Synthesized constructor
        }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.167 -0500", hash_original_method = "9AD729468BC88951DC9B447B72E180D0", hash_generated_method = "E9D4DFD4407D27ED24BD11596FAD7F2A")
        
public void run() {
            clearListSelection();
        }
        
    }
    
    private class ResizePopupRunnable implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.726 -0400", hash_original_method = "3BE1DF808B5AE0104DCA795D143316E5", hash_generated_method = "3BE1DF808B5AE0104DCA795D143316E5")
        public ResizePopupRunnable ()
        {
            //Synthesized constructor
        }
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.171 -0500", hash_original_method = "A0D6625363C0412112380631C620D963", hash_generated_method = "CB17003C1F1C5E3D173A611277EC7873")
        
public void run() {
            if (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() &&
                    mDropDownList.getChildCount() <= mListItemExpandMaximum) {
                mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                show();
            }
        }
        
    }
    
    /**
     * Abstract class that forwards touch events to a {@link ListPopupWindow}.
     *
     * @hide
     */
    public static abstract class ForwardingListener
            implements View.OnTouchListener, View.OnAttachStateChangeListener {
        /** Scaled touch slop, used for detecting movement outside bounds. */
        private final float mScaledTouchSlop;

        /** Timeout before disallowing intercept on the source's parent. */
        private final int mTapTimeout;

        /** Source view from which events are forwarded. */
        private final View mSrc;

        /** Runnable used to prevent conflicts with scrolling parents. */
        private Runnable mDisallowIntercept;

        /** Whether this listener is currently forwarding touch events. */
        private boolean mForwarding;

        /** The id of the first pointer down in the current event stream. */
        private int mActivePointerId;

        public ForwardingListener(View src) {
            mSrc = src;
            /*
            mScaledTouchSlop = ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
            mTapTimeout = ViewConfiguration.getTapTimeout();
            */
            mScaledTouchSlop = DSUtils.UNKNOWN_FLOAT;
            mTapTimeout = DSUtils.FAKE_INT;
            src.addOnAttachStateChangeListener(this);
        }

        /**
         * Returns the popup to which this listener is forwarding events.
         * <p>
         * Override this to return the correct popup. If the popup is displayed
         * asynchronously, you may also need to override
         * {@link #onForwardingStopped} to prevent premature cancelation of
         * forwarding.
         *
         * @return the popup to which this listener is forwarding events
         */
        public abstract ListPopupWindow getPopup();

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final boolean wasForwarding = mForwarding;
            final boolean forwarding;
            if (wasForwarding) {
                forwarding = onTouchForwarded(event) || !onForwardingStopped();
            } else {
                forwarding = onTouchObserved(event) && onForwardingStarted();
            }

            mForwarding = forwarding;
            return forwarding || wasForwarding;
        }

        @Override
        public void onViewAttachedToWindow(View v) {
        }

        @Override
        public void onViewDetachedFromWindow(View v) {
            mForwarding = false;
            mActivePointerId = MotionEvent.INVALID_POINTER_ID;

            if (mDisallowIntercept != null) {
                mSrc.removeCallbacks(mDisallowIntercept);
            }
        }

        /**
         * Called when forwarding would like to start.
         * <p>
         * By default, this will show the popup returned by {@link #getPopup()}.
         * It may be overridden to perform another action, like clicking the
         * source view or preparing the popup before showing it.
         *
         * @return true to start forwarding, false otherwise
         */
        protected boolean onForwardingStarted() {
            final ListPopupWindow popup = getPopup();
            if (popup != null && !popup.isShowing()) {
                popup.show();
            }
            return true;
        }

        /**
         * Called when forwarding would like to stop.
         * <p>
         * By default, this will dismiss the popup returned by
         * {@link #getPopup()}. It may be overridden to perform some other
         * action.
         *
         * @return true to stop forwarding, false otherwise
         */
        protected boolean onForwardingStopped() {
            final ListPopupWindow popup = getPopup();
            if (popup != null && popup.isShowing()) {
                popup.dismiss();
            }
            return true;
        }

        /**
         * Observes motion events and determines when to start forwarding.
         *
         * @param srcEvent motion event in source view coordinates
         * @return true to start forwarding motion events, false otherwise
         */
        private boolean onTouchObserved(MotionEvent srcEvent) {
            final View src = mSrc;
            if (!src.isEnabled()) {
                return false;
            }

            final int actionMasked = srcEvent.getActionMasked();
            switch (actionMasked) {
                case MotionEvent.ACTION_DOWN:
                    mActivePointerId = srcEvent.getPointerId(0);
                    if (mDisallowIntercept == null) {
                        mDisallowIntercept = new DisallowIntercept();
                    }
                    src.postDelayed(mDisallowIntercept, mTapTimeout);
                    break;
                case MotionEvent.ACTION_MOVE:
                    final int activePointerIndex = srcEvent.findPointerIndex(mActivePointerId);
                    if (activePointerIndex >= 0) {
                        final float x = srcEvent.getX(activePointerIndex);
                        final float y = srcEvent.getY(activePointerIndex);
                        if (!src.pointInView(x, y, mScaledTouchSlop)) {
                            // The pointer has moved outside of the view.
                            if (mDisallowIntercept != null) {
                                src.removeCallbacks(mDisallowIntercept);
                            }
                            src.getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    if (mDisallowIntercept != null) {
                        src.removeCallbacks(mDisallowIntercept);
                    }
                    break;
            }

            return false;
        }

        /**
         * Handled forwarded motion events and determines when to stop
         * forwarding.
         *
         * @param srcEvent motion event in source view coordinates
         * @return true to continue forwarding motion events, false to cancel
         */
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
        private boolean onTouchForwarded(MotionEvent srcEvent) {
            final View src = mSrc;
            final ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return false;
            }

            final DropDownListView dst = popup.mDropDownList;
            if (dst == null || !dst.isShown()) {
                return false;
            }

            /*
            // Convert event to destination-local coordinates.
            final MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
            src.toGlobalMotionEvent(dstEvent);
            dst.toLocalMotionEvent(dstEvent);

            // Forward converted event to destination view, then recycle it.
            final boolean handled = dst.onForwardedEvent(dstEvent, mActivePointerId);
            dstEvent.recycle();
            return handled;
            */
            addTaint(srcEvent.getTaint());
            return getTaintBoolean();
        }

        private class DisallowIntercept implements Runnable {
            @DSSpec(DSCat.THREADING)
            @Override
            public void run() {
                final ViewParent parent = mSrc.getParent();
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }
    
    private class PopupTouchInterceptor implements OnTouchListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.726 -0400", hash_original_method = "EC3EA52176E4094388A66835C5736568", hash_generated_method = "EC3EA52176E4094388A66835C5736568")
        public PopupTouchInterceptor ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.176 -0500", hash_original_method = "6DB51D562B35DA9065539F31B98AD12D", hash_generated_method = "07FE7217A9FF3612E69859A75A5A6814")
        
public boolean onTouch(View v, MotionEvent event) {
            final int action = event.getAction();
            final int x = (int) event.getX();
            final int y = (int) event.getY();
            
            if (action == MotionEvent.ACTION_DOWN &&
                    mPopup != null && mPopup.isShowing() &&
                    (x >= 0 && x < mPopup.getWidth() && y >= 0 && y < mPopup.getHeight())) {
                mHandler.postDelayed(mResizePopupRunnable, EXPAND_LIST_TIMEOUT);
            } else if (action == MotionEvent.ACTION_UP) {
                mHandler.removeCallbacks(mResizePopupRunnable);
            }
            return false;
        }
        
    }
    
    private class PopupScrollListener implements ListView.OnScrollListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.727 -0400", hash_original_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7", hash_generated_method = "F5F35EF888BB5CF4AB79CAB2F875B0A7")
        public PopupScrollListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.181 -0500", hash_original_method = "6B5691236DBDB14CA060F218338C51C6", hash_generated_method = "D742074EAAE849F36F748D2264C0E286")
        
public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                int totalItemCount) {

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.183 -0500", hash_original_method = "50D93865D772C2EF3B15BE53BF421FFA", hash_generated_method = "350F65FA0861D884A92684E69D7810E9")
        
public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == SCROLL_STATE_TOUCH_SCROLL &&
                    !isInputMethodNotNeeded() && mPopup.getContentView() != null) {
                mHandler.removeCallbacks(mResizePopupRunnable);
                mResizePopupRunnable.run();
            }
        }
        
    }

    /**
     * @return The currently selected item or null if the popup is not showing.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.098 -0500", hash_original_method = "E481FD4B78A135BB1B6DC4E83167B196", hash_generated_method = "6A17B03FB9691569A1AE097B83BBAA4F")
    
public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedItem();
    }

    /**
     * @return The position of the currently selected item or {@link ListView#INVALID_POSITION}
     * if {@link #isShowing()} == {@code false}.
     * 
     * @see ListView#getSelectedItemPosition()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.101 -0500", hash_original_method = "055DCA84E8C7B3F34F7D7819C2CD5AC3", hash_generated_method = "8A3175CA69A3FA68DA6E161E8C3CEDF4")
    
public int getSelectedItemPosition() {
        if (!isShowing()) {
            return ListView.INVALID_POSITION;
        }
        return mDropDownList.getSelectedItemPosition();
    }

    /**
     * @return The ID of the currently selected item or {@link ListView#INVALID_ROW_ID}
     * if {@link #isShowing()} == {@code false}.
     * 
     * @see ListView#getSelectedItemId()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.103 -0500", hash_original_method = "4492784EC84C61BD8D41E43112FEBCD0", hash_generated_method = "D3EEC71A6116CC51874E3E01EAFBD952")
    
public long getSelectedItemId() {
        if (!isShowing()) {
            return ListView.INVALID_ROW_ID;
        }
        return mDropDownList.getSelectedItemId();
    }

    /**
     * @return The View for the currently selected item or null if
     * {@link #isShowing()} == {@code false}.
     * 
     * @see ListView#getSelectedView()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.105 -0500", hash_original_method = "A94FEEC1ECDAC3555C21CB10FFC68C47", hash_generated_method = "892A145AB2B636C1047E11E5595197C0")
    
public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return mDropDownList.getSelectedView();
    }

    /**
     * @return The {@link ListView} displayed within the popup window.
     * Only valid when {@link #isShowing()} == {@code true}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.107 -0500", hash_original_method = "D21142DAF85C899FDAA3783E4BBEC12E", hash_generated_method = "7312C25846E6B9BBA3DB1F353BAB6BF7")
    
public ListView getListView() {
        return mDropDownList;
    }

    /**
     * The maximum number of list items that can be visible and still have
     * the list expand when touched.
     *
     * @param max Max number of items that can be visible and still allow the list to expand.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.109 -0500", hash_original_method = "21262ED785FC4787FB1F1DE7107BCA92", hash_generated_method = "21262ED785FC4787FB1F1DE7107BCA92")
    
void setListItemExpandMax(int max) {
        mListItemExpandMaximum = max;
    }

    /**
     * Filter key down events. By forwarding key down events to this function,
     * views using non-modal ListPopupWindow can have it handle key selection of items.
     *  
     * @param keyCode keyCode param passed to the host view's onKeyDown
     * @param event event param passed to the host view's onKeyDown
     * @return true if the event was handled, false if it was ignored.
     * 
     * @see #setModal(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.112 -0500", hash_original_method = "D4938DA23F7CC8247819641EDCB20246", hash_generated_method = "E26895403B9726AC0E4194C8C214B026")
    
public boolean onKeyDown(int keyCode, KeyEvent event) {
        // when the drop down is shown, we drive it directly
        if (isShowing()) {
            // the key events are forwarded to the list in the drop down view
            // note that ListView handles space but we don't want that to happen
            // also if selection is not currently in the drop down, then don't
            // let center or enter presses go there since that would cause it
            // to select one of its items
            if (keyCode != KeyEvent.KEYCODE_SPACE
                    && (mDropDownList.getSelectedItemPosition() >= 0
                            || (keyCode != KeyEvent.KEYCODE_ENTER
                                    && keyCode != KeyEvent.KEYCODE_DPAD_CENTER))) {
                int curIndex = mDropDownList.getSelectedItemPosition();
                boolean consumed;

                final boolean below = !mPopup.isAboveAnchor();

                final ListAdapter adapter = mAdapter;
                
                boolean allEnabled;
                int firstItem = Integer.MAX_VALUE;
                int lastItem = Integer.MIN_VALUE;

                if (adapter != null) {
                    allEnabled = adapter.areAllItemsEnabled();
                    firstItem = allEnabled ? 0 :
                            mDropDownList.lookForSelectablePosition(0, true);
                    lastItem = allEnabled ? adapter.getCount() - 1 :
                            mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);                    
                }
                
                if ((below && keyCode == KeyEvent.KEYCODE_DPAD_UP && curIndex <= firstItem) ||
                        (!below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && curIndex >= lastItem)) {
                    // When the selection is at the top, we block the key
                    // event to prevent focus from moving.
                    clearListSelection();
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
                    show();
                    return true;
                } else {
                    // WARNING: Please read the comment where mListSelectionHidden
                    //          is declared
                    mDropDownList.mListSelectionHidden = false;
                }

                consumed = mDropDownList.onKeyDown(keyCode, event);
                if (DEBUG) Log.v(TAG, "Key down: code=" + keyCode + " list consumed=" + consumed);

                if (consumed) {
                    // If it handled the key event, then the user is
                    // navigating in the list, so we should put it in front.
                    mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
                    // Here's a little trick we need to do to make sure that
                    // the list view is actually showing its focus indicator,
                    // by ensuring it has focus and getting its window out
                    // of touch mode.
                    mDropDownList.requestFocusFromTouch();
                    show();

                    switch (keyCode) {
                        // avoid passing the focus from the text view to the
                        // next component
                        case KeyEvent.KEYCODE_ENTER:
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_DPAD_DOWN:
                        case KeyEvent.KEYCODE_DPAD_UP:
                            return true;
                    }
                } else {
                    if (below && keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                        // when the selection is at the bottom, we block the
                        // event to avoid going to the next focusable widget
                        if (curIndex == lastItem) {
                            return true;
                        }
                    } else if (!below && keyCode == KeyEvent.KEYCODE_DPAD_UP &&
                            curIndex == firstItem) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Filter key down events. By forwarding key up events to this function,
     * views using non-modal ListPopupWindow can have it handle key selection of items.
     *  
     * @param keyCode keyCode param passed to the host view's onKeyUp
     * @param event event param passed to the host view's onKeyUp
     * @return true if the event was handled, false if it was ignored.
     * 
     * @see #setModal(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.115 -0500", hash_original_method = "CD01E8977B386E95EB43DA8A15EDF875", hash_generated_method = "38CE1FE25476BBCB139B3C9A4E2BE658")
    
public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (isShowing() && mDropDownList.getSelectedItemPosition() >= 0) {
            boolean consumed = mDropDownList.onKeyUp(keyCode, event);
            if (consumed) {
                switch (keyCode) {
                    // if the list accepts the key events and the key event
                    // was a click, the text view gets the selected item
                    // from the drop down as its content
                    case KeyEvent.KEYCODE_ENTER:
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                        dismiss();
                        break;
                }
            }
            return consumed;
        }
        return false;
    }

    /**
     * Filter pre-IME key events. By forwarding {@link View#onKeyPreIme(int, KeyEvent)}
     * events to this function, views using ListPopupWindow can have it dismiss the popup
     * when the back key is pressed.
     *  
     * @param keyCode keyCode param passed to the host view's onKeyPreIme
     * @param event event param passed to the host view's onKeyPreIme
     * @return true if the event was handled, false if it was ignored.
     * 
     * @see #setModal(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.117 -0500", hash_original_method = "5D81C652E72C1CAFD12E9CC95CD171E7", hash_generated_method = "92218C43C173710D3667B50B89726F62")
    
public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isShowing()) {
            // special case for the back key, we do not even try to send it
            // to the drop down list but instead, consume it immediately
            final View anchorView = mDropDownAnchorView;
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                if (state != null) {
                    state.startTracking(event, this);
                }
                return true;
            } else if (event.getAction() == KeyEvent.ACTION_UP) {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                if (state != null) {
                    state.handleUpEvent(event);
                }
                if (event.isTracking() && !event.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:01.724 -0400", hash_original_method = "F5C740553BB47CFEBEC052FD2A1DEFBA", hash_generated_method = "F19212F524157543401757E3253BD08A")
    private int buildDropDown() {
        ViewGroup dropDownView;
        int otherHeights = 0;
        if(mDropDownList == null)        
        {
            Context context = mContext;
            mShowDropDownRunnable = new Runnable() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.121 -0500", hash_original_method = "CEA8CEF9AA7B34E441550DF384140083", hash_generated_method = "EED7FFBA9AD29D9AA69601D426B89EA5")
                
public void run() {
                    // View layout should be all done before displaying the drop down.
                    View view = getAnchorView();
                    if (view != null && view.getWindowToken() != null) {
                        show();
                    }
                }
};
            mDropDownList = new DropDownListView(context, !mModal);
            if(mDropDownListHighlight != null)            
            {
                mDropDownList.setSelector(mDropDownListHighlight);
            } //End block
            mDropDownList.setAdapter(mAdapter);
            mDropDownList.setOnItemClickListener(mItemClickListener);
            mDropDownList.setFocusable(true);
            mDropDownList.setFocusableInTouchMode(true);
            mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.124 -0500", hash_original_method = "A3D9BDCD43F35F92A348E2938D25FA58", hash_generated_method = "9DBF480F8DAD4B30F9F09FED0CFA2CA0")
                
public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {

                    if (position != -1) {
                        DropDownListView dropDownList = mDropDownList;

                        if (dropDownList != null) {
                            dropDownList.mListSelectionHidden = false;
                        }
                    }
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:10.127 -0500", hash_original_method = "ABAE53FB2582432DFD925A1EB74EEC53", hash_generated_method = "6E7AEBAFC80C8D60C49939A085C5BFAF")
                
public void onNothingSelected(AdapterView<?> parent) {
                }
});
            mDropDownList.setOnScrollListener(mScrollListener);
            if(mItemSelectedListener != null)            
            {
                mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
            } //End block
            dropDownView = mDropDownList;
            View hintView = mPromptView;
            if(hintView != null)            
            {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f
                );
switch(mPromptPosition){
                case POSITION_PROMPT_BELOW:
                hintContainer.addView(dropDownView, hintParams);
                hintContainer.addView(hintView);
                break;
                case POSITION_PROMPT_ABOVE:
                hintContainer.addView(hintView);
                hintContainer.addView(dropDownView, hintParams);
                break;
                default:
                break;
}                int widthSpec = MeasureSpec.makeMeasureSpec(mDropDownWidth, MeasureSpec.AT_MOST);
                int heightSpec = MeasureSpec.UNSPECIFIED;
                hintView.measure(widthSpec, heightSpec);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = hintView.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
                dropDownView = hintContainer;
            } //End block
            mPopup.setContentView(dropDownView);
        } //End block
        else
        {
            dropDownView = (ViewGroup) mPopup.getContentView();
            final View view = mPromptView;
            if(view != null)            
            {
                LinearLayout.LayoutParams hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams.topMargin
                        + hintParams.bottomMargin;
            } //End block
        } //End block
        int padding = 0;
        Drawable background = mPopup.getBackground();
        if(background != null)        
        {
            background.getPadding(mTempRect);
            padding = mTempRect.top + mTempRect.bottom;
            if(!mDropDownVerticalOffsetSet)            
            {
                mDropDownVerticalOffset = -mTempRect.top;
            } //End block
        } //End block
        boolean ignoreBottomDecorations = mPopup.getInputMethodMode() == PopupWindow.INPUT_METHOD_NOT_NEEDED;
        final int maxHeight = mPopup.getMaxAvailableHeight(
                getAnchorView(), mDropDownVerticalOffset, ignoreBottomDecorations);
        if(mDropDownAlwaysVisible || mDropDownHeight == ViewGroup.LayoutParams.MATCH_PARENT)        
        {
            int var16E8D192DC05F014B65DD9ACA2DA23F9_2013416399 = (maxHeight + padding);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334029433 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334029433;
        } //End block
        final int listContent = mDropDownList.measureHeightOfChildren(MeasureSpec.UNSPECIFIED,
                0, ListView.NO_POSITION, maxHeight - otherHeights, -1);
        if(listContent > 0)        
        otherHeights += padding;
        int var62740D805AEE83AFF5A185B2395270D8_345022994 = (listContent + otherHeights);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979601008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979601008;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    /**
     * Returns an {@link OnTouchListener} that can be added to the source view
     * to implement drag-to-open behavior. Generally, the source view should be
     * the same view that was passed to {@link #setAnchorView}.
     * <p>
     * When the listener is set on a view, touching that view and dragging
     * outside of its bounds will open the popup window. Lifting will select the
     * currently touched list item.
     * <p>
     * Example usage:
     * <pre>
     * ListPopupWindow myPopup = new ListPopupWindow(context);
     * myPopup.setAnchor(myAnchor);
     * OnTouchListener dragListener = myPopup.createDragToOpenListener(myAnchor);
     * myAnchor.setOnTouchListener(dragListener);
     * </pre>
     *
     * @param src the view on which the resulting listener will be set
     * @return a touch listener that controls drag-to-open behavior
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public OnTouchListener createDragToOpenListener(View src) {
        return new ForwardingListener(src) {
            @Override
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }
}

